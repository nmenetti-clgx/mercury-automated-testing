package regressionPasswordSecurity;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjects.Secure.SAccount;
import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Password Security - Expire Password</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
@Test(singleThreaded=true)
public class ExpirePassword extends TestSetup {
	
	/** The user. */
	private final String user = "PasswordSecurity1";
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Click Account</li>
	 * 	<li>Get current settings</li>
	 * 	<li>Check Enable password expiration checkbox</li>
	 * 	<li>Select 30 days</li>
	 * 	<li>Click Save</li>
	 * 	<li>Save info if there were changes</li>
	 * 	<li>Get date</li>
	 * 	<li>Set new date value</li>
	 * 	<li>Verify database value</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Account", "Password Management On Secure"}, alwaysRun=true)
	public void setPasswordToExpire30Days() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Login to Secure
		secure.login(driver, user, StoredVariables.getpassword().get());
		
		// Click Account
		secure.goToAccount(driver);
		
		// Get current settings
		boolean passwordExpiration = SAccount.enablePasswordExpiration_chkbx(driver).isSelected();
		String days = SAccount.passwordsExpireEveryNumberOfDays_dropdown(driver).getAttribute("value");
		
		// Check Enable password expiration checkbox
		if (SAccount.enablePasswordExpiration_chkbx(driver).isSelected() == false)
		{
			perform.click(driver,SAccount.enablePasswordExpiration_chkbx(driver));
		}
		
		// Select 30 days
		perform.selectDropdownOption(driver, SAccount.passwordsExpireEveryNumberOfDays_dropdown(driver), "30");
		
		// Click Save
		boolean change = false;
		if (passwordExpiration==false)
		{
			change = true;
		} // end if passwordExpiration
		if (!days.equals("30"))
		{
			change = true;
		} // end if passwordExpiration
		// Save info if there were changes
		if (change==true)
		{
			secure.saveAccountSettings(driver);
		} // end if change
		
		// Get date
		perform.getNewDate(driver, 30);
		
		// Set new date value
		String month = StoredVariables.getnewMonth2().get();
		String day = StoredVariables.getnewDay2().get();
		String year = StoredVariables.getnewYear().get();
		String newDate = year + "-" + month + "-" + day;
		
		// Verify database value
		Thread.sleep(2000);
		String PasswordExpireDateSQL = "SELECT PasswordExpireDate FROM CustomerData.dbo.Passport WHERE EmailAddress = 'automation" + StoredVariables.getusernameEnvironment().get() + user + StoredVariables.getcatchAllDomain().get() + "'";
		String dbValue = db.queryDB(driver, "CustomerData", PasswordExpireDateSQL);
		Assert.assertTrue(dbValue.startsWith(newDate), "The database value for the PasswordExpireDate is incorrect. Expected = " + newDate + "    But the value is = " + dbValue);
		
		// Log test
		test.log(LogStatus.INFO, "Password Security", "Verified table was updated with the correct date to expire the password");
		
	} // end setPasswordToExpire30Days
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Click Account</li>
	 * 	<li>Get current settings</li>
	 * 	<li>Check Enable password expiration checkbox</li>
	 * 	<li>Select 60 days</li>
	 * 	<li>Click Save</li>
	 * 	<li>Save info if there were changes</li>
	 * 	<li>Get date</li>
	 * 	<li>Set new date value</li>
	 * 	<li>Verify database value</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Account", "Password Management On Secure"}, alwaysRun=true)
	public void setPasswordToExpire60Days() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Login to Secure
		secure.login(driver, user, StoredVariables.getpassword().get());
		
		// Click Account
		secure.goToAccount(driver);
		
		// Get current settings
		boolean passwordExpiration = SAccount.enablePasswordExpiration_chkbx(driver).isSelected();
		String days = SAccount.passwordsExpireEveryNumberOfDays_dropdown(driver).getAttribute("value");
		
		// Check Enable password expiration checkbox
		if (SAccount.enablePasswordExpiration_chkbx(driver).isSelected() == false)
		{
			perform.click(driver,SAccount.enablePasswordExpiration_chkbx(driver));
		}
		
		// Select 60 days
		perform.selectDropdownOption(driver, SAccount.passwordsExpireEveryNumberOfDays_dropdown(driver), "60");
		
		// Click Save
		boolean change = false;
		if (passwordExpiration==false)
		{
			change = true;
		} // end if passwordExpiration
		if (!days.equals("60"))
		{
			change = true;
		} // end if passwordExpiration
		// Save info if there were changes
		if (change==true)
		{
			secure.saveAccountSettings(driver);
		} // end if change
		
		// Get date
		perform.getNewDate(driver, 60);
		
		// Set new date value
		String month = StoredVariables.getnewMonth2().get();
		String day = StoredVariables.getnewDay2().get();
		String year = StoredVariables.getnewYear().get();
		String newDate = year + "-" + month + "-" + day;
		
		// Verify database value
		Thread.sleep(2000);
		String PasswordExpireDateSQL = "SELECT PasswordExpireDate FROM CustomerData.dbo.Passport WHERE EmailAddress = 'automation" + StoredVariables.getusernameEnvironment().get() + user + StoredVariables.getcatchAllDomain().get() + "'";
		String dbValue = db.queryDB(driver, "CustomerData", PasswordExpireDateSQL);
		Assert.assertTrue(dbValue.startsWith(newDate), "The database value for the PasswordExpireDate is incorrect. Expected = " + newDate + "    But the value is = " + dbValue);
		
		// Log test
		test.log(LogStatus.INFO, "Password Security", "Verified table was updated with the correct date to expire the password");
		
	} // end setPasswordToExpire60Days
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Click Account</li>
	 * 	<li>Get current settings</li>
	 * 	<li>Check Enable password expiration checkbox</li>
	 * 	<li>Select 90 days</li>
	 * 	<li>Click Save</li>
	 * 	<li>Save info if there were changes</li>
	 * 	<li>Get date</li>
	 * 	<li>Set new date value</li>
	 * 	<li>Verify database value</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Account", "Password Management On Secure"}, alwaysRun=true)
	public void setPasswordToExpire90Days() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Login to Secure
		secure.login(driver, user, StoredVariables.getpassword().get());
		
		// Click Account
		secure.goToAccount(driver);
		
		// Get current settings
		boolean passwordExpiration = SAccount.enablePasswordExpiration_chkbx(driver).isSelected();
		String days = SAccount.passwordsExpireEveryNumberOfDays_dropdown(driver).getAttribute("value");
		
		// Check Enable password expiration checkbox
		if (SAccount.enablePasswordExpiration_chkbx(driver).isSelected() == false)
		{
			perform.click(driver,SAccount.enablePasswordExpiration_chkbx(driver));
		}
		
		// Select 90 days
		perform.selectDropdownOption(driver, SAccount.passwordsExpireEveryNumberOfDays_dropdown(driver), "90");
		
		// Click Save
		boolean change = false;
		if (passwordExpiration==false)
		{
			change = true;
		} // end if passwordExpiration
		if (!days.equals("90"))
		{
			change = true;
		} // end if passwordExpiration
		// Save info if there were changes
		if (change==true)
		{
			secure.saveAccountSettings(driver);
		} // end if change
		
		// Get date
		perform.getNewDate(driver, 90);
		
		// Set new date value
		String month = StoredVariables.getnewMonth2().get();
		String day = StoredVariables.getnewDay2().get();
		String year = StoredVariables.getnewYear().get();
		String newDate = year + "-" + month + "-" + day;
		
		// Verify database value
		Thread.sleep(2000);
		String PasswordExpireDateSQL = "SELECT PasswordExpireDate FROM CustomerData.dbo.Passport WHERE EmailAddress = 'automation" + StoredVariables.getusernameEnvironment().get() + user + StoredVariables.getcatchAllDomain().get() + "'";
		String dbValue = db.queryDB(driver, "CustomerData", PasswordExpireDateSQL);
		Assert.assertTrue(dbValue.startsWith(newDate), "The database value for the PasswordExpireDate is incorrect. Expected = " + newDate + "    But the value is = " + dbValue);
		
		// Log test
		test.log(LogStatus.INFO, "Password Security", "Verified table was updated with the correct date to expire the password");
		
	} // end setPasswordToExpire90Days
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Click Account</li>
	 * 	<li>Get current settings</li>
	 * 	<li>Check Enable password expiration checkbox</li>
	 * 	<li>Select 120 days</li>
	 * 	<li>Click Save</li>
	 * 	<li>Save info if there were changes</li>
	 * 	<li>Get date</li>
	 * 	<li>Set new date value</li>
	 * 	<li>Verify database value</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Account", "Password Management On Secure"}, alwaysRun=true)
	public void setPasswordToExpire120Days() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Login to Secure
		secure.login(driver, user, StoredVariables.getpassword().get());
		
		// Click Account
		secure.goToAccount(driver);
		
		// Get current settings
		boolean passwordExpiration = SAccount.enablePasswordExpiration_chkbx(driver).isSelected();
		String days = SAccount.passwordsExpireEveryNumberOfDays_dropdown(driver).getAttribute("value");
		
		// Check Enable password expiration checkbox
		if (SAccount.enablePasswordExpiration_chkbx(driver).isSelected() == false)
		{
			perform.click(driver,SAccount.enablePasswordExpiration_chkbx(driver));
		}
		
		// Select 120 days
		perform.selectDropdownOption(driver, SAccount.passwordsExpireEveryNumberOfDays_dropdown(driver), "120");
		
		// Click Save
		boolean change = false;
		if (passwordExpiration==false)
		{
			change = true;
		} // end if passwordExpiration
		if (!days.equals("120"))
		{
			change = true;
		} // end if passwordExpiration
		// Save info if there were changes
		if (change==true)
		{
			secure.saveAccountSettings(driver);
		} // end if change
		
		// Get date
		perform.getNewDate(driver, 120);
		
		// Set new date value
		String month = StoredVariables.getnewMonth2().get();
		String day = StoredVariables.getnewDay2().get();
		String year = StoredVariables.getnewYear().get();
		String newDate = year + "-" + month + "-" + day;
		
		// Verify database value
		Thread.sleep(2000);
		String PasswordExpireDateSQL = "SELECT PasswordExpireDate FROM CustomerData.dbo.Passport WHERE EmailAddress = 'automation" + StoredVariables.getusernameEnvironment().get() + user + StoredVariables.getcatchAllDomain().get() + "'";
		String dbValue = db.queryDB(driver, "CustomerData", PasswordExpireDateSQL);
		Assert.assertTrue(dbValue.startsWith(newDate), "The database value for the PasswordExpireDate is incorrect. Expected = " + newDate + "    But the value is = " + dbValue);
		
		// Log test
		test.log(LogStatus.INFO, "Password Security", "Verified table was updated with the correct date to expire the password");
		
	} // end setPasswordToExpire120Days
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Click Account</li>
	 * 	<li>Get current settings</li>
	 * 	<li>Check Enable password expiration checkbox</li>
	 * 	<li>Click Save</li>
	 * 	<li>Save info if there were changes</li>
	 * 	<li>Verify database value</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Account", "Password Management On Secure"}, alwaysRun=true)
	public void disablePasswordToExpire() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Login to Secure
		secure.login(driver, user, StoredVariables.getpassword().get());
		
		// Click Account
		secure.goToAccount(driver);
		
		// Get current settings
		boolean passwordExpiration = SAccount.enablePasswordExpiration_chkbx(driver).isSelected();
		
		// Check Enable password expiration checkbox
		if (SAccount.enablePasswordExpiration_chkbx(driver).isSelected() == true)
		{
			perform.click(driver, SAccount.enablePasswordExpiration_chkbx(driver));
		}
		
		// Click Save
		boolean change = false;
		if (passwordExpiration==true)
		{
			change = true;
		} // end if passwordExpiration
		// Save info if there were changes
		if (change==true)
		{
			secure.saveAccountSettings(driver);
		} // end if change
		
		// Verify database value
		Thread.sleep(2000);
		String PasswordExpireDateSQL = "SELECT PasswordExpireDate FROM CustomerData.dbo.Passport WHERE EmailAddress = 'automation" + StoredVariables.getusernameEnvironment().get() + user + StoredVariables.getcatchAllDomain().get() + "'";
		String dbValue = db.queryDB(driver, "CustomerData", PasswordExpireDateSQL);
		Assert.assertTrue(dbValue.equals("null"), "The database value for the PasswordExpireDate is incorrect. Expected = NULL    But the value is = " + dbValue);
		
		// Log test
		test.log(LogStatus.INFO, "Password Security", "Verified table was updated with NULL for the password expire date");
		
	} // end disablePasswordToExpire
	
} // end the OrderManagement class
