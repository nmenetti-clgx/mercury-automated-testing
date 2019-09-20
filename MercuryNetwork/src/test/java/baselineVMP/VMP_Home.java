package baselineVMP;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.VMP.VMPLogin;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Baseline VMP - Home</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class VMP_Home extends TestSetup {
	
	/** The user. */
	private final String user = "EVFLender2";
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to VMP Client Portal</li>
	 * 	<li>Click the help link</li>
	 * 	<li>Switch to the new window</li>
	 * 	<li>Verify url</li>
	 * 	<li>Assert.assertTrue(driver.getCurrentUrl().equals("https:help.mercuryvmp.com/VMPClientPortal/"), "The url is incorrect");</li>
	 * 	<li>close the window</li>
	 * 	<li>Click the help link</li>
	 * 	<li>Switch to the new window</li>
	 * 	<li>Verify url</li>
	 * 	<li>close the window</li>
	 * 	<li>Click the Sign Out link</li>
	 * 	<li>Verify the Sign In button is displayed</li>
	 * 	<li>Verify url</li>
	 * 	<li>Log test</li>
* </ul>
	 *
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws SQLException the SQLException
	 * @throws ClassNotFoundException the ClassNotFoundException
	 */
	@Test (retryAnalyzer = Retry.class, groups={"VMP - Help", "VMP - Sign Out"}, alwaysRun=true)
	public void home() throws InterruptedException, IOException, ClassNotFoundException, SQLException {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Login to VMP Client Portal
		vmp.login(driver, user, "Originator"+user, StoredVariables.getpassword().get());
		
		// Click the help link
		perform.click(driver,driver.findElement(By.linkText("Help")));;
		
		// Switch to the new window
		perform.switchToXSiteWindowByTitle(driver, "VMP Client Portal User's Guide");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().equals("https://help.mercuryvmp.com/VMPClientPortal/"), "The url is incorrect");
		
		// close the window
		perform.closeNewWindow(driver);
		
		// Click the help link
		perform.click(driver,driver.findElement(By.linkText("Terms of Use")));;
		
		// Switch to the new window
		perform.switchToXSiteWindowByTitle(driver, "Terms of Use");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().contains("/TOU.htm"), "The url is incorrect");
		
		// close the window
		perform.closeNewWindow(driver);
		
		// Click the Sign Out link
		perform.click(driver,driver.findElement(By.linkText("Sign Out")));
		
		// Wait for Email textbox
		perform.waitForElementToBeClickable(driver, VMPLogin.email_txtbx(), "id");
		
		// Verify the Sign In button is displayed
		Assert.assertTrue(VMPLogin.signIn_btn(driver).isDisplayed(), "The Sign In button is not displayed");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().contains("SignIn.aspx"), "The url is incorrect");
		
		// Log test
		test.log(LogStatus.INFO, "home", "The Help link opened the correct url");
		
	} // end home
	
} // end the Secure_Login class
