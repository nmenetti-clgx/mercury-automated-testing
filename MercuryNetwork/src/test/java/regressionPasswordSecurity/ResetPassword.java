package regressionPasswordSecurity;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjects.CRM.CRM;
import pageObjects.CRM.CRMProducts;
//import pageObjects.CRM.CRMProducts;
import pageObjects.Overlay.Overlay;
import pageObjects.Secure.SAccount;
import pageObjects.Secure.SLogin;
import pageObjects.Secure.SOrders;
import pageObjects.Secure.SUsers;
import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Password Security - Reset Password</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
@Test(singleThreaded=true, groups= {"broken"})
public class ResetPassword extends TestSetup {
	
	/** The user. */
	private final String user = "PasswordSecurity2";
	
	/** The password. */
	private final String password = "T3sting1";
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get the environment</li>
	 * 	<li>Set the Customer Number</li>
	 * 	<li>Set the url</li>
	 * 	<li>Go to CRM</li>
	 * 	<li>Click Products</li>
	 * 	<li>Switch to iFrame</li>
	 * 	<li>Select All from the Status Filter dropdown</li>
	 * 	<li>Set login link</li>
	 * 	<li>Login</li>
	 * 	<li>Switch to the new window</li>
	 * 	<li>Go to Users</li>
	 * 	<li>Change the password 5 times</li>
	 * 	<li>Click the Password Gear icon</li>
	 * 	<li>Enter New PW</li>
	 * 	<li>Confirm New PW</li>
	 * 	<li>Click Save</li>
	 * 	<li>Change the password to T3sting1</li>
	 * 	<li>Click the Password Gear icon</li>
	 * 	<li>Enter New PW</li>
	 * 	<li>Confirm New PW</li>
	 * 	<li>Click Save</li>
	 * 	<li>Save the settings</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception 
	 */
	@Test (retryAnalyzer = Retry.class, groups={"broken", "Secure - Users", "Password Management On Secure"}, alwaysRun=true, priority=0)
	public void resetPW() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Get the environment
		String env = StoredVariables.getusernameEnvironment().get();
		
		// Set the Customer Number
		String custNo = "5013334041";
		if (env.equals("QA")) {
			custNo = "5011114041";
		} else if (env.equals("Beta")) {
			custNo = "5012224041";
		} // end if setting the custNo
		
		// Set the url
		String url = "https://crm.ad.mercuryvmp.com/customer/customermgt/customerinfo.aspx?ID="+custNo;
		if (env.equals("QA")) {
			url = "https://crmqa.ad.mercuryvmp.com/customer/customermgt/customerinfo.aspx?ID="+custNo;
		} // end if setting the url
		
		// Go to CRM
		System.out.println("URL: " + url);
		driver.get(url);
		System.out.println("Went to " + url);
		
		// Wait for Products button
		perform.waitForElementToBeClickable(driver, CRM.products_btn(), "id");
		
		// Click Products
		perform.click(driver,CRM.products_btn(driver));
		
		// Switch to iFrame
		perform.switchToiFrameByID(driver, "productsTab");
		
		// Wait for Status Filter dropdown
		perform.waitForElementToBeClickable(driver, CRMProducts.statusFilter_dropdown(), "id");
		
		// Select All from the Status Filter dropdown
		perform.selectDropdownOption(driver, CRMProducts.statusFilter_dropdown(driver), "All");
		
		// Wait for Mercury link
		perform.waitForElementToBeClickable(driver, "Mercury", "linkText");
		
		// Set login link
		String link = "Mercury";
		if (env.equals("Beta")) {
			link = "MN Beta";
		} // end if setting link

		Thread.sleep(3000);
		
		// Set the Login link as an element
		WebElement loginLink = driver.findElement(By.linkText(link));
		
		// Wait for login link element
		perform.waitForElementToBeClickable(driver, loginLink);
		
		// Click the Login link
		perform.click(driver,driver.findElement(By.linkText(link)));
		
		// Switch to the new window
		perform.switchToXSiteWindowByTitle(driver, "Orders");
		
		// Go to Users
		secure.goToUsers(driver);
		
		//Get Current Password
		String passPortid = null;
		if (env.equals("QA")){
			passPortid = "19225";
		} else if (env.equals("Beta")){
			passPortid = "733621";
		} else if (env.equals("Live")){
			passPortid = "733622";
		}
		
		String sqlStatement = "SELECT Password from customerdata.dbo.passport where PassportID = "+passPortid+"";
		String currentPassword = db.queryDB(driver, "customerdata", sqlStatement);
		
		// Change the password 5 times
		for (int a = 1; a <=5; a++)
		{
			
			String pw = "T1a"+perform.randomLetters(driver, 10);
		
			// Wait for the Password Gear Icon
			perform.waitForElementToBeClickable(driver, SUsers.passwordGear_icon(), "id");
			
			// Click the Password Gear icon
			perform.click(driver,SUsers.passwordGear_icon(driver));
			
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			// Wait for New
			perform.waitForElementToBeClickable(driver, SUsers.passwordSecurityOptions_txtbx(), "id");
			
			//Enter Current Password
			perform.type(driver, SUsers.currentPassword_txtbx(driver), currentPassword);
			
			// Enter New PW
			SUsers.passwordSecurityOptions_txtbx(driver).clear();
			perform.type(driver, SUsers.passwordSecurityOptions_txtbx(driver), pw);
			
			// Confirm New PW
			SUsers.confirmPasswordSecurityOptions_txtbx(driver).clear();
			perform.type(driver, SUsers.confirmPasswordSecurityOptions_txtbx(driver), pw);
			
			// Click Save
			perform.click(driver,SUsers.saveSecurityOptions_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			currentPassword = pw; 
		
		} // end for loop
		
		// Change the password to T3sting1
		// Wait for the Password Gear Icon
		perform.waitForElementToBeClickable(driver, SUsers.passwordGear_icon(), "id");
		
		// Click the Password Gear icon
		perform.click(driver,SUsers.passwordGear_icon(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for New
		perform.waitForElementToBeClickable(driver, SUsers.passwordSecurityOptions_txtbx(), "id");
		
		//Enter Current Password
		perform.type(driver, SUsers.currentPassword_txtbx(driver), currentPassword);
		
		// Enter New PW
		SUsers.passwordSecurityOptions_txtbx(driver).clear();
		perform.type(driver, SUsers.passwordSecurityOptions_txtbx(driver), "T3sting1");
		
		// Confirm New PW
		SUsers.confirmPasswordSecurityOptions_txtbx(driver).clear();
		perform.type(driver, SUsers.confirmPasswordSecurityOptions_txtbx(driver), "T3sting1");

		// Click Save
		perform.click(driver,SUsers.saveSecurityOptions_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Save the settings
		secure.saveUsersSettings(driver);
		
		Thread.sleep(3000);
	
		// Log test
		test.log(LogStatus.INFO, "Password Security", "Reset the password");
	}
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Check for No button</li>
	 * 	<li>Click Account</li>
	 * 	<li>If cancel link exists, click it</li>
	 * 	<li>Click Require password reset checkbox</li>
	 * 	<li>Select Require password reset dropdown</li>
	 * 	<li>Click Save</li>
	 * 	<li>Click Yes</li>
	 * 	<li>Verify Reset required text</li>
	 * 	<li>Verify checkbox is unchecked</li>
	 * 	<li>Get date</li>
	 * 	<li>Set new date value</li>
	 * 	<li>Verify database value</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Account", "Password Management On Secure"}, alwaysRun=true, priority=0)
	public void requirePasswordResetToday() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Login to Secure
		login(driver);
		
		// Check for No button
		if (Overlay.overlay(driver).getAttribute("style").contains("visible"))
		{
			perform.click(driver,SOrders.no_btn(driver));	
		}
		
		// Click Account
		secure.goToAccount(driver);
		
		// If cancel link exists, click it
		List<WebElement> cancelLink = driver.findElements(By.linkText("cancel"));
		System.out.println("cancelLink size = " + cancelLink.size());
		if (cancelLink.size()>0)
		{
			perform.click(driver,driver.findElement(By.linkText("cancel")));
			secure.goToAccount(driver);
		}
		
		// Click Require password reset checkbox
		if (SAccount.requirePasswordReset_chkbx(driver).isSelected()==false)
		{
			perform.click(driver,SAccount.requirePasswordReset_chkbx(driver));
		}
		
		// Select Require password reset dropdown
		perform.selectDropdownOption(driver, SAccount.requirePasswordResetInNumberOfDays_dropdown(driver), "Today");
		
		// Click Save
		perform.click(driver,SAccount.save_btn(driver));
		
		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for Yes button
		perform.waitForElementToBeClickable(driver, SAccount.yes_btn(), "id");
		
		// Click Yes
		perform.click(driver,SAccount.yes_btn(driver));
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SAccount.ok_btn(), "id");
		
		// Wait for OK button
		perform.click(driver,SAccount.ok_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Verify Reset required text
		Assert.assertTrue(SAccount.resetRequired_txt(driver).getText().contains("Reset required after"), "The reset required text did not display");
		
		// Verify checkbox is unchecked
		Assert.assertTrue(SAccount.requirePasswordReset_chkbx(driver).isSelected()==false, "The Require password reset checkbox is checked and shouldn't be");
		
		// Get date
		perform.getNewDate(driver, 0);
		
		// Set new date value
		String month = StoredVariables.getnewMonth2().get();
		String day = StoredVariables.getnewDay2().get();
		String year = StoredVariables.getnewYear().get();
		String newDate = year + "-" + month + "-" + day;
		
		// Verify database value
		Thread.sleep(2000);
		String PasswordExpireDateSQL = "SELECT PasswordResetDate FROM CustomerData.dbo.Passport WHERE EmailAddress = 'automation" + StoredVariables.getusernameEnvironment().get() + user + StoredVariables.getcatchAllDomain().get() + "'";
		String dbValue = db.queryDB(driver, "CustomerData", PasswordExpireDateSQL);
		Assert.assertTrue(dbValue.startsWith(newDate), "The database value for the PasswordResetDate is incorrect. Expected = " + newDate + "    But the value is = " + dbValue);
		
		// Log test
		test.log(LogStatus.INFO, "Password Security", "Verified table was updated with the correct date to reset the password");
		
	} // end requirePasswordResetToday
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Check for No button</li>
	 * 	<li>Click Account</li>
	 * 	<li>If cancel link exists, click it</li>
	 * 	<li>Click Require password reset checkbox</li>
	 * 	<li>Select Require password reset dropdown</li>
	 * 	<li>Click Save</li>
	 * 	<li>Click Yes</li>
	 * 	<li>Verify Reset required text</li>
	 * 	<li>Verify checkbox is unchecked</li>
	 * 	<li>Get date</li>
	 * 	<li>Set new date value</li>
	 * 	<li>Verify database value</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Account", "Password Management On Secure"}, alwaysRun=true, priority=1)
	public void requirePasswordResetIn1Day() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Login to Secure
		login(driver);
		
		// Check for No button
		if (Overlay.overlay(driver).getAttribute("style").contains("visible"))
		{
			perform.click(driver,SOrders.no_btn(driver));	
		}
		
		// Click Account
		secure.goToAccount(driver);
		
		// If cancel link exists, click it
		List<WebElement> cancelLink = driver.findElements(By.linkText("cancel"));
		System.out.println("cancelLink size = " + cancelLink.size());
		if (cancelLink.size()>0)
		{
			perform.click(driver,driver.findElement(By.linkText("cancel")));
			secure.goToAccount(driver);
		}
		
		// Click Require password reset checkbox
		if (SAccount.requirePasswordReset_chkbx(driver).isSelected()==false)
		{
			perform.click(driver,SAccount.requirePasswordReset_chkbx(driver));
		}
		
		// Select Require password reset dropdown
		perform.selectDropdownOption(driver, SAccount.requirePasswordResetInNumberOfDays_dropdown(driver), "1");
		
		// Click Save
		perform.click(driver,SAccount.save_btn(driver));
		
		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for Yes button
		perform.waitForElementToBeClickable(driver, SAccount.yes_btn(), "id");
		
		// Click Yes
		perform.click(driver,SAccount.yes_btn(driver));
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SAccount.ok_btn(), "id");
		
		// Wait for OK button
		perform.click(driver,SAccount.ok_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Verify Reset required text
		Assert.assertTrue(SAccount.resetRequired_txt(driver).getText().contains("Reset required after"), "The reset required text did not display");
		
		// Verify checkbox is unchecked
		Assert.assertTrue(SAccount.requirePasswordReset_chkbx(driver).isSelected()==false, "The Require password reset checkbox is checked and shouldn't be");
		
		// Get date
		perform.getNewDate(driver, 1);
		
		// Set new date value
		String month = StoredVariables.getnewMonth2().get();
		String day = StoredVariables.getnewDay2().get();
		String year = StoredVariables.getnewYear().get();
		String newDate = year + "-" + month + "-" + day;
		
		// Verify database value
		Thread.sleep(2000);
		String PasswordExpireDateSQL = "SELECT PasswordResetDate FROM CustomerData.dbo.Passport WHERE EmailAddress = 'automation" + StoredVariables.getusernameEnvironment().get() + user + StoredVariables.getcatchAllDomain().get() + "'";
		String dbValue = db.queryDB(driver, "CustomerData", PasswordExpireDateSQL);
		Assert.assertTrue(dbValue.startsWith(newDate), "The database value for the PasswordResetDate is incorrect. Expected = " + newDate + "    But the value is = " + dbValue);
		
		// Log test
		test.log(LogStatus.INFO, "Password Security", "Verified table was updated with the correct date to reset the password");
		
	} // end requirePasswordResetIn1Day
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Check for No button</li>
	 * 	<li>Click Account</li>
	 * 	<li>If cancel link exists, click it</li>
	 * 	<li>Click Require password reset checkbox</li>
	 * 	<li>Select Require password reset dropdown</li>
	 * 	<li>Click Save</li>
	 * 	<li>Click Yes</li>
	 * 	<li>Verify Reset required text</li>
	 * 	<li>Verify checkbox is unchecked</li>
	 * 	<li>Get date</li>
	 * 	<li>Set new date value</li>
	 * 	<li>Verify database value</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Account", "Password Management On Secure"}, alwaysRun=true, priority=2)
	public void requirePasswordResetIn7Days() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Login to Secure
		login(driver);
		
		// Check for No button
		if (Overlay.overlay(driver).getAttribute("style").contains("visible"))
		{
			perform.click(driver,SOrders.no_btn(driver));	
		}
		
		// Click Account
		secure.goToAccount(driver);
		
		// If cancel link exists, click it
		List<WebElement> cancelLink = driver.findElements(By.linkText("cancel"));
		System.out.println("cancelLink size = " + cancelLink.size());
		if (cancelLink.size()>0)
		{
			perform.click(driver,driver.findElement(By.linkText("cancel")));
			secure.goToAccount(driver);
		}
		
		// Click Require password reset checkbox
		if (SAccount.requirePasswordReset_chkbx(driver).isSelected()==false)
		{
			perform.click(driver,SAccount.requirePasswordReset_chkbx(driver));
		}
		
		// Select Require password reset dropdown
		perform.selectDropdownOption(driver, SAccount.requirePasswordResetInNumberOfDays_dropdown(driver), "7");
		
		// Click Save
		perform.click(driver,SAccount.save_btn(driver));
		
		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for Yes button
		perform.waitForElementToBeClickable(driver, SAccount.yes_btn(), "id");
		
		// Click Yes
		perform.click(driver,SAccount.yes_btn(driver));
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SAccount.ok_btn(), "id");
		
		// Wait for OK button
		perform.click(driver,SAccount.ok_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Verify Reset required text
		Assert.assertTrue(SAccount.resetRequired_txt(driver).getText().contains("Reset required after"), "The reset required text did not display");
		
		// Verify checkbox is unchecked
		Assert.assertTrue(SAccount.requirePasswordReset_chkbx(driver).isSelected()==false, "The Require password reset checkbox is checked and shouldn't be");
		
		// Get date
		perform.getNewDate(driver, 7);
		
		// Set new date value
		String month = StoredVariables.getnewMonth2().get();
		String day = StoredVariables.getnewDay2().get();
		String year = StoredVariables.getnewYear().get();
		String newDate = year + "-" + month + "-" + day;
		
		// Verify database value
		Thread.sleep(2000);
		String PasswordExpireDateSQL = "SELECT PasswordResetDate FROM CustomerData.dbo.Passport WHERE EmailAddress = 'automation" + StoredVariables.getusernameEnvironment().get() + user + StoredVariables.getcatchAllDomain().get() + "'";
		String dbValue = db.queryDB(driver, "CustomerData", PasswordExpireDateSQL);
		Assert.assertTrue(dbValue.startsWith(newDate), "The database value for the PasswordResetDate is incorrect. Expected = " + newDate + "    But the value is = " + dbValue);
		
		// Log test
		test.log(LogStatus.INFO, "Password Security", "Verified table was updated with the correct date to reset the password");
		
	} // end requirePasswordResetIn7Days
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Check for No button</li>
	 * 	<li>Click Account</li>
	 * 	<li>If cancel link exists, click it</li>
	 * 	<li>Click Require password reset checkbox</li>
	 * 	<li>Select Require password reset dropdown</li>
	 * 	<li>Click Save</li>
	 * 	<li>Click Yes</li>
	 * 	<li>Verify Reset required text</li>
	 * 	<li>Verify checkbox is unchecked</li>
	 * 	<li>Get date</li>
	 * 	<li>Set new date value</li>
	 * 	<li>Verify database value</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Account", "Password Management On Secure"}, alwaysRun=true, priority=3)
	public void requirePasswordResetIn21Days() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Login to Secure
		login(driver);
		
		// Check for No button
		if (Overlay.overlay(driver).getAttribute("style").contains("visible"))
		{
			perform.click(driver,SOrders.no_btn(driver));	
		}
		
		// Click Account
		secure.goToAccount(driver);
		
		// If cancel link exists, click it
		List<WebElement> cancelLink = driver.findElements(By.linkText("cancel"));
		System.out.println("cancelLink size = " + cancelLink.size());
		if (cancelLink.size()>0)
		{
			perform.click(driver,driver.findElement(By.linkText("cancel")));
			secure.goToAccount(driver);
		}
		
		// Click Require password reset checkbox
		if (SAccount.requirePasswordReset_chkbx(driver).isSelected()==false)
		{
			perform.click(driver,SAccount.requirePasswordReset_chkbx(driver));
		}
		
		// Select Require password reset dropdown
		perform.selectDropdownOption(driver, SAccount.requirePasswordResetInNumberOfDays_dropdown(driver), "21");
		
		// Click Save
		perform.click(driver,SAccount.save_btn(driver));
		
		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for Yes button
		perform.waitForElementToBeClickable(driver, SAccount.yes_btn(), "id");
		
		// Click Yes
		perform.click(driver,SAccount.yes_btn(driver));
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SAccount.ok_btn(), "id");
		
		// Wait for OK button
		perform.click(driver,SAccount.ok_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Verify Reset required text
		Assert.assertTrue(SAccount.resetRequired_txt(driver).getText().contains("Reset required after"), "The reset required text did not display");
		
		// Verify checkbox is unchecked
		Assert.assertTrue(SAccount.requirePasswordReset_chkbx(driver).isSelected()==false, "The Require password reset checkbox is checked and shouldn't be");
		
		// Get date
		perform.getNewDate(driver, 21);
		
		// Set new date value
		String month = StoredVariables.getnewMonth2().get();
		String day = StoredVariables.getnewDay2().get();
		String year = StoredVariables.getnewYear().get();
		String newDate = year + "-" + month + "-" + day;
		
		// Verify database value
		Thread.sleep(2000);
		String PasswordExpireDateSQL = "SELECT PasswordResetDate FROM CustomerData.dbo.Passport WHERE EmailAddress = 'automation" + StoredVariables.getusernameEnvironment().get() + user + StoredVariables.getcatchAllDomain().get() + "'";
		String dbValue = db.queryDB(driver, "CustomerData", PasswordExpireDateSQL);
		Assert.assertTrue(dbValue.startsWith(newDate), "The database value for the PasswordResetDate is incorrect. Expected = " + newDate + "    But the value is = " + dbValue);
		
		// Log test
		test.log(LogStatus.INFO, "Password Security", "Verified table was updated with the correct date to reset the password");
		
	} // end requirePasswordResetIn21Days
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Check for No button</li>
	 * 	<li>Click Account</li>
	 * 	<li>If cancel link exists, click it</li>
	 * 	<li>Click Require password reset checkbox</li>
	 * 	<li>Click Save</li>
	 * 	<li>Verify checkbox is unchecked</li>
	 * 	<li>Verify database value</li>
	 * 	<li>Log test</li>
	 * 	<li>Go to login page</li>
	 * 	<li>Enter email</li>
	 * 	<li>Enter Password</li>
	 * 	<li>Click Sign In</li>
	 * 	<li>Check for expired password</li>
	 * 	<li>New</li>
	 * 	<li>Confirm</li>
	 * 	<li>Save</li>
	 * 	<li>Check for overlay if it is the first time the page is opened since run</li>
	 * 	<li>Click Find textbox</li>
	 * 	<li>Close overlay</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Account", "Password Management On Secure"}, alwaysRun=true, priority=4)
	public void disablePasswordReset() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Login to Secure
		login(driver);
		
		// Check for No button
		if (Overlay.overlay(driver).getAttribute("style").contains("visible"))
		{
			perform.click(driver,SOrders.no_btn(driver));	
		}
		
		// Click Account
		secure.goToAccount(driver);
		
		// If cancel link exists, click it
		List<WebElement> cancelLink = driver.findElements(By.linkText("cancel"));
		System.out.println("cancelLink size = " + cancelLink.size());
		if (cancelLink.size()>0)
		{
			perform.click(driver,driver.findElement(By.linkText("cancel")));
			secure.goToAccount(driver);
		}
		
		// Click Require password reset checkbox
		if (SAccount.requirePasswordReset_chkbx(driver).isSelected()==true)
		{
			perform.click(driver,SAccount.requirePasswordReset_chkbx(driver));
		}
		
		// Click Save
		perform.click(driver,SAccount.save_btn(driver));
		
		// Wait for checkbox
		perform.waitForElementToBeClickable(driver, SAccount.requirePasswordReset_chkbx(), "id");
		
		// Verify checkbox is unchecked
		Assert.assertTrue(SAccount.requirePasswordReset_chkbx(driver).isSelected()==false, "The Require password reset checkbox is checked and shouldn't be");
		
		// Verify database value
		Thread.sleep(2000);
		String PasswordExpireDateSQL = "SELECT PasswordResetDate FROM CustomerData.dbo.Passport WHERE EmailAddress = 'automation" + StoredVariables.getusernameEnvironment().get() + user + StoredVariables.getcatchAllDomain().get() + "'";
		String dbValue = db.queryDB(driver, "CustomerData", PasswordExpireDateSQL);
		Assert.assertTrue(dbValue.equals("null"), "The database value for the PasswordResetDate is incorrect. Expected = NULL    But the value is = " + dbValue);
		
		// Log test
		test.log(LogStatus.INFO, "Password Security", "Verified table was updated with NULL for the password reset date");
		
	} // end disablePasswordReset
	
	/**
	 * Login.
	 *
	 * @param driver the driver
	 * @throws InterruptedException the interrupted exception
	 */
	private void login(RemoteWebDriver driver) throws InterruptedException {
		
		String environment = StoredVariables.getusernameEnvironment().get();
		String catchAllDomain = StoredVariables.getcatchAllDomain().get();
		
		// Go to login page
		driver.get(StoredVariables.getsecureSite().get());
		
		// Wait for email txtbx
		perform.waitForElementToBeClickable(driver, SLogin.email_txtbx(), "id");
		
		// Enter email
		if (user.contains("@"))
		{
			perform.type(driver, SLogin.email_txtbx(driver), user);
		}
		else
		{
			perform.type(driver, SLogin.email_txtbx(driver), "automation" + environment + user + catchAllDomain);	
		}
		
		// Enter Password
		perform.type(driver, SLogin.password_txtbx(driver), password);
		
		// Click Sign In
		perform.click(driver,SLogin.signIn_btn(driver));
		
		Thread.sleep(2000);
		
		// Check for expired password
		if (driver.getCurrentUrl().contains("SignIn.aspx")) {
			
			// New
			perform.type(driver, driver.findElement(By.id("divNewPassword_txtNew")), password);
			
			// Confirm
			perform.type(driver, driver.findElement(By.id("divNewPassword_txtConfirm")), password);
			
			// Save
			perform.click(driver,driver.findElement(By.id("Main_Main_btnSavePassword")));
			
		} // end if for expired password
		
		// Check for overlay if it is the first time the page is opened since run
		try
		{
			// Click Find textbox
			perform.click(driver,SOrders.find_txtbx(driver));
		} // end try
		catch (Exception e) {
			try
			{
			// Close overlay
			perform.waitForElementToBeClickable(driver, SOrders.closeOverlay_btn(), "cssSelector");
			perform.click(driver,SOrders.closeOverlay_btn(driver));
			}
			catch (Exception e1) {
			perform.click(driver,SOrders.no_btn(driver));
			}
		} // end catch
		
	} // end login
	
} // end the OrderManagement class
