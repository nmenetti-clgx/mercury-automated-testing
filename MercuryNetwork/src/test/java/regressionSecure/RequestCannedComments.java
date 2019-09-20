package regressionSecure;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Secure.SCannedCommentSuggestion;
import pageObjects.Secure.SConfirmOrder;
import pageObjects.Secure.SOrderDetails;
import pageObjects.Secure.SVendorSelectionSettings;
import pageObjects.Vendors.VCannedCommentSuggestion;
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
 * <h1>Secure - Request Canned Comments</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class RequestCannedComments extends TestSetup {
	
	/** The user secure. */
	private final String userSecure = "RegressionSecure16";
	
	/** The user vendors. */
	private final String userVendors = "Appraiser1";
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Go to Vendor Selection Settings</li>
	 * 	<li>Enable Double Blind</li>
	 * 	<li>Save settings</li>
	 * 	<li>Create an order to work with</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Find and open the order</li>
	 * 	<li>Click Assign</li>
	 * 	<li>Check I have read and understand the vendors fee</li>
	 * 	<li>Click Finish</li>
	 * 	<li>Login to vendors</li>
	 * 	<li>View the details of the order</li>
	 * 	<li>Click Accept</li>
	 * 	<li>Confirm you have canned comments and cannot free form type</li>
	 * 	<li>Verify there is not a message box</li>
	 * 	<li>Verify there are canned comments</li>
	 * 	<li>Get the number of available canned comments</li>
	 * 	<li>Click Suggest a canned comment</li>
	 * 	<li>Switch to the new window</li>
	 * 	<li>Confirm the /Landing/RequestCannedComment.aspx page loads without error</li>
	 * 	<li>Verify text is correct</li>
	 * 	<li>Close the new window</li>
	 * 	<li>Switch to the original window</li>
	 * 	<li>From Secure as a user without compliance enabled</li>
	 * 	<li>View the details of the order</li>
	 * 	<li>Click Message</li>
	 * 	<li>Confirm you have canned comments and cannot free form type</li>
	 * 	<li>Click Suggest a canned comment</li>
	 * 	<li>Switch to the new window</li>
	 * 	<li>Confirm the /Landing/RequestCannedComment.aspx page loads without error</li>
	 * 	<li>Verify text is correct</li>
	 * 	<li>Close the new window</li>
	 * 	<li>Switch to the original window</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Vendor Selection Settings", "Secure - Create Order Via API", "Secure - Orders", "Vendors - Orders", "Vendors - Accept Order", "Vendors - Canned Comments", "Secure - Send Message", "Secure - Canned Comments"}, alwaysRun=true)
	public void requestCannedComments() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		String password = StoredVariables.getpassword().get();

		// Login to Secure
		secure.login(driver, userSecure, password);
		
		// Go to Vendor Selection Settings
		secure.goToVendorSelectionSettings(driver);
		
		// Enable Double Blind
		secure.switchOn(driver, SVendorSelectionSettings.doubleBlind_switch(driver));
		
		// Save settings
		secure.saveVendorSelectionSettings(driver);
		
		// Create an order to work with
		perform.apiPlaceOrderFromSecure(driver, userSecure, password, "PlaceMNOrder-RequestCannedComments");
		String trackingNumber = StoredVariables.gettrackingNumber().get();
		
		// Login to Secure
		secure.login(driver, userSecure, password);
		
		// Find and open the order
		secure.findAndOpenOrder(driver, trackingNumber);
		
		// Click Assign
		perform.click(driver,SOrderDetails.assign_btn(driver));
		
		// Wait for the Finish button
		perform.waitForElementToBeClickable(driver, SConfirmOrder.finishBottom_btn(driver));
		
		// Check I have read and understand the vendors fee
		perform.checkCheckbox(driver, SConfirmOrder.readVendorsFeeNotes_chkbx(driver));
		
		// Click Finish
		perform.click(driver,SConfirmOrder.finishBottom_btn(driver));
		
		// Login to vendors
		vendors.login(driver, userVendors, password);
		
		// View the details of the order
		vendors.findAndOpenOrder(driver, trackingNumber);
		
		// Click Accept
		perform.click(driver,VOrderDetails.acceptDecline_btn(driver));
		
		// Confirm you have canned comments and cannot free form type
		// Verify there is not a message box
		int message_txtbx = driver.findElements(By.id(VOrderAcknowledgement.messageToClient_txtbx())).size();
		Assert.assertTrue(message_txtbx==0, "There should not be a message box");
		
		// Verify there are canned comments
		// Get the number of available canned comments
		int numOfCannedComments = driver.findElements(By.cssSelector("#"+VOrderAcknowledgement.cannedComments_txt()+" > li > input")).size();
		Assert.assertTrue(numOfCannedComments > 0, "There should be canned comments");
		
		// Click Suggest a canned comment
		perform.click(driver,driver.findElement(By.linkText("Suggest a canned comment")));
		
		// Switch to the new window
		perform.switchToXSiteWindowByTitle(driver, "Canned Comment Suggestion");
		
		// Confirm the /Landing/RequestCannedComment.aspx page loads without error
		String cannedCommentURL = driver.getCurrentUrl();
		Assert.assertTrue(cannedCommentURL.contains("/Landing/RequestCannedComment.aspx?"), "The canned comment url is incorrect");
		
		// Verify text is correct
		String cannedCommentText = VCannedCommentSuggestion.text(driver).getText();
		String expectedText = "This feature is intended to provide a way to suggest universal comments that can be added to the system for all appraisers on Mercury Network. Suggestions containing any contact, property, or order specific information will not be accepted. Complete all required fields below, then click ‘Submit’ to send your suggestion. Once received, your comment suggestion will be reviewed. If accepted, your comment will become available in Mercury Network as a canned comment under the specified status.";
		Assert.assertTrue(cannedCommentText.contains(expectedText), "The text is incorrect on the Canned Comment Suggestion page. It should be - " + expectedText + "/n/n But it is = " + cannedCommentText);
		
		// Close the new window
		driver.close();
		
		// Switch to the original window
		driver.switchTo().window(StoredVariables.getwinHandleBefore().get());
		
		// From Secure as a user without compliance enabled
		secure.login(driver, userSecure, password);
		
		// View the details of the order
		secure.findAndOpenOrder(driver, trackingNumber);
		
		// Click Message
		perform.click(driver,SOrderDetails.message_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SOrderDetails.messageOk_btn(driver));
		
		// Confirm you have canned comments and cannot free form type
		message_txtbx = driver.findElements(By.id(SOrderDetails.sendMessage_txtbx())).size();
		Assert.assertTrue(message_txtbx==0, "There should not be a message box");
		
		// Click Suggest a canned comment
		perform.click(driver,driver.findElement(By.linkText("Suggest a canned comment")));
		
		// Switch to the new window
		perform.switchToXSiteWindowByTitle(driver, "Canned Comment Suggestion");
		
		// Confirm the /Landing/RequestCannedComment.aspx page loads without error
		cannedCommentURL = driver.getCurrentUrl();
		Assert.assertTrue(cannedCommentURL.contains("/Landing/RequestCannedComment.aspx?"), "The canned comment url is incorrect");
		
		// Verify text is correct
		cannedCommentText = SCannedCommentSuggestion.text(driver).getText();
		expectedText = "This feature is intended to provide a way to suggest universal comments that can be added to the system for all appraisers on Mercury Network. Suggestions containing any contact, property, or order specific information will not be accepted. Complete all required fields below, then click ‘Submit’ to send your suggestion. Once received, your comment suggestion will be reviewed. If accepted, your comment will become available in Mercury Network as a canned comment under the specified status.";
		Assert.assertTrue(cannedCommentText.contains(expectedText), "The text is incorrect on the Canned Comment Suggestion page. It should be - " + expectedText + "/n/n But it is = " + cannedCommentText);
		
		// Close the new window
		driver.close();
		
		// Switch to the original window
		driver.switchTo().window(StoredVariables.getwinHandleBefore().get());
		
		// Log test
		test.log(LogStatus.INFO, "Secure Regression Test", "Verified vendor who has marked Only accept from Fee Panel is in the list for Fee Panel clients");
		
	} // end requestCannedComments
	
} // end RequestCannedComments class
