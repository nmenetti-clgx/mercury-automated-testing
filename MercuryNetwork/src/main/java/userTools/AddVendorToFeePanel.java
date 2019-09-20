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
 * The Class AddVendorToFeePanel.
 */
public class AddVendorToFeePanel extends TestSetup {
	
	/** The user secure. */
	// Set user information
	private static String userSecure = "RegressionSecure17";
	
	/** The user vendors. */
	private static String userVendors = "TraineeAppraiser2";
	
	/** The vendors cust no. */
	private static String vendorsCustNo = "6345"; // This is the last 4 of the vendors customer number
	
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
	 * Adds the vendor to QA.
	 * @throws Exception the exception
	 */
	@Test (priority = 0)
	public synchronized void addVendorToQA() throws Exception {
	
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		if (qa == true)
		{
			
			/********************************************************************************
			 * 
			 * ADD VENDOR ON QA
			 * 
			 ********************************************************************************/
			
			String env = "QA";
			String phonePrefix = "501111";

			// Login to Secure
			secure.login(driver, userSecure, password, env);
			
			// Add Vendor to Fee Panel
			secure.addVendorToFeePanel(driver, "phone", phonePrefix+vendorsCustNo, userVendors);
			
		} // end if for boolean environment
		
		else
		{
			ExtentTest test = ExtentTestManager.getTest();
			// Skip test
			System.out.println("Skipped adding the vendor on QA becuase the boolean was set to false");
			// Log a skip in the extent report
			test.log(LogStatus.SKIP, "<span class='label info'>SKIPPED</span>", "<pre>Skipped adding the vendor on QA becuase the boolean was set to false</pre>");
		} // end else
		
	} // end addVendorToQA

	/**
	 * Adds the vendor to beta.
	 * @throws Exception the exception
	 */
	@Test (priority = 1)
	public synchronized void addVendorToBeta() throws Exception {
		
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		if (beta == true)
			
		{
		
			/********************************************************************************
			 * 
			 * ADD VENDOR ON BETA
			 * 
			 ********************************************************************************/
			
			String env = "Beta";
			String phonePrefix = "501222";

			// Login to Secure
			secure.login(driver, userSecure, password, env);
			
			// Add Vendor to Fee Panel
			secure.addVendorToFeePanel(driver, "phone", phonePrefix+vendorsCustNo, userVendors);
			
		} // end if for boolean environment
		
		else
		{
			ExtentTest test = ExtentTestManager.getTest();
			// Skip test
			System.out.println("Skipped adding the vendor on Beta becuase the boolean was set to false");
			// Log a skip in the extent report
			test.log(LogStatus.SKIP, "<span class='label info'>SKIPPED</span>", "<pre>Skipped adding the vendor on Beta becuase the boolean was set to false</pre>");
		} // end else
		
	} // end addVendorToBeta
	
	/**
	 * Adds the vendor to live.
	 * @throws Exception the exception
	 */
	@Test (priority = 2)
	public synchronized void addVendorToLive() throws Exception {
		
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		if (live == true)
			
		{
			
			/********************************************************************************
			 * 
			 * ADD VENDOR ON LIVE
			 * 
			 ********************************************************************************/
			
			String env = "Live";
			String phonePrefix = "501333";

			// Login to Secure
			secure.login(driver, userSecure, password, env);
			
			// Add Vendor to Fee Panel
			secure.addVendorToFeePanel(driver, "phone", phonePrefix+vendorsCustNo, userVendors);
			
		} // end if for boolean environment
		
		else
		{
			ExtentTest test = ExtentTestManager.getTest();
			// Skip test
			System.out.println("Skipped adding the vendor on Live becuase the boolean was set to false");
			// Log a skip in the extent report
			test.log(LogStatus.SKIP, "<span class='label info'>SKIPPED</span>", "<pre>Skipped adding the vendor on Live becuase the boolean was set to false</pre>");
		} // end else
		
	} // end addVendorToLive
	
} // end AddVendorToFeePanel
