package systemsCheck;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Secure.SOrders;
import pageObjects.VMP.VMPOrders;
import pageObjects.Vendors.VOrders;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Systems Check</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class SystemsCheck extends TestSetup {
	
	/** The user secure. */
	private final String userSecure = "PostBuild1";
	
	/** The user VMP. */
	private final String userVMP = "OriginatorPostBuild1";
	
	/** The user vendors. */
	private final String userVendors = "PostBuildAppraiser1";
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set environment variables</li>
	 * 	<li>Go to the VMP Client portal and sign in</li>
	 * 	<li>Verify login succeeded</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={}, alwaysRun=true)
	public void vmpQA() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		String password = StoredVariables.getpassword().get();
		
		// Set environment variables
		StoredVariables.getusernameEnvironment().set("QA");
		StoredVariables.getenvironment().set("QA");
		
		// Go to the VMP Client portal and sign in
		vmp.login(driver, userSecure, userVMP, password, "QA");
		
		// Verify login succeeded
		Assert.assertTrue(VMPOrders.find_txtbx(driver).isDisplayed(), "The Find textbox did not load on VMP QA");
		
		// Log test
		test.log(LogStatus.INFO, "Systems Check", "Verified that you can login to VMP QA");
		
	} // end vmpQA
	
//	/**
//	 * <p>
//	 * STEPS:
//	 * <ul>
//	 * 	<li>Set environment variables</li>
//	 * 	<li>Go to the VMP Client portal and sign in</li>
//	 * 	<li>Verify login succeeded</li>
//	 * 	<li>Log test</li>
//* </ul>
//	 *
//	 * @throws Exception the exception
//	 */
//	@Test (retryAnalyzer = Retry.class, groups={}, alwaysRun=true)
//	public void vmpBeta() throws Exception{
//		
//		ExtentTest test = ExtentTestManager.getTest();
//		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
//		
//		String password = StoredVariables.getpassword().get();
//		
//		// Set environment variables
//		StoredVariables.getusernameEnvironment().set("Beta");
//		StoredVariables.getenvironment().set("Beta");
//		
//		// Go to the VMP Client portal and sign in
//		vmp.login(driver, userSecure, userVMP, password, "Beta");
//		
//		// Verify login succeeded
//		Assert.assertTrue(VMPOrders.find_txtbx(driver).isDisplayed(), "The Find textbox did not load on VMP Beta");
//		
//		// Log test
//		test.log(LogStatus.INFO, "Systems Check", "Verified that you can login to VMP Beta");
//		
//	} // end vmpBeta
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set environment variables</li>
	 * 	<li>Go to the VMP Client portal and sign in</li>
	 * 	<li>Verify login succeeded</li>
	 * 	<li>Log test</li>
* </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={}, alwaysRun=true)
	public void vmpLive() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		String password = StoredVariables.getpassword().get();
		
		// Set environment variables
		StoredVariables.getusernameEnvironment().set("Live");
		StoredVariables.getenvironment().set("Live");
		
		// Go to the VMP Client portal and sign in
		vmp.login(driver, userSecure, userVMP, password, "Live");
		
		// Verify login succeeded
		Assert.assertTrue(VMPOrders.find_txtbx(driver).isDisplayed(), "The Find textbox did not load on VMP Live");
		
		// Log test
		test.log(LogStatus.INFO, "Systems Check", "Verified that you can login to VMP Live");
		
	} // end vmpLive
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set environment variables</li>
	 * 	<li>Go to the VMP Client portal and sign in</li>
	 * 	<li>Verify login succeeded</li>
	 * 	<li>Log test</li>
* </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={}, alwaysRun=true)
	public void secureQA() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		String password = StoredVariables.getpassword().get();
		
		// Set environment variables
		StoredVariables.getusernameEnvironment().set("QA");
		StoredVariables.getenvironment().set("QA");
		
		// Go to the VMP Client portal and sign in
		secure.login(driver, userSecure, password, "QA");
		
		// Verify login succeeded
		Assert.assertTrue(SOrders.find_txtbx(driver).isDisplayed(), "The Find textbox did not load on Secure QA");
		
		// Log test
		test.log(LogStatus.INFO, "Systems Check", "Verified that you can login to Secure QA");
		
	} // end secureQA
	
//	/**
//	 * <p>
//	 * STEPS:
//	 * <ul>
//	 * 	<li>Set environment variables</li>
//	 * 	<li>Go to the VMP Client portal and sign in</li>
//	 * 	<li>Verify login succeeded</li>
//	 * 	<li>Log test</li>
//* </ul>
//	 *
//	 * @throws Exception the exception
//	 */
//	@Test (retryAnalyzer = Retry.class, groups={}, alwaysRun=true)
//	public void secureBeta() throws Exception{
//		
//		ExtentTest test = ExtentTestManager.getTest();
//		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
//		
//		String password = StoredVariables.getpassword().get();
//		
//		// Set environment variables
//		StoredVariables.getusernameEnvironment().set("Beta");
//		StoredVariables.getenvironment().set("Beta");
//		
//		// Go to the VMP Client portal and sign in
//		secure.login(driver, userSecure, password, "Beta");
//		
//		// Verify login succeeded
//		Assert.assertTrue(SOrders.find_txtbx(driver).isDisplayed(), "The Find textbox did not load on Secure Beta");
//		
//		// Log test
//		test.log(LogStatus.INFO, "Systems Check", "Verified that you can login to Secure Beta");
//		
//	} // end secureBeta
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set environment variables</li>
	 * 	<li>Go to the VMP Client portal and sign in</li>
	 * 	<li>Verify login succeeded</li>
	 * 	<li>Log test</li>
* </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={}, alwaysRun=true)
	public void secureLive() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		String password = StoredVariables.getpassword().get();
		
		// Set environment variables
		StoredVariables.getusernameEnvironment().set("Live");
		StoredVariables.getenvironment().set("Live");
		
		// Go to the VMP Client portal and sign in
		secure.login(driver, userSecure, password, "Live");
		
		// Verify login succeeded
		Assert.assertTrue(SOrders.find_txtbx(driver).isDisplayed(), "The Find textbox did not load on Secure Live");
		
		// Log test
		test.log(LogStatus.INFO, "Systems Check", "Verified that you can login to Secure Live");
		
	} // end secureLive
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set environment variables</li>
	 * 	<li>Go to the VMP Client portal and sign in</li>
	 * 	<li>Verify login succeeded</li>
	 * 	<li>Log test</li>
* </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={}, alwaysRun=true)
	public void vendorsQA() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		String password = StoredVariables.getpassword().get();
		
		// Set environment variables
		StoredVariables.getusernameEnvironment().set("QA");
		StoredVariables.getenvironment().set("QA");
		
		// Go to the VMP Client portal and sign in
		vendors.login(driver, userVendors, password, "QA");
		
		// Verify login succeeded
		Assert.assertTrue(VOrders.find_txtbx(driver).isDisplayed(), "The Find textbox did not load on Vendors QA");
		
		// Log test
		test.log(LogStatus.INFO, "Systems Check", "Verified that you can login to Vendors QA");
		
	} // end vendorsQA
	
//	/**
//	 * <p>
//	 * STEPS:
//	 * <ul>
//	 * 	<li>Set environment variables</li>
//	 * 	<li>Go to the VMP Client portal and sign in</li>
//	 * 	<li>Verify login succeeded</li>
//	 * 	<li>Log test</li>
//* </ul>
//	 *
//	 * @throws Exception the exception
//	 */
//	@Test (retryAnalyzer = Retry.class, groups={}, alwaysRun=true)
//	public void vendorsBeta() throws Exception{
//		
//		ExtentTest test = ExtentTestManager.getTest();
//		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
//		
//		String password = StoredVariables.getpassword().get();
//		
//		// Set environment variables
//		StoredVariables.getusernameEnvironment().set("Beta");
//		StoredVariables.getenvironment().set("Beta");
//		
//		// Go to the VMP Client portal and sign in
//		vendors.login(driver, userVendors, password, "Beta");
//		
//		// Verify login succeeded
//		Assert.assertTrue(VOrders.find_txtbx(driver).isDisplayed(), "The Find textbox did not load on Vendors Beta");
//		
//		// Log test
//		test.log(LogStatus.INFO, "Systems Check", "Verified that you can login to Vendors Beta");
//		
//	} // end vendorsBeta
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set environment variables</li>
	 * 	<li>Go to the VMP Client portal and sign in</li>
	 * 	<li>Verify login succeeded</li>
	 * 	<li>Log test</li>
* </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={}, alwaysRun=true)
	public void vendorsLive() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		String password = StoredVariables.getpassword().get();
		
		// Set environment variables
		StoredVariables.getusernameEnvironment().set("Live");
		StoredVariables.getenvironment().set("Live");
		
		// Go to the VMP Client portal and sign in
		vendors.login(driver, userVendors, password, "Live");
		
		// Verify login succeeded
		Assert.assertTrue(VOrders.find_txtbx(driver).isDisplayed(), "The Find textbox did not load on Vendors Live");
		
		// Log test
		test.log(LogStatus.INFO, "Systems Check", "Verified that you can login to Vendors Live");
		
	} // end vendorsLive
	
} // end the SystmesCheck class
