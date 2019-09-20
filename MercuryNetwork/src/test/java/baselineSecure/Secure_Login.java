package baselineSecure;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjects.Overlay.Overlay;
import pageObjects.Secure.SForgotPassword;
import pageObjects.Secure.SLogin;
import pageObjects.Secure.SSignUp;
import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Baseline Secure - Login</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class Secure_Login extends TestSetup {
	
	/** The user. */
	private static String user = "Baseline1";
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to Secure</li>
	 * 	<li>Clear email field</li>
	 * 	<li>enter password</li>
	 * 	<li>click Sign In</li>
	 * 	<li>Verify error text</li>
	 * 	<li>Log test</li>
* </ul>
	 *
	 * @throws InterruptedException the interrupted exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Login"}, alwaysRun=true)
	public void loginEmptyUsername() throws InterruptedException {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Go to Secure
		driver.get(StoredVariables.getsecureSite().get());
		
		// Wait for password
		perform.waitForElementToBeClickable(driver, SLogin.password_txtbx(), "id");
		
		// Clear email field
		SLogin.email_txtbx(driver).clear();
		
		// enter password
		SLogin.password_txtbx(driver).clear();
		perform.type(driver, SLogin.password_txtbx(driver), StoredVariables.getpassword().get());
		
		// click Sign In
		perform.click(driver, SLogin.signIn_btn(driver));
		
		// Wait for error
		perform.waitForElementToBeClickable(driver, SLogin.loginError_txt(), "id");
		
		// Verify error text
		Assert.assertTrue(SLogin.loginError_txt(driver).getText().contains("Your email or password (case sensitive) was incorrect. Please try again or select "));
		
		// Log test
		test.log(LogStatus.INFO, "login", "Tried logging in with an empty email");
		
	} // end loginEmptyUsername
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to Secure</li>
	 * 	<li>Enter email</li>
	 * 	<li>Clear password field</li>
	 * 	<li>click Sign In</li>
	 * 	<li>Verify error text</li>
	 * 	<li>Click OK</li>
	 * 	<li>Log test</li>
* </ul>
	 *
	 * @throws InterruptedException the interrupted exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Login"}, alwaysRun=true)
	public void loginEmptyPassword() throws InterruptedException {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		String environment = StoredVariables.getenvironment().get();
		String catchAllDomain = StoredVariables.getcatchAllDomain().get();
		String env = "";
		if (environment.startsWith("Dev") || environment.startsWith("QA"))
		{
			env = "QA";
		}
		else if (environment.startsWith("Beta"))
		{
			env = "Beta";
		}
		if (environment.startsWith("Live"))
		{
			env = "Live";
		}
		
		// Go to Secure
		driver.get(StoredVariables.getsecureSite().get());
		
		// Wait for password
		perform.waitForElementToBeClickable(driver, SLogin.password_txtbx(), "id");
		
		// Enter email
		perform.type(driver, SLogin.email_txtbx(driver), "automation" + env + user + catchAllDomain);
		
		// Clear password field
		SLogin.password_txtbx(driver).clear();
		
		// click Sign In
		perform.click(driver, SLogin.signIn_btn(driver));
		
		// Wait for dialog box
		perform.waitForElementToBeClickable(driver, SLogin.invalidInformationDialog_txt(), "id");
		
		// Verify error text
		Assert.assertTrue(SLogin.invalidInformationDialog_txt(driver).getText().contains("There is a problem with some of the information you have provided. Please correct the following issues and then try again."));
		Assert.assertTrue(SLogin.invalidInformationDialog_txt(driver).getText().contains("Password is required."));
		
		// Click OK
		perform.click(driver, SLogin.ok_btn(driver));
		
		// Log test
		test.log(LogStatus.INFO, "login", "Tried logging in with an empty password");		
		
	} // end loginEmptyPassword
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to Secure</li>
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
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Login"}, alwaysRun=true)
	public void loginEmptyUsernameAndPassword() throws InterruptedException {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Go to Secure
		driver.get(StoredVariables.getsecureSite().get());
		
		// Wait for password
		perform.waitForElementToBeClickable(driver, SLogin.password_txtbx(), "id");
		
		// Clear email field
		SLogin.email_txtbx(driver).clear();
		
		// clear password
		SLogin.password_txtbx(driver).clear();
		
		// click Sign In
		perform.click(driver, SLogin.signIn_btn(driver));
		
		// Wait for dialog box
		perform.waitForElementToBeClickable(driver, SLogin.invalidInformationDialog_txt(), "id");
		
		// Verify error text
		Assert.assertTrue(SLogin.invalidInformationDialog_txt(driver).getText().contains("There is a problem with some of the information you have provided. Please correct the following issues and then try again."));
		Assert.assertTrue(SLogin.invalidInformationDialog_txt(driver).getText().contains("Password is required."));
		
		// Click OK
		perform.click(driver, SLogin.ok_btn(driver));
		
		// Log test
		test.log(LogStatus.INFO, "login", "Tried logging in with an empty email and password");
		
	} // end loginEmptyUsernameAndPassword
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to Secure</li>
	 * 	<li>Clear email field</li>
	 * 	<li>enter password</li>
	 * 	<li>click Sign In</li>
	 * 	<li>Verify error text</li>
	 * 	<li>Log test</li>
* </ul>
	 *
	 * @throws InterruptedException the interrupted exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Login"}, alwaysRun=true)
	public void loginIncorrectUsername() throws InterruptedException {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Go to Secure
		driver.get(StoredVariables.getsecureSite().get());
		
		// Wait for password
		perform.waitForElementToBeClickable(driver, SLogin.password_txtbx(), "id");
		
		// Clear email field
		perform.type(driver, SLogin.email_txtbx(driver), "automatoin");
		
		// enter password
		SLogin.password_txtbx(driver).clear();
		perform.type(driver, SLogin.password_txtbx(driver), StoredVariables.getpassword().get());
		
		// click Sign In
		perform.click(driver, SLogin.signIn_btn(driver));
		
		// Wait for error
		perform.waitForElementToBeClickable(driver, SLogin.loginError_txt(), "id");
		
		// Verify error text
		Assert.assertTrue(SLogin.loginError_txt(driver).getText().contains("Your email or password (case sensitive) was incorrect. Please try again or select "));
		
		// Log test
		test.log(LogStatus.INFO, "login", "Tried logging in with an incorrect email");
		
	} // end loginIncorrectUsername
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to Secure</li>
	 * 	<li>Enter email</li>
	 * 	<li>Clear password field</li>
	 * 	<li>click Sign In</li>
	 * 	<li>Verify error text</li>
	 * 	<li>Log test</li>
* </ul>
	 *
	 * @throws InterruptedException the interrupted exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Login"}, alwaysRun=true)
	public void loginIncorrectPassword() throws InterruptedException {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		String environment = StoredVariables.getenvironment().get();
		String catchAllDomain = StoredVariables.getcatchAllDomain().get();
		String env = "";
		if (environment.startsWith("Dev") || environment.startsWith("QA"))
		{
			env = "QA";
		}
		else if (environment.startsWith("Beta"))
		{
			env = "Beta";
		}
		if (environment.startsWith("Live"))
		{
			env = "Live";
		}
		
		// Go to Secure
		driver.get(StoredVariables.getsecureSite().get());
		
		// Wait for password
		perform.waitForElementToBeClickable(driver, SLogin.password_txtbx(), "id");
		
		// Enter email
		perform.type(driver, SLogin.email_txtbx(driver), "automation" + env + user + catchAllDomain);
		
		// Clear password field
		perform.type(driver, SLogin.password_txtbx(driver), "password");
		
		// click Sign In
		perform.click(driver, SLogin.signIn_btn(driver));
		
		// Wait for error
		perform.waitForElementToBeClickable(driver, SLogin.loginError_txt(), "id");
		
		// Verify error text
		Assert.assertTrue(SLogin.loginError_txt(driver).getText().contains("Your email or password (case sensitive) was incorrect. Please try again or select "));
		
		// Log test
		test.log(LogStatus.INFO, "login", "Tried logging in with an incorrect password");		
		
	} // end loginIncorrectPassword
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to Secure</li>
	 * 	<li>Clear email field</li>
	 * 	<li>clear password</li>
	 * 	<li>click Sign In</li>
	 * 	<li>Verify error text</li>
	 * 	<li>Log test</li>
* </ul>
	 *
	 * @throws InterruptedException the interrupted exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Login"}, alwaysRun=true)
	public void loginIncorrectUsernameAndPassword() throws InterruptedException {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Go to Secure
		driver.get(StoredVariables.getsecureSite().get());
		
		// Wait for password
		perform.waitForElementToBeClickable(driver, SLogin.password_txtbx(), "id");
		
		// Clear email field
		perform.type(driver, SLogin.email_txtbx(driver), "automatoin");
		
		// clear password
		perform.type(driver, SLogin.password_txtbx(driver), "password");
		
		// click Sign In
		perform.click(driver, SLogin.signIn_btn(driver));
		
		// Wait for error
		perform.waitForElementToBeClickable(driver, SLogin.loginError_txt(), "id");
		
		// Verify error text
		Assert.assertTrue(SLogin.loginError_txt(driver).getText().contains("Your email or password (case sensitive) was incorrect. Please try again or select "));
		
		// Log test
		test.log(LogStatus.INFO, "login", "Tried logging in with an incorrect email and password");
		
	} // end loginIncorrectUsernameAndPassword
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Verify successful login</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Login"}, alwaysRun=true)
	public void login() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		secure.login(driver, user, StoredVariables.getpassword().get());
		
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
	 * 	<li>Go to Secure</li>
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
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Terms Of Use"}, alwaysRun=true)
	public void termsOfUse() throws InterruptedException, IOException {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Go to Secure
		driver.get(StoredVariables.getsecureSite().get());
		
		// Wait for password
		perform.waitForElementToBeClickable(driver, SLogin.password_txtbx(), "id");
		
		// Click the Terms of Use link
		perform.click(driver, driver.findElement(By.linkText("Terms of Use")));
		
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
	 * 	<li>Go to Secure</li>
	 * 	<li>Click the Forgot password link</li>
	 * 	<li>Verify url</li>
	 * 	<li>Get page text</li>
	 * 	<li>Verify page text</li>
	 * 	<li>Click Cancel</li>
	 * 	<li>Verify url</li>
	 * 	<li>Log test</li>
* </ul>
	 *
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Forgot Password"}, alwaysRun=true)
	public void forgotPassword() throws InterruptedException, IOException {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Go to Secure
		driver.get(StoredVariables.getsecureSite().get());
		
		// Wait for password
		perform.waitForElementToBeClickable(driver, SLogin.password_txtbx(), "id");
		
		// Click the Forgot password link
		perform.click(driver, driver.findElement(By.linkText("Forgot your password?")));
		
		// Wait for username textbox
		perform.waitForElementToBeClickable(driver, SForgotPassword.usernameForgotPassword_txtbx(), "id");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().contains(StoredVariables.getsecureSite().get()), "The url is incorrect");
		
		// Get page text
		String text = SForgotPassword.page_txt(driver).getText();
		
		// Verify page text
		Assert.assertTrue(text.contains("Locate your account by entering your Mercury Network username (e-mail address)."), "The text on the Forgot Password page is incorrect");
		
		// Click Cancel
		perform.click(driver, SForgotPassword.cancel_btn(driver));
		
		// Verify url
		perform.verification(driver, driver.getCurrentUrl(), "equals", StoredVariables.getsecureSite().get()+"/");
		
		// Log test
		test.log(LogStatus.INFO, "login", "The Forgot your password link opened the correct url");
		
	} // end forgotPassword
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to Secure</li>
	 * 	<li>Click Sign Up</li>
	 * 	<li>Verify Type of Account dropdown</li>
	 * 	<li>Select Type of Account</li>
	 * 	<li>Select State</li>
	 * 	<li>Enter Company Name</li>
	 * 	<li>Enter Phone Number</li>
	 * 	<li>Enter Email Address</li>
	 * 	<li>Click Next</li>
	 * 	<li>Click I don't match any of these</li>
	 * 	<li>Click Next</li>
	 * 	<li>Verify data passed over</li>
	 * 	<li>Verify url</li>
	 * 	<li>Log test</li>
* </ul>
	 *
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Sign Up"}, alwaysRun=true)
	public void signUp() throws InterruptedException, IOException {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Go to Secure
		driver.get(StoredVariables.getsecureSite().get());

		// Wait for email field
		perform.waitForElementToBeClickable(driver, SLogin.email_txtbx(), "id");

		// Click Sign Up
		perform.click(driver, SLogin.signUp_btn(driver));

		try {
			// Wait for company name textbox
			perform.waitForElementToBeClickable(driver, SSignUp.companyName_textbox(), "id");
		} catch (Exception e1) {
			System.out.println("The page was redirected because of the reCaptcha");
		} // end try/catch

		// Verify Type of Account dropdown
		String[] typeOfAccount = {"Choose Type...","Mortgage Lender","Appraisal Management Company","Credit Union","Mortgage Broker","Other"};
		perform.verifyDropdownOptions(driver, SSignUp.typeOfAccount_dropdown(driver), typeOfAccount);

		// Select Type of Account
		perform.selectDropdownOption(driver, SSignUp.typeOfAccount_dropdown(driver), "Mortgage Lender");

		// Select State
		perform.selectDropdownOption(driver, SSignUp.state_dropdown(driver), "Oklahoma");

		// Enter Company Name
		perform.type(driver, SSignUp.companyName_textbox(driver), "AutomationBaseline");

		// Enter Phone Number
		perform.type(driver, SSignUp.phoneNumber_textbox(driver), "1111111111");

		// Enter Email Address
		perform.type(driver, SSignUp.emailAddress_textbox(driver), "automationBaseline" + StoredVariables.getcatchAllDomain().get());

		// Click Next
		perform.click(driver, SSignUp.next_btn(driver));

		// If not on a QA environment, reCaptcha should redirect to the login screen
		if (!StoredVariables.getusernameEnvironment().get().equals("QA")) {
			
			// Verify the alert dialog is correct
			String alertText = Overlay.alertDialog(driver).getText();
			String[] expected = {"There was an error trying to get you signed up.", "Please call 1-800-900-4954 for support."};
			perform.verifyTextContains(driver, alertText, expected);
			
		} else {
			
			try
			{
				// Wait for I don't match any of these radio button
				perform.waitForElementToBeClickable(driver, SSignUp.iDontMatchAnyOfThese_radiobtn(), "id");

				// Click I don't match any of these
				perform.click(driver, SSignUp.iDontMatchAnyOfThese_radiobtn(driver));

				// Click Next
				perform.click(driver, SSignUp.nextPossibleDuplicate_btn(driver));
			}
			catch (Exception e){}

			// Wait for First Name textbox
			perform.waitForElementToBeClickable(driver, SSignUp.firstName_txtbx(), "id");

			// Verify data passed over
			Assert.assertTrue(SSignUp.company_txtbox(driver).getAttribute("value").equals("AutomationBaseline"), "The Company name did not pass over");
			Assert.assertTrue(SSignUp.businessPhone_txtbox(driver).getAttribute("value").equals("1111111111"), "The Business Phone did not pass over. Should be = " + SSignUp.businessPhone_txtbox(driver).getAttribute("value"));
			String selectedOption = new Select(SSignUp.state2_dropdown(driver)).getFirstSelectedOption().getText();
			Assert.assertTrue(selectedOption.equals("Oklahoma"), "The state did not pass over");
			Assert.assertTrue(SSignUp.emailAddress2_txtbox(driver).getAttribute("value").equals("automationBaseline@dntest.net"), "The email address did not pass over");

			// Verify url
			Assert.assertTrue(driver.getCurrentUrl().contains("SignUp/Client.aspx"), "The url is incorrect");

		} // end if/else

		// Log test
		test.log(LogStatus.INFO, "login", "Verified the Sign Up process");
		
	} // end signUp
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to Secure</li>
	 * 	<li>Click Sign Up</li>
	 * 	<li>Click the Sign in link</li>
	 * 	<li>Verify url</li>
	 * 	<li>Log test</li>
* </ul>
	 *
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Sign Up"}, alwaysRun=true)
	public void signUp_SignIn() throws InterruptedException, IOException {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Go to Secure
		driver.get(StoredVariables.getsecureSite().get());
		
		// Wait for email field
		perform.waitForElementToBeClickable(driver, SLogin.email_txtbx(), "id");
		
		// Click Sign Up
		perform.click(driver, SLogin.signUp_btn(driver));
		
		// Wait for company name textbox
		perform.waitForElementToBeClickable(driver, SSignUp.companyName_textbox(), "id");
		
		// Click the Sign in link
		perform.click(driver, driver.findElement(By.linkText("Click here")));
		
		// Wait for email textbox
		perform.waitForElementToBeClickable(driver, SLogin.email_txtbx(), "id");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().equals(StoredVariables.getsecureSite().get()+"/"), "The url is incorrect");
		
		// Log test
		test.log(LogStatus.INFO, "login", "The Click here link from the Sign Up page opened the login page");
		
	} // end signUp_SignIn
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to Secure</li>
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
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Sign Up", "Secure - Terms Of Use"}, alwaysRun=true)
	public void signUp_TermsOfUse() throws InterruptedException, IOException {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Go to Secure
		driver.get(StoredVariables.getsecureSite().get());
		
		// Wait for email field
		perform.waitForElementToBeClickable(driver, SLogin.email_txtbx(), "id");
		
		// Click Sign Up
		perform.click(driver, SLogin.signUp_btn(driver));
		
		// Wait for company name textbox
		perform.waitForElementToBeClickable(driver, SSignUp.companyName_textbox(), "id");
		
		// Click the Terms of Use link
		perform.click(driver, driver.findElement(By.linkText("Terms of Use")));
		
		// Switch to the new window
		perform.switchToXSiteWindowByTitle(driver, "Terms of Use");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().contains("/TOU.htm"), "The url is incorrect");
		
		// close the window
		perform.closeNewWindow(driver);
		
		// Log test
		test.log(LogStatus.INFO, "login", "The Terms of Use link opened the correct url");
		
	} // end signUp_TermsOfUse
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to Secure</li>
	 * 	<li>Click Sign Up</li>
	 * 	<li>Store the current window handle</li>
	 * 	<li>Click the vendors link</li>
	 * 	<li>Switch to new window opened</li>
	 * 	<li>Verify url</li>
	 * 	<li>Close the new window, if that window no more required</li>
	 * 	<li>Switch back to original browser (first window)</li>
	 * 	<li>Log test</li>
* </ul>
	 *
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Sign Up"}, alwaysRun=true)
	public void signUp_GoToVendors() throws InterruptedException, IOException {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Go to Secure
		driver.get(StoredVariables.getsecureSite().get());
		
		// Wait for email field
		perform.waitForElementToBeClickable(driver, SLogin.email_txtbx(), "id");
		
		// Click Sign Up
		perform.click(driver, SLogin.signUp_btn(driver));
		
		// Wait for company name textbox
		perform.waitForElementToBeClickable(driver, SSignUp.companyName_textbox(), "id");
		
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();

		// Click the vendors link
		perform.click(driver, driver.findElement(By.linkText("clicking here.")));
		
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().contains("SignupWiz.aspx"), "The url is incorrect");
		
		// Close the new window, if that window no more required
		driver.close();

		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
		
		// Log test
		test.log(LogStatus.INFO, "login", "The Vendors link opened the correct url");
		
	} // end signUp_TermsOfUse
	
} // end the Secure_Login class
