package baselineVendors;

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
import pageObjects.Vendors.VForgotPassword;
import pageObjects.Vendors.VSignUp;
import pageObjects.Vendors.VLogin;
import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Baseline Vendors - Login</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class Vendors_Login extends TestSetup {
	
	/** The user. */
	private final String user = "BaselineAppraiser1";
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to Vendors</li>
	 * 	<li>Clear email field</li>
	 * 	<li>enter password</li>
	 * 	<li>click Sign In</li>
	 * 	<li>Verify error text</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws InterruptedException the interrupted exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Vendors - Login"}, alwaysRun=true)
	public void loginEmptyUsername() throws InterruptedException {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Go to Vendors
		driver.get(StoredVariables.getvendorsSite().get());
		
		// Wait for password
		perform.waitForElementToBeClickable(driver, VLogin.password_txtbx(), "id");
		
		// Clear email field
		VLogin.email_txtbx(driver).clear();
		
		// enter password
		VLogin.password_txtbx(driver).clear();
		perform.type(driver, VLogin.password_txtbx(driver), StoredVariables.getpassword().get());
		
		// click Sign In
		perform.click(driver,VLogin.signIn_btn(driver));
		
		// Wait for error
		perform.waitForElementToBeClickable(driver, VLogin.loginError_txt(), "id");
		
		// Verify error text
		Assert.assertTrue(VLogin.loginError_txt(driver).getText().contains("Your email or password (case sensitive) was incorrect. Please try again or select "), "The error message is incorrect");
		
		// Log test
		test.log(LogStatus.INFO, "login", "Tried logging in with an empty email");
		
	} // end loginEmptyUsername
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to Vendors</li>
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
	@Test (retryAnalyzer = Retry.class, groups={"Vendors - Login"}, alwaysRun=true)
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
		
		// Go to Vendors
		driver.get(StoredVariables.getvendorsSite().get());
		
		// Wait for password
		perform.waitForElementToBeClickable(driver, VLogin.password_txtbx(), "id");
		
		// Enter email
		perform.type(driver, VLogin.email_txtbx(driver), "automation" + env + user + catchAllDomain);
		
		// Clear password field
		VLogin.password_txtbx(driver).clear();
		
		// click Sign In
		perform.click(driver,VLogin.signIn_btn(driver));
		
		// Wait for dialog box
		perform.waitForElementToBeClickable(driver, VLogin.invalidInformationDialog_txt(), "id");
		
		// Verify error text
		Assert.assertTrue(VLogin.invalidInformationDialog_txt(driver).getText().contains("There is a problem with some of the information you have provided. Please correct the following issues and then try again."));
		Assert.assertTrue(VLogin.invalidInformationDialog_txt(driver).getText().contains("Password is required."));
		
		// Click OK
		perform.click(driver,VLogin.ok_btn(driver));
		
		// Log test
		test.log(LogStatus.INFO, "login", "Tried logging in with an empty password");		
		
	} // end loginEmptyPassword
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to Vendors</li>
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
	@Test (retryAnalyzer = Retry.class, groups={"Vendors - Login"}, alwaysRun=true)
	public void loginEmptyUsernameAndPassword() throws InterruptedException {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Go to Vendors
		driver.get(StoredVariables.getvendorsSite().get());
		
		// Wait for password
		perform.waitForElementToBeClickable(driver, VLogin.password_txtbx(), "id");
		
		// Clear email field
		VLogin.email_txtbx(driver).clear();
		
		// clear password
		VLogin.password_txtbx(driver).clear();
		
		// click Sign In
		perform.click(driver,VLogin.signIn_btn(driver));
		
		// Wait for dialog box
		perform.waitForElementToBeClickable(driver, VLogin.invalidInformationDialog_txt(), "id");
		
		// Verify error text
		Assert.assertTrue(VLogin.invalidInformationDialog_txt(driver).getText().contains("There is a problem with some of the information you have provided. Please correct the following issues and then try again."));
		Assert.assertTrue(VLogin.invalidInformationDialog_txt(driver).getText().contains("Password is required."));
		
		// Click OK
		perform.click(driver,VLogin.ok_btn(driver));
		
		// Log test
		test.log(LogStatus.INFO, "login", "Tried logging in with an empty email and password");
		
	} // end loginEmptyUsernameAndPassword
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to Vendors</li>
	 * 	<li>Clear email field</li>
	 * 	<li>enter password</li>
	 * 	<li>click Sign In</li>
	 * 	<li>Verify error text</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws InterruptedException the interrupted exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Vendors - Login"}, alwaysRun=true)
	public void loginIncorrectUsername() throws InterruptedException {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Go to Vendors
		driver.get(StoredVariables.getvendorsSite().get());
		
		// Wait for password
		perform.waitForElementToBeClickable(driver, VLogin.password_txtbx(), "id");
		
		// Clear email field
		perform.type(driver, VLogin.email_txtbx(driver), "automatoin");
		
		// enter password
		VLogin.password_txtbx(driver).clear();
		perform.type(driver, VLogin.password_txtbx(driver), StoredVariables.getpassword().get());
		
		// click Sign In
		perform.click(driver,VLogin.signIn_btn(driver));
		
		// Wait for error
		perform.waitForElementToBeClickable(driver, VLogin.loginError_txt(), "id");
		
		// Verify error text
		Assert.assertTrue(VLogin.loginError_txt(driver).getText().contains("Your email or password (case sensitive) was incorrect. Please try again or select "), "The error message is incorrect");
		
		// Log test
		test.log(LogStatus.INFO, "login", "Tried logging in with an incorrect email");
		
	} // end loginIncorrectUsername
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to Vendors</li>
	 * 	<li>Enter email</li>
	 * 	<li>Clear password field</li>
	 * 	<li>click Sign In</li>
	 * 	<li>Verify error text</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws InterruptedException the interrupted exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Vendors - Login"}, alwaysRun=true)
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
		
		// Go to Vendors
		driver.get(StoredVariables.getvendorsSite().get());
		
		// Wait for password
		perform.waitForElementToBeClickable(driver, VLogin.password_txtbx(), "id");
		
		// Enter email
		perform.type(driver, VLogin.email_txtbx(driver), "automation" + env + user + catchAllDomain);
		
		// Clear password field
		perform.type(driver, VLogin.password_txtbx(driver), "password");
		
		// click Sign In
		perform.click(driver,VLogin.signIn_btn(driver));
		
		// Wait for error
		perform.waitForElementToBeClickable(driver, VLogin.loginError_txt(), "id");
		
		// Verify error text
		Assert.assertTrue(VLogin.loginError_txt(driver).getText().contains("Your email or password (case sensitive) was incorrect. Please try again or select "), "The error message is incorrect");
		
		// Log test
		test.log(LogStatus.INFO, "login", "Tried logging in with an incorrect password");		
		
	} // end loginIncorrectPassword
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to Vendors</li>
	 * 	<li>Clear email field</li>
	 * 	<li>clear password</li>
	 * 	<li>click Sign In</li>
	 * 	<li>Verify error text</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws InterruptedException the interrupted exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Vendors - Login"}, alwaysRun=true)
	public void loginIncorrectUsernameAndPassword() throws InterruptedException {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Go to Vendors
		driver.get(StoredVariables.getvendorsSite().get());
		
		// Wait for password
		perform.waitForElementToBeClickable(driver, VLogin.password_txtbx(), "id");
		
		// Clear email field
		perform.type(driver, VLogin.email_txtbx(driver), "automatoin");
		
		// clear password
		perform.type(driver, VLogin.password_txtbx(driver), "password");
		
		// click Sign In
		perform.click(driver,VLogin.signIn_btn(driver));
		
		// Wait for error
		perform.waitForElementToBeClickable(driver, VLogin.loginError_txt(), "id");
		
		// Verify error text
		Assert.assertTrue(VLogin.loginError_txt(driver).getText().contains("Your email or password (case sensitive) was incorrect. Please try again or select "), "The error message is incorrect");
		
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
	@Test (retryAnalyzer = Retry.class, groups={"Vendors - Login"}, alwaysRun=true)
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
	 * 	<li>Go to Vendors</li>
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
	@Test (retryAnalyzer = Retry.class, groups={"Vendors - Terms Of Use"}, alwaysRun=true)
	public void termsOfUse() throws InterruptedException, IOException {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Go to Vendors
		driver.get(StoredVariables.getvendorsSite().get());
		
		// Wait for password
		perform.waitForElementToBeClickable(driver, VLogin.password_txtbx(), "id");
		
		// Click the Terms of Use link
		perform.click(driver,driver.findElement(By.linkText("Terms of Use")));
		
		// Switch to the new window
		perform.switchToXSiteWindowByTitle(driver, "Terms of Use");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().contains("TOU.htm"), "The url is incorrect");
		
		// close the window
		perform.closeNewWindow(driver);
		
		// Log test
		test.log(LogStatus.INFO, "login", "The Terms of Use link opened the correct url");
		
	} // end termsOfUse
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to Vendors</li>
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
	@Test (retryAnalyzer = Retry.class, groups={"Vendors - Forgot Password"}, alwaysRun=true)
	public void forgotPassword() throws InterruptedException, IOException {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Go to Vendors
		driver.get(StoredVariables.getvendorsSite().get());
		
		// Wait for password
		perform.waitForElementToBeClickable(driver, VLogin.password_txtbx(), "id");
		
		// Click the Forgot password link
		perform.click(driver,driver.findElement(By.linkText("Forgot your password?")));
		
		// Wait for username textbox
		perform.waitForElementToBeClickable(driver, VForgotPassword.usernameForgotPassword_txtbx(), "id");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().contains(StoredVariables.getvendorsSite().get()), "The url is incorrect");
		
		// Get page text
		String text = VForgotPassword.page_txt(driver).getText();
		
		// Verify page text
		Assert.assertTrue(text.contains("Locate your account by entering your Mercury Network username (e-mail address)."), "The text on the Forgot Password page is incorrect");
		Assert.assertTrue(text.contains("Welcome to Mercury Network. This is the premier vendor management software platform for the nation"), "The text on the Forgot Password page is incorrect. Text on screen = " + text);
		Assert.assertTrue(text.contains("s largest lenders and appraisal management companies."), "The text on the Forgot Password page is incorrect. Text on screen = " + text);
		Assert.assertTrue(text.contains("Username (e-mail)"), "The text on the Forgot Password page is incorrect");
		Assert.assertTrue(text.contains("800-900-4954"), "The text on the Forgot Password page is incorrect");
		
		// Click Cancel
		perform.click(driver,VForgotPassword.cancel_btn(driver));
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().equals(StoredVariables.getvendorsSite().get()), "The url is incorrect");
		
		// Log test
		test.log(LogStatus.INFO, "login", "The Forgot your password link opened the correct url");
		
	} // end forgotPassword
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to Vendors</li>
	 * 	<li>Click Sign Up</li>
	 * 	<li>Verify Type of Account dropdown</li>
	 * 	<li>Select Type of Account</li>
	 * 	<li>Select State</li>
	 * 	<li>Enter Company Name</li>
	 * 	<li>Enter Phone Number</li>
	 * 	<li>Enter Email Address</li>
	 * 	<li>Click Next</li>
	 * 	<li>Verify data passed over</li>
	 * 	<li>Verify url</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Vendors - Sign Up"}, alwaysRun=true)
	public void signUp() throws InterruptedException, IOException {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Go to Vendors
		driver.get(StoredVariables.getvendorsSite().get());
		
		// Wait for email field
		perform.waitForElementToBeClickable(driver, VLogin.email_txtbx(), "id");
		
		// Click Sign Up
		perform.click(driver,VLogin.signUp_btn(driver));
		
		// Wait for company name textbox
		perform.waitForElementToBeClickable(driver, VSignUp.companyName_txtbx(), "id");

		// Verify Type of Account dropdown
		String[] typeOfAccount = {"Choose Type...","Appraiser Office (less than 10)","Appraisal Management Company / Appraisal Firm","Inspector","Real Estate Agent"};
		perform.verifyDropdownOptions(driver, VSignUp.typeOfAccount_dropdown(driver), typeOfAccount);

		// Select Type of Account
		perform.selectDropdownOption(driver, VSignUp.typeOfAccount_dropdown(driver), "Appraiser Office (less than 10)");

		// Select State
		perform.selectDropdownOption(driver, VSignUp.state_dropdown(driver), "Oklahoma");

		// Enter Company Name
		perform.type(driver, VSignUp.companyName_txtbx(driver), "AutomationBaseline");

		// Enter Phone Number
		perform.type(driver, VSignUp.phoneNumber_txtbx(driver), "1111111111");

		// Enter Email Address
		perform.type(driver, VSignUp.emailAddress_txtbx(driver), "automationBaseline" + StoredVariables.getcatchAllDomain().get());

		// Click Next
		perform.click(driver,VSignUp.next_btn(driver));

		// If not on a QA environment, reCaptcha should redirect to the login screen
		if (!StoredVariables.getusernameEnvironment().get().equals("QA")) {
			
			// Verify the alert dialog is correct
			String alertText = Overlay.alertDialog(driver).getText();
			String[] expected = {"There was an error trying to get you signed up.", "Please call 1-800-900-4954 for support."};
			perform.verifyTextContains(driver, alertText, expected);

		} else {

			// Wait for First Name textbox
			perform.waitForElementToBeClickable(driver, VSignUp.firstName_txtbx(), "id");

			// Verify data passed over
			Assert.assertTrue(VSignUp.company_txtbox(driver).getAttribute("value").equals("AutomationBaseline"), "The Company name did not pass over");
			Assert.assertTrue(VSignUp.officePhoneNumber_txtbx(driver).getAttribute("value").equals("1111111111"), "The Office Phone Number did not pass over. Should be = " + VSignUp.officePhoneNumber_txtbx(driver).getAttribute("value"));
			String selectedOption = new Select(VSignUp.state2_dropdown(driver)).getFirstSelectedOption().getText();
			Assert.assertTrue(selectedOption.equals("Oklahoma"), "The state did not pass over");
			Assert.assertTrue(VSignUp.emailAddress2_txtbox(driver).getAttribute("value").equals("automationBaseline@dntest.net"), "The email address did not pass over");

			// Verify url
			Assert.assertTrue(driver.getCurrentUrl().contains("SignUp/Vendor.aspx"), "The url is incorrect");

		} // end if/else
		
		// Log test
		test.log(LogStatus.INFO, "login", "Verified the Sign Up process");
		
	} // end signUp
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to Vendors</li>
	 * 	<li>Click Sign Up</li>
	 * 	<li>Click the Sign in link</li>
	 * 	<li>Verify url</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Vendors - Sign Up"}, alwaysRun=true)
	public void signUp_SignIn() throws InterruptedException, IOException {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Go to Vendors
		driver.get(StoredVariables.getvendorsSite().get());
		
		// Wait for email field
		perform.waitForElementToBeClickable(driver, VLogin.email_txtbx(), "id");
		
		// Click Sign Up
		perform.click(driver,VLogin.signUp_btn(driver));
		
		// Wait for company name textbox
		perform.waitForElementToBeClickable(driver, VSignUp.companyName_txtbx(), "id");
		
		// Click the Sign in link
		perform.click(driver,driver.findElement(By.linkText("Click here")));
		
		// Wait for email textbox
		perform.waitForElementToBeClickable(driver, VLogin.email_txtbx(), "id");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().equals(StoredVariables.getvendorsSite().get()), "The url is incorrect");
		
		// Log test
		test.log(LogStatus.INFO, "login", "The Click here link from the Sign Up page opened the login page");
		
	} // end signUp_SignIn
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to Vendors</li>
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
	@Test (retryAnalyzer = Retry.class, groups={"Vendors - Sign Up", "Vendors - Terms Of Use"}, alwaysRun=true)
	public void signUp_TermsOfUse() throws InterruptedException, IOException {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Go to Vendors
		driver.get(StoredVariables.getvendorsSite().get());
		
		// Wait for email field
		perform.waitForElementToBeClickable(driver, VLogin.email_txtbx(), "id");
		
		// Click Sign Up
		perform.click(driver,VLogin.signUp_btn(driver));
		
		// Wait for company name textbox
		perform.waitForElementToBeClickable(driver, VSignUp.companyName_txtbx(), "id");
		
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
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to Vendors</li>
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
	@Test (retryAnalyzer = Retry.class, groups={"Vendors - Sign Up"}, alwaysRun=true)
	public void signUp_GoToSecure() throws InterruptedException, IOException {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Go to Vendors
		driver.get(StoredVariables.getvendorsSite().get());
		
		// Wait for email field
		perform.waitForElementToBeClickable(driver, VLogin.email_txtbx(), "id");
		
		// Click Sign Up
		perform.click(driver,VLogin.signUp_btn(driver));
		
		// Wait for company name textbox
		perform.waitForElementToBeClickable(driver, VSignUp.companyName_txtbx(), "id");
		
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();

		// Click the vendors link
		perform.click(driver,driver.findElement(By.linkText("clicking here.")));
		
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().contains("SignupWiz.aspx"), "The url is incorrect.");
		
		// Close the new window, if that window no more required
		driver.close();

		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
		
		// Log test
		test.log(LogStatus.INFO, "login", "The Vendors link opened the correct url");
		
	} // end signUp_TermsOfUse
	
} // end the Secure_Login class
