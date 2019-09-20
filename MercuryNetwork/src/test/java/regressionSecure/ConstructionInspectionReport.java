package regressionSecure;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Secure.SAssignmentOptions;
import pageObjects.Secure.SConfigureAutomaticSettings;
import pageObjects.Secure.SDisclosureDate;
import pageObjects.Secure.SOrderDetails;
import pageObjects.Secure.SVendorSelectionSettings;
import pageObjects.VMP.VMPAppraisalOrderDetails;
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
 * <h1>Secure - Construction Inspection Report</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class ConstructionInspectionReport extends TestSetup {
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>From Secure Mercury Network:</li>
	 * 	<li>Preferences &gt; Vendor Selection Settings</li>
	 * 	<li>Select Custom Fee Panel</li>
	 * 	<li>Uncheck Use Mercury Network as backup</li>
	 * 	<li>Set Default vendor for inspection to Residential</li>
	 * 	<li>Click Default vendors button</li>
	 * 	<li>Select Residential for the Inspection products</li>
	 * 	<li>Click Save</li>
	 * 	<li>Enable unattended order assignment</li>
	 * 	<li>Save settings</li>
	 * 	<li>Click Configure Automatic Settings</li>
	 * 	<li>Uncheck Assign supplemental orders to the vendor that completed the original appraisal checkbox</li>
	 * 	<li>Click the gear icon for assign supplemental orders to ...</li>
	 * 	<li>Confirm the check boxes are unchecked</li>
	 * 	<li>Click OK</li>
	 * 	<li>Check Assign supplemental orders to the vendor that completed the original appraisal checkbox</li>
	 * 	<li>Click the gear icon for assign supplemental orders to ...</li>
	 * 	<li>Confirm the check boxes are checked</li>
	 * 	<li>Click OK</li>
	 * 	<li>Verify Assign supplemental orders to the vendor that completed the original appraisal checkbox is checked</li>
	 * 	<li>Click Save</li>
	 * 	<li>From the VMP Client Portal:</li>
	 * 	<li>Place a regular 1004 order</li>
	 * 	<li>Go to New Order</li>
	 * 	<li>Set variables</li>
	 * 	<li>Enter new order</li>
	 * 	<li>Click Next</li>
	 * 	<li>Save the order</li>
	 * 	<li>Click Finished Button</li>
	 * 	<li>Switch back to the attach documents frame</li>
	 * 	<li>Click the OK button in the Order Placed dialog</li>
	 * 	<li>Verify you land on the orders grid</li>
	 * 	<li>Query the db to get the order number that was just created</li>
	 * 	<li>From Secure make sure it assigned to a vendor</li>
	 * 	<li>Find Order</li>
	 * 	<li>Open Order</li>
	 * 	<li>Click the Edit link on the Disclosure</li>
	 * 	<li>Click the Calendar</li>
	 * 	<li>Select the date</li>
	 * 	<li>Click OK</li>
	 * 	<li>Verify the Disclosure date displays</li>
	 * 	<li>Refresh the page</li>
	 * 	<li>Verify the Disclosure date displays</li>
	 * 	<li>Get the history</li>
	 * 	<li>Verify the vendor name</li>
	 * 	<li>Get vendor Last Name</li>
	 * 	<li>As the vendor, accept and deliver a completed report</li>
	 * 	<li>Accept the order</li>
	 * 	<li>Complete the report</li>
	 * 	<li>From VMP Client Portal</li>
	 * 	<li>Find the order</li>
	 * 	<li>View the order details</li>
	 * 	<li>Click Other Actions &gt; Duplicate</li>
	 * 	<li>Click Duplicate</li>
	 * 	<li>Set the form to Construction Inspection Report</li>
	 * 	<li>Enter Order Due date</li>
	 * 	<li>Set new directions</li>
	 * 	<li>Click Next</li>
	 * 	<li>Click Next</li>
	 * 	<li>Get outside frames</li>
	 * 	<li>Get inside the attach document frame</li>
	 * 	<li>Click Finished Button</li>
	 * 	<li>Switch back to the attach documents frame</li>
	 * 	<li>Click the OK button in the Order Placed dialog</li>
	 * 	<li>Verify you land on the orders grid</li>
	 * 	<li>Query the db to get the order number that was just created</li>
	 * 	<li>Get vendor Last Name</li>
	 * 	<li>From Secure, confirm the order automatically assigned to the same vendor as the regular 1004 order</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Vendor Selection Settings", "Secure - Default Vendors", "Secure - Configure Automatic Settings", "VMP - Create Order", "Secure - Orders", "Vendors - Orders", "Vendors - Accept Order", "Vendors - Complete Order", "VMP - Orders", "VMP - Duplicate VMP Order"}, alwaysRun=true)
	public void constructionInspectionReport() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		
		// From Secure Mercury Network:
		secure.login(driver, "ConstructionInspectionReport1", StoredVariables.getpassword().get());
		
		// Preferences > Vendor Selection Settings
		secure.goToVendorSelectionSettings(driver);
		
		// Select Custom Fee Panel
		perform.click(driver,SVendorSelectionSettings.customFeePanel_radio(driver));
		
		// Uncheck Use Mercury Network as backup
		if (SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver).isSelected())
		{
			perform.click(driver,SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver));
		} // end if
		
		// Set Default vendor for inspection to Residential
		// Click Default vendors button
		perform.click(driver,SVendorSelectionSettings.defaultVendors_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for Inspection products dropdown
		perform.waitForElementToBeClickable(driver, SVendorSelectionSettings.inspectionProducts_dropdown(), "id");
		
		// Select Residential for the Inspection products
		perform.selectDropdownOption(driver, SVendorSelectionSettings.inspectionProducts_dropdown(driver), "Residential appraiser");
		
		// Click Save
		perform.click(driver,SVendorSelectionSettings.saveDefaultVendors_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Enable unattended order assignment
		secure.switchOn(driver, SVendorSelectionSettings.unattendedOrderAssignment_switch(driver));
		
		// Save settings
		secure.saveVendorSelectionSettings(driver);
		
		// Click Configure Automatic Settings
		perform.click(driver,driver.findElement(By.linkText("Configure automatic settings")));
		
		// Wait for Assign supplemental orders to the vendor that completed the original appraisal checkbox
		perform.waitForElementToBeClickable(driver, SConfigureAutomaticSettings.assignSupplementalOrdersToTheVendorThatCoompletedTheOriginalAppraisal_chkbx(), "id");
		
		// Wait for Assign supplemental orders to the vendor that completed the original appraisal checkbox
		perform.waitForElementToBeClickable(driver, SConfigureAutomaticSettings.assignSupplementalOrdersToTheVendorThatCoompletedTheOriginalAppraisal_chkbx(), "id");
		
		// Uncheck Assign supplemental orders to the vendor that completed the original appraisal checkbox
		perform.uncheckCheckbox(driver, SConfigureAutomaticSettings.assignSupplementalOrdersToTheVendorThatCoompletedTheOriginalAppraisal_chkbx(driver));
		
		// Click the gear icon for assign supplemental orders to ...
		perform.click(driver,SConfigureAutomaticSettings.assignSupplementalOrdersGearIcon_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for Construction Inspection Report checkbox
		perform.waitForElementToBeClickable(driver, SAssignmentOptions.constructionInspectionReport_chkbx(), "id");
		
		// Confirm the check boxes are unchecked
		Assert.assertTrue(SAssignmentOptions.constructionInspectionReport_chkbx(driver).isSelected()==false, "The Construction Inspection Report checkbox should not be checked");
		Assert.assertTrue(SAssignmentOptions.appraisalUpdateInspectionOfRepairs_chkbx(driver).isSelected()==false, "The checkboxes should all be unchecked");
		Assert.assertTrue(SAssignmentOptions.appraisalUpdateRecertification_chkbx(driver).isSelected()==false, "The checkboxes should all be unchecked");
		Assert.assertTrue(SAssignmentOptions.comparableRentSchedule_chkbx(driver).isSelected()==false, "The checkboxes should all be unchecked");
		Assert.assertTrue(SAssignmentOptions.operatingIncomeStatement_chkbx(driver).isSelected()==false, "The checkboxes should all be unchecked");
		Assert.assertTrue(SAssignmentOptions.comparableRentScheduleWithOperatingIncomeStatement_chkbx(driver).isSelected()==false, "The checkboxes should all be unchecked");
		Assert.assertTrue(SAssignmentOptions.fhaConversionAppraisalUpdate_chkbx(driver).isSelected()==false, "The checkboxes should all be unchecked");
		Assert.assertTrue(SAssignmentOptions.fhaInspection_chkbx(driver).isSelected()==false, "The checkboxes should all be unchecked");
		
		// Click OK
		perform.click(driver,SAssignmentOptions.ok_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Wait for Assign supplemental orders to the vendor that completed the original appraisal checkbox
		perform.waitForElementToBeClickable(driver, SConfigureAutomaticSettings.assignSupplementalOrdersToTheVendorThatCoompletedTheOriginalAppraisal_chkbx(), "id");
		
		// Check Assign supplemental orders to the vendor that completed the original appraisal checkbox
		perform.checkCheckbox(driver, SConfigureAutomaticSettings.assignSupplementalOrdersToTheVendorThatCoompletedTheOriginalAppraisal_chkbx(driver));
		
		// Click the gear icon for assign supplemental orders to ...
		perform.click(driver,SConfigureAutomaticSettings.assignSupplementalOrdersGearIcon_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for Construction Inspection Report checkbox
		perform.waitForElementToBeClickable(driver, SAssignmentOptions.constructionInspectionReport_chkbx(), "id");
		
		// Confirm the check boxes are checked
		Assert.assertTrue(SAssignmentOptions.constructionInspectionReport_chkbx(driver).isSelected()==true, "The Construction Inspection Report checkbox should not be checked");
		Assert.assertTrue(SAssignmentOptions.appraisalUpdateInspectionOfRepairs_chkbx(driver).isSelected()==true, "The checkboxes should all be unchecked");
		Assert.assertTrue(SAssignmentOptions.appraisalUpdateRecertification_chkbx(driver).isSelected()==true, "The checkboxes should all be unchecked");
		Assert.assertTrue(SAssignmentOptions.comparableRentSchedule_chkbx(driver).isSelected()==true, "The checkboxes should all be unchecked");
		Assert.assertTrue(SAssignmentOptions.operatingIncomeStatement_chkbx(driver).isSelected()==true, "The checkboxes should all be unchecked");
		Assert.assertTrue(SAssignmentOptions.comparableRentScheduleWithOperatingIncomeStatement_chkbx(driver).isSelected()==true, "The checkboxes should all be unchecked");
		Assert.assertTrue(SAssignmentOptions.fhaConversionAppraisalUpdate_chkbx(driver).isSelected()==true, "The checkboxes should all be unchecked");
		Assert.assertTrue(SAssignmentOptions.fhaInspection_chkbx(driver).isSelected()==true, "The checkboxes should all be unchecked");
		
		// Click OK
		perform.click(driver,SAssignmentOptions.ok_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Wait for Assign supplemental orders to the vendor that completed the original appraisal checkbox
		perform.waitForElementToBeClickable(driver, SConfigureAutomaticSettings.assignSupplementalOrdersToTheVendorThatCoompletedTheOriginalAppraisal_chkbx(), "id");
		
		// Verify Assign supplemental orders to the vendor that completed the original appraisal checkbox is checked
		Assert.assertTrue(SConfigureAutomaticSettings.assignSupplementalOrdersToTheVendorThatCoompletedTheOriginalAppraisal_chkbx(driver).isSelected()==true, "The Assign supplemental orders to the vendor that completed the original appraisal checkbox should be unchecked");
		
		// Click Save
		secure.saveVMPXSiteSettings(driver);
		
		// From the VMP Client Portal:
		vmp.login(driver, "ConstructionInspectionReport1", "OriginatorConstructionInspectionReport", StoredVariables.getpassword().get());
		
		// Place a regular 1004 order
		// Go to New Order
		vmp.goToNewOrder(driver);
		
		// Set variables
		vmp.setVariables(driver);
		
		// Enter new order
		vmp.enterNewOrder(driver);
		
		// Click Next
		perform.click(driver,VMPNewOrder.nextTop_btn(driver));
		
		// Save the order
		vmp.saveNewOrder(driver);
		
		// Click Finished Button
		perform.click(driver,VMPConfirmOrder.finished_btn(driver));
		
		// Switch back to the attach documents frame
		driver.switchTo().defaultContent();
		
		// Wait for the OK button in the Order Placed dialog
		perform.waitForElementToBeClickable(driver, VMPConfirmOrder.ok_btn(), "cssSelector");
		
		// Click the OK button in the Order Placed dialog
		perform.click(driver,VMPConfirmOrder.ok_btn(driver));
		
		// Wait for the Find textbox
		perform.waitForElementToBeClickable(driver, VMPOrders.find_txtbx(), "id");
		
		// Verify you land on the orders grid
		Assert.assertTrue(driver.getCurrentUrl().contains("OrderManagement"), "After completing an order, the orders grid did not load");
		
		// Query the db to get the order number that was just created
		db.getLoanIDsFromVMPClientPortalOrder(driver);
		
		// From Secure make sure it assigned to a vendor
		secure.login(driver, "ConstructionInspectionReport1", StoredVariables.getpassword().get());
		String trackingNumber = StoredVariables.gettrackingNumber().get();
		String trackingNumberVMP = StoredVariables.gettrackingNumberVMP().get();
		
		// Find Order
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Open Order
		secure.openOrder(driver, trackingNumber);
		
		/************************************
		 * ADDED TEST FOR BUG MER-2235
		 ***********************************/
		
		// Click the Edit link on the Disclosure
		perform.click(driver,SOrderDetails.editDisclosure_lnk(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for the Disclosure Date calendar button
		perform.waitForElementToBeClickable(driver, SDisclosureDate.disclosureDateCalendar_btn(), "id");
		
		// Click the Calendar
		perform.click(driver,SDisclosureDate.disclosureDateCalendar_btn(driver));
		
		// Select the date
		secure.selectDateFromCalendar(driver, 1);
		
		// Click OK
		perform.click(driver,SDisclosureDate.ok_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Verify the Disclosure date displays
		String disclosure = SOrderDetails.editDisclosure_lnk(driver).getText();
		Assert.assertTrue(!disclosure.contains("Edit"), "The Disclosure link should not say Edit, but instead it shows = " + disclosure);
		
		// Refresh the page
		driver.navigate().refresh();
		
		// Wait for the Disclosure Date
		perform.waitForElementToBeClickable(driver, SOrderDetails.editDisclosure_lnk(), "id");
		
		// Verify the Disclosure date displays
		disclosure = SOrderDetails.editDisclosure_lnk(driver).getText();
		Assert.assertTrue(!disclosure.contains("Edit"), "The Disclosure link should not say Edit, but instead it shows = " + disclosure);
		
		/************************************
		 * END TEST FOR BUG MER-2235
		 ***********************************/
		
		// Wait for history
		perform.waitForElementToBeClickable(driver, SOrderDetails.history_txt(), "id");
		
		// Get the history
		String history = SOrderDetails.history_txt(driver).getText();
		
		// Verify the vendor name
		Assert.assertTrue(history.contains("Order automatically assigned"), "The order should have been automatically assigned");
		
		// Get vendor Last Name
		db.getVendorLastNameFromLoanID(driver, StoredVariables.getloanID().get());
		String vendorLastName = StoredVariables.getvendorEmail().get();
		
		// As the vendor, accept and deliver a completed report
		vendors.login(driver, vendorLastName, StoredVariables.getpassword().get());
		
		// Accept the order
		vendors.acceptOrder(driver, trackingNumber);
		
		// Complete the report
		vendors.completeOrderByHTTPPost(driver, vendorLastName, StoredVariables.getpassword().get(), StoredVariables.getloanID().get(), "Complete.xml");
		
		// From VMP Client Portal
		vmp.login(driver, "ConstructionInspectionReport1", "OriginatorConstructionInspectionReport1", StoredVariables.getpassword().get());
		
		// Find the order
		vmp.findOrder(driver, trackingNumberVMP, "Tracking #");
		
		// View the order details
		vmp.openOrder(driver, trackingNumberVMP);
		
		// Click Other Actions > Duplicate
		perform.click(driver,VMPAppraisalOrderDetails.otherActions_btn(driver));
		
		// Wait for the Duplicate button
		perform.waitForElementToBeClickable(driver, VMPAppraisalOrderDetails.duplicateOrder_btn(), "cssSelector");
		
		// Click Duplicate
		perform.click(driver,VMPAppraisalOrderDetails.duplicateOrder_btn(driver));
		
		// Wait for dropdown
		perform.waitForElementToBeClickable(driver, VMPNewOrder.form_dropdown(), "id");
		
		// Set the form to Construction Inspection Report
		perform.selectDropdownOption(driver, VMPNewOrder.form_dropdown(driver), "Construction Inspection Report");
		
		// Enter Order Due date
		perform.type(driver,VMPNewOrder.orderDue_txtbx(driver), StoredVariables.getorderDueDateLong().get());
		
		// Set new directions
		String directions = "Duplicated order - " + perform.randomNumbers(driver, 7); 
		StoredVariables.getdirectionsIdentifier().set(directions);
		VMPNewOrder.directions_txtbx(driver).clear();
		perform.type(driver,VMPNewOrder.directions_txtbx(driver), directions);
		
		// Click Next
		perform.click(driver,VMPNewOrder.nextTop_btn(driver));
		
		// Handle address mismatch
		vmp.handleAddressMismatch(driver);
		
		// Wait for Next button
		perform.waitForElementToBeClickable(driver, VMPConfirmOrder.nextTop_btn(), "id");
		
		// Click Next
		perform.click(driver,VMPConfirmOrder.nextTop_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);

		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Get outside frames
		driver.switchTo().defaultContent();
		// Get inside the attach document frame
		driver.switchTo().frame("iframeAttach");
		
		// Wait for Finished button
		perform.waitForElementToBeClickable(driver, VMPConfirmOrder.finished_btn(), "id");
		
		// Click Finished Button
		perform.click(driver,VMPConfirmOrder.finished_btn(driver));
		
		// Switch back to the attach documents frame
		driver.switchTo().defaultContent();
		
		// Wait for the OK button in the Order Placed dialog
		perform.waitForElementToBeClickable(driver, VMPConfirmOrder.ok_btn(), "cssSelector");
		
		// Click the OK button in the Order Placed dialog
		perform.click(driver,VMPConfirmOrder.ok_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Wait for the Find textbox
		perform.waitForElementToBeClickable(driver, VMPOrders.find_txtbx(), "id");
		
		// Verify you land on the orders grid
		Assert.assertTrue(driver.getCurrentUrl().contains("OrderManagement"), "After completing an order, the orders grid did not load");
		
		// Query the db to get the order number that was just created
		db.getLoanIDsFromVMPClientPortalOrder(driver);
		
		// Get vendor Last Name
		db.getVendorLastNameFromLoanID(driver, StoredVariables.getloanID().get());
		String vendorLastName2 = StoredVariables.getvendorEmail().get();
		
		// From Secure, confirm the order automatically assigned to the same vendor as the regular 1004 order
		Assert.assertTrue(vendorLastName.equals(vendorLastName2), "The vendor should be the same");
		
		// Log test
		test.log(LogStatus.INFO, "Construction Inspection Report Regression Test", "Verified the functionality of Construction Inspection Report and that the order automatically assigned to the same vendor as the regular 1004 order");
		
	} // end constructionInspectionReport
	
} // end the ConstructionInspectionReport class
