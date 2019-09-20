package regressionVendorOrderCapacity;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjects.Secure.SConfirmOrder;
import pageObjects.Secure.SModifySelectionSettings;
import pageObjects.Secure.SNewOrder;
import pageObjects.Secure.SOrderDetails;
import pageObjects.Secure.SOrders;
import pageObjects.Secure.SProfile;
import pageObjects.Secure.SVendorSelection;
import pageObjects.Secure.SVendorSelectionSettings;
import pageObjects.Vendors.VOrderDetails;
import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Vendor Order Capacity - Require Staff Vendor</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class RequireStaffVendor extends TestSetup {
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to secure</li>
	 * 	<li>Click Preferences &gt; Vendor Selection Settings</li>
	 * 	<li>Uncheck all ISS check boxes</li>
	 * 	<li>Enable Require staff vendor</li>
	 * 	<li>Set option to Prefer</li>
	 * 	<li>Click Save</li>
	 * 	<li>Click Fee Panel</li>
	 * 	<li>Select a vendor and view profile</li>
	 * 	<li>Switch to iFrame</li>
	 * 	<li>Click Assignment tab</li>
	 * 	<li>Check Staff/salaried vendor box and Save</li>
	 * 	<li>Uncheck Do not show order fee on assignment</li>
	 * 	<li>Click Save</li>
	 * 	<li>Switch out of iframe</li>
	 * 	<li>Go to new Residential Appraisal</li>
	 * 	<li>Place a new order</li>
	 * 	<li>Enter New Order data</li>
	 * 	<li>Click Next</li>
	 * 	<li>Get first appraiser name in the list</li>
	 * 	<li>Verify first appraiser is Automation VendorOrderCapacityAppraiser1</li>
	 * 	<li>Click Back</li>
	 * 	<li>Click Modify Selection Settings</li>
	 * 	<li>Change Require staff vendor to Require instead of Prefer</li>
	 * 	<li>Click OK</li>
	 * 	<li>Click Next</li>
	 * 	<li>Count the number of rows for appraisers and verify there is only 1 row</li>
	 * 	<li>Verify only staff appraisers are shown as eligible</li>
	 * 	<li>Verify only staff appraisers are shown as eligible</li>
	 * 	<li>Assign the order to the staff appraiser</li>
	 * 	<li>Verify Confirm Order url</li>
	 * 	<li>Verify the order fee displays correctly</li>
	 * 	<li>Click Next</li>
	 * 	<li>Get outside frames</li>
	 * 	<li>Get inside the attach document frame</li>
	 * 	<li>Click Finished</li>
	 * 	<li>Get outside frames</li>
	 * 	<li>Verify you land on the orders grid</li>
	 * 	<li>Set 40 second while loop timeout</li>
	 * 	<li>Query the db to get the order number that was just created</li>
	 * 	<li>Search for the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Verify fee is 300</li>
	 * 	<li>Click Fee Panel</li>
	 * 	<li>View the staff vendor's profile</li>
	 * 	<li>Switch to iFrame</li>
	 * 	<li>Click the Assignment tab</li>
	 * 	<li>Check the option Do not show order fee on assignment</li>
	 * 	<li>Click Save</li>
	 * 	<li>Switch out of iframe</li>
	 * 	<li>Go to new Residential Appraisal</li>
	 * 	<li>Enter New Order data</li>
	 * 	<li>Click Next</li>
	 * 	<li>Assign the order to the staff appraiser</li>
	 * 	<li>Verify Confirm Order url</li>
	 * 	<li>Verify the order fee displays Staff</li>
	 * 	<li>Click Next</li>
	 * 	<li>Get outside frames</li>
	 * 	<li>Get inside the attach document frame</li>
	 * 	<li>Click Finished</li>
	 * 	<li>Get outside frames</li>
	 * 	<li>Verify you land on the orders grid</li>
	 * 	<li>Set 40 second while loop timeout</li>
	 * 	<li>Query the db to get the order number that was just created</li>
	 * 	<li>Search for the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Verify fee is Staff</li>
	 * 	<li>View the assigned vendor's profile from the order details</li>
	 * 	<li>Switch to iFrame</li>
	 * 	<li>Click the Notes tab</li>
	 * 	<li>Verify a note was added when they were marked as staff</li>
	 * 	<li>Click Cancel</li>
	 * 	<li>Switch out of iframe</li>
	 * 	<li>Log into Vendors as the staff appraiser</li>
	 * 	<li>Search for the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Verify the order fee shows 'Staff'</li>
	 * 	<li>Log test</li>
	 * </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Vendor Selection Settings", "Secure - Fee Panel", "Secure - Vendor Profile", "Secure - Create Order", "Secure - Modify Selection Settings", "Secure - Require Staff Vendor", "Secure - Orders", "Vendors - Orders", "Vendor Order Capcity"}, alwaysRun=true)
	public void requireStaffVendor() throws Exception{

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		String env = StoredVariables.getusernameEnvironment().get();
		
		// Login to secure
		secure.login(driver, "VendorOrderCapacity1", StoredVariables.getpassword().get());
		
		// Click Preferences > Vendor Selection Settings
		secure.goToVendorSelectionSettings(driver);
		
		// Uncheck all ISS check boxes
		secure.uncheckISSCheckboxes(driver);
		
		// Enable Require staff vendor
		perform.checkCheckbox(driver, SVendorSelectionSettings.requireStaffVendor_chkbx(driver));
		
		// Set option to Prefer
		perform.selectDropdownOption(driver, SVendorSelectionSettings.requireStaffVendor_dropdown(driver), "Prefer");
		
		// Click Save
		secure.saveVendorSelectionSettings(driver);
		
		// Click Fee Panel
		secure.goToFeePanel(driver);

		// View profile
		String text = "Automation" + env + "VendorOrderCapacityAppraiser1";
		secure.viewVendorProfileByCompanyName(driver, text);
		
		// Click Assignment tab
		perform.click(driver,SProfile.assignment_tab(driver));
		
		// Wait for staff/salaried vendor checkbox
		perform.waitForElementToBeClickable(driver, SProfile.staffSalariedVendor_chkbx(), "id");
		
		// Check Staff/salaried vendor box and Save
		perform.checkCheckbox(driver, SProfile.staffSalariedVendor_chkbx(driver));
		
		// Uncheck Do not show order fee on assignment
		perform.uncheckCheckbox(driver, SProfile.doNotShowOrderFeeOnAssignment_chkbx(driver));
		
		Thread.sleep(1500);
		
		// Click Save
		perform.click(driver,SProfile.save_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Switch out of iframe
		driver.switchTo().defaultContent();
		
		// Go to new Residential Appraisal
		secure.goToResidentialAppraisal(driver);
		
		// Place a new order
		/***************************************
		 * Set New Order Information
		 ***************************************/
		perform.clearOrderInfoStoredVariables(driver);
		secure.setNewResidentialAppraisalOrderVariablesMinimum(driver);
		
		// Enter New Order data
		secure.enterNewResidentialAppraisalOrder(driver);
		
		// Click Next
		perform.click(driver,SNewOrder.next_btn(driver));
		
		Thread.sleep(1000);
		
		// Close Related Orders popup
		secure.checkForRelatedOrdersDialog(driver);
		
		// Wait for Search tab
		perform.waitForElementToBeClickable(driver, SVendorSelection.search_tab(), "id");
		
		// Get first appraiser name in the list
		String firstAppraiser = SVendorSelection.vendorSearchResultFirstName_txt(driver).getText();
		
		// Verify first appraiser is Automation VendorOrderCapacityAppraiser1
		Assert.assertTrue(firstAppraiser.equals("Automation VendorOrderCapacityAppraiser1"), "Automation VendorOrderCapacityAppraiser1 is not the first vendor and should be");
		
		// Click Back
		perform.click(driver,SVendorSelection.backTop_btn(driver));
		
		// Wait for Address txtbx
		perform.waitForElementToBeClickable(driver, SNewOrder.address_txtbx(), "id");
		
		// Click Modify Selection Settings
		perform.clickInTable_Equals(driver, "Modify selection settings");
		
		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for Require valid license checkbox
		perform.waitForElementToBeClickable(driver, SModifySelectionSettings.requireValidLicense_chkbx(), "id");
		
		// Change Require staff vendor to Require instead of Prefer
		perform.selectDropdownOption(driver, SModifySelectionSettings.requireStaffVendor_dropdown(driver), "Require");
		
		// Click OK
		perform.click(driver,SModifySelectionSettings.ok_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Click Next
		perform.click(driver,SNewOrder.next_btn(driver));
		
		Thread.sleep(1000);
		
		// Close Related Orders popup
		secure.checkForRelatedOrdersDialog(driver);
		
		// Wait for Search tab
		perform.waitForElementToBeClickable(driver, SVendorSelection.search_tab(), "id");
		
		// Count the number of rows for appraisers and verify there is only 1 row
		List<WebElement> rows = driver.findElements(By.cssSelector("#tblFeePanel > tbody > tr"));
		Assert.assertTrue(rows.size()==1, "There is only supposed to be 1 row, but there are " + rows.size());
		
		// Verify only staff appraisers are shown as eligible
		String feePanelText = SVendorSelection.feePanelTable_txt(driver).getText();
		System.out.println("feePanelText = " + feePanelText);
		
		// Verify only staff appraisers are shown as eligible
		Assert.assertTrue(!feePanelText.contains("Automation Appraiser"), "Only staff appraisers should be displayed but others are as well");
		Assert.assertTrue(feePanelText.contains("Automation VendorOrderCapacityAppraiser1"), "Automation VendorOrderCapacityAppraiser1 should be displayed but it is not");
		
		// Assign the order to the staff appraiser
		secure.selectVendor(driver, "Automation VendorOrderCapacityAppraiser1");
		
		// Wait for Require Mismo XML checkbox to be clickable
		perform.waitForElementToBeClickable(driver, SConfirmOrder.requireMismoXml_chkbx(), "id");
		
		// Verify Confirm Order url
		Assert.assertTrue(driver.getCurrentUrl().contains("ConfirmOrder"), "The Confirm Order screen did not load properly");
		
		// Verify the order fee displays correctly 
		Assert.assertTrue(SConfirmOrder.orderFee_txtbx(driver).getAttribute("value").equals("300"), "Order fee should be 300");
		
		// Click Next
		perform.click(driver,SConfirmOrder.nextBottom_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Get outside frames
		driver.switchTo().defaultContent();
		// Get inside the attach document frame
		driver.switchTo().frame("iframeAttach");
		
		// Wait for message text
		perform.waitForElementToBeClickable(driver, SConfirmOrder.finished_btn(), "id");
		
		// Click Finished
		perform.click(driver,SConfirmOrder.finished_btn(driver));
		
		// Get outside frames
		driver.switchTo().defaultContent();
		
		// Wait for Orders page to load
		perform.waitForElementToBeClickable(driver, SOrders.orderTypes_dropdown(), "id");
		
		// Verify you land on the orders grid
		String url = driver.getCurrentUrl();
		// Set 40 second while loop timeout
		long start_time = System.currentTimeMillis();
		long wait_time = 40000;
		long end_time = start_time + wait_time;
		while (System.currentTimeMillis() < end_time && !url.contains("OrderManagement"))
		{
			url = driver.getCurrentUrl();
			if (url.contains("OrderManagement"))
			{
				break;
			}
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("OrderManagement"), "After completing an order, the orders grid did not load");
		
		// Query the db to get the order number that was just created
		db.getLoanID(driver);
		String trackingNumber = StoredVariables.gettrackingNumber().get();
		
		// Search for the order
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Open the order
		perform.doubleClickInTable(driver, trackingNumber);

		// Wait for Order fee text
		perform.waitForElementToBeVisible(driver, SOrderDetails.orderFee_txt(), "cssSelector");
		
		// Verify fee is 300
		Assert.assertTrue(SOrderDetails.orderFee_txt(driver).getText().equals("300"), "Fee should be 300 but is = " + SOrderDetails.orderFee_txt(driver).getText());
		
		// Click Fee Panel
		secure.goToFeePanel(driver);
		
		// View the staff vendor's profile
		text = "Automation" + env + "VendorOrderCapacityAppraiser1";
		secure.viewVendorProfileByCompanyName(driver, text);
		
		// Click the Assignment tab
		perform.click(driver,SProfile.assignment_tab(driver));
		
		// Wait for do not show order fee on assignment checkbox
		perform.waitForElementToBeClickable(driver, SProfile.doNotShowOrderFeeOnAssignment_chkbx(), "id");
		
		// Check the option Do not show order fee on assignment
		perform.checkCheckbox(driver, SProfile.doNotShowOrderFeeOnAssignment_chkbx(driver));
		
		Thread.sleep(1500);
		
		// Click Save
		perform.click(driver,SProfile.save_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Switch out of iframe
		driver.switchTo().defaultContent();
		
		// Go to new Residential Appraisal
		secure.goToResidentialAppraisal(driver);
		
		// Enter New Order data
		secure.enterNewResidentialAppraisalOrder(driver);
		
		// Click Next
		perform.click(driver,SNewOrder.next_btn(driver));
		
		Thread.sleep(1000);
		
		// Assign the order to the staff appraiser
		secure.selectVendor(driver, "Automation VendorOrderCapacityAppraiser1");
		
		// Wait for Require Mismo XML checkbox to be clickable
		perform.waitForElementToBeClickable(driver, SConfirmOrder.requireMismoXml_chkbx(), "id");
		
		// Verify Confirm Order url
		Assert.assertTrue(driver.getCurrentUrl().contains("ConfirmOrder"), "The Confirm Order screen did not load properly");
		
		// Verify the order fee displays Staff 
		Assert.assertTrue(SConfirmOrder.orderFeeStaff_txtbx(driver).getText().equals("Staff"), "Order fee should be set to Staff");
		
		// Click Next
		perform.click(driver,SConfirmOrder.nextBottom_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Get outside frames
		driver.switchTo().defaultContent();
		// Get inside the attach document frame
		driver.switchTo().frame("iframeAttach");
		
		// Wait for message text
		perform.waitForElementToBeClickable(driver, SConfirmOrder.finished_btn(), "id");
		
		// Click Finished
		perform.click(driver,SConfirmOrder.finished_btn(driver));
		
		// Get outside frames
		driver.switchTo().defaultContent();
		
		// Wait for Orders page to load
		perform.waitForElementToBeClickable(driver, SOrders.orderTypes_dropdown(), "id");
		
		// Verify you land on the orders grid
		url = driver.getCurrentUrl();
		// Set 40 second while loop timeout
		start_time = System.currentTimeMillis();
		wait_time = 40000;
		end_time = start_time + wait_time;
		while (System.currentTimeMillis() < end_time && !url.contains("OrderManagement"))
		{
			url = driver.getCurrentUrl();
			if (url.contains("OrderManagement"))
			{
				break;
			}
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("OrderManagement"), "After completing an order, the orders grid did not load");
		
		// Query the db to get the order number that was just created
		db.getLoanID(driver);
		trackingNumber = StoredVariables.gettrackingNumber().get();
		
		// Search for the order
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Open the order
		perform.doubleClickInTable(driver, trackingNumber);

		// Wait for Order fee text
		perform.waitForElementToBeVisible(driver, SOrderDetails.orderFee_txt(), "cssSelector");
		
		// Verify fee is Staff
		Assert.assertTrue(SOrderDetails.orderFee_txt(driver).getText().equals("Staff"), "Fee should be Staff but is = " + SOrderDetails.orderFee_txt(driver).getText());
		
		// View the assigned vendor's profile from the order details
		perform.click(driver,SOrderDetails.vendorInformation_btn(driver));
		
		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		// Switch to iFrame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "/Common/VendorProfile/Profile.aspx", By.id(SProfile.notes_tab()));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Click the Notes tab
		perform.click(driver,SProfile.notes_tab(driver));
		
		// Wait for Notes section
		perform.waitForElementToBeClickable(driver, SProfile.notes_txt(), "id");
		
		// Verify a note was added when they were marked as staff
		Assert.assertTrue(SProfile.notes_txt(driver).getText().contains("Marked as staff/salaried vendor"), "A note should have been added when they were marked as staff, but there is not one");
		
		// Click Cancel
		perform.click(driver,SProfile.cancel_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Switch out of iframe
		driver.switchTo().defaultContent();
		
		// Log into Vendors as the staff appraiser
		vendors.login(driver, "VendorOrderCapacityAppraiser1", StoredVariables.getpassword().get());
		
		// Search for the order
		vendors.findOrder(driver, trackingNumber, "Tracking Number");
		
		// Open the order
		perform.doubleClickInTable(driver, "VendorOrderCapacity1");
		
		// Wait for accept button
		perform.waitForElementToBeClickable(driver, VOrderDetails.acceptDecline_btn(), "cssSelector");
		
		// Verify the order fee shows 'Staff'
		Assert.assertTrue(VOrderDetails.orderFee_txt(driver).getText().equals("Staff"), "The Order Fee should be Staff, but it is = " + VOrderDetails.orderFee_txt(driver).getText());
		
		// Log test
		test.log(LogStatus.INFO, "Vendor Order Capacity", "Verified vendor can assign an order to a staff vendor");
		
	} // end requireStaffVendor
	
} // end the OrderManagement class
