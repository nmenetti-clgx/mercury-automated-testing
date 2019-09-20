package baselineWhitelist;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjects.Secure.SConfirmOrder;
import pageObjects.Secure.SOrderDetails;
import pageObjects.Secure.SOrders;
import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Baseline - Whitelist</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class Whitelist extends TestSetup {
	
	/** The user secure. */
	private static String userSecure = "Whitelist1";
	
	/** The user VMP. */
	private static String userVMP = "OriginatorWhitelist1";
	
	/** The user vendors. */
	private static String userVendors = "WhitelistingAppraiser1";
	
	/** The password. */
	private static String password = "";
	
	/** The tracking number secure. */
	private static String trackingNumberSecure = "";
	
	/** The loan ID secure. */
	private static String loanIDSecure = "";
	
	/** The whitelist 1. */
//	private static String whitelist1 = "Test String ���������������������������������������������������������������������������������������������������������������������������� !\"#$%&'()*+,-./0123456789:;<=>?@[\\]^_`{|}~";
	private static String whitelist1 = "Test String €‚ƒ„…†‡ˆ‰Š‹ŒŽ‘’“”•–—˜˜˜™š›œŸ ¡¢£¤¥¦§¨©ª«¬­®¯°±²³´µ¶·¸¹º»¼½¾¿ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚÛÜÝÞßàáâãäåæçèéêëìíîïðñòóôõö÷øùúûüýþÿ !\"#$%&'()*+,-./0123456789:;<=>?@[\\]^_`{|}~";
	
	/** The whitelist 1 expected. */
//	private static String whitelist1Expected = "Test String  !\"#$%&'()*+,-./0123456789:;<=>?@[\\]^_`{|}~";
	private static String whitelist1Expected = "Test String ©® !\"#$%&'()*+,-./0123456789:;<=>?@[\\]^_`{|}~";
	
	/** The whitelist multi line 1. */
//	private static String whitelistMultiLine1 = "Test String ���������������������������������������������������������������������������������������������������������������������������� !\"#$%&'()*+,-./\n0123456789:;<=>?@[\\]^_`{|}~";
	private static String whitelistMultiLine1 = "Test String €‚ƒ„…†‡ˆ‰Š‹ŒŽ‘’“”•–—˜˜˜™š›œŸ ¡¢£¤¥¦§¨©ª«¬­®¯°±²³´µ¶·¸¹º»¼½¾¿ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚÛÜÝÞßàáâãäåæçèéêëìíîïðñòóôõö÷øùúûüýþÿ !\"#$%&'()*+,-./\n0123456789:;<=>?@[\\]^_`{|}~";
	
	/** The whitelist multi line 1 expected. */
//	private static String whitelistMultiLine1Expected = "Test String  !\"#$%&'()*+,-./\n0123456789:;<=>?@[\\]^_`{|}~";
	private static String whitelistMultiLine1Expected = "Test String ©® !\"#$%&'()*+,-./\n0123456789:;<=>?@[\\]^_`{|}~";
	
	/** The whitelist multi line 2. */
//	private static String whitelistMultiLine2 = "Test String ���������������������������������������������������������������������������������������������������������������������������� !\"#$%&'()*+,-./\n0123456789:;=?@[\\]^_`{|}~";
	private static String whitelistMultiLine2 = "Test String €‚ƒ„…†‡ˆ‰Š‹ŒŽ‘’“”•–—˜˜˜™š›œŸ ¡¢£¤¥¦§¨©ª«¬­®¯°±²³´µ¶·¸¹º»¼½¾¿ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚÛÜÝÞßàáâãäåæçèéêëìíîïðñòóôõö÷øùúûüýþÿ !\"#$%&'()*+,-./\n0123456789:;=?@[\\]^_`{|}~";
	
	/** The whitelist multi line 2 expected. */
//	private static String whitelistMultiLine2Expected = "Test String  !\"#$%&'()*+,-./\n0123456789:;=?@[\\]^_`{|}~";
	private static String whitelistMultiLine2Expected = "Test String ©® !\"#$%&'()*+,-./\n0123456789:;=?@[\\]^_`{|}~";
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>From VMP Client Portal, place an order</li>
	 * 	<li>Get order numbers</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Select WhitelistingApprsiser1</li>
	 * 	<li>Click the Email button</li>
	 * 	<li>Test email message field</li>
	 * 	<li>Click Send</li>
	 * 	<li>Check database for notification</li>
	 * 	<li>Query the database and return the results as an array</li>
	 * 	<li>Verify correct number of rows in MailQueue</li>
	 * 	<li>Query the database</li>
	 * 	<li>Set the server address per the environment</li>
	 * 	<li>Set expected results</li>
	 * 	<li>Set database values</li>
	 * 	<li>Verify MailFrom</li>
	 * 	<li>Verify MailTo</li>
	 * 	<li>Verify Subject</li>
	 * 	<li>Verify TemplateUsed</li>
	 * 	<li>Verify SentDateTime is not NULL</li>
	 * 	<li>Verify Successful is 1</li>
	 * 	<li>Verify FromEntityID</li>
	 * 	<li>Verify ToEntityID</li>
	 * 	<li>Click Set Status</li>
	 * 	<li>Click Change due date</li>
	 * 	<li>Test Note textbox</li>
	 * 	<li>Click Cancel</li>
	 * 	<li>Click Add Note</li>
	 * 	<li>Click OK</li>
	 * 	<li>Test Note textbox</li>
	 * 	<li>Click Cancel</li>
	 * 	<li>Click Assign</li>
	 * 	<li>Assign the appraiser</li>
	 * 	<li>Click Finish</li>
	 * 	<li>Login to Vendors</li>
	 * 	<li>Conditionally decline the order</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Test commentsToVendorProposedConditions_txtbx</li>
	 * 	<li>Click OK</li>
	 * 	<li>Login to Vendors</li>
	 * 	<li>Open the order</li>
	 * 	<li>Request Modification</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Test Comments to Vendor Modification Requested</li>
	 * 	<li>Click OK</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Click Set status</li>
	 * 	<li>Click Delayed</li>
	 * 	<li>Test Notes textbox</li>
	 * 	<li>Click Cancel</li>
	 * 	<li>Test Ratings Comments</li>
	 * 	<li>Click Message</li>
	 * 	<li>Test Message textbox</li>
	 * 	<li>Click Cancel</li>
	 * 	<li>Click Set Status</li>
	 * 	<li>Click Inspection Scheduled</li>
	 * 	<li>Test Note textbox</li>
	 * 	<li>Click Cancel</li>
	 * 	<li>Click Set Status</li>
	 * 	<li>Click Change due date</li>
	 * 	<li>Test Note textbox</li>
	 * 	<li>Click Cancel</li>
	 * 	<li>Click Set Status</li>
	 * 	<li>Click Change fee</li>
	 * 	<li>Test Note textbox</li>
	 * 	<li>Click Cancel</li>
	 * 	<li>Complete the order as Lender</li>
	 * 	<li>Click Set Status</li>
	 * 	<li>Click Mark as complete</li>
	 * 	<li>Test Note textbox</li>
	 * 	<li>Upload report</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Click Set status</li>
	 * 	<li>Click Send to BlitzDocs</li>
	 * 	<li>Test note textbox</li>
	 * 	<li>Click Cancel</li>
	 * 	<li>Click Set Status</li>
	 * 	<li>Click Request revision</li>
	 * 	<li>Test Note textbox</li>
	 * 	<li>Click Cancel</li>
	 * 	<li>Select Completed Report (Current)</li>
	 * 	<li>Click Delete icon</li>
	 * 	<li>Click OK</li>
	 * 	<li>Test Notes textbox</li>
	 * 	<li>Click Cancel</li>
	 * 	<li>Submit to UCDP</li>
	 * 	<li>Set Remove UCDP status button as an element</li>
	 * 	<li>Get parent element</li>
	 * 	<li>refresh the page</li>
	 * 	<li>Set Remove UCDP status button as an element</li>
	 * 	<li>Get parent element</li>
	 * 	<li>Click Set Status</li>
	 * 	<li>Click Remove UCDP Status</li>
	 * 	<li>Test Note textbox</li>
	 * 	<li>Click Cancel</li>
	 * 	<li>Click Mark as paid</li>
	 * 	<li>Test Invoice #</li>
	 * 	<li>Test Check #</li>
	 * 	<li>Test Note</li>
	 * 	<li>Click Cancel</li>
	 * 	<li>Click No</li>
	 * 	<li>From VMP Client Portal, place an order</li>
	 * 	<li>Get order numbers</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Click Assign</li>
	 * 	<li>Assign the appraiser</li>
	 * 	<li>Click Finish</li>
	 * 	<li>Login to Vendors</li>
	 * 	<li>Accept the order</li>
	 * 	<li>Complete the order</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Test Comments to Client</li>
	 * 	<li>Test Comments to Vendor</li>
	 * 	<li>Test Comments to Borrower</li>
	 * 	<li>Click Set Status</li>
	 * 	<li>Click Place on Hold</li>
	 * 	<li>Test note</li>
	 * 	<li>Click OK</li>
	 * 	<li>Click Sync to VMP</li>
	 * 	<li>Test textbox</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (groups={"Whitelist", "VMP - Create Order Via API", "Secure - Orders", "Secure - Email", "Verify Mail Queue", "Secure - Set Status", "Vendors - Orders", "Vendors - Conditionally Decline Order", "Vendors - Request Modification", "Vendors - Accept Order", "Vendors - Complete Order"}, alwaysRun=true)
	public void orderDetailsWhitelisting() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		if (StoredVariables.getmobile().get()==false) {
		
			password = StoredVariables.getpassword().get();
			
			// From VMP Client Portal, place an order
			perform.apiPlaceOrderFromVMPClientPortal(driver, userVMP, password, userSecure, "PlaceAppraisalOrderExLenderNoGroups-Whitelist");
			
			// Get order numbers
			trackingNumberSecure = StoredVariables.gettrackingNumber().get();
			loanIDSecure = StoredVariables.getloanID().get();
			
			// Login to Secure
			secure.login(driver, userSecure, password);
			
			// Find the order
			secure.findOrder(driver, trackingNumberSecure, "Tracking number");
	
			// Open the order
			secure.openOrder(driver, trackingNumberSecure);
			
			// Wait for checkmark
			perform.waitForElementToBeClickable(driver, SOrderDetails.checkmark_btn(), "cssSelector");
			
			// Select WhitelistingApprsiser1
			perform.click(driver,SOrderDetails.checkmark_btn(driver));
			
			// Click the Email button
			perform.click(driver,SOrderDetails.email_btn(driver));
			
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			// Test email message field
			perform.verifyWhitelisting(driver, SOrderDetails.emailEligibleVendorsMessage_txtbx(driver), whitelistMultiLine1, SOrderDetails.emailEligibleVendors_txt(driver), whitelistMultiLine1Expected);
			
			// Click Send
			perform.click(driver,SOrderDetails.send_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			// Check database for notification
			/***********************************************************************************************
			 * Verify the notifications in the database
			 ***********************************************************************************************/
			// Query the database and return the results as an array
			String secureProductItemID = db.getProductItemID(driver, loanIDSecure);
			
			// Verify correct number of rows in MailQueue
			perform.verifyTheNumberOfRowsInTheMailQueueDBResultsForProductItemID(driver, 1, secureProductItemID);
			
			// Query the database
			// Set the server address per the environment
			String env = StoredVariables.getusernameEnvironment().get();
			String server = "";
			String secureEntityID = "";
			String vendorsEntityID = ""; 
			if (env.equals("QA"))
			{
				server = "\\\\ss1qa.internal.ad.mercuryvmp.com\\Shared Storage\\MercuryEmailTemplates\\QA\\";
				secureEntityID = "1071333";
				vendorsEntityID = "1071339";
			} // end if QA
			if (env.equals("Beta"))
			{
				server = "\\\\ss1.internal.ad.mercuryvmp.com\\Shared Storage\\MercuryEmailTemplates\\Beta\\";
				secureEntityID = "5573033";
				vendorsEntityID = "5573291";
			} // end if Beta
			if (env.equals("Live"))
			{
				server = "\\\\ss1.internal.ad.mercuryvmp.com\\Shared Storage\\MercuryEmailTemplates\\Production\\";
				secureEntityID = "5573034";
				vendorsEntityID = "5573293";
			} // end if Live
			
			String sqlStatement = "SELECT TOP 1 * FROM [dbo].[MailQueue] WHERE ProductItemID = '"
					+ secureProductItemID
					+ "' ORDER BY EnteredStamp DESC";
			ArrayList<String> results = db
					.getMailQueueInfoBySQLToArray(driver, sqlStatement);
	
			// Set expected results
			String mailFromExpected = "automation"+env+"Whitelist1@dntest.net";
			String mailToExpected = "automation"+env+"WhitelistingAppraiser1@dntest.net";
			String subjectExpected = "Mercury Network - Potential Order Message";
			String templateUsedExpected = server + "NotifyEligibleVendors.html";
			if (env.equals("Beta")) {
				templateUsedExpected = "\\\\ss1.internal.ad.mercuryvmp.com\\Shared Storage\\MercuryEmailTemplates\\Production\\NotifyEligibleVendors.html";
			}
			String successfulExpected = "1";
			String fromEntityIDExpected = secureEntityID;
			String toEntityIDExpected = vendorsEntityID;
	
			// Set database values
			String mailFrom = results.get(4);
			String mailTo = results.get(5);
			String subject = results.get(8);
			String templateUsed = results.get(9);
			String sentDateTime = results.get(11);
			String successful = results.get(12);
			String fromEntityID = results.get(13);
			String toEntityID = results.get(14);
	
			// Verify MailFrom
			Assert.assertTrue(mailFrom.equals(mailFromExpected),
					"The MailFrom entry in the database is incorrect. DB value = "
							+ mailFrom + " and shoudl be = " + mailFromExpected);
	
			// Verify MailTo
			Assert.assertTrue(mailTo.equals(mailToExpected),
					"The MailTo entry in the database is incorrect. DB value = "
							+ mailTo + " and shoudl be = " + mailToExpected);
	
			// Verify Subject
			Assert.assertTrue(subject.equals(subjectExpected),
					"The Subject entry in the database is incorrect. DB value = "
							+ subject + " and shoudl be = " + subjectExpected);
	
			// Verify TemplateUsed
			Assert.assertTrue(
					templateUsed.toLowerCase().equals(
							templateUsedExpected.toLowerCase()),
					"The TemplateUsed entry in the database is incorrect. DB value = "
							+ templateUsed + " and shoudl be = "
							+ templateUsedExpected);
	
			// Verify SentDateTime is not NULL
			Assert.assertTrue(!sentDateTime.toLowerCase().equals("null"),
					"The SentDateTime entry in the database is null!");
	
			// Verify Successful is 1
			Assert.assertTrue(successful.equals(successfulExpected),
					"The Successful entry in the database is incorrect. DB value = "
							+ successful + " and shoudl be = " + successfulExpected);
	
			// Verify FromEntityID
			Assert.assertTrue(fromEntityID.equals(fromEntityIDExpected),
					"The FromEntityID entry in the database is incorrect. DB value = "
							+ fromEntityID + " and shoudl be = "
							+ fromEntityIDExpected);
	
			// Verify ToEntityID
			Assert.assertTrue(toEntityID.equals(toEntityIDExpected),
					"The ToEntityID entry in the database is incorrect. DB value = "
							+ toEntityID + " and shoudl be = " + toEntityIDExpected);
	
			// Click Set Status
			perform.click(driver,SOrderDetails.setStatus_btn(driver));
			
			// Click Change due date
			perform.clickInTable_Contains(driver, "Change due date");
			
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			// Test Note textbox
			perform.verifyWhitelisting(driver, SOrderDetails.commentsChangeDueDate_txtbx(driver), whitelistMultiLine1, SOrderDetails.newDueDate_txtbx(driver), whitelistMultiLine1Expected);
			SOrderDetails.commentsChangeDueDate_txtbx(driver).clear();
			
			// Click Cancel
			perform.click(driver,SOrderDetails.cancelChangeDueDate_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			// Click Add Note
			perform.click(driver,SOrderDetails.addNote_btn(driver));
			
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			// Click OK
			perform.click(driver,SOrderDetails.okAddNote_btn(driver));
			
			// Test Note textbox 
			perform.verifyWhitelisting(driver, SOrderDetails.note_txtbx(driver), whitelistMultiLine2, SOrderDetails.addNote_txt(driver), whitelistMultiLine2Expected);
			
			// Click Cancel
			perform.click(driver,SOrderDetails.cancelAddNote_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			// Click Assign
			perform.click(driver,SOrderDetails.assign_btn(driver));
			
			// Assign the appraiser
			secure.selectVendor(driver, "WhitelistingAppraiser1");
			
			// Click Finish
			perform.click(driver,SConfirmOrder.finishTop_btn(driver));
			
			// Wait for attach button
			perform.waitForElementToBeClickable(driver, SOrderDetails.viewXSiteOrder_lnk(), "id");
			
			// Login to Vendors
			vendors.login(driver, userVendors, password);
			
			// Conditionally decline the order
			vendors.conditionallyDeclineOrder(driver, trackingNumberSecure, "525");
			
			// Login to Secure
			secure.login(driver, userSecure, password);
			
			// Find the order
			secure.findOrder(driver, trackingNumberSecure, "Tracking number");
	
			// Open the order
			secure.openOrder(driver, trackingNumberSecure);
			
			// Test commentsToVendorProposedConditions_txtbx
			perform.verifyWhitelisting(driver, SOrderDetails.commentsToVendorProposedConditions_txtbx(driver), whitelistMultiLine1, SOrderDetails.iAgreeVendorProposedConditions_btn(driver), whitelistMultiLine1Expected);
			
			// Click OK
			perform.click(driver,SOrderDetails.ok_btn(driver));
			
			// Wait for Find textbox
			perform.waitForElementToBeClickable(driver, SOrders.find_txtbx(), "id");
			
			// Login to Vendors
			vendors.login(driver, userVendors, password);
			
			// Open the order
			vendors.findAndOpenOrder(driver, trackingNumberSecure);
			
			// Request Modification
			vendors.requestModification(driver, "", "", "530", "", "These are request modification notes");
			
			// Login to Secure
			secure.login(driver, userSecure, password);
			
			// Find the order
			secure.findOrder(driver, trackingNumberSecure, "Tracking number");
	
			// Open the order
			secure.openOrder(driver, trackingNumberSecure);
			
			// Test Comments to Vendor Modification Requested
			perform.verifyWhitelisting(driver, SOrderDetails.commentsToVendorModificationRequested_txtbx(driver), whitelistMultiLine1, SOrderDetails.iAgreeToTheRequestedProductModifications_radioBtn(driver), whitelistMultiLine1Expected);
	
			// Click OK
			perform.click(driver,SOrderDetails.okModificationRequested_btn(driver));
	
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			// Wait for the Find textbox
			perform.waitForElementToBeClickable(driver, SOrders.find_txtbx(), "id");
			
			// Find the order
			secure.findOrder(driver, trackingNumberSecure, "Tracking number");
	
			// Open the order
			secure.openOrder(driver, trackingNumberSecure);
			
			// Click Set status
			perform.click(driver,SOrderDetails.setStatus_btn(driver));
			
			// Click Delayed
			perform.clickInTable_Contains(driver, "Delayed");
			
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			// Wait for notes textbox
			perform.waitForElementToBeClickable(driver, SOrderDetails.noteSetOrderStatusDelayed_txtbx(), "id");
			
			// Test Notes textbox
			perform.verifyWhitelisting(driver, SOrderDetails.noteSetOrderStatusDelayed_txtbx(driver), whitelistMultiLine1, SOrderDetails.setOrderStatusDueDate_txtbx(driver), whitelistMultiLine1Expected);
			
			// Click Cancel
			perform.click(driver,SOrderDetails.cancelSetOrderStatusDelayed_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			// Test Ratings Comments
			perform.verifyWhitelisting(driver, SOrderDetails.comments_txtbx(driver), whitelistMultiLine1, SOrderDetails.history_txt(driver), whitelistMultiLine1Expected);
			
			// Click Message
			perform.click(driver,SOrderDetails.message_btn(driver));
			
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			// Wait for Message textbox
			perform.waitForElementToBeClickable(driver, SOrderDetails.sendMessage_txtbx(), "id");
			
			// Test Message textbox
			perform.verifyWhitelisting(driver, SOrderDetails.sendMessage_txtbx(driver), whitelistMultiLine1, SOrderDetails.sendMessage_txt(driver), whitelistMultiLine1Expected);
			
			// Click Cancel
			perform.click(driver,SOrderDetails.cancelSendMessage_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			// Click Set Status
			perform.click(driver,SOrderDetails.setStatus_btn(driver));
			
			// Click Inspection Scheduled
			perform.clickInTable_Contains(driver, "Inspection scheduled");
			
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			// Wait for busy to be hidden
			perform.waitForBusyToBeHidden(driver);
			
			// Test Note textbox
			perform.verifyWhitelisting(driver, SOrderDetails.noteSetOrderStatus_txtbx(driver), whitelistMultiLine1, SOrderDetails.inspectionScheduledFor_txtbx(driver), whitelistMultiLine1Expected);
			
			// Click Cancel
			perform.click(driver,SOrderDetails.cancelSetOrderStatus_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			// Click Set Status
			perform.click(driver,SOrderDetails.setStatus_btn(driver));
			
			// Click Change due date
			perform.clickInTable_Contains(driver, "Change due date");
			
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			// Test Note textbox
			perform.verifyWhitelisting(driver, SOrderDetails.commentsChangeDueDate_txtbx(driver), whitelistMultiLine1, SOrderDetails.newDueDate_txtbx(driver), whitelistMultiLine1Expected);
			
			// Click Cancel
			perform.click(driver,SOrderDetails.cancelChangeDueDate_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			// Click Set Status
			perform.click(driver,SOrderDetails.setStatus_btn(driver));
			
			// Click Change fee
			perform.clickInTable_Contains(driver, "Change fee");
			
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			// Test Note textbox
			perform.verifyWhitelisting(driver, SOrderDetails.commentsChangeFee_txtbx(driver), whitelistMultiLine1, SOrderDetails.newFee_txtbx(driver), whitelistMultiLine1Expected);
			
			// Click Cancel
			perform.click(driver,SOrderDetails.cancelChangeFee_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			// Complete the order as Lender
			// Click Set Status
			perform.click(driver,SOrderDetails.setStatus_btn(driver));
			
			// Click Mark as complete
			perform.clickInTable_Contains(driver, "Mark as complete");
			
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			// Wait for Note textbox
			perform.waitForElementToBeClickable(driver, SOrderDetails.noteCompleteAssignment_txtbx(), "id");
			
			// Test Note textbox
			perform.verifyWhitelisting(driver, SOrderDetails.noteCompleteAssignment_txtbx(driver), whitelistMultiLine1, SOrderDetails.completeAssignment_txt(driver), whitelistMultiLine1Expected);
			
			// Upload report
			vendors.completeOrderByHTTPPost(driver, "Whitelist1", StoredVariables.getpassword().get(), loanIDSecure, "Complete.xml");
			
			// Login to Secure
			secure.login(driver, userSecure, password);
			
			// Find the order
			secure.findOrder(driver, trackingNumberSecure, "Tracking number");
	
			// Open the order
			secure.openOrder(driver, trackingNumberSecure);
			
			// Click Set status
			perform.click(driver,SOrderDetails.setStatus_btn(driver));
			
			// Click Send to BlitzDocs
			perform.clickInTable_Contains(driver, "Send to BlitzDocs");
			
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			// Wait for Notes textbox
			perform.waitForElementToBeClickable(driver, SOrderDetails.createANoteInYourBlitzDocs_txtbx(), "id");
			
			// Test note textbox
			perform.verifyWhitelisting(driver, SOrderDetails.createANoteInYourBlitzDocs_txtbx(driver), whitelistMultiLine1, SOrderDetails.sendToBlitzDocs_txt(driver), whitelistMultiLine1Expected);
			
			// Click Cancel
			perform.click(driver,SOrderDetails.cancelSendToBlitzDocs_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			// Click Set Status
			perform.click(driver,SOrderDetails.setStatus_btn(driver));
			
			// Click Request revision
			perform.clickInTable_Contains(driver, "Request revision");
			
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			// Test Note textbox
			perform.verifyWhitelisting(driver, SOrderDetails.notesRevisionRequired_txtbx(driver), whitelistMultiLine1, SOrderDetails.requestRevisionSetOrderStatusText_txt(driver), whitelistMultiLine1Expected);
			
			// Click Cancel
			perform.click(driver,SOrderDetails.cancelRequestRevision_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			// Select Completed Report (Current)
			perform.clickInTable_Contains(driver, "Completed Report (Current)");
			
			// Wait for Delete icon
			perform.waitForElementToBeClickable(driver, SOrderDetails.delete_btn(), "id");
			
			// Click Delete icon
			Thread.sleep(5000);
			perform.click(driver,SOrderDetails.delete_btn(driver));
			
			// Wait for OK button
			perform.waitForElementToBeClickable(driver, SOrderDetails.okDeleteCompletedReport_btn(), "id");
			
			// Click OK
			perform.click(driver,SOrderDetails.okDeleteCompletedReport_btn(driver));
			
			// Wait for Notes
			perform.waitForElementToBeClickable(driver, SOrderDetails.notesDeleteCompletedReport_txtbx(), "id");
			
			// Test Notes textbox
			perform.verifyWhitelisting(driver, SOrderDetails.notesDeleteCompletedReport_txtbx(driver), whitelist1, SOrderDetails.deleteCompletedReportDialog_txt(driver), whitelist1Expected);
			
			// Click Cancel
			perform.click(driver,SOrderDetails.cancelDeleteCompletedReport_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			// Submit to UCDP
			secure.submitToUCDP(driver, "Fannie Mae", "", "", "Submitting to UCDP", false);
			
			// Wait for Appraisal Submission Accepted to display in the history
			boolean dbUpdate = secure.waitForHistoryTextToUpdate(driver, "Appraisal Submission");
			Assert.assertTrue(dbUpdate==true, "The UCDP Submission has not completed");
			
			// Set Remove UCDP status button as an element
			String text = "Remove UCDP status";
			WebElement e = driver.findElement(By.xpath("//td[contains(text(), '" + text + "')]"));
			
			// Get parent element
			WebElement parent = e.findElement(By.xpath(".."));
			String parentClass = parent.getAttribute("class");
			
			while (parentClass.contains("Disabled")) {
				
				// refresh the page
				driver.navigate().refresh();
				
				// Set Remove UCDP status button as an element
				text = "Remove UCDP status";
				e = driver.findElement(By.xpath("//td[contains(text(), '" + text + "')]"));
				
				// Get parent element
				parent = e.findElement(By.xpath(".."));
				parentClass = parent.getAttribute("class");
				
			} // end while
			
			// Click Set Status
			perform.click(driver,SOrderDetails.setStatus_btn(driver));
			
			// Click Remove UCDP Status
			perform.clickInTable_Contains(driver, "Remove UCDP status");
			
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			// Wait for UCDP Status textbox
			perform.waitForElementToBeClickable(driver, SOrderDetails.noteRemoveUCPDStatus_txtbx(), "id");
			
			// Test Note textbox
			perform.verifyWhitelisting(driver, SOrderDetails.noteRemoveUCPDStatus_txtbx(driver), whitelistMultiLine2, SOrderDetails.removeUCDPStatusSetOrderStatusText_txt(driver), whitelistMultiLine2Expected);
			
			// Click Cancel
			perform.click(driver,SOrderDetails.cancelRemoveUCDPStatus_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			// Click Mark as paid
			perform.click(driver,SOrderDetails.markAsPaid_btn(driver));
			
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			// Test Invoice #
			perform.verifyWhitelisting(driver, SOrderDetails.invoiceNumber_txtbx(driver), whitelist1, SOrderDetails.checkNumber_txtbx(driver), whitelist1Expected);
			
			// Test Check #
			perform.verifyWhitelisting(driver, SOrderDetails.checkNumber_txtbx(driver), whitelist1, SOrderDetails.invoiceNumber_txtbx(driver), whitelist1Expected);
			
			// Test Note
			perform.verifyWhitelisting(driver, SOrderDetails.noteEnterNewPayment_txtbx(driver), whitelistMultiLine1, SOrderDetails.checkNumber_txtbx(driver), whitelistMultiLine1Expected);
			
			// Click Cancel
			perform.click(driver,SOrderDetails.cancelEnterNewPayment_btn(driver));
			
			// Wait for the No button
			perform.waitForElementToBeClickable(driver, SOrderDetails.no_btn(), "id");
			
			// Click No
			perform.click(driver,SOrderDetails.no_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			// From VMP Client Portal, place an order
			perform.apiPlaceOrderFromVMPClientPortal(driver, userVMP, password, userSecure, "PlaceAppraisalOrderExLenderNoGroups-Whitelist");
			
			// Get order numbers
			trackingNumberSecure = StoredVariables.gettrackingNumber().get();
			loanIDSecure = StoredVariables.getloanID().get();
			
			// Login to Secure
			secure.login(driver, userSecure, password);
			
			// Find the order
			secure.findOrder(driver, trackingNumberSecure, "Tracking number");
	
			// Open the order
			secure.openOrder(driver, trackingNumberSecure);
			
			// Click Assign
			perform.click(driver,SOrderDetails.assign_btn(driver));
			
			// Assign the appraiser
			secure.selectVendor(driver, "WhitelistingAppraiser1");
			
			// Click Finish
			perform.click(driver,SConfirmOrder.finishTop_btn(driver));
			
			// Wait for attach button
			perform.waitForElementToBeClickable(driver, SOrderDetails.viewXSiteOrder_lnk(), "id");
			
			// Login to Vendors
			vendors.login(driver, userVendors, password);
			
			// Accept the order
			vendors.acceptOrder(driver, trackingNumberSecure);
			
			// Complete the order
			vendors.completeOrderByHTTPPost(driver, userVendors, StoredVariables.getpassword().get(), loanIDSecure, "Complete.xml");
			
			// Login to Secure
			secure.login(driver, userSecure, password);
			
			// Find the order
			secure.findOrder(driver, trackingNumberSecure, "Tracking number");
	
			// Open the order
			secure.openOrder(driver, trackingNumberSecure);
			
			// Test Comments to Client
			perform.verifyWhitelisting(driver, SOrderDetails.commentsToClient_txtbx(driver), whitelistMultiLine2, SOrderDetails.commentsToVendor_txtbx(driver), whitelistMultiLine2Expected);
			SOrderDetails.commentsToClient_txtbx(driver).clear();
			
			// Test Comments to Vendor
			perform.verifyWhitelisting(driver, SOrderDetails.commentsToVendor_txtbx(driver), whitelistMultiLine2, SOrderDetails.commentsToClient_txtbx(driver), whitelistMultiLine2Expected);
			SOrderDetails.commentsToVendor_txtbx(driver).clear();
			
			// Test Comments to Borrower
			perform.verifyWhitelisting(driver, SOrderDetails.commentsToBorrower_txtbx(driver), whitelistMultiLine2, SOrderDetails.commentsToClient_txtbx(driver), whitelistMultiLine2Expected);
			SOrderDetails.commentsToBorrower_txtbx(driver).clear();
			
			// Click Set Status
			perform.click(driver,SOrderDetails.setStatus_btn(driver));
			
			// Click Place on Hold
			perform.clickInTable_Contains(driver, "Place on hold");
			
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			// Wait for Note textbox
			perform.waitForElementToBeClickable(driver, SOrderDetails.notePlaceOnHold_txtbx(), "id");
			
			// Test note
			perform.verifyWhitelisting(driver, SOrderDetails.notePlaceOnHold_txtbx(driver), whitelistMultiLine1, SOrderDetails.removeUCDPStatusSetOrderStatusText_txt(driver), whitelistMultiLine1Expected);
			
			// Click OK
			perform.click(driver,SOrderDetails.okPlaceOnHold_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			// Click Sync to VMP
			perform.click(driver,SOrderDetails.syncToVMP_btn(driver));
			
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			// Wait for textbox
			perform.waitForElementToBeClickable(driver, SOrderDetails.syncToVMPNotes_txtbx(), "id");
			
			// Test textbox
			perform.verifyWhitelisting(driver, SOrderDetails.syncToVMPNotes_txtbx(driver), whitelistMultiLine1, SOrderDetails.syncToVMPDialog_txt(driver), whitelistMultiLine1Expected);
			
			// Log test
			test.log(LogStatus.INFO, "Notifications", "Submitted the order to UCDP and verified the notifications");
			
		} // end if
		
	} // end orderDetailsWhitelisting
	
} // end the Whitelisting class
