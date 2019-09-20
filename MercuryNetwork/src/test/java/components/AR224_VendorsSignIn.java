package components;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Vendors.VForgotPassword;
import pageObjects.Vendors.VLogin;
import pageObjects.Vendors.VLoginLiveSupport;
import setup.DriverFactory;
import setup.TestSetup;
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
public class AR224_VendorsSignIn extends TestSetup {
	
	/** The user. */
	private final String user = "BaselineAppraiser1";
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to Vendors</li>
	 * 	<li>Enter valid email</li>
	 * 	<li>Clear password field</li>
	 * 	<li>click Sign In</li>
	 * 	<li>Verify error text</li>
	 * 	<li>Click OK</li>
	 *  <li>Verify the dialog closes</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws InterruptedException the interrupted exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Vendors - Login", "AR224"}, alwaysRun=true)
	public void ar224_1_SignInAttemptWithNoPassword() throws InterruptedException {

		// Create the driver for the test
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Go to Vendors
		driver.get(StoredVariables.getvendorsSite().get());
		
		// Enter valid email
		perform.type(driver, VLogin.email_txtbx(driver), "automation" + StoredVariables.getusernameEnvironment().get() + user + StoredVariables.getcatchAllDomain().get());
		
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
		
		// Verify
		perform.verifyTextDoesNotContain(driver, VLogin.invalidInformationDialog_txt(driver).getAttribute("style"), "block;");
		
		// Log test
		perform.addInfoToExtentReport(driver, "login", "Tried logging in with a valid email and empty password");
		
	} // end ar224_1_SignInAttemptWithNoPassword
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to Vendors</li>
	 * 	<li>Enter valid email</li>
	 * 	<li>Clear password field</li>
	 * 	<li>click Sign In</li>
	 * 	<li>Verify error text</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws InterruptedException the interrupted exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Vendors - Login", "AR224"}, alwaysRun=true)
	public void ar224_2_SignInAttemptWithInvalidPassword() throws InterruptedException {

		// Create the driver
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Go to Vendors
		driver.get(StoredVariables.getvendorsSite().get());
		
		// Enter valid email
		perform.type(driver, VLogin.email_txtbx(driver), "automation" + StoredVariables.getusernameEnvironment().get() + user + StoredVariables.getcatchAllDomain().get());
		
		// Enter invalid password
		perform.type(driver, VLogin.password_txtbx(driver), "65sd4");
		
		// click Sign In
		perform.click(driver,VLogin.signIn_btn(driver));
		
		// Wait for error
		perform.waitForElementToBeClickable(driver, VLogin.loginError_txt(), "id");
		
		// Verify error text
		Assert.assertTrue(VLogin.loginError_txt(driver).getText().contains("Your email or password (case sensitive) was incorrect. Please try again or select "), "The error message is incorrect");
		
		// Log test
		perform.addInfoToExtentReport(driver, "login", "Tried logging in with an incorrect password");
		
	} // end ar224_2_SignInAttemptWithInvalidPassword
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to Vendors</li>
	 *  <li>Enter invalid email</li>
	 *  <li>Enter invalid password</li>
	 *  <li>Click Sign In</li>
	 *  <li>Wait for the error message</li>
	 *  <li>Verify error text</li>
	 * 	<li>Click the Forgot password link in the pink banner</li>
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
	@Test (retryAnalyzer = Retry.class, groups={"Vendors - Forgot Password", "AR224"}, alwaysRun=true)
	public void ar224_3_ResetPasswordWithValidEmailAddressFromPinkBanner() throws InterruptedException, IOException {

		// Create the driver
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Go to Vendors
		driver.get(StoredVariables.getvendorsSite().get());
		
		// Enter invalid email
		perform.type(driver, VLogin.email_txtbx(driver), "clmn@clmn.com");
		
		// Enter invalid password
		perform.type(driver, VLogin.password_txtbx(driver), "65sd4");
		
		// click Sign In
		perform.click(driver,VLogin.signIn_btn(driver));
		
		// Wait for error
		perform.waitForElementToBeClickable(driver, VLogin.loginError_txt(), "id");
		
		// Verify error text
		Assert.assertTrue(VLogin.loginError_txt(driver).getText().contains("Your email or password (case sensitive) was incorrect. Please try again or select "), "The error message is incorrect");
		
		// Click the Forgot password link in the pink banner
		perform.click(driver,driver.findElement(By.linkText("forgot password.")));
		
		// Wait for username textbox
		perform.waitForElementToBeClickable(driver, VForgotPassword.usernameForgotPassword_txtbx(driver));
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().contains(StoredVariables.getvendorsSite().get()+"SignIn.aspx"), "The url is incorrect");
		
		// Get page text
		String text = VForgotPassword.page_txt(driver).getText();
				// Verify page text
		Assert.assertTrue(text.contains("Locate your account by entering your Mercury Network username (e-mail address)."), "The text on the Forgot Password page is incorrect");
		Assert.assertTrue(text.contains("Welcome to Mercury Network. This is the premier vendor management software platform for the nation"), "The text on the Forgot Password page is incorrect. Text on screen = " + text);
		Assert.assertTrue(text.contains("s largest lenders and appraisal management companies."), "The text on the Forgot Password page is incorrect. Text on screen = " + text);
		Assert.assertTrue(text.contains("Username (e-mail)"), "The text on the Forgot Password page is incorrect");
		Assert.assertTrue(text.contains("800-900-4954"), "The text on the Forgot Password page is incorrect");
		
		// Enter valid email address
		perform.type(driver, VForgotPassword.usernameForgotPassword_txtbx(driver), "automation"+StoredVariables.getusernameEnvironment().get()+"ResetPassword1@dntest.net");
		
		// Click Reset Password
		perform.click(driver, VForgotPassword.resetPassword_btn(driver));
		
		// Wait for element to be clickable
		perform.waitForElementToBeClickable(driver, VForgotPassword.returnToSignIn_btn(driver));
		
		// Verify the pod caption text has the title "Email sent"
		perform.verification(driver, VForgotPassword.podCaption_txt(driver).getText(), "equals", "E-mail sent");
		
		// Text on page should read "An e-mail has been sent to the address provided. Please check for receipt and follow the directions to reset your password."
		perform.verification(driver, VForgotPassword.podHeader_txt(driver).getText(), "contains", "An e-mail has been sent to the address provided. Please check for receipt and follow the directions to reset your password.");
		
		// A password reset email was sent to the vendor's email address
		// need to figure out how to see if an email was sent
		
		// Go to Vendors
		driver.get(StoredVariables.getvendorsSite().get());
		
		// Click the Forgot password link
		perform.click(driver,driver.findElement(By.linkText("Forgot your password?")));
		
		// Click Cancel
		perform.click(driver,VForgotPassword.cancel_btn(driver));
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().equals(StoredVariables.getvendorsSite().get()), "The url is incorrect");
		
		// Log test
		perform.addInfoToExtentReport(driver, "login", "The Forgot your password link opened the correct url");
		
	} // end ar224_3_ResetPasswordWithValidEmailAddressFromPinkBannerw
	
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
	@Test (retryAnalyzer = Retry.class, groups={"Vendors - Forgot Password", "AR224"}, alwaysRun=true)
	public void ar224_4_ForgotPasswordWithValidEmailAddress() throws InterruptedException, IOException {

		// Create the driver
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Go to Vendors
		driver.get(StoredVariables.getvendorsSite().get());

		// Click the Forgot password link
		perform.click(driver,driver.findElement(By.linkText("Forgot your password?")));
		
		// Wait for element to be clickable
		perform.waitForElementToBeClickable(driver, VForgotPassword.resetPassword_btn(driver));
		
		// Get page text
		String text = VForgotPassword.page_txt(driver).getText();
		
		// Verify page text
		Assert.assertTrue(text.contains("Locate your account by entering your Mercury Network username (e-mail address)."), "The text on the Forgot Password page is incorrect");
		Assert.assertTrue(text.contains("Welcome to Mercury Network. This is the premier vendor management software platform for the nation"), "The text on the Forgot Password page is incorrect. Text on screen = " + text);
		Assert.assertTrue(text.contains("s largest lenders and appraisal management companies."), "The text on the Forgot Password page is incorrect. Text on screen = " + text);
		Assert.assertTrue(text.contains("Username (e-mail)"), "The text on the Forgot Password page is incorrect");
		Assert.assertTrue(text.contains("800-900-4954"), "The text on the Forgot Password page is incorrect");
		
		// Verify the pod caption text has the title "Enter username"
		perform.verification(driver, VForgotPassword.podCaption_txt(driver).getText(), "equals", "Enter username");
		
		// Enter valid email address
		perform.type(driver, VForgotPassword.usernameForgotPassword_txtbx(driver), "automation"+StoredVariables.getusernameEnvironment().get()+"ResetPassword1@dntest.net");
		
		// Click Reset Password
		perform.click(driver, VForgotPassword.resetPassword_btn(driver));
		
		// Wait for element to be clickable
		perform.waitForElementToBeClickable(driver, VForgotPassword.returnToSignIn_btn(driver));
		
		// Verify the pod caption text has the title "Email sent"
		perform.verification(driver, VForgotPassword.podCaption_txt(driver).getText(), "equals", "E-mail sent");
		
		// Text on page should read "An e-mail has been sent to the address provided. Please check for receipt and follow the directions to reset your password."
		perform.verification(driver, VForgotPassword.podHeader_txt(driver).getText(), "contains", "An e-mail has been sent to the address provided. Please check for receipt and follow the directions to reset your password.");
		
		// Log test
		perform.addInfoToExtentReport(driver, "login", "The Forgot your password link sends an email");
		
	} // end ar224_4_ForgotPasswordWithValidEmailAddress
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to Vendors</li>
	 * 	<li>Click the chat with us now link</li>
	 * 	<li>Wait for th Name textbox to be clickable</li>
	 * 	<li>Verify the dialog is displayed</li>
	 * 	<li>Determine if the window is a chat window or e-mail window (this changes based on the time of day)</li>
	 *  <li>Click the 'Chat with us' or 'Email us' button</li>
	 *  <li>The required items are now displayed in red</li>
	 *  <li>Close the dialog</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws InterruptedException the interrupted exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Vendors - Login", "AR224"}, alwaysRun=true)
	public void ar224_5_ChatLiveSupport() throws InterruptedException {
		
		// Create the driver
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Go to Vendors
		driver.get(StoredVariables.getvendorsSite().get());
		
		// Click 'chat with us now' link
		perform.click(driver, driver.findElement(By.linkText("chat with us now")));
		
		// Wait for element to be clickable
		perform.waitForElementToBeClickable(driver, VLoginLiveSupport.name_txtbx(driver));
		
		// Verify the dialog is displayed
		perform.verification(driver, VLoginLiveSupport.liveSupport_dialog(driver).getAttribute("style"), "contains", "display: block;");
		
		// Determine if the 'Chat with us' or 'E-mail us' button is displayed
		WebElement send = VLoginLiveSupport.chatWithUs_btn(driver);
		try {
			perform.click(driver, send);
		} catch (Exception e) {
			send = VLoginLiveSupport.emailUs_btn(driver);
			perform.click(driver, send);
		} // end try/catch
		
		// The required items are now displayed in red
		perform.verification(driver, VLoginLiveSupport.name_txt(driver).getAttribute("style"), "contains", "color: rgb(144, 144, 144)");
		perform.verification(driver, VLoginLiveSupport.email_txt(driver).getAttribute("style"), "contains", "color: red");
		perform.verification(driver, VLoginLiveSupport.customerIDOrPhone_txt(driver).getAttribute("style"), "contains", "color: red");
		perform.verification(driver, VLoginLiveSupport.question_txt(driver).getAttribute("style"), "contains", "color: red");
		
		// Close the dialog
		perform.click(driver, VLoginLiveSupport.close_btn(driver));
		
		// Verify the dialog is closed
		perform.verification(driver, VLoginLiveSupport.liveSupport_dialog(driver).getAttribute("style"), "contains", "display: none;");
		
//		// Click 'chat with us now' link
//		perform.click(driver, driver.findElement(By.linkText("chat with us now")));
//		
//		// Wait for element to be clickable
//		perform.waitForElementToBeClickable(driver, VLoginLiveSupport.name_txtbx(driver));
//		
//		// Enter an invalid email address, with a valid phone number, name and text in the Question field
//		// Enter name
//		perform.type(driver, VLoginLiveSupport.name_txtbx(driver), "Automation " + user);
//		
//		// Enter an invalid email address
//		perform.type(driver, VLoginLiveSupport.email_txtbx(driver), "clmn@clmn");
//		
//		// Enter Phone
//		String envNum = "111";
//		if (StoredVariables.getusernameEnvironment().get().equals("Live")) {
//			envNum = "333";
//		} // end if
//		perform.type(driver, VLoginLiveSupport.customerIDOrPhone_txtbx(driver), "501"+envNum+"2001");
//		
//		// Enter Question
//		perform.type(driver, VLoginLiveSupport.question_txtbx(driver), "This is a Mercury Network automated test. Please ignore");
//		
//		// Click 'Chat with us'
//		try {
//			perform.click(driver, VLoginLiveSupport.chatWithUs_btn(driver));
//		} catch (Exception e) {
//			perform.click(driver, VLoginLiveSupport.emailUs_btn(driver));
//		} // end try/catch
//		
//		// The label for the Email field is red.
//		perform.verification(driver, VLoginLiveSupport.email_txt(driver).getAttribute("style"), "contains", "color:red");
//		
//		
//		perform.pauseScript(driver);
//
//		
//		
//		
//		
//		// Enter an invalid email address, remove one number from the phone number
//		
//		
//		// The 'Live Chat window appears
//		perform.verification(driver, VLoginLiveSupport.liveChat_dialog(driver).getAttribute("src"), "contains", "display: block;");
//		perform.verification(driver, VLoginLiveSupport.liveChat_dialog(driver).getText(), "contains", "Live Chat");
//		
//		// Hover over the arrow in the top right corner of the chat window
//		perform.hover(driver, VLoginLiveSupport.liveChatArrow_btn(driver));
//		
//		// Click Minimize
//		perform.click(driver, VLoginLiveSupport.minimize_btn(driver));
//		
//		// The Live Chat is minimized
//		perform.verification(driver, VLoginLiveSupport.liveChat_dialog(driver).getAttribute("src"), "contains", "display: none;");
//		
//		// Click the arrow again
//		perform.click(driver, VLoginLiveSupport.liveChatArrow_btn(driver));
//		
//		// The window is displayed again
//		perform.verification(driver, VLoginLiveSupport.liveChat_dialog(driver).getAttribute("src"), "contains", "display: block;");
//		
//		// Hover over the arrow in the top right corner of the chat window
//		perform.hover(driver, VLoginLiveSupport.liveChatArrow_btn(driver));
//		
//		// Click End Chat
//		perform.click(driver, VLoginLiveSupport.endChat_btn(driver));
//
//		// The Live Chat window closes
//		perform.verification(driver, VLoginLiveSupport.liveChat_dialog(driver).getAttribute("src"), "contains", "display: none;");
//		
//		// Click 'Chat with us'
//		perform.click(driver, driver.findElement(By.linkText("chat with us now")));
//		
//		// Wait for element to be clickable
//		perform.waitForElementToBeClickable(driver, VLoginLiveSupport.name_txtbx(driver));
//		
//		// Enter a valid email
//		perform.type(driver, VLoginLiveSupport.email_txtbx(driver), "automation"+StoredVariables.getusernameEnvironment().get()+user+"@dntest.net");
//		
//		// Leave the Phone # blank
//		VLoginLiveSupport.customerIDOrPhone_txtbx(driver).clear();
//		
//		// Enter text into the Question field
//		perform.type(driver, VLoginLiveSupport.question_txtbx(driver), "This is a Mercury Network automated test. Please ignore");
//		
//		// Click 'Chat with us'
//		perform.click(driver, VLoginLiveSupport.chatWithUs_btn(driver));
//		
//		// The label for the Phone # field is red
//		
//		
//		// Enter a valid phone number
//		
//		
//		// Remove text from the Question field
//		
//		
//		// Click 'Chat with us'
//		
//		
//		// The label for the Question field is red
//		
//		
//		// Enter valid information in all required fields, leave the name field blank
//		
//		
//		// Click 'Chat with us'
//		
//		
//		// A Live Chat is started
//		
//		
//		// End the Live Chat
//		
//		
//		// Live Chat session should end
		
		
		// Log test
		perform.addInfoToExtentReport(driver, "login", "Verified the Chat/Live Support window opens and required fields are highlighted red");
		
	} // end ar224_5_ChatLiveSupport
	
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
	@Test (retryAnalyzer = Retry.class, groups={"Vendors - Terms Of Use", "AR224"}, alwaysRun=true)
	public void ar224_6_TermsOfUse() throws InterruptedException, IOException {

		// Create the driver
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Go to Vendors
		driver.get(StoredVariables.getvendorsSite().get());
		
		// Click the Terms of Use link
		perform.click(driver,driver.findElement(By.linkText("Terms of Use")));
		
		// Switch to the new window
		perform.switchToXSiteWindowByTitle(driver, "Terms of Use");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().contains("TOU.htm"), "The url is incorrect");
		
		// close the window
		perform.closeNewWindow(driver);
		
		// Log test
		perform.addInfoToExtentReport(driver, "login", "The Terms of Use link opened the correct url");
		
	} // end ar224_6_TermsOfUse

	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to Vendors</li>
	 * 	<li>Enter valid username</li>
	 * 	<li>Enter valid password</li>
	 * 	<li>Click Sign In</li>
	 * 	<li>Log test</li>
	 * </ul>
	 * @throws Exception 
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Vendors - Terms Of Use", "AR224"}, alwaysRun=true)
	public void ar224_7_SuccessfulSignInAttempt() throws Exception {

		// Create the driver
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Login to Vendors
		vendors.login(driver, user, StoredVariables.getpassword().get());
		
		// Sign out
		vendors.signOut(driver);
		
		// Log test
		perform.addInfoToExtentReport(driver, "login", "Verify you can successfully sign in and sign out");
		
	} // end ar224_7_SuccessfulSignInAttempt
	
} // end the Secure_Login class
