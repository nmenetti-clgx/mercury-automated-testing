package components;

import java.util.List;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Secure.SAppraisalQualityManagementSettings;
import pageObjects.Secure.SClientGroups_AQM;
import pageObjects.Secure.SClients_ClientGroups;
import pageObjects.Secure.SOrderDetails;
import setup.DriverFactory;
import setup.TestSetup;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>AR172</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-01-2019
 */

@Listeners(utils.Listener.class)
public class AR172_AutoImportRealViewPDF extends TestSetup {
	
	/** The Vendors user. */
	private final String userVendors = "RegressionVendors4";

	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li></li>
	 * </ul>
	 * @throws Exception 
	 */
	@Test (retryAnalyzer = Retry.class, groups={"AR172"}, alwaysRun=true)
	public void ar172_1_GlobalSettings() throws Exception {

		// Create the driver
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Set the VMP user
		String userVMP = "OriginatorAQM1";
		
		// Set the Secure user
		String userSecure = "AQM1";
		
		// Set the password
		String password = StoredVariables.getpassword().get();

		// Login to Secure
		secure.login(driver, userSecure, password);
		
		// Go to AQM Settings
		secure.goToAppraisalQualityManagementSettings(driver);
		
		// Confirm there is an option to automatically download the RealView Report PDF
		perform.verification(driver, SAppraisalQualityManagementSettings.automaticallyDownloadTheRealViewReportPDFWhenResultsAreReturned_checkbox(driver).isDisplayed(),
				"equals", true);
		
		// Confirm text states Automatically download the RealView® Report PDF when results are returned
		perform.verification(driver, SAppraisalQualityManagementSettings.automaticallyDownloadTheRealViewReportPDFWhenResultsAreReturned_txt(driver).getText(),
				"equals", "Automatically download the RealView® Report PDF when results are returned.");
		
		// Confirm item can be checked and unchecked even if RealVIew is not set to be a default module
		perform.checkCheckbox(driver, SAppraisalQualityManagementSettings.automaticallyDownloadTheRealViewReportPDFWhenResultsAreReturned_checkbox(driver));
		perform.uncheckCheckbox(driver, SAppraisalQualityManagementSettings.automaticallyDownloadTheRealViewReportPDFWhenResultsAreReturned_checkbox(driver));
		
		// Check the option
		perform.checkCheckbox(driver, SAppraisalQualityManagementSettings.automaticallyDownloadTheRealViewReportPDFWhenResultsAreReturned_checkbox(driver));
		
		// Click Save
		secure.saveAppraisalQualityManagementSettings(driver);
		
		// Log in to vmpclient.com
		vmp.login(driver, userSecure, userVMP, password);
		
		// Place an order and assign it to the lender
		vmp.setMinimumVariables(driver);
		vmp.createVMPOrder(driver);
		
		// Get the loanID
		List<String> loanIDs = db.getLoanIDsFromVMPClientPortalOrder(driver);
		String secureLoanID = loanIDs.get(1);
		
		// Log in to Secure and assign the order to an appraiser
		secure.loginAndAssignOrderToAppraiser(driver, userSecure, password, secureLoanID, userVendors);
		
		// Log in to Vendors
		vendors.loginAndAcceptOrder(driver, userVendors, password, secureLoanID);
		
		// Complete the order
		vendors.completeOrderByHTTPPost(driver, userVendors, password, secureLoanID, "Complete.xml");
		
		// Log in to secure.mercuryvmp.com
		secure.loginAndOpenOrderByTrackingNumber(driver, userSecure, password, secureLoanID);
		
		// Start AQM
		secure.startAQM(driver, "RealView");
		
		// Wait for the RealView results to return
		secure.waitForHistoryTextToUpdate(driver, "Results returned from RealView");
		
		// When results return, confirm the RealView PDF is automatically attached to the MN order
		secure.verifyCorrectDocumentsAttached(driver, "RealView® Report");
		
		// Complete the order
		perform.click(driver, SOrderDetails.okProcessReceivedReport_btn(driver));
		
		// Wait for busy
		perform.waitForBusyToBeHidden(driver);
		
		// Open the order
		secure.openOrder(driver, secureLoanID);
		
		// Open the XSite order
		secure.openXSiteOrder(driver);
		
		// Confirm when the document syncing is enabled (Pref > VMP XSites > Configure Status Mapping) the PDF is automatically attached and synced to the XSite order
		perform.verification(driver, secure.verifyCorrectDocumentsAttachedOnXSiteOrder(driver, "Completed Report"), "equals", true);
		perform.verification(driver, secure.verifyCorrectDocumentsAttachedOnXSiteOrder(driver, "MISMO XML"), "equals", true);
		
		// Wait for the RealView Report to be displayed
		secure.waitForDocumentsAttachedOnXSiteOrder(driver, "RealView® Report");
		perform.verification(driver, secure.verifyCorrectDocumentsAttachedOnXSiteOrder(driver, "RealView® Report"), "equals", true);
		
		// Log test
		perform.addInfoToExtentReport(driver, "AQM", "Verified AQM Global Settings");

	} // end ar172_1_GlobalSettings
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li></li>
	 * </ul>
	 * @throws Exception 
	 */
	@Test (retryAnalyzer = Retry.class, groups={"AR172"}, alwaysRun=true)
	public void ar172_2_ClientSettings() throws Exception {

		// Create the driver
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Set the VMP user
		String userVMP = "OriginatorAQM2";
		
		// Set the Secure user
		String userSecure = "AQM2";

		// Set the password
		String password = StoredVariables.getpassword().get();
		
		// Go to login page
		secure.login(driver, userSecure, password);

		// Go to Clients > Client Groups > Manage Client Groups
		secure.goToManageClientGroups(driver);
		
		// Edit a client group
		perform.clickInTable_Contains(driver, "Test Client Group");
		perform.clickInTable_Contains(driver, "Edit Group");
		
		// Click the AQM tab
		perform.switchToiFrameByID(driver, "frameDialogL1");
		perform.click(driver, SClients_ClientGroups.aqm_btn(driver));
		
		// Confirm there is an option to automatically download the RealView Report PDF
		perform.verification(driver, SClientGroups_AQM.automaticallyDownloadTheRealViewReport_chkbx(driver).isDisplayed(), 
				"equals", true);

		// Confirm text states Automatically download the RealView® Report PDF when results are returned
		perform.verification(driver, SClientGroups_AQM.automaticallyDownloadTheRealViewReport_txt(driver).getText(), 
				"equals", "Automatically download the RealView® Report PDF when results are returned.");

		// Confirm item can be checked and unchecked
		perform.checkCheckbox(driver, SClientGroups_AQM.automaticallyDownloadTheRealViewReport_chkbx(driver));
		perform.uncheckCheckbox(driver, SClientGroups_AQM.automaticallyDownloadTheRealViewReport_chkbx(driver));
		
		// Make sure you have an email recipient listed
		perform.verification(driver, SClientGroups_AQM.additionalAQIRecipients_txtbx(driver).getAttribute("value"), 
				"contains", "AQM2");
		
		// Check option (global set to off)
		perform.checkCheckbox(driver, SClientGroups_AQM.automaticallyDownloadTheRealViewReport_chkbx(driver));
		
		// Click Save
		secure.saveClientGroupSettings(driver);
		
		// Log in to vmpclient.com
		vmp.login(driver, userSecure, userVMP, password);
		
		// Place an order and assign it to the lender
		vmp.setMinimumVariables(driver);
		vmp.createVMPOrder(driver);
		
		// Get the loanID
		List<String> loanIDs = db.getLoanIDsFromVMPClientPortalOrder(driver);
		String secureLoanID = loanIDs.get(1);
		
		// Get the product item id
		String pid = db.getProductItemID(driver, secureLoanID);
		
		// Log in to Secure and assign the order to an appraiser
		secure.loginAndAssignOrderToAppraiser(driver, userSecure, password, secureLoanID, userVendors);
		
		// Log in to Vendors
		vendors.loginAndAcceptOrder(driver, userVendors, password, secureLoanID);
		
		// Complete the order
		vendors.completeOrderByHTTPPost(driver, userVendors, password, secureLoanID, "Complete.xml");
		
		// Log in to secure.mercuryvmp.com
		secure.loginAndOpenOrderByTrackingNumber(driver, userSecure, password, secureLoanID);
		
		// Start AQM
		secure.startAQM(driver, "RealView");
		
		// Wait for the RealView results to return
		secure.waitForHistoryTextToUpdate(driver, "Results returned from RealView");
		
		// When results return, confirm the RealView PDF is automatically attached to the MN order
		secure.verifyCorrectDocumentsAttached(driver, "RealView® Report");
		
		// Complete the order
		perform.click(driver, SOrderDetails.okProcessReceivedReport_btn(driver));
		
		// Wait for busy
		perform.waitForBusyToBeHidden(driver);
		
		// Open the order
		secure.openOrder(driver, secureLoanID);
		
		// Open the XSite order
		secure.openXSiteOrder(driver);
		
		// Confirm when the document syncing is enabled (Pref > VMP XSites > Configure Status Mapping) the PDF is automatically attached and synced to the XSite order
		perform.verification(driver, secure.verifyCorrectDocumentsAttachedOnXSiteOrder(driver, "Completed Report"), "equals", true);
		perform.verification(driver, secure.verifyCorrectDocumentsAttachedOnXSiteOrder(driver, "MISMO XML"), "equals", true);
		
		// Wait for the RealView Report to be displayed
		secure.waitForDocumentsAttachedOnXSiteOrder(driver, "RealView® Report");
		perform.verification(driver, secure.verifyCorrectDocumentsAttachedOnXSiteOrder(driver, "RealView® Report"), "equals", true);
		
		/** Confirm the RealView PDF is sent to the recipient in the Client Group > AQM tab **/
		// Go to Notification Search and search for the order
		it.goToNotificationSearchAndSearchByProductItemID(driver, pid);
		
		// Find the record for the RealView PDF
		int row = it.getRowOfNotificationSearchResults(driver, "Subject", "New Document Attached to Order - Type: RealView® Report");
		String emailTo = it.verifyColumnTextInNotificationSearchResultsByRow(driver, "To", row);
		perform.verification(driver, emailTo, "contains", "AQM2@dntest.net");
		
		// Log test
		perform.addInfoToExtentReport(driver, "AQM", "Verified AQM Client Settings");

	} // end ar172_2_ClientSettings
	
} // end the Secure_Login class
