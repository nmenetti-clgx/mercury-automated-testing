package regressionStatusMapping;

import java.util.ArrayList;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Secure.SNewOrder;
import pageObjects.Secure.SOrderDetails;
import pageObjects.Secure.SUpdateClient;
import pageObjects.Secure.SVMPXSites;
import pageObjects.Secure.SVendorSelectionSettings;
import pageObjects.VMP.VMPConfirmOrder;
import pageObjects.VMP.VMPNewOrder;
import pageObjects.VMP.VMPOrderDetails;
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
 * <h1>Status Mapping - Pending Quality Review Syncing</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
@Test(singleThreaded=true)
public class PendingQualityReviewSyncing extends TestSetup {
	
	/** The user vendors. */
	private final String userVendors = "RegressionVendors2";
	
	/** The user secure. */
	private final String userSecure = "PQR1";
	
	/** The user VMP. */
	private final String userVMP = "OriginatorPQR1";
	
	/** The originator entity ID. */
	// Initialize variables
	private static String originatorEntityID = "";
	
	/** The x site entity ID. */
	private static String xSiteEntityID = "";
	
	/** The env. */
	private static String env = "";
	
	/** The server. */
	private static String server = "";
	
	/** The vmp product item ID. */
	private static String vmpProductItemID = "";
	
	/** The secure product item ID. */
	private static String secureProductItemID = "";
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the server address per the environment</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Click Preferences &gt; Vendor Selection Settings</li>
	 * 	<li>Disable Unattended Order Assignment</li>
	 * 	<li>Disable Unattended Order Reassignment</li>
	 * 	<li>Select Custom fee panel radio button</li>
	 * 	<li>Uncheck Use Mercury Network directory as backup</li>
	 * 	<li>Save</li>
	 * 	<li>Click Preferences &gt; VMP XSites</li>
	 * 	<li>Click Configure Automatic Settings</li>
	 * 	<li>Check Use QC Folders checkbox</li>
	 * 	<li>Save</li>
	 * 	<li>Click Configure Status Mapping</li>
	 * 	<li>Check the Pending Quality Review sync arrow</li>
	 * 	<li>Click Pending Quality Review gear icon</li>
	 * 	<li>Check Always include appraisal checkbox</li>
	 * 	<li>Check attach appraisal checkbox</li>
	 * 	<li>Click OK</li>
	 * 	<li>Click Save</li>
	 * 	<li>Click AMC/Firm button</li>
	 * 	<li>Scroll the gear icon into view</li>
	 * 	<li>Click gear icon</li>
	 * 	<li>Verify both checkboxes are there</li>
	 * 	<li>Click OK</li>
	 * 	<li>From VMP Client Portal, place an order</li>
	 * 	<li>Login to VMP Client Portal</li>
	 * 	<li>Set variables for new order</li>
	 * 	<li>Create VMP order and assign an appraiser</li>
	 * 	<li>Login to Vendors</li>
	 * 	<li>Complete order</li>
	 * 	<li>Login to VMP</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Verify Completed Report synced</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Click Edit</li>
	 * 	<li>Edit the Loan Number</li>
	 * 	<li>Click Save</li>
	 * 	<li>Check Lender Case#</li>
	 * 	<li>Click OK</li>
	 * 	<li>Verify Completed Report synced</li>
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
	 * 	<li>Verify Attachments</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Verify tool tip text</li>
	 * 	<li>Click the Request revision radio button</li>
	 * 	<li>Click OK</li>
	 * 	<li>Login to Vendors</li>
	 * 	<li>Complete order</li>
	 * 	<li>Login to VMP</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Verify Completed Report synced</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Verify Completed Report synced</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Status Mapping", "Secure - Vendor Selection Settings", "Secure - VMP XSite Settings", "Secure - Configure Status Mapping", "VMP - Create Order", "Vendors - Complete Order", "VMP - Orders", "Secure - Orders", "Secure - Edit Order",
			"Verify Mail Queue", "Secure - Request Revision"}, alwaysRun=true)
	public void bothOptionsChecked() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		String password = StoredVariables.getpassword().get();
		
		/**************************************************************************
		 * Get EntityID's and Group ID's for SQL queries
		 **************************************************************************/
		env = StoredVariables.getusernameEnvironment().get();
		// Set the variables
		if (env.equals("QA"))
		{
			originatorEntityID = "1071304";
			xSiteEntityID = "1071302";
		} // end if QA
		if (env.equals("Beta"))
		{
			originatorEntityID = "5572705";
			xSiteEntityID = "5572691";
		} // end if Beta
		if (env.equals("Live"))
		{
			originatorEntityID = "5572706";
			xSiteEntityID = "5572693";
		} // end if Live
		
		// Set the server address per the environment
		if (env.equals("QA"))
		{
			server = "\\\\ss1qa.internal.ad.mercuryvmp.com\\Shared Storage\\MercuryEmailTemplates\\QA\\";
		} // end if QA
		else
		{
			server = "\\\\ss1.internal.ad.mercuryvmp.com\\Shared Storage\\MercuryEmailTemplates\\Production\\";
		} // end if Live
		
		// Login to Secure
		secure.login(driver, userSecure, password);
		
		// Click Preferences > Vendor Selection Settings
		secure.goToVendorSelectionSettings(driver);
		
		// Disable Unattended Order Assignment
		if(!SVendorSelectionSettings.unattendedOrderAssignment_switch(driver).getAttribute("src").contains("Off.png"))
		{
			perform.click(driver,SVendorSelectionSettings.unattendedOrderAssignment_switch(driver));
		} // end if
		
		// Disable Unattended Order Reassignment
		if(SVendorSelectionSettings.unattendedOrderReassignment_switch(driver).getAttribute("src").contains("On.png"))
		{
			perform.click(driver,SVendorSelectionSettings.unattendedOrderReassignment_switch(driver));
		} // end if
		
		// Select Custom fee panel radio button
		perform.click(driver,SVendorSelectionSettings.customFeePanel_radio(driver));
		
		// Uncheck Use Mercury Network directory as backup
		perform.uncheckCheckbox(driver, SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver));
		
		Thread.sleep(1500);
		
		// Save
		secure.saveVendorSelectionSettings(driver);
		
		// Click Preferences > VMP XSites
		secure.goToVMPXSites(driver);
		
		// Click Configure Automatic Settings
		perform.click(driver,SVMPXSites.configureAutomaticSettings_lnk(driver));
		
		// Wait for Use QC folders checkbox
		perform.waitForElementToBeClickable(driver, SVMPXSites.useQCFolders_chckbx(), "id");
		
		// Check Use QC Folders checkbox
		perform.checkCheckbox(driver, SVMPXSites.useQCFolders_chckbx(driver));
		
		// Save
		secure.saveVMPXSiteSettings(driver);
		
		// Click Configure Status Mapping
		perform.click(driver,SVMPXSites.configureStatusMapping_lnk(driver));
		
		// Wait for Appraiser button
		perform.waitForElementToBeClickable(driver, SVMPXSites.appraiser_btn(), "cssSelector");
		
		// Check the Pending Quality Review sync arrow
		secure.setStatusMapping(driver, "Pending Quality Review", "both");
		
		// Click Pending Quality Review gear icon
		perform.click(driver,SVMPXSites.pendingQualityReviewGearIcon_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for checkbox
		perform.waitForElementToBeClickable(driver, SVMPXSites.alwaysIncludeAppraisalReport_chckbx(), "id");
		
		// Check Always include appraisal checkbox
		perform.checkCheckbox(driver, SVMPXSites.alwaysIncludeAppraisalReport_chckbx(driver));
		
		// Check attach appraisal checkbox
		perform.checkCheckbox(driver, SVMPXSites.attachAppraisalReport_chckbx(driver));
		
		// Click OK
		perform.clickWithJavascript(driver, SVMPXSites.okSync_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Click Save
		perform.click(driver,SVMPXSites.save_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Click AMC/Firm button
		perform.click(driver,SVMPXSites.amcFirm_btn(driver));
		
		// Wait for gear icon
		perform.waitForElementToBeClickable(driver, SVMPXSites.pendingQualityReviewGearIconAMC_btn(), "id");
		
		// Scroll the gear icon into view
		perform.scrollElementIntoView(driver, SVMPXSites.pendingQualityReviewGearIconAMC_btn(driver));
		
		// Click gear icon
		perform.click(driver,SVMPXSites.pendingQualityReviewGearIconAMC_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Verify both checkboxes are there
		Assert.assertTrue(SVMPXSites.alwaysIncludeAppraisalReport_chckbx(driver).isDisplayed()==true, "Always include checkbox is missing");
		Assert.assertTrue(SVMPXSites.attachAppraisalReport_chckbx(driver).isDisplayed()==true, "Attach appraisal checkbox is missing");
		
		// Click OK
		perform.clickWithJavascript(driver, SVMPXSites.okSync_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// From VMP Client Portal, place an order
		// Login to VMP Client Portal
		vmp.login(driver, userSecure, userVMP, password);
		
		// Set variables for new order
		vmp.setMinimumVariables(driver);
		
		// Create VMP order and assign an appraiser
		createVMPOrderAndAssignItToAnAppraiser(driver);
		String trackingNumber = StoredVariables.gettrackingNumber().get();
		String trackingNumberVMP = StoredVariables.gettrackingNumberVMP().get();
		
		// Login to Vendors
		vendors.login(driver, userVendors, password);
		
		// Accept the order
		vendors.acceptOrder(driver, trackingNumber);
		
		// Complete order
		String loanID = StoredVariables.getloanID().get();
		vendors.completeOrderByHTTPPost(driver, userVendors, password, loanID, "Complete.xml");
		
		// Login to VMP
		vmp.login(driver, userSecure, userVMP, password);
		
		// Find the order
		vmp.findOrder(driver, trackingNumberVMP, "Tracking #");
		
		// Open the order
		vmp.openOrder(driver, trackingNumberVMP);
		
		// Verify Completed Report synced
		String docs = VMPOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(docs.contains("Completed Report (Current)"), "The Completed Report did not sync to VMP");
		Assert.assertTrue(docs.contains("Report PDF"), "The Report PDF did not sync to VMP");
		Assert.assertTrue(docs.contains("MISMO XML"), "The MISMO XML did not sync to VMP");
		
		// Login to Secure
		secure.login(driver, userSecure, password);
		
		// Find the order
		secure.findOrder(driver, trackingNumber, "Tracking number");

		// Open the order
		secure.openOrder(driver, trackingNumber);
		
		// Click Edit
		perform.click(driver,SOrderDetails.edit_btn(driver));
		
		// Wait for Address textbox
		perform.waitForElementToBeClickable(driver, SNewOrder.address_txtbx(), "id");
		
		// Edit the Loan Number
		StoredVariables.getassignmentInformationLoanNumber().set(perform.randomNumbers(driver, 15));
		SNewOrder.loanNumber_txtbx(driver).clear();
		perform.type(driver,SNewOrder.loanNumber_txtbx(driver), StoredVariables.getassignmentInformationLoanNumber().get());
		
		// Click Save
		perform.click(driver,SNewOrder.saveTop_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for Lender Case# checkbox
		perform.waitForElementToBeClickable(driver, SUpdateClient.update1_btn(), "id");
		
		// Check Lender Case#
		perform.checkCheckbox(driver, SUpdateClient.update1_btn(driver));
		
		// Click OK 
		perform.click(driver,SUpdateClient.ok_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Verify Completed Report synced
		docs = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(docs.contains("Completed Report (Current)"), "The Completed Report did not sync to VMP");
		Assert.assertTrue(docs.contains("Report PDF"), "The Report PDF did not sync to VMP");
		Assert.assertTrue(docs.contains("MISMO XML"), "The MISMO XML did not sync to VMP");
		
		// Verify MailQueue row count for this productItemID
		perform.verifyTheNumberOfRowsInTheMailQueueDBResultsForProductItemID(driver, 4, vmpProductItemID);
		perform.verifyTheNumberOfRowsInTheMailQueueDBResultsForProductItemID(driver, 4, secureProductItemID);
		
		/***********************************************************************************************
		 * Verify the notifications in the database
		 ***********************************************************************************************/
		// Query the database and return the results as an array
		String sqlStatement = "SELECT TOP 1 * FROM [dbo].[MailQueue] WHERE ProductItemID = '"
				+ vmpProductItemID
				+ "' AND  ToEntityID = '"
				+ originatorEntityID
				+ "' ORDER BY EnteredStamp DESC";
		ArrayList<String> results = db
				.getMailQueueInfoBySQLToArray(driver, sqlStatement);

		// Set expected results
		String mailFromExpected = "XSite Order on behalf of automation"+env+"PQR1@dntest.net (MNDoNotReply@mercuryvmp.com)";
		String mailToExpected = "automation@dntest.net";
		String subjectExpected = "Order Status Update for Baseline Test";
		String templateUsedExpected = server + "XSiteStatusUpdate.html";
		String successfulExpected = "1";
		String fromEntityIDExpected = xSiteEntityID;
		String toEntityIDExpected = originatorEntityID;
		String attachmentsExpected = "Test PDF.pdf";

		// Set database values
		String mailFrom = results.get(4);
		String mailTo = results.get(5);
		String subject = results.get(8);
		String templateUsed = results.get(9);
		String sentDateTime = results.get(11);
		String successful = results.get(12);
		String fromEntityID = results.get(13);
		String toEntityID = results.get(14);
		String attachments = results.get(10);

		// Verify MailFrom
		Assert.assertTrue(mailFrom.equals(mailFromExpected),
				"The MailFrom entry in the database is incorrect. DB value = "
						+ mailFrom + " and shoudl be = " + mailFromExpected);

		// Verify MailTo
		Assert.assertTrue(mailTo.equals(mailToExpected),
				"The MailTo entry in the database is incorrect. DB value = "
						+ mailTo + " and shoudl be = " + mailToExpected);

		// Verify Subject
		Assert.assertTrue(subject.contains(subjectExpected),
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
		
		// Verify Attachments
		Assert.assertTrue(attachments.contains(attachmentsExpected),
				"The Attachmetns entry in the database is incorrect. DB value = "
						+ attachments + " and shoudl be = " + attachmentsExpected);

		// Verify order details
		secure.verifyResidentialAppraisalOrderDetails(driver);
		
		// Verify tool tip text
		String toolTip = SOrderDetails.toolTip_txt(driver).getAttribute("title");
		System.out.println("toolTip = " + toolTip);
		Assert.assertTrue(toolTip.contains("Appraisal report included"), "The tool tip does not contain Appraisal report included");
		
		// Click the Request revision radio button
		perform.click(driver,SOrderDetails.requestRevision_radioBtn(driver));
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SOrderDetails.okProcessReceivedReport_btn(), "id");
		
		Thread.sleep(4000);
		
		// Click OK
		perform.click(driver,SOrderDetails.okProcessReceivedReport_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Login to Vendors
		vendors.login(driver, userVendors, password);
		
		// Complete order
		loanID = StoredVariables.getloanID().get();
		vendors.completeOrderByHTTPPost(driver, userVendors, password, loanID, "Complete.xml");
		
		// Login to VMP
		vmp.login(driver, userSecure, userVMP, password);
		
		// Find the order
		vmp.findOrder(driver, trackingNumberVMP, "Tracking #");
		
		// Open the order
		vmp.openOrder(driver, trackingNumberVMP);
		
		// Verify Completed Report synced
		docs = VMPOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(docs.contains("Completed Report (Current)"), "The Completed Report did not sync to VMP");
		Assert.assertTrue(docs.contains("Report PDF"), "The Report PDF did not sync to VMP");
		Assert.assertTrue(docs.contains("Previously Completed Reports"), "The MISMO XML did not sync to VMP");
		
		// Login to Secure
		secure.login(driver, userSecure, password);
		
		// Find the order
		secure.findOrder(driver, trackingNumber, "Tracking number");

		// Open the order
		secure.openOrder(driver, trackingNumber);
		
		// Verify Completed Report synced
		docs = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(docs.contains("Completed Report (Current)"), "The Completed Report did not sync to VMP");
		Assert.assertTrue(docs.contains("Report PDF"), "The Report PDF did not sync to VMP");
		Assert.assertTrue(docs.contains("Previously Completed Reports"), "The MISMO XML did not sync to VMP");
		
		// Log test
		test.log(LogStatus.INFO, "Status Mapping Regression Test", "Verified Pending Quality Review syncing is working properly and does show the Completed Report on the 1st order");
		
	} // end bothOptionsChecked
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the server address per the environment</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Click Preferences &gt; Vendor Selection Settings</li>
	 * 	<li>Disable Unattended Order Assignment</li>
	 * 	<li>Disable Unattended Order Reassignment</li>
	 * 	<li>Select Custom fee panel radio button</li>
	 * 	<li>Uncheck Use Mercury Network directory as backup</li>
	 * 	<li>Save</li>
	 * 	<li>Click Preferences &gt; VMP XSites</li>
	 * 	<li>Click Configure Automatic Settings</li>
	 * 	<li>Check Use QC Folders checkbox</li>
	 * 	<li>Save</li>
	 * 	<li>Click Configure Status Mapping</li>
	 * 	<li>Check the Pending Quality Review sync arrow</li>
	 * 	<li>Click Pending Quality Review gear icon</li>
	 * 	<li>Check Always include appraisal checkbox</li>
	 * 	<li>Uncheck Attach appraisal checkbox</li>
	 * 	<li>Click OK</li>
	 * 	<li>Click Save</li>
	 * 	<li>Click AMC/Firm button</li>
	 * 	<li>Scroll the gear icon into view</li>
	 * 	<li>Click gear icon</li>
	 * 	<li>Verify both checkboxes are there</li>
	 * 	<li>Click OK</li>
	 * 	<li>From VMP Client Portal, place an order</li>
	 * 	<li>Login to VMP Client Portal</li>
	 * 	<li>Set variables for new order</li>
	 * 	<li>Create VMP order and assign an appraiser</li>
	 * 	<li>Login to Vendors</li>
	 * 	<li>Complete order</li>
	 * 	<li>Login to VMP</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Verify Completed Report synced</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Verify Completed Report synced</li>
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
	 * 	<li>Verify Attachments</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Verify tool tip text</li>
	 * 	<li>Click the Request revision radio button</li>
	 * 	<li>Click OK</li>
	 * 	<li>Login to Vendors</li>
	 * 	<li>Complete order</li>
	 * 	<li>Login to VMP</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Verify Completed Report synced</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Verify Completed Report synced</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Status Mapping", "Secure - Vendor Selection Settings", "Secure - VMP XSite Settings", "Secure - Configure Status Mapping", "VMP - Create Order", "Vendors - Complete Order", "VMP - Orders", "Secure - Orders",
			"Verify Mail Queue", "Secure - Request Revision"}, alwaysRun=true)
	public void alwaysIncludeOptionChecked() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		String password = StoredVariables.getpassword().get();
		
		/**************************************************************************
		 * Get EntityID's and Group ID's for SQL queries
		 **************************************************************************/
		env = StoredVariables.getusernameEnvironment().get();
		// Set the variables
		if (env.equals("QA"))
		{
			originatorEntityID = "1071304";
			xSiteEntityID = "1071302";
		} // end if QA
		if (env.equals("Beta"))
		{
			originatorEntityID = "5572705";
			xSiteEntityID = "5572691";
		} // end if Beta
		if (env.equals("Live"))
		{
			originatorEntityID = "5572706";
			xSiteEntityID = "5572693";
		} // end if Live
		
		// Set the server address per the environment
		if (env.equals("QA"))
		{
			server = "\\\\ss1qa.internal.ad.mercuryvmp.com\\Shared Storage\\MercuryEmailTemplates\\QA\\";
		} // end if QA
		else
		{
			server = "\\\\ss1.internal.ad.mercuryvmp.com\\Shared Storage\\MercuryEmailTemplates\\Production\\";
		} // end if Live
		
		// Login to Secure
		secure.login(driver, userSecure, password);
		
		// Click Preferences > Vendor Selection Settings
		secure.goToVendorSelectionSettings(driver);
		
		// Disable Unattended Order Assignment
		if(!SVendorSelectionSettings.unattendedOrderAssignment_switch(driver).getAttribute("src").contains("Off.png"))
		{
			perform.click(driver,SVendorSelectionSettings.unattendedOrderAssignment_switch(driver));
		} // end if
		
		// Disable Unattended Order Reassignment
		if(SVendorSelectionSettings.unattendedOrderReassignment_switch(driver).getAttribute("src").contains("On.png"))
		{
			perform.click(driver,SVendorSelectionSettings.unattendedOrderReassignment_switch(driver));
		} // end if
		
		// Select Custom fee panel radio button
		perform.click(driver,SVendorSelectionSettings.customFeePanel_radio(driver));
		
		// Uncheck Use Mercury Network directory as backup
		perform.uncheckCheckbox(driver, SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver));
		
		Thread.sleep(1500);
		
		// Save
		secure.saveVendorSelectionSettings(driver);
		
		// Click Preferences > VMP XSites
		secure.goToVMPXSites(driver);
		
		// Click Configure Automatic Settings
		perform.click(driver,SVMPXSites.configureAutomaticSettings_lnk(driver));
		
		// Wait for Use QC folders checkbox
		perform.waitForElementToBeClickable(driver, SVMPXSites.useQCFolders_chckbx(), "id");
		
		// Check Use QC Folders checkbox
		perform.checkCheckbox(driver, SVMPXSites.useQCFolders_chckbx(driver));
		
		// Save
		secure.saveVMPXSiteSettings(driver);
		
		// Click Configure Status Mapping
		perform.click(driver,SVMPXSites.configureStatusMapping_lnk(driver));
		
		// Wait for Appraiser button
		perform.waitForElementToBeClickable(driver, SVMPXSites.appraiser_btn(), "cssSelector");
		
		// Check the Pending Quality Review sync arrow
		secure.setStatusMapping(driver, "Pending Quality Review", "both");
		
		// Click Pending Quality Review gear icon
		perform.click(driver,SVMPXSites.pendingQualityReviewGearIcon_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for checkbox
		perform.waitForElementToBeClickable(driver, SVMPXSites.alwaysIncludeAppraisalReport_chckbx(), "id");
		
		// Check Always include appraisal checkbox
		perform.checkCheckbox(driver, SVMPXSites.alwaysIncludeAppraisalReport_chckbx(driver));
		
		// Uncheck Attach appraisal checkbox
		perform.uncheckCheckbox(driver, SVMPXSites.attachAppraisalReport_chckbx(driver));
		
		// Click OK
		perform.clickWithJavascript(driver, SVMPXSites.okSync_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Click Save
		perform.click(driver,SVMPXSites.save_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Click AMC/Firm button
		perform.click(driver,SVMPXSites.amcFirm_btn(driver));
		
		// Wait for gear icon
		perform.waitForElementToBeClickable(driver, SVMPXSites.pendingQualityReviewGearIconAMC_btn(), "id");
		
		// Scroll the gear icon into view
		perform.scrollElementIntoView(driver, SVMPXSites.pendingQualityReviewGearIconAMC_btn(driver));
		
		// Click gear icon
		perform.click(driver,SVMPXSites.pendingQualityReviewGearIconAMC_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Verify both checkboxes are there
		Assert.assertTrue(SVMPXSites.alwaysIncludeAppraisalReport_chckbx(driver).isDisplayed()==true, "Always include checkbox is missing");
		Assert.assertTrue(SVMPXSites.attachAppraisalReport_chckbx(driver).isDisplayed()==true, "Attach appraisal checkbox is missing");
		
		// Click OK
		perform.clickWithJavascript(driver, SVMPXSites.okSync_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// From VMP Client Portal, place an order
		// Login to VMP Client Portal
		vmp.login(driver, userSecure, userVMP, password);
		
		// Set variables for new order
		vmp.setMinimumVariables(driver);
		
		// Create VMP order and assign an appraiser
		createVMPOrderAndAssignItToAnAppraiser(driver);
		String trackingNumber = StoredVariables.gettrackingNumber().get();
		String trackingNumberVMP = StoredVariables.gettrackingNumberVMP().get();
		
		// Login to Vendors
		vendors.login(driver, userVendors, password);
		
		// Accept the order
		vendors.acceptOrder(driver, trackingNumber);
		
		// Complete order
		String loanID = StoredVariables.getloanID().get();
		vendors.completeOrderByHTTPPost(driver, userVendors, password, loanID, "Complete.xml");
		
		// Login to VMP
		vmp.login(driver, userSecure, userVMP, password);
		
		// Find the order
		vmp.findOrder(driver, trackingNumberVMP, "Tracking #");
		
		// Open the order
		vmp.openOrder(driver, trackingNumberVMP);
		
		// Verify Completed Report synced
		String docs = VMPOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(docs.contains("Completed Report (Current)"), "The Completed Report did not sync to VMP");
		Assert.assertTrue(docs.contains("Report PDF"), "The Report PDF did not sync to VMP");
		Assert.assertTrue(docs.contains("MISMO XML"), "The MISMO XML did not sync to VMP");
		
		// Login to Secure
		secure.login(driver, userSecure, password);
		
		// Find the order
		secure.findOrder(driver, trackingNumber, "Tracking number");

		// Open the order
		secure.openOrder(driver, trackingNumber);
		
		// Verify Completed Report synced
		docs = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(docs.contains("Completed Report (Current)"), "The Completed Report did not sync to VMP");
		Assert.assertTrue(docs.contains("Report PDF"), "The Report PDF did not sync to VMP");
		Assert.assertTrue(docs.contains("MISMO XML"), "The MISMO XML did not sync to VMP");
		
		// Verify MailQueue row count for this productItemID
		perform.verifyTheNumberOfRowsInTheMailQueueDBResultsForProductItemID(driver, 4, vmpProductItemID);
		perform.verifyTheNumberOfRowsInTheMailQueueDBResultsForProductItemID(driver, 3, secureProductItemID);
		
		/***********************************************************************************************
		 * Verify the notifications in the database
		 ***********************************************************************************************/
		// Query the database and return the results as an array
		String sqlStatement = "SELECT TOP 1 * FROM [dbo].[MailQueue] WHERE ProductItemID = '"
				+ vmpProductItemID
				+ "' AND  ToEntityID = '"
				+ originatorEntityID
				+ "' ORDER BY EnteredStamp DESC";
		ArrayList<String> results = db
				.getMailQueueInfoBySQLToArray(driver, sqlStatement);

		// Set expected results
		String mailFromExpected = "XSite Order on behalf of automation"+env+"PQR1@dntest.net (MNDoNotReply@mercuryvmp.com)";
		String mailToExpected = "automation@dntest.net";
		String subjectExpected = "Order Status Update for Baseline Test";
		String templateUsedExpected = server + "XSiteStatusUpdate.html";
		String successfulExpected = "1";
		String fromEntityIDExpected = xSiteEntityID;
		String toEntityIDExpected = originatorEntityID;
		String attachmentsExpected = "NULL";

		// Set database values
		String mailFrom = results.get(4);
		String mailTo = results.get(5);
		String subject = results.get(8);
		String templateUsed = results.get(9);
		String sentDateTime = results.get(11);
		String successful = results.get(12);
		String fromEntityID = results.get(13);
		String toEntityID = results.get(14);
		String attachments = results.get(10);

		// Verify MailFrom
		Assert.assertTrue(mailFrom.equals(mailFromExpected),
				"The MailFrom entry in the database is incorrect. DB value = "
						+ mailFrom + " and shoudl be = " + mailFromExpected);

		// Verify MailTo
		Assert.assertTrue(mailTo.equals(mailToExpected),
				"The MailTo entry in the database is incorrect. DB value = "
						+ mailTo + " and shoudl be = " + mailToExpected);

		// Verify Subject
		Assert.assertTrue(subject.contains(subjectExpected),
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
		
		// Verify Attachments
		Assert.assertTrue(attachments.equals(attachmentsExpected),
				"The Attachmetns entry in the database is incorrect. DB value = "
						+ attachments + " and shoudl be = " + attachmentsExpected);

		// Verify order details
		secure.verifyResidentialAppraisalOrderDetails(driver);
		
		// Verify tool tip text
		String toolTip = SOrderDetails.toolTip_txt(driver).getAttribute("title");
		System.out.println("toolTip = " + toolTip);
		Assert.assertTrue(toolTip.contains("Appraisal report included"), "The tool tip does not contain Appraisal report included");
		
		// Click the Request revision radio button
		perform.click(driver,SOrderDetails.requestRevision_radioBtn(driver));
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SOrderDetails.okProcessReceivedReport_btn(), "id");
		
		Thread.sleep(4000);
		
		// Click OK
		perform.click(driver,SOrderDetails.okProcessReceivedReport_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Login to Vendors
		vendors.login(driver, userVendors, password);
		
		// Complete order
		loanID = StoredVariables.getloanID().get();
		vendors.completeOrderByHTTPPost(driver, userVendors, password, loanID, "Complete.xml");
		
		// Login to VMP
		vmp.login(driver, userSecure, userVMP, password);
		
		// Find the order
		vmp.findOrder(driver, trackingNumberVMP, "Tracking #");
		
		// Open the order
		vmp.openOrder(driver, trackingNumberVMP);
		
		// Verify Completed Report synced
		docs = VMPOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(docs.contains("Completed Report (Current)"), "The Completed Report did not sync to VMP");
		Assert.assertTrue(docs.contains("Report PDF"), "The Report PDF did not sync to VMP");
		Assert.assertTrue(docs.contains("Previously Completed Reports"), "The MISMO XML did not sync to VMP");
		
		// Login to Secure
		secure.login(driver, userSecure, password);
		
		// Find the order
		secure.findOrder(driver, trackingNumber, "Tracking number");

		// Open the order
		secure.openOrder(driver, trackingNumber);
		
		// Verify Completed Report synced
		docs = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(docs.contains("Completed Report (Current)"), "The Completed Report did not sync to VMP");
		Assert.assertTrue(docs.contains("Report PDF"), "The Report PDF did not sync to VMP");
		Assert.assertTrue(docs.contains("Previously Completed Reports"), "The MISMO XML did not sync to VMP");
		
		// Log test
		test.log(LogStatus.INFO, "Status Mapping Regression Test", "Verified Pending Quality Review syncing is working properly and does show the Completed Report on the 1st order");
		
	} // end alwaysIncludeOptionChecked
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the server address per the environment</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Click Preferences &gt; Vendor Selection Settings</li>
	 * 	<li>Disable Unattended Order Assignment</li>
	 * 	<li>Disable Unattended Order Reassignment</li>
	 * 	<li>Select Custom fee panel radio button</li>
	 * 	<li>Uncheck Use Mercury Network directory as backup</li>
	 * 	<li>Save</li>
	 * 	<li>Click Preferences &gt; VMP XSites</li>
	 * 	<li>Click Configure Automatic Settings</li>
	 * 	<li>Check Use QC Folders checkbox</li>
	 * 	<li>Save</li>
	 * 	<li>Click Configure Status Mapping</li>
	 * 	<li>Check the Pending Quality Review sync arrow</li>
	 * 	<li>Click Pending Quality Review gear icon</li>
	 * 	<li>Uncheck Always include appraisal checkbox</li>
	 * 	<li>Check Attach appraisal checkbox</li>
	 * 	<li>Click OK</li>
	 * 	<li>Click Save</li>
	 * 	<li>Click AMC/Firm button</li>
	 * 	<li>Scroll the gear icon into view</li>
	 * 	<li>Click gear icon</li>
	 * 	<li>Verify both checkboxes are there</li>
	 * 	<li>Click OK</li>
	 * 	<li>From VMP Client Portal, place an order</li>
	 * 	<li>Login to VMP Client Portal</li>
	 * 	<li>Set variables for new order</li>
	 * 	<li>Create VMP order and assign an appraiser</li>
	 * 	<li>Login to Vendors</li>
	 * 	<li>Complete order</li>
	 * 	<li>Login to VMP</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Verify Completed Report synced</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Verify Completed Report synced</li>
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
	 * 	<li>Verify Attachments</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Verify tool tip text</li>
	 * 	<li>Click the Request revision radio button</li>
	 * 	<li>Click OK</li>
	 * 	<li>Login to Vendors</li>
	 * 	<li>Complete order</li>
	 * 	<li>Login to VMP</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Verify Completed Report synced</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Verify Completed Report synced</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Status Mapping", "Secure - Vendor Selection Settings", "Secure - VMP XSite Settings", "Secure - Configure Status Mapping", "VMP - Create Order", "Vendors - Complete Order", "VMP - Orders", "Secure - Orders",
			"Verify Mail Queue", "Secure - Request Revision"}, alwaysRun=true)
	public void attachAppraisalOptionChecked() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		String password = StoredVariables.getpassword().get();
		
		/**************************************************************************
		 * Get EntityID's and Group ID's for SQL queries
		 **************************************************************************/
		env = StoredVariables.getusernameEnvironment().get();
		// Set the variables
		if (env.equals("QA"))
		{
			originatorEntityID = "1071304";
			xSiteEntityID = "1071302";
		} // end if QA
		if (env.equals("Beta"))
		{
			originatorEntityID = "5572705";
			xSiteEntityID = "5572691";
		} // end if Beta
		if (env.equals("Live"))
		{
			originatorEntityID = "5572706";
			xSiteEntityID = "5572693";
		} // end if Live
		
		// Set the server address per the environment
		if (env.equals("QA"))
		{
			server = "\\\\ss1qa.internal.ad.mercuryvmp.com\\Shared Storage\\MercuryEmailTemplates\\QA\\";
		} // end if QA
		else
		{
			server = "\\\\ss1.internal.ad.mercuryvmp.com\\Shared Storage\\MercuryEmailTemplates\\Production\\";
		} // end if Live
		
		// Login to Secure
		secure.login(driver, userSecure, password);
		
		// Click Preferences > Vendor Selection Settings
		secure.goToVendorSelectionSettings(driver);
		
		// Disable Unattended Order Assignment
		if(!SVendorSelectionSettings.unattendedOrderAssignment_switch(driver).getAttribute("src").contains("Off.png"))
		{
			perform.click(driver,SVendorSelectionSettings.unattendedOrderAssignment_switch(driver));
		} // end if
		
		// Disable Unattended Order Reassignment
		if(SVendorSelectionSettings.unattendedOrderReassignment_switch(driver).getAttribute("src").contains("On.png"))
		{
			perform.click(driver,SVendorSelectionSettings.unattendedOrderReassignment_switch(driver));
		} // end if
		
		// Select Custom fee panel radio button
		perform.click(driver,SVendorSelectionSettings.customFeePanel_radio(driver));
		
		// Uncheck Use Mercury Network directory as backup
		perform.uncheckCheckbox(driver, SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver));
		
		Thread.sleep(1500);
		
		// Save
		secure.saveVendorSelectionSettings(driver);
		
		// Click Preferences > VMP XSites
		secure.goToVMPXSites(driver);
		
		// Click Configure Automatic Settings
		perform.click(driver,SVMPXSites.configureAutomaticSettings_lnk(driver));
		
		// Wait for Use QC folders checkbox
		perform.waitForElementToBeClickable(driver, SVMPXSites.useQCFolders_chckbx(), "id");
		
		// Check Use QC Folders checkbox
		perform.checkCheckbox(driver, SVMPXSites.useQCFolders_chckbx(driver));
		
		// Save
		secure.saveVMPXSiteSettings(driver);
		
		// Click Configure Status Mapping
		perform.click(driver,SVMPXSites.configureStatusMapping_lnk(driver));
		
		// Wait for Appraiser button
		perform.waitForElementToBeClickable(driver, SVMPXSites.appraiser_btn(), "cssSelector");
		
		// Check the Pending Quality Review sync arrow
		secure.setStatusMapping(driver, "Pending Quality Review", "both");
		
		// Click Pending Quality Review gear icon
		perform.click(driver,SVMPXSites.pendingQualityReviewGearIcon_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for checkbox
		perform.waitForElementToBeClickable(driver, SVMPXSites.alwaysIncludeAppraisalReport_chckbx(), "id");
		
		// Uncheck Always include appraisal checkbox
		perform.uncheckCheckbox(driver, SVMPXSites.alwaysIncludeAppraisalReport_chckbx(driver));
		
		// Check Attach appraisal checkbox
		perform.checkCheckbox(driver, SVMPXSites.attachAppraisalReport_chckbx(driver));
		
		// Click OK
		perform.clickWithJavascript(driver, SVMPXSites.okSync_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Click Save
		perform.click(driver,SVMPXSites.save_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Click AMC/Firm button
		perform.click(driver,SVMPXSites.amcFirm_btn(driver));
		
		// Wait for gear icon
		perform.waitForElementToBeClickable(driver, SVMPXSites.pendingQualityReviewGearIconAMC_btn(), "id");
		
		// Scroll the gear icon into view
		perform.scrollElementIntoView(driver, SVMPXSites.pendingQualityReviewGearIconAMC_btn(driver));
		
		// Click gear icon
		perform.click(driver,SVMPXSites.pendingQualityReviewGearIconAMC_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Verify both checkboxes are there
		Assert.assertTrue(SVMPXSites.alwaysIncludeAppraisalReport_chckbx(driver).isDisplayed()==true, "Always include checkbox is missing");
		Assert.assertTrue(SVMPXSites.attachAppraisalReport_chckbx(driver).isDisplayed()==true, "Attach appraisal checkbox is missing");
		
		// Click OK
		perform.clickWithJavascript(driver, SVMPXSites.okSync_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// From VMP Client Portal, place an order
		// Login to VMP Client Portal
		vmp.login(driver, userSecure, userVMP, password);
		
		// Set variables for new order
		vmp.setMinimumVariables(driver);
		
		// Create VMP order and assign an appraiser
		createVMPOrderAndAssignItToAnAppraiser(driver);
		String trackingNumber = StoredVariables.gettrackingNumber().get();
		String trackingNumberVMP = StoredVariables.gettrackingNumberVMP().get();
		
		// Login to Vendors
		vendors.login(driver, userVendors, password);
		
		// Accept the order
		vendors.acceptOrder(driver, trackingNumber);
		
		// Complete order
		String loanID = StoredVariables.getloanID().get();
		vendors.completeOrderByHTTPPost(driver, userVendors, password, loanID, "Complete.xml");
		
		// Login to VMP
		vmp.login(driver, userSecure, userVMP, password);
		
		// Find the order
		vmp.findOrder(driver, trackingNumberVMP, "Tracking #");
		
		// Open the order
		vmp.openOrder(driver, trackingNumberVMP);
		
		// Verify Completed Report synced
		String docs = VMPOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(!docs.contains("Completed Report (Current)"), "The Completed Report did not sync to VMP");
		Assert.assertTrue(!docs.contains("Report PDF"), "The Report PDF did not sync to VMP");
		Assert.assertTrue(!docs.contains("MISMO XML"), "The MISMO XML did not sync to VMP");
		
		// Login to Secure
		secure.login(driver, userSecure, password);
		
		// Find the order
		secure.findOrder(driver, trackingNumber, "Tracking number");

		// Open the order
		secure.openOrder(driver, trackingNumber);
		
		// Verify Completed Report synced
		docs = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(docs.contains("Completed Report (Current)"), "The Completed Report did not sync to VMP");
		Assert.assertTrue(docs.contains("Report PDF"), "The Report PDF did not sync to VMP");
		Assert.assertTrue(docs.contains("MISMO XML"), "The MISMO XML did not sync to VMP");
		
		// Verify MailQueue row count for this productItemID
		perform.verifyTheNumberOfRowsInTheMailQueueDBResultsForProductItemID(driver, 4, vmpProductItemID);
		perform.verifyTheNumberOfRowsInTheMailQueueDBResultsForProductItemID(driver, 3, secureProductItemID);
		
		/***********************************************************************************************
		 * Verify the notifications in the database
		 ***********************************************************************************************/
		// Query the database and return the results as an array
		String sqlStatement = "SELECT TOP 1 * FROM [dbo].[MailQueue] WHERE ProductItemID = '"
				+ vmpProductItemID
				+ "' AND  ToEntityID = '"
				+ originatorEntityID
				+ "' ORDER BY EnteredStamp DESC";
		ArrayList<String> results = db
				.getMailQueueInfoBySQLToArray(driver, sqlStatement);

		// Set expected results
		String mailFromExpected = "XSite Order on behalf of automation"+env+"PQR1@dntest.net (MNDoNotReply@mercuryvmp.com)";
		String mailToExpected = "automation@dntest.net";
		String subjectExpected = "Order Status Update for Baseline Test";
		String templateUsedExpected = server + "XSiteStatusUpdate.html";
		String successfulExpected = "1";
		String fromEntityIDExpected = xSiteEntityID;
		String toEntityIDExpected = originatorEntityID;
		String attachmentsExpected = "Test PDF.pdf";

		// Set database values
		String mailFrom = results.get(4);
		String mailTo = results.get(5);
		String subject = results.get(8);
		String templateUsed = results.get(9);
		String sentDateTime = results.get(11);
		String successful = results.get(12);
		String fromEntityID = results.get(13);
		String toEntityID = results.get(14);
		String attachments = results.get(10);

		// Verify MailFrom
		Assert.assertTrue(mailFrom.equals(mailFromExpected),
				"The MailFrom entry in the database is incorrect. DB value = "
						+ mailFrom + " and shoudl be = " + mailFromExpected);

		// Verify MailTo
		Assert.assertTrue(mailTo.equals(mailToExpected),
				"The MailTo entry in the database is incorrect. DB value = "
						+ mailTo + " and shoudl be = " + mailToExpected);

		// Verify Subject
		Assert.assertTrue(subject.contains(subjectExpected),
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
		
		// Verify Attachments
		Assert.assertTrue(attachments.contains(attachmentsExpected),
				"The Attachmetns entry in the database is incorrect. DB value = "
						+ attachments + " and shoudl be = " + attachmentsExpected);

		// Verify order details
		secure.verifyResidentialAppraisalOrderDetails(driver);
		
		// Verify tool tip text
		String toolTip = SOrderDetails.toolTip_txt(driver).getAttribute("title");
		System.out.println("toolTip = " + toolTip);
		Assert.assertTrue(!toolTip.contains("Appraisal report included"), "The tool tip does not contain Appraisal report included");
		
		// Click the Request revision radio button
		perform.click(driver,SOrderDetails.requestRevision_radioBtn(driver));
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SOrderDetails.okProcessReceivedReport_btn(), "id");
		
		Thread.sleep(4000);
		
		// Click OK
		perform.click(driver,SOrderDetails.okProcessReceivedReport_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Login to Vendors
		vendors.login(driver, userVendors, password);
		
		// Complete order
		loanID = StoredVariables.getloanID().get();
		vendors.completeOrderByHTTPPost(driver, userVendors, password, loanID, "Complete.xml");
		
		// Login to VMP
		vmp.login(driver, userSecure, userVMP, password);
		
		// Find the order
		vmp.findOrder(driver, trackingNumberVMP, "Tracking #");
		
		// Open the order
		vmp.openOrder(driver, trackingNumberVMP);
		
		// Verify Completed Report synced
		docs = VMPOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(!docs.contains("Completed Report (Current)"), "The Completed Report did not sync to VMP");
		Assert.assertTrue(!docs.contains("Report PDF"), "The Report PDF did not sync to VMP");
		Assert.assertTrue(!docs.contains("Previously Completed Reports"), "The MISMO XML did not sync to VMP");
		
		// Login to Secure
		secure.login(driver, userSecure, password);
		
		// Find the order
		secure.findOrder(driver, trackingNumber, "Tracking number");

		// Open the order
		secure.openOrder(driver, trackingNumber);
		
		// Verify Completed Report synced
		docs = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(docs.contains("Completed Report (Current)"), "The Completed Report did not sync to VMP");
		Assert.assertTrue(docs.contains("Report PDF"), "The Report PDF did not sync to VMP");
		Assert.assertTrue(docs.contains("Previously Completed Reports"), "The MISMO XML did not sync to VMP");
		
		// Log test
		test.log(LogStatus.INFO, "Status Mapping Regression Test", "Verified Pending Quality Review syncing is working properly and does not show the Completed Report on the 1st order");
		
	} // end attachAppraisalOptionChecked
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the variables</li>
	 * 	<li>clientGroupID = "";</li>
	 * 	<li>clientGroupID = "";</li>
	 * 	<li>clientGroupID = "";</li>
	 * 	<li>Set the server address per the environment</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Click Preferences &gt; Vendor Selection Settings</li>
	 * 	<li>Disable Unattended Order Assignment</li>
	 * 	<li>Disable Unattended Order Reassignment</li>
	 * 	<li>Select Custom fee panel radio button</li>
	 * 	<li>Uncheck Use Mercury Network directory as backup</li>
	 * 	<li>Save</li>
	 * 	<li>Click Preferences &gt; VMP XSites</li>
	 * 	<li>Click Configure Automatic Settings</li>
	 * 	<li>Check Use QC Folders checkbox</li>
	 * 	<li>Save</li>
	 * 	<li>Click Configure Status Mapping</li>
	 * 	<li>Check the Pending Quality Review sync arrow</li>
	 * 	<li>Click Pending Quality Review gear icon</li>
	 * 	<li>Uncheck Always include appraisal checkbox</li>
	 * 	<li>Uncheck Attach appraisal checkbox</li>
	 * 	<li>Click OK</li>
	 * 	<li>Click Save</li>
	 * 	<li>Click AMC/Firm button</li>
	 * 	<li>Scroll the gear icon into view</li>
	 * 	<li>Click gear icon</li>
	 * 	<li>Verify both checkboxes are there</li>
	 * 	<li>Click OK</li>
	 * 	<li>From VMP Client Portal, place an order</li>
	 * 	<li>Login to VMP Client Portal</li>
	 * 	<li>Set variables for new order</li>
	 * 	<li>Create VMP order and assign an appraiser</li>
	 * 	<li>Login to Vendors</li>
	 * 	<li>Complete order</li>
	 * 	<li>Login to VMP</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Verify Completed Report synced</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Verify Completed Report synced</li>
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
	 * 	<li>Verify Attachments</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Verify tool tip text</li>
	 * 	<li>Click the Request revision radio button</li>
	 * 	<li>Click OK</li>
	 * 	<li>Login to Vendors</li>
	 * 	<li>Complete order</li>
	 * 	<li>Login to VMP</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Verify Completed Report synced</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Verify Completed Report synced</li>
	 * 	<li>Log test</li>
	 * 	<li>Place a new order, make sure to attach documents to the order BEFORE finishing it</li>
	 * 	<li>Set variables</li>
	 * 	<li>Go to New Order</li>
	 * 	<li>Enter order details</li>
	 * 	<li>Click Next</li>
	 * 	<li>Save the order</li>
	 * 	<li>Click Finished</li>
	 * 	<li>Click OK</li>
	 * 	<li>Get order numbers</li>
	 * 	<li>Get Product Item ID</li>
	 * 	<li>Get tracking numbers</li>
	 * 	<li>Log into Secure as the Lender</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Click Assign</li>
	 * 	<li>Also update the due date on the VMP XSite order checkbox</li>
	 * 	<li>OK button</li>
	 * 	<li>Assign the vendor</li>
	 * 	<li>Click Finish</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Status Mapping", "Secure - Vendor Selection Settings", "Secure - VMP XSite Settings", "Secure - Configure Status Mapping", "VMP - Create Order", "Vendors - Complete Order", "VMP - Orders", "Secure - Orders",
			"Verify Mail Queue", "Secure - Request Revision"}, alwaysRun=true)
	public void neitherOptionChecked() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		String password = StoredVariables.getpassword().get();
		
		/**************************************************************************
		 * Get EntityID's and Group ID's for SQL queries
		 **************************************************************************/
		env = StoredVariables.getusernameEnvironment().get();
		// Set the variables
		if (env.equals("QA"))
		{
			originatorEntityID = "1071304";
			xSiteEntityID = "1071302";
		} // end if QA
		if (env.equals("Beta"))
		{
			originatorEntityID = "5572705";
			xSiteEntityID = "5572691";
		} // end if Beta
		if (env.equals("Live"))
		{
			originatorEntityID = "5572706";
			xSiteEntityID = "5572693";
		} // end if Live
		
		// Set the server address per the environment
		if (env.equals("QA"))
		{
			server = "\\\\ss1qa.internal.ad.mercuryvmp.com\\Shared Storage\\MercuryEmailTemplates\\QA\\";
		} // end if QA
		else
		{
			server = "\\\\ss1.internal.ad.mercuryvmp.com\\Shared Storage\\MercuryEmailTemplates\\Production\\";
		} // end if Live
		
		// Login to Secure
		secure.login(driver, userSecure, password);
		
		// Click Preferences > Vendor Selection Settings
		secure.goToVendorSelectionSettings(driver);
		
		// Disable Unattended Order Assignment
		if(!SVendorSelectionSettings.unattendedOrderAssignment_switch(driver).getAttribute("src").contains("Off.png"))
		{
			perform.click(driver,SVendorSelectionSettings.unattendedOrderAssignment_switch(driver));
		} // end if
		
		// Disable Unattended Order Reassignment
		if(SVendorSelectionSettings.unattendedOrderReassignment_switch(driver).getAttribute("src").contains("On.png"))
		{
			perform.click(driver,SVendorSelectionSettings.unattendedOrderReassignment_switch(driver));
		} // end if
		
		// Select Custom fee panel radio button
		perform.click(driver,SVendorSelectionSettings.customFeePanel_radio(driver));
		
		// Uncheck Use Mercury Network directory as backup
		perform.uncheckCheckbox(driver, SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver));
		
		Thread.sleep(1500);
		
		// Save
		secure.saveVendorSelectionSettings(driver);
		
		// Click Preferences > VMP XSites
		secure.goToVMPXSites(driver);
		
		// Click Configure Automatic Settings
		perform.click(driver,SVMPXSites.configureAutomaticSettings_lnk(driver));
		
		// Wait for Use QC folders checkbox
		perform.waitForElementToBeClickable(driver, SVMPXSites.useQCFolders_chckbx(), "id");
		
		// Check Use QC Folders checkbox
		perform.checkCheckbox(driver, SVMPXSites.useQCFolders_chckbx(driver));
		
		// Save
		secure.saveVMPXSiteSettings(driver);
		
		// Click Configure Status Mapping
		perform.click(driver,SVMPXSites.configureStatusMapping_lnk(driver));
		
		// Wait for Appraiser button
		perform.waitForElementToBeClickable(driver, SVMPXSites.appraiser_btn(), "cssSelector");
		
		// Check the Pending Quality Review sync arrow
		secure.setStatusMapping(driver, "Pending Quality Review", "both");
		
		// Click Pending Quality Review gear icon
		perform.click(driver,SVMPXSites.pendingQualityReviewGearIcon_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for checkbox
		perform.waitForElementToBeClickable(driver, SVMPXSites.alwaysIncludeAppraisalReport_chckbx(), "id");
		
		// Uncheck Always include appraisal checkbox
		perform.uncheckCheckbox(driver, SVMPXSites.alwaysIncludeAppraisalReport_chckbx(driver));
		
		// Uncheck Attach appraisal checkbox
		perform.uncheckCheckbox(driver, SVMPXSites.attachAppraisalReport_chckbx(driver));
		
		// Click OK
		perform.clickWithJavascript(driver, SVMPXSites.okSync_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Click Save
		perform.click(driver,SVMPXSites.save_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Click AMC/Firm button
		perform.click(driver,SVMPXSites.amcFirm_btn(driver));
		
		// Wait for gear icon
		perform.waitForElementToBeClickable(driver, SVMPXSites.pendingQualityReviewGearIconAMC_btn(), "id");
		
		// Scroll the gear icon into view
		perform.scrollElementIntoView(driver, SVMPXSites.pendingQualityReviewGearIconAMC_btn(driver));
		
		// Click gear icon
		perform.click(driver,SVMPXSites.pendingQualityReviewGearIconAMC_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Verify both checkboxes are there
		Assert.assertTrue(SVMPXSites.alwaysIncludeAppraisalReport_chckbx(driver).isDisplayed()==true, "Always include checkbox is missing");
		Assert.assertTrue(SVMPXSites.attachAppraisalReport_chckbx(driver).isDisplayed()==true, "Attach appraisal checkbox is missing");
		
		// Click OK
		perform.clickWithJavascript(driver, SVMPXSites.okSync_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// From VMP Client Portal, place an order
		// Login to VMP Client Portal
		vmp.login(driver, userSecure, userVMP, password);
		
		// Set variables for new order
		vmp.setMinimumVariables(driver);
		
		// Create VMP order and assign an appraiser
		createVMPOrderAndAssignItToAnAppraiser(driver);
		String trackingNumber = StoredVariables.gettrackingNumber().get();
		String trackingNumberVMP = StoredVariables.gettrackingNumberVMP().get();
		
		// Login to Vendors
		vendors.login(driver, userVendors, password);
		
		// Accept the order
		vendors.acceptOrder(driver, trackingNumber);
		
		// Complete order
		String loanID = StoredVariables.getloanID().get();
		vendors.completeOrderByHTTPPost(driver, userVendors, password, loanID, "Complete.xml");
		
		// Login to VMP
		vmp.login(driver, userSecure, userVMP, password);
		
		// Find the order
		vmp.findOrder(driver, trackingNumberVMP, "Tracking #");
		
		// Open the order
		vmp.openOrder(driver, trackingNumberVMP);
		
		// Verify Completed Report synced
		String docs = VMPOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(!docs.contains("Completed Report (Current)"), "The Completed Report did not sync to VMP");
		Assert.assertTrue(!docs.contains("Report PDF"), "The Report PDF did not sync to VMP");
		Assert.assertTrue(!docs.contains("MISMO XML"), "The MISMO XML did not sync to VMP");
		
		// Login to Secure
		secure.login(driver, userSecure, password);
		
		// Find the order
		secure.findOrder(driver, trackingNumber, "Tracking number");

		// Open the order
		secure.openOrder(driver, trackingNumber);
		
		// Verify Completed Report synced
		docs = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(docs.contains("Completed Report (Current)"), "The Completed Report did not sync to VMP");
		Assert.assertTrue(docs.contains("Report PDF"), "The Report PDF did not sync to VMP");
		Assert.assertTrue(docs.contains("MISMO XML"), "The MISMO XML did not sync to VMP");
		
		// Verify MailQueue row count for this productItemID
//		perform.verifyTheNumberOfRowsInTheMailQueueDBResultsForProductItemID(driver, 5, vmpProductItemID);
//		perform.verifyTheNumberOfRowsInTheMailQueueDBResultsForProductItemID(driver, 2, secureProductItemID);
		
		/***********************************************************************************************
		 * Verify the notifications in the database
		 ***********************************************************************************************/
		// Query the database and return the results as an array
		String sqlStatement = "SELECT TOP 1 * FROM [dbo].[MailQueue] WHERE ProductItemID = '"
				+ vmpProductItemID
				+ "' AND  ToEntityID = '"
				+ originatorEntityID
				+ "' ORDER BY EnteredStamp DESC";
		ArrayList<String> results = db
				.getMailQueueInfoBySQLToArray(driver, sqlStatement);

		// Set expected results
		String mailFromExpected = "XSite Order on behalf of automation"+env+"PQR1@dntest.net (MNDoNotReply@mercuryvmp.com)";
		String mailToExpected = "automation@dntest.net";
		String subjectExpected = "Order Status Update for Baseline Test";
		String templateUsedExpected = server + "XSiteStatusUpdate.html";
		String successfulExpected = "1";
		String fromEntityIDExpected = xSiteEntityID;
		String toEntityIDExpected = originatorEntityID;
		String attachmentsExpected = "NULL";

		// Set database values
		String mailFrom = results.get(4);
		String mailTo = results.get(5);
		String subject = results.get(8);
		String templateUsed = results.get(9);
		String sentDateTime = results.get(11);
		String successful = results.get(12);
		String fromEntityID = results.get(13);
		String toEntityID = results.get(14);
		String attachments = results.get(10);

		// Verify MailFrom
		Assert.assertTrue(mailFrom.equals(mailFromExpected),
				"The MailFrom entry in the database is incorrect. DB value = "
						+ mailFrom + " and shoudl be = " + mailFromExpected);

		// Verify MailTo
		Assert.assertTrue(mailTo.equals(mailToExpected),
				"The MailTo entry in the database is incorrect. DB value = "
						+ mailTo + " and shoudl be = " + mailToExpected);

		// Verify Subject
		Assert.assertTrue(subject.contains(subjectExpected),
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
		
		// Verify Attachments
		Assert.assertTrue(attachments.equals(attachmentsExpected),
				"The Attachmetns entry in the database is incorrect. DB value = "
						+ attachments + " and shoudl be = " + attachmentsExpected);

		// Verify order details
		secure.verifyResidentialAppraisalOrderDetails(driver);
		
		// Verify tool tip text
		String toolTip = SOrderDetails.toolTip_txt(driver).getAttribute("title");
		System.out.println("toolTip = " + toolTip);
		Assert.assertTrue(!toolTip.contains("Appraisal report included"), "The tool tip does not contain Appraisal report included");
		
		// Click the Request revision radio button
		perform.click(driver,SOrderDetails.requestRevision_radioBtn(driver));
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SOrderDetails.okProcessReceivedReport_btn(), "id");
		
		Thread.sleep(4000);
		
		// Click OK
		perform.click(driver,SOrderDetails.okProcessReceivedReport_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Login to Vendors
		vendors.login(driver, userVendors, password);
		
		// Complete order
		loanID = StoredVariables.getloanID().get();
		vendors.completeOrderByHTTPPost(driver, userVendors, password, loanID, "Complete.xml");
		
		// Login to VMP
		vmp.login(driver, userSecure, userVMP, password);
		
		// Find the order
		vmp.findOrder(driver, trackingNumberVMP, "Tracking #");
		
		// Open the order
		vmp.openOrder(driver, trackingNumberVMP);
		
		// Verify Completed Report synced
		docs = VMPOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(!docs.contains("Completed Report (Current)"), "The Completed Report did not sync to VMP");
		Assert.assertTrue(!docs.contains("Report PDF"), "The Report PDF did not sync to VMP");
		Assert.assertTrue(!docs.contains("Previously Completed Reports"), "The MISMO XML did not sync to VMP");
		
		// Login to Secure
		secure.login(driver, userSecure, password);
		
		// Find the order
		secure.findOrder(driver, trackingNumber, "Tracking number");

		// Open the order
		secure.openOrder(driver, trackingNumber);
		
		// Verify Completed Report synced
		docs = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(docs.contains("Completed Report (Current)"), "The Completed Report did not sync to VMP");
		Assert.assertTrue(docs.contains("Report PDF"), "The Report PDF did not sync to VMP");
		Assert.assertTrue(docs.contains("Previously Completed Reports"), "The MISMO XML did not sync to VMP");
		
		// Log test
		test.log(LogStatus.INFO, "Status Mapping Regression Test", "Verified Pending Quality Review syncing is working properly and does not show the Completed Report on the 1st order");
		
	} // end neitherOptionChecked
	
	/**
	 * Creates the VMP order and assign it to an appraiser.
	 *
	 * @param driver the driver
	 * @throws Exception the exception
	 */
	private void createVMPOrderAndAssignItToAnAppraiser(RemoteWebDriver driver) throws Exception {
		
		// Place a new order, make sure to attach documents to the order BEFORE finishing it
		// Set variables
		vmp.setVariables(driver);
		StoredVariables.getadditionalNotificationRecipientsAdditionalEmails().set("additionalEmail@dntest.net");
		StoredVariables.getassignmentInformationOrderDue().set(0);
		
		// Go to New Order
		vmp.goToNewOrder(driver);
		
		// Enter order details
		vmp.enterNewOrder(driver);
		
		// Click Next
		perform.click(driver,VMPNewOrder.nextBottom_btn(driver));
		
		// Confirm Address Mismatch
		try {
			perform.click(driver, VMPNewOrder.ok_btn(driver));
		} catch (Exception e) {
			// Address was correct and did not need to be confirmed
		} // end try/catch
		
		// Save the order
		vmp.saveNewOrder(driver);
		
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
		
		// Get Product Item ID
		vmpProductItemID = db.getProductItemID(driver, StoredVariables.getloanIDVMP().get());
		secureProductItemID = db.getProductItemID(driver, StoredVariables.getloanID().get());
		
		// Get tracking numbers
		String trackingNumber = StoredVariables.gettrackingNumber().get();
		
		// Log into Secure as the Lender
		String password = StoredVariables.getpassword().get();
		secure.login(driver, userSecure, password);
		
		// Find the order
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Open the order
		secure.openOrder(driver, trackingNumber);
		
		// Click Assign
		perform.click(driver,SOrderDetails.assign_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		perform.waitForElementToBeClickable(driver, SOrderDetails.updateVMPXSite_chkbx(), "id");
		
		// Also update the due date on the VMP XSite order checkbox
		perform.checkCheckbox(driver, SOrderDetails.updateVMPXSite_chkbx(driver));
		
		// OK button
		perform.click(driver, SOrderDetails.okDueDate_btn(driver));
		
		// Assign the vendor
		secure.selectVendor(driver, userVendors);
		
		// Click Finish
		perform.click(driver,SOrderDetails.finish_btn(driver));
		
		// Wait for attach button
		perform.waitForElementToBeClickable(driver, SOrderDetails.viewXSiteOrder_lnk(), "id");
		
	} // end createVMPOrderAndAssignItToAnAppraiser
	
} // end the PendingQualityReviewSyncing class
