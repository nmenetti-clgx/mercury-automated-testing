package baselineSecure;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Secure.SReports;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Baseline Secure - Reports</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class Secure_Reports extends TestSetup {
	
	/** The user. */
	private static String user = "Baseline1";
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to secure</li>
	 * 	<li>Go to Completed</li>
	 * 	<li>Verify header text</li>
	 * 	<li>Go to In Progress</li>
	 * 	<li>Verify header text</li>
	 * 	<li>Go to New Requests</li>
	 * 	<li>Verify header text</li>
	 * 	<li>Go to Fee Panel</li>
	 * 	<li>Verify header text</li>
	 * 	<li>Go to Work In Progress</li>
	 * 	<li>Verify header text</li>
	 * 	<li>Log test</li>
	 * </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Reports", "Secure - Reports - Completed", "Secure - Reports - In Progress", "Secure - Reports - New Requests", "Secure - Reports - Fee Panel", "Secure - Reports - Work In Progress"}, alwaysRun=true)
	public void reports() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Login to secure
		secure.login(driver, user, StoredVariables.getpassword().get());
		
		// Go to Completed
		secure.goToCompletedReports(driver);
		
		// Verify header text
		Assert.assertTrue(SReports.header_txt(driver).getText().contains("Completed Orders for"), "The header text is incorrect");
		
		// Go to In Progress
		secure.goToInProgressReports(driver);
		
		// Verify header text
		Assert.assertTrue(SReports.header_txt(driver).getText().contains("Orders In Progress for"), "The header text is incorrect");
		
		// Go to New Requests
		secure.goToNewRequestsReports(driver);
		
		// Verify header text
		Assert.assertTrue(SReports.header_txt(driver).getText().contains("Orders Pending Acceptance for"), "The header text is incorrect");
		
		// Go to Fee Panel
		secure.goToFeePanelReports(driver);
		
		// Verify header text
		Assert.assertTrue(SReports.header_txt(driver).getText().contains("Vendor Fee Panel"), "The header text is incorrect");
		
		// Go to Work In Progress
		secure.goToWorkInProgressReports(driver);
		
		// Verify header text
		Assert.assertTrue(SReports.header_txt(driver).getText().contains("Work In Progress for"), "The header text is incorrect");
		
		// Log test
		test.log(LogStatus.INFO, "reports", "Verified the Reports screens loads");
		
	} // end reports
	
} // end the Secure_Login class
