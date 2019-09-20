package baselineVMP;

import java.awt.AWTException;
import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.VMP.VMPAppraisalOrderDetails;
import pageObjects.VMP.VMPConfirmOrder;
import pageObjects.VMP.VMPManageMyColumns;
import pageObjects.VMP.VMPNewOrder;
import pageObjects.VMP.VMPOrderDetails;
import pageObjects.VMP.VMPOrders;
import pageObjects.VMP.VMPQuickList;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Baseline VMP - Order Management</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class VMP_OrderManagement extends TestSetup {
	
	/** The user. */
	private final String user = "EVFLender2";
	
	/** The tracking number. */
	private static String trackingNumber = "";
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Clear order information variables before placing a new order</li>
	 * 	<li>Login to VMP Client Portal</li>
	 * 	<li>Click New Order</li>
	 * 	<li>Set Property Information data</li>
	 * 	<li>StoredVariables.getpropertyInformationStateAbbr().set("OK");  Must set for a field check later on</li>
	 * 	<li>Set Assignment Information data</li>
	 * 	<li>Set Lender Information data</li>
	 * 	<li>Set Contact And Access Information data</li>
	 * 	<li>Set Additional Notification Recipients data</li>
	 * 	<li>Set Assigned person and pass it to StoredVariables</li>
	 * 	<li>Enter New Order data</li>
	 * 	<li>Click Next</li>
	 * 	<li>Confirm order screen loads</li>
	 * 	<li>Click Next</li>
	 * 	<li>Select document type</li>
	 * 	<li>Click Close Button</li>
	 * 	<li>Switch back to the attach documents frame</li>
	 * 	<li>Click the OK button in the Order Placed dialog</li>
	 * 	<li>Verify you land on the orders grid</li>
	 * 	<li>Query the db to get the order number that was just created</li>
	 * 	<li>Set tracking number</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"VMP - Create Order"}, alwaysRun=true)
	public void createNewOrder() throws Exception {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Clear order information variables before placing a new order
		perform.clearOrderInfoStoredVariables(driver);
		
		// Login to VMP Client Portal
		vmp.login(driver, user, "Originator"+user, StoredVariables.getpassword().get());
		
		// Wait for New Order button
		perform.waitForElementToBeClickable(driver, VMPOrders.newOrder_btn(), "cssSelector");
		
		// Click New Order
		perform.click(driver,VMPOrders.newOrder_btn(driver));
		
		// Wait for Address text box
		perform.waitForElementToBeClickable(driver, VMPNewOrder.address_txtbx(), "id");
		
		/***************************************
		 * Set New Order Information
		 ***************************************/

		// Set Property Information data		
		StoredVariables.getpropertyInformationAddress().set("2621 SW 136th St");
		StoredVariables.getpropertyInformationCity().set("Oklahoma City");
		StoredVariables.getpropertyInformationState().set("Oklahoma");
		StoredVariables.getpropertyInformationStateAbbr().set("OK"); // Must set for a field check later on
		StoredVariables.getpropertyInformationZip().set("73170");
		StoredVariables.getpropertyInformationPropType().set("Single Family");
		StoredVariables.getpropertyInformationLegalDesc().set("245 W Chantilly Way, Mustang, OK 73064");
		StoredVariables.getpropertyInformationDirections().set("East of N May Ave and south of NW Britton Rd");
		
		// Set Assignment Information data
		StoredVariables.getassignmentInformationForm().set("1004 Full/URAR");
		StoredVariables.getassignmentInformationOrderDue().set(7);
		StoredVariables.getassignmentInformationOtherRefNumber().set(perform.randomNumbers(driver, 7));
		StoredVariables.getassignmentInformationLoanType().set("All In One");
		StoredVariables.getassignmentInformationLoanPurpose().set("Purchase");
		StoredVariables.getassignmentInformationOrderedBy().set("Borrower Name");
		StoredVariables.getassignmentInformationAccountExec().set("(None Selected)");
		StoredVariables.getassignmentInformationLoanNumber().set(perform.randomNumbers(driver, 15));
		StoredVariables.getassignmentInformationFileNumber().set(perform.randomNumbers(driver, 5));
		StoredVariables.getassignmentInformationSalesPrice().set("645,715");
		StoredVariables.getassignmentInformationFHACaseNumber().set(perform.randomNumbers(driver, 6));
		StoredVariables.getassignmentInformationDisclosure().set(0);
		
		// Set Lender Information data
		StoredVariables.getlenderInformationLenderName().set("BOKF, National Association");
		StoredVariables.getlenderInformationAddress1().set("One Williams Center");
		StoredVariables.getlenderInformationCity().set("Tulsa");
		StoredVariables.getlenderInformationState().set("Oklahoma");
		StoredVariables.getlenderInformationZip().set("74172");
		
		// Set Contact And Access Information data
		StoredVariables.getcontactOccupancy().set("Owner");
		StoredVariables.getcontactBorrower().set("Baseline Test");
		StoredVariables.getcontactBorrowerInfo1Dropdown().set("Home");
		StoredVariables.getcontactBorrowerInfo1().set("405-555-7818");
		StoredVariables.getcontactBorrowerInfo2Dropdown().set("E-mail");
		StoredVariables.getcontactBorrowerInfo2().set("borrower@dntest.net");
		StoredVariables.getcontactCoBorrower().set("Coborrower Name");
		StoredVariables.getcontactCoBorrowerInfo1Dropdown().set("Work");
		StoredVariables.getcontactCoBorrowerInfo1().set("405-555-9813");
		StoredVariables.getcontactCoBorrowerInfo2Dropdown().set("Mobile");
		StoredVariables.getcontactCoBorrowerInfo2().set("405-555-1679");
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
		StoredVariables.getadditionalComments().set("These are test additional comments");
		
		// Set Assigned person and pass it to StoredVariables
		StoredVariables.getassignmentInformationAssignedTo().set("Automation OriginatorVMP1");
		
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
		
		// Click Next
		perform.click(driver,VMPConfirmOrder.nextTop_btn(driver));
		
		Thread.sleep(3500);
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for Frames
		perform.waitForIFrames(driver);
		
		// Switch into iFrame
		Thread.sleep(3500);
		perform.switchToiFrameByID(driver, "iframeAttach");
		
		// Wait for message text
		try {
			perform.waitForElementToBeClickable(driver, VMPConfirmOrder.documentType_dropdown(), "id");
		} catch (TimeoutException e) {
			driver.switchTo().defaultContent();
			perform.switchToiFrameByID(driver, "iframeAttach");
			perform.waitForElementToBeClickable(driver, VMPConfirmOrder.documentType_dropdown(), "id");
		} // end try/catch
		
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
		
		// Set tracking number
		trackingNumber = StoredVariables.getloanIDVMP().get();
		
		// Log test
		test.log(LogStatus.INFO, "Orders", "Create a new order");
		
	} // end createNewOrder
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to VMP Client Portal</li>
	 * 	<li>Search for order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Verify the Tracking number</li>
	 * 	<li>Verify url contains OrderDetails.aspx</li>
	 * 	<li>Click Send Message</li>
	 * 	<li>Click the QL icon in the comments field</li>
	 * 	<li>Select QL item</li>
	 * 	<li>Click Delete Selected</li>
	 * 	<li>Verify dialog text</li>
	 * 	<li>Click Yes</li>
	 * 	<li>Check for more QL items</li>
	 * 	<li>Click New</li>
	 * 	<li>Enter a Description</li>
	 * 	<li>Enter the Text</li>
	 * 	<li>Click Save</li>
	 * 	<li>Select QL item</li>
	 * 	<li>Click Edit</li>
	 * 	<li>Enter new text</li>
	 * 	<li>Click Save</li>
	 * 	<li>Select QL item</li>
	 * 	<li>Click Delete Selected</li>
	 * 	<li>Verify dialog text</li>
	 * 	<li>Click Yes</li>
	 * 	<li>Check for more QL items</li>
	 * 	<li>Click New</li>
	 * 	<li>Enter a Description</li>
	 * 	<li>Enter the Text</li>
	 * 	<li>Click Save</li>
	 * 	<li>Select QL item</li>
	 * 	<li>Click Use button</li>
	 * 	<li>Verify Message text</li>
	 * 	<li>Click Cancel</li>
	 * 	<li>Click Other Actions</li>
	 * 	<li>Click Place on Hold</li>
	 * 	<li>Click the QL icon in the comments field</li>
	 * 	<li>Select QL item</li>
	 * 	<li>Click Delete Selected</li>
	 * 	<li>Verify dialog text</li>
	 * 	<li>Click Yes</li>
	 * 	<li>Check for more QL items</li>
	 * 	<li>Click New</li>
	 * 	<li>Enter a Description</li>
	 * 	<li>Enter the Text</li>
	 * 	<li>Click Save</li>
	 * 	<li>Select QL item</li>
	 * 	<li>Click Edit</li>
	 * 	<li>Enter new text</li>
	 * 	<li>Click Save</li>
	 * 	<li>Select QL item</li>
	 * 	<li>Click Delete Selected</li>
	 * 	<li>Verify dialog text</li>
	 * 	<li>Click Yes</li>
	 * 	<li>Check for more QL items</li>
	 * 	<li>Click New</li>
	 * 	<li>Enter a Description</li>
	 * 	<li>Enter the Text</li>
	 * 	<li>Click Save</li>
	 * 	<li>Select QL item</li>
	 * 	<li>Click Use button</li>
	 * 	<li>Verify Message text</li>
	 * 	<li>Click Cancel</li>
	 * 	<li>Log test</li>
* </ul>
	 *
	 * @throws InterruptedException the interrupted exception
	 * @throws ClassNotFoundException the ClassNotFoundExceptionthe class not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws AWTException the AWT exception
	 * @throws SQLException the SQLExceptionthe SQL exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"VMP - Orders", "VMP - Send Message", "VMP - QuickList", "VMP - Place On Hold", "VMP - Other Actions"}, dependsOnMethods={"createNewOrder"})
	public void viewOrder() throws InterruptedException, ClassNotFoundException, IOException, AWTException, SQLException {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Login to VMP Client Portal
		vmp.login(driver, user, "Originator"+user, StoredVariables.getpassword().get());
		
		// Search for order
		vmp.findOrder(driver, trackingNumber, "Tracking #");
		
		// Open the order
		vmp.openOrder(driver, trackingNumber);
		
		// Verify the Tracking number
		Assert.assertTrue(VMPOrderDetails.trackingNumber_txt(driver).getText().contains(trackingNumber), "The order number is incorrect");
		
		// Verify url contains OrderDetails.aspx
		Assert.assertTrue(driver.getCurrentUrl().contains("Admin/OrderManagement/OrderDetails.aspx"), "URL is incorrect. = " + driver.getCurrentUrl());
		
		// Click Send Message
		perform.click(driver,VMPOrderDetails.sendMessage_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for Notes textbox
		perform.waitForElementToBeClickable(driver, VMPOrderDetails.notes_txtbox(), "id");
		
		WebElement menu = null;
		WebElement subMenu = null;
		Actions builder = new Actions(driver);
		int deleteVisible;
		String message = "This is a baseline test message";
		if (StoredVariables.getmobile().get()==false) {
		
			// Click the QL icon in the comments field
			menu = driver.findElement(By.id("ctl00_ctl00_Dialogs_Dialogs_txtSendMessageNotes"));
			subMenu = driver.findElement(By.id("ctl00_ctl00_Dialogs_Dialogs_QLSendMessage_pnlQLButton"));
			builder.moveToElement(menu).perform();
			perform.waitForElementToBeClickable(driver, "ctl00_ctl00_Dialogs_Dialogs_QLSendMessage_pnlQLButton", "id");
			perform.click(driver,subMenu);
			
			// Wait for QL
			perform.waitForElementToBeClickable(driver, VMPQuickList.quickListDialog(), "id");
			
			deleteVisible = driver.findElements(By.id(VMPQuickList.quickListExists())).size();
			System.out.println("deleteVisible = " + deleteVisible);
			while (deleteVisible > 0)
			{
				
				// Wait for item
				perform.waitForElementToBeClickable(driver, "#ctl00_ctl00_Dialogs_Dialogs_QuickList_gvQLItems > tbody > tr:nth-child(1) > td:nth-child(3)", "cssSelector");
				
				// Select QL item
				perform.click(driver,driver.findElement(By.cssSelector("#ctl00_ctl00_Dialogs_Dialogs_QuickList_gvQLItems > tbody > tr:nth-child(1) > td:nth-child(3)")));
				
				// Click Delete Selected
				perform.click(driver,VMPQuickList.deleteSelected_btn(driver));
				
				// Wait for Confirm Delete dialog
				perform.waitForElementToBeClickable(driver, VMPQuickList.confirmDeleteQuickListDialog(), "id");
				
				// Verify dialog text
				Assert.assertTrue(VMPQuickList.confirmDeleteQuickListDialog(driver).getText().contains("Are you sure you want to delete the selected items?"), "The dialog text is incorrect. Text = " + VMPQuickList.confirmDeleteQuickListDialog(driver).getText());
				
				// Click Yes
				perform.click(driver,VMPQuickList.yes_btn(driver));
				
				// Wait for New Item button
				perform.waitForElementToBeClickable(driver, VMPQuickList.newItem_btn(), "cssSelector");
				
				Thread.sleep(2000);
				// Check for more QL items
				deleteVisible = driver.findElements(By.id(VMPQuickList.quickListExists())).size();
			
			} // end while loop
			
			// Click New
			perform.click(driver,VMPQuickList.newItem_btn(driver));
			
			// Wait for Description textbox
			perform.waitForElementToBeClickable(driver, VMPQuickList.description_txtbx(), "id");
			
			// Enter a Description
			perform.type(driver, VMPQuickList.description_txtbx(driver), "Test QL Message");
			
			// Enter the Text
			perform.type(driver, VMPQuickList.text_txtbx(driver), "This is test QL Message text");
			
			// Click Save
			perform.click(driver,VMPQuickList.save_btn(driver));
			
			// Wait for Use Selected button
			perform.waitForElementToBeClickable(driver, VMPQuickList.useSelected_btn(), "cssSelector");
			
			// Select QL item
			perform.click(driver,driver.findElement(By.cssSelector("#ctl00_ctl00_Dialogs_Dialogs_QuickList_gvQLItems > tbody > tr:nth-child(1) > td:nth-child(3)")));
			
			// Click Edit
			perform.click(driver,VMPQuickList.edit_btn(driver));
			
			// Wait for Text
			perform.waitForElementToBeClickable(driver, VMPQuickList.editText_txtbx(), "id");
			
			// Enter new text
			VMPQuickList.editText_txtbx(driver).clear();
			perform.type(driver, VMPQuickList.editText_txtbx(driver), "These is modified QL text");
	
			// Click Save
			perform.click(driver,VMPQuickList.editSave_btn(driver));
			
			deleteVisible = driver.findElements(By.id(VMPQuickList.quickListExists())).size();
			System.out.println("deleteVisible = " + deleteVisible);
			while (deleteVisible > 0)
			{
				
				// Wait for item
				perform.waitForElementToBeClickable(driver, "#ctl00_ctl00_Dialogs_Dialogs_QuickList_gvQLItems > tbody > tr:nth-child(1) > td:nth-child(3)", "cssSelector");
				
				// Select QL item
				perform.click(driver,driver.findElement(By.cssSelector("#ctl00_ctl00_Dialogs_Dialogs_QuickList_gvQLItems > tbody > tr:nth-child(1) > td:nth-child(3)")));
				
				// Click Delete Selected
				perform.click(driver,VMPQuickList.deleteSelected_btn(driver));
				
				// Wait for Confirm Delete dialog
				perform.waitForElementToBeClickable(driver, VMPQuickList.confirmDeleteQuickListDialog(), "id");
				
				// Verify dialog text
				Assert.assertTrue(VMPQuickList.confirmDeleteQuickListDialog(driver).getText().contains("Are you sure you want to delete the selected items?"), "The dialog text is incorrect");
				
				// Click Yes
				perform.click(driver,VMPQuickList.yes_btn(driver));
				
				// Wait for New Item button
				perform.waitForElementToBeClickable(driver, VMPQuickList.newItem_btn(), "cssSelector");
				
				Thread.sleep(2000);
				// Check for more QL items
				deleteVisible = driver.findElements(By.id(VMPQuickList.quickListExists())).size();
			
			} // end while loop
			
			// Click New
			perform.click(driver,VMPQuickList.newItem_btn(driver));
			
			// Wait for Description textbox
			perform.waitForElementToBeClickable(driver, VMPQuickList.description_txtbx(), "id");
			
			// Enter a Description
			perform.type(driver, VMPQuickList.description_txtbx(driver), "Test QL Message");
			
			// Enter the Text
			perform.type(driver, VMPQuickList.text_txtbx(driver), message);
			
			// Click Save
			perform.click(driver,VMPQuickList.save_btn(driver));
			
			// Select QL item
			perform.click(driver,driver.findElement(By.cssSelector("#ctl00_ctl00_Dialogs_Dialogs_QuickList_gvQLItems > tbody > tr:nth-child(1) > td:nth-child(3)")));
			
			Thread.sleep(2000);
			
			// Click Use button
			perform.click(driver,VMPQuickList.useSelected_btn(driver));
			
			// Wait for Notes textbox
			perform.waitForElementToBeClickable(driver, VMPOrderDetails.notes_txtbox(), "id");
			
		} else {
			
			// Enter notes
			perform.type(driver, VMPOrderDetails.notes_txtbox(driver), message);
			
		} // end if/else
		
		// Verify Message text
		Assert.assertTrue(VMPOrderDetails.notes_txtbox(driver).getAttribute("value").contains(message), "The Message text is incorrect. Text = " + VMPOrderDetails.notes_txtbox(driver).getAttribute("value"));
		
		// Click Cancel
		perform.click(driver,VMPOrderDetails.cancelSendMessage_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Click Other Actions
		perform.click(driver,VMPAppraisalOrderDetails.otherActions_btn(driver));
		
		// Click Place on Hold
		perform.click(driver,VMPAppraisalOrderDetails.placeOnHold_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for Notes textbox
		perform.waitForElementToBeClickable(driver, VMPAppraisalOrderDetails.placeOnHoldNotes_txtbx(), "id");
		
		message = "This is a baseline test message";
		if (StoredVariables.getmobile().get()==false) {
		
			// Click the QL icon in the comments field
			menu = driver.findElement(By.id("ctl00_ctl00_Dialogs_Dialogs_txtPlaceOnHoldNotes"));
			subMenu = driver.findElement(By.id("ctl00_ctl00_Dialogs_Dialogs_QLOnHold_pnlQLButton"));
			builder = new Actions(driver);
			builder.moveToElement(menu).perform();
			perform.waitForElementToBeClickable(driver, "ctl00_ctl00_Dialogs_Dialogs_QLOnHold_pnlQLButton", "id");
			perform.click(driver,subMenu);
			
			// Wait for QL
			perform.waitForElementToBeClickable(driver, VMPQuickList.quickListDialog(), "id");
			
			deleteVisible = driver.findElements(By.id(VMPQuickList.quickListExists())).size();
			System.out.println("deleteVisible = " + deleteVisible);
			while (deleteVisible > 0)
			{
				
				// Wait for item
				perform.waitForElementToBeClickable(driver, "#ctl00_ctl00_Dialogs_Dialogs_QuickList_gvQLItems > tbody > tr:nth-child(1) > td:nth-child(3)", "cssSelector");
				
				// Select QL item
				perform.click(driver,driver.findElement(By.cssSelector("#ctl00_ctl00_Dialogs_Dialogs_QuickList_gvQLItems > tbody > tr:nth-child(1) > td:nth-child(3)")));
				
				// Click Delete Selected
				perform.click(driver,VMPQuickList.deleteSelected_btn(driver));
				
				// Wait for Confirm Delete dialog
				perform.waitForElementToBeClickable(driver, VMPQuickList.confirmDeleteQuickListDialog(), "id");
				
				// Verify dialog text
				Assert.assertTrue(VMPQuickList.confirmDeleteQuickListDialog(driver).getText().contains("Are you sure you want to delete the selected items?"), "The dialog text is incorrect. Text = " + VMPQuickList.confirmDeleteQuickListDialog(driver).getText());
				
				// Click Yes
				perform.click(driver,VMPQuickList.yes_btn(driver));
				
				// Wait for New Item button
				perform.waitForElementToBeClickable(driver, VMPQuickList.newItem_btn(), "cssSelector");
				
				Thread.sleep(2000);
				// Check for more QL items
				deleteVisible = driver.findElements(By.id(VMPQuickList.quickListExists())).size();
			
			} // end while loop
			
			// Click New
			perform.click(driver,VMPQuickList.newItem_btn(driver));
			
			// Wait for Description textbox
			perform.waitForElementToBeClickable(driver, VMPQuickList.description_txtbx(), "id");
			
			// Enter a Description
			perform.type(driver, VMPQuickList.description_txtbx(driver), "Test QL Message");
			
			// Enter the Text
			perform.type(driver, VMPQuickList.text_txtbx(driver), "This is test QL Message text");
			
			// Click Save
			perform.click(driver,VMPQuickList.save_btn(driver));
			
			// Wait for Use Selected button
			perform.waitForElementToBeClickable(driver, VMPQuickList.useSelected_btn(), "cssSelector");
			
			// Select QL item
			perform.click(driver,driver.findElement(By.cssSelector("#ctl00_ctl00_Dialogs_Dialogs_QuickList_gvQLItems > tbody > tr:nth-child(1) > td:nth-child(3)")));
			
			// Click Edit
			perform.click(driver,VMPQuickList.edit_btn(driver));
			
			// Wait for Text
			perform.waitForElementToBeClickable(driver, VMPQuickList.editText_txtbx(), "id");
			
			// Enter new text
			VMPQuickList.editText_txtbx(driver).clear();
			perform.type(driver, VMPQuickList.editText_txtbx(driver), "These is modified QL text");
	
			// Click Save
			perform.click(driver,VMPQuickList.editSave_btn(driver));
			
			deleteVisible = driver.findElements(By.id(VMPQuickList.quickListExists())).size();
			System.out.println("deleteVisible = " + deleteVisible);
			while (deleteVisible > 0)
			{
				
				// Wait for item
				perform.waitForElementToBeClickable(driver, "#ctl00_ctl00_Dialogs_Dialogs_QuickList_gvQLItems > tbody > tr:nth-child(1) > td:nth-child(3)", "cssSelector");
				
				// Select QL item
				perform.click(driver,driver.findElement(By.cssSelector("#ctl00_ctl00_Dialogs_Dialogs_QuickList_gvQLItems > tbody > tr:nth-child(1) > td:nth-child(3)")));
				
				// Click Delete Selected
				perform.click(driver,VMPQuickList.deleteSelected_btn(driver));
				
				// Wait for Confirm Delete dialog
				perform.waitForElementToBeClickable(driver, VMPQuickList.confirmDeleteQuickListDialog(), "id");
				
				// Verify dialog text
				Assert.assertTrue(VMPQuickList.confirmDeleteQuickListDialog(driver).getText().contains("Are you sure you want to delete the selected items?"), "The dialog text is incorrect");
				
				// Click Yes
				perform.click(driver,VMPQuickList.yes_btn(driver));
				
				// Wait for New Item button
				perform.waitForElementToBeClickable(driver, VMPQuickList.newItem_btn(), "cssSelector");
				
				Thread.sleep(2000);
				// Check for more QL items
				deleteVisible = driver.findElements(By.id(VMPQuickList.quickListExists())).size();
			
			} // end while loop
			
			// Click New
			perform.click(driver,VMPQuickList.newItem_btn(driver));
			
			// Wait for Description textbox
			perform.waitForElementToBeClickable(driver, VMPQuickList.description_txtbx(), "id");
			
			// Enter a Description
			perform.type(driver, VMPQuickList.description_txtbx(driver), "Test QL Message");
			
			// Enter the Text
			perform.type(driver, VMPQuickList.text_txtbx(driver), message);
			
			// Click Save
			perform.click(driver,VMPQuickList.save_btn(driver));
			
			// Select QL item
			perform.click(driver,driver.findElement(By.cssSelector("#ctl00_ctl00_Dialogs_Dialogs_QuickList_gvQLItems > tbody > tr:nth-child(1) > td:nth-child(3)")));
			
			Thread.sleep(2000);
			
			// Click Use button
			perform.click(driver,VMPQuickList.useSelected_btn(driver));
			
			// Wait for Notes textbox
			perform.waitForElementToBeClickable(driver, VMPAppraisalOrderDetails.placeOnHoldNotes_txtbx(), "id");
			
		} else {
			
			// Enter Notes
			perform.type(driver, VMPAppraisalOrderDetails.placeOnHoldNotes_txtbx(driver), message);
			
		} // end if/else
		
		// Verify Message text
		Assert.assertTrue(VMPAppraisalOrderDetails.placeOnHoldNotes_txtbx(driver).getAttribute("value").contains(message), "The Message text is incorrect. Text = " + VMPAppraisalOrderDetails.placeOnHoldNotes_txtbx(driver).getAttribute("value"));
		
		// Click Cancel
		perform.click(driver,VMPAppraisalOrderDetails.placeOnHoldCancel_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Log test
		test.log(LogStatus.INFO, "Orders", "Used the View button to view an order");
		
	} // end viewOrder
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to VMP Client Portal</li>
	 * 	<li>Search for order</li>
	 * 	<li>Click on Baseline Test</li>
	 * 	<li>Click Delete</li>
	 * 	<li>Verify dialog text</li>
	 * 	<li>Enter notes</li>
	 * 	<li>Click OK</li>
	 * 	<li>Verify Deleted Order text</li>
	 * 	<li>Click OK</li>
	 * 	<li>Go to Orders</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify order is cancelled</li>
	 * 	<li>Log test</li>
* </ul>
	 *
	 * @throws InterruptedException the interrupted exception
	 * @throws ClassNotFoundException the ClassNotFoundExceptionthe class not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws AWTException the AWT exception
	 * @throws SQLException the SQLExceptionthe SQL exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"VMP - Orders", "VMP - Delete Order"}, dependsOnMethods={"viewOrder"})
	public void deleteOrder() throws InterruptedException, ClassNotFoundException, IOException, AWTException, SQLException {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Login to VMP Client Portal
		vmp.login(driver, user, "Originator"+user, StoredVariables.getpassword().get());
		
		// Search for order
		vmp.findOrder(driver, trackingNumber, "Tracking #");
		
		// Click on Baseline Test
		perform.clickInTable_Contains(driver, "Baseline Test");
		
		// Click Delete
		perform.clickInTable_Contains(driver, "Delete Order");
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for Order Delete dialog
		perform.waitForElementToBeClickable(driver, VMPOrders.orderDeleteDialog_txtbx(), "id");
		
		// Verify dialog text
		Assert.assertTrue(VMPOrders.orderDeleteDialog_txtbx(driver).getText().contains("One or more of the orders selected has not been cancelled."), "Order Delete dialog text is incorrect");
		
		// Enter notes
		perform.type(driver, VMPOrders.notes_txtbx(driver), "These are baseline test notes");
		
		// Click OK
		perform.click(driver,VMPOrders.okDelete_btn(driver));
		
		// Wait for Deleted OK button
		perform.waitForElementToBeClickable(driver, VMPOrders.okDeleted_btn(), "cssSelector");
		
		// Verify Deleted Order text
		Assert.assertTrue(VMPOrders.deletedOrderDialog_txt(driver).getText().contains("Your orders have been successfully deleted."), "The Delete Orders dialog text is incorrect");
		
		// Click OK
		perform.click(driver,VMPOrders.okDeleted_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Go to Orders
		vmp.goToOrders(driver);
		
		// Search for order
		vmp.findOrder(driver, trackingNumber, "Tracking #");
		
		// Verify order is cancelled
		Assert.assertTrue(!VMPOrders.ordersGrid_txt(driver).getText().contains(trackingNumber), "The order " + trackingNumber + " is displayed and should not be.");
		
		// Log test
		test.log(LogStatus.INFO, "Orders", "Deleted order on VMP Client Portal");
		
	} // end deleteOrder
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to VMP Client Portal</li>
	 * 	<li>Click on My Columns</li>
	 * 	<li>Switch iFrame</li>
	 * 	<li>Verify the dropdown</li>
	 * 	<li>Verify Manage my columns is displayed</li>
	 * 	<li>Click close</li>
	 * 	<li>Log test</li>
* </ul>
	 *
	 * @throws InterruptedException the interrupted exception
	 * @throws ClassNotFoundException the ClassNotFoundExceptionthe class not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws AWTException the AWT exception
	 * @throws SQLException the SQLExceptionthe SQL exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"VMP - My Columns"}, dependsOnMethods="deleteOrder")
	public void myColumns() throws InterruptedException, ClassNotFoundException, IOException, AWTException, SQLException {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Login to VMP Client Portal
		vmp.login(driver, user, "Originator"+user, StoredVariables.getpassword().get());
		
		// Click on My Columns
		perform.click(driver,VMPOrders.myColumns_btn(driver));
		
		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		// Switch iFrame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "/Admin/OrderManagement/ManageColumns.aspx", By.id(VMPManageMyColumns.close_btn()));
		
		// Wait for Close button
		perform.waitForElementToBeClickable(driver, VMPManageMyColumns.close_btn(), "id");
		
		// Verify the dropdown
		String[] folder = {"---------- Folder Groups ----------","All Folders","In Progress","Exceptions","---------- Folders ------------------","All Open Orders","Open Bid Orders","Inspection Scheduled","Inspection Complete","Pending Quality Review","Due Today","Past Due","Awaiting Disclosure Expiration","Require Disclosure Date","No Borrower E-mail","Revision Needed","Delayed","On Hold","Payment Failed","Completed","Cancelled","Deleted","Found Orders"};
		perform.verifyDropdownOptions(driver, VMPManageMyColumns.folder_dropdown(driver), folder);
		
		// Verify Manage my columns is displayed
		Assert.assertTrue(VMPManageMyColumns.manageMyColulmns_txt(driver).getText().contains("Manage my columns"));
		
		// Click close
		perform.click(driver,VMPManageMyColumns.close_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Log test
		test.log(LogStatus.INFO, "Orders", "Verify My columns dialog opens");
		
	} // end myColumns
	
} // end the Secure_Login class
