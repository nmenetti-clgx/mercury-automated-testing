package regressionSecure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Secure.SNewOrder;
import pageObjects.Secure.SOrderDetails;
import pageObjects.Secure.SOrders;
import pageObjects.Secure.SUsers;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Secure - Place New Order Permissions</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class PlaceNewOrderPermissions extends TestSetup {
	
	/** The user lender. */
	private final String userLender = "OpenedBy1";
	
	/** The user lender sub user. */
	private final String userLenderSubUser = "OpenedBy1SU";
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure as Lender</li>
	 * 	<li>Go to Users</li>
	 * 	<li>Select the sub user</li>
	 * 	<li>Verify the sub user is selected</li>
	 * 	<li>Click on the hyperlink if the permission 'Place New Orders'</li>
	 * 	<li>Verify Inspection is checked</li>
	 * 	<li>Uncheck some product types</li>
	 * 	<li>Uncheck Residential appraisal</li>
	 * 	<li>Uncheck Commercial appraisal</li>
	 * 	<li>Click OK &gt; Save</li>
	 * 	<li>Save settings</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Users", "Place New Order Permissions"}, alwaysRun=true)
	public void verifySettings() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		String password = StoredVariables.getpassword().get();
		
		// Login to Secure as Lender
		secure.login(driver, userLender, password);
		
		// Go to Users
		secure.goToUsers(driver);
		
		// Select the sub user
		perform.click(driver,driver.findElement(By.cssSelector("#divAdminMain > table > tbody > tr > td.BlueBox > div.User.Ellipsis")));
		
		// Verify the sub user is selected
		perform.waitForElementToBeClickable(driver, SUsers.primaryEmail_txtbx(), "id");
		String email = SUsers.primaryEmail_txtbx(driver).getAttribute("value");
		Assert.assertTrue(email.contains("OpenedBy1SU"), "The sub user was not selected");
		
		// Click on the hyperlink if the permission 'Place New Orders'
		perform.click(driver,driver.findElement(By.linkText("New Orders")));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for Inspection checkbox
		perform.waitForElementToBeClickable(driver, SUsers.inspection_checkbox(), "id");
		
		// Verify Inspection is checked
		if (!SUsers.inspection_checkbox(driver).isSelected())
		{
			perform.click(driver,driver.findElement(By.cssSelector("label[for='"+SUsers.inspection_checkbox()+"']")));
		}
		
		// Uncheck some product types
		// Uncheck Residential appraisal
		if (SUsers.residentialAppraisal_checkbox(driver).isSelected())
		{
			perform.click(driver,driver.findElement(By.cssSelector("label[for='"+SUsers.residentialAppraisal_checkbox()+"']")));
		}
		// Uncheck Commercial appraisal
		if (SUsers.commercialAppraisal_checkbox(driver).isSelected())
		{
			perform.click(driver,driver.findElement(By.cssSelector("label[for='"+SUsers.commercialAppraisal_checkbox()+"']")));
		}
		
		// Click OK > Save
		perform.click(driver,SUsers.okPlaceNewOrders_btn(driver));
		
		// Save settings
		secure.saveUsersSettings(driver);
		
		// Log test
		test.log(LogStatus.INFO, "Secure Regression Test", "Verified that the settings are correct for this regression test");
		
	} // end verifySettings
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set preferences and enable all status mapping</li>
	 * 	<li>Login to Secure as Lender</li>
	 * 	<li>Confirm they cannot start a new order on a product type they do not have permission for</li>
	 * 	<li>Click New</li>
	 * 	<li>Get list text</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Place New Order Permissions"}, dependsOnMethods="verifySettings")
	public void confirmSubUserCannotCreateNewOrder() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		String password = StoredVariables.getpassword().get();
		
		// Set preferences and enable all status mapping
		// Login to Secure as Lender
		secure.login(driver, userLenderSubUser, password);
		
		// Confirm they cannot start a new order on a product type they do not have permission for
		// Click New
		perform.clickInTable_Contains(driver, "New");
		
		// Get list text
		String list = SOrders.newOptions_list(driver).getText();
		System.out.println("list = " + list);
		Assert.assertTrue(!list.contains("Commercial"), "Commercial appraisal should not be in the list");
		
		// Log test
		test.log(LogStatus.INFO, "Secure Regression Test", "Verified that the sub user cannot create an order that they do not have permissions to");
		
	} // end confirmSubUserCannotCreateNewOrder
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set preferences and enable all status mapping</li>
	 * 	<li>Login to Secure as Lender</li>
	 * 	<li>Start a new Broker Price Opinion order</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Place New Order Permissions"}, dependsOnMethods="verifySettings")
	public void confirmSubUserCanCreateNewOrder() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		String password = StoredVariables.getpassword().get();
		
		// Set preferences and enable all status mapping
		// Login to Secure as Lender
		secure.login(driver, userLenderSubUser, password);
		
		// Start a new Broker Price Opinion order
		secure.goToBrokerPriceOpinion(driver);
		
		// Log test
		test.log(LogStatus.INFO, "Secure Regression Test", "Verified that the sub user can create an order that they do not have permissions to");
		
	} // end confirmSubUserCanCreateNewOrder
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set preferences and enable all status mapping</li>
	 * 	<li>Login to Secure as Lender</li>
	 * 	<li>Set the environment variable</li>
	 * 	<li>Set commercial appraisal order number</li>
	 * 	<li>Find the Order</li>
	 * 	<li>Open the Order</li>
	 * 	<li>Click Duplicate button</li>
	 * 	<li>Select Place a new order to the same vendor radio button</li>
	 * 	<li>Click the Enter New Order button</li>
	 * 	<li>Verify URL contains Unauthorized.aspx</li>
	 * 	<li>Verify text on page</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Orders", "Place New Order Permissions"}, dependsOnMethods="verifySettings")
	public void confirmSubUserCannotDuplicateNewOrder() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		String password = StoredVariables.getpassword().get();
		
		// Set preferences and enable all status mapping
		// Login to Secure as Lender
		secure.login(driver, userLenderSubUser, password);
		
		// Set the environment variable
		String env = StoredVariables.getusernameEnvironment().get();
		
		// Set commercial appraisal order number
		String orderNumber = "";
		if (env.contains("QA")) {
			orderNumber = "220514";
		} else if (env.contains("Beta")) {
			orderNumber = "23186705";
		} else if (env.contains("Live")) {
			orderNumber = "23187056";
		}
			
		// Find the Order
		secure.findOrder(driver, orderNumber, "Tracking number");
		
		// Open the Order
		secure.openOrder(driver, orderNumber);
		
		// Click Duplicate button
		perform.click(driver,SOrderDetails.duplicate_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Select Place a new order to the same vendor radio button
		perform.click(driver,SOrderDetails.placeANewOrderToTheSameVendor_radiobtn(driver));
		
		// Click the Enter New Order button
		perform.click(driver,SOrderDetails.enterNewOrder_btn(driver));
		
		// Wait for Unauthorized page
		WebElement pageText = driver.findElement(By.id("divPublicMainContent"));
		perform.waitForElementToBeClickable(driver, "divPublicMainContent", "id");

		// Verify URL contains Unauthorized.aspx
		String url = driver.getCurrentUrl().toString();
		Assert.assertTrue(url.contains("Unauthorized.aspx"), "The URL is incorrect. It should contain Unauthorized.aspx. URL = " + url);
		
		// Verify text on page
		Assert.assertTrue(pageText.getText().contains("You do not have permission to view this feature. Please contact your Mercury Network administrator."), "The text on the page is incorrect");
		
		// Log test
		test.log(LogStatus.INFO, "Secure Regression Test", "Verified that the sub user cannot create an order that they do not have permissions to");
		
	} // end confirmSubUserCannotDuplicateNewOrder
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set preferences and enable all status mapping</li>
	 * 	<li>Login to Secure as Lender</li>
	 * 	<li>Set the environment variable</li>
	 * 	<li>Set commercial appraisal order number</li>
	 * 	<li>Find the Order</li>
	 * 	<li>Open the Order</li>
	 * 	<li>Click Duplicate button</li>
	 * 	<li>Select Place a new order to the same vendor radio button</li>
	 * 	<li>Click the Enter New Order button</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Orders", "Place New Order Permissions"}, dependsOnMethods="verifySettings")
	public void confirmSubUserCanDuplicateNewOrder() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		String password = StoredVariables.getpassword().get();
		
		// Set preferences and enable all status mapping
		// Login to Secure as Lender
		secure.login(driver, userLenderSubUser, password);
		
		// Set the environment variable
		String env = StoredVariables.getusernameEnvironment().get();
		
		// Set commercial appraisal order number
		String orderNumber = "";
		if (env.contains("QA")) {
			orderNumber = "220541";
		} else if (env.contains("Beta")) {
			orderNumber = "23187155";
		} else if (env.contains("Live")) {
			orderNumber = "23187083";
		}
		
		// Find the Order
		secure.findOrder(driver, orderNumber, "Tracking number");
		
		// Open the Order
		secure.openOrder(driver, orderNumber);
		
		// Click Duplicate button
		perform.click(driver,SOrderDetails.duplicate_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Select Place a new order to the same vendor radio button
		perform.click(driver,SOrderDetails.placeANewOrderToADifferentVendor_radiobtn(driver));
		
		// Click the Enter New Order button
		perform.click(driver,SOrderDetails.enterNewOrder_btn(driver));
		
		// Wait for Address textbox
		perform.waitForElementToBeClickable(driver, SNewOrder.address_txtbx(), "id");
		
		// Log test
		test.log(LogStatus.INFO, "Secure Regression Test", "Verified that the sub user can create an order that they do not have permissions to");
		
	} // end confirmSubUserCanDuplicateNewOrder
	
} // end the StateRegulation class
