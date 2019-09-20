package baselineSecure;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Secure.SChatAndTutorials;
import pageObjects.Secure.SContactSupport;
import pageObjects.Secure.SLogin;
import pageObjects.Secure.SOrders;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Baseline Secure - Home</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class Secure_Home extends TestSetup {
	
	/** The user. */
	private static String user = "Baseline1";
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Click the help link</li>
	 * 	<li>Switch to the new window</li>
	 * 	<li>Verify url</li>
	 * 	<li>Assert.assertTrue(driver.getCurrentUrl().equals("https:help.mercuryvmp.com/amc/vmpxsites/"), "The url is incorrect");</li>
	 * 	<li>close the window</li>
	 * 	<li>Click the Contact Support link</li>
	 * 	<li>switch into iFrame</li>
	 * 	<li>Get text from Contact Support dialog</li>
	 * 	<li>Verify Contact Support dialog text</li>
	 * 	<li>Close the dialog</li>
	 * 	<li>Click the help link</li>
	 * 	<li>Switch to the new window</li>
	 * 	<li>Verify url</li>
	 * 	<li>Assert.assertTrue(driver.getCurrentUrl().equals("http:www.mercuryvmp.com/workflowgeeks"), "The url is incorrect. It is " + driver.getCurrentUrl() + " and should be http:www.mercuryvmp.com/workflowgeeks");</li>
	 * 	<li>close the window</li>
	 * 	<li>Click the help link</li>
	 * 	<li>Switch to the new window</li>
	 * 	<li>Verify url</li>
	 * 	<li>close the window</li>
	 * 	<li>Go to Orders</li>
	 * 	<li>Click Chat and Tutorials button</li>
	 * 	<li>Verify Chat With Us button is displayed</li>
	 * 	<li>Click the Sign Out link</li>
	 * 	<li>Verify the Sign In button is displayed</li>
	 * 	<li>Verify url</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Help", "Secure - Sign Out", "Secure - Orders"}, alwaysRun=true)
	public void home() throws Exception {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Login to Secure
		secure.login(driver, user, StoredVariables.getpassword().get());
		
		// Click the help link
		perform.click(driver, driver.findElement(By.linkText("Help")));;
		
		// Switch to the new window
		perform.switchToXSiteWindowByTitle(driver, "VMP XSites User's Guide");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().equals("https://help.mercuryvmp.com/amc/vmpxsites/"), "The url is incorrect");
		
		// close the window
		perform.closeNewWindow(driver);
		
		// Click the Contact Support link
		perform.click(driver, driver.findElement(By.linkText("Contact Support")));;
		
		// switch into iFrame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "/ContactSupport.aspx", By.id(SContactSupport.send_btn()));
		
		// Wait for Send button
		perform.waitForElementToBeClickable(driver, SContactSupport.send_btn(), "id");
		
		// Get text from Contact Support dialog
		String text = SContactSupport.contactSupportPage_txt(driver).getText();
		
		// Verify Contact Support dialog text
		Assert.assertTrue(text.contains("Contact support"), "The Contact Support dialog text is incorrect");
		Assert.assertTrue(text.contains("Contact information"), "The Contact Support dialog text is incorrect");
		Assert.assertTrue(text.contains("Send us your question and we'll get back with you shortly."), "The Contact Support dialog text is incorrect");
		Assert.assertTrue(text.contains("www.workflowgeeks.com"), "The Contact Support dialog text is incorrect");
		
		// Close the dialog
		perform.click(driver, SContactSupport.close_btn(driver));
		
		// Switch out of iFrame
		driver.switchTo().defaultContent();
		
		// Click the help link
		perform.click(driver, driver.findElement(By.linkText("What's New")));;
		
		// Switch to the new window
		perform.switchToXSiteWindowByTitle(driver, "WorkflowGeeks");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().equals("https://www.mercuryvmp.com/workflowgeeks"), "The url is incorrect. It is " + driver.getCurrentUrl() + " and should be https://www.mercuryvmp.com/workflowgeeks");
		
		// close the window
		perform.closeNewWindow(driver);
		
		// Click the help link
		perform.click(driver, driver.findElement(By.linkText("Terms of Use")));;
		
		// Switch to the new window
		perform.switchToXSiteWindowByTitle(driver, "Terms of Use");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().contains("/TOU.htm"), "The url is incorrect");
		
		// close the window
		perform.closeNewWindow(driver);
		
		// Go to Orders
		secure.goToOrders(driver);
		
		if (StoredVariables.getmobile().get()==false) {

			// Click Chat and Tutorials button
			perform.click(driver, SOrders.chatAndTutorials_btn(driver));
			
			// Wait for the Chat with us button
			perform.waitForElementToBeClickable(driver, SChatAndTutorials.chatWithUs_btn(), "cssSelector");
			
			// Verify Chat With Us button is displayed
			Assert.assertTrue(SChatAndTutorials.chatWithUs_btn(driver).isDisplayed(), "The Chat With Us button is displayed");
			
		} // end if
		
		// Click the Sign Out link
		perform.click(driver, driver.findElement(By.linkText("Sign Out")));
		
		// Wait for Email textbox
		perform.waitForElementToBeClickable(driver, SLogin.email_txtbx(), "id");
		
		// Verify the Sign In button is displayed
		Assert.assertTrue(SLogin.signIn_btn(driver).isDisplayed(), "The Sign In button is not displayed");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().equals(StoredVariables.getsecureSite().get()+"/"), "The url is incorrect");
		
		// Log test
		test.log(LogStatus.INFO, "home", "The Help link opened the correct url");
		
	} // end home
	
} // end the Secure_Login class
