package regressionEligibleVendors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjects.Secure.SOrderDetails;
import pageObjects.Secure.SVendorSelection;
import pageObjects.Secure.SVendorSelectionSettings;
import pageObjects.Vendors.VOrders;
import pageObjects.Vendors.VUsers;
import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Eligible Vendors - Show Fee Panel Vendors Only</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class ShowFeePanelVendorsOnly extends TestSetup {
	
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
	 * 	<li>Place order through API</li>
	 * 	<li>Log into Secure as a lender who does not have the vendor in their fee panel</li>
	 * 	<li>Search for order</li>
	 * 	<li>Open order</li>
	 * 	<li>Click Assign</li>
	 * 	<li>Search for vendor by last name</li>
	 * 	<li>Verify no results were found</li>
	 * 	<li>Get results</li>
	 * 	<li>Verify the user is not in the results</li>
	 * 	<li>Click on ISS</li>
	 * 	<li>Verify the vendor does not show in ISS results</li>
	 * 	<li>Place order through API</li>
	 * 	<li>Log into Secure as the lender with the vendor on their fee panel</li>
	 * 	<li>Search for order</li>
	 * 	<li>Open order</li>
	 * 	<li>Assign the order</li>
	 * 	<li>Confirm Order Details</li>
	 * 	<li>Login to Vendors</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify order exists</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Vendors - Users", "Secure - Create Order Via API", "Secure - Orders", "Vendors - Orders", "Eligible Vendors"}, alwaysRun=true)
	public void acceptOnlyFromFeePanel() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Login to vendors
		vendors.login(driver, "VendorOrderCapacityAppraiser1", StoredVariables.getpassword().get());
		
		// Click Users 
		perform.click(driver,VOrders.users_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Wait for Only accept orders from my fee panel clients checkbox
		perform.waitForElementToBeClickable(driver, VUsers.acceptOrderFromMercuryNetworkClients_chkbx(), "id");
		
		// Enable Accept orders from Mercury Network clients
		if (VUsers.acceptOrderFromMercuryNetworkClients_chkbx(driver).isSelected()==false)
		{
			perform.click(driver,VUsers.acceptOrderFromMercuryNetworkClients_chkbx(driver));	
		}
		
		// Enable Only accept orders from my fee panel clients and save
		if (VUsers.onlyAcceptOrdersFromMyFeePanelClients_checkbox(driver).isSelected()==false)
		{
			perform.click(driver,VUsers.onlyAcceptOrdersFromMyFeePanelClients_checkbox(driver));	
		}
		
		// Click Save
		perform.click(driver,VUsers.save_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SVendorSelectionSettings.ok_btn(), "id");
		
		// Click OK
		perform.click(driver,VUsers.okSave_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Place order through API
		perform.apiPlaceOrderFromSecure(driver, "VendorOrderCapacity2", "T3sting1", "PlaceMNOrder-ShowFeePanelVendorsOnly");
		
		// Log into Secure as a lender who does not have the vendor in their fee panel
		secure.login(driver, "VendorOrderCapacity2", StoredVariables.getpassword().get());
		
		String trackingNumber = StoredVariables.gettrackingNumber().get();
		
		// Search for order
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Open order
		secure.openOrder(driver, trackingNumber);
		
		// Click Assign
		perform.click(driver,SOrderDetails.assign_btn(driver));
		
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
		
		// Place order through API
		perform.apiPlaceOrderFromSecure(driver, "VendorOrderCapacity1", "T3sting1", "PlaceMNOrder-ShowFeePanelVendorsOnly");
		
		// Log into Secure as the lender with the vendor on their fee panel 
		secure.login(driver, "VendorOrderCapacity1", StoredVariables.getpassword().get());
		
		trackingNumber = StoredVariables.gettrackingNumber().get();
		
		// Search for order
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Open order
		secure.openOrder(driver, trackingNumber);
		
		// Assign the order
		secure.assignVendor(driver, "VendorOrderCapacityAppraiser1");
		
		// Confirm Order Details
		secure.confirmOrderDetails(driver, "");
		
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
