package userTools;

import javax.swing.JOptionPane;

import org.openqa.selenium.remote.RemoteWebDriver;
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
 * The Class CreateSecurePaymentsUser.
 */
public class CreateSecurePaymentsUser extends TestSetup {
	
	/**
	 * Creates the new secure user.
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"regression", "positive"}, alwaysRun=true)
	public synchronized void createNewSecureUser() throws Exception {

		boolean specifyUserInfo = true; // If set to false, a random customer number and username will be created
		
		String username = "Payments9";
		String phoneSuffix = "5429";
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		String env = StoredVariables.getusernameEnvironment().get();

		// New user variables
		String phonePrefix = "";
		if (env.equals("QA")) {
			phonePrefix = "501111";
		} else if (env.equals("Beta")) {
			phonePrefix = "501222";
		} else if (env.equals("Live")) {
			phonePrefix = "501333";
		} // end phone
		
		String custNo = "";
		if (specifyUserInfo==true) {
			custNo = "501"+phonePrefix+phoneSuffix;
			JOptionPane.showMessageDialog(null, "Do NOT click OK unless you want to specify \nthe following values for creating the new user: \n\nEnvironment = "+StoredVariables.getenvironment().get()+"\nUsername = " + username + "\nCustomer Number = " + custNo + "\n\nStop the script if you do not want to continue!");
		} else {
			custNo = "000"+perform.randomNumbers(driver, 7);
			username = "Payments"+perform.randomNumbers(driver, 5);
		}
		if (username.equals("")) {
			test.log(LogStatus.WARNING, "<span class='label warning'>Blank username</span>", "<pre>The username is blank</pre>");
			username = JOptionPane.showInputDialog("The username is blank. Enter a username to continue");;
		}
		if (username.equals("")) {
			test.log(LogStatus.FAIL, "<span class='label failure'>Blank username</span>", "<pre>The username is blank</pre>");
		}
		String password = StoredVariables.getpassword().get();
		String email = "automation" + env + username + StoredVariables.getcatchAllDomain().get();
		String company = StoredVariables.getusernameEnvironment().get() + "AutoTest " + username;
		String state = "Oklahoma";
		String internalToolsURL = "";
		String sqlStatement = "";
		
		// Set Internal Tools url
		if (env.equals("QA")) {
			internalToolsURL = "https://internaltoolsqa.ad.mercuryvmp.com/";
		}
		else {
			internalToolsURL = "https://internaltools.ad.mercuryvmp.com/";
		}
		
		// Set address based on state
		String address = "";
		String city = "";
		String zip = "";
		if (state.startsWith("Penn")) {
			address = "1001 Fifth Ave";
			city = "Pittsburgh";
			zip = "15219";
		}
		if (state.startsWith("Okl")) {
			address = "501D NE 122nd St";
			city = "Oklahoma City";
			zip = "73114";
		}
		
		System.out.println("custNo = " + custNo);
		
		/********************************************************************************************************
		 * COMMENT BELOW THIS LINE TO RESUME A FAILED TEST
		 ********************************************************************************************************/
		
		// Sign up a new Secure user
		secure.signupNewSecureUser(driver, "Mortgage Lender", state, company, custNo, email, "AutoTest", username, address, city, zip, password);
		
		// Go to CRM
		String crmURL = crm.goToCRM(driver, env, custNo);
		
		// Verify the name is correct in CRM
		crm.verifyName(driver, username, crmURL);
		
		// Activate the user
		crm.activateUser(driver, custNo);
		
		// Enter a new order
		crm.enterNewOrderForXSite(driver, env, custNo);
		
		// Go to Internal Tools
		driver.get(internalToolsURL);
		
		// Link VMP XSite
		it.linkVMPXSite(driver, custNo, username);
		
		// Go to Internal Tools
		driver.get(internalToolsURL);
		
		// Enter info into Payments Console
		it.setPaymentConsoleInfo(driver, custNo, true, username, "Automation", "Automation test", true, "First delivery", "0", "automation@dntest.net");
		
		// Create Merchant Account
		secure.createMerchantAccount(driver, env, email, password, custNo);

		// Enable/Update Merchants account and Update CustomerSettings using the â€œUpdate Merchant CustomerSettingsâ€� script
		// Set the update statement
		String merchantID = "";
		if (env.equals("QA")) {
			merchantID = "orion1";	
		} else {
			merchantID = "mercurynetwork3";
		} // end if for setting the merchantID
		sqlStatement = "Declare @CustomerNumber numeric(18,0) "
				+ "Set @CustomerNumber = "+custNo+" "
				+ "Begin Tran "
				+ "Update Merchants.dbo.Accounts "
				+ "Set Enabled = 1, CyberSourceMerchantID = '"+merchantID+"' "
				+ "Where CustomerNumber = @CustomerNumber "
				+ "Update Mercury.dbo.CustomerSettings "
				+ "Set MakeAPaymentModeID = 3 "
				+ "Where CustomerNumber = @CustomerNumber "
				+ "Commit";
		
		// Run the update statement
		db.updateDB(driver, "Mercury", sqlStatement);
		
		// Insert into Mercury.dbo.SendPaymentLinkSettings using the â€œInsert SendPaymentLinkSettingsâ€� script
		// Set the update statement
		String sqlStatement2 = "Insert Into Mercury.dbo.SendPaymentLinkSettings "
				+ "(CustomerNumber, "
				+ "DirectLink, "
				+ "Enabled, "
				+ "SetDisclosureDateOnCharge, "
				+ "EmailTemplate, "
				+ "EmailSubject, "
				+ "EmailBody, "
				+ "Salutation, "
				+ "SPName, "
				+ "SyncSystemAlert, "
				+ "UseDeferredCCEmail, "
				+ "OverrideFromEmail "
				+ ") "
				+ "Values "
				+ "("+custNo+", "
				+ "1, "
				+ "1, "
				+ "0, "
				+ "'Pay_BorrowerCollection.html', "
				+ "'RP1 PAYMENTS QA Payment Link - $LastName#', "
				+ "'<p>$AMCName# has received an appraisal order from RP1 Payments QA4.</p>  <p>In order to complete the process and assign an appraiser, please complete the payment authorization section by clicking the \"Provide Payment Information\" link below.    By clicking the \"payment link\", you will be directed to a secure payment authorization site to make your appraisal payment.    Please complete all screens and validate both the property street address and zip code.</p>', "
				+ "'<p>Once your payment has been made the Appraiser or representative from $AMCName# will contact you to schedule a convenient time to schedule a Property Inspection.</p>  <p>HELPFUL TIPS FOR THE PROPERTY INSPECTION</p>  <p>?         The appraiser will need full access to all rooms of the property</p>  <p>?         The appraiser will need access to yards, garage, basement, patio, structures and amenities</p>  <p>?         Interior and exterior photos are required</p>  <br>  </br>  <p>Should you have any questions or need any additional assistance, please contact your Loan Officer at RP1 Payments QA4.</p>', "
				+ "'dbo.SendPaymentLink_Default', "
				+ "0, "
				+ "0, "
				+ "0 "
				+ ")";
		
		// Run the update statement
		db.updateDB(driver, "Mercury", sqlStatement2);
		
		// Send Russ an email to run the update statements if not on a QA environment
		if (!env.equals("QA")) {
			// Email Russ to run update statements
			perform.sendEmail(driver, "rupace@coerlogic.com","dnorman@corelogic.com","Please Run Update Statements On PROD", "Can you please run the following update statements on the Prod DB to finish setting up the new Payments user:\n\n" + sqlStatement + "\n\n" + sqlStatement2);
			System.out.println("\n\nAn email has been sent to run the update statements\n\n");
		}

		// Update the SMS number as bad
		db.markSMSNumberAsBad(driver, env, custNo);
		
		// Set user settings and info
		secure.setUpNewUserDefaults(driver, email, password, custNo, env, phonePrefix);
		
		// Set user to Monthly billing
		db.setUserToMonthlyBilling(driver, custNo);
		
		// Log test
		test.log(LogStatus.INFO, "Create Payments User", "Verified you can create a new Secure lender payments user");
		
	} // end createNewSecureUser
	
} // end CreateSecureUser
