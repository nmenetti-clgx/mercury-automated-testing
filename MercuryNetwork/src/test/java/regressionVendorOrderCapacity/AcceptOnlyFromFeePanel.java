package regressionVendorOrderCapacity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjects.Secure.SConfirmOrder;
import pageObjects.Secure.SNewOrder;
import pageObjects.Secure.SOrders;
import pageObjects.Secure.SVendorSelection;
import pageObjects.Vendors.VOrders;
import pageObjects.Vendors.VUsers;
import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Vendor Order Capacity - Accept Only From Fee Panel</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class AcceptOnlyFromFeePanel extends TestSetup {
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to vendors</li>
	 * 	<li>Click Users</li>
	 * 	<li>Enable Accept orders from Mercury Network clients</li>
	 * 	<li>Enable Only accept orders from my fee panel clients and save</li>
	 * 	<li>Click Save</li>
	 * 	<li>Click OK</li>
	 * 	<li>Log into Secure as a lender who does not have the vendor in their fee panel</li>
	 * 	<li>Go to Residential Appraisal</li>
	 * 	<li>Enter New Order data</li>
	 * 	<li>Click Next</li>
	 * 	<li>Search for vendor by last name</li>
	 * 	<li>Verify no results were found</li>
	 * 	<li>Get results</li>
	 * 	<li>Verify the user is not in the results</li>
	 * 	<li>Click on ISS</li>
	 * 	<li>Verify the vendor does not show in ISS results</li>
	 * 	<li>Log into Secure as the lender with the vendor on their fee panel</li>
	 * 	<li>Go to Residential Appraisal</li>
	 * 	<li>Enter New Order data</li>
	 * 	<li>Click Next</li>
	 * 	<li>Assign vendor</li>
	 * 	<li>Verify Confirm Order url</li>
	 * 	<li>Click Next</li>
	 * 	<li>Get outside frames</li>
	 * 	<li>Get inside the attach document frame</li>
	 * 	<li>Click Close</li>
	 * 	<li>Get outside frames</li>
	 * 	<li>Verify you land on the orders grid</li>
	 * 	<li>Set 40 second while loop timeout</li>
	 * 	<li>Query the db to get the order number that was just created</li>
	 * 	<li>Login to Vendors</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify order exists</li>
	 * 	<li>Log test</li>
	 * </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Vendors - Users", "Secure - Create Order", "Vendors - Orders", "Vendor Order Capcity"}, alwaysRun=true)
	public void acceptOnlyFromFeePanel() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Login to vendors
		vendors.login(driver, "VendorOrderCapacityAppraiser1", StoredVariables.getpassword().get());
		
		// Go to Users
		vendors.goToUsers(driver);
		
		// Wait for Only accept orders from my fee panel clients checkbox
		perform.waitForElementToBeClickable(driver, VUsers.acceptOrderFromMercuryNetworkClients_chkbx(), "id");
		
		// Enable Accept orders from Mercury Network clients
		if (VUsers.acceptOrderFromMercuryNetworkClients_chkbx(driver).isSelected()==false)
		{
			perform.click(driver,VUsers.acceptOrderFromMercuryNetworkClients_chkbx(driver));	
		}
		Assert.assertTrue(VUsers.acceptOrderFromMercuryNetworkClients_chkbx(driver).isSelected()==true, "Accept orders from Mercury Network clients is not checked");
		
		// Enable Only accept orders from my fee panel clients and save
		if (VUsers.onlyAcceptOrdersFromMyFeePanelClients_checkbox(driver).isSelected()==false)
		{
			perform.click(driver,VUsers.onlyAcceptOrdersFromMyFeePanelClients_checkbox(driver));	
		}
		Assert.assertTrue(VUsers.onlyAcceptOrdersFromMyFeePanelClients_checkbox(driver).isSelected()==true, "Only accept orders from my fee panel clients is not checked");
		
		// Save the settings
		vendors.saveUsersSettings(driver);
		
		// Log into Secure as a lender who does not have the vendor in their fee panel
		secure.login(driver, "VendorOrderCapacity2", StoredVariables.getpassword().get());
		
		// Go to Residential Appraisal
		secure.goToResidentialAppraisal(driver);
		
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
		
		// Search for vendor by last name
		secure.searchVendorByLastNameInVendorSelection(driver, "VendorOrderCapacityAppraiser1");
		
		if (StoredVariables.getusernameEnvironment().get().equals("QA")) {

			// Wait for text
			WebElement noResults = driver.findElement(By.cssSelector("#tab2content > div.psBorder.VendorData.VendorSearch > div.NoRows"));
			perform.waitForText(driver, noResults, "No vendors were found that meet your search criteria.");
	
			// Verify no results were found
			Assert.assertTrue(noResults.getText().contains("No vendors were found that meet your search criteria."), "There should have not been any results found");
			
		} else {
			
			// Get results
			String results = SVendorSelection.searchResultsTable_txt(driver).getText();
			
			// Verify the user is not in the results
			Assert.assertTrue(!results.contains("VendorOrderCapacityAppraiser1"), "The vendor searched for should not be in the results. Results = " + results);
			
		} // end if/else
		
		// Click on ISS
		perform.click(driver,SVendorSelection.issRanked_tab(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Verify the vendor does not show in ISS results
		WebElement issTable = driver.findElement(By.cssSelector("#divAdminMain > div.olContainer.FillSize > div.olContent.PodContainer > div:nth-child(3) > div.TabPanel"));
		Assert.assertTrue(!issTable.getText().contains("VendorOrderCapacityAppraiser1"), "VendorOrderCapacityAppraiser1 should not be in the table");
		
		// Log into Secure as the lender with the vendor on their fee panel 
		secure.login(driver, "VendorOrderCapacity1", StoredVariables.getpassword().get());
		
		// Go to Residential Appraisal
		secure.goToResidentialAppraisal(driver);
		
		// Enter New Order data
		StoredVariables.getassignmentInformationAssignedTo().set("Automation VendorOrderCapacity1");
		secure.enterNewResidentialAppraisalOrder(driver);
		
		// Click Next
		perform.click(driver,SNewOrder.next_btn(driver));
		
		Thread.sleep(1000);
		
		// Wait for Search tab
		perform.waitForElementToBeClickable(driver, SVendorSelection.search_tab(), "id");
		
		// Assign vendor
		secure.selectVendor(driver, "Automation VendorOrderCapacityAppraiser1");
		
		// Wait for Require Mismo XML checkbox to be clickable
		perform.waitForElementToBeClickable(driver, SConfirmOrder.requireMismoXml_chkbx(), "id");
		
		// Verify Confirm Order url
		Assert.assertTrue(driver.getCurrentUrl().contains("ConfirmOrder"), "The Confirm Order screen did not load properly");
		
		secure.verifyOrderDetails(driver);
		
		// Click Next
		perform.click(driver,SConfirmOrder.nextBottom_btn(driver));
		
		Thread.sleep(1000);
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Get outside frames
		driver.switchTo().defaultContent();
		// Get inside the attach document frame
		perform.switchToiFrameByID(driver, "iframeAttach");
		
		// Wait for message text
		perform.waitForElementToBeClickable(driver, SConfirmOrder.finished_btn(), "id");
		
		// Click Close
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
		
		// Login to Vendors
		vendors.login(driver, "VendorOrderCapacityAppraiser1", StoredVariables.getpassword().get());
		
		// Search for order
		vendors.findOrder(driver, trackingNumber, "Tracking Number");
		
		// Verify order exists
		Assert.assertTrue(VOrders.ordersGrid_txt(driver).getText().contains("VendorOrderCapacity"), "Order was not found");
		
		// Log test
		test.log(LogStatus.INFO, "Vendor Order Capacity", "Verified vendor who has marked Only accept from Fee Panel is in the list for Fee Panel clients");
		
	} // end acceptOnlyFromFeePanel
	
} // end the OrderManagement class
