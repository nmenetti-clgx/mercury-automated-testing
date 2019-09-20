package regressionEligibleVendors;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjects.Secure.SConfirmOrder;
import pageObjects.Secure.SEligibleVendors;
import pageObjects.Secure.SModifySelectionSettings;
import pageObjects.Secure.SOrderDetails;
import pageObjects.Secure.SVendorAssignment;
import pageObjects.Secure.SVendorSelectionSettings;
import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Eligible Vendors - View Eligible Vendors Link Displays On Commercial Order To AMC</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class ViewEligibleVendorsLinkDisplaysOnCommercialOrderToAMC extends TestSetup {
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Create order and assign it to RegressionAMC1</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Go to  Vendor Selection Settings</li>
	 * 	<li>Turn off Double-blind Communication switch</li>
	 * 	<li>Disable Automatic Vendor Selection</li>
	 * 	<li>Select Custom Fee Panel</li>
	 * 	<li>Uncheck Use Mercury Network Directory as backup checkbox</li>
	 * 	<li>Verify Mercury Network Directory as backup is unchecked</li>
	 * 	<li>Click AMC/Firms</li>
	 * 	<li>Turn off Automatic Vendor Selection for commercial</li>
	 * 	<li>Save Preferences</li>
	 * 	<li>Click OK in saved dialog box</li>
	 * 	<li>Place order through API</li>
	 * 	<li>Go to Orders screen</li>
	 * 	<li>Search for order</li>
	 * 	<li>Open order</li>
	 * 	<li>Click AMC radio button</li>
	 * 	<li>Assign order to AMC</li>
	 * 	<li>Confirm Order Details</li>
	 * 	<li>Login to Vendors</li>
	 * 	<li>Decline the order</li>
	 * 	<li>Log into Secure</li>
	 * 	<li>Go to Preferences&gt;VSS</li>
	 * 	<li>Turn off Automatic Vendor Selection for residential</li>
	 * 	<li>Save</li>
	 * 	<li>Go to Orders</li>
	 * 	<li>Search for order</li>
	 * 	<li>Open order</li>
	 * 	<li>Click Modify selection settings</li>
	 * 	<li>Turn on Automatic vendor selection</li>
	 * 	<li>Click OK</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify delayed is in the history</li>
	 * 	<li>Click Reassign</li>
	 * 	<li>Switch frame</li>
	 * 	<li>Click Approve</li>
	 * 	<li>Switch out of frame</li>
	 * 	<li>Click Finish</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify delayed is in the history</li>
	 * 	<li>Verify View eligible vendors link</li>
	 * 	<li>Go to the Orders screen</li>
	 * 	<li>Search for order</li>
	 * 	<li>Open order again</li>
	 * 	<li>Verify delayed is in the history</li>
	 * 	<li>Verify View eligible vendors link</li>
	 * 	<li>Click the View eligible vendors link</li>
	 * 	<li>Verify dialog text</li>
	 * 	<li>Verify appraiser in list</li>
	 * 	<li>Click Close</li>
	 * 	<li>Go to Preferences&gt;VSS</li>
	 * 	<li>Click AMC/Firms</li>
	 * 	<li>Turn on Automatic Vendor Selection for commercial</li>
	 * 	<li>Save Preferences</li>
	 * 	<li>Click OK in saved dialog box</li>
	 * 	<li>Place order through API</li>
	 * 	<li>Go to Orders screen</li>
	 * 	<li>Search for order</li>
	 * 	<li>Open order</li>
	 * 	<li>Click AMC radio button</li>
	 * 	<li>Click Assign</li>
	 * 	<li>Switch iFrame</li>
	 * 	<li>Click Approve</li>
	 * 	<li>Switch out of frame</li>
	 * 	<li>Click Finish</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify delayed is in the history</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Vendor Selection Settings", "Secure - Create Order Via API", "Secure - Orders", "Secure - Assign Order To AMC", "Vendors - Orders", "Vendors - Decline Order", "Secure - Reassign Order", "Eligible Vendors"}, alwaysRun=true)
	public void viewEligibleVendorsLinkDisplaysOnCommercialOrderToAMC() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Create order and assign it to RegressionAMC1
		// Login to Secure
		secure.login(driver, "RegressionSecure3", StoredVariables.getpassword().get());
		
		// Go to  Vendor Selection Settings
		secure.goToVendorSelectionSettings(driver);
		
		// Turn off Double-blind Communication switch
		if (!SVendorSelectionSettings.doubleBlind_switch(driver).getAttribute("src").contains("switchOff.png"))
		{
			perform.click(driver,SVendorSelectionSettings.doubleBlind_switch(driver));
		}
		
		// Disable Automatic Vendor Selection
		if (SVendorSelectionSettings.automaticOrderAssignment_switch(driver).getAttribute("src").contains("switchOn.png"))
		{
			perform.click(driver,SVendorSelectionSettings.automaticOrderAssignment_switch(driver));
		}
		
		// Select Custom Fee Panel
		perform.click(driver,SVendorSelectionSettings.customFeePanel_radio(driver));
		
		// Uncheck Use Mercury Network Directory as backup checkbox
		if (SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver).isSelected())
		{
			perform.click(driver,SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver));
		}
		
		// Verify Mercury Network Directory as backup is unchecked
		Assert.assertTrue(SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver).isSelected()==false, "Mercury Network Directory as backup is still checked");
		
		// Click AMC/Firms
		perform.click(driver,SVendorSelectionSettings.amcFirms_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Turn off Automatic Vendor Selection for commercial 
		if (!SVendorSelectionSettings.automaticOrderAssignment_switch(driver).getAttribute("src").contains("switchOff.png"))
		{
			perform.click(driver,SVendorSelectionSettings.automaticOrderAssignment_switch(driver));
		}
		
		// Save Preferences
		perform.click(driver,SVendorSelectionSettings.save_btn(driver));
		
		// Wait for the OK button to be visible
		perform.waitForElementToBeClickable(driver, SVendorSelectionSettings.ok_btn(), "id");
		
		// Click OK in saved dialog box
		perform.click(driver,SVendorSelectionSettings.ok_btn(driver));
		
		// Place order through API
		perform.apiPlaceOrderFromSecure(driver, "RegressionSecure3", "T3sting1", "PlaceMNOrder-Commercial-ViewEligibleVendorsLinkDisplaysOnCommercialOrderToAMC");
		
		// Go to Orders screen
		secure.goToOrders(driver);
		
		String trackingNumber = StoredVariables.gettrackingNumber().get();
		
		// Search for order
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Open order
		secure.openOrder(driver, trackingNumber);
		
		// Wait for AMC radio button
		perform.waitForElementToBeClickable(driver, SOrderDetails.amcFirm_radiobtn(), "id");
		
		// Click AMC radio button
		perform.click(driver,SOrderDetails.amcFirm_radiobtn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Assign order to AMC
		secure.assignVendor(driver, "Automation" + StoredVariables.getusernameEnvironment().get() + "RegressionAMC1");
		
		// Confirm Order Details
		secure.confirmOrderDetails(driver, "");
		
		// Login to Vendors
		vendors.login(driver, "RegressionAMC1", StoredVariables.getpassword().get());
		
		// Decline the order
		vendors.declineOrder(driver, trackingNumber);
		
		// Log into Secure 
		secure.login(driver, "RegressionSecure3", StoredVariables.getpassword().get());
		
		// Go to Preferences>VSS 
		secure.goToVendorSelectionSettings(driver);
		
		// Turn off Automatic Vendor Selection for residential 
		if (SVendorSelectionSettings.automaticOrderAssignment_switch(driver).getAttribute("src").contains("switchOn.png"))
		{
			perform.click(driver,SVendorSelectionSettings.automaticOrderAssignment_switch(driver));
		}
		
		// Save 
		secure.goToVendorSelectionSettings(driver);
		
		// Go to Orders
		secure.goToOrders(driver);
		
		// Search for order
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Open order
		perform.doubleClickInTable(driver, trackingNumber);
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Click Modify selection settings 
		perform.click(driver,SOrderDetails.modifySelectionSettings_btn(driver));
		
		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SModifySelectionSettings.okPreVendorSelect_btn(), "id");
		
		// Turn on Automatic vendor selection 
		if (SModifySelectionSettings.automaticOrderAssignment_btn(driver).getAttribute("src").contains("switchOff.png"))
		{
			perform.click(driver,SModifySelectionSettings.automaticOrderAssignment_btn(driver));			
		}
		
		// Click OK 
		perform.click(driver,SModifySelectionSettings.okPreVendorSelect_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Get history text
		String history = SOrderDetails.history_txt(driver).getText();
		
		// Verify delayed is in the history
		Assert.assertTrue(history.contains("Default Vendor Selection Settings were changed for this order by Client (Automation RegressionSecure3) "), "Default Vendor Selection Settings were changed for this order by Client (Automation RegressionSecure3)  is missing from the order information");
		
		// Click Reassign 
		perform.click(driver,SOrderDetails.reassign_btn(driver));
		
		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		// Switch frame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "/Admin/NewOrder/AutoAssignmentApproval.aspx", By.id(SVendorAssignment.approve_btn()));
		
		// Wait for Approve button
		perform.waitForElementToBeClickable(driver, SVendorAssignment.approve_btn(), "id");
		
		// Click Approve
		perform.click(driver,SVendorAssignment.approve_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Switch out of frame
		driver.switchTo().defaultContent();
		
		// Click Finish
		perform.click(driver,SConfirmOrder.finishBottom_btn(driver));
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify delayed is in the history
		Assert.assertTrue(history.contains("Awaiting acceptance by"), "Awaiting acceptance by is missing from the order information");
		Assert.assertTrue(history.contains("View eligible vendors"), "View eligible vendors is missing from the order information");
		
		// Verify View eligible vendors link
		Assert.assertTrue(driver.findElement(By.linkText("View eligible vendors")).isDisplayed(), "The View eligible vendors link is not displayed");
		
		// Go to the Orders screen
		secure.goToOrders(driver);
		
		// Search for order
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Open order again
		perform.doubleClickInTable(driver, trackingNumber);
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Verify delayed is in the history
		Assert.assertTrue(history.contains("Awaiting acceptance by "), "Awaiting acceptance by is missing from the order information");
		Assert.assertTrue(history.contains("View eligible vendors"), "View eligible vendors is missing from the order information");
		
		// Verify View eligible vendors link
		Assert.assertTrue(driver.findElement(By.linkText("View eligible vendors")).isDisplayed(), "The View eligible vendors link is not displayed");
		
		// Click the View eligible vendors link
		perform.click(driver,driver.findElement(By.linkText("View eligible vendors")));
		
		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for Close button
		perform.waitForElementToBeClickable(driver, SEligibleVendors.close_btn(), "id");
		
		// Verify dialog text
		Assert.assertTrue(SEligibleVendors.dialog_txt(driver).getText().contains("The following vendors from the Fee Panel were considered for this order when placed. The assigned vendor is highlighted."), "The dialog text is incorrect");
		
		// Verify appraiser in list
		Assert.assertTrue(SEligibleVendors.eligibleVendorsList_txt(driver).getText().contains("Automation RegressionAMC3"), "The appraiser in the list is incorrect");
		Assert.assertTrue(SEligibleVendors.eligibleVendorsList_txt(driver).getText().contains("Automation RegressionAMC2"), "The appraiser in the list is incorrect");
		
		// Click Close
		perform.click(driver,SEligibleVendors.close_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Go to Preferences>VSS 
		secure.goToVendorSelectionSettings(driver);
		
		// Click AMC/Firms
		perform.click(driver,SVendorSelectionSettings.amcFirms_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Turn on Automatic Vendor Selection for commercial 
		if (SVendorSelectionSettings.automaticOrderAssignment_switch(driver).getAttribute("src").contains("switchOff.png"))
		{
			perform.click(driver,SVendorSelectionSettings.automaticOrderAssignment_switch(driver));
		}
		
		// Save Preferences
		perform.click(driver,SVendorSelectionSettings.save_btn(driver));
		
		// Wait for the OK button to be visible
		perform.waitForElementToBeClickable(driver, SVendorSelectionSettings.ok_btn(), "id");
		
		// Click OK in saved dialog box
		perform.click(driver,SVendorSelectionSettings.ok_btn(driver));
		
		// Place order through API
		perform.apiPlaceOrderFromSecure(driver, "RegressionSecure3", "T3sting1", "PlaceMNOrder-Commercial-ViewEligibleVendorsLinkDisplaysOnCommercialOrderToAMC");
		
		// Go to Orders screen
		secure.goToOrders(driver);
		
		trackingNumber = StoredVariables.gettrackingNumber().get();
		
		// Search for order
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Open order
		secure.openOrder(driver, trackingNumber);
		
		// Wait for AMC radio button
		perform.waitForElementToBeClickable(driver, SOrderDetails.amcFirm_radiobtn(), "id");
		
		// Click AMC radio button
		perform.click(driver,SOrderDetails.amcFirm_radiobtn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Click Assign
		perform.click(driver,SOrderDetails.assign_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Switch iFrame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "/Admin/NewOrder/AutoAssignmentApproval.aspx", By.id(SVendorAssignment.approve_btn()));
		
		// Wait for Approve button
		perform.waitForElementToBeClickable(driver, SVendorAssignment.approve_btn(), "id");
		
		// Click Approve
		perform.click(driver,SVendorAssignment.approve_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Switch out of frame
		driver.switchTo().defaultContent();
		
		// Click Finish
		perform.click(driver,SConfirmOrder.finishBottom_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify delayed is in the history
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation"), "Awaiting acceptance by Automation is missing from the order information");
		
		// Log test
		test.log(LogStatus.INFO, "Eligible Vendors", "Verified the view eligible vendors link shows when using automatic vendor selection");
		
	} // end viewEligibleVendorsLinkDisplaysOnCommercialOrderToAMC
	
} // end the viewEligibleVendorsLinkDisplaysOnCommercialOrderToAMC class
