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
 * The Class SetFeesOnVendors.
 */
public class SetFeesOnVendors extends TestSetup {
	
	/** The user email address name. */
	// Set user information
	private static String userEmailAddressName = "StateRegulationAMC1"; // Not the full email address, just the users last name (This will be used to create the standardized email address)
	
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
	 * Sets the vendor fees on QA.
	 * @throws Exception the exception
	 */
	@Test
	public synchronized void setVendorFeesOnQA() throws Exception {
	
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		ExtentTest test = ExtentTestManager.getTest();
		
		if (qa == true)
		{
			
			String env = "QA";
			
			// Login to Vendors
			vendors.login(driver, userEmailAddressName, password, env);
			
			// Enter fees
			vendors.enterFees(driver);
		
		}
		
		else
		{
			
			// Skip test
			System.out.println("Skipped setting up the user on QA becuase the boolean was set to false");
			// Log a skip in the extent report
			test.log(LogStatus.SKIP, "<span class='label info'>SKIPPED</span>", "<pre>Skipped setting up the user on QA becuase the boolean was set to false</pre>");
		} // end else
		
	} // end setVendorFeesOnQA
		
	/**
	 * Sets the vendor fees on beta.
	 * @throws Exception the exception
	 */
	@Test
	public synchronized void setVendorFeesOnBeta() throws Exception {
		
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		ExtentTest test = ExtentTestManager.getTest();
		
		if (beta == true)
		{
			
			String env = "Beta";
			
			// Login to Vendors
			vendors.login(driver, userEmailAddressName, password, env);
			
			// Enter fees
			vendors.enterFees(driver);
			
		}
		
		else
		{
			
			// Skip test
			System.out.println("Skipped setting up the user on Beta becuase the boolean was set to false");
			// Log a skip in the extent report
			test.log(LogStatus.SKIP, "<span class='label info'>SKIPPED</span>", "<pre>Skipped setting up the user on QA becuase the boolean was set to false</pre>");
		} // end else
		
	} // end setVendorFeesOnBeta
		
	/**
	 * Sets the vendor fees on live.
	 * @throws Exception the exception
	 */
	@Test
	public synchronized void setVendorFeesOnLive() throws Exception {
		
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		ExtentTest test = ExtentTestManager.getTest();
		
		if (live == true)
		{
			
			String env = "Live";
			
			// Login to Vendors
			vendors.login(driver, userEmailAddressName, password, env);
			
			// Enter fees
			vendors.enterFees(driver);
			
		}
	
		else
		{
			
			// Skip test
			System.out.println("Skipped setting up the user on Live becuase the boolean was set to false");
			// Log a skip in the extent report
			test.log(LogStatus.SKIP, "<span class='label info'>SKIPPED</span>", "<pre>Skipped setting up the user on QA becuase the boolean was set to false</pre>");
		} // end else
		
	} // end setVendorFeesOnLive
	
} // end CreateSecureUser
