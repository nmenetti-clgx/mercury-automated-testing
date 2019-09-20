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
 * The Class EnableAllProductsForSecureUser.
 */
public class EnableAllProductsForSecureUser extends TestSetup {
	
	/** The user. */
	// Set user information
	private final String user = "RegressionSecure20"; // Not the full email address, just the users last name (This will be used to create the standardized email address)
	
	/** The password. */
	private final String password = "T3sting1";
	
	/** The created QA. */
	// Booleans to choose which environment to enable products for
	private static boolean createdQA = true;
	
	/** The created beta. */
	private static boolean createdBeta = true;
	
	/** The created live. */
	private static boolean createdLive = true;
	
	/**
	 * Creates the new secure user on QA.
	 * @throws Exception the exception
	 */
	@Test (priority=0)
	public synchronized void createNewSecureUserOnQA() throws Exception {
	
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		if (createdQA == true)
		{
		
			// Environment
			String env = "QA";
			
			// Set secure site url
			StoredVariables.getsecureSite().set(perform.getSecureSite(env));
			
			// Login to Secure
			secure.login(driver, user, password, env);
			
			// Enable all products
			secure.enableAllProducts(driver);
			
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
	 * Creates the new secure user on beta.
	 * @throws Exception the exception
	 */
	@Test (priority=1)
	public synchronized void createNewSecureUserOnBeta() throws Exception {
		
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		if (createdBeta == true)
		{
		
			// Environment
			String env = "Beta";
			
			// Set secure site url
			StoredVariables.getsecureSite().set(perform.getSecureSite(env));
			
			// Login to Secure
			secure.login(driver, user, password, env);
			
			// Enable all products
			secure.enableAllProducts(driver);
		
		} // end createdBeta
		
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
	 * Creates the new secure user on live.
	 * @throws Exception the exception
	 */
	@Test (priority=2)
	public synchronized void createNewSecureUserOnLive() throws Exception {
		
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		if (createdLive == true)
		{
		
			// Environment
			String env = "Live";
			
			// Set secure site url
			StoredVariables.getsecureSite().set(perform.getSecureSite(env));
			
			// Login to Secure
			secure.login(driver, user, password, env);
			
			// Enable all products
			secure.enableAllProducts(driver);
		
		} // end createdLive
		
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
