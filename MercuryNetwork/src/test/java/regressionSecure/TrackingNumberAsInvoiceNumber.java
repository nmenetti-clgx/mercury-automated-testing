package regressionSecure;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Secure.SClientGroups_Details;
import pageObjects.Secure.SClients;
import pageObjects.Secure.SClients_ClientGroups;
import pageObjects.Secure.SOrderDetails;
import pageObjects.Secure.SVMPXSites;
import pageObjects.VMP.VMPConfirmOrder;
import pageObjects.VMP.VMPNewOrder;
import pageObjects.VMP.VMPOrders;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Secure - Tracking Number As Invoice Number</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
@Test(singleThreaded=true)
public class TrackingNumberAsInvoiceNumber extends TestSetup {
	
	/** The user secure. */
	private final String userSecure = "Invoice1";
	
	/** The user VMP. */
	private final String userVMP = "OriginatorInvoice1";
	
	/** The user VMP 2. */
	private final String userVMP2 = "OriginatorInvoice2";
	
	/** The user vendors. */
	private final String userVendors = "InvoiceAppraiser1";
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Go to VMPXSites</li>
	 * 	<li>Click Automatic Settings</li>
	 * 	<li>Uncheck 'Use tracking number'</li>
	 * 	<li>Verify Prefix and Start Number Sequence is enabled</li>
	 * 	<li>Check Use tracking number</li>
	 * 	<li>Verify Prefix and Start Number Sequence is disabled</li>
	 * 	<li>Save settings</li>
	 * 	<li>Create an order</li>
	 * 	<li>Get the invoice number</li>
	 * 	<li>Set the tracking number</li>
	 * 	<li>Verify the Invoice number is the same as the tracking number</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - VMP XSite Settings", "VMP - Create Order", "Secure - Orders"}, alwaysRun=true)
	public void trackingNumberAsInvoiceNumberWhenCheckedGlobally() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Login to Secure
		secure.login(driver, userSecure, StoredVariables.getpassword().get());
		
		// Go to VMPXSites
		secure.goToVMPXSites(driver);
		
		// Click Automatic Settings
		perform.click(driver,SVMPXSites.configureAutomaticSettings_lnk(driver));
		
		// Wait for Use tracking number checkbox (Verify 'Use tracking number' is available)
		perform.waitForElementToBeClickable(driver, SVMPXSites.useTrackingNumber_chckbx(), "id");

		// Uncheck 'Use tracking number'
		perform.uncheckCheckbox(driver, SVMPXSites.useTrackingNumber_chckbx(driver));

		// Verify Prefix and Start Number Sequence is enabled
		boolean value1 = SVMPXSites.prefix_txtbx(driver).getAttribute("disabled") == null;
		boolean value2 = SVMPXSites.startNumberSequence_txtbx(driver).getAttribute("disabled") == null;
		Assert.assertTrue(value1==true, "The Prefix field should be enabled");
		Assert.assertTrue(value2==true, "The Start Number Sequence field should be enabled");
		
		// Check Use tracking number
		perform.checkCheckbox(driver, SVMPXSites.useTrackingNumber_chckbx(driver));
		
		// Verify Prefix and Start Number Sequence is disabled
		String value3 = SVMPXSites.prefix_txtbx(driver).getAttribute("disabled");
		String value4 = SVMPXSites.startNumberSequence_txtbx(driver).getAttribute("disabled");
		Assert.assertTrue(value3.equals("true"), "The Prefix field should be disabled");
		Assert.assertTrue(value4.equals("true"), "The Start Number Sequence field should be disabled");
		
		// Save settings
		secure.saveVMPXSiteSettings(driver);
		
		// Create an order
		createVMPOrderAndAssignItToAnAppraiser(driver, userVMP2);
		
		// Get the invoice number
		String invoiceNumber = secure.getInvoiceNumber(driver, StoredVariables.getloanID().get());
		
		// Set the tracking number
		String trackingNumber = StoredVariables.gettrackingNumberVMP().get();
		
		// Verify the Invoice number is the same as the tracking number
		Assert.assertTrue(invoiceNumber.equals(trackingNumber), "The invoice number should be the same as the tracking number. Invoice Number = " + invoiceNumber + " The Tracking Number is = " + trackingNumber);
		
		// Log test
		test.log(LogStatus.INFO, "Secure Regression Test", "Verified that the invoice number is the same as the tracking number if the checkbox is checked globally");
		
	} // end trackingNumberAsInvoiceNumberWhenCheckedGlobally
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Go to VMPXSites</li>
	 * 	<li>Click Automatic Settings</li>
	 * 	<li>Uncheck 'Use tracking number'</li>
	 * 	<li>Save settings</li>
	 * 	<li>Go to Clients</li>
	 * 	<li>Click Client Groups</li>
	 * 	<li>Click Manage Client Groups</li>
	 * 	<li>Click on Test Client Group Name</li>
	 * 	<li>Click the Automated tab</li>
	 * 	<li>Click Customize your invoice number link</li>
	 * 	<li>Check Use tracking number</li>
	 * 	<li>Click OK</li>
	 * 	<li>Save Client Group Settings</li>
	 * 	<li>Create an order</li>
	 * 	<li>Get the invoice number</li>
	 * 	<li>Set the tracking number</li>
	 * 	<li>Verify the Invoice number is the same as the tracking number</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Clients", "Secure - Client Groups", "Secure - VMP XSite Settings", "VMP - Create Order", "Secure - Orders"}, alwaysRun=true)
	public void trackingNumberAsInvoiceNumberWhenCheckedForClientGroup() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Login to Secure
		secure.login(driver, userSecure, StoredVariables.getpassword().get());
		
		// Go to VMPXSites
		secure.goToVMPXSites(driver);
		
		// Click Automatic Settings
		perform.click(driver,SVMPXSites.configureAutomaticSettings_lnk(driver));
		
		// Wait for Use tracking number checkbox (Verify 'Use tracking number' is available)
		perform.waitForElementToBeClickable(driver, SVMPXSites.useTrackingNumber_chckbx(), "id");

		// Uncheck 'Use tracking number'
		perform.uncheckCheckbox(driver, SVMPXSites.useTrackingNumber_chckbx(driver));

		// Save settings
		secure.saveVMPXSiteSettings(driver);
		
		// Go to Clients
		secure.goToClients(driver);
		
		// Click Client Groups
		perform.click(driver,SClients.clientGroups_btn(driver));
		
		// Click Manage Client Groups
		perform.clickInDiv_Contains(driver, "Manage Client Groups...");
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Switch into iFrame
		perform.switchToiFrameByID(driver, "frameDialogL1");
		
		// Click on Test Client Group Name
		perform.doubleClickInTable(driver, "AutomationInvoiceClientGroup");
		
		// Switch into iFrame
		driver.switchTo().defaultContent();
		perform.switchToiFrameByID(driver, "frameDialogL1");
		
		// Wait for Company textbox
		perform.waitForElementToBeClickable(driver, SClientGroups_Details.company_txtbx(), "id");
		
		// Click the Automated tab
		perform.click(driver,SClients_ClientGroups.automated_btn(driver));
		
		// Wait for Customize your invoice number and due date options
		perform.waitForElementToBeClickable(driver, SClients_ClientGroups.customizeYourInvoiceNumber_link(), "id");
		
		// Click Customize your invoice number link
		perform.click(driver,SClients_ClientGroups.customizeYourInvoiceNumber_link(driver));
		
		// Wait for Use tracking number checkbox
		perform.waitForElementToBeClickable(driver, SClients_ClientGroups.useTrackingNumber_chckbx(), "id");
		
		// Check Use tracking number
		perform.checkCheckbox(driver, SClients_ClientGroups.useTrackingNumber_chckbx(driver));
		
		// Click OK
		perform.click(driver,SClients_ClientGroups.ok_btn(driver));
		
		// Save Client Group Settings
		secure.saveClientGroupSettings(driver);
		
		// Create an order
		createVMPOrderAndAssignItToAnAppraiser(driver, userVMP);
		
		// Get the invoice number
		String invoiceNumber = secure.getInvoiceNumber(driver, StoredVariables.getloanID().get());
		
		// Set the tracking number
		String trackingNumber = StoredVariables.gettrackingNumberVMP().get();
		
		// Verify the Invoice number is the same as the tracking number
		Assert.assertTrue(invoiceNumber.equals(trackingNumber), "The invoice number should be the same as the tracking number. Invoice Number = " + invoiceNumber + " The Tracking Number is = " + trackingNumber);
		
		// Log test
		test.log(LogStatus.INFO, "Secure Regression Test", "Verified that the invoice number is the same as the tracking number if the checkbox is checked for the Client Group");
		
	} // end trackingNumberAsInvoiceNumberWhenCheckedForClientGroup
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Go to VMPXSites</li>
	 * 	<li>Click Automatic Settings</li>
	 * 	<li>Uncheck 'Use tracking number'</li>
	 * 	<li>Save settings</li>
	 * 	<li>Create an order</li>
	 * 	<li>Get the invoice number</li>
	 * 	<li>Set the tracking number</li>
	 * 	<li>Verify the Invoice number is the same as the tracking number</li>
	 * 	<li>Log test</li>
	 * 	<li>Log into the Lender's VMP Client portal</li>
	 * 	<li>Place a new order, make sure to attach documents to the order BEFORE finishing it</li>
	 * 	<li>Set variables</li>
	 * 	<li>Go to New Order</li>
	 * 	<li>Enter order details</li>
	 * 	<li>Click Next</li>
	 * 	<li>Save the order</li>
	 * 	<li>Click Finished</li>
	 * 	<li>Click OK</li>
	 * 	<li>Get order numbers</li>
	 * 	<li>Log into Secure as the Lender</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Click Assign</li>
	 * 	<li>Assign the vendor</li>
	 * 	<li>Click Finish</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - VMP XSite Settings", "VMP - Create Order", "Secure - Orders"}, alwaysRun=true)
	public void trackingNumberIsNotTheSameAsInvoiceNumberWhenUnchecked() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Login to Secure
		secure.login(driver, userSecure, StoredVariables.getpassword().get());
		
		// Go to VMPXSites
		secure.goToVMPXSites(driver);
		
		// Click Automatic Settings
		perform.click(driver,SVMPXSites.configureAutomaticSettings_lnk(driver));
		
		// Wait for Use tracking number checkbox (Verify 'Use tracking number' is available)
		perform.waitForElementToBeClickable(driver, SVMPXSites.useTrackingNumber_chckbx(), "id");

		// Uncheck 'Use tracking number'
		perform.uncheckCheckbox(driver, SVMPXSites.useTrackingNumber_chckbx(driver));

		// Save settings
		secure.saveVMPXSiteSettings(driver);
		
		// Create an order
		createVMPOrderAndAssignItToAnAppraiser(driver, userVMP2);
		
		// Get the invoice number
		String invoiceNumber = secure.getInvoiceNumber(driver, StoredVariables.getloanID().get());
		
		// Set the tracking number
		String trackingNumber = StoredVariables.gettrackingNumberVMP().get();
		
		// Verify the Invoice number is the same as the tracking number
		Assert.assertTrue(!invoiceNumber.equals(trackingNumber), "The invoice number should not be the same as the tracking number. Invoice Number = " + invoiceNumber + " The Tracking Number is = " + trackingNumber);
		
		// Log test
		test.log(LogStatus.INFO, "Secure Regression Test", "Verified that the invoice number is not the same as the tracking number if the checkbox is unchecked");
		
	} // end trackingNumberIsNotTheSameAsInvoiceNumberWhenUnchecked
	
	/**
	 * Creates the VMP order and assign it to an appraiser.
	 *
	 * @param driver the driver
	 * @param user the user
	 * @throws Exception the exception
	 */
	private void createVMPOrderAndAssignItToAnAppraiser(RemoteWebDriver driver, String user) throws Exception {
		
		// Log into the Lender's VMP Client portal
		vmp.login(driver, userSecure, user, StoredVariables.getpassword().get());
		
		// Place a new order, make sure to attach documents to the order BEFORE finishing it
		// Set variables
		vmp.setMinimumVariables(driver);
		StoredVariables.getadditionalNotificationRecipientsAdditionalEmails().set("additionalEmail@dntest.net");
		
		// Go to New Order
		vmp.goToNewOrder(driver);
		
		// Enter order details
		vmp.enterNewOrder(driver);
		
		// Click Next
		perform.click(driver,VMPNewOrder.nextBottom_btn(driver));
		
		// Save the order
		vmp.saveNewOrder(driver);
		
		// Click Finished
		perform.click(driver,VMPConfirmOrder.finished_btn(driver));
		
		// Switch out of iFrame
		driver.switchTo().defaultContent();
		
		// Click OK
		perform.click(driver,VMPConfirmOrder.ok_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Wait for Find textbox
		perform.waitForElementToBeClickable(driver, VMPOrders.find_txtbx(), "id");
		
		// Get order numbers
		db.getLoanIDsFromVMPClientPortalOrder(driver);
		
		// Log into Secure as the Lender
		secure.login(driver, userSecure, StoredVariables.getpassword().get());
		
		// Find the order
		secure.findOrder(driver, StoredVariables.getloanID().get(), "Tracking number");
		
		// Open the order
		secure.openOrder(driver, StoredVariables.getloanID().get());
		
		// Click Assign
		perform.click(driver,SOrderDetails.assign_btn(driver));
		
		// Assign the vendor
		secure.selectVendor(driver, userVendors);
		
		// Click Finish
		perform.click(driver,SOrderDetails.finish_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for attach button
		perform.waitForElementToBeClickable(driver, SOrderDetails.viewXSiteOrder_lnk(), "id");
		
	} // end createVMPOrderAndAssignItToAnAppraiser
	
} // end the TrackingNumberAsInvoiceNumber class
