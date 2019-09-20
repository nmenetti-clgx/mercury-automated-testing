package regressionEligibleVendors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjects.Secure.SConfirmOrder;
import pageObjects.Secure.SEligibleVendors;
import pageObjects.Secure.SModifySelectionSettings;
import pageObjects.Secure.SNewOrder;
import pageObjects.Secure.SOrderDetails;
import pageObjects.Secure.SVendorAssignment;
import pageObjects.Secure.SVendorSelection;
import pageObjects.Secure.SVendorSelectionSettings;
import pageObjects.Vendors.VOrderAcknowledgement;
import pageObjects.Vendors.VOrderDetails;
import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Eligible Vendors - View Eligible Vendors Link Displays On Residential Order To AMC</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class ViewEligibleVendorsLinkDisplaysOnResidentialOrderToAMC extends TestSetup {
	
	/** The user secure. */
	private final String userSecure = "RegressionSecure4";
	
	/** The user vendors. */
	private final String userVendors = "RegressionAMC2";
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Create order and assign it to RegressionAMC2</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Go to Vendor Selection Settings</li>
	 * 	<li>Turn off Double-blind Communication switch</li>
	 * 	<li>Disable Automatic Vendor Selection</li>
	 * 	<li>Select Custom Fee Panel</li>
	 * 	<li>Uncheck Use Mercury Network Directory as backup checkbox</li>
	 * 	<li>Verify Mercury Network Directory as backup is unchecked</li>
	 * 	<li>Save Preferences</li>
	 * 	<li>Click OK in saved dialog box</li>
	 * 	<li>Click AMC/Firms tab</li>
	 * 	<li>Disable Automatic Vendor Selection</li>
	 * 	<li>Save settings</li>
	 * 	<li>Go to Orders</li>
	 * 	<li>Place an order through the API</li>
	 * 	<li>Search for the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Switch to AMC</li>
	 * 	<li>Assign the order</li>
	 * 	<li>Confirm Order Details</li>
	 * 	<li>Login to Vendors</li>
	 * 	<li>Find order</li>
	 * 	<li>Click on the order from the orders grid</li>
	 * 	<li>Click Accept/Decline button</li>
	 * 	<li>Select Decline from dropdown</li>
	 * 	<li>Enter notes</li>
	 * 	<li>Click OK</li>
	 * 	<li>Log into Secure</li>
	 * 	<li>Go to Preferences&gt;VSS</li>
	 * 	<li>Click AMC/Firms</li>
	 * 	<li>Turn off Automatic Vendor Selection for residential</li>
	 * 	<li>Save Preferences</li>
	 * 	<li>Click OK in saved dialog box</li>
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
	 * 	<li>Turn on Automatic Vendor Selection for residential</li>
	 * 	<li>Save</li>
	 * 	<li>Click OK in saved dialog box</li>
	 * 	<li>Go to Residential Appraisal</li>
	 * 	<li>Enter New Order data</li>
	 * 	<li>Click Switch to AMC</li>
	 * 	<li>Click switch to AMC button</li>
	 * 	<li>Click Next</li>
	 * 	<li>Switch frame</li>
	 * 	<li>Click Approve</li>
	 * 	<li>Switch out of frame</li>
	 * 	<li>Click Next</li>
	 * 	<li>Get outside frames</li>
	 * 	<li>Get inside the attach document frame</li>
	 * 	<li>Click Finished</li>
	 * 	<li>Go to Orders</li>
	 * 	<li>Search for order</li>
	 * 	<li>Open order</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify delayed is in the history</li>
	 * 	<li>Verify View eligible vendors link</li>
	 * 	<li>Click the View eligible vendors link</li>
	 * 	<li>Verify dialog text</li>
	 * 	<li>Verify appraiser in list</li>
	 * 	<li>Click Close</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Vendor Selection Settings", "Secure - Create Order Via API", "Secure - Orders", "Secure - Assign Order To AMC", "Vendors - Orders", "Vendors - Decline Order", "Secure - Reassign Order", "Eligible Vendors"}, alwaysRun=true)
	public void viewEligibleVendorsLinkDisplaysOnResidentialOrderToAMC() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		String password = StoredVariables.getpassword().get();
		
		// Create order and assign it to RegressionAMC2
		// Login to Secure
		secure.login(driver, userSecure, password);
		
		// Go to Vendor Selection Settings
		secure.goToVendorSelectionSettings(driver);
		
		// Turn off Double-blind Communication switch
		if (!SVendorSelectionSettings.doubleBlind_switch(driver).getAttribute("src").contains("switchOff.png"))
		{
			perform.click(driver, SVendorSelectionSettings.doubleBlind_switch(driver));
		}
		
		// Disable Automatic Vendor Selection
		if (SVendorSelectionSettings.automaticOrderAssignment_switch(driver).getAttribute("src").contains("switchOn.png"))
		{
			perform.click(driver, SVendorSelectionSettings.automaticOrderAssignment_switch(driver));
		}
		
		// Select Custom Fee Panel
		perform.click(driver, SVendorSelectionSettings.customFeePanel_radio(driver));
		
		// Uncheck Use Mercury Network Directory as backup checkbox
		if (SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver).isSelected())
		{
			perform.click(driver, SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver));
		}
		
		// Verify Mercury Network Directory as backup is unchecked
		Assert.assertTrue(SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver).isSelected()==false, "Mercury Network Directory as backup is still checked");
		
		// Save Preferences
		perform.click(driver, SVendorSelectionSettings.save_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for the OK button to be visible
		perform.waitForElementToBeClickable(driver, SVendorSelectionSettings.ok_btn(), "id");
		
		// Click OK in saved dialog box
		perform.click(driver, SVendorSelectionSettings.ok_btn(driver));
		
		// Click AMC/Firms tab
		perform.click(driver, SVendorSelectionSettings.amcFirms_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Wait for Automatic order assignment switch
		perform.waitForElementToBeClickable(driver, SVendorSelectionSettings.automaticOrderAssignment_switch(), "id");
		
		// Disable Automatic Vendor Selection
		if (SVendorSelectionSettings.automaticOrderAssignment_switch(driver).getAttribute("src").contains("switchOn.png"))
		{
			System.out.println("Switch off Automatic order assignment");
			perform.click(driver, SVendorSelectionSettings.automaticOrderAssignment_switch(driver));
		} // end if
		
		// Save settings
		secure.saveVendorSelectionSettings(driver);
		
		// Go to Orders
		secure.goToOrders(driver);
		
		// Place an order through the API
		perform.apiPlaceOrderFromSecure(driver, userSecure, password, "PlaceMNOrder-ViewEligibleVendorsLinkDisplaysOnResidentialOrderToAMC");
		
		// Search for the order
		String trackingNumber = StoredVariables.gettrackingNumber().get();
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Open the order
		secure.openOrder(driver, trackingNumber);
		
		// Switch to AMC
		perform.click(driver, SOrderDetails.amcFirm_radiobtn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Assign the order
		secure.assignVendor(driver, userVendors);
		
		// Confirm Order Details
		secure.confirmOrderDetails(driver, "");
		
		// Login to Vendors
		vendors.login(driver, "RegressionAMC2", StoredVariables.getpassword().get());
		
		// Find order
		vendors.findOrder(driver, trackingNumber, "Tracking Number");
		
		// Click on the order from the orders grid
		perform.doubleClickInTable(driver, userSecure);
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, VOrderDetails.orderInformation_txt(), "id");
		
		// Click Accept/Decline button
		perform.click(driver, VOrderDetails.acceptDecline_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for Select Action dropdown
		perform.waitForElementToBeClickable(driver, VOrderAcknowledgement.selectAction_dropdown(), "id");
		
		// Select Decline from dropdown
		perform.selectDropdownOption(driver, VOrderAcknowledgement.selectAction_dropdown(driver), "Decline this Assignment");
		
		// Enter notes
		perform.type(driver,VOrderAcknowledgement.declineAssignmentNotes_txtbx(driver), "These are RegressionAMC2 declining order notes");
		
		// Click OK
		perform.click(driver, VOrderAcknowledgement.ok_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Log into Secure 
		secure.login(driver, "RegressionSecure4", StoredVariables.getpassword().get());
		
		// Go to Preferences>VSS 
		secure.goToVendorSelectionSettings(driver);
		
		// Click AMC/Firms
		perform.click(driver, SVendorSelectionSettings.amcFirms_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		Thread.sleep(2000);
		
		// Turn off Automatic Vendor Selection for residential
		if (SVendorSelectionSettings.automaticOrderAssignment_switch(driver).getAttribute("src").contains("switchOn.png"))
		{
			System.out.println("Turning off Auto order assignment");
			perform.click(driver, SVendorSelectionSettings.automaticOrderAssignment_switch(driver));
			Thread.sleep(1000);
		} // end if
		
		// Save Preferences
		perform.click(driver, SVendorSelectionSettings.save_btn(driver));
		
		// Wait for the OK button to be visible
		perform.waitForElementToBeClickable(driver, SVendorSelectionSettings.ok_btn(), "id");
		
		// Click OK in saved dialog box
		perform.click(driver, SVendorSelectionSettings.ok_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Go to Orders
		secure.goToOrders(driver);
		
		// Search for order
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Open order
		perform.doubleClickInTable(driver, trackingNumber);
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Click Modify selection settings 
		perform.click(driver, SOrderDetails.modifySelectionSettings_btn(driver));
		
		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SModifySelectionSettings.okPreVendorSelect_btn(), "id");
		
		// Turn on Automatic vendor selection 
		if (SModifySelectionSettings.automaticOrderAssignment_btn(driver).getAttribute("src").contains("switchOff.png"))
		{
			perform.click(driver, SModifySelectionSettings.automaticOrderAssignment_btn(driver));
			Thread.sleep(1500);
		} // end if
		
		// Click OK 
		perform.click(driver, SModifySelectionSettings.okPreVendorSelect_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Get history text
		String history = SOrderDetails.history_txt(driver).getText();
		
		// Verify delayed is in the history
		Assert.assertTrue(history.contains("Default Vendor Selection Settings were changed for this order by Client (Automation RegressionSecure4) "), "Default Vendor Selection Settings were changed for this order by Client (Automation RegressionSecure4)  is missing from the order information. The history = " + history);
		
		// Click Reassign 
		perform.click(driver, SOrderDetails.reassign_btn(driver));
		
		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		// Switch frame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "/Admin/NewOrder/AutoAssignmentApproval.aspx", By.id(SVendorAssignment.approve_btn()));
		
		// Wait for Approve button
		perform.waitForElementToBeClickable(driver, SVendorAssignment.approve_btn(), "id");
		
		// Click Approve
		perform.click(driver, SVendorAssignment.approve_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Switch out of frame
		driver.switchTo().defaultContent();
		
		// Click Finish
		perform.click(driver, SConfirmOrder.finishBottom_btn(driver));
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify delayed is in the history
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation"), "Awaiting acceptance by Automation is missing from the order information");
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
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation"), "Awaiting acceptance by Automation is missing from the order information");
		Assert.assertTrue(history.contains("View eligible vendors"), "View eligible vendors is missing from the order information");
		
		// Verify View eligible vendors link
		Assert.assertTrue(driver.findElement(By.linkText("View eligible vendors")).isDisplayed(), "The View eligible vendors link is not displayed");
		
		// Click the View eligible vendors link
		perform.click(driver, driver.findElement(By.linkText("View eligible vendors")));
		
		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for Close button
		perform.waitForElementToBeClickable(driver, SEligibleVendors.close_btn(), "id");
		
		// Verify dialog text
		Assert.assertTrue(SEligibleVendors.dialog_txt(driver).getText().contains("The following vendors from the Fee Panel were considered for this order when placed. The assigned vendor is highlighted."), "The dialog text is incorrect");
		
		// Verify appraiser in list
		Assert.assertTrue(SEligibleVendors.eligibleVendorsList_txt(driver).getText().contains("RegressionAMC1"), "The appraiser in the list is incorrect");
		Assert.assertTrue(SEligibleVendors.eligibleVendorsList_txt(driver).getText().contains("RegressionAMC3"), "The appraiser in the list is incorrect");
		
		// Click Close
		perform.click(driver, SEligibleVendors.close_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Go to Preferences>VSS 
		secure.goToVendorSelectionSettings(driver);
		
		// Click AMC/Firms
		perform.click(driver, SVendorSelectionSettings.amcFirms_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		Thread.sleep(2000);
		
		// Wait for Automatic Vendor Selection
		perform.waitForElementToBeClickable(driver, SVendorSelectionSettings.automaticOrderAssignment_switch(), "id");
		
		// Turn on Automatic Vendor Selection for residential 
		if (SVendorSelectionSettings.automaticOrderAssignment_switch(driver).getAttribute("src").contains("switchOff.png"))
		{
			System.out.println("Turning on Automatic vendor selection");
			perform.click(driver, SVendorSelectionSettings.automaticOrderAssignment_switch(driver));
			Thread.sleep(1500);
		} // end if
		
		// Save 
		perform.click(driver, SVendorSelectionSettings.save_btn(driver));
		
		// Wait for the OK button to be visible
		perform.waitForElementToBeClickable(driver, SVendorSelectionSettings.ok_btn(), "id");
		
		// Click OK in saved dialog box
		perform.click(driver, SVendorSelectionSettings.ok_btn(driver));
		
		// Go to Residential Appraisal
		secure.goToResidentialAppraisal(driver);
		
		/***************************************
		 * Set New Order Information
		 ***************************************/
		perform.clearOrderInfoStoredVariables(driver);
		secure.setNewResidentialAppraisalOrderVariablesMinimum(driver);
		
		// Enter New Order data
		secure.enterNewResidentialAppraisalOrder(driver);
		
		// Click Switch to AMC
		WebElement switchButton = driver.findElement(By.cssSelector("#Main_Main_upMenuBar > div > table > tbody > tr > td:nth-child(3) > table > tbody > tr > td.MenuBar_Item_Label"));
		System.out.println("switchButton = " + switchButton.getText());
		if (switchButton.getText().contains("AMC"))
		{
			// Click switch to AMC button
			perform.click(driver, SVendorSelection.switchToAMCFirm_btn(driver));
			
			// Wait for busy to be hidden
			perform.waitForBusyToBeHidden(driver);
		} // end if
		
		// Click Next
		perform.click(driver, SNewOrder.next_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Switch frame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "/Admin/NewOrder/AutoAssignmentApproval.aspx", By.id(SVendorAssignment.approve_btn()));
		
		// Wait for Approve button
		perform.waitForElementToBeClickable(driver, SVendorAssignment.approve_btn(), "id");
		
		// Click Approve
		perform.click(driver, SVendorAssignment.approve_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Switch out of frame
		driver.switchTo().defaultContent();
		
		// Click Next
		perform.click(driver, SConfirmOrder.finishBottom_btn(driver));
		
		Thread.sleep(3500);
		
		// Wait for frames
		perform.waitForIFrames(driver);
		
		// Get outside frames
		driver.switchTo().defaultContent();
		// Get inside the attach document frame
		driver.switchTo().frame("iframeAttach");
		
		// Wait for message text
		perform.waitForElementToBeClickable(driver, SConfirmOrder.uploadDocuments_btn(), "id");
		
		// Click Finished
		perform.click(driver, SConfirmOrder.finished_btn(driver));
		
		// Switch out of iFrame
		driver.switchTo().defaultContent();
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Go to Orders
		secure.goToOrders(driver);
		
		// Search for order
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Open order
		perform.doubleClickInTable(driver, trackingNumber);
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify delayed is in the history
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation"), "Awaiting acceptance by Automation is missing from the order information");
		Assert.assertTrue(history.contains("View eligible vendors"), "View eligible vendors is missing from the order information");
		
		// Verify View eligible vendors link
		Assert.assertTrue(driver.findElement(By.linkText("View eligible vendors")).isDisplayed(), "The View eligible vendors link is not displayed");
		
		// Click the View eligible vendors link
		perform.click(driver, driver.findElement(By.linkText("View eligible vendors")));
		
		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for Close button
		perform.waitForElementToBeClickable(driver, SEligibleVendors.close_btn(), "id");
		
		// Verify dialog text
		Assert.assertTrue(SEligibleVendors.dialog_txt(driver).getText().contains("The following vendors from the Fee Panel were considered for this order when placed. The assigned vendor is highlighted."), "The dialog text is incorrect");
		
		// Verify appraiser in list
		Assert.assertTrue(SEligibleVendors.eligibleVendorsList_txt(driver).getText().contains("RegressionAMC1"), "The appraiser in the list is incorrect");
		Assert.assertTrue(SEligibleVendors.eligibleVendorsList_txt(driver).getText().contains("RegressionAMC3"), "The appraiser in the list is incorrect");
		
		// Click Close
		perform.click(driver, SEligibleVendors.close_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Log test
		test.log(LogStatus.INFO, "Eligible Vendors", "Verified the view eligible vendors link shows when using automatic vendor selection");
		
	} // end viewEligibleVendorsLinkDisplaysOnResidentialOrderToAMC
	
} // end the viewEligibleVendorsLinkDisplaysOnResidentialOrderToAMC class
