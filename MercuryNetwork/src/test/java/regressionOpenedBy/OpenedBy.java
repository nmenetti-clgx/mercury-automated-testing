package regressionOpenedBy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Overlay.Overlay;
import pageObjects.Secure.SConfirmOrder;
import pageObjects.Secure.SLogin;
import pageObjects.Secure.SNewOrder;
import pageObjects.Secure.SOrderDetails;
import pageObjects.Secure.SOrders;
import pageObjects.Secure.SVendorSelection;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import setup.DriverFactory;
import setup.DriverFactorySecond;
//import setup.SecondDriver;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Opened By</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class OpenedBy extends TestSetup {

	/** The second driver. */
//	private DriverFactory2 secondDriver = new DriverFactory2();
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Click My Columns</li>
	 * 	<li>Switch in to iFrame</li>
	 * 	<li>Verify that Opened by is in the Displayed columns section</li>
	 * 	<li>Click Close</li>
	 * 	<li>Create 2  new orders</li>
	 * 	<li>Default the second browser to Firefox</li>
	 * 	<li>If the testing browser is Firefox, open the second browser in Chrome</li>
	 * 	<li>Create the second driver</li>
	 * 	<li>Set the second driver</li>
	 * 	<li>Open a new browser and go to Secure</li>
	 * 	<li>Enter email address</li>
	 * 	<li>Enter password</li>
	 * 	<li>Click Sign In</li>
	 * 	<li>Check for overlay if it is the first time the page is opened since run</li>
	 * 	<li>Click Find textbox</li>
	 * 	<li>Close overlay</li>
	 * 	<li>Enter order number into Find textbox</li>
	 * 	<li>Select Tracking number in the dropdown</li>
	 * 	<li>Click Contains radio button</li>
	 * 	<li>Click Find button</li>
	 * 	<li>Set 40 second while loop timeout</li>
	 * 	<li>Verify the Opened By column is blank</li>
	 * 	<li>Find the order</li>
	 * 	<li>Verify the Opened By column is blank</li>
	 * 	<li>Open the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Click View</li>
	 * 	<li>Verify banner text contains multiple order text</li>
	 * 	<li>Go to the Account page</li>
	 * 	<li>Go to the Orders page</li>
	 * 	<li>Find the order</li>
	 * 	<li>Verify the Opened By column now displays the sub user has the order opened</li>
	 * 	<li>Orders grid should show the order is opened by the sub user</li>
	 * 	<li>Set 2.5 minutes while loop timeout</li>
	 * 	<li>Get the text again</li>
	 * 	<li>Open the order</li>
	 * 	<li>Verify the banner displays the sub user has the order opened</li>
	 * 	<li>Banner should update showing the order has been opened by the admin user</li>
	 * 	<li>Set 2.5 minutes while loop timeout</li>
	 * 	<li>Get the text again</li>
	 * 	<li>Go back to the Orders screen</li>
	 * 	<li>Verify the banner updates the sub user no longer has the order opened</li>
	 * 	<li>Set 2.5 minutes while loop timeout</li>
	 * 	<li>Get the text again</li>
	 * 	<li>Log in as the Vendor</li>
	 * 	<li>Accept the order as the vendor</li>
	 * 	<li>Log back in to Secure</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Click Edit</li>
	 * 	<li>Open the order</li>
	 * 	<li>Click View</li>
	 * 	<li>Verify banner text contains multiple order text</li>
	 * 	<li>Go back to the Orders screen</li>
	 * 	<li>Go to the Orders page</li>
	 * 	<li>Create and assign a new order to Appraiser1</li>
	 * 	<li>Log in as the Vendor</li>
	 * 	<li>Decline the order as the vendor</li>
	 * 	<li>Log back in to Secure</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Enter order number into Find textbox</li>
	 * 	<li>Select Tracking number in the dropdown</li>
	 * 	<li>Click Contains radio button</li>
	 * 	<li>Click Find button</li>
	 * 	<li>Set 40 second while loop timeout</li>
	 * 	<li>Verify the Opened By column contains OpenedBy1</li>
	 * 	<li>Open the order</li>
	 * 	<li>Click View</li>
	 * 	<li>Verify banner text contains multiple order text</li>
	 * 	<li>Click the Reassign button</li>
	 * 	<li>Check for related orders</li>
	 * 	<li>Sleep for 120 seconds</li>
	 * 	<li>Verify banner text contains multiple order text</li>
	 * 	<li>Assign the order to Appraiser3</li>
	 * 	<li>Select vendor</li>
	 * 	<li>Verify the appraiser is selected</li>
	 * 	<li>Click Next</li>
	 * 	<li>Sleep for 120 seconds</li>
	 * 	<li>Verify banner text contains multiple order text</li>
	 * 	<li>Close the second driver</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@SuppressWarnings("unused")
	@Test (retryAnalyzer = Retry.class, groups={"broken", "Secure - Orders", "Secure - Create Order", "Secure - Account", "Vendors - Order", "Vendors - Accept Order", "Secure - Edit Order", "Vendors - Decline Order"}, alwaysRun=true)
	public void openedBy() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		/****************************************
		 * INITIAL DRIVER
		 ****************************************/
		
		// Log in to Secure
		secure.login(driver, "OpenedBy1", StoredVariables.getpassword().get());
		
		// Click My Columns
		perform.click(driver, SOrders.myColumns_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Switch in to iFrame
		driver.switchTo().defaultContent();
		perform.waitForiFrameSrcAndSwitchToIt(driver, "/Admin/OrderManagement/ManageColumns.aspx", By.id(SOrders.displayedColumns_txt()));
		
		// Verify that Opened by is in the Displayed columns section
		Assert.assertTrue(SOrders.displayedColumns_txt(driver).getText().contains("Opened by"), "Opened by is not available as a column");
		
		// Click Close
		perform.click(driver, SOrders.close_btn(driver));
		
		// Switch out of iFrame
		driver.switchTo().defaultContent();
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Create 2  new orders
		for (int a = 1; a <= 2; a++)
		{
			secure.createAndAssignNewResidentialAppraisalOrderUsingCustomFeePanel(driver, "OpenedBy1", "Appraiser1");			
		} // end for loop
		
		/****************************************
		 * SECOND DRIVER
		 ****************************************/
		
		System.out.println("\nStart second driver\n");
		
		// Default the second browser to Firefox
		String browser = "Firefox";
		
		// If the testing browser is Firefox, open the second browser in Chrome
		if (StoredVariables.getbrowser().equals("Firefox"))
		{
			browser = "Chrome";
		} // end if
		StoredVariables.getbrowser2().set(browser);
		
		// Set the second driver
		RemoteWebDriver driver2 = DriverFactorySecond.getInstance().getDriver();
		perform.manageDriver(driver2);
		
		// Open a new browser and go to Secure
		driver2.get(StoredVariables.getsecureSite().get());
		
		// Wait for email textbox in second window
		WebDriverWait wait = new WebDriverWait(driver2, 40);
		WebElement emailTextbox = wait.until(ExpectedConditions.elementToBeClickable(By.id(SLogin.email_txtbx())));
		
		// Enter email address
		perform.type(driver, SLogin.email_txtbx(driver2), "automation" + StoredVariables.getusernameEnvironment().get() + "OpenedBy1SU@dntest.net");
		
		// Enter password
		perform.type(driver, SLogin.password_txtbx(driver2), StoredVariables.getpassword().get());
		
		// Click Sign In
		perform.click(driver, SLogin.signIn_btn(driver2));
		
		// Wait for the Find textbox
		WebElement findTextbox = wait.until(ExpectedConditions.elementToBeClickable(By.id(SOrders.find_txtbx())));
		
		// Check for overlay if it is the first time the page is opened since run
		try
		{
			// Click Find textbox
			perform.click(driver, SOrders.find_txtbx(driver2));
		} // end try
		catch (Exception e) {
			try
			{
			// Close overlay
			WebElement closeOverlay = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(SOrders.closeOverlay_btn())));
			perform.click(driver, SOrders.closeOverlay_btn(driver2));
			}
			catch (Exception e1) {
				perform.click(driver, SOrders.no_btn(driver2));
			}
		} // end catch
		
		// Enter order number into Find textbox
		String trackingNumber = StoredVariables.gettrackingNumber().get();
		perform.type(driver, SOrders.find_txtbx(driver2), trackingNumber);
		
		// Select Tracking number in the dropdown
		Select documentType = new Select(driver2.findElement(By.id(SOrders.inField_dropdown())));   
		documentType.selectByVisibleText("Tracking number");
		
		// Click Contains radio button
		perform.click(driver, SOrders.contains_radioBtn(driver2));
		
		// Click Find button
		perform.click(driver, SOrders.find_btn(driver2));
		
		// Wait for overlay to be hidden
		Thread.sleep(2000);
		
		// Wait for overlay to go away
		String overlayHidden = Overlay.messageBusy(driver2).getAttribute("style");
		// Set 40 second while loop timeout
		long start_time = System.currentTimeMillis();
		long wait_time = 40000;
		long end_time = start_time + wait_time;
		while (System.currentTimeMillis() < end_time && overlayHidden.contains("visible")){
			Thread.sleep(1000);
			overlayHidden = Overlay.messageBusy(driver2).getAttribute("style");
			if (!overlayHidden.contains("visible"))
			{
				System.out.println("Overlay has been hidden");
				Thread.sleep(1000);
				break;
			} // end if
			Thread.sleep(1500);
		} // end while
		
		Thread.sleep(1000);
		
		// Wait for the grid to be visible
		WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SOrders.ordersTable_txt())));
		
		// Verify the Opened By column is blank
		String openedByText2 = driver2.findElement(By.cssSelector("#tblOrders > tbody > tr > td:nth-child(3)")).getText();
		System.out.println("openedByText2 = " + openedByText2);
		Assert.assertTrue(openedByText2.isEmpty(), "The Opened by column should be blank");
		
		/****************************************
		 * INITIAL DRIVER
		 ****************************************/
		
		// Find the order
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Verify the Opened By column is blank
		String openedByText = driver.findElement(By.cssSelector("#tblOrders > tbody > tr > td:nth-child(3)")).getText();
		System.out.println("openedByText = " + openedByText);
		Assert.assertTrue(openedByText.isEmpty(), "The Opened by column should be blank");
		
		// Open the order
		secure.openOrder(driver, trackingNumber);
		
		/****************************************
		 * SECOND DRIVER
		 ****************************************/
		
		// Open the order
		Actions action = new Actions(driver2);
		WebElement e = driver2.findElement(By.xpath("//td[contains(text(), '" + trackingNumber + "')]"));
		// Double Click the matching element
		perform.doubleClickInTable(driver2, trackingNumber);
		Thread.sleep(3000);
		
		// Wait for the Set status button to be clickable
		WebElement setStatusButton;
		try {
			setStatusButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(SOrderDetails.setStatus_btn())));
		} catch (Exception e2) {
			// Click View
			perform.click(driver, SOrders.view_btn(driver2));
			setStatusButton= wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(SOrderDetails.setStatus_btn())));
		} // end try/catch
		
		// Wait for the banner text
		WebElement bannerText2Element= wait.until(ExpectedConditions.elementToBeClickable(By.id(SOrderDetails.banner_txt())));
		
		// Verify banner text contains multiple order text
		String bannerText2 = driver2.findElement(By.id(SOrderDetails.banner_txt())).getText();
		Assert.assertTrue(bannerText2.contains("There are multiple orders for this property."), "The banner should only contain multiple orders text");
		
		/****************************************
		 * INITIAL DRIVER
		 ****************************************/
		
		// Go to the Account page
		secure.goToAccount(driver);
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Go to the Orders page
		secure.goToOrders(driver);
		
		// Find the order
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Verify the Opened By column now displays the sub user has the order opened
		openedByText = driver.findElement(By.cssSelector("#tblOrders > tbody > tr > td:nth-child(3)")).getText();
		System.out.println("openedByText = " + openedByText);
		
		// Orders grid should show the order is opened by the sub user
		// Set 2.5 minutes while loop timeout
		start_time = System.currentTimeMillis();
		wait_time = 150000;
		end_time = start_time + wait_time;
		while (System.currentTimeMillis() < end_time && !openedByText.contains("OpenedBy1SU"))
		{
			// Get the text again
			driver.navigate().refresh();
			perform.waitForElementToBeClickable(driver, "#tblOrders > tbody > tr > td:nth-child(3)", "cssSelector");
			openedByText = driver.findElement(By.cssSelector("#tblOrders > tbody > tr > td:nth-child(3)")).getText();
			if (openedByText.contains("OpenedBy1SU"))
			{
				break;
			}
			Thread.sleep(5000);
		} // end while
		
		Assert.assertTrue(openedByText.contains("Automation OpenedBy1SU"), "The Opened by column should show the sub user has the order opened");
		
		// Open the order
		secure.openOrder(driver, trackingNumber);
		
		// Wait for banner text
		perform.waitForElementToBeClickable(driver, SOrderDetails.banner_txt(), "id");
		
		// Verify the banner displays the sub user has the order opened
		String bannerText = SOrderDetails.banner_txt(driver).getText();
		Assert.assertTrue(bannerText.contains("There are multiple orders for this property."), "The banner text should contain information for both multiple orders and the order being opened by the sub user");
		Assert.assertTrue(bannerText.contains("This order is currently opened by Automation OpenedBy1SU."), "The banner text should contain information for both multiple orders and the order being opened by the sub user");
		
		/****************************************
		 * SECOND DRIVER
		 ****************************************/
		
		// Banner should update showing the order has been opened by the admin user
		bannerText2 = driver2.findElement(By.id(SOrderDetails.banner_txt())).getText();
		
		// Set 2.5 minutes while loop timeout
		start_time = System.currentTimeMillis();
		wait_time = 150000;
		end_time = start_time + wait_time;
		while (System.currentTimeMillis() < end_time && !bannerText2.contains("opened by"))
		{
			// Get the text again
			bannerText2 = driver2.findElement(By.id(SOrderDetails.banner_txt())).getText();
			if (bannerText2.contains("opened by"))
			{
				break;
			}
			Thread.sleep(2000);
		} // end while
		
		Assert.assertTrue(bannerText2.contains("There are multiple orders for this property."), "The banner text should contain information for both multiple orders and the order being opened by the sub user");
		Assert.assertTrue(bannerText2.contains("This order is currently opened by Automation OpenedBy1."), "The banner text should contain information for both multiple orders and the order being opened by the sub user");
		
		// Go back to the Orders screen
		perform.click(driver, driver2.findElement(By.cssSelector(SOrders.orders_btn())));
		
		// Wait for findTextbox
		findTextbox = wait.until(ExpectedConditions.elementToBeClickable(By.id(SOrders.find_txtbx())));
		
		/****************************************
		 * INITIAL DRIVER
		 ****************************************/
		
		// Verify the banner updates the sub user no longer has the order opened
		bannerText = SOrderDetails.banner_txt(driver).getText();
		
		// Set 2.5 minutes while loop timeout
		start_time = System.currentTimeMillis();
		wait_time = 150000;
		end_time = start_time + wait_time;
		while (System.currentTimeMillis() < end_time && bannerText.contains("opened by"))
		{
			// Get the text again
			bannerText = driver.findElement(By.id(SOrderDetails.banner_txt())).getText();
			if (!bannerText.contains("opened by"))
			{
				break;
			}
			Thread.sleep(5000);
			System.out.println("Waiting for 'opened by' in the banner text to go away");
		} // end while
		
		Assert.assertTrue(!bannerText.contains("This order is currently opened by Automation OpenedBy1."), "The banner text should only contain information for multiple orders");
		Assert.assertTrue(bannerText.contains("There are multiple orders for this property."), "The banner text should only contain information for multiple orders");
		
		// Log in as the Vendor
		vendors.login(driver, "Appraiser1", StoredVariables.getpassword().get());
		
		// Accept the order as the vendor
		vendors.acceptOrder(driver, trackingNumber);
		
		// Log back in to Secure
		secure.login(driver, "OpenedBy1", StoredVariables.getpassword().get());
		
		// Find the order
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Open the order
		secure.openOrder(driver, trackingNumber);
		
		// Wait for banner text
		perform.waitForElementToBeClickable(driver, SOrderDetails.banner_txt(), "id");
		
		// Click Edit
		perform.click(driver, SOrderDetails.edit_btn(driver));
		
		// Wait for Address textbox
		perform.waitForElementToBeClickable(driver, SNewOrder.address_txtbx(), "id");
		
		/****************************************
		 * SECOND DRIVER
		 ****************************************/
		
		// Open the order
		action = new Actions(driver2);
		e = driver2.findElement(By.xpath("//td[contains(text(), '" + trackingNumber + "')]"));
		// Double Click the matching element
		perform.doubleClickInTable(driver2, trackingNumber);
		Thread.sleep(3000);
		
		// Wait for the Set status button to be clickable
		try {
			setStatusButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(SOrderDetails.setStatus_btn())));
		} catch (Exception e2) {
			// Click View
			perform.click(driver, SOrders.view_btn(driver2));
			setStatusButton= wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(SOrderDetails.setStatus_btn())));
		} // end try/catch
		
		// Wait for the banner text
		bannerText2Element= wait.until(ExpectedConditions.elementToBeClickable(By.id(SOrderDetails.banner_txt())));
		
		// Verify banner text contains multiple order text
		bannerText2 = driver2.findElement(By.id(SOrderDetails.banner_txt())).getText();
		Assert.assertTrue(bannerText2.contains("There are multiple orders for this property."), "The banner text should contain information for both multiple orders and the order being opened by the sub user");
		Assert.assertTrue(bannerText2.contains("This order is currently opened by Automation OpenedBy1."), "The banner text should contain information for both multiple orders and the order being opened by the sub user");
		
		// Go back to the Orders screen
		perform.click(driver, driver2.findElement(By.cssSelector(SOrders.orders_btn())));
		
		// Wait for findTextbox
		findTextbox = wait.until(ExpectedConditions.elementToBeClickable(By.id(SOrders.find_txtbx())));
		
		/****************************************
		 * INITIAL DRIVER
		 ****************************************/
		
		// Go to the Orders page
		secure.goToOrders(driver);
		
		// Create and assign a new order to Appraiser1
		secure.createAndAssignNewResidentialAppraisalOrderUsingCustomFeePanel(driver, "OpenedBy1", "Appraiser1");
		trackingNumber = StoredVariables.gettrackingNumber().get();
		
		// Log in as the Vendor
		vendors.login(driver, "Appraiser1", StoredVariables.getpassword().get());
		
		// Decline the order as the vendor
		vendors.declineOrder(driver, trackingNumber);
		
		// Log back in to Secure
		secure.login(driver, "OpenedBy1", StoredVariables.getpassword().get());
		
		// Find the order
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Open the order
		secure.openOrder(driver, trackingNumber);
		
		// Wait for banner text
		perform.waitForElementToBeClickable(driver, SOrderDetails.banner_txt(), "id");
		
		/****************************************
		 * SECOND DRIVER
		 ****************************************/
		
		// Enter order number into Find textbox
		SOrders.find_txtbx(driver2).clear();
		perform.type(driver, SOrders.find_txtbx(driver2), trackingNumber);
		
		// Select Tracking number in the dropdown
		documentType = new Select(driver2.findElement(By.id(SOrders.inField_dropdown())));   
		documentType.selectByVisibleText("Tracking number");
		
		// Click Contains radio button
		perform.click(driver, SOrders.contains_radioBtn(driver2));
		
		// Click Find button
		perform.click(driver, SOrders.find_btn(driver2));
		
		// Wait for overlay to be hidden
		Thread.sleep(2000);
		
		// Wait for overlay to go away
		overlayHidden = Overlay.messageBusy(driver2).getAttribute("style");
		// Set 40 second while loop timeout
		start_time = System.currentTimeMillis();
		wait_time = 40000;
		end_time = start_time + wait_time;
		while (System.currentTimeMillis() < end_time && overlayHidden.contains("visible")){
			Thread.sleep(1000);
			overlayHidden = Overlay.messageBusy(driver2).getAttribute("style");
			if (!overlayHidden.contains("visible"))
			{
				System.out.println("Overlay has been hidden");
				Thread.sleep(1000);
				break;
			} // end if
			Thread.sleep(1500);
		} // end while
		
		Thread.sleep(1000);
		
		// Wait for the grid to be visible
		table = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SOrders.ordersTable_txt())));
		
		// Verify the Opened By column contains OpenedBy1
		openedByText2 = driver2.findElement(By.cssSelector("#tblOrders > tbody > tr > td:nth-child(3)")).getText();
		System.out.println("openedByText2 = " + openedByText2);
		Assert.assertTrue(openedByText2.contains("Automation OpenedBy1"), "The Opened by column should show that Automation OpenedBy1 has the order opened");
		
		// Open the order
		action = new Actions(driver2);
		e = driver2.findElement(By.xpath("//td[contains(text(), '" + trackingNumber + "')]"));
		// Double Click the matching element
		perform.doubleClickInTable(driver2, trackingNumber);
		Thread.sleep(3000);
		
		// Wait for the Set status button to be clickable
		try {
			setStatusButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(SOrderDetails.setStatus_btn())));
		} catch (Exception e2) {
			// Click View
			perform.click(driver, SOrders.view_btn(driver2));
			setStatusButton= wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(SOrderDetails.setStatus_btn())));
		} // end try/catch
		
		// Wait for the banner text
		bannerText2Element= wait.until(ExpectedConditions.elementToBeClickable(By.id(SOrderDetails.banner_txt())));
		
		// Verify banner text contains multiple order text
		bannerText2 = driver2.findElement(By.id(SOrderDetails.banner_txt())).getText();
		Assert.assertTrue(bannerText2.contains("There are multiple orders for this property."), "The banner text should contain information for both multiple orders and the order being opened by the sub user");
		Assert.assertTrue(bannerText2.contains("This order is currently opened by Automation OpenedBy1."), "The banner text should contain information for both multiple orders and the order being opened by the sub user");
		
		/****************************************
		 * INITIAL DRIVER
		 ****************************************/
		
		// Click the Reassign button
		perform.click(driver, SOrderDetails.reassign_btn(driver));
		
		// Check for related orders
		secure.checkForRelatedOrdersDialog(driver);
		
		// Sleep for 120 seconds
		Thread.sleep(120000);
		
		/****************************************
		 * SECOND DRIVER
		 ****************************************/
		
		// Verify banner text contains multiple order text
		bannerText2 = driver2.findElement(By.id(SOrderDetails.banner_txt())).getText();
		Assert.assertTrue(bannerText2.contains("There are multiple orders for this property."), "The banner text should contain information for both multiple orders and the order being opened by the sub user");
		Assert.assertTrue(bannerText2.contains("This order is currently opened by Automation OpenedBy1."), "The banner text should contain information for both multiple orders and the order being opened by the sub user");
		
		/****************************************
		 * INITIAL DRIVER
		 ****************************************/
		
		// Assign the order to Appraiser3
		// Select vendor
		perform.clickInTable_Contains(driver, "Appraiser3");
		
		// Verify the appraiser is selected
		Assert.assertTrue(SVendorSelection.feePanelSelectFirstRow_btn(driver).getAttribute("src").contains("/images/Checkmark-Small-Checked-Blue.O.png"), "Vendor is not selected");
		
		// Click Next
		perform.click(driver, SVendorSelection.nextTop_btn(driver));
		
		// Wait for Next button
		perform.waitForElementToBeClickable(driver, SConfirmOrder.nextTop_btn(), "id");
		
		// Sleep for 120 seconds
		Thread.sleep(120000);
		
		/****************************************
		 * SECOND DRIVER
		 ****************************************/
		
		// Verify banner text contains multiple order text
		bannerText2 = driver2.findElement(By.id(SOrderDetails.banner_txt())).getText();
		Assert.assertTrue(bannerText2.contains("There are multiple orders for this property."), "The banner text should contain information for both multiple orders and the order being opened by the sub user");
		Assert.assertTrue(bannerText2.contains("This order is currently opened by Automation OpenedBy1."), "The banner text should contain information for both multiple orders and the order being opened by the sub user");
		
		// Close the second driver
		DriverFactorySecond.getInstance().removeDriver();
		
		// Log test
		test.log(LogStatus.INFO, "Opened by Regression Test", "Verified the Opened by feature is working properly");
		
	} // end openedBy
	
} // end the OpenedBy class
