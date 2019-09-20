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
 * The Class CreateSecureSubUser.
 */
public class CreateSecureSubUser extends TestSetup {
	
	/** The user email address name. */
	// Set user information
	private static String userEmailAddressName = "ResBidding2"; // Not the full email address, just the users last name you are creating the subuser for (This will be used to create the standardized email address)
	
	/** The password. */
	private static String password = "T3sting1";
	
	/** The created QA. */
	// Booleans to know which environment was run to determine which email text should be generated
	private static boolean createdQA = false;
	
	/** The created beta. */
	private static boolean createdBeta = true;
	
	/** The created live. */
	private static boolean createdLive = true;
	
	/**
	 * Creates the new secure sub user on QA.
	 * @throws Exception the exception
	 */
	@Test
	public synchronized void createNewSecureSubUserOnQA() throws Exception {
	
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		if (createdQA == true)
		{
		
			/********************************************************************************
			 * 
			 * CREATE USER ON QA
			 * 
			 ********************************************************************************/
			
			String env = "QA";
			secure.createSubUser(driver, env, userEmailAddressName, password);
			
			createdQA = true;
		
		} // end createdQA
		
		else
		{
			ExtentTest test = ExtentTestManager.getTest();
			// Skip test
			System.out.println("Skipped setting up the user on QA becuase the boolean was set to false");
			// Log a skip in the extent report
			test.log(LogStatus.SKIP, "<span class='label info'>SKIPPED</span>", "<pre>Skipped setting up the user on QA becuase the boolean was set to false</pre>");
		} // end else
		
	} // end createNewSecureUserOnQA
		
	/**
	 * Creates the new secure sub user on beta.
	 * @throws Exception 
	 */
	@Test
	public synchronized void createNewSecureSubUserOnBeta() throws Exception {
		
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		if (createdBeta == true)
		{
		
			/********************************************************************************
			 * 
			 * CREATE USER ON BETA
			 * 
			 ********************************************************************************/
			
			String env = "Beta";
			secure.createSubUser(driver, env, userEmailAddressName, password);
			
			createdBeta = true;
		
		}
		
		else
		{
			ExtentTest test = ExtentTestManager.getTest();
			// Skip test
			System.out.println("Skipped setting up the user on Beta becuase the boolean was set to false");
			// Log a skip in the extent report
			test.log(LogStatus.SKIP, "<span class='label info'>SKIPPED</span>", "<pre>Skipped setting up the user on Beta becuase the boolean was set to false</pre>");
		} // end else
		
	} // end createNewSecureUserOnBeta
		
	/**
	 * Creates the new secure sub user on live.
	 * @throws Exception the exception
	 */
	@Test
	public synchronized void createNewSecureSubUserOnLive() throws Exception {
		
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		if (createdLive == true)
		{
		
			/********************************************************************************
			 * 
			 * CREATE USER ON LIVE
			 * 
			 ********************************************************************************/
			
			String env = "Live";
			secure.createSubUser(driver, env, userEmailAddressName, password);
			
			createdLive = true;
		
		}
		
		else
		{
			ExtentTest test = ExtentTestManager.getTest();
			// Skip test
			System.out.println("Skipped setting up the user on Live becuase the boolean was set to false");
			// Log a skip in the extent report
			test.log(LogStatus.SKIP, "<span class='label info'>SKIPPED</span>", "<pre>Skipped setting up the user on Live becuase the boolean was set to false</pre>");
		} // end else
		
	} // end createNewSecureUserOnLive
		
} // end CreateSecureUser
