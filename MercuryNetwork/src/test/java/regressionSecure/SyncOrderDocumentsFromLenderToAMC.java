package regressionSecure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

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
 * <h1>Secure - Sync Order Documents From Lender To AMC</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class SyncOrderDocumentsFromLenderToAMC extends TestSetup {
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set preferences and enable all status mapping</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Go to VMPXSites</li>
	 * 	<li>Click on Configure Status Mapping</li>
	 * 	<li>Enable all sync status options</li>
	 * 	<li>Click Save</li>
	 * 	<li>Click AMC/Firm</li>
	 * 	<li>Enable all sync status options</li>
	 * 	<li>Click Save</li>
	 * 	<li>Log into Secure as an AMC</li>
	 * 	<li>Go to VMPXSites</li>
	 * 	<li>Click on Configure Status Mapping</li>
	 * 	<li>Enable all sync status options</li>
	 * 	<li>Click Save</li>
	 * 	<li>Click AMC/Firm</li>
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
	 * 	<li>, "C:\\Code\\VMP\\automatedtesting\\MercuryNetwork\\src\\main\\resources\\testDocuments\\Preliminary Title Report.pdf");</li>
	 * 	<li>waitForAttachmentComplete(driver, num);</li>
	 * 	<li>Thread.sleep(3000);</li>
	 * 	<li></li>
	 * 	<li>Upload Special Instructions</li>
	 * 	<li>perform.selectDropdownOption(driver, VMPConfirmOrder.documentType_dropdown(driver), "Special Instructions");</li>
	 * 	<li>driver.findElement(By.cssSelector("input[type=file]"))</li>
	 * 	<li>, "C:\\Code\\VMP\\automatedtesting\\MercuryNetwork\\src\\main\\resources\\testDocuments\\Special Instructions.pdf");</li>
	 * 	<li>waitForAttachmentComplete(driver, num);</li>
	 * 	<li>Thread.sleep(3000);</li>
	 * 	<li></li>
	 * 	<li>Upload Statement of Engagement</li>
	 * 	<li>perform.selectDropdownOption(driver, VMPConfirmOrder.documentType_dropdown(driver), "Statement of Engagement");</li>
	 * 	<li>driver.findElement(By.cssSelector("input[type=file]"))</li>
	 * 	<li>, "C:\\Code\\VMP\\automatedtesting\\MercuryNetwork\\src\\main\\resources\\testDocuments\\Statement of Engagement.pdf");</li>
	 * 	<li>waitForAttachmentComplete(driver, num);</li>
	 * 	<li>Thread.sleep(3000);</li>
	 * 	<li></li>
	 * 	<li>Upload Value Reconsideration</li>
	 * 	<li>perform.selectDropdownOption(driver, VMPConfirmOrder.documentType_dropdown(driver), "Value Reconsideration");</li>
	 * 	<li>driver.findElement(By.cssSelector("input[type=file]"))</li>
	 * 	<li>, "C:\\Code\\VMP\\automatedtesting\\MercuryNetwork\\src\\main\\resources\\testDocuments\\Value Reconsideration.pdf");</li>
	 * 	<li>waitForAttachmentComplete(driver, num);</li>
	 * 	<li>Thread.sleep(3000);</li>
	 * 	<li>Click Finished</li>
	 * 	<li>Click OK</li>
	 * 	<li>Get order numbers</li>
	 * 	<li>Log into Secure as the Lender</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Verify the documents are attached and properly labeled</li>
	 * 	<li>Assign the order to an AMC</li>
	 * 	<li>Click AMC/Firm radio button</li>
	 * 	<li>Click Assign</li>
	 * 	<li>Assign the vendor</li>
	 * 	<li>Click Finish</li>
	 * 	<li>Log in as the AMC</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Verify the Documents were synced over to the secure side of the order</li>
	 * 	<li>Log test</li>
	 * 	<li>Set 40 second while loop timeout</li>
	 * 	<li>increment the int for the next attachment icon element</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - VMP XSite Settings", "Secure - Configure Status Mapping", "VMP - Create Order", "Secure - Orders", "Secure - Assign Order To AMC"}, alwaysRun=true)
	public void syncOrderDocumentsFromLenderToAMC() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Set preferences and enable all status mapping
		// Login to Secure
		secure.login(driver, "Sync1", StoredVariables.getpassword().get());
		
		// Go to VMPXSites
		secure.goToVMPXSites(driver);
		
		// Click on Configure Status Mapping
		perform.click(driver, SVMPXSites.configureStatusMapping_lnk(driver));
		
		// Wait for element
		perform.waitForElementToBeVisible(driver, SVMPXSites.statusMappingConfiguration_txt(), "id");
		
		// Enable all sync status options
		perform.enableAllOptionsInStatusMappingConfiguration(driver);
		
		// Click Save
		perform.clickInTable_Contains(driver, "Save");
		
		// Wait for save dialog to be hidden 
		perform.waitForOverlayToBeHidden(driver);
		
		// Click AMC/Firm
		perform.click(driver, SVMPXSites.amcFirm_btn(driver));

		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Enable all sync status options
		perform.enableAllOptionsInStatusMappingConfiguration(driver);
		
		// Click Save
		perform.clickInTable_Contains(driver, "Save");
		
		// Wait for save dialog to be hidden 
		perform.waitForOverlayToBeHidden(driver);
		
		// Log into Secure as an AMC
		secure.login(driver, "SyncAMC1", StoredVariables.getpassword().get());
		
		// Go to VMPXSites
		secure.goToVMPXSites(driver);
		
		// Click on Configure Status Mapping
		perform.click(driver, SVMPXSites.configureStatusMapping_lnk(driver));
		
		// Wait for element
		perform.waitForElementToBeVisible(driver, SVMPXSites.statusMappingConfiguration_txt(), "id");
		
		// Enable all sync status options
		perform.enableAllOptionsInStatusMappingConfiguration(driver);
		
		// Click Save
		perform.clickInTable_Contains(driver, "Save");
		
		// Wait for save dialog to be hidden 
		perform.waitForOverlayToBeHidden(driver);
		
		// Click AMC/Firm
		perform.click(driver, SVMPXSites.amcFirm_btn(driver));

		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Enable all sync status options
		perform.enableAllOptionsInStatusMappingConfiguration(driver);
		
		// Click Save
		perform.clickInTable_Contains(driver, "Save");
		
		// Wait for save dialog to be hidden 
		perform.waitForOverlayToBeHidden(driver);
		
		// Log into the Lender's VMP Client portal
		vmp.login(driver, "Sync1", "OriginatorSync1", StoredVariables.getpassword().get());
		
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
		perform.click(driver, VMPNewOrder.nextBottom_btn(driver));
		
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
		perform.type(driver,driver.findElement(By.cssSelector("input[type=file]"))
		      , StoredVariables.getdocDir().get()+"Condo HOA Cert.pdf");
		waitForAttachmentComplete(driver, num);
		Thread.sleep(3000);
		
		// Upload Hazard Disclosure
		perform.selectDropdownOption(driver, VMPConfirmOrder.documentType_dropdown(driver), "Hazard Disclosure");
		perform.type(driver,driver.findElement(By.cssSelector("input[type=file]"))
		      , StoredVariables.getdocDir().get()+"Hazard Disclosure.pdf");
		waitForAttachmentComplete(driver, num);
		Thread.sleep(3000);
		
		// Upload Other
		perform.selectDropdownOption(driver, VMPConfirmOrder.documentType_dropdown(driver), "Other");
		perform.type(driver,driver.findElement(By.cssSelector("input[type=file]"))
		      , StoredVariables.getdocDir().get()+"Other.pdf");
		waitForAttachmentComplete(driver, num);
		Thread.sleep(3000);
		
		/***************************************************************
		 * ONLY 4 DOCUMENTS ARE ALLOWED TO BE UPLOADED
		 ***************************************************************/
//		// Upload Preliminary Title Report
//		perform.selectDropdownOption(driver, VMPConfirmOrder.documentType_dropdown(driver), "Preliminary Title Report");
//		driver.findElement(By.cssSelector("input[type=file]"))
//	      , "C:\\Code\\VMP\\automatedtesting\\MercuryNetwork\\src\\main\\resources\\testDocuments\\Preliminary Title Report.pdf");
//		waitForAttachmentComplete(driver, num);
//		Thread.sleep(3000);
//		
//		// Upload Special Instructions
//		perform.selectDropdownOption(driver, VMPConfirmOrder.documentType_dropdown(driver), "Special Instructions");
//		driver.findElement(By.cssSelector("input[type=file]"))
//	      , "C:\\Code\\VMP\\automatedtesting\\MercuryNetwork\\src\\main\\resources\\testDocuments\\Special Instructions.pdf");
//		waitForAttachmentComplete(driver, num);
//		Thread.sleep(3000);
//		
//		// Upload Statement of Engagement
//		perform.selectDropdownOption(driver, VMPConfirmOrder.documentType_dropdown(driver), "Statement of Engagement");
//		driver.findElement(By.cssSelector("input[type=file]"))
//	      , "C:\\Code\\VMP\\automatedtesting\\MercuryNetwork\\src\\main\\resources\\testDocuments\\Statement of Engagement.pdf");
//		waitForAttachmentComplete(driver, num);
//		Thread.sleep(3000);
//		
//		// Upload Value Reconsideration
//		perform.selectDropdownOption(driver, VMPConfirmOrder.documentType_dropdown(driver), "Value Reconsideration");
//		driver.findElement(By.cssSelector("input[type=file]"))
//	      , "C:\\Code\\VMP\\automatedtesting\\MercuryNetwork\\src\\main\\resources\\testDocuments\\Value Reconsideration.pdf");
//		waitForAttachmentComplete(driver, num);
//		Thread.sleep(3000);
		
		// Click Finished
		perform.click(driver, VMPConfirmOrder.finished_btn(driver));
		
		// Switch out of iFrame
		driver.switchTo().defaultContent();
		
		// Click OK
		perform.click(driver, VMPConfirmOrder.ok_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Wait for Find textbox
		perform.waitForElementToBeClickable(driver, VMPOrders.find_txtbx(driver));;
		
		// Get order numbers
		db.getLoanIDsFromVMPClientPortalOrder(driver);
		String trackingNumber = StoredVariables.gettrackingNumber().get();
		
		// Log into Secure as the Lender
		secure.login(driver, "Sync1", StoredVariables.getpassword().get());
		
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
		
		// Assign the order to an AMC
		// Click AMC/Firm radio button
		perform.click(driver, SOrderDetails.amcFirm_radiobtn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		Thread.sleep(5000);
		
		// Wait for Assign button
		perform.waitForElementToBeClickable(driver, SOrderDetails.assign_btn(driver));
		
		// Click Assign
		perform.click(driver, SOrderDetails.assign_btn(driver));
		
		// Assign the vendor
		secure.selectVendor(driver, "SyncAMC1");
		
		// Click Finish
		perform.click(driver, SOrderDetails.finish_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for Edit button
		perform.waitForElementToBeClickable(driver, SOrderDetails.edit_btn(driver));
		
		// Log in as the AMC
		secure.login(driver, "SyncAMC1", StoredVariables.getpassword().get());
		
		// Find the order
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Open the order
		secure.openOrder(driver, trackingNumber);
		
		// Verify the Documents were synced over to the secure side of the order
		docsTable = SOrderDetails.documents_txt(driver);
		docs = docsTable.getText();
		System.out.println("docs = " + docs);
		Assert.assertTrue(docs.contains("Order Documents"), "There are documents missing in Secure");
		Assert.assertTrue(docs.contains("Sales Contract"), "There are documents missing in Secure");
		Assert.assertTrue(docs.contains("Condo/HOA Cert"), "There are documents missing in Secure");
		Assert.assertTrue(docs.contains("Hazard Disclosure"), "There are documents missing in Secure");
		Assert.assertTrue(docs.contains("Other"), "There are documents missing in Secure");
		
		// Log test
		test.log(LogStatus.INFO, "Secure Regression Test", "Verified that Order Documents sync from Lender to AMC");
		
	} // end syncOrderDocumentsFromLenderToAMC
	
	
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
