package regressionPayments;

import java.text.DecimalFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjects.Payments.MakeAPaymentSearch;
import pageObjects.Payments.MakeAPaymentSelect;
import pageObjects.Payments.PProvidePaymentInfo;
import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

/**
 * <h1>Payments - Old Make A Payment Page</h1>
 * Verify the old Make A Payment page loads
 *
 * @author  Dustin Norman
 * @since   10-24-2018
 */

@Listeners(utils.Listener.class)
@Test(singleThreaded=true, groups={"Payments"}, enabled=false)
public class NewMakeAPaymentPage extends TestSetup {

	/**
	 * Verify the old Make A Payment page loads correctly
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li></li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Payments"}, alwaysRun=true)
	public void placeNewPaymentOrder() throws Exception{
		
		// Create variables
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		String password = StoredVariables.getpassword().get();
		String env = StoredVariables.getusernameEnvironment().get();
		
		// Do not run if iOS
		if (!StoredVariables.getuseLocalGrid().get().equals("ios")) {
		
			// Set user variables
			String vmpUser = "OriginatorPayments1";
			
			// Set Payment variables
			String firstName = "Automation";
			String lastName = "Test";
			String cardNumber = "4111111111111111";
			String expMonth = "November";
			String expYear = "2026";
			String zipCode = "73099";
			String email = "automation@dntest.net";
			
			// Get a random Order Fee
			String getOrderFee = Integer.toString(perform.randomNumberBetween2Numbers(driver, 600, 999));
			String setOrderFee = "$" + getOrderFee + ".00";
			System.out.println("Order Fee: " + setOrderFee);
			
			// Login to VMP Client Portal
			vmp.login(driver, "https://"+env+"autotestpayments1."+StoredVariables.getvmpSiteSuffix().get()+"", vmpUser, password);
			
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
			
			// Go to the new Make a Payment page
			String url = "https://qaautotestpayments1.vmpclientqa.com/MakeAPayment/";
			if (env.equals("Live")) {
				url = "https://liveautotestpayments1.vmpclient.com/MakeAPayment/";
			} // end if live
			if (env.equals("Beta")) {
				url = "https://betaautotestpayments1.vmpclient.com/MakeAPayment/search";
			}
			driver.get(url);
			
			// Enter address
			perform.type(driver, MakeAPaymentSearch.address_txtbx(driver), StoredVariables.getpropertyInformationAddress().get());
			
			// Enter Zip
			perform.type(driver, MakeAPaymentSearch.zipCode_txtbx(driver), StoredVariables.getpropertyInformationZip().get());
			
			// Click Search
			perform.click(driver, MakeAPaymentSearch.search_btn(driver));
			
			// Wait for the order to display
			perform.waitForElementToBeClickable(driver, MakeAPaymentSelect.order(driver));
			
			// Open the order
			perform.click(driver, MakeAPaymentSelect.order(driver));
			
			perform.waitForElementToBeClickable(driver, PProvidePaymentInfo.amount_txt(driver));
			
			// Add a comma if the amount is in the thousands
//			boolean taxes = false;
//			String combinedWithComma = null;
//			int length;
//			if (taxes==false) {
//				combinedWithComma = setCombined;
//				length = setCombined.length();
//				if (length>7) {
//					combinedWithComma = setCombined.substring(0, 2) + "," + setCombined.substring(2,length);
//				} // end if
//			} else {
//				setTechFee = setTechFeeWithTaxes;
//				combinedWithComma = setCombinedWithTaxes;
//				length = setCombinedWithTaxes.length();
//				if (length>7) {
//					combinedWithComma = setCombinedWithTaxes.substring(0, 2) + "," + setCombinedWithTaxes.substring(2,length);
//				} // end if
//			} // end if/else
			
			// Verify amounts
			perform.verification(driver, PProvidePaymentInfo.amount_txt(driver).getText(), "equals", setOrderFee);
//			perform.verification(driver, PProvidePaymentInfo.technologyFee_txt(driver).getText(), "equals", setTechFee);
//			perform.verification(driver, PProvidePaymentInfo.total_txt(driver).getText(), "equals", combinedWithComma);
			
			// Enter payment
			secure.enterPaymentOnMakeAPaymentPage(driver, firstName, lastName, cardNumber, expMonth, expYear, zipCode, email);
			
			// Wait for Thank you text
			perform.waitForText(driver, driver.findElement(By.cssSelector("body")), "Thank you");
			
			// Verify successful payment
			perform.verification(driver, PProvidePaymentInfo.confirmation_txt(driver).getText(), "contains", "Thank you for providing your payment information. Charges should appear in 1-3 business days.");
			
			// Log test
			test.log(LogStatus.INFO, "Payments", "Verified the new Make A Payment page is working");
		
		} // end if/else
		
	} // end placeNewPaymentOrder
	
} // end the SecurePaymentMethods class
