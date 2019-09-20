package utils;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import pageObjects.Overlay.Overlay;
import pageObjects.Payments.MakeAPaymentSearch;
import pageObjects.Payments.MakeAPaymentSelect;
import pageObjects.Payments.PProvidePaymentInfo;
import pageObjects.Secure.SAccount;
import pageObjects.Secure.SAppraisalQualityManagementSettings;
import pageObjects.Secure.SChangeFee;
import pageObjects.Secure.SClients;
import pageObjects.Secure.SClients_ClientGroups;
import pageObjects.Secure.SClients_OrderRouting;
import pageObjects.Secure.SConfirmOrder;
import pageObjects.Secure.SConnectionSettings;
import pageObjects.Secure.SDataCourier;
import pageObjects.Secure.SDataCourierUploadPDF;
import pageObjects.Secure.SExpiredDueDate;
import pageObjects.Secure.SFeePanel;
import pageObjects.Secure.SLogin;
import pageObjects.Secure.SModifySelectionSettings;
import pageObjects.Secure.SNewAltValOrder;
import pageObjects.Secure.SNewOrder;
import pageObjects.Secure.SOrderDetails;
import pageObjects.Secure.SOrders;
import pageObjects.Secure.SPayments;
import pageObjects.Secure.SPreferences;
import pageObjects.Secure.SProductRequirements;
import pageObjects.Secure.SProfile;
import pageObjects.Secure.SQVPOrderDetails;
import pageObjects.Secure.SReports;
import pageObjects.Secure.SReviewBids;
import pageObjects.Secure.SSetOrderStatus;
import pageObjects.Secure.SSignUp;
import pageObjects.Secure.SSubmitToUCDP;
import pageObjects.Secure.SUARR;
import pageObjects.Secure.SUsers;
import pageObjects.Secure.SVMPXSites;
import pageObjects.Secure.SVMPXSitesBusinessManagement;
import pageObjects.Secure.SVendorAssignment;
import pageObjects.Secure.SVendorSelection;
import pageObjects.Secure.SVendorSelectionSettings;
import pageObjects.XSite.XBusinessManagement;
import pageObjects.XSite.XChargeCard;
import pageObjects.XSite.XInvoice;
import pageObjects.XSite.XOrders;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import setup.TestSetup;

// TODO: Auto-generated Javadoc
/**
 * <h1>Function_Secure</h1>
 * These are functions that are specific to the Secure environment.
 *
 * @author  Dustin Norman
 * @since   05-10-2018
 */

@Listeners(utils.Listener.class)
public class Function_Secure extends TestSetup {

	/**
	 * Login to Secure
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to Secure</li>
	 * 	<li>Enter username</li>
	 * 	<li>Enter password</li>
	 * 	<li>Ensure the username was entered correctly, if not, clear it out and re-enter it</li>
	 * 	<li>Ensure the password length entered matches the expected password length</li>
	 * 	<li>Click Sign In button</li>
	 * 	<li>Verify you are on the correct page</li>
	 * 	<li>Clear any dialogs that appear</li>
	 * </ul>
	 * @param driver the driver
	 * @param user This is the email address used to login. If the String that gets passed in does NOT have an {@literal @}
	 * included, the automation user's naming convention will be used which is "automation" + environment + user + {@literal @}dntest.net
	 * @param password This is the user's password
	 * @throws Exception the exception
	 */
	public void login(RemoteWebDriver driver, String user, String password) throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		String env = StoredVariables.getusernameEnvironment().get();
		String catchAllDomain = StoredVariables.getcatchAllDomain().get();
		int passwordLength = password.length();
		
		// Go to login page
		String url = StoredVariables.getsecureSite().get();
		driver.get(url);
		
		// Make sure you are on the login screen
		if (!driver.getCurrentUrl().equals(url)) {
			driver.get(url);
		} // end if
		
		// Wait for email txtbx
		perform.waitForElementToBeClickable(driver, SLogin.email_txtbx(), "id");
		
		// Enter email
		if (!user.contains("@")) {
			user = "automation" + env + user + catchAllDomain;
		} // end if
		perform.type(driver, SLogin.email_txtbx(driver), user);
		
		// Enter Password
		perform.type(driver, SLogin.password_txtbx(driver), password);
		
		System.out.println("Log in to Secure as user: " + user);
		System.out.println("Password: " + password);
		
		// Ensure the username is entered correctly
		int u = 1;
		String enteredUser = SLogin.email_txtbx(driver).getAttribute("value");
		while (!enteredUser.equals(user) && u <= 10) {
			perform.type(driver, SLogin.email_txtbx(driver), user);
			Thread.sleep(1500);
			enteredUser = SLogin.email_txtbx(driver).getAttribute("value");
			System.out.println("enteredUser: " + enteredUser);
			u++;
		} // end while
		
		// Ensure the password length is correct
		int p = 1;
		String enteredPassword = SLogin.password_txtbx(driver).getAttribute("value");
		while(enteredPassword.length() != passwordLength && p <= 10) {
			perform.type(driver, SLogin.password_txtbx(driver), password);
			Thread.sleep(1500);
			enteredPassword = SLogin.password_txtbx(driver).getAttribute("value");
			System.out.println("enteredPassword: " + enteredPassword);
		} // end while
		
		// Click Sign In
		perform.click(driver, SLogin.signIn_btn(driver));
		
		// Wait for Find textbox
		perform.waitForElementToBeClickable(driver, SOrders.find_txtbx(), "id");
		
		// Verify successful login
		Assert.assertTrue(driver.getTitle().equals("Orders"));
		Assert.assertTrue(driver.getCurrentUrl().contains("Orders.aspx"));
		
		// Check for overlay if it is the first time the page is opened since run
		try
		{
			// Click Find textbox
			perform.click(driver, SOrders.find_txtbx(driver));
		} // end try
		catch (Exception e) {
			try
			{
			// Close overlay
			perform.waitForElementToBeClickable(driver, SOrders.closeOverlay_btn(), "cssSelector");
			perform.click(driver, SOrders.closeOverlay_btn(driver));
			} // end try
			catch (Exception e1) {
				try {
					perform.click(driver, SOrders.no_btn(driver));
				} catch (Exception e2) {
					// Clear Update Payment Method dialog
					perform.click(driver, SOrders.noUpdatePaymentMethod_btn(driver));
					test.log(LogStatus.WARNING, "Log In", "There is a payment method issue for this user");
				} // end try/catch
			} // end try/catch
		} // end catch
		
		// Get the customer number to add to extent reports
		String customerNumber = db.getCustomerNumber(driver, user);
		
		// Log the user logged in
		test.log(LogStatus.INFO, "Log In", "Loggged in to Secure<br>URL: <a href=\"" + url + "\">" + url + "</a><br>User: " + user + "<br>Password: " + password + "<br>Customer Number: " + customerNumber);
		
	} // end login to secure site
	
	/**
	 * Login to Secure
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to Secure</li>
	 * 	<li>Enter username</li>
	 * 	<li>Enter password</li>
	 * 	<li>Ensure the username was entered correctly, if not, clear it out and re-enter it</li>
	 * 	<li>Ensure the password length entered matches the expected password length</li>
	 * 	<li>Click Sign In button</li>
	 * 	<li>Verify you are on the correct page</li>
	 * 	<li>Clear any dialogs that appear</li>
	 * </ul>
	 * @param driver the driver
	 * @param user This is the email address used to login. If the String that gets passed in does NOT have an {@literal @}
	 * included, the automation user's naming convention will be used which is "automation" + environment + user + {@literal @}dntest.net
	 * @param password This is the user's password
	 * @param env This allows you to specify an environment to log in to
	 * @throws Exception the exception
	 */
	public void login(RemoteWebDriver driver, String user, String password, String env) throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		String catchAllDomain = StoredVariables.getcatchAllDomain().get();
		int passwordLength = password.length();
		
		// Go to login page
		StoredVariables.getsecureSite().set(perform.getSecureSite(env));
		String url = StoredVariables.getsecureSite().get();
		driver.get(url);
		
		// Wait for email txtbx
		perform.waitForElementToBeClickable(driver, SLogin.email_txtbx(), "id");
		
		// Enter email
		if (!user.contains("@")) {
			user = "automation" + env + user + catchAllDomain;
		} // end if
		perform.type(driver, SLogin.email_txtbx(driver), user);
		
		// Enter Password
		perform.type(driver, SLogin.password_txtbx(driver), password);
		
		System.out.println("Log in to Secure as user: " + user);
		System.out.println("Password: " + password);
		
		// Ensure the username is entered correctly
		int u = 1;
		String enteredUser = SLogin.email_txtbx(driver).getAttribute("value");
		while (!enteredUser.equals(user) && u <= 10) {
			perform.type(driver, SLogin.email_txtbx(driver), user);
			Thread.sleep(1500);
			enteredUser = SLogin.email_txtbx(driver).getAttribute("value");
			System.out.println("enteredUser: " + enteredUser);
			u++;
		} // end while
		
		// Ensure the password length is correct
		int p = 1;
		String enteredPassword = SLogin.password_txtbx(driver).getAttribute("value");
		while(enteredPassword.length() != passwordLength && p <= 10) {
			perform.type(driver, SLogin.password_txtbx(driver), password);
			Thread.sleep(1500);
			enteredPassword = SLogin.password_txtbx(driver).getAttribute("value");
			System.out.println("enteredPassword: " + enteredPassword);
		} // end while
		
		// Click Sign In
		perform.click(driver, SLogin.signIn_btn(driver));
		
		// Wait for Find textbox
		perform.waitForElementToBeClickable(driver, SOrders.find_txtbx(), "id");
		
		// Verify successful login
		Assert.assertTrue(driver.getTitle().equals("Orders"));
		Assert.assertTrue(driver.getCurrentUrl().contains("Orders.aspx"));
		
		// Check for overlay if it is the first time the page is opened since run
		try
		{
			// Click Find textbox
			perform.click(driver, SOrders.find_txtbx(driver));
		} // end try
		catch (Exception e) {
			try
			{
			// Close overlay
			perform.waitForElementToBeClickable(driver, SOrders.closeOverlay_btn(), "cssSelector");
			perform.click(driver, SOrders.closeOverlay_btn(driver));
			} // end try
			catch (Exception e1) {
				try {
					perform.click(driver, SOrders.no_btn(driver));
				} catch (Exception e2) {
					// Clear Update Payment Method dialog
					perform.click(driver, SOrders.noUpdatePaymentMethod_btn(driver));
					test.log(LogStatus.WARNING, "Log In", "There is a payment method issue for this user");
				} // end try/catch
			} // end try/catch
		} // end catch
		
		// Get the customer number to add to extent reports
		String customerNumber = db.getCustomerNumber(driver, user);
		
		// Log the user logged in
		test.log(LogStatus.INFO, "Log In", "Loggged in to Secure<br>URL: <a href=\"" + url + "\">" + url + "</a><br>User: " + user + "<br>Password: " + password + "<br>Customer Number: " + customerNumber);
		
	} // end login to secure site
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to login page</li>
	 * 	<li>Enter email</li>
	 * 	<li>Enter Password</li>
	 * 	<li>Ensure the username is entered correctly</li>
	 * 	<li>Ensure the password length is correct</li>
	 * 	<li>Click Sign In</li>
	 * 	<li>Close dialog</li>
	 * 	<li>Close the dialog</li>
	 * 	<li>Click continue to Mercury network</li>
	 * 	<li>Close the dialog</li>
	 * 	<li>Close the dialog</li>
	 * 	<li>Click the I Agree radio button</li>
	 * 	<li>Select I Agree</li>
	 * 	<li>Click Continue</li>
	 * 	<li>Verify successful login</li>
	 * 	<li>Get the customer number to add to extent reports</li>
	 * 	<li>Log the user logged in</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param user the user
	 * @param password the password
	 * @param env the env
	 * @throws Exception the exception
	 */
	// Login for the first time to secure site
	public void loginFirstTime(RemoteWebDriver driver, String user, String password, String env) throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		String catchAllDomain = StoredVariables.getcatchAllDomain().get();
		int passwordLength = password.length();
		
		// Go to login page
		StoredVariables.getsecureSite().set(perform.getSecureSite(env));
		String url = StoredVariables.getsecureSite().get();
		driver.get(url);
		
		// Wait for email txtbx
		perform.waitForElementToBeClickable(driver, SLogin.email_txtbx(), "id");
		
		// Enter email
		if (!user.contains("@")) {
			user = "automation" + env + user + catchAllDomain;
		} // end if
		perform.type(driver, SLogin.email_txtbx(driver), user);
		
		// Enter Password
		perform.type(driver, SLogin.password_txtbx(driver), password);
		
		System.out.println("Log in to Secure as user: " + user);
		System.out.println("Password: " + password);
		
		// Ensure the username is entered correctly
		int u = 1;
		String enteredUser = SLogin.email_txtbx(driver).getAttribute("value");
		while (!enteredUser.equals(user) && u <= 10) {
			perform.type(driver, SLogin.email_txtbx(driver), user);
			Thread.sleep(1500);
			enteredUser = SLogin.email_txtbx(driver).getAttribute("value");
			System.out.println("enteredUser: " + enteredUser);
			u++;
		} // end while
		
		// Ensure the password length is correct
		int p = 1;
		String enteredPassword = SLogin.password_txtbx(driver).getAttribute("value");
		while(enteredPassword.length() != passwordLength && p <= 10) {
			perform.type(driver, SLogin.password_txtbx(driver), password);
			Thread.sleep(1500);
			enteredPassword = SLogin.password_txtbx(driver).getAttribute("value");
			System.out.println("enteredPassword: " + enteredPassword);
		} // end while
		
		// Click Sign In
		perform.click(driver, SLogin.signIn_btn(driver));
		
		// Close dialog
		try {
			// Close the dialog
			perform.click(driver, driver.findElement(By.cssSelector("img[src='/images/DialogCloseButton.png']")));
		}
		catch(Exception e){}
		
		// Click continue to Mercury network
		try{
			perform.click(driver, driver.findElement(By.id("lnkContinueAppraiser")));
		}
		catch (Exception e){}
		
		// Close the dialog
		try {
			// Close the dialog
			perform.click(driver, driver.findElement(By.cssSelector("img[src='/images/DialogCloseButton.png']")));
		} catch (Exception e) {}
		
		// Click the I Agree radio button
		try{
			
			// Select I Agree
			perform.click(driver, SSignUp.iAgree_radiobtn(driver));
			
			// Click Continue
			perform.click(driver, SSignUp.continue_btn(driver));
			
		}
		catch (Exception e) {}
		
		// Wait for Find textbox
		perform.waitForElementToBeClickable(driver, SOrders.find_txtbx(), "id");
		
		// Verify successful login
		Assert.assertTrue(driver.getTitle().equals("Orders"));
		Assert.assertTrue(driver.getCurrentUrl().contains("Orders.aspx"));
		
		// Get the customer number to add to extent reports
		String customerNumber = db.getCustomerNumber(driver, user);
		
		// Log the user logged in
		test.log(LogStatus.INFO, "Log In", "Loggged in to Secure<br>URL: <a href=\"" + url + "\">" + url + "</a><br>User: " + user + "<br>Password: " + password + "<br>Customer Number: " + customerNumber);
		
	} // end login for the first time to secure site
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to the Orders page</li>
	 * 	<li>Click New</li>
	 * 	<li>Click Residential Appraisal</li>
	 * 	<li>Click New</li>
	 * 	<li>Click Residential Appraisal</li>
	 * 	<li>Verify url</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	// Go to New Residential Appraisal
	public void goToResidentialAppraisal(RemoteWebDriver driver) throws IOException, InterruptedException
	{
		
		ExtentTest test = ExtentTestManager.getTest();
		
		System.out.println("Go to New > Residential Appraisal");
		
		// Go to the Orders page
		perform.clickInTable_Contains(driver, "Orders");
		
		if (StoredVariables.getbrowser().get().equals("Chrome"))
		{
			Thread.sleep(500);	
		}
		
		// Wait for Find textbox
		perform.waitForElementToBeClickable(driver, SOrders.find_txtbx(), "id");
		
		// Click New
		perform.clickInTable_Contains(driver, "New");
		
		// Click Residential Appraisal
		try {
			perform.clickInTable_Contains(driver, "Residential appraisal");
		} catch (Exception e) {
			// Click New
			perform.clickInTable_Contains(driver, "New");
			
			// Click Residential Appraisal
			perform.clickInTable_Contains(driver, "Residential appraisal");
		}
		
		// Wait for address text box
		perform.waitForElementToBeClickable(driver, SNewOrder.address_txtbx(), "id");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().contains("Admin/NewOrder/NewOrder.aspx?PID=0&t=1"), "The url is incorrect");
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Navigation", "Navigated to new Residential Appraisal order");
		
	} // end goToNewResidentialAppraisal
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to the Orders page</li>
	 * 	<li>Click New</li>
	 * 	<li>Click Commercial Appraisal</li>
	 * 	<li>Verify url</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	// Go to New Commercial Appraisal
	public void goToCommercialAppraisal(RemoteWebDriver driver) throws IOException, InterruptedException
	{
		
		System.out.println("Go to New > Commercial Appraisal");
		
		ExtentTest test = ExtentTestManager.getTest();
		
		// Go to the Orders page
		perform.clickInTable_Contains(driver, "Orders");
		
		if (StoredVariables.getbrowser().get().equals("Chrome"))
		{
			Thread.sleep(500);	
		}
		
		// Wait for Find textbox
		perform.waitForElementToBeClickable(driver, SOrders.find_txtbx(), "id");
		
		// Click New
		perform.clickInTable_Contains(driver, "New");
		
		// Click Commercial Appraisal
		perform.clickInTable_Contains(driver, "Commercial appraisal");
		
		// Wait for address text box
		perform.waitForElementToBeClickable(driver, SNewOrder.address_txtbx(), "id");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().contains("Admin/NewOrder/NewOrder.aspx?PID=0&t=5"), "The url is incorrect");
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Navigation", "Navigated to new Commercial Appraisal order");
		
	} // end goToNewCommercialAppraisalOnSecure
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to the Orders page</li>
	 * 	<li>Click New</li>
	 * 	<li>Click Inspection</li>
	 * 	<li>Verify url</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	// Go to Inspection
	public void goToInspection(RemoteWebDriver driver) throws IOException, InterruptedException
	{
		
		System.out.println("Go to New > Inspection");
		
		ExtentTest test = ExtentTestManager.getTest();
		
		// Go to the Orders page
		perform.clickInTable_Contains(driver, "Orders");
		
		if (StoredVariables.getbrowser().get().equals("Chrome"))
		{
			Thread.sleep(500);	
		}
		
		// Wait for Find textbox
		perform.waitForElementToBeClickable(driver, SOrders.find_txtbx(), "id");
		
		// Click New
		perform.clickInTable_Contains(driver, "New");
		
		// Click Inspection
		perform.clickInTable_Contains(driver, "Inspection");
		
		// Wait for address text box
		perform.waitForElementToBeClickable(driver, SNewOrder.address_txtbx(), "id");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().contains("Admin/NewOrder/NewOrder.aspx?PID=0&t=4"), "The url is incorrect");
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Navigation", "Navigated to new Inspection order");
		
	} // end goToInspectionOnSecure
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to the Orders page</li>
	 * 	<li>Click New</li>
	 * 	<li>Click Broker Price Opinion</li>
	 * 	<li>Verify url</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	// Go to Broker Price Opinion
	public void goToBrokerPriceOpinion(RemoteWebDriver driver) throws IOException, InterruptedException
	{
		
		System.out.println("Go to New > Broker Price Opinion");
		
		ExtentTest test = ExtentTestManager.getTest();
		
		// Go to the Orders page
		perform.clickInTable_Contains(driver, "Orders");
		
		if (StoredVariables.getbrowser().get().equals("Chrome"))
		{
			Thread.sleep(500);	
		}
		
		// Wait for Find textbox
		perform.waitForElementToBeClickable(driver, SOrders.find_txtbx(), "id");
		
		// Click New
		perform.clickInTable_Contains(driver, "New");
		
		// Click Broker Price Opinion
		perform.clickInTable_Contains(driver, "Broker Price Opinion");
		
		// Wait for address text box
		perform.waitForElementToBeClickable(driver, SNewOrder.address_txtbx(), "id");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().contains("Admin/NewOrder/NewOrder.aspx?PID=0&t=6"), "The url is incorrect");
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Navigation", "Navigated to new Broker Price Opinion order");
		
	} // end goToBrokerPriceOpinionOnSecure
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to the Orders page</li>
	 * 	<li>Click New</li>
	 * 	<li>Click Alternative Valuations</li>
	 * 	<li>Verify url for OptiVal AVM cascade order</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	// Go to OptiVal AVM Cascade
	public void goToAlternativeValuations(RemoteWebDriver driver) throws IOException, InterruptedException
	{
		
		System.out.println("Go to New > Alternative Valuations");
		
		ExtentTest test = ExtentTestManager.getTest();
		
		// Go to the Orders page
		perform.clickInTable_Contains(driver, "Orders");
		
		if (StoredVariables.getbrowser().get().equals("Chrome"))
		{
			Thread.sleep(500);	
		}
		
		// Wait for Find textbox
		perform.waitForElementToBeClickable(driver, SOrders.find_txtbx(), "id");
		
		// Click New
		perform.clickInTable_Contains(driver, "New");
		
		// Click Alternative Valuations
		perform.clickInTable_Contains(driver, "Alternative Valuations");
		
		// Wait for Product dropdown
		perform.waitForElementToBeClickable(driver, SNewAltValOrder.product_dropdown(driver));
		
		// Verify url for OptiVal AVM cascade order
		Assert.assertTrue(driver.getCurrentUrl().contains("NewAltValOrder.aspx"), "The url is incorrect for Alternative Valuations");
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Navigation", "Navigated to new Optival AVM Cascade order");
		
	} // end goToAlternativeValuationsOnSecure
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click on Data Courier</li>
	 * 	<li>Verify url</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	// Go to Data Courier
	public void goToDataCourier(RemoteWebDriver driver) throws IOException, InterruptedException
	{
		
		System.out.println("Go to Data Courier");
		
		ExtentTest test = ExtentTestManager.getTest();
		
		// Click on Data Courier
		perform.click(driver, SOrders.dataCourier_btn(driver));
		
		// Wait for the New File button 
		perform.waitForElementToBeClickable(driver, SDataCourier.newFile_btn(), "cssSelector");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().contains("DataCourier/Orders.aspx"), "The url is incorrect");
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Navigation", "Navigated to the Data Courier page");
		
	} // end goToDataCourier
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click Orders</li>
	 * 	<li>Verify url</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	// Go to Orders
	public void goToOrders(RemoteWebDriver driver) throws IOException, InterruptedException
	{
		
		System.out.println("Go to Orders");
		
		ExtentTest test = ExtentTestManager.getTest();
		
		// Click Orders
		perform.click(driver, SOrders.orders_btn(driver));
		
		if (StoredVariables.getbrowser().get().equals("Chrome"))
		{
			Thread.sleep(500);	
		}
		
		// Wait for Find textbox
		perform.waitForElementToBeClickable(driver, SOrders.find_txtbx(), "id");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().contains("Admin/OrderManagement/Orders.aspx"), "The url is incorrect");
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Navigation", "Navigated to the Orders page");
		
	} // end goToOrders
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click Fee Panel</li>
	 * 	<li>Verify url</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	// Go to Fee Panel
	public void goToFeePanel(RemoteWebDriver driver) throws IOException, InterruptedException
	{
		
		System.out.println("Go to Fee Panel");
		
		ExtentTest test = ExtentTestManager.getTest();
		
		// Click Fee Panel
		perform.click(driver, SOrders.feePanel_btn(driver));
		
		// Wait for Fee Panel tab
		perform.waitForElementToBeClickable(driver, SFeePanel.appraiserFeePanel_tab(), "id");
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().contains("Admin/feepanel/feepanel.aspx"), "The url is incorrect");
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Navigation", "Navigated to the Fee Panel page");
		
	} // end goToFeePanel
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click Fee Panel</li>
	 * 	<li>Verify url</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	// Go to Clients
	public void goToClients(RemoteWebDriver driver) throws IOException, InterruptedException
	{
		
		System.out.println("Go to Clients");
		
		ExtentTest test = ExtentTestManager.getTest();
		
		// Click Clients
		perform.click(driver, SOrders.clients_btn(driver));
		
		// Wait for Add button
		perform.waitForElementToBeClickable(driver, SClients.add_btn(), "cssSelector");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().contains("Admin/ClientManagement/Contacts.aspx"), "The url is incorrect");
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Navigation", "Navigated to the Clients page");
		
	} // end goToClients
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click Fee Panel</li>
	 * 	<li>Verify url</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	// Go to Clients
	public void goToManageClientGroups(RemoteWebDriver driver) throws IOException, InterruptedException
	{
		
		System.out.println("Go to Manage Client Groups");
		
		// Go to Clients
		secure.goToClients(driver);
		
		// Click Client Groups
		perform.click(driver, SClients.clientGroups_btn(driver));
		
		// Click Manage Client Groups
		perform.clickInDiv_Contains(driver, "Manage Client Groups...");
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Switch into iFrame
		perform.switchToiFrameByID(driver, "frameDialogL1");
		
		// Add info to Extent Report
		perform.addInfoToExtentReport(driver, "Navigation", "Navigated to the Manage Client Groups dialog");
		
	} // end goToManageClientGroups
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click UARR</li>
	 * 	<li>Verify url</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	// Go to UARR
	public void goToUARR(RemoteWebDriver driver) throws IOException, InterruptedException
	{
		
		System.out.println("Go to UARR");
		
		ExtentTest test = ExtentTestManager.getTest();
		
		// Click UARR
		perform.click(driver, SOrders.uarr_btn(driver));
		
		// Wait for New Card radio button
		perform.waitForElementToBeClickable(driver, SUARR.restore_btn(), "cssSelector");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().contains("Admin/UARR/ReviewRules.aspx"), "The url is incorrect");
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Navigation", "Navigated to the UARR page");
		
	} // end goToUARR
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click on Users</li>
	 * 	<li>Verify url</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	// Go to Users
	public void goToUsers(RemoteWebDriver driver) throws IOException, InterruptedException
	{
		
		System.out.println("Go to Users");
		
		ExtentTest test = ExtentTestManager.getTest();
		
		// Click on Users
		perform.click(driver, SOrders.users_btn(driver));
		
		// Wait for Save button
		perform.waitForElementToBeClickable(driver, SUsers.save_btn(), "cssSelector");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().contains("Admin/UserManagement/UserManagement.aspx"), "The url is incorrect");
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Navigation", "Navigated to the Users page");
		
	} // end goToUsers
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click Account</li>
	 * 	<li>Verify page text</li>
	 * 	<li>Verify url</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	// Go to Account
	public void goToAccount(RemoteWebDriver driver) throws IOException, InterruptedException
	{
		
		System.out.println("Go to Account");
		
		ExtentTest test = ExtentTestManager.getTest();
		
		// Click Account
		perform.click(driver, SOrders.account_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Wait for require strong password checkbox
		perform.waitForElementToBeClickable(driver, SAccount.page_txt(driver));
		
		// Verify page text
		String pageText = SAccount.page_txt(driver).getText();
		Assert.assertTrue(pageText.contains("Review pending, unpaid, and yearly invoice information for Mercury Network order activity below."), "Account page is missing text");
		Assert.assertTrue(pageText.contains("Find helpful information about Mercury Network products below."), "Account page is missing text");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().contains("AccountManagement/Account.aspx"), "The url is incorrect");
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Navigation", "Navigated to the Account page");
		
	} // end goToAccount
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click Payments</li>
	 * 	<li>if the Payments button cannot be clicked, go to the Payments URL</li>
	 * 	<li>Verify url</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	// Go to Payments
	public void goToPayments(RemoteWebDriver driver) throws IOException, InterruptedException
	{
		
		System.out.println("Go to Payments");
		
		ExtentTest test = ExtentTestManager.getTest();
		
		// Click Payments
		try {
			perform.click(driver, SOrders.paymentsMain_btn(driver));	
		} catch (Exception e) {
			// if the Payments button cannot be clicked, go to the Payments URL
			driver.get(StoredVariables.getsecureSite().get() + "Admin/Payments/Accounting.aspx");
		} // end try/catch
		
		// Wait for Loan Number textbox
		perform.waitForElementToBeClickable(driver, SPayments.loanNumber_txtbx(), "id");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().contains("Admin/Payments/Accounting.aspx"), "The url is incorrect");
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Navigation", "Navigated to the Payments page");
		
	} // end goToPayments
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click to Preferences</li>
	 * 	<li>Select Vendor Selection Settings</li>
	 * 	<li>Verify url</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	// Go to Vendor Selection Settings
	public void goToVendorSelectionSettings(RemoteWebDriver driver) throws IOException, InterruptedException
	{
		
		System.out.println("Go to Vendor Selection Settings");
		
		ExtentTest test = ExtentTestManager.getTest();
		
		// Click to Preferences
		perform.click(driver, SOrders.preferences_btn(driver));
		
		// Select Vendor Selection Settings
		perform.click(driver, SPreferences.vendorSelectionSettings_btn(driver));
		
		// Wait for Automatic Order Assignment switch
		perform.waitForElementToBeClickable(driver, SVendorSelectionSettings.automaticOrderAssignment_switch(), "id");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().contains("Admin/Preferences/VendorSelection.aspx"), "The url is incorrect");
		
		Thread.sleep(1000);
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Navigation", "Navigated to the Vendor Selection Settings page");
		
	} // end goToVendorSelectionSettings
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click to Preferences</li>
	 * 	<li>Select Product Requirements</li>
	 * 	<li>Verify url</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	// Go to Product Requirements
	public void goToProductRequirements(RemoteWebDriver driver) throws IOException, InterruptedException
	{
		
		System.out.println("Go to Product Requirements");
		
		ExtentTest test = ExtentTestManager.getTest();
		
		// Click to Preferences
		perform.click(driver, SOrders.preferences_btn(driver));
		
		// Select Product Requirements
		perform.click(driver, SPreferences.productRequirements_btn(driver));
		
		// Wait for Edit button
		perform.waitForElementToBeClickable(driver, SProductRequirements.edit_btn(), "cssSelector");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().contains("Admin/Preferences/ProductOptions.aspx"), "The url is incorrect");
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Navigation", "Navigated to the Product Requirements page");
		
	} // end goToProductRequirements
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click to Preferences</li>
	 * 	<li>Select Connection Settings</li>
	 * 	<li>Verify url</li>
	 * 	<li>Verify text on the screen</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	// Go to Connection Settings
	public void goToConnectionSettings(RemoteWebDriver driver) throws IOException, InterruptedException
	{
		
		System.out.println("Go to Connection Settings");
		
		ExtentTest test = ExtentTestManager.getTest();
		
		// Click to Preferences
		perform.click(driver, SOrders.preferences_btn(driver));
		
		// Select Connection Settings
		perform.click(driver, SPreferences.connectionSettings_btn(driver));
		
		// Wait for Direct Integration User Id textbox
		perform.waitForElementToBeClickable(driver, SConnectionSettings.directIntegrationUserID_txtbx(), "id");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().contains("Admin/Preferences/ConnectionSettings.aspx"), "The url is incorrect");
		
		// Verify text on the screen
		String text = SConnectionSettings.connectionSettings_txt(driver).getText();
		Assert.assertTrue(text.contains("UCDP Account Settings"), "Text is missing or incorrect on the Connection Settings page");
		Assert.assertTrue(text.contains("FHA Account Settings"), "Text is missing or incorrect on the Connection Settings page");
		Assert.assertTrue(text.contains("SureReceipts Settings"), "Text is missing or incorrect on the Connection Settings page");
		Assert.assertTrue(text.contains("QuickBooks Web Connector Settings"), "Text is missing or incorrect on the Connection Settings page");
		Assert.assertTrue(text.contains("RealEC Settings"), "Text is missing or incorrect on the Connection Settings page");
		Assert.assertTrue(text.contains("BlitzDocs Settings"), "Text is missing or incorrect on the Connection Settings page");

		// Add info to Extent Report
		test.log(LogStatus.INFO, "Navigation", "Navigated to the Connection Settings page");
		
	} // end goToConnectionSettings
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click to Preferences</li>
	 * 	<li>Select Appraisal Quality Management Settings</li>
	 * 	<li>Verify url</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	// Go to Appraisal Quality Management Settings
	public void goToAppraisalQualityManagementSettings(RemoteWebDriver driver) throws IOException, InterruptedException
	{
		
		System.out.println("Go to Appraisal Quality Management Settings");
		
		ExtentTest test = ExtentTestManager.getTest();
		
		// Click to Preferences
		perform.click(driver, SOrders.preferences_btn(driver));
		
		// Select Appraisal Quality Management Settings
		perform.click(driver, SPreferences.appraisalQualityManagementSettings_btn(driver));
		
		// Wait for Save button
		perform.waitForElementToBeClickable(driver, SAppraisalQualityManagementSettings.save_btn(), "cssSelector");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().contains("Admin/Preferences/AQM.aspx"), "The url is incorrect");
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Navigation", "Navigated to the Appraisal Quality Management Settings page");
		
	} // end goToAppraisalQualityManagementSettings
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click to Preferences</li>
	 * 	<li>Select VMP XSites</li>
	 * 	<li>Click to Preferences</li>
	 * 	<li>Click VMP XSites</li>
	 * 	<li>Verify url</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	// Go to VMP XSites
	public void goToVMPXSites(RemoteWebDriver driver) throws IOException, InterruptedException
	{
		
		System.out.println("Go to VMP XSites");
		
		ExtentTest test = ExtentTestManager.getTest();
		
		// Wait for Preferences button
		perform.waitForElementToBeClickable(driver, SOrders.preferences_btn(driver));
		
		// Click to Preferences
		perform.click(driver, SOrders.preferences_btn(driver));
		
		// Select VMP XSites
		try {
			perform.click(driver, SPreferences.vmpXSites_btn(driver));
		} catch (Exception e) {
			// Click to Preferences
			perform.click(driver, SOrders.preferences_btn(driver));
			// Click VMP XSites
			perform.click(driver, SPreferences.vmpXSites_btn(driver));
		} // end try/catch
		
		// Wait for configure status mapping link
		perform.waitForElementToBeClickable(driver, SVMPXSites.configureStatusMapping_lnk(), "id");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().contains("Admin/Preferences/VMPProducts.aspx"), "The url is incorrect");
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Navigation", "Navigated to the VMP XSites page");
		
	} // end goToVMPXSites
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click on Reports</li>
	 * 	<li>Click on Completed</li>
	 * 	<li>Verify url</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	// Go to Completed Reports
	public void goToCompletedReports(RemoteWebDriver driver) throws IOException, InterruptedException
	{
		
		System.out.println("Go to Completed Reports");
		
		ExtentTest test = ExtentTestManager.getTest();
		
		// Click on Reports
		perform.click(driver, SOrders.reports_btn(driver));
		
		// Wait for Completed button
		perform.waitForElementToBeClickable(driver, SReports.completed_btn(), "cssSelector");
		
		// Click on Completed
		perform.click(driver, SReports.completed_btn(driver));
		
		// Wait for Print button
		perform.waitForElementToBeClickable(driver, SReports.print_btn(), "cssSelector");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().contains("Admin/Reporting/OrderStatus.aspx?status=Completed"), "The url is incorrect");
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Navigation", "Navigated to the Completed Reports page");
		
	} // end goToCompletedReports
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click on Reports</li>
	 * 	<li>Click on In Progress</li>
	 * 	<li>Verify url</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	// Go to In Progress Reports
	public void goToInProgressReports(RemoteWebDriver driver) throws IOException, InterruptedException
	{
		
		System.out.println("Go to In Progress Reports");
		
		ExtentTest test = ExtentTestManager.getTest();
		
		// Click on Reports
		perform.click(driver, SOrders.reports_btn(driver));
		
		// Wait for Completed button
		perform.waitForElementToBeClickable(driver, SReports.completed_btn(), "cssSelector");
		
		// Click on In Progress
		perform.click(driver, SReports.inProgress_btn(driver));
		
		// Wait for Print button
		perform.waitForElementToBeClickable(driver, SReports.print_btn(), "cssSelector");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().contains("Admin/Reporting/OrderStatus.aspx?status=InProgress"), "The url is incorrect");

		// Add info to Extent Report
		test.log(LogStatus.INFO, "Navigation", "Navigated to the In Progress Reports page");
		
	} // end goToInProgressReports
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click on Reports</li>
	 * 	<li>Click on New Requests</li>
	 * 	<li>Verify url</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	// Go to New Requests Reports
	public void goToNewRequestsReports(RemoteWebDriver driver) throws IOException, InterruptedException
	{
		
		System.out.println("Go to New Requests Reports");
		
		ExtentTest test = ExtentTestManager.getTest();
		
		// Click on Reports
		perform.click(driver, SOrders.reports_btn(driver));
		
		// Wait for Completed button
		perform.waitForElementToBeClickable(driver, SReports.completed_btn(), "cssSelector");
		
		// Click on New Requests
		perform.click(driver, SReports.newRequests_btn(driver));
		
		// Wait for Print button
		perform.waitForElementToBeClickable(driver, SReports.print_btn(), "cssSelector");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().contains("Admin/Reporting/OrderStatus.aspx?status=Pending"), "The url is incorrect");
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Navigation", "Navigated to the New Request Reports page");
		
	} // end goToNewRequestsReports
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click on Reports</li>
	 * 	<li>Click on Fee Panel</li>
	 * 	<li>Verify url</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	// Go to Fee Panel Reports
	public void goToFeePanelReports(RemoteWebDriver driver) throws IOException, InterruptedException
	{
		
		System.out.println("Go to Fee Panel Reports");
		
		ExtentTest test = ExtentTestManager.getTest();
		
		// Click on Reports
		perform.click(driver, SOrders.reports_btn(driver));
		
		// Wait for Completed button
		perform.waitForElementToBeClickable(driver, SReports.completed_btn(), "cssSelector");
		
		// Click on Fee Panel
		perform.click(driver, SReports.feePanel_btn(driver));
		
		// Wait for Print button
		perform.waitForElementToBeClickable(driver, SReports.print_btn(), "cssSelector");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().contains("Admin/Reporting/FeePanel.aspx"), "The url is incorrect");
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Navigation", "Navigated to the Fee Panel Reports page");
		
	} // end goToFeePanelReports
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click on Reports</li>
	 * 	<li>Click on Work In Progress</li>
	 * 	<li>Verify url</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	// Go to Work In Progress Reports
	public void goToWorkInProgressReports(RemoteWebDriver driver) throws IOException, InterruptedException
	{
		
		System.out.println("Go to Work In Progress Reports");
		
		ExtentTest test = ExtentTestManager.getTest();
		
		// Click on Reports
		perform.click(driver, SOrders.reports_btn(driver));
		
		// Wait for Completed button
		perform.waitForElementToBeClickable(driver, SReports.completed_btn(), "cssSelector");
		
		// Click on Work In Progress
		perform.click(driver, SReports.workInProgress_btn(driver));
		
		// Wait for Print button
		perform.waitForElementToBeClickable(driver, SReports.print_btn(), "cssSelector");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().contains("Admin/Reporting/WorkInProgress.aspx"), "The url is incorrect");
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Navigation", "Navigated to the Work In Progress Reports page");
		
	} // end goToWorkInProgressReports
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Verify the dropdown is the correct VMP site</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param user the user
	 * @throws InterruptedException the interrupted exception
	 */
	// Verify XSite url in dropdown
	public void verifyXSiteURLDropdownValue(RemoteWebDriver driver, String user) throws InterruptedException
	{
		
		// Wait for Configure Status Mapping button
		perform.waitForElementToBeClickable(driver, SVMPXSites.configureStatusMapping_lnk(), "id");
		
		// Verify the dropdown is the correct VMP site
		String selected = SVMPXSites.vmpXSite_dropdown(driver).getText();
		String environment = StoredVariables.getusernameEnvironment().get();
		String dropdownValue = "";
		if (environment.equals("QA"))
		{
			dropdownValue = "AutomationQA" + user + ".qavmpxsites.com";
		} // end if Dev or QA
		else if (environment.equals("Beta"))
		{
			dropdownValue = "AutomationBeta" + user + ".vmpxsites.com";
		} // end if Beta
		else if (environment.equals("Live"))
		{
			dropdownValue = "AutomationLive" + user + ".vmpxsites.com";
		} // end if Live
		Assert.assertTrue(selected.contains(dropdownValue), "The VMP XSite is not correct in the dropdown. Should be - " + dropdownValue + ", but is - " + selected);
		
	} // end verifyXSiteURLDropdownValue
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Turn off Allow order bidding</li>
	 * 	<li>Turn off Automatic vendor seletion</li>
	 * 	<li>Turn off Unattended order assignment</li>
	 * 	<li>Turn off Unattended order reassignment</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws InterruptedException the interrupted exception
	 */
	// Turn off all Residential appraisal selection settings
	public void turnOffAllResidentialAppraisalSelectionSettings(RemoteWebDriver driver) throws InterruptedException
	{
		
		ExtentTest test = ExtentTestManager.getTest();
		
		// Turn off Allow order bidding
		switchOff(driver, SVendorSelectionSettings.allowOrderBidding_switch(driver));
		
		// Turn off Automatic vendor seletion
		switchOff(driver, SVendorSelectionSettings.automaticVendorSelection_switch(driver));
		
		// Turn off Unattended order assignment
		switchOff(driver, SVendorSelectionSettings.unattendedOrderAssignment_switch(driver));
		
		// Turn off Unattended order reassignment
		switchOff(driver, SVendorSelectionSettings.unattendedOrderReassignment_switch(driver));
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Turned off all Residential Appraisal Selection settings");
		
	} // end turnOffAllResidentialAppraisalSelectionSettings
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get current month</li>
	 * 	<li>Get today's date</li>
	 * 	<li>Add number of days passed in</li>
	 * 	<li>Set the date to the new date</li>
	 * 	<li>Set new day and format it without leading 0</li>
	 * 	<li>Set new day and format it with leading 0 if necessary</li>
	 * 	<li>Set new month and format it</li>
	 * 	<li>Set new month and format it</li>
	 * 	<li>Set new year and format it</li>
	 * 	<li>Convert the current month and new month to integers</li>
	 * 	<li>Get the name of the new month</li>
	 * 	<li>Declare calendar month string</li>
	 * 	<li>Check to see the difference between the new month and the current month</li>
	 * 	<li>If the new date goes into a new month</li>
	 * 	<li>Get the calendar element and all the columns/rows</li>
	 * 	<li>loop through the cells until the correct day is found</li>
	 * 	<li>Select Date</li>
	 * 	<li>select the correct day</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param numOfDaysInTheFuture the number of days in the future
	 * @param calendarElement the top level calendar element
	 * @param calendarMonthElement the calendar month element
	 * @param calendarNextMonth the next month button
	 * @param calendarPreviousMonth the previous month button
	 * @throws InterruptedException the interrupted exception
	 */
	// Select Date From Calendar
	@SuppressWarnings("unused")
	public void selectDateFromCalendar(RemoteWebDriver driver, int numOfDaysInTheFuture, WebElement calendarElement, WebElement calendarMonthElement, WebElement calendarNextMonth, WebElement calendarPreviousMonth) throws InterruptedException {

		// Get current month
		SimpleDateFormat s = new SimpleDateFormat("MM");
		StoredVariables.getcurrentMonth().set(s.format(new Date()));
		
		// Get today's date
		Calendar calendar = Calendar.getInstance();
		// Add number of days passed in
		calendar.add(Calendar.DAY_OF_MONTH, numOfDaysInTheFuture);
		// Set the date to the new date
		Date date = calendar.getTime();
		// Set new day and format it without leading 0
		StoredVariables.getnewDay().set(new SimpleDateFormat("d").format(date));
		// Set new day and format it with leading 0 if necessary
		StoredVariables.getnewDay2().set(new SimpleDateFormat("dd").format(date));
		// Set new month and format it
		StoredVariables.getnewMonth().set(new SimpleDateFormat("M").format(date));
		// Set new month and format it
		StoredVariables.getnewMonth2().set(new SimpleDateFormat("MM").format(date));
		// Set new year and format it
		StoredVariables.getnewYear().set(new SimpleDateFormat("yyyy").format(date));
		
		StoredVariables.getcalendarDateLong().set(StoredVariables.getnewMonth2().get() + "/" + StoredVariables.getnewDay2().get() + "/" + StoredVariables.getnewYear().get());
		StoredVariables.getcalendarDateShort().set(StoredVariables.getnewMonth().get() + "/" + StoredVariables.getnewDay().get() + "/" + StoredVariables.getnewYear().get());
		
		// Convert the current month and new month to integers
		int currentMonthInt = Integer.parseInt(StoredVariables.getcurrentMonth().get());
		int newMonthInt = Integer.parseInt(StoredVariables.getnewMonth().get());
		
		// Get the name of the new month
		String selectNewMonth = perform.getMonthName(driver, newMonthInt);
		System.out.println("selectNewMonth = " + selectNewMonth);
		
		// Wait for Month
		perform.waitForElementToBeClickable(driver, calendarMonthElement);
		
		// Declare calendar month string
		String calendarMonth = calendarMonthElement.getText();
		System.out.println("calendarMonth = " + calendarMonth);
		
		// Check to see the difference between the new month and the current month
		int diff = newMonthInt - currentMonthInt;
		
		// If the new date goes into a new month
		if (numOfDaysInTheFuture >= 0)
		{
			while(!calendarMonth.equals(selectNewMonth))
			{
				System.out.println("Next month");
				perform.click(driver, calendarNextMonth);
				Thread.sleep(500);
				calendarMonth = calendarMonthElement.getText();
				if (calendarMonth.equals(selectNewMonth))
				{
					break;
				}
			} // end while loop
		} // end next button click
		if (numOfDaysInTheFuture < 0)
		{
			while(!calendarMonth.equals(selectNewMonth))
			{
				System.out.println("Previous month");
				perform.click(driver, calendarPreviousMonth);
				Thread.sleep(500);
				calendarMonth = calendarMonthElement.getText();
				if (calendarMonth.equals(selectNewMonth))
				{
					break;
				}
			} // end while loop
		} // end back button click
		
		// Get the calendar element and all the columns/rows
		WebElement datepicker = calendarElement;
		List<WebElement> rows=datepicker.findElements(By.tagName("tr"));
		List<WebElement> columns=datepicker.findElements(By.tagName("td"));
		// loop through the cells until the correct day is found
		for (WebElement cell: columns){
			System.out.println("cell.getText() day = " + cell.getText() + "\tLooking for day = " + StoredVariables.getnewDay().get().trim());
			//Select Date
			if (cell.getText().equals(StoredVariables.getnewDay().get().trim()))
			{
				Thread.sleep(500);
				// select the correct day
				perform.click(driver, driver.findElement(By.cssSelector("td.almCalDay[datevalue='"+cell.getAttribute("datevalue")+"']")));
				System.out.println("Selected date");
				break;  
			} // end if statement
		} // end for loop  
		
	} // end selectDateFromCalendar
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the default elements for the calendar</li>
	 *  <li>Call the selectDateFromCalendar method</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param numOfDaysInTheFuture the number of days in the future
	 * @throws InterruptedException the interrupted exception
	 */
	// Select Date From Calendar
	public void selectDateFromCalendar(RemoteWebDriver driver, int numOfDaysInTheFuture) throws InterruptedException {

		WebElement calendarElement = SNewOrder.calendar(driver);
		WebElement calendarMonthElement = SNewOrder.calendarMonth_txt(driver);
		WebElement calendarNextMonth = SNewOrder.calendarNextMonth_btn(driver);
		WebElement calendarPreviousMonth = SNewOrder.calendarPreviousMonth_btn(driver);
		
		selectDateFromCalendar(driver, numOfDaysInTheFuture, calendarElement, calendarMonthElement, calendarNextMonth, calendarPreviousMonth);
		
	} // end selectDateFromCalendar
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the default elements for the calendar</li>
	 *  <li>Call the selectDateFromCalendar method</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param numOfDaysInTheFuture the number of days in the future
	 * @throws InterruptedException the interrupted exception
	 */
	// Select Date From Calendar Change Bid Due Date
	public void selectDateFromCalendarChangeBidDueDate(RemoteWebDriver driver, int numOfDaysInTheFuture) throws InterruptedException {

		WebElement calendarElement = SReviewBids.calendar(driver);
		WebElement calendarMonthElement = SReviewBids.calendarMonth_txt(driver);
		WebElement calendarNextMonth = SReviewBids.calendarNextMonth_btn(driver);
		WebElement calendarPreviousMonth = SReviewBids.calendarPreviousMonth_btn(driver);
		
		selectDateFromCalendar(driver, numOfDaysInTheFuture, calendarElement, calendarMonthElement, calendarNextMonth, calendarPreviousMonth);
		
	} // end selectDateFromCalendarChangeBidDueDate
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the default elements for the calendar</li>
	 *  <li>Call the selectDateFromCalendar method</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param numOfDaysInTheFuture the number of days in the future
	 * @throws InterruptedException the interrupted exception
	 */
	// Select Date From Calendar Change Bid Due Date
	public void selectDateFromCalendarExpiredDueDate(RemoteWebDriver driver, int numOfDaysInTheFuture) throws InterruptedException {

		WebElement calendarElement = SExpiredDueDate.calendar(driver);
		WebElement calendarMonthElement = SExpiredDueDate.calendarMonth_txt(driver);
		WebElement calendarNextMonth = SExpiredDueDate.calendarNextMonth_btn(driver);
		WebElement calendarPreviousMonth = SExpiredDueDate.calendarPreviousMonth_btn(driver);
		
		selectDateFromCalendar(driver, numOfDaysInTheFuture, calendarElement, calendarMonthElement, calendarNextMonth, calendarPreviousMonth);
		
	} // end selectDateFromCalendarExpiredDueDate
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the default elements for the calendar</li>
	 *  <li>Call the selectDateFromCalendar method</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param numOfDaysInTheFuture the number of days in the future
	 * @throws InterruptedException the interrupted exception
	 */
	// Select Date From Data Courier Calendar
	public void selectDateFromDataCourierCalendar(RemoteWebDriver driver, int numOfDaysInTheFuture) throws InterruptedException {
		
		WebElement calendarElement = SDataCourierUploadPDF.calendar(driver);
		WebElement calendarMonthElement = SDataCourierUploadPDF.calendarMonth_txt(driver);
		WebElement calendarNextMonth = SDataCourierUploadPDF.calendarNextMonth_btn(driver);
		WebElement calendarPreviousMonth = SDataCourierUploadPDF.calendarPreviousMonth_btn(driver);
		
		selectDateFromCalendar(driver, numOfDaysInTheFuture, calendarElement, calendarMonthElement, calendarNextMonth, calendarPreviousMonth);

	} // end selectDateFromDataCourierCalendar
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Go to Vendor Selection Settings</li>
	 * 	<li>Turn off Double-blind Communication switch</li>
	 * 	<li>Disable Automatic Vendor Selection</li>
	 * 	<li>Select Custom Fee Panel</li>
	 * 	<li>Uncheck Use Mercury Network Directory as backup checkbox</li>
	 * 	<li>Verify Mercury Network Directory as backup is unchecked</li>
	 * 	<li>Save Preferences</li>
	 * 	<li>Click OK in saved dialog box</li>
	 * 	<li>Go to Commercial Appraisal</li>
	 * 	<li>Enter New Order data</li>
	 * 	<li>Click Next</li>
	 * 	<li>Switch to the AMC view if assigning an order to an AMC</li>
	 * 	<li>Click switch to AMC button</li>
	 * 	<li>Assign vendor</li>
	 * 	<li>Confirm order screen loads</li>
	 * 	<li>Verify the 'I have read and understand the vendor's fee notes' checkbox is unchecked</li>
	 * 	<li>Click Next</li>
	 * 	<li>Verify popup displays with correct text</li>
	 * 	<li>Click OK</li>
	 * 	<li>Check the agree to notes checkbox</li>
	 * 	<li>Change payment method to check</li>
	 * 	<li>Click Next</li>
	 * 	<li>Check for a failed submission</li>
	 * 	<li>Click OK</li>
	 * 	<li>Click Back</li>
	 * 	<li>Click Next</li>
	 * 	<li>Check I have read checkbox</li>
	 * 	<li>Click Next</li>
	 * 	<li>Get inside the attach document frame</li>
	 * 	<li>Click Close Button</li>
	 * 	<li>Switch back to the attach documents frame</li>
	 * 	<li>Verify you land on the orders grid</li>
	 * 	<li>Query the db to get the order number that was just created</li>
	 * 	<li>String trackingNumber = StoredVariables.gettrackingNumber().get();</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param user the user
	 * @param vendor the vendor
	 * @throws Exception the exception
	 */
	// Create and assign a new Residential Appraisal order
	public void createAndAssignNewCommercialAppraisalOrderUsingCustomFeePanel(RemoteWebDriver driver, String user, String vendor) throws Exception {

		// Login to Secure
		login(driver, user, StoredVariables.getpassword().get());
		
		// Go to Vendor Selection Settings
		goToVendorSelectionSettings(driver);
		
		// Turn off Double-blind Communication switch
		if (!SVendorSelectionSettings.doubleBlind_switch(driver).getAttribute("src").contains("switchOff.png"))
		{
			perform.click(driver, SVendorSelectionSettings.doubleBlind_switch(driver));
		}
		
		// Disable Automatic Vendor Selection
		if (SVendorSelectionSettings.automaticOrderAssignment_switch(driver).getAttribute("src").contains("switchOn.png"))
		{
			perform.click(driver, SVendorSelectionSettings.automaticOrderAssignment_switch(driver));
		}
		
		// Select Custom Fee Panel
		perform.click(driver, SVendorSelectionSettings.customFeePanel_radio(driver));
		
		// Uncheck Use Mercury Network Directory as backup checkbox
		if (SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver).isSelected())
		{
			perform.click(driver, SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver));
		}
		
		// Verify Mercury Network Directory as backup is unchecked
		Assert.assertTrue(SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver).isSelected()==false, "Mercury Network Directory as backup is still checked");
		
		// Save Preferences
		perform.click(driver, SVendorSelectionSettings.save_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for the OK button to be visible
		perform.waitForElementToBeClickable(driver, SVendorSelectionSettings.ok_btn(), "id");
		
		// Click OK in saved dialog box
		perform.click(driver, SVendorSelectionSettings.ok_btn(driver));
		
		// Go to Commercial Appraisal
		goToCommercialAppraisal(driver);
		
		/***************************************
		 * Set New Order Information
		 ***************************************/
		perform.clearOrderInfoStoredVariables(driver);
		setNewCommercialAppraisalOrderVariablesMinimum(driver);
		
		// Enter New Order data
		enterNewCommercialAppraisalOrder(driver);
		
		// Click Next
		perform.click(driver, SNewOrder.next_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Switch to the AMC view if assigning an order to an AMC
		if (vendor.contains("AMC"))
		{
			// Wait for switch button
			perform.waitForElementToBeClickable(driver, SVendorSelection.switchToAMCFirm_btn(), "cssSelector");
			
			// Click switch to AMC button
			perform.click(driver, SVendorSelection.switchToAMCFirm_btn(driver));
		}
		
		// Assign vendor
		selectVendor(driver, vendor);
		
		// Confirm order screen loads
		Assert.assertTrue(driver.getCurrentUrl().contains("ConfirmOrder"), "Confirm Order page did not load");
		
		// Verify the 'I have read and understand the vendor's fee notes' checkbox is unchecked
		try
		{
			if (SConfirmOrder.readVendorsFeeNotes_chkbx(driver).isSelected())
			{
				perform.click(driver, SConfirmOrder.readVendorsFeeNotes_chkbx(driver));
			}
			
			// Click Next
			perform.click(driver, SConfirmOrder.nextBottom_btn(driver));
			
			// Wait for message text
			perform.waitForElementToBeClickable(driver, SConfirmOrder.messageOK_btn(), "id");
			
			// Verify popup displays with correct text
			Assert.assertTrue(SConfirmOrder.message_txt(driver).getText().contains("You must agree to the fee notes entered by the vendor."), "Message for not agreeing to vendor notes did not display properly");
			
			// Wait for OK button
			perform.waitForElementToBeClickable(driver, SConfirmOrder.messageOK_btn(), "id");
			
			// Click OK
			perform.click(driver, SConfirmOrder.messageOK_btn(driver));
			
			// Wait for the back button to be visible
			perform.waitForElementToBeClickable(driver, SConfirmOrder.backTop_btn(), "id");
			
			// Check the agree to notes checkbox
			if (!SConfirmOrder.readVendorsFeeNotes_chkbx(driver).isSelected())
			{
				perform.click(driver, SConfirmOrder.readVendorsFeeNotes_chkbx(driver));
			}
			
			// Change payment method to check
			perform.selectDropdownOption(driver, SConfirmOrder.paymentMethod_dropdown(driver), "Check");
			
		}
		catch (Exception e) {}
		
		Thread.sleep(2000);
		
		// Click Next
		perform.click(driver, SConfirmOrder.nextBottom_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Check for a failed submission 
		List<WebElement> frame = driver.findElements(By.xpath("//iframe[contains(@src,'AttachDocument.aspx')]"));
		int i = 1;
		while (frame.size()==0 && i <= 10) 
		{
			
			perform.sleep(driver, 5);
			
			frame = driver.findElements(By.xpath("//iframe[contains(@src,'AttachDocument.aspx')]"));
			if (frame.size()>0)
			{
				break;
			} // end if
			
			// Wait for busy to be hidden
			perform.waitForBusyToBeHidden(driver);
		
			// Click OK
			perform.click(driver, SConfirmOrder.messageOK_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			// Click Back
			perform.click(driver, SConfirmOrder.backBottom_btn(driver));
			
			// Wait for Next button
			perform.waitForElementToBeClickable(driver, SVendorSelection.nextTop_btn(), "id");
			
			// Click Next
			perform.click(driver, SVendorSelection.nextTop_btn(driver));
			
			// Wait for the Next button
			perform.waitForElementToBeClickable(driver, SConfirmOrder.nextTop_btn(), "id");
			
			// Check I have read checkbox
			try {
				perform.checkCheckbox(driver, SConfirmOrder.readVendorsFeeNotes_chkbx(driver));
			} catch (Exception s){}
			
			// Click Next
			perform.click(driver, SConfirmOrder.nextBottom_btn(driver));
			
			// Wait for busy to be hidden
			perform.waitForBusyToBeHidden(driver);
			
			frame = driver.findElements(By.xpath("//iframe[contains(@src,'AttachDocument.aspx')]"));
			
			i++;
			
		} // end the check for a failed submission
		
		// Get inside the attach document frame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "AttachDocument.aspx", By.id(SConfirmOrder.documentType_dropdown()));
		
		// Click Close Button
		perform.click(driver, SConfirmOrder.finished_btn(driver));
		
		// Switch back to the attach documents frame
		driver.switchTo().defaultContent();
		
		// Wait for Orders page to load
		perform.waitForElementToBeClickable(driver, SOrders.find_txtbx(), "id");
		
		// Verify you land on the orders grid
		Assert.assertTrue(driver.getCurrentUrl().contains("OrderManagement"), "After completing an order, the orders grid did not load");
		
		// Query the db to get the order number that was just created
		db.getLoanID(driver);
		//String trackingNumber = StoredVariables.gettrackingNumber().get();
		
	} // end createAndAssignNewResidentialAppraisalOrderUsingCustomFeePanel
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Go to Vendor Selection Settings</li>
	 * 	<li>Turn off Double-blind Communication switch</li>
	 * 	<li>Disable Automatic Vendor Selection</li>
	 * 	<li>Select Custom Fee Panel</li>
	 * 	<li>Uncheck Use Mercury Network Directory as backup checkbox</li>
	 * 	<li>Verify Mercury Network Directory as backup is unchecked</li>
	 * 	<li>Save Preferences</li>
	 * 	<li>Click OK in saved dialog box</li>
	 * 	<li>Go to Residential Appraisal</li>
	 * 	<li>Enter New Order data</li>
	 * 	<li>Click Next</li>
	 * 	<li>Check for related orders dialog</li>
	 * 	<li>Switch to the AMC view if assigning an order to an AMC</li>
	 * 	<li>Click switch to AMC button</li>
	 * 	<li>Assign vendor</li>
	 * 	<li>Confirm order screen loads</li>
	 * 	<li>Verify the 'I have read and understand the vendor's fee notes' checkbox is unchecked</li>
	 * 	<li>Click Next</li>
	 * 	<li>Verify popup displays with correct text</li>
	 * 	<li>Click OK</li>
	 * 	<li>Check the agree to notes checkbox</li>
	 * 	<li>Change payment method to check</li>
	 * 	<li>Click Next</li>
	 * 	<li>Check for a failed submission</li>
	 * 	<li>Click OK</li>
	 * 	<li>Click Back</li>
	 * 	<li>Click Next</li>
	 * 	<li>Check I have read checkbox</li>
	 * 	<li>Click Next</li>
	 * 	<li>Get inside the attach document frame</li>
	 * 	<li>Select document type</li>
	 * 	<li>Upload Document</li>
	 * 	<li>Click Finished Button</li>
	 * 	<li>Switch back to the attach documents frame</li>
	 * 	<li>Verify you land on the orders grid</li>
	 * 	<li>Query the db to get the order number that was just created</li>
	 * 	<li>Search for new order</li>
	 * 	<li>Verify the order just created is in the orders grid</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param user the user
	 * @param vendor the vendor
	 * @throws Exception the exception
	 */
	// Create and assign a new Residential Appraisal order
	public void createAndAssignNewResidentialAppraisalOrderUsingCustomFeePanel(RemoteWebDriver driver, String user, String vendor) throws Exception {

		// Login to Secure
		login(driver, user, StoredVariables.getpassword().get());
		
		// Go to Vendor Selection Settings
		goToVendorSelectionSettings(driver);
		
		// Turn off Double-blind Communication switch
		if (!SVendorSelectionSettings.doubleBlind_switch(driver).getAttribute("src").contains("switchOff.png"))
		{
			perform.click(driver, SVendorSelectionSettings.doubleBlind_switch(driver));
		}
		
		// Disable Automatic Vendor Selection
		if (SVendorSelectionSettings.automaticOrderAssignment_switch(driver).getAttribute("src").contains("switchOn.png"))
		{
			perform.click(driver, SVendorSelectionSettings.automaticOrderAssignment_switch(driver));
		}
		
		// Select Custom Fee Panel
		perform.click(driver, SVendorSelectionSettings.customFeePanel_radio(driver));
		
		// Uncheck Use Mercury Network Directory as backup checkbox
		if (SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver).isSelected())
		{
			perform.click(driver, SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver));
		}
		
		// Verify Mercury Network Directory as backup is unchecked
		Assert.assertTrue(SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver).isSelected()==false, "Mercury Network Directory as backup is still checked");
		
		// Save Preferences
		perform.click(driver, SVendorSelectionSettings.save_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for the OK button to be visible
		perform.waitForElementToBeClickable(driver, SVendorSelectionSettings.ok_btn(), "id");
		
		// Click OK in saved dialog box
		perform.click(driver, SVendorSelectionSettings.ok_btn(driver));
		
		// Go to Residential Appraisal
		goToResidentialAppraisal(driver);
		
		/***************************************
		 * Set New Order Information
		 ***************************************/
		perform.clearOrderInfoStoredVariables(driver);
		setNewResidentialAppraisalOrderVariablesMinimum(driver);
		
		// Enter New Order data
		enterNewResidentialAppraisalOrder(driver);
		
		// Click Next		
		if (StoredVariables.getmobile().get()==false) {
			perform.click(driver, SNewOrder.next_btn(driver));
		} else {
			perform.clickWithJavascript(driver, SNewOrder.next_btn(driver));
		} // end if/else
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Check for related orders dialog
		checkForRelatedOrdersDialog(driver);
		
		// Switch to the AMC view if assigning an order to an AMC
		if (vendor.contains("AMC"))
		{
			// Wait for switch button
			perform.waitForElementToBeClickable(driver, SVendorSelection.switchToAMCFirm_btn(), "cssSelector");
			
			// Click switch to AMC button
			perform.click(driver, SVendorSelection.switchToAMCFirm_btn(driver));
		} // end if
		
		// Assign vendor
		selectVendor(driver, vendor);
		
		// Confirm order screen loads
		Assert.assertTrue(driver.getCurrentUrl().contains("ConfirmOrder"), "Confirm Order page did not load");
		
		// Verify the 'I have read and understand the vendor's fee notes' checkbox is unchecked
		try
		{
			if (SConfirmOrder.readVendorsFeeNotes_chkbx(driver).isSelected())
			{
				perform.click(driver, SConfirmOrder.readVendorsFeeNotes_chkbx(driver));
			} // end if
			
			// Click Next
			perform.click(driver, SConfirmOrder.nextBottom_btn(driver));
			
			// Wait for message text
			perform.waitForElementToBeClickable(driver, SConfirmOrder.messageOK_btn(), "id");
			
			// Verify popup displays with correct text
			Assert.assertTrue(SConfirmOrder.message_txt(driver).getText().contains("You must agree to the fee notes entered by the vendor."), "Message for not agreeing to vendor notes did not display properly");
			
			// Wait for OK button
			perform.waitForElementToBeClickable(driver, SConfirmOrder.messageOK_btn(), "id");

			// Click OK
			if (StoredVariables.getmobile().get()==false) {
				perform.click(driver, SConfirmOrder.messageOK_btn(driver));
			} else {
				perform.clickWithJavascript(driver, SConfirmOrder.messageOK_btn(driver));
			} // end if/else
			
			// Wait for the back button to be visible
			perform.waitForElementToBeClickable(driver, SConfirmOrder.backTop_btn(), "id");
			
			// Check the agree to notes checkbox
			if (!SConfirmOrder.readVendorsFeeNotes_chkbx(driver).isSelected())
			{
				if (StoredVariables.getmobile().get()==false) {
					perform.click(driver, SConfirmOrder.readVendorsFeeNotes_chkbx(driver));
				} else {
					perform.clickWithJavascript(driver, SConfirmOrder.readVendorsFeeNotes_chkbx(driver));
					System.out.println("Clicked fee notes checkbox with Javascirpt");
				} // end if/else
			} // end if
			
			// Change payment method to check
			perform.selectDropdownOption(driver, SConfirmOrder.paymentMethod_dropdown(driver), "Check");
			
		} catch (Exception e) {} // end try/catch
		
		Thread.sleep(2000);
		
		// Click Next
		perform.click(driver, SConfirmOrder.nextBottom_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Check for a failed submission 
		List<WebElement> frame = driver.findElements(By.xpath("//iframe[contains(@src,'AttachDocument.aspx')]"));
		while (frame.size()==0) 
		{
			
			Thread.sleep(5000);
			
			frame = driver.findElements(By.xpath("//iframe[contains(@src,'AttachDocument.aspx')]"));
			if (frame.size()>0)
			{
				break;
			} // end if
		
			// Click OK
			perform.waitForElementToBeClickable(driver, SConfirmOrder.messageOK_btn(driver));
			perform.click(driver, SConfirmOrder.messageOK_btn(driver));

			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			// Click Back
			perform.click(driver, SConfirmOrder.backBottom_btn(driver));
			
			// Wait for Next button
			perform.waitForElementToBeClickable(driver, SVendorSelection.nextTop_btn(), "id");
			
			// Click Next
			perform.click(driver, SVendorSelection.nextTop_btn(driver));
			
			// Wait for the Next button
			perform.waitForElementToBeClickable(driver, SConfirmOrder.nextTop_btn(), "id");
			
			// Check I have read checkbox
			try {
				perform.checkCheckbox(driver, SConfirmOrder.readVendorsFeeNotes_chkbx(driver));
			} catch (Exception s){} // end try/catch
			
			// Click Next
			perform.click(driver, SConfirmOrder.nextBottom_btn(driver));
			
			// Wait for busy to be hidden
			perform.waitForBusyToBeHidden(driver);
			
			frame = driver.findElements(By.xpath("//iframe[contains(@src,'AttachDocument.aspx')]"));
		} // end the check for a failed submission
		
		// Get inside the attach document frame
		perform.switchToiFrameByID(driver, "iframeAttach");
		
		// Select document type
		perform.selectDropdownOption(driver, SConfirmOrder.documentType_dropdown(driver), "Other");
		
		// Wait for upload button
		perform.waitForElementToBeClickable(driver, SConfirmOrder.uploadDocuments_btn(), "id");
		
		if (StoredVariables.getmobile().get()==false) {
			System.out.println("upload document");
			// Upload Document
			String filePath = StoredVariables.getdocDir().get()+"Test PDF.pdf";
			uploadDocumentOnSConfirmOrder(driver, filePath);
		} // end if/else
		
		// Click Finished Button
		perform.click(driver, SConfirmOrder.finished_btn(driver));
		
		// Switch back to the attach documents frame
		driver.switchTo().defaultContent();
		
		// Wait for Orders page to load
		perform.waitForElementToBeClickable(driver, SOrders.find_txtbx(), "id");
		
		// Verify you land on the orders grid
		Assert.assertTrue(driver.getCurrentUrl().contains("OrderManagement"), "After completing an order, the orders grid did not load");
		
		// Query the db to get the order number that was just created
		db.getLoanID(driver);
		String trackingNumber = StoredVariables.gettrackingNumber().get();
		
		// Wait for the Order Types dropdown
		perform.waitForElementToBeClickable(driver, SOrders.orderTypes_dropdown(), "id");
		
		// Search for new order
		findOrder(driver, trackingNumber, "Tracking number");
		
		// Verify the order just created is in the orders grid 
		Assert.assertTrue(SOrders.ordersTable_txt(driver).getText().contains(StoredVariables.getloanID().get()), "New order is not displayed");
		
	} // end createAndAssignNewResidentialAppraisalOrderUsingCustomFeePanel
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Go to Vendor Selection Settings</li>
	 * 	<li>Turn off Double-blind Communication switch</li>
	 * 	<li>Disable Automatic Vendor Selection</li>
	 * 	<li>Select Mercury Network directory</li>
	 * 	<li>Save Preferences</li>
	 * 	<li>Click OK in saved dialog box</li>
	 * 	<li>Go to Residential Appraisal</li>
	 * 	<li>Set Property Information data</li>
	 * 	<li>Set Assignment Information data</li>
	 * 	<li>Set Lender Information data</li>
	 * 	<li>Set Contact And Access Information data</li>
	 * 	<li>Set Additional Notification Recipients data</li>
	 * 	<li>Enter New Order data</li>
	 * 	<li>Click Next</li>
	 * 	<li>Check for related orders dialog</li>
	 * 	<li>Switch to the AMC view if assigning an order to an AMC</li>
	 * 	<li>Click switch to AMC button</li>
	 * 	<li>Assign vendor</li>
	 * 	<li>Confirm order screen loads</li>
	 * 	<li>Verify data displays properly</li>
	 * 	<li>Verify the 'I have read and understand the vendor's fee notes' checkbox is unchecked</li>
	 * 	<li>Click Next</li>
	 * 	<li>Verify popup displays with correct text</li>
	 * 	<li>Click OK</li>
	 * 	<li>Check the agree to notes checkbox</li>
	 * 	<li>Change payment method to check</li>
	 * 	<li>Click Next</li>
	 * 	<li>Get inside the attach document frame</li>
	 * 	<li>Select document type</li>
	 * 	<li>Upload Document</li>
	 * 	<li>Click Close Button</li>
	 * 	<li>Switch back to the attach documents frame</li>
	 * 	<li>Verify you land on the orders grid</li>
	 * 	<li>Query the db to get the order number that was just created</li>
	 * 	<li>Search for new order</li>
	 * 	<li>Verify the order is in the correct status</li>
	 * 	<li>Verify the order just created is in the orders grid</li>
	 * 	<li>Verify data in the database</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param user the user
	 * @param vendor the vendor
	 * @throws Exception the exception
	 */
	// Create and assign a new Residential Appraisal order using the Mercury Network directory
	public void createAndAssignNewResidentialAppraisalOrderUsingMercuryNetworkDirectory(RemoteWebDriver driver, String user, String vendor) throws Exception {

		// Login to Secure
		login(driver, user, StoredVariables.getpassword().get());
		
		// Go to Vendor Selection Settings
		goToVendorSelectionSettings(driver);
		
		// Turn off Double-blind Communication switch
		if (!SVendorSelectionSettings.doubleBlind_switch(driver).getAttribute("src").contains("switchOff.png"))
		{
			perform.click(driver, SVendorSelectionSettings.doubleBlind_switch(driver));
		}
		
		// Disable Automatic Vendor Selection
		if (SVendorSelectionSettings.automaticOrderAssignment_switch(driver).getAttribute("src").contains("switchOn.png"))
		{
			perform.click(driver, SVendorSelectionSettings.automaticOrderAssignment_switch(driver));
		}
		
		// Select Mercury Network directory
		perform.click(driver, SVendorSelectionSettings.mercuryNetworkDirectory_radio(driver));
		
		// Save Preferences
		perform.click(driver, SVendorSelectionSettings.save_btn(driver));
		
		// Wait for the OK button to be visible
		perform.waitForElementToBeClickable(driver, SVendorSelectionSettings.ok_btn(), "id");
		
		// Click OK in saved dialog box
		perform.click(driver, SVendorSelectionSettings.ok_btn(driver));
		
		// Go to Residential Appraisal
		goToResidentialAppraisal(driver);
		
		/***************************************
		 * Set New Order Information
		 ***************************************/
		
		// Set Property Information data
		StoredVariables.getpropertyInformationAddress().set("2621 SW 136th St");
		StoredVariables.getpropertyInformationCity().set("Oklahoma City");
		StoredVariables.getpropertyInformationState().set("Oklahoma");
		StoredVariables.getpropertyInformationStateAbbr().set("OK"); // Must set for a field check later on
		StoredVariables.getpropertyInformationZip().set("73170");
		StoredVariables.getpropertyInformationSqFt().set("3697");
		StoredVariables.getpropertyInformationSiteSize().set("9,583 sq ft");
		StoredVariables.getpropertyInformationPropType().set("Single Family");
		StoredVariables.getpropertyInformationPropRights().set("Fee Simple");
		StoredVariables.getpropertyInformationLegalDesc().set("2844 Guilford Ln, Oklahoma City, OK 73120");
		StoredVariables.getpropertyInformationDirections().set("East of N May Ave and south of NW Britton Rd");
		
		// Set Assignment Information data
		StoredVariables.getassignmentInformationForm().set("Uniform Residential Appraisal (FNMA 1004)");
		StoredVariables.getassignmentInformationRushOrder().set(true);
		StoredVariables.getassignmentInformationComplex().set(true);
		StoredVariables.getassignmentInformationOrderDue().set(7);
		perform.getNewDate(driver, StoredVariables.getassignmentInformationOrderDue().get());
		StoredVariables.getassignmentInformationOtherRefNumber().set(perform.randomNumbers(driver, 7));
		StoredVariables.getassignmentInformationLoanType().set("All In One");
		StoredVariables.getassignmentInformationLoanPurpose().set("Purchase");
		StoredVariables.getassignmentInformationOrderedBy().set("Borrower Name");
		StoredVariables.getassignmentInformationOrderGroup().set("");
		StoredVariables.getassignmentInformationLoanNumber().set(perform.randomNumbers(driver, 10));
		StoredVariables.getassignmentInformationFileNumber().set(perform.randomNumbers(driver, 5));
		StoredVariables.getassignmentInformationSalesPrice().set("645,715");
		StoredVariables.getassignmentInformationFHACaseNumber().set(perform.randomNumbers(driver, 5));
		StoredVariables.getassignmentInformationDisclosure().set(0);
		StoredVariables.getassignmentInformationAssignedTo().set("");
		
		// Set Lender Information data
		StoredVariables.getlenderInformationLenderName().set("BOKF, National Association");
		StoredVariables.getlenderInformationAddress1().set("One Williams Center");
		StoredVariables.getlenderInformationAddress2().set("Suite D");
		StoredVariables.getlenderInformationCity().set("Tulsa");
		StoredVariables.getlenderInformationState().set("OK");
		StoredVariables.getlenderInformationZip().set("74172");
		
		// Set Contact And Access Information data
		StoredVariables.getcontactOccupancy().set("Owner");
		StoredVariables.getcontactBorrower().set("Borrower Name");
		StoredVariables.getcontactBorrowerInfo1Dropdown().set("Home");
		StoredVariables.getcontactBorrowerInfo1().set("405-555-7818");
		StoredVariables.getcontactBorrowerInfo2Dropdown().set("E-mail");
		StoredVariables.getcontactBorrowerInfo2().set("borrower@dntest.net");
		StoredVariables.getcontactBorrowerAddress().set("8051 Falcon Crst");
		StoredVariables.getcontactBorrowerCity().set("Edmond");
		StoredVariables.getcontactBorrowerState().set("OK");
		StoredVariables.getcontactBorrowerZip().set("73034");
		StoredVariables.getcontactCoBorrower().set("Coborrower Name");
		StoredVariables.getcontactCoBorrowerInfo1Dropdown().set("Work");
		StoredVariables.getcontactCoBorrowerInfo1().set("405-555-9813");
		StoredVariables.getcontactCoBorrowerInfo2Dropdown().set("Mobile");
		StoredVariables.getcontactCoBorrowerInfo2().set("405-555-1679");
		StoredVariables.getcontactCoBorrowerAddress().set("1509 Rain Tree Dr");
		StoredVariables.getcontactCoBorrowerCity().set("Moore");
		StoredVariables.getcontactCoBorrowerState().set("OK");
		StoredVariables.getcontactCoBorrowerZip().set("73160");
		StoredVariables.getcontactOwner().set("Owner Name");
		StoredVariables.getcontactOwnerInfo1Dropdown().set("Pager");
		StoredVariables.getcontactOwnerInfo1().set("405-555-8618");
		StoredVariables.getcontactOwnerInfo2Dropdown().set("Fax");
		StoredVariables.getcontactOwnerInfo2().set("405-555-7410");
		StoredVariables.getcontactOccupant().set("Occupant Name");
		StoredVariables.getcontactOccupantInfo1Dropdown().set("Home");
		StoredVariables.getcontactOccupantInfo1().set("405-555-3549");
		StoredVariables.getcontactOccupantInfo2Dropdown().set("Mobile");
		StoredVariables.getcontactOccupantInfo2().set("405-555-8895");
		StoredVariables.getcontactAgent().set("Agent Name");
		StoredVariables.getcontactAgentInfo1Dropdown().set("E-mail");
		StoredVariables.getcontactAgentInfo1().set("agent@dntest.net");
		StoredVariables.getcontactAgentInfo2Dropdown().set("Pager");
		StoredVariables.getcontactAgentInfo2().set("405-555-4893");
		StoredVariables.getcontactOther().set("Other Name");
		StoredVariables.getcontactOtherInfo1Dropdown().set("Work");
		StoredVariables.getcontactOtherInfo1().set("405-555-7825");
		StoredVariables.getcontactOtherInfo2Dropdown().set("Fax");
		StoredVariables.getcontactOtherInfo2().set("405-555-8688");
		StoredVariables.getcontactApptContact().set("Borrower");
		
		// Set Additional Notification Recipients data
		StoredVariables.getadditionalNotificationRecipientsAdditionalEmails().set("additionalEmail1@dntest.net; additionalEmail2@dntest.net");
		StoredVariables.getadditionalNotificationRecipientsAttachCompletedReport().set(true);
		
		// Enter New Order data
		enterNewResidentialAppraisalOrder(driver);
		
		// Click Next
		perform.click(driver, SNewOrder.next_btn(driver));
		
		// Check for related orders dialog
		checkForRelatedOrdersDialog(driver);
		
		// Switch to the AMC view if assigning an order to an AMC
		if (vendor.contains("AMC"))
		{
			// Wait for switch button
			perform.waitForElementToBeClickable(driver, SVendorSelection.switchToAMCFirm_btn(), "cssSelector");
			
			// Click switch to AMC button
			perform.click(driver, SVendorSelection.switchToAMCFirm_btn(driver));
		}
		
		// Assign vendor
		selectVendor(driver, vendor);
		
		// Confirm order screen loads
		Assert.assertTrue(driver.getCurrentUrl().contains("ConfirmOrder"), "Confirm Order page did not load");
		
		// Verify data displays properly
		verifyOrderDetails(driver);
		
		// Verify the 'I have read and understand the vendor's fee notes' checkbox is unchecked
		try
		{
			if (SConfirmOrder.readVendorsFeeNotes_chkbx(driver).isSelected())
			{
				perform.click(driver, SConfirmOrder.readVendorsFeeNotes_chkbx(driver));
			}
			
			// Click Next
			perform.click(driver, SConfirmOrder.nextBottom_btn(driver));
			
			// Wait for message text
			perform.waitForElementToBeClickable(driver, SConfirmOrder.messageOK_btn(), "id");
			
			// Verify popup displays with correct text
			Assert.assertTrue(SConfirmOrder.message_txt(driver).getText().contains("You must agree to the fee notes entered by the vendor."), "Message for not agreeing to vendor notes did not display properly");
			
			// Wait for OK button
			perform.waitForElementToBeClickable(driver, SConfirmOrder.messageOK_btn(), "id");
			
			// Click OK
			perform.click(driver, SConfirmOrder.messageOK_btn(driver));
			
			// Wait for the back button to be visible
			perform.waitForElementToBeClickable(driver, SConfirmOrder.backTop_btn(), "id");
			
			// Check the agree to notes checkbox
			if (!SConfirmOrder.readVendorsFeeNotes_chkbx(driver).isSelected())
			{
				perform.click(driver, SConfirmOrder.readVendorsFeeNotes_chkbx(driver));
			}
			
			// Change payment method to check
			perform.selectDropdownOption(driver, SConfirmOrder.paymentMethod_dropdown(driver), "Check");
			
		}
		catch (Exception e) {}
		
		// Click Next
		perform.click(driver, SConfirmOrder.nextBottom_btn(driver));
		
		// Get inside the attach document frame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "AttachDocument.aspx", By.id(SConfirmOrder.documentType_dropdown()));
		
		System.out.println("select doctype");
		// Select document type
		perform.selectDropdownOption(driver, SConfirmOrder.documentType_dropdown(driver), "Other");
		
		System.out.println("wait for upload button");
		// Wait for upload button
		perform.waitForElementToBeClickable(driver, SConfirmOrder.uploadDocuments_btn(), "id");
		
		System.out.println("upload doc");
		// Upload Document
		String filePath = StoredVariables.getdocDir().get()+"Test PDF.pdf";
		uploadDocumentOnSConfirmOrder(driver, filePath);
		
		// Click Close Button
		perform.click(driver, SConfirmOrder.finished_btn(driver));
		
		// Switch back to the attach documents frame
		driver.switchTo().defaultContent();
		
		// Wait for Orders page to load
		perform.waitForElementToBeClickable(driver, SOrders.find_txtbx(), "id");
		
		// Verify you land on the orders grid
		Assert.assertTrue(driver.getCurrentUrl().contains("OrderManagement"), "After completing an order, the orders grid did not load");
		
		// Query the db to get the order number that was just created
		db.getLoanID(driver);
		String trackingNumber = StoredVariables.gettrackingNumber().get();
		
		// Wait for the Order Types dropdown
		perform.waitForElementToBeClickable(driver, SOrders.orderTypes_dropdown(), "id");
		
		// Search for new order
		findOrder(driver, trackingNumber, "Tracking number");
		
		// Verify the order is in the correct status
		Assert.assertTrue(SOrders.ordersTable_txt(driver).getText().contains("Awaiting acceptance"), "The order is not in the correct status");
		
		// Verify the order just created is in the orders grid 
		Assert.assertTrue(SOrders.ordersTable_txt(driver).getText().contains(StoredVariables.getloanID().get()), "New order is not displayed");
		
		// Verify data in the database
		db.verifyNewOrderDataInDB_All(driver, StoredVariables.getloanID().get());
		
	} // end createAndAssignNewResidentialAppraisalOrderUsingMercuryNetworkDirectory
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set Property Information data</li>
	 * 	<li>StoredVariables.getpropertyInformationStateAbbr().set("OK");  Must set for a field check later on</li>
	 * 	<li>Set Assignment Information data</li>
	 * 	<li>Set Lender Information data</li>
	 * 	<li>Set Contact And Access Information data</li>
	 * 	<li>Set Additional Notification Recipients data</li>
	 * </ul>
	 *
	 * @param driver the new new residential appraisal order variables
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Set New Residential Appraisal Order Variables on Secure
	public void setNewResidentialAppraisalOrderVariables(RemoteWebDriver driver) throws InterruptedException, IOException {
		
		// Clear stored variables
		perform.clearOrderInfoStoredVariables(driver);
		
		/***************************************
		 * Set New Order Information
		 ***************************************/
		
		// Set Property Information data
		StoredVariables.getpropertyInformationAddress().set("10616 Timber Oak Dr");
		StoredVariables.getpropertyInformationCity().set("Oklahoma City");
		StoredVariables.getpropertyInformationState().set("Oklahoma");
		StoredVariables.getpropertyInformationStateAbbr().set("OK"); // Must set for a field check later on
		StoredVariables.getpropertyInformationZip().set("73151");
		StoredVariables.getpropertyInformationSqFt().set("3697");
		StoredVariables.getpropertyInformationSiteSize().set("9,583 sq ft");
		StoredVariables.getpropertyInformationPropType().set("Single Family");
		StoredVariables.getpropertyInformationPropRights().set("Fee Simple");
		StoredVariables.getpropertyInformationLegalDesc().set("2844 Guilford Ln, Oklahoma City, OK 73120");
		StoredVariables.getpropertyInformationDirections().set("Automation directions");
		
		// Set Assignment Information data
		StoredVariables.getassignmentInformationForm().set("Uniform Residential Appraisal (FNMA 1004)");
		StoredVariables.getassignmentInformationRushOrder().set(true);
		StoredVariables.getassignmentInformationComplex().set(true);
		StoredVariables.getassignmentInformationOrderDue().set(7);
		perform.getNewDate(driver, StoredVariables.getassignmentInformationOrderDue().get());
		StoredVariables.getassignmentInformationOtherRefNumber().set(perform.randomNumbers(driver, 7));
		StoredVariables.getassignmentInformationLoanType().set("All In One");
		StoredVariables.getassignmentInformationLoanPurpose().set("Purchase");
		StoredVariables.getassignmentInformationOrderedBy().set("Borrower Name");
		StoredVariables.getassignmentInformationOrderGroup().set("");
		StoredVariables.getassignmentInformationLoanNumber().set(perform.randomNumbers(driver, 10));
		StoredVariables.getassignmentInformationFileNumber().set(perform.randomNumbers(driver, 5));
		StoredVariables.getassignmentInformationSalesPrice().set("645,715");
		StoredVariables.getassignmentInformationFHACaseNumber().set(perform.randomNumbers(driver, 5));
		StoredVariables.getassignmentInformationDisclosure().set(0);
		StoredVariables.getassignmentInformationAssignedTo().set("");
		
		// Set Lender Information data
		StoredVariables.getlenderInformationLenderName().set("BOKF, National Association");
		StoredVariables.getlenderInformationAddress1().set("One Williams Center");
		StoredVariables.getlenderInformationAddress2().set("Suite D");
		StoredVariables.getlenderInformationCity().set("Tulsa");
		StoredVariables.getlenderInformationState().set("OK");
		StoredVariables.getlenderInformationZip().set("74172");
		
		// Set Contact And Access Information data
		StoredVariables.getcontactOccupancy().set("Owner");
		StoredVariables.getcontactBorrower().set("Borrower Name");
		StoredVariables.getcontactBorrowerInfo1Dropdown().set("Home");
		StoredVariables.getcontactBorrowerInfo1().set("405-555-7818");
		StoredVariables.getcontactBorrowerInfo2Dropdown().set("E-mail");
		StoredVariables.getcontactBorrowerInfo2().set("borrower@dntest.net");
		StoredVariables.getcontactBorrowerAddress().set("8051 Falcon Crst");
		StoredVariables.getcontactBorrowerCity().set("Edmond");
		StoredVariables.getcontactBorrowerState().set("OK");
		StoredVariables.getcontactBorrowerZip().set("73034");
		StoredVariables.getcontactCoBorrower().set("Coborrower Name");
		StoredVariables.getcontactCoBorrowerInfo1Dropdown().set("Work");
		StoredVariables.getcontactCoBorrowerInfo1().set("405-555-9813");
		StoredVariables.getcontactCoBorrowerInfo2Dropdown().set("E-mail");
		StoredVariables.getcontactCoBorrowerInfo2().set("testing@dntest.net");
		StoredVariables.getcontactCoBorrowerAddress().set("1509 Rain Tree Dr");
		StoredVariables.getcontactCoBorrowerCity().set("Moore");
		StoredVariables.getcontactCoBorrowerState().set("OK");
		StoredVariables.getcontactCoBorrowerZip().set("73160");
		StoredVariables.getcontactOwner().set("Owner Name");
		StoredVariables.getcontactOwnerInfo1Dropdown().set("Pager");
		StoredVariables.getcontactOwnerInfo1().set("405-555-8618");
		StoredVariables.getcontactOwnerInfo2Dropdown().set("Fax");
		StoredVariables.getcontactOwnerInfo2().set("405-555-7410");
		StoredVariables.getcontactOccupant().set("Occupant Name");
		StoredVariables.getcontactOccupantInfo1Dropdown().set("Home");
		StoredVariables.getcontactOccupantInfo1().set("405-555-3549");
		StoredVariables.getcontactOccupantInfo2Dropdown().set("Mobile");
		StoredVariables.getcontactOccupantInfo2().set("405-555-8895");
		StoredVariables.getcontactAgent().set("Agent Name");
		StoredVariables.getcontactAgentInfo1Dropdown().set("E-mail");
		StoredVariables.getcontactAgentInfo1().set("agent@dntest.net");
		StoredVariables.getcontactAgentInfo2Dropdown().set("Pager");
		StoredVariables.getcontactAgentInfo2().set("405-555-4893");
		StoredVariables.getcontactOther().set("Other Name");
		StoredVariables.getcontactOtherInfo1Dropdown().set("Work");
		StoredVariables.getcontactOtherInfo1().set("405-555-7825");
		StoredVariables.getcontactOtherInfo2Dropdown().set("Fax");
		StoredVariables.getcontactOtherInfo2().set("405-555-8688");
		StoredVariables.getcontactApptContact().set("Borrower");
		
		// Set Additional Notification Recipients data
		StoredVariables.getadditionalNotificationRecipientsAdditionalEmails().set("additionalEmail1@dntest.net; additionalEmail2@dntest.net");
		StoredVariables.getadditionalNotificationRecipientsAttachCompletedReport().set(true);
		
	} // end setNewResidentialAppraisalOrderVariables
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set Property Information data</li>
	 * 	<li>StoredVariables.getpropertyInformationStateAbbr().set("OK");  Must set for a field check later on</li>
	 * 	<li>Set Assignment Information data</li>
	 * </ul>
	 *
	 * @param driver the new new residential appraisal order variables minimum
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Set New Residential Appraisal Order Variables on Secure (minimum)
	public void setNewResidentialAppraisalOrderVariablesMinimum(RemoteWebDriver driver) throws InterruptedException, IOException {
		
		// Clear stored variables
		perform.clearOrderInfoStoredVariables(driver);
		
		/***************************************
		 * Set New Order Information
		 ***************************************/
		
		// Set Property Information data
		StoredVariables.getpropertyInformationAddress().set("10616 Timber Oak Dr");
		StoredVariables.getpropertyInformationCity().set("Oklahoma City");
		StoredVariables.getpropertyInformationState().set("Oklahoma");
		StoredVariables.getpropertyInformationStateAbbr().set("OK"); // Must set for a field check later on
		StoredVariables.getpropertyInformationZip().set("73151");
		StoredVariables.getpropertyInformationDirections().set("Automation directions");
		
		// Set Assignment Information data
		StoredVariables.getassignmentInformationForm().set("Uniform Residential Appraisal (FNMA 1004)");
		StoredVariables.getassignmentInformationOrderDue().set(7);
		StoredVariables.getassignmentInformationLoanNumber().set(perform.randomNumbers(driver, 10));
		
	} // end setNewResidentialAppraisalOrderVariablesMinimum
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set Property Information data</li>
	 * 	<li>Set Assignment Information data</li>
	 * 	<li>Set Lender Information data</li>
	 * 	<li>Set Contact And Access Information data</li>
	 * 	<li>Set Additional Notification Recipients data</li>
	 * </ul>
	 *
	 * @param driver the new new commercial appraisal order bid variables
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Set New Commercial Appraisal Order Variables on Secure
	public void setNewCommercialAppraisalOrderBidVariables(RemoteWebDriver driver) throws InterruptedException, IOException {

		// Clear stored variables
		perform.clearOrderInfoStoredVariables(driver);
		
		/***************************************
		 * Set New Order Information
		 ***************************************/
		
		// Set Property Information data
		StoredVariables.getpropertyInformationAddress().set("501-D NE 122nd St");
		StoredVariables.getpropertyInformationCity().set("Oklahoma City");
		StoredVariables.getpropertyInformationState().set("Oklahoma");
		StoredVariables.getpropertyInformationStateAbbr().set("OK"); // Must set for a field check later on
		StoredVariables.getpropertyInformationZip().set("73114");
		StoredVariables.getpropertyInformationSqFt().set("5688");
		StoredVariables.getpropertyInformationSiteSize().set("9,583 sq ft");
		StoredVariables.getpropertyInformationPropType().set("Office");
		StoredVariables.getpropertyInformationPropRights().set("Fee Simple");
		StoredVariables.getpropertyInformationLegalDesc().set("501-D NE 122nd St");
		StoredVariables.getpropertyInformationDirections().set("122nd and Kelley");
		
		// Set Assignment Information data
		StoredVariables.getassignmentInformationForm().set("Commercial Appraisal Report");
		StoredVariables.getassignmentInformationRushOrder().set(true);
		StoredVariables.getassignmentInformationComplex().set(true);
		StoredVariables.getassignmentInformationIssueAsBid().set(true);
		StoredVariables.getassignmentInformationOrderDue().set(7);
		perform.getNewDate(driver, StoredVariables.getassignmentInformationOrderDue().get());
		StoredVariables.getassignmentInformationOtherRefNumber().set(perform.randomNumbers(driver, 7));
		StoredVariables.getassignmentInformationLoanType().set("All In One");
		StoredVariables.getassignmentInformationLoanPurpose().set("Purchase");
		StoredVariables.getassignmentInformationOrderedBy().set("Borrower Name");
		StoredVariables.getassignmentInformationOrderGroup().set("AppraisersGroupTest");
		StoredVariables.getassignmentInformationLoanNumber().set(perform.randomNumbers(driver, 8));
		StoredVariables.getassignmentInformationFileNumber().set(perform.randomNumbers(driver, 5));
		StoredVariables.getassignmentInformationSalesPrice().set("645,715");
		StoredVariables.getassignmentInformationFHACaseNumber().set(perform.randomNumbers(driver, 6));
		StoredVariables.getassignmentInformationDisclosure().set(0);
		StoredVariables.getassignmentInformationAssignedTo().set("Automation Baseline2");
		
		// Set Lender Information data
		StoredVariables.getlenderInformationLenderName().set("BOKF, National Association");
		StoredVariables.getlenderInformationAddress1().set("One Williams Center");
		StoredVariables.getlenderInformationAddress2().set("Suite D");
		StoredVariables.getlenderInformationCity().set("Tulsa");
		StoredVariables.getlenderInformationState().set("OK");
		StoredVariables.getlenderInformationZip().set("74172");
		
		// Set Contact And Access Information data
		StoredVariables.getcontactOccupancy().set("Owner");
		StoredVariables.getcontactBorrower().set("Borrower Name");
		StoredVariables.getcontactBorrowerInfo1Dropdown().set("Home");
		StoredVariables.getcontactBorrowerInfo1().set("405-555-7818");
		StoredVariables.getcontactBorrowerInfo2Dropdown().set("E-mail");
		StoredVariables.getcontactBorrowerInfo2().set("borrower@dntest.net");
		StoredVariables.getcontactBorrowerAddress().set("8051 Falcon Crst");
		StoredVariables.getcontactBorrowerCity().set("Edmond");
		StoredVariables.getcontactBorrowerState().set("OK");
		StoredVariables.getcontactBorrowerZip().set("73034");
		StoredVariables.getcontactCoBorrower().set("Coborrower Name");
		StoredVariables.getcontactCoBorrowerInfo1Dropdown().set("Work");
		StoredVariables.getcontactCoBorrowerInfo1().set("405-555-9813");
		StoredVariables.getcontactCoBorrowerInfo2Dropdown().set("Mobile");
		StoredVariables.getcontactCoBorrowerInfo2().set("405-555-1679");
		StoredVariables.getcontactCoBorrowerAddress().set("1509 Rain Tree Dr");
		StoredVariables.getcontactCoBorrowerCity().set("Moore");
		StoredVariables.getcontactCoBorrowerState().set("OK");
		StoredVariables.getcontactCoBorrowerZip().set("73160");
		StoredVariables.getcontactOwner().set("Owner Name");
		StoredVariables.getcontactOwnerInfo1Dropdown().set("Pager");
		StoredVariables.getcontactOwnerInfo1().set("405-555-8618");
		StoredVariables.getcontactOwnerInfo2Dropdown().set("Fax");
		StoredVariables.getcontactOwnerInfo2().set("405-555-7410");
		StoredVariables.getcontactOccupant().set("Occupant Name");
		StoredVariables.getcontactOccupantInfo1Dropdown().set("Home");
		StoredVariables.getcontactOccupantInfo1().set("405-555-3549");
		StoredVariables.getcontactOccupantInfo2Dropdown().set("Mobile");
		StoredVariables.getcontactOccupantInfo2().set("405-555-8895");
		StoredVariables.getcontactAgent().set("Agent Name");
		StoredVariables.getcontactAgentInfo1Dropdown().set("E-mail");
		StoredVariables.getcontactAgentInfo1().set("agent@dntest.net");
		StoredVariables.getcontactAgentInfo2Dropdown().set("Pager");
		StoredVariables.getcontactAgentInfo2().set("405-555-4893");
		StoredVariables.getcontactOther().set("Other Name");
		StoredVariables.getcontactOtherInfo1Dropdown().set("Work");
		StoredVariables.getcontactOtherInfo1().set("405-555-7825");
		StoredVariables.getcontactOtherInfo2Dropdown().set("Fax");
		StoredVariables.getcontactOtherInfo2().set("405-555-8688");
		StoredVariables.getcontactApptContact().set("Borrower");
		
		// Set Additional Notification Recipients data
		StoredVariables.getadditionalNotificationRecipientsAdditionalEmails().set("additionalEmail1@dntest.net; additionalEmail2@dntest.net");
		StoredVariables.getadditionalNotificationRecipientsAttachCompletedReport().set(true);
		
	} // end setNewCommercialAppraisalOrderVariables
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set Property Information data</li>
	 * 	<li>StoredVariables.getpropertyInformationStateAbbr().set("OK");  Must set for a field check later on</li>
	 * 	<li>Set Assignment Information data</li>
	 * </ul>
	 *
	 * @param driver the new new commercial appraisal order variables minimum
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Set New Commercial Appraisal Order Variables on Secure
	public void setNewCommercialAppraisalOrderVariablesMinimum(RemoteWebDriver driver) throws InterruptedException, IOException {

		// Clear stored variables
		perform.clearOrderInfoStoredVariables(driver);
		
		// Set Property Information data
		StoredVariables.getpropertyInformationAddress().set("501-D NE 122nd St");
		StoredVariables.getpropertyInformationCity().set("Oklahoma City");
		StoredVariables.getpropertyInformationState().set("Oklahoma");
		StoredVariables.getpropertyInformationStateAbbr().set("OK"); // Must set for a field check later on
		StoredVariables.getpropertyInformationZip().set("73114");
		StoredVariables.getpropertyInformationDirections().set("122nd and Kelley");
		
		// Set Assignment Information data
		StoredVariables.getassignmentInformationForm().set("Commercial Appraisal Report");
		StoredVariables.getassignmentInformationIssueAsBid().set(false);
		StoredVariables.getassignmentInformationOrderDue().set(7);
		perform.getNewDate(driver, StoredVariables.getassignmentInformationOrderDue().get());
		StoredVariables.getassignmentInformationLoanNumber().set(perform.randomNumbers(driver, 8));
		
	} // end setNewCommercialAppraisalOrderVariables
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set Property Information data</li>
	 * 	<li>StoredVariables.getpropertyInformationStateAbbr().set("OK");  Must set for a field check later on</li>
	 * 	<li>Property Access</li>
	 * 	<li>Additional Information</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Set New Residential Appraisal Order Variables on Secure
	public void setNewAlternativeValuationOrderVariables(RemoteWebDriver driver) throws InterruptedException, IOException {

		// Clear stored variables
		perform.clearOrderInfoStoredVariables(driver);
		
		/***************************************
		 * Set New Order Information
		 ***************************************/
		
		// Set Property Information data
		StoredVariables.getpropertyInformationAddress().set("10616 Timber Oak Dr");
		StoredVariables.getpropertyInformationCity().set("Oklahoma City");
		StoredVariables.getpropertyInformationState().set("Oklahoma");
		StoredVariables.getpropertyInformationStateAbbr().set("OK"); // Must set for a field check later on
		StoredVariables.getpropertyInformationZip().set("73151");
		
		// Property Access
		StoredVariables.getcontactOther().set("Property Name");
		StoredVariables.getcontactOtherInfo1().set("405-555-7825");
		StoredVariables.getcontactOtherInfo2().set("405-555-8688");
		
		// Additional Information
		StoredVariables.getassignmentInformationLoanNumber().set(perform.randomNumbers(driver, 10));
		StoredVariables.getcontactBorrower().set("Borrower Name");
		StoredVariables.getcontactBorrowerInfo1().set("405-555-7818");
		StoredVariables.getassignmentInformationRushOrder().set(true);
		StoredVariables.getcontactCoBorrower().set("Coborrower Name");
		StoredVariables.getcontactCoBorrowerInfo1().set("405-555-9813");
		
	} // end setNewAlternativeValuationOrderVariables
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Select RealCondition Report</li>
	 * 	<li>Address</li>
	 * 	<li>City</li>
	 * 	<li>State</li>
	 * 	<li>Zip Code</li>
	 * 	<li>Name</li>
	 * 	<li>Phone</li>
	 * 	<li>Alt. phone</li>
	 * 	<li>Notes</li>
	 * 	<li>Loan Number</li>
	 * 	<li>Borrower</li>
	 * 	<li>Borrower Email</li>
	 * 	<li>Rush Order</li>
	 * 	<li>Coborrower</li>
	 * 	<li>Coborrower Email</li>
	 * 	<li>Add info to Extent Report</li>
	 * 	<li>Fill out New Order Form on Secure</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param product the Alternative Valuation product
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Fill out New Order Form on Secure
	public void enterNewAlternativeValuationOrder(RemoteWebDriver driver, String product) throws InterruptedException, IOException {
		
		ExtentTest test = ExtentTestManager.getTest();
		
		// Select RealCondition Report
		perform.selectDropdownOption(driver, SNewAltValOrder.product_dropdown(driver), product);
		
		// Wait for Address textbox
		perform.waitForElementToBeClickable(driver, SNewAltValOrder.address_txtbx(driver));
		
		/***************************************
		 * Enter Property Information
		 ***************************************/
		
		// Address
		perform.type(driver, SNewAltValOrder.address_txtbx(driver), StoredVariables.getpropertyInformationAddress().get());

		// City
		perform.type(driver, SNewAltValOrder.city_txtbx(driver), StoredVariables.getpropertyInformationCity().get());
		
		// State
		perform.selectDropdownOption(driver, SNewAltValOrder.state_dropdown(driver), StoredVariables.getpropertyInformationState().get());
		
		// Zip Code
		perform.waitForElementToBeClickable(driver, SNewAltValOrder.zipCode_txtbx(), "id");
		perform.type(driver, SNewAltValOrder.zipCode_txtbx(driver), StoredVariables.getpropertyInformationZip().get());
		
		/***************************************
		 * Enter Property access Information
		 ***************************************/
		if (!product.equals("OptiVal AVM Cascade")) {
			
			// Name
			perform.type(driver, SNewAltValOrder.name_txtbx(driver), StoredVariables.getcontactOther().get());
			
			// Phone
			perform.type(driver, SNewAltValOrder.phone_txtbx(driver), StoredVariables.getcontactOtherInfo1().get());
			
			// Alt. phone
			if (!StoredVariables.getcontactOtherInfo2().get().equals("")) {
				perform.type(driver, SNewAltValOrder.altPhone_txtbx(driver), StoredVariables.getcontactOtherInfo2().get());	
			} // end if
			
			// Notes
			perform.type(driver, SNewAltValOrder.notes_txtbx(driver), "These are test notes");
		
		} // end if product
		
		/***************************************
		 * Enter Additional Information
		 ***************************************/
		
		// Loan Number
		if (!StoredVariables.getassignmentInformationLoanNumber().get().equals("")) {
			perform.type(driver, SNewAltValOrder.loanNumber_txtbx(driver), StoredVariables.getassignmentInformationLoanNumber().get());	
		} // end if
		
		// Borrower
		if (!StoredVariables.getcontactBorrower().get().equals("")) {
			perform.type(driver, SNewAltValOrder.borrower_txtbx(driver), StoredVariables.getcontactBorrower().get());	
		} // end if
		
		// Borrower Email
		if (!StoredVariables.getcontactBorrowerInfo1().get().equals("")) {
			perform.type(driver, SNewAltValOrder.borrowerEmail_txtbx(driver), StoredVariables.getcontactBorrowerInfo1().get());	
		} // end if
		
		if (!product.equals("OptiVal AVM Cascade")) {
			// Rush Order
			if (StoredVariables.getassignmentInformationRushOrder().get()==(true)) {
				perform.checkCheckbox(driver, SNewAltValOrder.rushOrder_chkbx(driver));
			} // end if
		} // end if not OptiVal AVM Cascade
		
		// Coborrower
		if (!StoredVariables.getcontactCoBorrower().get().equals("")) {
			perform.type(driver, SNewAltValOrder.coborrower_txtbx(driver), StoredVariables.getcontactCoBorrower().get());	
		} // end if
		
		// Coborrower Email
		if (!StoredVariables.getcontactCoBorrowerInfo1().get().equals("")) {
			perform.type(driver, SNewAltValOrder.coborrowerEmail_txtbx(driver), StoredVariables.getcontactCoBorrowerInfo1().get());	
		} // end if
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Entered new Alternative Valuation order info");
		
	} // end enterNewAlternativeValuationOrder
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click Finish</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Fill out New Order Form on Secure
	public void completeNewAlternativeValuationOrder(RemoteWebDriver driver) throws InterruptedException, IOException {
		
		ExtentTest test = ExtentTestManager.getTest();
		
		// Click Finish
		perform.click(driver, SNewAltValOrder.finishBottom_btn(driver));
		
		// Wait for the audit trail to display
		perform.waitForElementToBeClickable(driver, SQVPOrderDetails.history_txt(driver));
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Completed the Alternative Valuation order");
		
	} // end completeNewAlternativeValuationOrder
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void waitForAlternativeValuationOrderToReturn(RemoteWebDriver driver) throws InterruptedException, IOException {
		
		System.out.println("Waiting for AVM product to return");
		
		// Get the number of sales grid items
		List<WebElement> salesGrid = driver.findElements(By.id("Main_Main_upRecentSalesOV"));

		// Wait until there are items in the sales grid
		int i = 1;
		while (salesGrid.size()<1 && i<=72)
		{
			
			// Refresh the page
			driver.navigate().refresh();
			
			// Get the number of sales grid items
			salesGrid = driver.findElements(By.id("Main_Main_upRecentSalesOV"));
			
			// Wait 5 seconds before refreshing the page again
			perform.sleep(driver, 5);
			
			i++;
			
		} // end while

		// Verify the AVM was returned
		Assert.assertTrue(salesGrid.size()>0, "AVM was not returned");
		
		// Add info to Extent Report
		perform.addInfoToExtentReport(driver, "Info", "Waited for Alternative Valuation to return");
		
	} // end waitForAlternativeValuationOrderToReturn
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Add Order Group</li>
	 * 	<li>Address</li>
	 * 	<li>City</li>
	 * 	<li>State</li>
	 * 	<li>Zip Code</li>
	 * 	<li>Click out of Zip Code field</li>
	 * 	<li>Verify the map loads properly</li>
	 * 	<li>Scroll to County text field</li>
	 * 	<li>Take a screenshot</li>
	 * 	<li>Add info to Extent Report</li>
	 * 	<li>Send an email</li>
	 * 	<li>Sq ft</li>
	 * 	<li>enter sq ft</li>
	 * 	<li>Verify Sq ft is entered correctly</li>
	 * 	<li>Site Size</li>
	 * 	<li>Prop Type</li>
	 * 	<li>Prop rights</li>
	 * 	<li>Legal desc</li>
	 * 	<li>Directions</li>
	 * 	<li>Get directionsIdentifier used to uniquely identify the order number and store it</li>
	 * 	<li>Enter Directions</li>
	 * 	<li>Verify Directions were entered correctly</li>
	 * 	<li>Enter Directions</li>
	 * 	<li>Verify Legal was entered correctly</li>
	 * 	<li>Enter Directions</li>
	 * 	<li>Form/type</li>
	 * 	<li>Check Rush Order</li>
	 * 	<li>Check Complex checkbox</li>
	 * 	<li>Other Ref #</li>
	 * 	<li>Loan Type</li>
	 * 	<li>Loan Purpose</li>
	 * 	<li>Ordered By</li>
	 * 	<li>Loan #</li>
	 * 	<li>File #</li>
	 * 	<li>Sales Price</li>
	 * 	<li>FHA Case #</li>
	 * 	<li>Set Order Due Date (Long and Short)</li>
	 * 	<li>Select the Order Due date</li>
	 * 	<li>Enter Order Due date</li>
	 * 	<li>Click the Order Due calendar button</li>
	 * 	<li>Select the date</li>
	 * 	<li>Click the Order Due calendar button</li>
	 * 	<li>Select the date</li>
	 * 	<li>Enter Order Due date</li>
	 * 	<li>Verify the correct order due date is correct</li>
	 * 	<li>Set Disclosure Date (Long and Short)</li>
	 * 	<li>Select Disclosure Date</li>
	 * 	<li>Enter Disclosure date</li>
	 * 	<li>Click calendar for Disclosure</li>
	 * 	<li>Select the date</li>
	 * 	<li>Click Disclosure Due Date</li>
	 * 	<li>Enter Disclosure date</li>
	 * 	<li>Verify the date is correct</li>
	 * 	<li>Assigned To</li>
	 * 	<li>Lender name</li>
	 * 	<li>Address 1</li>
	 * 	<li>Address 2</li>
	 * 	<li>City</li>
	 * 	<li>State</li>
	 * 	<li>Zip</li>
	 * 	<li>Occupancy</li>
	 * 	<li>Borrower</li>
	 * 	<li>Get borrower identifier to uniquely identify the borrower</li>
	 * 	<li>Borrower Info 1 dropdown</li>
	 * 	<li>Borrower Info 1</li>
	 * 	<li>Borrower Info 2 dropdown</li>
	 * 	<li>Borrower Info 2</li>
	 * 	<li>Click Borrower Address button</li>
	 * 	<li>Check Same as subject property address checkbox</li>
	 * 	<li>Verify property address populated</li>
	 * 	<li>Click Cancel</li>
	 * 	<li>Click Borrower Address button</li>
	 * 	<li>Uncheck Same as subject property address checkbox</li>
	 * 	<li>Verify address fields are empty</li>
	 * 	<li>Address</li>
	 * 	<li>City</li>
	 * 	<li>State</li>
	 * 	<li>Zip</li>
	 * 	<li>Click Save</li>
	 * 	<li>Co-borrower</li>
	 * 	<li>Co-borrower Info 1 dropdown</li>
	 * 	<li>Co-borrower Info 1</li>
	 * 	<li>Co-borrower Info 2 dropdown</li>
	 * 	<li>Co-borrower Info 2</li>
	 * 	<li>Click Co-borrower Address button</li>
	 * 	<li>Check Same as subject property address checkbox</li>
	 * 	<li>Verify borrower address populated</li>
	 * 	<li>Click Cancel</li>
	 * 	<li>Click Co-borrower Address button</li>
	 * 	<li>Uncheck Same as subject property address checkbox</li>
	 * 	<li>Address</li>
	 * 	<li>City</li>
	 * 	<li>State</li>
	 * 	<li>Zip</li>
	 * 	<li>Click Save</li>
	 * 	<li>Owner</li>
	 * 	<li>Owner Info 1 dropdown</li>
	 * 	<li>Owner Info 1</li>
	 * 	<li>Owner Info 2 dropdown</li>
	 * 	<li>Owner Info 2</li>
	 * 	<li>Occupant</li>
	 * 	<li>Occupant Info 1 dropdown</li>
	 * 	<li>Occupant Info 1</li>
	 * 	<li>Occupant Info 2 dropdown</li>
	 * 	<li>Occupant Info 2</li>
	 * 	<li>Agent</li>
	 * 	<li>Agent Info 1 dropdown</li>
	 * 	<li>Agent Info 1</li>
	 * 	<li>Agent Info 2 dropdown</li>
	 * 	<li>Agent Info 2</li>
	 * 	<li>Other</li>
	 * 	<li>Other Info 1 dropdown</li>
	 * 	<li>Other Info 1</li>
	 * 	<li>Other Info 2 dropdown</li>
	 * 	<li>Other Info 2</li>
	 * 	<li>Appt. Contact</li>
	 * 	<li>Enter additional email addresses</li>
	 * 	<li>Check Attach completed report</li>
	 * 	<li>Click the Click here link</li>
	 * 	<li>Verify information text</li>
	 * 	<li>Click the OK button</li>
	 * 	<li>Scroll to the Next button</li>
	 * 	<li>Verify county is not empty</li>
	 * 	<li>Scroll to County text field</li>
	 * 	<li>Take a screenshot</li>
	 * 	<li>Add info to Extent Report</li>
	 * 	<li>Send an email</li>
	 * 	<li>Add info to Extent Report</li>
	 * 	<li>Fill out New Order Form on Secure</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws Exception the exception
	 */
	// Fill out New Order Form on Secure
	public void enterNewResidentialAppraisalOrder(RemoteWebDriver driver) throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		
		// Add Order Group
		if (!StoredVariables.getassignmentInformationOrderGroup().get().equals(""))
		{
			addOrderGroupToOrder(driver, StoredVariables.getassignmentInformationOrderGroup().get());
		} // end if for non-empty order group
		
		/***************************************
		 * Enter Property Information
		 ***************************************/
		
		// Wait for address
		perform.waitForElementToBeClickable(driver, SNewOrder.address_txtbx(), "id");
		
		// Address
		perform.type(driver, SNewOrder.address_txtbx(driver), StoredVariables.getpropertyInformationAddress().get());

		// City
		perform.type(driver, SNewOrder.city_txtbx(driver), StoredVariables.getpropertyInformationCity().get());
		
		// State
		perform.selectDropdownOption(driver, SNewOrder.state_dropdown(driver), StoredVariables.getpropertyInformationState().get());
		
		// Zip Code
		perform.waitForElementToBeClickable(driver, SNewOrder.zipCode_txtbx(), "id");
		perform.type(driver, SNewOrder.zipCode_txtbx(driver), StoredVariables.getpropertyInformationZip().get());
		
		// Click out of Zip Code field
		perform.click(driver, SNewOrder.sqFt_txtbx(driver));
		
		Thread.sleep(3000);
		
		// Verify the map loads properly
//		String mapErrorStyle = SNewOrder.mapDisplay(driver).getAttribute("style");
//		int a = 1;
//		while (!mapErrorStyle.contains("display: none;") && a <= 5) {
//			Thread.sleep(1000);
//			mapErrorStyle = SNewOrder.mapDisplay(driver).getAttribute("style");
//			a++;
//		} // end while
//		if (!mapErrorStyle.contains("display: none;")) {
//			
//			System.out.println("The map is not displayed");
//			
//			// Scroll to County text field
//			perform.scrollElementIntoView(driver, SNewOrder.mapDisplay(driver));
//			
//			// Take a screenshot
//			perform.takeScreenshot(driver);
//			
//			// Add info to Extent Report
//			test.log(LogStatus.WARNING, "Warning", "The map is not loading on Secure when entering new order info");
//			
//			// Send an email
//			perform.sendEmail(driver, "dnorman@corelogic.com", "qa.vsg2@corelogic.com", "The map is not loading in Secure on " + StoredVariables.getenvironment().get(), "The map is not loading in Secure - "+StoredVariables.getenvironment().get()+" when entering a new order.\n\nClick here to view the screenshot: \""+StoredVariables.getscreenshotImage().get() + "\"");
//			
//		} // end if displayed is false
		
		SNewOrder.county_txtbx(driver).getText();
		
		// Sq ft
		if (!StoredVariables.getpropertyInformationSqFt().get().equals("")) {

			// enter sq ft
			perform.type(driver, SNewOrder.sqFt_txtbx(driver), StoredVariables.getpropertyInformationSqFt().get());	
		
			// Verify Sq ft is entered correctly
			if (!SNewOrder.sqFt_txtbx(driver).getAttribute("value").equals(StoredVariables.getpropertyInformationSqFt().get()))
			{
				perform.type(driver, SNewOrder.sqFt_txtbx(driver), StoredVariables.getpropertyInformationSqFt().get());
			}
		
		} // end if
		
		// Site Size
		if (!StoredVariables.getpropertyInformationSiteSize().get().equals("")) {
			perform.type(driver, SNewOrder.siteSize_txtbx(driver), StoredVariables.getpropertyInformationSiteSize().get());
		}
		
		// Prop Type
		if (!StoredVariables.getpropertyInformationPropType().get().equals("")) {
			try {
				perform.selectDropdownOption(driver, SNewOrder.propType_dropdown(driver), StoredVariables.getpropertyInformationPropType().get());
			} catch (Exception e) {
				perform.selectDropdownOption(driver, SNewOrder.propType_dropdown(driver), StoredVariables.getpropertyInformationPropType().get());
			} // end try/catch
		}
		
		// Prop rights
		if (!StoredVariables.getpropertyInformationPropRights().get().equals("")) {
			perform.selectDropdownOption(driver, SNewOrder.propRights_dropdown(driver), StoredVariables.getpropertyInformationPropRights().get());
		}
		
		// Legal desc
		if (!StoredVariables.getpropertyInformationLegalDesc().get().equals("")) {
			perform.type(driver, SNewOrder.legalDesc_txtbx(driver), StoredVariables.getpropertyInformationLegalDesc().get());
		}
		
		// Directions
		// Get directionsIdentifier used to uniquely identify the order number and store it
		StoredVariables.getdirectionsIdentifier().set(new SimpleDateFormat("MMddHHmmss").format(Calendar.getInstance().getTime()) + " - " + perform.randomNumbers(driver, 5));
		StoredVariables.getpropertyInformationDirections().set(StoredVariables.getpropertyInformationDirections().get() + " - " + StoredVariables.getdirectionsIdentifier().get());
		// Enter Directions
		perform.type(driver, SNewOrder.directions_txtbx(driver), StoredVariables.getpropertyInformationDirections().get());
		
		// Verify Directions were entered correctly
		if (!SNewOrder.directions_txtbx(driver).getAttribute("value").equals(StoredVariables.getpropertyInformationDirections().get()))
		{
			// Enter Directions
			perform.type(driver, SNewOrder.directions_txtbx(driver), StoredVariables.getpropertyInformationDirections().get());
		} // end if
		
		// Verify Legal was entered correctly
		if (!StoredVariables.getpropertyInformationLegalDesc().get().equals("")) {
			if (SNewOrder.legalDesc_txtbx(driver).getAttribute("value").equals(StoredVariables.getpropertyInformationLegalDesc().get()))
			{
				// Enter Directions
				perform.type(driver, SNewOrder.legalDesc_txtbx(driver), StoredVariables.getpropertyInformationLegalDesc().get());
			} // end if
		} // end if

		/***************************************
		 * Enter Assignment Information
		 ***************************************/
		
		// Form/type
		perform.selectDropdownOption(driver, SNewOrder.form_dropdown(driver), StoredVariables.getassignmentInformationForm().get());
		
		// Check Rush Order
		if (StoredVariables.getassignmentInformationRushOrder().get() == true && !SNewOrder.rushOrder_chkbx(driver).isSelected())
		{
			perform.click(driver, SNewOrder.rushOrder_chkbx(driver));
		}
		else if (StoredVariables.getassignmentInformationRushOrder().get() == false && SNewOrder.rushOrder_chkbx(driver).isSelected())
		{
			perform.click(driver, SNewOrder.rushOrder_chkbx(driver));
		}
		
		// Check Complex checkbox
		if (StoredVariables.getassignmentInformationComplex().get() == true && !SNewOrder.complex_chkbx(driver).isSelected())
		{
			perform.click(driver, SNewOrder.complex_chkbx(driver));				
		}
		else if (StoredVariables.getassignmentInformationComplex().get() == false && SNewOrder.complex_chkbx(driver).isSelected())
		{
			perform.click(driver, SNewOrder.complex_chkbx(driver));
		}
		
		// Other Ref #
		if (!StoredVariables.getassignmentInformationOtherRefNumber().get().equals("")) {
			perform.type(driver, SNewOrder.otherRefNumber_txtbx(driver), StoredVariables.getassignmentInformationOtherRefNumber().get());
		}
		
		// Loan Type
		if (!StoredVariables.getassignmentInformationLoanType().get().equals("")) {
			perform.selectDropdownOption(driver, SNewOrder.loanType_dropdown(driver), StoredVariables.getassignmentInformationLoanType().get());
		}
		
		// Loan Purpose
		if (!StoredVariables.getassignmentInformationLoanPurpose().get().equals("")) {
			perform.selectDropdownOption(driver, SNewOrder.loanPurpose_dropdown(driver), StoredVariables.getassignmentInformationLoanPurpose().get());
		}
		
		// Ordered By
		if (!StoredVariables.getassignmentInformationOrderedBy().get().equals("")) {
			perform.type(driver, SNewOrder.orderedBy_txtbx(driver), StoredVariables.getassignmentInformationOrderedBy().get());
		}
		
		// Loan #
		if (!StoredVariables.getassignmentInformationLoanNumber().get().equals("")) {
			perform.type(driver, SNewOrder.loanNumber_txtbx(driver), StoredVariables.getassignmentInformationLoanNumber().get());
		}
		
		// File #
		if (!StoredVariables.getassignmentInformationFileNumber().get().equals("")) {
			perform.type(driver, SNewOrder.fileNumber_txtbx(driver), StoredVariables.getassignmentInformationFileNumber().get());
		}
		
		// Sales Price
		if (!StoredVariables.getassignmentInformationSalesPrice().get().equals("")) {
			perform.type(driver, SNewOrder.salesPrice_txtbx(driver), StoredVariables.getassignmentInformationSalesPrice().get());
		}
		
		// FHA Case #
		if (!StoredVariables.getassignmentInformationFHACaseNumber().get().equals("")) {
			perform.type(driver, SNewOrder.fhaCaseNumber_txtbx(driver), StoredVariables.getassignmentInformationFHACaseNumber().get());
		}
		
		// Set Order Due Date (Long and Short)
		perform.getNewDate(driver, StoredVariables.getassignmentInformationOrderDue().get());
		StoredVariables.getorderDueDateLong().set(StoredVariables.getnewDateLong().get());
		StoredVariables.getorderDueDateShort().set(StoredVariables.getnewDateShort().get());
		
		// Select the Order Due date
		Thread.sleep(1000);
		if (StoredVariables.getbrowser().get().equals("PhantomJS") || StoredVariables.getbrowser().get().equals("HtmlUnit") || StoredVariables.getbrowser().get().equals("IE"))
		{
			// Enter Order Due date
			perform.type(driver, SNewOrder.orderDue_txtbx(driver), StoredVariables.getorderDueDateLong().get());
		}
		else
		{
			// Click the Order Due calendar button
			perform.click(driver, SNewOrder.orderDueCalendar_btn(driver));
			
			// Wait for calendar to be displayed
			int i = 0;
			String style = SNewOrder.calendarDisplay(driver).getAttribute("style");
			while (!style.contains("block") && i <= 5) {
				Thread.sleep(1000);
				style = SNewOrder.calendarDisplay(driver).getAttribute("style");
				i++;
			} // end while
			
			try {
				
				// Select the date
				selectDateFromCalendar(driver, StoredVariables.getassignmentInformationOrderDue().get());
				
			} catch (Exception e) {
				
				style = SNewOrder.calendarDisplay(driver).getAttribute("style");
				if (!style.contains("block")) {
					// Click the Order Due calendar button
					perform.click(driver, SNewOrder.orderDueCalendar_btn(driver));
				} // end if

				// Select the date
				selectDateFromCalendar(driver, StoredVariables.getassignmentInformationOrderDue().get());
				
			} // end try/catch
			
			if (!SNewOrder.orderDue_txtbx(driver).getAttribute("value").equals(StoredVariables.getcalendarDateLong().get())) {
				// Enter Order Due date
				perform.type(driver, SNewOrder.orderDue_txtbx(driver), StoredVariables.getorderDueDateLong().get());
			}
			
			// Verify the correct order due date is correct
			Assert.assertTrue(SNewOrder.orderDue_txtbx(driver).getAttribute("value").equals(StoredVariables.getcalendarDateLong().get()), "Date selected from calendar is the wrong date. Trying to match - " + StoredVariables.getcalendarDateLong().get());
			
		} // end if/else
		
		// Set Disclosure Date (Long and Short)
		if (StoredVariables.getassignmentInformationDisclosure().get() != null) {
			
			if (!StoredVariables.getassignmentInformationDisclosure().get().equals("")) {
				perform.getNewDate(driver, StoredVariables.getassignmentInformationDisclosure().get());
				StoredVariables.getdisclosureDateLong().set(StoredVariables.getnewDateLong().get());
				StoredVariables.getdisclosureDateShort().set(StoredVariables.getnewDateShort().get());
				
				// Select Disclosure Date
				if (StoredVariables.getbrowser().get().equals("PhantomJS") || StoredVariables.getbrowser().get().equals("HtmlUnit") || StoredVariables.getbrowser().get().equals("IE")) {
					
					// Enter Disclosure date
					perform.type(driver, SNewOrder.disclosure_txtbx(driver), StoredVariables.getdisclosureDateLong().get());
					
				} else {
					// Click calendar for Disclosure
					perform.click(driver, SNewOrder.disclosureCalendar_btn(driver));
					
					// Select the date
					selectDateFromCalendar(driver, StoredVariables.getassignmentInformationDisclosure().get());
					
					if (!SNewOrder.disclosure_txtbx(driver).getAttribute("value").equals(StoredVariables.getdisclosureDateLong().get())) {
						
						// Click Disclosure Due Date
						perform.click(driver, SNewOrder.disclosure_txtbx(driver));
						
						// Enter Disclosure date
						perform.type(driver, SNewOrder.disclosure_txtbx(driver), StoredVariables.getdisclosureDateLong().get());
						
					} // end if
						
				} // end if/else
				
				// Verify the date is correct
				Assert.assertTrue(SNewOrder.disclosure_txtbx(driver).getAttribute("value").equals(StoredVariables.getdisclosureDateLong().get()), "Date selected from calendar is the wrong date. It is - " + SNewOrder.disclosure_txtbx(driver).getAttribute("value") + " but should be " + StoredVariables.getdisclosureDateLong().get());
				
			} // end if
		} // end if null
		
		// Assigned To
		if (!StoredVariables.getassignmentInformationAssignedTo().get().equals(""))
		{
			perform.selectDropdownOption(driver, SNewOrder.assignedTo_dropdown(driver), StoredVariables.getassignmentInformationAssignedTo().get());
		}
		
		/***************************************
		 * Enter Lender Information
		 ***************************************/
		
		// Lender name
		if (!StoredVariables.getlenderInformationLenderName().get().equals("")) {
			perform.type(driver, SNewOrder.lenderName_txtbx(driver), StoredVariables.getlenderInformationLenderName().get());
		}
		
		// Address 1
		if (!StoredVariables.getlenderInformationAddress1().get().equals("")) {
			perform.type(driver, SNewOrder.lenderAddress1_txtbx(driver), StoredVariables.getlenderInformationAddress1().get());
		}
		
		// Address 2
		if (!StoredVariables.getlenderInformationAddress2().get().equals("")) {
			perform.type(driver, SNewOrder.lenderAddress2_txtbx(driver), StoredVariables.getlenderInformationAddress2().get());
		}
		
		// City
		if (!StoredVariables.getlenderInformationCity().get().equals("")) {
			perform.type(driver, SNewOrder.lenderCity_txtbx(driver), StoredVariables.getlenderInformationCity().get());
		}
		
		// State
		if (!StoredVariables.getlenderInformationState().get().equals("")) {
			perform.waitForElementToBeClickable(driver, SNewOrder.lenderState_dropdown(), "id");
			perform.selectDropdownOption(driver, SNewOrder.lenderState_dropdown(driver), StoredVariables.getpropertyInformationStateAbbr().get());
		}
		
		// Zip
		if (!StoredVariables.getlenderInformationZip().get().equals("")) {
			perform.type(driver, SNewOrder.lenderZip_txtbx(driver), StoredVariables.getlenderInformationZip().get());
		}
		
		/***************************************
		 * Enter Contact And Access Information
		 ***************************************/
		
		// Occupancy
		if (!StoredVariables.getcontactOccupancy().get().equals("")) {
			perform.selectDropdownOption(driver, SNewOrder.occupancy_dropdown(driver), StoredVariables.getcontactOccupancy().get());
		}
		
		// Borrower
		if (!StoredVariables.getcontactBorrower().get().equals("")) {
			// Get borrower identifier to uniquely identify the borrower
			StoredVariables.getborrowerIdentifier().set(new SimpleDateFormat("MMddHHmmss").format(Calendar.getInstance().getTime()));
			perform.type(driver, SNewOrder.borrower_txtbx(driver), StoredVariables.getcontactBorrower().get() + "-" + StoredVariables.getborrowerIdentifier().get());
		}
		
		// Borrower Info 1 dropdown
		if (!StoredVariables.getcontactBorrowerInfo1Dropdown().get().equals("")) {
			perform.selectDropdownOption(driver, SNewOrder.borrowerInfo1_dropdown(driver), StoredVariables.getcontactBorrowerInfo1Dropdown().get());
		}
		
		// Borrower Info 1
		if (!StoredVariables.getcontactBorrowerInfo1().get().equals("")) {
			perform.type(driver, SNewOrder.borrowerInfo1_txtbx(driver), StoredVariables.getcontactBorrowerInfo1().get());
		}
		
		// Borrower Info 2 dropdown
		if (!StoredVariables.getcontactBorrowerInfo2Dropdown().get().equals("")) {
			perform.selectDropdownOption(driver, SNewOrder.borrowerInfo2_dropdown(driver), StoredVariables.getcontactBorrowerInfo2Dropdown().get());
		}
		
		// Borrower Info 2
		if (!StoredVariables.getcontactBorrowerInfo2().get().equals("")) {
			perform.type(driver, SNewOrder.borrowerInfo2_txtbx(driver), StoredVariables.getcontactBorrowerInfo2().get());
		}
		
		if (!StoredVariables.getcontactBorrowerAddress().get().equals("")) {
			
			// Click Borrower Address button
			perform.click(driver, SNewOrder.borrowerAddress_btn(driver));
			
			// Check Same as subject property address checkbox
			perform.checkCheckbox(driver, SNewOrder.sameAsPropertyAddress_chkbx(driver));
			
			// Verify property address populated
			Assert.assertTrue(StoredVariables.getpropertyInformationAddress().get().equals(SNewOrder.borrowerAddress_txtbx(driver).getAttribute("value")), "The borrower contact property address did not pull in. On-screen = " + SNewOrder.borrowerAddress_txtbx(driver).getAttribute("value"));
			Assert.assertTrue(StoredVariables.getpropertyInformationCity().get().equals(SNewOrder.borrowerCity_txtbx(driver).getAttribute("value")), "The borrower contact property city did  not pull in. On-screen = " + SNewOrder.borrowerCity_txtbx(driver).getAttribute("value"));
			Assert.assertTrue(StoredVariables.getpropertyInformationStateAbbr().get().equals(SNewOrder.borrowerState_txtbx(driver).getAttribute("value")), "The borrower contact property state did not pull in. On-screen = " + SNewOrder.borrowerState_txtbx(driver).getAttribute("value"));
//			Assert.assertTrue(propertyZip.equals(SNewOrder.borrowerZip_txtbx(driver).getAttribute("value")), "The borrower contact property zip code did not pull in");
//			perform.commentedBug(driver, "Zip code not being pulled in for borrower address");
			
			// Click Cancel
			perform.click(driver, SNewOrder.borrowerCancel_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			// Click Borrower Address button
			perform.click(driver, SNewOrder.borrowerAddress_btn(driver));
			
			// Uncheck Same as subject property address checkbox
			if (SNewOrder.sameAsPropertyAddress_chkbx(driver).isSelected())
			{
				perform.click(driver, SNewOrder.sameAsPropertyAddress_chkbx(driver));	
			}
			
			// Verify address fields are empty
			Assert.assertTrue(SNewOrder.borrowerAddress_txtbx(driver).getAttribute("value").equals(""), "The borrower contact property address did not clear");
			Assert.assertTrue(SNewOrder.borrowerCity_txtbx(driver).getAttribute("value").equals(""), "The borrower contact property city did  not clear");
			Assert.assertTrue(SNewOrder.borrowerState_txtbx(driver).getAttribute("value").equals(""), "The borrower contact property state did not clear");
			Assert.assertTrue(SNewOrder.borrowerZip_txtbx(driver).getAttribute("value").equals(""), "The borrower contact property zip code did not clear");
			
			// Address
			perform.type(driver, SNewOrder.borrowerAddress_txtbx(driver), StoredVariables.getcontactBorrowerAddress().get());
			
			// City
			perform.type(driver, SNewOrder.borrowerCity_txtbx(driver), StoredVariables.getcontactBorrowerCity().get());
			
			// State
			perform.type(driver, SNewOrder.borrowerState_txtbx(driver), StoredVariables.getcontactBorrowerState().get());
			
			// Zip
			perform.type(driver, SNewOrder.borrowerZip_txtbx(driver), StoredVariables.getcontactBorrowerZip().get());
			
			// Click Save
			perform.click(driver, SNewOrder.borrowerSave_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
		} // end if
		
		// Co-borrower
		if (!StoredVariables.getcontactCoBorrower().get().equals("")) {
			perform.type(driver, SNewOrder.coBorrower_txtbx(driver), StoredVariables.getcontactCoBorrower().get());
		}
		
		// Co-borrower Info 1 dropdown
		if (!StoredVariables.getcontactCoBorrowerInfo1Dropdown().get().equals("")) {
			perform.selectDropdownOption(driver, SNewOrder.coBorrowerInfo1_dropdown(driver), StoredVariables.getcontactCoBorrowerInfo1Dropdown().get());
		}
		
		// Co-borrower Info 1
		if (!StoredVariables.getcontactCoBorrowerInfo1().get().equals("")) {
			perform.type(driver, SNewOrder.coBorrowerInfo1_txtbx(driver), StoredVariables.getcontactCoBorrowerInfo1().get());
		}
		
		// Co-borrower Info 2 dropdown
		if (!StoredVariables.getcontactCoBorrowerInfo2Dropdown().get().equals("")) {
			perform.selectDropdownOption(driver, SNewOrder.coBorrowerInfo2_dropdown(driver), StoredVariables.getcontactCoBorrowerInfo2Dropdown().get());
		}
		
		// Co-borrower Info 2
		if (!StoredVariables.getcontactCoBorrowerInfo2().get().equals("")) {
			perform.type(driver, SNewOrder.coBorrowerInfo2_txtbx(driver), StoredVariables.getcontactCoBorrowerInfo2().get());
		}
		
		if (!StoredVariables.getcontactCoBorrowerAddress().get().equals("")) {
			
			// Click Co-borrower Address button
			perform.click(driver, SNewOrder.coBorrowerAddress_btn(driver));
			
			// Wait for checkbox
			perform.waitForElementToBeClickable(driver, SNewOrder.coBorrowerSameAsSubjectPropertyAddress_chkbx(), "id");
			
			// Check Same as subject property address checkbox
			if (!SNewOrder.coBorrowerSameAsSubjectPropertyAddress_chkbx(driver).isSelected())
			{
				perform.click(driver, SNewOrder.coBorrowerSameAsSubjectPropertyAddress_chkbx(driver));	
			}
			
			// Verify borrower address populated
			Assert.assertTrue(StoredVariables.getcontactBorrowerAddress().get().equals(SNewOrder.coBorrowerAddress_txtbx(driver).getAttribute("value")), "The co-borrower contact property address did not pull in");
			Assert.assertTrue(StoredVariables.getcontactBorrowerCity().get().equals(SNewOrder.coBorrowerCity_txtbx(driver).getAttribute("value")), "The co-borrower contact property city did  not pull in");
			Assert.assertTrue(StoredVariables.getcontactBorrowerState().get().equals(SNewOrder.coBorrowerState_txtbx(driver).getAttribute("value")), "The co-borrower contact property state did not pull in");
			Assert.assertTrue(StoredVariables.getcontactBorrowerZip().get().equals(SNewOrder.coBorrowerZip_txtbx(driver).getAttribute("value")), "The co-borrower contact property zip code did not pull in");
			
			// Click Cancel
			perform.click(driver, SNewOrder.coBorrowerCancel_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			// Click Co-borrower Address button
			perform.click(driver, SNewOrder.coBorrowerAddress_btn(driver));
			
			// Uncheck Same as subject property address checkbox
			if (SNewOrder.coBorrowerSameAsSubjectPropertyAddress_chkbx(driver).isSelected())
			{
				perform.click(driver, SNewOrder.coBorrowerSameAsSubjectPropertyAddress_chkbx(driver));	
			}
			
			// Address
			perform.type(driver, SNewOrder.coBorrowerAddress_txtbx(driver), StoredVariables.getcontactCoBorrowerAddress().get());
			
			// City
			perform.type(driver, SNewOrder.coBorrowerCity_txtbx(driver), StoredVariables.getcontactCoBorrowerCity().get());
			
			// State
			perform.type(driver, SNewOrder.coBorrowerState_txtbx(driver), StoredVariables.getcontactCoBorrowerState().get());
			
			// Zip
			perform.type(driver, SNewOrder.coBorrowerZip_txtbx(driver), StoredVariables.getcontactCoBorrowerZip().get());
			
			// Click Save
			perform.click(driver, SNewOrder.coBorrowerSave_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
		} // end if
		
		// Owner
		if (!StoredVariables.getcontactOwner().get().equals("")) {
			perform.type(driver, SNewOrder.owner_txtbx(driver), StoredVariables.getcontactOwner().get());
		}
		
		// Owner Info 1 dropdown
		if (!StoredVariables.getcontactOwnerInfo1Dropdown().get().equals("")) {
			perform.selectDropdownOption(driver, SNewOrder.ownerInfo1_dropdown(driver), StoredVariables.getcontactOwnerInfo1Dropdown().get());
		}
		
		// Owner Info 1
		if (!StoredVariables.getcontactOwnerInfo1().get().equals("")) {
			perform.type(driver, SNewOrder.ownerInfo1_txtbx(driver), StoredVariables.getcontactOwnerInfo1().get());
		}
		
		// Owner Info 2 dropdown
		if (!StoredVariables.getcontactOwnerInfo2Dropdown().get().equals("")) {
			perform.selectDropdownOption(driver, SNewOrder.ownerInfo2_dropdown(driver), StoredVariables.getcontactOwnerInfo2Dropdown().get());
		}
		
		// Owner Info 2
		if (!StoredVariables.getcontactOwnerInfo2().get().equals("")) {
			perform.type(driver, SNewOrder.ownerInfo2_txtbx(driver), StoredVariables.getcontactOwnerInfo2().get());
		}
		
		// Occupant
		if (!StoredVariables.getcontactOccupant().get().equals("")) {
			perform.type(driver, SNewOrder.occupant_txtbx(driver), StoredVariables.getcontactOccupant().get());
		}
		
		// Occupant Info 1 dropdown
		if (!StoredVariables.getcontactOccupantInfo1Dropdown().get().equals("")) {
			perform.selectDropdownOption(driver, SNewOrder.occupantInfo1_dropdown(driver), StoredVariables.getcontactOccupantInfo1Dropdown().get());
		}
		
		// Occupant Info 1
		if (!StoredVariables.getcontactOccupantInfo1().get().equals("")) {
			perform.type(driver, SNewOrder.occupantInfo1_txtbx(driver), StoredVariables.getcontactOccupantInfo1().get());
		}
		
		// Occupant Info 2 dropdown
		if (!StoredVariables.getcontactOccupantInfo2Dropdown().get().equals("")) {
			perform.selectDropdownOption(driver, SNewOrder.occupantInfo2_dropdown(driver), StoredVariables.getcontactOccupantInfo2Dropdown().get());
		}
		
		// Occupant Info 2
		if (!StoredVariables.getcontactOccupantInfo2().get().equals("")) {
			perform.type(driver, SNewOrder.occupantInfo2_txtbx(driver), StoredVariables.getcontactOccupantInfo2().get());
		}
		
		// Agent
		if (!StoredVariables.getcontactAgent().get().equals("")) {
			perform.type(driver, SNewOrder.agent_txtbx(driver), StoredVariables.getcontactAgent().get());
		}
		
		// Agent Info 1 dropdown
		if (!StoredVariables.getcontactAgentInfo1Dropdown().get().equals("")) {
			perform.selectDropdownOption(driver, SNewOrder.agentInfo1_dropdown(driver), StoredVariables.getcontactAgentInfo1Dropdown().get());
		}
		
		// Agent Info 1
		if (!StoredVariables.getcontactAgentInfo1().get().equals("")) {
			perform.type(driver, SNewOrder.agentInfo1_txtbx(driver), StoredVariables.getcontactAgentInfo1().get());
		}
		
		// Agent Info 2 dropdown
		if (!StoredVariables.getcontactAgentInfo2Dropdown().get().equals("")) {
			perform.selectDropdownOption(driver, SNewOrder.agentInfo2_dropdown(driver), StoredVariables.getcontactAgentInfo2Dropdown().get());
		}
		
		// Agent Info 2
		if (!StoredVariables.getcontactAgentInfo2().get().equals("")) {
			perform.type(driver, SNewOrder.agentInfo2_txtbx(driver), StoredVariables.getcontactAgentInfo2().get());
		}
		
		// Other
		if (!StoredVariables.getcontactOther().get().equals("")) {
			perform.type(driver, SNewOrder.other_txtbx(driver), StoredVariables.getcontactOther().get());
		}
		
		// Other Info 1 dropdown
		if (!StoredVariables.getcontactOtherInfo1Dropdown().get().equals("")) {
			perform.selectDropdownOption(driver, SNewOrder.otherInfo1_dropdown(driver), StoredVariables.getcontactOtherInfo1Dropdown().get());
		}
		
		// Other Info 1
		if (!StoredVariables.getcontactOtherInfo1().get().equals("")) {
			perform.type(driver, SNewOrder.otherInfo1_txtbx(driver), StoredVariables.getcontactOtherInfo1().get());
		}
		
		// Other Info 2 dropdown
		if (!StoredVariables.getcontactOtherInfo2Dropdown().get().equals("")) {
			perform.selectDropdownOption(driver, SNewOrder.otherInfo2_dropdown(driver), StoredVariables.getcontactOtherInfo2Dropdown().get());
		}
		
		// Other Info 2
		if (!StoredVariables.getcontactOtherInfo2().get().equals("")) {
			perform.type(driver, SNewOrder.otherInfo2_txtbx(driver), StoredVariables.getcontactOtherInfo2().get());
		}
		
		// Appt. Contact
		System.out.println("ApptContact = " + StoredVariables.getcontactApptContact().get());
		if (!StoredVariables.getcontactApptContact().get().equals(""))
		{
			try {
				perform.selectDropdownOption(driver, SNewOrder.apptContact_dropdown(driver), StoredVariables.getcontactApptContact().get());
			}
			catch (Exception e){}
		}
		
		/***********************************************
		 * Enter Additional Notifications Recipients
		 ***********************************************/
		
		// Enter additional email addresses
		if (!StoredVariables.getadditionalNotificationRecipientsAdditionalEmails().get().equals("")) {
			perform.type(driver, SNewOrder.additionalEmailRecipients_txtbx(driver), StoredVariables.getadditionalNotificationRecipientsAdditionalEmails().get());
		}
		
		// Check Attach completed report
		if (StoredVariables.getadditionalNotificationRecipientsAttachCompletedReport().get() == true && !SNewOrder.attachCompletedReport_chkbx(driver).isSelected())
		{
			perform.click(driver, SNewOrder.attachCompletedReport_chkbx(driver));
		}
		else if (StoredVariables.getadditionalNotificationRecipientsAttachCompletedReport().get() == false && SNewOrder.attachCompletedReport_chkbx(driver).isSelected())
		{
			perform.click(driver, SNewOrder.attachCompletedReport_chkbx(driver));
		}
		
		if (StoredVariables.getuseLocalGrid().get().equals("android")) {} else {
			
			// Click the Click here link
			perform.click(driver, SNewOrder.clickHere_lnk(driver));
			
			// Verify information text
			Assert.assertTrue(SNewOrder.clickHere_txt(driver).getText().equals("The notification sent to additional recipients is an unsecured e-mail. Because the vendor and client documents contain non-public personal information (NPI), sending such information via an unsecured channel is a violation of the Gramm-Leach-Bliley Act (GLB), and can cause compliance issues for the lender."), "Sending via E-mail text has changed. Value on screen = " + SNewOrder.clickHere_txt(driver).getText());
			
			// Click the OK button
			perform.click(driver, SNewOrder.clickHereOK_btn(driver));
			
			// Wait for Next button
			perform.waitForElementToBeClickable(driver, SNewOrder.next_btn(), "id");
			
			// Scroll to the Next button
			perform.scrollElementIntoView(driver, SNewOrder.next_btn(driver));
			
			// Verify county is not empty
//			String county = SNewOrder.county_txtbx(driver).getAttribute("value");
//			int b = 1;
//			while (county.isEmpty() && b <=15) {
//				Thread.sleep(1000);
//				county = SNewOrder.county_txtbx(driver).getAttribute("value");
//				b++;
//			} // end while
//			
//			if (!mapErrorStyle.contains("display: none;")) {
//				
//				System.out.println("The county is empty");
//				
//				// Scroll to County text field
//				perform.scrollElementIntoView(driver, SNewOrder.county_txtbx(driver));
//				
//				// Take a screenshot
//				perform.takeScreenshot(driver);
//				
//				// Add info to Extent Report
//				test.log(LogStatus.WARNING, "Warning", "The county is empty on Secure when entering new order info");
//				
//				// Send an email
//				perform.sendEmail(driver, "dnorman@corelogic.com", "qa.vsg2@corelogic.com", "The County is blank in Secure on " + StoredVariables.getenvironment().get(), "The county is blank in Secure - "+StoredVariables.getenvironment().get()+" when entering a new order.\n\nClick here to view the screenshot: \""+StoredVariables.getscreenshotImage().get() + "\"");
//				
//			} // end if displayed is false
		
		} // end if android
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Entered new Residential Appraisal order info");
		
	} // end enterNewResidentialAppraisalOrderOnSecure
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Add Order Group</li>
	 * 	<li>Address</li>
	 * 	<li>City</li>
	 * 	<li>State</li>
	 * 	<li>Zip Code</li>
	 * 	<li>Sq ft</li>
	 * 	<li>Verify Sq ft is entered correctly</li>
	 * 	<li>Site Size</li>
	 * 	<li>Prop Type</li>
	 * 	<li>Prop rights</li>
	 * 	<li>Legal desc</li>
	 * 	<li>Directions</li>
	 * 	<li>Get directionsIdentifier used to uniquely identify the order number and store it</li>
	 * 	<li>Enter Directions</li>
	 * 	<li>Verify Directions were entered correctly</li>
	 * 	<li>Enter Directions</li>
	 * 	<li>Verify Legal was entered correctly</li>
	 * 	<li>Enter Directions</li>
	 * 	<li>Form/type</li>
	 * 	<li>Check Rush Order</li>
	 * 	<li>Check Complex checkbox</li>
	 * 	<li>Issue as bid</li>
	 * 	<li>Other Ref #</li>
	 * 	<li>Loan Type</li>
	 * 	<li>Loan Purpose</li>
	 * 	<li>Ordered By</li>
	 * 	<li>Loan #</li>
	 * 	<li>File #</li>
	 * 	<li>Sales Price</li>
	 * 	<li>FHA Case #</li>
	 * 	<li>Set Order Due Date (Long and Short)</li>
	 * 	<li>Select the Order Due date</li>
	 * 	<li>Enter Order Due date</li>
	 * 	<li>Click the Order Due calendar button</li>
	 * 	<li>Select the date</li>
	 * 	<li>Verify the correct order due date is correct</li>
	 * 	<li>Set Disclosure Date (Long and Short)</li>
	 * 	<li>Select Disclosure Date</li>
	 * 	<li>Enter Order Due date</li>
	 * 	<li>Click calendar for Disclosure</li>
	 * 	<li>Select the date</li>
	 * 	<li>Verify the date is correct</li>
	 * 	<li>Assigned To</li>
	 * 	<li>Lender name</li>
	 * 	<li>Address 1</li>
	 * 	<li>Address 2</li>
	 * 	<li>City</li>
	 * 	<li>State</li>
	 * 	<li>Zip</li>
	 * 	<li>Occupancy</li>
	 * 	<li>Borrower</li>
	 * 	<li>Get borrower identifier to uniquely identify the borrower</li>
	 * 	<li>Borrower Info 1 dropdown</li>
	 * 	<li>Borrower Info 1</li>
	 * 	<li>Borrower Info 2 dropdown</li>
	 * 	<li>Borrower Info 2</li>
	 * 	<li>Click Borrower Address button</li>
	 * 	<li>Check Same as subject property address checkbox</li>
	 * 	<li>Verify property address populated</li>
	 * 	<li>Click Cancel</li>
	 * 	<li>Click Borrower Address button</li>
	 * 	<li>Uncheck Same as subject property address checkbox</li>
	 * 	<li>Verify address fields are empty</li>
	 * 	<li>Address</li>
	 * 	<li>City</li>
	 * 	<li>State</li>
	 * 	<li>Zip</li>
	 * 	<li>Click Save</li>
	 * 	<li>Co-borrower</li>
	 * 	<li>Co-borrower Info 1 dropdown</li>
	 * 	<li>Co-borrower Info 1</li>
	 * 	<li>Co-borrower Info 2 dropdown</li>
	 * 	<li>Co-borrower Info 2</li>
	 * 	<li>Click Co-borrower Address button</li>
	 * 	<li>Check Same as subject property address checkbox</li>
	 * 	<li>Verify borrower address populated</li>
	 * 	<li>Click Cancel</li>
	 * 	<li>Click Co-borrower Address button</li>
	 * 	<li>Uncheck Same as subject property address checkbox</li>
	 * 	<li>Address</li>
	 * 	<li>City</li>
	 * 	<li>State</li>
	 * 	<li>Zip</li>
	 * 	<li>Click Save</li>
	 * 	<li>Owner</li>
	 * 	<li>Owner Info 1 dropdown</li>
	 * 	<li>Owner Info 1</li>
	 * 	<li>Owner Info 2 dropdown</li>
	 * 	<li>Owner Info 2</li>
	 * 	<li>Occupant</li>
	 * 	<li>Occupant Info 1 dropdown</li>
	 * 	<li>Occupant Info 1</li>
	 * 	<li>Occupant Info 2 dropdown</li>
	 * 	<li>Occupant Info 2</li>
	 * 	<li>Agent</li>
	 * 	<li>Agent Info 1 dropdown</li>
	 * 	<li>Agent Info 1</li>
	 * 	<li>Agent Info 2 dropdown</li>
	 * 	<li>Agent Info 2</li>
	 * 	<li>Other</li>
	 * 	<li>Other Info 1 dropdown</li>
	 * 	<li>Other Info 1</li>
	 * 	<li>Other Info 2 dropdown</li>
	 * 	<li>Other Info 2</li>
	 * 	<li>Appt. Contact</li>
	 * 	<li>Enter additional email addresses</li>
	 * 	<li>Check Attach completed report</li>
	 * 	<li>Add info to Extent Report</li>
	 * 	<li>Finish order after assignment</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Fill out New Order Form on Secure
	public void enterNewCommercialAppraisalOrder(RemoteWebDriver driver) throws InterruptedException, IOException {
		
		ExtentTest test = ExtentTestManager.getTest();
		
		// Add Order Group
		if (!StoredVariables.getassignmentInformationOrderGroup().get().equals(""))
		{
			addOrderGroupToOrder(driver, StoredVariables.getassignmentInformationOrderGroup().get());
		} // end if for non-empty order group
		
		/***************************************
		 * Enter Property Information
		 ***************************************/
		
		// Address
		perform.type(driver, SNewOrder.address_txtbx(driver), StoredVariables.getpropertyInformationAddress().get());
		
		// City
		perform.type(driver, SNewOrder.city_txtbx(driver), StoredVariables.getpropertyInformationCity().get());
		
		// State
		perform.selectDropdownOption(driver, SNewOrder.state_dropdown(driver), StoredVariables.getpropertyInformationState().get());
		
		// Zip Code
		perform.type(driver, SNewOrder.zipCode_txtbx(driver), StoredVariables.getpropertyInformationZip().get());
		
		// Sq ft
		if (!StoredVariables.getpropertyInformationSqFt().get().equals("")) {
			perform.type(driver, SNewOrder.sqFt_txtbx(driver), StoredVariables.getpropertyInformationSqFt().get());
			perform.click(driver, SNewOrder.zipCode_txtbx(driver));
			
			// Verify Sq ft is entered correctly
			if (!SNewOrder.sqFt_txtbx(driver).getAttribute("value").equals(StoredVariables.getpropertyInformationSqFt().get()))
			{
				perform.type(driver, SNewOrder.sqFt_txtbx(driver), StoredVariables.getpropertyInformationSqFt().get());
			}
		}
		
		// Site Size
		if (!StoredVariables.getpropertyInformationSiteSize().get().equals("")) {
			perform.type(driver, SNewOrder.siteSize_txtbx(driver), StoredVariables.getpropertyInformationSiteSize().get());
		}
		
		// Prop Type
		if (!StoredVariables.getpropertyInformationPropType().get().equals("")) {
		perform.selectDropdownOption(driver, SNewOrder.propType_dropdown(driver), StoredVariables.getpropertyInformationPropType().get());
		}
		
		// Prop rights
		if (!StoredVariables.getpropertyInformationPropRights().get().equals("")) {
		perform.selectDropdownOption(driver, SNewOrder.propRights_dropdown(driver), StoredVariables.getpropertyInformationPropRights().get());
		}
		
		// Legal desc
		if (!StoredVariables.getpropertyInformationLegalDesc().get().equals("")) {
			perform.type(driver, SNewOrder.legalDesc_txtbx(driver), StoredVariables.getpropertyInformationLegalDesc().get());
		}
		
		// Directions
		// Get directionsIdentifier used to uniquely identify the order number and store it
		StoredVariables.getdirectionsIdentifier().set(new SimpleDateFormat("MMddHHmmss").format(Calendar.getInstance().getTime()) + " - " + perform.randomNumbers(driver, 5));
		StoredVariables.getpropertyInformationDirections().set(StoredVariables.getpropertyInformationDirections().get() + " - " + StoredVariables.getdirectionsIdentifier().get());
		// Enter Directions
		perform.type(driver, SNewOrder.directions_txtbx(driver), StoredVariables.getpropertyInformationDirections().get());
		perform.click(driver, SNewOrder.legalDesc_txtbx(driver));
		
		// Verify Directions were entered correctly
		if (SNewOrder.directions_txtbx(driver).getAttribute("value").equals(StoredVariables.getpropertyInformationDirections().get()))
		{
			// Enter Directions
			SNewOrder.directions_txtbx(driver).clear();
			perform.type(driver, SNewOrder.directions_txtbx(driver), StoredVariables.getpropertyInformationDirections().get());
		} // end if
		
		// Verify Legal was entered correctly
		if (!StoredVariables.getpropertyInformationLegalDesc().get().equals("")) {
			if (SNewOrder.legalDesc_txtbx(driver).getAttribute("value").equals(StoredVariables.getpropertyInformationLegalDesc().get()))
			{
				// Enter Directions
				SNewOrder.legalDesc_txtbx(driver).clear();
				perform.type(driver, SNewOrder.legalDesc_txtbx(driver), StoredVariables.getpropertyInformationLegalDesc().get());
			} // end if
		}

		/***************************************
		 * Enter Assignment Information
		 ***************************************/
		
		// Form/type
		if (!StoredVariables.getassignmentInformationForm().get().equals("")) {
		perform.selectDropdownOption(driver, SNewOrder.form_dropdown(driver), StoredVariables.getassignmentInformationForm().get());
		}
		
		// Check Rush Order
		if (StoredVariables.getassignmentInformationRushOrder().get() == true && !SNewOrder.rushOrder_chkbx(driver).isSelected())
		{
			perform.click(driver, SNewOrder.rushOrder_chkbx(driver));
		}
		else if (StoredVariables.getassignmentInformationRushOrder().get() == false && SNewOrder.rushOrder_chkbx(driver).isSelected())
		{
			perform.click(driver, SNewOrder.rushOrder_chkbx(driver));
		}
		
		// Check Complex checkbox
		if (StoredVariables.getassignmentInformationComplex().get() == true && !SNewOrder.complex_chkbx(driver).isSelected())
		{
			perform.click(driver, SNewOrder.complex_chkbx(driver));				
		}
		else if (StoredVariables.getassignmentInformationComplex().get() == false && SNewOrder.complex_chkbx(driver).isSelected())
		{
			perform.click(driver, SNewOrder.complex_chkbx(driver));
		}
		
		// Issue as bid
		if (StoredVariables.getassignmentInformationIssueAsBid().get() == false)
		{
			
			perform.waitForElementToBeVisible(driver, SNewOrder.issueAsBidNo_radiobtn(), "id");
			perform.click(driver, SNewOrder.issueAsBidNo_radiobtn(driver));
		}
		else
		{
			perform.waitForElementToBeVisible(driver, SNewOrder.issueAsBidYes_radiobtn(), "id");
			perform.click(driver, SNewOrder.issueAsBidYes_radiobtn(driver));
		}
		
		// Other Ref #
		if (!StoredVariables.getassignmentInformationOtherRefNumber().get().equals("")) {
			perform.type(driver, SNewOrder.otherRefNumber_txtbx(driver), StoredVariables.getassignmentInformationOtherRefNumber().get());
		}
		
		// Loan Type
		if (!StoredVariables.getassignmentInformationLoanType().get().equals("")) {
		perform.selectDropdownOption(driver, SNewOrder.loanType_dropdown(driver), StoredVariables.getassignmentInformationLoanType().get());
		}
		
		// Loan Purpose
		if (!StoredVariables.getassignmentInformationLoanPurpose().get().equals("")) {
		perform.selectDropdownOption(driver, SNewOrder.loanPurpose_dropdown(driver), StoredVariables.getassignmentInformationLoanPurpose().get());
		}
		
		// Ordered By
		if (!StoredVariables.getassignmentInformationOrderedBy().get().equals("")) {
			perform.type(driver, SNewOrder.orderedBy_txtbx(driver), StoredVariables.getassignmentInformationOrderedBy().get());
		}
		
		// Loan #
		if (!StoredVariables.getassignmentInformationLoanNumber().get().equals("")) {
			perform.type(driver, SNewOrder.loanNumber_txtbx(driver), StoredVariables.getassignmentInformationLoanNumber().get());
		}
		
		// File #
		if (!StoredVariables.getassignmentInformationFileNumber().get().equals("")) {
			perform.type(driver, SNewOrder.fileNumber_txtbx(driver), StoredVariables.getassignmentInformationFileNumber().get());
		}
		
		// Sales Price
		if (!StoredVariables.getassignmentInformationSalesPrice().get().equals("")) {
			perform.type(driver, SNewOrder.salesPrice_txtbx(driver), StoredVariables.getassignmentInformationSalesPrice().get());
		}
		
		// FHA Case #
		if (!StoredVariables.getassignmentInformationFHACaseNumber().get().equals("")) {
			perform.type(driver, SNewOrder.fhaCaseNumber_txtbx(driver), StoredVariables.getassignmentInformationFHACaseNumber().get());
		}
		
		// Set Order Due Date (Long and Short)
		perform.getNewDate(driver, StoredVariables.getassignmentInformationOrderDue().get());
		StoredVariables.getorderDueDateLong().set(StoredVariables.getnewDateLong().get());
		StoredVariables.getorderDueDateShort().set(StoredVariables.getnewDateShort().get());
		
		// Select the Order Due date
		if (StoredVariables.getbrowser().get().equals("PhantomJS") || StoredVariables.getbrowser().get().equals("HtmlUnit") || StoredVariables.getbrowser().get().equals("IE") || StoredVariables.getmobile().get()==true)
		{
			// Enter Order Due date
			perform.type(driver, SNewOrder.orderDue_txtbx(driver), StoredVariables.getorderDueDateLong().get());
		}
		else
		{
			// Click the Order Due calendar button
			perform.click(driver, SNewOrder.orderDueCalendar_btn(driver));
			
			// Select the date
			selectDateFromCalendar(driver, StoredVariables.getassignmentInformationOrderDue().get());
			
			// Verify the correct order due date is correct
			Assert.assertTrue(SNewOrder.orderDue_txtbx(driver).getAttribute("value").equals(StoredVariables.getcalendarDateLong().get()), "Date selected from calendar is the wrong date. Trying to match - " + StoredVariables.getcalendarDateLong().get());
		}
		
		// Set Disclosure Date (Long and Short)
		if (StoredVariables.getassignmentInformationDisclosure().get() != null) {
			perform.getNewDate(driver, StoredVariables.getassignmentInformationDisclosure().get());
			StoredVariables.getdisclosureDateLong().set(StoredVariables.getnewDateLong().get());
			StoredVariables.getdisclosureDateShort().set(StoredVariables.getnewDateShort().get());
		
			// Select Disclosure Date
			if (StoredVariables.getbrowser().get().equals("PhantomJS") || StoredVariables.getbrowser().get().equals("HtmlUnit") || StoredVariables.getbrowser().get().equals("IE") || StoredVariables.getmobile().get()==true)
			{
				// Enter Order Due date
				perform.type(driver, SNewOrder.disclosure_txtbx(driver), StoredVariables.getdisclosureDateLong().get());
			}
			else
			{
				// Click calendar for Disclosure
				perform.click(driver, SNewOrder.disclosureCalendar_btn(driver));
				
				// Select the date
				selectDateFromCalendar(driver, StoredVariables.getassignmentInformationDisclosure().get());
				
				// Verify the date is correct
				Assert.assertTrue(SNewOrder.disclosure_txtbx(driver).getAttribute("value").equals(StoredVariables.getdisclosureDateLong().get()), "Date selected from calendar is the wrong date. It is - " + SNewOrder.disclosure_txtbx(driver).getAttribute("value") + " but should be " + StoredVariables.getdisclosureDateLong().get());
			}
		}
		
		// Assigned To
		if (!StoredVariables.getassignmentInformationAssignedTo().get().equals("")) {
			perform.selectDropdownOption(driver, SNewOrder.assignedTo_dropdown(driver), StoredVariables.getassignmentInformationAssignedTo().get());
		}
		
		/***************************************
		 * Enter Lender Information
		 ***************************************/
		
		// Lender name
		if (!StoredVariables.getlenderInformationLenderName().get().equals("")) {
			perform.type(driver, SNewOrder.lenderName_txtbx(driver), StoredVariables.getlenderInformationLenderName().get());
		}
		
		// Address 1
		if (!StoredVariables.getlenderInformationAddress1().get().equals("")) {
			perform.type(driver, SNewOrder.lenderAddress1_txtbx(driver), StoredVariables.getlenderInformationAddress1().get());
		}
		
		// Address 2
		if (!StoredVariables.getlenderInformationAddress2().get().equals("")) {
			perform.type(driver, SNewOrder.lenderAddress2_txtbx(driver), StoredVariables.getlenderInformationAddress2().get());
		}
		
		// City
		if (!StoredVariables.getlenderInformationCity().get().equals("")) {
			perform.type(driver, SNewOrder.lenderCity_txtbx(driver), StoredVariables.getlenderInformationCity().get());
		}
		
		// State
		if (!StoredVariables.getlenderInformationState().get().equals("")) {
			perform.selectDropdownOption(driver, SNewOrder.lenderState_dropdown(driver), StoredVariables.getlenderInformationState().get());
		}
		
		// Zip
		if (!StoredVariables.getlenderInformationZip().get().equals("")) {
			perform.type(driver, SNewOrder.lenderZip_txtbx(driver), StoredVariables.getlenderInformationZip().get());
		}
		
		/***************************************
		 * Enter Contact And Access Information
		 ***************************************/
		
		// Occupancy
		if (!StoredVariables.getcontactOccupancy().get().equals("")) {
			perform.selectDropdownOption(driver, SNewOrder.occupancy_dropdown(driver), StoredVariables.getcontactOccupancy().get());
		}
		
		// Borrower
		if (!StoredVariables.getcontactBorrower().get().equals("")) {
			// Get borrower identifier to uniquely identify the borrower
			StoredVariables.getborrowerIdentifier().set(new SimpleDateFormat("MMddHHmmss").format(Calendar.getInstance().getTime()));
			perform.type(driver, SNewOrder.borrower_txtbx(driver), StoredVariables.getcontactBorrower().get() + "-" + StoredVariables.getborrowerIdentifier().get());
		}
		
		// Borrower Info 1 dropdown
		if (!StoredVariables.getcontactBorrowerInfo1Dropdown().get().equals("")) {
			perform.selectDropdownOption(driver, SNewOrder.borrowerInfo1_dropdown(driver), StoredVariables.getcontactBorrowerInfo1Dropdown().get());
		}
		
		// Borrower Info 1
		if (!StoredVariables.getcontactBorrowerInfo1().get().equals("")) {
			perform.type(driver, SNewOrder.borrowerInfo1_txtbx(driver), StoredVariables.getcontactBorrowerInfo1().get());
		}
		
		// Borrower Info 2 dropdown
		if (!StoredVariables.getcontactBorrowerInfo2Dropdown().get().equals("")) {
			perform.selectDropdownOption(driver, SNewOrder.borrowerInfo2_dropdown(driver), StoredVariables.getcontactBorrowerInfo2Dropdown().get());
		}
		
		// Borrower Info 2
		if (!StoredVariables.getcontactBorrowerInfo2().get().equals("")) {
			perform.type(driver, SNewOrder.borrowerInfo2_txtbx(driver), StoredVariables.getcontactBorrowerInfo2().get());
		}
		
		// Click Borrower Address button
		perform.click(driver, SNewOrder.borrowerAddress_btn(driver));
		
		// Check Same as subject property address checkbox
		if (!SNewOrder.sameAsPropertyAddress_chkbx(driver).isSelected())
		{
			perform.click(driver, SNewOrder.sameAsPropertyAddress_chkbx(driver));	
		}
		
		// Verify property address populated
		Assert.assertTrue(StoredVariables.getpropertyInformationAddress().get().equals(SNewOrder.borrowerAddress_txtbx(driver).getAttribute("value")), "The borrower contact property address did not pull in");
		Assert.assertTrue(StoredVariables.getpropertyInformationCity().get().equals(SNewOrder.borrowerCity_txtbx(driver).getAttribute("value")), "The borrower contact property city did  not pull in");
		Assert.assertTrue(StoredVariables.getpropertyInformationStateAbbr().get().equals(SNewOrder.borrowerState_txtbx(driver).getAttribute("value")), "The borrower contact property state did not pull in");
//		Assert.assertTrue(propertyZip.equals(SNewOrder.borrowerZip_txtbx(driver).getAttribute("value")), "The borrower contact property zip code did not pull in");
		perform.commentedBug(driver, "Zip code not being pulled in for borrower address");
		
		// Click Cancel
		perform.click(driver, SNewOrder.borrowerCancel_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		if (!StoredVariables.getcontactBorrowerAddress().get().equals("")) {
			
			// Click Borrower Address button
			perform.click(driver, SNewOrder.borrowerAddress_btn(driver));
			
			// Uncheck Same as subject property address checkbox
			if (SNewOrder.sameAsPropertyAddress_chkbx(driver).isSelected())
			{
				perform.click(driver, SNewOrder.sameAsPropertyAddress_chkbx(driver));	
			}
			
			// Verify address fields are empty
			Assert.assertTrue(SNewOrder.borrowerAddress_txtbx(driver).getAttribute("value").equals(""), "The borrower contact property address did not clear");
			Assert.assertTrue(SNewOrder.borrowerCity_txtbx(driver).getAttribute("value").equals(""), "The borrower contact property city did  not clear");
			Assert.assertTrue(SNewOrder.borrowerState_txtbx(driver).getAttribute("value").equals(""), "The borrower contact property state did not clear");
			Assert.assertTrue(SNewOrder.borrowerZip_txtbx(driver).getAttribute("value").equals(""), "The borrower contact property zip code did not clear");
			
			// Address
			perform.type(driver, SNewOrder.borrowerAddress_txtbx(driver), StoredVariables.getcontactBorrowerAddress().get());
			
			// City
			perform.type(driver, SNewOrder.borrowerCity_txtbx(driver), StoredVariables.getcontactBorrowerCity().get());
			
			// State
			perform.type(driver, SNewOrder.borrowerState_txtbx(driver), StoredVariables.getcontactBorrowerState().get());
			
			// Zip
			perform.type(driver, SNewOrder.borrowerZip_txtbx(driver), StoredVariables.getcontactBorrowerZip().get());
			
			// Click Save
			perform.click(driver, SNewOrder.borrowerSave_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
		}
		
		// Co-borrower
		if (!StoredVariables.getcontactCoBorrower().get().equals("")) {
			perform.type(driver, SNewOrder.coBorrower_txtbx(driver), StoredVariables.getcontactCoBorrower().get());
		}
		
		// Co-borrower Info 1 dropdown
		if (!StoredVariables.getcontactCoBorrowerInfo1Dropdown().get().equals("")) {
			perform.selectDropdownOption(driver, SNewOrder.coBorrowerInfo1_dropdown(driver), StoredVariables.getcontactCoBorrowerInfo1Dropdown().get());
		}
		
		// Co-borrower Info 1
		if (!StoredVariables.getcontactCoBorrowerInfo1().get().equals("")) {
			perform.type(driver, SNewOrder.coBorrowerInfo1_txtbx(driver), StoredVariables.getcontactCoBorrowerInfo1().get());
		}
		
		// Co-borrower Info 2 dropdown
		if (!StoredVariables.getcontactCoBorrowerInfo2Dropdown().get().equals("")) {
			perform.selectDropdownOption(driver, SNewOrder.coBorrowerInfo2_dropdown(driver), StoredVariables.getcontactCoBorrowerInfo2Dropdown().get());
		}
		
		// Co-borrower Info 2
		if (!StoredVariables.getcontactCoBorrowerInfo2().get().equals("")) {
			perform.type(driver, SNewOrder.coBorrowerInfo2_txtbx(driver), StoredVariables.getcontactCoBorrowerInfo2().get());
		}
		
		// Click Co-borrower Address button
		perform.click(driver, SNewOrder.coBorrowerAddress_btn(driver));
		
		// Wait for checkbox
		perform.waitForElementToBeClickable(driver, SNewOrder.coBorrowerSameAsSubjectPropertyAddress_chkbx(), "id");
		
		// Check Same as subject property address checkbox
		if (!SNewOrder.coBorrowerSameAsSubjectPropertyAddress_chkbx(driver).isSelected())
		{
			perform.click(driver, SNewOrder.coBorrowerSameAsSubjectPropertyAddress_chkbx(driver));	
		}
		
		// Verify borrower address populated
		Assert.assertTrue(StoredVariables.getcontactBorrowerAddress().get().equals(SNewOrder.coBorrowerAddress_txtbx(driver).getAttribute("value")), "The co-borrower contact property address did not pull in");
		Assert.assertTrue(StoredVariables.getcontactBorrowerCity().get().equals(SNewOrder.coBorrowerCity_txtbx(driver).getAttribute("value")), "The co-borrower contact property city did  not pull in");
		Assert.assertTrue(StoredVariables.getcontactBorrowerState().get().equals(SNewOrder.coBorrowerState_txtbx(driver).getAttribute("value")), "The co-borrower contact property state did not pull in");
		Assert.assertTrue(StoredVariables.getcontactBorrowerZip().get().equals(SNewOrder.coBorrowerZip_txtbx(driver).getAttribute("value")), "The co-borrower contact property zip code did not pull in");
		
		// Click Cancel
		perform.click(driver, SNewOrder.coBorrowerCancel_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		if (!StoredVariables.getcontactCoBorrowerAddress().get().equals("")) {
		
			// Click Co-borrower Address button
			perform.click(driver, SNewOrder.coBorrowerAddress_btn(driver));
			
			// Uncheck Same as subject property address checkbox
			if (SNewOrder.coBorrowerSameAsSubjectPropertyAddress_chkbx(driver).isSelected())
			{
				perform.click(driver, SNewOrder.coBorrowerSameAsSubjectPropertyAddress_chkbx(driver));	
			}
			
			// Address
			perform.type(driver, SNewOrder.coBorrowerAddress_txtbx(driver), StoredVariables.getcontactCoBorrowerAddress().get());
			
			// City
			perform.type(driver, SNewOrder.coBorrowerCity_txtbx(driver), StoredVariables.getcontactCoBorrowerCity().get());
			
			// State
			perform.type(driver, SNewOrder.coBorrowerState_txtbx(driver), StoredVariables.getcontactCoBorrowerState().get());
			
			// Zip
			perform.type(driver, SNewOrder.coBorrowerZip_txtbx(driver), StoredVariables.getcontactCoBorrowerZip().get());
			
			// Click Save
			perform.click(driver, SNewOrder.coBorrowerSave_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
		}
		
		// Owner
		if (!StoredVariables.getcontactOwner().get().equals("")) {
			perform.type(driver, SNewOrder.owner_txtbx(driver), StoredVariables.getcontactOwner().get());
		}
		
		// Owner Info 1 dropdown
		if (!StoredVariables.getcontactOwnerInfo1Dropdown().get().equals("")) {
			perform.selectDropdownOption(driver, SNewOrder.ownerInfo1_dropdown(driver), StoredVariables.getcontactOwnerInfo1Dropdown().get());
		}
		
		// Owner Info 1
		if (!StoredVariables.getcontactOwnerInfo1().get().equals("")) {
			perform.type(driver, SNewOrder.ownerInfo1_txtbx(driver), StoredVariables.getcontactOwnerInfo1().get());
		}
		
		// Owner Info 2 dropdown
		if (!StoredVariables.getcontactOwnerInfo2Dropdown().get().equals("")) {
			perform.selectDropdownOption(driver, SNewOrder.ownerInfo2_dropdown(driver), StoredVariables.getcontactOwnerInfo2Dropdown().get());
		}
		
		// Owner Info 2
		if (!StoredVariables.getcontactOwnerInfo2().get().equals("")) {
			perform.type(driver, SNewOrder.ownerInfo2_txtbx(driver), StoredVariables.getcontactOwnerInfo2().get());
		}
		
		// Occupant
		if (!StoredVariables.getcontactOccupant().get().equals("")) {
			perform.type(driver, SNewOrder.occupant_txtbx(driver), StoredVariables.getcontactOccupant().get());
		}
		
		// Occupant Info 1 dropdown
		if (!StoredVariables.getcontactOccupantInfo1Dropdown().get().equals("")) {
			perform.selectDropdownOption(driver, SNewOrder.occupantInfo1_dropdown(driver), StoredVariables.getcontactOccupantInfo1Dropdown().get());
		}
		
		// Occupant Info 1
		if (!StoredVariables.getcontactOccupantInfo1().get().equals("")) {
			perform.type(driver, SNewOrder.occupantInfo1_txtbx(driver), StoredVariables.getcontactOccupantInfo1().get());
		}
		
		// Occupant Info 2 dropdown
		if (!StoredVariables.getcontactOccupantInfo2Dropdown().get().equals("")) {
			perform.selectDropdownOption(driver, SNewOrder.occupantInfo2_dropdown(driver), StoredVariables.getcontactOccupantInfo2Dropdown().get());
		}
		
		// Occupant Info 2
		if (!StoredVariables.getcontactOccupantInfo2().get().equals("")) {
			perform.type(driver, SNewOrder.occupantInfo2_txtbx(driver), StoredVariables.getcontactOccupantInfo2().get());
		}
		
		// Agent
		if (!StoredVariables.getcontactAgent().get().equals("")) {
			perform.type(driver, SNewOrder.agent_txtbx(driver), StoredVariables.getcontactAgent().get());
		}
		
		// Agent Info 1 dropdown
		if (!StoredVariables.getcontactAgentInfo1Dropdown().get().equals("")) {
			perform.selectDropdownOption(driver, SNewOrder.agentInfo1_dropdown(driver), StoredVariables.getcontactAgentInfo1Dropdown().get());
		}
		
		// Agent Info 1
		if (!StoredVariables.getcontactAgentInfo1().get().equals("")) {
			perform.type(driver, SNewOrder.agentInfo1_txtbx(driver), StoredVariables.getcontactAgentInfo1().get());
		}
		
		// Agent Info 2 dropdown
		if (!StoredVariables.getcontactAgentInfo2Dropdown().get().equals("")) {
			perform.selectDropdownOption(driver, SNewOrder.agentInfo2_dropdown(driver), StoredVariables.getcontactAgentInfo2Dropdown().get());
		}
		
		// Agent Info 2
		if (!StoredVariables.getcontactAgentInfo2().get().equals("")) {
			perform.type(driver, SNewOrder.agentInfo2_txtbx(driver), StoredVariables.getcontactAgentInfo2().get());
		}
		
		// Other
		if (!StoredVariables.getcontactOther().get().equals("")) {
			perform.type(driver, SNewOrder.other_txtbx(driver), StoredVariables.getcontactOther().get());
		}
		
		// Other Info 1 dropdown
		if (!StoredVariables.getcontactOtherInfo1Dropdown().get().equals("")) {
			perform.selectDropdownOption(driver, SNewOrder.otherInfo1_dropdown(driver), StoredVariables.getcontactOtherInfo1Dropdown().get());
		}
		
		// Other Info 1
		if (!StoredVariables.getcontactOtherInfo1().get().equals("")) {
			perform.type(driver, SNewOrder.otherInfo1_txtbx(driver), StoredVariables.getcontactOtherInfo1().get());
		}
		
		// Other Info 2 dropdown
		if (!StoredVariables.getcontactOtherInfo2Dropdown().get().equals("")) {
			perform.selectDropdownOption(driver, SNewOrder.otherInfo2_dropdown(driver), StoredVariables.getcontactOtherInfo2Dropdown().get());
		}
		
		// Other Info 2
		if (!StoredVariables.getcontactOtherInfo2().get().equals("")) {
			perform.type(driver, SNewOrder.otherInfo2_txtbx(driver), StoredVariables.getcontactOtherInfo2().get());
		}
		
		// Appt. Contact
		if (!StoredVariables.getcontactApptContact().get().equals("")) {
			perform.selectDropdownOption(driver, SNewOrder.apptContact_dropdown(driver), StoredVariables.getcontactApptContact().get());
		}
		
		/***********************************************
		 * Enter Additional Notifications Recipients
		 ***********************************************/
		
		// Enter additional email addresses
		if (!StoredVariables.getadditionalNotificationRecipientsAdditionalEmails().get().equals("")) {
			perform.type(driver, SNewOrder.additionalEmailRecipients_txtbx(driver), StoredVariables.getadditionalNotificationRecipientsAdditionalEmails().get());
		}
		
		// Check Attach completed report
		if (StoredVariables.getadditionalNotificationRecipientsAttachCompletedReport().get() == true && !SNewOrder.attachCompletedReport_chkbx(driver).isSelected())
		{
			perform.click(driver, SNewOrder.attachCompletedReport_chkbx(driver));
		}
		else if (StoredVariables.getadditionalNotificationRecipientsAttachCompletedReport().get() == false && SNewOrder.attachCompletedReport_chkbx(driver).isSelected())
		{
			perform.click(driver, SNewOrder.attachCompletedReport_chkbx(driver));
		}
		
		// Wait for Next button
		perform.waitForElementToBeClickable(driver, SNewOrder.next_btn(), "id");
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Entered new Commercial Appraisal order info");
		
	} // end enterNewCommercialAppraisalOrderOnSecure
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Verify the 'I have read and understand the vendor's fee notes' is unchecked</li>
	 * 	<li>Change payment method to check</li>
	 * 	<li>Click Next</li>
	 * 	<li>Get inside the attach document frame</li>
	 * 	<li>Select document type</li>
	 * 	<li>Upload Document</li>
	 * 	<li>Click Finished button</li>
	 * 	<li>Switch back to the attach documents frame</li>
	 * 	<li>Verify you land on the orders grid</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param paymentMethod the payment method
	 * @param documentType the document type
	 * @param document the document
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Finish order after assignment
	public void finishOrderAfterAssignment(RemoteWebDriver driver, String paymentMethod, String documentType, String document) throws InterruptedException, IOException {
		
		ExtentTest test = ExtentTestManager.getTest();
		
		// Wait for Next button
		perform.waitForElementToBeClickable(driver, SConfirmOrder.nextTop_btn(driver));
		
		// Verify the 'I have read and understand the vendor's fee notes' is unchecked
		int readVendorsFeeNotes = driver.findElements(By.id(SConfirmOrder.readVendorsFeeNotes_chkbx())).size();
		if (readVendorsFeeNotes > 0) {
			perform.checkCheckbox(driver, SConfirmOrder.readVendorsFeeNotes_chkbx(driver));
		} // end if
		
		// Change payment method to check
		if (!paymentMethod.isEmpty()) {
			perform.selectDropdownOption(driver, SConfirmOrder.paymentMethod_dropdown(driver), "Check");
		} // end payment method
		
		// Click Next
		perform.click(driver, SConfirmOrder.nextBottom_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for iFrames
		perform.waitForIFrames(driver);
		
		// Get inside the attach document frame
		perform.switchToiFrameByID(driver, "iframeAttach");
		
		// Wait for dropdown
		perform.waitForElementToBeClickable(driver, SConfirmOrder.documentType_dropdown(), "id");
		
		// Select document type
		if (!documentType.isEmpty()) {
			perform.selectDropdownOption(driver, SConfirmOrder.documentType_dropdown(driver), "Other");
			
			// Wait for upload button
			perform.waitForElementToBeClickable(driver, SConfirmOrder.uploadDocuments_btn(), "id");
		} // end doc type
		
		if (!document.isEmpty()) {
			// Upload Document
			String filePath = StoredVariables.getdocDir().get() + document;
			uploadDocumentOnSConfirmOrder(driver, filePath);
		} // end doc upload
		
		// Click Finished button
		perform.click(driver, SConfirmOrder.finished_btn(driver));
		
		// Switch back to the attach documents frame
		driver.switchTo().defaultContent();
		
		// Wait for Orders page to load
		perform.waitForElementToBeClickable(driver, SOrders.find_txtbx(), "id");
		
		// Verify you land on the orders grid
		Assert.assertTrue(driver.getCurrentUrl().contains("OrderManagement"), "After completing an order, the orders grid did not load");
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Finished the order after assigning to a vendor");
		
	} // end finishOrderAfterAssignment
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Enter address</li>
	 * 	<li>Enter city</li>
	 * 	<li>select state</li>
	 * 	<li>enter zip</li>
	 * 	<li>enter neighborhood</li>
	 * 	<li>enter sale price</li>
	 * 	<li>select product</li>
	 * 	<li>select loan type</li>
	 * 	<li>enter appraised value</li>
	 * 	<li>select appraisal date</li>
	 * 	<li>select assignment type</li>
	 * 	<li>select prior date</li>
	 * 	<li>enter prior price</li>
	 * 	<li>enter borrower name</li>
	 * 	<li>enter appraiser name</li>
	 * 	<li>enter lender name</li>
	 * 	<li>enter lender address</li>
	 * 	<li>enter lender city</li>
	 * 	<li>select lender state</li>
	 * 	<li>enter lender zip</li>
	 * 	<li>click create file</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param address the address
	 * @param city the city
	 * @param state the state
	 * @param zip the zip
	 * @param neighborhood the neighborhood
	 * @param salePrice the sale price
	 * @param product the product
	 * @param loanType the loan type
	 * @param appraisedValue the appraised value
	 * @param appraisalDate the appraisal date
	 * @param assignmentType the assignment type
	 * @param priorDate the prior date
	 * @param priorPrice the prior price
	 * @param borrowerName the borrower name
	 * @param appraiserName the appraiser name
	 * @param lenderName the lender name
	 * @param lenderAddress the lender address
	 * @param lenderCity the lender city
	 * @param lenderState the lender state
	 * @param lenderZip the lender zip
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Enter Create Data Courier File info
	public void enterCreateDataCourierFile(RemoteWebDriver driver, String address, String city, String state, String zip, String neighborhood, String salePrice,
			String product, String loanType, String appraisedValue, int appraisalDate, String assignmentType, int priorDate, String priorPrice,
			String borrowerName, String appraiserName, String lenderName, String lenderAddress, String lenderCity, String lenderState, String lenderZip) throws InterruptedException, IOException
	{
		
		System.out.println("Enter Create Data Courier File information");
		
		ExtentTest test = ExtentTestManager.getTest();

		// Wait for Find textbox
		perform.waitForElementToBeClickable(driver, SDataCourierUploadPDF.address_txtbx(), "id");
		
		// Enter address
		perform.type(driver, SDataCourierUploadPDF.address_txtbx(driver), address);
		
		// Enter city
		perform.type(driver, SDataCourierUploadPDF.city_txtbx(driver), city);
		
		// select state
		perform.selectDropdownOption(driver, SDataCourierUploadPDF.state_dropdown(driver), state);
		
		// enter zip
		perform.type(driver, SDataCourierUploadPDF.zip_txtbx(driver), zip);
		
		// enter neighborhood
		perform.type(driver, SDataCourierUploadPDF.neighborhood_txtbx(driver), neighborhood);
		
		// enter sale price
		perform.type(driver, SDataCourierUploadPDF.salePrice_txtbx(driver), salePrice);
		
		// select product
		perform.selectDropdownOption(driver, SDataCourierUploadPDF.product_dropdown(driver), product);
		
		// select loan type
		perform.selectDropdownOption(driver, SDataCourierUploadPDF.loanType_dropdown(driver), loanType);
		
		// enter appraised value
		perform.type(driver, SDataCourierUploadPDF.appraisedValue_txtbx(driver), appraisedValue);
		
		// select appraisal date
		perform.click(driver, SDataCourierUploadPDF.appraisalDateCalendar_btn(driver));
		selectDateFromDataCourierCalendar(driver, appraisalDate);
		
		// select assignment type
		perform.selectDropdownOption(driver, SDataCourierUploadPDF.assignmentType_dropdown(driver), assignmentType);
		
		// select prior date
		perform.click(driver, SDataCourierUploadPDF.priorDateCalendar_btn(driver));
		selectDateFromDataCourierCalendar(driver, priorDate);
		
		// enter prior price
		perform.type(driver, SDataCourierUploadPDF.priorPrice_txtbx(driver), priorPrice);
		
		// enter borrower name
		perform.type(driver, SDataCourierUploadPDF.borrowerName_txtbx(driver), borrowerName);
		
		// enter appraiser name
		perform.type(driver, SDataCourierUploadPDF.appraiserName_txtbx(driver), appraiserName);
		
		// enter lender name
		perform.type(driver, 	SDataCourierUploadPDF.lenderName_txtbx(driver), lenderName);
		
		// enter lender address
		perform.type(driver, SDataCourierUploadPDF.lenderAddress_txtbx(driver), lenderAddress);
		
		// enter lender city
		perform.type(driver, SDataCourierUploadPDF.lenderCity_txtbx(driver), lenderCity);
		
		// select lender state
		perform.selectDropdownOption(driver, SDataCourierUploadPDF.lenderState_dropdown(driver), lenderState);
		
		// enter lender zip
		perform.type(driver, SDataCourierUploadPDF.lenderZip_txtbx(driver), lenderZip);
		
		// click create file
		perform.click(driver, SDataCourierUploadPDF.createFile_btn(driver));
		
		// Wait for display to go away
		String display = SDataCourierUploadPDF.createPDFOverlay(driver).getAttribute("style");
		while (display.toLowerCase().contains("block"))
		{
			Thread.sleep(1000);
			display = SDataCourierUploadPDF.createPDFOverlay(driver).getAttribute("style");
		}
		
		// Wait for Find textbox
		perform.waitForElementToBeClickable(driver, SDataCourier.find_txtbx(), "id");
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Entered Create Data Courier File info");
		
	} // end enterCreateDataCourierFile
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Verify data in Property Information is correct</li>
	 * 	<li>Address</li>
	 * 	<li>City</li>
	 * 	<li>State</li>
	 * 	<li>Zip</li>
	 * 	<li>Sq Ft</li>
	 * 	<li>Site Size</li>
	 * 	<li>Prop Type</li>
	 * 	<li>Prop rights</li>
	 * 	<li>Legal Desc</li>
	 * 	<li>Directions</li>
	 * 	<li>Verify data in Assignment Information is correct</li>
	 * 	<li>Only check the zillow link if called from VerifyNewOrder for Round Trip</li>
	 * 	<li>Order due</li>
	 * 	<li>Rush</li>
	 * 	<li>Loan type</li>
	 * 	<li>Loan purpose</li>
	 * 	<li>Lender</li>
	 * 	<li>Sales Price</li>
	 * 	<li>Loan #</li>
	 * 	<li>Other ref #</li>
	 * 	<li>File #</li>
	 * 	<li>FHA #</li>
	 * 	<li>Disclosure</li>
	 * 	<li>Ordered by</li>
	 * 	<li>Order group</li>
	 * 	<li>Verify data in Contact And Access Information is correct</li>
	 * 	<li>Occupancy</li>
	 * 	<li>Borrower</li>
	 * 	<li>Borrower Info 1</li>
	 * 	<li>Borrower Info 2</li>
	 * 	<li>Borrower Address</li>
	 * 	<li>CoBorrower</li>
	 * 	<li>CoBorrower Info 1</li>
	 * 	<li>CoBorrower Info 2</li>
	 * 	<li>CoBorrower Address</li>
	 * 	<li>Owner</li>
	 * 	<li>Owner Info 1</li>
	 * 	<li>Owner Info 2</li>
	 * 	<li>Occupant</li>
	 * 	<li>Occupant Info 1</li>
	 * 	<li>Occupant Info 2</li>
	 * 	<li>Agent</li>
	 * 	<li>Agent Info 1</li>
	 * 	<li>Agent Info 2</li>
	 * 	<li>Other</li>
	 * 	<li>Other Info 1</li>
	 * 	<li>Other Info 2</li>
	 * 	<li>Appt. Contact</li>
	 * 	<li>Verify Product Requirements text loads in Additional Comments section</li>
	 * </ul>
	 *
	 * @param driver the driver
	 */
	// Verify Secure Order Details
	public void verifyOrderDetails(RemoteWebDriver driver)
	{
		
		System.out.println("Verifying Order Details on Secure");
		
		// Verify data in Property Information is correct
		String propertyInformation = SOrderDetails.propertyInformation_txt(driver).getText();
		
		// Address
		Assert.assertTrue(propertyInformation.contains(StoredVariables.getpropertyInformationAddress().get()), "Address is not displayed on the Order Confirmation page");
		
		// City
		Assert.assertTrue(propertyInformation.contains(StoredVariables.getpropertyInformationCity().get()), "City is not displayed on the Order Confirmation page");
		
		// State
		Assert.assertTrue(propertyInformation.contains(StoredVariables.getpropertyInformationStateAbbr().get()), "State is not displayed on the Order Confirmation page");
		
		// Zip
		Assert.assertTrue(propertyInformation.contains(StoredVariables.getpropertyInformationZip().get()), "Zip is not displayed on the Order Confirmation page");
		
		// Sq Ft 
		if (!StoredVariables.getpropertyInformationSqFt().get().equals("")) {
			Assert.assertTrue(propertyInformation.contains(StoredVariables.getpropertyInformationSqFt().get()), "Sq Ft is not displayed on the Order Confirmation page");
		}
		
		// Site Size
		if (!StoredVariables.getpropertyInformationSiteSize().get().equals("")) {
			Assert.assertTrue(propertyInformation.contains(StoredVariables.getpropertyInformationSiteSize().get()), "Site Size is not displayed on the Order Confirmation page");
		}
		
		// Prop Type
		if (!StoredVariables.getpropertyInformationPropType().get().equals("")) {
			Assert.assertTrue(propertyInformation.contains(StoredVariables.getpropertyInformationPropType().get()), "Prop Type is not displayed on the Order Confirmation page");
		}
		
		// Prop rights
		if (!StoredVariables.getpropertyInformationPropRights().get().equals("")) {
			Assert.assertTrue(propertyInformation.contains(StoredVariables.getpropertyInformationPropRights().get()), "Prop Rights is not displayed on the Order Confirmation page");
		}
		
		// Legal Desc
		if (!StoredVariables.getpropertyInformationLegalDesc().get().equals("")) {
			Assert.assertTrue(propertyInformation.contains(StoredVariables.getpropertyInformationLegalDesc().get()), "Legal Desc is not displayed on the Order Confirmation page");
		}
		
		// Directions
		if (!StoredVariables.getpropertyInformationDirections().get().equals("")) {
			Assert.assertTrue(propertyInformation.contains(StoredVariables.getpropertyInformationDirections().get()), "Directions is not displayed on the Order Confirmation page");
		}
		
		// Verify data in Assignment Information is correct
		String assignmentInformation = SOrderDetails.assignmentInformation_txt(driver).getText();

		// Only check the zillow link if called from VerifyNewOrder for Round Trip
		String form = StoredVariables.getassignmentInformationForm().get();
		System.out.println("*********FORM = " + form);
		if (!form.contains("Commercial"))
		{
			// Order due
			Assert.assertTrue(assignmentInformation.contains(StoredVariables.getorderDueDateShort().get()), "Order due is not displayed on the Order Confirmation page");
		
		
			// Rush
			if (StoredVariables.getassignmentInformationRushOrder().get() == true)
			{
				Assert.assertTrue(assignmentInformation.contains("Rush"), "Rush is not displayed on the Order Confirmation page");	
			}
			
		}
		
		// Loan type
		if (!StoredVariables.getassignmentInformationLoanType().get().equals("")) {
			Assert.assertTrue(assignmentInformation.contains(StoredVariables.getassignmentInformationLoanType().get()), "Loan type is not displayed on the Order Confirmation page");
		}
		
		// Loan purpose
		if (!StoredVariables.getassignmentInformationLoanPurpose().get().equals("")) {
			Assert.assertTrue(assignmentInformation.contains(StoredVariables.getassignmentInformationLoanPurpose().get()), "Loan purpose is not displayed on the Order Confirmation page");
		}
		
		// Lender
		if (!StoredVariables.getlenderInformationLenderName().get().equals("")) {
			Assert.assertTrue(assignmentInformation.contains(StoredVariables.getlenderInformationLenderName().get()), "Lender is not displayed on the Order Confirmation page");
		}
		
		// Sales Price
		if (!StoredVariables.getassignmentInformationSalesPrice().get().equals("")) {
			Assert.assertTrue(assignmentInformation.contains(StoredVariables.getassignmentInformationSalesPrice().get()), "Sales price is not displayed on the Order Confirmation page");
		}
		
		// Loan #
		if (!StoredVariables.getassignmentInformationLoanNumber().get().equals("")) {
			Assert.assertTrue(assignmentInformation.contains(StoredVariables.getassignmentInformationLoanNumber().get()), "Loan # is not displayed on the Order Confirmation page");
		}
		
		// Other ref #
		if (!StoredVariables.getassignmentInformationOtherRefNumber().get().equals("")) {
			Assert.assertTrue(assignmentInformation.contains(StoredVariables.getassignmentInformationOtherRefNumber().get()), "Other ref # is not displayed on the Order Confirmation page");
		}

		// File #
		if (!StoredVariables.getassignmentInformationFileNumber().get().equals("")) {
			Assert.assertTrue(assignmentInformation.contains(StoredVariables.getassignmentInformationFileNumber().get()), "File # is not displayed on the Order Confirmation page");
		}
		
		// FHA #
		if (!StoredVariables.getassignmentInformationFHACaseNumber().get().equals("")) {
			Assert.assertTrue(assignmentInformation.contains(StoredVariables.getassignmentInformationFHACaseNumber().get()), "FHA # is not displayed on the Order Confirmation page");
		}
		
		// Disclosure
		if (!StoredVariables.getdisclosureDateShort().get().equals("")) {
			Assert.assertTrue(assignmentInformation.contains(StoredVariables.getdisclosureDateShort().get()), "Disclosure is not displayed on the Order Confirmation page");
		}
		
		// Ordered by
		if (!StoredVariables.getassignmentInformationOrderedBy().get().equals("")) {
			Assert.assertTrue(assignmentInformation.contains(StoredVariables.getassignmentInformationOrderedBy().get()), "Ordered By is not displayed on the Order Confirmation page");
		}
		
		// Order group
		if (!StoredVariables.getassignmentInformationOrderGroup().get().equals("")) {
			Assert.assertTrue(assignmentInformation.contains(StoredVariables.getassignmentInformationOrderGroup().get()), "Order group is not displayed on the Order Confirmation page");
		}
		
		// Verify data in Contact And Access Information is correct
		String contactInformation = SOrderDetails.contactInformation_txt(driver).getText();
		// Occupancy
		if (!StoredVariables.getcontactOccupancy().get().equals("")) {
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactOccupancy().get()), "Occupancy is not displayed on the Order Confirmation page");
		}
		
		// Borrower
		if (!StoredVariables.getcontactBorrower().get().equals("")) {
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactBorrower().get()), "Borrower is not displayed on the Order Confirmation page");
		
			// Borrower Info 1
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactBorrowerInfo1().get().replace("-","")), "Borrower Info 1 is not displayed on the Order Confirmation page");
			
			// Borrower Info 2
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactBorrowerInfo2().get().replace("-","")), "Borrower Info 2 is not displayed on the Order Confirmation page");
			
			// Borrower Address
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactBorrowerAddress().get() + ", " + StoredVariables.getcontactBorrowerCity().get() + ", " + StoredVariables.getcontactBorrowerState().get() + " " + StoredVariables.getcontactBorrowerZip().get()), "Borrower Address is not displayed on the Order Confirmation page");
		}
		
		// CoBorrower
		if (!StoredVariables.getcontactCoBorrower().get().equals("")) {
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactCoBorrower().get()), "CoBorrower is not displayed on the Order Confirmation page");
			
			// CoBorrower Info 1
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactCoBorrowerInfo1().get().replace("-","")), "CoBorrower Info 1 is not displayed on the Order Confirmation page");
			
			// CoBorrower Info 2
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactCoBorrowerInfo2().get().replace("-","")), "CoBorrower Info 2 is not displayed on the Order Confirmation page");
			
			// CoBorrower Address
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactCoBorrowerAddress().get() + ", " + StoredVariables.getcontactCoBorrowerCity().get() + ", " + StoredVariables.getcontactCoBorrowerState().get() + " " + StoredVariables.getcontactCoBorrowerZip().get()), "CoBorrower Address is not displayed on the Order Confirmation page. Expected value = " + StoredVariables.getcontactCoBorrowerAddress().get() + "    The on-screen data = \n" + contactInformation);
		}
		
		// Owner
		if (!StoredVariables.getcontactOwner().get().equals("")) {
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactOwner().get()), "Owner is not displayed on the Order Confirmation page");
			
			// Owner Info 1
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactOwnerInfo1().get().replace("-","")), "Owner Info 1 is not displayed on the Order Confirmation page");
			
			// Owner Info 2
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactOwnerInfo2().get().replace("-","")), "Owner Info 2 is not displayed on the Order Confirmation page");
		}
		
		// Occupant
		if (!StoredVariables.getcontactOccupant().get().equals("")) {
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactOccupant().get()), "Occupant is not displayed on the Order Confirmation page");
			
			// Occupant Info 1
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactOccupantInfo1().get().replace("-","")), "Occupant Info 1 is not displayed on the Order Confirmation page");
			
			// Occupant Info 2
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactOccupantInfo2().get().replace("-","")), "Occupant Info 2 is not displayed on the Order Confirmation page");
		}
		
		// Agent
		if (!StoredVariables.getcontactAgent().get().equals("")) {
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactAgent().get()), "Agent is not displayed on the Order Confirmation page. Should be = " + StoredVariables.getcontactAgent().get() + "    The on-screen data = \n" + contactInformation);
			
			// Agent Info 1
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactAgentInfo1().get().replace("-","")), "Agent Info 1 is not displayed on the Order Confirmation page");
			
			// Agent Info 2
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactAgentInfo2().get().replace("-","")), "Agent Info 2 is not displayed on the Order Confirmation page");
		}
		
		// Other
		if (!StoredVariables.getcontactOther().get().equals("")) {
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactOther().get()), "Other is not displayed on the Order Confirmation page");
			
			// Other Info 1
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactOtherInfo1().get().replace("-","")), "Other Info 1 is not displayed on the Order Confirmation page");
			
			// Other Info 2
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactOtherInfo2().get().replace("-","")), "Other Info 2 is not displayed on the Order Confirmation page");
		}
		
		// Appt. Contact
		if (!StoredVariables.getcontactApptContact().get().equals("")) {
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactApptContact().get()), "Appt. Contact is not displayed on the Order Confirmation page");
		}
		
		// Verify Product Requirements text loads in Additional Comments section
		if (!StoredVariables.getassignmentInformationForm().get().equals("")) {
			if (StoredVariables.getassignmentInformationForm().equals("Uniform Residential Appraisal (FNMA 1004)"))
			{
				Assert.assertTrue(SOrderDetails.additionalNotificationRecipients_txt(driver).getText().contains("URAR (Form 1004 - UAD)"), "The Product Requirements text did not load in the Additional Comments");
			} // end if
		}
		
	} // end verifySecureOrderDetails
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Verify data in Property Information is correct</li>
	 * 	<li>Address</li>
	 * 	<li>City</li>
	 * 	<li>State</li>
	 * 	<li>Zip</li>
	 * 	<li>Sq Ft</li>
	 * 	<li>Site Size</li>
	 * 	<li>Prop Type</li>
	 * 	<li>Prop rights</li>
	 * 	<li>Legal Desc</li>
	 * 	<li>Directions</li>
	 * 	<li>Verify data in Assignment Information is correct</li>
	 * 	<li>Order due</li>
	 * 	<li>Rush</li>
	 * 	<li>Loan type</li>
	 * 	<li>Loan purpose</li>
	 * 	<li>Lender</li>
	 * 	<li>Sales Price</li>
	 * 	<li>Loan #</li>
	 * 	<li>Other ref #</li>
	 * 	<li>File #</li>
	 * 	<li>FHA #</li>
	 * 	<li>Ordered by</li>
	 * 	<li>Order group</li>
	 * 	<li>Verify data in Contact And Access Information is correct</li>
	 * 	<li>Occupancy</li>
	 * 	<li>Borrower</li>
	 * 	<li>Borrower Info 1</li>
	 * 	<li>Borrower Info 2</li>
	 * 	<li>CoBorrower</li>
	 * 	<li>CoBorrower Info 1</li>
	 * 	<li>CoBorrower Info 2</li>
	 * 	<li>Owner</li>
	 * 	<li>Owner Info 1</li>
	 * 	<li>Owner Info 2</li>
	 * 	<li>Occupant</li>
	 * 	<li>Occupant Info 1</li>
	 * 	<li>Occupant Info 2</li>
	 * 	<li>Agent</li>
	 * 	<li>Agent Info 1</li>
	 * 	<li>Agent Info 2</li>
	 * 	<li>Other</li>
	 * 	<li>Other Info 1</li>
	 * 	<li>Other Info 2</li>
	 * 	<li>Appt. Contact</li>
	 * 	<li>Verify Product Requirements text loads in Additional Comments section</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws InterruptedException the interrupted exception
	 */
	// Verify Order Details On Secure
	public void verifyResidentialAppraisalOrderDetails(RemoteWebDriver driver) throws InterruptedException
	{
		
		System.out.println("Verifying Order Details on Secure");
		
		// Wait for Property Information
		perform.waitForElementToBeClickable(driver, SOrderDetails.propertyInformation_txt(), "cssSelector");
		
		// Verify data in Property Information is correct
		String propertyInformation = SOrderDetails.propertyInformation_txt(driver).getText();
		// Address
		Assert.assertTrue(propertyInformation.contains(StoredVariables.getpropertyInformationAddress().get()), "Address is not displayed on the Order Confirmation page");
		
		// City
		Assert.assertTrue(propertyInformation.contains(StoredVariables.getpropertyInformationCity().get()), "City is not displayed on the Order Confirmation page");
		
		// State
		Assert.assertTrue(propertyInformation.contains(StoredVariables.getpropertyInformationStateAbbr().get()), "State is not displayed on the Order Confirmation page");
		
		// Zip
		Assert.assertTrue(propertyInformation.contains(StoredVariables.getpropertyInformationZip().get()), "Zip is not displayed on the Order Confirmation page");
		
		// Sq Ft 
		if (!StoredVariables.getpropertyInformationSqFt().get().equals("")) {
			Assert.assertTrue(propertyInformation.contains(StoredVariables.getpropertyInformationSqFt().get()), "Sq Ft is not displayed on the Order Confirmation page");
		}
		
		// Site Size
		if (!StoredVariables.getpropertyInformationSiteSize().get().equals("")) {
			Assert.assertTrue(propertyInformation.contains(StoredVariables.getpropertyInformationSiteSize().get()), "Site Size is not displayed on the Order Confirmation page");
		}
		
		// Prop Type
		if (!StoredVariables.getpropertyInformationPropType().get().equals("")) {
			Assert.assertTrue(propertyInformation.contains(StoredVariables.getpropertyInformationPropType().get()), "Prop Type is not displayed on the Order Confirmation page");
		}
		
		// Prop rights
		if (!StoredVariables.getpropertyInformationPropRights().get().equals("")) {
			Assert.assertTrue(propertyInformation.contains(StoredVariables.getpropertyInformationPropRights().get()), "Prop Rights is not displayed on the Order Confirmation page");
		}
		
		// Legal Desc
		if (!StoredVariables.getpropertyInformationLegalDesc().get().equals("")) {
			Assert.assertTrue(propertyInformation.contains(StoredVariables.getpropertyInformationLegalDesc().get()), "Legal Desc is not displayed on the Order Confirmation page");
		}
		
		// Directions
		if (!StoredVariables.getpropertyInformationDirections().get().equals("")) {
			Assert.assertTrue(propertyInformation.contains(StoredVariables.getpropertyInformationDirections().get()), "Directions is not displayed on the Order Confirmation page");
		}
		
		// Verify data in Assignment Information is correct
		String assignmentInformation = SOrderDetails.assignmentInformation_txt(driver).getText();

		// Order due
		Assert.assertTrue(assignmentInformation.contains(StoredVariables.getorderDueDateShort().get()), "Order due is not displayed on the Order Confirmation page. Should be = " + StoredVariables.getorderDueDateShort().get() + "    The on-screen data = \n" + assignmentInformation);
		
		// Rush
		if (StoredVariables.getassignmentInformationRushOrder().get() == true)
		{
			Assert.assertTrue(assignmentInformation.contains("Rush"), "Rush is not displayed on the Order Confirmation page");	
		}
		
		// Loan type
		if (!StoredVariables.getassignmentInformationLoanType().get().equals("")) {
			Assert.assertTrue(assignmentInformation.contains(StoredVariables.getassignmentInformationLoanType().get()), "Loan type is not displayed on the Order Confirmation page");
		}
		
		// Loan purpose
		if (!StoredVariables.getassignmentInformationLoanPurpose().get().equals("")) {
			Assert.assertTrue(assignmentInformation.contains(StoredVariables.getassignmentInformationLoanPurpose().get()), "Loan purpose is not displayed on the Order Confirmation page");
		}
		
		// Lender
		if (!StoredVariables.getlenderInformationLenderName().get().equals("")) {
			Assert.assertTrue(assignmentInformation.contains(StoredVariables.getlenderInformationLenderName().get()), "Lender is not displayed on the Order Confirmation page");
		}
		
		// Sales Price
		if (!StoredVariables.getassignmentInformationSalesPrice().get().equals("")) {
			Assert.assertTrue(assignmentInformation.contains(StoredVariables.getassignmentInformationSalesPrice().get()), "Sales price is not displayed on the Order Confirmation page");
		}
		
		// Loan #
		if (!StoredVariables.getassignmentInformationLoanNumber().get().equals("")) {
			Assert.assertTrue(assignmentInformation.contains(StoredVariables.getassignmentInformationLoanNumber().get()), "Loan # is not displayed on the Order Confirmation page");
		}
		
		// Other ref #
		if (!StoredVariables.getassignmentInformationOtherRefNumber().get().equals("")) {
			Assert.assertTrue(assignmentInformation.contains(StoredVariables.getassignmentInformationOtherRefNumber().get()), "Other ref # is not displayed on the Order Confirmation page");
		}

		// File #
		if (!StoredVariables.getassignmentInformationFileNumber().get().equals("")) {
			Assert.assertTrue(assignmentInformation.contains(StoredVariables.getassignmentInformationFileNumber().get()), "File # is not displayed on the Order Confirmation page");
		}
		
		// FHA #
		if (!StoredVariables.getassignmentInformationFHACaseNumber().get().equals("")) {
			Assert.assertTrue(assignmentInformation.contains(StoredVariables.getassignmentInformationFHACaseNumber().get()), "FHA # is not displayed on the Order Confirmation page");
		}
		
		// Ordered by
		if (!StoredVariables.getassignmentInformationOrderedBy().get().equals("")) {
			Assert.assertTrue(assignmentInformation.contains(StoredVariables.getassignmentInformationOrderedBy().get()), "Ordered By is not displayed on the Order Confirmation page");
		}
		
		// Order group
		if (!StoredVariables.getassignmentInformationOrderGroup().get().equals("")) {
			Assert.assertTrue(assignmentInformation.contains(StoredVariables.getassignmentInformationOrderGroup().get()), "Order group is not displayed on the Order Confirmation page");
		}
		
		// Verify data in Contact And Access Information is correct
		String contactInformation = SOrderDetails.contactInformation_txt(driver).getText();
		
		// Occupancy
		if (!StoredVariables.getcontactOccupancy().get().equals("")) {
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactOccupancy().get()), "Occupancy is not displayed on the Order Confirmation page");
		}
		
		// Borrower
		if (!StoredVariables.getcontactBorrower().get().equals("")) {
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactBorrower().get()), "Borrower is not displayed on the Order Confirmation page");
			
			// Borrower Info 1
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactBorrowerInfo1().get()), "Borrower Info 1 is not displayed on the Order Confirmation page. Should be = " + StoredVariables.getcontactBorrowerInfo1().get() + "    The on-screen data = \n" + contactInformation);
			
			// Borrower Info 2
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactBorrowerInfo2().get()), "Borrower Info 2 is not displayed on the Order Confirmation page");
		}
		
		// CoBorrower
		if (!StoredVariables.getcontactCoBorrower().get().equals("")) {
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactCoBorrower().get()), "CoBorrower is not displayed on the Order Confirmation page");
			
			// CoBorrower Info 1
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactCoBorrowerInfo1().get()), "CoBorrower Info 1 is not displayed on the Order Confirmation page");
			
			// CoBorrower Info 2
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactCoBorrowerInfo2().get()), "CoBorrower Info 2 is not displayed on the Order Confirmation page");
		}
		
		// Owner
		if (!StoredVariables.getcontactOwner().get().equals("")) {
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactOwner().get()), "Owner is not displayed on the Order Confirmation page");
			
			// Owner Info 1
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactOwnerInfo1().get()), "Owner Info 1 is not displayed on the Order Confirmation page");
			
			// Owner Info 2
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactOwnerInfo2().get()), "Owner Info 2 is not displayed on the Order Confirmation page");
		}
		
		// Occupant
		if (!StoredVariables.getcontactOccupant().get().equals("")) {
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactOccupant().get()), "Occupant is not displayed on the Order Confirmation page");
			
			// Occupant Info 1
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactOccupantInfo1().get()), "Occupant Info 1 is not displayed on the Order Confirmation page");
			
			// Occupant Info 2
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactOccupantInfo2().get()), "Occupant Info 2 is not displayed on the Order Confirmation page");
		}
		
		// Agent
		if (!StoredVariables.getcontactAgent().get().equals("")) {
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactAgent().get()), "Agent is not displayed on the Order Confirmation page");
			
			// Agent Info 1
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactAgentInfo1().get()), "Agent Info 1 is not displayed on the Order Confirmation page");
			
			// Agent Info 2
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactAgentInfo2().get()), "Agent Info 2 is not displayed on the Order Confirmation page");
		}
		
		// Other
		if (!StoredVariables.getcontactOther().get().equals("")) {
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactOther().get()), "Other is not displayed on the Order Confirmation page");
			
			// Other Info 1
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactOtherInfo1().get()), "Other Info 1 is not displayed on the Order Confirmation page");
			
			// Other Info 2
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactOtherInfo2().get()), "Other Info 2 is not displayed on the Order Confirmation page");
		}
		
		// Appt. Contact
		if (!StoredVariables.getcontactApptContact().get().equals("")) {
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactApptContact().get()), "Appt. Contact is not displayed on the Order Confirmation page");
		}
		
		// Verify Product Requirements text loads in Additional Comments section
		if (!StoredVariables.getassignmentInformationForm().get().equals("")) {
			if (StoredVariables.getassignmentInformationForm().equals("Uniform Residential Appraisal (FNMA 1004)"))
			{
				Assert.assertTrue(SOrderDetails.additionalNotificationRecipients_txt(driver).getText().contains("URAR (Form 1004 - UAD)"), "The Product Requirements text did not load in the Additional Comments");
			} // end if
		}
		
	} // end verifyResidentialAppraisalOrderDetailsOnSecure
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Verify data in Property Information is correct</li>
	 * 	<li>Address</li>
	 * 	<li>City</li>
	 * 	<li>State</li>
	 * 	<li>Zip</li>
	 * 	<li>Sq Ft</li>
	 * 	<li>Site Size</li>
	 * 	<li>Prop Type</li>
	 * 	<li>Prop rights</li>
	 * 	<li>Legal Desc</li>
	 * 	<li>Directions</li>
	 * 	<li>Verify data in Assignment Information is correct</li>
	 * 	<li>Order due</li>
	 * 	<li>Rush</li>
	 * 	<li>Loan type</li>
	 * 	<li>Loan purpose</li>
	 * 	<li>Lender</li>
	 * 	<li>Sales Price</li>
	 * 	<li>Loan #</li>
	 * 	<li>Other ref #</li>
	 * 	<li>File #</li>
	 * 	<li>FHA #</li>
	 * 	<li>Disclosure</li>
	 * 	<li>Ordered by</li>
	 * 	<li>Order group</li>
	 * 	<li>Verify data in Contact And Access Information is correct</li>
	 * 	<li>Occupancy</li>
	 * 	<li>Borrower</li>
	 * 	<li>Borrower Info 1</li>
	 * 	<li>Borrower Info 2</li>
	 * 	<li>CoBorrower</li>
	 * 	<li>CoBorrower Info 1</li>
	 * 	<li>CoBorrower Info 2</li>
	 * 	<li>Owner</li>
	 * 	<li>Owner Info 1</li>
	 * 	<li>Owner Info 2</li>
	 * 	<li>Occupant</li>
	 * 	<li>Occupant Info 1</li>
	 * 	<li>Occupant Info 2</li>
	 * 	<li>Agent</li>
	 * 	<li>Agent Info 1</li>
	 * 	<li>Agent Info 2</li>
	 * 	<li>Other</li>
	 * 	<li>Other Info 1</li>
	 * 	<li>Other Info 2</li>
	 * 	<li>Appt. Contact</li>
	 * 	<li>Verify Product Requirements text loads in Additional Comments section</li>
	 * 	<li>Verify Vendor's fee notes display</li>
	 * </ul>
	 *
	 * @param driver the driver
	 */
	// Verify Order Details on Secure
	public void verifyReassignResidentialAppraisalOrderDetails(RemoteWebDriver driver)
	{
		
		System.out.println("Verifying Order Details on Secure");
		
		// Verify data in Property Information is correct
		String propertyInformation = SOrderDetails.propertyInformation_txt(driver).getText();
		// Address
		Assert.assertTrue(propertyInformation.contains(StoredVariables.getpropertyInformationAddress().get()), "Address is not displayed on the Order Confirmation page");
		
		// City
		Assert.assertTrue(propertyInformation.contains(StoredVariables.getpropertyInformationCity().get()), "City is not displayed on the Order Confirmation page");
		
		// State
		Assert.assertTrue(propertyInformation.contains(StoredVariables.getpropertyInformationStateAbbr().get()), "State is not displayed on the Order Confirmation page");
		
		// Zip
		Assert.assertTrue(propertyInformation.contains(StoredVariables.getpropertyInformationZip().get()), "Zip is not displayed on the Order Confirmation page");
		
		// Sq Ft 
		if (!StoredVariables.getpropertyInformationSqFt().get().equals("")) {
			Assert.assertTrue(propertyInformation.contains(StoredVariables.getpropertyInformationSqFt().get()), "Sq Ft is not displayed on the Order Confirmation page");
		}
		
		// Site Size
		if (!StoredVariables.getpropertyInformationSiteSize().get().equals("")) {
			Assert.assertTrue(propertyInformation.contains(StoredVariables.getpropertyInformationSiteSize().get()), "Site Size is not displayed on the Order Confirmation page");
		}
		
		// Prop Type
		if (!StoredVariables.getpropertyInformationPropType().get().equals("")) {
			Assert.assertTrue(propertyInformation.contains(StoredVariables.getpropertyInformationPropType().get()), "Prop Type is not displayed on the Order Confirmation page");
		}
		
		// Prop rights
		if (!StoredVariables.getpropertyInformationPropRights().get().equals("")) {
			Assert.assertTrue(propertyInformation.contains(StoredVariables.getpropertyInformationPropRights().get()), "Prop Rights is not displayed on the Order Confirmation page");
		}
		
		// Legal Desc
		if (!StoredVariables.getpropertyInformationLegalDesc().get().equals("")) {
			Assert.assertTrue(propertyInformation.contains(StoredVariables.getpropertyInformationLegalDesc().get()), "Legal Desc is not displayed on the Order Confirmation page");
		}
		
		// Directions
		if (!StoredVariables.getpropertyInformationDirections().get().equals("")) {
			Assert.assertTrue(propertyInformation.contains(StoredVariables.getpropertyInformationDirections().get()), "Directions is not displayed on the Order Confirmation page");
		}
		
		// Verify data in Assignment Information is correct
		String assignmentInformation = SOrderDetails.assignmentInformation_txt(driver).getText();

		// Order due
		Assert.assertTrue(assignmentInformation.contains(StoredVariables.getorderDueDateShort().get()), "Order due is not displayed on the Order Confirmation page");
		
		// Rush
		if (StoredVariables.getassignmentInformationRushOrder().get() == true)
		{
			Assert.assertTrue(assignmentInformation.contains("Rush"), "Rush is not displayed on the Order Confirmation page");	
		}
		
		// Loan type
		if (!StoredVariables.getassignmentInformationLoanType().get().equals("")) {
			Assert.assertTrue(assignmentInformation.contains(StoredVariables.getassignmentInformationLoanType().get()), "Loan type is not displayed on the Order Confirmation page");
		}
		
		// Loan purpose
		if (!StoredVariables.getassignmentInformationLoanPurpose().get().equals("")) {
			Assert.assertTrue(assignmentInformation.contains(StoredVariables.getassignmentInformationLoanPurpose().get()), "Loan purpose is not displayed on the Order Confirmation page");
		}
		
		// Lender
		if (!StoredVariables.getlenderInformationLenderName().get().equals("")) {
			Assert.assertTrue(assignmentInformation.contains(StoredVariables.getlenderInformationLenderName().get()), "Lender is not displayed on the Order Confirmation page");
		}
		
		// Sales Price
		if (!StoredVariables.getassignmentInformationSalesPrice().get().equals("")) {
			Assert.assertTrue(assignmentInformation.contains(StoredVariables.getassignmentInformationSalesPrice().get()), "Sales price is not displayed on the Order Confirmation page");
		}
		
		// Loan #
		if (!StoredVariables.getassignmentInformationLoanNumber().get().equals("")) {
			Assert.assertTrue(assignmentInformation.contains(StoredVariables.getassignmentInformationLoanNumber().get()), "Loan # is not displayed on the Order Confirmation page");
		}
		
		// Other ref #
		if (!StoredVariables.getassignmentInformationOtherRefNumber().get().equals("")) {
			Assert.assertTrue(assignmentInformation.contains(StoredVariables.getassignmentInformationOtherRefNumber().get()), "Other ref # is not displayed on the Order Confirmation page");
		}

		// File #
		if (!StoredVariables.getassignmentInformationFileNumber().get().equals("")) {
			Assert.assertTrue(assignmentInformation.contains(StoredVariables.getassignmentInformationFileNumber().get()), "File # is not displayed on the Order Confirmation page");
		}
		
		// FHA #
		if (!StoredVariables.getassignmentInformationFHACaseNumber().get().equals("")) {
			Assert.assertTrue(assignmentInformation.contains(StoredVariables.getassignmentInformationFHACaseNumber().get()), "FHA # is not displayed on the Order Confirmation page");
		}
		
		// Disclosure
		if (!StoredVariables.getdisclosureDateShort().get().equals("")) {
			Assert.assertTrue(assignmentInformation.contains(StoredVariables.getdisclosureDateShort().get()), "Disclosure is not displayed on the Order Confirmation page");
		}
		
		// Ordered by
		if (!StoredVariables.getassignmentInformationOrderedBy().get().equals("")) {
			Assert.assertTrue(assignmentInformation.contains(StoredVariables.getassignmentInformationOrderedBy().get()), "Ordered By is not displayed on the Order Confirmation page");
		}
		
		// Order group
		if (!StoredVariables.getassignmentInformationOrderGroup().get().equals("")) {
			Assert.assertTrue(assignmentInformation.contains(StoredVariables.getassignmentInformationOrderGroup().get()), "Order group is not displayed on the Order Confirmation page");
		}
		
		// Verify data in Contact And Access Information is correct
		
		String contactInformation = SOrderDetails.contactInformation_txt(driver).getText();
		// Occupancy
		if (!StoredVariables.getcontactOccupancy().get().equals("")) {
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactOccupancy().get()), "Occupancy is not displayed on the Order Confirmation page");
		}
		
		// Borrower
		if (!StoredVariables.getcontactBorrower().get().equals("")) {
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactBorrower().get()), "Borrower is not displayed on the Order Confirmation page");
			
			// Borrower Info 1
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactBorrowerInfo1().get().replace("-","")), "Borrower Info 1 is not displayed on the Order Confirmation page");
			
			// Borrower Info 2
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactBorrowerInfo2().get().replace("-","")), "Borrower Info 2 is not displayed on the Order Confirmation page");
		}
		
		// CoBorrower
		if (!StoredVariables.getcontactCoBorrower().get().equals("")) {
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactCoBorrower().get()), "CoBorrower is not displayed on the Order Confirmation page");
			
			// CoBorrower Info 1
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactCoBorrowerInfo1().get().replace("-","")), "CoBorrower Info 1 is not displayed on the Order Confirmation page");
			
			// CoBorrower Info 2
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactCoBorrowerInfo2().get().replace("-","")), "CoBorrower Info 2 is not displayed on the Order Confirmation page");
		}
		
		// Owner
		if (!StoredVariables.getcontactOwner().get().equals("")) {
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactOwner().get()), "Owner is not displayed on the Order Confirmation page");
			
			// Owner Info 1
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactOwnerInfo1().get().replace("-","")), "Owner Info 1 is not displayed on the Order Confirmation page");
			
			// Owner Info 2
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactOwnerInfo2().get().replace("-","")), "Owner Info 2 is not displayed on the Order Confirmation page");
		}
		
		// Occupant
		if (!StoredVariables.getcontactOccupant().get().equals("")) {
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactOccupant().get()), "Occupant is not displayed on the Order Confirmation page");
			
			// Occupant Info 1
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactOccupantInfo1().get().replace("-","")), "Occupant Info 1 is not displayed on the Order Confirmation page");
			
			// Occupant Info 2
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactOccupantInfo2().get().replace("-","")), "Occupant Info 2 is not displayed on the Order Confirmation page");
		}
		
		// Agent
		if (!StoredVariables.getcontactAgent().get().equals("")) {
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactAgent().get()), "Agent is not displayed on the Order Confirmation page");
			
			// Agent Info 1
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactAgentInfo1().get().replace("-","")), "Agent Info 1 is not displayed on the Order Confirmation page");
			
			// Agent Info 2
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactAgentInfo2().get().replace("-","")), "Agent Info 2 is not displayed on the Order Confirmation page");
		}
		
		// Other
		if (!StoredVariables.getcontactOther().get().equals("")) {
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactOther().get()), "Other is not displayed on the Order Confirmation page");
			
			// Other Info 1
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactOtherInfo1().get().replace("-","")), "Other Info 1 is not displayed on the Order Confirmation page");
			
			// Other Info 2
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactOtherInfo2().get().replace("-","")), "Other Info 2 is not displayed on the Order Confirmation page");
		}
		
		// Appt. Contact
		if (!StoredVariables.getcontactApptContact().get().equals("")) {
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactApptContact().get()), "Appt. Contact is not displayed on the Order Confirmation page");
		}
		
		// Verify Product Requirements text loads in Additional Comments section
		if (!StoredVariables.getassignmentInformationForm().get().equals("")) {
			if (StoredVariables.getassignmentInformationForm().equals("Uniform Residential Appraisal (FNMA 1004)"))
			{
				Assert.assertTrue(SOrderDetails.additionalNotificationRecipients_txt(driver).getText().contains("URAR (Form 1004 - UAD)"), "The Product Requirements text did not load in the Additional Comments");
			} // end if
		}
		
		// Verify Vendor's fee notes display
		Assert.assertTrue(SConfirmOrder.vendorsNotes_txt(driver).getText().contains("These are"), "The vendor's fee notes did not display");
		
	} // end verifyReassignResidentialAppraisalOrderDetailsOnSecure
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Address</li>
	 * 	<li>City</li>
	 * 	<li>State</li>
	 * 	<li>Zip</li>
	 * 	<li>Sq ft</li>
	 * 	<li>Site size</li>
	 * 	<li>Prop Type</li>
	 * 	<li>Prop Rights</li>
	 * 	<li>Legal desc</li>
	 * 	<li>Directions</li>
	 * 	<li>Form</li>
	 * 	<li>Rush Order checkbox</li>
	 * 	<li>Complex checkbox</li>
	 * 	<li>Order Due</li>
	 * 	<li>Other Ref #</li>
	 * 	<li>Loan Type</li>
	 * 	<li>Loan Purpose</li>
	 * 	<li>Ordered By</li>
	 * 	<li>Loan #</li>
	 * 	<li>File #</li>
	 * 	<li>Sales Price</li>
	 * 	<li>FHA Case #</li>
	 * 	<li>Disclosure</li>
	 * 	<li>Assigned To</li>
	 * 	<li>Lender Name</li>
	 * 	<li>Address 1</li>
	 * 	<li>Address 2</li>
	 * 	<li>City</li>
	 * 	<li>State</li>
	 * 	<li>Zip</li>
	 * 	<li>Occupancy</li>
	 * 	<li>Borrower</li>
	 * 	<li>Borrower Info 1 dropdown</li>
	 * 	<li>Borrower Info 1</li>
	 * 	<li>Borrower Info 2 dropdown</li>
	 * 	<li>Borrower Info 2</li>
	 * 	<li>Click the borrower address button</li>
	 * 	<li>Borrower Address</li>
	 * 	<li>Borrower City</li>
	 * 	<li>Borrower State</li>
	 * 	<li>Borrower Zip</li>
	 * 	<li>Click the Cancel button</li>
	 * 	<li>CoBorrower</li>
	 * 	<li>CoBorrower Info 1 dropdown</li>
	 * 	<li>CoBorrower Info 1</li>
	 * 	<li>CoBorrower Info 2 dropdown</li>
	 * 	<li>CoBorrower Info 2</li>
	 * 	<li>Click the CoBorrower address button</li>
	 * 	<li>CoBorrower Address</li>
	 * 	<li>CoBorrower City</li>
	 * 	<li>CoBorrower State</li>
	 * 	<li>CoBorrower Zip</li>
	 * 	<li>Click the Cancel button</li>
	 * 	<li>Owner</li>
	 * 	<li>Owner Info 1 dropdown</li>
	 * 	<li>Owner Info 1</li>
	 * 	<li>Owner Info 2 dropdown</li>
	 * 	<li>Owner Info 2</li>
	 * 	<li>Occupant</li>
	 * 	<li>Occupant Info 1 dropdown</li>
	 * 	<li>Occupant Info 1</li>
	 * 	<li>Occupant Info 2 dropdown</li>
	 * 	<li>Occupant Info 2</li>
	 * 	<li>Agent</li>
	 * 	<li>Agent Info 1 dropdown</li>
	 * 	<li>Agent Info 1</li>
	 * 	<li>Agent Info 2 dropdown</li>
	 * 	<li>Agent Info 2</li>
	 * 	<li>Other</li>
	 * 	<li>Other Info 1 dropdown</li>
	 * 	<li>Other Info 1</li>
	 * 	<li>Other Info 2 dropdown</li>
	 * 	<li>Other Info 2</li>
	 * 	<li>Appt. Contact</li>
	 * 	<li>Additional Email</li>
	 * 	<li>Attach completed report checkbox</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws InterruptedException the interrupted exception
	 */
	// Verify Secure New Order Info
	public void verifyNewOrderInfo(RemoteWebDriver driver) throws InterruptedException
	{
		
		System.out.println("Verifying New Order Information On Secure");
		
		// Wait for Address
		perform.waitForElementToBeClickable(driver, SNewOrder.address_txtbx(), "id");
		
		/************************************************
		 * Property Information
		 ************************************************/
		// Address
		Assert.assertTrue(SNewOrder.address_txtbx(driver).getAttribute("value").equals(StoredVariables.getpropertyInformationAddress().get()), "Address information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getpropertyInformationAddress().get());
		
		// City
		Assert.assertTrue(SNewOrder.city_txtbx(driver).getAttribute("value").equals(StoredVariables.getpropertyInformationCity().get()), "City information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getpropertyInformationCity().get());
		
		// State
		String stateDropdown = new Select(SNewOrder.state_dropdown(driver)).getFirstSelectedOption().getText();
		Assert.assertTrue(stateDropdown.equals(StoredVariables.getpropertyInformationState().get()), "State information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getpropertyInformationState().get());
		
		// Zip
		Assert.assertTrue(SNewOrder.zipCode_txtbx(driver).getAttribute("value").equals(StoredVariables.getpropertyInformationZip().get()), "Zip information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getpropertyInformationZip().get());
		
		// Sq ft
		if (!StoredVariables.getpropertyInformationSqFt().get().equals("")) {
			Assert.assertTrue(SNewOrder.sqFt_txtbx(driver).getAttribute("value").equals(StoredVariables.getpropertyInformationSqFt().get()), "Sq Ft information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getpropertyInformationSqFt().get());
		}
		
		// Site size
		if (!StoredVariables.getpropertyInformationSiteSize().get().equals("")) {
			Assert.assertTrue(SNewOrder.siteSize_txtbx(driver).getAttribute("value").equals(StoredVariables.getpropertyInformationSiteSize().get()), "Site Size information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getpropertyInformationSiteSize().get());
		}
		
		// Prop Type
		if (!StoredVariables.getpropertyInformationPropType().get().equals("")) {
			String propTypeDropdown = new Select(SNewOrder.propType_dropdown(driver)).getFirstSelectedOption().getText();
			Assert.assertTrue(propTypeDropdown.equals(StoredVariables.getpropertyInformationPropType().get()), "Prop Type information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getpropertyInformationPropType().get());
		}
		
		// Prop Rights
		if (!StoredVariables.getpropertyInformationPropRights().get().equals("")) {
			String propRightsDropdown = new Select(SNewOrder.propRights_dropdown(driver)).getFirstSelectedOption().getText();
			Assert.assertTrue(propRightsDropdown.equals(StoredVariables.getpropertyInformationPropRights().get()), "Prop Rights information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getpropertyInformationPropRights().get());
		}
		
		// Legal desc
		if (!StoredVariables.getpropertyInformationLegalDesc().get().equals("")) {
			Assert.assertTrue(SNewOrder.legalDesc_txtbx(driver).getAttribute("value").equals(StoredVariables.getpropertyInformationLegalDesc().get()), "Legal Desc information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getpropertyInformationLegalDesc().get());
		}
		
		// Directions
		if (!StoredVariables.getpropertyInformationDirections().get().equals("")) {
			Assert.assertTrue(SNewOrder.directions_txtbx(driver).getAttribute("value").equals(StoredVariables.getpropertyInformationDirections().get()), "Directions information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getpropertyInformationDirections().get());
		}
		
		/************************************************
		 * Assignment Information
		 ************************************************/
		// Form
		if (!StoredVariables.getassignmentInformationForm().get().equals("")) {
			String formDropdown = new Select(SNewOrder.form_dropdown(driver)).getFirstSelectedOption().getText();
			Assert.assertTrue(formDropdown.equals(StoredVariables.getassignmentInformationForm().get()), "Form information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getassignmentInformationForm().get());
		}
		
		// Rush Order checkbox
		if (StoredVariables.getassignmentInformationRushOrder().get() == true)
		{
			Assert.assertTrue(SNewOrder.rushOrder_chkbx(driver).isSelected(), "Rush Order information was lost on the New Order page after clicking Back from the Confirm Order page");			
		}
		
		// Complex checkbox
		if (StoredVariables.getassignmentInformationComplex().get() == true)
		{
			Assert.assertTrue(SNewOrder.complex_chkbx(driver).isSelected(), "Complex information was lost on the New Order page after clicking Back from the Confirm Order page");			
		}
		
		// Order Due
		Assert.assertTrue(SNewOrder.orderDue_txtbx(driver).getAttribute("value").equals(StoredVariables.getorderDueDateShort().get()), "Order Due information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getorderDueDateShort().get());
		
		// Other Ref #
		if (!StoredVariables.getassignmentInformationOtherRefNumber().get().equals("")) {
			Assert.assertTrue(SNewOrder.otherRefNumber_txtbx(driver).getAttribute("value").equals(StoredVariables.getassignmentInformationOtherRefNumber().get()), "Other Ref # information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getassignmentInformationOtherRefNumber().get());
		}
		
		// Loan Type
		if (!StoredVariables.getassignmentInformationLoanType().get().equals("")) {
			String loanTypeDropdown = new Select(SNewOrder.loanType_dropdown(driver)).getFirstSelectedOption().getText();
			Assert.assertTrue(loanTypeDropdown.equals(StoredVariables.getassignmentInformationLoanType().get()), "Loan Type information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getassignmentInformationLoanType().get());
		}
		
		// Loan Purpose
		if (!StoredVariables.getassignmentInformationLoanPurpose().get().equals("")) {
			String loanPurposeDropdown = new Select(SNewOrder.loanPurpose_dropdown(driver)).getFirstSelectedOption().getText();
			Assert.assertTrue(loanPurposeDropdown.equals(StoredVariables.getassignmentInformationLoanPurpose().get()), "Loan Purpose information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getassignmentInformationLoanPurpose().get());
		}
		
		// Ordered By
		if (!StoredVariables.getassignmentInformationOrderedBy().get().equals("")) {
			Assert.assertTrue(SNewOrder.orderedBy_txtbx(driver).getAttribute("value").equals(StoredVariables.getassignmentInformationOrderedBy().get()), "Ordered By information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getassignmentInformationOrderedBy().get());
		}
		
		// Loan #
		if (!StoredVariables.getassignmentInformationLoanNumber().get().equals("")) {
			Assert.assertTrue(SNewOrder.loanNumber_txtbx(driver).getAttribute("value").equals(StoredVariables.getassignmentInformationLoanNumber().get()), "Loan # information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getassignmentInformationLoanNumber().get());
		}
		
		// File #
		if (!StoredVariables.getassignmentInformationFileNumber().get().equals("")) {
			Assert.assertTrue(SNewOrder.fileNumber_txtbx(driver).getAttribute("value").equals(StoredVariables.getassignmentInformationFileNumber().get()), "File # information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getassignmentInformationFileNumber().get());
		}
		
		// Sales Price
		if (!StoredVariables.getassignmentInformationSalesPrice().get().equals("")) {
			Assert.assertTrue(SNewOrder.salesPrice_txtbx(driver).getAttribute("value").equals(StoredVariables.getassignmentInformationSalesPrice().get().replace(",","")), "Sales Price information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getassignmentInformationSalesPrice().get());
		}
		
		// FHA Case #
		if (!StoredVariables.getassignmentInformationFHACaseNumber().get().equals("")) {
			Assert.assertTrue(SNewOrder.fhaCaseNumber_txtbx(driver).getAttribute("value").equals(StoredVariables.getassignmentInformationFHACaseNumber().get()), "FHA Case information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getassignmentInformationFHACaseNumber().get());
		}
		
		// Disclosure
		if (!StoredVariables.getdisclosureDateShort().get().equals("")) {
			Assert.assertTrue(SNewOrder.disclosure_txtbx(driver).getAttribute("value").equals(StoredVariables.getdisclosureDateShort().get()), "Disclosure information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getdisclosureDateShort().get());
		}
		
		// Assigned To
		if (!StoredVariables.getassignmentInformationAssignedTo().get().equals("")) {
			String assignedToDropdown = new Select(SNewOrder.assignedTo_dropdown(driver)).getFirstSelectedOption().getText();
			Assert.assertTrue(assignedToDropdown.equals(StoredVariables.getassignmentInformationAssignedTo().get()), "Assigned To information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getassignmentInformationAssignedTo().get());
		}
		
		/************************************************
		 * Lender Information
		 ************************************************/
		if (!StoredVariables.getlenderInformationLenderName().get().equals("")) {
			// Lender Name
			Assert.assertTrue(SNewOrder.lenderName_txtbx(driver).getAttribute("value").equals(StoredVariables.getlenderInformationLenderName().get()), "Lender Name information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getlenderInformationLenderName().get());
			
			// Address 1
			Assert.assertTrue(SNewOrder.lenderAddress1_txtbx(driver).getAttribute("value").equals(StoredVariables.getlenderInformationAddress1().get()), "Lender Address 1 information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getlenderInformationAddress1().get());
			
			// Address 2
			Assert.assertTrue(SNewOrder.lenderAddress2_txtbx(driver).getAttribute("value").equals(StoredVariables.getlenderInformationAddress2().get()), "Lender Address 2 information was lost on the New Order page after clicking Back from the Confirm Order page. Should be = " + StoredVariables.getlenderInformationAddress2().get() + "    The on-screen data = " + SNewOrder.lenderAddress2_txtbx(driver).getAttribute("value"));
			
			// City
			Assert.assertTrue(SNewOrder.lenderCity_txtbx(driver).getAttribute("value").equals(StoredVariables.getlenderInformationCity().get()), "City information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getlenderInformationCity().get());
			
			// State
			String lenderStateDropdown = new Select(SNewOrder.lenderState_dropdown(driver)).getFirstSelectedOption().getText();
			Assert.assertTrue(lenderStateDropdown.equals(StoredVariables.getlenderInformationState().get()), "State information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getlenderInformationState().get());
			
			// Zip
			Assert.assertTrue(SNewOrder.lenderZip_txtbx(driver).getAttribute("value").equals(StoredVariables.getlenderInformationZip().get()), "Zip information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getlenderInformationZip().get());
		}
		
		/************************************************
		 * Contact and Access Information
		 ************************************************/
		// Occupancy
		if (!StoredVariables.getcontactOccupancy().get().equals("")) {
			String occupancyDropdown = new Select(SNewOrder.occupancy_dropdown(driver)).getFirstSelectedOption().getText();
			Assert.assertTrue(occupancyDropdown.equals(StoredVariables.getcontactOccupancy().get()), "Zip information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getcontactOccupancy().get());
		}
		
		// Borrower
		if (!StoredVariables.getcontactBorrower().get().equals("")) {
			Assert.assertTrue(SNewOrder.borrower_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactBorrower().get() + "-" + StoredVariables.getborrowerIdentifier().get()), "Borrower information was lost on the New Order page after clicking Back from the Confirm Order page. Borrower = " + StoredVariables.getcontactBorrower().get() + "-" + StoredVariables.getborrowerIdentifier().get() + "     The on-screen data = \n" + SNewOrder.borrower_txtbx(driver).getAttribute("value"));
			
			// Borrower Info 1 dropdown
			String borrowerInfo1Dropdown = new Select(SNewOrder.borrowerInfo1_dropdown(driver)).getFirstSelectedOption().getText();
			Assert.assertTrue(borrowerInfo1Dropdown.equals(StoredVariables.getcontactBorrowerInfo1Dropdown().get()), "Borrower Info 1 Dropdown information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getcontactBorrowerInfo1Dropdown().get());
			
			// Borrower Info 1
			Assert.assertTrue(SNewOrder.borrowerInfo1_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactBorrowerInfo1().get()), "Borrower Info 1 information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getcontactBorrowerInfo1().get());
			
			// Borrower Info 2 dropdown
			String borrowerInfo2Dropdown = new Select(SNewOrder.borrowerInfo2_dropdown(driver)).getFirstSelectedOption().getText();
			Assert.assertTrue(borrowerInfo2Dropdown.equals(StoredVariables.getcontactBorrowerInfo2Dropdown().get()), "Borrower Info 2 Dropdown information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getcontactBorrowerInfo2Dropdown().get());
			
			// Borrower Info 2
			Assert.assertTrue(SNewOrder.borrowerInfo2_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactBorrowerInfo2().get()), "Borrower Info 2 information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getcontactBorrowerInfo2().get());
		}
		
		// Click the borrower address button
		if (!StoredVariables.getcontactBorrowerAddress().get().equals("")) {
			perform.click(driver, SNewOrder.borrowerAddress_btn(driver));
			
			// Borrower Address
			Assert.assertTrue(SNewOrder.borrowerAddress_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactBorrowerAddress().get()), "Borrower Address information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getcontactBorrowerAddress().get());
			
			// Borrower City
			Assert.assertTrue(SNewOrder.borrowerCity_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactBorrowerCity().get()), "Borrower City information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getcontactBorrowerCity().get());
			
			// Borrower State
			Assert.assertTrue(SNewOrder.borrowerState_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactBorrowerState().get()), "Borrower State information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getcontactBorrowerState().get());
			
			// Borrower Zip
			Assert.assertTrue(SNewOrder.borrowerZip_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactBorrowerZip().get()), "Borrower Zip information was lost on the New Order page after clicking Back from the Confirm Order page. Should be = " + StoredVariables.getcontactBorrowerZip().get() + "     The on-screen data = " + SNewOrder.borrowerZip_txtbx(driver).getAttribute("value"));
			
			// Click the Cancel button
			perform.click(driver, SNewOrder.borrowerCancel_btn(driver));
		}
		
		// CoBorrower
		if (!StoredVariables.getcontactCoBorrower().get().equals("")) {
			Assert.assertTrue(SNewOrder.coBorrower_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactCoBorrower().get()), "CoBorrower information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getcontactCoBorrower().get());
			
			// CoBorrower Info 1 dropdown
			String coBorrowerInfo1Dropdown = new Select(SNewOrder.coBorrowerInfo1_dropdown(driver)).getFirstSelectedOption().getText();
			Assert.assertTrue(coBorrowerInfo1Dropdown.equals(StoredVariables.getcontactCoBorrowerInfo1Dropdown().get()), "CoBorrower Info 1 Dropdown information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getcontactCoBorrowerInfo1Dropdown().get());
			
			// CoBorrower Info 1
			Assert.assertTrue(SNewOrder.coBorrowerInfo1_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactCoBorrowerInfo1().get()), "CoBorrower Info 1 information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getcontactCoBorrowerInfo1().get());
			
			// CoBorrower Info 2 dropdown
			String coBorrowerInfo2Dropdown = new Select(SNewOrder.coBorrowerInfo2_dropdown(driver)).getFirstSelectedOption().getText();
			Assert.assertTrue(coBorrowerInfo2Dropdown.equals(StoredVariables.getcontactCoBorrowerInfo2Dropdown().get()), "CoBorrower Info 2 Dropdown information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getcontactCoBorrowerInfo2Dropdown().get());
			
			// CoBorrower Info 2
			Assert.assertTrue(SNewOrder.coBorrowerInfo2_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactCoBorrowerInfo2().get()), "CoBorrower Info 2 information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getcontactCoBorrowerInfo2().get());
		}
		
		// Click the CoBorrower address button
		if (!StoredVariables.getcontactCoBorrowerAddress().get().equals("")) {
			perform.click(driver, SNewOrder.coBorrowerAddress_btn(driver));
			
			// CoBorrower Address
			Assert.assertTrue(SNewOrder.coBorrowerAddress_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactCoBorrowerAddress().get()), "CoBorrower Address information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getcontactCoBorrowerAddress().get());
			
			// CoBorrower City
			Assert.assertTrue(SNewOrder.coBorrowerCity_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactCoBorrowerCity().get()), "CoBorrower City information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getcontactCoBorrowerCity().get());
			
			// CoBorrower State
			Assert.assertTrue(SNewOrder.coBorrowerState_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactCoBorrowerState().get()), "CoBorrower State information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getcontactCoBorrowerState().get());
			
			// CoBorrower Zip
			Assert.assertTrue(SNewOrder.coBorrowerZip_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactCoBorrowerZip().get()), "CoBorrower Zip information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getcontactCoBorrowerZip().get());
			
			// Click the Cancel button
			perform.click(driver, SNewOrder.coBorrowerCancel_btn(driver));
		}
		
		// Owner
		if (!StoredVariables.getcontactOwner().get().equals("")) {
			Assert.assertTrue(SNewOrder.owner_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactOwner().get()), "Owner information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getcontactOwner().get());
			
			// Owner Info 1 dropdown
			String ownerInfo1Dropdown = new Select(SNewOrder.ownerInfo1_dropdown(driver)).getFirstSelectedOption().getText();
			Assert.assertTrue(ownerInfo1Dropdown.equals(StoredVariables.getcontactOwnerInfo1Dropdown().get()), "Owner Info 1 Dropdown information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getcontactOwnerInfo1Dropdown().get());
			
			// Owner Info 1
			Assert.assertTrue(SNewOrder.ownerInfo1_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactOwnerInfo1().get()), "Owner Info 1 information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getcontactOwnerInfo1().get());
			
			// Owner Info 2 dropdown
			String ownerInfo2Dropdown = new Select(SNewOrder.ownerInfo2_dropdown(driver)).getFirstSelectedOption().getText();
			Assert.assertTrue(ownerInfo2Dropdown.equals(StoredVariables.getcontactOwnerInfo2Dropdown().get()), "Owner Info 2 Dropdown information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getcontactOwnerInfo2Dropdown().get());
			
			// Owner Info 2
			Assert.assertTrue(SNewOrder.ownerInfo2_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactOwnerInfo2().get()), "Owner Info 2 information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getcontactOwnerInfo2().get());
		}
		
		// Occupant
		if (!StoredVariables.getcontactOccupant().get().equals("")) {
			Assert.assertTrue(SNewOrder.occupant_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactOccupant().get()), "Occupant information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getcontactOccupant().get());
			
			// Occupant Info 1 dropdown
			String occupantInfo1Dropdown = new Select(SNewOrder.occupantInfo1_dropdown(driver)).getFirstSelectedOption().getText();
			Assert.assertTrue(occupantInfo1Dropdown.equals(StoredVariables.getcontactOccupantInfo1Dropdown().get()), "Occupant Info 1 Dropdown information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getcontactOccupantInfo1Dropdown().get());
			
			// Occupant Info 1
			Assert.assertTrue(SNewOrder.occupantInfo1_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactOccupantInfo1().get()), "Occupant Info 1 information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getcontactOccupantInfo1().get());
			
			// Occupant Info 2 dropdown
			String occupantInfo2Dropdown = new Select(SNewOrder.occupantInfo2_dropdown(driver)).getFirstSelectedOption().getText();
			Assert.assertTrue(occupantInfo2Dropdown.equals(StoredVariables.getcontactOccupantInfo2Dropdown().get()), "Occupant Info 2 Dropdown information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getcontactOccupantInfo2Dropdown().get());
			
			// Occupant Info 2
			Assert.assertTrue(SNewOrder.occupantInfo2_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactOccupantInfo2().get()), "Occupant Info 2 information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getcontactOccupantInfo2().get());
		}
		
		// Agent
		if (!StoredVariables.getcontactAgent().get().equals("")) {
			Assert.assertTrue(SNewOrder.agent_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactAgent().get()), "Agent information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getcontactAgent().get());
			
			// Agent Info 1 dropdown
			String agentInfo1Dropdown = new Select(SNewOrder.agentInfo1_dropdown(driver)).getFirstSelectedOption().getText();
			Assert.assertTrue(agentInfo1Dropdown.equals(StoredVariables.getcontactAgentInfo1Dropdown().get()), "Agent Info 1 Dropdown information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getcontactAgentInfo1Dropdown().get());
			
			// Agent Info 1
			Assert.assertTrue(SNewOrder.agentInfo1_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactAgentInfo1().get()), "Agent Info 1 information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getcontactAgentInfo1().get());
			
			// Agent Info 2 dropdown
			String agentInfo2Dropdown = new Select(SNewOrder.agentInfo2_dropdown(driver)).getFirstSelectedOption().getText();
			Assert.assertTrue(agentInfo2Dropdown.equals(StoredVariables.getcontactAgentInfo2Dropdown().get()), "Agent Info 2 Dropdown information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getcontactAgentInfo2Dropdown().get());
			
			// Agent Info 2
			Assert.assertTrue(SNewOrder.agentInfo2_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactAgentInfo2().get()), "Agent Info 2 information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getcontactAgentInfo2().get());
		}
		
		// Other
		if (!StoredVariables.getcontactOther().get().equals("")) {
			Assert.assertTrue(SNewOrder.other_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactOther().get()), "Other information was lost on the New Order page after clicking Back from the Confirm Order page. Should be = " + StoredVariables.getcontactOther().get() + "    The on-screen data = " + SNewOrder.other_txtbx(driver).getAttribute("value"));
			
			// Other Info 1 dropdown
			String otherInfo1Dropdown = new Select(SNewOrder.otherInfo1_dropdown(driver)).getFirstSelectedOption().getText();
			Assert.assertTrue(otherInfo1Dropdown.equals(StoredVariables.getcontactOtherInfo1Dropdown().get()), "Other Info 1 Dropdown information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getcontactOtherInfo1Dropdown().get());
			
			// Other Info 1
			Assert.assertTrue(SNewOrder.otherInfo1_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactOtherInfo1().get()), "Other Info 1 information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getcontactOtherInfo1().get());
			
			// Other Info 2 dropdown
			String otherInfo2Dropdown = new Select(SNewOrder.otherInfo2_dropdown(driver)).getFirstSelectedOption().getText();
			Assert.assertTrue(otherInfo2Dropdown.equals(StoredVariables.getcontactOtherInfo2Dropdown().get()), "Other Info 2 Dropdown information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getcontactOtherInfo2Dropdown().get());
			
			// Other Info 2
			Assert.assertTrue(SNewOrder.otherInfo2_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactOtherInfo2().get()), "Other Info 2 information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getcontactOtherInfo2().get());
		}
		
		// Appt. Contact
		if (!StoredVariables.getcontactApptContact().get().equals("")) {
			String apptContactDropdown = new Select(SNewOrder.apptContact_dropdown(driver)).getFirstSelectedOption().getText();
			Assert.assertTrue(apptContactDropdown.equals(StoredVariables.getcontactApptContact().get()), "Appt. Contact information was lost on the New Order page after clicking Back from the Confirm Order page. Should be - " + StoredVariables.getcontactApptContact().get());
		}
		
		/************************************************
		 * Additional Notification Recipients
		 ************************************************/
		// Additional Email
		if (!StoredVariables.getadditionalNotificationRecipientsAdditionalEmails().get().equals("")) {
			Assert.assertTrue(SNewOrder.additionalEmailRecipients_txtbx(driver).getAttribute("value").equals(StoredVariables.getadditionalNotificationRecipientsAdditionalEmails().get()), "Appt. Contact information was lost on the New Order page after clicking Back from the Confirm Order page");
		}
		
		// Attach completed report checkbox
		if (!StoredVariables.getadditionalNotificationRecipientsAttachCompletedReport().get().equals("")) {
			if (StoredVariables.getadditionalNotificationRecipientsAttachCompletedReport().get() == true)
			{
				Assert.assertTrue(SNewOrder.attachCompletedReport_chkbx(driver).isSelected(), "Attach completed report checkbox information was lost on the New Order page after clicking Back from the Confirm Order page");	
			} // end if
		}
		
	} // end verifySecureNewOrderInfo
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Enter borrower identifier into Find textbox</li>
	 * 	<li>Click the Contains radio button</li>
	 * 	<li>Select Borrower in the In Field dropdown</li>
	 * 	<li>Select Placed as All</li>
	 * 	<li>Click the Find magnifying glass</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param search the search
	 * @param field the field
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Find order on Secure
	public void findOrder(RemoteWebDriver driver, String search, String field) throws InterruptedException, IOException
	{
		
		System.out.println("Searching for " + search + " in " + field);

		// Wait for the Find text box
		perform.waitForElementToBeClickable(driver, SOrders.find_txtbx(), "id");
		
		// Enter borrower identifier into Find textbox
		try {
			SOrders.find_txtbx(driver).clear();
		} catch (InvalidElementStateException e) {
			SOrders.find_txtbx(driver).clear();
		} // end try/catch
		perform.type(driver, SOrders.find_txtbx(driver), search);
		
		Thread.sleep(1000);
		
		// Click the Contains radio button
		perform.click(driver, SOrders.contains_radioBtn(driver));
		
		Thread.sleep(1000);
		
		// Select Borrower in the In Field dropdown
		perform.selectDropdownOption(driver, SOrders.inField_dropdown(driver), field);
		
		// Wait for dropdown
		perform.waitForElementToBeClickable(driver, SOrders.placed_dropdown(driver));
		
		// Select Placed as All
		perform.selectDropdownOption(driver, SOrders.placed_dropdown(driver), "All");
		
		// Click the Find magnifying glass
		perform.click(driver, SOrders.find_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		Thread.sleep(2000);
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for the grid to be visible
		perform.waitForElementToBeClickable(driver, SOrders.ordersTable_txt(), "id");
		
		// Add info to ExtentReport
		perform.addInfoToExtentReport(driver, "Search Order", "Search for order " + search);
		
	} // end findOrder
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Open the order</li>
	 * 	<li>Click the order</li>
	 * 	<li>Click View</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param trackingNumber the tracking number
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Open order on Secure
	public void openOrder(RemoteWebDriver driver, String trackingNumber) throws InterruptedException, IOException
	{
		
		System.out.println("Open order " + trackingNumber);
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);

		if (StoredVariables.getmobile().get()==false) {
			// Open the order
			perform.doubleClickInTable(driver, trackingNumber);
		} else {
			// Click the order
			perform.clickInTable_Contains(driver, trackingNumber);
			// Click View
			perform.click(driver, SOrders.view_btn(driver));
		} // end if/else
		
		// Wait for the Set status button to be clickable
		perform.waitForElementToBeClickable(driver, SOrderDetails.setStatus_btn(driver));
		
	} // end openOrder
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Find and open the order</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param user the user
	 * @param password the password
	 * @param trackingNumber the tracking number
	 * @throws Exception the exception
	 */
	// Open order on Secure
	public void loginAndOpenOrderByTrackingNumber(RemoteWebDriver driver, String user, String password, String trackingNumber) throws Exception {
		
		// Login
		login(driver, user, password);
		
		// Find the order
		findAndOpenOrder(driver, trackingNumber);
		
	} // end loginAndOpenOrderByTrackingNumber
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Search for order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param trackingNumber the tracking number
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Find and open order on Secure
	public void findAndOpenOrder(RemoteWebDriver driver, String trackingNumber) throws InterruptedException, IOException
	{
		
		System.out.println("Find and open order " + trackingNumber);

		ExtentTest test = ExtentTestManager.getTest();
		
		// Search for order
		findOrder(driver, trackingNumber, "Tracking number");
		
		// Open the order
		openOrder(driver, trackingNumber);
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Opened order in Secure: " + trackingNumber);
		
	} // end findAndOpenOrder
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Enter borrower identifier into Find textbox</li>
	 * 	<li>Click the Contains radio button</li>
	 * 	<li>Select Borrower in the In Field dropdown</li>
	 * 	<li>Click the Find magnifying glass</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param search the search
	 * @param field the field
	 * @throws InterruptedException the interrupted exception
	 */
	// Find document on Secure
	public void findDocument(RemoteWebDriver driver, String search, String field) throws InterruptedException
	{
		
		System.out.println("Searching for " + search + " in " + field);

		// Wait for the Find text box
		perform.waitForElementToBeClickable(driver, SOrders.find_txtbx(), "id");
		
		// Enter borrower identifier into Find textbox
		perform.type(driver, SOrders.find_txtbx(driver), search);
		
		// Click the Contains radio button
		perform.click(driver, SOrders.contains_radioBtn(driver));
		
		// Select Borrower in the In Field dropdown
		perform.selectDropdownOption(driver, SOrders.inField_dropdown(driver), field);
		
		// Click the Find magnifying glass
		perform.click(driver, SOrders.find_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
	} // end findDocument
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to Fee Panel</li>
	 * 	<li>Click Add</li>
	 * 	<li>Switch to iFrame</li>
	 * 	<li>Enter Company Name</li>
	 * 	<li>Enter Email Address</li>
	 * 	<li>Enter phone number</li>
	 * 	<li>Click Next</li>
	 * 	<li>Set vendor exists boolean</li>
	 * 	<li>Get text from the dialog</li>
	 * 	<li>Check to see if the vendor already exists on the Fee Panel</li>
	 * 	<li>Check if the OK button is visible</li>
	 * 	<li>Verify dialog text</li>
	 * 	<li>Click OK</li>
	 * 	<li>perform.click(driver, SFeePanel.yes_btn(driver));  The Yes button has the same id as the OK button here</li>
	 * 	<li>Switch to iFrame</li>
	 * 	<li>Finish adding the vendor if they did not already exist in the Fee Panel</li>
	 * 	<li>Select the checkbox</li>
	 * 	<li>Click Add</li>
	 * 	<li>Verify AppraiserTest is in the table</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param addVendorBy the add vendor by
	 * @param vendorInfo the vendor info
	 * @param vendorLastName the vendor last name
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */	
	// Add vendor to Fee Panel
	public void addVendorToFeePanel(RemoteWebDriver driver, String addVendorBy, String vendorInfo, String vendorLastName) throws InterruptedException, IOException
	{
		
		System.out.println("Add vendor to Fee Panel");
		
		ExtentTest test = ExtentTestManager.getTest();
		
		// Go to Fee Panel
		goToFeePanel(driver);

		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for Add
		perform.waitForElementToBeClickable(driver, SFeePanel.add_btn(), "cssSelector");
		
		// Click Add
		perform.click(driver, SFeePanel.add_btn(driver));
		
		// Switch to iFrame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "Build/Single/SingleInfo.aspx", By.id(SFeePanel.phone_txtbx()));
		
		// Wait for phone number textbox
		perform.waitForElementToBeClickable(driver, SFeePanel.phone_txtbx(), "id");
		
		// Enter Company Name
		if (addVendorBy.toLowerCase().contains("company"))
		{
			perform.type(driver, SFeePanel.companyName_txtbx(driver), vendorInfo);
		}
		
		// Enter Email Address
		if (addVendorBy.toLowerCase().contains("email") || addVendorBy.toLowerCase().contains("e-mail"))
		{
			perform.type(driver, SFeePanel.emailAddress_txtbx(driver), vendorInfo);
		}
		
		// Enter phone number
		if (addVendorBy.toLowerCase().contains("phone"))
		{
			perform.type(driver, SFeePanel.phone_txtbx(driver), vendorInfo);
		}
		
		// Click Next
		perform.click(driver, SFeePanel.next_btn(driver));
		
		Thread.sleep(8000);
		
		// Switch out of iFrames
		driver.switchTo().defaultContent();
		
		// Set vendor exists boolean
		boolean vendorExists = false;
		
		// Get text from the dialog
		String text = SFeePanel.vendorExistsDialog_txt(driver).getText();
		
		// Check to see if the vendor already exists on the Fee Panel
		if (text.contains("matches a vendor")) {
			// Check if the OK button is visible
			SFeePanel.yes_btn(driver).isDisplayed();
			
			// Verify dialog text
			Assert.assertTrue(SFeePanel.vendorExistsDialog_txt(driver).getText().contains("The information you entered matches a vendor already on your fee panel or ineligible list."), "The Vendor exists dialog text is incorrect");
			
			// Click OK
			perform.click(driver, SFeePanel.yes_btn(driver)); // The Yes button has the same id as the OK button here
			
			vendorExists = true;
			System.out.println("vendorExists = " + vendorExists);
		} else {
			// Switch to iFrame
			perform.waitForiFrameSrcAndSwitchToIt(driver, "Build/Single/SingleChoose.aspx", By.id(SFeePanel.back_btn()));
			System.out.println("vendorExists = " + vendorExists);
		} // end if/else
		
		// Finish adding the vendor if they did not already exist in the Fee Panel
		if (vendorExists==false)
		{
			
			// Wait for the Back button
			try {
				perform.waitForElementToBeClickable(driver, SFeePanel.back_btn(driver));	
			} catch (Exception e) {
				perform.waitForElementToBeClickable(driver, SFeePanel.back_btn(driver));
			} // end try/catch
			
			// Select the checkbox
			perform.click(driver, SFeePanel.vendor_chkbx(driver));
			
			// Click Add
			perform.click(driver, SFeePanel.addVendor_btn(driver));
			
			// Get out of iFrame
			driver.switchTo().defaultContent();
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			// Wait for Fee Panel to be clickable
			perform.waitForElementToBeClickable(driver, SOrders.feePanel_btn(), "cssSelector");
			
			// Verify AppraiserTest is in the table
			Assert.assertTrue(SFeePanel.feePanelTable_txt(driver).getText().contains(vendorLastName), vendorLastName + " was not added to the Fee Panel");
		
		} // end if vendor does not exist
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Added vendor to Fee Panel: " + vendorLastName);
		
	} // end addVendorToFeePanel
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click Vendor Profile button</li>
	 * 	<li>Switch to the new iFrame</li>
	 * 	<li>Get Profile text</li>
	 * 	<li>Reopen the Vendor Profile if the info is blank</li>
	 * 	<li>Click Cancel</li>
	 * 	<li>Switch out of iframe</li>
	 * 	<li>Try switching into an iFrame</li>
	 * 	<li>Get inside the vendor assignment frame</li>
	 * 	<li>Click Vendor Profile button</li>
	 * 	<li>Switch to the new iFrame</li>
	 * 	<li>Get Profile text</li>
	 * 	<li>} end while</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param vendorProfileButton the vendor profile button
	 * @param expectedProfileText the expected profile text
	 * @throws InterruptedException the interrupted exception
	 */
	// View vendor profile
	public void viewVendorProfile (RemoteWebDriver driver, WebElement vendorProfileButton, String expectedProfileText) throws InterruptedException {
	
		ExtentTest test = ExtentTestManager.getTest();
		
		// Click Vendor Profile button
		perform.click(driver, vendorProfileButton);
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Switch to the new iFrame
		driver.switchTo().defaultContent();
		perform.waitForiFrameSrcAndSwitchToIt(driver, "/Common/VendorProfile/Profile.aspx", By.id(SProfile.products_tab()));
		
		// Wait for the Products tab
		perform.waitForElementToBeVisible(driver, SProfile.products_tab(), "id");
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Get Profile text
		String profileText = SProfile.profile_txt(driver).getText();
		
		// Reopen the Vendor Profile if the info is blank
		int tries = 1;
		while (!profileText.contains(expectedProfileText) && tries < 5) {
			
			// Click Cancel
			perform.click(driver, SProfile.cancel_btn(driver));
			
			// Switch out of iframe
			driver.switchTo().defaultContent();
			
			// Try switching into an iFrame
			boolean newIframeEntered = false;
			if (perform.checkIfIframeExists(driver, "/Admin/NewOrder/AutoAssignmentApproval.aspx")==true) {
				newIframeEntered=true;
				// Get inside the vendor assignment frame
				driver.switchTo().frame(1);
			} // end if
			
			// Wait for Vendor Profile button
			perform.waitForElementToBeClickable(driver, vendorProfileButton);
			
			// Click Vendor Profile button
			perform.click(driver, vendorProfileButton);
			
			if (newIframeEntered==true) {
				driver.switchTo().defaultContent();
			} // end if
			
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			// Switch to the new iFrame
			perform.waitForiFrameSrcAndSwitchToIt(driver, "/Common/VendorProfile/Profile.aspx", By.id(SProfile.products_tab()));
			
			// Wait for the Products tab
			perform.waitForElementToBeVisible(driver, SProfile.products_tab(), "id");
			
			// Wait for busy to be hidden
			perform.waitForBusyToBeHidden(driver);
			
			// Get Profile text
			profileText = SProfile.profile_txt(driver).getText();
			
			tries++;
			
		}// end while
		
		System.out.println("profileText = " + profileText);
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "View vendor profile");
		
	} // end viewVendorProfile
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get the Vendor Profile button</li>
	 *  <li>Call viewVendorProfile</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param name the name of the vendor whose profile you want to open
	 * @throws InterruptedException the interrupted exception
	 */
	// View vendor profile
	public void viewVendorProfileByCompanyName(RemoteWebDriver driver, String name) throws InterruptedException {

		// Get vendor profile button
		WebElement vendorProfileButton = driver.findElement(By.xpath("//td[contains(text(), '" + name + "')]/preceding-sibling::td[1]"));
		
		// View the vendor profile
		viewVendorProfile(driver, vendorProfileButton, name);
		
	} // end viewVendorProfileByName
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Remove vendor from fee panel</li>
	 * 	<li>Remove vendors</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws InterruptedException the exception
	 */
	// Remove All Selected vendors from vendor selection
	public void removeAllSelectedVendorsFromVendorSelection (RemoteWebDriver driver) throws InterruptedException {
		
		// Remove vendor from fee panel
		List<WebElement> remove = driver.findElements(By.cssSelector("img[src='/images/removelogo-O.png']"));
		
		// Remove vendors
		for (WebElement el : remove) {
			perform.click(driver, el);
		} // end for
		
	} // end removeAllSelectedVendorsFromVendorSelection
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Select the AppraiserTest</li>
	 * 	<li>Click Remove</li>
	 * 	<li>Verify dialog text</li>
	 * 	<li>Click Yes</li>
	 * 	<li>Verify AppraiserTest is not in the table</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param vendorLastName the vendor last name
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Remove vendor from Fee Panel
	public void removeVendorFromFeePanel(RemoteWebDriver driver, String vendorLastName) throws InterruptedException, IOException
	{
		
		System.out.println("Remove vendor from Fee Panel");
		
		ExtentTest test = ExtentTestManager.getTest();

		// Wait for fee panel table to load
		perform.waitForText(driver, SFeePanel.feePanelTable_txt(driver), "AppraiserTest");
		
		Thread.sleep(2000);
		
		// Select the AppraiserTest
		perform.clickInTable_Equals(driver, "AppraiserTest");
		
		// Wait for Move to fee panel button
		perform.waitForElementToBeClickable(driver, SFeePanel.remove_btn(), "cssSelector");
		
		// Click Remove
		perform.click(driver, SFeePanel.remove_btn(driver));
		
		// Wait for the Yes button
		perform.waitForElementToBeClickable(driver, SFeePanel.yes_btn(), "id");
		
		// Verify dialog text
		Assert.assertTrue(SFeePanel.dialog_txt(driver).getText().contains("Are you sure you want to remove the selected vendor(s)?"), "The Remove vendor(s) dialog text is incorrect");
		
		// Click Yes
		perform.click(driver, SFeePanel.yes_btn(driver));
		
		// Wait for the overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		Thread.sleep(1000);
		
		// Verify AppraiserTest is not in the table
		Assert.assertTrue(!SFeePanel.feePanelTable_txt(driver).getText().contains(vendorLastName), vendorLastName + " was not removed from the Fee Panel");
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Removed " + vendorLastName + " from the vendor profile");
		
	} // end removeVendorFromFeePanel
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Select the AppraiserTest</li>
	 * 	<li>Click Remove</li>
	 * 	<li>Verify dialog text</li>
	 * 	<li>Click Yes</li>
	 * 	<li>Verify AppraiserTest is not in the table</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param vendorLastName the vendor last name
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Remove vendor from Fee Panel
	public void removeIneligibleVendorFromFeePanel(RemoteWebDriver driver, String vendorLastName) throws InterruptedException, IOException
	{
		
		System.out.println("Remove inelgible vendor from Fee Panel");
		
		ExtentTest test = ExtentTestManager.getTest();

		// Wait for fee panel table to load
		perform.waitForText(driver, SFeePanel.feePanelTable_txt(driver), "AppraiserTest");
		
		Thread.sleep(2000);
		
		// Select the AppraiserTest
		perform.clickInTable_Equals(driver, "AppraiserTest");
		
		// Wait for Move to fee panel button
		perform.waitForElementToBeClickable(driver, SFeePanel.remove_btn(), "cssSelector");
		
		// Click Remove
		perform.click(driver, SFeePanel.remove_btn(driver));
		
		// Wait for the Yes button
		perform.waitForElementToBeClickable(driver, SFeePanel.yes_btn(), "id");
		
		// Verify dialog text
		Assert.assertTrue(SFeePanel.dialog_txt(driver).getText().contains("Remove the selected vendors from the ineligible list and clear them to receive orders?"), "The Remove vendor(s) dialog text is incorrect");
		
		// Click Yes
		perform.click(driver, SFeePanel.yes_btn(driver));
		
		// Wait for the overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		Thread.sleep(1000);
		
		// Verify AppraiserTest is not in the table
		Assert.assertTrue(!SFeePanel.feePanelTable_txt(driver).getText().contains(vendorLastName), vendorLastName + " was not removed from the Fee Panel");
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Removed " + vendorLastName + " from the vendor profile");
		
	} // end removeIneligibleVendorFromFeePanel
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Select the AppraiserTest</li>
	 * 	<li>Click Mark Ineligible</li>
	 * 	<li>Verify dialog text</li>
	 * 	<li>Click Yes</li>
	 * 	<li>Verify AppraiserTest is not in the table</li>
	 * 	<li>Click Ineligible vendors tab</li>
	 * 	<li>Verify AppraiserTest is in the table</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param vendorName the vendor name
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Mark Vendor Ineligible in the Fee Panel
	public void markVendorIneligible(RemoteWebDriver driver, String vendorName) throws InterruptedException, IOException
	{
		
		System.out.println("Mark vendor ineligible - " + vendorName);
		
		ExtentTest test = ExtentTestManager.getTest();
		
		// Wait for table
		perform.waitForElementToBeClickable(driver, SFeePanel.feePanelTable_txt(), "id");
		
		Thread.sleep(5000);
		
		// Select the AppraiserTest
		perform.clickInTable_Equals(driver, "AppraiserTest");
		
		// Wait for Move to fee panel button
		perform.waitForElementToBeClickable(driver, SFeePanel.markIneligible_btn(), "cssSelector");
		
		// Click Mark Ineligible
		perform.click(driver, SFeePanel.markIneligible_btn(driver));
		
		// Wait for the Yes button
		perform.waitForElementToBeClickable(driver, SFeePanel.yes_btn(), "id");
		
		// Verify dialog text
		Assert.assertTrue(SFeePanel.dialog_txt(driver).getText().contains("Fee panel vendors will be marked ineligible for receiving orders and removed from your fee panel and all order groups."), "The Ineligible vendors dialog text is incorrect");
		Assert.assertTrue(SFeePanel.dialog_txt(driver).getText().contains("Vendors can be re-activated from the Ineligible vendors list. Previous order group settings are not remembered."), "The Ineligible vendors dialog text is incorrect");
		Assert.assertTrue(SFeePanel.dialog_txt(driver).getText().contains("Do you wish to continue?"), "The Ineligible vendors dialog text is incorrect");
		
		// Click Yes
		perform.click(driver, SFeePanel.yes_btn(driver));
		
		Thread.sleep(4000);
		
		// Wait for the overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Verify AppraiserTest is not in the table
		Assert.assertTrue(!SFeePanel.feePanelTable_txt(driver).getText().contains(vendorName), vendorName + " was not removed from the Fee Panel");
		
		// Click Ineligible vendors tab
		perform.click(driver, SFeePanel.ineligibleVendors_tab(driver));
		
		// Wait for Appraiser/Agent fee panel tab
		perform.waitForElementToBeClickable(driver, SFeePanel.appraiserFeePanel_tab(), "id");
		
		// Verify AppraiserTest is in the table
		Assert.assertTrue(SFeePanel.feePanelTable_txt(driver).getText().contains(vendorName), vendorName + " is not in the Ineligible Vendors list");
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Marked " + vendorName + " as an Ineliglbe Vendor");
		
	} // end markVendorIneligible
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>If browser is Firefox, skip this method</li>
	 * 	<li>Log a skip in the extent report</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Search for order</li>
	 * 	<li>Open order</li>
	 * 	<li>Get the Window Handle before the new window opens</li>
	 * 	<li>Click View XSite Order link</li>
	 * 	<li>Switch to the new window</li>
	 * 	<li>Get inside the contents frame for the Cancel button</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param user the user
	 * @param password the password
	 * @param trackingNumber the tracking number
	 * @throws Exception the exception
	 */
	// View XSite Order via Secure
	public void viewXSiteOrderFromSecure(RemoteWebDriver driver, String user, String password, String trackingNumber) throws Exception
	{
		
		System.out.println("View the XSite order by going through Secure");
		
		ExtentTest test = ExtentTestManager.getTest();
		
		// If browser is Firefox, skip this method
		if (StoredVariables.getbrowser().get().equals("Firefox"))
		{
			System.out.println("Skipped this method becuase the XSite functionality does not work in Firefox");
			// Log a skip in the extent report
			test.log(LogStatus.SKIP, "<span class='label info'>SKIPPED</span>", "<pre>Skipped this method becuase the XSite functionality does not work in Firefox</pre>");
		} // end if
		else
		{
			
			// Log in to Secure
			login(driver, user, password);
			
			// Search for order
			findOrder(driver, trackingNumber, "Tracking number");
			
			// Open order
			openOrder(driver, trackingNumber);
			
			// Wait for link
			perform.waitForElementToBeClickable(driver, SOrderDetails.viewXSiteOrder_lnk(driver));
			
			// Get the Window Handle before the new window opens
			StoredVariables.getwinHandleBefore().set(driver.getWindowHandle());
			System.out.println("winHandleBefore = " + StoredVariables.getwinHandleBefore().get());
			
			// Click View XSite Order link
			perform.click(driver, SOrderDetails.viewXSiteOrder_lnk(driver));
			perform.sleep(driver, 3);
			driver.switchTo().window(StoredVariables.getwinHandleBefore().get());
			perform.click(driver, SOrderDetails.viewXSiteOrder_lnk(driver));
			
			// Wait for multiple windows to be opened
			perform.waitForMultipleWindowsToBeOpened(driver);
			
			// Switch to the new window
			perform.switchToXSiteWindowByTitle(driver, "Business Management");
			
			// Get inside the contents frame for the Cancel button
			perform.switchToiFrameByID(driver, "Main");
			
			// Wait for text to display
			try {
				perform.waitForText(driver, driver.findElement(By.id("divMain")), "Order Details");
			} catch (Exception e) {
				driver.switchTo().defaultContent();
				perform.switchToiFrameByID(driver, "Main");
				perform.waitForText(driver, driver.findElement(By.id("divMain")), "Order Details");
			} // end try/catch
			
			Thread.sleep(4000);
			
		} // end else
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Opened the XSite order from Secure");
		
	} // end viewXSiteOrderFromSecure
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get the Window Handle before the new window opens</li>
	 * 	<li>Open the XSite order</li>
	 * 	<li>Switch to the new window</li>
	 * 	<li>Get the Window Handle before the new window opens</li>
	 * 	<li>Get inside the contents frame for the Cancel button</li>
	 * 	<li>Set window handles</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// View XSite Order via Secure
	public void openXSiteOrder(RemoteWebDriver driver) throws InterruptedException, IOException
	{
		
		System.out.println("View the XSite order");
		
		ExtentTest test = ExtentTestManager.getTest();
		
		// Get the Window Handle before the new window opens
		StoredVariables.getwinHandleBefore().set(driver.getWindowHandle());
		System.out.println("winHandleBefore = " + StoredVariables.getwinHandleBefore().get());
		
		// Wait for link to be clickable
		perform.waitForElementToBeClickable(driver, SOrderDetails.viewXSiteOrder_lnk(), "id");
		
		// Open the XSite order
		perform.click(driver, SOrderDetails.viewXSiteOrder_lnk(driver));
		
		// Switch to the new window
		perform.switchToXSiteWindowByTitle(driver, "Business Management");
		
		// Get the Window Handle before the new window opens
		StoredVariables.getnewWinHandle().set(driver.getWindowHandle());
		System.out.println("newWinHandle = " + StoredVariables.getnewWinHandle().get());
		
		// Get inside the contents frame for the Cancel button
		driver.switchTo().window(StoredVariables.getnewWinHandle().get());
		driver.switchTo().frame("Main");
		
		// Set window handles
		StoredVariables.getwin1().set(StoredVariables.getwinHandleBefore().get());
		StoredVariables.getwin2().set(StoredVariables.getnewWinHandle().get());
		
		Thread.sleep(4000);
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Opened the XSite order from Secure");
		
	} // end openXSiteOrder
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get outside frames</li>
	 * 	<li>Get inside the attach document frame</li>
	 * 	<li>Click Close</li>
	 * 	<li>Get outside frames</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws InterruptedException the interrupted exception
	 */
	// Check for Related Orders dialog and close it
	public void checkForRelatedOrdersDialog(RemoteWebDriver driver) throws InterruptedException
	{
		
		System.out.println("Check for Related Orders dialog");
		
		// Wait for the page to load
		perform.waitForPageToLoad(driver);
		
		// Wait for the Next button to be visible
		perform.waitForElementToBeVisible(driver, SVendorSelection.nextTop_btn(driver));
		
		// Check if overlay is visible
		if (!Overlay.overlayDisabled(driver).getAttribute("style").contains("hidden"))
		{
			
			// Get outside frames
			driver.switchTo().defaultContent();
			
			// Get inside the attach document frame
			try {
				
				perform.waitForiFrameSrcAndSwitchToIt(driver, "/Admin/Neworder/RelatedAppraisals.aspx", By.id(SVendorSelection.relatedOrdersClose_btn()));
			
				// Click Close
				perform.click(driver, SVendorSelection.relatedOrdersClose_btn(driver));
				
				// Get outside frames
				driver.switchTo().defaultContent();
				
			} catch (Exception e) {}
			
		} // end if related orders popup displays
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
	} // end checkForRelatedOrdersDialog
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click Set status</li>
	 * 	<li>Click Submit to UCDP</li>
	 * 	<li>Get outside frames</li>
	 * 	<li>Select GSE dropdown</li>
	 * 	<li>Select a la mode from Business unit dropdown</li>
	 * 	<li>Set the loan number</li>
	 * 	<li>Verify unit number is correct</li>
	 * 	<li>Assert.assertTrue(SSubmitToUCDP.loanNumber_txtbx(driver).getAttribute("value").equals(loanNumber), "The Loan Number is not correct");</li>
	 * 	<li>Enter internal notes</li>
	 * 	<li>Verify Update status on VMP XSite is checked</li>
	 * 	<li>Click Send</li>
	 * 	<li>Verify dialog text</li>
	 * 	<li>Click OK button</li>
	 * 	<li>Get outside frames</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify history</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param GSE the gse
	 * @param businessUnit the business unit
	 * @param loanNumber the loan number
	 * @param internalNotes the internal notes
	 * @param updateVMPXSite the update VMPX site
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Submit to UCDP
	public void submitToUCDP(RemoteWebDriver driver, String GSE, String businessUnit, String loanNumber, String internalNotes, boolean updateVMPXSite) throws InterruptedException, IOException
	{
		
		System.out.println("Submit to UCDP");
		
		ExtentTest test = ExtentTestManager.getTest();
		
		// Click Set status
		perform.click(driver, SOrderDetails.setStatus_btn(driver));
		
		// Wait for Submit to UCDP button
		perform.waitForElementToBeClickable(driver, SOrderDetails.submitToUCDP_btn(), "cssSelector");
		
		// Click Submit to UCDP
		perform.clickInTable_Contains(driver, "Submit to UCDP");
		
		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		// Get outside frames
		perform.waitForiFrameSrcAndSwitchToIt(driver, "UCDPSubmit.aspx", By.id(SSubmitToUCDP.internalNotes_txtbx()));
		
		// Wait for Internal notes to be clickable
		perform.waitForElementToBeClickable(driver, SSubmitToUCDP.internalNotes_txtbx(), "id");
		
		// Wait for Select GSE dropdown
		perform.waitForElementToBeClickable(driver, SSubmitToUCDP.selectGSE_dropdown(), "id");
		
		// Select GSE dropdown
		perform.selectDropdownOption(driver, SSubmitToUCDP.selectGSE_dropdown(driver), GSE);
		
		// Select a la mode from Business unit dropdown
		if (!businessUnit.isEmpty()) {
			perform.selectDropdownOption(driver, SSubmitToUCDP.businessUnit_dropdown(driver), businessUnit);
		} // end if
		
		// Set the loan number
		if (!loanNumber.isEmpty()) {
			perform.type(driver, SSubmitToUCDP.loanNumber_txtbx(driver), loanNumber);
		} // end if
		
		// Verify unit number is correct
//		Assert.assertTrue(SSubmitToUCDP.loanNumber_txtbx(driver).getAttribute("value").equals(loanNumber), "The Loan Number is not correct");
		
		// Enter internal notes
		perform.type(driver, SSubmitToUCDP.internalNotes_txtbx(driver), internalNotes);
		
		// Verify Update status on VMP XSite is checked
		if (updateVMPXSite==true) {
			if (!SSubmitToUCDP.updateStatusOnVMPXSite_chkbx(driver).isSelected())
			{
				perform.click(driver, SSubmitToUCDP.updateStatusOnVMPXSite_chkbx(driver));
			}
		} // end if updateVMPXSite
		
		// Click Send
		perform.click(driver, SSubmitToUCDP.send_btn(driver));
		
		// Wait for busy to be hidden
		try {
			perform.waitForBusyToBeHidden(driver);
		} catch (Exception e) {}
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for UCDP submission complete text
		perform.waitForText(driver, SSubmitToUCDP.ucdpSubmissionComplete_txt(driver), "UCDP submission complete");

		// Verify dialog text
		String text;
		try {
			text = SSubmitToUCDP.ucdpSubmissionComplete_txt(driver).getText();
		} catch (Exception e) {
			text = SSubmitToUCDP.ucdpSubmissionComplete_txt(driver).getText();
		} // end try/catch
		Assert.assertTrue(text.contains("UCDP submission complete"), "The UCDP submission complete dialog text is incorrect. Dialog = " + text);
		Assert.assertTrue(text.contains("Your report has been successfully submitted to UCDP and the Doc File ID has been added to order details. You should receive the status of the appraisal shortly. If you haven't received a response with your Summary Submission Report in the next 24 hours, please contact Client Relations at 1-800-900-4954"), "The UCDP submission complete dialog text is incorrect. Dialog = " + text);
		
		// Click OK button
		perform.click(driver, SSubmitToUCDP.ok_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Get outside frames
		driver.switchTo().defaultContent();
		
		// Wait for history to update
		waitForHistoryTextToUpdate(driver, "UCDP Document File ID Updated by Client");
		
		// Get history text
		String history = SOrderDetails.history_txt(driver).getText();
		
		// Verify history
		Assert.assertTrue(history.contains("UCDP Document File ID Updated by Client"), "UCDP Document File ID Updated by Client is missing from the order information. History = " + history);
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Submitted the order to UCDP");
		
	} // end submitToUCDP
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click Set status button</li>
	 * 	<li>Click Request Revision</li>
	 * 	<li>Enter notes</li>
	 * 	<li>Click OK</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify history</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param notes the notes
	 * @throws InterruptedException the interrupted exception
	 */
	// Request Revision
	public void requestRevision(RemoteWebDriver driver, String notes) throws InterruptedException
	{

		ExtentTest test = ExtentTestManager.getTest();
		
		// Click Set status button
		perform.click(driver, SOrderDetails.setStatus_btn(driver));

		// Wait for Request Revision
		perform.waitForElementToBeClickable(driver, SOrderDetails.requestRevision_btn(), "cssSelector");
		
		// Click Request Revision
		perform.click(driver, SOrderDetails.requestRevision_btn(driver));
		
		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SSetOrderStatus.ok_btn(), "id");
		
		// Enter notes
		perform.type(driver, SSetOrderStatus.notes_txtbx(driver), notes);
		
		// Click OK
		perform.click(driver, SSetOrderStatus.ok_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Get history text
		String history = SOrderDetails.history_txt(driver).getText();
		
		// Verify history
		Assert.assertTrue(history.contains("Revision Needed by Client"), "Revision Needed by Client is missing from the order information");
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Requested a revision");
		
	} // end requestRevision
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Find and open order</li>
	 * 	<li>Assign the order to an appraiser</li>
	 * 	<li>Confirm Order Details</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param secureUsername the secure username
	 * @param securePassword the secure password
	 * @param loanID the loan ID
	 * @param vendorUserLastName the vendor user last name
	 * @throws Exception the exception
	 */
	// Login and assign vendor to order
	public void loginAndAssignOrderToAppraiser(RemoteWebDriver driver, String secureUsername, String securePassword, String loanID, String vendorUserLastName) throws Exception
	{
		
		// Login to Secure
		login(driver, secureUsername, securePassword);
		
		// Search for the order
		String trackingNumber = db.getTrackingNumber(driver, loanID);
		
		// Find and open order
		findAndOpenOrder(driver, trackingNumber);
		
		// Assign a vendor
		assignVendor(driver, vendorUserLastName);
		
		// Confirm Order Details
		confirmOrderDetails(driver, "");
		
	} // end loginAndAssignOrderToAppraiser
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Find and open order</li>
	 * 	<li>Assign the order to an appraiser</li>
	 * 	<li>Confirm Order Details</li>
	 * </ul>.
	 *
	 * @param driver the driver
	 * @param secureUsername the secure username
	 * @param securePassword the secure password
	 * @param trackingNumber the tracking number
	 * @param vendorUserLastName the vendor user last name
	 * @throws Exception the exception
	 */
	// Login and assign vendor to order
	public void loginAndAssignOrderToAppraiserWithTrackingNumber(RemoteWebDriver driver, String secureUsername, String securePassword, String trackingNumber, String vendorUserLastName) throws Exception
	{
		
		// Login to Secure
		login(driver, secureUsername, securePassword);
		
		// Find and open order
		findAndOpenOrder(driver, trackingNumber);
		
		// Assign a vendor
		assignVendor(driver, vendorUserLastName);
		
		// Confirm Order Details
		confirmOrderDetails(driver, "");
		
	} // end loginAndAssignOrderToAppraiserWithTrackingNumber
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Find and open order</li>
	 * 	<li>Assign the order to an AMC</li>
	 * 	<li>Confirm Order Details</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param secureUsername the secure username
	 * @param securePassword the secure password
	 * @param loanID the loan ID
	 * @param userAMC the AMC to be assigned
	 * @throws Exception the exception
	 */
	// Login and assign vendor to order
	public void loginAndAssignOrderToAMC(RemoteWebDriver driver, String secureUsername, String securePassword, String loanID, String userAMC) throws Exception
	{
		
		// Login to Secure
		login(driver, secureUsername, securePassword);
		
		// Search for the order
		String trackingNumber = db.getTrackingNumber(driver, loanID);
		
		// Find and open order
		findAndOpenOrder(driver, trackingNumber);
		
		// Assign a vendor
		assignToAMC(driver, userAMC);
		
		// Confirm Order Details
		confirmOrderDetails(driver, "");
		
	} // end loginAndAssignOrderToAMC
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click Assign</li>
	 * 	<li>Select vendor</li>
	 * 	<li>Confirm order screen loads</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param loanID the loan ID
	 * @return the string
	 * @throws Exception the exception
	 */
	// Assign an order with automatic vendor selection settings on
	public  String assignAutomaticVendorSelection(RemoteWebDriver driver, String loanID) throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		
		// Go to orders
		goToOrders(driver);
		
		// Search for the order
		String trackingNumber = db.getTrackingNumber(driver, loanID);
		findOrder(driver, trackingNumber, "Tracking number");
		
		// Open the order
		openOrder(driver, trackingNumber);
		
		// Click Assign
		perform.click(driver, SOrderDetails.assign_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Switch iFrame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "/Admin/NewOrder/AutoAssignmentApproval.aspx", By.id(SVendorAssignment.approve_btn()));
		
		// Wait for Approve button
		perform.waitForElementToBeClickable(driver, SVendorAssignment.approve_btn(), "id");
		
		// Click Approve
		perform.click(driver, SVendorAssignment.approve_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Switch out of frame
		driver.switchTo().defaultContent();
		
		// Wait for I have read checkbox
		perform.waitForElementToBeClickable(driver, SConfirmOrder.readVendorsFeeNotes_chkbx(), "id");
		
		// Check I have read and understand checkbox
		perform.checkCheckbox(driver, SConfirmOrder.readVendorsFeeNotes_chkbx(driver));

		// Click Next
		perform.click(driver, SConfirmOrder.finishBottom_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Get Vendor the order is assigned to
		String vendorLastName = db.getVendorLastNameFromLoanID(driver, StoredVariables.getloanID().get());
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Assigned order to vendor: " + vendorLastName);
		
		return vendorLastName;
		
	} // end assignAutomaticVendorSelection
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Assign an order with automatic vendor selection settings on</li>
	 * 	<li>Go to orders</li>
	 * 	<li>Search for the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Click Assign</li>
	 * 	<li>Switch iFrame</li>
	 * 	<li>Click Approve</li>
	 * 	<li>Switch out of frame</li>
	 * 	<li>Check I have read and understand checkbox</li>
	 * 	<li>Click Next</li>
	 * 	<li>Get Vendor the order is assigned to</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param vendorUserLastName the vendor user last name
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Assign vendor to order
	public void assignVendor(RemoteWebDriver driver, String vendorUserLastName) throws InterruptedException, IOException
	{
		
		ExtentTest test = ExtentTestManager.getTest();
		
		// Wait for Assign button
		perform.waitForElementToBeClickable(driver, SOrderDetails.assign_btn(), "id");
		
		// Click Assign
		perform.click(driver, SOrderDetails.assign_btn(driver));
		
		// Select vendor
		selectVendor(driver, vendorUserLastName);
		
		// Confirm order screen loads
		Assert.assertTrue(driver.getCurrentUrl().contains("ConfirmOrder"), "Confirm Order page did not load");
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Assigned Vendor", "Assigned order to vendor: " + vendorUserLastName);
		
	} // assignVendor
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click the AMC/Firm radio button</li>
	 * 	<li>Assign the order to the AMC</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param userAMC the AMC user
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Assign vendor to order
	public void assignToAMC(RemoteWebDriver driver, String userAMC) throws InterruptedException, IOException {
		
		// Click the AMC/Firm radio button
		perform.click(driver,SOrderDetails.amcFirm_radiobtn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Assign the order to the AMC
		secure.assignVendor(driver, userAMC);
		
	} // assignToAMC
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Verify the 'I have read and understand the vendor's fee notes' is unchecked</li>
	 * 	<li>Change payment method to check</li>
	 * 	<li>Click Finish</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param paymentMethod the payment method
	 * @throws InterruptedException the interrupted exception
	 */
	// Confirm order details page
	public void confirmOrderDetails(RemoteWebDriver driver, String paymentMethod) throws InterruptedException {
		
		// Wait for Next button
		perform.waitForElementToBeClickable(driver, SConfirmOrder.nextTop_btn(driver));
		
		// Verify the 'I have read and understand the vendor's fee notes' is unchecked
		int readVendorsFeeNotes = driver.findElements(By.id(SConfirmOrder.readVendorsFeeNotes_chkbx())).size();
		if (readVendorsFeeNotes > 0) {
			perform.checkCheckbox(driver, SConfirmOrder.readVendorsFeeNotes_chkbx(driver));
		} // end if
		
		// Change payment method to check
		if (!paymentMethod.isEmpty()) {
			perform.selectDropdownOption(driver, SConfirmOrder.paymentMethod_dropdown(driver), "Check");
		} // end payment method
		
		// Click Finish
		perform.click(driver, SConfirmOrder.finishBottom_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
	} // end confirmOrderDetails
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click Fee Panel Tab button</li>
	 * 	<li>Verify url contains VendorSelect</li>
	 * 	<li>Select vendor</li>
	 * 	<li>Click Next</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param vendorName the vendor name
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Select vendor to order
	public void selectVendor(RemoteWebDriver driver, String vendorName) throws InterruptedException, IOException
	{
		
		ExtentTest test = ExtentTestManager.getTest();
		
		Thread.sleep(2000);
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Close Related Orders popup
		checkForRelatedOrdersDialog(driver);
		
		// Make sure you're on the Fee Panel tab
		if (!SVendorSelection.feePanelTab_tab(driver).getAttribute("class").contains("Selected")) {
			perform.click(driver, SVendorSelection.feePanelTab_tab(driver));	
		} // end if
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Verify url contains VendorSelect
		Assert.assertTrue(driver.getCurrentUrl().contains("VendorSelect"), "The url does not contain VendorSelect");
		
		// Select vendor
		perform.clickInTable_Contains(driver, vendorName);
		
		perform.sleep(driver, 2);
		
		// Verify vendor is selected
		boolean gotChecked = false;
		List<WebElement> selection = driver.findElements(By.cssSelector("#tblFeePanel > tbody > tr > td:nth-child(1)"));
		for (WebElement el : selection) {
			WebElement checkmark = el.findElement(By.cssSelector("img"));
			String selected = checkmark.getAttribute("src");
			System.out.println("selected = " + selected);
			if (selected.contains("Small-Checked")) {
				gotChecked = true;
			} // end if
		} // end for
		
		int a = 1;
		while (gotChecked==false && a <= 10) {
			
			// Select vendor
			perform.clickInTable_Contains(driver, vendorName);
			
			perform.sleep(driver, 2);
			
			selection = driver.findElements(By.cssSelector("#tblFeePanel > tbody > tr > td:nth-child(1)"));
			for (WebElement el : selection) {
				WebElement checkmark = el.findElement(By.cssSelector("img"));
				String selected = checkmark.getAttribute("src");
				if (selected.contains("Small-Checked")) {
					gotChecked = true;
				} // end if
			} // end for
			
			a++;
			
		} // end while
		
		// Click Next
		perform.click(driver, SVendorSelection.nextTop_btn(driver));
		
		// Wait for Finish button
		perform.waitForElementToBeClickable(driver, SConfirmOrder.finishTop_btn(), "id");
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Selected the vendor: " + vendorName);
		
	} // end selectVendor
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click Search Tab button</li>
	 * 	<li>Enter Last Name</li>
	 * 	<li>Click Search</li>
	 * 	<li>Click off error message if exists</li>
	 * 	<li>Click OK</li>
	 * 	<li>Select vendor</li>
	 * 	<li>Click Next</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param vendorLastName the vendor last name
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Select vendor to order search by last name
	public void selectVendorSearchByLastName(RemoteWebDriver driver, String vendorLastName) throws InterruptedException, IOException
	{
		
		ExtentTest test = ExtentTestManager.getTest();
		
		Thread.sleep(2000);
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Close Related Orders popup
		checkForRelatedOrdersDialog(driver);
		
		// Click Search Tab button
		perform.click(driver, SVendorSelection.search_tab(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Wait for Last Name textbox
		perform.waitForElementToBeClickable(driver, SVendorSelection.lastName_txtbx(), "id");
		
		// Enter Last Name
		perform.type(driver, SVendorSelection.lastName_txtbx(driver), vendorLastName);
		
		// Click Search
		perform.click(driver, SVendorSelection.search_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Click off error message if exists
		if (Overlay.overlay(driver).getAttribute("style").contains("visible")) {

			try {
				// Wait for element
				perform.waitForElementToBeClickable(driver, SVendorSelection.ok_btn(driver));
				
				// Click OK
				perform.click(driver, SVendorSelection.ok_btn(driver));
				
				// Wait for overlay to be hidden
				perform.waitForOverlayToBeHidden(driver);
			} catch (Exception e) {}
			
		} // end if
		
		// Select vendor
		List<WebElement> cells = SVendorSelection.searchResultsTable_txt(driver).findElements(By.cssSelector("tbody > tr > td"));
		for (WebElement el : cells) {
			if (el.getText().contains(vendorLastName)) {
				perform.click(driver, el);
				break;
			}
		} // end for
		
		// Click Next
		perform.click(driver, SVendorSelection.nextTop_btn(driver));
		
		// Wait for Finish button
		perform.waitForElementToBeClickable(driver, SConfirmOrder.finishTop_btn(), "id");
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Selected the vendor: " + vendorLastName);
		
	} // end selectVendorSearchByLastName
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click Search Tab button</li>
	 * 	<li>Enter Last Name</li>
	 * 	<li>Click Search</li>
	 * 	<li>Click off error message if exists</li>
	 * 	<li>Click OK</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param vendorLastName the vendor last name
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Search for a vendor by last name in Vendor Selection
	public void searchVendorByLastNameInVendorSelection(RemoteWebDriver driver, String vendorLastName) throws InterruptedException, IOException
	{
		
		Thread.sleep(2000);
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Close Related Orders popup
		checkForRelatedOrdersDialog(driver);
		
		// Click Search Tab button
		perform.click(driver, SVendorSelection.search_tab(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Wait for Last Name textbox
		perform.waitForElementToBeClickable(driver, SVendorSelection.lastName_txtbx(), "id");
		
		// Enter Last Name
		perform.type(driver, SVendorSelection.lastName_txtbx(driver), vendorLastName);
		
		// Click Search
		perform.click(driver, SVendorSelection.search_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Click off error message if exists
		if (Overlay.overlay(driver).getAttribute("style").contains("visible")) {

			// Click OK
			perform.click(driver, SVendorSelection.ok_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
		} // end if
		
	} // end searchVendorByLastNameInVendorSelection
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Confirm order screen loads</li>
	 * 	<li>Verify order information</li>
	 * 	<li>Click Next</li>
	 * 	<li>Check header text for Credit Card</li>
	 * 	<li>Click Next</li>
	 * 	<li>Set 40 second while loop timeout</li>
	 * 	<li>Get outside frames</li>
	 * 	<li>Get inside the attach document frame</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws InterruptedException the interrupted exception
	 */
	// Save New Order On Secure
	public void saveNewOrder(RemoteWebDriver driver) throws InterruptedException
	{

		// Wait for the back button
		perform.waitForElementToBeClickable(driver, SConfirmOrder.backTop_btn(), "id");
		
		Thread.sleep(1000);
		
		// Confirm order screen loads
		Assert.assertTrue(driver.getCurrentUrl().contains("ConfirmOrder"), "Order page did not load. Url should contain OrderConfirm, but is - " + driver.getCurrentUrl());
		
		// Verify order information
		verifyOrderDetails(driver);
		
		// Click Next
		perform.click(driver, SConfirmOrder.nextTop_btn(driver));
		
		Thread.sleep(3500);
		
		// Check header text for Credit Card
		if (SConfirmOrder.header_txt(driver).getText().contains("Credit Card"))
		{
			// Click Next
			perform.click(driver, SConfirmOrder.nextTop_btn(driver));
			Thread.sleep(3500);
		}
		
		// Wait for frames
		perform.waitForIFrames(driver);
		
		// Wait for dialog to move
		String dialogText = driver.findElement(By.id("ClickDialogText")).getAttribute("style");
		// Set 40 second while loop timeout
		long start_time = System.currentTimeMillis();
		long wait_time = 40000;
		long end_time = start_time + wait_time;
		while(System.currentTimeMillis() < end_time && !dialogText.contains("display: none;"))
		{
			Thread.sleep(500);
			dialogText = driver.findElement(By.id("ClickDialogText")).getAttribute("style");
			if (dialogText.contains("display: none;"))
			{
				break;
			} // end if
		} // end while
		
		// Get outside frames
		driver.switchTo().defaultContent();
		// Get inside the attach document frame
		driver.switchTo().frame("iframeAttach");
		
		// Wait for message text
		perform.waitForElementToBeClickable(driver, SConfirmOrder.uploadDocuments_btn(), "id");
		
	} // end saveNewOrderOnSecure
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Confirm order screen loads</li>
	 * 	<li>Verify order information</li>
	 * 	<li>Click Next</li>
	 * 	<li>Check header text for Credit Card</li>
	 * 	<li>Click Next</li>
	 * 	<li>Set 40 second while loop timeout</li>
	 * 	<li>Get outside frames</li>
	 * 	<li>Get inside the attach document frame</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws InterruptedException the interrupted exception
	 */
	public void saveEditOrder(RemoteWebDriver driver) throws InterruptedException
	{

		// Click Save
		perform.click(driver, SNewOrder.saveTop_btn(driver));
		
		// Wait for busy
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for the overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Check all of the checkboxes
		List<WebElement> checkboxes = driver.findElements(By.cssSelector("#Dialogs_Dialogs_chkVMPChangedItems > tbody > tr > td > input"));
		for (WebElement el : checkboxes) {
			// Check the checkboxes
			perform.checkCheckbox(driver, el);
		} // end for
		
		// Click the OK button
		perform.click(driver, SNewOrder.okUpdateClient_btn(driver));
		
		// Wait for busy
		perform.waitForBusyToBeHidden(driver);

	} // end saveEditOrder
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click Save</li>
	 * 	<li>Verify Dialog Text</li>
	 * 	<li>Click OK</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws InterruptedException the interrupted exception
	 */
	// Save Connection Settings
	public void saveConnectionSettings(RemoteWebDriver driver) throws InterruptedException
	{

		// Click Save
		perform.click(driver, SConnectionSettings.save_btn(driver));
		
		// Wait for overlay to be displayed
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SConnectionSettings.okSave_btn(), "cssSelector");
		
		// Verify Dialog Text
		Assert.assertTrue(SConnectionSettings.saveDialog_txt(driver).getText().contains("Your connection settings have been saved."), "Save dialog text is incorrect");
		
		// Click OK
		perform.click(driver, SConnectionSettings.okSave_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
	} // end saveConnectionSettings
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click Save</li>
	 * 	<li>Click OK</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws InterruptedException the interrupted exception
	 */
	// Save VMP XSite Settings
	public void saveVMPXSiteSettings(RemoteWebDriver driver) throws InterruptedException
	{

		// Click Save
		perform.click(driver, SVMPXSites.save_btn(driver));
		
		// Wait for overlay to be displayed
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SVMPXSites.saveCompleteOK_btn(), "cssSelector");
		
		// Click OK
		perform.click(driver, SVMPXSites.saveCompleteOK_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
	} // end saveVMPXSiteSettings
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click Save</li>
	 * 	<li>Verify Dialog Text</li>
	 * 	<li>Click OK</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Save Vendor Selection Settings
	public void saveVendorSelectionSettings(RemoteWebDriver driver) throws InterruptedException, IOException
	{

		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Click Save
		perform.click(driver, SVendorSelection.save_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for overlay to be displayed
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SVendorSelection.ok_btn(), "id");
		
		// Verify Dialog Text
		Assert.assertTrue(SVendorSelection.savedDialog_txt(driver).getText().contains("Your settings have been successfully saved"), "Save dialog text is incorrect");
		
		// Click OK
		perform.click(driver, SVendorSelection.ok_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
	} // end saveVendorSelectionSettings
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click Save</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws InterruptedException the interrupted exception
	 */
	// Save Users Settings
	public void saveUsersSettings(RemoteWebDriver driver) throws InterruptedException
	{

		// Click Save
		perform.click(driver, SUsers.save_btn(driver));
		
		// Wait for Create New user button
		perform.waitForElementToBeClickable(driver, SUsers.createNewUser_btn(), "cssSelector");
		
	} // end saveUsersSettings
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click Save</li>
	 * 	<li>Click OK button</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws InterruptedException the interrupted exception
	 */
	// Save Account Settings
	public void saveAccountSettings(RemoteWebDriver driver) throws InterruptedException
	{

		// Click Save
		perform.click(driver, SAccount.save_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);

		// Click OK button
		perform.click(driver, SAccount.ok_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
	} // end saveAccountSettings
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click Save</li>
	 * 	<li>Click OK</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws InterruptedException the interrupted exception
	 */
	// Save Appraisal Quality Management Settings
	public void saveAppraisalQualityManagementSettings(RemoteWebDriver driver) throws InterruptedException
	{

		// Click Save
		perform.click(driver, SAppraisalQualityManagementSettings.save_btn(driver));
		
		// Wait for the OK button
		perform.waitForElementToBeClickable(driver, SAppraisalQualityManagementSettings.ok_btn(), "id");
		
		// Click OK
		perform.click(driver, SAppraisalQualityManagementSettings.ok_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
	} // end saveAppraisalQualityManagementSettings
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Scroll element into view</li>
	 * 	<li>Get the text of the history</li>
	 * 	<li>Check for updated history</li>
	 * 	<li>Get start and end time for polling the db</li>
	 * 	<li>Date dNow = new Date( );  Instantiate a Date object</li>
	 * 	<li>Set 10 minute while loop timeout</li>
	 * 	<li>Refresh the screen</li>
	 * 	<li>Get history text</li>
	 * 	<li>Check if db has updated</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param textToWaitFor the text to wait for
	 * @return true, if successful
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Wait for the database to update by checking the text in the history of the Secure
	public boolean waitForHistoryTextToUpdate(RemoteWebDriver driver, String textToWaitFor) throws InterruptedException, IOException
	{
		
		System.out.println("Wait for db to update - " + textToWaitFor);
		
		ExtentTest test = ExtentTestManager.getTest();
		
		// Wait for db to update
		boolean dbUpdate = false;
		
		// Scroll element into view
		perform.scrollElementIntoView(driver, SOrderDetails.history_txt(driver));
		
		// Get the text of the history
		String history = SOrderDetails.history_txt(driver).getText();
		
		// Check for updated history
		if (history.contains(textToWaitFor))
		{
			dbUpdate = true;
		} // end if
		
		// Get start and end time for polling the db
		String startTime = new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime());
		Date dNow = new Date( ); // Instantiate a Date object
		Calendar cal = Calendar.getInstance();
		cal.setTime(dNow);
		cal.add(Calendar.MINUTE, 15);
		dNow = cal.getTime();
		String endTime = new SimpleDateFormat("HH:mm").format(dNow);
		
		System.out.println("Start polling for db update at " + startTime);
		System.out.println("Stop polling for db update at " + endTime);
		
		// Set 10 minute while loop timeout
		long start_time = System.currentTimeMillis();
		long wait_time = 1500000;
		long end_time = start_time + wait_time;
		while (System.currentTimeMillis() < end_time && dbUpdate == false)
		{
			
			// Refresh the screen
			driver.navigate().refresh();
			
			// Wait for History
			perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
			
			// Get history text
			history = SOrderDetails.history_txt(driver).getText();
			
			// Check if db has updated
			if (history.contains(textToWaitFor))
			{
				System.out.println("DB has been updated");
				dbUpdate = true;
				break;
			} // end if
			
			Thread.sleep(5000);
			
		} // end while loop
		
		if (dbUpdate == false) {
			System.out.println("The text '"+textToWaitFor+"' was not found in the audit trail");
			test.log(LogStatus.FAIL, "<span class='label failure'>waitForDBUpdateForHistoryTextOnSecure</span>", "<pre>Failure = The text '"+textToWaitFor+"' was not found in the audit trail</pre>");
			Assert.assertTrue(dbUpdate==true, "The text '"+textToWaitFor+"' was not found in the audit trail");
		}
		
		return dbUpdate;
	} // end waitForDBUpdateForHistoryTextOnSecure
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Check for updated history</li>
	 * 	<li>Get start and end time for polling the db</li>
	 * 	<li>Date dNow = new Date( );  Instantiate a Date object</li>
	 * 	<li>Set 10 minute while loop timeout</li>
	 * 	<li>Refresh the screen</li>
	 * 	<li>Get first row again</li>
	 * 	<li>Get history text</li>
	 * 	<li>Check if db has updated</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param textToWaitFor the text to wait for
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Wait for the database to update by checking the text in the history of the Secure
	public void waitForHistoryTextFirstRowToUpdate(RemoteWebDriver driver, String textToWaitFor) throws InterruptedException, IOException
	{
		
		System.out.println("Wait for db to update - " + textToWaitFor);
		
		// Wait for db to update
		boolean dbUpdate = false;
		
		WebElement firstRow = driver.findElement(By.cssSelector("#divHistoryWrapper > div:nth-child(1) > div.hiDescription"));
		String history = firstRow.getText();
		
		// Check for updated history
		if (history.contains(textToWaitFor))
		{
			dbUpdate = true;
		} // end if
		
		// Get start and end time for polling the db
		String startTime = new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime());
		Date dNow = new Date( ); // Instantiate a Date object
		Calendar cal = Calendar.getInstance();
		cal.setTime(dNow);
		cal.add(Calendar.MINUTE, 10);
		dNow = cal.getTime();
		String endTime = new SimpleDateFormat("HH:mm").format(dNow);
		
		System.out.println("Start polling for db update at " + startTime);
		System.out.println("Stop polling for db update at " + endTime);
		
		// Set 10 minute while loop timeout
		long start_time = System.currentTimeMillis();
		long wait_time = 600000;
		long end_time = start_time + wait_time;
		while (System.currentTimeMillis() < end_time && dbUpdate == false)
		{
			
			// Refresh the screen
			driver.navigate().refresh();
			
			// Wait for History
			perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
			
			// Get first row again
			firstRow = driver.findElement(By.cssSelector("#divHistoryWrapper > div:nth-child(1) > div.hiDescription"));
			
			// Get history text
			history = firstRow.getText();
			
			// Check if db has updated
			if (history.contains(textToWaitFor))
			{
				System.out.println("DB has been updated");
				break;
			} // end if
			
			Thread.sleep(2000);
			
		} // end while loop
		
	} // end waitForHistoryTextFirstRowToUpdate
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>disable the click event on an `&lt;input&gt;` file</li>
	 * 	<li>trigger the upload</li>
	 * 	<li>assign the file to the `&lt;input&gt;`</li>
	 * 	<li>Click OK alert dialog</li>
	 * 	<li>Click OK</li>
	 * 	<li>Set 40 second while loop timeout</li>
	 * 	<li>Add info to Extent Report</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param filePath the file path
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Upload document on Secure Confirm Order
	public void uploadDocumentOnSConfirmOrder(RemoteWebDriver driver, String filePath) throws InterruptedException, IOException
	{
		
		ExtentTest test = ExtentTestManager.getTest();
		
		if (StoredVariables.getmobile().get()==false) {
		
			System.out.println("Uploading a document");
		
			// disable the click event on an `<input>` file
			((JavascriptExecutor)driver).executeScript(
			    "HTMLInputElement.prototype.click = function() {                     " +
			    "  if(this.type !== 'file') HTMLElement.prototype.click.call(this);  " +
			    "};                                                                  " );
			
			Thread.sleep(2500);
			
			// trigger the upload
			perform.click(driver, SConfirmOrder.uploadDocuments_btn(driver));
			
			Thread.sleep(2500);
			
			// assign the file to the `<input>`
			System.out.println("filePath: " + filePath);
			driver.findElement(By.cssSelector("input[type=file]")).sendKeys(filePath);
			Thread.sleep(5000);
			
			// Click OK alert dialog
			try {
				// Click OK
				Alert alertOK = driver.switchTo().alert();
				alertOK.accept();
			} catch (Exception e) {
			}
			
			// Wait for completed check mark icon
			perform.waitForElementToBeVisible(driver, SConfirmOrder.attached_icon(), "id");
			String attachComplete = SConfirmOrder.attached_icon(driver).getAttribute("class");
			// Set 40 second while loop timeout
			long start_time = System.currentTimeMillis();
			long wait_time = 40000;
			long end_time = start_time + wait_time;
			while (System.currentTimeMillis() < end_time && !attachComplete.contains("OuterIconComplete"))
			{
				Thread.sleep(1000);
				attachComplete = SConfirmOrder.attached_icon(driver).getAttribute("class");
				if (attachComplete.contains("OuterIconComplete"))
				{
					break;
				} // end if
			} // end while
			
			// Wait for close button
			perform.waitForElementToBeClickable(driver, SConfirmOrder.finished_btn(), "id");
			
			// Add info to Extent Report
			test.log(LogStatus.INFO, "Info", "Uploaded document on the Confirm Order screen: " + filePath);
			
			} else {
			
			// Add info to Extent Report
			test.log(LogStatus.INFO, "Info", "Did not upload file because running in mobile");
			
		} // end if/else
		
	} // end uploadDocumentOnSConfirmOrder
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>disable the click event on an `&lt;input&gt;` file</li>
	 * 	<li>trigger the upload</li>
	 * 	<li>assign the file to the `&lt;input&gt;`</li>
	 * 	<li>Set 40 second while loop timeout</li>
	 * 	<li>Click OK</li>
	 * 	<li>Click Attach</li>
	 * 	<li>Select document type</li>
	 * 	<li>Add info to Extent Report</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param filePath the file path
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Upload document on Secure Confirm Order
	public void uploadDocumentOnSOrderDetails(RemoteWebDriver driver, String filePath) throws InterruptedException, IOException
	{
		
		ExtentTest test = ExtentTestManager.getTest();
		
		if (StoredVariables.getmobile().get()==false) {
			
			System.out.println("Uploading a document");
			// disable the click event on an `<input>` file
			((JavascriptExecutor) driver)
					.executeScript("HTMLInputElement.prototype.click = function() {                     "
							+ "  if(this.type !== 'file') HTMLElement.prototype.click.call(this);  "
							+ "};                                                                  ");
			Thread.sleep(2500);
			// trigger the upload
			perform.click(driver, SOrderDetails.uploadDocuments_btn(driver));
			Thread.sleep(2500);
			// assign the file to the `<input>`
			driver.findElement(By.cssSelector("input[type=file]")).sendKeys(filePath);
			Thread.sleep(2500);
			try {
				// Wait for completed check mark icon
				perform.waitForElementToBeVisible(driver, SOrderDetails.attached_icon(), "id");
				String attachComplete = SOrderDetails.attached_icon(driver).getAttribute("class");
				// Set 40 second while loop timeout
				long start_time = System.currentTimeMillis();
				long wait_time = 40000;
				long end_time = start_time + wait_time;
				while (System.currentTimeMillis() < end_time && !attachComplete.contains("OuterIconComplete")) {
					Thread.sleep(1000);
					attachComplete = SOrderDetails.attached_icon(driver).getAttribute("class");
					if (attachComplete.contains("OuterIconComplete")) {
						break;
					} // end if
				} // end while
			} catch (Exception e) {
				// Click OK
				perform.click(driver, driver.findElement(By.id("sbdmButton1")));

				// Click Attach
				perform.click(driver, SOrderDetails.attach_btn(driver));

				// Wait for overlay to be visible
				perform.waitForOverlayToBeVisible(driver);

				// Wait for upload button
				perform.waitForElementToBeClickable(driver, SOrderDetails.uploadDocuments_btn(), "id");

				// Select document type
				perform.selectDropdownOption(driver, SOrderDetails.documentType_dropdown(driver), "Other");

				uploadDocumentOnSOrderDetails(driver, filePath);
			}
			// Wait for close button
			perform.waitForElementToBeClickable(driver, SOrderDetails.close_btn(), "id");
			// Add info to Extent Report
			test.log(LogStatus.INFO, "Info", "Uploaded document on the Order Details screen: " + filePath);
			
		} else {
			
			// Add info to Extent Report
			test.log(LogStatus.INFO, "Info", "Did not upload file because running in mobile");
			
		} // end if
		
	} // end uploadDocumentOnSOrderDetails
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>disable the click event on an `&lt;input&gt;` file</li>
	 * 	<li>trigger the upload</li>
	 * 	<li>assign the file to the `&lt;input&gt;`</li>
	 * 	<li>Add info to Extent Report</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param fileName the file name
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Upload document on Secure Confirm Order
	public void uploadReportOnSOrderDetails(RemoteWebDriver driver, String fileName) throws InterruptedException, IOException
	{
		
		ExtentTest test = ExtentTestManager.getTest();
		
		if (StoredVariables.getmobile().get()==false) {
			
			System.out.println("Uploading a document");
			// disable the click event on an `<input>` file
			((JavascriptExecutor) driver)
					.executeScript("HTMLInputElement.prototype.click = function() {                     "
							+ "  if(this.type !== 'file') HTMLElement.prototype.click.call(this);  "
							+ "};                                                                  ");
			Thread.sleep(2500);
			// trigger the upload
			perform.click(driver, SOrderDetails.uploadReport_btn(driver));
			Thread.sleep(2500);
			// assign the file to the `<input>`
			driver.findElement(By.cssSelector("input[type=file]"))
					.sendKeys(StoredVariables.getdocDir().get() + fileName);
			Thread.sleep(2500);
			// Wait for document upload text
			perform.waitForText(driver, SOrderDetails.documentUploadProgress_txt(driver), fileName);
			// Wait for close button
			perform.waitForElementToBeClickable(driver, SOrderDetails.close_btn(), "id");
			// Add info to Extent Report
			test.log(LogStatus.INFO, "Info", "Uploaded report on the Order Details screen: " + fileName);
			
		} else {
			
			// Add info to Extent Report
			test.log(LogStatus.INFO, "Info", "Did not upload file because running in mobile");
			
		} // end if/else
		
	} // end uploadReportOnSOrderDetails
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>disable the click event on an `&lt;input&gt;` file</li>
	 * 	<li>trigger the upload</li>
	 * 	<li>assign the file to the `&lt;input&gt;`</li>
	 * 	<li>Add info to Extent Report</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param filePath the file path
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Upload document in Data Courier
	public void uploadXMLFileInDataCourier(RemoteWebDriver driver, String filePath) throws InterruptedException, IOException
	{
		
		ExtentTest test = ExtentTestManager.getTest();
		
		if (StoredVariables.getmobile().get()==false) {
			
			System.out.println("Uploading a document");
			// disable the click event on an `<input>` file
			((JavascriptExecutor) driver)
					.executeScript("HTMLInputElement.prototype.click = function() {                     "
							+ "  if(this.type !== 'file') HTMLElement.prototype.click.call(this);  "
							+ "};                                                                  ");
			Thread.sleep(2500);
			// trigger the upload
			perform.click(driver, SDataCourier.uploadReportFile_btn(driver));
			Thread.sleep(2500);
			// assign the file to the `<input>`
			driver.findElement(By.cssSelector("input[type=file]")).sendKeys(filePath);
			Thread.sleep(2500);
			// Add info to Extent Report
			test.log(LogStatus.INFO, "Info", "Uploaded XML file in Data Courier: " + filePath);
			
		} else {
			
			// Add info to Extent Report
			test.log(LogStatus.INFO, "Info", "Did not upload file because running in mobile");
			
		} // end if/else
		
	} // end uploadXMLFileInDataCourier
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click the Updated column</li>
	 * 	<li>Verify Due date is ordered properly to display the most recent order first</li>
	 * 	<li>Set 40 second while loop timeout</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws InterruptedException the interrupted exception
	 */
	// Sort by Updated column
	public void sortByUpdated(RemoteWebDriver driver) throws InterruptedException
	{
		
		System.out.println("Sorting by Updated");

		try
		{
			// Click the Updated column
			String column = "Updated";
			perform.click(driver, driver.findElement(By.xpath("//span[@class='" + SOrders.columnHeaders() + "' and text()='" + column + "']")));
			
			// Wait for overlay to disappear
			perform.waitForOverlayToBeHidden(driver);
			
			Thread.sleep(500);
			
			// Verify Due date is ordered properly to display the most recent order first
			String dueDateOrder = SOrders.sortArrow(driver).getAttribute("class");
			// Set 40 second while loop timeout
			long start_time = System.currentTimeMillis();
			long wait_time = 40000;
			long end_time = start_time + wait_time;
			while (System.currentTimeMillis() < end_time && !dueDateOrder.contains("ui-icon-arrowthick-1-s"))
			{
				perform.click(driver, driver.findElement(By.xpath("//span[@class='" + SOrders.columnHeaders() + "' and text()='" + column + "']")));
				perform.waitForOverlayToBeHidden(driver);
				Thread.sleep(500);
				dueDateOrder = SOrders.sortArrow(driver).getAttribute("class");
				if (dueDateOrder.contains("ui-icon-arrowthick-1-s"))
				{
					break;
				} // end if
				Thread.sleep(500);
			} // end while
		}
		catch (Exception e) {}
		
	} // end sortByUpdated
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click Uploaded On</li>
	 * 	<li>Click Uploaded On</li>
	 * 	<li>Look for desc arrow</li>
	 * 	<li>Verify order is descending</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws InterruptedException the interrupted exception
	 */
	// Sort by Uploaded column
	public void sortByUploadedDesc(RemoteWebDriver driver) throws InterruptedException
	{
		
		System.out.println("Sorting by Updated");

	    // Click Uploaded On
		perform.click(driver, driver.findElement(By.xpath("//th[contains(text(), 'Uploaded')]")));
		
		Thread.sleep(3000);
		
		// Wait for Find textbox
		perform.waitForElementToBeClickable(driver, SOrders.find_txtbx(), "id");
		
		List<WebElement> desc = driver.findElements(By.cssSelector("img[src='/Styles/Infragistics/Main_Alpha14_01/images/igg_sortDesc.gif']"));
		while (desc.isEmpty())
		{
			// Click Uploaded On
			perform.click(driver, driver.findElement(By.xpath("//th[contains(text(), 'Uploaded')]")));
			
			Thread.sleep(2000);
			
			// Look for desc arrow
			desc = driver.findElements(By.cssSelector("img[src='/Styles/Infragistics/Main_Alpha14_01/images/igg_sortDesc.gif']"));
		}
		
		// Verify order is descending
		perform.waitForElementToBeClickable(driver, "img[src='/Styles/Infragistics/Main_Alpha14_01/images/igg_sortDesc.gif']", "cssSelector");
		
	} // end sortByUploadedDesc
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Require Valid License</li>
	 * 	<li>Require Years Of Experience</li>
	 * 	<li>Require Staff Vendor</li>
	 * 	<li>Exclude Past Due Vendors</li>
	 * 	<li>Require Errors And Omissions</li>
	 * 	<li>Require Vendor Rating</li>
	 * 	<li>Limit Vendor Capacity</li>
	 * 	<li>Enforce Vendor Priority</li>
	 * 	<li>Click Save</li>
	 * 	<li>Click OK</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Sort by Uploaded column
	public void uncheckISSCheckboxes(RemoteWebDriver driver) throws InterruptedException, IOException
	{
		
		System.out.println("Uncheck ISS Checkboxes");

		// Require Valid License
		if (SVendorSelectionSettings.requireValidLicense_chkbx(driver).isSelected()==true)
		{
			perform.click(driver, SVendorSelectionSettings.requireValidLicense_chkbx(driver));
		}
		
		
		if (SVendorSelectionSettings.requireLocalVendor_chkbx(driver).isSelected()==true)
		{
			perform.click(driver, SVendorSelectionSettings.requireLocalVendor_chkbx(driver));
		}
		
		// Require Years Of Experience
		if (SVendorSelectionSettings.requireYearsOfExperience_chkbx(driver).isSelected()==true)
		{
			perform.click(driver, SVendorSelectionSettings.requireYearsOfExperience_chkbx(driver));
		}
		
		// Require Staff Vendor
		if (SVendorSelectionSettings.requireStaffVendor_chkbx(driver).isSelected()==true)
		{
			perform.click(driver, SVendorSelectionSettings.requireStaffVendor_chkbx(driver));
		}
		
		// Exclude Past Due Vendors
		if (SVendorSelectionSettings.excludePastDueVendors_chkbx(driver).isSelected()==true)
		{
			perform.click(driver, SVendorSelectionSettings.excludePastDueVendors_chkbx(driver));
		}
		
		// Require Errors And Omissions
		if (SVendorSelectionSettings.requireErrorsAndOmissions_chkbx(driver).isSelected()==true)
		{
			perform.click(driver, SVendorSelectionSettings.requireErrorsAndOmissions_chkbx(driver));
		}
		
		// Require Vendor Rating
		if (SVendorSelectionSettings.requireVendorRating_chkbx(driver).isSelected()==true)
		{
			perform.click(driver, SVendorSelectionSettings.requireVendorRating_chkbx(driver));
		}
		
		// Limit Vendor Capacity
		if (SVendorSelectionSettings.limitVendorCapacity_chkbx(driver).isSelected()==true)
		{
			perform.click(driver, SVendorSelectionSettings.limitVendorCapacity_chkbx(driver));
		}
		
		// Enforce Vendor Priority
		if (SVendorSelectionSettings.enforceVendorPriority_chkbx(driver).isSelected()==true)
		{
			perform.click(driver, SVendorSelectionSettings.enforceVendorPriority_chkbx(driver));
		}
		
		// Click Save
		perform.click(driver, SVendorSelectionSettings.save_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SVendorSelectionSettings.ok_btn(), "id");
		
		// Click OK
		perform.click(driver, SVendorSelectionSettings.ok_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
	} // end uncheckISSCheckboxes
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Turn switch on</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param element the element
	 * @throws InterruptedException the interrupted exception
	 */
	// Turn switch on
	public void switchOn(RemoteWebDriver driver, WebElement element) throws InterruptedException
	{
	    // Turn switch on
		if (element.getAttribute("src").contains("Off.png"))
		{
			perform.click(driver, element);
		} // end if
	} // end switchOn
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Turn switch off</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param element the element
	 * @throws InterruptedException the interrupted exception
	 */
	// Turn switch off
	public void switchOff(RemoteWebDriver driver, WebElement element) throws InterruptedException
	{
	    // Turn switch off
		if (element.getAttribute("src").contains("On.png"))
		{
			perform.click(driver, element);
		} // end if
	} // end switchOff
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click Manage</li>
	 * 	<li>Get the number of payment methods</li>
	 * 	<li>Delete payment methods</li>
	 * 	<li>Click Delete</li>
	 * 	<li>Click Yes</li>
	 *  <li>Handle the deletion of the payment method. If the card cannot be deleted, edit the info and then delete</li>
	 * 	<li>Get number of payment methods</li>
	 * 	<li>Click OK</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Delete all payment methods
	public void deleteAllPaymentMethods(RemoteWebDriver driver) throws InterruptedException, IOException
	{
		
		ExtentTest test = ExtentTestManager.getTest();
		
		// Click Manage
		perform.click(driver, SAccount.manage_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SAccount.okManagePaymentMethods_btn(), "id");
		
		// Get the number of payment methods
		int numOfPaymentMethods = perform.getNumOfRowsInTableID(driver, SAccount.managePaymentMethods_table())-1;
		System.out.println("Number of payment methods = " + (numOfPaymentMethods));
		
		// Delete payment methods
		while (numOfPaymentMethods > 0)
		{

			// Handle deletion of payment method
			handleDeletionOfPaymentMethod(driver, "1");
			
			// Get number of payment methods
			numOfPaymentMethods = perform.getNumOfRowsInTableID(driver, SAccount.managePaymentMethods_table())-1;
			
		} // end while number of payments are greater than 0
		
		// Click OK
		perform.click(driver, SAccount.okManagePaymentMethods_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Deleted all payment methods");
		
	} // end deleteAllPaymentMethods
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click Manage</li>
	 * 	<li>Get the number of payment methods</li>
	 * 	<li>Click Delete</li>
	 * 	<li>Click Yes</li>
	 * 	<li>Handle the deletion of the payment method. If the card cannot be deleted, edit the info and then delete</li>
	 * 	<li>Click OK</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param cardIndex the card index
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Delete individual payment method
	public void deleteIndividualPaymentMethod(RemoteWebDriver driver, String cardIndex) throws InterruptedException, IOException
	{
	
		ExtentTest test = ExtentTestManager.getTest();
		
		// Click Manage
		perform.click(driver, SAccount.manage_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SAccount.okManagePaymentMethods_btn(), "id");
		
		// Get the number of payment methods
		int numOfPaymentMethods = perform.getNumOfRowsInTableID(driver, SAccount.managePaymentMethods_table())-1;
		System.out.println("Number of payment methods = " + (numOfPaymentMethods));
		
		// Handle deletion of payment method
		handleDeletionOfPaymentMethod(driver, cardIndex);
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Deleted payment method");
		
	} // end deleteIndividualPaymentMethod
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * <ul>
	 * 	<li>Get the dialog text</li>
	 * 	<li>If the payment method could not be deleted, edit the card info and then try deleting again</li>
	 * </ul>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param cardIndex the card index
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Delete individual payment method
	public void handleDeletionOfPaymentMethod(RemoteWebDriver driver, String cardIndex) throws InterruptedException, IOException
	{

		// Click Delete
		perform.click(driver, SAccount.deletedCard_btn(driver, cardIndex));
		
		// Wait for Yes button
		perform.waitForElementToBeClickable(driver, SAccount.yes_btn(), "id");
		
		// Click Yes
		perform.click(driver, SAccount.yes_btn(driver));
		
		// Wait for busy
		perform.waitForBusyToBeHidden(driver);
		
		// If the payment method could not be deleted, edit the card info and then delete it
		if (!SAccount.okManagePaymentMethods_btn(driver).isDisplayed()) {
		
			// Get the dialog message
			String dialog = SAccount.dialog_txt(driver).getText();
			System.out.println("Dialog text: " + dialog);
			
			// Delete the payment method or edit and then delete if you cannot
			if (dialog.contains("Unable to delete")) {
				
				// Click OK on the Unable to delete dialog
				perform.click(driver, SAccount.ok_btn(driver));
				
				// Edit the payment method
				String firstName = "Auto" + perform.randomNumbers(driver, 3);
				String lastName = "TestUser";
				String streetAddress = "123 Test St.";
				String city = "Yukon";
				String state = "Oklahoma";
				String zipCode = "73099";
				String creditCardNumber = "4111111111111111";
				String expMonth = "12";
				String expYear = "2024";
				String emailAddress = "test@gmail.com";
				boolean primary = true;
				editIndividualPaymentMethod(driver, cardIndex, firstName, lastName, streetAddress, city, state, zipCode, creditCardNumber, expMonth, expYear, emailAddress, primary);
				
				// Click Delete
				perform.click(driver, SAccount.deletedCard_btn(driver, cardIndex));
				
				// Wait for Yes button
				perform.waitForElementToBeClickable(driver, SAccount.yes_btn(), "id");
				
				// Click Yes
				perform.click(driver, SAccount.yes_btn(driver));
				
				// Wait for busy
				perform.waitForBusyToBeHidden(driver);
				
			} // end if dialog contains unable to delete
			
		} // end if card could not be deleted
		
		// Wait for busy
		perform.waitForBusyToBeHidden(driver);

		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SAccount.okManagePaymentMethods_btn(), "id");
		
	} // end handleDeletionOfPaymentMethod
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li></li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>.
	 *
	 * @param driver the driver
	 * @param cardIndex the card index
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param streetAddress the street address
	 * @param city the city
	 * @param state the state
	 * @param zipCode the zip code
	 * @param creditCardNumber the credit card number
	 * @param expMonth the exp month
	 * @param expYear the exp year
	 * @param emailAddress the email address
	 * @param primary the primary
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Edit individual payment method
	public void editIndividualPaymentMethod(RemoteWebDriver driver, String cardIndex, String firstName, String lastName, String streetAddress, String city, String state, String zipCode, String creditCardNumber, String expMonth, String expYear, String emailAddress, boolean primary) throws InterruptedException, IOException
	{
		
		ExtentTest test = ExtentTestManager.getTest();
		
		// Click Edit
		perform.click(driver, SAccount.editCard_btn(driver, cardIndex));
		
		// Enter credit card info
		enterNewCreditCardInfo(driver, firstName, lastName, streetAddress, city, state, zipCode, creditCardNumber, expMonth, expYear, emailAddress, primary);
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Edited the payment method in position #" + cardIndex);
		
	} // end editIndividualPaymentMethod
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li></li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>.
	 *
	 * @param driver the driver
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param streetAddress the street address
	 * @param city the city
	 * @param state the state
	 * @param zipCode the zip code
	 * @param creditCardNumber the credit card number
	 * @param expMonth the exp month
	 * @param expYear the exp year
	 * @param emailAddress the email address
	 * @param primary the primary
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Edit individual payment method
	public void enterNewCreditCardInfo(RemoteWebDriver driver, String firstName, String lastName, String streetAddress, String city, String state, String zipCode, String creditCardNumber, String expMonth, String expYear, String emailAddress, boolean primary) throws InterruptedException, IOException
	{
		
		ExtentTest test = ExtentTestManager.getTest();
		
		// Switch iFrame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "StoreCard2.aspx", By.id(SAccount.firstName_txtbx()));
		
		// Wait for First Name textbox
		perform.waitForElementToBeClickable(driver, SAccount.firstName_txtbx(), "id");
		
		perform.sleep(driver, 5);
		
		// Enter First Name
		perform.type(driver, SAccount.firstName_txtbx(driver), firstName);
		
		// Enter Last Name
		perform.type(driver, SAccount.lastName_txtbx(driver), "TestUser");
		
		// Enter Address
		perform.type(driver, SAccount.address_txtbx(driver), "123 Test St.");
		
		// Enter City
		perform.type(driver, SAccount.city_txtbx(driver), "Mustang");
		
		// Select State
		perform.selectDropdownOption(driver, SAccount.state_dropdown(driver), "Oklahoma");
		
		// Enter Zip
		perform.type(driver, SAccount.zip_txtbx(driver), "73064");
		
		// Enter Card Number
		perform.type(driver, SAccount.cardNumber_txtbx(driver), creditCardNumber);
		
		// Select Expiration Month
		perform.selectDropdownOption(driver, SAccount.expirationMonth_dropdown(driver), "12");
		
		// Select Expiration Year
		perform.selectDropdownOption(driver, SAccount.expirationYear_dropdown(driver), "2024");
		
		// Enter Email
		perform.type(driver, SAccount.email_txtbx(driver), "automationTestUser" + StoredVariables.getcatchAllDomain().get());
		
		// Select Primary checkbox
		if (primary==true)
		{
			try
			{
				if (SAccount.primary_chkbx(driver).isSelected()==false)
				{
					perform.click(driver, SAccount.primary_chkbx(driver));
				} // end if not selected
			} // end try
			catch(Exception e){}
		} // end if primary == true
		
		// Click Save
		perform.click(driver, SAccount.saveCreditCard_btn(driver));
		
		// Switch out of iFrame
		driver.switchTo().defaultContent();
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SAccount.okManagePaymentMethods_btn(), "id");
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Entered new credit card information");
		
	} // end enterNewCreditCardInfo
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click Manage</li>
	 * 	<li>Get the number of payment methods</li>
	 * 	<li>Click Add a credit card</li>
	 * 	<li>Switch iFrame</li>
	 * 	<li>Enter First Name</li>
	 * 	<li>Enter Last Name</li>
	 * 	<li>Enter Address</li>
	 * 	<li>Enter City</li>
	 * 	<li>Select State</li>
	 * 	<li>Enter Zip</li>
	 * 	<li>Enter Card Number</li>
	 * 	<li>Select Expiration Month</li>
	 * 	<li>Select Expiration Year</li>
	 * 	<li>Enter Email</li>
	 * 	<li>Select Primary checkbox</li>
	 * 	<li>Click Save</li>
	 * 	<li>Click OK</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param creditCardNumber the credit card number
	 * @param primary the primary
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Add test credit card payment method
	public void addTestCreditCard(RemoteWebDriver driver, String creditCardNumber, boolean primary) throws InterruptedException, IOException
	{
		
		ExtentTest test = ExtentTestManager.getTest();
		
		// Click Manage
		perform.click(driver, SAccount.manage_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SAccount.okManagePaymentMethods_btn(), "id");
		
		// Get the number of payment methods
		int numOfPaymentMethods = perform.getNumOfRowsInTableID(driver, SAccount.managePaymentMethods_table())-1;
		System.out.println("Number of payment methods = " + (numOfPaymentMethods));
		Assert.assertTrue(numOfPaymentMethods < 2, "No more payment methods can be added becasue there are already 2 payment methods");
		
		// Click Add a credit card
		perform.click(driver, SAccount.addCreditCard_btn(driver));
		
		// Enter credit card info
		String firstName = "Auto" + perform.randomNumbers(driver, 3);
		String lastName = "TestUser";
		String streetAddress = "123 Test St.";
		String city = "Yukon";
		String state = "Oklahoma";
		String zipCode = "73099";
		String expMonth = "12";
		String expYear = "2024";
		String emailAddress = "test@gmail.com";
		enterNewCreditCardInfo(driver, firstName, lastName, streetAddress, city, state, zipCode, creditCardNumber, expMonth, expYear, emailAddress, true);
		
		// Click OK
		perform.click(driver, SAccount.okManagePaymentMethods_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Added credit card: " + creditCardNumber);
		
	} // end addCreditCard
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click Manage</li>
	 * 	<li>Get the number of payment methods</li>
	 * 	<li>Click Add a checking account</li>
	 * 	<li>Switch iFrame</li>
	 * 	<li>Enter First Name</li>
	 * 	<li>Enter Bank routing number</li>
	 * 	<li>Enter Account number</li>
	 * 	<li>Enter Confirm account number</li>
	 * 	<li>Select Personal radio button</li>
	 * 	<li>Click Save</li>
	 * 	<li>Click OK</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param accountNumber the account number
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Add test ACH account payment method
	public void addTestACHAccount(RemoteWebDriver driver, String accountNumber) throws InterruptedException, IOException
	{
		
		ExtentTest test = ExtentTestManager.getTest();
		
		// Click Manage
		perform.click(driver, SAccount.manage_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SAccount.okManagePaymentMethods_btn(), "id");
		
		// Get the number of payment methods
		int numOfPaymentMethods = perform.getNumOfRowsInTableID(driver, SAccount.managePaymentMethods_table())-1;
		System.out.println("Number of payment methods = " + (numOfPaymentMethods));
		Assert.assertTrue(numOfPaymentMethods < 2, "No more payment methods can be added becasue there are already 2 payment methods");
		
		// Click Add a checking account
		perform.click(driver, SAccount.addCheckingAccount_btn(driver));
		
		// Switch iFrame
		driver.switchTo().defaultContent();
		perform.waitForiFrameSrcAndSwitchToIt(driver, "/manage.aspx", By.id(SAccount.nameOnAccount_txtbx()));
		
		// Wait for Name on account textbox
		perform.waitForElementToBeClickable(driver, SAccount.nameOnAccount_txtbx(), "id");
		
		// Enter First Name
		String nameOnAccount = "Auto" + perform.randomNumbers(driver, 3) + " ACHUser";
		perform.type(driver, SAccount.nameOnAccount_txtbx(driver), nameOnAccount);
		
		// Enter Bank routing number
		perform.type(driver, SAccount.routingNumber_txtbx(driver), "103000130");
		
		// Enter Account number
		perform.type(driver, SAccount.accountNumber_txtbx(driver), accountNumber);
		
		// Enter Confirm account number
		perform.type(driver, SAccount.confirmAccountNumber_txtbx(driver), accountNumber);
		
		// Select Personal radio button
		perform.click(driver, SAccount.personal_radiobtn(driver));
		
		// Click Save
		perform.click(driver, SAccount.saveACH_btn(driver));
		
		// Switch out of iFrame
		driver.switchTo().defaultContent();
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SAccount.okManagePaymentMethods_btn(), "id");
		
		// Click OK
		perform.click(driver, SAccount.okManagePaymentMethods_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Added ACH account: " + accountNumber);
		
	} // end addTestACHAccount
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click Save</li>
	 * 	<li>Click OK</li>
	 * 	<li>Click close</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Save Client Group settings
	public void saveClientGroupSettings(RemoteWebDriver driver) throws InterruptedException, IOException
	{
		
		// Click Save
		perform.clickInTable_Equals(driver, "Save");
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SClients_ClientGroups.okSave_btn(), "cssSelector");
		
		// Click OK
		perform.click(driver, SClients_ClientGroups.okSave_btn(driver));

		// Click close
		perform.click(driver, SClients_OrderRouting.closeDialog_btn(driver));
		
		// Switch out of iFrame
		driver.switchTo().defaultContent();
		
	} // end saveClientGroupSettings
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set preferences and enable all status mapping</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Go to VMPXSites</li>
	 * 	<li>Click on Configure Status Mapping</li>
	 * 	<li>Enable all sync status options</li>
	 * 	<li>Click Save</li>
	 * 	<li>Click AMC/Firm</li>
	 * 	<li>Enable all sync status options</li>
	 * 	<li>Click Save</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param user the user
	 * @throws Exception the exception
	 */
	// Enable all sync options settings
	public void enableAllSyncOptionsSettings(RemoteWebDriver driver, String user) throws Exception
	{
		
		// Set preferences and enable all status mapping
		// Login to Secure
		login(driver, user, StoredVariables.getpassword().get());
		
		// Go to VMPXSites
		goToVMPXSites(driver);
		
		// Click on Configure Status Mapping
		perform.click(driver, SVMPXSites.configureStatusMapping_lnk(driver));
		
		// Wait for element
		perform.waitForElementToBeVisible(driver, SVMPXSites.statusMappingConfiguration_txt(), "id");
		
		// Enable all sync status options
		perform.enableAllOptionsInStatusMappingConfiguration(driver);
		
		// Click Save
		perform.clickInTable_Contains(driver, "Save");
		
		// Wait for save dialog to be hidden 
		perform.waitForOverlayToBeHidden(driver);
		
		// Click AMC/Firm
		perform.click(driver, SVMPXSites.amcFirm_btn(driver));

		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Enable all sync status options
		perform.enableAllOptionsInStatusMappingConfiguration(driver);
		
		// Click Save
		perform.clickInTable_Contains(driver, "Save");
		
		// Wait for save dialog to be hidden 
		perform.waitForOverlayToBeHidden(driver);
		
	} // end enableAllSyncOptionsSettings
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Switch to default frame</li>
	 * 	<li>Switch to iFrame</li>
	 * 	<li>Click Billing</li>
	 * 	<li>Click Invoices</li>
	 * 	<li>Switch to new window</li>
	 * 	<li>Get the new Window Handle</li>
	 * 	<li>Switch to the new window</li>
	 * 	<li>Switch to new frame</li>
	 * 	<li>Get invoice number</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @return the string
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// View Invoice from XSite Business Management
	public String viewInvoiceFromXSiteBusinessManagement(RemoteWebDriver driver) throws InterruptedException, IOException
	{
		
		// Switch to default frame
		driver.switchTo().defaultContent();
		
		// Switch to iFrame
		perform.switchToiFrameByID(driver, "Main");
		
		Thread.sleep(2500);
		
		perform.waitForElementToBeClickable(driver, XBusinessManagement.billing_btn(), "cssSelector");
		
		// Click Billing
		perform.click(driver, XBusinessManagement.billing_btn(driver));
		
		// Click Invoices
		perform.clickLabelText(driver, "Invoice");
		
	    // Switch to new window
	    perform.switchToXSiteWindowByTitle(driver, "Create an Invoice");
		
		// Get the new Window Handle
	    StoredVariables.getwin3().set(driver.getWindowHandle());
	    
	    Thread.sleep(3000);
		
		// Switch to the new window
		driver.switchTo().window(StoredVariables.getwin3().get());
		
		System.out.println("TITLE = " + driver.getTitle());
		
		Thread.sleep(3000);
		
		// Switch to new frame
		perform.switchToiFrameBySrc(driver, "Invoice.aspx");
		
		Thread.sleep(3000);
		
		// Wait for Invoice Number textbox
		perform.waitForElementToBeClickable(driver, XInvoice.invoiceNumber_txtbx(), "id");

		// Get invoice number
		String invoiceNumber = XInvoice.invoiceNumber_txtbx(driver).getAttribute("value");
		
		return invoiceNumber;
		
	} // end viewInvoiceFromXSiteBusinessManagement
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click Set status</li>
	 * 	<li>Click Place on hold</li>
	 * 	<li>Enter Notes</li>
	 * 	<li>Check Update status on VMP XSite checkbox</li>
	 * 	<li>Click OK button</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param notes the notes
	 * @param updateStatusOnVMPXSite the update status on VMPX site
	 * @throws InterruptedException the interrupted exception
	 */
	// Place On Hold
	public void placeOnHold(RemoteWebDriver driver, String notes, boolean updateStatusOnVMPXSite) throws InterruptedException 
	{
		
		ExtentTest test = ExtentTestManager.getTest();
		
		// Click Set status
		perform.click(driver, SOrderDetails.setStatus_btn(driver));
		
		// Click Place on hold
		perform.click(driver, SOrderDetails.placeOnHold_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for the Notes textbox
		perform.waitForElementToBeClickable(driver, SSetOrderStatus.notePlaceOnHold_txtbx(), "id");
		
		// Enter Notes
		perform.type(driver, SSetOrderStatus.notePlaceOnHold_txtbx(driver), notes);
		
		// Check Update status on VMP XSite checkbox
		if (updateStatusOnVMPXSite==true)
		{
			perform.checkCheckbox(driver, SSetOrderStatus.updateStatusOnVMPXSitePlaceOnHold_chkbx(driver));			
		}
		
		// Click OK button
		perform.click(driver, SSetOrderStatus.okPlaceOnHold_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Placed the order On Hold");
		
	} // end placeOnHold
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click Set status</li>
	 * 	<li>Click Resume</li>
	 * 	<li>Click the calendar</li>
	 * 	<li>Select date</li>
	 * 	<li>Enter Notes</li>
	 * 	<li>Check Update status on VMP XSite checkbox</li>
	 * 	<li>Click OK button</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param days the days
	 * @param notes the notes
	 * @param updateStatusOnVMPXSite the update status on VMPX site
	 * @throws InterruptedException the interrupted exception
	 */
	// Resume Order
	public void resumeOrder(RemoteWebDriver driver, int days, String notes, boolean updateStatusOnVMPXSite) throws InterruptedException 
	{
		
		ExtentTest test = ExtentTestManager.getTest();
		
		// Click Set status
		perform.click(driver, SOrderDetails.setStatus_btn(driver));
		
		// Click Resume
		perform.click(driver, SOrderDetails.resume_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for the Notes textbox
		perform.waitForElementToBeClickable(driver, SSetOrderStatus.noteResume_txtbx(), "id");
		
		// Click the calendar
		perform.click(driver, SSetOrderStatus.calendar_btn(driver));
		
		// Select date
		selectDateFromCalendar(driver, days);
		
		// Enter Notes
		perform.type(driver, SSetOrderStatus.noteResume_txtbx(driver), notes);
		
		// Check Update status on VMP XSite checkbox
		if (updateStatusOnVMPXSite==true)
		{
			perform.checkCheckbox(driver, SSetOrderStatus.updateStatusOnVMPXSiteResume_chkbx(driver));			
		}
		
		// Click OK button
		perform.click(driver, SSetOrderStatus.okResume_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Resumed the order");
		
	} // end resumeOrder
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click Order Groups</li>
	 * 	<li>Get outside frames</li>
	 * 	<li>Get inside the vendor assignment frame</li>
	 * 	<li>Click Add New button</li>
	 * 	<li>Enter Group Name</li>
	 * 	<li>Click Add</li>
	 * 	<li>Click Close</li>
	 * 	<li>Get outside frames</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param orderGroupName the order group name
	 * @throws InterruptedException the interrupted exception
	 */
	// Add Order Group
	public void addNewOrderGroup(RemoteWebDriver driver, String orderGroupName) throws InterruptedException 
	{
	
		ExtentTest test = ExtentTestManager.getTest();
		
		System.out.println("Adding Order Group");
		
		// Click Order Groups
		perform.click(driver, SFeePanel.orderGroups_btn(driver));
		
		Thread.sleep(3000);
		
		// Get outside frames
		driver.switchTo().defaultContent();
		
		// Get inside the vendor assignment frame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "Appraisers/OrderGroupsManage.aspx", By.linkText("Add new"));
		
		// Click Add New button
		perform.click(driver, driver.findElement(By.linkText("Add new")));
		
		// Enter Group Name
		perform.type(driver, driver.findElement(By.cssSelector("#tblOrderGroups_headers > thead > tr:nth-child(3) > td:nth-child(1) > span > input")), orderGroupName);
		
		// Click Add
		perform.click(driver, driver.findElement(By.cssSelector("#tblOrderGroups_scroll > div > span.done_id.ui-iggrid-button.ui-state-default.ui-corner-all.ui-iggrid-donebutton.ui-priority-primary > span:nth-child(2)")));
		
		Thread.sleep(2000);
		
		// Wait for Close button
		perform.waitForElementToBeClickable(driver, SFeePanel.saveOrderGroups_btn(), "id");
		
		// Click Close
		perform.click(driver, SFeePanel.saveOrderGroups_btn(driver));
		
		// Get outside frames
		driver.switchTo().defaultContent();
		
		Thread.sleep(2000);
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Added an Order Group: " + orderGroupName);
		
	} // end addNewOrderGroup
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click Order Groups</li>
	 * 	<li>Switch iFrame</li>
	 * 	<li>Get the total number of rows in the table</li>
	 * 	<li>Verify the Order Group exists</li>
	 * 	<li>Delete the Order Groups that contain the supplied text</li>
	 * 	<li>Look for the TestOrderGroup</li>
	 * 	<li>Click the delete icon</li>
	 * 	<li>Click Save</li>
	 * 	<li>Switch out of the iFrame</li>
	 * 	<li>Click Cancel</li>
	 * 	<li>Switch out of the iFrame</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param orderGroup the order group
	 * @throws InterruptedException the interrupted exception
	 */
	// Delete Order Group
	public void deleteOrderGroup(RemoteWebDriver driver, String orderGroup) throws InterruptedException 
	{
		
		ExtentTest test = ExtentTestManager.getTest();
		
		System.out.println("Deleting Order Groups that contain the text '" + orderGroup + "'");
		
		// Click Order Groups
		perform.click(driver, SFeePanel.orderGroups_btn(driver));
		
		// Switch iFrame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "Appraisers/OrderGroupsManage.aspx", By.linkText("Add new"));
		
		// Wait for Add new link text
		perform.waitForElementToBeClickable(driver, "Add new", "linkText");
		
		// Get the total number of rows in the table
		List<WebElement> numOfRows = SFeePanel.orderGroupsTable_txt(driver).findElements(By.cssSelector("tr"));
		System.out.println("Total number of Order Groups = " + numOfRows.size());
		
		// Verify the Order Group exists
		String groupText = SFeePanel.orderGroupsTable_txt(driver).getText();
		if (groupText.contains(orderGroup)) {
			
			// Delete the Order Groups that contain the supplied text
			for(WebElement row:numOfRows)
			{
				// Look for the TestOrderGroup
				if (row.getText().contains(orderGroup))
				{
					
					// Click the delete icon
					perform.click(driver, row.findElement(By.cssSelector(SFeePanel.delete_btn())));
					
					// Wait for the undelete icon
					perform.waitForElementToBeClickable(driver, SFeePanel.undelete_btn(), "cssSelector");
					
					Thread.sleep(500);
					
				} // end if
			} // end the for loop
			
			// Click Save
			perform.click(driver, SFeePanel.saveOrderGroups_btn(driver));
			
			// Switch out of the iFrame
			driver.switchTo().defaultContent();
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
		} else {
			
			System.out.println("The order group " + orderGroup + " does not exist");
			
			// Click Cancel
			perform.click(driver, SFeePanel.cancelOrderGroups_btn(driver));
			
			// Switch out of the iFrame
			driver.switchTo().defaultContent();
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
		} // end if group exists
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Deleted an Order Group: " + orderGroup);
		
	} // end deleteOrderGroup
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>On the Xsite order, click Billing&gt;Charge Card</li>
	 * 	<li>Switch to the new window</li>
	 * 	<li>Switch to the correct iFrame</li>
	 * 	<li>Charge the card for the order fee</li>
	 * 	<li>Enter First Name</li>
	 * 	<li>Enter Last Name</li>
	 * 	<li>Enter Zip code</li>
	 * 	<li>Enter Credit card number</li>
	 * 	<li>Select Exp Date</li>
	 * 	<li>Select Exp Year</li>
	 * 	<li>Enter Amount</li>
	 * 	<li>Enter Email address</li>
	 * 	<li>Check E-mail invoice</li>
	 * 	<li>Click Charge Card button</li>
	 * 	<li>Get to correct window</li>
	 * 	<li>Verify text in the Payment Summary</li>
	 * 	<li>Click Close</li>
	 * 	<li>Switch to the new window</li>
	 * 	<li>Set the current window handle to use outside of this method</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param zipCode the zip code
	 * @param creditCardNumber the credit card number
	 * @param expMonth the exp month
	 * @param expYear the exp year
	 * @param amount the amount
	 * @param emailAddress the email address
	 * @param emailInvoice the email invoice
	 * @throws InterruptedException the interrupted exception
	 */
	// Charge Card XSite
	public void chargeCardXSite(RemoteWebDriver driver, String firstName, String lastName, String zipCode, String creditCardNumber, String expMonth, String expYear, String amount, String emailAddress, boolean emailInvoice) throws InterruptedException 
	{
		
		ExtentTest test = ExtentTestManager.getTest();
		
		/**************************************************
		 * Make sure that you are in the #Main iFrame 
		**************************************************/
		
		String windowBusMan = driver.getWindowHandle();
		
		// Click Billing
		perform.click(driver, XBusinessManagement.billing_btn(driver));

		// Click Charge Card
		perform.click(driver, XBusinessManagement.chargeCard_btn(driver));
		
		// Switch to the new window
		perform.switchToXSiteWindowByTitle(driver, "Charge Card");
		
		// Wait for Form to load
		perform.waitForElementToBeClickable(driver, "Form1", "id");
		
		// Switch to the correct iFrame
		perform.switchToiFrameByID(driver, "PB_ctlStoreCardFrame");
		
		// Wait for the First Name textbox
		perform.waitForElementToBeClickable(driver, XChargeCard.firstName_txtbx(), "id");
		
		// Charge the card for the order fee
		// Enter First Name
		if (!firstName.equals("")) {
			perform.type(driver, XChargeCard.firstName_txtbx(driver), firstName);
		} // end if
		
		// Enter Last Name
		if (!lastName.equals("")) {
			perform.type(driver, XChargeCard.lastName_txtbx(driver), lastName);
		} // end if
		
		// Enter Zip code
		if (!zipCode.equals("")) {
			perform.type(driver, XChargeCard.zipCode_txtbx(driver), zipCode);
		} // end if
		
		// Enter Credit card number
		if (!creditCardNumber.equals("")) {
			perform.type(driver, XChargeCard.creditCardNumber_txtbx(driver), creditCardNumber);
		} // end if
		
		// Select Exp Date
		if (!expMonth.equals("")) {	
			perform.selectDropdownOption(driver, XChargeCard.expMonth_dropdown(driver), expMonth);
		} // end if
		
		// Select Exp Year
		if (!expYear.equals("")) {	
			perform.selectDropdownOption(driver, XChargeCard.expYear_dropdown(driver), expYear);
		} // end if
		
		// Enter Amount
		if (!amount.equals("")) {	
			perform.type(driver, XChargeCard.amount_txtbx(driver), amount);
		} // end if
		
		// Enter Email address
		if (!emailAddress.equals("")) {	
			perform.type(driver, XChargeCard.emailAddress_txtbx(driver), emailAddress);
		} // end if
		
		// Check E-mail invoice
		if (emailInvoice==true) {
			perform.checkCheckbox(driver, XChargeCard.emailInvoice_chkbx(driver));
		}

		// Click Charge Card button
		perform.click(driver, XChargeCard.chargeCard_btn(driver));
		
		// Close the alert if it exists and cancel out of the charge card window and fail the test if it does
		perform.sleep(driver, 10);
		boolean alertDisplayed = perform.closeAlertIfItExists(driver);
		if (alertDisplayed==true) {
			
			// Click Cancel
			perform.click(driver, XChargeCard.cancel_btn(driver));
			
			// Switch window
			driver.switchTo().window(windowBusMan);
			
			// Fail the test if the alert was displayed
			Assert.assertTrue(alertDisplayed==false, "There was a problem charging the card on the XSite");
			
		} // end if
		
		// Get to correct window
		perform.switchToXSiteWindowByTitle(driver, "Receivable");
		
		// Wait for Close button
		perform.waitForElementToBeClickable(driver, XChargeCard.close_btn(), "id");
		
		// Verify text in the Payment Summary
		String paymentSummaryText = XChargeCard.paymentSummary_txt(driver).getText();
		Assert.assertTrue(paymentSummaryText.contains("Payment Summary"), "The Payment Summary text is incorrect. Text = " + paymentSummaryText);
		Assert.assertTrue(paymentSummaryText.contains("The following items have been paid with this credit card transaction."), "The Payment Summary text is incorrect. Text = " + paymentSummaryText);
		if (!amount.equals("")) {
			Assert.assertTrue(paymentSummaryText.contains("$" + amount + " - Paid in Full"), "The Payment Summary text is incorrect. Text = " + paymentSummaryText);
		} // end if
		// Click Close
		perform.click(driver, XChargeCard.close_btn(driver));
		
		// Switch to the new window
		driver.switchTo().window(windowBusMan);
		driver.switchTo().frame("Main");
		
		Thread.sleep(4000);
		
		// Set the current window handle to use outside of this method
		StoredVariables.getnewWinHandle().set(driver.getWindowHandle());
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Charged creit card " + creditCardNumber + " for " + amount + " from the XSite");
		
	} // end chargeCardXSite
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Enter Loan Number</li>
	 * 	<li>Click Search</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param loanNumber the loan number
	 * @throws InterruptedException the interrupted exception
	 */
	// Search for payments in Order Summary by loan number
	public void searchForPaymentsInOrderSummaryByLoanNumber(RemoteWebDriver driver, String loanNumber) throws InterruptedException 
	{
		// Enter Loan Number
		perform.type(driver, SPayments.loanNumber_txtbx(driver), loanNumber);
		
		// Click Search
		perform.click(driver, SPayments.search_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for the Loan number to be in the grid
		perform.waitForText(driver, SPayments.grid_txt(driver), loanNumber);
		
	} // searchForPaymentsInOrderSummaryByLoanNumber
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Enter loan number</li>
	 * 	<li>Click Search button</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param loanNumber the loan number
	 * @throws InterruptedException the interrupted exception
	 */
	// Search for payments in Invoices by loan number
	public void searchForPaymentsInInvoicesByLoanNumber(RemoteWebDriver driver, String loanNumber) throws InterruptedException 
	{
		
		// Wait for the element
		perform.waitForElementToBeClickable(driver, SPayments.loanNumberInvoices_txtbx(driver));
		
		// Enter loan number
		perform.type(driver, SPayments.loanNumberInvoices_txtbx(driver), loanNumber);
		
		// Click Search button
		perform.click(driver, SPayments.searchInvoices_btn(driver));
		
		// Wait for the grid to display the loan number
		perform.waitForText(driver, SPayments.gridInvoices_txt(driver), loanNumber);
		
		Thread.sleep(3000);
		
	} // searchForPaymentsInInvoicesByLoanNumber
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	public void searchForPaymentsInTransactionsByLoanNumber(RemoteWebDriver driver, String loanNumber) throws InterruptedException 
	 * 	<li>Enter Loan Number</li>
	 * 	<li>Click Search</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param loanNumber the loan number
	 * @throws InterruptedException the interrupted exception
	 */
	// Search for payments in Transactions by loan number
	public void searchForPaymentsInTransactionsByLoanNumber(RemoteWebDriver driver, String loanNumber) throws InterruptedException 
	{
		// Enter Loan Number
		perform.type(driver, SPayments.loanNumberTransactions_txtbx(driver), loanNumber);
		
		// Click Search
		perform.click(driver, SPayments.searchTransactions_btn(driver));

		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
	} // searchForPaymentsInTransactionsByLoanNumber
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get table data</li>
	 * 	<li>Verify table data</li>
	 * 	<li>Verify Ordered column</li>
	 * 	<li>Verify Loan Number column</li>
	 * 	<li>Verify Property address column</li>
	 * 	<li>Verify Borrower column</li>
	 * 	<li>Verify Client column</li>
	 * 	<li>Verify Vendor column</li>
	 * 	<li>Verify Receivable column</li>
	 * 	<li>Verify Received column</li>
	 * 	<li>Verify Receivable due column</li>
	 * 	<li>Verify Payable column</li>
	 * 	<li>Verify Payable due column</li>
	 * 	<li>Verify Issue date column</li>
	 * 	<li>Verify To vendor column</li>
	 * 	<li>Verify Tech fee column</li>
	 * 	<li>Verify Balance column</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param ordered the ordered
	 * @param loanNumber the loan number
	 * @param propertyAddress the property address
	 * @param borrower the borrower
	 * @param client the client
	 * @param vendor the vendor
	 * @param receivable the receivable
	 * @param received the received
	 * @param receivableDue the receivable due
	 * @param payable the payable
	 * @param payableDue the payable due
	 * @param issueDate the issue date
	 * @param toVendor the to vendor
	 * @param techFee the tech fee
	 * @param balance the balance
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Verify the Order Summary details in the Payments screen
	public void verifyOrderSummaryPaymentDetailsInPayments(RemoteWebDriver driver, String ordered, String loanNumber, String propertyAddress, String borrower, String client, String vendor,
			String receivable, String received, String receivableDue, String payable, String payableDue, String issueDate, String toVendor, String techFee, String balance) throws InterruptedException, IOException
	{
		
		System.out.println("ordered = " + ordered);
		System.out.println("loanNumber = " + loanNumber);
		System.out.println("propertyAddress = " + propertyAddress);
		System.out.println("borrower = " + borrower);
		System.out.println("client = " + client);
		System.out.println("vendor = " + vendor);
		System.out.println("receivable = " + receivable);
		System.out.println("received = " + received);
		System.out.println("receivableDue = " + receivableDue);
		System.out.println("payable = " + payable);
		System.out.println("payableDue = " + payableDue);
		System.out.println("issueDate = " + issueDate);
		System.out.println("toVendor = " + toVendor);
		System.out.println("techFee = " + techFee);
		System.out.println("balance = " + balance);
		
		Thread.sleep(3000);
		
		// Wait for the table
		perform.waitForElementToBeClickable(driver, SPayments.grid_txt(), "id");
		
		// Get table data
		ArrayList<String> orderSummary = perform.getAllTableData(driver, SPayments.grid_txt());
		
		// Verify table data
		// Verify Ordered column
		perform.verification(driver, orderSummary.get(0), "contains", ordered);
		// Verify Loan Number column
		perform.verification(driver, orderSummary.get(1), "equals", loanNumber);		
		// Verify Property address column
		perform.verification(driver, orderSummary.get(2), "equals", propertyAddress);
		// Verify Borrower column
		perform.verification(driver, orderSummary.get(3), "equals", borrower);
		// Verify Client column
		perform.verification(driver, orderSummary.get(4), "contains", client);
		// Verify Vendor column
		perform.verification(driver, orderSummary.get(5), "contains", vendor);
		// Verify Receivable column
		perform.verification(driver, orderSummary.get(6), "equals", receivable);
		// Verify Received column
		perform.verification(driver, orderSummary.get(7), "equals", received);
		// Verify Receivable due column
		perform.verification(driver, orderSummary.get(8), "equals", receivableDue);
		// Verify Payable column
		perform.verification(driver, orderSummary.get(9), "equals", payable);
		// Verify Payable due column
		perform.verification(driver, orderSummary.get(10), "equals", payableDue);
		// Verify Issue date column
		perform.verification(driver, orderSummary.get(11), "equals", issueDate);
		// Verify To vendor column
		perform.verification(driver, orderSummary.get(12), "equals", toVendor);
		// Verify Tech fee column
		perform.verification(driver, orderSummary.get(13), "equals", techFee);
		// Verify Balance column
		perform.verification(driver, orderSummary.get(14), "equals", balance);
		
	} // end verifyOrderSummaryPaymentDetailsInPayments
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get table data</li>
	 * 	<li>Verify table data</li>
	 * 	<li>Verify Invoice date column</li>
	 * 	<li>Verify Loan Number column</li>
	 * 	<li>Verify Property address column</li>
	 * 	<li>Verify Contact column</li>
	 * 	<li>Verify Company column</li>
	 * 	<li>Verify Invoice # column</li>
	 * 	<li>Verify Invoice due column</li>
	 * 	<li>Verify Type column</li>
	 * 	<li>Verify Amount column</li>
	 * 	<li>Verify Received column</li>
	 * 	<li>Verify Paid column</li>
	 * 	<li>Verify Amount due column</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param invoiceDate the invoice date
	 * @param loanNumber the loan number
	 * @param propertyAddress the property address
	 * @param contact the contact
	 * @param company the company
	 * @param invoiceNumber the invoice number
	 * @param invoiceDue the invoice due
	 * @param type the type
	 * @param amount the amount
	 * @param received the received
	 * @param paid the paid
	 * @param amountDue the amount due
	 * @param tableID The id of the grid to get data from
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Verify the Invoices details in the Payments screen
	public void verifyInvoicesPaymentDetailsInPayments(RemoteWebDriver driver, String invoiceDate, String loanNumber, String propertyAddress, String contact, String company, String invoiceNumber,
			String invoiceDue, String type, String amount, String received, String paid, String amountDue, String tableID) throws InterruptedException, IOException
	{
		
		System.out.println("invoiceDate = " + invoiceDate);
		System.out.println("loanNumber = " + loanNumber);
		System.out.println("propertyAddress = " + propertyAddress);
		System.out.println("contact = " + contact);
		System.out.println("company = " + company);
		System.out.println("invoiceNumber = " + invoiceNumber);
		System.out.println("invoiceDue = " + invoiceDue);
		System.out.println("received = " + received);
		System.out.println("type = " + type);
		System.out.println("amount = " + amount);
		System.out.println("received = " + received);
		System.out.println("amountDue = " + amountDue);
		
		// Get table data
		ArrayList<String> invoices = perform.getAllTableData(driver, tableID);
		
		// Verify table data
		// Verify Invoice date column
		perform.verification(driver, invoices.get(0), "contains", invoiceDate);
		// Verify Loan Number column
		perform.verification(driver, invoices.get(1), "equals", loanNumber);		
		// Verify Property address column
		perform.verification(driver, invoices.get(2), "contains", propertyAddress);
		// Verify Contact column
		perform.verification(driver, invoices.get(3), "contains", contact);
		// Verify Company column
		perform.verification(driver, invoices.get(4), "equals", company);
		// Verify Invoice # column
		perform.verification(driver, invoices.get(5), "contains", invoiceNumber);
		// Verify Invoice due column
		perform.verification(driver, invoices.get(6), "equals", invoiceDue);
		// Verify Type column
		perform.verification(driver, invoices.get(7), "equals", type);
		// Verify Amount column
		perform.verification(driver, invoices.get(8), "equals", amount);
		// Verify Received column
		perform.verification(driver, invoices.get(9), "equals", received);
		// Verify Paid column
//		perform.verification(driver, invoices.get(10), "equals", paid);
		// Verify Amount due column
		perform.verification(driver, invoices.get(10), "equals", amountDue);
		
	} // end verifyInvoicesPaymentDetailsInPayments
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get table data</li>
	 * 	<li>Verify table data</li>
	 * 	<li>Verify Date column</li>
	 * 	<li>Verify Loan Number column</li>
	 * 	<li>Verify Property address column</li>
	 * 	<li>Verify Name on account column</li>
	 * 	<li>Verify Address on account column</li>
	 * 	<li>Verify Account # column</li>
	 * 	<li>Verify Trans ID column</li>
	 * 	<li>Verify Type column</li>
	 * 	<li>Verify Status column</li>
	 * 	<li>Verify Amount column</li>
	 * 	<li>Verify Actions due column</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param date the date
	 * @param loanNumber the loan number
	 * @param propertyAddress the property address
	 * @param nameOnAccount the name on account
	 * @param addressOnAccount the address on account
	 * @param accountNumber the account number
	 * @param transID the trans ID
	 * @param type the type
	 * @param status the status
	 * @param amount the amount
	 * @param actions the actions
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Verify the Transactions details in the Payments screen
	public void verifyTransactionsPaymentDetailsInPayments(RemoteWebDriver driver, String date, String loanNumber, String propertyAddress, String nameOnAccount, String addressOnAccount, String accountNumber,
			String transID, String type, String status, String amount, String actions) throws InterruptedException, IOException
	{
		
		System.out.println("date = " + date);
		System.out.println("loanNumber = " + loanNumber);
		System.out.println("propertyAddress = " + propertyAddress);
		System.out.println("nameOnAccount = " + nameOnAccount);
		System.out.println("addressOnAccount = " + addressOnAccount);
		System.out.println("accountNumber = " + accountNumber);
		System.out.println("transID = " + transID);
		System.out.println("type = " + type);
		System.out.println("status = " + status);
		System.out.println("amount = " + amount);
		System.out.println("actions = " + actions);
		
		// Get table data
		ArrayList<String> transactions = perform.getAllTableData(driver, SPayments.gridTransactions_txt());
		
		// Verify table data
		// Verify Date column
		perform.verification(driver, transactions.get(0), "equals", date);
		// Verify Loan Number column
		perform.verification(driver, transactions.get(1), "equals", loanNumber);		
		// Verify Property address column
		perform.verification(driver, transactions.get(2), "equals", propertyAddress);
		// Verify Name on account column
		perform.verification(driver, transactions.get(3), "equals", nameOnAccount);
		// Verify Address on account column
		perform.verification(driver, transactions.get(4), "contains", addressOnAccount);
		// Verify Account # column
		perform.verification(driver, transactions.get(5), "equals", accountNumber);
		// Verify Trans ID column
		perform.verification(driver, transactions.get(6), "equals", transID);
		// Verify Type column
		perform.verification(driver, transactions.get(7), "equals", type);
		// Verify Status column
		perform.verification(driver, transactions.get(8), "equals", status);
		// Verify Amount column
		perform.verification(driver, transactions.get(9), "equals", amount);
		// Verify Actions due column
		perform.verification(driver, transactions.get(10), "equals", actions);
		
	} // end verifyTransactionsPaymentDetailsInPayments
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click Set Status</li>
	 * 	<li>Click Change fee</li>
	 * 	<li>Enter New Fee</li>
	 * 	<li>Enter Comments</li>
	 * 	<li>Click Set Fee</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param newFee the new fee
	 * @param comments the comments
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	// Change fee on Secure
	public void changeFee(RemoteWebDriver driver, String newFee, String comments) throws IOException, InterruptedException
	{
		
		ExtentTest test = ExtentTestManager.getTest();
		
		System.out.println("Changing the fee of the order from Secure");

		// Click Set Status
		perform.click(driver, SOrderDetails.setStatus_btn(driver));
		
		// Wait for Change fee text
		perform.waitForText(driver, driver.findElement(By.id("Main_Main_mbMain_3")), "Change fee");
		
		// Click Change fee
		perform.clickInTable_Contains(driver, "Change fee");
				
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for Set Fee button
		perform.waitForElementToBeClickable(driver, SChangeFee.setFee_btn(), "id");
		
		// Enter New Fee
		perform.type(driver, SChangeFee.newFee_txtbx(driver), newFee);
		
		// Enter Comments
		perform.type(driver, SChangeFee.comments_txtbx(driver), comments);
		
		// Click Set Fee
		perform.click(driver, SChangeFee.setFee_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Changed the fee to " + newFee);
		
	} // end changeFee
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click the request sent link</li>
	 * 	<li>Switch to new window</li>
	 * 	<li>Set the 3rd window handle</li>
	 * 	<li>Switch to iFrame</li>
	 * 	<li>close third window</li>
	 * 	<li>switch to second window</li>
	 * 	<li>Click the request sent link</li>
	 * 	<li>Switch to new window</li>
	 * 	<li>Set the 3rd window handle</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws InterruptedException the interrupted exception
	 */
	// Open the Make A Payment page
	public void openMakeAPaymentPage (RemoteWebDriver driver) throws InterruptedException {
		
		String win2 = StoredVariables.getwin2().get();
		
		// Wait for history to display Make a payment
		String text = "Make a payment";
		int a = 1;
		String getText = XOrders.history_txt(driver).getText();
		while(a<85 && !getText.contains(text))
		{
			System.out.println("a = " + a);
			getText = XOrders.history_txt(driver).getText();
			if (getText.contains(text))
			{
				break;
			} // end if
			driver.navigate().refresh();
			driver.switchTo().window(win2);
			perform.switchToiFrameByID(driver, "Main");
			Thread.sleep(5000);
			a++;
		} // end while
		
		// Click the request sent link
		perform.click(driver, driver.findElement(By.linkText("request sent")));
		
		// Switch to new window
		Thread.sleep(2000);
		perform.switchToXSiteWindowByTitle(driver, "Enter Payment");
		Thread.sleep(2000);
		
		// Set the 3rd window handle
		String win3 = driver.getWindowHandle();
		
		// Switch to iFrame
		boolean paymentScreen = false;
		int tries = 1;
		while (paymentScreen==false && tries < 8) {
			try {
				
				perform.waitForiFrameSrcAndSwitchToIt(driver, "StoreCardBorrower/?", By.id(PProvidePaymentInfo.firstName_txtbx()));
				paymentScreen = true;
				System.out.println("Switched to the Make A Payment screen");
				
			} catch (Exception e) {

				// close third window
				driver.close();
				
				// switch to second window
				driver.switchTo().window(win2);
				
				// Switch into iFrame
				perform.switchToiFrameByID(driver, "Main");
				
				// Click the request sent link
				perform.click(driver, driver.findElement(By.linkText("request sent")));
				
				// Switch to new window
				Thread.sleep(2000);
				perform.switchToXSiteWindowByTitle(driver, "Enter Payment");
				Thread.sleep(2000);
				
				// Set the 3rd window handle
				win3 = driver.getWindowHandle();
					
			} // end try/catch
			
			tries++;
			
		} // end while
		
		// Wait for First Name textbox
		perform.waitForElementToBeClickable(driver, PProvidePaymentInfo.firstName_txtbx(), "id");
		
		driver.switchTo().window(win3);
		StoredVariables.getwin3().set(driver.getWindowHandle());
		
	} // end openMakeAPaymentPage
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Switch to iFrame</li>
	 * 	<li>Enter first name</li>
	 * 	<li>Enter last name</li>
	 * 	<li>Enter card number</li>
	 * 	<li>Select Month</li>
	 * 	<li>Select Year</li>
	 * 	<li>Enter Billing Zip Code</li>
	 * 	<li>Enter email address</li>
	 * 	<li>Click Submit</li>
	 * 	<li>Verify successful payment</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param cardNumber the card number
	 * @param expMonth the exp month
	 * @param expYear the exp year
	 * @param zip the zip
	 * @param email the email
	 * @throws InterruptedException the interrupted exception
	 */
	// Enter payment on Make A Payment page
	public void enterPaymentOnMakeAPaymentPage (RemoteWebDriver driver, String firstName, String lastName, String cardNumber, String expMonth, String expYear, String zip, String email) throws InterruptedException
	{
		
		ExtentTest test = ExtentTestManager.getTest();
		
		// Switch to iFrame
		perform.waitForIFrames(driver);
		perform.waitForiFrameSrcAndSwitchToIt(driver, "StoreCardBorrower/?", By.id(PProvidePaymentInfo.firstName_txtbx()));
		
		// Enter first name
		perform.type(driver, PProvidePaymentInfo.firstName_txtbx(driver), firstName);
		
		// Enter last name
		perform.type(driver, PProvidePaymentInfo.lastName_txtbx(driver), lastName);
		
		// Enter card number
		perform.type(driver, PProvidePaymentInfo.cardNumber_txtbx(driver), cardNumber);
		
		// Select Month
		perform.selectDropdownOption(driver, PProvidePaymentInfo.month_dropdown(driver), expMonth);
		
		// Select Year
		perform.selectDropdownOption(driver, PProvidePaymentInfo.year_dropdown(driver), expYear);
		
		// Enter Billing Zip Code
		perform.type(driver, PProvidePaymentInfo.billingZipCode_txtbx(driver), zip);
		
		// Enter email address
		perform.type(driver, PProvidePaymentInfo.emailAddress_txtbx(driver), email);
		
		perform.sleep(driver, 2);
		
		// Wait for element to be clickable
		perform.waitForElementToBeClickable(driver, PProvidePaymentInfo.submit_btn(driver));
		
		// Click Submit
		perform.click(driver, PProvidePaymentInfo.submit_btn(driver));
		
		// Wait for the payment to process
		waitForPaymentToProcess(driver);
		
		// Check if payment was made successfully
		String paymentSuccessText = "Thank you for providing your payment information. Charges should appear in 1-3 business days.";
		if (!PProvidePaymentInfo.confirmation_txt(driver).getText().contains(paymentSuccessText)) {
			
			// Ensure Submit button is clickable
			List<WebElement> submit = driver.findElements(By.cssSelector(PProvidePaymentInfo.submit_btn()));
			int i = 1;
			while (submit.size()==0 && i++ <= 15) {
				
				// Check for the Submit button
				submit = driver.findElements(By.cssSelector(PProvidePaymentInfo.submit_btn()));
				
			} // end while
			
			// Click Submit
			perform.click(driver, PProvidePaymentInfo.submit_btn(driver));
			
			// Wait for the payment to process
			waitForPaymentToProcess(driver);
			
		} // end if

		// Verify successful payment
		perform.verification(driver, PProvidePaymentInfo.confirmation_txt(driver).getText(), "contains", paymentSuccessText);			
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Entered a payment on the Make A Payment page using card: " + cardNumber);
		
	} // end enterPaymentOnMakeAPaymentPage
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get the text on the screen and wait for "Loading" to not be displayed</li>
	 * </ul>.
	 *
	 * @param driver the driver
	 * @throws InterruptedException the interrupted exception
	 */
	public void waitForPaymentToProcess (RemoteWebDriver driver) throws InterruptedException {
		
		// Verify the Submit button was clicked
		perform.sleep(driver, 5);
		List<WebElement> submit = driver.findElements(By.cssSelector(PProvidePaymentInfo.submit_btn()));
		if (submit.size()>0) {
			
			// Click Submit
			perform.click(driver, PProvidePaymentInfo.submit_btn(driver));
			
			perform.sleep(driver, 5);
			
		} // end if
		
		// Get out of iFrames
		driver.switchTo().defaultContent();
		
		// Wait for payment to process
		String text = PProvidePaymentInfo.confirmation_txt(driver).getText();
		
		// Wait for the Loading text to go away
		int i = 1;
		while (text.contains("Loading") && i <= 60) {
			
			// Wait for 2 seconds and check the text again
			perform.sleep(driver, 2);
			
			// Capture the screen text
			text = PProvidePaymentInfo.confirmation_txt(driver).getText();
			
			i++;
			
		} // end if
		
	} // end waitForPaymentToProcess
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Close the 3rd window</li>
	 * 	<li>Close the 2nd window</li>
	 * 	<li>Switch to the first window</li>
	 * 	<li>Get the invoice number from the XSite order</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws InterruptedException the interrupted exception
	 */
	// Close Make A Payment and XSite windows
	public void closeMakeAPaymentAndXSiteWindows (RemoteWebDriver driver) throws InterruptedException
	{
		
		// Close the 3rd window
		Thread.sleep(1000);
		driver.switchTo().window(StoredVariables.getwin3().get());
		driver.close();
		Thread.sleep(1000);
		
		// Close the 2nd window
		driver.switchTo().window(StoredVariables.getwin2().get());
		driver.close();
		Thread.sleep(1000);
		
		// Switch to the first window
		driver.switchTo().window(StoredVariables.getwin1().get());
		Thread.sleep(1000);
		
	} // end closeMakeAPaymentAndXSiteWindows
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Open the order</li>
	 * 	<li>Click View XSite order link</li>
	 * 	<li>Switch to new window</li>
	 * 	<li>Switch to iFrame</li>
	 * 	<li>Click Billing</li>
	 * 	<li>Click Invoices</li>
	 * 	<li>Switch to new window</li>
	 * 	<li>Get the new Window Handle</li>
	 * 	<li>Switch to the new window</li>
	 * 	<li>Switch to new frame</li>
	 * 	<li>Get invoice number</li>
	 * 	<li>Close third window</li>
	 * 	<li>Switch back to second window</li>
	 * 	<li>Close second window</li>
	 * 	<li>Switch back to original window</li>
	 * 	<li>Switch out of frame</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param trackingNumber the tracking number
	 * @return the invoice number
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ClassNotFoundException the ClassNotFoundExceptionthe class not found exception
	 * @throws SQLException the SQLExceptionthe SQL exception
	 */
	// Get the invoice number from the XSite order
	public String getInvoiceNumber(RemoteWebDriver driver, String trackingNumber) throws InterruptedException, IOException, ClassNotFoundException, SQLException {

		ExtentTest test = ExtentTestManager.getTest();
		
		String win1 = driver.getWindowHandle();
		
		// Wait for XSite order link
		try {
			perform.waitForElementToBeClickable(driver, SOrderDetails.viewXSiteOrder_lnk(), "id");
		} catch (Exception e) {
			// Open the order
			openOrder(driver, trackingNumber);
		} // end try/catch
		
		// Click View XSite order link
		perform.click(driver, SOrderDetails.viewXSiteOrder_lnk(driver));
		
		// Switch to new window
		perform.switchToXSiteWindowByTitle(driver, "Buesiness Management");
		
		Thread.sleep(5000);
		
		String win2 = driver.getWindowHandle();
		
		// Switch to iFrame
		perform.switchToiFrameByID(driver, "Main");

		// Wait for Billing button
		perform.waitForElementToBeClickable(driver, XBusinessManagement.billing_btn(), "cssSelector");
		
		// Click Billing
		perform.click(driver, XBusinessManagement.billing_btn(driver));
		
		// Click Invoices
		perform.clickLabelText(driver, "Invoice");
		
		// Switch out of iFrame
		driver.switchTo().defaultContent();
		
		// Switch to new window
		perform.switchToXSiteWindowByTitle(driver, "Create an Invoice");
		
		// Get the new Window Handle
	    String win3 = driver.getWindowHandle();
	    
	    Thread.sleep(3000);
		
		// Switch to the new window
		driver.switchTo().window(win3);
		
		System.out.println("TITLE = " + driver.getTitle());
		
		Thread.sleep(3000);
		
		// Switch to new frame
		perform.switchToiFrameBySrc(driver, "Invoice.aspx");
		
		Thread.sleep(3000);
		
		// Wait for Invoice Number textbox
		perform.waitForElementToBeClickable(driver, XInvoice.invoiceNumber_txtbx(), "id");

		// Get invoice number
		String invoiceNumber = XInvoice.invoiceNumber_txtbx(driver).getAttribute("value");
		
		// Close third window
		driver.close();
		
		// Switch back to second window
		driver.switchTo().window(win2);
		
		// Close second window
		driver.close();
		
		// Switch back to original window
		driver.switchTo().window(win1);
		
		// Switch out of frame
		driver.switchTo().defaultContent();
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Got the invoice number: " + invoiceNumber);
		
		return invoiceNumber;
		
	} // end getInvoiceNumber
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click Contact</li>
	 * 	<li>Click Delete</li>
	 * 	<li>Verify delete dialog text</li>
	 * 	<li>Click Yes</li>
	 * 	<li>Verify Contacts Deleted text</li>
	 * 	<li>Click OK</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void deleteContactInClients(RemoteWebDriver driver) throws InterruptedException, IOException
	{
		
		ExtentTest test = ExtentTestManager.getTest();

		// Wait for text in the table
		perform.waitForText(driver, SClients.contactsGrid_txt(driver), "Contact");
		
		// Click Contact
		perform.clickInTable_Contains(driver, "Contact");
		
		// Click Delete
		perform.click(driver, SClients.delete_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for Yes button
		perform.waitForElementToBeClickable(driver, SClients.yesDelete_btn(), "cssSelector");
		
		// Verify delete dialog text
		Assert.assertTrue(SClients.confirmDeleteDialog_txt(driver).getText().contains("Are you sure you want to delete the selected contact(s)?"), "The Confirm Delete dialog text is incorrect");
		
		// Click Yes
		perform.click(driver, SClients.yesDelete_btn(driver));
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SClients.okDelete_btn(), "cssSelector");
		
		// Verify Contacts Deleted text
		Assert.assertTrue(SClients.contactsDeletedDialog_txt(driver).getText().contains("The contacts were successfully deleted."), "The Contacts Deleted dialog text is incorrect");
		
		// Click OK
		perform.click(driver, SClients.okDelete_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Deleted a contact in Clients");
		
	} // end deleteContact
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Agree or Do Not agree to the modification requested</li>
	 * 	<li>Select the I agree radio button</li>
	 * 	<li>Select the I agree radio button</li>
	 * 	<li>Enter comments</li>
	 * 	<li>Click OK</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param agree the agree
	 * @param comments the comments
	 * @throws InterruptedException the interrupted exception
	 */
	public void modificationRequested(RemoteWebDriver driver, boolean agree, String comments) throws InterruptedException {

		ExtentTest test = ExtentTestManager.getTest();
		
		// Agree or Do Not agree to the modification requested
		if (agree == true) {
			// Select the I agree radio button
			perform.click(driver, SOrderDetails.iAgreeToTheRequestedProductModifications_radioBtn(driver));
		} else if (agree == false) {
			// Select the I agree radio button
			perform.click(driver, SOrderDetails.iDoNotAgreeToTheRequestedProductModificationsRequested_radioBtn(driver));
		} // end if/else
		
		// Enter comments
		perform.type(driver, SOrderDetails.commentsToVendorModificationRequested_txtbx(driver), comments);
		
		// Click OK
		perform.click(driver, SOrderDetails.okModificationRequested_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for Find textbox
		perform.waitForElementToBeClickable(driver, SOrders.find_txtbx(), "id");
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Requested a modification: " + comments);
		
	} // end deleteContact
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to login page</li>
	 * 	<li>Enter email</li>
	 * 	<li>Enter password</li>
	 * 	<li>Click Sign In</li>
	 * 	<li>Close dialog</li>
	 * 	<li>Close the dialog</li>
	 * 	<li>Click continue to Mercury network</li>
	 * 	<li>Close the dialog</li>
	 * 	<li>Click the I Agree radio button</li>
	 * 	<li>Select I Agree</li>
	 * 	<li>Click Continue</li>
	 * 	<li>Click on â€œPaymentsâ€� in top navigation</li>
	 * 	<li>Click on â€œTransactionsâ€� tab</li>
	 * 	<li>Click the â€œclick here to enter your merchant account detailsâ€� link</li>
	 * 	<li>Set â€œProcessorâ€� to â€œGlobal Payments (East)â€�</li>
	 * 	<li>Check â€œAMEXâ€� and â€œDiscoverâ€�</li>
	 * 	<li>Enter data into â€œMerchant numberâ€� and â€œAcquirer bin (Bank ID)â€� fields</li>
	 * 	<li>Enter email</li>
	 * 	<li>Submit</li>
	 * 	<li>Verify Information updated text</li>
	 * 	<li>Click Yes</li>
	 * 	<li>Query Merchants.dbo.Accounts using CustomerNumber and verify values are correct based on data entered in Step 6</li>
	 * 	<li>Verify the values are correct</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param env the env
	 * @param user the user
	 * @param password the password
	 * @param custNo the cust no
	 * @throws Exception the exception
	 */
	public void createMerchantAccount(RemoteWebDriver driver, String env, String user, String password, String custNo) throws Exception {

		ExtentTest test = ExtentTestManager.getTest();
		
		String catchAllDomain = StoredVariables.getcatchAllDomain().get();
		
		// Go to login page
		StoredVariables.getsecureSite().set(perform.getSecureSite(env));
		driver.get(StoredVariables.getsecureSite().get());
		
		// Wait for email txtbx
		perform.waitForElementToBeClickable(driver, SLogin.email_txtbx(), "id");
		
		// Enter email
		String email;
		if (user.contains("@"))
		{
			email = user;
			perform.type(driver, SLogin.email_txtbx(driver), user);
		}
		else
		{
			email = "automation" + env + user + catchAllDomain;
			perform.type(driver, SLogin.email_txtbx(driver), email);	
		}
		
		// Enter password
		perform.type(driver, SLogin.password_txtbx(driver), password);
		
		// Click Sign In
		perform.click(driver, SLogin.signIn_btn(driver));
		
		Thread.sleep(2500);
		
		// Close dialog
		try {
			// Close the dialog
			perform.click(driver, driver.findElement(By.cssSelector("img[src='/images/DialogCloseButton.png']")));
		}
		catch(Exception e){}
		
		// Click continue to Mercury network
		try{
			perform.click(driver, driver.findElement(By.id("lnkContinueAppraiser")));
		}
		catch (Exception e){}
		
		try {
			// Close the dialog
			perform.click(driver, driver.findElement(By.cssSelector("img[src='/images/DialogCloseButton.png']")));
		} catch (Exception e) {
		}
		
		// Click the I Agree radio button
		try{
			
			// Select I Agree
			perform.click(driver, SSignUp.iAgree_radiobtn(driver));
			
			// Click Continue
			perform.click(driver, SSignUp.continue_btn(driver));
			
		}
		catch (Exception e) {}
		
		// Click on â€œPaymentsâ€� in top navigation
		perform.click(driver, SOrders.paymentsTab_btn(driver));
		
		// Wait for Loan # textbox
		perform.waitForElementToBeClickable(driver, SPayments.loanNumber_txtbx(), "id");
		
		// Click on â€œTransactionsâ€� tab
		perform.click(driver, SPayments.transactions_btn(driver));
		
		// Wait for the link
		perform.waitForElementToBeClickable(driver, "click here to enter your merchant account details.", "linkText");
		
		// Click the â€œclick here to enter your merchant account detailsâ€� link
		perform.click(driver, driver.findElement(By.linkText("click here to enter your merchant account details.")));
		
		// Switch into iFrame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "/Common/Accounting/MerchantInformation.aspx", By.id(SPayments.processor_dropdown()));
		
		// Wait for the processor dropdown
		perform.waitForElementToBeClickable(driver, SPayments.processor_dropdown(), "id");
		
		// Set â€œProcessorâ€� to â€œGlobal Payments (East)â€�
		perform.selectDropdownOption(driver, SPayments.processor_dropdown(driver), "Global Payments (East)");
		
		// Check â€œAMEXâ€� and â€œDiscoverâ€�
		perform.checkCheckbox(driver, SPayments.amex_chkbx(driver));
		perform.checkCheckbox(driver, SPayments.discover_chkbx(driver));
		
		// Enter data into â€œMerchant numberâ€� and â€œAcquirer bin (Bank ID)â€� fields
		String merchantNumber = perform.randomNumbers(driver, 15);
		String acquirerNumber = perform.randomNumbers(driver, 6);
		perform.type(driver, SPayments.merchantNumber_txtbx(driver), merchantNumber);
		perform.type(driver, SPayments.acquirerBin_txtbx(driver), acquirerNumber);
		
		// Enter email
		perform.type(driver, SPayments.email_txtbx(driver), email);
		
		// Submit
		perform.click(driver, SPayments.submit_btn(driver));
		
		// Wait for Yes button
		perform.waitForElementToBeClickable(driver, SPayments.yes_btn(), "id");
		
		// Verify Information updated text
		String infoUpdatedText = SPayments.informationUpdated_txt(driver).getText();
		Assert.assertTrue(infoUpdatedText.contains("Processing merchant account changes will take 4-5 business days. Your current merchant account settings will be used until processing is complete. Do you wish to submit your changes?"), "The dialog is incorrect. Dialog = " + infoUpdatedText);
		
		// Click Yes
		perform.click(driver, SPayments.yes_btn(driver));
		
		// Switch out of iFrame
		driver.switchTo().defaultContent();
		
		// Wait for the transaction page
		perform.waitForElementToBeClickable(driver, SPayments.transactionPage_txt(), "id");
		
		// Wait for information to be received
		String text = "";
		while(!text.contains("Information received"))
		{
			Thread.sleep(2000);
			text = SPayments.transactionPage_txt(driver).getText();
		} // end while
		Assert.assertTrue(text.contains("Information received!"), "The transaction page never reflected the information was received. On screen text = " + text);
		
		// Query Merchants.dbo.Accounts using CustomerNumber and verify values are correct based on data entered in Step 6
		ArrayList<String> results = null;
		results = db.getMerchantAccountInfoToArray(driver, custNo);
		String merchant = results.get(0);
		String amex = results.get(1);
		String discover = results.get(2);
		
		// Verify the values are correct
		Assert.assertTrue(merchant.equals(merchantNumber), "Active is not set properly in the DB. It should be set to "+merchantNumber+", but is set to " + merchant);
		Assert.assertTrue(amex.equals("1"), "Autopay is not set properly in the DB. It should be set to 1, but is set to " + amex);
		Assert.assertTrue(discover.equals("1"), "Days is not set properly in the DB. It should be set to 1, but is set to " + discover);
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Created a merchant account for " + user + "<br>Customer Number: " + custNo);
		
	} // end createMerchantAccount
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to Secure site</li>
	 * 	<li>Click Sign Up</li>
	 * 	<li>Select Type of Account</li>
	 * 	<li>Select State</li>
	 * 	<li>Enter Company Name</li>
	 * 	<li>Enter Phone Number</li>
	 * 	<li>Enter Email Address</li>
	 * 	<li>Verify email gets entered correctly</li>
	 * 	<li>Click Next</li>
	 * 	<li>Enter First Name</li>
	 * 	<li>Enter Last Name</li>
	 * 	<li>Enter Address</li>
	 * 	<li>Enter City</li>
	 * 	<li>Enter Zip</li>
	 * 	<li>Enter Appraisal Volume per Month</li>
	 * 	<li>Enter Password</li>
	 * 	<li>Enter Confirm Password</li>
	 * 	<li>Click Next</li>
	 * 	<li>Verify user created successfully</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param typeOfAccount the type of account
	 * @param state the state
	 * @param company the company
	 * @param custNo the cust no
	 * @param email the email
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param address the address
	 * @param city the city
	 * @param zip the zip
	 * @param password the password
	 * @throws InterruptedException the interrupted exception
	 */
	public void signupNewSecureUser(RemoteWebDriver driver, String typeOfAccount, String state, String company, String custNo, String email, String firstName,
			String lastName, String address, String city, String zip, String password) throws InterruptedException {

		// Go to Secure site
		driver.get(StoredVariables.getsecureSite().get());
		
		// Wait for email field
		perform.waitForElementToBeClickable(driver, SLogin.email_txtbx(), "id");
		
		// Click Sign Up
		perform.click(driver, SLogin.signUp_btn(driver));
		
		// Wait for company name textbox
		perform.waitForElementToBeClickable(driver, SSignUp.companyName_textbox(), "id");
		
		// Select Type of Account
		perform.selectDropdownOption(driver, SSignUp.typeOfAccount_dropdown(driver), typeOfAccount);
		
		// Select State
		perform.selectDropdownOption(driver, SSignUp.state_dropdown(driver), state);
		
		// Enter Company Name
		perform.type(driver, SSignUp.companyName_textbox(driver), company);
		
		// Enter Phone Number
		perform.type(driver, SSignUp.phoneNumber_textbox(driver), custNo);
		
		// Enter Email Address
		perform.type(driver, SSignUp.emailAddress_textbox(driver), email);
		
		// Verify email gets entered correctly
		String enteredText = SSignUp.emailAddress_textbox(driver).getAttribute("value");
		Thread.sleep(1000);
		System.out.println("enteredText = " + enteredText);
		while (!enteredText.equals(email))
		{
			perform.type(driver, SSignUp.emailAddress_textbox(driver), email);
			enteredText = SSignUp.emailAddress_textbox(driver).getAttribute("value");
		} // end while
		
		// Click Next
		perform.click(driver, SSignUp.next_btn(driver));
		
		// Wait for First Name text box
		perform.waitForElementToBeClickable(driver, SSignUp.firstName_txtbx(), "id");
		
		// Enter First Name
		perform.type(driver, SSignUp.firstName_txtbx(driver), firstName);
		
		// Enter Last Name
		perform.type(driver, SSignUp.lastName_txtbx(driver), lastName);
		
		// Enter Address
		perform.type(driver, SSignUp.address_txtbx(driver), address);
		
		// Enter City
		perform.type(driver, SSignUp.city_txtbx(driver), city);
		
		// Enter Zip
		perform.type(driver, SSignUp.zip_txtbx(driver), zip);
		
		// Enter Appraisal Volume per Month
		perform.selectDropdownOption(driver, SSignUp.appraisalVolumePerMonth_dropdown(driver), "5000 or more");
		
		// Enter Password
		perform.type(driver, SSignUp.password_txtbx(driver), password);
		
		// Enter Confirm Password
		perform.type(driver, SSignUp.confirmPassword_txtbx(driver), password);
		
		// Click Next
		perform.click(driver, SSignUp.next_btn_EnterAccountInfo(driver));
		
		// Wait for confirmation text
		perform.waitForElementToBeClickable(driver, SSignUp.confirmation_txt(), "id");
		
		// Verify user created successfully
		Assert.assertTrue(SSignUp.confirmation_txt(driver).getText().contains("Congrats"), "User was not created successfully");
		
	} // end signupNewSecureUser
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to Vendor Selection Settings</li>
	 * 	<li>Select Custom Fee Panel</li>
	 * 	<li>Uncheck Use Mercury Network Directory as backup checkbox</li>
	 * 	<li>Verify Mercury Network Directory as backup is unchecked</li>
	 * 	<li>Check Set Default Order Expiration Time</li>
	 * 	<li>Check Pay All Transaction Fees</li>
	 * 	<li>Save Preferences</li>
	 * 	<li>Click OK in saved dialog box</li>
	 * </ul>
	 *
	 * @param driver the new default vendor selection settings
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void setDefaultVendorSelectionSettings(RemoteWebDriver driver) throws InterruptedException, IOException {

		// Go to Vendor Selection Settings
		goToVendorSelectionSettings(driver);

		// Select Custom Fee Panel
		perform.click(driver, SVendorSelectionSettings.customFeePanel_radio(driver));
		
		// Uncheck Use Mercury Network Directory as backup checkbox
		if (SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver).isSelected())
		{
			perform.click(driver, SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver));
		}
		
		// Verify Mercury Network Directory as backup is unchecked
		Assert.assertTrue(SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver).isSelected()==false, "Mercury Network Directory as backup is still checked");
		
		// Check Set Default Order Expiration Time
		if (!SVendorSelectionSettings.setDefaultOrderExpirationTime_chkbx(driver).isSelected())
		{
			perform.click(driver, SVendorSelectionSettings.setDefaultOrderExpirationTime_chkbx(driver));
		}
		
		// Check Pay All Transaction Fees
		if (!SVendorSelectionSettings.payAllTransactionFees_chkbx(driver).isSelected())
		{
			perform.click(driver, SVendorSelectionSettings.payAllTransactionFees_chkbx(driver));
		}
		
		// Save Preferences
		perform.click(driver, SVendorSelectionSettings.save_btn(driver));
		
		// Wait for the OK button
		perform.waitForElementToBeClickable(driver, SVendorSelectionSettings.ok_btn(), "id");
		
		// Click OK in saved dialog box
		perform.click(driver, SVendorSelectionSettings.ok_btn(driver));
		
		// Wait for Preferences button
		perform.waitForElementToBeClickable(driver, SOrders.preferences_btn(), "id");
		
	} // end setDefaultVendorSelectionSettings
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to Users</li>
	 * 	<li>Verify Compliance is unchecked</li>
	 * 	<li>Check Auto Assignment Approval</li>
	 * 	<li>Click Save</li>
	 * </ul>
	 *
	 * @param driver the new default users settings
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void setDefaultUsersSettings(RemoteWebDriver driver) throws InterruptedException, IOException {

		// Go to Users
		goToUsers(driver);
		
		// Verify Compliance is unchecked
		if (SUsers.compliance_chkbx(driver).isSelected())
		{
			perform.click(driver, SUsers.compliance_chkbx(driver));
		}
		
		// Check Auto Assignment Approval
		if (!SUsers.autoAssignmentApproval_chkbx(driver).isSelected())
		{
			perform.click(driver, SUsers.autoAssignmentApproval_chkbx(driver));
		}
		
		// Click Save
		perform.click(driver, SUsers.save_btn(driver));
		
		// Wait for Fee Panel
		perform.waitForElementToBeClickable(driver, SOrders.feePanel_btn(), "cssSelector");
		
	} // end setDefaultUsersSettings
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to Product</li>
	 * 	<li>Scroll element into focus</li>
	 * 	<li>Click in the field</li>
	 * 	<li>Click Save</li>
	 * 	<li>Click OK</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param fee the fee
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Enter Product Fees
	public void enterProductFees(RemoteWebDriver driver, String fee) throws InterruptedException, IOException {
		
		// Go to Product 
		goToProductRequirements(driver);
		
		List<WebElement> fees = driver.findElements(By.cssSelector("td.ProductFee"));
		
		for(WebElement el : fees) 
		{

			// Scroll element into focus
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].scrollIntoView()", el); 
			
			// Click in the field
			perform.click(driver, el);

			Thread.sleep(500);
			
			el.sendKeys(fee);
			
		} // end for loop
		
		// Click Save
		perform.click(driver, SProductRequirements.save_btn(driver));
		
		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SProductRequirements.ok_btn(), "cssSelector");
		
		// Click OK
		perform.click(driver, SProductRequirements.ok_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		System.out.println("*** FEES HAVE BEEN UPDATED ***");
		
	} // end enterProductFees
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Check if the link is visible</li>
	 * 	<li>If the link is visible, click it</li>
	 * 	<li>Add default products</li>
	 * 	<li>Click Save</li>
	 * 	<li>Click OK</li>
	 * 	<li>Try to clear the dialog</li>
	 * 	<li>Click OK</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	// Add default products to XSite
	public void addDefaultProductsToXSite(RemoteWebDriver driver) throws IOException, InterruptedException {
		
		// Check if the link is visible
		int link = driver.findElements(By.linkText("click here to add the default products.")).size();
		
		// If the link is visible, click it
		if (link>0) {
			try
			{
				// Add default products
				perform.click(driver, driver.findElement(By.linkText("click here to add the default products.")));
				
				// Wait for save
				perform.waitForElementToBeClickable(driver, SVMPXSites.save_btn(), "cssSelector");
				
				// Click Save
				perform.click(driver, SVMPXSites.save_btn(driver));
				
				// Wait for overlay
				perform.waitForOverlayToBeVisible(driver);
				
				// Wait for OK button
				perform.waitForElementToBeClickable(driver, SVMPXSites.saveCompleteOK_btn(), "cssSelector");
				
				// Click OK
				perform.click(driver, SVMPXSites.saveCompleteOK_btn(driver));
				
				// Wait for busy to be hidden
				perform.waitForBusyToBeHidden(driver);
			}
			catch (Exception e){
				System.out.println("The link could not be clicked");
			} // end try/catch
		} // end if
		
		// Try to clear the dialog
		try {
			// Click OK
			perform.click(driver, SVMPXSites.saveCompleteOK_btn(driver));
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
		} catch (Exception e) {}
		
	} // end addDefaultProductsToXSite
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Catch Save changes</li>
	 * 	<li>Click Business Management</li>
	 * 	<li>Catch Save changes dialog</li>
	 * 	<li>Click Yes</li>
	 * 	<li>Click Business Management</li>
	 * 	<li>Click OK</li>
	 * 	<li>Click Business Management</li>
	 * 	<li>Get the Window Handle before the new window opens</li>
	 * 	<li>Go to new window</li>
	 * 	<li>Get the Window Handle before the new window opens</li>
	 * 	<li>Get outside frames</li>
	 * 	<li>Get inside the attach document frame</li>
	 * 	<li>driver.switchTo().frame(driver.findElement(By.xpath("iframe[contains(@src,'LeftNav.aspx')]")));</li>
	 * 	<li>Click Fee Setup</li>
	 * 	<li>Get outside frames</li>
	 * 	<li>Get inside the attach document frame</li>
	 * 	<li>driver.switchTo().frame(driver.findElement(By.xpath("iframe[contains(@src,'Blank.htm')]")));</li>
	 * 	<li>Check Allow clients to create accounts</li>
	 * 	<li>Check Allow clients to enter fee</li>
	 * 	<li>Switch iFrame</li>
	 * 	<li>Click on 1004 Full/URAR</li>
	 * 	<li>Click Add arrow</li>
	 * 	<li>Switch out of iframe</li>
	 * 	<li>Close window</li>
	 * 	<li>Switch back to original window</li>
	 * </ul>
	 *
	 * @param driver the new default X site settings
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	// Set default XSite settings
	public void setDefaultXSiteSettings(RemoteWebDriver driver) throws IOException, InterruptedException {

		
		// Catch Save changes
		try {
			// Click Business Management
			perform.click(driver, driver.findElement(By.linkText("Business Management")));
		} catch (Exception e) {
			// Catch Save changes dialog
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			// Click Yes
			perform.click(driver, driver.findElement(By.cssSelector("input[type='button'][value='Yes'][onclick='javascript:btnSaveChangesYes_Click();']")));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			// Click Business Management
			try {
				perform.click(driver, driver.findElement(By.linkText("Business Management")));
			} catch (Exception e2) {
				// Click OK
				perform.click(driver, SVMPXSites.saveCompleteOK_btn(driver));
				// Wait for overlay to be hidden
				perform.waitForOverlayToBeHidden(driver);
				// Click Business Management
				perform.click(driver, driver.findElement(By.linkText("Business Management")));
			}
		} // end try/catch
		
		// Get the Window Handle before the new window opens
		StoredVariables.getwinHandleBefore().set(driver.getWindowHandle());
		System.out.println("winHandleBefore = " + StoredVariables.getwinHandleBefore().get());
		
		// Go to new window
	    RemoteWebDriver popup = null;
	    Iterator<String> windowIterator = driver.getWindowHandles()
	            .iterator();
	    while (windowIterator.hasNext()) {
	        String windowHandle1 = windowIterator.next();
	        popup = (RemoteWebDriver) driver.switchTo().window(windowHandle1);
	        String title = popup.getTitle();
	        System.out.println("title = " + title);
	        if (title.contains("Business Management")) {
	        	System.out.println("break");
	            break;
	        } // end if
	    } // end while loop
	    
		// Get the Window Handle before the new window opens
		StoredVariables.getnewWinHandle().set(driver.getWindowHandle());
		System.out.println("newWinHandle = " + StoredVariables.getnewWinHandle().get());
		
		// Get outside frames
		driver.switchTo().defaultContent();
		// Get inside the attach document frame
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'LeftNav.aspx')]")));
		
		Thread.sleep(3000);
		
		// Click Fee Setup
		perform.clickInTable_Contains(driver, "Fees Setup");
		
		Thread.sleep(2000);
		
		// Get outside frames
		driver.switchTo().defaultContent();
		// Get inside the attach document frame
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'Blank.htm')]")));
		
		perform.waitForElementToBeClickable(driver, SVMPXSitesBusinessManagement.allowClientsToCreateAccounts_chkbx(driver));
		
		// Check Allow clients to create accounts
		if (!SVMPXSitesBusinessManagement.allowClientsToCreateAccounts_chkbx(driver).isSelected())
		{
			perform.waitForElementToBeClickable(driver, SVMPXSitesBusinessManagement.allowClientsToCreateAccounts_chkbx(driver));
			perform.click(driver, SVMPXSitesBusinessManagement.allowClientsToCreateAccounts_chkbx(driver));
		}	
		
		// Check Allow clients to enter fee
		if (!SVMPXSitesBusinessManagement.allowClientsToEnterFee_chkbx(driver).isSelected())
		{
			perform.waitForElementToBeClickable(driver, SVMPXSitesBusinessManagement.allowClientsToEnterFee_chkbx(driver));
			perform.click(driver, SVMPXSitesBusinessManagement.allowClientsToEnterFee_chkbx(driver));
		}
		
		// Switch iFrame
		driver.switchTo().defaultContent();
		perform.switchToiFrameByID(driver, "Main");
		
		// Click on 1004 Full/URAR
		perform.clickInTable_Equals(driver, "1004 Full/URAR");
		
		// Click Add arrow
		perform.click(driver, SVMPXSitesBusinessManagement.addToAvailableProducts_btn(driver));
		
		// Switch out of iframe
		driver.switchTo().defaultContent();
		
		// Close window
		driver.close();
		
		// Switch back to original window
		driver.switchTo().window(StoredVariables.getwinHandleBefore().get());
		
	} // end setDefaultXSiteSettings
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login</li>
	 * 	<li>Set default Vendor Selection Settings</li>
	 * 	<li>Set default Users settings</li>
	 * 	<li>Go to Fee Panel</li>
	 * 	<li>Check if the order group already exists, if it does, delete it</li>
	 * 	<li>Delete the TestOrderGroup Order Groups</li>
	 * 	<li>Add order group</li>
	 * 	<li>Add Vendor</li>
	 * 	<li>Add Vendor</li>
	 * 	<li>Enter Product Fees</li>
	 * 	<li>Click Account</li>
	 * 	<li>Add credit card</li>
	 * 	<li>Go to VMP XSites</li>
	 * 	<li>Add Default Products</li>
	 * 	<li>Go to VMP XSites</li>
	 * 	<li>Allow clients to create accounts</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param user the user
	 * @param password the password
	 * @param custNo the cust no
	 * @param env the env
	 * @param phonePrefix the phone prefix
	 * @throws Exception the exception
	 */
	// Set up a new user using default settings
	public void setUpNewUserDefaults(RemoteWebDriver driver, String user, String password, String custNo, String env, String phonePrefix) throws Exception {
		
		// Login
		loginFirstTime(driver, user, password, env);
		
		// Set default Vendor Selection Settings
		setDefaultVendorSelectionSettings(driver);

		// Set default Users settings
		setDefaultUsersSettings(driver);
		
		// Go to Fee Panel
		goToFeePanel(driver);
		
		// Check if the order group already exists, if it does, delete it
		// Delete the TestOrderGroup Order Groups
		secure.deleteOrderGroup(driver, "AppraisersGroupTest");
		
		// Add order group
		addNewOrderGroup(driver, "AppraisersGroupTest");

		// Add Vendor
		addVendorToFeePanel(driver, "phone", phonePrefix+"0001", "Appraiser1");
		
		// Add Vendor
		addVendorToFeePanel(driver, "phone", phonePrefix+"0003", "Appraiser3");	
		
		// Enter Product Fees
		enterProductFees(driver, "500");
		
		// Click Account
		goToAccount(driver);
		
		// Add credit card
		String creditCardNumber = "4111111111111111";
		addTestCreditCard(driver, creditCardNumber, false);
		
		// Go to VMP XSites
		goToVMPXSites(driver);
		
		// Add Default Products
		addDefaultProductsToXSite(driver);
		
		// Go to VMP XSites
		goToVMPXSites(driver);
		
		// Allow clients to create accounts
		setDefaultXSiteSettings(driver);
		
		// Enable all products
		enableAllProducts(driver);
		
	} // end setUpNewUserDefaults
	
	/**
	 * Enable all products in VMP XSites
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to VMP XSites</li>
	 * 	<li>Activate the new product</li>
	 * 	<li>Get the style attribute of the element</li>
	 * 	<li>If the style contains hidden, enable the product</li>
	 * 	<li>Enable the product</li>
	 * 	<li>Click the parent element</li>
	 * 	<li>Save settings</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	public void enableAllProducts(RemoteWebDriver driver) throws IOException, InterruptedException {
		
		// Go to VMP XSites
		goToVMPXSites(driver);
		
		// Activate the new product
		List<WebElement> product = driver.findElements(By.cssSelector("#Main_Main_Main_grdProductMappings > table > tbody > tr > td > table > tbody:nth-child(2) > tr > td > div:nth-child(2) > table > tbody > tr > td > img"));
		for (WebElement el : product) {
			// Get the style attribute of the element
			String style = el.getAttribute("style");
			System.out.println("style = " + style);
			// If the style contains hidden, enable the product
			if (style.contains("hidden")) {
				// Enable the product
				// Click the parent element
				WebElement parent = el.findElement(By.xpath(".."));
				perform.click(driver, parent);
			} // end if
		} // end for
		
		// Save settings
		saveVMPXSiteSettings(driver);
		
	} // end enableAllProducts
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to Secure site</li>
	 * 	<li>Go to Users</li>
	 * 	<li>Click Create New User</li>
	 * 	<li>Set the subuser's email address</li>
	 * 	<li>Enter the subuser's email address</li>
	 * 	<li>Verify email gets entered correctly</li>
	 * 	<li>Click in the Password field</li>
	 * 	<li>Enter New password</li>
	 * 	<li>Enter Confirm password</li>
	 * 	<li>Click Save</li>
	 * 	<li>Enter First Name</li>
	 * 	<li>Enter Last Name</li>
	 * 	<li>Save</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param env the env
	 * @param user the user
	 * @param password the password
	 * @throws Exception the exception
	 */
	// Create sub user
	public void createSubUser(RemoteWebDriver driver, String env, String user, String password) throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		
		// Go to Secure site
		login(driver, user, password, env);
		
		// Go to Users
		goToUsers(driver);
		
		// Click Create New User
		perform.click(driver, SUsers.createNewUser_btn(driver));
		
		// Wait for email field
		perform.waitForElementToBeClickable(driver, SUsers.primaryEmail_txtbx(), "id");
		
		// Set the subuser's email address
		String subUsersEmail = "automation" + env + user + "SU" + StoredVariables.getcatchAllDomain().get();
		
		Thread.sleep(3000);
		
		// Enter the subuser's email address
		perform.type(driver, SUsers.primaryEmail_txtbx(driver), subUsersEmail);
		
		// Verify email gets entered correctly
		String enteredText = SUsers.primaryEmail_txtbx(driver).getAttribute("value");
		Thread.sleep(1000);
		System.out.println("enteredText = " + enteredText);
		while (!enteredText.equals(subUsersEmail))
		{
			perform.type(driver, SUsers.primaryEmail_txtbx(driver), subUsersEmail);
			enteredText = SUsers.primaryEmail_txtbx(driver).getAttribute("value");
		} // end while
		
		// Click in the Password field
		perform.click(driver, SUsers.password_txtbx(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for New password textbox
		perform.waitForElementToBeClickable(driver, SUsers.passwordSecurityOptions_txtbx(), "id");
		
		// Enter New password
		perform.type(driver, SUsers.passwordSecurityOptions_txtbx(driver), password);
		
		// Enter Confirm password
		perform.type(driver, SUsers.confirmPasswordSecurityOptions_txtbx(driver), password);
		
		// Click Save
		perform.click(driver, SUsers.saveSecurityOptions_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Enter First Name
		perform.type(driver, SUsers.firstName_txtbx(driver), "Automation");
		
		// Enter Last Name
		perform.type(driver, SUsers.lastName_txtbx(driver), user + "SU");
		
		// Save
		perform.click(driver, SUsers.save_btn(driver));
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Created a subuser: " + user);
		
	} // end createSubUser
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click Assign</li>
	 * 	<li>Get number of vendors passed in</li>
	 * 	<li>Loop through each vendor and add them</li>
	 * 	<li>Select vendor</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param vendorsToAssign the vendors to assign
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Assign vendors to bid order
	public void assignVendorsToBidOrder(RemoteWebDriver driver, String[] vendorsToAssign) throws InterruptedException, IOException {
		
		ExtentTest test = ExtentTestManager.getTest();
		
		// Click Assign
		perform.click(driver, SOrderDetails.assign_btn(driver));

		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Close Related Orders popup
		checkForRelatedOrdersDialog(driver);

		// Wait for Fee Panel tab
		perform.waitForElementToBeClickable(driver, SVendorSelection.feePanelTab_tab(), "id");
		
		// Get number of vendors passed in
		int size = vendorsToAssign.length;
		
		// Loop through each vendor and add them
		for (int i = 0; i < size; i++) {
			
			// Select vendor
			perform.clickInTable_Contains(driver, vendorsToAssign[i]);
			
			// Wait for the vendor to be added to the Selected vendors table
			perform.waitForText(driver, SVendorSelection.selectedVendorsTable_txt(driver), vendorsToAssign[i]);
			
			Thread.sleep(3000);
			
		} // end for loop
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Assigned vendors to bid order: " + vendorsToAssign);
		
	} // end assignVendorsToBidOrder
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click Review Bids</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Review bids
	public void reviewBids(RemoteWebDriver driver) throws InterruptedException, IOException {

		// Click Review Bids
		perform.click(driver, SOrderDetails.reviewBids_btn(driver));

		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Switch into iFrame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "Bidding/Review.aspx", By.id(SReviewBids.closeReviewBids_btn()));
		
	} // end reviewBids
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get number of vendors passed in</li>
	 * 	<li>Loop through each vendor and add them</li>
	 * 	<li>Select vendor</li>
	 * 	<li>Click Send message</li>
	 * 	<li>Enter message</li>
	 * 	<li>Click Send</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param vendorsToSendMessageTo the vendors to send message to
	 * @param message the message
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Send a message to vendors Review bids
	public void sendAMessageToVendorsInReviewBids(RemoteWebDriver driver, String[] vendorsToSendMessageTo, String message) throws InterruptedException, IOException {

		ExtentTest test = ExtentTestManager.getTest();
		
		// Get number of vendors passed in
		int size = vendorsToSendMessageTo.length;
		
		// Loop through each vendor and add them
		for (int i = 0; i < size; i++) {
			// Select vendor
			perform.clickInTable_Contains(driver, vendorsToSendMessageTo[i]);
			Thread.sleep(1000);
		} // end for loop
		
		// Click Send message
		perform.click(driver, SReviewBids.sendMessage_btn(driver));
		
		// Wait for message
		perform.waitForElementToBeClickable(driver, SReviewBids.messageSendMessage_txtbx(driver));
		
		// Enter message
		perform.type(driver, SReviewBids.messageSendMessage_txtbx(driver), message);
		
		// Click Send
		perform.click(driver, SReviewBids.sendSendMessage_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for the Close button
		perform.waitForElementToBeClickable(driver, SReviewBids.closeReviewBids_btn(driver));
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Sent message to vendors: " + vendorsToSendMessageTo);
		
	} // end sendAMessageToVendorsInReviewBids
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>De-select all vendors</li>
	 * 	<li>Select vendor</li>
	 * 	<li>Click Award bid</li>
	 * 	<li>Switch to award iFrame</li>
	 * 	<li>Enter award note</li>
	 * 	<li>Enter decline note</li>
	 * 	<li>Select Payment Method</li>
	 * 	<li>Click Award</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param vendorToAwardBidTo the vendor to award bid to
	 * @param awardNote the award note
	 * @param declineNote the decline note
	 * @param paymentMethod the payment method
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Award bid
	public void awardBid(RemoteWebDriver driver, String vendorToAwardBidTo, String awardNote, String declineNote, String paymentMethod) throws InterruptedException, IOException {

		ExtentTest test = ExtentTestManager.getTest();
		
		// De-select all vendors
		try {
			perform.click(driver, driver.findElement(By.linkText("None")));
			Thread.sleep(1000);
		} catch (Exception e) {
			reviewBids(driver);
			perform.click(driver, driver.findElement(By.linkText("None")));
			Thread.sleep(1000);
		} // end try/catch
		
		// Select vendor
		perform.clickInTable_Contains(driver, vendorToAwardBidTo);
		
		// Click Award bid
		perform.click(driver, SReviewBids.awardBid_btn(driver));
		
		// Switch to award iFrame
		driver.switchTo().defaultContent();
		perform.waitForiFrameSrcAndSwitchToIt(driver, "Bidding/Award.aspx", By.id(SReviewBids.awardNote_txtbx()));
		
		// Wait for Award note textbox
		perform.waitForElementToBeClickable(driver, SReviewBids.awardNote_txtbx(driver));
		
		// Enter award note
		perform.type(driver, SReviewBids.awardNote_txtbx(driver), awardNote);
		
		// Enter decline note
		perform.type(driver, SReviewBids.declineNote_txtbx(driver), declineNote);
		
		// Select Payment Method
		if (!paymentMethod.isEmpty()) {
			perform.selectDropdownOption(driver, SReviewBids.paymentMethod_dropdown(driver), paymentMethod);
			
		} // end if
		
		// Click Award
		perform.click(driver, SReviewBids.award_btn(driver));
		
		// Switch out of iFrames
		driver.switchTo().defaultContent();
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for the Close button
		perform.waitForElementToBeClickable(driver, SOrderDetails.close_btn(driver));
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Awarded bid to: " + vendorToAwardBidTo);
		
	} // end awardBid
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click the Zillow link</li>
	 * 	<li>Switch to new window</li>
	 * 	<li>Get the url of the new window</li>
	 * 	<li>Verify the url</li>
	 * 	<li>Close the new window</li>
	 * 	<li>Switch back to the main window</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws InterruptedException the interrupted exception
	 */
	public void verifyZillowLink(RemoteWebDriver driver) throws InterruptedException {
		
		// Click the Zillow link
		perform.click(driver, SOrderDetails.zillow_lnk(driver));
		
		// Switch to new window
		perform.switchToXSiteWindowByTitle(driver, "Zillow");
		
		// Get the url of the new window
		String newURL = driver.getCurrentUrl();
		
		// Wait for Zillow to load
		int a = 1;
		while (!newURL.contains("zillow.com") && a <= 30) {
			Thread.sleep(1000);
			newURL = driver.getCurrentUrl();
			a++;
		} // end while
		
		// Verify the url
		Assert.assertTrue(newURL.contains("zillow.com"), "The url should be Zillow");
		
		// Close the new window
		driver.close();
		
		// Switch back to the main window
		driver.switchTo().window(StoredVariables.getwinHandleBefore().get());
		
	} // end verifyZillowLink
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click Modify selection settings</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws InterruptedException the interrupted exception
	 */
	// openModifySelectionSettingsFromNewOrder
	public void openModifySelectionSettingsFromNewOrder(RemoteWebDriver driver) throws InterruptedException {

		// Click Modify selection settings
		perform.click(driver, SNewOrder.modifySelectionSettings_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SModifySelectionSettings.ok_btn(driver));
		
	} // end openModifySelectionSettingsFromNewOrder
	
	/**
	 * Check a Payments grid column to display an expected value
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the grid data to an array</li>
	 * 	<li>Get the column text of the column passed in as a param from the array</li>
	 * 	<li>Enter a while loop if the expected text is not in the column</li>
	 * 	<li>If the expected text is not displayed , refresh the screen</li>
	 * 	<li>Search for the loan number again</li>
	 * 	<li>Check to see if the expected text is now displayed, if it is not, continue the while loop</li>
	 * </ul>
	 * @param driver the driver
	 * @param loanNumber The loan number of the payment you are looking for
	 * @param column The column you want to check the data of
	 * @param expectedText The text that you are expecting to be displayed in the column
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	public void waitForPaymentsColumnToBeValue (RemoteWebDriver driver, String loanNumber, String column, String expectedText) throws IOException, InterruptedException {

		// Get table data
		ArrayList<String> orderSummary = perform.getAllTableData(driver, SPayments.grid_txt());
		
		// Set the column text on the screen
		int index = 0;
		if (column.equals("Issue date")) {
			index = 11;
		}
		String columnText = orderSummary.get(index);
		
		int i = 1;
		while (!columnText.contains(expectedText) && i <=10) {
			
			Thread.sleep(5000);
			
			// Refresh the screen
			driver.navigate().refresh();
			
			// Wait for Loan # textbox
			perform.waitForElementToBeClickable(driver, SPayments.loanNumber_txtbx(driver));
			
			// Search for the loan #
			searchForPaymentsInOrderSummaryByLoanNumber(driver, loanNumber);
			
			// Get the grid text
			try {
				orderSummary = perform.getAllTableData(driver, SPayments.grid_txt());
			} catch (StaleElementReferenceException e) {
				orderSummary = perform.getAllTableData(driver, SPayments.grid_txt());
			} // end try/catch
			
			// Get the column text
			columnText = orderSummary.get(index);
			
			i++;
			
		} // end while
		
	} // end waitForPaymentsColumnToBeValue
	
	/**
	 * Set default settings for Secure users placing a Payments order
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Go to Vendor Selection Settings to turn off all Residential appraisal selection settings</li>
	 * 	<li>Go to VMP XSites &gt; Configure Order Form to check 'Allow clients to enter fee' and enable global login</li>
	 * 	<li>Go to Configure Automatic Settings to use the VMP XSite fee, check 'Created invoice when order is placed', check
	 * 'Attach invoice when credit card is charged', check 'Attach invoice when order is marked complete' and check 'Use tracking
	 *  number'</li>
	 * </ul>
	 * @param driver the driver
	 * @param user The email address used to login to Secure
	 * @param password The password for the user
	 * @throws Exception the exception
	 */
	public void setDefaultSettingsForPaymentsTests (RemoteWebDriver driver, String user, String password) throws Exception {
		
		// Log in to Secure
		login(driver, user, password);
		
		// Go to Vendor Selection Settings
		goToVendorSelectionSettings(driver);
		
		// Turn off all Residential appraisal selection settings
		turnOffAllResidentialAppraisalSelectionSettings(driver);
		
		// Go to XSite settings
		goToVMPXSites(driver);
		
		// Click Configure Order Form
		perform.click(driver, SVMPXSites.configureOrderForm_lnk(driver));
		
		// Wait for Allow clients to enter fee checkbox
		perform.waitForElementToBeClickable(driver, SVMPXSites.allowClientsToEnterFee_chkbx(), "id");
		
		// Check Allow clients to enter fee
		perform.checkCheckbox(driver, SVMPXSites.allowClientsToEnterFee_chkbx(driver));
		
		// Check Enable global login checkbox
		perform.checkCheckbox(driver, SVMPXSites.enableGlobalLogin_chckbx(driver));
		
		// Save
		saveVMPXSiteSettings(driver);
		
		// Click Configure Automatic Settings
		perform.click(driver, SVMPXSites.configureAutomaticSettings_lnk(driver));
		
		// Wait for Use fee when assigning orders dropdown
		perform.waitForElementToBeClickable(driver, SVMPXSites.useFeeWhenAssigningOrders_dropdown(), "id");
		
		// Select VMP XSite fee
		perform.selectDropdownOption(driver, SVMPXSites.useFeeWhenAssigningOrders_dropdown(driver), "VMP XSite fee");
		
		// Check Create invoice when order is placed checkbox
		perform.checkCheckbox(driver, SVMPXSites.createInvoiceWhenOrderIsPlaced_chkbx(driver));
		
		// Check Attach invoice when credit card is charged checkbox
		perform.checkCheckbox(driver, SVMPXSites.attachInvoiceWhenCreditCardIsCharged_chkbx(driver));
		
		// Check Attach invoice when order is marked complete
		perform.checkCheckbox(driver, SVMPXSites.attachInvoiceWhenOrderIsMarkedComplete_chkbx(driver));
		
		// Check Use tracking number checkbox
		perform.checkCheckbox(driver, SVMPXSites.useTrackingNumber_chckbx(driver));
		
		// Click Save
		perform.click(driver, SVMPXSites.save_btn(driver));
		
		// Wait for overlay to be displayed
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SVMPXSites.okInvalidInformation_btn(), "cssSelector");
		
		// Click OK
		perform.click(driver, SVMPXSites.okInvalidInformation_btn(driver));
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SVMPXSites.saveCompleteOK_btn(), "cssSelector");
		
		// Click OK
		perform.click(driver, SVMPXSites.saveCompleteOK_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
	} // end setDefaultSettingsForPaymentsTests
	
	/**
	 * Make a payment using the Make Payment link from the XSite order
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to the Orders page</li>
	 * 	<li>Search for and open the order</li>
	 * 	<li>Click the 'View XSite Order' link</li>
	 * 	<li>Wait for the 'Make a payment' link to be displayed (the job that produces the link runs every 5 minutes) and click on it</li>
	 * 	<li>Verify the URL contains '/makeapayment/payment' and that thet order fee, tech fee and combined amounts are correct</li>
	 * 	<li>Enter the data on the Make a payment screen and submit the payment</li>
	 * 	<li>Close the Make a payment and XSite windows and switch the driver back to the original window</li>
	 * </ul>
	 * @param driver the driver
	 * @param orderNumber The order number of the Secure order
	 * @param orderFee The expected order fee used to verify on the Make A Payment page
	 * @param techFee The expected tech fee used to verify on the Make A Payment page
	 * @param combined The expected combined fee used to verify on the Make A Payment page
	 * @param firstName The first name of the person making the payment
	 * @param lastName The last name of the person making the payment
	 * @param cardNumber The credit card number used to make the payment
	 * @param expMonth The expiration month for the credit card used to make the payment
	 * @param expYear The expiration year for the credit card used to make the payment
	 * @param zipCode The zip code for the credit card used to make the payment
	 * @param email The email address of the person making the payment
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void makePaymentFromXSiteUsingPaymentLink(RemoteWebDriver driver, String orderNumber, String orderFee, String techFee, String combined, 
			String firstName, String lastName, String cardNumber, String expMonth, String expYear, String zipCode, String email) throws InterruptedException, IOException {
		
		ExtentTest test = ExtentTestManager.getTest();
		
		// Go to Orders
		goToOrders(driver);
		
		// Find and open the order
		findAndOpenOrder(driver, orderNumber);
		
		// Open the XSite Order
		openXSiteOrder(driver);
		
		// Open the Make A Payment page
		openMakeAPaymentPage(driver);

		// Verify the URL
		perform.verification(driver, driver.getCurrentUrl().toLowerCase(), "contains", "/makeapayment/");
		
		// Add a comma if the amount is in the thousands
		String combinedWithComma = combined;
		int length = combined.length();
		if (length>7) {
			combinedWithComma = combined.substring(0, 2) + "," + combined.substring(2,length);
		} // end if
		
		// Verify amounts
		perform.verification(driver, PProvidePaymentInfo.amount_txt(driver).getText(), "equals", orderFee);
		perform.verification(driver, PProvidePaymentInfo.technologyFee_txt(driver).getText(), "equals", techFee);
		perform.verification(driver, PProvidePaymentInfo.total_txt(driver).getText(), "equals", combinedWithComma);
		
		// Enter payment
		enterPaymentOnMakeAPaymentPage(driver, firstName, lastName, cardNumber, expMonth, expYear, zipCode, email);
		
		// Close the Make A Payment and XSite windows
		closeMakeAPaymentAndXSiteWindows(driver);
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Made a payment using the payment link from the XSite using card " + cardNumber + " for Order Number: " + orderNumber);
		
	} // end makePaymentFromXSiteUsingPaymentLink
	
	/**
	 * Make a payment using the Make Payment link from the XSite order
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to the Make A Payment page</li>
	 * 	<li>Verify the URL contains '/makeapayment/payment' and that the order fee, tech fee and combined amounts are correct</li>
	 *  <li>Search for the order by address and zip code</li>
	 * 	<li>Enter the data on the Make a payment screen and submit the payment</li>
	 * 	<li>Close the Make a payment and XSite windows and switch the driver back to the original window</li>
	 * </ul>.
	 *
	 * @param driver the driver
	 * @param vmpURLFull the vmp URL full
	 * @param address the address
	 * @param zipCode The zip code for the credit card used to make the payment
	 * @param orderFee The expected order fee used to verify on the Make A Payment page
	 * @param techFee The expected tech fee used to verify on the Make A Payment page
	 * @param combined The expected combined fee used to verify on the Make A Payment page
	 * @param firstName The first name of the person making the payment
	 * @param lastName The last name of the person making the payment
	 * @param cardNumber The credit card number used to make the payment
	 * @param expMonth The expiration month for the credit card used to make the payment
	 * @param expYear The expiration year for the credit card used to make the payment
	 * @param paymentZipCode the payment zip code
	 * @param email The email address of the person making the payment
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void makeAPayment(RemoteWebDriver driver, String vmpURLFull, String address, String zipCode, String orderFee, String techFee, String combined, 
			String firstName, String lastName, String cardNumber, String expMonth, String expYear, String paymentZipCode, String email) throws InterruptedException, IOException {
		
		ExtentTest test = ExtentTestManager.getTest();

		// Go to the new Make A Payment page
		driver.get(vmpURLFull+"/MakeAPayment");

		// Verify the URL
		perform.verification(driver, driver.getCurrentUrl().toLowerCase(), "contains", "/makeapayment");
		
		// Enter the address to search for
		perform.type(driver, MakeAPaymentSearch.address_txtbx(driver), address);
		
		// Enter the Zip Code
		perform.type(driver, MakeAPaymentSearch.zipCode_txtbx(driver), zipCode);
		
		// Click Search
		perform.click(driver, MakeAPaymentSearch.search_btn(driver));
		
		// Select the order
		perform.click(driver, MakeAPaymentSelect.order(driver));
		
		// Add a comma if the amount is in the thousands
//		String combinedWithComma = combined;
//		int length = combined.length();
//		if (length>7) {
//			combinedWithComma = combined.substring(0, 2) + "," + combined.substring(2,length);
//		} // end if
		
		// Verify amounts
		perform.verification(driver, PProvidePaymentInfo.amount_txt(driver).getText(), "equals", orderFee);
//		perform.verification(driver, PProvidePaymentInfo.technologyFee_txt(driver).getText(), "equals", techFee);
//		perform.verification(driver, PProvidePaymentInfo.total_txt(driver).getText(), "equals", combinedWithComma);
		
		// Enter payment
		enterPaymentOnMakeAPaymentPage(driver, firstName, lastName, cardNumber, expMonth, expYear, paymentZipCode, email);
		
		// Get out of the iFrame
		driver.switchTo().defaultContent();
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Made a payment using card " + cardNumber);
		
	} // end makeAPayment
	
	/**
	 * Set the status in Configure Status Mapping to sync
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Sets an element to the row for the status</li>
	 *  <li>Sets an element to the parent for that row</li>
	 *  <li>Creates an element for the sync status right</li>
	 *  <li>Creates an element for the sync status left</li>
	 *  <li>Uses a switch statement to set the sync direction</li>
	 * </ul>
	 * @param driver the driver
	 * @param statusName The name of the status to set the sync direction
	 * @param syncDirection The direction to sync the status
	 * @throws InterruptedException the exception
	 */
	public void setStatusMapping(RemoteWebDriver driver, String statusName, String syncDirection) throws InterruptedException {
		
		ExtentTest test = ExtentTestManager.getTest();

		WebElement image = null;
		
		// Get status row
		WebElement status = driver.findElement(By.xpath("//td[contains(text(), '" + statusName + "')]"));
		
		// Set syncLeft and syncRight elements
		WebElement parent = status.findElement(By.xpath(".."));
		WebElement syncLeft = parent.findElement(By.cssSelector("td.grdCell:nth-child(4)"));
		WebElement syncRight = parent.findElement(By.cssSelector("td.grdCell:nth-child(7)"));
		
		// Set status mapping
		switch (syncDirection.toLowerCase()) {
		case "both":
			if (!syncLeft.getAttribute("class").contains("grdCell_Gray")) {
				image = syncLeft.findElement(By.cssSelector("img"));
				if (image.getAttribute("style").contains("hidden")) {
					perform.click(driver, syncLeft);
				} // end if image
				while (image.getAttribute("style").contains("hidden")) {
					Thread.sleep(1000);
					image = syncLeft.findElement(By.cssSelector("img"));
				} // end while
			} // end if not gray
			if (!syncRight.getAttribute("class").contains("grdCell_Gray")) {
				image = syncRight.findElement(By.cssSelector("img"));
				if (image.getAttribute("style").contains("hidden")) {
					perform.click(driver, syncRight);
				} // end if image
				while (image.getAttribute("style").contains("hidden")) {
					Thread.sleep(1000);
					image = syncRight.findElement(By.cssSelector("img"));
				} // end while
			} // end if not gray
			break;
		case "none":
			if (!syncLeft.getAttribute("class").contains("grdCell_Gray")) {
				image = syncLeft.findElement(By.cssSelector("img"));
				if (!image.getAttribute("style").contains("hidden")) {
					perform.click(driver, syncLeft);
				} // end if image
				while (!image.getAttribute("style").contains("hidden")) {
					Thread.sleep(1000);
					image = syncLeft.findElement(By.cssSelector("img"));
				} // end while
			} // end if not gray
			if (!syncRight.getAttribute("class").contains("grdCell_Gray")) {
				image = syncRight.findElement(By.cssSelector("img"));
				if (!image.getAttribute("style").contains("hidden")) {
					perform.click(driver, syncRight);
				} // end if image
				while (!image.getAttribute("style").contains("hidden")) {
					Thread.sleep(1000);
					image = syncRight.findElement(By.cssSelector("img"));
				} // end while
			} // end if not gray
			break;
		case "left":
			if (!syncLeft.getAttribute("class").contains("grdCell_Gray")) {
				image = syncLeft.findElement(By.cssSelector("img"));
				if (image.getAttribute("style").contains("hidden")) {
					perform.click(driver, syncLeft);
				} // end if image
				while (image.getAttribute("style").contains("hidden")) {
					Thread.sleep(1000);
					image = syncLeft.findElement(By.cssSelector("img"));
				} // end while
			} // end if not gray
			if (!syncRight.getAttribute("class").contains("grdCell_Gray")) {
				image = syncRight.findElement(By.cssSelector("img"));
				if (!image.getAttribute("style").contains("hidden")) {
					perform.click(driver, syncRight);
				} // end if image
				while (!image.getAttribute("style").contains("hidden")) {
					Thread.sleep(1000);
					image = syncRight.findElement(By.cssSelector("img"));
				} // end while
			} // end if not gray
			break;
		case "right":
			if (!syncLeft.getAttribute("class").contains("grdCell_Gray")) {
				image = syncLeft.findElement(By.cssSelector("img"));
				if (!image.getAttribute("style").contains("hidden")) {
					perform.click(driver, syncLeft);
				} // end if image
				while (!image.getAttribute("style").contains("hidden")) {
					Thread.sleep(1000);
					image = syncLeft.findElement(By.cssSelector("img"));
				} // end while
			} // end if not gray
			if (!syncRight.getAttribute("class").contains("grdCell_Gray")) {
				image = syncRight.findElement(By.cssSelector("img"));
				if (image.getAttribute("style").contains("hidden")) {
					perform.click(driver, syncRight);
				} // end if image
				while (image.getAttribute("style").contains("hidden")) {
					Thread.sleep(1000);
					image = syncRight.findElement(By.cssSelector("img"));
				} // end while
			} // end if not gray
			break;
		} // end switch
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Set "+statusName+" to sync to " + syncDirection);
		
	} // end statusMappingSelect
	
	/**
	 * Get the element in Configure Status Mapping
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Sets an element to the row for the status</li>
	 *  <li>Sets an element to the parent for that row</li>
	 *  <li>Creates an element for the sync status right</li>
	 *  <li>Creates an element for the sync status left</li>
	 *  <li>Uses a switch statement to determine which element to get</li>
	 * </ul>
	 * @param driver the driver
	 * @param statusName The name of the status to set the sync direction
	 * @param syncDirection The direction to sync the status
	 * @return WebElement the status mapping element
	 */
	public WebElement getStatusMappingElement(RemoteWebDriver driver, String statusName, String syncDirection) {
		
		WebElement element = null;
		
		// Get status row
		WebElement status = driver.findElement(By.xpath("//td[contains(text(), '" + statusName + "')]"));
		
		// Set syncLeft and syncRight elements
		WebElement parent = status.findElement(By.xpath(".."));
		WebElement syncLeft = parent.findElement(By.cssSelector("td.grdCell:nth-child(4)"));
		WebElement syncRight = parent.findElement(By.cssSelector("td.grdCell:nth-child(7)"));
		
		// Set status mapping
		switch (syncDirection.toLowerCase()) {
		case "left":
			if (!syncLeft.getAttribute("class").contains("grdCell_Gray")) {
				element = syncLeft.findElement(By.cssSelector("img"));
			} // end if not gray
		case "right":
			if (!syncRight.getAttribute("class").contains("grdCell_Gray")) {
				element = syncRight.findElement(By.cssSelector("img"));
			} // end if not gray
			break;
		} // end switch
		
		return element;
		
	} // end statusMappingSelect
	
	/**
	 * Add an Order Group to an order
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click Edit Order Groups</li>
	 *  <li>Switch to the new iFrame</li>
	 *  <li>Create WebElement for Available Groups</li>
	 *  <li>List all the options in Available Groups</li>
	 *  <li>Loop through all Available Groups and click on the desired one</li>
	 *  <li>Add selected group to Eligible Vendors</li>
	 *  <li>Click OK</li>
	 *  <li>Switch to original iFrame</li>
	 *  <li>Wait for overlay to be hidden</li>
	 * </ul>
	 * @param driver the driver
	 * @param orderGroupToAdd The order group to add to the order
	 * @throws InterruptedException the exception
	 */
	public void addOrderGroupToOrder(RemoteWebDriver driver, String orderGroupToAdd) throws InterruptedException {
		
		Thread.sleep(1000);
		// Click Edit Order Groups
		perform.click(driver, SNewOrder.editOrderGroups_lnk(driver));
		
		if (StoredVariables.getbrowser().get().equals("Chrome"))
		{
			Thread.sleep(500);				
		} // end if
		
		// Switch focus to new dialog box iFrame
		driver.switchTo().defaultContent();
		perform.waitForiFrameSrcAndSwitchToIt(driver, "Controls/OrderGroupManagement.aspx", By.id(SNewOrder.availableGroups_grid()));
		
		// Select Order Group To Add
		// Create WebElement for Available Groups
		WebElement availableGroups = driver.findElement(By.id(SNewOrder.availableGroups_grid()));
		// List all the options in Available Groups
		List<WebElement> options = availableGroups.findElements(By.tagName("li"));
		// Loop through all Available Groups and click on the desired one
		for (WebElement option : options)
		{
		    if (option.getText().equals(orderGroupToAdd))
		    {
		    	// click the desired option
		    	Thread.sleep(1000);
		    	option.click();
		        break;
		    }
		} // end for
		
		// Add selected group to Eligible Vendors
		perform.waitForElementToBeClickable(driver, SNewOrder.addEligibleVendors_btn(), "cssSelector");
		perform.click(driver, SNewOrder.addEligibleVendors_btn(driver));
		
		perform.waitForElementToBeClickable(driver, SNewOrder.ok_btn(), "id");
		
		// Click OK
		perform.click(driver, SNewOrder.ok_btn(driver));
		
		// Switch to original iFrame
		driver.switchTo().defaultContent();
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
	} // end addOrderGroupToAdd
	
	/**
	 * Find order folder in the Secure orders grid
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Create a list of folders </li>
	 *  <li>Get the text of the folder</li>
	 *  <li>Click on the folder</li>
	 * </ul>
	 * @param driver The driver
	 * @param findFolder Click on specified folder in the Secure orders grid
	 * @throws InterruptedException The exception
	 */
	public void findOrderFolder(RemoteWebDriver driver, String findFolder) throws InterruptedException{
		
		System.out.println("Click on the " + findFolder + " folder");

		// Click on an order folder
		List<WebElement> folders = driver.findElements(By.cssSelector("div.OrderFolderText"));
		for (WebElement el : folders) {

			// Get the text of the folder
			String folder = el.getText();

			// Click on the folder
			if (folder.startsWith(findFolder)) {
				perform.click(driver, el);
				perform.waitForBusyToBeHidden(driver);
				// Wait for element to be clickable
				perform.waitForElementToBeClickable(driver, SOrders.find_txtbx(driver));
				break;
			} // end if

		} // end for

	} // end findOrderFolder
	
	/**
	 * Verify history text in Secure
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get the text of the history/audit trail</li>
	 *  <li>Verify the text is in the history</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param expected the expected
	 * @throws InterruptedException the exception
	 */
	public void verifyHistoryTextContains(RemoteWebDriver driver, String[] expected) throws InterruptedException {

		// Get history text
		String screenText = SOrderDetails.history_txt(driver).getText();
		
		// Verify the history/audit trail contains text
		perform.verifyTextContains(driver, screenText, expected);
		
	} // end verifyHistoryText

	/**
	 * Verify history text in Secure does not contain
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get the text of the history/audit trail</li>
	 *  <li>Verify the text is not in the history</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param expected the expected
	 * @throws InterruptedException the exception
	 */
	public void verifyHistoryTextDoesNotContain(RemoteWebDriver driver, String[] expected) throws InterruptedException {

		// Get history text
		String screenText = SOrderDetails.history_txt(driver).getText();

		// Verify the history/audit trail contains text
		perform.verifyTextDoesNotContain(driver, screenText, expected);
	}

	/**
	 * Verify correct documents attached.
	 *
	 * @param driver the driver
	 * @param expected the expected
	 * @return true, if successful
	 * @throws InterruptedException the interrupted exception
	 */
	public boolean verifyCorrectDocumentsAttached(RemoteWebDriver driver, String expected) throws InterruptedException {

		// Get the items in the document section
		List<WebElement> docs = driver.findElements(By.cssSelector("table > tbody > tr > td.odTableItem"));

		boolean found = false;

		// Iterate through all of the items in the document section
		for (WebElement el : docs) {

			// Get the text of the attached documents
			String document = el.getText();

			// Check if the document is an SoE
			if (document.contains(expected)) {
				found = true;
			} // end if

		} // end for

		return found;

	} // end verifyCorrectDocumentsAttached
	
	/**
	 * Verify correct documents attached.
	 *
	 * @param driver the driver
	 * @param expected the expected
	 * @return true, if successful
	 * @throws InterruptedException the interrupted exception
	 */
	public boolean verifyCorrectDocumentsAttachedOnXSiteOrder(RemoteWebDriver driver, String expected) throws InterruptedException {

		// Get the items in the document section
		List<WebElement> docs = driver.findElements(By.id("PB_trFiles"));

		boolean found = false;

		// Iterate through all of the items in the document section
		for (WebElement el : docs) {

			// Get the text of the attached documents
			String document = el.getText();

			// Check if the document is an SoE
			if (document.contains(expected)) {
				found = true;
			} // end if

		} // end for

		return found;

	} // end verifyCorrectDocumentsAttachedOnXSiteOrder
	
	/**
	 * Wait for documents attached on XSite order.
	 *
	 * @param driver the driver
	 * @param expected the expected
	 * @return true, if successful
	 * @throws InterruptedException the interrupted exception
	 */
	public boolean waitForDocumentsAttachedOnXSiteOrder(RemoteWebDriver driver, String expected) throws InterruptedException {

		boolean found = false;

		// Get the text of the attached documents
		String document = driver.findElement(By.id("PB_trFiles")).getText();

		// Check if the document is an SoE
		int a = 1;
		while (!document.contains(expected) && a <= 10) {

			// Wait for 5 seconds
			perform.sleep(driver, 8);

			// Refresh the screen
			driver.navigate().refresh();
			
			// Wait for iframes and switch to it
			perform.waitForIFrames(driver);
			driver.switchTo().frame("Main");
			
			document = driver.findElement(By.id("PB_trFiles")).getText();

			// Iterate a
			a++;

		} // end while

		if (document.contains(expected)) {
			found = true;
		} // end if
			
		return found;

	} // end waitForDocumentsAttachedOnXSiteOrder

	/**
	 * Wait for real condition report.
	 *
	 * @param driver the driver
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void waitForRealConditionReport(RemoteWebDriver driver) throws InterruptedException, IOException {

		System.out.println("Waiting for AVM product to return");

		// Get the number of items in the sales grid
		List<WebElement> salesGrid = driver.findElements(By.id("divBorrowerCaption"));

		// Wait for items in the sales grid
		int i = 1;
		while (salesGrid.size()<1 && i<=72)
		{

			// Refresh the page
			driver.navigate().refresh();

			// Get the number of items in the sales grid
			salesGrid = driver.findElements(By.id("divBorrowerCaption"));

			// Wait 5 seconds before refreshing the page
			perform.sleep(driver, 5);

			i++;

		} // end while

		// Verify there are items in the sales grid
		Assert.assertTrue(salesGrid.size()>0, "RCR was not returned");

		// Add info to Extent Report
		perform.addInfoToExtentReport(driver, "Info", "Waiting for RCR to return");

	} // end waitForAlternativeValuationOrderToReturn
	
	/**
	 * Gets the permissions checkbox web element for a given permission.
	 *
	 * @param driver the driver
	 * @param permission the permission
	 * @return the permissions checkbox
	 */
	public WebElement getPermissionsCheckbox (RemoteWebDriver driver, String permission) {
		
		// Initialize the checkbox WebElement
		WebElement checkbox = null;
		
		// Create a list of all permissions
		List<WebElement> permissions = driver.findElements(By.cssSelector(".Permission > tbody > tr > td"));
		
		// Iterate through each permission and create a WebElement for the checkbox of the matching permission
		for (WebElement checkboxName : permissions) {
			
			// Get the text of the permission
			String permissionName = checkboxName.getText();
			
			// If the permission matches, create a WebElement for the checkbox of that permission
			if (permissionName.contains(permission)) {
				
				// Create WebElement
				checkbox = checkboxName.findElement(By.cssSelector("span > input"));
				
				// Break out of the for loop
				break;
				
			} // end if
			
		} // for loop
		
		// Return the checkbox element
		return checkbox;
		
	} // end getPermissionsCheckbox
	
	/**
	 * Select a sub user.
	 *
	 * @param driver the driver
	 * @param subUserName the sub user name
	 * @throws InterruptedException 
	 */
	public void selectSubUser (RemoteWebDriver driver, String subUserName) throws InterruptedException {

		System.out.println("Select the sub user " + subUserName);
		
		List<WebElement> subUsers = driver.findElements(By.cssSelector("tr > td.BlueBox > div"));
		for (WebElement user : subUsers) {

			// Get the current user
			String currentUser = user.getText();
			
			// If the current user matches the expected sub user, click it
			if (currentUser.contains(subUserName)) {
				perform.click(driver, user);
				break;
			} // end if
			
		} // end for
		
	} // end selectSubUser

	/**
	 * Create and assign new double blind residential appraisal order.
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 *  <li>Go to Vendor Selection Settings</li>
	 *  <li>Turn on Double-blind Communication</li>
	 *  <li>Disable Automatic Vendor Selection</li>
	 *  <li>Select Custom Fee Panel</li>
	 *  <li><Uncheck Use Mercury Network Directory as backup checkbox/li>
	 *  <li>Verify Mercury Network Directory as backup is unchecked</li>
	 *  <li>Save Vendor Selection Settings</li>
	 *  <li>Go to Residential Appraisal</li>
	 *  <li>Set New Order Information</li>
	 *  <li>Enter New Order data</li>
	 *  <li>Click Next</li>
	 *  <li>Check for related orders dialog</li>
	 *  <li>Confirm order screen loads</li>
	 *  <li>Verify the 'I have read and understand the vendor's fee notes' checkbox is unchecked</li>
	 *  <li>Click Next</li>
	 *  <li>Check for a failed submission</li>
	 *  <li>Select document type</li>
	 *  <li>Click Finished Button</li>
	 *  <li>Verify you land on the orders grid</li>
	 *  <li>Query the db to get the order number that was just created</li>
	 *  <li>Search for new order</li>
	 *  <li>Verify the order just created is in the orders grid</li>
	 * </ul>
	 * @param driver the driver
	 * @param user the user
	 * @throws Exception the exception
	 */
	// Create and assign a new Residential Appraisal order
	public void createAndAssignNewDoubleBlindResidentialAppraisalOrder(RemoteWebDriver driver, String user) throws Exception {

		// Login to Secure
		login(driver, user, StoredVariables.getpassword().get());

		// Go to Vendor Selection Settings
		goToVendorSelectionSettings(driver);

		// Turn on Double-blind Communication switch
		if (!SVendorSelectionSettings.doubleBlind_switch(driver).getAttribute("src").contains("switchOn.png"))
		{
			perform.click(driver, SVendorSelectionSettings.doubleBlind_switch(driver));
		} 

		// Disable Automatic Vendor Selection
		if (SVendorSelectionSettings.automaticOrderAssignment_switch(driver).getAttribute("src").contains("switchOn.png"))
		{
			perform.click(driver, SVendorSelectionSettings.automaticOrderAssignment_switch(driver));
		}

		// Select Custom Fee Panel
		perform.click(driver, SVendorSelectionSettings.customFeePanel_radio(driver));

		// Uncheck Use Mercury Network Directory as backup checkbox
		if (SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver).isSelected())
		{
			perform.click(driver, SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver));
		}

		// Verify Mercury Network Directory as backup is unchecked
		Assert.assertTrue(SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver).isSelected()==false, "Mercury Network Directory as backup is still checked");

		// Save Vendor Selection Settings
		secure.saveVendorSelectionSettings(driver);

		// Go to Residential Appraisal
		goToResidentialAppraisal(driver);

		/***************************************
		 * Set New Order Information
		 ***************************************/
		perform.clearOrderInfoStoredVariables(driver);
		setNewResidentialAppraisalOrderVariablesMinimum(driver);

		// Enter New Order data
		enterNewResidentialAppraisalOrder(driver);

		// Click Next		
		if (StoredVariables.getmobile().get()==false) {
			perform.click(driver, SNewOrder.next_btn(driver));
		} else {
			perform.clickWithJavascript(driver, SNewOrder.next_btn(driver));
		} // end if/else

		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);

		// Check for related orders dialog
		checkForRelatedOrdersDialog(driver);

		// Confirm order screen loads
		Assert.assertTrue(driver.getCurrentUrl().contains("ConfirmOrder"), "Confirm Order page did not load");

		// Verify the 'I have read and understand the vendor's fee notes' checkbox is unchecked
		try
		{
			if (SConfirmOrder.readVendorsFeeNotes_chkbx(driver).isSelected())
			{
				perform.click(driver, SConfirmOrder.readVendorsFeeNotes_chkbx(driver));
			} // end if

			// Click Next
			perform.click(driver, SConfirmOrder.nextBottom_btn(driver));

			// Wait for message text
			perform.waitForElementToBeClickable(driver, SConfirmOrder.messageOK_btn(), "id");

			// Verify popup displays with correct text
			Assert.assertTrue(SConfirmOrder.message_txt(driver).getText().contains("You must agree to the fee notes entered by the vendor."), "Message for not agreeing to vendor notes did not display properly");

			// Wait for OK button
			perform.waitForElementToBeClickable(driver, SConfirmOrder.messageOK_btn(), "id");

			// Click OK
			if (StoredVariables.getmobile().get()==false) {
				perform.click(driver, SConfirmOrder.messageOK_btn(driver));
			} else {
				perform.clickWithJavascript(driver, SConfirmOrder.messageOK_btn(driver));
			} // end if/else

			// Wait for the back button to be visible
			perform.waitForElementToBeClickable(driver, SConfirmOrder.backTop_btn(), "id");

			// Check the agree to notes checkbox
			if (!SConfirmOrder.readVendorsFeeNotes_chkbx(driver).isSelected())
			{
				if (StoredVariables.getmobile().get()==false) {
					perform.click(driver, SConfirmOrder.readVendorsFeeNotes_chkbx(driver));
				} else {
					perform.clickWithJavascript(driver, SConfirmOrder.readVendorsFeeNotes_chkbx(driver));
					System.out.println("Clicked fee notes checkbox with Javascirpt");
				} // end if/else
			} // end if

			// Change payment method to check
			perform.selectDropdownOption(driver, SConfirmOrder.paymentMethod_dropdown(driver), "Check");

		} catch (Exception e) {} // end try/catch

		Thread.sleep(2000);

		// Click Next
		perform.click(driver, SConfirmOrder.nextBottom_btn(driver));

		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);

		// Check for a failed submission 
		List<WebElement> frame = driver.findElements(By.xpath("//iframe[contains(@src,'AttachDocument.aspx')]"));
		while (frame.size()==0) 
		{

			Thread.sleep(5000);

			frame = driver.findElements(By.xpath("//iframe[contains(@src,'AttachDocument.aspx')]"));
			if (frame.size()>0)
			{
				break;
			} // end if

			// Click OK
			perform.waitForElementToBeClickable(driver, SConfirmOrder.messageOK_btn(driver));
			perform.click(driver, SConfirmOrder.messageOK_btn(driver));

			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);

			// Click Back
			perform.click(driver, SConfirmOrder.backBottom_btn(driver));

			// Wait for Next button
			perform.waitForElementToBeClickable(driver, SVendorSelection.nextTop_btn(), "id");

			// Click Next
			perform.click(driver, SVendorSelection.nextTop_btn(driver));

			// Wait for the Next button
			perform.waitForElementToBeClickable(driver, SConfirmOrder.nextTop_btn(), "id");

			// Check I have read checkbox
			try {
				perform.checkCheckbox(driver, SConfirmOrder.readVendorsFeeNotes_chkbx(driver));
			} catch (Exception s){} // end try/catch

			// Click Next
			perform.click(driver, SConfirmOrder.nextBottom_btn(driver));

			// Wait for busy to be hidden
			perform.waitForBusyToBeHidden(driver);

			frame = driver.findElements(By.xpath("//iframe[contains(@src,'AttachDocument.aspx')]"));
		} // end the check for a failed submission

		// Get inside the attach document frame
		perform.switchToiFrameByID(driver, "iframeAttach");

		// Select document type
		perform.selectDropdownOption(driver, SConfirmOrder.documentType_dropdown(driver), "Other");

		// Wait for upload button
		perform.waitForElementToBeClickable(driver, SConfirmOrder.uploadDocuments_btn(), "id");

		if (StoredVariables.getmobile().get()==false) {
			System.out.println("upload document");
			// Upload Document
			String filePath = StoredVariables.getdocDir().get()+"Test PDF.pdf";
			uploadDocumentOnSConfirmOrder(driver, filePath);
		} // end if/else

		// Click Finished Button
		perform.click(driver, SConfirmOrder.finished_btn(driver));

		// Switch back to the attach documents frame
		driver.switchTo().defaultContent();

		// Wait for Orders page to load
		perform.waitForElementToBeClickable(driver, SOrders.find_txtbx(), "id");

		// Verify you land on the orders grid
		Assert.assertTrue(driver.getCurrentUrl().contains("OrderManagement"), "After completing an order, the orders grid did not load");

		// Query the db to get the order number that was just created
		db.getLoanID(driver);
		String trackingNumber = StoredVariables.gettrackingNumber().get();

		// Wait for the Order Types dropdown
		perform.waitForElementToBeClickable(driver, SOrders.orderTypes_dropdown(), "id");

		// Search for new order
		findOrder(driver, trackingNumber, "Tracking number");

		// Verify the order just created is in the orders grid 
		Assert.assertTrue(SOrders.ordersTable_txt(driver).getText().contains(StoredVariables.getloanID().get()), "New order is not displayed");

	} // end createAndAssignNewDoubleBlindResidentialAppraisalOrder

	/**
	 * Delete secure orders.
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get all items in the grid</li>
	 *  <li>Get the number of row elements</li>
	 *  <li>Loop through and delete all orders</li>
	 *  <li>Select row if it exists</li>
	 *  <li>Click Delete</li>
	 *  <li>Verify Deleted Order text</li>
	 *  <li>Click OK</li>
	 *  <li>Get all items in the grid</li>
	 *  <li>Get the number of row elements</li>
	 * </ul>
	 * @param driver the driver
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void deleteAllOrdersInFolder(RemoteWebDriver driver) throws InterruptedException, IOException {

		// Get the number of records in the folder
		int numOfOrders = getNumberOfOrdersInFolder(driver);
		
		if (numOfOrders > 0) {
			
			// Loop through and delete all orders
			while (numOfOrders > 0) {
				
				// Get all items in the grid
				List<WebElement> rows = driver.findElements(By.cssSelector("#tblOrders > tbody > tr"));
				
				// Get the number of row elements
				int numOfRows = rows.size();

				// Select the first row
				perform.click(driver, rows.get(0));
				
				// Click the last row on the screen
				perform.keyPressAndClick(driver, Keys.LEFT_SHIFT, rows.get(numOfRows-1));
				
				// Click Delete
				perform.clickInTable_Contains(driver, "Delete");

				// Wait for busy to be hidden
				perform.waitForBusyToBeHidden(driver);
				
				// Wait for the overlay to be visible
				perform.waitForOverlayToBeVisible(driver);

				//Check for dialog text
				int a = 1;
				String text = SOrders.deleteOrdersdialog_txt(driver).getText();
				while (!text.contains("Your orders have been") && a++ <10) {
					perform.sleep(driver, 1);
					text = SOrders.deleteOrdersdialog_txt(driver).getText();
				}//End while

				// If the order needs to be cancelled before being deleted, send message
				if (!SOrders.deleteOrdersdialog_txt(driver).getText().contains("Your orders have been")) {

					// Enter message to send to appraiser
					perform.type(driver, SOrders.deleteMessage_txtbx(driver), "The order is being cancelled and deleted");

					// Check the checkbox to update status on VMP XSite
					perform.checkCheckbox(driver, SOrders.updateStatusOnVMPXSite_chkkbx(driver));

					// Click OK
					perform.click(driver, SOrders.okSendDeleteMessage_btn(driver));

					// Wait for busy
					perform.waitForBusyToBeHidden(driver);

					// Wait for the overlay to be visible
					perform.waitForOverlayToBeVisible(driver);

				} // end if

				// Verify Deleted Order text
				perform.verification(driver, SOrders.deleteOrdersdialog_txt(driver).getText(), "Contains", "Your orders have been successfully deleted.");

				// Click OK
				perform.click(driver,SOrders.deleteOrderOK_btn(driver));

				// Wait for overlay to be hidden
				perform.waitForOverlayToBeHidden(driver);
				
				// Update the number of records in the folder
				numOfOrders = getNumberOfOrdersInFolder(driver);

			} // end while
			
		} // end if
		
	} // end deleteAllOrdersInFolder
	
	/**
	 * Gets the number of orders in folder.
	 *
	 * @param driver the driver
	 * @return the number of orders in folder
	 */
	public int getNumberOfOrdersInFolder (RemoteWebDriver driver) {
		
		// Get the text in the title
		String title = SOrders.ordersTitle_txt(driver).getText();
		
		// Get the number between the parentheses
		String count = title.substring(title.indexOf("(")+1,title.indexOf(")"));
		
		// Convert the number to an integer
		int numOfOrders = Integer.parseInt(count);
		
		// Return the number of orders
		return numOfOrders;
		
	}

	/**
	 * Start AQM on an order in Secure.
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click Start AQM</li>
	 *  <li>Click Agree</li>
	 *  <li>Switch into iFrame</li>
	 *  <li>Select the module</li>
	 *  <li>Click OK</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param module the module
	 * @throws InterruptedException the interrupted exception
	 */
	//Delete Secure Orders
	public void startAQM(RemoteWebDriver driver, String module) throws InterruptedException {

		// Click Start AQM
		perform.click(driver, SOrderDetails.startAQM_btn(driver));
		
		perform.sleep(driver, 2);
		
		// Wait for busy
		perform.waitForBusyToBeHidden(driver);
		
		// Switch into iFrame
//		perform.switchToiFrameBySrc(driver, "Common/AQMForms/StartAQM.aspx");
		perform.switchToiFrameByIndex(driver, 0);
		
		System.out.println("Body: " + driver.findElement(By.id("bdyDialog")).getText());
		
		// Select module
		if (module.toLowerCase().startsWith("real")) {
			
			// RealView
			perform.click(driver, SOrderDetails.aqmRealView_btn(driver));
			
		} else if (module.toLowerCase().startsWith("master")) {
			
			// MasterServ AppraisalNSight
			perform.click(driver, SOrderDetails.aqmRealView_btn(driver));
			
		} // end if/else
		
		// Click OK
		perform.click(driver, SOrderDetails.okStartAQM_btn(driver));

	} // end startAQM
	
	/**
	 * Start AQM on an order in Secure.
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Enter username</li>
	 *  <li>Enter password</li>
	 *  <li>Click Save</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param platdataUsername the platdata username
	 * @param platdataPassword the platdata password
	 * @throws InterruptedException 
	 */
	//Delete Secure Orders
	public void enterAQMCredentials(RemoteWebDriver driver, String platdataUsername, String platdataPassword) throws InterruptedException {

		// Enter username
		perform.type(driver, SOrderDetails.platdataUsername_txtbx(driver), "aplatdata1");
		
		// Enter password
		perform.type(driver, SOrderDetails.platdataPassword_txtbx(driver), "T3sting1");
		
		// Click Save
		perform.click(driver, SOrderDetails.platdataSave_btn(driver));
		
		// Click OK
		perform.click(driver, SOrderDetails.platdataSaveOK_btn(driver));

	} // end enterAQMCredentials
	
} // end Function_Secure class