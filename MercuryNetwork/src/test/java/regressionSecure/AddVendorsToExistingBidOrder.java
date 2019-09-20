package regressionSecure;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjects.Secure.SConfirmOrder;
import pageObjects.Secure.SOrderDetails;
import pageObjects.Secure.SReviewBids;
import pageObjects.Secure.SVendorSelection;
import pageObjects.Secure.SVendorSelectionSettings;
import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Secure - Add Vendors To Existing Bid Order</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class AddVendorsToExistingBidOrder extends TestSetup {
	
	/** The user VMP. */
	private final String userVMP = "OriginatorRegression1";
	
	/** The user secure. */
	private final String userSecure = "Regression1";
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Place commercial order thru VMP client from the API</li>
	 * 	<li>Get order numbers</li>
	 * 	<li>In Secure, issue as bid to a few vendors</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Go to vendor selection settings</li>
	 * 	<li>Turn on Allow order bidding</li>
	 * 	<li>Save settings</li>
	 * 	<li>Go to Orders</li>
	 * 	<li>Find order</li>
	 * 	<li>Open order</li>
	 * 	<li>Click Issue as bid checkbox</li>
	 * 	<li>Verify checkbox is checked</li>
	 * 	<li>Click Assign</li>
	 * 	<li>Select RegressionVendors1</li>
	 * 	<li>Verify vendor was selected</li>
	 * 	<li>Select RegressionVendors2</li>
	 * 	<li>Verify vendor was selected</li>
	 * 	<li>Click Next</li>
	 * 	<li>Click Finish</li>
	 * 	<li>Click on Review bids</li>
	 * 	<li>Click Add vendor</li>
	 * 	<li>Select RegressionVendors3</li>
	 * 	<li>Verify vendor was selected</li>
	 * 	<li>Select Appraiser3</li>
	 * 	<li>Verify vendor was selected</li>
	 * 	<li>Click Next</li>
	 * 	<li>Click Finish</li>
	 * 	<li>Confirm new vendors on Order confirmation screen and finish order</li>
	 * 	<li>All vendors from the initial and 2nd selection phase should appear in the Review bids dialog</li>
	 * 	<li>Log test</li>
* </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"VMP - Create Order Via API", "Secure - Vendor Selection Settings", "Secure - Orders", "Secure - Issue As Bid"}, alwaysRun=true)
	public void addVendorToExistingBidOrder() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		String password = StoredVariables.getpassword().get();
		
		// Place commercial order thru VMP client from the API
		perform.apiPlaceOrderFromVMPClientPortal(driver, userVMP, password, userSecure, "PlaceAppraisalOrderExLenderNoGroups-Commercial-addVendorToExistingBidOrder");
		
		// Get order numbers
		String trackingNumber = StoredVariables.gettrackingNumber().get();
		
		// In Secure, issue as bid to a few vendors
		// Log in to Secure
		secure.login(driver, userSecure, password);
		
		// Go to vendor selection settings
		secure.goToVendorSelectionSettings(driver);
		
		// Turn on Allow order bidding
		secure.switchOn(driver, SVendorSelectionSettings.allowOrderBidding_switch(driver));
		
		// Save settings
		secure.saveVendorSelectionSettings(driver);
		
		// Go to Orders
		secure.goToOrders(driver);
		
		// Find order
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Open order
		secure.openOrder(driver, trackingNumber);
		
		// Click Issue as bid checkbox
		perform.click(driver,SOrderDetails.issueAsBid_btn(driver));

		// Verify checkbox is checked
		String checked = SOrderDetails.issueAsBid_btn(driver).getAttribute("class");
		System.out.println("class = " + checked);
		while (!checked.contains("imagecheckbox-container-checked"))
		{
			Thread.sleep(1000);
			checked = SOrderDetails.issueAsBid_btn(driver).getAttribute("class");
		} // end while
		
		// Click Assign
		perform.click(driver,SOrderDetails.assign_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Close Related Orders popup
		secure.checkForRelatedOrdersDialog(driver);
		
		// Select RegressionVendors1
		perform.clickInTable_Contains(driver, "RegressionVendors1");
		
		// Wait for text
		perform.waitForText(driver, SVendorSelection.selectedVendorsTable_txt(driver), "RegressionVendors1");
		
		// Verify vendor was selected
		String selectedVendors = SVendorSelection.selectedVendorsTable_txt(driver).getText();
		Assert.assertTrue(selectedVendors.contains("RegressionVendors1"), "The vendor was not selected");
		
		// Select RegressionVendors2
		perform.clickInTable_Contains(driver, "RegressionVendors2");
		
		// Wait for text
		perform.waitForText(driver, SVendorSelection.selectedVendorsTable_txt(driver), "RegressionVendors2");
		
		// Verify vendor was selected
		selectedVendors = SVendorSelection.selectedVendorsTable_txt(driver).getText();
		Assert.assertTrue(selectedVendors.contains("RegressionVendors2"), "The vendor was not selected");
		
		// Click Next
		perform.click(driver,SVendorSelection.nextTop_btn(driver));
		
		// Wait for Finish button
		perform.waitForElementToBeClickable(driver, SConfirmOrder.finishBottom_btn(), "id");
		
		// Click Finish
		perform.click(driver,SConfirmOrder.finishBottom_btn(driver));
		
		// Wait for history
		perform.waitForElementToBeClickable(driver, SOrderDetails.history_txt(), "id");
		
		// Click on Review bids
		perform.click(driver,SOrderDetails.reviewBids_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		Thread.sleep(3000);
		
		// Switch into iFrame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "Bidding/Review.aspx", By.cssSelector(SReviewBids.addVendor_btn()));
		
		// Wait for Add Vendor button
		perform.waitForElementToBeClickable(driver, SReviewBids.addVendor_btn(), "cssSelector");
		
		// Click Add vendor
		perform.click(driver,SReviewBids.addVendor_btn(driver));
		
		// Switch out of iFrame
		driver.switchTo().defaultContent();
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Select RegressionVendors3
		perform.clickInTable_Contains(driver, "RegressionVendors3");
		
		// Wait for text
		perform.waitForText(driver, SVendorSelection.selectedVendorsTable_txt(driver), "RegressionVendors3");
		
		// Verify vendor was selected
		selectedVendors = SVendorSelection.selectedVendorsTable_txt(driver).getText();
		Assert.assertTrue(selectedVendors.contains("RegressionVendors3"), "The vendor was not selected");
		
		Thread.sleep(3000);
		
		// Select Appraiser3
		perform.clickInTable_Contains(driver, "Appraiser3");
		
		// Wait for text
		perform.waitForText(driver, SVendorSelection.selectedVendorsTable_txt(driver), "Appraiser3");
		
		// Verify vendor was selected
		selectedVendors = SVendorSelection.selectedVendorsTable_txt(driver).getText();
		Assert.assertTrue(selectedVendors.contains("Appraiser3"), "The vendor was not selected");
		
		// Click Next
		perform.click(driver,SVendorSelection.nextTop_btn(driver));
		
		// Wait for Finish button
		perform.waitForElementToBeClickable(driver, SConfirmOrder.finishBottom_btn(), "id");
		
		// Click Finish
		perform.click(driver,SConfirmOrder.finishBottom_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		Thread.sleep(3000);
		
		// Switch into iFrame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "Bidding/Review.aspx", By.cssSelector(SReviewBids.addVendor_btn()));
		
		// Wait for Review bids vendors table text
		perform.waitForElementToBeClickable(driver, SOrderDetails.reviewBidsVendorsTable_txt(), "id");
		
		// Confirm new vendors on Order confirmation screen and finish order
		// All vendors from the initial and 2nd selection phase should appear in the Review bids dialog
		String vendorsList = SOrderDetails.reviewBidsVendorsTable_txt(driver).getText();
		Assert.assertTrue(vendorsList.contains("RegressionVendors1"), "RegressionVendors1 is missing vendors in the table");
		Assert.assertTrue(vendorsList.contains("RegressionVendors2"), "RegressionVendors2 is missing vendors in the table");
		Assert.assertTrue(vendorsList.contains("RegressionVendors3"), "RegressionVendors3 is missing vendors in the table");
		Assert.assertTrue(vendorsList.contains("Appraiser3"), "Appraiser3 is missing vendors in the table");
		
		// Get out of iFrame
		driver.switchTo().defaultContent();
		
		// Log test
		test.log(LogStatus.INFO, "Secure Regression Test", "Verified you can Add Vendors to Existing Bid Order");
		
	} // end addVendorToExistingBidOrder
	
} // end the AddVendorsToExistingBidOrder class
