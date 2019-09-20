package baselineVendors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Vendors.VOrderDetails;
import pageObjects.Vendors.VOrders;
import pageObjects.Vendors.VQuickListOld;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Baseline Vendors - Order Management</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class Vendors_OrderManagement extends TestSetup {
	
	/** The user. */
	private final String user = "BaselineAppraiser2";
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Vendors</li>
	 * 	<li>Click Borrower Name</li>
	 * 	<li>Click View</li>
	 * 	<li>Verify url contains OrderDetails.aspx</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Vendors - Orders"}, alwaysRun=true)
	public void view() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Login to Vendors
		vendors.login(driver, user, StoredVariables.getpassword().get());
		
		// Click Borrower Name
		perform.clickInTable_Contains(driver, "Borrower Name");
		
		// Click View
		perform.clickInTable_Contains(driver, "View Order");
		
		// Wait for History text
		perform.waitForElementToBeClickable(driver, VOrderDetails.historyHeader_txt(), "id");
		
		// Verify url contains OrderDetails.aspx
		Assert.assertTrue(driver.getCurrentUrl().contains("VendorAdmin/OrderManagement/OrderDetails.aspx"), "URL is incorrect. = " + driver.getCurrentUrl());
		
		// Log test
		test.log(LogStatus.INFO, "Orders", "Used the View button to view an order");
		
	} // end view
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Create the order to be deleted</li>
	 * 	<li>Login to Vendors</li>
	 * 	<li>Click Action Required</li>
	 * 	<li>Open an order by double clicking Borrower Name</li>
	 * 	<li>Get the Tracking number</li>
	 * 	<li>Go to Orders</li>
	 * 	<li>Search for order</li>
	 * 	<li>Click on Borrower Name</li>
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
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Vendors - Orders", "Vendors - Delete Order"}, alwaysRun=true)
	public void deleteNonCancelledOrder() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Create the order to be deleted
		secure.createAndAssignNewResidentialAppraisalOrderUsingCustomFeePanel(driver, "Baseline2", "Automation BaselineAppraiser2");
		
		// Login to Vendors
		vendors.login(driver, user, StoredVariables.getpassword().get());
		
		// Click Action Required
		perform.click(driver,driver.findElement(By.cssSelector("#tblFolders > tbody > tr:nth-child(3) > td:nth-child(1)")));
		
		Thread.sleep(2000);
		
		// Open an order by double clicking Borrower Name
		vendors.openOrder(driver);
		
		// Get the Tracking number
		String trackingNumber = StoredVariables.getloanID().get();
		
		// Go to Orders
		vendors.goToOrders(driver);
		
		// Search for order
		vendors.findOrder(driver, trackingNumber, "Tracking Number");
		
		// Click on Borrower Name
		perform.clickInTable_Contains(driver, "Baseline2");
		
		// Click Delete
		perform.clickInTable_Contains(driver, "Delete Order");
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for Order Delete dialog
		perform.waitForElementToBeClickable(driver, VOrders.orderDeleteDialog_txtbx(), "id");
		
		// Verify dialog text
		Assert.assertTrue(VOrders.orderDeleteDialog_txtbx(driver).getText().contains("One or more of the orders selected has not been cancelled."), "Order Delete dialog text is incorrect");
		
		// Enter notes
		perform.type(driver, VOrders.notes_txtbx(driver), "These are baseline test notes");
		
		// Click OK
		perform.click(driver,VOrders.okDelete_btn(driver));
		
		// Wait for Deleted OK button
		perform.waitForElementToBeClickable(driver, VOrders.okDeleted_btn(), "cssSelector");
		
		// Verify Deleted Order text
		Assert.assertTrue(VOrders.deletedOrderDialog_txt(driver).getText().contains("Your orders have been successfully deleted."), "The Delete Orders dialog text is incorrect");
		
		// Click OK
		perform.click(driver,VOrders.okDeleted_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Go to Orders
		vendors.goToOrders(driver);
		
		// Search for order
		vendors.findOrder(driver, trackingNumber, "Tracking Number");
		
		// Verify order is cancelled
		Assert.assertTrue(VOrders.ordersGrid_txt(driver).getText().contains("Cancelled"), "The order is not in the Cancelled status. - " + trackingNumber);
		
		// Log test
		test.log(LogStatus.INFO, "Orders", "Deleted order on Vendors");
		
	} // end deleteNonCancelledOrder
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Go to Data Courier</li>
	 * 	<li>Set element</li>
	 * 	<li>Get the element id</li>
	 * 	<li>Get column width for the borrower column before</li>
	 * 	<li>Expand column width for the borrower column</li>
	 * 	<li>Get the new column width for the borrower column</li>
	 * 	<li>Verify the column width got changed</li>
	 * 	<li>Click Restore Column Widths button</li>
	 * 	<li>Refresh the element</li>
	 * 	<li>Get the new column width for the borrower column</li>
	 * 	<li>Edit strings</li>
	 * 	<li>Convert strings to integers</li>
	 * 	<li>initialize boolean</li>
	 * 	<li>Check if width is within a range</li>
	 * 	<li>Verify column width returns to original width</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Vendors - Orders", "Vendors - Data Courier", "Vendors - Column Width"}, alwaysRun=true)
	public void restoreColumnWidths() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Log in to Vendors
		vendors.login(driver, user, StoredVariables.getpassword().get());
		
		// Go to Data Courier
		vendors.goToOrders(driver);
		
		Thread.sleep(4000);
		
		// Set element
		WebElement e = driver.findElement(By.cssSelector("th[idx='2']"));
		
		// Get the element id
		String id = e.getAttribute("id");
		
		// Get column width for the borrower column before
		String styleBefore = e.getAttribute("style");
		
		// Expand column width for the borrower column
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('" + id + "').setAttribute('style', 'width: 200px;')");
		
		// Get the new column width for the borrower column
		String styleAfter = e.getAttribute("style");
		
		// Verify the column width got changed
		Assert.assertTrue(!styleBefore.equals(styleAfter), "The column width did not change");
		
		// Click Restore Column Widths button
		perform.clickInTable_Contains(driver, "Restore Column Widths");
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Refresh the element
		e = driver.findElement(By.cssSelector("th[idx='2']"));
		
		Thread.sleep(4000);
		
		// Get the new column width for the borrower column
		String styleAfterRestore = e.getAttribute("style");
		
		// Edit strings
		String styleBefore_edited = styleBefore.replace("width: ", "").replace("px;", "");
		String styleAfter_edited = styleAfterRestore.replace("width: ", "").replace("px;", "");
		
		// Convert strings to integers
		int before = Integer.parseInt(styleBefore_edited);
		int after = Integer.parseInt(styleAfter_edited);
		int tolerance = 5;
		
		// initialize boolean
		boolean acceptableValue = false;
		
		// Check if width is within a range
		if (before > (after-tolerance) && before < (after+tolerance))
		{
			acceptableValue = true;
		}
		
		// Verify column width returns to original width
		Assert.assertTrue(acceptableValue==true, "The column did not return to the original width. styleBefore = " + styleBefore + "   styleAfterRestore = " + styleAfterRestore);
	    
		// Log test
		test.log(LogStatus.INFO, "Orders", "Tested the Restore Column Widths button");
		
	} // end restoreColumnWidths
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Vendors</li>
	 * 	<li>Open the order</li>
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
	 * 	<li>Click Set Order Status</li>
	 * 	<li>Click Inspection Scheduled</li>
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
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Vendors - QuickList", "Vendors - Orders", "Vendors - Send Message", "Vendors - Set Status", "Vendors - Inspection Scheduled"}, alwaysRun=true)
	public void quickList() throws Exception {
		
		if (StoredVariables.getmobile().get()==false) {
			
			ExtentTest test = ExtentTestManager.getTest();
			RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
			
			String env = StoredVariables.getusernameEnvironment().get(); 
			String orderNumber = "";
			if (env.equals("QA")) {
				orderNumber = "384720";
			}
			if (env.equals("Beta")) {
				orderNumber = "22903969";
			}
			if (env.equals("Live")) {
				orderNumber = "23302433";
			}
			
			// Login to Vendors
			vendors.login(driver, user, StoredVariables.getpassword().get());
			
			// Open the order
			vendors.findAndOpenOrder(driver, orderNumber);
			
			// Wait for History text
			perform.waitForElementToBeClickable(driver, VOrderDetails.historyHeader_txt(), "id");
			
			// Verify url contains OrderDetails.aspx
			Assert.assertTrue(driver.getCurrentUrl().contains("VendorAdmin/OrderManagement/OrderDetails.aspx"), "URL is incorrect. = " + driver.getCurrentUrl());
			
			// Click Send Message
			perform.click(driver,VOrderDetails.sendMessage_btn(driver));
			
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			// Wait for Notes textbox
			perform.waitForElementToBeClickable(driver, VOrderDetails.sendMessageNotes_txtbx(), "id");
			
			// Click the QL icon in the comments field
			WebElement menu = driver.findElement(By.id("Dialogs_Dialogs_ctlSendMessages_txtMessage"));
			WebElement subMenu = driver.findElement(By.id("Dialogs_Dialogs_ctlSendMessages_QLMessage_pnlQLButton"));
			Actions builder = new Actions(driver);
			builder.moveToElement(menu).perform();
			perform.waitForElementToBeClickable(driver, "Dialogs_Dialogs_ctlSendMessages_QLMessage_pnlQLButton", "id");
			perform.click(driver,subMenu);
			
			// Wait for QL
			perform.waitForElementToBeClickable(driver, VQuickListOld.quickListDialog(), "id");
			
			int deleteVisible = driver.findElements(By.id(VQuickListOld.quickListExists())).size();
			System.out.println("deleteVisible = " + deleteVisible);
			while (deleteVisible > 0)
			{
				
				// Wait for item
				perform.waitForElementToBeClickable(driver, "#Dialogs_Dialogs_QuickList_gvQLItems > tbody > tr > td:nth-child(3)", "cssSelector");
				
				// Select QL item
				perform.click(driver,driver.findElement(By.cssSelector("#Dialogs_Dialogs_QuickList_gvQLItems > tbody > tr > td:nth-child(3)")));
				
				// Click Delete Selected
				perform.click(driver,VQuickListOld.deleteSelected_btn(driver));
				
				// Wait for Confirm Delete dialog
				perform.waitForElementToBeClickable(driver, VQuickListOld.confirmDeleteQuickListDialog(), "cssSelector");
				
				// Verify dialog text
				Assert.assertTrue(VQuickListOld.confirmDeleteQuickListDialog(driver).getText().contains("Are you sure you want to delete the selected items?"), "The dialog text is incorrect. Text = " + VQuickListOld.confirmDeleteQuickListDialog(driver).getText());
				
				// Click Yes
				perform.click(driver,VQuickListOld.yes_btn(driver));
				
				// Wait for New Item button
				perform.waitForElementToBeClickable(driver, VQuickListOld.newItem_btn(), "cssSelector");
				
				Thread.sleep(2000);
				// Check for more QL items
				deleteVisible = driver.findElements(By.id(VQuickListOld.quickListExists())).size();
			
			} // end while loop
			
			// Click New
			perform.click(driver,VQuickListOld.newItem_btn(driver));
			
			// Wait for Description textbox
			perform.waitForElementToBeClickable(driver, VQuickListOld.description_txtbx(), "id");
			
			// Enter a Description
			perform.type(driver, VQuickListOld.description_txtbx(driver), "Test QL Message");
			
			// Enter the Text
			perform.type(driver, VQuickListOld.text_txtbx(driver), "This is test QL Message text");
			
			// Click Save
			perform.click(driver,VQuickListOld.save_btn(driver));
			
			// Wait for Use Selected button
			perform.waitForElementToBeClickable(driver, VQuickListOld.useSelected_btn(), "cssSelector");
			
			// Select QL item
			perform.click(driver,driver.findElement(By.cssSelector("#Dialogs_Dialogs_QuickList_gvQLItems > tbody > tr > td:nth-child(3)")));
			
			// Click Edit
			perform.click(driver,VQuickListOld.edit_btn(driver));
			
			// Wait for Text
			perform.waitForElementToBeClickable(driver, VQuickListOld.editText_txtbx(), "id");
			
			// Enter new text
			VQuickListOld.editText_txtbx(driver).clear();
			perform.type(driver, VQuickListOld.editText_txtbx(driver), "These is modified QL text");
	
			// Click Save
			perform.click(driver,VQuickListOld.editSave_btn(driver));
			
			deleteVisible = driver.findElements(By.id(VQuickListOld.quickListExists())).size();
			System.out.println("deleteVisible = " + deleteVisible);
			while (deleteVisible > 0)
			{
				
				// Wait for item
				perform.waitForElementToBeClickable(driver, "#Dialogs_Dialogs_QuickList_gvQLItems > tbody > tr > td:nth-child(3)", "cssSelector");
				
				// Select QL item
				perform.click(driver,driver.findElement(By.cssSelector("#Dialogs_Dialogs_QuickList_gvQLItems > tbody > tr > td:nth-child(3)")));
				
				// Click Delete Selected
				perform.click(driver,VQuickListOld.deleteSelected_btn(driver));
				
				// Wait for Confirm Delete dialog
				perform.waitForElementToBeClickable(driver, VQuickListOld.confirmDeleteQuickListDialog(), "cssSelector");
				
				// Verify dialog text
				Assert.assertTrue(VQuickListOld.confirmDeleteQuickListDialog(driver).getText().contains("Are you sure you want to delete the selected items?"), "The dialog text is incorrect");
				
				// Click Yes
				perform.click(driver,VQuickListOld.yes_btn(driver));
				
				// Wait for New Item button
				perform.waitForElementToBeClickable(driver, VQuickListOld.newItem_btn(), "cssSelector");
				
				Thread.sleep(2000);
				// Check for more QL items
				deleteVisible = driver.findElements(By.id(VQuickListOld.quickListExists())).size();
			
			} // end while loop
			
			// Click New
			perform.click(driver,VQuickListOld.newItem_btn(driver));
			
			// Wait for Description textbox
			perform.waitForElementToBeClickable(driver, VQuickListOld.description_txtbx(), "id");
			
			// Enter a Description
			perform.type(driver, VQuickListOld.description_txtbx(driver), "Test QL Message");
			
			// Enter the Text
			String message = "This is a baseline test message";
			perform.type(driver, VQuickListOld.text_txtbx(driver), message);
			
			// Click Save
			perform.click(driver,VQuickListOld.save_btn(driver));
			
			// Select QL item
			perform.click(driver,driver.findElement(By.cssSelector("#Dialogs_Dialogs_QuickList_gvQLItems > tbody > tr > td:nth-child(3)")));
			
			Thread.sleep(2000);
			
			// Click Use button
			perform.click(driver,VQuickListOld.useSelected_btn(driver));
			
			// Wait for Notes textbox
			perform.waitForElementToBeClickable(driver, VOrderDetails.sendMessageNotes_txtbx(), "id");
			
			// Verify Message text
			Assert.assertTrue(VOrderDetails.sendMessageNotes_txtbx(driver).getAttribute("value").contains(message), "The Message text is incorrect. Text = " + VOrderDetails.sendMessageNotes_txtbx(driver).getAttribute("value"));
			
			// Click Cancel
			perform.click(driver,VOrderDetails.sendMessageCancel_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			// Click Set Order Status
			perform.click(driver,VOrderDetails.setOrderStatus_btn(driver));
			
			// Click Inspection Scheduled
			perform.click(driver,VOrderDetails.inspectionScheduled_btn(driver));
			
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			// Wait for Notes textbox
			perform.waitForElementToBeClickable(driver, VOrderDetails.inspectionScheduledNotes_txtbx(), "id");
			
			// Click the QL icon in the comments field
			menu = driver.findElement(By.id("Dialogs_Dialogs_ctlSetInspectionMessage_txtMessage"));
			subMenu = driver.findElement(By.id("Dialogs_Dialogs_ctlSetInspectionMessage_QLMessage_pnlQLButton"));
			builder = new Actions(driver);
			builder.moveToElement(menu).perform();
			perform.waitForElementToBeClickable(driver, "Dialogs_Dialogs_ctlSetInspectionMessage_QLMessage_pnlQLButton", "id");
			perform.click(driver,subMenu);
			
			// Wait for QL
			perform.waitForElementToBeClickable(driver, VQuickListOld.quickListDialog(), "id");
			
			deleteVisible = driver.findElements(By.id(VQuickListOld.quickListExists())).size();
			System.out.println("deleteVisible = " + deleteVisible);
			while (deleteVisible > 0)
			{
				
				// Wait for item
				perform.waitForElementToBeClickable(driver, "#Dialogs_Dialogs_QuickList_gvQLItems > tbody > tr > td:nth-child(3)", "cssSelector");
				
				// Select QL item
				perform.click(driver,driver.findElement(By.cssSelector("#Dialogs_Dialogs_QuickList_gvQLItems > tbody > tr > td:nth-child(3)")));
				
				// Click Delete Selected
				perform.click(driver,VQuickListOld.deleteSelected_btn(driver));
				
				// Wait for Confirm Delete dialog
				perform.waitForElementToBeClickable(driver, VQuickListOld.confirmDeleteQuickListDialog(), "cssSelector");
				
				// Verify dialog text
				Assert.assertTrue(VQuickListOld.confirmDeleteQuickListDialog(driver).getText().contains("Are you sure you want to delete the selected items?"), "The dialog text is incorrect. Text = " + VQuickListOld.confirmDeleteQuickListDialog(driver).getText());
				
				// Click Yes
				perform.click(driver,VQuickListOld.yes_btn(driver));
				
				// Wait for New Item button
				perform.waitForElementToBeClickable(driver, VQuickListOld.newItem_btn(), "cssSelector");
				
				Thread.sleep(2000);
				// Check for more QL items
				deleteVisible = driver.findElements(By.id(VQuickListOld.quickListExists())).size();
			
			} // end while loop
			
			// Click New
			perform.click(driver,VQuickListOld.newItem_btn(driver));
			
			// Wait for Description textbox
			perform.waitForElementToBeClickable(driver, VQuickListOld.description_txtbx(), "id");
			
			// Enter a Description
			perform.type(driver, VQuickListOld.description_txtbx(driver), "Test QL Message");
			
			// Enter the Text
			perform.type(driver, VQuickListOld.text_txtbx(driver), "This is test QL Message text");
			
			// Click Save
			perform.click(driver,VQuickListOld.save_btn(driver));
			
			// Wait for Use Selected button
			perform.waitForElementToBeClickable(driver, VQuickListOld.useSelected_btn(), "cssSelector");
			
			// Select QL item
			perform.click(driver,driver.findElement(By.cssSelector("#Dialogs_Dialogs_QuickList_gvQLItems > tbody > tr > td:nth-child(3)")));
			
			// Click Edit
			perform.click(driver,VQuickListOld.edit_btn(driver));
			
			// Wait for Text
			perform.waitForElementToBeClickable(driver, VQuickListOld.editText_txtbx(), "id");
			
			// Enter new text
			VQuickListOld.editText_txtbx(driver).clear();
			perform.type(driver, VQuickListOld.editText_txtbx(driver), "These is modified QL text");
	
			// Click Save
			perform.click(driver,VQuickListOld.editSave_btn(driver));
			
			deleteVisible = driver.findElements(By.id(VQuickListOld.quickListExists())).size();
			System.out.println("deleteVisible = " + deleteVisible);
			while (deleteVisible > 0)
			{
				
				// Wait for item
				perform.waitForElementToBeClickable(driver, "#Dialogs_Dialogs_QuickList_gvQLItems > tbody > tr > td:nth-child(3)", "cssSelector");
				
				// Select QL item
				perform.click(driver,driver.findElement(By.cssSelector("#Dialogs_Dialogs_QuickList_gvQLItems > tbody > tr > td:nth-child(3)")));
				
				// Click Delete Selected
				perform.click(driver,VQuickListOld.deleteSelected_btn(driver));
				
				// Wait for Confirm Delete dialog
				perform.waitForElementToBeClickable(driver, VQuickListOld.confirmDeleteQuickListDialog(), "cssSelector");
				
				// Verify dialog text
				Assert.assertTrue(VQuickListOld.confirmDeleteQuickListDialog(driver).getText().contains("Are you sure you want to delete the selected items?"), "The dialog text is incorrect");
				
				// Click Yes
				perform.click(driver,VQuickListOld.yes_btn(driver));
				
				// Wait for New Item button
				perform.waitForElementToBeClickable(driver, VQuickListOld.newItem_btn(), "cssSelector");
				
				Thread.sleep(2000);
				// Check for more QL items
				deleteVisible = driver.findElements(By.id(VQuickListOld.quickListExists())).size();
			
			} // end while loop
			
			// Click New
			perform.click(driver,VQuickListOld.newItem_btn(driver));
			
			// Wait for Description textbox
			perform.waitForElementToBeClickable(driver, VQuickListOld.description_txtbx(), "id");
			
			// Enter a Description
			perform.type(driver, VQuickListOld.description_txtbx(driver), "Test QL Message");
			
			// Enter the Text
			message = "This is a baseline test message";
			perform.type(driver, VQuickListOld.text_txtbx(driver), message);
			
			// Click Save
			perform.click(driver,VQuickListOld.save_btn(driver));
			
			// Select QL item
			perform.click(driver,driver.findElement(By.cssSelector("#Dialogs_Dialogs_QuickList_gvQLItems > tbody > tr > td:nth-child(3)")));
			
			Thread.sleep(1000);
			
			// Click Use button
			perform.click(driver,VQuickListOld.useSelected_btn(driver));
			
			// Wait for Notes textbox
			perform.waitForElementToBeClickable(driver, VOrderDetails.inspectionScheduledNotes_txtbx(), "id");
			
			// Verify Message text
			System.out.println("\n\nNotes = " + VOrderDetails.inspectionScheduledNotes_txtbx(driver).getAttribute("value"));
			Assert.assertTrue(VOrderDetails.inspectionScheduledNotes_txtbx(driver).getAttribute("value").contains(message), "The Message text is incorrect. Text = " + VOrderDetails.sendMessageNotes_txtbx(driver).getAttribute("value"));
			
			// Click Cancel
			perform.click(driver,VOrderDetails.cancelInspectionScheduled_btn(driver));
			
			// Log test
			test.log(LogStatus.INFO, "Orders", "Verified the Quick List functionality on Send Message and Set Order Status");
			
		} // end if android
		
	} // end quickList
	
} // end the Secure_Login class
