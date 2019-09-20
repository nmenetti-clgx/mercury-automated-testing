package baselineVendors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Vendors.VOrders;
import pageObjects.Vendors.VPreviewProfile;
import pageObjects.Vendors.VUsers;
import pageObjects.Vendors.VUsers_AddTrainee;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Baseline Vendors - Users</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class Vendors_Users extends TestSetup {
	
	/** The user. */
	private static String user = "BaselineAppraiser1";
	
	/** The email. */
	private static String email = "";
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Go to Users</li>
	 * 	<li>Click Professional</li>
	 * 	<li>Get text</li>
	 * 	<li>Verify text</li>
	 * 	<li>Get Profile Status text</li>
	 * 	<li>Verify Profile Status text</li>
	 * 	<li>Click Products</li>
	 * 	<li>Get text</li>
	 * 	<li>Verify text</li>
	 * 	<li>Get Profile Status text</li>
	 * 	<li>Verify Profile Status text</li>
	 * 	<li>Get Products Table Header text</li>
	 * 	<li>Verify Products Table Header text</li>
	 * 	<li>Click Commercial appraisal button</li>
	 * 	<li>Get Products Table Header text</li>
	 * 	<li>Verify Products Table Header text</li>
	 * 	<li>Click Broker Price Opinion button</li>
	 * 	<li>Get Products Table Header text</li>
	 * 	<li>Verify Products Table Header text</li>
	 * 	<li>Click Inspection button</li>
	 * 	<li>Get Products Table Header text</li>
	 * 	<li>Verify Products Table Header text</li>
	 * 	<li>Click Coverage</li>
	 * 	<li>Get text</li>
	 * 	<li>Verify text</li>
	 * 	<li>Get Profile Status text</li>
	 * 	<li>Verify Profile Status text</li>
	 * 	<li>Click My Panels</li>
	 * 	<li>Get text</li>
	 * 	<li>Verify text</li>
	 * 	<li>Get Profile Status text</li>
	 * 	<li>Verify Profile Status text</li>
	 * 	<li>Click Details</li>
	 * 	<li>Get text</li>
	 * 	<li>Verify text</li>
	 * 	<li>Get Profile Status text</li>
	 * 	<li>Verify Profile Status text</li>
	 * 	<li>Click the banner link</li>
	 * 	<li>Switch to new window</li>
	 * 	<li>Verify url</li>
	 * 	<li>Assert.assertTrue(driver.getCurrentUrl().equals("http:www.mercuryvmp.com/mercurymobile/"), "The url is incorrect");</li>
	 * 	<li>Close the new window</li>
	 * 	<li>Save</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Vendors - Users", "Vendors - Professional", "Vendors - Products", "Vendors - Coverage", "Vendors - My Panels"}, alwaysRun=true)
	public void profileTabs() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Log in to Vendors
		vendors.login(driver, user, StoredVariables.getpassword().get());
		
		// Go to Users
		vendors.goToUsers(driver);
		
		// Click Professional
		perform.click(driver,VUsers.professional_btn(driver));
		
		// Wait for Residential appraisal checkbox
		perform.waitForElementToBeClickable(driver, VUsers.residentialAppraisal_chkbx(), "id");
		
		// Get text
		String text = VUsers.profilePage_txt(driver).getText();
		
		// Verify text
		Assert.assertTrue(text.contains(""), "The text on the screen is incorrect");
		Assert.assertTrue(text.contains("Professional Experience"), "The text on the screen is incorrect");
		Assert.assertTrue(text.contains("Licenses"), "The text on the screen is incorrect");
		Assert.assertTrue(text.contains("Insurance Policies"), "The text on the screen is incorrect");
		Assert.assertTrue(text.contains("Attachments"), "The text on the screen is incorrect");
		Assert.assertTrue(text.contains("Notification Settings"), "The text on the screen is incorrect");
		
		// Get Profile Status text
		String profileText = VUsers.profileStatus_txt(driver).getText();
		
		// Verify Profile Status text
		Assert.assertTrue(profileText.contains("Enabled"), "The Profile Status text on the screen is incorrect");
		Assert.assertTrue(profileText.contains("License"), "The Profile Status text on the screen is incorrect");
		Assert.assertTrue(profileText.contains("E & O"), "The Profile Status text on the screen is incorrect");
		Assert.assertTrue(profileText.contains("Products"), "The Profile Status text on the screen is incorrect");
		Assert.assertTrue(profileText.contains("Coverage"), "The Profile Status text on the screen is incorrect");
		
		// Click Products
		perform.click(driver,VUsers.products_btn(driver));
		
		// Wait for ACH checkbox
		perform.waitForElementToBeClickable(driver, VUsers.ach_chkbx(), "id");
		
		// Get text
		text = VUsers.profilePage_txt(driver).getText();
		
		// Verify text
		Assert.assertTrue(text.contains("Default Products and Fees"), "The text on the screen is incorrect");
		
		// Get Profile Status text
		profileText = VUsers.profileStatus_txt(driver).getText();
		
		// Verify Profile Status text
		Assert.assertTrue(profileText.contains("Enabled"), "The Profile Status text on the screen is incorrect");
		Assert.assertTrue(profileText.contains("License"), "The Profile Status text on the screen is incorrect");
		Assert.assertTrue(profileText.contains("E & O"), "The Profile Status text on the screen is incorrect");
		Assert.assertTrue(profileText.contains("Products"), "The Profile Status text on the screen is incorrect");
		Assert.assertTrue(profileText.contains("Coverage"), "The Profile Status text on the screen is incorrect");
		
		// Get Products Table Header text
		String residentialAppraisalTableHeaderText = VUsers.residentialAppraisalTableHeader_txt(driver).getText(); 
		
		// Verify Products Table Header text
		Assert.assertTrue(residentialAppraisalTableHeaderText.contains("Product"), "Text from the table header is missing");
		Assert.assertTrue(residentialAppraisalTableHeaderText.contains("Fee"), "Text from the table header is missing");
		Assert.assertTrue(residentialAppraisalTableHeaderText.contains("Fee Notes"), "Text from the table header is missing");
		
		// Click Commercial appraisal button
		perform.click(driver,VUsers.commercialAppraisal_btn(driver));
		
		// Wait for table header text
		perform.waitForElementToBeClickable(driver, VUsers.commercialAppraisalTableHeader_txt(), "cssSelector");
		
		// Get Products Table Header text
		String commercialAppraisalTableHeaderText = VUsers.commercialAppraisalTableHeader_txt(driver).getText(); 
		
		// Verify Products Table Header text
		Assert.assertTrue(commercialAppraisalTableHeaderText.contains("Product"), "Text from the table header is missing");
		Assert.assertTrue(commercialAppraisalTableHeaderText.contains("Offer"), "Text from the table header is missing");
		Assert.assertTrue(commercialAppraisalTableHeaderText.contains("Fee"), "Text from the table header is missing");
		Assert.assertTrue(commercialAppraisalTableHeaderText.contains("Fee Notes"), "Text from the table header is missing");
		
		// Click Broker Price Opinion button
		perform.click(driver,VUsers.brokerPriceOpinion_btn(driver));
		
		// Wait for table header text
		perform.waitForElementToBeClickable(driver, VUsers.brokerPriceOpinionTableHeader_txt(), "cssSelector");
		
		// Get Products Table Header text
		String brokerPriceOpinionTableHeaderText = VUsers.brokerPriceOpinionTableHeader_txt(driver).getText(); 
		
		// Verify Products Table Header text
		Assert.assertTrue(brokerPriceOpinionTableHeaderText.contains("Product"), "Text from the table header is missing");
		Assert.assertTrue(brokerPriceOpinionTableHeaderText.contains("Fee"), "Text from the table header is missing");
		Assert.assertTrue(brokerPriceOpinionTableHeaderText.contains("Fee Notes"), "Text from the table header is missing");
		
		// Click Inspection button
		perform.click(driver,VUsers.inspection_btn(driver));
		
		// Wait for table header text
		perform.waitForElementToBeClickable(driver, VUsers.inspectionTableHeader_txt(), "cssSelector");
		
		// Get Products Table Header text
		String inspectionTableHeaderText = VUsers.inspectionTableHeader_txt(driver).getText(); 
		
		// Verify Products Table Header text
		Assert.assertTrue(inspectionTableHeaderText.contains("Product"), "Text from the table header is missing");
		Assert.assertTrue(inspectionTableHeaderText.contains("Fee"), "Text from the table header is missing");
		Assert.assertTrue(inspectionTableHeaderText.contains("Fee Notes"), "Text from the table header is missing");
				
		// Click Coverage
		perform.click(driver,VUsers.coverage_btn(driver));
		
		// Wait for Select button
		perform.waitForElementToBeClickable(driver, VUsers.select_btn(), "cssSelector");
		
		// Get text
		text = VUsers.coveragePage_txt(driver).getText();
		
		// Verify text
		Assert.assertTrue(text.contains("County Based Coverage"), "The text on the screen is incorrect");
		
		// Get Profile Status text
		profileText = VUsers.profileStatus_txt(driver).getText();
		
		// Verify Profile Status text
		Assert.assertTrue(profileText.contains("Enabled"), "The Profile Status text on the screen is incorrect");
		Assert.assertTrue(profileText.contains("License"), "The Profile Status text on the screen is incorrect");
		Assert.assertTrue(profileText.contains("E & O"), "The Profile Status text on the screen is incorrect");
		Assert.assertTrue(profileText.contains("Products"), "The Profile Status text on the screen is incorrect");
		Assert.assertTrue(profileText.contains("Coverage"), "The Profile Status text on the screen is incorrect");
		
		// Click My Panels
		perform.click(driver,VUsers.myPanels_btn(driver));
		
		Thread.sleep(2000);
		
		// Get text
		text = VUsers.page_txt(driver).getText();
		
		// Verify text
		Assert.assertTrue(text.contains("Fee Panel Memberships"), "The text on the screen is incorrect");
		
		// Get Profile Status text
		profileText = VUsers.profileStatus_txt(driver).getText();
		
		// Verify Profile Status text
		Assert.assertTrue(profileText.contains("Enabled"), "The Profile Status text on the screen is incorrect");
		Assert.assertTrue(profileText.contains("License"), "The Profile Status text on the screen is incorrect");
		Assert.assertTrue(profileText.contains("E & O"), "The Profile Status text on the screen is incorrect");
		Assert.assertTrue(profileText.contains("Products"), "The Profile Status text on the screen is incorrect");
		Assert.assertTrue(profileText.contains("Coverage"), "The Profile Status text on the screen is incorrect");
		
		// Click Details
		perform.click(driver,VUsers.details_btn(driver));
		
		// Wait for Auto-accept checkbox
		perform.waitForElementToBeClickable(driver, VUsers.acceptOrderFromMercuryNetworkClients_chkbx(), "id");
		
		// Get text
		text = VUsers.profilePage_txt(driver).getText();
		
		// Verify text
		Assert.assertTrue(text.contains("Contact Information"), "The text on the screen is incorrect");
		
		// Get Profile Status text
		profileText = VUsers.profileStatus_txt(driver).getText();
		
		// Verify Profile Status text
		Assert.assertTrue(profileText.contains("Enabled"), "The Profile Status text on the screen is incorrect");
		Assert.assertTrue(profileText.contains("License"), "The Profile Status text on the screen is incorrect");
		Assert.assertTrue(profileText.contains("E & O"), "The Profile Status text on the screen is incorrect");
		Assert.assertTrue(profileText.contains("Products"), "The Profile Status text on the screen is incorrect");
		Assert.assertTrue(profileText.contains("Coverage"), "The Profile Status text on the screen is incorrect");
		
		// Click the banner link
		perform.click(driver,VUsers.banner_lnk(driver));
		
		// Switch to new window
		perform.switchToXSiteWindowByTitle(driver, "Appraisal Vendor Management Software Mobile");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().equals("https://www.mercuryvmp.com/mercurymobile/"), "The url is incorrect");
		
		// Close the new window
		perform.closeNewWindow(driver);
		
		// Save
		vendors.saveUsersSettings(driver);
		
		// Log test
		test.log(LogStatus.INFO, "Users", "Verified all the profile tabs on the Users screen");
		
	} // end profileTabs
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Go to Users</li>
	 * 	<li>if user already exists, delete it</li>
	 * 	<li>Select user</li>
	 * 	<li>Click Delete User</li>
	 * 	<li>Click Yes</li>
	 * 	<li>Click OK</li>
	 * 	<li>Get table text</li>
	 * 	<li>Verify user is displayed in Users</li>
	 * 	<li>Click Create New User</li>
	 * 	<li>Enter primary email</li>
	 * 	<li>Enter Password</li>
	 * 	<li>Enter Confirm password</li>
	 * 	<li>Enter First Name</li>
	 * 	<li>Enter Last Name</li>
	 * 	<li>Click Professional</li>
	 * 	<li>Click Residential appraisal checkbox</li>
	 * 	<li>Click Commercial appraisal checkbox</li>
	 * 	<li>Click Inspection checkbox</li>
	 * 	<li>Click Broker Price Opinion checkbox</li>
	 * 	<li>Enter year</li>
	 * 	<li>Enter year</li>
	 * 	<li>Enter year</li>
	 * 	<li>Enter year</li>
	 * 	<li>Click Coverage</li>
	 * 	<li>Click Oklahoma</li>
	 * 	<li>Click A</li>
	 * 	<li>Select all counties</li>
	 * 	<li>driver.findElement(By.xpath("td[text()='Woodward']")))</li>
	 * 	<li>Click Select</li>
	 * 	<li>Click Save</li>
	 * 	<li>Click OK</li>
	 * 	<li>Verify user is displayed in Users</li>
	 * 	<li>Save</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Vendors - Users", "Vendors - Create Sub User", "Vendors - Professional", "Vendors - Coverage"}, alwaysRun=true)
	public void createNewUser() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		if (StoredVariables.getmobile().get()==false) {
		
			// Log in to Vendors
			vendors.login(driver, user, StoredVariables.getpassword().get());
			
			// Go to Users
			vendors.goToUsers(driver);
			
			// if user already exists, delete it
			String text = VUsers.usersTable_txt(driver).getText();
			while (text.contains("Automation TestUser"))
			{
				
				// Select user
				perform.clickInTable_Contains(driver, "Automation TestUser");
				
				// Wait for busy
				perform.waitForBusyToBeHidden(driver);
				
				// Wait for delete button
				perform.waitForElementToBeClickable(driver, VUsers.deleteUser_btn(), "cssSelector");
				
				// Click Delete User
				perform.clickInTable_Contains(driver, "Delete User");
				
				// Wait for overlay
				perform.waitForOverlayToBeVisible(driver);
				
				// Click Yes
				perform.click(driver,VUsers.yesDeleteUser_btn(driver));
				
				// Wait for busy
				perform.waitForBusyToBeHidden(driver);
				
				// Wait for ok button
				perform.waitForElementToBeClickable(driver, VUsers.yesDeleteUser_btn(), "id");
				
				// Click OK
				perform.click(driver,VUsers.yesDeleteUser_btn(driver));
				
				// Wait for overlay to be hidden
				perform.waitForOverlayToBeHidden(driver);
				
				// Get table text
				text = VUsers.usersTable_txt(driver).getText();
				
			} // end while
	
			// Verify user is displayed in Users
			Assert.assertTrue(!VUsers.usersTable_txt(driver).getText().contains("Automation TestUser"), "The user was not deleted");
			
			// Click Create New User
			perform.click(driver,VUsers.createNewUser_btn(driver));
			
			// Wait for Primary Email textbox
			perform.waitForElementToBeClickable(driver, VUsers.primaryEmail_txtbx(), "id");
			
			Thread.sleep(1000);
			
			// Enter primary email
			email = "automationtestuser" + perform.randomNumbers(driver, 15) + StoredVariables.getcatchAllDomain().get();
			perform.type(driver, VUsers.primaryEmail_txtbx(driver), email);
			
			Thread.sleep(1000);
			
			// Enter Password
			perform.type(driver, VUsers.password_txtbx(driver), StoredVariables.getpassword().get());
			
			// Enter Confirm password
			perform.type(driver, VUsers.confirmPassword_txtbx(driver), StoredVariables.getpassword().get());
			
			// Enter First Name
			perform.type(driver, VUsers.firstName_txtbx(driver), "Automation");
			
			// Enter Last Name
			perform.type(driver, VUsers.lastName_txtbx(driver), "TestUser");
			
			// Click Professional
			perform.click(driver,VUsers.professional_btn(driver));
			
			// Wait for Residential appraisal checkbox
			perform.waitForElementToBeClickable(driver, VUsers.residentialAppraisal_chkbx(), "id");
			
			// Click Residential appraisal checkbox
			perform.checkCheckbox(driver, VUsers.residentialAppraisal_chkbx(driver));
			
			// Click Commercial appraisal checkbox
			perform.checkCheckbox(driver, VUsers.commercialAppraisal_chkbx(driver));
			
			// Click Inspection checkbox
			perform.checkCheckbox(driver, VUsers.inspection_chkbx(driver));
			
			// Click Broker Price Opinion checkbox
			perform.checkCheckbox(driver, VUsers.brokerPriceOpinion_chkbx(driver));
			
			// Enter year
			perform.type(driver, VUsers.residentialAppraisalYear_txtbx(driver), "2000");
			
			// Enter year
			perform.type(driver, VUsers.commercialAppraisalYear_txtbx(driver), "2000");
			
			// Enter year
			perform.type(driver, VUsers.inspectionYear_txtbx(driver), "2000");
			
			// Enter year
			perform.type(driver, VUsers.brokerPriceOpinionYear_txtbx(driver), "2000");
			
			// Click Coverage
			perform.click(driver,VUsers.coverage_btn(driver));
			
			// Wait for Select button
			perform.waitForElementToBeClickable(driver, VUsers.select_btn(), "cssSelector");
			
			// Click Oklahoma
			perform.click(driver,driver.findElement(By.xpath("//*[@id='tblccStates']/tbody/tr[39]/td")));
			
			// Wait for counties to load
			perform.waitForText(driver, VUsers.counties_txt(driver), "Adair");
			
			// Click A
			perform.clickInTable_Equals(driver, "A");
			
			// Select all counties
			Actions actions = new Actions(driver);
			actions.keyDown(Keys.LEFT_SHIFT)
			    .click(driver.findElement(By.xpath("//td[text()='Woodward']")))
			    .keyUp(Keys.LEFT_SHIFT)
			    .build()
			    .perform();
			
			// Click Select
			perform.click(driver,VUsers.select_btn(driver));
			
			// Click Save
			perform.click(driver,VUsers.save_btn(driver));
			
			// Wait for overlay
			perform.waitForOverlayToBeVisible(driver);
			
			// Wait for the OK button
			perform.waitForElementToBeClickable(driver, VUsers.okSave_btn(), "id");
			
			// Click OK
			perform.click(driver,VUsers.okSave_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			// Wait for User to be added
			perform.waitForText(driver, VUsers.usersTable_txt(driver), "Automation TestUser");
			
			// Verify user is displayed in Users
			Assert.assertTrue(VUsers.usersTable_txt(driver).getText().contains("Automation TestUser"), "The new created user is not displayed in the Users area");
			
			// Save
			vendors.saveUsersSettings(driver);
			
			// Log test
			test.log(LogStatus.INFO, "Users", "Created a new user");
			
		} else {
			
			// Log test
			test.log(LogStatus.INFO, "Users", "Did not create a new user because the process is not friently for mobile");
			
		} // end if/else
		
	} // end createNewUser
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Go to Users</li>
	 * 	<li>Verify user already exists</li>
	 * 	<li>Fail the test because the user doesn't already exist</li>
	 * 	<li>Click Create New User</li>
	 * 	<li>Enter primary email</li>
	 * 	<li>Enter Password</li>
	 * 	<li>Enter Confirm password</li>
	 * 	<li>Enter First Name</li>
	 * 	<li>Enter Last Name</li>
	 * 	<li>Click Professional</li>
	 * 	<li>Click Residential appraisal checkbox</li>
	 * 	<li>Enter year</li>
	 * 	<li>Click Save</li>
	 * 	<li>Verify alert dialog text</li>
	 * 	<li>Click OK</li>
	 * 	<li>Verify user is displayed in Users</li>
	 * 	<li>Click Orders</li>
	 * 	<li>Click No</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Vendors - Users", "Vendors - Create Sub User", "Vendors - Professional", "Vendors - Coverage"}, dependsOnMethods={"createNewUser"})
	public void cannotCreateExistingUser() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		if (StoredVariables.getmobile().get()==false) {
		
			// Log in to Vendors
			vendors.login(driver, user, StoredVariables.getpassword().get());
			
			// Go to Users
			vendors.goToUsers(driver);
			
			// Verify user already exists
			if (!VUsers.usersTable_txt(driver).getText().contains("Automation TestUser"))
			{
				// Fail the test because the user doesn't already exist
				test.log(LogStatus.FAIL, "users", "Cannot test creating a user that already exists because the user does not exist");
			} // end if
			
			// Click Create New User
			perform.click(driver,VUsers.createNewUser_btn(driver));
			
			// Wait for Primary Email textbox
			perform.waitForElementToBeClickable(driver, VUsers.primaryEmail_txtbx(), "id");
			
			Thread.sleep(1000);
			
			// Enter primary email
			perform.type(driver, VUsers.primaryEmail_txtbx(driver), email);
			
			Thread.sleep(1000);
			
			// Enter Password
			perform.type(driver, VUsers.password_txtbx(driver), StoredVariables.getpassword().get());
			
			// Enter Confirm password
			perform.type(driver, VUsers.confirmPassword_txtbx(driver), StoredVariables.getpassword().get());
			
			// Enter First Name
			perform.type(driver, VUsers.firstName_txtbx(driver), "Automation");
			
			// Enter Last Name
			perform.type(driver, VUsers.lastName_txtbx(driver), "TestUser");
			
			// Click Professional
			perform.click(driver,VUsers.professional_btn(driver));
			
			// Wait for Residential appraisal checkbox
			perform.waitForElementToBeClickable(driver, VUsers.residentialAppraisal_chkbx(), "id");
			
			// Click Residential appraisal checkbox
			perform.checkCheckbox(driver, VUsers.residentialAppraisal_chkbx(driver));
			
			// Enter year
			perform.type(driver, VUsers.residentialAppraisalYear_txtbx(driver), "2000");
			
			// Click Save
			perform.click(driver,VUsers.save_btn(driver));
			
			// Wait for overlay
			perform.waitForOverlayToBeVisible(driver);
			
			// Verify alert dialog text
			Assert.assertTrue(VUsers.alertDialog_txt(driver).getText().contains("An account already exists with this e-mail address."), "Error message is incorrect");
			
			// Click OK
			perform.click(driver,VUsers.okAlert_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			// Verify user is displayed in Users
			Assert.assertTrue(VUsers.usersTable_txt(driver).getText().contains("Automation TestUser"), "The new created user is not displayed in the Users area");
			
			// Click Orders
			perform.click(driver,VOrders.orders_btn(driver));
			
			// Wait for overlay
			perform.waitForOverlayToBeVisible(driver);
			
			// Click No
			perform.click(driver,VUsers.noSave_btn(driver));
			
			// Wait for overlay to be hidden]
			perform.waitForOverlayToBeHidden(driver);
			
			// Log test
			test.log(LogStatus.INFO, "users", "Verified you cannot create a user that already exists");
			
		} else {
			
			// Log test
			test.log(LogStatus.INFO, "Users", "Did not create a new user because the process is not friently for mobile");
			
		} // end if/else
		
	} // end cannotCreateExistingUser
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Go to Users</li>
	 * 	<li>Select user</li>
	 * 	<li>Click Delete User</li>
	 * 	<li>Verify dialog text</li>
	 * 	<li>Click Yes</li>
	 * 	<li>Verify dialog text</li>
	 * 	<li>Click OK</li>
	 * 	<li>Verify user is displayed in Users</li>
	 * 	<li>Save</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Vendors - Users", "Vendors - Delete User"}, dependsOnMethods={"cannotCreateExistingUser"})
	public void deleteUser() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		if (StoredVariables.getmobile().get()==false) {

			// Log in to Vendors
			vendors.login(driver, user, StoredVariables.getpassword().get());
			
			// Go to Users
			vendors.goToUsers(driver);
			
			// Select user
			perform.clickInTable_Contains(driver, "Automation TestUser");
			
			Thread.sleep(1000);
			
			// Wait for delete button
			perform.waitForElementToBeClickable(driver, VUsers.deleteUser_btn(), "cssSelector");
			
			// Click Delete User
			perform.clickInTable_Contains(driver, "Delete User");
			
			// Wait for overlay
			perform.waitForOverlayToBeVisible(driver);
			
			// Verify dialog text
			Assert.assertTrue(VUsers.alertDialog_txt(driver).getText().contains("Are you sure you want to delete this user?"), "The confirm delete dialog is incorrect");
			
			// Click Yes
			perform.click(driver,VUsers.yesDeleteUser_btn(driver));
			
			// Wait for ok button
			perform.waitForElementToBeClickable(driver, VUsers.yesDeleteUser_btn(), "id");
			
			// Verify dialog text
			Assert.assertTrue(VUsers.alertDialog_txt(driver).getText().contains("Selected user was successfully deleted."), "The confirm delete dialog is incorrect");
			
			// Click OK
			perform.click(driver,VUsers.yesDeleteUser_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			// Verify user is displayed in Users
			Assert.assertTrue(!VUsers.usersTable_txt(driver).getText().contains("Automation TestUser"), "The user was not deleted");
			
			// Save
			vendors.saveUsersSettings(driver);
			
			// Log test
			test.log(LogStatus.INFO, "users", "Deleted the new user");
			
		} else {
			
			// Log test
			test.log(LogStatus.INFO, "Users", "Did not delete a new user because the process is not friently for mobile");
			
		} // end if/else
		
	} // end deleteUser
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Go to Users</li>
	 * 	<li>Click Professional</li>
	 * 	<li>if license already exists, delete it</li>
	 * 	<li>Click the delete button</li>
	 * 	<li>Verify dialog text</li>
	 * 	<li>Click Yes</li>
	 * 	<li>Get text</li>
	 * 	<li>Save</li>
	 * 	<li>Click Add trainee</li>
	 * 	<li>Enter First Name</li>
	 * 	<li>Enter Last Name</li>
	 * 	<li>Verify there are no states in the dropdown</li>
	 * 	<li>Enter License Number</li>
	 * 	<li>Enter Expiration Date</li>
	 * 	<li>Click Save</li>
	 * 	<li>Verify Error dialog</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Vendors - Users", "Vendors - Professional", "Vendors - Trainee"}, alwaysRun=true)
	public void verifyYouCannotAddTraineeWithoutALicense() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Log in to Vendors
		vendors.login(driver, user, StoredVariables.getpassword().get());
		
		// Go to Users
		vendors.goToUsers(driver);
		
		// Click Professional
		perform.click(driver,VUsers.professional_btn(driver));
		
		// Wait for Residential appraisal checkbox
		perform.waitForElementToBeClickable(driver, VUsers.residentialAppraisal_chkbx(), "id");
		
		// if license already exists, delete it
		boolean licenseExists = perform.checkIfElementExists(driver, By.cssSelector(VUsers.deleteLicense_btn()));
		while (licenseExists==true) {
			vendors.deleteLicense(driver);
			licenseExists = perform.checkIfElementExists(driver, By.cssSelector(VUsers.deleteLicense_btn()));
		} // end if
		
		// Save
		vendors.saveUsersSettings(driver);
		
		// Click Add trainee
		perform.click(driver,driver.findElement(By.linkText("Add trainee")));;

		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for First Name
		perform.waitForElementToBeClickable(driver, VUsers_AddTrainee.firstName_txtbx(), "id");
		
		// Enter First Name
		perform.type(driver, VUsers_AddTrainee.firstName_txtbx(driver), "Automation");
		
		// Enter Last Name
		perform.type(driver, VUsers_AddTrainee.lastName_txtbx(driver), "Test");
		
		// Verify there are no states in the dropdown
		String[] expectedValues = {"Choose..."};
		perform.verifyDropdownOptions(driver, VUsers_AddTrainee.trainingState_dropdown(driver), expectedValues);
		
		// Enter License Number
		perform.type(driver, VUsers_AddTrainee.licenseNumber_txtbx(driver), perform.randomNumbers(driver, 10));
		
		// Enter Expiration Date
		perform.getNewDate(driver, 300);
		perform.type(driver, VUsers_AddTrainee.expirationDate_txtbx(driver), StoredVariables.getnewDateLong().get());
		
		// Click Save
		perform.click(driver,VUsers_AddTrainee.save_btn(driver));
		
		// Wait for OK button in error dialog
		perform.waitForElementToBeClickable(driver, VUsers_AddTrainee.ok_btn(driver));
		
		// Verify Error dialog
		String screenText = VUsers_AddTrainee.errorMessage_txt(driver).getText();
		String[] expected = {"Please correct the following issues and try again.","Please select the state in which you will supervise your trainee."};
		perform.verifyTextContains(driver, screenText, expected);
		
		// Log test
		test.log(LogStatus.INFO, "users", "Verify you can not add a state to a trainee without a licnese");
		
	} // end verifyYouCannotAddTraineeWithoutALicense
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Go to Orders</li>
	 * 	<li>Verify Missing info banner is displayed</li>
	 * 	<li>Go to Account</li>
	 * 	<li>Verify Missing info banner is displayed</li>
	 * 	<li>Go to Users</li>
	 * 	<li>Verify Missing info banner is displayed</li>
	 * 	<li>Click Professional</li>
	 * 	<li>Click Add</li>
	 * 	<li>Click License</li>
	 * 	<li>Select License Type</li>
	 * 	<li>Select State</li>
	 * 	<li>Enter License Number</li>
	 * 	<li>Enter Expiration Date</li>
	 * 	<li>Click Save</li>
	 * 	<li>Verify license was created</li>
	 * 	<li>Save</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Vendors - Users", "Vendors - Orders", "Vendors - License", "Vendors - Account", "Vendors - Professional"}, dependsOnMethods={"verifyYouCannotAddTraineeWithoutALicense"})
	public void addLicense() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		String env = StoredVariables.getusernameEnvironment().get();

		String licenseState = "";
		String licenseNumber = "";
		if (env.equals("QA")) {
			licenseState = "Kentucky";
			licenseNumber = "3221";
		} else if (env.equals("Live")) {
			licenseState = "Florida";
			licenseNumber = "RZ3849";
		} // end if/else if
		
		// Log in to Vendors
		vendors.login(driver, user, StoredVariables.getpassword().get());
		
		// Go to Orders
		vendors.goToOrders(driver);
		
		// Verify Missing info banner is displayed
		boolean exists = perform.checkIfElementExistsByCssSelector(driver, VOrders.vendorProfileBanner_txt());
		Assert.assertTrue(exists==true, "The Vendor Profile Banner should be dispalyed");
		String bannerText = VOrders.vendorProfileBanner_txt(driver).getText();
		Assert.assertTrue(bannerText.equals("WARNING:Your profile is missing critical information which can prevent you from receiving orders. Click here to fix it."), "The Vendor Profile Banner text is incorrect");
		
		// Go to Account
		vendors.goToAccount(driver);
		
		// Verify Missing info banner is displayed
		exists = perform.checkIfElementExistsByCssSelector(driver, VOrders.vendorProfileBanner_txt());
		Assert.assertTrue(exists==true, "The Vendor Profile Banner should be dispalyed");
		bannerText = VOrders.vendorProfileBanner_txt(driver).getText();
		Assert.assertTrue(bannerText.equals("WARNING:Your profile is missing critical information which can prevent you from receiving orders. Click here to fix it."), "The Vendor Profile Banner text is incorrect");
		
		// Go to Users
		vendors.goToUsers(driver);
		
		// Verify Missing info banner is displayed
		exists = perform.checkIfElementExistsByCssSelector(driver, VOrders.vendorProfileBanner_txt());
		Assert.assertTrue(exists==true, "The Vendor Profile Banner should be dispalyed");
		bannerText = VOrders.vendorProfileBanner_txt(driver).getText();
		Assert.assertTrue(bannerText.equals("WARNING:Your profile is missing critical information which can prevent you from receiving orders. Click here to fix it."), "The Vendor Profile Banner text is incorrect");
		
		// Click Professional
		perform.click(driver,VUsers.professional_btn(driver));
		
		// Wait for Residential appraisal checkbox
		perform.waitForElementToBeClickable(driver, VUsers.residentialAppraisal_chkbx(), "id");
		
		// Click Add
		perform.click(driver,VUsers.add_btn(driver));
		
		// Click License
		perform.click(driver,VUsers.license_btn(driver));
		
		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		// Select License Type
		perform.selectDropdownOption(driver, VUsers.licenseType_dropdown(driver), "Licensed Appraiser");
		
		// Select State
		perform.selectDropdownOption(driver, VUsers.state_dropdown(driver), licenseState);
		
		// Enter License Number
		perform.type(driver, VUsers.licenseNumber_txtbx(driver), licenseNumber);
		
		// Enter Expiration Date
		perform.getNewDate(driver, 300);
		perform.type(driver, VUsers.expirationDate_txtbx(driver), StoredVariables.getnewDateLong().get());
		
		// Click Save
		perform.click(driver,VUsers.saveLicense_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Verify license was created
		String getUnusedLicenseNumberQuery = "Select CASE A.LicenseType "
				+ " WHEN 1 THEN 'Licensed Appraiser' "
				+ " WHEN 2 THEN 'Certified General' "
				+ " WHEN 3 THEN 'Certified Residential' "
				+ " WHEN 4 THEN 'Trainee' "
				+ "END AS LicenseType, A.* "
				+ "From Mercury.dbo.ASCLicenses A "
				+ "LEFT JOIN Mercury.dbo.Licenses L ON L.LicenseNumber = A.LicenseNumber "
				+ "WHERE A.ExpDate > GetDate() "
				+ " AND L.LicenseID IS NULL "
				+ "Order BY A.LicenseNumber DESC";
		Assert.assertTrue(VUsers.licenses_txt(driver).getText().contains("Licensed Appraiser"), "The license was not created. Get a new license number and state by using this query:\n" + getUnusedLicenseNumberQuery);
		
		// Save
		vendors.saveUsersSettings(driver);
		
		// Log test
		test.log(LogStatus.INFO, "users", "Added a new license");
		
	} // end addLicense
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Verify there is no banner</li>
	 * 	<li>Go to Users</li>
	 * 	<li>Verify there is no banner</li>
	 * 	<li>Go to Account</li>
	 * 	<li>Verify there is no banner</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Vendors - Users", "Vendors - Account"}, dependsOnMethods={"addLicense"})
	public void verifyBannerIsNotDisplayed() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Log in to Vendors
		vendors.login(driver, user, StoredVariables.getpassword().get());
		
		// Verify there is no banner
		boolean exists = perform.checkIfElementExistsByCssSelector(driver, VOrders.vendorProfileBanner_txt());
		Assert.assertTrue(exists==false, "The Vendor Profile Banner should not be dispalyed");
		
		// Go to Users
		vendors.goToUsers(driver);
		
		// Verify there is no banner
		exists = perform.checkIfElementExistsByCssSelector(driver, VOrders.vendorProfileBanner_txt());
		Assert.assertTrue(exists==false, "The Vendor Profile Banner should not be dispalyed");
		
		// Go to Account
		vendors.goToAccount(driver);
		
		// Verify there is no banner
		exists = perform.checkIfElementExistsByCssSelector(driver, VOrders.vendorProfileBanner_txt());
		Assert.assertTrue(exists==false, "The Vendor Profile Banner should not be dispalyed");

		// Log test
		test.log(LogStatus.INFO, "users", "Verify the Vendor Profile Banner is not displayed");
		
	} // end verifyBannerIsNotDisplayed
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Go to Users</li>
	 * 	<li>Click Professional</li>
	 * 	<li>Set the date for the expDate</li>
	 * 	<li>Add a trainee</li>
	 * 	<li>Add 2 more trainees to reach the max of 3</li>
	 * 	<li>Confirm after a total of three trainees on the user profile, the Add trainee link is no longer displayed</li>
	 * 	<li>Confirm there is text stating you have reached the maximum number of trainees</li>
	 * 	<li>Click Preview Profile</li>
	 * 	<li>Switch iframe</li>
	 * 	<li>Confirm there is a Trainees section</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Vendors - Users", "Vendors - Professional", "Vendors - Trainee"}, dependsOnMethods={"verifyBannerIsNotDisplayed"})
	public void addTrainee() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Log in to Vendors
		vendors.login(driver, user, StoredVariables.getpassword().get());
		
		// Go to Users
		vendors.goToUsers(driver);
		
		// Click Professional
		perform.click(driver,VUsers.professional_btn(driver));
		
		// Wait for Residential appraisal checkbox
		perform.waitForElementToBeClickable(driver, VUsers.residentialAppraisal_chkbx(), "id");

		// Set the date for the expDate
		perform.getNewDate(driver, 300);
		
		// Add a trainee
		String env = StoredVariables.getusernameEnvironment().get();
		String state = "";
		if (env.equals("QA")) {
			state = "Kentucky";
		} else if (env.equals("Live")) {
			state = "Florida";
		} // end if/else
		vendors.addTrainee(driver, "Automation", "Test", state, perform.randomNumbers(driver, 10), StoredVariables.getnewDateLong().get());

		// Add 2 more trainees to reach the max of 3
		vendors.addTrainee(driver, "Automation", "Test2", state, perform.randomNumbers(driver, 10), StoredVariables.getnewDateLong().get());
		vendors.addTrainee(driver, "Automation", "Test3", state, perform.randomNumbers(driver, 10), StoredVariables.getnewDateLong().get());
		
		// Confirm after a total of three trainees on the user profile, the Add trainee link is no longer displayed
		int size = driver.findElements(By.linkText("Add trainee")).size();
		Assert.assertTrue(size==0, "The Add trainee link should not be displayed");
		
		// Confirm there is text stating you have reached the maximum number of trainees
		Assert.assertTrue(VUsers.maxTrainee_txt(driver).getText().equals("You have reached the maximum number of trainees."), "There should be text saying you have reached the maximum number of trainees");
		
		// Click Preview Profile
		perform.click(driver,VUsers.previewProfile_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Switch iframe
		perform.waitForiFrameSrcAndSwitchToIt(driver, "Dialogs/Preview.aspx", By.cssSelector(VPreviewProfile.ok_btn()));
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, VPreviewProfile.ok_btn(driver));
		
		// Confirm there is a Trainees section
		String pageText = VPreviewProfile.page_txt(driver).getText();
		String[] expected = {"Trainees", "Test", "Test2", "Test3"};
		perform.verifyTextContains(driver, pageText, expected);

		// Log test
		test.log(LogStatus.INFO, "users", "Verify you can add a trainee");
		
	} // end addTrainee
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Go to Users</li>
	 * 	<li>Click Professional</li>
	 * 	<li>Click the delete button</li>
	 * 	<li>Verify dialog text</li>
	 * 	<li>Click Yes</li>
	 * 	<li>Verify the license got deleted</li>
	 * 	<li>Verify the trainee got deleted</li>
	 * 	<li>Save</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Vendors - Users", "Vendors - Professional", "Vendors - License", "Vendors - Trainee"}, dependsOnMethods={"addTrainee"})
	public void deleteLicense() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Log in to Vendors
		vendors.login(driver, user, StoredVariables.getpassword().get());
		
		// Go to Users
		vendors.goToUsers(driver);
		
		// Click Professional
		perform.click(driver,VUsers.professional_btn(driver));
		
		// Wait for Residential appraisal checkbox
		perform.waitForElementToBeClickable(driver, VUsers.residentialAppraisal_chkbx(), "id");
		
//		// Click the delete button
//		perform.click(driver,driver.findElement(By.cssSelector("#_scroll > table > tbody > tr > td:nth-child(9) > img")));
//		
//		// Wait for overlay to be visible
//		perform.waitForOverlayToBeVisible(driver);
//		
//		// Wait for Yes button
//		perform.waitForElementToBeClickable(driver, VUsers.yesDeleteUser_btn(), "id");
//		
//		// Verify dialog text
//		Assert.assertTrue(VUsers.alertDialog_txt(driver).getText().contains("Are you sure you want to delete"), "The delete license dialog is incorrect");
//		
//		// Click Yes
//		perform.click(driver,VUsers.yesDeleteUser_btn(driver));
//		
//		// Wait for overlay to be hidden
//		perform.waitForOverlayToBeHidden(driver);
		
		// Delete the License
		vendors.deleteLicense(driver);
		
		// Verify the license got deleted
		Assert.assertTrue(!VUsers.licenses_txt(driver).getText().contains("OK"), "The license was not deleted");
		
		// Verify the trainee got deleted
		String traineeTable = VUsers.traineesTable(driver).getText();
		Assert.assertTrue(!traineeTable.contains("Test"), "The new trainee is not in the table correctly. Table = " + traineeTable);
		
		// Save
		vendors.saveUsersSettings(driver);

		// Log test
		test.log(LogStatus.INFO, "users", "Deleted a new license");
		
	} // end deleteLicense
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Verify Missing info banner is displayed</li>
	 * 	<li>Go to Users</li>
	 * 	<li>Verify Missing info banner is displayed</li>
	 * 	<li>Go to Account</li>
	 * 	<li>Verify Missing info banner is displayed</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Vendors - Users", "Vendors - Account"}, dependsOnMethods={"deleteLicense"})
	public void verifyBannerIsDisplayed() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Log in to Vendors
		vendors.login(driver, user, StoredVariables.getpassword().get());
		
		// Verify Missing info banner is displayed
		boolean exists = perform.checkIfElementExistsByCssSelector(driver, VOrders.vendorProfileBanner_txt());
		Assert.assertTrue(exists==true, "The Vendor Profile Banner should be dispalyed");
		String bannerText = VOrders.vendorProfileBanner_txt(driver).getText();
		Assert.assertTrue(bannerText.equals("WARNING:Your profile is missing critical information which can prevent you from receiving orders. Click here to fix it."), "The Vendor Profile Banner text is incorrect");
		
		// Go to Users
		vendors.goToUsers(driver);
		
		// Verify Missing info banner is displayed
		exists = perform.checkIfElementExistsByCssSelector(driver, VOrders.vendorProfileBanner_txt());
		Assert.assertTrue(exists==true, "The Vendor Profile Banner should be dispalyed");
		bannerText = VOrders.vendorProfileBanner_txt(driver).getText();
		Assert.assertTrue(bannerText.equals("WARNING:Your profile is missing critical information which can prevent you from receiving orders. Click here to fix it."), "The Vendor Profile Banner text is incorrect");
		
		// Go to Account
		vendors.goToAccount(driver);
		
		// Verify Missing info banner is displayed
		exists = perform.checkIfElementExistsByCssSelector(driver, VOrders.vendorProfileBanner_txt());
		Assert.assertTrue(exists==true, "The Vendor Profile Banner should be dispalyed");
		bannerText = VOrders.vendorProfileBanner_txt(driver).getText();
		Assert.assertTrue(bannerText.equals("WARNING:Your profile is missing critical information which can prevent you from receiving orders. Click here to fix it."), "The Vendor Profile Banner text is incorrect");

		// Log test
		test.log(LogStatus.INFO, "users", "Verify the Vendor Profile Banner is displayed");
		
	} // end verifyBannerIsDisplayed
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Go to Users</li>
	 * 	<li>Click Professional</li>
	 * 	<li>if insurance policy already exists, delete it</li>
	 * 	<li>Click the delete button</li>
	 * 	<li>Verify dialog text</li>
	 * 	<li>Click Yes</li>
	 * 	<li>Get text</li>
	 * 	<li>Click Add</li>
	 * 	<li>Click Insurance Policy</li>
	 * 	<li>Select Insurance Type</li>
	 * 	<li>Enter Carrier Name</li>
	 * 	<li>Enter Policy Number</li>
	 * 	<li>Enter Policy Amount</li>
	 * 	<li>Enter Expiration Date</li>
	 * 	<li>Click Save</li>
	 * 	<li>Verify insurance policy was created</li>
	 * 	<li>Save</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Vendors - Users", "Vendors - Professional", "Vendors - Insurance Policy"}, dependsOnMethods={"deleteLicense"})
	public void addInsurancePolicy() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Log in to Vendors
		vendors.login(driver, user, StoredVariables.getpassword().get());
		
		// Go to Users
		vendors.goToUsers(driver);
		
		// Click Professional
		perform.click(driver,VUsers.professional_btn(driver));
		
		// Wait for Residential appraisal checkbox
		perform.waitForElementToBeClickable(driver, VUsers.residentialAppraisal_chkbx(), "id");
		
		// if insurance policy already exists, delete it
		String text = VUsers.insurancePolicies_txt(driver).getText();
		while (text.contains("Test"))
		{
			
			// Click the delete button
			perform.click(driver,driver.findElement(By.cssSelector("#_scroll > table > tbody > tr > td:nth-child(9) > img")));
			
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			// Wait for Yes button
			perform.waitForElementToBeClickable(driver, VUsers.yesDeleteUser_btn(), "id");
			
			// Verify dialog text
			Assert.assertTrue(VUsers.alertDialog_txt(driver).getText().contains("Are you sure you want to delete"), "The delete license dialog is incorrect");
			
			// Click Yes
			perform.click(driver,VUsers.yesDeleteUser_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			// Get text
			text = VUsers.licenses_txt(driver).getText();
			
		} // end if
		
		// Click Add
		perform.click(driver,VUsers.add_btn(driver));
		
		// Click Insurance Policy
		perform.click(driver,VUsers.insurancePolicy_btn(driver));
		
		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		// Select Insurance Type
		perform.selectDropdownOption(driver, VUsers.insuranceType_dropdown(driver), "General Liability");
		
		// Enter Carrier Name
		perform.type(driver, VUsers.carrierName_txtbx(driver), "Test Carrier Name");
		
		// Enter Policy Number
		perform.type(driver, VUsers.policyNumber_txtbx(driver), perform.randomNumbers(driver, 10));
		
		// Enter Policy Amount
		perform.type(driver, VUsers.policyAmount_txtbx(driver), "350000");
		
		// Enter Expiration Date
		perform.getNewDate(driver, 300);
		perform.type(driver, VUsers.expirationDateInsurancePolicy_txtbx(driver), StoredVariables.getnewDateLong().get());
		
		// Click Save
		perform.click(driver,VUsers.saveLicense_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Verify insurance policy was created
		Assert.assertTrue(VUsers.insurancePolicies_txt(driver).getText().contains("Test Carrier Name"), "The insurance policy was not created");
		
		// Save
		vendors.saveUsersSettings(driver);
		
		// Log test
		test.log(LogStatus.INFO, "users", "Added a new insurance policy");
		
	} // end addInsurancePolicy
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Go to Users</li>
	 * 	<li>Click Professional</li>
	 * 	<li>Click the delete button</li>
	 * 	<li>Verify dialog text</li>
	 * 	<li>Click Yes</li>
	 * 	<li>Verify the license got deleted</li>
	 * 	<li>Save</li>
	 * 	<li>Log test</li>

* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Vendors - Users", "Vendors - Professional", "Vendors - Insurance Policy"}, dependsOnMethods={"addInsurancePolicy"})
	public void deleteInsurancePolicy() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Log in to Vendors
		vendors.login(driver, user, StoredVariables.getpassword().get());
		
		// Go to Users
		vendors.goToUsers(driver);
		
		// Click Professional
		perform.click(driver,VUsers.professional_btn(driver));
		
		// Wait for Residential appraisal checkbox
		perform.waitForElementToBeClickable(driver, VUsers.residentialAppraisal_chkbx(), "id");
		
		// Click the delete button
		perform.click(driver,driver.findElement(By.cssSelector("#_scroll > table > tbody > tr > td:nth-child(9) > img")));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for Yes button
		perform.waitForElementToBeClickable(driver, VUsers.yesDeleteUser_btn(), "id");
		
		// Verify dialog text
		Assert.assertTrue(VUsers.alertDialog_txt(driver).getText().contains("Are you sure you want to delete"), "The delete license dialog is incorrect");
		
		// Click Yes
		perform.click(driver,VUsers.yesDeleteUser_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Verify the license got deleted
		Assert.assertTrue(!VUsers.insurancePolicies_txt(driver).getText().contains("Test Carrier Name"), "The license was not deleted");
		
		// Save
		vendors.saveUsersSettings(driver);

		// Log test
		test.log(LogStatus.INFO, "users", "Deleted a new insurance policy");
		
	} // end deleteInsurancePolicy
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Go to Users</li>
	 * 	<li>Click Professional</li>
	 * 	<li>Click Add</li>
	 * 	<li>Click Attachment</li>
	 * 	<li>Select Attachment Type</li>
	 * 	<li>Click Cancel</li>
	 * 	<li>Click No</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Vendors - Users", "Vendors - Professional"}, alwaysRun=true)
	public void addAttachment() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Log in to Vendors
		vendors.login(driver, user, StoredVariables.getpassword().get());
		
		// Go to Users
		vendors.goToUsers(driver);
		
		// Click Professional
		perform.click(driver,VUsers.professional_btn(driver));
		
		// Wait for Residential appraisal checkbox
		perform.waitForElementToBeClickable(driver, VUsers.residentialAppraisal_chkbx(), "id");
		
		// Click Add
		perform.click(driver,VUsers.add_btn(driver));
		
		// Click Attachment
		perform.click(driver,VUsers.attachment_btn(driver));
		
		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		// Select Attachment Type
		perform.selectDropdownOption(driver, VUsers.attachmentType_dropdown(driver), "Other");
		
		// Click Cancel
		perform.click(driver,VUsers.cancel_btn(driver));
		
		// Wait for the No button
		perform.waitForElementToBeClickable(driver, VUsers.noSave_btn(), "id");
		
		// Click No
		perform.click(driver,VUsers.noSave_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Log test
		test.log(LogStatus.INFO, "users", "Verify attachment dialog opens");
		
	} // end addAttachment
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Go to Users</li>
	 * 	<li>Click on Baseline user</li>
	 * 	<li>Click Preview Profile</li>
	 * 	<li>Switch iFrame</li>
	 * 	<li>Verify text</li>
	 * 	<li>Click OK</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Vendors - Users", "Vendors - Profile"}, alwaysRun=true)
	public void previewProfile() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Log in to Vendors
		vendors.login(driver, user, StoredVariables.getpassword().get());
		
		// Go to Users
		vendors.goToUsers(driver);
		
		// Click on Baseline user
		perform.clickInTable_Contains(driver, "Automation Baseline");
		
		Thread.sleep(500);
		
		// Click Preview Profile
		perform.click(driver,VUsers.previewProfile_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		// Switch iFrame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "Dialogs/Preview.aspx", By.cssSelector(VUsers.ok_btn()));
		
		// Verify text
		String text = VUsers.previewProfile_txt(driver).getText();
		Assert.assertTrue(text.contains("Automation " + user), "Preview Profile dialog is missing text or text is incorrect");
		
		// Click OK
		perform.click(driver,VUsers.ok_btn(driver));
		
		// Get out of iFrame
		driver.switchTo().defaultContent();
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Log test
		test.log(LogStatus.INFO, "users", "Verify preview profile dialog box");
		
	} // end previewProfile
	
} // end the Secure_Login class
