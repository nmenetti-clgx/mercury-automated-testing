package regressionResidentialBidding;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Secure.SAwardBid;
import pageObjects.Secure.SChangeBidDueDate;
import pageObjects.Secure.SConfirmOrder;
import pageObjects.Secure.SDeclineBid;
import pageObjects.Secure.SOrderDetails;
import pageObjects.Secure.SProfile;
import pageObjects.Secure.SReviewBids;
import pageObjects.Secure.SUsers;
import pageObjects.Secure.SVendorSelection;
import pageObjects.Secure.SVendorSelectionSettings;
import pageObjects.Vendors.VOrderDetails;
import pageObjects.Vendors.VOrders;
import pageObjects.Vendors.VQuickList;
import pageObjects.Vendors.VSubmitBid;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Residential Bidding - Fee And Date Locked</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class FeeAndDateLocked extends TestSetup {

	/** The user secure. */
	private final String userSecure = "ResBidding1";
	
	/** The user secure SU. */
	private final String userSecureSU = "ResBidding1SU";
	
	/** The user vendors. */
	private final String userVendors = "Appraiser1";
	
	/** The user VMP. */
	private final String userVMP = "OriginatorResBidding1";
	
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
	 * 	<li>Go to Users</li>
	 * 	<li>Select the sub user</li>
	 * 	<li>Click the hyperlink in the permission Edit/Update Orders</li>
	 * 	<li>Confirm there is an option for Issue/Review Bids</li>
	 * 	<li>Uncheck the Issue/Review Bids permission for the sub user</li>
	 * 	<li>Click OK</li>
	 * 	<li>Save</li>
	 * 	<li>Login to VMP Client Portal</li>
	 * 	<li>Set variables for new order</li>
	 * 	<li>Place an order from VMP Client Portal</li>
	 * 	<li>Set the borrower name</li>
	 * 	<li>Get order numbers</li>
	 * 	<li>Log the tracking number</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Confirm there is not an option to Issue as bid next to the selection for Appraiser or AMC/Firm</li>
	 * 	<li>As the Admin, view the order details</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Confirm there is an option to Issue as bid next to the selection for Appraiser or AMC/Firm</li>
	 * 	<li>Check Issue as Bid</li>
	 * 	<li>Confirm the locks for Fee is locked (matches global)</li>
	 * 	<li>Confirm the locks for Date is locked (matches global)</li>
	 * 	<li>Confirm you can click and change the locks for Fee</li>
	 * 	<li>Confirm you can click and change the locks for Date</li>
	 * 	<li>Make sure the Fee is locked</li>
	 * 	<li>Make sure the Date is locked</li>
	 * 	<li>Click Assign</li>
	 * 	<li>Select available vendors and confirm selected vendors show in the Selected Vendors pod on the right</li>
	 * 	<li>Select Appraiser1</li>
	 * 	<li>Select Appraiser3</li>
	 * 	<li>Verify which line is Appraiser1 and set the Profile button</li>
	 * 	<li>View the Vendor Profile</li>
	 * 	<li>Click the Products tab</li>
	 * 	<li>Check the box 'Always pay the transaction fee for this vendor.'</li>
	 * 	<li>Click Save</li>
	 * 	<li>Verify which line is Appraiser3 and set the Profile button</li>
	 * 	<li>View the Vendor Profile</li>
	 * 	<li>Click the Products tab</li>
	 * 	<li>Check the box 'Always pay the transaction fee for this vendor.'</li>
	 * 	<li>Click Save</li>
	 * 	<li>Click Next</li>
	 * 	<li>Confirm there is a Bidding information pod on the confirmation step</li>
	 * 	<li>Confirm the selected vendors display in the Bidding information pod</li>
	 * 	<li>Confirm the order fee and order due date are displayed in the bidding information pod</li>
	 * 	<li>Confirm you can click and change the Fee lock</li>
	 * 	<li>Confirm when unlocked, the order fee does not display</li>
	 * 	<li>Confirm when the Fee is unlocked, the options for Order fee, Source, and Payment method are not displayed in the Payment information section</li>
	 * 	<li>Confirm you can click and change the Date lock</li>
	 * 	<li>Confirm when unlocked, the order due date does not display</li>
	 * 	<li>Confirm when the date is unlocked, the Order due does not display a date in the Assignment information section</li>
	 * 	<li>Click the Fee lock</li>
	 * 	<li>Click the Date lock</li>
	 * 	<li>Verify Fee lock is locked</li>
	 * 	<li>Verify Date lock is locked</li>
	 * 	<li>Enter fee</li>
	 * 	<li>Click Finish</li>
	 * 	<li>Confirm since you are covering the transaction fee for one vendor, the Almost done message displays stating you must agree to pay the Mercury Network transaction fee</li>
	 * 	<li>Click OK</li>
	 * 	<li>Check the box 'I agree to pay the Mercury Network transaction fee...'</li>
	 * 	<li>Click Finish</li>
	 * 	<li>Confirm the order is placed</li>
	 * 	<li>Confirm there is an Issue as bid field in Assignment information</li>
	 * 	<li>Confirm the locks for Fee and Date show as locked as the order was placed with them locked</li>
	 * 	<li>Log in as the vendor with the transaction fee paid for by the client</li>
	 * 	<li>Confirm the new bid order is found in the Bidding Orders folder</li>
	 * 	<li>Go to Orders</li>
	 * 	<li>Confirm it can also be found in the Inbox folder</li>
	 * 	<li>Go to Orders</li>
	 * 	<li>Confirm it can also be found in the New Orders folder</li>
	 * 	<li>Confirm the status shows Bid Pending</li>
	 * 	<li>Confirm the Order Fee value is displayed in red text</li>
	 * 	<li>Confirm the Due Date value is displayed in purple text</li>
	 * 	<li>Confirm there is a Submit Bid button instead of Accept/Decline Assignment</li>
	 * 	<li>Click Submit Bid</li>
	 * 	<li>Confirm there is a message stating the vendor will not be charged the fee as the client is covering the fee</li>
	 * 	<li>Confirm the Appraisal bid and Due date are displayed and cannot be changed</li>
	 * 	<li>Add test to make sure both of these fields are not editable</li>
	 * 	<li>Confirm Submit is currently not active and cannot be clicked</li>
	 * 	<li>Confirm the vendor can click I accept these terms, or I am unable to bid</li>
	 * 	<li>Click I accept these terms</li>
	 * 	<li>Confirm you can add a message to the client</li>
	 * 	<li>Confirm you can use the QuickList icon to add and use a QuickList item</li>
	 * 	<li>Open the QL dialog</li>
	 * 	<li>Delete any existing QL items</li>
	 * 	<li>Create a new QL item</li>
	 * 	<li>Select the first QL item</li>
	 * 	<li>Click Use</li>
	 * 	<li>Switch to Submit Bid iFrame</li>
	 * 	<li>Verify the new QL item is displayed</li>
	 * 	<li>Confirm you can now click on Submit</li>
	 * 	<li>Click Submit</li>
	 * 	<li>Confirm the Submit Bid button now states Update Bid</li>
	 * 	<li>Confirm there is an audit trail event showing any vendor notes and the vendor agreed to the bid terms</li>
	 * 	<li>Log in as the vendor who will be paying the transaction fee</li>
	 * 	<li>View the order details</li>
	 * 	<li>Click Submit Bid</li>
	 * 	<li>Switch to iFrame</li>
	 * 	<li>Confirm the message shows the vendor will be responsible for the transaction fee</li>
	 * 	<li>Confirm the transaction fee amount is displayed and includes any sales tax if applicable</li>
	 * 	<li>String transactionFee = "16.89";</li>
	 * 	<li>Assert.assertTrue(dialogText.contains(transactionFee), "The transaction fee is missing. Dialog = " + dialogText);</li>
	 * 	<li>Confirm the Submit button is not active and cannot be clicked</li>
	 * 	<li>Click I am unable to bid on this opportunity</li>
	 * 	<li>Add notes to the client</li>
	 * 	<li>Click on Submit</li>
	 * 	<li>Confirm the vendor receives the Are you sure message stating</li>
	 * 	<li>Click Decline</li>
	 * 	<li>Confirm the vendor receives the Success message stating 'The client will be notified you are unable to bid at this time.'</li>
	 * 	<li>Click OK</li>
	 * 	<li>Go to Orders</li>
	 * 	<li>Search for the order</li>
	 * 	<li>Verify the order is not found</li>
	 * 	<li>From Secure Mercury Network:</li>
	 * 	<li>Log in as the sub user without Issue/Review Bids permission</li>
	 * 	<li>View the order details</li>
	 * 	<li>Confirm the Review bids option is not active and cannot be clicked on</li>
	 * 	<li>Log in as the Admin</li>
	 * 	<li>View the order details</li>
	 * 	<li>Confirm there are audit trail events for the vendor accepting the terms and the vendor declining to bid</li>
	 * 	<li>Click Review bids</li>
	 * 	<li>Switch into iframe</li>
	 * 	<li>Confirm it displays all selected vendors and any bid information</li>
	 * 	<li>Find Appraiser1 row</li>
	 * 	<li>Appraiser1 should display Bid Submitted</li>
	 * 	<li>Appraiser3 should display Vendor declined</li>
	 * 	<li>Confirm Award bid, Decline bid, and send message are not active until a vendor bid is selected in the list</li>
	 * 	<li>Select Appraiser1</li>
	 * 	<li>Confirm Award bid, Decline bid, and send message are active</li>
	 * 	<li>Click on Add Vendor</li>
	 * 	<li>Switch to default content</li>
	 * 	<li>Confirm the Add additional vendors displays with eligible vendors to choose from</li>
	 * 	<li>Select a vendor (not from a company currently selected)</li>
	 * 	<li>Click Next</li>
	 * 	<li>Confirm the additional vendor is displayed in Bidding information</li>
	 * 	<li>Confirm you cannot change the status of the Fee and Date locks</li>
	 * 	<li>Click Finish</li>
	 * 	<li>Confirm you are returned to the Review bids window</li>
	 * 	<li>Confirm the new vendor is listed</li>
	 * 	<li>Click Rank vendors</li>
	 * 	<li>Verify there are only 2 Rank inputs</li>
	 * 	<li>Confirm an entry box is displayed for the column Rank for eligible vendors (not for vendors who declined)</li>
	 * 	<li>Row 1</li>
	 * 	<li>Row 2</li>
	 * 	<li>Row 3</li>
	 * 	<li>Rank the vendors 2 or higher</li>
	 * 	<li>Click Save</li>
	 * 	<li>Confirm you receive the Ranking order message stating must start with 1</li>
	 * 	<li>Click OK</li>
	 * 	<li>Change the numbers to start with 1</li>
	 * 	<li>Click Save</li>
	 * 	<li>Confirm the rankings are saved and displayed</li>
	 * 	<li>Click Change bid due</li>
	 * 	<li>Change iFrame</li>
	 * 	<li>Confirm you can change the bid due date and include comments</li>
	 * 	<li>Get the current Bid due date</li>
	 * 	<li>Click the Calendar button</li>
	 * 	<li>Select 5 days in the future</li>
	 * 	<li>Add comments</li>
	 * 	<li>Get the new Bid due date</li>
	 * 	<li>Verify the due date changed</li>
	 * 	<li>Click Set date</li>
	 * 	<li>Get back into the Review bids iFrame</li>
	 * 	<li>Click Close</li>
	 * 	<li>Get the audit trail text</li>
	 * 	<li>Confirm there is an audit trail event for the change in the bid due date</li>
	 * 	<li>Select a vendor in the Review bids list</li>
	 * 	<li>Click Review bids</li>
	 * 	<li>Switch into the Review bids iFrame</li>
	 * 	<li>perform.waitForiFrameSrcAndSwitchToIt(driver, "Bidding/Review.aspx", By.xpath("td[contains(text(), 'Automation Appraiser1')]"));</li>
	 * 	<li>Select Automation Appraiser1</li>
	 * 	<li>Confirm Award bid, Decline bid, and Send message are now active</li>
	 * 	<li>Click Send message</li>
	 * 	<li>Confirm it shows the vendor(s) selected before Send message was clicked</li>
	 * 	<li>Confirm you can enter a message and Send to the selected vendor(s)</li>
	 * 	<li>Click Send</li>
	 * 	<li>Get back into the Review bids iFrame</li>
	 * 	<li>Click Close</li>
	 * 	<li>Get the audit trail text</li>
	 * 	<li>Confirm the audit trail event shows the vendor(s) and the message sent</li>
	 * 	<li>Click Review bids</li>
	 * 	<li>Switch into the Review bids iFrame</li>
	 * 	<li>perform.waitForiFrameSrcAndSwitchToIt(driver, "Bidding/Review.aspx",By.xpath("td[contains(text(), 'Automation ResBidAppraiser1')]"));</li>
	 * 	<li>From the Review bids dialog, select the vendor added (without a bid submitted)</li>
	 * 	<li>Click Decline bid</li>
	 * 	<li>Confirm you can include a Decline Note</li>
	 * 	<li>Click Decline</li>
	 * 	<li>Switch to ResBidding iFrame</li>
	 * 	<li>Confirm the vendor shows as Bid Declined in the list</li>
	 * 	<li>Get back into the Review bids iFrame</li>
	 * 	<li>Click Close</li>
	 * 	<li>Get the audit trail text</li>
	 * 	<li>Confirm there is an audit trail event</li>
	 * 	<li>Click Review bids</li>
	 * 	<li>Switch into the Review bids iFrame</li>
	 * 	<li>Select the vendor with a bid</li>
	 * 	<li>Click Award bid</li>
	 * 	<li>Switch to iFrame</li>
	 * 	<li>Confirm you can include an Award note</li>
	 * 	<li>Confirm the Order fee is displayed and cannot be changed</li>
	 * 	<li>Confirm you can change the payment method</li>
	 * 	<li>Confirm you can click Award</li>
	 * 	<li>Click Close on the attach document window</li>
	 * 	<li>Get the history text</li>
	 * 	<li>Confirm there is an audit trail event showing the bid awarded including the fee and date</li>
	 * 	<li>Confirm the order is automatically accepted by the vendor and there is an audit trail event</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Residential Bidding", "Secure - Vendor Selection Settings", "Secure - Users", "VMP - Create Order", "Secure - Orders", "Secure - Issue As Bid", "Secure - Vendor Profile", "Secure - Products", "Vendors - Orders",
			"Vendors - Submit Bid", "Vendors - QuickList", "Vendors - Accept Bid", "Vendors - Decline Bid", "Secure - Review Bids", "Secure - Send Message", "Secure - Decline Bid", "Secure - Award Bid"}, alwaysRun=true)
	public void feeAndDateLocked() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
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
		}
		
		// Go to Users
		secure.goToUsers(driver);
		
		// Select the sub user
		perform.click(driver, SUsers.subUser_btn(driver));
		
		// Wait for Edit/Update link
		perform.waitForElementToBeClickable(driver, "Edit/Update", "linkText");
		
		// Click the hyperlink in the permission Edit/Update Orders
		perform.click(driver, driver.findElement(By.linkText("Edit/Update")));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SUsers.okEditUpdateOrders_btn(), "id");
		
		// Confirm there is an option for Issue/Review Bids
		Assert.assertTrue(SUsers.issueReviewBids_txtbx(driver).getText().equals("Issue/Review Bids"), "There should be an option to Issue/Review Bids");
		
		// Uncheck the Issue/Review Bids permission for the sub user
		if (SUsers.issueReviewBids_chkbx(driver).isSelected()) {
			perform.clickLabelText(driver, "Issue/Review Bids");	
		}
		Assert.assertTrue(!SUsers.issueReviewBids_chkbx(driver).isSelected(), "Issue/Review Bids checkbox should be checked");
		
		// Click OK
		perform.click(driver, SUsers.okEditUpdateOrders_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Save
		secure.saveUsersSettings(driver);
		
		// Login to VMP Client Portal
		vmp.login(driver, userSecure, userVMP, password);
		
		// Set variables for new order
		vmp.setVariables(driver);
		
		// Place an order from VMP Client Portal
		vmp.createVMPOrder(driver);
		
		// Set the borrower name
		String borrower = StoredVariables.getcontactBorrower().get() + "-" + StoredVariables.getborrowerIdentifier().get();
		test.log(LogStatus.INFO, "Info", "Borrower: " + borrower);
		
		// Get order numbers
		db.getLoanIDsFromVMPClientPortalOrder(driver);
		String trackingNumber = StoredVariables.gettrackingNumber().get();
		String trackingNumberVMP = StoredVariables.gettrackingNumberVMP().get();
		
		// Log the tracking number
		test.log(LogStatus.INFO, "Tracking Number", "Tracking #: " + trackingNumber + "\nVMP Tracking #: " + trackingNumberVMP);
		
		// Login to Secure and open the order
		secure.loginAndOpenOrderByTrackingNumber(driver, userSecureSU, password, trackingNumber);
		
		// Verify order details
		secure.verifyResidentialAppraisalOrderDetails(driver);
		
		// Confirm there is not an option to Issue as bid next to the selection for Appraiser or AMC/Firm
		Assert.assertTrue(!SOrderDetails.assign_div(driver).getText().contains("Issue as bid"), "The subuser should not be able to issue the order as a bid");
		
		// As the Admin, view the order details
		// Login to Secure and open the order
		secure.loginAndOpenOrderByTrackingNumber(driver, userSecure, password, trackingNumber);
		
		// Verify order details
		secure.verifyResidentialAppraisalOrderDetails(driver);
		
		// Confirm there is an option to Issue as bid next to the selection for Appraiser or AMC/Firm
		Assert.assertTrue(SOrderDetails.assign_div(driver).getText().contains("Issue as bid"), "The subuser should be able to issue the order as a bid");
		
		// Check Issue as Bid
		perform.click(driver, SOrderDetails.issueAsBid_btn(driver));
		
		// Confirm the locks for Fee is locked (matches global)
		WebElement fee = SOrderDetails.feeLock_btn(driver);
		Assert.assertTrue(fee.isDisplayed(), "The Fee lock should be displayed");
		Assert.assertTrue(fee.getAttribute("class").contains("imagecheckbox-container-checked"), "The Fee lock should be locked");
		Assert.assertTrue(fee.getAttribute("title").equals("Unlock to allow the vendor to enter a fee."), "The Fee lock title should be 'Unlock to allow the vendor to enter a fee.'");

		// Confirm the locks for Date is locked (matches global)
		WebElement date = SOrderDetails.dateLock_btn(driver);
		Assert.assertTrue(date.isDisplayed(), "The Date lock should be displayed");
		Assert.assertTrue(date.getAttribute("class").contains("imagecheckbox-container-checked"), "The Date lock should be locked");
		Assert.assertTrue(date.getAttribute("title").equals("Unlock to allow the vendor to enter a due date."), "The Date lock title should be 'Unlock to allow the vendor to enter a due date.'");
		
		// Confirm you can click and change the locks for Fee
		perform.click(driver, fee);
		fee = SOrderDetails.feeLock_btn(driver);
		Assert.assertTrue(!fee.getAttribute("class").contains("imagecheckbox-container-checked"), "The Fee lock should be unlocked");
		Assert.assertTrue(fee.getAttribute("title").equals("Lock to control the order fee."), "The Fee lock title should be 'Lock to control the order fee.'");
		
		// Confirm you can click and change the locks for Date
		perform.click(driver, date);
		date = SOrderDetails.dateLock_btn(driver);
		Assert.assertTrue(!date.getAttribute("class").contains("imagecheckbox-container-checked"), "The Date lock should be unlocked");
		Assert.assertTrue(date.getAttribute("title").equals("Lock to control the order due date."), "The Date lock title should be 'Lock to control the order due date.'");
		
		// Make sure the Fee is locked
		perform.click(driver, fee);
		fee = SOrderDetails.feeLock_btn(driver);
		Assert.assertTrue(fee.getAttribute("class").contains("imagecheckbox-container-checked"), "The Fee lock should be locked");
		Assert.assertTrue(fee.getAttribute("title").equals("Unlock to allow the vendor to enter a fee."), "The Fee lock title should be 'Unlock to allow the vendor to enter a fee.'");
		
		// Make sure the Date is locked
		perform.click(driver, date);
		date = SOrderDetails.dateLock_btn(driver);
		Assert.assertTrue(date.getAttribute("class").contains("imagecheckbox-container-checked"), "The Date lock should be locked");
		Assert.assertTrue(date.getAttribute("title").equals("Unlock to allow the vendor to enter a due date."), "The Date lock title should be 'Unlock to allow the vendor to enter a due date.'");
		
		// Click Assign
		perform.click(driver, SOrderDetails.assign_btn(driver));

		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Close Related Orders popup
		secure.checkForRelatedOrdersDialog(driver);

		// Wait for Fee Panel tab
		perform.waitForElementToBeClickable(driver, SVendorSelection.feePanelTab_tab(), "id");
		
		// Select available vendors and confirm selected vendors show in the Selected Vendors pod on the right
		// Select Appraiser1
		perform.clickInTable_Contains(driver, "Automation " + userVendors);
		
		// Wait for the vendor to be added to the Selected vendors table
		perform.waitForText(driver, SVendorSelection.selectedVendorsTable_txt(driver), userVendors);
		
		Thread.sleep(3000);

		// Select Appraiser3
		perform.clickInTable_Contains(driver, "Appraiser3");
		
		// Wait for the vendor to be added to the Selected vendors table
		perform.waitForText(driver, SVendorSelection.selectedVendorsTable_txt(driver), "Appraiser3");
		
		Thread.sleep(3000);
		
		// Verify which line is Appraiser1 and set the Profile button
		WebElement profile = null;
		WebElement firstAppraiser = driver.findElement(By.cssSelector("#tblBidVendors > tbody > tr:nth-child(1) > td.VendorSelectVendorName"));
		if (firstAppraiser.getText().contains(userVendors)) {
			profile = driver.findElement(By.cssSelector("#tblBidVendors > tbody > tr:nth-child(1) > td:nth-child(3) > img"));
		}
		else {
			profile = driver.findElement(By.cssSelector("#tblBidVendors > tbody > tr.ui-ig-altrecord.ui-iggrid-altrecord > td:nth-child(3) > img"));
		}
		
		// View the Vendor Profile
		secure.viewVendorProfile(driver, profile, "Appraiser");
		
		// Click the Products tab
		perform.click(driver, SProfile.products_tab(driver));
		
		// Wait for Always pay the transaction fee checkbox
		perform.waitForElementToBeClickable(driver, SProfile.alwaysPayTheTransactionFeeForThisVendor_chkbx(), "id");
		
		// Check the box 'Always pay the transaction fee for this vendor.'
		perform.checkCheckbox(driver, SProfile.alwaysPayTheTransactionFeeForThisVendor_chkbx(driver));
		
		// Click Save
		perform.click(driver, SProfile.save_btn(driver));
		
		// Switch out of iFrame
		driver.switchTo().defaultContent();
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);

		// Verify which line is Appraiser3 and set the Profile button
		profile = null;
		firstAppraiser = driver.findElement(By.cssSelector("#tblBidVendors > tbody > tr:nth-child(1) > td.VendorSelectVendorName"));
		if (firstAppraiser.getText().contains("Appraiser3")) {
			profile = driver.findElement(By.cssSelector("#tblBidVendors > tbody > tr:nth-child(1) > td:nth-child(3) > img"));
		}
		else {
			profile = driver.findElement(By.cssSelector("#tblBidVendors > tbody > tr.ui-ig-altrecord.ui-iggrid-altrecord > td:nth-child(3) > img"));
		}
		
		// View the Vendor Profile
		secure.viewVendorProfile(driver, profile, "Appraiser");
		
		// Click the Products tab
		perform.click(driver, SProfile.products_tab(driver));
		
		// Wait for Always pay the transaction fee checkbox
		perform.waitForElementToBeClickable(driver, SProfile.alwaysPayTheTransactionFeeForThisVendor_chkbx(), "id");
		
		// Check the box 'Always pay the transaction fee for this vendor.'
		perform.uncheckCheckbox(driver, SProfile.alwaysPayTheTransactionFeeForThisVendor_chkbx(driver));
		
		// Click Save
		perform.click(driver, SProfile.save_btn(driver));
		
		// Switch out of iFrame
		driver.switchTo().defaultContent();
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Click Next
		perform.click(driver, SVendorSelection.nextBottom_btn(driver));
		
		// Wait for Bidding information
		perform.waitForElementToBeClickable(driver, SConfirmOrder.vendorSection_txt(), "id");
		
		// Confirm there is a Bidding information pod on the confirmation step
		String vendorSection = SConfirmOrder.vendorSection_txt(driver).getText();
		Assert.assertTrue(vendorSection.contains("Bidding information"), "There should be Bidding information in the vendor section");
		
		// Confirm the selected vendors display in the Bidding information pod
		Assert.assertTrue(vendorSection.contains(userVendors), "Appraiser1 should be in the Bidding information pod");
		Assert.assertTrue(vendorSection.contains("Appraiser3"), "Appraiser3 should be in the Bidding information pod");
		
		// Confirm the order fee and order due date are displayed in the bidding information pod
		Assert.assertTrue(vendorSection.contains("$500"), "The $500 fee should be in the Bidding information pod");
		Assert.assertTrue(vendorSection.contains(StoredVariables.getorderDueDateShort().get()), "The date ("+StoredVariables.getorderDueDateShort().get()+") should be in the Bidding information pod");
		
		// Confirm you can click and change the Fee lock
		perform.click(driver, SConfirmOrder.feeLock_btn(driver));
		
		// Confirm when unlocked, the order fee does not display
		Assert.assertTrue(SConfirmOrder.bidFee_txt(driver).getAttribute("style").equals("display: none;"), "The order fee should not display when the Fee lock is unlocked");

		// Confirm when the Fee is unlocked, the options for Order fee, Source, and Payment method are not displayed in the Payment information section
		Assert.assertTrue(!SConfirmOrder.orderFee_txtbx(driver).isDisplayed(), "The Order fee should not be displayed when the Fee is unlocked");
		Assert.assertTrue(!SConfirmOrder.source_dropdown(driver).isDisplayed(), "The Source dropdown should not be displayed when the Fee is unlocked");
		Assert.assertTrue(!SConfirmOrder.paymentMethod_dropdown(driver).isDisplayed(), "The Payment method dropdown should not be displayed when the Fee is unlocked");
		
		// Confirm you can click and change the Date lock
		perform.click(driver, SConfirmOrder.dateLock_btn(driver));
		
		// Confirm when unlocked, the order due date does not display
		Assert.assertTrue(SConfirmOrder.bidDate_txt(driver).getAttribute("style").equals("display: none;"), "The bid date should not display when the Date lock is unlocked");
		
		// Confirm when the date is unlocked, the Order due does not display a date in the Assignment information section
		Assert.assertTrue(SConfirmOrder.orderDueDate_txt(driver).getText().equals(""), "The Order Due Date should not display when the Date lock is unlocked");
		
		// Click the Fee lock
		perform.click(driver, SConfirmOrder.feeLock_btn(driver));
		
		// Click the Date lock
		perform.click(driver, SConfirmOrder.dateLock_btn(driver));
		
		// Verify Fee lock is locked
		Assert.assertTrue(SConfirmOrder.feeLock_btn(driver).getAttribute("class").contains("imagecheckbox-container-checked"), "The Fee lock should be locked");
		
		// Verify Date lock is locked
		Assert.assertTrue(SConfirmOrder.dateLock_btn(driver).getAttribute("class").contains("imagecheckbox-container-checked"), "The Date lock should be locked");
		
		// Enter fee
		perform.type(driver, SConfirmOrder.orderFee_txtbx(driver), "500");
		
		// Click Finish
		perform.click(driver, SConfirmOrder.finishBottom_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SConfirmOrder.messageOK_btn(), "id");
		
		// Confirm since you are covering the transaction fee for one vendor, the Almost done message displays stating you must agree to pay the Mercury Network transaction fee
		Assert.assertTrue(SConfirmOrder.message_txt(driver).getText().contains("Almost done"), "The message stating you must agree to pay the Mercury Network transaction fee is incorrect");
		Assert.assertTrue(SConfirmOrder.message_txt(driver).getText().contains("Please correct the following issues and try again."), "The message stating you must agree to pay the Mercury Network transaction fee is incorrect");
		Assert.assertTrue(SConfirmOrder.message_txt(driver).getText().contains("You must agree to pay"), "The message stating you must agree to pay is incorrect");
		
		// Click OK
		perform.click(driver, SConfirmOrder.messageOK_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Check the box 'I agree to pay the Mercury Network transaction fee...'
		perform.checkCheckbox(driver, SConfirmOrder.iAgreeToPayTheMercuryNetworkTransactionFee_chkbx(driver));
		
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

		// Log in as the vendor with the transaction fee paid for by the client
		vendors.login(driver, userVendors, password);
		System.out.println("OrderNumber = " + trackingNumber);
		System.out.println("OrderNumberVMP = " + trackingNumberVMP);
		
		// Confirm the new bid order is found in the Bidding Orders folder
		vendors.findOrderInFolder(driver, "Bidding Orders", "Due", borrower);
		
		// Commented this out because there appears to be a problem with the filter for Inbox items
//		// Go to Orders
//		vendors.goToOrders(driver);
//		
//		// Confirm it can also be found in the Inbox folder
//		vendors.findOrderInFolder(driver, "Inbox", "Due", borrower);
		
		// Go to Orders
		vendors.goToOrders(driver);

		// Confirm it can also be found in the New Orders folder
		vendors.findOrderInFolder(driver, "New Orders", "Due", borrower);
		
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
		
		// Click Submit Bid
		perform.click(driver, VOrderDetails.submitBid_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Switch into iFrame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "Bidding/SubmitBid.aspx", By.id(VSubmitBid.cancel_btn()));
		
		// Wait for the Cancel button
		perform.waitForElementToBeClickable(driver, VSubmitBid.cancel_btn(), "id");
		
		// Confirm there is a message stating the vendor will not be charged the fee as the client is covering the fee
		String dialogText = VSubmitBid.dialog_txt(driver).getText();
		Assert.assertTrue(dialogText.contains("You won't be charged a transaction fee for this order because the client has agreed to cover the transaction fee."), "There should be a message stating the vendor will not be charged the fee as the client is covering the fee. The text in the dialog = " + dialogText);
		
		// Confirm the Appraisal bid and Due date are displayed and cannot be changed
		Assert.assertTrue(dialogText.contains("Appraisal bid $"), "The Appraisal bid should be displayed. The text in the dialog = " + dialogText);
		Assert.assertTrue(dialogText.contains("Due date "), "The Due date should be displayed. The text in the dialog = " + dialogText);
		// Add test to make sure both of these fields are not editable
		
		// Confirm Submit is currently not active and cannot be clicked
		Assert.assertTrue(VSubmitBid.submit_btn(driver).getAttribute("class").contains("SkinButtonDisabled"), "The Submit button should be disabled but is not");
		
		// Confirm the vendor can click I accept these terms, or I am unable to bid
		perform.click(driver, VSubmitBid.iAmUnableToBid_radiobtn(driver));
		
		Thread.sleep(1000);
		
		// Click I accept these terms
		perform.click(driver, VSubmitBid.iAcceptTheseTerms_radiobtn(driver));
		
		// Confirm you can add a message to the client
		perform.type(driver, VSubmitBid.messageToTheClient_txtbx(driver), "These are test message notes to the client");
		Thread.sleep(500);
		VSubmitBid.messageToTheClient_txtbx(driver).clear();
		
		// Confirm you can use the QuickList icon to add and use a QuickList item
		// Open the QL dialog
		vendors.openQLDialog(driver, VSubmitBid.messageToTheClient_txtbx(driver), VSubmitBid.ql_btn(driver));
		
		// Delete any existing QL items
		vendors.deleteAllQLItems(driver);
		
		// Create a new QL item
		vendors.createNewQLItem(driver, "Test QL text", "This is test QL text");
		
		// Wait for the checkmark
		perform.waitForElementToBeClickable(driver, VQuickList.checkmark_btn(), "cssSelector");
		
		// Select the first QL item
		perform.click(driver, VQuickList.checkmark_btn(driver));
		
		// Click Use
		perform.click(driver, VQuickList.use_btn(driver));
		
		// Switch to Submit Bid iFrame
		driver.switchTo().defaultContent();
		perform.waitForiFrameSrcAndSwitchToIt(driver, "Bidding/SubmitBid.aspx", By.id(VSubmitBid.messageToTheClient_txtbx()));
		
		// Wait for the message textbox
		perform.waitForElementToBeClickable(driver, VSubmitBid.messageToTheClient_txtbx(), "id");
		
		// Verify the new QL item is displayed
		String messageText = VSubmitBid.messageToTheClient_txtbx(driver).getAttribute("value");
		Assert.assertTrue(messageText.equals("This is test QL text"), "The message textbox should be the new QL item. Message text = " + messageText);
		
		// Confirm you can now click on Submit
		Assert.assertTrue(!VSubmitBid.submit_btn(driver).getAttribute("class").contains("SkinButtonDisabled"), "The Submit button should not be disabled");
		
		// Click Submit
		perform.click(driver, VSubmitBid.submit_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Confirm the Submit Bid button now states Update Bid
		perform.waitForElementToBeVisible(driver, VOrderDetails.menuBar(), "id");
		String menuBar = VOrderDetails.menuBar(driver).getText();
		Assert.assertTrue(menuBar.contains("Update Bid"), "There should be an Update Bid button in the menu bar. Menu Bar = " + menuBar);
		
		// Confirm there is an audit trail event showing any vendor notes and the vendor agreed to the bid terms
		String history = VOrderDetails.history_txt(driver).getText();
		Assert.assertTrue(history.contains("Appraiser Automation Appraiser1 agreed to bid terms."), "The history should contain ''. History = " + history);
		Assert.assertTrue(history.contains("This is test QL text"), "The history should contain ''. History = " + history);
		Assert.assertTrue(history.contains("Bid Pending by Automation Appraiser1"), "The history should contain ''. History = " + history);

		// Log in as the vendor who will be paying the transaction fee
		vendors.login(driver, "Appraiser3", password);
		
		// View the order details
		vendors.findAndOpenOrder(driver, trackingNumber);
		
		// Click Submit Bid
		perform.click(driver, VOrderDetails.submitBid_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Switch to iFrame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "Bidding/SubmitBid.aspx", By.id(VSubmitBid.dialog_txt()));
		
		// Confirm the message shows the vendor will be responsible for the transaction fee
		dialogText = VSubmitBid.dialog_txt(driver).getText();
		Assert.assertTrue(dialogText.contains("By selecting continue, I acknowledge the Mercury Network transaction fee shown below will be charged to my account (discounts may apply)."), "The message should show the vendor will be responsible for the transaction fee. Dialog = " + dialogText);
		
		// Confirm the transaction fee amount is displayed and includes any sales tax if applicable
		Assert.assertTrue(dialogText.contains("Transaction fee $"), "Dialog = " + dialogText);
//		String transactionFee = "16.89";
//		Assert.assertTrue(dialogText.contains(transactionFee), "The transaction fee is missing. Dialog = " + dialogText);
		
		// Confirm the Submit button is not active and cannot be clicked
		Assert.assertTrue(VSubmitBid.submit_btn(driver).getAttribute("class").contains("SkinButtonDisabled"), "The Submit button should be disabled but is not");
		
		// Click I am unable to bid on this opportunity
		perform.click(driver, VSubmitBid.iAmUnableToBid_radiobtn(driver));
		
		// Add notes to the client
		perform.type(driver, VSubmitBid.messageToTheClient_txtbx(driver), "I do not want to bid");
		
		// Click on Submit
		perform.click(driver, VSubmitBid.submit_btn(driver));
		
		// Wait for Decline dialog
		perform.waitForElementToBeClickable(driver, VSubmitBid.declineBidDialog_txt(), "id");
		
		// Confirm the vendor receives the Are you sure message stating
		String declineDialog = VSubmitBid.declineBidDialog_txt(driver).getText();
		Assert.assertTrue(declineDialog.contains("If you decline to bid, you will no longer be eligible for this order. If you wish to discuss options with your client, please send a message instead."), "The dialog should say 'If you decline to bid, you will no longer be eligible for this order. If you wish to discuss options with your client, please send a message instead.'. Dialog = " + declineDialog);
		
		// Click Decline
		perform.click(driver, VSubmitBid.decline_btn(driver));
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, VSubmitBid.ok_btn(), "id");
		
		// Confirm the vendor receives the Success message stating 'The client will be notified you are unable to bid at this time.'		
		declineDialog = VSubmitBid.declineBidDialog_txt(driver).getText();
		Assert.assertTrue(declineDialog.contains("The client will be notified you are unable to bid at this time."), "The dialog should contain 'The client will be notified you are unable to bid at this time.' The dialog = " + declineDialog);
		
		// Click OK
		perform.click(driver, VSubmitBid.ok_btn(driver));
		
		// Get out of iFrame
		driver.switchTo().defaultContent();
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Go to Orders
		vendors.goToOrders(driver);
		
		// Search for the order
		vendors.findOrder(driver, trackingNumber, "Tracking Number");
		
		// Verify the order is not found
		String gridText = VOrders.ordersGrid_txt(driver).getText();
		Assert.assertTrue(gridText.contains("No orders found for the selected filter."), "The order should not be displayed. Orders Grid = " + gridText);
		
		// From Secure Mercury Network:
		// Log in as the sub user without Issue/Review Bids permission
		secure.login(driver, userSecureSU, password);
		
		// View the order details
		secure.findOrder(driver, trackingNumber, "Tracking number");
		secure.openOrder(driver, trackingNumber);
		
		// Confirm the Review bids option is not active and cannot be clicked on
		Assert.assertTrue(driver.findElement(By.cssSelector("img[src='/App_Themes/FlatGrayscale/Icons/Review.O-disabled.png']")).isDisplayed(), "The Review bids button should be disabled");
		
		// Log in as the Admin
		secure.login(driver, userSecure, password);
		
		// View the order details
		secure.findOrder(driver, trackingNumber, "Tracking number");
		secure.openOrder(driver, trackingNumber);
		
		// Confirm there are audit trail events for the vendor accepting the terms and the vendor declining to bid
		history = SOrderDetails.history_txt(driver).getText();
		Assert.assertTrue(history.contains("Vendor Automation Appraiser1 agreed to the bid terms."), "The history is missing audit trail events for the vendor accepting the terms. The history = " + history);
		Assert.assertTrue(history.contains("This is test QL text"), "The history is missing audit trail events for the vendor accepting the terms. The history = " + history);
		Assert.assertTrue(history.contains("Vendor Automation Appraiser3 declined to bid on this order."), "The history is missing audit trail events for the vendor declining to bid. The history = " + history);
		Assert.assertTrue(history.contains("I do not want to bid"), "The history is missing audit trail events for the vendor declining to bid. The history = " + history);
		
		// Click Review bids
		perform.click(driver, SOrderDetails.reviewBids_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		Thread.sleep(1000);
		
		// Switch into iframe
		perform.waitForiFrameSrcAndSwitchToIt(driver, "Bidding/Review.aspx", By.id(SReviewBids.closeReviewBids_btn()));
		
		// Wait for the Close button
		perform.waitForElementToBeClickable(driver, SReviewBids.closeReviewBids_btn(), "id");
		
		// Confirm it displays all selected vendors and any bid information
		String table = SReviewBids.appraiserTable_txt(driver).getText();
		Assert.assertTrue(table.contains("Automation Appraiser1"), "Automation Appraiser1 is missing from the table");
		Assert.assertTrue(table.contains("Automation Appraiser3"), "Automation Appraiser3 is missing from the table");
		
		// Find Appraiser1 row
		WebElement row1 = driver.findElement(By.cssSelector("#"+SReviewBids.appraiserTable_txt()+" > tbody > tr:nth-child(1)"));
		WebElement statusRow1 = driver.findElement(By.cssSelector("#"+SReviewBids.appraiserTable_txt()+" > tbody > tr:nth-child(1) > td:nth-child(8)"));
		WebElement statusRow2 = driver.findElement(By.cssSelector("#"+SReviewBids.appraiserTable_txt()+" > tbody > tr:nth-child(2) > td:nth-child(8)"));
		
		// Appraiser1 should display Bid Submitted
		String vendorStatus = "";
		if (row1.getText().contains(userVendors)) {
			vendorStatus = statusRow1.getText();
		} else {
			vendorStatus = statusRow2.getText();
		}
		Assert.assertTrue(vendorStatus.contains("Bid Submitted"), "Appraiser1 status should be Bid Submitted. vendorStatus = " + vendorStatus);
		
		// Appraiser3 should display Vendor declined
		vendorStatus = "";
		if (row1.getText().contains("Appraiser3")) {
			vendorStatus = statusRow1.getText();
		} else {
			vendorStatus = statusRow2.getText();
		}
		Assert.assertTrue(vendorStatus.contains("Vendor declined"), "Appraiser3 status should be Vendor declined");
		
		// Confirm Award bid, Decline bid, and send message are not active until a vendor bid is selected in the list
		Assert.assertTrue(SReviewBids.awardBidDisabled_btn(driver).isDisplayed(), "The Award Bid button should be disabled");
		Assert.assertTrue(SReviewBids.declineBidDisabled_btn(driver).isDisplayed(), "The Decline Bid button should be disabled");
		Assert.assertTrue(SReviewBids.sendMessageDisabled_btn(driver).isDisplayed(), "The Send Message button should be disabled");
		
		// Select Appraiser1
		perform.clickInTable_Contains(driver, userVendors);
		
		// Confirm Award bid, Decline bid, and send message are active
		Assert.assertTrue(SReviewBids.awardBid_btn(driver).isDisplayed(), "The Award Bid button should not be disabled");
		Assert.assertTrue(SReviewBids.declineBid_btn(driver).isDisplayed(), "The Decline Bid button should not be disabled");
		Assert.assertTrue(SReviewBids.sendMessage_btn(driver).isDisplayed(), "The Send Message button should not be disabled");
		
		// Click on Add Vendor
		perform.click(driver, SReviewBids.addVendor_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Switch to default content
		driver.switchTo().defaultContent();
		
		// Wait for the Next button
		perform.waitForElementToBeClickable(driver, SVendorSelection.nextTop_btn(), "id");
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Confirm the Add additional vendors displays with eligible vendors to choose from
		Assert.assertTrue(SVendorSelection.feePanelTable_txt(driver).getText().contains("ResBidAppraiser1"), "ResBidAppraiser1 should be an available vendor. Vendors availabe = " + SVendorSelection.feePanelTable_txt(driver).getText());
		
		// Select a vendor (not from a company currently selected)
		perform.clickInTable_Contains(driver, "ResBidAppraiser1");
		
		// Wait for the vendor to be added to the Selected vendors table
		perform.waitForText(driver, SVendorSelection.selectedVendorsTable_txt(driver), "ResBidAppraiser1");
		
		// Click Next
		perform.click(driver, SVendorSelection.nextTop_btn(driver));
		
		// Confirm the additional vendor is displayed in Bidding information
		Assert.assertTrue(SConfirmOrder.vendorSection_txt(driver).getText().contains("ResBidAppraiser1"), "The ResBidAppraiser1 info shoudl be displayed in the Bidding information table");
		
		// Confirm you cannot change the status of the Fee and Date locks
		Assert.assertTrue(driver.findElement(By.cssSelector("#divBidLocks > div:nth-child(1) > div > div")).getAttribute("class").contains("imagecheckbox-container-disabled"), "The Fee button should be locked");
		Assert.assertTrue(driver.findElement(By.cssSelector("#divBidLocks > div:nth-child(3) > div > div")).getAttribute("class").contains("imagecheckbox-container-disabled"), "The Date button should be locked");

		// Check I agree checkbox (currently a bug on QA)
		if (StoredVariables.getusernameEnvironment().get().equals("QA")) {
			perform.checkCheckbox(driver, SConfirmOrder.iAgreeToPayTheMercuryNetworkTransactionFee_chkbx(driver));
		} // end if
		
		// Click Finish
		perform.click(driver, SConfirmOrder.finishTop_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Confirm you are returned to the Review bids window
		perform.waitForIFrames(driver);
		perform.waitForiFrameSrcAndSwitchToIt(driver, "Bidding/Review.aspx", By.id(SReviewBids.appraiserTable_txt()));
		
		// Confirm the new vendor is listed
		perform.waitForElementToBeVisible(driver, SReviewBids.appraiserTable_txt(driver));
		table = SReviewBids.appraiserTable_txt(driver).getText();
		Assert.assertTrue(table.contains("Automation ResBidAppraiser1"), "Automation ResBidAppraiser1 is missing from the table");
		
		// Click Rank vendors
		perform.click(driver, SReviewBids.rankVendors_btn(driver));
		
		// Wait for Rank input
		String rankElement = "input[type='number']";
		perform.waitForElementToBeClickable(driver, rankElement, "cssSelector");
		
		// Verify there are only 2 Rank inputs
		List<WebElement> rank = driver.findElements(By.cssSelector(rankElement));
		Assert.assertTrue(rank.size()==2, "There should only be 2 Rank elements");
		
		// Confirm an entry box is displayed for the column Rank for eligible vendors (not for vendors who declined)
		row1 = driver.findElement(By.cssSelector("#"+SReviewBids.appraiserTable_txt()+" > tbody > tr:nth-child(1)"));
		WebElement row2 = driver.findElement(By.cssSelector("#"+SReviewBids.appraiserTable_txt()+" > tbody > tr:nth-child(2)"));
		WebElement row3 = driver.findElement(By.cssSelector("#"+SReviewBids.appraiserTable_txt()+" > tbody > tr:nth-child(3)"));
		
		// Row 1
		if (row1.getText().contains(userVendors)) {
			Assert.assertTrue(!row1.getAttribute("class").contains("IG_Row_Disabled"), "The class of the element should not contain Disabled");
		} else {
			Assert.assertTrue(row1.getAttribute("class").contains("IG_Row_Disabled"), "The class of the element should contain Disabled");
		}
		
		// Row 2
		if (row2.getText().contains(userVendors)) {
			Assert.assertTrue(!row2.getAttribute("class").contains("IG_Row_Disabled"), "The class of the element should not contain Disabled");
		} else {
			Assert.assertTrue(row2.getAttribute("class").contains("IG_Row_Disabled"), "The class of the element should contain Disabled");
		}
		
		// Row 3
		if (row3.getText().contains(userVendors)) {
			Assert.assertTrue(!row3.getAttribute("class").contains("IG_Row_Disabled"), "The class of the element should not contain Disabled");
		} else {
			Assert.assertTrue(row3.getAttribute("class").contains("IG_Row_Disabled"), "The class of the element should contain Disabled");
		}
		
		// Rank the vendors 2 or higher
		if (row1.getText().contains("Automation Appraiser1")) {
			perform.type(driver, rank.get(0), "3");
			perform.type(driver, rank.get(1), "2");
		} else {
			perform.type(driver, rank.get(0), "2");
			perform.type(driver, rank.get(1), "3");
		} // end rank vendors
		
		// Click Save
		perform.click(driver, SReviewBids.save_btn(driver));
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SReviewBids.ok_btn(), "id");
		
		// Confirm you receive the Ranking order message stating must start with 1
		String dialog = SReviewBids.dialog_txt(driver).getText();
		Assert.assertTrue(dialog.contains("You must start with 1"), "The dialog text should say 'You must start with 1'. Dialog = " + dialog);
		
		// Click OK
		perform.click(driver, SReviewBids.ok_btn(driver));
		
		// Wait for Rank element
		perform.waitForElementToBeClickable(driver, rankElement, "cssSelector");
		
		// Change the numbers to start with 1
		if (row1.getText().contains("Automation Appraiser1")) {
			rank.get(0).clear();
			perform.type(driver, rank.get(0), "1");
		} else {
			rank.get(1).clear();
			perform.type(driver, rank.get(1), "1");
		} // end rank vendors
		
		// Click Save
		perform.click(driver, SReviewBids.save_btn(driver));
		
		Thread.sleep(1000);
		
		// Wait for Change Bid Due button
		perform.waitForElementToBeClickable(driver, SReviewBids.changeBidDue_btn(), "cssSelector");
		
		// Confirm the rankings are saved and displayed
		WebElement rank1 = driver.findElement(By.cssSelector("#tblReview > tbody > tr:nth-child(1) > td:nth-child(2)"));
		WebElement rank2 = driver.findElement(By.cssSelector("#tblReview > tbody > tr:nth-child(3) > td:nth-child(2)"));
		if (row1.getText().contains("Automation Appraiser1")) {
			Assert.assertTrue(rank1.getText().equals("1"), "Appraiser1's rank should be 1");
			Assert.assertTrue(rank2.getText().equals("2"), "ResBidAppraiser1's rank should be 2");
		} else {
			Assert.assertTrue(rank2.getText().equals("1"), "Appraiser1's rank should be 1");
			Assert.assertTrue(rank1.getText().equals("2"), "ResBidAppraiser1's rank should be 2");
		} // end rank vendors
		
		// Click Change bid due
		perform.click(driver, SReviewBids.changeBidDue_btn(driver));
		
		// Change iFrame
		try {
			perform.waitForiFrameSrcAndSwitchToIt(driver, "ChangeDueDate.aspx", By.id(SChangeBidDueDate.comments_txtbx()));
		} catch (Exception e) {
			perform.waitForiFrameSrcAndSwitchToIt(driver, "ChangeDueDate.aspx", By.id(SChangeBidDueDate.comments_txtbx()));
		} // end try/catch
		
		// Wait for Comments textbox
		perform.waitForElementToBeClickable(driver, SChangeBidDueDate.comments_txtbx(), "id");
		
		// Confirm you can change the bid due date and include comments
		// Get the current Bid due date
		String originalDueDate = SChangeBidDueDate.bidDueDate_txtbx(driver).getAttribute("value");
		
		// Click the Calendar button
		perform.click(driver, SChangeBidDueDate.calendar_btn(driver));
		
		// Select 5 days in the future
		secure.selectDateFromCalendarChangeBidDueDate(driver, 5);
		
		// Add comments
		perform.type(driver, SChangeBidDueDate.comments_txtbx(driver), "Changed the Bid due date");
		
		// Get the new Bid due date
		String newDueDate = SChangeBidDueDate.bidDueDate_txtbx(driver).getAttribute("value");
		
		// Verify the due date changed
		Assert.assertTrue(!originalDueDate.equals(newDueDate), "The due date should have been updated. The originalDueDate = " + originalDueDate + " and the newDueDate = " + newDueDate);
		
		// Click Set date
		perform.click(driver, SChangeBidDueDate.setDate_btn(driver));
		
		// Get back into the Review bids iFrame
		driver.switchTo().defaultContent();
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		perform.waitForiFrameSrcAndSwitchToIt(driver, "Bidding/Review.aspx", By.id(SReviewBids.closeReviewBids_btn()));
		
		// Wait for busy
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for Close button
		perform.waitForElementToBeClickable(driver, SReviewBids.closeReviewBids_btn(driver));
		
		// Click Close
//		SReviewBids.closeReviewBids_btn(driver)
		perform.click(driver, SReviewBids.closeReviewBids_btn(driver));
		
		// Switch out of iFrame
		driver.switchTo().defaultContent();
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Get the audit trail text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Wait for history to update
		perform.waitForText(driver, SOrderDetails.history_txt(driver), "Changed the Bid due date");
		
		// Get the audit trail text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Confirm there is an audit trail event for the change in the bid due date
		Assert.assertTrue(history.contains("Bid Due Date Changed by Client (Automation ResBidding1)"), "Bid Due Date Changed by Client (Automation ResBidding1) should be displayed in the history. History = " + history);
		Assert.assertTrue(history.contains("Bid due date changed from"), "Bid due date changed from should be displayed in the history. History = " + history);
		Assert.assertTrue(history.contains("Changed the Bid due date"), "Changed the Bid due date should be displayed in the history. History = " + history);
		
		// Select a vendor in the Review bids list
		// Click Review bids
		perform.click(driver, SOrderDetails.reviewBids_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Switch into the Review bids iFrame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "Bidding/Review.aspx", By.xpath("//td[contains(text(), 'Automation Appraiser1')]"));
		
		// Select Automation Appraiser1
		perform.clickInTable_Contains(driver, "Automation Appraiser1");
		
		// Confirm Award bid, Decline bid, and Send message are now active
		Assert.assertTrue(SReviewBids.awardBid_btn(driver).isDisplayed(), "The Award Bid button should not be disabled");
		Assert.assertTrue(SReviewBids.declineBid_btn(driver).isDisplayed(), "The Decline Bid button should not be disabled");
		Assert.assertTrue(SReviewBids.sendMessage_btn(driver).isDisplayed(), "The Send Message button should not be disabled");
		
		// Click Send message
		perform.click(driver, SReviewBids.sendMessage_btn(driver));
		
		// Wait for Cancel button
		perform.waitForElementToBeClickable(driver, SReviewBids.cancelSendMessage_btn(), "id");
		
		// Confirm it shows the vendor(s) selected before Send message was clicked
		String to = SReviewBids.toSendMessage_txtbx(driver).getText();
		Assert.assertTrue(to.contains("Automation Appraiser1"), "The To textbox should contain Automation Appraiser1. To = " + to);
		
		// Confirm you can enter a message and Send to the selected vendor(s)
		perform.type(driver, SReviewBids.messageSendMessage_txtbx(driver), "This is a test message for Automation Appraiser1");
		
		// Click Send
		perform.click(driver, SReviewBids.sendSendMessage_btn(driver));
		
		// Get back into the Review bids iFrame
		driver.switchTo().defaultContent();
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		perform.waitForiFrameSrcAndSwitchToIt(driver, "Bidding/Review.aspx", By.id(SReviewBids.closeReviewBids_btn()));
		
		// Wait for Close button
		perform.waitForElementToBeClickable(driver, SReviewBids.closeReviewBids_btn(driver));
		
		// Click Close
		perform.click(driver, SReviewBids.closeReviewBids_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Get the audit trail text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Confirm the audit trail event shows the vendor(s) and the message sent
		Assert.assertTrue(history.contains("Message from Client (Automation ResBidding1) to Automation Appraiser1"), "The audit trail should show the vendor and the message");
		Assert.assertTrue(history.contains("This is a test message for Automation Appraiser1"), "The audit trail should contain This is a test message for Automation Appraiser1");
		
		// Click Review bids
		perform.click(driver, SOrderDetails.reviewBids_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Switch into the Review bids iFrame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "Bidding/Review.aspx",By.xpath("//td[contains(text(), 'Automation ResBidAppraiser1')]"));
		
		// From the Review bids dialog, select the vendor added (without a bid submitted)
		perform.clickInTable_Contains(driver, "Automation ResBidAppraiser1");
		
		// Click Decline bid
		perform.click(driver, SReviewBids.declineBid_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Switch into iFrame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "Decline.aspx", By.id(SDeclineBid.declineNote_txtbx()));
		
		// Wait for Decline note textbox
		perform.waitForElementToBeClickable(driver, SDeclineBid.declineNote_txtbx(), "id");
		
		// Confirm you can include a Decline Note
		perform.type(driver, SDeclineBid.declineNote_txtbx(driver), "These are decline notes");
		
		// Click Decline
		perform.click(driver, SDeclineBid.decline_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Switch to ResBidding iFrame
		driver.switchTo().defaultContent();
		perform.waitForiFrameSrcAndSwitchToIt(driver, "Bidding/Review.aspx", By.id(SReviewBids.closeReviewBids_btn()));
		
		// Wait for the Close button
		perform.waitForElementToBeClickable(driver, SReviewBids.closeReviewBids_btn(), "id");
		
		// Confirm the vendor shows as Bid Declined in the list
		status = driver.findElement(By.cssSelector("#tblReview > tbody > tr.ui-iggrid-activerow.ui-state-focus.IG_Row_Disabled > td:nth-child(8)")).getText();
		Assert.assertTrue(status.equals("Bid Declined"), "The Status should say Bid Declined. Status = " + status);
		
		// Get back into the Review bids iFrame
		driver.switchTo().defaultContent();
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		perform.waitForiFrameSrcAndSwitchToIt(driver, "Bidding/Review.aspx", By.id(SReviewBids.closeReviewBids_btn()));
		
		// Wait for Close button
		perform.waitForElementToBeClickable(driver, SReviewBids.closeReviewBids_btn(), "id");
		
		// Click Close
		perform.click(driver, SReviewBids.closeReviewBids_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Get the audit trail text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Confirm there is an audit trail event
		Assert.assertTrue(history.contains("Bid declined by Client (Automation ResBidding1) for Vendor (Automation ResBidAppraiser1)"), "The audit trail should contiain 'Bid declined by Client (Automation ResBidding1) for Vendor (Automation ResBidAppraiser1)'. History = " + history);
		Assert.assertTrue(history.contains("These are decline notes"), "The audit trail should contiain 'These are decline notes'. History = " + history);
		
		// Click Review bids
		perform.click(driver, SOrderDetails.reviewBids_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Switch into the Review bids iFrame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "Bidding/Review.aspx", By.xpath("//td[contains(text(), 'Automation Appraiser1')]"));
		
		// Select the vendor with a bid
		perform.clickInTable_Contains(driver, "Automation Appraiser1");
		
		// Click Award bid
		perform.click(driver, SReviewBids.awardBid_btn(driver));
		
		// Switch to iFrame
		driver.switchTo().defaultContent();
		perform.waitForiFrameSrcAndSwitchToIt(driver, "Bidding/Award.aspx", By.id(SAwardBid.awardNote_txtbx()));
		
		// Wait for Award note textbox
		perform.waitForElementToBeClickable(driver, SAwardBid.awardNote_txtbx(), "id");
		
		// Confirm you can include an Award note
		perform.type(driver, SAwardBid.awardNote_txtbx(driver), "These are award notes");
		
		// Confirm the Order fee is displayed and cannot be changed
		Assert.assertTrue(SAwardBid.orderFee_txt(driver).getText().equals("$500"), "Thte order fee should be $500");
		
		// Confirm you can change the payment method
		perform.selectDropdownOption(driver, SAwardBid.paymentMethod_dropdown(driver), "PayPal");
		
		// Confirm you can click Award
		perform.click(driver, SAwardBid.award_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Switch out of iFrames
		driver.switchTo().defaultContent();
		
		// Wait for Close button
		perform.waitForElementToBeClickable(driver, SOrderDetails.close_btn(), "id");
		
		// Click Close on the attach document window
		perform.click(driver, SOrderDetails.close_btn(driver));
		
		// Wait for history text to update
		perform.waitForText(driver, SOrderDetails.history_txt(driver), "History (In Progress)");
		
		// Get the history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Confirm there is an audit trail event showing the bid awarded including the fee and date
		Assert.assertTrue(history.contains("Bid Awarded by Client (Automation ResBidding1) to Appraiser (Automation Appraiser1)"), "The history should contain 'Bid Awarded by Client (Automation ResBidding1) to Appraiser (Automation Appraiser1)'. History = " + history);
		Assert.assertTrue(history.contains("Amount: $500.00; Order due date set to:"), "The history should contain 'Amount: $500.00; Order due date set to:'. History = " + history);
		Assert.assertTrue(history.contains("These are award notes"), "The history should contain 'These are award notes'. History = " + history);
		
		// Confirm the order is automatically accepted by the vendor and there is an audit trail event
		Assert.assertTrue(history.contains("Order accepted by Appraiser (Automation Appraiser1) and In Progress"), "The history should contain 'Order accepted by Appraiser (Automation Appraiser1) and In Progress'. History = " + history);
		Assert.assertTrue(history.contains("Order automatically accepted"), "The history should contain 'Order automatically accepted'. History = " + history);
		
		// Log test
		test.log(LogStatus.INFO, "Residential Bidding", "Verified Residential Bidding with the Fee and Date locked");
		
	} // end VMPXSiteFeeWithVMPComment
	
} // end the AutomaticAssignmentSettings class
