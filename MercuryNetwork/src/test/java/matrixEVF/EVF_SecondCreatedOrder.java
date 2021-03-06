package matrixEVF;

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
import pageObjects.Secure.SNewOrder;
import pageObjects.Secure.SOrderDetails;
import pageObjects.Secure.SOrders;
import pageObjects.Secure.SPreferences;
import pageObjects.Secure.SSyncToVMP;
import pageObjects.Secure.SVMPXSites;
import pageObjects.Secure.SVendorSelection;
import pageObjects.Secure.SVendorSelectionSettings;
import pageObjects.Secure.SVerifyCertificateInformation;
import pageObjects.VMP.VMPAppraisalOrderDetails;
import pageObjects.VMP.VMPConfirmOrder;
import pageObjects.VMP.VMPNewOrder;
import pageObjects.VMP.VMPOrders;
import pageObjects.Vendors.VOrderAcknowledgement;
import pageObjects.Vendors.VOrderDetails;
import pageObjects.Vendors.VOrders;
import pageObjects.XSite.XOrders;
import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>EVF - Second Created Order</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class EVF_SecondCreatedOrder extends TestSetup {
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Go to VMPXSites</li>
	 * 	<li>Verify the dropdown is the correct VMP site</li>
	 * 	<li>Click Configure Automatic Settings</li>
	 * 	<li>Check Create invoice when order is placed</li>
	 * 	<li>Check Attach invoice when credit card is charged</li>
	 * 	<li>Attach invoice when order is marked complete</li>
	 * 	<li>Check Include the vendor's fee on the invoice</li>
	 * 	<li>Enter 7 for Set the invoice due date</li>
	 * 	<li>Auto numbers prefix</li>
	 * 	<li>Auto number start number</li>
	 * 	<li>Save Preferences</li>
	 * 	<li>Click OK button</li>
	 * 	<li>Click on Configure Status Mapping</li>
	 * 	<li>Disable all sync status options</li>
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
	 * 	<li>Click on Compliance Certificate</li>
	 * 	<li>Click Options button</li>
	 * 	<li>Check Always attach a copy of the Compliance Certificate checkbox</li>
	 * 	<li>Click OK</li>
	 * 	<li>Save Preferences</li>
	 * 	<li>Click OK in saved dialog box</li>
	 * 	<li>Click to Preferences</li>
	 * 	<li>Select Vendor Selection Settings</li>
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
	 * 	<li>Verify the dropdown is the correct VMP site</li>
	 * 	<li>Click Configure Automatic Settings</li>
	 * 	<li>Check Create invoice when order is placed</li>
	 * 	<li>Check Attach invoice when credit card is charged</li>
	 * 	<li>Attach invoice when order is marked complete</li>
	 * 	<li>Check Include the vendor's fee on the invoice</li>
	 * 	<li>Enter 7 for Set the invoice due date</li>
	 * 	<li>Auto numbers prefix</li>
	 * 	<li>Auto number start number</li>
	 * 	<li>Save Preferences</li>
	 * 	<li>Click OK button</li>
	 * 	<li>Click on Configure Status Mapping</li>
	 * 	<li>Enable all sync status options</li>
	 * 	<li>Click the Client Document Upload gear icon</li>
	 * 	<li>Check every option for syncing</li>
	 * 	<li>Click OK</li>
	 * 	<li>Click the Vendor Document Upload gear icon</li>
	 * 	<li>Check every option for syncing</li>
	 * 	<li>Click OK</li>
	 * 	<li>Click Save</li>
	 * 	<li>Click on AMC/Firm</li>
	 * 	<li>Enable all sync status options for Appraiser/Agent</li>
	 * 	<li>Click the AMC Client Document Upload gear icon</li>
	 * 	<li>Check every option for syncing</li>
	 * 	<li>Click OK</li>
	 * 	<li>Click the AMC Vendor Document Upload gear icon</li>
	 * 	<li>Check every option for syncing</li>
	 * 	<li>Click OK</li>
	 * 	<li>Click Save</li>
	 * 	<li>Get the AWSAccountsID</li>
	 * 	<li>Build database url</li>
	 * 	<li>dbUrl = "jdbc:sqlserver:" + StoredVariables.getdbName().get() + ":" + StoredVariables.getdbPort().get() + ";"+</li>
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
	 * 	<li>Click on Compliance Certificate</li>
	 * 	<li>Click Options button</li>
	 * 	<li>Check Always attach a copy of the Compliance Certificate checkbox</li>
	 * 	<li>Click OK</li>
	 * 	<li>Save Preferences</li>
	 * 	<li>Click OK in saved dialog box</li>
	 * 	<li>Click to Preferences</li>
	 * 	<li>Select Vendor Selection Settings</li>
	 * 	<li>Turn off Double-blind Communication switch</li>
	 * 	<li>Disable Automatic Vendor Selection</li>
	 * 	<li>Enable Unattended Order Assignment Selection</li>
	 * 	<li>Click switch On</li>
	 * 	<li>Disable Unattended Order Reassignment</li>
	 * 	<li>Select Custom Fee Panel</li>
	 * 	<li>Uncheck Use Mercury Network Directory as backup checkbox</li>
	 * 	<li>Verify Mercury Network Directory as backup is unchecked</li>
	 * 	<li>Save Preferences</li>
	 * 	<li>Click OK in saved dialog box</li>
	 * 	<li>Clear order information variables before placing a new order</li>
	 * 	<li>Login to VMP Client Portal</li>
	 * 	<li>Click New Order</li>
	 * 	<li>Set Property Information data</li>
	 * 	<li>StoredVariables.getpropertyInformationStateAbbr().set("OK");  Must set for a field check later on</li>
	 * 	<li>Set Assignment Information data</li>
	 * 	<li>Set Lender Information data</li>
	 * 	<li>Set Contact And Access Information data</li>
	 * 	<li>Set Additional Notification Recipients data</li>
	 * 	<li>Enter New Order data</li>
	 * 	<li>Click Next</li>
	 * 	<li>Confirm order screen loads</li>
	 * 	<li>Verify VMP Order Details</li>
	 * 	<li>Verify the order fee is not 0</li>
	 * 	<li>Click Next</li>
	 * 	<li>Get inside the attach document frame</li>
	 * 	<li>Select document type</li>
	 * 	<li>Click Finished Button</li>
	 * 	<li>Switch back to the attach documents frame</li>
	 * 	<li>Click the OK button in the Order Placed dialog</li>
	 * 	<li>Verify you land on the orders grid</li>
	 * 	<li>Query the db to get the order number that was just created</li>
	 * 	<li>Verify Due date is ordered properly to display the most recent order first</li>
	 * 	<li>Verify the order just created is in the orders grid</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify the order details</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Click Edit</li>
	 * 	<li>Get the text from VMP Comments</li>
	 * 	<li>Enter new comments</li>
	 * 	<li>Click Save</li>
	 * 	<li>Check VMP Comments</li>
	 * 	<li>Click OK</li>
	 * 	<li>If browser is IE, set nativeEvents capability to false</li>
	 * 	<li>if (StoredVariables.getbrowser().get().equals("IE"))</li>
	 * 	<li>{</li>
	 * 	<li>perform.IE_setNativeEventsToFalse();</li>
	 * 	<li></li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>secure.login(driver, "EVFAMC2", StoredVariables.getpassword().get());</li>
	 * 	<li></li>
	 * 	<li>Search for order</li>
	 * 	<li>secure.findOrder(driver, StoredVariables.getorderNumberAMC().get(), "Tracking number");</li>
	 * 	<li></li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("Requires assignment"), "The order is not in the correct status");</li>
	 * 	<li></li>
	 * 	<li>Open order</li>
	 * 	<li>perform.doubleClickInTable(driver, StoredVariables.getAWSAccountsID().get() + "-" + StoredVariables.getorderNumberAMC().get());</li>
	 * 	<li></li>
	 * 	<li>perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");</li>
	 * 	<li></li>
	 * 	<li>}</li>
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
	 * 	<li>Agree to pay the transaction fee</li>
	 * 	<li>Click Finish</li>
	 * 	<li>Verify the order is in the Awaiting acceptance status</li>
	 * 	<li>Verify audit trail</li>
	 * 	<li>If browser is IE, set nativeEvents capability to false</li>
	 * 	<li>if (StoredVariables.getbrowser().get().equals("IE"))</li>
	 * 	<li>{</li>
	 * 	<li>perform.IE_reEstablishCapabilities();</li>
	 * 	<li>}</li>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify order status</li>
	 * 	<li>Click on the order from the orders grid</li>
	 * 	<li>Get order information text</li>
	 * 	<li>Verify audit trail</li>
	 * 	<li>Get comments</li>
	 * 	<li>Verify both VMP and MN comments are displayed</li>
	 * 	<li>View Order Details</li>
	 * 	<li>Log in to VMP</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify the audit trail</li>
	 * 	<li>Verify the order details</li>
	 * 	<li>Click Other Actions</li>
	 * 	<li>Click Place On Hold</li>
	 * 	<li>Add notes</li>
	 * 	<li>Click OK</li>
	 * 	<li>Verify Update Complete text</li>
	 * 	<li>Click OK for Update Complete</li>
	 * 	<li>Verify history</li>
	 * 	<li>Click Other Actions</li>
	 * 	<li>Click Resume</li>
	 * 	<li>Add notes</li>
	 * 	<li>Click OK</li>
	 * 	<li>Verify Update Complete text</li>
	 * 	<li>Click OK for Update Complete</li>
	 * 	<li>Verify history</li>
	 * 	<li>Click Other Actions</li>
	 * 	<li>Click Delayed</li>
	 * 	<li>Add notes</li>
	 * 	<li>Click OK</li>
	 * 	<li>Verify Update Complete text</li>
	 * 	<li>Click OK for Update Complete</li>
	 * 	<li>Verify history</li>
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
	 * 	<li>Click Send Message</li>
	 * 	<li>Add notes</li>
	 * 	<li>Uncheck Action Required</li>
	 * 	<li>Click Send</li>
	 * 	<li>Verify Update Complete text</li>
	 * 	<li>Click OK for Send Complete</li>
	 * 	<li>Verify history</li>
	 * 	<li>Click Send Message</li>
	 * 	<li>Add notes</li>
	 * 	<li>Click Action Required checkbox</li>
	 * 	<li>Click Send</li>
	 * 	<li>Verify Update Complete text</li>
	 * 	<li>Click OK for Send Complete</li>
	 * 	<li>Verify history</li>
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
	 * 	<li>Verify order details</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify Other Document is in Documents</li>
	 * 	<li>Click on Other</li>
	 * 	<li>Verify file name and uploaded by</li>
	 * 	<li>Verify Sales ContractDocument is in Documents</li>
	 * 	<li>Click on Sales Contract</li>
	 * 	<li>Verify file name and uploaded by</li>
	 * 	<li>If browser is Firefox, skip this method</li>
	 * 	<li>Log a skip in the extent report</li>
	 * 	<li>View XSite order</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Verify documents</li>
	 * 	<li>Verify comments</li>
	 * 	<li>Close XSite order</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify Documents aren't in Documents</li>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify order status</li>
	 * 	<li>Click on the order from the orders grid</li>
	 * 	<li>Get order information text</li>
	 * 	<li>Verify audit trail</li>
	 * 	<li>Get comments</li>
	 * 	<li>Verify both VMP and MN comments are displayed</li>
	 * 	<li>View Order Details</li>
	 * 	<li>Verify Document is in Documents</li>
	 * 	<li>Click Accept/Decline button</li>
	 * 	<li>Enter notes</li>
	 * 	<li>Click OK</li>
	 * 	<li>Close Order Acknowledgement dialog</li>
	 * 	<li>Get order information text</li>
	 * 	<li>Verify audit trail</li>
	 * 	<li>Click Set Order Status</li>
	 * 	<li>Click Inspection Scheduled</li>
	 * 	<li>Click the calendar button</li>
	 * 	<li>Select date</li>
	 * 	<li>Verify the correct order due date is correct</li>
	 * 	<li>Add notes</li>
	 * 	<li>Click OK</li>
	 * 	<li>Click Set Order Status</li>
	 * 	<li>Click Inspection Complete</li>
	 * 	<li>Click the calendar button</li>
	 * 	<li>Select date</li>
	 * 	<li>Verify the correct order due date is correct</li>
	 * 	<li>Add notes</li>
	 * 	<li>Click OK</li>
	 * 	<li>If browser is IE, set require window focus capability to false</li>
	 * 	<li>if (StoredVariables.getbrowser().get().equals("IE"))</li>
	 * 	<li>{</li>
	 * 	<li></li>
	 * 	<li>perform.IE_setRequireWindowFocusToFalse();</li>
	 * 	<li></li>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>vendors.login(driver, "Appraiser3", StoredVariables.getpassword().get());</li>
	 * 	<li></li>
	 * 	<li>Search for order</li>
	 * 	<li>vendors.findOrder(driver, StoredVariables.getorderNumberAMC().get(), "Tracking Number");</li>
	 * 	<li></li>
	 * 	<li>Verify order status</li>
	 * 	<li>Assert.assertTrue(VOrders.ordersGrid_txt(driver).getText().contains("Inspection Complete"), "The order is not in the correct status");</li>
	 * 	<li></li>
	 * 	<li>Click on the order from the orders grid</li>
	 * 	<li>perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());</li>
	 * 	<li></li>
	 * 	<li>}</li>
	 * 	<li>Upload Other document</li>
	 * 	<li>Click Attach Documents button</li>
	 * 	<li>Select document type</li>
	 * 	<li>Upload test pdf file</li>
	 * 	<li>Click Close Button</li>
	 * 	<li>Verify Other is in the Order Documents pane twice</li>
	 * 	<li>Click Other document</li>
	 * 	<li>Verify Uploaded By and Document Name</li>
	 * 	<li>Get order information text</li>
	 * 	<li>Verify audit trail</li>
	 * 	<li>If browser is IE, re-establish capabilities</li>
	 * 	<li>if (StoredVariables.getbrowser().get().equals("IE"))</li>
	 * 	<li>{</li>
	 * 	<li>perform.IE_reEstablishCapabilities();</li>
	 * 	<li>}</li>
	 * 	<li>perform.IE_setRequireWindowFocusToFalse();</li>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify order status</li>
	 * 	<li>Click on the order from the orders grid</li>
	 * 	<li>Complete the order using the HTTP Post</li>
	 * 	<li>Get order information text</li>
	 * 	<li>Verify audit trail</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Get comments</li>
	 * 	<li>Verify both VMP and MN comments are displayed</li>
	 * 	<li>View Order Details</li>
	 * 	<li>Verify Document is in Documents</li>
	 * 	<li>Click Sales Contract</li>
	 * 	<li>Verify Uploaded By and Document Name</li>
	 * 	<li>If browser is IE, re-establish capabilites</li>
	 * 	<li>if (StoredVariables.getbrowser().get().equals("IE"))</li>
	 * 	<li>{</li>
	 * 	<li>perform.IE_reEstablishCapabilities();</li>
	 * 	<li>}</li>
	 * 	<li>If browser is Firefox, skip this method</li>
	 * 	<li>Log a skip in the extent report</li>
	 * 	<li>View XSite order</li>
	 * 	<li>Get history text</li>
	 * 	<li>Recapture the text from the history</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Verify documents</li>
	 * 	<li>Verify comments</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Close XSite order</li>
	 * 	<li>Log in to VMP</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify the audit trail</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Verify the order details</li>
	 * 	<li>Verify Document is in Documents</li>
	 * 	<li>Click on Sales Contract</li>
	 * 	<li>Verify file name and uploaded by</li>
	 * 	<li>Click on Other</li>
	 * 	<li>Verify file name and uploaded by</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify Other Document is in Documents</li>
	 * 	<li>Verify Sales ContractDocument is in Documents</li>
	 * 	<li>Click on Sales Contract</li>
	 * 	<li>Verify file name and uploaded by</li>
	 * 	<li>Click on Other</li>
	 * 	<li>Verify file name and uploaded by</li>
	 * 	<li>If browser is Firefox, skip this method</li>
	 * 	<li>Log a skip in the extent report</li>
	 * 	<li>View XSite order</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Verify documents</li>
	 * 	<li>Verify comments</li>
	 * 	<li>Close XSite order</li>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify order status</li>
	 * 	<li>Click on the order from the orders grid</li>
	 * 	<li>Get order information text</li>
	 * 	<li>Verify audit trail</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Get comments</li>
	 * 	<li>Verify both VMP and MN comments are displayed</li>
	 * 	<li>View Order Details</li>
	 * 	<li>Verify Document is in Documents</li>
	 * 	<li>Click Sales Contract</li>
	 * 	<li>Verify Uploaded By and Document Name</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify Documents aren't in Documents</li>
	 * 	<li>Submit to UCDP</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Verify Other Document is in Documents</li>
	 * 	<li>Get the new history text</li>
	 * 	<li>Verify SSR is in the history</li>
	 * 	<li>Verify FNM SSR is in the Documents</li>
	 * 	<li>If browser is Firefox, skip this method</li>
	 * 	<li>Log a skip in the extent report</li>
	 * 	<li>View XSite order</li>
	 * 	<li>Get history text</li>
	 * 	<li>Recapture the text from the history</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Verify documents</li>
	 * 	<li>Verify comments</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Verify SSR is not in the history</li>
	 * 	<li>Verify FNM SSR is not in the Documents</li>
	 * 	<li>Close XSite order</li>
	 * 	<li>Log in to VMP</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify the audit trail</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Verify the order details</li>
	 * 	<li>Verify Document is in Documents</li>
	 * 	<li>Verify SSR is not in the history</li>
	 * 	<li>Verify FNM SSR is not in the Documents</li>
	 * 	<li>Click on Sales Contract</li>
	 * 	<li>Verify file name and uploaded by</li>
	 * 	<li>Click on Other</li>
	 * 	<li>Verify file name and uploaded by</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify Other Document is in Documents</li>
	 * 	<li>Verify SSR is not in the history</li>
	 * 	<li>Verify FNM SSR is not in the Documents</li>
	 * 	<li>Verify Sales ContractDocument is in Documents</li>
	 * 	<li>Click on Sales Contract</li>
	 * 	<li>Verify file name and uploaded by</li>
	 * 	<li>Click on Other</li>
	 * 	<li>Verify file name and uploaded by</li>
	 * 	<li>If browser is Firefox, skip this method</li>
	 * 	<li>Log a skip in the extent report</li>
	 * 	<li>View XSite order</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Verify documents</li>
	 * 	<li>Verify SSR is not in the history</li>
	 * 	<li>Verify FNM SSR is not in the Documents</li>
	 * 	<li>Verify comments</li>
	 * 	<li>Close XSite order</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify Documents aren't in Documents</li>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify order status</li>
	 * 	<li>Click on the order from the orders grid</li>
	 * 	<li>Click Message</li>
	 * 	<li>Add notes</li>
	 * 	<li>Click Send button</li>
	 * 	<li>Get order information text</li>
	 * 	<li>Verify audit trail</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Get comments</li>
	 * 	<li>Verify both VMP and MN comments are displayed</li>
	 * 	<li>View Order Details</li>
	 * 	<li>Verify Document is in Documents</li>
	 * 	<li>Click Sales Contract</li>
	 * 	<li>Verify Uploaded By and Document Name</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Click Sync to VMP button</li>
	 * 	<li>Verify message text</li>
	 * 	<li>Check Action Required checkbox</li>
	 * 	<li>Click OK</li>
	 * 	<li>If browser is Firefox, skip this method</li>
	 * 	<li>Log a skip in the extent report</li>
	 * 	<li>View XSite order</li>
	 * 	<li>Get history text</li>
	 * 	<li>Recapture the text from the history</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Verify documents</li>
	 * 	<li>Verify comments</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Verify SSR is not in the history</li>
	 * 	<li>Verify FNM SSR is not in the Documents</li>
	 * 	<li>Close XSite order</li>
	 * 	<li>Log in to VMP</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Recapture history text</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Verify the order details</li>
	 * 	<li>Verify Document is in Documents</li>
	 * 	<li>Verify SSR is not in the history</li>
	 * 	<li>Verify FNM SSR is not in the Documents</li>
	 * 	<li>Click on Sales Contract</li>
	 * 	<li>Verify file name and uploaded by</li>
	 * 	<li>Click on Other</li>
	 * 	<li>Verify file name and uploaded by</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify Other Document is in Documents</li>
	 * 	<li>Verify SSR is not in the history</li>
	 * 	<li>Verify FNM SSR is not in the Documents</li>
	 * 	<li>Verify Sales ContractDocument is in Documents</li>
	 * 	<li>Click on Sales Contract</li>
	 * 	<li>Verify file name and uploaded by</li>
	 * 	<li>Click on Other</li>
	 * 	<li>Verify file name and uploaded by</li>
	 * 	<li>If browser is Firefox, skip this method</li>
	 * 	<li>Log a skip in the extent report</li>
	 * 	<li>View XSite order</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Verify documents</li>
	 * 	<li>Verify SSR is not in the history</li>
	 * 	<li>Verify FNM SSR is not in the Documents</li>
	 * 	<li>Verify comments</li>
	 * 	<li>Close XSite order</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify Documents aren't in Documents</li>
	 * 	<li>Click OK</li>
	 * 	<li>Check to see if back on the orders screen, if not, verify cert info and save it</li>
	 * 	<li>Verify all fields have data</li>
	 * 	<li>Verify Lender Name</li>
	 * 	<li>Verify Property Street</li>
	 * 	<li>Verify Property City</li>
	 * 	<li>Verify Property State</li>
	 * 	<li>Verify Property Zip</li>
	 * 	<li>Verify Borrower Name</li>
	 * 	<li>Verify Loan Number</li>
	 * 	<li>Uncheck Appraised Date</li>
	 * 	<li>Uncheck Appraised Value</li>
	 * 	<li>Click Save</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Click OK</li>
	 * 	<li>Check to see if back on the orders screen, if not, verify cert info and save it</li>
	 * 	<li>Verify all fields have data</li>
	 * 	<li>Verify Lender Name</li>
	 * 	<li>Verify Property Street</li>
	 * 	<li>Verify Property City</li>
	 * 	<li>Verify Property State</li>
	 * 	<li>Verify Property Zip</li>
	 * 	<li>Verify Borrower Name</li>
	 * 	<li>Verify Loan Number</li>
	 * 	<li>Uncheck Appraised Date</li>
	 * 	<li>Uncheck Appraised Value</li>
	 * 	<li>Click Save</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>If browser is Firefox, skip this method</li>
	 * 	<li>Log a skip in the extent report</li>
	 * 	<li>View XSite order</li>
	 * 	<li>Get history text</li>
	 * 	<li>Recapture the text from the history</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Verify documents</li>
	 * 	<li>Verify comments</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Verify SSR is not in the history</li>
	 * 	<li>Verify FNM SSR is not in the Documents</li>
	 * 	<li>Close XSite order</li>
	 * 	<li>Log in to VMP</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify the audit trail</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Verify the order details</li>
	 * 	<li>Verify Document is in Documents</li>
	 * 	<li>Verify SSR is not in the history</li>
	 * 	<li>Verify FNM SSR is not in the Documents</li>
	 * 	<li>Click on Sales Contract</li>
	 * 	<li>Verify file name and uploaded by</li>
	 * 	<li>Click on Other</li>
	 * 	<li>Verify file name and uploaded by</li>
	 * 	<li>Click on Report PDF</li>
	 * 	<li>Verify file name and uploaded by</li>
	 * 	<li>Click on Attached Invoice</li>
	 * 	<li>Verify file name and uploaded by</li>
	 * 	<li>Click on Compliance Cert</li>
	 * 	<li>Verify file name and uploaded by</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify Other Document is in Documents</li>
	 * 	<li>Verify SSR is not in the history</li>
	 * 	<li>Verify FNM SSR is not in the Documents</li>
	 * 	<li>Verify Sales ContractDocument is in Documents</li>
	 * 	<li>Click on Sales Contract</li>
	 * 	<li>Verify file name and uploaded by</li>
	 * 	<li>Click on Other</li>
	 * 	<li>Verify file name and uploaded by</li>
	 * 	<li>Click on Report PDF</li>
	 * 	<li>Verify file name and uploaded by</li>
	 * 	<li>Click on Attached Invoice</li>
	 * 	<li>Verify file name and uploaded by</li>
	 * 	<li>Click on Compliance Cert</li>
	 * 	<li>Verify file name and uploaded by</li>
	 * 	<li>If browser is Firefox, skip this method</li>
	 * 	<li>Log a skip in the extent report</li>
	 * 	<li>View XSite order</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Verify documents</li>
	 * 	<li>Verify SSR is not in the history</li>
	 * 	<li>Verify FNM SSR is not in the Documents</li>
	 * 	<li>Verify comments</li>
	 * 	<li>Close XSite order</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify Documents aren't in Documents</li>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify order status</li>
	 * 	<li>Click on the order from the orders grid</li>
	 * 	<li>Get order information text</li>
	 * 	<li>Verify audit trail</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Get comments</li>
	 * 	<li>Verify both VMP and MN comments are displayed</li>
	 * 	<li>View Order Details</li>
	 * 	<li>Verify Document is in Documents</li>
	 * 	<li>Click Sales Contract</li>
	 * 	<li>Verify Uploaded By and Document Name</li>
	 * 	<li>Click Other</li>
	 * 	<li>Verify Uploaded By and Document Name</li>
	 * 	<li>Log test</li>
* </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"EVF", "Secure - VMP XSite Settings", "Secure - Configure Automatic Settings", "Secure - Configure Status Mapping", "Secure - Compliance Certificate", "Secure - Vendor Selection Settings", "Secure - Orders", 
			"VMP - Create Order", "Secure - Edit Order", "VMP - Orders", "VMP - Other Actions", "VMP - Place On Hold", "VMP - Resume", "VMP - Delayed", "VMP - Send Message", "VMP - Action Required", "XSite - Order Details", "Vendors - Accept Order", 
			"Vendors - Set Status", "Vendors - Inspection Scheduled", "Vendors - Inspection Complete", "Vendors - Complete Order", "Vendors - Send Message"}, alwaysRun=true)
	public void secondOrder() throws Exception {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Login to Secure
		secure.login(driver, "EVFAMC2", StoredVariables.getpassword().get());
		
		// Go to VMPXSites
		secure.goToVMPXSites(driver);
		
		// Verify the dropdown is the correct VMP site
		secure.verifyXSiteURLDropdownValue(driver, "EVFAMC2");
		
		// Click Configure Automatic Settings
		perform.click(driver,SVMPXSites.configureAutomaticSettings_lnk(driver));
		
		// Wait for Allow clients to enter fee
		perform.waitForElementToBeClickable(driver, SVMPXSites.createInvoiceWhenOrderIsPlaced_chkbx(), "id");
		
		// Check Create invoice when order is placed
		if (!SVMPXSites.createInvoiceWhenOrderIsPlaced_chkbx(driver).isSelected())
		{
			perform.click(driver,SVMPXSites.createInvoiceWhenOrderIsPlaced_chkbx(driver));
		}
		
		// Check Attach invoice when credit card is charged
		if (!SVMPXSites.attachInvoiceWhenCreditCardIsCharged_chkbx(driver).isSelected())
		{
			perform.click(driver,SVMPXSites.attachInvoiceWhenCreditCardIsCharged_chkbx(driver));
		}
		
		// Attach invoice when order is marked complete
		if (!SVMPXSites.attachInvoiceWhenOrderIsMarkedComplete_chkbx(driver).isSelected())
		{
			perform.click(driver,SVMPXSites.attachInvoiceWhenOrderIsMarkedComplete_chkbx(driver));
		}
		
		// Check Include the vendor's fee on the invoice
		if (!SVMPXSites.includeTheVendorsFeeOnTheInvoice_chkbx(driver).isSelected())
		{
			perform.click(driver,SVMPXSites.includeTheVendorsFeeOnTheInvoice_chkbx(driver));
		}
		
		// Enter 7 for Set the invoice due date
		SVMPXSites.setTheInvoiceDueDate_txtbx(driver).clear();
		perform.type(driver,SVMPXSites.setTheInvoiceDueDate_txtbx(driver), "7");
		
		// Auto numbers prefix
		SVMPXSites.prefix_txtbx(driver).clear();
		perform.type(driver,SVMPXSites.prefix_txtbx(driver), "87");
		
		// Auto number start number
		SVMPXSites.startNumberSequence_txtbx(driver).clear();
		perform.type(driver,SVMPXSites.startNumberSequence_txtbx(driver), "58");
		
		// Save Preferences
		perform.click(driver,SVMPXSites.save_btn(driver));
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SVMPXSites.saveCompleteOK_btn(), "cssSelector");
		
		// Click OK button
		perform.click(driver,SVMPXSites.saveCompleteOK_btn(driver));
		
		// Wait for button
		perform.waitForElementToBeClickable(driver, SVMPXSites.configureStatusMapping_lnk(), "id");
		
		// Click on Configure Status Mapping
		perform.click(driver,SVMPXSites.configureStatusMapping_lnk(driver));
		
		// Wait for element
		perform.waitForElementToBeVisible(driver, SVMPXSites.statusMappingConfiguration_txt(), "id");
		
		// Disable all sync status options
		perform.disableAllOptionsInStatusMappingConfiguration(driver);
		
		// Click Save
		perform.clickInTable_Contains(driver, "Save");
		
		// Wait for save dialog to be hidden 
		perform.waitForOverlayToBeHidden(driver);
		
		System.out.println("Verifying the database values");
		
		// Get the AWSAccountsID
		String env = StoredVariables.getenvironment().get();
		if (StoredVariables.getenvironment().get().equals("Dev") || StoredVariables.getenvironment().get().equals("QA2") || StoredVariables.getenvironment().get().equals("QA3"))
		{
			env = "QA";
		}
		if (StoredVariables.getenvironment().get().equals("Beta Offline"))
		{
			env = "Beta";
		}
		if (StoredVariables.getenvironment().get().equals("Live Offline"))
		{
			env = "Live";
		}
		
		String getAWSAccountsIDSQL = "SELECT AWSAccountsID FROM ULSAccounts u JOIN Entities e ON u.AppraiserEntityID = e.EntityID "
				+ "WHERE CompanyName = 'Automation" + env + "EVFAMC2' AND EntityTypeID = 32";		
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
	            		if (Description.equals("Vendor Accepted Assignment")){Assert.assertTrue(SyncDirection.equals("Does Not Sync"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Does Not Sync");}
	            		if (Description.equals("Inspection Scheduled")){Assert.assertTrue(SyncDirection.equals("Does Not Sync"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Does Not Sync");}
	            		if (Description.equals("Inspection Complete")){Assert.assertTrue(SyncDirection.equals("Does Not Sync"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Does Not Sync");}
	            		if (Description.equals("Delayed")){Assert.assertTrue(SyncDirection.equals("Does Not Sync"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Does Not Sync");}
	            		if (Description.equals("On Hold")){Assert.assertTrue(SyncDirection.equals("Does Not Sync"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Does Not Sync");}
	            		if (Description.equals("Resumed")){Assert.assertTrue(SyncDirection.equals("Does Not Sync"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Does Not Sync");}
	            		if (Description.equals("Document Uploaded")){Assert.assertTrue(SyncDirection.equals("Does Not Sync"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Does Not Sync");}
	            		if (Description.equals("Order Changed")){Assert.assertTrue(SyncDirection.equals("Does Not Sync"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Does Not Sync");}
	            		if (Description.equals("Cancelled")){Assert.assertTrue(SyncDirection.equals("Does Not Sync"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Does Not Sync");}
	            		if (Description.equals("Pending Quality Review")){Assert.assertTrue(SyncDirection.equals("Does Not Sync"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Does Not Sync");}
	            		if (Description.equals("Revision Needed")){Assert.assertTrue(SyncDirection.equals("Does Not Sync"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Does Not Sync");}
	            		if (Description.equals("Revision Request Cancelled")){Assert.assertTrue(SyncDirection.equals("Does Not Sync"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Does Not Sync");}
	            		if (Description.equals("Copy of Completed Appraisal E-mailed to Borrower")){Assert.assertTrue(SyncDirection.equals("Does Not Sync"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Does Not Sync");}
	            		if (Description.equals("Appraisal Viewed by {0}")){Assert.assertTrue(SyncDirection.equals("Does Not Sync"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Does Not Sync");}
	            		if (Description.equals("{0} <b>declined</b> to receive the appraisal electronically")){Assert.assertTrue(SyncDirection.equals("Does Not Sync"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Does Not Sync");}
	            		if (Description.equals("{0} consented to receive the appraisal electronically")){Assert.assertTrue(SyncDirection.equals("Does Not Sync"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Does Not Sync");}
	            		if (Description.equals("SureReceipts delivery to Borrower scheduled")){Assert.assertTrue(SyncDirection.equals("Does Not Sync"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Does Not Sync");}
	            		if (Description.equals("Update Disclosure Date")){Assert.assertTrue(SyncDirection.equals("Does Not Sync"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Does Not Sync");}
	            		if (Description.equals("Appraisal Submitted to {0} via UCDP")){Assert.assertTrue(SyncDirection.equals("Does Not Sync"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Does Not Sync");}
	            		if (Description.equals("Appraisal Submission Accepted by {0} via UCDP")){Assert.assertTrue(SyncDirection.equals("Does Not Sync"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Does Not Sync");}
	            		if (Description.equals("Appraisal Submission to {0} Not Successful")){Assert.assertTrue(SyncDirection.equals("Does Not Sync"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Does Not Sync");}
	            		if (Description.equals("UCDP Document File ID Updated")){Assert.assertTrue(SyncDirection.equals("Does Not Sync"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Does Not Sync");}
	            		if (Description.equals("UCDP Status Removed")){Assert.assertTrue(SyncDirection.equals("Does Not Sync"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Does Not Sync");}
	            		if (Description.equals("AQI results returned ")){Assert.assertTrue(SyncDirection.equals("Does Not Sync"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Does Not Sync");}
	            		if (Description.equals("Appraisal Submitted to FHA via EAD")){Assert.assertTrue(SyncDirection.equals("Does Not Sync"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Does Not Sync");}
	            		if (Description.equals("Appraisal Submission Accepted by FHA via EAD")){Assert.assertTrue(SyncDirection.equals("Does Not Sync"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Does Not Sync");}
	            		if (Description.equals("Appraisal Submission to FHA Not Successful")){Assert.assertTrue(SyncDirection.equals("Does Not Sync"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Does Not Sync");}
	            		if (Description.equals("FHA Document File ID Updated")){Assert.assertTrue(SyncDirection.equals("Does Not Sync"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Does Not Sync");}
	            		if (Description.equals("FHA Status Removed")){Assert.assertTrue(SyncDirection.equals("Does Not Sync"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Does Not Sync");}
	            		if (Description.equals("Message")){Assert.assertTrue(SyncDirection.equals("Does Not Sync"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Does Not Sync");}
	            		if (Description.equals("Comment - Action Required")){Assert.assertTrue(SyncDirection.equals("Does Not Sync"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Does Not Sync");}
	            		if (Description.equals("Conditionally Declined")){Assert.assertTrue(SyncDirection.equals("Does Not Sync"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Does Not Sync");}
	            		if (Description.equals("Vendor assignment expired")){Assert.assertTrue(SyncDirection.equals("Does Not Sync"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Does Not Sync");}
	            		if (Description.equals("Vendor declined assignment")){Assert.assertTrue(SyncDirection.equals("Does Not Sync"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Does Not Sync");}

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
		
		// Click on Compliance Certificate
		perform.click(driver,SVMPXSites.complianceCertificate_lnk(driver));
		
		// Wait for options button
		perform.waitForElementToBeClickable(driver, SVMPXSites.options_btn(), "cssSelector");
		
		// Click Options button
		perform.click(driver,SVMPXSites.options_btn(driver));
		
		// Wait for checkbox
		perform.waitForElementToBeClickable(driver, SVMPXSites.alwaysAttachACopyOfTheComplianceCertificate_chkbx(), "id");

		// Check Always attach a copy of the Compliance Certificate checkbox
		if (!SVMPXSites.alwaysAttachACopyOfTheComplianceCertificate_chkbx(driver).isSelected())
		{
			perform.click(driver,SVMPXSites.alwaysAttachACopyOfTheComplianceCertificate_chkbx(driver));
		}
		
		// Click OK
		perform.click(driver,SVMPXSites.OK_btn(driver));
		
		// Wait for Save button
		perform.waitForElementToBeClickable(driver, SVMPXSites.complianceCertificateSave_btn(), "cssSelector");
		
		// Save Preferences
		perform.click(driver,SVMPXSites.complianceCertificateSave_btn(driver));
		
		// Wait for the OK button
		perform.waitForElementToBeClickable(driver, SVendorSelectionSettings.okAlert_btn(), "cssSelector");
		
		// Click OK in saved dialog box
		perform.click(driver,SVendorSelectionSettings.okAlert_btn(driver));
		
		// Wait for the Preferences button to be visible
		perform.waitForElementToBeClickable(driver, SOrders.preferences_btn(), "id");
		
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
		
		secure.login(driver, "EVFLender2", StoredVariables.getpassword().get());
		
		perform.waitForElementToBeClickable(driver, SOrders.preferences_btn(), "id");
		
		perform.click(driver,SOrders.preferences_btn(driver));
		
		perform.waitForElementToBeClickable(driver, SPreferences.vmpXSites_btn(), "cssSelector");
		
		perform.click(driver,SPreferences.vmpXSites_btn(driver));
		
		// Verify the dropdown is the correct VMP site
		secure.verifyXSiteURLDropdownValue(driver, "EVFLender2");
		
		// Click Configure Automatic Settings
		perform.click(driver,SVMPXSites.configureAutomaticSettings_lnk(driver));
		
		// Wait for Allow clients to enter fee
		perform.waitForElementToBeClickable(driver, SVMPXSites.createInvoiceWhenOrderIsPlaced_chkbx(), "id");
		
		// Check Create invoice when order is placed
		if (!SVMPXSites.createInvoiceWhenOrderIsPlaced_chkbx(driver).isSelected())
		{
			perform.click(driver,SVMPXSites.createInvoiceWhenOrderIsPlaced_chkbx(driver));
		}
		
		// Check Attach invoice when credit card is charged
		if (!SVMPXSites.attachInvoiceWhenCreditCardIsCharged_chkbx(driver).isSelected())
		{
			perform.click(driver,SVMPXSites.attachInvoiceWhenCreditCardIsCharged_chkbx(driver));
		}
		
		// Attach invoice when order is marked complete
		if (!SVMPXSites.attachInvoiceWhenOrderIsMarkedComplete_chkbx(driver).isSelected())
		{
			perform.click(driver,SVMPXSites.attachInvoiceWhenOrderIsMarkedComplete_chkbx(driver));
		}
		
		// Check Include the vendor's fee on the invoice
		if (!SVMPXSites.includeTheVendorsFeeOnTheInvoice_chkbx(driver).isSelected())
		{
			perform.click(driver,SVMPXSites.includeTheVendorsFeeOnTheInvoice_chkbx(driver));
		}
		
		// Enter 7 for Set the invoice due date
		SVMPXSites.setTheInvoiceDueDate_txtbx(driver).clear();
		perform.type(driver,SVMPXSites.setTheInvoiceDueDate_txtbx(driver), "7");
		
		// Auto numbers prefix
		SVMPXSites.prefix_txtbx(driver).clear();
		perform.type(driver,SVMPXSites.prefix_txtbx(driver), "87");
		
		// Auto number start number
		SVMPXSites.startNumberSequence_txtbx(driver).clear();
		perform.type(driver,SVMPXSites.startNumberSequence_txtbx(driver), "58");
		
		// Save Preferences
		perform.click(driver,SVMPXSites.save_btn(driver));
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SVMPXSites.saveCompleteOK_btn(), "cssSelector");
		
		// Click OK button
		perform.click(driver,SVMPXSites.saveCompleteOK_btn(driver));
		
		// Wait for button
		perform.waitForElementToBeClickable(driver, SVMPXSites.configureStatusMapping_lnk(), "id");
		
		// Click on Configure Status Mapping
		perform.click(driver,SVMPXSites.configureStatusMapping_lnk(driver));
		
		// Wait for element
		perform.waitForElementToBeVisible(driver, SVMPXSites.statusMappingConfiguration_txt(), "id");
		
		// Enable all sync status options
		perform.enableAllOptionsInStatusMappingConfiguration(driver);
		
		// Click the Client Document Upload gear icon
		perform.click(driver,SVMPXSites.documentUploadedAppraiserClientGearIcon_btn(driver));
		
		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		// Check every option for syncing
		perform.enableAllCheckboxesToSyncToVMP(driver);
		
		// Click OK
		perform.click(driver,SVMPXSites.okSyncToVMPCheckboxesClient_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Click the Vendor Document Upload gear icon
		perform.click(driver,SVMPXSites.documentUploadedAppraiserVendorGearIcon_btn(driver));
		
		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		// Check every option for syncing
		perform.enableAllCheckboxesToSyncToVMP(driver);
		
		// Click OK
		perform.click(driver,SVMPXSites.okSyncToVMPCheckboxesVendor_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Click Save
		perform.clickInTable_Contains(driver, "Save");
		
		// Wait for save dialog to be hidden 
		perform.waitForOverlayToBeHidden(driver);
		
		// Click on AMC/Firm
		perform.click(driver,SVMPXSites.amcFirm_btn(driver));
		
		// Wait for element
		perform.waitForElementToBeVisible(driver, SVMPXSites.documentUploadedAMCClientGearIcon_btn(), "id");
		
		// Enable all sync status options for Appraiser/Agent
		perform.enableAllOptionsInStatusMappingConfiguration(driver);
		
		// Click the AMC Client Document Upload gear icon
		perform.click(driver,SVMPXSites.documentUploadedAMCClientGearIcon_btn(driver));
		
		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		// Check every option for syncing
		perform.enableAllCheckboxesToSyncToVMP(driver);
		
		// Click OK
		perform.click(driver,SVMPXSites.okSyncToVMPCheckboxesClient_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Click the AMC Vendor Document Upload gear icon
		perform.click(driver,SVMPXSites.documentUploadedAMCVendorGearIcon_btn(driver));
		
		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		// Check every option for syncing
		perform.enableAllCheckboxesToSyncToVMP(driver);
		
		// Click OK
		perform.click(driver,SVMPXSites.okSyncToVMPCheckboxesVendor_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Click Save
		perform.clickInTable_Contains(driver, "Save");
		
		// Wait for save dialog to be hidden 
		perform.waitForOverlayToBeHidden(driver);
		
		System.out.println("Verifying the database values");
		
		// Get the AWSAccountsID
		env = StoredVariables.getenvironment().get();
		if (StoredVariables.getenvironment().get().equals("Dev") || StoredVariables.getenvironment().get().equals("QA2") || StoredVariables.getenvironment().get().equals("QA3"))
		{
			env = "QA";
		}
		if (StoredVariables.getenvironment().get().equals("Beta Offline"))
		{
			env = "Beta";
		}
		if (StoredVariables.getenvironment().get().equals("Live Offline"))
		{
			env = "Live";
		}
		
		getAWSAccountsIDSQL = "SELECT AWSAccountsID FROM ULSAccounts u JOIN Entities e ON u.AppraiserEntityID = e.EntityID "
				+ "WHERE CompanyName = 'Automation" + env + "EVFLender2' AND EntityTypeID = 1";		
		StoredVariables.getAWSAccountsID().set(db.queryDB(driver, "Mercury", getAWSAccountsIDSQL));
		
		// Set the DB Connection String
		dbUrl = perform.setDBConnectionString(driver, "Mercury");
		
		// Get sync statuses
		getSyncStatusSQL = "SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED SELECT UA.SyncStatus, UA.SyncStatusXSite, LS.[Description], "
				+ "CASE SSP.SyncFromBitMask WHEN 0 THEN 'Does Not Sync' WHEN 1 THEN 'Sync To VMP XSite' WHEN 2 THEN 'Sync to Mercury' "
				+ "WHEN 3 THEN 'Sync to Both' END AS 'SyncDirection' FROM Mercury.dbo.ULS_StatusSyncPrefs SSP JOIN Mercury.dbo.ListStatus LS "
				+ "ON LS.ListStatusID = SSP.ListStatusID JOIN Mercury.dbo.ULSAccounts UA ON UA.AppraiserEntityID = SSP.AppraiserEntityID "
				+ "WHERE 1=1 AND UA.AWSAccountsID = '" + StoredVariables.getAWSAccountsID().get() + "'";
		
		//Load the required JDBC Driver class
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
		
	 	conn = null;
	 	
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
		
		// Click on Compliance Certificate
		perform.click(driver,SVMPXSites.complianceCertificate_lnk(driver));
		
		// Wait for options button
		perform.waitForElementToBeClickable(driver, SVMPXSites.options_btn(), "cssSelector");
		
		// Click Options button
		perform.click(driver,SVMPXSites.options_btn(driver));

		// Check Always attach a copy of the Compliance Certificate checkbox
		if (!SVMPXSites.alwaysAttachACopyOfTheComplianceCertificate_chkbx(driver).isSelected())
		{
			perform.click(driver,SVMPXSites.alwaysAttachACopyOfTheComplianceCertificate_chkbx(driver));
		}
		
		// Click OK
		perform.click(driver,SVMPXSites.OK_btn(driver));
		
		// Wait for Save button
		perform.waitForElementToBeClickable(driver, SVMPXSites.complianceCertificateSave_btn(), "cssSelector");
		
		// Save Preferences
		perform.click(driver,SVMPXSites.complianceCertificateSave_btn(driver));
		
		// Wait for the OK button
		perform.waitForElementToBeClickable(driver, SVendorSelectionSettings.okAlert_btn(), "cssSelector");
		
		// Click OK in saved dialog box
		perform.click(driver,SVendorSelectionSettings.okAlert_btn(driver));
		
		// Wait for the Preferences button to be visible
		perform.waitForElementToBeClickable(driver, SOrders.preferences_btn(), "id");
		
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
		
		// Enable Unattended Order Assignment Selection
		if (!SVendorSelectionSettings.unattendedOrderAssignment_switch(driver).getAttribute("src").contains("switchOn.png"))
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
		
		// Wait for the OK button to be visible
		perform.waitForElementToBeClickable(driver, SVendorSelectionSettings.ok_btn(), "id");
		
		// Click OK in saved dialog box
		perform.click(driver,SVendorSelectionSettings.ok_btn(driver));
		
		// Clear order information variables before placing a new order
		perform.clearOrderInfoStoredVariables(driver);
		
		// Login to VMP Client Portal
		vmp.login(driver, "EVFLender2", "OriginatorEVFLender2", StoredVariables.getpassword().get());
		
		// Wait for New Order button
		perform.waitForElementToBeClickable(driver, VMPOrders.newOrder_btn(), "cssSelector");
		
		// Click New Order
		perform.click(driver,VMPOrders.newOrder_btn(driver));
		
		// Wait for Address text box
		perform.waitForElementToBeClickable(driver, VMPNewOrder.address_txtbx(), "id");
		
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
		StoredVariables.getpropertyInformationLegalDesc().set("717 Vickery Ave, Yukon, OK 73099");
		StoredVariables.getpropertyInformationDirections().set("Mustang Rd and NW 10th St.");
		
		// Set Assignment Information data
		StoredVariables.getassignmentInformationForm().set("1004 Full/URAR");
		StoredVariables.getassignmentInformationOrderDue().set(7);
		perform.getNewDate(driver, StoredVariables.getassignmentInformationOrderDue().get());
		StoredVariables.getassignmentInformationOtherRefNumber().set(perform.randomNumbers(driver, 7));
		while (StoredVariables.getassignmentInformationOtherRefNumber().get().contains("525"))
		{
			StoredVariables.getassignmentInformationOtherRefNumber().set(perform.randomNumbers(driver, 7));	
			StoredVariables.getassignmentInformationOtherRefNumber().get();
		}
		StoredVariables.getassignmentInformationLoanType().set("All In One");
		StoredVariables.getassignmentInformationLoanPurpose().set("Purchase");
		StoredVariables.getassignmentInformationOrderedBy().set("Borrower Name");
		StoredVariables.getassignmentInformationAccountExec().set("(None Selected)");
		StoredVariables.getassignmentInformationLoanNumber().set(perform.randomNumbers(driver, 15));
		while (StoredVariables.getassignmentInformationOtherRefNumber().get().contains("525"))
		{
			StoredVariables.getassignmentInformationOtherRefNumber().set(perform.randomNumbers(driver, 15));	
			StoredVariables.getassignmentInformationOtherRefNumber().get();
		}
		StoredVariables.getassignmentInformationFileNumber().set(perform.randomNumbers(driver, 8));
		while (StoredVariables.getassignmentInformationFileNumber().get().contains("525"))
		{
			StoredVariables.getassignmentInformationFileNumber().set(perform.randomNumbers(driver, 8));	
			StoredVariables.getassignmentInformationFileNumber().get();
		}
		StoredVariables.getassignmentInformationSalesPrice().set("645,715");
		StoredVariables.getassignmentInformationFHACaseNumber().set(perform.randomNumbers(driver, 8));
		while (StoredVariables.getassignmentInformationFHACaseNumber().get().contains("525"))
		{
			StoredVariables.getassignmentInformationFHACaseNumber().set(perform.randomNumbers(driver, 8));	
			StoredVariables.getassignmentInformationFHACaseNumber().get();
		}
		StoredVariables.getassignmentInformationDisclosure().set(0);
		
		// Set Lender Information data
		StoredVariables.getlenderInformationLenderName().set("US Bank");
		StoredVariables.getlenderInformationAddress1().set("123 Test St");
		StoredVariables.getlenderInformationCity().set("Mustang");
		StoredVariables.getlenderInformationState().set("Oklahoma");
		StoredVariables.getlenderInformationZip().set("73064");
		
		// Set Contact And Access Information data
		StoredVariables.getcontactOccupancy().set("Owner");
		StoredVariables.getcontactBorrower().set("Test User");
		StoredVariables.getcontactBorrowerInfo1Dropdown().set("Home");
		StoredVariables.getcontactBorrowerInfo1().set("405-555-1111");
		StoredVariables.getcontactBorrowerInfo2Dropdown().set("E-mail");
		StoredVariables.getcontactBorrowerInfo2().set("test@dntest.net");
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
		StoredVariables.getassignmentInformationAssignedTo().set("Automation OriginatorEVFLender2");
		
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
		
		// Verify VMP Order Details
		vmp.verifyOrderDetails(driver);
		
		// Verify the order fee is not 0
		Assert.assertTrue(!VMPConfirmOrder.orderFee_txtbx(driver).getAttribute("value").equals("0"), "Order Fee should not equal 0. Check the XSite fee settings for the product");

		// Wait for Next button to load
		perform.waitForElementToBeClickable(driver, VMPConfirmOrder.nextTop_btn(), "id");
		
		// Click Next
		perform.click(driver,VMPConfirmOrder.nextTop_btn(driver));
		
		Thread.sleep(10000);
		
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Get inside the attach document frame
		perform.switchToiFrameByID(driver, "iframeAttach");
		
		// Wait for message text
		perform.waitForElementToBeClickable(driver, VMPConfirmOrder.uploadDocuments_btn(), "id");
		
		// Select document type
		perform.selectDropdownOption(driver, VMPConfirmOrder.documentType_dropdown(driver), "Other");
		
		// Click Finished Button
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
		db.getLoanIDsFromEVFClientPortalOrder(driver);
		
		// Verify Due date is ordered properly to display the most recent order first
		secure.sortByUpdated(driver);
		
		// Wait for overlay to disappear
		perform.waitForOverlayToBeHidden(driver);
		
		// Verify the order just created is in the orders grid 
		Assert.assertTrue(SOrders.ordersTable_txt(driver).getText().contains(StoredVariables.getborrowerIdentifier().get()), "New order is not displayed");

		// Verify data in the database
		db.verifyNewOrderDataInDB_All(driver, StoredVariables.getloanIDVMP().get());

		// Log in to Secure
		secure.login(driver, "EVFAMC2", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, StoredVariables.getloanIDAMC().get(), "Tracking number");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("Requires assignment"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getloanIDAMC().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Verify the order details
		secure.verifyResidentialAppraisalOrderDetails(driver);
		
		// Get history text
		String history = SOrderDetails.history_txt(driver).getText();
		
		// Verify the history
		Assert.assertTrue(history.contains("History (Requires assignment)"), "History (Requires assignment) is missing from the order information");
		Assert.assertTrue(history.contains("Requires assignment"), "Requires assignment is missing from the order information");
		Assert.assertTrue(history.contains("Awaiting acceptance"), "Awaiting acceptance is missing from the order information");
		
		// Click Edit
		perform.clickInTable_Contains(driver, "Edit");
		
		// Wait for VMP Comments
		perform.waitForElementToBeClickable(driver, SNewOrder.vmpComments_txtbx(), "id");
		
		// Get the text from VMP Comments
		String originalComments = SNewOrder.vmpComments_txtbx(driver).getAttribute("value");
		
		// Enter new comments
		SNewOrder.vmpComments_txtbx(driver).clear();
		perform.type(driver,SNewOrder.vmpComments_txtbx(driver), originalComments + "\n\nThese are edited comments by EVFAMC");
		
		// Click Save
		perform.clickInTable_Contains(driver, "Save");
		
		// Wait for overly to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for VMP Comments checkbox
		perform.waitForElementToBeClickable(driver, SNewOrder.vmpComments_chkbx(), "id");
		
		// Check VMP Comments
		perform.click(driver,SNewOrder.vmpComments_chkbx(driver));

		Thread.sleep(2000);
		
		// Click OK
		perform.click(driver,SNewOrder.okUpdateClient_btn(driver));
		
		// Wait for Assign button
		perform.waitForElementToBeClickable(driver, SOrderDetails.assign_btn(), "id");
		
		// Click Assign button
		perform.click(driver,SOrderDetails.assign_btn(driver));
		
		Thread.sleep(15000);
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		Thread.sleep(2000);
		
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
		perform.clickInTable_Contains(driver, "Automation Appraiser3");
		
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
		
		// Agree to pay the transaction fee
		if (!SConfirmOrder.transactionFee_chkbx(driver).isSelected())
		{
			perform.click(driver,SConfirmOrder.transactionFee_chkbx(driver));
		}
		
		// Click Finish
		perform.click(driver,SConfirmOrder.nextTop_btn(driver));
		
		// Wait for page to load
		perform.waitForElementToBeClickable(driver, SOrders.orders_btn(), "cssSelector");
		
		// Verify the order is in the Awaiting acceptance status
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		String historyText = SOrderDetails.history_txt(driver).getText();
		Assert.assertTrue(historyText.contains("History (Awaiting acceptance"), "The order is not in Awaiting acceptance status");
		
		// Verify audit trail
		Assert.assertTrue(historyText.contains("Awaiting acceptance by Automation Appraiser3"), "Awaiting acceptance by Automation Appraiser3 is missing from the audit trail");
		Assert.assertTrue(historyText.contains("Reassigned by Client (Automation EVFAMC2) to Automation Appraiser3"), "Reassigned by Client (Automation EVFAMC2) to Automation Appraiser3 is missing from the audit trail");
		Assert.assertTrue(historyText.contains("Order Changed by Client (Automation EVFAMC2)"), "Order Changed by Client (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(historyText.contains("To View Change History:"), "To View Change History: is missing from the audit trail");
		Assert.assertTrue(historyText.contains("Requires assignment"), "Requires assignment is missing from the audit trail");
		Assert.assertTrue(historyText.contains("Awaiting acceptance"), "Awaiting acceptance is missing from the audit trail");
		
		// Log in to Vendors
		vendors.login(driver, "Appraiser3", StoredVariables.getpassword().get());
		
		// Search for order
		vendors.findOrder(driver, StoredVariables.getloanIDAMC().get(), "Tracking Number");
		
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
		Assert.assertTrue(orderInformation.contains("Awaiting acceptance by Automation Appraiser3"), "Awaiting acceptance by Automation Appraiser3 is missing from the order information");
		
		// Get comments
		String additionalComments = VOrderDetails.additionalComments_txt(driver).getText();
		
		// Verify both VMP and MN comments are displayed
		Assert.assertTrue(additionalComments.contains("These are edited comments by EVFAMC"), "Additional Comments section is missing info");
		
		// View Order Details
		vendors.verifyOrderDetails(driver);

		// Log in to VMP
		vmp.login(driver, "EVFLender2", "OriginatorEVFLender2", StoredVariables.getpassword().get());
		
		// Search for order
		vmp.findOrder(driver, StoredVariables.getloanIDVMP().get(), "Tracking #");
		
		// Verify Order Status
		Assert.assertTrue(VMPOrders.orderStatus_txt(driver).getText().equals("In Progress"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());
		
		Thread.sleep(1500);
		
		// Wait for Edit Property Contacts link
		perform.waitForElementToBeClickable(driver, VMPAppraisalOrderDetails.editPropertyContacts_lnk(), "id");
		
		// Verify the audit trail
		Assert.assertTrue(VMPAppraisalOrderDetails.history_txt(driver).getText().contains("In Progress by Automation OriginatorEVFLender2"), "In Progress by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(VMPAppraisalOrderDetails.areaBelowHistory_txt(driver).getText().contains("For compliance exams, every order event is recorded here for your protection."), "For compliance exams, every order event is recorded here for your protection is missing from the audit trail");
		
		// Verify the order details
		vmp.verifyAppraisalOrderDetails(driver);
		
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
		perform.type(driver,VMPAppraisalOrderDetails.placeOnHoldNotes_txtbx(driver), "These are Place On Hold test notes from OriginatorEVFLender2");
		
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
		Assert.assertTrue(history.contains("On Hold by Automation OriginatorEVFLender2"), "On Hold by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVFLender2"), "These are Place On Hold test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("In Progress by Automation OriginatorEVFLender2"), "In Progress by Automation OriginatorEVFLender2 is missing from the audit trail");

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
		perform.type(driver,VMPAppraisalOrderDetails.resumeNotes_txtbx(driver), "These are Resume test notes from OriginatorEVFLender2");
		
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
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorEVFLender2"), "Resumed by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVFLender2"), "These are Resume test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Automation OriginatorEVFLender2"), "On Hold by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVFLender2"), "These are Place On Hold test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("In Progress by Automation OriginatorEVFLender2"), "In Progress by Automation OriginatorEVFLender2 is missing from the audit trail");

		// Click Other Actions
		perform.click(driver,VMPAppraisalOrderDetails.otherActions_btn(driver));
		
		// Click Delayed
		perform.click(driver,VMPAppraisalOrderDetails.delayed_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, VMPAppraisalOrderDetails.delayedOk_btn(), "cssSelector");
		
		// Add notes
		perform.type(driver,VMPAppraisalOrderDetails.delayedNotes_txtbx(driver), "These are Delayed test notes from OriginatorEVFLender2");
		
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
		history = VMPAppraisalOrderDetails.history_txt(driver).getText();
		Assert.assertTrue(history.contains("Delayed by Automation OriginatorEVFLender2"), "Delayed by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVFLender2"), "These are Delayed test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorEVFLender2"), "Resumed by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVFLender2"), "These are Resume test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Automation OriginatorEVFLender2"), "On Hold by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVFLender2"), "These are Place On Hold test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("In Progress by Automation OriginatorEVFLender2"), "In Progress by Automation OriginatorEVFLender2 is missing from the audit trail");
		
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
		perform.switchToiFrameByID(driver, "iframeAttach");
		
		// Wait for message text
		perform.waitForElementToBeClickable(driver, VMPConfirmOrder.uploadDocuments_btn(), "id");
		
		// Select document type
		perform.selectDropdownOption(driver, VMPConfirmOrder.documentType_dropdown(driver), "Sales Contract");
		
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
		perform.clickInTable_Contains(driver, "Sales Contract");
		
		// Wait for open button
		perform.waitForElementToBeClickable(driver, VMPAppraisalOrderDetails.open_btn(), "id");
		
		// Verify attached document name
		Assert.assertTrue(VMPAppraisalOrderDetails.attachedDocumentName_txt(driver).getText().contains("Test PDF"), "The document didn't get uploaded. The name = " + VMPAppraisalOrderDetails.attachedDocumentName_txt(driver).getText());
		
		// Verify uploaded by is correct
		Assert.assertTrue(VMPAppraisalOrderDetails.attachedDocumentUploadedBy_txt(driver).getText().equals("Automation OriginatorEVFLender2"), "The Uploaded By name is incorrect. It is - " + VMPAppraisalOrderDetails.attachedDocumentUploadedBy_txt(driver).getText());
		
		// Verify history
		history = VMPAppraisalOrderDetails.history_txt(driver).getText();
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorEVFLender2"), "Document Uploaded by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Sales Contract"), "Sales Contract is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF"), "Test PDF is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation OriginatorEVFLender2"), "Delayed by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVFLender2"), "These are Delayed test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorEVFLender2"), "Resumed by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVFLender2"), "These are Resume test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Automation OriginatorEVFLender2"), "On Hold by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVFLender2"), "These are Place On Hold test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("In Progress by Automation OriginatorEVFLender2"), "In Progress by Automation OriginatorEVFLender2 is missing from the audit trail");

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
		filePath = StoredVariables.getdocDir().get()+"TestPDF.pdf";
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
		Assert.assertTrue(VMPAppraisalOrderDetails.attachedDocumentName_txt(driver).getText().equals("TestPDF.pdf"), "The document didn't get uploaded. The name = " + VMPAppraisalOrderDetails.attachedDocumentName_txt(driver).getText());
		
		// Verify uploaded by is correct
		Assert.assertTrue(VMPAppraisalOrderDetails.attachedDocumentUploadedBy_txt(driver).getText().equals("Automation OriginatorEVFLender2"), "The Uploaded By name is incorrect. It is - " + VMPAppraisalOrderDetails.attachedDocumentUploadedBy_txt(driver).getText());
		
		// Verify history
		history = VMPAppraisalOrderDetails.history_txt(driver).getText();
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorEVFLender2"), "Document Uploaded by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Other"), "Other is missing from the audit trail");
		Assert.assertTrue(history.contains("TestPDF.pdf"), "TestPDF.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorEVFLender2"), "Document Uploaded by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Sales Contract"), "Sales Contract is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF"), "Test PDF is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation OriginatorEVFLender2"), "Delayed by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVFLender2"), "These are Delayed test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorEVFLender2"), "Resumed by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVFLender2"), "These are Resume test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Automation OriginatorEVFLender2"), "On Hold by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVFLender2"), "These are Place On Hold test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("In Progress by Automation OriginatorEVFLender2"), "In Progress by Automation OriginatorEVFLender2 is missing from the audit trail");

		// Wait for Send Message button
		perform.waitForElementToBeVisible(driver, VMPAppraisalOrderDetails.sendMessage_btn(), "cssSelector");
		
		// Click Send Message
		perform.click(driver,VMPAppraisalOrderDetails.sendMessage_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for Send button
		perform.waitForElementToBeClickable(driver, VMPAppraisalOrderDetails.send_btn(), "cssSelector");
		
		// Add notes
		perform.type(driver,VMPAppraisalOrderDetails.sendMessage_txtbx(driver), "These are test Send Message notes from OriginatorEVFLender2");
		
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
		Assert.assertTrue(history.contains("Message by Automation OriginatorEVFLender2"), "Message by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVFLender2"), "These are test Send Message notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorEVFLender2"), "Document Uploaded by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Other"), "Other is missing from the audit trail");
		Assert.assertTrue(history.contains("TestPDF.pdf"), "TestPDF.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorEVFLender2"), "Document Uploaded by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Sales Contract"), "Sales Contract is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF"), "Test PDF is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation OriginatorEVFLender2"), "Delayed by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVFLender2"), "These are Delayed test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorEVFLender2"), "Resumed by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVFLender2"), "These are Resume test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Automation OriginatorEVFLender2"), "On Hold by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVFLender2"), "These are Place On Hold test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("In Progress by Automation OriginatorEVFLender2"), "In Progress by Automation OriginatorEVFLender2 is missing from the audit trail");
		
		// Wait for Send Message button
		perform.waitForElementToBeClickable(driver, VMPAppraisalOrderDetails.sendMessage_btn(), "cssSelector");
		
		// Click Send Message
		perform.click(driver,VMPAppraisalOrderDetails.sendMessage_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for Send button
		perform.waitForElementToBeClickable(driver, VMPAppraisalOrderDetails.send_btn(), "cssSelector");
		
		// Add notes
		perform.type(driver,VMPAppraisalOrderDetails.sendMessage_txtbx(driver), "These are Action Required test notes from OriginatorEVFLender2");
		
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
		Assert.assertTrue(history.contains("Comment - Action Required by Automation OriginatorEVFLender2"), "Comment - Action Required by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVFLender2"), "These are Action Required test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation OriginatorEVFLender2"), "Message by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVFLender2"), "These are test Send Message notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorEVFLender2"), "Document Uploaded by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Other"), "Other is missing from the audit trail");
		Assert.assertTrue(history.contains("TestPDF.pdf"), "TestPDF.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorEVFLender2"), "Document Uploaded by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Sales Contract"), "Sales Contract is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF"), "Test PDF is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation OriginatorEVFLender2"), "Delayed by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVFLender2"), "These are Delayed test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorEVFLender2"), "Resumed by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVFLender2"), "These are Resume test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Automation OriginatorEVFLender2"), "On Hold by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVFLender2"), "These are Place On Hold test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("In Progress by Automation OriginatorEVFLender2"), "In Progress by Automation OriginatorEVFLender2 is missing from the audit trail");
		
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
		perform.type(driver,VMPAppraisalOrderDetails.resumeNotes_txtbx(driver), "These are Resume2 test notes from OriginatorEVFLender2");
		
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
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorEVFLender2"), "Resumed by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVFLender2"), "These are Resume2 test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Automation OriginatorEVFLender2"), "Comment - Action Required by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVFLender2"), "These are Action Required test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation OriginatorEVFLender2"), "Message by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVFLender2"), "These are test Send Message notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorEVFLender2"), "Document Uploaded by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Other"), "Other is missing from the audit trail");
		Assert.assertTrue(history.contains("TestPDF.pdf"), "TestPDF.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorEVFLender2"), "Document Uploaded by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Sales Contract"), "Sales Contract is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF"), "Test PDF is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation OriginatorEVFLender2"), "Delayed by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVFLender2"), "These are Delayed test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorEVFLender2"), "Resumed by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVFLender2"), "These are Resume test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Automation OriginatorEVFLender2"), "On Hold by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVFLender2"), "These are Place On Hold test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("In Progress by Automation OriginatorEVFLender2"), "In Progress by Automation OriginatorEVFLender2 is missing from the audit trail");
		
		// Log in to Secure
		secure.login(driver, "EVFLender2", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, StoredVariables.getloanID().get(), "Tracking number");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("In Progress"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getloanID().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Verify order details
		secure.verifyResidentialAppraisalOrderDetails(driver);
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify the history
		Assert.assertTrue(history.contains("History (In Progress)"), "History (In Progress) is missing from the order information");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFLender2)"), "Resumed by Client (Automation EVFLender2) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVFLender2"), "These are Resume2 test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation EVFLender2)"), "Comment - Action Required by Client (Automation EVFLender2) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVFLender2"), "These are Action Required test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFLender2)"), "Message from Client (Automation EVFLender2) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVFLender2"), "These are test Send Message notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFLender2) (TestPDF.pdf)"), "Document Uploaded from Client (Automation EVFLender2) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFLender2) (Test PDF"), "Document Uploaded from Client (Automation EVFLender2) (Test PDF is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Client (Automation EVFLender2)"), "Delayed by Client (Automation EVFLender2) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVFLender2"), "These are Delayed test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFLender2)"), "Resumed by Client (Automation EVFLender2) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVFLender2"), "These are Resume test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Client (Automation EVFLender2)"), "On Hold by Client (Automation EVFLender2) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVFLender2"), "These are Place On Hold test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by AMC (Automation Test User)"), "Order Changed by Vendor (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(history.contains("To View Change History:"), "To View Change History: is missing from the audit trail");
		Assert.assertTrue(history.contains("Order accepted by AMC (Automation Test User) and In Progress"), "Order accepted by Vendor (Automation EVFAMC2) and In Progress is missing from the audit trail");
		Assert.assertTrue(history.contains("Order automatically accepted."), "Order automatically accepted. is missing from the audit trail");
		Assert.assertTrue(history.contains("Order automatically assigned"), "Order automatically assigned is missing from the audit trail");
		Assert.assertTrue(history.contains("Assigned to Automation Test User"), "Assigned to Automation Test User is missing from the audit trail");
		
		// Verify Other Document is in Documents
		String documentText = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Other"), "Other did not sync to Secure");
		
		// Click on Other
		perform.clickInTable_Equals(driver, "Other");
		
		// Wait for text to update
		perform.waitForText(driver, SOrderDetails.documents_txt(driver), "TestPDF.pdf");
		documentText = SOrderDetails.documents_txt(driver).getText();
		
		// Verify file name and uploaded by
		Assert.assertTrue(documentText.contains("TestPDF.pdf"), "Document name is incorrect in Documents");
		Assert.assertTrue(documentText.contains("Automation EVFLender2"), "Uploaded By is incorrect in Documents");
		
		// Verify Sales ContractDocument is in Documents
		String documentText2 = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText2.contains("Sales Contract"), "Sales Contract did not sync to Secure");
		
		// Click on Sales Contract
		perform.clickInTable_Contains(driver, "Sales Contract");
		
		// Wait for text to update
		perform.waitForText(driver, SOrderDetails.documents_txt(driver), "Test PDF");
		documentText2 = SOrderDetails.documents_txt(driver).getText();
		
		// Verify file name and uploaded by
		Assert.assertTrue(documentText2.contains("Test PDF"), "Document name is incorrect in Documents");
		Assert.assertTrue(documentText2.contains("Automation EVFLender2"), "Uploaded By is incorrect in Documents");
		
		// If browser is Firefox, skip this method
		if (StoredVariables.getbrowser().get().equals("Firefox"))
		{
			System.out.println("Skipped this method becuase the XSite functionality does not work in Firefox");
			// Log a skip in the extent report
			test.log(LogStatus.SKIP, "<span class='label info'>SKIPPED</span>", "<pre>Skipped this method becuase the XSite functionality does not work in Firefox</pre>");
		} // end if
		else
		{
		
			// View XSite order
			secure.viewXSiteOrderFromSecure(driver, "EVFAMC2", StoredVariables.getpassword().get(), StoredVariables.getloanIDAMC().get());
			
			// Get history text
			Thread.sleep(5000);
			perform.waitForElementToBeVisible(driver, XOrders.history_txt(), "id");
			history = XOrders.history_txt(driver).getText();
			String address = StoredVariables.getpropertyInformationAddress().get() + " " + StoredVariables.getpropertyInformationCity().get() + ", " + StoredVariables.getpropertyInformationStateAbbr().get() + " " + StoredVariables.getpropertyInformationZip().get();
			
			// Verify the history
			Assert.assertTrue(history.contains("History (In Progress)"), "History (In Progress) is missing from the order information");
			Assert.assertTrue(history.contains("Resumed (Automation EVFLender2)"), "Resumed (Automation EVFLender2) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVFLender2"), "These are Resume2 test notes from OriginatorEVFLender2 is missing from the audit trail");
			Assert.assertTrue(history.contains("Comment - Action Required (Automation EVFLender2)"), "Comment - Action Required (Automation EVFLender2) is missing from the order information");
			Assert.assertTrue(history.contains("Comment - Action Required for " + address), "Comment - Action Required for " + address + " is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVFLender2"), "These are Action Required test notes from OriginatorEVFLender2 is missing from the audit trail");
			Assert.assertTrue(history.contains("Message (Automation EVFLender2)"), "Message (Automation EVFLender2) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVFLender2"), "These are test Send Message notes from OriginatorEVFLender2 is missing from the audit trail");
			Assert.assertTrue(history.contains("Document Uploaded (Automation EVFLender2) (TestPDF.pdf)"), "Document Uploaded (Automation EVFLender2) (TestPDF.pdf) is missing from the audit trail");
			Assert.assertTrue(history.contains("Document Uploaded (Automation EVFLender2) (Test PDF"), "Document Uploaded (Automation EVFLender2) (Test PDF is missing from the audit trail");
			Assert.assertTrue(history.contains("Delayed (Automation EVFLender2)"), "Delayed (Automation EVFLender2) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVFLender2"), "These are Delayed test notes from OriginatorEVFLender2 is missing from the audit trail");
			Assert.assertTrue(history.contains("Resumed (Automation EVFLender2)"), "Resumed (Automation EVFLender2) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVFLender2"), "These are Resume test notes from OriginatorEVFLender2 is missing from the audit trail");
			Assert.assertTrue(history.contains("On Hold (Automation EVFLender2)"), "On Hold (Automation EVFLender2) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVFLender2"), "These are Place On Hold test notes from OriginatorEVFLender2 is missing from the audit trail");
			Assert.assertTrue(history.contains("Order Changed (Automation EVFAMC2)"), "Order Changed (Automation EVFAMC2) is missing from the audit trail");
			Assert.assertTrue(history.contains("To View Change History:"), "To View Change History: is missing from the audit trail");
			Assert.assertTrue(history.contains("In Progress (Automation EVFAMC2)"), "In Progress (Automation EVFAMC2) is missing from the audit trail");
			Assert.assertTrue(history.contains("Order automatically accepted."), "Order automatically accepted. is missing from the audit trail");
			Assert.assertTrue(history.contains("Awaiting acceptance"), "Awaiting acceptance is missing from the audit trail");
			
			// Verify order details
			perform.verifyXSiteOrderDetailsForAMC(driver);
			
			// Verify documents
			perform.waitForText(driver, XOrders.documents_txt(driver), "Other");
			String documentsText = XOrders.documents_txt(driver).getText();
			Assert.assertTrue(documentsText.contains("Other"), "Other document is missing from the documents section of the XSite - " + documentsText);
			Assert.assertTrue(documentsText.contains("TestPDF"), "TestPDF document is missing from the documents section of the XSite - " + documentsText);
			Assert.assertTrue(documentsText.contains("Sales Contract"), "Sales Contract document is missing from the documents section of the XSite - " + documentsText);
			Assert.assertTrue(documentsText.contains("Test PDF"), "Test PDF document is missing from the documents section of the XSite - " + documentsText);
			
			// Verify comments
			String comments = XOrders.comments_txt(driver).getText();
			Assert.assertTrue(comments.contains("These are edited comments by EVFAMC"), "Additional Comments section is missing info");
			
			// Close XSite order
			perform.closeNewWindow(driver);
		
		} // end else

		// Log in to Secure
		secure.login(driver, "EVFAMC2", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, StoredVariables.getloanIDAMC().get(), "Tracking number");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("Awaiting acceptance"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getloanIDAMC().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Verify order details
		secure.verifyResidentialAppraisalOrderDetails(driver);
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify the history
		Assert.assertTrue(history.contains("History (Awaiting acceptance)"), "History (Awaiting acceptance) is missing from the order information");
		Assert.assertTrue(!history.contains("Resumed by Client (Automation EVFAMC2)"), "Resumed by Client (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are Resume2 test notes from OriginatorEVFLender2"), "These are Resume2 test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(!history.contains("Comment - Action Required by Client (Automation EVFAMC2)"), "Comment - Action Required by Client (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are Action Required test notes from OriginatorEVFLender2"), "These are Action Required test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(!history.contains("Message from Client (Automation EVFAMC2)"), "Message from Client (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are test Send Message notes from OriginatorEVFLender2"), "These are test Send Message notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(!history.contains("Document Uploaded from Client (Automation EVFAMC2) (TestPDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC2) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(!history.contains("Document Uploaded from Client (Automation EVFAMC2) (Test PDF"), "Document Uploaded from Client (Automation EVFAMC2) (Test PDF is missing from the audit trail");
		Assert.assertTrue(!history.contains("Delayed by Client (Automation EVFAMC2)"), "Delayed by Client (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are Delayed test notes from OriginatorEVFLender2"), "These are Delayed test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(!history.contains("Resumed by Client (Automation EVFAMC2)"), "Resumed by Client (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are Resume test notes from OriginatorEVFLender2"), "These are Resume test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(!history.contains("On Hold by Client (Automation EVFAMC2)"), "On Hold by Client (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are Place On Hold test notes from OriginatorEVFLender2"), "These are Place On Hold test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser3"), "Awaiting acceptance by Automation Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Reassigned by Client (Automation EVFAMC2) to Automation Appraiser3"), "Reassigned by Client (Automation EVFAMC2) to Automation Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by Client (Automation EVFAMC2)"), "Order Changed by Client (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(history.contains("To View Change History:"), "To View Change History: is missing from the audit trail");
		Assert.assertTrue(history.contains("Requires assignment"), "Requires assignment is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance"), "Awaiting acceptance is missing from the audit trail");
		
		// Verify Documents aren't in Documents
		documentText = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(!documentText.contains("Other"), "Other should not sync to Secure");
		Assert.assertTrue(!documentText.contains("Sales Contract"), "Sales Contract should not sync to Secure");

		// Log in to Vendors
		vendors.login(driver, "Appraiser3", StoredVariables.getpassword().get());
		
		// Search for order
		String orderNumber = StoredVariables.getloanIDAMC().get();
		vendors.findOrder(driver, orderNumber, "Tracking Number");
		
		// Verify order status
		Assert.assertTrue(VOrders.ordersGrid_txt(driver).getText().contains("Awaiting acceptance"), "The order is not in the correct status");
		
		// Click on the order from the orders grid
		perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, VOrderDetails.orderInformation_txt(), "id");
		
		// Get order information text
		history = VOrderDetails.orderInformation_txt(driver).getText();
		
		// Verify audit trail
		Assert.assertTrue(history.contains("History (Awaiting acceptance)"), "History (Awaiting acceptance) is missing from the order information");
		Assert.assertTrue(!history.contains("Resumed by Client (Automation EVFAMC2)"), "Resumed by Client (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are Resume2 test notes from OriginatorEVFLender2"), "These are Resume2 test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(!history.contains("Comment - Action Required by Client (Automation EVFAMC2)"), "Comment - Action Required by Client (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are Action Required test notes from OriginatorEVFLender2"), "These are Action Required test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(!history.contains("Message from Client (Automation EVFAMC2)"), "Message from Client (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are test Send Message notes from OriginatorEVFLender2"), "These are test Send Message notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(!history.contains("Document Uploaded from Client (Automation EVFAMC2) (TestPDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC2) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(!history.contains("Document Uploaded from Client (Automation EVFAMC2) (Test PDF"), "Document Uploaded from Client (Automation EVFAMC2) (Test PDF is missing from the audit trail");
		Assert.assertTrue(!history.contains("Delayed by Client (Automation EVFAMC2)"), "Delayed by Client (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are Delayed test notes from OriginatorEVFLender2"), "These are Delayed test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(!history.contains("Resumed by Client (Automation EVFAMC2)"), "Resumed by Client (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are Resume test notes from OriginatorEVFLender2"), "These are Resume test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(!history.contains("On Hold by Client (Automation EVFAMC2)"), "On Hold by Client (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are Place On Hold test notes from OriginatorEVFLender2"), "These are Place On Hold test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser3"), "Awaiting acceptance by Automation Appraiser3 is missing from the audit trail");
		
		// Get comments
		additionalComments = VOrderDetails.additionalComments_txt(driver).getText();
		
		// Verify both VMP and MN comments are displayed
		Assert.assertTrue(additionalComments.contains("These are edited comments by EVFAMC"), "Additional Comments section is missing info");
		
		// View Order Details
		vendors.verifyOrderDetails(driver);
		
		// Verify Document is in Documents
		documentText = VOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(!documentText.contains("Other"), "Other should not sync to Vendors");
		Assert.assertTrue(!documentText.contains("Sales Contract"), "Sales Contract should not sync to Vendors");

		// Click Accept/Decline button
		perform.click(driver,VOrderDetails.acceptDecline_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for Select Action dropdown
		perform.waitForElementToBeClickable(driver, VOrderAcknowledgement.selectAction_dropdown(), "id");
		
		// Enter notes
		perform.type(driver,VOrderAcknowledgement.acceptAssignmentNotes_txtbx(driver), "These are Appraiser3 accepting order notes");
		
		// Click OK
		perform.click(driver,VOrderAcknowledgement.ok_btn(driver));
		
		perform.sleep(driver, 15);

		// Close Order Acknowledgement dialog
		vendors.closeOrderAcknowledgementDialog(driver);
		
		// Get order information text
		orderInformation = VOrderDetails.orderInformation_txt(driver).getText();
		
		// Wait for text
		perform.waitForText(driver, VOrderDetails.orderInformation_txt(driver), "History (In Progress)");
		
		// Verify audit trail
		Assert.assertTrue(orderInformation.contains("History (In Progress)"), "History (In Progress) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Order accepted by Appraiser (Automation Appraiser3) and In Progress"), "Order accepted by Appraiser (Automation Appraiser3) and In Progress is missing from the audit trail");
		Assert.assertTrue(orderInformation.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(!orderInformation.contains("Resumed by Client (Automation EVFAMC2)"), "Resumed by Client (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(!orderInformation.contains("These are Resume2 test notes from OriginatorEVFLender2"), "These are Resume2 test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(!orderInformation.contains("Comment - Action Required by Client (Automation EVFAMC2)"), "Comment - Action Required by Client (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(!orderInformation.contains("These are Action Required test notes from OriginatorEVFLender2"), "These are Action Required test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(!orderInformation.contains("Message from Client (Automation EVFAMC2)"), "Message from Client (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(!orderInformation.contains("These are test Send Message notes from OriginatorEVFLender2"), "These are test Send Message notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(!orderInformation.contains("Document Uploaded from Client (Automation EVFAMC2) (TestPDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC2) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(!orderInformation.contains("Delayed by Client (Automation EVFAMC2)"), "Delayed by Client (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(!orderInformation.contains("These are Delayed test notes from OriginatorEVFLender2"), "These are Delayed test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(!orderInformation.contains("Resumed by Client (Automation EVFAMC2)"), "Resumed by Client (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(!orderInformation.contains("These are Resume test notes from OriginatorEVFLender2"), "These are Resume test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(!orderInformation.contains("On Hold by Client (Automation EVFAMC2)"), "On Hold by Client (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(!orderInformation.contains("These are Place On Hold test notes from OriginatorEVFLender2"), "These are Place On Hold test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(orderInformation.contains("Awaiting acceptance by Automation Appraiser3"), "Awaiting acceptance by Automation Appraiser3 is missing from the audit trail");

		// Click Set Order Status
		perform.click(driver,VOrderDetails.setOrderStatus_btn(driver));
		
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
		perform.type(driver,VOrderDetails.inspectionScheduledNotes_txtbx(driver), "These are Inspection Scheduled notes from Appraiser3");
		
		// Click OK
		perform.click(driver,VOrderDetails.inspectionScheduledOk_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, VOrderDetails.orderInformation_txt(), "id");
		
		Thread.sleep(1000);

		// Click Set Order Status
		perform.click(driver,VOrderDetails.setOrderStatus_btn(driver));
		
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
		perform.type(driver,VOrderDetails.inspectionScheduledNotes_txtbx(driver), "These are Inspection Complete notes from Appraiser3");
		
		// Click OK
		perform.click(driver,VOrderDetails.inspectionScheduledOk_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, VOrderDetails.orderInformation_txt(), "id");
		
		Thread.sleep(1000);
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, VOrderDetails.sendMessage_btn(), "cssSelector");
		
		// Upload Other document
		perform.waitForElementToBeClickable(driver, VOrderDetails.attachDocuments_btn(), "cssSelector");
		// Click Attach Documents button
		perform.click(driver,VOrderDetails.attachDocuments_btn(driver));
		
		// Wait for message text
		perform.waitForElementToBeClickable(driver, VOrderDetails.uploadDocuments_btn(), "id");
		
		// Select document type
		perform.selectDropdownOption(driver, VOrderDetails.documentType_dropdown(driver), "Other");
		
		// Wait for upload button
		perform.waitForElementToBeClickable(driver, VOrderDetails.uploadDocuments_btn(), "id");
		
		// Upload test pdf file
		filePath = StoredVariables.getdocDir().get()+"Test PDF.pdf";
		vendors.uploadDocument(driver, filePath, orderNumber, "Other");
		
		// Click Close Button
		perform.click(driver,VOrderDetails.close_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		Thread.sleep(1500);
		
		// Verify Other is in the Order Documents pane twice
		String orderDocumentsText = VOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(orderDocumentsText.contains("Order Documents"), "Order Documents is not showing in the Order Documents");
		Assert.assertTrue(orderDocumentsText.contains("Other"), "Other is not showing in the Order Documents");
		Assert.assertTrue(!orderDocumentsText.contains("Sales Contract"), "Sales Contract is not showing in the Order Documents");
		Assert.assertTrue(orderDocumentsText.contains(StoredVariables.gettodaysDateLong().get()), "The Date Uploaded is not showing in the Order Documents");
		
		// Click Other document
		perform.clickInTable_Equals(driver, "Other");
			
		Thread.sleep(3000);
			
		orderDocumentsText = VOrderDetails.documents_txt(driver).getText();
			
		// Wait for text
		perform.waitForText(driver, VOrderDetails.documents_txt(driver), "Test PDF_1.pdf");
			
		// Verify Uploaded By and Document Name
		Assert.assertTrue(orderDocumentsText.contains("Test PDF_1.pdf"), "Test PDF_1.pdf is not showing as the Document Name in Order Documents");
		Assert.assertTrue(orderDocumentsText.contains("Automation Appraiser3"), "Automation Appraiser3 is not showing as the Document Name in Order Documents");
		
		// Get order information text
		history = VOrderDetails.orderInformation_txt(driver).getText();
		
		// Verify audit trail
		Assert.assertTrue(history.contains("History (Inspection Complete)"), "History (Inspection Complete) is missing from the order information");
		Assert.assertTrue(history.contains("Inspection Complete by Appraiser (Automation Appraiser3)"), "Inspection Complete by Appraiser (Automation Appraiser3) is missing from the order information");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Inspection Scheduled by Appraiser (Automation Appraiser3)"), "Inspection Scheduled by Appraiser (Automation Appraiser3) is missing from the order information");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(!history.contains("Resumed by Vendor (Automation Appraiser3)"), "Resumed by Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(!history.contains("Delayed by Vendor (Automation Appraiser3)"), "Delayed by Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order accepted by Appraiser (Automation Appraiser3) and In Progress"), "Order accepted by Appraiser (Automation Appraiser3) and In Progress is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(!history.contains("Resumed by Client (Automation EVFAMC2)"), "Resumed by Client (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are Resume2 test notes from OriginatorEVFLender2"), "These are Resume2 test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(!history.contains("Comment - Action Required by Client (Automation EVFAMC2)"), "Comment - Action Required by Client (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are Action Required test notes from OriginatorEVFLender2"), "These are Action Required test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(!history.contains("Message from Client (Automation EVFAMC2)"), "Message from Client (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are test Send Message notes from OriginatorEVFLender2"), "These are test Send Message notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(!history.contains("Document Uploaded from Client (Automation EVFAMC2) (TestPDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC2) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(!history.contains("Delayed by Client (Automation EVFAMC2)"), "Delayed by Client (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are Delayed test notes from OriginatorEVFLender2"), "These are Delayed test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(!history.contains("Resumed by Client (Automation EVFAMC2)"), "Resumed by Client (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are Resume test notes from OriginatorEVFLender2"), "These are Resume test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(!history.contains("On Hold by Client (Automation EVFAMC2)"), "On Hold by Client (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are Place On Hold test notes from OriginatorEVFLender2"), "These are Place On Hold test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser3"), "Awaiting acceptance by Automation Appraiser3 is missing from the audit trail");

		// Log in to Vendors
		vendors.login(driver, "Appraiser3", StoredVariables.getpassword().get());
		
		// Search for order
		vendors.findOrder(driver, StoredVariables.getloanIDAMC().get(), "Tracking Number");
		
		// Verify order status
		Assert.assertTrue(VOrders.ordersGrid_txt(driver).getText().contains("Inspection Complete"), "The order is not in the correct status");
		
		// Click on the order from the orders grid
		perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, VOrderDetails.sendMessage_btn(), "cssSelector");
		
		// Complete the order using the HTTP Post
		vendors.completeOrderByHTTPPost(driver, "Appraiser3", StoredVariables.getpassword().get(), StoredVariables.getloanIDAMC().get(), "Complete.xml");
		
		// Get order information text
		history = VOrderDetails.orderInformation_txt(driver).getText();
		
		// Verify audit trail
		Assert.assertTrue(history.contains("History (In QC - Level One)"), "History (In QC - Level One) is missing from the order information");
		Assert.assertTrue(history.contains("Order delivered by Appraiser (Automation Appraiser3) and is now In QC - Level One"), "Order delivered by Appraiser (Automation Appraiser3) and is now In QC - Level One is missing from the order information");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Test PDF_1.pdf)"), "Document Uploaded from Appraiser (Automation Appraiser3) (Test PDF_1.pdf) is missing from the order information");
		Assert.assertTrue(history.contains("Inspection Complete by Appraiser (Automation Appraiser3)"), "Inspection Complete by Appraiser (Automation Appraiser3) is missing from the order information");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Inspection Scheduled by Appraiser (Automation Appraiser3)"), "Inspection Scheduled by Appraiser (Automation Appraiser3) is missing from the order information");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(!history.contains("Resumed by Vendor (Automation Appraiser3)"), "Resumed by Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(!history.contains("Delayed by Vendor (Automation Appraiser3)"), "Delayed by Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order accepted by Appraiser (Automation Appraiser3) and In Progress"), "Order accepted by Appraiser (Automation Appraiser3) and In Progress is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(!history.contains("Resumed by Client (Automation EVFAMC2)"), "Resumed by Client (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are Resume2 test notes from OriginatorEVFLender2"), "These are Resume2 test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(!history.contains("Comment - Action Required by Client (Automation EVFAMC2)"), "Comment - Action Required by Client (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are Action Required test notes from OriginatorEVFLender2"), "These are Action Required test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(!history.contains("Message from Client (Automation EVFAMC2)"), "Message from Client (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are test Send Message notes from OriginatorEVFLender2"), "These are test Send Message notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(!history.contains("Document Uploaded from Client (Automation EVFAMC2) (TestPDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC2) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(!history.contains("Delayed by Client (Automation EVFAMC2)"), "Delayed by Client (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are Delayed test notes from OriginatorEVFLender2"), "These are Delayed test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(!history.contains("Resumed by Client (Automation EVFAMC2)"), "Resumed by Client (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are Resume test notes from OriginatorEVFLender2"), "These are Resume test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(!history.contains("On Hold by Client (Automation EVFAMC2)"), "On Hold by Client (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are Place On Hold test notes from OriginatorEVFLender2"), "These are Place On Hold test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser3"), "Awaiting acceptance by Automation Appraiser3 is missing from the audit trail");
		
		// Verify fee
		Assert.assertTrue(VOrderDetails.orderInformation_txt(driver).getText().contains("$350"), "Fee should not have updated");
		
		// Get comments
		additionalComments = VOrderDetails.additionalComments_txt(driver).getText();
		
		// Verify both VMP and MN comments are displayed
		Assert.assertTrue(additionalComments.contains("These are edited comments by EVFAMC"), "Additional Comments section is missing info");
		
		// View Order Details
		vendors.verifyOrderDetails(driver);
		
		// Verify Document is in Documents
		documentText = VOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Other"), "Other did not sync to Vendors");
		Assert.assertTrue(!documentText.contains("Sales Contract"), "Sales Contract should not sync to Vendors");
		Assert.assertTrue(documentText.contains("MISMO XML"), "MISMO XML is not showing in the Order Documents");
		Assert.assertTrue(documentText.contains("Order Documents"), "Order Documents is not showing in the Order Documents");
		Assert.assertTrue(documentText.contains("Report PDF"), "Report PDF is not showing in the Order Documents");
		Assert.assertTrue(documentText.contains("Completed Report (Current)"), "Completed Report (Current) is not showing in the Order Documents");
		Assert.assertTrue(documentText.contains(StoredVariables.gettodaysDateLong().get()), "The Date Uploaded is not showing in the Order Documents");
		
		// Click Sales Contract
		perform.clickInTable_Contains(driver, "Report PDF");
		
		// Wait for text
		perform.waitForText(driver, VOrderDetails.documents_txt(driver), "Test PDF");
		documentText = VOrderDetails.documents_txt(driver).getText();
		
		// Verify Uploaded By and Document Name
		Assert.assertTrue(documentText.contains("Test PDF"), "Test PDF is not showing as the Document Name in Order Documents");
		Assert.assertTrue(documentText.contains("Automation Appraiser3"), "Automation Appraiser3 is not showing as the Document Name in Order Documents");
		
		test = ExtentTestManager.getTest();
		
		// If browser is Firefox, skip this method
		if (StoredVariables.getbrowser().get().equals("Firefox"))
		{
			System.out.println("Skipped this method becuase the XSite functionality does not work in Firefox");
			// Log a skip in the extent report
			test.log(LogStatus.SKIP, "<span class='label info'>SKIPPED</span>", "<pre>Skipped this method becuase the XSite functionality does not work in Firefox</pre>");
		} // end if
		else
		{
			
			// View XSite order
			secure.viewXSiteOrderFromSecure(driver, "EVFLender2", StoredVariables.getpassword().get(), StoredVariables.getloanID().get());
			
			// Get history text
			perform.waitForElementToBeVisible(driver, XOrders.toolbar(), "id");
			history = XOrders.history_txt(driver).getText();
			String address = StoredVariables.getpropertyInformationAddress().get() + " " + StoredVariables.getpropertyInformationCity().get() + ", " + StoredVariables.getpropertyInformationStateAbbr().get() + " " + StoredVariables.getpropertyInformationZip().get();
			
			// Wait for db to update
			perform.waitForDBUpdateForHistoryTextInVMPXSite(driver, "These are Resume2 test notes from OriginatorEVFLender2");
			
			// Recapture the text from the history
			history = XOrders.history_txt(driver).getText();
			
			// Verify the history
			Assert.assertTrue(history.contains("History (In Progress)"), "History (In Progress) is missing from the order information");
			Assert.assertTrue(history.contains("Resumed (Automation OriginatorEVFLender2)"), "Resumed (Automation OriginatorEVFLender2) is missing from the order information");
			Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVFLender2"), "These are Resume2 test notes from OriginatorEVFLender2 is missing from the order information");
			Assert.assertTrue(history.contains("Comment - Action Required (Automation OriginatorEVFLender2)"), "Comment - Action Required (Automation OriginatorEVFLender2) is missing from the order information");
			Assert.assertTrue(history.contains("Comment - Action Required for " + address), "Comment - Action Required for " + address + " is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVFLender2"), "These are Action Required test notes from OriginatorEVFLender2 is missing from the order information");
			Assert.assertTrue(history.contains("Message (Automation OriginatorEVFLender2)"), "Message (Automation OriginatorEVFLender2) is missing from the order information");
			Assert.assertTrue(history.contains("Order message for " + address), "Order message for " + address + " is missing from the order information");
			Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVFLender2"), "These are test Send Message notes from OriginatorEVFLender2 is missing from the order information");
			Assert.assertTrue(history.contains("Document Uploaded (Automation OriginatorEVFLender2) (TestPDF.pdf)"), "Document Uploaded (Automation OriginatorEVFLender2) (TestPDF.pdf) is missing from the audit trail");
			Assert.assertTrue(history.contains("Document Uploaded (Automation OriginatorEVFLender2) (Test PDF"), "Document Uploaded (Automation OriginatorEVFLender2) (Test PDF is missing from the audit trail");
			Assert.assertTrue(history.contains("Delayed (Automation OriginatorEVFLender2)"), "Delayed (Automation OriginatorEVFLender2) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVFLender2"), "These are Delayed test notes from OriginatorEVFLender2 is missing from the audit trail");
			Assert.assertTrue(history.contains("Resumed (Automation OriginatorEVFLender2)"), "Resumed (Automation OriginatorEVFLender2) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVFLender2"), "These are Resume test notes from OriginatorEVFLender2 is missing from the audit trail");
			Assert.assertTrue(history.contains("On Hold (Automation OriginatorEVFLender2)"), "On Hold (Automation OriginatorEVFLender2) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVFLender2"), "These are Place On Hold test notes from OriginatorEVFLender2 is missing from the order information");
			Assert.assertTrue(history.contains("In Progress (Automation OriginatorEVFLender2)"), "In Progress (Automation OriginatorEVFLender2) is missing from the audit trail");
			Assert.assertTrue(!history.contains("Pending Quality Review"), "Pending Quality Review is missing from the order information");
			Assert.assertTrue(!history.contains("Inspection Complete"), "Inspection Complete is missing from the order information");
			Assert.assertTrue(!history.contains("Inspected on"), "Inspected on is missing from the order information");
			Assert.assertTrue(!history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the order information");
			Assert.assertTrue(!history.contains("Inspection Scheduled"), "Inspection Scheduled is missing from the order information");
			Assert.assertTrue(!history.contains("Inspection date is"), "Inspection date is is missing from the order information");
			Assert.assertTrue(!history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the order information");
			
			// Verify order details
			perform.verifyXSiteOrderDetailsForLender(driver);
			
			// Verify documents
			String documentsText = XOrders.documents_txt(driver).getText();
			Assert.assertTrue(documentsText.contains("Sales Contract"), "Sales Contract document is missing from the documents section of the XSite");
			Assert.assertTrue(documentsText.contains("Test PDF"), "Test PDF document is missing from the documents section of the XSite");
			Assert.assertTrue(documentsText.contains("Other"), "Other document is missing from the documents section of the XSite");
			Assert.assertTrue(documentsText.contains("TestPDF"), "TestPDF document is missing from the documents section of the XSite");
			Assert.assertTrue(!documentsText.contains("Test PDF_1"), "TestPDF document is missing from the documents section of the XSite");
			Assert.assertTrue(!documentsText.contains("Apostrophes License"), "Apostrophes License should not sync to the XSite");
			Assert.assertTrue(!documentsText.contains("Test PDF.xml"), "Test PDF.xml should not sync to the XSite");
			
			// Verify comments
			String comments = XOrders.comments_txt(driver).getText();
			Assert.assertTrue(comments.contains("These are test additional comments"), "Additional Comments section is missing info");
			
			// Verify fee
			Assert.assertTrue(XOrders.fee_txt(driver).getText().equals("$350.00"), "Fee should not update");
			
			// Close XSite order
			perform.closeNewWindow(driver);
			
		} // end else

		// Log in to VMP
		vmp.login(driver, "EVFLender2", "OriginatorEVFLender2", StoredVariables.getpassword().get());
		
		// Search for order
		vmp.findOrder(driver, StoredVariables.getloanIDVMP().get(), "Tracking #");
		
		// Verify Order Status
		Assert.assertTrue(VMPOrders.orderStatus_txt(driver).getText().equals("In Progress"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());
		
		Thread.sleep(1500);
		
		// Wait for Edit Property Contacts link
		perform.waitForElementToBeClickable(driver, VMPAppraisalOrderDetails.editPropertyContacts_lnk(), "id");
		
		// Verify the audit trail
		history = VMPAppraisalOrderDetails.history_txt(driver).getText();
		
		Assert.assertTrue(!history.contains("Pending Quality Review by Automation EVFLender2"), "Pending Quality Review by Automation EVFLender2 is missing from the audit trail");
		Assert.assertTrue(!history.contains("Inspection Complete by Automation EVFLender2"), "Inspection Complete by Automation EVFLender2 is missing from the audit trail");
		Assert.assertTrue(!history.contains("Inspected on"), "Inspected on is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(!history.contains("Inspection Scheduled by Automation EVFLender2"), "Inspection Scheduled by Automation EVFLender2 is missing from the audit trail");
		Assert.assertTrue(!history.contains("Inspection date is"), "Inspection date is is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorEVFLender2"), "Resumed by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVFLender2"), "These are Resume2 test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Automation OriginatorEVFLender2"), "Comment - Action Required by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVFLender2"), "These are Action Required test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation OriginatorEVFLender2"), "Message by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVFLender2"), "These are test Send Message notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorEVFLender2"), "Document Uploaded by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Other"), "Other is missing from the audit trail");
		Assert.assertTrue(history.contains("TestPDF.pdf"), "TestPDF.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorEVFLender2"), "Document Uploaded by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Sales Contract"), "Sales Contract is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF"), "Test PDF is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation OriginatorEVFLender2"), "Delayed by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVFLender2"), "These are Delayed test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorEVFLender2"), "Resumed by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVFLender2"), "These are Resume test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Automation OriginatorEVFLender2"), "On Hold by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVFLender2"), "These are Place On Hold test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("In Progress by Automation OriginatorEVFLender2"), "In Progress by Automation OriginatorEVFLender2 is missing from the audit trail");
		
		// Verify fee
		Assert.assertTrue(VMPAppraisalOrderDetails.orderDetails_txt(driver).getText().contains("$350"), "Fee should not update");
		
		// Verify the order details
		vmp.verifyAppraisalOrderDetails(driver);
		
		// Verify Document is in Documents
		documentText = VMPAppraisalOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Other"), "Other document is not displayed in VMP Client Portal");
		Assert.assertTrue(documentText.contains("Sales Contract"), "Sales Contract did not sync to VMP Client Portal");
		Assert.assertTrue(!documentText.contains("Market Information"), "Market Information should not sync to VMP Client Portal");
		Assert.assertTrue(!documentText.contains("Report PDF"), "Report PDF should not sync to VMP Client Portal");
		
		// Click on Sales Contract
		perform.clickInTable_Contains(driver, "Sales Contract");
		
		// Wait for text to update
		perform.waitForText(driver, VMPAppraisalOrderDetails.documents_txt(driver), "Test PDF");
		documentText = VMPAppraisalOrderDetails.documents_txt(driver).getText();
		
		// Verify file name and uploaded by
		Assert.assertTrue(documentText.contains("Test PDF"), "Document name is incorrect in Documents");
		Assert.assertTrue(documentText.contains("Automation OriginatorEVFLender2"), "Uploaded By is incorrect in Documents");
		
		// Click on Other
		perform.clickInTable_Equals(driver, "Other");
		
		// Wait for text to update
		perform.waitForText(driver, VMPAppraisalOrderDetails.documents_txt(driver), "TestPDF.pdf");
		documentText = VMPAppraisalOrderDetails.documents_txt(driver).getText();
		
		// Verify file name and uploaded by
		Assert.assertTrue(documentText.contains("TestPDF"), "Document name is incorrect in Documents");
		Assert.assertTrue(documentText.contains("Automation OriginatorEVFLender2"), "Uploaded By is incorrect in Documents");

		// Log in to Secure
		secure.login(driver, "EVFLender2", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, StoredVariables.getloanID().get(), "Tracking number");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("In Progress"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getloanID().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Verify order details
		secure.verifyResidentialAppraisalOrderDetails(driver);
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify the history
		Assert.assertTrue(history.contains("History (In Progress)"), "History (In Progress) is missing from the order information");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFLender2)"), "Resumed by Client (Automation EVFLender2) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVFLender2"), "These are Resume2 test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation EVFLender2)"), "Comment - Action Required by Client (Automation EVFLender2) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVFLender2"), "These are Action Required test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFLender2)"), "Message from Client (Automation EVFLender2) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVFLender2"), "These are test Send Message notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFLender2) (TestPDF.pdf)"), "Document Uploaded from Client (Automation EVFLender2) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFLender2) (Test PDF"), "Document Uploaded from Client (Automation EVFLender2) (Test PDF is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Client (Automation EVFLender2)"), "Delayed by Client (Automation EVFLender2) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVFLender2"), "These are Delayed test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFLender2)"), "Resumed by Client (Automation EVFLender2) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVFLender2"), "These are Resume test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Client (Automation EVFLender2)"), "On Hold by Client (Automation EVFLender2) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVFLender2"), "These are Place On Hold test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by AMC (Automation Test User)"), "Order Changed by Vendor (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(history.contains("To View Change History:"), "To View Change History: is missing from the audit trail");
		Assert.assertTrue(history.contains("Order accepted by AMC (Automation Test User) and In Progress"), "Order accepted by Vendor (Automation EVFAMC2) and In Progress is missing from the audit trail");
		Assert.assertTrue(history.contains("Order automatically accepted."), "Order automatically accepted. is missing from the audit trail");
		Assert.assertTrue(history.contains("Order automatically assigned"), "Order automatically assigned is missing from the audit trail");
		Assert.assertTrue(history.contains("Assigned to Automation Test User"), "Assigned to Automation Test User is missing from the audit trail");
		Assert.assertTrue(!history.contains("Pending Quality Review"), "Pending Quality Review is missing from the order information");
		Assert.assertTrue(!history.contains("Inspection Complete"), "Inspection Complete is missing from the order information");
		Assert.assertTrue(!history.contains("Inspected on"), "Inspected on is missing from the order information");
		Assert.assertTrue(!history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(!history.contains("Inspection Scheduled"), "Inspection Scheduled is missing from the order information");
		Assert.assertTrue(!history.contains("Inspection date is"), "Inspection date is is missing from the order information");
		Assert.assertTrue(!history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the order information");
		
		// Verify Other Document is in Documents
		documentText = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(!documentText.contains("Market Information"), "Market Information should not sync to Secure");
		Assert.assertTrue(!documentText.contains("Report PDF"), "Report PDF should not sync to Secure");
		Assert.assertTrue(documentText.contains("Other"), "Other did not sync to Secure");
		Assert.assertTrue(documentText.contains("Sales Contract"), "Sales Contract did not sync to Secure");
		
		// Verify Sales ContractDocument is in Documents
		documentText = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Sales Contract"), "Sales Contract did not sync to Secure");
		
		// Click on Sales Contract
		perform.clickInTable_Contains(driver, "Sales Contract");
		
		// Wait for text to update
		perform.waitForText(driver, SOrderDetails.documents_txt(driver), "Test PDF");
		documentText = SOrderDetails.documents_txt(driver).getText();
		
		// Verify file name and uploaded by
		Assert.assertTrue(documentText.contains("Test PDF"), "Document name is incorrect in Documents");
		Assert.assertTrue(documentText.contains("Automation EVFLender2"), "Uploaded By is incorrect in Documents");
		
		// Click on Other
		perform.clickInTable_Equals(driver, "Other");
		
		// Wait for text to update
		perform.waitForText(driver, SOrderDetails.documents_txt(driver), "TestPDF.pdf");
		documentText = SOrderDetails.documents_txt(driver).getText();
		
		// Verify file name and uploaded by
		Assert.assertTrue(documentText.contains("TestPDF.pdf"), "Document name is incorrect in Documents");
		Assert.assertTrue(documentText.contains("Automation EVFLender2"), "Uploaded By is incorrect in Documents");

		test = ExtentTestManager.getTest();
		
		// If browser is Firefox, skip this method
		if (StoredVariables.getbrowser().get().equals("Firefox"))
		{
			System.out.println("Skipped this method becuase the XSite functionality does not work in Firefox");
			// Log a skip in the extent report
			test.log(LogStatus.SKIP, "<span class='label info'>SKIPPED</span>", "<pre>Skipped this method becuase the XSite functionality does not work in Firefox</pre>");
		} // end if
		else
		{
		
			// View XSite order
			secure.viewXSiteOrderFromSecure(driver, "EVFAMC2", StoredVariables.getpassword().get(), StoredVariables.getloanIDAMC().get());
			
			// Get history text
			Thread.sleep(2000);
			perform.waitForElementToBeVisible(driver, XOrders.history_txt(), "id");
			history = XOrders.history_txt(driver).getText();
			String address = StoredVariables.getpropertyInformationAddress().get() + " " + StoredVariables.getpropertyInformationCity().get() + ", " + StoredVariables.getpropertyInformationStateAbbr().get() + " " + StoredVariables.getpropertyInformationZip().get();
			
			// Verify the history
			Assert.assertTrue(history.contains("History (In Progress)"), "History (In Progress) is missing from the order information");
			Assert.assertTrue(history.contains("Resumed (Automation EVFLender2)"), "Resumed (Automation EVFLender2) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVFLender2"), "These are Resume2 test notes from OriginatorEVFLender2 is missing from the audit trail");
			Assert.assertTrue(history.contains("Comment - Action Required (Automation EVFLender2)"), "Comment - Action Required (Automation EVFLender2) is missing from the order information");
			Assert.assertTrue(history.contains("Comment - Action Required for " + address), "Comment - Action Required for " + address + " is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVFLender2"), "These are Action Required test notes from OriginatorEVFLender2 is missing from the audit trail");
			Assert.assertTrue(history.contains("Message (Automation EVFLender2)"), "Message (Automation EVFLender2) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVFLender2"), "These are test Send Message notes from OriginatorEVFLender2 is missing from the audit trail");
			Assert.assertTrue(history.contains("Document Uploaded (Automation EVFLender2) (TestPDF.pdf)"), "Document Uploaded (Automation EVFLender2) (TestPDF.pdf) is missing from the audit trail");
			Assert.assertTrue(history.contains("Document Uploaded (Automation EVFLender2) (Test PDF"), "Document Uploaded (Automation EVFLender2) (Test PDF is missing from the audit trail");
			Assert.assertTrue(history.contains("Delayed (Automation EVFLender2)"), "Delayed (Automation EVFLender2) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVFLender2"), "These are Delayed test notes from OriginatorEVFLender2 is missing from the audit trail");
			Assert.assertTrue(history.contains("Resumed (Automation EVFLender2)"), "Resumed (Automation EVFLender2) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVFLender2"), "These are Resume test notes from OriginatorEVFLender2 is missing from the audit trail");
			Assert.assertTrue(history.contains("On Hold (Automation EVFLender2)"), "On Hold (Automation EVFLender2) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVFLender2"), "These are Place On Hold test notes from OriginatorEVFLender2 is missing from the audit trail");
			Assert.assertTrue(history.contains("Order Changed (Automation EVFAMC2)"), "Order Changed (Automation EVFAMC2) is missing from the audit trail");
			Assert.assertTrue(history.contains("To View Change History:"), "To View Change History: is missing from the audit trail");
			Assert.assertTrue(history.contains("In Progress (Automation EVFAMC2)"), "In Progress (Automation EVFAMC2) is missing from the audit trail");
			Assert.assertTrue(history.contains("Order automatically accepted."), "Order automatically accepted. is missing from the audit trail");
			Assert.assertTrue(history.contains("Awaiting acceptance"), "Awaiting acceptance is missing from the audit trail");
			Assert.assertTrue(!history.contains("Pending Quality Review"), "Pending Quality Review is missing from the order information");
			Assert.assertTrue(!history.contains("Inspection Complete"), "Inspection Complete is missing from the order information");
			Assert.assertTrue(!history.contains("Inspected on"), "Inspected on is missing from the order information");
			Assert.assertTrue(!history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the order information");
			Assert.assertTrue(!history.contains("Inspection Scheduled"), "Inspection Scheduled is missing from the order information");
			Assert.assertTrue(!history.contains("Inspection date is"), "Inspection date is is missing from the order information");
			Assert.assertTrue(!history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the order information");
			
			// Verify order details
			perform.verifyXSiteOrderDetailsForAMC(driver);
			
			// Verify documents
			perform.waitForText(driver, XOrders.documents_txt(driver), "Other");
			String documentsText = XOrders.documents_txt(driver).getText();
			Assert.assertTrue(documentsText.contains("Other"), "Other document is missing from the documents section of the XSite - " + documentsText);
			Assert.assertTrue(documentsText.contains("TestPDF"), "TestPDF document is missing from the documents section of the XSite - " + documentsText);
			Assert.assertTrue(documentsText.contains("Sales Contract"), "Sales Contract document is missing from the documents section of the XSite - " + documentsText);
			Assert.assertTrue(documentsText.contains("Test PDF"), "Test PDF document is missing from the documents section of the XSite - " + documentsText);
			
			// Verify comments
			String comments = XOrders.comments_txt(driver).getText();
			Assert.assertTrue(comments.contains("These are edited comments by EVFAMC"), "Additional Comments section is missing info");
			
			// Close XSite order
			perform.closeNewWindow(driver);
		
		} // end else
		
		// Log in to Vendors
		vendors.login(driver, "Appraiser3", StoredVariables.getpassword().get());
		
		// Search for order
		vendors.findOrder(driver, StoredVariables.getloanIDAMC().get(), "Tracking Number");
		
		// Verify order status
		Assert.assertTrue(VOrders.ordersGrid_txt(driver).getText().contains("In QC - Level One"), "The order is not in the correct status");
		
		// Click on the order from the orders grid
		perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, VOrderDetails.orderInformation_txt(), "id");
		
		// Get order information text
		history = VOrderDetails.orderInformation_txt(driver).getText();
		
		// Verify audit trail
		Assert.assertTrue(history.contains("History (In QC - Level One)"), "History (In QC - Level One) is missing from the order information");
		Assert.assertTrue(history.contains("Order delivered by Appraiser (Automation Appraiser3) and is now In QC - Level One"), "Order delivered by Appraiser (Automation Appraiser3) and is now In QC - Level One is missing from the order information");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Test PDF_1.pdf)"), "Document Uploaded from Appraiser (Automation Appraiser3) (Test PDF_1.pdf) is missing from the order information");
		Assert.assertTrue(history.contains("Inspection Complete by Appraiser (Automation Appraiser3)"), "Inspection Complete by Appraiser (Automation Appraiser3) is missing from the order information");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Inspection Scheduled by Appraiser (Automation Appraiser3)"), "Inspection Scheduled by Appraiser (Automation Appraiser3) is missing from the order information");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(!history.contains("Resumed by Vendor (Automation Appraiser3)"), "Resumed by Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(!history.contains("Delayed by Vendor (Automation Appraiser3)"), "Delayed by Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order accepted by Appraiser (Automation Appraiser3) and In Progress"), "Order accepted by Appraiser (Automation Appraiser3) and In Progress is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(!history.contains("Resumed by Client (Automation EVFAMC2)"), "Resumed by Client (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are Resume2 test notes from OriginatorEVFLender2"), "These are Resume2 test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(!history.contains("Comment - Action Required by Client (Automation EVFAMC2)"), "Comment - Action Required by Client (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are Action Required test notes from OriginatorEVFLender2"), "These are Action Required test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(!history.contains("Message from Client (Automation EVFAMC2)"), "Message from Client (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are test Send Message notes from OriginatorEVFLender2"), "These are test Send Message notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(!history.contains("Document Uploaded from Client (Automation EVFAMC2) (TestPDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC2) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(!history.contains("Delayed by Client (Automation EVFAMC2)"), "Delayed by Client (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are Delayed test notes from OriginatorEVFLender2"), "These are Delayed test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(!history.contains("Resumed by Client (Automation EVFAMC2)"), "Resumed by Client (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are Resume test notes from OriginatorEVFLender2"), "These are Resume test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(!history.contains("On Hold by Client (Automation EVFAMC2)"), "On Hold by Client (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are Place On Hold test notes from OriginatorEVFLender2"), "These are Place On Hold test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser3"), "Awaiting acceptance by Automation Appraiser3 is missing from the audit trail");
		
		// Verify fee
		Assert.assertTrue(VOrderDetails.orderInformation_txt(driver).getText().contains("$350"), "Fee should not have updated");
		
		// Get comments
		additionalComments = VOrderDetails.additionalComments_txt(driver).getText();
		
		// Verify both VMP and MN comments are displayed
		Assert.assertTrue(additionalComments.contains("These are edited comments by EVFAMC"), "Additional Comments section is missing info");
		
		// View Order Details
		vendors.verifyOrderDetails(driver);
		
		// Verify Document is in Documents
		documentText = VOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Other"), "Other did not sync to Vendors");
		Assert.assertTrue(!documentText.contains("Sales Contract"), "Sales Contract should not sync to Vendors");
		Assert.assertTrue(documentText.contains("Order Documents"), "Order Documents is not showing in the Order Documents");
		Assert.assertTrue(documentText.contains("Report PDF"), "Report PDF is not showing in the Order Documents");
		Assert.assertTrue(documentText.contains("Completed Report (Current)"), "Completed Report (Current) is not showing in the Order Documents");
		Assert.assertTrue(documentText.contains(StoredVariables.gettodaysDateLong().get()), "The Date Uploaded is not showing in the Order Documents");
		
		// Click Sales Contract
		perform.clickInTable_Contains(driver, "Report PDF");
		
		// Wait for text
		perform.waitForText(driver, VOrderDetails.documents_txt(driver), "Test PDF");
		documentText = VOrderDetails.documents_txt(driver).getText();
		
		// Verify Uploaded By and Document Name
		Assert.assertTrue(documentText.contains("Test PDF"), "Test PDF is not showing as the Document Name in Order Documents");
		Assert.assertTrue(documentText.contains("Automation Appraiser3"), "Automation Appraiser3 is not showing as the Document Name in Order Documents");

		// Log in to Secure
		secure.login(driver, "EVFAMC2", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, StoredVariables.getloanIDAMC().get(), "Tracking number");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("In QC - Level One"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getloanIDAMC().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Verify order details
		secure.verifyResidentialAppraisalOrderDetails(driver);
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify the history
		Assert.assertTrue(history.contains("History (In QC - Level One)"), "History (In QC - Level One) is missing from the order information");
		Assert.assertTrue(history.contains("Order delivered by Appraiser (Automation Appraiser3) and is now In QC - Level One"), "Order delivered by Vendor (Automation Appraiser3) and is now In QC - Level One is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Test PDF_1.pdf)"), "Document Uploaded from Vendor (Automation Appraiser3) (Test PDF_1.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Complete by Appraiser (Automation Appraiser3)"), "Inspection Complete by Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Scheduled by Appraiser (Automation Appraiser3)"), "Inspection Scheduled by Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection date"), "Inspection date is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order accepted by Appraiser (Automation Appraiser3) and In Progress"), "Order accepted by Vendor (Automation Appraiser3) and In Progress is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser3"), "Awaiting acceptance by Automation Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Reassigned by Client (Automation EVFAMC2) to Automation Appraiser3"), "Reassigned by Client (Automation EVFAMC2) to Automation Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by Client (Automation EVFAMC2)"), "Order Changed by Client (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(history.contains("To View Change History:"), "To View Change History: is missing from the audit trail");
		Assert.assertTrue(history.contains("Requires assignment"), "Requires assignment is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance"), "Awaiting acceptance is missing from the audit trail");
		
		// Verify Documents aren't in Documents
		documentText = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Other"), "Other did not sync to Secure");
		Assert.assertTrue(documentText.contains("Report PDF"), "Report PDF did not sync to Secure");
		Assert.assertTrue(!documentText.contains("Sales Contract"), "Sales Contract should not sync to Secure");
		
		// Submit to UCDP
		secure.submitToUCDP(driver, "Fannie Mae", "a la mode", "", "These are internal notes from EVFAMC on Secure", true);
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify the history
		Assert.assertTrue(history.contains("History (In QC - Level One)"), "History (In QC - Level One) is missing from the order information");
		Assert.assertTrue(history.contains("UCDP Document File ID Updated by Client (Automation EVFAMC2)"), "UCDP Document File ID Updated by Client (Automation EVFAMC2) is missing from the order information");
		Assert.assertTrue(history.contains("Note Added (Automation EVFAMC2)"), "Note Added (Automation EVFAMC2) is missing from the order information");
		Assert.assertTrue(history.contains("These are internal notes from EVFAMC on Secure"), "These are internal notes from EVFAMC on Secure is missing from the order information");
		Assert.assertTrue(history.contains("Order delivered by Appraiser (Automation Appraiser3) and is now In QC - Level One"), "Order delivered by Vendor (Automation Appraiser3) and is now In QC - Level One is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Test PDF_1.pdf)"), "Document Uploaded from Vendor (Automation Appraiser3) (Test PDF_1.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Complete by Appraiser (Automation Appraiser3)"), "Inspection Complete by Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Scheduled by Appraiser (Automation Appraiser3)"), "Inspection Scheduled by Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection date"), "Inspection date is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order accepted by Appraiser (Automation Appraiser3) and In Progress"), "Order accepted by Vendor (Automation Appraiser3) and In Progress is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser3"), "Awaiting acceptance by Automation Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Reassigned by Client (Automation EVFAMC2) to Automation Appraiser3"), "Reassigned by Client (Automation EVFAMC2) to Automation Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by Client (Automation EVFAMC2)"), "Order Changed by Client (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(history.contains("To View Change History:"), "To View Change History: is missing from the audit trail");
		Assert.assertTrue(history.contains("Requires assignment"), "Requires assignment is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance"), "Awaiting acceptance is missing from the audit trail");
		
		// Verify fee
		Assert.assertTrue(SOrderDetails.assignmentInformation_txt(driver).getText().contains("350"), "Fee is incorrect");
		
		// Verify Other Document is in Documents
		documentText = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Report PDF"), "Report PDF did not sync to Secure");
		Assert.assertTrue(documentText.contains("Other"), "Other did not sync to Secure");
		Assert.assertTrue(!documentText.contains("Sales Contract"), "Sales Contract should not sync to Secure");
		
		// Wait for View FNM SSR to display in the history
		secure.waitForHistoryTextToUpdate(driver, "View FNM SSR");
		
		// Get the new history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify SSR is in the history
		Assert.assertTrue(history.contains("Appraisal Submission to FNM Not Successful"), "Appraisal Submission to FNM Not Successful is missing from the order information");
		Assert.assertTrue(history.contains("View FNM SSR"), "View FNM SSR is missing from the order information");
		
		// Verify FNM SSR is in the Documents
		documentText = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("FNM SSR"), "FNM SSR did not sync to Secure");
		
		test = ExtentTestManager.getTest();
		
		// If browser is Firefox, skip this method
		if (StoredVariables.getbrowser().get().equals("Firefox"))
		{
			System.out.println("Skipped this method becuase the XSite functionality does not work in Firefox");
			// Log a skip in the extent report
			test.log(LogStatus.SKIP, "<span class='label info'>SKIPPED</span>", "<pre>Skipped this method becuase the XSite functionality does not work in Firefox</pre>");
		} // end if
		else
		{
			
			// View XSite order
			secure.viewXSiteOrderFromSecure(driver, "EVFLender2", StoredVariables.getpassword().get(), StoredVariables.getloanID().get());
			
			// Get history text
			perform.waitForElementToBeVisible(driver, XOrders.toolbar(), "id");
			history = XOrders.history_txt(driver).getText();
			String address = StoredVariables.getpropertyInformationAddress().get() + " " + StoredVariables.getpropertyInformationCity().get() + ", " + StoredVariables.getpropertyInformationStateAbbr().get() + " " + StoredVariables.getpropertyInformationZip().get();
			
			// Recapture the text from the history
			history = XOrders.history_txt(driver).getText();
			
			// Verify the history
			Assert.assertTrue(history.contains("History (In Progress)"), "History (In Progress) is missing from the order information");
			Assert.assertTrue(history.contains("Appraisal Submitted to FNM via UCDP"), "Appraisal Submitted to FNM via UCDP is missing from the order information");
			Assert.assertTrue(history.contains("Resumed (Automation OriginatorEVFLender2)"), "Resumed (Automation OriginatorEVFLender2) is missing from the order information");
			Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVFLender2"), "These are Resume2 test notes from OriginatorEVFLender2 is missing from the order information");
			Assert.assertTrue(history.contains("Comment - Action Required (Automation OriginatorEVFLender2)"), "Comment - Action Required (Automation OriginatorEVFLender2) is missing from the order information");
			Assert.assertTrue(history.contains("Comment - Action Required for " + address), "Comment - Action Required for " + address + " is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVFLender2"), "These are Action Required test notes from OriginatorEVFLender2 is missing from the order information");
			Assert.assertTrue(history.contains("Message (Automation OriginatorEVFLender2)"), "Message (Automation OriginatorEVFLender2) is missing from the order information");
			Assert.assertTrue(history.contains("Order message for " + address), "Order message for " + address + " is missing from the order information");
			Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVFLender2"), "These are test Send Message notes from OriginatorEVFLender2 is missing from the order information");
			Assert.assertTrue(history.contains("Document Uploaded (Automation OriginatorEVFLender2) (TestPDF.pdf)"), "Document Uploaded (Automation OriginatorEVFLender2) (TestPDF.pdf) is missing from the audit trail");
			Assert.assertTrue(history.contains("Document Uploaded (Automation OriginatorEVFLender2) (Test PDF"), "Document Uploaded (Automation OriginatorEVFLender2) (Test PDF is missing from the audit trail");
			Assert.assertTrue(history.contains("Delayed (Automation OriginatorEVFLender2)"), "Delayed (Automation OriginatorEVFLender2) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVFLender2"), "These are Delayed test notes from OriginatorEVFLender2 is missing from the audit trail");
			Assert.assertTrue(history.contains("Resumed (Automation OriginatorEVFLender2)"), "Resumed (Automation OriginatorEVFLender2) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVFLender2"), "These are Resume test notes from OriginatorEVFLender2 is missing from the audit trail");
			Assert.assertTrue(history.contains("On Hold (Automation OriginatorEVFLender2)"), "On Hold (Automation OriginatorEVFLender2) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVFLender2"), "These are Place On Hold test notes from OriginatorEVFLender2 is missing from the order information");
			Assert.assertTrue(history.contains("In Progress (Automation OriginatorEVFLender2)"), "In Progress (Automation OriginatorEVFLender2) is missing from the audit trail");
			Assert.assertTrue(!history.contains("Pending Quality Review"), "Pending Quality Review is missing from the order information");
			Assert.assertTrue(!history.contains("Inspection Complete"), "Inspection Complete is missing from the order information");
			Assert.assertTrue(!history.contains("Inspected on"), "Inspected on is missing from the order information");
			Assert.assertTrue(!history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the order information");
			Assert.assertTrue(!history.contains("Inspection Scheduled"), "Inspection Scheduled is missing from the order information");
			Assert.assertTrue(!history.contains("Inspection date is"), "Inspection date is is missing from the order information");
			Assert.assertTrue(!history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the order information");
			
			// Verify order details
			perform.verifyXSiteOrderDetailsForLender(driver);
			
			// Verify documents
			String documentsText = XOrders.documents_txt(driver).getText();
			Assert.assertTrue(documentsText.contains("Sales Contract"), "Sales Contract document is missing from the documents section of the XSite");
			Assert.assertTrue(documentsText.contains("Test PDF"), "Test PDF document is missing from the documents section of the XSite");
			Assert.assertTrue(documentsText.contains("Other"), "Other document is missing from the documents section of the XSite");
			Assert.assertTrue(documentsText.contains("TestPDF"), "TestPDF document is missing from the documents section of the XSite");
			Assert.assertTrue(!documentsText.contains("Test PDF_1"), "TestPDF document is missing from the documents section of the XSite");
			Assert.assertTrue(!documentsText.contains("Apostrophes License"), "Apostrophes License should not sync to the XSite");
			Assert.assertTrue(!documentsText.contains("Test PDF.xml"), "Test PDF.xml should not sync to the XSite");
			
			// Verify comments
			String comments = XOrders.comments_txt(driver).getText();
			Assert.assertTrue(comments.contains("These are test additional comments"), "Additional Comments section is missing info");
			
			// Verify fee
			Assert.assertTrue(XOrders.fee_txt(driver).getText().equals("$350.00"), "Fee should not update");
			
			// Verify SSR is not in the history
			Assert.assertTrue(!history.contains("View FNM SSR"), "View FNM SSR is missing from the order information");
			
			// Verify FNM SSR is not in the Documents
			Assert.assertTrue(!documentsText.contains("FNM SSR"), "FNM SSR did not sync to Secure");
			
			// Close XSite order
			perform.closeNewWindow(driver);
			
		} // end else

		// Log in to VMP
		vmp.login(driver, "EVFLender2", "OriginatorEVFLender2", StoredVariables.getpassword().get());
		
		// Search for order
		vmp.findOrder(driver, StoredVariables.getloanIDVMP().get(), "Tracking #");
		
		// Verify Order Status
		Assert.assertTrue(VMPOrders.orderStatus_txt(driver).getText().equals("In Progress"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());
		
		Thread.sleep(1500);
		
		// Wait for Edit Property Contacts link
		perform.waitForElementToBeClickable(driver, VMPAppraisalOrderDetails.editPropertyContacts_lnk(), "id");
		
		// Verify the audit trail
		history = VMPAppraisalOrderDetails.history_txt(driver).getText();
		
		Assert.assertTrue(!history.contains("Pending Quality Review by Automation EVFLender2"), "Pending Quality Review by Automation EVFLender2 is missing from the audit trail");
		Assert.assertTrue(!history.contains("Inspection Complete by Automation EVFLender2"), "Inspection Complete by Automation EVFLender2 is missing from the audit trail");
		Assert.assertTrue(!history.contains("Inspected on"), "Inspected on is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(!history.contains("Inspection Scheduled by Automation EVFLender2"), "Inspection Scheduled by Automation EVFLender2 is missing from the audit trail");
		Assert.assertTrue(!history.contains("Inspection date is"), "Inspection date is is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraisal Submitted to FNM via UCDP by Automation EVFLender2"), "Appraisal Submitted to FNM via UCDP by Automation EVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorEVFLender2"), "Resumed by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVFLender2"), "These are Resume2 test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Automation OriginatorEVFLender2"), "Comment - Action Required by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVFLender2"), "These are Action Required test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation OriginatorEVFLender2"), "Message by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVFLender2"), "These are test Send Message notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorEVFLender2"), "Document Uploaded by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Other"), "Other is missing from the audit trail");
		Assert.assertTrue(history.contains("TestPDF.pdf"), "TestPDF.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorEVFLender2"), "Document Uploaded by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Sales Contract"), "Sales Contract is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF"), "Test PDF is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation OriginatorEVFLender2"), "Delayed by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVFLender2"), "These are Delayed test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorEVFLender2"), "Resumed by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVFLender2"), "These are Resume test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Automation OriginatorEVFLender2"), "On Hold by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVFLender2"), "These are Place On Hold test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("In Progress by Automation OriginatorEVFLender2"), "In Progress by Automation OriginatorEVFLender2 is missing from the audit trail");
		
		// Verify fee
		Assert.assertTrue(VMPAppraisalOrderDetails.orderDetails_txt(driver).getText().contains("$350"), "Fee should not update");
		
		// Verify the order details
		vmp.verifyAppraisalOrderDetails(driver);
		
		// Verify Document is in Documents
		documentText = VMPAppraisalOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Other"), "Other document is not displayed in VMP Client Portal");
		Assert.assertTrue(documentText.contains("Sales Contract"), "Sales Contract did not sync to VMP Client Portal");
		Assert.assertTrue(!documentText.contains("Market Information"), "Market Information should not sync to VMP Client Portal");
		Assert.assertTrue(!documentText.contains("Report PDF"), "Report PDF should not sync to VMP Client Portal");
		
		// Verify SSR is not in the history
		Assert.assertTrue(!history.contains("View FNM SSR"), "View FNM SSR is missing from the order information");
		
		// Verify FNM SSR is not in the Documents
		Assert.assertTrue(!documentText.contains("FNM SSR"), "FNM SSR did not sync to Secure");
		
		// Click on Sales Contract
		perform.clickInTable_Contains(driver, "Sales Contract");
		
		// Wait for text to update
		perform.waitForText(driver, VMPAppraisalOrderDetails.documents_txt(driver), "Test PDF");
		documentText = VMPAppraisalOrderDetails.documents_txt(driver).getText();
		
		// Verify file name and uploaded by
		Assert.assertTrue(documentText.contains("Test PDF"), "Document name is incorrect in Documents");
		Assert.assertTrue(documentText.contains("Automation OriginatorEVFLender2"), "Uploaded By is incorrect in Documents");
		
		// Click on Other
		perform.clickInTable_Equals(driver, "Other");
		
		// Wait for text to update
		perform.waitForText(driver, VMPAppraisalOrderDetails.documents_txt(driver), "TestPDF.pdf");
		documentText = VMPAppraisalOrderDetails.documents_txt(driver).getText();
		
		// Verify file name and uploaded by
		Assert.assertTrue(documentText.contains("TestPDF.pdf"), "Document name is incorrect in Documents");
		Assert.assertTrue(documentText.contains("Automation OriginatorEVFLender2"), "Uploaded By is incorrect in Documents");
		
		// Log in to Secure
		secure.login(driver, "EVFLender2", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, StoredVariables.getloanID().get(), "Tracking number");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("In Progress"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getloanID().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Verify order details
		secure.verifyResidentialAppraisalOrderDetails(driver);
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify the history
		Assert.assertTrue(history.contains("History (In Progress)"), "History (In Progress) is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Submitted to FNM via UCDP by AMC (Automation Test User)"), "Appraisal Submitted to FNM via UCDP by Vendor (Automation EVFAMC2) is missing from the order information");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFLender2)"), "Resumed by Client (Automation EVFLender2) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVFLender2"), "These are Resume2 test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation EVFLender2)"), "Comment - Action Required by Client (Automation EVFLender2) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVFLender2"), "These are Action Required test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFLender2)"), "Message from Client (Automation EVFLender2) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVFLender2"), "These are test Send Message notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFLender2) (TestPDF.pdf)"), "Document Uploaded from Client (Automation EVFLender2) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFLender2) (Test PDF"), "Document Uploaded from Client (Automation EVFLender2) (Test PDF is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Client (Automation EVFLender2)"), "Delayed by Client (Automation EVFLender2) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVFLender2"), "These are Delayed test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFLender2)"), "Resumed by Client (Automation EVFLender2) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVFLender2"), "These are Resume test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Client (Automation EVFLender2)"), "On Hold by Client (Automation EVFLender2) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVFLender2"), "These are Place On Hold test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by AMC (Automation Test User)"), "Order Changed by Vendor (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(history.contains("To View Change History:"), "To View Change History: is missing from the audit trail");
		Assert.assertTrue(history.contains("Order accepted by AMC (Automation Test User) and In Progress"), "Order accepted by Vendor (Automation EVFAMC2) and In Progress is missing from the audit trail");
		Assert.assertTrue(history.contains("Order automatically accepted."), "Order automatically accepted. is missing from the audit trail");
		Assert.assertTrue(history.contains("Order automatically assigned"), "Order automatically assigned is missing from the audit trail");
		Assert.assertTrue(history.contains("Assigned to Automation Test User"), "Assigned to Automation Test User is missing from the audit trail");
		Assert.assertTrue(!history.contains("Pending Quality Review"), "Pending Quality Review is missing from the order information");
		Assert.assertTrue(!history.contains("Inspection Complete"), "Inspection Complete is missing from the order information");
		Assert.assertTrue(!history.contains("Inspected on"), "Inspected on is missing from the order information");
		Assert.assertTrue(!history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(!history.contains("Inspection Scheduled"), "Inspection Scheduled is missing from the order information");
		Assert.assertTrue(!history.contains("Inspection date is"), "Inspection date is is missing from the order information");
		Assert.assertTrue(!history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the order information");
		
		// Verify Other Document is in Documents
		documentText = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(!documentText.contains("Market Information"), "Market Information should not sync to Secure");
		Assert.assertTrue(!documentText.contains("Report PDF"), "Report PDF should not sync to Secure");
		Assert.assertTrue(documentText.contains("Other"), "Other did not sync to Secure");
		Assert.assertTrue(documentText.contains("Sales Contract"), "Sales Contract did not sync to Secure");
		
		// Verify SSR is not in the history
		Assert.assertTrue(!history.contains("View FNM SSR"), "View FNM SSR is missing from the order information");
		
		// Verify FNM SSR is not in the Documents
		Assert.assertTrue(!documentText.contains("FNM SSR"), "FNM SSR did not sync to Secure");
		
		// Verify Sales ContractDocument is in Documents
		documentText = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Sales Contract"), "Sales Contract did not sync to Secure");
		
		// Click on Sales Contract
		perform.clickInTable_Contains(driver, "Sales Contract");
		
		// Wait for text to update
		perform.waitForText(driver, SOrderDetails.documents_txt(driver), "Test PDF");
		documentText = SOrderDetails.documents_txt(driver).getText();
		
		// Verify file name and uploaded by
		Assert.assertTrue(documentText.contains("Test PDF"), "Document name is incorrect in Documents");
		Assert.assertTrue(documentText.contains("Automation EVFLender2"), "Uploaded By is incorrect in Documents");
		
		// Click on Other
		perform.clickInTable_Equals(driver, "Other");
		
		// Wait for text to update
		perform.waitForText(driver, SOrderDetails.documents_txt(driver), "TestPDF.pdf");
		documentText = SOrderDetails.documents_txt(driver).getText();
		
		// Verify file name and uploaded by
		Assert.assertTrue(documentText.contains("TestPDF.pdf"), "Document name is incorrect in Documents");
		Assert.assertTrue(documentText.contains("Automation EVFLender2"), "Uploaded By is incorrect in Documents");
		
		test = ExtentTestManager.getTest();
		
		// If browser is Firefox, skip this method
		if (StoredVariables.getbrowser().get().equals("Firefox"))
		{
			System.out.println("Skipped this method becuase the XSite functionality does not work in Firefox");
			// Log a skip in the extent report
			test.log(LogStatus.SKIP, "<span class='label info'>SKIPPED</span>", "<pre>Skipped this method becuase the XSite functionality does not work in Firefox</pre>");
		} // end if
		else
		{
			
			// View XSite order
			secure.viewXSiteOrderFromSecure(driver, "EVFAMC2", StoredVariables.getpassword().get(), StoredVariables.getloanIDAMC().get());
			
			// Get history text
			perform.waitForElementToBeVisible(driver, XOrders.toolbar(), "id");
			history = XOrders.history_txt(driver).getText();
			String address = StoredVariables.getpropertyInformationAddress().get() + " " + StoredVariables.getpropertyInformationCity().get() + ", " + StoredVariables.getpropertyInformationStateAbbr().get() + " " + StoredVariables.getpropertyInformationZip().get();
			
			// Verify the history
			Assert.assertTrue(history.contains("History (In Progress)"), "History (In Progress) is missing from the order information");
			Assert.assertTrue(history.contains("Appraisal Submitted to FNM via UCDP"), "Appraisal Submitted to FNM via UCDP is missing from the order information");
			Assert.assertTrue(history.contains("Resumed (Automation EVFLender2)"), "Resumed (Automation EVFLender2) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVFLender2"), "These are Resume2 test notes from OriginatorEVFLender2 is missing from the audit trail");
			Assert.assertTrue(history.contains("Comment - Action Required (Automation EVFLender2)"), "Comment - Action Required (Automation EVFLender2) is missing from the order information");
			Assert.assertTrue(history.contains("Comment - Action Required for " + address), "Comment - Action Required for " + address + " is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVFLender2"), "These are Action Required test notes from OriginatorEVFLender2 is missing from the audit trail");
			Assert.assertTrue(history.contains("Message (Automation EVFLender2)"), "Message (Automation EVFLender2) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVFLender2"), "These are test Send Message notes from OriginatorEVFLender2 is missing from the audit trail");
			Assert.assertTrue(history.contains("Document Uploaded (Automation EVFLender2) (TestPDF.pdf)"), "Document Uploaded (Automation EVFLender2) (TestPDF.pdf) is missing from the audit trail");
			Assert.assertTrue(history.contains("Document Uploaded (Automation EVFLender2) (Test PDF"), "Document Uploaded (Automation EVFLender2) (Test PDF is missing from the audit trail");
			Assert.assertTrue(history.contains("Delayed (Automation EVFLender2)"), "Delayed (Automation EVFLender2) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVFLender2"), "These are Delayed test notes from OriginatorEVFLender2 is missing from the audit trail");
			Assert.assertTrue(history.contains("Resumed (Automation EVFLender2)"), "Resumed (Automation EVFLender2) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVFLender2"), "These are Resume test notes from OriginatorEVFLender2 is missing from the audit trail");
			Assert.assertTrue(history.contains("On Hold (Automation EVFLender2)"), "On Hold (Automation EVFLender2) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVFLender2"), "These are Place On Hold test notes from OriginatorEVFLender2 is missing from the audit trail");
			Assert.assertTrue(history.contains("Order Changed (Automation EVFAMC2)"), "Order Changed (Automation EVFAMC2) is missing from the audit trail");
			Assert.assertTrue(history.contains("To View Change History:"), "To View Change History: is missing from the audit trail");
			Assert.assertTrue(history.contains("In Progress (Automation EVFAMC2)"), "In Progress (Automation EVFAMC2) is missing from the audit trail");
			Assert.assertTrue(history.contains("Order automatically accepted."), "Order automatically accepted. is missing from the audit trail");
			Assert.assertTrue(history.contains("Awaiting acceptance"), "Awaiting acceptance is missing from the audit trail");
			Assert.assertTrue(!history.contains("Pending Quality Review"), "Pending Quality Review is missing from the order information");
			Assert.assertTrue(!history.contains("Inspection Complete"), "Inspection Complete is missing from the order information");
			Assert.assertTrue(!history.contains("Inspected on"), "Inspected on is missing from the order information");
			Assert.assertTrue(!history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the order information");
			Assert.assertTrue(!history.contains("Inspection Scheduled"), "Inspection Scheduled is missing from the order information");
			Assert.assertTrue(!history.contains("Inspection date is"), "Inspection date is is missing from the order information");
			Assert.assertTrue(!history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the order information");
			
			// Verify order details
			perform.verifyXSiteOrderDetailsForAMC(driver);
			
			// Verify documents
			perform.waitForText(driver, XOrders.documents_txt(driver), "Other");
			String documentsText = XOrders.documents_txt(driver).getText();
			Assert.assertTrue(documentsText.contains("Other"), "Other document is missing from the documents section of the XSite - " + documentsText);
			Assert.assertTrue(documentsText.contains("TestPDF"), "TestPDF document is missing from the documents section of the XSite - " + documentsText);
			Assert.assertTrue(documentsText.contains("Sales Contract"), "Sales Contract document is missing from the documents section of the XSite - " + documentsText);
			Assert.assertTrue(documentsText.contains("Test PDF"), "Test PDF document is missing from the documents section of the XSite - " + documentsText);
			
			// Verify SSR is not in the history
			Assert.assertTrue(!history.contains("View FNM SSR"), "View FNM SSR is missing from the order information");
			
			// Verify FNM SSR is not in the Documents
			Assert.assertTrue(!documentsText.contains("FNM SSR"), "FNM SSR did not sync to Secure");
			
			// Verify comments
			String comments = XOrders.comments_txt(driver).getText();
			Assert.assertTrue(comments.contains("These are edited comments by EVFAMC"), "Additional Comments section is missing info");
			
			// Close XSite order
			perform.closeNewWindow(driver);
			
		} // end else
		
		// Log in to Secure
		secure.login(driver, "EVFAMC2", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, StoredVariables.getloanIDAMC().get(), "Tracking number");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("Appraisal Submission to FNM Not Successful"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getloanIDAMC().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Verify order details
		secure.verifyResidentialAppraisalOrderDetails(driver);
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify the history
		Assert.assertTrue(history.contains("History (In QC - Level One)"), "History (In QC - Level One) is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Submission to FNM Not Successful"), "Appraisal Submission to FNM Not Successful is missing from the order information");
		Assert.assertTrue(history.contains("View FNM SSR"), "View FNM SSR is missing from the order information");
		Assert.assertTrue(history.contains("UCDP Document File ID Updated by Client (Automation EVFAMC2)"), "UCDP Document File ID Updated by Client (Automation EVFAMC2) is missing from the order information");
		Assert.assertTrue(history.contains("Note Added (Automation EVFAMC2)"), "Note Added (Automation EVFAMC2) is missing from the order information");
		Assert.assertTrue(history.contains("These are internal notes from EVFAMC on Secure"), "These are internal notes from EVFAMC on Secure is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Submitted to FNM via UCDP by Client (Automation EVFAMC2)"), "Appraisal Submitted to FNM via UCDP by Client (Automation EVFAMC2) is missing from the order information");
		Assert.assertTrue(history.contains("Order delivered by Appraiser (Automation Appraiser3) and is now In QC - Level One"), "Order delivered by Vendor (Automation Appraiser3) and is now In QC - Level One is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Test PDF_1.pdf)"), "Document Uploaded from Vendor (Automation Appraiser3) (Test PDF_1.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Complete by Appraiser (Automation Appraiser3)"), "Inspection Complete by Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Scheduled by Appraiser (Automation Appraiser3)"), "Inspection Scheduled by Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection date"), "Inspection date is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order accepted by Appraiser (Automation Appraiser3) and In Progress"), "Order accepted by Vendor (Automation Appraiser3) and In Progress is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser3"), "Awaiting acceptance by Automation Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Reassigned by Client (Automation EVFAMC2) to Automation Appraiser3"), "Reassigned by Client (Automation EVFAMC2) to Automation Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by Client (Automation EVFAMC2)"), "Order Changed by Client (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(history.contains("To View Change History:"), "To View Change History: is missing from the audit trail");
		Assert.assertTrue(history.contains("Requires assignment"), "Requires assignment is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance"), "Awaiting acceptance is missing from the audit trail");
		
		// Verify Documents aren't in Documents
		documentText = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Other"), "Other did not sync to Secure");
		Assert.assertTrue(documentText.contains("Report PDF"), "Report PDF did not sync to Secure");
		Assert.assertTrue(!documentText.contains("Sales Contract"), "Sales Contract should not sync to Secure");
		Assert.assertTrue(documentText.contains("FNM SSR"), "FNM SSR did not sync to Secure");

		// Log in to Vendors
		vendors.login(driver, "Appraiser3", StoredVariables.getpassword().get());
		
		// Search for order
		vendors.findOrder(driver, StoredVariables.getloanIDAMC().get(), "Tracking Number");
		
		// Verify order status
		Assert.assertTrue(VOrders.ordersGrid_txt(driver).getText().contains("In QC - Level One"), "The order is not in the correct status");
		
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
		perform.type(driver,VOrderDetails.sendMessageNotes_txtbx(driver), "These are some more Message notes from Appraiser3");
		
		// Click Send button
		perform.click(driver,VOrderDetails.sendMessageOk_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		Thread.sleep(1000);
		
		// Get order information text
		history = VOrderDetails.orderInformation_txt(driver).getText();
		
		// Verify audit trail
		Assert.assertTrue(history.contains("History (In QC - Level One)"), "History (In QC - Level One) is missing from the order information");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser3)"), "Message from Appraiser (Automation Appraiser3) is missing from the order information");
		Assert.assertTrue(history.contains("These are some more Message notes from Appraiser3"), "These are some more Message notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Order delivered by Appraiser (Automation Appraiser3) and is now In QC - Level One"), "Order delivered by Appraiser (Automation Appraiser3) and is now In QC - Level One is missing from the order information");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Test PDF_1.pdf)"), "Document Uploaded from Appraiser (Automation Appraiser3) (Test PDF_1.pdf) is missing from the order information");
		Assert.assertTrue(history.contains("Inspection Complete by Appraiser (Automation Appraiser3)"), "Inspection Complete by Appraiser (Automation Appraiser3) is missing from the order information");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Inspection Scheduled by Appraiser (Automation Appraiser3)"), "Inspection Scheduled by Appraiser (Automation Appraiser3) is missing from the order information");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(!history.contains("Resumed by Vendor (Automation Appraiser3)"), "Resumed by Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(!history.contains("Delayed by Vendor (Automation Appraiser3)"), "Delayed by Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order accepted by Appraiser (Automation Appraiser3) and In Progress"), "Order accepted by Appraiser (Automation Appraiser3) and In Progress is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(!history.contains("Resumed by Client (Automation EVFAMC2)"), "Resumed by Client (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are Resume2 test notes from OriginatorEVFLender2"), "These are Resume2 test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(!history.contains("Comment - Action Required by Client (Automation EVFAMC2)"), "Comment - Action Required by Client (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are Action Required test notes from OriginatorEVFLender2"), "These are Action Required test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(!history.contains("Message from Client (Automation EVFAMC2)"), "Message from Client (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are test Send Message notes from OriginatorEVFLender2"), "These are test Send Message notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(!history.contains("Document Uploaded from Client (Automation EVFAMC2) (TestPDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC2) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(!history.contains("Delayed by Client (Automation EVFAMC2)"), "Delayed by Client (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are Delayed test notes from OriginatorEVFLender2"), "These are Delayed test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(!history.contains("Resumed by Client (Automation EVFAMC2)"), "Resumed by Client (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are Resume test notes from OriginatorEVFLender2"), "These are Resume test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(!history.contains("On Hold by Client (Automation EVFAMC2)"), "On Hold by Client (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are Place On Hold test notes from OriginatorEVFLender2"), "These are Place On Hold test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser3"), "Awaiting acceptance by Automation Appraiser3 is missing from the audit trail");
		
		// Verify fee
		Assert.assertTrue(VOrderDetails.orderInformation_txt(driver).getText().contains("$350"), "Fee should not have updated");
		
		// Get comments
		additionalComments = VOrderDetails.additionalComments_txt(driver).getText();
		
		// Verify both VMP and MN comments are displayed
		Assert.assertTrue(additionalComments.contains("These are edited comments by EVFAMC"), "Additional Comments section is missing info");
		
		// View Order Details
		vendors.verifyOrderDetails(driver);
		
		// Verify Document is in Documents
		documentText = VOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Other"), "Other did not sync to Vendors");
		Assert.assertTrue(!documentText.contains("Sales Contract"), "Sales Contract should not sync to Vendors");
		Assert.assertTrue(documentText.contains("Order Documents"), "Order Documents is not showing in the Order Documents");
		Assert.assertTrue(documentText.contains("Report PDF"), "Report PDF is not showing in the Order Documents");
		Assert.assertTrue(documentText.contains("Completed Report (Current)"), "Completed Report (Current) is not showing in the Order Documents");
		Assert.assertTrue(documentText.contains(StoredVariables.gettodaysDateLong().get()), "The Date Uploaded is not showing in the Order Documents");
		
		// Click Sales Contract
		perform.clickInTable_Contains(driver, "Report PDF");
		
		// Wait for text
		perform.waitForText(driver, VOrderDetails.documents_txt(driver), "Test PDF");
		documentText = VOrderDetails.documents_txt(driver).getText();
		
		// Verify Uploaded By and Document Name
		Assert.assertTrue(documentText.contains("Test PDF"), "Test PDF is not showing as the Document Name in Order Documents");
		Assert.assertTrue(documentText.contains("Automation Appraiser3"), "Automation Appraiser3 is not showing as the Document Name in Order Documents");
		
		// Log in to Secure
		secure.login(driver, "EVFAMC2", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, StoredVariables.getloanIDAMC().get(), "Tracking number");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("Appraisal Submission to FNM Not Successful"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getloanIDAMC().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Click Sync to VMP button
		perform.clickInTable_Contains(driver, "Sync to VMP");
		
		// Wait for Notes textbox
		perform.waitForElementToBeClickable(driver, SSyncToVMP.message_txtbx(), "id");
		
		// Verify message text
		Assert.assertTrue(SSyncToVMP.message_txtbx(driver).getAttribute("value").equals("These are some more Message notes from Appraiser3"), "The text in the message is not correct");
		
		// Check Action Required checkbox
		if (!SSyncToVMP.actionRequired_chkbx(driver).isSelected())
		{
			perform.click(driver,SSyncToVMP.actionRequired_chkbx(driver));
		}
		
		// Click OK
		perform.click(driver,SSyncToVMP.ok_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);

		test = ExtentTestManager.getTest();
		
		// If browser is Firefox, skip this method
		if (StoredVariables.getbrowser().get().equals("Firefox"))
		{
			System.out.println("Skipped this method becuase the XSite functionality does not work in Firefox");
			// Log a skip in the extent report
			test.log(LogStatus.SKIP, "<span class='label info'>SKIPPED</span>", "<pre>Skipped this method becuase the XSite functionality does not work in Firefox</pre>");
		} // end if
		else
		{
			
			// View XSite order
			secure.viewXSiteOrderFromSecure(driver, "EVFLender2", StoredVariables.getpassword().get(), StoredVariables.getloanID().get());
			
			// Get history text
			perform.waitForElementToBeVisible(driver, XOrders.toolbar(), "id");
			history = XOrders.history_txt(driver).getText();
			String address = StoredVariables.getpropertyInformationAddress().get() + " " + StoredVariables.getpropertyInformationCity().get() + ", " + StoredVariables.getpropertyInformationStateAbbr().get() + " " + StoredVariables.getpropertyInformationZip().get();
			
			// Wait for db to update
			perform.waitForDBUpdateForHistoryTextInVMPXSite(driver, "These are some more Message notes from Appraiser3");
			
			// Recapture the text from the history
			history = XOrders.history_txt(driver).getText();
			
			// Verify the history
			Assert.assertTrue(history.contains("History (In Progress)"), "History (In Progress) is missing from the order information");
			
			Assert.assertTrue(history.contains("Comment - Action Required (Automation EVFLender2)"), "Comment - Action Required (Automation EVFLender2) is missing from the order information");
			Assert.assertTrue(history.contains("These are some more Message notes from Appraiser3"), "These are some more Message notes from Appraiser3 is missing from the order information");
			Assert.assertTrue(history.contains("Appraisal Submitted to FNM via UCDP"), "Appraisal Submitted to FNM via UCDP is missing from the order information");
			Assert.assertTrue(history.contains("Resumed (Automation OriginatorEVFLender2)"), "Resumed (Automation OriginatorEVFLender2) is missing from the order information");
			Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVFLender2"), "These are Resume2 test notes from OriginatorEVFLender2 is missing from the order information");
			Assert.assertTrue(history.contains("Comment - Action Required (Automation OriginatorEVFLender2)"), "Comment - Action Required (Automation OriginatorEVFLender2) is missing from the order information");
			Assert.assertTrue(history.contains("Comment - Action Required for " + address), "Comment - Action Required for " + address + " is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVFLender2"), "These are Action Required test notes from OriginatorEVFLender2 is missing from the order information");
			Assert.assertTrue(history.contains("Message (Automation OriginatorEVFLender2)"), "Message (Automation OriginatorEVFLender2) is missing from the order information");
			Assert.assertTrue(history.contains("Order message for " + address), "Order message for " + address + " is missing from the order information");
			Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVFLender2"), "These are test Send Message notes from OriginatorEVFLender2 is missing from the order information");
			Assert.assertTrue(history.contains("Document Uploaded (Automation OriginatorEVFLender2) (TestPDF.pdf)"), "Document Uploaded (Automation OriginatorEVFLender2) (TestPDF.pdf) is missing from the audit trail");
			Assert.assertTrue(history.contains("Document Uploaded (Automation OriginatorEVFLender2) (Test PDF"), "Document Uploaded (Automation OriginatorEVFLender2) (Test PDF is missing from the audit trail");
			Assert.assertTrue(history.contains("Delayed (Automation OriginatorEVFLender2)"), "Delayed (Automation OriginatorEVFLender2) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVFLender2"), "These are Delayed test notes from OriginatorEVFLender2 is missing from the audit trail");
			Assert.assertTrue(history.contains("Resumed (Automation OriginatorEVFLender2)"), "Resumed (Automation OriginatorEVFLender2) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVFLender2"), "These are Resume test notes from OriginatorEVFLender2 is missing from the audit trail");
			Assert.assertTrue(history.contains("On Hold (Automation OriginatorEVFLender2)"), "On Hold (Automation OriginatorEVFLender2) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVFLender2"), "These are Place On Hold test notes from OriginatorEVFLender2 is missing from the order information");
			Assert.assertTrue(history.contains("In Progress (Automation OriginatorEVFLender2)"), "In Progress (Automation OriginatorEVFLender2) is missing from the audit trail");
			Assert.assertTrue(!history.contains("Pending Quality Review"), "Pending Quality Review is missing from the order information");
			Assert.assertTrue(!history.contains("Inspection Complete"), "Inspection Complete is missing from the order information");
			Assert.assertTrue(!history.contains("Inspected on"), "Inspected on is missing from the order information");
			Assert.assertTrue(!history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the order information");
			Assert.assertTrue(!history.contains("Inspection Scheduled"), "Inspection Scheduled is missing from the order information");
			Assert.assertTrue(!history.contains("Inspection date is"), "Inspection date is is missing from the order information");
			Assert.assertTrue(!history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the order information");
			
			// Verify order details
			perform.verifyXSiteOrderDetailsForLender(driver);
			
			// Verify documents
			String documentsText = XOrders.documents_txt(driver).getText();
			Assert.assertTrue(documentsText.contains("Sales Contract"), "Sales Contract document is missing from the documents section of the XSite");
			Assert.assertTrue(documentsText.contains("Test PDF"), "Test PDF document is missing from the documents section of the XSite");
			Assert.assertTrue(documentsText.contains("Other"), "Other document is missing from the documents section of the XSite");
			Assert.assertTrue(documentsText.contains("TestPDF"), "TestPDF document is missing from the documents section of the XSite");
			Assert.assertTrue(!documentsText.contains("Test PDF_1"), "TestPDF document is missing from the documents section of the XSite");
			Assert.assertTrue(!documentsText.contains("Apostrophes License"), "Apostrophes License should not sync to the XSite");
			Assert.assertTrue(!documentsText.contains("Test PDF.xml"), "Test PDF.xml should not sync to the XSite");
			
			// Verify comments
			String comments = XOrders.comments_txt(driver).getText();
			Assert.assertTrue(comments.contains("These are test additional comments"), "Additional Comments section is missing info");
			
			// Verify fee
			Assert.assertTrue(XOrders.fee_txt(driver).getText().equals("$350.00"), "Fee should not update");
			
			// Verify SSR is not in the history
			Assert.assertTrue(!history.contains("View FNM SSR"), "View FNM SSR is missing from the order information");
			
			// Verify FNM SSR is not in the Documents
			Assert.assertTrue(!documentsText.contains("FNM SSR"), "FNM SSR did not sync to Secure");
			
			// Close XSite order
			perform.closeNewWindow(driver);
			
		} // end else
		
		// Log in to VMP
		vmp.login(driver, "EVFLender2", "OriginatorEVFLender2", StoredVariables.getpassword().get());
		
		// Search for order
		vmp.findOrder(driver, StoredVariables.getloanIDVMP().get(), "Tracking #");
		
		// Verify Order Status
		Assert.assertTrue(VMPOrders.orderStatus_txt(driver).getText().equals("In Progress"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());
		
		Thread.sleep(1500);
		
		// Wait for Edit Property Contacts link
		perform.waitForElementToBeClickable(driver, VMPAppraisalOrderDetails.editPropertyContacts_lnk(), "id");
		
		// Wait for db to update
		vmp.waitForDBUpdateForHistory(driver, "These are some more Message notes from Appraiser3");
		
		// Recapture history text
		history = VMPAppraisalOrderDetails.history_txt(driver).getText();
		
		Assert.assertTrue(history.contains("Comment - Action Required by Automation EVFLender2"), "Comment - Action Required by Automation EVFLender2 is missing from the order information");
		Assert.assertTrue(history.contains("These are some more Message notes from Appraiser3"), "These are some more Message notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(!history.contains("Pending Quality Review by Automation EVFLender2"), "Pending Quality Review by Automation EVFLender2 is missing from the audit trail");
		Assert.assertTrue(!history.contains("Inspection Complete by Automation EVFLender2"), "Inspection Complete by Automation EVFLender2 is missing from the audit trail");
		Assert.assertTrue(!history.contains("Inspected on"), "Inspected on is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(!history.contains("Inspection Scheduled by Automation EVFLender2"), "Inspection Scheduled by Automation EVFLender2 is missing from the audit trail");
		Assert.assertTrue(!history.contains("Inspection date is"), "Inspection date is is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraisal Submitted to FNM via UCDP by Automation EVFLender2"), "Appraisal Submitted to FNM via UCDP by Automation EVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorEVFLender2"), "Resumed by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVFLender2"), "These are Resume2 test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Automation OriginatorEVFLender2"), "Comment - Action Required by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVFLender2"), "These are Action Required test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation OriginatorEVFLender2"), "Message by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVFLender2"), "These are test Send Message notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorEVFLender2"), "Document Uploaded by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Other"), "Other is missing from the audit trail");
		Assert.assertTrue(history.contains("TestPDF.pdf"), "TestPDF.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorEVFLender2"), "Document Uploaded by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Sales Contract"), "Sales Contract is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF"), "Test PDF is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation OriginatorEVFLender2"), "Delayed by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVFLender2"), "These are Delayed test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorEVFLender2"), "Resumed by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVFLender2"), "These are Resume test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Automation OriginatorEVFLender2"), "On Hold by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVFLender2"), "These are Place On Hold test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("In Progress by Automation OriginatorEVFLender2"), "In Progress by Automation OriginatorEVFLender2 is missing from the audit trail");
		
		// Verify fee
		Assert.assertTrue(VMPAppraisalOrderDetails.orderDetails_txt(driver).getText().contains("$350"), "Fee should not update");
		
		// Verify the order details
		vmp.verifyAppraisalOrderDetails(driver);
		
		// Verify Document is in Documents
		documentText = VMPAppraisalOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Other"), "Other document is not displayed in VMP Client Portal");
		Assert.assertTrue(documentText.contains("Sales Contract"), "Sales Contract did not sync to VMP Client Portal");
		Assert.assertTrue(!documentText.contains("Market Information"), "Market Information should not sync to VMP Client Portal");
		Assert.assertTrue(!documentText.contains("Report PDF"), "Report PDF should not sync to VMP Client Portal");
		
		// Verify SSR is not in the history
		Assert.assertTrue(!history.contains("View FNM SSR"), "View FNM SSR is missing from the order information");
		
		// Verify FNM SSR is not in the Documents
		Assert.assertTrue(!documentText.contains("FNM SSR"), "FNM SSR did not sync to Secure");
		
		// Click on Sales Contract
		perform.clickInTable_Contains(driver, "Sales Contract");
		
		// Wait for text to update
		perform.waitForText(driver, VMPAppraisalOrderDetails.documents_txt(driver), "Test PDF");
		documentText = VMPAppraisalOrderDetails.documents_txt(driver).getText();
		
		// Verify file name and uploaded by
		Assert.assertTrue(documentText.contains("Test PDF"), "Document name is incorrect in Documents");
		Assert.assertTrue(documentText.contains("Automation OriginatorEVFLender2"), "Uploaded By is incorrect in Documents");
		
		// Click on Other
		perform.clickInTable_Equals(driver, "Other");
		
		// Wait for text to update
		perform.waitForText(driver, VMPAppraisalOrderDetails.documents_txt(driver), "TestPDF.pdf");
		documentText = VMPAppraisalOrderDetails.documents_txt(driver).getText();
		
		// Verify file name and uploaded by
		Assert.assertTrue(documentText.contains("TestPDF.pdf"), "Document name is incorrect in Documents");
		Assert.assertTrue(documentText.contains("Automation OriginatorEVFLender2"), "Uploaded By is incorrect in Documents");
		
		// Log in to Secure
		secure.login(driver, "EVFLender2", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, StoredVariables.getloanID().get(), "Tracking number");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("In Progress"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getloanID().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Verify order details
		secure.verifyResidentialAppraisalOrderDetails(driver);
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify the history
		Assert.assertTrue(history.contains("History (In Progress)"), "History (In Progress) is missing from the order information");
		Assert.assertTrue(history.contains("Comment - Action Required by AMC (Automation Test User)"), "Comment - Action Required by Vendor (Automation EVFAMC2) is missing from the order information");
		Assert.assertTrue(history.contains("These are some more Message notes from Appraiser3"), "These are some more Message notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Submitted to FNM via UCDP by AMC (Automation Test User)"), "Appraisal Submitted to FNM via UCDP by Vendor (Automation EVFAMC2) is missing from the order information");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFLender2)"), "Resumed by Client (Automation EVFLender2) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVFLender2"), "These are Resume2 test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation EVFLender2)"), "Comment - Action Required by Client (Automation EVFLender2) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVFLender2"), "These are Action Required test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFLender2)"), "Message from Client (Automation EVFLender2) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVFLender2"), "These are test Send Message notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFLender2) (TestPDF.pdf)"), "Document Uploaded from Client (Automation EVFLender2) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFLender2) (Test PDF"), "Document Uploaded from Client (Automation EVFLender2) (Test PDF is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Client (Automation EVFLender2)"), "Delayed by Client (Automation EVFLender2) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVFLender2"), "These are Delayed test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFLender2)"), "Resumed by Client (Automation EVFLender2) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVFLender2"), "These are Resume test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Client (Automation EVFLender2)"), "On Hold by Client (Automation EVFLender2) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVFLender2"), "These are Place On Hold test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by AMC (Automation Test User)"), "Order Changed by Vendor (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(history.contains("To View Change History:"), "To View Change History: is missing from the audit trail");
		Assert.assertTrue(history.contains("Order accepted by AMC (Automation Test User) and In Progress"), "Order accepted by Vendor (Automation EVFAMC2) and In Progress is missing from the audit trail");
		Assert.assertTrue(history.contains("Order automatically accepted."), "Order automatically accepted. is missing from the audit trail");
		Assert.assertTrue(history.contains("Order automatically assigned"), "Order automatically assigned is missing from the audit trail");
		Assert.assertTrue(history.contains("Assigned to Automation Test User"), "Assigned to Automation Test User is missing from the audit trail");
		Assert.assertTrue(!history.contains("Pending Quality Review"), "Pending Quality Review is missing from the order information");
		Assert.assertTrue(!history.contains("Inspection Complete"), "Inspection Complete is missing from the order information");
		Assert.assertTrue(!history.contains("Inspected on"), "Inspected on is missing from the order information");
		Assert.assertTrue(!history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(!history.contains("Inspection Scheduled"), "Inspection Scheduled is missing from the order information");
		Assert.assertTrue(!history.contains("Inspection date is"), "Inspection date is is missing from the order information");
		Assert.assertTrue(!history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the order information");
		
		// Verify Other Document is in Documents
		documentText = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(!documentText.contains("Market Information"), "Market Information should not sync to Secure");
		Assert.assertTrue(!documentText.contains("Report PDF"), "Report PDF should not sync to Secure");
		Assert.assertTrue(documentText.contains("Other"), "Other did not sync to Secure");
		Assert.assertTrue(documentText.contains("Sales Contract"), "Sales Contract did not sync to Secure");
		
		// Verify SSR is not in the history
		Assert.assertTrue(!history.contains("View FNM SSR"), "View FNM SSR is missing from the order information");
		
		// Verify FNM SSR is not in the Documents
		Assert.assertTrue(!documentText.contains("FNM SSR"), "FNM SSR did not sync to Secure");
		
		// Verify Sales ContractDocument is in Documents
		documentText = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Sales Contract"), "Sales Contract did not sync to Secure");
		
		// Click on Sales Contract
		perform.clickInTable_Contains(driver, "Sales Contract");
		
		// Wait for text to update
		perform.waitForText(driver, SOrderDetails.documents_txt(driver), "Test PDF");
		documentText = SOrderDetails.documents_txt(driver).getText();
		
		// Verify file name and uploaded by
		Assert.assertTrue(documentText.contains("Test PDF"), "Document name is incorrect in Documents");
		Assert.assertTrue(documentText.contains("Automation EVFLender2"), "Uploaded By is incorrect in Documents");
		
		// Click on Other
		perform.clickInTable_Equals(driver, "Other");
		
		// Wait for text to update
		perform.waitForText(driver, SOrderDetails.documents_txt(driver), "TestPDF.pdf");
		documentText = SOrderDetails.documents_txt(driver).getText();
		
		// Verify file name and uploaded by
		Assert.assertTrue(documentText.contains("TestPDF.pdf"), "Document name is incorrect in Documents");
		Assert.assertTrue(documentText.contains("Automation EVFLender2"), "Uploaded By is incorrect in Documents");
		
		test = ExtentTestManager.getTest();
		
		// If browser is Firefox, skip this method
		if (StoredVariables.getbrowser().get().equals("Firefox"))
		{
			System.out.println("Skipped this method becuase the XSite functionality does not work in Firefox");
			// Log a skip in the extent report
			test.log(LogStatus.SKIP, "<span class='label info'>SKIPPED</span>", "<pre>Skipped this method becuase the XSite functionality does not work in Firefox</pre>");
		} // end if
		else
		{
			
			// View XSite order
			secure.viewXSiteOrderFromSecure(driver, "EVFAMC2", StoredVariables.getpassword().get(), StoredVariables.getloanIDAMC().get());
			
			// Get history text
			perform.waitForElementToBeVisible(driver, XOrders.toolbar(), "id");
			history = XOrders.history_txt(driver).getText();
			String address = StoredVariables.getpropertyInformationAddress().get() + " " + StoredVariables.getpropertyInformationCity().get() + ", " + StoredVariables.getpropertyInformationStateAbbr().get() + " " + StoredVariables.getpropertyInformationZip().get();
			
			// Verify the history
			Assert.assertTrue(history.contains("History (In Progress)"), "History (In Progress) is missing from the order information");
			Assert.assertTrue(history.contains("Comment - Action Required (Automation EVFAMC2)"), "Comment - Action Required (Automation EVFAMC2) is missing from the order information");
			Assert.assertTrue(history.contains("These are some more Message notes from Appraiser3"), "These are some more Message notes from Appraiser3 is missing from the order information");
			Assert.assertTrue(history.contains("Appraisal Submitted to FNM via UCDP"), "Appraisal Submitted to FNM via UCDP is missing from the order information");
			Assert.assertTrue(history.contains("Resumed (Automation EVFLender2)"), "Resumed (Automation EVFLender2) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVFLender2"), "These are Resume2 test notes from OriginatorEVFLender2 is missing from the audit trail");
			Assert.assertTrue(history.contains("Comment - Action Required (Automation EVFLender2)"), "Comment - Action Required (Automation EVFLender2) is missing from the order information");
			Assert.assertTrue(history.contains("Comment - Action Required for " + address), "Comment - Action Required for " + address + " is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVFLender2"), "These are Action Required test notes from OriginatorEVFLender2 is missing from the audit trail");
			Assert.assertTrue(history.contains("Message (Automation EVFLender2)"), "Message (Automation EVFLender2) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVFLender2"), "These are test Send Message notes from OriginatorEVFLender2 is missing from the audit trail");
			Assert.assertTrue(history.contains("Document Uploaded (Automation EVFLender2) (TestPDF.pdf)"), "Document Uploaded (Automation EVFLender2) (TestPDF.pdf) is missing from the audit trail");
			Assert.assertTrue(history.contains("Document Uploaded (Automation EVFLender2) (Test PDF"), "Document Uploaded (Automation EVFLender2) (Test PDF is missing from the audit trail");
			Assert.assertTrue(history.contains("Delayed (Automation EVFLender2)"), "Delayed (Automation EVFLender2) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVFLender2"), "These are Delayed test notes from OriginatorEVFLender2 is missing from the audit trail");
			Assert.assertTrue(history.contains("Resumed (Automation EVFLender2)"), "Resumed (Automation EVFLender2) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVFLender2"), "These are Resume test notes from OriginatorEVFLender2 is missing from the audit trail");
			Assert.assertTrue(history.contains("On Hold (Automation EVFLender2)"), "On Hold (Automation EVFLender2) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVFLender2"), "These are Place On Hold test notes from OriginatorEVFLender2 is missing from the audit trail");
			Assert.assertTrue(history.contains("Order Changed (Automation EVFAMC2)"), "Order Changed (Automation EVFAMC2) is missing from the audit trail");
			Assert.assertTrue(history.contains("To View Change History:"), "To View Change History: is missing from the audit trail");
			Assert.assertTrue(history.contains("In Progress (Automation EVFAMC2)"), "In Progress (Automation EVFAMC2) is missing from the audit trail");
			Assert.assertTrue(history.contains("Order automatically accepted."), "Order automatically accepted. is missing from the audit trail");
			Assert.assertTrue(history.contains("Awaiting acceptance"), "Awaiting acceptance is missing from the audit trail");
			Assert.assertTrue(!history.contains("Pending Quality Review"), "Pending Quality Review is missing from the order information");
			Assert.assertTrue(!history.contains("Inspection Complete"), "Inspection Complete is missing from the order information");
			Assert.assertTrue(!history.contains("Inspected on"), "Inspected on is missing from the order information");
			Assert.assertTrue(!history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the order information");
			Assert.assertTrue(!history.contains("Inspection Scheduled"), "Inspection Scheduled is missing from the order information");
			Assert.assertTrue(!history.contains("Inspection date is"), "Inspection date is is missing from the order information");
			Assert.assertTrue(!history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the order information");
			
			// Verify order details
			perform.verifyXSiteOrderDetailsForAMC(driver);
			
			// Verify documents
			perform.waitForText(driver, XOrders.documents_txt(driver), "Other");
			String documentsText = XOrders.documents_txt(driver).getText();
			Assert.assertTrue(documentsText.contains("Other"), "Other document is missing from the documents section of the XSite - " + documentsText);
			Assert.assertTrue(documentsText.contains("TestPDF"), "TestPDF document is missing from the documents section of the XSite - " + documentsText);
			Assert.assertTrue(documentsText.contains("Sales Contract"), "Sales Contract document is missing from the documents section of the XSite - " + documentsText);
			Assert.assertTrue(documentsText.contains("Test PDF"), "Test PDF document is missing from the documents section of the XSite - " + documentsText);
			
			// Verify SSR is not in the history
			Assert.assertTrue(!history.contains("View FNM SSR"), "View FNM SSR is missing from the order information");
			
			// Verify FNM SSR is not in the Documents
			Assert.assertTrue(!documentsText.contains("FNM SSR"), "FNM SSR did not sync to Secure");
			
			// Verify comments
			String comments = XOrders.comments_txt(driver).getText();
			Assert.assertTrue(comments.contains("These are edited comments by EVFAMC"), "Additional Comments section is missing info");
			
			// Close XSite order
			perform.closeNewWindow(driver);
			
		} // end else

		// Log in to Secure
		secure.login(driver, "EVFAMC2", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, StoredVariables.getloanIDAMC().get(), "Tracking number");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("Appraisal Submission to FNM Not Successful"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getloanIDAMC().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Verify order details
		secure.verifyResidentialAppraisalOrderDetails(driver);
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify the history
		Assert.assertTrue(history.contains("History (In QC - Level One)"), "History (In QC - Level One) is missing from the order information");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser3)"), "Message from Vendor (Automation Appraiser3) is missing from the order information");
		Assert.assertTrue(history.contains("These are some more Message notes from Appraiser3"), "These are some more Message notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Submission to FNM Not Successful"), "Appraisal Submission to FNM Not Successful is missing from the order information");
		Assert.assertTrue(history.contains("View FNM SSR"), "View FNM SSR is missing from the order information");
		Assert.assertTrue(history.contains("UCDP Document File ID Updated by Client (Automation EVFAMC2)"), "UCDP Document File ID Updated by Client (Automation EVFAMC2) is missing from the order information");
		Assert.assertTrue(history.contains("Note Added (Automation EVFAMC2)"), "Note Added (Automation EVFAMC2) is missing from the order information");
		Assert.assertTrue(history.contains("These are internal notes from EVFAMC on Secure"), "These are internal notes from EVFAMC on Secure is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Submitted to FNM via UCDP by Client (Automation EVFAMC2)"), "Appraisal Submitted to FNM via UCDP by Client (Automation EVFAMC2) is missing from the order information");
		Assert.assertTrue(history.contains("Order delivered by Appraiser (Automation Appraiser3) and is now In QC - Level One"), "Order delivered by Vendor (Automation Appraiser3) and is now In QC - Level One is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Test PDF_1.pdf)"), "Document Uploaded from Vendor (Automation Appraiser3) (Test PDF_1.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Complete by Appraiser (Automation Appraiser3)"), "Inspection Complete by Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Scheduled by Appraiser (Automation Appraiser3)"), "Inspection Scheduled by Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection date"), "Inspection date is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order accepted by Appraiser (Automation Appraiser3) and In Progress"), "Order accepted by Vendor (Automation Appraiser3) and In Progress is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser3"), "Awaiting acceptance by Automation Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Reassigned by Client (Automation EVFAMC2) to Automation Appraiser3"), "Reassigned by Client (Automation EVFAMC2) to Automation Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by Client (Automation EVFAMC2)"), "Order Changed by Client (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(history.contains("To View Change History:"), "To View Change History: is missing from the audit trail");
		Assert.assertTrue(history.contains("Requires assignment"), "Requires assignment is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance"), "Awaiting acceptance is missing from the audit trail");
		
		// Verify Documents aren't in Documents
		documentText = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Other"), "Other did not sync to Secure");
		Assert.assertTrue(documentText.contains("Report PDF"), "Report PDF did not sync to Secure");
		Assert.assertTrue(!documentText.contains("Sales Contract"), "Sales Contract should not sync to Secure");
		Assert.assertTrue(documentText.contains("FNM SSR"), "FNM SSR did not sync to Secure");

		// Click OK
		perform.click(driver,SOrderDetails.okProcessReceivedReport_btn(driver));
		
		// Check to see if back on the orders screen, if not, verify cert info and save it
		try {
			System.out.println("try clicking on the Find textbox");
			perform.click(driver,SOrders.find_txtbx(driver));
		}
		catch (Exception e)
		{
			System.out.println("verify certification information");
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			// Wait for Lender Name
			perform.waitForElementToBeClickable(driver, SVerifyCertificateInformation.lenderName_txtbx(), "id");
			
			// Verify all fields have data
			// Verify Lender Name
			Assert.assertTrue(SVerifyCertificateInformation.lenderName_txtbx(driver).getAttribute("value").equals(StoredVariables.getlenderInformationLenderName().get()), "Lender Name field is incorrect");
			
			// Verify Property Street
			Assert.assertTrue(SVerifyCertificateInformation.propertyStreet_txtbx(driver).getAttribute("value").equals(StoredVariables.getpropertyInformationAddress().get()), "Property Street field is incorrect");
			
			// Verify Property City
			Assert.assertTrue(SVerifyCertificateInformation.propertyCity_txtbx(driver).getAttribute("value").equals(StoredVariables.getpropertyInformationCity().get()), "Property City field is incorrect");
			
			// Verify Property State
			Assert.assertTrue(SVerifyCertificateInformation.propertyState_txtbx(driver).getAttribute("value").equals(StoredVariables.getpropertyInformationStateAbbr().get()), "Property State field is incorrect");
			
			// Verify Property Zip
			Assert.assertTrue(SVerifyCertificateInformation.propertyZip_txtbx(driver).getAttribute("value").equals(StoredVariables.getpropertyInformationZip().get()), "Property Zip field is incorrect");
			
			// Verify Borrower Name
			Assert.assertTrue(SVerifyCertificateInformation.borrowerName_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactBorrower().get()+"-"+StoredVariables.getborrowerIdentifier().get()), "Borrower Name field is incorrect. Should be = " + StoredVariables.getcontactBorrower().get()+"-"+StoredVariables.getborrowerIdentifier().get());
			
			// Verify Loan Number
			Assert.assertTrue(SVerifyCertificateInformation.loanNumber_txtbx(driver).getAttribute("value").equals(StoredVariables.getassignmentInformationLoanNumber().get()), "Loan Number field is incorrect");
			
			// Uncheck Appraised Date
			if (SVerifyCertificateInformation.appraisedDate_chkbx(driver).isSelected())
			{
				perform.click(driver,SVerifyCertificateInformation.appraisedDate_chkbx(driver));
			}
			
			// Uncheck Appraised Value
			if (SVerifyCertificateInformation.appraisedValue_chkbx(driver).isSelected())
			{
				perform.click(driver,SVerifyCertificateInformation.appraisedValue_chkbx(driver));
			}
			
			// Click Save
			perform.click(driver,SVerifyCertificateInformation.save_btn(driver));
			
			Thread.sleep(2000);
			
		} // end catch
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Wait for Find text box
		perform.waitForElementToBeClickable(driver, SOrders.find_txtbx(), "id");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("Appraisal Submission to FNM Not Successful"), "The order is not in the correct status");
		
		// Log in to Secure
		secure.login(driver, "EVFLender2", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, StoredVariables.getloanID().get(), "Tracking number");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("In QC - Level One"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getloanID().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Click OK
		perform.click(driver,SOrderDetails.okProcessReceivedReport_btn(driver));
		
		// Check to see if back on the orders screen, if not, verify cert info and save it
		try {
			System.out.println("try clicking on the Find textbox");
			perform.click(driver,SOrders.find_txtbx(driver));
		}
		catch (Exception e)
		{
			System.out.println("verify certification information");
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			// Wait for Lender Name
			perform.waitForElementToBeClickable(driver, SVerifyCertificateInformation.lenderName_txtbx(), "id");
			
			// Verify all fields have data
			// Verify Lender Name
			Assert.assertTrue(SVerifyCertificateInformation.lenderName_txtbx(driver).getAttribute("value").equals(StoredVariables.getlenderInformationLenderName().get()), "Lender Name field is incorrect");
			
			// Verify Property Street
			Assert.assertTrue(SVerifyCertificateInformation.propertyStreet_txtbx(driver).getAttribute("value").equals(StoredVariables.getpropertyInformationAddress().get()), "Property Street field is incorrect");
			
			// Verify Property City
			Assert.assertTrue(SVerifyCertificateInformation.propertyCity_txtbx(driver).getAttribute("value").equals(StoredVariables.getpropertyInformationCity().get()), "Property City field is incorrect");
			
			// Verify Property State
			Assert.assertTrue(SVerifyCertificateInformation.propertyState_txtbx(driver).getAttribute("value").equals(StoredVariables.getpropertyInformationStateAbbr().get()), "Property State field is incorrect");
			
			// Verify Property Zip
			Assert.assertTrue(SVerifyCertificateInformation.propertyZip_txtbx(driver).getAttribute("value").equals(StoredVariables.getpropertyInformationZip().get()), "Property Zip field is incorrect");
			
			// Verify Borrower Name
			Assert.assertTrue(SVerifyCertificateInformation.borrowerName_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactBorrower().get()+"-"+StoredVariables.getborrowerIdentifier().get()), "Borrower Name field is incorrect. Should be = " + StoredVariables.getcontactBorrower().get()+"-"+StoredVariables.getborrowerIdentifier().get());
			
			// Verify Loan Number
			Assert.assertTrue(SVerifyCertificateInformation.loanNumber_txtbx(driver).getAttribute("value").equals(StoredVariables.getassignmentInformationLoanNumber().get()), "Loan Number field is incorrect");
			
			// Uncheck Appraised Date
			if (SVerifyCertificateInformation.appraisedDate_chkbx(driver).isSelected())
			{
				perform.click(driver,SVerifyCertificateInformation.appraisedDate_chkbx(driver));
			}
			
			// Uncheck Appraised Value
			if (SVerifyCertificateInformation.appraisedValue_chkbx(driver).isSelected())
			{
				perform.click(driver,SVerifyCertificateInformation.appraisedValue_chkbx(driver));
			}
			
			// Click Save
			perform.click(driver,SVerifyCertificateInformation.save_btn(driver));
			
		} // end catch
		
		Thread.sleep(3000);
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Wait for Find text box
		perform.waitForElementToBeClickable(driver, SOrders.find_txtbx(), "id");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("Completed"), "The order is not in the correct status");

		test = ExtentTestManager.getTest();
		
		// If browser is Firefox, skip this method
		if (StoredVariables.getbrowser().get().equals("Firefox"))
		{
			System.out.println("Skipped this method becuase the XSite functionality does not work in Firefox");
			// Log a skip in the extent report
			test.log(LogStatus.SKIP, "<span class='label info'>SKIPPED</span>", "<pre>Skipped this method becuase the XSite functionality does not work in Firefox</pre>");
		} // end if
		else
		{
			
			// View XSite order
			secure.viewXSiteOrderFromSecure(driver, "EVFLender2", StoredVariables.getpassword().get(), StoredVariables.getloanID().get());
			
			// Get history text
			perform.waitForElementToBeVisible(driver, XOrders.toolbar(), "id");
			history = XOrders.history_txt(driver).getText();
			String address = StoredVariables.getpropertyInformationAddress().get() + " " + StoredVariables.getpropertyInformationCity().get() + ", " + StoredVariables.getpropertyInformationStateAbbr().get() + " " + StoredVariables.getpropertyInformationZip().get();
			
			// Recapture the text from the history
			history = XOrders.history_txt(driver).getText();
			
			// Verify the history
			Assert.assertTrue(history.contains("History (Completed)"), "History (Completed) is missing from the order information");
			Assert.assertTrue(history.contains("Completed (Automation EVFLender2)"), "Completed (Automation EVFLender2) is missing from the order information");
			Assert.assertTrue(history.contains("Document Uploaded (Automation EVFLender2) (ProvidedComplianceCert_1.pdf)"), "Document Uploaded (Automation EVFLender2) (ProvidedComplianceCert_1.pdf) is missing from the order information");
			Assert.assertTrue(history.contains("Document Uploaded (Automation EVFLender2) (Invoice_"), "Document Uploaded (Automation EVFLender2) (Invoice_ is missing from the order information");
			Assert.assertTrue(history.contains("Document Uploaded (Automation EVFLender2) (ProvidedComplianceCert.pdf)"), "Document Uploaded (Automation EVFLender2) (ProvidedComplianceCert.pdf) is missing from the order information");
			Assert.assertTrue(history.contains("Comment - Action Required (Automation EVFLender2)"), "Comment - Action Required (Automation EVFLender2) is missing from the order information");
			Assert.assertTrue(history.contains("These are some more Message notes from Appraiser3"), "These are some more Message notes from Appraiser3 is missing from the order information");
			Assert.assertTrue(history.contains("Appraisal Submitted to FNM via UCDP"), "Appraisal Submitted to FNM via UCDP is missing from the order information");
			Assert.assertTrue(history.contains("Resumed (Automation OriginatorEVFLender2)"), "Resumed (Automation OriginatorEVFLender2) is missing from the order information");
			Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVFLender2"), "These are Resume2 test notes from OriginatorEVFLender2 is missing from the order information");
			Assert.assertTrue(history.contains("Comment - Action Required (Automation OriginatorEVFLender2)"), "Comment - Action Required (Automation OriginatorEVFLender2) is missing from the order information");
			Assert.assertTrue(history.contains("Comment - Action Required for " + address), "Comment - Action Required for " + address + " is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVFLender2"), "These are Action Required test notes from OriginatorEVFLender2 is missing from the order information");
			Assert.assertTrue(history.contains("Message (Automation OriginatorEVFLender2)"), "Message (Automation OriginatorEVFLender2) is missing from the order information");
			Assert.assertTrue(history.contains("Order message for " + address), "Order message for " + address + " is missing from the order information");
			Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVFLender2"), "These are test Send Message notes from OriginatorEVFLender2 is missing from the order information");
			Assert.assertTrue(history.contains("Document Uploaded (Automation OriginatorEVFLender2) (TestPDF.pdf)"), "Document Uploaded (Automation OriginatorEVFLender2) (TestPDF.pdf) is missing from the audit trail");
			Assert.assertTrue(history.contains("Document Uploaded (Automation OriginatorEVFLender2) (Test PDF"), "Document Uploaded (Automation OriginatorEVFLender2) (Test PDF is missing from the audit trail");
			Assert.assertTrue(history.contains("Delayed (Automation OriginatorEVFLender2)"), "Delayed (Automation OriginatorEVFLender2) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVFLender2"), "These are Delayed test notes from OriginatorEVFLender2 is missing from the audit trail");
			Assert.assertTrue(history.contains("Resumed (Automation OriginatorEVFLender2)"), "Resumed (Automation OriginatorEVFLender2) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVFLender2"), "These are Resume test notes from OriginatorEVFLender2 is missing from the audit trail");
			Assert.assertTrue(history.contains("On Hold (Automation OriginatorEVFLender2)"), "On Hold (Automation OriginatorEVFLender2) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVFLender2"), "These are Place On Hold test notes from OriginatorEVFLender2 is missing from the order information");
			Assert.assertTrue(history.contains("In Progress (Automation OriginatorEVFLender2)"), "In Progress (Automation OriginatorEVFLender2) is missing from the audit trail");
			Assert.assertTrue(history.contains("Pending Quality Review"), "Pending Quality Review is missing from the order information");
			Assert.assertTrue(!history.contains("Inspection Complete"), "Inspection Complete is missing from the order information");
			Assert.assertTrue(!history.contains("Inspected on"), "Inspected on is missing from the order information");
			Assert.assertTrue(!history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the order information");
			Assert.assertTrue(!history.contains("Inspection Scheduled"), "Inspection Scheduled is missing from the order information");
			Assert.assertTrue(!history.contains("Inspection date is"), "Inspection date is is missing from the order information");
			Assert.assertTrue(!history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the order information");
			
			// Verify order details
			perform.verifyXSiteOrderDetailsForLender(driver);
			
			// Verify documents
			String documentsText = XOrders.documents_txt(driver).getText();
			Assert.assertTrue(documentsText.contains("Sales Contract"), "Sales Contract document is missing from the documents section of the XSite");
			Assert.assertTrue(documentsText.contains("Test PDF"), "Test PDF document is missing from the documents section of the XSite");
			Assert.assertTrue(documentsText.contains("Other"), "Other document is missing from the documents section of the XSite");
			Assert.assertTrue(documentsText.contains("TestPDF"), "TestPDF document is missing from the documents section of the XSite");
			Assert.assertTrue(!documentsText.contains("Test PDF_1"), "TestPDF document is missing from the documents section of the XSite");
			Assert.assertTrue(!documentsText.contains("Apostrophes License"), "Apostrophes License should not sync to the XSite");
			Assert.assertTrue(!documentsText.contains("Test PDF.xml"), "Test PDF.xml should not sync to the XSite");
			Assert.assertTrue(documentsText.contains("Completed Report"), "Completed Report document is missing from the documents section of the XSite");
			Assert.assertTrue(documentsText.contains("Attached Invoice"), "Attached Invoice document is missing from the documents section of the XSite");
			Assert.assertTrue(documentsText.contains("Invoice_"), "Invoice_ document is missing from the documents section of the XSite");
			Assert.assertTrue(documentsText.contains("Compliance Cert"), "Compliance Cert document is missing from the documents section of the XSite");
			Assert.assertTrue(documentsText.contains("ProvidedComplianceCert"), "ProvidedComplianceCert document is missing from the documents section of the XSite");
			
			// Verify comments
			String comments = XOrders.comments_txt(driver).getText();
			Assert.assertTrue(comments.contains("These are test additional comments"), "Additional Comments section is missing info");
			
			// Verify fee
			Assert.assertTrue(XOrders.fee_txt(driver).getText().equals("$350.00"), "Fee should not update");
			
			// Verify SSR is not in the history
			Assert.assertTrue(!history.contains("View FNM SSR"), "View FNM SSR is missing from the order information");
			
			// Verify FNM SSR is not in the Documents
			Assert.assertTrue(documentsText.contains("FNM SSR"), "FNM SSR did not sync to Secure");
			
			// Close XSite order
			perform.closeNewWindow(driver);
			
		} // end else

		// Log in to VMP
		vmp.login(driver, "EVFLender2", "OriginatorEVFLender2", StoredVariables.getpassword().get());
		
		// Search for order
		vmp.findOrder(driver, StoredVariables.getloanIDVMP().get(), "Tracking #");
		
		// Verify Order Status
		Assert.assertTrue(VMPOrders.orderStatus_txt(driver).getText().equals("Completed"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());
		
		Thread.sleep(1500);
		
		// Wait for Edit Property Contacts link
		perform.waitForElementToBeClickable(driver, VMPAppraisalOrderDetails.editPropertyContacts_lnk(), "id");
		
		// Verify the audit trail
		history = VMPAppraisalOrderDetails.history_txt(driver).getText();
		
		Assert.assertTrue(history.contains("Completed by Automation EVFLender2"), "Completed by Automation EVFLender2 is missing from the order information");
		Assert.assertTrue(history.contains("ProvidedComplianceCert_1.pdf"), "ProvidedComplianceCert_1.pdf is missing from the order information");
		Assert.assertTrue(history.contains("Document Uploaded by Automation EVFLender2"), "Document Uploaded by Automation EVFLender2 is missing from the order information");
		Assert.assertTrue(history.contains("Compliance Cert"), "Compliance Cert is missing from the order information");
		Assert.assertTrue(history.contains("ProvidedComplianceCert.pdf"), "ProvidedComplianceCert.pdf is missing from the order information");
		Assert.assertTrue(history.contains("Document Uploaded by Automation EVFLender2"), "Document Uploaded by Automation EVFLender2 is missing from the order information");
		Assert.assertTrue(history.contains("Attached Invoice"), "Attached Invoice is missing from the order information");
		Assert.assertTrue(history.contains("Invoice_"), "Invoice_ is missing from the order information");
		Assert.assertTrue(history.contains("Invoice attached"), "Invoice attached is missing from the order information");
		Assert.assertTrue(history.contains("Comment - Action Required by Automation EVFLender2"), "Comment - Action Required by Automation EVFLender2 is missing from the order information");
		Assert.assertTrue(history.contains("These are some more Message notes from Appraiser3"), "These are some more Message notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Pending Quality Review by Automation EVFLender2"), "Pending Quality Review by Automation EVFLender2 is missing from the audit trail");
		Assert.assertTrue(!history.contains("Inspection Complete by Automation EVFLender2"), "Inspection Complete by Automation EVFLender2 is missing from the audit trail");
		Assert.assertTrue(!history.contains("Inspected on"), "Inspected on is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(!history.contains("Inspection Scheduled by Automation EVFLender2"), "Inspection Scheduled by Automation EVFLender2 is missing from the audit trail");
		Assert.assertTrue(!history.contains("Inspection date is"), "Inspection date is is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraisal Submitted to FNM via UCDP by Automation EVFLender2"), "Appraisal Submitted to FNM via UCDP by Automation EVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorEVFLender2"), "Resumed by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVFLender2"), "These are Resume2 test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Automation OriginatorEVFLender2"), "Comment - Action Required by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVFLender2"), "These are Action Required test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation OriginatorEVFLender2"), "Message by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVFLender2"), "These are test Send Message notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorEVFLender2"), "Document Uploaded by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Other"), "Other is missing from the audit trail");
		Assert.assertTrue(history.contains("TestPDF.pdf"), "TestPDF.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorEVFLender2"), "Document Uploaded by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Sales Contract"), "Sales Contract is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF"), "Test PDF is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation OriginatorEVFLender2"), "Delayed by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVFLender2"), "These are Delayed test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorEVFLender2"), "Resumed by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVFLender2"), "These are Resume test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Automation OriginatorEVFLender2"), "On Hold by Automation OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVFLender2"), "These are Place On Hold test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("In Progress by Automation OriginatorEVFLender2"), "In Progress by Automation OriginatorEVFLender2 is missing from the audit trail");
		
		// Verify fee
		Assert.assertTrue(VMPAppraisalOrderDetails.orderDetails_txt(driver).getText().contains("$350"), "Fee should not update");
		
		// Verify the order details
		vmp.verifyAppraisalOrderDetails(driver);
		
		// Verify Document is in Documents
		documentText = VMPAppraisalOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Other"), "Other document is not displayed in VMP Client Portal");
		Assert.assertTrue(documentText.contains("Sales Contract"), "Sales Contract did not sync to VMP Client Portal");
		Assert.assertTrue(documentText.contains("Report PDF"), "Report PDF should not sync to VMP Client Portal");
		Assert.assertTrue(documentText.contains("Attached Invoice"), "Attached Invoice document is not displayed in VMP Client Portal");
		Assert.assertTrue(documentText.contains("Compliance Cert"), "Compliance Cert document is not displayed in VMP Client Portal");
		
		// Verify SSR is not in the history
		Assert.assertTrue(!history.contains("View FNM SSR"), "View FNM SSR is missing from the order information");
		
		// Verify FNM SSR is not in the Documents
		Assert.assertTrue(documentText.contains("FNM SSR"), "FNM SSR did not sync to Secure");
		
		// Click on Sales Contract
		perform.clickInTable_Contains(driver, "Sales Contract");
		
		// Wait for text to update
		perform.waitForText(driver, VMPAppraisalOrderDetails.documents_txt(driver), "Test PDF");
		documentText = VMPAppraisalOrderDetails.documents_txt(driver).getText();
		
		// Verify file name and uploaded by
		Assert.assertTrue(documentText.contains("Test PDF"), "Document name is incorrect in Documents");
		Assert.assertTrue(documentText.contains("Automation OriginatorEVFLender2"), "Uploaded By is incorrect in Documents");
		
		// Click on Other
		perform.clickInTable_Equals(driver, "Other");
		
		// Wait for text to update
		perform.waitForText(driver, VMPAppraisalOrderDetails.documents_txt(driver), "TestPDF.pdf");
		documentText = VMPAppraisalOrderDetails.documents_txt(driver).getText();
		
		// Verify file name and uploaded by
		Assert.assertTrue(documentText.contains("TestPDF.pdf"), "Document name is incorrect in Documents");
		Assert.assertTrue(documentText.contains("Automation OriginatorEVFLender2"), "Uploaded By is incorrect in Documents");
		
		// Click on Report PDF
		perform.clickInTable_Contains(driver, "Report PDF");
		
		// Wait for text to update
		perform.waitForText(driver, VMPAppraisalOrderDetails.documents_txt(driver), "Test PDF");
		documentText = VMPAppraisalOrderDetails.documents_txt(driver).getText();
		
		// Verify file name and uploaded by
		Assert.assertTrue(documentText.contains("Test PDF"), "Document name is incorrect in Documents");
		Assert.assertTrue(documentText.contains("Automation EVFLender2"), "Uploaded By is incorrect in Documents");
		
		// Click on Attached Invoice
		perform.clickInTable_Contains(driver, "Attached Invoice");
		
		// Wait for text to update
		perform.waitForText(driver, VMPAppraisalOrderDetails.documents_txt(driver), "Invoice_");
		documentText = VMPAppraisalOrderDetails.documents_txt(driver).getText();
		
		// Verify file name and uploaded by
		Assert.assertTrue(documentText.contains("Invoice_"), "Document name is incorrect in Documents");
		Assert.assertTrue(documentText.contains("Automation EVFLender2"), "Uploaded By is incorrect in Documents");
		
		// Click on Compliance Cert
		perform.clickInTable_Contains(driver, "Compliance Cert");
		
		// Wait for text to update
		perform.waitForText(driver, VMPAppraisalOrderDetails.documents_txt(driver), "ProvidedComplianceCert");
		documentText = VMPAppraisalOrderDetails.documents_txt(driver).getText();
		
		// Verify file name and uploaded by
		Assert.assertTrue(documentText.contains("ProvidedComplianceCert"), "Document name is incorrect in Documents");
		Assert.assertTrue(documentText.contains("Automation EVFLender2"), "Uploaded By is incorrect in Documents");

		// Log in to Secure
		secure.login(driver, "EVFLender2", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, StoredVariables.getloanID().get(), "Tracking number");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("Completed"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getloanID().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Verify order details
		secure.verifyResidentialAppraisalOrderDetails(driver);
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify the history
		Assert.assertTrue(history.contains("History (Completed)"), "History (Completed) is missing from the order information");
		Assert.assertTrue(history.contains("Completed by Client (Automation EVFLender2)"), "Completed by Client (Automation EVFLender2) is missing from the order information");
		Assert.assertTrue(history.contains("Order delivered by AMC (Automation Test User) and is now In QC - Level One"), "Order delivered by Vendor (Automation EVFAMC2) and is now In QC - Level One is missing from the order information");
		Assert.assertTrue(history.contains("Document Uploaded from AMC (Automation Test User) (ProvidedComplianceCert.pdf)"), "Document Uploaded from Vendor (Automation EVFAMC2) (ProvidedComplianceCert.pdf) is missing from the order information");
		Assert.assertTrue(history.contains("Document Uploaded from AMC (Automation Test User) (Invoice_"), "Document Uploaded from Vendor (Automation EVFAMC2) (Invoice_ is missing from the order information");
		Assert.assertTrue(history.contains("Invoice attached"), "Invoice attached is missing from the order information");
		Assert.assertTrue(history.contains("Comment - Action Required by AMC (Automation Test User)"), "Comment - Action Required by Vendor (Automation EVFAMC2) is missing from the order information");
		Assert.assertTrue(history.contains("These are some more Message notes from Appraiser3"), "These are some more Message notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Submitted to FNM via UCDP by AMC (Automation Test User)"), "Appraisal Submitted to FNM via UCDP by Vendor (Automation EVFAMC2) is missing from the order information");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFLender2)"), "Resumed by Client (Automation EVFLender2) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVFLender2"), "These are Resume2 test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation EVFLender2)"), "Comment - Action Required by Client (Automation EVFLender2) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVFLender2"), "These are Action Required test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFLender2)"), "Message from Client (Automation EVFLender2) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVFLender2"), "These are test Send Message notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFLender2) (TestPDF.pdf)"), "Document Uploaded from Client (Automation EVFLender2) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFLender2) (Test PDF"), "Document Uploaded from Client (Automation EVFLender2) (Test PDF is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Client (Automation EVFLender2)"), "Delayed by Client (Automation EVFLender2) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVFLender2"), "These are Delayed test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFLender2)"), "Resumed by Client (Automation EVFLender2) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVFLender2"), "These are Resume test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Client (Automation EVFLender2)"), "On Hold by Client (Automation EVFLender2) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVFLender2"), "These are Place On Hold test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by AMC (Automation Test User)"), "Order Changed by Vendor (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(history.contains("To View Change History:"), "To View Change History: is missing from the audit trail");
		Assert.assertTrue(history.contains("Order accepted by AMC (Automation Test User) and In Progress"), "Order accepted by Vendor (Automation EVFAMC2) and In Progress is missing from the audit trail");
		Assert.assertTrue(history.contains("Order automatically accepted."), "Order automatically accepted. is missing from the audit trail");
		Assert.assertTrue(history.contains("Order automatically assigned"), "Order automatically assigned is missing from the audit trail");
		Assert.assertTrue(history.contains("Assigned to Automation Test User"), "Assigned to Automation Test User is missing from the audit trail");
		Assert.assertTrue(!history.contains("Pending Quality Review"), "Pending Quality Review is missing from the order information");
		Assert.assertTrue(!history.contains("Inspection Complete"), "Inspection Complete is missing from the order information");
		Assert.assertTrue(!history.contains("Inspected on"), "Inspected on is missing from the order information");
		Assert.assertTrue(!history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(!history.contains("Inspection Scheduled"), "Inspection Scheduled is missing from the order information");
		Assert.assertTrue(!history.contains("Inspection date is"), "Inspection date is is missing from the order information");
		Assert.assertTrue(!history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the order information");
		
		// Verify Other Document is in Documents
		documentText = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(!documentText.contains("Market Information"), "Market Information should not sync to Secure");
		Assert.assertTrue(documentText.contains("Report PDF"), "Report PDF should not sync to Secure");
		Assert.assertTrue(documentText.contains("Other"), "Other did not sync to Secure");
		Assert.assertTrue(documentText.contains("Sales Contract"), "Sales Contract did not sync to Secure");
		Assert.assertTrue(documentText.contains("Attached Invoice"), "Attached Invoice did not sync to Secure");
		Assert.assertTrue(documentText.contains("Compliance Cert"), "Compliance Cert did not sync to Secure");
		
		// Verify SSR is not in the history
		Assert.assertTrue(!history.contains("View FNM SSR"), "View FNM SSR is missing from the order information");
		
		// Verify FNM SSR is not in the Documents
		Assert.assertTrue(documentText.contains("FNM SSR"), "FNM SSR did not sync to Secure");
		
		// Verify Sales ContractDocument is in Documents
		documentText = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Sales Contract"), "Sales Contract did not sync to Secure");
		
		// Click on Sales Contract
		perform.clickInTable_Contains(driver, "Sales Contract");
		
		// Wait for text to update
		perform.waitForText(driver, SOrderDetails.documents_txt(driver), "Test PDF");
		documentText = SOrderDetails.documents_txt(driver).getText();
		
		// Verify file name and uploaded by
		Assert.assertTrue(documentText.contains("Test PDF"), "Document name is incorrect in Documents");
		Assert.assertTrue(documentText.contains("Automation EVFLender2"), "Uploaded By is incorrect in Documents");
		
		// Click on Other
		perform.clickInTable_Equals(driver, "Other");
		
		// Wait for text to update
		perform.waitForText(driver, SOrderDetails.documents_txt(driver), "TestPDF.pdf");
		documentText = SOrderDetails.documents_txt(driver).getText();
		
		// Verify file name and uploaded by
		Assert.assertTrue(documentText.contains("TestPDF.pdf"), "Document name is incorrect in Documents");
		Assert.assertTrue(documentText.contains("Automation EVFLender2"), "Uploaded By is incorrect in Documents");
		
		// Click on Report PDF
		perform.clickInTable_Contains(driver, "Report PDF");
		
		// Wait for text to update
		perform.waitForText(driver, SOrderDetails.documents_txt(driver), "Test PDF");
		documentText = SOrderDetails.documents_txt(driver).getText();
		
		// Verify file name and uploaded by
		Assert.assertTrue(documentText.contains("Test PDF"), "Document name is incorrect in Documents");
		Assert.assertTrue(documentText.contains("Automation EVFAMC2"), "Uploaded By is incorrect in Documents");
		
		// Click on Attached Invoice
		perform.clickInTable_Contains(driver, "Attached Invoice");
		
		// Wait for text to update
		perform.waitForText(driver, SOrderDetails.documents_txt(driver), "Invoice_");
		documentText = SOrderDetails.documents_txt(driver).getText();
		
		// Verify file name and uploaded by
		Assert.assertTrue(documentText.contains("Invoice_"), "Document name is incorrect in Documents");
		Assert.assertTrue(documentText.contains("Automation EVFAMC2"), "Uploaded By is incorrect in Documents");
		
		// Click on Compliance Cert
		perform.clickInTable_Contains(driver, "Compliance Cert");
		
		// Wait for text to update
		perform.waitForText(driver, SOrderDetails.documents_txt(driver), "ProvidedComplianceCert");
		documentText = SOrderDetails.documents_txt(driver).getText();
		
		// Verify file name and uploaded by
		Assert.assertTrue(documentText.contains("ProvidedComplianceCert"), "Document name is incorrect in Documents");
		Assert.assertTrue(documentText.contains("Automation EVFAMC2"), "Uploaded By is incorrect in Documents");

		test = ExtentTestManager.getTest();
		
		// If browser is Firefox, skip this method
		if (StoredVariables.getbrowser().get().equals("Firefox"))
		{
			System.out.println("Skipped this method becuase the XSite functionality does not work in Firefox");
			// Log a skip in the extent report
			test.log(LogStatus.SKIP, "<span class='label info'>SKIPPED</span>", "<pre>Skipped this method becuase the XSite functionality does not work in Firefox</pre>");
		} // end if
		else
		{
			
			// View XSite order
			secure.viewXSiteOrderFromSecure(driver, "EVFAMC2", StoredVariables.getpassword().get(), StoredVariables.getloanIDAMC().get());
			
			// Get history text
			perform.waitForElementToBeVisible(driver, XOrders.toolbar(), "id");
			history = XOrders.history_txt(driver).getText();
			String address = StoredVariables.getpropertyInformationAddress().get() + " " + StoredVariables.getpropertyInformationCity().get() + ", " + StoredVariables.getpropertyInformationStateAbbr().get() + " " + StoredVariables.getpropertyInformationZip().get();
			
			// Verify the history
			Assert.assertTrue(history.contains("History (Completed)"), "History (Completed) is missing from the order information");
			Assert.assertTrue(history.contains("Completed (Automation EVFLender2)"), "Completed (Automation EVFLender2) is missing from the order information");
			Assert.assertTrue(history.contains("Pending Quality Review (Automation EVFAMC2)"), "Pending Quality Review (Automation EVFAMC2) is missing from the order information");
			Assert.assertTrue(history.contains("Document Uploaded (Automation EVFAMC2) (ProvidedComplianceCert.pdf)"), "Document Uploaded (Automation EVFAMC2) (ProvidedComplianceCert.pdf) is missing from the order information");
			Assert.assertTrue(history.contains("Document Uploaded (Automation EVFAMC2) (Invoice_"), "Document Uploaded (Automation EVFAMC2) (Invoice_ is missing from the order information");
			Assert.assertTrue(history.contains("Comment - Action Required (Automation EVFAMC2)"), "Comment - Action Required (Automation EVFAMC2) is missing from the order information");
			Assert.assertTrue(history.contains("These are some more Message notes from Appraiser3"), "These are some more Message notes from Appraiser3 is missing from the order information");
			Assert.assertTrue(history.contains("Appraisal Submitted to FNM via UCDP"), "Appraisal Submitted to FNM via UCDP is missing from the order information");
			Assert.assertTrue(history.contains("Resumed (Automation EVFLender2)"), "Resumed (Automation EVFLender2) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVFLender2"), "These are Resume2 test notes from OriginatorEVFLender2 is missing from the audit trail");
			Assert.assertTrue(history.contains("Comment - Action Required (Automation EVFLender2)"), "Comment - Action Required (Automation EVFLender2) is missing from the order information");
			Assert.assertTrue(history.contains("Comment - Action Required for " + address), "Comment - Action Required for " + address + " is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVFLender2"), "These are Action Required test notes from OriginatorEVFLender2 is missing from the audit trail");
			Assert.assertTrue(history.contains("Message (Automation EVFLender2)"), "Message (Automation EVFLender2) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVFLender2"), "These are test Send Message notes from OriginatorEVFLender2 is missing from the audit trail");
			Assert.assertTrue(history.contains("Document Uploaded (Automation EVFLender2) (TestPDF.pdf)"), "Document Uploaded (Automation EVFLender2) (TestPDF.pdf) is missing from the audit trail");
			Assert.assertTrue(history.contains("Document Uploaded (Automation EVFLender2) (Test PDF"), "Document Uploaded (Automation EVFLender2) (Test PDF is missing from the audit trail");
			Assert.assertTrue(history.contains("Delayed (Automation EVFLender2)"), "Delayed (Automation EVFLender2) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVFLender2"), "These are Delayed test notes from OriginatorEVFLender2 is missing from the audit trail");
			Assert.assertTrue(history.contains("Resumed (Automation EVFLender2)"), "Resumed (Automation EVFLender2) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVFLender2"), "These are Resume test notes from OriginatorEVFLender2 is missing from the audit trail");
			Assert.assertTrue(history.contains("On Hold (Automation EVFLender2)"), "On Hold (Automation EVFLender2) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVFLender2"), "These are Place On Hold test notes from OriginatorEVFLender2 is missing from the audit trail");
			Assert.assertTrue(history.contains("Order Changed (Automation EVFAMC2)"), "Order Changed (Automation EVFAMC2) is missing from the audit trail");
			Assert.assertTrue(history.contains("To View Change History:"), "To View Change History: is missing from the audit trail");
			Assert.assertTrue(history.contains("In Progress (Automation EVFAMC2)"), "In Progress (Automation EVFAMC2) is missing from the audit trail");
			Assert.assertTrue(history.contains("Order automatically accepted."), "Order automatically accepted. is missing from the audit trail");
			Assert.assertTrue(history.contains("Awaiting acceptance"), "Awaiting acceptance is missing from the audit trail");
			Assert.assertTrue(!history.contains("Inspection Complete"), "Inspection Complete is missing from the order information");
			Assert.assertTrue(!history.contains("Inspected on"), "Inspected on is missing from the order information");
			Assert.assertTrue(!history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the order information");
			Assert.assertTrue(!history.contains("Inspection Scheduled"), "Inspection Scheduled is missing from the order information");
			Assert.assertTrue(!history.contains("Inspection date is"), "Inspection date is is missing from the order information");
			Assert.assertTrue(!history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the order information");
			
			// Verify order details
			perform.verifyXSiteOrderDetailsForAMC(driver);
			
			// Verify documents
			perform.waitForText(driver, XOrders.documents_txt(driver), "Other");
			String documentsText = XOrders.documents_txt(driver).getText();
			Assert.assertTrue(documentsText.contains("Other"), "Other document is missing from the documents section of the XSite - " + documentsText);
			Assert.assertTrue(documentsText.contains("TestPDF"), "TestPDF document is missing from the documents section of the XSite - " + documentsText);
			Assert.assertTrue(documentsText.contains("Sales Contract"), "Sales Contract document is missing from the documents section of the XSite - " + documentsText);
			Assert.assertTrue(documentsText.contains("Test PDF"), "Test PDF document is missing from the documents section of the XSite - " + documentsText);
			
			// Verify SSR is not in the history
			Assert.assertTrue(!history.contains("View FNM SSR"), "View FNM SSR is missing from the order information");
			
			// Verify FNM SSR is not in the Documents
			Assert.assertTrue(documentsText.contains("FNM SSR"), "FNM SSR did not sync to Secure");
			
			// Verify comments
			String comments = XOrders.comments_txt(driver).getText();
			Assert.assertTrue(comments.contains("These are edited comments by EVFAMC"), "Additional Comments section is missing info");
			
			// Close XSite order
			perform.closeNewWindow(driver);
			
		} // end else

		// Log in to Secure
		secure.login(driver, "EVFAMC2", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, StoredVariables.getloanIDAMC().get(), "Tracking number");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("Appraisal Submission to FNM Not Successful"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getloanIDAMC().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Verify order details
		secure.verifyResidentialAppraisalOrderDetails(driver);
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify the history
		Assert.assertTrue(history.contains("History (Appraisal Submission to UCDP Not Successful)"), "History (Appraisal Submission to UCDP Not Successful) is missing from the order information");
		Assert.assertTrue(history.contains("Completed by Client (Automation EVFAMC2)"), "Completed by Client (Automation EVFAMC2) is missing from the order information");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser3)"), "Message from Vendor (Automation Appraiser3) is missing from the order information");
		Assert.assertTrue(history.contains("These are some more Message notes from Appraiser3"), "These are some more Message notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Submission to FNM Not Successful"), "Appraisal Submission to FNM Not Successful is missing from the order information");
		Assert.assertTrue(history.contains("View FNM SSR"), "View FNM SSR is missing from the order information");
		Assert.assertTrue(history.contains("UCDP Document File ID Updated by Client (Automation EVFAMC2)"), "UCDP Document File ID Updated by Client (Automation EVFAMC2) is missing from the order information");
		Assert.assertTrue(history.contains("Note Added (Automation EVFAMC2)"), "Note Added (Automation EVFAMC2) is missing from the order information");
		Assert.assertTrue(history.contains("These are internal notes from EVFAMC on Secure"), "These are internal notes from EVFAMC on Secure is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Submitted to FNM via UCDP by Client (Automation EVFAMC2)"), "Appraisal Submitted to FNM via UCDP by Client (Automation EVFAMC2) is missing from the order information");
		Assert.assertTrue(history.contains("Order delivered by Appraiser (Automation Appraiser3) and is now In QC - Level One"), "Order delivered by Vendor (Automation Appraiser3) and is now In QC - Level One is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Test PDF_1.pdf)"), "Document Uploaded from Vendor (Automation Appraiser3) (Test PDF_1.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Complete by Appraiser (Automation Appraiser3)"), "Inspection Complete by Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Scheduled by Appraiser (Automation Appraiser3)"), "Inspection Scheduled by Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection date"), "Inspection date is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order accepted by Appraiser (Automation Appraiser3) and In Progress"), "Order accepted by Vendor (Automation Appraiser3) and In Progress is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser3"), "Awaiting acceptance by Automation Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Reassigned by Client (Automation EVFAMC2) to Automation Appraiser3"), "Reassigned by Client (Automation EVFAMC2) to Automation Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by Client (Automation EVFAMC2)"), "Order Changed by Client (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(history.contains("To View Change History:"), "To View Change History: is missing from the audit trail");
		Assert.assertTrue(history.contains("Requires assignment"), "Requires assignment is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance"), "Awaiting acceptance is missing from the audit trail");
		
		// Verify Documents aren't in Documents
		documentText = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Other"), "Other did not sync to Secure");
		Assert.assertTrue(documentText.contains("Report PDF"), "Report PDF did not sync to Secure");
		Assert.assertTrue(!documentText.contains("Sales Contract"), "Sales Contract should not sync to Secure");
		Assert.assertTrue(documentText.contains("FNM SSR"), "FNM SSR did not sync to Secure");
		Assert.assertTrue(documentText.contains("Completed Report"), "Completed Report document is missing from the documents section of the XSite");
		
		// Log in to Vendors
		vendors.login(driver, "Appraiser3", StoredVariables.getpassword().get());
		
		// Search for order
		vendors.findOrder(driver, StoredVariables.getloanIDAMC().get(), "Tracking Number");
		
		// Verify order status
		Assert.assertTrue(VOrders.ordersGrid_txt(driver).getText().contains("Completed"), "The order is not in the correct status");
		
		// Click on the order from the orders grid
		perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, VOrderDetails.orderInformation_txt(), "id");
		
		// Get order information text
		history = VOrderDetails.orderInformation_txt(driver).getText();
		
		// Verify audit trail
		Assert.assertTrue(history.contains("History (Completed)"), "History (Completed) is missing from the order information");
		Assert.assertTrue(history.contains("Completed by Client (Automation EVFAMC2)"), "Completed by Client (Automation EVFAMC2) is missing from the order information");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser3)"), "Message from Appraiser (Automation Appraiser3) is missing from the order information");
		Assert.assertTrue(history.contains("These are some more Message notes from Appraiser3"), "These are some more Message notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Order delivered by Appraiser (Automation Appraiser3) and is now In QC - Level One"), "Order delivered by Appraiser (Automation Appraiser3) and is now In QC - Level One is missing from the order information");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Test PDF_1.pdf)"), "Document Uploaded from Appraiser (Automation Appraiser3) (Test PDF_1.pdf) is missing from the order information");
		Assert.assertTrue(history.contains("Inspection Complete by Appraiser (Automation Appraiser3)"), "Inspection Complete by Appraiser (Automation Appraiser3) is missing from the order information");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Inspection Scheduled by Appraiser (Automation Appraiser3)"), "Inspection Scheduled by Appraiser (Automation Appraiser3) is missing from the order information");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(!history.contains("Resumed by Vendor (Automation Appraiser3)"), "Resumed by Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(!history.contains("Delayed by Vendor (Automation Appraiser3)"), "Delayed by Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order accepted by Appraiser (Automation Appraiser3) and In Progress"), "Order accepted by Appraiser (Automation Appraiser3) and In Progress is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(!history.contains("Resumed by Client (Automation EVFAMC2)"), "Resumed by Client (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are Resume2 test notes from OriginatorEVFLender2"), "These are Resume2 test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(!history.contains("Comment - Action Required by Client (Automation EVFAMC2)"), "Comment - Action Required by Client (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are Action Required test notes from OriginatorEVFLender2"), "These are Action Required test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(!history.contains("Message from Client (Automation EVFAMC2)"), "Message from Client (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are test Send Message notes from OriginatorEVFLender2"), "These are test Send Message notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(!history.contains("Document Uploaded from Client (Automation EVFAMC2) (TestPDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC2) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(!history.contains("Delayed by Client (Automation EVFAMC2)"), "Delayed by Client (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are Delayed test notes from OriginatorEVFLender2"), "These are Delayed test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(!history.contains("Resumed by Client (Automation EVFAMC2)"), "Resumed by Client (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are Resume test notes from OriginatorEVFLender2"), "These are Resume test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(!history.contains("On Hold by Client (Automation EVFAMC2)"), "On Hold by Client (Automation EVFAMC2) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are Place On Hold test notes from OriginatorEVFLender2"), "These are Place On Hold test notes from OriginatorEVFLender2 is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser3"), "Awaiting acceptance by Automation Appraiser3 is missing from the audit trail");
		
		// Verify fee
		Assert.assertTrue(VOrderDetails.orderInformation_txt(driver).getText().contains("$350"), "Fee should not have updated");
		
		// Get comments
		additionalComments = VOrderDetails.additionalComments_txt(driver).getText();
		
		// Verify both VMP and MN comments are displayed
		Assert.assertTrue(additionalComments.contains("These are edited comments by EVFAMC"), "Additional Comments section is missing info");
		
		// View Order Details
		vendors.verifyOrderDetails(driver);
		
		// Verify Document is in Documents
		documentText = VOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Other"), "Other did not sync to Vendors");
		Assert.assertTrue(!documentText.contains("Sales Contract"), "Sales Contract should not sync to Vendors");
		Assert.assertTrue(documentText.contains("Order Documents"), "Order Documents is not showing in the Order Documents");
		Assert.assertTrue(documentText.contains("Report PDF"), "Report PDF is not showing in the Order Documents");
		Assert.assertTrue(documentText.contains("Completed Report (Current)"), "Completed Report (Current) is not showing in the Order Documents");
		Assert.assertTrue(documentText.contains(StoredVariables.gettodaysDateLong().get()), "The Date Uploaded is not showing in the Order Documents");
		
		// Click Sales Contract
		perform.clickInTable_Contains(driver, "Report PDF");
		
		// Wait for text
		perform.waitForText(driver, VOrderDetails.documents_txt(driver), "Test PDF");
		documentText = VOrderDetails.documents_txt(driver).getText();
		
		// Verify Uploaded By and Document Name
		Assert.assertTrue(documentText.contains("Test PDF"), "Test PDF is not showing as the Document Name in Order Documents");
		Assert.assertTrue(documentText.contains("Automation Appraiser3"), "Automation Appraiser3 is not showing as the Document Name in Order Documents");
		
		// Click Other
		perform.clickInTable_Equals(driver, "Other");
		
		// Wait for text
		perform.waitForText(driver, VOrderDetails.documents_txt(driver), "Test PDF_1.pdf");
		documentText = VOrderDetails.documents_txt(driver).getText();
		
		// Verify Uploaded By and Document Name
		Assert.assertTrue(documentText.contains("Test PDF_1.pdf"), "Test PDF.xml is not showing as the Document Name in Order Documents");
		Assert.assertTrue(documentText.contains("Automation Appraiser3"), "Automation Appraiser3 is not showing as the Document Name in Order Documents");
		
		// Log test
		test.log(LogStatus.INFO, "EVF", "Ran through the EVF martix");
		
	} // end viewThirdOrderDetailsOnVendors
	
} // end the OrderManagement class
