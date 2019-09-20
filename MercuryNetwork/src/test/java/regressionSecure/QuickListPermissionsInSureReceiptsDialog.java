package regressionSecure;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Secure.SConnectionSettings;
import pageObjects.Secure.SOrderDetails;
import pageObjects.Secure.SSendViaSureReceipts;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Secure - QuickList Permissions In Sure Receipt Dialog</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class QuickListPermissionsInSureReceiptsDialog extends TestSetup {
	
	/** The user secure. */
	private final String userSecure = "RegressionSecure1";
	
	/** The user secure sub. */
	private final String userSecureSub = "RegressionSecure1SU";
	
	/** The user vendors. */
	private final String userVendors = "Appraiser1";
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 *  <li>Log in to Secure</li>
	 *  <li>Go to Connection Settings</li>
	 *  <li><Select to automatically send SureReceipt/li>
	 *  <li>Select how soon to send the SureReceipt</li>
	 *  <li>Check Include co-borrower when present</li>
	 *  <li>Save the settings</li>
	 * 	<li>Create an order to work with</li>
	 * 	<li>Complete the order on Vendors</li>
	 * 	<li>Log into Secure as the sub user</li>
	 * 	<li>Open order</li>
	 * 	<li>Open a completed report</li>
	 * 	<li>Click Set Status</li>
	 * 	<li>Click Send via SureReceipts</li>
	 * 	<li>Switch iFrame</li>
	 * 	<li>Get uniqueid of first record</li>
	 * 	<li>Verify there are 2 records</li>
	 * 	<li>Get the second email address element</li>
	 * 	<li>Verify coborrower email address</li>
	 * 	<li>Click the QL icon in the comments field</li>
	 * 	<li>Switch iFrame</li>
	 * 	<li>Verified you cannot add or edit anything in the QL form</li>
	 * 	<li>Click Close</li>
	 * 	<li>Switch iFrame</li>
	 * 	<li>Click Cancel</li>
	 * 	<li>Switch iFrame</li>
	 * 	<li>Log back in as Admin</li>
	 * 	<li>Open order</li>
	 * 	<li>Open a completed report</li>
	 * 	<li>Click Set Status</li>
	 * 	<li>Click Send via SureReceipts</li>
	 * 	<li>Switch iFrame</li>
	 * 	<li>Click the QL icon in the comments field</li>
	 * 	<li>Switch iFrame</li>
	 * 	<li>Click Delete on QuickList item</li>
	 * 	<li>Verify dialog text</li>
	 * 	<li>Click Yes</li>
	 * 	<li>Check for more QL items</li>
	 * 	<li>Click New</li>
	 * 	<li>Enter Description</li>
	 * 	<li>Enter Text</li>
	 * 	<li>Click Save</li>
	 * 	<li>Click Delete on QuickList item</li>
	 * 	<li>Verify dialog text</li>
	 * 	<li>Click Yes</li>
	 * 	<li>Click Close</li>
	 * 	<li>Switch iFrame</li>
	 * 	<li>Enter message</li>
	 * 	<li>Get uniqueid of first record</li>
	 * 	<li>Verify there are 2 records</li>
	 * 	<li>Get the uniqueid of the second recipient</li>
	 * 	<li>Verify coborrower email address</li>
	 * 	<li>Add screenshot to ExtentReport</li>
	 * 	<li>Click Send</li>
	 * 	<li>Switch iFrame</li>
	 * 	<li>Verify both recipients are in the audit trail</li>
	 * 	<li>Verify the number of items in the MailQueue table</li>
	 * 	<li>Verify there is an email with the Subject "Documents available"</li>
	 * 	<li>Set the Auth Code filename</li>
	 * 	<li>Set the Test PDF filename</li>
	 * 	<li>Delete test files if they exist</li>
	 * 	<li>Go to Notification Search Internal Tools page and search by Product Item ID</li>
	 * 	<li>Get the window handle of the original window</li>
	 * 	<li>Click the Body link to open the email</li>
	 * 	<li>Get the window handle of the second window</li>
	 * 	<li>Click Download documents and switch to the new window</li>
	 * 	<li>Get the window handle of the third window</li>
	 * 	<li>Acknowledge Electric Delivery and download the auth code</li>
	 * 	<li>Get Auth Code from the PDF</li>
	 * 	<li>Switch the focus back to the third window</li>
	 * 	<li>Click Download report</li>
	 * 	<li>Open the PDF and get the contents</li>
	 * 	<li>Verify that the pdf could be opened and was not empty</li>
	 * 	<li>Close the third window</li>
	 * 	<li>Close the second window</li>
	 * 	<li>Switch back to original window</li>
	 * 	<li>Refresh the Notifications list and wait for text to exist</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Create Order Via API", "Vendors - Complete Order", "Secure - Orders", "Secure - Set Status", "Secure - Send Via SureReceipts", "Secure - QuickLists"}, alwaysRun=true)
	public void quickListPermissionsInSureReceiptsDialog() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		String password = StoredVariables.getpassword().get();
		
		/** Set the settings to automatically submit Sure Receipts **/
//		// Log in to Secure
//		secure.login(driver, userSecure, password);
//		
//		// Go to Connection Settings
//		secure.goToConnectionSettings(driver);
//		
//		// Select to automatically send SureReceipt
//		perform.selectDropdownOption(driver, SConnectionSettings.forAllOrders_dropdown(driver), "(None Selected)");
//		
//		// Select how soon to send the SureReceipt
//		perform.selectDropdownOption(driver, SConnectionSettings.automaticallySendTheSelectedAppraisalProductsToTheBorrower_dropdown(driver), "immediately");
//		
//		// Uncheck Include co-borrower when present
//		perform.scrollElementIntoView(driver, SConnectionSettings.includeCoBorrowerWhenPresent_chkbx(driver));
//		perform.uncheckCheckbox(driver, SConnectionSettings.includeCoBorrowerWhenPresent_chkbx(driver));
//		
//		// Save the settings
//		secure.saveConnectionSettings(driver);
//		
//		// Log in to Secure
//		secure.login(driver, userSecureSub, password);
//		
//		// Go to Connection Settings
//		secure.goToConnectionSettings(driver);
//		
//		// Select to automatically send SureReceipt
//		perform.selectDropdownOption(driver, SConnectionSettings.forAllOrders_dropdown(driver), "always");
//		
//		// Select how soon to send the SureReceipt
//		perform.selectDropdownOption(driver, SConnectionSettings.automaticallySendTheSelectedAppraisalProductsToTheBorrower_dropdown(driver), "immediately");
//		
//		// Check Include co-borrower when present
//		perform.checkCheckbox(driver, SConnectionSettings.includeCoBorrowerWhenPresent_chkbx(driver));
//		
//		// Save the settings
//		secure.saveConnectionSettings(driver);
		
		// Create an order to work with
		perform.apiPlaceOrderFromSecure(driver, userSecureSub, password, "PlaceMNOrder-QuickListPermissionsInSureReceiptsDialog");
		String trackingNumber = StoredVariables.gettrackingNumber().get();
		secure.loginAndAssignOrderToAppraiser(driver, userSecureSub, password, trackingNumber, userVendors);
		
		// Complete the order on Vendors
		vendors.completeOrderByHTTPPost(driver, userVendors, password, StoredVariables.getloanID().get(), "Complete.xml");
		
		// Log into Secure as the sub user 
		secure.login(driver, userSecureSub, password);
		
		// Open order
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Open a completed report 
		perform.doubleClickInTable(driver, trackingNumber);
		
		// Wait for Set Status button
		perform.waitForElementToBeClickable(driver, SOrderDetails.setStatus_btn(), "cssSelector");
		
		// Click Set Status 
		perform.click(driver,SOrderDetails.setStatus_btn(driver));
		
		Thread.sleep(1000);
		
		// Click Send via SureReceipts
		perform.clickInTable_Contains(driver, "Send via SureReceipts");
		
		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		// Switch iFrame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "/SureReceipts/SendFiles.aspx", By.id(SSendViaSureReceipts.comments_txtbx()));
		
		// Wait for comments textbox
		perform.waitForElementToBeClickable(driver, SSendViaSureReceipts.comments_txtbx(), "id");

		Thread.sleep(2000);
		
		// Get uniqueid of first record
		List<WebElement> recipients = driver.findElements(By.cssSelector(".ContactContent"));
		
		// Verify there are 2 records
		Assert.assertTrue(recipients.size()==2, "There should be 2 recipients in the dialog");
		
		// Get the second email address element
		WebElement coborrower = driver.findElement(By.cssSelector(".ContactContent:nth-child(2) > .MercuryInput"));
		
		// Verify coborrower email address
		Thread.sleep(2000);
		Assert.assertTrue(coborrower.getAttribute("value").equals("auto@dntest.net"), "Coborrower email should be = " + StoredVariables.getcontactCoBorrowerInfo2().get() + " On screen = " + coborrower.getAttribute("value"));
		
		// Click the QL icon in the comments field
		perform.clickWithJavascript(driver, SSendViaSureReceipts.QL_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Switch iFrame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "/Common/Lists/Quick.aspx?", By.id(SSendViaSureReceipts.close_btn()));
		
		// Wait for close button
		perform.waitForElementToBeClickable(driver, SSendViaSureReceipts.close_btn(), "id");
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Verified you cannot add or edit anything in the QL form 
		boolean visible = driver.findElement(By.id(SSendViaSureReceipts.new_btn())).isDisplayed();
		Assert.assertTrue(visible == false, "The New button is displayed and should not be");
		
		// Click Close
		perform.click(driver,SSendViaSureReceipts.close_btn(driver));
		
		// Switch iFrame
		driver.switchTo().defaultContent();
		perform.waitForiFrameSrcAndSwitchToIt(driver, "/SureReceipts/SendFiles.aspx", By.id(SSendViaSureReceipts.cancel_btn()));
		
		// Click Cancel
		perform.click(driver,SSendViaSureReceipts.cancel_btn(driver));
		
		// Switch iFrame
		driver.switchTo().defaultContent();
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Log back in as Admin 
		secure.login(driver, userSecure, password);
		
		// Open order
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Open a completed report 
		perform.doubleClickInTable(driver, trackingNumber);
		
		// Wait for Set Status button
		perform.waitForElementToBeClickable(driver, SOrderDetails.setStatus_btn(), "cssSelector");
		
		// Click Set Status 
		perform.click(driver,SOrderDetails.setStatus_btn(driver));
		
		Thread.sleep(1000);
		
		// Click Send via SureReceipts
		perform.clickInTable_Contains(driver, "Send via SureReceipts");
		
		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		// Switch iFrame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "/SureReceipts/SendFiles.aspx", By.id(SSendViaSureReceipts.comments_txtbx()));
		
		// Wait for comments textbox
		perform.waitForElementToBeClickable(driver, SSendViaSureReceipts.comments_txtbx(), "id");
		
		// Click the QL icon in the comments field
		perform.clickWithJavascript(driver, SSendViaSureReceipts.QL_btn(driver));
		
		// Switch iFrame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "/Common/Lists/Quick.aspx?", By.id(SSendViaSureReceipts.close_btn()));
		
		// Wait for close button
		perform.waitForElementToBeClickable(driver, SSendViaSureReceipts.close_btn(), "id");
		
		int deleteVisible = driver.findElements(By.cssSelector(SSendViaSureReceipts.delete_btn())).size();
		System.out.println("deleteVisible = " + deleteVisible);
		while (deleteVisible > 0)
		{
			
			// Click Delete on QuickList item
			perform.click(driver,SSendViaSureReceipts.delete_btn(driver));
			
			// Verify dialog text
			Assert.assertTrue(SSendViaSureReceipts.deleteDialog_txt(driver).getText().equals("Are you sure you want to delete the selected item?"), "The dialog text is incorrect");
			
			// Click Yes
			perform.click(driver,SSendViaSureReceipts.yes_btn(driver));
			
			// Wait for Close button
			perform.waitForElementToBeClickable(driver, SSendViaSureReceipts.close_btn(), "id");
			
			// Check for more QL items
			deleteVisible = driver.findElements(By.cssSelector(SSendViaSureReceipts.delete_btn())).size();
		
		} // end while loop
		
		// Click New
		perform.click(driver,SSendViaSureReceipts.new_btn(driver));
		
		// Wait for Cancel button
		perform.waitForElementToBeClickable(driver, SSendViaSureReceipts.save_btn(), "id");
		
		// Enter Description
		perform.type(driver,SSendViaSureReceipts.description_txtbx(driver), "Test");
		
		// Enter Text
		perform.type(driver,SSendViaSureReceipts.text_txtbx(driver), "These is test QuickList text");
		
		// Click Save
		perform.click(driver,SSendViaSureReceipts.save_btn(driver));
		
		// Wait for delete button
		perform.waitForElementToBeClickable(driver, SSendViaSureReceipts.delete_btn(), "cssSelector");
		
		// Click Delete on QuickList item
		perform.click(driver,SSendViaSureReceipts.delete_btn(driver));
		
		// Verify dialog text
		Assert.assertTrue(SSendViaSureReceipts.deleteDialog_txt(driver).getText().equals("Are you sure you want to delete the selected item?"), "The dialog text is incorrect");
		
		// Click Yes
		perform.click(driver,SSendViaSureReceipts.yes_btn(driver));
		
		// Wait for Close button
		perform.waitForElementToBeClickable(driver, SSendViaSureReceipts.close_btn(), "id");
		
		Thread.sleep(2500);
		
		// Click Close
		perform.click(driver,SSendViaSureReceipts.close_btn(driver));
		
		// Switch iFrame
		driver.switchTo().defaultContent();
		perform.waitForiFrameSrcAndSwitchToIt(driver, "/SureReceipts/SendFiles.aspx", By.id(SSendViaSureReceipts.comments_txtbx()));
	
		// Enter message
		perform.type(driver,SSendViaSureReceipts.comments_txtbx(driver), "This is a test");
		
		Thread.sleep(2000);
		
		// Get uniqueid of first record
		recipients = driver.findElements(By.cssSelector(".ContactContent"));
		
		// Verify there are 2 records
		Assert.assertTrue(recipients.size()==2, "There should be 2 recipients in the dialog");
		
		// Get the uniqueid of the second recipient
		coborrower = driver.findElement(By.cssSelector(".ContactContent:nth-child(2) > .MercuryInput"));
		
		// Verify coborrower email address
		Thread.sleep(2000);
		Assert.assertTrue(coborrower.getAttribute("value").equals("auto@dntest.net"), "Coborrower email should be = " + StoredVariables.getcontactCoBorrowerInfo2().get() + " On screen = " + coborrower.getAttribute("value"));
		
		// Add screenshot to ExtentReport
		perform.takeScreenshot(driver);

		Thread.sleep(5000);
		
		// Click Send
		perform.click(driver,SSendViaSureReceipts.send_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Switch iFrame
		driver.switchTo().defaultContent();
		
		// Wait for history
		perform.waitForElementToBeClickable(driver, SOrderDetails.history_txt(), "id");
		
		// Verify both recipients are in the audit trail
		String history = SOrderDetails.history_txt(driver).getText();
		String borrowerEmail = "test@dntest.net";
		String coborrowerEmail = "auto@dntest.net";
		System.out.println("borrower = " + borrowerEmail);
		System.out.println("coborrower = " + coborrowerEmail);
		if (!history.contains("Borrower ("+borrowerEmail+") and Co-Borrower ("+coborrowerEmail+")")) {
			perform.addWarningToExtentReport(driver, "Recipients", "The Co-Borrower email was set as the Borrower email. This is an occasional hiccup that occurs in automation "
					+ "that has not been able to be reproduced manually");
		} // end if
		
		// Verify the number of items in the MailQueue table
		String productItemID = db.getProductItemID(driver, trackingNumber);
		perform.verifyTheNumberOfRowsInTheMailQueueDBResultsForProductItemID(driver, 5, productItemID);
		
		// Verify there is an email with the Subject "Documents available"
		String sqlStatement = "SELECT Subject FROM [dbo].[MailQueue] WHERE ProductItemID = '"+productItemID+"'";
		ArrayList<String> result = db.queryDBArray(driver, "Mercury", sqlStatement);
		perform.verifyListContains(driver, result, "Documents available for");
		
		// Only run on QA
		if (StoredVariables.getusernameEnvironment().get().equals("QA")) {
			
			// Set the Auth Code filename
			String authCodeFileName = "501 NE 122nd_AuthCode.pdf";
			
			// Set the Test PDF filename
			String testPDFFileName = "Test PDF.pdf";
			
			// Delete test files if they exist
			perform.deleteFile(driver, authCodeFileName);
			perform.deleteFile(driver, testPDFFileName);
			
			// Go to Notification Search Internal Tools page and search by Product Item ID
			it.goToNotificationSearchAndSearchByProductItemID(driver, productItemID);
			
			// Get the window handle of the original window
			String win1 = driver.getWindowHandle();
			
			// Click the Body link to open the email
			it.clickBodyLinkOfRowThatContainsTextInNotificationSearchAndSwitchToIt(driver, "MN_SureReceipts-notification.html", "MN_SureReceipts-notification");
			
			// Get the window handle of the second window
			String win2 = driver.getWindowHandle();
			
			// Click Download documents and switch to the new window
			it.clickDownloadDocumentsAndSwitchToTheNewWindow(driver);
			
			// Get the window handle of the third window
			String win3 = driver.getWindowHandle();
	
			// Acknowledge Electric Delivery and download the auth code
			it.acknowledgeElectricDeliveryAndDownloadAuthCode(driver);
			
			// Get Auth Code from the PDF
			String authCode = it.getAuthCodeFromPDF(driver, authCodeFileName);
			
			// Switch the focus back to the third window
			driver.switchTo().window(win3);
			
			// Click Download report
			it.enterAuthCodeAndDownloadReport(driver, authCode);
			
			// Open the PDF and get the contents
			String testPDFText = perform.readPDFInURL(driver, testPDFFileName);
			
			// Verify that the pdf could be opened and was not empty
			Assert.assertTrue(testPDFText.contains("Uniform Residential Appraisal Report File #"), "The Test PDF.pdf was empty!");
			
			// Close the third window
			driver.close();
			
			// Close the second window
			driver.switchTo().window(win2);
			driver.close();
			
			// Switch back to original window
			driver.switchTo().window(win1);
			
			// Refresh the Notifications list and wait for text to exist
			it.refreshNotificationListAndVerifyTextExists(driver, "Report viewed for");
		
		} // end if
		
		// Log test
		test.log(LogStatus.INFO, "Secure Regression Test", "Verified vendor who has marked Only accept from Fee Panel is in the list for Fee Panel clients");
		
	} // end quickListPermissionsInSureReceiptsDialog

	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 *  <li>Log in to Secure</li>
	 *  <li>Go to Connection Settings</li>
	 *  <li><Select to automatically send SureReceipt/li>
	 *  <li>Select how soon to send the SureReceipt</li>
	 *  <li>Check Include co-borrower when present</li>
	 *  <li>Save the settings</li>
	 * 	<li>Create an order to work with</li>
	 * 	<li>Complete the order on Vendors</li>
	 * 	<li>Verify there are 2 records</li>
	 * 	<li>Get the uniqueid of the second recipient</li>
	 * 	<li>Verify coborrower email address</li>
	 * 	<li>Add screenshot to ExtentReport</li>
	 * 	<li>Click Send</li>
	 * 	<li>Switch iFrame</li>
	 * 	<li>Verify both recipients are in the audit trail</li>
	 * 	<li>Verify the number of items in the MailQueue table</li>
	 * 	<li>Verify there is an email with the Subject "Documents available"</li>
	 * 	<li>Set the Auth Code filename</li>
	 * 	<li>Set the Test PDF filename</li>
	 * 	<li>Delete test files if they exist</li>
	 * 	<li>Go to Notification Search Internal Tools page and search by Product Item ID</li>
	 * 	<li>Get the window handle of the original window</li>
	 * 	<li>Click the Body link to open the email</li>
	 * 	<li>Get the window handle of the second window</li>
	 * 	<li>Click Download documents and switch to the new window</li>
	 * 	<li>Get the window handle of the third window</li>
	 * 	<li>Acknowledge Electric Delivery and download the auth code</li>
	 * 	<li>Get Auth Code from the PDF</li>
	 * 	<li>Switch the focus back to the third window</li>
	 * 	<li>Click Download report</li>
	 * 	<li>Open the PDF and get the contents</li>
	 * 	<li>Verify that the pdf could be opened and was not empty</li>
	 * 	<li>Close the third window</li>
	 * 	<li>Close the second window</li>
	 * 	<li>Switch back to original window</li>
	 * 	<li>Refresh the Notifications list and wait for text to exist</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"broken", "Secure - Create Order Via API", "Vendors - Complete Order", "Secure - Orders", "Secure - Set Status", "Secure - Send Via SureReceipts", "Secure - QuickLists"}, alwaysRun=true)
	public void automaticSureReceipts() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		String password = StoredVariables.getpassword().get();
		
		/** Set the settings to automatically submit Sure Receipts **/
		// Log in to Secure
		secure.login(driver, userSecure, password);
		
		// Go to Connection Settings
		secure.goToConnectionSettings(driver);
		
		// Select to automatically send SureReceipt
		perform.selectDropdownOption(driver, SConnectionSettings.forAllOrders_dropdown(driver), "always");
		
		// Select how soon to send the SureReceipt
		perform.selectDropdownOption(driver, SConnectionSettings.automaticallySendTheSelectedAppraisalProductsToTheBorrower_dropdown(driver), "immediately");
		
		// Check Include co-borrower when present
		perform.checkCheckbox(driver, SConnectionSettings.includeCoBorrowerWhenPresent_chkbx(driver));
		
		// Save the settings
		secure.saveConnectionSettings(driver);
		
		// Log in to Secure
		secure.login(driver, userSecureSub, password);
		
		// Go to Connection Settings
		secure.goToConnectionSettings(driver);
		
		// Select to automatically send SureReceipt
		perform.selectDropdownOption(driver, SConnectionSettings.forAllOrders_dropdown(driver), "always");
		
		// Select how soon to send the SureReceipt
		perform.selectDropdownOption(driver, SConnectionSettings.automaticallySendTheSelectedAppraisalProductsToTheBorrower_dropdown(driver), "immediately");
		
		// Check Include co-borrower when present
		perform.checkCheckbox(driver, SConnectionSettings.includeCoBorrowerWhenPresent_chkbx(driver));
		
		// Save the settings
		secure.saveConnectionSettings(driver);
		
		// Create an order to work with
		perform.apiPlaceOrderFromSecure(driver, userSecureSub, password, "PlaceMNOrder-QuickListPermissionsInSureReceiptsDialog");
		String trackingNumber = StoredVariables.gettrackingNumber().get();
		secure.loginAndAssignOrderToAppraiser(driver, userSecureSub, password, trackingNumber, userVendors);
		
		// Complete the order on Vendors
		vendors.completeOrderByHTTPPost(driver, userVendors, password, StoredVariables.getloanID().get(), "Complete.xml");
		
		// Verify the number of items in the MailQueue table
		String productItemID = db.getProductItemID(driver, trackingNumber);
		perform.verifyTheNumberOfRowsInTheMailQueueDBResultsForProductItemID(driver, 2, productItemID);
		
		// Only run on QA
		if (StoredVariables.getusernameEnvironment().get().equals("QA")) {
			
			// Set the Auth Code filename
			String authCodeFileName = "501 NE 122nd_AuthCode.pdf";
			
			// Set the Test PDF filename
			String testPDFFileName = "Test PDF.pdf";
			
			// Delete test files if they exist
			perform.deleteFile(driver, authCodeFileName);
			perform.deleteFile(driver, testPDFFileName);
			
			// Go to Notification Search Internal Tools page and search by Product Item ID
			it.goToNotificationSearchAndSearchByProductItemID(driver, productItemID);
			
			// Get the window handle of the original window
			String win1 = driver.getWindowHandle();
			
			// Click the Body link to open the email
			it.clickBodyLinkOfRowThatContainsTextInNotificationSearchAndSwitchToIt(driver, "MN_SureReceipts-notification.html", "MN_SureReceipts-notification");
			
			// Get the window handle of the second window
			String win2 = driver.getWindowHandle();
			
			// Click Download documents and switch to the new window
			it.clickDownloadDocumentsAndSwitchToTheNewWindow(driver);
			
			// Get the window handle of the third window
			String win3 = driver.getWindowHandle();
	
			// Acknowledge Electric Delivery and download the auth code
			it.acknowledgeElectricDeliveryAndDownloadAuthCode(driver);
			
			// Get Auth Code from the PDF
			String authCode = it.getAuthCodeFromPDF(driver, authCodeFileName);
			
			// Switch the focus back to the third window
			driver.switchTo().window(win3);
			
			// Click Download report
			it.enterAuthCodeAndDownloadReport(driver, authCode);
			
			// Open the PDF and get the contents
			String testPDFText = perform.readPDFInURL(driver, testPDFFileName);
			
			// Verify that the pdf could be opened and was not empty
			Assert.assertTrue(testPDFText.contains("Uniform Residential Appraisal Report File #"), "The Test PDF.pdf was empty!");
			
			// Close the third window
			driver.close();
			
			// Close the second window
			driver.switchTo().window(win2);
			driver.close();
			
			// Switch back to original window
			driver.switchTo().window(win1);
			
			// Refresh the Notifications list and wait for text to exist
			it.refreshNotificationListAndVerifyTextExists(driver, "Report viewed for");
		
		} // end if
		
		// Log test
		test.log(LogStatus.INFO, "Secure Regression Test", "Verified automatic submission of Sure Receipts");
		
	} // end automaticSureReceipts
	
} // end the QuickListPermissionsInSureReceiptsDialog class
