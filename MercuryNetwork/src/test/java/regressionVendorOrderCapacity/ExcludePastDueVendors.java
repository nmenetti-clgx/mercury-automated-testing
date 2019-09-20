package regressionVendorOrderCapacity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjects.Secure.SNewOrder;
import pageObjects.Secure.SVendorSelection;
import pageObjects.Secure.SVendorSelectionSettings;
import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Vendor Order Capacity - Exclude Past Due Vendors</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class ExcludePastDueVendors extends TestSetup {
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to secure</li>
	 * 	<li>Click Preferences &gt; Vendor Selection Settings</li>
	 * 	<li>Uncheck all ISS check boxes</li>
	 * 	<li>Enable Exclude past due vendors</li>
	 * 	<li>Click Save</li>
	 * 	<li>Verify Exclude past due vendors checkbox is checked</li>
	 * 	<li>Go to new Residential Appraisal</li>
	 * 	<li>Place a new order</li>
	 * 	<li>Enter New Order data</li>
	 * 	<li>Click Next</li>
	 * 	<li>Verify there are no vendors in the Fee Panel</li>
	 * 	<li>Log test</li>
	 * </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Vendor Selection Settings", "Vendor Order Capcity", "Secure - Create Order", "Vendor Order Capcity"}, alwaysRun=true)
	public void excludePastDueVendors() throws Exception{

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Login to secure
		secure.login(driver, "VendorOrderCapacity3", StoredVariables.getpassword().get());
		
		// Click Preferences > Vendor Selection Settings
		secure.goToVendorSelectionSettings(driver);
		
		// Uncheck all ISS check boxes
		secure.uncheckISSCheckboxes(driver);
		
		// Enable Exclude past due vendors
		if (SVendorSelectionSettings.excludePastDueVendors_chkbx(driver).isSelected()==false)
		{
			perform.click(driver, SVendorSelectionSettings.excludePastDueVendors_chkbx(driver));
		}
		
		// Click Save
		secure.saveVendorSelectionSettings(driver);
		
		// Verify Exclude past due vendors checkbox is checked
		Assert.assertTrue(SVendorSelectionSettings.excludePastDueVendors_chkbx(driver).isSelected()==true, "The Exclude past due vendors checkbox should be checked");
		
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
		perform.click(driver, SNewOrder.next_btn(driver));
		
		Thread.sleep(1000);
		
		// Close Related Orders popup
		secure.checkForRelatedOrdersDialog(driver);
		
		// Wait for Search tab
		perform.waitForElementToBeClickable(driver, SVendorSelection.search_tab(), "id");
		
		// Verify there are no vendors in the Fee Panel
		WebElement vendors = driver.findElement(By.cssSelector("#tab0content > div.NoRows > div > div"));
		Assert.assertTrue(vendors.getText().contains("No fee panel vendors found."), "There should not be any vendors in the fee panel");
		
		// Log test
		test.log(LogStatus.INFO, "Vendor Order Capacity", "Verified vendors who are past due are not includded in the list when placing an order");
		
	} // end excludePastDueVendors
	
} // end the OrderManagement class
