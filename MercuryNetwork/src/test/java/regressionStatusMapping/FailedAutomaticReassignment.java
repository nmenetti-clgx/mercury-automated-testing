package regressionStatusMapping;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Secure.SConfirmOrder;
import pageObjects.Secure.SModifySelectionSettings;
import pageObjects.Secure.SOrderDetails;
import pageObjects.Secure.SVMPXSites;
import pageObjects.Secure.SVendorSelection;
import pageObjects.Secure.SVendorSelectionSettings;
import pageObjects.VMP.VMPAppraisalOrderDetails;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Status Mapping - Failed Automatic Reassignment</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
@Test(singleThreaded=true)
public class FailedAutomaticReassignment extends TestSetup {
	
	/** The user secure. */
	private final String userSecure = "RegressionSecure12";
	
	/** The user VMP. */
	private final String userVMP = "OriginatorRegressionSecure12";
	
	/** The user vendors. */
	private final String userVendors = "Appraiser3";
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Go to Preferences &gt; VMP XSites</li>
	 * 	<li>Click Configure Order Form</li>
	 * 	<li>Check to provide Disclosure tracking</li>
	 * 	<li>Save</li>
	 * 	<li>Click Configure Status Mapping</li>
	 * 	<li>Disable Requires Reassignment to sync</li>
	 * 	<li>Click Save</li>
	 * 	<li>Click Preferences &gt; Vendor Selection Settings</li>
	 * 	<li>Disable Unattended Order Assignment</li>
	 * 	<li>Enable Unattended Order Reassignment</li>
	 * 	<li>Select Custom fee panel radio button</li>
	 * 	<li>Uncheck Use Mercury Network directory as backup</li>
	 * 	<li>Save</li>
	 * 	<li>From VMP Client Portal, place an order without a disclosure date included</li>
	 * 	<li>Place order through the API</li>
	 * 	<li>Order should fail the initial automatic assignment</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Click Modify selection settings button</li>
	 * 	<li>Check Enforce Vendor Priority</li>
	 * 	<li>Uncheck Consider unranked vendors</li>
	 * 	<li>Click OK</li>
	 * 	<li>Click Assign</li>
	 * 	<li>Check for related orders</li>
	 * 	<li>Choose Appraiser3</li>
	 * 	<li>Click Next</li>
	 * 	<li>Check read vendors fee notes checkbox</li>
	 * 	<li>Click Finish</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify history contains waiting acceptance by Automation Appraiser3</li>
	 * 	<li>Login to Vendors as Appraiser3</li>
	 * 	<li>Decline the order</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify history contains failed reassignment text</li>
	 * 	<li>Login to VMP Client Portal</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Get history text</li>
	 * 	<li>Confirm the item does not sync when not checked</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Status Mapping", "Secure - VMP XSite Settings", "Secure - Configure Status Mapping", "Secure - Vendor Selection Settings", "VMP - Create Order Via API", "Secure - Orders", "Secure - Modify Selection Settings", "Vendors - Orders", "Vendor - Decline Order", "VMP - Orders"}, alwaysRun=true)
	public void failedAutomaticReassignmentWithoutSync() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		String password = StoredVariables.getpassword().get();
		
		// Login to Secure
		secure.login(driver, userSecure, password);
		
		// Go to Preferences > VMP XSites
		secure.goToVMPXSites(driver);
		
		// Click Configure Order Form
		perform.click(driver,SVMPXSites.configureOrderForm_lnk(driver));
		
		// Wait for Provide Disclosure tracking checkbox
		perform.waitForElementToBeClickable(driver, SVMPXSites.providesDisclosureTracking_chkbx(), "id");
		
		// Check to provide Disclosure tracking
		perform.uncheckCheckbox(driver, SVMPXSites.providesDisclosureTracking_chkbx(driver));
		
		// Save
		secure.saveVMPXSiteSettings(driver);
		
		// Click Configure Status Mapping
		perform.click(driver,SVMPXSites.configureStatusMapping_lnk(driver));
		
		// Wait for Appraiser button
		perform.waitForElementToBeClickable(driver, SVMPXSites.appraiser_btn(), "cssSelector");
		
		// Disable Requires Reassignment to sync
		secure.setStatusMapping(driver, "Requires Reassignment", "none");
		
		// Click Save
		perform.click(driver,SVMPXSites.save_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Click Preferences > Vendor Selection Settings
		secure.goToVendorSelectionSettings(driver);
		
		// Disable Unattended Order Assignment
		if(SVendorSelectionSettings.unattendedOrderAssignment_switch(driver).getAttribute("src").contains("On.png"))
		{
			perform.click(driver,SVendorSelectionSettings.unattendedOrderAssignment_switch(driver));
		} // end if
		
		// Enable Unattended Order Reassignment
		if(SVendorSelectionSettings.unattendedOrderReassignment_switch(driver).getAttribute("src").contains("Off.png"))
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
		
		// From VMP Client Portal, place an order without a disclosure date included
		// Place order through the API
		perform.apiPlaceOrderFromVMPClientPortal(driver, userVMP, password, userSecure, "PlaceAppraisalOrderExLenderNoGroups-failedAutomaticReassignmentWithoutSync");
		String trackingNumber = StoredVariables.gettrackingNumber().get();
		String trackingNumberVMP = StoredVariables.gettrackingNumberVMP().get();
		
		// Order should fail the initial automatic assignment
		// Login to Secure
		secure.login(driver, userSecure, password);
		
		// Find the order
		secure.findOrder(driver, trackingNumber, "Tracking number");

		// Open the order
		secure.openOrder(driver, trackingNumber);
		
		// Click Modify selection settings button
		perform.click(driver,SOrderDetails.modifySelectionSettings_btn(driver));
		
		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for Require valid license
		perform.waitForElementToBeClickable(driver, SModifySelectionSettings.requireValidLicense_chkbx(), "id");
		
		// Check Enforce Vendor Priority
		perform.checkCheckbox(driver, SModifySelectionSettings.enforceVendorPriority_chkbx(driver));
		
		// Uncheck Consider unranked vendors
		perform.uncheckCheckbox(driver, SModifySelectionSettings.considerUnrankedVendors_chkbx(driver));
		
		// Click OK
		perform.click(driver,SModifySelectionSettings.okPreVendorSelect_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Click Assign
		perform.click(driver,SOrderDetails.assign_btn(driver));
		
		// Check for related orders
		secure.checkForRelatedOrdersDialog(driver);
		
		// Choose Appraiser3
		perform.clickInTable_Contains(driver, userVendors);
		
		// Click Next
		perform.click(driver,SVendorSelection.nextTop_btn(driver));
		
		// Wait for the I have read vendor fee notes checkbox
		perform.waitForElementToBeClickable(driver, SConfirmOrder.readVendorsFeeNotes_chkbx(), "id");
		
		// Check read vendors fee notes checkbox
		perform.checkCheckbox(driver, SConfirmOrder.readVendorsFeeNotes_chkbx(driver));
		
		// Click Finish
		perform.click(driver,SConfirmOrder.finishBottom_btn(driver));
		
		// Wait for history
		perform.waitForElementToBeClickable(driver, SOrderDetails.history_txt(), "id");
		
		// Get history text
		String history = SOrderDetails.history_txt(driver).getText();
		
		// Verify history contains waiting acceptance by Automation Appraiser3
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser3"), "The order should be waiting acceptance by Appraiser3");
		Assert.assertTrue(history.contains("Reassigned by Client (Automation RegressionSecure12) to Automation Appraiser3"), "The order should have been reassigned to Appraiser3");
		
		// Login to Vendors as Appraiser3
		vendors.login(driver, userVendors, password);
		
		// Decline the order 
		vendors.declineOrder(driver, trackingNumber);
		
		// Login to Secure
		secure.login(driver, userSecure, password);
		
		// Find the order
		secure.findOrder(driver, trackingNumber, "Tracking number");

		// Open the order
		secure.openOrder(driver, trackingNumber);
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify history contains failed reassignment text
		Assert.assertTrue(history.contains("Automatic order reassignment failed"), "The history should reflect the failed reassignment");
		Assert.assertTrue(history.contains("There were no appraisers returned matching the property address and selection criteria or fees you have configured."), "The history should reflect there were no matching appraisers");
		
		// Login to VMP Client Portal
		vmp.login(driver, userSecure, userVMP, password);
		
		// Find the order
		vmp.findOrder(driver, trackingNumberVMP, "Tracking #");
		
		// Open the order
		vmp.openOrder(driver, trackingNumberVMP);
		
		// Get history text
		history = VMPAppraisalOrderDetails.history_txt(driver).getText();
		
		// Confirm the item does not sync when not checked
		Assert.assertTrue(!history.contains("Requires Reassignment by Automation RegressionSecure11"), "The history should not reflect the failed reassignment");
		Assert.assertTrue(!history.contains("There were no appraisers returned matching the property address and selection criteria or fees you have configured."), "The history should not reflect there were no matching appraisers");
		
		// Log test
		test.log(LogStatus.INFO, "Status Mapping Regression Test", "Verified failed automatic reassignment is working properly and does not show on the VMP order");
		
	} // end failedAutomaticReassignmentWithoutSync
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Go to Preferences &gt; VMP XSites</li>
	 * 	<li>Click Configure Order Form</li>
	 * 	<li>Check to provide Disclosure tracking</li>
	 * 	<li>Save</li>
	 * 	<li>Click Configure Status Mapping</li>
	 * 	<li>Enable Requires Reassignment to sync</li>
	 * 	<li>Verify sync is checked</li>
	 * 	<li>Click Save</li>
	 * 	<li>Verify sync is checked</li>
	 * 	<li>Click Preferences &gt; Vendor Selection Settings</li>
	 * 	<li>Disable Unattended Order Assignment</li>
	 * 	<li>Enable Unattended Order Reassignment</li>
	 * 	<li>Select Custom fee panel radio button</li>
	 * 	<li>Uncheck Use Mercury Network directory as backup</li>
	 * 	<li>Save</li>
	 * 	<li>From VMP Client Portal, place an order without a disclosure date included</li>
	 * 	<li>Place order through the API</li>
	 * 	<li>Order should fail the initial automatic assignment</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Click Modify selection settings button</li>
	 * 	<li>Check Enforce Vendor Priority</li>
	 * 	<li>Uncheck Consider unranked vendors</li>
	 * 	<li>Click OK</li>
	 * 	<li>Click Assign</li>
	 * 	<li>Check for related orders</li>
	 * 	<li>Choose Appraiser3</li>
	 * 	<li>Click Next</li>
	 * 	<li>Check read vendors fee notes checkbox</li>
	 * 	<li>Click Finish</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify history contains waiting acceptance by Automation Appraiser3</li>
	 * 	<li>Login to Vendors as Appraiser3</li>
	 * 	<li>Decline the order</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify history contains failed reassignment text</li>
	 * 	<li>Login to VMP Client Portal</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Get history text</li>
	 * 	<li>Set 40 second while loop timeout</li>
	 * 	<li>Confirm the item does sync when not checked</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Status Mapping", "Secure - VMP XSite Settings", "Secure - Configure Status Mapping", "Secure - Vendor Selection Settings", "VMP - Create Order Via API", "Secure - Orders", "Secure - Modify Selection Settings", "Vendors - Orders", "Vendor - Decline Order", "VMP - Orders"}, alwaysRun=true)
	public void failedAutomaticReassignmentWithSync() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		String password = StoredVariables.getpassword().get();
		
		// Login to Secure
		secure.login(driver, userSecure, password);
		
		// Go to Preferences > VMP XSites
		secure.goToVMPXSites(driver);
		
		// Click Configure Order Form
		perform.click(driver,SVMPXSites.configureOrderForm_lnk(driver));
		
		// Wait for Provide Disclosure tracking checkbox
		perform.waitForElementToBeClickable(driver, SVMPXSites.providesDisclosureTracking_chkbx(), "id");
		
		// Check to provide Disclosure tracking
		perform.uncheckCheckbox(driver, SVMPXSites.providesDisclosureTracking_chkbx(driver));
		
		// Save
		secure.saveVMPXSiteSettings(driver);
		
		// Click Configure Status Mapping
		perform.click(driver,SVMPXSites.configureStatusMapping_lnk(driver));
		
		// Wait for Appraiser button
		perform.waitForElementToBeClickable(driver, SVMPXSites.appraiser_btn(), "cssSelector");
		
		// Enable Requires Reassignment to sync
		secure.setStatusMapping(driver, "Requires Reassignment", "both");
		
		// Verify sync is checked
		WebElement element = secure.getStatusMappingElement(driver, "Requires Reassignment", "left");
		Assert.assertTrue(element.getAttribute("style").contains("visible"), "The Requires Reassignment sync option is not checked");
		
		// Click Save
		perform.click(driver,SVMPXSites.save_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Verify sync is checked
		element = secure.getStatusMappingElement(driver, "Requires Reassignment", "left");
		Assert.assertTrue(element.getAttribute("style").contains("visible"), "The Requires Reassignment sync option is not checked");
		
		// Click Preferences > Vendor Selection Settings
		secure.goToVendorSelectionSettings(driver);
		
		// Disable Unattended Order Assignment
		if(SVendorSelectionSettings.unattendedOrderAssignment_switch(driver).getAttribute("src").contains("On.png"))
		{
			perform.click(driver,SVendorSelectionSettings.unattendedOrderAssignment_switch(driver));
		} // end if
		
		// Enable Unattended Order Reassignment
		if(SVendorSelectionSettings.unattendedOrderReassignment_switch(driver).getAttribute("src").contains("Off.png"))
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
		
		// From VMP Client Portal, place an order without a disclosure date included
		// Place order through the API
		perform.apiPlaceOrderFromVMPClientPortal(driver, userVMP, password, userSecure, "PlaceAppraisalOrderExLenderNoGroups-failedAutomaticReassignmentWithoutSync");
		String trackingNumber = StoredVariables.gettrackingNumber().get();
		
		// Order should fail the initial automatic assignment
		// Login to Secure
		secure.login(driver, userSecure, password);
		
		// Find the order
		secure.findOrder(driver, trackingNumber, "Tracking number");

		// Open the order
		secure.openOrder(driver, trackingNumber);
		
		// Click Modify selection settings button
		perform.click(driver,SOrderDetails.modifySelectionSettings_btn(driver));
		
		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for Require valid license
		perform.waitForElementToBeClickable(driver, SModifySelectionSettings.requireValidLicense_chkbx(), "id");
		
		// Check Enforce Vendor Priority
		perform.checkCheckbox(driver, SModifySelectionSettings.enforceVendorPriority_chkbx(driver));
		
		// Uncheck Consider unranked vendors
		perform.uncheckCheckbox(driver, SModifySelectionSettings.considerUnrankedVendors_chkbx(driver));
		
		// Click OK
		perform.click(driver,SModifySelectionSettings.okPreVendorSelect_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Click Assign
		perform.click(driver,SOrderDetails.assign_btn(driver));
		
		// Check for related orders
		secure.checkForRelatedOrdersDialog(driver);
		
		// Choose Appraiser3
		perform.clickInTable_Contains(driver, userVendors);
		
		// Click Next
		perform.click(driver,SVendorSelection.nextTop_btn(driver));
		
		// Wait for the I have read vendor fee notes checkbox
		perform.waitForElementToBeClickable(driver, SConfirmOrder.readVendorsFeeNotes_chkbx(), "id");
		
		// Check read vendors fee notes checkbox
		perform.checkCheckbox(driver, SConfirmOrder.readVendorsFeeNotes_chkbx(driver));
		
		// Click Finish
		perform.click(driver,SConfirmOrder.finishBottom_btn(driver));
		
		// Wait for history
		perform.waitForElementToBeClickable(driver, SOrderDetails.history_txt(), "id");
		
		// Get history text
		String history = SOrderDetails.history_txt(driver).getText();
		
		// Verify history contains waiting acceptance by Automation Appraiser3
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser3"), "The order should be waiting acceptance by Appraiser3");
		Assert.assertTrue(history.contains("Reassigned by Client (Automation RegressionSecure12) to Automation Appraiser3"), "The order should have been reassigned to Appraiser3");
		
		// Login to Vendors as Appraiser3
		vendors.login(driver, userVendors, password);
		
		// Decline the order 
		vendors.declineOrder(driver, trackingNumber);
		
		// Login to Secure
		secure.login(driver, userSecure, password);
		
		// Find the order
		secure.findOrder(driver, trackingNumber, "Tracking number");

		// Open the order
		secure.openOrder(driver, trackingNumber);
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify history contains failed reassignment text
		Assert.assertTrue(history.contains("Automatic order reassignment failed"), "The history should reflect the failed reassignment");
		Assert.assertTrue(history.contains("There were no appraisers returned matching the property address and selection criteria or fees you have configured."), "The history should reflect there were no matching appraisers");
		
		// Login to VMP Client Portal
		vmp.login(driver, userSecure, userVMP, password);
		
		// Find the order
		vmp.findOrder(driver, StoredVariables.getloanIDVMP().get(), "Tracking #");
		
		// Open the order
		vmp.openOrder(driver, StoredVariables.getloanIDVMP().get());
		
		// Get history text
		history = VMPAppraisalOrderDetails.history_txt(driver).getText();
		
		// Set 40 second while loop timeout
		long start_time = System.currentTimeMillis();
		long wait_time = 40000;
		long end_time = start_time + wait_time;
		while (System.currentTimeMillis() < end_time && !history.contains("Requires Reassignment by Automation RegressionSecure12")){
 			driver.navigate().refresh();
			perform.waitForElementToBeClickable(driver, VMPAppraisalOrderDetails.history_txt(), "id");
			history = VMPAppraisalOrderDetails.history_txt(driver).getText();
			if (history.contains("Requires Reassignment by Automation RegressionSecure12"))
			{
				break;
			} // end if
			Thread.sleep(1500);
		} // end while
		
		// Confirm the item does sync when not checked
		Assert.assertTrue(history.contains("Requires Reassignment by Automation RegressionSecure12"), "The history should reflect the failed reassignment");
		Assert.assertTrue(history.contains("There were no appraisers returned matching the property address and selection criteria or fees you have configured."), "The history should reflect there were no matching appraisers");
		
		// Log test
		test.log(LogStatus.INFO, "Status Mapping Regression Test", "Verified failed automatic reassignment is working properly and does show on the VMP order");
		
	} // end failedAutomaticReassignmentWithSync
	
} // end the RequiresReassignmentStatusMapping class
