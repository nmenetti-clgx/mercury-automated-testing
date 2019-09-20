package regressionVMP;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import setup.DriverFactory;
import setup.TestSetup;
import utils.Retry;
import utils.StoredVariables;

/**
 * <h1>VMP - Show Vendor Status Source</h1>
 * 
 * <p>Confirm the status event shows by Appraiser and does not include the appraiser's name
 *
 * @author  Dustin Norman
 * @since   03-11-2019
 */

@Listeners(utils.Listener.class)
@Test(singleThreaded=true)
public class ShowVendorStatusSource extends TestSetup {
	
	/** The user appraiser. */
	private final String userAppraiser = "SVSSAppraiser1";
	
	/** The user AMC. */
	private final String userAMC = "SVSSAMC1";
	
	/** The user secure. */
	private final String userSecure = "SVSS2";
	
	/** The user VMP. */
	private final String userVMP = "OriginatorSVSS2";
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 *  <li>Login to Secure</li>
	 * 	<li>Enable all sync options</li>
	 * 	<li>From VMP Client Portal, place an order through the API</li>
	 * 	<li>Log in to vendors and accept the order</li>
	 * 	<li>Send a message as the vendor</li>
	 * 	<li>View the order details in VMP Client Portal</li>
	 * 	<li>Confirm the status event shows by Appraiser and does not include the appraiser's name</li>
	 *  <li>Log test</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - VMP XSite Settings", "VMP - Create Order Via API", "Vendors - Orders", "Vendors - Accept Order", "Vendors - Send Message", "VMP - Orders"}, alwaysRun=true)
	public void appraiserShowVendorStatusSource() throws Exception{

		// Create the driver for the test
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Set the password
		String password = StoredVariables.getpassword().get();
		
		// Login
		secure.login(driver, userSecure, password);
		
		// Enable all sync options
		secure.enableAllSyncOptionsSettings(driver, userSecure);
		
		// From VMP Client Portal, place an order
		perform.apiPlaceOrderFromVMPClientPortal(driver, userVMP, password, userSecure, "PlaceAppraisalOrderExLenderNoGroups-ShowVendorStatusSource");
		String trackingNumber = StoredVariables.gettrackingNumber().get();
		String trackingNumberVMP = StoredVariables.gettrackingNumberVMP().get();
		String loanID = StoredVariables.getloanID().get();
		
		// Add order info to Extent Report
		perform.addInfoToExtentReport(driver, "Order Info", "Address: " + StoredVariables.getpropertyInformationAddress().get() + 
				"<br>Order Number: " + trackingNumber +
				"<br>VMP Order Number: " + trackingNumberVMP +
				"<br>LoanID: " + loanID);
		
		// Assign the order to the vendor
		secure.loginAndAssignOrderToAppraiser(driver, userSecure, password, loanID, userAppraiser);
		
		// Login and Accept the order 
		vendors.loginAndAcceptOrder(driver, userAppraiser, password, trackingNumberVMP);
		
		// Send a message as the vendor
		vendors.sendMessage(driver, "Test message Appraiser notes");
		
		// View the order details in VMP Client Portal
		vmp.loginAndOpenOrderByTrackingNumber(driver, userSecure, userVMP, password, trackingNumberVMP);

		// Get history text
		String[] notExpected = {userAppraiser};
		vmp.verifyHistoryTextDoesNotContain(driver, notExpected);
		String[] expected = {"Message by Appraiser"};
		vmp.verifyHistoryTextContains(driver, expected);
		
		// Log test
		perform.addInfoToExtentReport(driver, "Regression VMP", "Verified that a message from the vendor does not show the vendors name when the ShowVendorStatusSource bit is enabled for an Appraiser");
		
	} // end appraiserShowVendorStatusSource
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 *  <li>Login to Secure</li>
	 * 	<li>Enable all sync options</li>
	 * 	<li>From VMP Client Portal, place an order through the API</li>
	 *  <li>Login to Secure</li>
	 * 	<li>Assign the order to an AMC</li>
	 * 	<li>Log in to vendors</li>
	 * 	<li>Open the order</li>
	 * 	<li>Send a message as the vendor</li>
	 * 	<li>Log in to VMP</li>
	 * 	<li>Open the order</li>
	 * 	<li>Confirm the status event shows by Appraiser and does not include the appraiser's name</li>
	 *  <li>Login to Secure</li>
	 * 	<li>Open the order</li>
	 * 	<li>Confirm the message events in Secure Mercury Network do not change when ShowVendorStatusSource is enabled</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - VMP XSite Settings", "VMP - Create Order Via API", "Secure - Assign Order To AMC", "Vendors - Orders", "Vendors - Send Message"}, alwaysRun=true)
	public void amcShowVendorStatusSource() throws Exception{
		
		// Create the driver for the test
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Set the password
		String password = StoredVariables.getpassword().get();
		
		// Login to Secure
		secure.login(driver, userSecure, password);
		
		// Enable all sync options
		secure.enableAllSyncOptionsSettings(driver, userSecure);
		
		// From VMP Client Portal, place an order
		perform.apiPlaceOrderFromVMPClientPortal(driver, userVMP, password, userSecure, "PlaceAppraisalOrderExLenderNoGroups-ShowVendorStatusSource");
		String trackingNumber = StoredVariables.gettrackingNumber().get();
		String trackingNumberVMP = StoredVariables.gettrackingNumberVMP().get();
		String loanID = StoredVariables.getloanID().get();
		
		// Add order info to Extent Report
		perform.addInfoToExtentReport(driver, "Order Info", "Address: " + StoredVariables.getpropertyInformationAddress().get() + 
				"<br>Order Number: " + trackingNumber +
				"<br>VMP Order Number: " + trackingNumberVMP +
				"<br>LoanID: " + loanID);
		
		// Login to Secure and assign the order to an AMC
		secure.loginAndAssignOrderToAMC(driver, userSecure, password, loanID, userAMC);
		
		// Login to Vendors and open the order
		vendors.loginAndOpenOrderByTrackingNumber(driver, userAMC, password, trackingNumber);
		
		// Send a message as the vendor
		vendors.sendMessage(driver, "Test message AMC notes");
		
		// View the order details in VMP Client Portal 
		vmp.loginAndOpenOrderByTrackingNumber(driver, userSecure, userVMP, password, trackingNumberVMP);
		
		// Verify the history text in VMP
		String[] notExpected = {userAMC};
		vmp.verifyHistoryTextDoesNotContain(driver, notExpected);
		String[] expected2 = {"Message by Automation SVSS2"};
		vmp.verifyHistoryTextContains(driver, expected2);
		
		// View the order details in Secure as the Lender
		secure.loginAndOpenOrderByTrackingNumber(driver, userSecure, password, trackingNumber);
		
		// Confirm the message events in Secure Mercury Network do not change when ShowVendorStatusSource is enabled
		String[] expected = {
				"Message from AMC (Automation"+StoredVariables.getusernameEnvironment().get()+"SVSSAMC1)",
				"Test message AMC notes",
				"Order accepted by AMC (Automation"+StoredVariables.getusernameEnvironment().get()+"SVSSAMC1) and In Progress",
				"Order automatically accepted",
				"Awaiting acceptance by Automation"+StoredVariables.getusernameEnvironment().get()+"SVSSAMC1",
				"Reassigned by Client (Automation SVSS2) to Automation"+StoredVariables.getusernameEnvironment().get()+"SVSSAMC1",
				"Vendor type changed by Client (Automation SVSS2)"
		};
		secure.verifyHistoryTextContains(driver, expected);
		
		// Log test
		perform.addInfoToExtentReport(driver, "Regression VMP", "Verified that a message from the AMC does not show the AMC's name when the ShowVendorStatusSource bit is enabled for an Appraiser");
		
	} // end amcShowVendorStatusSource
	
} // end the ShowVendorStatusSource class
