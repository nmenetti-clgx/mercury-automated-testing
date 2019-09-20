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
 * The Class CreateVendorsUser.
 */
public class CreateVendorsUser extends TestSetup {
	
	/** The user email address name. */
	// Set user information
	private static String userEmailAddressName = "BaselineAppraiser3"; // Not the full email address, just the users last name (This will be used to create the standardized email address)
	
	/** The last 4 digits of phone number. */
	private static String last4digitsOfPhoneNumber = "2003"; // Used for account number
	
	/** The type of account. */
	private static String typeOfAccount = "Appraiser Office (less than 10)"; // Appraiser Office (less than 10), Appraisal Management Company / Appraisal Firm, Inspector, Real Estate Agent

/** The type. */
//	private static String typeOfAccount = "Appraisal Management Company / Appraisal Firm"; // Appraiser Office (less than 10), Appraisal Management Company / Appraisal Firm, Inspector, Real Estate Agent
		private static String type = "AMC"; // Used if Appraisal Management Company / Appraisal Firm = AMC, Firm
	
	/** The state. */
	// User information fields that do not need to change
	private static String state = "Oklahoma"; // spelled out
	
	/** The company. */
	private static String company = "Automation Company"; // Leave empty if you want an auto-generated company
	
	/** The first name. */
	private static String firstName = "Automation";
	
	/** The last name. */
	private static String lastName = userEmailAddressName;
	
	/** The cell phone. */
	private static String cellPhone = "405555"+last4digitsOfPhoneNumber;
	
	/** The address. */
	private static String address = "501D NE 122nd St";
	
	/** The city. */
	private static String city = "Oklahoma City";
	
	/** The zip. */
	private static String zip = "73114";
	
	/** The appraisal volume per month. */
	private static String appraisalVolumePerMonth = "Less than 10";
	
	/** The time zone. */
	private static String timeZone = "Central";
	
	/** The how did you hear about us. */
	private static String howDidYouHearAboutUs = "Client";
	
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
	@Test
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
			String phonePrefix = "501111";
			StoredVariables.getvendorsSite().set(perform.getVendorsSite(env));
				
			// Sign up new user
			vendors.signupNewVendorsUser(driver, env, userEmailAddressName, password, phonePrefix+last4digitsOfPhoneNumber, typeOfAccount, state, company, firstName, lastName, cellPhone, address, city, zip, appraisalVolumePerMonth, type, timeZone, howDidYouHearAboutUs);
			
			// Login to Vendors as the new vendor
			vendors.login(driver, userEmailAddressName, password, env);
			
			// Go to Users
			vendors.goToUsers(driver);
			
			// Set up user
			vendors.setDefaultVendorsSettings(driver, typeOfAccount, timeZone);
			
			// Sign out
			vendors.signOut(driver);
			
			// Update the SMS number as bad
			String phoneNumber = "501111" + last4digitsOfPhoneNumber;
			db.markSMSNumberAsBad(driver, env, phoneNumber);
		
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
	@Test
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
			String phonePrefix = "501222";
			StoredVariables.getvendorsSite().set(perform.getVendorsSite(env));
				
			// Sign up new user
			vendors.signupNewVendorsUser(driver, env, userEmailAddressName, password, phonePrefix+last4digitsOfPhoneNumber, typeOfAccount, state, company, firstName, lastName, cellPhone, address, city, zip, appraisalVolumePerMonth, type, timeZone, howDidYouHearAboutUs);
			
			// Login to Vendors as the new vendor
			vendors.login(driver, userEmailAddressName, password, env);
			
			// Go to Users
			vendors.goToUsers(driver);
			
			// Set up user
			vendors.setDefaultVendorsSettings(driver, typeOfAccount, timeZone);
			
			// Sign out
			vendors.signOut(driver);
			
			// Update the SMS number as bad
			String phoneNumber = "501222" + last4digitsOfPhoneNumber;
			db.markSMSNumberAsBad(driver, env, phoneNumber);

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
	@Test
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
			String phonePrefix = "501333";
			StoredVariables.getvendorsSite().set(perform.getVendorsSite(env));
				
			// Sign up new user
			vendors.signupNewVendorsUser(driver, env, userEmailAddressName, password, phonePrefix+last4digitsOfPhoneNumber, typeOfAccount, state, company, firstName, lastName, cellPhone, address, city, zip, appraisalVolumePerMonth, type, timeZone, howDidYouHearAboutUs);
			
			// Login to Vendors as the new vendor
			vendors.login(driver, userEmailAddressName, password, env);
			
			// Go to Users
			vendors.goToUsers(driver);
			
			// Set up user
			vendors.setDefaultVendorsSettings(driver, typeOfAccount, timeZone);
			
			// Sign out
			vendors.signOut(driver);
			
			// Update the SMS number as bad
			String phoneNumber = "501333" + last4digitsOfPhoneNumber;
			db.markSMSNumberAsBad(driver, env, phoneNumber);

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
