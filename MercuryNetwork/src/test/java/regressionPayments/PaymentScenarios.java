package regressionPayments;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import setup.DriverFactory;
import setup.TestSetup;
import utils.Retry;
import utils.StoredVariables;

/**
 * <h1>Payments - Place Payment Orders</h1>
 * This class contains several different scenarios to test the Payment process
 * <p>
 *
 * @author  Dustin Norman
 * @since   03-27-2019
 */

@Listeners(utils.Listener.class)
@Test(singleThreaded=false, groups={"Payments", "broken"}, enabled=false)
public class PaymentScenarios extends TestSetup {

	/** Set the password */
	private static String password = "Password1!";
	
	/** Set the VMP User */
	private static String vmpUser = "QATestClient";
	
	/** Set the Vendors Login */
	private static String vendorsLogin = "steve@cliftonc.com";
	
	/** Set the Vendors User */
	private static String vendorsUser = "Steven Speilberg";
	
	/**
	 * Scenario #1 - Funds always directed to the Lender<br>
	 * (Mode 1 / Real / Auto charge)
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Create an order from VMP Client</li>
	 *  <li>Login to Secure and assign the order to an appraiser</li>
	 *  <li>Login to Vendors and accept the order</li>
	 *  <li>Go to the new Make A Payment page</li>
	 *  <li>Search for the order</li>
	 *  <li>Enter payment information and submit the payment</li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Payments", "Scenario 1", "VMP - Create Order"}, alwaysRun=true)
	public void scenario1() throws Exception{
		
		// Create the driver for the test
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Set the environment
		String env = StoredVariables.getusernameEnvironment().get();
		
		// Only run in the QA environment
		if (env.equals("QA")) {

			// Set user variables
			String vmpURL = "";
			String secureUser = "";
			String secureUserCustomerNumber = "";
			if (env.equals("QA")) {
				vmpURL = "ModeOneReal";
				secureUser = "ModeOneReal@cliftonc.com";
				secureUserCustomerNumber = "1029990085";
			} else if (env.equals("Live")) {
				vmpURL = "";
				secureUser = "";
				secureUserCustomerNumber = "";
			} // end if/else
			String vmpURLFull = "https://" + vmpURL + "." + StoredVariables.getvmpSiteSuffix().get();
			
			// Verify the lender payment settings
			perform.verifyPaymentSettings(driver, secureUserCustomerNumber, "1", "803", "1", "mercurynetwork2", "1");
			perform.verifySendPaymentLinkSettings(driver, secureUserCustomerNumber, "1", "1");
			
			// Create the order, assign it to an appraiser and make a payment on it
			createOrderAndMakeAPayment(driver, vmpURLFull, secureUser, "1", true, "375", secureUserCustomerNumber, "Net 30");
			
			// Log test
			perform.addInfoToExtentReport(driver, "Payment Scenarios", "Verified payment scenario 1");
		
		} // end if QA
		
	} // end scenario1
	
	/**
	 * Scenario #2 - Funds always going to AMC / Mercury charges card / Mercury AMC<br>
	 * (Mode 1 / Fake / Auto charge / Mercury AMC)
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Create an order from VMP Client</li>
	 *  <li>Login to Secure and assign the order to an AMC</li>
	 *  <li>Login to Secure and assign the order to an appraiser</li>
	 *  <li>Login to Vendors and accept the order</li>
	 *  <li>Go to the new Make A Payment page</li>
	 *  <li>Search for the order</li>
	 *  <li>Enter payment information and submit the payment</li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Payments", "Scenario 2"}, alwaysRun=true)
	public void scenario2() throws Exception{
		
		// Create the driver for the test
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Set the environment
		String env = StoredVariables.getusernameEnvironment().get();
		
		// Only run in the QA environment
		if (env.equals("QA")) {

			// Set user variables
			String vmpURL = "";
			String secureUser = "";
			String secureUserCustomerNumber = "";
			String amcUser = "";
			String amcCompanyName = "";
			String amcEntityID = "";
			if (env.equals("QA")) {
				vmpURL = "ModeOneFake";
				secureUser = "ModeOneFake@cliftonc.com";
				secureUserCustomerNumber = "1029990084";
				amcUser = "FullNoStore@cliftonc.com";
				amcCompanyName = "Full AMC No Store";
				amcEntityID = "1074556";
			} else if (env.equals("Live")) {
				vmpURL = "";
				secureUser = "";
				secureUserCustomerNumber = "";
				amcUser = "";
				amcCompanyName = "";
				amcEntityID = "";
			} // end if/else
			String vmpURLFull = "https://" + vmpURL + "." + StoredVariables.getvmpSiteSuffix().get();
			
			// Verify the lender payment settings
			perform.verifyPaymentSettings(driver, secureUserCustomerNumber, "1", "802", "1", "FakeMerchantAccount", "1");
			perform.verifySendPaymentLinkSettings(driver, secureUserCustomerNumber, "1", "1");
			
			// Verify the AMC store card info
			perform.verifyEntitySettingsBit(driver, amcEntityID, "12", null);
			
			// Create the order, assign it to an AMC, assign it to an appraiser and make a payment on it
			createOrderAndMakeAPaymentWithAMC(driver, vmpURLFull, secureUser, amcUser, amcCompanyName, "1", false, "450", secureUserCustomerNumber, false, "Deferred CC");
			
			// Log test
			perform.addInfoToExtentReport(driver, "Payment Scenarios", "Verified payment scenario 2");
			
		} // end if QA
		
	} // end scenario2
	
	/**
	 * Scenario 3
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Create an order from VMP Client</li>
	 *  <li>Login to Secure and assign the order to an AMC</li>
	 *  <li>Login to Secure and assign the order to an appraiser</li>
	 *  <li>Login to Vendors and accept the order</li>
	 *  <li>Go to the new Make A Payment page</li>
	 *  <li>Search for the order</li>
	 *  <li>Enter payment information and submit the payment</li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Payments", "Scenario 3"}, alwaysRun=true)
	public void scenario3() throws Exception{
		
		// Create the driver for the test
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Set the environment
		String env = StoredVariables.getusernameEnvironment().get();
		
		// Only run in the QA environment
		if (env.equals("QA")) {
		
			// Set user variables
			String vmpURL = "";
			String secureUser = "";
			String secureUserCustomerNumber = "";
			String amcUser = "";
			String amcCompanyName = "";
			String amcEntityID = "";
			if (env.equals("QA")) {
				vmpURL = "ModeOneFake";
				secureUser = "ModeOneFake@cliftonc.com";
				secureUserCustomerNumber = "1029990084";
				amcUser = "FullStoreCard@cliftonc.com";
				amcCompanyName = "Full AMC Store Card";
				amcEntityID = "1074559";
			} else if (env.equals("Live")) {
				vmpURL = "";
				secureUser = "";
				secureUserCustomerNumber = "";
				amcUser = "";
				amcCompanyName = "";
				amcEntityID = "";
			} // end if/else
			String vmpURLFull = "https://" + vmpURL + "." + StoredVariables.getvmpSiteSuffix().get();
			
			// Verify the lender payment settings
			perform.verifyPaymentSettings(driver, secureUserCustomerNumber, "1", "802", "1", "FakeMerchantAccount", "1");
			perform.verifySendPaymentLinkSettings(driver, secureUserCustomerNumber, "1", "1");
			
			// Verify the AMC store card info
			perform.verifyEntitySettingsBit(driver, amcEntityID, "12", "1");
	
			// Create the order, assign it to an AMC, assign it to an appraiser and make a payment on it
			createOrderAndMakeAPaymentWithAMC(driver, vmpURLFull, secureUser, amcUser, amcCompanyName, "1", false, "450", secureUserCustomerNumber, true, "Deferred CC");
			
			// Log test
			perform.addInfoToExtentReport(driver, "Payment Scenarios", "Verified payment scenario 3");
			
		} // end if QA
		
	} // end scenario3
	
	/**
	 * Scenario 4
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Create an order from VMP Client</li>
	 *  <li>Login to Secure and assign the order to an AMC</li>
	 *  <li>Login to Secure and assign the order to an appraiser</li>
	 *  <li>Login to Vendors and accept the order</li>
	 *  <li>Go to the new Make A Payment page</li>
	 *  <li>Search for the order</li>
	 *  <li>Enter payment information and submit the payment</li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Payments", "Scenario 4"}, alwaysRun=true)
	public void scenario4() throws Exception{
		
		// Create the driver for the test
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Set the environment
		String env = StoredVariables.getusernameEnvironment().get();
		
		// Only run in the QA environment
		if (env.equals("QA")) {
		
			// Set user variables
			String vmpURL = "";
			String secureUser = "";
			String secureUserCustomerNumber = "";
			String amcUser = "";
			String amcCompanyName = "";
			String amcEntityID = "";
			if (env.equals("QA")) {
				vmpURL = "ModeOneFake";
				secureUser = "ModeOneFake@cliftonc.com";
				secureUserCustomerNumber = "1029990084";
				amcUser = "VendorNoStore@cliftonc.com";
				amcCompanyName = "Vendor AMC No Store Card";
				amcEntityID = "1074561";
			} else if (env.equals("Live")) {
				vmpURL = "";
				secureUser = "";
				secureUserCustomerNumber = "";
				amcUser = "";
				amcCompanyName = "";
				amcEntityID = "";
			} // end if/else
			String vmpURLFull = "https://" + vmpURL + "." + StoredVariables.getvmpSiteSuffix().get();
			
			// Verify the lender payment settings
			perform.verifyPaymentSettings(driver, secureUserCustomerNumber, "1", "802", "1", "FakeMerchantAccount", "1");
			perform.verifySendPaymentLinkSettings(driver, secureUserCustomerNumber, "1", "1");
			
			// Verify the AMC store card info
			perform.verifyEntitySettingsBit(driver, amcEntityID, "12", null);
	
			// Create the order, assign it to an AMC, assign it to an appraiser and make a payment on it
			createOrderAndMakeAPaymentWithAMCVendorOnly(driver, vmpURLFull, secureUser, amcUser, amcCompanyName, "1", false, "450", "Deferred CC", false);
			
			// Log test
			perform.addInfoToExtentReport(driver, "Payment Scenarios", "Verified payment scenario 4");
			
		} // end if QA
		
	} // end scenario4
	
	/**
	 * Scenario 5
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Create an order from VMP Client</li>
	 *  <li>Login to Secure and assign the order to an AMC</li>
	 *  <li>Login to Secure and assign the order to an appraiser</li>
	 *  <li>Login to Vendors and accept the order</li>
	 *  <li>Go to the new Make A Payment page</li>
	 *  <li>Search for the order</li>
	 *  <li>Enter payment information and submit the payment</li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Payments", "Scenario 5"}, alwaysRun=true)
	public void scenario5() throws Exception{
		
		// Create the driver for the test
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Set the environment
		String env = StoredVariables.getusernameEnvironment().get();
		
		// Only run in the QA environment
		if (env.equals("QA")) {
		
			// Set user variables
			String vmpURL = "";
			String secureUser = "";
			String secureUserCustomerNumber = "";
			String amcUser = "";
			String amcCompanyName = "";
			String amcEntityID = "";
			if (env.equals("QA")) {
				vmpURL = "ModeOneFake";
				secureUser = "ModeOneFake@cliftonc.com";
				secureUserCustomerNumber = "1029990084";
				amcUser = "VendorStoreCard@cliftonc.com";
				amcCompanyName = "Vendor Only Store Card";
				amcEntityID = "1074562";
			} else if (env.equals("Live")) {
				vmpURL = "";
				secureUser = "";
				secureUserCustomerNumber = "";
				amcUser = "";
				amcCompanyName = "";
				amcEntityID = "";
			} // end if/else
			String vmpURLFull = "https://" + vmpURL + "." + StoredVariables.getvmpSiteSuffix().get();
			
			// Verify the lender payment settings
			perform.verifyPaymentSettings(driver, secureUserCustomerNumber, "1", "802", "1", "FakeMerchantAccount", "1");
			perform.verifySendPaymentLinkSettings(driver, secureUserCustomerNumber, "1", "1");
			
			// Verify the AMC store card info
			perform.verifyEntitySettingsBit(driver, amcEntityID, "12", "1");
	
			// Create the order, assign it to an AMC, assign it to an appraiser and make a payment on it
			createOrderAndMakeAPaymentWithAMCVendorOnly(driver, vmpURLFull, secureUser, amcUser, amcCompanyName, "1", false, "450", "Deferred CC", true);
			
			// Log test
			perform.addInfoToExtentReport(driver, "Payment Scenarios", "Verified payment scenario 5");
			
		} // end if QA
		
	} // end scenario5
	
	/**
	 * Scenario 6
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Create an order from VMP Client</li>
	 *  <li>Login to Secure and assign the order to an appraiser</li>
	 *  <li>Login to Vendors and accept the order</li>
	 *  <li>Go to the new Make A Payment page</li>
	 *  <li>Search for the order</li>
	 *  <li>Enter payment information and submit the payment</li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Payments", "Scenario 6"}, alwaysRun=true)
	public void scenario6() throws Exception{
		
		// Create the driver for the test
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Set the environment
		String env = StoredVariables.getusernameEnvironment().get();
		
		// Only run in the QA environment
		if (env.equals("QA")) {
		
			// Set user variables
			String vmpURL = "";
			String secureUser = "";
			String secureUserCustomerNumber = "";
			if (env.equals("QA")) {
				vmpURL = "ModeTwoReal";
				secureUser = "ModeTwoReal@cliftonc.com";
				secureUserCustomerNumber = "1029990086";
			} else if (env.equals("Live")) {
				vmpURL = "";
				secureUser = "";
				secureUserCustomerNumber = "";
			} // end if/else
			String vmpURLFull = "https://" + vmpURL + "." + StoredVariables.getvmpSiteSuffix().get();
			
			// Verify the lender payment settings
			perform.verifyPaymentSettings(driver, secureUserCustomerNumber, "2", "804", "1", "mercurynetwork2", "1");
			perform.verifySendPaymentLinkSettings(driver, secureUserCustomerNumber, "1", "1");
	
			// Create the order, assign it to an appraiser and make a payment on it
			createOrderAndMakeAPayment(driver, vmpURLFull, secureUser, "1", false, "375", secureUserCustomerNumber, "Net 30");
			
			// Log test
			perform.addInfoToExtentReport(driver, "Payment Scenarios", "Verified payment scenario 6");
			
		} // end if QA
		
	} // end scenario6
	
	/**
	 * Scenario 7
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Create an order from VMP Client</li>
	 *  <li>Login to Secure and assign the order to an appraiser</li>
	 *  <li>Login to Vendors and accept the order</li>
	 *  <li>Go to the new Make A Payment page</li>
	 *  <li>Search for the order</li>
	 *  <li>Enter payment information and submit the payment</li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Payments", "Scenario 7"}, alwaysRun=true)
	public void scenario7() throws Exception{
		
		// Create the driver for the test
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Set the environment
		String env = StoredVariables.getusernameEnvironment().get();
		
		// Only run in the QA environment
		if (env.equals("QA")) {
		
			// Set user variables
			String vmpURL = "";
			String secureUser = "";
			String secureUserCustomerNumber = "";
			String amcUser = "";
			String amcCompanyName = "";
			String amcEntityID = "";
			if (env.equals("QA")) {
				vmpURL = "ModeTwoReal";
				secureUser = "ModeTwoReal@cliftonc.com";
				secureUserCustomerNumber = "1029990086";
				amcUser = "FullNoStore@cliftonc.com";
				amcCompanyName = "Full AMC No Store";
				amcEntityID = "1074556";
			} else if (env.equals("Live")) {
				vmpURL = "";
				secureUser = "";
				secureUserCustomerNumber = "";
				amcUser = "";
				amcCompanyName = "";
				amcEntityID = "";
			} // end if/else
			String vmpURLFull = "https://" + vmpURL + "." + StoredVariables.getvmpSiteSuffix().get();
			
			// Verify the lender payment settings
			perform.verifyPaymentSettings(driver, secureUserCustomerNumber, "2", "804", "1", "mercurynetwork2", "1");
			perform.verifySendPaymentLinkSettings(driver, secureUserCustomerNumber, "1", "1");
			
			// Verify the AMC store card info
			perform.verifyEntitySettingsBit(driver, amcEntityID, "12", null);
	
			// Create the order, assign it to an AMC, assign it to an appraiser and make a payment on it
			createOrderAndMakeAPaymentWithAMC(driver, vmpURLFull, secureUser, amcUser, amcCompanyName, "1", false, "450", secureUserCustomerNumber, false, "Deferred CC");
			
			// Log test
			perform.addInfoToExtentReport(driver, "Payment Scenarios", "Verified payment scenario 7");
			
		} // end if QA
		
	} // end scenario7
	
	/**
	 * Scenario 8
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Create an order from VMP Client</li>
	 *  <li>Login to Secure and assign the order to an appraiser</li>
	 *  <li>Login to Vendors and accept the order</li>
	 *  <li>Go to the new Make A Payment page</li>
	 *  <li>Search for the order</li>
	 *  <li>Enter payment information and submit the payment</li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Payments", "Scenario 8"}, alwaysRun=true)
	public void scenario8() throws Exception{
		
		// Create the driver for the test
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Set the environment
		String env = StoredVariables.getusernameEnvironment().get();
		
		// Only run in the QA environment
		if (env.equals("QA")) {
		
			// Set user variables
			String vmpURL = "";
			String secureUser = "";
			String secureUserCustomerNumber = "";
			String amcUser = "";
			String amcCompanyName = "";
			String amcEntityID = "";
			if (env.equals("QA")) {
				vmpURL = "ModeTwoReal";
				secureUser = "ModeTwoReal@cliftonc.com";
				secureUserCustomerNumber = "1029990086";
				amcUser = "FullStoreCard@cliftonc.com";
				amcCompanyName = "Full AMC Store Card";
				amcEntityID = "1074559";
			} else if (env.equals("Live")) {
				vmpURL = "";
				secureUser = "";
				secureUserCustomerNumber = "";
				amcUser = "";
				amcCompanyName = "";
				amcEntityID = "";
			} // end if/else
			String vmpURLFull = "https://" + vmpURL + "." + StoredVariables.getvmpSiteSuffix().get();
			
			// Verify the lender payment settings
			perform.verifyPaymentSettings(driver, secureUserCustomerNumber, "2", "804", "1", "mercurynetwork2", "1");
			perform.verifySendPaymentLinkSettings(driver, secureUserCustomerNumber, "1", "1");
			
			// Verify the AMC store card info
			perform.verifyEntitySettingsBit(driver, amcEntityID, "12", "1");
	
			// Create the order, assign it to an AMC, assign it to an appraiser and make a payment on it
			createOrderAndMakeAPaymentWithAMC(driver, vmpURLFull, secureUser, amcUser, amcCompanyName, "1", false, "450", secureUserCustomerNumber, true, "Deferred CC");
			
			// Log test
			perform.addInfoToExtentReport(driver, "Payment Scenarios", "Verified payment scenario 8");
			
		} // end if QA
		
	} // end scenario8
	
	/**
	 * Scenario 9
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Create an order from VMP Client</li>
	 *  <li>Login to Secure and assign the order to an appraiser</li>
	 *  <li>Login to Vendors and accept the order</li>
	 *  <li>Go to the new Make A Payment page</li>
	 *  <li>Search for the order</li>
	 *  <li>Enter payment information and submit the payment</li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Payments", "Scenario 9"}, alwaysRun=true)
	public void scenario9() throws Exception{
		
		// Create the driver for the test
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Set the environment
		String env = StoredVariables.getusernameEnvironment().get();
		
		// Only run in the QA environment
		if (env.equals("QA")) {
		
			// Set user variables
			String vmpURL = "";
			String secureUser = "";
			String secureUserCustomerNumber = "";
			String amcUser = "";
			String amcCompanyName = "";
			String amcEntityID = "";
			if (env.equals("QA")) {
				vmpURL = "ModeTwoReal";
				secureUser = "ModeTwoReal@cliftonc.com";
				secureUserCustomerNumber = "1029990086";
				amcUser = "VendorNoStore@cliftonc.com";
				amcCompanyName = "Vendor AMC No Store Card";
				amcEntityID = "1074561";
			} else if (env.equals("Live")) {
				vmpURL = "";
				secureUser = "";
				secureUserCustomerNumber = "";
				amcUser = "";
				amcCompanyName = "";
				amcEntityID = "";
			} // end if/else
			String vmpURLFull = "https://" + vmpURL + "." + StoredVariables.getvmpSiteSuffix().get();
			
			// Verify the lender payment settings
			perform.verifyPaymentSettings(driver, secureUserCustomerNumber, "2", "804", "1", "mercurynetwork2", "1");
			perform.verifySendPaymentLinkSettings(driver, secureUserCustomerNumber, "1", "1");
			
			// Verify the AMC store card info
			perform.verifyEntitySettingsBit(driver, amcEntityID, "12", null);
	
			// Create the order, assign it to an AMC, assign it to an appraiser and make a payment on it
			createOrderAndMakeAPaymentWithAMCVendorOnly(driver, vmpURLFull, secureUser, amcUser, amcCompanyName, "1", false, "450", "Deferred CC", false);
			
			// Log test
			perform.addInfoToExtentReport(driver, "Payment Scenarios", "Verified payment scenario 9");
			
		} // end if QA
		
	} // end scenario9
	
	/**
	 * Scenario 10
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Create an order from VMP Client</li>
	 *  <li>Login to Secure and assign the order to an appraiser</li>
	 *  <li>Login to Vendors and accept the order</li>
	 *  <li>Go to the new Make A Payment page</li>
	 *  <li>Search for the order</li>
	 *  <li>Enter payment information and submit the payment</li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Payments", "Scenario 10"}, alwaysRun=true)
	public void scenario10() throws Exception{
		
		// Create the driver for the test
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Set the environment
		String env = StoredVariables.getusernameEnvironment().get();
		
		// Only run in the QA environment
		if (env.equals("QA")) {
		
			// Set user variables
			String vmpURL = "";
			String secureUser = "";
			String secureUserCustomerNumber = "";
			String amcUser = "";
			String amcCompanyName = "";
			String amcEntityID = "";
			if (env.equals("QA")) {
				vmpURL = "ModeTwoReal";
				secureUser = "ModeTwoReal@cliftonc.com";
				secureUserCustomerNumber = "1029990086";
				amcUser = "VendorStoreCard@cliftonc.com";
				amcCompanyName = "Vendor Only Store Card";
				amcEntityID = "1074562";
			} else if (env.equals("Live")) {
				vmpURL = "";
				secureUser = "";
				secureUserCustomerNumber = "";
				amcUser = "";
				amcCompanyName = "";
				amcEntityID = "";
			} // end if/else
			String vmpURLFull = "https://" + vmpURL + "." + StoredVariables.getvmpSiteSuffix().get();
			
			// Verify the lender payment settings
			perform.verifyPaymentSettings(driver, secureUserCustomerNumber, "2", "804", "1", "mercurynetwork2", "1");
			perform.verifySendPaymentLinkSettings(driver, secureUserCustomerNumber, "1", "1");
			
			// Verify the AMC store card info
			perform.verifyEntitySettingsBit(driver, amcEntityID, "12", "1");
	
			// Create the order, assign it to an AMC, assign it to an appraiser and make a payment on it
			createOrderAndMakeAPaymentWithAMCVendorOnly(driver, vmpURLFull, secureUser, amcUser, amcCompanyName, "1", false, "450", "Deferred CC", true);
			
			// Log test
			perform.addInfoToExtentReport(driver, "Payment Scenarios", "Verified payment scenario 10");
			
		} // end if QA
		
	} // end scenario10
	
	/**
	 * Create the VMP order.
	 *
	 * @param driver the driver
	 * @param vmpURLFull the vmp URL full
	 * @param vendorPaymentResponsibility the vendor payment responsibility
	 * @param enterCustomOrderFee the enter custom order fee
	 * @return the order information
	 * @throws Exception the exception
	 */
	private String[] createVMPOrder (RemoteWebDriver driver, String vmpURLFull, String vendorPaymentResponsibility, boolean enterCustomOrderFee) throws Exception {
		
		String getOrderFee = "";
		String setOrderFee = "";
		if (enterCustomOrderFee == true) {
			
			// Get a random Order Fee
			getOrderFee = Integer.toString(perform.randomNumberBetween2Numbers(driver, 600, 999));
			setOrderFee = "$" + getOrderFee + ".00";
			
		} // end if enterCustomOrderFee
		
		// Login to VMP Client Portal
		vmp.login(driver, vmpURLFull, vmpUser, password);
		
		// Set variables for a new VMP Order
		vmp.setVariables(driver);
		
		// Create a new order using deferred CC
		StoredVariables.getassignmentInformationForm().set("Uniform Residential Appraisal (FNMA 1004)");
		if (enterCustomOrderFee==false) {
			
			getOrderFee = vmp.createNewOrderUsingDeferredCC(driver, setOrderFee);
			setOrderFee = "$" + getOrderFee + ".00";
			
		} else {
			
			vmp.createNewOrderUsingDeferredCC(driver, setOrderFee);
			
		} // end setting the order fee
		
		// Get order numbers
		db.getLoanIDsFromVMPClientPortalOrder(driver);
		String orderNumber = StoredVariables.getloanID().get();
		String orderNumberVMP = StoredVariables.getloanIDVMP().get();
		
		// Get the ProductItemID
		String productItemID = db.getProductItemID(driver, orderNumber);
		 
		// Calculate the Tech Fee
		String calculateTechFeeSQL = "SELECT ServiceFeeFlat + ServiceFeePercent FROM [Mercury].[dbo].[MercuryOrderInformation] WHERE ProductItemID = '"+productItemID+"'";
		String getTechFee = db.queryDB(driver, "Mercury", calculateTechFeeSQL);
		String setTechFee = "$" + getTechFee;
		System.out.println("Tech Fee: " + setTechFee);
		
		// Set the Combined Fee
		DecimalFormat df = new DecimalFormat("#.00");
		String setCombined = "$" + df.format(Integer.parseInt(getOrderFee)+Double.parseDouble(getTechFee));
		System.out.println("Combined: " + setCombined);
		
		// Add order info to Extent Report
		perform.addInfoToExtentReport(driver, "Order Info", "Address: " + StoredVariables.getpropertyInformationAddress().get() + 
				"<br>Order Number: " + orderNumber +
				"<br>VMP Order Number: " + orderNumberVMP +
				"<br>Product Item ID: " + productItemID +
				"<br>Loan Number: " + StoredVariables.getassignmentInformationLoanNumber().get() +
				"<br>Order Fee: " + setOrderFee +
				"<br>Tech Fee: " + setTechFee +
				"<br>Combined Fee: " + setCombined);
		
		// Create an array of the values to return
		String[] values = {setOrderFee, setTechFee, setCombined, productItemID};
		
		return values;
		
	} // end createVMPOrder
	
	/**
	 * Create the order, assign it to an appraiser and make a payment on it.
	 *
	 * @param driver the driver
	 * @param vmpURLFull the vmp URL full
	 * @param secureUser the secure user
	 * @param vendorPaymentResponsibility the vendor payment responsibility
	 * @param enterCustomOrderFee the enter custom order fee
	 * @param vendorsOrderFee the vendors order fee
	 * @param customerNumberToBackDateOrders the customer number to back date orders
	 * @throws Exception the exception
	 */
	private void createOrderAndMakeAPayment (RemoteWebDriver driver, String vmpURLFull, String secureUser, String vendorPaymentResponsibility, boolean enterCustomOrderFee, String vendorsOrderFee, String customerNumberToBackDateOrders, String paymentMethod) throws Exception {
		
		// Create the VMP order
		String[] values = createVMPOrder(driver, vmpURLFull, vendorPaymentResponsibility, enterCustomOrderFee);
		
		// Set the new order info variables
		String orderFee = values[0];
		String techFee = values[1];
		String combined = values[2];
		String productItemID = values[3];
		String orderNumber = StoredVariables.getloanID().get();
		
		// Login to Secure and assign the order to an appraiser
		secure.loginAndAssignOrderToAppraiser(driver, secureUser, password, orderNumber, vendorsUser);
		
		// Login to Vendors and accept the order
		vendors.loginAndAcceptOrder(driver, vendorsLogin, password, orderNumber);
		
		// Check the database entries
		performDBChecksOnSecondOrderAfterOrderIsAccepted(driver, orderNumber, productItemID, vendorPaymentResponsibility, vendorsOrderFee, paymentMethod);
		
		// Make a payment from the new Make A Payment page
		secure.makeAPayment(driver, vmpURLFull, StoredVariables.getpropertyInformationAddress().get(), StoredVariables.getpropertyInformationZip().get(), orderFee, techFee, combined, "Automation", "Test", "4111111111111111", "November", "2026", "73099", "automation@dntest.net");
		
		// Check database to verify an entry is written to the MercuryOrderReceivables table for the second order
		performDBChecksAfterPaymentIsMadeOnSecondOrder(driver, orderNumber);
		
		// Run query to back-date the orders
		backDateOrder(driver, customerNumberToBackDateOrders);
		
		// Verify second order entries in the database after the billing processor runs
//		performDBChecksAfterBillingProcessorRuns(driver, orderNumberAMC);
		
		
		
//		// Set date format
//		Calendar cal = Calendar.getInstance();
//		cal.add(Calendar.DATE, 0);
//		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
//		String today = format1.format(cal.getTime());
//		
//		// Verify there is now a row in the Mercury.dbo.VendorPaymentQueue table and data is correct
//		// Set SQL statement
//		String sqlStatement = "SELECT * FROM Mercury.dbo.VendorPaymentQueue "
//				+ "WHERE LoanID = '"+trackingNumber+"'";
//		
//		// Query the DB and build an array out of the results
//		ArrayList<String> vendorPaymentQueue = db.queryDBArray(driver, "Mercury", sqlStatement);
//		String loanID = vendorPaymentQueue.get(1);
//		String enteredStamp = vendorPaymentQueue.get(2);
//		String paymentDate = vendorPaymentQueue.get(3);
//		
//		// Verify the values are correct
//		perform.verification(driver, loanID, "equals", trackingNumber);
//		perform.verification(driver, enteredStamp, "contains", today);
//		perform.verification(driver, paymentDate, "contains", today);
		
	} // end createOrderAndMakeAPayment
	
	/**
	 * Create the order, assign it to an AMC, assign it to an appraiser and make a payment on it.
	 *
	 * @param driver the driver
	 * @param vmpURLFull the vmp URL full
	 * @param secureUser the secure user
	 * @param amcUser the amc user
	 * @param amcCompanyName the amc company name
	 * @param vendorPaymentResponsibility the vendor payment responsibility
	 * @param enterCustomOrderFee the enter custom order fee
	 * @throws Exception the exception
	 */
	private void createOrderAndMakeAPaymentWithAMC (RemoteWebDriver driver, String vmpURLFull, String secureUser, String amcUser, String amcCompanyName, String vendorPaymentResponsibility,
			boolean enterCustomOrderFee, String vendorsOrderFee, String customerNumberToBackDateOrders, boolean makePaymentViaXSite, String paymentMethod) throws Exception {
		
		// Create the VMP order
		String[] values = createVMPOrder(driver, vmpURLFull, vendorPaymentResponsibility, enterCustomOrderFee);
		
		// Set the new order info variables
		String orderFee = values[0];
		String techFee = values[1];
		String combined = values[2];
		String productItemID = values[3];
		String orderNumber = StoredVariables.getloanID().get();
		
		// Login to Secure as the Lender and assign the order to an AMC
		secure.loginAndAssignOrderToAMC(driver, secureUser, password, orderNumber, amcCompanyName);
		
		// Login to Secure as the AMC and assign the order to an appraiser
		secure.loginAndAssignOrderToAppraiser(driver, amcUser, password, orderNumber, vendorsUser);
		
		// Get the AMC order number
		db.getLoanIDsFromEVFClientPortalOrder(driver);
		String orderNumberAMC = StoredVariables.getloanIDAMC().get();
		
		// Login to Vendors and accept the order
		vendors.loginAndAcceptOrder(driver, vendorsLogin, password, orderNumber);

		// Check the database entries
		performDBChecksOnSecondOrderAfterOrderIsAccepted(driver, orderNumber, productItemID, vendorPaymentResponsibility, vendorsOrderFee, paymentMethod);
		performDBChecksOnThirdOrderAfterOrderIsAccepted(driver, orderNumberAMC, productItemID, vendorPaymentResponsibility, vendorsOrderFee);
		
		// Make a payment from the new Make A Payment page
		secure.makeAPayment(driver, vmpURLFull, StoredVariables.getpropertyInformationAddress().get(), StoredVariables.getpropertyInformationZip().get(), orderFee, techFee, combined, "Automation", "Test", "4111111111111111", "November", "2026", "73099", "automation@dntest.net");
		
		// Make a payment from the XSite
		if (makePaymentViaXSite==true) {
			
			// View the XSite order as the AMC
			secure.viewXSiteOrderFromSecure(driver, amcUser, password, orderNumberAMC);
			
			// Charge the card from the XSite
			secure.chargeCardXSite(driver, "", "", "", "", "", "", "", "", false);
			
		} // end if
		
		else {
			
		// Check database to verify an entry is written to the MercuryOrderReceivables table for the second order
		performDBChecksAfterPaymentIsMadeOnSecondOrder(driver, orderNumber);
		
		} // end if/else
		
		// Run query to back-date the orders
//		backDateOrder(driver, customerNumberToBackDateOrders);
		
		// Verify second order entries in the database after the billing processor runs
//		performDBChecksAfterBillingProcessorRuns(driver, orderNumberAMC);
		
	} // end createOrderAndMakeAPaymentWithAMC
	
	/**
	 * Create the order, assign it to an AMC, assign it to an appraiser and make a payment on it.
	 *
	 * @param driver the driver
	 * @param vmpURLFull the vmp URL full
	 * @param secureUser the secure user
	 * @param amcUser the amc user
	 * @param amcCompanyName the amc company name
	 * @param vendorPaymentResponsibility the vendor payment responsibility
	 * @param enterCustomOrderFee the enter custom order fee
	 * @throws Exception the exception
	 */
	private void createOrderAndMakeAPaymentWithAMCVendorOnly (RemoteWebDriver driver, String vmpURLFull, String secureUser, String amcUser, String amcCompanyName, String vendorPaymentResponsibility, 
			boolean enterCustomOrderFee, String vendorsOrderFee, String paymentMethod, boolean makePaymentViaXSite) throws Exception {
		
		// Create the VMP order
		String[] values = createVMPOrder(driver, vmpURLFull, vendorPaymentResponsibility, enterCustomOrderFee);
		
		// Set the new order info variables
		String orderFee = values[0];
		String techFee = values[1];
		String combined = values[2];
		String productItemID = values[3];
		String orderNumber = StoredVariables.getloanID().get();
		
		// Login to Secure as the Lender and assign the order to an AMC
		secure.loginAndAssignOrderToAMC(driver, secureUser, password, orderNumber, amcCompanyName);
		
		// Check the database entries
		performDBChecksOnSecondOrderAfterOrderIsAccepted(driver, orderNumber, productItemID, vendorPaymentResponsibility, vendorsOrderFee, paymentMethod);
//		performDBChecksOnThirdOrderAfterOrderIsAccepted(driver, orderNumberAMC, productItemID, vendorPaymentResponsibility, vendorsOrderFee);
		
		// Make a payment from the new Make A Payment page
		secure.makeAPayment(driver, vmpURLFull, StoredVariables.getpropertyInformationAddress().get(), StoredVariables.getpropertyInformationZip().get(), orderFee, techFee, combined, "Automation", "Test", "4111111111111111", "November", "2026", "73099", "automation@dntest.net");
		
		// Make a payment from the XSite
		if (makePaymentViaXSite==true) {
			
			// View the XSite order as the lender
			secure.viewXSiteOrderFromSecure(driver, secureUser, password, orderNumber);
			
			// Charge the card from the XSite
			secure.chargeCardXSite(driver, "", "", "", "4111111111111111", "12", "2025", "", "", false);
			
		} // end if
		
		else {
			
		// Check database to verify an entry is written to the MercuryOrderReceivables table for the second order
		performDBChecksAfterPaymentIsMadeOnSecondOrder(driver, orderNumber);
		
		} // end if/else
		
		// Run query to back-date the orders
//		backDateOrder(driver, customerNumberToBackDateOrders);
		
		// Verify second order entries in the database after the billing processor runs
//		performDBChecksAfterBillingProcessorRuns(driver, orderNumberAMC);
		
	} // end createOrderAndMakeAPaymentWithAMCVendorOnly
	
	/**
	 * Perform DB checks on second order after order is accepted.
	 *
	 * @param driver the driver
	 * @param orderNumber the order number
	 * @param productItemID the product item ID
	 * @param vendorPaymentResponsibility the vendor payment responsibility
	 * @param orderFee the order fee
	 * @throws Exception the exception
	 */
	private void performDBChecksOnSecondOrderAfterOrderIsAccepted (RemoteWebDriver driver, String orderNumber, String productItemID, String vendorPaymentResponsibility, String orderFee, String paymentMethod) throws Exception {
		
		String sqlStatement = null;
		
		// Verify the VendorPaymentResponsibility
		db.verifyVendorPaymentResponsibilityID(driver, productItemID, vendorPaymentResponsibility);
		
		// Verify the price
		db.verifyPriceInProductItems(driver, productItemID, orderFee);
		
		// Verify the payment method
		db.verifyPaymentMethodInProductItems(driver, productItemID, paymentMethod);
		
		// Verify there is an entry in MercuryOrderInformation
		sqlStatement = "SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED "
				+ "SELECT ProductItemID FROM Mercury.dbo.MercuryOrderInformation WHERE ProductItemID = " + productItemID;
		ArrayList<String> moiResults = db.queryDBArray(driver, "Mercury", sqlStatement);
		Assert.assertTrue(moiResults.size()==1, "There should be 1 record in MercuryOrderInformation, but there are " + moiResults.size() + "\n" + sqlStatement);
		
		// Verify 2 entries are written to MercuryBillingQueue
		sqlStatement = "SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED "
				+ "SELECT MercuryBillingQueueID FROM Mercury.dbo.MercuryBillingQueue WHERE LoanID = " + orderNumber;
		ArrayList<String> mbqResults = db.queryDBArray(driver, "Mercury", sqlStatement);
		Assert.assertTrue(mbqResults.size()==1, "There should be 1 record in MercuryBillingQueue, but there are " + mbqResults.size() + "\n" + sqlStatement);
		
	} // end performDBChecksOnSecondOrderAfterOrderIsAccepted
	
	/**
	 * Perform DB checks on third order after order is accepted.
	 *
	 * @param driver the driver
	 * @param orderNumber the order number
	 * @param productItemID the product item ID
	 * @param vendorPaymentResponsibility the vendor payment responsibility
	 * @param orderFee the order fee
	 * @throws Exception the exception
	 */
	private void performDBChecksOnThirdOrderAfterOrderIsAccepted (RemoteWebDriver driver, String orderNumber, String productItemID, String vendorPaymentResponsibility, String orderFee) throws Exception {
		
		String sqlStatement = null;
		
		// Verify the VendorPaymentResponsibility
		db.verifyVendorPaymentResponsibilityID(driver, productItemID, vendorPaymentResponsibility);
		
		// Verify the price
		db.verifyPriceInProductItems(driver, productItemID, orderFee);
		
		// Verify the payment method
		db.verifyPaymentMethodInProductItems(driver, productItemID, "Deferred CC");
		
		// Verify there is an entry in MercuryOrderInformation
		sqlStatement = "SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED "
				+ "SELECT ProductItemID FROM Mercury.dbo.MercuryOrderInformation WHERE ProductItemID = " + productItemID;
		ArrayList<String> moiResults = db.queryDBArray(driver, "Mercury", sqlStatement);
		Assert.assertTrue(moiResults.size()==1, "There should be 1 record in MercuryOrderInformation, but there are " + moiResults.size() + "\n" + sqlStatement);
		
		// Verify 2 entries are written to MercuryBillingQueue
		sqlStatement = "SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED "
				+ "SELECT MercuryBillingQueueID FROM Mercury.dbo.MercuryBillingQueue WHERE LoanID = " + orderNumber;
		ArrayList<String> mbqResults = db.queryDBArray(driver, "Mercury", sqlStatement);
		Assert.assertTrue(mbqResults.size()==2, "There should be 2 records in MercuryBillingQueue, but there are " + mbqResults.size() + "\n" + sqlStatement);
		
	} // end performDBChecksOnThirdOrderAfterOrderIsAccepted
	
	/**
	 * Perform DB checks on second order after a payment has been made.
	 *
	 * @param driver the driver
	 * @param orderNumber the order number
	 * @throws Exception the exception
	 */
	private void performDBChecksAfterPaymentIsMadeOnSecondOrder (RemoteWebDriver driver, String orderNumber) throws Exception {
		
		// Verify an entry is written to MercuryOrderReceivables
		String sqlStatement = "SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED "
				+ "SELECT MercuryOrderReceivableID FROM CompanyData.dbo.MercuryOrderReceivables WHERE LoanID = " + orderNumber;
		ArrayList<String> morResults = db.queryDBArray(driver, "CompanyData", sqlStatement);
		Assert.assertTrue(morResults.size()==1, "There should be 1 record in CompanyData.dbo.MercuryOrderReceivables, but there are " + morResults.size() + "\n" + sqlStatement);
		
	} // end performDBChecksAfterPaymentIsMadeOnSecondOrder
	
	/**
	 * Perform DB checks on second order after a payment has been made.
	 *
	 * @param driver the driver
	 * @param orderNumber the order number
	 * @throws Exception the exception
	 */
	@SuppressWarnings("unused")
	private void performDBChecksAfterBillingProcessorRuns (RemoteWebDriver driver, String orderNumber) throws Exception {
		
		String sqlStatement = null;
		
		// Verify an entry is written to CompanyData.dbo.MercuryOrders
		sqlStatement = "SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED "
				+ "SELECT OrderNumber FROM CompanyData.dbo.MercuryOrders WHERE OrderNumber = " + orderNumber;
		ArrayList<String> moResults = db.queryDBArray(driver, "CompanyData", sqlStatement);
		Assert.assertTrue(moResults.size()==1, "There should be 1 record in CompanyData.dbo.MercuryOrders, but there are " + moResults.size() + "\n" + sqlStatement);
		
		// Verify an entry is written to CompanyData.dbo.MercuryLineItems
		sqlStatement = "SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED "
				+ "SELECT LoanID FROM CompanyData.dbo.MercuryLineItems WHERE LoanID = " + orderNumber;
		ArrayList<String> mliResults = db.queryDBArray(driver, "CompanyData", sqlStatement);
		Assert.assertTrue(mliResults.size()==1, "There should be 1 record in CompanyData.dbo.MercuryLineItems, but there are " + mliResults.size() + "\n" + sqlStatement);
		
		// Verify an entry is written to CompanyData.dbo.MercuryOrderPayments
		sqlStatement = "SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED "
				+ "SELECT OrderNumber FROM CompanyData.dbo.MercuryOrderPayments WHERE OrderNumber = " + orderNumber;
		ArrayList<String> mopResults = db.queryDBArray(driver, "CompanyData", sqlStatement);
		Assert.assertTrue(mopResults.size()==1, "There should be 1 record in CompanyData.dbo.MercuryOrderPayments, but there are " + mopResults.size() + "\n" + sqlStatement);
		
	} // end performDBChecksAfterBillingProcessorRuns
	
	/**
	 * Back date order to be picked up by the billing processor.
	 *
	 * @param driver the driver
	 * @param customerNumber the customer number
	 * @throws Exception the exception
	 */
	private void backDateOrder (RemoteWebDriver driver, String customerNumber) throws Exception {
		
		// Update MercuryBillingAccount
		String sqlStatement = "UPDATE dbo.MercuryBillingAccount " + 
				"SET NextBillingDate = CASE MercuryBillingTypeID WHEN 1 THEN CAST(getdate() as date) " + 
				"ELSE dateadd(dd, -day(getdate())+1, convert(varchar(10), getdate(), 101)) " + 
				"END " + 
				"WHERE CustomerNumber = "+customerNumber+" " + 
				"AND NextBillingDate > CAST(getdate() AS date)";
		db.updateDB(driver, "Mercury", sqlStatement);
		
		// Update MercuryBillingQueue
		String sqlStatement2 = "UPDATE mbq " + 
				"SET LastStatusUpdate = dateadd(dd, datediff(dd, LastStatusUpdate, getdate())-1, LastStatusUpdate), " + 
				"EnteredStamp = dateadd(dd, datediff(dd, EnteredStamp, getdate())-1, EnteredStamp), " + 
				"MercuryBillingStatusID	= CASE mbq.MercuryBillingStatusID WHEN 16 THEN 1 ELSE mbq.MercuryBillingStatusID END " + 
				"FROM dbo.MercuryBillingQueue mbq " + 
				"INNER JOIN dbo.MercuryBillingAccount mba ON mba.MercuryBillingAccountID = mbq.MercuryBillingAccountID " + 
				"WHERE mba.CustomerNumber = "+customerNumber+" " + 
				"AND mbq.MercuryBillingStatusID	IN ( 1, 2, 16, 18 ) " + 
				"AND LastStatusUpdate > CONVERT(varchar(30), getdate(), 1)";
		db.updateDB(driver, "Mercury", sqlStatement2);
		
	} // end backDateOrder
	
	/**
	 * Back date order to be picked up by the billing processor.
	 *
	 * @param driver the driver
	 * @throws IOException 
	 */
	@SuppressWarnings("unused")
	private void runBillingProcessor (RemoteWebDriver driver) throws IOException {
		
		// Run the billing processor
		Runtime.getRuntime().exec(StoredVariables.getuserDir().get() + "\\src\\main\\resources\\ExecuteVendorPaymentProcessor.bat");
		
	} // end runBillingProcessor
	
} // end the SecurePaymentMethods class