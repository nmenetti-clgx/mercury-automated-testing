package userTools;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;

// TODO: Auto-generated Javadoc
/**
 * The Class SetFeesOnSecure.
 */
public class SetFeesOnSecure extends TestSetup {
		
	/** The user email address name. */
	// Set user information
	private static String userEmailAddressName = "Payments2"; // Not the full email address, just user last name (This will be used to create the standardized email address)
	
	/** The password. */
	private static String password = "T3sting1";
	
	/** The qa. */
	// Booleans to know which environment was run to determine which email text should be generated
	private static boolean qa = false;
	
	/** The beta. */
	private static boolean beta = false;
	
	/** The live. */
	private static boolean live = true;
	
	/**
	 * Sets the fees on secure QA.
	 * @throws Exception the exception
	 */
	@Test (priority = 0)
	public synchronized void setFeesOnSecureQA() throws Exception {
		
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		if (qa == true)
		{
			
			String env = "QA";
			secure.login(driver, userEmailAddressName, password, env);
			secure.enterProductFees(driver, "500");
			
		} // end if for boolean environment
		
		else
		{
			ExtentTest test = ExtentTestManager.getTest();
			// Skip test
			System.out.println("Skipped setting up the user on QA becuase the boolean was set to false");
			// Log a skip in the extent report
			test.log(LogStatus.SKIP, "<span class='label info'>SKIPPED</span>", "<pre>Skipped setting up the user on QA becuase the boolean was set to false</pre>");
		} // end else
		
	} // end firstSignInOnSecureQA

	/**
	 * Sets the fees on secure beta.
	 * @throws Exception the exception
	 */
	@Test (priority = 1, dependsOnMethods = {"setFeesOnSecureQA"})
	public synchronized void setFeesOnSecureBeta() throws Exception {
		
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		if (beta == true)
			
		{
		
			String env = "Beta";
			secure.login(driver, userEmailAddressName, password, env);
			secure.enterProductFees(driver, "500");
			
		} // end if for boolean environment
		
		else
		{
			ExtentTest test = ExtentTestManager.getTest();
			// Skip test
			System.out.println("Skipped setting up the user on Beta becuase the boolean was set to false");
			// Log a skip in the extent report
			test.log(LogStatus.SKIP, "<span class='label info'>SKIPPED</span>", "<pre>Skipped setting up the user on Beta becuase the boolean was set to false</pre>");
		} // end else
		
	} // end firstSignInOnSecureBeta
	
	/**
	 * Sets the fees on secure live.
	 * @throws Exception the exception
	 */
	@Test (priority = 2, dependsOnMethods = {"setFeesOnSecureBeta"})
	public synchronized void setFeesOnSecureLive() throws Exception {
		
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		if (live == true)
			
		{
			
			String env = "Live";
			secure.login(driver, userEmailAddressName, password, env);
			secure.enterProductFees(driver, "500");
			
		} // end if for boolean environment
		
		else
		{
			ExtentTest test = ExtentTestManager.getTest();
			// Skip test
			System.out.println("Skipped setting up the user on Live becuase the boolean was set to false");
			// Log a skip in the extent report
			test.log(LogStatus.SKIP, "<span class='label info'>SKIPPED</span>", "<pre>Skipped setting up the user on Live becuase the boolean was set to false</pre>");
		} // end else
		
	} // end firstSignInOnSecureLive
	
} // end FirstLoginSecureUser
