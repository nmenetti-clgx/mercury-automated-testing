package regressionStatusMapping;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Secure.SOrderDetails;
import pageObjects.Secure.SVMPXSites;
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
 * <h1>Status Mapping - Failed Automatic Assignment</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
@Test(singleThreaded=true)
public class FailedAutomaticAssignment extends TestSetup {
	
	/** The user secure. */
	private final String userSecure = "RegressionSecure11";
	
	/** The user VMP. */
	private final String userVMP = "OriginatorRegressionSecure11";
	
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
	 * 	<li>Enable Unattended Order Assignment</li>
	 * 	<li>Disable Unattended Order Reassignment</li>
	 * 	<li>Select Custom fee panel radio button</li>
	 * 	<li>Uncheck Use Mercury Network directory as backup</li>
	 * 	<li>Save</li>
	 * 	<li>From VMP Client Portal, place an order without a disclosure date included</li>
	 * 	<li>Place order through the API</li>
	 * 	<li>Login to VMP Client Portal</li>
	 * 	<li>Find the new order</li>
	 * 	<li>Open the new order</li>
	 * 	<li>Get history text</li>
	 * 	<li>Confirm the item does not sync when not checked</li>
	 * 	<li>Order should fail the initial automatic assignment</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify history contains failed assignment text</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Status Mapping", "Secure - VMP XSite Settings", "Secure - Configure Status Mapping", "Secure - Vendor Selection Settings", "VMP - Create Order Via API", "VMP - Orders", "Secure - Orders"}, alwaysRun=true)
	public void failedAutomaticAssignmentWithoutSync() throws Exception{
		
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
		perform.checkCheckbox(driver, SVMPXSites.providesDisclosureTracking_chkbx(driver));
		
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
		
		// Enable Unattended Order Assignment
		if(SVendorSelectionSettings.unattendedOrderAssignment_switch(driver).getAttribute("src").contains("Off.png"))
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
		
		// From VMP Client Portal, place an order without a disclosure date included
		// Place order through the API
		perform.apiPlaceOrderFromVMPClientPortal(driver, userVMP, password, userSecure, "PlaceAppraisalOrderExLenderNoGroups-failedAutomaticAssignmentWithoutSync");
		String trackingNumber = StoredVariables.gettrackingNumber().get();
		String trackingNumberVMP = StoredVariables.gettrackingNumberVMP().get();
		
		// Login to VMP Client Portal
		vmp.login(driver, userSecure, userVMP, password);
		
		// Find the new order
		vmp.findOrder(driver, trackingNumberVMP, "Tracking #");
		
		// Open the new order
		vmp.openOrder(driver, trackingNumberVMP);
		
		// Wait for the history text
		perform.waitForElementToBeClickable(driver, VMPAppraisalOrderDetails.history_txt(), "id");
		
		// Get history text
		String history = VMPAppraisalOrderDetails.history_txt(driver).getText();
		
		// Confirm the item does not sync when not checked
		Assert.assertTrue(!history.contains("Automatic order assignment failed"), "The history should not reflect the failed assignment");
		Assert.assertTrue(!history.contains("This order couldn't be automatically assigned to a vendor because the disclosure date has not been provided."), "The history should not reflect the failed assignment");
		
		// Order should fail the initial automatic assignment
		// Login to Secure
		secure.login(driver, userSecure, password);
		
		// Find the order
		secure.findOrder(driver, trackingNumber, "Tracking number");

		// Open the order
		secure.openOrder(driver, trackingNumber);

		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify history contains failed assignment text
		Assert.assertTrue(history.contains("Automatic order assignment failed"), "The history should reflect the failed assignment");
		Assert.assertTrue(history.contains("This order couldn't be automatically assigned to a vendor because the disclosure date has not been provided."), "The history should reflect the failed assignment");
		
		// Log test
		test.log(LogStatus.INFO, "Status Mapping Regression Test", "Verified failed automatic assignment is working properly and does not show on the VMP order");
		
	} // end failedAutomaticAssignmentWithoutSync
	
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
	 * 	<li>Click Save</li>
	 * 	<li>Click Preferences &gt; Vendor Selection Settings</li>
	 * 	<li>Enable Unattended Order Assignment</li>
	 * 	<li>Disable Unattended Order Reassignment</li>
	 * 	<li>Select Custom fee panel radio button</li>
	 * 	<li>Uncheck Use Mercury Network directory as backup</li>
	 * 	<li>Save</li>
	 * 	<li>From VMP Client Portal, place an order without a disclosure date included</li>
	 * 	<li>Place order through the API</li>
	 * 	<li>Login to VMP Client Portal</li>
	 * 	<li>Find the new order</li>
	 * 	<li>Open the new order</li>
	 * 	<li>Get history text</li>
	 * 	<li>Confirm the item sync when not checked</li>
	 * 	<li>Order should fail the initial automatic assignment</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify history contains failed assignment text</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Status Mapping", "Secure - VMP XSite Settings", "Secure - Configure Status Mapping", "Secure - Vendor Selection Settings", "VMP - Create Order Via API", "VMP - Orders", "Secure - Orders"}, alwaysRun=true)
	public void failedAutomaticAssignmentWithSync() throws Exception{
		
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
		perform.checkCheckbox(driver, SVMPXSites.providesDisclosureTracking_chkbx(driver));
		
		// Save
		secure.saveVMPXSiteSettings(driver);
		
		// Click Configure Status Mapping
		perform.click(driver,SVMPXSites.configureStatusMapping_lnk(driver));
		
		// Wait for Appraiser button
		perform.waitForElementToBeClickable(driver, SVMPXSites.appraiser_btn(), "cssSelector");
		
		// Enable Requires Reassignment to sync
		secure.setStatusMapping(driver, "Requires Reassignment", "both");
		
		// Click Save
		perform.click(driver,SVMPXSites.save_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Click Preferences > Vendor Selection Settings
		secure.goToVendorSelectionSettings(driver);
		
		// Enable Unattended Order Assignment
		if(SVendorSelectionSettings.unattendedOrderAssignment_switch(driver).getAttribute("src").contains("Off.png"))
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
		
		// From VMP Client Portal, place an order without a disclosure date included
		// Place order through the API
		perform.apiPlaceOrderFromVMPClientPortal(driver, userVMP, password, userSecure, "PlaceAppraisalOrderExLenderNoGroups-failedAutomaticAssignmentWithSync");
		String trackingNumber = StoredVariables.gettrackingNumber().get();
		String trackingNumberVMP = StoredVariables.gettrackingNumberVMP().get();
		
		// Login to VMP Client Portal
		vmp.login(driver, userSecure, userVMP, password);
		
		// Find the new order
		vmp.findOrder(driver, trackingNumberVMP, "Tracking #");
		
		// Open the new order
		vmp.openOrder(driver, trackingNumberVMP);
		
		// Wait for the history text
		perform.waitForElementToBeClickable(driver, VMPAppraisalOrderDetails.history_txt(), "id");
		
		// Get history text
		String history = VMPAppraisalOrderDetails.history_txt(driver).getText();
		
		// Confirm the item sync when not checked
		Assert.assertTrue(history.contains("Requires Reassignment by Automation RegressionSecure11"), "The history should reflect the failed assignment");
		Assert.assertTrue(history.contains("This order couldn't be automatically assigned to a vendor because the disclosure date has not been provided."), "The history should reflect the failed assignment");
		
		// Order should fail the initial automatic assignment
		// Login to Secure
		secure.login(driver, userSecure, password);
		
		// Find the order
		secure.findOrder(driver, trackingNumber, "Tracking number");

		// Open the order
		secure.openOrder(driver, trackingNumber);

		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify history contains failed assignment text
		Assert.assertTrue(history.contains("Automatic order assignment failed"), "The history should reflect the failed assignment");
		Assert.assertTrue(history.contains("This order couldn't be automatically assigned to a vendor because the disclosure date has not been provided."), "The history should reflect the failed assignment");
		
		// Log test
		test.log(LogStatus.INFO, "Status Mapping Regression Test", "Verified failed automatic assignment is working properly and does show on the VMP order");
		
	} // end failedAutomaticAssignmentWithSync
	
} // end the RequiresReassignmentStatusMapping class
