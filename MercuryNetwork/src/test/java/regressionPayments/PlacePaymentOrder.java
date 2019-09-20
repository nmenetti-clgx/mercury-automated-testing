package regressionPayments;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.openqa.selenium.By;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjects.InternalTools.ITPaymentsConsole;
import pageObjects.Secure.SConfirmOrder;
import pageObjects.Secure.SOrderDetails;
import pageObjects.Secure.SPaymentDetails;
import pageObjects.Secure.SPayments;
import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Payments - Place Payment Orders</h1>
 * This class contains several different scenarios to test the Payment process
 * <p>
 * If the test is ran in a QA environment, the Vendor Payment Processor will be ran as part of the test.
 *
 * @author  Dustin Norman
 * @since   05-10-2018
 */

@Listeners(utils.Listener.class)
@Test(singleThreaded=true, groups={"Payments", "broken"}, enabled=false)
public class PlacePaymentOrder extends TestSetup {

	/** Set whether or not to run the Vendor Payment Processor */
	private static boolean runVPP = false;
	
	/**
	 * Go through the process of placing a standard payments order and verify the data in the Payments grid is correct throughout the process
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set default settings for the Secure user</li>
	 * 	<li>Create an order from VMP Client Portal using Deferred CC as the payment method</li>
	 * 	<li>Verify there is an entry in Mercury.dbo.MercuryOrderInformation with a VendorPaymentResponsibility of 2</li>
	 * 	<li>Assign the order from Secure</li>
	 * 	<li>Go to the Payments screen in Secure and verify the data in the Payments grid on all of the tabs</li>
	 * 	<li>Make a payment using the payment link from the XSite</li>
	 * 	<li>Go back to the Payments screen in Secure and verify the data in the Payments grid on all of the tabs</li>
	 * 	<li>Accept and complete the order as the Vendor</li>
	 * 	<li>Verify there is a row in the Mercury.dbo.VendorPaymentQueue table and data is correct</li>
	 * 	<li>Go back to the Payments screen in Secure and verify the data in the Payments grid on all of the tabs</li>
	 * 	<li>Run the Vendor Payment Processor if on a QA environment</li>
	 * 	<li>Go to the Payments screen in Secure and verify the data in the Payments grid on all of the tabs</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Payments"}, alwaysRun=true)
	public void placeNewPaymentOrder() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		String password = StoredVariables.getpassword().get();
		
		String env = StoredVariables.getusernameEnvironment().get();

		// Set user variables
		String secureUser = "Payments1";
		String vmpUser = "OriginatorPayments1";
		String vendorsUser = "PaymentsAppraiser1";
		
		// Get a random Order Fee
		String getOrderFee = Integer.toString(perform.randomNumberBetween2Numbers(driver, 600, 999));
		String setOrderFee = "$" + getOrderFee + ".00";
		System.out.println("Order Fee: " + setOrderFee);
		
		// Set default settings
		secure.setDefaultSettingsForPaymentsTests(driver, secureUser, password);
		
		// Login to VMP Client Portal
		vmp.login(driver, "https://"+env+"autotestpayments1."+StoredVariables.getvmpSiteSuffix().get()+"", vmpUser, password);
		
		// Set variables for a new VMP Order
		vmp.setVariables(driver);
		
		// Create a new order using deferred CC
		vmp.createNewOrderUsingDeferredCC(driver, setOrderFee);

		// Get order numbers
		db.getLoanIDsFromVMPClientPortalOrder(driver);
		String orderNumber = StoredVariables.getloanID().get();
		String orderNumberVMP = StoredVariables.getloanIDVMP().get();
		
		// Get the ProductItemID
		String productItemID = db.getProductItemID(driver, orderNumber);
		
		// Calculate the Tech Fee
		String calculateTechFeeSQL = "SELECT ServiceFeeFlat + ServiceFeePercent FROM [Mercury].[dbo].[MercuryOrderInformation] WHERE ProductItemID = '"+productItemID+"'";
		String getTechFee = db.queryDB(driver, "Mercury", calculateTechFeeSQL);
		String setTechFee = "$" + getTechFee;
		System.out.println("Tech Fee: " + setTechFee);
		
		// Set the Combined Fee
		int orderFeeInt = Integer.parseInt(getOrderFee);
		float techFeeFloat = Float.parseFloat(getTechFee);
		DecimalFormat df = new DecimalFormat("#.00");
		String setCombined = "$" + df.format(orderFeeInt+techFeeFloat);
		System.out.println("Combined: " + setCombined + " - " + orderFeeInt + " + " + techFeeFloat);
		
		// Get the tax percentage
		String getTaxPercentageSQL = "SELECT IsNull(StateRate,0)+IsNull(CountyRate,0)+IsNull(CityRate,0)+IsNull(OtherRate,0) FROM [dbo].[TaxValues] WHERE ZipCode = '73114'";
		String getTaxPercentage = db.queryDB(driver, "Mercury", getTaxPercentageSQL);
		float taxPercent = Float.parseFloat(getTaxPercentage);
		System.out.println("Tax Percentage: " + taxPercent);
		
		// Calculate the tax
		float taxAmountBeforeRound = techFeeFloat * taxPercent;
		float taxAmount = perform.roundFloat(driver, taxAmountBeforeRound, 2);
		String taxAmountString = String.format("%.2f", taxAmount);
		System.out.println("Tax Amount: " + taxAmountString + " - " + techFeeFloat + " * " + taxPercent);
		
		// Set Combined with taxes
		String setCombinedWithTaxes = "$" + df.format(orderFeeInt+techFeeFloat+taxAmount);
		System.out.println("Combined Fee With Taxes: " + setCombinedWithTaxes + " - " + orderFeeInt + " + " + techFeeFloat + " + " + taxAmount);
		
		// Set Combined with taxes
		String setTechFeeWithTaxes = "$" + df.format(techFeeFloat+taxAmount);
		System.out.println("Tech Fee With Taxes: " + setTechFeeWithTaxes);
		
		// Add order info to Extent Report
		test.log(LogStatus.INFO, "Order Info", "Address: " + StoredVariables.getpropertyInformationAddress().get() + 
				"<br>Order Number: " + orderNumber +
				"<br>VMP Order Number: " + orderNumberVMP +
				"<br>Product Item ID: " + productItemID +
				"<br>Loan Number: " + StoredVariables.getassignmentInformationLoanNumber().get() +
				"<br>Order Fee: " + setOrderFee +
				"<br>Tech Fee: " + setTechFee +
				"<br>Combined Fee: " + setCombined +
				"<br>Tax Amount: " + taxAmount +
				"<br>Combined Fee With Taxes: " + setCombinedWithTaxes);
		
		// Set ServiceFeePercent
		double getServiceFeePercent = Integer.parseInt(getOrderFee) * 2.8/100;
		long serviceFeePercentLong = (long) getServiceFeePercent;
		String setServiceFeePercent = Long.toString(serviceFeePercentLong) + ".00";
		System.out.println("serviceFeePercent: " + setServiceFeePercent);
		
		// Verify there is an entry in Mercury.dbo.MercuryOrderInformation with a VendorPaymentResponsibility of 2
		String sqlStatement = "SELECT VendorPaymentResponsibilityID, ServiceFeeFlat, ServiceFeePercent, ServiceFeeTaxState, ServiceFeeTaxAmount FROM Mercury.dbo.MercuryOrderInformation WHERE ProductItemID = '"+productItemID+"'";
		ArrayList<String> dbResult = db.queryDBArray(driver, "Mercury", sqlStatement);
		String vendorPaymentResponsibilityID = dbResult.get(0);
		String serviceFlatFee = dbResult.get(1);
		String serviceFeePercent = dbResult.get(2);
		String serviceFeeTaxState = dbResult.get(3);
		String serviceFeeTaxAmount = dbResult.get(4);
		Assert.assertTrue(vendorPaymentResponsibilityID.equals("2"), "The VendorPaymentResponsibilityID should be 2, but it is " + vendorPaymentResponsibilityID);
		Assert.assertTrue(serviceFlatFee.equals("25.00"), "The ServiceFlatFee should be 25.00, but it is " + serviceFlatFee);
		Assert.assertTrue(serviceFeePercent.equals(setServiceFeePercent), "The ServiceFeePercent should be "+setServiceFeePercent+", but it is " + serviceFeePercent);
		Assert.assertTrue(serviceFeeTaxState.equals("OK"), "The ServiceFeeTaxState should be OK, but it is " + serviceFeeTaxState);
		Assert.assertTrue(serviceFeeTaxAmount.equals(taxAmountString), "The ServiceFeeTaxAmount should be "+taxAmountString.substring(0, 4)+", but it is " + serviceFeeTaxAmount);
		
		// Login to Secure
		secure.login(driver, secureUser, password);
		
		// Find and open the order
		secure.findAndOpenOrder(driver, orderNumber);
		
		// Assign the order from Secure
		secure.assignVendor(driver, vendorsUser);
		
		// Confirm order details
		secure.confirmOrderDetails(driver, "");
		
		// Wait for history
		perform.waitForElementToBeClickable(driver, SOrderDetails.history_txt(), "id");
		
		// Go to Payments
		secure.goToPayments(driver);
		
		// Search for payment
		String loanNumber = StoredVariables.getassignmentInformationLoanNumber().get();
		secure.searchForPaymentsInOrderSummaryByLoanNumber(driver, loanNumber);
		
		// Verify Order Summary payment details
		String ordered = StoredVariables.gettodaysDateLong().get();
		String propertyAddress = StoredVariables.getpropertyInformationAddress().get();
		String borrower = StoredVariables.getcontactBorrower().get()+"-"+StoredVariables.getborrowerIdentifier().get();
		String receivable = setCombinedWithTaxes;
		String received = "$0.00";
		String receivableDue = setCombinedWithTaxes;
		String payable = setCombinedWithTaxes;
		String payableDue = setCombinedWithTaxes;
		String issueDate = "";
		String toVendor = "$0.00";
		String techFee = "$0.00";
		String balance = "$0.00";
		secure.verifyOrderSummaryPaymentDetailsInPayments(driver, ordered, loanNumber, propertyAddress, borrower, secureUser, vendorsUser, receivable, received, receivableDue, payable, payableDue, issueDate, toVendor, techFee, balance);
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Click Invoices tab
		perform.click(driver, SPayments.invoices_btn(driver));
		
		// Wait for Loan Number
		perform.waitForElementToBeClickable(driver, SPayments.loanNumberInvoices_txtbx(), "id");
		
		// Search for payment
		secure.searchForPaymentsInInvoicesByLoanNumber(driver, loanNumber);
		
		// Verify Invoices payment details
		String invoiceDate = StoredVariables.gettodaysDateLong().get();
		String company = "Automation"+StoredVariables.getusernameEnvironment().get()+vmpUser;
		String invoiceDue = "";
		String type = "Receivable";
		String amount = setCombinedWithTaxes;
		received = "$0.00";
		String paid = "";
		String amountDue = setCombinedWithTaxes;
		secure.verifyInvoicesPaymentDetailsInPayments(driver, invoiceDate, loanNumber, propertyAddress, vmpUser, company, orderNumberVMP, invoiceDue, type, amount, received, paid, amountDue, SPayments.gridInvoices_txt());
		
		// Click Transactions button
		perform.click(driver, SPayments.transactions_btn(driver));
		
		// Wait for text on the page
		perform.waitForElementToBeClickable(driver, SPayments.transactionPage_txt(), "id");
		
		// Search for the Loan Number in the Transactions tab
		secure.searchForPaymentsInTransactionsByLoanNumber(driver, loanNumber);
		
		// Verify the data on the screen
		perform.verification(driver, SPayments.gridTransactions_txt(driver).getText(), "!contains", loanNumber);
		
		// Make a payment using the payment link on the XSite order
		secure.makePaymentFromXSiteUsingPaymentLink(driver, orderNumber, setOrderFee, setTechFeeWithTaxes, setCombinedWithTaxes, "Automation", "Test", "4111111111111111", "November", "2026", "73099", "automation@dntest.net");
		
		// Go to Payments
		secure.goToPayments(driver);
		
		// Search for payment
		secure.searchForPaymentsInOrderSummaryByLoanNumber(driver, loanNumber);
		
		// Verify Order Summary payment details
		received = setCombinedWithTaxes;
		receivableDue = "$0.00";
		balance = setCombinedWithTaxes;
		secure.verifyOrderSummaryPaymentDetailsInPayments(driver, ordered, loanNumber, propertyAddress, borrower, secureUser, vendorsUser, receivable, received, receivableDue, payable, payableDue, issueDate, toVendor, techFee, balance);
		
		// Click Invoices tab
		perform.click(driver, SPayments.invoices_btn(driver));
		
		// Wait for Loan Number
		perform.waitForElementToBeClickable(driver, SPayments.loanNumberInvoices_txtbx(), "id");
		
		// Search for payment
		secure.searchForPaymentsInInvoicesByLoanNumber(driver, loanNumber);
		
		// Verify Invoices payment details
		amountDue = "$0.00";
		secure.verifyInvoicesPaymentDetailsInPayments(driver, invoiceDate, loanNumber, propertyAddress, vmpUser, company, orderNumberVMP, invoiceDue, type, amount, received, paid, amountDue, SPayments.gridInvoices_txt());
		
		// Click Transactions button
		perform.click(driver, SPayments.transactions_btn(driver));
		
		// Wait for text on the page
		perform.waitForElementToBeClickable(driver, SPayments.transactionPage_txt(), "id");
		
		// Search for the Loan Number in the Transactions tab
		secure.searchForPaymentsInTransactionsByLoanNumber(driver, loanNumber);
		
		// Verify the data on the screen
		String date = StoredVariables.gettodaysDateLong().get();
		String nameOnAccount = "Automation Test";
		String addressOnAccount = "Not provided";
		String accountNumber = "xxxxx1111";
		sqlStatement = "SELECT TransactionID FROM Merchants.dbo.Transactions WHERE ProductItemID = (SELECT ProductItemID FROM Mercury.dbo.ProductItems WHERE LoanID = "+orderNumberVMP+")";
		String transID = db.queryDB(driver, "Merchants", sqlStatement);
		type = "Charge";
		String status = "Charged";
		amount = setCombinedWithTaxes;
		String actions = "View";
		
		secure.verifyTransactionsPaymentDetailsInPayments(driver, date, loanNumber, propertyAddress, nameOnAccount, addressOnAccount, accountNumber, transID, type, status, amount, actions);
		
		// Login to Vendors
		vendors.login(driver, vendorsUser, password);
		
		// Accept and deliver the order
		vendors.acceptOrder(driver, orderNumber);
		vendors.completeOrderByHTTPPost(driver, vendorsUser, password, orderNumber, "Complete.xml");
		
		// Set date format
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 0);
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		String today = format1.format(cal.getTime());
		
		// Verify there is now a row in the Mercury.dbo.VendorPaymentQueue table and data is correct
		// Set SQL statement
		sqlStatement = "SELECT * FROM Mercury.dbo.VendorPaymentQueue "
				+ "WHERE LoanID = '"+orderNumber+"'";
		
		// Query the DB and build an array out of the results
		ArrayList<String> vendorPaymentQueue = db.queryDBArray(driver, "Mercury", sqlStatement);
		String loanID = vendorPaymentQueue.get(1);
		String enteredStamp = vendorPaymentQueue.get(2);
		String paymentDate = vendorPaymentQueue.get(3);
		
		// Verify the values are correct
		perform.verification(driver, loanID, "equals", orderNumber);
		perform.verification(driver, enteredStamp, "contains", today);
		perform.verification(driver, paymentDate, "contains", today);
		
		// Login to Secure
		secure.login(driver, secureUser, password);
		
		// Go to Payments
		secure.goToPayments(driver);
		
		// Search for payment
		secure.searchForPaymentsInOrderSummaryByLoanNumber(driver, loanNumber);
		
		// Verify Order Summary payment details
		issueDate = StoredVariables.gettodaysDateLong().get();
		secure.verifyOrderSummaryPaymentDetailsInPayments(driver, ordered, loanNumber, propertyAddress, borrower, secureUser, vendorsUser, receivable, received, receivableDue, payable, payableDue, issueDate, toVendor, techFee, balance);
		
		// Click Invoices tab
		perform.click(driver, SPayments.invoices_btn(driver));
		
		// Wait for Loan Number
		perform.waitForElementToBeClickable(driver, SPayments.loanNumberInvoices_txtbx(), "id");
		
		// Search for payment
		secure.searchForPaymentsInInvoicesByLoanNumber(driver, loanNumber);
		
		// Verify Invoices payment details
		type = "Receivable";
		secure.verifyInvoicesPaymentDetailsInPayments(driver, invoiceDate, loanNumber, propertyAddress, vmpUser, company, orderNumberVMP, invoiceDue, type, amount, received, paid, amountDue, SPayments.gridInvoices_txt());
		
		// Click Transactions button
		perform.click(driver, SPayments.transactions_btn(driver));
		
		// Wait for text on the page
		perform.waitForElementToBeClickable(driver, SPayments.transactionPage_txt(), "id");
		
		// Search for the Loan Number in the Transactions tab
		secure.searchForPaymentsInTransactionsByLoanNumber(driver, loanNumber);
		
		// Verify the data on the screen
		type = "Charge";
		secure.verifyTransactionsPaymentDetailsInPayments(driver, date, loanNumber, propertyAddress, nameOnAccount, addressOnAccount, accountNumber, transID, type, status, amount, actions);
		
		// Run the Vendor Payment Processor on QA
		if (env.equals("QA") && runVPP==true) {
			Thread.sleep(15000);
			Runtime.getRuntime().exec(StoredVariables.getuserDir().get() + "\\src\\main\\resources\\ExecuteVendorPaymentProcessor.bat");
		
			// Wait for the Vendor Payment processor to run
			Thread.sleep(30000);
			
			// Verify vendor receives payment
			// Login to Secure
			secure.login(driver, secureUser, password);
			
			// Go to Payments
			secure.goToPayments(driver);
			
			// Search for payment
			secure.searchForPaymentsInOrderSummaryByLoanNumber(driver, loanNumber);
			
			// Wait for payable due to be $0.00
			waitForPayableDueToUpdate(driver, loanNumber, "$0.00");
			
			// Verify Order Summary payment details
			issueDate = StoredVariables.gettodaysDateLong().get();
			payableDue = "$0.00";
			toVendor = setOrderFee;
			techFee = setTechFee;
			balance = "$0.00";
			secure.verifyOrderSummaryPaymentDetailsInPayments(driver, ordered, loanNumber, propertyAddress, borrower, secureUser, vendorsUser, receivable, received, receivableDue, payable, payableDue, issueDate, toVendor, techFee, balance);
			
			// Click Invoices tab
			perform.click(driver, SPayments.invoices_btn(driver));
			
			// Wait for Loan Number
			perform.waitForElementToBeClickable(driver, SPayments.loanNumberInvoices_txtbx(), "id");
			
			// Search for payment
			secure.searchForPaymentsInInvoicesByLoanNumber(driver, loanNumber);
			
			// Verify Invoices payment details
			type = "Receivable";
			secure.verifyInvoicesPaymentDetailsInPayments(driver, invoiceDate, loanNumber, propertyAddress, vmpUser, company, orderNumberVMP, invoiceDue, type, amount, received, paid, amountDue, SPayments.gridInvoices_txt());
			
			// Click Transactions button
			perform.click(driver, SPayments.transactions_btn(driver));
			
			// Wait for text on the page
			perform.waitForElementToBeClickable(driver, SPayments.transactionPage_txt(), "id");
			
			// Search for the Loan Number in the Transactions tab
			secure.searchForPaymentsInTransactionsByLoanNumber(driver, loanNumber);
			
			// Verify the data on the screen
			type = "Charge";
			secure.verifyTransactionsPaymentDetailsInPayments(driver, date, loanNumber, propertyAddress, nameOnAccount, addressOnAccount, accountNumber, transID, type, status, amount, actions);
			
			System.out.println("Order Number = " + orderNumber);
			System.out.println("Order Number VMP = " + orderNumberVMP);
		
		} // end if QA, run vendor payment processor
		
		// Log test
		test.log(LogStatus.INFO, "Payment Methods", "Verified you can place a payment order");
		
	} // end placeNewPaymentOrder
	
	/**
	 * Go through the process of placing a standard payments order and verify the data in the Payments grid is correct throughout the process
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set default settings for the Secure user</li>
	 * 	<li>Create an order from VMP Client Portal using Deferred CC as the payment method</li>
	 * 	<li>Verify there is an entry in Mercury.dbo.MercuryOrderInformation with a VendorPaymentResponsibility of 2</li>
	 * 	<li>Assign the order from Secure</li>
	 * 	<li>Go to the Payments screen in Secure and verify the data in the Payments grid on all of the tabs</li>
	 * 	<li>Make a payment using the payment link from the XSite</li>
	 * 	<li>Go back to the Payments screen in Secure and verify the data in the Payments grid on all of the tabs</li>
	 * 	<li>Accept and complete the order as the Vendor</li>
	 * 	<li>Verify there is a row in the Mercury.dbo.VendorPaymentQueue table and data is correct</li>
	 * 	<li>Verify data in CompanyData.dbo.MercuryOrderReceivables</li>
	 * 	<li>Go back to the Payments screen in Secure and verify the data in the Payments grid on all of the tabs</li>
	 * 	<li>Run the Vendor Payment Processor if on a QA environment</li>
	 * 	<li>Go to the Payments screen in Secure and verify the data in the Payments grid on all of the tabs</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Payments"}, alwaysRun=true)
	public void perfectWorld() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		String password = StoredVariables.getpassword().get();
		
		String env = StoredVariables.getusernameEnvironment().get();

		// Set user variables
		String secureUser = "Payments2";
		String vmpUser = "OriginatorPayments2";
		String vendorsUser = "PaymentsAppraiser1";
		
		// Get a random Order Fee
		String getOrderFee = Integer.toString(perform.randomNumberBetween2Numbers(driver, 600, 999));
		String setOrderFee = "$" + getOrderFee + ".00";
		System.out.println("Order Fee: " + setOrderFee);
		
		// Set default settings
		secure.setDefaultSettingsForPaymentsTests(driver, secureUser, password);
		
		// Login to VMP Client Portal
		vmp.login(driver, "https://"+env+"autotestpayments2."+StoredVariables.getvmpSiteSuffix().get()+"", vmpUser, password);
		
		// Set variables for a new VMP Order
		vmp.setVariables(driver);
		
		// Create a new order using deferred CC
		vmp.createNewOrderUsingDeferredCC(driver, setOrderFee);

		// Get order numbers
		db.getLoanIDsFromVMPClientPortalOrder(driver);
		String orderNumber = StoredVariables.getloanID().get();
		String orderNumberVMP = StoredVariables.getloanIDVMP().get();
		
		// Get the ProductItemID
		String productItemID = db.getProductItemID(driver, orderNumber);
		
		// Calculate the Tech Fee
		String calculateTechFeeSQL = "SELECT ServiceFeeFlat + ServiceFeePercent FROM [Mercury].[dbo].[MercuryOrderInformation] WHERE ProductItemID = '"+productItemID+"'";
		String getTechFee = db.queryDB(driver, "Mercury", calculateTechFeeSQL);
		String setTechFee = "$" + getTechFee;
		System.out.println("Tech Fee: " + setTechFee);
		
		// Set the Combined Fee
		int orderFeeInt = Integer.parseInt(getOrderFee);
		float techFeeFloat = Float.parseFloat(getTechFee);
		DecimalFormat df = new DecimalFormat("#.00");
		String setCombined = "$" + df.format(orderFeeInt+techFeeFloat);
		System.out.println("Combined: " + setCombined + " - " + orderFeeInt + " + " + techFeeFloat);
		
		// Get the tax percentage
		String getTaxPercentageSQL = "SELECT IsNull(StateRate,0)+IsNull(CountyRate,0)+IsNull(CityRate,0)+IsNull(OtherRate,0) FROM [dbo].[TaxValues] WHERE ZipCode = '73114'";
		String getTaxPercentage = db.queryDB(driver, "Mercury", getTaxPercentageSQL);
		float taxPercent = Float.parseFloat(getTaxPercentage);
		System.out.println("Tax Percentage: " + taxPercent);
		
		// Calculate the tax
		float taxAmountBeforeRound = techFeeFloat * taxPercent;
		float taxAmount = perform.roundFloat(driver, taxAmountBeforeRound, 2);
		String taxAmountString = String.format("%.2f", taxAmount);
		System.out.println("Tax Amount: " + taxAmountString + " - " + techFeeFloat + " * " + taxPercent);
		
		// Set Combined with taxes
		String setCombinedWithTaxes = "$" + df.format(orderFeeInt+techFeeFloat+taxAmount);
		System.out.println("Combined Fee With Taxes: " + setCombinedWithTaxes + " - " + orderFeeInt + " + " + techFeeFloat + " + " + taxAmount);
		
		// Set Combined with taxes
		String setTechFeeWithTaxes = "$" + df.format(techFeeFloat+taxAmount);
		System.out.println("Tech Fee With Taxes: " + setTechFeeWithTaxes);
		
		// Add order info to Extent Report
		test.log(LogStatus.INFO, "Order Info", "Address: " + StoredVariables.getpropertyInformationAddress().get() + 
				"<br>Order Number: " + orderNumber +
				"<br>VMP Order Number: " + orderNumberVMP +
				"<br>Product Item ID: " + productItemID +
				"<br>Loan Number: " + StoredVariables.getassignmentInformationLoanNumber().get() +
				"<br>Order Fee: " + setOrderFee +
				"<br>Tech Fee: " + setTechFee +
				"<br>Combined Fee: " + setCombined +
				"<br>Tax Amount: " + taxAmount +
				"<br>Combined Fee With Taxes: " + setCombinedWithTaxes);
		
		// Set ServiceFeePercent
		double getServiceFeePercent = Integer.parseInt(getOrderFee) * 2.8/100;
		long serviceFeePercentLong = (long) getServiceFeePercent;
		String setServiceFeePercent = Long.toString(serviceFeePercentLong) + ".00";
		System.out.println("serviceFeePercent: " + setServiceFeePercent);
		
		// Verify there is an entry in Mercury.dbo.MercuryOrderInformation with a VendorPaymentResponsibility of 2
		String sqlStatement = "SELECT VendorPaymentResponsibilityID, ServiceFeeFlat, ServiceFeePercent, ServiceFeeTaxState, ServiceFeeTaxAmount FROM Mercury.dbo.MercuryOrderInformation WHERE ProductItemID = '"+productItemID+"'";
		ArrayList<String> dbResult = db.queryDBArray(driver, "Mercury", sqlStatement);
		String vendorPaymentResponsibilityID = dbResult.get(0);
		String serviceFlatFee = dbResult.get(1);
		String serviceFeePercent = dbResult.get(2);
		String serviceFeeTaxState = dbResult.get(3);
		String serviceFeeTaxAmount = dbResult.get(4);
		Assert.assertTrue(vendorPaymentResponsibilityID.equals("2"), "The VendorPaymentResponsibilityID should be 2, but it is " + vendorPaymentResponsibilityID);
		Assert.assertTrue(serviceFlatFee.equals("25.00"), "The ServiceFlatFee should be 25.00, but it is " + serviceFlatFee);
		Assert.assertTrue(serviceFeePercent.equals(setServiceFeePercent), "The ServiceFeePercent should be "+setServiceFeePercent+", but it is " + serviceFeePercent);
		Assert.assertTrue(serviceFeeTaxState.equals("OK"), "The ServiceFeeTaxState should be OK, but it is " + serviceFeeTaxState);
		Assert.assertTrue(serviceFeeTaxAmount.equals(taxAmountString), "The ServiceFeeTaxAmount should be "+taxAmountString.substring(0, 4)+", but it is " + serviceFeeTaxAmount);
		
		// Login to Secure
		secure.login(driver, secureUser, password);
		
		// Find and open the order
		secure.findAndOpenOrder(driver, orderNumber);
		
		// Assign the order from Secure
		secure.assignVendor(driver, vendorsUser);
		
		// Confirm order details
		secure.confirmOrderDetails(driver, "");
		
		// Wait for history
		perform.waitForElementToBeClickable(driver, SOrderDetails.history_txt(), "id");
		
		// Go to Payments
		secure.goToPayments(driver);
		
		// Search for payment
		String loanNumber = StoredVariables.getassignmentInformationLoanNumber().get();
		secure.searchForPaymentsInOrderSummaryByLoanNumber(driver, loanNumber);
		
		// Verify Order Summary payment details
		String ordered = StoredVariables.gettodaysDateLong().get();
		String propertyAddress = StoredVariables.getpropertyInformationAddress().get();
		String borrower = StoredVariables.getcontactBorrower().get()+"-"+StoredVariables.getborrowerIdentifier().get();
		String receivable = setCombinedWithTaxes;
		String received = "$0.00";
		String receivableDue = setCombinedWithTaxes;
		String payable = setCombinedWithTaxes;
		String payableDue = setCombinedWithTaxes;
		String issueDate = "";
		String toVendor = "$0.00";
		String techFee = "$0.00";
		String balance = "$0.00";
		secure.verifyOrderSummaryPaymentDetailsInPayments(driver, ordered, loanNumber, propertyAddress, borrower, secureUser, vendorsUser, receivable, received, receivableDue, payable, payableDue, issueDate, toVendor, techFee, balance);
		
		// Click Invoices tab
		perform.click(driver, SPayments.invoices_btn(driver));
		
		// Wait for Loan Number
		perform.waitForElementToBeClickable(driver, SPayments.loanNumberInvoices_txtbx(), "id");
		
		// Search for payment
		secure.searchForPaymentsInInvoicesByLoanNumber(driver, loanNumber);
		
		// Verify Invoices payment details
		String invoiceDate = StoredVariables.gettodaysDateLong().get();
		String company = "Automation"+StoredVariables.getusernameEnvironment().get()+vmpUser;
		String invoiceDue = "";
		String type = "Receivable";
		String amount = setCombinedWithTaxes;
		received = "$0.00";
		String paid = "";
		String amountDue = setCombinedWithTaxes;
		secure.verifyInvoicesPaymentDetailsInPayments(driver, invoiceDate, loanNumber, propertyAddress, vmpUser, company, orderNumberVMP, invoiceDue, type, amount, received, paid, amountDue, SPayments.gridInvoices_txt());
		
		// Click Transactions button
		perform.click(driver, SPayments.transactions_btn(driver));
		
		// Wait for text on the page
		perform.waitForElementToBeClickable(driver, SPayments.transactionPage_txt(), "id");
		
		// Search for the Loan Number in the Transactions tab
		secure.searchForPaymentsInTransactionsByLoanNumber(driver, loanNumber);
		
		// Verify the data on the screen
		perform.verification(driver, SPayments.gridTransactions_txt(driver).getText(), "!contains", loanNumber);
		
		// Make a payment using the payment link on the XSite order
		secure.makePaymentFromXSiteUsingPaymentLink(driver, orderNumber, setOrderFee, setTechFeeWithTaxes, setCombinedWithTaxes, "Automation", "Test", "5555555555554444", "November", "2026", "73099", "automation@dntest.net");
		
		// Go to Payments
		secure.goToPayments(driver);
		
		// Search for payment
		secure.searchForPaymentsInOrderSummaryByLoanNumber(driver, loanNumber);
		
		// Verify Order Summary payment details
		received = setCombinedWithTaxes;
		receivableDue = "$0.00";
		balance = setCombinedWithTaxes;
		secure.verifyOrderSummaryPaymentDetailsInPayments(driver, ordered, loanNumber, propertyAddress, borrower, secureUser, vendorsUser, receivable, received, receivableDue, payable, payableDue, issueDate, toVendor, techFee, balance);
		
		// Click Invoices tab
		perform.click(driver, SPayments.invoices_btn(driver));
		
		// Wait for Loan Number
		perform.waitForElementToBeClickable(driver, SPayments.loanNumberInvoices_txtbx(), "id");
		
		// Search for payment
		secure.searchForPaymentsInInvoicesByLoanNumber(driver, loanNumber);
		
		// Verify Invoices payment details
		amountDue = "$0.00";
		secure.verifyInvoicesPaymentDetailsInPayments(driver, invoiceDate, loanNumber, propertyAddress, vmpUser, company, orderNumberVMP, invoiceDue, type, amount, received, paid, amountDue, SPayments.gridInvoices_txt());
		
		// Click Transactions button
		perform.click(driver, SPayments.transactions_btn(driver));
		
		// Wait for text on the page
		perform.waitForElementToBeClickable(driver, SPayments.transactionPage_txt(), "id");
		
		// Search for the Loan Number in the Transactions tab
		secure.searchForPaymentsInTransactionsByLoanNumber(driver, loanNumber);
		
		// Verify the data on the screen
		String date = StoredVariables.gettodaysDateLong().get();
		String nameOnAccount = "Automation Test";
		String addressOnAccount = "Not provided";
		String accountNumber = "xxxxx4444";
		sqlStatement = "SELECT TransactionID FROM Merchants.dbo.Transactions WHERE ProductItemID = (SELECT ProductItemID FROM Mercury.dbo.ProductItems WHERE LoanID = "+orderNumberVMP+")";
		String transID = db.queryDB(driver, "Merchants", sqlStatement);
		type = "Charge";
		String status = "Charged";
		amount = setCombinedWithTaxes;
		String actions = "View";
		
		secure.verifyTransactionsPaymentDetailsInPayments(driver, date, loanNumber, propertyAddress, nameOnAccount, addressOnAccount, accountNumber, transID, type, status, amount, actions);
		
		// Login to Vendors
		vendors.login(driver, vendorsUser, password);
		
		// Accept and deliver the order
		vendors.acceptOrder(driver, orderNumber);
		vendors.completeOrderByHTTPPost(driver, vendorsUser, password, orderNumber, "Complete.xml");
		
		// Set date format
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 0);
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		String today = format1.format(cal.getTime());
		
		// Verify there is now a row in the Mercury.dbo.VendorPaymentQueue table and data is correct
		// Set SQL statement
		sqlStatement = "SELECT * FROM Mercury.dbo.VendorPaymentQueue "
				+ "WHERE LoanID = '"+orderNumber+"'";
		
		// Query the DB and build an array out of the results
		ArrayList<String> vendorPaymentQueue = db.queryDBArray(driver, "Mercury", sqlStatement);
		String loanID = vendorPaymentQueue.get(1);
		String enteredStamp = vendorPaymentQueue.get(2);
		String paymentDate = vendorPaymentQueue.get(3);
		String amountDB = vendorPaymentQueue.get(4);
		
		// Verify the values are correct
		perform.verification(driver, loanID, "equals", orderNumber);
		perform.verification(driver, enteredStamp, "contains", today);
		perform.verification(driver, paymentDate, "contains", today);
		perform.verification(driver, amountDB, "equals", "NULL");
		
		// Set SQL Statement
		sqlStatement = "SELECT ServiceFeeFlat, ServiceFeePercent FROM CompanyData.dbo.MercuryOrderReceivables WHERE LoanID = '"+orderNumber+"'";
		
		// Query the DB and build an array out of the results
		ArrayList<String> mercuryOrderReceivables = db.queryDBArray(driver, "Mercury", sqlStatement);
		
		// Get the serviceFeeFlat amount
		String serviceFeeFlat = mercuryOrderReceivables.get(0);
		
		// Verify the values are correct
		perform.verification(driver, serviceFeeFlat, "equals", "25.0000");
		perform.verification(driver, serviceFeePercent, "contains", setServiceFeePercent);
		
		// Login to Secure
		secure.login(driver, secureUser, password);
		
		// Go to Payments
		secure.goToPayments(driver);
		
		// Search for payment
		secure.searchForPaymentsInOrderSummaryByLoanNumber(driver, loanNumber);
		
		// Set the new issue date
		issueDate = StoredVariables.gettodaysDateLong().get();
		
		// Wait for payable due to be the payableDue
		waitForPayableDueToUpdate(driver, loanNumber, payableDue);

		// Verify Order Summary payment details
		secure.verifyOrderSummaryPaymentDetailsInPayments(driver, ordered, loanNumber, propertyAddress, borrower, secureUser, vendorsUser, receivable, received, receivableDue, payable, payableDue, issueDate, toVendor, techFee, balance);
		
		// Click Invoices tab
		perform.click(driver, SPayments.invoices_btn(driver));
		
		// Wait for Loan Number
		perform.waitForElementToBeClickable(driver, SPayments.loanNumberInvoices_txtbx(), "id");
		
		// Search for payment
		secure.searchForPaymentsInInvoicesByLoanNumber(driver, loanNumber);
		
		// Verify Invoices payment details
		type = "Receivable";
		secure.verifyInvoicesPaymentDetailsInPayments(driver, invoiceDate, loanNumber, propertyAddress, vmpUser, company, orderNumberVMP, invoiceDue, type, amount, received, paid, amountDue, SPayments.gridInvoices_txt());
		
		// Click Transactions button
		perform.click(driver, SPayments.transactions_btn(driver));
		
		// Wait for text on the page
		perform.waitForElementToBeClickable(driver, SPayments.transactionPage_txt(), "id");
		
		// Search for the Loan Number in the Transactions tab
		secure.searchForPaymentsInTransactionsByLoanNumber(driver, loanNumber);
		
		// Verify the data on the screen
		type = "Charge";
		secure.verifyTransactionsPaymentDetailsInPayments(driver, date, loanNumber, propertyAddress, nameOnAccount, addressOnAccount, accountNumber, transID, type, status, amount, actions);
		
		// Write data to a file
		String fileName = "Payments-PerfectWorld-"+StoredVariables.getenvironment().get()+".txt";
		String data = ordered + "," + loanNumber + "," + propertyAddress + "," + borrower + "," + secureUser + "," + vendorsUser + "," + receivable + "," + received + "," + receivableDue + "," + payable + "," + payableDue + "," + issueDate + "," + toVendor + "," + techFee + "," + balance + "," + invoiceDate + "," + vmpUser + "," + company + "," + orderNumberVMP + "," + invoiceDue + "," + type + "," + amount + "," + paid + "," + amountDue + "," + date + "," + nameOnAccount + "," + addressOnAccount + "," + accountNumber + "," + transID + "," + status + "," + actions;
		perform.writeToAFile(driver, StoredVariables.getdocDir().get(), fileName, data);
		
		// Run the Vendor Payment Processor on QA
		if (env.equals("QA") && runVPP==true) {
			
			Thread.sleep(15000);
			// Run the Vendor Payment Processor
			Runtime.getRuntime().exec(StoredVariables.getuserDir().get() + "\\src\\main\\resources\\ExecuteVendorPaymentProcessor.bat");
			
			// Wait for the Vendor Payment processor to run
			Thread.sleep(15000);
			
			// Verify vendor receives payment
			// Login to Secure
			secure.login(driver, secureUser, password);
			
			// Go to Payments
			secure.goToPayments(driver);
			
			// Search for payment
			secure.searchForPaymentsInOrderSummaryByLoanNumber(driver, loanNumber);
			
			// Wait for the table
			perform.waitForElementToBeClickable(driver, SPayments.grid_txt(), "id");
			
			// Wait for payable due to be $0.00
			waitForPayableDueToUpdate(driver, loanNumber, "$0.00");
			
			// Verify Order Summary payment details
			issueDate = StoredVariables.gettodaysDateLong().get();
			payableDue = "$0.00";
			toVendor = setOrderFee;
			techFee = setTechFeeWithTaxes;
			balance = "$0.00";
			secure.verifyOrderSummaryPaymentDetailsInPayments(driver, ordered, loanNumber, propertyAddress, borrower, secureUser, vendorsUser, receivable, received, receivableDue, payable, payableDue, issueDate, toVendor, techFee, balance);
			
			// Click Invoices tab
			perform.click(driver, SPayments.invoices_btn(driver));
			
			// Wait for Loan Number
			perform.waitForElementToBeClickable(driver, SPayments.loanNumberInvoices_txtbx(), "id");
			
			// Search for payment
			secure.searchForPaymentsInInvoicesByLoanNumber(driver, loanNumber);
			
			// Verify Invoices payment details
			type = "Receivable";
			secure.verifyInvoicesPaymentDetailsInPayments(driver, invoiceDate, loanNumber, propertyAddress, vmpUser, company, orderNumberVMP, invoiceDue, type, amount, received, paid, amountDue, SPayments.gridInvoices_txt());
			
			// Click Transactions button
			perform.click(driver, SPayments.transactions_btn(driver));
			
			// Wait for text on the page
			perform.waitForElementToBeClickable(driver, SPayments.transactionPage_txt(), "id");
			
			// Search for the Loan Number in the Transactions tab
			secure.searchForPaymentsInTransactionsByLoanNumber(driver, loanNumber);
			
			// Verify the data on the screen
			type = "Charge";
			secure.verifyTransactionsPaymentDetailsInPayments(driver, date, loanNumber, propertyAddress, nameOnAccount, addressOnAccount, accountNumber, transID, type, status, amount, actions);
			
		} // end running the Vendor Payment Processor
		
		// Log test
		test.log(LogStatus.INFO, "Payment Methods", "Verified you can place a payment order");
		
	} // end perfectWorld
	
	/**
	 * Place a payments order, make a payment from the Make A Payment page, change the fee to a higher amount, deliver the order as the Vendor and confirm there are secondary collection 
	 * items in Payment details while verifying the data in the Payments grid throughout the process
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set default settings for the Secure user</li>
	 * 	<li>Create an order from VMP Client Portal using Deferred CC as the payment method</li>
	 * 	<li>Assign the order from Secure</li>
	 * 	<li>Go to the Payments screen in Secure and verify the data in the Payments grid on all of the tabs</li>
	 * 	<li>Make a payment using the payment link from the XSite</li>
	 * 	<li>Go back to the Payments screen in Secure and verify the data in the Payments grid on all of the tabs</li>
	 * 	<li>Accept the order as the Vendor</li>
	 * 	<li>Open the order in Secure and change the fee to a higher amount</li>
	 * 	<li>Go back to the Payments screen in Secure and verify the data in the Payments grid on all of the tabs</li>
	 * 	<li>Complete the order as the Vendor</li>
	 * 	<li>Verify there is a row in the Mercury.dbo.VendorPaymentQueue table and data is correct</li>
	 * 	<li>Verify data in CompanyData.dbo.MercuryOrderReceivables</li>
	 * 	<li>Go back to the Payments screen in Secure and verify the data in the Payments grid on all of the tabs</li>
	 * 	<li>Run the Vendor Payment Processor if on a QA environment</li>
	 * 	<li>Go to the Payments screen in Secure and verify the data in the Payments grid on all of the tabs</li>
	 * 	<li>Verify there is no record in the SecondaryCollectionLiteItmes table</li>
	 * 	<li>Confirm the primary and secondary collections appear in Payment details for the order</li>
	 * 	<li>Verify that there are 2 entries in the Received column</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Payments"}, alwaysRun=true)
	public void secondaryCollection() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		String password = StoredVariables.getpassword().get();

		String env = StoredVariables.getusernameEnvironment().get();
			
		// Set user variables
		String secureUser = "Payments3";
		String vmpUser = "OriginatorPayments3";
		String vendorsUser = "PaymentsAppraiser1";
		
		// Get a random Order Fee
		String getOrderFee = Integer.toString(perform.randomNumberBetween2Numbers(driver, 600, 900));
		String setOrderFee = "$" + getOrderFee + ".00";
		System.out.println("Order Fee: " + setOrderFee);
		
		// Set default settings
		secure.setDefaultSettingsForPaymentsTests(driver, secureUser, password);
		
		// Login to VMP Client Portal
		vmp.login(driver, "https://"+env+"autotestpayments3."+StoredVariables.getvmpSiteSuffix().get()+"", vmpUser, password);
		
		// Set variables for a new VMP Order
		vmp.setVariables(driver);
		
		// Create a new order using deferred CC
		vmp.createNewOrderUsingDeferredCC(driver, setOrderFee);

		// Get order numbers
		db.getLoanIDsFromVMPClientPortalOrder(driver);
		String orderNumber = StoredVariables.getloanID().get();
		String orderNumberVMP = StoredVariables.getloanIDVMP().get();
		
		// Get the ProductItemID
		String productItemID = db.getProductItemID(driver, orderNumber);
		
		// Calculate the Tech Fee
		String calculateTechFeeSQL = "SELECT ServiceFeeFlat + ServiceFeePercent FROM [Mercury].[dbo].[MercuryOrderInformation] WHERE ProductItemID = '"+productItemID+"'";
		String getTechFee = db.queryDB(driver, "Mercury", calculateTechFeeSQL);
		String setTechFee = "$" + getTechFee;
		System.out.println("Tech Fee: " + setTechFee);
		
		// Set the Combined Fee
		int orderFeeInt = Integer.parseInt(getOrderFee);
		float techFeeFloat = Float.parseFloat(getTechFee);
		DecimalFormat df = new DecimalFormat("#.00");
		String setCombined = "$" + df.format(orderFeeInt+techFeeFloat);
		System.out.println("Combined: " + setCombined + " - " + orderFeeInt + " + " + techFeeFloat);
		
		// Get the tax percentage
		String getTaxPercentageSQL = "SELECT IsNull(StateRate,0)+IsNull(CountyRate,0)+IsNull(CityRate,0)+IsNull(OtherRate,0) FROM [dbo].[TaxValues] WHERE ZipCode = '73114'";
		String getTaxPercentage = db.queryDB(driver, "Mercury", getTaxPercentageSQL);
		float taxPercent = Float.parseFloat(getTaxPercentage);
		System.out.println("Tax Percentage: " + taxPercent);
		
		// Calculate the tax
		float taxAmountBeforeRound = techFeeFloat * taxPercent;
		float taxAmount = perform.roundFloat(driver, taxAmountBeforeRound, 2);
		String taxAmountString = String.format("%.2f", taxAmount);
		System.out.println("Tax Amount: " + taxAmountString + " - " + techFeeFloat + " * " + taxPercent);
		
		// Set Combined with taxes
		String setCombinedWithTaxes = "$" + df.format(orderFeeInt+techFeeFloat+taxAmount);
		System.out.println("Combined Fee With Taxes: " + setCombinedWithTaxes + " - " + orderFeeInt + " + " + techFeeFloat + " + " + taxAmount);
		
		// Set Combined with taxes
		String setTechFeeWithTaxes = "$" + df.format(techFeeFloat+taxAmount);
		System.out.println("Tech Fee With Taxes: " + setTechFeeWithTaxes);
		
		// Add order info to Extent Report
		test.log(LogStatus.INFO, "Order Info", "Address: " + StoredVariables.getpropertyInformationAddress().get() + 
				"<br>Order Number: " + orderNumber +
				"<br>VMP Order Number: " + orderNumberVMP +
				"<br>Product Item ID: " + productItemID +
				"<br>Loan Number: " + StoredVariables.getassignmentInformationLoanNumber().get() +
				"<br>Order Fee: " + setOrderFee +
				"<br>Tech Fee: " + setTechFee +
				"<br>Combined Fee: " + setCombined +
				"<br>Tax Amount: " + taxAmount +
				"<br>Combined Fee With Taxes: " + setCombinedWithTaxes);
		
		// Set ServiceFeePercent
		double getServiceFeePercent = Integer.parseInt(getOrderFee) * 2.8/100;
		long serviceFeePercentLong = (long) getServiceFeePercent;
		String setServiceFeePercent = Long.toString(serviceFeePercentLong) + ".00";
		System.out.println("serviceFeePercent: " + setServiceFeePercent);
		
		// Verify there is an entry in Mercury.dbo.MercuryOrderInformation with a VendorPaymentResponsibility of 2
		String sqlStatement = "SELECT VendorPaymentResponsibilityID, ServiceFeeFlat, ServiceFeePercent, ServiceFeeTaxState, ServiceFeeTaxAmount FROM Mercury.dbo.MercuryOrderInformation WHERE ProductItemID = '"+productItemID+"'";
		ArrayList<String> dbResult = db.queryDBArray(driver, "Mercury", sqlStatement);
		String vendorPaymentResponsibilityID = dbResult.get(0);
		String serviceFlatFee = dbResult.get(1);
		String serviceFeePercent = dbResult.get(2);
		String serviceFeeTaxState = dbResult.get(3);
		String serviceFeeTaxAmount = dbResult.get(4);
		Assert.assertTrue(vendorPaymentResponsibilityID.equals("2"), "The VendorPaymentResponsibilityID should be 2, but it is " + vendorPaymentResponsibilityID);
		Assert.assertTrue(serviceFlatFee.equals("25.00"), "The ServiceFlatFee should be 25.00, but it is " + serviceFlatFee);
		Assert.assertTrue(serviceFeePercent.equals(setServiceFeePercent), "The ServiceFeePercent should be "+setServiceFeePercent+", but it is " + serviceFeePercent);
		Assert.assertTrue(serviceFeeTaxState.equals("OK"), "The ServiceFeeTaxState should be OK, but it is " + serviceFeeTaxState);
		Assert.assertTrue(serviceFeeTaxAmount.equals(taxAmountString), "The ServiceFeeTaxAmount should be "+taxAmountString.substring(0, 4)+", but it is " + serviceFeeTaxAmount);
		
		// Login to Secure
		secure.login(driver, secureUser, password);
		
		// Find and open the order
		secure.findAndOpenOrder(driver, orderNumber);
		
		// Assign the order from Secure
		secure.assignVendor(driver, vendorsUser);
		
		// Confirm order details
		secure.confirmOrderDetails(driver, "");
		
		// Wait for history
		perform.waitForElementToBeClickable(driver, SOrderDetails.history_txt(), "id");
		
		// Go to Payments
		secure.goToPayments(driver);
		
		// Search for payment
		String loanNumber = StoredVariables.getassignmentInformationLoanNumber().get();
		secure.searchForPaymentsInOrderSummaryByLoanNumber(driver, loanNumber);
		
		// Verify Order Summary payment details
		String ordered = StoredVariables.gettodaysDateLong().get();
		String propertyAddress = StoredVariables.getpropertyInformationAddress().get();
		String borrower = StoredVariables.getcontactBorrower().get()+"-"+StoredVariables.getborrowerIdentifier().get();
		String receivable = setCombinedWithTaxes;
		String received = "$0.00";
		String receivableDue = setCombinedWithTaxes;
		String payable = setCombinedWithTaxes;
		String payableDue = setCombinedWithTaxes;
		String issueDate = "";
		String toVendor = "$0.00";
		String techFee = "$0.00";
		String balance = "$0.00";
		secure.verifyOrderSummaryPaymentDetailsInPayments(driver, ordered, loanNumber, propertyAddress, borrower, secureUser, vendorsUser, receivable, received, receivableDue, payable, payableDue, issueDate, toVendor, techFee, balance);
		
		// Click Invoices tab
		perform.click(driver, SPayments.invoices_btn(driver));
		
		// Wait for Loan Number
		perform.waitForElementToBeClickable(driver, SPayments.loanNumberInvoices_txtbx(), "id");
		
		// Search for payment
		secure.searchForPaymentsInInvoicesByLoanNumber(driver, loanNumber);
		
		// Verify Invoices payment details
		String invoiceDate = StoredVariables.gettodaysDateLong().get();
		String company = "Automation"+StoredVariables.getusernameEnvironment().get()+vmpUser;
		String invoiceDue = "";
		String type = "Receivable";
		String amount = setCombinedWithTaxes;
		received = "$0.00";
		String paid = "";
		String amountDue = setCombinedWithTaxes;
		secure.verifyInvoicesPaymentDetailsInPayments(driver, invoiceDate, loanNumber, propertyAddress, vmpUser, company, orderNumberVMP, invoiceDue, type, amount, received, paid, amountDue, SPayments.gridInvoices_txt());
		
		// Click Transactions button
		perform.click(driver, SPayments.transactions_btn(driver));
		
		// Wait for text on the page
		perform.waitForElementToBeClickable(driver, SPayments.transactionPage_txt(), "id");
		
		// Search for the Loan Number in the Transactions tab
		secure.searchForPaymentsInTransactionsByLoanNumber(driver, loanNumber);
		
		// Verify the data on the screen
		perform.verification(driver, SPayments.gridTransactions_txt(driver).getText(), "!contains", loanNumber);
		
		// Make a payment using the payment link on the XSite order
		secure.makePaymentFromXSiteUsingPaymentLink(driver, orderNumber, setOrderFee, setTechFeeWithTaxes, setCombinedWithTaxes, "Automation", "Test", "4111111111111111", "November", "2026", "73099", "automation@dntest.net");
		
		// Go to Payments
		secure.goToPayments(driver);
		
		// Search for payment
		secure.searchForPaymentsInOrderSummaryByLoanNumber(driver, loanNumber);
		
		// Verify Order Summary payment details
		received = setCombinedWithTaxes;
		receivableDue = "$0.00";
		balance = setCombinedWithTaxes;
		secure.verifyOrderSummaryPaymentDetailsInPayments(driver, ordered, loanNumber, propertyAddress, borrower, secureUser, vendorsUser, receivable, received, receivableDue, payable, payableDue, issueDate, toVendor, techFee, balance);
		
		// Click Invoices tab
		perform.click(driver, SPayments.invoices_btn(driver));
		
		// Wait for Loan Number
		perform.waitForElementToBeClickable(driver, SPayments.loanNumberInvoices_txtbx(), "id");
		
		// Search for payment
		secure.searchForPaymentsInInvoicesByLoanNumber(driver, loanNumber);
		
		// Verify Invoices payment details
		amountDue = "$0.00";
		secure.verifyInvoicesPaymentDetailsInPayments(driver, invoiceDate, loanNumber, propertyAddress, vmpUser, company, orderNumberVMP, invoiceDue, type, amount, received, paid, amountDue, SPayments.gridInvoices_txt());
		
		// Click Transactions button
		perform.click(driver, SPayments.transactions_btn(driver));
		
		// Wait for text on the page
		perform.waitForElementToBeClickable(driver, SPayments.transactionPage_txt(), "id");
		
		// Search for the Loan Number in the Transactions tab
		secure.searchForPaymentsInTransactionsByLoanNumber(driver, loanNumber);
		
		// Verify the data on the screen
		String date = StoredVariables.gettodaysDateLong().get();
		String nameOnAccount = "Automation Test";
		String addressOnAccount = "Not provided";
		String accountNumber = "xxxxx1111";
		sqlStatement = "SELECT TransactionID FROM Merchants.dbo.Transactions WHERE ProductItemID = (SELECT ProductItemID FROM Mercury.dbo.ProductItems WHERE LoanID = "+orderNumberVMP+")";
		String transID = db.queryDB(driver, "Merchants", sqlStatement);
		type = "Charge";
		String status = "Charged";
		amount = setCombinedWithTaxes;
		String actions = "View";
		
		secure.verifyTransactionsPaymentDetailsInPayments(driver, date, loanNumber, propertyAddress, nameOnAccount, addressOnAccount, accountNumber, transID, type, status, amount, actions);
		
		// Login to Vendors
		vendors.login(driver, vendorsUser, password);
		
		// Accept and deliver the order
		vendors.acceptOrder(driver, orderNumber);

		// Login to Secure
		secure.login(driver, secureUser, password);
		
		// Find the order
		secure.findOrder(driver, orderNumber, "Tracking number");
		
		// Open the order
		secure.openOrder(driver, orderNumber);
		
		// Get new fee to change to
		String getNewOrderFee = Integer.toString(perform.randomNumberBetween2Numbers(driver, Integer.parseInt(getOrderFee), 999));
		String setNewOrderFee = "$" + getNewOrderFee + ".00";
		System.out.println("New Order Fee: " + setNewOrderFee);
		
		// Change Fee
		secure.changeFee(driver, getNewOrderFee, "Changing the fee to "+getNewOrderFee+"");
		
		// Calculate the New Tech Fee
		String getNewTechFee = db.queryDB(driver, "Mercury", calculateTechFeeSQL);
		String setNewTechFee = "$" + getNewTechFee;
		System.out.println("New Tech Fee: " + setNewTechFee);
		
		// Set the New Combined Fee
		int newOrderFeeInt = Integer.parseInt(getNewOrderFee);
		float newTechFeeFloat = Float.parseFloat(getTechFee);
		String newSetCombined = "$" + df.format(newOrderFeeInt+newTechFeeFloat);
		System.out.println("New Combined: " + newSetCombined + " - " + newOrderFeeInt + " + " + newTechFeeFloat);
		
		// Get the new tax percentage
		String getNewTaxPercentageSQL = "SELECT IsNull(StateRate,0)+IsNull(CountyRate,0)+IsNull(CityRate,0)+IsNull(OtherRate,0) FROM [dbo].[TaxValues] WHERE ZipCode = '73114'";
		String getNewTaxPercentage = db.queryDB(driver, "Mercury", getNewTaxPercentageSQL);
		float newTaxPercent = Float.parseFloat(getNewTaxPercentage);
		System.out.println("New Tax Percentage: " + newTaxPercent);
		
		// Calculate the tax
		float newTaxAmountBeforeRound = newTechFeeFloat * newTaxPercent;
		float newTaxAmount = perform.roundFloat(driver, newTaxAmountBeforeRound, 2);
		String newTaxAmountString = String.format("%.2f", newTaxAmount);
		System.out.println("New Tax Amount: " + newTaxAmountString + " - " + newTechFeeFloat + " * " + newTaxPercent);
		
		// Set Combined with taxes
		String setNewCombinedWithTaxes = "$" + df.format(newOrderFeeInt+newTechFeeFloat+newTaxAmount);
		System.out.println("New Combined Fee With Taxes: " + setNewCombinedWithTaxes + " - " + newOrderFeeInt + " + " + newTechFeeFloat + " + " + newTaxAmount);
		
		// Set Combined with taxes
		String setNewTechFeeWithTaxes = "$" + df.format(newTechFeeFloat+newTaxAmount);
		System.out.println("New Tech Fee With Taxes: " + setNewTechFeeWithTaxes);
		
		// Add order info to Extent Report
		test.log(LogStatus.INFO, "Order Info", "Address: " + StoredVariables.getpropertyInformationAddress().get() + 
				"<br>Order Number: " + orderNumber +
				"<br>VMP Order Number: " + orderNumberVMP +
				"<br>Product Item ID: " + productItemID +
				"<br>Loan Number: " + StoredVariables.getassignmentInformationLoanNumber().get() +
				"<br>Order Fee: " + setNewOrderFee +
				"<br>Tech Fee: " + setNewTechFee +
				"<br>Combined Fee: " + newSetCombined +
				"<br>Tax Amount: " + newTaxAmount +
				"<br>Combined Fee With Taxes: " + setNewCombinedWithTaxes);
		
		// Set ServiceFeePercent
		double getNewServiceFeePercent = Integer.parseInt(getNewOrderFee) * 2.8/100;
		long newServiceFeePercentLong = (long) getNewServiceFeePercent;
		String setNewServiceFeePercent = Long.toString(newServiceFeePercentLong) + ".00";
		System.out.println("serviceFeePercent: " + setNewServiceFeePercent);
		
		// Go to Payments
		secure.goToPayments(driver);
		
		// Search for payment
		secure.searchForPaymentsInOrderSummaryByLoanNumber(driver, loanNumber);
		
		// Calculate Receivable Due
		int receivableDueInt = Integer.parseInt(getNewOrderFee) - Integer.parseInt(getOrderFee);
		
		// Verify Order Summary payment details
		receivable = setNewCombinedWithTaxes;
		received = setCombinedWithTaxes;
		receivableDue = "$" + Integer.toString(receivableDueInt) + ".00";
		payable = setNewCombinedWithTaxes;
		payableDue = setNewCombinedWithTaxes;
		balance = setCombinedWithTaxes;
		secure.verifyOrderSummaryPaymentDetailsInPayments(driver, ordered, loanNumber, propertyAddress, borrower, secureUser, vendorsUser, receivable, received, receivableDue, payable, payableDue, issueDate, toVendor, techFee, balance);
		
		// Click Invoices tab
		perform.click(driver, SPayments.invoices_btn(driver));
		
		// Wait for Loan Number
		perform.waitForElementToBeClickable(driver, SPayments.loanNumberInvoices_txtbx(), "id");
		
		// Search for payment
		secure.searchForPaymentsInInvoicesByLoanNumber(driver, loanNumber);
		
		// Verify Invoices payment details
		type = "Receivable";
		amountDue = "$0.00";
		secure.verifyInvoicesPaymentDetailsInPayments(driver, invoiceDate, loanNumber, propertyAddress, vmpUser, company, orderNumberVMP, invoiceDue, type, amount, received, paid, amountDue, SPayments.gridInvoices_txt());
		
		// Click Transactions button
		perform.click(driver, SPayments.transactions_btn(driver));
		
		// Wait for text on the page
		perform.waitForElementToBeClickable(driver, SPayments.transactionPage_txt(), "id");
		
		// Search for the Loan Number in the Transactions tab
		secure.searchForPaymentsInTransactionsByLoanNumber(driver, loanNumber);
		
		// Verify the data on the screen
		type = "Charge";
		secure.verifyTransactionsPaymentDetailsInPayments(driver, date, loanNumber, propertyAddress, nameOnAccount, addressOnAccount, accountNumber, transID, type, status, amount, actions);
		
		// Login to Vendors
		vendors.login(driver, vendorsUser, password);
		
		// Go to the Orders screen
		vendors.goToOrders(driver);
		
		// Search for the order
		vendors.findAndOpenOrder(driver, orderNumber);
		vendors.completeOrderByHTTPPost(driver, vendorsUser, password, orderNumber, "Complete.xml");
		
		// Set date format
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 0);
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		String today = format1.format(cal.getTime());
		
		// Verify there is now a row in the Mercury.dbo.VendorPaymentQueue table and data is correct
		// Set SQL statement
		sqlStatement = "SELECT * FROM Mercury.dbo.VendorPaymentQueue "
				+ "WHERE LoanID = '"+orderNumber+"'";
		
		// Query the DB and build an array out of the results
		ArrayList<String> vendorPaymentQueue = db.queryDBArray(driver, "Mercury", sqlStatement);
		String loanID = vendorPaymentQueue.get(1);
		String enteredStamp = vendorPaymentQueue.get(2);
		String paymentDate = vendorPaymentQueue.get(3);
		String amountDB = vendorPaymentQueue.get(4);
		
		// Verify the values are correct
		perform.verification(driver, loanID, "equals", orderNumber);
		perform.verification(driver, enteredStamp, "contains", today);
		perform.verification(driver, paymentDate, "contains", today);
		perform.verification(driver, amountDB, "equals", "NULL");
		
		// Set SQL Statement
		sqlStatement = "SELECT ServiceFeeFlat, ServiceFeePercent FROM CompanyData.dbo.MercuryOrderReceivables WHERE LoanID = '"+orderNumber+"'";
		
		// Query the DB and build an array out of the results
		ArrayList<String> mercuryOrderReceivables = db.queryDBArray(driver, "Mercury", sqlStatement);
		
		// Set the serviceFeeFlat amount
		String serviceFeeFlat = mercuryOrderReceivables.get(0);
		
		// Verify the values are correct
		perform.verification(driver, serviceFeeFlat, "equals", "25.0000");
		perform.verification(driver, serviceFeePercent, "contains", setServiceFeePercent);
		
		// Login to Secure
		secure.login(driver, secureUser, password);
		
		// Go to Payments
		secure.goToPayments(driver);
		
		// Search for payment
		secure.searchForPaymentsInOrderSummaryByLoanNumber(driver, loanNumber);
		
		// Wait for receivable due to update
		receivableDue = "$" + Integer.toString(receivableDueInt) + ".00";
		waitForReceivableDueToUpdate(driver, loanNumber, receivableDue);
		
		// Verify Order Summary payment details
		receivable = setNewCombinedWithTaxes;
		received = setCombinedWithTaxes;
		payable = setNewCombinedWithTaxes;
		payableDue = setNewCombinedWithTaxes;
		issueDate = StoredVariables.gettodaysDateLong().get();
		balance = setCombinedWithTaxes;
		secure.verifyOrderSummaryPaymentDetailsInPayments(driver, ordered, loanNumber, propertyAddress, borrower, secureUser, vendorsUser, receivable, received, receivableDue, payable, payableDue, issueDate, toVendor, techFee, balance);
		
		// Click Invoices tab
		perform.click(driver, SPayments.invoices_btn(driver));
		
		// Wait for Loan Number
		perform.waitForElementToBeClickable(driver, SPayments.loanNumberInvoices_txtbx(), "id");
		
		// Search for payment
		secure.searchForPaymentsInInvoicesByLoanNumber(driver, loanNumber);
		
		// Verify Invoices payment details
		type = "Receivable";
		amountDue = "$0.00";
		secure.verifyInvoicesPaymentDetailsInPayments(driver, invoiceDate, loanNumber, propertyAddress, vmpUser, company, orderNumberVMP, invoiceDue, type, amount, received, paid, amountDue, SPayments.gridInvoices_txt());
		
		// Click Transactions button
		perform.click(driver, SPayments.transactions_btn(driver));
		
		// Wait for text on the page
		perform.waitForElementToBeClickable(driver, SPayments.transactionPage_txt(), "id");
		
		// Search for the Loan Number in the Transactions tab
		secure.searchForPaymentsInTransactionsByLoanNumber(driver, loanNumber);
		
		// Verify the data on the screen
		type = "Charge";
		secure.verifyTransactionsPaymentDetailsInPayments(driver, date, loanNumber, propertyAddress, nameOnAccount, addressOnAccount, accountNumber, transID, type, status, amount, actions);
		
		// Run the Vendor Payment Processor on QA
		if (env.equals("QA") && runVPP==true) {
			
			Thread.sleep(15000);
			// Run the Vendor Payment Processor
			Runtime.getRuntime().exec(StoredVariables.getuserDir().get() + "\\src\\main\\resources\\ExecuteVendorPaymentProcessor.bat");
			
			// Wait for the Vendor Payment processor to run
			Thread.sleep(15000);
			
			// Go to Payments
			secure.goToPayments(driver);
			
			// Search for payment
			secure.searchForPaymentsInOrderSummaryByLoanNumber(driver, loanNumber);
			
			// Wait for payable due to be $0.00
			waitForPayableDueToUpdate(driver, loanNumber, "$0.00");
			
			// Verify Order Summary payment details
			receivable = setNewCombinedWithTaxes;
			received = setNewCombinedWithTaxes;
			receivableDue = "$0.00";
			payable = setNewCombinedWithTaxes;
			payableDue = setNewCombinedWithTaxes; // payableDue = "$0.00";
			toVendor = "$0.00"; // toVendor = "550.00";
			techFee = "$0.00"; // techFee = setTechFee;
			balance = setNewCombinedWithTaxes; // balance = "$0.00";
			secure.verifyOrderSummaryPaymentDetailsInPayments(driver, ordered, loanNumber, propertyAddress, borrower, secureUser, vendorsUser, receivable, received, receivableDue, payable, payableDue, issueDate, toVendor, techFee, balance);
			
			// Click Invoices tab
			perform.click(driver, SPayments.invoices_btn(driver));
			
			// Wait for Loan Number
			perform.waitForElementToBeClickable(driver, SPayments.loanNumberInvoices_txtbx(), "id");
			
			// Search for payment
			secure.searchForPaymentsInInvoicesByLoanNumber(driver, loanNumber);
			
			// Verify Invoices payment details
			amountDue = "$0.00";
			type = "Receivable";
			received = newSetCombined; // this should be removed because the value it should be is set prior to this
			secure.verifyInvoicesPaymentDetailsInPayments(driver, invoiceDate, loanNumber, propertyAddress, vmpUser, company, orderNumberVMP, invoiceDue, type, amount, received, paid, amountDue, SPayments.gridInvoices_txt());
			
			// Click Transactions button
			perform.click(driver, SPayments.transactions_btn(driver));
			
			// Wait for text on the page
			perform.waitForElementToBeClickable(driver, SPayments.transactionPage_txt(), "id");
			
			// Search for the Loan Number in the Transactions tab
			secure.searchForPaymentsInTransactionsByLoanNumber(driver, loanNumber);
			
			// Verify the data on the screen
			type = "Charge";
			secure.verifyTransactionsPaymentDetailsInPayments(driver, date, loanNumber, propertyAddress, nameOnAccount, addressOnAccount, accountNumber, transID, type, status, amount, actions);
			
			// Verify there is no record in the SecondaryCollectionLiteItems table
			sqlStatement = "SELECT * FROM CompanyData.dbo.SecondaryCollectionLineItems WHERE LoanID = " + orderNumber;
			ArrayList<String> result = db.queryDBArray(driver, "CompanyData", sqlStatement);
			amountDB = result.get(4);
			System.out.println("amountDB = " + amountDB);
			Assert.assertTrue(amountDB.contains(""+Integer.toString(receivableDueInt)+".00"), "There should be a record in the SecondaryCollectionLineItems table");
			
			// Confirm the primary and secondary collections appear in Payment details for the order
			// Click the Order Summary tab
			perform.click(driver, SPayments.orderSummary_btn(driver));
			
			// Wait for Loan # textbox
			perform.waitForElementToBeClickable(driver, SPayments.loanNumber_txtbx(), "id");
			
			// Search for payment
			SPayments.loanNumber_txtbx(driver).clear();
			secure.searchForPaymentsInOrderSummaryByLoanNumber(driver, loanNumber);
			
			// Wait for Vendor Payment Processor to run
			Thread.sleep(3000);
			
			// Wait for the table
			perform.waitForElementToBeClickable(driver, SPayments.grid_txt(), "id");
			
			// Double-click the Loan #
			perform.doubleClickInTable(driver, loanNumber);
			
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			// Switch to the new iFrame
			perform.waitForiFrameSrcAndSwitchToIt(driver, "/Admin/Payments/PaymentDetails.aspx", By.id(SPaymentDetails.ok_btn()));
			
			// Wait for the OK button
			perform.waitForElementToBeClickable(driver, SPaymentDetails.ok_btn(), "id");
			
			// Verify that there are 2 entries in Received
			String receivedText = SPaymentDetails.received_txt(driver).getText();
			perform.verification(driver, receivedText, "contains", newSetCombined.replace(".00", ""));
			perform.verification(driver, receivedText, "contains", "$"+Integer.toString(receivableDueInt));
			
		} // end running the Vendor Payment Processor
		
		// Log test
		test.log(LogStatus.INFO, "Payment Methods", "Verified there is no record in the Secondary Collection table because there is no ACH account");
		
	} // end secondaryCollection
	
	/**
	 * Place a payments order to a vendor with no ACH and confirm the status is in Payment hold while verifying the data in the Payments grid throughout the process
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set default settings for the Secure user</li>
	 * 	<li>Create an order from VMP Client Portal using Deferred CC as the payment method</li>
	 * 	<li>Assign the order from Secure to a vendor with no ACH account</li>
	 * 	<li>Go to the Payments screen in Secure and verify the data in the Payments grid on all of the tabs</li>
	 * 	<li>Make a payment using the payment link from the XSite</li>
	 * 	<li>Go back to the Payments screen in Secure and verify the data in the Payments grid on all of the tabs</li>
	 * 	<li>Accept and complete the order as the Vendor</li>
	 * 	<li>Verify there is a row in the Mercury.dbo.VendorPaymentQueue table and data is correct</li>
	 * 	<li>Verify data in CompanyData.dbo.MercuryOrderReceivables</li>
	 * 	<li>Go back to the Payments screen in Secure and verify the data in the Payments grid on all of the tabs</li>
	 * 	<li>Run the Vendor Payment Processor if on a QA environment</li>
	 * 	<li>Verify the status is Payment hold and the history contains 'Vendor doesn't have a valid bank account on file.'</li>
	 * 	<li>Go to the Payments screen in Secure and verify the data in the Payments grid on all of the tabs</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Payments"}, alwaysRun=true)
	public void vendorWithNoACH() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		String password = StoredVariables.getpassword().get();

		String env = StoredVariables.getusernameEnvironment().get();
		
		// Set user variables
		String secureUser = "Payments4";
		String vmpUser = "OriginatorPayments4";
		String vendorsUser = "RegressionVendors1";
		
		// Get a random Order Fee
		String getOrderFee = Integer.toString(perform.randomNumberBetween2Numbers(driver, 600, 999));
		String setOrderFee = "$" + getOrderFee + ".00";
		System.out.println("Order Fee: " + setOrderFee);
		
		// Set default settings
		secure.setDefaultSettingsForPaymentsTests(driver, secureUser, password);
		
		// Login to VMP Client Portal
		vmp.login(driver, "https://"+env+"autotestpayments4."+StoredVariables.getvmpSiteSuffix().get()+"", vmpUser, password);

		// Set variables for a new VMP Order
		vmp.setVariables(driver);
		
		// Create a new order using deferred CC
		vmp.createNewOrderUsingDeferredCC(driver, setOrderFee);

		// Get order numbers
		db.getLoanIDsFromVMPClientPortalOrder(driver);
		String orderNumber = StoredVariables.getloanID().get();
		String orderNumberVMP = StoredVariables.getloanIDVMP().get();
		
		// Get the ProductItemID
		String productItemID = db.getProductItemID(driver, orderNumber);
		
		// Calculate the Tech Fee
		String calculateTechFeeSQL = "SELECT ServiceFeeFlat + ServiceFeePercent FROM [Mercury].[dbo].[MercuryOrderInformation] WHERE ProductItemID = '"+productItemID+"'";
		String getTechFee = db.queryDB(driver, "Mercury", calculateTechFeeSQL);
		String setTechFee = "$" + getTechFee;
		System.out.println("Tech Fee: " + setTechFee);
		
		// Set the Combined Fee
		int orderFeeInt = Integer.parseInt(getOrderFee);
		float techFeeFloat = Float.parseFloat(getTechFee);
		DecimalFormat df = new DecimalFormat("#.00");
		String setCombined = "$" + df.format(orderFeeInt+techFeeFloat);
		System.out.println("Combined: " + setCombined + " - " + orderFeeInt + " + " + techFeeFloat);
		
		// Get the tax percentage
		String getTaxPercentageSQL = "SELECT IsNull(StateRate,0)+IsNull(CountyRate,0)+IsNull(CityRate,0)+IsNull(OtherRate,0) FROM [dbo].[TaxValues] WHERE ZipCode = '73114'";
		String getTaxPercentage = db.queryDB(driver, "Mercury", getTaxPercentageSQL);
		float taxPercent = Float.parseFloat(getTaxPercentage);
		System.out.println("Tax Percentage: " + taxPercent);
		
		// Calculate the tax
		float taxAmountBeforeRound = techFeeFloat * taxPercent;
		float taxAmount = perform.roundFloat(driver, taxAmountBeforeRound, 2);
		String taxAmountString = String.format("%.2f", taxAmount);
		System.out.println("Tax Amount: " + taxAmountString + " - " + techFeeFloat + " * " + taxPercent);
		
		// Set Combined with taxes
		String setCombinedWithTaxes = "$" + df.format(orderFeeInt+techFeeFloat+taxAmount);
		System.out.println("Combined Fee With Taxes: " + setCombinedWithTaxes + " - " + orderFeeInt + " + " + techFeeFloat + " + " + taxAmount);
		
		// Set Combined with taxes
		String setTechFeeWithTaxes = "$" + df.format(techFeeFloat+taxAmount);
		System.out.println("Tech Fee With Taxes: " + setTechFeeWithTaxes);
		
		// Add order info to Extent Report
		test.log(LogStatus.INFO, "Order Info", "Address: " + StoredVariables.getpropertyInformationAddress().get() + 
				"<br>Order Number: " + orderNumber +
				"<br>VMP Order Number: " + orderNumberVMP +
				"<br>Product Item ID: " + productItemID +
				"<br>Loan Number: " + StoredVariables.getassignmentInformationLoanNumber().get() +
				"<br>Order Fee: " + setOrderFee +
				"<br>Tech Fee: " + setTechFee +
				"<br>Combined Fee: " + setCombined +
				"<br>Tax Amount: " + taxAmount +
				"<br>Combined Fee With Taxes: " + setCombinedWithTaxes);
		
		// Set ServiceFeePercent
		double getServiceFeePercent = Integer.parseInt(getOrderFee) * 2.8/100;
		long serviceFeePercentLong = (long) getServiceFeePercent;
		String setServiceFeePercent = Long.toString(serviceFeePercentLong) + ".00";
		System.out.println("serviceFeePercent: " + setServiceFeePercent);
		
		// Verify there is an entry in Mercury.dbo.MercuryOrderInformation with a VendorPaymentResponsibility of 2
		String sqlStatement = "SELECT VendorPaymentResponsibilityID, ServiceFeeFlat, ServiceFeePercent, ServiceFeeTaxState, ServiceFeeTaxAmount FROM Mercury.dbo.MercuryOrderInformation WHERE ProductItemID = '"+productItemID+"'";
		ArrayList<String> dbResult = db.queryDBArray(driver, "Mercury", sqlStatement);
		String vendorPaymentResponsibilityID = dbResult.get(0);
		String serviceFlatFee = dbResult.get(1);
		String serviceFeePercent = dbResult.get(2);
		String serviceFeeTaxState = dbResult.get(3);
		String serviceFeeTaxAmount = dbResult.get(4);
		Assert.assertTrue(vendorPaymentResponsibilityID.equals("2"), "The VendorPaymentResponsibilityID should be 2, but it is " + vendorPaymentResponsibilityID);
		Assert.assertTrue(serviceFlatFee.equals("25.00"), "The ServiceFlatFee should be 25.00, but it is " + serviceFlatFee);
		Assert.assertTrue(serviceFeePercent.equals(setServiceFeePercent), "The ServiceFeePercent should be "+setServiceFeePercent+", but it is " + serviceFeePercent);
		Assert.assertTrue(serviceFeeTaxState.equals("OK"), "The ServiceFeeTaxState should be OK, but it is " + serviceFeeTaxState);
		Assert.assertTrue(serviceFeeTaxAmount.equals(taxAmountString), "The ServiceFeeTaxAmount should be "+taxAmountString.substring(0, 4)+", but it is " + serviceFeeTaxAmount);
		
		// Login to Secure
		secure.login(driver, secureUser, password);
		
		// Find and open the order
		secure.findAndOpenOrder(driver, orderNumber);
		
		// Assign the order from Secure
		secure.assignVendor(driver, vendorsUser);
		
		// Confirm order details
		secure.confirmOrderDetails(driver, "");
		
		// Wait for history
		perform.waitForElementToBeClickable(driver, SOrderDetails.history_txt(), "id");
		
		// Go to Payments
		secure.goToPayments(driver);
		
		// Search for payment
		String loanNumber = StoredVariables.getassignmentInformationLoanNumber().get();
		secure.searchForPaymentsInOrderSummaryByLoanNumber(driver, loanNumber);
		
		// Verify Order Summary payment details
		String ordered = StoredVariables.gettodaysDateLong().get();
		String propertyAddress = StoredVariables.getpropertyInformationAddress().get();
		String borrower = StoredVariables.getcontactBorrower().get()+"-"+StoredVariables.getborrowerIdentifier().get();
		String receivable = setCombinedWithTaxes;
		String received = "$0.00";
		String receivableDue = setCombinedWithTaxes;
		String payable = setCombinedWithTaxes;
		String payableDue = setCombinedWithTaxes;
		String issueDate = "";
		String toVendor = "$0.00";
		String techFee = "$0.00";
		String balance = "$0.00";
		secure.verifyOrderSummaryPaymentDetailsInPayments(driver, ordered, loanNumber, propertyAddress, borrower, secureUser, vendorsUser, receivable, received, receivableDue, payable, payableDue, issueDate, toVendor, techFee, balance);
		
		// Click Invoices tab
		perform.click(driver, SPayments.invoices_btn(driver));
		
		// Wait for Loan Number
		perform.waitForElementToBeClickable(driver, SPayments.loanNumberInvoices_txtbx(), "id");
		
		// Search for payment
		secure.searchForPaymentsInInvoicesByLoanNumber(driver, loanNumber);
		
		// Verify Invoices payment details
		String invoiceDate = StoredVariables.gettodaysDateLong().get();
		String company = "Automation"+StoredVariables.getusernameEnvironment().get()+vmpUser;
		String invoiceDue = "";
		String type = "Receivable";
		String amount = setCombinedWithTaxes;
		received = "$0.00";
		String paid = "";
		String amountDue = setCombinedWithTaxes;
		secure.verifyInvoicesPaymentDetailsInPayments(driver, invoiceDate, loanNumber, propertyAddress, vmpUser, company, orderNumberVMP, invoiceDue, type, amount, received, paid, amountDue, SPayments.gridInvoices_txt());
		
		// Click Transactions button
		perform.click(driver, SPayments.transactions_btn(driver));
		
		// Wait for text on the page
		perform.waitForElementToBeClickable(driver, SPayments.transactionPage_txt(), "id");
		
		// Search for the Loan Number in the Transactions tab
		secure.searchForPaymentsInTransactionsByLoanNumber(driver, loanNumber);
		
		// Verify the data on the screen
		perform.verification(driver, SPayments.gridTransactions_txt(driver).getText(), "!contains", loanNumber);
		
		// Make a payment using the payment link on the XSite order
		secure.makePaymentFromXSiteUsingPaymentLink(driver, orderNumber, setOrderFee, setTechFeeWithTaxes, setCombinedWithTaxes, "Automation", "Test", "4111111111111111", "November", "2026", "73099", "automation@dntest.net");
		
		// Go to Payments
		secure.goToPayments(driver);
		
		// Search for payment
		secure.searchForPaymentsInOrderSummaryByLoanNumber(driver, loanNumber);
		
		// Verify Order Summary payment details
		received = setCombinedWithTaxes;
		receivableDue = "$0.00";
		balance = setCombinedWithTaxes;
		secure.verifyOrderSummaryPaymentDetailsInPayments(driver, ordered, loanNumber, propertyAddress, borrower, secureUser, vendorsUser, receivable, received, receivableDue, payable, payableDue, issueDate, toVendor, techFee, balance);
		
		// Click Invoices tab
		perform.click(driver, SPayments.invoices_btn(driver));
		
		// Wait for Loan Number
		perform.waitForElementToBeClickable(driver, SPayments.loanNumberInvoices_txtbx(), "id");
		
		// Search for payment
		secure.searchForPaymentsInInvoicesByLoanNumber(driver, loanNumber);
		
		// Verify Invoices payment details
		amountDue = "$0.00";
		secure.verifyInvoicesPaymentDetailsInPayments(driver, invoiceDate, loanNumber, propertyAddress, vmpUser, company, orderNumberVMP, invoiceDue, type, amount, received, paid, amountDue, SPayments.gridInvoices_txt());
		
		// Click Transactions button
		perform.click(driver, SPayments.transactions_btn(driver));
		
		// Wait for text on the page
		perform.waitForElementToBeClickable(driver, SPayments.transactionPage_txt(), "id");
		
		// Search for the Loan Number in the Transactions tab
		secure.searchForPaymentsInTransactionsByLoanNumber(driver, loanNumber);
		
		// Verify the data on the screen
		String date = StoredVariables.gettodaysDateLong().get();
		String nameOnAccount = "Automation Test";
		String addressOnAccount = "Not provided";
		String accountNumber = "xxxxx1111";
		sqlStatement = "SELECT TransactionID FROM Merchants.dbo.Transactions WHERE ProductItemID = (SELECT ProductItemID FROM Mercury.dbo.ProductItems WHERE LoanID = "+orderNumberVMP+")";
		String transID = db.queryDB(driver, "Merchants", sqlStatement);
		type = "Charge";
		String status = "Charged";
		amount = setCombinedWithTaxes;
		String actions = "View";
		
		secure.verifyTransactionsPaymentDetailsInPayments(driver, date, loanNumber, propertyAddress, nameOnAccount, addressOnAccount, accountNumber, transID, type, status, amount, actions);
		
		// Login to Vendors
		vendors.login(driver, vendorsUser, password);
		
		// Accept and deliver the order
		vendors.acceptOrder(driver, orderNumber);
		vendors.completeOrderByHTTPPost(driver, vendorsUser, password, orderNumber, "Complete.xml");
		
		// Set date format
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 0);
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		String today = format1.format(cal.getTime());
		
		// Verify there is now a row in the Mercury.dbo.VendorPaymentQueue table and data is correct
		// Set SQL statement
		sqlStatement = "SELECT * FROM Mercury.dbo.VendorPaymentQueue "
				+ "WHERE LoanID = '"+orderNumber+"'";
		
		// Query the DB and build an array out of the results
		ArrayList<String> vendorPaymentQueue = db.queryDBArray(driver, "Mercury", sqlStatement);
		String loanID = vendorPaymentQueue.get(1);
		String enteredStamp = vendorPaymentQueue.get(2);
		String paymentDate = vendorPaymentQueue.get(3);
		String amountDB = vendorPaymentQueue.get(4);
		
		// Verify the values are correct
		perform.verification(driver, loanID, "equals", orderNumber);
		perform.verification(driver, enteredStamp, "contains", today);
		perform.verification(driver, paymentDate, "contains", today);
		perform.verification(driver, amountDB, "equals", "NULL");
		
		// Set SQL Statement
		sqlStatement = "SELECT ServiceFeeFlat, ServiceFeePercent FROM CompanyData.dbo.MercuryOrderReceivables WHERE LoanID = '"+orderNumber+"'";
		
		// Query the DB and build an array out of the results
		ArrayList<String> mercuryOrderReceivables = db.queryDBArray(driver, "Mercury", sqlStatement);
		
		// Set the serviceFeeFlat
		String serviceFeeFlat = mercuryOrderReceivables.get(0);
		
		// Verify the values are correct
		perform.verification(driver, serviceFeeFlat, "equals", "25.0000");
		perform.verification(driver, serviceFeePercent, "contains", setServiceFeePercent);
		
		// Login to Secure
		secure.login(driver, secureUser, password);
		
		// Go to Payments
		secure.goToPayments(driver);
		
		// Search for payment
		secure.searchForPaymentsInOrderSummaryByLoanNumber(driver, loanNumber);
		
		// Wait for payable due column to update
		payableDue = setCombinedWithTaxes;
		waitForPayableDueToUpdate(driver, loanNumber, setCombinedWithTaxes);
		
		// Verify Order Summary payment details
		receivable = setCombinedWithTaxes;
		received = setCombinedWithTaxes;
		receivableDue = "$0.00";
		payable = setCombinedWithTaxes;
		issueDate = StoredVariables.gettodaysDateLong().get();
		balance = setCombinedWithTaxes;
		secure.verifyOrderSummaryPaymentDetailsInPayments(driver, ordered, loanNumber, propertyAddress, borrower, secureUser, vendorsUser, receivable, received, receivableDue, payable, payableDue, issueDate, toVendor, techFee, balance);
		
		// Click Invoices tab
		perform.click(driver, SPayments.invoices_btn(driver));
		
		// Wait for Loan Number
		perform.waitForElementToBeClickable(driver, SPayments.loanNumberInvoices_txtbx(), "id");
		
		// Search for payment
		secure.searchForPaymentsInInvoicesByLoanNumber(driver, loanNumber);
		
		// Wait for payable due to be the payableDue
		waitForReceivableDueToUpdateOnInvoicesTab(driver, loanNumber, payableDue);
		
		// Verify Invoices payment details
		type = "Receivable";
		amountDue = "$0.00";
		secure.verifyInvoicesPaymentDetailsInPayments(driver, invoiceDate, loanNumber, propertyAddress, vmpUser, company, orderNumberVMP, invoiceDue, type, amount, received, paid, amountDue, SPayments.gridInvoices_txt());
		
		// Click Transactions button
		perform.click(driver, SPayments.transactions_btn(driver));
		
		// Wait for text on the page
		perform.waitForElementToBeClickable(driver, SPayments.transactionPage_txt(), "id");
		
		// Search for the Loan Number in the Transactions tab
		secure.searchForPaymentsInTransactionsByLoanNumber(driver, loanNumber);
		
		// Verify the data on the screen
		type = "Charge";
		secure.verifyTransactionsPaymentDetailsInPayments(driver, date, loanNumber, propertyAddress, nameOnAccount, addressOnAccount, accountNumber, transID, type, status, amount, actions);
		
		// Run the Vendor Payment Processor on QA
		if (env.equals("QA") && runVPP==true) {
			
			Thread.sleep(15000);
			// Run the Vendor Payment Processor
			Runtime.getRuntime().exec(StoredVariables.getuserDir().get() + "\\src\\main\\resources\\ExecuteVendorPaymentProcessor.bat");
			
			// Wait for the Vendor Payment processor to run
			Thread.sleep(15000);
			
			// Go to Orders
			secure.goToOrders(driver);
			
			// Open the order
			secure.findAndOpenOrder(driver, orderNumber);

			// Wait for History to update and say Payment hold
			secure.waitForHistoryTextToUpdate(driver, "Payment hold");
			
			// Get the history text
			String history = SOrderDetails.history_txt(driver).getText();
			System.out.println("history = " + history);
			
			// Verify Payment hold is in the audit trail
			Assert.assertTrue(history.contains("Payment hold"), "Payment hold is not in the audit trail and should be. History = " + history);
			
			// Veirfy there is a note under the Payment hold audit trail entry
			Assert.assertTrue(history.contains("Notes:  Vendor doesn't have a valid bank account on file."), "'Notes:  Vendor doesn't have a valid bank account on file.' is not in the audit trail and should be. History = " + history);			
			
			// Go to Payments
			secure.goToPayments(driver);
			
			// Search for payment
			secure.searchForPaymentsInOrderSummaryByLoanNumber(driver, loanNumber);
			
			// Wait for Vendor Payment Processor to run
			Thread.sleep(3000);
			
			// Wait for the table
			perform.waitForElementToBeClickable(driver, SPayments.grid_txt(), "id");
			
			// Verify Order Summary payment details
			receivable = setCombinedWithTaxes;
			received = setCombinedWithTaxes; // is setCombinedWithTaxes
			receivableDue = "$0.00"; // is $50.00
			payable = setCombinedWithTaxes;
			payableDue = setTechFee;
			issueDate = "Pay hold";
			toVendor = "$0.00";
			techFee = "$0.00";
			balance = setTechFee;
			secure.verifyOrderSummaryPaymentDetailsInPayments(driver, ordered, loanNumber, propertyAddress, borrower, secureUser, vendorsUser, receivable, received, receivableDue, payable, payableDue, issueDate, toVendor, techFee, balance);
			
			// Click Invoices tab
			perform.click(driver, SPayments.invoices_btn(driver));
			
			// Wait for Loan Number
			perform.waitForElementToBeClickable(driver, SPayments.loanNumberInvoices_txtbx(), "id");
			
			// Search for payment
			secure.searchForPaymentsInInvoicesByLoanNumber(driver, loanNumber);
			
			// Verify Invoices payment details
			amountDue = "$0.00";
			received = setCombinedWithTaxes;
			type = "Receivable";
			secure.verifyInvoicesPaymentDetailsInPayments(driver, invoiceDate, loanNumber, propertyAddress, vmpUser, company, orderNumberVMP, invoiceDue, type, amount, received, paid, amountDue, SPayments.gridInvoices_txt());
			
			// Click Transactions button
			perform.click(driver, SPayments.transactions_btn(driver));
			
			// Wait for text on the page
			perform.waitForElementToBeClickable(driver, SPayments.transactionPage_txt(), "id");
			
			// Search for the Loan Number in the Transactions tab
			secure.searchForPaymentsInTransactionsByLoanNumber(driver, loanNumber);
			
			// Verify the data on the screen
			type = "Charge";
			secure.verifyTransactionsPaymentDetailsInPayments(driver, date, loanNumber, propertyAddress, nameOnAccount, addressOnAccount, accountNumber, transID, type, status, amount, actions);
			
		} // end running the Vendor Payment Processor
		
		// Log test
		test.log(LogStatus.INFO, "Payment Methods", "Verified there is no record in the Secondary Collection table because there is no ACH account");
		
	} // end vendorWithNoACH
	
	/**
	 * Place a payments order with a user that pays taxes and verify the data in the Payments grid throughout the process
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set default settings for the Secure user</li>
	 * 	<li>Create an order from VMP Client Portal using Deferred CC as the payment method</li>
	 * 	<li>Verify there is an entry in Mercury.dbo.MercuryOrderInformation with a VendorPaymentResponsibility of 2, serviceFlatFee is 25.00
	 * serviceFeePercent is 14.00, serviceFeeTaxState is PA and serviceFeeTaxAmount is 2.73</li>
	 * 	<li>Assign the order from Secure</li>
	 * 	<li>Go to the Payments screen in Secure and verify the data in the Payments grid on all of the tabs</li>
	 * 	<li>Make a payment using the payment link from the XSite</li>
	 * 	<li>Go back to the Payments screen in Secure and verify the data in the Payments grid on all of the tabs</li>
	 * 	<li>Accept and complete the order as the Vendor</li>
	 * 	<li>Verify there is a row in the Mercury.dbo.VendorPaymentQueue table and data is correct</li>
	 * 	<li>Verify data in CompanyData.dbo.MercuryOrderReceivables</li>
	 * 	<li>Go back to the Payments screen in Secure and verify the data in the Payments grid on all of the tabs</li>
	 * 	<li>Run the Vendor Payment Processor if on a QA environment</li>
	 * 	<li>Go to the Payments screen in Secure and verify the data in the Payments grid on all of the tabs</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Payments"}, alwaysRun=true)
	public void perfectWorldWithTaxes() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		String password = StoredVariables.getpassword().get();

		String env = StoredVariables.getusernameEnvironment().get();
		
		// Set user variables
		String secureUser = "Payments5";
		String vmpUser = "OriginatorPayments5";
		String vendorsUser = "PaymentsAppraiser1";
		
		// Get a random Order Fee
		String getOrderFee = Integer.toString(perform.randomNumberBetween2Numbers(driver, 600, 999));
		String setOrderFee = "$" + getOrderFee + ".00";
		System.out.println("Order Fee: " + setOrderFee);
		
		// Set default settings
		secure.setDefaultSettingsForPaymentsTests(driver, secureUser, password);
		
		// Login to VMP Client Portal
		vmp.login(driver, "https://"+env+"autotestpayments5."+StoredVariables.getvmpSiteSuffix().get()+"", vmpUser, password);

		// Set variables for a new VMP Order
		vmp.setVariables(driver);
		
		// Create a new order using deferred CC
		vmp.createNewOrderUsingDeferredCC(driver, setOrderFee);
		
		// Get order numbers
		db.getLoanIDsFromVMPClientPortalOrder(driver);
		String orderNumber = StoredVariables.getloanID().get();
		String orderNumberVMP = StoredVariables.getloanIDVMP().get();
		
		// Get the ProductItemID
		String productItemID = db.getProductItemID(driver, orderNumber);
		
		// Calculate the Tech Fee
		String calculateTechFeeSQL = "SELECT ServiceFeeFlat + ServiceFeePercent FROM [Mercury].[dbo].[MercuryOrderInformation] WHERE ProductItemID = '"+productItemID+"'";
		String getTechFee = db.queryDB(driver, "Mercury", calculateTechFeeSQL);
		String setTechFee = "$" + getTechFee;
		System.out.println("Tech Fee: " + setTechFee);
		
		// Set the Combined Fee
		int orderFeeInt = Integer.parseInt(getOrderFee);
		float techFeeFloat = Float.parseFloat(getTechFee);
		DecimalFormat df = new DecimalFormat("#.00");
		String setCombined = "$" + df.format(orderFeeInt+techFeeFloat);
		System.out.println("Combined: " + setCombined);
		
		// Get the tax percentage
		String getTaxPercentageSQL = "SELECT IsNull(StateRate,0)+IsNull(CountyRate,0)+IsNull(CityRate,0)+IsNull(OtherRate,0) FROM [dbo].[TaxValues] WHERE ZipCode = '15207'";
		String getTaxPercentage = db.queryDB(driver, "Mercury", getTaxPercentageSQL);
		float taxPercent = Float.parseFloat(getTaxPercentage);
		System.out.println("Tax Percentage: " + taxPercent);
		
		// Calculate the tax
		float taxAmount = techFeeFloat * taxPercent;
		String taxAmountString = String.format("%.2f", taxAmount);
		System.out.println("Tax Amount: " + taxAmountString);
		
		// Set Combined with taxes
		String setCombinedWithTaxes = "$" + df.format(orderFeeInt+techFeeFloat+taxAmount);
		System.out.println("Combined Fee With Taxes: " + setCombinedWithTaxes);
		
		// Set Combined with taxes
		String setTechFeeWithTaxes = "$" + df.format(techFeeFloat+taxAmount);
		System.out.println("Tech Fee With Taxes: " + setTechFeeWithTaxes);
		
		// Add order info to Extent Report
		test.log(LogStatus.INFO, "Order Info", "Address: " + StoredVariables.getpropertyInformationAddress().get() + 
				"<br>Order Number: " + orderNumber +
				"<br>VMP Order Number: " + orderNumberVMP +
				"<br>Product Item ID: " + productItemID +
				"<br>Loan Number: " + StoredVariables.getassignmentInformationLoanNumber().get() +
				"<br>Order Fee: " + setOrderFee +
				"<br>Tech Fee: " + setTechFee +
				"<br>Combined Fee: " + setCombined +
				"<br>Tax Amount: " + taxAmount +
				"<br>Combined Fee With Taxes: " + setCombinedWithTaxes);
		
		// Set ServiceFeePercent
		double getServiceFeePercent = Integer.parseInt(getOrderFee) * 2.8/100;
		long serviceFeePercentLong = (long) getServiceFeePercent;
		String setServiceFeePercent = Long.toString(serviceFeePercentLong) + ".00";
		System.out.println("serviceFeePercent: " + setServiceFeePercent);
		
		// Verify there is an entry in Mercury.dbo.MercuryOrderInformation with a VendorPaymentResponsibility of 2
		String sqlStatement = "SELECT VendorPaymentResponsibilityID, ServiceFeeFlat, ServiceFeePercent, ServiceFeeTaxState, ServiceFeeTaxAmount FROM Mercury.dbo.MercuryOrderInformation WHERE ProductItemID = '"+productItemID+"'";
		ArrayList<String> dbResult = db.queryDBArray(driver, "Mercury", sqlStatement);
		String vendorPaymentResponsibilityID = dbResult.get(0);
		String serviceFlatFee = dbResult.get(1);
		String serviceFeePercent = dbResult.get(2);
		String serviceFeeTaxState = dbResult.get(3);
		String serviceFeeTaxAmount = dbResult.get(4);
		Assert.assertTrue(vendorPaymentResponsibilityID.equals("2"), "The VendorPaymentResponsibilityID should be 2, but it is " + vendorPaymentResponsibilityID);
		Assert.assertTrue(serviceFlatFee.equals("25.00"), "The ServiceFlatFee should be 25.00, but it is " + serviceFlatFee);
		Assert.assertTrue(serviceFeePercent.equals(setServiceFeePercent), "The ServiceFeePercent should be "+setServiceFeePercent+", but it is " + serviceFeePercent);
		Assert.assertTrue(serviceFeeTaxState.equals("PA"), "The ServiceFeeTaxState should be PA, but it is " + serviceFeeTaxState);
		Assert.assertTrue(serviceFeeTaxAmount.equals(taxAmountString), "The ServiceFeeTaxAmount should be "+taxAmountString.substring(0, 4)+", but it is " + serviceFeeTaxAmount);
		
		// Login to Secure
		secure.login(driver, secureUser, password);
		
		// Find and open the order
		secure.findAndOpenOrder(driver, orderNumber);
		
		// Assign the order from Secure
		secure.assignVendor(driver, vendorsUser);
		
		// Confirm order details
		secure.confirmOrderDetails(driver, "");
		
		// Wait for history
		perform.waitForElementToBeClickable(driver, SOrderDetails.history_txt(), "id");
		
		// Go to Payments
		secure.goToPayments(driver);
		
		// Search for payment
		String loanNumber = StoredVariables.getassignmentInformationLoanNumber().get();
		secure.searchForPaymentsInOrderSummaryByLoanNumber(driver, loanNumber);
		
		// Verify Order Summary payment details
		String ordered = StoredVariables.gettodaysDateLong().get();
		String propertyAddress = StoredVariables.getpropertyInformationAddress().get();
		String borrower = StoredVariables.getcontactBorrower().get()+"-"+StoredVariables.getborrowerIdentifier().get();
		String receivable = setCombinedWithTaxes;
		String received = "$0.00";
		String receivableDue = setCombinedWithTaxes;
		String payable = setCombinedWithTaxes;
		String payableDue = setCombinedWithTaxes;
		String issueDate = "";
		String toVendor = "$0.00";
		String techFee = "$0.00";
		String balance = "$0.00";
		secure.verifyOrderSummaryPaymentDetailsInPayments(driver, ordered, loanNumber, propertyAddress, borrower, secureUser, vendorsUser, receivable, received, receivableDue, payable, payableDue, issueDate, toVendor, techFee, balance);

		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Click Invoices tab
		try {
			perform.click(driver, SPayments.invoices_btn(driver));	
		} catch (Exception e) {
			// Wait for busy to be hidden
			perform.waitForBusyToBeHidden(driver);
			
			perform.click(driver, SPayments.invoices_btn(driver));
		} // end try/catch
		
		// Wait for Loan Number
		perform.waitForElementToBeClickable(driver, SPayments.loanNumberInvoices_txtbx(), "id");
		
		// Search for payment
		secure.searchForPaymentsInInvoicesByLoanNumber(driver, loanNumber);
		
		// Verify Invoices payment details
		String invoiceDate = StoredVariables.gettodaysDateLong().get();
		String company = "Automation"+StoredVariables.getusernameEnvironment().get()+vmpUser;
		String invoiceDue = "";
		String type = "Receivable";
		String amount = setCombinedWithTaxes;
		received = "$0.00";
		String paid = "";
		String amountDue = setCombinedWithTaxes;
		secure.verifyInvoicesPaymentDetailsInPayments(driver, invoiceDate, loanNumber, propertyAddress, vmpUser, company, orderNumberVMP, invoiceDue, type, amount, received, paid, amountDue, SPayments.gridInvoices_txt());
		
		// Click Transactions button
		perform.click(driver, SPayments.transactions_btn(driver));
		
		// Wait for text on the page
		perform.waitForElementToBeClickable(driver, SPayments.transactionPage_txt(), "id");
		
		// Search for the Loan Number in the Transactions tab
		secure.searchForPaymentsInTransactionsByLoanNumber(driver, loanNumber);
		
		// Verify the data on the screen
		perform.verification(driver, SPayments.gridTransactions_txt(driver).getText(), "!contains", loanNumber);
		
		// Make a payment using the payment link on the XSite order
		secure.makePaymentFromXSiteUsingPaymentLink(driver, orderNumber, setOrderFee, setTechFeeWithTaxes, setCombinedWithTaxes, "Automation", "Test", "4111111111111111", "November", "2026", "73099", "automation@dntest.net");
		
		// Go to Payments
		secure.goToPayments(driver);
		
		// Search for payment
		secure.searchForPaymentsInOrderSummaryByLoanNumber(driver, loanNumber);
		
		// Verify Order Summary payment details
		received = setCombinedWithTaxes;
		receivableDue = "$0.00";
		balance = setCombinedWithTaxes;
		secure.verifyOrderSummaryPaymentDetailsInPayments(driver, ordered, loanNumber, propertyAddress, borrower, secureUser, vendorsUser, receivable, received, receivableDue, payable, payableDue, issueDate, toVendor, techFee, balance);
		
		// Click Invoices tab
		perform.click(driver, SPayments.invoices_btn(driver));
		
		// Wait for Loan Number
		perform.waitForElementToBeClickable(driver, SPayments.loanNumberInvoices_txtbx(), "id");
		
		// Search for payment
		secure.searchForPaymentsInInvoicesByLoanNumber(driver, loanNumber);
		
		// Verify Invoices payment details
		amountDue = "$0.00";
		secure.verifyInvoicesPaymentDetailsInPayments(driver, invoiceDate, loanNumber, propertyAddress, vmpUser, company, orderNumberVMP, invoiceDue, type, amount, received, paid, amountDue, SPayments.gridInvoices_txt());
		
		// Click Transactions button
		perform.click(driver, SPayments.transactions_btn(driver));
		
		// Wait for text on the page
		perform.waitForElementToBeClickable(driver, SPayments.transactionPage_txt(), "id");
		
		// Search for the Loan Number in the Transactions tab
		secure.searchForPaymentsInTransactionsByLoanNumber(driver, loanNumber);
		
		// Verify the data on the screen
		String date = StoredVariables.gettodaysDateLong().get();
		String nameOnAccount = "Automation Test";
		String addressOnAccount = "Not provided";
		String accountNumber = "xxxxx1111";
		sqlStatement = "SELECT TransactionID FROM Merchants.dbo.Transactions WHERE ProductItemID = (SELECT ProductItemID FROM Mercury.dbo.ProductItems WHERE LoanID = "+orderNumberVMP+")";
		String transID = db.queryDB(driver, "Merchants", sqlStatement);
		type = "Charge";
		String status = "Charged";
		amount = setCombinedWithTaxes;
		String actions = "View";
		
		secure.verifyTransactionsPaymentDetailsInPayments(driver, date, loanNumber, propertyAddress, nameOnAccount, addressOnAccount, accountNumber, transID, type, status, amount, actions);
		
		// Login to Vendors
		vendors.login(driver, vendorsUser, password);
		
		// Accept and deliver the order
		vendors.acceptOrder(driver, orderNumber);
		vendors.completeOrderByHTTPPost(driver, vendorsUser, password, orderNumber, "Complete.xml");
		
		// Set date format
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 0);
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		String today = format1.format(cal.getTime());
		
		// Verify there is now a row in the Mercury.dbo.VendorPaymentQueue table and data is correct
		// Set SQL statement
		sqlStatement = "SELECT * FROM Mercury.dbo.VendorPaymentQueue "
				+ "WHERE LoanID = '"+orderNumber+"'";
		
		// Query the DB and build an array out of the results
		ArrayList<String> vendorPaymentQueue = db.queryDBArray(driver, "Mercury", sqlStatement);
		String loanID = vendorPaymentQueue.get(1);
		String enteredStamp = vendorPaymentQueue.get(2);
		String paymentDate = vendorPaymentQueue.get(3);
		String amountDB = vendorPaymentQueue.get(4);
		
		// Verify the values are correct
		perform.verification(driver, loanID, "equals", orderNumber);
		perform.verification(driver, enteredStamp, "contains", today);
		perform.verification(driver, paymentDate, "contains", today);
		perform.verification(driver, amountDB, "equals", "NULL");
		
		// Set SQL Statement
		sqlStatement = "SELECT ServiceFeeFlat, ServiceFeePercent FROM CompanyData.dbo.MercuryOrderReceivables WHERE LoanID = '"+orderNumber+"'";
		
		// Query the DB and build an array out of the results
		ArrayList<String> mercuryOrderReceivables = db.queryDBArray(driver, "Mercury", sqlStatement);
		serviceFlatFee = mercuryOrderReceivables.get(0);
		serviceFeePercent = mercuryOrderReceivables.get(1);
		
		// Verify the values are correct
		perform.verification(driver, serviceFlatFee, "equals", "25.0000");
		perform.verification(driver, serviceFeePercent, "contains", setServiceFeePercent);
		
		// Login to Secure
		secure.login(driver, secureUser, password);
		
		// Go to Payments
		secure.goToPayments(driver);
		
		// Search for payment
		secure.searchForPaymentsInOrderSummaryByLoanNumber(driver, loanNumber);
		
		// Verify Order Summary payment details
		issueDate = StoredVariables.gettodaysDateLong().get();
		secure.verifyOrderSummaryPaymentDetailsInPayments(driver, ordered, loanNumber, propertyAddress, borrower, secureUser, vendorsUser, receivable, received, receivableDue, payable, payableDue, issueDate, toVendor, techFee, balance);
		
		// Click Invoices tab
		perform.click(driver, SPayments.invoices_btn(driver));
		
		// Wait for Loan Number
		perform.waitForElementToBeClickable(driver, SPayments.loanNumberInvoices_txtbx(), "id");
		
		// Search for payment
		secure.searchForPaymentsInInvoicesByLoanNumber(driver, loanNumber);
		
		// Verify Invoices payment details
		type = "Receivable";
		secure.verifyInvoicesPaymentDetailsInPayments(driver, invoiceDate, loanNumber, propertyAddress, vmpUser, company, orderNumberVMP, invoiceDue, type, amount, received, paid, amountDue, SPayments.gridInvoices_txt());
		
		// Click Transactions button
		perform.click(driver, SPayments.transactions_btn(driver));
		
		// Wait for text on the page
		perform.waitForElementToBeClickable(driver, SPayments.transactionPage_txt(), "id");
		
		// Search for the Loan Number in the Transactions tab
		secure.searchForPaymentsInTransactionsByLoanNumber(driver, loanNumber);
		
		// Verify the data on the screen
		type = "Charge";
		secure.verifyTransactionsPaymentDetailsInPayments(driver, date, loanNumber, propertyAddress, nameOnAccount, addressOnAccount, accountNumber, transID, type, status, amount, actions);
		
		// Write data to a file
		String fileName = "Payments-PerfectWorld-"+StoredVariables.getenvironment().get()+".txt";
		String data = ordered + "," + loanNumber + "," + propertyAddress + "," + borrower + "," + secureUser + "," + vendorsUser + "," + receivable + "," + received + "," + receivableDue + "," + payable + "," + payableDue + "," + issueDate + "," + toVendor + "," + techFee + "," + balance + "," + invoiceDate + "," + vmpUser + "," + company + "," + orderNumberVMP + "," + invoiceDue + "," + type + "," + amount + "," + paid + "," + amountDue + "," + date + "," + nameOnAccount + "," + addressOnAccount + "," + accountNumber + "," + transID + "," + status + "," + actions;
		perform.writeToAFile(driver, StoredVariables.getdocDir().get(), fileName, data);
		
		// Run the Vendor Payment Processor on QA
		if (env.equals("QA") && runVPP==true) {
			
			Thread.sleep(15000);
			// Run the Vendor Payment Processor
			Runtime.getRuntime().exec(StoredVariables.getuserDir().get() + "\\src\\main\\resources\\ExecuteVendorPaymentProcessor.bat");
			
			// Wait for the Vendor Payment processor to run
			Thread.sleep(15000);
			
			// Verify vendor receives payment
			// Login to Secure
			secure.login(driver, secureUser, password);
			
			// Go to Payments
			secure.goToPayments(driver);
			
			// Search for payment
			secure.searchForPaymentsInOrderSummaryByLoanNumber(driver, loanNumber);
			
			// Wait for Vendor Payment Processor to run
			Thread.sleep(3000);
			
			// Wait for the table
			perform.waitForElementToBeClickable(driver, SPayments.grid_txt(), "id");
			
			// Wait for payable due to be $0.00
			waitForPayableDueToUpdate(driver, loanNumber, "$0.00");
			
			// Verify Order Summary payment details
			issueDate = StoredVariables.gettodaysDateLong().get();
			payableDue = "$0.00";
			toVendor = setOrderFee;
			techFee = setTechFee;
			balance = "$0.00";
			secure.verifyOrderSummaryPaymentDetailsInPayments(driver, ordered, loanNumber, propertyAddress, borrower, secureUser, vendorsUser, receivable, received, receivableDue, payable, payableDue, issueDate, toVendor, techFee, balance);
			
			// Click Invoices tab
			perform.click(driver, SPayments.invoices_btn(driver));
			
			// Wait for Loan Number
			perform.waitForElementToBeClickable(driver, SPayments.loanNumberInvoices_txtbx(), "id");
			
			// Search for payment
			secure.searchForPaymentsInInvoicesByLoanNumber(driver, loanNumber);
			
			// Verify Invoices payment details
			type = "Receivable";
			secure.verifyInvoicesPaymentDetailsInPayments(driver, invoiceDate, loanNumber, propertyAddress, vmpUser, company, orderNumberVMP, invoiceDue, type, amount, received, paid, amountDue, SPayments.gridInvoices_txt());
			
			// Click Transactions button
			perform.click(driver, SPayments.transactions_btn(driver));
			
			// Wait for text on the page
			perform.waitForElementToBeClickable(driver, SPayments.transactionPage_txt(), "id");
			
			// Search for the Loan Number in the Transactions tab
			secure.searchForPaymentsInTransactionsByLoanNumber(driver, loanNumber);
			
			// Verify the data on the screen
			type = "Charge";
			secure.verifyTransactionsPaymentDetailsInPayments(driver, date, loanNumber, propertyAddress, nameOnAccount, addressOnAccount, accountNumber, transID, type, status, amount, actions);
			
		} // end running the Vendor Payment Processor
		
		// Log test
		test.log(LogStatus.INFO, "Payment Methods", "Verified you can place a payment order and taxes are correct");
		
	} // end perfectWorldWithTaxes
	
	/**
	 * Test Collection Hold with Auto Pay Variance turned off using a user that pays taxes
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go the the Payments Console in Internal Tools and verify Auto pay variance is unchecked</li>
	 * 	<li>Set default settings for the Secure user</li>
	 * 	<li>Create an order from VMP Client Portal using Deferred CC as the payment method</li>
	 * 	<li>Verify there is an entry in Mercury.dbo.MercuryOrderInformation with a VendorPaymentResponsibility of 2</li>
	 * 	<li>Assign the order from Secure</li>
	 * 	<li>Accept the order as the Vendor</li>
	 * 	<li>Make a payment using the payment link from the XSite</li>
	 * 	<li>Request a modification and increase the fee from Vendors</li>
	 * 	<li>Accept the modification from Secure (The test ends here if not ran on a QA environment)</li>
	 * 	<li>Deliver the order as the Vendor</li>
	 * 	<li>Run the Vendor Payment Processor</li>
	 * 	<li>Go to the Payments screen in Secure and search for the loan number of the payment made</li>
	 * 	<li>Wait for the Issue date column to display Collection hold</li>
	 * 	<li>Verify all columns in the Payments screen</li>
	 * 	<li>Verify the audit trail contains "Collection hold" and "Additional funds required prior to paying vendor."</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Payments"}, alwaysRun=true)
	public void collectionHoldWithNoAutoPayVarianceWithTaxes() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		String password = StoredVariables.getpassword().get();

		String env = StoredVariables.getusernameEnvironment().get();
		
		// Set user variables
		String secureUser = "Payments6";
		String vmpUser = "OriginatorPayments6";
		String vendorsUser = "PaymentsAppraiser1";
		
		// Get a random Order Fee
		String getOrderFee = Integer.toString(perform.randomNumberBetween2Numbers(driver, 600, 999));
		String setOrderFee = "$" + getOrderFee + ".00";
		System.out.println("Order Fee: " + setOrderFee);
		
		// Go to internal tools
		it.goToPaymentsConsole(driver);
		
		// Enter Customer number
		String phoneSuffix = "5426";
		it.searchForPaymentCustomerInPaymentsConsole(driver, phoneSuffix);
		
		// Verify Auto pay variance is unchecked
		boolean autoPay = ITPaymentsConsole.autoPayVariance_chkbx(driver).isSelected();
		if (autoPay==true) {
			
			// Uncheck Auto pay variance
			perform.click(driver, ITPaymentsConsole.autoPayVariance_chkbx(driver));
			
			// Click Save
			perform.click(driver, ITPaymentsConsole.save_btn(driver));
			
			// Verify alert text
			perform.waitForElementToBeClickable(driver, ITPaymentsConsole.alert_txt(), "cssSelector");
			perform.waitForText(driver, ITPaymentsConsole.alert_txt(driver), "Successfully processed Customer number");
			String text = ITPaymentsConsole.alert_txt(driver).getText();
			Assert.assertTrue(text.contains("Successfully processed Customer number " + "501"+StoredVariables.getuserPhonePrefix().get()+phoneSuffix), "The alert text should show the customer was processed successfully. On screen text = " + text);
			
		} // end if
		
		// Set default settings
		secure.setDefaultSettingsForPaymentsTests(driver, secureUser, password);
		
		// Login to VMP Client Portal
		vmp.login(driver, "https://"+env+"autotestpayments6."+StoredVariables.getvmpSiteSuffix().get()+"", vmpUser, password);

		// Set variables for a new VMP Order
		vmp.setVariables(driver);
		
		// Create a new order using deferred CC
		vmp.createNewOrderUsingDeferredCC(driver, setOrderFee);

		// Get order numbers
		db.getLoanIDsFromVMPClientPortalOrder(driver);
		String orderNumber = StoredVariables.getloanID().get();
		
		// Get the ProductItemID
		String productItemID = db.getProductItemID(driver, orderNumber);
		
		// Calculate the Tech Fee
		String calculateTechFeeSQL = "SELECT ServiceFeeFlat + ServiceFeePercent FROM [Mercury].[dbo].[MercuryOrderInformation] WHERE ProductItemID = '"+productItemID+"'";
		String getTechFee = db.queryDB(driver, "Mercury", calculateTechFeeSQL);
		String setTechFee = "$" + getTechFee;
		System.out.println("Tech Fee: " + setTechFee);
		
		// Set the Combined Fee
		int orderFeeInt = Integer.parseInt(getOrderFee);
		float techFeeFloat = Float.parseFloat(getTechFee);
		DecimalFormat df = new DecimalFormat("#.00");
		String setCombined = "$" + df.format(orderFeeInt+techFeeFloat);
		System.out.println("Combined: " + setCombined);
		
		// Get the tax percentage
		String getTaxPercentageSQL = "SELECT IsNull(StateRate,0)+IsNull(CountyRate,0)+IsNull(CityRate,0)+IsNull(OtherRate,0) FROM [dbo].[TaxValues] WHERE ZipCode = '15207'";
		String getTaxPercentage = db.queryDB(driver, "Mercury", getTaxPercentageSQL);
		float taxPercent = Float.parseFloat(getTaxPercentage);
		System.out.println("Tax Percentage: " + taxPercent);
		
		// Calculate the tax
		float taxAmount = techFeeFloat * taxPercent;
		String taxAmountString = String.format("%.2f", taxAmount);
		System.out.println("Tax Amount: " + taxAmountString);
		
		// Set Combined with taxes
		String setCombinedWithTaxes = "$" + df.format(orderFeeInt+techFeeFloat+taxAmount);
		System.out.println("Combined Fee With Taxes: " + setCombinedWithTaxes);
		
		// Set Combined with taxes
		String setTechFeeWithTaxes = "$" + df.format(techFeeFloat+taxAmount);
		System.out.println("Tech Fee With Taxes: " + setTechFeeWithTaxes);
		
		// Add order info to Extent Report
		test.log(LogStatus.INFO, "Order Info", "Address: " + StoredVariables.getpropertyInformationAddress().get() + 
				"<br>Order Number: " + orderNumber +
				"<br>Product Item ID: " + productItemID +
				"<br>Loan Number: " + StoredVariables.getassignmentInformationLoanNumber().get() +
				"<br>Order Fee: " + setOrderFee +
				"<br>Tech Fee: " + setTechFee +
				"<br>Combined Fee: " + setCombined +
				"<br>Combined Fee With Taxes: " + setCombinedWithTaxes);
		
		// Verify there is an entry in Mercury.dbo.MercuryOrderInformation with a VendorPaymentResponsibility of 2
		db.verifyVendorPaymentResponsibilityID(driver, productItemID, "2");
		
		// Login to Secure
		secure.login(driver, secureUser, password);
		
		// Find the order
		secure.findOrder(driver, orderNumber, "Tracking number");
		
		// Open the order
		secure.openOrder(driver, orderNumber);
		
		// Click Assign button
		perform.click(driver, SOrderDetails.assign_btn(driver));
		
		// Assign it to PaymentsAppraiser1
		secure.selectVendor(driver, vendorsUser);
		
		// Select Deferred CC as the payment option
		perform.selectDropdownOption(driver, SConfirmOrder.paymentMethod_dropdown(driver), "Deferred CC");
		Thread.sleep(1000);
		
		// Click Finish
		perform.click(driver, SConfirmOrder.finishTop_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for history
		perform.waitForElementToBeClickable(driver, SOrderDetails.history_txt(), "id");
		
		// Login to Vendors
		vendors.login(driver, vendorsUser, password);
		
		// Accept the order
		vendors.acceptOrder(driver, orderNumber);
		
		// Login to Secure
		secure.login(driver, secureUser, password);
		
		// Make a payment using the payment link on the XSite order
		secure.makePaymentFromXSiteUsingPaymentLink(driver, orderNumber, setOrderFee, setTechFeeWithTaxes, setCombinedWithTaxes, "Automation", "Test", "4111111111111111", "November", "2026", "73099", "automation@dntest.net");
		
		// Login to Vendors
		vendors.login(driver, vendorsUser, password);
		
		// Open the order
		vendors.findAndOpenOrder(driver, orderNumber);
		
		// Get new fee to change to
		String getNewOrderFee = Integer.toString(perform.randomNumberBetween2Numbers(driver, Integer.parseInt(getOrderFee), 999));
		String setNewOrderFee = "$" + getNewOrderFee + ".00";
		System.out.println("New Order Fee: " + setNewOrderFee);
		
		// Change Fee
		vendors.requestModification(driver, "", "", getNewOrderFee, "", "Incresed the fee from 500 to "+getNewOrderFee+"");
		
		// Calculate the New Tech Fee
		String getNewTechFee = db.queryDB(driver, "Mercury", calculateTechFeeSQL);
		String setNewTechFee = "$" + getNewTechFee;
		System.out.println("New Tech Fee: " + setNewTechFee);
		
		// Set the New Combined Fee
		String setNewCombined = "$" + df.format(Integer.parseInt(getNewOrderFee)+Double.parseDouble(getNewTechFee));
		System.out.println("New Combined: " + setNewCombined);
		
		// Add order info to Extent Report
		test.log(LogStatus.INFO, "Order Info", "Address: " + StoredVariables.getpropertyInformationAddress().get() + 
				"<br>Order Number: " + orderNumber +
				"<br>Product Item ID: " + productItemID +
				"<br>Loan Number: " + StoredVariables.getassignmentInformationLoanNumber().get() +
				"<br>New Order Fee: " + setNewOrderFee +
				"<br>New Tech Fee: " + setNewTechFee +
				"<br>New Combined Fee: " + setNewCombined);
		
		// Login to Secure
		secure.login(driver, secureUser, password);
		
		// Open the order
		secure.findAndOpenOrder(driver, orderNumber);
		
		// Accept the modification request
		secure.modificationRequested(driver, true, "Accepting the change fee notes");
		
		// Run the Vendor Payment Processor on QA
		if (env.equals("QA") && runVPP==true) {
			
			// Login to Vendors
			vendors.login(driver, vendorsUser, password);
			
			// Complete the order
			vendors.completeOrderByHTTPPost(driver, vendorsUser, password, orderNumber, "Complete.xml");
			
			Thread.sleep(15000);
			// Run the Vendor Payment Processor
			Runtime.getRuntime().exec(StoredVariables.getuserDir().get() + "\\src\\main\\resources\\ExecuteVendorPaymentProcessor.bat");
			
			// Wait for the Vendor Payment processor to run
			Thread.sleep(15000);
			
			// Login to Secure
			secure.login(driver, secureUser, password);
			
			// Go to Payments
			secure.goToPayments(driver);
			
			// Search for the payment
			String loanNumber = StoredVariables.getassignmentInformationLoanNumber().get();
			secure.searchForPaymentsInOrderSummaryByLoanNumber(driver, loanNumber);
			
			// Wait for Issue Date to display Collection hold
			secure.waitForPaymentsColumnToBeValue(driver, loanNumber, "Issue date", "Collection hold");
			
			// Calculate Receivable Due
			int receivableDueInt = Integer.parseInt(getNewOrderFee) - Integer.parseInt(getOrderFee);
			
			// Verify Order Summary payment details
			String ordered = StoredVariables.gettodaysDateLong().get();
			String propertyAddress = StoredVariables.getpropertyInformationAddress().get();
			String borrower = StoredVariables.getcontactBorrower().get()+"-"+StoredVariables.getborrowerIdentifier().get();
			String receivable = setNewCombined;
			String received = setCombined;
			String receivableDue = "$" + Integer.toString(receivableDueInt) + ".00";
			String payable = setNewCombined;
			String payableDue = setNewCombined;
			String issueDate = "Collect hold";
			String toVendor = "$0.00";
			String techFee = "$0.00";
			String balance = setCombined;
			secure.verifyOrderSummaryPaymentDetailsInPayments(driver, ordered, loanNumber, propertyAddress, borrower, secureUser, vendorsUser, receivable, received, receivableDue, payable, payableDue, issueDate, toVendor, techFee, balance);
			
			// Go to Orders
			secure.goToOrders(driver);
			
			// Open the order
			secure.findAndOpenOrder(driver, orderNumber);
			
			// Get the history text
			String history = SOrderDetails.history_txt(driver).getText();
			System.out.println("history = " + history);
			
			// Verify the order has an audit trail event stating Collection Hold
			Assert.assertTrue(history.contains("Collection hold"), "Collection hold is not in the audit trail and should be. History = " + history);
			
			// Verify the audit trail has a note under the audit trail entry 'Collection hold'
			Assert.assertTrue(history.contains("Additional funds required prior to paying vendor."), "Additional funds required prior to paying vendor is not in the audit trail and should be. History = " + history);			
			
		} // end running the Vendor Payment Processor
		
		// Log test
		test.log(LogStatus.INFO, "Payment Methods", "Verified there is no record in the Secondary Collection table because there is no ACH account");
		
	} // end collectionHoldWithNoAutoPayVarianceWithTaxes
	
	/**
	 * Test Collection Hold with Auto Pay Variance turned on using a user that pays taxes
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go the the Payments Console in Internal Tools and verify Auto pay variance is checked</li>
	 * 	<li>Set default settings for the Secure user</li>
	 * 	<li>Create an order from VMP Client Portal using Deferred CC as the payment method</li>
	 * 	<li>Verify there is an entry in Mercury.dbo.MercuryOrderInformation with a VendorPaymentResponsibility of 2</li>
	 * 	<li>Assign the order from Secure</li>
	 * 	<li>Accept the order as the Vendor</li>
	 * 	<li>Make a payment using the payment link from the XSite</li>
	 * 	<li>Request a modification and increase the fee from Vendors</li>
	 * 	<li>Accept the modification from Secure (The test ends here if not ran on a QA environment)</li>
	 * 	<li>Deliver the order as the Vendor</li>
	 * 	<li>Run the Vendor Payment Processor</li>
	 * 	<li>Go to the Payments screen in Secure and search for the loan number of the payment made</li>
	 * 	<li>Wait for the Issue date column to display Collection hold</li>
	 * 	<li>Verify all columns in the Payments screen</li>
	 * 	<li>Verify the audit trail contains "Collection hold" and "Additional funds required prior to paying vendor."</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Payments"}, alwaysRun=true)
	public void collectionHoldWithAutoPayVarianceWithTaxes() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		String password = StoredVariables.getpassword().get();

		String env = StoredVariables.getusernameEnvironment().get();
		
		// Set user variables
		String secureUser = "Payments7";
		String vmpUser = "OriginatorPayments7";
		String vendorsUser = "PaymentsAppraiser1";
		
		// Get a random Order Fee
		String getOrderFee = Integer.toString(perform.randomNumberBetween2Numbers(driver, 600, 999));
		String setOrderFee = "$" + getOrderFee + ".00";
		System.out.println("Order Fee: " + setOrderFee);
		
		// Go to internal tools
		it.goToPaymentsConsole(driver);
		
		// Enter Customer number
		String phoneSuffix = "5427";
		it.searchForPaymentCustomerInPaymentsConsole(driver, phoneSuffix);
		
		// Verify Auto pay variance is unchecked
		boolean autoPay = ITPaymentsConsole.autoPayVariance_chkbx(driver).isSelected();
		if (autoPay==false) {
			
			// Check Auto pay variance
			perform.click(driver, ITPaymentsConsole.autoPayVariance_chkbx(driver));
			
			// Click Save
			perform.click(driver, ITPaymentsConsole.save_btn(driver));
			
			// Verify alert text
			perform.waitForElementToBeClickable(driver, ITPaymentsConsole.alert_txt(), "cssSelector");
			perform.waitForText(driver, ITPaymentsConsole.alert_txt(driver), "Successfully processed Customer number");
			String text = ITPaymentsConsole.alert_txt(driver).getText();
			Assert.assertTrue(text.contains("Successfully processed Customer number " + "501"+StoredVariables.getuserPhonePrefix().get()+phoneSuffix), "The alert text should show the customer was processed successfully. On screen text = " + text);
			
		} // end if
		
		// Set default settings
		secure.setDefaultSettingsForPaymentsTests(driver, secureUser, password);
		
		// Login to VMP Client Portal
		vmp.login(driver, "https://"+env+"autotestpayments7."+StoredVariables.getvmpSiteSuffix().get()+"", vmpUser, password);

		// Set variables for a new VMP Order
		vmp.setVariables(driver);
		
		// Create a new order using deferred CC
		vmp.createNewOrderUsingDeferredCC(driver, setOrderFee);

		// Get order numbers
		db.getLoanIDsFromVMPClientPortalOrder(driver);
		String orderNumber = StoredVariables.getloanID().get();
		
		// Get the ProductItemID
		String productItemID = db.getProductItemID(driver, orderNumber);
		
		// Calculate the Tech Fee
		String calculateTechFeeSQL = "SELECT ServiceFeeFlat + ServiceFeePercent FROM [Mercury].[dbo].[MercuryOrderInformation] WHERE ProductItemID = '"+productItemID+"'";
		String getTechFee = db.queryDB(driver, "Mercury", calculateTechFeeSQL);
		String setTechFee = "$" + getTechFee;
		System.out.println("Tech Fee: " + setTechFee);
		
		// Set the Combined Fee
		int orderFeeInt = Integer.parseInt(getOrderFee);
		float techFeeFloat = Float.parseFloat(getTechFee);
		DecimalFormat df = new DecimalFormat("#.00");
		String setCombined = "$" + df.format(orderFeeInt+techFeeFloat);
		System.out.println("Combined: " + setCombined);
		
		// Get the tax percentage
		String getTaxPercentageSQL = "SELECT IsNull(StateRate,0)+IsNull(CountyRate,0)+IsNull(CityRate,0)+IsNull(OtherRate,0) FROM [dbo].[TaxValues] WHERE ZipCode = '15207'";
		String getTaxPercentage = db.queryDB(driver, "Mercury", getTaxPercentageSQL);
		float taxPercent = Float.parseFloat(getTaxPercentage);
		System.out.println("Tax Percentage: " + taxPercent);
		
		// Calculate the tax
		float taxAmount = techFeeFloat * taxPercent;
		String taxAmountString = String.format("%.2f", taxAmount);
		System.out.println("Tax Amount: " + taxAmountString);
		
		// Set Combined with taxes
		String setCombinedWithTaxes = "$" + df.format(orderFeeInt+techFeeFloat+taxAmount);
		System.out.println("Combined Fee With Taxes: " + setCombinedWithTaxes);
		
		// Set Combined with taxes
		String setTechFeeWithTaxes = "$" + df.format(techFeeFloat+taxAmount);
		System.out.println("Tech Fee With Taxes: " + setTechFeeWithTaxes);
		
		// Add order info to Extent Report
		test.log(LogStatus.INFO, "Order Info", "Address: " + StoredVariables.getpropertyInformationAddress().get() + 
				"<br>Order Number: " + orderNumber +
				"<br>Product Item ID: " + productItemID +
				"<br>Loan Number: " + StoredVariables.getassignmentInformationLoanNumber().get() +
				"<br>Order Fee: " + setOrderFee +
				"<br>Tech Fee: " + setTechFee +
				"<br>Combined Fee: " + setCombined +
				"<br>Combined Fee With Taxes: " + setCombinedWithTaxes);
		
		// Verify there is an entry in Mercury.dbo.MercuryOrderInformation with a VendorPaymentResponsibility of 2
		db.verifyVendorPaymentResponsibilityID(driver, productItemID, "2");
		
		// Login to Secure
		secure.login(driver, secureUser, password);
		
		// Find the order
		secure.findOrder(driver, orderNumber, "Tracking number");
		
		// Open the order
		secure.openOrder(driver, orderNumber);
		
		// Click Assign button
		perform.click(driver, SOrderDetails.assign_btn(driver));
		
		// Assign it to PaymentsAppraiser1
		secure.selectVendor(driver, vendorsUser);
		
		// Select Deferred CC as the payment option
		perform.selectDropdownOption(driver, SConfirmOrder.paymentMethod_dropdown(driver), "Deferred CC");
		Thread.sleep(1000);
		
		// Click Finish
		perform.click(driver, SConfirmOrder.finishTop_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for history
		perform.waitForElementToBeClickable(driver, SOrderDetails.history_txt(), "id");
		
		// Login to Vendors
		vendors.login(driver, vendorsUser, password);
		
		// Accept and deliver the order
		vendors.acceptOrder(driver, orderNumber);
		
		// Login to Secure
		secure.login(driver, secureUser, password);
		
		// Make a payment using the payment link on the XSite order
		secure.makePaymentFromXSiteUsingPaymentLink(driver, orderNumber, setOrderFee, setTechFeeWithTaxes, setCombinedWithTaxes, "Automation", "Test", "4111111111111111", "November", "2026", "73099", "automation@dntest.net");
		
		// Login to Vendors
		vendors.login(driver, vendorsUser, password);
		
		// Open the order
		vendors.findAndOpenOrder(driver, orderNumber);
		
		// Get new fee to change to
		String getNewOrderFee = Integer.toString(perform.randomNumberBetween2Numbers(driver, Integer.parseInt(getOrderFee), 999));
		String setNewOrderFee = "$" + getNewOrderFee + ".00";
		System.out.println("New Order Fee: " + setNewOrderFee);
		
		// Request a modification to the order
		vendors.requestModification(driver, "", "", getNewOrderFee, "", "Incresed the fee from 500 to "+getNewOrderFee+"");
		
		// Calculate the New Tech Fee
		String getNewTechFee = db.queryDB(driver, "Mercury", calculateTechFeeSQL);
		String setNewTechFee = "$" + getNewTechFee;
		System.out.println("New Tech Fee: " + setNewTechFee);
		
		// Set the New Combined Fee
		String setNewCombined = "$" + df.format(Integer.parseInt(getNewOrderFee)+Double.parseDouble(getNewTechFee));
		System.out.println("New Combined: " + setNewCombined);
		
		// Add order info to Extent Report
		test.log(LogStatus.INFO, "Order Info", "Address: " + StoredVariables.getpropertyInformationAddress().get() + 
				"<br>Order Number: " + orderNumber +
				"<br>Product Item ID: " + productItemID +
				"<br>Loan Number: " + StoredVariables.getassignmentInformationLoanNumber().get() +
				"<br>New Order Fee: " + setNewOrderFee +
				"<br>New Tech Fee: " + setNewTechFee +
				"<br>New Combined Fee: " + setNewCombined);
		
		// Login to Secure
		secure.login(driver, secureUser, password);
		
		// Open the order
		secure.findAndOpenOrder(driver, orderNumber);
		
		// Accept the modification request
		secure.modificationRequested(driver, true, "Accepting the change fee notes");
		
		// Run the Vendor Payment Processor on QA
		if (env.equals("QA") && runVPP==true) {
			
			// Login to Vendors
			vendors.login(driver, vendorsUser, password);
			
			// Complete the order
			vendors.completeOrderByHTTPPost(driver, vendorsUser, password, orderNumber, "Complete.xml");

			Thread.sleep(15000);
			// Run the Vendor Payment Processor
			Runtime.getRuntime().exec(StoredVariables.getuserDir().get() + "\\src\\main\\resources\\ExecuteVendorPaymentProcessor.bat");
			
			// Wait for the Vendor Payment processor to run
			Thread.sleep(15000);
			
			// Login to Secure
			secure.login(driver, secureUser, password);
			
			// Go to Payments
			secure.goToPayments(driver);
			
			// Search for the payment
			String loanNumber = StoredVariables.getassignmentInformationLoanNumber().get();
			secure.searchForPaymentsInOrderSummaryByLoanNumber(driver, loanNumber);
			
			// Wait for Issue Date to display Collection hold
			secure.waitForPaymentsColumnToBeValue(driver, loanNumber, "Issue date", "Collection hold");
			
			// Calculate Receivable Due
			int receivableDueInt = Integer.parseInt(getNewOrderFee) - Integer.parseInt(getOrderFee);
			
			// Verify Order Summary payment details
			String ordered = StoredVariables.gettodaysDateLong().get();
			String propertyAddress = StoredVariables.getpropertyInformationAddress().get();
			String borrower = StoredVariables.getcontactBorrower().get()+"-"+StoredVariables.getborrowerIdentifier().get();
			String receivable = setNewCombined;
			String received = setCombined;
			String receivableDue = "$" + Integer.toString(receivableDueInt) + ".00";
			String payable = setNewCombined;
			String payableDue = setNewCombined;
			String issueDate = "Collect hold";
			String toVendor = "$0.00";
			String techFee = "$0.00";
			String balance = setCombined;
			secure.verifyOrderSummaryPaymentDetailsInPayments(driver, ordered, loanNumber, propertyAddress, borrower, secureUser, vendorsUser, receivable, received, receivableDue, payable, payableDue, issueDate, toVendor, techFee, balance);
			
			// Go to Orders
			secure.goToOrders(driver);
			
			// Open the order
			secure.findAndOpenOrder(driver, orderNumber);
			
			// Get the history text
			String history = SOrderDetails.history_txt(driver).getText();
			System.out.println("history = " + history);
			
			// Verify the order has an audit trail event stating Collection Hold
			Assert.assertTrue(history.contains("Collection hold"), "Collection hold is not in the audit trail and should be. History = " + history);
			
			// Verify the audit trail has a note under the audit trail entry 'Collection hold'
			Assert.assertTrue(history.contains("Additional funds required prior to paying vendor."), "Additional funds required prior to paying vendor is not in the audit trail and should be. History = " + history);			
			
		} // end running the Vendor Payment Processor
		
		// Log test
		test.log(LogStatus.INFO, "Payment Methods", "Verified there is no record in the Secondary Collection table because there is no ACH account");
		
	} // end collectionHoldWithAutoPayVarianceWithTaxes
	
	/**
	 * Test Collection Hold with Auto Pay Variance turned off using a user that does not pay taxes
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go the the Payments Console in Internal Tools and verify Auto pay variance is unchecked</li>
	 * 	<li>Set default settings for the Secure user</li>
	 * 	<li>Create an order from VMP Client Portal using Deferred CC as the payment method</li>
	 * 	<li>Verify there is an entry in Mercury.dbo.MercuryOrderInformation with a VendorPaymentResponsibility of 2</li>
	 * 	<li>Assign the order from Secure</li>
	 * 	<li>Accept the order as the Vendor</li>
	 * 	<li>Make a payment using the payment link from the XSite</li>
	 * 	<li>Request a modification and increase the fee from Vendors</li>
	 * 	<li>Accept the modification from Secure (The test ends here if not ran on a QA environment)</li>
	 * 	<li>Deliver the order as the Vendor</li>
	 * 	<li>Run the Vendor Payment Processor</li>
	 * 	<li>Go to the Payments screen in Secure and search for the loan number of the payment made</li>
	 * 	<li>Wait for the Issue date column to display Collection hold</li>
	 * 	<li>Verify all columns in the Payments screen</li>
	 * 	<li>Verify the audit trail contains "Collection hold" and "Additional funds required prior to paying vendor."</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Payments"}, alwaysRun=true)
	public void collectionHoldWithNoAutoPayVariance() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		String password = StoredVariables.getpassword().get();

		String env = StoredVariables.getusernameEnvironment().get();
		
		// Set user variables
		String secureUser = "Payments8";
		String vmpUser = "OriginatorPayments8";
		String vendorsUser = "PaymentsAppraiser1";
		
		// Get a random Order Fee
		String getOrderFee = Integer.toString(perform.randomNumberBetween2Numbers(driver, 600, 999));
		String setOrderFee = "$" + getOrderFee + ".00";
		System.out.println("Order Fee: " + setOrderFee);
		
		// Go to internal tools
		it.goToPaymentsConsole(driver);
		
		// Enter Customer number
		String phoneSuffix = "5428";
		it.searchForPaymentCustomerInPaymentsConsole(driver, phoneSuffix);
		
		// Verify Auto pay variance is unchecked
		boolean autoPay = ITPaymentsConsole.autoPayVariance_chkbx(driver).isSelected();
		if (autoPay==true) {
			
			// Uncheck Auto pay variance
			perform.click(driver, ITPaymentsConsole.autoPayVariance_chkbx(driver));
			
			// Click Save
			perform.click(driver, ITPaymentsConsole.save_btn(driver));
			
			// Verify alert text
			perform.waitForElementToBeClickable(driver, ITPaymentsConsole.alert_txt(), "cssSelector");
			perform.waitForText(driver, ITPaymentsConsole.alert_txt(driver), "Successfully processed Customer number");
			String text = ITPaymentsConsole.alert_txt(driver).getText();
			Assert.assertTrue(text.contains("Successfully processed Customer number " + "501"+StoredVariables.getuserPhonePrefix().get()+phoneSuffix), "The alert text should show the customer was processed successfully. On screen text = " + text);
			
		} // end if
		
		// Set default settings
		secure.setDefaultSettingsForPaymentsTests(driver, secureUser, password);
		
		// Login to VMP Client Portal
		vmp.login(driver, "https://"+env+"autotestpayments8."+StoredVariables.getvmpSiteSuffix().get()+"", vmpUser, password);

		// Set variables for a new VMP Order
		vmp.setVariables(driver);
		
		// Create a new order using deferred CC
		vmp.createNewOrderUsingDeferredCC(driver, setOrderFee);

		// Get order numbers
		db.getLoanIDsFromVMPClientPortalOrder(driver);
		String orderNumber = StoredVariables.getloanID().get();
		
		// Get the ProductItemID
		String productItemID = db.getProductItemID(driver, orderNumber);
		
		// Calculate the Tech Fee
		String calculateTechFeeSQL = "SELECT ServiceFeeFlat + ServiceFeePercent FROM [Mercury].[dbo].[MercuryOrderInformation] WHERE ProductItemID = '"+productItemID+"'";
		String getTechFee = db.queryDB(driver, "Mercury", calculateTechFeeSQL);
		String setTechFee = "$" + getTechFee;
		System.out.println("Tech Fee: " + setTechFee);
		
		// Set the Combined Fee
		int orderFeeInt = Integer.parseInt(getOrderFee);
		float techFeeFloat = Float.parseFloat(getTechFee);
		DecimalFormat df = new DecimalFormat("#.00");
		String setCombined = "$" + df.format(orderFeeInt+techFeeFloat);
		System.out.println("Combined: " + setCombined + " - " + orderFeeInt + " + " + techFeeFloat);
		
		// Get the tax percentage
		String getTaxPercentageSQL = "SELECT IsNull(StateRate,0)+IsNull(CountyRate,0)+IsNull(CityRate,0)+IsNull(OtherRate,0) FROM [dbo].[TaxValues] WHERE ZipCode = '73114'";
		String getTaxPercentage = db.queryDB(driver, "Mercury", getTaxPercentageSQL);
		float taxPercent = Float.parseFloat(getTaxPercentage);
		System.out.println("Tax Percentage: " + taxPercent);
		
		// Calculate the tax
		float taxAmountBeforeRound = techFeeFloat * taxPercent;
		float taxAmount = perform.roundFloat(driver, taxAmountBeforeRound, 2);
		String taxAmountString = String.format("%.2f", taxAmount);
		System.out.println("Tax Amount: " + taxAmountString + " - " + techFeeFloat + " * " + taxPercent);
		
		// Set Combined with taxes
		String setCombinedWithTaxes = "$" + df.format(orderFeeInt+techFeeFloat+taxAmount);
		System.out.println("Combined Fee With Taxes: " + setCombinedWithTaxes + " - " + orderFeeInt + " + " + techFeeFloat + " + " + taxAmount);
		
		// Set Combined with taxes
		String setTechFeeWithTaxes = "$" + df.format(techFeeFloat+taxAmount);
		System.out.println("Tech Fee With Taxes: " + setTechFeeWithTaxes);
		
		// Add order info to Extent Report
		test.log(LogStatus.INFO, "Order Info", "Address: " + StoredVariables.getpropertyInformationAddress().get() + 
				"<br>Order Number: " + orderNumber +
				"<br>Product Item ID: " + productItemID +
				"<br>Loan Number: " + StoredVariables.getassignmentInformationLoanNumber().get() +
				"<br>Order Fee: " + setOrderFee +
				"<br>Tech Fee: " + setTechFee +
				"<br>Combined Fee: " + setCombined +
				"<br>Tax Amount: " + taxAmount +
				"<br>Combined Fee With Taxes: " + setCombinedWithTaxes);
		
		// Set ServiceFeePercent
		double getServiceFeePercent = Integer.parseInt(getOrderFee) * 2.8/100;
		long serviceFeePercentLong = (long) getServiceFeePercent;
		String setServiceFeePercent = Long.toString(serviceFeePercentLong) + ".00";
		System.out.println("serviceFeePercent: " + setServiceFeePercent);
		
		// Verify there is an entry in Mercury.dbo.MercuryOrderInformation with a VendorPaymentResponsibility of 2
		String sqlStatement = "SELECT VendorPaymentResponsibilityID, ServiceFeeFlat, ServiceFeePercent, ServiceFeeTaxState, ServiceFeeTaxAmount FROM Mercury.dbo.MercuryOrderInformation WHERE ProductItemID = '"+productItemID+"'";
		ArrayList<String> dbResult = db.queryDBArray(driver, "Mercury", sqlStatement);
		String vendorPaymentResponsibilityID = dbResult.get(0);
		String serviceFlatFee = dbResult.get(1);
		String serviceFeePercent = dbResult.get(2);
		String serviceFeeTaxState = dbResult.get(3);
		String serviceFeeTaxAmount = dbResult.get(4);
		Assert.assertTrue(vendorPaymentResponsibilityID.equals("2"), "The VendorPaymentResponsibilityID should be 2, but it is " + vendorPaymentResponsibilityID);
		Assert.assertTrue(serviceFlatFee.equals("25.00"), "The ServiceFlatFee should be 25.00, but it is " + serviceFlatFee);
		Assert.assertTrue(serviceFeePercent.equals(setServiceFeePercent), "The ServiceFeePercent should be "+setServiceFeePercent+", but it is " + serviceFeePercent);
		Assert.assertTrue(serviceFeeTaxState.equals("OK"), "The ServiceFeeTaxState should be OK, but it is " + serviceFeeTaxState);
		Assert.assertTrue(serviceFeeTaxAmount.equals(taxAmountString), "The ServiceFeeTaxAmount should be "+taxAmountString.substring(0, 4)+", but it is " + serviceFeeTaxAmount);
		
		// Login to Secure
		secure.login(driver, secureUser, password);
		
		// Find the order
		secure.findOrder(driver, orderNumber, "Tracking number");
		
		// Open the order
		secure.openOrder(driver, orderNumber);
		
		// Click Assign button
		perform.click(driver, SOrderDetails.assign_btn(driver));
		
		// Assign it to PaymentsAppraiser1
		secure.selectVendor(driver, vendorsUser);
		
		// Select Deferred CC as the payment option
		perform.selectDropdownOption(driver, SConfirmOrder.paymentMethod_dropdown(driver), "Deferred CC");
		Thread.sleep(1000);
		
		// Click Finish
		perform.click(driver, SConfirmOrder.finishTop_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for history
		perform.waitForElementToBeClickable(driver, SOrderDetails.history_txt(), "id");
		
		// Login to Vendors
		vendors.login(driver, vendorsUser, password);
		
		// Accept and deliver the order
		vendors.acceptOrder(driver, orderNumber);
		
		// Login to Secure
		secure.login(driver, secureUser, password);
		
		// Make a payment using the payment link on the XSite order
		secure.makePaymentFromXSiteUsingPaymentLink(driver, orderNumber, setOrderFee, setTechFeeWithTaxes, setCombinedWithTaxes, "Automation", "Test", "4111111111111111", "November", "2026", "73099", "automation@dntest.net");
		
		// Login to Vendors
		vendors.login(driver, vendorsUser, password);
		
		// Open the order
		vendors.findAndOpenOrder(driver, orderNumber);
		
		// Get new fee to change to
		String getNewOrderFee = Integer.toString(perform.randomNumberBetween2Numbers(driver, Integer.parseInt(getOrderFee), 999));
		String setNewOrderFee = "$" + getNewOrderFee + ".00";
		System.out.println("New Order Fee: " + setNewOrderFee);
		
		// Request a modification to the order
		vendors.requestModification(driver, "", "", getNewOrderFee, "", "Incresed the fee from 500 to "+getNewOrderFee+"");
		
		// Calculate the New Tech Fee
		String getNewTechFee = db.queryDB(driver, "Mercury", calculateTechFeeSQL);
		String setNewTechFee = "$" + getNewTechFee;
		System.out.println("New Tech Fee: " + setNewTechFee);
		
		// Set the New Combined Fee
		int newOrderFeeInt = Integer.parseInt(getNewOrderFee);
		float newTechFeeFloat = Float.parseFloat(getTechFee);
		String newSetCombined = "$" + df.format(newOrderFeeInt+newTechFeeFloat);
		System.out.println("New Combined: " + newSetCombined + " - " + newOrderFeeInt + " + " + newTechFeeFloat);
		
		// Get the new tax percentage
		String getNewTaxPercentageSQL = "SELECT IsNull(StateRate,0)+IsNull(CountyRate,0)+IsNull(CityRate,0)+IsNull(OtherRate,0) FROM [dbo].[TaxValues] WHERE ZipCode = '73114'";
		String getNewTaxPercentage = db.queryDB(driver, "Mercury", getNewTaxPercentageSQL);
		float newTaxPercent = Float.parseFloat(getNewTaxPercentage);
		System.out.println("New Tax Percentage: " + newTaxPercent);
		
		// Calculate the tax
		float newTaxAmountBeforeRound = newTechFeeFloat * newTaxPercent;
		float newTaxAmount = perform.roundFloat(driver, newTaxAmountBeforeRound, 2);
		String newTaxAmountString = String.format("%.2f", newTaxAmount);
		System.out.println("New Tax Amount: " + newTaxAmountString + " - " + newTechFeeFloat + " * " + newTaxPercent);
		
		// Set Combined with taxes
		String setNewCombinedWithTaxes = "$" + df.format(newOrderFeeInt+newTechFeeFloat+newTaxAmount);
		System.out.println("New Combined Fee With Taxes: " + setNewCombinedWithTaxes + " - " + newOrderFeeInt + " + " + newTechFeeFloat + " + " + newTaxAmount);
		
		// Set Combined with taxes
		String setNewTechFeeWithTaxes = "$" + df.format(newTechFeeFloat+newTaxAmount);
		System.out.println("New Tech Fee With Taxes: " + setNewTechFeeWithTaxes);
		
		// Add order info to Extent Report
		test.log(LogStatus.INFO, "Order Info", "Address: " + StoredVariables.getpropertyInformationAddress().get() + 
				"<br>Order Number: " + orderNumber +
				"<br>Product Item ID: " + productItemID +
				"<br>Loan Number: " + StoredVariables.getassignmentInformationLoanNumber().get() +
				"<br>Order Fee: " + setNewOrderFee +
				"<br>Tech Fee: " + setNewTechFee +
				"<br>Combined Fee: " + newSetCombined +
				"<br>Tax Amount: " + newTaxAmount +
				"<br>Combined Fee With Taxes: " + setNewCombinedWithTaxes);
		
		// Set ServiceFeePercent
		double getNewServiceFeePercent = Integer.parseInt(getNewOrderFee) * 2.8/100;
		long newServiceFeePercentLong = (long) getNewServiceFeePercent;
		String setNewServiceFeePercent = Long.toString(newServiceFeePercentLong) + ".00";
		System.out.println("serviceFeePercent: " + setNewServiceFeePercent);
		
		// Login to Secure
		secure.login(driver, secureUser, password);
		
		// Open the order
		secure.findAndOpenOrder(driver, orderNumber);
		
		// Accept the modification request
		secure.modificationRequested(driver, true, "Accepting the change fee notes");
		
		// Run the Vendor Payment Processor on QA
		if (env.equals("QA") && runVPP==true) {
			
			// Login to Vendors
			vendors.login(driver, vendorsUser, password);
			
			// Complete the order
			vendors.completeOrderByHTTPPost(driver, vendorsUser, password, orderNumber, "Complete.xml");
			
			Thread.sleep(15000);
			// Run the Vendor Payment Processor
			Runtime.getRuntime().exec(StoredVariables.getuserDir().get() + "\\src\\main\\resources\\ExecuteVendorPaymentProcessor.bat");
			
			// Wait for the Vendor Payment processor to run
			Thread.sleep(15000);
			
			// Login to Secure
			secure.login(driver, secureUser, password);
			
			// Go to Payments
			secure.goToPayments(driver);
			
			// Search for the payment
			String loanNumber = StoredVariables.getassignmentInformationLoanNumber().get();
			secure.searchForPaymentsInOrderSummaryByLoanNumber(driver, loanNumber);
			
			// Wait for Issue Date to display Collection hold
			secure.waitForPaymentsColumnToBeValue(driver, loanNumber, "Issue date", "Collection hold");
			
			// Calculate Receivable Due
			int receivableDueInt = Integer.parseInt(getNewOrderFee) - Integer.parseInt(getOrderFee);
			
			// Verify Order Summary payment details
			String ordered = StoredVariables.gettodaysDateLong().get();
			String propertyAddress = StoredVariables.getpropertyInformationAddress().get();
			String borrower = StoredVariables.getcontactBorrower().get()+"-"+StoredVariables.getborrowerIdentifier().get();
			String receivable = setNewCombinedWithTaxes;
			String received = setCombinedWithTaxes;
			String receivableDue = "$" + Integer.toString(receivableDueInt) + ".00";
			String payable = setNewCombinedWithTaxes;
			String payableDue = setNewCombinedWithTaxes;
			String issueDate = "Collect hold";
			String toVendor = "$0.00";
			String techFee = "$0.00";
			String balance = setCombinedWithTaxes;
			secure.verifyOrderSummaryPaymentDetailsInPayments(driver, ordered, loanNumber, propertyAddress, borrower, secureUser, vendorsUser, receivable, received, receivableDue, payable, payableDue, issueDate, toVendor, techFee, balance);
			
			// Go to Orders
			secure.goToOrders(driver);
			
			// Open the order
			secure.findAndOpenOrder(driver, orderNumber);
			
			// Get the history text
			String history = SOrderDetails.history_txt(driver).getText();
			System.out.println("history = " + history);
			
			// Verify the order has an audit trail event stating Collection Hold
			Assert.assertTrue(history.contains("Collection hold"), "Collection hold is not in the audit trail and should be. History = " + history);
			
			// Verify the audit trail has a note under the audit trail entry 'Collection hold'
			Assert.assertTrue(history.contains("Additional funds required prior to paying vendor."), "Additional funds required prior to paying vendor is not in the audit trail and should be. History = " + history);			
			
		} // end running the Vendor Payment Processor
		
		// Log test
		test.log(LogStatus.INFO, "Payment Methods", "Verified there is no record in the Secondary Collection table because there is no ACH account");
		
	} // end collectionHoldWithNoAutoPayVariance
	
	/**
	 * Test Collection Hold with Auto Pay Variance turned on using a user that does not pay taxes
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go the the Payments Console in Internal Tools and verify Auto pay variance is checked</li>
	 * 	<li>Set default settings for the Secure user</li>
	 * 	<li>Create an order from VMP Client Portal using Deferred CC as the payment method</li>
	 * 	<li>Verify there is an entry in Mercury.dbo.MercuryOrderInformation with a VendorPaymentResponsibility of 2</li>
	 * 	<li>Assign the order from Secure</li>
	 * 	<li>Accept the order as the Vendor</li>
	 * 	<li>Make a payment using the payment link from the XSite</li>
	 * 	<li>Request a modification and increase the fee from Vendors</li>
	 * 	<li>Accept the modification from Secure (The test ends here if not ran on a QA environment)</li>
	 * 	<li>Deliver the order as the Vendor</li>
	 * 	<li>Run the Vendor Payment Processor</li>
	 * 	<li>Go to the Payments screen in Secure and search for the loan number of the payment made</li>
	 * 	<li>Wait for the Issue date column to display Collection hold</li>
	 * 	<li>Verify all columns in the Payments screen</li>
	 * 	<li>Verify the audit trail contains "Collection hold" and "Additional funds required prior to paying vendor."</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Payments"}, alwaysRun=true)
	public void collectionHoldWithAutoPayVariance() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		String password = StoredVariables.getpassword().get();

		String env = StoredVariables.getusernameEnvironment().get();
		
		// Set user variables
		String secureUser = "Payments9";
		String vmpUser = "OriginatorPayments9";
		String vendorsUser = "PaymentsAppraiser1";
		
		// Get a random Order Fee
		String getOrderFee = Integer.toString(perform.randomNumberBetween2Numbers(driver, 600, 999));
		String setOrderFee = "$" + getOrderFee + ".00";
		System.out.println("Order Fee: " + setOrderFee);
		
		// Go to internal tools
		it.goToPaymentsConsole(driver);
		
		// Enter Customer number
		String phoneSuffix = "5429";
		it.searchForPaymentCustomerInPaymentsConsole(driver, phoneSuffix);
		
		// Verify Auto pay variance is unchecked
		boolean autoPay = ITPaymentsConsole.autoPayVariance_chkbx(driver).isSelected();
		if (autoPay==false) {
			
			// Uncheck Auto pay variance
			perform.click(driver, ITPaymentsConsole.autoPayVariance_chkbx(driver));
			
			// Click Save
			perform.click(driver, ITPaymentsConsole.save_btn(driver));
			
			// Verify alert text
			perform.waitForElementToBeClickable(driver, ITPaymentsConsole.alert_txt(), "cssSelector");
			perform.waitForText(driver, ITPaymentsConsole.alert_txt(driver), "Successfully processed Customer number");
			String text = ITPaymentsConsole.alert_txt(driver).getText();
			Assert.assertTrue(text.contains("Successfully processed Customer number " + "501"+StoredVariables.getuserPhonePrefix().get()+phoneSuffix), "The alert text should show the customer was processed successfully. On screen text = " + text);
			
		} // end if
		
		// Set default settings
		secure.setDefaultSettingsForPaymentsTests(driver, secureUser, password);
		
		// Login to VMP Client Portal
		vmp.login(driver, "https://"+env+"autotestpayments9."+StoredVariables.getvmpSiteSuffix().get()+"", vmpUser, password);

		// Set variables for a new VMP Order
		vmp.setVariables(driver);
		
		// Create a new order using deferred CC
		vmp.createNewOrderUsingDeferredCC(driver, setOrderFee);

		// Get order numbers
		db.getLoanIDsFromVMPClientPortalOrder(driver);
		String orderNumber = StoredVariables.getloanID().get();
		
		// Get the ProductItemID
		String productItemID = db.getProductItemID(driver, orderNumber);
		
		// Calculate the Tech Fee
		String calculateTechFeeSQL = "SELECT ServiceFeeFlat + ServiceFeePercent FROM [Mercury].[dbo].[MercuryOrderInformation] WHERE ProductItemID = '"+productItemID+"'";
		String getTechFee = db.queryDB(driver, "Mercury", calculateTechFeeSQL);
		String setTechFee = "$" + getTechFee;
		System.out.println("Tech Fee: " + setTechFee);
		
		// Set the Combined Fee
		int orderFeeInt = Integer.parseInt(getOrderFee);
		float techFeeFloat = Float.parseFloat(getTechFee);
		DecimalFormat df = new DecimalFormat("#.00");
		String setCombined = "$" + df.format(orderFeeInt+techFeeFloat);
		System.out.println("Combined: " + setCombined + " - " + orderFeeInt + " + " + techFeeFloat);
		
		// Get the tax percentage
		String getTaxPercentageSQL = "SELECT IsNull(StateRate,0)+IsNull(CountyRate,0)+IsNull(CityRate,0)+IsNull(OtherRate,0) FROM [dbo].[TaxValues] WHERE ZipCode = '73114'";
		String getTaxPercentage = db.queryDB(driver, "Mercury", getTaxPercentageSQL);
		float taxPercent = Float.parseFloat(getTaxPercentage);
		System.out.println("Tax Percentage: " + taxPercent);
		
		// Calculate the tax
		float taxAmountBeforeRound = techFeeFloat * taxPercent;
		float taxAmount = perform.roundFloat(driver, taxAmountBeforeRound, 2);
		String taxAmountString = String.format("%.2f", taxAmount);
		System.out.println("Tax Amount: " + taxAmountString + " - " + techFeeFloat + " * " + taxPercent);
		
		// Set Combined with taxes
		String setCombinedWithTaxes = "$" + df.format(orderFeeInt+techFeeFloat+taxAmount);
		System.out.println("Combined Fee With Taxes: " + setCombinedWithTaxes + " - " + orderFeeInt + " + " + techFeeFloat + " + " + taxAmount);
		
		// Set Combined with taxes
		String setTechFeeWithTaxes = "$" + df.format(techFeeFloat+taxAmount);
		System.out.println("Tech Fee With Taxes: " + setTechFeeWithTaxes);
		
		// Add order info to Extent Report
		test.log(LogStatus.INFO, "Order Info", "Address: " + StoredVariables.getpropertyInformationAddress().get() + 
				"<br>Order Number: " + orderNumber +
				"<br>Product Item ID: " + productItemID +
				"<br>Loan Number: " + StoredVariables.getassignmentInformationLoanNumber().get() +
				"<br>Order Fee: " + setOrderFee +
				"<br>Tech Fee: " + setTechFee +
				"<br>Combined Fee: " + setCombined +
				"<br>Tax Amount: " + taxAmount +
				"<br>Combined Fee With Taxes: " + setCombinedWithTaxes);
		
		// Set ServiceFeePercent
		double getServiceFeePercent = Integer.parseInt(getOrderFee) * 2.8/100;
		long serviceFeePercentLong = (long) getServiceFeePercent;
		String setServiceFeePercent = Long.toString(serviceFeePercentLong) + ".00";
		System.out.println("serviceFeePercent: " + setServiceFeePercent);
		
		// Verify there is an entry in Mercury.dbo.MercuryOrderInformation with a VendorPaymentResponsibility of 2
		String sqlStatement = "SELECT VendorPaymentResponsibilityID, ServiceFeeFlat, ServiceFeePercent, ServiceFeeTaxState, ServiceFeeTaxAmount FROM Mercury.dbo.MercuryOrderInformation WHERE ProductItemID = '"+productItemID+"'";
		ArrayList<String> dbResult = db.queryDBArray(driver, "Mercury", sqlStatement);
		String vendorPaymentResponsibilityID = dbResult.get(0);
		String serviceFlatFee = dbResult.get(1);
		String serviceFeePercent = dbResult.get(2);
		String serviceFeeTaxState = dbResult.get(3);
		String serviceFeeTaxAmount = dbResult.get(4);
		Assert.assertTrue(vendorPaymentResponsibilityID.equals("2"), "The VendorPaymentResponsibilityID should be 2, but it is " + vendorPaymentResponsibilityID);
		Assert.assertTrue(serviceFlatFee.equals("25.00"), "The ServiceFlatFee should be 25.00, but it is " + serviceFlatFee);
		Assert.assertTrue(serviceFeePercent.equals(setServiceFeePercent), "The ServiceFeePercent should be "+setServiceFeePercent+", but it is " + serviceFeePercent);
		Assert.assertTrue(serviceFeeTaxState.equals("OK"), "The ServiceFeeTaxState should be OK, but it is " + serviceFeeTaxState);
		Assert.assertTrue(serviceFeeTaxAmount.equals(taxAmountString), "The ServiceFeeTaxAmount should be "+taxAmountString.substring(0, 4)+", but it is " + serviceFeeTaxAmount);
		
		// Login to Secure
		secure.login(driver, secureUser, password);
		
		// Find the order
		secure.findOrder(driver, orderNumber, "Tracking number");
		
		// Open the order
		secure.openOrder(driver, orderNumber);
		
		// Click Assign button
		perform.click(driver, SOrderDetails.assign_btn(driver));
		
		// Assign it to PaymentsAppraiser1
		secure.selectVendor(driver, vendorsUser);
		
		// Select Deferred CC as the payment option
		perform.selectDropdownOption(driver, SConfirmOrder.paymentMethod_dropdown(driver), "Deferred CC");
		Thread.sleep(1000);
		
		// Click Finish
		perform.click(driver, SConfirmOrder.finishTop_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for history
		perform.waitForElementToBeClickable(driver, SOrderDetails.history_txt(), "id");
		
		// Login to Vendors
		vendors.login(driver, vendorsUser, password);
		
		// Accept and deliver the order
		vendors.acceptOrder(driver, orderNumber);
		
		// Login to Secure
		secure.login(driver, secureUser, password);
		
		// Make a payment using the payment link on the XSite order
		secure.makePaymentFromXSiteUsingPaymentLink(driver, orderNumber, setOrderFee, setTechFeeWithTaxes, setCombinedWithTaxes, "Automation", "Test", "4111111111111111", "November", "2026", "73099", "automation@dntest.net");
		
		// Login to Vendors
		vendors.login(driver, vendorsUser, password);
		
		// Open the order
		vendors.findAndOpenOrder(driver, orderNumber);
		
		// Get new fee to change to
		String getNewOrderFee = Integer.toString(perform.randomNumberBetween2Numbers(driver, Integer.parseInt(getOrderFee), 999));
		String setNewOrderFee = "$" + getNewOrderFee + ".00";
		System.out.println("New Order Fee: " + setNewOrderFee);
		
		// Request a modification to the order
		vendors.requestModification(driver, "", "", getNewOrderFee, "", "Incresed the fee from 500 to "+getNewOrderFee+"");
		
		// Calculate the New Tech Fee
		String getNewTechFee = db.queryDB(driver, "Mercury", calculateTechFeeSQL);
		String setNewTechFee = "$" + getNewTechFee;
		System.out.println("New Tech Fee: " + setNewTechFee);
		
		// Set the New Combined Fee
		int newOrderFeeInt = Integer.parseInt(getNewOrderFee);
		float newTechFeeFloat = Float.parseFloat(getTechFee);
		String newSetCombined = "$" + df.format(newOrderFeeInt+newTechFeeFloat);
		System.out.println("New Combined: " + newSetCombined + " - " + newOrderFeeInt + " + " + newTechFeeFloat);
		
		// Get the new tax percentage
		String getNewTaxPercentageSQL = "SELECT IsNull(StateRate,0)+IsNull(CountyRate,0)+IsNull(CityRate,0)+IsNull(OtherRate,0) FROM [dbo].[TaxValues] WHERE ZipCode = '73114'";
		String getNewTaxPercentage = db.queryDB(driver, "Mercury", getNewTaxPercentageSQL);
		float newTaxPercent = Float.parseFloat(getNewTaxPercentage);
		System.out.println("New Tax Percentage: " + newTaxPercent);
		
		// Calculate the tax
		float newTaxAmountBeforeRound = newTechFeeFloat * newTaxPercent;
		float newTaxAmount = perform.roundFloat(driver, newTaxAmountBeforeRound, 2);
		String newTaxAmountString = String.format("%.2f", newTaxAmount);
		System.out.println("New Tax Amount: " + newTaxAmountString + " - " + newTechFeeFloat + " * " + newTaxPercent);
		
		// Set Combined with taxes
		String setNewCombinedWithTaxes = "$" + df.format(newOrderFeeInt+newTechFeeFloat+newTaxAmount);
		System.out.println("New Combined Fee With Taxes: " + setNewCombinedWithTaxes + " - " + newOrderFeeInt + " + " + newTechFeeFloat + " + " + newTaxAmount);
		
		// Set Combined with taxes
		String setNewTechFeeWithTaxes = "$" + df.format(newTechFeeFloat+newTaxAmount);
		System.out.println("New Tech Fee With Taxes: " + setNewTechFeeWithTaxes);
		
		// Add order info to Extent Report
		test.log(LogStatus.INFO, "Order Info", "Address: " + StoredVariables.getpropertyInformationAddress().get() + 
				"<br>Order Number: " + orderNumber +
				"<br>Product Item ID: " + productItemID +
				"<br>Loan Number: " + StoredVariables.getassignmentInformationLoanNumber().get() +
				"<br>Order Fee: " + setNewOrderFee +
				"<br>Tech Fee: " + setNewTechFee +
				"<br>Combined Fee: " + newSetCombined +
				"<br>Tax Amount: " + newTaxAmount +
				"<br>Combined Fee With Taxes: " + setNewCombinedWithTaxes);
		
		// Set ServiceFeePercent
		double getNewServiceFeePercent = Integer.parseInt(getNewOrderFee) * 2.8/100;
		long newServiceFeePercentLong = (long) getNewServiceFeePercent;
		String setNewServiceFeePercent = Long.toString(newServiceFeePercentLong) + ".00";
		System.out.println("serviceFeePercent: " + setNewServiceFeePercent);
		
		// Login to Secure
		secure.login(driver, secureUser, password);
		
		// Open the order
		secure.findAndOpenOrder(driver, orderNumber);
		
		// Accept the modification request
		secure.modificationRequested(driver, true, "Accepting the change fee notes");
		
		// Run the Vendor Payment Processor on QA
		if (env.equals("QA") && runVPP==true) {
			
			// Login to Vendors
			vendors.login(driver, vendorsUser, password);
			
			// Complete the order
			vendors.completeOrderByHTTPPost(driver, vendorsUser, password, orderNumber, "Complete.xml");
			
			Thread.sleep(15000);
			// Run the Vendor Payment Processor
			Runtime.getRuntime().exec(StoredVariables.getuserDir().get() + "\\src\\main\\resources\\ExecuteVendorPaymentProcessor.bat");
			
			// Wait for the Vendor Payment processor to run
			Thread.sleep(15000);
			
			// Login to Secure
			secure.login(driver, secureUser, password);
			
			// Go to Payments
			secure.goToPayments(driver);
			
			// Search for the payment
			String loanNumber = StoredVariables.getassignmentInformationLoanNumber().get();
			secure.searchForPaymentsInOrderSummaryByLoanNumber(driver, loanNumber);
			
			// Wait for Issue Date to display Collection hold
			secure.waitForPaymentsColumnToBeValue(driver, loanNumber, "Issue date", "Collection hold");
			
			// Calculate Receivable Due
			int receivableDueInt = Integer.parseInt(getNewOrderFee) - Integer.parseInt(getOrderFee);
			
			// Verify Order Summary payment details
			String ordered = StoredVariables.gettodaysDateLong().get();
			String propertyAddress = StoredVariables.getpropertyInformationAddress().get();
			String borrower = StoredVariables.getcontactBorrower().get()+"-"+StoredVariables.getborrowerIdentifier().get();
			String receivable = setNewCombinedWithTaxes;
			String received = setCombinedWithTaxes;
			String receivableDue = "$" + Integer.toString(receivableDueInt) + ".00";
			String payable = setNewCombinedWithTaxes;
			String payableDue = setNewCombinedWithTaxes;
			String issueDate = "Collect hold";
			String toVendor = "$0.00";
			String techFee = "$0.00";
			String balance = setCombinedWithTaxes;
			secure.verifyOrderSummaryPaymentDetailsInPayments(driver, ordered, loanNumber, propertyAddress, borrower, secureUser, vendorsUser, receivable, received, receivableDue, payable, payableDue, issueDate, toVendor, techFee, balance);
			
			// Go to Orders
			secure.goToOrders(driver);
			
			// Open the order
			secure.findAndOpenOrder(driver, orderNumber);
			
			// Get the history text
			String history = SOrderDetails.history_txt(driver).getText();
			System.out.println("history = " + history);
			
			// Verify the order has an audit trail event stating Collection Hold
			Assert.assertTrue(history.contains("Collection hold"), "Collection hold is not in the audit trail and should be. History = " + history);
			
			// Verify the audit trail has a note under the audit trail entry 'Collection hold'
			Assert.assertTrue(history.contains("Additional funds required prior to paying vendor."), "Additional funds required prior to paying vendor is not in the audit trail and should be. History = " + history);			
			
		} // end running the Vendor Payment Processor
		
		// Log test
		test.log(LogStatus.INFO, "Payment Methods", "Verified there is no record in the Secondary Collection table because there is no ACH account");
		
	} // end collectionHoldWithAutoPayVariance
	
	/**
	 * Wait for payable due to be updated
	 *
	 * @param driver the driver
	 * @param loanNumber the loan number
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	private void waitForPayableDueToUpdate (RemoteWebDriver driver, String loanNumber, String expectedValue) throws IOException, InterruptedException {
		
		// Get table data
		ArrayList<String> orderSummary = perform.getAllTableData(driver, SPayments.grid_txt());
		String payableDueOnScreen = orderSummary.get(10);
		int i = 1;
		while (!payableDueOnScreen.equals(expectedValue) && i < 6) {
			
			driver.navigate().refresh();
			
			// Wait for Loan#
			perform.waitForElementToBeClickable(driver, SPayments.loanNumber_txtbx(), "id");
			
			// Search for payment
			secure.searchForPaymentsInOrderSummaryByLoanNumber(driver, loanNumber);
			
			// Get table data
			orderSummary = perform.getAllTableData(driver, SPayments.grid_txt());

			// Get Payable due column
			payableDueOnScreen = orderSummary.get(10);
			
			Thread.sleep(1000);
			
			i++;
			
		} // end while
		
	} // end waitForPayableDueToUpdate
	
	/**
	 * Wait for receivable due to be updated
	 *
	 * @param driver the driver
	 * @param loanNumber the loan number
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	private void waitForReceivableDueToUpdate (RemoteWebDriver driver, String loanNumber, String expectedValue) throws IOException, InterruptedException {
		
		// Get table data
		ArrayList<String> orderSummary = perform.getAllTableData(driver, SPayments.grid_txt());
		String payableDueOnScreen = orderSummary.get(10);
		int i = 1;
		while (!payableDueOnScreen.equals(expectedValue) && i < 6) {
			
			driver.navigate().refresh();
			
			// Wait for Loan#
			perform.waitForElementToBeClickable(driver, SPayments.loanNumber_txtbx(), "id");
			
			// Search for payment
			secure.searchForPaymentsInOrderSummaryByLoanNumber(driver, loanNumber);
			
			// Get table data
			orderSummary = perform.getAllTableData(driver, SPayments.grid_txt());

			// Get Payable due column
			payableDueOnScreen = orderSummary.get(8);
			
			Thread.sleep(1000);
			
			i++;
			
		} // end while
		
	} // end waitForReceivableDueToUpdate
	
	/**
	 * Wait for receivable due to be updated
	 *
	 * @param driver the driver
	 * @param loanNumber the loan number
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	private void waitForReceivableDueToUpdateOnInvoicesTab (RemoteWebDriver driver, String loanNumber, String expectedValue) throws IOException, InterruptedException {
		
		// Get table data
		ArrayList<String> orderSummary = perform.getAllTableData(driver, SPayments.gridInvoices_txt());
		String payableDueOnScreen = orderSummary.get(10);
		int i = 1;
		while (!payableDueOnScreen.equals(expectedValue) && i < 6) {
			
			driver.navigate().refresh();
			
			// Wait for Loan#
			perform.waitForElementToBeClickable(driver, SPayments.loanNumber_txtbx(), "id");
			
			// Click Invoices tab
			perform.click(driver, SPayments.invoices_btn(driver));
			
			// Wait for Loan Number
			perform.waitForElementToBeClickable(driver, SPayments.loanNumberInvoices_txtbx(), "id");
			
			// Search for payment
			secure.searchForPaymentsInInvoicesByLoanNumber(driver, loanNumber);
			
			// Get table data
			orderSummary = perform.getAllTableData(driver, SPayments.gridInvoices_txt());

			// Get Payable due column
			payableDueOnScreen = orderSummary.get(8);
			
			Thread.sleep(1000);
			
			i++;
			
		} // end while
		
	} // end waitForReceivableDueToUpdate
	
} // end the SecurePaymentMethods class
