package utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjects.Secure.SOrderDetails;
import pageObjects.Vendors.VAccount;
import pageObjects.Vendors.VCreditCard;
import pageObjects.Vendors.VLogin;
import pageObjects.Vendors.VOrderAcknowledgement;
import pageObjects.Vendors.VOrderDetails;
import pageObjects.Vendors.VOrders;
import pageObjects.Vendors.VQuickList;
import pageObjects.Vendors.VRequestModification;
import pageObjects.Vendors.VSignUp;
import pageObjects.Vendors.VUsers;
import pageObjects.Vendors.VUsers_AddTrainee;
import pageObjects.XSite.XBusinessManagement;
import pageObjects.XSite.XInvoice;
import setup.TestSetup;

// TODO: Auto-generated Javadoc
/**
 * <h1>Function Vendors</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class Function_Vendors extends TestSetup {
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to sign up page</li>
	 * 	<li>Choose account type</li>
	 * 	<li>Choose State</li>
	 * 	<li>Enter company name</li>
	 * 	<li>Enter phone number</li>
	 * 	<li>Enter email address</li>
	 * 	<li>Click the Next button</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param environment the environment
	 * @throws InterruptedException the exception
	 */
	// Create vendor account
	public void createAccount(RemoteWebDriver driver, String environment) throws InterruptedException {

		// Go to sign up page
		if (environment.equals("dev") || environment.equals("qa"))
		{
			driver.get("https://vendors.mercuryvmpqa.com/SignupWiz.aspx");
		}
		else if (environment.equals("beta") || environment.equals("live"))
		{
			driver.get("https://vendors.mercuryvmp.com/SignupWiz.aspx");
		}
		
		// Choose account type
		perform.selectDropdownOption(driver, VSignUp.typeOfAccount_dropdown(driver), "Appraiser");
		
		// Choose State
		perform.selectDropdownOption(driver, VSignUp.state_dropdown(driver), "Oklahoma");
		
		// Enter company name
		perform.type(driver, VSignUp.companyName_txtbx(driver), "");
		
		// Enter phone number
		perform.type(driver, VSignUp.phoneNumber_txtbx(driver), "");
		
		// Enter email address
		perform.type(driver, VSignUp.emailAddress_txtbx(driver), "");
		
		// Click the Next button
		perform.click(driver, VSignUp.next_btn(driver));
		
	} // end create vendor account
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click on Orders</li>
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
		
		ExtentTest test = ExtentTestManager.getTest();
		
		System.out.println("Go to Orders");
		
		// Click on Orders if not on the orders page
		if (!driver.getCurrentUrl().contains("/Orders.aspx")) {
			
			try {
				perform.click(driver, VOrders.orders_btn(driver));
			} catch (Exception e) {
				perform.click(driver, VOrders.orders_btn(driver));
			} // end try/catch
			
		} // end if not on orders page 
		
		// Wait for the Find textbox
		perform.waitForElementToBeClickable(driver, VOrders.find_txtbx(), "id");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().contains("VendorAdmin/OrderManagement/Orders.aspx"), "The url is incorrect");
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Navigated to the Orders page");
		
	} // end goToOrders
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click on Account</li>
	 * 	<li>Verify url</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	// Go to Orders
	public void goToAccount(RemoteWebDriver driver) throws IOException, InterruptedException
	{
		
		ExtentTest test = ExtentTestManager.getTest();
		
		System.out.println("Go to Account");
		
		// Click on Account
		perform.click(driver, VOrders.account_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Wait for the Manage button
		perform.waitForElementToBeClickable(driver, VAccount.unpaidInvoices_btn(), "id");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().contains("AccountManagement/Account.aspx"), "The url is incorrect");
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Navigated to the Account page");
		
	} // end goToAccount
	
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
		
		ExtentTest test = ExtentTestManager.getTest();
		
		System.out.println("Go to Users");
		
		// Click on Users
		perform.click(driver, VOrders.users_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Wait for Professional tab
		perform.waitForElementToBeClickable(driver, VUsers.professional_btn(), "id");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().contains("VendorAdmin/UserManagement/User.aspx"), "The url is incorrect");
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Navigated to the Users page");
		
	} // end goToUsers
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click on Credit Card</li>
	 * 	<li>Verify url</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	// Go to Credit Card
	public void goToCreditCard(RemoteWebDriver driver) throws IOException, InterruptedException
	{
		
		ExtentTest test = ExtentTestManager.getTest();
		
		System.out.println("Go to Credit Card");
		
		// Click on Credit Card
		try {
			perform.click(driver, VOrders.creditCard_btn(driver));
		} catch (Exception e) {
			perform.waitForOverlayToBeHidden(driver);
			perform.click(driver, VOrders.creditCard_btn(driver));
		}  //end trycatch  
		
		// Wait for the Find textbox
		perform.waitForElementToBeClickable(driver, VCreditCard.search_btn(), "id");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().contains("Common/CreditCards/CreditCards.aspx"), "The url is incorrect");
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Navigated to the Credit Card page");
		
	} // end goToCreditCard
	
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
	 * 	<li>Check for overlay if it is the first time the page is opened since run</li>
	 * 	<li>Click the find textbox</li>
	 * 	<li>Close overlay</li>
	 * 	<li>Get the customer number to add to extent reports</li>
	 * 	<li>Log the user logged in</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param user the user
	 * @param password the password
	 * @throws Exception the exception
	 */
	// Login to vendors site
	public void login(RemoteWebDriver driver, String user, String password) throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		String catchAllDomain = StoredVariables.getcatchAllDomain().get();
		String env = StoredVariables.getusernameEnvironment().get();
		int passwordLength = password.length();
		
		if (!user.contains("@")) {
			user = "automation" + env + user + catchAllDomain;
		}
		
		// Go to login page
		String url = StoredVariables.getvendorsSite().get();
		driver.get(url);
		
		// Wait for Email textbox
		perform.waitForElementToBeClickable(driver, VLogin.email_txtbx(), "id");
		
		// Enter email
		perform.type(driver, VLogin.email_txtbx(driver), user);
		
		// Enter Password
		perform.type(driver, VLogin.password_txtbx(driver), password);
		
		// Ensure the username is entered correctly
		int u = 1;
		String enteredUser = VLogin.email_txtbx(driver).getAttribute("value");
		while (!enteredUser.equals(user) && u <= 10) {
			perform.type(driver, VLogin.email_txtbx(driver), user);
			Thread.sleep(1500);
			enteredUser = VLogin.email_txtbx(driver).getAttribute("value");
			System.out.println("enteredUser: " + enteredUser);
			u++;
		} // end while
		
		// Ensure the password length is correct
		int p = 1;
		String enteredPassword = VLogin.password_txtbx(driver).getAttribute("value");
		while(enteredPassword.length() != passwordLength && p <= 10) {
			perform.type(driver, VLogin.password_txtbx(driver), password);
			Thread.sleep(1500);
			enteredPassword = VLogin.password_txtbx(driver).getAttribute("value");
			System.out.println("enteredPassword: " + enteredPassword);
		} // end while
		
		// Click Sign In
		perform.click(driver, VLogin.signIn_btn(driver));
		
		// Wait for Find textbox
		perform.waitForElementToBeClickable(driver, VOrders.find_txtbx(), "id");
		
		// Check for overlay if it is the first time the page is opened since run
		try
		{
			// Click the find textbox
			perform.click(driver, VOrders.find_txtbx(driver));
		} // end try
		catch (Exception e) {
			// Close overlay
			perform.waitForElementToBeClickable(driver, VOrders.closeOverlay_btn(), "cssSelector");
			perform.click(driver, VOrders.closeOverlay_btn(driver));
		} // end catch
		
		// Get the customer number to add to extent reports
		String customerNumber = db.getCustomerNumber(driver, user);
		
		// Log the user logged in
		test.log(LogStatus.INFO, "Log In", "Loggged in to Vendors<br>URL: <a href=\"" + url + "\">" + url + "</a><br>User: " + user + "<br>Password: " + password + "<br>Customer Number: " + customerNumber);
		
	} // end login to vendors site
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to login page</li>
	 * 	<li>Enter email</li>
	 * 	<li>perform.type(driver, VLogin.email_txtbx(driver), user);</li>
	 * 	<li>Enter Password</li>
	 * 	<li>Ensure the username is entered correctly</li>
	 * 	<li>Ensure the password length is correct</li>
	 * 	<li>Click Sign In</li>
	 * 	<li>Check for overlay if it is the first time the page is opened since run</li>
	 * 	<li>Click the find textbox</li>
	 * 	<li>Close overlay</li>
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
	// Login to vendors site
	public void login(RemoteWebDriver driver, String user, String password, String env) throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		String catchAllDomain = StoredVariables.getcatchAllDomain().get();
		int passwordLength = password.length();
		
		if (!user.contains("@")) {
			user = "automation" + env + user + catchAllDomain;
		}
		
		// Go to login page
		StoredVariables.getvendorsSite().set(perform.getVendorsSite(env));
		String url = StoredVariables.getvendorsSite().get();
		driver.get(url);
		
		// Wait for Email textbox
		perform.waitForElementToBeClickable(driver, VLogin.email_txtbx(), "id");
		
		// Enter email
//		perform.type(driver, VLogin.email_txtbx(driver), user);
		
		// Enter Password
		perform.type(driver, VLogin.password_txtbx(driver), password);
		
		// Ensure the username is entered correctly
		int u = 1;
		String enteredUser = VLogin.email_txtbx(driver).getAttribute("value");
		while (!enteredUser.equals(user) && u <= 10) {
			perform.type(driver, VLogin.email_txtbx(driver), user);
			Thread.sleep(1500);
			enteredUser = VLogin.email_txtbx(driver).getAttribute("value");
			System.out.println("enteredUser: " + enteredUser);
			u++;
		} // end while
		
		// Ensure the password length is correct
		int p = 1;
		String enteredPassword = VLogin.password_txtbx(driver).getAttribute("value");
		while(enteredPassword.length() != passwordLength && p <= 10) {
			perform.type(driver, VLogin.password_txtbx(driver), password);
			Thread.sleep(1500);
			enteredPassword = VLogin.password_txtbx(driver).getAttribute("value");
			System.out.println("enteredPassword: " + enteredPassword);
		} // end while
		
		// Click Sign In
		perform.click(driver, VLogin.signIn_btn(driver));
		
		// Wait for Find textbox
		perform.waitForElementToBeClickable(driver, VOrders.find_txtbx(), "id");
		
		// Check for overlay if it is the first time the page is opened since run
		try
		{
			// Click the find textbox
			perform.click(driver, VOrders.find_txtbx(driver));
		} // end try
		catch (Exception e) {
			// Close overlay
			perform.waitForElementToBeClickable(driver, VOrders.closeOverlay_btn(), "cssSelector");
			perform.click(driver, VOrders.closeOverlay_btn(driver));
		} // end catch
		
		// Get the customer number to add to extent reports
		String customerNumber = db.getCustomerNumber(driver, user);
		
		// Log the user logged in
		test.log(LogStatus.INFO, "Log In", "Loggged in to Vendors<br>URL: <a href=\"" + url + "\">" + url + "</a><br>User: " + user + "<br>Password: " + password + "<br>Customer Number: " + customerNumber);
		
	} // end login to vendors site
	
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
	 * 	<li>Form</li>
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
	 * 	<li>Verify data in Contact And Access Information is correct</li>
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
	 */
	// Verify Vendor Order Details
	public void verifyOrderDetails(RemoteWebDriver driver)
	{
		
		System.out.println("Verifying Order Details");
		
		String orderInformation = VOrderDetails.orderInformation_txt(driver).getText();
		
		// Verify data in Property Information is correct
		// Address
		Assert.assertTrue(orderInformation.contains(StoredVariables.getpropertyInformationAddress().get()), "Address is not displayed on the Order Confirmation page");
		
		// City
		Assert.assertTrue(orderInformation.contains(StoredVariables.getpropertyInformationCity().get()), "City is not displayed on the Order Confirmation page");
		
		// State
		Assert.assertTrue(orderInformation.contains(StoredVariables.getpropertyInformationStateAbbr().get()), "State is not displayed on the Order Confirmation page");
		
		// Zip
		Assert.assertTrue(orderInformation.contains(StoredVariables.getpropertyInformationZip().get()), "Zip is not displayed on the Order Confirmation page");
		
		// Sq Ft 
		Assert.assertTrue(orderInformation.contains(StoredVariables.getpropertyInformationSqFt().get()), "Sq Ft is not displayed on the Order Confirmation page");
		
		// Site Size
		Assert.assertTrue(orderInformation.contains(StoredVariables.getpropertyInformationSiteSize().get()), "Site Size is not displayed on the Order Confirmation page");
		
		// Prop Type
		Assert.assertTrue(orderInformation.contains(StoredVariables.getpropertyInformationPropType().get()), "Prop Type is not displayed on the Order Confirmation page");
		
		// Prop rights
		Assert.assertTrue(orderInformation.contains(StoredVariables.getpropertyInformationPropRights().get()), "Prop Rights is not displayed on the Order Confirmation page");
		
		// Legal Desc
		Assert.assertTrue(orderInformation.contains(StoredVariables.getpropertyInformationLegalDesc().get()), "Legal Desc is not displayed on the Order Confirmation page");
		
		// Directions
		Assert.assertTrue(orderInformation.contains(StoredVariables.getpropertyInformationDirections().get()), "Directions is not displayed on the Order Confirmation page");
		
		// Verify data in Assignment Information is correct
		// Form
		Assert.assertTrue(orderInformation.contains(perform.convertXSiteProductToMNProduct(driver, StoredVariables.getassignmentInformationForm().get())), "Form is not displayed on the Order Confirmation page. The form should be = " + StoredVariables.getassignmentInformationForm().get() + "     The on-screen data = " + orderInformation);
		
		// Order due
		Assert.assertTrue(orderInformation.contains(StoredVariables.getorderDueDateShort().get()), "Order due is not displayed on the Order Confirmation page");
		
		// Rush
		if (StoredVariables.getassignmentInformationRushOrder().get() == true)
		{
			Assert.assertTrue(orderInformation.contains("Rush"), "Rush is not displayed on the Order Confirmation page");	
		}
		
		// Loan type
		Assert.assertTrue(orderInformation.contains(StoredVariables.getassignmentInformationLoanType().get()), "Loan type is not displayed on the Order Confirmation page");
		
		// Loan purpose
		Assert.assertTrue(orderInformation.contains(StoredVariables.getassignmentInformationLoanPurpose().get()), "Loan purpose is not displayed on the Order Confirmation page");
		
		// Lender
		Assert.assertTrue(orderInformation.contains(StoredVariables.getlenderInformationLenderName().get()), "Lender is not displayed on the Order Confirmation page");
		
		// Sales Price
		Assert.assertTrue(orderInformation.contains(StoredVariables.getassignmentInformationSalesPrice().get()), "Sales price is not displayed on the Order Confirmation page");
		
		// Loan #
		Assert.assertTrue(orderInformation.contains(StoredVariables.getassignmentInformationLoanNumber().get()), "Loan # is not displayed on the Order Confirmation page");
		
		// Other ref #
		Assert.assertTrue(orderInformation.contains(StoredVariables.getassignmentInformationOtherRefNumber().get()), "Other ref # is not displayed on the Order Confirmation page");

		// File #
		Assert.assertTrue(orderInformation.contains(StoredVariables.getassignmentInformationFileNumber().get()), "File # is not displayed on the Order Confirmation page");
		
		// FHA #
		Assert.assertTrue(orderInformation.contains(StoredVariables.getassignmentInformationFHACaseNumber().get()), "FHA # is not displayed on the Order Confirmation page");
		
		// Ordered by
		Assert.assertTrue(orderInformation.contains(StoredVariables.getassignmentInformationOrderedBy().get()), "Ordered By is not displayed on the Order Confirmation page");
		
		// Verify data in Contact And Access Information is correct
		// Borrower
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactBorrower().get()), "Borrower is not displayed on the Order Confirmation page");
		
		// Borrower Info 1
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactBorrowerInfo1().get()), "Borrower Info 1 is not displayed on the Order Confirmation page");
		
		// Borrower Info 2
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactBorrowerInfo2().get()), "Borrower Info 2 is not displayed on the Order Confirmation page");
		
		// CoBorrower
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactCoBorrower().get()), "CoBorrower is not displayed on the Order Confirmation page");
		
		// CoBorrower Info 1
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactCoBorrowerInfo1().get()), "CoBorrower Info 1 is not displayed on the Order Confirmation page");
		
		// CoBorrower Info 2
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactCoBorrowerInfo2().get()), "CoBorrower Info 2 is not displayed on the Order Confirmation page");
		
		// Owner
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactOwner().get()), "Owner is not displayed on the Order Confirmation page");
		
		// Owner Info 1
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactOwnerInfo1().get()), "Owner Info 1 is not displayed on the Order Confirmation page");
		
		// Owner Info 2
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactOwnerInfo2().get()), "Owner Info 2 is not displayed on the Order Confirmation page");
		
		// Occupant
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactOccupant().get()), "Occupant is not displayed on the Order Confirmation page");
		
		// Occupant Info 1
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactOccupantInfo1().get()), "Occupant Info 1 is not displayed on the Order Confirmation page");
		
		// Occupant Info 2
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactOccupantInfo2().get()), "Occupant Info 2 is not displayed on the Order Confirmation page");
		
		// Agent
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactAgent().get()), "Agent is not displayed on the Order Confirmation page");
		
		// Agent Info 1
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactAgentInfo1().get()), "Agent Info 1 is not displayed on the Order Confirmation page");
		
		// Agent Info 2
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactAgentInfo2().get()), "Agent Info 2 is not displayed on the Order Confirmation page");
		
		// Other
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactOther().get()), "Other is not displayed on the Order Confirmation page");
		
		// Other Info 1
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactOtherInfo1().get()), "Other Info 1 is not displayed on the Order Confirmation page");
		
		// Other Info 2
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactOtherInfo2().get()), "Other Info 2 is not displayed on the Order Confirmation page");
		
		// Appt. Contact
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactApptContact().get()), "Appt. Contact is not displayed on the Order Confirmation page");
		
		// Verify Product Requirements text loads in Additional Comments section
		if (StoredVariables.getassignmentInformationForm().get().equals("1004 Full/URAR"))
		{
			Assert.assertTrue(orderInformation.contains("URAR (Form 1004 - UAD)"), "The Product Requirements text did not load in the Additional Comments");
		} // end if
		else if (StoredVariables.getassignmentInformationForm().get().equals("Uniform Residential Appraisal (FNMA 1004)"))
		{
			Assert.assertTrue(orderInformation.contains("URAR (Form 1004 - UAD)"), "The Product Requirements text did not load in the Additional Comments");
		} // end if
		else
		{
			Assert.assertTrue(orderInformation.contains(StoredVariables.getassignmentInformationForm().get()), "The Product Requirements text did not load in the Additional Comments");
		}
		
	} // end verifyVendorOrderDetails
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click Orders</li>
	 * 	<li>Select All from the Placed dropdown</li>
	 * 	<li>Enter search text into Find textbox</li>
	 * 	<li>Click the Contains radio button</li>
	 * 	<li>Select Field dropdown</li>
	 * 	<li>Ensure All is selected</li>
	 * 	<li>Select All from the Placed dropdown</li>
	 * 	<li>Click the Find magnifying glass</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param search the search
	 * @param field the field
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Find Order on Vendors
	public void findOrder(RemoteWebDriver driver, String search, String field) throws InterruptedException, IOException
	{
		
		ExtentTest test = ExtentTestManager.getTest();
		
		System.out.println("Searching for " + search + " in " + field);
		
		// Click Orders
		goToOrders(driver);

		// Wait for the Find text box
		perform.waitForElementToBeClickable(driver, VOrders.find_txtbx(), "id");
		
		// Select All from the Placed dropdown
		try {
			perform.selectDropdownOption(driver, VOrders.placed_dropdown(driver), "All");
		} catch (Exception e) {
			perform.selectDropdownOption(driver, VOrders.placed_dropdown(driver), "All");
		} // end try/catch
		
		// Enter search text into Find textbox
		try {
			perform.type(driver, VOrders.find_txtbx(driver), search);
		} catch (Exception e) {
			perform.type(driver, VOrders.find_txtbx(driver), search);
		} // end try/catch
		
		// Click the Contains radio button
		perform.click(driver, VOrders.contains_radioBtn(driver));
		
		// Select Field dropdown
		perform.selectDropdownOption(driver, VOrders.inField_dropdown(driver), field);
		
		// Ensure All is selected 
		String placed = perform.getSelectedDropdownOption(driver, VOrders.placed_dropdown(driver));
		if (!placed.equals("All")) {
			// Select All from the Placed dropdown
			try {
				perform.selectDropdownOption(driver, VOrders.placed_dropdown(driver), "All");
			} catch (Exception e) {
				perform.selectDropdownOption(driver, VOrders.placed_dropdown(driver), "All");
			} // end try/catch
		} // end if
		
		// Click the Find magnifying glass
		perform.click(driver, VOrders.find_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		Thread.sleep(1000);
		
		// Wait for the grid to be visible
		perform.waitForElementToBeVisible(driver, VOrders.ordersGrid_txt(), "id");
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Search for order: " + search);
		
	} // end findOrderOnVendors
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Vendors</li>
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
	 * 	<li>Login to Vendors</li>
	 * 	<li>Accept the order</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param user the user
	 * @param password the password
	 * @param trackingNumber the tracking number
	 * @throws Exception the exception
	 */
	// Login and Accept Order on Vendors
	public void loginAndAcceptOrder(RemoteWebDriver driver, String user, String password, String trackingNumber) throws Exception
	{
		
		// Login
		login(driver, user, password);
		
		// Accept the order
		acceptOrder(driver, trackingNumber);
		
	} // end loginAndAcceptOrder
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Vendors</li>
	 * 	<li>Accept the order</li>
	 *  <li>Complete the order</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param user the user
	 * @param password the password
	 * @param trackingNumber the tracking number
	 * @throws Exception the exception
	 */
	// Login and Accept Order on Vendors
	public void loginAcceptAndCompleteOrder(RemoteWebDriver driver, String user, String password, String trackingNumber) throws Exception
	{
		
		// Login
		login(driver, user, password);
		
		// Accept the order
		acceptOrder(driver, trackingNumber);
		
		//Complete the order
		vendors.completeOrderByHTTPPost(driver, user, password, trackingNumber, "Complete.xml");
		
	} // end loginAcceptAndCompleteOrder
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to the Orders screen</li>
	 * 	<li>Search for the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Click the Accept button</li>
	 * 	<li>Allow popup time to load</li>
	 * 	<li>Select Accept from Select Action dropdown</li>
	 * 	<li>Enter notes</li>
	 * 	<li>Click OK</li>
	 * 	<li>Click OK on acknowledgement</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param trackingNumber the tracking number
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ClassNotFoundException the ClassNotFoundExceptionthe class not found exception
	 * @throws SQLException the SQLExceptionthe SQL exception
	 */
	// Accept Order on Vendors
	public void acceptOrder(RemoteWebDriver driver, String trackingNumber) throws InterruptedException, IOException, ClassNotFoundException, SQLException
	{
		
		ExtentTest test = ExtentTestManager.getTest();
		
		System.out.println("Accept order " + trackingNumber);

		// Open the order if it is not already opened
		if (!driver.getCurrentUrl().contains("/OrderDetails.aspx?LoanID=")) {
			
			// Go to the Orders screen
			goToOrders(driver);
			
			// Search for the order
			findOrder(driver, trackingNumber, "Tracking Number");
			
			// Open the order
			openOrder(driver);
			
		} // end if not already in order details
		
		// Wait for the Send Message button
		perform.waitForElementToBeClickable(driver, VOrderDetails.sendMessage_btn(), "cssSelector");
		
		// Click the Accept button
		perform.click(driver, VOrderDetails.acceptDecline_btn(driver));
		
		// Allow popup time to load
		Thread.sleep(1500);
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for Select Action dropdown
		perform.waitForElementToBeClickable(driver, VOrderAcknowledgement.selectAction_dropdown(), "id");

		// Select Accept from Select Action dropdown
		perform.selectDropdownOption(driver, VOrderAcknowledgement.selectAction_dropdown(driver), "Accept this Assignment");
		
		// Enter notes
		perform.type(driver, VOrderAcknowledgement.acceptAssignmentNotes_txtbx(driver), "These are accepting notes");
		
		// Click OK
		perform.click(driver, VOrderAcknowledgement.ok_btn(driver));
		
		// Wait for Ok button
		perform.waitForElementToBeClickable(driver, VOrderAcknowledgement.orderAcknowledgementOK_btn(), "id");
		
		// Click OK on acknowledgement
		perform.click(driver, VOrderAcknowledgement.orderAcknowledgementOK_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Wait for the audit trail to show the order has been accepted
		perform.waitForText(driver, VOrderDetails.history_txt(driver), "Order accepted by");
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Accepted order: " + trackingNumber);
		
	} // end acceptOrder
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to the Orders screen</li>
	 * 	<li>Search for the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Click on order</li>
	 * 	<li>Click View Order</li>
	 * 	<li>Click the Accept button</li>
	 * 	<li>Allow popup time to load</li>
	 * 	<li>Select Decline from Select Action dropdown</li>
	 * 	<li>Enter notes</li>
	 * 	<li>Click OK</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param trackingNumber the tracking number
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ClassNotFoundException the ClassNotFoundExceptionthe class not found exception
	 * @throws SQLException the SQLExceptionthe SQL exception
	 */
	// Decline Order on Vendors
	public void declineOrder(RemoteWebDriver driver, String trackingNumber) throws InterruptedException, IOException, ClassNotFoundException, SQLException
	{
		
		ExtentTest test = ExtentTestManager.getTest();
		
		System.out.println("Decline order " + trackingNumber);

		// Go to the Orders screen
		goToOrders(driver);
		
		// Search for the order
		findOrder(driver, trackingNumber, "Tracking Number");

		// Open the order
		if (StoredVariables.getmobile().get()==false) {
			Actions action = new Actions(driver);
			WebElement e = driver.findElement(By.cssSelector("img[src='Images/OrderIcons/M.png']"));
			action.doubleClick(e).perform();
		} else {
			// Click on order
			perform.click(driver, driver.findElement(By.cssSelector("tbody[mkr='rows'] > tr > td:nth-child(2)")));
			
			// Click View Order
			perform.clickInTable_Equals(driver, "View Order");
			
		} // end if/else
		
		// Wait for the Send Message button
		perform.waitForElementToBeClickable(driver, VOrderDetails.sendMessage_btn(), "cssSelector");
		
		// Click the Accept button
		perform.click(driver, VOrderDetails.acceptDecline_btn(driver));
		
		// Allow popup time to load
		Thread.sleep(1500);
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for Select Action dropdown
		perform.waitForElementToBeClickable(driver, VOrderAcknowledgement.selectAction_dropdown(), "id");

		// Select Decline from Select Action dropdown
		perform.selectDropdownOption(driver, VOrderAcknowledgement.selectAction_dropdown(driver), "Decline this Assignment");
		
		// Enter notes
		perform.type(driver, VOrderAcknowledgement.declineAssignmentNotes_txtbx(driver), "These are declining notes");
		
		// Click OK
		perform.click(driver, VOrderAcknowledgement.ok_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Declined the order: " + trackingNumber);
		
	} // end declineOrder
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to the Orders screen</li>
	 * 	<li>Search for the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Click the Accept button</li>
	 * 	<li>Allow popup time to load</li>
	 * 	<li>Select Decline from Select Action dropdown</li>
	 * 	<li>Enter notes</li>
	 * 	<li>Enter new fee</li>
	 * 	<li>Click OK</li>
	 * 	<li>Click OK</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param trackingNumber the tracking number
	 * @param newFee the new fee
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ClassNotFoundException the ClassNotFoundExceptionthe class not found exception
	 * @throws SQLException the SQLExceptionthe SQL exception
	 */
	// Decline Order on Vendors
	public void conditionallyDeclineOrder(RemoteWebDriver driver, String trackingNumber, String newFee) throws InterruptedException, IOException, ClassNotFoundException, SQLException
	{
		
		ExtentTest test = ExtentTestManager.getTest();
		
		System.out.println("Decline order " + trackingNumber);

		// Go to the Orders screen
		goToOrders(driver);
		
		// Search for the order
		findOrder(driver, trackingNumber, "Tracking Number");
		
		// Open the order
		Actions action = new Actions(driver);
		WebElement e = driver.findElement(By.cssSelector("img[src='Images/OrderIcons/M.png']"));
		action.doubleClick(e).perform();
		
		// Wait for the Send Message button
		perform.waitForElementToBeClickable(driver, VOrderDetails.sendMessage_btn(), "cssSelector");
		
		// Click the Accept button
		perform.click(driver, VOrderDetails.acceptDecline_btn(driver));
		
		// Allow popup time to load
		Thread.sleep(1500);
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for Select Action dropdown
		perform.waitForElementToBeClickable(driver, VOrderAcknowledgement.selectAction_dropdown(), "id");

		// Select Decline from Select Action dropdown
		perform.selectDropdownOption(driver, VOrderAcknowledgement.selectAction_dropdown(driver), "Propose Conditions to Client");
		
		// Enter notes
		perform.type(driver, VOrderAcknowledgement.conditionalDeclineNotes_txtbx(driver), "These are conditional declining notes");
		
		// Enter new fee
		perform.type(driver, VOrderAcknowledgement.fee_txtbx(driver), newFee);
		
		// Click OK
		perform.click(driver, VOrderAcknowledgement.ok_btn(driver));
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, VOrderAcknowledgement.orderAcknowledgementOK_btn(), "id");
		
		// Click OK
		perform.click(driver, VOrderAcknowledgement.orderAcknowledgementOK_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Conditionally Declined the order: " + trackingNumber + " and proposed a new fee of: " + newFee);
		
	} // end conditionallyDeclineOrder
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to the Orders screen</li>
	 * 	<li>Search for the order</li>
	 * 	<li>Set the order icon element</li>
	 * 	<li>Open the order</li>
	 * 	<li>Click the order</li>
	 * 	<li>Click View Order</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param trackingNumber the tracking number
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ClassNotFoundException the ClassNotFoundExceptionthe class not found exception
	 * @throws SQLException the SQLExceptionthe SQL exception
	 */
	// Open Order on Vendors
	public void findAndOpenOrder(RemoteWebDriver driver, String trackingNumber) throws InterruptedException, IOException, ClassNotFoundException, SQLException
	{
		
		System.out.println("Open order " + trackingNumber);
		
		// Go to the Orders screen
		goToOrders(driver);
		
		// Search for the order
		findOrder(driver, trackingNumber, "Tracking Number");
		
		// Set the order icon element
		WebElement e = driver.findElement(By.cssSelector("img[src='Images/OrderIcons/M.png']"));
		
		// Open the order
		if (StoredVariables.getmobile().get()==true) {
			// Click the order
			e.click();
			// Click View Order
			perform.clickInTable_Contains(driver, "View Order");
		} else {
			try {
				Actions action = new Actions(driver);
				action.doubleClick(e).perform();
			} catch (Exception e1) {
				// Click the order
				e.click();
				// Click View Order
				perform.clickInTable_Contains(driver, "View Order");
			} // end try/catch
		} // end if/else
		
		// Wait for the Send Message button
		perform.waitForElementToBeClickable(driver, VOrderDetails.sendMessage_btn(), "cssSelector");
		
	} // end openOrder
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the order icon element</li>
	 * 	<li>Open the order</li>
	 * 	<li>Click the order</li>
	 * 	<li>Click View Order</li>
	 * </ul>.
	 *
	 * @param driver the driver
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ClassNotFoundException the ClassNotFoundExceptionthe class not found exception
	 * @throws SQLException the SQLExceptionthe SQL exception
	 */
	// Open Order on Vendors
	public void openOrder(RemoteWebDriver driver) throws InterruptedException, IOException, ClassNotFoundException, SQLException
	{
		
		System.out.println("Open an order");
		
		// Wait for the overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Set the order icon element
		WebElement e = driver.findElement(By.cssSelector("img[src='Images/OrderIcons/M.png']"));
		
		// Wait for element to be clickable
		perform.waitForElementToBeClickable(driver, e);
		
		// Open the order
		if (StoredVariables.getmobile().get()==true) {
			// Click the order
			e.click();
			// Click View Order
			perform.clickInTable_Contains(driver, "View Order");
		} else {
			Actions action = new Actions(driver);
			action.doubleClick(e).perform();
		} // end if/else
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for the Send Message button
		perform.waitForElementToBeClickable(driver, VOrderDetails.sendMessage_btn(), "cssSelector");
		
	} // end openOrder
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get the Property ID (trackingID)</li>
	 * 	<li>Set filePath</li>
	 * 	<li>Modify XML File</li>
	 * 	<li>Convert xml file to a string</li>
	 * 	<li>URL Encode the xml string</li>
	 * 	<li>Send the Post</li>
	 * 	<li>Refresh the page</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param user the user
	 * @param password the password
	 * @param loanID the loan ID
	 * @param fileName the file name
	 * @throws Exception the exception
	 */
	public void completeOrderByHTTPPost(RemoteWebDriver driver, String user, String password, String loanID, String fileName) throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		
		perform.sleep(driver, 10);
		
		// Get the Property ID (trackingID)
		String trackingID = db.getProductItemID(driver, loanID);
		
		// Set filePath
		String filePath = null;
		if (fileName.equals("")) {
			filePath = StoredVariables.getdocDir().get()+"Complete.xml";
		} else {
			filePath = StoredVariables.getdocDir().get()+fileName;
		} // end if/else
		System.out.println("filePath: " + filePath);
		
		// Modify XML File
		perform.changeTagElementInXML(driver, "TRACKINGID",trackingID, filePath);
		
		// Convert xml file to a string
		String xml = perform.stringBuilder(driver, StoredVariables.getdocDir().get()+fileName);
		
		// URL Encode the xml string
		xml = URLEncoder.encode(xml, "UTF-8");

		// Send the Post
		perform.sendPost_UpdateAppraisalStatusGlobal(driver, user, password, xml);
		
		// Refresh the page
		driver.navigate().refresh();
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Completed order: " + trackingID + " using the file: " + filePath + " with the UpdateAppraisalStatusGlobal web service");
		
	} // end completeOrderByHTTPPost
	
	// Upload report on Vendors Order Details
//	public void uploadReport(String filePath, String fileNameWithNoExtension) throws InterruptedException, IOException
//	{
//		
//		System.out.println("Uploading a document");
//	
//		// disable the click event on an `<input>` file
//		((JavascriptExecutor)driver).executeScript(
//		    "HTMLInputElement.prototype.click = function() {                     " +
//		    "  if(this.type !== 'file') HTMLElement.prototype.click.call(this);  " +
//		    "};                                                                  " );
//		
////		// trigger the upload
////		perform.click(driver, VOrderDetails.uploadReport_btn(driver));
//		
//		// change the visibility of the file input control
//		WebElement elem = driver.findElement(By.id("UploadLib_Uploader_js"));
//		String js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
//		((JavascriptExecutor) driver).executeScript(js, elem);
//		
//		Thread.sleep(1000);
//		
//		// trigger the upload
//		perform.click(driver, VOrderDetails.uploadReport_btn(driver));
//		
//		// Click away from upload button
////		perform.click(driver, driver.findElement(By.cssSelector("#divSetComplete > div.DialogTitle")));
//		
//		// assign the file to the `<input>`
//		driver.findElement(By.cssSelector("input[type=file]"))
//		      , filePath);
//		
//		Thread.sleep(1000);
//		
//		
//		
//		
//		
////		// Click the message textbx
////		perform.click(driver, VOrderDetails.uploadReportMessageToClient_btn(driver));
////		
////		// Wait for completed check mark icon
////		String attachComplete = VOrderDetails.uploadedReportProgress_txt(driver).getText();
////		// Set 40 second while loop timeout
////		long start_time = System.currentTimeMillis();
////		long wait_time = 40000;
////		long end_time = start_time + wait_time;
////		while (System.currentTimeMillis() < end_time && !attachComplete.contains(fileNameWithNoExtension))
////		{
////			Thread.sleep(1000);
////			attachComplete = VOrderDetails.uploadedReportProgress_txt(driver).getText();
////			if (attachComplete.contains(fileNameWithNoExtension))
////			{
////				System.out.println("attachComplete = " + attachComplete);
////				break;
////			} // end if
////		} // end while
//		
//		
//		
//		
//		
////		System.out.println("Uploaded the Test PDF file");
////		
////		// Wait for OK button
////		perform.waitForElementToBeClickable(driver, VOrderDetails.completeOk_btn(), "id");
//		
//	} // end uploadReportOnVOrderDetails
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>disable the click event on an `&lt;input&gt;` file</li>
	 * 	<li>wait for the upload button</li>
	 * 	<li>trigger the upload</li>
	 * 	<li>assign the file to the `&lt;input&gt;`</li>
	 * 	<li>Add retry if document fails to upload</li>
	 * 	<li>Click OK</li>
	 * 	<li>Click Close</li>
	 * 	<li>Click Close</li>
	 * 	<li>Click Back</li>
	 * 	<li>Open the order</li>
	 * 	<li>Click Attach Documents</li>
	 * 	<li>Select Document Type</li>
	 * 	<li>wait for the upload button</li>
	 * 	<li>Retry document upload</li>
	 * 	<li>assign the file to the `&lt;input&gt;`</li>
	 * 	<li>Click OK</li>
	 * 	<li>Click Close</li>
	 * 	<li>Click Close</li>
	 * 	<li>Set 120 second while loop timeout</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param filePath the file path
	 * @param loanID the loan ID
	 * @param documentType the document type
	 * @throws Exception the exception
	 */
	// Upload document on Vendors Order Details
	public void uploadDocument(RemoteWebDriver driver, String filePath, String loanID, String documentType) throws Exception
	{
		
		ExtentTest test = ExtentTestManager.getTest();
		
		System.out.println("Uploading a document");
	
		Thread.sleep(2000);
		
		// disable the click event on an `<input>` file
		((JavascriptExecutor)driver).executeScript(
		    "HTMLInputElement.prototype.click = function() {                     " +
		    "  if(this.type !== 'file') HTMLElement.prototype.click.call(this);  " +
		    "};                                                                  " );
		
		Thread.sleep(2500);
		
		// wait for the upload button
		perform.waitForElementToBeClickable(driver, VOrderDetails.uploadDocuments_btn(), "id");
		
		// trigger the upload
		perform.click(driver, VOrderDetails.uploadDocuments_btn(driver));
		
		Thread.sleep(2500);
		
		// assign the file to the `<input>`
		driver.findElement(By.cssSelector("input[type=file]")).sendKeys(filePath);
		
		Thread.sleep(5000);
		
		/**************************
		 * RETRY ON FAILURE BLOCK
		 **************************/
		
		// Add retry if document fails to upload
		boolean fail = false;
		int a = 1;
		if (VOrderDetails.okSubmitBid_btn(driver).isDisplayed())
		{
			fail = true;
			
			// Click OK
			perform.click(driver, VOrderDetails.okSubmitBid_btn(driver));
			
			// Click Close
			perform.click(driver, VOrderDetails.close_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
		}
		else if (driver.findElements(By.id(VOrderDetails.attached_icon())).size()<1)
		{
			fail = true;
			
			// Click Close
			perform.click(driver, VOrderDetails.close_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
		}
		
		while (fail==true)
		{
			System.out.println("Failed attempts = " + a);
			
			// Click Back
			perform.click(driver, VOrderDetails.back_btn(driver));
			
			// Wait for Find textbox
			perform.waitForElementToBeClickable(driver, VOrders.find_txtbx(), "id");
			
			// Open the order
			String trackingNumber = db.getTrackingNumber(driver, loanID);
			vendors.findAndOpenOrder(driver, trackingNumber);
			
			// Click Attach Documents
			perform.click(driver, VOrderDetails.attachDocuments_btn(driver));
			
			// Wait for the document type dropdown
			perform.waitForElementToBeClickable(driver, VOrderDetails.documentType_dropdown(), "id");
			
			// Select Document Type
			perform.selectDropdownOption(driver, VOrderDetails.documentType_dropdown(driver), documentType);
			
			Thread.sleep(2000);
			
			// wait for the upload button
			perform.waitForElementToBeClickable(driver, VOrderDetails.uploadDocuments_btn(), "id");
			
			// Retry document upload
			// assign the file to the `<input>`
			driver.findElement(By.cssSelector("input[type=file]")).sendKeys(filePath);
			
			Thread.sleep(5000);
			
			List<WebElement> attachIcon = driver.findElements(By.id(VOrderDetails.attached_icon()));
			if (!VOrderDetails.okSubmitBid_btn(driver).isDisplayed() && attachIcon.size()>0)
			{
				fail = false;
			}
			
			if (fail == true) {
				
				if (VOrderDetails.okSubmitBid_btn(driver).isDisplayed())
				{
					fail = true;
					
					// Click OK
					perform.click(driver, VOrderDetails.okSubmitBid_btn(driver));
					
					// Click Close
					perform.click(driver, VOrderDetails.close_btn(driver));
					
					// Wait for overlay to be hidden
					perform.waitForOverlayToBeHidden(driver);
					
				}
				else if (driver.findElements(By.id(VOrderDetails.attached_icon())).size()==0)
				{
					fail = true;
					
					// Click Close
					perform.click(driver, VOrderDetails.close_btn(driver));
					
					// Wait for overlay to be hidden
					perform.waitForOverlayToBeHidden(driver);
				}
			} // end if
			
			a++;
		} // end Fail
			
		/**************************
		 * RETRY ON FAILURE BLOCK
		 **************************/
		
		// Wait for completed check mark icon
		perform.waitForElementToBeVisible(driver, VOrderDetails.attached_icon(), "id");
		String attachComplete = VOrderDetails.attached_icon(driver).getAttribute("class");
		// Set 120 second while loop timeout
		long start_time = System.currentTimeMillis();
		long wait_time = 120000;
		long end_time = start_time + wait_time;
		while (System.currentTimeMillis() < end_time && !attachComplete.contains("OuterIconComplete"))
		{
			Thread.sleep(1000);
			attachComplete = VOrderDetails.attached_icon(driver).getAttribute("class");
			if (attachComplete.contains("OuterIconComplete"))
			{
				break;
			} // end if
		} // end while
		
		// Wait for Close button
		perform.waitForElementToBeClickable(driver, VOrderDetails.close_btn(), "id");
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Uploaded the document: " + filePath + " to order: " + loanID);
		
	} // end uploadDocumentOnVOrderDetails
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Verify credit card will be charged text</li>
	 * 	<li>Click OK on order acknowledgement popup</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Close Order Acknowledgement Dialog
	public void closeOrderAcknowledgementDialog(RemoteWebDriver driver) throws InterruptedException, IOException
	{
		
		System.out.println("Close the Order Acknowledgement dialog");
	
		// Wait for text
		perform.waitForElementToBeVisible(driver, VOrderAcknowledgement.orderAcknowledgement_txt(), "id");
		
		// Verify credit card will be charged text
		Assert.assertTrue(VOrderAcknowledgement.orderAcknowledgement_txt(driver).getText().contains("be charged a transaction fee for this order because the client"), "Order acknowledgement text did not display properly - " + VOrderAcknowledgement.orderAcknowledgement_txt(driver).getText());	
		
		// Click OK on order acknowledgement popup
		perform.click(driver, VOrderAcknowledgement.orderAcknowledgementOK_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Wait for the Orders button to be clickable
		perform.waitForElementToBeClickable(driver, VOrders.orders_btn(), "cssSelector");
		
	} // end closeOrderAcknowledgementDialog
	
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
	// Save Users Settings
	public void saveUsersSettings(RemoteWebDriver driver) throws InterruptedException
	{

		// Click Save
		perform.click(driver, VUsers.save_btn(driver));
		
		// Wait for overlay to be displayed
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, VUsers.okSave_btn(), "id");
		
		// Verify Dialog Text
		Assert.assertTrue(VUsers.dialogSave_txt(driver).getText().contains("Changes were successfully saved."), "Save dialog text is incorrect");
		
		// Click OK
		perform.click(driver, VUsers.okSave_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
	} // end saveUsersSettings
	
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
	public void saveSearchSettings(RemoteWebDriver driver) throws InterruptedException
	{

		//Click Save
		perform.click(driver, VOrders.searchOptionSave_btn(driver));
		
		//Wait for custom search dialog
		perform.waitForElementToBeClickable(driver, VOrders.searchOptionOK_btn(driver));
		
		//Click OK button
		perform.click(driver, VOrders.searchOptionOK_btn(driver));
		
		// Wait for the overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
	} // end saveSearchSettings
	
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
		perform.click(driver, VAccount.manage_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, VAccount.okManagePaymentMethods_btn(), "id");
		
		// Get the number of payment methods
		int numOfPaymentMethods = perform.getNumOfRowsInTableID(driver, VAccount.managePaymentMethods_table())-1;
		System.out.println("Number of payment methods = " + (numOfPaymentMethods));
		
		// Delete payment methods
		while (numOfPaymentMethods > 0)
		{

			// Handle deletion of payment method
			handleDeletionOfPaymentMethod(driver, "1");
			
			// Get number of payment methods
			numOfPaymentMethods = perform.getNumOfRowsInTableID(driver, VAccount.managePaymentMethods_table())-1;
			
		} // end while number of payments are greater than 0
		
		// Click OK
		perform.click(driver, VAccount.okManagePaymentMethods_btn(driver));
		
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
		perform.click(driver, VAccount.manage_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, VAccount.okManagePaymentMethods_btn(), "id");
		
		// Get the number of payment methods
		int numOfPaymentMethods = perform.getNumOfRowsInTableID(driver, VAccount.managePaymentMethods_table())-1;
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
	 * 	<li>Get the dialog text</li>
	 * 	<li>If the payment method could not be deleted, edit the card info and then try deleting again</li>
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
		perform.click(driver, VAccount.deletedCard_btn(driver, cardIndex));
		
		// Wait for Yes button
		perform.waitForElementToBeClickable(driver, VAccount.yes_btn(), "id");
		
		// Click Yes
		perform.click(driver, VAccount.yes_btn(driver));
		
		// Wait for busy
		perform.waitForBusyToBeHidden(driver);
		
		// If the payment method could not be deleted, edit the card info and then delete it
		if (!VAccount.okManagePaymentMethods_btn(driver).isDisplayed()) {
		
			// Get the dialog message
			String dialog = VAccount.dialog_txt(driver).getText();
			System.out.println("Dialog text: " + dialog);
			
			// Delete the payment method or edit and then delete if you cannot
			if (dialog.contains("Unable to delete")) {
				
				// Click OK on the Unable to delete dialog
				perform.click(driver, VAccount.ok_btn(driver));
				
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
				perform.click(driver, VAccount.deletedCard_btn(driver, cardIndex));
				
				// Wait for Yes button
				perform.waitForElementToBeClickable(driver, VAccount.yes_btn(), "id");
				
				// Click Yes
				perform.click(driver, VAccount.yes_btn(driver));
				
				// Wait for busy
				perform.waitForBusyToBeHidden(driver);
				
			} // end if dialog contains unable to delete
			
		} // end if card could not be deleted
		
		// Wait for busy
		perform.waitForBusyToBeHidden(driver);

		// Wait for OK button
		perform.waitForElementToBeClickable(driver, VAccount.okManagePaymentMethods_btn(), "id");

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
		perform.click(driver, VAccount.editCard_btn(driver, cardIndex));
		
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
	 */
	// Edit individual payment method
	public void enterNewCreditCardInfo(RemoteWebDriver driver, String firstName, String lastName, String streetAddress, String city, String state, String zipCode, String creditCardNumber, String expMonth, String expYear, String emailAddress, boolean primary) throws InterruptedException
	{
		
		// Wait 2 seconds
		perform.sleep(driver, 2);
		
		// Switch iFrame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "StoreCard2.aspx?", By.id(VAccount.firstName_txtbx()));
		
		// Wait for First Name textbox
		perform.waitForElementToBeClickable(driver, VAccount.firstName_txtbx(), "id");
		
		// Enter First Name
		perform.type(driver, VAccount.firstName_txtbx(driver), firstName);
		
		// Enter Last Name
		perform.type(driver, VAccount.lastName_txtbx(driver), lastName);
		
		// Enter Address
		perform.type(driver, VAccount.address_txtbx(driver), streetAddress);
		
		// Enter City
		perform.type(driver, VAccount.city_txtbx(driver), city);
		
		// Select State
		perform.selectDropdownOption(driver, VAccount.state_dropdown(driver), state);
		
		// Enter Zip
		perform.type(driver, VAccount.zip_txtbx(driver), zipCode);
		
		// Enter Card Number
		perform.type(driver, VAccount.cardNumber_txtbx(driver), creditCardNumber);
		
		// Select Expiration Month
		perform.selectDropdownOption(driver, VAccount.expirationMonth_dropdown(driver), expMonth);
		
		// Select Expiration Year
		perform.selectDropdownOption(driver, VAccount.expirationYear_dropdown(driver), expYear);
		
		// Enter Email
		perform.type(driver, VAccount.email_txtbx(driver), emailAddress);
		
		// Select Primary checkbox
		if (primary==true)
		{
			try
			{
				if (VAccount.primary_chkbx(driver).isSelected()==false)
				{
					perform.click(driver, VAccount.primary_chkbx(driver));
				} // end if not selected
			} // end try
			catch(Exception e){}
		} // end if primary == true
		
		// Verify the information is entered correctly
		// First Name
		if (!VAccount.firstName_txtbx(driver).getAttribute("value").equals(firstName)) {
			// Enter First Name
			perform.type(driver, VAccount.firstName_txtbx(driver), firstName);			
		} // end if first name
		
		// Last Name
		if (!VAccount.lastName_txtbx(driver).getAttribute("value").equals(lastName)) {
			// Enter Last Name
			perform.type(driver, VAccount.lastName_txtbx(driver), lastName);			
		} // end if last name
		
		// Zip Code
		if (!VAccount.zip_txtbx(driver).getAttribute("value").equals(lastName)) {
			// Enter Zip Code
			perform.type(driver, VAccount.zip_txtbx(driver), zipCode);			
		} // end if zip
		
		// Card Number
		if (!VAccount.cardNumber_txtbx(driver).getAttribute("value").equals(lastName)) {
			// Enter Card Number
			perform.type(driver, VAccount.cardNumber_txtbx(driver), creditCardNumber);			
		} // end if card number
		
		// Expiration Month
		if (!perform.getSelectedDropdownOption(driver, VAccount.expirationMonth_dropdown(driver)).equals(expMonth)) {
			// Select Expiration Year
			perform.selectDropdownOption(driver, VAccount.expirationMonth_dropdown(driver), expMonth);			
		} // end if exp year
		
		// Expiration Year
		if (!perform.getSelectedDropdownOption(driver, VAccount.expirationYear_dropdown(driver)).equals(expYear)) {
			// Select Expiration Year
			perform.selectDropdownOption(driver, VAccount.expirationYear_dropdown(driver), expYear);			
		} // end if exp year

		// Click Save
		perform.click(driver, VAccount.saveCreditCard_btn(driver));

		// Switch out of iFrame
		driver.switchTo().defaultContent();
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, VAccount.okManagePaymentMethods_btn(), "id");

		// Add info to Extent Report
		perform.addInfoToExtentReport(driver, "Info", "Entered new credit card information");
		
	} // end editIndividualPaymentMethod
	
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
		perform.click(driver, VAccount.manage_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, VAccount.okManagePaymentMethods_btn(), "id");
		
		// Get the number of payment methods
		int numOfPaymentMethods = perform.getNumOfRowsInTableID(driver, VAccount.managePaymentMethods_table())-1;
		System.out.println("Number of payment methods = " + (numOfPaymentMethods));
		Assert.assertTrue(numOfPaymentMethods < 2, "No more payment methods can be added becasue there are already 2 payment methods");
		
		// Click Add a credit card
		perform.click(driver, VAccount.addCreditCard_btn(driver));
		
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
		enterNewCreditCardInfo(driver, firstName, lastName, streetAddress, city, state, zipCode, creditCardNumber, expMonth, expYear, emailAddress, primary);
		
		// Click OK
		perform.click(driver, VAccount.okManagePaymentMethods_btn(driver));
		
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
		perform.click(driver, VAccount.manage_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, VAccount.okManagePaymentMethods_btn(), "id");
		
		// Get the number of payment methods
		int numOfPaymentMethods = perform.getNumOfRowsInTableID(driver, VAccount.managePaymentMethods_table())-1;
		System.out.println("Number of payment methods = " + (numOfPaymentMethods));
		Assert.assertTrue(numOfPaymentMethods < 2, "No more payment methods can be added becasue there are already 2 payment methods");
		
		// Click Add a checking account
		perform.click(driver, VAccount.addCheckingAccount_btn(driver));
		
		// Switch iFrame
		driver.switchTo().defaultContent();
		perform.waitForiFrameSrcAndSwitchToIt(driver, "/manage.aspx", By.id(VAccount.nameOnAccount_txtbx()));
		
		// Wait for Name on account textbox
		perform.waitForElementToBeClickable(driver, VAccount.nameOnAccount_txtbx(), "id");
		
		// Enter First Name
		String nameOnAccount = "Auto" + perform.randomNumbers(driver, 3) + " ACHUser";
		perform.type(driver, VAccount.nameOnAccount_txtbx(driver), nameOnAccount);
		
		// Enter Bank routing number
		perform.type(driver, VAccount.routingNumber_txtbx(driver), "103000130");
		
		// Enter Account number
		perform.type(driver, VAccount.accountNumber_txtbx(driver), accountNumber);
		
		// Enter Confirm account number
		perform.type(driver, VAccount.confirmAccountNumber_txtbx(driver), accountNumber);
		
		// Select Personal radio button
		perform.click(driver, VAccount.personal_radiobtn(driver));
		
		// Click Save
		perform.click(driver, VAccount.saveACH_btn(driver));
		
		// Switch out of iFrame
		driver.switchTo().defaultContent();
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, VAccount.okManagePaymentMethods_btn(), "id");
		
		// Click OK
		perform.click(driver, VAccount.okManagePaymentMethods_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Added ACH account: " + accountNumber);
		
	} // end addTestACHAccount
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click Submit Bid</li>
	 * 	<li>Enter bid amount</li>
	 * 	<li>Enter Turn time</li>
	 * 	<li>Click Continue</li>
	 * 	<li>Check I have no interest checkbox</li>
	 * 	<li>Check I have performed checkbox</li>
	 * 	<li>Check I have no bias checkbox</li>
	 * 	<li>Check My engagement checkbox</li>
	 * 	<li>Click Submit button</li>
	 * 	<li>Click OK</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param bidAmount the bid amount
	 * @param turnTime the turn time
	 * @throws InterruptedException the interrupted exception
	 */
	public void submitBidWithBidAmount(RemoteWebDriver driver, String bidAmount, String turnTime) throws InterruptedException {
		
		ExtentTest test = ExtentTestManager.getTest();
		
		// Click Submit Bid
		perform.click(driver, VOrderDetails.submitBid_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for text area
		perform.waitForElementToBeClickable(driver, VOrderDetails.wontBeCharged_txt(), "id");
		
		// Enter bid amount
		perform.type(driver, VOrderDetails.appraisalBid_txtbx(driver), bidAmount);
		
		// Enter Turn time
		perform.type(driver, VOrderDetails.turnTime_txtbx(driver), turnTime);
		
		// Click Continue
		perform.click(driver, VOrderDetails.continue_btn(driver));
		
		// Wait for Submit button
		perform.waitForElementToBeClickable(driver, VOrderDetails.submit_btn(), "id");
		
		// Check I have no interest checkbox
		perform.checkCheckbox(driver, VOrderDetails.iHaveNoInterest_chkbx(driver));
		
		// Check I have performed checkbox
		perform.checkCheckbox(driver, VOrderDetails.iHavePerformed_chkbx(driver));
		
		// Check I have no bias checkbox
		perform.checkCheckbox(driver, VOrderDetails.iHaveNoBias_chkbx(driver));
		
		// Check My engagement checkbox
		perform.checkCheckbox(driver, VOrderDetails.myEngagement_chkbx(driver));
		
		// Click Submit button
		perform.click(driver, VOrderDetails.submit_btn(driver));
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, VOrderDetails.okSubmitBid_btn(), "id");
		
		// Click OK
		perform.click(driver, VOrderDetails.okSubmitBid_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Submitted a bid for: " + bidAmount);
		
	} // end submitBidWithBidAmount
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click Submit Bid</li>
	 * 	<li>Accept or Decline the bid</li>
	 * 	<li>Select I accept these terms radio button</li>
	 * 	<li>Select I am unable to bid on this opportunity</li>
	 * 	<li>Enter notes</li>
	 * 	<li>Click Submit button</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param accept the accept
	 * @param message the message
	 * @throws InterruptedException the interrupted exception
	 */
	public void submitBidWithFixedFee(RemoteWebDriver driver, boolean accept, String message) throws InterruptedException {
		
		// Click Submit Bid
		perform.click(driver, VOrderDetails.submitBid_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Switch into iFrame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "Bidding/SubmitBid.aspx", By.id(VOrderDetails.continue_btn()));
		
		// Wait for Submit button
		perform.waitForElementToBeClickable(driver, VOrderDetails.continue_btn(driver));
		
		// Accept or Decline the bid
		if (accept==true) {
			// Select I accept these terms radio button
			perform.click(driver, VOrderDetails.iAcceptTheseTerms_radiobtn(driver));			
		} else if (accept==false) {
			// Select I am unable to bid on this opportunity
			perform.click(driver, VOrderDetails.iAmUnableToBidOnThisOpportunity_radiobtn(driver));
		} // end if/else
		
		// Enter notes
		perform.type(driver, VOrderDetails.provideAMessageToTheClient_txtbx(driver), message);
		
		// Click Submit button
		perform.click(driver, VOrderDetails.continue_btn(driver));
		
		if (accept==false) {
			
			// Wait for the dialog to contain text
			perform.waitForText(driver, VOrderDetails.declineDialog_txt(driver), "If you decline");
			
			// Verify the Decline dialog text
			perform.verification(driver, VOrderDetails.declineDialog_txt(driver).getText(), "contains", 
					"If you decline to bid, you will no longer be eligible for this order. If you wish to discuss options with your client, please send a message instead.");
			
			// Click Decline button
			perform.click(driver, VOrderDetails.okSubmitBid_btn(driver));
			
			// Wait for the dialog to contain text
			perform.waitForText(driver, VOrderDetails.declineDialog_txt(driver), "The client will be notified");
			
			// Verify the Decline dialog text
			perform.verification(driver, VOrderDetails.declineDialog_txt(driver).getText(), "contains", 
					"The client will be notified you are unable to bid at this time.");
			
			// Click OK button
			perform.click(driver, VOrderDetails.okSubmitBid_btn(driver));
			
		} // end if
		
		// Get out of iFrame
		driver.switchTo().defaultContent();
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		perform.sleep(driver, 3);
		
		// Add info to Extent Report
		perform.addInfoToExtentReport(driver, "Info", "Submitted a bid decision: " + accept);
		
	} // end submitBidWithFixedFee
	
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
	 * 	<li>Go to new window</li>
	 * 	<li>Get the new Window Handle</li>
	 * 	<li>Switch to the new window</li>
	 * 	<li>Switch to new frame</li>
	 * 	<li>driver.switchTo().frame(driver.findElement(By.xpath("frame[contains(@src,'Invoice.aspx')]")));</li>
	 * 	<li>Close third window</li>
	 * 	<li>Switch back to second window</li>
	 * 	<li>Close second window</li>
	 * 	<li>Switch back to original window</li>
	 * 	<li>Switch out of frame</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @return the invoice number
	 * @throws Exception the exception
	 */
	public  int getInvoiceNumber(RemoteWebDriver driver) throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		
		// Open the order
		secure.openOrder(driver, StoredVariables.getloanID().get());
		
		// Click View XSite order link
		perform.click(driver, SOrderDetails.viewXSiteOrder_lnk(driver));
		
		// Switch to new window
		perform.switchToXSiteWindowByTitle(driver, "Buesiness Management");
		
		// Switch to iFrame
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("Main"));
		
		perform.waitForElementToBeClickable(driver, XBusinessManagement.billing_btn(), "id");
		
		// Click Billing
		perform.click(driver, XBusinessManagement.billing_btn(driver));
		
		// Click Invoices
		perform.clickLabelText(driver, "Invoice");
		
		// Switch out of iFrame
		driver.switchTo().defaultContent();
		
		// Go to new window
	    Iterator<String> windowIterator = driver.getWindowHandles()
	            .iterator();
	    while (windowIterator.hasNext()) {
	        String windowHandle1 = windowIterator.next();
	        driver.switchTo().window(windowHandle1);
	        String title = driver.getTitle();
	        System.out.println("title = " + title);
	        if (title.contains("Create an Invoice")) {
	        	System.out.println("break");
	            break;
	        } // end if
	    } // end while loop
		
		// Get the new Window Handle
	    String thirdWindow = driver.getWindowHandle();
	    
	    Thread.sleep(3000);
		
		// Switch to the new window
		driver.switchTo().window(thirdWindow);
		
		System.out.println("TITLE = " + driver.getTitle());
		
		Thread.sleep(3000);
		
		// Switch to new frame
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[contains(@src,'Invoice.aspx')]")));
		
		Thread.sleep(3000);
		
		// Wait for Invoice Number textbox
		perform.waitForElementToBeClickable(driver, XInvoice.invoiceNumber_txtbx(), "id");

		// Get invoice number
		int invoiceNumber = Integer.parseInt(XInvoice.invoiceNumber_txtbx(driver).getAttribute("value").replace("AUTO-", ""));
		
		// Close third window
		driver.close();
		
		// Switch back to second window
		driver.switchTo().window(StoredVariables.getnewWinHandle().get());
		
		// Close second window
		driver.close();
		
		// Switch back to original window
		driver.switchTo().window(StoredVariables.getwinHandleBefore().get());
		
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
	 * 	<li>Click Set Order Status</li>
	 * 	<li>Click Inspection Scheduled</li>
	 * 	<li>Click the calendar button</li>
	 * 	<li>Select date</li>
	 * 	<li>Verify the correct order due date is correct</li>
	 * 	<li>Add notes</li>
	 * 	<li>Click OK</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param days the days
	 * @param notes the notes
	 * @throws InterruptedException the interrupted exception
	 */
	public void inspectionScheduled(RemoteWebDriver driver, int days, String notes) throws InterruptedException {
		
		ExtentTest test = ExtentTestManager.getTest();
		
		// Click Set Order Status
		perform.click(driver, VOrderDetails.setOrderStatus_btn(driver));
		
		// Click Inspection Scheduled
		perform.click(driver, VOrderDetails.inspectionScheduled_btn(driver));
		
		// Wait for Overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for OK button to be clickable
		perform.waitForElementToBeClickable(driver, VOrderDetails.inspectionScheduledOk_btn(), "cssSelector");
		
		// Click the calendar button
		perform.click(driver, VOrderDetails.inspectionScheduledCalendar_btn(driver));
		
		// Select date
		secure.selectDateFromCalendar(driver, days);
		
		// Verify the correct order due date is correct
		Assert.assertTrue(VOrderDetails.inspectionScheduledCalendar_txtbx(driver).getAttribute("value").equals(StoredVariables.getcalendarDateLong().get()), "Date selected from calendar is the wrong date");
		
		// Add notes
		perform.type(driver, VOrderDetails.inspectionScheduledNotes_txtbx(driver), notes);
		
		// Click OK
		perform.click(driver, VOrderDetails.inspectionScheduledOk_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Set Inspection Scheduled");
		
	} // end inspectionScheduled
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click Set Order Status</li>
	 * 	<li>Click Inspection Complete</li>
	 * 	<li>Click the calendar button</li>
	 * 	<li>Select date</li>
	 * 	<li>Verify the correct order due date is correct</li>
	 * 	<li>Add notes</li>
	 * 	<li>Click OK</li>
	 * 	<li>Add info to Extent Report</li>
	 * 	<li>Send message</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param days the days
	 * @param notes the notes
	 * @throws InterruptedException the interrupted exception
	 */
	public void inspectionComplete(RemoteWebDriver driver, int days, String notes) throws InterruptedException {
		
		ExtentTest test = ExtentTestManager.getTest();
		
		// Click Set Order Status
		perform.click(driver, VOrderDetails.setOrderStatus_btn(driver));
		
		// Click Inspection Complete
		perform.click(driver, VOrderDetails.inspectionComplete_btn(driver));
		
		// Wait for Overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for OK button to be clickable
		perform.waitForElementToBeClickable(driver, VOrderDetails.inspectionScheduledOk_btn(), "cssSelector");
		
		// Click the calendar button
		perform.click(driver, VOrderDetails.inspectionScheduledCalendar_btn(driver));
		
		// Select date
		secure.selectDateFromCalendar(driver, days);
		
		// Verify the correct order due date is correct
		Assert.assertTrue(VOrderDetails.inspectionScheduledCalendar_txtbx(driver).getAttribute("value").equals(StoredVariables.getcalendarDateLong().get()), "Date selected from calendar is the wrong date");
		
		// Add notes
		perform.type(driver, VOrderDetails.inspectionScheduledNotes_txtbx(driver), notes);
		
		// Click OK
		perform.click(driver, VOrderDetails.inspectionScheduledOk_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		perform.sleep(driver, 15);
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Set Inspection Complete");
		
	} // end inspectionComplete
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click Send Message</li>
	 * 	<li>Enter Notes</li>
	 * 	<li>Click Send</li>
	 * 	<li>Add info to Extent Report</li>
	 * 	<li>Sort by column</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param notes the notes
	 * @throws InterruptedException the interrupted exception
	 */
	// Send message
	public void sendMessage(RemoteWebDriver driver, String notes) throws InterruptedException {

		ExtentTest test = ExtentTestManager.getTest();
		
		// Click Send Message
		perform.click(driver, VOrderDetails.sendMessage_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for Send button
		perform.waitForElementToBeClickable(driver, VOrderDetails.send_btn(), "cssSelector");
		
		// Enter Notes
		perform.type(driver, VOrderDetails.sendMessageNotes_txtbx(driver), notes);
		
		// Click Send
		perform.click(driver, VOrderDetails.send_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Send a message: " + notes);
		
	} // end sendMessage
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>perform.waitForElementToBeClickable(driver, "th[contains(text(), '" + column + "')]", "xpath");</li>
	 * 	<li>Click the column</li>
	 * 	<li>Verify column is ordered properly to display the most recent order first</li>
	 * 	<li>Click the column</li>
	 * 	<li>Get the new count of the desc arrow element</li>
	 * 	<li>Open QL dialog</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param column the column
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Sort by column
	public void sortByColumn(RemoteWebDriver driver, String column) throws InterruptedException, IOException
	{
		
		System.out.println("Sorting by column = " + column);

		perform.waitForElementToBeClickable(driver, "//th[contains(text(), '" + column + "')]", "xpath");
		
		// Click the column
		perform.clickInTableColumn_Contains(driver, column);
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Verify column is ordered properly to display the most recent order first
		List<WebElement> asc = driver.findElements(By.cssSelector("img[src='/Styles/Infragistics/Main_Alpha14_01/images/igg_sortAsc.gif']"));
		int descCount = 0;
		
		if (asc.size() > 0)
		{
			while (descCount==0)
			{
				// Click the column
				perform.clickInTableColumn_Contains(driver, column);
	
				Thread.sleep(1000);
				
				// Get the new count of the desc arrow element
				List<WebElement> desc = driver.findElements(By.cssSelector("img[src='/Styles/Infragistics/Main_Alpha14_01/images/igg_sortDesc.gif']"));
				descCount = desc.size();
			} // end while loop
		} // end if
			
	} // end sortByColumn
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click the QL icon in the comments field</li>
	 * 	<li>Switch to the QL iFrame</li>
	 * 	<li>perform.waitForIFrames(driver);</li>
	 * 	<li>driver.switchTo().frame(0);</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param textArea the text area
	 * @param QL_id the q L id
	 * @throws InterruptedException the interrupted exception
	 */
	// Open QL dialog
	public void openQLDialog(RemoteWebDriver driver, WebElement textArea, WebElement QL_id) throws InterruptedException {

		// Click the QL icon in the comments field
		try {
			perform.click(driver, textArea);
			perform.hover(driver, textArea);
			perform.waitForElementToBeClickable(driver, QL_id.getAttribute("id"), "id");
			perform.click(driver, QL_id);
		} catch (Exception e) {
			System.err.println("Could not click QL initially. Trying again");
			perform.click(driver, textArea);
			perform.hover(driver, textArea);
			perform.waitForElementToBeClickable(driver, QL_id.getAttribute("id"), "id");
			perform.click(driver, QL_id);
		} // end try/catch
		
		Thread.sleep(3000);
		
		// Switch to the QL iFrame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "/Common/Lists/Quick.aspx", By.id(VQuickList.close_btn()));
//		perform.waitForIFrames(driver);
//		driver.switchTo().frame(0);
		
		// Wait for QL Close button
		try {
			perform.waitForElementToBeClickable(driver, VQuickList.close_btn(), "id");
		} catch (Exception e) {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(0);
			perform.waitForiFrameSrcAndSwitchToIt(driver, "/Common/Lists/Quick.aspx", By.id(VQuickList.close_btn()));
			perform.waitForElementToBeClickable(driver, VQuickList.close_btn(), "id");
		}
		
		
	} // end openQLDialog
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click the Delete icon</li>
	 * 	<li>Verify dialog text</li>
	 * 	<li>Click Yes</li>
	 * 	<li>Get the QL dialog text</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws InterruptedException the interrupted exception
	 */
	// Delete all QL items
	public void deleteAllQLItems(RemoteWebDriver driver) throws InterruptedException {

		ExtentTest test = ExtentTestManager.getTest();
		
		String qlText = VQuickList.quickListDialog(driver).getText();
		while (!qlText.contains("There are no QuickList Items available to use."))
		{
			Thread.sleep(2000);
			
			// Click the Delete icon
			perform.click(driver, VQuickList.delete_btn(driver));
			
			// Wait for Yes button
			perform.waitForElementToBeClickable(driver, VQuickList.yes_btn(), "id");
			
			// Verify dialog text
			String dialog = VQuickList.messageDialog_txt(driver).getText();
			Assert.assertTrue(dialog.contains("Are you sure you want to delete the selected item?"), "The dialog text should say 'Are you sure you want to delete the selected item?'. The dialog = " + dialog);
			
			// Click Yes
			perform.click(driver, VQuickList.yes_btn(driver));
			
			Thread.sleep(2000);

			// Get the QL dialog text
			qlText = VQuickList.quickListDialog(driver).getText();
			
		} // end while
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Delete all QL items");
		
	} // end deleteAllQLItems
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click New</li>
	 * 	<li>Enter a description</li>
	 * 	<li>Enter text</li>
	 * 	<li>Click Save</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param description the description
	 * @param text the text
	 * @throws InterruptedException the interrupted exception
	 */
	// Create a new QL item
	public void createNewQLItem(RemoteWebDriver driver, String description, String text) throws InterruptedException {

		ExtentTest test = ExtentTestManager.getTest();
		
		// Click New
		perform.click(driver, VQuickList.new_btn(driver));
		
		// Wait for description textbox
		perform.waitForElementToBeClickable(driver, VQuickList.description_txtbx(), "id");
		
		// Enter a description
		perform.type(driver, VQuickList.description_txtbx(driver), description);
		
		// Enter text
		perform.type(driver, VQuickList.text_txtbx(driver), text);
		
		// Click Save
		perform.click(driver, VQuickList.save_btn(driver));
		
		// Wait for the Close button
		perform.waitForElementToBeClickable(driver, VQuickList.close_btn(), "id");
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Create new QL item titled: " + description + " with the text: " + text);
		
	} // end createNewQLItem
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click the Set Order Status</li>
	 * 	<li>Choose Request Modification</li>
	 * 	<li>Change the Product</li>
	 * 	<li>Change the Due Date</li>
	 * 	<li>Change the fee</li>
	 * 	<li>Change the Payment Method</li>
	 * 	<li>Enter notes</li>
	 * 	<li>Click OK</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify Modification Requested is in the history</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param product the product
	 * @param dueDate the due date
	 * @param fee the fee
	 * @param paymentMethod the payment method
	 * @param notes the notes
	 * @throws InterruptedException the interrupted exception
	 */
	// Request Modification
	public void requestModification(RemoteWebDriver driver, String product, String dueDate, String fee, String paymentMethod, String notes) throws InterruptedException {

		ExtentTest test = ExtentTestManager.getTest();
		
		// Click the Set Order Status
		perform.click(driver, VOrderDetails.setOrderStatus_btn(driver));
		
		// Choose Request Modification
		perform.click(driver, VOrderDetails.requestModification_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for Fee textbox
		perform.waitForElementToBeClickable(driver, VRequestModification.fee_txtbx(), "id");
		
		// Change the Product
		if (!product.isEmpty()) {
			perform.selectDropdownOption(driver, VRequestModification.product_dropdown(driver), product);
		}
		
		// Change the Due Date
		if (!dueDate.isEmpty()) {
			perform.type(driver, VRequestModification.dueDatetextbox(driver), dueDate);
		}
		
		// Change the fee
		if (!fee.isEmpty()) {
			perform.type(driver, VRequestModification.fee_txtbx(driver), fee);
		}
		
		// Change the Payment Method
		if (!paymentMethod.isEmpty()) {
			perform.selectDropdownOption(driver, VRequestModification.paymentMethod_dropdown(driver), paymentMethod);
		}
		
		// Enter notes
		if (!notes.isEmpty()) {
			perform.type(driver, VRequestModification.notes_txtbx(driver), notes);	
		}
		
		// Click OK
		perform.click(driver, VRequestModification.ok_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Get history text
		String history = VOrderDetails.orderInformation_txt(driver).getText();
		
		// Verify Modification Requested is in the history
		Assert.assertTrue(history.contains("Modification Requested"), "The Modification Request is not in the history. History = " + history);
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Request a modification");
		
	} // end requestModification
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click on the Bidding Orders folder</li>
	 * 	<li>Sort the Due Date column descending</li>
	 * 	<li>Open the order</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param folder the folder
	 * @param sortByColumn the sort by column
	 * @param borrower the borrower
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	public void findOrderInFolder(RemoteWebDriver driver, String folder, String sortByColumn, String borrower) throws IOException, InterruptedException {
		
		// Click on the Bidding Orders folder
		perform.clickInTable_Contains(driver, folder);
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		Thread.sleep(1500);
		
		// Sort the Due Date column descending
		vendors.sortByColumn(driver, sortByColumn);
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Open the order
		perform.doubleClickInTable(driver, borrower);
		
		// Wait for the Send Message button
		perform.waitForElementToBeClickable(driver, VOrderDetails.sendMessage_btn(), "cssSelector");
		
	} // end findOrderInFolder	
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to Vendors site</li>
	 * 	<li>Click Sign Up</li>
	 * 	<li>Select Type of Account</li>
	 * 	<li>Select State</li>
	 * 	<li>Enter Company Name</li>
	 * 	<li>Enter Phone Number</li>
	 * 	<li>Enter Email Address</li>
	 * 	<li>Click Next</li>
	 * 	<li>Enter First Name</li>
	 * 	<li>Enter Last Name</li>
	 * 	<li>Enter Cell Phone</li>
	 * 	<li>Enter Address</li>
	 * 	<li>Enter City</li>
	 * 	<li>Enter Zip</li>
	 * 	<li>Appraisal Volume per Month</li>
	 * 	<li>Select Type of Account radio button</li>
	 * 	<li>Select Time Zone</li>
	 * 	<li>Select How did you hear about us</li>
	 * 	<li>Enter Password</li>
	 * 	<li>Enter Confirm Password</li>
	 * 	<li>Click Next</li>
	 * 	<li>Click I Agree radio button</li>
	 * 	<li>Click Continue</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param env the env
	 * @param user the user
	 * @param password the password
	 * @param customerNumber the customer number
	 * @param typeOfAccount the type of account
	 * @param state the state
	 * @param company the company
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param cellPhone the cell phone
	 * @param address the address
	 * @param city the city
	 * @param zip the zip
	 * @param appraisalVolumePerMonth the appraisal volume per month
	 * @param type the type
	 * @param timeZone the time zone
	 * @param howDidYouHearAboutUs the how did you hear about us
	 * @throws InterruptedException the interrupted exception
	 */
	public void signupNewVendorsUser(RemoteWebDriver driver, String env, String user, String password, String customerNumber, String typeOfAccount, String state, String company,
			String firstName, String lastName, String cellPhone, String address, String city, String zip, String appraisalVolumePerMonth, String type, String timeZone,
			String howDidYouHearAboutUs) throws InterruptedException {
		
		// Go to Vendors site
		driver.get(StoredVariables.getvendorsSite().get());
		
		// Click Sign Up
		perform.click(driver, VLogin.signUp_btn(driver));
		
		// Wait for company name textbox
		perform.waitForElementToBeClickable(driver, VSignUp.companyName_txtbx(), "id");
		
		// Select Type of Account
		perform.selectDropdownOption(driver, VSignUp.typeOfAccount_dropdown(driver), typeOfAccount);
		
		// Select State
		perform.selectDropdownOption(driver, VSignUp.state_dropdown(driver), state);
		
		// Enter Company Name
		if (!company.isEmpty()) {
			perform.type(driver, VSignUp.companyName_txtbx(driver), company);	
		} else {
			perform.type(driver, VSignUp.companyName_txtbx(driver), "Automation" + env + user);
		}
		
		
		// Enter Phone Number
		perform.type(driver, VSignUp.phoneNumber_txtbx(driver), customerNumber);
		
		// Enter Email Address
		perform.type(driver, VSignUp.emailAddress_txtbx(driver), "automation" + env + user + StoredVariables.getcatchAllDomain().get());
		
		// Click Next
		perform.click(driver, VSignUp.next_btn(driver));
		
		// Wait for First Name textbox
		perform.waitForElementToBeClickable(driver, VSignUp.firstName_txtbx(), "id");
		
		// Enter First Name
		perform.type(driver, VSignUp.firstName_txtbx(driver), firstName);
		
		// Enter Last Name
		perform.type(driver, VSignUp.lastName_txtbx(driver), lastName);
		
		// Enter Cell Phone
		perform.type(driver, VSignUp.cellPhone_txtbox(driver), cellPhone);
		
		// Enter Address
		perform.type(driver, VSignUp.address_txtbx(driver), address);
		
		// Enter City
		perform.type(driver, VSignUp.city_txtbx(driver), city);
		
		// Enter Zip
		perform.type(driver, VSignUp.zip_txtbx(driver), zip);
		
		if (typeOfAccount.equals("Appraisal Management Company / Appraisal Firm"))
		{
			// Appraisal Volume per Month
			perform.selectDropdownOption(driver, VSignUp.appraisalVolumePerMonth_dropdown(driver), appraisalVolumePerMonth);
			
			// Select Type of Account radio button
			if (type.equals("AMC"))
			{
				perform.click(driver, VSignUp.appraisalManagementCompany_radiobtn(driver));
			}
			else if (type.equals("Firm"))
			{
				perform.click(driver, VSignUp.appraisalFirm_radiobtn(driver));
			} // end else if
		} // end if
		
		if (typeOfAccount.equals("Appraiser Office (less than 10)"))
		{
			// Select Time Zone
			perform.selectDropdownOption(driver, VSignUp.timeZone_dropdown(driver), timeZone);			
		} // end if
		
		// Select How did you hear about us
		perform.selectDropdownOption(driver, VSignUp.howDidYouHearAboutUs_dropdown(driver), howDidYouHearAboutUs);
		
		// Enter Password
		perform.type(driver, VSignUp.password_txtbx(driver), password);
		
		// Enter Confirm Password
		perform.type(driver, VSignUp.confirmPassword_txtbx(driver), password);
		
		// Click Next
		perform.click(driver, VSignUp.next_btn_EnterAccountInfo(driver));
		
		// Wait for confirmation text
		perform.waitForElementToBeClickable(driver, VSignUp.confirmation_txt(), "id");
		
		// Click I Agree radio button
		perform.click(driver, VSignUp.iAgree_radiobtn(driver));
		
		// Click Continue
		perform.click(driver, VSignUp.continue_btn(driver));

		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
	} // end findOrderInFolder
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click Details</li>
	 * 	<li>Select Time Zone</li>
	 * 	<li>Set Professional settings</li>
	 * 	<li>Set Product settings</li>
	 * 	<li>Set Coverage settings</li>
	 * 	<li>Save Settings</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param typeOfAccount the type of account
	 * @param timeZone the time zone
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws AWTException the AWT exception
	 */
	public void setDefaultVendorsSettings(RemoteWebDriver driver, String typeOfAccount, String timeZone) throws InterruptedException, IOException, AWTException {

		// Wait for Details button
		perform.waitForElementToBeClickable(driver, VUsers.details_btn(), "id");
		
		if (typeOfAccount.equals("Appraisal Management Company / Appraisal Firm"))
		{
			// Click Details
			perform.click(driver, VUsers.details_btn(driver));
			
			// Wait for Time Zone
			perform.waitForElementToBeClickable(driver, VUsers.corporateOfficeTimeZone_dropdown(), "id");
			
			// Select Time Zone
			perform.selectDropdownOption(driver, VUsers.corporateOfficeTimeZone_dropdown(driver), timeZone);
		}
		
		// Set Professional settings
		setProfessionalDefaultSettings(driver, typeOfAccount);
		
		// Set Product settings
		setProductsDefaultSettings(driver);
		
		// Set Coverage settings
		setCoverageDefaultSettings(driver, typeOfAccount);
		
		// Save Settings
		vendors.saveUsersSettings(driver);
		
	} // end setDefaultVendorsSettings
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click Professional</li>
	 * 	<li>Check Residential appraisal</li>
	 * 	<li>Check Commercial appraisal</li>
	 * 	<li>Check Inspection</li>
	 * 	<li>Check Broker Price Opinion</li>
	 * 	<li>Enter In business since month</li>
	 * 	<li>Enter In business since year</li>
	 * 	<li>Enter Residential appraisal year</li>
	 * 	<li>Enter Commercial appraisal year</li>
	 * 	<li>Enter Inspection year</li>
	 * 	<li>Enter Broker Price Opinion year</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param typeOfAccount the type of account
	 * @throws InterruptedException the interrupted exception
	 */
	public void setProfessionalDefaultSettings(RemoteWebDriver driver, String typeOfAccount) throws InterruptedException {
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Click Professional
		perform.click(driver, VUsers.professional_btn(driver));
		
		// Wait for residential appraisal checkbox
		perform.waitForElementToBeClickable(driver, VUsers.residentialAppraisal_chkbx(), "id");
		
		// Check Residential appraisal
		if (!VUsers.residentialAppraisal_chkbx(driver).isSelected())
		{
			perform.click(driver, VUsers.residentialAppraisal_chkbx(driver));
		}
		
		// Check Commercial appraisal
		if (!VUsers.commercialAppraisal_chkbx(driver).isSelected())
		{
			perform.click(driver, VUsers.commercialAppraisal_chkbx(driver));
		}
		
		// Check Inspection
		if (!VUsers.inspection_chkbx(driver).isSelected())
		{
			perform.click(driver, VUsers.inspection_chkbx(driver));
		}
		
		// Check Broker Price Opinion
		if (!VUsers.brokerPriceOpinion_chkbx(driver).isSelected())
		{
			perform.click(driver, VUsers.brokerPriceOpinion_chkbx(driver));
		}
		
		if (typeOfAccount.equals("Appraisal Management Company / Appraisal Firm"))
		{
			
			// Enter In business since month
			perform.type(driver, VUsers.inBusinessSinceMonth_txtbx(driver), "06");
			
			// Enter In business since year
			perform.type(driver, VUsers.inBusinessSinceYear_txtbx(driver), "2000");
			
		} else {
			
			// Enter Residential appraisal year
			perform.type(driver, VUsers.residentialAppraisalYear_txtbx(driver), "2000");
			
			// Enter Commercial appraisal year
			perform.type(driver, VUsers.commercialAppraisalYear_txtbx(driver), "2000");
			
			// Enter Inspection year
			perform.type(driver, VUsers.inspectionYear_txtbx(driver), "2000");
			
			// Enter Broker Price Opinion year
			perform.type(driver, VUsers.brokerPriceOpinionYear_txtbx(driver), "2000");
			
		} // end if/else
		
	} // end setProfessionalDefaultSettings
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click Products</li>
	 * 	<li>Check ACH</li>
	 * 	<li>Check C.O.D.</li>
	 * 	<li>Check Check</li>
	 * 	<li>Check Deferred CC</li>
	 * 	<li>Check Invoice</li>
	 * 	<li>Check Money order</li>
	 * 	<li>Check Net 30</li>
	 * 	<li>Check PayPal</li>
	 * 	<li>Save Settings</li>
	 * 	<li>Enter fees</li>
	 * 	<li>Save Settings</li>
	 * </ul>
	 *
	 * @param driver the new products default settings
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws AWTException the AWT exception
	 */
	public void setProductsDefaultSettings(RemoteWebDriver driver) throws InterruptedException, IOException, AWTException {
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Click Products
		perform.click(driver, VUsers.products_btn(driver));
		
		// Wait for ACH checkbox
		perform.waitForElementToBeClickable(driver, VUsers.ach_chkbx(), "id");
		
		// Check ACH
		if (!VUsers.ach_chkbx(driver).isSelected())
		{
			perform.click(driver, VUsers.ach_chkbx(driver));
		}
		
		// Check C.O.D.
		if (!VUsers.cod_chkbx(driver).isSelected())
		{
			perform.click(driver, VUsers.cod_chkbx(driver));
		}
		
		// Check Check
		if (!VUsers.check_chkbx(driver).isSelected())
		{
			perform.click(driver, VUsers.check_chkbx(driver));
		}
		
		// Check Deferred CC
		if (!VUsers.deferredCC_chkbx(driver).isSelected())
		{
			perform.click(driver, VUsers.deferredCC_chkbx(driver));
		}
		
		// Check Invoice
		if (!VUsers.invoice_chkbx(driver).isSelected())
		{
			perform.click(driver, VUsers.invoice_chkbx(driver));
		}
		
		// Check Money order
		if (!VUsers.moneyOrder_chkbx(driver).isSelected())
		{
			perform.click(driver, VUsers.moneyOrder_chkbx(driver));
		}
		
		// Check Net 30
		if (!VUsers.net30_chkbx(driver).isSelected())
		{
			perform.click(driver, VUsers.net30_chkbx(driver));
		}
		
		// Check PayPal
		if (!VUsers.paypal_chkbx(driver).isSelected())
		{
			perform.click(driver, VUsers.paypal_chkbx(driver));
		}
		
		// Save Settings
		vendors.saveUsersSettings(driver);
		
		// Enter fees
		enterFees(driver);
		
		// Save Settings
		vendors.saveUsersSettings(driver);
		
	} // end setProductsDefaultSettings
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click Coverage</li>
	 * 	<li>Check Oklahoma checkbox</li>
	 * 	<li>Click Oklahoma</li>
	 * 	<li>Click A</li>
	 * 	<li>Select all counties</li>
	 * 	<li>Click Select</li>
	 * 	<li>Save</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param typeOfAccount the type of account
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void setCoverageDefaultSettings(RemoteWebDriver driver, String typeOfAccount) throws InterruptedException, IOException {
		
		// Wait for Coverage button
		perform.waitForElementToBeClickable(driver, VUsers.coverage_btn(driver));
		
		// Click Coverage
		perform.click(driver, VUsers.coverage_btn(driver));
		
		if (typeOfAccount.equals("Appraisal Management Company / Appraisal Firm"))
		{
			// Wait for Oklahoma checkbox
			perform.waitForElementToBeClickable(driver, VUsers.oklahoma_chkbx(), "id");
			
			// Check Oklahoma checkbox
			if (VUsers.oklahoma_chkbx(driver).isSelected()==false)
			{
				perform.click(driver, VUsers.oklahoma_chkbx(driver));
			}
		} else {
			
			// Wait for Select button
			perform.waitForElementToBeClickable(driver, VUsers.select_btn(), "cssSelector");
		
			// Click Oklahoma
			perform.clickInTable_Equals(driver, "Oklahoma");
			
			// Wait for counties to load
			perform.waitForText(driver, VUsers.counties_txt(driver), "Adair");
			
			// Click A
			perform.clickInTable_Equals(driver, "A");
			
			// Select all counties
			Actions actions = new Actions(driver);
			actions.keyDown(Keys.LEFT_SHIFT)
			    .click(driver.findElement(By.xpath("//td[text()='Woodward']")))
			    .keyUp(Keys.LEFT_SHIFT)
			    .build()
			    .perform();
			
			// Click Select
			perform.click(driver, VUsers.select_btn(driver));
			
			// Save
			vendors.saveUsersSettings(driver);
			
		} // end if/else
		
	} // end setCoverageDefaultSettings
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click the Sign Out link</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws InterruptedException the interrupted exception
	 */
	public void signOut(RemoteWebDriver driver) throws InterruptedException {
		
		ExtentTest test = ExtentTestManager.getTest();
		
		// Click the Sign Out link
		perform.click(driver, driver.findElement(By.linkText("Sign Out")));
		
		// Wait for Email textbox
		perform.waitForElementToBeClickable(driver, VLogin.email_txtbx(), "id");
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Signed out");
		
	} // end signOut
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click Products</li>
	 * 	<li>handleFHApopup</li>
	 * 	<li>Scroll element into focus</li>
	 * 	<li>Click in the field</li>
	 * 	<li>handle the FHA popup</li>
	 * 	<li>Click Yes</li>
	 * 	<li>Create object of Robot class</li>
	 * 	<li>Press 3</li>
	 * 	<li>Release 3</li>
	 * 	<li>Press 0</li>
	 * 	<li>Release 0</li>
	 * 	<li>Press 0</li>
	 * 	<li>Release 0</li>
	 * 	<li>iterate a</li>
	 * 	<li>break if &gt; 4</li>
	 * 	<li>Scroll element into focus</li>
	 * 	<li>Click in the field</li>
	 * 	<li>Create object of Robot class</li>
	 * 	<li>Press 3</li>
	 * 	<li>Release 3</li>
	 * 	<li>Press 0</li>
	 * 	<li>Release 0</li>
	 * 	<li>Press 0</li>
	 * 	<li>Release 0</li>
	 * 	<li>Click Save</li>
	 * 	<li>Click OK</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws AWTException the AWT exception
	 */
	public void enterFees(RemoteWebDriver driver) throws InterruptedException, IOException, AWTException {

		// Wait for Products
		perform.waitForElementToBeClickable(driver, VUsers.products_btn(driver));
		
		// Click Products
		perform.click(driver, VUsers.products_btn(driver));
		
		// handleFHApopup
		List<WebElement> fees = driver.findElements(By.cssSelector("td[role='gridcell'][aria-describedby='tblProduct0_Fee']"));
		
		int a = 1;
		for(WebElement el : fees) 
		{
			
			// Scroll element into focus
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].scrollIntoView()", el); 
			
			// Click in the field
			perform.click(driver, el);

			Thread.sleep(500);
				
			// handle the FHA popup
			if (a == 4)
			{
				  
				try
				{
					// Click Yes
					perform.click(driver, driver.findElement(By.id("sbdmButton1")));
					
					// Wait for overlay to be hidden
					perform.waitForOverlayToBeHidden(driver);
				}
				catch (Exception e) {}
				   
			} // end if a = 4

			// Create object of Robot class
			Robot r=new Robot();
		 
		   // Press 3
		   r.keyPress(KeyEvent.VK_3);
		 
		   // Release 3
		   r.keyRelease(KeyEvent.VK_3);
		
		   // Press 0
		   r.keyPress(KeyEvent.VK_0);
		 
		   // Release 0
		   r.keyRelease(KeyEvent.VK_0);
		   
		   // Press 0
		   r.keyPress(KeyEvent.VK_0);
		 
		   // Release 0
		   r.keyRelease(KeyEvent.VK_0);
		   
		   // iterate a
		   a++;
		   
		   // break if > 4
		   if (a > 4)
		   {
			   break;
		   }
		   
		} // end handleFHApopup
		
		fees = driver.findElements(By.cssSelector("td[role='gridcell'][aria-describedby='tblProduct0_Fee']"));
		
		for(WebElement el : fees) 
		{

			// Scroll element into focus
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].scrollIntoView()", el); 
			
			// Click in the field
			perform.click(driver, el);

			Thread.sleep(500);
			
			// Create object of Robot class
			Robot r=new Robot();
		 
		   // Press 3
		   r.keyPress(KeyEvent.VK_3);
		 
		   // Release 3
		   r.keyRelease(KeyEvent.VK_3);
		
		   // Press 0
		   r.keyPress(KeyEvent.VK_0);
		 
		   // Release 0
		   r.keyRelease(KeyEvent.VK_0);
		   
		   // Press 0
		   r.keyPress(KeyEvent.VK_0);
		 
		   // Release 0
		   r.keyRelease(KeyEvent.VK_0);
			
		} // end for loop
		
		// Click Save
		perform.click(driver, VUsers.save_btn(driver));
		
		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for OK
		perform.waitForElementToBeClickable(driver, VUsers.okSave_btn(), "id");
		
		// Click OK
		perform.click(driver, VUsers.okSave_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		System.out.println("*** FEES HAVE BEEN UPDATED ***");
		
	} // end signOut
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to Users</li>
	 * 	<li>Click Create New User</li>
	 * 	<li>Check Accept orders from Mercury Network clients</li>
	 * 	<li>Enter Email Address/Username</li>
	 * 	<li>Enter Password</li>
	 * 	<li>Enter Confirm Password</li>
	 * 	<li>First Name</li>
	 * 	<li>Last Name</li>
	 * 	<li>Set Professional settings</li>
	 * 	<li>Save</li>
	 * 	<li>Click the Sub user last name</li>
	 * 	<li>Set Products settings</li>
	 * 	<li>Click the Sub user last name</li>
	 * 	<li>Set Coverage settings</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param acceptOrders the accept orders
	 * @param subUser the sub user
	 * @param password the password
	 * @param firstName the first name
	 * @param lastName the last name
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws AWTException the AWT exception
	 */
	public void createSubUser(RemoteWebDriver driver, boolean acceptOrders, String subUser, String password, String firstName, String lastName) throws InterruptedException, IOException, AWTException {

		// Go to Users
		vendors.goToUsers(driver);
		
		// Click Create New User
		perform.click(driver, VUsers.createNewUser_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for primary email address to be blank
		String emailText = VUsers.primaryEmail_txtbx(driver).getText();
		while (!emailText.isEmpty()) {
			Thread.sleep(1500);
			emailText = VUsers.primaryEmail_txtbx(driver).getText();
		} // end while
		
		// Check Accept orders from Mercury Network clients
		if (acceptOrders==true) {
			perform.checkCheckbox(driver, VUsers.acceptOrderFromMercuryNetworkClients_chkbx(driver));
		} // end if
		
		// Enter Email Address/Username
		if (subUser.contains("@")) {
			perform.type(driver, VUsers.primaryEmail_txtbx(driver), subUser);	
		} else {
			perform.type(driver, VUsers.primaryEmail_txtbx(driver), "automation"+StoredVariables.getusernameEnvironment().get()+subUser+StoredVariables.getcatchAllDomain().get());
		} // end if/else
		
		// Enter Password
		perform.type(driver, VUsers.password_txtbx(driver), password);
		
		// Enter Confirm Password
		perform.type(driver, VUsers.confirmPassword_txtbx(driver), password);
		
		// First Name
		perform.type(driver, VUsers.firstName_txtbx(driver), firstName);
		
		// Last Name
		perform.type(driver, VUsers.lastName_txtbx(driver), lastName);
		
		// Set Professional settings
		setProfessionalDefaultSettings(driver, "");
		
		// Save
		vendors.saveUsersSettings(driver);
		
		// Click the Sub user last name
		perform.clickInTable_Contains(driver, lastName);
		
		// Set Products settings
		setProductsDefaultSettings(driver);
		
		// Click the Sub user last name
		perform.clickInTable_Contains(driver, lastName);
		
		// Set Coverage settings
		setCoverageDefaultSettings(driver, "");
		
	} // end createSubUser
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click Add trainee</li>
	 * 	<li>Enter First Name</li>
	 * 	<li>Enter Last Name</li>
	 * 	<li>Select Training State</li>
	 * 	<li>Enter License Number</li>
	 * 	<li>Enter Expiration Date</li>
	 * 	<li>Verify Note</li>
	 * 	<li>Click Save</li>
	 * 	<li>Verify the new trainee is in the table</li>
	 * 	<li>Save settings</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param state the state
	 * @param licenseNumber the license number
	 * @param expDate the exp date
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws AWTException the AWT exception
	 */
	public void addTrainee(RemoteWebDriver driver, String firstName, String lastName, String state, String licenseNumber, String expDate) throws InterruptedException, IOException, AWTException {

		ExtentTest test = ExtentTestManager.getTest();
		
		// Click Add trainee
		perform.click(driver, driver.findElement(By.linkText("Add trainee")));

		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for First Name
		perform.waitForElementToBeClickable(driver, VUsers_AddTrainee.firstName_txtbx(), "id");
		
		// Enter First Name
		perform.type(driver, VUsers_AddTrainee.firstName_txtbx(driver), firstName);
		
		// Enter Last Name
		perform.type(driver, VUsers_AddTrainee.lastName_txtbx(driver), lastName);
		
		// Select Training State
		perform.selectDropdownOption(driver, VUsers_AddTrainee.trainingState_dropdown(driver), state);
		
		// Enter License Number
		perform.type(driver, VUsers_AddTrainee.licenseNumber_txtbx(driver), licenseNumber);
		
		// Enter Expiration Date
		perform.type(driver, VUsers_AddTrainee.expirationDate_txtbx(driver), expDate);
		
		// Verify Note
		String text = VUsers_AddTrainee.addTrainee_txt(driver).getText();
		Assert.assertTrue(text.contains("Mercury Network does not utilize a service to validate trainee licenses."), "The Note text is incorrect. It should contain - Mercury Network does not utilize a service to validate trainee licenses., but is - " + text);
		
		// Click Save
		perform.click(driver, VUsers_AddTrainee.save_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Verify the new trainee is in the table
		String traineeTable = VUsers.traineesTable(driver).getText();
		String[] expected = {firstName, lastName, perform.getStateAbbreviation(driver, state)};
		perform.verifyTextContains(driver, traineeTable, expected);
		
		// Save settings
		vendors.saveUsersSettings(driver);
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Added trainee: " + firstName + " " + lastName);
		
	} // end addTrainee
	
	/**
	 * Verify history text in Vendors
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
	public void verifyHistoryText(RemoteWebDriver driver, String[] expected) throws InterruptedException {

		// Get history text
		String screenText = VOrderDetails.history_txt(driver).getText();
		
		// Verify the history/audit trail contains text
		perform.verifyTextContains(driver, screenText, expected);
		
	} // end verifyHistoryText
	
	/**
	 * Verify history text in Vendors does not contain
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
		String screenText = VOrderDetails.history_txt(driver).getText();
		
		// Verify the history/audit trail contains text
		perform.verifyTextDoesNotContain(driver, screenText, expected);
		
	} // end verifyHistoryTextDoesNotContain
	
	/**
	 * Delete license
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click the delete license button</li>
	 *  <li>Wait for the overlay to be hidden</li>
	 *  <li>Wait for the Yes button to be clickable</li>
	 *  <li>Verify the dialog text</li>
	 *  <li>Click the Yes button</li>
	 *  <li>Wait for the overlay to be hidden</li>
	 * </ul>.
	 *
	 * @param driver the driver
	 * @throws InterruptedException the exception
	 */
	public void deleteLicense(RemoteWebDriver driver) throws InterruptedException {

		// Click the delete button
		perform.click(driver, VUsers.deleteLicense_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for Yes button
		perform.waitForElementToBeClickable(driver, VUsers.yesDeleteUser_btn(), "id");
		
		// Verify dialog text
		Assert.assertTrue(VUsers.alertDialog_txt(driver).getText().contains("Are you sure you want to delete"), "The delete license dialog is incorrect");
		
		// Click Yes
		perform.click(driver,VUsers.yesDeleteUser_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
	} // end deleteLicense
	
	/**
	 * Delete all orders
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get the number of row elements</li>
	 *  <li>Get the number of rows</li>
	 *  <li>Loop through and delete all orders</li>
	 *  <li>Select row if it exists</li>
	 *  <li>Click Delete</li>
	 *  <li>Wait for overlay to be visible</li>
	 *  <li>Wait for Order Delete dialog</li>
	 *  <li>Enter notes</li>
	 *  <li>Click OK</li>
	 *  <li>Wait for Deleted OK button</li>
	 *  <li>Verify Deleted Order text</li>
	 *  <li>Click OK</li>
	 *  <li>Wait for overlay to be hidden</li>
	 *  <li>Get all items in the grid</li>
	 *  <li>Get the number of row elements</li>
	 * </ul>.
	 *
	 * @param driver the driver
	 * @throws InterruptedException the exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void deleteOrders(RemoteWebDriver driver) throws InterruptedException, IOException {

		// Get all items in the grid
		List<WebElement> rows = driver.findElements(By.cssSelector("table > tbody > tr[type='row']"));
		
		// Get the number of row elements
		int numOfRows = rows.size();
		
		// Loop through and delete all orders
		while (numOfRows > 0) {
			
			// Select row if it exists
			perform.click(driver, rows.get(0));
			
			// Click Delete
			perform.clickInTable_Contains(driver, "Delete Order");
			
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			// Wait for Order Delete dialog
			perform.waitForElementToBeClickable(driver, VOrders.orderDeleteDialog_txtbx(driver));
			
			// Enter notes
			perform.type(driver, VOrders.notes_txtbx(driver), "delete order");
			
			// Click OK
			perform.click(driver,VOrders.okDelete_btn(driver));
			
			// Wait for Deleted OK button
			perform.waitForElementToBeClickable(driver, VOrders.okDeleted_btn(), "cssSelector");
			
			// Verify Deleted Order text
			Assert.assertTrue(VOrders.deletedOrderDialog_txt(driver).getText().contains("Your orders have been successfully deleted."), "The Delete Orders dialog text is incorrect");
			
			// Click OK
			perform.click(driver,VOrders.okDeleted_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			// Get all items in the grid
			rows = driver.findElements(By.cssSelector("table > tbody > tr[type='row']"));
			
			// Get the number of row elements
			numOfRows = rows.size();
			
		} // end while
		
	} // end deleteOrders
	
} // end Do class
