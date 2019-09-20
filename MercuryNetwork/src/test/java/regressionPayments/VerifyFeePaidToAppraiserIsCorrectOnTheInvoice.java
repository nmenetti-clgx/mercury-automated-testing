package regressionPayments;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjects.Secure.SConfirmOrder;
import pageObjects.Secure.SOrderDetails;
import pageObjects.Secure.SOrders;
import pageObjects.Secure.SVMPXSites;
import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Payments - Verify Fee Paid To Appraiser Is Correct On The Invoice</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
@Test(singleThreaded=true, groups={"Payments"})
public class VerifyFeePaidToAppraiserIsCorrectOnTheInvoice extends TestSetup {

	/** The secure user 1. */
	private final String secureUser1 = "FeeOnInvoice1";
	
	/** The vmp user 1. */
	private final String vmpUser1 = "OriginatorFeeOnInvoice1";
	
	/** The vendors user 1. */
	private final String vendorsUser1 = "Appraiser1";
	
	/** The first name. */
	private final String firstName = "Automation";
	
	/** The last name. */
	private final String lastName = "Test";
	
	/** The zip code. */
	private final String zipCode = "73099";
	
	/** The credit card number. */
	private final String creditCardNumber = "4111111111111111";
	
	/** The exp month. */
	private final String expMonth = "12";
	
	/** The exp year. */
	private final String expYear = "2026";
	
	/** The amount. */
	private final String amount = "150";
	
	/** The email address. */
	private final String emailAddress = "automation@dntest.net";
	
	/** The email invoice. */
	private final boolean emailInvoice = true;
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Click Preferences&gt;VMP Xsites&gt;Configure Automatic Settings</li>
	 * 	<li>Check the box "Include the vendor's fee on the invoice"</li>
	 * 	<li>Make sure "Attach invoice when order is complete"</li>
	 * 	<li>Save</li>
	 * 	<li>Log in to VMP</li>
	 * 	<li>Set variables</li>
	 * 	<li>Create VMP Order</li>
	 * 	<li>Get order numbers</li>
	 * 	<li>Set the window handle so the test knows where to get back to</li>
	 * 	<li>Open a VMP order needing assignment or reassignment</li>
	 * 	<li>Charge the card</li>
	 * 	<li>Close XSite order</li>
	 * 	<li>Assign the order to a vendor</li>
	 * 	<li>Click Assign</li>
	 * 	<li>Check the agree to notes checkbox</li>
	 * 	<li>Click Finish</li>
	 * 	<li>Login to Vendors</li>
	 * 	<li>Accept the order</li>
	 * 	<li>Complete the order</li>
	 * 	<li>Log back into Secure</li>
	 * 	<li>Open the order</li>
	 * 	<li>Click OK to Complete the order (note the tracking # of the order so you can find it in the Completed folder)</li>
	 * 	<li>Open the order back up</li>
	 * 	<li>Get the Order Fee</li>
	 * 	<li>Click View Xsite order</li>
	 * 	<li>Switch to the new window</li>
	 * 	<li>Open the Invoice PDF</li>
	 * 	<li>Verify the amount paid to the vendor on the invoice matches the order's fee</li>
	 * 	<li>Get the window handle</li>
	 * 	<li>Switch to default content of the third window</li>
	 * 	<li>Get in the correct iFrame</li>
	 * 	<li>driver.switchTo().frame(driver.findElement(By.xpath("frame[contains(@src,'saveIbar.aspx')]")));</li>
	 * 	<li>Click the PDF button</li>
	 * 	<li>Get into the correct iFrame</li>
	 * 	<li>driver.switchTo().frame(driver.findElement(By.xpath("frame[contains(@src,'Invoice.aspx')]")));</li>
	 * 	<li>Copy the contents of the pdf to the clipboard</li>
	 * 	<li>Verify the amount paid to the vendor on the invoice matches the order's fee</li>
	 * 	<li>Log test</li>
* </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Payments"}, alwaysRun=true)
	public void verifyFeeOnInvoiceMatchesOrderFee() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		String password = StoredVariables.getpassword().get();
		
		// Log in to Secure
		secure.login(driver, secureUser1, password);
		
		// Click Preferences>VMP Xsites>Configure Automatic Settings
		secure.goToVMPXSites(driver);
		perform.click(driver,SVMPXSites.configureAutomaticSettings_lnk(driver));
		
		// Check the box "Include the vendor's fee on the invoice"
		perform.waitForElementToBeClickable(driver, SVMPXSites.includeTheVendorsFeeOnTheInvoice_chkbx(), "id");
		perform.checkCheckbox(driver, SVMPXSites.includeTheVendorsFeeOnTheInvoice_chkbx(driver));
		
		// Make sure "Attach invoice when order is complete"
		perform.checkCheckbox(driver, SVMPXSites.attachInvoiceWhenOrderIsMarkedComplete_chkbx(driver));
		
		// Save
		secure.saveVMPXSiteSettings(driver);
		
		// Log in to VMP
		vmp.login(driver, secureUser1, vmpUser1, password);
		
		// Set variables
		vmp.setVariables(driver);
		StoredVariables.getassignmentInformationForm().set("Uniform Residential Appraisal (FNMA 1004)");
		
		// Create VMP Order
		vmp.createVMPOrder(driver);
		
		// Get order numbers
		db.getLoanIDsFromVMPClientPortalOrder(driver);
		String trackingNumber = StoredVariables.gettrackingNumber().get();
		String trackingNumberVMP = StoredVariables.gettrackingNumberVMP().get();
		
		// Set the window handle so the test knows where to get back to
		String winHandle = driver.getWindowHandle();
		
		// Open a VMP order needing assignment or reassignment
		secure.viewXSiteOrderFromSecure(driver, secureUser1, password, trackingNumber);
		
		// Charge the card
		secure.chargeCardXSite(driver, firstName, lastName, zipCode, creditCardNumber, expMonth, expYear, amount, emailAddress, emailInvoice);		
		
		// Close XSite order
		driver.switchTo().window(StoredVariables.getnewWinHandle().get());
		driver.close();
		driver.switchTo().window(winHandle);
		driver.switchTo().defaultContent();
		
		// Assign the order to a vendor
		// Click Assign
		perform.click(driver,SOrderDetails.assign_btn(driver));
		secure.selectVendor(driver, "Appraiser1");
		
		// Check the agree to notes checkbox
		if (!SConfirmOrder.readVendorsFeeNotes_chkbx(driver).isSelected())
		{
			perform.click(driver,SConfirmOrder.readVendorsFeeNotes_chkbx(driver));
		}
		
		// Click Finish
		perform.click(driver,SConfirmOrder.nextBottom_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Login to Vendors 
		vendors.login(driver, vendorsUser1, password);
		
		// Accept the order
		vendors.acceptOrder(driver, trackingNumber);
		
		// Complete the order
		String loanID = StoredVariables.getloanID().get();
		vendors.completeOrderByHTTPPost(driver, vendorsUser1, password, loanID, "Complete.xml");
		
		// Log back into Secure
		secure.login(driver, secureUser1, password);
		
		// Open the order
		secure.findOrder(driver, trackingNumber, "Tracking number");
		secure.openOrder(driver, trackingNumber);
		
		// Click OK to Complete the order (note the tracking # of the order so you can find it in the Completed folder)
		perform.click(driver,SOrderDetails.okProcessReceivedReport_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for Find textbox
		perform.waitForElementToBeClickable(driver, SOrders.find_txtbx(), "id");
		
		// Open the order back up
		secure.openOrder(driver, trackingNumber);
		
		// Get the Order Fee
		String orderFee = SOrderDetails.orderFee_txt(driver).getText();
		
		// Get the PID of the order
		String pid = db.getProductItemID(driver, trackingNumberVMP);
		
		// Get the invoice
		String urlEnv = "";
		switch (StoredVariables.getusernameEnvironment().get()) {
		case "QA":
			urlEnv = "QA";
			break;
		case "Beta":
			urlEnv = "Beta";
			break;
		default:
			urlEnv = "";
		} // end switch
		
		String url = "https://automation"+StoredVariables.getusernameEnvironment().get()+"feeoninvoice1.vmpbilling"+urlEnv+".com/XBilling/Invoicing/Invoice.aspx?PItemID="+pid+"&PIID=&FromGrid=";
		System.out.println("Invoice URL: " + url);
		driver.get(url);
		
		// Get the text of the invoice
		String pdf = driver.findElement(By.id("Form1")).getText();
		
		// Verify the amount paid to the vendor on the invoice matches the order's fee
		System.out.println("amount: " + amount);
		System.out.println("orderFee: " + orderFee);
		Assert.assertTrue(pdf.contains("Default Fee $" + amount + ".00"), "The Default Fee is incorrect. It should be "+amount+" PDF = " + pdf);
		Assert.assertTrue(pdf.contains("Fee paid to Appraiser: $" + orderFee), "The amount paid to the vendor on the invoice does not match the order's fee. It should be "+orderFee+" PDF = " + pdf);
		
		// Log test
		test.log(LogStatus.INFO, "Verify Fee On Invoice", "Verified the fee on the invoice matches the order's fee");
		
	} // end verifyFeeOnInvoiceMatchesOrderFee
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Click Preferences&gt;VMP Xsites&gt;Configure Automatic Settings</li>
	 * 	<li>Check the box "Include the vendor's fee on the invoice"</li>
	 * 	<li>Make sure "Attach invoice when order is complete"</li>
	 * 	<li>Save</li>
	 * 	<li>Log in to VMP</li>
	 * 	<li>Set variables</li>
	 * 	<li>Create VMP Order</li>
	 * 	<li>Get order numbers</li>
	 * 	<li>Set the window handle so the test knows where to get back to</li>
	 * 	<li>Open a VMP order needing assignment or reassignment</li>
	 * 	<li>Charge the card</li>
	 * 	<li>Close XSite order</li>
	 * 	<li>Assign the order to a vendor</li>
	 * 	<li>Click Assign</li>
	 * 	<li>Check the agree to notes checkbox</li>
	 * 	<li>Click Finish</li>
	 * 	<li>Login to Vendors</li>
	 * 	<li>Conditionally decline the order</li>
	 * 	<li>Log back into Secure</li>
	 * 	<li>Open the order</li>
	 * 	<li>Select the I agree radio button</li>
	 * 	<li>Click OK</li>
	 * 	<li>Login to Vendors</li>
	 * 	<li>Complete the order</li>
	 * 	<li>Log back into Secure</li>
	 * 	<li>Open the order</li>
	 * 	<li>Click OK to Complete the order (note the tracking # of the order so you can find it in the Completed folder)</li>
	 * 	<li>Open the order back up</li>
	 * 	<li>Get the Order Fee</li>
	 * 	<li>Click View Xsite order</li>
	 * 	<li>Switch to the new window</li>
	 * 	<li>Open the Invoice PDF</li>
	 * 	<li>Verify the amount paid to the vendor on the invoice matches the order's fee</li>
	 * 	<li>Get the window handle</li>
	 * 	<li>Switch to default content of the third window</li>
	 * 	<li>Get in the correct iFrame</li>
	 * 	<li>driver.switchTo().frame(driver.findElement(By.xpath("frame[contains(@src,'saveIbar.aspx')]")));</li>
	 * 	<li>Click the PDF button</li>
	 * 	<li>Get into the correct iFrame</li>
	 * 	<li>driver.switchTo().frame(driver.findElement(By.xpath("frame[contains(@src,'Invoice.aspx')]")));</li>
	 * 	<li>Copy the contents of the pdf to the clipboard</li>
	 * 	<li>Verify the amount paid to the vendor on the invoice matches the order's fee</li>
	 * 	<li>Log test</li>
* </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Payments"}, alwaysRun=true)
	public void verifyFeeOnInvoiceMatchesOrderFee2() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		String password = StoredVariables.getpassword().get();
		
		// Log in to Secure
		secure.login(driver, secureUser1, password);
		
		// Click Preferences>VMP Xsites>Configure Automatic Settings
		secure.goToVMPXSites(driver);
		perform.click(driver,SVMPXSites.configureAutomaticSettings_lnk(driver));
		
		// Check the box "Include the vendor's fee on the invoice"
		perform.waitForElementToBeClickable(driver, SVMPXSites.includeTheVendorsFeeOnTheInvoice_chkbx(), "id");
		perform.checkCheckbox(driver, SVMPXSites.includeTheVendorsFeeOnTheInvoice_chkbx(driver));
		
		// Make sure "Attach invoice when order is complete"
		perform.checkCheckbox(driver, SVMPXSites.attachInvoiceWhenOrderIsMarkedComplete_chkbx(driver));
		
		// Save
		secure.saveVMPXSiteSettings(driver);
		
		// Log in to VMP
		vmp.login(driver, secureUser1, vmpUser1, password);
		
		// Set variables
		vmp.setVariables(driver);
		StoredVariables.getassignmentInformationForm().set("Uniform Residential Appraisal (FNMA 1004)");
		
		// Create VMP Order
		vmp.createVMPOrder(driver);
		
		// Get order numbers
		db.getLoanIDsFromVMPClientPortalOrder(driver);
		String orderNumber = StoredVariables.getloanID().get();
		String trackingNumberVMP = StoredVariables.gettrackingNumberVMP().get();
		
		// Set the window handle so the test knows where to get back to
		String winHandle = driver.getWindowHandle();
		
		// Open a VMP order needing assignment or reassignment
		secure.viewXSiteOrderFromSecure(driver, secureUser1, password, orderNumber);
		
		// Charge the card
		secure.chargeCardXSite(driver, firstName, lastName, zipCode, creditCardNumber, expMonth, expYear, amount, emailAddress, emailInvoice);		
		
		// Close XSite order
		driver.switchTo().window(StoredVariables.getnewWinHandle().get());
		driver.close();
		driver.switchTo().window(winHandle);
		driver.switchTo().defaultContent();
		
		// Assign the order to a vendor
		// Click Assign
		perform.click(driver,SOrderDetails.assign_btn(driver));
		secure.selectVendor(driver, "Appraiser1");
		
		// Check the agree to notes checkbox
		if (!SConfirmOrder.readVendorsFeeNotes_chkbx(driver).isSelected())
		{
			perform.click(driver,SConfirmOrder.readVendorsFeeNotes_chkbx(driver));
		}
		
		// Click Finish
		perform.click(driver,SConfirmOrder.nextBottom_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Login to Vendors 
		vendors.login(driver, vendorsUser1, password);
		
		// Conditionally decline the order
		vendors.conditionallyDeclineOrder(driver, orderNumber, "400");
		
		// Log back into Secure
		secure.login(driver, secureUser1, password);
		
		// Open the order
		secure.findOrder(driver, orderNumber, "Tracking number");
		secure.openOrder(driver, orderNumber);
		
		// Select the I agree radio button
		perform.click(driver,SOrderDetails.iAgreeVendorProposedConditions_btn(driver));;
		
		// Click OK
		perform.click(driver,SOrderDetails.ok_btn(driver));
		
		perform.sleep(driver, 15);
		
		// Login to Vendors 
		vendors.login(driver, vendorsUser1, password);
		
		// Complete the order
		vendors.completeOrderByHTTPPost(driver, vendorsUser1, password, orderNumber, "Complete.xml");
		
		// Log back into Secure
		secure.login(driver, secureUser1, password);
		
		// Open the order
		secure.findOrder(driver, orderNumber, "Tracking number");
		secure.openOrder(driver, orderNumber);
		
		// Click OK to Complete the order (note the tracking # of the order so you can find it in the Completed folder)
		perform.click(driver,SOrderDetails.okProcessReceivedReport_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for Find textbox
		perform.waitForElementToBeClickable(driver, SOrders.find_txtbx(), "id");
		
		// Open the order back up
		secure.openOrder(driver, orderNumber);
		
		// Get the Order Fee
		String orderFee = SOrderDetails.orderFee_txt(driver).getText();
		
		// Get the PID of the order
		String pid = db.getProductItemID(driver, trackingNumberVMP);
		
		// Get the invoice
		String urlEnv = "";
		switch (StoredVariables.getusernameEnvironment().get()) {
		case "QA":
			urlEnv = "QA";
			break;
		case "Beta":
			urlEnv = "Beta";
			break;
		default:
			urlEnv = "";
		} // end switch
		
		String url = "https://automation"+StoredVariables.getusernameEnvironment().get()+"feeoninvoice1.vmpbilling"+urlEnv+".com/XBilling/Invoicing/Invoice.aspx?PItemID="+pid+"&PIID=&FromGrid=";
		System.out.println("Invoice URL: " + url);
		driver.get(url);
		
		// Get the text of the invoice
		String pdf = driver.findElement(By.id("Form1")).getText();
		
		// Verify the amount paid to the vendor on the invoice matches the order's fee
		System.out.println("amount: " + amount);
		System.out.println("orderFee: " + orderFee);
		Assert.assertTrue(pdf.contains("Default Fee $" + amount + ".00"), "The Default Fee is incorrect. It should be "+amount+" PDF = " + pdf);
		Assert.assertTrue(pdf.contains("Fee paid to Appraiser: $" + orderFee), "The amount paid to the vendor on the invoice does not match the order's fee. It should be "+orderFee+" PDF = " + pdf);
		
		// Log test
		test.log(LogStatus.INFO, "Verify Fee On Invoice", "Verified the fee on the invoice matches the order's fee");
		
	} // end verifyFeeOnInvoiceMatchesOrderFee2
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Click Preferences&gt;VMP Xsites&gt;Configure Automatic Settings</li>
	 * 	<li>Check the box "Include the vendor's fee on the invoice"</li>
	 * 	<li>Make sure "Attach invoice when order is complete"</li>
	 * 	<li>Save</li>
	 * 	<li>Log in to VMP</li>
	 * 	<li>Set variables</li>
	 * 	<li>Create VMP Order</li>
	 * 	<li>Get order numbers</li>
	 * 	<li>Set the window handle so the test knows where to get back to</li>
	 * 	<li>Open a VMP order needing assignment or reassignment</li>
	 * 	<li>Charge the card</li>
	 * 	<li>Close XSite order</li>
	 * 	<li>Assign the order to a vendor</li>
	 * 	<li>Click Assign</li>
	 * 	<li>Check the agree to notes checkbox</li>
	 * 	<li>Click Finish</li>
	 * 	<li>Login to Vendors</li>
	 * 	<li>Conditionally decline the order</li>
	 * 	<li>Log back into Secure</li>
	 * 	<li>Open the order</li>
	 * 	<li>Select the I agree radio button</li>
	 * 	<li>Click OK</li>
	 * 	<li>Login to Vendors</li>
	 * 	<li>Complete the order</li>
	 * 	<li>Log back into Secure</li>
	 * 	<li>Open the order</li>
	 * 	<li>Click OK to Complete the order (note the tracking # of the order so you can find it in the Completed folder)</li>
	 * 	<li>Open the order back up</li>
	 * 	<li>Get the Order Fee</li>
	 * 	<li>Click View Xsite order</li>
	 * 	<li>Switch to the new window</li>
	 * 	<li>Open the Invoice PDF</li>
	 * 	<li>Verify the amount paid to the vendor on the invoice matches the order's fee</li>
	 * 	<li>Get the window handle</li>
	 * 	<li>Switch to default content of the third window</li>
	 * 	<li>Get in the correct iFrame</li>
	 * 	<li>driver.switchTo().frame(driver.findElement(By.xpath("frame[contains(@src,'saveIbar.aspx')]")));</li>
	 * 	<li>Click the PDF button</li>
	 * 	<li>Get into the correct iFrame</li>
	 * 	<li>driver.switchTo().frame(driver.findElement(By.xpath("frame[contains(@src,'Invoice.aspx')]")));</li>
	 * 	<li>Copy the contents of the pdf to the clipboard</li>
	 * 	<li>Verify the amount paid to the vendor on the invoice matches the order's fee</li>
	 * 	<li>Log test</li>
* </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Payments"}, alwaysRun=true)
	public void verifyFeeOnInvoiceMatchesOrderFee3() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		String password = StoredVariables.getpassword().get();
		
		// Log in to Secure
		secure.login(driver, secureUser1, password);
		
		// Click Preferences>VMP Xsites>Configure Automatic Settings
		secure.goToVMPXSites(driver);
		perform.click(driver,SVMPXSites.configureAutomaticSettings_lnk(driver));
		
		// Check the box "Include the vendor's fee on the invoice"
		perform.waitForElementToBeClickable(driver, SVMPXSites.includeTheVendorsFeeOnTheInvoice_chkbx(), "id");
		perform.checkCheckbox(driver, SVMPXSites.includeTheVendorsFeeOnTheInvoice_chkbx(driver));
		
		// Make sure "Attach invoice when order is complete"
		perform.checkCheckbox(driver, SVMPXSites.attachInvoiceWhenOrderIsMarkedComplete_chkbx(driver));
		
		// Save
		secure.saveVMPXSiteSettings(driver);
		
		// Log in to VMP
		vmp.login(driver, secureUser1, vmpUser1, password);
		
		// Set variables
		vmp.setVariables(driver);
		StoredVariables.getassignmentInformationForm().set("Uniform Residential Appraisal (FNMA 1004)");
		
		// Create VMP Order
		vmp.createVMPOrder(driver);
		
		// Get order numbers
		db.getLoanIDsFromVMPClientPortalOrder(driver);
		String orderNumber = StoredVariables.getloanID().get();
		String trackingNumberVMP = StoredVariables.gettrackingNumberVMP().get();
		
		// Set the window handle so the test knows where to get back to
		String winHandle = driver.getWindowHandle();
		
		// Open a VMP order needing assignment or reassignment
		secure.viewXSiteOrderFromSecure(driver, secureUser1, password, orderNumber);
		
		// Charge the card
		secure.chargeCardXSite(driver, firstName, lastName, zipCode, creditCardNumber, expMonth, expYear, amount, emailAddress, emailInvoice);		
		
		// Close XSite order
		driver.switchTo().window(StoredVariables.getnewWinHandle().get());
		driver.close();
		driver.switchTo().window(winHandle);
		driver.switchTo().defaultContent();
		
		// Assign the order to a vendor
		// Click Assign
		perform.click(driver,SOrderDetails.assign_btn(driver));
		secure.selectVendor(driver, "Appraiser1");
		
		// Check the agree to notes checkbox
		if (!SConfirmOrder.readVendorsFeeNotes_chkbx(driver).isSelected())
		{
			perform.click(driver,SConfirmOrder.readVendorsFeeNotes_chkbx(driver));
		}
		
		// Click Finish
		perform.click(driver,SConfirmOrder.nextBottom_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Login to Vendors 
		vendors.login(driver, vendorsUser1, password);
		
		// Conditionally decline the order
		vendors.conditionallyDeclineOrder(driver, orderNumber, "400");
		
		// Log back into Secure and open the order
		secure.loginAndOpenOrderByTrackingNumber(driver, secureUser1, password, orderNumber);
		
		// Select the I agree radio button
		perform.click(driver,SOrderDetails.iAgreeVendorProposedConditions_btn(driver));;
		
		// Click OK
		perform.click(driver,SOrderDetails.ok_btn(driver));
		
		perform.sleep(driver, 15);
		
		// Login to Vendors 
		vendors.login(driver, vendorsUser1, password);
		
		// Complete the order
		vendors.completeOrderByHTTPPost(driver, vendorsUser1, password, orderNumber, "Complete.xml");
		
		// Log back into Secure
		secure.login(driver, secureUser1, password);
		
		// Open the order
		secure.findOrder(driver, orderNumber, "Tracking number");
		secure.openOrder(driver, orderNumber);
		
		// Click OK to Complete the order (note the tracking # of the order so you can find it in the Completed folder)
		perform.click(driver,SOrderDetails.okProcessReceivedReport_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for Find textbox
		perform.waitForElementToBeClickable(driver, SOrders.find_txtbx(), "id");
		
		// Open the order back up
		secure.openOrder(driver, orderNumber);
		
		// Get the Order Fee
		String orderFee = SOrderDetails.orderFee_txt(driver).getText();
		
		// Get the PID of the order
		String pid = db.getProductItemID(driver, trackingNumberVMP);
		
		// Get the invoice
		String urlEnv = "";
		switch (StoredVariables.getusernameEnvironment().get()) {
		case "QA":
			urlEnv = "QA";
			break;
		case "Beta":
			urlEnv = "Beta";
			break;
		default:
			urlEnv = "";
		} // end switch
		
		String url = "https://automation"+StoredVariables.getusernameEnvironment().get()+"feeoninvoice1.vmpbilling"+urlEnv+".com/XBilling/Invoicing/Invoice.aspx?PItemID="+pid+"&PIID=&FromGrid=";
		System.out.println("Invoice URL: " + url);
		driver.get(url);
		
		// Get the text of the invoice
		String pdf = driver.findElement(By.id("Form1")).getText();
		
		// Verify the amount paid to the vendor on the invoice matches the order's fee
		System.out.println("amount: " + amount);
		System.out.println("orderFee: " + orderFee);
		Assert.assertTrue(pdf.contains("Default Fee $" + amount + ".00"), "The Default Fee is incorrect. It should be "+amount+" PDF = " + pdf);
		Assert.assertTrue(pdf.contains("Fee paid to Appraiser: $" + orderFee), "The amount paid to the vendor on the invoice does not match the order's fee. It should be "+orderFee+" PDF = " + pdf);
		
		// Log test
		test.log(LogStatus.INFO, "Verify Fee On Invoice", "Verified the fee on the invoice matches the order's fee");
		
	} // end verifyFeeOnInvoiceMatchesOrderFee3
	
} // end the VerifyFeePaidToAppraiserIsCorrectOnTheInvoice class
