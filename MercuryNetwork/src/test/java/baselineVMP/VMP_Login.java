package baselineVMP;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjects.VMP.VMPForgotPassword;
import pageObjects.VMP.VMPLogin;
import pageObjects.VMP.VMPSignUp;
import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Baseline VMP - Login</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class VMP_Login extends TestSetup {
	
	/** The user. */
	private final String user = "EVFLender2";
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get environment</li>
	 * 	<li>Go to login page</li>
	 * 	<li>driver.get("https:automation" + environment + user + "." + StoredVariables.getvmpSiteSuffix().get());</li>
	 * 	<li>Clear email field</li>
	 * 	<li>enter password</li>
	 * 	<li>click Sign In</li>
	 * 	<li>Verify error text</li>
	 * 	<li>Log test</li>
* </ul>
	 *
	 * @throws InterruptedException the interrupted exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"baseline", "negative"}, alwaysRun=true)
	public void loginEmptyUsername() throws InterruptedException {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Get environment
		String environment = StoredVariables.getusernameEnvironment().get();
		
		// Go to login page
		driver.get("https://automation" + environment + user + "." + StoredVariables.getvmpSiteSuffix().get());
		
		// Wait for password
		perform.waitForElementToBeClickable(driver, VMPLogin.password_txtbx(), "id");
		
		// Clear email field
		VMPLogin.email_txtbx(driver).clear();
		
		// enter password
		VMPLogin.password_txtbx(driver).clear();
		perform.type(driver, VMPLogin.password_txtbx(driver), StoredVariables.getpassword().get());
		
		// click Sign In
		perform.click(driver,VMPLogin.signIn_btn(driver));
		
		// Wait for error
		perform.waitForElementToBeClickable(driver, VMPLogin.invalidInformationDialog2_txt(), "id");
		
		// Verify error text
		Assert.assertTrue(VMPLogin.invalidInformationDialog2_txt(driver).getText().contains("There is a problem with some of the information you have provided for the order."));
		Assert.assertTrue(VMPLogin.invalidInformationDialog2_txt(driver).getText().contains("Username is required"));
		
		// Log test
		test.log(LogStatus.INFO, "login", "Tried logging in with an empty username");
		
	} // end loginEmptyUsername
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get environment</li>
	 * 	<li>Go to login page</li>
	 * 	<li>driver.get("https:automation" + environment + user + "." + StoredVariables.getvmpSiteSuffix().get());</li>
	 * 	<li>Enter username</li>
	 * 	<li>Clear password field</li>
	 * 	<li>click Sign In</li>
	 * 	<li>Verify error text</li>
	 * 	<li>Click OK</li>
	 * 	<li>Log test</li>
* </ul>
	 *
	 * @throws InterruptedException the interrupted exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"VMP - Login"}, alwaysRun=true)
	public void loginEmptyPassword() throws InterruptedException {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Get environment
		String environment = StoredVariables.getusernameEnvironment().get();
		
		// Go to login page
		driver.get("https://automation" + environment + user + "." + StoredVariables.getvmpSiteSuffix().get());
		
		// Wait for password
		perform.waitForElementToBeClickable(driver, VMPLogin.password_txtbx(), "id");
		
		// Enter username
		perform.type(driver, VMPLogin.email_txtbx(driver), "automation" + environment + user);
		
		// Clear password field
		VMPLogin.password_txtbx(driver).clear();
		
		// click Sign In
		perform.click(driver,VMPLogin.signIn_btn(driver));
		
		// Wait for dialog box
		perform.waitForElementToBeClickable(driver, VMPLogin.invalidInformationDialog2_txt(), "id");
		
		// Verify error text
		Assert.assertTrue(VMPLogin.invalidInformationDialog2_txt(driver).getText().contains("There is a problem with some of the information you have provided for the order."));
		Assert.assertTrue(VMPLogin.invalidInformationDialog2_txt(driver).getText().contains("Password is required"));
		
		// Click OK
		perform.click(driver,VMPLogin.ok_btn(driver));
		
		// Log test
		test.log(LogStatus.INFO, "login", "Tried logging in with an empty password");		
		
	} // end loginEmptyPassword
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get environment</li>
	 * 	<li>Go to login page</li>
	 * 	<li>driver.get("https:automation" + environment + user + "." + StoredVariables.getvmpSiteSuffix().get());</li>
	 * 	<li>Clear email field</li>
	 * 	<li>clear password</li>
	 * 	<li>click Sign In</li>
	 * 	<li>Verify error text</li>
	 * 	<li>Click OK</li>
	 * 	<li>Log test</li>
* </ul>
	 *
	 * @throws InterruptedException the interrupted exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"VMP - Login"}, alwaysRun=true)
	public void loginEmptyUsernameAndPassword() throws InterruptedException {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Get environment
		String environment = StoredVariables.getusernameEnvironment().get();
		
		// Go to login page
		driver.get("https://automation" + environment + user + "." + StoredVariables.getvmpSiteSuffix().get());
		
		// Wait for password
		perform.waitForElementToBeClickable(driver, VMPLogin.password_txtbx(), "id");
		
		// Clear email field
		VMPLogin.email_txtbx(driver).clear();
		
		// clear password
		VMPLogin.password_txtbx(driver).clear();
		
		// click Sign In
		perform.click(driver,VMPLogin.signIn_btn(driver));
		
		// Wait for dialog box
		perform.waitForElementToBeClickable(driver, VMPLogin.invalidInformationDialog2_txt(), "id");
		
		// Verify error text
		Assert.assertTrue(VMPLogin.invalidInformationDialog2_txt(driver).getText().contains("There is a problem with some of the information you have provided for the order."));
		Assert.assertTrue(VMPLogin.invalidInformationDialog2_txt(driver).getText().contains("Username is required"));
		Assert.assertTrue(VMPLogin.invalidInformationDialog2_txt(driver).getText().contains("Password is required"));
		
		// Click OK
		perform.click(driver,VMPLogin.ok_btn(driver));
		
		// Log test
		test.log(LogStatus.INFO, "login", "Tried logging in with an empty email and password");
		
	} // end loginEmptyUsernameAndPassword
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get environment</li>
	 * 	<li>Go to login page</li>
	 * 	<li>driver.get("https:automation" + environment + user + "." + StoredVariables.getvmpSiteSuffix().get());</li>
	 * 	<li>Clear email field</li>
	 * 	<li>enter password</li>
	 * 	<li>click Sign In</li>
	 * 	<li>Verify error text</li>
	 * 	<li>Log test</li>
* </ul>
	 *
	 * @throws InterruptedException the interrupted exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"VMP - Login"}, alwaysRun=true)
	public void loginIncorrectUsername() throws InterruptedException {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Get environment
		String environment = StoredVariables.getusernameEnvironment().get();
		
		// Go to login page
		driver.get("https://automation" + environment + user + "." + StoredVariables.getvmpSiteSuffix().get());
		
		// Wait for password
		perform.waitForElementToBeClickable(driver, VMPLogin.password_txtbx(), "id");
		
		// Clear email field
		VMPLogin.email_txtbx(driver).clear();
		perform.type(driver, VMPLogin.email_txtbx(driver), "automation");
		
		// enter password
		VMPLogin.password_txtbx(driver).clear();
		perform.type(driver, VMPLogin.password_txtbx(driver), StoredVariables.getpassword().get());
		
		// click Sign In
		perform.click(driver,VMPLogin.signIn_btn(driver));
		
		// Wait for error
		perform.waitForElementToBeClickable(driver, VMPLogin.invalidInformationDialog_txt(), "id");
		
		// Verify error text
		Assert.assertTrue(VMPLogin.invalidInformationDialog_txt(driver).getText().contains("The username and/or password you entered is invalid."));
		
		// Log test
		test.log(LogStatus.INFO, "login", "Tried logging in with an incorrect email");
		
	} // end loginIncorrectUsername
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get environment</li>
	 * 	<li>Go to login page</li>
	 * 	<li>driver.get("https:automation" + environment + user + "." + StoredVariables.getvmpSiteSuffix().get());</li>
	 * 	<li>Enter email</li>
	 * 	<li>Clear password field</li>
	 * 	<li>click Sign In</li>
	 * 	<li>Verify error text</li>
	 * 	<li>Log test</li>
* </ul>
	 *
	 * @throws InterruptedException the interrupted exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"VMP - Login"}, alwaysRun=true)
	public void loginIncorrectPassword() throws InterruptedException {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Get environment
		String environment = StoredVariables.getusernameEnvironment().get();
		
		// Go to login page
		driver.get("https://automation" + environment + user + "." + StoredVariables.getvmpSiteSuffix().get());
		
		// Wait for password
		perform.waitForElementToBeClickable(driver, VMPLogin.password_txtbx(), "id");
		
		// Enter email
		perform.type(driver, VMPLogin.email_txtbx(driver), "automation" + environment + user);
		
		// Clear password field
		perform.type(driver, VMPLogin.password_txtbx(driver), "password");
		
		// click Sign In
		perform.click(driver,VMPLogin.signIn_btn(driver));
		
		// Wait for error
		perform.waitForElementToBeClickable(driver, VMPLogin.invalidInformationDialog_txt(), "id");
		
		// Verify error text
		Assert.assertTrue(VMPLogin.invalidInformationDialog_txt(driver).getText().contains("The username and/or password you entered is invalid."));
		
		// Log test
		test.log(LogStatus.INFO, "login", "Tried logging in with an incorrect password");		
		
	} // end loginIncorrectPassword
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get environment</li>
	 * 	<li>Go to login page</li>
	 * 	<li>driver.get("https:automation" + environment + user + "." + StoredVariables.getvmpSiteSuffix().get());</li>
	 * 	<li>Clear email field</li>
	 * 	<li>clear password</li>
	 * 	<li>click Sign In</li>
	 * 	<li>perform.waitForOverlayToBeVisible(driver);</li>
	 * 	<li>Verify error text</li>
	 * 	<li>Log test</li>
* </ul>
	 *
	 * @throws InterruptedException the interrupted exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"VMP - Login"}, alwaysRun=true)
	public void loginIncorrectUsernameAndPassword() throws InterruptedException {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Get environment
		String environment = StoredVariables.getusernameEnvironment().get();
		
		// Go to login page
		driver.get("https://automation" + environment + user + "." + StoredVariables.getvmpSiteSuffix().get());
		
		// Wait for password
		perform.waitForElementToBeClickable(driver, VMPLogin.password_txtbx(), "id");
		
		// Clear email field
		perform.type(driver, VMPLogin.email_txtbx(driver), "automatoin");
		
		// clear password
		perform.type(driver, VMPLogin.password_txtbx(driver), "password");
		
		// click Sign In
		perform.click(driver,VMPLogin.signIn_btn(driver));
		
		// Wait for overlay
//		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for error
		perform.waitForElementToBeVisible(driver, VMPLogin.invalidInformationDialog_txt(), "id");
		
		// Verify error text
		Assert.assertTrue(VMPLogin.invalidInformationDialog_txt(driver).getText().contains("The username and/or password you entered is invalid."));
		
		// Log test
		test.log(LogStatus.INFO, "login", "Tried logging in with an incorrect email and password");
		
	} // end loginIncorrectUsernameAndPassword
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to VMP Client Portal</li>
	 * 	<li>Verify successful login</li>
	 * 	<li>Log test</li>
* </ul>
	 *
	 * @throws InterruptedException the interrupted exception
	 * @throws SQLException the SQLException
	 * @throws ClassNotFoundException the ClassNotFoundException
	 */
	@Test (retryAnalyzer = Retry.class, groups={"VMP - Login"}, alwaysRun=true)
	public void login() throws InterruptedException, ClassNotFoundException, SQLException {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Login to VMP Client Portal
		vmp.login(driver, user, "Originator"+user, StoredVariables.getpassword().get());
		
		// Verify successful login
		Assert.assertTrue(driver.getTitle().equals("Orders"));
		Assert.assertTrue(driver.getCurrentUrl().contains("Orders.aspx"));
		
		// Log test
		test.log(LogStatus.INFO, "login", "Logged in successfully");
		
	} // end login
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get environment</li>
	 * 	<li>Go to login page</li>
	 * 	<li>driver.get("https:automation" + environment + user + "." + StoredVariables.getvmpSiteSuffix().get());</li>
	 * 	<li>Click the Terms of Use link</li>
	 * 	<li>Switch to the new window</li>
	 * 	<li>Verify url</li>
	 * 	<li>close the window</li>
	 * 	<li>Log test</li>
* </ul>
	 *
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Test (retryAnalyzer = Retry.class, groups={"VMP - Terms Of Use"}, alwaysRun=true)
	public void termsOfUse() throws InterruptedException, IOException {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Get environment
		String environment = StoredVariables.getusernameEnvironment().get();
		
		// Go to login page
		driver.get("https://automation" + environment + user + "." + StoredVariables.getvmpSiteSuffix().get());
		
		// Wait for password
		perform.waitForElementToBeClickable(driver, VMPLogin.password_txtbx(), "id");
		
		// Click the Terms of Use link
		perform.click(driver,driver.findElement(By.linkText("Terms of Use")));
		
		// Switch to the new window
		perform.switchToXSiteWindowByTitle(driver, "Terms of Use");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().contains("/TOU.htm"), "The url is incorrect");
		
		// close the window
		perform.closeNewWindow(driver);
		
		// Log test
		test.log(LogStatus.INFO, "login", "The Terms of Use link opened the correct url");
		
	} // end termsOfUse
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get environment</li>
	 * 	<li>Go to login page</li>
	 * 	<li>driver.get("https:automation" + environment + user + "." + StoredVariables.getvmpSiteSuffix().get());</li>
	 * 	<li>Click the Forgot password link</li>
	 * 	<li>Get page text</li>
	 * 	<li>Verify page text</li>
	 * 	<li>Click Close</li>
	 * 	<li>Verify url</li>
	 * 	<li>Log test</li>
* </ul>
	 *
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Test (retryAnalyzer = Retry.class, groups={"VMP - Forgot Password"}, alwaysRun=true)
	public void forgotPassword() throws InterruptedException, IOException {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Get environment
		String environment = StoredVariables.getusernameEnvironment().get();
		
		// Go to login page
		driver.get("https://automation" + environment + user + "." + StoredVariables.getvmpSiteSuffix().get());
		
		// Wait for password
		perform.waitForElementToBeClickable(driver, VMPLogin.password_txtbx(), "id");
		
		// Click the Forgot password link
		perform.click(driver,driver.findElement(By.linkText("Forgot Password?")));
		
		// Wait for Send Account Info button
		perform.waitForElementToBeClickable(driver, VMPForgotPassword.email_txtbx(), "id");
		
		// Get page text
		String text = VMPForgotPassword.sendAccountInfo_txt(driver).getText();
		
		// Verify page text
		Assert.assertTrue(text.contains("Forgot your Username or Password?"), "The text on the Forgot Password page is incorrect");
		Assert.assertTrue(text.contains("Just enter your e-mail and we'll send it to you."), "The text on the Forgot Password page is incorrect");
		
		// Click Close
		perform.click(driver,VMPForgotPassword.close_btn(driver));
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().contains("SignIn.aspx"), "The url is incorrect");
		
		// Log test
		test.log(LogStatus.INFO, "login", "Verified the Forgot your password link dialog");
		
	} // end forgotPassword
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get environment</li>
	 * 	<li>Go to login page</li>
	 * 	<li>driver.get("https:automation" + environment + user + "." + StoredVariables.getvmpSiteSuffix().get());</li>
	 * 	<li>Click Sign Up</li>
	 * 	<li>Verify Account Type dropdown</li>
	 * 	<li>String[] typeOfAccountQA = {"(None Selected)","Lender","Mortgage Broker","Home Owner","Attorney","Real Estate Agent","Credit Company","Title Company","Other"};</li>
	 * 	<li>if (env.equals("QA"))</li>
	 * 	<li>{</li>
	 * 	<li>perform.verifyDropdownOptions(driver, VMPSignUp.accountType_dropdown(driver), typeOfAccountQA);</li>
	 * 	<li>}</li>
	 * 	<li>else</li>
	 * 	<li>{</li>
	 * 	<li>perform.verifyDropdownOptions(driver, VMPSignUp.accountType_dropdown(driver), typeOfAccount);</li>
	 * 	<li>}</li>
	 * 	<li>Select Type of Account</li>
	 * 	<li>Select State</li>
	 * 	<li>Enter Company Name</li>
	 * 	<li>Enter First Name</li>
	 * 	<li>Enter Last Name</li>
	 * 	<li>Enter Address</li>
	 * 	<li>Enter City</li>
	 * 	<li>Enter Zip</li>
	 * 	<li>Enter Phone</li>
	 * 	<li>Select Time Zone</li>
	 * 	<li>perform.selectDropdownOption(driver, VMPSignUp.timeZone_dropdown(driver), "Central Time (GMT-06:00)");</li>
	 * 	<li>Enter Email</li>
	 * 	<li>Enter Username</li>
	 * 	<li>Enter Password</li>
	 * 	<li>Enter Confirm Password</li>
	 * 	<li>Click Next</li>
	 * 	<li>VMPSignUp.next_btn(driver));</li>
	 * 	<li>Verify url</li>
	 * 	<li>Log test</li>
* </ul>
	 *
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Test (retryAnalyzer = Retry.class, groups={"VMP - Sign Up"}, alwaysRun=true)
	public void signUp() throws InterruptedException, IOException {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Get environment
		String environment = StoredVariables.getusernameEnvironment().get();
		
		// Go to login page
		driver.get("https://automation" + environment + user + "." + StoredVariables.getvmpSiteSuffix().get());
		
		// Wait for email field
		perform.waitForElementToBeClickable(driver, VMPLogin.email_txtbx(), "id");
		
		// Click Sign Up
		perform.click(driver,VMPLogin.signUp_btn(driver));
		
		// Wait for company name textbox
		perform.waitForElementToBeClickable(driver, VMPSignUp.companyName_txtbx(), "id");
		
		// Verify Account Type dropdown
		String[] typeOfAccount = {"(None Selected)","Lender","Mortgage Broker","Home Owner","Attorney","Real Estate Agent","Appraisal Management Company","Credit Company","Title Company","Other"};
		perform.verifyDropdownOptions(driver, VMPSignUp.accountType_dropdown(driver), typeOfAccount);
//		String[] typeOfAccountQA = {"(None Selected)","Lender","Mortgage Broker","Home Owner","Attorney","Real Estate Agent","Credit Company","Title Company","Other"};
//		if (env.equals("QA"))
//		{
//			perform.verifyDropdownOptions(driver, VMPSignUp.accountType_dropdown(driver), typeOfAccountQA);	
//		}
//		else
//		{
//			perform.verifyDropdownOptions(driver, VMPSignUp.accountType_dropdown(driver), typeOfAccount);
//		}
		
		// Select Type of Account
		perform.selectDropdownOption(driver, VMPSignUp.accountType_dropdown(driver), "Lender");
		
		// Select State
		perform.selectDropdownOption(driver, VMPSignUp.state_dropdown(driver), "Oklahoma");
		
		// Enter Company Name
		perform.type(driver, VMPSignUp.companyName_txtbx(driver), "AutomationBaseline");
		
		// Enter First Name
		perform.type(driver, VMPSignUp.firstName_txtbx(driver), "Automation");
		
		// Enter Last Name
		perform.type(driver, VMPSignUp.lastName_txtbx(driver), "BaselineTest");
		
		// Enter Address
		perform.type(driver, VMPSignUp.address_txtbx(driver), "123 Test St");
		
		// Enter City
		perform.type(driver, VMPSignUp.city_txtbx(driver), "Yukon");
		
		// Enter Zip
		perform.type(driver, VMPSignUp.zip_txtbx(driver), "73099");
		
		// Enter Phone
		perform.type(driver, VMPSignUp.phone_txtbx(driver), "4055559999");
		
		// Select Time Zone
//		perform.selectDropdownOption(driver, VMPSignUp.timeZone_dropdown(driver), "Central Time (GMT-06:00)");
		perform.selectDropdownOption(driver, VMPSignUp.timeZone_dropdown(driver), "Central");
		
		// Enter Email
		perform.type(driver, VMPSignUp.email_txtbx(driver), "automationBaselineVMP@dntest.net");
		
		// Enter Username
		perform.type(driver, VMPSignUp.username_txtbx(driver), "AutomationBaselineVMP");
		
		// Enter Password
		perform.type(driver, VMPSignUp.password_txtbx(driver), "T3sting1");
		
		// Enter Confirm Password
		perform.type(driver, VMPSignUp.confirmPassword_txtbx(driver), "T3sting1");
		
		// Click Next
//		VMPSignUp.next_btn(driver));
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().contains("SignUp.aspx"), "The url is incorrect");
		
		// Log test
		test.log(LogStatus.INFO, "login", "Verified data can be entered during the Sign Up process");
		
	} // end signUp
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get environment</li>
	 * 	<li>Go to login page</li>
	 * 	<li>driver.get("https:automation" + environment + user + "." + StoredVariables.getvmpSiteSuffix().get());</li>
	 * 	<li>Click Sign Up</li>
	 * 	<li>Click the Terms of Use link</li>
	 * 	<li>Switch to the new window</li>
	 * 	<li>Verify url</li>
	 * 	<li>close the window</li>
	 * 	<li>Log test</li>
* </ul>
	 *
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Test (retryAnalyzer = Retry.class, groups={"VMP - Sign Up", "VMP - Terms Of Use"}, alwaysRun=true)
	public void signUp_TermsOfUse() throws InterruptedException, IOException {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Get environment
		String environment = StoredVariables.getusernameEnvironment().get();
		
		// Go to login page
		driver.get("https://automation" + environment + user + "." + StoredVariables.getvmpSiteSuffix().get());
		
		// Wait for email field
		perform.waitForElementToBeClickable(driver, VMPLogin.email_txtbx(), "id");
		
		// Click Sign Up
		perform.click(driver,VMPLogin.signUp_btn(driver));
		
		// Wait for company name textbox
		perform.waitForElementToBeClickable(driver, VMPSignUp.companyName_txtbx(), "id");
		
		// Click the Terms of Use link
		perform.click(driver,driver.findElement(By.linkText("Terms of Use")));
		
		// Switch to the new window
		perform.switchToXSiteWindowByTitle(driver, "Terms of Use");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().contains("/TOU.htm"), "The url is incorrect");
		
		// close the window
		perform.closeNewWindow(driver);
		
		// Log test
		test.log(LogStatus.INFO, "login", "The Terms of Use link opened the correct url");
		
	} // end signUp_TermsOfUse
	
} // end the Secure_Login class
