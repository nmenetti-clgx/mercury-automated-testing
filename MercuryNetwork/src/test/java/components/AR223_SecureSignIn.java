package components;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Secure.SForgotPassword;
import pageObjects.Secure.SLogin;
import pageObjects.Secure.SOrders;
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
 * @since   07-30-2019
 */

@Listeners(utils.Listener.class)
public class AR223_SecureSignIn extends TestSetup {
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to Secure</li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws InterruptedException the interrupted exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Login", "AR223"}, alwaysRun=true)
	public void ar223_1_ChatWithUsNowChatFeature() throws InterruptedException {

		// Create the driver for the test
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Get current time
		int hour = Integer.parseInt(perform.getTodaysDateFormatted(driver, "HH"));
		
		// Only run between 8am and 5pm
		if (hour >= 8 && hour <= 17) {

			// Go to Secure
			driver.get(StoredVariables.getsecureSite().get());
			
			// Click the hyperlink 'Chat with us now'
			perform.click(driver, SLogin.chatWithUsNow_link(driver));
			
			// Wait for the overlay to be visible
			waitForChatDialog(driver, true);
			
			// Verify a window titled Live Support is displayed
			perform.verification(driver, SLogin.chatWindowDialogTitle_txt(driver).getText(), "contains", "Live Support");
			
			// Fill out only the Name field
			perform.type(driver, SLogin.chatWindowName_txtbx(driver), "Automation Test");
			
			// Click 'Chat with us'
			perform.click(driver, SLogin.chatWindowChatWithUs_btn(driver));
			
			// Verify Email, Customer ID or Phone and Question are all highlighted in red
			perform.verification(driver, SLogin.chatWindowEmail_txt(driver).getAttribute("style"), "contains", "color: red;");
			perform.verification(driver, SLogin.chatWindowPhone_txt(driver).getAttribute("style"), "contains", "color: red;");
			perform.verification(driver, SLogin.chatWindowQuestion_txt(driver).getAttribute("style"), "contains", "color: red;");
			
			// Close the window.
			perform.click(driver, SLogin.chatWindowClose_btn(driver));
			
			// Wait for the overlay to be hidden
			waitForChatDialog(driver, false);
			
			// Click the hyperlink 'Chat with us now'
			perform.click(driver, SLogin.chatWithUsNow_link(driver));
			
			// Wait for the overlay to be visible
			waitForChatDialog(driver, true);
			
			// Verify a window titled Live Support is displayed
			perform.verification(driver, SLogin.chatWindowDialogTitle_txt(driver).getText(), "contains", "Live Support");
			
			// Fill out only the Name and Email field
			perform.type(driver, SLogin.chatWindowName_txtbx(driver), "Automation Test");
			perform.type(driver, SLogin.chatWindowEmail_txtbx(driver), "AutomationTest@dntest.net");
			
			// Click 'Chat with us'
			perform.click(driver, SLogin.chatWindowChatWithUs_btn(driver));
			
			// Verify Customer ID or Phone and Question are all highlighted in red
			perform.verification(driver, SLogin.chatWindowPhone_txt(driver).getAttribute("style"), "contains", "color: red;");
			perform.verification(driver, SLogin.chatWindowQuestion_txt(driver).getAttribute("style"), "contains", "color: red;");
			
			// Close the window
			perform.click(driver, SLogin.chatWindowClose_btn(driver));
			
			// Wait for the overlay to be hidden
			waitForChatDialog(driver, false);
			
			// Click the hyperlink 'Chat with us now'
			perform.click(driver, SLogin.chatWithUsNow_link(driver));
			
			// Wait for the overlay to be visible
			waitForChatDialog(driver, true);
			
			// Verify a window titled Live Support is displayed
			perform.verification(driver, SLogin.chatWindowDialogTitle_txt(driver).getText(), "contains", "Live Support");
			
			// Fill out the Name, Email and Customer ID or Phone fields
			perform.type(driver, SLogin.chatWindowName_txtbx(driver), "Automation Test");
			perform.type(driver, SLogin.chatWindowEmail_txtbx(driver), "AutomationTest@dntest.net");
			perform.type(driver, SLogin.chatWindowPhone_txtbx(driver), "5015551233");
			
			// Click 'Chat with us'
			perform.click(driver, SLogin.chatWindowChatWithUs_btn(driver));
			
			// Verify Question is highlighted in red
			perform.verification(driver, SLogin.chatWindowQuestion_txt(driver).getAttribute("style"), "contains", "color: red;");
			
		} // end if

		// Log test
		perform.addInfoToExtentReport(driver, "login", "Verified the chat with us dialog");
		
	} // end ar223_1_ChatWithUsNowChatFeature
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to Secure</li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws InterruptedException the interrupted exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Login", "AR223"}, alwaysRun=true)
	public void ar223_2_ChatWithUsNowEmailFeature() throws InterruptedException {

		// Create the driver for the test
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Get current time
		int hour = Integer.parseInt(perform.getTodaysDateFormatted(driver, "HH"));
		
		// Only run between 8am and 5pm
		if (hour >= 8 && hour <= 17) {

			// Go to Secure
			driver.get(StoredVariables.getsecureSite().get());
			
			// Click the hyperlink 'Chat with us now'
			perform.click(driver, SLogin.chatWithUsNow_link(driver));
			
			// Wait for the overlay to be visible
			waitForChatDialog(driver, true);
			
			// Verify a window titled Live Support is displayed
			perform.verification(driver, SLogin.chatWindowDialogTitle_txt(driver).getText(), "contains", "Live Support");
			
			// Fill out only the Name field
			perform.type(driver, SLogin.chatWindowName_txtbx(driver), "Automation Test");
			
			// Click 'Email us'
			perform.click(driver, SLogin.chatWindowEmailUs_btn(driver));
			
			// Verify Email, Customer ID or Phone and Question are all highlighted in red
			perform.verification(driver, SLogin.chatWindowEmail_txt(driver).getAttribute("style"), "contains", "color: red;");
			perform.verification(driver, SLogin.chatWindowPhone_txt(driver).getAttribute("style"), "contains", "color: red;");
			perform.verification(driver, SLogin.chatWindowQuestion_txt(driver).getAttribute("style"), "contains", "color: red;");
			
			// Close the window
			perform.click(driver, SLogin.chatWindowClose_btn(driver));
			
			// Wait for the overlay to be hidden
			waitForChatDialog(driver, false);
			
			// Click the hyperlink 'Chat with us now'
			perform.click(driver, SLogin.chatWithUsNow_link(driver));
			
			// Wait for the overlay to be visible
			waitForChatDialog(driver, true);
			
			// Verify a window titled Live Support is displayed
			perform.verification(driver, SLogin.chatWindowDialogTitle_txt(driver).getText(), "contains", "Live Support");
			
			// Fill out the Name and Email fields
			perform.type(driver, SLogin.chatWindowName_txtbx(driver), "Automation Test");
			perform.type(driver, SLogin.chatWindowEmail_txtbx(driver), "AutomationTest@dntest.net");
			
			// Click 'Email us'
			perform.click(driver, SLogin.chatWindowEmailUs_btn(driver));
			
			// Verify Customer ID or Phone and Question are all highlighted in red
			perform.verification(driver, SLogin.chatWindowPhone_txt(driver).getAttribute("style"), "contains", "color: red;");
			perform.verification(driver, SLogin.chatWindowQuestion_txt(driver).getAttribute("style"), "contains", "color: red;");
			
			// Close the window
			perform.click(driver, SLogin.chatWindowClose_btn(driver));
			
			// Wait for the overlay to be hidden
			waitForChatDialog(driver, false);
			
			// Click the hyperlink 'Chat with us now'
			perform.click(driver, SLogin.chatWithUsNow_link(driver));
			
			// Wait for the overlay to be visible
			waitForChatDialog(driver, true);
			
			// Verify a window titled Live Support is displayed
			perform.verification(driver, SLogin.chatWindowDialogTitle_txt(driver).getText(), "contains", "Live Support");
			
			// Fill out the Name, Email and Customer ID or Phone fields
			perform.type(driver, SLogin.chatWindowName_txtbx(driver), "Automation Test");
			perform.type(driver, SLogin.chatWindowEmail_txtbx(driver), "AutomationTest@dntest.net");
			perform.type(driver, SLogin.chatWindowPhone_txtbx(driver), "5015551233");
			
			// Click 'Email us'
			perform.click(driver, SLogin.chatWindowEmailUs_btn(driver));
			
			// Verify Question is highlighted in red
			perform.verification(driver, SLogin.chatWindowQuestion_txt(driver).getAttribute("style"), "contains", "color: red;");
			
			// Close the window
			perform.click(driver, SLogin.chatWindowClose_btn(driver));
			
			// Wait for the overlay to be hidden
			waitForChatDialog(driver, false);
			
			// Click the hyperlink 'Chat with us now'
			perform.click(driver, SLogin.chatWithUsNow_link(driver));
			
			// Wait for the overlay to be visible
			waitForChatDialog(driver, true);
			
			// Verify a window titled Live Support is displayed
			perform.verification(driver, SLogin.chatWindowDialogTitle_txt(driver).getText(), "contains", "Live Support");
			
		} // end if
		
		// Log test
		perform.addInfoToExtentReport(driver, "login", "Verified the chat with us email dialog");
		
	} // end ar223_2_ChatWithUsNowEmailFeature
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to Secure</li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException 
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Login", "AR223"}, alwaysRun=true)
	public void ar223_3_TermsOfUse() throws InterruptedException, IOException {

		// Create the driver for the test
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Go to Secure
		driver.get(StoredVariables.getsecureSite().get());
		
		// Click the 'Terms of Use' hyperlink
		perform.click(driver, SLogin.termsOfUse_link(driver));
		
		// Switch to the new window
		perform.switchToXSiteWindowByTitle(driver, "Terms of Use");
		
		// Verify the Terms of Use is displayed
		String tou = driver.findElement(By.cssSelector("body > p:nth-child(1) > strong")).getText();
		perform.verification(driver, tou, "contains", "IMPORTANT NOTICE TO USER – PLEASE READ CAREFULLY");
		
		// Verify the Title of the page is "Mercury Network - Terms of Use"
		perform.verification(driver, driver.getTitle(), "equals", "Mercury Network - Terms of Use");
		
		// Verify the URL is "https://secure.mercuryvmp.com/TOU.htm"
		perform.verification(driver, driver.getCurrentUrl(), "contains", "/TOU.htm");
		
		// Log test
		perform.addInfoToExtentReport(driver, "login", "Verified the Terms of Use");
		
	} // end ar223_3_TermsOfUse
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to Secure</li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws InterruptedException the interrupted exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Login", "AR223"}, alwaysRun=true)
	public void ar223_4_ForgotYourPassword() throws InterruptedException {

		// Create the driver for the test
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Go to Secure
		driver.get(StoredVariables.getsecureSite().get());
		
		// Click 'Forgot your password?'
		perform.click(driver, SLogin.forgotYourPassword_link(driver));
		
		// Wait for username textbox
		perform.waitForElementToBeClickable(driver, SForgotPassword.usernameForgotPassword_txtbx(), "id");
		
		// Verify url
		perform.verification(driver, driver.getCurrentUrl(), "contains", StoredVariables.getsecureSite().get());
		
		// Get page text
		String text = SForgotPassword.page_txt(driver).getText();
		
		// Verify page text
		Assert.assertTrue(text.contains("Locate your account by entering your Mercury Network username (e-mail address)."), "The text on the Forgot Password page is incorrect");
		
		// Enter a valid email address
		String email = "automation"+StoredVariables.getusernameEnvironment().get()+"ForgotPassword1@dntest.net";
		perform.type(driver, SForgotPassword.usernameForgotPassword_txtbx(driver), email);
		
		// Click 'Reset Password'
		perform.click(driver, SForgotPassword.resetPassword_btn(driver));
		
		// Verify a new pod displays
		String podText = SForgotPassword.emailSent_txt(driver).getText();
		
		// Verify the title is 'E-mail sent'
		perform.verification(driver, podText, "contains", "E-mail sent");
		
		// Verify the text reads 'An e-mail has been sent to the address provided. Please check for receipt and follow the directions to reset your password.'
		perform.verification(driver, podText, "contains", "An e-mail has been sent to the address provided. Please check for receipt and follow the directions to reset your password.");
		
		// Verify the Sign Up button is displayed below the 'E-mail sent' pod
		perform.verification(driver, perform.checkIfElementExists(driver, By.cssSelector(SLogin.signUp_btn())), "equals", true);
		
		// Verify the text next to the Sign Up button reads 'Mercury Network’s cloud-based software makes your job much easier.'
		perform.verification(driver, SForgotPassword.signUp_txt(driver).getText(), "contains", "Mercury Network’s cloud-based software makes your job much easier.");
		
		// Click 'Return to Sign in'
		perform.click(driver, SForgotPassword.returnToSignIn_btn(driver));
		
		// Verify you are taken back to the Sign In page at secure.mercuryvmp.com
		perform.verification(driver, driver.getCurrentUrl(), "equals", StoredVariables.getsecureSite().get()+"/");
		
//		// Check your e-mail.
//		// Go to Notification Search
//		it.goToNotificationSearch(driver);
//		
//		// Enter the email address in the To Address
//		it.searchNotificationsByProductItemID(driver, email);
//		
//		// Open the email by clicking the Body link
//		
//		
//		// Verify you received an e-mail titled Mercury Network password reset
//		
//		
//		// Verify there is a Reset Now button in the body of the email
//		
		
		// Log test
		perform.addInfoToExtentReport(driver, "login", "Verified the Forgot your password functionality");
		
	} // end ar223_4_ForgotYourPassword
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to Secure</li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws InterruptedException the interrupted exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Login", "AR223"}, alwaysRun=true)
	public void ar223_5_SignIn() throws InterruptedException {

		// Create the driver for the test
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Set the user
		String user = "automation"+StoredVariables.getusernameEnvironment().get()+"Baseline1@dntest.net";
		
		// Set the password
		String password = StoredVariables.getpassword().get();

		// Go to Secure
		driver.get(StoredVariables.getsecureSite().get());
		
		// Enter an invalid email address
		perform.type(driver, SLogin.email_txtbx(driver), "automatoin");
		
		// Enter a valid password
		perform.type(driver, SLogin.password_txtbx(driver), password);
		
		// Click Sign In
		perform.click(driver, SLogin.signIn_btn(driver));
		
		// Wait for error message
		perform.waitForElementToBeClickable(driver, SLogin.loginError_txt(), "id");
		
		// Verify a new pod in Red is displayed
		perform.verification(driver, SLogin.loginError_txt(driver).getAttribute("class"), "contains", "RedBox");
		
		// Verify the test reads 'Your email or password (case sensitive) was incorrect. Please try again or select forgot password.'
		perform.verification(driver, SLogin.loginError_txt(driver).getText(), "contains", "Your email or password (case sensitive) was incorrect. Please try again or select ");
		
		// Click the 'forgot password' link
		perform.click(driver, SLogin.forgotYourPassword_link(driver));
		
		// Verify it takes you to the Forgot Password page
		perform.click(driver, SForgotPassword.usernameForgotPassword_txtbx(driver));
		
		// Click Cancel
		perform.click(driver, SForgotPassword.cancel_btn(driver));
		
		// Verify you are taken back to the Secure Sign In page
		perform.click(driver, SLogin.email_txtbx(driver));
		
		// Enter a valid email address
		perform.type(driver, SLogin.email_txtbx(driver), user);
		
		// Enter an invalid password
		perform.type(driver, SLogin.password_txtbx(driver), "laksdjflksadjf");
		
		// Click Sign In
		perform.click(driver, SLogin.signIn_btn(driver));
		
		// Wait for error message
		perform.waitForElementToBeClickable(driver, SLogin.loginError_txt(), "id");
		
		// Verify a new pod in Red is displayed
		perform.verification(driver, SLogin.loginError_txt(driver).getAttribute("class"), "contains", "RedBox");
		
		// Verify the test reads 'Your email or password (case sensitive) was incorrect. Please try again or select forgot password.'
		perform.verification(driver, SLogin.loginError_txt(driver).getText(), "contains", "Your email or password (case sensitive) was incorrect. Please try again or select ");
		
		// Click the 'forgot password' link
		perform.click(driver, SLogin.forgotYourPassword_link(driver));
		
		// Verify it takes you to the Forgot Password page
		perform.click(driver, SForgotPassword.usernameForgotPassword_txtbx(driver));
		
		// Click Cancel
		perform.click(driver, SForgotPassword.cancel_btn(driver));
		
		// Verify you are taken back to the Secure Sign In page
		perform.click(driver, SLogin.email_txtbx(driver));
		
		// Enter a valid email address
		perform.type(driver, SLogin.email_txtbx(driver), user);
		
		// Enter an invalid password
		perform.type(driver, SLogin.password_txtbx(driver), "laksdjflksadjf");
		
		// Check 'Remember me'
		perform.checkCheckbox(driver, SLogin.rememberMe_chkbx(driver));
		
		// Click Sign In
		perform.click(driver, SLogin.signIn_btn(driver));
		
		// Wait for error message
		perform.waitForElementToBeClickable(driver, SLogin.loginError_txt(), "id");
		
		// Verify the test reads 'Your email or password (case sensitive) was incorrect. Please try again or select forgot password.'
		perform.verification(driver, SLogin.loginError_txt(driver).getText(), "contains", "Your email or password (case sensitive) was incorrect. Please try again or select ");
		
		// Verify the 'Remember me' box is still checked
		perform.verification(driver, SLogin.rememberMe_chkbx(driver).isSelected(), "equals", true);
		
//		// Close the browser
//		
//		
//		// Open the browser and go to secure.mercuryvmp.com
//		
//		
//		// Verify the 'Remember me' box is checked
//		
//		
		// Verify the previously entered email address is auto-populated in the E-mail field
		perform.verification(driver, SLogin.email_txtbx(driver).getAttribute("value"), "equals", user);
		
		// Enter a valid password
		perform.type(driver, SLogin.password_txtbx(driver), password);
		
		// Click Sign In
		perform.click(driver, SLogin.signIn_btn(driver));
		
		// Verify you are logged into Secure
		perform.click(driver, SOrders.find_txtbx(driver));
		
		// Log test
		perform.addInfoToExtentReport(driver, "login", "Verified the sign in functionality");
		
	} // end ar223_5_SignIn
	
	/**
	 * Wait for chat dialog.
	 *
	 * @param driver the driver
	 * @param visible the visible
	 * @throws InterruptedException the interrupted exception
	 */
	private void waitForChatDialog (RemoteWebDriver driver, boolean visible) throws InterruptedException {
		
		// Set the expected result
		String expected = visible ? "display: block" : "display: none";
		
		// Get the style of the dialog
		String dialog = SLogin.chatWindowDialog(driver).getAttribute("style");
		
		// Wait for the dialog to be visible or hidden
		int a = 1;
		while (!dialog.contains(expected) && a++ < 10) {
			
			perform.sleep(driver, 1);
			dialog = SLogin.chatWindowDialog(driver).getAttribute("style");
			
		} // end while
		
		if (expected.contains("block")) {
			
			String title = SLogin.chatWindowDialogTitle_txt(driver).getText();
			
			int i = 1;
			while (!title.contains("Live Support") && i++ <= 10) {
				
				perform.sleep(driver, 1);
				title = SLogin.chatWindowDialogTitle_txt(driver).getText();
				
			} // end while
			
		} // end if
		
	} // end waitForChatDialog
	
} // end the Secure_SignIn class
