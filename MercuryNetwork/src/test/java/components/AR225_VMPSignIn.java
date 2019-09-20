package components;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Overlay.Overlay;
import pageObjects.VMP.VMPForgotPassword;
import pageObjects.VMP.VMPLogin;
import setup.DriverFactory;
import setup.TestSetup;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Baseline VMP - Login</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-01-2019
 */

@Listeners(utils.Listener.class)
public class AR225_VMPSignIn extends TestSetup {
	
	/** The user. */
	private final String user = "EVFLender2";

	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get environment</li>
	 * 	<li>Go to login page</li>
	 * 	<li>Enter username</li>
	 * 	<li>Clear password field</li>
	 * 	<li>Click Sign In</li>
	 * 	<li>Verify error text</li>
	 * 	<li>Click OK</li>
	 *  <li>Verify the dialog closes</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws InterruptedException the interrupted exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"VMP - Login", "AR225"}, alwaysRun=true)
	public void ar225_1_SignInAttemptWithNoPassword() throws InterruptedException {

		// Create the driver
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Get environment
		String environment = StoredVariables.getusernameEnvironment().get();

		// Go to login page
		driver.get("https://automation" + environment + user + "." + StoredVariables.getvmpSiteSuffix().get());

		// Enter username
		perform.type(driver, VMPLogin.email_txtbx(driver), "automation" + environment + user);

		// Clear password field
		VMPLogin.password_txtbx(driver).clear();

		// Click Sign In
		perform.click(driver,VMPLogin.signIn_btn(driver));

		// Wait for dialog box
		perform.waitForElementToBeClickable(driver, VMPLogin.invalidInformationDialog2_txt(), "id");

		// Verify error text
		String dialogText = VMPLogin.invalidInformationDialog2_txt(driver).getText();
		perform.verification(driver, dialogText, "contains", "Invalid Information");
		perform.verification(driver, dialogText, "contains", "There is a problem with some of the information you have provided for the order.");
		perform.verification(driver, dialogText, "contains", "Password is required");

		// Click OK
		perform.click(driver,VMPLogin.ok_btn(driver));
		
		// Verify the warning dialog closes
		perform.verification(driver, VMPLogin.invalidInformationDialog2_txt(driver).getAttribute("style"), "contains", "display: none;");

		// Log test
		perform.addInfoToExtentReport(driver, "login", "Tried logging in with an empty password");

	} // end ar225_1_SignInAttemptWithNoPassword

	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get environment</li>
	 * 	<li>Go to login page</li>
	 * 	<li>Enter email</li>
	 * 	<li>Enter invalid password</li>
	 * 	<li>Click Sign In</li>
	 * 	<li>Verify error text</li>
	 *  <li>Click OK</li>
	 *  <li>Verify dialog closes</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws InterruptedException the interrupted exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"VMP - Login", "AR225"}, alwaysRun=true)
	public void ar225_2_SignInAttemptWithInvalidPassword() throws InterruptedException {

		// Create the driver
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Get environment
		String environment = StoredVariables.getusernameEnvironment().get();

		// Go to login page
		driver.get("https://automation" + environment + user + "." + StoredVariables.getvmpSiteSuffix().get());

		// Enter email
		perform.type(driver, VMPLogin.email_txtbx(driver), "automation" + environment + user);

		// Enter invalid password
		perform.type(driver, VMPLogin.password_txtbx(driver), "password");

		// Click Sign In
		perform.click(driver,VMPLogin.signIn_btn(driver));

		// Wait for error
		perform.waitForElementToBeClickable(driver, VMPLogin.invalidInformationDialog_txt(), "id");

		// Verify error text
		String dialogText = VMPLogin.invalidInformationDialog_txt(driver).getText();
		perform.verification(driver, dialogText, "contains", "Invalid Login");
		perform.verification(driver, dialogText, "contains", "The username and/or password you entered is invalid.");
		perform.verification(driver, dialogText, "contains", "Please try again.");
		
		// Click OK
		perform.click(driver,VMPLogin.ok2_btn(driver));
		
		// Verify the warning dialog closes
		perform.verification(driver, VMPLogin.invalidInformationDialog_txt(driver).getAttribute("style"), "contains", "display: none;");

		// Log test
		perform.addInfoToExtentReport(driver, "login", "Tried logging in with an incorrect password");

	} // end ar225_2_SignInAttemptWithInvalidPassword

	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to VMP Client Portal</li>
	 * 	<li>Verify successful login</li>
	 *  <li>Click Sign Out</li>
	 *  <li>Verify the URL</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws InterruptedException the interrupted exception
	 * @throws SQLException the SQLException
	 * @throws ClassNotFoundException the ClassNotFoundException
	 */
	@Test (retryAnalyzer = Retry.class, groups={"VMP - Login", "AR225"}, alwaysRun=true)
	public void ar225_3_SuccessfulSignInAttempt() throws InterruptedException, ClassNotFoundException, SQLException {

		// Create the driver
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Login to VMP Client Portal
		vmp.login(driver, user, "Originator"+user, StoredVariables.getpassword().get());

		// Verify successful login
		Assert.assertTrue(driver.getTitle().equals("Orders"));
		Assert.assertTrue(driver.getCurrentUrl().contains("Orders.aspx"));

		// Sign out
		vmp.signOut(driver);
		
		// Log test
		perform.addInfoToExtentReport(driver, "login", "Logged in and signed out successfully");

	} // end ar225_3_SuccessfulSignInAttempt

	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get environment</li>
	 * 	<li>Go to login page</li>
	 * 	<li>Click the Forgot password link</li>
	 * 	<li>Verify page text</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Test (retryAnalyzer = Retry.class, groups={"VMP - Forgot Password", "AR225"}, alwaysRun=true)
	public void ar225_5_ForgotPasswordWithValidEmail() throws InterruptedException, IOException {

		// Create the driver
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Get environment
		String environment = StoredVariables.getusernameEnvironment().get();
		
		// Set VMP URL
		String vmpURL = "https://AutomationQABaseline11.vmpclientqa.com";
		if (environment.equals("Live")) {
			vmpURL = "https://AutomationQABaseline1.vmpclient.com";
		} // end if
		
		// Set valid email address
		String emailAddress = "automationQAPassword1@dntest.net";
		if (environment.equals("Live")) {
			emailAddress = "automationLivePassword1@dntest.net";
		} // end if
		
		// Set valid username
		String username = "automationQAOriginatorPassword1";
		if (environment.equals("Live")) {
			username = "OriginatorPassword1";
		} // end if
		
		// Go to login page
		driver.get(vmpURL);

		// Click the Forgot password link
		perform.click(driver,driver.findElement(By.linkText("Forgot Password?")));

		// Wait for Send Account Info button
		perform.waitForElementToBeClickable(driver, VMPForgotPassword.email_txtbx(), "id");

		// Get page text
		String text = VMPForgotPassword.sendAccountInfo_txt(driver).getText();

		// Verify page text
		perform.verification(driver, text, "contains", "Send Account Info");
		perform.verification(driver, text, "contains", "Forgot your Username or Password?");
		perform.verification(driver, text, "contains", "Just enter your e-mail and we'll send it to you.");
		perform.verification(driver, text, "contains", "E-mail:");

		// Enter VMP Client email address
		perform.type(driver, VMPForgotPassword.email_txtbx(driver), emailAddress);
		
		// Click Send Account Info
		perform.click(driver, VMPForgotPassword.sendAccountInfo_btn(driver));
		
		// Verify you receive a message window
		perform.waitForAttributeValueToBePresent(driver, Overlay.alertDialog(driver), "style", "block;");
		perform.verification(driver, Overlay.alertDialog(driver).getAttribute("style"), "contains", "display: block;");
		
		// Wait for the alert dialog
		perform.waitForElementToBeClickable(driver, Overlay.alertDialog(driver));
		
		// Get the alert dialog text
		text = Overlay.alertDialog(driver).getText();
		
		// Verify the Title is 'Send Account Info'
		perform.verification(driver, text, "contains", "Send Account Info");
		
		// Verify the text reads 'Your account information has been sent.'
		perform.verification(driver, text, "contains", "Your account information has been sent.");
		
		// Click OK
		perform.click(driver, Overlay.okAlert_btn(driver));
		
		// Verify dialog closes
		perform.verification(driver, VMPForgotPassword.sendAccountInfo_txt(driver).getAttribute("style"), "contains", "display: none;");
		
		// Click 'Forgot Password?'
		perform.click(driver,driver.findElement(By.linkText("Forgot Password?")));
		
		// Enter the VMP Client's Username
		perform.type(driver, VMPForgotPassword.email_txtbx(driver), username);
		
		// Click Send Account Info
		perform.click(driver, VMPForgotPassword.sendAccountInfo_btn(driver));
		
		// Verify you receive a message window
		perform.waitForAttributeValueToBePresent(driver, Overlay.alertDialog(driver), "style", "block;");
		perform.verification(driver, Overlay.alertDialog(driver).getAttribute("style"), "contains", "display: block;");
		
		// Wait for the alert dialog
		perform.waitForElementToBeClickable(driver, Overlay.alertDialog(driver));
		
		// Get the alert dialog text
		text = Overlay.alertDialog(driver).getText();
		
		// Verify the Title is 'Send Account Info'
		perform.verification(driver, text, "contains", "Send Account Info");
		
		// Verify the text reads 'Your account information has been sent.'
		perform.verification(driver, text, "contains", "Your account information has been sent.");
		
		// Click 'OK'
		perform.click(driver, Overlay.okAlert_btn(driver));
		
		// Dialog should close
		perform.verification(driver, Overlay.alertDialog(driver).getAttribute("style"), "contains", "display: none;");
		
		// Click 'Forgot Password?'
		perform.click(driver,driver.findElement(By.linkText("Forgot Password?")));
		
		// Enter an invalid email address
		perform.type(driver, VMPForgotPassword.email_txtbx(driver), "clmn@clmn");
		
		// Click 'Send Account Info'
		perform.click(driver, VMPForgotPassword.sendAccountInfo_btn(driver));
		
		// Verify a warning is displayed
		perform.waitForAttributeValueToBePresent(driver, Overlay.alertDialog(driver), "style", "block;");
		perform.verification(driver, Overlay.alertDialog(driver).getAttribute("style"), "contains", "display: block;");
		
		// Get the alert dialog text
		text = Overlay.alertDialog(driver).getText();
		
		// Verify the Title is 'Send Account Info'
		perform.verification(driver, text, "contains", "Send Account Info");
		
		// Verify the text reads 'Sorry, we can not find that username in our database.'
		perform.verification(driver, text, "contains", "Sorry, we can not find that username in our database.");
		
		// Click 'OK'
		perform.click(driver, Overlay.okAlert_btn(driver));
		
		// Dialog should close
		perform.verification(driver, Overlay.alertDialog(driver).getAttribute("style"), "contains", "display: none;");
		
		// Click 'Forgot Password?'
		perform.click(driver,driver.findElement(By.linkText("Forgot Password?")));
		
		// Click 'Send Account Info'
		perform.click(driver, VMPForgotPassword.sendAccountInfo_btn(driver));
		
		// Verify a warning message is displayed
		perform.waitForAttributeValueToBePresent(driver, Overlay.summaryDialog(driver), "style", "block;");
		perform.verification(driver, Overlay.summaryDialog(driver).getAttribute("style"), "contains", "display: block;");
		
		// Get the alert dialog text
		text = Overlay.summaryDialog(driver).getText();
		
		// Verify the Title is 'Invalid Information'
		perform.verification(driver, text, "contains", "Invalid Information");
		
		// Verify the text reads as 'There is a problem with some of the information you have provided for the order. Please correct the following issues and then try again.'
		perform.verification(driver, text, "contains", "There is a problem with some of the information you have provided for the order. Please correct the following issues and then try again.");
		
		// Verify there is a bullet item and the text reads as '•E-mail is required'
		perform.verification(driver, text, "contains", "E-mail is required");
		
		// Click 'OK'
		perform.click(driver, Overlay.okSummary_btn(driver));
		
		// Dialog should close
		perform.verification(driver, Overlay.summaryDialog(driver).getAttribute("style"), "contains", "display: none;");
		
		// Log test
		perform.addInfoToExtentReport(driver, "login", "Verified Forgot your password functionality");

	} // end ar225_5_ForgotPasswordWithValidEmail
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get environment</li>
	 * 	<li>Go to login page</li>
	 * 	<li>Click the Terms of Use link</li>
	 * 	<li>Switch to the new window</li>
	 * 	<li>Verify url</li>
	 *  <li>Verify contents of the page</li>
	 * 	<li>close the window</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Test (retryAnalyzer = Retry.class, groups={"VMP - Terms Of Use", "AR225"}, alwaysRun=true)
	public void ar225_6_TermsOfUse() throws InterruptedException, IOException {

		// Create the driver
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Get environment
		String environment = StoredVariables.getusernameEnvironment().get();

		// Go to login page
		driver.get("https://automation" + environment + user + "." + StoredVariables.getvmpSiteSuffix().get());

		// Click the Terms of Use link
		perform.click(driver,driver.findElement(By.linkText("Terms of Use")));

		// Switch to the new window
		perform.switchToXSiteWindowByTitle(driver, "Terms of Use");

		// Verify url
		perform.verification(driver, driver.getCurrentUrl(), "contains", "/TOU.htm");
		
		// Verify contents of page
		String text = driver.findElement(By.cssSelector("body > p:nth-child(2)")).getText();
		String expectedData = "USING THIS SITE TO LOCATE A REAL ESTATE PROFESSIONAL OR VIEWING ANY OF THE WEB PAGES FOR ANY REASON "
				+ "CONSTITUTES YOUR ACCEPTANCE OF THE FOLLOWING TERMS OF USE (\"AGREEMENT\").  BY USING THE SITE, YOU REPRESENT AND "
				+ "WARRANT TO MERCURY NETWORK, LLC (\"COMPANY\") THAT YOU ARE A LICENSED REAL ESTATE APPRAISER, REAL ESTATE AGENT OR "
				+ "AN AUTHORIZED EMPLOYEE OF A BANK, MORTGAGE COMPANY OR OTHER PARTICIPANT IN THE REAL ESTATE MORTGAGE INDUSTRY. ";
		perform.verification(driver, text, "contains", expectedData);

		// close the window
		perform.closeNewWindow(driver);

		// Log test
		perform.addInfoToExtentReport(driver, "login", "The Terms of Use link opened the correct url");

	} // end ar225_6_TermsOfUse
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to VMP Client Portal</li>
	 * 	<li>Verify successful login</li>
	 *  <li>Click Sign Out</li>
	 *  <li>Verify the URL</li>
	 * 	<li>Log test</li>
	 * </ul>.
	 *
	 * @throws InterruptedException the interrupted exception
	 * @throws ClassNotFoundException the ClassNotFoundException
	 * @throws SQLException the SQLException
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Test (retryAnalyzer = Retry.class, groups={"VMP - Login", "AR225"}, alwaysRun=true)
	public void ar225_7_PoweredByMercuryNetworkLogo() throws InterruptedException, ClassNotFoundException, SQLException, IOException {

		// Create the driver
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Get environment
		String environment = StoredVariables.getusernameEnvironment().get();

		// Go to login page
		driver.get("https://automation" + environment + user + "." + StoredVariables.getvmpSiteSuffix().get());

		// Click the Powered By Mercury Network button
		perform.click(driver, VMPLogin.poweredByMercuryNetwork_btn(driver));
		
		// Switch to the new window
		perform.switchToXSiteWindowByTitle(driver, "Mercury Network - Appraisal Vendor Management Software");

		// Verify url
		perform.verification(driver, driver.getCurrentUrl(), "equals", "https://www.mercuryvmp.com/");
		
		// close the window
		perform.closeNewWindow(driver);
		
		// Log test
		perform.addInfoToExtentReport(driver, "login", "Verified the Powered By Mercury Network button");

	} // end ar225_7_PoweredByMercuryNetworkLogo
	
} // end the Secure_Login class
