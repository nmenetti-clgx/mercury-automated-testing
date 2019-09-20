package userTools;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * The Class CreateVendorsSubUser.
 */
public class CreateVendorsSubUser extends TestSetup {
	
	/** The primary vendor. */
	// Set user information
	private static String primaryVendor = "TraineeAppraiser2"; // Not the full email address, just the users last name (This will be used to create the standardized email address)
	
	/** The sub user. */
	private static String subUser = "Trainee2SU2";
	
	/** The first name. */
	// User information fields that do not need to change
	private static String firstName = "Automation";
	
	/** The last name. */
	private static String lastName = subUser;
	
	/** The password. */
	private static String password = "T3sting1";
	
	/** The qa. */
	// Booleans to know which environment was run to determine which email text should be generated
	private static boolean qa = true;
	
	/** The beta. */
	private static boolean beta = true;
	
	/** The live. */
	private static boolean live = true;
	
	
	/**
	 * Creates the new vendor user on QA.
	 * @throws Exception the exception
	 */
	@Test (priority=1)
	public synchronized void createNewVendorUserOnQA() throws Exception {
		
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		if (qa == true)
		{
			
			/********************************************************************************
			 * 
			 * CREATE USER ON QA
			 * 
			 ********************************************************************************/
			
			String env = "QA";
			String email = "automation"+env+subUser+StoredVariables.getcatchAllDomain().get();

			// Log in to Vendors
			vendors.login(driver, primaryVendor, password, env);
			
			// Create sub user
			vendors.createSubUser(driver, true, email, password, firstName, lastName);
			
		} // end if for boolean environment
		
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
	 * Creates the new vendor user on beta.
	 * @throws Exception the exception
	 */
	@Test (priority=2)
	public synchronized void createNewVendorUserOnBeta() throws Exception {
		
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		if (beta == true)
		{
			
			/********************************************************************************
			 * 
			 * CREATE USER ON BETA
			 * 
			 ********************************************************************************/
			
			String env = "Beta";
			String email = "automation"+env+subUser+StoredVariables.getcatchAllDomain().get();
			
			// Log in to Vendors
			vendors.login(driver, primaryVendor, password, env);
			
			// Create sub user
			vendors.createSubUser(driver, true, email, password, firstName, lastName);

		} // end if for boolean environment
		
		else
		{
			ExtentTest test = ExtentTestManager.getTest();
			// Skip test
			System.out.println("Skipped setting up the user on QA becuase the boolean was set to false");
			// Log a skip in the extent report
			test.log(LogStatus.SKIP, "<span class='label info'>SKIPPED</span>", "<pre>Skipped setting up the user on QA becuase the boolean was set to false</pre>");
		} // end else
		
	} // end createNewSecureUserOnBeta
		
	/**
	 * Creates the new vendor user on live.
	 * @throws Exception the exception
	 */
	@Test (priority=3)
	public synchronized void createNewVendorUserOnLive() throws Exception {
		
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		if (live == true)
		{
			
			/********************************************************************************
			 * 
			 * CREATE USER ON LIVE
			 * 
			 ********************************************************************************/
			
			String env = "Live";
			String email = "automation"+env+subUser+StoredVariables.getcatchAllDomain().get();
				
			// Log in to Vendors
			vendors.login(driver, primaryVendor, password, env);
			
			// Create sub user
			vendors.createSubUser(driver, true, email, password, firstName, lastName);

		} // end if for boolean environment
	
		else
		{
			ExtentTest test = ExtentTestManager.getTest();
			// Skip test
			System.out.println("Skipped setting up the user on QA becuase the boolean was set to false");
			// Log a skip in the extent report
			test.log(LogStatus.SKIP, "<span class='label info'>SKIPPED</span>", "<pre>Skipped setting up the user on QA becuase the boolean was set to false</pre>");
		} // end else
		
	} // end createNewSecureUserOnLive
		
} // end CreateSecureUser
