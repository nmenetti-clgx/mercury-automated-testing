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
 * <h1>Post Build - VMP</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class VMP extends TestSetup {
	
	/** The user secure. */
	private final String userSecure = "PostBuild1";
	
	/** The user VMP. */
	private final String userVMP = "OriginatorPostBuild1";
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to the VMP Client portal and sign in</li>
	 * 	<li>Go to Profile</li>
	 * 	<li>Go to Orders</li>
	 * 	<li>Log test</li>
* </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"VMP - Profile", "VMP - Orders"}, alwaysRun=true)
	public void vmp() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		String password = StoredVariables.getpassword().get();
		
		// Go to the VMP Client portal and sign in
		vmp.login(driver, userSecure, userVMP, password);
		
		// Go to Profile
		vmp.goToProfile(driver);
		
		// Go to Orders
		vmp.goToOrders(driver);
			
		// Log test
		test.log(LogStatus.INFO, "Post-Build VMP", "Verified VMP Client pages load");
		
	} // end vmp
	
} // end the VMP class
