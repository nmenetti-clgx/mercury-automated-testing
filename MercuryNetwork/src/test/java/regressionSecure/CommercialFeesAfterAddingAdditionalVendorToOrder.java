package regressionSecure;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Secure.SConfirmOrder;
import pageObjects.Secure.SOrderDetails;
import pageObjects.Secure.SReviewBids;
import pageObjects.Secure.SVendorSelection;
import pageObjects.Secure.SVendorSelectionSettings;
import pageObjects.Vendors.VOrderAcknowledgement;
import pageObjects.Vendors.VOrderDetails;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Secure - Commercial Fees After Adding Additional Vendor To Order</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class CommercialFeesAfterAddingAdditionalVendorToOrder extends TestSetup {
	
	/** The user secure. */
	private final String userSecure = "Fee1";
	
	/** The user vendors. */
	private final String userVendors = "FeeAppraiser1";
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set preferences and enable all status mapping</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Place order through the API and assign it to FeeAppraiser1</li>
	 * 	<li>Log the tracking number</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Go to vendor selection settings</li>
	 * 	<li>Turn on Allow order bidding</li>
	 * 	<li>Verify fee and date are locked</li>
	 * 	<li>Save settings</li>
	 * 	<li>Go to Orders</li>
	 * 	<li>Find order</li>
	 * 	<li>Open order</li>
	 * 	<li>Click Issue as bid checkbox</li>
	 * 	<li>Verify checkbox is checked</li>
	 * 	<li>Click Assign</li>
	 * 	<li>Select vendor</li>
	 * 	<li>Select vendor</li>
	 * 	<li>Click Next</li>
	 * 	<li>Verify Confirm Order url</li>
	 * 	<li>Click Next</li>
	 * 	<li>Log in as one of the vendors</li>
	 * 	<li>View the order</li>
	 * 	<li>Submit bid</li>
	 * 	<li>Log back in to Secure</li>
	 * 	<li>Find order</li>
	 * 	<li>Open the bid order</li>
	 * 	<li>Click Review Bids</li>
	 * 	<li>Click Add vendor</li>
	 * 	<li>Add a third vendor to the order</li>
	 * 	<li>Select vendor</li>
	 * 	<li>Click Next</li>
	 * 	<li>Click Finish</li>
	 * 	<li>Click Close</li>
	 * 	<li>Log into vendors as the third vendor (the one you just added)</li>
	 * 	<li>Open the order</li>
	 * 	<li>Submit bid</li>
	 * 	<li>Check the TransactionFeeResponsibilityID in the database and verify the amount is correct</li>
	 * 	<li>Get the ProductItemID</li>
	 * 	<li>Log in as one of the vendors</li>
	 * 	<li>View the order</li>
	 * 	<li>Submit bid</li>
	 * 	<li>Award the bid to a vendor</li>
	 * 	<li>Log back in to Secure</li>
	 * 	<li>Find order</li>
	 * 	<li>Open the bid order</li>
	 * 	<li>Click Review Bids</li>
	 * 	<li>Select an Appraiser</li>
	 * 	<li>Click Award Bid</li>
	 * 	<li>Verify fee amount</li>
	 * 	<li>Click Award</li>
	 * 	<li>Click Close</li>
	 * 	<li>Verify history</li>
	 * 	<li>Log in as one of the vendors</li>
	 * 	<li>Open the order</li>
	 * 	<li>Click the Accept button</li>
	 * 	<li>Allow popup time to load</li>
	 * 	<li>Switch in to iFrame</li>
	 * 	<li>Click Yes radio button</li>
	 * 	<li>CLick OK</li>
	 * 	<li>Verify the Lender is responsible for the fee and the fee is the correct amount</li>
	 * 	<li>Get results from Array</li>
	 * 	<li>USER 1</li>
	 * 	<li>USER 2</li>
	 * 	<li>Verify the Appraiser is not responsible for the transaction fee</li>
	 * 	<li>Verify the Lender is responsible for the transaction fee</li>
	 * 	<li>Log test</li>
	 * 	<li>Click Submit Bid</li>
	 * 	<li>Enter bid of 100</li>
	 * 	<li>Enter Turn time of 1</li>
	 * 	<li>Click Continue</li>
	 * 	<li>Check I have no interest checkbox</li>
	 * 	<li>Check I have performed checkbox</li>
	 * 	<li>Check I have no bias checkbox</li>
	 * 	<li>Check My engagement checkbox</li>
	 * 	<li>Click Submit button</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@SuppressWarnings("unused")
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Create Order Via API", "Secure - Vendor Selection Settings", "Secure - Orders", "Secure - Issue As Bid", "Vendors - Orders", "Vendors - Submit Bid"}, alwaysRun=true)
	public void commercialFeesAfterAddingAdditionalVendorToOrder() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		String password = StoredVariables.getpassword().get();
		
		// Set preferences and enable all status mapping
		// Login to Secure
		secure.login(driver, userSecure, password);
		
		// Place order through the API and assign it to FeeAppraiser1
		perform.apiPlaceOrderFromSecure(driver, userSecure, password, "PlaceMNOrder-Commercial-CommercialFeesAfterAddingAdditionalVendorToOrder");
		String trackingNumber = StoredVariables.gettrackingNumber().get();
		
		// Log the tracking number
		test.log(LogStatus.INFO, "Tracking Number", "Tracking #: " + trackingNumber);
		
		// Log in to Secure
		secure.login(driver, userSecure, password);
		
		// Go to vendor selection settings
		secure.goToVendorSelectionSettings(driver);
		
		// Turn on Allow order bidding
		secure.switchOn(driver, SVendorSelectionSettings.allowOrderBidding_switch(driver));
		
		// Verify fee and date are locked
		if (SVendorSelectionSettings.feeLock_btn(driver).getAttribute("src").contains("Unlocked")) {
			perform.click(driver,SVendorSelectionSettings.feeLock_btn(driver));
		} // end if
		
		if (SVendorSelectionSettings.dateLock_btn(driver).getAttribute("src").contains("Unlocked")) {
			perform.click(driver,SVendorSelectionSettings.dateLock_btn(driver));
		} // end if
		
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
		
		// Select vendor
		perform.clickInTable_Contains(driver, "Automation FeeAppraiser1");

		// Wait for the vendor to be added to the Selected vendors table
		perform.waitForText(driver, SVendorSelection.selectedVendorsTable_txt(driver), "FeeAppraiser1");
		
		Thread.sleep(3000);
		
		// Select vendor
		perform.clickInTable_Contains(driver, "Automation FeeAppraiser2");
		
		// Wait for the vendor to be added to the Selected vendors table
		perform.waitForText(driver, SVendorSelection.selectedVendorsTable_txt(driver), "FeeAppraiser2");
		
		Thread.sleep(3000);
		
		// Click Next
		perform.click(driver,SVendorSelection.nextTop_btn(driver));
		
		// Wait for Next button
		perform.waitForElementToBeClickable(driver, SConfirmOrder.nextTop_btn(), "id");
		
		// Verify Confirm Order url
		Assert.assertTrue(driver.getCurrentUrl().contains("ConfirmOrder"), "The Confirm Order screen did not load properly");

		// Click Next
		perform.click(driver,SConfirmOrder.nextBottom_btn(driver));
		
		// Wait for history
		perform.waitForElementToBeClickable(driver, SOrderDetails.history_txt(), "id");
		
		// Log in as one of the vendors
		vendors.login(driver, userVendors, password);
		
		// View the order
		vendors.findAndOpenOrder(driver, trackingNumber);
		
		// Submit bid
		submitBid(driver, "100","1");
		
		// Log back in to Secure
		secure.login(driver, userSecure, password);
		
		// Find order
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Open the bid order
		secure.openOrder(driver, trackingNumber);
		
		// Click Review Bids
		perform.click(driver,SOrderDetails.reviewBids_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Switch into iFrame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "Bidding/Review.aspx", By.id(SReviewBids.closeReviewBids_btn()));
		
		// Wait for Close button
		perform.waitForElementToBeClickable(driver, SReviewBids.closeReviewBids_btn(), "id");
		
		// Click Add vendor
		perform.click(driver,SReviewBids.addVendor_btn(driver));
		
		// Switch out of iFrame
		driver.switchTo().defaultContent();
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Add a third vendor to the order
		// Select vendor
		perform.clickInTable_Contains(driver, "Automation FeeAppraiser3");

		// Wait for the vendor to be added to the Selected vendors table
		perform.waitForText(driver, SVendorSelection.selectedVendorsTable_txt(driver), "FeeAppraiser3");
		
		Thread.sleep(3000);
		
		// Click Next
		perform.click(driver,SVendorSelection.nextTop_btn(driver));
		
		// Wait for Finish button
		perform.waitForElementToBeClickable(driver, SConfirmOrder.finishTop_btn(), "id");
		
		// Click Finish
		perform.click(driver,SConfirmOrder.finishTop_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		Thread.sleep(8000);
		
		// Switch into iFrame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "Bidding/Review.aspx", By.id(SReviewBids.closeReviewBids_btn()));
		
		// Wait for Close button
		perform.waitForElementToBeClickable(driver, SReviewBids.closeReviewBids_btn(), "id");
		
		// Click Close
		perform.click(driver,SReviewBids.closeReviewBids_btn(driver));
		
		// Switch out of iFrame
		driver.switchTo().defaultContent();
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Log into vendors as the third vendor (the one you just added)
		vendors.login(driver, "FeeAppraiser3", password);
		
		// Open the order
		vendors.findAndOpenOrder(driver, trackingNumber);
		
		// Submit bid
		submitBid(driver, "300","3");
		
		// Check the TransactionFeeResponsibilityID in the database and verify the amount is correct
		// Get the ProductItemID
		String productItemID = db.getProductItemID(driver, StoredVariables.getloanID().get());
		String sqlStatement = "SELECT NewValue FROM dbo.vDataLogEvents "
				+ "WHERE [Table] = 'MercuryOrderInformation' AND Field = 'MercuryTransactionFeeResponsibilityID' "
				+ "AND PrimaryKey1 = '"+productItemID+"' Order By EnteredStamp DESC";
		String value = db.queryDB(driver, "Mercury", sqlStatement);
		Assert.assertTrue(value.contains("6"), "The NewValue in the database should be 6, but is " + value);
		
		// Log in as one of the vendors
		vendors.login(driver, "FeeAppraiser2", password);
		
		// View the order
		vendors.findAndOpenOrder(driver, trackingNumber);
		
		// Submit bid
		submitBid(driver, "200","2");
		
		// Award the bid to a vendor
		// Log back in to Secure
		secure.login(driver, userSecure, password);
		
		// Find order
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Open the bid order
		secure.openOrder(driver, trackingNumber);
		
		// Click Review Bids
		perform.click(driver,SOrderDetails.reviewBids_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Switch into iFrame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "Bidding/Review.aspx", By.id(SReviewBids.closeReviewBids_btn()));
		
		// Wait for Close button
		perform.waitForElementToBeClickable(driver, SReviewBids.closeReviewBids_btn(), "id");
		
		// Select an Appraiser
		perform.clickInTable_Contains(driver, "Automation FeeAppraiser2");
		
		// Click Award Bid
		perform.click(driver,SReviewBids.awardBid_btn(driver));
		
		// Switch out of iFrame
		driver.switchTo().defaultContent();
		
		// Switch into iFrame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "Bidding/Award.aspx", By.id(SReviewBids.award_btn()));
		
		// Wait for Award button
		perform.waitForElementToBeClickable(driver, SReviewBids.award_btn(), "id");
		
		// Verify fee amount
		String fee = SOrderDetails.orderFeeAwardBidGrid_txt(driver).getText();
		System.out.println("Fee: " + fee);
		Assert.assertTrue(fee.contains("$200"), "The Order fee should be $200, but is " + fee);
		
		// Click Award
		perform.click(driver,SReviewBids.award_btn(driver));
		
		// Switch out of iFrame
		driver.switchTo().defaultContent();
		
		// Wait for the Close button
		perform.waitForElementToBeClickable(driver, SOrderDetails.close_btn(), "id");
		
		// Click Close
		perform.click(driver,SOrderDetails.close_btn(driver));
		
		// Wait for history
		perform.waitForElementToBeClickable(driver, SOrderDetails.history_txt(), "id");
		
		// Wait for history text to update
		perform.waitForText(driver, SOrderDetails.history_txt(driver), "Bid Awarded to Appraiser");
		
		// Verify history
		String history = SOrderDetails.history_txt(driver).getText();
		System.out.println("history = " + history);
		Assert.assertTrue(history.contains("Bid Awarded by Client (Automation Fee1) to Appraiser (Automation FeeAppraiser2)"), "The history is incorrect. History = " + history);
		Assert.assertTrue(history.contains("Amount: $200.00"), "The history is incorrect. History = " + history);
		
		// Log in as one of the vendors
		vendors.login(driver, "FeeAppraiser2", password);
		
		// Open the order
		vendors.findAndOpenOrder(driver, trackingNumber);
		
		// Click the Accept button
		perform.click(driver,VOrderDetails.acceptDecline_btn(driver));
		
		// Allow popup time to load
		Thread.sleep(1500);
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Switch in to iFrame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "Bidding/AcknowledgeBid.aspx?", By.id(VOrderAcknowledgement.yes_radiobtn()));
		
		// Click Yes radio button
		perform.click(driver,VOrderAcknowledgement.yes_radiobtn(driver));
		
		// CLick OK
		perform.click(driver,VOrderAcknowledgement.ok2_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);

		// Verify the Lender is responsible for the fee and the fee is the correct amount
		ArrayList<String> results = db.getBillingQueueToArray(driver, StoredVariables.getloanID().get());
		System.out.println("billingQueue = " + results);
		
		// Get results from Array
		// USER 1
		String mercuryBillingAccountID1 = results.get(0);
		String loanID1 = results.get(1);
		String billingCustNumber1 = results.get(2);
		String entityID1 = results.get(3);
		String firstName1 = results.get(4);
		String lastName1 = results.get(5);
		String entityCustNumber1 = results.get(6);
		String amount1 = results.get(7);
		String description1 = results.get(8);
		String enteredStamp1 = results.get(9);
		
		// USER 2
		String mercuryBillingAccountID2 = results.get(10);
		String loanID2 = results.get(11);
		String billingCustNumber2 = results.get(12);
		String entityID2 = results.get(13);
		String firstName2 = results.get(14);
		String lastName2 = results.get(15);
		String entityCustNumber2 = results.get(16);
		String amount2 = results.get(17);
		String description2 = results.get(18);
		String enteredStamp2 = results.get(19);
		
		// Verify the Appraiser is not responsible for the transaction fee
		if (lastName1.contains("Appraiser"))
		{
			Assert.assertTrue(amount1.equals("0.0000"), "The appraiser should have a 0.00 amount but is " + amount1);
			Assert.assertTrue(description1.equals("Client is paying transaction fee"), "The Description should be 'Client is paying transaction fee' but is " + description1);
		} // end if
		else if (lastName2.contains("Appraiser"))
		{
			Assert.assertTrue(amount2.equals("0.0000"), "The appraiser should have a 0.00 amount but is " + amount2);
			Assert.assertTrue(description2.equals("Client is paying transaction fee"), "The Description should be 'Client is paying transaction fee' but is " + description2);
		} // end if/else
		else
		{
			test.log(LogStatus.FAIL, "The Appraiser was not found in the databse");
		}
		
		// Verify the Lender is responsible for the transaction fee
		if (!lastName1.contains("Appraiser"))
		{
			Assert.assertTrue(!amount1.equals("0.0000"), "The lender should not have a 0.00 amount but is " + amount1);
			Assert.assertTrue(description1.equals("Default - Show Price"), "The Description should be 'Default - Show Price' but is " + description1);
		} // end if
		else if (!lastName2.contains("Appraiser"))
		{
			Assert.assertTrue(!amount2.equals("0.0000"), "The lender should not have a 0.00 amount but is " + amount2);
			Assert.assertTrue(description2.equals("Default - Show Price"), "The Description should be 'Default - Show Price' but is " + description2);
		} // end if/else
		else
		{
			test.log(LogStatus.FAIL, "The Appraiser was not found in the databse");
		}	
		
		// Log test
		test.log(LogStatus.INFO, "Secure Regression Test", "Verified that commercial fee stays the same after adding an additional vendor");
		
	} // end invoiceNumbersDoNotResetWhenChangingClientGroupSettings
	
	/**
	 * Submit bid.
	 *
	 * @param driver the driver
	 * @param bidAmount the bid amount
	 * @param turnTime the turn time
	 * @throws InterruptedException the interrupted exception
	 */
	private void submitBid(RemoteWebDriver driver, String bidAmount, String turnTime) throws InterruptedException {
		
		// Click Submit Bid
		perform.click(driver,VOrderDetails.submitBid_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Switch into iFrame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "Bidding/SubmitBid.aspx", By.id(VOrderDetails.appraisalBid_txtbx()));
		
		// Wait for text area
		perform.waitForElementToBeClickable(driver, VOrderDetails.appraisalBid_txtbx(), "id");
		
		// Enter bid of 100
		VOrderDetails.appraisalBid_txtbx(driver).clear();
		perform.type(driver,VOrderDetails.appraisalBid_txtbx(driver), bidAmount);
		
		// Enter Turn time of 1
		VOrderDetails.turnTime_txtbx(driver).clear();
		perform.type(driver,VOrderDetails.turnTime_txtbx(driver), turnTime);
		
		// Click Continue
		perform.click(driver,VOrderDetails.continue_btn(driver));
		
		// Wait for Submit button
		perform.waitForElementToBeClickable(driver, VOrderDetails.submit_btn(), "id");
		
		// Check I have no interest checkbox
		perform.checkCheckbox(driver, VOrderDetails.iHaveNoInterest_chkbx(driver));
		
		// Check I have performed checkbox
		perform.checkCheckbox(driver, VOrderDetails.iHavePerformed_chkbx(driver));
		
		// Check I have no bias checkbox
		perform.checkCheckbox(driver, VOrderDetails.iHaveNoBias_chkbx(driver));
		
		// Check My engagement checkbox
		perform.checkCheckbox(driver, VOrderDetails.myEngagement_chkbx(driver));
		
		// Click Submit button
		perform.click(driver,VOrderDetails.submit_btn(driver));
		
		// Get out of iFrame
		driver.switchTo().defaultContent();
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
	} // end submitBid
	
} // end the commercialFeesAfterAddingAdditionalVendorToOrder class
