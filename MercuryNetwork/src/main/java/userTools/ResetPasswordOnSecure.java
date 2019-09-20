package userTools;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjects.Secure.SLogin;
import pageObjects.Secure.SOrders;
import pageObjects.Secure.SUsers;
import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;

// TODO: Auto-generated Javadoc
/**
 * The Class ResetPasswordOnSecure.
 */
public class ResetPasswordOnSecure extends TestSetup {
	
	/** The user. */
	// Set user information
	private static String user = "PasswordSecurity2"; // Not the full email address, just the users last name (This will be used to create the standardized email address)
	
	/** The password. */
	private static String password = "T3sting1";
	
	/** The reset QA. */
	// Booleans to know which environment was run to determine which email text should be generated
	private static boolean resetQA = true;
	
	/** The reset beta. */
	private static boolean resetBeta = false;
	
	/** The reset live. */
	private static boolean resetLive = false;
	
	/**
	 * Reset password on QA.
	 *
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws AWTException the AWT exception
	 */
	@Test (priority=0)
	public synchronized void resetPasswordOnQA() throws InterruptedException, IOException, AWTException {
	
		if (resetQA == true)
		{
		
			RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
			
			/********************************************************************************
			 * 
			 * CREATE USER ON QA
			 * 
			 ********************************************************************************/
			
			// Environment
			String env = "QA";
			
			// Go to QA Secure site
			driver.get("https://secure.mercuryvmpqa.com/");
			
			// Create the user
			resetPassword(driver, env);
			
		}
			
		
		else
		{
			ExtentTest test = ExtentTestManager.getTest();
			// Skip test
			System.out.println("Skipped resetting the password for the user on QA becuase the boolean was set to false");
			// Log a skip in the extent report
			test.log(LogStatus.SKIP, "<span class='label info'>SKIPPED</span>", "<pre>Skipped resetting the password for the user on QA becuase the boolean was set to false</pre>");
		} // end else
		
	} // end createNewSecureUserOnQA
		
	/**
	 * Reset password on beta.
	 *
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws AWTException the AWT exception
	 */
	@Test (priority=1)
	public synchronized void resetPasswordOnBeta() throws InterruptedException, IOException, AWTException {
		
		if (resetBeta == true)
		{
		
			RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
			
			/********************************************************************************
			 * 
			 * CREATE USER ON BETA
			 * 
			 ********************************************************************************/
			
			// Environment
			String env = "Beta";
			
			// Go to Beta Secure site
			driver.get("https://secure.mercuryvmpbeta.com/");
			
			// Create the user
			resetPassword(driver, env);
			
		}
			
		
		else
		{
			ExtentTest test = ExtentTestManager.getTest();
			// Skip test
			System.out.println("Skipped resetting the password for the user on Beta becuase the boolean was set to false");
			// Log a skip in the extent report
			test.log(LogStatus.SKIP, "<span class='label info'>SKIPPED</span>", "<pre>Skipped resetting the password for the user on Beta becuase the boolean was set to false</pre>");
		} // end else
		
	} // end createNewSecureUserOnBeta
		
	/**
	 * Reset password on live.
	 *
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws AWTException the AWT exception
	 */
	@Test (priority=2)
	public synchronized void resetPasswordOnLive() throws InterruptedException, IOException, AWTException {
		
		if (resetLive == true)
		{
		
			RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
			
			/********************************************************************************
			 * 
			 * CREATE USER ON LIVE
			 * 
			 ********************************************************************************/
			
			// Environment
			String env = "Live";
			
			// Go to Live Secure site
			driver.get("https://secure.mercuryvmp.com/");
			
			// Create the user
			resetPassword(driver, env);
			
		}
			
		
		else
		{
			ExtentTest test = ExtentTestManager.getTest();
			// Skip test
			System.out.println("Skipped resetting the password for the user on Live becuase the boolean was set to false");
			// Log a skip in the extent report
			test.log(LogStatus.SKIP, "<span class='label info'>SKIPPED</span>", "<pre>Skipped resetting the password for the user on Live becuase the boolean was set to false</pre>");
		} // end else
		
	}  // end createNewSecureUser
	
	/**
	 * Reset password.
	 *
	 * @param driver the driver
	 * @param env the env
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws AWTException the AWT exception
	 */
	public synchronized void resetPassword(RemoteWebDriver driver, String env) throws InterruptedException, IOException, AWTException {
			
		// Enter Email
		perform.type(driver, SLogin.email_txtbx(driver), "automation" + env + user + "@dntest.net");
		
		// Enter Password
		perform.type(driver, SLogin.password_txtbx(driver), password);
		
		// Click Sign In
		perform.click(driver, SLogin.signIn_btn(driver));
		
		// Wait for Find textbox
		perform.waitForElementToBeClickable(driver, SOrders.find_txtbx(driver));
		
		// Go to Users
		secure.goToUsers(driver);
		
		// Change the password 5 times
		for (int a = 1; a <=5; a++)
		{
			
			String pw = perform.randomLetters(driver, 10);
		
			// Wait for the Password Gear Icon
			perform.waitForElementToBeClickable(driver, SUsers.passwordGear_icon(driver));
			
			// Click the Password Gear icon
			perform.click(driver, SUsers.passwordGear_icon(driver));
			
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			// Wait for New
			perform.waitForElementToBeClickable(driver, SUsers.passwordSecurityOptions_txtbx(driver));
			
			// Enter New PW
			perform.type(driver, SUsers.passwordSecurityOptions_txtbx(driver), pw);
			
			// Confirm New PW
			perform.type(driver, SUsers.confirmPasswordSecurityOptions_txtbx(driver), pw);
			
			// Click Save
			perform.click(driver, SUsers.saveSecurityOptions_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
		
		} // end for loop
		
		// Change the password to T3sting1
		// Wait for the Password Gear Icon
		perform.waitForElementToBeClickable(driver, SUsers.passwordGear_icon(driver));
		
		// Click the Password Gear icon
		perform.click(driver, SUsers.passwordGear_icon(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for New
		perform.waitForElementToBeClickable(driver, SUsers.passwordSecurityOptions_txtbx(driver));
		
		// Enter New PW
		perform.type(driver, SUsers.passwordSecurityOptions_txtbx(driver), "T3sting1");
		
		// Confirm New PW
		perform.type(driver, SUsers.confirmPasswordSecurityOptions_txtbx(driver), "T3sting1");
		
		// Click Save
		perform.click(driver, SUsers.saveSecurityOptions_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Save the settings
		secure.saveUsersSettings(driver);
		
	} // end resetPassword
	
} // end ResetPasswordOnSecure
