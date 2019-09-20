
package utils;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjects.Overlay.Overlay;
import pageObjects.VMP.VMPAppraisalOrderDetails;
import pageObjects.VMP.VMPConfirmOrder;
import pageObjects.VMP.VMPLogin;
import pageObjects.VMP.VMPNewOrder;
import pageObjects.VMP.VMPOrderDetails;
import pageObjects.VMP.VMPOrders;
import pageObjects.VMP.VMPProfile;
import pageObjects.VMP.VMPSignUp;
import setup.TestSetup;

// TODO: Auto-generated Javadoc
/**
 * <h1>Function VMP</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class Function_VMP extends TestSetup {
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get environment</li>
	 * 	<li>Go to login page</li>
	 * 	<li>Enter username</li>
	 * 	<li>Enter Password</li>
	 * 	<li>Ensure the username is entered correctly</li>
	 * 	<li>Ensure the password length is correct</li>
	 * 	<li>Click Sign In</li>
	 * 	<li>Click the find textbox</li>
	 * 	<li>Close overlay</li>
	 * 	<li>Log the user logged in</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param vmpURL the vmp URL
	 * @param vmpUser the vmp user
	 * @param password the password
	 * @throws InterruptedException the interrupted exception
	 * @throws SQLException the SQLException
	 * @throws ClassNotFoundException the ClassNotFoundException
	 */
	// Login to VMP Client Portal
	public void login(RemoteWebDriver driver, String vmpURL, String vmpUser, String password) throws InterruptedException, ClassNotFoundException, SQLException {

		ExtentTest test = ExtentTestManager.getTest();
		int passwordLength = password.length();
		
		// Get environment
		String env = StoredVariables.getusernameEnvironment().get();
		
		// Go to login page
		String url = "";
		if (vmpURL.contains(".com")) {
			url = vmpURL;
		} else {
			url = "https://automation" + env + vmpURL + "." + StoredVariables.getvmpSiteSuffix().get();
		} // end if/else
		driver.get(url);
		System.out.println("VMP Client Portal URL: " + url);
		
		// Enter username
		String user = "";
		if (vmpUser.contains("AutomationInt")) {
			user =  vmpUser;
		} else if (vmpUser.contains("QATestClient")) {
			user = vmpUser;
		} else {
			user = "automation" + env + vmpUser;
		} // end if/else
		System.out.println("USER: " + user);
		perform.type(driver, VMPLogin.email_txtbx(driver), user);
		
		// Enter Password
		perform.type(driver, VMPLogin.password_txtbx(driver), password);
		
		// Ensure the username is entered correctly
		int u = 1;
		String enteredUser = VMPLogin.email_txtbx(driver).getAttribute("value");
		while (!enteredUser.equals(user) && u <= 10) {
			perform.type(driver, VMPLogin.email_txtbx(driver), user);
			Thread.sleep(1500);
			enteredUser = VMPLogin.email_txtbx(driver).getAttribute("value");
			System.out.println("enteredUser: " + enteredUser);
			u++;
		} // end while
		
		// Ensure the password length is correct
		int p = 1;
		String enteredPassword = VMPLogin.password_txtbx(driver).getAttribute("value");
		while(enteredPassword.length() != passwordLength && p <= 10) {
			perform.type(driver, VMPLogin.password_txtbx(driver), password);
			Thread.sleep(1500);
			enteredPassword = VMPLogin.password_txtbx(driver).getAttribute("value");
			System.out.println("enteredPassword: " + enteredPassword);
		} // end while
		
		// Click Sign In
		perform.click(driver, VMPLogin.signIn_btn(driver));
		
		// Wait for Find textbox
		perform.waitForElementToBeClickable(driver, VMPOrders.find_txtbx(), "id");
		
		try
		{
			// Click the find textbox
			perform.click(driver, VMPOrders.find_txtbx(driver));
		} // end try
		catch (Exception e) {
			// Close overlay
			perform.waitForElementToBeClickable(driver, VMPOrders.closeOverlay_btn(), "cssSelector");
			perform.click(driver, VMPOrders.closeOverlay_btn(driver));				
		} // end catch
		
		// Log the user logged in
		test.log(LogStatus.INFO, "Log In", "Loggged in to VMP<br>URL: <a href=\"" + url + "\">" + url + "</a><br>User: " + user + "<br>Password: " + password);
		
	} // end loginToVMPClientPortal
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the vmpSiteSuffix</li>
	 * 	<li>Go to login page</li>
	 * 	<li>Enter username</li>
	 * 	<li>Enter Password</li>
	 * 	<li>Ensure the username is entered correctly</li>
	 * 	<li>Ensure the password length is correct</li>
	 * 	<li>Click Sign In</li>
	 * 	<li>Click the find textbox</li>
	 * 	<li>Close overlay</li>
	 * 	<li>Log the user logged in</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param vmpURL the vmp URL
	 * @param vmpUser the vmp user
	 * @param password the password
	 * @param env the env
	 * @throws InterruptedException the interrupted exception
	 * @throws SQLException the SQLException
	 * @throws ClassNotFoundException the ClassNotFoundException
	 */
	// Login to VMP Client Portal
	public void login(RemoteWebDriver driver, String vmpURL, String vmpUser, String password, String env) throws InterruptedException, ClassNotFoundException, SQLException {

		ExtentTest test = ExtentTestManager.getTest();
		int passwordLength = password.length();
		
		// Set the vmpSiteSuffix
		StoredVariables.getvmpSiteSuffix().set(perform.getvmpSiteSuffix(driver, env));
		
		// Go to login page
		String url = "";
		if (vmpURL.contains(".com")) {
			url = vmpURL;
		} else {
			url = "https://automation" + env + vmpURL + "." + StoredVariables.getvmpSiteSuffix().get();
		} // end if/else
		driver.get(url);
		System.out.println("VMP Client Portal URL: " + url);
		
		// Enter username
		String user = "";
		if (vmpUser.contains("AutomationInt")) {
			user =  vmpUser;
		} else {
			user = "automation" + env + vmpUser;
		}
		System.out.println("USER: " + user);
		perform.type(driver, VMPLogin.email_txtbx(driver), user);
		
		// Enter Password
		perform.type(driver, VMPLogin.password_txtbx(driver), password);
		
		// Ensure the username is entered correctly
		int u = 1;
		String enteredUser = VMPLogin.email_txtbx(driver).getAttribute("value");
		while (!enteredUser.equals(user) && u <= 10) {
			perform.type(driver, VMPLogin.email_txtbx(driver), user);
			Thread.sleep(1500);
			enteredUser = VMPLogin.email_txtbx(driver).getAttribute("value");
			System.out.println("enteredUser: " + enteredUser);
			u++;
		} // end while
		
		// Ensure the password length is correct
		int p = 1;
		String enteredPassword = VMPLogin.password_txtbx(driver).getAttribute("value");
		while(enteredPassword.length() != passwordLength && p <= 10) {
			VMPLogin.password_txtbx(driver).clear();
			perform.type(driver, VMPLogin.password_txtbx(driver), password);
			Thread.sleep(1500);
			enteredPassword = VMPLogin.password_txtbx(driver).getAttribute("value");
			System.out.println("enteredPassword: " + enteredPassword);
		} // end while
		
		// Click Sign In
		perform.click(driver, VMPLogin.signIn_btn(driver));
		
		// Wait for Find textbox
		perform.waitForElementToBeClickable(driver, VMPOrders.find_txtbx(), "id");
		
		try
		{
			// Click the find textbox
			perform.click(driver, VMPOrders.find_txtbx(driver));
		} // end try
		catch (Exception e) {
			// Close overlay
			perform.waitForElementToBeClickable(driver, VMPOrders.closeOverlay_btn(), "cssSelector");
			perform.click(driver, VMPOrders.closeOverlay_btn(driver));				
		} // end catch
		
		// Log the user logged in
		test.log(LogStatus.INFO, "Log In", "Loggged in to VMP<br>URL: <a href=\"" + url + "\">" + url + "</a><br>User: " + user + "<br>Password: " + password);
		
	} // end loginToVMPClientPortal
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get environment</li>
	 * 	<li>Go to login page</li>
	 * 	<li>Enter username</li>
	 * 	<li>Enter Password</li>
	 * 	<li>Ensure the username is entered correctly</li>
	 * 	<li>Ensure the password length is correct</li>
	 * 	<li>Click Sign In</li>
	 * 	<li>Click the find textbox</li>
	 * 	<li>Close overlay</li>
	 * 	<li>Log the user logged in</li>
	 * </ul>.
	 *
	 * @param driver the driver
	 * @param vmpURL the vmp URL
	 * @param vmpUser the vmp user
	 * @param password the password
	 * @param personal the personal
	 * @throws InterruptedException the interrupted exception
	 * @throws ClassNotFoundException the ClassNotFoundException
	 * @throws SQLException the SQLException
	 */
	// Login to VMP Client Portal
	public void login(RemoteWebDriver driver, String vmpURL, String vmpUser, String password, boolean personal) throws InterruptedException, ClassNotFoundException, SQLException {
	
		ExtentTest test = ExtentTestManager.getTest();
		int passwordLength = password.length();
		
		// Get environment
		String env = StoredVariables.getusernameEnvironment().get();
		
		// Go to login page
		String url = "";
		if (vmpURL.contains(".com")) {
			url = vmpURL;
		} else {
			url = "https://automation" + env + vmpURL + "." + StoredVariables.getvmpSiteSuffix().get();
		} // end if/else
		driver.get(url);
		System.out.println("VMP Client Portal URL: " + url);
		
		// Enter username
		String user = "";
		if (personal==true) {
			user =  vmpUser;
		} else {
			user = "automation" + env + vmpUser;
		}
		System.out.println("USER: " + user);
		perform.type(driver, VMPLogin.email_txtbx(driver), user);
		
		// Enter Password
		perform.type(driver, VMPLogin.password_txtbx(driver), password);
		
		// Ensure the username is entered correctly
		int u = 1;
		String enteredUser = VMPLogin.email_txtbx(driver).getAttribute("value");
		while (!enteredUser.equals(user) && u <= 10) {
			perform.type(driver, VMPLogin.email_txtbx(driver), user);
			Thread.sleep(1500);
			enteredUser = VMPLogin.email_txtbx(driver).getAttribute("value");
			System.out.println("enteredUser: " + enteredUser);
			u++;
		} // end while
		
		// Ensure the password length is correct
		int p = 1;
		String enteredPassword = VMPLogin.password_txtbx(driver).getAttribute("value");
		while(enteredPassword.length() != passwordLength && p <= 10) {
			perform.type(driver, VMPLogin.password_txtbx(driver), password);
			Thread.sleep(1500);
			enteredPassword = VMPLogin.password_txtbx(driver).getAttribute("value");
			System.out.println("enteredPassword: " + enteredPassword);
		} // end while
		
		// Click Sign In
		perform.click(driver, VMPLogin.signIn_btn(driver));
		
		// Wait for Find textbox
		perform.waitForElementToBeClickable(driver, VMPOrders.find_txtbx(), "id");
		
		try
		{
			// Click the find textbox
			perform.click(driver, VMPOrders.find_txtbx(driver));
		} // end try
		catch (Exception e) {
			// Close overlay
			perform.waitForElementToBeClickable(driver, VMPOrders.closeOverlay_btn(), "cssSelector");
			perform.click(driver, VMPOrders.closeOverlay_btn(driver));				
		} // end catch
		
		// Log the user logged in
		test.log(LogStatus.INFO, "Log In", "Loggged in to VMP<br>URL: <a href=\"" + url + "\">" + url + "</a><br>User: " + user + "<br>Password: " + password);
		
	} // end loginToVMPClientPortal
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click Sign Out</li>
	 * 	<li>Verify the URL</li>
	 * </ul>.
	 *
	 * @param driver the driver
	 * @throws InterruptedException the interrupted exception
	 */
	// Login to VMP Client Portal
	public void signOut(RemoteWebDriver driver) throws InterruptedException {

		// Click Sign Out
		perform.click(driver, VMPOrders.signOut_btn(driver));
		
		// Wait for element to be clickable
		perform.waitForElementToBeClickable(driver, VMPLogin.email_txtbx(driver));
		
		// Verify URL contains SignIn.aspx
		perform.verification(driver, driver.getCurrentUrl(), "contains", "SignIn.aspx");
		
		
	} // end signOut

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
		
		// Click on Orders
		perform.click(driver, VMPOrders.orders_btn(driver));
		
		// Wait for the Find textbox
		perform.waitForElementToBeClickable(driver, VMPOrders.find_txtbx(), "id");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().contains("Admin/OrderManagement/Orders.aspx"), "The url is incorrect");
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Navigated to the Orders screen");
		
	} // end goToOrders
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click on Orders</li>
	 * 	<li>Verify url</li>
	 * 	<li>Click on New Order</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	// Go to New Order
	public void goToNewOrder(RemoteWebDriver driver) throws IOException, InterruptedException
	{
		
		ExtentTest test = ExtentTestManager.getTest();
		
		System.out.println("Go to New Order");
		
		// Click on Orders
		perform.click(driver, VMPOrders.orders_btn(driver));
		
		// Wait for the Find textbox
		perform.waitForElementToBeClickable(driver, VMPOrders.find_txtbx(), "id");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().contains("Admin/OrderManagement/Orders.aspx"), "The url is incorrect");
		
		// Click on New Order
		try {
			perform.click(driver, VMPOrders.newOrder_btn(driver));
		} catch (Exception e) {
			perform.click(driver, VMPOrders.newOrder_btn(driver));
		} // end try/catch
		
		// Wait for Address textbox
		perform.waitForElementToBeClickable(driver, VMPNewOrder.address_txtbx(), "id");
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Navigated to the New Order screen");
		
	} // end goToNewOrder
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click on Profile</li>
	 * 	<li>Verify url</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	// Go to Profile
	public void goToProfile(RemoteWebDriver driver) throws IOException, InterruptedException
	{
		
		ExtentTest test = ExtentTestManager.getTest();
		
		System.out.println("Go to Profile");
		
		// Click on Profile
		perform.click(driver, VMPOrders.profile_btn(driver));
		
		// Wait for the Find textbox
		perform.waitForElementToBeClickable(driver, VMPProfile.username_txtbx(), "id");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().contains("Admin/Profile/Profile.aspx"), "The url is incorrect");
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Navigated to the Profile screen");
		
	} // end goToProfile
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get current month</li>
	 * 	<li>Get today's date</li>
	 * 	<li>Add number of days passed in</li>
	 * 	<li>Set the date to the new date</li>
	 * 	<li>Get new day and format it without leading 0</li>
	 * 	<li>Get new day and format it with leading 0 if necessary</li>
	 * 	<li>Get new month and format it</li>
	 * 	<li>Get new month and format it</li>
	 * 	<li>Get new year and format it</li>
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
	 * @param numOfDaysInTheFuture the num of days in the future
	 * @throws InterruptedException the interrupted exception
	 */
	// Select Date From Calendar
	@SuppressWarnings("unused")
	public void selectDateFromCalendar(RemoteWebDriver driver, int numOfDaysInTheFuture) throws InterruptedException {

		// Get current month
		SimpleDateFormat s = new SimpleDateFormat("MM");
		StoredVariables.getcurrentMonth().set(s.format(new Date()));
		
		// Get today's date
		Calendar calendar = Calendar.getInstance();
		// Add number of days passed in
		calendar.add(Calendar.DAY_OF_MONTH, numOfDaysInTheFuture);
		// Set the date to the new date
		Date date = calendar.getTime();
		// Get new day and format it without leading 0
		StoredVariables.getnewDay().set(new SimpleDateFormat("d").format(date));
		// Get new day and format it with leading 0 if necessary
		StoredVariables.getnewDay2().set(new SimpleDateFormat("dd").format(date));
		// Get new month and format it
		StoredVariables.getnewMonth().set(new SimpleDateFormat("M").format(date));
		// Get new month and format it
		StoredVariables.getnewMonth2().set(new SimpleDateFormat("MM").format(date));
		// Get new year and format it
		StoredVariables.getnewYear().set(new SimpleDateFormat("yyyy").format(date));
		
		StoredVariables.getcalendarDateLong().set(StoredVariables.getnewMonth2().get()+"/"+StoredVariables.getnewDay2().get()+"/"+StoredVariables.getnewYear().get());
		StoredVariables.getcalendarDateShort().set(StoredVariables.getnewMonth().get()+"/"+StoredVariables.getnewDay().get()+"/"+StoredVariables.getnewYear().get());
		
		// Convert the current month and new month to integers
		int currentMonthInt = Integer.parseInt(StoredVariables.getcurrentMonth().get());
		int newMonthInt = Integer.parseInt(StoredVariables.getnewMonth().get());
		
		// Get the name of the new month
		String selectNewMonth = perform.getMonthName(driver, newMonthInt);
		
		// Declare calendar month string
		String calendarMonth = VMPNewOrder.calendarMonth_txt(driver).getText();
		
		// Check to see the difference between the new month and the current month
		int diff = newMonthInt - currentMonthInt;
		
		// If the new date goes into a new month
		if (numOfDaysInTheFuture >= 0)
		{
			while(!calendarMonth.equals(selectNewMonth))
			{
				perform.click(driver, VMPNewOrder.calendarNextMonth_btn(driver));
				Thread.sleep(500);
				calendarMonth = VMPNewOrder.calendarMonth_txt(driver).getText();
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
				perform.click(driver, VMPNewOrder.calendarPreviousMonth_btn(driver));
				Thread.sleep(500);
				calendarMonth = VMPNewOrder.calendarMonth_txt(driver).getText();
				if (calendarMonth.equals(selectNewMonth))
				{
					break;
				}
			} // end while loop
		} // end back button click
		
		// Get the calendar element and all the columns/rows
		WebElement datepicker = driver.findElement(By.id(VMPNewOrder.calendar()));
		List<WebElement> rows=datepicker.findElements(By.tagName("tr"));
		List<WebElement> columns=datepicker.findElements(By.tagName("td"));
		// loop through the cells until the correct day is found
		for (WebElement cell: columns){
			//Select Date
			if (cell.getText().equals(StoredVariables.getnewDay().get()))
			{
				perform.waitForElementToBeClickable(driver, "td.almCalDay[datevalue='"+cell.getAttribute("datevalue")+"']", "cssSelector");
				// select the correct day
				perform.click(driver, driver.findElement(By.cssSelector("td.almCalDay[datevalue='"+cell.getAttribute("datevalue")+"']")));
				break;  
			} // end if statement
		} // end for loop  
		
	} // end selectDateFromCalendarOnVMPSite
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Clear order information variables before setting new variables</li>
	 * 	<li>Set Property Information data</li>
	 * 	<li>Set Assignment Information data</li>
	 * 	<li>Set Lender Information data</li>
	 * 	<li>Set Contact And Access Information data</li>
	 * 	<li>Set Additional Notification Recipients data</li>
	 * </ul>
	 *
	 * @param driver the new variables
	 * @throws InterruptedException the interrupted exception
	 */
	// Set default variables for placing a VMP order
	public void setVariables(RemoteWebDriver driver) throws InterruptedException {
		
		// Clear order information variables before setting new variables
		perform.clearOrderInfoStoredVariables(driver);
		
		/***************************************
		 * Set New Order Information
		 ***************************************/

		// Set Property Information data		
//		StoredVariables.getpropertyInformationAddress().set("2621 SW 136th St");
//		StoredVariables.getpropertyInformationCity().set("Oklahoma City");
//		StoredVariables.getpropertyInformationState().set("Oklahoma");
//		StoredVariables.getpropertyInformationStateAbbr().set("OK"); // Must set for a field check later on
//		StoredVariables.getpropertyInformationZip().set("73170");
//		StoredVariables.getpropertyInformationPropType().set("Single Family");
//		StoredVariables.getpropertyInformationLegalDesc().set("2844 Guilford Ln, Oklahoma City, OK 73120");
//		StoredVariables.getpropertyInformationDirections().set("East of N May Ave and south of NW Britton Rd");
		
		StoredVariables.getpropertyInformationAddress().set("501-D NE 122nd St");
		StoredVariables.getpropertyInformationCity().set("Oklahoma City");
		StoredVariables.getpropertyInformationState().set("Oklahoma");
		StoredVariables.getpropertyInformationStateAbbr().set("OK"); // Must set for a field check later on
		StoredVariables.getpropertyInformationZip().set("73114");
		StoredVariables.getpropertyInformationPropType().set("Single Family");
		StoredVariables.getpropertyInformationLegalDesc().set("501-D NE 122nd St, Oklahoma City, OK 73114");
		StoredVariables.getpropertyInformationDirections().set("I235 and 122nd St");
		
		// Set Assignment Information data
		StoredVariables.getassignmentInformationForm().set("1004 Full/URAR");
		StoredVariables.getassignmentInformationOrderDue().set(7);
		StoredVariables.getassignmentInformationOtherRefNumber().set(perform.randomNumbers(driver, 7));
		StoredVariables.getassignmentInformationLoanType().set("All In One");
		StoredVariables.getassignmentInformationLoanPurpose().set("Purchase");
		StoredVariables.getassignmentInformationOrderedBy().set("Borrower Name");
		StoredVariables.getassignmentInformationAccountExec().set("(None Selected)");
		StoredVariables.getassignmentInformationLoanNumber().set(perform.randomNumbers(driver, 15));
		StoredVariables.getassignmentInformationFileNumber().set(perform.randomNumbers(driver, 5));
		StoredVariables.getassignmentInformationSalesPrice().set("645,715");
		StoredVariables.getassignmentInformationFHACaseNumber().set(perform.randomNumbers(driver, 3) + "-" + perform.randomNumbers(driver, 7));
		StoredVariables.getassignmentInformationDisclosure().set(0);
		
		// Set Lender Information data
		StoredVariables.getlenderInformationLenderName().set("BOKF, National Association");
		StoredVariables.getlenderInformationAddress1().set("One Williams Center");
		StoredVariables.getlenderInformationCity().set("Tulsa");
		StoredVariables.getlenderInformationState().set("Oklahoma");
		StoredVariables.getlenderInformationZip().set("74172");
		
		// Set Contact And Access Information data
		StoredVariables.getcontactOccupancy().set("Owner");
		StoredVariables.getcontactBorrower().set("Baseline Test");
		StoredVariables.getcontactBorrowerInfo1Dropdown().set("Home");
		StoredVariables.getcontactBorrowerInfo1().set("405-555-7818");
		StoredVariables.getcontactBorrowerInfo2Dropdown().set("E-mail");
		StoredVariables.getcontactBorrowerInfo2().set("borrower@dntest.net");
		StoredVariables.getcontactCoBorrower().set("Coborrower Name");
		StoredVariables.getcontactCoBorrowerInfo1Dropdown().set("Work");
		StoredVariables.getcontactCoBorrowerInfo1().set("405-555-9813");
		StoredVariables.getcontactCoBorrowerInfo2Dropdown().set("E-mail");
		StoredVariables.getcontactCoBorrowerInfo2().set("test@dntest.net");
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
		StoredVariables.getadditionalComments().set("These are test additional comments");
		
	} // end setVariables
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Clear order information variables before setting new variables</li>
	 * 	<li>Set Property Information data</li>
	 * 	<li>Set Assignment Information data</li>
	 * </ul>
	 *
	 * @param driver the new minimum variables
	 * @throws InterruptedException the interrupted exception
	 */
	// Set default minimum variables for placing a VMP order
	public void setMinimumVariables(RemoteWebDriver driver) throws InterruptedException {
		
		// Clear order information variables before setting new variables
		perform.clearOrderInfoStoredVariables(driver);
		
		/***************************************
		 * Set New Order Information
		 ***************************************/

		// Set Property Information data		
		StoredVariables.getpropertyInformationAddress().set("2621 SW 136th St");
		StoredVariables.getpropertyInformationCity().set("Oklahoma City");
		StoredVariables.getpropertyInformationState().set("Oklahoma");
		StoredVariables.getpropertyInformationStateAbbr().set("OK"); // Must set for a field check later on
		StoredVariables.getpropertyInformationZip().set("73170");
		StoredVariables.getpropertyInformationDirections().set("East of N May Ave and south of NW Britton Rd");
		
		// Set Assignment Information data
		StoredVariables.getassignmentInformationForm().set("1004 Full/URAR");
		StoredVariables.getassignmentInformationOrderDue().set(7);
		
	} // end setMinimumVariables
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Address</li>
	 * 	<li>City</li>
	 * 	<li>State</li>
	 * 	<li>Zip Code</li>
	 * 	<li>Click in the Legal Description field to load the map</li>
	 * 	<li>Prop Type</li>
	 * 	<li>Legal desc</li>
	 * 	<li>Directions</li>
	 * 	<li>Get directionsIdentifier used to uniquely identify the order number and store it</li>
	 * 	<li>Enter Directions</li>
	 * 	<li>Click Legal desc</li>
	 * 	<li>Verify Directions were entered correctly</li>
	 * 	<li>Enter Directions</li>
	 * 	<li>Verify Legal was entered correctly</li>
	 * 	<li>Enter Directions</li>
	 * 	<li>Form/type</li>
	 * 	<li>Set Order Due Date (Long and Short)</li>
	 * 	<li>Select the Order Due date</li>
	 * 	<li>Enter Order Due date</li>
	 * 	<li>Click the Order Due calendar button</li>
	 * 	<li>Select the date</li>
	 * 	<li>Verify the correct order due date is correct</li>
	 * 	<li>Other Ref #</li>
	 * 	<li>Loan Type</li>
	 * 	<li>Loan Purpose</li>
	 * 	<li>Ordered By</li>
	 * 	<li>Account Exec.</li>
	 * 	<li>Loan #</li>
	 * 	<li>File #</li>
	 * 	<li>Sales Price</li>
	 * 	<li>FHA Case #</li>
	 * 	<li>Set Disclosure Date (Long and Short)</li>
	 * 	<li>Select Disclosure Date</li>
	 * 	<li>Enter Order Due date</li>
	 * 	<li>Lender name</li>
	 * 	<li>Lender Street</li>
	 * 	<li>Lender City</li>
	 * 	<li>Lender State</li>
	 * 	<li>Lender Zip</li>
	 * 	<li>Occupancy</li>
	 * 	<li>Borrower</li>
	 * 	<li>Get borrower identifier to uniquely identify the borrower</li>
	 * 	<li>Borrower Info 1 dropdown</li>
	 * 	<li>Borrower Info 1</li>
	 * 	<li>Borrower Info 2 dropdown</li>
	 * 	<li>Borrower Info 2</li>
	 * 	<li>Co-borrower</li>
	 * 	<li>Co-borrower Info 1 dropdown</li>
	 * 	<li>Co-borrower Info 1</li>
	 * 	<li>Co-borrower Info 2 dropdown</li>
	 * 	<li>Co-borrower Info 2</li>
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
	 * 	<li>Enter additional comments</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws InterruptedException the interrupted exception
	 */
	// Fill out New Order Form on VMP
	public void enterNewOrder(RemoteWebDriver driver) throws InterruptedException {
		
		ExtentTest test = ExtentTestManager.getTest();
		
		/***************************************
		 * Enter Property Information
		 ***************************************/
		
		// Address
		perform.type(driver, VMPNewOrder.address_txtbx(driver), StoredVariables.getpropertyInformationAddress().get());

		// City
		perform.type(driver, VMPNewOrder.city_txtbx(driver), StoredVariables.getpropertyInformationCity().get());
		
		// State
		perform.selectDropdownOption(driver, VMPNewOrder.state_dropdown(driver), StoredVariables.getpropertyInformationState().get());
		
		// Zip Code
		perform.type(driver, VMPNewOrder.zipCode_txtbx(driver), StoredVariables.getpropertyInformationZip().get());
		
		// Click in the Legal Description field to load the map
		perform.click(driver, VMPNewOrder.legalDesc_txtbx(driver));
		
		// Prop Type
		if (!StoredVariables.getpropertyInformationPropType().get().equals("")) {
			perform.selectDropdownOption(driver, VMPNewOrder.propType_dropdown(driver), StoredVariables.getpropertyInformationPropType().get());
		}
		
		// Legal desc
		if (!StoredVariables.getpropertyInformationLegalDesc().get().equals("")) {
			perform.type(driver, VMPNewOrder.legalDesc_txtbx(driver), StoredVariables.getpropertyInformationLegalDesc().get());
		}
		
		// Directions
		// Get directionsIdentifier used to uniquely identify the order number and store it
		StoredVariables.getdirectionsIdentifier().set(new SimpleDateFormat("MMddHHmmss").format(Calendar.getInstance().getTime()) + " - " + perform.randomNumbers(driver, 5));
		StoredVariables.getpropertyInformationDirections().set(StoredVariables.getpropertyInformationDirections().get() + " - " + StoredVariables.getdirectionsIdentifier().get());
		// Enter Directions
		perform.type(driver, VMPNewOrder.directions_txtbx(driver), StoredVariables.getpropertyInformationDirections().get());
		
		// Click Legal desc
		perform.click(driver, VMPNewOrder.legalDesc_txtbx(driver));
		
		// Verify Directions were entered correctly
		String directions = StoredVariables.getpropertyInformationDirections().get();
		while (!VMPNewOrder.directions_txtbx(driver).getAttribute("value").equals(directions))
		{
			// Enter Directions
			perform.type(driver, VMPNewOrder.directions_txtbx(driver), directions);
			Thread.sleep(1000);
		} // end if
		
		// Verify Legal was entered correctly
		String legal = StoredVariables.getpropertyInformationLegalDesc().get();
		while (!VMPNewOrder.legalDesc_txtbx(driver).getAttribute("value").equals(legal))
		{
			// Enter Directions
			perform.type(driver, VMPNewOrder.legalDesc_txtbx(driver), legal);
			Thread.sleep(1000);
		} // end if
		
		/***************************************
		 * Enter Assignment Information
		 ***************************************/
		
		// Wait for dropdown
		perform.waitForElementToBeClickable(driver, VMPNewOrder.form_dropdown(), "id");
		
		// Form/type
		perform.selectDropdownOption(driver, VMPNewOrder.form_dropdown(driver), StoredVariables.getassignmentInformationForm().get());
		
		// Set Order Due Date (Long and Short)
		perform.getNewDate(driver, StoredVariables.getassignmentInformationOrderDue().get());
		StoredVariables.getorderDueDateLong().set(StoredVariables.getnewDateLong().get());
		StoredVariables.getorderDueDateShort().set(StoredVariables.getnewDateShort().get());
		
		// Select the Order Due date
		if (StoredVariables.getbrowser().get().equals("PhantomJS") || StoredVariables.getbrowser().get().equals("HtmlUnit") || StoredVariables.getbrowser().get().equals("IE") || StoredVariables.getmobile().get()==true)
		{
			// Enter Order Due date
			perform.type(driver, VMPNewOrder.orderDue_txtbx(driver), StoredVariables.getorderDueDateLong().get());
		}
		else
		{
			// Click the Order Due calendar button
			perform.click(driver, VMPNewOrder.orderDueCalendar_btn(driver));
			
			// Select the date
			selectDateFromCalendar(driver, StoredVariables.getassignmentInformationOrderDue().get());
			
			// Verify the correct order due date is correct
			Assert.assertTrue(VMPNewOrder.orderDue_txtbx(driver).getAttribute("value").equals(StoredVariables.getcalendarDateLong().get()), "Date selected from calendar is the wrong date. Trying to match - " + StoredVariables.getcalendarDateLong().get());
		}
		
		// Other Ref #
		if (!StoredVariables.getassignmentInformationOtherRefNumber().get().equals("")) {
			perform.type(driver, VMPNewOrder.otherRefNumber_txtbx(driver), StoredVariables.getassignmentInformationOtherRefNumber().get());
		}
		
		// Loan Type
		if (!StoredVariables.getassignmentInformationLoanType().get().equals("")) {
			perform.selectDropdownOption(driver, VMPNewOrder.loanType_dropdown(driver), StoredVariables.getassignmentInformationLoanType().get());
		}
		
		// Loan Purpose
		if (!StoredVariables.getassignmentInformationLoanPurpose().get().equals("")) {
			perform.selectDropdownOption(driver, VMPNewOrder.loanPurpose_dropdown(driver), StoredVariables.getassignmentInformationLoanPurpose().get());
		}
		
		// Ordered By
		if (!StoredVariables.getassignmentInformationOrderedBy().get().equals("")) {
			perform.type(driver, VMPNewOrder.orderedBy_txtbx(driver), StoredVariables.getassignmentInformationOrderedBy().get());
		}
		
		// Account Exec.
		if (!StoredVariables.getassignmentInformationAccountExec().get().equals("")) {
			perform.selectDropdownOption(driver, VMPNewOrder.accountExec_dropdown(driver), StoredVariables.getassignmentInformationAccountExec().get());
		}
		
		// Loan #
		if (!StoredVariables.getassignmentInformationLoanNumber().get().equals("")) {
			perform.type(driver, VMPNewOrder.loanNumber_txtbx(driver), StoredVariables.getassignmentInformationLoanNumber().get());
		}
		
		// File #
		if (!StoredVariables.getassignmentInformationFileNumber().get().equals("")) {
			perform.type(driver, VMPNewOrder.fileNumber_txtbx(driver), StoredVariables.getassignmentInformationFileNumber().get());
		}
		
		// Sales Price
		if (!StoredVariables.getassignmentInformationSalesPrice().get().equals("")) {
			perform.type(driver, VMPNewOrder.salesPrice_txtbx(driver), StoredVariables.getassignmentInformationSalesPrice().get());
		}
		
		// FHA Case #
		if (!StoredVariables.getassignmentInformationFHACaseNumber().get().equals("")) {
			perform.type(driver, VMPNewOrder.fhaCaseNumber_txtbx(driver), StoredVariables.getassignmentInformationFHACaseNumber().get());
		}
		
		// Set Disclosure Date (Long and Short)
		if (!StoredVariables.getassignmentInformationDisclosure().get().equals("")) {
			perform.getNewDate(driver, StoredVariables.getassignmentInformationDisclosure().get());
			StoredVariables.getdisclosureDateLong().set(StoredVariables.getnewDateLong().get());
			StoredVariables.getdisclosureDateShort().set(StoredVariables.getnewDateShort().get());
			
			Thread.sleep(5000);
		
			// Select Disclosure Date
			if (!StoredVariables.getskipDisclosureDate().get()==true)
			{
					// Enter Order Due date
					perform.type(driver, VMPNewOrder.disclosure_txtbx(driver), StoredVariables.getdisclosureDateLong().get());
			}
		}
		
		/***************************************
		 * Enter Lender Information
		 ***************************************/
		
		// Lender name
		if (!StoredVariables.getlenderInformationLenderName().get().equals("")) {
			perform.type(driver, VMPNewOrder.lenderName_txtbx(driver), StoredVariables.getlenderInformationLenderName().get());
		}
		
		// Lender Street
		if (!StoredVariables.getlenderInformationAddress1().get().equals("")) {
			perform.type(driver, VMPNewOrder.lenderAddress1_txtbx(driver), StoredVariables.getlenderInformationAddress1().get());
		}
		
		// Lender City
		if (!StoredVariables.getlenderInformationCity().get().equals("")) {
			perform.type(driver, VMPNewOrder.lenderCity_txtbx(driver), StoredVariables.getlenderInformationCity().get());
		}
		
		// Lender State
		if (!StoredVariables.getlenderInformationState().get().equals("")) {
			perform.selectDropdownOption(driver, VMPNewOrder.lenderState_dropdown(driver), StoredVariables.getlenderInformationState().get());
		}
		
		// Lender Zip
		if (!StoredVariables.getlenderInformationZip().get().equals("")) {
			perform.type(driver, VMPNewOrder.lenderZip_txtbx(driver), StoredVariables.getlenderInformationZip().get());
		}
		
		/***************************************
		 * Enter Contact And Access Information
		 ***************************************/
		
		// Occupancy
		if (!StoredVariables.getcontactOccupancy().get().equals("")) {
			perform.selectDropdownOption(driver, VMPNewOrder.occupancy_dropdown(driver), StoredVariables.getcontactOccupancy().get());
		}
		
		// Borrower
		if (!StoredVariables.getcontactBorrower().get().equals("")) {
			// Get borrower identifier to uniquely identify the borrower
			StoredVariables.getborrowerIdentifier().set(new SimpleDateFormat("MMddHHmmss").format(Calendar.getInstance().getTime()));
			perform.type(driver, VMPNewOrder.borrower_txtbx(driver), StoredVariables.getcontactBorrower().get() + "-" + StoredVariables.getborrowerIdentifier().get());
		}
			
		if (!StoredVariables.getcontactBorrowerInfo1Dropdown().get().equals("")) {
			// Borrower Info 1 dropdown
			perform.selectDropdownOption(driver, VMPNewOrder.borrowerInfo1_dropdown(driver), StoredVariables.getcontactBorrowerInfo1Dropdown().get());
		}
		
		if (!StoredVariables.getcontactBorrowerInfo1().get().equals("")) {
			// Borrower Info 1
			perform.type(driver, VMPNewOrder.borrowerInfo1_txtbx(driver), StoredVariables.getcontactBorrowerInfo1().get());
		}
		
		if (!StoredVariables.getcontactBorrowerInfo2Dropdown().get().equals("")) {
			// Borrower Info 2 dropdown
			perform.selectDropdownOption(driver, VMPNewOrder.borrowerInfo2_dropdown(driver), StoredVariables.getcontactBorrowerInfo2Dropdown().get());
		}
		
		if (!StoredVariables.getcontactBorrowerInfo2().get().equals("")) {
			// Borrower Info 2
			perform.type(driver, VMPNewOrder.borrowerInfo2_txtbx(driver), StoredVariables.getcontactBorrowerInfo2().get());
		} // end Borrower
		
		// Co-borrower
		if (!StoredVariables.getcontactCoBorrower().get().equals("")) {
			perform.type(driver, VMPNewOrder.coBorrower_txtbx(driver), StoredVariables.getcontactCoBorrower().get());
			
			// Co-borrower Info 1 dropdown
			perform.selectDropdownOption(driver, VMPNewOrder.coBorrowerInfo1_dropdown(driver), StoredVariables.getcontactCoBorrowerInfo1Dropdown().get());
			
			// Co-borrower Info 1
			perform.type(driver, VMPNewOrder.coBorrowerInfo1_txtbx(driver), StoredVariables.getcontactCoBorrowerInfo1().get());
			
			// Co-borrower Info 2 dropdown
			perform.selectDropdownOption(driver, VMPNewOrder.coBorrowerInfo2_dropdown(driver), StoredVariables.getcontactCoBorrowerInfo2Dropdown().get());
			
			// Co-borrower Info 2
			perform.type(driver, VMPNewOrder.coBorrowerInfo2_txtbx(driver), StoredVariables.getcontactCoBorrowerInfo2().get());
		} // end Co-Bborower
		
		// Owner
		if (!StoredVariables.getcontactOwner().get().equals("")) {
			perform.type(driver, VMPNewOrder.owner_txtbx(driver), StoredVariables.getcontactOwner().get());
			
			// Owner Info 1 dropdown
			perform.selectDropdownOption(driver, VMPNewOrder.ownerInfo1_dropdown(driver), StoredVariables.getcontactOwnerInfo1Dropdown().get());
			
			// Owner Info 1
			perform.type(driver, VMPNewOrder.ownerInfo1_txtbx(driver), StoredVariables.getcontactOwnerInfo1().get());
			
			// Owner Info 2 dropdown
			perform.selectDropdownOption(driver, VMPNewOrder.ownerInfo2_dropdown(driver), StoredVariables.getcontactOwnerInfo2Dropdown().get());
			
			// Owner Info 2
			perform.type(driver, VMPNewOrder.ownerInfo2_txtbx(driver), StoredVariables.getcontactOwnerInfo2().get());
		} // end owner
		
		// Occupant
		if (!StoredVariables.getcontactOccupant().get().equals("")) {
			perform.type(driver, VMPNewOrder.occupant_txtbx(driver), StoredVariables.getcontactOccupant().get());
			
			// Occupant Info 1 dropdown
			perform.selectDropdownOption(driver, VMPNewOrder.occupantInfo1_dropdown(driver), StoredVariables.getcontactOccupantInfo1Dropdown().get());
			
			// Occupant Info 1
			perform.type(driver, VMPNewOrder.occupantInfo1_txtbx(driver), StoredVariables.getcontactOccupantInfo1().get());
			
			// Occupant Info 2 dropdown
			perform.selectDropdownOption(driver, VMPNewOrder.occupantInfo2_dropdown(driver), StoredVariables.getcontactOccupantInfo2Dropdown().get());
			
			// Occupant Info 2
			perform.type(driver, VMPNewOrder.occupantInfo2_txtbx(driver), StoredVariables.getcontactOccupantInfo2().get());
		} // end Occupant
		
		// Agent
		if (!StoredVariables.getcontactAgent().get().equals("")) {
			perform.type(driver, VMPNewOrder.agent_txtbx(driver), StoredVariables.getcontactAgent().get());
			
			// Agent Info 1 dropdown
			perform.selectDropdownOption(driver, VMPNewOrder.agentInfo1_dropdown(driver), StoredVariables.getcontactAgentInfo1Dropdown().get());
			
			// Agent Info 1
			perform.type(driver, VMPNewOrder.agentInfo1_txtbx(driver), StoredVariables.getcontactAgentInfo1().get());
			
			// Agent Info 2 dropdown
			perform.selectDropdownOption(driver, VMPNewOrder.agentInfo2_dropdown(driver), StoredVariables.getcontactAgentInfo2Dropdown().get());
			
			// Agent Info 2
			perform.type(driver, VMPNewOrder.agentInfo2_txtbx(driver), StoredVariables.getcontactAgentInfo2().get());
		} // end Agent
		
		// Other
		if (!StoredVariables.getcontactOther().get().equals("")) {
			perform.type(driver, VMPNewOrder.other_txtbx(driver), StoredVariables.getcontactOther().get());
			
			// Other Info 1 dropdown
			perform.selectDropdownOption(driver, VMPNewOrder.otherInfo1_dropdown(driver), StoredVariables.getcontactOtherInfo1Dropdown().get());
			
			// Other Info 1
			perform.type(driver, VMPNewOrder.otherInfo1_txtbx(driver), StoredVariables.getcontactOtherInfo1().get());
			
			// Other Info 2 dropdown
			perform.selectDropdownOption(driver, VMPNewOrder.otherInfo2_dropdown(driver), StoredVariables.getcontactOtherInfo2Dropdown().get());
			
			// Other Info 2
			perform.type(driver, VMPNewOrder.otherInfo2_txtbx(driver), StoredVariables.getcontactOtherInfo2().get());
		} // end Other
		
		// Appt. Contact
		if (!StoredVariables.getcontactApptContact().get().equals("")) {
			perform.selectDropdownOption(driver, VMPNewOrder.apptContact_dropdown(driver), StoredVariables.getcontactApptContact().get());
		}
		
		/***********************************************
		 * Enter Additional Notifications Recipients
		 ***********************************************/
		
		// Enter additional email addresses
		if (!StoredVariables.getadditionalNotificationRecipientsAdditionalEmails().get().equals("")) {
			perform.type(driver, VMPNewOrder.additionalEmailRecipients_txtbx(driver), StoredVariables.getadditionalNotificationRecipientsAdditionalEmails().get());
		}
		
		// Enter additional comments
		if (!StoredVariables.getadditionalComments().get().equals("")) {
			perform.type(driver, VMPNewOrder.additionalComments_txtbx(driver), StoredVariables.getadditionalComments().get());
		}
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Entered new order information");
		
	} // end enterNewOrderOnVMP
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Wait for busy to be hidden</li>
	 * 	<li>Click the Cancel button if it is displayed</li>
	 * 	<li>Wait for busy to be hidden</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws InterruptedException the interrupted exception
	 */
	public void handleAddressMismatch(RemoteWebDriver driver) throws InterruptedException {
		
		System.out.println("Handle address mismatch");
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Handle address mismatch
		try {

			// Click Cancel button
			perform.click(driver, VMPNewOrder.cancel_btn(driver));

		} catch (Exception e) {
			// Address did not mismatch
		} // end try/catch
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
	} // end handleAddressMismatch
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Wait for busy to be hidden</li>
	 * 	<li>Click the Cancel button if it is displayed</li>
	 * 	<li>Wait for busy to be hidden</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws InterruptedException the interrupted exception
	 */
	public void handleUnknownAddress(RemoteWebDriver driver) throws InterruptedException {
		
		System.out.println("Handle unknown address");
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Handle address mismatch
		try {

			// Click Yes button
			perform.click(driver, VMPNewOrder.yes_btn(driver));

		} catch (Exception e) {
			// Address did not mismatch
		} // end try/catch
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
	} // end handleUnknownAddress
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Confirm order screen loads</li>
	 * 	<li>Verify order information</li>
	 * 	<li>Click Next</li>
	 * 	<li>Check header text for Credit Card</li>
	 * 	<li>Click Next</li>
	 * 	<li>Get outside frames</li>
	 * 	<li>Get inside the attach document frame</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Save New Order On VMP
	public void saveNewOrder(RemoteWebDriver driver) throws InterruptedException, IOException
	{
		
		System.out.println("Save the new order");
		
		perform.sleep(driver, 2);
		
		if (driver.getCurrentUrl().contains("OrderForm.aspx")) {
			
			System.out.println("There's a problem with the address");

			// Handle address mismatch
			String addressMismatch = null;
			String invalidAddress = null;
			try {
				addressMismatch = Overlay.addressMismatchDialog(driver).getAttribute("style");
				invalidAddress = Overlay.invalidAddressDialog(driver).getAttribute("style");
			} catch (Exception e) {
				addressMismatch = Overlay.addressMismatchDialog(driver).getAttribute("style");
				invalidAddress = Overlay.invalidAddressDialog(driver).getAttribute("style");
			} // end try/catch

			// Handle address mismatch
			if (addressMismatch.contains("block")) {
				handleAddressMismatch(driver);
			} // end handle address mismatch
			
			// Handle unknown address
			if (invalidAddress.contains("block")) {
				handleUnknownAddress(driver);
			} // end handle invalid address
			
		} // end if
		
		// Wait for the back button
		perform.waitForElementToBeClickable(driver, VMPConfirmOrder.backTop_btn(driver));
		
		// Confirm order screen loads
		Assert.assertTrue(driver.getCurrentUrl().contains("OrderConfirm"), "Order page did not load");
		
		// Verify order information
		verifyOrderDetails(driver);
		
		// Click Next
		perform.click(driver, VMPConfirmOrder.nextTop_btn(driver));
		
		Thread.sleep(3500);
		
		// Check header text for Credit Card
		if (VMPConfirmOrder.header_txt(driver).getText().contains("Credit Card"))
		{
			// Click Next
			perform.click(driver, VMPConfirmOrder.nextTop_btn(driver));
			Thread.sleep(3500);
		}
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Get outside frames
		driver.switchTo().defaultContent();
		// Get inside the attach document frame
		perform.switchToiFrameByID(driver, "iframeAttach");
		
		// Wait for Finished button
		try {
			perform.waitForElementToBeClickable(driver, VMPConfirmOrder.finished_btn(), "id");
		} catch (TimeoutException e) {
			driver.switchTo().defaultContent();
			perform.switchToiFrameByID(driver, "iframeAttach");
			perform.waitForElementToBeClickable(driver, VMPConfirmOrder.finished_btn(), "id");
		} // end try/catch
		
		// Add info to Extent Report
		perform.addInfoToExtentReport(driver, "Info", "Saved the order");
		
	} // end saveNewOrderOnVMP
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Create a new VMP Order</li>
	 * 	<li>Set unique address</li>
	 * 	<li>Go to New Order</li>
	 * 	<li>Enter order details</li>
	 * 	<li>Click Next</li>
	 * 	<li>Click Cancel button</li>
	 * 	<li>Enter Order Fee</li>
	 * 	<li>Select Deferred CC as the payment method</li>
	 * 	<li>Set variables for Deferred CC</li>
	 * 	<li>Enter First Name</li>
	 * 	<li>Enter Last Name</li>
	 * 	<li>Enter Street Address</li>
	 * 	<li>Enter City</li>
	 * 	<li>Select State dropdown</li>
	 * 	<li>Enter Zip</li>
	 * 	<li>Enter Email</li>
	 * 	<li>Save the order</li>
	 * 	<li>Click Finished</li>
	 * 	<li>Click OK</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>.
	 *
	 * @param driver the driver
	 * @param setOrderFee the set order fee
	 * @return the order fee
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Create a New Order on VMP using Deferred CC
	public String createNewOrderUsingDeferredCC(RemoteWebDriver driver, String setOrderFee) throws InterruptedException, IOException {

		ExtentTest test = ExtentTestManager.getTest();
		
		// Set unique address
		String uniqueID = perform.randomNumbers(driver, 10);
		StoredVariables.getpropertyInformationAddress().set(StoredVariables.getpropertyInformationAddress().get() + " " + uniqueID);
		
		// Go to New Order
		vmp.goToNewOrder(driver);
		
		// Enter order details
		vmp.enterNewOrder(driver);
		
		// Click Next
		perform.click(driver, VMPNewOrder.nextBottom_btn(driver));
		
		// Check for the Back button and handle address issues if it is not displayed
		List<WebElement> backButton = driver.findElements(By.id(VMPConfirmOrder.backTop_btn()));
		if (backButton.size()<1) {
		
			// Handle address mismatch
			handleAddressMismatch(driver);
			
			// Handle Unknown Address
			handleUnknownAddress(driver);
			
		} // end if

		// Wait for the order fee textbox
		perform.waitForElementToBeClickable(driver, VMPNewOrder.paymentMethod_dropdown(driver));
		
		// Enter Order Fee
		if (!setOrderFee.isEmpty()) {
			
			// Enter the fee
			perform.type(driver, VMPNewOrder.orderFee_txtbx(driver), setOrderFee.replace("$", "").replace(".00", ""));
			
		} // end if order fee
		
		// Select Deferred CC as the payment method
		perform.selectDropdownOption(driver, VMPNewOrder.paymentMethod_dropdown(driver), "Deferred CC");
		
		// Get the order fee to return
		String orderFee = "";
		orderFee = VMPNewOrder.orderFee_txtbx(driver).getAttribute("value");
		
		// Set variables for Deferred CC
		String firstName = "Automation";
		String lastName = "Test";
		String streetAddress = "123 Test St.";
		String city = "Yukon";
		String state = "Oklahoma";
		String zip = "73099";
		String email = "test@dntest.net";
		
		// Wait for First Name textbox
		perform.waitForElementToBeClickable(driver, VMPNewOrder.firstName_txtbx(), "id");
		
		// Enter First Name
		perform.type(driver, VMPNewOrder.firstName_txtbx(driver), firstName);
		
		// Enter Last Name
		perform.type(driver, VMPNewOrder.lastName_txtbx(driver), lastName);
		
		// Enter Street Address
		perform.type(driver, VMPNewOrder.streetAddress_txtbx(driver), streetAddress);
		
		// Enter City
		perform.type(driver, VMPNewOrder.cityPaymentMethod_txtbx(driver), city);
		
		// Select State dropdown
		perform.selectDropdownOption(driver, VMPNewOrder.statePaymentMethod_dropdown(driver), state);
		
		// Enter Zip
		perform.type(driver, VMPNewOrder.zip_txtbx(driver), zip);
		
		// Enter Email
		perform.type(driver, VMPNewOrder.email_txtbx(driver), email);
		
		// Save the order
		vmp.saveNewOrder(driver);
		
		// Click Finished
		perform.click(driver, VMPConfirmOrder.finished_btn(driver));
		
		// Switch out of iFrame
		driver.switchTo().defaultContent();
		
		// Click OK
		perform.click(driver, VMPConfirmOrder.ok_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Wait for Find textbox
		perform.waitForElementToBeClickable(driver, VMPOrders.find_txtbx(), "id");
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Created a new order using Deferred CC as the payment method");
		
		return orderFee;
		
	} // end createNewOrderUsingDeferredCC
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Property Information</li>
	 * 	<li>Assignment Information</li>
	 * 	<li>Lender Information</li>
	 * 	<li>Contact and Access Information</li>
	 * 	<li>Additional Data</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws InterruptedException the interrupted exception
	 */
	// Verify VMP Order Details
	public void verifyOrderDetails(RemoteWebDriver driver) throws InterruptedException
	{
		
		System.out.println("Verifying Order Details On VMP Client Portal");
		
		perform.waitForElementToBeClickable(driver, VMPConfirmOrder.orderInformation_txt(), "cssSelector");
		String orderInformation = VMPConfirmOrder.orderInformation_txt(driver).getText();
		
		// Property Information
		String[] propertyInformation = {StoredVariables.getpropertyInformationAddress().get(),
				StoredVariables.getpropertyInformationCity().get(),
				StoredVariables.getpropertyInformationStateAbbr().get(),
				StoredVariables.getpropertyInformationZip().get()};
		perform.verifyTextContains(driver, orderInformation, propertyInformation);
		
		// Property Type
		if (!StoredVariables.getpropertyInformationPropType().get().equals("")) {
			perform.verifyTextContains(driver, orderInformation, StoredVariables.getpropertyInformationPropType().get());
		}
		
		// Legal Description
		if (!StoredVariables.getpropertyInformationLegalDesc().get().equals("")) {
			perform.verifyTextContains(driver, orderInformation, StoredVariables.getpropertyInformationLegalDesc().get());
		}
		
		// Directions
		if (!StoredVariables.getpropertyInformationDirections().get().equals("")) {
			perform.verifyTextContains(driver, orderInformation, StoredVariables.getpropertyInformationDirections().get());
		}
		
		// Assignment Information
		perform.verifyTextContains(driver, orderInformation, StoredVariables.getassignmentInformationForm().get());
		
		// Other Ref Number
		if (!StoredVariables.getassignmentInformationOtherRefNumber().get().equals("")) {
			perform.verifyTextContains(driver, orderInformation, StoredVariables.getassignmentInformationOtherRefNumber().get());
		}
		
		// Loan Type
		if (!StoredVariables.getassignmentInformationLoanType().get().equals("")) {
			perform.verifyTextContains(driver, orderInformation, StoredVariables.getassignmentInformationLoanType().get());
		}
		
		// Loan Purpose
		if (!StoredVariables.getassignmentInformationLoanPurpose().get().equals("")) {
			perform.verifyTextContains(driver, orderInformation, StoredVariables.getassignmentInformationLoanPurpose().get());
		}
		
		// Ordered By
		if (!StoredVariables.getassignmentInformationOrderedBy().get().equals("")) {
			perform.verifyTextContains(driver, orderInformation, StoredVariables.getassignmentInformationOrderedBy().get());
		}
		
		// Loan Number
		if (!StoredVariables.getassignmentInformationLoanNumber().get().equals("")) {
			perform.verifyTextContains(driver, orderInformation, StoredVariables.getassignmentInformationLoanNumber().get());
		}
		
		// File Number
		if (!StoredVariables.getassignmentInformationFileNumber().get().equals("")) {
			perform.verifyTextContains(driver, orderInformation, StoredVariables.getassignmentInformationFileNumber().get());
		}
		
		// Sales Price
		if (!StoredVariables.getassignmentInformationSalesPrice().get().equals("")) {
			perform.verifyTextContains(driver, orderInformation, StoredVariables.getassignmentInformationSalesPrice().get());
		}
		
		// FHA Case Number
		if (!StoredVariables.getassignmentInformationFHACaseNumber().get().equals("")) {
			perform.verifyTextContains(driver, orderInformation, StoredVariables.getassignmentInformationFHACaseNumber().get());
		}
		
		// Lender Information
		if (!StoredVariables.getlenderInformationLenderName().get().equals("")) {
			perform.verifyTextContains(driver, orderInformation, StoredVariables.getlenderInformationLenderName().get());
		}
		
		// Contact and Access Information
		// Occupancy
		if (!StoredVariables.getcontactOccupancy().get().equals("")) {
			perform.verifyTextContains(driver, orderInformation, StoredVariables.getcontactOccupancy().get());
		}
		
		// Borrower
		if (!StoredVariables.getcontactBorrower().get().equals("")) {
			String[] contactBorrower = {StoredVariables.getcontactBorrower().get(),
					StoredVariables.getcontactBorrowerInfo1().get().replace("-", "").replace("(", "").replace(")", "").replace(" ", ""),
					StoredVariables.getcontactBorrowerInfo2().get().replace("-", "")};
			perform.verifyTextContains(driver, orderInformation, contactBorrower);
		}
		
		// Co-borrower
		if (!StoredVariables.getcontactCoBorrower().get().equals("")) {
			String[] coBorrower = {StoredVariables.getcontactCoBorrower().get(),
					StoredVariables.getcontactCoBorrowerInfo1().get().replace("-", "").replace("(", "").replace(")", "").replace(" ", ""),
					StoredVariables.getcontactCoBorrowerInfo2().get().replace("-", "").replace("(", "").replace(")", "").replace(" ", "")};
			perform.verifyTextContains(driver, orderInformation, coBorrower);
		}
		
		// Contact Owner
		if (!StoredVariables.getcontactOwner().get().equals("")) {
			String[] contactOwner = {StoredVariables.getcontactOwner().get(),
					StoredVariables.getcontactOwnerInfo1().get().replace("-", "").replace("(", "").replace(")", "").replace(" ", ""),
					StoredVariables.getcontactOwnerInfo2().get().replace("-", "").replace("(", "").replace(")", "").replace(" ", "")};
			perform.verifyTextContains(driver, orderInformation, contactOwner);
		}
		
		// Occupant
		if (!StoredVariables.getcontactOccupant().get().equals("")) {
			String[] contactOccupant = {StoredVariables.getcontactOccupant().get(),
					StoredVariables.getcontactOccupantInfo1().get().replace("-", "").replace("(", "").replace(")", "").replace(" ", ""),
					StoredVariables.getcontactOccupantInfo2().get().replace("-", "").replace("(", "").replace(")", "").replace(" ", "")};
			perform.verifyTextContains(driver, orderInformation, contactOccupant);
		}
		
		// Agent
		if (!StoredVariables.getcontactAgent().get().equals("")) {
			String[] contactAgent = {StoredVariables.getcontactAgent().get(),
					StoredVariables.getcontactAgentInfo1().get().replace("-", "").replace("(", "").replace(")", "").replace(" ", ""),
					StoredVariables.getcontactAgentInfo2().get().replace("-", "").replace("(", "").replace(")", "").replace(" ", "")};
			perform.verifyTextContains(driver, orderInformation, contactAgent);
		}
		
		// Other
		if (!StoredVariables.getcontactOther().get().equals("")) {
			String[] contactOther = {StoredVariables.getcontactOther().get(),
					StoredVariables.getcontactOtherInfo1().get().replace("-", "").replace("(", "").replace(")", "").replace(" ", ""),
					StoredVariables.getcontactOtherInfo2().get().replace("-", "").replace("(", "").replace(")", "").replace(" ", "")};
			perform.verifyTextContains(driver, orderInformation, contactOther);
		}
		
		// Appt Contact
		if (!StoredVariables.getcontactApptContact().get().equals("")) {
			perform.verifyTextContains(driver, orderInformation, StoredVariables.getcontactApptContact().get());
		}
		
		// Additional Data
		if (!StoredVariables.getadditionalComments().get().equals("")) {
			perform.verifyTextContains(driver, orderInformation, StoredVariables.getadditionalComments().get());
		}
		
	} // end verifyVMPOrderDetails
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Property Information</li>
	 * 	<li>Assignment Information</li>
	 * 	<li>Lender Information</li>
	 * 	<li>Contact and Access Information</li>
	 * 	<li>Additional Data</li>
	 * </ul>
	 *
	 * @param driver the driver
	 */
	// Verify VMP Appraisal Order Details
	public void verifyAppraisalOrderDetails(RemoteWebDriver driver)
	{
		
		System.out.println("Verifying Appraisal Order Details On VMP Client Portal");
		
		String orderInformation = VMPAppraisalOrderDetails.orderDetails_txt(driver).getText();
		// Property Information
		Assert.assertTrue(orderInformation.contains(StoredVariables.getpropertyInformationAddress().get()), "Address is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getpropertyInformationCity().get()), "City is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getpropertyInformationStateAbbr().get()), "State is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getpropertyInformationZip().get()), "Zip Code is not displayed on the Order Confirmation page");
		if (!StoredVariables.getpropertyInformationPropType().get().equals("")) {
			Assert.assertTrue(orderInformation.contains(StoredVariables.getpropertyInformationPropType().get()), "Prop Type is not displayed on the Order Confirmation page");
		}
		if (!StoredVariables.getpropertyInformationDirections().get().equals("")) {
			Assert.assertTrue(orderInformation.contains(StoredVariables.getpropertyInformationDirections().get()), "Directions is not displayed on the Order Confirmation page");
		}
		
		// Assignment Information
		Assert.assertTrue(orderInformation.contains(StoredVariables.getassignmentInformationForm().get()), "Form is not displayed on the Order Confirmation page");
		if (!StoredVariables.getassignmentInformationOtherRefNumber().get().equals("")) {
			Assert.assertTrue(orderInformation.contains(StoredVariables.getassignmentInformationOtherRefNumber().get()), "Other Ref Number is not displayed on the Order Confirmation page");
		}
		if (!StoredVariables.getassignmentInformationLoanType().get().equals("")) {
			Assert.assertTrue(orderInformation.contains(StoredVariables.getassignmentInformationLoanType().get()), "Loan Type is not displayed on the Order Confirmation page");
		}
		if (!StoredVariables.getassignmentInformationLoanPurpose().get().equals("")) {
			Assert.assertTrue(orderInformation.contains(StoredVariables.getassignmentInformationLoanPurpose().get()), "Loan Purpose is not displayed on the Order Confirmation page");
		}
		if (!StoredVariables.getassignmentInformationOrderedBy().get().equals("")) {
			Assert.assertTrue(orderInformation.contains(StoredVariables.getassignmentInformationOrderedBy().get()), "Ordered By is not displayed on the Order Confirmation page");
		}
		if (!StoredVariables.getassignmentInformationLoanNumber().get().equals("")) {
			Assert.assertTrue(orderInformation.contains(StoredVariables.getassignmentInformationLoanNumber().get()), "Loan Number is not displayed on the Order Confirmation page");
		}
		if (!StoredVariables.getassignmentInformationFileNumber().get().equals("")) {
			Assert.assertTrue(orderInformation.contains(StoredVariables.getassignmentInformationFileNumber().get()), "File Number is not displayed on the Order Confirmation page");
		}
		if (!StoredVariables.getassignmentInformationSalesPrice().get().equals("")) {
			Assert.assertTrue(orderInformation.contains(StoredVariables.getassignmentInformationSalesPrice().get()), "Sales Price is not displayed on the Order Confirmation page");
		}
		if (!StoredVariables.getassignmentInformationFHACaseNumber().get().equals("")) {
			Assert.assertTrue(orderInformation.contains(StoredVariables.getassignmentInformationFHACaseNumber().get()), "FHA Case Number is not displayed on the Order Confirmation page");
		}
		
		// Lender Information
		if (!StoredVariables.getlenderInformationLenderName().get().equals("")) {
			Assert.assertTrue(orderInformation.contains(StoredVariables.getlenderInformationLenderName().get()), "Lender Name is not displayed on the Order Confirmation page");
			Assert.assertTrue(orderInformation.contains(StoredVariables.getlenderInformationAddress1().get()), "Lender Stret is not displayed on the Order Confirmation page");
			Assert.assertTrue(orderInformation.contains(StoredVariables.getlenderInformationCity().get()), "Lender City is not displayed on the Order Confirmation page");
			Assert.assertTrue(orderInformation.contains(StoredVariables.getlenderInformationZip().get()), "Lender Zip is not displayed on the Order Confirmation page");
		}
		
		String contactInformation = VMPAppraisalOrderDetails.contactDetails_txt(driver).getText();
		// Contact and Access Information
		if (!StoredVariables.getcontactOccupancy().get().equals("")) {
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactOccupancy().get()), "Occupancy is not displayed on the Order Confirmation page");
		}
		if (!StoredVariables.getcontactBorrower().get().equals("")) {
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactBorrower().get()), "Borrower is not displayed on the Order Confirmation page");
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactBorrowerInfo1().get()), "Borrower Info 1 is not displayed on the Order Confirmation page");
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactBorrowerInfo2().get()), "Borrower Info 2 is not displayed on the Order Confirmation page");
		}
		if (!StoredVariables.getcontactCoBorrower().get().equals("")) {
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactCoBorrower().get()), "CoBorrower is not displayed on the Order Confirmation page");
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactCoBorrowerInfo1().get()), "CoBorrower Info 1 is not displayed on the Order Confirmation page");
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactCoBorrowerInfo2().get()), "CoBorrower Info 2 is not displayed on the Order Confirmation page");
		}
		if (!StoredVariables.getcontactOwner().get().equals("")) {
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactOwner().get()), "Owner is not displayed on the Order Confirmation page");
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactOwnerInfo1().get()), "Owner Info 1 is not displayed on the Order Confirmation page");
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactOwnerInfo2().get()), "Owner Info 2 is not displayed on the Order Confirmation page");
		}
		if (!StoredVariables.getcontactOccupant().get().equals("")) {
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactOccupant().get()), "Occupant is not displayed on the Order Confirmation page");
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactOccupantInfo1().get()), "Occupant Info 1 is not displayed on the Order Confirmation page");
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactOccupantInfo2().get()), "Occupant Info 2 is not displayed on the Order Confirmation page");
		}
		if (!StoredVariables.getcontactAgent().get().equals("")) {
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactAgent().get()), "Agent is not displayed on the Order Confirmation page");
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactAgentInfo1().get()), "Agent Info 1 is not displayed on the Order Confirmation page");
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactAgentInfo2().get()), "Agent Info 2 is not displayed on the Order Confirmation page");
		}
		if (!StoredVariables.getcontactOther().get().equals("")) {
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactOther().get()), "Other is not displayed on the Order Confirmation page");
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactOtherInfo1().get()), "Other Info 1 is not displayed on the Order Confirmation page");
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactOtherInfo2().get()), "Other Info 2 is not displayed on the Order Confirmation page");
		}
		if (!StoredVariables.getcontactApptContact().get().equals("")) {
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactApptContact().get()), "Appt Contact is not displayed on the Order Confirmation page");
		}
		
		String additionalNotificationRecipients = VMPAppraisalOrderDetails.additionalNotificationRecipients_txt(driver).getText();
		String additionalComments = VMPAppraisalOrderDetails.specialInstructions_txt(driver).getText();
		// Additional Data
		if (!StoredVariables.getadditionalNotificationRecipientsAdditionalEmails().get().equals("")) {
			Assert.assertTrue(additionalNotificationRecipients.contains(StoredVariables.getadditionalNotificationRecipientsAdditionalEmails().get()), "Additional Emails are not displayed on the Order Confirmation page");
		}
		if (!StoredVariables.getadditionalComments().get().equals("")) {
			Assert.assertTrue(additionalComments.contains(StoredVariables.getadditionalComments().get()), "Additional Comments are not displayed on the Order Confirmation page");
		}
		
	} // end verifyVMPAppraisalOrderDetails
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Property Information</li>
	 * 	<li>Assignment Information</li>
	 * 	<li>Lender Information</li>
	 * 	<li>Contact and Access Information</li>
	 * 	<li>Additional Data</li>
	 * </ul>
	 *
	 * @param driver the driver
	 */
	// Verify VMP Appraisal Order Details with no XML File attached
	public void verifyAppraisalOrderDetailsWithNoXML(RemoteWebDriver driver)
	{
		
		System.out.println("Verifying Appraisal Order Details On VMP Client Portal");
		
		String orderInformation = VMPAppraisalOrderDetails.orderDetails_txt(driver).getText();
		// Property Information
		Assert.assertTrue(orderInformation.contains(StoredVariables.getpropertyInformationAddress().get()), "Address is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getpropertyInformationCity().get()), "City is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getpropertyInformationStateAbbr().get()), "State is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getpropertyInformationZip().get()), "Zip Code is not displayed on the Order Confirmation page");
		if (!StoredVariables.getpropertyInformationPropType().get().equals("")) {
			Assert.assertTrue(orderInformation.contains(StoredVariables.getpropertyInformationPropType().get()), "Prop Type is not displayed on the Order Confirmation page");
		}
		if (!StoredVariables.getpropertyInformationDirections().get().equals("")) {
			Assert.assertTrue(orderInformation.contains(StoredVariables.getpropertyInformationDirections().get()), "Directions is not displayed on the Order Confirmation page");
		}
		
		// Assignment Information
		Assert.assertTrue(orderInformation.contains(StoredVariables.getassignmentInformationForm().get()), "Form is not displayed on the Order Confirmation page");
		if (!StoredVariables.getassignmentInformationOtherRefNumber().get().equals("")) {
			Assert.assertTrue(orderInformation.contains(StoredVariables.getassignmentInformationOtherRefNumber().get()), "Other Ref Number is not displayed on the Order Confirmation page");
		}
		if (!StoredVariables.getassignmentInformationLoanType().get().equals("")) {
			Assert.assertTrue(orderInformation.contains(StoredVariables.getassignmentInformationLoanType().get()), "Loan Type is not displayed on the Order Confirmation page");
		}
		if (!StoredVariables.getassignmentInformationLoanPurpose().get().equals("")) {
			Assert.assertTrue(orderInformation.contains(StoredVariables.getassignmentInformationLoanPurpose().get()), "Loan Purpose is not displayed on the Order Confirmation page");
		}
		if (!StoredVariables.getassignmentInformationOrderedBy().get().equals("")) {
			Assert.assertTrue(orderInformation.contains(StoredVariables.getassignmentInformationOrderedBy().get()), "Ordered By is not displayed on the Order Confirmation page");
		}
		if (!StoredVariables.getassignmentInformationLoanNumber().get().equals("")) {
			Assert.assertTrue(orderInformation.contains(StoredVariables.getassignmentInformationLoanNumber().get()), "Loan Number is not displayed on the Order Confirmation page");
		}
		if (!StoredVariables.getassignmentInformationFileNumber().get().equals("")) {
			Assert.assertTrue(orderInformation.contains(StoredVariables.getassignmentInformationFileNumber().get()), "File Number is not displayed on the Order Confirmation page");
		}
		if (!StoredVariables.getassignmentInformationSalesPrice().get().equals("")) {
			Assert.assertTrue(orderInformation.contains(StoredVariables.getassignmentInformationSalesPrice().get()), "Sales Price is not displayed on the Order Confirmation page");
		}
		if (!StoredVariables.getassignmentInformationFHACaseNumber().get().equals("")) {
			Assert.assertTrue(orderInformation.contains(StoredVariables.getassignmentInformationFHACaseNumber().get()), "FHA Case Number is not displayed on the Order Confirmation page");
		}
		
		// Lender Information
		if (!StoredVariables.getlenderInformationLenderName().get().equals("")) {
			Assert.assertTrue(orderInformation.contains(StoredVariables.getlenderInformationLenderName().get()), "Lender Name is not displayed on the Order Confirmation page");
			Assert.assertTrue(orderInformation.contains(StoredVariables.getlenderInformationAddress1().get()), "Lender Stret is not displayed on the Order Confirmation page");
			Assert.assertTrue(orderInformation.contains(StoredVariables.getlenderInformationCity().get()), "Lender City is not displayed on the Order Confirmation page");
			Assert.assertTrue(orderInformation.contains(StoredVariables.getlenderInformationZip().get()), "Lender Zip is not displayed on the Order Confirmation page");
		}
		
		String contactInformation = VMPAppraisalOrderDetails.contactDetails_txt(driver).getText();
		// Contact and Access Information
		if (!StoredVariables.getcontactOccupancy().get().equals("")) {
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactOccupancy().get()), "Occupancy is not displayed on the Order Confirmation page");
		}
		if (!StoredVariables.getcontactBorrower().get().equals("")) {
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactBorrower().get()), "Borrower is not displayed on the Order Confirmation page");
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactBorrowerInfo1().get()), "Borrower Info 1 is not displayed on the Order Confirmation page");
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactBorrowerInfo2().get()), "Borrower Info 2 is not displayed on the Order Confirmation page");
		}
		if (!StoredVariables.getcontactCoBorrower().get().equals("")) {
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactCoBorrower().get()), "CoBorrower is not displayed on the Order Confirmation page");
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactCoBorrowerInfo1().get()), "CoBorrower Info 1 is not displayed on the Order Confirmation page");
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactCoBorrowerInfo2().get()), "CoBorrower Info 2 is not displayed on the Order Confirmation page");
		}
		if (!StoredVariables.getcontactOwner().get().equals("")) {
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactOwner().get()), "Owner is not displayed on the Order Confirmation page");
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactOwnerInfo1().get()), "Owner Info 1 is not displayed on the Order Confirmation page");
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactOwnerInfo2().get()), "Owner Info 2 is not displayed on the Order Confirmation page");
		}
		if (!StoredVariables.getcontactOccupant().get().equals("")) {
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactOccupant().get()), "Occupant is not displayed on the Order Confirmation page");
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactOccupantInfo1().get()), "Occupant Info 1 is not displayed on the Order Confirmation page");
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactOccupantInfo2().get()), "Occupant Info 2 is not displayed on the Order Confirmation page");
		}
		if (!StoredVariables.getcontactAgent().get().equals("")) {
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactAgent().get()), "Agent is not displayed on the Order Confirmation page");
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactAgentInfo1().get()), "Agent Info 1 is not displayed on the Order Confirmation page");
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactAgentInfo2().get()), "Agent Info 2 is not displayed on the Order Confirmation page");
		}
		if (!StoredVariables.getcontactOther().get().equals("")) {
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactOther().get()), "Other is not displayed on the Order Confirmation page");
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactOtherInfo1().get()), "Other Info 1 is not displayed on the Order Confirmation page");
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactOtherInfo2().get()), "Other Info 2 is not displayed on the Order Confirmation page");
		}
		if (!StoredVariables.getcontactApptContact().get().equals("")) {
			Assert.assertTrue(contactInformation.contains(StoredVariables.getcontactApptContact().get()), "Appt Contact is not displayed on the Order Confirmation page");
		}
		
		String additionalNotificationRecipients = VMPAppraisalOrderDetails.additionalNotificationRecipients_txt(driver).getText();
		String additionalComments = VMPAppraisalOrderDetails.specialInstructions_txt(driver).getText();
		// Additional Data
		if (!StoredVariables.getadditionalNotificationRecipientsAdditionalEmails().get().equals("")) {
			Assert.assertTrue(additionalNotificationRecipients.contains(StoredVariables.getadditionalNotificationRecipientsAdditionalEmails().get()), "Additional Emails are not displayed on the Order Confirmation page");
		}
		if (!StoredVariables.getadditionalComments().get().equals("")) {
			Assert.assertTrue(additionalComments.contains(StoredVariables.getadditionalComments().get()), "Additional Comments are not displayed on the Order Confirmation page");
		}
		
	} // end verifyVMPAppraisalOrderDetailsWithNoXML
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Address</li>
	 * 	<li>City</li>
	 * 	<li>State</li>
	 * 	<li>Zip</li>
	 * 	<li>Prop Type</li>
	 * 	<li>Legal desc</li>
	 * 	<li>Directions</li>
	 * 	<li>Form</li>
	 * 	<li>Order Due</li>
	 * 	<li>Other Ref #</li>
	 * 	<li>Loan Type</li>
	 * 	<li>Loan Purpose</li>
	 * 	<li>Ordered By</li>
	 * 	<li>Account Exec.</li>
	 * 	<li>Loan #</li>
	 * 	<li>File #</li>
	 * 	<li>Sales Price</li>
	 * 	<li>FHA Case #</li>
	 * 	<li>Disclosure</li>
	 * 	<li>Lender Name</li>
	 * 	<li>Lender Street</li>
	 * 	<li>Lender City</li>
	 * 	<li>Lender State</li>
	 * 	<li>Lender Zip</li>
	 * 	<li>Occupancy</li>
	 * 	<li>Borrower</li>
	 * 	<li>Borrower Info 1 dropdown</li>
	 * 	<li>Borrower Info 1</li>
	 * 	<li>Borrower Info 2 dropdown</li>
	 * 	<li>Borrower Info 2</li>
	 * 	<li>CoBorrower</li>
	 * 	<li>CoBorrower Info 1 dropdown</li>
	 * 	<li>CoBorrower Info 1</li>
	 * 	<li>CoBorrower Info 2 dropdown</li>
	 * 	<li>CoBorrower Info 2</li>
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
	 * 	<li>Additional Comments</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws InterruptedException the interrupted exception
	 */
	// Verify VMP New Order Info
	public void verifyNewOrderInfo(RemoteWebDriver driver) throws InterruptedException
	{
		
		System.out.println("Verifying New Order Information On VMP");
		
		// Wait for Address text box
		perform.waitForElementToBeClickable(driver, VMPNewOrder.address_txtbx(), "id");
		
		/************************************************
		 * Property Information
		 ************************************************/
		String address = VMPNewOrder.address_txtbx(driver).getAttribute("value");
		int i = 1;
		while (!address.equals(StoredVariables.getpropertyInformationAddress().get()) && i <= 10) {
			Thread.sleep(1500);
			address = VMPNewOrder.address_txtbx(driver).getAttribute("value");
			i++;
		} // end while
		
		// Address
		Assert.assertTrue(VMPNewOrder.address_txtbx(driver).getAttribute("value").equals(StoredVariables.getpropertyInformationAddress().get()), "Address information was lost on the New Order page after clicking Back from the Confirm Order page");
		
		// City
		Assert.assertTrue(VMPNewOrder.city_txtbx(driver).getAttribute("value").equals(StoredVariables.getpropertyInformationCity().get()), "City information was lost on the New Order page after clicking Back from the Confirm Order page");
		
		// State
		String stateDropdown = new Select(VMPNewOrder.state_dropdown(driver)).getFirstSelectedOption().getText();
		Assert.assertTrue(stateDropdown.equals(StoredVariables.getpropertyInformationState().get()), "State information was lost on the New Order page after clicking Back from the Confirm Order page");
		
		// Zip
		Assert.assertTrue(VMPNewOrder.zipCode_txtbx(driver).getAttribute("value").equals(StoredVariables.getpropertyInformationZip().get()), "Zip information was lost on the New Order page after clicking Back from the Confirm Order page");
		
		// Prop Type
		if (!StoredVariables.getpropertyInformationPropType().get().equals("")) {
			String propTypeDropdown = new Select(VMPNewOrder.propType_dropdown(driver)).getFirstSelectedOption().getText();
			Assert.assertTrue(propTypeDropdown.equals(StoredVariables.getpropertyInformationPropType().get()), "Prop Type information was lost on the New Order page after clicking Back from the Confirm Order page");
		}
		
		// Legal desc
		if (!StoredVariables.getpropertyInformationLegalDesc().get().equals("")) {
			Assert.assertTrue(VMPNewOrder.legalDesc_txtbx(driver).getAttribute("value").equals(StoredVariables.getpropertyInformationLegalDesc().get()), "Legal Desc information was lost on the New Order page after clicking Back from the Confirm Order page");
		}
		
		// Directions
		if (!StoredVariables.getpropertyInformationDirections().get().equals("")) {
			Assert.assertTrue(VMPNewOrder.directions_txtbx(driver).getAttribute("value").equals(StoredVariables.getpropertyInformationDirections().get()), "Directions information was lost on the New Order page after clicking Back from the Confirm Order page");
		}
		
		/************************************************
		 * Assignment Information
		 ************************************************/
		// Form
		String formDropdown = new Select(VMPNewOrder.form_dropdown(driver)).getFirstSelectedOption().getText();
		Assert.assertTrue(formDropdown.equals(StoredVariables.getassignmentInformationForm().get()), "Form information was lost on the New Order page after clicking Back from the Confirm Order page");
		
		// Order Due
		Assert.assertTrue(VMPNewOrder.orderDue_txtbx(driver).getAttribute("value").equals(StoredVariables.getorderDueDateShort().get()), "Order Due information was lost on the New Order page after clicking Back from the Confirm Order page. Expected value = " + StoredVariables.getorderDueDateShort().get() + "   The on-screen data = " + VMPNewOrder.orderDue_txtbx(driver).getAttribute("value"));
		
		// Other Ref #
		if (!StoredVariables.getassignmentInformationOtherRefNumber().get().equals("")) {
			Assert.assertTrue(VMPNewOrder.otherRefNumber_txtbx(driver).getAttribute("value").equals(StoredVariables.getassignmentInformationOtherRefNumber().get()), "Other Ref # information was lost on the New Order page after clicking Back from the Confirm Order page");
		}
		
		// Loan Type
		if (!StoredVariables.getassignmentInformationLoanType().get().equals("")) {
			String loanTypeDropdown = new Select(VMPNewOrder.loanType_dropdown(driver)).getFirstSelectedOption().getText();
			Assert.assertTrue(loanTypeDropdown.equals(StoredVariables.getassignmentInformationLoanType().get()), "Loan Type information was lost on the New Order page after clicking Back from the Confirm Order page");
		}
		
		// Loan Purpose
		if (!StoredVariables.getassignmentInformationLoanPurpose().get().equals("")) {
			String loanPurposeDropdown = new Select(VMPNewOrder.loanPurpose_dropdown(driver)).getFirstSelectedOption().getText();
			Assert.assertTrue(loanPurposeDropdown.equals(StoredVariables.getassignmentInformationLoanPurpose().get()), "Loan Purpose information was lost on the New Order page after clicking Back from the Confirm Order page");
		}
		
		// Ordered By
		if (!StoredVariables.getassignmentInformationOrderedBy().get().equals("")) {
			Assert.assertTrue(VMPNewOrder.orderedBy_txtbx(driver).getAttribute("value").equals(StoredVariables.getassignmentInformationOrderedBy().get()), "Ordered By information was lost on the New Order page after clicking Back from the Confirm Order page");
		}
		
		// Account Exec.
		if (!StoredVariables.getassignmentInformationAccountExec().get().equals("")) {
			String accountExecDropdown = new Select(VMPNewOrder.accountExec_dropdown(driver)).getFirstSelectedOption().getText();
			Assert.assertTrue(accountExecDropdown.equals(StoredVariables.getassignmentInformationAccountExec().get()), "Account Exec information was lost on the New Order page after clicking Back from the Confirm Order page");
		}
		
		// Loan #
		if (!StoredVariables.getassignmentInformationLoanNumber().get().equals("")) {
			Assert.assertTrue(VMPNewOrder.loanNumber_txtbx(driver).getAttribute("value").equals(StoredVariables.getassignmentInformationLoanNumber().get()), "Loan # information was lost on the New Order page after clicking Back from the Confirm Order page");
		}
		
		// File #
		if (!StoredVariables.getassignmentInformationFileNumber().get().equals("")) {
			String fileNumber = VMPNewOrder.fileNumber_txtbx(driver).getAttribute("value");
			Assert.assertTrue(fileNumber.equals(StoredVariables.getassignmentInformationFileNumber().get()), "File # information was lost on the New Order page after clicking Back from the Confirm Order page. The screen is "+fileNumber+" but it should be " + StoredVariables.getassignmentInformationFileNumber().get());
		}
		
		// Sales Price
		if (!StoredVariables.getassignmentInformationSalesPrice().get().equals("")) {
			Assert.assertTrue(VMPNewOrder.salesPrice_txtbx(driver).getAttribute("value").equals(StoredVariables.getassignmentInformationSalesPrice().get().replace(",","")), "Sales Price information was lost on the New Order page after clicking Back from the Confirm Order page");
		}
		
		// FHA Case #
		if (!StoredVariables.getassignmentInformationFHACaseNumber().get().equals("")) {
			Assert.assertTrue(VMPNewOrder.fhaCaseNumber_txtbx(driver).getAttribute("value").equals(StoredVariables.getassignmentInformationFHACaseNumber().get()), "FHA Case information was lost on the New Order page after clicking Back from the Confirm Order page");
		}
		
		// Disclosure
		if (!StoredVariables.getdisclosureDateShort().get().equals("")) {
			Assert.assertTrue(VMPNewOrder.disclosure_txtbx(driver).getAttribute("value").equals(StoredVariables.getdisclosureDateShort().get()), "Disclosure information was lost on the New Order page after clicking Back from the Confirm Order page");
		}
		
		/************************************************
		 * Lender Information
		 ************************************************/
		if (!StoredVariables.getlenderInformationLenderName().get().equals("")) {
			// Lender Name
			Assert.assertTrue(VMPNewOrder.lenderName_txtbx(driver).getAttribute("value").equals(StoredVariables.getlenderInformationLenderName().get()), "Lender Name information was lost on the New Order page after clicking Back from the Confirm Order page");
			
			// Lender Street
			Assert.assertTrue(VMPNewOrder.lenderAddress1_txtbx(driver).getAttribute("value").equals(StoredVariables.getlenderInformationAddress1().get()), "Lender Address 1 information was lost on the New Order page after clicking Back from the Confirm Order page");
			
			// Lender City
			Assert.assertTrue(VMPNewOrder.lenderCity_txtbx(driver).getAttribute("value").equals(StoredVariables.getlenderInformationCity().get()), "City information was lost on the New Order page after clicking Back from the Confirm Order page");
			
			// Lender State
			String lenderStateDropdown = new Select(VMPNewOrder.lenderState_dropdown(driver)).getFirstSelectedOption().getText();
			Assert.assertTrue(lenderStateDropdown.equals(StoredVariables.getlenderInformationState().get()), "State information was lost on the New Order page after clicking Back from the Confirm Order page");
			
			// Lender Zip
			Assert.assertTrue(VMPNewOrder.lenderZip_txtbx(driver).getAttribute("value").equals(StoredVariables.getlenderInformationZip().get()), "Zip information was lost on the New Order page after clicking Back from the Confirm Order page");
		}
		
		/************************************************
		 * Contact and Access Information
		 ************************************************/
		// Occupancy
		if (!StoredVariables.getcontactOccupancy().get().equals("")) {
			String occupancyDropdown = new Select(VMPNewOrder.occupancy_dropdown(driver)).getFirstSelectedOption().getText();
			Assert.assertTrue(occupancyDropdown.equals(StoredVariables.getcontactOccupancy().get()), "Zip information was lost on the New Order page after clicking Back from the Confirm Order page");
		}
		
		// Borrower
		if (!StoredVariables.getcontactBorrower().get().equals("")) {
			Assert.assertTrue(VMPNewOrder.borrower_txtbx(driver).getAttribute("value").contains(StoredVariables.getcontactBorrower().get()), "Borrower information was lost on the New Order page after clicking Back from the Confirm Order page");
			
			// Borrower Info 1 dropdown
			String borrowerInfo1Dropdown = new Select(VMPNewOrder.borrowerInfo1_dropdown(driver)).getFirstSelectedOption().getText();
			Assert.assertTrue(borrowerInfo1Dropdown.equals(StoredVariables.getcontactBorrowerInfo1Dropdown().get()), "Borrower Info 1 Dropdown information was lost on the New Order page after clicking Back from the Confirm Order page");
			
			// Borrower Info 1
			Assert.assertTrue(VMPNewOrder.borrowerInfo1_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactBorrowerInfo1().get()), "Borrower Info 1 information was lost on the New Order page after clicking Back from the Confirm Order page");
			
			// Borrower Info 2 dropdown
			String borrowerInfo2Dropdown = new Select(VMPNewOrder.borrowerInfo2_dropdown(driver)).getFirstSelectedOption().getText();
			Assert.assertTrue(borrowerInfo2Dropdown.equals(StoredVariables.getcontactBorrowerInfo2Dropdown().get()), "Borrower Info 2 Dropdown information was lost on the New Order page after clicking Back from the Confirm Order page");
			
			// Borrower Info 2
			Assert.assertTrue(VMPNewOrder.borrowerInfo2_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactBorrowerInfo2().get()), "Borrower Info 2 information was lost on the New Order page after clicking Back from the Confirm Order page");
		}
		
		// CoBorrower
		if (!StoredVariables.getcontactCoBorrower().get().equals("")) {
			Assert.assertTrue(VMPNewOrder.coBorrower_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactCoBorrower().get()), "CoBorrower information was lost on the New Order page after clicking Back from the Confirm Order page");
			
			// CoBorrower Info 1 dropdown
			String coBorrowerInfo1Dropdown = new Select(VMPNewOrder.coBorrowerInfo1_dropdown(driver)).getFirstSelectedOption().getText();
			Assert.assertTrue(coBorrowerInfo1Dropdown.equals(StoredVariables.getcontactCoBorrowerInfo1Dropdown().get()), "CoBorrower Info 1 Dropdown information was lost on the New Order page after clicking Back from the Confirm Order page");
			
			// CoBorrower Info 1
			Assert.assertTrue(VMPNewOrder.coBorrowerInfo1_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactCoBorrowerInfo1().get()), "CoBorrower Info 1 information was lost on the New Order page after clicking Back from the Confirm Order page");
			
			// CoBorrower Info 2 dropdown
			String coBorrowerInfo2Dropdown = new Select(VMPNewOrder.coBorrowerInfo2_dropdown(driver)).getFirstSelectedOption().getText();
			Assert.assertTrue(coBorrowerInfo2Dropdown.equals(StoredVariables.getcontactCoBorrowerInfo2Dropdown().get()), "CoBorrower Info 2 Dropdown information was lost on the New Order page after clicking Back from the Confirm Order page");
			
			// CoBorrower Info 2
			Assert.assertTrue(VMPNewOrder.coBorrowerInfo2_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactCoBorrowerInfo2().get()), "CoBorrower Info 2 information was lost on the New Order page after clicking Back from the Confirm Order page");
		}
		
		// Owner
		if (!StoredVariables.getcontactOwner().get().equals("")) {
			Assert.assertTrue(VMPNewOrder.owner_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactOwner().get()), "Owner information was lost on the New Order page after clicking Back from the Confirm Order page. Should be = " + StoredVariables.getcontactOwner().get() + "    The on-screen data = " + VMPNewOrder.owner_txtbx(driver).getAttribute("value"));
			
			// Owner Info 1 dropdown
			String ownerInfo1Dropdown = new Select(VMPNewOrder.ownerInfo1_dropdown(driver)).getFirstSelectedOption().getText();
			Assert.assertTrue(ownerInfo1Dropdown.equals(StoredVariables.getcontactOwnerInfo1Dropdown().get()), "Owner Info 1 Dropdown information was lost on the New Order page after clicking Back from the Confirm Order page");
			
			// Owner Info 1
			Assert.assertTrue(VMPNewOrder.ownerInfo1_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactOwnerInfo1().get()), "Owner Info 1 information was lost on the New Order page after clicking Back from the Confirm Order page");
			
			// Owner Info 2 dropdown
			String ownerInfo2Dropdown = new Select(VMPNewOrder.ownerInfo2_dropdown(driver)).getFirstSelectedOption().getText();
			Assert.assertTrue(ownerInfo2Dropdown.equals(StoredVariables.getcontactOwnerInfo2Dropdown().get()), "Owner Info 2 Dropdown information was lost on the New Order page after clicking Back from the Confirm Order page");
			
			// Owner Info 2
			Assert.assertTrue(VMPNewOrder.ownerInfo2_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactOwnerInfo2().get()), "Owner Info 2 information was lost on the New Order page after clicking Back from the Confirm Order page");
		}
			
		// Occupant
		if (!StoredVariables.getcontactOccupant().get().equals("")) {
			Assert.assertTrue(VMPNewOrder.occupant_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactOccupant().get()), "Occupant information was lost on the New Order page after clicking Back from the Confirm Order page");
			
			// Occupant Info 1 dropdown
			String occupantInfo1Dropdown = new Select(VMPNewOrder.occupantInfo1_dropdown(driver)).getFirstSelectedOption().getText();
			Assert.assertTrue(occupantInfo1Dropdown.equals(StoredVariables.getcontactOccupantInfo1Dropdown().get()), "Occupant Info 1 Dropdown information was lost on the New Order page after clicking Back from the Confirm Order page");
			
			// Occupant Info 1
			Assert.assertTrue(VMPNewOrder.occupantInfo1_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactOccupantInfo1().get()), "Occupant Info 1 information was lost on the New Order page after clicking Back from the Confirm Order page");
			
			// Occupant Info 2 dropdown
			String occupantInfo2Dropdown = new Select(VMPNewOrder.occupantInfo2_dropdown(driver)).getFirstSelectedOption().getText();
			Assert.assertTrue(occupantInfo2Dropdown.equals(StoredVariables.getcontactOccupantInfo2Dropdown().get()), "Occupant Info 2 Dropdown information was lost on the New Order page after clicking Back from the Confirm Order page");
			
			// Occupant Info 2
			Assert.assertTrue(VMPNewOrder.occupantInfo2_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactOccupantInfo2().get()), "Occupant Info 2 information was lost on the New Order page after clicking Back from the Confirm Order page");
		}
		
		// Agent
		if (!StoredVariables.getcontactAgent().get().equals("")) {
			Assert.assertTrue(VMPNewOrder.agent_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactAgent().get()), "Agent information was lost on the New Order page after clicking Back from the Confirm Order page");
			
			// Agent Info 1 dropdown
			String agentInfo1Dropdown = new Select(VMPNewOrder.agentInfo1_dropdown(driver)).getFirstSelectedOption().getText();
			Assert.assertTrue(agentInfo1Dropdown.equals(StoredVariables.getcontactAgentInfo1Dropdown().get()), "Agent Info 1 Dropdown information was lost on the New Order page after clicking Back from the Confirm Order page");
			
			// Agent Info 1
			Assert.assertTrue(VMPNewOrder.agentInfo1_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactAgentInfo1().get()), "Agent Info 1 information was lost on the New Order page after clicking Back from the Confirm Order page");
			
			// Agent Info 2 dropdown
			String agentInfo2Dropdown = new Select(VMPNewOrder.agentInfo2_dropdown(driver)).getFirstSelectedOption().getText();
			Assert.assertTrue(agentInfo2Dropdown.equals(StoredVariables.getcontactAgentInfo2Dropdown().get()), "Agent Info 2 Dropdown information was lost on the New Order page after clicking Back from the Confirm Order page");
			
			// Agent Info 2
			Assert.assertTrue(VMPNewOrder.agentInfo2_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactAgentInfo2().get()), "Agent Info 2 information was lost on the New Order page after clicking Back from the Confirm Order page");
		}
		
		// Other
		if (!StoredVariables.getcontactOther().get().equals("")) {
			Assert.assertTrue(VMPNewOrder.other_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactOther().get()), "Other information was lost on the New Order page after clicking Back from the Confirm Order page");
			
			// Other Info 1 dropdown
			String otherInfo1Dropdown = new Select(VMPNewOrder.otherInfo1_dropdown(driver)).getFirstSelectedOption().getText();
			Assert.assertTrue(otherInfo1Dropdown.equals(StoredVariables.getcontactOtherInfo1Dropdown().get()), "Other Info 1 Dropdown information was lost on the New Order page after clicking Back from the Confirm Order page");
			
			// Other Info 1
			Assert.assertTrue(VMPNewOrder.otherInfo1_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactOtherInfo1().get()), "Other Info 1 information was lost on the New Order page after clicking Back from the Confirm Order page");
			
			// Other Info 2 dropdown
			String otherInfo2Dropdown = new Select(VMPNewOrder.otherInfo2_dropdown(driver)).getFirstSelectedOption().getText();
			Assert.assertTrue(otherInfo2Dropdown.equals(StoredVariables.getcontactOtherInfo2Dropdown().get()), "Other Info 2 Dropdown information was lost on the New Order page after clicking Back from the Confirm Order page");
			
			// Other Info 2
			Assert.assertTrue(VMPNewOrder.otherInfo2_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactOtherInfo2().get()), "Other Info 2 information was lost on the New Order page after clicking Back from the Confirm Order page");
		}
		
		// Appt. Contact
		if (!StoredVariables.getcontactApptContact().get().equals("")) {
			String apptContactDropdown = new Select(VMPNewOrder.apptContact_dropdown(driver)).getFirstSelectedOption().getText();
			Assert.assertTrue(apptContactDropdown.equals(StoredVariables.getcontactApptContact().get()), "Appt. Contact information was lost on the New Order page after clicking Back from the Confirm Order page");
		}
		
		/************************************************
		 * Additional Notification Recipients
		 ************************************************/
		// Additional Email
		if (!StoredVariables.getadditionalNotificationRecipientsAdditionalEmails().get().equals("")) {
			Assert.assertTrue(VMPNewOrder.additionalEmailRecipients_txtbx(driver).getAttribute("value").equals(StoredVariables.getadditionalNotificationRecipientsAdditionalEmails().get()), "Appt. Contact information was lost on the New Order page after clicking Back from the Confirm Order page");
		}
		
		// Additional Comments
		if (!StoredVariables.getadditionalComments().get().equals("")) {
			Assert.assertTrue(VMPNewOrder.additionalComments_txtbx(driver).getAttribute("value").equals(StoredVariables.getadditionalComments().get()), "Additional comments were lost on the New Order page after clicking Back from the Confirm Order page");
		}
		
	} // end verifyVMPNewOrderInfo
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to Orders Page</li>
	 * 	<li>Enter borrower identifier into Find textbox</li>
	 * 	<li>Click the Contains radio button</li>
	 * 	<li>Select Field dropdown</li>
	 * 	<li>Click the Find magnifying glass</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param search the search
	 * @param field the field
	 * @throws InterruptedException the interrupted exception
	 */
	// Find order on VMP
	public void findOrder(RemoteWebDriver driver, String search, String field) throws InterruptedException
	{
		
		ExtentTest test = ExtentTestManager.getTest();
		
		System.out.println("Searching for " + search + " in " + field);

		// Go to Orders Page
		perform.click(driver, VMPOrders.orders_btn(driver));
		
		// Wait for the Find text box
		perform.waitForElementToBeClickable(driver, VMPOrders.find_txtbx(), "id");
		
		// Enter borrower identifier into Find textbox
		perform.type(driver, VMPOrders.find_txtbx(driver), search);
		
		// Click the Contains radio button
		perform.click(driver, VMPOrders.contains_radioBtn(driver));
		
		// Select Field dropdown
		perform.selectDropdownOption(driver, VMPOrders.inField_dropdown(driver), field);
		
		// Click the Find magnifying glass
		perform.click(driver, VMPOrders.find_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		Thread.sleep(1000);
		
		// Wait for the grid to be visible
		perform.waitForElementToBeVisible(driver, VMPOrders.ordersTable(), "id");
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Search for order: " + search);
		
	} // end findOrderOnVMP
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Search for order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>.
	 *
	 * @param driver the driver
	 * @param trackingNumber the tracking number
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	// Find and open order on Secure
	public void findAndOpenOrder(RemoteWebDriver driver, String trackingNumber) throws InterruptedException, IOException, ClassNotFoundException, SQLException
	{
		
		System.out.println("Find and open order " + trackingNumber);

		ExtentTest test = ExtentTestManager.getTest();
		
		// Search for order
		findOrder(driver, trackingNumber, "Tracking #");
		
		// Open the order
		openOrder(driver, trackingNumber);
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Opened order in VMP: " + trackingNumber);
		
	} // end findAndOpenOrder
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to VMP Client</li>
	 * 	<li>Find the order by the Tracking #</li>
	 * 	<li>Open the order</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param vmpURL the vmp URL
	 * @param userVMP the user VMP
	 * @param password the password
	 * @param trackingNumber the tracking number
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ClassNotFoundException the ClassNotFoundExceptionthe class not found exception
	 * @throws SQLException the SQLExceptionthe SQL exception
	 */	
	// Open order on VMP
	public void loginAndOpenOrderByTrackingNumber(RemoteWebDriver driver, String vmpURL, String userVMP, String password, String trackingNumber) throws InterruptedException, IOException, ClassNotFoundException, SQLException {
		
		// Login
		login(driver, vmpURL, userVMP, password);
		
		// Find the order
		findOrder(driver, trackingNumber, "Tracking #");
		
		// Open the order		
		openOrder(driver, trackingNumber);
		
	} // end loginAndOpenOrder
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Open the order</li>
	 * 	<li>Click the order</li>
	 * 	<li>Click View Order</li>
	 * 	<li>Get Tracking Number</li>
	 * 	<li>Check for data on screen</li>
	 * 	<li>Click Back</li>
	 * 	<li>Search for the order again</li>
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
	// Open order on VMP
	public void openOrder(RemoteWebDriver driver, String trackingNumber) throws InterruptedException, IOException, ClassNotFoundException, SQLException
	{
		
		ExtentTest test = ExtentTestManager.getTest();
		
		System.out.println("Open order " + trackingNumber);
		
		// Open the order		
		if (StoredVariables.getmobile().get()==false) {
			perform.doubleClickInTable(driver, trackingNumber);
		} else {
			// Click the order
			perform.clickInTable_Contains(driver, trackingNumber);
			// Click View Order
			perform.clickInTable_Contains(driver, "View Order");
		} // end if/else
		
		// Wait for the Back button to be clickable
		perform.waitForElementToBeClickable(driver, VMPAppraisalOrderDetails.back_btn(), "cssSelector");
		
		// Get Tracking Number
		String trackingNumberText = VMPAppraisalOrderDetails.trackingNumber_txt(driver).getText();
		
		// Check for data on screen
		int attempt = 1;
		while (trackingNumberText.equals("") && attempt < 6) {
			
			System.out.println("Attempt "+attempt+" at opening the VMP order");
			
			Thread.sleep(5000);
			
			// Click Back
			perform.click(driver, VMPAppraisalOrderDetails.back_btn(driver));
			
			// Search for the order again
			vmp.findOrder(driver, trackingNumber, "Tracking #");
			
			// Open the order		
			if (StoredVariables.getmobile().get()==false) {
				perform.doubleClickInTable(driver, trackingNumber);
			} else {
				// Click the order
				perform.clickInTable_Contains(driver, trackingNumber);
				// Click View Order
				perform.clickInTable_Contains(driver, "View Order");
			} // end if/else
			
			// Wait for the Back button to be clickable
			perform.waitForElementToBeClickable(driver, VMPAppraisalOrderDetails.back_btn(), "cssSelector");
			
			trackingNumberText = VMPAppraisalOrderDetails.trackingNumber_txt(driver).getText();
			
			attempt++;
			
		} // end while
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Open order: " + trackingNumber);
		
	} // end openOrder
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Check for updated history</li>
	 * 	<li>Get start and end time for polling the db</li>
	 * 	<li>Date dNow = new Date( );  Instantiate a Date object</li>
	 * 	<li>Set 10 minute while loop timeout</li>
	 * 	<li>Search for order</li>
	 * 	<li>Get status text</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param textToWaitFor the text to wait for
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Wait for the database to update by checking the text in the Order Status on VMP Client Portal
	public void waitForDBUpdateForOrderStatus(RemoteWebDriver driver, String textToWaitFor) throws InterruptedException, IOException
	{
		
		System.out.println("Wait for db to update - " + textToWaitFor);
		
		// Wait for db to update
		boolean dbUpdate = false;
		
		String statusText = VMPOrders.orderStatus_txt(driver).getText();
		
		// Check for updated history
		if (statusText.contains(textToWaitFor))
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
			
			// Search for order
			findOrder(driver, StoredVariables.getloanIDVMP().get(), "Tracking #");
			
			// Get status text
			statusText = VMPOrders.orderStatus_txt(driver).getText();
			
			// Check if db has updated
			if (statusText.contains(textToWaitFor))
			{
				System.out.println("DB has been updated");
				break;
			} // end if
			
			driver.navigate().refresh();
			
			Thread.sleep(5000);
			
		} // end while loop
		
	} // end waitForDBUpdateForOrderStatusOnVMPClientPortal
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Check for updated history</li>
	 * 	<li>Get start and end time for polling the db</li>
	 * 	<li>Set 10 minute while loop timeout</li>
	 * 	<li>Go to Orders Page</li>
	 * 	<li>Search for order</li>
	 * 	<li>Open order</li>
	 * 	<li>Get history text</li>
	 * 	<li>Check if db has updated</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param textToWaitFor the text to wait for
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Wait for the database to update by checking the text in the Order Status on VMP Client Portal
	public void waitForDBUpdateForHistory(RemoteWebDriver driver, String textToWaitFor) throws InterruptedException, IOException
	{
		
		System.out.println("Wait for db to update - " + textToWaitFor);
		
		// Wait for db to update
		boolean dbUpdate = false;
		
		String history = VMPAppraisalOrderDetails.history_txt(driver).getText();
		
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
			
			// Go to Orders Page
			perform.click(driver, VMPOrders.orders_btn(driver));
			
			// Wait for the Find text box
			perform.waitForElementToBeClickable(driver, VMPOrders.find_txtbx(), "id");
			
			// Search for order
			findOrder(driver, StoredVariables.getloanIDVMP().get(), "Tracking #");
			
			// Open order
			perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());
			
			Thread.sleep(1500);
			
			// Wait for Edit Property Contacts link
			perform.waitForElementToBeClickable(driver, VMPAppraisalOrderDetails.editPropertyContacts_lnk(), "id");
			
			// Get history text
			history = VMPAppraisalOrderDetails.history_txt(driver).getText();
			
			// Check if db has updated
			if (history.contains(textToWaitFor))
			{
				System.out.println("DB has been updated");
				break;
			} // end if
			
			driver.navigate().refresh();
			
			Thread.sleep(5000);
			
		} // end while loop
		
	} // end waitForDBUpdateForHistoryOnVMPClientPortal
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>disable the click event on an `&lt;input&gt;` file</li>
	 * 	<li>trigger the upload</li>
	 * 	<li>assign the file to the `&lt;input&gt;`</li>
	 * 	<li>Set 40 second while loop timeout</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param filePath the file path
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Upload document on VMP Appraisal Order Details
	public void uploadDocumentOnAppraisalOrderDetails(RemoteWebDriver driver, String filePath) throws InterruptedException, IOException
	{
		
		ExtentTest test = ExtentTestManager.getTest();
		
		System.out.println("Uploading a document");
	
		// disable the click event on an `<input>` file
		((JavascriptExecutor)driver).executeScript(
		    "HTMLInputElement.prototype.click = function() {                     " +
		    "  if(this.type !== 'file') HTMLElement.prototype.click.call(this);  " +
		    "};                                                                  " );
	
		// trigger the upload
		perform.click(driver, VMPConfirmOrder.uploadDocuments_btn(driver));
	
		// assign the file to the `<input>`
		driver.findElement(By.cssSelector("input[type=file]")).sendKeys(filePath);
		
		// Wait for completed check mark icon
		perform.waitForElementToBeVisible(driver, VMPAppraisalOrderDetails.attached_icon(), "id");
		String attachComplete = VMPAppraisalOrderDetails.attached_icon(driver).getAttribute("class");
		// Set 40 second while loop timeout
		long start_time = System.currentTimeMillis();
		long wait_time = 40000;
		long end_time = start_time + wait_time;
		while (System.currentTimeMillis() < end_time && !attachComplete.contains("OuterIconComplete"))
		{
			Thread.sleep(1000);
			attachComplete = VMPAppraisalOrderDetails.attached_icon(driver).getAttribute("class");
			if (attachComplete.contains("OuterIconComplete"))
			{
				break;
			} // end if
		} // end while
		
		// Wait for Finished button
		perform.waitForElementToBeClickable(driver, VMPConfirmOrder.finished_btn(), "id");
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Uploaded document on Appraisal Order Details screen: " + filePath);
		
	} // end uploadDocumentOnVMPAppraisalOrderDetails
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>disable the click event on an `&lt;input&gt;` file</li>
	 * 	<li>trigger the upload</li>
	 * 	<li>assign the file to the `&lt;input&gt;`</li>
	 * 	<li>Set 40 second while loop timeout</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param filePath the file path
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Upload Sales Contract on VMP Confirm Order
	public void uploadSalesContractOnVMPConfirmOrder(RemoteWebDriver driver, String filePath) throws InterruptedException, IOException
	{
		
		ExtentTest test = ExtentTestManager.getTest();
		
		System.out.println("Uploading a document");
	
		// disable the click event on an `<input>` file
		((JavascriptExecutor)driver).executeScript(
		    "HTMLInputElement.prototype.click = function() {                     " +
		    "  if(this.type !== 'file') HTMLElement.prototype.click.call(this);  " +
		    "};                                                                  " );
	
		// trigger the upload
		perform.click(driver, VMPConfirmOrder.uploadSalesContract_btn(driver));
	
		// assign the file to the `<input>`
		perform.type(driver, driver.findElement(By.cssSelector("input[type=file]")), filePath);
		
		// Wait for delete button
		perform.waitForElementToBeVisible(driver, VMPConfirmOrder.deleteFile_btn(), "id");
		
		String uploadLinkText = VMPConfirmOrder.uploadSalesContract_btn(driver).getText();
		// Set 40 second while loop timeout
		long start_time = System.currentTimeMillis();
		long wait_time = 40000;
		long end_time = start_time + wait_time;
		while (System.currentTimeMillis() < end_time && !uploadLinkText.contains("SalesContract.pdf"))
		{
			Thread.sleep(1000);
			uploadLinkText = VMPConfirmOrder.uploadSalesContract_btn(driver).getText();
			if (uploadLinkText.contains("SalesContract.pdf"))
			{
				break;
			} // end if
		} // end while
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Uploaded sales contract on the Confirm Order screen");
		
	} // end uploadSalesContractOnVMPConfirmOrder
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>disable the click event on an `&lt;input&gt;` file</li>
	 * 	<li>trigger the upload</li>
	 * 	<li>assign the file to the `&lt;input&gt;`</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param filePath the file path
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Upload Document on VMP
	public void uploadDocumentOnVMP(RemoteWebDriver driver, String filePath) throws InterruptedException, IOException
	{
		
		ExtentTest test = ExtentTestManager.getTest();
		
		System.out.println("Uploading a document");
	
		// disable the click event on an `<input>` file
		((JavascriptExecutor)driver).executeScript(
		    "HTMLInputElement.prototype.click = function() {                     " +
		    "  if(this.type !== 'file') HTMLElement.prototype.click.call(this);  " +
		    "};                                                                  " );
	
		// trigger the upload
		perform.click(driver, VMPConfirmOrder.uploadDocuments_btn(driver));
	
		// assign the file to the `<input>`
		perform.type(driver, driver.findElement(By.cssSelector("input[type=file]")), filePath);
		
		// Wait for Upload complete button
		perform.waitForElementToBeVisible(driver, VMPConfirmOrder.uploadComplete_btn(), "id");
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Uploaded document: " + filePath);
		
	} // end uploadDocumentOnVMP
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click Finished</li>
	 * 	<li>Switch back to the attach documents frame</li>
	 * 	<li>Click the OK button in the Order Placed dialog</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */	
	// Finish VMP order
	public void finishVMPOrder(RemoteWebDriver driver) throws InterruptedException, IOException
	{
		
		ExtentTest test = ExtentTestManager.getTest();
		
		System.out.println("Finish the VMP order");
	
		// Wait for Finished to be clickable
		perform.waitForElementToBeClickable(driver, VMPConfirmOrder.finished_btn(), "id");
		
		// Click Finished
		perform.click(driver, VMPConfirmOrder.finished_btn(driver));
		
		// Switch back to the attach documents frame
		driver.switchTo().defaultContent();
		
		// Wait for the OK button in the Order Placed dialog
		perform.waitForElementToBeClickable(driver, VMPConfirmOrder.ok_btn(), "cssSelector");
		
		// Click the OK button in the Order Placed dialog
		perform.click(driver, VMPConfirmOrder.ok_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Wait for the Find textbox
		perform.waitForElementToBeClickable(driver, VMPOrders.find_txtbx(), "id");
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Finished the VMP order");
		
	} // end finishVMPOrder
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Place a new order, make sure to attach documents to the order BEFORE finishing it</li>
	 * 	<li>Go to New Order</li>
	 * 	<li>Enter order details</li>
	 * 	<li>Click Next</li>
	 * 	<li>Save the order</li>
	 * 	<li>Click Finished</li>
	 * 	<li>Click OK</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ClassNotFoundException the ClassNotFoundExceptionthe class not found exception
	 * @throws SQLException the SQLExceptionthe SQL exception
	 */
	public void createVMPOrder(RemoteWebDriver driver) throws InterruptedException, IOException, ClassNotFoundException, SQLException {
		
		ExtentTest test = ExtentTestManager.getTest();
		
		// Place a new order, make sure to attach documents to the order BEFORE finishing it
		// Go to New Order
		goToNewOrder(driver);
		
		// Enter order details
		enterNewOrder(driver);
		
		// Click Next
		perform.click(driver, VMPNewOrder.nextBottom_btn(driver));
		
		// Save the order
		saveNewOrder(driver);
		
		// Click Finished
		perform.click(driver, VMPConfirmOrder.finished_btn(driver));
		
		// Switch out of iFrame
		driver.switchTo().defaultContent();
		
		// Click OK
		perform.click(driver, VMPConfirmOrder.ok_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Wait for Find textbox
		perform.waitForElementToBeClickable(driver, VMPOrders.find_txtbx(), "id");
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Created a new VMP order");
		
	} // end createVMPOrder
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click Sign Up</li>
	 * 	<li>Enter Company Name</li>
	 * 	<li>Enter First Name</li>
	 * 	<li>Enter Last Name</li>
	 * 	<li>Enter Address</li>
	 * 	<li>Enter City</li>
	 * 	<li>Select State</li>
	 * 	<li>Enter Zip</li>
	 * 	<li>Select Account Type</li>
	 * 	<li>Enter Phone</li>
	 * 	<li>Select Time Zone</li>
	 * 	<li>Enter Email</li>
	 * 	<li>Enter Username</li>
	 * 	<li>Enter Password</li>
	 * 	<li>Enter Confirm Password</li>
	 * 	<li>Click Next</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param env the env
	 * @param newUserName the new user name
	 * @param password the password
	 * @param accountNumber the account number
	 * @throws InterruptedException the interrupted exception
	 */
	public void createVMPUser(RemoteWebDriver driver, String env, String newUserName, String password, String accountNumber) throws InterruptedException {
		
		String phonePrefix = "";
		if (env.equals("QA"))
		{
			phonePrefix = "111";
		}
		if (env.equals("Beta"))
		{
			phonePrefix = "222";
		}
		if (env.equals("Live"))
		{
			phonePrefix = "333";
		}
		
		// Wait for email field
		perform.waitForElementToBeClickable(driver, VMPLogin.email_txtbx(), "id");
		
		// Click Sign Up
		perform.click(driver, VMPLogin.signUp_btn(driver));
		
		// Wait for Company Name
		perform.waitForElementToBeClickable(driver, VMPSignUp.companyName_txtbx(), "id");
		
		// Enter Company Name
		perform.type(driver, VMPSignUp.companyName_txtbx(driver), "Automation" + env + newUserName);
		
		// Enter First Name
		perform.type(driver, VMPSignUp.firstName_txtbx(driver), "Automation");
		
		// Enter Last Name
		perform.type(driver, VMPSignUp.lastName_txtbx(driver), newUserName);
		
		// Enter Address
		perform.type(driver, VMPSignUp.address_txtbx(driver), "123 Test St.");
		
		// Enter City
		perform.type(driver, VMPSignUp.city_txtbx(driver), "Yukon");
		
		// Select State
		perform.selectDropdownOption(driver, VMPSignUp.state_dropdown(driver), "Oklahoma");
		
		// Enter Zip
		perform.type(driver, VMPSignUp.zip_txtbx(driver), "73099");
		
		// Select Account Type
		perform.selectDropdownOption(driver, VMPSignUp.accountType_dropdown(driver), "Lender");
		
		// Enter Phone
		perform.type(driver, VMPSignUp.phone_txtbx(driver), "501" + phonePrefix + accountNumber);
		
		// Select Time Zone
		perform.selectDropdownOption(driver, VMPSignUp.timeZone_dropdown(driver), "Central");
		
		// Enter Email
		perform.type(driver, VMPSignUp.email_txtbx(driver), "automation" + StoredVariables.getcatchAllDomain().get());
		
		// Enter Username
		perform.type(driver, VMPSignUp.username_txtbx(driver), "automation" + env + newUserName);
		
		// Enter Password
		perform.type(driver, VMPSignUp.password_txtbx(driver), password);
		
		// Enter Confirm Password
		perform.type(driver, VMPSignUp.confirmPassword_txtbx(driver), password);
		
		// Click Next
		perform.click(driver, VMPSignUp.next_btn(driver));
		
		// Wait for Orders button
		perform.waitForElementToBeClickable(driver, VMPOrders.orders_btn(), "cssSelector");
		
	} // end createVMPUser
	
	/**
	 * Verify history text in VMP
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
		String screenText = VMPOrderDetails.history_txt(driver).getText();
		
		// Verify the history/audit trail contains text
		perform.verifyTextContains(driver, screenText, expected);
		
	} // end verifyHistoryText
	
	/**
	 * Verify history text in VMP does not contain
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
		String screenText = VMPOrderDetails.history_txt(driver).getText();
		
		// Verify the history/audit trail contains text
		perform.verifyTextDoesNotContain(driver, screenText, expected);
		
	} // end verifyHistoryTextDoesNotContain
	
} // end Do class
