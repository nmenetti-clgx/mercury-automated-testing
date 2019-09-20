package matrixULSOrders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjects.Secure.SConfirmOrder;
import pageObjects.Secure.SOrderDetails;
import pageObjects.Secure.SOrders;
import pageObjects.Secure.SPreferences;
import pageObjects.Secure.SVMPXSites;
import pageObjects.Secure.SVendorSelection;
import pageObjects.Secure.SVendorSelectionSettings;
import pageObjects.VMP.VMPAppraisalOrderDetails;
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

// TODO: Auto-generated Javado
/**
 * <h1>ULS Orders - Order 1</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class ULSOrders_Order1 extends TestSetup {
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to secure</li>
	 * 	<li>Go to VMP XSite settings</li>
	 * 	<li>Verify the dropdown is the correct VMP site</li>
	 * 	<li>Check every option for syncing</li>
	 * 	<li>Click OK</li>
	 * 	<li>Click Save</li>
	 * 	<li>Get the AWSAccountsID</li>
	 * 	<li>Build database url</li>
	 * 	<li>String dbUrl = "jdbc:sqlserver:" + StoredVariables.getdbName().get() + ":" + StoredVariables.getdbPort().get() + ";"+</li>
	 * 	<li>Get sync statuses</li>
	 * 	<li>Load the required JDBC Driver class</li>
	 * 	<li>Execute the sql query</li>
	 * 	<li>While Loop to iterate through all data and print results</li>
	 * 	<li>Create the Strings for each column</li>
	 * 	<li>Verify SyncStatus and SyncStatusXSite equals 2</li>
	 * 	<li>Verify The SyncDirection is correct for each Description</li>
	 * 	<li>handle any errors</li>
	 * 	<li>it is a good idea to release resources in a finally{} block</li>
	 * 	<li>if they are no-longer needed in reverse-order of their creation</li>
	 * 	<li>handle any errors</li>
	 * 	<li>Close the database connection</li>
	 * 	<li>Log test</li>
	 * 	<li>Go to Vendor Selection Settings</li>
	 * 	<li>Turn off Double-blind Communication switch</li>
	 * 	<li>Disable Automatic Vendor Selection</li>
	 * 	<li>Disable Unattended Order Assignment Selection</li>
	 * 	<li>Click switch On</li>
	 * 	<li>Disable Unattended Order Reassignment</li>
	 * 	<li>Select Custom Fee Panel</li>
	 * 	<li>Uncheck Use Mercury Network Directory as backup checkbox</li>
	 * 	<li>Verify Mercury Network Directory as backup is unchecked</li>
	 * 	<li>Save Preferences</li>
	 * 	<li>Click OK in saved dialog box</li>
	 * 	<li>Clear order information variables before placing a new order</li>
	 * 	<li>Login to VMP Client Portal</li>
	 * 	<li>Create a new order</li>
	 * 	<li>Set Property Information data</li>
	 * 	<li>StoredVariables.getpropertyInformationStateAbbr().set("OK");  Must set for a field check later on</li>
	 * 	<li>Set Assignment Information data</li>
	 * 	<li>Set Lender Information data</li>
	 * 	<li>Set Contact And Access Information data</li>
	 * 	<li>Set Additional Notification Recipients data</li>
	 * 	<li>Set Assigned person and pass it to StoredVariables</li>
	 * 	<li>Enter New Order data</li>
	 * 	<li>Click Next</li>
	 * 	<li>Confirm order screen loads</li>
	 * 	<li>Verify Vendor Information is correct</li>
	 * 	<li>Click back</li>
	 * 	<li>Verify the order info was not lost</li>
	 * 	<li>Click Next</li>
	 * 	<li>Check the order information again</li>
	 * 	<li>Click Next</li>
	 * 	<li>Get outside frames</li>
	 * 	<li>Get inside the attach document frame</li>
	 * 	<li>Select document type</li>
	 * 	<li>Click Close Button</li>
	 * 	<li>Switch back to the attach documents frame</li>
	 * 	<li>Click the OK button in the Order Placed dialog</li>
	 * 	<li>Verify you land on the orders grid</li>
	 * 	<li>Query the db to get the order number that was just created</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify the order just created is in the orders grid</li>
	 * 	<li>If browser is IE, set nativeEvents capability to false</li>
	 * 	<li>if (StoredVariables.getbrowser().get().equals("IE"))</li>
	 * 	<li>{</li>
	 * 	<li>perform.IE_setNativeEventsToFalse();</li>
	 * 	<li>}</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify order status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify History contains History (Requires assignment) in header</li>
	 * 	<li>Verify audit trail contains Requires assignment and Awaiting acceptance</li>
	 * 	<li>Verify order information</li>
	 * 	<li>Click Assign button</li>
	 * 	<li>Click Close on Related Orders popup</li>
	 * 	<li>Verify url contains VendorSelect</li>
	 * 	<li>Click on Fee Panel tab</li>
	 * 	<li>Verify Fee Panel tab is selected</li>
	 * 	<li>Select Automation Appraiser1</li>
	 * 	<li>Verify the appraiser is selected</li>
	 * 	<li>Click Next</li>
	 * 	<li>Verify Confirm Order url</li>
	 * 	<li>Agree to the fee notes</li>
	 * 	<li>Click Next</li>
	 * 	<li>Verify the order is in the Awaiting acceptance status</li>
	 * 	<li>Verify audit trail</li>
	 * 	<li>If browser is IE, set nativeEvents capability to false</li>
	 * 	<li>if (StoredVariables.getbrowser().get().equals("IE"))</li>
	 * 	<li>{</li>
	 * 	<li>perform.IE_reEstablishCapabilities();</li>
	 * 	<li>}</li>
	 * 	<li>Log in to VMP</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify the audit trail</li>
	 * 	<li>Verify the order details</li>
	 * 	<li>Click Other Actions</li>
	 * 	<li>Click Delayed</li>
	 * 	<li>Add notes</li>
	 * 	<li>Click OK</li>
	 * 	<li>Verify Update Complete text</li>
	 * 	<li>Click OK for Update Complete</li>
	 * 	<li>Verify history</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify delayed is in the history</li>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify order status</li>
	 * 	<li>Click on the order from the orders grid</li>
	 * 	<li>Verify status is Delayed</li>
	 * 	<li>Get order information text</li>
	 * 	<li>Verify audit trail</li>
	 * 	<li>Log in to VMP</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Click Other Actions</li>
	 * 	<li>Click Resume</li>
	 * 	<li>Add notes</li>
	 * 	<li>Click OK</li>
	 * 	<li>Verify Update Complete text</li>
	 * 	<li>Click OK for Update Complete</li>
	 * 	<li>Verify history</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify delayed is in the history</li>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify order status</li>
	 * 	<li>Click on the order from the orders grid</li>
	 * 	<li>Verify status is Resumed</li>
	 * 	<li>Get order information text</li>
	 * 	<li>Verify audit trail</li>
	 * 	<li>Log in to VMP</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Click Other Actions</li>
	 * 	<li>Click Place On Hold</li>
	 * 	<li>Add notes</li>
	 * 	<li>Click OK</li>
	 * 	<li>Verify Update Complete text</li>
	 * 	<li>Click OK for Update Complete</li>
	 * 	<li>Verify history</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify delayed is in the history</li>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify order status</li>
	 * 	<li>Click on the order from the orders grid</li>
	 * 	<li>Verify status is Delayed</li>
	 * 	<li>Get order information text</li>
	 * 	<li>Verify audit trail</li>
	 * 	<li>If browser is IE, set require window focus capability to false</li>
	 * 	<li>if (StoredVariables.getbrowser().get().equals("IE"))</li>
	 * 	<li>{</li>
	 * 	<li>perform.IE_setRequireWindowFocusToFalse();</li>
	 * 	<li>}</li>
	 * 	<li>Log in to VMP</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Click Attach Documents</li>
	 * 	<li>Get outside frames</li>
	 * 	<li>Get inside the attach document frame</li>
	 * 	<li>Select document type</li>
	 * 	<li>Upload Document</li>
	 * 	<li>Click Close Button</li>
	 * 	<li>Switch back to the attach documents frame</li>
	 * 	<li>Verify the document got attached</li>
	 * 	<li>Verify attached document name</li>
	 * 	<li>Verify uploaded by is correct</li>
	 * 	<li>Verify history</li>
	 * 	<li>If browser is IE, re-establish capabilites</li>
	 * 	<li>if (StoredVariables.getbrowser().get().equals("IE"))</li>
	 * 	<li>{</li>
	 * 	<li>perform.IE_reEstablishCapabilities();</li>
	 * 	<li>}</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify delayed is in the history</li>
	 * 	<li>Verify Document is in Documents</li>
	 * 	<li>Click on Sales Contract</li>
	 * 	<li>Verify file name and uploaded by</li>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify order status</li>
	 * 	<li>Click on the order from the orders grid</li>
	 * 	<li>Verify status is Delayed</li>
	 * 	<li>Get order information text</li>
	 * 	<li>Verify audit trail</li>
	 * 	<li>Verify Document is in Documents</li>
	 * 	<li>Click on Sales Contract</li>
	 * 	<li>Verify file name and uploaded by</li>
	 * 	<li>Log in to VMP</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Click Send Message</li>
	 * 	<li>Add notes</li>
	 * 	<li>Uncheck Action Required</li>
	 * 	<li>Click Send</li>
	 * 	<li>Verify Update Complete text</li>
	 * 	<li>Click OK for Send Complete</li>
	 * 	<li>Verify history</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify delayed is in the history</li>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify order status</li>
	 * 	<li>Click on the order from the orders grid</li>
	 * 	<li>Verify status is Delayed</li>
	 * 	<li>Get order information text</li>
	 * 	<li>Verify audit trail</li>
	 * 	<li>Log in to VMP</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Click Send Message</li>
	 * 	<li>Add notes</li>
	 * 	<li>Click Action Required checkbox</li>
	 * 	<li>Click Send</li>
	 * 	<li>Verify Update Complete text</li>
	 * 	<li>Click OK for Send Complete</li>
	 * 	<li>Verify history</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify delayed is in the history</li>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify order status</li>
	 * 	<li>Click on the order from the orders grid</li>
	 * 	<li>Verify status is Delayed</li>
	 * 	<li>Get order information text</li>
	 * 	<li>Verify audit trail</li>
	 * 	<li>Log in to VMP</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Click Other Actions</li>
	 * 	<li>Click Resume</li>
	 * 	<li>Add notes</li>
	 * 	<li>Click OK</li>
	 * 	<li>Verify Update Complete text</li>
	 * 	<li>Click OK for Update Complete</li>
	 * 	<li>Verify history</li>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify order status</li>
	 * 	<li>Click on the order from the orders grid</li>
	 * 	<li>Get order information text</li>
	 * 	<li>Verify audit trail</li>
	 * 	<li>View Order Details</li>
	 * 	<li>Click Accept/Decline button</li>
	 * 	<li>Enter notes</li>
	 * 	<li>Click OK</li>
	 * 	<li>Close Order Acknowledgement dialog</li>
	 * 	<li>Get order information text</li>
	 * 	<li>Set 40 second while loop timeout</li>
	 * 	<li>Verify audit trail</li>
	 * 	<li>Log in to VMP</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify history</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify delayed is in the history</li>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify order status</li>
	 * 	<li>Click on the order from the orders grid</li>
	 * 	<li>Click Set Order Status</li>
	 * 	<li>Click Delayed</li>
	 * 	<li>Enter Notes</li>
	 * 	<li>Click OK</li>
	 * 	<li>Get order information text</li>
	 * 	<li>Verify audit trail</li>
	 * 	<li>Log in to VMP</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify history</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify delayed is in the history</li>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify order status</li>
	 * 	<li>Click on the order from the orders grid</li>
	 * 	<li>Click Set Order Status</li>
	 * 	<li>Click Resume</li>
	 * 	<li>Enter Notes</li>
	 * 	<li>Click OK</li>
	 * 	<li>Get order information text</li>
	 * 	<li>Verify audit trail</li>
	 * 	<li>Log in to VMP</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify history</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify delayed is in the history</li>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify order status</li>
	 * 	<li>Click on the order from the orders grid</li>
	 * 	<li>Click Message</li>
	 * 	<li>Add notes</li>
	 * 	<li>Click OK button</li>
	 * 	<li>Get order information text</li>
	 * 	<li>Verify audit trail</li>
	 * 	<li>Log in to VMP</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify history</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify delayed is in the history</li>
	 * 	<li>If browser is IE, set require window focus capability to false</li>
	 * 	<li>if (StoredVariables.getbrowser().get().equals("IE"))</li>
	 * 	<li>{</li>
	 * 	<li>perform.IE_setRequireWindowFocusToFalse();</li>
	 * 	<li>}</li>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify order status</li>
	 * 	<li>Click on the order from the orders grid</li>
	 * 	<li>Click Attach Documents button</li>
	 * 	<li>Select document type</li>
	 * 	<li>Upload test pdf file</li>
	 * 	<li>Click Close Button</li>
	 * 	<li>Verify Report is in the Order Documents pane</li>
	 * 	<li>Get order information text</li>
	 * 	<li>Verify audit trail</li>
	 * 	<li>Click Sales Contract</li>
	 * 	<li>Verify Uploaded By and Document Name</li>
	 * 	<li>If browser is IE, re-establish capabilities</li>
	 * 	<li>if (StoredVariables.getbrowser().get().equals("IE"))</li>
	 * 	<li>{</li>
	 * 	<li>perform.IE_reEstablishCapabilities();</li>
	 * 	<li>}</li>
	 * 	<li>Log in to VMP</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify history</li>
	 * 	<li>Verify Document is in Documents</li>
	 * 	<li>Click on Sales Contract</li>
	 * 	<li>Verify file name and uploaded by</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify delayed is in the history</li>
	 * 	<li>Verify Document is in Documents</li>
	 * 	<li>Click on Sales Contract</li>
	 * 	<li>Verify file name and uploaded by</li>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify order status</li>
	 * 	<li>Click on the order from the orders grid</li>
	 * 	<li>Click Set Order Status</li>
	 * 	<li>Click Inspection Scheduled</li>
	 * 	<li>Click the calendar button</li>
	 * 	<li>Select date</li>
	 * 	<li>Verify the correct order due date is correct</li>
	 * 	<li>Add notes</li>
	 * 	<li>Click OK</li>
	 * 	<li>Verify Report is in the Order Documents pane</li>
	 * 	<li>Get order information text</li>
	 * 	<li>Verify audit trail</li>
	 * 	<li>Log in to VMP</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify history</li>
	 * 	<li>Verify Document is in Documents</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify delayed is in the history</li>
	 * 	<li>Verify Document is in Documents</li>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify order status</li>
	 * 	<li>Click on the order from the orders grid</li>
	 * 	<li>Click Set Order Status</li>
	 * 	<li>Click Inspection Complete</li>
	 * 	<li>Click the calendar button</li>
	 * 	<li>Select date</li>
	 * 	<li>Verify the correct order due date is correct</li>
	 * 	<li>Add notes</li>
	 * 	<li>Click OK</li>
	 * 	<li>Verify Report is in the Order Documents pane</li>
	 * 	<li>Get order information text</li>
	 * 	<li>Verify audit trail</li>
	 * 	<li>Log in to VMP</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify history</li>
	 * 	<li>Verify Document is in Documents</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify delayed is in the history</li>
	 * 	<li>Verify Document is in Documents</li>
	 * 	<li>If browser is IE, set require window focus capability to false</li>
	 * 	<li>if (StoredVariables.getbrowser().get().equals("IE"))</li>
	 * 	<li>{</li>
	 * 	<li>perform.IE_setRequireWindowFocusToFalse();</li>
	 * 	<li>}</li>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify order status</li>
	 * 	<li>Click on the order from the orders grid</li>
	 * 	<li>Complete the order using the HTTP Post</li>
	 * 	<li>Verify Report is in the Order Documents pane</li>
	 * 	<li>Get order information text</li>
	 * 	<li>Verify audit trail</li>
	 * 	<li>Click Sales Contract</li>
	 * 	<li>Verify Uploaded By and Document Name</li>
	 * 	<li>If browser is IE, re-establish capabilites</li>
	 * 	<li>if (StoredVariables.getbrowser().get().equals("IE"))</li>
	 * 	<li>{</li>
	 * 	<li>perform.IE_reEstablishCapabilities();</li>
	 * 	<li>}</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify order status</li>
	 * 	<li>Open order</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify delayed is in the history</li>
	 * 	<li>Verify Document is in Documents</li>
	 * 	<li>Click on Sales Contract</li>
	 * 	<li>Verify file name and uploaded by</li>
	 * 	<li>Log in to VMP</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify order status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify history</li>
	 * 	<li>Verify Document is in Documents</li>
	 * 	<li>Click on Sales Contract</li>
	 * 	<li>Verify file name and uploaded by</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify order status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Select Request vendor make revisions to this report</li>
	 * 	<li>Enter comments to vendor</li>
	 * 	<li>Check Update status on VMP XSite and notify client</li>
	 * 	<li>Click OK</li>
	 * 	<li>Log in to VMP</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify order status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify history</li>
	 * 	<li>Verify Document is in Documents</li>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify order status</li>
	 * 	<li>Click on the order from the orders grid</li>
	 * 	<li>Verify Report is in the Order Documents pane</li>
	 * 	<li>Get order information text</li>
	 * 	<li>Verify audit trail</li>
	 * 	<li>Uncheck Pending Quality Review</li>
	 * 	<li>Uncheck VMP Message arrow</li>
	 * 	<li>Uncheck Mercury Message arrow</li>
	 * 	<li>Click Save</li>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify order status</li>
	 * 	<li>Click on the order from the orders grid</li>
	 * 	<li>Verify Report is in the Order Documents pane</li>
	 * 	<li>Get order information text</li>
	 * 	<li>Verify audit trail</li>
	 * 	<li>View Order Details</li>
	 * 	<li>If browser is IE, set require window focus capability to false</li>
	 * 	<li>if (StoredVariables.getbrowser().get().equals("IE"))</li>
	 * 	<li>{</li>
	 * 	<li></li>
	 * 	<li>perform.IE_setRequireWindowFocusToFalse();</li>
	 * 	<li></li>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>vendors.login(driver, "Appraiser1", StoredVariables.getpassword().get());</li>
	 * 	<li></li>
	 * 	<li>Search for order</li>
	 * 	<li>vendors.findOrder(driver, StoredVariables.getorderNumber().get(), "Tracking Number");</li>
	 * 	<li></li>
	 * 	<li>Verify order status</li>
	 * 	<li>Assert.assertTrue(VOrders.ordersGrid_txt(driver).getText().contains("Revision Needed"), "The order is not in the correct status");</li>
	 * 	<li></li>
	 * 	<li>Click on the order from the orders grid</li>
	 * 	<li>perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());</li>
	 * 	<li></li>
	 * 	<li>perform.waitForElementToBeVisible(driver, VOrderDetails.sendMessage_btn(), "cssSelector");</li>
	 * 	<li></li>
	 * 	<li>Complete the order using the HTTP Post</li>
	 * 	<li>Verify Report is in the Order Documents pane</li>
	 * 	<li>Get order information text</li>
	 * 	<li>Verify audit trail</li>
	 * 	<li>Click Sales Contract</li>
	 * 	<li>Verify Uploaded By and Document Name</li>
	 * 	<li>If browser is IE, re-establish capabilites</li>
	 * 	<li>if (StoredVariables.getbrowser().get().equals("IE"))</li>
	 * 	<li>{</li>
	 * 	<li>perform.IE_reEstablishCapabilities();</li>
	 * 	<li>}</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify order status</li>
	 * 	<li>Open order</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify delayed is in the history</li>
	 * 	<li>Verify Document is in Documents</li>
	 * 	<li>Click on Sales Contract</li>
	 * 	<li>Verify file name and uploaded by</li>
	 * 	<li>Log in to VMP</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify order status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify history</li>
	 * 	<li>Verify Document is in Documents</li>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify order status</li>
	 * 	<li>Click on the order from the orders grid</li>
	 * 	<li>Click Message</li>
	 * 	<li>Add notes</li>
	 * 	<li>Click Send button</li>
	 * 	<li>Verify Report is in the Order Documents pane</li>
	 * 	<li>Get order information text</li>
	 * 	<li>Verify audit trail</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify order status</li>
	 * 	<li>Open order</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify delayed is in the history</li>
	 * 	<li>Verify Document is in Documents</li>
	 * 	<li>Log in to VMP</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify order status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify history</li>
	 * 	<li>Verify Document is in Documents</li>
	 * 	<li>Verify the order details</li>
	 * 	<li>Click Send Message</li>
	 * 	<li>Add notes</li>
	 * 	<li>Uncheck Action Required</li>
	 * 	<li>Click Send</li>
	 * 	<li>Verify Update Complete text</li>
	 * 	<li>Click OK for Send Complete</li>
	 * 	<li>Verify history</li>
	 * 	<li>Verify Document is in Documents</li>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify order status</li>
	 * 	<li>Click on the order from the orders grid</li>
	 * 	<li>Verify Report is in the Order Documents pane</li>
	 * 	<li>Get order information text</li>
	 * 	<li>Verify audit trail</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify order status</li>
	 * 	<li>Open order</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify delayed is in the history</li>
	 * 	<li>Verify Document is in Documents</li>
	 * 	<li>Log test</li>
* </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - VMP XSite Settings", "Secure - Configure Status Mapping", "Secure - Compliance Certificate", "Secure - Vendor Selection Settings", 
			"VMP - Create Order", "VMP - Orders", "Secure - Orders", "Secure - Require Reassignment", "VMP - Other Actions", "VMP - Delayed", "VMP - Resume", "VMP - Place On Hold", "VMP - Send Message", "Vendors - Orders", 
			"Vendors - Accept Order", "Vendors - Set Order Status", "Vendors - Delayed", "Vendors - Resume", "Vendors - Send Message", "Vendors - Inspection Scheduled", "Vendors - Inspection Complete", "Secure - Request Revision", 
			"Vendors - Complete Order"}, alwaysRun=true)
	public void order1() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Log in to secure
		secure.login(driver, "VMP1", StoredVariables.getpassword().get());
		
		// Go to VMP XSite settings
		secure.goToVMPXSites(driver);
		
		// Verify the dropdown is the correct VMP site
		secure.verifyXSiteURLDropdownValue(driver, "VMP1");
		
		perform.click(driver,SVMPXSites.configureStatusMapping_lnk(driver));
		
		perform.waitForElementToBeVisible(driver, SVMPXSites.statusMappingConfiguration_txt(), "id");
		
		perform.enableAllOptionsInStatusMappingConfiguration(driver);
		
		perform.click(driver,SVMPXSites.documentUploadedAppraiserClientGearIcon_btn(driver));
		
		perform.waitForOverlayToBeVisible(driver);
		
		// Check every option for syncing
		perform.enableAllCheckboxesToSyncToVMP(driver);

		// Click OK
		perform.click(driver,SVMPXSites.okSyncToVMPCheckboxesClient_btn(driver));
		
		// Click Save
		perform.clickInTable_Contains(driver, "Save");
		
		// Wait for save dialog to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for save dialog to be hidden 
		perform.waitForOverlayToBeHidden(driver);
		
		System.out.println("Verifying the database values");
		
		// Get the AWSAccountsID
		String getAWSAccountsIDSQL = "SELECT AWSAccountsID FROM ULSAccounts u JOIN Entities e ON u.AppraiserEntityID = e.EntityID "
				+ "WHERE CompanyName = 'Automation" + StoredVariables.getenvironment().get() + "VMP1' AND EntityTypeID = 1";		
		StoredVariables.getAWSAccountsID().set(db.queryDB(driver, "Mercury", getAWSAccountsIDSQL));
		
		// Set the DB Connection String
		String dbUrl = perform.setDBConnectionString(driver, "Mercury");
		
		// Get sync statuses
		String getSyncStatusSQL = "SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED SELECT UA.SyncStatus, UA.SyncStatusXSite, LS.[Description], "
				+ "CASE SSP.SyncFromBitMask WHEN 0 THEN 'Does Not Sync' WHEN 1 THEN 'Sync To VMP XSite' WHEN 2 THEN 'Sync to Mercury' "
				+ "WHEN 3 THEN 'Sync to Both' END AS 'SyncDirection' FROM Mercury.dbo.ULS_StatusSyncPrefs SSP JOIN Mercury.dbo.ListStatus LS "
				+ "ON LS.ListStatusID = SSP.ListStatusID JOIN Mercury.dbo.ULSAccounts UA ON UA.AppraiserEntityID = SSP.AppraiserEntityID "
				+ "WHERE 1=1 AND UA.AWSAccountsID = '" + StoredVariables.getAWSAccountsID().get() + "'";
		
		//Load the required JDBC Driver class
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
		
	 	Connection conn = null;
	 	
	 	try {
	 	    	conn = DriverManager.getConnection(dbUrl);

			 	Statement stmt = null;
			 	ResultSet rs = null;

			 	try
			 	{
			 	  	stmt = conn.createStatement();
			 	   
				    // Execute the sql query
				    rs = stmt.executeQuery(getSyncStatusSQL);
				    
	         		// While Loop to iterate through all data and print results		
					while (rs.next()){

						// Create the Strings for each column
						String SyncStatus = rs.getString(1);
	                    String SyncStatusXSite = rs.getString(2);
	                    String Description = rs.getString(3);
	                    String SyncDirection = rs.getString(4);
	                    
	            		// Verify SyncStatus and SyncStatusXSite equals 2
	            		Assert.assertTrue(SyncStatus.equals("2"), "SyncStatus in the database does not equal 2 for " + Description + " - SyncStatus = " + SyncStatus);
	            		Assert.assertTrue(SyncStatusXSite.equals("2"), "SyncStatusXSite in the database does not equal 2  for " + Description + " - SyncStatusXSite = " + SyncStatusXSite);
	            		
	            		// Verify The SyncDirection is correct for each Description
	            		if (Description.equals("Vendor Accepted Assignment")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite");}
	            		if (Description.equals("Inspection Scheduled")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite");}
	            		if (Description.equals("Inspection Complete")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite");}
	            		if (Description.equals("Delayed")){Assert.assertTrue(SyncDirection.equals("Sync to Both"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync to Both");}
	            		if (Description.equals("On Hold")){Assert.assertTrue(SyncDirection.equals("Sync to Mercury"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync to Mercury");}
	            		if (Description.equals("Resumed")){Assert.assertTrue(SyncDirection.equals("Sync to Both"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync to Both");}
	            		if (Description.equals("Document Uploaded")){Assert.assertTrue(SyncDirection.equals("Sync to Both"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync to Both");}
	            		if (Description.equals("Order Changed")){Assert.assertTrue(SyncDirection.equals("Sync to Mercury"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync to Mercury");}
	            		if (Description.equals("Cancelled")){Assert.assertTrue(SyncDirection.equals("Sync to Both"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync to Both");}
	            		if (Description.equals("Pending Quality Review")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite");}
	            		if (Description.equals("Revision Needed")){Assert.assertTrue(SyncDirection.equals("Sync to Mercury"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync to Mercury");}
	            		if (Description.equals("Revision Request Cancelled")){Assert.assertTrue(SyncDirection.equals("Sync to Mercury"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync to Mercury");}
	            		if (Description.equals("Copy of Completed Appraisal E-mailed to Borrower")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite");}
	            		if (Description.equals("Appraisal Viewed by {0}")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite");}
	            		if (Description.equals("{0} <b>declined</b> to receive the appraisal electronically")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite");}
	            		if (Description.equals("{0} consented to receive the appraisal electronically")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite");}
	            		if (Description.equals("SureReceipts delivery to Borrower scheduled")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite");}
	            		if (Description.equals("Update Disclosure Date")){Assert.assertTrue(SyncDirection.equals("Sync to Mercury"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync to Mercury");}
	            		if (Description.equals("Appraisal Submitted to {0} via UCDP")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite");}
	            		if (Description.equals("Appraisal Submission Accepted by {0} via UCDP")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite");}
	            		if (Description.equals("Appraisal Submission to {0} Not Successful")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite");}
	            		if (Description.equals("UCDP Document File ID Updated")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite");}
	            		if (Description.equals("UCDP Status Removed")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite");}
	            		if (Description.equals("AQI results returned ")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite");}
	            		if (Description.equals("Appraisal Submitted to FHA via EAD")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite");}
	            		if (Description.equals("Appraisal Submission Accepted by FHA via EAD")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite");}
	            		if (Description.equals("Appraisal Submission to FHA Not Successful")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite");}
	            		if (Description.equals("FHA Document File ID Updated")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite");}
	            		if (Description.equals("FHA Status Removed")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite");}
	            		if (Description.equals("Message")){Assert.assertTrue(SyncDirection.equals("Sync to Both"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync to Both");}
	            		if (Description.equals("Comment - Action Required")){Assert.assertTrue(SyncDirection.equals("Sync to Mercury"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync to Mercury");}
	            		if (Description.equals("Conditionally Declined")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite");}

					} // end while loop
				    
			 	} // end try
			 	catch (SQLException ex)
			 	{
			 	    // handle any errors
			 	    System.out.println("SQLException: " + ex.getMessage());
			 	    System.out.println("SQLState: " + ex.getSQLState());
			 	    System.out.println("VendorError: " + ex.getErrorCode());
			 	} // end catch
			 	finally {
			 	    // it is a good idea to release resources in a finally{} block
			 	    // if they are no-longer needed in reverse-order of their creation
			 	    if (rs != null) {
			 	        try {
			 	            rs.close();
			 	        } catch (SQLException sqlEx) { } // ignore
		
			 	        rs = null;
			 	    } // end if
		
			 	    if (stmt != null) {
			 	        try {
			 	            stmt.close();
			 	        } catch (SQLException sqlEx) { } // ignore
		
			 	        stmt = null;
			 	    } // end if
			 	} // end finally
	 	
	 	} catch (SQLException ex) {
	 	    // handle any errors
	 	    System.out.println("SQLException: " + ex.getMessage());
	 	    System.out.println("SQLState: " + ex.getSQLState());
	 	    System.out.println("VendorError: " + ex.getErrorCode());
	 	} // end catch
	 	
		// Close the database connection
		conn.close();
		
		// Log test
		test.log(LogStatus.INFO, "ULS Orders", "Database values for syncing are correct");
		
		// Wait for the Preferences button to be visible
		perform.waitForElementToBeClickable(driver, SOrders.preferences_btn(), "id");

		// Go to Vendor Selection Settings
		secure.goToVendorSelectionSettings(driver);
		
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
		
		// Disable Unattended Order Assignment Selection
		if (SVendorSelectionSettings.unattendedOrderAssignment_switch(driver).getAttribute("src").contains("switchOn.png"))
		{
			// Click switch On
			perform.click(driver,SVendorSelectionSettings.unattendedOrderAssignment_switch(driver));
		}
		
		// Disable Unattended Order Reassignment
		if (SVendorSelectionSettings.unattendedOrderReassignment_switch(driver).getAttribute("src").contains("switchOn.png"))
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
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for the OK button to be visible
		perform.waitForElementToBeClickable(driver, SVendorSelectionSettings.ok_btn(), "id");
		
		// Click OK in saved dialog box
		perform.click(driver,SVendorSelectionSettings.ok_btn(driver));

		// Clear order information variables before placing a new order
		perform.clearOrderInfoStoredVariables(driver);
		
		// Login to VMP Client Portal
		vmp.login(driver, "VMP1", "OriginatorVMP1", StoredVariables.getpassword().get());
		
		// Create a new order
		vmp.goToNewOrder(driver);
		
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
		StoredVariables.getassignmentInformationAssignedTo().set("Automation OriginatorVMP1");
		
		// Enter New Order data
		vmp.enterNewOrder(driver);

		// Click Next
		perform.click(driver,VMPNewOrder.nextBottom_btn(driver));
		
		Thread.sleep(1000);
		
		/***********************************************
		 * Confirm Order Page
		 ***********************************************/

		// Wait for the back button
		perform.waitForElementToBeClickable(driver, VMPConfirmOrder.backTop_btn(), "id");
		
		// Confirm order screen loads
		Assert.assertTrue(driver.getCurrentUrl().contains("OrderConfirm"), "Order page did not load");
		
		// Verify Vendor Information is correct
		/***********************************************************************
		 * NEED TO PARSE OUT THE VENDORID FROM THE SOURCE CODE AND LOOK IT UP
		 * IN THE DATABASE TO MATCH THE INFORMATION
		 ***********************************************************************/
		int lineNumber = new Exception().getStackTrace()[0].getLineNumber();
		String thisClass = new Exception().getStackTrace()[0].getClassName();
		String thisMethod = new Exception().getStackTrace()[0].getMethodName();
		System.out.println("Line #" + lineNumber + " - " + thisClass + "." + thisMethod + " ***** Need to parse out the vendorid from the source code and look it up in the db to verify vendor info");
		
		vmp.verifyOrderDetails(driver);
		
		// Click back
		perform.click(driver,VMPConfirmOrder.backTop_btn(driver));
		
		// Verify the order info was not lost
		vmp.verifyNewOrderInfo(driver);
		
		// Wait for Next button
		perform.waitForElementToBeClickable(driver, VMPNewOrder.nextBottom_btn(), "id");
		
		// Click Next
		perform.click(driver,VMPNewOrder.nextBottom_btn(driver));
		
		Thread.sleep(1500);
		
		// Check the order information again
		vmp.verifyOrderDetails(driver);
		
		// Wait for Next button
		perform.waitForElementToBeClickable(driver, VMPConfirmOrder.nextTop_btn(), "id");
		
		// Click Next
		perform.click(driver,VMPConfirmOrder.nextTop_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		Thread.sleep(3500);
		
		// Wait for Frames
		perform.waitForIFrames(driver);
		
		// Get outside frames
		driver.switchTo().defaultContent();
		// Get inside the attach document frame
		driver.switchTo().frame("iframeAttach");
		
		// Wait for message text
		perform.waitForElementToBeClickable(driver, VMPConfirmOrder.uploadDocuments_btn(), "id");
		
		// Select document type
		perform.selectDropdownOption(driver, VMPConfirmOrder.documentType_dropdown(driver), "Other");
		
		// Click Close Button
		perform.click(driver,VMPConfirmOrder.finished_btn(driver));
		
		// Switch back to the attach documents frame
		driver.switchTo().defaultContent();
		
		// Wait for the OK button in the Order Placed dialog
		perform.waitForElementToBeClickable(driver, VMPConfirmOrder.ok_btn(), "cssSelector");
		
		// Click the OK button in the Order Placed dialog
		perform.click(driver,VMPConfirmOrder.ok_btn(driver));
		
		// Wait for the Find textbox
		perform.waitForElementToBeClickable(driver, VMPOrders.find_txtbx(), "id");
		
		// Verify you land on the orders grid
		Assert.assertTrue(driver.getCurrentUrl().contains("OrderManagement"), "After completing an order, the orders grid did not load");
		
		// Query the db to get the order number that was just created
		db.getLoanIDsFromVMPClientPortalOrder(driver);

		// Search for order
		vmp.findOrder(driver, StoredVariables.getloanIDVMP().get(), "Tracking #");
		
		// Verify the order just created is in the orders grid 
		Assert.assertTrue(VMPOrders.ordersTable(driver).getText().contains(StoredVariables.getAWSAccountsID().get() + "-" + StoredVariables.getloanIDVMP().get()), "New order is not displayed");
		
		db.verifyNewOrderDataInDB_All(driver, StoredVariables.getloanIDVMP().get());
		
		// Log in to Secure
		secure.login(driver, "VMP1", StoredVariables.getpassword().get());
		
		// Wait for Find text box
		perform.waitForElementToBeClickable(driver, SOrders.find_txtbx(), "id");
		
		// Search for order
		secure.findOrder(driver, StoredVariables.getloanID().get(), "Tracking number");
		
		// Wait for orderStatus text
		perform.waitForElementToBeClickable(driver, SOrders.orderStatus_txt(), "cssSelector");
		
		// Verify order status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().contains("Requires assignment"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getAWSAccountsID().get() + "-" + StoredVariables.getloanID().get());
		
		// Wait for Assign button
		perform.waitForElementToBeClickable(driver, SOrderDetails.assign_btn(), "id");
		
		// Verify History contains History (Requires assignment) in header
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("History (Requires assignment)"), "The order is not in the correct status - Requires assignment");
		
		// Verify audit trail contains Requires assignment and Awaiting acceptance
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("Requires assignment"), "Requires assignment is missing from the audit trail");
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("Awaiting acceptance"), "Awaiting acceptance is missing from the audit trail");
		
		// Verify order information
		secure.verifyResidentialAppraisalOrderDetails(driver);
		
		// Click Assign button
		perform.click(driver,SOrderDetails.assign_btn(driver));
		
		Thread.sleep(4000);
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Click Close on Related Orders popup
		secure.checkForRelatedOrdersDialog(driver);
		
		// Verify url contains VendorSelect
		Assert.assertTrue(driver.getCurrentUrl().contains("VendorSelect"), "The url does not contain VendorSelect");
		
		// Wait for Fee Panel tab button
		perform.waitForElementToBeClickable(driver, SVendorSelection.feePanelTab_tab(), "id");
		
		// Click on Fee Panel tab
		perform.click(driver,SVendorSelection.feePanelTab_tab(driver));
		
		// Verify Fee Panel tab is selected
		if (!SVendorSelection.feePanelTab_tab(driver).getAttribute("class").contains("Selected"))
		{
			perform.click(driver,SVendorSelection.feePanelTab_tab(driver));
		}
		Assert.assertTrue(SVendorSelection.feePanelTab_tab(driver).getAttribute("class").contains("Selected"), "Fee Panel is not selected and should be");
		
		// Select Automation Appraiser1
		perform.clickInTable_Contains(driver, "Automation Appraiser1");
		
		// Verify the appraiser is selected
		Assert.assertTrue(SVendorSelection.feePanelSelectFirstRow_btn(driver).getAttribute("src").contains("/images/Checkmark-Small-Checked-Blue.O.png"), "Vendor is not selected");	
		
		// Click Next
		perform.click(driver,SVendorSelection.nextTop_btn(driver));
		
		// Wait for Fee Notes checkbox to be clickable
		perform.waitForElementToBeClickable(driver, SConfirmOrder.readVendorsFeeNotes_chkbx(), "id");
		
		// Verify Confirm Order url
		Assert.assertTrue(driver.getCurrentUrl().contains("ConfirmOrder"), "The Confirm Order screen did not load properly");
		
		secure.verifyReassignResidentialAppraisalOrderDetails(driver);
		
		// Agree to the fee notes
		perform.click(driver,SConfirmOrder.readVendorsFeeNotes_chkbx(driver));
		
		// Click Next
		perform.click(driver,SConfirmOrder.nextBottom_btn(driver));
		
		// Wait for page to load
		perform.waitForElementToBeClickable(driver, SOrders.orders_btn(), "cssSelector");
		
		// Verify the order is in the Awaiting acceptance status
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		String historyText = SOrderDetails.history_txt(driver).getText();
		Assert.assertTrue(historyText.contains("History (Awaiting acceptance"), "The order is not in Awaiting acceptance status");
		
		// Verify audit trail
		Assert.assertTrue(historyText.contains("Awaiting acceptance by Automation Appraiser1"), "Awaiting acceptance by Automation Appraiser1 is missing from the audit trail");
		Assert.assertTrue(historyText.contains("Reassigned by Client (Automation VMP1) to Automation Appraiser1"), "Reassigned by Client (Automation VMP1) to Automation Appraiser1 is missing from the audit trail");
		Assert.assertTrue(historyText.contains("Requires assignment"), "Requires assignment is missing from the audit trail");
		Assert.assertTrue(historyText.contains("Awaiting acceptance"), "Awaiting acceptance is missing from the audit trail");

		// Log in to VMP
		vmp.login(driver, "VMP1", "OriginatorVMP1", StoredVariables.getpassword().get());
		
		// Search for order
		vmp.findOrder(driver, StoredVariables.getloanIDVMP().get(), "Tracking #");
		
		// Verify Order Status
		Assert.assertTrue(VMPOrders.orderStatus_txt(driver).getText().equals("In Progress"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getAWSAccountsID().get() + "-" + StoredVariables.getloanIDVMP().get());
		
		Thread.sleep(1500);
		
		// Wait for Edit Property Contacts link
		perform.waitForElementToBeClickable(driver, VMPAppraisalOrderDetails.editPropertyContacts_lnk(), "id");
		
		// Verify the audit trail
		Assert.assertTrue(VMPAppraisalOrderDetails.history_txt(driver).getText().contains("In Progress by Automation OriginatorVMP1"), "In Progress by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(VMPAppraisalOrderDetails.areaBelowHistory_txt(driver).getText().contains("For compliance exams, every order event is recorded here for your protection."), "For compliance exams, every order event is recorded here for your protection is missing from the audit trail");
		
		// Verify the order details
		vmp.verifyAppraisalOrderDetailsWithNoXML(driver);

		// Click Other Actions
		perform.click(driver,VMPAppraisalOrderDetails.otherActions_btn(driver));
		
		// Click Delayed
		perform.click(driver,VMPAppraisalOrderDetails.delayed_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, VMPAppraisalOrderDetails.delayedOk_btn(), "cssSelector");
		
		// Add notes
		perform.type(driver,VMPAppraisalOrderDetails.delayedNotes_txtbx(driver), "These are Delayed test notes from OriginatorVMP1");
		
		// Click OK
		perform.click(driver,VMPAppraisalOrderDetails.delayedOk_btn(driver));
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, VMPAppraisalOrderDetails.alertDialogOk_btn(), "cssSelector");
		
		// Verify Update Complete text
		Assert.assertTrue(VMPAppraisalOrderDetails.alertDialog_txt(driver).getText().equals("The status of the order has been updated."), "The Update Complete dialog box text is incorrect");
		
		// Click OK for Update Complete
		perform.click(driver,VMPAppraisalOrderDetails.alertDialogOk_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Verify history
		String history = VMPAppraisalOrderDetails.history_txt(driver).getText();
		Assert.assertTrue(history.contains("Delayed by Automation OriginatorVMP1"), "Delayed by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorVMP"), "These are Delayed test notes from OriginatorVMP is missing from the audit trail");
		Assert.assertTrue(history.contains("In Progress by Automation OriginatorVMP1"), "In Progress by Automation OriginatorVMP1 is missing from the audit trail");

		// Log in to Secure
		secure.login(driver, "VMP1", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, StoredVariables.getloanID().get(), "Tracking number");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("Awaiting acceptance"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getAWSAccountsID().get() + "-" + StoredVariables.getloanID().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify delayed is in the history
		Assert.assertTrue(history.contains("History (Awaiting acceptance)"), "History (Awaiting acceptance) is missing from the order information");
		Assert.assertTrue(history.contains("Delayed by Client (Automation VMP1)"), "Delayed by Client (Automation VMP1) status did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorVMP1"), "These are Delayed test notes from OriginatorVMP1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser1"), "Awaiting acceptance by Automation Appraiser1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Reassigned by Client (Automation VMP1) to Automation Appraiser1"), "Reassigned by Client (Automation VMP1) to Automation Appraiser1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Requires assignment"), "Requires assignment did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Awaiting acceptance"), "Awaiting acceptance did not sync from VMP to Secure");
		
		// Log in to Vendors
		vendors.login(driver, "Appraiser1", StoredVariables.getpassword().get());
		
		// Search for order
		vendors.findOrder(driver, StoredVariables.getloanID().get(), "Tracking Number");
		
		// Verify order status
		Assert.assertTrue(VOrders.ordersGrid_txt(driver).getText().contains("Awaiting acceptance"), "The order is not in the correct status");
		
		// Click on the order from the orders grid
		perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, VOrderDetails.orderInformation_txt(), "id");
		
		// Verify status is Delayed
		Assert.assertTrue(VOrderDetails.historyHeader_txt(driver).getText().contains(""), "The Delayed status did not sync from the VMP to Vendors");
		
		// Get order information text
		String orderInformation = VOrderDetails.orderInformation_txt(driver).getText();
		
		// Verify audit trail
		Assert.assertTrue(orderInformation.contains("History (Awaiting acceptance)"), "History (Awaiting acceptance) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Delayed by Client (Automation VMP1)"), "Delayed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Delayed test notes from OriginatorVMP1"), "These are Delayed test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Awaiting acceptance by Automation Appraiser1"), "Awaiting acceptance by Automation Appraiser1 is missing from the order information");

		// Log in to VMP
		vmp.login(driver, "VMP1", "OriginatorVMP1", StoredVariables.getpassword().get());
		
		// Search for order
		vmp.findOrder(driver, StoredVariables.getloanIDVMP().get(), "Tracking #");
		
		// Verify Order Status
		Assert.assertTrue(VMPOrders.orderStatus_txt(driver).getText().equals("Delayed"), "The order is not in the correct status");
		
		// Open order
		perform.clickInTable_Contains(driver, StoredVariables.getAWSAccountsID().get() + "-" + StoredVariables.getloanIDVMP().get());
		
		// Click View Order
		perform.click(driver, VMPOrders.viewOrder_btn(driver));
		
		// Wait for Other Actions button
		perform.waitForElementToBeVisible(driver, VMPAppraisalOrderDetails.otherActions_btn(), "cssSelector");
		
		// Click Other Actions
		perform.click(driver,VMPAppraisalOrderDetails.otherActions_btn(driver));
		
		// Click Resume
		perform.click(driver,VMPAppraisalOrderDetails.resume_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, VMPAppraisalOrderDetails.resumeOk_btn(), "cssSelector");
		
		// Add notes
		perform.type(driver,VMPAppraisalOrderDetails.resumeNotes_txtbx(driver), "These are Resume test notes from OriginatorVMP1");
		
		// Click OK
		perform.click(driver,VMPAppraisalOrderDetails.resumeOk_btn(driver));
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, VMPAppraisalOrderDetails.alertDialogOk_btn(), "cssSelector");
		
		// Verify Update Complete text
		Assert.assertTrue(VMPAppraisalOrderDetails.alertDialog_txt(driver).getText().equals("The status of the order has been updated."), "The Update Complete dialog box text is incorrect");
		
		// Click OK for Update Complete
		perform.click(driver,VMPAppraisalOrderDetails.alertDialogOk_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Verify history
		history = VMPAppraisalOrderDetails.history_txt(driver).getText();
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorVMP1"), "Resumed by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorVMP1"), "These are Resume test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation OriginatorVMP1"), "Delayed by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorVMP1"), "These are Delayed test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("In Progress by Automation OriginatorVMP1"), "In Progress by Automation OriginatorVMP1 is missing from the audit trail");

		// Log in to Secure
		secure.login(driver, "VMP1", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, StoredVariables.getloanID().get(), "Tracking number");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("Awaiting acceptance"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getAWSAccountsID().get() + "-" + StoredVariables.getloanID().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify delayed is in the history
		Assert.assertTrue(history.contains("History (Awaiting acceptance)"), "History (Awaiting acceptance) is missing from the order information");
		Assert.assertTrue(history.contains("Resumed by Client (Automation VMP1)"), "Resumed by Client (Automation VMP1) did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorVMP1"), "These are Resume test notes from OriginatorVMP1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Delayed by Client (Automation VMP1)"), "Delayed by Client (Automation VMP1) status did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorVMP1"), "These are Delayed test notes from OriginatorVMP1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser1"), "Awaiting acceptance by Automation Appraiser1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Reassigned by Client (Automation VMP1) to Automation Appraiser1"), "Reassigned by Client (Automation VMP1) to Automation Appraiser1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Requires assignment"), "Requires assignment did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Awaiting acceptance"), "Awaiting acceptance did not sync from VMP to Secure");

		// Log in to Vendors
		vendors.login(driver, "Appraiser1", StoredVariables.getpassword().get());
		
		// Search for order
		vendors.findOrder(driver, StoredVariables.getloanID().get(), "Tracking Number");
		
		perform.waitForElementToBeVisible(driver, VOrders.ordersGrid_txt(), "id");
		
		// Verify order status
		Assert.assertTrue(VOrders.ordersGrid_txt(driver).getText().contains("Awaiting acceptance"), "The order is not in the correct status. --- " + VOrders.ordersGrid_txt(driver).getText());
		
		// Click on the order from the orders grid
		perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, VOrderDetails.orderInformation_txt(), "id");
		
		// Verify status is Resumed
		Assert.assertTrue(VOrderDetails.historyHeader_txt(driver).getText().contains(""), "The Resumed status did not sync from the VMP to Vendors");
		
		// Get order information text
		orderInformation = VOrderDetails.orderInformation_txt(driver).getText();
		
		// Verify audit trail
		Assert.assertTrue(orderInformation.contains("History (Awaiting acceptance)"), "History (Awaiting acceptance) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Resumed by Client (Automation VMP1)"), "Resumed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Resume test notes from OriginatorVMP1"), "These are Resume test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Delayed by Client (Automation VMP1)"), "Delayed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Delayed test notes from OriginatorVMP1"), "These are Delayed test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Awaiting acceptance by Automation Appraiser1"), "Awaiting acceptance by Automation Appraiser1 is missing from the order information");
		
		// Log in to VMP
		vmp.login(driver, "VMP1", "OriginatorVMP1", StoredVariables.getpassword().get());
		
		// Search for order
		vmp.findOrder(driver, StoredVariables.getloanIDVMP().get(), "Tracking #");
		
		// Verify Order Status
		Assert.assertTrue(VMPOrders.orderStatus_txt(driver).getText().equals("In Progress"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getAWSAccountsID().get() + "-" + StoredVariables.getloanIDVMP().get());
		
		// Wait for Other Actions button
		perform.waitForElementToBeVisible(driver, VMPAppraisalOrderDetails.otherActions_btn(), "cssSelector");
		
		// Click Other Actions
		perform.click(driver,VMPAppraisalOrderDetails.otherActions_btn(driver));
		
		// Click Place On Hold
		perform.click(driver,VMPAppraisalOrderDetails.placeOnHold_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, VMPAppraisalOrderDetails.placeOnHoldOk_btn(), "cssSelector");
		
		// Add notes
		perform.type(driver,VMPAppraisalOrderDetails.placeOnHoldNotes_txtbx(driver), "These are Place On Hold test notes from OriginatorVMP1");
		
		// Click OK
		perform.click(driver,VMPAppraisalOrderDetails.placeOnHoldOk_btn(driver));
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, VMPAppraisalOrderDetails.alertDialogOk_btn(), "cssSelector");
		
		// Verify Update Complete text
		Assert.assertTrue(VMPAppraisalOrderDetails.alertDialog_txt(driver).getText().equals("The status of the order has been updated."), "The Update Complete dialog box text is incorrect");
		
		// Click OK for Update Complete
		perform.click(driver,VMPAppraisalOrderDetails.alertDialogOk_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Verify history
		history = VMPAppraisalOrderDetails.history_txt(driver).getText();
		Assert.assertTrue(history.contains("On Hold by Automation OriginatorVMP1"), "On Hold by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorVMP1"), "These are Place On Hold test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorVMP1"), "Resumed by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorVMP1"), "These are Resume test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation OriginatorVMP1"), "Delayed by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorVMP1"), "These are Delayed test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("In Progress by Automation OriginatorVMP1"), "In Progress by Automation OriginatorVMP1 is missing from the audit trail");

		// Log in to Secure
		secure.login(driver, "VMP1", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, StoredVariables.getloanID().get(), "Tracking number");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("Awaiting acceptance"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getAWSAccountsID().get() + "-" + StoredVariables.getloanID().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify delayed is in the history
		Assert.assertTrue(history.contains("History (Awaiting acceptance)"), "History (Awaiting acceptance) is missing from the order information");
		Assert.assertTrue(history.contains("On Hold by Client (Automation VMP1)"), "On Hold by Client (Automation VMP1) did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorVMP1"), "These are Place On Hold test notes from OriginatorVMP1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Resumed by Client (Automation VMP1)"), "Resumed by Client (Automation VMP1) did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorVMP1"), "These are Resume test notes from OriginatorVMP1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Delayed by Client (Automation VMP1)"), "Delayed by Client (Automation VMP1) status did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorVMP1"), "These are Delayed test notes from OriginatorVMP1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser1"), "Awaiting acceptance by Automation Appraiser1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Reassigned by Client (Automation VMP1) to Automation Appraiser1"), "Reassigned by Client (Automation VMP1) to Automation Appraiser1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Requires assignment"), "Requires assignment did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Awaiting acceptance"), "Awaiting acceptance did not sync from VMP to Secure");

		// Log in to Vendors
		vendors.login(driver, "Appraiser1", StoredVariables.getpassword().get());
		
		// Search for order
		vendors.findOrder(driver, StoredVariables.getloanID().get(), "Tracking Number");
		
		// Verify order status
		Assert.assertTrue(VOrders.ordersGrid_txt(driver).getText().contains("Awaiting acceptance"), "The order is not in the correct status");
		
		// Click on the order from the orders grid
		perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, VOrderDetails.orderInformation_txt(), "id");
		
		// Verify status is Delayed
		Assert.assertTrue(VOrderDetails.historyHeader_txt(driver).getText().contains(""), "The Place On Hold status did not sync from the VMP to Vendors");
		
		// Get order information text
		orderInformation = VOrderDetails.orderInformation_txt(driver).getText();
		
		// Verify audit trail
		Assert.assertTrue(orderInformation.contains("History (Awaiting acceptance)"), "History (Awaiting acceptance) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("On Hold by Client (Automation VMP1)"), "On Hold by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Place On Hold test notes from OriginatorVMP1"), "These are Place On Hold test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Resumed by Client (Automation VMP1)"), "Resumed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Resume test notes from OriginatorVMP1"), "These are Resume test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Delayed by Client (Automation VMP1)"), "Delayed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Delayed test notes from OriginatorVMP1"), "These are Delayed test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Awaiting acceptance by Automation Appraiser1"), "Awaiting acceptance by Automation Appraiser1 is missing from the order information");
		
		// Log in to VMP
		vmp.login(driver, "VMP1", "OriginatorVMP1", StoredVariables.getpassword().get());
		
		// Search for order
		vmp.findOrder(driver, StoredVariables.getloanIDVMP().get(), "Tracking #");
		
		// Verify Order Status
		Assert.assertTrue(VMPOrders.orderStatus_txt(driver).getText().equals("On Hold"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getAWSAccountsID().get() + "-" + StoredVariables.getloanIDVMP().get());
		
		// Wait for Attach Documents button
		perform.waitForElementToBeVisible(driver, VMPAppraisalOrderDetails.attachDocuments_btn(), "cssSelector");
		
		// Click Attach Documents
		perform.click(driver,VMPAppraisalOrderDetails.attachDocuments_btn(driver));
		
		Thread.sleep(3500);
		
		// Wait for Frames
		perform.waitForIFrames(driver);
		
		// Get outside frames
		driver.switchTo().defaultContent();
		// Get inside the attach document frame
		driver.switchTo().frame("iframeAttach");
		
		// Wait for message text
		perform.waitForElementToBeClickable(driver, VMPConfirmOrder.uploadDocuments_btn(), "id");
		
		// Select document type
		perform.selectDropdownOption(driver, VMPConfirmOrder.documentType_dropdown(driver), "Other");
		
		// Wait for upload button
		perform.waitForElementToBeClickable(driver, VMPConfirmOrder.uploadDocuments_btn(), "id");
		
		// Upload Document
		String filePath = StoredVariables.getdocDir().get()+"Test PDF.pdf";
		vmp.uploadDocumentOnAppraisalOrderDetails(driver, filePath);
		
		// Click Close Button
		perform.click(driver,VMPConfirmOrder.finished_btn(driver));
		
		// Switch back to the attach documents frame
		driver.switchTo().defaultContent();
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Wait for Edit Property Contacts link
		perform.waitForElementToBeClickable(driver, VMPAppraisalOrderDetails.editPropertyContacts_lnk(), "id");
		
		// Verify the document got attached
		perform.clickInTable_Equals(driver, "Other");
		
		// Wait for open button
		perform.waitForElementToBeClickable(driver, VMPAppraisalOrderDetails.open_btn(), "id");
		
		// Verify attached document name
		Assert.assertTrue(VMPAppraisalOrderDetails.attachedDocumentName_txt(driver).getText().contains("Test PDF.pdf"), "The document didn't get uploaded. The name = " + VMPAppraisalOrderDetails.attachedDocumentName_txt(driver).getText());
		
		// Verify uploaded by is correct
		Assert.assertTrue(VMPAppraisalOrderDetails.attachedDocumentUploadedBy_txt(driver).getText().equals("Automation OriginatorVMP1"), "The Uploaded By name is incorrect. It is - " + VMPAppraisalOrderDetails.attachedDocumentUploadedBy_txt(driver).getText());
		
		// Verify history
		history = VMPAppraisalOrderDetails.history_txt(driver).getText();
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorVMP1"), "Document Uploaded by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Other"), "Other is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF.pdf"), "Test PDF.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Automation OriginatorVMP1"), "On Hold by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorVMP1"), "These are Place On Hold test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorVMP1"), "Resumed by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorVMP1"), "These are Resume test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation OriginatorVMP1"), "Delayed by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorVMP1"), "These are Delayed test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("In Progress by Automation OriginatorVMP1"), "In Progress by Automation OriginatorVMP1 is missing from the audit trail");
		
		// Log in to Secure
		secure.login(driver, "VMP1", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, StoredVariables.getloanID().get(), "Tracking number");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("Awaiting acceptance"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getAWSAccountsID().get() + "-" + StoredVariables.getloanID().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify delayed is in the history
		Assert.assertTrue(history.contains("History (Awaiting acceptance)"), "History (Awaiting acceptance) is missing from the order information");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation VMP1) (Test PDF.pdf)"), "Document Uploaded from Client (Automation VMP1) (Test PDF.pdf) is missing from the order information");
		Assert.assertTrue(history.contains("On Hold by Client (Automation VMP1)"), "On Hold by Client (Automation VMP1) did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorVMP"), "These are Place On Hold test notes from OriginatorVMP did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Resumed by Client (Automation VMP1)"), "Resumed by Client (Automation VMP1) did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorVMP1"), "These are Resume test notes from OriginatorVMP1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Delayed by Client (Automation VMP1)"), "Delayed by Client (Automation VMP1) status did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorVMP1"), "These are Delayed test notes from OriginatorVMP1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser1"), "Awaiting acceptance by Automation Appraiser1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Reassigned by Client (Automation VMP1) to Automation Appraiser1"), "Reassigned by Client (Automation VMP1) to Automation Appraiser1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Requires assignment"), "Requires assignment did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Awaiting acceptance"), "Awaiting acceptance did not sync from VMP to Secure");
		
		// Verify Document is in Documents
		String documentText = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Other"), "Other did not sync to Secure");
		
		// Click on Sales Contract
		perform.clickInTable_Equals(driver, "Other");
		
		// Wait for text to update
		perform.waitForText(driver, SOrderDetails.documents_txt(driver), "Test PDF.pdf");
		documentText = SOrderDetails.documents_txt(driver).getText();
		
		// Verify file name and uploaded by
		Assert.assertTrue(documentText.contains("Test PDF.pdf"), "Document name is incorrect in Documents");
		Assert.assertTrue(documentText.contains("Automation VMP1"), "Uploaded By is incorrect in Documents");

		// Log in to Vendors
		vendors.login(driver, "Appraiser1", StoredVariables.getpassword().get());
		
		// Search for order
		vendors.findOrder(driver, StoredVariables.getloanID().get(), "Tracking Number");
		
		// Verify order status
		Assert.assertTrue(VOrders.ordersGrid_txt(driver).getText().contains("Awaiting acceptance"), "The order is not in the correct status");
		
		// Click on the order from the orders grid
		perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, VOrderDetails.orderInformation_txt(), "id");
		
		// Verify status is Delayed
		Assert.assertTrue(VOrderDetails.historyHeader_txt(driver).getText().contains(""), "The Delayed status did not sync from the VMP to Vendors");
		
		// Get order information text
		orderInformation = VOrderDetails.orderInformation_txt(driver).getText();
		
		// Verify audit trail
		Assert.assertTrue(orderInformation.contains("History (Awaiting acceptance)"), "History (Awaiting acceptance) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Document Uploaded from Client (Automation VMP1) (Test PDF.pdf)"), "Document Uploaded from Client (Automation VMP1) (Test PDF.pdf) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("On Hold by Client (Automation VMP1)"), "On Hold by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Place On Hold test notes from OriginatorVMP"), "These are Place On Hold test notes from OriginatorVMP is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Resumed by Client (Automation VMP1)"), "Resumed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Resume test notes from OriginatorVMP1"), "These are Resume test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Delayed by Client (Automation VMP1)"), "Delayed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Delayed test notes from OriginatorVMP1"), "These are Delayed test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Awaiting acceptance by Automation Appraiser1"), "Awaiting acceptance by Automation Appraiser1 is missing from the order information");
		
		// Verify Document is in Documents
		documentText = VOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Other"), "Other did not sync to Vendors");
		
		// Click on Sales Contract
		perform.clickInTable_Equals(driver, "Other");
		
		// Wait for text to update
		perform.waitForText(driver, VOrderDetails.documents_txt(driver), "Test PDF.pdf");
		documentText = VOrderDetails.documents_txt(driver).getText();
		
		// Verify file name and uploaded by
		Assert.assertTrue(documentText.contains("Test PDF.pdf"), "Document name is incorrect in Documents");
		Assert.assertTrue(documentText.contains("Automation VMP1"), "Uploaded By is incorrect in Documents");
		
		// Log in to VMP
		vmp.login(driver, "VMP1", "OriginatorVMP1", StoredVariables.getpassword().get());
		
		// Search for order
		vmp.findOrder(driver, StoredVariables.getloanIDVMP().get(), "Tracking #");
		
		// Verify Order Status
		Assert.assertTrue(VMPOrders.orderStatus_txt(driver).getText().equals("On Hold"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getAWSAccountsID().get() + "-" + StoredVariables.getloanIDVMP().get());
		
		// Wait for Send Message button
		perform.waitForElementToBeVisible(driver, VMPAppraisalOrderDetails.sendMessage_btn(), "cssSelector");
		
		// Click Send Message
		perform.click(driver,VMPAppraisalOrderDetails.sendMessage_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for Send button
		perform.waitForElementToBeClickable(driver, VMPAppraisalOrderDetails.send_btn(), "cssSelector");
		
		// Add notes
		perform.type(driver,VMPAppraisalOrderDetails.sendMessage_txtbx(driver), "These are test Send Message notes from OriginatorVMP1");
		
		// Uncheck Action Required
		if (VMPAppraisalOrderDetails.actionRequired_chkbx(driver).isSelected())
		{
			perform.click(driver,VMPAppraisalOrderDetails.actionRequired_chkbx(driver));
		}
		
		// Click Send
		perform.click(driver,VMPAppraisalOrderDetails.send_btn(driver));
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, VMPAppraisalOrderDetails.alertDialogOk_btn(), "cssSelector");
		
		// Verify Update Complete text
		Assert.assertTrue(VMPAppraisalOrderDetails.alertDialog_txt(driver).getText().equals("The message has been sent."), "The Update Complete dialog box text is incorrect");
		
		// Click OK for Send Complete
		perform.click(driver,VMPAppraisalOrderDetails.alertDialogOk_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Verify history
		history = VMPAppraisalOrderDetails.history_txt(driver).getText();
		Assert.assertTrue(history.contains("Message by Automation OriginatorVMP1"), "Message by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorVMP1"), "These are test Send Message notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorVMP1"), "Document Uploaded by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Other"), "Other is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF.pdf"), "Test PDF.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Automation OriginatorVMP1"), "On Hold by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorVMP1"), "These are Place On Hold test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorVMP1"), "Resumed by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorVMP1"), "These are Resume test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation OriginatorVMP1"), "Delayed by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorVMP1"), "These are Delayed test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("In Progress by Automation OriginatorVMP1"), "In Progress by Automation OriginatorVMP1 is missing from the audit trail");
		
		// Log in to Secure
		secure.login(driver, "VMP1", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, StoredVariables.getloanID().get(), "Tracking number");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("Awaiting acceptance"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getAWSAccountsID().get() + "-" + StoredVariables.getloanID().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify delayed is in the history
		Assert.assertTrue(history.contains("History (Awaiting acceptance)"), "History (Awaiting acceptance) is missing from the order information");
		Assert.assertTrue(history.contains("Message from Client (Automation VMP1)"), "Message from Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorVMP1"), "These are test Send Message notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation VMP1) (Test PDF.pdf)"), "Document Uploaded from Client (Automation VMP1) (Test PDF.pdf) is missing from the order information");
		Assert.assertTrue(history.contains("On Hold by Client (Automation VMP1)"), "On Hold by Client (Automation VMP1) did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorVMP1"), "These are Place On Hold test notes from OriginatorVMP1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Resumed by Client (Automation VMP1)"), "Resumed by Client (Automation VMP1) did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorVMP1"), "These are Resume test notes from OriginatorVMP1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Delayed by Client (Automation VMP1)"), "Delayed by Client (Automation VMP1) status did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorVMP1"), "These are Delayed test notes from OriginatorVMP1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser1"), "Awaiting acceptance by Automation Appraiser1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Reassigned by Client (Automation VMP1) to Automation Appraiser1"), "Reassigned by Client (Automation VMP1) to Automation Appraiser1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Requires assignment"), "Requires assignment did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Awaiting acceptance"), "Awaiting acceptance did not sync from VMP to Secure");

		// Log in to Vendors
		vendors.login(driver, "Appraiser1", StoredVariables.getpassword().get());
		
		// Search for order
		vendors.findOrder(driver, StoredVariables.getloanID().get(), "Tracking Number");
		
		// Verify order status
		Assert.assertTrue(VOrders.ordersGrid_txt(driver).getText().contains("Awaiting acceptance"), "The order is not in the correct status");
		
		// Click on the order from the orders grid
		perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, VOrderDetails.orderInformation_txt(), "id");
		
		// Verify status is Delayed
		Assert.assertTrue(VOrderDetails.historyHeader_txt(driver).getText().contains(""), "The Delayed status did not sync from the VMP to Vendors");
		
		// Get order information text
		orderInformation = VOrderDetails.orderInformation_txt(driver).getText();
		
		// Verify audit trail
		Assert.assertTrue(orderInformation.contains("History (Awaiting acceptance)"), "History (Awaiting acceptance) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Message from Client (Automation VMP1)"), "Message from Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are test Send Message notes from OriginatorVMP1"), "These are test Send Message notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Document Uploaded from Client (Automation VMP1) (Test PDF.pdf)"), "Document Uploaded from Client (Automation VMP1) (Test PDF.pdf) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("On Hold by Client (Automation VMP1)"), "On Hold by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Place On Hold test notes from OriginatorVMP1"), "These are Place On Hold test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Resumed by Client (Automation VMP1)"), "Resumed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Resume test notes from OriginatorVMP1"), "These are Resume test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Delayed by Client (Automation VMP1)"), "Delayed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Delayed test notes from OriginatorVMP1"), "These are Delayed test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Awaiting acceptance by Automation Appraiser1"), "Awaiting acceptance by Automation Appraiser1 is missing from the order information");

		// Log in to VMP
		vmp.login(driver, "VMP1", "OriginatorVMP1", StoredVariables.getpassword().get());
		
		// Search for order
		vmp.findOrder(driver, StoredVariables.getloanIDVMP().get(), "Tracking #");
		
		// Verify Order Status
		Assert.assertTrue(VMPOrders.orderStatus_txt(driver).getText().equals("On Hold"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getAWSAccountsID().get() + "-" + StoredVariables.getloanIDVMP().get());
		
		// Wait for Send Message button
		perform.waitForElementToBeClickable(driver, VMPAppraisalOrderDetails.sendMessage_btn(), "cssSelector");
		
		// Click Send Message
		perform.click(driver,VMPAppraisalOrderDetails.sendMessage_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for Send button
		perform.waitForElementToBeClickable(driver, VMPAppraisalOrderDetails.send_btn(), "cssSelector");
		
		// Add notes
		perform.type(driver,VMPAppraisalOrderDetails.sendMessage_txtbx(driver), "These are Action Required test notes from OriginatorVMP1");
		
		// Click Action Required checkbox
		if (!VMPAppraisalOrderDetails.actionRequired_chkbx(driver).isSelected())
		{
			perform.click(driver,VMPAppraisalOrderDetails.actionRequired_chkbx(driver));
		}
		
		// Click Send
		perform.click(driver,VMPAppraisalOrderDetails.send_btn(driver));
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, VMPAppraisalOrderDetails.alertDialogOk_btn(), "cssSelector");
		
		// Verify Update Complete text
		Assert.assertTrue(VMPAppraisalOrderDetails.alertDialog_txt(driver).getText().equals("The message has been sent."), "The Update Complete dialog box text is incorrect");
		
		// Click OK for Send Complete
		perform.click(driver,VMPAppraisalOrderDetails.alertDialogOk_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Verify history
		history = VMPAppraisalOrderDetails.history_txt(driver).getText();
		Assert.assertTrue(history.contains("Comment - Action Required by Automation OriginatorVMP1"), "Comment - Action Required by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorVMP1"), "These are Action Required test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation OriginatorVMP1"), "Message by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorVMP1"), "These are test Send Message notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorVMP1"), "Document Uploaded by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Other"), "Other is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF.pdf"), "Test PDF.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Automation OriginatorVMP1"), "On Hold by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorVMP1"), "These are Place On Hold test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorVMP1"), "Resumed by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorVMP1"), "These are Resume test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation OriginatorVMP1"), "Delayed by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorVMP1"), "These are Delayed test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("In Progress by Automation OriginatorVMP1"), "In Progress by Automation OriginatorVMP1 is missing from the audit trail");

		// Log in to Secure
		secure.login(driver, "VMP1", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, StoredVariables.getloanID().get(), "Tracking number");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("Awaiting acceptance"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getAWSAccountsID().get() + "-" + StoredVariables.getloanID().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify delayed is in the history
		Assert.assertTrue(history.contains("History (Awaiting acceptance)"), "History (Awaiting acceptance) is missing from the order information");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation VMP1)"), "Comment - Action Required by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorVMP1"), "These are Action Required test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(history.contains("Message from Client (Automation VMP1)"), "Message from Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorVMP1"), "These are test Send Message notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation VMP1) (Test PDF.pdf)"), "Document Uploaded from Client (Automation VMP1) (Test PDF.pdf) is missing from the order information");
		Assert.assertTrue(history.contains("On Hold by Client (Automation VMP1)"), "On Hold by Client (Automation VMP1) did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorVMP1"), "These are Place On Hold test notes from OriginatorVMP1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Resumed by Client (Automation VMP1)"), "Resumed by Client (Automation VMP1) did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorVMP1"), "These are Resume test notes from OriginatorVMP1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Delayed by Client (Automation VMP1)"), "Delayed by Client (Automation VMP1) status did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorVMP1"), "These are Delayed test notes from OriginatorVMP1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser1"), "Awaiting acceptance by Automation Appraiser1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Reassigned by Client (Automation VMP1) to Automation Appraiser1"), "Reassigned by Client (Automation VMP1) to Automation Appraiser1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Requires assignment"), "Requires assignment did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Awaiting acceptance"), "Awaiting acceptance did not sync from VMP to Secure");

		// Log in to Vendors
		vendors.login(driver, "Appraiser1", StoredVariables.getpassword().get());
		
		// Search for order
		vendors.findOrder(driver, StoredVariables.getloanID().get(), "Tracking Number");
		
		// Verify order status
		Assert.assertTrue(VOrders.ordersGrid_txt(driver).getText().contains("Awaiting acceptance"), "The order is not in the correct status");
		
		// Click on the order from the orders grid
		perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, VOrderDetails.orderInformation_txt(), "id");
		
		// Verify status is Delayed
		Assert.assertTrue(VOrderDetails.historyHeader_txt(driver).getText().contains(""), "The Delayed status did not sync from the VMP to Vendors");
		
		// Get order information text
		orderInformation = VOrderDetails.orderInformation_txt(driver).getText();
		
		// Verify audit trail
		Assert.assertTrue(orderInformation.contains("History (Awaiting acceptance)"), "History (Awaiting acceptance) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Comment - Action Required by Client (Automation VMP1)"), "Comment - Action Required by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Action Required test notes from OriginatorVMP1"), "These are Action Required test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Message from Client (Automation VMP1)"), "Message from Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are test Send Message notes from OriginatorVMP1"), "These are test Send Message notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Document Uploaded from Client (Automation VMP1) (Test PDF.pdf)"), "Document Uploaded from Client (Automation VMP1) (Test PDF.pdf) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("On Hold by Client (Automation VMP1)"), "On Hold by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Place On Hold test notes from OriginatorVMP1"), "These are Place On Hold test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Resumed by Client (Automation VMP1)"), "Resumed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Resume test notes from OriginatorVMP1"), "These are Resume test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Delayed by Client (Automation VMP1)"), "Delayed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Delayed test notes from OriginatorVMP1"), "These are Delayed test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Awaiting acceptance by Automation Appraiser1"), "Awaiting acceptance by Automation Appraiser1 is missing from the order information");

		// Log in to VMP
		vmp.login(driver, "VMP1", "OriginatorVMP1", StoredVariables.getpassword().get());
		
		// Search for order
		vmp.findOrder(driver, StoredVariables.getloanIDVMP().get(), "Tracking #");
		
		// Verify Order Status
		Assert.assertTrue(VMPOrders.orderStatus_txt(driver).getText().equals("On Hold"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getAWSAccountsID().get() + "-" + StoredVariables.getloanIDVMP().get());
		
		// Wait for Other Actions button
		perform.waitForElementToBeVisible(driver, VMPAppraisalOrderDetails.otherActions_btn(), "cssSelector");
		
		// Click Other Actions
		perform.click(driver,VMPAppraisalOrderDetails.otherActions_btn(driver));
		
		// Click Resume
		perform.click(driver,VMPAppraisalOrderDetails.resume_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, VMPAppraisalOrderDetails.resumeOk_btn(), "cssSelector");
		
		// Add notes
		perform.type(driver,VMPAppraisalOrderDetails.resumeNotes_txtbx(driver), "These are Resume2 test notes from OriginatorVMP1");
		
		// Click OK
		perform.click(driver,VMPAppraisalOrderDetails.resumeOk_btn(driver));
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, VMPAppraisalOrderDetails.alertDialogOk_btn(), "cssSelector");
		
		// Verify Update Complete text
		Assert.assertTrue(VMPAppraisalOrderDetails.alertDialog_txt(driver).getText().equals("The status of the order has been updated."), "The Update Complete dialog box text is incorrect");
		
		// Click OK for Update Complete
		perform.click(driver,VMPAppraisalOrderDetails.alertDialogOk_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Verify history
		history = VMPAppraisalOrderDetails.history_txt(driver).getText();
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorVMP1"), "Resumed by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorVMP1"), "These are Resume2 test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Automation OriginatorVMP1"), "Comment - Action Required by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorVMP1"), "These are Action Required test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation OriginatorVMP1"), "Message by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorVMP1"), "These are test Send Message notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorVMP1"), "Document Uploaded by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Other"), "Other is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF.pdf"), "Test PDF.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Automation OriginatorVMP1"), "On Hold by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorVMP1"), "These are Place On Hold test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorVMP1"), "Resumed by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorVMP1"), "These are Resume test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation OriginatorVMP1"), "Delayed by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorVMP1"), "These are Delayed test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("In Progress by Automation OriginatorVMP1"), "In Progress by Automation OriginatorVMP1 is missing from the audit trail");
		
		// Log in to Vendors
		vendors.login(driver, "Appraiser1", StoredVariables.getpassword().get());
		
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
		Assert.assertTrue(orderInformation.contains("Resumed by Client (Automation VMP1)"), "Resumed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Resume2 test notes from OriginatorVMP1"), "These are Resume2 test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Comment - Action Required by Client (Automation VMP1)"), "Comment - Action Required by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Action Required test notes from OriginatorVMP1"), "These are Action Required test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Message from Client (Automation VMP1)"), "Message from Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are test Send Message notes from OriginatorVMP1"), "These are test Send Message notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Document Uploaded from Client (Automation VMP1) (Test PDF.pdf)"), "Document Uploaded from Client (Automation VMP1) (Test PDF.pdf) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("On Hold by Client (Automation VMP1)"), "On Hold by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Place On Hold test notes from OriginatorVMP1"), "These are Place On Hold test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Resumed by Client (Automation VMP1)"), "Resumed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Resume test notes from OriginatorVMP1"), "These are Resume test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Delayed by Client (Automation VMP1)"), "Delayed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Delayed test notes from OriginatorVMP1"), "These are Delayed test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Awaiting acceptance by Automation Appraiser1"), "Awaiting acceptance by Automation Appraiser1 is missing from the order information");
		
		// View Order Details
		vendors.verifyOrderDetails(driver);

		// Click Accept/Decline button
		perform.click(driver,VOrderDetails.acceptDecline_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for Select Action dropdown
		perform.waitForElementToBeClickable(driver, VOrderAcknowledgement.selectAction_dropdown(), "id");
		
		// Enter notes
		perform.type(driver,VOrderAcknowledgement.acceptAssignmentNotes_txtbx(driver), "These are Appraiser1 accepting order notes");
		
		// Click OK
		perform.click(driver,VOrderAcknowledgement.ok_btn(driver));
		
		// Close Order Acknowledgement dialog
		vendors.closeOrderAcknowledgementDialog(driver);
		
		// Get order information text
		orderInformation = VOrderDetails.orderInformation_txt(driver).getText();
		
		// Wait for audit trail to update
		// Set 40 second while loop timeout
		long start_time = System.currentTimeMillis();
		long wait_time = 40000;
		long end_time = start_time + wait_time;
		while (System.currentTimeMillis() < end_time && !orderInformation.contains("History (In Progress)"))
		{
			Thread.sleep(1000);
			orderInformation = VOrderDetails.orderInformation_txt(driver).getText();
			if (orderInformation.contains("History (In Progress)"))
			{
				break;
			} // end if
		} // end while
		
		// Verify audit trail
		Assert.assertTrue(orderInformation.contains("History (In Progress)"), "History (In Progress) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Order accepted by Appraiser (Automation Appraiser1) and In Progress"), "Order accepted by Appraiser (Automation Appraiser1) and In Progress is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Appraiser1 accepting order notes"), "These are Appraiser1 accepting order notes is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Resumed by Client (Automation VMP1)"), "Resumed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Resume2 test notes from OriginatorVMP1"), "These are Resume2 test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Comment - Action Required by Client (Automation VMP1)"), "Comment - Action Required by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Action Required test notes from OriginatorVMP1"), "These are Action Required test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Message from Client (Automation VMP1)"), "Message from Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are test Send Message notes from OriginatorVMP1"), "These are test Send Message notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Document Uploaded from Client (Automation VMP1) (Test PDF.pdf)"), "Document Uploaded from Client (Automation VMP1) (Test PDF.pdf) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("On Hold by Client (Automation VMP1)"), "On Hold by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Place On Hold test notes from OriginatorVMP1"), "These are Place On Hold test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Resumed by Client (Automation VMP1)"), "Resumed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Resume test notes from OriginatorVMP1"), "These are Resume test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Delayed by Client (Automation VMP1)"), "Delayed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Delayed test notes from OriginatorVMP1"), "These are Delayed test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Awaiting acceptance by Automation Appraiser1"), "Awaiting acceptance by Automation Appraiser1 is missing from the order information");

		// Log in to VMP
		vmp.login(driver, "VMP1", "OriginatorVMP1", StoredVariables.getpassword().get());
		
		// Search for order
		vmp.findOrder(driver, StoredVariables.getloanIDVMP().get(), "Tracking #");
		
		// Verify Order Status
		Assert.assertTrue(VMPOrders.orderStatus_txt(driver).getText().equals("In Progress"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getAWSAccountsID().get() + "-" + StoredVariables.getloanIDVMP().get());
		
		// Wait for Other Actions button
		perform.waitForElementToBeVisible(driver, VMPAppraisalOrderDetails.otherActions_btn(), "cssSelector");
		
		// Verify history
		history = VMPAppraisalOrderDetails.history_txt(driver).getText();
		Assert.assertTrue(history.contains("Appraiser Accepted Assignment by Automation VMP1"), "Appraiser Accepted Assignment by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser1 accepting order notes"), "These are Appraiser1 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorVMP1"), "Resumed by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorVMP1"), "These are Resume2 test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Automation OriginatorVMP1"), "Comment - Action Required by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorVMP1"), "These are Action Required test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation OriginatorVMP1"), "Message by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorVMP1"), "These are test Send Message notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorVMP1"), "Document Uploaded by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Other"), "Other is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF.pdf"), "Test PDF.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Automation OriginatorVMP1"), "On Hold by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorVMP1"), "These are Place On Hold test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorVMP1"), "Resumed by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorVMP1"), "These are Resume test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation OriginatorVMP1"), "Delayed by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorVMP1"), "These are Delayed test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("In Progress by Automation OriginatorVMP1"), "In Progress by Automation OriginatorVMP1 is missing from the audit trail");

		// Log in to Secure
		secure.login(driver, "VMP1", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, StoredVariables.getloanID().get(), "Tracking number");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("In Progress"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getAWSAccountsID().get() + "-" + StoredVariables.getloanID().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify delayed is in the history
		Assert.assertTrue(history.contains("History (In Progress)"), "History (In Progress) is missing from the order information");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation VMP1)"), "Comment - Action Required by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorVMP1"), "These are Action Required test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(history.contains("Message from Client (Automation VMP1)"), "Message from Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorVMP1"), "These are test Send Message notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation VMP1) (Test PDF.pdf)"), "Document Uploaded from Client (Automation VMP1) (Test PDF.pdf) is missing from the order information");
		Assert.assertTrue(history.contains("On Hold by Client (Automation VMP1)"), "On Hold by Client (Automation VMP1) did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorVMP1"), "These are Place On Hold test notes from OriginatorVMP1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Resumed by Client (Automation VMP1)"), "Resumed by Client (Automation VMP1) did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorVMP1"), "These are Resume test notes from OriginatorVMP1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Delayed by Client (Automation VMP1)"), "Delayed by Client (Automation VMP1) status did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorVMP1"), "These are Delayed test notes from OriginatorVMP1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser1"), "Awaiting acceptance by Automation Appraiser1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Reassigned by Client (Automation VMP1) to Automation Appraiser1"), "Reassigned by Client (Automation VMP1) to Automation Appraiser1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Requires assignment"), "Requires assignment did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Awaiting acceptance"), "Awaiting acceptance did not sync from VMP to Secure");

		// Log in to Vendors
		vendors.login(driver, "Appraiser1", StoredVariables.getpassword().get());
		
		// Search for order
		vendors.findOrder(driver, StoredVariables.getloanID().get(), "Tracking Number");
		
		// Verify order status
		Assert.assertTrue(VOrders.ordersGrid_txt(driver).getText().contains("In Progress"), "The order is not in the correct status");
		
		// Click on the order from the orders grid
		perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, VOrderDetails.orderInformation_txt(), "id");
		
		// Click Set Order Status
		perform.clickInTable_Contains(driver, "Set Order Status");
		
		// Click Delayed
		perform.click(driver,VOrderDetails.delayed_btn(driver));
		
		// Wait for Overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for OK button to be clickable
		perform.waitForElementToBeClickable(driver, VOrderDetails.setStatusOk_btn(), "cssSelector");
		
		// Enter Notes
		perform.type(driver,VOrderDetails.setOrderStatusNotes_txtbx(driver), "These are Delayed notes from Appraiser1");
		
		// Click OK
		perform.click(driver,VOrderDetails.setStatusOk_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Get order information text
		orderInformation = VOrderDetails.orderInformation_txt(driver).getText();
		
		// Verify audit trail
		Assert.assertTrue(orderInformation.contains("History (Delayed)"), "History (Delayed) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Delayed by Appraiser (Automation Appraiser1)"), "Delayed by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Delayed notes from Appraiser1"), "These are Delayed notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Order accepted by Appraiser (Automation Appraiser1) and In Progress"), "Order accepted by Appraiser (Automation Appraiser1) and In Progress is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Appraiser1 accepting order notes"), "These are Appraiser1 accepting order notes is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Resumed by Client (Automation VMP1)"), "Resumed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Resume2 test notes from OriginatorVMP1"), "These are Resume2 test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Comment - Action Required by Client (Automation VMP1)"), "Comment - Action Required by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Action Required test notes from OriginatorVMP1"), "These are Action Required test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Message from Client (Automation VMP1)"), "Message from Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are test Send Message notes from OriginatorVMP1"), "These are test Send Message notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Document Uploaded from Client (Automation VMP1) (Test PDF.pdf)"), "Document Uploaded from Client (Automation VMP1) (Test PDF.pdf) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("On Hold by Client (Automation VMP1)"), "On Hold by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Place On Hold test notes from OriginatorVMP1"), "These are Place On Hold test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Resumed by Client (Automation VMP1)"), "Resumed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Resume test notes from OriginatorVMP1"), "These are Resume test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Delayed by Client (Automation VMP1)"), "Delayed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Delayed test notes from OriginatorVMP1"), "These are Delayed test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Awaiting acceptance by Automation Appraiser1"), "Awaiting acceptance by Automation Appraiser1 is missing from the order information");

		// Log in to VMP
		vmp.login(driver, "VMP1", "OriginatorVMP1", StoredVariables.getpassword().get());
		
		// Search for order
		vmp.findOrder(driver, StoredVariables.getloanIDVMP().get(), "Tracking #");
		
		// Verify Order Status
		Assert.assertTrue(VMPOrders.orderStatus_txt(driver).getText().equals("Delayed"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getAWSAccountsID().get() + "-" + StoredVariables.getloanIDVMP().get());
		
		// Wait for Other Actions button
		perform.waitForElementToBeVisible(driver, VMPAppraisalOrderDetails.otherActions_btn(), "cssSelector");
		
		// Verify history
		history = VMPAppraisalOrderDetails.history_txt(driver).getText();
		Assert.assertTrue(history.contains("Delayed by Automation VMP1"), "Delayed by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser1"), "These are Delayed notes from Appraiser1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraiser Accepted Assignment by Automation VMP1"), "Appraiser Accepted Assignment by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser1 accepting order notes"), "These are Appraiser1 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorVMP1"), "Resumed by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorVMP1"), "These are Resume2 test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Automation OriginatorVMP1"), "Comment - Action Required by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorVMP1"), "These are Action Required test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation OriginatorVMP1"), "Message by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorVMP1"), "These are test Send Message notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorVMP1"), "Document Uploaded by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Other"), "Other is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF.pdf"), "Test PDF.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Automation OriginatorVMP1"), "On Hold by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorVMP1"), "These are Place On Hold test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorVMP1"), "Resumed by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorVMP1"), "These are Resume test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation OriginatorVMP1"), "Delayed by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorVMP1"), "These are Delayed test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("In Progress by Automation OriginatorVMP1"), "In Progress by Automation OriginatorVMP1 is missing from the audit trail");
		
		// Log in to Secure
		secure.login(driver, "VMP1", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, StoredVariables.getloanID().get(), "Tracking number");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("Delayed"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getAWSAccountsID().get() + "-" + StoredVariables.getloanID().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify delayed is in the history
		Assert.assertTrue(history.contains("History (Delayed)"), "History (Delayed) is missing from the order information");
		Assert.assertTrue(history.contains("Delayed by Appraiser (Automation Appraiser1)"), "Delayed by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser1"), "These are Delayed notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation VMP1)"), "Comment - Action Required by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorVMP1"), "These are Action Required test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(history.contains("Message from Client (Automation VMP1)"), "Message from Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorVMP1"), "These are test Send Message notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation VMP1) (Test PDF.pdf)"), "Document Uploaded from Client (Automation VMP1) (Test PDF.pdf) is missing from the order information");
		Assert.assertTrue(history.contains("On Hold by Client (Automation VMP1)"), "On Hold by Client (Automation VMP1) did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorVMP1"), "These are Place On Hold test notes from OriginatorVMP1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Resumed by Client (Automation VMP1)"), "Resumed by Client (Automation VMP1) did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorVMP1"), "These are Resume test notes from OriginatorVMP1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Delayed by Client (Automation VMP1)"), "Delayed by Client (Automation VMP1) status did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorVMP1"), "These are Delayed test notes from OriginatorVMP1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser1"), "Awaiting acceptance by Automation Appraiser1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Reassigned by Client (Automation VMP1) to Automation Appraiser1"), "Reassigned by Client (Automation VMP1) to Automation Appraiser1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Requires assignment"), "Requires assignment did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Awaiting acceptance"), "Awaiting acceptance did not sync from VMP to Secure");
		
		// Log in to Vendors
		vendors.login(driver, "Appraiser1", StoredVariables.getpassword().get());
		
		// Search for order
		vendors.findOrder(driver, StoredVariables.getloanID().get(), "Tracking Number");
		
		// Verify order status
		Assert.assertTrue(VOrders.ordersGrid_txt(driver).getText().contains("Delayed"), "The order is not in the correct status");
		
		// Click on the order from the orders grid
		perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, VOrderDetails.orderInformation_txt(), "id");
		
		// Click Set Order Status
		perform.clickInTable_Contains(driver, "Set Order Status");
		
		// Click Resume
		perform.click(driver,VOrderDetails.resume_btn(driver));
		
		// Wait for Overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for OK button to be clickable
		perform.waitForElementToBeClickable(driver, VOrderDetails.setStatusOk_btn(), "cssSelector");
		
		// Enter Notes
		perform.type(driver,VOrderDetails.setOrderStatusNotes_txtbx(driver), "These are Resume notes from Appraiser1");
		
		// Click OK
		perform.click(driver,VOrderDetails.setStatusOk_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Get order information text
		orderInformation = VOrderDetails.orderInformation_txt(driver).getText();
		
		// Verify audit trail
		Assert.assertTrue(orderInformation.contains("History (In Progress)"), "History (In Progress) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Resumed by Appraiser (Automation Appraiser1)"), "Resumed by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Resume notes from Appraiser1"), "These are Resume notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Delayed by Appraiser (Automation Appraiser1)"), "Delayed by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Delayed notes from Appraiser1"), "These are Delayed notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Order accepted by Appraiser (Automation Appraiser1) and In Progress"), "Order accepted by Appraiser (Automation Appraiser1) and In Progress is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Appraiser1 accepting order notes"), "These are Appraiser1 accepting order notes is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Resumed by Client (Automation VMP1)"), "Resumed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Resume2 test notes from OriginatorVMP1"), "These are Resume2 test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Comment - Action Required by Client (Automation VMP1)"), "Comment - Action Required by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Action Required test notes from OriginatorVMP1"), "These are Action Required test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Message from Client (Automation VMP1)"), "Message from Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are test Send Message notes from OriginatorVMP1"), "These are test Send Message notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Document Uploaded from Client (Automation VMP1) (Test PDF.pdf)"), "Document Uploaded from Client (Automation VMP1) (Test PDF.pdf) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("On Hold by Client (Automation VMP1)"), "On Hold by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Place On Hold test notes from OriginatorVMP1"), "These are Place On Hold test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Resumed by Client (Automation VMP1)"), "Resumed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Resume test notes from OriginatorVMP1"), "These are Resume test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Delayed by Client (Automation VMP1)"), "Delayed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Delayed test notes from OriginatorVMP1"), "These are Delayed test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Awaiting acceptance by Automation Appraiser1"), "Awaiting acceptance by Automation Appraiser1 is missing from the order information");

		// Log in to VMP
		vmp.login(driver, "VMP1", "OriginatorVMP1", StoredVariables.getpassword().get());
		
		// Search for order
		vmp.findOrder(driver, StoredVariables.getloanIDVMP().get(), "Tracking #");
		
		// Verify Order Status
		Assert.assertTrue(VMPOrders.orderStatus_txt(driver).getText().equals("In Progress"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getAWSAccountsID().get() + "-" + StoredVariables.getloanIDVMP().get());
		
		// Wait for Other Actions button
		perform.waitForElementToBeVisible(driver, VMPAppraisalOrderDetails.otherActions_btn(), "cssSelector");
		
		// Verify history
		history = VMPAppraisalOrderDetails.history_txt(driver).getText();
		Assert.assertTrue(history.contains("Resumed by Automation VMP1"), "Resumed by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser1"), "These are Resume notes from Appraiser1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation VMP1"), "Delayed by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser1"), "These are Delayed notes from Appraiser1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraiser Accepted Assignment by Automation VMP1"), "Appraiser Accepted Assignment by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser1 accepting order notes"), "These are Appraiser1 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorVMP1"), "Resumed by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorVMP1"), "These are Resume2 test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Automation OriginatorVMP1"), "Comment - Action Required by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorVMP1"), "These are Action Required test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation OriginatorVMP1"), "Message by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorVMP1"), "These are test Send Message notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorVMP1"), "Document Uploaded by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Other"), "Other is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF.pdf"), "Test PDF.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Automation OriginatorVMP1"), "On Hold by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorVMP1"), "These are Place On Hold test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorVMP1"), "Resumed by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorVMP1"), "These are Resume test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation OriginatorVMP1"), "Delayed by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorVMP1"), "These are Delayed test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("In Progress by Automation OriginatorVMP1"), "In Progress by Automation OriginatorVMP1 is missing from the audit trail");

		// Log in to Secure
		secure.login(driver, "VMP1", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, StoredVariables.getloanID().get(), "Tracking number");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("In Progress"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getAWSAccountsID().get() + "-" + StoredVariables.getloanID().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify delayed is in the history
		Assert.assertTrue(history.contains("History (In Progress)"), "History (In Progress) is missing from the order information");
		Assert.assertTrue(history.contains("Resumed by Appraiser (Automation Appraiser1)"), "Resumed by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser1"), "These are Resume notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(history.contains("Delayed by Appraiser (Automation Appraiser1)"), "Delayed by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser1"), "These are Delayed notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation VMP1)"), "Comment - Action Required by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorVMP1"), "These are Action Required test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(history.contains("Message from Client (Automation VMP1)"), "Message from Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorVMP1"), "These are test Send Message notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation VMP1) (Test PDF.pdf)"), "Document Uploaded from Client (Automation VMP1) (Test PDF.pdf) is missing from the order information");
		Assert.assertTrue(history.contains("On Hold by Client (Automation VMP1)"), "On Hold by Client (Automation VMP1) did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorVMP1"), "These are Place On Hold test notes from OriginatorVMP1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Resumed by Client (Automation VMP1)"), "Resumed by Client (Automation VMP1) did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorVMP1"), "These are Resume test notes from OriginatorVMP1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Delayed by Client (Automation VMP1)"), "Delayed by Client (Automation VMP1) status did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorVMP1"), "These are Delayed test notes from OriginatorVMP1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser1"), "Awaiting acceptance by Automation Appraiser1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Reassigned by Client (Automation VMP1) to Automation Appraiser1"), "Reassigned by Client (Automation VMP1) to Automation Appraiser1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Requires assignment"), "Requires assignment did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Awaiting acceptance"), "Awaiting acceptance did not sync from VMP to Secure");
		
		// Log in to Vendors
		vendors.login(driver, "Appraiser1", StoredVariables.getpassword().get());
		
		// Search for order
		vendors.findOrder(driver, StoredVariables.getloanID().get(), "Tracking Number");
		
		// Verify order status
		Assert.assertTrue(VOrders.ordersGrid_txt(driver).getText().contains("In Progress"), "The order is not in the correct status");
		
		// Click on the order from the orders grid
		perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, VOrderDetails.sendMessage_btn(), "cssSelector");
		
		// Click Message
		perform.click(driver,VOrderDetails.sendMessage_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for OK button to be clickable
		perform.waitForElementToBeClickable(driver, VOrderDetails.sendMessageOk_btn(), "cssSelector");
		
		// Add notes
		perform.type(driver,VOrderDetails.sendMessageNotes_txtbx(driver), "These are Message notes from Appraiser1");
		
		// Click OK button
		perform.click(driver,VOrderDetails.sendMessageOk_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Get order information text
		orderInformation = VOrderDetails.orderInformation_txt(driver).getText();
		
		// Verify audit trail
		Assert.assertTrue(orderInformation.contains("History (In Progress)"), "History (In Progress) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Message from Appraiser (Automation Appraiser1)"), "Message from Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Message notes from Appraiser1"), "These are Message notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Resumed by Appraiser (Automation Appraiser1)"), "Resumed by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Resume notes from Appraiser1"), "These are Resume notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Delayed by Appraiser (Automation Appraiser1)"), "Delayed by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Delayed notes from Appraiser1"), "These are Delayed notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Order accepted by Appraiser (Automation Appraiser1) and In Progress"), "Order accepted by Appraiser (Automation Appraiser1) and In Progress is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Appraiser1 accepting order notes"), "These are Appraiser1 accepting order notes is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Resumed by Client (Automation VMP1)"), "Resumed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Resume2 test notes from OriginatorVMP1"), "These are Resume2 test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Comment - Action Required by Client (Automation VMP1)"), "Comment - Action Required by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Action Required test notes from OriginatorVMP1"), "These are Action Required test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Message from Client (Automation VMP1)"), "Message from Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are test Send Message notes from OriginatorVMP1"), "These are test Send Message notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Document Uploaded from Client (Automation VMP1) (Test PDF.pdf)"), "Document Uploaded from Client (Automation VMP1) (Test PDF.pdf) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("On Hold by Client (Automation VMP1)"), "On Hold by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Place On Hold test notes from OriginatorVMP1"), "These are Place On Hold test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Resumed by Client (Automation VMP1)"), "Resumed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Resume test notes from OriginatorVMP1"), "These are Resume test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Delayed by Client (Automation VMP1)"), "Delayed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Delayed test notes from OriginatorVMP1"), "These are Delayed test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Awaiting acceptance by Automation Appraiser1"), "Awaiting acceptance by Automation Appraiser1 is missing from the order information");

		// Log in to VMP
		vmp.login(driver, "VMP1", "OriginatorVMP1", StoredVariables.getpassword().get());
		
		// Search for order
		vmp.findOrder(driver, StoredVariables.getloanIDVMP().get(), "Tracking #");
		
		// Verify Order Status
		Assert.assertTrue(VMPOrders.orderStatus_txt(driver).getText().equals("In Progress"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getAWSAccountsID().get() + "-" + StoredVariables.getloanIDVMP().get());
		
		// Wait for Other Actions button
		perform.waitForElementToBeVisible(driver, VMPAppraisalOrderDetails.otherActions_btn(), "cssSelector");
		
		// Verify history
		history = VMPAppraisalOrderDetails.history_txt(driver).getText();
		Assert.assertTrue(history.contains("Message by Automation VMP1"), "Message by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser1"), "These are Message notes from Appraiser1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation VMP1"), "Resumed by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser1"), "These are Resume notes from Appraiser1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation VMP1"), "Delayed by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser1"), "These are Delayed notes from Appraiser1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraiser Accepted Assignment by Automation VMP1"), "Appraiser Accepted Assignment by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser1 accepting order notes"), "These are Appraiser1 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorVMP1"), "Resumed by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorVMP1"), "These are Resume2 test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Automation OriginatorVMP1"), "Comment - Action Required by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorVMP1"), "These are Action Required test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation OriginatorVMP1"), "Message by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorVMP1"), "These are test Send Message notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorVMP1"), "Document Uploaded by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Other"), "Other is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF.pdf"), "Test PDF.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Automation OriginatorVMP1"), "On Hold by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorVMP1"), "These are Place On Hold test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorVMP1"), "Resumed by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorVMP1"), "These are Resume test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation OriginatorVMP1"), "Delayed by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorVMP1"), "These are Delayed test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("In Progress by Automation OriginatorVMP1"), "In Progress by Automation OriginatorVMP1 is missing from the audit trail");

		// Log in to Secure
		secure.login(driver, "VMP1", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, StoredVariables.getloanID().get(), "Tracking number");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("In Progress"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getAWSAccountsID().get() + "-" + StoredVariables.getloanID().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify delayed is in the history
		Assert.assertTrue(history.contains("History (In Progress)"), "History (In Progress) is missing from the order information");
		Assert.assertTrue(history.contains("Resumed by Appraiser (Automation Appraiser1)"), "Resumed by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser1"), "These are Message notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(history.contains("Resumed by Appraiser (Automation Appraiser1)"), "Resumed by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser1"), "These are Resume notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(history.contains("Delayed by Appraiser (Automation Appraiser1)"), "Delayed by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser1"), "These are Delayed notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation VMP1)"), "Comment - Action Required by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorVMP1"), "These are Action Required test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(history.contains("Message from Client (Automation VMP1)"), "Message from Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorVMP1"), "These are test Send Message notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation VMP1) (Test PDF.pdf)"), "Document Uploaded from Client (Automation VMP1) (Test PDF.pdf) is missing from the order information");
		Assert.assertTrue(history.contains("On Hold by Client (Automation VMP1)"), "On Hold by Client (Automation VMP1) did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorVMP1"), "These are Place On Hold test notes from OriginatorVMP1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Resumed by Client (Automation VMP1)"), "Resumed by Client (Automation VMP1) did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorVMP1"), "These are Resume test notes from OriginatorVMP1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Delayed by Client (Automation VMP1)"), "Delayed by Client (Automation VMP1) status did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorVMP1"), "These are Delayed test notes from OriginatorVMP1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser1"), "Awaiting acceptance by Automation Appraiser1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Reassigned by Client (Automation VMP1) to Automation Appraiser1"), "Reassigned by Client (Automation VMP1) to Automation Appraiser1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Requires assignment"), "Requires assignment did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Awaiting acceptance"), "Awaiting acceptance did not sync from VMP to Secure");
		
		// Log in to Vendors
		vendors.login(driver, "Appraiser1", StoredVariables.getpassword().get());
		
		// Search for order
		String orderNumber = StoredVariables.getloanID().get();
		vendors.findOrder(driver, orderNumber, "Tracking Number");
		
		// Verify order status
		Assert.assertTrue(VOrders.ordersGrid_txt(driver).getText().contains("In Progress"), "The order is not in the correct status");
		
		// Click on the order from the orders grid
		perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, VOrderDetails.sendMessage_btn(), "cssSelector");
		
		// Click Attach Documents button
		perform.click(driver,VOrderDetails.attachDocuments_btn(driver));
		
		// Wait for message text
		perform.waitForElementToBeClickable(driver, VOrderDetails.uploadDocuments_btn(), "id");
		
		// Select document type
		perform.selectDropdownOption(driver, VOrderDetails.documentType_dropdown(driver), "Sales Contract");
		
		// Wait for upload button
		perform.waitForElementToBeClickable(driver, VOrderDetails.uploadDocuments_btn(), "id");
		
		// Upload test pdf file
		filePath = StoredVariables.getdocDir().get()+"Test PDF.pdf";
		vendors.uploadDocument(driver, filePath, orderNumber, "Sales Contract");
		
		Thread.sleep(1000);
		
		// Click Close Button
		perform.click(driver,VOrderDetails.close_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Wait for text to be visible
		perform.waitForElementToBeVisible(driver, VOrderDetails.documents_txt(), "id");
		
		// Verify Report is in the Order Documents pane
		String orderDocumentsText = VOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(orderDocumentsText.contains("Order Documents"), "Order Documents is not showing in the Order Documents");
		Assert.assertTrue(orderDocumentsText.contains("Other"), "Other is not showing in the Order Documents");
		Assert.assertTrue(orderDocumentsText.contains("Sales Contract"), "Sales Contract is not showing in the Order Documents");
		Assert.assertTrue(orderDocumentsText.contains(StoredVariables.gettodaysDateLong().get()), "The Date Uploaded is not showing in the Order Documents");
		
		// Get order information text
		orderInformation = VOrderDetails.orderInformation_txt(driver).getText();
		
		// Verify audit trail
		Assert.assertTrue(orderInformation.contains("History (In Progress)"), "History (In Progress) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Message from Appraiser (Automation Appraiser1)"), "Message from Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Message notes from Appraiser1"), "These are Message notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Resumed by Appraiser (Automation Appraiser1)"), "Resumed by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Resume notes from Appraiser1"), "These are Resume notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Delayed by Appraiser (Automation Appraiser1)"), "Delayed by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Delayed notes from Appraiser1"), "These are Delayed notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Order accepted by Appraiser (Automation Appraiser1) and In Progress"), "Order accepted by Appraiser (Automation Appraiser1) and In Progress is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Appraiser1 accepting order notes"), "These are Appraiser1 accepting order notes is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Resumed by Client (Automation VMP1)"), "Resumed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Resume2 test notes from OriginatorVMP1"), "These are Resume2 test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Comment - Action Required by Client (Automation VMP1)"), "Comment - Action Required by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Action Required test notes from OriginatorVMP1"), "These are Action Required test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Message from Client (Automation VMP1)"), "Message from Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are test Send Message notes from OriginatorVMP1"), "These are test Send Message notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Document Uploaded from Client (Automation VMP1) (Test PDF.pdf)"), "Document Uploaded from Client (Automation VMP1) (Test PDF.pdf) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("On Hold by Client (Automation VMP1)"), "On Hold by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Place On Hold test notes from OriginatorVMP1"), "These are Place On Hold test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Resumed by Client (Automation VMP1)"), "Resumed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Resume test notes from OriginatorVMP1"), "These are Resume test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Delayed by Client (Automation VMP1)"), "Delayed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Delayed test notes from OriginatorVMP1"), "These are Delayed test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Awaiting acceptance by Automation Appraiser1"), "Awaiting acceptance by Automation Appraiser1 is missing from the order information");
		
		// Click Sales Contract
		perform.clickInTable_Contains(driver, "Sales Contract");
		
		// Wait for text
		perform.waitForText(driver, VOrderDetails.documents_txt(driver), "Automation Appraiser1");
		orderDocumentsText = VOrderDetails.documents_txt(driver).getText();
		
		// Verify Uploaded By and Document Name
		Assert.assertTrue(orderDocumentsText.contains("Test PDF_1.pdf"), "Test PDF_1.pdf is not showing as the Document Name in Order Documents");

		// Log in to VMP
		vmp.login(driver, "VMP1", "OriginatorVMP1", StoredVariables.getpassword().get());
		
		// Search for order
		vmp.findOrder(driver, StoredVariables.getloanIDVMP().get(), "Tracking #");
		
		// Verify Order Status
		Assert.assertTrue(VMPOrders.orderStatus_txt(driver).getText().equals("In Progress"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getAWSAccountsID().get() + "-" + StoredVariables.getloanIDVMP().get());
		
		// Wait for Other Actions button
		perform.waitForElementToBeVisible(driver, VMPAppraisalOrderDetails.otherActions_btn(), "cssSelector");
		
		// Verify history
		history = VMPAppraisalOrderDetails.history_txt(driver).getText();
		Assert.assertTrue(history.contains("Document Uploaded by Automation VMP1"), "Document Uploaded by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Sales Contract"), "Sales Contract is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF_1.pdf"), "Test PDF_1.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation VMP1"), "Message by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser1"), "These are Message notes from Appraiser1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation VMP1"), "Resumed by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser1"), "These are Resume notes from Appraiser1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation VMP1"), "Delayed by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser1"), "These are Delayed notes from Appraiser1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraiser Accepted Assignment by Automation VMP1"), "Appraiser Accepted Assignment by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser1 accepting order notes"), "These are Appraiser1 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorVMP1"), "Resumed by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorVMP1"), "These are Resume2 test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Automation OriginatorVMP1"), "Comment - Action Required by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorVMP1"), "These are Action Required test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation OriginatorVMP1"), "Message by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorVMP1"), "These are test Send Message notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorVMP1"), "Document Uploaded by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Other"), "Other is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF.pdf"), "Test PDF.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Automation OriginatorVMP1"), "On Hold by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorVMP1"), "These are Place On Hold test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorVMP1"), "Resumed by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorVMP1"), "These are Resume test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation OriginatorVMP1"), "Delayed by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorVMP1"), "These are Delayed test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("In Progress by Automation OriginatorVMP1"), "In Progress by Automation OriginatorVMP1 is missing from the audit trail");
		
		// Verify Document is in Documents
		documentText = VMPAppraisalOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Other"), "Other document is not displayed in VMP XSite");
		Assert.assertTrue(documentText.contains("Sales Contract"), "Sales Contract did not sync to VMP XSite");
		
		// Click on Sales Contract
		perform.clickInTable_Contains(driver, "Sales Contract");
		
		// Wait for text to update
		perform.waitForText(driver, VMPAppraisalOrderDetails.documents_txt(driver), "Test PDF_1.pdf");
		documentText = VMPAppraisalOrderDetails.documents_txt(driver).getText();
		
		// Verify file name and uploaded by
		Assert.assertTrue(documentText.contains("Test PDF_1.pdf"), "Document name is incorrect in Documents");
		Assert.assertTrue(documentText.contains("Automation VMP1"), "Uploaded By is incorrect in Documents");
		
		// Log in to Secure
		secure.login(driver, "VMP1", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, StoredVariables.getloanID().get(), "Tracking number");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("In Progress"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getAWSAccountsID().get() + "-" + StoredVariables.getloanID().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify delayed is in the history
		Assert.assertTrue(history.contains("History (In Progress)"), "History (In Progress) is missing from the order information");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser1) (Test PDF_1.pdf)"), "Document Uploaded from Appraiser (Automation Appraiser1) (Test PDF_1.pdf) is missing from the order information");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser1)"), "Message from Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser1"), "These are Message notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(history.contains("Resumed by Appraiser (Automation Appraiser1)"), "Resumed by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser1"), "These are Resume notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(history.contains("Delayed by Appraiser (Automation Appraiser1)"), "Delayed by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser1"), "These are Delayed notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation VMP1)"), "Comment - Action Required by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorVMP1"), "These are Action Required test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(history.contains("Message from Client (Automation VMP1)"), "Message from Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorVMP1"), "These are test Send Message notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation VMP1) (Test PDF.pdf)"), "Document Uploaded from Client (Automation VMP1) (Test PDF.pdf) is missing from the order information");
		Assert.assertTrue(history.contains("On Hold by Client (Automation VMP1)"), "On Hold by Client (Automation VMP1) did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorVMP1"), "These are Place On Hold test notes from OriginatorVMP1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Resumed by Client (Automation VMP1)"), "Resumed by Client (Automation VMP1) did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorVMP1"), "These are Resume test notes from OriginatorVMP1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Delayed by Client (Automation VMP1)"), "Delayed by Client (Automation VMP1) status did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorVMP1"), "These are Delayed test notes from OriginatorVMP1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser1"), "Awaiting acceptance by Automation Appraiser1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Reassigned by Client (Automation VMP1) to Automation Appraiser1"), "Reassigned by Client (Automation VMP1) to Automation Appraiser1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Requires assignment"), "Requires assignment did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Awaiting acceptance"), "Awaiting acceptance did not sync from VMP to Secure");
		
		// Verify Document is in Documents
		documentText = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Sales Contract"), "Sales Contract did not sync to VMP XSite");
		
		// Click on Sales Contract
		perform.clickInTable_Contains(driver, "Sales Contract");
		
		// Wait for text to update
		perform.waitForText(driver, SOrderDetails.documents_txt(driver), "Test PDF_1.pdf");
		documentText = SOrderDetails.documents_txt(driver).getText();
		
		// Verify file name and uploaded by
		Assert.assertTrue(documentText.contains("Test PDF_1.pdf"), "Document name is incorrect in Documents");
		Assert.assertTrue(documentText.contains("Automation Appraiser1"), "Uploaded By is incorrect in Documents");
		
		// Log in to Vendors
		vendors.login(driver, "Appraiser1", StoredVariables.getpassword().get());
		
		// Search for order
		vendors.findOrder(driver, StoredVariables.getloanID().get(), "Tracking Number");
		
		// Verify order status
		Assert.assertTrue(VOrders.ordersGrid_txt(driver).getText().contains("In Progress"), "The order is not in the correct status");
		
		// Click on the order from the orders grid
		perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, VOrderDetails.sendMessage_btn(), "cssSelector");
		
		// Click Set Order Status
		perform.clickInTable_Contains(driver, "Set Order Status");
		
		// Click Inspection Scheduled
		perform.click(driver,VOrderDetails.inspectionScheduled_btn(driver));
		
		// Wait for Overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for OK button to be clickable
		perform.waitForElementToBeClickable(driver, VOrderDetails.inspectionScheduledOk_btn(), "cssSelector");
		
		// Click the calendar button
		perform.click(driver,VOrderDetails.inspectionScheduledCalendar_btn(driver));
		
		// Select date
		secure.selectDateFromCalendar(driver, 1);
		
		// Verify the correct order due date is correct
		Assert.assertTrue(VOrderDetails.inspectionScheduledCalendar_txtbx(driver).getAttribute("value").equals(StoredVariables.getcalendarDateLong().get()), "Date selected from calendar is the wrong date");
		
		// Add notes
		perform.type(driver,VOrderDetails.inspectionScheduledNotes_txtbx(driver), "These are Inspection Scheduled notes from Appraiser1");
		
		// Click OK
		perform.click(driver,VOrderDetails.inspectionScheduledOk_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Verify Report is in the Order Documents pane
		orderDocumentsText = VOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(orderDocumentsText.contains("Order Documents"), "Order Documents is not showing in the Order Documents");
		Assert.assertTrue(orderDocumentsText.contains("Other"), "Other is not showing in the Order Documents");
		Assert.assertTrue(orderDocumentsText.contains("Sales Contract"), "Sales Contract is not showing in the Order Documents");
		Assert.assertTrue(orderDocumentsText.contains(StoredVariables.gettodaysDateLong().get()), "The Date Uploaded is not showing in the Order Documents");

		// Get order information text
		orderInformation = VOrderDetails.orderInformation_txt(driver).getText();
		
		// Verify audit trail
		Assert.assertTrue(orderInformation.contains("History (Inspection Scheduled)"), "History (Inspection Scheduled) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Inspection Scheduled by Appraiser (Automation Appraiser1)"), "Inspection Scheduled by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Inspection date is " + StoredVariables.getcalendarDateShort().get()), "Inspection date is " + StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Inspection Scheduled notes from Appraiser1"), "These are Inspection Scheduled notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Document Uploaded from Appraiser (Automation Appraiser1) (Test PDF_1.pdf)"), "Document Uploaded from Appraiser (Automation Appraiser1) (Test PDF_1.pdf) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Message from Appraiser (Automation Appraiser1)"), "Message from Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Message notes from Appraiser1"), "These are Message notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Resumed by Appraiser (Automation Appraiser1)"), "Resumed by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Resume notes from Appraiser1"), "These are Resume notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Delayed by Appraiser (Automation Appraiser1)"), "Delayed by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Delayed notes from Appraiser1"), "These are Delayed notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Order accepted by Appraiser (Automation Appraiser1) and In Progress"), "Order accepted by Appraiser (Automation Appraiser1) and In Progress is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Appraiser1 accepting order notes"), "These are Appraiser1 accepting order notes is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Resumed by Client (Automation VMP1)"), "Resumed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Resume2 test notes from OriginatorVMP1"), "These are Resume2 test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Comment - Action Required by Client (Automation VMP1)"), "Comment - Action Required by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Action Required test notes from OriginatorVMP1"), "These are Action Required test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Message from Client (Automation VMP1)"), "Message from Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are test Send Message notes from OriginatorVMP1"), "These are test Send Message notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Document Uploaded from Client (Automation VMP1) (Test PDF.pdf)"), "Document Uploaded from Client (Automation VMP1) (Test PDF.pdf) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("On Hold by Client (Automation VMP1)"), "On Hold by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Place On Hold test notes from OriginatorVMP1"), "These are Place On Hold test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Resumed by Client (Automation VMP1)"), "Resumed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Resume test notes from OriginatorVMP1"), "These are Resume test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Delayed by Client (Automation VMP1)"), "Delayed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Delayed test notes from OriginatorVMP1"), "These are Delayed test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Awaiting acceptance by Automation Appraiser1"), "Awaiting acceptance by Automation Appraiser1 is missing from the order information");

		// Log in to VMP
		vmp.login(driver, "VMP1", "OriginatorVMP1", StoredVariables.getpassword().get());
		
		// Search for order
		vmp.findOrder(driver, StoredVariables.getloanIDVMP().get(), "Tracking #");
		
		// Verify Order Status
		Assert.assertTrue(VMPOrders.orderStatus_txt(driver).getText().equals("Inspection Scheduled"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getAWSAccountsID().get() + "-" + StoredVariables.getloanIDVMP().get());
		
		// Wait for Other Actions button
		perform.waitForElementToBeVisible(driver, VMPAppraisalOrderDetails.otherActions_btn(), "cssSelector");
		
		// Verify history
		history = VMPAppraisalOrderDetails.history_txt(driver).getText();
		Assert.assertTrue(history.contains("Inspection Scheduled by Automation VMP1"), "Inspection Scheduled by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection date is " + StoredVariables.getcalendarDateShort().get()), "Inspection date is " + StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser1"), "These are Inspection Scheduled notes from Appraiser1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation VMP1"), "Document Uploaded by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Sales Contract"), "Sales Contract is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF_1.pdf"), "Test PDF_1.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation VMP1"), "Message by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser1"), "These are Message notes from Appraiser1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation VMP1"), "Resumed by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser1"), "These are Resume notes from Appraiser1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation VMP1"), "Delayed by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser1"), "These are Delayed notes from Appraiser1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraiser Accepted Assignment by Automation VMP1"), "Appraiser Accepted Assignment by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser1 accepting order notes"), "These are Appraiser1 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorVMP1"), "Resumed by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorVMP1"), "These are Resume2 test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Automation OriginatorVMP1"), "Comment - Action Required by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorVMP1"), "These are Action Required test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation OriginatorVMP1"), "Message by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorVMP1"), "These are test Send Message notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorVMP1"), "Document Uploaded by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Other"), "Other is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF.pdf"), "Test PDF.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Automation OriginatorVMP1"), "On Hold by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorVMP1"), "These are Place On Hold test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorVMP1"), "Resumed by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorVMP1"), "These are Resume test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation OriginatorVMP1"), "Delayed by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorVMP1"), "These are Delayed test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("In Progress by Automation OriginatorVMP1"), "In Progress by Automation OriginatorVMP1 is missing from the audit trail");
		
		// Verify Document is in Documents
		documentText = VMPAppraisalOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Other"), "Other document is not displayed in VMP XSite");
		Assert.assertTrue(documentText.contains("Sales Contract"), "Sales Contract did not sync to VMP XSite");

		// Log in to Secure
		secure.login(driver, "VMP1", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, StoredVariables.getloanID().get(), "Tracking number");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("Inspection Scheduled"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getAWSAccountsID().get() + "-" + StoredVariables.getloanID().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify delayed is in the history
		Assert.assertTrue(history.contains("History (Inspection Scheduled)"), "History (Inspection Scheduled) is missing from the order information");
		Assert.assertTrue(history.contains("Inspection Scheduled by Appraiser (Automation Appraiser1)"), "Inspection Scheduled by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(history.contains("Inspection date is " + StoredVariables.getcalendarDateShort().get()), "Inspection date is " + StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser1"), "These are Inspection Scheduled notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser1) (Test PDF_1.pdf)"), "Document Uploaded from Appraiser (Automation Appraiser1) (Test PDF_1.pdf) is missing from the order information");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser1)"), "Message from Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser1"), "These are Message notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(history.contains("Resumed by Appraiser (Automation Appraiser1)"), "Resumed by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser1"), "These are Resume notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(history.contains("Delayed by Appraiser (Automation Appraiser1)"), "Delayed by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser1"), "These are Delayed notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation VMP1)"), "Comment - Action Required by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorVMP1"), "These are Action Required test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(history.contains("Message from Client (Automation VMP1)"), "Message from Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorVMP1"), "These are test Send Message notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation VMP1) (Test PDF.pdf)"), "Document Uploaded from Client (Automation VMP1) (Test PDF.pdf) is missing from the order information");
		Assert.assertTrue(history.contains("On Hold by Client (Automation VMP1)"), "On Hold by Client (Automation VMP1) did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorVMP1"), "These are Place On Hold test notes from OriginatorVMP1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Resumed by Client (Automation VMP1)"), "Resumed by Client (Automation VMP1) did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorVMP1"), "These are Resume test notes from OriginatorVMP1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Delayed by Client (Automation VMP1)"), "Delayed by Client (Automation VMP1) status did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorVMP1"), "These are Delayed test notes from OriginatorVMP1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser1"), "Awaiting acceptance by Automation Appraiser1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Reassigned by Client (Automation VMP1) to Automation Appraiser1"), "Reassigned by Client (Automation VMP1) to Automation Appraiser1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Requires assignment"), "Requires assignment did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Awaiting acceptance"), "Awaiting acceptance did not sync from VMP to Secure");
		
		// Verify Document is in Documents
		documentText = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Other"), "Other document is not on VMP XSite");
		Assert.assertTrue(documentText.contains("Sales Contract"), "Sales Contract did not sync to VMP XSite");

		// Log in to Vendors
		vendors.login(driver, "Appraiser1", StoredVariables.getpassword().get());
		
		// Search for order
		vendors.findOrder(driver, StoredVariables.getloanID().get(), "Tracking Number");
		
		// Verify order status
		Assert.assertTrue(VOrders.ordersGrid_txt(driver).getText().contains("Inspection Scheduled"), "The order is not in the correct status");
		
		// Click on the order from the orders grid
		perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, VOrderDetails.sendMessage_btn(), "cssSelector");
		
		// Click Set Order Status
		perform.clickInTable_Contains(driver, "Set Order Status");
		
		// Click Inspection Complete
		perform.click(driver,VOrderDetails.inspectionComplete_btn(driver));
		
		// Wait for Overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for OK button to be clickable
		perform.waitForElementToBeClickable(driver, VOrderDetails.inspectionScheduledOk_btn(), "cssSelector");
		
		// Click the calendar button
		perform.click(driver,VOrderDetails.inspectionScheduledCalendar_btn(driver));
		
		// Select date
		secure.selectDateFromCalendar(driver, 1);
		
		// Verify the correct order due date is correct
		Assert.assertTrue(VOrderDetails.inspectionScheduledCalendar_txtbx(driver).getAttribute("value").equals(StoredVariables.getcalendarDateLong().get()), "Date selected from calendar is the wrong date");
		
		// Add notes
		perform.type(driver,VOrderDetails.inspectionScheduledNotes_txtbx(driver), "These are Inspection Complete notes from Appraiser1");
		
		// Click OK
		perform.click(driver,VOrderDetails.inspectionScheduledOk_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Verify Report is in the Order Documents pane
		orderDocumentsText = VOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(orderDocumentsText.contains("Order Documents"), "Order Documents is not showing in the Order Documents");
		Assert.assertTrue(orderDocumentsText.contains("Other"), "Other is not showing in the Order Documents");
		Assert.assertTrue(orderDocumentsText.contains("Sales Contract"), "Sales Contract is not showing in the Order Documents");
		Assert.assertTrue(orderDocumentsText.contains(StoredVariables.gettodaysDateLong().get()), "The Date Uploaded is not showing in the Order Documents");

		// Get order information text
		orderInformation = VOrderDetails.orderInformation_txt(driver).getText();
		
		// Verify audit trail
		Assert.assertTrue(orderInformation.contains("History (Inspection Complete)"), "History (Inspection Complete) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Inspection Complete by Appraiser (Automation Appraiser1)"), "Inspection Complete by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Inspected on " + StoredVariables.getcalendarDateLong().get()), "Inspected on " + StoredVariables.getcalendarDateLong().get() + " is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Inspection Complete notes from Appraiser1"), "These are Inspection Complete notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Inspection Scheduled by Appraiser (Automation Appraiser1)"), "Inspection Scheduled by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Inspection date is " + StoredVariables.getcalendarDateShort().get()), "Inspection date is " + StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Inspection Scheduled notes from Appraiser1"), "These are Inspection Scheduled notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Document Uploaded from Appraiser (Automation Appraiser1) (Test PDF_1.pdf)"), "Document Uploaded from Appraiser (Automation Appraiser1) (Test PDF_1.pdf) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Message from Appraiser (Automation Appraiser1)"), "Message from Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Message notes from Appraiser1"), "These are Message notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Resumed by Appraiser (Automation Appraiser1)"), "Resumed by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Resume notes from Appraiser1"), "These are Resume notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Delayed by Appraiser (Automation Appraiser1)"), "Delayed by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Delayed notes from Appraiser1"), "These are Delayed notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Order accepted by Appraiser (Automation Appraiser1) and In Progress"), "Order accepted by Appraiser (Automation Appraiser1) and In Progress is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Appraiser1 accepting order notes"), "These are Appraiser1 accepting order notes is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Resumed by Client (Automation VMP1)"), "Resumed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Resume2 test notes from OriginatorVMP1"), "These are Resume2 test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Comment - Action Required by Client (Automation VMP1)"), "Comment - Action Required by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Action Required test notes from OriginatorVMP1"), "These are Action Required test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Message from Client (Automation VMP1)"), "Message from Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are test Send Message notes from OriginatorVMP1"), "These are test Send Message notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Document Uploaded from Client (Automation VMP1) (Test PDF.pdf)"), "Document Uploaded from Client (Automation VMP1) (Test PDF.pdf) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("On Hold by Client (Automation VMP1)"), "On Hold by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Place On Hold test notes from OriginatorVMP1"), "These are Place On Hold test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Resumed by Client (Automation VMP1)"), "Resumed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Resume test notes from OriginatorVMP1"), "These are Resume test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Delayed by Client (Automation VMP1)"), "Delayed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Delayed test notes from OriginatorVMP1"), "These are Delayed test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Awaiting acceptance by Automation Appraiser1"), "Awaiting acceptance by Automation Appraiser1 is missing from the order information");

		// Log in to VMP
		vmp.login(driver, "VMP1", "OriginatorVMP1", StoredVariables.getpassword().get());
		
		// Search for order
		vmp.findOrder(driver, StoredVariables.getloanIDVMP().get(), "Tracking #");
		
		// Verify Order Status
		Assert.assertTrue(VMPOrders.orderStatus_txt(driver).getText().equals("Inspection Complete"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getAWSAccountsID().get() + "-" + StoredVariables.getloanIDVMP().get());
		
		// Wait for Other Actions button
		perform.waitForElementToBeVisible(driver, VMPAppraisalOrderDetails.otherActions_btn(), "cssSelector");
		
		// Verify history
		history = VMPAppraisalOrderDetails.history_txt(driver).getText();
		Assert.assertTrue(history.contains("Inspection Complete by Automation VMP1"), "Inspection Complete by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspected on " + StoredVariables.getcalendarDateLong().get()), "Inspected on " + StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser1"), "These are Inspection Complete notes from Appraiser1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Scheduled by Automation VMP1"), "Inspection Scheduled by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection date is " + StoredVariables.getcalendarDateShort().get()), "Inspection date is " + StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser1"), "These are Inspection Scheduled notes from Appraiser1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation VMP1"), "Document Uploaded by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Sales Contract"), "Sales Contract is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF_1.pdf"), "Test PDF_1.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation VMP1"), "Message by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser1"), "These are Message notes from Appraiser1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation VMP1"), "Resumed by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser1"), "These are Resume notes from Appraiser1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation VMP1"), "Delayed by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser1"), "These are Delayed notes from Appraiser1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraiser Accepted Assignment by Automation VMP1"), "Appraiser Accepted Assignment by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser1 accepting order notes"), "These are Appraiser1 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorVMP1"), "Resumed by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorVMP1"), "These are Resume2 test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Automation OriginatorVMP1"), "Comment - Action Required by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorVMP1"), "These are Action Required test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation OriginatorVMP1"), "Message by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorVMP1"), "These are test Send Message notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorVMP1"), "Document Uploaded by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Other"), "Other is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF.pdf"), "Test PDF.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Automation OriginatorVMP1"), "On Hold by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorVMP1"), "These are Place On Hold test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorVMP1"), "Resumed by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorVMP1"), "These are Resume test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation OriginatorVMP1"), "Delayed by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorVMP1"), "These are Delayed test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("In Progress by Automation OriginatorVMP1"), "In Progress by Automation OriginatorVMP1 is missing from the audit trail");
		
		// Verify Document is in Documents
		documentText = VMPAppraisalOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Other"), "Other document is not displayed in VMP XSite");
		Assert.assertTrue(documentText.contains("Sales Contract"), "Sales Contract did not sync to VMP XSite");

		// Log in to Secure
		secure.login(driver, "VMP1", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, StoredVariables.getloanID().get(), "Tracking number");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("Inspection Complete"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getAWSAccountsID().get() + "-" + StoredVariables.getloanID().get());
		
		Thread.sleep(1000);
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify delayed is in the history
		Assert.assertTrue(history.contains("History (Inspection Complete)"), "History (Inspection Complete) is missing from the order information");
		Assert.assertTrue(history.contains("Inspection Complete by Appraiser (Automation Appraiser1)"), "Inspection Complete by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(history.contains("Inspected on " + StoredVariables.getcalendarDateLong().get()), "Inspected on " + StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser1"), "These are Inspection Complete notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(history.contains("Inspection Scheduled by Appraiser (Automation Appraiser1)"), "Inspection Scheduled by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(history.contains("Inspection date is " + StoredVariables.getcalendarDateShort().get()), "Inspection date is " + StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser1"), "These are Inspection Scheduled notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser1) (Test PDF_1.pdf)"), "Document Uploaded from Appraiser (Automation Appraiser1) (Test PDF_1.pdf) is missing from the order information");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser1)"), "Message from Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser1"), "These are Message notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(history.contains("Resumed by Appraiser (Automation Appraiser1)"), "Resumed by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser1"), "These are Resume notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(history.contains("Delayed by Appraiser (Automation Appraiser1)"), "Delayed by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser1"), "These are Delayed notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation VMP1)"), "Comment - Action Required by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorVMP1"), "These are Action Required test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(history.contains("Message from Client (Automation VMP1)"), "Message from Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorVMP1"), "These are test Send Message notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation VMP1) (Test PDF.pdf)"), "Document Uploaded from Client (Automation VMP1) (Test PDF.pdf) is missing from the order information");
		Assert.assertTrue(history.contains("On Hold by Client (Automation VMP1)"), "On Hold by Client (Automation VMP1) did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorVMP1"), "These are Place On Hold test notes from OriginatorVMP1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Resumed by Client (Automation VMP1)"), "Resumed by Client (Automation VMP1) did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorVMP1"), "These are Resume test notes from OriginatorVMP1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Delayed by Client (Automation VMP1)"), "Delayed by Client (Automation VMP1) status did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorVMP1"), "These are Delayed test notes from OriginatorVMP1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser1"), "Awaiting acceptance by Automation Appraiser1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Reassigned by Client (Automation VMP1) to Automation Appraiser1"), "Reassigned by Client (Automation VMP1) to Automation Appraiser1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Requires assignment"), "Requires assignment did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Awaiting acceptance"), "Awaiting acceptance did not sync from VMP to Secure");
		
		// Verify Document is in Documents
		documentText = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Other"), "Other document is not on VMP XSite");
		Assert.assertTrue(documentText.contains("Sales Contract"), "Sales Contract did not sync to VMP XSite");
		
		// Log in to Vendors
		vendors.login(driver, "Appraiser1", StoredVariables.getpassword().get());
		
		// Search for order
		vendors.findOrder(driver, StoredVariables.getloanID().get(), "Tracking Number");
		
		// Verify order status
		Assert.assertTrue(VOrders.ordersGrid_txt(driver).getText().contains("Inspection Complete"), "The order is not in the correct status");
		
		// Click on the order from the orders grid
		perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, VOrderDetails.sendMessage_btn(), "cssSelector");
		
		// Complete the order using the HTTP Post
		vendors.completeOrderByHTTPPost(driver, "Appraiser1", StoredVariables.getpassword().get(), StoredVariables.getloanID().get(), "Complete.xml");
		
		// Verify Report is in the Order Documents pane
		orderDocumentsText = VOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(orderDocumentsText.contains("Order Documents"), "Order Documents is not showing in the Order Documents");
		Assert.assertTrue(orderDocumentsText.contains("Other"), "Other is not showing in the Order Documents");
		Assert.assertTrue(orderDocumentsText.contains("Sales Contract"), "Sales Contract is not showing in the Order Documents");
		Assert.assertTrue(orderDocumentsText.contains("Report PDF"), "Report PDF is not showing in the Order Documents");
		Assert.assertTrue(orderDocumentsText.contains("Completed Report (Current)"), "Completed Report (Current) is not showing in the Order Documents");
		Assert.assertTrue(orderDocumentsText.contains(StoredVariables.gettodaysDateLong().get()), "The Date Uploaded is not showing in the Order Documents");

		// Get order information text
		orderInformation = VOrderDetails.orderInformation_txt(driver).getText();
		
		// Verify audit trail
		Assert.assertTrue(orderInformation.contains("History (In QC - Level One)"), "History (In QC - Level One) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Inspection Complete by Appraiser (Automation Appraiser1)"), "Inspection Complete by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Inspection Complete by Appraiser (Automation Appraiser1)"), "Inspection Complete by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Inspected on " + StoredVariables.getcalendarDateLong().get()), "Inspected on " + StoredVariables.getcalendarDateLong().get() + " is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Inspection Complete notes from Appraiser1"), "These are Inspection Complete notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Inspection Scheduled by Appraiser (Automation Appraiser1)"), "Inspection Scheduled by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Inspection date is " + StoredVariables.getcalendarDateShort().get()), "Inspection date is " + StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Inspection Scheduled notes from Appraiser1"), "These are Inspection Scheduled notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Document Uploaded from Appraiser (Automation Appraiser1) (Test PDF_1.pdf)"), "Document Uploaded from Appraiser (Automation Appraiser1) (Test PDF_1.pdf) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Message from Appraiser (Automation Appraiser1)"), "Message from Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Message notes from Appraiser1"), "These are Message notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Resumed by Appraiser (Automation Appraiser1)"), "Resumed by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Resume notes from Appraiser1"), "These are Resume notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Delayed by Appraiser (Automation Appraiser1)"), "Delayed by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Delayed notes from Appraiser1"), "These are Delayed notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Order accepted by Appraiser (Automation Appraiser1) and In Progress"), "Order accepted by Appraiser (Automation Appraiser1) and In Progress is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Appraiser1 accepting order notes"), "These are Appraiser1 accepting order notes is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Resumed by Client (Automation VMP1)"), "Resumed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Resume2 test notes from OriginatorVMP1"), "These are Resume2 test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Comment - Action Required by Client (Automation VMP1)"), "Comment - Action Required by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Action Required test notes from OriginatorVMP1"), "These are Action Required test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Message from Client (Automation VMP1)"), "Message from Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are test Send Message notes from OriginatorVMP1"), "These are test Send Message notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Document Uploaded from Client (Automation VMP1) (Test PDF.pdf)"), "Document Uploaded from Client (Automation VMP1) (Test PDF.pdf) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("On Hold by Client (Automation VMP1)"), "On Hold by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Place On Hold test notes from OriginatorVMP1"), "These are Place On Hold test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Resumed by Client (Automation VMP1)"), "Resumed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Resume test notes from OriginatorVMP1"), "These are Resume test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Delayed by Client (Automation VMP1)"), "Delayed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Delayed test notes from OriginatorVMP1"), "These are Delayed test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Awaiting acceptance by Automation Appraiser1"), "Awaiting acceptance by Automation Appraiser1 is missing from the order information");
		
		// Click Sales Contract
		perform.clickInTable_Contains(driver, "Report PDF");
		
		// Wait for text
		perform.waitForText(driver, VOrderDetails.documents_txt(driver), "Automation Appraiser1");
		orderDocumentsText = VOrderDetails.documents_txt(driver).getText();
		
		// Verify Uploaded By and Document Name
		Assert.assertTrue(orderDocumentsText.contains("Test PDF"), "Test PDF is not showing as the Document Name in Order Documents");
		Assert.assertTrue(orderDocumentsText.contains("Automation Appraiser1"), "Automation Appraiser1 is not showing as the Document Name in Order Documents");

		// Log in to Secure
		secure.login(driver, "VMP1", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, StoredVariables.getloanID().get(), "Tracking number");
		
		// Verify order status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("In QC - Level One"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getAWSAccountsID().get() + "-" + StoredVariables.getloanID().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify delayed is in the history
		Assert.assertTrue(history.contains("History (In QC - Level One)"), "History (In QC - Level One) is missing from the order information");
		Assert.assertTrue(history.contains("Order delivered by Appraiser (Automation Appraiser1) and is now In QC - Level One"), "Order delivered by Appraiser (Automation Appraiser1) and is now In QC - Level One status did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Inspection Complete by Appraiser (Automation Appraiser1)"), "Inspection Complete by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(history.contains("Inspected on " + StoredVariables.getcalendarDateLong().get()), "Inspected on " + StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser1"), "These are Inspection Complete notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(history.contains("Inspection Scheduled by Appraiser (Automation Appraiser1)"), "Inspection Scheduled by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(history.contains("Inspection date is " + StoredVariables.getcalendarDateShort().get()), "Inspection date is " + StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser1"), "These are Inspection Scheduled notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser1) (Test PDF_1.pdf)"), "Document Uploaded from Appraiser (Automation Appraiser1) (Test PDF_1.pdf) is missing from the order information");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser1)"), "Message from Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser1"), "These are Message notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(history.contains("Resumed by Appraiser (Automation Appraiser1)"), "Resumed by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser1"), "These are Resume notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(history.contains("Delayed by Appraiser (Automation Appraiser1)"), "Delayed by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser1"), "These are Delayed notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation VMP1)"), "Comment - Action Required by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorVMP1"), "These are Action Required test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(history.contains("Message from Client (Automation VMP1)"), "Message from Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorVMP1"), "These are test Send Message notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation VMP1) (Test PDF.pdf)"), "Document Uploaded from Client (Automation VMP1) (Test PDF.pdf) is missing from the order information");
		Assert.assertTrue(history.contains("On Hold by Client (Automation VMP1)"), "On Hold by Client (Automation VMP1) did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorVMP1"), "These are Place On Hold test notes from OriginatorVMP1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Resumed by Client (Automation VMP1)"), "Resumed by Client (Automation VMP1) did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorVMP1"), "These are Resume test notes from OriginatorVMP1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Delayed by Client (Automation VMP1)"), "Delayed by Client (Automation VMP1) status did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorVMP1"), "These are Delayed test notes from OriginatorVMP1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser1"), "Awaiting acceptance by Automation Appraiser1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Reassigned by Client (Automation VMP1) to Automation Appraiser1"), "Reassigned by Client (Automation VMP1) to Automation Appraiser1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Requires assignment"), "Requires assignment did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Awaiting acceptance"), "Awaiting acceptance did not sync from VMP to Secure");
		
		// Verify Document is in Documents
		documentText = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Completed Report (Current)"), "Completed Report (Current) document is not on VMP XSite");
		Assert.assertTrue(documentText.contains("Order Documents"), "Order Documents document is not on VMP XSite");
		Assert.assertTrue(documentText.contains("Report PDF"), "Report PDF document is not on VMP XSite");
		Assert.assertTrue(documentText.contains("Other"), "Other document is not on VMP XSite");
		Assert.assertTrue(documentText.contains("Sales Contract"), "Sales Contract did not sync to VMP XSite");
		
		// Click on Sales Contract
		perform.clickInTable_Contains(driver, "Report PDF");
		
		// Wait for text to update
		perform.waitForText(driver, SOrderDetails.documents_txt(driver), "Test PDF.pdf");
		documentText = SOrderDetails.documents_txt(driver).getText();
		
		// Verify file name and uploaded by
		Assert.assertTrue(documentText.contains("Test PDF"), "Document name is incorrect in Documents for Report PDF");
		Assert.assertTrue(documentText.contains("Automation Appraiser1"), "Uploaded By is incorrect in Documents");
		
		// Log in to VMP
		vmp.login(driver, "VMP1", "OriginatorVMP1", StoredVariables.getpassword().get());
		
		// Search for order
		vmp.findOrder(driver, StoredVariables.getloanIDVMP().get(), "Tracking #");
		
		// Verify order status
		Assert.assertTrue(VMPOrders.orderStatus_txt(driver).getText().equals("Pending Quality Review"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getAWSAccountsID().get() + "-" + StoredVariables.getloanIDVMP().get());
		
		// Wait for Other Actions button
		perform.waitForElementToBeVisible(driver, VMPAppraisalOrderDetails.otherActions_btn(), "cssSelector");
		
		// Verify history
		history = VMPAppraisalOrderDetails.history_txt(driver).getText();
		Assert.assertTrue(history.contains("Pending Quality Review by Automation VMP1"), "Pending Quality Review by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Complete by Automation VMP1"), "Inspection Complete by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspected on " + StoredVariables.getcalendarDateLong().get()), "Inspected on " + StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser1"), "These are Inspection Complete notes from Appraiser1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Scheduled by Automation VMP1"), "Inspection Scheduled by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection date is " + StoredVariables.getcalendarDateShort().get()), "Inspection date is " + StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser1"), "These are Inspection Scheduled notes from Appraiser1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation VMP1"), "Document Uploaded by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Sales Contract"), "Sales Contract is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF_1.pdf"), "Test PDF_1.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation VMP1"), "Message by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser1"), "These are Message notes from Appraiser1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation VMP1"), "Resumed by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser1"), "These are Resume notes from Appraiser1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation VMP1"), "Delayed by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser1"), "These are Delayed notes from Appraiser1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraiser Accepted Assignment by Automation VMP1"), "Appraiser Accepted Assignment by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser1 accepting order notes"), "These are Appraiser1 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorVMP1"), "Resumed by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorVMP1"), "These are Resume2 test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Automation OriginatorVMP1"), "Comment - Action Required by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorVMP1"), "These are Action Required test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation OriginatorVMP1"), "Message by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorVMP1"), "These are test Send Message notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorVMP1"), "Document Uploaded by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Other"), "Other is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF.pdf"), "Test PDF.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Automation OriginatorVMP1"), "On Hold by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorVMP1"), "These are Place On Hold test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorVMP1"), "Resumed by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorVMP1"), "These are Resume test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation OriginatorVMP1"), "Delayed by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorVMP1"), "These are Delayed test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("In Progress by Automation OriginatorVMP1"), "In Progress by Automation OriginatorVMP1 is missing from the audit trail");
		
		// Verify Document is in Documents
		documentText = VMPAppraisalOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Other"), "Other document is not displayed in VMP XSite");
		Assert.assertTrue(documentText.contains("Sales Contract"), "Sales Contract did not sync to VMP XSite");
		
		// Click on Sales Contract
		perform.clickInTable_Contains(driver, "Sales Contract");
		
		// Wait for text to update
		perform.waitForText(driver, VMPAppraisalOrderDetails.documents_txt(driver), "Test PDF_1.pdf");
		documentText = VMPAppraisalOrderDetails.documents_txt(driver).getText();
		
		// Verify file name and uploaded by
		Assert.assertTrue(documentText.contains("Test PDF_1.pdf"), "Document name is incorrect in Documents");
		Assert.assertTrue(documentText.contains("Automation VMP1"), "Uploaded By is incorrect in Documents");
		
		// Log in to Secure
		secure.login(driver, "VMP1", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, StoredVariables.getloanID().get(), "Tracking number");
		
		// Verify order status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("In QC - Level One"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getAWSAccountsID().get() + "-" + StoredVariables.getloanID().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Verify order details
		secure.verifyResidentialAppraisalOrderDetails(driver);

		// Select Request vendor make revisions to this report
		perform.click(driver,SOrderDetails.requestRevision_radioBtn(driver));
		
		// Wait for textbox
		perform.waitForElementToBeClickable(driver, SOrderDetails.commentsToVendor_txtbx(), "id");
		
		// Enter comments to vendor
		perform.type(driver,SOrderDetails.commentsToVendor_txtbx(driver), "Requesting a revision from Automation VMP1");
		
		// Check Update status on VMP XSite and notify client
		perform.click(driver,SOrderDetails.updateStatusOnVMP_chkbx(driver));
		
		Thread.sleep(1000);
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SOrderDetails.okProcessReceivedReport_btn(), "id");
		
		// Click OK		
		perform.click(driver,SOrderDetails.okProcessReceivedReport_btn(driver));
		
		// Wait for Find text box
		perform.waitForElementToBeClickable(driver, SOrders.find_txtbx(), "id");

		// Log in to VMP
		vmp.login(driver, "VMP1", "OriginatorVMP1", StoredVariables.getpassword().get());
		
		// Search for order
		vmp.findOrder(driver, StoredVariables.getloanIDVMP().get(), "Tracking #");
		
		// Verify order status
		Assert.assertTrue(VMPOrders.orderStatus_txt(driver).getText().equals("Revision Needed"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getAWSAccountsID().get() + "-" + StoredVariables.getloanIDVMP().get());
		
		// Wait for Other Actions button
		perform.waitForElementToBeVisible(driver, VMPAppraisalOrderDetails.otherActions_btn(), "cssSelector");
		
		// Verify history
		history = VMPAppraisalOrderDetails.history_txt(driver).getText();
		Assert.assertTrue(history.contains("Revision Needed by Automation VMP1"), "Revision Needed by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Requesting a revision from Automation VMP1"), "Requesting a revision from Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Pending Quality Review by Automation VMP1"), "Pending Quality Review by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Complete by Automation VMP1"), "Inspection Complete by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspected on " + StoredVariables.getcalendarDateLong().get()), "Inspected on " + StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser1"), "These are Inspection Complete notes from Appraiser1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Scheduled by Automation VMP1"), "Inspection Scheduled by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection date is " + StoredVariables.getcalendarDateShort().get()), "Inspection date is " + StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser1"), "These are Inspection Scheduled notes from Appraiser1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation VMP1"), "Document Uploaded by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Sales Contract"), "Sales Contract is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF_1.pdf"), "Test PDF_1.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation VMP1"), "Message by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser1"), "These are Message notes from Appraiser1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation VMP1"), "Resumed by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser1"), "These are Resume notes from Appraiser1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation VMP1"), "Delayed by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser1"), "These are Delayed notes from Appraiser1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraiser Accepted Assignment by Automation VMP1"), "Appraiser Accepted Assignment by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser1 accepting order notes"), "These are Appraiser1 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorVMP1"), "Resumed by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorVMP1"), "These are Resume2 test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Automation OriginatorVMP1"), "Comment - Action Required by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorVMP1"), "These are Action Required test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation OriginatorVMP1"), "Message by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorVMP1"), "These are test Send Message notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorVMP1"), "Document Uploaded by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Other"), "Other is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF.pdf"), "Test PDF.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Automation OriginatorVMP1"), "On Hold by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorVMP1"), "These are Place On Hold test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorVMP1"), "Resumed by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorVMP1"), "These are Resume test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation OriginatorVMP1"), "Delayed by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorVMP1"), "These are Delayed test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("In Progress by Automation OriginatorVMP1"), "In Progress by Automation OriginatorVMP1 is missing from the audit trail");
		
		// Verify Document is in Documents
		documentText = VMPAppraisalOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Other"), "Other document is not displayed in VMP XSite");
		Assert.assertTrue(documentText.contains("Sales Contract"), "Sales Contract did not sync to VMP XSite");
		
		// Log in to Vendors
		vendors.login(driver, "Appraiser1", StoredVariables.getpassword().get());
		
		// Search for order
		vendors.findOrder(driver, StoredVariables.getloanID().get(), "Tracking Number");
		
		// Verify order status
		Assert.assertTrue(VOrders.ordersGrid_txt(driver).getText().contains("Revision Needed"), "The order is not in the correct status");
		
		// Click on the order from the orders grid
		perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, VOrderDetails.sendMessage_btn(), "cssSelector");
		
		// Verify Report is in the Order Documents pane
		orderDocumentsText = VOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(orderDocumentsText.contains("Order Documents"), "Order Documents is not showing in the Order Documents");
		Assert.assertTrue(orderDocumentsText.contains("Other"), "Other is not showing in the Order Documents");
		Assert.assertTrue(orderDocumentsText.contains("Sales Contract"), "Sales Contract is not showing in the Order Documents");
		Assert.assertTrue(orderDocumentsText.contains("Report PDF"), "Report PDF is not showing in the Order Documents");
		Assert.assertTrue(orderDocumentsText.contains("Completed Report (Current)"), "Completed Report (Current) is not showing in the Order Documents");
		Assert.assertTrue(orderDocumentsText.contains(StoredVariables.gettodaysDateLong().get()), "The Date Uploaded is not showing in the Order Documents");

		// Get order information text
		orderInformation = VOrderDetails.orderInformation_txt(driver).getText();
		
		// Verify audit trail
		Assert.assertTrue(orderInformation.contains("History (Revision Needed)"), "History (Revision Needed) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Revision Needed by Client (Automation VMP1)"), "Revision Needed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Requesting a revision from Automation VMP1"), "Requesting a revision from Automation VMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Inspection Complete by Appraiser (Automation Appraiser1)"), "Inspection Complete by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Inspection Complete by Appraiser (Automation Appraiser1)"), "Inspection Complete by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Inspected on " + StoredVariables.getcalendarDateLong().get()), "Inspected on " + StoredVariables.getcalendarDateLong().get() + " is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Inspection Complete notes from Appraiser1"), "These are Inspection Complete notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Inspection Scheduled by Appraiser (Automation Appraiser1)"), "Inspection Scheduled by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Inspection date is " + StoredVariables.getcalendarDateShort().get()), "Inspection date is " + StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Inspection Scheduled notes from Appraiser1"), "These are Inspection Scheduled notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Document Uploaded from Appraiser (Automation Appraiser1) (Test PDF_1.pdf)"), "Document Uploaded from Appraiser (Automation Appraiser1) (Test PDF_1.pdf) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Message from Appraiser (Automation Appraiser1)"), "Message from Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Message notes from Appraiser1"), "These are Message notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Resumed by Appraiser (Automation Appraiser1)"), "Resumed by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Resume notes from Appraiser1"), "These are Resume notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Delayed by Appraiser (Automation Appraiser1)"), "Delayed by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Delayed notes from Appraiser1"), "These are Delayed notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Order accepted by Appraiser (Automation Appraiser1) and In Progress"), "Order accepted by Appraiser (Automation Appraiser1) and In Progress is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Appraiser1 accepting order notes"), "These are Appraiser1 accepting order notes is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Resumed by Client (Automation VMP1)"), "Resumed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Resume2 test notes from OriginatorVMP1"), "These are Resume2 test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Comment - Action Required by Client (Automation VMP1)"), "Comment - Action Required by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Action Required test notes from OriginatorVMP1"), "These are Action Required test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Message from Client (Automation VMP1)"), "Message from Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are test Send Message notes from OriginatorVMP1"), "These are test Send Message notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Document Uploaded from Client (Automation VMP1) (Test PDF.pdf)"), "Document Uploaded from Client (Automation VMP1) (Test PDF.pdf) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("On Hold by Client (Automation VMP1)"), "On Hold by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Place On Hold test notes from OriginatorVMP1"), "These are Place On Hold test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Resumed by Client (Automation VMP1)"), "Resumed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Resume test notes from OriginatorVMP1"), "These are Resume test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Delayed by Client (Automation VMP1)"), "Delayed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Delayed test notes from OriginatorVMP1"), "These are Delayed test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Awaiting acceptance by Automation Appraiser1"), "Awaiting acceptance by Automation Appraiser1 is missing from the order information");

		secure.login(driver, "VMP1", StoredVariables.getpassword().get());
		
		perform.waitForElementToBeClickable(driver, SOrders.preferences_btn(), "id");
		
		perform.click(driver,SOrders.preferences_btn(driver));
		
		perform.waitForElementToBeClickable(driver, SPreferences.vmpXSites_btn(), "cssSelector");
		
		perform.click(driver,SPreferences.vmpXSites_btn(driver));
		
		perform.waitForElementToBeClickable(driver, SVMPXSites.configureStatusMapping_lnk(), "id");
		
		perform.click(driver,SVMPXSites.configureStatusMapping_lnk(driver));
		
		perform.waitForElementToBeVisible(driver, SVMPXSites.statusMappingConfiguration_txt(), "id");
		
		// Uncheck Pending Quality Review
		secure.setStatusMapping(driver, "Pending Quality Review", "none");
		
		// Uncheck VMP Message arrow
		secure.setStatusMapping(driver, "Message", "none");
		
		// Click Save
		perform.clickInTable_Contains(driver, "Save");
		
		// Wait for save dialog to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for save dialog to be hidden 
		perform.waitForOverlayToBeHidden(driver);
		
		// Log in to Vendors
		vendors.login(driver, "Appraiser1", StoredVariables.getpassword().get());
		
		// Search for order
		vendors.findOrder(driver, StoredVariables.getloanID().get(), "Tracking Number");
		
		// Verify order status
		Assert.assertTrue(VOrders.ordersGrid_txt(driver).getText().contains("Revision Needed"), "The order is not in the correct status");
		
		// Click on the order from the orders grid
		perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, VOrderDetails.sendMessage_btn(), "cssSelector");
		
		// Verify Report is in the Order Documents pane
		orderDocumentsText = VOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(orderDocumentsText.contains("Order Documents"), "Order Documents is not showing in the Order Documents");
		Assert.assertTrue(orderDocumentsText.contains("Other"), "Other is not showing in the Order Documents");
		Assert.assertTrue(orderDocumentsText.contains("Sales Contract"), "Sales Contract is not showing in the Order Documents");
		Assert.assertTrue(orderDocumentsText.contains("Report PDF"), "Report PDF is not showing in the Order Documents");
		Assert.assertTrue(orderDocumentsText.contains("Completed Report (Current)"), "Completed Report (Current) is not showing in the Order Documents");
		Assert.assertTrue(orderDocumentsText.contains(StoredVariables.gettodaysDateLong().get()), "The Date Uploaded is not showing in the Order Documents");

		// Get order information text
		orderInformation = VOrderDetails.orderInformation_txt(driver).getText();
		
		// Verify audit trail
		Assert.assertTrue(orderInformation.contains("History (Revision Needed)"), "History (Revision Needed) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Revision Needed by Client (Automation VMP1)"), "Revision Needed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Requesting a revision from Automation VMP1"), "Requesting a revision from Automation VMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Inspection Complete by Appraiser (Automation Appraiser1)"), "Inspection Complete by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Inspection Complete by Appraiser (Automation Appraiser1)"), "Inspection Complete by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Inspected on " + StoredVariables.getcalendarDateLong().get()), "Inspected on " + StoredVariables.getcalendarDateLong().get() + " is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Inspection Complete notes from Appraiser1"), "These are Inspection Complete notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Inspection Scheduled by Appraiser (Automation Appraiser1)"), "Inspection Scheduled by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Inspection date is " + StoredVariables.getcalendarDateShort().get()), "Inspection date is " + StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Inspection Scheduled notes from Appraiser1"), "These are Inspection Scheduled notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Document Uploaded from Appraiser (Automation Appraiser1) (Test PDF_1.pdf)"), "Document Uploaded from Appraiser (Automation Appraiser1) (Test PDF_1.pdf) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Message from Appraiser (Automation Appraiser1)"), "Message from Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Message notes from Appraiser1"), "These are Message notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Resumed by Appraiser (Automation Appraiser1)"), "Resumed by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Resume notes from Appraiser1"), "These are Resume notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Delayed by Appraiser (Automation Appraiser1)"), "Delayed by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Delayed notes from Appraiser1"), "These are Delayed notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Order accepted by Appraiser (Automation Appraiser1) and In Progress"), "Order accepted by Appraiser (Automation Appraiser1) and In Progress is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Appraiser1 accepting order notes"), "These are Appraiser1 accepting order notes is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Resumed by Client (Automation VMP1)"), "Resumed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Resume2 test notes from OriginatorVMP1"), "These are Resume2 test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Comment - Action Required by Client (Automation VMP1)"), "Comment - Action Required by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Action Required test notes from OriginatorVMP1"), "These are Action Required test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Message from Client (Automation VMP1)"), "Message from Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are test Send Message notes from OriginatorVMP1"), "These are test Send Message notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Document Uploaded from Client (Automation VMP1) (Test PDF.pdf)"), "Document Uploaded from Client (Automation VMP1) (Test PDF.pdf) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("On Hold by Client (Automation VMP1)"), "On Hold by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Place On Hold test notes from OriginatorVMP1"), "These are Place On Hold test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Resumed by Client (Automation VMP1)"), "Resumed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Resume test notes from OriginatorVMP1"), "These are Resume test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Delayed by Client (Automation VMP1)"), "Delayed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Delayed test notes from OriginatorVMP1"), "These are Delayed test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Awaiting acceptance by Automation Appraiser1"), "Awaiting acceptance by Automation Appraiser1 is missing from the order information");
		
		// View Order Details
		vendors.verifyOrderDetails(driver);
		
		// Complete the order using the HTTP Post
		vendors.completeOrderByHTTPPost(driver, "Appraiser1", StoredVariables.getpassword().get(), StoredVariables.getloanID().get(), "Complete.xml");
		
		// Verify Report is in the Order Documents pane
		orderDocumentsText = VOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(orderDocumentsText.contains("Order Documents"), "Order Documents is not showing in the Order Documents");
		Assert.assertTrue(orderDocumentsText.contains("Other"), "Other is not showing in the Order Documents");
		Assert.assertTrue(orderDocumentsText.contains("Sales Contract"), "Sales Contract is not showing in the Order Documents");
		Assert.assertTrue(orderDocumentsText.contains("Report PDF"), "Report PDF is not showing in the Order Documents");
		Assert.assertTrue(orderDocumentsText.contains("Completed Report (Current)"), "Completed Report (Current) is not showing in the Order Documents");
		Assert.assertTrue(orderDocumentsText.contains("Previously Completed Reports"), "Previously Completed Reports is not showing in the Order Documents");
		Assert.assertTrue(orderDocumentsText.contains("Completed Report"), "Completed Report is not showing in the Order Documents");
		Assert.assertTrue(orderDocumentsText.contains(StoredVariables.gettodaysDateLong().get()), "The Date Uploaded is not showing in the Order Documents");

		// Get order information text
		orderInformation = VOrderDetails.orderInformation_txt(driver).getText();
		
		// Verify audit trail
		Assert.assertTrue(orderInformation.contains("History (Revised Report)"), "History (Revised Report) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Revised Report delivered by Appraiser (Automation Appraiser1)"), "Revised Report delivered by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Revision Needed by Client (Automation VMP1)"), "Revision Needed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Requesting a revision from Automation VMP1"), "Requesting a revision from Automation VMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Inspection Complete by Appraiser (Automation Appraiser1)"), "Inspection Complete by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Inspection Complete by Appraiser (Automation Appraiser1)"), "Inspection Complete by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Inspected on " + StoredVariables.getcalendarDateLong().get()), "Inspected on " + StoredVariables.getcalendarDateLong().get() + " is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Inspection Complete notes from Appraiser1"), "These are Inspection Complete notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Inspection Scheduled by Appraiser (Automation Appraiser1)"), "Inspection Scheduled by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Inspection date is " + StoredVariables.getcalendarDateShort().get()), "Inspection date is " + StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Inspection Scheduled notes from Appraiser1"), "These are Inspection Scheduled notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Document Uploaded from Appraiser (Automation Appraiser1) (Test PDF_1.pdf)"), "Document Uploaded from Appraiser (Automation Appraiser1) (Test PDF_1.pdf) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Message from Appraiser (Automation Appraiser1)"), "Message from Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Message notes from Appraiser1"), "These are Message notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Resumed by Appraiser (Automation Appraiser1)"), "Resumed by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Resume notes from Appraiser1"), "These are Resume notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Delayed by Appraiser (Automation Appraiser1)"), "Delayed by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Delayed notes from Appraiser1"), "These are Delayed notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Order accepted by Appraiser (Automation Appraiser1) and In Progress"), "Order accepted by Appraiser (Automation Appraiser1) and In Progress is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Appraiser1 accepting order notes"), "These are Appraiser1 accepting order notes is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Resumed by Client (Automation VMP1)"), "Resumed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Resume2 test notes from OriginatorVMP1"), "These are Resume2 test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Comment - Action Required by Client (Automation VMP1)"), "Comment - Action Required by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Action Required test notes from OriginatorVMP1"), "These are Action Required test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Message from Client (Automation VMP1)"), "Message from Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are test Send Message notes from OriginatorVMP1"), "These are test Send Message notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Document Uploaded from Client (Automation VMP1) (Test PDF.pdf)"), "Document Uploaded from Client (Automation VMP1) (Test PDF.pdf) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("On Hold by Client (Automation VMP1)"), "On Hold by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Place On Hold test notes from OriginatorVMP1"), "These are Place On Hold test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Resumed by Client (Automation VMP1)"), "Resumed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Resume test notes from OriginatorVMP1"), "These are Resume test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Delayed by Client (Automation VMP1)"), "Delayed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Delayed test notes from OriginatorVMP1"), "These are Delayed test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Awaiting acceptance by Automation Appraiser1"), "Awaiting acceptance by Automation Appraiser1 is missing from the order information");
		
		// Click Sales Contract
		perform.clickInTable_Contains(driver, "Report PDF");
		
		// Wait for text
		perform.waitForText(driver, VOrderDetails.documents_txt(driver), "Automation Appraiser1");
		orderDocumentsText = VOrderDetails.documents_txt(driver).getText();
		
		// Verify Uploaded By and Document Name
		Assert.assertTrue(orderDocumentsText.contains("Test PDF"), "Test PDF is not showing as the Document Name in Order Documents");
		Assert.assertTrue(orderDocumentsText.contains("Automation Appraiser1"), "Automation Appraiser1 is not showing as the Document Name in Order Documents");

		// Log in to Secure
		secure.login(driver, "VMP1", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, StoredVariables.getloanID().get(), "Tracking number");
		
		// Verify order status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("Revised Report"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getAWSAccountsID().get() + "-" + StoredVariables.getloanID().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify delayed is in the history
		Assert.assertTrue(history.contains("Revised Report delivered by Appraiser (Automation Appraiser1)"), "Revised Report delivered by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(history.contains("Revision Needed by Client (Automation VMP1)"), "Revision Needed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(history.contains("Requesting a revision from Automation VMP1"), "Requesting a revision from Automation VMP1 is missing from the order information");
		Assert.assertTrue(history.contains("Order delivered by Appraiser (Automation Appraiser1) and is now In QC - Level One"), "Order delivered by Appraiser (Automation Appraiser1) and is now In QC - Level One status did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Inspection Complete by Appraiser (Automation Appraiser1)"), "Inspection Complete by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(history.contains("Inspected on " + StoredVariables.getcalendarDateLong().get()), "Inspected on " + StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser1"), "These are Inspection Complete notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(history.contains("Inspection Scheduled by Appraiser (Automation Appraiser1)"), "Inspection Scheduled by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(history.contains("Inspection date is " + StoredVariables.getcalendarDateShort().get()), "Inspection date is " + StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser1"), "These are Inspection Scheduled notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser1) (Test PDF_1.pdf)"), "Document Uploaded from Appraiser (Automation Appraiser1) (Test PDF_1.pdf) is missing from the order information");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser1)"), "Message from Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser1"), "These are Message notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(history.contains("Resumed by Appraiser (Automation Appraiser1)"), "Resumed by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser1"), "These are Resume notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(history.contains("Delayed by Appraiser (Automation Appraiser1)"), "Delayed by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser1"), "These are Delayed notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation VMP1)"), "Comment - Action Required by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorVMP1"), "These are Action Required test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(history.contains("Message from Client (Automation VMP1)"), "Message from Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorVMP1"), "These are test Send Message notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation VMP1) (Test PDF.pdf)"), "Document Uploaded from Client (Automation VMP1) (Test PDF.pdf) is missing from the order information");
		Assert.assertTrue(history.contains("On Hold by Client (Automation VMP1)"), "On Hold by Client (Automation VMP1) did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorVMP1"), "These are Place On Hold test notes from OriginatorVMP1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Resumed by Client (Automation VMP1)"), "Resumed by Client (Automation VMP1) did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorVMP1"), "These are Resume test notes from OriginatorVMP1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Delayed by Client (Automation VMP1)"), "Delayed by Client (Automation VMP1) status did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorVMP1"), "These are Delayed test notes from OriginatorVMP1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser1"), "Awaiting acceptance by Automation Appraiser1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Reassigned by Client (Automation VMP1) to Automation Appraiser1"), "Reassigned by Client (Automation VMP1) to Automation Appraiser1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Requires assignment"), "Requires assignment did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Awaiting acceptance"), "Awaiting acceptance did not sync from VMP to Secure");
		
		// Verify Document is in Documents
		documentText = SOrderDetails.documents_txt(driver).getText();
		System.out.println("documentText = " + documentText);
		Assert.assertTrue(documentText.contains("Completed Report (Current)"), "Completed Report (Current) document is not on VMP XSite");
		Assert.assertTrue(documentText.contains("Order Documents"), "Order Documents document is not on VMP XSite");
		Assert.assertTrue(documentText.contains("Report PDF"), "Report PDF document is not on VMP XSite");
		Assert.assertTrue(documentText.contains("Other"), "Other document is not on VMP XSite");
		Assert.assertTrue(documentText.contains("Sales Contract"), "Sales Contract did not sync to VMP XSite");
		Assert.assertTrue(documentText.contains("Previously Completed Reports"), "Previously Completed Reports document is not on VMP XSite");
		Assert.assertTrue(documentText.contains("Completed Report"), "Completed Report document is not on VMP XSite");
		
		// Click on Sales Contract
		perform.clickInTable_Contains(driver, "Report PDF");
		
		// Wait for text to update
		perform.waitForText(driver, SOrderDetails.documents_txt(driver), "Test PDF_1.pdf");
		documentText = SOrderDetails.documents_txt(driver).getText();
		
		// Verify file name and uploaded by
		Assert.assertTrue(documentText.contains("Test PDF"), "Document name is incorrect in Documents for Report PDF");
		Assert.assertTrue(documentText.contains("Automation Appraiser1"), "Uploaded By is incorrect in Documents");

		// Log in to VMP
		vmp.login(driver, "VMP1", "OriginatorVMP1", StoredVariables.getpassword().get());
		
		// Search for order
		vmp.findOrder(driver, StoredVariables.getloanIDVMP().get(), "Tracking #");
		
		// Verify order status
		Assert.assertTrue(VMPOrders.orderStatus_txt(driver).getText().equals("Revision Needed"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getAWSAccountsID().get() + "-" + StoredVariables.getloanIDVMP().get());
		
		// Wait for Other Actions button
		perform.waitForElementToBeVisible(driver, VMPAppraisalOrderDetails.otherActions_btn(), "cssSelector");
		
		// Verify history
		history = VMPAppraisalOrderDetails.history_txt(driver).getText();
		Assert.assertTrue(history.contains("Revision Needed by Automation VMP1"), "Revision Needed by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Requesting a revision from Automation VMP1"), "Requesting a revision from Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Pending Quality Review by Automation VMP1"), "Pending Quality Review by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Complete by Automation VMP1"), "Inspection Complete by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspected on " + StoredVariables.getcalendarDateLong().get()), "Inspected on " + StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser1"), "These are Inspection Complete notes from Appraiser1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Scheduled by Automation VMP1"), "Inspection Scheduled by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection date is " + StoredVariables.getcalendarDateShort().get()), "Inspection date is " + StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser1"), "These are Inspection Scheduled notes from Appraiser1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation VMP1"), "Document Uploaded by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Sales Contract"), "Sales Contract is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF_1.pdf"), "Test PDF_1.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation VMP1"), "Message by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser1"), "These are Message notes from Appraiser1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation VMP1"), "Resumed by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser1"), "These are Resume notes from Appraiser1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation VMP1"), "Delayed by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser1"), "These are Delayed notes from Appraiser1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraiser Accepted Assignment by Automation VMP1"), "Appraiser Accepted Assignment by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser1 accepting order notes"), "These are Appraiser1 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorVMP1"), "Resumed by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorVMP1"), "These are Resume2 test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Automation OriginatorVMP1"), "Comment - Action Required by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorVMP1"), "These are Action Required test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation OriginatorVMP1"), "Message by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorVMP1"), "These are test Send Message notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorVMP1"), "Document Uploaded by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Other"), "Other is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF.pdf"), "Test PDF.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Automation OriginatorVMP1"), "On Hold by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorVMP1"), "These are Place On Hold test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorVMP1"), "Resumed by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorVMP1"), "These are Resume test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation OriginatorVMP1"), "Delayed by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorVMP1"), "These are Delayed test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("In Progress by Automation OriginatorVMP1"), "In Progress by Automation OriginatorVMP1 is missing from the audit trail");
		
		// Verify Document is in Documents
		documentText = VMPAppraisalOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Other"), "Other document is not displayed in VMP XSite");
		Assert.assertTrue(documentText.contains("Sales Contract"), "Sales Contract did not sync to VMP XSite");
		
		// Log in to Vendors
		vendors.login(driver, "Appraiser1", StoredVariables.getpassword().get());
		
		// Search for order
		vendors.findOrder(driver, StoredVariables.getloanID().get(), "Tracking Number");
		
		// Verify order status
		Assert.assertTrue(VOrders.ordersGrid_txt(driver).getText().contains("Revised Report"), "The order is not in the correct status");
		
		// Click on the order from the orders grid
		perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, VOrderDetails.sendMessage_btn(), "cssSelector");
		
		// Click Message
		perform.click(driver,VOrderDetails.sendMessage_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for OK button to be clickable
		perform.waitForElementToBeClickable(driver, VOrderDetails.sendMessageOk_btn(), "cssSelector");
		
		// Add notes
		perform.type(driver,VOrderDetails.sendMessageNotes_txtbx(driver), "These are additional Message notes from Appraiser1");
		
		// Click Send button
		perform.click(driver,VOrderDetails.sendMessageOk_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Verify Report is in the Order Documents pane
		orderDocumentsText = VOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(orderDocumentsText.contains("Order Documents"), "Order Documents is not showing in the Order Documents");
		Assert.assertTrue(orderDocumentsText.contains("Other"), "Other is not showing in the Order Documents");
		Assert.assertTrue(orderDocumentsText.contains("Sales Contract"), "Sales Contract is not showing in the Order Documents");
		Assert.assertTrue(orderDocumentsText.contains("Report PDF"), "Report PDF is not showing in the Order Documents");
		Assert.assertTrue(orderDocumentsText.contains("Completed Report (Current)"), "Completed Report (Current) is not showing in the Order Documents");
		Assert.assertTrue(orderDocumentsText.contains("Previously Completed Reports"), "Previously Completed Reports is not showing in the Order Documents");
		Assert.assertTrue(orderDocumentsText.contains("Completed Report"), "Completed Report is not showing in the Order Documents");
		Assert.assertTrue(orderDocumentsText.contains(StoredVariables.gettodaysDateLong().get()), "The Date Uploaded is not showing in the Order Documents");

		// Get order information text
		orderInformation = VOrderDetails.orderInformation_txt(driver).getText();
		
		// Verify audit trail
		Assert.assertTrue(orderInformation.contains("History (Revised Report)"), "History (Revised Report) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Message from Appraiser (Automation Appraiser1)"), "Message from Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are additional Message notes from Appraiser1"), "These are additional Message notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Revised Report delivered by Appraiser (Automation Appraiser1)"), "Revised Report delivered by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Revision Needed by Client (Automation VMP1)"), "Revision Needed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Requesting a revision from Automation VMP1"), "Requesting a revision from Automation VMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Inspection Complete by Appraiser (Automation Appraiser1)"), "Inspection Complete by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Inspection Complete by Appraiser (Automation Appraiser1)"), "Inspection Complete by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Inspected on " + StoredVariables.getcalendarDateLong().get()), "Inspected on " + StoredVariables.getcalendarDateLong().get() + " is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Inspection Complete notes from Appraiser1"), "These are Inspection Complete notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Inspection Scheduled by Appraiser (Automation Appraiser1)"), "Inspection Scheduled by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Inspection date is " + StoredVariables.getcalendarDateShort().get()), "Inspection date is " + StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Inspection Scheduled notes from Appraiser1"), "These are Inspection Scheduled notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Document Uploaded from Appraiser (Automation Appraiser1) (Test PDF_1.pdf)"), "Document Uploaded from Appraiser (Automation Appraiser1) (Test PDF_1.pdf) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Message from Appraiser (Automation Appraiser1)"), "Message from Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Message notes from Appraiser1"), "These are Message notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Resumed by Appraiser (Automation Appraiser1)"), "Resumed by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Resume notes from Appraiser1"), "These are Resume notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Delayed by Appraiser (Automation Appraiser1)"), "Delayed by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Delayed notes from Appraiser1"), "These are Delayed notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Order accepted by Appraiser (Automation Appraiser1) and In Progress"), "Order accepted by Appraiser (Automation Appraiser1) and In Progress is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Appraiser1 accepting order notes"), "These are Appraiser1 accepting order notes is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Resumed by Client (Automation VMP1)"), "Resumed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Resume2 test notes from OriginatorVMP1"), "These are Resume2 test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Comment - Action Required by Client (Automation VMP1)"), "Comment - Action Required by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Action Required test notes from OriginatorVMP1"), "These are Action Required test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Message from Client (Automation VMP1)"), "Message from Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are test Send Message notes from OriginatorVMP1"), "These are test Send Message notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Document Uploaded from Client (Automation VMP1) (Test PDF.pdf)"), "Document Uploaded from Client (Automation VMP1) (Test PDF.pdf) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("On Hold by Client (Automation VMP1)"), "On Hold by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Place On Hold test notes from OriginatorVMP1"), "These are Place On Hold test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Resumed by Client (Automation VMP1)"), "Resumed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Resume test notes from OriginatorVMP1"), "These are Resume test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Delayed by Client (Automation VMP1)"), "Delayed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Delayed test notes from OriginatorVMP1"), "These are Delayed test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Awaiting acceptance by Automation Appraiser1"), "Awaiting acceptance by Automation Appraiser1 is missing from the order information");
		
		// Log in to Secure
		secure.login(driver, "VMP1", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, StoredVariables.getloanID().get(), "Tracking number");
		
		// Verify order status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("Revised Report"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getAWSAccountsID().get() + "-" + StoredVariables.getloanID().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify delayed is in the history
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser1)"), "Message from Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser1"), "These are additional Message notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(history.contains("Revised Report delivered by Appraiser (Automation Appraiser1)"), "Revised Report delivered by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(history.contains("Revision Needed by Client (Automation VMP1)"), "Revision Needed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(history.contains("Requesting a revision from Automation VMP1"), "Requesting a revision from Automation VMP1 is missing from the order information");
		Assert.assertTrue(history.contains("Order delivered by Appraiser (Automation Appraiser1) and is now In QC - Level One"), "Order delivered by Appraiser (Automation Appraiser1) and is now In QC - Level One status did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Inspection Complete by Appraiser (Automation Appraiser1)"), "Inspection Complete by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(history.contains("Inspected on " + StoredVariables.getcalendarDateLong().get()), "Inspected on " + StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser1"), "These are Inspection Complete notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(history.contains("Inspection Scheduled by Appraiser (Automation Appraiser1)"), "Inspection Scheduled by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(history.contains("Inspection date is " + StoredVariables.getcalendarDateShort().get()), "Inspection date is " + StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser1"), "These are Inspection Scheduled notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser1) (Test PDF_1.pdf)"), "Document Uploaded from Appraiser (Automation Appraiser1) (Test PDF_1.pdf) is missing from the order information");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser1)"), "Message from Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser1"), "These are Message notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(history.contains("Resumed by Appraiser (Automation Appraiser1)"), "Resumed by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser1"), "These are Resume notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(history.contains("Delayed by Appraiser (Automation Appraiser1)"), "Delayed by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser1"), "These are Delayed notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation VMP1)"), "Comment - Action Required by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorVMP1"), "These are Action Required test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(history.contains("Message from Client (Automation VMP1)"), "Message from Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorVMP1"), "These are test Send Message notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation VMP1) (Test PDF.pdf)"), "Document Uploaded from Client (Automation VMP1) (Test PDF.pdf) is missing from the order information");
		Assert.assertTrue(history.contains("On Hold by Client (Automation VMP1)"), "On Hold by Client (Automation VMP1) did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorVMP1"), "These are Place On Hold test notes from OriginatorVMP1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Resumed by Client (Automation VMP1)"), "Resumed by Client (Automation VMP1) did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorVMP1"), "These are Resume test notes from OriginatorVMP1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Delayed by Client (Automation VMP1)"), "Delayed by Client (Automation VMP1) status did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorVMP1"), "These are Delayed test notes from OriginatorVMP1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser1"), "Awaiting acceptance by Automation Appraiser1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Reassigned by Client (Automation VMP1) to Automation Appraiser1"), "Reassigned by Client (Automation VMP1) to Automation Appraiser1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Requires assignment"), "Requires assignment did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Awaiting acceptance"), "Awaiting acceptance did not sync from VMP to Secure");
		
		// Verify Document is in Documents
		documentText = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Completed Report (Current)"), "Completed Report (Current) document is not on VMP XSite");
		Assert.assertTrue(documentText.contains("Order Documents"), "Order Documents document is not on VMP XSite");
		Assert.assertTrue(documentText.contains("Report PDF"), "Report PDF document is not on VMP XSite");
		Assert.assertTrue(documentText.contains("Other"), "Other document is not on VMP XSite");
		Assert.assertTrue(documentText.contains("Sales Contract"), "Sales Contract did not sync to VMP XSite");
		Assert.assertTrue(documentText.contains("Previously Completed Reports"), "Previously Completed Reports document is not on VMP XSite");
		Assert.assertTrue(documentText.contains("Completed Report"), "Completed Report document is not on VMP XSite");

		// Log in to VMP
		vmp.login(driver, "VMP1", "OriginatorVMP1", StoredVariables.getpassword().get());
		
		// Search for order
		vmp.findOrder(driver, StoredVariables.getloanIDVMP().get(), "Tracking #");
		
		// Verify order status
		Assert.assertTrue(VMPOrders.orderStatus_txt(driver).getText().equals("Revision Needed"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getAWSAccountsID().get() + "-" + StoredVariables.getloanIDVMP().get());
		
		// Wait for Other Actions button
		perform.waitForElementToBeVisible(driver, VMPAppraisalOrderDetails.otherActions_btn(), "cssSelector");
		
		// Verify history
		history = VMPAppraisalOrderDetails.history_txt(driver).getText();
		Assert.assertTrue(!history.contains("These are additional Message notes from Appraiser1"), "These are additional Message notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(history.contains("Revision Needed by Automation VMP1"), "Revision Needed by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Requesting a revision from Automation VMP1"), "Requesting a revision from Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Pending Quality Review by Automation VMP1"), "Pending Quality Review by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Complete by Automation VMP1"), "Inspection Complete by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspected on " + StoredVariables.getcalendarDateLong().get()), "Inspected on " + StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser1"), "These are Inspection Complete notes from Appraiser1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Scheduled by Automation VMP1"), "Inspection Scheduled by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection date is " + StoredVariables.getcalendarDateShort().get()), "Inspection date is " + StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser1"), "These are Inspection Scheduled notes from Appraiser1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation VMP1"), "Document Uploaded by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Sales Contract"), "Sales Contract is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF_1.pdf"), "Test PDF_1.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation VMP1"), "Message by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser1"), "These are Message notes from Appraiser1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation VMP1"), "Resumed by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser1"), "These are Resume notes from Appraiser1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation VMP1"), "Delayed by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser1"), "These are Delayed notes from Appraiser1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraiser Accepted Assignment by Automation VMP1"), "Appraiser Accepted Assignment by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser1 accepting order notes"), "These are Appraiser1 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorVMP1"), "Resumed by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorVMP1"), "These are Resume2 test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Automation OriginatorVMP1"), "Comment - Action Required by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorVMP1"), "These are Action Required test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation OriginatorVMP1"), "Message by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorVMP1"), "These are test Send Message notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorVMP1"), "Document Uploaded by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Other"), "Other is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF.pdf"), "Test PDF.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Automation OriginatorVMP1"), "On Hold by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorVMP1"), "These are Place On Hold test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorVMP1"), "Resumed by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorVMP1"), "These are Resume test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation OriginatorVMP1"), "Delayed by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorVMP1"), "These are Delayed test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("In Progress by Automation OriginatorVMP1"), "In Progress by Automation OriginatorVMP1 is missing from the audit trail");
		
		// Verify Document is in Documents
		documentText = VMPAppraisalOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Other"), "Other document is not displayed in VMP XSite");
		Assert.assertTrue(documentText.contains("Sales Contract"), "Sales Contract did not sync to VMP XSite");

		// Verify the order details
		vmp.verifyAppraisalOrderDetails(driver);

		// Click Send Message
		perform.click(driver,VMPAppraisalOrderDetails.sendMessage_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for Send button
		perform.waitForElementToBeClickable(driver, VMPAppraisalOrderDetails.send_btn(), "cssSelector");
		
		// Add notes
		perform.type(driver,VMPAppraisalOrderDetails.sendMessage_txtbx(driver), "These are additional test Send Message notes from OriginatorVMP1");
		
		// Uncheck Action Required
		if (VMPAppraisalOrderDetails.actionRequired_chkbx(driver).isSelected())
		{
			perform.click(driver,VMPAppraisalOrderDetails.actionRequired_chkbx(driver));
		}
		
		// Click Send
		perform.click(driver,VMPAppraisalOrderDetails.send_btn(driver));
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, VMPAppraisalOrderDetails.alertDialogOk_btn(), "cssSelector");
		
		// Verify Update Complete text
		Assert.assertTrue(VMPAppraisalOrderDetails.alertDialog_txt(driver).getText().equals("The message has been sent."), "The Update Complete dialog box text is incorrect");
		
		// Click OK for Send Complete
		perform.click(driver,VMPAppraisalOrderDetails.alertDialogOk_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Verify history
		history = VMPAppraisalOrderDetails.history_txt(driver).getText();
		Assert.assertTrue(history.contains("Message by Automation OriginatorVMP1"), "Message by Automation OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(history.contains("These are additional test Send Message notes from OriginatorVMP1"), "These are additional test Send Message notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(!history.contains("These are additional Message notes from Appraiser1"), "These are additional Message notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(history.contains("Revision Needed by Automation VMP1"), "Revision Needed by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Requesting a revision from Automation VMP1"), "Requesting a revision from Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Pending Quality Review by Automation VMP1"), "Pending Quality Review by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Complete by Automation VMP1"), "Inspection Complete by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspected on " + StoredVariables.getcalendarDateLong().get()), "Inspected on " + StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser1"), "These are Inspection Complete notes from Appraiser1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Scheduled by Automation VMP1"), "Inspection Scheduled by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection date is " + StoredVariables.getcalendarDateShort().get()), "Inspection date is " + StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser1"), "These are Inspection Scheduled notes from Appraiser1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation VMP1"), "Document Uploaded by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Sales Contract"), "Sales Contract is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF_1.pdf"), "Test PDF_1.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation VMP1"), "Message by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser1"), "These are Message notes from Appraiser1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation VMP1"), "Resumed by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser1"), "These are Resume notes from Appraiser1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation VMP1"), "Delayed by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser1"), "These are Delayed notes from Appraiser1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraiser Accepted Assignment by Automation VMP1"), "Appraiser Accepted Assignment by Automation VMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser1 accepting order notes"), "These are Appraiser1 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorVMP1"), "Resumed by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorVMP1"), "These are Resume2 test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Automation OriginatorVMP1"), "Comment - Action Required by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorVMP1"), "These are Action Required test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation OriginatorVMP1"), "Message by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorVMP1"), "These are test Send Message notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorVMP1"), "Document Uploaded by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Other"), "Other is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF.pdf"), "Test PDF.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Automation OriginatorVMP1"), "On Hold by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorVMP1"), "These are Place On Hold test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorVMP1"), "Resumed by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorVMP1"), "These are Resume test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation OriginatorVMP1"), "Delayed by Automation OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorVMP1"), "These are Delayed test notes from OriginatorVMP1 is missing from the audit trail");
		Assert.assertTrue(history.contains("In Progress by Automation OriginatorVMP1"), "In Progress by Automation OriginatorVMP1 is missing from the audit trail");
		
		// Verify Document is in Documents
		documentText = VMPAppraisalOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Other"), "Other document is not displayed in VMP XSite");
		Assert.assertTrue(documentText.contains("Sales Contract"), "Sales Contract did not sync to VMP XSite");

		// Log in to Vendors
		vendors.login(driver, "Appraiser1", StoredVariables.getpassword().get());
		
		// Search for order
		vendors.findOrder(driver, StoredVariables.getloanID().get(), "Tracking Number");
		
		// Verify order status
		Assert.assertTrue(VOrders.ordersGrid_txt(driver).getText().contains("Revised Report"), "The order is not in the correct status");
		
		// Click on the order from the orders grid
		perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, VOrderDetails.sendMessage_btn(), "cssSelector");
		
		// Verify Report is in the Order Documents pane
		orderDocumentsText = VOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(orderDocumentsText.contains("Order Documents"), "Order Documents is not showing in the Order Documents");
		Assert.assertTrue(orderDocumentsText.contains("Other"), "Other is not showing in the Order Documents");
		Assert.assertTrue(orderDocumentsText.contains("Sales Contract"), "Sales Contract is not showing in the Order Documents");
		Assert.assertTrue(orderDocumentsText.contains("Report PDF"), "Report PDF is not showing in the Order Documents");
		Assert.assertTrue(orderDocumentsText.contains("Completed Report (Current)"), "Completed Report (Current) is not showing in the Order Documents");
		Assert.assertTrue(orderDocumentsText.contains(StoredVariables.gettodaysDateLong().get()), "The Date Uploaded is not showing in the Order Documents");

		// Get order information text
		orderInformation = VOrderDetails.orderInformation_txt(driver).getText();
		
		// Verify audit trail
		Assert.assertTrue(orderInformation.contains("History (Revised Report)"), "History (Revised Report) is missing from the order information");
		Assert.assertTrue(!orderInformation.contains("These are additional test Send Message notes from OriginatorVMP1"), "These are additional test Send Message notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Message from Appraiser (Automation Appraiser1)"), "Message from Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are additional Message notes from Appraiser1"), "These are additional Message notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Revised Report delivered by Appraiser (Automation Appraiser1)"), "Revised Report delivered by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Revision Needed by Client (Automation VMP1)"), "Revision Needed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Requesting a revision from Automation VMP1"), "Requesting a revision from Automation VMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Inspection Complete by Appraiser (Automation Appraiser1)"), "Inspection Complete by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Inspection Complete by Appraiser (Automation Appraiser1)"), "Inspection Complete by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Inspected on " + StoredVariables.getcalendarDateLong().get()), "Inspected on " + StoredVariables.getcalendarDateLong().get() + " is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Inspection Complete notes from Appraiser1"), "These are Inspection Complete notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Inspection Scheduled by Appraiser (Automation Appraiser1)"), "Inspection Scheduled by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Inspection date is " + StoredVariables.getcalendarDateShort().get()), "Inspection date is " + StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Inspection Scheduled notes from Appraiser1"), "These are Inspection Scheduled notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Document Uploaded from Appraiser (Automation Appraiser1) (Test PDF_1.pdf)"), "Document Uploaded from Appraiser (Automation Appraiser1) (Test PDF_1.pdf) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Message from Appraiser (Automation Appraiser1)"), "Message from Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Message notes from Appraiser1"), "These are Message notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Resumed by Appraiser (Automation Appraiser1)"), "Resumed by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Resume notes from Appraiser1"), "These are Resume notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Delayed by Appraiser (Automation Appraiser1)"), "Delayed by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Delayed notes from Appraiser1"), "These are Delayed notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Order accepted by Appraiser (Automation Appraiser1) and In Progress"), "Order accepted by Appraiser (Automation Appraiser1) and In Progress is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Appraiser1 accepting order notes"), "These are Appraiser1 accepting order notes is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Resumed by Client (Automation VMP1)"), "Resumed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Resume2 test notes from OriginatorVMP1"), "These are Resume2 test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Comment - Action Required by Client (Automation VMP1)"), "Comment - Action Required by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Action Required test notes from OriginatorVMP1"), "These are Action Required test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Message from Client (Automation VMP1)"), "Message from Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are test Send Message notes from OriginatorVMP1"), "These are test Send Message notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Document Uploaded from Client (Automation VMP1) (Test PDF.pdf)"), "Document Uploaded from Client (Automation VMP1) (Test PDF.pdf) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("On Hold by Client (Automation VMP1)"), "On Hold by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Place On Hold test notes from OriginatorVMP1"), "These are Place On Hold test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Resumed by Client (Automation VMP1)"), "Resumed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Resume test notes from OriginatorVMP1"), "These are Resume test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Delayed by Client (Automation VMP1)"), "Delayed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Delayed test notes from OriginatorVMP1"), "These are Delayed test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Awaiting acceptance by Automation Appraiser1"), "Awaiting acceptance by Automation Appraiser1 is missing from the order information");

		// Log in to Secure
		secure.login(driver, "VMP1", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, StoredVariables.getloanID().get(), "Tracking number");
		
		// Verify order status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("Revised Report"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getAWSAccountsID().get() + "-" + StoredVariables.getloanID().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify delayed is in the history
		Assert.assertTrue(!history.contains("These are additional test Send Message notes from OriginatorVMP1"), "These are additional test Send Message notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser1)"), "Message from Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser1"), "These are additional Message notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(history.contains("Revised Report delivered by Appraiser (Automation Appraiser1)"), "Revised Report delivered by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(history.contains("Revision Needed by Client (Automation VMP1)"), "Revision Needed by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(history.contains("Requesting a revision from Automation VMP1"), "Requesting a revision from Automation VMP1 is missing from the order information");
		Assert.assertTrue(history.contains("Order delivered by Appraiser (Automation Appraiser1) and is now In QC - Level One"), "Order delivered by Appraiser (Automation Appraiser1) and is now In QC - Level One status did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Inspection Complete by Appraiser (Automation Appraiser1)"), "Inspection Complete by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(history.contains("Inspected on " + StoredVariables.getcalendarDateLong().get()), "Inspected on " + StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser1"), "These are Inspection Complete notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(history.contains("Inspection Scheduled by Appraiser (Automation Appraiser1)"), "Inspection Scheduled by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(history.contains("Inspection date is " + StoredVariables.getcalendarDateShort().get()), "Inspection date is " + StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser1"), "These are Inspection Scheduled notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser1) (Test PDF_1.pdf)"), "Document Uploaded from Appraiser (Automation Appraiser1) (Test PDF_1.pdf) is missing from the order information");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser1)"), "Message from Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser1"), "These are Message notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(history.contains("Resumed by Appraiser (Automation Appraiser1)"), "Resumed by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser1"), "These are Resume notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(history.contains("Delayed by Appraiser (Automation Appraiser1)"), "Delayed by Appraiser (Automation Appraiser1) is missing from the order information");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser1"), "These are Delayed notes from Appraiser1 is missing from the order information");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation VMP1)"), "Comment - Action Required by Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorVMP1"), "These are Action Required test notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(history.contains("Message from Client (Automation VMP1)"), "Message from Client (Automation VMP1) is missing from the order information");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorVMP1"), "These are test Send Message notes from OriginatorVMP1 is missing from the order information");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation VMP1) (Test PDF.pdf)"), "Document Uploaded from Client (Automation VMP1) (Test PDF.pdf) is missing from the order information");
		Assert.assertTrue(history.contains("On Hold by Client (Automation VMP1)"), "On Hold by Client (Automation VMP1) did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorVMP1"), "These are Place On Hold test notes from OriginatorVMP1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Resumed by Client (Automation VMP1)"), "Resumed by Client (Automation VMP1) did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorVMP1"), "These are Resume test notes from OriginatorVMP1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Delayed by Client (Automation VMP1)"), "Delayed by Client (Automation VMP1) status did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorVMP1"), "These are Delayed test notes from OriginatorVMP1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser1"), "Awaiting acceptance by Automation Appraiser1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Reassigned by Client (Automation VMP1) to Automation Appraiser1"), "Reassigned by Client (Automation VMP1) to Automation Appraiser1 did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Requires assignment"), "Requires assignment did not sync from VMP to Secure");
		Assert.assertTrue(history.contains("Awaiting acceptance"), "Awaiting acceptance did not sync from VMP to Secure");
		
		// Verify Document is in Documents
		documentText = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Completed Report (Current)"), "Completed Report (Current) document is not on VMP XSite");
		Assert.assertTrue(documentText.contains("Order Documents"), "Order Documents document is not on VMP XSite");
		Assert.assertTrue(documentText.contains("Report PDF"), "Report PDF document is not on VMP XSite");
		Assert.assertTrue(documentText.contains("Other"), "Other document is not on VMP XSite");
		Assert.assertTrue(documentText.contains("Sales Contract"), "Sales Contract did not sync to VMP XSite");
		Assert.assertTrue(documentText.contains("Previously Completed Reports"), "Previously Completed Reports document is not on VMP XSite");
		Assert.assertTrue(documentText.contains("Completed Report"), "Completed Report document is not on VMP XSite");

		// Log test
		test.log(LogStatus.INFO, "ULS Orders", "Ran through the ULS Orders martix");
		
	} // end verifyMessageNotOnSecure	
	
} // end the ULSOrders_Order1 class
