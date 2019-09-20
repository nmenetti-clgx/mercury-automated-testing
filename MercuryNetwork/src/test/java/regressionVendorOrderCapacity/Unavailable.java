package regressionVendorOrderCapacity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjects.Secure.SFeePanel;
import pageObjects.Secure.SNewOrder;
import pageObjects.Secure.SVendorSelection;
import pageObjects.Vendors.VUsers;
import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Vendor Order Capacity - Unavailable</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class Unavailable extends TestSetup {
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Vendors</li>
	 * 	<li>Go to Users</li>
	 * 	<li>Click My Panels</li>
	 * 	<li>Select one of the fee panel memberships and click Set dates under Unavailable column</li>
	 * 	<li>Click Set Dates</li>
	 * 	<li>Click unavailable link</li>
	 * 	<li>Enter a date leaving</li>
	 * 	<li>Enter date returning</li>
	 * 	<li>click OK</li>
	 * 	<li>Click Set Dates</li>
	 * 	<li>Enter a date leaving</li>
	 * 	<li>Enter date returning</li>
	 * 	<li>click OK</li>
	 * 	<li>Save</li>
	 * 	<li>Verify the dates show in the Unavailable column</li>
	 * 	<li>Log into Secure as the selected fee panel membership user</li>
	 * 	<li>Click on Fee Panel</li>
	 * 	<li>View the vendor in the Fee Panel list</li>
	 * 	<li>Verify one of the alerts shows the vendor is out of office until X date</li>
	 * 	<li>Go to new Residential Appraisal</li>
	 * 	<li>Place a new order</li>
	 * 	<li>Enter New Order data</li>
	 * 	<li>Click Next</li>
	 * 	<li>Verify there are no vendors in the Fee Panel</li>
	 * 	<li>Log test</li>
	 * </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Vendors - Users", "Vendors - My Panels", "Secure - Fee Panel", "Secure - Create Order", "Vendor Order Capcity"}, alwaysRun=true)
	public void unavailable() throws Exception{

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Login to Vendors
		vendors.login(driver, "VendorOrderCapacityAppraiser6", StoredVariables.getpassword().get());
		
		// Go to Users
		vendors.goToUsers(driver);
		
		// Click My Panels
		perform.click(driver,VUsers.myPanels_btn(driver));
		
		// Wait for Remove button
		perform.waitForElementToBeClickable(driver, VUsers.remove_btn(), "cssSelector");
		
		// Select one of the fee panel memberships and click Set dates under Unavailable column
		try
		{
			// Click Set Dates
			perform.click(driver,driver.findElement(By.linkText("Set dates")));
		}
		catch (Exception e)
		{
			// Click unavailable link
			perform.click(driver,driver.findElement(By.cssSelector("#_scroll > table > tbody > tr > td:nth-child(5) > a")));
			
			// Wait for overlay
			perform.waitForOverlayToBeVisible(driver);
			
			// Wait for OK button
			perform.waitForElementToBeClickable(driver, VUsers.okUnavailable_btn(), "cssSelector");
			
			// Enter a date leaving 
			VUsers.dateLeaving_txtbx(driver).clear();
			
			// Enter date returning
			VUsers.dateReturning_txtbx(driver).clear();
			
			// click OK   
			perform.click(driver,VUsers.okUnavailable_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			// Click Set Dates
			perform.click(driver,driver.findElement(By.linkText("Set dates")));
		}
		
		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, VUsers.okUnavailable_btn(), "cssSelector");
		
		// Enter a date leaving 
		perform.getNewDate(driver, 0);
		String leaving = StoredVariables.getnewDateLong().get();
		perform.type(driver,VUsers.dateLeaving_txtbx(driver), leaving);
		
		// Enter date returning
		perform.getNewDate(driver, 5);
		String returning = StoredVariables.getnewDateLong().get();
		perform.type(driver,VUsers.dateReturning_txtbx(driver), returning);
		
		// click OK   
		perform.click(driver,VUsers.okUnavailable_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Save
		vendors.saveUsersSettings(driver);
		
		// Verify the dates show in the Unavailable column
		String unavailable = leaving + " - " + returning;
		String unavailableText = driver.findElement(By.cssSelector("#_scroll > table > tbody > tr > td:nth-child(5)")).getText();
		Assert.assertTrue(unavailableText.contains(unavailable), "Unavailable dates are not correct. Should be = " + unavailable);
		
		// Log into Secure as the selected fee panel membership user
		secure.login(driver, "VendorOrderCapacity6", StoredVariables.getpassword().get());
		
		// Click on Fee Panel
		secure.goToFeePanel(driver);
		
		// Wait for link
		perform.waitForElementToBeClickable(driver, "View", "linkText");
		
		// View the vendor in the Fee Panel list
		perform.clickInTable_Equals(driver, "VendorOrderCapacityAppraiser6");
		
		// Verify one of the alerts shows the vendor is out of office until X date
		Assert.assertTrue(SFeePanel.notices_txt(driver).getText().contains("Vendor is marked out of office and unavailable for new order assignments until " + returning), "There should be a notice stating that the vendor is unavailable until " + returning);
		
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
		
		// Verify there are no vendors in the Fee Panel
		WebElement vendors = driver.findElement(By.cssSelector("#tab0content > div.NoRows > div > div"));
		Assert.assertTrue(vendors.getText().contains("No fee panel vendors found."), "There should not be any vendors in the fee panel");
		
		// Log test
		test.log(LogStatus.INFO, "Vendor Order Capacity", "Verified vendor who was marked away is unavailbe to be assigned");
		
	} // end unavailable
	
} // end the OrderManagement class
