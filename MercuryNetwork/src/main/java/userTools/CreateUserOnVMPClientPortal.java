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
 * The Class CreateUserOnVMPClientPortal.
 */
public class CreateUserOnVMPClientPortal extends TestSetup {
	
		
	/** The user created for. */
	// Set user information
	private static String userCreatedFor = "ResBidding4"; // username of the user the VMP account is being created for (ex. VMP3)
	
	/** The new user name. */
	private static String newUserName = "Originator" + userCreatedFor; // username of the VMP Client user
	
	/** The account number. */
	private static String accountNumber = "9231"; // last 4 digits of the new phone number
	
	/** The password. */
	private static String password = "T3sting1";
	
	/** The payments URL. */
	// Set to true for payments users only!!!
	private static boolean paymentsURL = false;

	/** The qa. */
	// Set environment to run setup on
	private static boolean qa = true;
	
	/** The beta. */
	private static boolean beta = true;
	
	/** The live. */
	private static boolean live = true;
	
	/**
	 * Creates the VMP user on QA.
	 * @throws Exception the exception
	 */
	@Test (priority = 0)
	public synchronized void createVMPUserOnQA() throws Exception {
	
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		ExtentTest test = ExtentTestManager.getTest();
		
		if (qa == true)
		{
			
			/********************************************************************************
			 * 
			 * CREATE USER ON QA VMP CLIENT PORTAL
			 * 
			 ********************************************************************************/
			
			String env = "QA";
			String url = "https://"+env+"AutoTest"+userCreatedFor+".vmpclient"+env+".com";
			// Go to QA VMP Client Portal site
			if (paymentsURL==true) {
				driver.get(url);
			} else {
				driver.get("https://automationQA" + userCreatedFor + ".vmpclientqa.com");
			}
			
			vmp.createVMPUser(driver, env, newUserName, password, accountNumber);
			
			// Update the SMS number as bad
			String phoneNumber = "501111" + accountNumber;
			db.markSMSNumberAsBad(driver, env, phoneNumber);
			
		} // end if for boolean environment
		
		else
		{
			// Skip test
			System.out.println("Skipped creating the user on QA becuase the boolean was set to false");
			// Log a skip in the extent report
			test.log(LogStatus.SKIP, "<span class='label info'>SKIPPED</span>", "<pre>Skipped creating the user on QA becuase the boolean was set to false</pre>");
		} // end else
		
	} // end createVMPUserOnQA

	/**
	 * Creates the VMP user on beta.
	 * @throws Exception the exception
	 */
	@Test (priority = 1, dependsOnMethods = {"createVMPUserOnQA"})
	public synchronized void createVMPUserOnBeta() throws Exception {
		
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		ExtentTest test = ExtentTestManager.getTest();
		
		if (beta == true)
			
		{
		
			/********************************************************************************
			 * 
			 * CREATE USER ON BETA VMP CLIENT PORTAL
			 * 
			 ********************************************************************************/
			
			String env = "Beta";
			String url = "https://"+env+"AutoTest"+userCreatedFor+".vmpclient"+env+".com";
			// Go to QA VMP Client Portal site
			if (paymentsURL==true) {
				driver.get(url);
			} else {
			// Go to QA VMP Client Portal site
			driver.get("https://automationBeta" + userCreatedFor + ".vmpclientbeta.com");
			}
			
			vmp.createVMPUser(driver, env, newUserName, password, accountNumber);
			
			// Update the SMS number as bad
			String phoneNumber = "501222" + accountNumber;
			db.markSMSNumberAsBad(driver, env, phoneNumber);
			
		} // end if for boolean environment
		
		else
		{
			// Skip test
			System.out.println("Skipped creating the user on Beta becuase the boolean was set to false");
			// Log a skip in the extent report
			test.log(LogStatus.SKIP, "<span class='label info'>SKIPPED</span>", "<pre>Skipped creating the user on Beta becuase the boolean was set to false</pre>");
		} // end else
		
	} // end createVMPUserOnBeta
	
	/**
	 * Creates the VMP user on live.
	 * @throws Exception the exception
	 */
	@Test (priority = 2, dependsOnMethods = {"createVMPUserOnBeta"})
	public synchronized void createVMPUserOnLive() throws Exception {
		
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		ExtentTest test = ExtentTestManager.getTest();
		
		if (live == true)
			
		{
			
			/********************************************************************************
			 * 
			 * CREATE USER ON LIVE VMP CLIENT PORTAL
			 * 
			 ********************************************************************************/
			
			String env = "Live";
			String url = "https://"+env+"AutoTest"+userCreatedFor+".vmpclient"+env+".com";
			// Go to QA VMP Client Portal site
			if (paymentsURL==true) {
				driver.get(url);
			} else {
			// Go to QA VMP Client Portal site
			driver.get("https://automationLive" + userCreatedFor + ".vmpclient.com");
			}
			
			vmp.createVMPUser(driver, env, newUserName, password, accountNumber);
			
			// Update the SMS number as bad
			String phoneNumber = "501333" + accountNumber;
			db.markSMSNumberAsBad(driver, env, phoneNumber);
			
		} // end if for boolean environment
		
		else
		{
			// Skip test
			System.out.println("Skipped creating the user on Live becuase the boolean was set to false");
			// Log a skip in the extent report
			test.log(LogStatus.SKIP, "<span class='label info'>SKIPPED</span>", "<pre>Skipped creating the user on Live becuase the boolean was set to false</pre>");
		} // end else
		
	} // end createVMPUserOnLive
	
} // end CreateUserOnVMPClientPortal
