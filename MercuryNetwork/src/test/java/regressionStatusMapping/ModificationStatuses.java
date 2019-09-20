package regressionStatusMapping;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Secure.SConfirmOrder;
import pageObjects.Secure.SOrderDetails;
import pageObjects.Secure.SVMPXSites;
import pageObjects.Secure.SVendorSelectionSettings;
import pageObjects.VMP.VMPAppraisalOrderDetails;
import pageObjects.Vendors.VOrderDetails;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Status Mapping - Modification Statuses</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
@Test(singleThreaded=true)
public class ModificationStatuses extends TestSetup {
	
	/** The user secure. */
	private final String userSecure = "RegressionSecure14";
	
	/** The user VMP. */
	private final String userVMP = "OriginatorRegressionSecure14";
	
	/** The user vendors. */
	private final String userVendors = "Appraiser3";
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Click Preferences &gt; Vendor Selection Settings</li>
	 * 	<li>Disable Unattended Order Assignment</li>
	 * 	<li>Disable Unattended Order Reassignment</li>
	 * 	<li>Select Custom fee panel radio button</li>
	 * 	<li>Uncheck Use Mercury Network directory as backup</li>
	 * 	<li>Save</li>
	 * 	<li>Click Preferences &gt; VMP XSites</li>
	 * 	<li>Click Configure Status Mapping</li>
	 * 	<li>Make sure Modification Statuses sync option is unchecked</li>
	 * 	<li>Save</li>
	 * 	<li>From VMP Client Portal, place an order</li>
	 * 	<li>Place order through the API</li>
	 * 	<li>Assign the order to Appraiser3</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Click Assign</li>
	 * 	<li>Assign the order to Appraiser3</li>
	 * 	<li>Check I have read fee notes</li>
	 * 	<li>Click Finish</li>
	 * 	<li>Verify the order shows it being assigned to Appraiser3</li>
	 * 	<li>Accept the order as Appraiser3</li>
	 * 	<li>Login to Vendors as Appraiser3</li>
	 * 	<li>Accept the order</li>
	 * 	<li>Request Modification</li>
	 * 	<li>Verify Modification Requested is in the history</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Agree to the modification</li>
	 * 	<li>Login to Vendors as Appraiser3</li>
	 * 	<li>Open the order</li>
	 * 	<li>Request Modification</li>
	 * 	<li>Verify Modification Requested is in the history</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Do not agree to the modification requested</li>
	 * 	<li>Login to VMP Client Portal</li>
	 * 	<li>Find the new order</li>
	 * 	<li>Open the new order</li>
	 * 	<li>Get history text</li>
	 * 	<li>Confirm the text does not sync when Modification Statuses is not checked to sync to VMP</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Status Mapping", "Secure - Vendor Selection Settings", "Secure - VMP XSite Settings", "VMP - Create Order Via API", "Secure - Orders", "Vendors - Orders", "Vendors - Accept Order", "Vendors - Request Modification", "VMP - Orders"}, alwaysRun=true)
	public void modificationStatusesWithoutSync() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		String password = StoredVariables.getpassword().get();
		
		// Login to Secure
		secure.login(driver, userSecure, password);
		
		// Click Preferences > Vendor Selection Settings
		secure.goToVendorSelectionSettings(driver);
		
		// Disable Unattended Order Assignment
		if(!SVendorSelectionSettings.unattendedOrderAssignment_switch(driver).getAttribute("src").contains("Off.png"))
		{
			perform.click(driver,SVendorSelectionSettings.unattendedOrderAssignment_switch(driver));
		} // end if
		
		// Disable Unattended Order Reassignment
		if(SVendorSelectionSettings.unattendedOrderReassignment_switch(driver).getAttribute("src").contains("On.png"))
		{
			perform.click(driver,SVendorSelectionSettings.unattendedOrderReassignment_switch(driver));
		} // end if
		
		// Select Custom fee panel radio button
		perform.click(driver,SVendorSelectionSettings.customFeePanel_radio(driver));
		
		// Uncheck Use Mercury Network directory as backup
		perform.uncheckCheckbox(driver, SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver));
		
		Thread.sleep(1500);
		
		// Save
		secure.saveVendorSelectionSettings(driver);
		
		// Click Preferences > VMP XSites
		secure.goToVMPXSites(driver);
		
		// Click Configure Status Mapping
		perform.click(driver,SVMPXSites.configureStatusMapping_lnk(driver));
		
		// Wait for Appraiser button
		perform.waitForElementToBeClickable(driver, SVMPXSites.appraiser_btn(), "cssSelector");
		
	    // Make sure Modification Statuses sync option is unchecked
		secure.setStatusMapping(driver, "Modification Statuses", "none");
		
	    // Save
		perform.click(driver, SVMPXSites.save_btn(driver));
	    
	    // Wait for overlay to be hidden
	    perform.waitForOverlayToBeHidden(driver);
		
		// From VMP Client Portal, place an order
		// Place order through the API
		perform.apiPlaceOrderFromVMPClientPortal(driver, userVMP, password, userSecure, "PlaceAppraisalOrderExLenderNoGroups-modificationStatusesWithoutSync");
		String trackingNumber = StoredVariables.gettrackingNumber().get();
		String trackingNumberVMP = StoredVariables.gettrackingNumberVMP().get();
		
		// Assign the order to Appraiser3
		// Login to Secure
		secure.login(driver, userSecure, password);
		
		// Find the order
		secure.findOrder(driver, trackingNumber, "Tracking number");

		// Open the order
		secure.openOrder(driver, trackingNumber);
		
		// Click Assign
		perform.click(driver,SOrderDetails.assign_btn(driver));
		
		// Assign the order to Appraiser3
		try {
			secure.selectVendor(driver, userVendors);
		} catch (Exception e) {
			
			// Click Assign
			perform.click(driver,SOrderDetails.assign_btn(driver));
			
			secure.selectVendor(driver, userVendors);
		} // end try/catch
		
		// Check I have read fee notes
		perform.checkCheckbox(driver, SConfirmOrder.readVendorsFeeNotes_chkbx(driver));
		
		// Click Finish
		perform.click(driver,SConfirmOrder.finishBottom_btn(driver));
		
		// Wait for history to load
		perform.waitForElementToBeClickable(driver, SOrderDetails.history_txt(), "id");
		
		// Verify the order shows it being assigned to Appraiser3
		String history = SOrderDetails.history_txt(driver).getText();
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser3"), "The history does not show the order being assigned to Appraiser3");
		
		// Accept the order as Appraiser3
		// Login to Vendors as Appraiser3
		vendors.login(driver, userVendors, password);
		
		// Accept the order
		vendors.acceptOrder(driver, trackingNumber);
		
		// Request Modification
		vendors.requestModification(driver, "", "", "444", "", "Changing the fee");
		
		// Verify Modification Requested is in the history
		history = VOrderDetails.orderInformation_txt(driver).getText();
		Assert.assertTrue(history.contains("Modification Requested by Appraiser (Automation Appraiser3)"), "The change fee request is not in the history. History = " + history);
		Assert.assertTrue(history.contains("$444.00"), "The change fee request is not in the history. History = " + history);
		Assert.assertTrue(history.contains("Changing the fee"), "The change fee request is not in the history. History = " + history);
		
		// Login to Secure
		secure.login(driver, userSecure, password);
		
		// Find the order
		secure.findOrder(driver, trackingNumber, "Tracking number");

		// Open the order
		secure.openOrder(driver, trackingNumber);
		
		// Agree to the modification
		secure.modificationRequested(driver, true, "Accepting the change fee notes");
		
		// Login to Vendors as Appraiser3
		vendors.login(driver, userVendors, password);
		
		// Open the order
		vendors.findAndOpenOrder(driver, trackingNumber);
		
		// Request Modification
		vendors.requestModification(driver, "", "", "", "PayPal", "Changing the payment method to PayPal");
		
		// Verify Modification Requested is in the history
		history = VOrderDetails.orderInformation_txt(driver).getText();
		Assert.assertTrue(history.contains("Modification Requested by Appraiser (Automation Appraiser3)"), "The change fee request is not in the history");
		Assert.assertTrue(history.contains("PayPal"), "The change fee request is not in the history");
		Assert.assertTrue(history.contains("Changing the payment method to PayPal"), "The change fee request is not in the history");
		
		// Login to Secure
		secure.login(driver, userSecure, password);
		
		// Find the order
		secure.findOrder(driver, trackingNumber, "Tracking number");

		// Open the order
		secure.openOrder(driver, trackingNumber);
		
		// Do not agree to the modification requested
		secure.modificationRequested(driver, false, "Do not agree to changing the payment method to PayPal");
		
		// Login to VMP Client Portal
		vmp.login(driver, userSecure, userVMP, password);
		
		// Find the new order
		vmp.findOrder(driver, trackingNumberVMP, "Tracking #");
		
		// Open the new order
		vmp.openOrder(driver, trackingNumberVMP);
		
		// Wait for the history text
		perform.waitForElementToBeClickable(driver, VMPAppraisalOrderDetails.history_txt(), "id");
		
		// Get history text
		history = VMPAppraisalOrderDetails.history_txt(driver).getText();
		
		// Confirm the text does not sync when Modification Statuses is not checked to sync to VMP
		Assert.assertTrue(!history.contains("Modification Declined by Automation RegressionSecure14"), "The history should reflect the Modification Requested changes");
		Assert.assertTrue(!history.contains("Do not agree to changing the payment method to PayPal"), "The history should reflect the Modification Requested changes");
		Assert.assertTrue(!history.contains("Changing the payment method to PayPal"), "The history should reflect the Modification Requested changes");
		Assert.assertTrue(!history.contains("Modification Accepted by Automation RegressionSecure14"), "The history should reflect the Modification Requested changes");
		Assert.assertTrue(!history.contains("Accepting the change fee notes"), "The history should reflect the Modification Requested changes");
		Assert.assertTrue(!history.contains("Modification Requested by Automation RegressionSecure14"), "The history should reflect the Modification Requested changes");
		Assert.assertTrue(!history.contains("Changing the fee"), "The history should reflect the Modification Requested changes");
		
		// Log test
		test.log(LogStatus.INFO, "Status Mapping Regression Test", "Verified Modification Statuses is working properly and does not show on the VMP order");
		
	} // end modificationStatusesWithoutSync
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Click Preferences &gt; Vendor Selection Settings</li>
	 * 	<li>Disable Unattended Order Assignment</li>
	 * 	<li>Disable Unattended Order Reassignment</li>
	 * 	<li>Select Custom fee panel radio button</li>
	 * 	<li>Uncheck Use Mercury Network directory as backup</li>
	 * 	<li>Save</li>
	 * 	<li>Click Preferences &gt; VMP XSites</li>
	 * 	<li>Click Configure Status Mapping</li>
	 * 	<li>Make sure Modification Statuses sync option is checked</li>
	 * 	<li>Save</li>
	 * 	<li>From VMP Client Portal, place an order</li>
	 * 	<li>Place order through the API</li>
	 * 	<li>Assign the order to Appraiser3</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Click Assign</li>
	 * 	<li>Assign the order to Appraiser3</li>
	 * 	<li>Check I have read fee notes</li>
	 * 	<li>Click Finish</li>
	 * 	<li>Verify the order shows it being assigned to Appraiser3</li>
	 * 	<li>Accept the order as Appraiser3</li>
	 * 	<li>Login to Vendors as Appraiser3</li>
	 * 	<li>Accept the order</li>
	 * 	<li>Request Modification</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify Modification Requested is in the history</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Agree to the modification</li>
	 * 	<li>Login to Vendors as Appraiser3</li>
	 * 	<li>Open the order</li>
	 * 	<li>Request Modification</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify Modification Requested is in the history</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Do not agree to the modification requested</li>
	 * 	<li>Login to VMP Client Portal</li>
	 * 	<li>Find the new order</li>
	 * 	<li>Open the new order</li>
	 * 	<li>Get history text</li>
	 * 	<li>Confirm the text does sync when Modification Statuses is checked to sync to VMP</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Status Mapping", "Secure - Vendor Selection Settings", "Secure - VMP XSite Settings", "VMP - Create Order Via API", "Secure - Orders", "Vendors - Orders", "Vendors - Accept Order", "Vendors - Request Modification", "VMP - Orders"}, alwaysRun=true)
	public void modificationStatusesWithSync() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		String password = StoredVariables.getpassword().get();
		
		// Login to Secure
		secure.login(driver, userSecure, password);
		
		// Click Preferences > Vendor Selection Settings
		secure.goToVendorSelectionSettings(driver);
		
		// Disable Unattended Order Assignment
		if(!SVendorSelectionSettings.unattendedOrderAssignment_switch(driver).getAttribute("src").contains("Off.png"))
		{
			perform.click(driver,SVendorSelectionSettings.unattendedOrderAssignment_switch(driver));
		} // end if
		
		// Disable Unattended Order Reassignment
		if(SVendorSelectionSettings.unattendedOrderReassignment_switch(driver).getAttribute("src").contains("On.png"))
		{
			perform.click(driver,SVendorSelectionSettings.unattendedOrderReassignment_switch(driver));
		} // end if
		
		// Select Custom fee panel radio button
		perform.click(driver,SVendorSelectionSettings.customFeePanel_radio(driver));
		
		// Uncheck Use Mercury Network directory as backup
		perform.uncheckCheckbox(driver, SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver));
		
		Thread.sleep(1500);
		
		// Save
		secure.saveVendorSelectionSettings(driver);
		
		// Click Preferences > VMP XSites
		secure.goToVMPXSites(driver);
		
		// Click Configure Status Mapping
		perform.click(driver,SVMPXSites.configureStatusMapping_lnk(driver));
		
		// Wait for Appraiser button
		perform.waitForElementToBeClickable(driver, SVMPXSites.appraiser_btn(), "cssSelector");
		
	    // Make sure Modification Statuses sync option is checked
		secure.setStatusMapping(driver, "Modification Statuses", "both");
		
	    // Save
		perform.click(driver, SVMPXSites.save_btn(driver));
	    
	    // Wait for overlay to be hidden
	    perform.waitForOverlayToBeHidden(driver);
		
		// From VMP Client Portal, place an order
		// Place order through the API
		perform.apiPlaceOrderFromVMPClientPortal(driver, userVMP, password, userSecure, "PlaceAppraisalOrderExLenderNoGroups-modificationStatusesWithSync");
		String trackingNumber = StoredVariables.gettrackingNumber().get();
		String trackingNumberVMP = StoredVariables.gettrackingNumberVMP().get();
		
		// Assign the order to Appraiser3
		// Login to Secure
		secure.login(driver, userSecure, password);
		
		// Find the order
		secure.findOrder(driver, trackingNumber, "Tracking number");

		// Open the order
		secure.openOrder(driver, trackingNumber);
		
		// Click Assign
		perform.click(driver,SOrderDetails.assign_btn(driver));

		// Assign the order to Appraiser3
		secure.selectVendor(driver, userVendors);
		
		// Check I have read fee notes
		perform.checkCheckbox(driver, SConfirmOrder.readVendorsFeeNotes_chkbx(driver));
		
		// Click Finish
		perform.click(driver,SConfirmOrder.finishBottom_btn(driver));
		
		// Wait for history to load
		perform.waitForElementToBeClickable(driver, SOrderDetails.history_txt(), "id");
		
		// Verify the order shows it being assigned to Appraiser3
		String history = SOrderDetails.history_txt(driver).getText();
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser3"), "The history does not show the order being assigned to Appraiser3");
		
		// Accept the order as Appraiser3
		// Login to Vendors as Appraiser3
		vendors.login(driver, userVendors, password);
		
		// Accept the order
		vendors.acceptOrder(driver, trackingNumber);
		
		// Request Modification
		vendors.requestModification(driver, "", "", "444", "", "Changing the fee");
		
		// Get history text
		history = VOrderDetails.orderInformation_txt(driver).getText();
		
		// Verify Modification Requested is in the history
		Assert.assertTrue(history.contains("Modification Requested by Appraiser (Automation Appraiser3)"), "The change fee request is not in the history");
		Assert.assertTrue(history.contains("$444.00"), "The change fee request is not in the history");
		Assert.assertTrue(history.contains("Changing the fee"), "The change fee request is not in the history");
		
		// Login to Secure
		secure.login(driver, userSecure, password);
		
		// Find the order
		secure.findOrder(driver, trackingNumber, "Tracking number");

		// Open the order
		secure.openOrder(driver, trackingNumber);
		
		// Agree to the modification
		secure.modificationRequested(driver, true, "Accepting the change fee notes");
		
		// Login to Vendors as Appraiser3
		vendors.login(driver, userVendors, password);
		
		// Open the order
		vendors.findAndOpenOrder(driver, trackingNumber);
		
		// Request Modification
		vendors.requestModification(driver, "", "", "", "PayPal", "Changing the payment method to PayPal");
		
		// Get history text
		history = VOrderDetails.orderInformation_txt(driver).getText();
		
		// Verify Modification Requested is in the history
		Assert.assertTrue(history.contains("Modification Requested by Appraiser (Automation Appraiser3)"), "The change fee request is not in the history");
		Assert.assertTrue(history.contains("PayPal"), "The change fee request is not in the history");
		Assert.assertTrue(history.contains("Changing the payment method to PayPal"), "The change fee request is not in the history");
		
		// Login to Secure
		secure.login(driver, userSecure, password);
		
		// Find the order
		secure.findOrder(driver, trackingNumber, "Tracking number");

		// Open the order
		secure.openOrder(driver, trackingNumber);

		// Do not agree to the modification requested
		secure.modificationRequested(driver, false, "Do not agree to changing the payment method to PayPal");
		
		// Login to VMP Client Portal
		vmp.login(driver, userSecure, userVMP, password);
		
		// Find the new order
		vmp.findOrder(driver, trackingNumberVMP, "Tracking #");
		
		// Open the new order
		vmp.openOrder(driver, trackingNumberVMP);
		
		// Wait for the history text
		perform.waitForElementToBeClickable(driver, VMPAppraisalOrderDetails.history_txt(), "id");
		
		// Get history text
		history = VMPAppraisalOrderDetails.history_txt(driver).getText();
		
		// Confirm the text does sync when Modification Statuses is checked to sync to VMP
		Assert.assertTrue(history.contains("Modification Declined by Automation RegressionSecure14"), "The history should reflect the Modification Requested changes");
		Assert.assertTrue(history.contains("Do not agree to changing the payment method to PayPal"), "The history should reflect the Modification Requested changes");
		Assert.assertTrue(history.contains("Changing the payment method to PayPal"), "The history should reflect the Modification Requested changes");
		Assert.assertTrue(history.contains("Modification Accepted by Automation RegressionSecure14"), "The history should reflect the Modification Requested changes");
		Assert.assertTrue(history.contains("Accepting the change fee notes"), "The history should reflect the Modification Requested changes");
		Assert.assertTrue(history.contains("Modification Requested by Automation RegressionSecure14"), "The history should reflect the Modification Requested changes");
		Assert.assertTrue(history.contains("Changing the fee"), "The history should reflect the Modification Requested changes");
		
		// Log test
		test.log(LogStatus.INFO, "Status Mapping Regression Test", "Verified Modification Statuses is working properly and does show on the VMP order");
		
	} // end modificationStatusesWithSync
	
} // end the RequiresReassignmentStatusMapping class
