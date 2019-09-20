package matrixRoundTrip;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjects.Overlay.Overlay;
import pageObjects.Secure.SConfirmOrder;
import pageObjects.Secure.SNewOrder;
import pageObjects.Secure.SOrderDetails;
import pageObjects.Secure.SOrders;
import pageObjects.Secure.SPreferences;
import pageObjects.Secure.SUsers;
import pageObjects.Secure.SVendorAssignment;
import pageObjects.Secure.SVendorProfile;
import pageObjects.Secure.SVendorSelection;
import pageObjects.Secure.SVendorSelectionSettings;
import pageObjects.VMP.VMPConfirmOrder;
import pageObjects.VMP.VMPNewOrder;
import pageObjects.VMP.VMPOrders;
import pageObjects.Vendors.VOrderAcknowledgement;
import pageObjects.Vendors.VOrderDetails;
import pageObjects.Vendors.VOrders;
import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Round Trip - Order Ownership</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class OrderOwnership extends TestSetup {
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Sign in to Secure</li>
	 * 	<li>Click to Preferences</li>
	 * 	<li>Select Vendor Selection Settings</li>
	 * 	<li>Turn off Double-blind Communication switch</li>
	 * 	<li>Enable Automatic Vendor Selection</li>
	 * 	<li>Select Custom Fee Panel</li>
	 * 	<li>Uncheck Use Mercury Network Directory as backup checkbox</li>
	 * 	<li>Verify Mercury Network Directory as backup is unchecked</li>
	 * 	<li>Save Preferences</li>
	 * 	<li>Click OK in saved dialog box</li>
	 * 	<li>Clear order information variables before placing a new order</li>
	 * 	<li>Click Users</li>
	 * 	<li>Verify Auto Assignment Approval is not checked</li>
	 * 	<li>Click Save</li>
	 * 	<li>Go to the Orders page</li>
	 * 	<li>Go to Residential Appraisal</li>
	 * 	<li>Set Property Information data</li>
	 * 	<li>StoredVariables.getpropertyInformationStateAbbr().set("OK");  Must set for a field check later on</li>
	 * 	<li>Set Assignment Information data</li>
	 * 	<li>Set Lender Information data</li>
	 * 	<li>Set Contact And Access Information data</li>
	 * 	<li>Set Additional Notification Recipients data</li>
	 * 	<li>Enter New Order data</li>
	 * 	<li>Click Next</li>
	 * 	<li>Confirm order screen loads</li>
	 * 	<li>Verify Vendor Information is correct</li>
	 * 	<li>Clear order information variables before placing a new order</li>
	 * 	<li>Click Users</li>
	 * 	<li>Verify Auto Assignment Approval is checked</li>
	 * 	<li>Click Save</li>
	 * 	<li>Go to the Orders page</li>
	 * 	<li>Click New</li>
	 * 	<li>Click Residential Appraisal</li>
	 * 	<li>Set Property Information data</li>
	 * 	<li>StoredVariables.getpropertyInformationStateAbbr().set("OK");  Must set for a field check later on</li>
	 * 	<li>Set Assignment Information data</li>
	 * 	<li>Set Lender Information data</li>
	 * 	<li>Set Contact And Access Information data</li>
	 * 	<li>Set Additional Notification Recipients data</li>
	 * 	<li>Enter New Order data</li>
	 * 	<li>Click Next</li>
	 * 	<li>Get inside the vendor assignment frame</li>
	 * 	<li>Verify vendor selected text</li>
	 * 	<li>Get vendor customer number</li>
	 * 	<li>Get vendor information</li>
	 * 	<li>Verify vendor name</li>
	 * 	<li>Verify vendor company</li>
	 * 	<li>Verify vendor address</li>
	 * 	<li>Verify vendor city, state, zip</li>
	 * 	<li>Verify vendor phone</li>
	 * 	<li>Verify vendor email</li>
	 * 	<li>View the vendor profile</li>
	 * 	<li>Verify vendor name text on profile page</li>
	 * 	<li>Verify vendor company text on profile page</li>
	 * 	<li>Verify vendor address text on profile page</li>
	 * 	<li>Verify vendor phone text on profile page</li>
	 * 	<li>Verify vendor email text on profile page</li>
	 * 	<li>Click Remove this vendor from your custom fee panel</li>
	 * 	<li>Verify Remove vendor text</li>
	 * 	<li>Click alert OK button</li>
	 * 	<li>Click Add this vendor to your custom fee panel</li>
	 * 	<li>Verify Add vendor text</li>
	 * 	<li>Click alert OK button</li>
	 * 	<li>Click Cancel</li>
	 * 	<li>Get inside the attach document frame</li>
	 * 	<li>Click Decline</li>
	 * 	<li>Verify Notes required text</li>
	 * 	<li>Click Notes Required Ok button</li>
	 * 	<li>Enter notes</li>
	 * 	<li>Click Decline</li>
	 * 	<li>Get vendor customer number</li>
	 * 	<li>Get vendor information</li>
	 * 	<li>Verify vendor is different from the original selection</li>
	 * 	<li>Verify vendor name</li>
	 * 	<li>Verify vendor company</li>
	 * 	<li>Verify vendor address</li>
	 * 	<li>Verify vendor city, state, zip</li>
	 * 	<li>Verify vendor phone</li>
	 * 	<li>Verify vendor email</li>
	 * 	<li>Click Approve</li>
	 * 	<li>Get outside frames</li>
	 * 	<li>Confirm order screen loads</li>
	 * 	<li>Verify vendor Name is displayed</li>
	 * 	<li>Verify vendor Company is displayed</li>
	 * 	<li>Verify vendor Address is displayed</li>
	 * 	<li>Verify vendor Phone is displayed</li>
	 * 	<li>Verify vendor Email is displayed</li>
	 * 	<li>Check read and understand fee notes checkbox</li>
	 * 	<li>Click Next</li>
	 * 	<li>Get outside frames</li>
	 * 	<li>Get inside the attach document frame</li>
	 * 	<li>Go back</li>
	 * 	<li>Click Next</li>
	 * 	<li>Get inside the attach document frame</li>
	 * 	<li>Click Next</li>
	 * 	<li>Get inside the attach document frame</li>
	 * 	<li>Go back</li>
	 * 	<li>Click the Close button</li>
	 * 	<li>Get outside frames</li>
	 * 	<li>Verify you land on the orders grid</li>
	 * 	<li>Query the db to get the order number that was just created</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify the order just created is in the orders grid</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify the order is in the Awaiting Acceptance status</li>
	 * 	<li>Verify it is assigned to the correct vendor</li>
	 * 	<li>Verify the decline event is in the history</li>
	 * 	<li>Verify the declined notes are in the history</li>
	 * 	<li>Verify the approved event is in the history</li>
	 * 	<li>Login as vendor and verify order exists</li>
	 * 	<li>Find order</li>
	 * 	<li>Click on the order from the orders grid</li>
	 * 	<li>Verify awaiting acceptance is displayed</li>
	 * 	<li>If browser is IE, set nativeEvents capability to false</li>
	 * 	<li>perform.IE_setNativeEventsToFalse();</li>
	 * 	<li>Sign in to Secure</li>
	 * 	<li>Click to Preferences</li>
	 * 	<li>Select Vendor Selection Settings</li>
	 * 	<li>Turn off Double-blind Communication switch</li>
	 * 	<li>Disable Automatic Vendor Selection</li>
	 * 	<li>Select Custom Fee Panel</li>
	 * 	<li>Uncheck Use Mercury Network Directory as backup checkbox</li>
	 * 	<li>Verify Mercury Network Directory as backup is unchecked</li>
	 * 	<li>Save Preferences</li>
	 * 	<li>Click OK in saved dialog box</li>
	 * 	<li>Clear order information variables before placing a new order</li>
	 * 	<li>Go to Residential Appraisal</li>
	 * 	<li>Set Property Information data</li>
	 * 	<li>StoredVariables.getpropertyInformationStateAbbr().set("OK");  Must set for a field check later on</li>
	 * 	<li>Set Assignment Information data</li>
	 * 	<li>Set Lender Information data</li>
	 * 	<li>Set Contact And Access Information data</li>
	 * 	<li>Set Additional Notification Recipients data</li>
	 * 	<li>Enter New Order data</li>
	 * 	<li>Click Next</li>
	 * 	<li>Click Close on Related Orders popup</li>
	 * 	<li>Verify url contains VendorSelect</li>
	 * 	<li>Click the Vendor name header button</li>
	 * 	<li>Verify sort arrow button displays</li>
	 * 	<li>Click the Search tab</li>
	 * 	<li>Enter first name</li>
	 * 	<li>Enter last name</li>
	 * 	<li>City</li>
	 * 	<li>Click Search</li>
	 * 	<li>Click off error message if exists</li>
	 * 	<li>Click OK</li>
	 * 	<li>Verify the correct vendor was found</li>
	 * 	<li>Click Back</li>
	 * 	<li>Click Next</li>
	 * 	<li>Assign vendor</li>
	 * 	<li>Verify Confirm Order url</li>
	 * 	<li>Agree to the fee notes</li>
	 * 	<li>Click Next</li>
	 * 	<li>Get outside frames</li>
	 * 	<li>Get inside the attach document frame</li>
	 * 	<li>Click Close</li>
	 * 	<li>Get outside frames</li>
	 * 	<li>Verify you land on the orders grid</li>
	 * 	<li>Set 40 second while loop timeout</li>
	 * 	<li>Query the db to get the order number that was just created</li>
	 * 	<li>Verify Due date is ordered properly to display the most recent order first</li>
	 * 	<li>Verify the order just created is in the orders grid</li>
	 * 	<li>Clear order information variables before placing a new order</li>
	 * 	<li>Go to the Orders page</li>
	 * 	<li>Click New</li>
	 * 	<li>Click Residential Appraisal</li>
	 * 	<li>Set Property Information data</li>
	 * 	<li>StoredVariables.getpropertyInformationStateAbbr().set("OK");  Must set for a field check later on</li>
	 * 	<li>Set Assignment Information data</li>
	 * 	<li>Set Lender Information data</li>
	 * 	<li>Set Contact And Access Information data</li>
	 * 	<li>Set Additional Notification Recipients data</li>
	 * 	<li>Enter New Order data</li>
	 * 	<li>Click Next</li>
	 * 	<li>Click Close on Related Orders popup</li>
	 * 	<li>Verify url contains VendorSelect</li>
	 * 	<li>Verify Fee Panel tab is selected</li>
	 * 	<li>Click Appraiser1</li>
	 * 	<li>Click Next</li>
	 * 	<li>Verify Confirm Order url</li>
	 * 	<li>Agree to the fee notes</li>
	 * 	<li>Click Next</li>
	 * 	<li>Get outside frames</li>
	 * 	<li>Get inside the attach document frame</li>
	 * 	<li>Click Close</li>
	 * 	<li>Get outside frames</li>
	 * 	<li>Verify you land on the orders grid</li>
	 * 	<li>Set 40 second while loop timeout</li>
	 * 	<li>Query the db to get the order number that was just created</li>
	 * 	<li>Get VendorID</li>
	 * 	<li>Get ParentEntityID</li>
	 * 	<li>Verify in the db that the order placed to a vendor sub user</li>
	 * 	<li>Clear order information variables before placing a new order</li>
	 * 	<li>Go to the Orders page</li>
	 * 	<li>Click New</li>
	 * 	<li>Click Residential Appraisal</li>
	 * 	<li>Set Property Information data</li>
	 * 	<li>StoredVariables.getpropertyInformationStateAbbr().set("OK");  Must set for a field check later on</li>
	 * 	<li>Set Assignment Information data</li>
	 * 	<li>Set Lender Information data</li>
	 * 	<li>Set Contact And Access Information data</li>
	 * 	<li>Set Additional Notification Recipients data</li>
	 * 	<li>Enter New Order data</li>
	 * 	<li>Click Next</li>
	 * 	<li>Click Close on Related Orders popup</li>
	 * 	<li>Verify url contains VendorSelect</li>
	 * 	<li>Verify Fee Panel tab is selected</li>
	 * 	<li>Check for related orders dialog</li>
	 * 	<li>Click Appraiser1</li>
	 * 	<li>Click Next</li>
	 * 	<li>Verify Confirm Order url</li>
	 * 	<li>Agree to the fee notes</li>
	 * 	<li>Click Next</li>
	 * 	<li>Get outside frames</li>
	 * 	<li>Get inside the attach document frame</li>
	 * 	<li>Click Close</li>
	 * 	<li>Get outside frames</li>
	 * 	<li>Verify you land on the orders grid</li>
	 * 	<li>Set 40 second while loop timeout</li>
	 * 	<li>Query the db to get the order number that was just created</li>
	 * 	<li>Get VendorID</li>
	 * 	<li>Get ParentEntityID</li>
	 * 	<li>Verify in the db that the order placed to a vendor sub user</li>
	 * 	<li>Log in to Secure as VMP</li>
	 * 	<li>Click to Preferences</li>
	 * 	<li>Select Vendor Selection Settings</li>
	 * 	<li>Turn off Double-blind Communication switch</li>
	 * 	<li>Enable Unattended Order Assignment Selection</li>
	 * 	<li>Click switch On</li>
	 * 	<li>Enable Unattended Order Reassignment</li>
	 * 	<li>Select Custom Fee Panel</li>
	 * 	<li>Uncheck Use Mercury Network Directory as backup checkbox</li>
	 * 	<li>Verify Mercury Network Directory as backup is unchecked</li>
	 * 	<li>Save Preferences</li>
	 * 	<li>Click OK in saved dialog box</li>
	 * 	<li>Click Users</li>
	 * 	<li>Verify Auto Assignment Approval is not checked</li>
	 * 	<li>Click Save</li>
	 * 	<li>Clear order information variables before placing a new order</li>
	 * 	<li>Login to VMP Client Portal</li>
	 * 	<li>Click New Order</li>
	 * 	<li>Set Property Information data</li>
	 * 	<li>StoredVariables.getpropertyInformationStateAbbr().set("OK");  Must set for a field check later on</li>
	 * 	<li>Set Assignment Information data</li>
	 * 	<li>Set Lender Information data</li>
	 * 	<li>Set Contact And Access Information data</li>
	 * 	<li>Set Additional Notification Recipients data</li>
	 * 	<li>Set Assigned person and pass it to StoredVariables</li>
	 * 	<li>Enter New Order data</li>
	 * 	<li>Click Next</li>
	 * 	<li>Select document type</li>
	 * 	<li>Click Finished Button</li>
	 * 	<li>Switch back to the attach documents frame</li>
	 * 	<li>Click the OK button in the Order Placed dialog</li>
	 * 	<li>Verify you land on the orders grid</li>
	 * 	<li>Query the db to get the order number that was just created</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify the order details</li>
	 * 	<li>Get vendor name</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Get vendor info text</li>
	 * 	<li>Verify vendor info</li>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify order status</li>
	 * 	<li>Click on the order from the orders grid</li>
	 * 	<li>Get order information text</li>
	 * 	<li>Verify audit trail</li>
	 * 	<li>View Order Details</li>
	 * 	<li>Click on the Accept/Decline button</li>
	 * 	<li>Allow popup time to load</li>
	 * 	<li>Select Propose Conditions to Client from Select Action dropdown</li>
	 * 	<li>Add Notes</li>
	 * 	<li>Click OK</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify the order details</li>
	 * 	<li>Get vendor information</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Get vendor info text</li>
	 * 	<li>Verify vendor info</li>
	 * 	<li>Clear order information variables before placing a new order</li>
	 * 	<li>Login to VMP Client Portal</li>
	 * 	<li>Click New Order</li>
	 * 	<li>Set Property Information data</li>
	 * 	<li>StoredVariables.getpropertyInformationStateAbbr().set("OK");  Must set for a field check later on</li>
	 * 	<li>Set Assignment Information data</li>
	 * 	<li>Set Lender Information data</li>
	 * 	<li>Set Contact And Access Information data</li>
	 * 	<li>Set Additional Notification Recipients data</li>
	 * 	<li>Set Assigned person and pass it to StoredVariables</li>
	 * 	<li>Enter New Order data</li>
	 * 	<li>Click Next</li>
	 * 	<li>Select document type</li>
	 * 	<li>Click Finished Button</li>
	 * 	<li>Switch back to the attach documents frame</li>
	 * 	<li>Click the OK button in the Order Placed dialog</li>
	 * 	<li>Verify you land on the orders grid</li>
	 * 	<li>Query the db to get the order number that was just created</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify the order details</li>
	 * 	<li>Get vendor name</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Get vendor info text</li>
	 * 	<li>Verify vendor info</li>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify order status</li>
	 * 	<li>Click on the order from the orders grid</li>
	 * 	<li>Get order information text</li>
	 * 	<li>Verify audit trail</li>
	 * 	<li>View Order Details</li>
	 * 	<li>Click on the Accept/Decline button</li>
	 * 	<li>Allow popup time to load</li>
	 * 	<li>Select Propose Conditions to Client from Select Action dropdown</li>
	 * 	<li>Add Notes</li>
	 * 	<li>Click OK</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify the order details</li>
	 * 	<li>Get vendor information</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Get vendor info text</li>
	 * 	<li>Verify vendor info</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Vendor Selection Settings", "Secure - Create Order", "Secure - Users", "Secure - Vendor Profile", "Secure - Orders", "VMP - Create Order", "Vendors - Decline Order", "Vendors - Orders"}, alwaysRun=true)
	public void vendorSelectionSettings() throws Exception {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		if (StoredVariables.getbrowser().get().equals("PhantomJS"))
		{
			String callersClass = new Exception().getStackTrace()[0].getClassName();
			test.log(LogStatus.SKIP, "The " + callersClass + " class was skipped becuase the " + StoredVariables.getbrowser().get() + " browser causes Eclipse to hang when handling the iFrames");
			throw new SkipException("The " + callersClass + " class was skipped becuase the " + StoredVariables.getbrowser().get() + " browser causes Eclipse to hang when handling the iFrames");
		} // end if PhantomJS
		
		// Sign in to Secure
		secure.login(driver, "Lender3", StoredVariables.getpassword().get());
		
		// Wait for the Preferences button to be visible
		perform.waitForElementToBeClickable(driver, SOrders.preferences_btn(driver));
		
		// Click to Preferences
		perform.click(driver,SOrders.preferences_btn(driver));
		
		// Wait for Vendor Selection Settings
		perform.waitForElementToBeClickable(driver, SPreferences.vendorSelectionSettings_btn(driver));
		
		// Select Vendor Selection Settings
		perform.click(driver,SPreferences.vendorSelectionSettings_btn(driver));
		
		// Turn off Double-blind Communication switch
		if (!SVendorSelectionSettings.doubleBlind_switch(driver).getAttribute("src").contains("switchOff.png"))
		{
			perform.click(driver,SVendorSelectionSettings.doubleBlind_switch(driver));
		}
		
		// Enable Automatic Vendor Selection
		if (!SVendorSelectionSettings.automaticOrderAssignment_switch(driver).getAttribute("src").contains("switchOn.png"))
		{
			perform.click(driver,SVendorSelectionSettings.automaticOrderAssignment_switch(driver));
		}
		
		// Select Custom Fee Panel
		perform.click(driver,SVendorSelectionSettings.customFeePanel_radio(driver));
		
		// Uncheck Use Mercury Network Directory as backup checkbox
		if (SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver).isSelected())
		{
			perform.click(driver,SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver));
		}
		
		// Verify Mercury Network Directory as backup is unchecked
		Assert.assertTrue(SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver).isSelected()==false, "Mercury Network Directory as backup is still checked");
		
		// Save Preferences
		perform.click(driver,SVendorSelectionSettings.save_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for the OK button to be visible
		perform.waitForElementToBeClickable(driver, SVendorSelectionSettings.ok_btn(driver));
		
		// Click OK in saved dialog box
		perform.click(driver,SVendorSelectionSettings.ok_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);

		// Clear order information variables before placing a new order
		perform.clearOrderInfoStoredVariables(driver);
		
		// Click Users
		perform.click(driver,SOrders.users_btn(driver));
		
		// Verify Auto Assignment Approval is not checked
		if (SUsers.autoAssignmentApproval_chkbx(driver).isSelected())
		{
			perform.click(driver,SUsers.autoAssignmentApproval_chkbx(driver));
		}
		
		// Click Save
		perform.click(driver,SUsers.save_btn(driver));
		
		Thread.sleep(1000);
		
		// Go to the Orders page
		perform.clickInTable_Contains(driver, "Orders");
		
		if (StoredVariables.getbrowser().get().equals("Chrome"))
		{
			Thread.sleep(500);	
		}
		
		// Go to Residential Appraisal
		secure.goToResidentialAppraisal(driver);
		
		/***************************************
		 * Set New Order Information
		 ***************************************/
		
		// Set Property Information data
		StoredVariables.getpropertyInformationAddress().set("2621 SW 136th St");
		StoredVariables.getpropertyInformationCity().set("Oklahoma City");
		StoredVariables.getpropertyInformationState().set("Oklahoma");
		StoredVariables.getpropertyInformationStateAbbr().set("OK"); // Must set for a field check later on
		StoredVariables.getpropertyInformationZip().set("73170");
		StoredVariables.getpropertyInformationSqFt().set("5,688");
		StoredVariables.getpropertyInformationSiteSize().set("9,583 sq ft");
		StoredVariables.getpropertyInformationPropType().set("Single Family");
		StoredVariables.getpropertyInformationPropRights().set("Fee Simple");
		StoredVariables.getpropertyInformationLegalDesc().set("245 W Chantilly Way, Mustang, OK 73064");
		StoredVariables.getpropertyInformationDirections().set("East of N May Ave and south of NW Britton Rd");
		
		// Set Assignment Information data
		StoredVariables.getassignmentInformationForm().set("Uniform Residential Appraisal (FNMA 1004)");
		StoredVariables.getassignmentInformationRushOrder().set(true);
		StoredVariables.getassignmentInformationComplex().set(true);
		StoredVariables.getassignmentInformationOrderDue().set(7);
		perform.getNewDate(driver, StoredVariables.getassignmentInformationOrderDue().get());
		StoredVariables.getassignmentInformationOtherRefNumber().set("8615406");
		StoredVariables.getassignmentInformationLoanType().set("All In One");
		StoredVariables.getassignmentInformationLoanPurpose().set("Purchase");
		StoredVariables.getassignmentInformationOrderedBy().set("Borrower Name");
		StoredVariables.getassignmentInformationOrderGroup().set("AppraisersGroupTest");
		StoredVariables.getassignmentInformationLoanNumber().set("74108641");
		StoredVariables.getassignmentInformationFileNumber().set("31849");
		StoredVariables.getassignmentInformationSalesPrice().set("645,715");
		StoredVariables.getassignmentInformationFHACaseNumber().set("564193");
		StoredVariables.getassignmentInformationDisclosure().set(0);
		StoredVariables.getassignmentInformationAssignedTo().set("Automation Lender3");
		
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
		secure.enterNewResidentialAppraisalOrder(driver);

		// Click Next
		perform.click(driver,SNewOrder.next_btn(driver));
		
		Thread.sleep(1000);
		
		/***********************************************
		 * Confirm Order Page
		 ***********************************************/

		// Wait for the back button to be visible
		perform.waitForElementToBeClickable(driver, SConfirmOrder.backTop_btn(driver));
		
		// Confirm order screen loads
		Assert.assertTrue(driver.getCurrentUrl().contains("ConfirmOrder"), "Order page did not load");
		
		// Verify Vendor Information is correct
		/***********************************************************************
		 * NEED TO PARSE OUT THE VENDORID FROM THE SOURCE CODE AND LOOK IT UP
		 * IN THE DATABASE TO MATCH THE INFORMATION
		 ***********************************************************************/
		int lineNumber = new Exception().getStackTrace()[0].getLineNumber();
		String thisClass = new Exception().getStackTrace()[0].getClassName();
		String thisMethod = new Exception().getStackTrace()[0].getMethodName();
		System.out.println("Line #" + lineNumber + " - " + thisClass + "." + thisMethod + " ***** Need to parse out the vendorid from the source code and look it up in the db to verify vendor info");
		
		secure.verifyOrderDetails(driver);

		// Clear order information variables before placing a new order
		perform.clearOrderInfoStoredVariables(driver);
		
		// Click Users
		perform.click(driver,SOrders.users_btn(driver));
		
		// Verify Auto Assignment Approval is checked
		if (!SUsers.autoAssignmentApproval_chkbx(driver).isSelected())
		{
			perform.click(driver,SUsers.autoAssignmentApproval_chkbx(driver));
		}
		
		// Click Save
		perform.click(driver,SUsers.save_btn(driver));
		
		// Wait for Orders button
		perform.waitForElementToBeClickable(driver, SOrders.orders_btn(driver));
		
		// Go to the Orders page
		perform.clickInTable_Contains(driver, "Orders");
		
		if (StoredVariables.getbrowser().get().equals("Chrome"))
		{
			Thread.sleep(500);	
		}
		
		// Click New
		perform.clickInTable_Contains(driver, "New");
		
		// Click Residential Appraisal
		perform.click(driver,SOrders.residentialAppraisal_btn(driver));
		
		/***************************************
		 * Set New Order Information
		 ***************************************/
		
		// Set Property Information data
		StoredVariables.getpropertyInformationAddress().set("2621 SW 136th St");
		StoredVariables.getpropertyInformationCity().set("Oklahoma City");
		StoredVariables.getpropertyInformationState().set("Oklahoma");
		StoredVariables.getpropertyInformationStateAbbr().set("OK"); // Must set for a field check later on
		StoredVariables.getpropertyInformationZip().set("73170");
		StoredVariables.getpropertyInformationSqFt().set("2,017");
		StoredVariables.getpropertyInformationSiteSize().set("9,583 sq ft");
		StoredVariables.getpropertyInformationPropType().set("Single Family");
		StoredVariables.getpropertyInformationPropRights().set("Fee Simple");
		StoredVariables.getpropertyInformationLegalDesc().set("717 Vickery Ave, Yukon, OK 73099");
		StoredVariables.getpropertyInformationDirections().set("Mustang Rd and NW 10th St.");
		
		// Set Assignment Information data
		StoredVariables.getassignmentInformationForm().set("Uniform Residential Appraisal (FNMA 1004)");
		StoredVariables.getassignmentInformationRushOrder().set(true);
		StoredVariables.getassignmentInformationComplex().set(true);
		StoredVariables.getassignmentInformationOrderDue().set(7);
		perform.getNewDate(driver, StoredVariables.getassignmentInformationOrderDue().get());
		StoredVariables.getassignmentInformationOtherRefNumber().set("9856321");
		StoredVariables.getassignmentInformationLoanType().set("All In One");
		StoredVariables.getassignmentInformationLoanPurpose().set("Purchase");
		StoredVariables.getassignmentInformationOrderedBy().set("Test User");
		StoredVariables.getassignmentInformationOrderGroup().set("AppraisersGroupTest");
		StoredVariables.getassignmentInformationLoanNumber().set("84131");
		StoredVariables.getassignmentInformationFileNumber().set("56413");
		StoredVariables.getassignmentInformationSalesPrice().set("188,000");
		StoredVariables.getassignmentInformationFHACaseNumber().set("6413");
		StoredVariables.getassignmentInformationDisclosure().set(0);
		StoredVariables.getassignmentInformationAssignedTo().set("Automation Lender3");
		
		// Set Lender Information data
		StoredVariables.getlenderInformationLenderName().set("US Bank");
		StoredVariables.getlenderInformationAddress1().set("123 Test St");
		StoredVariables.getlenderInformationAddress2().set("Suite D");
		StoredVariables.getlenderInformationCity().set("Mustang");
		StoredVariables.getlenderInformationState().set("OK");
		StoredVariables.getlenderInformationZip().set("73064");
		
		// Set Contact And Access Information data
		StoredVariables.getcontactOccupancy().set("Owner");
		StoredVariables.getcontactBorrower().set("Test User");
		StoredVariables.getcontactBorrowerInfo1Dropdown().set("Home");
		StoredVariables.getcontactBorrowerInfo1().set("405-555-1111");
		StoredVariables.getcontactBorrowerInfo2Dropdown().set("E-mail");
		StoredVariables.getcontactBorrowerInfo2().set("test@dntest.net");
		StoredVariables.getcontactBorrowerAddress().set("684 Test St.");
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
		secure.enterNewResidentialAppraisalOrder(driver);

		// Click Next
		perform.click(driver,SNewOrder.next_btn(driver));
		
		// Wait for iFrames
		perform.waitForIFrames(driver);
		
		if (StoredVariables.getbrowser().get().equals("Chrome") || StoredVariables.getbrowser().get().equals("IE"))
		{
			Thread.sleep(5000);
		}
		
		// Get inside the vendor assignment frame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "/Admin/NewOrder/AutoAssignmentApproval.aspx", By.id(SVendorAssignment.vendorProfile_btn()));
		
		Thread.sleep(1000);
		
		// Wait for vendor profile button
		perform.waitForElementToBeClickable(driver, SVendorAssignment.vendorProfile_btn(driver));
		
		// Verify vendor selected text
		Assert.assertTrue(SVendorAssignment.vendorAssignment_txt(driver).getText().contains("This vendor has been automatically selected. Click Approve to assign the order or click Decline to choose a new vendor. If you enter notes, they will be saved to the audit trail, however they will not be delivered to the vendor."), "Vendor selection text is incorrect - " + SVendorAssignment.vendorAssignment_txt(driver).getText());
		
		// Get vendor customer number
		String customerNumber = SVendorAssignment.phone_txt(driver).getText();
		
		// Get vendor information
		String name = SVendorAssignment.name_txt(driver).getText();
		String[] parts = name.split(" ");
		String LastName = parts[1];
		System.out.println("LastName = " + LastName + "    customerNumber = " + customerNumber);
		db.getVendorInformationByLastNameAndCustomerNumber(driver, LastName, customerNumber);
		
		// Verify vendor name
		Assert.assertTrue(SVendorAssignment.name_txt(driver).getText().equals(StoredVariables.getvendorFirstName().get() + " " + StoredVariables.getvendorLastName().get()), "Vendor Name is not displayed correctly - " + SVendorAssignment.name_txt(driver).getText() + ". Should be - " + StoredVariables.getvendorFirstName().get() + " " + StoredVariables.getvendorLastName().get());
		
		// Verify vendor company
		Assert.assertTrue(SVendorAssignment.companyName_txt(driver).getText().equals(StoredVariables.getvendorCompanyName().get()), "Vendor Company Name is not displayed correctly");
		
		// Verify vendor address
		Assert.assertTrue(SVendorAssignment.address_txt(driver).getText().equals(StoredVariables.getvendorAddress1().get()), "Vendor Address is not displayed correctly");
		
		// Verify vendor city, state, zip
		Assert.assertTrue(SVendorAssignment.cityStateZip_txt(driver).getText().equals(StoredVariables.getvendorCity().get() + " " + StoredVariables.getvendorState().get() + ", " + StoredVariables.getvendorZip().get()), "Vendor City, State, Zip is not displayed correctly");
		
		// Verify vendor phone
		Assert.assertTrue(SVendorAssignment.phone_txt(driver).getText().equals(StoredVariables.getvendorPhone().get()), "Vendor Phone is not displayed correctly - " + SVendorAssignment.phone_txt(driver).getText() + ". Should be - " + StoredVariables.getvendorPhone().get());
		
		// Verify vendor email
		Assert.assertTrue(SVendorAssignment.email_txt(driver).getText().equals(StoredVariables.getvendorEmail().get()), "Vendor Email is not displayed correctly");
		
		// View the vendor profile
		secure.viewVendorProfile(driver, SVendorAssignment.vendorProfile_btn(driver), "Automation");
		
		// Verify vendor name text on profile page
		String vendorName = StoredVariables.getvendorFirstName().get() + " " + StoredVariables.getvendorLastName().get();
		Assert.assertTrue(SVendorProfile.vendorProfileName_txt(driver).getText().equals(vendorName), "Vendor name is not displayed properly - " + SVendorProfile.vendorProfileName_txt(driver).getAttribute("value"));
		
		// Verify vendor company text on profile page
		Assert.assertTrue(SVendorProfile.vendorProfileCompanyName_txt(driver).getText().contains(StoredVariables.getvendorCompanyName().get()), "Vendor company is not displayed properly");
		
		// Verify vendor address text on profile page
		String vendorAddress = StoredVariables.getvendorAddress1().get() + "\n" + StoredVariables.getvendorCity().get() + ", " + StoredVariables.getvendorState().get() + " " + StoredVariables.getvendorZip().get();
		Assert.assertTrue(SVendorProfile.vendorProfileAddress_txt(driver).getText().contains(vendorAddress), "Vendor address is not displayed properly - " + SVendorProfile.vendorProfileAddress_txt(driver).getText());
		
		// Verify vendor phone text on profile page
		String vendorPhone = "(" + StoredVariables.getvendorPhone().get().substring(0, 3) + ") " + StoredVariables.getvendorPhone().get().substring(3, 6) + "-" + StoredVariables.getvendorPhone().get().substring(6, 10);
		Assert.assertTrue(SVendorProfile.vendorProfilePhone_txt(driver).getText().equals(vendorPhone), "Vendor phone is not displayed properly");
		
		// Verify vendor email text on profile page
		Assert.assertTrue(SVendorProfile.vendorProfileEmail_txt(driver).getText().equals(StoredVariables.getvendorEmail().get()), "Vendor email is not displayed properly");
		
		System.out.println("remove vendor from fee panel");
		// Click Remove this vendor from your custom fee panel
		perform.click(driver,SVendorProfile.removeThisVendorFromYourCustomFeePanel_lnk(driver));
		
		// Wait for OK button to be clickable
		perform.waitForElementToBeClickable(driver, SVendorProfile.alertOk_btn(driver));
		
		// Verify Remove vendor text
		Assert.assertTrue(SVendorProfile.alert_txt(driver).getText().contains("The vendor was successfully removed from your fee panel."), "Remove Vendor text is incorrect - " + SVendorProfile.alert_txt(driver).getText());
		
		// Click alert OK button
		perform.click(driver,SVendorProfile.alertOk_btn(driver));
		
		// Wait for Add Vendor link
		perform.waitForElementToBeClickable(driver, SVendorProfile.addThisVendorFromYourCustomFeePanel_lnk(driver));
		
		// Click Add this vendor to your custom fee panel
		perform.click(driver,SVendorProfile.addThisVendorFromYourCustomFeePanel_lnk(driver));
		
		// Wait for OK button to be clickable
		perform.waitForElementToBeClickable(driver, SVendorProfile.alertOk_btn(driver));
		
		// Verify Add vendor text
		Assert.assertTrue(SVendorProfile.alert_txt(driver).getText().contains("The vendor was successfully added to your fee panel."), "Add Vendor text is incorrect - " + SVendorProfile.alert_txt(driver).getText());
		
		// Click alert OK button
		perform.click(driver,SVendorProfile.alertOk_btn(driver));
		
		Thread.sleep(5000);
		
		// Wait for Cancel button to be clickable
		perform.waitForElementToBeClickable(driver, SVendorProfile.cancel_btn(driver));
		
		// Click Cancel
		perform.click(driver,SVendorProfile.cancel_btn(driver));
		
		// Get inside the attach document frame
		driver.switchTo().defaultContent();
		perform.waitForiFrameSrcAndSwitchToIt(driver, "/Admin/NewOrder/AutoAssignmentApproval.aspx", By.id(SVendorAssignment.decline_btn()));
		
		// Click Decline
		perform.click(driver,SVendorAssignment.decline_btn(driver));
		
		// Verify Notes required text
		Assert.assertTrue(SVendorAssignment.notesRequired_txt(driver).getText().contains("In order to decline this vendor, please enter notes for your compliance audit trail."), "Notes required text is not correct");
		
		// Click Notes Required Ok button
		perform.click(driver,SVendorAssignment.notesRequiredOk_btn(driver));
		
		// Enter notes
		perform.type(driver,SVendorAssignment.notes_txtbx(driver), "These are test notes for vendor assignment");
		
		// Click Decline
		perform.click(driver,SVendorAssignment.decline_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Get vendor customer number
		String customerNumber2 = SVendorAssignment.phone_txt(driver).getText();
		
		// Get vendor information
		String name2 = SVendorAssignment.name_txt(driver).getText();
		String[] parts2 = name2.split(" ");
		String LastName2 = parts2[1];
		db.getVendorInformationByLastNameAndCustomerNumber(driver, LastName2, customerNumber2);
		
		// Verify vendor is different from the original selection
		Assert.assertTrue(!LastName.equals(LastName2), "Vendor did not change after declining initial vendor");
		
		// Verify vendor name
		Assert.assertTrue(SVendorAssignment.name_txt(driver).getText().equals(StoredVariables.getvendorFirstName().get() + " " + StoredVariables.getvendorLastName().get()), "Vendor Name is not displayed correctly");
		
		// Verify vendor company
		Assert.assertTrue(SVendorAssignment.companyName_txt(driver).getText().equals(StoredVariables.getvendorCompanyName().get()), "Vendor Company Name is not displayed correctly");
		
		// Verify vendor address
		Assert.assertTrue(SVendorAssignment.address_txt(driver).getText().equals(StoredVariables.getvendorAddress1().get()), "Vendor Address is not displayed correctly");
		
		// Verify vendor city, state, zip
		Assert.assertTrue(SVendorAssignment.cityStateZip_txt(driver).getText().equals(StoredVariables.getvendorCity().get() + " " + StoredVariables.getvendorState().get() + ", " + StoredVariables.getvendorZip().get()), "Vendor City, State, Zip is not displayed correctly");
		
		// Verify vendor phone
		Assert.assertTrue(SVendorAssignment.phone_txt(driver).getText().equals(StoredVariables.getvendorPhone().get()), "Vendor Phone is not displayed correctly");
		
		// Verify vendor email
		Assert.assertTrue(SVendorAssignment.email_txt(driver).getText().equals(StoredVariables.getvendorEmail().get()), "Vendor Email is not displayed correctly");
		
		// Click Approve
		perform.click(driver,SVendorAssignment.approve_btn(driver));
		
		// Get outside frames
		driver.switchTo().defaultContent();
		
		/***********************************************
		 * Confirm Order Page
		 ***********************************************/
	
		// Wait for the back button to be visible
		perform.waitForElementToBeClickable(driver, SConfirmOrder.backTop_btn(driver));
		
		// Confirm order screen loads
		Assert.assertTrue(driver.getCurrentUrl().contains("ConfirmOrder"), "Order page did not load");
		
		// Verify vendor Name is displayed
		String vendorName2 = StoredVariables.getvendorFirstName().get() + " " + StoredVariables.getvendorLastName().get();
		Assert.assertTrue(SConfirmOrder.vendorInformation_txt(driver).getText().contains(vendorName2), "Vendor name is not displayed in the Vendor Information");
		
		// Verify vendor Company is displayed 
		Assert.assertTrue(SConfirmOrder.vendorInformation_txt(driver).getText().contains(StoredVariables.getvendorCompanyName().get()), "Vendor company is not displayed in the Vendor Information");
		
		// Verify vendor Address is displayed 
		String vendorAddress2 = StoredVariables.getvendorAddress1().get() + "\n" + StoredVariables.getvendorCity().get() + ", " + StoredVariables.getvendorState().get() + " " + StoredVariables.getvendorZip().get();
		Assert.assertTrue(SConfirmOrder.vendorInformation_txt(driver).getText().contains(vendorAddress2), "Vendor address is not displayed in the Vendor Information");
		
		// Verify vendor Phone is displayed 
		String vendorPhone2 = StoredVariables.getvendorPhone().get().substring(0, 3) + "-" + StoredVariables.getvendorPhone().get().substring(3, 6) + "-" + StoredVariables.getvendorPhone().get().substring(6, 10);
		Assert.assertTrue(SConfirmOrder.vendorInformation_txt(driver).getText().contains(vendorPhone2), "Vendor phone number is not displayed in the Vendor Information");
		
		// Verify vendor Email is displayed 
		Assert.assertTrue(SConfirmOrder.vendorInformation_txt(driver).getText().contains(StoredVariables.getvendorEmail().get()), "Vendor email is not displayed in the Vendor Information");
		
		secure.verifyOrderDetails(driver);
		
		// Check read and understand fee notes checkbox
		if (!SConfirmOrder.readVendorsFeeNotes_chkbx(driver).isSelected())
		{
			perform.click(driver,SConfirmOrder.readVendorsFeeNotes_chkbx(driver));	
		}
		
		// Click Next
		perform.click(driver,SConfirmOrder.nextBottom_btn(driver));
		
		Thread.sleep(2000);
		
		// Wait for Frames
		perform.waitForIFrames(driver);
		
		// Get outside frames
		driver.switchTo().defaultContent();
		try {

			// Get inside the attach document frame
			perform.switchToiFrameByID(driver, "iframeAttach");
			
		} catch (Exception e) {
			
			// Go back
			driver.navigate().back();
			
			int attempt = 1;
			boolean visible = false;
			while (visible == false && attempt < 6) {
				
				try {
					
					// Wait for Next button
					perform.waitForElementToBeClickable(driver, SConfirmOrder.nextBottom_btn(driver));
					
					visible=true;
					
					// Click Next
					perform.click(driver,SConfirmOrder.nextBottom_btn(driver));
					
					Thread.sleep(2000);
					
					// Wait for Frames
					perform.waitForIFrames(driver);
					
					// Get inside the attach document frame
					driver.switchTo().frame("iframeAttach");
				
				} catch (Exception e2) {
					
					try {
						perform.click(driver,driver.findElement(By.id("sbdmButton1")));
					} catch (Exception e3) {
						
						try {
							// Wait for Next button
							perform.waitForElementToBeClickable(driver, SConfirmOrder.nextBottom_btn(driver));
							
							visible=true;
							
							// Click Next
							perform.click(driver,SConfirmOrder.nextBottom_btn(driver));
							
							Thread.sleep(2000);
							
							// Wait for Frames
							perform.waitForIFrames(driver);
							
							// Get inside the attach document frame
							perform.switchToiFrameByID(driver, "iframeAttach");
						} catch (Exception e4) {
						// Go back
						driver.navigate().back();
						
						Thread.sleep(2000);
						}
					} // end try/catch
					
				} // end try/catch
				
				attempt++;
				
			} // end while
				
		} // end try/catch
		
		// Wait for Close button
		perform.waitForElementToBeClickable(driver, SConfirmOrder.finished_btn(driver));
		
		// Click the Close button
		perform.click(driver,SConfirmOrder.finished_btn(driver));
		
		// Get outside frames
		driver.switchTo().defaultContent();
		
		// Wait for Orders button
		perform.waitForElementToBeClickable(driver, SOrders.orders_btn(driver));
		
		// Verify you land on the orders grid
		Assert.assertTrue(driver.getCurrentUrl().contains("OrderManagement"), "After completing an order, the orders grid did not load");
		
		// Query the db to get the order number that was just created
		db.getLoanID(driver);
		
		// Search for order
		secure.findOrder(driver, StoredVariables.getloanID().get(), "Tracking number");
		
		// Verify the order just created is in the orders grid 
		Assert.assertTrue(SOrders.ordersTable_txt(driver).getText().contains("MERC-" + StoredVariables.getloanID().get()), "New order is not displayed");
		
		// Open order
		perform.doubleClickInTable(driver, "MERC-" + StoredVariables.getloanID().get());
		
		// Wait for history
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Verify the order is in the Awaiting Acceptance status
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("History (Awaiting acceptance)"), "The order is not in the Awaiting acceptance status");
		
		// Verify it is assigned to the correct vendor
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("Awaiting acceptance by " + StoredVariables.getvendorFirstName().get() + " " + StoredVariables.getvendorLastName().get()), "The vendor who was assigned to the order does not display in the history");
		
		// Verify the decline event is in the history
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("Order Assignment Declined by Client (Automation Lender3)"), "The decline event does not display in the history");
		
		// Verify the declined notes are in the history
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("Notes:  " + vendorName + " - These are test notes for vendor assignment"), "The decline notes do not display in the history");
		
		// Verify the approved event is in the history
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("Vendor Approved by Client (Automation Lender3)"), "The approved event does not display in the history");
		
		// Login as vendor and verify order exists
		vendors.login(driver, StoredVariables.getvendorEmail().get(), StoredVariables.getpassword().get());
		
		// Wait for page to load
		perform.waitForElementToBeClickable(driver, VOrders.orders_btn(driver));
		
		// Find order
		vendors.findOrder(driver, StoredVariables.getborrowerIdentifier().get(), "Borrower");
		
		// Click on the order from the orders grid
		perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());
		
		// Wait for Order Information
		perform.waitForElementToBeVisible(driver, VOrderDetails.orderInformation_txt(), "id");
		
		// Verify awaiting acceptance is displayed
		Assert.assertTrue(VOrderDetails.orderInformation_txt(driver).getText().contains("Awaiting acceptance by " + vendorName2), "Awaiting acceptance from appraiser is not displayed in the history");
		

		// If browser is IE, set nativeEvents capability to false
		if (StoredVariables.getbrowser().get().equals("IE"))
		{
//			perform.IE_setNativeEventsToFalse();
		}
		
		// Sign in to Secure
		secure.login(driver, "Lender3", StoredVariables.getpassword().get());
		
		// Wait for the Preferences button to be visible
		perform.waitForElementToBeClickable(driver, SOrders.preferences_btn(driver));
		
		// Click to Preferences
		perform.click(driver,SOrders.preferences_btn(driver));
		
		// Select Vendor Selection Settings
		perform.click(driver,SPreferences.vendorSelectionSettings_btn(driver));
		
		// Turn off Double-blind Communication switch
		if (!SVendorSelectionSettings.doubleBlind_switch(driver).getAttribute("src").contains("switchOff.png"))
		{
			perform.click(driver,SVendorSelectionSettings.doubleBlind_switch(driver));
		}
		
		// Disable Automatic Vendor Selection
		if (SVendorSelectionSettings.automaticOrderAssignment_switch(driver).getAttribute("src").contains("switchOn.png"))
		{
			perform.click(driver,SVendorSelectionSettings.automaticOrderAssignment_switch(driver));
		}
		
		// Select Custom Fee Panel
		perform.click(driver,SVendorSelectionSettings.customFeePanel_radio(driver));
		
		// Uncheck Use Mercury Network Directory as backup checkbox
		if (SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver).isSelected())
		{
			perform.click(driver,SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver));
		}
		
		// Verify Mercury Network Directory as backup is unchecked
		Assert.assertTrue(SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver).isSelected()==false, "Mercury Network Directory as backup is still checked");
		
		// Save Preferences
		perform.click(driver,SVendorSelectionSettings.save_btn(driver));
		
		// Wait for the OK button to be visible
		perform.waitForElementToBeClickable(driver, SVendorSelectionSettings.ok_btn(driver));
		
		// Click OK in saved dialog box
		perform.click(driver,SVendorSelectionSettings.ok_btn(driver));

		// Clear order information variables before placing a new order
		perform.clearOrderInfoStoredVariables(driver);
		
		// Go to Residential Appraisal
		secure.goToResidentialAppraisal(driver);
		
		/***************************************
		 * Set New Order Information
		 ***************************************/
		
		// Set Property Information data
		StoredVariables.getpropertyInformationAddress().set("2621 SW 136th St");
		StoredVariables.getpropertyInformationCity().set("Oklahoma City");
		StoredVariables.getpropertyInformationState().set("Oklahoma");
		StoredVariables.getpropertyInformationStateAbbr().set("OK"); // Must set for a field check later on
		StoredVariables.getpropertyInformationZip().set("73170");
		StoredVariables.getpropertyInformationSqFt().set("5,688");
		StoredVariables.getpropertyInformationSiteSize().set("9,583 sq ft");
		StoredVariables.getpropertyInformationPropType().set("Single Family");
		StoredVariables.getpropertyInformationPropRights().set("Fee Simple");
		StoredVariables.getpropertyInformationLegalDesc().set("245 W Chantilly Way, Mustang, OK 73064");
		StoredVariables.getpropertyInformationDirections().set("East of N May Ave and south of NW Britton Rd");
		
		// Set Assignment Information data
		StoredVariables.getassignmentInformationForm().set("Uniform Residential Appraisal (FNMA 1004)");
		StoredVariables.getassignmentInformationRushOrder().set(true);
		StoredVariables.getassignmentInformationComplex().set(true);
		StoredVariables.getassignmentInformationOrderDue().set(7);
		perform.getNewDate(driver, StoredVariables.getassignmentInformationOrderDue().get());
		StoredVariables.getassignmentInformationOtherRefNumber().set("8615406");
		StoredVariables.getassignmentInformationLoanType().set("All In One");
		StoredVariables.getassignmentInformationLoanPurpose().set("Purchase");
		StoredVariables.getassignmentInformationOrderedBy().set("Borrower Name");
		StoredVariables.getassignmentInformationOrderGroup().set("AppraisersGroupTest");
		StoredVariables.getassignmentInformationLoanNumber().set("74108641");
		StoredVariables.getassignmentInformationFileNumber().set("31849");
		StoredVariables.getassignmentInformationSalesPrice().set("645,715");
		StoredVariables.getassignmentInformationFHACaseNumber().set(perform.randomNumbers(driver, 3) + "-" + perform.randomNumbers(driver, 7));
		StoredVariables.getassignmentInformationDisclosure().set(0);
		StoredVariables.getassignmentInformationAssignedTo().set("Automation Lender3");
		
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
		secure.enterNewResidentialAppraisalOrder(driver);

		// Click Next
		perform.click(driver,SNewOrder.next_btn(driver));
		
		Thread.sleep(10000);
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		Thread.sleep(2000);
		
		// Click Close on Related Orders popup
		secure.checkForRelatedOrdersDialog(driver);
		
		// Verify url contains VendorSelect
		Assert.assertTrue(driver.getCurrentUrl().contains("VendorSelect"), "The url does not contain VendorSelect");
		
		// Click the Vendor name header button
		perform.click(driver,SVendorSelection.vendorNameHeader_btn(driver));
		
		// Verify sort arrow button displays
		Assert.assertTrue(SVendorSelection.sortArrow_btn(driver).getAttribute("class").contains("ui-icon-arrowthick-1-n"), "Sort arrow is not displayed");
		
		// Click the Search tab
		perform.click(driver,SVendorSelection.searchTab_btn(driver));
		
		// Wait for first name
		perform.waitForElementToBeClickable(driver, SVendorSelection.firstName_txtbx(driver));
		
		// Enter first name
		perform.type(driver,SVendorSelection.firstName_txtbx(driver), "Automation");
		
		// Enter last name
		perform.type(driver,SVendorSelection.lastName_txtbx(driver), "Appraiser3");
		
		// City
		perform.type(driver,SVendorSelection.city_txtbx(driver), "Yukon");
		
		// Click Search
		perform.click(driver,SVendorSelection.search_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Click off error message if exists
		if (Overlay.overlay(driver).getAttribute("style").contains("visible")) {

			try {
				// Click OK
				perform.click(driver,SVendorSelection.ok_btn(driver));
				
				// Wait for overlay to be hidden
				perform.waitForOverlayToBeHidden(driver);
			} catch (Exception e) {}
			
		} // end if
		
		// Wait for Search Result name
		perform.waitForElementToBeVisible(driver, SVendorSelection.vendorSearchResultName_txt(), "cssSelector");
		
		// Verify the correct vendor was found
		Assert.assertTrue(SVendorSelection.searchResultsTable_txt(driver).getText().contains("Automation Appraiser3"), "Vendor (Automation Appraiser3) searched for did not display - " + SVendorSelection.searchResultsTable_txt(driver).getText());
		
		// Click Back
		perform.click(driver,SVendorSelection.backBottom_btn(driver));
		
		secure.verifyNewOrderInfo(driver);
		
		Thread.sleep(500);

		// Wait for Next button to be clickable
		perform.waitForElementToBeClickable(driver, SNewOrder.next_btn(driver));
		
		// Click Next
		perform.click(driver,SNewOrder.next_btn(driver));

		// Assign vendor
		secure.selectVendor(driver, "Automation Appraiser3");
		
		// Wait for Fee Notes checkbox to be clickable
		perform.waitForElementToBeClickable(driver, SConfirmOrder.readVendorsFeeNotes_chkbx(driver));
		
		// Verify Confirm Order url
		Assert.assertTrue(driver.getCurrentUrl().contains("ConfirmOrder"), "The Confirm Order screen did not load properly");
		
		secure.verifyOrderDetails(driver);
		
		// Agree to the fee notes
		perform.click(driver,SConfirmOrder.readVendorsFeeNotes_chkbx(driver));
		
		// Click Next
		perform.click(driver,SConfirmOrder.nextBottom_btn(driver));
		
		Thread.sleep(3500);
		
		// Get outside frames
		driver.switchTo().defaultContent();
		// Get inside the attach document frame
		driver.switchTo().frame("iframeAttach");
		
		// Wait for message text
		perform.waitForElementToBeClickable(driver, SConfirmOrder.finished_btn(driver));
		
		// Click Close
		perform.click(driver,SConfirmOrder.finished_btn(driver));
		
		// Get outside frames
		driver.switchTo().defaultContent();
		
		// Wait for Orders page to load
		perform.waitForElementToBeClickable(driver, SOrders.orderTypes_dropdown(driver));
		
		// Verify you land on the orders grid
		String url = driver.getCurrentUrl();
		// Set 40 second while loop timeout
		long start_time = System.currentTimeMillis();
		long wait_time = 40000;
		long end_time = start_time + wait_time;
		while (System.currentTimeMillis() < end_time && !url.contains("OrderManagement"))
		{
			url = driver.getCurrentUrl();
			if (url.contains("OrderManagement"))
			{
				break;
			}
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("OrderManagement"), "After completing an order, the orders grid did not load");
		
		// Query the db to get the order number that was just created
		db.getLoanID(driver);
		
		// Wait for the Order Types dropdown
		perform.waitForElementToBeClickable(driver, SOrders.orderTypes_dropdown(driver));

		// Verify Due date is ordered properly to display the most recent order first
		secure.sortByUpdated(driver);
		
		// Wait for overlay to disappear
		perform.waitForOverlayToBeHidden(driver);
		
		// Verify the order just created is in the orders grid 
		Assert.assertTrue(SOrders.ordersTable_txt(driver).getText().contains("MERC-" + StoredVariables.getloanID().get()), "New order is not displayed");

		// Clear order information variables before placing a new order
		perform.clearOrderInfoStoredVariables(driver);
		
		// Go to the Orders page
		perform.clickInTable_Contains(driver, "Orders");
		
		if (StoredVariables.getbrowser().get().equals("Chrome"))
		{
			Thread.sleep(500);	
		}
		
		// Click New
		perform.clickInTable_Contains(driver, "New");
		
		// Click Residential Appraisal
		perform.click(driver,SOrders.residentialAppraisal_btn(driver));
		
		/***************************************
		 * Set New Order Information
		 ***************************************/
		
		// Set Property Information data
		StoredVariables.getpropertyInformationAddress().set("2621 SW 136th St");
		StoredVariables.getpropertyInformationCity().set("Oklahoma City");
		StoredVariables.getpropertyInformationState().set("Oklahoma");
		StoredVariables.getpropertyInformationStateAbbr().set("OK"); // Must set for a field check later on
		StoredVariables.getpropertyInformationZip().set("73170");
		StoredVariables.getpropertyInformationSqFt().set("2,017");
		StoredVariables.getpropertyInformationSiteSize().set("9,583 sq ft");
		StoredVariables.getpropertyInformationPropType().set("Single Family");
		StoredVariables.getpropertyInformationPropRights().set("Fee Simple");
		StoredVariables.getpropertyInformationLegalDesc().set("717 Vickery Ave, Yukon, OK 73099");
		StoredVariables.getpropertyInformationDirections().set("Mustang Rd and NW 10th St.");
		
		// Set Assignment Information data
		StoredVariables.getassignmentInformationForm().set("Uniform Residential Appraisal (FNMA 1004)");
		StoredVariables.getassignmentInformationRushOrder().set(true);
		StoredVariables.getassignmentInformationComplex().set(true);
		StoredVariables.getassignmentInformationOrderDue().set(7);
		perform.getNewDate(driver, StoredVariables.getassignmentInformationOrderDue().get());
		StoredVariables.getassignmentInformationOtherRefNumber().set("9856321");
		StoredVariables.getassignmentInformationLoanType().set("All In One");
		StoredVariables.getassignmentInformationLoanPurpose().set("Purchase");
		StoredVariables.getassignmentInformationOrderedBy().set("Test User");
		StoredVariables.getassignmentInformationOrderGroup().set("AppraisersGroupTest");
		StoredVariables.getassignmentInformationLoanNumber().set("84131");
		StoredVariables.getassignmentInformationFileNumber().set("56413");
		StoredVariables.getassignmentInformationSalesPrice().set("188,000");
		StoredVariables.getassignmentInformationFHACaseNumber().set("6413");
		StoredVariables.getassignmentInformationDisclosure().set(0);
		StoredVariables.getassignmentInformationAssignedTo().set("Automation Lender3");
		
		// Set Lender Information data
		StoredVariables.getlenderInformationLenderName().set("US Bank");
		StoredVariables.getlenderInformationAddress1().set("123 Test St");
		StoredVariables.getlenderInformationAddress2().set("Suite D");
		StoredVariables.getlenderInformationCity().set("Mustang");
		StoredVariables.getlenderInformationState().set("OK");
		StoredVariables.getlenderInformationZip().set("73064");
		
		// Set Contact And Access Information data
		StoredVariables.getcontactOccupancy().set("Owner");
		StoredVariables.getcontactBorrower().set("Test User");
		StoredVariables.getcontactBorrowerInfo1Dropdown().set("Home");
		StoredVariables.getcontactBorrowerInfo1().set("405-555-1111");
		StoredVariables.getcontactBorrowerInfo2Dropdown().set("E-mail");
		StoredVariables.getcontactBorrowerInfo2().set("test@dntest.net");
		StoredVariables.getcontactBorrowerAddress().set("684 Test St.");
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
		secure.enterNewResidentialAppraisalOrder(driver);

		// Click Next
		perform.click(driver,SNewOrder.next_btn(driver));
		
		Thread.sleep(10000);
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Click Close on Related Orders popup
		secure.checkForRelatedOrdersDialog(driver);
		
		// Verify url contains VendorSelect
		Assert.assertTrue(driver.getCurrentUrl().contains("VendorSelect"), "The url does not contain VendorSelect");
		
		// Verify Fee Panel tab is selected
		if (!SVendorSelection.feePanelTab_tab(driver).getAttribute("class").contains("Selected"))
		{
			perform.click(driver,SVendorSelection.feePanelTab_tab(driver));
		}
		Assert.assertTrue(SVendorSelection.feePanelTab_tab(driver).getAttribute("class").contains("Selected"), "Fee Panel is not selected and should be");
		
		// Click Appraiser1
		perform.clickInTable_Contains(driver, "Automation Appraiser1");
		
		// Click Next
		perform.click(driver,SVendorSelection.nextTop_btn(driver));
		
		// Wait for Fee Notes checkbox to be clickable
		perform.waitForElementToBeClickable(driver, SConfirmOrder.readVendorsFeeNotes_chkbx(driver));
		
		// Verify Confirm Order url
		Assert.assertTrue(driver.getCurrentUrl().contains("ConfirmOrder"), "The Confirm Order screen did not load properly");
		
		secure.verifyOrderDetails(driver);
		
		// Agree to the fee notes
		perform.click(driver,SConfirmOrder.readVendorsFeeNotes_chkbx(driver));
		
		// Click Next
		perform.click(driver,SConfirmOrder.nextBottom_btn(driver));
		
		Thread.sleep(3500);
		
		// Wait for Frames
		perform.waitForIFrames(driver);
		
		// Get outside frames
		driver.switchTo().defaultContent();
		// Get inside the attach document frame
		driver.switchTo().frame("iframeAttach");
		
		// Wait for message text
		perform.waitForElementToBeClickable(driver, SConfirmOrder.finished_btn(driver));
		
		// Click Close
		perform.click(driver,SConfirmOrder.finished_btn(driver));
		
		// Get outside frames
		driver.switchTo().defaultContent();
		
		// Wait for Orders page to load
		perform.waitForElementToBeClickable(driver, SOrders.orderTypes_dropdown(driver));
		
		// Verify you land on the orders grid
		url = driver.getCurrentUrl();
		// Set 40 second while loop timeout
		start_time = System.currentTimeMillis();
		wait_time = 40000;
		end_time = start_time + wait_time;
		while (System.currentTimeMillis() < end_time && !url.contains("OrderManagement"))
		{
			url = driver.getCurrentUrl();
			if (url.contains("OrderManagement"))
			{
				break;
			}
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("OrderManagement"), "After completing an order, the orders grid did not load");
		
		// Query the db to get the order number that was just created
		db.getLoanID(driver);
		
		// Get VendorID
		String vendorID = db.getVendorIDForOrder(driver);
		
		// Get ParentEntityID
		String getParentEntityIDSQL = "select EntityID "
				+ "from Entities "
				+ "where LastName = 'Appraiser1' "
				+ "and FirstName = 'Automation' "
				+ "and Email like '%" + StoredVariables.getusernameEnvironment().get() + "%'";
		String parentEntityID = db.queryDB(driver, "Mercury", getParentEntityIDSQL);
		
		// Verify in the db that the order placed to a vendor sub user
		System.out.println("vendorID = " + vendorID + "    parentEntityID = " + parentEntityID);
		Assert.assertTrue(vendorID.equals(parentEntityID), "The VendorID is not set to the Admin's EntityID --- vendorID = " + vendorID + "    parentEntityID = " + parentEntityID);

		// Clear order information variables before placing a new order
		perform.clearOrderInfoStoredVariables(driver);
		
		// Go to the Orders page
		perform.clickInTable_Contains(driver, "Orders");
		
		if (StoredVariables.getbrowser().get().equals("Chrome"))
		{
			Thread.sleep(500);	
		}
		
		// Click New
		perform.clickInTable_Contains(driver, "New");
		
		// Click Residential Appraisal
		perform.click(driver,SOrders.residentialAppraisal_btn(driver));
		
		/***************************************
		 * Set New Order Information
		 ***************************************/
		
		// Set Property Information data
		StoredVariables.getpropertyInformationAddress().set("2621 SW 136th St");
		StoredVariables.getpropertyInformationCity().set("Oklahoma City");
		StoredVariables.getpropertyInformationState().set("Oklahoma");
		StoredVariables.getpropertyInformationStateAbbr().set("OK"); // Must set for a field check later on
		StoredVariables.getpropertyInformationZip().set("73170");
		StoredVariables.getpropertyInformationSqFt().set("5,688");
		StoredVariables.getpropertyInformationSiteSize().set("9,583 sq ft");
		StoredVariables.getpropertyInformationPropType().set("Single Family");
		StoredVariables.getpropertyInformationPropRights().set("Fee Simple");
		StoredVariables.getpropertyInformationLegalDesc().set("245 W Chantilly Way, Mustang, OK 73064");
		StoredVariables.getpropertyInformationDirections().set("East of N May Ave and south of NW Britton Rd");
		
		// Set Assignment Information data
		StoredVariables.getassignmentInformationForm().set("Uniform Residential Appraisal (FNMA 1004)");
		StoredVariables.getassignmentInformationRushOrder().set(true);
		StoredVariables.getassignmentInformationComplex().set(true);
		StoredVariables.getassignmentInformationOrderDue().set(7);
		perform.getNewDate(driver, StoredVariables.getassignmentInformationOrderDue().get());
		StoredVariables.getassignmentInformationOtherRefNumber().set("8615406");
		StoredVariables.getassignmentInformationLoanType().set("All In One");
		StoredVariables.getassignmentInformationLoanPurpose().set("Purchase");
		StoredVariables.getassignmentInformationOrderedBy().set("Borrower Name");
		StoredVariables.getassignmentInformationOrderGroup().set("AppraisersGroupTest");
		StoredVariables.getassignmentInformationLoanNumber().set("74108641");
		StoredVariables.getassignmentInformationFileNumber().set("31849");
		StoredVariables.getassignmentInformationSalesPrice().set("645,715");
		StoredVariables.getassignmentInformationFHACaseNumber().set("564193");
		StoredVariables.getassignmentInformationDisclosure().set(0);
		StoredVariables.getassignmentInformationAssignedTo().set("Automation Lender3");
		
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
		secure.enterNewResidentialAppraisalOrder(driver);

		// Click Next
		perform.click(driver,SNewOrder.next_btn(driver));
		
		// Click Close on Related Orders popup
		secure.checkForRelatedOrdersDialog(driver);
		
		// Verify url contains VendorSelect
		Assert.assertTrue(driver.getCurrentUrl().contains("VendorSelect"), "The url does not contain VendorSelect");
		
		// Verify Fee Panel tab is selected
		if (!SVendorSelection.feePanelTab_tab(driver).getAttribute("class").contains("Selected"))
		{
			perform.click(driver,SVendorSelection.feePanelTab_tab(driver));
		}
		Assert.assertTrue(SVendorSelection.feePanelTab_tab(driver).getAttribute("class").contains("Selected"), "Fee Panel is not selected and should be");
		
		// Check for related orders dialog
		secure.checkForRelatedOrdersDialog(driver);
		
		// Click Appraiser1
		perform.clickInTable_Contains(driver, "Automation Appraiser1SU");
		
		// Click Next
		perform.click(driver,SVendorSelection.nextTop_btn(driver));
		
		// Wait for Fee Notes checkbox to be clickable
		perform.waitForElementToBeClickable(driver, SConfirmOrder.readVendorsFeeNotes_chkbx(driver));
		
		// Verify Confirm Order url
		Assert.assertTrue(driver.getCurrentUrl().contains("ConfirmOrder"), "The Confirm Order screen did not load properly");
		
		secure.verifyOrderDetails(driver);
		
		// Agree to the fee notes
		perform.click(driver,SConfirmOrder.readVendorsFeeNotes_chkbx(driver));
		
		// Click Next
		perform.click(driver,SConfirmOrder.nextBottom_btn(driver));
		
		Thread.sleep(5000);
		
		// Wait for Frames
		perform.waitForIFrames(driver);
		
		// Get outside frames
		driver.switchTo().defaultContent();
		// Get inside the attach document frame
		driver.switchTo().frame("iframeAttach");
		
		// Wait for message text
		perform.waitForElementToBeClickable(driver, SConfirmOrder.finished_btn(driver));
		
		// Click Close
		perform.click(driver,SConfirmOrder.finished_btn(driver));
		
		// Get outside frames
		driver.switchTo().defaultContent();
		
		// Wait for Orders page to load
		perform.waitForElementToBeClickable(driver, SOrders.orderTypes_dropdown(driver));
		
		// Verify you land on the orders grid
		url = driver.getCurrentUrl();
		// Set 40 second while loop timeout
		start_time = System.currentTimeMillis();
		wait_time = 40000;
		end_time = start_time + wait_time;
		while (System.currentTimeMillis() < end_time && !url.contains("OrderManagement"))
		{
			url = driver.getCurrentUrl();
			if (url.contains("OrderManagement"))
			{
				break;
			}
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("OrderManagement"), "After completing an order, the orders grid did not load");
		
		// Query the db to get the order number that was just created
		db.getLoanID(driver);
		
		// Get VendorID
		vendorID = db.getVendorIDForOrder(driver);
		
		// Get ParentEntityID
		getParentEntityIDSQL = "select EntityID "
				+ "from Entities "
				+ "where LastName = 'Appraiser1' "
				+ "and FirstName = 'Automation' "
				+ "and Email like '%" + StoredVariables.getusernameEnvironment().get() + "%'";
		parentEntityID = db.queryDB(driver, "Mercury", getParentEntityIDSQL);
		
		// Verify in the db that the order placed to a vendor sub user
		System.out.println("vendorID = " + vendorID + "    parentEntityID = " + parentEntityID);
		Assert.assertTrue(vendorID.equals(parentEntityID), "The VendorID is not set to the Admin's EntityID --- vendorID = " + vendorID + "    parentEntityID = " + parentEntityID);
		
		// Log in to Secure as VMP
		secure.login(driver, "VMP", StoredVariables.getpassword().get());
		
		// Wait for Preferences button
		perform.waitForElementToBeClickable(driver, SOrders.preferences_btn(driver));
		
		// Click to Preferences
		perform.click(driver,SOrders.preferences_btn(driver));
		
		// Select Vendor Selection Settings
		perform.click(driver,SPreferences.vendorSelectionSettings_btn(driver));
		
		// Turn off Double-blind Communication switch
		if (!SVendorSelectionSettings.doubleBlind_switch(driver).getAttribute("src").contains("switchOff.png"))
		{
			perform.click(driver,SVendorSelectionSettings.doubleBlind_switch(driver));
		}
		
		// Enable Unattended Order Assignment Selection
		if (!SVendorSelectionSettings.unattendedOrderAssignment_switch(driver).getAttribute("src").contains("switchOn.png"))
		{
			// Click switch On
			perform.click(driver,SVendorSelectionSettings.unattendedOrderAssignment_switch(driver));
		}
		
		// Enable Unattended Order Reassignment
		if (!SVendorSelectionSettings.unattendedOrderReassignment_switch(driver).getAttribute("src").contains("switchOn.png"))
		{
			perform.click(driver,SVendorSelectionSettings.unattendedOrderReassignment_switch(driver));
		}
		
		// Select Custom Fee Panel
		perform.click(driver,SVendorSelectionSettings.customFeePanel_radio(driver));
		
		// Uncheck Use Mercury Network Directory as backup checkbox
		if (SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver).isSelected())
		{
			perform.click(driver,SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver));
		}
		
		// Verify Mercury Network Directory as backup is unchecked
		Assert.assertTrue(SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver).isSelected()==false, "Mercury Network Directory as backup is still checked");
		
		// Save Preferences
		perform.click(driver,SVendorSelectionSettings.save_btn(driver));
		
		// Wait for the OK button to be visible
		perform.waitForElementToBeClickable(driver, SVendorSelectionSettings.ok_btn(driver));
		
		// Click OK in saved dialog box
		perform.click(driver,SVendorSelectionSettings.ok_btn(driver));
		
		// Click Users
		perform.click(driver,SOrders.users_btn(driver));
		
		// Verify Auto Assignment Approval is not checked
		if (SUsers.autoAssignmentApproval_chkbx(driver).isSelected())
		{
			perform.click(driver,SUsers.autoAssignmentApproval_chkbx(driver));
		}
		
		// Click Save
		perform.click(driver,SUsers.save_btn(driver));
		
		// Wait for orders button
		perform.waitForElementToBeClickable(driver, SOrders.orders_btn(driver));

		// Clear order information variables before placing a new order
		perform.clearOrderInfoStoredVariables(driver);
		
		// Login to VMP Client Portal
		vmp.login(driver, "VMP", "OriginatorVMP2", StoredVariables.getpassword().get());
		
		// Wait for New Order button
		perform.waitForElementToBeClickable(driver, VMPOrders.newOrder_btn(driver));
		
		// Click New Order
		perform.click(driver,VMPOrders.newOrder_btn(driver));
		
		// Wait for Address text box
		perform.waitForElementToBeClickable(driver, VMPNewOrder.address_txtbx(driver));
		
		/***************************************
		 * Set New Order Information
		 ***************************************/

		// Set Property Information data		
		StoredVariables.getpropertyInformationAddress().set("2621 SW 136th St");
		StoredVariables.getpropertyInformationCity().set("Oklahoma City");
		StoredVariables.getpropertyInformationState().set("Oklahoma");
		StoredVariables.getpropertyInformationStateAbbr().set("OK"); // Must set for a field check later on
		StoredVariables.getpropertyInformationZip().set("73170");
		StoredVariables.getpropertyInformationPropType().set("Single Family");
		StoredVariables.getpropertyInformationLegalDesc().set("245 W Chantilly Way, Mustang, OK 73064");
		StoredVariables.getpropertyInformationDirections().set("East of N May Ave and south of NW Britton Rd - 878787");
		
		// Set Assignment Information data
		StoredVariables.getassignmentInformationForm().set("1004 Full/URAR");
		StoredVariables.getassignmentInformationOrderDue().set(7);
		perform.getNewDate(driver, StoredVariables.getassignmentInformationOrderDue().get());
		StoredVariables.getassignmentInformationOtherRefNumber().set(perform.randomNumbers(driver, 7));
		StoredVariables.getassignmentInformationLoanType().set("All In One");
		StoredVariables.getassignmentInformationLoanPurpose().set("Purchase");
		StoredVariables.getassignmentInformationOrderedBy().set("Borrower Name");
		StoredVariables.getassignmentInformationAccountExec().set("(None Selected)");
		StoredVariables.getassignmentInformationLoanNumber().set(perform.randomNumbers(driver, 15));
		StoredVariables.getassignmentInformationFileNumber().set(perform.randomNumbers(driver, 5));
		StoredVariables.getassignmentInformationSalesPrice().set("645,715");
		StoredVariables.getassignmentInformationFHACaseNumber().set(perform.randomNumbers(driver, 6));
		StoredVariables.getassignmentInformationDisclosure().set(0);
		
		// Set Lender Information data
		StoredVariables.getlenderInformationLenderName().set("BOKF, National Association");
		StoredVariables.getlenderInformationAddress1().set("One Williams Center");
		StoredVariables.getlenderInformationCity().set("Tulsa");
		StoredVariables.getlenderInformationState().set("Oklahoma");
		StoredVariables.getlenderInformationZip().set("74172");
		
		// Set Contact And Access Information data
		StoredVariables.getcontactOccupancy().set("Owner");
		StoredVariables.getcontactBorrower().set("Borrower Name");
		StoredVariables.getcontactBorrowerInfo1Dropdown().set("Home");
		StoredVariables.getcontactBorrowerInfo1().set("405-555-7818");
		StoredVariables.getcontactBorrowerInfo2Dropdown().set("E-mail");
		StoredVariables.getcontactBorrowerInfo2().set("borrower@dntest.net");
		StoredVariables.getcontactCoBorrower().set("Coborrower Name");
		StoredVariables.getcontactCoBorrowerInfo1Dropdown().set("Work");
		StoredVariables.getcontactCoBorrowerInfo1().set("405-555-9813");
		StoredVariables.getcontactCoBorrowerInfo2Dropdown().set("Mobile");
		StoredVariables.getcontactCoBorrowerInfo2().set("405-555-1679");
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
		
		// Set Assigned person and pass it to StoredVariables
		StoredVariables.getassignmentInformationAssignedTo().set("Automation OriginatorVMP2");
		
		// Enter New Order data
		vmp.enterNewOrder(driver);
		
		// Wait for the Next button
		perform.waitForElementToBeClickable(driver, VMPNewOrder.nextBottom_btn(driver));
		
		// Click Next
		perform.click(driver,VMPNewOrder.nextBottom_btn(driver));
		
		Thread.sleep(1000);
		
		/***********************************************
		 * Confirm Order Page
		 ***********************************************/

		vmp.saveNewOrder(driver);
		
		// Select document type
		perform.selectDropdownOption(driver, VMPConfirmOrder.documentType_dropdown(driver), "Other");
		
		// Click Finished Button
		perform.click(driver,VMPConfirmOrder.finished_btn(driver));
		
		// Switch back to the attach documents frame
		driver.switchTo().defaultContent();
		
		// Wait for the OK button in the Order Placed dialog
		perform.waitForElementToBeClickable(driver, VMPConfirmOrder.ok_btn(driver));
		
		// Click the OK button in the Order Placed dialog
		perform.click(driver,VMPConfirmOrder.ok_btn(driver));
		
		// Wait for the Find textbox
		perform.waitForElementToBeClickable(driver, VMPOrders.find_txtbx(driver));
		
		// Verify you land on the orders grid
		Assert.assertTrue(driver.getCurrentUrl().contains("OrderManagement"), "After completing an order, the orders grid did not load");
		
		// Query the db to get the order number that was just created
		db.getLoanIDsFromVMPClientPortalOrder(driver);

		// Log in to Secure
		secure.login(driver, "VMP", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, StoredVariables.getloanID().get(), "Tracking number");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("Awaiting acceptance"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getloanID().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Verify the order details
		secure.verifyResidentialAppraisalOrderDetails(driver);
		
		// Get vendor name
		db.getLoanIDsFromVMPClientPortalOrder(driver);
		db.getVendorEmailFromLoanID(driver, StoredVariables.getloanID().get());
		db.getVendorInformationByEmail(driver, StoredVariables.getvendorEmail().get());
		StoredVariables.getfirstVendorName().set(StoredVariables.getvendorFirstName().get() + " " + StoredVariables.getvendorLastName().get());
		
		// Get history text
		String history = SOrderDetails.history_txt(driver).getText();
		
		// Verify the history
		Assert.assertTrue(history.contains("History (Awaiting acceptance)"), "History (Awaiting acceptance) is missing from the order information");
		Assert.assertTrue(history.contains("Order automatically assigned"), "Order automatically assigned did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("The vendor's published fee was accepted as the order fee ($350)."), "The vendor's published fee was accepted as the order fee ($350). did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Vendor Fee Notes"), "Vendor Fee Notes did not sync from VMP to Secure");
		
		// Get vendor info text
		String vendorInfo = SOrderDetails.vendorInformation_txt(driver).getText();
		
		// Verify vendor info
		Assert.assertTrue(vendorInfo.contains(StoredVariables.getvendorFirstName().get()), "Vendor First Name is not displaying correctly");
		Assert.assertTrue(vendorInfo.contains(StoredVariables.getvendorLastName().get()), "Vendor Last Name is not displaying correctly");
		Assert.assertTrue(vendorInfo.contains(StoredVariables.getvendorCompanyName().get()), "Vendor Company Name is not displaying correctly");
		Assert.assertTrue(vendorInfo.contains(StoredVariables.getvendorAddress1().get()), "Vendor Address is not displaying correctly");
		Assert.assertTrue(vendorInfo.contains(StoredVariables.getvendorCity().get() + ", " + StoredVariables.getvendorState().get() + " " + StoredVariables.getvendorZip().get()), "Vendor Address is not displaying correctly");
		Assert.assertTrue(vendorInfo.contains(StoredVariables.getvendorEmail().get()), "Vendor Email is not displaying correctly");

		// Log in to Vendors
		System.out.println("vendorEmail = " + StoredVariables.getvendorEmail().get());
		System.out.println("password = " + StoredVariables.getpassword().get());
		vendors.login(driver, StoredVariables.getvendorEmail().get(), StoredVariables.getpassword().get());
		
		// Search for order
		vendors.findOrder(driver, StoredVariables.getloanID().get(), "Tracking Number");
		
		// Wait for text to be visible
		perform.waitForElementToBeVisible(driver, VOrders.ordersGrid_txt(), "id");
		
		// Verify order status
		Assert.assertTrue(VOrders.ordersGrid_txt(driver).getText().contains("Awaiting acceptance"), "The order is not in the correct status");
		
		// Click on the order from the orders grid
		perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, VOrderDetails.orderInformation_txt(), "id");
		
		// Get order information text
		String orderInformation = VOrderDetails.orderInformation_txt(driver).getText();
		
		// Verify audit trail
		Assert.assertTrue(orderInformation.contains("History (Awaiting acceptance)"), "History (Awaiting acceptance) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Awaiting acceptance by " + StoredVariables.getvendorFirstName().get() + " " + StoredVariables.getvendorLastName().get()), "Awaiting acceptance by " + StoredVariables.getvendorFirstName().get() + " " + StoredVariables.getvendorLastName().get() + " is missing from the order information");
		
		// View Order Details
		vendors.verifyOrderDetails(driver);
		
		Thread.sleep(1000);
		
		// Click on the Accept/Decline button
		perform.click(driver,VOrderDetails.acceptDecline_btn(driver));

		// Allow popup time to load
		Thread.sleep(1500);
		
		// Wait for Select Action dropdown
		perform.waitForElementToBeClickable(driver, VOrderAcknowledgement.selectAction_dropdown(driver));

		// Select Propose Conditions to Client from Select Action dropdown
		perform.selectDropdownOption(driver, VOrderAcknowledgement.selectAction_dropdown(driver), "Decline this Assignment");
		
		// Add Notes
		perform.type(driver,VOrderDetails.declineThisAssignmentNotes_txtbx(driver), "These are the decline notes");
		
		// Click OK
		perform.click(driver,VOrderDetails.declineThisAssignmentOk_btn(driver));
		
		// Wait for the Find text box
		perform.waitForElementToBeClickable(driver, VOrders.find_txtbx(driver));
	
		// Log in to Secure
		secure.login(driver, "VMP", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, StoredVariables.getloanID().get(), "Tracking number");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("Awaiting acceptance"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getloanID().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Verify the order details
		secure.verifyResidentialAppraisalOrderDetails(driver);
		
		// Get vendor information
		db.getLoanIDsFromVMPClientPortalOrder(driver);
		db.getVendorEmailFromLoanID(driver, StoredVariables.getloanID().get());
		db.getVendorInformationByEmail(driver, StoredVariables.getvendorEmail().get());
		StoredVariables.getsecondVendorName().set(StoredVariables.getvendorFirstName().get() + " " + StoredVariables.getvendorLastName().get());
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify the history
		Assert.assertTrue(history.contains("History (Awaiting acceptance)"), "History (Awaiting acceptance) is missing from the order information");
		Assert.assertTrue(history.contains("Awaiting acceptance by " + StoredVariables.getsecondVendorName().get()), "Awaiting acceptance by " + StoredVariables.getsecondVendorName().get() + " did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Order automatically reassigned"), "Order automatically reassigned did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Declined by Appraiser (" + StoredVariables.getfirstVendorName().get() + ")"), "Declined by Appraiser (" + StoredVariables.getfirstVendorName().get() + ") did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("These are the decline notes"), "These are the decline notes did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Order automatically assigned"), "Order automatically assigned did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("The vendor's published fee was accepted as the order fee ($350)."), "The vendor's published fee was accepted as the order fee ($350). did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Vendor Fee Notes"), "Vendor Fee Notes did not sync from VMP to Secure");
		
		// Get vendor info text
		vendorInfo = SOrderDetails.vendorInformation_txt(driver).getText();
		
		// Verify vendor info
		Assert.assertTrue(vendorInfo.contains(StoredVariables.getvendorFirstName().get()), "Vendor First Name is not displaying correctly");
		Assert.assertTrue(vendorInfo.contains(StoredVariables.getvendorLastName().get()), "Vendor Last Name is not displaying correctly");
		Assert.assertTrue(vendorInfo.contains(StoredVariables.getvendorCompanyName().get()), "Vendor Company Name is not displaying correctly");
		Assert.assertTrue(vendorInfo.contains(StoredVariables.getvendorAddress1().get()), "Vendor Address is not displaying correctly");
		Assert.assertTrue(vendorInfo.contains(StoredVariables.getvendorCity().get() + ", " + StoredVariables.getvendorState().get() + " " + StoredVariables.getvendorZip().get()), "Vendor Address is not displaying correctly");
		Assert.assertTrue(vendorInfo.contains(StoredVariables.getvendorEmail().get()), "Vendor Email is not displaying correctly");
		
		// Clear order information variables before placing a new order
		perform.clearOrderInfoStoredVariables(driver);
		
		// Login to VMP Client Portal
		vmp.login(driver, "VMP", "OriginatorVMP2", StoredVariables.getpassword().get());
		
		// Wait for New Order button
		perform.waitForElementToBeClickable(driver, VMPOrders.newOrder_btn(driver));
		
		// Click New Order
		perform.click(driver,VMPOrders.newOrder_btn(driver));
		
		// Wait for Address text box
		perform.waitForElementToBeClickable(driver, VMPNewOrder.address_txtbx(driver));
		
		/***************************************
		 * Set New Order Information
		 ***************************************/

		// Set Property Information data		
		StoredVariables.getpropertyInformationAddress().set("2621 SW 136th St");
		StoredVariables.getpropertyInformationCity().set("Oklahoma City");
		StoredVariables.getpropertyInformationState().set("Oklahoma");
		StoredVariables.getpropertyInformationStateAbbr().set("OK"); // Must set for a field check later on
		StoredVariables.getpropertyInformationZip().set("73170");
		StoredVariables.getpropertyInformationPropType().set("Single Family");
		StoredVariables.getpropertyInformationLegalDesc().set("245 W Chantilly Way, Mustang, OK 73064");
		StoredVariables.getpropertyInformationDirections().set("East of N May Ave and south of NW Britton Rd");
		
		// Set Assignment Information data
		StoredVariables.getassignmentInformationForm().set("1004 Full/URAR");
		StoredVariables.getassignmentInformationOrderDue().set(7);
		perform.getNewDate(driver, StoredVariables.getassignmentInformationOrderDue().get());
		StoredVariables.getassignmentInformationOtherRefNumber().set(perform.randomNumbers(driver, 7));
		StoredVariables.getassignmentInformationLoanType().set("All In One");
		StoredVariables.getassignmentInformationLoanPurpose().set("Purchase");
		StoredVariables.getassignmentInformationOrderedBy().set("Borrower Name");
		StoredVariables.getassignmentInformationAccountExec().set("(None Selected)");
		StoredVariables.getassignmentInformationLoanNumber().set(perform.randomNumbers(driver, 15));
		StoredVariables.getassignmentInformationFileNumber().set(perform.randomNumbers(driver, 5));
		StoredVariables.getassignmentInformationSalesPrice().set("645,715");
		StoredVariables.getassignmentInformationFHACaseNumber().set(perform.randomNumbers(driver, 6));
		StoredVariables.getassignmentInformationDisclosure().set(0);
		
		// Set Lender Information data
		StoredVariables.getlenderInformationLenderName().set("BOKF, National Association");
		StoredVariables.getlenderInformationAddress1().set("One Williams Center");
		StoredVariables.getlenderInformationCity().set("Tulsa");
		StoredVariables.getlenderInformationState().set("Oklahoma");
		StoredVariables.getlenderInformationZip().set("74172");
		
		// Set Contact And Access Information data
		StoredVariables.getcontactOccupancy().set("Owner");
		StoredVariables.getcontactBorrower().set("Borrower Name");
		StoredVariables.getcontactBorrowerInfo1Dropdown().set("Home");
		StoredVariables.getcontactBorrowerInfo1().set("405-555-7818");
		StoredVariables.getcontactBorrowerInfo2Dropdown().set("E-mail");
		StoredVariables.getcontactBorrowerInfo2().set("borrower@dntest.net");
		StoredVariables.getcontactCoBorrower().set("Coborrower Name");
		StoredVariables.getcontactCoBorrowerInfo1Dropdown().set("Work");
		StoredVariables.getcontactCoBorrowerInfo1().set("405-555-9813");
		StoredVariables.getcontactCoBorrowerInfo2Dropdown().set("Mobile");
		StoredVariables.getcontactCoBorrowerInfo2().set("405-555-1679");
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
		
		// Set Assigned person and pass it to StoredVariables
		StoredVariables.getassignmentInformationAssignedTo().set("Automation OriginatorVMP2");
		
		// Enter New Order data
		vmp.enterNewOrder(driver);
		
		// Click Next
		perform.click(driver,VMPNewOrder.nextBottom_btn(driver));
		
		Thread.sleep(1000);
		
		/***********************************************
		 * Confirm Order Page
		 ***********************************************/

		vmp.saveNewOrder(driver);
		
		// Select document type
		perform.selectDropdownOption(driver, VMPConfirmOrder.documentType_dropdown(driver), "Other");
		
		// Click Finished Button
		perform.click(driver,VMPConfirmOrder.finished_btn(driver));
		
		// Switch back to the attach documents frame
		driver.switchTo().defaultContent();
		
		// Wait for the OK button in the Order Placed dialog
		perform.waitForElementToBeClickable(driver, VMPConfirmOrder.ok_btn(driver));
		
		// Click the OK button in the Order Placed dialog
		perform.click(driver,VMPConfirmOrder.ok_btn(driver));
		
		// Wait for the Find textbox
		perform.waitForElementToBeClickable(driver, VMPOrders.find_txtbx(driver));
		
		// Verify you land on the orders grid
		Assert.assertTrue(driver.getCurrentUrl().contains("OrderManagement"), "After completing an order, the orders grid did not load");
		
		// Query the db to get the order number that was just created
		db.getLoanIDsFromVMPClientPortalOrder(driver);
		
		// Log in to Secure
		secure.login(driver, "VMP", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, StoredVariables.getloanID().get(), "Tracking number");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("Awaiting acceptance"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getloanID().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Verify the order details
		secure.verifyResidentialAppraisalOrderDetails(driver);
		
		// Get vendor name
		db.getLoanIDsFromVMPClientPortalOrder(driver);
		db.getVendorEmailFromLoanID(driver, StoredVariables.getloanID().get());
		db.getVendorInformationByEmail(driver, StoredVariables.getvendorEmail().get());
		StoredVariables.getfirstVendorName().set(StoredVariables.getvendorFirstName().get() + " " + StoredVariables.getvendorLastName().get());
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify the history
		Assert.assertTrue(history.contains("History (Awaiting acceptance)"), "History (Awaiting acceptance) is missing from the order information");
		Assert.assertTrue(history.contains("Order automatically assigned"), "Order automatically assigned did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("The vendor's published fee was accepted as the order fee ($350)."), "The vendor's published fee was accepted as the order fee ($350). did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Vendor Fee Notes"), "Vendor Fee Notes did not sync from VMP to Secure");
		
		// Get vendor info text
		vendorInfo = SOrderDetails.vendorInformation_txt(driver).getText();
		
		// Verify vendor info
		Assert.assertTrue(vendorInfo.contains(StoredVariables.getvendorFirstName().get()), "Vendor First Name is not displaying correctly");
		Assert.assertTrue(vendorInfo.contains(StoredVariables.getvendorLastName().get()), "Vendor Last Name is not displaying correctly");
		Assert.assertTrue(vendorInfo.contains(StoredVariables.getvendorCompanyName().get()), "Vendor Company Name is not displaying correctly");
		Assert.assertTrue(vendorInfo.contains(StoredVariables.getvendorAddress1().get()), "Vendor Address is not displaying correctly");
		Assert.assertTrue(vendorInfo.contains(StoredVariables.getvendorCity().get() + ", " + StoredVariables.getvendorState().get() + " " + StoredVariables.getvendorZip().get()), "Vendor Address is not displaying correctly");
		Assert.assertTrue(vendorInfo.contains(StoredVariables.getvendorEmail().get()), "Vendor Email is not displaying correctly");

		// Log in to Vendors
		vendors.login(driver, StoredVariables.getvendorEmail().get(), StoredVariables.getpassword().get());
		
		// Search for order
		vendors.findOrder(driver, StoredVariables.getloanID().get(), "Tracking Number");
		
		// Verify order status
		Assert.assertTrue(VOrders.ordersGrid_txt(driver).getText().contains("Awaiting acceptance"), "The order is not in the correct status");
		
		// Click on the order from the orders grid
		perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, VOrderDetails.orderInformation_txt(), "id");
		
		// Get order information text
		orderInformation = VOrderDetails.orderInformation_txt(driver).getText();
		
		// Verify audit trail
		Assert.assertTrue(orderInformation.contains("History (Awaiting acceptance)"), "History (Awaiting acceptance) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Awaiting acceptance by " + StoredVariables.getvendorFirstName().get() + " " + StoredVariables.getvendorLastName().get()), "Awaiting acceptance by " + StoredVariables.getvendorFirstName().get() + " " + StoredVariables.getvendorLastName().get() + " is missing from the order information");
		
		// View Order Details
		vendors.verifyOrderDetails(driver);
		
		Thread.sleep(1000);
		
		// Click on the Accept/Decline button
		perform.click(driver,VOrderDetails.acceptDecline_btn(driver));

		// Allow popup time to load
		Thread.sleep(1500);
		
		// Wait for Select Action dropdown
		perform.waitForElementToBeClickable(driver, VOrderAcknowledgement.selectAction_dropdown(driver));

		// Select Propose Conditions to Client from Select Action dropdown
		perform.selectDropdownOption(driver, VOrderAcknowledgement.selectAction_dropdown(driver), "Decline this Assignment");
		
		// Add Notes
		perform.type(driver,VOrderDetails.declineThisAssignmentNotes_txtbx(driver), "These are the decline notes");
		
		// Click OK
		perform.click(driver, VOrderDetails.declineThisAssignmentOk_btn(driver));
		
		// Wait for the Find text box
		perform.waitForElementToBeClickable(driver, VOrders.find_txtbx(driver));

		// Log in to Secure
		secure.login(driver, "VMP", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, StoredVariables.getloanID().get(), "Tracking number");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("Awaiting acceptance"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getloanID().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Verify the order details
		secure.verifyResidentialAppraisalOrderDetails(driver);
		
		// Get vendor information
		db.getLoanIDsFromVMPClientPortalOrder(driver);
		db.getVendorEmailFromLoanID(driver, StoredVariables.getloanID().get());
		db.getVendorInformationByEmail(driver, StoredVariables.getvendorEmail().get());
		StoredVariables.getsecondVendorName().set(StoredVariables.getvendorFirstName().get() + " " + StoredVariables.getvendorLastName().get());
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify the history
		Assert.assertTrue(history.contains("History (Awaiting acceptance)"), "History (Awaiting acceptance) is missing from the order information");
		Assert.assertTrue(history.contains("Awaiting acceptance by " + StoredVariables.getsecondVendorName().get()), "Awaiting acceptance by " + StoredVariables.getsecondVendorName().get() + " did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Order automatically reassigned"), "Order automatically reassigned did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Declined by Appraiser (" + StoredVariables.getfirstVendorName().get() + ")"), "Declined by Appraiser (" + StoredVariables.getfirstVendorName().get() + ") did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("These are the decline notes"), "These are the decline notes did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Order automatically assigned"), "Order automatically assigned did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("The vendor's published fee was accepted as the order fee ($350)."), "The vendor's published fee was accepted as the order fee ($350). did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Vendor Fee Notes"), "Vendor Fee Notes did not sync from VMP to Secure");
		
		// Get vendor info text
		vendorInfo = SOrderDetails.vendorInformation_txt(driver).getText();
		
		// Verify vendor info
		Assert.assertTrue(vendorInfo.contains(StoredVariables.getvendorFirstName().get()), "Vendor First Name is not displaying correctly");
		Assert.assertTrue(vendorInfo.contains(StoredVariables.getvendorLastName().get()), "Vendor Last Name is not displaying correctly");
		Assert.assertTrue(vendorInfo.contains(StoredVariables.getvendorCompanyName().get()), "Vendor Company Name is not displaying correctly");
		Assert.assertTrue(vendorInfo.contains(StoredVariables.getvendorAddress1().get()), "Vendor Address is not displaying correctly");
		Assert.assertTrue(vendorInfo.contains(StoredVariables.getvendorCity().get() + ", " + StoredVariables.getvendorState().get() + " " + StoredVariables.getvendorZip().get()), "Vendor Address is not displaying correctly");
		Assert.assertTrue(vendorInfo.contains(StoredVariables.getvendorEmail().get()), "Vendor Email is not displaying correctly");
	
		// Log test
		test.log(LogStatus.INFO, "Round Trip", "Ran through the Order Ownership process");
		
	} // end viewOrderDetailsOnSecure3
	
} // end the OrderOwnership class
