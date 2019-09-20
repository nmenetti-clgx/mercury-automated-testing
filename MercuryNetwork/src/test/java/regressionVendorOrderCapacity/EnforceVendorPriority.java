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

import pageObjects.Secure.SFeePanel;
import pageObjects.Secure.SModifySelectionSettings;
import pageObjects.Secure.SNewOrder;
import pageObjects.Secure.SProfile;
import pageObjects.Secure.SVendorSelection;
import pageObjects.Secure.SVendorSelectionSettings;
import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Vendor Order Capacity - Enforce Vendor Priority</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class EnforceVendorPriority extends TestSetup {
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to secure</li>
	 * 	<li>Click Preferences &gt; Vendor Selection Settings</li>
	 * 	<li>Uncheck all ISS check boxes</li>
	 * 	<li>Enable Enforce vendor priority</li>
	 * 	<li>Check option to Consider unranked vendors</li>
	 * 	<li>Click Save</li>
	 * 	<li>Verify the Enforce vendor priority and Consider unranked vendors checkbox is checked</li>
	 * 	<li>Click Fee Panel</li>
	 * 	<li>View the vendor's profile</li>
	 * 	<li>Switch to iFrame</li>
	 * 	<li>Click the Assignment tab</li>
	 * 	<li>Assign the vendor a priority and click OK</li>
	 * 	<li>Click Save</li>
	 * 	<li>View the vendor's profile</li>
	 * 	<li>Switch to iFrame</li>
	 * 	<li>Click the Assignment tab</li>
	 * 	<li>Assign the vendor a priority and click OK</li>
	 * 	<li>Click Save</li>
	 * 	<li>View the vendor's profile</li>
	 * 	<li>Switch to iFrame</li>
	 * 	<li>Click the Notes tab</li>
	 * 	<li>Verify a note was added listing the priority ranking</li>
	 * 	<li>Click Save</li>
	 * 	<li>Go to Residential Appraisal</li>
	 * 	<li>Place a new order</li>
	 * 	<li>Enter New Order data</li>
	 * 	<li>Click Next</li>
	 * 	<li>Verify only vendors with a priority ranking are eligible</li>
	 * 	<li>Verify there are only 2 rows</li>
	 * 	<li>Get first appraiser name in the list</li>
	 * 	<li>Verify first appraiser is Automation VendorOrderCapacityAppraiser4</li>
	 * 	<li>Get second appraiser name in the list</li>
	 * 	<li>Verify second appraiser is Automation VendorOrderCapacityAppraiser3</li>
	 * 	<li>Get third appraiser name in the list</li>
	 * 	<li>Verify third appraiser is Automation VendorOrderCapacityAppraiser5</li>
	 * 	<li>Click Back</li>
	 * 	<li>Click Modify Selection Settings</li>
	 * 	<li>Uncheck the option to consider unranked vendors</li>
	 * 	<li>Click OK</li>
	 * 	<li>Click Next</li>
	 * 	<li>Verify only vendors with a priority ranking are eligible</li>
	 * 	<li>Verify there are only 2 rows</li>
	 * 	<li>Log test</li>
	 * </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Vendor Order Capcity", "Secure - Vendor Selection Settings", "Secure - Fee Panel", "Secure - Vendor Profile", "Secure - Create Order", "Secure - Modify Selection Settings", ""}, alwaysRun=true)
	public void enforceVendorPriority() throws Exception{

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Login to secure
		secure.login(driver, "VendorOrderCapacity5", StoredVariables.getpassword().get());
		
		// Click Preferences > Vendor Selection Settings
		secure.goToVendorSelectionSettings(driver);
		
		// Uncheck all ISS check boxes
		secure.uncheckISSCheckboxes(driver);
		
		// Enable Enforce vendor priority
		if (SVendorSelectionSettings.enforceVendorPriority_chkbx(driver).isSelected()==false)
		{
			perform.click(driver,SVendorSelectionSettings.enforceVendorPriority_chkbx(driver));
		}
		
		// Check option to Consider unranked vendors
		if (SVendorSelectionSettings.considerUnrankedVendors_chkbx(driver).isSelected()==false)
		{
			perform.click(driver,SVendorSelectionSettings.considerUnrankedVendors_chkbx(driver));
		}
		
		// Click Save
		secure.saveVendorSelectionSettings(driver);
		
		// Verify the Enforce vendor priority and Consider unranked vendors checkbox is checked
		Assert.assertTrue(SVendorSelectionSettings.enforceVendorPriority_chkbx(driver).isSelected()==true, "The Enforce vendor priority checkbox should be checked");
		Assert.assertTrue(SVendorSelectionSettings.considerUnrankedVendors_chkbx(driver).isSelected()==true, "The Consider unranked vendors checkbox should be checked");
		
		// Click Fee Panel
		secure.goToFeePanel(driver);
		
		// View the vendor's profile
		perform.click(driver,SFeePanel.viewProfileFirstRow_btn(driver));
		
		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		// Switch to iFrame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "/Common/VendorProfile/Profile.aspx", By.id(SProfile.assignment_tab()));
		
		// Wait for Assignment button
		perform.waitForElementToBeClickable(driver, SProfile.assignment_tab(), "id");
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Click the Assignment tab
		perform.click(driver,SProfile.assignment_tab(driver));
		
		// Wait for Staff/salaried vendor checkbox
		perform.waitForElementToBeClickable(driver, SProfile.staffSalariedVendor_chkbx(), "id");
		
		// Assign the vendor a priority and click OK
		perform.selectDropdownOption(driver, SProfile.vendorPriority_dropdown(driver), "3");
		
		// Click Save
		perform.click(driver,SProfile.save_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Switch out of iFrame
		driver.switchTo().defaultContent();
		
		// View the vendor's profile
		perform.click(driver,SFeePanel.viewProfileSecondRow_btn(driver));
		
		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		// Switch to iFrame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "/Common/VendorProfile/Profile.aspx", By.id(SProfile.assignment_tab()));

		// Click the Assignment tab
		perform.click(driver,SProfile.assignment_tab(driver));
		
		// Wait for Staff/salaried vendor checkbox
		perform.waitForElementToBeClickable(driver, SProfile.vendorPriority_dropdown(), "id");
		
		// Assign the vendor a priority and click OK
		perform.selectDropdownOption(driver, SProfile.vendorPriority_dropdown(driver), "1");
		
		// Click Save
		perform.click(driver,SProfile.save_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Switch out of iFrame
		driver.switchTo().defaultContent();
		
		// View the vendor's profile
		perform.click(driver,SFeePanel.viewProfileSecondRow_btn(driver));
		
		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		// Switch to iFrame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "/Common/VendorProfile/Profile.aspx", By.id(SProfile.notes_tab()));

		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Click the Notes tab
		perform.click(driver,SProfile.notes_tab(driver));
		
		// Wait for notes text
		perform.waitForElementToBeClickable(driver, SProfile.notes_txt(), "id");
		
		// Verify a note was added listing the priority ranking
		Assert.assertTrue(SProfile.notes_txt(driver).getText().contains("Marked as priority 1 vendor"), "There should be a note that displays the vendor priority");
		
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
		
		// Enter New Order data
		secure.enterNewResidentialAppraisalOrder(driver);
		
		// Click Next
		perform.click(driver,SNewOrder.next_btn(driver));
		
		Thread.sleep(1000);
		
		// Close Related Orders popup
		secure.checkForRelatedOrdersDialog(driver);
		
		// Wait for Search tab
		perform.waitForElementToBeClickable(driver, SVendorSelection.search_tab(), "id");
		
		// Verify only vendors with a priority ranking are eligible
		List<WebElement> numOfRows = driver.findElements(By.cssSelector(SVendorSelection.feePanelTable_rows()));
		
		// Verify there are only 2 rows
		Assert.assertTrue(numOfRows.size()==3, "There should be 3 eligible vendors");
		
		// Get first appraiser name in the list
		String firstAppraiser = SVendorSelection.vendorSearchResultFirstName_txt(driver).getText();
		
		// Verify first appraiser is Automation VendorOrderCapacityAppraiser4
		Assert.assertTrue(firstAppraiser.equals("Automation VendorOrderCapacityAppraiser4"), "Automation VendorOrderCapacityAppraiser4 should be the first vendor. The screen equals " + firstAppraiser);
		
		// Get second appraiser name in the list
		String secondAppraiser = SVendorSelection.vendorSearchResultSecondName_txt(driver).getText();
		
		// Verify second appraiser is Automation VendorOrderCapacityAppraiser3
		Assert.assertTrue(secondAppraiser.equals("Automation VendorOrderCapacityAppraiser3"), "Automation VendorOrderCapacityAppraiser3 should be the second vendor. The screen equals" + secondAppraiser);
		
		// Get third appraiser name in the list
		String thirdAppraiser = SVendorSelection.vendorSearchResultThirdName_txt(driver).getText();
		
		// Verify third appraiser is Automation VendorOrderCapacityAppraiser5
		Assert.assertTrue(thirdAppraiser.equals("Automation VendorOrderCapacityAppraiser5"), "Automation VendorOrderCapacityAppraiser5 should be the third vendor. The screen equals" + thirdAppraiser);
		
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
		
		// Uncheck the option to consider unranked vendors
		if (SModifySelectionSettings.considerUnrankedVendors_chkbx(driver).isSelected() == true)
		{
			perform.click(driver,SModifySelectionSettings.considerUnrankedVendors_chkbx(driver));
		}
		
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
		
		// Verify only vendors with a priority ranking are eligible
		numOfRows = driver.findElements(By.cssSelector(SVendorSelection.feePanelTable_rows()));
		
		// Verify there are only 2 rows
		Assert.assertTrue(numOfRows.size()==2, "There should only be 2 eligible vendors");
		
		// Log test
		test.log(LogStatus.INFO, "Vendor Order Capacity", "Verified vendor whose priority is higher is listed first");
		
	} // end enforceVendorPriority
	
} // end the OrderManagement class
