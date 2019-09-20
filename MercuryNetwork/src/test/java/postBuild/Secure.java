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
 * <h1>Post Build - Secure</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class Secure extends TestSetup {
	
	/** The user secure. */
	private final String userSecure = "PostBuild1";
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Go to DataCourier</li>
	 * 	<li>Go to Account</li>
	 * 	<li>Go to Orders</li>
	 * 	<li>Go to Fee Panel</li>
	 * 	<li>Go to Clients</li>
	 * 	<li>Go to Users</li>
	 * 	<li>Go to Completed</li>
	 * 	<li>Go to In Progress</li>
	 * 	<li>Go to New Requests</li>
	 * 	<li>Go to Fee Panel</li>
	 * 	<li>Go to Work In Progress</li>
	 * 	<li>Go to Vendor Selection Settings</li>
	 * 	<li>Go to Product Requirements</li>
	 * 	<li>Go to Connection Settings</li>
	 * 	<li>Go to Appraisal Quality Management Settings</li>
	 * 	<li>Go to VMP XSites</li>
	 * 	<li>Log test</li>
* </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - DataCourier", "Secure - Account", "Secure - Orders", "Secure - Fee Panel", "Secure - Clients", "Secure - Users", "Secure - Reports",
			"Secure - Vendor Selection Settings", "Secure - Product Requirements", "Secure - Connection Settings", "Secure - Appraisal Quality Management Settings", "Secure - VMP XSite Settings"}, alwaysRun=true)
	public void secure() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		String password = StoredVariables.getpassword().get();
		
		// Log in to Secure
		secure.login(driver, userSecure, password);
		
		// Go to DataCourier
		secure.goToDataCourier(driver);
		
		// Go to Account
		secure.goToAccount(driver);
		
		// Go to Orders
		secure.goToOrders(driver);
		
		// Go to Fee Panel
		secure.goToFeePanel(driver);
		
		// Go to Clients
		secure.goToClients(driver);
		
		// Go to Users
		secure.goToUsers(driver);
		
		// Go to Completed
		secure.goToCompletedReports(driver);
		
		// Go to In Progress
		secure.goToInProgressReports(driver);
		
		// Go to New Requests
		secure.goToNewRequestsReports(driver);
		
		// Go to Fee Panel
		secure.goToFeePanelReports(driver);
		
		// Go to Work In Progress
		secure.goToWorkInProgressReports(driver);
		
		// Go to Vendor Selection Settings
		secure.goToVendorSelectionSettings(driver);
		
		// Go to Product Requirements
		secure.goToProductRequirements(driver);

		// Go to Connection Settings
		secure.goToConnectionSettings(driver);
		
		// Go to Appraisal Quality Management Settings
		secure.goToAppraisalQualityManagementSettings(driver);
		
		// Go to VMP XSites
		secure.goToVMPXSites(driver);
			
		// Log test
		test.log(LogStatus.INFO, "Post-Build Secure", "Verified pages load in Secure");
		
	} // end secure
	
} // end the Secure class
