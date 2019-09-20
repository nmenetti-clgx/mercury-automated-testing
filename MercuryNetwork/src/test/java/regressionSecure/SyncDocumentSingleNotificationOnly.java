package regressionSecure;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Secure.SConfirmOrder;
import pageObjects.Secure.SOrderDetails;
import pageObjects.Secure.SVMPXSites;
import pageObjects.VMP.VMPAppraisalOrderDetails;
import pageObjects.VMP.VMPConfirmOrder;
import pageObjects.VMP.VMPNewOrder;
import pageObjects.VMP.VMPOrders;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Secure - Sync Document Single Notification Only</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class SyncDocumentSingleNotificationOnly extends TestSetup {
	
	/** The user secure. */
	private final String userSecure = "Sync2";
	
	/** The user VMP. */
	private final String userVMP = "OriginatorSync2";
	
	/** The user vendors. */
	private final String userVendors = "Appraiser1";
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Initialize variables</li>
	 * 	<li>Set the variables</li>
	 * 	<li>Set the server address per the environment</li>
	 * 	<li>Set preferences and enable all status mapping</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Go to VMPXSites</li>
	 * 	<li>Click on Configure Status Mapping</li>
	 * 	<li>Enable all sync status options</li>
	 * 	<li>Click Save</li>
	 * 	<li>Log into the Lender's VMP Client portal</li>
	 * 	<li>Place a new order, make sure to attach documents to the order BEFORE finishing it</li>
	 * 	<li>Set variables</li>
	 * 	<li>Go to New Order</li>
	 * 	<li>Enter order details</li>
	 * 	<li>Click Next</li>
	 * 	<li>Save the order</li>
	 * 	<li>(I would attach several different types of docs. Sales Contract, Tax Document, etc)</li>
	 * 	<li>Set first int for the attach icon element (pbAttach0_Icon)</li>
	 * 	<li>Upload Sales Contract</li>
	 * 	<li>Upload Condo HOA Cert</li>
	 * 	<li>Upload Hazard Disclosure</li>
	 * 	<li>Upload Other</li>
	 * 	<li>Upload Preliminary Title Report</li>
	 * 	<li>perform.selectDropdownOption(driver, VMPConfirmOrder.documentType_dropdown(driver), "Preliminary Title Report");</li>
	 * 	<li>driver.findElement(By.cssSelector("input[type=file]"))</li>
	 * 	<li>waitForAttachmentComplete(driver, num);</li>
	 * 	<li>Thread.sleep(3000);</li>
	 * 	<li></li>
	 * 	<li>Upload Special Instructions</li>
	 * 	<li>perform.selectDropdownOption(driver, VMPConfirmOrder.documentType_dropdown(driver), "Special Instructions");</li>
	 * 	<li>driver.findElement(By.cssSelector("input[type=file]"))</li>
	 * 	<li>waitForAttachmentComplete(driver, num);</li>
	 * 	<li>Thread.sleep(3000);</li>
	 * 	<li></li>
	 * 	<li>Upload Statement of Engagement</li>
	 * 	<li>perform.selectDropdownOption(driver, VMPConfirmOrder.documentType_dropdown(driver), "Statement of Engagement");</li>
	 * 	<li>driver.findElement(By.cssSelector("input[type=file]"))</li>
	 * 	<li>waitForAttachmentComplete(driver, num);</li>
	 * 	<li>Thread.sleep(3000);</li>
	 * 	<li></li>
	 * 	<li>Upload Value Reconsideration</li>
	 * 	<li>perform.selectDropdownOption(driver, VMPConfirmOrder.documentType_dropdown(driver), "Value Reconsideration");</li>
	 * 	<li>driver.findElement(By.cssSelector("input[type=file]"))</li>
	 * 	<li>waitForAttachmentComplete(driver, num);</li>
	 * 	<li>Thread.sleep(3000);</li>
	 * 	<li>Click Finished</li>
	 * 	<li>Click OK</li>
	 * 	<li>Get order numbers</li>
	 * 	<li>Log into Secure as the Lender</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Verify the documents are attached and properly labeled</li>
	 * 	<li>Click Assign</li>
	 * 	<li>Assign the vendor</li>
	 * 	<li>Check read vendors fee notes</li>
	 * 	<li>Click Finish</li>
	 * 	<li>Log in as the Appraiser</li>
	 * 	<li>Complete the order</li>
	 * 	<li>Log in as lender</li>
	 * 	<li>Find order</li>
	 * 	<li>Open order</li>
	 * 	<li>Click Accept this report</li>
	 * 	<li>Check attach completed report</li>
	 * 	<li>Verify the documents are attached and properly labeled</li>
	 * 	<li>Click OK</li>
	 * 	<li>Click Save</li>
	 * 	<li>Get Product Item ID</li>
	 * 	<li>Verify MailQueue row count for this productItemID</li>
	 * 	<li>Query the database and return the results as an array</li>
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
	 * 	<li>Query the database and return the results as an array</li>
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
	 * 	<li>Log test</li>
	 * 	<li>Set 40 second while loop timeout</li>
	 * 	<li>increment the int for the next attachment icon element</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - VMP XSite Settings", "VMP - Create Order", "Secure - Orders", "Vendors - Orders", "Vendors - Complete Order"}, alwaysRun=true)
	public void syncDocumentSingleNotificationOnly() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Initialize variables
		String originatorEntityID = "";
		String xSiteEntityID = "";
		String env = "";
		String server = "";
		String vmpProductItemID = "";
		String secureProductItemID = "";
		
		/**************************************************************************
		 * Get EntityID's and Group ID's for SQL queries
		 **************************************************************************/
		
		env = StoredVariables.getusernameEnvironment().get();
		// Set the variables
		if (env.equals("QA"))
		{
			originatorEntityID = "1071271";
			xSiteEntityID = "1071269";
		} // end if QA
		if (env.equals("Beta"))
		{
			originatorEntityID = "5572236";
			xSiteEntityID = "5572231";
		} // end if Beta
		if (env.equals("Live"))
		{
			originatorEntityID = "5572237";
			xSiteEntityID = "5572233";
		} // end if Live
		
		// Set the server address per the environment
		if (StoredVariables.getenvironment().get().equals("Dev")) {
			server = "\\\\ss1qa.internal.ad.mercuryvmp.com\\Shared Storage\\MercuryEmailTemplates\\QA-Dev\\";
		} else {
			if (env.equals("QA")) {
				server = "\\\\ss1qa.internal.ad.mercuryvmp.com\\Shared Storage\\MercuryEmailTemplates\\QA\\";
			} if (env.equals("Beta") || env.equals("Live")) {
				server = "\\\\ss1.internal.ad.mercuryvmp.com\\Shared Storage\\MercuryEmailTemplates\\Production\\";
			}
		} // end if Live
		
		// Set preferences and enable all status mapping
		// Login to Secure
		secure.login(driver, userSecure, StoredVariables.getpassword().get());
		
		// Go to VMPXSites
		secure.goToVMPXSites(driver);
		
		// Click on Configure Status Mapping
		perform.click(driver,SVMPXSites.configureStatusMapping_lnk(driver));
		
		// Wait for element
		perform.waitForElementToBeVisible(driver, SVMPXSites.statusMappingConfiguration_txt(), "id");
		
		// Enable all sync status options
		perform.enableAllOptionsInStatusMappingConfiguration(driver);
		
		// Click Save
		perform.clickInTable_Contains(driver, "Save");
		
		// Wait for save dialog to be hidden 
		perform.waitForOverlayToBeHidden(driver);
		
		// Log into the Lender's VMP Client portal
		vmp.login(driver, userSecure, userVMP, StoredVariables.getpassword().get());
		
		// Place a new order, make sure to attach documents to the order BEFORE finishing it
		// Set variables
		vmp.setMinimumVariables(driver);
		StoredVariables.getadditionalNotificationRecipientsAdditionalEmails().set("additionalEmail@dntest.net");
		StoredVariables.getlenderInformationLenderName().set("Lender Name");
		StoredVariables.getcontactBorrower().set("Borrower Name");
		StoredVariables.getassignmentInformationLoanNumber().set(perform.randomNumbers(driver, 8));
		
		// Go to New Order
		vmp.goToNewOrder(driver);
		
		// Enter order details
		vmp.enterNewOrder(driver);
		
		// Click Next
		perform.click(driver,VMPNewOrder.nextBottom_btn(driver));
		
		// Save the order
		vmp.saveNewOrder(driver);
		
		// (I would attach several different types of docs. Sales Contract, Tax Document, etc)
		// Set first int for the attach icon element (pbAttach0_Icon)
		int num = 0;
		
		// Upload Sales Contract
		perform.selectDropdownOption(driver, VMPConfirmOrder.documentType_dropdown(driver), "Sales Contract");
		vmp.uploadDocumentOnAppraisalOrderDetails(driver, StoredVariables.getdocDir().get()+"SalesContract.pdf");
		waitForAttachmentComplete(driver, num);
		Thread.sleep(3000);
		
		// Upload Condo HOA Cert
		perform.selectDropdownOption(driver, VMPConfirmOrder.documentType_dropdown(driver), "Condo/HOA Cert");
		perform.type(driver, driver.findElement(By.cssSelector("input[type=file]")), StoredVariables.getdocDir().get()+"Condo HOA Cert.pdf");
		waitForAttachmentComplete(driver, num);
		Thread.sleep(3000);
		
		// Upload Hazard Disclosure
		perform.selectDropdownOption(driver, VMPConfirmOrder.documentType_dropdown(driver), "Hazard Disclosure");
		perform.type(driver, driver.findElement(By.cssSelector("input[type=file]")), StoredVariables.getdocDir().get()+"Hazard Disclosure.pdf");
		waitForAttachmentComplete(driver, num);
		Thread.sleep(3000);
		
		// Upload Other
		perform.selectDropdownOption(driver, VMPConfirmOrder.documentType_dropdown(driver), "Other");
		perform.type(driver, driver.findElement(By.cssSelector("input[type=file]")), StoredVariables.getdocDir().get()+"Other.pdf");
		waitForAttachmentComplete(driver, num);
		Thread.sleep(3000);
		
		// Click Finished
		perform.click(driver,VMPConfirmOrder.finished_btn(driver));
		
		// Switch out of iFrame
		driver.switchTo().defaultContent();
		
		// Click OK
		perform.click(driver,VMPConfirmOrder.ok_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Wait for Find textbox
		perform.waitForElementToBeClickable(driver, VMPOrders.find_txtbx(), "id");
		
		// Get order numbers
		db.getLoanIDsFromVMPClientPortalOrder(driver);
		String trackingNumber = StoredVariables.gettrackingNumber().get();
		
		// Log into Secure as the Lender
		secure.login(driver, "Sync2", StoredVariables.getpassword().get());
		
		// Find the order
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Open the order
		secure.openOrder(driver, trackingNumber);
		
		// Verify the documents are attached and properly labeled
		WebElement docsTable = driver.findElement(By.id("tblODFiles"));
		String docs = docsTable.getText();
		System.out.println("docs = " + docs);
		Assert.assertTrue(docs.contains("Order Documents"), "There are documents missing in Secure");
		Assert.assertTrue(docs.contains("Sales Contract"), "There are documents missing in Secure");
		Assert.assertTrue(docs.contains("Condo/HOA Cert"), "There are documents missing in Secure");
		Assert.assertTrue(docs.contains("Hazard Disclosure"), "There are documents missing in Secure");
		
		// Click Assign
		perform.click(driver,SOrderDetails.assign_btn(driver));
		
		// Assign the vendor
		secure.selectVendor(driver, "Appraiser1");
		
		// Check read vendors fee notes
		perform.checkCheckbox(driver, SConfirmOrder.readVendorsFeeNotes_chkbx(driver));
		
		// Click Finish
		perform.click(driver,SOrderDetails.finish_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Log in as the Appraiser
		vendors.login(driver, userVendors, StoredVariables.getpassword().get());
		
		// Accept the order
		vendors.acceptOrder(driver, trackingNumber);
		
		perform.sleep(driver, 10);

		// Complete the order
		vendors.completeOrderByHTTPPost(driver, userVendors, StoredVariables.getpassword().get(), StoredVariables.getloanID().get(), "Complete.xml");
		
		// Log in as lender
		secure.login(driver, userSecure, StoredVariables.getpassword().get());
		
		// Find order
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Open order
		secure.openOrder(driver, trackingNumber);
		
		// Click Accept this report
		perform.click(driver,SOrderDetails.acceptThisReportAsIs_radioBtn(driver));
		
		// Check attach completed report
		perform.checkCheckbox(driver, SOrderDetails.attachCompletedReportToAdditionalRecipients_chkbx(driver));
		perform.checkCheckbox(driver, SOrderDetails.attachCompletedReportToXSite_chkbx(driver));
		
		// Verify the documents are attached and properly labeled
		docsTable = driver.findElement(By.id("tblODFiles"));
		docs = docsTable.getText();
		System.out.println("docs = " + docs);
		Assert.assertTrue(docs.contains("Report PDF"), "There are documents missing in Secure");
		Assert.assertTrue(docs.contains("MISMO XML"), "There are documents missing in Secure");
		Assert.assertTrue(docs.contains("Order Documents"), "There are documents missing in Secure");
		Assert.assertTrue(docs.contains("Sales Contract"), "There are documents missing in Secure");
		Assert.assertTrue(docs.contains("Condo/HOA Cert"), "There are documents missing in Secure");
		Assert.assertTrue(docs.contains("Hazard Disclosure"), "There are documents missing in Secure");
		
		String clientDocs = driver.findElement(By.id("divDocumentListItems")).getText();
		Assert.assertTrue(clientDocs.contains("Invoice"), "There should be an invoice in Order Details for order number " + StoredVariables.getloanID().get());
		Assert.assertTrue(clientDocs.contains("Compliance Cert"), "There should be a Compliance Cert in Order Details for order number " + StoredVariables.getloanID().get());
		
		// Click OK
		perform.click(driver,SOrderDetails.okProcessReceivedReport_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Click Save
		perform.click(driver,driver.findElement(By.cssSelector("img[src='/images/Save16x16.png']")));
		
		// Get Product Item ID
		vmpProductItemID = db.getProductItemID(driver, StoredVariables.getloanIDVMP().get());
		secureProductItemID = db.getProductItemID(driver, StoredVariables.getloanID().get());
		
		// Verify MailQueue row count for this productItemID
		perform.verifyTheNumberOfRowsInTheMailQueueDBResultsForProductItemID(driver, 14, vmpProductItemID);
		perform.verifyTheNumberOfRowsInTheMailQueueDBResultsForProductItemID(driver, 4, secureProductItemID);
		
		/***********************************************************************************************
		 * Verify the notifications in the database
		 ***********************************************************************************************/
		// Query the database and return the results as an array
		String sqlStatement = "SELECT TOP 1 * FROM [dbo].[MailQueue] WHERE ProductItemID = '"
				+ vmpProductItemID
				+ "' AND  ToEntityID = '"
				+ xSiteEntityID
				+ "' ORDER BY EnteredStamp DESC";
		ArrayList<String> results = db
				.getMailQueueInfoBySQLToArray(driver, sqlStatement);

		// Set expected results
		String mailFromExpected = "XSite Order on behalf of automation@dntest.net (MNDoNotReply@mercuryvmp.com)";
		String mailToExpected = "automation"+env+"Sync2@dntest.net";
		String subjectExpected = "New Document(s) Attached to Order";
		String templateUsedExpected = server + "DocumentAttached_complete.html";
		String successfulExpected = "1";
		String fromEntityIDExpected = originatorEntityID;
		String toEntityIDExpected = xSiteEntityID;

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

		/***********************************************************************************************
		 * Verify the notifications in the database
		 ***********************************************************************************************/
		// Query the database and return the results as an array
		sqlStatement = "SELECT * FROM [dbo].[MailQueue] WHERE ProductItemID = '"
				+ vmpProductItemID
				+ "' AND MailTo like 'additionalEmail%"
				+ "' AND Subject like 'New Document(s)%"
				+ "' ORDER BY EnteredStamp DESC";
		results = db
				.getMailQueueInfoBySQLToArray(driver, sqlStatement);

		// Set expected results
		mailFromExpected = "XSite Order on behalf of automation@dntest.net (MNDoNotReply@mercuryvmp.com)";
		mailToExpected = "additionalEmail@dntest.net";
		subjectExpected = "New Document(s) Attached to Order";
		templateUsedExpected = server + "DocumentAttached_complete_AddtlRecipients.html";
		successfulExpected = "1";
		fromEntityIDExpected = xSiteEntityID;
		toEntityIDExpected = "NULL";

		// Set database values
		mailFrom = results.get(4);
		mailTo = results.get(5);
		subject = results.get(8);
		templateUsed = results.get(9);
		sentDateTime = results.get(11);
		successful = results.get(12);
		fromEntityID = results.get(13);
		toEntityID = results.get(14);

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
		
		// Log test
		test.log(LogStatus.INFO, "Secure Regression Test", "Verified that syncing Order Documents only produces one notification");
		
	} // end syncDocumentSingleNotificationOnly
	
	/**
	 * Wait for attachment complete.
	 *
	 * @param driver the driver
	 * @param num the num
	 * @throws InterruptedException the interrupted exception
	 */
	private void waitForAttachmentComplete(RemoteWebDriver driver, int num) throws InterruptedException {
		
		WebElement attach = driver.findElement(By.id("pbAttach"+num+"_Icon"));
		String attachComplete = attach.getAttribute("class");
		// Set 40 second while loop timeout
		long start_time = System.currentTimeMillis();
		long wait_time = 40000;
		long end_time = start_time + wait_time;
		while (System.currentTimeMillis() < end_time && !attachComplete.contains("OuterIconComplete"))
		{
			Thread.sleep(1000);
			attachComplete = VMPAppraisalOrderDetails.attached_icon(driver).getAttribute("class");
			if (attachComplete.contains("OuterIconComplete"))
			{
				// increment the int for the next attachment icon element
				num++;
				Thread.sleep(3000);
				break;
			} // end if
		} // end while
		
	} // end waitForAttachmentComplete
	
} // end the InvoiceNumbersDoNotResetWhenChangingClientGroupSettings class