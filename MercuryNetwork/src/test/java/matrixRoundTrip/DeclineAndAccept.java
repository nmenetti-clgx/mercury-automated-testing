package matrixRoundTrip;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjects.Secure.SConfirmOrder;
import pageObjects.Secure.SNewOrder;
import pageObjects.Secure.SOrderDetails;
import pageObjects.Secure.SOrders;
import pageObjects.Secure.SUsers;
import pageObjects.Secure.SVendorSelectionSettings;
import pageObjects.Vendors.VOrderAcknowledgement;
import pageObjects.Vendors.VOrderDetails;
import pageObjects.Vendors.VOrders;
import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

import org.testng.annotations.*;

// TODO: Auto-generated Javadoc
/**
 * <h1>Round Trip - Decline and Accept</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class DeclineAndAccept extends TestSetup {
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Sign in to Secure</li>
	 * 	<li>Select Vendor Selection Settings</li>
	 * 	<li>Turn on Double-blind Communication switch</li>
	 * 	<li>Verify Canned Comment Override switch is off</li>
	 * 	<li>Select Custom Fee Panel</li>
	 * 	<li>Uncheck Use Mercury Network Directory as backup checkbox</li>
	 * 	<li>Verify Mercury Network Directory as backup is unchecked</li>
	 * 	<li>Save Preferences</li>
	 * 	<li>Click OK in saved dialog box</li>
	 * 	<li>Clear order information variables before placing a new order</li>
	 * 	<li>Go to the Orders page</li>
	 * 	<li>Go to Residential Appraisal</li>
	 * 	<li>Create another order</li>
	 * 	<li>Set Property Information data</li>
	 * 	<li>StoredVariables.getpropertyInformationStateAbbr().set("OK");  Must set for a field check later on</li>
	 * 	<li>Set Assignment Information data</li>
	 * 	<li>Set Lender Information data</li>
	 * 	<li>Set Contact And Access Information data</li>
	 * 	<li>Set Additional Notification Recipients data</li>
	 * 	<li>Enter New Order data</li>
	 * 	<li>Click Next</li>
	 * 	<li>Check the agree to notes checkbox</li>
	 * 	<li>Change payment method to check</li>
	 * 	<li>Save new order (click Next)</li>
	 * 	<li>Select document type</li>
	 * 	<li>Upload Document</li>
	 * 	<li>Click Place Another Order</li>
	 * 	<li>Get outside frames</li>
	 * 	<li>Verify you are on the New Order screen</li>
	 * 	<li>Get order number</li>
	 * 	<li>Get Vendor assigned to the order</li>
	 * 	<li>Get Vendor Email Address</li>
	 * 	<li>Login to Vendors site</li>
	 * 	<li>Find order</li>
	 * 	<li>Click on the order from the orders grid</li>
	 * 	<li>Click on the Accept/Decline button</li>
	 * 	<li>Allow popup time to load</li>
	 * 	<li>Select Propose Conditions to Client from Select Action dropdown</li>
	 * 	<li>Set 40 second while loop timeout</li>
	 * 	<li>Allow checkbox options to update</li>
	 * 	<li>Check Complexity of job requires extra charge</li>
	 * 	<li>Click OK</li>
	 * 	<li>Verify alert text</li>
	 * 	<li>Click alert ok button</li>
	 * 	<li>Get random fee amount greater than current fee and pass the fee amount to StorecVariables</li>
	 * 	<li>Change fee amount</li>
	 * 	<li>Get the due date</li>
	 * 	<li>Parse the due date into long and short format</li>
	 * 	<li>Click OK</li>
	 * 	<li>Close Order Acknowledgement dialog</li>
	 * 	<li>log in to secure site</li>
	 * 	<li>Find order</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify the tracking number</li>
	 * 	<li>Verify the fee amount</li>
	 * 	<li>Verify the order due date</li>
	 * 	<li>Verify conditionally cancelled is in the history</li>
	 * 	<li>Verify proposed fee is in the history</li>
	 * 	<li>Verify reason for request is in the history</li>
	 * 	<li>Verify order info</li>
	 * 	<li>Select the Do Not Agree radio button</li>
	 * 	<li>Click OK</li>
	 * 	<li>Verify popup says you have to change either fee or date</li>
	 * 	<li>Click Error OK</li>
	 * 	<li>Click the calendar button</li>
	 * 	<li>Select a new date</li>
	 * 	<li>Verify the correct order due date is correct</li>
	 * 	<li>click OK</li>
	 * 	<li>Find order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Verify the status of the order is Awaiting Acceptance</li>
	 * 	<li>Verify the counter offer shows in the history</li>
	 * 	<li>Login to Vendors site</li>
	 * 	<li>Find order</li>
	 * 	<li>Click on the order from the orders grid</li>
	 * 	<li>Click on the Accept/Decline button</li>
	 * 	<li>Allow popup time to load</li>
	 * 	<li>Select Propose Conditions to Client from Select Action dropdown</li>
	 * 	<li>Set 40 second while loop timeout</li>
	 * 	<li>Allow checkbox options to update</li>
	 * 	<li>Check the Current workload requires extra time checkbox</li>
	 * 	<li>Click the calendar button</li>
	 * 	<li>Select New Date from Calendar</li>
	 * 	<li>Set and pass the Due Date to StorecVariables</li>
	 * 	<li>Store New Order Date</li>
	 * 	<li>Click OK</li>
	 * 	<li>Close Order Acknowledgement dialog</li>
	 * 	<li>log in to secure site</li>
	 * 	<li>Find order</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify the tracking number</li>
	 * 	<li>Verify the fee amount</li>
	 * 	<li>Verify the order due date</li>
	 * 	<li>Verify conditionally cancelled is in the history</li>
	 * 	<li>Verify proposed fee is in the history</li>
	 * 	<li>Verify reason for request is in the history</li>
	 * 	<li>Select the Reassign to a different vendor radio button</li>
	 * 	<li>Click OK</li>
	 * 	<li>Click finish</li>
	 * 	<li>Verify popup displays with correct text</li>
	 * 	<li>Click ok on the popup</li>
	 * 	<li>Agree to vendor fee notes</li>
	 * 	<li>Click Finish</li>
	 * 	<li>Get Vendor Email Address</li>
	 * 	<li>Login to Vendors site</li>
	 * 	<li>Find order</li>
	 * 	<li>Click on the order from the orders grid</li>
	 * 	<li>Click on the Accept/Decline button</li>
	 * 	<li>Allow popup time to load</li>
	 * 	<li>Select Propose Conditions to Client from Select Action dropdown</li>
	 * 	<li>Set 40 second while loop timeout</li>
	 * 	<li>Allow checkbox options to update</li>
	 * 	<li>Check Complexity of job requires extra charge</li>
	 * 	<li>Click OK</li>
	 * 	<li>Verify alert text</li>
	 * 	<li>Click alert ok button</li>
	 * 	<li>Get random fee amount greater than current fee and pass the fee amount to StorecVariables</li>
	 * 	<li>Change fee amount</li>
	 * 	<li>Get the due date</li>
	 * 	<li>Parse the due date into long and short format</li>
	 * 	<li>Click OK</li>
	 * 	<li>Close Order Acknowledgement dialog</li>
	 * 	<li>log in to secure site</li>
	 * 	<li>Search for the order</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify the tracking number</li>
	 * 	<li>Verify the fee amount</li>
	 * 	<li>Verify the order due date</li>
	 * 	<li>Verify conditionally cancelled is in the history</li>
	 * 	<li>Verify proposed fee is in the history</li>
	 * 	<li>Verify reason for request is in the history</li>
	 * 	<li>Verify fee amount is in the agree text</li>
	 * 	<li>Verify the correct due date is in the agree text</li>
	 * 	<li>Click the agree radio button</li>
	 * 	<li>Click OK</li>
	 * 	<li>Search for the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Verify the status of the order is In Progress</li>
	 * 	<li>Verify the order accepted shows in the history</li>
	 * 	<li>Verify the order accepted shows in the history</li>
	 * 	<li>Click on Users</li>
	 * 	<li>Uncheck Compliance</li>
	 * 	<li>Click Save</li>
	 * 	<li>Click Orders</li>
	 * 	<li>Find order</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify the tracking number</li>
	 * 	<li>Verify the status of the order is In Progress</li>
	 * 	<li>Verify the order accepted shows in the history</li>
	 * 	<li>Verify the order accepted shows in the history</li>
	 * 	<li>Verify order info</li>
	 * 	<li>Click Set status button</li>
	 * 	<li>Click Place On Hold</li>
	 * 	<li>Check Borrower requests to place everything on hold checkbox</li>
	 * 	<li>Click OK</li>
	 * 	<li>Verify order status is On Hold</li>
	 * 	<li>Verify history contains On Hold by Client</li>
	 * 	<li>Click Set Status</li>
	 * 	<li>Click Resume</li>
	 * 	<li>Click the calendar button</li>
	 * 	<li>Select date</li>
	 * 	<li>Verify correct date was selected</li>
	 * 	<li>Check Borrower ready to continue checkbox</li>
	 * 	<li>Click OK</li>
	 * 	<li>Verify order status is In Progress</li>
	 * 	<li>Verify history contains Resumed by Client</li>
	 * 	<li>Click the Message button</li>
	 * 	<li>Check 1004MC is not required for this job checkbox</li>
	 * 	<li>CLick the OK button</li>
	 * 	<li>Verify Message from *************** is displayed in History</li>
	 * 	<li>Click Set Status</li>
	 * 	<li>Click Cancel</li>
	 * 	<li>Click Cancel</li>
	 * 	<li>Verify order status is In Progress</li>
	 * 	<li>Get Vendor Email Address</li>
	 * 	<li>Login to Vendors site</li>
	 * 	<li>Find order</li>
	 * 	<li>Click on the order from the orders grid</li>
	 * 	<li>Verify the tracking number</li>
	 * 	<li>Verify the status of the order is In Progress</li>
	 * 	<li>Verify order info</li>
	 * 	<li>Click Set Order Status</li>
	 * 	<li>Click Delayed</li>
	 * 	<li>Check Changed original appointment due to homeowner conflicts</li>
	 * 	<li>Click OK</li>
	 * 	<li>Verify status is History (Delayed)</li>
	 * 	<li>Verify Delayed by Appraiser is displayed in the History</li>
	 * 	<li>Verify Changed original appointment due to homeowner conflicts is displayed in the history</li>
	 * 	<li>Click Set Order Status</li>
	 * 	<li>Click Resume</li>
	 * 	<li>Click Received the OK to proceed from agent</li>
	 * 	<li>Click OK</li>
	 * 	<li>Verify status is History (In Progress)</li>
	 * 	<li>Verify Resumed by Appraiser is displayed in the History</li>
	 * 	<li>Received the OK to proceed from agent</li>
	 * 	<li>Click the Message button</li>
	 * 	<li>Check Actual depreciation for the Subject is justifiable given the market area</li>
	 * 	<li>CLick the Send button</li>
	 * 	<li>Verify status is History (In Progress)</li>
	 * 	<li>Verify Message from Appraiser is displayed in the History</li>
	 * 	<li>Verify Actual depreciation for the Subject is justifiable given the market area. is displayed in the History</li>
	 * 	<li>Click Set Order Status</li>
	 * 	<li>Click Cancel</li>
	 * 	<li>Click Cancel</li>
	 * 	<li>Verify status is History (In Progress)</li>
	 * 	<li>Verify Message from Appraiser is displayed in the History</li>
	 * 	<li>Verify Actual depreciation for the Subject is justifiable given the market area. is displayed in the History</li>
	 * 	<li>log in to secure site</li>
	 * 	<li>Find order</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify the tracking number</li>
	 * 	<li>Verify the notes in the audit trail reflect the activity of the order without names</li>
	 * 	<li>Verify order info</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Vendor Selection Settings", "Secure - Create Order", "Vendors - Orders", "Vendors - Propose Conditions To Client", "Secure - Orders", "Secure - Do Not Agree", "Secure - Require Reassignment", "Secure - Place On Hold", 
			"Secure - Resume", "Secure - Message", "Secure - Cancel", "Secure - Set Status", "Vendors - Delayed", "Vendors - Received The OK To Proceed From Agent", "Vendors - Message"}, alwaysRun=true)
	public void vendorSelectionSettings() throws Exception {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		if (StoredVariables.getbrowser().get().equals("PhantomJS"))
		{
			String callersClass = new Exception().getStackTrace()[0].getClassName();
			test.log(LogStatus.SKIP, "The " + callersClass + " class was skipped becuase the " + StoredVariables.getbrowser().get() + " browser can not see the Accpet/Decline button");
			throw new SkipException("The " + callersClass + " class was skipped becuase the " + StoredVariables.getbrowser().get() + " browser can not see the Accpet/Decline button");
		}
		
		// Sign in to Secure
		secure.login(driver, "Lender2", StoredVariables.getpassword().get());
		
		// Select Vendor Selection Settings
		secure.goToVendorSelectionSettings(driver);
		
		// Turn on Double-blind Communication switch
		if (SVendorSelectionSettings.doubleBlind_switch(driver).getAttribute("src").contains("switchOff.png"))
		{
			perform.click(driver,SVendorSelectionSettings.doubleBlind_switch(driver));
		}
		
		// Verify Canned Comment Override switch is off
		if (SVendorSelectionSettings.cannedCommentOverride_switch(driver).getAttribute("src").contains("switchOn.png"))
		{
			perform.click(driver,SVendorSelectionSettings.cannedCommentOverride_switch(driver));
		}
		
		// Select Custom Fee Panel
		perform.click(driver,SVendorSelectionSettings.customFeePanel_radio(driver));
		
		// Uncheck Use Mercury Network Directory as backup checkbox
		if (SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver).isSelected())
		{
			perform.click(driver,SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver));
		}
		
		// Verify Mercury Network Directory as backup is unchecked
		Assert.assertTrue(SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver).isSelected()==false, "Mercury Network Directory as backup is still checked");
		
		// Save Preferences
		perform.click(driver,SVendorSelectionSettings.save_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for the OK button
		perform.waitForElementToBeClickable(driver, SVendorSelectionSettings.ok_btn(), "id");
		
		// Click OK in saved dialog box
		perform.click(driver,SVendorSelectionSettings.ok_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);

		// Clear order information variables before placing a new order
		perform.clearOrderInfoStoredVariables(driver);
		
		// Go to the Orders page
		perform.clickInTable_Contains(driver, "Orders");
		
		if (StoredVariables.getbrowser().get().equals("Chrome"))
		{
			Thread.sleep(500);	
		}
		
		// Go to Residential Appraisal
		secure.goToResidentialAppraisal(driver);
		
		// Create another order
		/***************************************
		 * Set New Order Information
		 ***************************************/
		
		// Set Property Information data
		StoredVariables.getpropertyInformationAddress().set("2621 SW 136th St");
		StoredVariables.getpropertyInformationCity().set("Oklahoma City");
		StoredVariables.getpropertyInformationState().set("Oklahoma");
		StoredVariables.getpropertyInformationStateAbbr().set("OK"); // Must set for a field check later on
		StoredVariables.getpropertyInformationZip().set("73170");
		StoredVariables.getpropertyInformationSqFt().set("2,017");
		StoredVariables.getpropertyInformationSiteSize().set("9583 sq ft");
		StoredVariables.getpropertyInformationPropType().set("Single Family");
		StoredVariables.getpropertyInformationPropRights().set("Fee Simple");
		StoredVariables.getpropertyInformationLegalDesc().set("717 Vickery Ave, Yukon, OK 73099");
		StoredVariables.getpropertyInformationDirections().set("Mustang Rd and NW 10th St.");
		
		// Set Assignment Information data
		StoredVariables.getassignmentInformationForm().set("Uniform Residential Appraisal (FNMA 1004)");
		StoredVariables.getassignmentInformationRushOrder().set(true);
		StoredVariables.getassignmentInformationComplex().set(true);
		StoredVariables.getassignmentInformationOrderDue().set(7);
		perform.getNewDate(driver, StoredVariables.getassignmentInformationOrderDue().get());
		StoredVariables.getassignmentInformationOtherRefNumber().set("9856321");
		StoredVariables.getassignmentInformationLoanType().set("All In One");
		StoredVariables.getassignmentInformationLoanPurpose().set("Purchase");
		StoredVariables.getassignmentInformationOrderedBy().set("Test User");
		StoredVariables.getassignmentInformationOrderGroup().set("AppraisersGroupTest");
		StoredVariables.getassignmentInformationLoanNumber().set("84131");
		StoredVariables.getassignmentInformationFileNumber().set("56413");
		StoredVariables.getassignmentInformationSalesPrice().set("188,000");
		StoredVariables.getassignmentInformationFHACaseNumber().set("6413");
		StoredVariables.getassignmentInformationDisclosure().set(0);
		StoredVariables.getassignmentInformationAssignedTo().set("Automation Lender2");
		
		// Set Lender Information data
		StoredVariables.getlenderInformationLenderName().set("US Bank");
		StoredVariables.getlenderInformationAddress1().set("123 Test St");
		StoredVariables.getlenderInformationAddress2().set("Suite D");
		StoredVariables.getlenderInformationCity().set("Mustang");
		StoredVariables.getlenderInformationState().set("OK");
		StoredVariables.getlenderInformationZip().set("73064");
		
		// Set Contact And Access Information data
		StoredVariables.getcontactOccupancy().set("Owner");
		StoredVariables.getcontactBorrower().set("Test User");
		StoredVariables.getcontactBorrowerInfo1Dropdown().set("Home");
		StoredVariables.getcontactBorrowerInfo1().set("405-555-1111");
		StoredVariables.getcontactBorrowerInfo2Dropdown().set("E-mail");
		StoredVariables.getcontactBorrowerInfo2().set("test@dntest.net");
		StoredVariables.getcontactBorrowerAddress().set("684 Test St.");
		StoredVariables.getcontactBorrowerCity().set("Edmond");
		StoredVariables.getcontactBorrowerState().set("OK");
		StoredVariables.getcontactBorrowerZip().set("73034");
		StoredVariables.getcontactCoBorrower().set("Coborrower Name");
		StoredVariables.getcontactCoBorrowerInfo1Dropdown().set("Work");
		StoredVariables.getcontactCoBorrowerInfo1().set("405-555-9813");
		StoredVariables.getcontactCoBorrowerInfo2Dropdown().set("Mobile");
		StoredVariables.getcontactCoBorrowerInfo2().set("405-555-1679");
		StoredVariables.getcontactCoBorrowerAddress().set("1509 Rain Tree Dr");
		StoredVariables.getcontactCoBorrowerCity().set("Moore");
		StoredVariables.getcontactCoBorrowerState().set("OK");
		StoredVariables.getcontactCoBorrowerZip().set("73160");
		StoredVariables.getcontactOwner().set("Owner Name");
		StoredVariables.getcontactOwnerInfo1Dropdown().set("Pager");
		StoredVariables.getcontactOwnerInfo1().set("405-555-8618");
		StoredVariables.getcontactOwnerInfo2Dropdown().set("Fax");
		StoredVariables.getcontactOwnerInfo2().set("405-555-7410");
		StoredVariables.getcontactOccupant().set("Occupant Name");
		StoredVariables.getcontactOccupantInfo1Dropdown().set("Home");
		StoredVariables.getcontactOccupantInfo1().set("405-555-3549");
		StoredVariables.getcontactOccupantInfo2Dropdown().set("Mobile");
		StoredVariables.getcontactOccupantInfo2().set("405-555-8895");
		StoredVariables.getcontactAgent().set("Agent Name");
		StoredVariables.getcontactAgentInfo1Dropdown().set("E-mail");
		StoredVariables.getcontactAgentInfo1().set("agent@dntest.net");
		StoredVariables.getcontactAgentInfo2Dropdown().set("Pager");
		StoredVariables.getcontactAgentInfo2().set("405-555-4893");
		StoredVariables.getcontactOther().set("Other Name");
		StoredVariables.getcontactOtherInfo1Dropdown().set("Work");
		StoredVariables.getcontactOtherInfo1().set("405-555-7825");
		StoredVariables.getcontactOtherInfo2Dropdown().set("Fax");
		StoredVariables.getcontactOtherInfo2().set("405-555-8688");
		StoredVariables.getcontactApptContact().set("Borrower");
		
		// Set Additional Notification Recipients data
		StoredVariables.getadditionalNotificationRecipientsAdditionalEmails().set("additionalEmail1@dntest.net; additionalEmail2@dntest.net");
		StoredVariables.getadditionalNotificationRecipientsAttachCompletedReport().set(true);
		
		// Enter New Order data
		secure.enterNewResidentialAppraisalOrder(driver);
		
		// Click Next
		perform.click(driver,SNewOrder.next_btn(driver));
		
		/***********************************************
		 * Confirm Order Page
		 ***********************************************/
		
		// Wait for the back button
		perform.waitForElementToBeClickable(driver, SConfirmOrder.backTop_btn(), "id");
		
		// Check the agree to notes checkbox
		if (!SConfirmOrder.readVendorsFeeNotes_chkbx(driver).isSelected())
		{
			perform.click(driver,SConfirmOrder.readVendorsFeeNotes_chkbx(driver));
		}
		
		// Change payment method to check
		perform.selectDropdownOption(driver, SConfirmOrder.paymentMethod_dropdown(driver), "Check");
		
		// Save new order (click Next)
		secure.saveNewOrder(driver);
		
		// Select document type
		perform.selectDropdownOption(driver, SConfirmOrder.documentType_dropdown(driver), "Other");
		
		if (!StoredVariables.getbrowser().get().equals("Chrome"))
		{
			// Upload Document
			perform.type(driver,SConfirmOrder.uploadDocuments_btn(driver), "X:\\QA\\Web\\Test Files\\_Test Files\\Test PDF.pdf");			
		}
		
		// Click Place Another Order
		perform.click(driver,SConfirmOrder.placeAnotherOrder_lnk(driver));
		
		// Get outside frames
		driver.switchTo().defaultContent();
		
		// Wait for the Address field
		perform.waitForElementToBeClickable(driver, SNewOrder.address_txtbx(), "id");
		
		// Verify you are on the New Order screen
		Assert.assertTrue(driver.getCurrentUrl().contains("NewOrder"), "Clicking the Place another order link did not take you back to the New Order page");
		
		// Get order number
		db.getLoanID(driver);
		
		// Get Vendor assigned to the order
		db.getVendorIDForOrder(driver);

		// Get Vendor Email Address
		db.getVendorEmail(driver);

		// Login to Vendors site
		vendors.login(driver, StoredVariables.getvendorEmail().get(), StoredVariables.getpassword().get());
		
		// Wait for page to load
		perform.waitForElementToBeClickable(driver, VOrders.orders_btn(), "cssSelector");
		
		// Find order
		vendors.findOrder(driver, StoredVariables.getborrowerIdentifier().get(), "Borrower");
		
		// Click on the order from the orders grid
		perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());
		
		if (StoredVariables.getbrowser().get().equals("Chrome"))
		{
			Thread.sleep(1000);
		}
		
		// Wait for Accept/Decline button
		perform.waitForElementToBeClickable(driver, VOrderDetails.acceptDecline_btn(), "cssSelector");
		
		Thread.sleep(1000);
		
		// Click on the Accept/Decline button
		perform.click(driver,VOrderDetails.acceptDecline_btn(driver));

		// Allow popup time to load
		Thread.sleep(1500);
		
		// Wait for Select Action dropdown
		perform.waitForElementToBeClickable(driver, VOrderAcknowledgement.selectAction_dropdown(), "id");

		// Select Propose Conditions to Client from Select Action dropdown
		perform.selectDropdownOption(driver, VOrderAcknowledgement.selectAction_dropdown(driver), "Propose Conditions to Client");
		
		// Wait for check boxes to load
		String conditionalDeclineOptions = VOrderAcknowledgement.conditionalDeclineOptions(driver).getAttribute("style");
		// Set 40 second while loop timeout
		long start_time = System.currentTimeMillis();
		long wait_time = 40000;
		long end_time = start_time + wait_time;
		while (System.currentTimeMillis() < end_time && conditionalDeclineOptions.contains("none")){
			conditionalDeclineOptions = VOrderAcknowledgement.conditionalDeclineOptions(driver).getAttribute("style");
		}
		
		// Allow checkbox options to update
		Thread.sleep(2500);
		
		// Check Complexity of job requires extra charge
		List<WebElement> els = driver.findElements(By.cssSelector(VOrderAcknowledgement.extraCharge_chkbx()));
		for(WebElement el : els) 
		{
		  if(el.isDisplayed() && el.isEnabled())
		  {
			  ((JavascriptExecutor) driver).executeScript("arguments[0].click();",el);
		  }
		}
		
		// Click OK
		perform.click(driver,VOrderAcknowledgement.ok_btn(driver));
		
		// Wait for the Alert OK button
		perform.waitForElementToBeClickable(driver, VOrderAcknowledgement.alertOk_btn(), "cssSelector");
		
		// Verify alert text
		Assert.assertTrue(VOrderAcknowledgement.alert_txt(driver).getText().contains("You must either propose a new fee or due date."), "Alert dialog box did not display properly");
		
		// Click alert ok button
		perform.click(driver,VOrderAcknowledgement.alertOk_btn(driver));
		
		// Get random fee amount greater than current fee and pass the fee amount to StorecVariables
		int fee = Integer.parseInt(VOrderAcknowledgement.fee_txtbx(driver).getAttribute("value"));
		Random rand = new Random();
		int randomFeeAmount = fee + rand.nextInt((999 - fee) + 1);
		StoredVariables.getfeeAmount().set(Integer.toString(randomFeeAmount));
		
		// Change fee amount
		VOrderAcknowledgement.fee_txtbx(driver).clear();
		perform.type(driver,VOrderAcknowledgement.fee_txtbx(driver), StoredVariables.getfeeAmount().get());
		
		// Get the due date
		StoredVariables.getorderDueDate().set(VOrderAcknowledgement.dueDate_txtbx(driver).getAttribute("value"));
		
		// Parse the due date into long and short format
		Date date = new SimpleDateFormat("M/d/yyyy").parse(StoredVariables.getorderDueDate().get());
		StoredVariables.getorderDueDateShort().set(new SimpleDateFormat("M/d/yyyy").format(date));
		StoredVariables.getorderDueDateLong().set(new SimpleDateFormat("MM/dd/yyyy").format(date));
		
		// Click OK
		perform.click(driver,VOrderAcknowledgement.ok_btn(driver));
		
		// Close Order Acknowledgement dialog
		vendors.closeOrderAcknowledgementDialog(driver);
		
		// log in to secure site
		secure.login(driver, "Lender2", StoredVariables.getpassword().get());
		
		// Find order
		secure.findOrder(driver, StoredVariables.getloanID().get(), "Tracking number");
		
		// Open order
		perform.doubleClickInTable(driver, "MERC-" + StoredVariables.getloanID().get());
		
		// Wait for the ok button to be clickable
		perform.waitForElementToBeClickable(driver, SOrderDetails.ok_btn(), "id");
		
		// Verify the tracking number
		Assert.assertTrue(SOrderDetails.trackingNumber_txt(driver).getText().contains(StoredVariables.getloanID().get()), "The tracking number did not populate properly");
		
		// Verify the fee amount
		Assert.assertTrue(SOrderDetails.fee_txtbx(driver).getAttribute("value").contains(StoredVariables.getfeeAmount().get()), "The Fee Amount did not populate correctly");
		
		// Verify the order due date
		Assert.assertTrue(SOrderDetails.dueDate_txtbx(driver).getAttribute("value").contains(StoredVariables.getorderDueDateShort().get()), "The Due Date " + StoredVariables.getorderDueDateShort().get() + " did not populate correctly");
		
		// Verify conditionally cancelled is in the history
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("Conditionally declined by Appraiser"), "The history is not displaying conditionally declined");
		
		// Verify proposed fee is in the history
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("Proposed Fee: $"+StoredVariables.getfeeAmount().get()), "The fee amount is not displaying conditionally declined");
		
		// Verify reason for request is in the history
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("Reason for request: Complexity of job requires extra charge."), "The reason for request is not displaying correctly - " + SOrderDetails.history_txt(driver).getText());
		
		// Verify order info
		secure.verifyResidentialAppraisalOrderDetails(driver);
		
		// Select the Do Not Agree radio button
		perform.click(driver,SOrderDetails.doNotAgree_radioBtn(driver));
		
		// Click OK
		perform.click(driver,SOrderDetails.ok_btn(driver));
		
		// Wait for error text
		perform.waitForElementToBeVisible(driver, SOrderDetails.error_txt(), "id");
		
		// Verify popup says you have to change either fee or date
		Assert.assertTrue(SOrderDetails.error_txt(driver).getText().equals("You must change either the fee or the due date."), "The Error popup did not populate correctly");
		
		// Click Error OK
		perform.click(driver,SOrderDetails.errorOk_btn(driver));
		
		// Click the calendar button
		perform.click(driver,SOrderDetails.calendar_btn(driver));
		
		// Select a new date
		secure.selectDateFromCalendar(driver, 14);
		
		// Verify the correct order due date is correct
		Assert.assertTrue(SOrderDetails.dueDate_txtbx(driver).getAttribute("value").equals(StoredVariables.getcalendarDateLong().get()), "Date selected from calendar is the wrong date. Selected - " + SOrderDetails.dueDate_txtbx(driver).getAttribute("value") + " and should be - " + StoredVariables.getorderDueDateLong().get());
		
		// click OK
		perform.click(driver,SOrderDetails.ok_btn(driver));
		
		if (StoredVariables.getbrowser().get().equals("Chrome"))
		{
			Thread.sleep(2000);
		}
		
		// Wait for the do not agree radio button to be clickable
		perform.waitForElementToBeClickable(driver, SOrders.orders_btn(), "cssSelector");
		
		// Find order
		secure.findOrder(driver, StoredVariables.getloanID().get(), "Tracking number");
		
		// Open the order
		perform.doubleClickInTable(driver, "MERC-" + StoredVariables.getloanID().get());
		
		// Wait for history text
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Verify the status of the order is Awaiting Acceptance
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("History (Awaiting acceptance)"), "The order is not in the Awaiting Acceptance status");
						
		// Verify the counter offer shows in the history
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("Proposed Vendor Due Date: " + StoredVariables.getcalendarDateLong().get()), "Proposed Vendor Due Date does not show in the history");

		// Login to Vendors site
		vendors.login(driver, StoredVariables.getvendorEmail().get(), StoredVariables.getpassword().get());
		
		// Wait for page to load
		perform.waitForElementToBeClickable(driver, VOrders.orders_btn(), "cssSelector");
		
		// Find order
		vendors.findOrder(driver, StoredVariables.getborrowerIdentifier().get(), "Borrower");
		
		// Click on the order from the orders grid
		perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());
		
		if (StoredVariables.getbrowser().get().equals("Chrome"))
		{
			Thread.sleep(1000);
		}
		
		// Wait for Accept/Decline button
		perform.waitForElementToBeClickable(driver, VOrderDetails.acceptDecline_btn(), "cssSelector");
		
		Thread.sleep(1000);
		
		// Click on the Accept/Decline button
		perform.click(driver,VOrderDetails.acceptDecline_btn(driver));

		// Allow popup time to load
		Thread.sleep(1500);
		
		// Wait for Select Action dropdown
		perform.waitForElementToBeClickable(driver, VOrderAcknowledgement.selectAction_dropdown(), "id");

		// Select Propose Conditions to Client from Select Action dropdown
		perform.selectDropdownOption(driver, VOrderAcknowledgement.selectAction_dropdown(driver), "Propose Conditions to Client");
		
		// Wait for check boxes to load
		conditionalDeclineOptions = VOrderAcknowledgement.conditionalDeclineOptions(driver).getAttribute("style");
		// Set 40 second while loop timeout
		start_time = System.currentTimeMillis();
		wait_time = 40000;
		end_time = start_time + wait_time;
		while (System.currentTimeMillis() < end_time && conditionalDeclineOptions.contains("none")){
			conditionalDeclineOptions = VOrderAcknowledgement.conditionalDeclineOptions(driver).getAttribute("style");
		}
		
		// Allow checkbox options to update
		Thread.sleep(2500);
		
		// Check the Current workload requires extra time checkbox
		els = driver.findElements(By.cssSelector(VOrderAcknowledgement.extraTime_chkbx()));
		for(WebElement el : els) 
		{
		  if(el.isDisplayed() && el.isEnabled())
		  {
			  ((JavascriptExecutor) driver).executeScript("arguments[0].click();",el);
		  }
		}
		
		// Click the calendar button
		perform.click(driver,VOrderAcknowledgement.calendar_btn(driver));
		
		// Select New Date from Calendar
		secure.selectDateFromCalendar(driver, 20);
		
		// Set and pass the Due Date to StorecVariables
		String orderDueDate = VOrderAcknowledgement.dueDate_txtbx(driver).getAttribute("value");
		
		// Store New Order Date
		perform.storeNewOrderDate(driver, orderDueDate);
		
		// Click OK
		perform.click(driver,VOrderAcknowledgement.ok_btn(driver));
		
		// Close Order Acknowledgement dialog
		vendors.closeOrderAcknowledgementDialog(driver);

		// log in to secure site
		secure.login(driver, "Lender2", StoredVariables.getpassword().get());
		
		// Wait for the search text box to be clickable
		perform.waitForElementToBeClickable(driver, VOrders.find_txtbx(), "id");
		
		// Find order
		secure.findOrder(driver, StoredVariables.getloanID().get(), "Tracking number");
		
		// Open order
		perform.doubleClickInTable(driver, "MERC-" + StoredVariables.getloanID().get());
		
		if (StoredVariables.getbrowser().get().equals("Chrome"))
		{
			Thread.sleep(1000);
		}
		
		// Wait for the ok button to be clickable
		perform.waitForElementToBeClickable(driver, SOrderDetails.ok_btn(), "id");
		
		// Verify the tracking number
		Assert.assertTrue(SOrderDetails.trackingNumber_txt(driver).getText().contains(StoredVariables.getloanID().get()), "The tracking number did not populate properly");
		
		// Verify the fee amount
		Assert.assertTrue(SOrderDetails.fee_txtbx(driver).getAttribute("value").contains(StoredVariables.getfeeAmount().get()), "The Fee Amount did not populate correctly");
		
		// Verify the order due date
		Assert.assertTrue(SOrderDetails.dueDate_txtbx(driver).getAttribute("value").contains(StoredVariables.getorderDueDateShort().get()), "The Due Date " + StoredVariables.getorderDueDateShort().get() + " did not populate correctly");
		
		// Verify conditionally cancelled is in the history
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("Conditionally declined by Appraiser"), "The history is not displaying conditionally declined");
		
		// Verify proposed fee is in the history
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("Proposed Vendor Due Date: " + StoredVariables.getorderDueDateShort().get()), "The new order due date is not displaying correctly");
		
		// Verify reason for request is in the history
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("Reason for request: Complexity of job requires extra time."), "The reason for request is not displaying correctly");
		
		// Select the Reassign to a different vendor radio button
		perform.click(driver,SOrderDetails.reassign_radioBtn(driver));
		
		// Click OK
		perform.click(driver,SOrderDetails.ok_btn(driver));
		
		// Wait for Finish button to be clickable
		perform.waitForElementToBeClickable(driver, SConfirmOrder.finishTop_btn(), "id");
		
		// Click finish
		perform.click(driver,SConfirmOrder.finishTop_btn(driver));
		
		// Wait for message text
		perform.waitForElementToBeClickable(driver, SConfirmOrder.messageOK_btn(), "id");
		
		// Verify popup displays with correct text
		Assert.assertTrue(SConfirmOrder.message_txt(driver).getText().contains("You must agree to the fee notes entered by the vendor."), "Message for not agreeing to vendor notes did not display properly");
		
		// Click ok on the popup
		perform.click(driver,SConfirmOrder.messageOK_btn(driver));
		
		// Agree to vendor fee notes
		if (!SConfirmOrder.readVendorsFeeNotes_chkbx(driver).isSelected())
		{
			perform.click(driver,SConfirmOrder.readVendorsFeeNotes_chkbx(driver));
		}
		
		// Click Finish
		perform.click(driver,SConfirmOrder.finishBottom_btn(driver));
		
		if (StoredVariables.getbrowser().get().equals("Chrome"))
		{
			Thread.sleep(2000);
		}
		
		// Wait for element to be visible
		perform.waitForElementToBeClickable(driver, SConfirmOrder.vendorInformationEmailAddress_txt(), "cssSelector");
		
		// Get Vendor Email Address
		db.getVendorEmail(driver);
		
		// Login to Vendors site
		vendors.login(driver, StoredVariables.getvendorEmail().get(), StoredVariables.getpassword().get());
		
		// Wait for page to load
		perform.waitForElementToBeClickable(driver, VOrders.orders_btn(), "cssSelector");
		
		// Find order
		vendors.findOrder(driver, StoredVariables.getborrowerIdentifier().get(), "Borrower");
		
		// Click on the order from the orders grid
		perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());
		
		if (StoredVariables.getbrowser().get().equals("Chrome"))
		{
			Thread.sleep(1000);
		}
		
		// Wait for Accept/Decline button
		perform.waitForElementToBeClickable(driver, VOrderDetails.acceptDecline_btn(), "cssSelector");
		
		Thread.sleep(1000);
		
		// Click on the Accept/Decline button
		perform.click(driver,VOrderDetails.acceptDecline_btn(driver));

		// Allow popup time to load
		Thread.sleep(1500);
		
		// Wait for Select Action dropdown
		perform.waitForElementToBeClickable(driver, VOrderAcknowledgement.selectAction_dropdown(), "id");

		// Select Propose Conditions to Client from Select Action dropdown
		perform.selectDropdownOption(driver, VOrderAcknowledgement.selectAction_dropdown(driver), "Propose Conditions to Client");
		
		// Wait for check boxes to load
		conditionalDeclineOptions = VOrderAcknowledgement.conditionalDeclineOptions(driver).getAttribute("style");
		// Set 40 second while loop timeout
		start_time = System.currentTimeMillis();
		wait_time = 40000;
		end_time = start_time + wait_time;
		while (System.currentTimeMillis() < end_time && conditionalDeclineOptions.contains("none")){
			conditionalDeclineOptions = VOrderAcknowledgement.conditionalDeclineOptions(driver).getAttribute("style");
		}
		
		// Allow checkbox options to update
		Thread.sleep(2500);
		
		// Check Complexity of job requires extra charge
		els = driver.findElements(By.cssSelector(VOrderAcknowledgement.extraCharge_chkbx()));
		for(WebElement el : els) 
		{
		  if(el.isDisplayed() && el.isEnabled())
		  {
			  ((JavascriptExecutor) driver).executeScript("arguments[0].click();",el);
		  }
		}
		
		// Click OK
		perform.click(driver,VOrderAcknowledgement.ok_btn(driver));
		
		// Wait for the Address field
		perform.waitForElementToBeClickable(driver, VOrderAcknowledgement.alertOk_btn(), "cssSelector");
		
		// Verify alert text
		Assert.assertTrue(VOrderAcknowledgement.alert_txt(driver).getText().contains("You must either propose a new fee or due date."), "Alert dialog box did not display properly");
		
		// Click alert ok button
		perform.click(driver,VOrderAcknowledgement.alertOk_btn(driver));
		
		// Get random fee amount greater than current fee and pass the fee amount to StorecVariables
		fee = Integer.parseInt(VOrderAcknowledgement.fee_txtbx(driver).getAttribute("value"));
		rand = new Random();
		randomFeeAmount = fee + rand.nextInt((999 - fee) + 1);
		StoredVariables.getfeeAmount().set(Integer.toString(randomFeeAmount));
		
		// Change fee amount
		VOrderAcknowledgement.fee_txtbx(driver).clear();
		perform.type(driver,VOrderAcknowledgement.fee_txtbx(driver), StoredVariables.getfeeAmount().get());
		
		// Get the due date
		StoredVariables.getorderDueDate().set(VOrderAcknowledgement.dueDate_txtbx(driver).getAttribute("value"));
		
		// Parse the due date into long and short format
		date = new SimpleDateFormat("M/d/yyyy").parse(StoredVariables.getorderDueDate().get());
		StoredVariables.getorderDueDateShort().set(new SimpleDateFormat("M/d/yyyy").format(date));
		StoredVariables.getorderDueDateLong().set(new SimpleDateFormat("MM/dd/yyyy").format(date));
		
		// Click OK
		perform.click(driver,VOrderAcknowledgement.ok_btn(driver));
		
		// Close Order Acknowledgement dialog
		vendors.closeOrderAcknowledgementDialog(driver);
		
		// log in to secure site
		secure.login(driver, "Lender2", StoredVariables.getpassword().get());
		
		// Search for the order
		secure.findOrder(driver, StoredVariables.getloanID().get(), "Tracking number");
		
		// Open order
		perform.doubleClickInTable(driver, "MERC-" + StoredVariables.getloanID().get());
		
		// Wait for the do not agree radio button to be clickable
		perform.waitForElementToBeClickable(driver, SOrderDetails.doNotAgree_radioBtn(), "id");
		
		// Verify the tracking number
		Assert.assertTrue(SOrderDetails.trackingNumber_txt(driver).getText().contains(StoredVariables.getloanID().get()), "The tracking number did not populate properly");
		
		// Verify the fee amount
		Assert.assertTrue(SOrderDetails.fee_txtbx(driver).getAttribute("value").contains(StoredVariables.getfeeAmount().get()), "The Fee Amount did not populate correctly");
		
		// Verify the order due date
		Assert.assertTrue(SOrderDetails.dueDate_txtbx(driver).getAttribute("value").contains(StoredVariables.getorderDueDateShort().get()), "The Due Date " + StoredVariables.getorderDueDateShort().get() + " did not populate correctly");
		
		// Verify conditionally cancelled is in the history
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("Conditionally declined by Appraiser"), "The history is not displaying conditionally declined");
		
		// Verify proposed fee is in the history
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("Proposed Fee: $"+StoredVariables.getfeeAmount().get()), "The fee amount is not displaying conditionally declined");
		
		// Verify reason for request is in the history
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("Reason for request: Complexity of job requires extra charge."), "The reason for request is not displaying correctly");
		
		// Verify fee amount is in the agree text
		Assert.assertTrue(SOrderDetails.agree_txt(driver).getText().contains(StoredVariables.getfeeAmount().get()), "The fee amount is not displayed correctly in the agree text");
		
		// Verify the correct due date is in the agree text
		Assert.assertTrue(SOrderDetails.agree_txt(driver).getText().contains(StoredVariables.getorderDueDateShort().get()), "The order due date is not displayed correctly in the agree text");
		
		// Click the agree radio button
		perform.click(driver,SOrderDetails.agree_radioBtn(driver));
		
		// Click OK
		perform.click(driver,SOrderDetails.ok_btn(driver));
		
		if (StoredVariables.getbrowser().get().equals("Chrome"))
		{
			Thread.sleep(1000);
		}
		
		// Search for the order
		secure.findOrder(driver, StoredVariables.getloanID().get(), "Tracking number");
		
		// Open the order
		perform.doubleClickInTable(driver, "MERC-" + StoredVariables.getloanID().get());
		
		// Wait for history text
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Verify the status of the order is In Progress
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("History (In Progress)"), "The order is not in the In Progress status - " + SOrderDetails.history_txt(driver).getText());
						
		// Verify the order accepted shows in the history
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("Order accepted by Client and In Progress"), "Order accepted by Client and In Progress - " + SOrderDetails.history_txt(driver).getText());
		
		// Verify the order accepted shows in the history
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("Client Agrees to Fee and Due Date"), "The client agrees to fee and due date does not show in the history - " + SOrderDetails.history_txt(driver).getText());

		// Wait for Users
		perform.waitForElementToBeClickable(driver, SOrders.users_btn(), "cssSelector");
		
		// Click on Users
		perform.click(driver,SOrders.users_btn(driver));
		
		// Uncheck Compliance
		if (SUsers.compliance_chkbx(driver).isSelected())
		{
			perform.click(driver,SUsers.compliance_chkbx(driver));
		}
		
		// Click Save
		perform.click(driver,SUsers.save_btn(driver));
		
		if (StoredVariables.getbrowser().get().equals("Chrome"))
		{
			Thread.sleep(1000);
		}
		
		// Wait for Orders button
		perform.waitForElementToBeClickable(driver, SOrders.orders_btn(), "cssSelector");
		
		// Click Orders
		perform.click(driver,SOrders.orders_btn(driver));
		
		if (StoredVariables.getbrowser().get().equals("Chrome"))
		{
			Thread.sleep(1000);
		}
		
		// Wait for the find text button to be clickable
		perform.waitForElementToBeClickable(driver, SOrders.find_btn(), "id");
		
		// Find order
		secure.findOrder(driver, StoredVariables.getloanID().get(), "Tracking number");
		
		// Open order
		perform.doubleClickInTable(driver, "MERC-" + StoredVariables.getloanID().get());
		
		// Wait for history
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Verify the tracking number
		Assert.assertTrue(SOrderDetails.trackingNumber_txt(driver).getText().contains(StoredVariables.getloanID().get()), "The tracking number did not populate properly");
		
		// Verify the status of the order is In Progress
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("History (In Progress)"), "The order is not in the In Progress status");
						
		// Verify the order accepted shows in the history
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("Order accepted by Client and In Progress"), "The order aceepted by Lender2 does not show in the history");
		
		// Verify the order accepted shows in the history
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("Client Agrees to Fee and Due Date"), "The client agrees to fee and due date does not show in the history");
		
		// Verify order info
		secure.verifyResidentialAppraisalOrderDetails(driver);

		// Click Set status button
		perform.clickInTable_Contains(driver, "Set status");
		
		// Wait for Place on hold
		perform.waitForElementToBeClickable(driver, SOrderDetails.placeOnHold_btn(), "cssSelector");
		
		// Click Place On Hold
		perform.click(driver,SOrderDetails.placeOnHold_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for OK button to be clickable
		perform.waitForElementToBeClickable(driver, SOrderDetails.setOrderStatusOk_btn(), "id");
		
		// Check Borrower requests to place everything on hold checkbox
		perform.click(driver,SOrderDetails.borrowerRequestsToPlaceEverythingOnHold_chkbx(driver));
		
		// Click OK
		perform.click(driver,SOrderDetails.setOrderStatusOk_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Wait for history text
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Verify order status is On Hold
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("History (On Hold)"), "Order status On Hold not set properly");
		
		// Verify history contains On Hold by Client
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("On Hold by Client"), "On Hold by Client is not displaying in the history");

		// Click Set Status
		perform.clickInTable_Contains(driver, "Set status");
		
		// Click Resume
		perform.click(driver,SOrderDetails.resume_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for OK button to be clickable
		perform.waitForElementToBeClickable(driver, SOrderDetails.setOrderStatusCalendar_btn(), "id");
		
		// Click the calendar button
		perform.click(driver,SOrderDetails.setOrderStatusCalendar_btn(driver));
		
		// Select date
		secure.selectDateFromCalendar(driver, 7);
		
		// Verify correct date was selected
		Assert.assertTrue(SOrderDetails.setOrderStatusDueDate_txtbx(driver).getAttribute("value").equals(StoredVariables.getcalendarDateLong().get()), "New Order Due date ('" + StoredVariables.getcalendarDateLong().get() + "') not selected properly");
		
		// Check Borrower ready to continue checkbox
		perform.click(driver,SOrderDetails.borrowerReadyToContinue_chkbx(driver));
		
		Thread.sleep(1000);
		
		// Click OK
		perform.click(driver,SOrderDetails.setOrderStatusResumeOk_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Wait for history text
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Verify order status is In Progress
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("History (In Progress)"), "Order status In Progress not set properly");
		
		// Verify history contains Resumed by Client
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("Resumed by Client"), "Resumed by Client is not displaying in the history");
		
		Thread.sleep(1500);
		
		// Click the Message button
		perform.click(driver,SOrderDetails.message_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for OK button to be clickable
		perform.waitForElementToBeClickable(driver, SOrderDetails.messageOk_btn(driver));
		
		// Check 1004MC is not required for this job checkbox
		perform.click(driver,SOrderDetails.mcIsNotRequiredForThisJob_chkbx(driver));
		
		// CLick the OK button
		perform.click(driver,SOrderDetails.messageOk_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Click Set Status
		perform.clickInTable_Contains(driver, "Set status");
		
		// Click Cancel
		perform.click(driver,SOrderDetails.setStatusCancel_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for Cancel button to be clickable
		perform.waitForElementToBeClickable(driver, SOrderDetails.setStatusCancelCancel_btn(), "id");
		
		// Click Cancel
		perform.click(driver,SOrderDetails.setStatusCancelCancel_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Wait for history text
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Verify order status is In Progress
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("History (In Progress)"), "Order status In Progress not set properly");
		
		// Get Vendor Email Address
		db.getVendorEmail(driver);

		// Login to Vendors site
		vendors.login(driver, StoredVariables.getvendorEmail().get(), StoredVariables.getpassword().get());
		
		// Wait for page to load
		perform.waitForElementToBeClickable(driver, VOrders.orders_btn(), "cssSelector");
		
		// Find order
		vendors.findOrder(driver, StoredVariables.getborrowerIdentifier().get(), "Borrower");
		
		// Click on the order from the orders grid
		perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());
		
		// Wait for history text
		perform.waitForElementToBeVisible(driver, VOrderDetails.historyHeader_txt(), "id");
		
		// Verify the tracking number
		Assert.assertTrue(VOrderDetails.trackingNumber_txt(driver).getText().contains(StoredVariables.getloanID().get()), "The tracking number did not populate properly");
		
		// Verify the status of the order is In Progress
		Assert.assertTrue(VOrderDetails.historyHeader_txt(driver).getText().contains("History (In Progress)"), "The order is not in the In Progress status");
		
		// Verify order info
		vendors.verifyOrderDetails(driver);

		// Click Set Order Status
		perform.clickInTable_Contains(driver, "Set Order Status");
		
		// Click Delayed
		perform.click(driver,VOrderDetails.delayed_btn(driver));
		
		// Wait for Overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for OK button to be clickable
		perform.waitForElementToBeClickable(driver, VOrderDetails.setStatusOk_btn(), "cssSelector");
		
		// Check Changed original appointment due to homeowner conflicts
		perform.click(driver,VOrderDetails.changedOriginalAppointmentDueToHomeownerConflicts_chkbx(driver));
		
		// Click OK
		perform.click(driver,VOrderDetails.setStatusOk_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Wait for history text
		perform.waitForElementToBeVisible(driver, VOrderDetails.historyHeader_txt(), "id");
		
		// Verify status is History (Delayed)
		Assert.assertTrue(VOrderDetails.historyHeader_txt(driver).getText().contains("History (Delayed)"), "History (Delayed) is not present as the status header"); 
		
		// Verify Delayed by Appraiser is displayed in the History
		Assert.assertTrue(VOrderDetails.orderInformation_txt(driver).getText().contains("Delayed by Appraiser"), "Delayed by Appraiser is not displayed in the history");
		
		// Verify Changed original appointment due to homeowner conflicts is displayed in the history
		Assert.assertTrue(VOrderDetails.orderInformation_txt(driver).getText().contains("Changed original appointment due to homeowner conflicts."), "Changed original appointment due to homeowner conflicts is not displayed in the history");

		// Click Set Order Status
		perform.clickInTable_Contains(driver, "Set Order Status");
		
		// Click Resume
		perform.click(driver,VOrderDetails.resume_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for OK button to be clickable
		perform.waitForElementToBeClickable(driver, VOrderDetails.setStatusOk_btn(), "cssSelector");
		
		// Click Received the OK to proceed from agent
		perform.click(driver,VOrderDetails.receivedTheOkToProceedFromAgent_chkbx(driver));
		
		// Click OK
		perform.click(driver,VOrderDetails.setStatusOk_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Wait for history text
		perform.waitForElementToBeVisible(driver, VOrderDetails.historyHeader_txt(), "id");
		
		// Verify status is History (In Progress)
		Assert.assertTrue(VOrderDetails.historyHeader_txt(driver).getText().contains("History (In Progress)"), "History (In Progress) is not present as the status header"); 
		
		// Verify Resumed by Appraiser is displayed in the History
		Assert.assertTrue(VOrderDetails.orderInformation_txt(driver).getText().contains("Resumed by Appraiser"), "Resumed by Appraiser is not present in the history");
		
		// Received the OK to proceed from agent
		Assert.assertTrue(VOrderDetails.orderInformation_txt(driver).getText().contains("Received the OK to proceed from agent."), "Received the OK to proceed from agent is not present in the history");

		// Click the Message button
		perform.click(driver,VOrderDetails.message_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for OK button to be clickable
		perform.waitForElementToBeClickable(driver, VOrderDetails.send_btn(), "cssSelector");
		
		// Check Actual depreciation for the Subject is justifiable given the market area
		perform.click(driver,VOrderDetails.actualDepreciationForTheSubjectIsJustifiableGivenTheMarketArea_chkbx(driver));
		
		// CLick the Send button
		perform.click(driver,VOrderDetails.send_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Wait for history text
		perform.waitForElementToBeVisible(driver, VOrderDetails.historyHeader_txt(), "id");
		
		// Verify status is History (In Progress)
		Assert.assertTrue(VOrderDetails.historyHeader_txt(driver).getText().contains("History (In Progress)"), "History (In Progress) is not present as the status header");
		
		// Verify Message from Appraiser is displayed in the History
		Assert.assertTrue(VOrderDetails.orderInformation_txt(driver).getText().contains("Message from Appraiser"), "Message from Appraiser is not displayed in the history");

		// Verify Actual depreciation for the Subject is justifiable given the market area. is displayed in the History
		Assert.assertTrue(VOrderDetails.orderInformation_txt(driver).getText().contains("Actual depreciation for the Subject is justifiable given the market area."), "Actual depreciation for the Subject is justifiable given the market area is not displayed in the history");
		
		// Click Set Order Status
		perform.clickInTable_Contains(driver, "Set Order Status");
		
		// Click Cancel
		perform.click(driver,VOrderDetails.cancel_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for OK button to be clickable
		perform.waitForElementToBeClickable(driver, VOrderDetails.setStatusOk_btn(), "cssSelector");
		
		// Click Cancel
		perform.click(driver,VOrderDetails.setStatusCancel_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Wait for history text
		perform.waitForElementToBeVisible(driver, VOrderDetails.historyHeader_txt(), "id");
		
		// Verify status is History (In Progress)
		Assert.assertTrue(VOrderDetails.historyHeader_txt(driver).getText().contains("History (In Progress)"), "History (In Progress) is not present as the status header");
		
		// Verify Message from Appraiser is displayed in the History
		Assert.assertTrue(VOrderDetails.orderInformation_txt(driver).getText().contains("Message from Appraiser"), "Message from Appraiser is not displayed in the history");

		// Verify Actual depreciation for the Subject is justifiable given the market area. is displayed in the History
		Assert.assertTrue(VOrderDetails.orderInformation_txt(driver).getText().contains("Actual depreciation for the Subject is justifiable given the market area."), "Actual depreciation for the Subject is justifiable given the market area is not displayed in the history");

		// log in to secure site
		secure.login(driver, "Lender2", StoredVariables.getpassword().get());
		
		// Wait for the first row to be clickable
		perform.waitForElementToBeClickable(driver, VOrders.find_txtbx(), "id");
		
		// Find order
		secure.findOrder(driver, StoredVariables.getloanID().get(), "Tracking number");
		
		// Open order
		perform.doubleClickInTable(driver, "MERC-" + StoredVariables.getloanID().get());
		
		if (StoredVariables.getbrowser().get().equals("Chrome"))
		{
			Thread.sleep(1000);
		}
		
		// Wait for the set status button to be clickable
		perform.waitForElementToBeClickable(driver, SOrderDetails.message_btn(driver));
		
		// Verify the tracking number
		Assert.assertTrue(SOrderDetails.trackingNumber_txt(driver).getText().contains(StoredVariables.getloanID().get()), "The tracking number did not populate properly");
		
		// Verify the notes in the audit trail reflect the activity of the order without names
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("History (In Progress)"), "The history is not displaying correctly");
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("Message from Appraiser"), "The history is not displaying correctly");
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("Actual depreciation for the Subject is justifiable given the market area."), "The history is not displaying correctly");
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("Resumed by Appraiser"), "The history is not displaying correctly");
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("Notes:  Received the OK to proceed from agent."), "The history is not displaying correctly");
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("Delayed by Appraiser"), "The history is not displaying correctly");
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("Notes:  Changed original appointment due to homeowner conflicts."), "The history is not displaying correctly");
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("Message from Client"), "The history is not displaying correctly");
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("1004MC is not required for this job"), "The history is not displaying correctly");
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("Resumed by Client"), "The history is not displaying correctly");
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("Notes:  Borrower ready to continue."), "The history is not displaying correctly");
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("On Hold by Client"), "The history is not displaying correctly");
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("Notes:  Borrower requests to place everything on hold."), "The history is not displaying correctly");
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("Order accepted by Client and In Progress"), "The history is not displaying correctly");
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("Notes:  Client Agrees to Fee and Due Date"), "The history is not displaying correctly");
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("Conditionally declined by Appraiser"), "The history is not displaying correctly");
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("Reason for request: Complexity of job requires extra charge."), "The history is not displaying correctly");
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("Awaiting acceptance by Appraiser"), "The history is not displaying correctly");
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("Reassigned by Client to Appraiser"), "The history is not displaying correctly");
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("Conditionally declined by Appraiser"), "The history is not displaying correctly");
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("Reason for request: Complexity of job requires extra time."), "The history is not displaying correctly");
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("Awaiting acceptance by Appraiser"), "The history is not displaying correctly");
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("Notes:  Client Proposes New Conditions"), "The history is not displaying correctly");
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("Conditionally declined by Appraiser"), "The history is not displaying correctly");
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("Reason for request: Complexity of job requires extra charge."), "The history is not displaying correctly");
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("Awaiting acceptance by Appraiser"), "The history is not displaying correctly");
		
		// Verify order info
		secure.verifyResidentialAppraisalOrderDetails(driver);
		
		// Log test
		test.log(LogStatus.INFO, "Round Trip", "Ran through the Decline and Accept process");
	}
} // end the OrderManagement class
