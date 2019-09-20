package regressionVMP;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjects.Secure.SVMPXSites;
import pageObjects.VMP.VMPAppraisalOrderDetails;
import pageObjects.VMP.VMPConfirmOrder;
import pageObjects.VMP.VMPNewOrder;
import pageObjects.VMP.VMPOrders;
import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

/**
 * <h1>VMP - Require Sales Contract</h1>
 * 
 * <p>Verify uploading a Sales Contract is required if you check Require Sales Contract and that the document syncs correctly 
 *
 * @author  Dustin Norman
 * @since   03-12-2019
 */

@Listeners(utils.Listener.class)
public class RequireSalesContract extends TestSetup {
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Click Preference &gt; VMP XSites</li>
	 * 	<li>Click Configure Order Form</li>
	 * 	<li>Check Require sales contract</li>
	 * 	<li>Save</li>
	 * 	<li>Click on Configure Status Mapping</li>
	 * 	<li>Enable all sync status options</li>
	 * 	<li>Click the Client Document Upload gear icon</li>
	 * 	<li>Check every option for syncing</li>
	 * 	<li>Click OK</li>
	 * 	<li>Click Save</li>
	 * 	<li>Go to the VMP Client portal and sign in</li>
	 * 	<li>Go to New Order</li>
	 * 	<li>Enter New Order data</li>
	 * 	<li>Click Next</li>
	 * 	<li>Confirm order screen loads</li>
	 * 	<li>Get page text</li>
	 * 	<li>Confirm there is not a spot to upload a sales contract or a required documents selection</li>
	 * 	<li>Click Back</li>
	 * 	<li>Set Loan Purpose variable to Purchase</li>
	 * 	<li>Select Loan Purpose</li>
	 * 	<li>Click Next</li>
	 * 	<li>Confirm order screen loads</li>
	 * 	<li>Confirm there is a spot to upload a sales contract or a required documents selection</li>
	 * 	<li>Confirm you can Upload sales contract</li>
	 * 	<li>Confirm once attached the hyperlink displays the filename</li>
	 * 	<li>Delete the file</li>
	 * 	<li>Confirm deleting the file returns to Upload sales contract</li>
	 * 	<li>Set 40 second while loop timeout</li>
	 * 	<li>Click Next</li>
	 * 	<li>Confirm you cannot finish the order without having a sales contract uploaded</li>
	 * 	<li>Verify dialog text</li>
	 * 	<li>Click OK</li>
	 * 	<li>Upload sales contract</li>
	 * 	<li>Confirm once attached the hyperlink displays the filename</li>
	 * 	<li>Click Next</li>
	 * 	<li>Wait until saving dialog is gone</li>
	 * 	<li>Get inside the attach document frame</li>
	 * 	<li>Select document type</li>
	 * 	<li>Click Close Button</li>
	 * 	<li>Switch back to the attach documents frame</li>
	 * 	<li>Click the OK button in the Order Placed dialog</li>
	 * 	<li>Verify you land on the orders grid</li>
	 * 	<li>Query the db to get the order number that was just created</li>
	 * 	<li>View the order details in VMP Client Portal</li>
	 * 	<li>Confirm the Sales Contract displays in Order Documents and can be viewed</li>
	 * 	<li>Verify the order details</li>
	 * 	<li>Verify Document is in Documents</li>
	 * 	<li>Click on Sales Contract</li>
	 * 	<li>Verify file name and uploaded by</li>
	 * 	<li>View the Secure Mercury Network order</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Confirm the document is there</li>
	 * 	<li>Log test</li>
	 * </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - VMP XSite Settings", "Secure - Configure Status Mapping", "VMP - Create Order", "VMP - Require Sales Contract", "Secure - Orders", "VMP - Orders"}, alwaysRun=true)
	public void requireSalesContract() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Login to Secure
		secure.login(driver, "RegressionSecure10", StoredVariables.getpassword().get());
		
		// Click Preference > VMP XSites
		secure.goToVMPXSites(driver);
		
		// Click Configure Order Form
		perform.click(driver,SVMPXSites.configureOrderForm_lnk(driver));
		
		// Check Require sales contract 
		perform.checkCheckbox(driver, SVMPXSites.requireSalesContract_chkbx(driver));
		
		// Save
		secure.saveVMPXSiteSettings(driver);
		
		// Click on Configure Status Mapping
		perform.click(driver,SVMPXSites.configureStatusMapping_lnk(driver));
		
		// Enable all sync status options
		perform.enableAllOptionsInStatusMappingConfiguration(driver);
		
		// Click the Client Document Upload gear icon
		perform.click(driver,SVMPXSites.documentUploadedAppraiserClientGearIcon_btn(driver));
		
		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		// Check every option for syncing
		perform.enableAllCheckboxesToSyncToVMP(driver);
		
		// Click OK
		perform.click(driver,SVMPXSites.okSyncToVMPCheckboxesClient_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Click Save
		perform.click(driver,SVMPXSites.save_btn(driver));
		
		// Go to the VMP Client portal and sign in
		vmp.login(driver, "RegressionSecure10", "OriginatorRegressionSecure10", StoredVariables.getpassword().get());
		
		// Go to New Order
		vmp.goToNewOrder(driver);
		
		/***************************************
		 * Set New Order Information
		 ***************************************/
		perform.clearOrderInfoStoredVariables(driver);
		secure.setNewResidentialAppraisalOrderVariablesMinimum(driver);
		StoredVariables.getassignmentInformationForm().set("1004 Full/URAR");
		
		// Enter New Order data
		vmp.enterNewOrder(driver);
		
		// Click Next
		perform.click(driver,VMPNewOrder.nextBottom_btn(driver));
		
		Thread.sleep(1000);
		
		/***********************************************
		 * Confirm Order Page
		 ***********************************************/

		// Wait for the back button
		perform.waitForElementToBeClickable(driver, VMPConfirmOrder.backTop_btn(), "id");
		
		// Confirm order screen loads
		Assert.assertTrue(driver.getCurrentUrl().contains("OrderConfirm"), "Order page did not load");
		
		// Get page text
		String pageText = VMPConfirmOrder.page_txt(driver).getText();
		
		// Confirm there is not a spot to upload a sales contract or a required documents selection
		Assert.assertTrue(!pageText.contains("Required Documents"), "There should not be a required documents selection");
		Assert.assertTrue(!pageText.contains("Sales Contract"), "There should not be a spot to upload a sales contract");
		Assert.assertTrue(!pageText.contains("Upload sales contract"), "There should not be a spot to upload a sales contract");
		
		// Click Back
		perform.click(driver,VMPConfirmOrder.backTop_btn(driver));
		
		// Set Loan Purpose variable to Purchase
		StoredVariables.getassignmentInformationLoanPurpose().set("Purchase");
		
		// Select Loan Purpose
		perform.selectDropdownOption(driver, VMPNewOrder.loanPurpose_dropdown(driver), StoredVariables.getassignmentInformationLoanPurpose().get());
		
		// Click Next
		perform.click(driver,VMPNewOrder.nextBottom_btn(driver));
		
		Thread.sleep(1000);
		
		/***********************************************
		 * Confirm Order Page
		 ***********************************************/

		// Wait for the back button
		perform.waitForElementToBeClickable(driver, VMPConfirmOrder.backTop_btn(), "id");
		
		// Confirm order screen loads
		Assert.assertTrue(driver.getCurrentUrl().contains("OrderConfirm"), "Order page did not load");
		
		// Confirm there is a spot to upload a sales contract or a required documents selection
		pageText = VMPConfirmOrder.page_txt(driver).getText();
		String[] expected = {
				"Required Documents",
				"Sales Contract",
				"Upload sales contract"
		};
		perform.verifyTextContains(driver, pageText, expected);
		
		// Confirm you can Upload sales contract
		String filePath = StoredVariables.getdocDir().get()+"SalesContract.pdf";
		vmp.uploadSalesContractOnVMPConfirmOrder(driver, filePath);
		
		// Confirm once attached the hyperlink displays the filename
		Assert.assertTrue(VMPConfirmOrder.uploadSalesContract_btn(driver).getText().equals("SalesContract.pdf"), "The upload link should contain the document name");
		
		// Delete the file
		perform.click(driver,VMPConfirmOrder.deleteFile_btn(driver));
		
		Thread.sleep(2000);
		
		// Confirm deleting the file returns to Upload sales contract
		String uploadLinkText = VMPConfirmOrder.uploadSalesContract_btn(driver).getText();
		// Set 40 second while loop timeout
		long start_time = System.currentTimeMillis();
		long wait_time = 40000;
		long end_time = start_time + wait_time;
		while (System.currentTimeMillis() < end_time && !uploadLinkText.contains("Upload sales contract"))
		{
			Thread.sleep(1000);
			uploadLinkText = VMPConfirmOrder.uploadSalesContract_btn(driver).getText();
			if (uploadLinkText.contains("Upload sales contract"))
			{
				break;
			} // end if
		} // end while
		
		// Click Next
		perform.click(driver,VMPConfirmOrder.nextTop_btn(driver));

		// Confirm you cannot finish the order without having a sales contract uploaded
		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, VMPConfirmOrder.okInvalidInformation_btn(), "cssSelector");
		
		// Verify dialog text
		String invalidInformationDialog = VMPConfirmOrder.invalidInformationDialog_txt(driver).getText();
		String[] expected2 = {
				"Invalid Information",
				"There is a problem with some of the information you have provided for the order.",
				"Please correct the following issues and then try again.",
				"The sales contract document is required."
		};
		perform.verifyTextContains(driver, invalidInformationDialog, expected2);
		
		// Click OK
		perform.click(driver,VMPConfirmOrder.okInvalidInformation_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);

		// Upload sales contract
		vmp.uploadSalesContractOnVMPConfirmOrder(driver, filePath);
		
		// Confirm once attached the hyperlink displays the filename
		Assert.assertTrue(VMPConfirmOrder.uploadSalesContract_btn(driver).getText().equals("SalesContract.pdf"), "The upload link should contain the document name");
		
		// Click Next
		perform.click(driver,VMPConfirmOrder.nextTop_btn(driver));
		
		Thread.sleep(3500);
		
		// Wait until saving dialog is gone
		long start_time2 = System.currentTimeMillis();
		long wait_time2 = 40000;
		long end_time2 = start_time2 + wait_time2;
		String style = VMPConfirmOrder.saving_dialog(driver).getAttribute("style");
		while(System.currentTimeMillis() < end_time2 && !style.contains("display: none"))
		{
			Thread.sleep(1000);
			style = VMPConfirmOrder.saving_dialog(driver).getAttribute("style");
			if (style.contains("display: none"))
			{
				System.out.println("Saving dialog is gone");
				break;
			} // end if
		} // end while
		
		// Get inside the attach document frame
		perform.switchToiFrameByID(driver, "iframeAttach");

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
		
		// Verify you land on the orders grid
		Assert.assertTrue(driver.getCurrentUrl().contains("OrderManagement"), "After completing an order, the orders grid did not load");
		
		// Query the db to get the order number that was just created
		db.getLoanIDsFromVMPClientPortalOrder(driver);
		String trackingNumber = StoredVariables.gettrackingNumber().get();
		String trackingNumberVMP = StoredVariables.gettrackingNumberVMP().get();
		
		// View the order details in VMP Client Portal
		vmp.findAndOpenOrder(driver, trackingNumberVMP);
		
		// Confirm the Sales Contract displays in Order Documents and can be viewed
		// Verify the order details
		vmp.verifyAppraisalOrderDetails(driver);
		
		// Verify Document is in Documents
		String documentText = VMPAppraisalOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Sales Contract"), "Sales Contract did not sync to VMP Client Portal");
		
		// Click on Sales Contract
		perform.clickInTable_Contains(driver, "Sales Contract");
		
		// Wait for text to update
		perform.waitForText(driver, VMPAppraisalOrderDetails.documents_txt(driver), "SalesContract.pdf");
		documentText = VMPAppraisalOrderDetails.documents_txt(driver).getText();
		
		// Verify file name and uploaded by
		Assert.assertTrue(documentText.contains("SalesContract.pdf"), "Document name is incorrect in Documents");
		Assert.assertTrue(documentText.contains("Automation OriginatorRegressionSecure10"), "Uploaded By is incorrect in Documents");
		
		// View the Secure Mercury Network order
		// Login to Secure
		secure.login(driver, "RegressionSecure10", StoredVariables.getpassword().get());
		
		// Confirm the document is there
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Log test
		test.log(LogStatus.INFO, "Regression VMP", "Verified require sales contract functions correctly");
		
	} // end requireSalesContract
	
} // end the RequireSalesContract class
