package regressionVendorOrderCapacity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Secure.SFeePanel;
import pageObjects.Secure.SModifySelectionSettings;
import pageObjects.Secure.SNewOrder;
import pageObjects.Secure.SProfile;
import pageObjects.Secure.SVendorSelection;
import pageObjects.Secure.SVendorSelectionSettings;
import setup.DriverFactory;
import setup.TestSetup;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Vendor Order Capacity - Limit Vendor Capacity</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   04-30-2019
 */

@Listeners(utils.Listener.class)
public class LimitVendorCapacity extends TestSetup {

	/** The user secure. */
	private final String userSecure = "VendorOrderCapacity4";
	
	/** The user vendors. */
	private final String userVendors = "VendorOrderCapacityAppraiser2";
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 *  <li>Login to Vendors</li>
	 *  <li>Delete all orders</li>
	 * 	<li>Login to secure</li>
	 * 	<li>Click Preferences &gt; Vendor Selection Settings</li>
	 * 	<li>Uncheck all ISS check boxes</li>
	 * 	<li>Enable Limit vendor capacity</li>
	 * 	<li>Set option to Prefer</li>
	 * 	<li>Set capacity to 2</li>
	 * 	<li>Click Save</li>
	 * 	<li>Click Save Custom Settings</li>
	 * 	<li>Click OK</li>
	 * 	<li>Click Fee Panel</li>
	 * 	<li>View the vendor's profile</li>
	 * 	<li>Switch to iFrame</li>
	 * 	<li>Click the Assignment tab</li>
	 * 	<li>Assign the vendor an individual capacity different (greater) from the global and save</li>
	 * 	<li>Click Save</li>
	 * 	<li>Create 2 new Residential Appraisal orders</li>
	 * 	<li>Go to Residential Appraisal</li>
	 * 	<li>Place a new order</li>
	 * 	<li>Enter New Order data</li>
	 * 	<li>Click Next</li>
	 * 	<li>Get first appraiser name in the list</li>
	 * 	<li>Verify first appraiser is Automation VendorOrderCapacityAppraiser2</li>
	 * 	<li>View the vendor's profile</li>
	 * 	<li>Switch to iFrame</li>
	 * 	<li>Click the Notes tab</li>
	 * 	<li>Verify a note was added listing the limit vendor capacity maximum</li>
	 * 	<li>Click Cancel</li>
	 * 	<li>Click Back</li>
	 * 	<li>Click Modify Selection Settings</li>
	 * 	<li>Change the capacity to Require instead of Prefer</li>
	 * 	<li>Click OK</li>
	 * 	<li>Click Next</li>
	 * 	<li>Verify there are no vendors in the Fee Panel</li>
	 * 	<li>Click Fee Panel</li>
	 * 	<li>View the vendor's profile</li>
	 * 	<li>Switch to iFrame</li>
	 * 	<li>Click the Assignment tab</li>
	 * 	<li>Assign the vendor an individual capacity different (greater) from the global and save</li>
	 * 	<li>Click Save</li>
	 * 	<li>Go to Residential Appraisal</li>
	 * 	<li>Enter New Order data</li>
	 * 	<li>Click Modify Selection Settings</li>
	 * 	<li>Change the capacity to Require instead of Prefer</li>
	 * 	<li>Click OK</li>
	 * 	<li>Click Next</li>
	 * 	<li>Get first appraiser name in the list</li>
	 * 	<li>Verify first appraiser is Automation VendorOrderCapacityAppraiser1</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Vendor Selection Settings", "Secure - Fee Panel", "Secure - Vendor Profile", "Secure - Create Order", "Secure - Modify Selection Settings", "Vendor Order Capcity"}, alwaysRun=true)
	public void limitVendorCapacity() throws Exception{
		
		// Create the driver
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Create new orders if necessary
//		createNewOrders(driver);
		
		// Set the password
		String password = StoredVariables.getpassword().get();
		
		// Login to secure
		secure.login(driver, userSecure, password);
		
		// Click Preferences > Vendor Selection Settings
		secure.goToVendorSelectionSettings(driver);
		
		// Uncheck all ISS check boxes
		secure.uncheckISSCheckboxes(driver);
		
		// Enable Limit vendor capacity
		if (SVendorSelectionSettings.limitVendorCapacity_chkbx(driver).isSelected()==false)
		{
			perform.click(driver,SVendorSelectionSettings.limitVendorCapacity_chkbx(driver));
		}
		
		// Set option to Prefer
		perform.selectDropdownOption(driver, SVendorSelectionSettings.limitVendorCapacity_dropdown(driver), "Prefer");
		
		// Set capacity to 2
		SVendorSelectionSettings.limitVendorCapacityOpenOrders_txtbx(driver).clear();
		perform.type(driver,SVendorSelectionSettings.limitVendorCapacityOpenOrders_txtbx(driver), "2");
		
		// Click Save
		perform.click(driver,SVendorSelectionSettings.save_btn(driver));
		
		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for Save Custom Settings button
		perform.waitForElementToBeClickable(driver, SVendorSelectionSettings.saveCustomSettings_btn(), "id");
		
		// Click Save Custom Settings 
		perform.click(driver,SVendorSelectionSettings.saveCustomSettings_btn(driver));
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SVendorSelectionSettings.ok_btn(), "id");
		
		// Click OK
		perform.click(driver,SVendorSelectionSettings.ok_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Click Fee Panel
		secure.goToFeePanel(driver);
		
		// View the vendor's profile
		perform.click(driver,SFeePanel.viewProfileFirstRow_btn(driver));
		
		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		// Switch to iFrame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "/Common/VendorProfile/Profile.aspx", By.id(SProfile.assignment_tab()));
		
		// Click the Assignment tab
		perform.click(driver,SProfile.assignment_tab(driver));
		
		// Wait for capacity textbox
		perform.waitForElementToBeClickable(driver, SProfile.capacity_txtbx(), "id");
		
		// Assign the vendor an individual capacity different (greater) from the global and save
		SProfile.capacity_txtbx(driver).clear();
		perform.type(driver,SProfile.capacity_txtbx(driver), "2");
		
		// Click Save
		perform.click(driver,SProfile.save_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Switch out of iFrame
		driver.switchTo().defaultContent();
		
		// Go to Residential Appraisal
		secure.goToResidentialAppraisal(driver);
		
		// Place a new order
		/***************************************
		 * Set New Order Information
		 ***************************************/
		perform.clearOrderInfoStoredVariables(driver);
		secure.setNewResidentialAppraisalOrderVariablesMinimum(driver);
		StoredVariables.getassignmentInformationOrderDue().set(7);
		
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
		
		// Verify first appraiser is Automation VendorOrderCapacityAppraiser2
		Assert.assertTrue(firstAppraiser.equals("Automation VendorOrderCapacityAppraiser2"), "Automation VendorOrderCapacityAppraiser2 is not the first vendor and should be");
		
		// View the vendor's profile
		perform.click(driver,SVendorSelection.viewProfileFirstRow_btn(driver));
		
		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		Thread.sleep(3000);
		
		// Switch to iFrame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "/Common/VendorProfile/Profile.aspx", By.id(SProfile.notes_tab()));
		
		// Wait for Notes button
		perform.waitForElementToBeClickable(driver, SProfile.notes_tab(), "id");
		
		// Click the Notes tab
		perform.click(driver,SProfile.notes_tab(driver));
		
		// Wait for notes text
		perform.waitForElementToBeClickable(driver, SProfile.notes_txt(), "id");
		
		// Verify a note was added listing the limit vendor capacity maximum
		perform.verification(driver, SProfile.notes_txt(driver).getText(), "contains", "Global maximum capacity for Residential appraisal set (2)");
		perform.verification(driver, SProfile.notesFirstRow_txt(driver).getText(), "contains", "Individual maximum capacity set (2)");
//		perform.verification(driver, SProfile.notesFirstRow_txt(driver).getText(), "contains", StoredVariables.gettodaysDateLong().get());
		
		// Click Cancel
		perform.click(driver,SProfile.cancel_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Switch out of iFrame
		driver.switchTo().defaultContent();
		
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
		
		// Change the capacity to Require instead of Prefer
		perform.selectDropdownOption(driver, SModifySelectionSettings.limitVendorCapacity_dropdown(driver), "Require");
		
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
		
		// Verify there are no vendors in the Fee Panel
		WebElement vendors = driver.findElement(By.cssSelector("#tab0content > div.NoRows > div > div"));
		Assert.assertTrue(vendors.getText().contains("No fee panel vendors found."), "There should not be any vendors in the fee panel");
		
		// Click Fee Panel
		secure.goToFeePanel(driver);
		
		// View the vendor's profile
		perform.click(driver,SFeePanel.viewProfileFirstRow_btn(driver));
		
		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Switch to iFrame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "/Common/VendorProfile/Profile.aspx", By.id(SProfile.assignment_tab()));
		
		// Click the Assignment tab
		perform.click(driver,SProfile.assignment_tab(driver));
		
		// Wait for capacity textbox
		perform.waitForElementToBeClickable(driver, SProfile.capacity_txtbx(), "id");
		
		// Assign the vendor an individual capacity different (greater) from the global and save
		SProfile.capacity_txtbx(driver).clear();
		perform.type(driver,SProfile.capacity_txtbx(driver), "30");
		
		// Click Save
		perform.click(driver,SProfile.save_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Switch out of iFrame
		driver.switchTo().defaultContent();
		
		// Go to Residential Appraisal
		secure.goToResidentialAppraisal(driver);
		
		// Enter New Order data
		secure.enterNewResidentialAppraisalOrder(driver);

		// Click Modify Selection Settings
		perform.clickInTable_Equals(driver, "Modify selection settings");
		
		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for Require valid license checkbox
		perform.waitForElementToBeClickable(driver, SModifySelectionSettings.requireValidLicense_chkbx(), "id");
		
		// Change the capacity to Require instead of Prefer
		perform.selectDropdownOption(driver, SModifySelectionSettings.limitVendorCapacity_dropdown(driver), "Require");
		
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
		
		// Get first appraiser name in the list
		firstAppraiser = driver.findElement(By.cssSelector("#tblFeePanel > tbody > tr:nth-child(1) > td:nth-child(5)")).getText();
		
		// Verify first appraiser is Automation VendorOrderCapacityAppraiser1
		Assert.assertTrue(firstAppraiser.equals("Automation VendorOrderCapacityAppraiser2"), "Automation VendorOrderCapacityAppraiser2 is not the first vendor and should be. Screen equals" + firstAppraiser);
		
		// Log test
		perform.addInfoToExtentReport(driver, "Vendor Order Capacity", "Verified vendors who exceed the order capacity are not in the list");
		
	} // end limitVendorCapacity
	
	/**
	 * Creates new orders to be used.
	 *
	 * @param driver the driver
	 * @throws Exception the exception
	 */
	@SuppressWarnings("unused")
	private void createNewOrders (RemoteWebDriver driver) throws Exception {
		
		String password = StoredVariables.getpassword().get();
		
		// Login to Vendors
		vendors.login(driver, "VendorOrderCapacityAppraiser2", password);
		
		// Delete all orders
//		vendors.deleteOrders(driver);
		
		// Create 2 new Residential Appraisal orders
		String trackingNumber;
		for (int i = 0; i < 2; i++) {
			perform.apiPlaceOrderFromSecure(driver, userSecure, password, "PlaceMNOrder-LimitVendorCapacity");
			trackingNumber = StoredVariables.gettrackingNumber().get();
			secure.loginAndAssignOrderToAppraiser(driver, userSecure, password, trackingNumber, userVendors);
			vendors.loginAndAcceptOrder(driver, userVendors, password, trackingNumber);
//			vendors.completeOrderByHTTPPost(driver, userVendors, password, trackingNumber, "Complete.xml");
		} // end for loop		
		
	} // createNewOrders
	
} // end the OrderManagement class
