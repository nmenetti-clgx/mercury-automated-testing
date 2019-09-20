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
 * The Class CreateSecureUser.
 */
public class CreateSecureUser extends TestSetup {
	
	/** The user email address name. */
	// Set user information
	private static String userEmailAddressName = "Secure1"; // Not the full email address, just the users last name (This will be used to create the standardized email address)
	
	/** The last 4 digits of phone number. */
	private static String last4digitsOfPhoneNumber = "4550"; // Used for account number
	
	/** The amc. */
	// User information fields that do not need to change
	boolean amc = false;

	/** The type of account. */
	private static String typeOfAccount = "";
	
	/** The state. */
	private static String state = "Oklahoma"; // spelled out
	
	/** The first name. */
	private static String firstName = "Automation";
	
	/** The last name. */
	private static String lastName = userEmailAddressName;
	
	/** The address. */
	private static String address = "501D NE 122nd St";
	
	/** The city. */
	private static String city = "Oklahoma City";
	
	/** The zip. */
	private static String zip = "73114";
	
	/** The password. */
	private static String password = "T3sting1";
	
	/** The setup user. */
	// User setup booleans
	private static boolean setupUser = true;
	
	/** The created QA. */
	// Booleans to know which environment was run to determine which email text should be generated
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
		
			if (amc==true) {
				typeOfAccount = "Appraisal Management Company";
			} else {
				typeOfAccount = "Mortgage Lender";		
			} // end if/else
			
			/********************************************************************************
			 * 
			 * CREATE USER ON QA
			 * 
			 ********************************************************************************/
			
			// Environment
			String env = "QA";
			String email = "automation" + env + userEmailAddressName + StoredVariables.getcatchAllDomain().get();
			String phonePrefix = "501111";
			String custNo = phonePrefix+last4digitsOfPhoneNumber;
			
			// Set secure site url
			StoredVariables.getsecureSite().set(perform.getSecureSite(env));
			
			// Sign up a new user
			secure.signupNewSecureUser(driver, typeOfAccount, state, "Automation"+env+userEmailAddressName, custNo, email, firstName, lastName, address, city, zip, password);
			
			// Activate user
			String crmURL = crm.goToCRM(driver, env, custNo);
			crm.verifyName(driver, userEmailAddressName, crmURL);
			crm.activateUser(driver, custNo);
			
			// Add a new order for the XSite
			crm.enterNewOrderForXSite(driver, env, custNo);
			
			// Go to internal tools
			StoredVariables.getinternalToolsSite().set(perform.getInternalToolsSite(env));
			it.goToInternalTools(driver);
			
			// Link the XSite
			it.linkVMPXSite(driver, custNo, userEmailAddressName);
			
			// Setup User
			if (setupUser == true)
			{
				secure.setUpNewUserDefaults(driver, userEmailAddressName, password, custNo, env, phonePrefix);
			} // end if setupUser
			
			createdQA = true;
			
			// Update the SMS number as bad
			db.markSMSNumberAsBad(driver, env, custNo);
			
			// Set user to Monthly billing
			db.setUserToMonthlyBilling(driver, custNo);
		
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
		
			if (amc==true) {
				typeOfAccount = "Appraisal Management Company";
			} else {
				typeOfAccount = "Mortgage Lender";		
			} // end if/else
			
			/********************************************************************************
			 * 
			 * CREATE USER ON BETA
			 * 
			 ********************************************************************************/
			
			// Environment
			String env = "Beta";
			String email = "automation" + env + userEmailAddressName + StoredVariables.getcatchAllDomain().get();
			String phonePrefix = "501222";
			String custNo = phonePrefix+last4digitsOfPhoneNumber;
			
			// Set secure site url
			StoredVariables.getsecureSite().set(perform.getSecureSite(env));
			
			// Sign up a new user
			secure.signupNewSecureUser(driver, typeOfAccount, state, "Automation"+env+userEmailAddressName, custNo, email, firstName, lastName, address, city, zip, password);
			
			// Activate user
			String crmURL = crm.goToCRM(driver, env, custNo);
			crm.verifyName(driver, userEmailAddressName, crmURL);
			crm.activateUser(driver, custNo);
			
			// Add a new order for the XSite
			crm.enterNewOrderForXSite(driver, env, custNo);
			
			// Go to internal tools
			StoredVariables.getinternalToolsSite().set(perform.getInternalToolsSite(env));
			it.goToInternalTools(driver);
			
			// Link the XSite
			it.linkVMPXSite(driver, custNo, userEmailAddressName);
			
			// Setup User
			if (setupUser == true)
			{
				secure.setUpNewUserDefaults(driver, userEmailAddressName, password, custNo, env, phonePrefix);
			} // end if setupUser
			
			createdBeta = true;
			
			// Update the SMS number as bad
			db.markSMSNumberAsBad(driver, env, custNo);
			
			// Set user to Monthly billing
			db.setUserToMonthlyBilling(driver, custNo);
		
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
		
			if (amc==true) {
				typeOfAccount = "Appraisal Management Company";
			} else {
				typeOfAccount = "Mortgage Lender";		
			} // end if/else
			
			/********************************************************************************
			 * 
			 * CREATE USER ON LIVE
			 * 
			 ********************************************************************************/
			
			// Environment
			String env = "Live";
			String email = "automation" + env + userEmailAddressName + StoredVariables.getcatchAllDomain().get();
			String phonePrefix = "501333";
			String custNo = phonePrefix+last4digitsOfPhoneNumber;
			
			// Set secure site url
			StoredVariables.getsecureSite().set(perform.getSecureSite(env));
			
			// Sign up a new user
			secure.signupNewSecureUser(driver, typeOfAccount, state, "Automation"+env+userEmailAddressName, custNo, email, firstName, lastName, address, city, zip, password);
			
			// Activate user
			String crmURL = crm.goToCRM(driver, env, custNo);
			crm.verifyName(driver, userEmailAddressName, crmURL);
			crm.activateUser(driver, custNo);
			
			// Add a new order for the XSite
			crm.enterNewOrderForXSite(driver, env, custNo);
			
			// Go to internal tools
			StoredVariables.getinternalToolsSite().set(perform.getInternalToolsSite(env));
			it.goToInternalTools(driver);
			
			// Link the XSite
			it.linkVMPXSite(driver, custNo, userEmailAddressName);
			
			// Setup User
			if (setupUser == true)
			{
				secure.setUpNewUserDefaults(driver, userEmailAddressName, password, custNo, env, phonePrefix);
			} // end if setupUser
			
			createdLive = true;
			
			// Update the SMS number as bad
			db.markSMSNumberAsBad(driver, env, custNo);
			
			// Set user to Monthly billing
			db.setUserToMonthlyBilling(driver, custNo);
		
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
