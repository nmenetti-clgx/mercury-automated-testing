package regressionResidentialBidding;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.InternalTools.ITNotificationSearch;
import pageObjects.Secure.SConfirmOrder;
import pageObjects.Secure.SOrderDetails;
import pageObjects.Secure.SReviewBids;
import pageObjects.Secure.SVendorSelection;
import pageObjects.Secure.SVendorSelectionSettings;
import pageObjects.Vendors.VOrderDetails;
import pageObjects.Vendors.VOrders;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Residential Bidding - Multiple Vendors From The Same Company</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class MultipleVendorsFromTheSameCompany extends TestSetup {

	/** The password. */
	private final String password = "T3sting1";
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Go to Vendor Selection Settings</li>
	 * 	<li>Set changed boolean</li>
	 * 	<li>Turn off Automatic vendor selection</li>
	 * 	<li>Turn off Unattended Order Assignment</li>
	 * 	<li>Click OK</li>
	 * 	<li>Turn off Unattended Order Reassignment</li>
	 * 	<li>Confirm there is an option in the Residential appraisal selection section for Allow order bidding</li>
	 * 	<li>Enable Allow order bidding</li>
	 * 	<li>Confirm it has two sub options to lock or unlock the Fee and Date</li>
	 * 	<li>Lock Fee and Date Locks</li>
	 * 	<li>Confirm the locks default to locked</li>
	 * 	<li>Confirm under Ordering options section &gt; default order expiration time, there is a sub option for Default bid due</li>
	 * 	<li>Confirm the default bid due time is 12 hours</li>
	 * 	<li>Save settings</li>
	 * 	<li>Place a VMP order through the API</li>
	 * 	<li>Get order numbers</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Find and Open the order</li>
	 * 	<li>Mark as a bid order</li>
	 * 	<li>Assign vendors to bid order</li>
	 * 	<li>Click Next</li>
	 * 	<li>Confirm there is a Bidding information pod on the confirmation step</li>
	 * 	<li>Confirm the selected vendors display in the Bidding information pod</li>
	 * 	<li>Click Finish</li>
	 * 	<li>Confirm the order is placed</li>
	 * 	<li>Confirm there is an Issue as bid field in Assignment information</li>
	 * 	<li>Confirm the locks for Fee and Date show as locked as the order was placed with them locked</li>
	 * 	<li>Login to Vendors as vendor1</li>
	 * 	<li>Find the order</li>
	 * 	<li>Get the text from the Orders Grid</li>
	 * 	<li>Verify each vendor has an order</li>
	 * 	<li>Open the order for vendor1</li>
	 * 	<li>Verify the Bid Vendor Information contains the correct vendor info</li>
	 * 	<li>Go to Orders</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order for vendor2</li>
	 * 	<li>Verify the Bid Vendor Information contains the correct vendor info</li>
	 * 	<li>Go to Orders</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order for vendor3</li>
	 * 	<li>Verify the Bid Vendor Information contains the correct vendor info</li>
	 * 	<li>Confirm the status shows Bid Pending</li>
	 * 	<li>Confirm the Order Fee value is displayed in red text</li>
	 * 	<li>Confirm the Due Date value is displayed in purple text</li>
	 * 	<li>Confirm there is a Submit Bid button instead of Accept/Decline Assignment</li>
	 * 	<li>Submit the bid</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the audit trail events display (vendor who set status/bid) on behalf of (actual assigned vendor)</li>
	 * 	<li>Go to Orders</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order for vendor1</li>
	 * 	<li>Verify the Bid Vendor Information contains the correct vendor info</li>
	 * 	<li>Verify the audit trail events are only for vendor1</li>
	 * 	<li>login as vendor2</li>
	 * 	<li>Find the order</li>
	 * 	<li>Verify there is only 1 record in the order grid</li>
	 * 	<li>Open the order</li>
	 * 	<li>Verify the Bid Vendor Information contains the correct vendor info</li>
	 * 	<li>Verify the audit trail are only for vendor2</li>
	 * 	<li>Submit a bid and send a message</li>
	 * 	<li>Get the audit trail text</li>
	 * 	<li>Verify the bid info shows in the audit trail</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Find and Open the order</li>
	 * 	<li>Review bids</li>
	 * 	<li>Send vendor a message</li>
	 * 	<li>Award bid</li>
	 * 	<li>Click Close</li>
	 * 	<li>Verify the audit trail</li>
	 * 	<li>Login to vendors as vendor2 (winning vendor)</li>
	 * 	<li>Open the order</li>
	 * 	<li>Verify the Bid Vendor Information contains the correct vendor info</li>
	 * 	<li>Verify the audit trail</li>
	 * 	<li>Login to vendors as admin appraiser</li>
	 * 	<li>Find order</li>
	 * 	<li>Verify there is only 1 record in the order grid</li>
	 * 	<li>Open the order</li>
	 * 	<li>Verify the Bid Vendor Information contains the correct vendor info</li>
	 * 	<li>Verify the audit trail only contains vendor2 information</li>
	 * 	<li>Log test</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Go to Vendor Selection Settings</li>
	 * 	<li>Set changed boolean</li>
	 * 	<li>Turn on Automatic vendor selection</li>
	 * 	<li>Turn off Unattended Order Assignment</li>
	 * 	<li>Click OK</li>
	 * 	<li>Turn off Unattended Order Reassignment</li>
	 * 	<li>Confirm there is an option in the Residential appraisal selection section for Allow order bidding</li>
	 * 	<li>Enable Allow order bidding</li>
	 * 	<li>Confirm it has two sub options to lock or unlock the Fee and Date</li>
	 * 	<li>Lock Fee and Date Locks</li>
	 * 	<li>Confirm the locks default to locked</li>
	 * 	<li>Confirm under Ordering options section &gt; default order expiration time, there is a sub option for Default bid due</li>
	 * 	<li>Confirm the default bid due time is 12 hours</li>
	 * 	<li>Save settings</li>
	 * 	<li>Place a VMP order through the API</li>
	 * 	<li>Get order numbers</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Find and open the order</li>
	 * 	<li>Mark as a bid order</li>
	 * 	<li>Click assign</li>
	 * 	<li>Verify there are multiple vendors from the same company in the auto selection</li>
	 * 	<li>Click Finish</li>
	 * 	<li>Review the bids</li>
	 * 	<li>Verify vendors in the table</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Vendor Selection Settings", "Residential Bidding", "VMP - Create Order Via API", "Secure - Orders", "Secure - Issue As Bid", "Vendors - Order", "Vendors - Submit Bid",
			"Secure - Review Bids", "Secure - Award Bid"}, alwaysRun=true)
	public void sameCompanyBidOrder() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		String userSecure = "ResBidding3";
		String userVendors = "SameCoAppraiser1";
		String userVMP = "OriginatorResBidding3";
		
		// Log in to Secure
		secure.login(driver, userSecure, password);

		// Go to Vendor Selection Settings
		secure.goToVendorSelectionSettings(driver);
		
		// Set changed boolean
		boolean changed = false;
		
		// Turn off Automatic vendor selection
		if (SVendorSelectionSettings.automaticVendorSelection_switch(driver).getAttribute("src").contains("switchOn.png")) {
			perform.click(driver, SVendorSelectionSettings.automaticVendorSelection_switch(driver));
			changed = true;
		}

		// Turn off Unattended Order Assignment
		if (SVendorSelectionSettings.unattendedOrderAssignment_switch(driver).getAttribute("src").contains("switchOn.png")) {
			
			perform.click(driver, SVendorSelectionSettings.unattendedOrderAssignment_switch(driver));
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			// Click OK
			perform.click(driver, SVendorSelectionSettings.unattendedOrderAssignmentDialogOk_btn(driver));
			changed = true;
		}

		// Turn off Unattended Order Reassignment
		if (SVendorSelectionSettings.unattendedOrderReassignment_switch(driver).getAttribute("src").contains("switchOn.png")) {
			perform.click(driver, SVendorSelectionSettings.unattendedOrderReassignment_switch(driver));
			changed = true;
		}
		
		// Confirm there is an option in the Residential appraisal selection section for Allow order bidding
		Assert.assertTrue(SVendorSelectionSettings.allowOrderBidding_switch(driver).isDisplayed(), "There should be an option to Allow order bidding");
		
		// Enable Allow order bidding
		if (SVendorSelectionSettings.allowOrderBidding_switch(driver).getAttribute("src").contains("switchOff.png")) {
			perform.click(driver, SVendorSelectionSettings.allowOrderBidding_switch(driver));
			Thread.sleep(1500);
			changed = true;
		}
		
		// Confirm it has two sub options to lock or unlock the Fee and Date
		WebElement feeLock = SVendorSelectionSettings.feeLock_btn(driver);
		WebElement dateLock = SVendorSelectionSettings.dateLock_btn(driver);
		Assert.assertTrue(feeLock.isDisplayed(), "There should be a Fee lock button");
		Assert.assertTrue(dateLock.isDisplayed(), "There should be a Date lock button");
		
		// Lock Fee and Date Locks
		if (feeLock.getAttribute("src").contains("/Images/Unlocked-Blue.png")) {
			perform.click(driver, feeLock);
		}
		if (dateLock.getAttribute("src").contains("/Images/Unlocked-Blue.png")) {
			perform.click(driver, dateLock);
		}
		
		// Confirm the locks default to locked
		Assert.assertTrue(feeLock.getAttribute("src").contains("/Images/Locked-Blue.png"), "The Fee lock should be locked");
		Assert.assertTrue(dateLock.getAttribute("src").contains("/Images/Locked-Blue.png"), "The Date lock should be locked");
		
		// Confirm under Ordering options section > default order expiration time, there is a sub option for Default bid due
		Assert.assertTrue(SVendorSelectionSettings.defaultBidDue_div(driver).getText().contains("Default bid due"), "There should be an option to set the Default bid due");
		
		// Confirm the default bid due time is 12 hours
		Assert.assertTrue(SVendorSelectionSettings.defaultBidDueHours_txtbx(driver).getAttribute("value").equals("12"), "The hours should be set to 12");
		
		// Save settings
		if (changed==true) {
			secure.saveVendorSelectionSettings(driver);	
		} // end if

		// Place a VMP order through the API
		perform.apiPlaceOrderFromVMPClientPortal(driver, userVMP, password, userSecure, "PlaceAppraisalOrderExLenderNoGroups-MultipleVendorsFromTheSameCompany");
		
		// Get order numbers
		String trackingNumber = StoredVariables.gettrackingNumber().get();
		
		// Login to Secure
		secure.login(driver, userSecure, password);
		
		// Find and Open the order
		secure.findAndOpenOrder(driver, trackingNumber);
		
		// Mark as a bid order
		if (!SOrderDetails.issueAsBid_btn(driver).getAttribute("class").contains("imagecheckbox-container-checked")) {
			perform.click(driver, SOrderDetails.issueAsBid_btn(driver));
		} // end if
		
		// Assign vendors to bid order
		String vendor1 = "SameCoSU1";
		String vendor2 = "SameCoSU2";
		String vendor3 = "SameCoSU3";
		String[] vendorsToAssign = {vendor1, vendor2, vendor3};
		secure.assignVendorsToBidOrder(driver, vendorsToAssign);
		
		// Click Next
		perform.click(driver, SVendorSelection.nextBottom_btn(driver));
		
		// Wait for Bidding information
		perform.waitForElementToBeClickable(driver, SConfirmOrder.vendorSection_txt(), "id");
		
		// Confirm there is a Bidding information pod on the confirmation step
		// Confirm the selected vendors display in the Bidding information pod
		String vendorSection = SConfirmOrder.vendorSection_txt(driver).getText();
		String[] expected = {"Bidding information", vendor1, vendor2, vendor3};
		perform.verifyTextContains(driver, vendorSection, expected);
		
		// Click Finish
		perform.click(driver, SConfirmOrder.finishBottom_btn(driver));
		
		// Wait for the history
		perform.waitForElementToBeClickable(driver, SOrderDetails.history_txt(), "id");
		
		// Confirm the order is placed
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("Out for Bid by Client"), "The history does not reflect the order being 'Out for Bid by Client'");
		
		// Confirm there is an Issue as bid field in Assignment information
		Assert.assertTrue(SOrderDetails.assignmentInformation_txt(driver).getText().contains("Issue as bid"), "There should be an Issue as bid field in the Assignment information pod");
		
		// Confirm the locks for Fee and Date show as locked as the order was placed with them locked
		Assert.assertTrue(SOrderDetails.feeLock_img(driver).getAttribute("src").contains("/Images/Locked.png"), "The Fee lock should be locked");
		Assert.assertTrue(SOrderDetails.dateLock_img(driver).getAttribute("src").contains("/Images/Locked.png"), "The Date lock should be locked");

		// Get the Product Item ID
		String productItemID = db.getProductItemID(driver, trackingNumber);
		
		// Go to the Notification Search Internal Tool and search by productItemID
		it.goToNotificationSearchAndSearchByProductItemID(driver, productItemID);
		
		// Verify there are 3 records
		it.waitForTheNumberOfRecordsInNotificationSearch(driver, 3, productItemID);
		
		// Verify each vendor receives a 'New Bidding Opportunity' email
		String nbo = "New Bidding Opportunity";
		perform.verification(driver, ITNotificationSearch.resultByColumnAndRow_txt(driver, it.getRowOfNotificationSearchResults(driver, "to", vendor1), "subject").getText(), 
				"starts with", nbo);
		perform.verification(driver, ITNotificationSearch.resultByColumnAndRow_txt(driver, it.getRowOfNotificationSearchResults(driver, "to", vendor2), "subject").getText(), 
				"starts with", nbo);
		perform.verification(driver, ITNotificationSearch.resultByColumnAndRow_txt(driver, it.getRowOfNotificationSearchResults(driver, "to", vendor3), "subject").getText(), 
				"starts with", nbo);
		
		// Login to Vendors as vendor1
		vendors.login(driver, userVendors, password);
		
		// Find the order
		vendors.findOrder(driver, trackingNumber, "Tracking Number");
		
		// Get the text from the Orders Grid
		String grid = VOrders.ordersGrid_txt(driver).getText();
		
		// Verify each vendor has an order
		expected = new String[]{vendor1, vendor2, vendor3};
		perform.verifyTextContains(driver, grid, expected);
		
		// Open the order for vendor1
		perform.doubleClickInTable(driver, vendor1);
		
		// Wait for the history
		perform.waitForElementToBeClickable(driver, VOrderDetails.history_txt(driver));
		
		// Verify the Bid Vendor Information contains the correct vendor info
		String bidVendorInfo = VOrderDetails.bidVendorInformation_txt(driver).getText();
		Assert.assertTrue(bidVendorInfo.contains(vendor1), vendor1 + " should be in the Bid Vendor Information section and is not");
		
		// Go to Orders
		vendors.goToOrders(driver);
		
		// Find the order
		vendors.findOrder(driver, trackingNumber, "Tracking Number");
		
		// Open the order for vendor2
		perform.doubleClickInTable(driver, vendor2);
		
		// Wait for the history
		perform.waitForElementToBeClickable(driver, VOrderDetails.history_txt(driver));
		
		// Verify the Bid Vendor Information contains the correct vendor info
		bidVendorInfo = VOrderDetails.bidVendorInformation_txt(driver).getText();
		Assert.assertTrue(bidVendorInfo.contains(vendor2), vendor2 + " should be in the Bid Vendor Information section and is not");
		
		// Go to Orders
		vendors.goToOrders(driver);
		
		// Find the order
		vendors.findOrder(driver, trackingNumber, "Tracking Number");
		
		// Open the order for vendor3
		perform.doubleClickInTable(driver, vendor3);
		
		// Wait for the history
		perform.waitForElementToBeClickable(driver, VOrderDetails.history_txt(driver));
		
		// Verify the Bid Vendor Information contains the correct vendor info
		bidVendorInfo = VOrderDetails.bidVendorInformation_txt(driver).getText();
		Assert.assertTrue(bidVendorInfo.contains(vendor3), vendor3 + " should be in the Bid Vendor Information section and is not");
		
		// Confirm the status shows Bid Pending
		String status = VOrderDetails.historyHeader_txt(driver).getText();
		Assert.assertTrue(status.contains("(Bid Pending)"), "The status should be Bid Pending but is = " + status);
		
		// Confirm the Order Fee value is displayed in red text
		String orderFeeColor = perform.getElementColor(driver, VOrderDetails.orderFee_txt(driver));
		Assert.assertTrue(orderFeeColor.equals("#ff0000"), "The color should be #ff0000, but instead is = " + orderFeeColor);
		
		// Confirm the Due Date value is displayed in purple text
		String dueDateColor = perform.getElementColor(driver, VOrderDetails.dueDate_txt(driver));
		Assert.assertTrue(dueDateColor.equals("#800080"), "The color should be #800080, but instead is = " + dueDateColor);
		
		// Confirm there is a Submit Bid button instead of Accept/Decline Assignment
		Assert.assertTrue(VOrderDetails.submitBid_btn(driver).isDisplayed(), "There should be a Submit Bid button instead of an Accept/Decline button");
		
		// Submit the bid
		vendors.submitBidWithFixedFee(driver, true, "I accept the bid");
		
		// Get history text
		String history = VOrderDetails.history_txt(driver).getText();
		
		// Verify the audit trail events display (vendor who set status/bid) on behalf of (actual assigned vendor)
		String onBehalfOf = "Appraiser Automation "+userVendors+" agreed to bid terms on behalf of Automati "+vendor3+"";
		expected = new String[]{onBehalfOf, "I accept the bid"};
		perform.verifyTextContains(driver, history, expected);
		
		// Go to Orders
		vendors.goToOrders(driver);
		
		// Find the order
		vendors.findOrder(driver, trackingNumber, "Tracking Number");
		
		// Open the order for vendor1
		perform.doubleClickInTable(driver, vendor1);
		
		// Wait for the history
		perform.waitForElementToBeClickable(driver, VOrderDetails.history_txt(driver));
		
		// Verify the Bid Vendor Information contains the correct vendor info
		bidVendorInfo = VOrderDetails.bidVendorInformation_txt(driver).getText();
		Assert.assertTrue(bidVendorInfo.contains(vendor1), vendor1 + " should be in the Bid Vendor Information section and is not");
		
		// Verify the audit trail events are only for vendor1
		history = VOrderDetails.history_txt(driver).getText();
		String[] notExpected = {onBehalfOf, "I accept the bid"};
		expected = new String[]{"Bid Pending by Auto SameCoSU1"};
		perform.verifyTextDoesNotContain(driver, history, notExpected);
		perform.verifyTextContains(driver, history, expected);
		
		// login as vendor2
		vendors.login(driver, vendor2, password);
		
		// Find the order
		vendors.findOrder(driver, trackingNumber, "Tracking Number");
		
		// Verify there is only 1 record in the order grid
		List<WebElement> rows = driver.findElements(By.cssSelector("#"+VOrders.ordersGrid_txt()+" tr"));
		int count = rows.size();
		Assert.assertTrue(count==6, "There should only be 1 record in the order grid");
		
		// Open the order
		perform.doubleClickInTable(driver, "Bid Pending");
		
		// Wait for the history
		perform.waitForElementToBeClickable(driver, VOrderDetails.history_txt(driver));
		
		// Verify the Bid Vendor Information contains the correct vendor info
		bidVendorInfo = VOrderDetails.bidVendorInformation_txt(driver).getText();
		Assert.assertTrue(bidVendorInfo.contains(vendor2), vendor2 + " should be in the Bid Vendor Information section and is not");
		
		// Verify the audit trail are only for vendor2
		history = VOrderDetails.history_txt(driver).getText();
		expected = new String[]{"Bid Pending by Automa SameCoSU2"};
		perform.verifyTextDoesNotContain(driver, history, notExpected);
		perform.verifyTextContains(driver, history, expected);

		// Submit a bid and send a message
		vendors.submitBidWithFixedFee(driver, true, "I also accept the bid");

		// Get the audit trail text
		history = VOrderDetails.history_txt(driver).getText();
		
		// Verify the bid info shows in the audit trail
		expected = new String[]{"Appraiser Automa SameCoSU2 agreed to bid terms.", "I also accept the bid"};
		perform.verifyTextContains(driver, history, expected);
		
		// Login as main appraiser
		vendors.login(driver, vendor1, password);
		
		// Find and open the order for vendor1
		vendors.findAndOpenOrder(driver, trackingNumber);
		
		// Decline the bid order as vendor1
		vendors.submitBidWithFixedFee(driver, false, "I decline the bid");
		
		// Go to the Notification Search Internal Tool and search by productItemID
		it.goToNotificationSearchAndSearchByProductItemID(driver, productItemID);
		
		// Verify there are 6 records
		it.waitForTheNumberOfRecordsInNotificationSearch(driver, 6, productItemID);
		
		// Create array lists to hold the To and Subject values
		ArrayList<String> bidDeclined = new ArrayList<String>();
		ArrayList<String> bidSubmitted = new ArrayList<String>();
		ArrayList<String> newBiddingOpportunity = new ArrayList<String>();
		
		// Get a list of the table to get the To and Subject fields
		List<WebElement> searchResults = driver.findElements(By.cssSelector(ITNotificationSearch.rowSearchResults_txt()));
		for (WebElement el : searchResults.subList(1, searchResults.size())) {

			// Get the text from the Subject line
			String subject = el.findElement(By.cssSelector("td:nth-child(7)")).getText();
			
			// Add to the bidDeclined array if the subject starts with Bid declined
			if (subject.startsWith("Bid declined")) {
				bidDeclined.add(subject);
			} // end if
			
			// Add to the bidSubmitted array if the subject starts with Bid submitted
			if (subject.startsWith("Bid submitted")) {
				bidSubmitted.add(subject);
			} // end if
			
			// Add to the newBiddingOpportunity array if the subject starts with New Bidding Opportunity
			if (subject.startsWith("New Bidding Opportunity")) {
				newBiddingOpportunity.add(subject);
			} // end if
			
		} // end for
		
		// Verify a 'Bid Submitted' email was received for both appraiser's bid submissions
		perform.verification(driver, Integer.toString(bidSubmitted.size()), "equals", "2");
		
		// Verify a 'Bid Declined' email was received
		perform.verification(driver, Integer.toString(bidDeclined.size()), "equals", "1");
		
		// Verify a 'New Bidding Opportunity' emails are still there
		String numOfNotifications = "3";
		if (!StoredVariables.getenvironment().get().contains("QA")) {
			numOfNotifications = "6";
		} // end if not QA
		perform.verification(driver, Integer.toString(newBiddingOpportunity.size()), "equals", numOfNotifications);
		
		// Login to Secure
		secure.login(driver, userSecure, password);
		
		// Find and Open the order
		secure.findAndOpenOrder(driver, trackingNumber);
		
		// Review bids
		secure.reviewBids(driver);
		
		// Send vendor a message
		secure.sendAMessageToVendorsInReviewBids(driver, new String[]{vendor3}, "Sorry, I'm not picking you");
		
		// Award bid
		secure.awardBid(driver, vendor2, "Congratulations, I'm picking you", "Sorry, you were not picked", "");

		// Click Close
		perform.click(driver, SOrderDetails.close_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Wait for audit trail to update
		perform.waitForText(driver, SOrderDetails.history_txt(driver), "History (In Progress)");
		
		// Verify the audit trail
		history = SOrderDetails.history_txt(driver).getText();
		String expected1 = "Bid declined by Client (Automation ResBidding3) for Vendor (Automati SameCoSU3)";
		String expected2 = "Sorry, you were not picked";
		String expected3 = "Order accepted by Appraiser (Automa SameCoSU2) and In Progress";
		String expected4 = "Order automatically accepted";
		String expected5 = "Bid Awarded by Client (Automation ResBidding3) to Appraiser (Automa SameCoSU2)";
		String expected6 = "Congratulations, I'm picking you";
		String expected7 = "Message from Client (Automation ResBidding3) to Automati SameCoSU3";
		String expected8 = "Sorry, I'm not picking you";
		String expected9 = "Vendor Automa SameCoSU2 agreed to the bid terms";
		String expected10 = "I also accept the bid";
		String expected11 = "Vendor Automation SameCoAppraiser1 agreed to the bid terms";
		String expected12 = "I accept the bid";
		String expected13 = "Order Changed by Client (Automation ResBidding3)";
		String expected14 = "Out for Bid by Client (Automation ResBidding3)";
		String expected15 = "Requires assignment";
		String expected16 = "Awaiting acceptance";
		expected = new String[]{expected1, expected2, expected3, expected4, expected5, expected6, expected7, expected8, 
				expected9, expected10, expected11, expected12, expected13, expected14, expected15, expected16};
		perform.verifyTextContains(driver, history, expected);
		
		// Go to the Notification Search Internal Tool and search by productItemID
		it.goToNotificationSearchAndSearchByProductItemID(driver, productItemID);
		
		// Verify there are 9 records
		it.waitForTheNumberOfRecordsInNotificationSearch(driver, 9, productItemID);
		
		// Create array lists to hold the To and Subject values
		ArrayList<String> bidAwarded = new ArrayList<String>();
		ArrayList<String> bidClientDeclined = new ArrayList<String>();
		ArrayList<String> bidMessage = new ArrayList<String>();
		ArrayList<String> bidVendorDeclined = new ArrayList<String>();
		ArrayList<String> bidVendorSubmit = new ArrayList<String>();
		ArrayList<String> bidNewOpportunity = new ArrayList<String>();
		
		// Get a list of the table to get the To and Subject fields
		searchResults = driver.findElements(By.cssSelector(ITNotificationSearch.rowSearchResults_txt()));
		for (WebElement el : searchResults.subList(1, searchResults.size())) {

			// Get the text from the Subject line
			String condition = el.findElement(By.cssSelector("td:nth-child(2)")).getText();
			
			// Add items to arrays for given conditions
			if (condition.startsWith("Bid - Awarded")) {
				bidAwarded.add(condition);
			} // end if
			
			if (condition.startsWith("Bid - ClientDeclined")) {
				bidClientDeclined.add(condition);
			} // end if
			
			if (condition.startsWith("Bid - Message")) {
				bidMessage.add(condition);
			} // end if
			
			if (condition.startsWith("Bid - VendorDeclined")) {
				bidVendorDeclined.add(condition);
			} // end if
			
			if (condition.startsWith("Bid - Vendor Submit")) {
				bidVendorSubmit.add(condition);
			} // end if
			
			if (condition.startsWith("Bid - New Oppurtunity")) {
				bidNewOpportunity.add(condition);
			} // end if
			
		} // end for
		
		// Verify emails sent
		String emailsSent1 = "1";
		String emailsSent2 = "3";
		if (!StoredVariables.getenvironment().get().contains("QA")) {
			emailsSent1 = "2";
			emailsSent2 = "6";
		} // end if
		perform.verification(driver, Integer.toString(bidAwarded.size()), "equals", emailsSent1);
		perform.verification(driver, Integer.toString(bidClientDeclined.size()), "equals", emailsSent1);
		perform.verification(driver, Integer.toString(bidMessage.size()), "equals", emailsSent1);
		perform.verification(driver, Integer.toString(bidVendorDeclined.size()), "equals", "1");
		perform.verification(driver, Integer.toString(bidVendorSubmit.size()), "equals", "2");
		perform.verification(driver, Integer.toString(bidNewOpportunity.size()), "equals", emailsSent2);
		
		// Login to vendors as vendor2 (winning vendor)
		vendors.login(driver, vendor2, password);
		
		// Open the order
		vendors.findAndOpenOrder(driver, trackingNumber);
		
		// Verify the Bid Vendor Information contains the correct vendor info
		bidVendorInfo = VOrderDetails.bidVendorInformation_txt(driver).getText();
		Assert.assertTrue(bidVendorInfo.contains(vendor2), vendor2 + " should be in the Bid Vendor Information section and is not");

		// Verify the audit trail
		history = VOrderDetails.history_txt(driver).getText();
		expected1 = "Automatically accepted by Appraiser (Automa SameCoSU2) and In Progress";
		expected2 = "Appraiser Automa SameCoSU2 has been awarded this order by Client Automation ResBidding3.";
		expected3 = "Congratulations, I'm picking you";
		expected4 = "Appraiser Automa SameCoSU2 agreed to bid terms.";
		expected5 = "I also accept the bid";
		expected6 = "Bid Pending by Automa SameCoSU2";
		expected = new String[]{expected1, expected2, expected3, expected4, expected5, expected6};
		perform.verifyTextContains(driver, history, expected);
		
		String notExpected1 = "Bid declined";
		String notExpected2 = "Sorry";
		String notExpected3 = "I accept the bid";
		String notExpected4 = "Vendor Automation SameCoAppraiser1 agreed to the bid terms";
		notExpected = new String[] {notExpected1, notExpected2, notExpected3, notExpected4};
		perform.verifyTextDoesNotContain(driver, history, notExpected);
		
		// Login to vendors as admin appraiser
		vendors.login(driver, userVendors, password);
		
		// Find order
		vendors.findOrder(driver, trackingNumber, "Tracking Number");
		
		// Verify there is only 1 record in the order grid
		rows = driver.findElements(By.cssSelector("#"+VOrders.ordersGrid_txt()+" tr"));
		count = rows.size();
		Assert.assertTrue(count==6, "There should only be 1 record in the order grid");
		
		// Open the order
		perform.doubleClickInTable(driver, vendor2);
		
		// Verify the Bid Vendor Information contains the correct vendor info
		bidVendorInfo = VOrderDetails.bidVendorInformation_txt(driver).getText();
		Assert.assertTrue(bidVendorInfo.contains(vendor2), vendor2 + " should be in the Bid Vendor Information section and is not");
		
		// Verify the audit trail only contains vendor2 information
		perform.verifyTextContains(driver, history, expected);
		perform.verifyTextDoesNotContain(driver, history, notExpected);
		
		// Log test
		test.log(LogStatus.INFO, "Residential Bidding", "Verified Residential Bidding within the same company");
		
	} // end sameCompanyBidOrder
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Go to Vendor Selection Settings</li>
	 * 	<li>Set changed boolean</li>
	 * 	<li>Turn on Automatic vendor selection</li>
	 * 	<li>Turn off Unattended Order Assignment</li>
	 * 	<li>Click OK</li>
	 * 	<li>Turn off Unattended Order Reassignment</li>
	 * 	<li>Confirm there is an option in the Residential appraisal selection section for Allow order bidding</li>
	 * 	<li>Enable Allow order bidding</li>
	 * 	<li>Confirm it has two sub options to lock or unlock the Fee and Date</li>
	 * 	<li>Lock Fee and Date Locks</li>
	 * 	<li>Confirm the locks default to locked</li>
	 * 	<li>Confirm under Ordering options section &gt; default order expiration time, there is a sub option for Default bid due</li>
	 * 	<li>Confirm the default bid due time is 12 hours</li>
	 * 	<li>Save settings</li>
	 * 	<li>Place a VMP order through the API</li>
	 * 	<li>Get order numbers</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Find and open the order</li>
	 * 	<li>Mark as a bid order</li>
	 * 	<li>Click assign</li>
	 * 	<li>Verify there are multiple vendors from the same company in the auto selection</li>
	 * 	<li>Click Finish</li>
	 * 	<li>Review the bids</li>
	 * 	<li>Verify vendors in the table</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Vendor Selection Settings", "Residential Bidding", "VMP - Create Order Via API", "Secure - Orders", "Secure - Issue As Bid", "Secure - Review Bids"}, alwaysRun=true)
	public void sameCompanyBidOrderAutoAssignment() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		String userSecure = "ResBidding4";
		String userVMP = "OriginatorResBidding4";

		// Log in to Secure
		secure.login(driver, userSecure, password);

		// Go to Vendor Selection Settings
		secure.goToVendorSelectionSettings(driver);
		
		// Set changed boolean
		boolean changed = false;
		
		// Turn on Automatic vendor selection
		if (!SVendorSelectionSettings.automaticVendorSelection_switch(driver).getAttribute("src").contains("switchOn.png")) {
			perform.click(driver, SVendorSelectionSettings.automaticVendorSelection_switch(driver));
			changed = true;
		}

		// Turn off Unattended Order Assignment
		if (SVendorSelectionSettings.unattendedOrderAssignment_switch(driver).getAttribute("src").contains("switchOn.png")) {
			
			perform.click(driver, SVendorSelectionSettings.unattendedOrderAssignment_switch(driver));
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			// Click OK
			perform.click(driver, SVendorSelectionSettings.unattendedOrderAssignmentDialogOk_btn(driver));
			changed = true;
		}

		// Turn off Unattended Order Reassignment
		if (SVendorSelectionSettings.unattendedOrderReassignment_switch(driver).getAttribute("src").contains("switchOn.png")) {
			perform.click(driver, SVendorSelectionSettings.unattendedOrderReassignment_switch(driver));
			changed = true;
		}
		
		// Confirm there is an option in the Residential appraisal selection section for Allow order bidding
		Assert.assertTrue(SVendorSelectionSettings.allowOrderBidding_switch(driver).isDisplayed(), "There should be an option to Allow order bidding");
		
		// Enable Allow order bidding
		if (SVendorSelectionSettings.allowOrderBidding_switch(driver).getAttribute("src").contains("switchOff.png")) {
			perform.click(driver, SVendorSelectionSettings.allowOrderBidding_switch(driver));
			Thread.sleep(1500);
			changed = true;
		}
		
		// Confirm it has two sub options to lock or unlock the Fee and Date
		WebElement feeLock = SVendorSelectionSettings.feeLock_btn(driver);
		WebElement dateLock = SVendorSelectionSettings.dateLock_btn(driver);
		Assert.assertTrue(feeLock.isDisplayed(), "There should be a Fee lock button");
		Assert.assertTrue(dateLock.isDisplayed(), "There should be a Date lock button");
		
		// Lock Fee and Date Locks
		if (feeLock.getAttribute("src").contains("/Images/Unlocked-Blue.png")) {
			perform.click(driver, feeLock);
		}
		if (dateLock.getAttribute("src").contains("/Images/Unlocked-Blue.png")) {
			perform.click(driver, dateLock);
		}
		
		// Confirm the locks default to locked
		Assert.assertTrue(feeLock.getAttribute("src").contains("/Images/Locked-Blue.png"), "The Fee lock should be locked");
		Assert.assertTrue(dateLock.getAttribute("src").contains("/Images/Locked-Blue.png"), "The Date lock should be locked");
		
		// Confirm under Ordering options section > default order expiration time, there is a sub option for Default bid due
		Assert.assertTrue(SVendorSelectionSettings.defaultBidDue_div(driver).getText().contains("Default bid due"), "There should be an option to set the Default bid due");
		
		// Confirm the default bid due time is 12 hours
		Assert.assertTrue(SVendorSelectionSettings.defaultBidDueHours_txtbx(driver).getAttribute("value").equals("12"), "The hours should be set to 12");
		
		// Save settings
		if (changed==true) {
			secure.saveVendorSelectionSettings(driver);	
		} // end if

		// Place a VMP order through the API
		perform.apiPlaceOrderFromVMPClientPortal(driver, userVMP, password, userSecure, "PlaceAppraisalOrderExLenderNoGroups-MultipleVendorsFromTheSameCompany");
		
		// Get order numbers
		String trackingNumber = StoredVariables.gettrackingNumber().get();
		
		// Login to Secure
		secure.login(driver, userSecure, password);
		
		// Find and open the order
		secure.findAndOpenOrder(driver, trackingNumber);

		// Mark as a bid order
		if (!SOrderDetails.issueAsBid_btn(driver).getAttribute("class").contains("imagecheckbox-container-checked")) {
			perform.click(driver, SOrderDetails.issueAsBid_btn(driver));
		} // end if
		
		// Click assign
		perform.click(driver, SOrderDetails.assign_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for Finish button
		perform.waitForElementToBeClickable(driver, SOrderDetails.finish_btn(driver));
		
		// Verify there are multiple vendors from the same company in the auto selection
		String biddingInformation = SOrderDetails.biddingInformation_txt(driver).getText();
		String expected1 = "SameCoSU1";
		String expected2 = "SameCoSU2";
		String expected3 = "SameCoSU3";
		String[] expected = {expected1, expected2, expected3};
		perform.verifyTextContains(driver, biddingInformation, expected);
		
		// Click Finish
		perform.click(driver, SOrderDetails.finish_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Review the bids
		secure.reviewBids(driver);
		
		// Verify vendors in the table
		String tableText = SReviewBids.appraiserTable_txt(driver).getText();
		perform.verifyTextContains(driver, tableText, expected);
		
		// Log test
		test.log(LogStatus.INFO, "Residential Bidding", "Verified Residential Bidding orders can be automatically assigned to members of the same company");
		
	} // end sameCompanyBidOrderAutoAssignment
	
} // end the AutomaticAssignmentSettings class
