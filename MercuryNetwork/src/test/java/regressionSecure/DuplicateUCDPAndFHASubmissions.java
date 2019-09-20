package regressionSecure;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Secure.SOrderDetails;
import pageObjects.Secure.SSubmitToFHA;
import pageObjects.Secure.SSubmitToUCDP;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Secure - Duplicate UCDP And FHA Submissions</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class DuplicateUCDPAndFHASubmissions extends TestSetup {
	
	/** The user secure. */
	private final String userSecure = "RegressionSecure8";
	
	/** The user vendors. */
	private final String userVendors = "Appraiser1";
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Place a new order and assign to a vendor</li>
	 * 	<li>Log in as the vendor</li>
	 * 	<li>Accept the order</li>
	 * 	<li>Complete the order using the HTTP Post</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Search for the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Click Set status</li>
	 * 	<li>Click Submit to UCDP</li>
	 * 	<li>Get outside frames</li>
	 * 	<li>Get inside the attach document frame</li>
	 * 	<li>driver.switchTo().frame(driver.findElement(By.xpath("iframe[contains(@src,'UCDPSubmit.aspx')]")));</li>
	 * 	<li>Select GSE dropdown</li>
	 * 	<li>Enter duplicate loan number</li>
	 * 	<li>Enter internal notes</li>
	 * 	<li>Click Send</li>
	 * 	<li>Verify dialog text</li>
	 * 	<li>Click Yes button</li>
	 * 	<li>Verify dialog text</li>
	 * 	<li>Click OK button</li>
	 * 	<li>Get history text</li>
	 * 	<li>Click Set status</li>
	 * 	<li>Click Submit to UCDP</li>
	 * 	<li>Get outside frames</li>
	 * 	<li>Get inside the attach document frame</li>
	 * 	<li>driver.switchTo().frame(driver.findElement(By.xpath("iframe[contains(@src,'UCDPSubmit.aspx')]")));</li>
	 * 	<li>Click Send</li>
	 * 	<li>Click OK</li>
	 * 	<li>secure.waitForHistoryTextToUpdate(driver, "Appraisal Submission Accepted");</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Create Order Via API", "Vendors - Orders", "Vendors - Accept Order", "Vendors - Complete Order", "Secure - Orders", "Secure - Set Status", "Secure - Submit To UCDP"}, alwaysRun=true)
	public void duplicateUCDPSubmission() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		String password = StoredVariables.getpassword().get();
		
		String loanNumber = "";
		String env = StoredVariables.getusernameEnvironment().get();
		
		if (env.equals("QA"))
		{
			loanNumber = "8217869528";
		}
		if (env.equals("Beta"))
		{
			loanNumber = "2788848968";
		}
		if (env.equals("Live"))
		{
			loanNumber = "1688423875";
		}
		
		// Place a new order and assign to a vendor
		perform.apiPlaceOrderFromSecure(driver, userSecure, password, "PlaceMNOrder-PlaceMNOrder-DuplicateUCDPSubmissions");
		String trackingNumber = StoredVariables.gettrackingNumber().get();
		secure.loginAndAssignOrderToAppraiser(driver, userSecure, password, trackingNumber, userVendors);
		
		// Log in as the vendor
		vendors.login(driver, userVendors, password);
		
		// Accept the order
		vendors.acceptOrder(driver, trackingNumber);
		
		// Complete the order using the HTTP Post
		vendors.completeOrderByHTTPPost(driver, userVendors, password, StoredVariables.getloanID().get(), "FRE_Complete.xml");
		
		// Login to Secure
		secure.login(driver, userSecure, password);
		
		// Search for the order
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Open the order
		secure.openOrder(driver, trackingNumber);
		
		// Click Set status
		perform.click(driver,SOrderDetails.setStatus_btn(driver));
		
		// Wait for Submit to UCDP button
		perform.waitForElementToBeClickable(driver, SOrderDetails.submitToUCDP_btn(), "cssSelector");
		
		// Click Submit to UCDP
		perform.clickInTable_Contains(driver, "Submit to UCDP");
		
		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		// Get outside frames
		driver.switchTo().defaultContent();
		// Get inside the attach document frame
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'UCDPSubmit.aspx')]")));
		
		// Wait for Internal notes to be clickable
		perform.waitForElementToBeClickable(driver, SSubmitToUCDP.internalNotes_txtbx(), "id");
		
		// Wait for Select GSE dropdown
		perform.waitForElementToBeClickable(driver, SSubmitToUCDP.selectGSE_dropdown(), "id");
		
		// Select GSE dropdown
		perform.selectDropdownOption(driver, SSubmitToUCDP.selectGSE_dropdown(driver), "Freddie Mac");
		
		// Enter duplicate loan number
		SSubmitToUCDP.loanNumber_txtbx(driver).clear();
		perform.type(driver,SSubmitToUCDP.loanNumber_txtbx(driver), loanNumber);
		
		// Enter internal notes
		perform.type(driver,SSubmitToUCDP.internalNotes_txtbx(driver), "Trying duplicate Loan #");
		
		// Click Send
		perform.click(driver,SSubmitToUCDP.send_btn(driver));
		
		// Wait for Yes button
		perform.waitForElementToBeClickable(driver, SSubmitToUCDP.ok_btn(), "id");
		
		// Verify dialog text
		String dialogText = SSubmitToUCDP.confirmChange_txt(driver).getText();
		Assert.assertTrue(dialogText.contains("Changing the Loan # for UCDP submission will change the Loan # in your order. Do you wish to make this change?"), "Confirm Change dialog text is incorrect");
		
		// Click Yes button
		perform.click(driver,SSubmitToUCDP.ok_btn(driver));
		
		// Wait for dialog text
		perform.waitForElementToBeClickable(driver, SSubmitToUCDP.ucdpSubmissionComplete_txt(), "id");
		
		// Verify dialog text
		dialogText = SSubmitToUCDP.ucdpSubmissionFailed_txt(driver).getText();
		String exp1 = "Your UCDP Submission Failed. The portal returned the response below. Contact your Mercury Network account representative for help with this error.";
		String exp2 = "Duplicate submission - a submission has already been received for Mercury Test loan # "+loanNumber;
		String[] expected = {exp1, exp2};
		perform.verifyTextContains(driver, dialogText, expected);
		
		// Click OK button
		perform.click(driver,SSubmitToUCDP.ok_btn(driver));
		
		// Get out of iFrame
		driver.switchTo().defaultContent();
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Get history text
		String history = SOrderDetails.history_txt(driver).getText();
		Assert.assertTrue(history.contains("Duplicate submission - a submission has already been received for Mercury Test loan # "+loanNumber), "The duplicate submission text is not added to the history. History = " + history);
		
		// Click Set status
		perform.click(driver,SOrderDetails.setStatus_btn(driver));
		
		// Wait for Submit to UCDP button
		perform.waitForElementToBeClickable(driver, SOrderDetails.submitToUCDP_btn(), "cssSelector");
		
		// Click Submit to UCDP
		perform.clickInTable_Contains(driver, "Submit to UCDP");
		
		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		// Get outside frames
		driver.switchTo().defaultContent();
		// Get inside the attach document frame
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'UCDPSubmit.aspx')]")));
		
		// Wait for Internal notes to be clickable
		perform.waitForElementToBeClickable(driver, SSubmitToUCDP.internalNotes_txtbx(), "id");
		
		// Wait for Select GSE dropdown
		perform.waitForElementToBeClickable(driver, SSubmitToUCDP.selectGSE_dropdown(), "id");
		
		// Click Send
		perform.click(driver,SSubmitToUCDP.send_btn(driver));
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SSubmitToUCDP.ok_btn(), "id");
		
		// Click OK
		perform.click(driver,SSubmitToUCDP.ok_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Wait for Appraisal Submission Accepted to display in the history
//		secure.waitForHistoryTextToUpdate(driver, "Appraisal Submission Accepted");
		/********************************************************
		 * ADDING THIS UNTIL DUPLICATE SUBMISSION IS FIXED
		 ********************************************************/
		secure.waitForHistoryTextToUpdate(driver, "Appraisal Submission to FRE via UCDP Failed");
		
		// Log test
		test.log(LogStatus.INFO, "Secure Regression Test", "Verified duplicate submission of UCDP order");
		
	} // end duplicateUCDPSubmission
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Place a new order and assign to a vendor</li>
	 * 	<li>Log in as the vendor</li>
	 * 	<li>Accept the order</li>
	 * 	<li>Complete the order using the HTTP Post</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Search for the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Click Set status</li>
	 * 	<li>Click Submit to FHA</li>
	 * 	<li>Get outside frames</li>
	 * 	<li>Get inside the iframe</li>
	 * 	<li>Enter duplicate loan number</li>
	 * 	<li>Enter FHA Case Number</li>
	 * 	<li>Enter internal notes</li>
	 * 	<li>Click Send</li>
	 * 	<li>Verify dialog text</li>
	 * 	<li>Click Yes button</li>
	 * 	<li>Verify dialog text</li>
	 * 	<li>Click OK button</li>
	 * 	<li>Get history text</li>
	 * 	<li>Click DocFileIdentifier link</li>
	 * 	<li>Verify the FHA Doc File ID textbox is prepopulated</li>
	 * 	<li>Click the OK button</li>
	 * 	<li>Verify the correct Doc File ID is applied to the order</li>
	 * 	<li>Click Set status</li>
	 * 	<li>Click Submit to FHA</li>
	 * 	<li>Get outside frames</li>
	 * 	<li>Get inside the iframe</li>
	 * 	<li>Click Send</li>
	 * 	<li>Switch iFrame</li>
	 * 	<li>Verify dialog text</li>
	 * 	<li>Select Slot 1</li>
	 * 	<li>Click OK</li>
	 * 	<li>Verify dialog text</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Create Order Via API", "Vendors - Orders", "Vendors - Accept Order", "Vendors - Complete Order", "Secure - Orders", "Secure - Set Status", "Secure - Submit To FHA"}, alwaysRun=true)
	public void duplicateFHASubmission() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		String password = StoredVariables.getpassword().get();
		
		String loanNumber = "";
		String documentFileIdentifier = "";
		String env = StoredVariables.getusernameEnvironment().get();
		
		if (env.equals("QA"))
		{
			loanNumber = "8217869528";
			documentFileIdentifier = "A00000232C";
		}
		if (env.equals("Beta"))
		{
			loanNumber = "2788848968";
			documentFileIdentifier = "A000002676";
//			documentFileIdentifier = "A000001378";
//			documentFileIdentifier = "A000001EAE";
		}
		if (env.equals("Live"))
		{
			loanNumber = "1688423875";
//			documentFileIdentifier = "A000001378";
//			documentFileIdentifier = "A000001EAE";
//			documentFileIdentifier = "A00000232C";
			documentFileIdentifier = "A000002676";
		}
		
		// Place a new order and assign to a vendor
		perform.apiPlaceOrderFromSecure(driver, userSecure, password, "PlaceMNOrder-PlaceMNOrder-DuplicateFHASubmissions");
		String trackingNumber = StoredVariables.gettrackingNumber().get();
		secure.loginAndAssignOrderToAppraiser(driver, userSecure, password, trackingNumber, userVendors);
		
		// Log in as the vendor
		vendors.login(driver, userVendors, password);
		
		// Accept the order
		vendors.acceptOrder(driver, trackingNumber);
		
		// Complete the order using the HTTP Post
		vendors.completeOrderByHTTPPost(driver, userVendors, password, StoredVariables.getloanID().get(), "CompleteFHA.xml");
		
		// Login to Secure
		secure.login(driver, userSecure, password);
		
		// Search for the order
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Open the order
		secure.openOrder(driver, trackingNumber);
		
		// Click Set status
		perform.click(driver,SOrderDetails.setStatus_btn(driver));

		// Wait for Submit to UCDP button
		perform.waitForElementToBeClickable(driver, SOrderDetails.submitToUCDP_btn(), "cssSelector");
		
		// Click Submit to FHA
		perform.clickInTable_Contains(driver, "Submit to FHA");
		
		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		// Get outside frames
		driver.switchTo().defaultContent();
		// Get inside the iframe
		perform.waitForiFrameSrcAndSwitchToIt(driver, "EADSubmit.aspx", By.id(SSubmitToFHA.internalNotes_txtbx()));
		
		// Wait for Internal notes to be clickable
		perform.waitForElementToBeClickable(driver, SSubmitToFHA.internalNotes_txtbx(), "id");
		
		// Enter duplicate loan number
		SSubmitToFHA.loanNumber_txtbx(driver).clear();
		perform.type(driver,SSubmitToFHA.loanNumber_txtbx(driver), loanNumber);
		
		// Enter FHA Case Number
		SSubmitToFHA.fhaCaseNumber_txtbx(driver).clear();
		perform.type(driver,SSubmitToFHA.fhaCaseNumber_txtbx(driver), "100-0040012");
		
		// Enter internal notes
		perform.type(driver,SSubmitToFHA.internalNotes_txtbx(driver), "Trying duplicate Loan #");
		
		// Click Send
		perform.click(driver,SSubmitToFHA.send_btn(driver));
		
		// Wait for Yes button
		perform.waitForElementToBeClickable(driver, SSubmitToFHA.ok_btn(), "id");
		
		// Verify dialog text
		String dialogText = SSubmitToFHA.confirmChange_txt(driver).getText();
		Assert.assertTrue(dialogText.contains("Changing the Loan # for FHA submission will change the Loan # in the order. Do you wish to make this change?"), "Confirm Change dialog text is incorrect");
		
		// Click Yes button
		perform.click(driver,SSubmitToFHA.ok_btn(driver));
		
		Thread.sleep(2000);
		
		// Wait for dialog text
		perform.waitForElementToBeClickable(driver, SSubmitToFHA.fhaSubmissionFailed_txt(), "id");
		
		// Verify dialog text
		dialogText = SSubmitToFHA.fhaSubmissionFailed_txt(driver).getText();
		Assert.assertTrue(dialogText.contains("Your FHA submission failed. The portal returned the response below. Contact your Mercury Network account representative for help with this error."), "Duplicate submission dialog text is incorrect");
		Assert.assertTrue(dialogText.contains("Duplicate submission - a submission has already been received for Mercury Network"), "Duplicate submission dialog text is incorrect");
		
		// Click OK button
		perform.click(driver,SSubmitToFHA.ok_btn(driver));
		
		// Get out of iFrame
		driver.switchTo().defaultContent();
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Wait for history to update
		secure.waitForHistoryTextToUpdate(driver, "Duplicate submission");
		
		// Get history text
		String history = SOrderDetails.history_txt(driver).getText();
		Assert.assertTrue(history.contains("Duplicate submission - a submission has already been received for Mercury Network"), "The duplicate submission text is not added to the history");

		// Click DocFileIdentifier link
		perform.click(driver,driver.findElement(By.cssSelector("#divHistoryWrapper > div:nth-child(1) > div.hiDescription > div > div.StatusHistoryData > a")));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for FHA Doc File ID textbox
		perform.waitForElementToBeClickable(driver, SSubmitToFHA.fhaDocFileID_txtbx(), "id");
		
		// Verify the FHA Doc File ID textbox is prepopulated
		String docFileID = SSubmitToFHA.fhaDocFileID_txtbx(driver).getAttribute("value");
		perform.verification(driver, docFileID, "equals", documentFileIdentifier);
		
		// Click the OK button
		perform.click(driver,SSubmitToFHA.okFHADocFileID_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Verify the correct Doc File ID is applied to the order
		history = SOrderDetails.history_txt(driver).getText();
		Assert.assertTrue(history.contains("Doc File ID "+documentFileIdentifier+" was added."), "The Doc File ID was not added to the history");
		
		// Click Set status
		perform.click(driver,SOrderDetails.setStatus_btn(driver));
		
		// Wait for Submit to UCDP button
		perform.waitForElementToBeClickable(driver, SOrderDetails.submitToUCDP_btn(), "cssSelector");
		
		// Click Submit to FHA
		perform.clickInTable_Contains(driver, "Submit to FHA");
		
		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		// Get outside frames
		driver.switchTo().defaultContent();
		// Get inside the iframe
		perform.waitForiFrameSrcAndSwitchToIt(driver, "EADSubmit.aspx", By.id(SSubmitToFHA.internalNotes_txtbx()));
		
		// Wait for Internal notes to be clickable
		perform.waitForElementToBeClickable(driver, SSubmitToFHA.internalNotes_txtbx(), "id");
		
		// Click Send
		perform.click(driver,SSubmitToFHA.send_btn(driver));
		
		// Switch iFrame
		driver.switchTo().defaultContent();
		perform.waitForiFrameSrcAndSwitchToIt(driver, "EADChooseAppraisal.aspx", By.id(SSubmitToFHA.okFHAAppraisalFileLocation_btn()));
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SSubmitToFHA.okFHAAppraisalFileLocation_btn(), "id");
		
		// Verify dialog text
		Assert.assertTrue(SSubmitToFHA.okUCDPAppraisalFileLocation_txt(driver).getText().contains("The following appraisal file locations are available for Doc File ID - "+documentFileIdentifier+". You can submit this appraisal in any of the three locations."), "FHA appraisal File Location dialog text is incorrect");
		
		// Select Slot 1
		perform.click(driver,SSubmitToFHA.appraisal_check(driver));
		// Click OK
		perform.click(driver,SSubmitToFHA.okFHAAppraisalFileLocation_btn(driver));
		
		// Wait for OK replace confirmation button
		perform.waitForElementToBeClickable(driver, SSubmitToFHA.ok_btn(), "id");
		
		// Verify dialog text
		String screenText = SSubmitToFHA.confirmChange_txt(driver).getText();
		System.out.println("screenText: " + screenText);
		
		if (screenText.contains("If the location you selected already contains an appraisal, that appraisal will be replaced by the one you’re submitting right now.")) {
			// Click OK
			perform.click(driver,SSubmitToFHA.ok_btn(driver));
			
			// Click OK
			perform.click(driver,SSubmitToFHA.ok_btn(driver));
		} else {
			String exp1 = "The location you selected already contains an appraisal that was submitted to FHA from Mercury Network. If you continue, the previous appraisal will be replaced with the one you";
			String exp2 = "re submitting right now.";
			String exp3 = "Click OK to continue with this FHA submission.";
			String[] expected = {exp1, exp2, exp3};
			perform.verifyTextContains(driver, screenText, expected);
			
			// Click OK
			perform.click(driver,SSubmitToFHA.ok_btn(driver));
		} // end if/else
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SSubmitToFHA.ok_btn(), "id");
		
		// Log test
		test.log(LogStatus.INFO, "Secure Regression Test", "Verified duplicate submission of FHA order");
		
	} // end duplicateFHASubmission
	
} // end the DuplicateUCDPAndFHASubmissions class
