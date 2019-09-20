package notifications;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjects.Secure.SAQMQCModule;
import pageObjects.Secure.SConfirmOrder;
import pageObjects.Secure.SNewOrder;
import pageObjects.Secure.SOrderDetails;
import pageObjects.Secure.SOrders;
import pageObjects.Secure.SUpdateClient;
import pageObjects.Secure.SVMPXSites;
import pageObjects.Secure.SVerifyCertificateInformation;
import pageObjects.VMP.VMPAppraisalOrderDetails;
import pageObjects.VMP.VMPConfirmOrder;
import pageObjects.VMP.VMPNewOrder;
import pageObjects.VMP.VMPOrderDetails;
import pageObjects.VMP.VMPOrders;
import pageObjects.Vendors.VOrderDetails;
import pageObjects.XSite.XBusinessManagement;
import pageObjects.XSite.XEditOrder;
import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Notifications</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
@Test(singleThreaded=true, groups= {"Secure - VMP XSite Settings", "Secure - Configure Status Mapping", "VMP - Create Order", "Secure - Orders", 
		"XSite - Order Details", "XSite - Edit Order", "Secure - Edit Order", "VMP - Orders", "Vendors - Orders", "Vendors - Accept Order", 
		"Vendors - Complete Order", "Vendors - Send Message", "Vendors - Set Status", "Vendors - Inspection Scheduled", "VMP - Send Message", 
		"Secure - Message", "Secure - Set Status", "Secure - Send Via SureReceipts", "Secure - Start AQM", "Secure - Submit To UCDP"})
public class Notifications extends TestSetup {

	/** The user secure. */
	private static String userSecure = "Notifications1";

	/** The user VMP. */
	private static String userVMP = "OriginatorNotifications1";

	/** The user vendors. */
	private static String userVendors = "NotificationsAppraiser2";

	/** The originator entity ID. */
	// Initialize variables
	private static String originatorEntityID = "";

	/** The managing originator entity ID. */
	private static String managingOriginatorEntityID = "";

	/** The x site entity ID. */
	private static String xSiteEntityID = "";

	/** The secure entity ID. */
	private static String secureEntityID = "";

	/** The vendor entity ID. */
	private static String vendorEntityID = "";

	/** The env. */
	//	private static String clientGroupID = "";
	private static String env = "";

	/** The server. */
	private static String server = "";

	/** The vmp product item ID. */
	private static String vmpProductItemID = "";

	/** The secure product item ID. */
	private static String secureProductItemID = "";

	/** The additional recipient 1. */
	private static String additionalRecipient1 = "";

	/** The additional recipient 2. */
	private static String additionalRecipient2 = "";

	/** The password. */
	private static String password = "";

	/** The order number. */
	private static String orderNumber = "";

	/** The order number VMP. */
	private static String orderNumberVMP = "";
	//	private static String loanNumber = "";

	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the variables</li>
	 * 	<li>clientGroupID = "";</li>
	 * 	<li>clientGroupID = "";</li>
	 * 	<li>clientGroupID = "";</li>
	 * 	<li>Set the server address per the environment</li>
	 * 	<li>Log in to secure</li>
	 * 	<li>Go to VMP XSite settings</li>
	 * 	<li>Verify the dropdown is the correct VMP site</li>
	 * 	<li>Click Configure Status Mapping link</li>
	 * 	<li>Enable all options</li>
	 * 	<li>Click the document upload gear icon</li>
	 * 	<li>Check every option for syncing</li>
	 * 	<li>Click OK</li>
	 * 	<li>Save</li>
	 * 	<li>Log in to VMP</li>
	 * 	<li>Set variables for a new order</li>
	 * 	<li>Go to New Order</li>
	 * 	<li>Place a new order</li>
	 * 	<li>Click Next</li>
	 * 	<li>Finish and save the order</li>
	 * 	<li>Select document type</li>
	 * 	<li>Click Close Button</li>
	 * 	<li>Switch back to the attach documents frame</li>
	 * 	<li>Click the OK button in the Order Placed dialog</li>
	 * 	<li>Get Order Number</li>
	 * 	<li>Get Product Item ID</li>
	 * 	<li>Verify MailQueue row count for this productItemID</li>
	 * 	<li>Get Loan Number</li>
	 * 	<li>String loanNumber = StoredVariables.getassignmentInformationLoanNumber().get();</li>
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
	 * </ul>
	 * @throws Exception the exception
	 */
	@Test (groups={}, alwaysRun=true)
	public void placeFirstOrderFromVMPClientPortal() throws Exception{

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		password = StoredVariables.getpassword().get();

		/**************************************************************************
		 * Get EntityID's and Group ID's for SQL queries
		 **************************************************************************/
		env = StoredVariables.getusernameEnvironment().get();
		// Set the variables
		if (env.equals("QA"))
		{
			originatorEntityID = "1071118";
			managingOriginatorEntityID = "1071122";
			xSiteEntityID = "1071116";
			secureEntityID = "1071115";
			vendorEntityID = "1071152";
		} // end if QA
		if (env.equals("Beta"))
		{
			originatorEntityID = "5569261";
			managingOriginatorEntityID = "5569308";
			xSiteEntityID = "5569254";
			secureEntityID = "5569251";
			vendorEntityID = "5570067";
		} // end if Beta
		if (env.equals("Live"))
		{
			originatorEntityID = "5569262";
			managingOriginatorEntityID = "5569309";
			xSiteEntityID = "5569256";
			secureEntityID = "5569252";
			vendorEntityID = "5570068";
		} // end if Live

		// Set the server address per the environment
		if (StoredVariables.getenvironment().get().equals("Dev")) {
			server = "\\\\ss1qa.internal.ad.mercuryvmp.com\\Shared Storage\\MercuryEmailTemplates\\QA-Dev\\";
		} else {
			if (env.equals("QA"))
			{
				server = "\\\\ss1qa.internal.ad.mercuryvmp.com\\Shared Storage\\MercuryEmailTemplates\\QA\\";
			} // end if QA
			if (env.equals("Beta"))
			{
				server = "\\\\ss1.internal.ad.mercuryvmp.com\\Shared Storage\\MercuryEmailTemplates\\Production\\";
			} // end if Beta
			if (env.equals("Live"))
			{
				server = "\\\\ss1.internal.ad.mercuryvmp.com\\Shared Storage\\MercuryEmailTemplates\\Production\\";
			} // end if Live
		} // end if/else

		/*********************************************************
		 * ENSURE ALL VMP STATUS MAPPING ITEMS ARE SET TO SYNC
		 *********************************************************/
		// Log in to secure
		secure.login(driver, userSecure, password);

		// Go to VMP XSite settings
		secure.goToVMPXSites(driver);

		// Verify the dropdown is the correct VMP site
		secure.verifyXSiteURLDropdownValue(driver, userSecure);

		Thread.sleep(2000);

		// Click Configure Status Mapping link
		perform.click(driver,SVMPXSites.configureStatusMapping_lnk(driver));

		// Wait for the Status Mapping text
		perform.waitForElementToBeVisible(driver, SVMPXSites.statusMappingConfiguration_txt(), "id");

		// Enable all options
		perform.enableAllOptionsInStatusMappingConfiguration(driver);

		// Click the document upload gear icon
		perform.click(driver,SVMPXSites.documentUploadedAppraiserClientGearIcon_btn(driver));

		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);

		// Check every option for syncing
		perform.enableAllCheckboxesToSyncToVMP(driver);

		// Click OK
		perform.click(driver,SVMPXSites.okSyncToVMPCheckboxesClient_btn(driver));

		// Save
		perform.click(driver,SVMPXSites.save_btn(driver));

		// Log in to VMP
		vmp.login(driver, userSecure, userVMP, password);

		// Set variables for a new order
		vmp.setVariables(driver);

		// Go to New Order
		vmp.goToNewOrder(driver);

		// Place a new order
		additionalRecipient1 = "additionalRecipient" + perform.randomNumbers(driver, 9) + StoredVariables.getcatchAllDomain().get();
		StoredVariables.getadditionalNotificationRecipientsAdditionalEmails().set(additionalRecipient1);
		vmp.enterNewOrder(driver);

		// Click Next
		perform.click(driver,VMPNewOrder.nextBottom_btn(driver));

		// Finish and save the order
		vmp.saveNewOrder(driver);

		// Select document type
		perform.selectDropdownOption(driver, VMPConfirmOrder.documentType_dropdown(driver), "Other");

		// Click Close Button
		perform.click(driver,VMPConfirmOrder.finished_btn(driver));

		// Switch back to the attach documents frame
		driver.switchTo().defaultContent();

		// Wait for the OK button in the Order Placed dialog
		perform.waitForElementToBeClickable(driver, VMPConfirmOrder.ok_btn(), "cssSelector");

		// Click the OK button in the Order Placed dialog
		perform.click(driver,VMPConfirmOrder.ok_btn(driver));

		// Wait for the Find textbox
		perform.waitForElementToBeClickable(driver, VMPOrders.find_txtbx(), "id");

		// Get Order Number
		db.getLoanIDsFromVMPClientPortalOrder(driver);
		orderNumber = StoredVariables.getloanID().get();
		orderNumberVMP = StoredVariables.getloanIDVMP().get();

		// Get Product Item ID
		vmpProductItemID = db.getProductItemID(driver, orderNumberVMP);
		secureProductItemID = db.getProductItemID(driver, orderNumber);

		// Verify MailQueue row count for this productItemID
		perform.verifyTheNumberOfRowsInTheMailQueueDBResultsForProductItemID(driver, 3, vmpProductItemID);

		/***********************************************************************************************
		 * Verify the VMP XSite EntityID receives New Order notifications in the database
		 ***********************************************************************************************/
		// Query the database and return the results as an array
		String sqlStatement = "SELECT * FROM [dbo].[MailQueue] WHERE ProductItemID = '"
				+ vmpProductItemID + "' AND ToEntityID = '" + xSiteEntityID + "'";
		ArrayList<String> results = db.getMailQueueInfoBySQLToArray(driver, sqlStatement);

		// Set expected results
		String mailFromExpected = "XSite Order on behalf of automation@dntest.net (MNDoNotReply@mercuryvmp.com)";
		String mailToExpected = "automation"+env+"Notifications1@dntest.net";
		String subjectExpected = "XSite Order - 501-D NE 122nd St, Oklahoma City";
		String templateUsedExpected = server+"XSiteNewAppraisalOrder.html";
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
						+ mailFrom + " and should be = " + mailFromExpected);

		// Verify MailTo
		Assert.assertTrue(mailTo.equals(mailToExpected),
				"The MailTo entry in the database is incorrect. DB value = "
						+ mailTo + " and should be = " + mailToExpected);

		// Verify Subject
		Assert.assertTrue(subject.equals(subjectExpected),
				"The Subject entry in the database is incorrect. DB value = "
						+ subject + " and should be = " + subjectExpected);

		// Verify TemplateUsed
		Assert.assertTrue(templateUsed.toLowerCase().equals(templateUsedExpected.toLowerCase()),
				"The TemplateUsed entry in the database is incorrect. DB value = "
						+ templateUsed + " and should be = "
						+ templateUsedExpected);

		// Verify SentDateTime is not NULL
		Assert.assertTrue(!sentDateTime.toLowerCase().equals("null"),
				"The SentDateTime entry in the database is null!");

		// Verify Successful is 1
		Assert.assertTrue(successful.equals(successfulExpected),
				"The Successful entry in the database is incorrect. DB value = "
						+ successful + " and should be = " + successfulExpected);

		// Verify FromEntityID
		Assert.assertTrue(fromEntityID.equals(fromEntityIDExpected),
				"The FromEntityID entry in the database is incorrect. DB value = "
						+ fromEntityID + " and should be = "
						+ fromEntityIDExpected);

		// Verify ToEntityID
		Assert.assertTrue(toEntityID.equals(toEntityIDExpected),
				"The ToEntityID entry in the database is incorrect. DB value = "
						+ toEntityID + " and should be = " + toEntityIDExpected);

		/***********************************************************************************************
		 * Verify the Originator EntityID receives Appraisal Order Placed notifications in the database
		 ***********************************************************************************************/
		// Query the database and return the results as an array
		sqlStatement = "SELECT * FROM [dbo].[MailQueue] WHERE ProductItemID = '"
				+ vmpProductItemID + "' AND ToEntityID = '" + originatorEntityID + "'";
		results = db.getMailQueueInfoBySQLToArray(driver, sqlStatement);

		// Set expected results
		mailFromExpected = "Mercury Network (MNDoNotReply@mercuryvmp.com)";
		mailToExpected = "automation@dntest.net";
		subjectExpected = "XSite Order - 501-D NE 122nd St, Oklahoma City";
		templateUsedExpected = server+"NewOrderPlacedNotification_v2.html";
		successfulExpected = "1";
		fromEntityIDExpected = "NULL";
		toEntityIDExpected = originatorEntityID;

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
						+ mailFrom + " and should be = " + mailFromExpected);

		// Verify MailTo
		Assert.assertTrue(mailTo.equals(mailToExpected),
				"The MailTo entry in the database is incorrect. DB value = "
						+ mailTo + " and should be = " + mailToExpected);

		// Verify Subject
		Assert.assertTrue(subject.equals(subjectExpected),
				"The Subject entry in the database is incorrect. DB value = "
						+ subject + " and should be = " + subjectExpected);

		// Verify TemplateUsed
		Assert.assertTrue(templateUsed.toLowerCase().equals(templateUsedExpected.toLowerCase()),
				"The TemplateUsed entry in the database is incorrect. DB value = "
						+ templateUsed + " and should be = "
						+ templateUsedExpected);

		// Verify SentDateTime is not NULL
		Assert.assertTrue(!sentDateTime.toLowerCase().equals("null"),
				"The SentDateTime entry in the database is null!");

		// Verify Successful is 1
		Assert.assertTrue(successful.equals(successfulExpected),
				"The Successful entry in the database is incorrect. DB value = "
						+ successful + " and should be = " + successfulExpected);

		// Verify FromEntityID
		Assert.assertTrue(fromEntityID.equals(fromEntityIDExpected),
				"The FromEntityID entry in the database is incorrect. DB value = "
						+ fromEntityID + " and should be = "
						+ fromEntityIDExpected);

		// Verify ToEntityID
		Assert.assertTrue(toEntityID.equals(toEntityIDExpected),
				"The ToEntityID entry in the database is incorrect. DB value = "
						+ toEntityID + " and should be = " + toEntityIDExpected);

		/***********************************************************************************************
		 * Verify the VMP XSite Additional Recipient receives Appraisal Order Placed notifications in the database
		 ***********************************************************************************************/
		// Query the database and return the results as an array
		sqlStatement = "SELECT * FROM [dbo].[MailQueue] WHERE ProductItemID = '"
				+ vmpProductItemID + "' AND MailTo = '"+additionalRecipient1+"'";
		results = db.getMailQueueInfoBySQLToArray(driver, sqlStatement);

		// Set expected results
		mailFromExpected = "Mercury Network (MNDoNotReply@mercuryvmp.com)";
		mailToExpected = additionalRecipient1;
		subjectExpected = "XSite Order - 501-D NE 122nd St, Oklahoma City";
		templateUsedExpected = server+"NewOrderPlacedNotification_v2.html";
		successfulExpected = "1";
		fromEntityIDExpected = "NULL";
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
						+ mailFrom + " and should be = " + mailFromExpected);

		// Verify MailTo
		Assert.assertTrue(mailTo.equals(mailToExpected),
				"The MailTo entry in the database is incorrect. DB value = "
						+ mailTo + " and should be = " + mailToExpected);

		// Verify Subject
		Assert.assertTrue(subject.equals(subjectExpected),
				"The Subject entry in the database is incorrect. DB value = "
						+ subject + " and should be = " + subjectExpected);

		// Verify TemplateUsed
		Assert.assertTrue(templateUsed.toLowerCase().equals(templateUsedExpected.toLowerCase()),
				"The TemplateUsed entry in the database is incorrect. DB value = "
						+ templateUsed + " and should be = "
						+ templateUsedExpected);

		// Verify SentDateTime is not NULL
		Assert.assertTrue(!sentDateTime.toLowerCase().equals("null"),
				"The SentDateTime entry in the database is null!");

		// Verify Successful is 1
		Assert.assertTrue(successful.equals(successfulExpected),
				"The Successful entry in the database is incorrect. DB value = "
						+ successful + " and should be = " + successfulExpected);

		// Verify FromEntityID
		Assert.assertTrue(fromEntityID.equals(fromEntityIDExpected),
				"The FromEntityID entry in the database is incorrect. DB value = "
						+ fromEntityID + " and should be = "
						+ fromEntityIDExpected);

		// Verify ToEntityID
		Assert.assertTrue(toEntityID.equals(toEntityIDExpected),
				"The ToEntityID entry in the database is incorrect. DB value = "
						+ toEntityID + " and should be = " + toEntityIDExpected);

		/***********************************************************************************************
		 * Verify the Managing Client Group Member receives Appraisal Order Placed notifications in the database
		 ***********************************************************************************************/
		test.log(LogStatus.WARNING, "Notifications", "There is no notification in the database for the Managing Client Group Member receives Appraisal Order Placed. The matrix shows there should be");

		// Log test
		test.log(LogStatus.INFO, "Notifications", "Placed the first order from VMP Client Portal and verified the notificaitons get sent correctly");

	} // end placeFirstOrderFromVMPClientPortal

	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Edit the order from VMP XSite and check the box for "Attach completed report to the completion or pending quality review�"  **Must have this bit enabled by dev</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Find order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Click the View XSite order link</li>
	 * 	<li>Switch to new window</li>
	 * 	<li>Print out the current iFrame</li>
	 * 	<li>Click Edit</li>
	 * 	<li>Change the Sale Price</li>
	 * 	<li>Check the Attach completed report checkbox</li>
	 * 	<li>Click OK</li>
	 * 	<li>Select the update Sale Price checkbox</li>
	 * 	<li>Click OK</li>
	 * 	<li>Close the XSite window</li>
	 * 	<li>Switch focus to original window</li>
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
	 * 	<li>VMP XSite Additional Recipient receives Order Changed notification</li>
	 * 	<li>Log test</li>
	 * </ul>
	 * @throws Exception the exception
	 */
	@Test (groups={}, dependsOnMethods="placeFirstOrderFromVMPClientPortal")
	public void editOrderFromXSite() throws Exception {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Edit the order from VMP XSite and check the box for "Attach completed report to the completion or pending quality review�"  **Must have this bit enabled by dev
		// Log in to Secure
		secure.login(driver, userSecure, password);

		// Find order
		secure.findOrder(driver, orderNumber, "Tracking number");

		// Open the order
		secure.openOrder(driver, orderNumber);

		// Click the View XSite order link
		perform.click(driver,SOrderDetails.viewXSiteOrder_lnk(driver));

		Thread.sleep(2500);

		// Switch to new window
		perform.switchToXSiteWindowByTitle(driver, "Business Management");

		// Wait for iFrame
		perform.waitForIFrames(driver);

		// Wait for iFrame and switch to it
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("Main")));

		// Print out the current iFrame
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		String currentFrame = (String) jsExecutor.executeScript("return self.name");
		System.out.println("Current frame = " + currentFrame);

		Thread.sleep(2500);

		// Wait for Edit button
		perform.waitForElementToBeClickable(driver, XBusinessManagement.edit_btn(), "cssSelector");

		// Click Edit
		perform.click(driver,XBusinessManagement.edit_btn(driver));

		// Wait for OK button
		perform.waitForElementToBeClickable(driver, XEditOrder.ok_btn(), "id");

		// Change the Sale Price
		XEditOrder.salePrice_txtbx(driver).clear();
		perform.type(driver,XEditOrder.salePrice_txtbx(driver), "450775");

		// Check the Attach completed report checkbox
		perform.checkCheckbox(driver, XEditOrder.attachCompletedReport_chkbx(driver));

		// Click OK
		perform.click(driver,XEditOrder.ok_btn(driver));

		// Wait for the Sale Price checkbox
		perform.waitForElementToBeClickable(driver, XEditOrder.update1_chkbx(), "id");

		// Select the update Sale Price checkbox
		perform.checkCheckbox(driver, XEditOrder.update1_chkbx(driver));

		// Click OK
		perform.click(driver,XEditOrder.okUpdate_btn(driver));

		// Wait for the Edit button
		perform.waitForElementToBeClickable(driver, XBusinessManagement.edit_btn(), "cssSelector");

		// Close the XSite window
		driver.close();

		// Switch focus to original window
		driver.switchTo().window(StoredVariables.getwinHandleBefore().get());

		// Verify MailQueue row count for this productItemID
		perform.verifyTheNumberOfRowsInTheMailQueueDBResultsForProductItemID(driver, 4, vmpProductItemID);

		/***********************************************************************************************
		 * Verify the Originator EntityID receives Order Changed notifications in the database
		 ***********************************************************************************************/
		// Query the database and return the results as an array
		String sqlStatement = "SELECT TOP 1 * FROM [dbo].[MailQueue] WHERE ProductItemID = '"
				+ vmpProductItemID + "' AND ToEntityID = '"+originatorEntityID+"' ORDER BY EnteredStamp DESC";
		ArrayList<String> results = db
				.getMailQueueInfoBySQLToArray(driver, sqlStatement);

		// Set expected results
		String mailFromExpected = "\"Automation"+env+"Notifications1\" (automation"+env+"Notifications1@dntest.net)";
		String mailToExpected = "automation@dntest.net";
		String subjectExpected = "Order changed for Baseline Test-";
		String templateUsedExpected = server+"XSiteOrderEdit.html";
		String successfulExpected = "1";
		String fromEntityIDExpected = xSiteEntityID;
		String toEntityIDExpected = originatorEntityID;

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
						+ mailFrom + " and should be = " + mailFromExpected);

		// Verify MailTo
		Assert.assertTrue(mailTo.equals(mailToExpected),
				"The MailTo entry in the database is incorrect. DB value = "
						+ mailTo + " and should be = " + mailToExpected);

		// Verify Subject
		Assert.assertTrue(subject.contains(subjectExpected),
				"The Subject entry in the database is incorrect. DB value = "
						+ subject + " and should be = " + subjectExpected);

		// Verify TemplateUsed
		Assert.assertTrue(templateUsed.toLowerCase().equals(templateUsedExpected.toLowerCase()),
				"The TemplateUsed entry in the database is incorrect. DB value = "
						+ templateUsed + " and should be = "
						+ templateUsedExpected);

		// Verify SentDateTime is not NULL
		Assert.assertTrue(!sentDateTime.toLowerCase().equals("null"),
				"The SentDateTime entry in the database is null!");

		// Verify Successful is 1
		Assert.assertTrue(successful.equals(successfulExpected),
				"The Successful entry in the database is incorrect. DB value = "
						+ successful + " and should be = " + successfulExpected);

		// Verify FromEntityID
		Assert.assertTrue(fromEntityID.equals(fromEntityIDExpected),
				"The FromEntityID entry in the database is incorrect. DB value = "
						+ fromEntityID + " and should be = "
						+ fromEntityIDExpected);

		// Verify ToEntityID
		Assert.assertTrue(toEntityID.equals(toEntityIDExpected),
				"The ToEntityID entry in the database is incorrect. DB value = "
						+ toEntityID + " and should be = " + toEntityIDExpected);

		// VMP XSite Additional Recipient receives Order Changed notification
		test.log(LogStatus.WARNING, "Notifications", "There is no notification in the database for the VMP XSite Additional Recipient receives Order Changed. The matrix shows there should be");

		// Log test
		test.log(LogStatus.INFO, "Notifications", "Edit the order from the XSite and verify notifications");

	} // end editOrderFromXSite

	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Edit the order from VMP XSite and check the box for "Attach completed report to the completion or pending quality review�"  **Must have this bit enabled by dev</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Find order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Edit the order as the Secure MN user and add an Additional Notification Recipient</li>
	 * 	<li>Click Edit</li>
	 * 	<li>Change the Sales price</li>
	 * 	<li>Add an Additional Recipient</li>
	 * 	<li>Verify Attach completed report checkbox is checked</li>
	 * 	<li>Click Save</li>
	 * 	<li>Check the Sales Price item</li>
	 * 	<li>Click OK</li>
	 * 	<li>Click the Appraiser radio button</li>
	 * 	<li>Click Assign1</li>
	 * 	<li>Assign the order to a vendor</li>
	 * 	<li>Click Finish</li>
	 * 	<li>Verify MailQueue row count for this vmp productItemID</li>
	 * 	<li>Verify MailQueue row count for this secure productItemID</li>
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
	 * </ul>
	 * @throws Exception the exception
	 */
	@Test (groups={}, dependsOnMethods="editOrderFromXSite")
	public void editOrderAsSecureAndAssignVendor() throws Exception {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Edit the order from VMP XSite and check the box for "Attach completed report to the completion or pending quality review�"  **Must have this bit enabled by dev
		// Log in to Secure
		secure.login(driver, userSecure, password);

		// Find order
		secure.findOrder(driver, orderNumber, "Tracking number");

		// Open the order
		secure.openOrder(driver, orderNumber);

		// Edit the order as the Secure MN user and add an Additional Notification Recipient
		// Click Edit
		perform.click(driver,SOrderDetails.edit_btn(driver));

		// Wait for Address textbox
		perform.waitForElementToBeClickable(driver, SNewOrder.address_txtbx(), "id");

		// Change the Sales price
		SNewOrder.salesPrice_txtbx(driver).clear();
		perform.type(driver,SNewOrder.salesPrice_txtbx(driver), "550550");

		// Add an Additional Recipient
		additionalRecipient2 = "additionalRecipient" + perform.randomNumbers(driver, 9) + StoredVariables.getcatchAllDomain().get();
		perform.type(driver,SNewOrder.additionalEmailRecipients_txtbx(driver), additionalRecipient2);

		// Verify Attach completed report checkbox is checked
		perform.checkCheckbox(driver, SNewOrder.attachCompletedReport_chkbx(driver));

		// Click Save
		perform.click(driver,SNewOrder.saveTop_btn(driver));

		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);

		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SUpdateClient.ok_btn(), "id");

		// Check the Sales Price item
		perform.checkCheckbox(driver, SUpdateClient.update1_btn(driver));

		// Click OK
		perform.click(driver,SUpdateClient.ok_btn(driver));

		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);

		// Click the Appraiser radio button
		perform.click(driver,SOrderDetails.appraiser_radiobtn(driver));

		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);

		// Wait for Assign button
		perform.waitForElementToBeClickable(driver, SOrderDetails.assign_btn(), "id");

		// Click Assign1
		perform.click(driver,SOrderDetails.assign_btn(driver));

		// Assign the order to a vendor
		secure.selectVendor(driver, "NotificationsAppraiser2");

		// Click Finish
		perform.click(driver,SConfirmOrder.finishTop_btn(driver));

		// Verify MailQueue row count for this vmp productItemID
		perform.verifyTheNumberOfRowsInTheMailQueueDBResultsForProductItemID(driver, 5, vmpProductItemID);

		// Verify MailQueue row count for this secure productItemID
		perform.verifyTheNumberOfRowsInTheMailQueueDBResultsForProductItemID(driver, 1, secureProductItemID);

		/***********************************************************************************************
		 * Verify the Vendor EntityID receives New Appraisal Order notifications in the database
		 ***********************************************************************************************/
		// Query the database and return the results as an array
		String sqlStatement = "SELECT * FROM [dbo].[MailQueue] WHERE ProductItemID = '"
				+ secureProductItemID + "' AND ToEntityID = '"+vendorEntityID+"'";
		ArrayList<String> results = db
				.getMailQueueInfoBySQLToArray(driver, sqlStatement);

		// Set expected results
		String mailFromExpected = "Mercury Network (MNDoNotReply@mercuryvmp.com)";
		String mailToExpected = "automation"+env+"NotificationsAppraiser2@dntest.net";
		String subjectExpected = "Mercury Network Order - 501-D NE 122nd St, Oklahoma City";
		String templateUsedExpected = server+"MN_XSiteNewAppraisalOrder_v2.html";
		String successfulExpected = "1";
		String fromEntityIDExpected = secureEntityID;
		String toEntityIDExpected = vendorEntityID;

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
						+ mailFrom + " and should be = " + mailFromExpected);

		// Verify MailTo
		Assert.assertTrue(mailTo.equals(mailToExpected),
				"The MailTo entry in the database is incorrect. DB value = "
						+ mailTo + " and should be = " + mailToExpected);

		// Verify Subject
		Assert.assertTrue(subject.equals(subjectExpected),
				"The Subject entry in the database is incorrect. DB value = "
						+ subject + " and should be = " + subjectExpected);

		// Verify TemplateUsed
		Assert.assertTrue(templateUsed.toLowerCase().equals(templateUsedExpected.toLowerCase()),
				"The TemplateUsed entry in the database is incorrect. DB value = "
						+ templateUsed + " and should be = "
						+ templateUsedExpected);

		// Verify SentDateTime is not NULL
		Assert.assertTrue(!sentDateTime.toLowerCase().equals("null"),
				"The SentDateTime entry in the database is null!");

		// Verify Successful is 1
		Assert.assertTrue(successful.equals(successfulExpected),
				"The Successful entry in the database is incorrect. DB value = "
						+ successful + " and should be = " + successfulExpected);

		// Verify FromEntityID
		Assert.assertTrue(fromEntityID.equals(fromEntityIDExpected),
				"The FromEntityID entry in the database is incorrect. DB value = "
						+ fromEntityID + " and should be = "
						+ fromEntityIDExpected);

		// Verify ToEntityID
		Assert.assertTrue(toEntityID.equals(toEntityIDExpected),
				"The ToEntityID entry in the database is incorrect. DB value = "
						+ toEntityID + " and should be = " + toEntityIDExpected);

		// Log test
		test.log(LogStatus.INFO, "Notifications", "Edited the order as Secure user, assigned to a vendor and verified the notifications");

	} // end editOrderAsSecureAndAssignVendor

	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>From the VMP Client Portal view the order details &gt; Click Attach Documents</li>
	 * 	<li>Log in to VMP</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Click Attach Documents</li>
	 * 	<li>Select a document type</li>
	 * 	<li>Upload a document</li>
	 * 	<li>Click Finished</li>
	 * 	<li>Verify MailQueue row count for this vmp productItemID</li>
	 * 	<li>Verify MailQueue row count for this secure productItemID</li>
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
	 * </ul>
	 * @throws Exception the exception
	 */
	@Test (groups={}, dependsOnMethods="editOrderAsSecureAndAssignVendor")
	public void uploadDocumentFromVMPClientPortal() throws Exception {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// From the VMP Client Portal view the order details  >  Click Attach Documents
		// Log in to VMP
		vmp.login(driver, userSecure, userVMP, password);

		// Find the order
		vmp.findOrder(driver, orderNumberVMP, "Tracking #");

		// Open the order
		vmp.openOrder(driver, orderNumberVMP);

		// Click Attach Documents
		perform.click(driver,VMPAppraisalOrderDetails.attachDocuments_btn(driver));

		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);

		// Switch into iFrame
		perform.switchToiFrameByID(driver, "iframeAttach");

		// Wait for document type dropdown
		perform.waitForElementToBeClickable(driver, VMPConfirmOrder.documentType_dropdown(driver));

		// Select a document type  
		perform.selectDropdownOption(driver, VMPConfirmOrder.documentType_dropdown(driver), "Other");

		// Upload a document
		String filePath = StoredVariables.getdocDir().get()+"Test PDF.pdf";
		vmp.uploadDocumentOnAppraisalOrderDetails(driver, filePath);

		// Click Finished
		perform.click(driver,VMPConfirmOrder.finished_btn(driver));

		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);

		// Verify MailQueue row count for this vmp productItemID
		perform.verifyTheNumberOfRowsInTheMailQueueDBResultsForProductItemID(driver, 6, vmpProductItemID);

		// Verify MailQueue row count for this secure productItemID
		perform.verifyTheNumberOfRowsInTheMailQueueDBResultsForProductItemID(driver, 2, secureProductItemID);

		/***********************************************************************************************
		 * Verify the VMP XSite EntityID receives New Document Attached notifications in the database
		 ***********************************************************************************************/
		// Query the database and return the results as an array
		String sqlStatement = "SELECT TOP 1 * FROM [dbo].[MailQueue] WHERE ProductItemID = '"
				+ vmpProductItemID + "' AND ToEntityID = '"+xSiteEntityID+"' ORDER BY EnteredStamp DESC";
		ArrayList<String> results = db
				.getMailQueueInfoBySQLToArray(driver, sqlStatement);

		// Set expected results
		String mailFromExpected = "XSite Order on behalf of automation@dntest.net (MNDoNotReply@mercuryvmp.com)";
		String mailToExpected = "automation"+env+"Notifications1@dntest.net";
		String subjectExpected = "New Document Attached to Order - Type: Other";
		String templateUsedExpected = server+"DocumentAttached.html";
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
						+ mailFrom + " and should be = " + mailFromExpected);

		// Verify MailTo
		Assert.assertTrue(mailTo.equals(mailToExpected),
				"The MailTo entry in the database is incorrect. DB value = "
						+ mailTo + " and should be = " + mailToExpected);

		// Verify Subject
		Assert.assertTrue(subject.equals(subjectExpected),
				"The Subject entry in the database is incorrect. DB value = "
						+ subject + " and should be = " + subjectExpected);

		// Verify TemplateUsed
		Assert.assertTrue(templateUsed.toLowerCase().equals(templateUsedExpected.toLowerCase()),
				"The TemplateUsed entry in the database is incorrect. DB value = "
						+ templateUsed + " and should be = "
						+ templateUsedExpected);

		// Verify SentDateTime is not NULL
		Assert.assertTrue(!sentDateTime.toLowerCase().equals("null"),
				"The SentDateTime entry in the database is null!");

		// Verify Successful is 1
		Assert.assertTrue(successful.equals(successfulExpected),
				"The Successful entry in the database is incorrect. DB value = "
						+ successful + " and should be = " + successfulExpected);

		// Verify FromEntityID
		Assert.assertTrue(fromEntityID.equals(fromEntityIDExpected),
				"The FromEntityID entry in the database is incorrect. DB value = "
						+ fromEntityID + " and should be = "
						+ fromEntityIDExpected);

		// Verify ToEntityID
		Assert.assertTrue(toEntityID.equals(toEntityIDExpected),
				"The ToEntityID entry in the database is incorrect. DB value = "
						+ toEntityID + " and should be = " + toEntityIDExpected);

		/***********************************************************************************************
		 * Verify the Vendor EntityID receives New Document Attached notifications in the database
		 ***********************************************************************************************/
		// Query the database and return the results as an array
		sqlStatement = "SELECT TOP 1 * FROM [dbo].[MailQueue] WHERE ProductItemID = '"
				+ secureProductItemID + "' AND ToEntityID = '"+vendorEntityID+"' ORDER BY EnteredStamp DESC";
		results = db
				.getMailQueueInfoBySQLToArray(driver, sqlStatement);

		// Set expected results
		mailFromExpected = "Mercury Network (MNDoNotReply@mercuryvmp.com)";
		mailToExpected = "automation"+env+"NotificationsAppraiser2@dntest.net";
		subjectExpected = "New Document Attached to Order - Type: Other";
		templateUsedExpected = server+"MN_XSiteDocumentAttached.html";
		successfulExpected = "1";
		fromEntityIDExpected = secureEntityID;
		toEntityIDExpected = vendorEntityID;

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
						+ mailFrom + " and should be = " + mailFromExpected);

		// Verify MailTo
		Assert.assertTrue(mailTo.equals(mailToExpected),
				"The MailTo entry in the database is incorrect. DB value = "
						+ mailTo + " and should be = " + mailToExpected);

		// Verify Subject
		Assert.assertTrue(subject.equals(subjectExpected),
				"The Subject entry in the database is incorrect. DB value = "
						+ subject + " and should be = " + subjectExpected);

		// Verify TemplateUsed
		Assert.assertTrue(templateUsed.toLowerCase().equals(templateUsedExpected.toLowerCase()),
				"The TemplateUsed entry in the database is incorrect. DB value = "
						+ templateUsed + " and should be = "
						+ templateUsedExpected);

		// Verify SentDateTime is not NULL
		Assert.assertTrue(!sentDateTime.toLowerCase().equals("null"),
				"The SentDateTime entry in the database is null!");

		// Verify Successful is 1
		Assert.assertTrue(successful.equals(successfulExpected),
				"The Successful entry in the database is incorrect. DB value = "
						+ successful + " and should be = " + successfulExpected);

		// Verify FromEntityID
		Assert.assertTrue(fromEntityID.equals(fromEntityIDExpected),
				"The FromEntityID entry in the database is incorrect. DB value = "
						+ fromEntityID + " and should be = "
						+ fromEntityIDExpected);

		// Verify ToEntityID
		Assert.assertTrue(toEntityID.equals(toEntityIDExpected),
				"The ToEntityID entry in the database is incorrect. DB value = "
						+ toEntityID + " and should be = " + toEntityIDExpected);

		// Log test
		test.log(LogStatus.INFO, "Notifications", "Uploaded a document from the VMP Client Portal and verified the notifications");

	} // end uploadDocumentFromVMPClientPortal

	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Accept the order as the Vendor</li>
	 * 	<li>Login to Vendors</li>
	 * 	<li>Accept the order</li>
	 * 	<li>Verify MailQueue row count for this vmp productItemID</li>
	 * 	<li>Verify MailQueue row count for this secure productItemID</li>
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
	 * 	<li>Mercury Network Additional Recipient receives Order Placed notification</li>
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
	 * </ul>
	 * @throws Exception the exception
	 */
	@Test (groups={}, dependsOnMethods="uploadDocumentFromVMPClientPortal")
	public void acceptOrderAsVendor() throws Exception {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Accept the order as the Vendor
		// Login to Vendors
		vendors.login(driver, userVendors, password);

		// Accept the order
		vendors.acceptOrder(driver, orderNumber);

		// Verify MailQueue row count for this vmp productItemID
		perform.verifyTheNumberOfRowsInTheMailQueueDBResultsForProductItemID(driver, 8, vmpProductItemID);

		// Verify MailQueue row count for this secure productItemID
		perform.verifyTheNumberOfRowsInTheMailQueueDBResultsForProductItemID(driver, 4, secureProductItemID);

		/***********************************************************************************************
		 * Verify the Secure EntityID receives Order Placed notifications in the database
		 ***********************************************************************************************/
		// Query the database and return the results as an array
		String sqlStatement = "SELECT * FROM [dbo].[MailQueue] WHERE ProductItemID = '"
				+ secureProductItemID + "' AND ToEntityID = '"+secureEntityID+"'";
		ArrayList<String> results = db
				.getMailQueueInfoBySQLToArray(driver, sqlStatement);

		// Set expected results
		String mailFromExpected = "Mercury Network (MNDoNotReply@mercuryvmp.com)";
		String mailToExpected = "automation"+env+"Notifications1@dntest.net";
		String subjectExpected = "Order Placed for Baseline Test-";
		String templateUsedExpected = server+"MN_InProgress.html";
		String successfulExpected = "1";
		String fromEntityIDExpected = vendorEntityID;
		String toEntityIDExpected = secureEntityID;

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
						+ mailFrom + " and should be = " + mailFromExpected);

		// Verify MailTo
		Assert.assertTrue(mailTo.equals(mailToExpected),
				"The MailTo entry in the database is incorrect. DB value = "
						+ mailTo + " and should be = " + mailToExpected);

		// Verify Subject
		Assert.assertTrue(subject.contains(subjectExpected),
				"The Subject entry in the database is incorrect. DB value = "
						+ subject + " and should be = " + subjectExpected);

		// Verify TemplateUsed
		Assert.assertTrue(templateUsed.toLowerCase().equals(templateUsedExpected.toLowerCase()),
				"The TemplateUsed entry in the database is incorrect. DB value = "
						+ templateUsed + " and should be = "
						+ templateUsedExpected);

		// Verify SentDateTime is not NULL
		Assert.assertTrue(!sentDateTime.toLowerCase().equals("null"),
				"The SentDateTime entry in the database is null!");

		// Verify Successful is 1
		Assert.assertTrue(successful.equals(successfulExpected),
				"The Successful entry in the database is incorrect. DB value = "
						+ successful + " and should be = " + successfulExpected);

		// Verify FromEntityID
		Assert.assertTrue(fromEntityID.equals(fromEntityIDExpected),
				"The FromEntityID entry in the database is incorrect. DB value = "
						+ fromEntityID + " and should be = "
						+ fromEntityIDExpected);

		// Verify ToEntityID
		Assert.assertTrue(toEntityID.equals(toEntityIDExpected),
				"The ToEntityID entry in the database is incorrect. DB value = "
						+ toEntityID + " and should be = " + toEntityIDExpected);

		// Mercury Network Additional Recipient receives Order Placed notification
		/***********************************************************************************************
		 * Verify the notifications in the database
		 ***********************************************************************************************/
		// Query the database and return the results as an array
		sqlStatement = "SELECT * FROM [dbo].[MailQueue] WHERE ProductItemID = '"
				+ secureProductItemID + "' AND MailTo = '"+additionalRecipient2+"'";
		results = db
				.getMailQueueInfoBySQLToArray(driver, sqlStatement);

		// Set expected results
		mailFromExpected = "Mercury Network (MNDoNotReply@mercuryvmp.com)";
		mailToExpected = additionalRecipient2;
		subjectExpected = "Order Placed for Baseline Test-";
		templateUsedExpected = server + "MN_InProgress_AddtlRecipients.html";
		successfulExpected = "1";
		fromEntityIDExpected = vendorEntityID;
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
						+ mailFrom + " and should be = " + mailFromExpected);

		// Verify MailTo
		Assert.assertTrue(mailTo.equals(mailToExpected),
				"The MailTo entry in the database is incorrect. DB value = "
						+ mailTo + " and should be = " + mailToExpected);

		// Verify Subject
		Assert.assertTrue(subject.contains(subjectExpected),
				"The Subject entry in the database is incorrect. DB value = "
						+ subject + " and should be = " + subjectExpected);

		// Verify TemplateUsed
		Assert.assertTrue(templateUsed.toLowerCase().equals(templateUsedExpected.toLowerCase()),
				"The TemplateUsed entry in the database is incorrect. DB value = "
						+ templateUsed + " and should be = "
						+ templateUsedExpected);

		// Verify SentDateTime is not NULL
		Assert.assertTrue(!sentDateTime.toLowerCase().equals("null"),
				"The SentDateTime entry in the database is null!");

		// Verify Successful is 1
		Assert.assertTrue(successful.equals(successfulExpected),
				"The Successful entry in the database is incorrect. DB value = "
						+ successful + " and should be = " + successfulExpected);

		// Verify FromEntityID
		Assert.assertTrue(fromEntityID.equals(fromEntityIDExpected),
				"The FromEntityID entry in the database is incorrect. DB value = "
						+ fromEntityID + " and should be = "
						+ fromEntityIDExpected);

		// Verify ToEntityID
		Assert.assertTrue(toEntityID.equals(toEntityIDExpected),
				"The ToEntityID entry in the database is incorrect. DB value = "
						+ toEntityID + " and should be = " + toEntityIDExpected);

		/***********************************************************************************************
		 * Verify the Originator EntityID receives Vendor Accepted Assignment notifications in the database
		 ***********************************************************************************************/
		// Query the database and return the results as an array
		sqlStatement = "SELECT TOP 1 * FROM [dbo].[MailQueue] WHERE ProductItemID = '"
				+ vmpProductItemID + "' AND ToEntityID = '"+originatorEntityID+"' ORDER BY EnteredStamp DESC";
		results = db
				.getMailQueueInfoBySQLToArray(driver, sqlStatement);

		// Set expected results
		mailFromExpected = "XSite Order on behalf of automation"+env+"Notifications1@dntest.net (MNDoNotReply@mercuryvmp.com)";
		mailToExpected = "automation@dntest.net";
		subjectExpected = "Vendor Accepted Assignment for Baseline Test-";
		templateUsedExpected = server+"XSiteStatusUpdate.html";
		successfulExpected = "1";
		fromEntityIDExpected = xSiteEntityID;
		toEntityIDExpected = originatorEntityID;

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
						+ mailFrom + " and should be = " + mailFromExpected);

		// Verify MailTo
		Assert.assertTrue(mailTo.equals(mailToExpected),
				"The MailTo entry in the database is incorrect. DB value = "
						+ mailTo + " and should be = " + mailToExpected);

		// Verify Subject
		Assert.assertTrue(subject.contains(subjectExpected),
				"The Subject entry in the database is incorrect. DB value = "
						+ subject + " and should be = " + subjectExpected);

		// Verify TemplateUsed
		Assert.assertTrue(templateUsed.toLowerCase().equals(templateUsedExpected.toLowerCase()),
				"The TemplateUsed entry in the database is incorrect. DB value = "
						+ templateUsed + " and should be = "
						+ templateUsedExpected);

		// Verify SentDateTime is not NULL
		Assert.assertTrue(!sentDateTime.toLowerCase().equals("null"),
				"The SentDateTime entry in the database is null!");

		// Verify Successful is 1
		Assert.assertTrue(successful.equals(successfulExpected),
				"The Successful entry in the database is incorrect. DB value = "
						+ successful + " and should be = " + successfulExpected);

		// Verify FromEntityID
		Assert.assertTrue(fromEntityID.equals(fromEntityIDExpected),
				"The FromEntityID entry in the database is incorrect. DB value = "
						+ fromEntityID + " and should be = "
						+ fromEntityIDExpected);

		// Verify ToEntityID
		Assert.assertTrue(toEntityID.equals(toEntityIDExpected),
				"The ToEntityID entry in the database is incorrect. DB value = "
						+ toEntityID + " and should be = " + toEntityIDExpected);

		/***********************************************************************************************
		 * Verify the VMP XSite Additional Recipient receives Vendor Accepted Assignment notifications in the database
		 ***********************************************************************************************/
		// Query the database and return the results as an array
		sqlStatement = "SELECT TOP 1 * FROM [dbo].[MailQueue] WHERE ProductItemID = '"
				+ vmpProductItemID + "' AND MailTo = '"+additionalRecipient1+"' ORDER BY EnteredStamp DESC";
		results = db
				.getMailQueueInfoBySQLToArray(driver, sqlStatement);

		// Set expected results
		mailFromExpected = "XSite Order on behalf of automation"+env+"Notifications1@dntest.net (MNDoNotReply@mercuryvmp.com)";
		mailToExpected = additionalRecipient1;
		subjectExpected = "Vendor Accepted Assignment for Baseline Test-";
		templateUsedExpected = server+"XSiteStatusUpdate_AddtlRecipients.html";
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
						+ mailFrom + " and should be = " + mailFromExpected);

		// Verify MailTo
		Assert.assertTrue(mailTo.equals(mailToExpected),
				"The MailTo entry in the database is incorrect. DB value = "
						+ mailTo + " and should be = " + mailToExpected);

		// Verify Subject
		Assert.assertTrue(subject.contains(subjectExpected),
				"The Subject entry in the database is incorrect. DB value = "
						+ subject + " and should be = " + subjectExpected);

		// Verify TemplateUsed
		Assert.assertTrue(templateUsed.toLowerCase().equals(templateUsedExpected.toLowerCase()),
				"The TemplateUsed entry in the database is incorrect. DB value = "
						+ templateUsed + " and should be = "
						+ templateUsedExpected);

		// Verify SentDateTime is not NULL
		Assert.assertTrue(!sentDateTime.toLowerCase().equals("null"),
				"The SentDateTime entry in the database is null!");

		// Verify Successful is 1
		Assert.assertTrue(successful.equals(successfulExpected),
				"The Successful entry in the database is incorrect. DB value = "
						+ successful + " and should be = " + successfulExpected);

		// Verify FromEntityID
		Assert.assertTrue(fromEntityID.equals(fromEntityIDExpected),
				"The FromEntityID entry in the database is incorrect. DB value = "
						+ fromEntityID + " and should be = "
						+ fromEntityIDExpected);

		// Verify ToEntityID
		Assert.assertTrue(toEntityID.equals(toEntityIDExpected),
				"The ToEntityID entry in the database is incorrect. DB value = "
						+ toEntityID + " and should be = " + toEntityIDExpected);

		// Log test
		test.log(LogStatus.INFO, "Notifications", "Accepted the order as the Vendor and verified the notifications");

	} // end acceptOrderAsVendor

	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Vendors</li>
	 * 	<li>Open the order</li>
	 * 	<li>Send a message as the Vendor</li>
	 * 	<li>Enter Notes</li>
	 * 	<li>Click Send</li>
	 * 	<li>Verify MailQueue row count for this vmp productItemID</li>
	 * 	<li>Verify MailQueue row count for this secure productItemID</li>
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
	 * 	<li>Managing Client Group Member receives Message notification</li>
	 * 	<li>Log test</li>
	 * </ul>
	 * @throws Exception the exception
	 */
	@Test (groups={}, dependsOnMethods="acceptOrderAsVendor")
	public void sendMessageAsTheVendor() throws Exception {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Login to Vendors
		vendors.login(driver, userVendors, password);

		// Open the order
		vendors.findAndOpenOrder(driver, orderNumber);

		// Send a message as the Vendor
		perform.click(driver,VOrderDetails.sendMessage_btn(driver));

		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);

		// Enter Notes
		perform.type(driver,VOrderDetails.sendMessageNotes_txtbx(driver), "These are test notes for notifications");

		// Click Send
		perform.click(driver,VOrderDetails.sendMessageOk_btn(driver));

		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);

		// Verify MailQueue row count for this vmp productItemID
		perform.verifyTheNumberOfRowsInTheMailQueueDBResultsForProductItemID(driver, 10, vmpProductItemID);

		// Verify MailQueue row count for this secure productItemID
		perform.verifyTheNumberOfRowsInTheMailQueueDBResultsForProductItemID(driver, 6, secureProductItemID);

		/***********************************************************************************************
		 * Verify the Secure EntityID receives Message notifications in the database
		 ***********************************************************************************************/
		// Query the database and return the results as an array
		String sqlStatement = "SELECT TOP 1 * FROM [dbo].[MailQueue] WHERE ProductItemID = '"
				+ secureProductItemID + "' AND ToEntityID = '"+secureEntityID+"' ORDER BY EnteredStamp DESC";
		ArrayList<String> results = db
				.getMailQueueInfoBySQLToArray(driver, sqlStatement);

		// Set expected results
		String mailFromExpected = "Mercury Network (MNDoNotReply@mercuryvmp.com)";
		String mailToExpected = "automation"+env+"Notifications1@dntest.net";
		String subjectExpected = "Order message for 501-D NE 122nd St, Oklahoma City, OK";
		String templateUsedExpected = server + "MN_Message.html";
		String successfulExpected = "1";
		String fromEntityIDExpected = vendorEntityID;
		String toEntityIDExpected = secureEntityID;

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
						+ mailFrom + " and should be = " + mailFromExpected);

		// Verify MailTo
		Assert.assertTrue(mailTo.equals(mailToExpected),
				"The MailTo entry in the database is incorrect. DB value = "
						+ mailTo + " and should be = " + mailToExpected);

		// Verify Subject
		Assert.assertTrue(subject.equals(subjectExpected),
				"The Subject entry in the database is incorrect. DB value = "
						+ subject + " and should be = " + subjectExpected);

		// Verify TemplateUsed
		Assert.assertTrue(templateUsed.toLowerCase().equals(templateUsedExpected.toLowerCase()),
				"The TemplateUsed entry in the database is incorrect. DB value = "
						+ templateUsed + " and should be = "
						+ templateUsedExpected);

		// Verify SentDateTime is not NULL
		Assert.assertTrue(!sentDateTime.toLowerCase().equals("null"),
				"The SentDateTime entry in the database is null!");

		// Verify Successful is 1
		Assert.assertTrue(successful.equals(successfulExpected),
				"The Successful entry in the database is incorrect. DB value = "
						+ successful + " and should be = " + successfulExpected);

		// Verify FromEntityID
		Assert.assertTrue(fromEntityID.equals(fromEntityIDExpected),
				"The FromEntityID entry in the database is incorrect. DB value = "
						+ fromEntityID + " and should be = "
						+ fromEntityIDExpected);

		// Verify ToEntityID
		Assert.assertTrue(toEntityID.equals(toEntityIDExpected),
				"The ToEntityID entry in the database is incorrect. DB value = "
						+ toEntityID + " and should be = " + toEntityIDExpected);

		/***********************************************************************************************
		 * Verify the Mercury Network Additional Recipient receives Message notifications in the database
		 ***********************************************************************************************/
		// Query the database and return the results as an array
		sqlStatement = "SELECT TOP 1 * FROM [dbo].[MailQueue] WHERE ProductItemID = '"
				+ secureProductItemID + "' AND MailTo = '"+additionalRecipient2+"' ORDER BY EnteredStamp DESC";
		results = db
				.getMailQueueInfoBySQLToArray(driver, sqlStatement);

		// Set expected results
		mailFromExpected = "Mercury Network (MNDoNotReply@mercuryvmp.com)";
		mailToExpected = additionalRecipient2;
		subjectExpected = "Order message for 501-D NE 122nd St, Oklahoma City, OK";
		templateUsedExpected = server + "MN_Message_AddtlRecipients.html";
		successfulExpected = "1";
		fromEntityIDExpected = vendorEntityID;
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
						+ mailFrom + " and should be = " + mailFromExpected);

		// Verify MailTo
		Assert.assertTrue(mailTo.equals(mailToExpected),
				"The MailTo entry in the database is incorrect. DB value = "
						+ mailTo + " and should be = " + mailToExpected);

		// Verify Subject
		Assert.assertTrue(subject.equals(subjectExpected),
				"The Subject entry in the database is incorrect. DB value = "
						+ subject + " and should be = " + subjectExpected);

		// Verify TemplateUsed
		Assert.assertTrue(templateUsed.toLowerCase().equals(templateUsedExpected.toLowerCase()),
				"The TemplateUsed entry in the database is incorrect. DB value = "
						+ templateUsed + " and should be = "
						+ templateUsedExpected);

		// Verify SentDateTime is not NULL
		Assert.assertTrue(!sentDateTime.toLowerCase().equals("null"),
				"The SentDateTime entry in the database is null!");

		// Verify Successful is 1
		Assert.assertTrue(successful.equals(successfulExpected),
				"The Successful entry in the database is incorrect. DB value = "
						+ successful + " and should be = " + successfulExpected);

		// Verify FromEntityID
		Assert.assertTrue(fromEntityID.equals(fromEntityIDExpected),
				"The FromEntityID entry in the database is incorrect. DB value = "
						+ fromEntityID + " and should be = "
						+ fromEntityIDExpected);

		// Verify ToEntityID
		Assert.assertTrue(toEntityID.equals(toEntityIDExpected),
				"The ToEntityID entry in the database is incorrect. DB value = "
						+ toEntityID + " and should be = " + toEntityIDExpected);

		/***********************************************************************************************
		 * Verify the Originator EntityID receives Message notifications in the database
		 ***********************************************************************************************/
		// Query the database and return the results as an array
		sqlStatement = "SELECT TOP 1 * FROM [dbo].[MailQueue] WHERE ProductItemID = '"
				+ vmpProductItemID + "' AND ToEntityID = '"+originatorEntityID+"' ORDER BY EnteredStamp DESC";
		results = db
				.getMailQueueInfoBySQLToArray(driver, sqlStatement);

		// Set expected results
		mailFromExpected = "XSite Order on behalf of automation"+env+"Notifications1@dntest.net (MNDoNotReply@mercuryvmp.com)";
		mailToExpected = "automation@dntest.net";
		subjectExpected = "Order message for 501-D NE 122nd St, Oklahoma City, OK";
		templateUsedExpected = server + "XSiteMessage.html";
		successfulExpected = "1";
		fromEntityIDExpected = xSiteEntityID;
		toEntityIDExpected = originatorEntityID;

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
						+ mailFrom + " and should be = " + mailFromExpected);

		// Verify MailTo
		Assert.assertTrue(mailTo.equals(mailToExpected),
				"The MailTo entry in the database is incorrect. DB value = "
						+ mailTo + " and should be = " + mailToExpected);

		// Verify Subject
		Assert.assertTrue(subject.equals(subjectExpected),
				"The Subject entry in the database is incorrect. DB value = "
						+ subject + " and should be = " + subjectExpected);

		// Verify TemplateUsed
		Assert.assertTrue(templateUsed.toLowerCase().equals(templateUsedExpected.toLowerCase()),
				"The TemplateUsed entry in the database is incorrect. DB value = "
						+ templateUsed + " and should be = "
						+ templateUsedExpected);

		// Verify SentDateTime is not NULL
		Assert.assertTrue(!sentDateTime.toLowerCase().equals("null"),
				"The SentDateTime entry in the database is null!");

		// Verify Successful is 1
		Assert.assertTrue(successful.equals(successfulExpected),
				"The Successful entry in the database is incorrect. DB value = "
						+ successful + " and should be = " + successfulExpected);

		// Verify FromEntityID
		Assert.assertTrue(fromEntityID.equals(fromEntityIDExpected),
				"The FromEntityID entry in the database is incorrect. DB value = "
						+ fromEntityID + " and should be = "
						+ fromEntityIDExpected);

		// Verify ToEntityID
		Assert.assertTrue(toEntityID.equals(toEntityIDExpected),
				"The ToEntityID entry in the database is incorrect. DB value = "
						+ toEntityID + " and should be = " + toEntityIDExpected);

		/***********************************************************************************************
		 * Verify the VMP XSite Additional Recipient receives Message notifications in the database
		 ***********************************************************************************************/
		// Query the database and return the results as an array
		sqlStatement = "SELECT TOP 1 * FROM [dbo].[MailQueue] WHERE ProductItemID = '"
				+ vmpProductItemID + "' AND MailTo = '"+additionalRecipient1+"' ORDER BY EnteredStamp DESC";
		results = db
				.getMailQueueInfoBySQLToArray(driver, sqlStatement);

		// Set expected results
		mailFromExpected = "XSite Order on behalf of automation"+env+"Notifications1@dntest.net (MNDoNotReply@mercuryvmp.com)";
		mailToExpected = additionalRecipient1;
		subjectExpected = "Order message for 501-D NE 122nd St, Oklahoma City, OK";
		templateUsedExpected = server + "XSiteMessage_AddtlRecipients.html";
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
						+ mailFrom + " and should be = " + mailFromExpected);

		// Verify MailTo
		Assert.assertTrue(mailTo.equals(mailToExpected),
				"The MailTo entry in the database is incorrect. DB value = "
						+ mailTo + " and should be = " + mailToExpected);

		// Verify Subject
		Assert.assertTrue(subject.equals(subjectExpected),
				"The Subject entry in the database is incorrect. DB value = "
						+ subject + " and should be = " + subjectExpected);

		// Verify TemplateUsed
		Assert.assertTrue(templateUsed.toLowerCase().equals(templateUsedExpected.toLowerCase()),
				"The TemplateUsed entry in the database is incorrect. DB value = "
						+ templateUsed + " and should be = "
						+ templateUsedExpected);

		// Verify SentDateTime is not NULL
		Assert.assertTrue(!sentDateTime.toLowerCase().equals("null"),
				"The SentDateTime entry in the database is null!");

		// Verify Successful is 1
		Assert.assertTrue(successful.equals(successfulExpected),
				"The Successful entry in the database is incorrect. DB value = "
						+ successful + " and should be = " + successfulExpected);

		// Verify FromEntityID
		Assert.assertTrue(fromEntityID.equals(fromEntityIDExpected),
				"The FromEntityID entry in the database is incorrect. DB value = "
						+ fromEntityID + " and should be = "
						+ fromEntityIDExpected);

		// Verify ToEntityID
		Assert.assertTrue(toEntityID.equals(toEntityIDExpected),
				"The ToEntityID entry in the database is incorrect. DB value = "
						+ toEntityID + " and should be = " + toEntityIDExpected);

		// Managing Client Group Member receives Message notification
		test.log(LogStatus.WARNING, "Notifications", "There is no notification in the database for the Managing Client Group Member receives Message. The matrix shows there should be");

		// Log test
		test.log(LogStatus.INFO, "Notifications", "Sent a message as the Vendor and verified the notifications");

	} // end sendMessageAsTheVendor

	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Vendors</li>
	 * 	<li>Open the order</li>
	 * 	<li>Set Inspection Scheduled as the Vendor</li>
	 * 	<li>Click Set Order Status</li>
	 * 	<li>Click Inspection Scheduled</li>
	 * 	<li>Click the calendar button</li>
	 * 	<li>Select date</li>
	 * 	<li>Verify the correct order due date is correct</li>
	 * 	<li>Add notes</li>
	 * 	<li>Click OK</li>
	 * 	<li>Verify MailQueue row count for this vmp productItemID</li>
	 * 	<li>Verify MailQueue row count for this secure productItemID</li>
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
	 * 	<li>VMP XSite Additional Recipient receives Inspection Scheduled notification</li>
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
	 * 	<li>Managing Client Group Member receives Inspection Scheduled notification</li>
	 * 	<li>Log test</li>
	 * </ul>
	 * @throws Exception the exception
	 */
	@Test (groups={}, dependsOnMethods="sendMessageAsTheVendor")
	public void setInspectionScheduled() throws Exception {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Login to Vendors
		vendors.login(driver, userVendors, password);

		// Open the order
		vendors.findAndOpenOrder(driver, orderNumber);

		// Set Inspection Scheduled as the Vendor
		// Click Set Order Status
		perform.click(driver,VOrderDetails.setOrderStatus_btn(driver));

		// Click Inspection Scheduled
		perform.click(driver,VOrderDetails.inspectionScheduled_btn(driver));

		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);

		// Wait for the OK button
		perform.waitForElementToBeClickable(driver, VOrderDetails.inspectionScheduledOk_btn(), "cssSelector");

		// Click the calendar button
		perform.click(driver,VOrderDetails.inspectionScheduledCalendar_btn(driver));

		// Select date
		secure.selectDateFromCalendar(driver, 1);

		// Verify the correct order due date is correct
		Assert.assertTrue(VOrderDetails.inspectionScheduledCalendar_txtbx(driver).getAttribute("value").equals(StoredVariables.getcalendarDateLong().get()), "Date selected from calendar is the wrong date");

		// Add notes
		perform.type(driver,VOrderDetails.inspectionScheduledNotes_txtbx(driver), "These are Inspection Scheduled notes for Notifications tests");

		// Click OK
		perform.click(driver,VOrderDetails.inspectionScheduledOk_btn(driver));

		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);

		// Verify MailQueue row count for this vmp productItemID
		perform.verifyTheNumberOfRowsInTheMailQueueDBResultsForProductItemID(driver, 12, vmpProductItemID);

		// Verify MailQueue row count for this secure productItemID
		perform.verifyTheNumberOfRowsInTheMailQueueDBResultsForProductItemID(driver, 8, secureProductItemID);

		/***********************************************************************************************
		 * Verify the Secure EntityID receives Inspection Scheduled notifications in the database
		 ***********************************************************************************************/
		// Query the database and return the results as an array
		String sqlStatement = "SELECT TOP 1 * FROM [dbo].[MailQueue] WHERE ProductItemID = '"
				+ secureProductItemID + "' AND ToEntityID = '"+secureEntityID+"' ORDER BY EnteredStamp DESC";
		ArrayList<String> results = db
				.getMailQueueInfoBySQLToArray(driver, sqlStatement);

		// Set expected results
		String mailFromExpected = "Mercury Network (MNDoNotReply@mercuryvmp.com)";
		String mailToExpected = "automation"+env+"Notifications1@dntest.net";
		String subjectExpected = "Inspection Scheduled for Baseline Test-";
		String templateUsedExpected = server + "MN_InspectionScheduled.html";
		String successfulExpected = "1";
		String fromEntityIDExpected = vendorEntityID;
		String toEntityIDExpected = secureEntityID;

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
						+ mailFrom + " and should be = " + mailFromExpected);

		// Verify MailTo
		Assert.assertTrue(mailTo.equals(mailToExpected),
				"The MailTo entry in the database is incorrect. DB value = "
						+ mailTo + " and should be = " + mailToExpected);

		// Verify Subject
		Assert.assertTrue(subject.contains(subjectExpected),
				"The Subject entry in the database is incorrect. DB value = "
						+ subject + " and should be = " + subjectExpected);

		// Verify TemplateUsed
		Assert.assertTrue(templateUsed.toLowerCase().equals(templateUsedExpected.toLowerCase()),
				"The TemplateUsed entry in the database is incorrect. DB value = "
						+ templateUsed + " and should be = "
						+ templateUsedExpected);

		// Verify SentDateTime is not NULL
		Assert.assertTrue(!sentDateTime.toLowerCase().equals("null"),
				"The SentDateTime entry in the database is null!");

		// Verify Successful is 1
		Assert.assertTrue(successful.equals(successfulExpected),
				"The Successful entry in the database is incorrect. DB value = "
						+ successful + " and should be = " + successfulExpected);

		// Verify FromEntityID
		Assert.assertTrue(fromEntityID.equals(fromEntityIDExpected),
				"The FromEntityID entry in the database is incorrect. DB value = "
						+ fromEntityID + " and should be = "
						+ fromEntityIDExpected);

		// Verify ToEntityID
		Assert.assertTrue(toEntityID.equals(toEntityIDExpected),
				"The ToEntityID entry in the database is incorrect. DB value = "
						+ toEntityID + " and should be = " + toEntityIDExpected);

		/***********************************************************************************************
		 * Verify the Mercury Network Additional Recipient receives Inspection Scheduled notifications in the database
		 ***********************************************************************************************/
		// Query the database and return the results as an array
		sqlStatement = "SELECT TOP 1 * FROM [dbo].[MailQueue] WHERE ProductItemID = '"
				+ secureProductItemID + "' AND MailTo = '"+additionalRecipient2+"' ORDER BY EnteredStamp DESC";
		results = db
				.getMailQueueInfoBySQLToArray(driver, sqlStatement);

		// Set expected results
		mailFromExpected = "Mercury Network (MNDoNotReply@mercuryvmp.com)";
		mailToExpected = additionalRecipient2;
		subjectExpected = "Inspection Scheduled for Baseline Test-";
		templateUsedExpected = server + "MN_InspectionScheduled_AddtlRecipients.html";
		successfulExpected = "1";
		fromEntityIDExpected = vendorEntityID;
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
						+ mailFrom + " and should be = " + mailFromExpected);

		// Verify MailTo
		Assert.assertTrue(mailTo.equals(mailToExpected),
				"The MailTo entry in the database is incorrect. DB value = "
						+ mailTo + " and should be = " + mailToExpected);

		// Verify Subject
		Assert.assertTrue(subject.contains(subjectExpected),
				"The Subject entry in the database is incorrect. DB value = "
						+ subject + " and should be = " + subjectExpected);

		// Verify TemplateUsed
		Assert.assertTrue(templateUsed.toLowerCase().equals(templateUsedExpected.toLowerCase()),
				"The TemplateUsed entry in the database is incorrect. DB value = "
						+ templateUsed + " and should be = "
						+ templateUsedExpected);

		// Verify SentDateTime is not NULL
		Assert.assertTrue(!sentDateTime.toLowerCase().equals("null"),
				"The SentDateTime entry in the database is null!");

		// Verify Successful is 1
		Assert.assertTrue(successful.equals(successfulExpected),
				"The Successful entry in the database is incorrect. DB value = "
						+ successful + " and should be = " + successfulExpected);

		// Verify FromEntityID
		Assert.assertTrue(fromEntityID.equals(fromEntityIDExpected),
				"The FromEntityID entry in the database is incorrect. DB value = "
						+ fromEntityID + " and should be = "
						+ fromEntityIDExpected);

		// Verify ToEntityID
		Assert.assertTrue(toEntityID.equals(toEntityIDExpected),
				"The ToEntityID entry in the database is incorrect. DB value = "
						+ toEntityID + " and should be = " + toEntityIDExpected);

		/***********************************************************************************************
		 * Verify the Originator EntityID receives Inspection Scheduled notifications in the database
		 ***********************************************************************************************/
		// Query the database and return the results as an array
		sqlStatement = "SELECT TOP 1 * FROM [dbo].[MailQueue] WHERE ProductItemID = '"
				+ vmpProductItemID + "' AND ToEntityID = '"+originatorEntityID+"' ORDER BY EnteredStamp DESC";
		results = db
				.getMailQueueInfoBySQLToArray(driver, sqlStatement);

		// Set expected results
		mailFromExpected = "XSite Order on behalf of automation"+env+"Notifications1@dntest.net (MNDoNotReply@mercuryvmp.com)";
		mailToExpected = "automation@dntest.net";
		subjectExpected = "Inspection Scheduled for Baseline Test-";
		templateUsedExpected = server + "XSiteStatusUpdate.html";
		successfulExpected = "1";
		fromEntityIDExpected = xSiteEntityID;
		toEntityIDExpected = originatorEntityID;

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
						+ mailFrom + " and should be = " + mailFromExpected);

		// Verify MailTo
		Assert.assertTrue(mailTo.equals(mailToExpected),
				"The MailTo entry in the database is incorrect. DB value = "
						+ mailTo + " and should be = " + mailToExpected);

		// Verify Subject
		Assert.assertTrue(subject.contains(subjectExpected),
				"The Subject entry in the database is incorrect. DB value = "
						+ subject + " and should be = " + subjectExpected);

		// Verify TemplateUsed
		Assert.assertTrue(templateUsed.toLowerCase().equals(templateUsedExpected.toLowerCase()),
				"The TemplateUsed entry in the database is incorrect. DB value = "
						+ templateUsed + " and should be = "
						+ templateUsedExpected);

		// Verify SentDateTime is not NULL
		Assert.assertTrue(!sentDateTime.toLowerCase().equals("null"),
				"The SentDateTime entry in the database is null!");

		// Verify Successful is 1
		Assert.assertTrue(successful.equals(successfulExpected),
				"The Successful entry in the database is incorrect. DB value = "
						+ successful + " and should be = " + successfulExpected);

		// Verify FromEntityID
		Assert.assertTrue(fromEntityID.equals(fromEntityIDExpected),
				"The FromEntityID entry in the database is incorrect. DB value = "
						+ fromEntityID + " and should be = "
						+ fromEntityIDExpected);

		// Verify ToEntityID
		Assert.assertTrue(toEntityID.equals(toEntityIDExpected),
				"The ToEntityID entry in the database is incorrect. DB value = "
						+ toEntityID + " and should be = " + toEntityIDExpected);

		// VMP XSite Additional Recipient receives Inspection Scheduled notification
		/***********************************************************************************************
		 * Verify the notifications in the database
		 ***********************************************************************************************/
		// Query the database and return the results as an array
		sqlStatement = "SELECT TOP 1 * FROM [dbo].[MailQueue] WHERE ProductItemID = '"
				+ vmpProductItemID + "' AND MailTo = '"+additionalRecipient1+"' ORDER BY EnteredStamp DESC";
		results = db
				.getMailQueueInfoBySQLToArray(driver, sqlStatement);

		// Set expected results
		mailFromExpected = "XSite Order on behalf of automation"+env+"Notifications1@dntest.net (MNDoNotReply@mercuryvmp.com)";
		mailToExpected = additionalRecipient1;
		subjectExpected = "Inspection Scheduled for Baseline Test-";
		templateUsedExpected = server + "XSiteStatusUpdate_AddtlRecipients.html";
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
						+ mailFrom + " and should be = " + mailFromExpected);

		// Verify MailTo
		Assert.assertTrue(mailTo.equals(mailToExpected),
				"The MailTo entry in the database is incorrect. DB value = "
						+ mailTo + " and should be = " + mailToExpected);

		// Verify Subject
		Assert.assertTrue(subject.contains(subjectExpected),
				"The Subject entry in the database is incorrect. DB value = "
						+ subject + " and should be = " + subjectExpected);

		// Verify TemplateUsed
		Assert.assertTrue(templateUsed.toLowerCase().equals(templateUsedExpected.toLowerCase()),
				"The TemplateUsed entry in the database is incorrect. DB value = "
						+ templateUsed + " and should be = "
						+ templateUsedExpected);

		// Verify SentDateTime is not NULL
		Assert.assertTrue(!sentDateTime.toLowerCase().equals("null"),
				"The SentDateTime entry in the database is null!");

		// Verify Successful is 1
		Assert.assertTrue(successful.equals(successfulExpected),
				"The Successful entry in the database is incorrect. DB value = "
						+ successful + " and should be = " + successfulExpected);

		// Verify FromEntityID
		Assert.assertTrue(fromEntityID.equals(fromEntityIDExpected),
				"The FromEntityID entry in the database is incorrect. DB value = "
						+ fromEntityID + " and should be = "
						+ fromEntityIDExpected);

		// Verify ToEntityID
		Assert.assertTrue(toEntityID.equals(toEntityIDExpected),
				"The ToEntityID entry in the database is incorrect. DB value = "
						+ toEntityID + " and should be = " + toEntityIDExpected);

		// Managing Client Group Member receives Inspection Scheduled notification
		test.log(LogStatus.WARNING, "Notifications", "There is no notification in the database for the Managing Client Group Member receives Inspection Scheduled. The matrix shows there should be");

		// Log test
		test.log(LogStatus.INFO, "Notifications", "Set Inspection Scheduled as the Vendor and verified the notifications");

	} // end setInspectionScheduled

	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Send a Message as the Originator</li>
	 * 	<li>Log in to VMP</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Click Send Message</li>
	 * 	<li>Enter Notes</li>
	 * 	<li>Click Send</li>
	 * 	<li>Click OK button</li>
	 * 	<li>Verify MailQueue row count for this vmp productItemID</li>
	 * 	<li>Verify MailQueue row count for this secure productItemID</li>
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
	 * </ul>
	 * @throws Exception the exception
	 */
	@Test (groups={}, dependsOnMethods="setInspectionScheduled")
	public void sendMessageAsOriginator() throws Exception {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Send a Message as the Originator
		// Log in to VMP
		vmp.login(driver, userSecure, userVMP, password);

		// Find the order
		vmp.findOrder(driver, orderNumberVMP, "Tracking #");

		// Open the order
		vmp.openOrder(driver, orderNumberVMP);

		// Click Send Message
		perform.click(driver,VMPOrderDetails.sendMessage_btn(driver));

		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);

		// Wait for Send button
		perform.waitForElementToBeClickable(driver, VMPOrderDetails.send_btn(), "cssSelector");

		// Enter Notes
		perform.type(driver,VMPOrderDetails.notes_txtbox(driver), "These are originator message notes for Notifications test");

		// Click Send
		perform.click(driver,VMPOrderDetails.send_btn(driver));

		// Wait for OK button
		perform.waitForElementToBeClickable(driver, VMPOrderDetails.ok_btn(), "cssSelector");

		// Click OK button
		perform.click(driver,VMPOrderDetails.ok_btn(driver));

		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);

		// Verify MailQueue row count for this vmp productItemID
		perform.verifyTheNumberOfRowsInTheMailQueueDBResultsForProductItemID(driver, 13, vmpProductItemID);

		// Verify MailQueue row count for this secure productItemID
		perform.verifyTheNumberOfRowsInTheMailQueueDBResultsForProductItemID(driver, 9, secureProductItemID);

		/***********************************************************************************************
		 * Verify the Vendor EntityID receives Message notifications in the database
		 ***********************************************************************************************/
		// Query the database and return the results as an array
		String sqlStatement = "SELECT TOP 1 * FROM [dbo].[MailQueue] WHERE ProductItemID = '"
				+ secureProductItemID + "' AND ToEntityID = '"+vendorEntityID+"' ORDER BY EnteredStamp DESC";
		ArrayList<String> results = db
				.getMailQueueInfoBySQLToArray(driver, sqlStatement);

		// Set expected results
		String mailFromExpected = "Mercury Network (MNDoNotReply@mercuryvmp.com)";
		String mailToExpected = "automation"+env+"NotificationsAppraiser2@dntest.net";
		String subjectExpected = "Order message for 501-D NE 122nd St Oklahoma City, OK 73114";
		String templateUsedExpected = server + "MN_Message.html";
		String successfulExpected = "1";
		String fromEntityIDExpected = secureEntityID;
		String toEntityIDExpected = vendorEntityID;

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
						+ mailFrom + " and should be = " + mailFromExpected);

		// Verify MailTo
		Assert.assertTrue(mailTo.equals(mailToExpected),
				"The MailTo entry in the database is incorrect. DB value = "
						+ mailTo + " and should be = " + mailToExpected);

		// Verify Subject
		Assert.assertTrue(subject.equals(subjectExpected),
				"The Subject entry in the database is incorrect. DB value = "
						+ subject + " and should be = " + subjectExpected);

		// Verify TemplateUsed
		Assert.assertTrue(templateUsed.toLowerCase().equals(templateUsedExpected.toLowerCase()),
				"The TemplateUsed entry in the database is incorrect. DB value = "
						+ templateUsed + " and should be = "
						+ templateUsedExpected);

		// Verify SentDateTime is not NULL
		Assert.assertTrue(!sentDateTime.toLowerCase().equals("null"),
				"The SentDateTime entry in the database is null!");

		// Verify Successful is 1
		Assert.assertTrue(successful.equals(successfulExpected),
				"The Successful entry in the database is incorrect. DB value = "
						+ successful + " and should be = " + successfulExpected);

		// Verify FromEntityID
		Assert.assertTrue(fromEntityID.equals(fromEntityIDExpected),
				"The FromEntityID entry in the database is incorrect. DB value = "
						+ fromEntityID + " and should be = "
						+ fromEntityIDExpected);

		// Verify ToEntityID
		Assert.assertTrue(toEntityID.equals(toEntityIDExpected),
				"The ToEntityID entry in the database is incorrect. DB value = "
						+ toEntityID + " and should be = " + toEntityIDExpected);

		/***********************************************************************************************
		 * Verify the Secure XSite EntityID receives Message notifications in the database
		 ***********************************************************************************************/
		// Query the database and return the results as an array
		sqlStatement = "SELECT TOP 1 * FROM [dbo].[MailQueue] WHERE ProductItemID = '"
				+ vmpProductItemID + "' AND ToEntityID = '"+xSiteEntityID+"' ORDER BY EnteredStamp DESC";
		results = db
				.getMailQueueInfoBySQLToArray(driver, sqlStatement);

		// Set expected results
		mailFromExpected = "XSite Order on behalf of automation@dntest.net (MNDoNotReply@mercuryvmp.com)";
		mailToExpected = "automation"+env+"Notifications1@dntest.net";
		subjectExpected = "Order message for 501-D NE 122nd St Oklahoma City, OK 73114";
		templateUsedExpected = server + "XSiteMessage.html";
		successfulExpected = "1";
		fromEntityIDExpected = originatorEntityID;
		toEntityIDExpected = xSiteEntityID;

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
						+ mailFrom + " and should be = " + mailFromExpected);

		// Verify MailTo
		Assert.assertTrue(mailTo.equals(mailToExpected),
				"The MailTo entry in the database is incorrect. DB value = "
						+ mailTo + " and should be = " + mailToExpected);

		// Verify Subject
		Assert.assertTrue(subject.equals(subjectExpected),
				"The Subject entry in the database is incorrect. DB value = "
						+ subject + " and should be = " + subjectExpected);

		// Verify TemplateUsed
		Assert.assertTrue(templateUsed.toLowerCase().equals(templateUsedExpected.toLowerCase()),
				"The TemplateUsed entry in the database is incorrect. DB value = "
						+ templateUsed + " and should be = "
						+ templateUsedExpected);

		// Verify SentDateTime is not NULL
		Assert.assertTrue(!sentDateTime.toLowerCase().equals("null"),
				"The SentDateTime entry in the database is null!");

		// Verify Successful is 1
		Assert.assertTrue(successful.equals(successfulExpected),
				"The Successful entry in the database is incorrect. DB value = "
						+ successful + " and should be = " + successfulExpected);

		// Verify FromEntityID
		Assert.assertTrue(fromEntityID.equals(fromEntityIDExpected),
				"The FromEntityID entry in the database is incorrect. DB value = "
						+ fromEntityID + " and should be = "
						+ fromEntityIDExpected);

		// Verify ToEntityID
		Assert.assertTrue(toEntityID.equals(toEntityIDExpected),
				"The ToEntityID entry in the database is incorrect. DB value = "
						+ toEntityID + " and should be = " + toEntityIDExpected);

		// Log test
		test.log(LogStatus.INFO, "Notifications", "Sent a message as the originator and verified the notifications");

	} // end sendMessageAsOriginator

	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Send a Message as the Secure MN user (check the box)</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Find order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Click Message</li>
	 * 	<li>Enter Notes</li>
	 * 	<li>Check Update the Message status checkbox</li>
	 * 	<li>Click OK</li>
	 * 	<li>Verify MailQueue row count for this vmp productItemID</li>
	 * 	<li>Verify MailQueue row count for this secure productItemID</li>
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
	 * 	<li>Managing Client Group Member receives Message notification</li>
	 * 	<li>Log test</li>
	 * </ul>
	 * @throws Exception the exception
	 */
	@Test (groups={}, dependsOnMethods="sendMessageAsOriginator")
	public void sendMessageFromSecure() throws Exception {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Send a Message as the Secure MN user (check the box)
		// Log in to Secure
		secure.login(driver, userSecure, password);

		// Find order
		secure.findOrder(driver, orderNumber, "Tracking number");

		// Open the order
		secure.openOrder(driver, orderNumber);

		// Click Message
		perform.click(driver,SOrderDetails.message_btn(driver));

		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);

		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SOrderDetails.messageOk_btn(), "id");

		// Enter Notes
		perform.type(driver,SOrderDetails.sendMessage_txtbx(driver), "These are secure notes for Notifications tests");

		// Check Update the Message status checkbox
		perform.checkCheckbox(driver, SOrderDetails.sendMessageUpdateStatusOnVMP_chkbx(driver));

		// Click OK
		perform.click(driver,SOrderDetails.messageOk_btn(driver));

		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);

		// Verify MailQueue row count for this vmp productItemID
		perform.verifyTheNumberOfRowsInTheMailQueueDBResultsForProductItemID(driver, 15, vmpProductItemID);

		// Verify MailQueue row count for this secure productItemID
		perform.verifyTheNumberOfRowsInTheMailQueueDBResultsForProductItemID(driver, 10, secureProductItemID);

		/***********************************************************************************************
		 * Verify the Vendor EntityID receives Message notifications in the database
		 ***********************************************************************************************/
		// Query the database and return the results as an array
		String sqlStatement = "SELECT TOP 1 * FROM [dbo].[MailQueue] WHERE ProductItemID = '"
				+ secureProductItemID + "' AND ToEntityID = '"+vendorEntityID+"' ORDER BY EnteredStamp DESC";
		ArrayList<String> results = db
				.getMailQueueInfoBySQLToArray(driver, sqlStatement);

		// Set expected results
		String mailFromExpected = "Mercury Network (MNDoNotReply@mercuryvmp.com)";
		String mailToExpected = "automation"+env+"NotificationsAppraiser2@dntest.net";
		String subjectExpected = "Order message for 501-D NE 122nd St, Oklahoma City, OK";
		String templateUsedExpected = server + "MN_Message.html";
		String successfulExpected = "1";
		String fromEntityIDExpected = secureEntityID;
		String toEntityIDExpected = vendorEntityID;

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
						+ mailFrom + " and should be = " + mailFromExpected);

		// Verify MailTo
		Assert.assertTrue(mailTo.equals(mailToExpected),
				"The MailTo entry in the database is incorrect. DB value = "
						+ mailTo + " and should be = " + mailToExpected);

		// Verify Subject
		Assert.assertTrue(subject.equals(subjectExpected),
				"The Subject entry in the database is incorrect. DB value = "
						+ subject + " and should be = " + subjectExpected);

		// Verify TemplateUsed
		Assert.assertTrue(templateUsed.toLowerCase().equals(templateUsedExpected.toLowerCase()),
				"The TemplateUsed entry in the database is incorrect. DB value = "
						+ templateUsed + " and should be = "
						+ templateUsedExpected);

		// Verify SentDateTime is not NULL
		Assert.assertTrue(!sentDateTime.toLowerCase().equals("null"),
				"The SentDateTime entry in the database is null!");

		// Verify Successful is 1
		Assert.assertTrue(successful.equals(successfulExpected),
				"The Successful entry in the database is incorrect. DB value = "
						+ successful + " and should be = " + successfulExpected);

		// Verify FromEntityID
		Assert.assertTrue(fromEntityID.equals(fromEntityIDExpected),
				"The FromEntityID entry in the database is incorrect. DB value = "
						+ fromEntityID + " and should be = "
						+ fromEntityIDExpected);

		// Verify ToEntityID
		Assert.assertTrue(toEntityID.equals(toEntityIDExpected),
				"The ToEntityID entry in the database is incorrect. DB value = "
						+ toEntityID + " and should be = " + toEntityIDExpected);

		/***********************************************************************************************
		 * Verify the Originator EntityID receives Message notifications in the database
		 ***********************************************************************************************/
		// Query the database and return the results as an array
		sqlStatement = "SELECT TOP 1 * FROM [dbo].[MailQueue] WHERE ProductItemID = '"
				+ vmpProductItemID + "' AND ToEntityID = '"+originatorEntityID+"' ORDER BY EnteredStamp DESC";
		results = db
				.getMailQueueInfoBySQLToArray(driver, sqlStatement);

		// Set expected results
		mailFromExpected = "XSite Order on behalf of automation"+env+"Notifications1@dntest.net (MNDoNotReply@mercuryvmp.com)";
		mailToExpected = "automation@dntest.net";
		subjectExpected = "Order message for 501-D NE 122nd St, Oklahoma City, OK";
		templateUsedExpected = server + "XSiteMessage.html";
		successfulExpected = "1";
		fromEntityIDExpected = xSiteEntityID;
		toEntityIDExpected = originatorEntityID;

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
						+ mailFrom + " and should be = " + mailFromExpected);

		// Verify MailTo
		Assert.assertTrue(mailTo.equals(mailToExpected),
				"The MailTo entry in the database is incorrect. DB value = "
						+ mailTo + " and should be = " + mailToExpected);

		// Verify Subject
		Assert.assertTrue(subject.equals(subjectExpected),
				"The Subject entry in the database is incorrect. DB value = "
						+ subject + " and should be = " + subjectExpected);

		// Verify TemplateUsed
		Assert.assertTrue(templateUsed.toLowerCase().equals(templateUsedExpected.toLowerCase()),
				"The TemplateUsed entry in the database is incorrect. DB value = "
						+ templateUsed + " and should be = "
						+ templateUsedExpected);

		// Verify SentDateTime is not NULL
		Assert.assertTrue(!sentDateTime.toLowerCase().equals("null"),
				"The SentDateTime entry in the database is null!");

		// Verify Successful is 1
		Assert.assertTrue(successful.equals(successfulExpected),
				"The Successful entry in the database is incorrect. DB value = "
						+ successful + " and should be = " + successfulExpected);

		// Verify FromEntityID
		Assert.assertTrue(fromEntityID.equals(fromEntityIDExpected),
				"The FromEntityID entry in the database is incorrect. DB value = "
						+ fromEntityID + " and should be = "
						+ fromEntityIDExpected);

		// Verify ToEntityID
		Assert.assertTrue(toEntityID.equals(toEntityIDExpected),
				"The ToEntityID entry in the database is incorrect. DB value = "
						+ toEntityID + " and should be = " + toEntityIDExpected);

		/***********************************************************************************************
		 * Verify the VMP XSite Additional Recipient receives Message notifications in the database
		 ***********************************************************************************************/
		// Query the database and return the results as an array
		sqlStatement = "SELECT TOP 1 * FROM [dbo].[MailQueue] WHERE ProductItemID = '"
				+ vmpProductItemID + "' AND MailTo = '"+additionalRecipient1+"' ORDER BY EnteredStamp DESC";
		results = db
				.getMailQueueInfoBySQLToArray(driver, sqlStatement);

		// Set expected results
		mailFromExpected = "XSite Order on behalf of automation"+env+"Notifications1@dntest.net (MNDoNotReply@mercuryvmp.com)";
		mailToExpected = additionalRecipient1;
		subjectExpected = "Order message for 501-D NE 122nd St, Oklahoma City, OK";
		templateUsedExpected = server + "XSiteMessage_AddtlRecipients.html";
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
						+ mailFrom + " and should be = " + mailFromExpected);

		// Verify MailTo
		Assert.assertTrue(mailTo.equals(mailToExpected),
				"The MailTo entry in the database is incorrect. DB value = "
						+ mailTo + " and should be = " + mailToExpected);

		// Verify Subject
		Assert.assertTrue(subject.equals(subjectExpected),
				"The Subject entry in the database is incorrect. DB value = "
						+ subject + " and should be = " + subjectExpected);

		// Verify TemplateUsed
		Assert.assertTrue(templateUsed.toLowerCase().equals(templateUsedExpected.toLowerCase()),
				"The TemplateUsed entry in the database is incorrect. DB value = "
						+ templateUsed + " and should be = "
						+ templateUsedExpected);

		// Verify SentDateTime is not NULL
		Assert.assertTrue(!sentDateTime.toLowerCase().equals("null"),
				"The SentDateTime entry in the database is null!");

		// Verify Successful is 1
		Assert.assertTrue(successful.equals(successfulExpected),
				"The Successful entry in the database is incorrect. DB value = "
						+ successful + " and should be = " + successfulExpected);

		// Verify FromEntityID
		Assert.assertTrue(fromEntityID.equals(fromEntityIDExpected),
				"The FromEntityID entry in the database is incorrect. DB value = "
						+ fromEntityID + " and should be = "
						+ fromEntityIDExpected);

		// Verify ToEntityID
		Assert.assertTrue(toEntityID.equals(toEntityIDExpected),
				"The ToEntityID entry in the database is incorrect. DB value = "
						+ toEntityID + " and should be = " + toEntityIDExpected);

		// Managing Client Group Member receives Message notification
		test.log(LogStatus.WARNING, "Notifications", "There is no notification in the database for the Managing Client Group Member receives Message. The matrix shows there should be");

		// Log test
		test.log(LogStatus.INFO, "Notifications", "Sent a message from Secure and verified the notifications");

	} // end sendMessageFromSecure

	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Deliver a report as the Vendor</li>
	 * 	<li>Login to Vendors</li>
	 * 	<li>Open Order</li>
	 * 	<li>Complete the order</li>
	 * 	<li>Verify MailQueue row count for this vmp productItemID</li>
	 * 	<li>Verify MailQueue row count for this secure productItemID</li>
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
	 * 	<li>Verify Attachments</li>
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
	 * 	<li>Verify Attachments</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (groups={}, dependsOnMethods="sendMessageFromSecure")
	public void deliverReportAsVendor() throws Exception {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Deliver a report as the Vendor
		// Login to Vendors
		vendors.login(driver, userVendors, password);

		// Open Order
		vendors.findAndOpenOrder(driver, orderNumber);

		// Complete the order
		vendors.completeOrderByHTTPPost(driver, userVendors, StoredVariables.getpassword().get(), orderNumber, "Complete.xml");

		// Verify MailQueue row count for this vmp productItemID
		perform.verifyTheNumberOfRowsInTheMailQueueDBResultsForProductItemID(driver, 17, vmpProductItemID);

		// Verify MailQueue row count for this secure productItemID
		perform.verifyTheNumberOfRowsInTheMailQueueDBResultsForProductItemID(driver, 12, secureProductItemID);

		/***********************************************************************************************
		 * Verify the Secure EntityID receives the In QC - Level One notifications in the database
		 ***********************************************************************************************/
		// Query the database and return the results as an array
		String sqlStatement = "SELECT TOP 1 * FROM [dbo].[MailQueue] WHERE ProductItemID = '"
				+ secureProductItemID + "' AND ToEntityID = '"+secureEntityID+"' ORDER BY EnteredStamp DESC";
		ArrayList<String> results = db
				.getMailQueueInfoBySQLToArray(driver, sqlStatement);

		// Set expected results
		String mailFromExpected = "Mercury Network (MNDoNotReply@mercuryvmp.com)";
		String mailToExpected = "automation"+env+"Notifications1@dntest.net";
		String subjectExpected = "Order In QC - Level One for Baseline Test-";
		String templateUsedExpected = server + "MN_ReportInQCLevelOne.html";
		if (env.equals("Beta"))
		{
			templateUsedExpected = "\\\\ss1.internal.ad.mercuryvmp.com\\Shared Storage\\MercuryEmailTemplates\\Production\\MN_ReportInQCLevelOne.html";
		}
		String successfulExpected = "1";
		String fromEntityIDExpected = vendorEntityID;
		String toEntityIDExpected = secureEntityID;

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
						+ mailFrom + " and should be = " + mailFromExpected);

		// Verify MailTo
		Assert.assertTrue(mailTo.equals(mailToExpected),
				"The MailTo entry in the database is incorrect. DB value = "
						+ mailTo + " and should be = " + mailToExpected);

		// Verify Subject
		Assert.assertTrue(subject.contains(subjectExpected),
				"The Subject entry in the database is incorrect. DB value = "
						+ subject + " and should be = " + subjectExpected);

		// Verify TemplateUsed
		Assert.assertTrue(templateUsed.toLowerCase().equals(templateUsedExpected.toLowerCase()),
				"The TemplateUsed entry in the database is incorrect. DB value = "
						+ templateUsed + " and should be = "
						+ templateUsedExpected);

		// Verify SentDateTime is not NULL
		Assert.assertTrue(!sentDateTime.toLowerCase().equals("null"),
				"The SentDateTime entry in the database is null!");

		// Verify Successful is 1
		Assert.assertTrue(successful.equals(successfulExpected),
				"The Successful entry in the database is incorrect. DB value = "
						+ successful + " and should be = " + successfulExpected);

		// Verify FromEntityID
		Assert.assertTrue(fromEntityID.equals(fromEntityIDExpected),
				"The FromEntityID entry in the database is incorrect. DB value = "
						+ fromEntityID + " and should be = "
						+ fromEntityIDExpected);

		// Verify ToEntityID
		Assert.assertTrue(toEntityID.equals(toEntityIDExpected),
				"The ToEntityID entry in the database is incorrect. DB value = "
						+ toEntityID + " and should be = " + toEntityIDExpected);

		/***********************************************************************************************
		 * Verify the Mercury Network Additional Recipient receives the In QC - Level One notification w/ completed report attached notifications in the database
		 ***********************************************************************************************/
		// Query the database and return the results as an array
		sqlStatement = "SELECT TOP 1 * FROM [dbo].[MailQueue] WHERE ProductItemID = '"
				+ secureProductItemID + "' AND MailTo = '"+additionalRecipient2+"' ORDER BY EnteredStamp DESC";
		results = db
				.getMailQueueInfoBySQLToArray(driver, sqlStatement);

		// Set expected results
		mailFromExpected = "Mercury Network (MNDoNotReply@mercuryvmp.com)";
		mailToExpected = additionalRecipient2;
		subjectExpected = "Order In QC - Level One for Baseline Test-";
		templateUsedExpected = server + "MN_ReportInQCLevelOne_AddtlRecipients.html";
		if (env.equals("Beta"))
		{
			templateUsedExpected = "\\\\ss1.internal.ad.mercuryvmp.com\\Shared Storage\\MercuryEmailTemplates\\Production\\MN_ReportInQCLevelOne_AddtlRecipients.html";
		}
		successfulExpected = "1";
		fromEntityIDExpected = vendorEntityID;
		toEntityIDExpected = "NULL";
		String attachmentsExpected = "Test PDF.pdf";

		// Set database values
		mailFrom = results.get(4);
		mailTo = results.get(5);
		subject = results.get(8);
		templateUsed = results.get(9);
		String attachments = results.get(10);
		sentDateTime = results.get(11);
		successful = results.get(12);
		fromEntityID = results.get(13);
		toEntityID = results.get(14);

		// Verify MailFrom
		Assert.assertTrue(mailFrom.equals(mailFromExpected),
				"The MailFrom entry in the database is incorrect. DB value = "
						+ mailFrom + " and should be = " + mailFromExpected);

		// Verify MailTo
		Assert.assertTrue(mailTo.equals(mailToExpected),
				"The MailTo entry in the database is incorrect. DB value = "
						+ mailTo + " and should be = " + mailToExpected);

		// Verify Subject
		Assert.assertTrue(subject.contains(subjectExpected),
				"The Subject entry in the database is incorrect. DB value = "
						+ subject + " and should be = " + subjectExpected);

		// Verify TemplateUsed
		Assert.assertTrue(templateUsed.toLowerCase().equals(templateUsedExpected.toLowerCase()),
				"The TemplateUsed entry in the database is incorrect. DB value = "
						+ templateUsed + " and should be = "
						+ templateUsedExpected);

		// Verify SentDateTime is not NULL
		Assert.assertTrue(!sentDateTime.toLowerCase().equals("null"),
				"The SentDateTime entry in the database is null!");

		// Verify Successful is 1
		Assert.assertTrue(successful.equals(successfulExpected),
				"The Successful entry in the database is incorrect. DB value = "
						+ successful + " and should be = " + successfulExpected);

		// Verify FromEntityID
		Assert.assertTrue(fromEntityID.equals(fromEntityIDExpected),
				"The FromEntityID entry in the database is incorrect. DB value = "
						+ fromEntityID + " and should be = "
						+ fromEntityIDExpected);

		// Verify ToEntityID
		Assert.assertTrue(toEntityID.equals(toEntityIDExpected),
				"The ToEntityID entry in the database is incorrect. DB value = "
						+ toEntityID + " and should be = " + toEntityIDExpected);

		// Verify Attachments
		Assert.assertTrue(attachments.contains(attachmentsExpected),
				"The Attachments entry in the database is incorrect. DB value = "
						+ attachments + " and should be = " + attachmentsExpected);

		/***********************************************************************************************
		 * Verify the Originator EntityID receives Status Update notifications in the database
		 ***********************************************************************************************/
		// Query the database and return the results as an array
		sqlStatement = "SELECT TOP 1 * FROM [dbo].[MailQueue] WHERE ProductItemID = '"
				+ vmpProductItemID
				+ "' AND  ToEntityID = '"
				+ originatorEntityID
				+ "' ORDER BY EnteredStamp DESC";
		results = db
				.getMailQueueInfoBySQLToArray(driver, sqlStatement);

		// Set expected results
		mailFromExpected = "XSite Order on behalf of automation"+env+"Notifications1@dntest.net (MNDoNotReply@mercuryvmp.com)";
		mailToExpected = "automation@dntest.net";
		subjectExpected = "Order Status Update for Baseline Test-";
		templateUsedExpected = server + "XSiteStatusUpdate.html";
		if (env.equals("Beta"))
		{
			templateUsedExpected = "\\\\ss1.internal.ad.mercuryvmp.com\\Shared Storage\\MercuryEmailTemplates\\Production\\XSiteStatusUpdate.html";
		}
		successfulExpected = "1";
		fromEntityIDExpected = xSiteEntityID;
		toEntityIDExpected = originatorEntityID;

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
						+ mailFrom + " and should be = " + mailFromExpected);

		// Verify MailTo
		Assert.assertTrue(mailTo.equals(mailToExpected),
				"The MailTo entry in the database is incorrect. DB value = "
						+ mailTo + " and should be = " + mailToExpected);

		// Verify Subject
		Assert.assertTrue(subject.contains(subjectExpected),
				"The Subject entry in the database is incorrect. DB value = "
						+ subject + " and should be = " + subjectExpected);

		// Verify TemplateUsed
		Assert.assertTrue(templateUsed.toLowerCase().equals(templateUsedExpected.toLowerCase()),
				"The TemplateUsed entry in the database is incorrect. DB value = "
						+ templateUsed + " and should be = "
						+ templateUsedExpected);

		// Verify SentDateTime is not NULL
		Assert.assertTrue(!sentDateTime.toLowerCase().equals("null"),
				"The SentDateTime entry in the database is null!");

		// Verify Successful is 1
		Assert.assertTrue(successful.equals(successfulExpected),
				"The Successful entry in the database is incorrect. DB value = "
						+ successful + " and should be = " + successfulExpected);

		// Verify FromEntityID
		Assert.assertTrue(fromEntityID.equals(fromEntityIDExpected),
				"The FromEntityID entry in the database is incorrect. DB value = "
						+ fromEntityID + " and should be = "
						+ fromEntityIDExpected);

		// Verify ToEntityID
		Assert.assertTrue(toEntityID.equals(toEntityIDExpected),
				"The ToEntityID entry in the database is incorrect. DB value = "
						+ toEntityID + " and should be = " + toEntityIDExpected);

		/***********************************************************************************************
		 * Verify the VMP XSite Additional Recipient receives Status Update notification w/ completed report attached notifications in the database
		 ***********************************************************************************************/
		// Query the database and return the results as an array
		sqlStatement = "SELECT TOP 1 * FROM [dbo].[MailQueue] WHERE ProductItemID = '"
				+ vmpProductItemID + "' AND MailTo = '"+additionalRecipient1+"' ORDER BY EnteredStamp DESC";
		results = db
				.getMailQueueInfoBySQLToArray(driver, sqlStatement);

		// Set expected results
		mailFromExpected = "XSite Order on behalf of automation"+env+"Notifications1@dntest.net (MNDoNotReply@mercuryvmp.com)";
		mailToExpected = additionalRecipient1;
		subjectExpected = "Order Status Update for Baseline Test-";
		templateUsedExpected = server + "XSiteStatusUpdate_AddtlRecipients.html";
		if (env.equals("Beta"))
		{
			templateUsedExpected = "\\\\ss1.internal.ad.mercuryvmp.com\\Shared Storage\\MercuryEmailTemplates\\Production\\XSiteStatusUpdate_AddtlRecipients.html";
		}
		successfulExpected = "1";
		fromEntityIDExpected = xSiteEntityID;
		toEntityIDExpected = "NULL";
		attachmentsExpected = "Test PDF.pdf";

		// Set database values
		mailFrom = results.get(4);
		mailTo = results.get(5);
		subject = results.get(8);
		templateUsed = results.get(9);
		attachments = results.get(10);
		sentDateTime = results.get(11);
		successful = results.get(12);
		fromEntityID = results.get(13);
		toEntityID = results.get(14);

		// Verify MailFrom
		Assert.assertTrue(mailFrom.equals(mailFromExpected),
				"The MailFrom entry in the database is incorrect. DB value = "
						+ mailFrom + " and should be = " + mailFromExpected);

		// Verify MailTo
		Assert.assertTrue(mailTo.equals(mailToExpected),
				"The MailTo entry in the database is incorrect. DB value = "
						+ mailTo + " and should be = " + mailToExpected);

		// Verify Subject
		Assert.assertTrue(subject.contains(subjectExpected),
				"The Subject entry in the database is incorrect. DB value = "
						+ subject + " and should be = " + subjectExpected);

		// Verify TemplateUsed
		Assert.assertTrue(templateUsed.toLowerCase().equals(templateUsedExpected.toLowerCase()),
				"The TemplateUsed entry in the database is incorrect. DB value = "
						+ templateUsed + " and should be = "
						+ templateUsedExpected);

		// Verify SentDateTime is not NULL
		Assert.assertTrue(!sentDateTime.toLowerCase().equals("null"),
				"The SentDateTime entry in the database is null!");

		// Verify Successful is 1
		Assert.assertTrue(successful.equals(successfulExpected),
				"The Successful entry in the database is incorrect. DB value = "
						+ successful + " and should be = " + successfulExpected);

		// Verify FromEntityID
		Assert.assertTrue(fromEntityID.equals(fromEntityIDExpected),
				"The FromEntityID entry in the database is incorrect. DB value = "
						+ fromEntityID + " and should be = "
						+ fromEntityIDExpected);

		// Verify ToEntityID
		Assert.assertTrue(toEntityID.equals(toEntityIDExpected),
				"The ToEntityID entry in the database is incorrect. DB value = "
						+ toEntityID + " and should be = " + toEntityIDExpected);

		// Verify Attachments
		Assert.assertTrue(attachments.contains(attachmentsExpected),
				"The Attachments entry in the database is incorrect. DB value = "
						+ attachments + " and should be = " + attachmentsExpected);

		// Log test
		test.log(LogStatus.INFO, "Notifications", "Delivered the report as the Vendor and verified the notifications");

	} // end deliverReportAsVendor

	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Mark the order complete as the Secure MN user</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Find order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Click Accept this report radio button</li>
	 * 	<li>Check Attach completed report to XSite</li>
	 * 	<li>Check Attach completed report to additional recipients</li>
	 * 	<li>Click OK</li>
	 * 	<li>Click Save</li>
	 * 	<li>perform.waitForOverlayToBeHidden(driver);</li>
	 * 	<li>Verify MailQueue row count for this vmp productItemID</li>
	 * 	<li>Verify MailQueue row count for this secure productItemID</li>
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
	 * 	<li>* Verify the VMP XSite EntityID receives Document Attached to Order notification (Compliance Certificate) notifications in the database</li>
	 * 	<li>Query the database and return the results as an array</li>
	 * 	<li>sqlStatement = "SELECT TOP 1 * FROM [dbo].[MailQueue] WHERE ProductItemID = '"</li>
	 * 	<li>+ vmpProductItemID</li>
	 * 	<li>+ "' AND  ToEntityID = '"</li>
	 * 	<li>+ xSiteEntityID</li>
	 * 	<li>+ "' AND Subject like '%Compliance Cert%' ORDER BY EnteredStamp DESC";</li>
	 * 	<li>results = db</li>
	 * 	<li>.getMailQueueInfoBySQLToArray(driver, sqlStatement);</li>
	 * 	<li></li>
	 * 	<li>Set expected results</li>
	 * 	<li>mailFromExpected = "XSite Order on behalf of automation@dntest.net (MNDoNotReply@mercuryvmp.com)";</li>
	 * 	<li>mailToExpected = "automation"+env+"Notifications1@dntest.net";</li>
	 * 	<li>subjectExpected = "New Document Attached to Order - Type: Compliance Cert";</li>
	 * 	<li>templateUsedExpected = server + "DocumentAttached.html";</li>
	 * 	<li>successfulExpected = "1";</li>
	 * 	<li>fromEntityIDExpected = originatorEntityID;</li>
	 * 	<li>toEntityIDExpected = xSiteEntityID;</li>
	 * 	<li></li>
	 * 	<li>Set database values</li>
	 * 	<li>mailFrom = results.get(4);</li>
	 * 	<li>mailTo = results.get(5);</li>
	 * 	<li>subject = results.get(8);</li>
	 * 	<li>templateUsed = results.get(9);</li>
	 * 	<li>sentDateTime = results.get(11);</li>
	 * 	<li>successful = results.get(12);</li>
	 * 	<li>fromEntityID = results.get(13);</li>
	 * 	<li>toEntityID = results.get(14);</li>
	 * 	<li></li>
	 * 	<li>Verify MailFrom</li>
	 * 	<li>Assert.assertTrue(mailFrom.equals(mailFromExpected),</li>
	 * 	<li>"The MailFrom entry in the database is incorrect. DB value = "</li>
	 * 	<li>+ mailFrom + " and should be = " + mailFromExpected);</li>
	 * 	<li></li>
	 * 	<li>Verify MailTo</li>
	 * 	<li>Assert.assertTrue(mailTo.equals(mailToExpected),</li>
	 * 	<li>"The MailTo entry in the database is incorrect. DB value = "</li>
	 * 	<li>+ mailTo + " and should be = " + mailToExpected);</li>
	 * 	<li></li>
	 * 	<li>Verify Subject</li>
	 * 	<li>Assert.assertTrue(subject.equals(subjectExpected),</li>
	 * 	<li>"The Subject entry in the database is incorrect. DB value = "</li>
	 * 	<li>+ subject + " and should be = " + subjectExpected);</li>
	 * 	<li></li>
	 * 	<li>Verify TemplateUsed</li>
	 * 	<li>Assert.assertTrue(templateUsed.toLowerCase().equals(templateUsedExpected.toLowerCase()),</li>
	 * 	<li>"The TemplateUsed entry in the database is incorrect. DB value = "</li>
	 * 	<li>+ templateUsed + " and should be = "</li>
	 * 	<li>+ templateUsedExpected);</li>
	 * 	<li></li>
	 * 	<li>Verify SentDateTime is not NULL</li>
	 * 	<li>Assert.assertTrue(!sentDateTime.toLowerCase().equals("null"),</li>
	 * 	<li>"The SentDateTime entry in the database is null!");</li>
	 * 	<li></li>
	 * 	<li>Verify Successful is 1</li>
	 * 	<li>Assert.assertTrue(successful.equals(successfulExpected),</li>
	 * 	<li>"The Successful entry in the database is incorrect. DB value = "</li>
	 * 	<li>+ successful + " and should be = " + successfulExpected);</li>
	 * 	<li></li>
	 * 	<li>Verify FromEntityID</li>
	 * 	<li>Assert.assertTrue(fromEntityID.equals(fromEntityIDExpected),</li>
	 * 	<li>"The FromEntityID entry in the database is incorrect. DB value = "</li>
	 * 	<li>+ fromEntityID + " and should be = "</li>
	 * 	<li>+ fromEntityIDExpected);</li>
	 * 	<li></li>
	 * 	<li>Verify ToEntityID</li>
	 * 	<li>Assert.assertTrue(toEntityID.equals(toEntityIDExpected),</li>
	 * 	<li>"The ToEntityID entry in the database is incorrect. DB value = "</li>
	 * 	<li>+ toEntityID + " and should be = " + toEntityIDExpected);</li>
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
	 * 	<li>Verify Attachments</li>
	 * 	<li>Originator EntityID receives Document Attached to Order notification (Invoice)</li>
	 * 	<li>Originator EntityID receives Document Attached to Order notification (Compliance Certificate)</li>
	 * 	<li>VMP XSite Additional Recipient receives Document Attached to Order notification (Invoice)</li>
	 * 	<li>VMP XSite Additional Recipient receives Document Attached to Order notification (Compliance Certificate)</li>
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
	 * 	<li>Verify Attachments</li>
	 * 	<li>Managing Client Group Member receives Order Complete notification</li>
	 * 	<li>Log test</li>
	 * </ul>
	 * @throws Exception the exception
	 */
	@Test (groups={}, dependsOnMethods="deliverReportAsVendor")
	public void completeOrderOnSecure() throws Exception {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Mark the order complete as the Secure MN user
		// Log in to Secure
		secure.login(driver, userSecure, password);

		// Find order
		secure.findOrder(driver, orderNumber, "Tracking number");

		// Open the order
		secure.openOrder(driver, orderNumber);

		// Click Accept this report radio button
		perform.click(driver,SOrderDetails.acceptThisReportAsIs_radioBtn(driver));

		// Check Attach completed report to XSite
		perform.uncheckCheckbox(driver, SOrderDetails.attachCompletedReportToXSite_chkbx(driver));

		// Check Attach completed report to additional recipients
		perform.uncheckCheckbox(driver, SOrderDetails.attachCompletedReportToAdditionalRecipients_chkbx(driver));		

		// Click OK
		perform.click(driver,SOrderDetails.okProcessReceivedReport_btn(driver));

		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);

		// Wait for Save
		perform.waitForElementToBeClickable(driver, SVerifyCertificateInformation.save_btn(), "cssSelector");

		// Click Save
		perform.click(driver,SVerifyCertificateInformation.save_btn(driver));

		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);

		// Wait for Find textbox
		perform.waitForElementToBeClickable(driver, SOrders.find_txtbx(), "id");

		// Verify MailQueue row count for this vmp productItemID
		perform.verifyTheNumberOfRowsInTheMailQueueDBResultsForProductItemID(driver, 21, vmpProductItemID);

		// Verify MailQueue row count for this secure productItemID
		perform.verifyTheNumberOfRowsInTheMailQueueDBResultsForProductItemID(driver, 13, secureProductItemID);

		/***********************************************************************************************
		 * Verify the Vendor EntityID receives Review Accepted notifications in the database
		 ***********************************************************************************************/
		// Query the database and return the results as an array
		String sqlStatement = "SELECT TOP 1 * FROM [dbo].[MailQueue] WHERE ProductItemID = '"
				+ secureProductItemID
				+ "' AND  ToEntityID = '"
				+ vendorEntityID
				+ "' ORDER BY EnteredStamp DESC";
		ArrayList<String> results = db
				.getMailQueueInfoBySQLToArray(driver, sqlStatement);

		// Set expected results
		String mailFromExpected = "Mercury Network (MNDoNotReply@mercuryvmp.com)";
		String mailToExpected = "automation"+env+"NotificationsAppraiser2@dntest.net";
		String subjectExpected = "Review Accepted for 501-D NE 122nd St, Oklahoma City, OK";
		String templateUsedExpected = server + "MN_ReviewAccepted.html";
		String successfulExpected = "1";
		String fromEntityIDExpected = secureEntityID;
		String toEntityIDExpected = vendorEntityID;

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
						+ mailFrom + " and should be = " + mailFromExpected);

		// Verify MailTo
		Assert.assertTrue(mailTo.equals(mailToExpected),
				"The MailTo entry in the database is incorrect. DB value = "
						+ mailTo + " and should be = " + mailToExpected);

		// Verify Subject
		Assert.assertTrue(subject.equals(subjectExpected),
				"The Subject entry in the database is incorrect. DB value = "
						+ subject + " and should be = " + subjectExpected);

		// Verify TemplateUsed
		Assert.assertTrue(templateUsed.toLowerCase().equals(templateUsedExpected.toLowerCase()),
				"The TemplateUsed entry in the database is incorrect. DB value = "
						+ templateUsed + " and should be = "
						+ templateUsedExpected);

		// Verify SentDateTime is not NULL
		Assert.assertTrue(!sentDateTime.toLowerCase().equals("null"),
				"The SentDateTime entry in the database is null!");

		// Verify Successful is 1
		Assert.assertTrue(successful.equals(successfulExpected),
				"The Successful entry in the database is incorrect. DB value = "
						+ successful + " and should be = " + successfulExpected);

		// Verify FromEntityID
		Assert.assertTrue(fromEntityID.equals(fromEntityIDExpected),
				"The FromEntityID entry in the database is incorrect. DB value = "
						+ fromEntityID + " and should be = "
						+ fromEntityIDExpected);

		// Verify ToEntityID
		Assert.assertTrue(toEntityID.equals(toEntityIDExpected),
				"The ToEntityID entry in the database is incorrect. DB value = "
						+ toEntityID + " and should be = " + toEntityIDExpected);

		/***********************************************************************************************
		 * Verify the VMP XSite EntityID receives Document Attached to Order notification (Invoice) notifications in the database
		 ***********************************************************************************************/
		// Query the database and return the results as an array
		sqlStatement = "SELECT TOP 1 * FROM [dbo].[MailQueue] WHERE ProductItemID = '"
				+ vmpProductItemID
				+ "' AND  ToEntityID = '"
				+ xSiteEntityID
				+ "' AND Subject like 'New Document Attached to Order - Type: Other' ORDER BY EnteredStamp DESC";
		results = db
				.getMailQueueInfoBySQLToArray(driver, sqlStatement);

		// Set expected results
		mailFromExpected = "XSite Order on behalf of automation@dntest.net (MNDoNotReply@mercuryvmp.com)";
		mailToExpected = "automation"+env+"Notifications1@dntest.net";
		subjectExpected = "New Document Attached to Order - Type: Other";
		templateUsedExpected = server + "DocumentAttached.html";
		successfulExpected = "1";
		fromEntityIDExpected = originatorEntityID;
		toEntityIDExpected = xSiteEntityID;

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
						+ mailFrom + " and should be = " + mailFromExpected);

		// Verify MailTo
		Assert.assertTrue(mailTo.equals(mailToExpected),
				"The MailTo entry in the database is incorrect. DB value = "
						+ mailTo + " and should be = " + mailToExpected);

		// Verify Subject
		Assert.assertTrue(subject.equals(subjectExpected),
				"The Subject entry in the database is incorrect. DB value = "
						+ subject + " and should be = " + subjectExpected);

		// Verify TemplateUsed
		Assert.assertTrue(templateUsed.toLowerCase().equals(templateUsedExpected.toLowerCase()),
				"The TemplateUsed entry in the database is incorrect. DB value = "
						+ templateUsed + " and should be = "
						+ templateUsedExpected);

		// Verify SentDateTime is not NULL
		Assert.assertTrue(!sentDateTime.toLowerCase().equals("null"),
				"The SentDateTime entry in the database is null!");

		// Verify Successful is 1
		Assert.assertTrue(successful.equals(successfulExpected),
				"The Successful entry in the database is incorrect. DB value = "
						+ successful + " and should be = " + successfulExpected);

		// Verify FromEntityID
		Assert.assertTrue(fromEntityID.equals(fromEntityIDExpected),
				"The FromEntityID entry in the database is incorrect. DB value = "
						+ fromEntityID + " and should be = "
						+ fromEntityIDExpected);

		// Verify ToEntityID
		Assert.assertTrue(toEntityID.equals(toEntityIDExpected),
				"The ToEntityID entry in the database is incorrect. DB value = "
						+ toEntityID + " and should be = " + toEntityIDExpected);

		/***********************************************************************************************
		 * Verify the Originator EntityID receives Order Completed notifications in the database
		 ***********************************************************************************************/
		// Query the database and return the results as an array
		sqlStatement = "SELECT TOP 1 * FROM [dbo].[MailQueue] WHERE ProductItemID = '"
				+ vmpProductItemID
				+ "' AND  ToEntityID = '"
				+ originatorEntityID
				+ "' ORDER BY EnteredStamp DESC";
		results = db
				.getMailQueueInfoBySQLToArray(driver, sqlStatement);

		// Set expected results
		mailFromExpected = "XSite Order on behalf of automation"+env+"Notifications1@dntest.net (MNDoNotReply@mercuryvmp.com)";
		mailToExpected = "automation@dntest.net";
		subjectExpected = "Order Completed - File #:";
		templateUsedExpected = server + "XSiteAppraisalComplete.html";
		successfulExpected = "1";
		fromEntityIDExpected = xSiteEntityID;
		toEntityIDExpected = originatorEntityID;
		String attachmentsExpected = "NULL";

		// Set database values
		mailFrom = results.get(4);
		mailTo = results.get(5);
		subject = results.get(8);
		templateUsed = results.get(9);
		String attachments = results.get(10);
		sentDateTime = results.get(11);
		successful = results.get(12);
		fromEntityID = results.get(13);
		toEntityID = results.get(14);

		// Verify MailFrom
		Assert.assertTrue(mailFrom.equals(mailFromExpected),
				"The MailFrom entry in the database is incorrect. DB value = "
						+ mailFrom + " and should be = " + mailFromExpected);

		// Verify MailTo
		Assert.assertTrue(mailTo.equals(mailToExpected),
				"The MailTo entry in the database is incorrect. DB value = "
						+ mailTo + " and should be = " + mailToExpected);

		// Verify Subject
		Assert.assertTrue(subject.contains(subjectExpected),
				"The Subject entry in the database is incorrect. DB value = "
						+ subject + " and should be = " + subjectExpected);

		// Verify TemplateUsed
		Assert.assertTrue(templateUsed.toLowerCase().equals(templateUsedExpected.toLowerCase()),
				"The TemplateUsed entry in the database is incorrect. DB value = "
						+ templateUsed + " and should be = "
						+ templateUsedExpected);

		// Verify SentDateTime is not NULL
		Assert.assertTrue(!sentDateTime.toLowerCase().equals("null"),
				"The SentDateTime entry in the database is null!");

		// Verify Successful is 1
		Assert.assertTrue(successful.equals(successfulExpected),
				"The Successful entry in the database is incorrect. DB value = "
						+ successful + " and should be = " + successfulExpected);

		// Verify FromEntityID
		Assert.assertTrue(fromEntityID.equals(fromEntityIDExpected),
				"The FromEntityID entry in the database is incorrect. DB value = "
						+ fromEntityID + " and should be = "
						+ fromEntityIDExpected);

		// Verify ToEntityID
		Assert.assertTrue(toEntityID.equals(toEntityIDExpected),
				"The ToEntityID entry in the database is incorrect. DB value = "
						+ toEntityID + " and should be = " + toEntityIDExpected);

		// Verify Attachments
		Assert.assertTrue(attachments.contains(attachmentsExpected),
				"The Attachments entry in the database is incorrect. DB value = "
						+ attachments + " and should be = " + attachmentsExpected);

		// Originator EntityID receives Document Attached to Order notification (Invoice)
		test.log(LogStatus.WARNING, "Notifications", "There is no notification in the database for the Originator EntityID receives Document Attached to Order notification (Invoice). The matrix shows there should be");

		// Originator EntityID receives Document Attached to Order notification (Compliance Certificate)
		test.log(LogStatus.WARNING, "Notifications", "There is no notification in the database for the Originator EntityID receives Document Attached to Order notification (Compliance Certificate). The matrix shows there should be");

		// VMP XSite Additional Recipient receives Document Attached to Order notification (Invoice)
		test.log(LogStatus.WARNING, "Notifications", "There is no notification in the database for the VMP XSite Additional Recipient receives Document Attached to Order notification (Invoice). The matrix shows there should be");		

		// VMP XSite Additional Recipient receives Document Attached to Order notification (Compliance Certificate)
		test.log(LogStatus.WARNING, "Notifications", "There is no notification in the database for the VMP XSite Additional Recipient receives Document Attached to Order notification (Compliance Certificate). The matrix shows there should be");		

		/***********************************************************************************************
		 * Verify the VMP XSite Additional Recipient receives Order Completed notification w/ completed report attached notifications in the database
		 ***********************************************************************************************/
		// Query the database and return the results as an array
		sqlStatement = "SELECT TOP 1 * FROM [dbo].[MailQueue] WHERE ProductItemID = '"
				+ vmpProductItemID
				+ "' AND  MailTo = '"
				+ additionalRecipient1
				+ "' AND Subject like '%Completed%'ORDER BY EnteredStamp DESC";
		results = db
				.getMailQueueInfoBySQLToArray(driver, sqlStatement);

		// Set expected results
		mailFromExpected = "XSite Order on behalf of automation"+env+"Notifications1@dntest.net (MNDoNotReply@mercuryvmp.com)";
		mailToExpected = additionalRecipient1;
		subjectExpected = "Order Completed - File #:";
		templateUsedExpected = server + "XSiteAppraisalComplete_AddtlRecipients.html";
		successfulExpected = "1";
		fromEntityIDExpected = xSiteEntityID;
		toEntityIDExpected = "NULL";
		attachmentsExpected = "Test PDF.pdf";

		// Set database values
		mailFrom = results.get(4);
		mailTo = results.get(5);
		subject = results.get(8);
		templateUsed = results.get(9);
		attachments = results.get(10);
		sentDateTime = results.get(11);
		successful = results.get(12);
		fromEntityID = results.get(13);
		toEntityID = results.get(14);

		// Verify MailFrom
		Assert.assertTrue(mailFrom.equals(mailFromExpected),
				"The MailFrom entry in the database is incorrect. DB value = "
						+ mailFrom + " and should be = " + mailFromExpected);

		// Verify MailTo
		Assert.assertTrue(mailTo.equals(mailToExpected),
				"The MailTo entry in the database is incorrect. DB value = "
						+ mailTo + " and should be = " + mailToExpected);

		// Verify Subject
		Assert.assertTrue(subject.contains(subjectExpected),
				"The Subject entry in the database is incorrect. DB value = "
						+ subject + " and should be = " + subjectExpected);

		// Verify TemplateUsed
		Assert.assertTrue(templateUsed.toLowerCase().equals(templateUsedExpected.toLowerCase()),
				"The TemplateUsed entry in the database is incorrect. DB value = "
						+ templateUsed + " and should be = "
						+ templateUsedExpected);

		// Verify SentDateTime is not NULL
		Assert.assertTrue(!sentDateTime.toLowerCase().equals("null"),
				"The SentDateTime entry in the database is null!");

		// Verify Successful is 1
		Assert.assertTrue(successful.equals(successfulExpected),
				"The Successful entry in the database is incorrect. DB value = "
						+ successful + " and should be = " + successfulExpected);

		// Verify FromEntityID
		Assert.assertTrue(fromEntityID.equals(fromEntityIDExpected),
				"The FromEntityID entry in the database is incorrect. DB value = "
						+ fromEntityID + " and should be = "
						+ fromEntityIDExpected);

		// Verify ToEntityID
		Assert.assertTrue(toEntityID.equals(toEntityIDExpected),
				"The ToEntityID entry in the database is incorrect. DB value = "
						+ toEntityID + " and should be = " + toEntityIDExpected);

		// Verify Attachments
		Assert.assertTrue(attachments.contains(attachmentsExpected),
				"The Attachments entry in the database is incorrect. DB value = "
						+ attachments + " and should be = " + attachmentsExpected);

		// Managing Client Group Member receives Order Complete notification
		test.log(LogStatus.WARNING, "Notifications", "There is no notification in the database for the Managing Client Group Member receives Order Complete. The matrix shows there should be");		

		// Log test
		test.log(LogStatus.INFO, "Notifications", "Marked the order complete from Secure and verified the notifications");

	} // end completeOrderOnSecure

	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Send the report to the Borrower as the Secure MN User</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Find order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Click Set Status</li>
	 * 	<li>Click Send via SureReceipts</li>
	 * 	<li>Switch to iFrame</li>
	 * 	<li>Click Send</li>
	 * 	<li>Verify MailQueue row count for this vmp productItemID</li>
	 * 	<li>Verify MailQueue row count for this secure productItemID (updated count to 17 for the coborrower)</li>
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
	 * 	<li>VMP XSite Additional Recipient receives Report Delivered to Borrower notification</li>
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
	 * 	<li>Managing Client Group Member receives Report Delivered to Borrower notification</li>
	 * 	<li>Log test</li>
	 * </ul>
	 * @throws Exception the exception
	 */
	@Test (groups={}, dependsOnMethods="completeOrderOnSecure")
	public void sendReportToBorrowerAsSecureUser() throws Exception {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Send the report to the Borrower as the Secure MN User
		// Log in to Secure
		secure.login(driver, userSecure, password);

		// Find order
		secure.findOrder(driver, orderNumber, "Tracking number");

		// Open the order
		secure.openOrder(driver, orderNumber);

		// Click Set Status
		perform.click(driver,SOrderDetails.setStatus_btn(driver));

		// Click Send via SureReceipts
		perform.click(driver,SOrderDetails.sendViaSureReceipts_btn(driver));

		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);

		// Switch to iFrame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "/SureReceipts/SendFiles.aspx", By.id(SOrderDetails.sendInSendViaSureReceipts_btn()));

		// Wait for Send button
		perform.waitForElementToBeClickable(driver, SOrderDetails.sendInSendViaSureReceipts_btn(), "id");

		Thread.sleep(2500);

		//Click Send
		perform.click(driver,SOrderDetails.sendInSendViaSureReceipts_btn(driver));

		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);

		// Switch out of iFrame
		driver.switchTo().defaultContent();

		// Verify MailQueue row count for this vmp productItemID
		perform.verifyTheNumberOfRowsInTheMailQueueDBResultsForProductItemID(driver, 23, vmpProductItemID);

		// Verify MailQueue row count for this secure productItemID (updated count to 17 for the coborrower)
		perform.verifyTheNumberOfRowsInTheMailQueueDBResultsForProductItemID(driver, 17, secureProductItemID);

		/***********************************************************************************************
		 * Verify the Secure EntityID receives Report Delivered notifications in the database
		 ***********************************************************************************************/
		// Query the database and return the results as an array
		String sqlStatement = "SELECT TOP 1 * FROM [dbo].[MailQueue] WHERE ProductItemID = '"
				+ secureProductItemID
				+ "' AND  ToEntityID = '"
				+ secureEntityID
				+ "' AND MailTo like '%Notifications1%' ORDER BY EnteredStamp DESC";
		ArrayList<String> results = db
				.getMailQueueInfoBySQLToArray(driver, sqlStatement);

		// Set expected results
		String mailFromExpected = "ndr.VSG@corelogic.com";
		String mailToExpected = "automation"+env+"Notifications1@dntest.net";
		String subjectExpected = "Report delivered for 501-D NE 122nd St";
		String templateUsedExpected = server + "MN_AppraisalSentClient.html";
		if (env.equals("Beta"))
		{
			templateUsedExpected = "\\\\ss1.internal.ad.mercuryvmp.com\\Shared Storage\\MercuryEmailTemplates\\Production\\MN_AppraisalSentClient.html";
		}
		String successfulExpected = "1";
		String fromEntityIDExpected = "NULL";
		String toEntityIDExpected = secureEntityID;

		// Set database values
		String mailFrom = results.get(4);
		String mailTo = results.get(5);
		String subject = results.get(8);
		String templateUsed = results.get(9);
		String sentDateTime = results.get(11);
		String successful = results.get(12);
		String fromEntityID = results.get(13);
		String toEntityID = results.get(14);


		if (env.equals("QA"))
		{
			mailFromExpected = "ndr.VSG@corelogic.com";

		} // end if QA

		if (env.equals("Live"))
		{
			mailFromExpected = "MNDoNotReply@mercuryvmp.com"; 
		}// end if Live


		// Verify MailFrom
		Assert.assertTrue(mailFrom.equals(mailFromExpected),
				"The MailFrom entry in the database is incorrect. DB value = "
						+ mailFrom + " and should be = " + mailFromExpected);

		// Verify MailTo
		Assert.assertTrue(mailTo.equals(mailToExpected),
				"The MailTo entry in the database is incorrect. DB value = "
						+ mailTo + " and should be = " + mailToExpected);

		// Verify Subject
		Assert.assertTrue(subject.equals(subjectExpected),
				"The Subject entry in the database is incorrect. DB value = "
						+ subject + " and should be = " + subjectExpected);

		// Verify TemplateUsed
		Assert.assertTrue(templateUsed.toLowerCase().equals(templateUsedExpected.toLowerCase()),
				"The TemplateUsed entry in the database is incorrect. DB value = "
						+ templateUsed + " and should be = "
						+ templateUsedExpected);

		// Verify SentDateTime is not NULL
		Assert.assertTrue(!sentDateTime.toLowerCase().equals("null"),
				"The SentDateTime entry in the database is null!");

		// Verify Successful is 1
		Assert.assertTrue(successful.equals(successfulExpected),
				"The Successful entry in the database is incorrect. DB value = "
						+ successful + " and should be = " + successfulExpected);

		// Verify FromEntityID
		Assert.assertTrue(fromEntityID.equals(fromEntityIDExpected),
				"The FromEntityID entry in the database is incorrect. DB value = "
						+ fromEntityID + " and should be = "
						+ fromEntityIDExpected);

		// Verify ToEntityID
		Assert.assertTrue(toEntityID.equals(toEntityIDExpected),
				"The ToEntityID entry in the database is incorrect. DB value = "
						+ toEntityID + " and should be = " + toEntityIDExpected);

		/***********************************************************************************************
		 * Verify the Mercury Network Additional Recipient receives Report Delivered notifications in the database
		 ***********************************************************************************************/
		// Query the database and return the results as an array
		sqlStatement = "SELECT TOP 1 * FROM [dbo].[MailQueue] WHERE ProductItemID = '"
				+ secureProductItemID
				+ "' AND  ToEntityID = '"
				+ secureEntityID
				+ "' AND MailTo = '"+additionalRecipient2+"' ORDER BY EnteredStamp DESC";
		results = db
				.getMailQueueInfoBySQLToArray(driver, sqlStatement);

		// Set expected results
		mailFromExpected = "ndr.VSG@corelogic.com";
		mailToExpected = additionalRecipient2;
		subjectExpected = "Report delivered for 501-D NE 122nd St";
		templateUsedExpected = server + "MN_AppraisalSentClient_AddtlRecipients.html";
		if (env.equals("Beta"))
		{
			templateUsedExpected = "\\\\ss1.internal.ad.mercuryvmp.com\\Shared Storage\\MercuryEmailTemplates\\Production\\MN_AppraisalSentClient_AddtlRecipients.html";
		}
		successfulExpected = "1";
		fromEntityIDExpected = "NULL";
		toEntityIDExpected = secureEntityID;

		// Set database values
		mailFrom = results.get(4);
		mailTo = results.get(5);
		subject = results.get(8);
		templateUsed = results.get(9);
		sentDateTime = results.get(11);
		successful = results.get(12);
		fromEntityID = results.get(13);
		toEntityID = results.get(14);

		if (env.equals("QA"))
		{
			mailFromExpected = "ndr.VSG@corelogic.com";

		} // end if QA

		if (env.equals("Live"))
		{
			mailFromExpected = "MNDoNotReply@mercuryvmp.com"; 
		}// end if Live

		// Verify MailFrom
		Assert.assertTrue(mailFrom.equals(mailFromExpected),
				"The MailFrom entry in the database is incorrect. DB value = "
						+ mailFrom + " and should be = " + mailFromExpected);

		// Verify MailTo
		Assert.assertTrue(mailTo.equals(mailToExpected),
				"The MailTo entry in the database is incorrect. DB value = "
						+ mailTo + " and should be = " + mailToExpected);

		// Verify Subject
		Assert.assertTrue(subject.equals(subjectExpected),
				"The Subject entry in the database is incorrect. DB value = "
						+ subject + " and should be = " + subjectExpected);

		// Verify TemplateUsed
		Assert.assertTrue(templateUsed.toLowerCase().equals(templateUsedExpected.toLowerCase()),
				"The TemplateUsed entry in the database is incorrect. DB value = "
						+ templateUsed + " and should be = "
						+ templateUsedExpected);

		// Verify SentDateTime is not NULL
		Assert.assertTrue(!sentDateTime.toLowerCase().equals("null"),
				"The SentDateTime entry in the database is null!");

		// Verify Successful is 1
		Assert.assertTrue(successful.equals(successfulExpected),
				"The Successful entry in the database is incorrect. DB value = "
						+ successful + " and should be = " + successfulExpected);

		// Verify FromEntityID
		Assert.assertTrue(fromEntityID.equals(fromEntityIDExpected),
				"The FromEntityID entry in the database is incorrect. DB value = "
						+ fromEntityID + " and should be = "
						+ fromEntityIDExpected);

		// Verify ToEntityID
		Assert.assertTrue(toEntityID.equals(toEntityIDExpected),
				"The ToEntityID entry in the database is incorrect. DB value = "
						+ toEntityID + " and should be = " + toEntityIDExpected);

		/***********************************************************************************************
		 * Verify the Borrower receives Report for <xx> notifications in the database
		 ***********************************************************************************************/
		// Query the database and return the results as an array
		sqlStatement = "SELECT TOP 1 * FROM [dbo].[MailQueue] WHERE ProductItemID = '"
				+ secureProductItemID
				+ "' AND  MailTo = 'borrower@dntest.net'"
				+ " ORDER BY EnteredStamp DESC";
		results = db
				.getMailQueueInfoBySQLToArray(driver, sqlStatement);

		// Set expected results
		mailFromExpected = "MNDoNotReply@mercuryvmp.com";
		mailToExpected = "borrower@dntest.net";
		subjectExpected = "Documents available from BOKF, National Association";
		templateUsedExpected = server + "MN_SureReceipts-notification_NoNotes.html";
		successfulExpected = "1";
		fromEntityIDExpected = secureEntityID;
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
						+ mailFrom + " and should be = " + mailFromExpected);

		// Verify MailTo
		Assert.assertTrue(mailTo.equals(mailToExpected),
				"The MailTo entry in the database is incorrect. DB value = "
						+ mailTo + " and should be = " + mailToExpected);

		// Verify Subject
		Assert.assertTrue(subject.equals(subjectExpected),
				"The Subject entry in the database is incorrect. DB value = "
						+ subject + " and should be = " + subjectExpected);

		// Verify TemplateUsed
		Assert.assertTrue(templateUsed.toLowerCase().equals(templateUsedExpected.toLowerCase()),
				"The TemplateUsed entry in the database is incorrect. DB value = "
						+ templateUsed + " and should be = "
						+ templateUsedExpected);

		// Verify SentDateTime is not NULL
		Assert.assertTrue(!sentDateTime.toLowerCase().equals("null"),
				"The SentDateTime entry in the database is null!");

		// Verify Successful is 1
		Assert.assertTrue(successful.equals(successfulExpected),
				"The Successful entry in the database is incorrect. DB value = "
						+ successful + " and should be = " + successfulExpected);

		// Verify FromEntityID
		Assert.assertTrue(fromEntityID.equals(fromEntityIDExpected),
				"The FromEntityID entry in the database is incorrect. DB value = "
						+ fromEntityID + " and should be = "
						+ fromEntityIDExpected);

		// Verify ToEntityID
		Assert.assertTrue(toEntityID.equals(toEntityIDExpected),
				"The ToEntityID entry in the database is incorrect. DB value = "
						+ toEntityID + " and should be = " + toEntityIDExpected);

		/***********************************************************************************************
		 * Verify the Originator EntityID receives Report Delivered to Borrower notifications in the database
		 ***********************************************************************************************/
		// Query the database and return the results as an array
		sqlStatement = "SELECT TOP 1 * FROM [dbo].[MailQueue] WHERE ProductItemID = '"
				+ vmpProductItemID
				+ "' AND  ToEntityID = '"
				+ originatorEntityID
				+ "' ORDER BY EnteredStamp DESC";
		results = db
				.getMailQueueInfoBySQLToArray(driver, sqlStatement);

		// Set expected results
		mailFromExpected = "XSite Order on behalf of automation"+env+"Notifications1@dntest.net (MNDoNotReply@mercuryvmp.com)";
		mailToExpected = "automation@dntest.net";
		subjectExpected = "Report Delivered to Borrower for Baseline Test-";
		templateUsedExpected = server + "XSiteAppraisalSentToBorrower.html";
		successfulExpected = "1";
		fromEntityIDExpected = xSiteEntityID;
		toEntityIDExpected = originatorEntityID;

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
						+ mailFrom + " and should be = " + mailFromExpected);

		// Verify MailTo
		Assert.assertTrue(mailTo.equals(mailToExpected),
				"The MailTo entry in the database is incorrect. DB value = "
						+ mailTo + " and should be = " + mailToExpected);

		// Verify Subject
		Assert.assertTrue(subject.contains(subjectExpected),
				"The Subject entry in the database is incorrect. DB value = "
						+ subject + " and should be = " + subjectExpected);

		// Verify TemplateUsed
		Assert.assertTrue(templateUsed.toLowerCase().equals(templateUsedExpected.toLowerCase()),
				"The TemplateUsed entry in the database is incorrect. DB value = "
						+ templateUsed + " and should be = "
						+ templateUsedExpected);

		// Verify SentDateTime is not NULL
		Assert.assertTrue(!sentDateTime.toLowerCase().equals("null"),
				"The SentDateTime entry in the database is null!");

		// Verify Successful is 1
		Assert.assertTrue(successful.equals(successfulExpected),
				"The Successful entry in the database is incorrect. DB value = "
						+ successful + " and should be = " + successfulExpected);

		// Verify FromEntityID
		Assert.assertTrue(fromEntityID.equals(fromEntityIDExpected),
				"The FromEntityID entry in the database is incorrect. DB value = "
						+ fromEntityID + " and should be = "
						+ fromEntityIDExpected);

		// Verify ToEntityID
		Assert.assertTrue(toEntityID.equals(toEntityIDExpected),
				"The ToEntityID entry in the database is incorrect. DB value = "
						+ toEntityID + " and should be = " + toEntityIDExpected);

		// VMP XSite Additional Recipient receives Report Delivered to Borrower notification
		/***********************************************************************************************
		 * Verify the notifications in the database
		 ***********************************************************************************************/
		// Query the database and return the results as an array
		sqlStatement = "SELECT TOP 1 * FROM [dbo].[MailQueue] WHERE ProductItemID = '"
				+ vmpProductItemID
				+ "' AND  MailTo = '"
				+ additionalRecipient1
				+ "' ORDER BY EnteredStamp DESC";
		results = db
				.getMailQueueInfoBySQLToArray(driver, sqlStatement);

		// Set expected results
		mailFromExpected = "XSite Order on behalf of automation"+env+"Notifications1@dntest.net (MNDoNotReply@mercuryvmp.com)";
		mailToExpected = additionalRecipient1;
		subjectExpected = "Report Delivered to Borrower for Baseline Test-";
		templateUsedExpected = server + "XSiteAppraisalSentToBorrower_AddtlRecipients.html";
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
						+ mailFrom + " and should be = " + mailFromExpected);

		// Verify MailTo
		Assert.assertTrue(mailTo.equals(mailToExpected),
				"The MailTo entry in the database is incorrect. DB value = "
						+ mailTo + " and should be = " + mailToExpected);

		// Verify Subject
		Assert.assertTrue(subject.contains(subjectExpected),
				"The Subject entry in the database is incorrect. DB value = "
						+ subject + " and should be = " + subjectExpected);

		// Verify TemplateUsed
		Assert.assertTrue(templateUsed.toLowerCase().equals(templateUsedExpected.toLowerCase()),
				"The TemplateUsed entry in the database is incorrect. DB value = "
						+ templateUsed + " and should be = "
						+ templateUsedExpected);

		// Verify SentDateTime is not NULL
		Assert.assertTrue(!sentDateTime.toLowerCase().equals("null"),
				"The SentDateTime entry in the database is null!");

		// Verify Successful is 1
		Assert.assertTrue(successful.equals(successfulExpected),
				"The Successful entry in the database is incorrect. DB value = "
						+ successful + " and should be = " + successfulExpected);

		// Verify FromEntityID
		Assert.assertTrue(fromEntityID.equals(fromEntityIDExpected),
				"The FromEntityID entry in the database is incorrect. DB value = "
						+ fromEntityID + " and should be = "
						+ fromEntityIDExpected);

		// Verify ToEntityID
		Assert.assertTrue(toEntityID.equals(toEntityIDExpected),
				"The ToEntityID entry in the database is incorrect. DB value = "
						+ toEntityID + " and should be = " + toEntityIDExpected);

		// Managing Client Group Member receives Report Delivered to Borrower notification
		test.log(LogStatus.WARNING, "Notifications", "There is no notification in the database for the Managing Client Group Member receives Report Delivered to Borrower. The matrix shows there should be");

		// Log test
		test.log(LogStatus.INFO, "Notifications", "Sent the report to the Borrower as the Secure user and verified the notifications");

	} // end sendReportToBorrowerAsSecureUser

	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>From Secure Mercury Network &gt; Setup the Client Group with an automatic AQI report recipient (Automated tab)</li>
	 * 	<li>On the completed report Start AQM and order the AQI and QC Module</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Find order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Click Start AQM</li>
	 * 	<li>Click No Thanks</li>
	 * 	<li>perform.waitForIFrames(driver);</li>
	 * 	<li>driver.switchTo().frame(0);</li>
	 * 	<li>Check AQI</li>
	 * 	<li>Check AQM QC</li>
	 * 	<li>Click OK</li>
	 * 	<li>Click OK</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify Appraisal submitted is in the history</li>
	 * 	<li>Verify MailQueue row count for this vmp productItemID</li>
	 * 	<li>Verify MailQueue row count for this secure productItemID</li>
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
	 * </ul>
	 * @throws Exception the exception
	 */
	@Test (groups={}, dependsOnMethods="sendReportToBorrowerAsSecureUser")
	public void startAQM() throws Exception {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// From Secure Mercury Network > Setup the Client Group with an automatic AQI report recipient (Automated tab)
		// On the completed report Start AQM and order the AQI and QC Module
		// Log in to Secure
		secure.login(driver, userSecure, password);

		// Find order
		secure.findOrder(driver, orderNumber, "Tracking number");

		// Open the order
		secure.openOrder(driver, orderNumber);

		// Click Start AQM
		perform.click(driver,SOrderDetails.startAQM_btn(driver));

		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);

		// Click No Thanks
		try {
			perform.click(driver,driver.findElement(By.id("Dialogs_Dialogs_ctl51")));
			Thread.sleep(2000);
		} catch (Exception e) {
		}

		// Switch into iFrame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "/Common/AQMForms/StartAQM.aspx", By.id(SOrderDetails.okStartAQM_btn()));

		// Wait for OK button
		try {
			perform.waitForElementToBeClickable(driver, SOrderDetails.okStartAQM_btn(driver));
		} catch (Exception e) {
			driver.switchTo().defaultContent();
			// Switch into iFrame
			perform.waitForiFrameSrcAndSwitchToIt(driver, "/Common/AQMForms/StartAQM.aspx", By.id(SOrderDetails.okStartAQM_btn()));
			perform.waitForElementToBeClickable(driver, SOrderDetails.okStartAQM_btn(driver));
		} // end try/catch

		// Check AQI
		if (!SOrderDetails.aqi_chkbx(driver).getAttribute("src").contains("Checked-Blue"))
		{
			perform.click(driver,SOrderDetails.aqi_chkbx(driver));
		} // end if

		// Check AQM QC
		if (!SOrderDetails.aqmQC_chcbx(driver).getAttribute("src").contains("Checked-Blue"))
		{
			perform.click(driver,SOrderDetails.aqmQC_chcbx(driver));
		} // end if

		// Click OK
		perform.click(driver,SOrderDetails.okStartAQM_btn(driver));

		// Wait for Payment acknowledgement OK button
		perform.waitForElementToBeClickable(driver, SOrderDetails.okPaymentAcknowledgement_btn(), "id");

		// Click OK
		perform.click(driver,SOrderDetails.okPaymentAcknowledgement_btn(driver));

		Thread.sleep(2000);

		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);

		// Switch out of iFrames
		driver.switchTo().defaultContent();

		// Wait for AQM to appear in the audit trail
		perform.waitForText(driver, SOrderDetails.history_txt(driver), "Appraisal submitted to AQM by Client");

		// Get history text
		String history = SOrderDetails.history_txt(driver).getText();

		// Verify Appraisal submitted is in the history
		Assert.assertTrue(history.contains("Appraisal submitted to AQM by Client"), "The history does not show the appraisal being submitted to AQM. History = " + history);

		// Wait for View FNM SSR to display in the history
		secure.waitForHistoryTextToUpdate(driver, "AQM preliminary results returned");

		// Verify MailQueue row count for this vmp productItemID
		perform.verifyTheNumberOfRowsInTheMailQueueDBResultsForProductItemID(driver, 23, vmpProductItemID);

		// Verify MailQueue row count for this secure productItemID
		perform.verifyTheNumberOfRowsInTheMailQueueDBResultsForProductItemID(driver, 18, secureProductItemID);

		/***********************************************************************************************
		 * Verify the Secure EntityID receives AQM Preliminary Results Returned notifications in the database
		 ***********************************************************************************************/
		// Query the database and return the results as an array
		String sqlStatement = "SELECT TOP 1 * FROM [dbo].[MailQueue] WHERE ProductItemID = '"
				+ secureProductItemID
				+ "' AND  ToEntityID = '"
				+ secureEntityID
				+ "' ORDER BY EnteredStamp DESC";
		ArrayList<String> results = db
				.getMailQueueInfoBySQLToArray(driver, sqlStatement);

		// Set expected results
		String mailFromExpected = "Mercury Network (ndr.VSG@corelogic.com)";
		String mailToExpected = "automation"+env+"Notifications1@dntest.net";
		String subjectExpected = "AQM Preliminary Results Returned for 501-D NE 122nd St, Oklahoma City, OK";
		String templateUsedExpected = server + "MN_AQMPreliminary.html";
		if (env.equals("Beta"))
		{
			templateUsedExpected = "\\\\ss1.internal.ad.mercuryvmp.com\\Shared Storage\\MercuryEmailTemplates\\Production\\MN_AQMPreliminary.html";
		}
		String successfulExpected = "1";
		String fromEntityIDExpected = vendorEntityID;
		String toEntityIDExpected = secureEntityID;

		// Set database values
		String mailFrom = results.get(4);
		String mailTo = results.get(5);
		String subject = results.get(8);
		String templateUsed = results.get(9);
		String sentDateTime = results.get(11);
		String successful = results.get(12);
		String fromEntityID = results.get(13);
		String toEntityID = results.get(14);

		if (env.equals("QA"))
		{
			mailFromExpected = "Mercury Network (ndr.VSG@corelogic.com)";

		} // end if QA

		if (env.equals("Live"))
		{
			mailFromExpected = "Mercury Network (MNDoNotReply@mercuryvmp.com)"; 
		}// end if Live


		// Verify MailFrom
		Assert.assertTrue(mailFrom.equals(mailFromExpected),
				"The MailFrom entry in the database is incorrect. DB value = "
						+ mailFrom + " and should be = " + mailFromExpected);

		// Verify MailTo
		Assert.assertTrue(mailTo.equals(mailToExpected),
				"The MailTo entry in the database is incorrect. DB value = "
						+ mailTo + " and should be = " + mailToExpected);

		// Verify Subject
		Assert.assertTrue(subject.equals(subjectExpected),
				"The Subject entry in the database is incorrect. DB value = "
						+ subject + " and should be = " + subjectExpected);

		// Verify TemplateUsed
		Assert.assertTrue(templateUsed.toLowerCase().equals(templateUsedExpected.toLowerCase()),
				"The TemplateUsed entry in the database is incorrect. DB value = "
						+ templateUsed + " and should be = "
						+ templateUsedExpected);

		// Verify SentDateTime is not NULL
		Assert.assertTrue(!sentDateTime.toLowerCase().equals("null"),
				"The SentDateTime entry in the database is null!");

		// Verify Successful is 1
		Assert.assertTrue(successful.equals(successfulExpected),
				"The Successful entry in the database is incorrect. DB value = "
						+ successful + " and should be = " + successfulExpected);

		// Verify FromEntityID
		Assert.assertTrue(fromEntityID.equals(fromEntityIDExpected),
				"The FromEntityID entry in the database is incorrect. DB value = "
						+ fromEntityID + " and should be = "
						+ fromEntityIDExpected);

		// Verify ToEntityID
		Assert.assertTrue(toEntityID.equals(toEntityIDExpected),
				"The ToEntityID entry in the database is incorrect. DB value = "
						+ toEntityID + " and should be = " + toEntityIDExpected);

		// Log test
		test.log(LogStatus.INFO, "Notifications", "Started AQM and ordered the AQI and QC Module and verified the notification");

	} // end startAQM

	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Find order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Set all AQM Preliminary Results to Passed and Calculate</li>
	 * 	<li>Click View Results</li>
	 * 	<li>driver.findElement(By.linkText("View Results")));</li>
	 * 	<li>Set all results to Passed</li>
	 * 	<li>Set dropdown elements</li>
	 * 	<li>Get the id of the row</li>
	 * 	<li>Set the dropdown element</li>
	 * 	<li>Click the dropdown</li>
	 * 	<li>Click Pass</li>
	 * 	<li>Click Calculate</li>
	 * 	<li>Verify MailQueue row count for this vmp productItemID</li>
	 * 	<li>Verify MailQueue row count for this secure productItemID</li>
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
	 * 	<li>Verify Attachments</li>
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
	 * 	<li>Verify the Secure EntityID receives AQI returned notifications in the database</li>
	 * 	<li>Log test</li>
	 * </ul>
	 * @throws Exception the exception
	 */
	@Test (groups={}, dependsOnMethods="startAQM")
	public void passAllAQMResults() throws Exception {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Log in to Secure
		secure.login(driver, userSecure, password);

		// Find order
		secure.findOrder(driver, orderNumber, "Tracking number");

		// Open the order
		secure.openOrder(driver, orderNumber);

		// Set all AQM Preliminary Results to Passed and Calculate
		// Wait for View Results link to be clickable
		WebElement viewResults = driver.findElement(By.linkText("View Results"));
		perform.waitForElementToBeClickable(driver, viewResults);

		Thread.sleep(2000);

		// Click View Results
		perform.click(driver, viewResults);

		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);

		// Wait for iFrames
		perform.waitForIFrames(driver);

		// Switch into iFrame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "/Common/AQMForms/AQMVarianceResults.aspx", By.id(SAQMQCModule.save_btn()));

		// Wait for Save button
		perform.waitForElementToBeClickable(driver, SAQMQCModule.save_btn(), "id");

		// Set all results to Passed
		// Set dropdown elements
		List<WebElement> els = driver.findElements(By.cssSelector("#tblResults > tbody > tr"));
		for(WebElement el : els) 
		{
			// Get the id of the row
			String id = el.getAttribute("id");

			// Set the dropdown element
			WebElement dropdownElement = driver.findElement(By.cssSelector("#"+id+" > td:nth-child(3) > div > span:nth-child(1)"));

			// Click the dropdown
			perform.click(driver,dropdownElement);

			// Wait for Pass
			perform.waitForElementToBeClickable(driver, SAQMQCModule.pass_btn(), "id");

			// Click Pass
			perform.click(driver,SAQMQCModule.pass_btn(driver));

			Thread.sleep(500);

		} // end for loop

		// Click Calculate
		perform.click(driver,SAQMQCModule.calculate_btn(driver));

		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);

		// Switch out of iFrames
		driver.switchTo().defaultContent();

		// Verify MailQueue row count for this vmp productItemID
		perform.verifyTheNumberOfRowsInTheMailQueueDBResultsForProductItemID(driver, 27, vmpProductItemID);

		// Verify MailQueue row count for this secure productItemID
		perform.verifyTheNumberOfRowsInTheMailQueueDBResultsForProductItemID(driver, 18, secureProductItemID);

		/***********************************************************************************************
		 * Verify the AQI report recipient from Client Group receives Appraisal Quality Index for (address) notifications in the database
		 ***********************************************************************************************/
		// Query the database and return the results as an array
		String sqlStatement = "SELECT TOP 1 * FROM [dbo].[MailQueue] WHERE ProductItemID = '"
				+ vmpProductItemID
				+ "' AND  MailTO = 'AQIRecipient@dntest.net'"
				+ " ORDER BY EnteredStamp DESC";
		ArrayList<String> results = db
				.getMailQueueInfoBySQLToArray(driver, sqlStatement);

		// Set expected results
		String mailFromExpected = "automation"+env+"Notifications1@dntest.net";
		String mailToExpected = "AQIRecipient@dntest.net";
		String subjectExpected = "Appraisal Quality Index for 501-D NE 122nd St, Oklahoma City, OK";
		String templateUsedExpected = server + "MN_AQIResults_ClientGroups.html";
		if (env.equals("Beta"))
		{
			templateUsedExpected = "\\\\ss1.internal.ad.mercuryvmp.com\\Shared Storage\\MercuryEmailTemplates\\Production\\MN_AQIResults_ClientGroups.html";
		}
		String successfulExpected = "1";
		String fromEntityIDExpected = xSiteEntityID;
		String toEntityIDExpected = "NULL";
		String attachmentsExpected = "AQI_Test PDF.pdf";

		// Set database values
		String mailFrom = results.get(4);
		String mailTo = results.get(5);
		String subject = results.get(8);
		String templateUsed = results.get(9);
		String attachments = results.get(10);
		String sentDateTime = results.get(11);
		String successful = results.get(12);
		String fromEntityID = results.get(13);
		String toEntityID = results.get(14);

		// Verify MailFrom
		Assert.assertTrue(mailFrom.equals(mailFromExpected),
				"The MailFrom entry in the database is incorrect. DB value = "
						+ mailFrom + " and should be = " + mailFromExpected);

		// Verify MailTo
		Assert.assertTrue(mailTo.equals(mailToExpected),
				"The MailTo entry in the database is incorrect. DB value = "
						+ mailTo + " and should be = " + mailToExpected);

		// Verify Subject
		Assert.assertTrue(subject.equals(subjectExpected),
				"The Subject entry in the database is incorrect. DB value = "
						+ subject + " and should be = " + subjectExpected);

		// Verify TemplateUsed
		Assert.assertTrue(templateUsed.toLowerCase().equals(templateUsedExpected.toLowerCase()),
				"The TemplateUsed entry in the database is incorrect. DB value = "
						+ templateUsed + " and should be = "
						+ templateUsedExpected);

		// Verify SentDateTime is not NULL
		Assert.assertTrue(!sentDateTime.toLowerCase().equals("null"),
				"The SentDateTime entry in the database is null!");

		// Verify Successful is 1
		Assert.assertTrue(successful.equals(successfulExpected),
				"The Successful entry in the database is incorrect. DB value = "
						+ successful + " and should be = " + successfulExpected);

		// Verify FromEntityID
		Assert.assertTrue(fromEntityID.equals(fromEntityIDExpected),
				"The FromEntityID entry in the database is incorrect. DB value = "
						+ fromEntityID + " and should be = "
						+ fromEntityIDExpected);

		// Verify ToEntityID
		Assert.assertTrue(toEntityID.equals(toEntityIDExpected),
				"The ToEntityID entry in the database is incorrect. DB value = "
						+ toEntityID + " and should be = " + toEntityIDExpected);

		// Verify Attachments
		Assert.assertTrue(attachments.contains(attachmentsExpected),
				"The Attachments entry in the database is incorrect. DB value = "
						+ attachments + " and should be = " + attachmentsExpected);

		/***********************************************************************************************
		 * Verify the Originator EntityID receives Document Attached notifications in the database
		 ***********************************************************************************************/
		// Query the database and return the results as an array
		sqlStatement = "SELECT TOP 1 * FROM [dbo].[MailQueue] WHERE ProductItemID = '"
				+ vmpProductItemID
				+ "' AND  ToEntityID = '"
				+ originatorEntityID
				+ "' ORDER BY EnteredStamp DESC";
		results = db
				.getMailQueueInfoBySQLToArray(driver, sqlStatement);

		// Set expected results
		mailFromExpected = "\"Automation"+env+"Notifications1\" (automation"+env+"Notifications1@dntest.net)";
		mailToExpected = "automation@dntest.net";
		subjectExpected = "New Document Attached to Order - Type: AQI";
		templateUsedExpected = server + "XSiteDocumentAttached.html";
		if (env.equals("Beta"))
		{
			templateUsedExpected = "\\\\ss1.internal.ad.mercuryvmp.com\\Shared Storage\\MercuryEmailTemplates\\Production\\XSiteDocumentAttached.html";
		}
		successfulExpected = "1";
		fromEntityIDExpected = xSiteEntityID;
		toEntityIDExpected = originatorEntityID;

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
						+ mailFrom + " and should be = " + mailFromExpected);

		// Verify MailTo
		Assert.assertTrue(mailTo.equals(mailToExpected),
				"The MailTo entry in the database is incorrect. DB value = "
						+ mailTo + " and should be = " + mailToExpected);

		// Verify Subject
		Assert.assertTrue(subject.equals(subjectExpected),
				"The Subject entry in the database is incorrect. DB value = "
						+ subject + " and should be = " + subjectExpected);

		// Verify TemplateUsed
		Assert.assertTrue(templateUsed.toLowerCase().equals(templateUsedExpected.toLowerCase()),
				"The TemplateUsed entry in the database is incorrect. DB value = "
						+ templateUsed + " and should be = "
						+ templateUsedExpected);

		// Verify SentDateTime is not NULL
		Assert.assertTrue(!sentDateTime.toLowerCase().equals("null"),
				"The SentDateTime entry in the database is null!");

		// Verify Successful is 1
		Assert.assertTrue(successful.equals(successfulExpected),
				"The Successful entry in the database is incorrect. DB value = "
						+ successful + " and should be = " + successfulExpected);

		// Verify FromEntityID
		Assert.assertTrue(fromEntityID.equals(fromEntityIDExpected),
				"The FromEntityID entry in the database is incorrect. DB value = "
						+ fromEntityID + " and should be = "
						+ fromEntityIDExpected);

		// Verify ToEntityID
		Assert.assertTrue(toEntityID.equals(toEntityIDExpected),
				"The ToEntityID entry in the database is incorrect. DB value = "
						+ toEntityID + " and should be = " + toEntityIDExpected);

		/***********************************************************************************************
		 * Verify the VMP XSite Additional Recipient receives Document Attached notifications in the database
		 ***********************************************************************************************/
		// Query the database and return the results as an array
		sqlStatement = "SELECT TOP 1 * FROM [dbo].[MailQueue] WHERE ProductItemID = '"
				+ vmpProductItemID
				+ "' AND  MailTo = '"
				+ additionalRecipient1
				+ "' ORDER BY EnteredStamp DESC";
		results = db
				.getMailQueueInfoBySQLToArray(driver, sqlStatement);

		// Set expected results
		mailFromExpected = "XSite Order on behalf of automation@dntest.net (ndr.VSG@corelogic.com)";
		mailToExpected = additionalRecipient1;
		subjectExpected = "New Document Attached to Order - Type: AQI";
		templateUsedExpected = server + "XSiteDocumentAttached_AddtlRecipients.html";
		if (env.equals("Beta"))
		{
			templateUsedExpected = "\\\\ss1.internal.ad.mercuryvmp.com\\Shared Storage\\MercuryEmailTemplates\\Production\\XSiteDocumentAttached_AddtlRecipients.html";
		}
		successfulExpected = "1";
		fromEntityIDExpected = originatorEntityID;
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


		if (env.equals("Live"))
		{
			mailFromExpected = "XSite Order on behalf of automation@dntest.net (MNDoNotReply@mercuryvmp.com)"; 
		}// end if Live


		// Verify MailFrom
		Assert.assertTrue(mailFrom.equals(mailFromExpected),
				"The MailFrom entry in the database is incorrect. DB value = "
						+ mailFrom + " and should be = " + mailFromExpected);

		// Verify MailTo
		Assert.assertTrue(mailTo.equals(mailToExpected),
				"The MailTo entry in the database is incorrect. DB value = "
						+ mailTo + " and should be = " + mailToExpected);

		// Verify Subject
		Assert.assertTrue(subject.equals(subjectExpected),
				"The Subject entry in the database is incorrect. DB value = "
						+ subject + " and should be = " + subjectExpected);

		// Verify TemplateUsed
		Assert.assertTrue(templateUsed.toLowerCase().equals(templateUsedExpected.toLowerCase()),
				"The TemplateUsed entry in the database is incorrect. DB value = "
						+ templateUsed + " and should be = "
						+ templateUsedExpected);

		// Verify SentDateTime is not NULL
		Assert.assertTrue(!sentDateTime.toLowerCase().equals("null"),
				"The SentDateTime entry in the database is null!");

		// Verify Successful is 1
		Assert.assertTrue(successful.equals(successfulExpected),
				"The Successful entry in the database is incorrect. DB value = "
						+ successful + " and should be = " + successfulExpected);

		// Verify FromEntityID
		Assert.assertTrue(fromEntityID.equals(fromEntityIDExpected),
				"The FromEntityID entry in the database is incorrect. DB value = "
						+ fromEntityID + " and should be = "
						+ fromEntityIDExpected);

		// Verify ToEntityID
		Assert.assertTrue(toEntityID.equals(toEntityIDExpected),
				"The ToEntityID entry in the database is incorrect. DB value = "
						+ toEntityID + " and should be = " + toEntityIDExpected);

		/***********************************************************************************************
		 * Verify the Managing Client Group Member receives Document Attached notifications in the database
		 ***********************************************************************************************/
		// Query the database and return the results as an array
		sqlStatement = "SELECT * FROM [dbo].[MailQueue] WHERE ProductItemID = '"
				+ vmpProductItemID
				+ "' AND  ToEntityID = '"
				+ managingOriginatorEntityID
				+ "' ORDER BY EnteredStamp DESC";
		results = db
				.getMailQueueInfoBySQLToArray(driver, sqlStatement);

		// Set expected results
		mailFromExpected = "XSite Order on behalf of automation@dntest.net (ndr.VSG@corelogic.com)";
		mailToExpected = "automation@dntest.net";
		subjectExpected = "New Document Attached to Order - Type: AQI";
		templateUsedExpected = server + "XSiteDocumentAttached.html";
		if (env.equals("Beta"))
		{
			templateUsedExpected = "\\\\ss1.internal.ad.mercuryvmp.com\\Shared Storage\\MercuryEmailTemplates\\Production\\XSiteDocumentAttached.html";
		}
		successfulExpected = "1";
		fromEntityIDExpected = originatorEntityID;
		toEntityIDExpected = managingOriginatorEntityID;

		// Set database values
		mailFrom = results.get(4);
		mailTo = results.get(5);
		subject = results.get(8);
		templateUsed = results.get(9);
		sentDateTime = results.get(11);
		successful = results.get(12);
		fromEntityID = results.get(13);
		toEntityID = results.get(14);

		//		if (env.equals("Live"))
		//		{
		//			mailFromExpected = "XSite Order on behalf of automation@dntest.net (MNDoNotReply@mercuryvmp.com)"; 
		//		}// end if Live

		// Verify MailFrom
		//		Assert.assertTrue(mailFrom.equals(mailFromExpected),
		//				"The MailFrom entry in the database is incorrect. DB value = "
		//						+ mailFrom + " and should be = " + mailFromExpected);

		// Verify MailTo
		Assert.assertTrue(mailTo.equals(mailToExpected),
				"The MailTo entry in the database is incorrect. DB value = "
						+ mailTo + " and should be = " + mailToExpected);

		// Verify Subject
		Assert.assertTrue(subject.equals(subjectExpected),
				"The Subject entry in the database is incorrect. DB value = "
						+ subject + " and should be = " + subjectExpected);

		// Verify TemplateUsed
		Assert.assertTrue(templateUsed.toLowerCase().equals(templateUsedExpected.toLowerCase()),
				"The TemplateUsed entry in the database is incorrect. DB value = "
						+ templateUsed + " and should be = "
						+ templateUsedExpected);

		// Verify SentDateTime is not NULL
		Assert.assertTrue(!sentDateTime.toLowerCase().equals("null"),
				"The SentDateTime entry in the database is null!");

		// Verify Successful is 1
		Assert.assertTrue(successful.equals(successfulExpected),
				"The Successful entry in the database is incorrect. DB value = "
						+ successful + " and should be = " + successfulExpected);

		// Verify FromEntityID
		Assert.assertTrue(fromEntityID.equals(fromEntityIDExpected),
				"The FromEntityID entry in the database is incorrect. DB value = "
						+ fromEntityID + " and should be = "
						+ fromEntityIDExpected);

		// Verify ToEntityID
		Assert.assertTrue(toEntityID.equals(toEntityIDExpected),
				"The ToEntityID entry in the database is incorrect. DB value = "
						+ toEntityID + " and should be = " + toEntityIDExpected);

		// Verify the Secure EntityID receives AQI returned notifications in the database
		test.log(LogStatus.WARNING, "Notifications", "There is no notification in the database for the Secure EntityID receives AQI returned notifications. The matrix shows there should be");

		// Log test
		test.log(LogStatus.INFO, "Notifications", "Set all AQM results to passed and verified the notifications");

	} // end passAllAQMResults

	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Find order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Submit the order to UCDP</li>
	 * 	<li>Verify MailQueue row count for this vmp productItemID</li>
	 * 	<li>Verify MailQueue row count for this secure productItemID</li>
	 * 	<li>perform.verifyTheNumberOfRowsInTheMailQueueDBResultsForProductItemID(driver, 24, secureProductItemID);</li>
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
	 * 	<li>Secure EntityID receives Appraisal Submission (successful or not successful) notification</li>
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
	 * 	<li>Managing Client Group Member receives Appraisal Submission (successful or not successful) notification</li>
	 * 	<li>Log test</li>
	 * </ul>
	 * @throws Exception the exception
	 */
	@Test (groups={}, dependsOnMethods="passAllAQMResults")
	public void submitOrderToUCDP() throws Exception {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Log in to Secure
		secure.login(driver, userSecure, password);

		// Find order
		secure.findOrder(driver, orderNumber, "Tracking number");

		// Open the order
		secure.openOrder(driver, orderNumber);

		// Submit the order to UCDP
		secure.submitToUCDP(driver, "Fannie Mae", "a la mode", "", "These are internal notes from EVFAMC on Secure", true);

		// Verify MailQueue row count for this vmp productItemID
		perform.verifyTheNumberOfRowsInTheMailQueueDBResultsForProductItemID(driver, 27, vmpProductItemID);

		// Verify MailQueue row count for this secure productItemID
		Thread.sleep(5000);
		//		perform.verifyTheNumberOfRowsInTheMailQueueDBResultsForProductItemID(driver, 24, secureProductItemID);
		perform.verifyTheNumberOfRowsInTheMailQueueDBResultsForProductItemID(driver, 24, secureProductItemID);

		/***********************************************************************************************
		 * Verify the Originator EntityID receives Document File ID Added notifications in the database
		 ***********************************************************************************************/
		// Query the database and return the results as an array
		String sqlStatement = "SELECT TOP 1 * FROM [dbo].[MailQueue] WHERE ProductItemID = '"
				+ secureProductItemID
				+ "' AND  ToEntityID = '"
				+ originatorEntityID
				+ "' AND Subject like '%UCDP Document File ID%'ORDER BY EnteredStamp DESC";
		ArrayList<String> results = db
				.getMailQueueInfoBySQLToArray(driver, sqlStatement);

		// Set expected results
		//		String mailFromExpected = "Mercury Network (MNDoNotReply@mercuryvmp.com)";
		String mailToExpected = "automation@dntest.net";
		String subjectExpected = "UCDP Document File ID Added for 501-D NE 122nd St, Oklahoma City, OK 73114";
		String templateUsedExpected = server + "XSiteDocFileIDadded.html";
		String successfulExpected = "1";
		String fromEntityIDExpected = secureEntityID;
		String toEntityIDExpected = originatorEntityID;

		// Set database values
		//		String mailFrom = results.get(4);
		String mailTo = results.get(5);
		String subject = results.get(8);
		String templateUsed = results.get(9);
		String sentDateTime = results.get(11);
		String successful = results.get(12);
		String fromEntityID = results.get(13);
		String toEntityID = results.get(14);

		// Verify MailTo
		Assert.assertTrue(mailTo.equals(mailToExpected),
				"The MailTo entry in the database is incorrect. DB value = "
						+ mailTo + " and should be = " + mailToExpected);

		// Verify Subject
		Assert.assertTrue(subject.equals(subjectExpected),
				"The Subject entry in the database is incorrect. DB value = "
						+ subject + " and should be = " + subjectExpected);

		// Verify TemplateUsed
		Assert.assertTrue(templateUsed.toLowerCase().equals(templateUsedExpected.toLowerCase()),
				"The TemplateUsed entry in the database is incorrect. DB value = "
						+ templateUsed + " and should be = "
						+ templateUsedExpected);

		// Verify SentDateTime is not NULL
		Assert.assertTrue(!sentDateTime.toLowerCase().equals("null"),
				"The SentDateTime entry in the database is null!");

		// Verify Successful is 1
		Assert.assertTrue(successful.equals(successfulExpected),
				"The Successful entry in the database is incorrect. DB value = "
						+ successful + " and should be = " + successfulExpected);

		// Verify FromEntityID
		Assert.assertTrue(fromEntityID.equals(fromEntityIDExpected),
				"The FromEntityID entry in the database is incorrect. DB value = "
						+ fromEntityID + " and should be = "
						+ fromEntityIDExpected);

		// Verify ToEntityID
		Assert.assertTrue(toEntityID.equals(toEntityIDExpected),
				"The ToEntityID entry in the database is incorrect. DB value = "
						+ toEntityID + " and should be = " + toEntityIDExpected);

		/***********************************************************************************************
		 * Verify the Originator EntityID receives Appraisal Submission (successful or not successful) notifications in the database
		 ***********************************************************************************************/
		// Query the database and return the results as an array
		sqlStatement = "SELECT TOP 1 * FROM [dbo].[MailQueue] WHERE ProductItemID = '"
				+ secureProductItemID
				+ "' AND  ToEntityID = '"
				+ originatorEntityID
				+ "' AND Subject like '%UCDP Appraisal Submission%' ORDER BY EnteredStamp DESC";
		results = db.getMailQueueInfoBySQLToArray(driver, sqlStatement);
		int i = 1;
		while (results.isEmpty() && i <= 10) {
			Thread.sleep(10000);
			System.out.println("Data was empty on the intial attempt. Retry " + i);
			results = db.getMailQueueInfoBySQLToArray(driver, sqlStatement);
			i++;
		} // end while

		// Set expected results
		//		String mailFromExpected = "Mercury Network (ndr.VSG@corelogic.com)";
		mailToExpected = "automation@dntest.net";
		subjectExpected = "UCDP Appraisal Submission Not Successful for 501-D NE 122nd St, Oklahoma City, OK 73114";
		templateUsedExpected = server + "XSiteAppraisalUCDPNotSuccessful.html";
		if (env.equals("Beta"))
		{
			templateUsedExpected = "\\\\ss1.internal.ad.mercuryvmp.com\\Shared Storage\\MercuryEmailTemplates\\production\\XSiteAppraisalUCDPNotSuccessful.html";
		}
		successfulExpected = "1";
		fromEntityIDExpected = secureEntityID;
		toEntityIDExpected = originatorEntityID;

		// Set database values
		//		String mailFrom = results.get(4);
		mailTo = results.get(5);
		subject = results.get(8);
		templateUsed = results.get(9);
		sentDateTime = results.get(11);
		successful = results.get(12);
		fromEntityID = results.get(13);
		toEntityID = results.get(14);

		// Verify MailTo
		Assert.assertTrue(mailTo.equals(mailToExpected),
				"The MailTo entry in the database is incorrect. DB value = "
						+ mailTo + " and should be = " + mailToExpected);

		// Verify Subject
		Assert.assertTrue(subject.equals(subjectExpected),
				"The Subject entry in the database is incorrect. DB value = "
						+ subject + " and should be = " + subjectExpected);

		// Verify TemplateUsed
		Assert.assertTrue(templateUsed.toLowerCase().equals(templateUsedExpected.toLowerCase()),
				"The TemplateUsed entry in the database is incorrect. DB value = "
						+ templateUsed + " and should be = "
						+ templateUsedExpected);

		// Verify SentDateTime is not NULL
		Assert.assertTrue(!sentDateTime.toLowerCase().equals("null"),
				"The SentDateTime entry in the database is null!");

		// Verify Successful is 1
		Assert.assertTrue(successful.equals(successfulExpected),
				"The Successful entry in the database is incorrect. DB value = "
						+ successful + " and should be = " + successfulExpected);

		// Verify FromEntityID
		Assert.assertTrue(fromEntityID.equals(fromEntityIDExpected),
				"The FromEntityID entry in the database is incorrect. DB value = "
						+ fromEntityID + " and should be = "
						+ fromEntityIDExpected);

		// Verify ToEntityID
		Assert.assertTrue(toEntityID.equals(toEntityIDExpected),
				"The ToEntityID entry in the database is incorrect. DB value = "
						+ toEntityID + " and should be = " + toEntityIDExpected);

		// Secure EntityID receives Appraisal Submission (successful or not successful) notification
		test.log(LogStatus.WARNING, "Notifications", "There is no notification in the database for the Secure EntityID receives Appraisal Submission (successful or not successful). The matrix shows there should be");		

		/***********************************************************************************************
		 * Verify the VMP XSite Additional Recipient receives Appraisal Submission (successful or not successful) notifications in the database
		 ***********************************************************************************************/
		// Query the database and return the results as an array
		sqlStatement = "SELECT TOP 1 * FROM [dbo].[MailQueue] WHERE ProductItemID = '"
				+ secureProductItemID
				+ "' AND  MailTo = '"
				+ additionalRecipient1
				+ "' AND Subject like '%UCDP Appraisal Submission%'ORDER BY EnteredStamp DESC";
		results = db
				.getMailQueueInfoBySQLToArray(driver, sqlStatement);
		i = 1;
		while (results.isEmpty() && i <= 10) {
			Thread.sleep(10000);
			System.out.println("Data was empty on the intial attempt. Retry " + i);
			results = db.getMailQueueInfoBySQLToArray(driver, sqlStatement);
			i++;
		} // end while

		// Set expected results
		//		String mailFromExpected = "Mercury Network (ndr.VSG@corelogic.com)";
		mailToExpected = additionalRecipient1;
		subjectExpected = "UCDP Appraisal Submission Not Successful for 501-D NE 122nd St, Oklahoma City, OK 73114";
		templateUsedExpected = server + "XSiteAppraisalUCDPNotSuccessful_AddtlRecipients.html";
		if (env.equals("Beta"))
		{
			templateUsedExpected = "\\\\ss1.internal.ad.mercuryvmp.com\\Shared Storage\\MercuryEmailTemplates\\production\\XSiteAppraisalUCDPNotSuccessful_AddtlRecipients.html";
		}
		successfulExpected = "1";
		fromEntityIDExpected = secureEntityID;
		toEntityIDExpected = "NULL";

		// Set database values
		//		String mailFrom = results.get(4);
		mailTo = results.get(5);
		subject = results.get(8);
		templateUsed = results.get(9);
		sentDateTime = results.get(11);
		successful = results.get(12);
		fromEntityID = results.get(13);
		toEntityID = results.get(14);

		// Verify MailTo
		Assert.assertTrue(mailTo.equals(mailToExpected),
				"The MailTo entry in the database is incorrect. DB value = "
						+ mailTo + " and should be = " + mailToExpected);

		// Verify Subject
		Assert.assertTrue(subject.equals(subjectExpected),
				"The Subject entry in the database is incorrect. DB value = "
						+ subject + " and should be = " + subjectExpected);

		// Verify TemplateUsed
		Assert.assertTrue(templateUsed.toLowerCase().equals(templateUsedExpected.toLowerCase()),
				"The TemplateUsed entry in the database is incorrect. DB value = "
						+ templateUsed + " and should be = "
						+ templateUsedExpected);

		// Verify SentDateTime is not NULL
		Assert.assertTrue(!sentDateTime.toLowerCase().equals("null"),
				"The SentDateTime entry in the database is null!");

		// Verify Successful is 1
		Assert.assertTrue(successful.equals(successfulExpected),
				"The Successful entry in the database is incorrect. DB value = "
						+ successful + " and should be = " + successfulExpected);

		// Verify FromEntityID
		Assert.assertTrue(fromEntityID.equals(fromEntityIDExpected),
				"The FromEntityID entry in the database is incorrect. DB value = "
						+ fromEntityID + " and should be = "
						+ fromEntityIDExpected);

		// Verify ToEntityID
		Assert.assertTrue(toEntityID.equals(toEntityIDExpected),
				"The ToEntityID entry in the database is incorrect. DB value = "
						+ toEntityID + " and should be = " + toEntityIDExpected);

		// Managing Client Group Member receives Appraisal Submission (successful or not successful) notification
		test.log(LogStatus.WARNING, "Notifications", "There is no notification in the database for the Managing Client Group Member receives Report Delivered to Borrower. The matrix shows there should be");

		// Log test
		test.log(LogStatus.INFO, "Notifications", "Submitted the order to UCDP and verified the notifications");

	} // end submitOrderToUCDP

} // end the RequireSalesContract class
