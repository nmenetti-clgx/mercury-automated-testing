package baselineSecure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Secure.SConfirmOrder;
import pageObjects.Secure.SMyColumns;
import pageObjects.Secure.SNewOrder;
import pageObjects.Secure.SOrderDetails;
import pageObjects.Secure.SOrders;
import pageObjects.Secure.SPaymentSummary;
import pageObjects.Secure.SPreferences;
import pageObjects.Secure.SSendMessage;
import pageObjects.Secure.SSendViaSureReceipts;
import pageObjects.Secure.SSetOrderStatus;
import pageObjects.Secure.SVendorSelection;
import pageObjects.Secure.SVendorSelectionSettings;
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
 * <h1>Baseline Secure - Order Management</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class Secure_OrderManagement extends TestSetup {
	
	/** The user. */
	private static String user = "Baseline2";
	
	/** The order number. */
	private String orderNumber;
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Go to Vendor Selection Settings</li>
	 * 	<li>Turn off Double-blind Communication switch</li>
	 * 	<li>Disable Automatic Vendor Selection</li>
	 * 	<li>Select Custom Fee Panel</li>
	 * 	<li>Uncheck Use Mercury Network Directory as backup checkbox</li>
	 * 	<li>Verify Mercury Network Directory as backup is unchecked</li>
	 * 	<li>Save Preferences</li>
	 * 	<li>Click OK in saved dialog box</li>
	 * 	<li>Go to Residential Appraisal</li>
	 * 	<li>Set Property Information data</li>
	 * 	<li>StoredVariables.getpropertyInformationStateAbbr().set("OK");  Must set for a field check later on</li>
	 * 	<li>Set Assignment Information data</li>
	 * 	<li>Set Lender Information data</li>
	 * 	<li>Set Contact And Access Information data</li>
	 * 	<li>Set Additional Notification Recipients data</li>
	 * 	<li>Enter New Order data</li>
	 * 	<li>Set the borrower identifier</li>
	 * 	<li>Click Next</li>
	 * 	<li>Assign vendor</li>
	 * 	<li>Confirm order screen loads</li>
	 * 	<li>Verify data displays properly</li>
	 * 	<li>Verify the 'I have read and understand the vendor's fee notes' checkbox is unchecked</li>
	 * 	<li>Click Next</li>
	 * 	<li>Verify popup displays with correct text</li>
	 * 	<li>Click OK</li>
	 * 	<li>Check the agree to notes checkbox</li>
	 * 	<li>Change payment method to check</li>
	 * 	<li>Click Next</li>
	 * 	<li>Get inside the attach document frame</li>
	 * 	<li>Select document type</li>
	 * 	<li>Upload Document</li>
	 * 	<li>Click Close Button</li>
	 * 	<li>Switch back to the attach documents frame</li>
	 * 	<li>Verify you land on the orders grid</li>
	 * 	<li>Query the db to get the order number that was just created</li>
	 * 	<li>Search for new order</li>
	 * 	<li>Verify the order is in the correct status</li>
	 * 	<li>Verify the order just created is in the orders grid</li>
	 * 	<li>Verify data in the database</li>
	 * 	<li>Search for new order</li>
	 * 	<li>Select the order in the table</li>
	 * 	<li>Click Message</li>
	 * 	<li>Click the QL icon in the comments field</li>
	 * 	<li>Switch iFrame</li>
	 * 	<li>Click Delete on QuickList item</li>
	 * 	<li>Verify dialog text</li>
	 * 	<li>Click Yes</li>
	 * 	<li>Check for more QL items</li>
	 * 	<li>Click New</li>
	 * 	<li>Enter a Description</li>
	 * 	<li>Enter the Text</li>
	 * 	<li>Click Save</li>
	 * 	<li>Click Edit</li>
	 * 	<li>Enter new text</li>
	 * 	<li>Click Save</li>
	 * 	<li>Click Delete on QuickList item</li>
	 * 	<li>Verify dialog text</li>
	 * 	<li>Click Yes</li>
	 * 	<li>Check for more QL items</li>
	 * 	<li>Click New</li>
	 * 	<li>Enter a Description</li>
	 * 	<li>Enter the Text</li>
	 * 	<li>Click Save</li>
	 * 	<li>Select the new QL item</li>
	 * 	<li>Click Use button</li>
	 * 	<li>Verify Message text</li>
	 * 	<li>Click Send</li>
	 * 	<li>Verify message text</li>
	 * 	<li>Click OK button</li>
	 * 	<li>Search for new order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Verify message is displayed in the audit trail</li>
	 * 	<li>Verify the tracking number is displayed</li>
	 * 	<li>Verify url contains OrderDetails.aspx</li>
	 * 	<li>Click Set Status</li>
	 * 	<li>Click Cancel</li>
	 * 	<li>Click the QL icon in the comments field</li>
	 * 	<li>Switch iFrame</li>
	 * 	<li>Click Delete on QuickList item</li>
	 * 	<li>Verify dialog text</li>
	 * 	<li>Click Yes</li>
	 * 	<li>Check for more QL items</li>
	 * 	<li>Click New</li>
	 * 	<li>Enter a Description</li>
	 * 	<li>Enter the Text</li>
	 * 	<li>Click Save</li>
	 * 	<li>Click Edit</li>
	 * 	<li>Enter new text</li>
	 * 	<li>Click Save</li>
	 * 	<li>Click Delete on QuickList item</li>
	 * 	<li>Verify dialog text</li>
	 * 	<li>Click Yes</li>
	 * 	<li>Check for more QL items</li>
	 * 	<li>Click New</li>
	 * 	<li>Enter a Description</li>
	 * 	<li>Enter the Text</li>
	 * 	<li>Click Save</li>
	 * 	<li>Select the new QL item</li>
	 * 	<li>Click Use button</li>
	 * 	<li>Verify Message text</li>
	 * 	<li>Click Cancel</li>
	 * 	<li>Log in as the vendor</li>
	 * 	<li>Search for the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Verify the message is displayed in the audit trail</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Search for new order</li>
	 * 	<li>Select the order in the table</li>
	 * 	<li>Click Delete</li>
	 * 	<li>Enter a message</li>
	 * 	<li>Click OK</li>
	 * 	<li>Verify message text</li>
	 * 	<li>Click OK button</li>
	 * 	<li>Search for new order</li>
	 * 	<li>Verify the order is not in the table</li>
	 * 	<li>Log in as the vendor</li>
	 * 	<li>Search for the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Verify the message is displayed in the audit trail</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Create Residential Appraisal Order", "Secure - Vendor Selection Settings", "Secure - Create Order", "Secure - Send Via SureReceipts", "Secure - Message", "Secure - Orders", "Secure - Place On Hold", "Vendors - Orders"}, alwaysRun=true)
	public void createNewResidentialAppraisalOrder() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Login to Secure
		secure.login(driver, user, StoredVariables.getpassword().get());
		
		// Go to Vendor Selection Settings
		secure.goToVendorSelectionSettings(driver);
		
		// Turn off Double-blind Communication switch
		if (!SVendorSelectionSettings.doubleBlind_switch(driver).getAttribute("src").contains("switchOff.png"))
		{
			perform.click(driver, SVendorSelectionSettings.doubleBlind_switch(driver));
		}
		
		// Disable Automatic Vendor Selection
		if (SVendorSelectionSettings.automaticOrderAssignment_switch(driver).getAttribute("src").contains("switchOn.png"))
		{
			perform.click(driver, SVendorSelectionSettings.automaticOrderAssignment_switch(driver));
		}
		
		// Select Custom Fee Panel
		perform.click(driver, SVendorSelectionSettings.customFeePanel_radio(driver));
		
		// Uncheck Use Mercury Network Directory as backup checkbox
		if (SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver).isSelected())
		{
			perform.click(driver, SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver));
		}
		
		// Verify Mercury Network Directory as backup is unchecked
		Assert.assertTrue(SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver).isSelected()==false, "Mercury Network Directory as backup is still checked");
		
		// Save Preferences
		perform.click(driver, SVendorSelectionSettings.save_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for the OK button to be visible
		perform.waitForElementToBeClickable(driver, SVendorSelectionSettings.ok_btn(), "id");
		
		// Click OK in saved dialog box
		perform.click(driver, SVendorSelectionSettings.ok_btn(driver));
		
		// Go to Residential Appraisal
		secure.goToResidentialAppraisal(driver);
		
		/***************************************
		 * Set New Order Information
		 ***************************************/
		
		// Set Property Information data
		StoredVariables.getpropertyInformationAddress().set("2621 SW 136th St");
		StoredVariables.getpropertyInformationCity().set("Oklahoma City");
		StoredVariables.getpropertyInformationState().set("Oklahoma");
		StoredVariables.getpropertyInformationStateAbbr().set("OK"); // Must set for a field check later on
		StoredVariables.getpropertyInformationZip().set("73170");
		StoredVariables.getpropertyInformationSqFt().set("3697");
		StoredVariables.getpropertyInformationSiteSize().set("9,583 sq ft");
		StoredVariables.getpropertyInformationPropType().set("Single Family");
		StoredVariables.getpropertyInformationPropRights().set("Fee Simple");
		StoredVariables.getpropertyInformationLegalDesc().set("2844 Guilford Ln, Oklahoma City, OK 73120");
		StoredVariables.getpropertyInformationDirections().set(perform.randomNumbers(driver, 8));
		
		// Set Assignment Information data
		StoredVariables.getassignmentInformationForm().set("Uniform Residential Appraisal (FNMA 1004)");
		StoredVariables.getassignmentInformationRushOrder().set(true);
		StoredVariables.getassignmentInformationComplex().set(true);
		StoredVariables.getassignmentInformationOrderDue().set(7);
		perform.getNewDate(driver, StoredVariables.getassignmentInformationOrderDue().get());
		StoredVariables.getassignmentInformationOtherRefNumber().set("8615406");
		StoredVariables.getassignmentInformationLoanType().set("All In One");
		StoredVariables.getassignmentInformationLoanPurpose().set("Purchase");
		StoredVariables.getassignmentInformationOrderedBy().set("Borrower Name");
		StoredVariables.getassignmentInformationOrderGroup().set("AppraisersGroupTest");
		StoredVariables.getassignmentInformationLoanNumber().set("74108641");
		StoredVariables.getassignmentInformationFileNumber().set("31849");
		StoredVariables.getassignmentInformationSalesPrice().set("645,715");
		StoredVariables.getassignmentInformationFHACaseNumber().set("564193");
		StoredVariables.getassignmentInformationDisclosure().set(0);
		StoredVariables.getassignmentInformationAssignedTo().set("Automation Baseline2");
		
		// Set Lender Information data
		StoredVariables.getlenderInformationLenderName().set("BOKF, National Association");
		StoredVariables.getlenderInformationAddress1().set("One Williams Center");
		StoredVariables.getlenderInformationAddress2().set("Suite D");
		StoredVariables.getlenderInformationCity().set("Tulsa");
		StoredVariables.getlenderInformationState().set("OK");
		StoredVariables.getlenderInformationZip().set("74172");
		
		// Set Contact And Access Information data
		StoredVariables.getcontactOccupancy().set("Owner");
		StoredVariables.getcontactBorrower().set("Borrower Name");
		StoredVariables.getcontactBorrowerInfo1Dropdown().set("Home");
		StoredVariables.getcontactBorrowerInfo1().set("405-555-7818");
		StoredVariables.getcontactBorrowerInfo2Dropdown().set("E-mail");
		StoredVariables.getcontactBorrowerInfo2().set("borrower@dntest.net");
		StoredVariables.getcontactBorrowerAddress().set("8051 Falcon Crst");
		StoredVariables.getcontactBorrowerCity().set("Edmond");
		StoredVariables.getcontactBorrowerState().set("OK");
		StoredVariables.getcontactBorrowerZip().set("73034");
		StoredVariables.getcontactCoBorrower().set("Coborrower Name");
		StoredVariables.getcontactCoBorrowerInfo1Dropdown().set("Work");
		StoredVariables.getcontactCoBorrowerInfo1().set("405-555-9813");
		StoredVariables.getcontactCoBorrowerInfo2Dropdown().set("Mobile");
		StoredVariables.getcontactCoBorrowerInfo2().set("405-555-1679");
		StoredVariables.getcontactCoBorrowerAddress().set("1509 Rain Tree Dr");
		StoredVariables.getcontactCoBorrowerCity().set("Moore");
		StoredVariables.getcontactCoBorrowerState().set("OK");
		StoredVariables.getcontactCoBorrowerZip().set("73160");
		StoredVariables.getcontactOwner().set("Owner Name");
		StoredVariables.getcontactOwnerInfo1Dropdown().set("Pager");
		StoredVariables.getcontactOwnerInfo1().set("405-555-8618");
		StoredVariables.getcontactOwnerInfo2Dropdown().set("Fax");
		StoredVariables.getcontactOwnerInfo2().set("405-555-7410");
		StoredVariables.getcontactOccupant().set("Occupant Name");
		StoredVariables.getcontactOccupantInfo1Dropdown().set("Home");
		StoredVariables.getcontactOccupantInfo1().set("405-555-3549");
		StoredVariables.getcontactOccupantInfo2Dropdown().set("Mobile");
		StoredVariables.getcontactOccupantInfo2().set("405-555-8895");
		StoredVariables.getcontactAgent().set("Agent Name");
		StoredVariables.getcontactAgentInfo1Dropdown().set("E-mail");
		StoredVariables.getcontactAgentInfo1().set("agent@dntest.net");
		StoredVariables.getcontactAgentInfo2Dropdown().set("Pager");
		StoredVariables.getcontactAgentInfo2().set("405-555-4893");
		StoredVariables.getcontactOther().set("Other Name");
		StoredVariables.getcontactOtherInfo1Dropdown().set("Work");
		StoredVariables.getcontactOtherInfo1().set("405-555-7825");
		StoredVariables.getcontactOtherInfo2Dropdown().set("Fax");
		StoredVariables.getcontactOtherInfo2().set("405-555-8688");
		StoredVariables.getcontactApptContact().set("Borrower");
		
		// Set Additional Notification Recipients data
		StoredVariables.getadditionalNotificationRecipientsAdditionalEmails().set("additionalEmail1@dntest.net; additionalEmail2@dntest.net");
		StoredVariables.getadditionalNotificationRecipientsAttachCompletedReport().set(true);
		
		// Enter New Order data
		secure.enterNewResidentialAppraisalOrder(driver);
		
		// Click Next
		perform.click(driver, SNewOrder.next_btn(driver));
		
		// Assign vendor
		secure.selectVendor(driver, "Automation BaselineAppraiser2");
		
		// Confirm order screen loads
		Assert.assertTrue(driver.getCurrentUrl().contains("ConfirmOrder"), "Confirm Order page did not load");
		
		// Verify data displays properly
		secure.verifyOrderDetails(driver);
		
		// Verify the 'I have read and understand the vendor's fee notes' checkbox is unchecked
		if (SConfirmOrder.readVendorsFeeNotes_chkbx(driver).isSelected())
		{
			perform.click(driver, SConfirmOrder.readVendorsFeeNotes_chkbx(driver));
		}
		
		// Click Next
		perform.click(driver, SConfirmOrder.nextBottom_btn(driver));
		
		// Wait for message text
		perform.waitForElementToBeClickable(driver, SConfirmOrder.messageOK_btn(), "id");
		
		// Verify popup displays with correct text
		Assert.assertTrue(SConfirmOrder.message_txt(driver).getText().contains("You must agree to the fee notes entered by the vendor."), "Message for not agreeing to vendor notes did not display properly");
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SConfirmOrder.messageOK_btn(), "id");
		
		// Click OK
		perform.click(driver, SConfirmOrder.messageOK_btn(driver));
		
		// Wait for the back button to be visible
		perform.waitForElementToBeClickable(driver, SConfirmOrder.backTop_btn(), "id");
		
		// Check the agree to notes checkbox
		if (!SConfirmOrder.readVendorsFeeNotes_chkbx(driver).isSelected())
		{
			perform.click(driver, SConfirmOrder.readVendorsFeeNotes_chkbx(driver));
		}
		
		// Change payment method to check
		perform.selectDropdownOption(driver, SConfirmOrder.paymentMethod_dropdown(driver), "Check");
		
		// Click Next
		perform.click(driver, SConfirmOrder.nextBottom_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Get inside the attach document frame
		perform.switchToiFrameByID(driver, "iframeAttach");
		
		// Wait for dropdown
		perform.waitForElementToBeClickable(driver, SConfirmOrder.documentType_dropdown(), "id");
		
		// Select document type
		perform.selectDropdownOption(driver, SConfirmOrder.documentType_dropdown(driver), "Other");
		
		// Wait for upload button
		perform.waitForElementToBeClickable(driver, SConfirmOrder.uploadDocuments_btn(), "id");
		
		// Upload Document
		String filePath = StoredVariables.getdocDir().get()+"Test PDF.pdf";
		secure.uploadDocumentOnSConfirmOrder(driver, filePath);
		
		// Click Close Button
		perform.click(driver, SConfirmOrder.finished_btn(driver));
		
		// Switch back to the attach documents frame
		driver.switchTo().defaultContent();
		
		// Wait for Orders page to load
		perform.waitForElementToBeClickable(driver, SOrders.find_txtbx(), "id");
		
		// Verify you land on the orders grid
		Assert.assertTrue(driver.getCurrentUrl().contains("OrderManagement"), "After completing an order, the orders grid did not load");
		
		// Query the db to get the order number that was just created
		orderNumber = db.getLoanID(driver);
		
		// Log order number to extent reports
		test.log(LogStatus.INFO, "Info", "Order Number: " + orderNumber);
		
		// Wait for the Order Types dropdown
		perform.waitForElementToBeClickable(driver, SOrders.orderTypes_dropdown(), "id");
		
		// Search for new order
		secure.findOrder(driver, orderNumber, "Tracking number");
		
		// Verify the order is in the correct status
		Assert.assertTrue(SOrders.ordersTable_txt(driver).getText().contains("Awaiting acceptance"), "The order is not in the correct status");
		
		// Verify the order just created is in the orders grid 
		Assert.assertTrue(SOrders.ordersTable_txt(driver).getText().contains(StoredVariables.getloanID().get()), "New order is not displayed");
		
		// Verify data in the database
		db.verifyNewOrderDataInDB_All(driver, StoredVariables.getloanID().get());
		
		// Search for new order
		secure.findOrder(driver, orderNumber, "Tracking number");
		
		// Select the order in the table
		perform.clickInTable_Contains(driver, orderNumber);
		
		// Click Message
		perform.clickInTable_Contains(driver, "Message");
		
		// Wait for Message textbox
		perform.waitForElementToBeClickable(driver, SOrders.message_txtbx(), "id");
		
		// QuickList test
		String message = "This is a baseline test message";
		WebElement menu = null;
		WebElement subMenu = null;
		Actions builder = new Actions(driver);
		int deleteVisible;
		if (StoredVariables.getmobile().get()==false) {
			
			// Click the QL icon in the comments field
			menu = driver.findElement(By.id("Dialogs_Dialogs_ctlSendMessages_txtMessage"));
			subMenu = driver.findElement(By.id("Dialogs_Dialogs_ctlSendMessages_hbStatusMessage_btnHover"));
			builder = new Actions(driver);
			builder.moveToElement(menu).perform();
			perform.waitForElementToBeClickable(driver, "Dialogs_Dialogs_ctlSendMessages_hbStatusMessage_btnHover", "id");
			perform.click(driver, subMenu);
			
			// Wait for busy to be hidden
			perform.waitForBusyToBeHidden(driver);
					
			// Switch iFrame
			perform.waitForiFrameSrcAndSwitchToIt(driver, "/Common/Lists/Quick.aspx?", By.id(SSendViaSureReceipts.close_btn()));
			
			// Wait for close button
			perform.waitForElementToBeClickable(driver, SSendViaSureReceipts.close_btn(), "id");
			
			deleteVisible = driver.findElements(By.cssSelector(SSendViaSureReceipts.delete_btn())).size();
			System.out.println("deleteVisible = " + deleteVisible);
			while (deleteVisible > 0)
			{
				
				// Click Delete on QuickList item
				perform.click(driver, SSendViaSureReceipts.delete_btn(driver));
				
				// Verify dialog text
				Assert.assertTrue(SSendViaSureReceipts.deleteDialog_txt(driver).getText().equals("Are you sure you want to delete the selected item?"), "The dialog text is incorrect");
				
				// Click Yes
				perform.click(driver, SSendViaSureReceipts.yes_btn(driver));
				
				// Wait for Close button
				perform.waitForElementToBeClickable(driver, SSendViaSureReceipts.close_btn(), "id");
				
				Thread.sleep(2000);
				// Check for more QL items
				deleteVisible = driver.findElements(By.cssSelector(SSendViaSureReceipts.delete_btn())).size();
			
			} // end while loop
			
			// Click New
			perform.click(driver, SSendViaSureReceipts.new_btn(driver));
			
			// Wait for Description textbox
			perform.waitForElementToBeClickable(driver, SSendViaSureReceipts.description_txtbx(), "id");
			
			// Enter a Description
			perform.type(driver, SSendViaSureReceipts.description_txtbx(driver), "Test QL Message");
			
			// Enter the Text
			perform.type(driver, SSendViaSureReceipts.text_txtbx(driver), "This is test QL Message text");
			
			// Click Save
			perform.click(driver, SSendViaSureReceipts.save_btn(driver));
			
			// Wait for busy to be hidden
			perform.waitForBusyToBeHidden(driver);
			
			// Click Edit
			perform.click(driver, SSendViaSureReceipts.edit_btn(driver));
			
			// Wait for Text
			perform.waitForElementToBeClickable(driver, SSendViaSureReceipts.text_txtbx(), "id");
			
			// Enter new text
			SSendViaSureReceipts.text_txtbx(driver).clear();
			perform.type(driver, SSendViaSureReceipts.text_txtbx(driver), "These is modified QL text");
	
			// Click Save
			perform.click(driver, SSendViaSureReceipts.save_btn(driver));
			
			// Wait for busy to be hidden
			perform.waitForBusyToBeHidden(driver);
			
			deleteVisible = driver.findElements(By.cssSelector(SSendViaSureReceipts.delete_btn())).size();
			System.out.println("deleteVisible = " + deleteVisible);
			while (deleteVisible > 0)
			{
				
				// Click Delete on QuickList item
				perform.click(driver, SSendViaSureReceipts.delete_btn(driver));
				
				// Verify dialog text
				Assert.assertTrue(SSendViaSureReceipts.deleteDialog_txt(driver).getText().equals("Are you sure you want to delete the selected item?"), "The dialog text is incorrect");
				
				// Click Yes
				perform.click(driver, SSendViaSureReceipts.yes_btn(driver));
				
				// Wait for Close button
				perform.waitForElementToBeClickable(driver, SSendViaSureReceipts.close_btn(), "id");
				
				Thread.sleep(2000);
				
				// Check for more QL items
				deleteVisible = driver.findElements(By.cssSelector(SSendViaSureReceipts.delete_btn())).size();
			
			} // end while loop
			
			// Click New
			perform.click(driver, SSendViaSureReceipts.new_btn(driver));
			
			// Wait for Description textbox
			perform.waitForElementToBeClickable(driver, SSendViaSureReceipts.description_txtbx(), "id");
			
			// Enter a Description
			perform.type(driver, SSendViaSureReceipts.description_txtbx(driver), "Test QL Message");
			
			// Enter the Text
			perform.type(driver, SSendViaSureReceipts.text_txtbx(driver), message);
			
			// Click Save
			perform.click(driver, SSendViaSureReceipts.save_btn(driver));
			
			// Wait for busy to be hidden
			perform.waitForBusyToBeHidden(driver);
			
			// Select the new QL item
			perform.click(driver, SSendViaSureReceipts.select_btn(driver));
			
			Thread.sleep(5000);
			
			// Click Use button
			perform.click(driver, SSendViaSureReceipts.use_btn(driver));
			
			// Switch out of iFrame
			driver.switchTo().defaultContent();
			
			// Wait for Send button
			perform.waitForElementToBeClickable(driver, SSendMessage.send_btn(), "id");
			
			// Verify Message text
			Assert.assertTrue(SSendMessage.message_txtbx(driver).getAttribute("value").equals(message), "The Message text is incorrect");
		
		} else {
			
			// Enter message
			perform.type(driver, SOrders.message_txtbx(driver), message);
			
		} // end if/else
		
		// Click Send
		perform.click(driver, SSendMessage.send_btn(driver));
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SOrders.okMessage_btn(), "id");
		
		// Verify message text
		String messageText = SOrders.message_txt(driver).getText();
		Assert.assertTrue(messageText.contains("Send Message"), "Message text is incorrect. Should contain Send Message. The screen is displaying = " + messageText);
		Assert.assertTrue(messageText.contains("Your messages have been successfully sent."), "Message text is incorrect. Should contain Your messages have been successfully sent. The screen is displaying = " + messageText);
		
		// Click OK button
		perform.click(driver, SOrders.okMessage_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Search for new order
		secure.findOrder(driver, orderNumber, "Tracking number");
		
		// Open the order
		secure.openOrder(driver, orderNumber);
		
		// Wait for Tracking Number
		perform.waitForElementToBeClickable(driver, SOrderDetails.trackingNumber_txt(), "cssSelector");
		
		// Verify message is displayed in the audit trail
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains(message), "The message is not displayed in the audit trail");
		
		// Verify the tracking number is displayed
		Assert.assertTrue(SOrderDetails.trackingNumber_txt(driver).getText().contains(orderNumber), "Tracking number is not displayed correctly. Should contain = " + orderNumber + " but screen is displaying = " + SOrderDetails.trackingNumber_txt(driver).getText());
		
		// Verify url contains OrderDetails.aspx
		Assert.assertTrue(driver.getCurrentUrl().contains("OrderDetails.aspx"), "URL is incorrect. = " + driver.getCurrentUrl());
		
		// Click Set Status
		perform.click(driver, SOrderDetails.setStatus_btn(driver));
		
		// Click Cancel
		perform.click(driver, SOrderDetails.setStatusCancel_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for Note textbox
		perform.waitForElementToBeClickable(driver, SSetOrderStatus.notePlaceOnHold_txtbx(), "id");
		
		// Click the QL icon in the comments field
		if (StoredVariables.getmobile().get()==false) {
		
			menu = driver.findElement(By.id("Dialogs_Dialogs_ctlStatusMessage_txtMessage"));
			subMenu = driver.findElement(By.id("Dialogs_Dialogs_ctlStatusMessage_hbStatusMessage_btnHover"));
			builder = new Actions(driver);
			builder.moveToElement(menu).perform();
			perform.waitForElementToBeClickable(driver, "Dialogs_Dialogs_ctlStatusMessage_hbStatusMessage_btnHover", "id");
			perform.click(driver, subMenu);
			
			// Wait for busy to be hidden
			perform.waitForBusyToBeHidden(driver);
					
			// Switch iFrame
			perform.waitForiFrameSrcAndSwitchToIt(driver, "/Common/Lists/Quick.aspx?", By.id(SSendViaSureReceipts.close_btn()));
			
			// Wait for close button
			perform.waitForElementToBeClickable(driver, SSendViaSureReceipts.close_btn(), "id");
			
			deleteVisible = driver.findElements(By.cssSelector(SSendViaSureReceipts.delete_btn())).size();
			System.out.println("deleteVisible = " + deleteVisible);
			while (deleteVisible > 0)
			{
				
				// Click Delete on QuickList item
				perform.click(driver, SSendViaSureReceipts.delete_btn(driver));
				
				// Verify dialog text
				Assert.assertTrue(SSendViaSureReceipts.deleteDialog_txt(driver).getText().equals("Are you sure you want to delete the selected item?"), "The dialog text is incorrect");
				
				// Click Yes
				perform.click(driver, SSendViaSureReceipts.yes_btn(driver));
				
				// Wait for Close button
				perform.waitForElementToBeClickable(driver, SSendViaSureReceipts.close_btn(), "id");
				
				Thread.sleep(2000);
				// Check for more QL items
				deleteVisible = driver.findElements(By.cssSelector(SSendViaSureReceipts.delete_btn())).size();
			
			} // end while loop
			
			// Click New
			perform.click(driver, SSendViaSureReceipts.new_btn(driver));
			
			// Wait for Description textbox
			perform.waitForElementToBeClickable(driver, SSendViaSureReceipts.description_txtbx(), "id");
			
			// Enter a Description
			perform.type(driver, SSendViaSureReceipts.description_txtbx(driver), "Test QL Message");
			
			// Enter the Text
			perform.type(driver, SSendViaSureReceipts.text_txtbx(driver), "This is test QL Message text");
			
			// Click Save
			perform.click(driver, SSendViaSureReceipts.save_btn(driver));
			
			// Wait for busy to be hidden
			perform.waitForBusyToBeHidden(driver);
			
			// Click Edit
			perform.click(driver, SSendViaSureReceipts.edit_btn(driver));
			
			// Wait for Text
			perform.waitForElementToBeClickable(driver, SSendViaSureReceipts.text_txtbx(), "id");
			
			// Enter new text
			SSendViaSureReceipts.text_txtbx(driver).clear();
			perform.type(driver, SSendViaSureReceipts.text_txtbx(driver), "These is modified QL text");
	
			// Click Save
			perform.click(driver, SSendViaSureReceipts.save_btn(driver));
			
			// Wait for busy to be hidden
			perform.waitForBusyToBeHidden(driver);
			
			deleteVisible = driver.findElements(By.cssSelector(SSendViaSureReceipts.delete_btn())).size();
			System.out.println("deleteVisible = " + deleteVisible);
			while (deleteVisible > 0)
			{
				
				// Click Delete on QuickList item
				perform.click(driver, SSendViaSureReceipts.delete_btn(driver));
				
				// Verify dialog text
				Assert.assertTrue(SSendViaSureReceipts.deleteDialog_txt(driver).getText().equals("Are you sure you want to delete the selected item?"), "The dialog text is incorrect");
				
				// Click Yes
				perform.click(driver, SSendViaSureReceipts.yes_btn(driver));
				
				// Wait for Close button
				perform.waitForElementToBeClickable(driver, SSendViaSureReceipts.close_btn(), "id");
				
				Thread.sleep(2000);
				
				// Check for more QL items
				deleteVisible = driver.findElements(By.cssSelector(SSendViaSureReceipts.delete_btn())).size();
			
			} // end while loop
			
			// Click New
			perform.click(driver, SSendViaSureReceipts.new_btn(driver));
			
			// Wait for Description textbox
			perform.waitForElementToBeClickable(driver, SSendViaSureReceipts.description_txtbx(), "id");
			
			// Enter a Description
			perform.type(driver, SSendViaSureReceipts.description_txtbx(driver), "Test QL Message");
			
			// Enter the Text
			message = "This is a baseline test message";
			perform.type(driver, SSendViaSureReceipts.text_txtbx(driver), message);
			
			// Click Save
			perform.click(driver, SSendViaSureReceipts.save_btn(driver));
			
			// Wait for busy to be hidden
			perform.waitForBusyToBeHidden(driver);
			
			// Select the new QL item
			perform.click(driver, SSendViaSureReceipts.select_btn(driver));
			
			Thread.sleep(5000);
			
			// Click Use button
			perform.click(driver, SSendViaSureReceipts.use_btn(driver));
			
			// Switch out of iFrame
			driver.switchTo().defaultContent();
			
			// Wait for Cancel button
			perform.waitForElementToBeClickable(driver, SSetOrderStatus.cancel_btn(), "id");
			
			// Verify Message text
			Assert.assertTrue(SSetOrderStatus.notePlaceOnHold_txtbx(driver).getAttribute("value").equals(message), "The Message text is incorrect");
			
			// Click Cancel
			perform.click(driver, SSetOrderStatus.cancel_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
		} // end if
		
		// Log in as the vendor
		vendors.login(driver, "BaselineAppraiser2", StoredVariables.getpassword().get());
		
		// Search for the order
		vendors.findOrder(driver, orderNumber, "Tracking Number");
		
		// Open the order
		vendors.openOrder(driver);
		
		// Wait for the Send Message button
		perform.waitForElementToBeClickable(driver, VOrderDetails.sendMessage_btn(), "cssSelector");
		
		// Verify the message is displayed in the audit trail
		Assert.assertTrue(VOrderDetails.orderInformation_txt(driver).getText().contains(message), "The message is not displayed on the Vendors order history");
		
		// Login to Secure
		secure.login(driver, user, StoredVariables.getpassword().get());
		
		// Search for new order
		secure.findOrder(driver, orderNumber, "Tracking number");
		
		// Select the order in the table
		perform.clickInTable_Contains(driver, orderNumber);
		
		// Click Delete
		perform.clickInTable_Contains(driver, "Delete");
		
		// Wait for Message textbox
		perform.waitForElementToBeClickable(driver, SOrders.deleteMessage_txtbx(), "id");
		
		// Enter a message
		message = "This is for the baseline test testing the Delete button on Secure";
		perform.type(driver, SOrders.deleteMessage_txtbx(driver), message);
		
		// Click OK
		perform.click(driver, SOrders.okSendDeleteMessage_btn(driver));
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SOrders.okMessage_btn(), "id");
		
		// Verify message text
		messageText = SOrders.message_txt(driver).getText();
		Assert.assertTrue(messageText.contains("Delete Orders"), "Message text is incorrect. Should contain Delete Orders. The screen is displaying = " + messageText);
		Assert.assertTrue(messageText.contains("Your orders have been successfully deleted."), "Message text is incorrect. Should contain Your orders have been successfully deleted.. The screen is displaying = " + messageText);
		
		// Click OK button
		perform.click(driver, SOrders.okMessage_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Search for new order
		secure.findOrder(driver, orderNumber, "Tracking number");
		
		// Verify the order is not in the table
		Assert.assertTrue(!SOrders.ordersTable_txt(driver).getText().contains(orderNumber), "The order should have gotten deleted, but it did not");
		
		// Log in as the vendor
		vendors.login(driver, "BaselineAppraiser2", StoredVariables.getpassword().get());
		
		// Search for the order
		vendors.findOrder(driver, orderNumber, "Tracking Number");
		
		// Open the order
		vendors.openOrder(driver);
		
		// Wait for the Send Message button
		perform.waitForElementToBeClickable(driver, VOrderDetails.sendMessage_btn(), "cssSelector");
		
		// Verify the message is displayed in the audit trail
		Assert.assertTrue(VOrderDetails.orderInformation_txt(driver).getText().contains(message), "The Delete message is not displayed on the Vendors order history");

		// Log test
		test.log(LogStatus.INFO, "Orders", "Created new Resiential Appraisal order on Secure");
		
	} // end createNewResidentialAppraisalOrder
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Go to Vendor Selection Settings</li>
	 * 	<li>Turn off Double-blind Communication switch</li>
	 * 	<li>Disable Automatic Vendor Selection</li>
	 * 	<li>Select Custom Fee Panel</li>
	 * 	<li>Uncheck Use Mercury Network Directory as backup checkbox</li>
	 * 	<li>Verify Mercury Network Directory as backup is unchecked</li>
	 * 	<li>Save Preferences</li>
	 * 	<li>Click OK in saved dialog box</li>
	 * 	<li>Go to Commercial Appraisal</li>
	 * 	<li>Set Property Information data</li>
	 * 	<li>StoredVariables.getpropertyInformationStateAbbr().set("OK");  Must set for a field check later on</li>
	 * 	<li>Set Assignment Information data</li>
	 * 	<li>Set Lender Information data</li>
	 * 	<li>Set Contact And Access Information data</li>
	 * 	<li>Set Additional Notification Recipients data</li>
	 * 	<li>Enter New Order data</li>
	 * 	<li>Click Next</li>
	 * 	<li>Click Fee Panel Tab button</li>
	 * 	<li>Verify url contains VendorSelect</li>
	 * 	<li>Select vendor</li>
	 * 	<li>Click Next</li>
	 * 	<li>Verify Confirm Order url</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Click Next</li>
	 * 	<li>Get inside the attach document frame</li>
	 * 	<li>Select document type</li>
	 * 	<li>Upload Document</li>
	 * 	<li>Click Close Button</li>
	 * 	<li>Switch back to the attach documents frame</li>
	 * 	<li>Verify you land on the orders grid</li>
	 * 	<li>Query the db to get the order number that was just created</li>
	 * 	<li>Search for new order</li>
	 * 	<li>Verify the order is in the correct status</li>
	 * 	<li>Verify the order just created is in the orders grid</li>
	 * 	<li>Verify data in the database</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Orders", "Secure - Create Commercial Appraisal Bid Order", "Secure - Vendor Selection Settings"}, alwaysRun=true)
	public void createNewCommercialAppraisalBidOrder() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Login to Secure
		secure.login(driver, user, StoredVariables.getpassword().get());
		
		// Go to Vendor Selection Settings
		secure.goToVendorSelectionSettings(driver);
		
		// Turn off Double-blind Communication switch
		if (!SVendorSelectionSettings.doubleBlind_switch(driver).getAttribute("src").contains("switchOff.png"))
		{
			perform.click(driver, SVendorSelectionSettings.doubleBlind_switch(driver));
		}
		
		// Disable Automatic Vendor Selection
		if (SVendorSelectionSettings.automaticOrderAssignment_switch(driver).getAttribute("src").contains("switchOn.png"))
		{
			perform.click(driver, SVendorSelectionSettings.automaticOrderAssignment_switch(driver));
		}
		
		// Select Custom Fee Panel
		perform.click(driver, SVendorSelectionSettings.customFeePanel_radio(driver));
		
		// Uncheck Use Mercury Network Directory as backup checkbox
		if (SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver).isSelected())
		{
			perform.click(driver, SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver));
		}
		
		// Verify Mercury Network Directory as backup is unchecked
		Assert.assertTrue(SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver).isSelected()==false, "Mercury Network Directory as backup is still checked");
		
		// Save Preferences
		perform.click(driver, SVendorSelectionSettings.save_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for the OK button to be visible
		perform.waitForElementToBeClickable(driver, SVendorSelectionSettings.ok_btn(), "id");
		
		// Click OK in saved dialog box
		perform.click(driver, SVendorSelectionSettings.ok_btn(driver));
		
		// Go to Commercial Appraisal
		secure.goToCommercialAppraisal(driver);
		
		/***************************************
		 * Set New Order Information
		 ***************************************/
		
		// Set Property Information data
		StoredVariables.getpropertyInformationAddress().set("501-D NE 122nd St");
		StoredVariables.getpropertyInformationCity().set("Oklahoma City");
		StoredVariables.getpropertyInformationState().set("Oklahoma");
		StoredVariables.getpropertyInformationStateAbbr().set("OK"); // Must set for a field check later on
		StoredVariables.getpropertyInformationZip().set("73114");
		StoredVariables.getpropertyInformationSqFt().set("5688");
		StoredVariables.getpropertyInformationSiteSize().set("9,583 sq ft");
		StoredVariables.getpropertyInformationPropType().set("Office");
		StoredVariables.getpropertyInformationPropRights().set("Fee Simple");
		StoredVariables.getpropertyInformationLegalDesc().set("501-D NE 122nd St");
		StoredVariables.getpropertyInformationDirections().set(perform.randomNumbers(driver, 8));
		
		// Set Assignment Information data
		StoredVariables.getassignmentInformationForm().set("Commercial Appraisal Report");
		StoredVariables.getassignmentInformationRushOrder().set(true);
		StoredVariables.getassignmentInformationComplex().set(true);
		StoredVariables.getassignmentInformationIssueAsBid().set(true);
		StoredVariables.getassignmentInformationOrderDue().set(7);
		perform.getNewDate(driver, StoredVariables.getassignmentInformationOrderDue().get());
		StoredVariables.getassignmentInformationOtherRefNumber().set(perform.randomNumbers(driver, 7));
		StoredVariables.getassignmentInformationLoanType().set("All In One");
		StoredVariables.getassignmentInformationLoanPurpose().set("Purchase");
		StoredVariables.getassignmentInformationOrderedBy().set("Borrower Name");
		StoredVariables.getassignmentInformationOrderGroup().set("AppraisersGroupTest");
		StoredVariables.getassignmentInformationLoanNumber().set(perform.randomNumbers(driver, 8));
		StoredVariables.getassignmentInformationFileNumber().set(perform.randomNumbers(driver, 5));
		StoredVariables.getassignmentInformationSalesPrice().set("645,715");
		StoredVariables.getassignmentInformationFHACaseNumber().set(perform.randomNumbers(driver, 6));
		StoredVariables.getassignmentInformationDisclosure().set(0);
		StoredVariables.getassignmentInformationAssignedTo().set("Automation Baseline2");
		
		// Set Lender Information data
		StoredVariables.getlenderInformationLenderName().set("BOKF, National Association");
		StoredVariables.getlenderInformationAddress1().set("One Williams Center");
		StoredVariables.getlenderInformationAddress2().set("Suite D");
		StoredVariables.getlenderInformationCity().set("Tulsa");
		StoredVariables.getlenderInformationState().set("OK");
		StoredVariables.getlenderInformationZip().set("74172");
		
		// Set Contact And Access Information data
		StoredVariables.getcontactOccupancy().set("Owner");
		StoredVariables.getcontactBorrower().set("Borrower Name");
		StoredVariables.getcontactBorrowerInfo1Dropdown().set("Home");
		StoredVariables.getcontactBorrowerInfo1().set("405-555-7818");
		StoredVariables.getcontactBorrowerInfo2Dropdown().set("E-mail");
		StoredVariables.getcontactBorrowerInfo2().set("borrower@dntest.net");
		StoredVariables.getcontactBorrowerAddress().set("8051 Falcon Crst");
		StoredVariables.getcontactBorrowerCity().set("Edmond");
		StoredVariables.getcontactBorrowerState().set("OK");
		StoredVariables.getcontactBorrowerZip().set("73034");
		StoredVariables.getcontactCoBorrower().set("Coborrower Name");
		StoredVariables.getcontactCoBorrowerInfo1Dropdown().set("Work");
		StoredVariables.getcontactCoBorrowerInfo1().set("405-555-9813");
		StoredVariables.getcontactCoBorrowerInfo2Dropdown().set("Mobile");
		StoredVariables.getcontactCoBorrowerInfo2().set("405-555-1679");
		StoredVariables.getcontactCoBorrowerAddress().set("1509 Rain Tree Dr");
		StoredVariables.getcontactCoBorrowerCity().set("Moore");
		StoredVariables.getcontactCoBorrowerState().set("OK");
		StoredVariables.getcontactCoBorrowerZip().set("73160");
		StoredVariables.getcontactOwner().set("Owner Name");
		StoredVariables.getcontactOwnerInfo1Dropdown().set("Pager");
		StoredVariables.getcontactOwnerInfo1().set("405-555-8618");
		StoredVariables.getcontactOwnerInfo2Dropdown().set("Fax");
		StoredVariables.getcontactOwnerInfo2().set("405-555-7410");
		StoredVariables.getcontactOccupant().set("Occupant Name");
		StoredVariables.getcontactOccupantInfo1Dropdown().set("Home");
		StoredVariables.getcontactOccupantInfo1().set("405-555-3549");
		StoredVariables.getcontactOccupantInfo2Dropdown().set("Mobile");
		StoredVariables.getcontactOccupantInfo2().set("405-555-8895");
		StoredVariables.getcontactAgent().set("Agent Name");
		StoredVariables.getcontactAgentInfo1Dropdown().set("E-mail");
		StoredVariables.getcontactAgentInfo1().set("agent@dntest.net");
		StoredVariables.getcontactAgentInfo2Dropdown().set("Pager");
		StoredVariables.getcontactAgentInfo2().set("405-555-4893");
		StoredVariables.getcontactOther().set("Other Name");
		StoredVariables.getcontactOtherInfo1Dropdown().set("Work");
		StoredVariables.getcontactOtherInfo1().set("405-555-7825");
		StoredVariables.getcontactOtherInfo2Dropdown().set("Fax");
		StoredVariables.getcontactOtherInfo2().set("405-555-8688");
		StoredVariables.getcontactApptContact().set("Borrower");
		
		// Set Additional Notification Recipients data
		StoredVariables.getadditionalNotificationRecipientsAdditionalEmails().set("additionalEmail1@dntest.net; additionalEmail2@dntest.net");
		StoredVariables.getadditionalNotificationRecipientsAttachCompletedReport().set(true);
		
		// Enter New Order data
		secure.enterNewCommercialAppraisalOrder(driver);
		
		// Click Next
		perform.click(driver, SNewOrder.next_btn(driver));
		
		// Close Related Orders popup
		secure.checkForRelatedOrdersDialog(driver);
		
		// Click Fee Panel Tab button
		perform.click(driver, SVendorSelection.feePanelTab_tab(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Verify url contains VendorSelect
		Assert.assertTrue(driver.getCurrentUrl().contains("VendorSelect"), "The url does not contain VendorSelect");
		
		// Select vendor
		perform.clickInTable_Contains(driver, "Automation BaselineAppraiser2");
		
		// Click Next
		perform.click(driver, SVendorSelection.nextTop_btn(driver));
		
		// Wait for Next button
		perform.waitForElementToBeClickable(driver, SConfirmOrder.nextTop_btn(), "id");
		
		// Verify Confirm Order url
		Assert.assertTrue(driver.getCurrentUrl().contains("ConfirmOrder"), "The Confirm Order screen did not load properly");
		
		// Verify order details
		secure.verifyOrderDetails(driver);
		
		// Click Next
		perform.click(driver, SConfirmOrder.nextBottom_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Get inside the attach document frame
		perform.switchToiFrameByID(driver, "iframeAttach");
		
		// Select document type
		perform.selectDropdownOption(driver, SConfirmOrder.documentType_dropdown(driver), "Other");
		
		// Wait for upload button
		perform.waitForElementToBeClickable(driver, SConfirmOrder.uploadDocuments_btn(), "id");
		
		// Upload Document
		String filePath = StoredVariables.getdocDir().get()+"Test PDF.pdf";
		secure.uploadDocumentOnSConfirmOrder(driver, filePath);
		
		// Click Close Button
		perform.click(driver, SConfirmOrder.finished_btn(driver));
		
		// Switch back to the attach documents frame
		driver.switchTo().defaultContent();
		
		// Wait for Orders page to load
		perform.waitForElementToBeClickable(driver, SOrders.find_txtbx(), "id");
		
		// Verify you land on the orders grid
		Assert.assertTrue(driver.getCurrentUrl().contains("OrderManagement"), "After completing an order, the orders grid did not load");
		
		// Query the db to get the order number that was just created
		db.getLoanID(driver);
		
		// Log order number to extent reports
		test.log(LogStatus.INFO, "Info", "Order Number: " + StoredVariables.getloanID().get());
		
		// Wait for the Order Types dropdown
		perform.waitForElementToBeClickable(driver, SOrders.orderTypes_dropdown(), "id");

		// Search for new order
		secure.findOrder(driver, StoredVariables.getloanID().get(), "Tracking number");
		
		// Verify the order is in the correct status
		Assert.assertTrue(SOrders.ordersTable_txt(driver).getText().contains("Out for Bid"), "The order is not in the correct status");
		
		// Verify the order just created is in the orders grid 
		Assert.assertTrue(SOrders.ordersTable_txt(driver).getText().contains(StoredVariables.getloanID().get()), "New order is not displayed");
		
		// Verify data in the database
		db.verifyNewOrderDataInDB_All(driver, StoredVariables.getloanID().get());
		
		// Log test
		test.log(LogStatus.INFO, "Orders", "Created new Commercial Appraisal order on Secure");
		
	} // end createNewCommercialAppraisalBidOrder
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Go to  Vendor Selection Settings</li>
	 * 	<li>Turn off Double-blind Communication switch</li>
	 * 	<li>Disable Automatic Vendor Selection</li>
	 * 	<li>Select Custom Fee Panel</li>
	 * 	<li>Uncheck Use Mercury Network Directory as backup checkbox</li>
	 * 	<li>Verify Mercury Network Directory as backup is unchecked</li>
	 * 	<li>Save Preferences</li>
	 * 	<li>Click OK in saved dialog box</li>
	 * 	<li>Go to Commercial Appraisal</li>
	 * 	<li>Set Property Information data</li>
	 * 	<li>StoredVariables.getpropertyInformationStateAbbr().set("OK");  Must set for a field check later on</li>
	 * 	<li>Set Assignment Information data</li>
	 * 	<li>Set Lender Information data</li>
	 * 	<li>Set Contact And Access Information data</li>
	 * 	<li>Set Additional Notification Recipients data</li>
	 * 	<li>Enter New Order data</li>
	 * 	<li>Click Next</li>
	 * 	<li>Assign vendor</li>
	 * 	<li>Verify Confirm Order url</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Click Next</li>
	 * 	<li>Get inside the attach document frame</li>
	 * 	<li>Select document type</li>
	 * 	<li>Upload Document</li>
	 * 	<li>Click Close Button</li>
	 * 	<li>Switch back to the attach documents frame</li>
	 * 	<li>Verify you land on the orders grid</li>
	 * 	<li>Query the db to get the order number that was just created</li>
	 * 	<li>Search for new order</li>
	 * 	<li>Verify the order is in the correct status</li>
	 * 	<li>Verify the order just created is in the orders grid</li>
	 * 	<li>Verify data in the database</li>
	 * 	<li>Open the order</li>
	 * 	<li>Verify there is no Statement of Engagement attached to the order</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Orders", "Secure - Create Commercial Appraisal Non-Bid Order", "Secure - Vendor Selection Settings"}, alwaysRun=true)
	public void createNewCommercialAppraisalNoBidOrder() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Login to Secure
		secure.login(driver, user, StoredVariables.getpassword().get());
		
		// Go to  Vendor Selection Settings
		secure.goToVendorSelectionSettings(driver);
		
		// Turn off Double-blind Communication switch
		if (!SVendorSelectionSettings.doubleBlind_switch(driver).getAttribute("src").contains("switchOff.png"))
		{
			perform.click(driver, SVendorSelectionSettings.doubleBlind_switch(driver));
		}
		
		// Disable Automatic Vendor Selection
		if (SVendorSelectionSettings.automaticOrderAssignment_switch(driver).getAttribute("src").contains("switchOn.png"))
		{
			perform.click(driver, SVendorSelectionSettings.automaticOrderAssignment_switch(driver));
		}
		
		// Select Custom Fee Panel
		perform.click(driver, SVendorSelectionSettings.customFeePanel_radio(driver));
		
		// Uncheck Use Mercury Network Directory as backup checkbox
		if (SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver).isSelected())
		{
			perform.click(driver, SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver));
		}
		
		// Verify Mercury Network Directory as backup is unchecked
		Assert.assertTrue(SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver).isSelected()==false, "Mercury Network Directory as backup is still checked");
		
		// Save Preferences
		perform.click(driver, SVendorSelectionSettings.save_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for the OK button to be visible
		perform.waitForElementToBeClickable(driver, SVendorSelectionSettings.ok_btn(), "id");
		
		// Click OK in saved dialog box
		perform.click(driver, SVendorSelectionSettings.ok_btn(driver));
		
		// Go to Commercial Appraisal
		secure.goToCommercialAppraisal(driver);
		
		/***************************************
		 * Set New Order Information
		 ***************************************/
		
		// Set Property Information data
		StoredVariables.getpropertyInformationAddress().set("501-D NE 122nd St");
		StoredVariables.getpropertyInformationCity().set("Oklahoma City");
		StoredVariables.getpropertyInformationState().set("Oklahoma");
		StoredVariables.getpropertyInformationStateAbbr().set("OK"); // Must set for a field check later on
		StoredVariables.getpropertyInformationZip().set("73114");
		StoredVariables.getpropertyInformationSqFt().set("5688");
		StoredVariables.getpropertyInformationSiteSize().set("9,583 sq ft");
		StoredVariables.getpropertyInformationPropType().set("Office");
		StoredVariables.getpropertyInformationPropRights().set("Fee Simple");
		StoredVariables.getpropertyInformationLegalDesc().set("501-D NE 122nd St");
		StoredVariables.getpropertyInformationDirections().set(perform.randomNumbers(driver, 8));
		
		// Set Assignment Information data
		StoredVariables.getassignmentInformationForm().set("Commercial Appraisal Report");
		StoredVariables.getassignmentInformationRushOrder().set(true);
		StoredVariables.getassignmentInformationComplex().set(true);
		StoredVariables.getassignmentInformationIssueAsBid().set(false);
		StoredVariables.getassignmentInformationOrderDue().set(7);
		perform.getNewDate(driver, StoredVariables.getassignmentInformationOrderDue().get());
		StoredVariables.getassignmentInformationOtherRefNumber().set(perform.randomNumbers(driver, 7));
		StoredVariables.getassignmentInformationLoanType().set("All In One");
		StoredVariables.getassignmentInformationLoanPurpose().set("Purchase");
		StoredVariables.getassignmentInformationOrderedBy().set("Borrower Name");
		StoredVariables.getassignmentInformationOrderGroup().set("AppraisersGroupTest");
		StoredVariables.getassignmentInformationLoanNumber().set(perform.randomNumbers(driver, 8));
		StoredVariables.getassignmentInformationFileNumber().set(perform.randomNumbers(driver, 5));
		StoredVariables.getassignmentInformationSalesPrice().set("645,715");
		StoredVariables.getassignmentInformationFHACaseNumber().set(perform.randomNumbers(driver, 6));
		StoredVariables.getassignmentInformationDisclosure().set(0);
		StoredVariables.getassignmentInformationAssignedTo().set("Automation Baseline2");
		
		// Set Lender Information data
		StoredVariables.getlenderInformationLenderName().set("BOKF, National Association");
		StoredVariables.getlenderInformationAddress1().set("One Williams Center");
		StoredVariables.getlenderInformationAddress2().set("Suite D");
		StoredVariables.getlenderInformationCity().set("Tulsa");
		StoredVariables.getlenderInformationState().set("OK");
		StoredVariables.getlenderInformationZip().set("74172");
		
		// Set Contact And Access Information data
		StoredVariables.getcontactOccupancy().set("Owner");
		StoredVariables.getcontactBorrower().set("Borrower Name");
		StoredVariables.getcontactBorrowerInfo1Dropdown().set("Home");
		StoredVariables.getcontactBorrowerInfo1().set("405-555-7818");
		StoredVariables.getcontactBorrowerInfo2Dropdown().set("E-mail");
		StoredVariables.getcontactBorrowerInfo2().set("borrower@dntest.net");
		StoredVariables.getcontactBorrowerAddress().set("8051 Falcon Crst");
		StoredVariables.getcontactBorrowerCity().set("Edmond");
		StoredVariables.getcontactBorrowerState().set("OK");
		StoredVariables.getcontactBorrowerZip().set("73034");
		StoredVariables.getcontactCoBorrower().set("Coborrower Name");
		StoredVariables.getcontactCoBorrowerInfo1Dropdown().set("Work");
		StoredVariables.getcontactCoBorrowerInfo1().set("405-555-9813");
		StoredVariables.getcontactCoBorrowerInfo2Dropdown().set("Mobile");
		StoredVariables.getcontactCoBorrowerInfo2().set("405-555-1679");
		StoredVariables.getcontactCoBorrowerAddress().set("1509 Rain Tree Dr");
		StoredVariables.getcontactCoBorrowerCity().set("Moore");
		StoredVariables.getcontactCoBorrowerState().set("OK");
		StoredVariables.getcontactCoBorrowerZip().set("73160");
		StoredVariables.getcontactOwner().set("Owner Name");
		StoredVariables.getcontactOwnerInfo1Dropdown().set("Pager");
		StoredVariables.getcontactOwnerInfo1().set("405-555-8618");
		StoredVariables.getcontactOwnerInfo2Dropdown().set("Fax");
		StoredVariables.getcontactOwnerInfo2().set("405-555-7410");
		StoredVariables.getcontactOccupant().set("Occupant Name");
		StoredVariables.getcontactOccupantInfo1Dropdown().set("Home");
		StoredVariables.getcontactOccupantInfo1().set("405-555-3549");
		StoredVariables.getcontactOccupantInfo2Dropdown().set("Mobile");
		StoredVariables.getcontactOccupantInfo2().set("405-555-8895");
		StoredVariables.getcontactAgent().set("Agent Name");
		StoredVariables.getcontactAgentInfo1Dropdown().set("E-mail");
		StoredVariables.getcontactAgentInfo1().set("agent@dntest.net");
		StoredVariables.getcontactAgentInfo2Dropdown().set("Pager");
		StoredVariables.getcontactAgentInfo2().set("405-555-4893");
		StoredVariables.getcontactOther().set("Other Name");
		StoredVariables.getcontactOtherInfo1Dropdown().set("Work");
		StoredVariables.getcontactOtherInfo1().set("405-555-7825");
		StoredVariables.getcontactOtherInfo2Dropdown().set("Fax");
		StoredVariables.getcontactOtherInfo2().set("405-555-8688");
		StoredVariables.getcontactApptContact().set("Borrower");
		
		// Set Additional Notification Recipients data
		StoredVariables.getadditionalNotificationRecipientsAdditionalEmails().set("additionalEmail1@dntest.net; additionalEmail2@dntest.net");
		StoredVariables.getadditionalNotificationRecipientsAttachCompletedReport().set(true);
		
		// Enter New Order data
		secure.enterNewCommercialAppraisalOrder(driver);
		
		// Click Next
		perform.click(driver, SNewOrder.next_btn(driver));
		
		// Assign vendor
		secure.selectVendor(driver, "Automation BaselineAppraiser2");
		
		// Verify Confirm Order url
		Assert.assertTrue(driver.getCurrentUrl().contains("ConfirmOrder"), "The Confirm Order screen did not load properly");
		
		// Verify order details
		secure.verifyOrderDetails(driver);
		
		// Click Next
		perform.click(driver, SConfirmOrder.nextBottom_btn(driver));
		
		// Get inside the attach document frame
		perform.switchToiFrameByID(driver, "iframeAttach");
		
		// Select document type
		perform.selectDropdownOption(driver, SConfirmOrder.documentType_dropdown(driver), "Other");
		
		// Wait for upload button
		perform.waitForElementToBeClickable(driver, SConfirmOrder.uploadDocuments_btn(), "id");
		
		// Upload Document
		String filePath = StoredVariables.getdocDir().get()+"Test PDF.pdf";
		secure.uploadDocumentOnSConfirmOrder(driver, filePath);
		
		// Click Close Button
		perform.click(driver, SConfirmOrder.finished_btn(driver));
		
		// Switch back to the attach documents frame
		driver.switchTo().defaultContent();
		
		// Wait for Orders page to load
		perform.waitForElementToBeClickable(driver, SOrders.find_txtbx(), "id");
		
		// Verify you land on the orders grid
		Assert.assertTrue(driver.getCurrentUrl().contains("OrderManagement"), "After completing an order, the orders grid did not load");
		
		// Query the db to get the order number that was just created
		db.getLoanID(driver);
		
		// Log order number to extent reports
		test.log(LogStatus.INFO, "Info", "Order Number: " + StoredVariables.getloanID().get());
		
		// Wait for the Order Types dropdown
		perform.waitForElementToBeClickable(driver, SOrders.orderTypes_dropdown(), "id");

		// Search for new order
		secure.findOrder(driver, StoredVariables.getloanID().get(), "Tracking number");
		
		// Verify the order is in the correct status
		Assert.assertTrue(SOrders.ordersTable_txt(driver).getText().contains("Awaiting acceptance"), "The order is not in the correct status");
		
		// Verify the order just created is in the orders grid 
		Assert.assertTrue(SOrders.ordersTable_txt(driver).getText().contains(StoredVariables.getloanID().get()), "New order is not displayed");
		
		// Verify data in the database
		db.verifyNewOrderDataInDB_All(driver, StoredVariables.getloanID().get());
		
		// Open the order
		secure.openOrder(driver, StoredVariables.getloanID().get());
		
		// Verify there is no Statement of Engagement attached to the order
		Assert.assertTrue(!SOrderDetails.orderDocuments_txt(driver).getText().contains("Engage"), "There should not be a Statement of Engagement on this order");
		
		// Log test
		test.log(LogStatus.INFO, "Orders", "Created new Commercial Appraisal order on Secure");
		
	} // end createNewCommercialAppraisalNoBidOrder
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Go to Vendor Selection Settings</li>
	 * 	<li>Turn off Double-blind Communication switch</li>
	 * 	<li>Disable Automatic Vendor Selection</li>
	 * 	<li>Select Custom Fee Panel</li>
	 * 	<li>Uncheck Use Mercury Network Directory as backup checkbox</li>
	 * 	<li>Verify Mercury Network Directory as backup is unchecked</li>
	 * 	<li>Save Preferences</li>
	 * 	<li>Click OK in saved dialog box</li>
	 * 	<li>Go to Inspection</li>
	 * 	<li>Set Property Information data</li>
	 * 	<li>StoredVariables.getpropertyInformationStateAbbr().set("OK");  Must set for a field check later on</li>
	 * 	<li>Set Assignment Information data</li>
	 * 	<li>Set Lender Information data</li>
	 * 	<li>Set Contact And Access Information data</li>
	 * 	<li>Set Additional Notification Recipients data</li>
	 * 	<li>Enter New Order data</li>
	 * 	<li>Click Next</li>
	 * 	<li>Assign vendor</li>
	 * 	<li>Verify Confirm Order url</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Click Next</li>
	 * 	<li>Get inside the attach document frame</li>
	 * 	<li>Select document type</li>
	 * 	<li>Upload Document</li>
	 * 	<li>Click Close Button</li>
	 * 	<li>Switch back to the attach documents frame</li>
	 * 	<li>Verify you land on the orders grid</li>
	 * 	<li>Query the db to get the order number that was just created</li>
	 * 	<li>Search for new order</li>
	 * 	<li>Verify the order is in the correct status</li>
	 * 	<li>Verify the order just created is in the orders grid</li>
	 * 	<li>Verify data in the database</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Orders", "Secure - Create Inspection Order", "Secure - Vendor Selection Settings"}, alwaysRun=true)
	public void createNewInspectionOrder() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Login to Secure
		secure.login(driver, user, StoredVariables.getpassword().get());
		
		// Go to Vendor Selection Settings
		secure.goToVendorSelectionSettings(driver);
		
		// Turn off Double-blind Communication switch
		if (!SVendorSelectionSettings.doubleBlind_switch(driver).getAttribute("src").contains("switchOff.png"))
		{
			perform.click(driver, SVendorSelectionSettings.doubleBlind_switch(driver));
		}
		
		// Disable Automatic Vendor Selection
		if (SVendorSelectionSettings.automaticOrderAssignment_switch(driver).getAttribute("src").contains("switchOn.png"))
		{
			perform.click(driver, SVendorSelectionSettings.automaticOrderAssignment_switch(driver));
		}
		
		// Select Custom Fee Panel
		perform.click(driver, SVendorSelectionSettings.customFeePanel_radio(driver));
		
		// Uncheck Use Mercury Network Directory as backup checkbox
		if (SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver).isSelected())
		{
			perform.click(driver, SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver));
		}
		
		// Verify Mercury Network Directory as backup is unchecked
		Assert.assertTrue(SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver).isSelected()==false, "Mercury Network Directory as backup is still checked");
		
		// Save Preferences
		perform.click(driver, SVendorSelectionSettings.save_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for the OK button to be visible
		perform.waitForElementToBeClickable(driver, SVendorSelectionSettings.ok_btn(), "id");
		
		// Click OK in saved dialog box
		perform.click(driver, SVendorSelectionSettings.ok_btn(driver));
		
		// Go to Inspection
		secure.goToInspection(driver);
		
		/***************************************
		 * Set New Order Information
		 ***************************************/
		
		// Set Property Information data
		StoredVariables.getpropertyInformationAddress().set("501-D NE 122nd St");
		StoredVariables.getpropertyInformationCity().set("Oklahoma City");
		StoredVariables.getpropertyInformationState().set("Oklahoma");
		StoredVariables.getpropertyInformationStateAbbr().set("OK"); // Must set for a field check later on
		StoredVariables.getpropertyInformationZip().set("73114");
		StoredVariables.getpropertyInformationSqFt().set("5688");
		StoredVariables.getpropertyInformationSiteSize().set("9,583 sq ft");
		StoredVariables.getpropertyInformationPropType().set("Single Family");
		StoredVariables.getpropertyInformationPropRights().set("Fee Simple");
		StoredVariables.getpropertyInformationLegalDesc().set("501-D NE 122nd St");
		StoredVariables.getpropertyInformationDirections().set(perform.randomNumbers(driver, 8));
		
		// Set Assignment Information data
		StoredVariables.getassignmentInformationForm().set("General Property Inspection (no form specified)");
		StoredVariables.getassignmentInformationRushOrder().set(true);
		StoredVariables.getassignmentInformationComplex().set(true);
		StoredVariables.getassignmentInformationOrderDue().set(7);
		perform.getNewDate(driver, StoredVariables.getassignmentInformationOrderDue().get());
		StoredVariables.getassignmentInformationOtherRefNumber().set(perform.randomNumbers(driver, 7));
		StoredVariables.getassignmentInformationLoanType().set("All In One");
		StoredVariables.getassignmentInformationLoanPurpose().set("Purchase");
		StoredVariables.getassignmentInformationOrderedBy().set("Borrower Name");
		StoredVariables.getassignmentInformationOrderGroup().set("AppraisersGroupTest");
		StoredVariables.getassignmentInformationLoanNumber().set(perform.randomNumbers(driver, 8));
		StoredVariables.getassignmentInformationFileNumber().set(perform.randomNumbers(driver, 5));
		StoredVariables.getassignmentInformationSalesPrice().set("645,715");
		StoredVariables.getassignmentInformationFHACaseNumber().set(perform.randomNumbers(driver, 6));
		StoredVariables.getassignmentInformationDisclosure().set(0);
		StoredVariables.getassignmentInformationAssignedTo().set("Automation Baseline2");
		
		// Set Lender Information data
		StoredVariables.getlenderInformationLenderName().set("BOKF, National Association");
		StoredVariables.getlenderInformationAddress1().set("One Williams Center");
		StoredVariables.getlenderInformationAddress2().set("Suite D");
		StoredVariables.getlenderInformationCity().set("Tulsa");
		StoredVariables.getlenderInformationState().set("OK");
		StoredVariables.getlenderInformationZip().set("74172");
		
		// Set Contact And Access Information data
		StoredVariables.getcontactOccupancy().set("Owner");
		StoredVariables.getcontactBorrower().set("Borrower Name");
		StoredVariables.getcontactBorrowerInfo1Dropdown().set("Home");
		StoredVariables.getcontactBorrowerInfo1().set("405-555-7818");
		StoredVariables.getcontactBorrowerInfo2Dropdown().set("E-mail");
		StoredVariables.getcontactBorrowerInfo2().set("borrower@dntest.net");
		StoredVariables.getcontactBorrowerAddress().set("8051 Falcon Crst");
		StoredVariables.getcontactBorrowerCity().set("Edmond");
		StoredVariables.getcontactBorrowerState().set("OK");
		StoredVariables.getcontactBorrowerZip().set("73034");
		StoredVariables.getcontactCoBorrower().set("Coborrower Name");
		StoredVariables.getcontactCoBorrowerInfo1Dropdown().set("Work");
		StoredVariables.getcontactCoBorrowerInfo1().set("405-555-9813");
		StoredVariables.getcontactCoBorrowerInfo2Dropdown().set("Mobile");
		StoredVariables.getcontactCoBorrowerInfo2().set("405-555-1679");
		StoredVariables.getcontactCoBorrowerAddress().set("1509 Rain Tree Dr");
		StoredVariables.getcontactCoBorrowerCity().set("Moore");
		StoredVariables.getcontactCoBorrowerState().set("OK");
		StoredVariables.getcontactCoBorrowerZip().set("73160");
		StoredVariables.getcontactOwner().set("Owner Name");
		StoredVariables.getcontactOwnerInfo1Dropdown().set("Pager");
		StoredVariables.getcontactOwnerInfo1().set("405-555-8618");
		StoredVariables.getcontactOwnerInfo2Dropdown().set("Fax");
		StoredVariables.getcontactOwnerInfo2().set("405-555-7410");
		StoredVariables.getcontactOccupant().set("Occupant Name");
		StoredVariables.getcontactOccupantInfo1Dropdown().set("Home");
		StoredVariables.getcontactOccupantInfo1().set("405-555-3549");
		StoredVariables.getcontactOccupantInfo2Dropdown().set("Mobile");
		StoredVariables.getcontactOccupantInfo2().set("405-555-8895");
		StoredVariables.getcontactAgent().set("Agent Name");
		StoredVariables.getcontactAgentInfo1Dropdown().set("E-mail");
		StoredVariables.getcontactAgentInfo1().set("agent@dntest.net");
		StoredVariables.getcontactAgentInfo2Dropdown().set("Pager");
		StoredVariables.getcontactAgentInfo2().set("405-555-4893");
		StoredVariables.getcontactOther().set("Other Name");
		StoredVariables.getcontactOtherInfo1Dropdown().set("Work");
		StoredVariables.getcontactOtherInfo1().set("405-555-7825");
		StoredVariables.getcontactOtherInfo2Dropdown().set("Fax");
		StoredVariables.getcontactOtherInfo2().set("405-555-8688");
		StoredVariables.getcontactApptContact().set("Borrower");
		
		// Set Additional Notification Recipients data
		StoredVariables.getadditionalNotificationRecipientsAdditionalEmails().set("additionalEmail1@dntest.net; additionalEmail2@dntest.net");
		StoredVariables.getadditionalNotificationRecipientsAttachCompletedReport().set(true);
		
		// Enter New Order data
		secure.enterNewResidentialAppraisalOrder(driver);
		
		// Click Next
		perform.click(driver, SNewOrder.next_btn(driver));
		
		// Assign vendor
		secure.selectVendor(driver, "Automation BaselineAppraiser2");
		
		// Verify Confirm Order url
		Assert.assertTrue(driver.getCurrentUrl().contains("ConfirmOrder"), "The Confirm Order screen did not load properly");
		
		// Verify order details
		secure.verifyOrderDetails(driver);
		
		// Click Next
		perform.click(driver, SConfirmOrder.nextBottom_btn(driver));
		
		// Get inside the attach document frame
		perform.switchToiFrameByID(driver, "iframeAttach");
		
		// Select document type
		perform.selectDropdownOption(driver, SConfirmOrder.documentType_dropdown(driver), "Other");
		
		// Wait for upload button
		perform.waitForElementToBeClickable(driver, SConfirmOrder.uploadDocuments_btn(), "id");
		
		// Upload Document
		String filePath = StoredVariables.getdocDir().get()+"Test PDF.pdf";
		secure.uploadDocumentOnSConfirmOrder(driver, filePath);
		
		// Click Close Button
		perform.click(driver, SConfirmOrder.finished_btn(driver));
		
		// Switch back to the attach documents frame
		driver.switchTo().defaultContent();
		
		// Wait for Orders page to load
		perform.waitForElementToBeClickable(driver, SOrders.find_txtbx(), "id");
		
		// Verify you land on the orders grid
		Assert.assertTrue(driver.getCurrentUrl().contains("OrderManagement"), "After completing an order, the orders grid did not load");
		
		// Query the db to get the order number that was just created
		db.getLoanID(driver);
		
		// Log order number to extent reports
		test.log(LogStatus.INFO, "Info", "Order Number: " + StoredVariables.getloanID().get());
		
		// Wait for the Order Types dropdown
		perform.waitForElementToBeClickable(driver, SOrders.orderTypes_dropdown(), "id");

		// Search for new order
		secure.findOrder(driver, StoredVariables.getloanID().get(), "Tracking number");
		
		// Verify the order is in the correct status
		Assert.assertTrue(SOrders.ordersTable_txt(driver).getText().contains("Awaiting acceptance"), "The order is not in the correct status");
		
		// Verify the order just created is in the orders grid 
		Assert.assertTrue(SOrders.ordersTable_txt(driver).getText().contains(StoredVariables.getloanID().get()), "New order is not displayed");
		
		// Verify data in the database
		db.verifyNewOrderDataInDB_All(driver, StoredVariables.getloanID().get());
		
		// Log test
		test.log(LogStatus.INFO, "Orders", "Created new Inspection order on Secure");
		
	} // end createNewInspectionOrder
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Go to Vendor Selection Settings</li>
	 * 	<li>Turn off Double-blind Communication switch</li>
	 * 	<li>Disable Automatic Vendor Selection</li>
	 * 	<li>Select Custom Fee Panel</li>
	 * 	<li>Uncheck Use Mercury Network Directory as backup checkbox</li>
	 * 	<li>Verify Mercury Network Directory as backup is unchecked</li>
	 * 	<li>Save Preferences</li>
	 * 	<li>Click OK in saved dialog box</li>
	 * 	<li>Go to Broker Price Opinion</li>
	 * 	<li>Set Property Information data</li>
	 * 	<li>StoredVariables.getpropertyInformationStateAbbr().set("OK");  Must set for a field check later on</li>
	 * 	<li>Set Assignment Information data</li>
	 * 	<li>Set Lender Information data</li>
	 * 	<li>Set Contact And Access Information data</li>
	 * 	<li>Set Additional Notification Recipients data</li>
	 * 	<li>Enter New Order data</li>
	 * 	<li>Click Next</li>
	 * 	<li>Assign vendor</li>
	 * 	<li>Verify Confirm Order url</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Click Next</li>
	 * 	<li>Get inside the attach document frame</li>
	 * 	<li>Select document type</li>
	 * 	<li>Upload Document</li>
	 * 	<li>Click Close Button</li>
	 * 	<li>Switch back to the attach documents frame</li>
	 * 	<li>Verify you land on the orders grid</li>
	 * 	<li>Query the db to get the order number that was just created</li>
	 * 	<li>Search for new order</li>
	 * 	<li>Verify the order is in the correct status</li>
	 * 	<li>Verify the order just created is in the orders grid</li>
	 * 	<li>Verify data in the database</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Orders", "Secure - Create Broker Price Opinion Order", "Secure - Vendor Selection Settings"}, alwaysRun=true)
	public void createNewBrokerPriceOpinionOrder() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Login to Secure
		secure.login(driver, user, StoredVariables.getpassword().get());
		
		// Go to Vendor Selection Settings
		secure.goToVendorSelectionSettings(driver);
		
		// Turn off Double-blind Communication switch
		if (!SVendorSelectionSettings.doubleBlind_switch(driver).getAttribute("src").contains("switchOff.png"))
		{
			perform.click(driver, SVendorSelectionSettings.doubleBlind_switch(driver));
		}
		
		// Disable Automatic Vendor Selection
		if (SVendorSelectionSettings.automaticOrderAssignment_switch(driver).getAttribute("src").contains("switchOn.png"))
		{
			perform.click(driver, SVendorSelectionSettings.automaticOrderAssignment_switch(driver));
		}
		
		// Select Custom Fee Panel
		perform.click(driver, SVendorSelectionSettings.customFeePanel_radio(driver));
		
		// Uncheck Use Mercury Network Directory as backup checkbox
		if (SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver).isSelected())
		{
			perform.click(driver, SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver));
		}
		
		// Verify Mercury Network Directory as backup is unchecked
		Assert.assertTrue(SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver).isSelected()==false, "Mercury Network Directory as backup is still checked");
		
		// Save Preferences
		perform.click(driver, SVendorSelectionSettings.save_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for the OK button to be visible
		perform.waitForElementToBeClickable(driver, SVendorSelectionSettings.ok_btn(), "id");
		
		// Click OK in saved dialog box
		perform.click(driver, SVendorSelectionSettings.ok_btn(driver));
		
		// Go to Broker Price Opinion
		secure.goToBrokerPriceOpinion(driver);
		
		/***************************************
		 * Set New Order Information
		 ***************************************/
		
		// Set Property Information data
		StoredVariables.getpropertyInformationAddress().set("501-D NE 122nd St");
		StoredVariables.getpropertyInformationCity().set("Oklahoma City");
		StoredVariables.getpropertyInformationState().set("Oklahoma");
		StoredVariables.getpropertyInformationStateAbbr().set("OK"); // Must set for a field check later on
		StoredVariables.getpropertyInformationZip().set("73114");
		StoredVariables.getpropertyInformationSqFt().set("5688");
		StoredVariables.getpropertyInformationSiteSize().set("9,583 sq ft");
		StoredVariables.getpropertyInformationPropType().set("Other");
		StoredVariables.getpropertyInformationLegalDesc().set("501-D NE 122nd St");
		StoredVariables.getpropertyInformationDirections().set(perform.randomNumbers(driver, 8));
		
		// Set Assignment Information data
		StoredVariables.getassignmentInformationForm().set("Broker Price Opinion Drive by");
		StoredVariables.getassignmentInformationRushOrder().set(true);
		StoredVariables.getassignmentInformationComplex().set(true);
		StoredVariables.getassignmentInformationOrderDue().set(7);
		perform.getNewDate(driver, StoredVariables.getassignmentInformationOrderDue().get());
		StoredVariables.getassignmentInformationOtherRefNumber().set(perform.randomNumbers(driver, 7));
		StoredVariables.getassignmentInformationLoanType().set("All In One");
		StoredVariables.getassignmentInformationLoanPurpose().set("Purchase");
		StoredVariables.getassignmentInformationOrderedBy().set("Borrower Name");
		StoredVariables.getassignmentInformationOrderGroup().set("AppraisersGroupTest");
		StoredVariables.getassignmentInformationLoanNumber().set(perform.randomNumbers(driver, 8));
		StoredVariables.getassignmentInformationFileNumber().set(perform.randomNumbers(driver, 5));
		StoredVariables.getassignmentInformationSalesPrice().set("645,715");
		StoredVariables.getassignmentInformationFHACaseNumber().set(perform.randomNumbers(driver, 6));
		StoredVariables.getassignmentInformationDisclosure().set(0);
		StoredVariables.getassignmentInformationAssignedTo().set("Automation Baseline2");
		
		// Set Lender Information data
		StoredVariables.getlenderInformationLenderName().set("BOKF, National Association");
		StoredVariables.getlenderInformationAddress1().set("One Williams Center");
		StoredVariables.getlenderInformationAddress2().set("Suite D");
		StoredVariables.getlenderInformationCity().set("Tulsa");
		StoredVariables.getlenderInformationState().set("OK");
		StoredVariables.getlenderInformationZip().set("74172");
		
		// Set Contact And Access Information data
		StoredVariables.getcontactOccupancy().set("Owner");
		StoredVariables.getcontactBorrower().set("Borrower Name");
		StoredVariables.getcontactBorrowerInfo1Dropdown().set("Home");
		StoredVariables.getcontactBorrowerInfo1().set("405-555-7818");
		StoredVariables.getcontactBorrowerInfo2Dropdown().set("E-mail");
		StoredVariables.getcontactBorrowerInfo2().set("borrower@dntest.net");
		StoredVariables.getcontactBorrowerAddress().set("8051 Falcon Crst");
		StoredVariables.getcontactBorrowerCity().set("Edmond");
		StoredVariables.getcontactBorrowerState().set("OK");
		StoredVariables.getcontactBorrowerZip().set("73034");
		StoredVariables.getcontactCoBorrower().set("Coborrower Name");
		StoredVariables.getcontactCoBorrowerInfo1Dropdown().set("Work");
		StoredVariables.getcontactCoBorrowerInfo1().set("405-555-9813");
		StoredVariables.getcontactCoBorrowerInfo2Dropdown().set("Mobile");
		StoredVariables.getcontactCoBorrowerInfo2().set("405-555-1679");
		StoredVariables.getcontactCoBorrowerAddress().set("1509 Rain Tree Dr");
		StoredVariables.getcontactCoBorrowerCity().set("Moore");
		StoredVariables.getcontactCoBorrowerState().set("OK");
		StoredVariables.getcontactCoBorrowerZip().set("73160");
		StoredVariables.getcontactOwner().set("Owner Name");
		StoredVariables.getcontactOwnerInfo1Dropdown().set("Pager");
		StoredVariables.getcontactOwnerInfo1().set("405-555-8618");
		StoredVariables.getcontactOwnerInfo2Dropdown().set("Fax");
		StoredVariables.getcontactOwnerInfo2().set("405-555-7410");
		StoredVariables.getcontactOccupant().set("Occupant Name");
		StoredVariables.getcontactOccupantInfo1Dropdown().set("Home");
		StoredVariables.getcontactOccupantInfo1().set("405-555-3549");
		StoredVariables.getcontactOccupantInfo2Dropdown().set("Mobile");
		StoredVariables.getcontactOccupantInfo2().set("405-555-8895");
		StoredVariables.getcontactAgent().set("Agent Name");
		StoredVariables.getcontactAgentInfo1Dropdown().set("E-mail");
		StoredVariables.getcontactAgentInfo1().set("agent@dntest.net");
		StoredVariables.getcontactAgentInfo2Dropdown().set("Pager");
		StoredVariables.getcontactAgentInfo2().set("405-555-4893");
		StoredVariables.getcontactOther().set("Other Name");
		StoredVariables.getcontactOtherInfo1Dropdown().set("Work");
		StoredVariables.getcontactOtherInfo1().set("405-555-7825");
		StoredVariables.getcontactOtherInfo2Dropdown().set("Fax");
		StoredVariables.getcontactOtherInfo2().set("405-555-8688");
		StoredVariables.getcontactApptContact().set("Borrower");
		
		// Set Additional Notification Recipients data
		StoredVariables.getadditionalNotificationRecipientsAdditionalEmails().set("additionalEmail1@dntest.net; additionalEmail2@dntest.net");
		StoredVariables.getadditionalNotificationRecipientsAttachCompletedReport().set(true);
		
		// Enter New Order data
		secure.enterNewResidentialAppraisalOrder(driver);
		
		// Click Next
		perform.click(driver, SNewOrder.next_btn(driver));
		
		// Assign vendor
		secure.selectVendor(driver, "Automation BaselineAppraiser2");
		
		// Verify Confirm Order url
		Assert.assertTrue(driver.getCurrentUrl().contains("ConfirmOrder"), "The Confirm Order screen did not load properly");
		
		// Verify order details
		secure.verifyOrderDetails(driver);
		
		Thread.sleep(5000);
		
		// Wait for Next button
		perform.waitForElementToBeClickable(driver, SConfirmOrder.nextBottom_btn(), "id");
		
		// Click Next
		perform.click(driver, SConfirmOrder.nextBottom_btn(driver));
		
		// Get inside the attach document frame
		perform.switchToiFrameByID(driver, "iframeAttach");
		
		// Select document type
		perform.selectDropdownOption(driver, SConfirmOrder.documentType_dropdown(driver), "Other");
		
		// Wait for upload button
		perform.waitForElementToBeClickable(driver, SConfirmOrder.uploadDocuments_btn(), "id");
		
		// Upload Document
		String filePath = StoredVariables.getdocDir().get()+"Test PDF.pdf";
		secure.uploadDocumentOnSConfirmOrder(driver, filePath);
		
		// Click Close Button
		perform.click(driver, SConfirmOrder.finished_btn(driver));
		
		// Switch back to the attach documents frame
		driver.switchTo().defaultContent();
		
		// Wait for Orders page to load
		perform.waitForElementToBeClickable(driver, SOrders.find_txtbx(), "id");
		
		// Verify you land on the orders grid
		Assert.assertTrue(driver.getCurrentUrl().contains("OrderManagement"), "After completing an order, the orders grid did not load");
		
		// Query the db to get the order number that was just created
		db.getLoanID(driver);
		
		// Log order number to extent reports
		test.log(LogStatus.INFO, "Info", "Order Number: " + StoredVariables.getloanID().get());
		
		// Wait for the Order Types dropdown
		perform.waitForElementToBeClickable(driver, SOrders.orderTypes_dropdown(), "id");

		// Search for new order
		secure.findOrder(driver, StoredVariables.getloanID().get(), "Tracking number");
		
		// Verify the order is in the correct status
		Assert.assertTrue(SOrders.ordersTable_txt(driver).getText().contains("Awaiting acceptance"), "The order is not in the correct status");
		
		// Verify the order just created is in the orders grid 
		Assert.assertTrue(SOrders.ordersTable_txt(driver).getText().contains(StoredVariables.getloanID().get()), "New order is not displayed");
		
		// Verify data in the database
		db.verifyNewOrderDataInDB_All(driver, StoredVariables.getloanID().get());
		
		// Log test
		test.log(LogStatus.INFO, "Orders", "Created new Broker Price Opinion order on Secure");
		
	} // end createNewBrokerPriceOpinionOrder
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Click on an order that requires assignment</li>
	 * 	<li>Click View</li>
	 * 	<li>Verify the tracking number is displayed</li>
	 * 	<li>Verify url contains OrderDetails.aspx</li>
	 * 	<li>Verify the Zillow link</li>
	 * 	<li>Click Reassign</li>
	 * 	<li>Click calendar button</li>
	 * 	<li>Click OK</li>
	 * 	<li>Check for related orders</li>
	 * 	<li>Click the expand map button</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Orders"}, alwaysRun=true)
	public void view() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Login to Secure
		secure.login(driver, user, StoredVariables.getpassword().get());
		
		// Click on an order that requires assignment
		perform.clickInTable_Contains(driver, "Requires assignment");
		
		// Click View
		perform.clickInTable_Contains(driver, "View");
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for reassign button
		perform.waitForElementToBeClickable(driver, SOrderDetails.reassign_btn(driver));
		
		// Verify the tracking number is displayed
		Assert.assertTrue(!SOrderDetails.trackingNumber_txt(driver).getText().isEmpty(), "Tracking number is not displayed correctly. The screen is displaying = " + SOrderDetails.trackingNumber_txt(driver).getText());
		
		// Verify url contains OrderDetails.aspx
		Assert.assertTrue(driver.getCurrentUrl().contains("OrderDetails.aspx"), "URL is incorrect. = " + driver.getCurrentUrl());
		
		// Wait for Zoom out button on map
		perform.waitForElementToBeClickable(driver, SOrderDetails.zoomOut_btn(driver));
		
		// Verify the Zillow link
		secure.verifyZillowLink(driver);
		
		// Click Reassign
		perform.click(driver, SOrderDetails.reassign_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		int size = driver.findElements(By.id(SOrderDetails.okDueDate_btn())).size();
		if (size > 0) {
			// Click calendar button
			perform.click(driver, driver.findElement(By.id("Dialogs_Dialogs_imgDueDateCalendar")));
			secure.selectDateFromCalendarExpiredDueDate(driver, 3);
			// Click OK
			perform.click(driver, SOrderDetails.okDueDate_btn(driver));
		} // end if
		
		// Check for related orders
		secure.checkForRelatedOrdersDialog(driver);
		
		// Click the expand map button
		perform.click(driver, SVendorSelection.expandMap_btn(driver));
		
		// Wait for the zoom out button
		perform.waitForElementToBeClickable(driver, SOrderDetails.zoomOut_btn(driver));
		
		// Log test
		test.log(LogStatus.INFO, "Orders", "Used the View button to view an order");
		
	} // end view
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Click to Preferences</li>
	 * 	<li>Select Vendor Selection Settings</li>
	 * 	<li>Turn off Double-blind Communication switch</li>
	 * 	<li>Disable Automatic Vendor Selection</li>
	 * 	<li>Select Custom Fee Panel</li>
	 * 	<li>Uncheck Use Mercury Network Directory as backup checkbox</li>
	 * 	<li>Verify Mercury Network Directory as backup is unchecked</li>
	 * 	<li>Save Preferences</li>
	 * 	<li>Click OK in saved dialog box</li>
	 * 	<li>Go to Residential Appraisal</li>
	 * 	<li>Set Property Information data</li>
	 * 	<li>StoredVariables.getpropertyInformationStateAbbr().set("OK");  Must set for a field check later on</li>
	 * 	<li>Set Assignment Information data</li>
	 * 	<li>Set Lender Information data</li>
	 * 	<li>Set Contact And Access Information data</li>
	 * 	<li>Set Additional Notification Recipients data</li>
	 * 	<li>Enter New Order data</li>
	 * 	<li>Click Next</li>
	 * 	<li>Assign vendor</li>
	 * 	<li>Confirm order screen loads</li>
	 * 	<li>Verify data displays properly</li>
	 * 	<li>Verify the 'I have read and understand the vendor's fee notes' checkbox is unchecked</li>
	 * 	<li>Click Next</li>
	 * 	<li>Verify popup displays with correct text</li>
	 * 	<li>Click OK</li>
	 * 	<li>Check the agree to notes checkbox</li>
	 * 	<li>Change payment method to check</li>
	 * 	<li>Click Next</li>
	 * 	<li>Get inside the attach document frame</li>
	 * 	<li>Select document type</li>
	 * 	<li>Upload Document</li>
	 * 	<li>Click Close Button</li>
	 * 	<li>Switch back to the attach documents frame</li>
	 * 	<li>Verify you land on the orders grid</li>
	 * 	<li>Query the db to get the order number that was just created</li>
	 * 	<li>Verify Due date is ordered properly to display the most recent order first</li>
	 * 	<li>Verify the order just created is in the orders grid</li>
	 * 	<li>Verify data in the database</li>
	 * 	<li>Log in as the vendor</li>
	 * 	<li>Search for the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Click the Accept button</li>
	 * 	<li>Allow popup time to load</li>
	 * 	<li>Select Propose Conditions to Client from Select Action dropdown</li>
	 * 	<li>Enter notes</li>
	 * 	<li>Click OK</li>
	 * 	<li>Click OK on acknowledgement</li>
	 * 	<li>Complete the order using the HTTP Post</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Search for new order</li>
	 * 	<li>Select the order in the table</li>
	 * 	<li>Click Payments</li>
	 * 	<li>Verify tracking number is displayed</li>
	 * 	<li>Select method</li>
	 * 	<li>Enter check number</li>
	 * 	<li>Enter invoice number</li>
	 * 	<li>Enter notes</li>
	 * 	<li>Select the Notify vendor of payment checkbox</li>
	 * 	<li>Click Save</li>
	 * 	<li>Click Close</li>
	 * 	<li>Get outside frames</li>
	 * 	<li>Search for new order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Verify payment in history</li>
	 * 	<li>Log test</li>
* </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Vendor Selection Settings", "Secure - Orders", "Secure - Create Residential Appraisal Order", "Vendors - Orders", "Vendors - Accept Order", "Vendors - Complete Order", "Secure - Payments"}, alwaysRun=true)
	public void payment() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Login to Secure
		secure.login(driver, user, StoredVariables.getpassword().get());
		
		// Wait for the Preferences button to be visible
		perform.waitForElementToBeClickable(driver, SOrders.preferences_btn(), "id");
		
		// Click to Preferences
		perform.click(driver, SOrders.preferences_btn(driver));
		
		// Select Vendor Selection Settings
		perform.click(driver, SPreferences.vendorSelectionSettings_btn(driver));
		
		// Turn off Double-blind Communication switch
		if (!SVendorSelectionSettings.doubleBlind_switch(driver).getAttribute("src").contains("switchOff.png"))
		{
			perform.click(driver, SVendorSelectionSettings.doubleBlind_switch(driver));
		}
		
		// Disable Automatic Vendor Selection
		if (SVendorSelectionSettings.automaticOrderAssignment_switch(driver).getAttribute("src").contains("switchOn.png"))
		{
			perform.click(driver, SVendorSelectionSettings.automaticOrderAssignment_switch(driver));
		}
		
		// Select Custom Fee Panel
		perform.click(driver, SVendorSelectionSettings.customFeePanel_radio(driver));
		
		// Uncheck Use Mercury Network Directory as backup checkbox
		if (SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver).isSelected())
		{
			perform.click(driver, SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver));
		}
		
		// Verify Mercury Network Directory as backup is unchecked
		Assert.assertTrue(SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver).isSelected()==false, "Mercury Network Directory as backup is still checked");
		
		// Save Preferences
		perform.click(driver, SVendorSelectionSettings.save_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for the OK button to be visible
		perform.waitForElementToBeClickable(driver, SVendorSelectionSettings.ok_btn(), "id");
		
		// Click OK in saved dialog box
		perform.click(driver, SVendorSelectionSettings.ok_btn(driver));
		
		// Go to Residential Appraisal
		secure.goToResidentialAppraisal(driver);
		
		/***************************************
		 * Set New Order Information
		 ***************************************/
		
		// Set Property Information data
		StoredVariables.getpropertyInformationAddress().set("2621 SW 136th St");
		StoredVariables.getpropertyInformationCity().set("Oklahoma City");
		StoredVariables.getpropertyInformationState().set("Oklahoma");
		StoredVariables.getpropertyInformationStateAbbr().set("OK"); // Must set for a field check later on
		StoredVariables.getpropertyInformationZip().set("73170");
		StoredVariables.getpropertyInformationSqFt().set("3697");
		StoredVariables.getpropertyInformationSiteSize().set("9,583 sq ft");
		StoredVariables.getpropertyInformationPropType().set("Single Family");
		StoredVariables.getpropertyInformationPropRights().set("Fee Simple");
		StoredVariables.getpropertyInformationLegalDesc().set("2844 Guilford Ln, Oklahoma City, OK 73120");
		StoredVariables.getpropertyInformationDirections().set("East of N May Ave and south of NW Britton Rd");
		
		// Set Assignment Information data
		StoredVariables.getassignmentInformationForm().set("Uniform Residential Appraisal (FNMA 1004)");
		StoredVariables.getassignmentInformationRushOrder().set(true);
		StoredVariables.getassignmentInformationComplex().set(true);
		StoredVariables.getassignmentInformationOrderDue().set(7);
		perform.getNewDate(driver, StoredVariables.getassignmentInformationOrderDue().get());
		StoredVariables.getassignmentInformationOtherRefNumber().set("8615406");
		StoredVariables.getassignmentInformationLoanType().set("All In One");
		StoredVariables.getassignmentInformationLoanPurpose().set("Purchase");
		StoredVariables.getassignmentInformationOrderedBy().set("Borrower Name");
		StoredVariables.getassignmentInformationOrderGroup().set("AppraisersGroupTest");
		StoredVariables.getassignmentInformationLoanNumber().set("74108641");
		StoredVariables.getassignmentInformationFileNumber().set("31849");
		StoredVariables.getassignmentInformationSalesPrice().set("645,715");
		StoredVariables.getassignmentInformationFHACaseNumber().set("564193");
		StoredVariables.getassignmentInformationDisclosure().set(0);
		StoredVariables.getassignmentInformationAssignedTo().set("Automation Baseline2");
		
		// Set Lender Information data
		StoredVariables.getlenderInformationLenderName().set("BOKF, National Association");
		StoredVariables.getlenderInformationAddress1().set("One Williams Center");
		StoredVariables.getlenderInformationAddress2().set("Suite D");
		StoredVariables.getlenderInformationCity().set("Tulsa");
		StoredVariables.getlenderInformationState().set("OK");
		StoredVariables.getlenderInformationZip().set("74172");
		
		// Set Contact And Access Information data
		StoredVariables.getcontactOccupancy().set("Owner");
		StoredVariables.getcontactBorrower().set("Borrower Name");
		StoredVariables.getcontactBorrowerInfo1Dropdown().set("Home");
		StoredVariables.getcontactBorrowerInfo1().set("405-555-7818");
		StoredVariables.getcontactBorrowerInfo2Dropdown().set("E-mail");
		StoredVariables.getcontactBorrowerInfo2().set("borrower@dntest.net");
		StoredVariables.getcontactBorrowerAddress().set("8051 Falcon Crst");
		StoredVariables.getcontactBorrowerCity().set("Edmond");
		StoredVariables.getcontactBorrowerState().set("OK");
		StoredVariables.getcontactBorrowerZip().set("73034");
		StoredVariables.getcontactCoBorrower().set("Coborrower Name");
		StoredVariables.getcontactCoBorrowerInfo1Dropdown().set("Work");
		StoredVariables.getcontactCoBorrowerInfo1().set("405-555-9813");
		StoredVariables.getcontactCoBorrowerInfo2Dropdown().set("Mobile");
		StoredVariables.getcontactCoBorrowerInfo2().set("405-555-1679");
		StoredVariables.getcontactCoBorrowerAddress().set("1509 Rain Tree Dr");
		StoredVariables.getcontactCoBorrowerCity().set("Moore");
		StoredVariables.getcontactCoBorrowerState().set("OK");
		StoredVariables.getcontactCoBorrowerZip().set("73160");
		StoredVariables.getcontactOwner().set("Owner Name");
		StoredVariables.getcontactOwnerInfo1Dropdown().set("Pager");
		StoredVariables.getcontactOwnerInfo1().set("405-555-8618");
		StoredVariables.getcontactOwnerInfo2Dropdown().set("Fax");
		StoredVariables.getcontactOwnerInfo2().set("405-555-7410");
		StoredVariables.getcontactOccupant().set("Occupant Name");
		StoredVariables.getcontactOccupantInfo1Dropdown().set("Home");
		StoredVariables.getcontactOccupantInfo1().set("405-555-3549");
		StoredVariables.getcontactOccupantInfo2Dropdown().set("Mobile");
		StoredVariables.getcontactOccupantInfo2().set("405-555-8895");
		StoredVariables.getcontactAgent().set("Agent Name");
		StoredVariables.getcontactAgentInfo1Dropdown().set("E-mail");
		StoredVariables.getcontactAgentInfo1().set("agent@dntest.net");
		StoredVariables.getcontactAgentInfo2Dropdown().set("Pager");
		StoredVariables.getcontactAgentInfo2().set("405-555-4893");
		StoredVariables.getcontactOther().set("Other Name");
		StoredVariables.getcontactOtherInfo1Dropdown().set("Work");
		StoredVariables.getcontactOtherInfo1().set("405-555-7825");
		StoredVariables.getcontactOtherInfo2Dropdown().set("Fax");
		StoredVariables.getcontactOtherInfo2().set("405-555-8688");
		StoredVariables.getcontactApptContact().set("Borrower");
		
		// Set Additional Notification Recipients data
		StoredVariables.getadditionalNotificationRecipientsAdditionalEmails().set("additionalEmail1@dntest.net; additionalEmail2@dntest.net");
		StoredVariables.getadditionalNotificationRecipientsAttachCompletedReport().set(true);
		
		// Enter New Order data
		secure.enterNewResidentialAppraisalOrder(driver);
		
		// Click Next
		perform.click(driver, SNewOrder.next_btn(driver));
		
		// Assign vendor
		secure.selectVendor(driver, "Automation BaselineAppraiser2");
		
		// Confirm order screen loads
		Assert.assertTrue(driver.getCurrentUrl().contains("ConfirmOrder"), "Confirm Order page did not load");
		
		// Verify data displays properly
		secure.verifyOrderDetails(driver);
		
		// Verify the 'I have read and understand the vendor's fee notes' checkbox is unchecked
		if (SConfirmOrder.readVendorsFeeNotes_chkbx(driver).isSelected())
		{
			perform.click(driver, SConfirmOrder.readVendorsFeeNotes_chkbx(driver));
		}
		
		// Click Next
		perform.click(driver, SConfirmOrder.nextBottom_btn(driver));
		
		// Wait for message text
		perform.waitForElementToBeClickable(driver, SConfirmOrder.messageOK_btn(), "id");
		
		// Verify popup displays with correct text
		Assert.assertTrue(SConfirmOrder.message_txt(driver).getText().contains("You must agree to the fee notes entered by the vendor."), "Message for not agreeing to vendor notes did not display properly");
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SConfirmOrder.messageOK_btn(), "id");
		
		// Click OK
		perform.click(driver, SConfirmOrder.messageOK_btn(driver));
		
		// Wait for the back button to be visible
		perform.waitForElementToBeClickable(driver, SConfirmOrder.backTop_btn(), "id");
		
		// Check the agree to notes checkbox
		if (!SConfirmOrder.readVendorsFeeNotes_chkbx(driver).isSelected())
		{
			perform.click(driver, SConfirmOrder.readVendorsFeeNotes_chkbx(driver));
		}
		
		// Change payment method to check
		perform.selectDropdownOption(driver, SConfirmOrder.paymentMethod_dropdown(driver), "Check");
		
		// Click Next
		perform.click(driver, SConfirmOrder.nextBottom_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Get inside the attach document frame
		perform.switchToiFrameByID(driver, "iframeAttach");
		
		System.out.println("select doctype");
		// Select document type
		perform.selectDropdownOption(driver, SConfirmOrder.documentType_dropdown(driver), "Other");
		
		System.out.println("wait for upload button");
		// Wait for upload button
		perform.waitForElementToBeClickable(driver, SConfirmOrder.uploadDocuments_btn(), "id");
		
		System.out.println("upload doc");
		// Upload Document
		String filePath = StoredVariables.getdocDir().get()+"Test PDF.pdf";
		secure.uploadDocumentOnSConfirmOrder(driver, filePath);
		
		// Click Close Button
		perform.click(driver, SConfirmOrder.finished_btn(driver));
		
		// Switch back to the attach documents frame
		driver.switchTo().defaultContent();
		
		// Wait for Orders page to load
		perform.waitForElementToBeClickable(driver, SOrders.find_txtbx(), "id");
		
		// Verify you land on the orders grid
		Assert.assertTrue(driver.getCurrentUrl().contains("OrderManagement"), "After completing an order, the orders grid did not load");
		
		// Query the db to get the order number that was just created
		db.getLoanID(driver);
		
		// Wait for the Order Types dropdown
		perform.waitForElementToBeClickable(driver, SOrders.orderTypes_dropdown(), "id");
	
		// Verify Due date is ordered properly to display the most recent order first
		secure.sortByUpdated(driver);
		
		// Wait for overlay to disappear
		perform.waitForOverlayToBeHidden(driver);
		
		// Verify the order just created is in the orders grid 
		Assert.assertTrue(SOrders.ordersTable_txt(driver).getText().contains(StoredVariables.getloanID().get()), "New order is not displayed");
		
		// Verify data in the database
		db.verifyNewOrderDataInDB_All(driver, StoredVariables.getloanID().get());
		
		/***************************************
		 * COMPLETE THE ORDER ON VENDORS
		 ***************************************/
		
		// Log in as the vendor
		vendors.login(driver, "BaselineAppraiser2", StoredVariables.getpassword().get());
		
		// Search for the order
		vendors.findOrder(driver, StoredVariables.getloanID().get(), "Tracking Number");
		
		// Open the order
		vendors.openOrder(driver);
		
		// Wait for the Send Message button
		perform.waitForElementToBeClickable(driver, VOrderDetails.sendMessage_btn(), "cssSelector");
		
		// Click the Accept button
		perform.click(driver, VOrderDetails.acceptDecline_btn(driver));
		
		// Allow popup time to load
		Thread.sleep(1500);
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for Select Action dropdown
		perform.waitForElementToBeClickable(driver, VOrderAcknowledgement.selectAction_dropdown(), "id");

		// Select Propose Conditions to Client from Select Action dropdown
		perform.selectDropdownOption(driver, VOrderAcknowledgement.selectAction_dropdown(driver), "Accept this Assignment");
		
		// Enter notes
		perform.type(driver, VOrderAcknowledgement.acceptAssignmentNotes_txtbx(driver), "Entering accepting notes for the baseline test");
		
		// Click OK
		perform.click(driver, VOrderAcknowledgement.ok_btn(driver));
		
		// Wait for Ok button
		perform.waitForElementToBeClickable(driver, VOrderAcknowledgement.orderAcknowledgementOK_btn(), "id");
		
		// Click OK on acknowledgement
		perform.click(driver, VOrderAcknowledgement.orderAcknowledgementOK_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Complete the order using the HTTP Post
		vendors.completeOrderByHTTPPost(driver, "BaselineAppraiser2", StoredVariables.getpassword().get(), StoredVariables.getloanID().get(), "Complete.xml");
		
		/***************************************
		 * MAKE PAYMENT FROM SECURE
		 ***************************************/
		
		// Login to Secure
		secure.login(driver, user, StoredVariables.getpassword().get());
		
		// Search for new order
		secure.findOrder(driver, StoredVariables.getloanID().get(), "Tracking number");
		
		// Select the order in the table
		perform.clickInTable_Contains(driver, StoredVariables.getloanID().get());
		
		// Wait for Payments
		perform.waitForElementToBeClickable(driver, SOrders.payments_btn(), "cssSelector");
		
		// Click Payments
		perform.click(driver, SOrders.payments_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Switch into iFrame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "/Admin/OrderManagement/PaymentSummary.aspx", By.id(SPaymentSummary.save_btn()));
		
		// Wait for Save button
		perform.waitForElementToBeClickable(driver, SPaymentSummary.save_btn(), "id");
		
		Thread.sleep(15000);
		
		// Wait for grid
		perform.waitForElementToBeClickable(driver, "Main_upMain", "id");
		
		// Wait for text
		perform.waitForText(driver, SPaymentSummary.paymentSummaryGrid_txt(driver), StoredVariables.getloanID().get());
		
		// Verify tracking number is displayed
		Assert.assertTrue(SPaymentSummary.paymentSummaryGrid_txt(driver).getText().contains(StoredVariables.getloanID().get()), "The order is not in the Payment summary. = " + SPaymentSummary.paymentSummaryGrid_txt(driver).getText());
		
		// Select method
		perform.selectDropdownOption(driver, SPaymentSummary.method_dropdown(driver), "Check");
		
		// Enter check number
		perform.type(driver, SPaymentSummary.check_txtbx(driver), perform.randomNumbers(driver, 3));
		
		// Enter invoice number
		perform.type(driver, SPaymentSummary.invoiceNumber_txtbx(driver), perform.randomNumbers(driver, 8));
		
		// Enter notes
		perform.type(driver, SPaymentSummary.note_txtbx(driver), "These are test payment notes for the baseline test");
		
		// Select the Notify vendor of payment checkbox
		if (!SPaymentSummary.notifyVendorOfPayment_chkbx(driver).isSelected())
		{
			perform.click(driver, SPaymentSummary.notifyVendorOfPayment_chkbx(driver));
		}
		
		// Click Save
		perform.click(driver, SPaymentSummary.save_btn(driver));
		
		// Wait for Save button to be disabled
		perform.waitForElementToBeClickable(driver, SPaymentSummary.saveDisabled_btn(), "cssSelector");
		
		// Click Close
		perform.click(driver, SPaymentSummary.close_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Get outside frames
		driver.switchTo().defaultContent();
		
		// Search for new order
		secure.findOrder(driver, StoredVariables.getloanID().get(), "Tracking number");
		
		// Open the order
		secure.openOrder(driver, StoredVariables.getloanID().get());
		
		// Wait for history
		perform.waitForElementToBeClickable(driver, SOrderDetails.history_txt(), "id");
		
		// Verify payment in history
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("A check payment of $300.00"), "Payment information is not in the history. Data = " + SOrderDetails.history_txt(driver).getText());
		
		// Log test
		test.log(LogStatus.INFO, "Orders", "Made a payment on a completed order");
		
	} // end payment
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Click My columns button</li>
	 * 	<li>Switch to iFrame</li>
	 * 	<li>Get text of dialog</li>
	 * 	<li>Verify Manage my columns is displayed</li>
	 * 	<li>Click Close</li>
	 * 	<li>Create list of expected items in dropdown</li>
	 * 	<li>Verify dropdown values</li>
	 * 	<li>Create list of expected items in dropdown</li>
	 * 	<li>Verify dropdown values</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - My Columns", ""}, alwaysRun=true)
	public void myColumns() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Login to Secure
		secure.login(driver, user, StoredVariables.getpassword().get());
		
		// Click My columns button
		perform.clickInTable_Contains(driver, "My columns");
		
		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		// Switch to iFrame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "/Admin/OrderManagement/ManageColumns.aspx", By.id(SMyColumns.manageMyColumnsDialog_txt()));
		
		// Get text of dialog
		String dialogText = SMyColumns.manageMyColumnsDialog_txt(driver).getText();
		
		// Verify Manage my columns is displayed
		Assert.assertTrue(dialogText.contains("Manage my columns"));
		
		// Click Close
		perform.click(driver, SMyColumns.close_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Create list of expected items in dropdown
		String[] expectedValues = {"All","Residential appraisal","  Conventional","Commercial appraisal","Broker Price Opinion","OptiVal AVM Cascade","RealCondition Report","OptiVal+"};
		
		// Verify dropdown values
		perform.verifyDropdownOptions(driver, SOrders.orderTypes_dropdown(driver), expectedValues);
		
		// Create list of expected items in dropdown
		expectedValues = new String[] {"All","Automation Baseline2"};
		
		// Verify dropdown values
		perform.verifyDropdownOptions(driver, SOrders.assigned_dropdown(driver), expectedValues);
		
		// Log test
		test.log(LogStatus.INFO, "Orders", "Verify My columns dialog opens");
		
	} // end myColumns
	
} // end the Secure_OrderManagement class

