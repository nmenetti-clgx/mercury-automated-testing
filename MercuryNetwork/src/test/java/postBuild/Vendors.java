package postBuild;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Post Build - Vendors</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class Vendors extends TestSetup {
	
	/** The user vendors. */
	private final String userVendors = "PostBuildAppraiser1";
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Go to Account</li>
	 * 	<li>Go to Users</li>
	 * 	<li>Go to Orders</li>
	 * 	<li>Log test</li>
* </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Vendors - Account", "Vendors - Users", "Vendors - Orders"}, alwaysRun=true)
	public void vendors() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		String password = StoredVariables.getpassword().get();
		
		// Log in to Vendors
		vendors.login(driver, userVendors, password);
		
		// Go to Account
		vendors.goToAccount(driver);
		
		// Go to Users
		vendors.goToUsers(driver);
		
		// Go to Orders
		vendors.goToOrders(driver);
			
		// Log test
		test.log(LogStatus.INFO, "Post-Build Vendors", "Verified vendors pages load");
		
	} // end vendors
	
} // end the Vendors class
