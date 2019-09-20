package matrixEVF;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjects.Secure.SConfirmOrder;
import pageObjects.Secure.SNewOrder;
import pageObjects.Secure.SOrderDetails;
import pageObjects.Secure.SOrders;
import pageObjects.Secure.SPreferences;
import pageObjects.Secure.SSetOrderStatus;
import pageObjects.Secure.SSubmitToUCDP;
import pageObjects.Secure.SSyncToVMP;
import pageObjects.Secure.SVMPXSites;
import pageObjects.Secure.SVendorSelection;
import pageObjects.Secure.SVendorSelectionSettings;
import pageObjects.VMP.VMPAppraisalOrderDetails;
import pageObjects.VMP.VMPCancelRevisionRequest;
import pageObjects.VMP.VMPConfirmOrder;
import pageObjects.VMP.VMPNewOrder;
import pageObjects.VMP.VMPOrders;
import pageObjects.Vendors.VOrderAcknowledgement;
import pageObjects.Vendors.VOrderDetails;
import pageObjects.Vendors.VOrders;
import pageObjects.XSite.XEditOrder;
import pageObjects.XSite.XOrders;
import pageObjects.XSite.XSendMessage;
import pageObjects.XSite.XStatus;
import pageObjects.XSite.XSyncToMercury;
import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>EVF - First Created Order</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
@Test(singleThreaded=true, groups={"EVF"}, enabled=false)
public class EVF_FirstCreatedOrder extends TestSetup {
	
	/** The amc company. */
	private String amcCompany = null;
	
	/** The aws accounts ID. */
	private String awsAccountsID = null;
	
	/** The order number AMC. */
	private String orderNumberAMC = null;
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
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
	 * 	<li>Uncheck Market Information</li>
	 * 	<li>Uncheck Market Information</li>
	 * 	<li>SVMPXSites.marketInformation_chkbx(driver));</li>
	 * 	<li>Click OK</li>
	 * 	<li>Click the Vendor Document Upload gear icon</li>
	 * 	<li>Uncheck Sales Contract</li>
	 * 	<li>Uncheck Sales Contract</li>
	 * 	<li>perform.clickLabelText("Sales Contract");</li>
	 * 	<li>Click OK</li>
	 * 	<li>Click Save</li>
	 * 	<li>perform.waitForOverlayToBeVisible(driver);</li>
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
	 * 	<li>if (Description.equals("On Hold")){Assert.assertTrue(SyncDirection.equals("Sync to Mercury"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync to Mercury\n" + getSyncStatusSQL);}</li>
	 * 	<li>if (Description.equals("Order Changed")){Assert.assertTrue(SyncDirection.equals("Sync to Mercury"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync to Mercury\n" + getSyncStatusSQL);}</li>
	 * 	<li>if (Description.equals("Revision Needed")){Assert.assertTrue(SyncDirection.equals("Sync to Mercury"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync to Mercury\n" + getSyncStatusSQL);}</li>
	 * 	<li>if (Description.equals("Revision Request Cancelled")){Assert.assertTrue(SyncDirection.equals("Sync to Mercury"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync to Mercury\n" + getSyncStatusSQL);}</li>
	 * 	<li>if (Description.equals("Comment - Action Required")){Assert.assertTrue(SyncDirection.equals("Sync to Mercury"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync to Mercury\n" + getSyncStatusSQL);}</li>
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
	 * 	<li>Click Preferences</li>
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
	 * 	<li>Set AMC Company</li>
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
	 * 	<li>Uncheck Pending Quality Review</li>
	 * 	<li>Click Save</li>
	 * 	<li>perform.waitForOverlayToBeVisible(driver);</li>
	 * 	<li>Click on AMC/Firm</li>
	 * 	<li>Enable all sync status options for Appraiser/Agent</li>
	 * 	<li>Click the AMC Client Document Upload gear icon</li>
	 * 	<li>Check every option for syncing</li>
	 * 	<li>Click OK</li>
	 * 	<li>Click the AMC Vendor Document Upload gear icon</li>
	 * 	<li>Check every option for syncing</li>
	 * 	<li>Click OK</li>
	 * 	<li>Click Save</li>
	 * 	<li>perform.waitForOverlayToBeVisible(driver);</li>
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
	 * 	<li>if (Description.equals("On Hold")){Assert.assertTrue(SyncDirection.equals("Sync to Mercury"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync to Mercury\n" + getSyncStatusSQL);}</li>
	 * 	<li>if (Description.equals("Order Changed")){Assert.assertTrue(SyncDirection.equals("Sync to Mercury"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync to Mercury\n" + getSyncStatusSQL);}</li>
	 * 	<li>if (Description.equals("Pending Quality Review")){Assert.assertTrue(!SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite\n" + getSyncStatusSQL);}</li>
	 * 	<li>if (Description.equals("Revision Needed")){Assert.assertTrue(SyncDirection.equals("Sync to Mercury"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync to Mercury\n" + getSyncStatusSQL);}</li>
	 * 	<li>if (Description.equals("Revision Request Cancelled")){Assert.assertTrue(SyncDirection.equals("Sync to Mercury"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync to Mercury\n" + getSyncStatusSQL);}</li>
	 * 	<li>if (Description.equals("Comment - Action Required")){Assert.assertTrue(SyncDirection.equals("Sync to Mercury"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync to Mercury\n" + getSyncStatusSQL);}</li>
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
	 * 	<li>Set Assigned person and pass it to StoredVariables</li>
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
	 * 	<li>Click Assign button</li>
	 * 	<li>Click Close on Related Orders popup</li>
	 * 	<li>Verify url contains VendorSelect</li>
	 * 	<li>Click on Fee Panel tab</li>
	 * 	<li>Verify Fee Panel tab is selected</li>
	 * 	<li>Select Automation Appraiser3</li>
	 * 	<li>Click Next</li>
	 * 	<li>Verify Confirm Order url</li>
	 * 	<li>Agree to the fee notes</li>
	 * 	<li>Agree to pay the transaction fee</li>
	 * 	<li>Click Finish</li>
	 * 	<li>Verify the order is in the Awaiting acceptance status</li>
	 * 	<li>Verify audit trail</li>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify order status</li>
	 * 	<li>Click on the order from the orders grid</li>
	 * 	<li>Get order information text</li>
	 * 	<li>Verify audit trail</li>
	 * 	<li>Get comments</li>
	 * 	<li>Verify both VMP and MN comments are displayed</li>
	 * 	<li>View Order Details</li>
	 * 	<li>Login to VMP Client Portal</li>
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
	 * 	<li>Verify Other Document is in Documents</li>
	 * 	<li>Click on Other</li>
	 * 	<li>Verify file name and uploaded by</li>
	 * 	<li>Verify Sales ContractDocument is in Documents</li>
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
	 * 	<li>Click on Other</li>
	 * 	<li>Verify file name and uploaded by</li>
	 * 	<li>Verify Sales Contract did NOT sync</li>
	 * 	<li>Click Accept/Decline button</li>
	 * 	<li>Enter notes</li>
	 * 	<li>Click OK</li>
	 * 	<li>Close Order Acknowledgement dialog</li>
	 * 	<li>Get order information text</li>
	 * 	<li>Set 40 second while loop timeout</li>
	 * 	<li>Verify audit trail</li>
	 * 	<li>Click Set Order Status</li>
	 * 	<li>Click Delayed</li>
	 * 	<li>Enter Notes</li>
	 * 	<li>Click OK</li>
	 * 	<li>Get order information text</li>
	 * 	<li>Verify audit trail</li>
	 * 	<li>Click Set Order Status</li>
	 * 	<li>Click Resume</li>
	 * 	<li>Enter Notes</li>
	 * 	<li>Click OK</li>
	 * 	<li>Get order information text</li>
	 * 	<li>Verify audit trail</li>
	 * 	<li>If browser is IE, set require window focus capability to false</li>
	 * 	<li>if (StoredVariables.getbrowser().get().equals("IE"))</li>
	 * 	<li>{</li>
	 * 	<li></li>
	 * 	<li>perform.IE_setRequireWindowFocusToFalse();</li>
	 * 	<li></li>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>vendors.loginToVendors("Appraiser3", StoredVariables.getpassword().get());</li>
	 * 	<li></li>
	 * 	<li>Search for order</li>
	 * 	<li>vendors.findOrderOnVendors(StoredVariables.getorderNumberAMC().get(), "Tracking Number");</li>
	 * 	<li></li>
	 * 	<li>Verify order status</li>
	 * 	<li>Assert.assertTrue(VOrders.ordersGrid_txt(driver).getText().contains("In Progress"), "The order is not in the correct status");</li>
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
	 * 	<li>Upload Market Information document</li>
	 * 	<li>Click Attach Documents button</li>
	 * 	<li>Select document type</li>
	 * 	<li>Upload test pdf file</li>
	 * 	<li>Click Close Button</li>
	 * 	<li>Verify Other is in the Order Documents pane twice</li>
	 * 	<li>Create boolean for both Other documents</li>
	 * 	<li>Get Number Of Other documents</li>
	 * 	<li>List&lt;WebElement&gt; docs = driver.findElements(By.xpath("td[text()='Other']"));</li>
	 * 	<li>Click first Other document</li>
	 * 	<li>Verify Uploaded By and Document Name</li>
	 * 	<li>Verify Uploaded By and Document Name</li>
	 * 	<li>Click Market Information</li>
	 * 	<li>Verify Uploaded By and Document Name</li>
	 * 	<li>Get order information text</li>
	 * 	<li>Verify audit trail</li>
	 * 	<li>If browser is IE, re-establish capabilities</li>
	 * 	<li>if (StoredVariables.getbrowser().get().equals("IE"))</li>
	 * 	<li>{</li>
	 * 	<li>perform.IE_reEstablishCapabilities();</li>
	 * 	<li>}</li>
	 * 	<li>If browser is IE, set require window focus capability to false</li>
	 * 	<li>if (StoredVariables.getbrowser().get().equals("IE"))</li>
	 * 	<li>{</li>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>vendors.loginToVendors("Appraiser3", StoredVariables.getpassword().get());</li>
	 * 	<li></li>
	 * 	<li>Search for order</li>
	 * 	<li>vendors.findOrderOnVendors(StoredVariables.getorderNumberAMC().get(), "Tracking Number");</li>
	 * 	<li></li>
	 * 	<li>Verify order status</li>
	 * 	<li>Assert.assertTrue(VOrders.ordersGrid_txt(driver).getText().contains("In Progress"), "The order is not in the correct status");</li>
	 * 	<li></li>
	 * 	<li>Click on the order from the orders grid</li>
	 * 	<li>perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());</li>
	 * 	<li></li>
	 * 	<li>}</li>
	 * 	<li>Click Message</li>
	 * 	<li>Add notes</li>
	 * 	<li>Click Send button</li>
	 * 	<li>Verify Report is in the Order Documents pane</li>
	 * 	<li>Verify audit trail</li>
	 * 	<li>Verify audit trail</li>
	 * 	<li>If browser is Firefox, skip this method</li>
	 * 	<li>Log a skip in the extent report</li>
	 * 	<li>View XSite order</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Verify documents</li>
	 * 	<li>Verify comments</li>
	 * 	<li>Close XSite order</li>
	 * 	<li>Login to VMP Client Portal</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify the audit trail</li>
	 * 	<li>Verify the order details</li>
	 * 	<li>Verify Document is in Documents</li>
	 * 	<li>Click on Sales Contract</li>
	 * 	<li>Verify file name and uploaded by</li>
	 * 	<li>Create boolean for both Other documents</li>
	 * 	<li>Get Number Of Other documents</li>
	 * 	<li>docs = driver.findElements(By.xpath("td[text()='Other']"));</li>
	 * 	<li>Click first Other document</li>
	 * 	<li>Verify Uploaded By and Document Name</li>
	 * 	<li>Verify Uploaded By and Document Name</li>
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
	 * 	<li>Create boolean for both Other documents</li>
	 * 	<li>Get Number Of Other documents</li>
	 * 	<li>docs = driver.findElements(By.xpath("td[text()='Other']"));</li>
	 * 	<li>Click first Other document</li>
	 * 	<li>Verify Uploaded By and Document Name</li>
	 * 	<li>Verify Uploaded By and Document Name</li>
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
	 * 	<li>Get comments</li>
	 * 	<li>Verify both VMP and MN comments are displayed</li>
	 * 	<li>View Order Details</li>
	 * 	<li>Verify Document is in Documents</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify Other Document is in Documents</li>
	 * 	<li>Click Set status</li>
	 * 	<li>Click Change due date</li>
	 * 	<li>Click the Order due calendar button</li>
	 * 	<li>Change the date to 10 days out</li>
	 * 	<li>Set new order due date</li>
	 * 	<li>Enter comments</li>
	 * 	<li>Check Update the due date on the VMP XSite and notify client checkbox</li>
	 * 	<li>Click Set date</li>
	 * 	<li>Click Set status</li>
	 * 	<li>Click Change fee</li>
	 * 	<li>Change the fee to $525</li>
	 * 	<li>Enter comments</li>
	 * 	<li>Click Set Fee</li>
	 * 	<li>If browser is Firefox, skip this method</li>
	 * 	<li>Log a skip in the extent report</li>
	 * 	<li>View XSite order</li>
	 * 	<li>Get history text</li>
	 * 	<li>Recapture the text from the history</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Verify documents</li>
	 * 	<li>Verify comments</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Close XSite order</li>
	 * 	<li>Login to VMP Client Portal</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify the audit trail</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Verify the order details</li>
	 * 	<li>Verify Document is in Documents</li>
	 * 	<li>Click on Sales Contract</li>
	 * 	<li>Verify file name and uploaded by</li>
	 * 	<li>Create boolean for both Other documents</li>
	 * 	<li>Get Number Of Other documents</li>
	 * 	<li>docs = driver.findElements(By.xpath("td[text()='Other']"));</li>
	 * 	<li>Click first Other document</li>
	 * 	<li>Verify Uploaded By and Document Name</li>
	 * 	<li>Verify Uploaded By and Document Name</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Verify Other Document is in Documents</li>
	 * 	<li>Verify Sales ContractDocument is in Documents</li>
	 * 	<li>Click on Sales Contract</li>
	 * 	<li>Verify file name and uploaded by</li>
	 * 	<li>Create boolean for both Other documents</li>
	 * 	<li>Get Number Of Other documents</li>
	 * 	<li>docs = driver.findElements(By.xpath("td[text()='Other']"));</li>
	 * 	<li>Click first Other document</li>
	 * 	<li>Verify Uploaded By and Document Name</li>
	 * 	<li>Verify Uploaded By and Document Name</li>
	 * 	<li>If browser is Firefox, skip this method</li>
	 * 	<li>Log a skip in the extent report</li>
	 * 	<li>View XSite order</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Verify documents</li>
	 * 	<li>Verify comments</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Close XSite order</li>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify order status</li>
	 * 	<li>Click on the order from the orders grid</li>
	 * 	<li>Get order information text</li>
	 * 	<li>Verify audit trail</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Get comments</li>
	 * 	<li>Verify both VMP and MN comments are displayed</li>
	 * 	<li>View Order Details</li>
	 * 	<li>Verify Document is in Documents</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify order details0</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Verify Other Document is in Documents</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Click Set status</li>
	 * 	<li>Click Change due date</li>
	 * 	<li>Click the Order due calendar button</li>
	 * 	<li>Change the date to 12 days out</li>
	 * 	<li>Set new order due date</li>
	 * 	<li>Enter comments</li>
	 * 	<li>Check Update the due date on the VMP XSite and notify client checkbox</li>
	 * 	<li>Click Set date</li>
	 * 	<li>Click Set status</li>
	 * 	<li>Click Change fee</li>
	 * 	<li>Change the fee to $525</li>
	 * 	<li>Enter comments</li>
	 * 	<li>Click Set Fee</li>
	 * 	<li>If browser is Firefox, skip this method</li>
	 * 	<li>Log a skip in the extent report</li>
	 * 	<li>View XSite order</li>
	 * 	<li>Get history text</li>
	 * 	<li>Recapture the text from the history</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Verify documents</li>
	 * 	<li>Verify comments</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Close XSite order</li>
	 * 	<li>Login to VMP Client Portal</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify the audit trail</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Verify the order details</li>
	 * 	<li>Verify Document is in Documents</li>
	 * 	<li>Click on Sales Contract</li>
	 * 	<li>Verify file name and uploaded by</li>
	 * 	<li>Create boolean for both Other documents</li>
	 * 	<li>Get Number Of Other documents</li>
	 * 	<li>docs = driver.findElements(By.xpath("td[text()='Other']"));</li>
	 * 	<li>Click first Other document</li>
	 * 	<li>Verify Uploaded By and Document Name</li>
	 * 	<li>Verify Uploaded By and Document Name</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Verify Other Document is in Documents</li>
	 * 	<li>Verify Sales ContractDocument is in Documents</li>
	 * 	<li>Click on Sales Contract</li>
	 * 	<li>Verify file name and uploaded by</li>
	 * 	<li>Create boolean for both Other documents</li>
	 * 	<li>Get Number Of Other documents</li>
	 * 	<li>docs = driver.findElements(By.xpath("td[text()='Other']"));</li>
	 * 	<li>Click first Other document</li>
	 * 	<li>Verify Uploaded By and Document Name</li>
	 * 	<li>Verify Uploaded By and Document Name</li>
	 * 	<li>If browser is Firefox, skip this method</li>
	 * 	<li>Log a skip in the extent report</li>
	 * 	<li>View XSite order</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Verify documents</li>
	 * 	<li>Verify comments</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Close XSite order</li>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify order status</li>
	 * 	<li>Click on the order from the orders grid</li>
	 * 	<li>Get order information text</li>
	 * 	<li>Verify audit trail</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Get comments</li>
	 * 	<li>Verify both VMP and MN comments are displayed</li>
	 * 	<li>View Order Details</li>
	 * 	<li>Verify Document is in Documents</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Verify Other Document is in Documents</li>
	 * 	<li>If browser is Firefox, skip the rest of the test</li>
	 * 	<li>Log a skip in the extent report</li>
	 * 	<li>View XSite order</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Verify documents</li>
	 * 	<li>Verify comments</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Click Edit</li>
	 * 	<li>Get due date</li>
	 * 	<li>Get the FHA Case Number</li>
	 * 	<li>Get the Loan Number</li>
	 * 	<li>Get a new date to enter as the new due date</li>
	 * 	<li>Edit the order date</li>
	 * 	<li>Edit the FHA Case Number</li>
	 * 	<li>Edit the Loan Number</li>
	 * 	<li>Click OK</li>
	 * 	<li>Click FHA Case Number checkbox</li>
	 * 	<li>Click Lender Case Number checkbox</li>
	 * 	<li>Click OK</li>
	 * 	<li>Verify first row text</li>
	 * 	<li>Get Due Date and verify it changed</li>
	 * 	<li>Get FHA Number and verify it changed</li>
	 * 	<li>Get Loan Number and verify it changed</li>
	 * 	<li>Verify the Due Date is the new Due Date</li>
	 * 	<li>Verify the FHA Number is the new FHA Number</li>
	 * 	<li>Verify the Loan Number is the new Loan Number</li>
	 * 	<li>Click the Edit button</li>
	 * 	<li>Verify the new Due Date</li>
	 * 	<li>Verify the new FHA Case Number</li>
	 * 	<li>Verify the new Loan Number</li>
	 * 	<li>Set due date back to what it was</li>
	 * 	<li>Set the Due Date back to it's original date</li>
	 * 	<li>Set the FHA Case Number back to it's original number</li>
	 * 	<li>Set the Loan Number back to it's original number</li>
	 * 	<li>Verify the original Due Date</li>
	 * 	<li>Verify the original FHA Case Number</li>
	 * 	<li>Verify the original Loan Number</li>
	 * 	<li>Click OK</li>
	 * 	<li>Click FHA Case Number checkbox</li>
	 * 	<li>Click Lender Case Number checkbox</li>
	 * 	<li>Click OK</li>
	 * 	<li>Verify first row text</li>
	 * 	<li>Get Due Date and verify it changed</li>
	 * 	<li>Get FHA Number and verify it changed</li>
	 * 	<li>Get Loan Number and verify it changed</li>
	 * 	<li>Verify the Due Date is the new Due Date</li>
	 * 	<li>Verify the FHA Number is the new FHA Number</li>
	 * 	<li>Verify the Loan Number is the new Loan Number</li>
	 * 	<li>Click Message button</li>
	 * 	<li>Go to new window</li>
	 * 	<li>Get and pass the Window Handle for Send Message</li>
	 * 	<li>Switch to the new window</li>
	 * 	<li>Enter message</li>
	 * 	<li>Click Save</li>
	 * 	<li>Switch to the XSite window</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Click Status</li>
	 * 	<li>Go to new window</li>
	 * 	<li>Get and pass the Window Handle for Send Message</li>
	 * 	<li>Switch to the new window</li>
	 * 	<li>Select Comment - Action Required</li>
	 * 	<li>Enter message</li>
	 * 	<li>Click Save</li>
	 * 	<li>Switch to the XSite window</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Close XSite order</li>
	 * 	<li>View XSite order</li>
	 * 	<li>Get history text</li>
	 * 	<li>Recapture the text from the history</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Verify documents</li>
	 * 	<li>Verify comments</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Close XSite order</li>
	 * 	<li>Login to VMP Client Portal</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify the audit trail</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Verify the order details</li>
	 * 	<li>Verify Document is in Documents</li>
	 * 	<li>Click on Sales Contract</li>
	 * 	<li>Verify file name and uploaded by</li>
	 * 	<li>Create boolean for both Other documents</li>
	 * 	<li>Get Number Of Other documents</li>
	 * 	<li>docs = driver.findElements(By.xpath("td[text()='Other']"));</li>
	 * 	<li>Click first Other document</li>
	 * 	<li>Verify Uploaded By and Document Name</li>
	 * 	<li>Verify Uploaded By and Document Name</li>
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
	 * 	<li>Click Set Order Status</li>
	 * 	<li>Click Inspection Complete</li>
	 * 	<li>Click the calendar button</li>
	 * 	<li>Select date</li>
	 * 	<li>Verify the correct order due date is correct</li>
	 * 	<li>Add notes</li>
	 * 	<li>Click OK</li>
	 * 	<li>Click Message</li>
	 * 	<li>Add notes</li>
	 * 	<li>Click OK button</li>
	 * 	<li>If browser is IE, set require window focus capability to false</li>
	 * 	<li>if (StoredVariables.getbrowser().get().equals("IE"))</li>
	 * 	<li>{</li>
	 * 	<li></li>
	 * 	<li>perform.IE_setRequireWindowFocusToFalse();</li>
	 * 	<li></li>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>vendors.loginToVendors("Appraiser3", StoredVariables.getpassword().get());</li>
	 * 	<li></li>
	 * 	<li>Search for order</li>
	 * 	<li>vendors.findOrderOnVendors(StoredVariables.getorderNumber().get(), "Tracking Number");</li>
	 * 	<li></li>
	 * 	<li>Verify order status</li>
	 * 	<li>Assert.assertTrue(VOrders.ordersGrid_txt(driver).getText().contains("Revision Needed"), "The order is not in the correct status");</li>
	 * 	<li></li>
	 * 	<li>Click on the order from the orders grid</li>
	 * 	<li>perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());</li>
	 * 	<li></li>
	 * 	<li>perform.waitForElementToBeVisible(driver, VOrderDetails.sendMessage_btn(), "cssSelector");</li>
	 * 	<li></li>
	 * 	<li>Thread.sleep(1000);</li>
	 * 	<li></li>
	 * 	<li>Complete the order using the HTTP Post</li>
	 * 	<li>Get order information text</li>
	 * 	<li>Verify audit trail</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Get comments</li>
	 * 	<li>Verify both VMP and MN comments are displayed</li>
	 * 	<li>View Order Details</li>
	 * 	<li>Verify Document is in Documents</li>
	 * 	<li>Click Sales Contract</li>
	 * 	<li>Verify Uploaded By and Document Name</li>
	 * 	<li>Click Sales Contract</li>
	 * 	<li>Verify Uploaded By and Document Name</li>
	 * 	<li>If browser is IE, re-establish capabilites</li>
	 * 	<li>if (StoredVariables.getbrowser().get().equals("IE"))</li>
	 * 	<li>{</li>
	 * 	<li>perform.IE_reEstablishCapabilities();</li>
	 * 	<li>}</li>
	 * 	<li>View XSite order</li>
	 * 	<li>Get history text</li>
	 * 	<li>Recapture the text from the history</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Verify documents</li>
	 * 	<li>Verify comments</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Close XSite order</li>
	 * 	<li>Login to VMP Client Portal</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify the audit trail</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Verify the order details</li>
	 * 	<li>Verify Document is in Documents</li>
	 * 	<li>Click on Sales Contract</li>
	 * 	<li>Verify file name and uploaded by</li>
	 * 	<li>Create boolean for both Other documents</li>
	 * 	<li>Get Number Of Other documents</li>
	 * 	<li>docs = driver.findElements(By.xpath("td[text()='Other']"));</li>
	 * 	<li>Click first Other document</li>
	 * 	<li>Verify Uploaded By and Document Name</li>
	 * 	<li>Verify Uploaded By and Document Name</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Verify Other Document is in Documents</li>
	 * 	<li>Verify Sales ContractDocument is in Documents</li>
	 * 	<li>Click on Sales Contract</li>
	 * 	<li>Verify file name and uploaded by</li>
	 * 	<li>Create boolean for both Other documents</li>
	 * 	<li>Get Number Of Other documents</li>
	 * 	<li>docs = driver.findElements(By.xpath("td[text()='Other']"));</li>
	 * 	<li>Click first Other document</li>
	 * 	<li>Verify Uploaded By and Document Name</li>
	 * 	<li>Verify Uploaded By and Document Name</li>
	 * 	<li>View XSite order</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Verify documents</li>
	 * 	<li>Verify comments</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Close XSite order</li>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify order status</li>
	 * 	<li>Click on the order from the orders grid</li>
	 * 	<li>Get order information text</li>
	 * 	<li>Verify audit trail</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Get comments</li>
	 * 	<li>Verify both VMP and MN comments are displayed</li>
	 * 	<li>View Order Details</li>
	 * 	<li>Verify Document is in Documents</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify order details0</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Verify Other Document is in Documents</li>
* </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"EVF", "Secure - VMP XSite Settings", "Secure - Configure Automatic Settings", "Secure - Configure Status Mapping", "Secure - Compliance Certificate", "Secure - Vendor Selection Settings", 
			"VMP - Create Order", "Secure - Orders", "Secure - Edit Order", "Vendors - Orders", "VMP - Orders", "VMP - Place On Hold", "VMP - Resume", "VMP - Delayed", "VMP - Send Message", "XSite - Order Details", "Vendors - Accept Order", 
			"Vendors Set Order Status", "Vendors - Delayed", "Vendors - Resume", "Vendors - Send Message", "Secure - Set Status", "Secure - Change Due Date", "Secure - Change Fee", "XSite - Edit Order", "XSite - Message", "XSite - Comment - Action Required", 
			"Vendors - Inspection Scheduled", "Vendors - Inspection Complete", "Vendors - Complete Order"}, alwaysRun=true)
	public void firstOrder() throws Exception {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		secure.login(driver, "EVFAMC", StoredVariables.getpassword().get());
		
		perform.waitForElementToBeClickable(driver, SOrders.preferences_btn(), "id");
		
		perform.click(driver,SOrders.preferences_btn(driver));
		
		perform.waitForElementToBeClickable(driver, SPreferences.vmpXSites_btn(), "cssSelector");
		
		perform.click(driver,SPreferences.vmpXSites_btn(driver));
		
		// Verify the dropdown is the correct VMP site
		secure.verifyXSiteURLDropdownValue(driver, "EVFAMC");
		
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
		perform.click(driver,SVMPXSites.documentUploadedAppraiserClientGearIcon2_btn(driver));
		
		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		// Check every option for syncing
		perform.enableAllCheckboxesToSyncToVMP(driver);
		
		// Wait for Market Information
		perform.waitForElementToBeClickable(driver, SVMPXSites.marketInformation_chkbx(), "id");
		
		// Uncheck Market Information
		if (SVMPXSites.marketInformation_chkbx(driver).getAttribute("checked").equals("true"))
		{
			// Uncheck Market Information
			perform.clickLabelText(driver, "Market Information");
		} // end if
		
		// Click OK
		perform.click(driver,SVMPXSites.okSyncToVMPCheckboxesClient_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Click the Vendor Document Upload gear icon
		perform.click(driver,SVMPXSites.documentUploadedAppraiserVendorGearIconAsAMC2_btn(driver));
		
		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for Sales Contract
		perform.waitForElementToBeClickable(driver, SVMPXSites.salesContract_chkbx(), "id");
		
		// Uncheck Sales Contract
		if (SVMPXSites.salesContract_chkbx(driver).getAttribute("checked").equals("true"))
		{
			// Uncheck Sales Contract
			perform.click(driver,SVMPXSites.salesContract_txt(driver));
		} // end if
		
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
		String env = StoredVariables.getusernameEnvironment().get();
		
		String getAWSAccountsIDSQL = "SELECT AWSAccountsID FROM ULSAccounts u JOIN Entities e ON u.AppraiserEntityID = e.EntityID "
				+ "WHERE CompanyName = 'Automation" + env + "EVFAMC' AND EntityTypeID = 32";		
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
	            		if (Description.equals("Vendor Accepted Assignment")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite\n" + getSyncStatusSQL);}
	            		if (Description.equals("Inspection Scheduled")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite\n" + getSyncStatusSQL);}
	            		if (Description.equals("Inspection Complete")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite\n" + getSyncStatusSQL);}
	            		if (Description.equals("Delayed")){Assert.assertTrue(SyncDirection.equals("Sync to Both"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync to Both\n" + getSyncStatusSQL);}
	            		if (Description.equals("Resumed")){Assert.assertTrue(SyncDirection.equals("Sync to Both"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync to Both\n" + getSyncStatusSQL);}
	            		if (Description.equals("Document Uploaded")){Assert.assertTrue(SyncDirection.equals("Sync to Both"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync to Both\n" + getSyncStatusSQL);}
	            		if (Description.equals("Cancelled")){Assert.assertTrue(SyncDirection.equals("Sync to Both"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync to Both\n" + getSyncStatusSQL);}
	            		if (Description.equals("Pending Quality Review")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite\n" + getSyncStatusSQL);}
	            		if (Description.equals("Copy of Completed Appraisal E-mailed to Borrower")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite\n" + getSyncStatusSQL);}
	            		if (Description.equals("Appraisal Viewed by {0}")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite\n" + getSyncStatusSQL);}
	            		if (Description.equals("{0} <b>declined</b> to receive the appraisal electronically")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite\n" + getSyncStatusSQL);}
	            		if (Description.equals("{0} consented to receive the appraisal electronically")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite\n" + getSyncStatusSQL);}
	            		if (Description.equals("SureReceipts delivery to Borrower scheduled")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite\n" + getSyncStatusSQL);}
	            		if (Description.equals("Update Disclosure Date")){Assert.assertTrue(SyncDirection.equals("Sync to Mercury"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync to Mercury\n" + getSyncStatusSQL);}
	            		if (Description.equals("Appraisal Submitted to {0} via UCDP")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite\n" + getSyncStatusSQL);}
	            		if (Description.equals("Appraisal Submission Accepted by {0} via UCDP")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite\n" + getSyncStatusSQL);}
	            		if (Description.equals("Appraisal Submission to {0} Not Successful")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite\n" + getSyncStatusSQL);}
	            		if (Description.equals("UCDP Document File ID Updated")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite\n" + getSyncStatusSQL);}
	            		if (Description.equals("UCDP Status Removed")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite\n" + getSyncStatusSQL);}
	            		if (Description.equals("AQI results returned ")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite\n" + getSyncStatusSQL);}
	            		if (Description.equals("Appraisal Submitted to FHA via EAD")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite\n" + getSyncStatusSQL);}
	            		if (Description.equals("Appraisal Submission Accepted by FHA via EAD")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite\n" + getSyncStatusSQL);}
	            		if (Description.equals("Appraisal Submission to FHA Not Successful")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite\n" + getSyncStatusSQL);}
	            		if (Description.equals("FHA Document File ID Updated")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite\n" + getSyncStatusSQL);}
	            		if (Description.equals("FHA Status Removed")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite\n" + getSyncStatusSQL);}
	            		if (Description.equals("Message")){Assert.assertTrue(SyncDirection.equals("Sync to Both"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync to Both\n" + getSyncStatusSQL);}
	            		if (Description.equals("Conditionally Declined")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite\n" + getSyncStatusSQL);}

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
		
		// Click Preferences
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
		
		// Wait for the OK button to be visible
		perform.waitForElementToBeClickable(driver, SVendorSelectionSettings.ok_btn(), "id");
		
		// Click OK in saved dialog box
		perform.click(driver,SVendorSelectionSettings.ok_btn(driver));
		
		// Set AMC Company
		amcCompany = "Automation"+env+"EVFAMC";

		secure.login(driver, "EVFLender", StoredVariables.getpassword().get());
		
		perform.waitForElementToBeClickable(driver, SOrders.preferences_btn(), "id");
		
		perform.click(driver,SOrders.preferences_btn(driver));
		
		perform.waitForElementToBeClickable(driver, SPreferences.vmpXSites_btn(), "cssSelector");
		
		perform.click(driver,SPreferences.vmpXSites_btn(driver));
		
		// Verify the dropdown is the correct VMP site
		secure.verifyXSiteURLDropdownValue(driver, "EVFLender");
		
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
		
		// Uncheck Pending Quality Review
		secure.setStatusMapping(driver, "Pending Quality Review", "none");
		
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
		getAWSAccountsIDSQL = "SELECT AWSAccountsID FROM ULSAccounts u JOIN Entities e ON u.AppraiserEntityID = e.EntityID "
				+ "WHERE CompanyName = 'Automation" + env + "EVFLender' AND EntityTypeID = 1";		
		StoredVariables.getAWSAccountsID().set(db.queryDB(driver, "Mercury", getAWSAccountsIDSQL));
		
		// Set the DB Connection String
		dbUrl = perform.setDBConnectionString(driver, "Mercury");
		
		// Get sync statuses
		getSyncStatusSQL = "SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED SELECT UA.SyncStatus, UA.SyncStatusXSite, LS.[Description], "
				+ "CASE SSP.SyncFromBitMask WHEN 0 THEN 'Does Not Sync' WHEN 1 THEN 'Sync To VMP XSite' WHEN 2 THEN 'Sync to Mercury' "
				+ "WHEN 3 THEN 'Sync to Both' END AS 'SyncDirection' FROM Mercury.dbo.ULS_StatusSyncPrefs SSP JOIN Mercury.dbo.ListStatus LS "
				+ "ON LS.ListStatusID = SSP.ListStatusID JOIN Mercury.dbo.ULSAccounts UA ON UA.AppraiserEntityID = SSP.AppraiserEntityID "
				+ "WHERE 1=1 AND UA.AWSAccountsID = '" + StoredVariables.getAWSAccountsID().get() + "'";
		
		System.out.println("getSyncStatusSQL = " + getSyncStatusSQL);

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
	            		if (Description.equals("Vendor Accepted Assignment")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite\n" + getSyncStatusSQL);}
	            		if (Description.equals("Inspection Scheduled")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite\n" + getSyncStatusSQL);}
	            		if (Description.equals("Inspection Complete")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite\n" + getSyncStatusSQL);}
	            		if (Description.equals("Delayed")){Assert.assertTrue(SyncDirection.equals("Sync to Both"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync to Both\n" + getSyncStatusSQL);}
	            		if (Description.equals("Resumed")){Assert.assertTrue(SyncDirection.equals("Sync to Both"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync to Both\n" + getSyncStatusSQL);}
	            		if (Description.equals("Document Uploaded")){Assert.assertTrue(SyncDirection.equals("Sync to Both"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync to Both\n" + getSyncStatusSQL);}
	            		if (Description.equals("Cancelled")){Assert.assertTrue(SyncDirection.equals("Sync to Both"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync to Both\n" + getSyncStatusSQL);}
	            		if (Description.equals("Copy of Completed Appraisal E-mailed to Borrower")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite\n" + getSyncStatusSQL);}
	            		if (Description.equals("Appraisal Viewed by {0}")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite\n" + getSyncStatusSQL);}
	            		if (Description.equals("{0} <b>declined</b> to receive the appraisal electronically")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite\n" + getSyncStatusSQL);}
	            		if (Description.equals("{0} consented to receive the appraisal electronically")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite\n" + getSyncStatusSQL);}
	            		if (Description.equals("SureReceipts delivery to Borrower scheduled")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite\n" + getSyncStatusSQL);}
	            		if (Description.equals("Update Disclosure Date")){Assert.assertTrue(SyncDirection.equals("Sync to Mercury"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync to Mercury\n" + getSyncStatusSQL);}
	            		if (Description.equals("Appraisal Submitted to {0} via UCDP")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite\n" + getSyncStatusSQL);}
	            		if (Description.equals("Appraisal Submission Accepted by {0} via UCDP")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite\n" + getSyncStatusSQL);}
	            		if (Description.equals("Appraisal Submission to {0} Not Successful")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite\n" + getSyncStatusSQL);}
	            		if (Description.equals("UCDP Document File ID Updated")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite\n" + getSyncStatusSQL);}
	            		if (Description.equals("UCDP Status Removed")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite\n" + getSyncStatusSQL);}
	            		if (Description.equals("AQI results returned ")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite\n" + getSyncStatusSQL);}
	            		if (Description.equals("Appraisal Submitted to FHA via EAD")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite\n" + getSyncStatusSQL);}
	            		if (Description.equals("Appraisal Submission Accepted by FHA via EAD")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite\n" + getSyncStatusSQL);}
	            		if (Description.equals("Appraisal Submission to FHA Not Successful")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite\n" + getSyncStatusSQL);}
	            		if (Description.equals("FHA Document File ID Updated")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite\n" + getSyncStatusSQL);}
	            		if (Description.equals("FHA Status Removed")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite\n" + getSyncStatusSQL);}
	            		if (Description.equals("Message")){Assert.assertTrue(SyncDirection.equals("Sync to Both"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync to Both\n" + getSyncStatusSQL);}
	            		if (Description.equals("Conditionally Declined")){Assert.assertTrue(SyncDirection.equals("Sync To VMP XSite"), "TheSyncDirection for " + Description + " is " + SyncDirection + " and should be - Sync To VMP XSite\n" + getSyncStatusSQL);}

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
		vmp.login(driver, "EVFLender", "OriginatorEVF", StoredVariables.getpassword().get());
		
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
		StoredVariables.getpropertyInformationLegalDesc().set("245 W Chantilly Way, Mustang, OK 73064");
		StoredVariables.getpropertyInformationDirections().set("East of N May Ave and south of NW Britton Rd");
		
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
		StoredVariables.getassignmentInformationAssignedTo().set("Automation OriginatorEVF");
		
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

		// Click Next
		perform.click(driver,VMPConfirmOrder.nextTop_btn(driver));
		
		Thread.sleep(10000);
		
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for message text
		try {
			// Get inside the attach document frame
			perform.waitForiFrameSrcAndSwitchToIt(driver, "AttachDocument.aspx", By.id(VMPConfirmOrder.uploadDocuments_btn()));
			perform.waitForElementToBeClickable(driver, VMPConfirmOrder.uploadDocuments_btn(), "id");
		} catch (Exception e) {
			driver.switchTo().defaultContent();
			// Get inside the attach document frame
			perform.waitForiFrameSrcAndSwitchToIt(driver, "AttachDocument.aspx", By.id(VMPConfirmOrder.uploadDocuments_btn()));
			perform.waitForElementToBeClickable(driver, VMPConfirmOrder.uploadDocuments_btn(), "id");
		} // end try/catch
		
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

		db.verifyNewOrderDataInDB_All(driver, StoredVariables.getloanIDVMP().get());

		// Log in to Secure
		secure.login(driver, "EVFAMC", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, StoredVariables.getloanIDAMC().get(), "Tracking number");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("Requires assignment"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getAWSAccountsID().get() + "-" + StoredVariables.getloanIDAMC().get());
		
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
		
		// Select Automation Appraiser3
		perform.click(driver,driver.findElement(By.cssSelector("img[src='/images/Checkmark-Small-Unchecked.O.png']")));
		
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
		Assert.assertTrue(historyText.contains("Reassigned by Client (Automation EVFAMC) to Automation Appraiser3"), "Reassigned by Client (Automation EVFAMC) to Automation Appraiser3 is missing from the audit trail");
		Assert.assertTrue(historyText.contains("Order Changed by Client (Automation EVFAMC)"), "Order Changed by Client (Automation EVFAMC) is missing from the audit trail");
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

		// Login to VMP Client Portal
		vmp.login(driver, "EVFLender", "OriginatorEVF", StoredVariables.getpassword().get());
		
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
		Assert.assertTrue(VMPAppraisalOrderDetails.history_txt(driver).getText().contains("In Progress by Automation OriginatorEVF"), "In Progress by Automation OriginatorEVF is missing from the audit trail");
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
		perform.type(driver,VMPAppraisalOrderDetails.placeOnHoldNotes_txtbx(driver), "These are Place On Hold test notes from OriginatorEVF");
		
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
		Assert.assertTrue(history.contains("On Hold by Automation OriginatorEVF"), "On Hold by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("In Progress by Automation OriginatorEVF"), "In Progress by Automation OriginatorEVF is missing from the audit trail");

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
		perform.type(driver,VMPAppraisalOrderDetails.resumeNotes_txtbx(driver), "These are Resume test notes from OriginatorEVF");
		
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
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorEVF"), "Resumed by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Automation OriginatorEVF"), "On Hold by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("In Progress by Automation OriginatorEVF"), "In Progress by Automation OriginatorEVF is missing from the audit trail");

		// Click Other Actions
		perform.click(driver,VMPAppraisalOrderDetails.otherActions_btn(driver));
		
		// Click Delayed
		perform.click(driver,VMPAppraisalOrderDetails.delayed_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, VMPAppraisalOrderDetails.delayedOk_btn(), "cssSelector");
		
		// Add notes
		perform.type(driver,VMPAppraisalOrderDetails.delayedNotes_txtbx(driver), "These are Delayed test notes from OriginatorEVF");
		
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
		Assert.assertTrue(history.contains("Delayed by Automation OriginatorEVF"), "Delayed by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorEVF"), "Resumed by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Automation OriginatorEVF"), "On Hold by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("In Progress by Automation OriginatorEVF"), "In Progress by Automation OriginatorEVF is missing from the audit trail");

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
		Assert.assertTrue(VMPAppraisalOrderDetails.attachedDocumentName_txt(driver).getText().equals("Test PDF.pdf"), "The document didn't get uploaded. The name = " + VMPAppraisalOrderDetails.attachedDocumentName_txt(driver).getText());
		
		// Verify uploaded by is correct
		Assert.assertTrue(VMPAppraisalOrderDetails.attachedDocumentUploadedBy_txt(driver).getText().equals("Automation OriginatorEVF"), "The Uploaded By name is incorrect. It is - " + VMPAppraisalOrderDetails.attachedDocumentUploadedBy_txt(driver).getText());
		
		// Verify history
		history = VMPAppraisalOrderDetails.history_txt(driver).getText();
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorEVF"), "Document Uploaded by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Sales Contract"), "Sales Contract is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF.pdf"), "Test PDF.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation OriginatorEVF"), "Delayed by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorEVF"), "Resumed by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Automation OriginatorEVF"), "On Hold by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("In Progress by Automation OriginatorEVF"), "In Progress by Automation OriginatorEVF is missing from the audit trail");

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
		Assert.assertTrue(VMPAppraisalOrderDetails.attachedDocumentUploadedBy_txt(driver).getText().equals("Automation OriginatorEVF"), "The Uploaded By name is incorrect. It is - " + VMPAppraisalOrderDetails.attachedDocumentUploadedBy_txt(driver).getText());
		
		// Verify history
		history = VMPAppraisalOrderDetails.history_txt(driver).getText();
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorEVF"), "Document Uploaded by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Other"), "Other is missing from the audit trail");
		Assert.assertTrue(history.contains("TestPDF.pdf"), "TestPDF.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorEVF"), "Document Uploaded by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Sales Contract"), "Sales Contract is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF.pdf"), "Test PDF.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation OriginatorEVF"), "Delayed by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorEVF"), "Resumed by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Automation OriginatorEVF"), "On Hold by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("In Progress by Automation OriginatorEVF"), "In Progress by Automation OriginatorEVF is missing from the audit trail");

		// Wait for Send Message button
		perform.waitForElementToBeVisible(driver, VMPAppraisalOrderDetails.sendMessage_btn(), "cssSelector");
		
		// Click Send Message
		perform.click(driver,VMPAppraisalOrderDetails.sendMessage_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for Send button
		perform.waitForElementToBeClickable(driver, VMPAppraisalOrderDetails.send_btn(), "cssSelector");
		
		// Add notes
		perform.type(driver,VMPAppraisalOrderDetails.sendMessage_txtbx(driver), "These are test Send Message notes from OriginatorEVF");
		
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
		Assert.assertTrue(history.contains("Message by Automation OriginatorEVF"), "Message by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorEVF"), "Document Uploaded by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Other"), "Other is missing from the audit trail");
		Assert.assertTrue(history.contains("TestPDF.pdf"), "TestPDF.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorEVF"), "Document Uploaded by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Sales Contract"), "Sales Contract is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF.pdf"), "Test PDF.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation OriginatorEVF"), "Delayed by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorEVF"), "Resumed by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Automation OriginatorEVF"), "On Hold by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("In Progress by Automation OriginatorEVF"), "In Progress by Automation OriginatorEVF is missing from the audit trail");
		
		// Wait for Send Message button
		perform.waitForElementToBeClickable(driver, VMPAppraisalOrderDetails.sendMessage_btn(), "cssSelector");
		
		// Click Send Message
		perform.click(driver,VMPAppraisalOrderDetails.sendMessage_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for Send button
		perform.waitForElementToBeClickable(driver, VMPAppraisalOrderDetails.send_btn(), "cssSelector");
		
		// Add notes
		perform.type(driver,VMPAppraisalOrderDetails.sendMessage_txtbx(driver), "These are Action Required test notes from OriginatorEVF");
		
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
		Assert.assertTrue(history.contains("Comment - Action Required by Automation OriginatorEVF"), "Comment - Action Required by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation OriginatorEVF"), "Message by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorEVF"), "Document Uploaded by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Other"), "Other is missing from the audit trail");
		Assert.assertTrue(history.contains("TestPDF.pdf"), "TestPDF.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorEVF"), "Document Uploaded by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Sales Contract"), "Sales Contract is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF.pdf"), "Test PDF.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation OriginatorEVF"), "Delayed by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorEVF"), "Resumed by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Automation OriginatorEVF"), "On Hold by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("In Progress by Automation OriginatorEVF"), "In Progress by Automation OriginatorEVF is missing from the audit trail");
		
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
		perform.type(driver,VMPAppraisalOrderDetails.resumeNotes_txtbx(driver), "These are Resume2 test notes from OriginatorEVF");
		
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
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorEVF"), "Resumed by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Automation OriginatorEVF"), "Comment - Action Required by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation OriginatorEVF"), "Message by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorEVF"), "Document Uploaded by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Other"), "Other is missing from the audit trail");
		Assert.assertTrue(history.contains("TestPDF.pdf"), "TestPDF.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorEVF"), "Document Uploaded by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Sales Contract"), "Sales Contract is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF.pdf"), "Test PDF.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation OriginatorEVF"), "Delayed by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorEVF"), "Resumed by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Automation OriginatorEVF"), "On Hold by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("In Progress by Automation OriginatorEVF"), "In Progress by Automation OriginatorEVF is missing from the audit trail");

		// Log in to Secure
		secure.login(driver, "EVFLender", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, StoredVariables.getloanID().get(), "Tracking number");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("In Progress"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getAWSAccountsID().get() + "-" + StoredVariables.getloanID().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Verify order details
		secure.verifyResidentialAppraisalOrderDetails(driver);
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify the history
		Assert.assertTrue(history.contains("History (In Progress)"), "History (In Progress) is missing from the order information");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFLender)"), "Resumed by Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation EVFLender)"), "Comment - Action Required by Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFLender)"), "Message from Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFLender) (TestPDF.pdf)"), "Document Uploaded from Client (Automation EVFLender) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFLender) (Test PDF.pdf)"), "Document Uploaded from Client (Automation EVFLender) (Test PDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Client (Automation EVFLender)"), "Delayed by Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFLender)"), "Resumed by Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Client (Automation EVFLender)"), "On Hold by Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by AMC (" + amcCompany + ")"), "Order Changed by AMC (AutomationQAEVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("To View Change History:"), "To View Change History: is missing from the audit trail");
		Assert.assertTrue(history.contains("Order accepted by AMC (" + amcCompany + ") and In Progress"), "Order accepted by Vendor (Automation EVFAMC) and In Progress is missing from the audit trail");
		Assert.assertTrue(history.contains("Order automatically accepted."), "Order automatically accepted. is missing from the audit trail");
		Assert.assertTrue(history.contains("Order automatically assigned"), "Order automatically assigned is missing from the audit trail");
		Assert.assertTrue(history.contains("Assigned to Automation"), "Assigned to Automation is missing from the audit trail");
		
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
		Assert.assertTrue(documentText.contains("Automation EVFLender"), "Uploaded By is incorrect in Documents");
		
		// Verify Sales ContractDocument is in Documents
		String documentText2 = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText2.contains("Sales Contract"), "Sales Contract did not sync to Secure");
		
		// Click on Sales Contract
		perform.clickInTable_Contains(driver, "Sales Contract");
		
		// Wait for text to update
		perform.waitForText(driver, SOrderDetails.documents_txt(driver), "Test PDF.pdf");
		documentText2 = SOrderDetails.documents_txt(driver).getText();
		
		// Verify file name and uploaded by
		Assert.assertTrue(documentText2.contains("Test PDF.pdf"), "Document name is incorrect in Documents");
		Assert.assertTrue(documentText2.contains("Automation EVFLender"), "Uploaded By is incorrect in Documents");
		
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
			secure.viewXSiteOrderFromSecure(driver, "EVFAMC", StoredVariables.getpassword().get(), StoredVariables.getloanIDAMC().get());
			
			// Get history text
			Thread.sleep(2000);
			perform.waitForElementToBeVisible(driver, XOrders.history_txt(), "id");
			history = XOrders.history_txt(driver).getText();
			String address = StoredVariables.getpropertyInformationAddress().get() + " " + StoredVariables.getpropertyInformationCity().get() + ", " + StoredVariables.getpropertyInformationStateAbbr().get() + " " + StoredVariables.getpropertyInformationZip().get();
			
			// Verify the history
			Assert.assertTrue(history.contains("History (In Progress)"), "History (In Progress) is missing from the order information");
			Assert.assertTrue(history.contains("Resumed (Automation EVFLender)"), "Resumed (Automation EVFLender) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
			Assert.assertTrue(history.contains("Comment - Action Required for " + address), "Comment - Action Required for " + address + " is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
			Assert.assertTrue(history.contains("Message (Automation EVFLender)"), "Message (Automation EVFLender) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
			Assert.assertTrue(history.contains("Document Uploaded (Automation EVFLender) (TestPDF.pdf)"), "Document Uploaded (Automation EVFLender) (TestPDF.pdf) is missing from the audit trail");
			Assert.assertTrue(history.contains("Document Uploaded (Automation EVFLender) (Test PDF.pdf)"), "Document Uploaded (Automation EVFLender) (Test PDF.pdf) is missing from the audit trail");
			Assert.assertTrue(history.contains("Delayed (Automation EVFLender)"), "Delayed (Automation EVFLender) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
			Assert.assertTrue(history.contains("Resumed (Automation EVFLender)"), "Resumed (Automation EVFLender) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
			Assert.assertTrue(history.contains("On Hold (Automation EVFLender)"), "On Hold (Automation EVFLender) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
			Assert.assertTrue(history.contains("Order Changed (Automation EVFAMC)"), "Order Changed (Automation EVFAMC) is missing from the audit trail");
			Assert.assertTrue(history.contains("To View Change History:"), "To View Change History: is missing from the audit trail");
			Assert.assertTrue(history.contains("In Progress (Automation EVFAMC)"), "In Progress (Automation EVFAMC) is missing from the audit trail");
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
		secure.login(driver, "EVFAMC", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, StoredVariables.getloanIDAMC().get(), "Tracking number");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("Awaiting acceptance"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getAWSAccountsID().get() + "-" + StoredVariables.getloanIDAMC().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Verify order details
		secure.verifyResidentialAppraisalOrderDetails(driver);
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify the history
		Assert.assertTrue(history.contains("History (Awaiting acceptance)"), "History (Awaiting acceptance) is missing from the order information");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation EVFAMC)"), "Comment - Action Required by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFAMC)"), "Message from Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Client (Automation EVFAMC)"), "Delayed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Client (Automation EVFAMC)"), "On Hold by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser3"), "Awaiting acceptance by Automation Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Reassigned by Client (Automation EVFAMC) to Automation Appraiser3"), "Reassigned by Client (Automation EVFAMC) to Automation Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by Client (Automation EVFAMC)"), "Order Changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("To View Change History:"), "To View Change History: is missing from the audit trail");
		Assert.assertTrue(history.contains("Requires assignment"), "Requires assignment is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance"), "Awaiting acceptance is missing from the audit trail");
		
		// Verify Other Document is in Documents
		documentText = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Other"), "Other did not sync to Secure");
		
		// Click on Other
		perform.clickInTable_Equals(driver, "Other");
		
		// Wait for text to update
		perform.waitForText(driver, SOrderDetails.documents_txt(driver), "TestPDF.pdf");
		documentText = SOrderDetails.documents_txt(driver).getText();
		
		// Verify file name and uploaded by
		Assert.assertTrue(documentText.contains("TestPDF.pdf"), "Document name is incorrect in Documents");
		Assert.assertTrue(documentText.contains("Automation EVFAMC"), "Uploaded By is incorrect in Documents");
		
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
		history = VOrderDetails.orderInformation_txt(driver).getText();
		
		// Verify audit trail
		Assert.assertTrue(history.contains("History (Awaiting acceptance)"), "History (Awaiting acceptance) is missing from the order information");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation EVFAMC)"), "Comment - Action Required by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFAMC)"), "Message from Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Client (Automation EVFAMC)"), "Delayed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Client (Automation EVFAMC)"), "On Hold by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser3"), "Awaiting acceptance by Automation Appraiser3 is missing from the audit trail");
		
		// Get comments
		additionalComments = VOrderDetails.additionalComments_txt(driver).getText();
		
		// Verify both VMP and MN comments are displayed
		Assert.assertTrue(additionalComments.contains("These are edited comments by EVFAMC"), "Additional Comments section is missing info");
		
		// View Order Details
		vendors.verifyOrderDetails(driver);
		
		// Verify Document is in Documents
		documentText = VOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Other"), "Other did not sync to Vendors");
		
		// Click on Other
		perform.clickInTable_Equals(driver, "Other");
		
		// Wait for text to update
		perform.waitForText(driver, VOrderDetails.documents_txt(driver), "TestPDF.pdf");
		documentText = VOrderDetails.documents_txt(driver).getText();
		
		// Verify file name and uploaded by
		Assert.assertTrue(documentText.contains("TestPDF.pdf"), "Document name is incorrect in Documents");
		Assert.assertTrue(documentText.contains("Automation EVFAMC"), "Uploaded By is incorrect in Documents");
		
		// Verify Sales Contract did NOT sync
		Assert.assertTrue(!documentText.contains("Test PDF.pdf"), "Document name is incorrect in Documents");
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
		Assert.assertTrue(orderInformation.contains("Order accepted by Appraiser (Automation Appraiser3) and In Progress"), "Order accepted by Appraiser (Automation Appraiser3) and In Progress is missing from the audit trail");
		Assert.assertTrue(orderInformation.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(orderInformation.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(orderInformation.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(orderInformation.contains("Comment - Action Required by Client (Automation EVFAMC)"), "Comment - Action Required by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(orderInformation.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(orderInformation.contains("Message from Client (Automation EVFAMC)"), "Message from Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(orderInformation.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(orderInformation.contains("Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(orderInformation.contains("Delayed by Client (Automation EVFAMC)"), "Delayed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(orderInformation.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(orderInformation.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(orderInformation.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(orderInformation.contains("On Hold by Client (Automation EVFAMC)"), "On Hold by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(orderInformation.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(orderInformation.contains("Awaiting acceptance by Automation Appraiser3"), "Awaiting acceptance by Automation Appraiser3 is missing from the audit trail");
		
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
		perform.type(driver,VOrderDetails.setOrderStatusNotes_txtbx(driver), "These are Delayed notes from Appraiser3");
		
		// Click OK
		perform.click(driver,VOrderDetails.setStatusOk_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Get order information text
		history = VOrderDetails.orderInformation_txt(driver).getText();
		
		// Verify audit trail
		Assert.assertTrue(history.contains("History (Delayed)"), "History (Delayed) is missing from the order information");
		Assert.assertTrue(history.contains("Delayed by Appraiser (Automation Appraiser3)"), "Delayed by Appraiser (Automation Appraiser3) is missing from the order information");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Order accepted by Appraiser (Automation Appraiser3) and In Progress"), "Order accepted by Appraiser (Automation Appraiser3) and In Progress is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation EVFAMC)"), "Comment - Action Required by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFAMC)"), "Message from Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Client (Automation EVFAMC)"), "Delayed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Client (Automation EVFAMC)"), "On Hold by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser3"), "Awaiting acceptance by Automation Appraiser3 is missing from the audit trail");

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
		perform.type(driver,VOrderDetails.setOrderStatusNotes_txtbx(driver), "These are Resume notes from Appraiser3");
		
		// Click OK
		perform.click(driver,VOrderDetails.setStatusOk_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Get order information text
		history = VOrderDetails.orderInformation_txt(driver).getText();
		
		// Verify audit trail
		Assert.assertTrue(history.contains("History (In Progress)"), "History (In Progress) is missing from the order information");
		Assert.assertTrue(history.contains("Resumed by Appraiser (Automation Appraiser3)"), "Resumed by Appraiser (Automation Appraiser3) is missing from the order information");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Delayed by Appraiser (Automation Appraiser3)"), "Delayed by Appraiser (Automation Appraiser3) is missing from the order information");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Order accepted by Appraiser (Automation Appraiser3) and In Progress"), "Order accepted by Appraiser (Automation Appraiser3) and In Progress is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation EVFAMC)"), "Comment - Action Required by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFAMC)"), "Message from Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Client (Automation EVFAMC)"), "Delayed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Client (Automation EVFAMC)"), "On Hold by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser3"), "Awaiting acceptance by Automation Appraiser3 is missing from the audit trail");
		
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
		vendors.uploadDocument(driver, filePath, StoredVariables.getloanIDAMC().get(), "Other");
		
		// Click Close Button
		perform.click(driver,VOrderDetails.close_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		Thread.sleep(1500);
		
		// Upload Market Information document
		perform.waitForElementToBeClickable(driver, VOrderDetails.attachDocuments_btn(), "cssSelector");
		// Click Attach Documents button
		perform.click(driver,VOrderDetails.attachDocuments_btn(driver));
		
		// Wait for message text
		perform.waitForElementToBeClickable(driver, VOrderDetails.uploadDocuments_btn(), "id");
		
		// Select document type
		perform.selectDropdownOption(driver, VOrderDetails.documentType_dropdown(driver), "Market Information");
		
		// Wait for upload button
		perform.waitForElementToBeClickable(driver, VOrderDetails.uploadDocuments_btn(), "id");
		
		// Upload test pdf file
		filePath = StoredVariables.getdocDir().get()+"Apostrophes License.pdf";
		vendors.uploadDocument(driver, filePath, StoredVariables.getloanID().get(), "Other");
		
		// Click Close Button
		perform.click(driver,VOrderDetails.close_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
	
		// Verify Other is in the Order Documents pane twice
		String orderDocumentsText = VOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(orderDocumentsText.contains("Order Documents"), "Order Documents is not showing in the Order Documents");
		Assert.assertTrue(orderDocumentsText.contains("Other"), "Other is not showing in the Order Documents");
		Assert.assertTrue(orderDocumentsText.contains("Market Information"), "Market Information is not showing in the Order Documents");
		Assert.assertTrue(!orderDocumentsText.contains("Sales Contract"), "Sales Contract is not showing in the Order Documents");
		Assert.assertTrue(orderDocumentsText.contains(StoredVariables.gettodaysDateLong().get()), "The Date Uploaded is not showing in the Order Documents");
		
		// Create boolean for both Other documents
		boolean amc = false;
		boolean appraiser = false;
		
		// Get Number Of Other documents
		List<WebElement> docs = driver.findElements(By.xpath("//td[text()='Other']"));
		for (WebElement doc: docs)
		{
			
			// Click first Other document
			perform.click(driver,doc);
			
			Thread.sleep(3000);
			
			orderDocumentsText = VOrderDetails.documents_txt(driver).getText();
			
			// Wait for text
			perform.waitForText(driver, VOrderDetails.documents_txt(driver), "Automation");
			
			if (orderDocumentsText.contains("Automation EVFAMC") && amc == false)
			{
				// Verify Uploaded By and Document Name
				Assert.assertTrue(orderDocumentsText.contains("TestPDF.pdf"), "TestPDF.pdf is not showing as the Document Name in Order Documents");
				amc = true;
			}
			
			else if (orderDocumentsText.contains("Automation Appraiser3") && appraiser == false)
			{
				// Verify Uploaded By and Document Name
				Assert.assertTrue(orderDocumentsText.contains("Test PDF_1.pdf"), "Test PDF_1.pdf is not showing as the Document Name in Order Documents");
				appraiser = true;
			}
				
		} // end for loop
		
		Assert.assertTrue(amc==true, "The Other document uploaded by Automation EVFAMC is not displaying");
		Assert.assertTrue(appraiser==true, "The Other document uploaded by Automation Appraiser3 is not displaying");
		
		// Click Market Information
		perform.clickInTable_Contains(driver, "Market Information");
		
		// Wait for text
		perform.waitForText(driver, VOrderDetails.documents_txt(driver), "Automation Appraiser3");
		perform.waitForText(driver, VOrderDetails.documents_txt(driver), "Apostrophes License.pdf");
		orderDocumentsText = VOrderDetails.documents_txt(driver).getText();
		
		// Verify Uploaded By and Document Name
		Assert.assertTrue(orderDocumentsText.contains("Apostrophes License.pdf"), "Apostrophes License.pdf is not showing as the Document Name in Order Documents");
		
		// Get order information text
		history = VOrderDetails.orderInformation_txt(driver).getText();
		
		// Verify audit trail
		Assert.assertTrue(history.contains("History (In Progress)"), "History (In Progress) is missing from the order information");
		Assert.assertTrue(history.contains("Resumed by Appraiser (Automation Appraiser3)"), "Resumed by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Appraiser (Automation Appraiser3)"), "Delayed by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order accepted by Appraiser (Automation Appraiser3) and In Progress"), "Order accepted by Appraiser (Automation Appraiser3) and In Progress is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation EVFAMC)"), "Comment - Action Required by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFAMC)"), "Message from Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Client (Automation EVFAMC)"), "Delayed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Client (Automation EVFAMC)"), "On Hold by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser3"), "Awaiting acceptance by Automation Appraiser3 is missing from the audit trail");

		// Wait for History
		perform.waitForElementToBeVisible(driver, VOrderDetails.sendMessage_btn(), "cssSelector");
		
		// Click Message
		perform.click(driver,VOrderDetails.sendMessage_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for OK button to be clickable
		perform.waitForElementToBeClickable(driver, VOrderDetails.sendMessageOk_btn(), "cssSelector");
		
		// Add notes
		perform.type(driver,VOrderDetails.sendMessageNotes_txtbx(driver), "These are additional Message notes from Appraiser3");
		
		// Click Send button
		perform.click(driver,VOrderDetails.sendMessageOk_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Verify Report is in the Order Documents pane
		orderDocumentsText = VOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(orderDocumentsText.contains("Order Documents"), "Order Documents is not showing in the Order Documents");
		Assert.assertTrue(orderDocumentsText.contains("Other"), "Other is not showing in the Order Documents");
		Assert.assertTrue(orderDocumentsText.contains("Market Information"), "Market Information is not showing in the Order Documents");
		Assert.assertTrue(orderDocumentsText.contains(StoredVariables.gettodaysDateLong().get()), "The Date Uploaded is not showing in the Order Documents");

		// Verify audit trail
		history = VOrderDetails.orderInformation_txt(driver).getText();
		
		// Verify audit trail
		Assert.assertTrue(history.contains("History (In Progress)"), "History (In Progress) is missing from the order information");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser3)"), "Message from Appraiser (Automation Appraiser3) is missing from the order information");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Apostrophes License.pdf)"), "Document Uploaded from Appraiser (Automation Appraiser3) (Apostrophes License.pdf) is missing from the order information");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Test PDF_1.pdf)"), "Document Uploaded from Appraiser (Automation Appraiser3) (Test PDF_1.pdf) is missing from the order information");
		Assert.assertTrue(history.contains("Resumed by Appraiser (Automation Appraiser3)"), "Resumed by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Appraiser (Automation Appraiser3)"), "Delayed by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order accepted by Appraiser (Automation Appraiser3) and In Progress"), "Order accepted by Appraiser (Automation Appraiser3) and In Progress is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation EVFAMC)"), "Comment - Action Required by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFAMC)"), "Message from Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Client (Automation EVFAMC)"), "Delayed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Client (Automation EVFAMC)"), "On Hold by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser3"), "Awaiting acceptance by Automation Appraiser3 is missing from the audit trail");

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
			secure.viewXSiteOrderFromSecure(driver, "EVFLender", StoredVariables.getpassword().get(), StoredVariables.getloanID().get());
			
			// Get history text
			perform.waitForElementToBeVisible(driver, XOrders.toolbar(), "id");
			history = XOrders.history_txt(driver).getText();
			String address = StoredVariables.getpropertyInformationAddress().get() + " " + StoredVariables.getpropertyInformationCity().get() + ", " + StoredVariables.getpropertyInformationStateAbbr().get() + " " + StoredVariables.getpropertyInformationZip().get();
			
			// Verify the history
			Assert.assertTrue(history.contains("History (In Progress)"), "History (In Progress) is missing from the order information");
			Assert.assertTrue(!history.contains("Document Uploaded from Vendor (Automation Appraiser3) (Apostrophes License.pdf)"), "Document Uploaded from Vendor (Automation Appraiser3) (Apostrophes License.pdf) is missing from the audit trail");
			Assert.assertTrue(history.contains("Message (Automation EVFLender)"), "Message (Automation EVFLender) is missing from the order information");
			Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the order information");
			Assert.assertTrue(history.contains("Document Uploaded (Automation EVFLender) (Test PDF_1.pdf)"), "Document Uploaded (Automation EVFLender) (Test PDF_1.pdf) is missing from the order information");
			Assert.assertTrue(history.contains("Resumed (Automation EVFLender)"), "Resumed (Automation EVFLender) is missing from the order information");
			Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the order information");
			Assert.assertTrue(history.contains("Delayed (Automation EVFLender)"), "Delayed (Automation EVFLender) is missing from the order information");
			Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the order information");
			Assert.assertTrue(history.contains("Vendor Accepted Assignment (Automation EVFLender)"), "Vendor Accepted Assignment (Automation EVFLender) is missing from the order information");
			Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the order information");
			Assert.assertTrue(history.contains("Resumed (Automation EVFLender)"), "Resumed (Automation EVFLender) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
			Assert.assertTrue(history.contains("Comment - Action Required (Automation OriginatorEVF)"), "Comment - Action Required (Automation OriginatorEVF) is missing from the order information");
			Assert.assertTrue(history.contains("Comment - Action Required for " + address), "Comment - Action Required for " + address + " is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
			Assert.assertTrue(history.contains("Message (Automation OriginatorEVF)"), "Message (Automation OriginatorEVF) is missing from the audit trail");
			Assert.assertTrue(history.contains("Order message for " + address), "Order message for " + address + " is missing from the order information");
			Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
			Assert.assertTrue(history.contains("Document Uploaded (Automation OriginatorEVF) (TestPDF.pdf)"), "Document Uploaded (Automation OriginatorEVF) (TestPDF.pdf) is missing from the audit trail");
			Assert.assertTrue(history.contains("Document Uploaded (Automation OriginatorEVF) (Test PDF.pdf)"), "Document Uploaded (Automation OriginatorEVF) (Test PDF.pdf) is missing from the audit trail");
			Assert.assertTrue(history.contains("Delayed (Automation OriginatorEVF)"), "Delayed (Automation OriginatorEVF) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
			Assert.assertTrue(history.contains("Resumed (Automation OriginatorEVF)"), "Resumed (Automation OriginatorEVF) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
			Assert.assertTrue(history.contains("On Hold (Automation OriginatorEVF)"), "On Hold (Automation OriginatorEVF) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the order information");
			Assert.assertTrue(history.contains("In Progress (Automation OriginatorEVF)"), "In Progress (Automation OriginatorEVF) is missing from the audit trail");
			
			// Verify order details
			perform.verifyXSiteOrderDetailsForLender(driver);
			
			// Verify documents
			String documentsText = XOrders.documents_txt(driver).getText();
			Assert.assertTrue(documentsText.contains("Other"), "Other document is missing from the documents section of the XSite");
			Assert.assertTrue(documentsText.contains("TestPDF"), "TestPDF document is missing from the documents section of the XSite");
			Assert.assertTrue(documentsText.contains("Test PDF_1"), "TestPDF document is missing from the documents section of the XSite");
			Assert.assertTrue(documentsText.contains("Sales Contract"), "Sales Contract document is missing from the documents section of the XSite");
			Assert.assertTrue(documentsText.contains("Test PDF"), "Test PDF document is missing from the documents section of the XSite");
			Assert.assertTrue(!documentsText.contains("Apostrophes License"), "Apostrophes License PDF document should not sync to the documents section of the XSite");
			
			// Verify comments
			String comments = XOrders.comments_txt(driver).getText();
			Assert.assertTrue(comments.contains("These are test additional comments"), "Additional Comments section is missing info");
			
			// Close XSite order
			perform.closeNewWindow(driver);
		
		} // end else

		// Login to VMP Client Portal
		vmp.login(driver, "EVFLender", "OriginatorEVF", StoredVariables.getpassword().get());
		
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
		
		Assert.assertTrue(!history.contains("Document Uploaded from Vendor (Automation Appraiser3) (Apostrophes License.pdf)"), "Document Uploaded from Vendor (Automation Appraiser3) (Apostrophes License.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation EVFLender"), "Message by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation EVFLender"), "Document Uploaded by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("Other"), "Other is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF_1.pdf"), "Test PDF_1.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation EVFLender"), "Resumed by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation EVFLender"), "Delayed by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraiser Accepted Assignment by Automation EVFLender"), "Appraiser Accepted Assignment by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorEVF"), "Resumed by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Automation OriginatorEVF"), "Comment - Action Required by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation OriginatorEVF"), "Message by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorEVF"), "Document Uploaded by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Other"), "Other is missing from the audit trail");
		Assert.assertTrue(history.contains("TestPDF.pdf"), "TestPDF.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorEVF"), "Document Uploaded by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Sales Contract"), "Sales Contract is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF.pdf"), "Test PDF.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation OriginatorEVF"), "Delayed by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorEVF"), "Resumed by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Automation OriginatorEVF"), "On Hold by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("In Progress by Automation OriginatorEVF"), "In Progress by Automation OriginatorEVF is missing from the audit trail");
		
		// Verify the order details
		vmp.verifyAppraisalOrderDetails(driver);
		
		// Verify Document is in Documents
		documentText = VMPAppraisalOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Other"), "Other document is not displayed in VMP Client Portal");
		Assert.assertTrue(documentText.contains("Sales Contract"), "Sales Contract did not sync to VMP Client Portal");
		Assert.assertTrue(!documentText.contains("Market Information"), "Market Information should not sync to VMP Client Portal");
		
		// Click on Sales Contract
		perform.clickInTable_Contains(driver, "Sales Contract");
		
		// Wait for text to update
		perform.waitForText(driver, VMPAppraisalOrderDetails.documents_txt(driver), "Test PDF.pdf");
		documentText = VMPAppraisalOrderDetails.documents_txt(driver).getText();
		
		// Verify file name and uploaded by
		Assert.assertTrue(documentText.contains("Test PDF.pdf"), "Document name is incorrect in Documents");
		Assert.assertTrue(documentText.contains("Automation OriginatorEVF"), "Uploaded By is incorrect in Documents");
		
		// Create boolean for both Other documents
		boolean originator = false;
		boolean lender = false;
		
		// Get Number Of Other documents
		docs = driver.findElements(By.xpath("//td[text()='Other']"));
		for (WebElement doc: docs)
		{
			
			// Click first Other document
			perform.click(driver,doc);
			
			Thread.sleep(3000);
			
			documentText = VMPAppraisalOrderDetails.documents_txt(driver).getText();
			
			// Wait for text
			perform.waitForText(driver, VMPAppraisalOrderDetails.documents_txt(driver), "Automation");
			
			if (documentText.contains("Automation OriginatorEVF") && originator == false)
			{
				// Verify Uploaded By and Document Name
				Assert.assertTrue(documentText.contains("TestPDF.pdf"), "TestPDF.pdf is not showing as the Document Name in Order Documents");
				originator = true;
			}
			
			else if (documentText.contains("Automation EVFLender") && lender == false)
			{
				// Verify Uploaded By and Document Name
				Assert.assertTrue(documentText.contains("Test PDF_1.pdf"), "Test PDF_1.pdf is not showing as the Document Name in Order Documents");
				lender = true;
			}
				
		} // end for loop
		
		Assert.assertTrue(originator==true, "The Other document uploaded by Automation OriginatorEVF is not displaying");
		Assert.assertTrue(lender==true, "The Other document uploaded by Automation EVFLender is not displaying");
		
		// Log in to Secure
		secure.login(driver, "EVFLender", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, StoredVariables.getloanID().get(), "Tracking number");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("In Progress"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getAWSAccountsID().get() + "-" + StoredVariables.getloanID().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Verify order details
		secure.verifyResidentialAppraisalOrderDetails(driver);
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify the history
		Assert.assertTrue(history.contains("History (In Progress)"), "History (In Progress) is missing from the order information");
		Assert.assertTrue(!history.contains("Document Uploaded from Vendor (Automation Appraiser3) (Apostrophes License.pdf)"), "Document Uploaded from Vendor (Automation Appraiser3) (Apostrophes License.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from AMC (" + amcCompany + ")"), "Message from Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from AMC (" + amcCompany + ") (Test PDF_1.pdf)"), "Document Uploaded from Vendor (Automation EVFAMC) (Test PDF_1.pdf)�is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by AMC (" + amcCompany + ")"), "Resumed by Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by AMC (" + amcCompany + ")"), "Delayed by Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraiser Accepted assignment"), "Appraiser Accepted assignment is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFLender)"), "Resumed by Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation EVFLender)"), "Comment - Action Required by Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFLender)"), "Message from Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFLender) (TestPDF.pdf)"), "Document Uploaded from Client (Automation EVFLender) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFLender) (Test PDF.pdf)"), "Document Uploaded from Client (Automation EVFLender) (Test PDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Client (Automation EVFLender)"), "Delayed by Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFLender)"), "Resumed by Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Client (Automation EVFLender)"), "On Hold by Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by AMC (" + amcCompany + ")"), "Order Changed by Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Order accepted by AMC (" + amcCompany + ") and In Progress"), "Order accepted by Vendor (Automation EVFAMC) and In Progress is missing from the audit trail");
		Assert.assertTrue(history.contains("Order automatically accepted."), "Order automatically accepted. is missing from the audit trail");
		Assert.assertTrue(history.contains("Order automatically assigned"), "Order automatically assigned is missing from the audit trail");
		Assert.assertTrue(history.contains("Assigned to Automation"), "Assigned to Automation EVFAMC is missing from the audit trail");
		
		// Verify Other Document is in Documents
		documentText = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(!documentText.contains("Market Information"), "Market Information should not sync to Secure");
		Assert.assertTrue(documentText.contains("Other"), "Other did not sync to Secure");
		Assert.assertTrue(documentText.contains("Sales Contract"), "Sales Contract did not sync to Secure");
		
		// Verify Sales ContractDocument is in Documents
		documentText = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Sales Contract"), "Sales Contract did not sync to Secure");
		
		// Click on Sales Contract
		perform.clickInTable_Contains(driver, "Sales Contract");
		
		// Wait for text to update
		perform.waitForText(driver, SOrderDetails.documents_txt(driver), "Test PDF.pdf");
		documentText = SOrderDetails.documents_txt(driver).getText();
		
		// Verify file name and uploaded by
		Assert.assertTrue(documentText.contains("Test PDF.pdf"), "Document name is incorrect in Documents");
		Assert.assertTrue(documentText.contains("Automation EVFLender"), "Uploaded By is incorrect in Documents");
		
		// Create boolean for both Other documents
		amc = false;
		lender = false;
		
		// Get Number Of Other documents
		docs = driver.findElements(By.xpath("//td[text()='Other']"));
		for (WebElement doc: docs)
		{
			
			// Click first Other document
			perform.click(driver,doc);
			
			Thread.sleep(3000);
			
			documentText = SOrderDetails.documents_txt(driver).getText();
			
			// Wait for text
			perform.waitForText(driver, SOrderDetails.documents_txt(driver), "Automation");
			
			if (documentText.contains("Automation EVFAMC") && amc == false)
			{
				// Verify Uploaded By and Document Name
				Assert.assertTrue(documentText.contains("Test PDF_1.pdf"), "Test PDF_1.pdf is not showing as the Document Name in Order Documents");
				amc = true;
			}
			
			else if (documentText.contains("Automation EVFLender") && lender == false)
			{
				// Verify Uploaded By and Document Name
				Assert.assertTrue(documentText.contains("TestPDF.pdf"), "TestPDF.pdf is not showing as the Document Name in Order Documents");
				lender = true;
			}
				
		} // end for loop
		
		Assert.assertTrue(amc==true, "The Other document uploaded by Automation EVFAMC is not displaying");
		Assert.assertTrue(lender==true, "The Other document uploaded by Automation EVFLender is not displaying");
		
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
			secure.viewXSiteOrderFromSecure(driver, "EVFAMC", StoredVariables.getpassword().get(), StoredVariables.getloanIDAMC().get());
			
			// Get history text
			perform.waitForElementToBeVisible(driver, XOrders.toolbar(), "id");
			history = XOrders.history_txt(driver).getText();
			String address = StoredVariables.getpropertyInformationAddress().get() + " " + StoredVariables.getpropertyInformationCity().get() + ", " + StoredVariables.getpropertyInformationStateAbbr().get() + " " + StoredVariables.getpropertyInformationZip().get();
			
			// Verify the history
			Assert.assertTrue(history.contains("History (In Progress)"), "History (In Progress) is missing from the order information");
			Assert.assertTrue(!history.contains("Document Uploaded from Vendor (Automation Appraiser3) (Apostrophes License.pdf)"), "Document Uploaded from Vendor (Automation Appraiser3) (Apostrophes License.pdf) is missing from the audit trail");
			Assert.assertTrue(history.contains("Message (Automation EVFAMC)"), "Message (Automation EVFAMC) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the audit trail");
			Assert.assertTrue(history.contains("Document Uploaded (Automation EVFAMC) (Test PDF_1.pdf)"), "Document Uploaded (Automation EVFAMC) (Test PDF_1.pdf) is missing from the audit trail");
			Assert.assertTrue(history.contains("Resumed (Automation EVFAMC)"), "Resumed (Automation EVFAMC) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
			Assert.assertTrue(history.contains("Delayed (Automation EVFAMC)"), "Delayed (Automation EVFAMC) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
			Assert.assertTrue(history.contains("Appraiser Accepted assignment by Appraiser"), "Appraiser Accepted assignment by Appraiser is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
			Assert.assertTrue(history.contains("Resumed (Automation EVFLender)"), "Resumed (Automation EVFLender) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
			Assert.assertTrue(history.contains("Comment - Action Required (Automation EVFLender)"), "Comment - Action Required (Automation EVFLender) is missing from the audit trail");
			Assert.assertTrue(history.contains("Comment - Action Required for " + address), "Comment - Action Required for " + address + " is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
			Assert.assertTrue(history.contains("Message (Automation EVFLender)"), "Message (Automation EVFLender) is missing from the audit trail");
			Assert.assertTrue(history.contains("Order message for " + address), "Order message for " + address + " is missing from the audit trail");
			Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
			Assert.assertTrue(history.contains("Document Uploaded (Automation EVFLender) (TestPDF.pdf)"), "Document Uploaded (Automation EVFLender) (TestPDF.pdf) is missing from the audit trail");
			Assert.assertTrue(history.contains("Document Uploaded (Automation EVFLender) (Test PDF.pdf)"), "Document Uploaded (Automation EVFLender) (Test PDF.pdf) is missing from the audit trail");
			Assert.assertTrue(history.contains("Delayed (Automation EVFLender)"), "Delayed (Automation EVFLender) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
			Assert.assertTrue(history.contains("Resumed (Automation EVFLender)"), "Resumed (Automation EVFLender) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
			Assert.assertTrue(history.contains("On Hold (Automation EVFLender)"), "On Hold (Automation EVFLender) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
			Assert.assertTrue(history.contains("Order Changed (Automation EVFAMC)"), "Order Changed (Automation EVFAMC) is missing from the audit trail");
			Assert.assertTrue(history.contains("To View Change History:"), "To View Change History: is missing from the audit trail");
			Assert.assertTrue(history.contains("In Progress (Automation EVFAMC)"), "In Progress (Automation EVFAMC) is missing from the audit trail");
			Assert.assertTrue(history.contains("Awaiting acceptance"), "Awaiting acceptance is missing from the audit trail");
			
			// Verify order details
			perform.verifyXSiteOrderDetailsForAMC(driver);
			
			// Verify documents
			perform.waitForText(driver, XOrders.documents_txt(driver), "Other");
			String documentsText = XOrders.documents_txt(driver).getText();
			Assert.assertTrue(!documentsText.contains("Market Information"), "Market Information should not sync to Secure");
			Assert.assertTrue(documentsText.contains("Other"), "Other document is missing from the documents section of the XSite - " + documentsText);
			Assert.assertTrue(documentsText.contains("TestPDF"), "TestPDF document is missing from the documents section of the XSite - " + documentsText);
			Assert.assertTrue(documentsText.contains("Test PDF_1"), "Test PDF_1 document is missing from the documents section of the XSite - " + documentsText);
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
		Assert.assertTrue(VOrders.ordersGrid_txt(driver).getText().contains("In Progress"), "The order is not in the correct status");
		
		// Click on the order from the orders grid
		perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, VOrderDetails.orderInformation_txt(), "id");
		
		// Get order information text
		history = VOrderDetails.orderInformation_txt(driver).getText();
		
		// Verify audit trail
		Assert.assertTrue(history.contains("History (In Progress)"), "History (In Progress) is missing from the order information");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser3)"), "Message from Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Apostrophes License.pdf)"), "Document Uploaded from Appraiser (Automation Appraiser3) (Apostrophes License.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Test PDF_1.pdf)"), "Document Uploaded from Appraiser (Automation Appraiser3) (Test PDF_1.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Appraiser (Automation Appraiser3)"), "Resumed by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Appraiser (Automation Appraiser3)"), "Delayed by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order accepted by Appraiser (Automation Appraiser3) and In Progress"), "Order accepted by Appraiser (Automation Appraiser3) and In Progress is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation EVFAMC)"), "Comment - Action Required by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFAMC)"), "Message from Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(!history.contains("Document Uploaded from Client (Automation EVFAMC) (Test PDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC) (Test PDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Client (Automation EVFAMC)"), "Delayed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Client (Automation EVFAMC)"), "On Hold by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser3"), "Awaiting acceptance by Automation Appraiser3 is missing from the audit trail");
		
		// Get comments
		additionalComments = VOrderDetails.additionalComments_txt(driver).getText();
		
		// Verify both VMP and MN comments are displayed
		Assert.assertTrue(additionalComments.contains("These are edited comments by EVFAMC"), "Additional Comments section is missing info");
		
		// View Order Details
		vendors.verifyOrderDetails(driver);
		
		// Verify Document is in Documents
		documentText = VOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Other"), "Other did not sync to Vendors");
		Assert.assertTrue(documentText.contains("Market Information"), "Market Information did not sync to Vendors");
		Assert.assertTrue(!documentText.contains("Sales Contract"), "Sales Contract should not sync to Vendors");

		// Log in to Secure
		secure.login(driver, "EVFAMC", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, StoredVariables.getloanIDAMC().get(), "Tracking number");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("In Progress"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getAWSAccountsID().get() + "-" + StoredVariables.getloanIDAMC().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Verify order details
		secure.verifyResidentialAppraisalOrderDetails(driver);
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify the history
		Assert.assertTrue(history.contains("History (In Progress)"), "History (In Progress) is missing from the order information");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser3)"), "Message from Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Apostrophes License.pdf)"), "Document Uploaded from Vendor (Automation Appraiser3) (Apostrophes License.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Test PDF_1.pdf)"), "Document Uploaded from Vendor (Automation Appraiser3) (Test PDF_1.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Appraiser (Automation Appraiser3)"), "Resumed by Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Appraiser (Automation Appraiser3)"), "Delayed by Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order accepted by Appraiser (Automation Appraiser3) and In Progress"), "Order accepted by Vendor (Automation Appraiser3) and In Progress is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation EVFAMC)"), "Comment - Action Required by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFAMC)"), "Message from Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(!history.contains("Document Uploaded from Client (Automation EVFAMC) (Test PDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC) (Test PDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Client (Automation EVFAMC)"), "Delayed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Client (Automation EVFAMC)"), "On Hold by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser3"), "Awaiting acceptance by Automation Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Reassigned by Client (Automation EVFAMC) to Automation Appraiser3"), "Reassigned by Client (Automation EVFAMC) to Automation Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by Client (Automation EVFAMC)"), "Order Changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("To View Change History:"), "To View Change History: is missing from the audit trail");
		Assert.assertTrue(history.contains("Requires assignment"), "Requires assignment is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance"), "Awaiting acceptance is missing from the audit trail");
		
		// Verify Other Document is in Documents
		documentText = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Other"), "Other did not sync to Secure");
		Assert.assertTrue(documentText.contains("Market Information"), "Market Information did not sync to Secure");
		Assert.assertTrue(!documentText.contains("Sales Contract"), "Sales Contract should not sync to Secure");
		
		// Click Set status
		perform.clickInTable_Contains(driver, "Set status");
		
		// Wait for text
		perform.waitForText(driver, SNewOrder.setStatus_txt(driver), "Change due date");
		
		// Click Change due date
		perform.click(driver,SNewOrder.changeDueDateAsAMC_btn(driver));
		
		// Wait for Set date to be clickable
		perform.waitForElementToBeClickable(driver, SNewOrder.changeDueDateSetDate_btn(), "id");
		
		Thread.sleep(1500);
		
		// Click the Order due calendar button
		perform.click(driver,SNewOrder.changeDueDateCalendar_btn(driver));
		
		// Change the date to 10 days out
		secure.selectDateFromCalendar(driver, 10);
		
		// Set new order due date
		StoredVariables.getorderDueDateShort().set(StoredVariables.getcalendarDateShort().get());
		
		// Enter comments
		perform.type(driver,SNewOrder.changeDueDateComments_txtbx(driver), "These are EVFAMC change due date comments");
		
		// Check Update the due date on the VMP XSite and notify client checkbox
		if (!SNewOrder.updateDueDateOnVMPXSite_chkbx(driver).isSelected())
		{
			perform.click(driver,SNewOrder.updateDueDateOnVMPXSite_chkbx(driver));
		}
		
		// Click Set date
		perform.click(driver,SNewOrder.changeDueDateSetDate_btn(driver));
		
		Thread.sleep(6000);
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for history
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Click Set status
		perform.clickInTable_Equals(driver, "Set status");

		// Wait for text
		perform.waitForText(driver, SNewOrder.setStatus_txt(driver), "Change fee");
		
		// Click Change fee
		perform.click(driver,SNewOrder.changeFeeAsAMC_btn(driver));
		
		// Change the fee to $525
		perform.waitForElementToBeClickable(driver, SNewOrder.newFee_txtbx(), "id");
		SNewOrder.newFee_txtbx(driver).clear();
		perform.type(driver,SNewOrder.newFee_txtbx(driver), "525");
		
		// Enter comments
		perform.type(driver,SNewOrder.changeFeeComments_txtbx(driver), "These are EVFAMC change fee comments");
		
		// Click Set Fee
		perform.click(driver,SNewOrder.setFee_btn(driver));
		
		// Wait for history
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
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
			secure.viewXSiteOrderFromSecure(driver, "EVFLender", StoredVariables.getpassword().get(), StoredVariables.getloanID().get());
			
			// Get history text
			perform.waitForElementToBeVisible(driver, XOrders.toolbar(), "id");
			history = XOrders.history_txt(driver).getText();
			String address = StoredVariables.getpropertyInformationAddress().get() + " " + StoredVariables.getpropertyInformationCity().get() + ", " + StoredVariables.getpropertyInformationStateAbbr().get() + " " + StoredVariables.getpropertyInformationZip().get();
			
			// Wait for db to update
			perform.waitForDBUpdateForHistoryTextInVMPXSite(driver, "Vendor due date changed (Automation EVFLender)");
			
			// Recapture the text from the history
			history = XOrders.history_txt(driver).getText();
			
			// Verify the history
			Assert.assertTrue(history.contains("History (In Progress)"), "History (In Progress) is missing from the order information");
			Assert.assertTrue(!history.contains("These are EVFAMC change fee comments"), "These are EVFAMC change fee comments is missing from the audit trail");
			Assert.assertTrue(history.contains("Vendor due date changed (Automation EVFLender)"), "Order due date changed (Automation EVFLender) is missing from the order information");
			Assert.assertTrue(history.contains("Vendor due date changed from"), "Order due date changed from is missing from the order information");
			Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
			Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the order information");
			Assert.assertTrue(history.contains("Message (Automation EVFLender)"), "Message (Automation EVFLender) is missing from the order information");
			Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the order information");
			Assert.assertTrue(history.contains("Document Uploaded (Automation EVFLender) (Test PDF_1.pdf)"), "Document Uploaded (Automation EVFLender) (Test PDF_1.pdf) is missing from the order information");
			Assert.assertTrue(history.contains("Resumed (Automation EVFLender)"), "Resumed (Automation EVFLender) is missing from the order information");
			Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the order information");
			Assert.assertTrue(history.contains("Delayed (Automation EVFLender)"), "Delayed (Automation EVFLender) is missing from the order information");
			Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the order information");
			Assert.assertTrue(history.contains("Vendor Accepted Assignment (Automation EVFLender)"), "Vendor Accepted Assignment (Automation EVFLender) is missing from the order information");
			Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the order information");
			Assert.assertTrue(history.contains("Resumed (Automation EVFLender)"), "Resumed (Automation EVFLender) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
			Assert.assertTrue(history.contains("Comment - Action Required (Automation OriginatorEVF)"), "Comment - Action Required (Automation OriginatorEVF) is missing from the order information");
			Assert.assertTrue(history.contains("Comment - Action Required for " + address), "Comment - Action Required for " + address + " is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
			Assert.assertTrue(history.contains("Message (Automation OriginatorEVF)"), "Message (Automation OriginatorEVF) is missing from the audit trail");
			Assert.assertTrue(history.contains("Order message for " + address), "Order message for " + address + " is missing from the order information");
			Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
			Assert.assertTrue(history.contains("Document Uploaded (Automation OriginatorEVF) (TestPDF.pdf)"), "Document Uploaded (Automation OriginatorEVF) (TestPDF.pdf) is missing from the audit trail");
			Assert.assertTrue(history.contains("Document Uploaded (Automation OriginatorEVF) (Test PDF.pdf)"), "Document Uploaded (Automation OriginatorEVF) (Test PDF.pdf) is missing from the audit trail");
			Assert.assertTrue(history.contains("Delayed (Automation OriginatorEVF)"), "Delayed (Automation OriginatorEVF) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
			Assert.assertTrue(history.contains("Resumed (Automation OriginatorEVF)"), "Resumed (Automation OriginatorEVF) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
			Assert.assertTrue(history.contains("On Hold (Automation OriginatorEVF)"), "On Hold (Automation OriginatorEVF) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the order information");
			Assert.assertTrue(history.contains("In Progress (Automation OriginatorEVF)"), "In Progress (Automation OriginatorEVF) is missing from the audit trail");
			
			// Verify order details
			perform.verifyXSiteOrderDetailsForLender(driver);
			
			// Verify documents
			String documentsText = XOrders.documents_txt(driver).getText();
			Assert.assertTrue(documentsText.contains("Other"), "Other document is missing from the documents section of the XSite");
			Assert.assertTrue(documentsText.contains("TestPDF"), "TestPDF document is missing from the documents section of the XSite");
			Assert.assertTrue(documentsText.contains("Test PDF_1"), "TestPDF document is missing from the documents section of the XSite");
			Assert.assertTrue(documentsText.contains("Sales Contract"), "Sales Contract document is missing from the documents section of the XSite");
			Assert.assertTrue(documentsText.contains("Test PDF"), "Test PDF document is missing from the documents section of the XSite");
			Assert.assertTrue(!documentsText.contains("Apostrophes License"), "Test PDF document is missing from the documents section of the XSite");
			
			// Verify comments
			String comments = XOrders.comments_txt(driver).getText();
			Assert.assertTrue(comments.contains("These are test additional comments"), "Additional Comments section is missing info");
			
			// Verify new Due Date
			Assert.assertTrue(XOrders.dueDate_txt(driver).getText().equals(StoredVariables.getcalendarDateShort().get()), "New Due Date is not correct");
			
			// Verify fee
			Assert.assertTrue(XOrders.fee_txt(driver).getText().equals("$350.00"), "Fee should not update");
			
			// Close XSite order
			perform.closeNewWindow(driver);
		
		} // end else
		
		// Login to VMP Client Portal
		vmp.login(driver, "EVFLender", "OriginatorEVF", StoredVariables.getpassword().get());
		
		// Search for order
		vmp.findOrder(driver, StoredVariables.getloanIDVMP().get(), "Tracking #");
		
		// Verify Order Status
		Assert.assertTrue(VMPOrders.orderStatus_txt(driver).getText().equals("In Progress"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());
		
		Thread.sleep(1500);
		
		// Wait for Edit Property Contacts link
		perform.waitForElementToBeClickable(driver, VMPAppraisalOrderDetails.editPropertyContacts_lnk(), "id");
		
		vmp.waitForDBUpdateForHistory(driver, "These are EVFAMC change due date comments");
		
		// Verify the audit trail
		history = VMPAppraisalOrderDetails.history_txt(driver).getText();
		
		Assert.assertTrue(!history.contains("These are EVFAMC change fee comments"), "These are EVFAMC change fee comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed by Automation EVFLender"), "Vendor due date changed by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the audit trail");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation EVFLender"), "Message by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation EVFLender"), "Document Uploaded by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("Other"), "Other is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF_1.pdf"), "Test PDF_1.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation EVFLender"), "Resumed by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation EVFLender"), "Delayed by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraiser Accepted Assignment by Automation EVFLender"), "Appraiser Accepted Assignment by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorEVF"), "Resumed by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Automation OriginatorEVF"), "Comment - Action Required by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation OriginatorEVF"), "Message by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorEVF"), "Document Uploaded by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Other"), "Other is missing from the audit trail");
		Assert.assertTrue(history.contains("TestPDF.pdf"), "TestPDF.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorEVF"), "Document Uploaded by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Sales Contract"), "Sales Contract is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF.pdf"), "Test PDF.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation OriginatorEVF"), "Delayed by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorEVF"), "Resumed by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Automation OriginatorEVF"), "On Hold by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("In Progress by Automation OriginatorEVF"), "In Progress by Automation OriginatorEVF is missing from the audit trail");
		
		// Verify new Due Date
		Assert.assertTrue(VMPAppraisalOrderDetails.orderDetails_txt(driver).getText().contains(StoredVariables.getcalendarDateShort().get()), "New Due Date is not correct");
		
		// Verify fee
		Assert.assertTrue(VMPAppraisalOrderDetails.orderDetails_txt(driver).getText().contains("$350"), "Fee should not update");
		
		// Verify the order details
		vmp.verifyAppraisalOrderDetails(driver);
		
		// Verify Document is in Documents
		documentText = VMPAppraisalOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Other"), "Other document is not displayed in VMP Client Portal");
		Assert.assertTrue(documentText.contains("Sales Contract"), "Sales Contract did not sync to VMP Client Portal");
		Assert.assertTrue(!documentText.contains("Market Information"), "Market Information should not sync to VMP Client Portal");
		
		// Click on Sales Contract
		perform.clickInTable_Contains(driver, "Sales Contract");
		
		// Wait for text to update
		perform.waitForText(driver, VMPAppraisalOrderDetails.documents_txt(driver), "Test PDF.pdf");
		documentText = VMPAppraisalOrderDetails.documents_txt(driver).getText();
		
		// Verify file name and uploaded by
		Assert.assertTrue(documentText.contains("Test PDF.pdf"), "Document name is incorrect in Documents");
		Assert.assertTrue(documentText.contains("Automation OriginatorEVF"), "Uploaded By is incorrect in Documents");
		
		// Create boolean for both Other documents
		originator = false;
		lender = false;
		
		// Get Number Of Other documents
		docs = driver.findElements(By.xpath("//td[text()='Other']"));
		for (WebElement doc: docs)
		{
			
			// Click first Other document
			perform.click(driver,doc);
			
			Thread.sleep(3000);
			
			documentText = VMPAppraisalOrderDetails.documents_txt(driver).getText();
			
			// Wait for text
			perform.waitForText(driver, VMPAppraisalOrderDetails.documents_txt(driver), "Automation");
			
			if (documentText.contains("Automation OriginatorEVF") && originator == false)
			{
				// Verify Uploaded By and Document Name
				Assert.assertTrue(documentText.contains("TestPDF.pdf"), "TestPDF.pdf is not showing as the Document Name in Order Documents");
				originator = true;
			}
			
			else if (documentText.contains("Automation EVFLender") && lender == false)
			{
				// Verify Uploaded By and Document Name
				Assert.assertTrue(documentText.contains("Test PDF_1.pdf"), "Test PDF_1.pdf is not showing as the Document Name in Order Documents");
				lender = true;
			}
				
		} // end for loop
		
		Assert.assertTrue(originator==true, "The Other document uploaded by Automation OriginatorEVF is not displaying");
		Assert.assertTrue(lender==true, "The Other document uploaded by Automation EVFLender is not displaying");

		// Log in to Secure
		secure.login(driver, "EVFLender", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, StoredVariables.getloanID().get(), "Tracking number");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("In Progress"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getAWSAccountsID().get() + "-" + StoredVariables.getloanID().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Verify order details
		secure.verifyResidentialAppraisalOrderDetails(driver);
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify the history
		Assert.assertTrue(history.contains("History (In Progress)"), "History (In Progress) is missing from the order information");
		Assert.assertTrue(!history.contains("These are EVFAMC change fee comments"), "These are EVFAMC change fee comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed by AMC (" + amcCompany + ")"), "Vendor due date changed by Vendor (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the order information");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Message from AMC (" + amcCompany + ")"), "Message from Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from AMC (" + amcCompany + ") (Test PDF_1.pdf)"), "Document Uploaded from Vendor (Automation EVFAMC) (Test PDF_1.pdf)�is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by AMC (" + amcCompany + ")"), "Resumed by Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by AMC (" + amcCompany + ")"), "Delayed by Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraiser Accepted assignment"), "Appraiser Accepted assignment is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFLender)"), "Resumed by Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation EVFLender)"), "Comment - Action Required by Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFLender)"), "Message from Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFLender) (TestPDF.pdf)"), "Document Uploaded from Client (Automation EVFLender) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFLender) (Test PDF.pdf)"), "Document Uploaded from Client (Automation EVFLender) (Test PDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Client (Automation EVFLender)"), "Delayed by Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFLender)"), "Resumed by Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Client (Automation EVFLender)"), "On Hold by Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by AMC (" + amcCompany + ")"), "Order Changed by Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Order accepted by AMC (" + amcCompany + ") and In Progress"), "Order accepted by Vendor (Automation EVFAMC) and In Progress is missing from the audit trail");
		Assert.assertTrue(history.contains("Order automatically accepted."), "Order automatically accepted. is missing from the audit trail");
		Assert.assertTrue(history.contains("Order automatically assigned"), "Order automatically assigned is missing from the audit trail");
		Assert.assertTrue(history.contains("Assigned to Automation"), "Assigned to Automation EVFAMC is missing from the audit trail");
		
		// Verify new Due Date
		Assert.assertTrue(SOrderDetails.orderDue_txt(driver).getText().contains(StoredVariables.getcalendarDateShort().get()), "New Due Date is not correct");
		
		// Verify fee
		Assert.assertTrue(!SOrderDetails.assignmentInformation_txt(driver).getText().contains("525"), "Fee should not have updated. The fee = " + SOrderDetails.assignmentInformation_txt(driver).getText());
		
		// Verify Other Document is in Documents
		documentText = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(!documentText.contains("Market Information"), "Market Information should not sync to Secure");
		Assert.assertTrue(documentText.contains("Other"), "Other did not sync to Secure");
		Assert.assertTrue(documentText.contains("Sales Contract"), "Sales Contract did not sync to Secure");
		
		// Verify Sales ContractDocument is in Documents
		documentText = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Sales Contract"), "Sales Contract did not sync to Secure");
		
		// Click on Sales Contract
		perform.clickInTable_Contains(driver, "Sales Contract");
		
		// Wait for text to update
		perform.waitForText(driver, SOrderDetails.documents_txt(driver), "Test PDF.pdf");
		documentText = SOrderDetails.documents_txt(driver).getText();
		
		// Verify file name and uploaded by
		Assert.assertTrue(documentText.contains("Test PDF.pdf"), "Document name is incorrect in Documents");
		Assert.assertTrue(documentText.contains("Automation EVFLender"), "Uploaded By is incorrect in Documents");
		
		// Create boolean for both Other documents
		amc = false;
		lender = false;
		
		// Get Number Of Other documents
		docs = driver.findElements(By.xpath("//td[text()='Other']"));
		for (WebElement doc: docs)
		{
			
			// Click first Other document
			perform.click(driver,doc);
			
			Thread.sleep(3000);
			
			documentText = SOrderDetails.documents_txt(driver).getText();
			
			// Wait for text
			perform.waitForText(driver, SOrderDetails.documents_txt(driver), "Automation");
			
			if (documentText.contains("Automation EVFAMC") && amc == false)
			{
				// Verify Uploaded By and Document Name
				Assert.assertTrue(documentText.contains("Test PDF_1.pdf"), "Test PDF_1.pdf is not showing as the Document Name in Order Documents");
				amc = true;
			}
			
			else if (documentText.contains("Automation EVFLender") && lender == false)
			{
				// Verify Uploaded By and Document Name
				Assert.assertTrue(documentText.contains("TestPDF.pdf"), "TestPDF.pdf is not showing as the Document Name in Order Documents");
				lender = true;
			}
				
		} // end for loop
		
		Assert.assertTrue(amc==true, "The Other document uploaded by Automation EVFAMC is not displaying");
		Assert.assertTrue(lender==true, "The Other document uploaded by Automation EVFLender is not displaying");
		
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
			secure.viewXSiteOrderFromSecure(driver, "EVFAMC", StoredVariables.getpassword().get(), StoredVariables.getloanIDAMC().get());
			
			// Get history text
			perform.waitForElementToBeVisible(driver, XOrders.toolbar(), "id");
			history = XOrders.history_txt(driver).getText();
			String address = StoredVariables.getpropertyInformationAddress().get() + " " + StoredVariables.getpropertyInformationCity().get() + ", " + StoredVariables.getpropertyInformationStateAbbr().get() + " " + StoredVariables.getpropertyInformationZip().get();
			
			// Verify the history
			Assert.assertTrue(history.contains("History (In Progress)"), "History (In Progress) is missing from the order information");
			Assert.assertTrue(!history.contains("These are EVFAMC change fee comments"), "These are EVFAMC change fee comments is missing from the audit trail");
			Assert.assertTrue(history.contains("Vendor due date changed (Automation EVFAMC)"), "Vendor due date changed (Automation EVFAMC) is missing from the order information");
			Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the order information");
			Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
			Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the order information");
			Assert.assertTrue(history.contains("Message (Automation EVFAMC)"), "Message (Automation EVFAMC) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the audit trail");
			Assert.assertTrue(history.contains("Document Uploaded (Automation EVFAMC) (Test PDF_1.pdf)"), "Document Uploaded (Automation EVFAMC) (Test PDF_1.pdf) is missing from the audit trail");
			Assert.assertTrue(history.contains("Resumed (Automation EVFAMC)"), "Resumed (Automation EVFAMC) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
			Assert.assertTrue(history.contains("Delayed (Automation EVFAMC)"), "Delayed (Automation EVFAMC) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
			Assert.assertTrue(history.contains("Appraiser Accepted assignment by Appraiser"), "Appraiser Accepted assignment by Appraiser is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
			Assert.assertTrue(history.contains("Resumed (Automation EVFLender)"), "Resumed (Automation EVFLender) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
			Assert.assertTrue(history.contains("Comment - Action Required (Automation EVFLender)"), "Comment - Action Required (Automation EVFLender) is missing from the audit trail");
			Assert.assertTrue(history.contains("Comment - Action Required for " + address), "Comment - Action Required for " + address + " is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
			Assert.assertTrue(history.contains("Message (Automation EVFLender)"), "Message (Automation EVFLender) is missing from the audit trail");
			Assert.assertTrue(history.contains("Order message for " + address), "Order message for " + address + " is missing from the audit trail");
			Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
			Assert.assertTrue(history.contains("Document Uploaded (Automation EVFLender) (TestPDF.pdf)"), "Document Uploaded (Automation EVFLender) (TestPDF.pdf) is missing from the audit trail");
			Assert.assertTrue(history.contains("Document Uploaded (Automation EVFLender) (Test PDF.pdf)"), "Document Uploaded (Automation EVFLender) (Test PDF.pdf) is missing from the audit trail");
			Assert.assertTrue(history.contains("Delayed (Automation EVFLender)"), "Delayed (Automation EVFLender) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
			Assert.assertTrue(history.contains("Resumed (Automation EVFLender)"), "Resumed (Automation EVFLender) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
			Assert.assertTrue(history.contains("On Hold (Automation EVFLender)"), "On Hold (Automation EVFLender) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
			Assert.assertTrue(history.contains("Order Changed (Automation EVFAMC)"), "Order Changed (Automation EVFAMC) is missing from the audit trail");
			Assert.assertTrue(history.contains("To View Change History:"), "To View Change History: is missing from the audit trail");
			Assert.assertTrue(history.contains("In Progress (Automation EVFAMC)"), "In Progress (Automation EVFAMC) is missing from the audit trail");
			Assert.assertTrue(history.contains("Awaiting acceptance"), "Awaiting acceptance is missing from the audit trail");
			
			// Verify order details
			perform.verifyXSiteOrderDetailsForAMC(driver);
			
			// Verify documents
			perform.waitForText(driver, XOrders.documents_txt(driver), "Other");
			String documentsText = XOrders.documents_txt(driver).getText();
			Assert.assertTrue(!documentsText.contains("Market Information"), "Market Information should not sync to Secure");
			Assert.assertTrue(documentsText.contains("Other"), "Other document is missing from the documents section of the XSite - " + documentsText);
			Assert.assertTrue(documentsText.contains("TestPDF"), "TestPDF document is missing from the documents section of the XSite - " + documentsText);
			Assert.assertTrue(documentsText.contains("Test PDF_1"), "Test PDF_1 document is missing from the documents section of the XSite - " + documentsText);
			Assert.assertTrue(documentsText.contains("Sales Contract"), "Sales Contract document is missing from the documents section of the XSite - " + documentsText);
			Assert.assertTrue(documentsText.contains("Test PDF"), "Test PDF document is missing from the documents section of the XSite - " + documentsText);
			
			// Verify comments
			String comments = XOrders.comments_txt(driver).getText();
			Assert.assertTrue(comments.contains("These are edited comments by EVFAMC"), "Additional Comments section is missing info");
			
			// Verify new Due Date
			Assert.assertTrue(XOrders.dueDate_txt(driver).getText().equals(StoredVariables.getcalendarDateShort().get()), "New Due Date is not correct");
			
			// Verify fee
			Assert.assertTrue(!XOrders.fee_txt(driver).getText().equals("525"), "Fee should not update");
			
			// Close XSite order
			perform.closeNewWindow(driver);
		
		} // end else

		// Log in to Vendors
		vendors.login(driver, "Appraiser3", StoredVariables.getpassword().get());
		
		// Search for order
		vendors.findOrder(driver, StoredVariables.getloanIDAMC().get(), "Tracking Number");
		
		// Verify order status
		Assert.assertTrue(VOrders.ordersGrid_txt(driver).getText().contains("In Progress"), "The order is not in the correct status");
		
		// Click on the order from the orders grid
		perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, VOrderDetails.orderInformation_txt(), "id");
		
		// Get order information text
		history = VOrderDetails.orderInformation_txt(driver).getText();
		
		// Verify audit trail
		Assert.assertTrue(history.contains("History (In Progress)"), "History (In Progress) is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Fee Changed by Client (Automation EVFAMC)"), "Appraisal Fee Changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraisal fee changed from $350 to $525."), "Appraisal fee changed from $350 to $525. is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFAMC change fee comments"), "These are EVFAMC change fee comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed by Client (Automation EVFAMC)"), "Vendor due date changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the audit trail");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser3)"), "Message from Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Apostrophes License.pdf)"), "Document Uploaded from Appraiser (Automation Appraiser3) (Apostrophes License.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Test PDF_1.pdf)"), "Document Uploaded from Appraiser (Automation Appraiser3) (Test PDF_1.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Appraiser (Automation Appraiser3)"), "Resumed by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Appraiser (Automation Appraiser3)"), "Delayed by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order accepted by Appraiser (Automation Appraiser3) and In Progress"), "Order accepted by Appraiser (Automation Appraiser3) and In Progress is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation EVFAMC)"), "Comment - Action Required by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFAMC)"), "Message from Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(!history.contains("Document Uploaded from Client (Automation EVFAMC) (Test PDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC) (Test PDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Client (Automation EVFAMC)"), "Delayed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Client (Automation EVFAMC)"), "On Hold by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser3"), "Awaiting acceptance by Automation Appraiser3 is missing from the audit trail");
		
		// Verify new Due Date
		Assert.assertTrue(VOrderDetails.orderInformation_txt(driver).getText().contains(StoredVariables.getcalendarDateShort().get()), "New Due Date is not correct");
		
		// Verify fee
		Assert.assertTrue(VOrderDetails.orderInformation_txt(driver).getText().contains("$525"), "Fee should have updated");
		
		// Get comments
		additionalComments = VOrderDetails.additionalComments_txt(driver).getText();
		
		// Verify both VMP and MN comments are displayed
		Assert.assertTrue(additionalComments.contains("These are edited comments by EVFAMC"), "Additional Comments section is missing info");
		
		// View Order Details
		vendors.verifyOrderDetails(driver);
		
		// Verify Document is in Documents
		documentText = VOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Other"), "Other did not sync to Vendors");
		Assert.assertTrue(documentText.contains("Market Information"), "Market Information did not sync to Vendors");
		Assert.assertTrue(!documentText.contains("Sales Contract"), "Sales Contract should not sync to Vendors");
		
		// Log in to Secure
		secure.login(driver, "EVFAMC", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, StoredVariables.getloanIDAMC().get(), "Tracking number");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("In Progress"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getAWSAccountsID().get() + "-" + StoredVariables.getloanIDAMC().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Verify order details0
		secure.verifyResidentialAppraisalOrderDetails(driver);
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify the history
		Assert.assertTrue(history.contains("History (In Progress)"), "History (In Progress) is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Fee Changed by Client (Automation EVFAMC)"), "Appraisal Fee Changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraisal fee changed from $350 to $525."), "Appraisal fee changed from $350 to $525. is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFAMC change fee comments"), "These are EVFAMC change fee comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed by Client (Automation EVFAMC)"), "Vendor due date changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the audit trail");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser3)"), "Message from Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Apostrophes License.pdf)"), "Document Uploaded from Vendor (Automation Appraiser3) (Apostrophes License.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Test PDF_1.pdf)"), "Document Uploaded from Vendor (Automation Appraiser3) (Test PDF_1.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Appraiser (Automation Appraiser3)"), "Resumed by Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Appraiser (Automation Appraiser3)"), "Delayed by Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order accepted by Appraiser (Automation Appraiser3) and In Progress"), "Order accepted by Vendor (Automation Appraiser3) and In Progress is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation EVFAMC)"), "Comment - Action Required by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFAMC)"), "Message from Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(!history.contains("Document Uploaded from Client (Automation EVFAMC) (Test PDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC) (Test PDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Client (Automation EVFAMC)"), "Delayed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Client (Automation EVFAMC)"), "On Hold by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser3"), "Awaiting acceptance by Automation Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Reassigned by Client (Automation EVFAMC) to Automation Appraiser3"), "Reassigned by Client (Automation EVFAMC) to Automation Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by Client (Automation EVFAMC)"), "Order Changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("To View Change History:"), "To View Change History: is missing from the audit trail");
		Assert.assertTrue(history.contains("Requires assignment"), "Requires assignment is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance"), "Awaiting acceptance is missing from the audit trail");
		
		// Verify new Due Date
		Assert.assertTrue(SOrderDetails.orderDue_txt(driver).getText().contains(StoredVariables.getcalendarDateShort().get()), "New Due Date is not correct");
		
		// Verify fee
		Assert.assertTrue(SOrderDetails.assignmentInformation_txt(driver).getText().contains("525"), "Fee should have updated");
		
		// Verify Other Document is in Documents
		documentText = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Other"), "Other did not sync to Secure");
		Assert.assertTrue(documentText.contains("Market Information"), "Market Information did not sync to Secure");
		Assert.assertTrue(!documentText.contains("Sales Contract"), "Sales Contract should not sync to Secure");

		// Log in to Secure
		secure.login(driver, "EVFLender", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, StoredVariables.getloanID().get(), "Tracking number");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("In Progress"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getAWSAccountsID().get() + "-" + StoredVariables.getloanID().get());
		
		// Wait for history
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Click Set status
		perform.clickInTable_Contains(driver, "Set status");
		
		// Wait for text
		perform.waitForText(driver, SNewOrder.setStatus_txt(driver), "Change due date");
		
		// Click Change due date
		perform.click(driver,SNewOrder.changeDueDateAsLender_btn(driver));
		
		// Wait for Set date to be clickable
		perform.waitForElementToBeClickable(driver, SNewOrder.changeDueDateSetDate_btn(), "id");
		
		Thread.sleep(1500);
		
		// Click the Order due calendar button
		perform.click(driver,SNewOrder.changeDueDateCalendar_btn(driver));
		
		// Change the date to 12 days out
		secure.selectDateFromCalendar(driver, 12);
		
		// Set new Vendor due date
		StoredVariables.getorderDueDateShort().set(StoredVariables.getcalendarDateShort().get());
		
		// Enter comments
		perform.type(driver,SNewOrder.changeDueDateComments_txtbx(driver), "These are EVFLender change due date comments");
		
		// Check Update the due date on the VMP XSite and notify client checkbox
		if (!SNewOrder.updateDueDateOnVMPXSite_chkbx(driver).isSelected())
		{
			perform.click(driver,SNewOrder.updateDueDateOnVMPXSite_chkbx(driver));
		}
		
		// Click Set date
		perform.click(driver,SNewOrder.changeDueDateSetDate_btn(driver));
		
		Thread.sleep(6000);
		
		// Wait for history
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Click Set status
		perform.clickInTable_Contains(driver, "Set status");

		// Wait for text
		perform.waitForText(driver, SNewOrder.setStatus_txt(driver), "Change fee");
		
		// Click Change fee
		perform.click(driver,SNewOrder.changeFeeAsLender_btn(driver));
		
		// Change the fee to $525
		perform.waitForElementToBeClickable(driver, SNewOrder.newFee_txtbx(), "id");
		SNewOrder.newFee_txtbx(driver).clear();
		perform.type(driver,SNewOrder.newFee_txtbx(driver), "673");
		
		// Enter comments
		perform.type(driver,SNewOrder.changeFeeComments_txtbx(driver), "These are EVFLender change fee comments");
		
		// Click Set Fee
		perform.click(driver,SNewOrder.setFee_btn(driver));
		
		// Wait for history
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
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
			secure.viewXSiteOrderFromSecure(driver, "EVFLender", StoredVariables.getpassword().get(), StoredVariables.getloanID().get());
			
			// Get history text
			perform.waitForElementToBeVisible(driver, XOrders.toolbar(), "id");
			history = XOrders.history_txt(driver).getText();
			String address = StoredVariables.getpropertyInformationAddress().get() + " " + StoredVariables.getpropertyInformationCity().get() + ", " + StoredVariables.getpropertyInformationStateAbbr().get() + " " + StoredVariables.getpropertyInformationZip().get();
			
			// Wait for db to update
			perform.waitForDBUpdateForHistoryTextInVMPXSite(driver, StoredVariables.getcalendarDateShort().get());
			
			// Recapture the text from the history
			history = XOrders.history_txt(driver).getText();
			
			// Verify the history
			Assert.assertTrue(history.contains("History (In Progress)"), "History (In Progress) is missing from the order information");
			Assert.assertTrue(!history.contains("These are EVFLender change fee comments"), "These are EVFLender change fee comments is missing from the order information");
			Assert.assertTrue(history.contains("These are EVFLender change due date comments"), "These are EVFLender change due date comments is missing from the order information");
			Assert.assertTrue(history.contains("Vendor due date changed (Automation EVFLender)"), "Vendor due date changed (Automation EVFLender) is missing from the order information");
			Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the order information");
			Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
			Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the order information");
			Assert.assertTrue(history.contains("Message (Automation EVFLender)"), "Message (Automation EVFLender) is missing from the order information");
			Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the order information");
			Assert.assertTrue(history.contains("Document Uploaded (Automation EVFLender) (Test PDF_1.pdf)"), "Document Uploaded (Automation EVFLender) (Test PDF_1.pdf) is missing from the order information");
			Assert.assertTrue(history.contains("Resumed (Automation EVFLender)"), "Resumed (Automation EVFLender) is missing from the order information");
			Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the order information");
			Assert.assertTrue(history.contains("Delayed (Automation EVFLender)"), "Delayed (Automation EVFLender) is missing from the order information");
			Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the order information");
			Assert.assertTrue(history.contains("Vendor Accepted Assignment (Automation EVFLender)"), "Vendor Accepted Assignment (Automation EVFLender) is missing from the order information");
			Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the order information");
			Assert.assertTrue(history.contains("Resumed (Automation EVFLender)"), "Resumed (Automation EVFLender) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
			Assert.assertTrue(history.contains("Comment - Action Required (Automation OriginatorEVF)"), "Comment - Action Required (Automation OriginatorEVF) is missing from the order information");
			Assert.assertTrue(history.contains("Comment - Action Required for " + address), "Comment - Action Required for " + address + " is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
			Assert.assertTrue(history.contains("Message (Automation OriginatorEVF)"), "Message (Automation OriginatorEVF) is missing from the audit trail");
			Assert.assertTrue(history.contains("Order message for " + address), "Order message for " + address + " is missing from the order information");
			Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
			Assert.assertTrue(history.contains("Document Uploaded (Automation OriginatorEVF) (TestPDF.pdf)"), "Document Uploaded (Automation OriginatorEVF) (TestPDF.pdf) is missing from the audit trail");
			Assert.assertTrue(history.contains("Document Uploaded (Automation OriginatorEVF) (Test PDF.pdf)"), "Document Uploaded (Automation OriginatorEVF) (Test PDF.pdf) is missing from the audit trail");
			Assert.assertTrue(history.contains("Delayed (Automation OriginatorEVF)"), "Delayed (Automation OriginatorEVF) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
			Assert.assertTrue(history.contains("Resumed (Automation OriginatorEVF)"), "Resumed (Automation OriginatorEVF) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
			Assert.assertTrue(history.contains("On Hold (Automation OriginatorEVF)"), "On Hold (Automation OriginatorEVF) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the order information");
			Assert.assertTrue(history.contains("In Progress (Automation OriginatorEVF)"), "In Progress (Automation OriginatorEVF) is missing from the audit trail");
			
			// Verify order details
			perform.verifyXSiteOrderDetailsForLender(driver);
			
			// Verify documents
			String documentsText = XOrders.documents_txt(driver).getText();
			Assert.assertTrue(documentsText.contains("Other"), "Other document is missing from the documents section of the XSite");
			Assert.assertTrue(documentsText.contains("TestPDF"), "TestPDF document is missing from the documents section of the XSite");
			Assert.assertTrue(documentsText.contains("Test PDF_1"), "TestPDF document is missing from the documents section of the XSite");
			Assert.assertTrue(documentsText.contains("Sales Contract"), "Sales Contract document is missing from the documents section of the XSite");
			Assert.assertTrue(documentsText.contains("Test PDF"), "Test PDF document is missing from the documents section of the XSite");
			Assert.assertTrue(!documentsText.contains("Apostrophes License"), "Test PDF document is missing from the documents section of the XSite");
			
			// Verify comments
			String comments = XOrders.comments_txt(driver).getText();
			Assert.assertTrue(comments.contains("These are test additional comments"), "Additional Comments section is missing info");
			
			// Verify new Due Date
			Assert.assertTrue(XOrders.dueDate_txt(driver).getText().equals(StoredVariables.getcalendarDateShort().get()), "New Due Date is not correct");
			
			// Verify fee
			Assert.assertTrue(XOrders.fee_txt(driver).getText().equals("$350.00"), "Fee should not update");
			
			// Close XSite order
			perform.closeNewWindow(driver);
		
		} // end else

		// Login to VMP Client Portal
		vmp.login(driver, "EVFLender", "OriginatorEVF", StoredVariables.getpassword().get());
		
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
		
		Assert.assertTrue(!history.contains("These are EVFLender change fee comments"), "These are EVFLender change fee comments is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed by Automation EVFLender"), "Vendor due date changed by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the audit trail");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFLender change due date comments"), "These are EVFLender change due date comments is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation EVFLender"), "Message by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation EVFLender"), "Document Uploaded by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("Other"), "Other is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF_1.pdf"), "Test PDF_1.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation EVFLender"), "Resumed by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation EVFLender"), "Delayed by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraiser Accepted Assignment by Automation EVFLender"), "Appraiser Accepted Assignment by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorEVF"), "Resumed by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Automation OriginatorEVF"), "Comment - Action Required by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation OriginatorEVF"), "Message by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorEVF"), "Document Uploaded by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Other"), "Other is missing from the audit trail");
		Assert.assertTrue(history.contains("TestPDF.pdf"), "TestPDF.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorEVF"), "Document Uploaded by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Sales Contract"), "Sales Contract is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF.pdf"), "Test PDF.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation OriginatorEVF"), "Delayed by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorEVF"), "Resumed by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Automation OriginatorEVF"), "On Hold by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("In Progress by Automation OriginatorEVF"), "In Progress by Automation OriginatorEVF is missing from the audit trail");
		
		// Verify new Due Date
		Assert.assertTrue(VMPAppraisalOrderDetails.orderDetails_txt(driver).getText().contains(StoredVariables.getcalendarDateShort().get()), "New Due Date is not correct");
		
		// Verify fee
		Assert.assertTrue(VMPAppraisalOrderDetails.orderDetails_txt(driver).getText().contains("$350"), "Fee should not update");
		
		// Verify the order details
		vmp.verifyAppraisalOrderDetails(driver);
		
		// Verify Document is in Documents
		documentText = VMPAppraisalOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Other"), "Other document is not displayed in VMP Client Portal");
		Assert.assertTrue(documentText.contains("Sales Contract"), "Sales Contract did not sync to VMP Client Portal");
		Assert.assertTrue(!documentText.contains("Market Information"), "Market Information should not sync to VMP Client Portal");
		
		// Click on Sales Contract
		perform.clickInTable_Contains(driver, "Sales Contract");
		
		// Wait for text to update
		perform.waitForText(driver, VMPAppraisalOrderDetails.documents_txt(driver), "Test PDF.pdf");
		documentText = VMPAppraisalOrderDetails.documents_txt(driver).getText();
		
		// Verify file name and uploaded by
		Assert.assertTrue(documentText.contains("Test PDF.pdf"), "Document name is incorrect in Documents");
		Assert.assertTrue(documentText.contains("Automation OriginatorEVF"), "Uploaded By is incorrect in Documents");
		
		// Create boolean for both Other documents
		originator = false;
		lender = false;
		
		// Get Number Of Other documents
		docs = driver.findElements(By.xpath("//td[text()='Other']"));
		for (WebElement doc: docs)
		{
			
			// Click first Other document
			perform.click(driver,doc);
			
			Thread.sleep(3000);
			
			documentText = VMPAppraisalOrderDetails.documents_txt(driver).getText();
			
			// Wait for text
			perform.waitForText(driver, VMPAppraisalOrderDetails.documents_txt(driver), "Automation");
			
			if (documentText.contains("Automation OriginatorEVF") && originator == false)
			{
				// Verify Uploaded By and Document Name
				Assert.assertTrue(documentText.contains("TestPDF.pdf"), "TestPDF.pdf is not showing as the Document Name in Order Documents");
				originator = true;
			}
			
			else if (documentText.contains("Automation EVFLender") && lender == false)
			{
				// Verify Uploaded By and Document Name
				Assert.assertTrue(documentText.contains("Test PDF_1.pdf"), "Test PDF_1.pdf is not showing as the Document Name in Order Documents");
				lender = true;
			}
				
		} // end for loop
		
		Assert.assertTrue(originator==true, "The Other document uploaded by Automation OriginatorEVF is not displaying");
		Assert.assertTrue(lender==true, "The Other document uploaded by Automation EVFLender is not displaying");

		// Log in to Secure
		secure.login(driver, "EVFLender", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, StoredVariables.getloanID().get(), "Tracking number");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("In Progress"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getAWSAccountsID().get() + "-" + StoredVariables.getloanID().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Verify order details
		secure.verifyResidentialAppraisalOrderDetails(driver);
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify the history
		Assert.assertTrue(history.contains("History (In Progress)"), "History (In Progress) is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Fee Changed by Client (Automation EVFLender)"), "Appraisal Fee Changed by Client (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal fee changed from $0 to $673"), "Appraisal fee changed from $0 to $673 is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFLender change fee comment"), "These are EVFLender change fee comment is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed by Client (Automation EVFLender)"), "Vendor due date changed by Client (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the order information");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFLender change due date comments"), "These are EVFLender change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed by AMC (" + amcCompany + ")"), "Vendor due date changed by Vendor (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the order information");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Message from AMC (" + amcCompany + ")"), "Message from Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from AMC (" + amcCompany + ") (Test PDF_1.pdf)"), "Document Uploaded from Vendor (Automation EVFAMC) (Test PDF_1.pdf)�is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by AMC (" + amcCompany + ")"), "Resumed by Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by AMC (" + amcCompany + ")"), "Delayed by Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraiser Accepted assignment"), "Appraiser Accepted assignment is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFLender)"), "Resumed by Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation EVFLender)"), "Comment - Action Required by Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFLender)"), "Message from Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFLender) (TestPDF.pdf)"), "Document Uploaded from Client (Automation EVFLender) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFLender) (Test PDF.pdf)"), "Document Uploaded from Client (Automation EVFLender) (Test PDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Client (Automation EVFLender)"), "Delayed by Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFLender)"), "Resumed by Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Client (Automation EVFLender)"), "On Hold by Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by AMC (" + amcCompany + ")"), "Order Changed by Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Order accepted by AMC (" + amcCompany + ") and In Progress"), "Order accepted by Vendor (Automation EVFAMC) and In Progress is missing from the audit trail");
		Assert.assertTrue(history.contains("Order automatically accepted."), "Order automatically accepted. is missing from the audit trail");
		Assert.assertTrue(history.contains("Order automatically assigned"), "Order automatically assigned is missing from the audit trail");
		Assert.assertTrue(history.contains("Assigned to Automation"), "Assigned to Automation EVFAMC is missing from the audit trail");
		
		// Verify new Due Date
		Assert.assertTrue(SOrderDetails.orderDue_txt(driver).getText().contains(StoredVariables.getcalendarDateShort().get()), "New Due Date is not correct");
		
		// Verify fee
		Assert.assertTrue(SOrderDetails.assignmentInformation_txt(driver).getText().contains("673"), "Fee should have updated");
		
		// Verify Other Document is in Documents
		documentText = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(!documentText.contains("Market Information"), "Market Information should not sync to Secure");
		Assert.assertTrue(documentText.contains("Other"), "Other did not sync to Secure");
		Assert.assertTrue(documentText.contains("Sales Contract"), "Sales Contract did not sync to Secure");
		
		// Verify Sales ContractDocument is in Documents
		documentText = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Sales Contract"), "Sales Contract did not sync to Secure");
		
		// Click on Sales Contract
		perform.clickInTable_Contains(driver, "Sales Contract");
		
		// Wait for text to update
		perform.waitForText(driver, SOrderDetails.documents_txt(driver), "Test PDF.pdf");
		documentText = SOrderDetails.documents_txt(driver).getText();
		
		// Verify file name and uploaded by
		Assert.assertTrue(documentText.contains("Test PDF.pdf"), "Document name is incorrect in Documents");
		Assert.assertTrue(documentText.contains("Automation EVFLender"), "Uploaded By is incorrect in Documents");
		
		// Create boolean for both Other documents
		amc = false;
		lender = false;
		
		// Get Number Of Other documents
		docs = driver.findElements(By.xpath("//td[text()='Other']"));
		for (WebElement doc: docs)
		{
			
			// Click first Other document
			perform.click(driver,doc);
			
			Thread.sleep(3000);
			
			documentText = SOrderDetails.documents_txt(driver).getText();
			
			// Wait for text
			perform.waitForText(driver, SOrderDetails.documents_txt(driver), "Automation");
			
			if (documentText.contains("Automation EVFAMC") && amc == false)
			{
				// Verify Uploaded By and Document Name
				Assert.assertTrue(documentText.contains("Test PDF_1.pdf"), "Test PDF_1.pdf is not showing as the Document Name in Order Documents");
				amc = true;
			}
			
			else if (documentText.contains("Automation EVFLender") && lender == false)
			{
				// Verify Uploaded By and Document Name
				Assert.assertTrue(documentText.contains("TestPDF.pdf"), "TestPDF.pdf is not showing as the Document Name in Order Documents");
				lender = true;
			}
				
		} // end for loop
		
		Assert.assertTrue(amc==true, "The Other document uploaded by Automation EVFAMC is not displaying");
		Assert.assertTrue(lender==true, "The Other document uploaded by Automation EVFLender is not displaying");
		
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
			secure.viewXSiteOrderFromSecure(driver, "EVFAMC", StoredVariables.getpassword().get(), StoredVariables.getloanIDAMC().get());
			
			// Get history text
			perform.waitForElementToBeVisible(driver, XOrders.toolbar(), "id");
			history = XOrders.history_txt(driver).getText();
			String address = StoredVariables.getpropertyInformationAddress().get() + " " + StoredVariables.getpropertyInformationCity().get() + ", " + StoredVariables.getpropertyInformationStateAbbr().get() + " " + StoredVariables.getpropertyInformationZip().get();
			
			// Verify the history
			Assert.assertTrue(history.contains("History (In Progress)"), "History (In Progress) is missing from the order information");
			Assert.assertTrue(history.contains("Appraisal Fee Changed (Automation EVFLender)"), "Appraisal Fee Changed (Automation EVFLender) is missing from the order information");
			Assert.assertTrue(history.contains("Appraisal fee changed from $0 to $673"), "Appraisal fee changed from $0 to $673 is missing from the order information");
			Assert.assertTrue(history.contains("These are EVFLender change fee comments"), "These are EVFLender change fee comments is missing from the order information");
			Assert.assertTrue(history.contains("Vendor due date changed (Automation EVFLender)"), "Vendor due date changed (Automation EVFLender) is missing from the order information");
			Assert.assertTrue(history.contains("These are EVFLender change due date comments"), "These are EVFLender change due date comments is missing from the order information");
			Assert.assertTrue(history.contains("Vendor due date changed (Automation EVFAMC)"), "Vendor due date changed (Automation EVFAMC) is missing from the order information");
			Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the order information");
			Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
			Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the order information");
			Assert.assertTrue(history.contains("Message (Automation EVFAMC)"), "Message (Automation EVFAMC) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the audit trail");
			Assert.assertTrue(history.contains("Document Uploaded (Automation EVFAMC) (Test PDF_1.pdf)"), "Document Uploaded (Automation EVFAMC) (Test PDF_1.pdf) is missing from the audit trail");
			Assert.assertTrue(history.contains("Resumed (Automation EVFAMC)"), "Resumed (Automation EVFAMC) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
			Assert.assertTrue(history.contains("Delayed (Automation EVFAMC)"), "Delayed (Automation EVFAMC) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
			Assert.assertTrue(history.contains("Appraiser Accepted assignment by Appraiser"), "Appraiser Accepted assignment by Appraiser is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
			Assert.assertTrue(history.contains("Resumed (Automation EVFLender)"), "Resumed (Automation EVFLender) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
			Assert.assertTrue(history.contains("Comment - Action Required (Automation EVFLender)"), "Comment - Action Required (Automation EVFLender) is missing from the audit trail");
			Assert.assertTrue(history.contains("Comment - Action Required for " + address), "Comment - Action Required for " + address + " is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
			Assert.assertTrue(history.contains("Message (Automation EVFLender)"), "Message (Automation EVFLender) is missing from the audit trail");
			Assert.assertTrue(history.contains("Order message for " + address), "Order message for " + address + " is missing from the audit trail");
			Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
			Assert.assertTrue(history.contains("Document Uploaded (Automation EVFLender) (TestPDF.pdf)"), "Document Uploaded (Automation EVFLender) (TestPDF.pdf) is missing from the audit trail");
			Assert.assertTrue(history.contains("Document Uploaded (Automation EVFLender) (Test PDF.pdf)"), "Document Uploaded (Automation EVFLender) (Test PDF.pdf) is missing from the audit trail");
			Assert.assertTrue(history.contains("Delayed (Automation EVFLender)"), "Delayed (Automation EVFLender) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
			Assert.assertTrue(history.contains("Resumed (Automation EVFLender)"), "Resumed (Automation EVFLender) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
			Assert.assertTrue(history.contains("On Hold (Automation EVFLender)"), "On Hold (Automation EVFLender) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
			Assert.assertTrue(history.contains("Order Changed (Automation EVFAMC)"), "Order Changed (Automation EVFAMC) is missing from the audit trail");
			Assert.assertTrue(history.contains("To View Change History:"), "To View Change History: is missing from the audit trail");
			Assert.assertTrue(history.contains("In Progress (Automation EVFAMC)"), "In Progress (Automation EVFAMC) is missing from the audit trail");
			Assert.assertTrue(history.contains("Awaiting acceptance"), "Awaiting acceptance is missing from the audit trail");
			
			// Verify order details
			perform.verifyXSiteOrderDetailsForAMC(driver);
			
			// Verify documents
			perform.waitForText(driver, XOrders.documents_txt(driver), "Other");
			String documentsText = XOrders.documents_txt(driver).getText();
			Assert.assertTrue(!documentsText.contains("Market Information"), "Market Information should not sync to Secure");
			Assert.assertTrue(documentsText.contains("Other"), "Other document is missing from the documents section of the XSite - " + documentsText);
			Assert.assertTrue(documentsText.contains("TestPDF"), "TestPDF document is missing from the documents section of the XSite - " + documentsText);
			Assert.assertTrue(documentsText.contains("Test PDF_1"), "Test PDF_1 document is missing from the documents section of the XSite - " + documentsText);
			Assert.assertTrue(documentsText.contains("Sales Contract"), "Sales Contract document is missing from the documents section of the XSite - " + documentsText);
			Assert.assertTrue(documentsText.contains("Test PDF"), "Test PDF document is missing from the documents section of the XSite - " + documentsText);
			
			// Verify comments
			String comments = XOrders.comments_txt(driver).getText();
			Assert.assertTrue(comments.contains("These are edited comments by EVFAMC"), "Additional Comments section is missing info");
			
			// Verify new Due Date
			Assert.assertTrue(XOrders.dueDate_txt(driver).getText().equals(StoredVariables.getcalendarDateShort().get()), "New Due Date is not correct");
			
			// Verify fee
			Assert.assertTrue(XOrders.fee_txt(driver).getText().equals("$673.00"), "Fee should have updated");
			
			// Close XSite order
			perform.closeNewWindow(driver);
		
		} // end else
		
		// Log in to Vendors
		vendors.login(driver, "Appraiser3", StoredVariables.getpassword().get());
		
		// Search for order
		vendors.findOrder(driver, StoredVariables.getloanIDAMC().get(), "Tracking Number");
		
		// Verify order status
		Assert.assertTrue(VOrders.ordersGrid_txt(driver).getText().contains("In Progress"), "The order is not in the correct status");
		
		// Click on the order from the orders grid
		perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, VOrderDetails.orderInformation_txt(), "id");
		
		// Get order information text
		history = VOrderDetails.orderInformation_txt(driver).getText();
		
		// Verify audit trail
		Assert.assertTrue(history.contains("History (In Progress)"), "History (In Progress) is missing from the order information");
		Assert.assertTrue(!history.contains("These are EVFLender change fee comments"), "These are EVFLender change fee comments is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed by Client (Automation EVFAMC)"), "Vendor due date changed by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFLender change due date comments"), "These are EVFLender change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Fee Changed by Client (Automation EVFAMC)"), "Appraisal Fee Changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraisal fee changed from $350 to $525."), "Appraisal fee changed from $350 to $525. is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFAMC change fee comments"), "These are EVFAMC change fee comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed by Client (Automation EVFAMC)"), "Vendor due date changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the audit trail");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser3)"), "Message from Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Apostrophes License.pdf)"), "Document Uploaded from Appraiser (Automation Appraiser3) (Apostrophes License.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Test PDF_1.pdf)"), "Document Uploaded from Appraiser (Automation Appraiser3) (Test PDF_1.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Appraiser (Automation Appraiser3)"), "Resumed by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Appraiser (Automation Appraiser3)"), "Delayed by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order accepted by Appraiser (Automation Appraiser3) and In Progress"), "Order accepted by Appraiser (Automation Appraiser3) and In Progress is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation EVFAMC)"), "Comment - Action Required by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFAMC)"), "Message from Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(!history.contains("Document Uploaded from Client (Automation EVFAMC) (Test PDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC) (Test PDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Client (Automation EVFAMC)"), "Delayed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Client (Automation EVFAMC)"), "On Hold by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser3"), "Awaiting acceptance by Automation Appraiser3 is missing from the audit trail");
		
		// Verify new Due Date
		Assert.assertTrue(VOrderDetails.orderInformation_txt(driver).getText().contains(StoredVariables.getcalendarDateShort().get()), "New Due Date is not correct");
		
		// Verify fee
		Assert.assertTrue(VOrderDetails.orderInformation_txt(driver).getText().contains("$525"), "Fee should not have updated");
		
		// Get comments
		additionalComments = VOrderDetails.additionalComments_txt(driver).getText();
		
		// Verify both VMP and MN comments are displayed
		Assert.assertTrue(additionalComments.contains("These are edited comments by EVFAMC"), "Additional Comments section is missing info");
		
		// View Order Details
		vendors.verifyOrderDetails(driver);
		
		// Verify Document is in Documents
		documentText = VOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Other"), "Other did not sync to Vendors");
		Assert.assertTrue(documentText.contains("Market Information"), "Market Information did not sync to Vendors");
		Assert.assertTrue(!documentText.contains("Sales Contract"), "Sales Contract should not sync to Vendors");

		// Log in to Secure
		secure.login(driver, "EVFAMC", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, StoredVariables.getloanIDAMC().get(), "Tracking number");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("In Progress"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getAWSAccountsID().get() + "-" + StoredVariables.getloanIDAMC().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Verify order details
		secure.verifyResidentialAppraisalOrderDetails(driver);
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify the history
		Assert.assertTrue(history.contains("History (In Progress)"), "History (In Progress) is missing from the order information");
		Assert.assertTrue(!history.contains("These are EVFLender change fee comments"), "These are EVFLender change fee comments is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed by Client (Automation EVFAMC)"), "Vendor due date changed by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFLender change due date comments"), "These are EVFLender change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Fee Changed by Client (Automation EVFAMC)"), "Appraisal Fee Changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraisal fee changed from $350 to $525."), "Appraisal fee changed from $350 to $525. is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFAMC change fee comments"), "These are EVFAMC change fee comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed by Client (Automation EVFAMC)"), "Vendor due date changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the audit trail");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser3)"), "Message from Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Apostrophes License.pdf)"), "Document Uploaded from Vendor (Automation Appraiser3) (Apostrophes License.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Test PDF_1.pdf)"), "Document Uploaded from Vendor (Automation Appraiser3) (Test PDF_1.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Appraiser (Automation Appraiser3)"), "Resumed by Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Appraiser (Automation Appraiser3)"), "Delayed by Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order accepted by Appraiser (Automation Appraiser3) and In Progress"), "Order accepted by Vendor (Automation Appraiser3) and In Progress is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation EVFAMC)"), "Comment - Action Required by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFAMC)"), "Message from Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(!history.contains("Document Uploaded from Client (Automation EVFAMC) (Test PDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC) (Test PDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Client (Automation EVFAMC)"), "Delayed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Client (Automation EVFAMC)"), "On Hold by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser3"), "Awaiting acceptance by Automation Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Reassigned by Client (Automation EVFAMC) to Automation Appraiser3"), "Reassigned by Client (Automation EVFAMC) to Automation Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by Client (Automation EVFAMC)"), "Order Changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("To View Change History:"), "To View Change History: is missing from the audit trail");
		Assert.assertTrue(history.contains("Requires assignment"), "Requires assignment is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance"), "Awaiting acceptance is missing from the audit trail");
		
		// Verify new Due Date
		Assert.assertTrue(SOrderDetails.orderDue_txt(driver).getText().contains(StoredVariables.getcalendarDateShort().get()), "New Due Date is not correct");
		
		// Verify fee
		Assert.assertTrue(SOrderDetails.assignmentInformation_txt(driver).getText().contains("525"), "Fee should not have updated");
		
		// Verify Other Document is in Documents
		documentText = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Other"), "Other did not sync to Secure");
		Assert.assertTrue(documentText.contains("Market Information"), "Market Information did not sync to Secure");
		Assert.assertTrue(!documentText.contains("Sales Contract"), "Sales Contract should not sync to Secure");
		
		// If browser is Firefox, skip the rest of the test
		if (StoredVariables.getbrowser().get().equals("Firefox"))
		{
			System.out.println("Skipped the rest of this matrix test becuase the XSite functionality does not work in Firefox");
			// Log a skip in the extent report
			test.log(LogStatus.SKIP, "<span class='label info'>SKIPPED</span>", "<pre>Skipped the rest of this matrix test becuase the XSite functionality does not work in Firefox</pre>");
			String callersClass = new Exception().getStackTrace()[0].getClassName();
			throw new SkipException("The rest of " + callersClass + " was skipped becuase the XSite functionality does not work in " + StoredVariables.getbrowser().get());
		} // end if
		else
		{
		
			// View XSite order
			secure.viewXSiteOrderFromSecure(driver, "EVFAMC", StoredVariables.getpassword().get(), StoredVariables.getloanIDAMC().get());
			
			// Get history text
			perform.waitForElementToBeVisible(driver, XOrders.toolbar(), "id");
			history = XOrders.history_txt(driver).getText();
			String address = StoredVariables.getpropertyInformationAddress().get() + " " + StoredVariables.getpropertyInformationCity().get() + ", " + StoredVariables.getpropertyInformationStateAbbr().get() + " " + StoredVariables.getpropertyInformationZip().get();
			
			// Verify the history
			Assert.assertTrue(history.contains("History (In Progress)"), "History (In Progress) is missing from the order information");
			Assert.assertTrue(history.contains("Appraisal Fee Changed (Automation EVFLender)"), "Appraisal Fee Changed (Automation EVFLender) is missing from the order information");
			Assert.assertTrue(history.contains("Appraisal fee changed from $0 to $673"), "Appraisal fee changed from $0 to $673 is missing from the order information");
			Assert.assertTrue(history.contains("These are EVFLender change fee comments"), "These are EVFLender change fee comments is missing from the order information");
			Assert.assertTrue(history.contains("Vendor due date changed (Automation EVFLender)"), "Vendor due date changed (Automation EVFLender) is missing from the order information");
			Assert.assertTrue(history.contains("These are EVFLender change due date comments"), "These are EVFLender change due date comments is missing from the order information");
			Assert.assertTrue(history.contains("Vendor due date changed (Automation EVFAMC)"), "Vendor due date changed (Automation EVFAMC) is missing from the order information");
			Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the order information");
			Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
			Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the order information");
			Assert.assertTrue(history.contains("Message (Automation EVFAMC)"), "Message (Automation EVFAMC) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the audit trail");
			Assert.assertTrue(history.contains("Document Uploaded (Automation EVFAMC) (Test PDF_1.pdf)"), "Document Uploaded (Automation EVFAMC) (Test PDF_1.pdf) is missing from the audit trail");
			Assert.assertTrue(history.contains("Resumed (Automation EVFAMC)"), "Resumed (Automation EVFAMC) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
			Assert.assertTrue(history.contains("Delayed (Automation EVFAMC)"), "Delayed (Automation EVFAMC) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
			Assert.assertTrue(history.contains("Appraiser Accepted assignment by Appraiser"), "Appraiser Accepted assignment by Appraiser is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
			Assert.assertTrue(history.contains("Resumed (Automation EVFLender)"), "Resumed (Automation EVFLender) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
			Assert.assertTrue(history.contains("Comment - Action Required (Automation EVFLender)"), "Comment - Action Required (Automation EVFLender) is missing from the audit trail");
			Assert.assertTrue(history.contains("Comment - Action Required for " + address), "Comment - Action Required for " + address + " is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
			Assert.assertTrue(history.contains("Message (Automation EVFLender)"), "Message (Automation EVFLender) is missing from the audit trail");
			Assert.assertTrue(history.contains("Order message for " + address), "Order message for " + address + " is missing from the audit trail");
			Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
			Assert.assertTrue(history.contains("Document Uploaded (Automation EVFLender) (TestPDF.pdf)"), "Document Uploaded (Automation EVFLender) (TestPDF.pdf) is missing from the audit trail");
			Assert.assertTrue(history.contains("Document Uploaded (Automation EVFLender) (Test PDF.pdf)"), "Document Uploaded (Automation EVFLender) (Test PDF.pdf) is missing from the audit trail");
			Assert.assertTrue(history.contains("Delayed (Automation EVFLender)"), "Delayed (Automation EVFLender) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
			Assert.assertTrue(history.contains("Resumed (Automation EVFLender)"), "Resumed (Automation EVFLender) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
			Assert.assertTrue(history.contains("On Hold (Automation EVFLender)"), "On Hold (Automation EVFLender) is missing from the audit trail");
			Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
			Assert.assertTrue(history.contains("Order Changed (Automation EVFAMC)"), "Order Changed (Automation EVFAMC) is missing from the audit trail");
			Assert.assertTrue(history.contains("To View Change History:"), "To View Change History: is missing from the audit trail");
			Assert.assertTrue(history.contains("In Progress (Automation EVFAMC)"), "In Progress (Automation EVFAMC) is missing from the audit trail");
			Assert.assertTrue(history.contains("Awaiting acceptance"), "Awaiting acceptance is missing from the audit trail");
			
			// Verify order details
			perform.verifyXSiteOrderDetailsForAMC(driver);
			
			// Verify documents
			perform.waitForText(driver, XOrders.documents_txt(driver), "Other");
			String documentsText = XOrders.documents_txt(driver).getText();
			Assert.assertTrue(!documentsText.contains("Market Information"), "Market Information should not sync to Secure");
			Assert.assertTrue(documentsText.contains("Other"), "Other document is missing from the documents section of the XSite - " + documentsText);
			Assert.assertTrue(documentsText.contains("TestPDF"), "TestPDF document is missing from the documents section of the XSite - " + documentsText);
			Assert.assertTrue(documentsText.contains("Test PDF_1"), "Test PDF_1 document is missing from the documents section of the XSite - " + documentsText);
			Assert.assertTrue(documentsText.contains("Sales Contract"), "Sales Contract document is missing from the documents section of the XSite - " + documentsText);
			Assert.assertTrue(documentsText.contains("Test PDF"), "Test PDF document is missing from the documents section of the XSite - " + documentsText);
			
			// Verify comments
			String comments = XOrders.comments_txt(driver).getText();
			Assert.assertTrue(comments.contains("These are edited comments by EVFAMC"), "Additional Comments section is missing info");
			
			// Verify new Due Date
			Assert.assertTrue(XOrders.dueDate_txt(driver).getText().equals(StoredVariables.getcalendarDateShort().get()), "New Due Date is not correct");
			
			// Verify fee
			Assert.assertTrue(XOrders.fee_txt(driver).getText().equals("$673.00"), "Fee should have updated");
			
			// Click Edit
			perform.click(driver,XOrders.edit_btn(driver));
			
			// Wait for Order Date textbox
			perform.waitForElementToBeClickable(driver, XEditOrder.dueDate_txtbx(), "id");
			
			// Get due date
			String originalDueDate = XEditOrder.dueDate_txtbx(driver).getAttribute("value");
			String newDueDate = StoredVariables.getorderDueDateShort().get();
			
			// Get the FHA Case Number
			String originalFHACaseNumber = XEditOrder.fhaCaseNumber_txtbx(driver).getAttribute("value");
			String newFHACaseNumber = "897658";
			
			// Get the Loan Number
			String originalLoanNumber = XEditOrder.loanNumber_txtbx(driver).getAttribute("value");
			String newLoanNumber = "963258";
			
			// Get a new date to enter as the new due date
			perform.getNewDate(driver, 15);
			
			// Edit the order date
			XEditOrder.dueDate_txtbx(driver).clear();
			perform.type(driver,XEditOrder.dueDate_txtbx(driver), newDueDate);
			
			// Edit the FHA Case Number
			XEditOrder.fhaCaseNumber_txtbx(driver).clear();
			perform.type(driver,XEditOrder.fhaCaseNumber_txtbx(driver), newFHACaseNumber);
			
			// Edit the Loan Number
			XEditOrder.loanNumber_txtbx(driver).clear();
			perform.type(driver,XEditOrder.loanNumber_txtbx(driver), newLoanNumber);
			
			Thread.sleep(1000);
			
			// Click OK
			perform.click(driver,XEditOrder.ok_btn(driver));
			
			// Wait for FHA Case Number Checkbox
			perform.waitForElementToBeClickable(driver, XEditOrder.orderEditOK_btn(), "id");
			
			// Click FHA Case Number checkbox
			perform.click(driver,XEditOrder.fhaCaseNumber_chkbx(driver));
			
			// Click Lender Case Number checkbox
			perform.click(driver,XEditOrder.lenderCaseNumber_chkbx(driver));
			
			// Click OK
			perform.click(driver,XEditOrder.orderEditOK_btn(driver));
			
			Thread.sleep(5000);
			
			// Wait for Edit button
			perform.waitForElementToBeClickable(driver, XOrders.edit_btn(), "cssSelector");
			
			// Verify first row text
			Assert.assertTrue(XOrders.firstRow_txt(driver).getText().contains("Order Changed (Automation EVFAMC)"), "Order Changed (Automation EVFAMC) should be displayed in the history");
			
			// Get Due Date and verify it changed
			String displayedDueDate = XOrders.dueDate_txt(driver).getText();
			
			// Get FHA Number and verify it changed
			String displayedFHANumber = XOrders.fhaNumber_txt(driver).getText();
			
			// Get Loan Number and verify it changed
			String displayedLoanNumber = XOrders.loanNumber_txt(driver).getText();
			
			// Verify the Due Date is the new Due Date
			Assert.assertTrue(displayedDueDate.equals(newDueDate), "The Due Date is not the new value");
			
			// Verify the FHA Number is the new FHA Number
			Assert.assertTrue(displayedFHANumber.equals(newFHACaseNumber), "The FHA Number is not the new value");
			
			// Verify the Loan Number is the new Loan Number
			Assert.assertTrue(displayedLoanNumber.equals(newLoanNumber), "The Loan Number is not the new value");
			
			// Click the Edit button
			perform.click(driver,XOrders.edit_btn(driver));
			
			// Wait for due date text box
			perform.waitForElementToBeClickable(driver, XEditOrder.dueDate_txtbx(), "id");
			
			// Verify the new Due Date
			Assert.assertTrue(XEditOrder.dueDate_txtbx(driver).getAttribute("value").equals(newDueDate), "The Due Date was not able to be updated");
			
			// Verify the new FHA Case Number
			Assert.assertTrue(XEditOrder.fhaCaseNumber_txtbx(driver).getAttribute("value").equals(newFHACaseNumber), "The FHA Loan Number was not able to be updated");
			
			// Verify the new Loan Number
			Assert.assertTrue(XEditOrder.loanNumber_txtbx(driver).getAttribute("value").equals(newLoanNumber), "The Loan Number was not able to be updated");
			
			// Set due date back to what it was
			perform.getNewDate(driver, 12);
			StoredVariables.getorderDueDateLong().set(StoredVariables.getnewDateLong().get());
			StoredVariables.getorderDueDateShort().set(StoredVariables.getnewDateShort().get());
			
			// Set the Due Date back to it's original date
			XEditOrder.dueDate_txtbx(driver).clear();
			perform.type(driver,XEditOrder.dueDate_txtbx(driver), originalDueDate);
			
			// Set the FHA Case Number back to it's original number
			XEditOrder.fhaCaseNumber_txtbx(driver).clear();
			perform.type(driver,XEditOrder.fhaCaseNumber_txtbx(driver), originalFHACaseNumber);
			
			// Set the Loan Number back to it's original number
			XEditOrder.loanNumber_txtbx(driver).clear();
			perform.type(driver,XEditOrder.loanNumber_txtbx(driver), originalLoanNumber);
			
			// Verify the original Due Date
			Assert.assertTrue(XEditOrder.dueDate_txtbx(driver).getAttribute("value").equals(originalDueDate), "The Due Date was not set back to the original value");
			
			// Verify the original FHA Case Number
			Assert.assertTrue(XEditOrder.fhaCaseNumber_txtbx(driver).getAttribute("value").equals(originalFHACaseNumber), "The FHA Loan Number was not set back to the original value");
			
			// Verify the original Loan Number
			Assert.assertTrue(XEditOrder.loanNumber_txtbx(driver).getAttribute("value").equals(originalLoanNumber), "The Loan Number was not set back to the original value");
			
			// Click OK
			perform.click(driver,XEditOrder.ok_btn(driver));
			
			// Wait for FHA Case Number Checkbox
			perform.waitForElementToBeClickable(driver, XEditOrder.fhaCaseNumber_chkbx(), "id");
			
			// Click FHA Case Number checkbox
			perform.click(driver,XEditOrder.fhaCaseNumber_chkbx(driver));
			
			// Click Lender Case Number checkbox
			perform.click(driver,XEditOrder.lenderCaseNumber_chkbx(driver));
			
			// Click OK
			perform.click(driver,XEditOrder.orderEditOK_btn(driver));
			
			// Wait for Edit button
			perform.waitForElementToBeClickable(driver, XOrders.edit_btn(), "cssSelector");
			
			// Verify first row text
			Assert.assertTrue(XOrders.firstRow_txt(driver).getText().contains("Order Changed (Automation EVFAMC)"), "Order Changed (Automation EVFAMC) should be displayed in the history");
			
			// Get Due Date and verify it changed
			displayedDueDate = XOrders.dueDate_txt(driver).getText();
			
			// Get FHA Number and verify it changed
			displayedFHANumber = XOrders.fhaNumber_txt(driver).getText();
			
			// Get Loan Number and verify it changed
			displayedLoanNumber = XOrders.loanNumber_txt(driver).getText();
			
			// Verify the Due Date is the new Due Date
			Assert.assertTrue(displayedDueDate.equals(originalDueDate), "The Due Date is not the original value");
			
			// Verify the FHA Number is the new FHA Number
			Assert.assertTrue(displayedFHANumber.equals(originalFHACaseNumber), "The FHA Number is not the original value");
			
			// Verify the Loan Number is the new Loan Number
			Assert.assertTrue(displayedLoanNumber.equals(originalLoanNumber), "The Loan Number is not the original value");
			
		} // end else

		// Click Message button
		perform.click(driver,XOrders.message_btn(driver));
		
		Thread.sleep(2000);
		
		// Go to new window
	    Iterator<String> windowIterator = driver.getWindowHandles()
	            .iterator();
	    while (windowIterator.hasNext()) {
	        String windowHandle1 = windowIterator.next();
	        driver.switchTo().window(windowHandle1);
	        String title = driver.getTitle();
	        System.out.println("title = " + title);
	        if (title.contains("StatusNotify")) {
	        	System.out.println("break");
	            break;
	        } // end if
	    } // end while loop
	    
		// Get and pass the Window Handle for Send Message
		StoredVariables.getthirdWinHandle().set(driver.getWindowHandle());
		System.out.println("thirdWinHandle = " + StoredVariables.getthirdWinHandle().get());
		
		// Switch to the new window
		driver.switchTo().window(StoredVariables.getthirdWinHandle().get());
		
		// Wait for Message textbox
		perform.waitForElementToBeClickable(driver, XSendMessage.message_txtbx(), "id");
		
		// Enter message
		perform.type(driver,XSendMessage.message_txtbx(driver), "This is a test message from EVFAMC on the XSite");
		
		// Click Save
		perform.click(driver,XSendMessage.save_btn(driver));
		
		Thread.sleep(2000);
		
		// Switch to the XSite window
		driver.switchTo().window(StoredVariables.getnewWinHandle().get());
		driver.switchTo().frame("Main");
		
		// Get history text
		history = XOrders.history_txt(driver).getText();
		
		// Verify the history
		Assert.assertTrue(history.contains("Message (Automation EVFAMC)"), "Message (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("This is a test message from EVFAMC on the XSite"), "This is a test message from EVFAMC on the XSite is missing from the order information");

		// Click Status
		perform.click(driver,XOrders.status_btn(driver));
		
		Thread.sleep(2000);
		
		// Go to new window
	    windowIterator = driver.getWindowHandles()
	            .iterator();
	    while (windowIterator.hasNext()) {
	        String windowHandle1 = windowIterator.next();
	        driver.switchTo().window(windowHandle1);
	        String title = driver.getTitle();
	        System.out.println("title = " + title);
	        if (title.contains("StatusNotify")) {
	        	System.out.println("break");
	            break;
	        } // end if
	    } // end while loop
	    
		// Get and pass the Window Handle for Send Message
		StoredVariables.getthirdWinHandle().set(driver.getWindowHandle());
		System.out.println("thirdWinHandle = " + StoredVariables.getthirdWinHandle().get());
		
		// Switch to the new window
		driver.switchTo().window(StoredVariables.getthirdWinHandle().get());
		
		// Wait for Status dropdown
		perform.waitForElementToBeClickable(driver, XStatus.status_dropdown(), "id");
		
		// Select Comment - Action Required
		perform.selectDropdownOption(driver, XStatus.status_dropdown(driver), "Comment - Action Required");
		
		// Enter message
		perform.type(driver,XStatus.message_txtbx(driver), "This is an action required message by EVFAMC");
		
		// Click Save
		perform.click(driver,XStatus.save_btn(driver));
		
		Thread.sleep(2000);
		
		// Switch to the XSite window
		driver.switchTo().window(StoredVariables.getnewWinHandle().get());
		driver.switchTo().frame("Main");
		
		// Get history text
		history = XOrders.history_txt(driver).getText();
		
		// Verify the history
		Assert.assertTrue(history.contains("Comment - Action Required (Automation EVFAMC)"), "Comment - Action Required (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("This is an action required message by EVFAMC"), "This is an action required message by EVFAMC is missing from the order information");
		
		// Close XSite order
		perform.closeNewWindow(driver);

		// View XSite order
		secure.viewXSiteOrderFromSecure(driver, "EVFLender", StoredVariables.getpassword().get(), StoredVariables.getloanID().get());
		
		// Get history text
		perform.waitForElementToBeVisible(driver, XOrders.toolbar(), "id");
		history = XOrders.history_txt(driver).getText();
		String address = StoredVariables.getpropertyInformationAddress().get() + " " + StoredVariables.getpropertyInformationCity().get() + ", " + StoredVariables.getpropertyInformationStateAbbr().get() + " " + StoredVariables.getpropertyInformationZip().get();
		
		// Wait for db to update
		perform.waitForDBUpdateForHistoryTextInVMPXSite(driver, "This is an action required message by EVFAMC");
		
		// Recapture the text from the history
		Thread.sleep(5000);
		perform.waitForElementToBeClickable(driver, XOrders.history_txt(), "id");
		history = XOrders.history_txt(driver).getText();
		
		// Verify the history
		Assert.assertTrue(history.contains("History (In Progress)"), "History (In Progress) is missing from the order information");
		Assert.assertTrue(history.contains("Comment - Action Required (Automation EVFLender)"), "Comment - Action Required (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("This is an action required message by EVFAMC"), "This is an action required message by EVFAMC is missing from the order information");
		Assert.assertTrue(history.contains("Message (Automation EVFLender)"), "Message (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("This is a test message from EVFAMC on the XSite"), "This is a test message from EVFAMC on the XSite is missing from the order information");
		Assert.assertTrue(history.contains("Order Changed (Automation EVFLender)"), "Order Changed (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(!history.contains("These are EVFAMC change fee comments"), "These are EVFAMC change fee comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed (Automation EVFLender)"), "Vendor due date changed (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the order information");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Message (Automation EVFLender)"), "Message (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Document Uploaded (Automation EVFLender) (Test PDF_1.pdf)"), "Document Uploaded (Automation EVFLender) (Test PDF_1.pdf) is missing from the order information");
		Assert.assertTrue(history.contains("Resumed (Automation EVFLender)"), "Resumed (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Delayed (Automation EVFLender)"), "Delayed (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Vendor Accepted Assignment (Automation EVFLender)"), "Vendor Accepted Assignment (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the order information");
		Assert.assertTrue(history.contains("Resumed (Automation EVFLender)"), "Resumed (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required (Automation OriginatorEVF)"), "Comment - Action Required (Automation OriginatorEVF) is missing from the order information");
		Assert.assertTrue(history.contains("Comment - Action Required for " + address), "Comment - Action Required for " + address + " is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message (Automation OriginatorEVF)"), "Message (Automation OriginatorEVF) is missing from the audit trail");
		Assert.assertTrue(history.contains("Order message for " + address), "Order message for " + address + " is missing from the order information");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded (Automation OriginatorEVF) (TestPDF.pdf)"), "Document Uploaded (Automation OriginatorEVF) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded (Automation OriginatorEVF) (Test PDF.pdf)"), "Document Uploaded (Automation OriginatorEVF) (Test PDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed (Automation OriginatorEVF)"), "Delayed (Automation OriginatorEVF) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed (Automation OriginatorEVF)"), "Resumed (Automation OriginatorEVF) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold (Automation OriginatorEVF)"), "On Hold (Automation OriginatorEVF) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the order information");
		Assert.assertTrue(history.contains("In Progress (Automation OriginatorEVF)"), "In Progress (Automation OriginatorEVF) is missing from the audit trail");
		
		// Verify order details
		perform.verifyXSiteOrderDetailsForLender(driver);
		
		// Verify documents
		String documentsText = XOrders.documents_txt(driver).getText();
		Assert.assertTrue(documentsText.contains("Other"), "Other document is missing from the documents section of the XSite");
		Assert.assertTrue(documentsText.contains("TestPDF"), "TestPDF document is missing from the documents section of the XSite");
		Assert.assertTrue(documentsText.contains("Test PDF_1"), "TestPDF document is missing from the documents section of the XSite");
		Assert.assertTrue(documentsText.contains("Sales Contract"), "Sales Contract document is missing from the documents section of the XSite");
		Assert.assertTrue(documentsText.contains("Test PDF"), "Test PDF document is missing from the documents section of the XSite");
		Assert.assertTrue(!documentsText.contains("Apostrophes License"), "Test PDF document is missing from the documents section of the XSite");
		
		// Verify comments
		String comments = XOrders.comments_txt(driver).getText();
		Assert.assertTrue(comments.contains("These are test additional comments"), "Additional Comments section is missing info");
		
		// Verify new Due Date
		Assert.assertTrue(XOrders.dueDate_txt(driver).getText().equals(StoredVariables.getorderDueDateShort().get()), "Due Date is not correct. Variable set to = " + StoredVariables.getorderDueDateShort().get() + "     The on-screen data = " + XOrders.dueDate_txt(driver).getText());
		
		// Verify fee
		Assert.assertTrue(XOrders.fee_txt(driver).getText().equals("$350.00"), "Fee should not update");
		
		// Close XSite order
		perform.closeNewWindow(driver);
		
		// Login to VMP Client Portal
		vmp.login(driver, "EVFLender", "OriginatorEVF", StoredVariables.getpassword().get());
		
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

		Assert.assertTrue(history.contains("Comment - Action Required by Automation EVFLender"), "Comment - Action Required by Automation EVFLender is missing from the order information");
		Assert.assertTrue(history.contains("This is an action required message by EVFAMC"), "This is an action required message by EVFAMC is missing from the order information");
		Assert.assertTrue(history.contains("Message by Automation EVFLender"), "Message by Automation EVFLender is missing from the order information");
		Assert.assertTrue(history.contains("This is a test message from EVFAMC on the XSite"), "This is a test message from EVFAMC on the XSite is missing from the order information");
		Assert.assertTrue(history.contains("Order Changed by Automation EVFLender"), "Order Changed by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are EVFAMC change fee comments"), "These are EVFAMC change fee comments is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are EVFLender change fee comments"), "These are EVFLender change fee comments is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed by Automation EVFLender"), "Vendor due date changed by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the audit trail");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFLender change due date comments"), "These are EVFLender change due date comments is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation EVFLender"), "Message by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation EVFLender"), "Document Uploaded by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("Other"), "Other is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF_1.pdf"), "Test PDF_1.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation EVFLender"), "Resumed by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation EVFLender"), "Delayed by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraiser Accepted Assignment by Automation EVFLender"), "Appraiser Accepted Assignment by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorEVF"), "Resumed by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Automation OriginatorEVF"), "Comment - Action Required by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation OriginatorEVF"), "Message by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorEVF"), "Document Uploaded by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Other"), "Other is missing from the audit trail");
		Assert.assertTrue(history.contains("TestPDF.pdf"), "TestPDF.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorEVF"), "Document Uploaded by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Sales Contract"), "Sales Contract is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF.pdf"), "Test PDF.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation OriginatorEVF"), "Delayed by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorEVF"), "Resumed by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Automation OriginatorEVF"), "On Hold by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("In Progress by Automation OriginatorEVF"), "In Progress by Automation OriginatorEVF is missing from the audit trail");
		
		// Verify new Due Date
		Assert.assertTrue(VMPAppraisalOrderDetails.orderDetails_txt(driver).getText().contains(StoredVariables.getorderDueDateShort().get()), "Due Date is not correct");
		
		// Verify fee
		Assert.assertTrue(VMPAppraisalOrderDetails.orderDetails_txt(driver).getText().contains("$350"), "Fee should not update");
		
		// Verify the order details
		vmp.verifyAppraisalOrderDetails(driver);
		
		// Verify Document is in Documents
		documentText = VMPAppraisalOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Other"), "Other document is not displayed in VMP Client Portal");
		Assert.assertTrue(documentText.contains("Sales Contract"), "Sales Contract did not sync to VMP Client Portal");
		Assert.assertTrue(!documentText.contains("Market Information"), "Market Information should not sync to VMP Client Portal");
		
		// Click on Sales Contract
		perform.clickInTable_Contains(driver, "Sales Contract");
		
		// Wait for text to update
		perform.waitForText(driver, VMPAppraisalOrderDetails.documents_txt(driver), "Test PDF.pdf");
		documentText = VMPAppraisalOrderDetails.documents_txt(driver).getText();
		
		// Verify file name and uploaded by
		Assert.assertTrue(documentText.contains("Test PDF.pdf"), "Document name is incorrect in Documents");
		Assert.assertTrue(documentText.contains("Automation OriginatorEVF"), "Uploaded By is incorrect in Documents");
		
		// Create boolean for both Other documents
		originator = false;
		lender = false;
		
		// Get Number Of Other documents
		docs = driver.findElements(By.xpath("//td[text()='Other']"));
		for (WebElement doc: docs)
		{
			
			// Click first Other document
			perform.click(driver,doc);
			
			Thread.sleep(3000);
			
			documentText = VMPAppraisalOrderDetails.documents_txt(driver).getText();
			
			// Wait for text
			perform.waitForText(driver, VMPAppraisalOrderDetails.documents_txt(driver), "Automation");
			
			if (documentText.contains("Automation OriginatorEVF") && originator == false)
			{
				// Verify Uploaded By and Document Name
				Assert.assertTrue(documentText.contains("TestPDF.pdf"), "TestPDF.pdf is not showing as the Document Name in Order Documents");
				originator = true;
			}
			
			else if (documentText.contains("Automation EVFLender") && lender == false)
			{
				// Verify Uploaded By and Document Name
				Assert.assertTrue(documentText.contains("Test PDF_1.pdf"), "Test PDF_1.pdf is not showing as the Document Name in Order Documents");
				lender = true;
			}
			
		} // end for loop
		
		Assert.assertTrue(originator==true, "The Other document uploaded by Automation OriginatorEVF is not displaying");
		Assert.assertTrue(lender==true, "The Other document uploaded by Automation EVFLender is not displaying");
		
		// Log in to Vendors
		vendors.login(driver, "Appraiser3", StoredVariables.getpassword().get());
		
		// Search for order
		vendors.findOrder(driver, StoredVariables.getloanIDAMC().get(), "Tracking Number");
		
		// Verify order status
		Assert.assertTrue(VOrders.ordersGrid_txt(driver).getText().contains("In Progress"), "The order is not in the correct status");
		
		// Click on the order from the orders grid
		perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, VOrderDetails.orderInformation_txt(), "id");
		
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
		
		// Verify the correct Vendor due date is correct
		Assert.assertTrue(VOrderDetails.inspectionScheduledCalendar_txtbx(driver).getAttribute("value").equals(StoredVariables.getcalendarDateLong().get()), "Date selected from calendar is the wrong date");
		
		// Add notes
		perform.type(driver,VOrderDetails.inspectionScheduledNotes_txtbx(driver), "These are Inspection Scheduled notes from Appraiser3");
		
		// Click OK
		perform.click(driver,VOrderDetails.inspectionScheduledOk_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, VOrderDetails.orderInformation_txt(), "id");
		
		perform.sleep(driver, 15);

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
		
		// Verify the correct Vendor due date is correct
		Assert.assertTrue(VOrderDetails.inspectionScheduledCalendar_txtbx(driver).getAttribute("value").equals(StoredVariables.getcalendarDateLong().get()), "Date selected from calendar is the wrong date");
		
		// Add notes
		perform.type(driver,VOrderDetails.inspectionScheduledNotes_txtbx(driver), "These are Inspection Complete notes from Appraiser3");
		
		// Click OK
		perform.click(driver,VOrderDetails.inspectionScheduledOk_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, VOrderDetails.orderInformation_txt(), "id");
		
		perform.sleep(driver, 15);

		// Click Message
		perform.click(driver,VOrderDetails.sendMessage_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for OK button to be clickable
		perform.waitForElementToBeClickable(driver, VOrderDetails.sendMessageOk_btn(), "cssSelector");
		
		// Wait for message box
		perform.waitForElementToBeClickable(driver, VOrderDetails.sendMessageNotes_txtbx(), "id");
		
		// Add notes
		perform.type(driver,VOrderDetails.sendMessageNotes_txtbx(driver), "These are Message notes from Appraiser3");
		
		// Click OK button
		perform.click(driver,VOrderDetails.sendMessageOk_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, VOrderDetails.orderInformation_txt(), "id");
		
		perform.sleep(driver, 15);
		
		// Complete the order using the HTTP Post
		vendors.completeOrderByHTTPPost(driver, "Appraiser3", StoredVariables.getpassword().get(), StoredVariables.getloanIDAMC().get(), "Complete.xml");
		
		// Get order information text
		history = VOrderDetails.orderInformation_txt(driver).getText();
		
		// Verify audit trail
		Assert.assertTrue(history.contains("History (In QC - Level One)"), "History (In QC - Level One) is missing from the order information");
		Assert.assertTrue(history.contains("Order delivered by Appraiser (Automation Appraiser3) and is now In QC - Level One"), "Order delivered by Appraiser (Automation Appraiser3) and is now In QC - Level One is missing from the order information");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser3)"), "Message from Appraiser (Automation Appraiser3) is missing from the order information");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser3"), "These are Message notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Inspection Complete by Appraiser (Automation Appraiser3)"), "Inspection Complete by Appraiser (Automation Appraiser3) is missing from the order information");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Inspection Scheduled by Appraiser (Automation Appraiser3)"), "Inspection Scheduled by Appraiser (Automation Appraiser3) is missing from the order information");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFAMC)"), "Message from Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("This is a test message from EVFAMC on the XSite"), "This is a test message from EVFAMC on the XSite is missing from the order information");
		Assert.assertTrue(history.contains("Order Changed by AMC (Automation"+env+"EVFAMC)"), "Order Changed by AMC (Automation"+env+"EVFAMC) is missing from the order information");
		Assert.assertTrue(!history.contains("These are EVFLender change fee comments"), "These are EVFLender change fee comments is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed by Client (Automation EVFAMC)"), "Vendor due date changed by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFLender change due date comments"), "These are EVFLender change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Fee Changed by Client (Automation EVFAMC)"), "Appraisal Fee Changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraisal fee changed from $350 to $525."), "Appraisal fee changed from $350 to $525. is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFAMC change fee comments"), "These are EVFAMC change fee comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed by Client (Automation EVFAMC)"), "Vendor due date changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the audit trail");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser3)"), "Message from Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Apostrophes License.pdf)"), "Document Uploaded from Appraiser (Automation Appraiser3) (Apostrophes License.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Test PDF_1.pdf)"), "Document Uploaded from Appraiser (Automation Appraiser3) (Test PDF_1.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Appraiser (Automation Appraiser3)"), "Resumed by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Appraiser (Automation Appraiser3)"), "Delayed by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order accepted by Appraiser (Automation Appraiser3) and In Progress"), "Order accepted by Appraiser (Automation Appraiser3) and In Progress is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation EVFAMC)"), "Comment - Action Required by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFAMC)"), "Message from Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(!history.contains("Document Uploaded from Client (Automation EVFAMC) (Test PDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC) (Test PDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Client (Automation EVFAMC)"), "Delayed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Client (Automation EVFAMC)"), "On Hold by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser3"), "Awaiting acceptance by Automation Appraiser3 is missing from the audit trail");
		
		// Verify new Due Date
		Assert.assertTrue(VOrderDetails.orderInformation_txt(driver).getText().contains(StoredVariables.getorderDueDateShort().get()), "New Due Date is not correct");
		
		// Verify fee
		Assert.assertTrue(VOrderDetails.orderInformation_txt(driver).getText().contains("$525"), "Fee should not have updated");
		
		// Get comments
		additionalComments = VOrderDetails.additionalComments_txt(driver).getText();
		
		// Verify both VMP and MN comments are displayed
		Assert.assertTrue(additionalComments.contains("These are edited comments by EVFAMC"), "Additional Comments section is missing info");
		
		// View Order Details
		vendors.verifyOrderDetails(driver);
		
		// Verify Document is in Documents
		documentText = VOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Other"), "Other did not sync to Vendors");
		Assert.assertTrue(documentText.contains("Market Information"), "Market Information did not sync to Vendors");
		Assert.assertTrue(!documentText.contains("Sales Contract"), "Sales Contract should not sync to Vendors");
		Assert.assertTrue(documentText.contains("Order Documents"), "Order Documents is not showing in the Order Documents");
		Assert.assertTrue(documentText.contains("Report PDF"), "Report PDF is not showing in the Order Documents");
		Assert.assertTrue(documentText.contains("Completed Report (Current)"), "Completed Report (Current) is not showing in the Order Documents");
		Assert.assertTrue(documentText.contains(StoredVariables.gettodaysDateLong().get()), "The Date Uploaded is not showing in the Order Documents");
		
		// Click Sales Contract
		perform.clickInTable_Contains(driver, "Report PDF");
		
		// Wait for text
		perform.waitForText(driver, VOrderDetails.documents_txt(driver), "Automation Appraiser3");
		documentText = VOrderDetails.documents_txt(driver).getText();
		
		// Verify Uploaded By and Document Name
		Assert.assertTrue(documentText.contains("Test PDF.pdf"), "Test PDF.pdf is not showing as the Document Name in Order Documents");
		Assert.assertTrue(documentText.contains("Automation Appraiser3"), "Automation Appraiser3 is not showing as the Document Name in Order Documents");
		
		// Click Sales Contract
		perform.clickInTable_Contains(driver, "MISMO XML");
		
		// Wait for text
		perform.waitForText(driver, VOrderDetails.documents_txt(driver), "Test PDF.xml");
		documentText = VOrderDetails.documents_txt(driver).getText();
		
		// Verify Uploaded By and Document Name
		Assert.assertTrue(documentText.contains("Test PDF.xml"), "Test PDF.xml is not showing as the Document Name in Order Documents");
		Assert.assertTrue(documentText.contains("Automation Appraiser3"), "Automation Appraiser3 is not showing as the Document Name in Order Documents");
		
		// View XSite order
		secure.viewXSiteOrderFromSecure(driver, "EVFLender", StoredVariables.getpassword().get(), StoredVariables.getloanID().get());
		
		// Get history text
		perform.waitForElementToBeVisible(driver, XOrders.toolbar(), "id");
		history = XOrders.history_txt(driver).getText();
		address = StoredVariables.getpropertyInformationAddress().get() + " " + StoredVariables.getpropertyInformationCity().get() + ", " + StoredVariables.getpropertyInformationStateAbbr().get() + " " + StoredVariables.getpropertyInformationZip().get();
		
		// Wait for db to update
//		perform.waitForDBUpdateForHistoryTextInVMPXSite(driver, "Pending Quality Review (Automation EVFLender)");
		
		// Switch in to the correct frame
		driver.switchTo().defaultContent();
		driver.switchTo().frame("Main");
		
		// Recapture the text from the history
		perform.waitForElementToBeClickable(driver, XOrders.history_txt(driver));
		history = XOrders.history_txt(driver).getText();
		
		// Verify the history
		Assert.assertTrue(!history.contains("History (Pending Quality Review)"), "History (Pending Quality Review) is missing from the order information");
		Assert.assertTrue(!history.contains("Pending Quality Review (Automation EVFLender)"), "Pending Quality Review (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("Message (Automation EVFLender)"), "Message (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser3"), "These are Message notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Inspection Complete (Automation EVFLender)"), "Inspection Complete (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("Inspected on"), "Inspected on is missing from the order information");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Inspection Scheduled (Automation EVFLender)"), "Inspection Scheduled (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("Inspection date is"), "Inspection date is is missing from the order information");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Comment - Action Required (Automation EVFLender)"), "Comment - Action Required (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("This is an action required message by EVFAMC"), "This is an action required message by EVFAMC is missing from the order information");
		Assert.assertTrue(history.contains("Order Changed (Automation EVFLender)"), "Order Changed (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("Message (Automation EVFLender)"), "Message (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("This is a test message from EVFAMC on the XSite"), "This is a test message from EVFAMC on the XSite is missing from the order information");
		Assert.assertTrue(!history.contains("These are EVFLender change fee comments"), "These are EVFLender change fee comments is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFLender change due date comments"), "These are EVFLender change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed (Automation EVFLender)"), "Vendor due date changed (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the order information");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Message (Automation EVFLender)"), "Message (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Document Uploaded (Automation EVFLender) (Test PDF_1.pdf)"), "Document Uploaded (Automation EVFLender) (Test PDF_1.pdf) is missing from the order information");
		Assert.assertTrue(history.contains("Resumed (Automation EVFLender)"), "Resumed (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Delayed (Automation EVFLender)"), "Delayed (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Vendor Accepted Assignment (Automation EVFLender)"), "Vendor Accepted Assignment (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the order information");
		Assert.assertTrue(history.contains("Resumed (Automation EVFLender)"), "Resumed (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required (Automation OriginatorEVF)"), "Comment - Action Required (Automation OriginatorEVF) is missing from the order information");
		Assert.assertTrue(history.contains("Comment - Action Required for " + address), "Comment - Action Required for " + address + " is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message (Automation OriginatorEVF)"), "Message (Automation OriginatorEVF) is missing from the audit trail");
		Assert.assertTrue(history.contains("Order message for " + address), "Order message for " + address + " is missing from the order information");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded (Automation OriginatorEVF) (TestPDF.pdf)"), "Document Uploaded (Automation OriginatorEVF) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded (Automation OriginatorEVF) (Test PDF.pdf)"), "Document Uploaded (Automation OriginatorEVF) (Test PDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed (Automation OriginatorEVF)"), "Delayed (Automation OriginatorEVF) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed (Automation OriginatorEVF)"), "Resumed (Automation OriginatorEVF) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold (Automation OriginatorEVF)"), "On Hold (Automation OriginatorEVF) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the order information");
		Assert.assertTrue(history.contains("In Progress (Automation OriginatorEVF)"), "In Progress (Automation OriginatorEVF) is missing from the audit trail");
		
		// Verify order details
		perform.verifyXSiteOrderDetailsForLender(driver);
		
		// Verify documents
		documentsText = XOrders.documents_txt(driver).getText();
		Assert.assertTrue(documentsText.contains("Other"), "Other document is missing from the documents section of the XSite");
		Assert.assertTrue(documentsText.contains("TestPDF"), "TestPDF document is missing from the documents section of the XSite");
		Assert.assertTrue(documentsText.contains("Test PDF_1"), "TestPDF document is missing from the documents section of the XSite");
		Assert.assertTrue(documentsText.contains("Sales Contract"), "Sales Contract document is missing from the documents section of the XSite");
		Assert.assertTrue(documentsText.contains("Test PDF"), "Test PDF document is missing from the documents section of the XSite");
		Assert.assertTrue(!documentsText.contains("Apostrophes License"), "Apostrophes License should not sync to the XSite");
		Assert.assertTrue(!documentsText.contains("No UAD Hard Stops.xml"), "No UAD Hard Stops.xml should not sync to the XSite");
		
		// Verify comments
		comments = XOrders.comments_txt(driver).getText();
		Assert.assertTrue(comments.contains("These are test additional comments"), "Additional Comments section is missing info");
		
		// Verify new Due Date
		Assert.assertTrue(XOrders.dueDate_txt(driver).getText().equals(StoredVariables.getorderDueDateShort().get()), "New Due Date is not correct - It is: " + XOrders.dueDate_txt(driver).getText() + ", but should be: " + StoredVariables.getorderDueDateShort().get());
		
		// Verify fee
		Assert.assertTrue(XOrders.fee_txt(driver).getText().equals("$350.00"), "Fee should not update");
		
		// Close XSite order
		perform.closeNewWindow(driver);

		// Login to VMP Client Portal
		vmp.login(driver, "EVFLender", "OriginatorEVF", StoredVariables.getpassword().get());
		
		// Search for order
		vmp.findOrder(driver, StoredVariables.getloanIDVMP().get(), "Tracking #");
		
		// Verify Order Status
		Assert.assertTrue(VMPOrders.orderStatus_txt(driver).getText().equals("Inspection Complete"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());
		
		Thread.sleep(1500);
		
		// Wait for Edit Property Contacts link
		perform.waitForElementToBeClickable(driver, VMPAppraisalOrderDetails.editPropertyContacts_lnk(), "id");
		
		// Verify the audit trail
		history = VMPAppraisalOrderDetails.history_txt(driver).getText();
		
		Assert.assertTrue(!history.contains("Pending Quality Review by Automation EVFLender"), "Pending Quality Review by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation EVFLender"), "Message by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser3"), "These are Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Complete by Automation EVFLender"), "Inspection Complete by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspected on"), "Inspected on is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Scheduled by Automation EVFLender"), "Inspection Scheduled by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection date is"), "Inspection date is is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Automation EVFLender"), "Comment - Action Required by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("This is an action required message by EVFAMC"), "This is an action required message by EVFAMC is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by Automation EVFLender"), "Order Changed by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by Automation EVFLender"), "Order Changed by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation EVFLender"), "Message by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("This is a test message from EVFAMC on the XSite"), "This is a test message from EVFAMC on the XSite is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are EVFLender change fee comments"), "These are EVFLender change fee comments is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed by Automation EVFLender"), "Vendor due date changed by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the audit trail");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFLender change due date comments"), "These are EVFLender change due date comments is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation EVFLender"), "Message by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation EVFLender"), "Document Uploaded by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("Other"), "Other is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF_1.pdf"), "Test PDF_1.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation EVFLender"), "Resumed by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation EVFLender"), "Delayed by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraiser Accepted Assignment by Automation EVFLender"), "Appraiser Accepted Assignment by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorEVF"), "Resumed by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Automation OriginatorEVF"), "Comment - Action Required by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation OriginatorEVF"), "Message by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorEVF"), "Document Uploaded by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Other"), "Other is missing from the audit trail");
		Assert.assertTrue(history.contains("TestPDF.pdf"), "TestPDF.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorEVF"), "Document Uploaded by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Sales Contract"), "Sales Contract is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF.pdf"), "Test PDF.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation OriginatorEVF"), "Delayed by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorEVF"), "Resumed by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Automation OriginatorEVF"), "On Hold by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("In Progress by Automation OriginatorEVF"), "In Progress by Automation OriginatorEVF is missing from the audit trail");
		
		// Verify new Due Date
		Assert.assertTrue(VMPAppraisalOrderDetails.orderDetails_txt(driver).getText().contains(StoredVariables.getorderDueDateShort().get()), "New Due Date is not correct");
		
		// Verify fee
		Assert.assertTrue(VMPAppraisalOrderDetails.orderDetails_txt(driver).getText().contains("$350"), "Fee should not update");
		
		// Verify the order details
		vmp.verifyAppraisalOrderDetails(driver);
		
		// Verify Document is in Documents
		documentText = VMPAppraisalOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Other"), "Other document is not displayed in VMP Client Portal");
		Assert.assertTrue(documentText.contains("Sales Contract"), "Sales Contract did not sync to VMP Client Portal");
		Assert.assertTrue(!documentText.contains("Market Information"), "Market Information should not sync to VMP Client Portal");
		Assert.assertTrue(!documentText.contains("MISMO XML"), "MISMO XML should not sync to VMP Client Portal");
		Assert.assertTrue(!documentText.contains("Report PDF"), "Report PDF should not sync to VMP Client Portal");
		
		// Click on Sales Contract
		perform.clickInTable_Contains(driver, "Sales Contract");
		
		// Wait for text to update
		perform.waitForText(driver, VMPAppraisalOrderDetails.documents_txt(driver), "Test PDF.pdf");
		documentText = VMPAppraisalOrderDetails.documents_txt(driver).getText();
		
		// Verify file name and uploaded by
		Assert.assertTrue(documentText.contains("Test PDF.pdf"), "Document name is incorrect in Documents");
		Assert.assertTrue(documentText.contains("Automation OriginatorEVF"), "Uploaded By is incorrect in Documents");
		
		// Create boolean for both Other documents
		originator = false;
		lender = false;
		
		// Get Number Of Other documents
		docs = driver.findElements(By.xpath("//td[text()='Other']"));
		for (WebElement doc: docs)
		{
			
			// Click first Other document
			perform.click(driver,doc);
			
			Thread.sleep(3000);
			
			documentText = VMPAppraisalOrderDetails.documents_txt(driver).getText();
			
			// Wait for text
			perform.waitForText(driver, VMPAppraisalOrderDetails.documents_txt(driver), "Automation");
			
			if (documentText.contains("Automation OriginatorEVF") && originator == false)
			{
				// Verify Uploaded By and Document Name
				Assert.assertTrue(documentText.contains("TestPDF.pdf"), "TestPDF.pdf is not showing as the Document Name in Order Documents");
				originator = true;
			}
			
			else if (documentText.contains("Automation EVFLender") && lender == false)
			{
				// Verify Uploaded By and Document Name
				Assert.assertTrue(documentText.contains("Test PDF_1.pdf"), "Test PDF_1.pdf is not showing as the Document Name in Order Documents");
				lender = true;
			}
				
		} // end for loop
		
		Assert.assertTrue(originator==true, "The Other document uploaded by Automation OriginatorEVF is not displaying");
		Assert.assertTrue(lender==true, "The Other document uploaded by Automation EVFLender is not displaying");
		
		// Log in to Secure
		secure.login(driver, "EVFLender", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, StoredVariables.getloanID().get(), "Tracking number");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("Pending Quality Review"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getAWSAccountsID().get() + "-" + StoredVariables.getloanID().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Verify order details
		secure.verifyResidentialAppraisalOrderDetails(driver);
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify the history
		Assert.assertTrue(history.contains("History (Pending Quality Review)"), "History (Pending Quality Review) is missing from the order information");
		Assert.assertTrue(history.contains("Order delivered by AMC (" + amcCompany + ") and is now Pending Quality Review"), "Order delivered by Vendor (Automation EVFAMC) and is now Pending Quality Review is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from AMC (" + amcCompany + ")"), "Message from Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser3"), "These are Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Complete by AMC (" + amcCompany + ")"), "Inspection Complete by Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspected on"), "Inspected on is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Scheduled by AMC (" + amcCompany + ")"), "Inspection Scheduled by Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection date is"), "Inspection date is is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by AMC (" + amcCompany + ")"), "Comment - Action Required by Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("This is an action required message by EVFAMC"), "This is an action required message by EVFAMC is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from AMC (" + amcCompany + ")"), "Message from Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("This is a test message from EVFAMC on the XSite"), "This is a test message from EVFAMC on the XSite is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by AMC (" + amcCompany + ")"), "Order Changed by Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraisal Fee Changed by Client (Automation EVFLender)"), "Appraisal Fee Changed by Client (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal fee changed from $0 to $673"), "Appraisal fee changed from $0 to $673 is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFLender change fee comment"), "These are EVFLender change fee comment is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed by Client (Automation EVFLender)"), "Vendor due date changed by Client (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the order information");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFLender change due date comments"), "These are EVFLender change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed by AMC (" + amcCompany + ")"), "Vendor due date changed by Vendor (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the order information");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Message from AMC (" + amcCompany + ")"), "Message from Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from AMC (" + amcCompany + ") (Test PDF_1.pdf)"), "Document Uploaded from Vendor (Automation EVFAMC) (Test PDF_1.pdf)�is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by AMC (" + amcCompany + ")"), "Resumed by Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by AMC (" + amcCompany + ")"), "Delayed by Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraiser Accepted assignment"), "Appraiser Accepted assignment is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFLender)"), "Resumed by Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation EVFLender)"), "Comment - Action Required by Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFLender)"), "Message from Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFLender) (TestPDF.pdf)"), "Document Uploaded from Client (Automation EVFLender) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFLender) (Test PDF.pdf)"), "Document Uploaded from Client (Automation EVFLender) (Test PDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Client (Automation EVFLender)"), "Delayed by Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFLender)"), "Resumed by Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Client (Automation EVFLender)"), "On Hold by Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by AMC (" + amcCompany + ")"), "Order Changed by Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Order accepted by AMC (" + amcCompany + ") and In Progress"), "Order accepted by Vendor (Automation EVFAMC) and In Progress is missing from the audit trail");
		Assert.assertTrue(history.contains("Order automatically accepted."), "Order automatically accepted. is missing from the audit trail");
		Assert.assertTrue(history.contains("Order automatically assigned"), "Order automatically assigned is missing from the audit trail");
		Assert.assertTrue(history.contains("Assigned to Automation"), "Assigned to Automation EVFAMC is missing from the audit trail");
		
		// Verify new Due Date
		Assert.assertTrue(SOrderDetails.orderDue_txt(driver).getText().contains(StoredVariables.getorderDueDateShort().get()), "New Due Date is not correct");
		
		// Verify fee
		Assert.assertTrue(SOrderDetails.assignmentInformation_txt(driver).getText().contains("673"), "Fee should have updated");
		
		// Verify Other Document is in Documents
		documentText = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(!documentText.contains("Market Information"), "Market Information should not sync to Secure");
		Assert.assertTrue(!documentText.contains("MISMO XML"), "MISMO XML should not sync to Secure");
		Assert.assertTrue(!documentText.contains("Report PDF"), "Report PDF should not sync to Secure");
		Assert.assertTrue(documentText.contains("Other"), "Other did not sync to Secure");
		Assert.assertTrue(documentText.contains("Sales Contract"), "Sales Contract did not sync to Secure");
		
		// Verify Sales ContractDocument is in Documents
		documentText = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Sales Contract"), "Sales Contract did not sync to Secure");
		
		// Click on Sales Contract
		perform.clickInTable_Contains(driver, "Sales Contract");
		
		// Wait for text to update
		perform.waitForText(driver, SOrderDetails.documents_txt(driver), "Test PDF.pdf");
		documentText = SOrderDetails.documents_txt(driver).getText();
		
		// Verify file name and uploaded by
		Assert.assertTrue(documentText.contains("Test PDF.pdf"), "Document name is incorrect in Documents");
		Assert.assertTrue(documentText.contains("Automation EVFLender"), "Uploaded By is incorrect in Documents");
		
		// Create boolean for both Other documents
		amc = false;
		lender = false;
		
		// Get Number Of Other documents
		docs = driver.findElements(By.xpath("//td[text()='Other']"));
		for (WebElement doc: docs)
		{
			
			// Click first Other document
			perform.click(driver,doc);
			
			Thread.sleep(3000);
			
			documentText = SOrderDetails.documents_txt(driver).getText();
			
			// Wait for text
			perform.waitForText(driver, SOrderDetails.documents_txt(driver), "Automation");
			
			if (documentText.contains("Automation EVFAMC") && amc == false)
			{
				// Verify Uploaded By and Document Name
				Assert.assertTrue(documentText.contains("Test PDF_1.pdf"), "Test PDF_1.pdf is not showing as the Document Name in Order Documents");
				amc = true;
			}
			
			else if (documentText.contains("Automation EVFLender") && lender == false)
			{
				// Verify Uploaded By and Document Name
				Assert.assertTrue(documentText.contains("TestPDF.pdf"), "TestPDF.pdf is not showing as the Document Name in Order Documents");
				lender = true;
			}
				
		} // end for loop
		
		Assert.assertTrue(amc==true, "The Other document uploaded by Automation EVFAMC is not displaying");
		Assert.assertTrue(lender==true, "The Other document uploaded by Automation EVFLender is not displaying");

		// View XSite order
		secure.viewXSiteOrderFromSecure(driver, "EVFAMC", StoredVariables.getpassword().get(), StoredVariables.getloanIDAMC().get());
		
		// Get history text
		perform.waitForElementToBeVisible(driver, XOrders.toolbar(), "id");
		history = XOrders.history_txt(driver).getText();
		address = StoredVariables.getpropertyInformationAddress().get() + " " + StoredVariables.getpropertyInformationCity().get() + ", " + StoredVariables.getpropertyInformationStateAbbr().get() + " " + StoredVariables.getpropertyInformationZip().get();
		
		// Verify the history
		Assert.assertTrue(history.contains("History (Pending Quality Review)"), "History (Pending Quality Review) is missing from the order information");
		Assert.assertTrue(history.contains("Pending Quality Review (Automation EVFAMC)"), "Pending Quality Review (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Message (Automation EVFAMC)"), "Message (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser3"), "These are Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Complete (Automation EVFAMC)"), "Inspection Complete (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspected on"), "Inspected on is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Scheduled (Automation EVFAMC)"), "Inspection Scheduled (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection date is"), "Inspection date is is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required (Automation EVFAMC)"), "Comment - Action Required (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("This is an action required message by EVFAMC"), "This is an action required message by EVFAMC is missing from the audit trail");
		Assert.assertTrue(history.contains("Message (Automation EVFAMC)"), "Message (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("This is a test message from EVFAMC on the XSite"), "This is a test message from EVFAMC on the XSite is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed (Automation EVFAMC)"), "Order Changed (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraisal Fee Changed (Automation EVFLender)"), "Appraisal Fee Changed (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal fee changed from $0 to $673"), "Appraisal fee changed from $0 to $673 is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFLender change fee comments"), "These are EVFLender change fee comments is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed (Automation EVFLender)"), "Vendor due date changed (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFLender change due date comments"), "These are EVFLender change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed (Automation EVFAMC)"), "Vendor due date changed (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the order information");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Message (Automation EVFAMC)"), "Message (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded (Automation EVFAMC) (Test PDF_1.pdf)"), "Document Uploaded (Automation EVFAMC) (Test PDF_1.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed (Automation EVFAMC)"), "Resumed (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed (Automation EVFAMC)"), "Delayed (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraiser Accepted assignment by Appraiser"), "Appraiser Accepted assignment by Appraiser is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed (Automation EVFLender)"), "Resumed (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required (Automation EVFLender)"), "Comment - Action Required (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required for " + address), "Comment - Action Required for " + address + " is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message (Automation EVFLender)"), "Message (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("Order message for " + address), "Order message for " + address + " is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded (Automation EVFLender) (TestPDF.pdf)"), "Document Uploaded (Automation EVFLender) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded (Automation EVFLender) (Test PDF.pdf)"), "Document Uploaded (Automation EVFLender) (Test PDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed (Automation EVFLender)"), "Delayed (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed (Automation EVFLender)"), "Resumed (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold (Automation EVFLender)"), "On Hold (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed (Automation EVFAMC)"), "Order Changed (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("To View Change History:"), "To View Change History: is missing from the audit trail");
		Assert.assertTrue(history.contains("In Progress (Automation EVFAMC)"), "In Progress (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance"), "Awaiting acceptance is missing from the audit trail");
		
		// Verify order details
		perform.verifyXSiteOrderDetailsForAMC(driver);
		
		// Verify documents
		perform.waitForText(driver, XOrders.documents_txt(driver), "Other");
		documentsText = XOrders.documents_txt(driver).getText();
		Assert.assertTrue(!documentsText.contains("Market Information"), "Market Information should not sync to Secure");
		Assert.assertTrue(!documentsText.contains("No UAD Hard Stops.xml"), "No UAD Hard Stops.xml should not sync to the XSite");
		Assert.assertTrue(documentsText.contains("Other"), "Other document is missing from the documents section of the XSite - " + documentsText);
		Assert.assertTrue(documentsText.contains("TestPDF"), "TestPDF document is missing from the documents section of the XSite - " + documentsText);
		Assert.assertTrue(documentsText.contains("Test PDF_1"), "Test PDF_1 document is missing from the documents section of the XSite - " + documentsText);
		Assert.assertTrue(documentsText.contains("Sales Contract"), "Sales Contract document is missing from the documents section of the XSite - " + documentsText);
		Assert.assertTrue(documentsText.contains("Test PDF"), "Test PDF document is missing from the documents section of the XSite - " + documentsText);
		
		// Verify comments
		comments = XOrders.comments_txt(driver).getText();
		Assert.assertTrue(comments.contains("These are edited comments by EVFAMC"), "Additional Comments section is missing info");
		
		// Verify new Due Date
		Assert.assertTrue(XOrders.dueDate_txt(driver).getText().equals(StoredVariables.getorderDueDateShort().get()), "New Due Date is not correct");
		
		// Verify fee
		Assert.assertTrue(XOrders.fee_txt(driver).getText().equals("$673.00"), "Fee should have updated");
		
		// Close XSite order
		perform.closeNewWindow(driver);

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
		Assert.assertTrue(history.contains("Order delivered by Appraiser (Automation Appraiser3) and is now In QC - Level One"), "Order delivered by Appraiser (Automation Appraiser3) and is now In QC - Level One is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser3)"), "Message from Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser3"), "These are Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Complete by Appraiser (Automation Appraiser3)"), "Inspection Complete by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspected on"), "Inspected on is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Scheduled by Appraiser (Automation Appraiser3)"), "Inspection Scheduled by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection date is"), "Inspection date is is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFAMC)"), "Message from Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("This is a test message from EVFAMC on the XSite"), "This is a test message from EVFAMC on the XSite is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by AMC ("+amcCompany+")"), "Order Changed by Appraiser ("+amcCompany+") is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are EVFLender change fee comments"), "These are EVFLender change fee comments is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed by Client (Automation EVFAMC)"), "Vendor due date changed by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFLender change due date comments"), "These are EVFLender change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Fee Changed by Client (Automation EVFAMC)"), "Appraisal Fee Changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraisal fee changed from $350 to $525."), "Appraisal fee changed from $350 to $525. is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFAMC change fee comments"), "These are EVFAMC change fee comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed by Client (Automation EVFAMC)"), "Vendor due date changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the audit trail");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser3)"), "Message from Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Apostrophes License.pdf)"), "Document Uploaded from Appraiser (Automation Appraiser3) (Apostrophes License.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Test PDF_1.pdf)"), "Document Uploaded from Appraiser (Automation Appraiser3) (Test PDF_1.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Appraiser (Automation Appraiser3)"), "Resumed by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Appraiser (Automation Appraiser3)"), "Delayed by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order accepted by Appraiser (Automation Appraiser3) and In Progress"), "Order accepted by Appraiser (Automation Appraiser3) and In Progress is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation EVFAMC)"), "Comment - Action Required by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFAMC)"), "Message from Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(!history.contains("Document Uploaded from Client (Automation EVFAMC) (Test PDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC) (Test PDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Client (Automation EVFAMC)"), "Delayed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Client (Automation EVFAMC)"), "On Hold by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser3"), "Awaiting acceptance by Automation Appraiser3 is missing from the audit trail");
		
		// Verify new Due Date
		Assert.assertTrue(VOrderDetails.orderInformation_txt(driver).getText().contains(StoredVariables.getorderDueDateShort().get()), "New Due Date is not correct");
		
		// Verify fee
		Assert.assertTrue(VOrderDetails.orderInformation_txt(driver).getText().contains("$525"), "Fee should not have updated");
		
		// Get comments
		additionalComments = VOrderDetails.additionalComments_txt(driver).getText();
		
		// Verify both VMP and MN comments are displayed
		Assert.assertTrue(additionalComments.contains("These are edited comments by EVFAMC"), "Additional Comments section is missing info");
		
		// View Order Details
		vendors.verifyOrderDetails(driver);
		
		// Verify Document is in Documents
		documentText = VOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Report PDF"), "Report PDF did not sync to Vendors");
		Assert.assertTrue(documentText.contains("MISMO XML"), "MISMO XML did not sync to Vendors");
		Assert.assertTrue(documentText.contains("Other"), "Other did not sync to Vendors");
		Assert.assertTrue(documentText.contains("Market Information"), "Market Information did not sync to Vendors");
		Assert.assertTrue(!documentText.contains("Sales Contract"), "Sales Contract should not sync to Vendors");

		// Log in to Secure
		secure.login(driver, "EVFAMC", StoredVariables.getpassword().get());
		
		// Search for order
		orderNumberAMC = StoredVariables.getloanIDAMC().get();
		secure.findOrder(driver, orderNumberAMC, "Tracking number");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("In QC - Level One"), "The order is not in the correct status");
		
		// Open order
		awsAccountsID = StoredVariables.getAWSAccountsID().get();
		perform.doubleClickInTable(driver, awsAccountsID + "-" + orderNumberAMC);
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Verify order details0
		secure.verifyResidentialAppraisalOrderDetails(driver);
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify the history
		Assert.assertTrue(history.contains("History (In QC - Level One)"), "History (In QC - Level One) is missing from the order information");
		Assert.assertTrue(history.contains("Order delivered by Appraiser (Automation Appraiser3) and is now In QC - Level One"), "Order delivered by Vendor (Automation Appraiser3) and is now In QC - Level One is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser3)"), "Message from Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser3"), "These are Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Complete by Appraiser (Automation Appraiser3)"), "Inspection Complete by Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspected on"), "Inspected on is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Scheduled by Appraiser (Automation Appraiser3)"), "Inspection Scheduled by Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection date is"), "Inspection date is is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFAMC)"), "Message from Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("This is a test message from EVFAMC on the XSite"), "This is a test message from EVFAMC on the XSite is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by Client (Automation EVFAMC)"), "Order Changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are EVFLender change fee comments"), "These are EVFLender change fee comments is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed by Client (Automation EVFAMC)"), "Vendor due date changed by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFLender change due date comments"), "These are EVFLender change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Fee Changed by Client (Automation EVFAMC)"), "Appraisal Fee Changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraisal fee changed from $350 to $525."), "Appraisal fee changed from $350 to $525. is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFAMC change fee comments"), "These are EVFAMC change fee comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed by Client (Automation EVFAMC)"), "Vendor due date changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the audit trail");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser3)"), "Message from Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Apostrophes License.pdf)"), "Document Uploaded from Vendor (Automation Appraiser3) (Apostrophes License.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Test PDF_1.pdf)"), "Document Uploaded from Vendor (Automation Appraiser3) (Test PDF_1.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Appraiser (Automation Appraiser3)"), "Resumed by Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Appraiser (Automation Appraiser3)"), "Delayed by Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order accepted by Appraiser (Automation Appraiser3) and In Progress"), "Order accepted by Vendor (Automation Appraiser3) and In Progress is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation EVFAMC)"), "Comment - Action Required by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFAMC)"), "Message from Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(!history.contains("Document Uploaded from Client (Automation EVFAMC) (Test PDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC) (Test PDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Client (Automation EVFAMC)"), "Delayed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Client (Automation EVFAMC)"), "On Hold by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser3"), "Awaiting acceptance by Automation Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Reassigned by Client (Automation EVFAMC) to Automation Appraiser3"), "Reassigned by Client (Automation EVFAMC) to Automation Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by Client (Automation EVFAMC)"), "Order Changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("To View Change History:"), "To View Change History: is missing from the audit trail");
		Assert.assertTrue(history.contains("Requires assignment"), "Requires assignment is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance"), "Awaiting acceptance is missing from the audit trail");
		
		// Verify new Due Date
		Assert.assertTrue(SOrderDetails.orderDue_txt(driver).getText().contains(StoredVariables.getorderDueDateShort().get()), "New Due Date is not correct");
		
		// Verify fee
		Assert.assertTrue(SOrderDetails.assignmentInformation_txt(driver).getText().contains("525"), "Fee should not have updated");
		
		// Verify Other Document is in Documents
		documentText = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Report PDF"), "Report PDF did not sync to Secure");
		Assert.assertTrue(documentText.contains("MISMO XML"), "MISMO XML did not sync to Secure");
		Assert.assertTrue(documentText.contains("Other"), "Other did not sync to Secure");
		Assert.assertTrue(documentText.contains("Market Information"), "Market Information did not sync to Secure");
		Assert.assertTrue(!documentText.contains("Sales Contract"), "Sales Contract should not sync to Secure");
		
	}
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Click Set Status</li>
	 * 	<li>Click Submit to UCDP</li>
	 * 	<li>Get outside frames</li>
	 * 	<li>Get inside the attach document frame</li>
	 * 	<li>driver.switchTo().frame(driver.findElement(By.xpath("iframe[contains(@src,'UCDPSubmit.aspx')]")));</li>
	 * 	<li>Select Fannie Mae from Select GSE dropdown</li>
	 * 	<li>Select a la mode from Business unit dropdown</li>
	 * 	<li>Verify unit number is correct</li>
	 * 	<li>Enter internal update notes</li>
	 * 	<li>Verify Update status on VMP XSite is checked</li>
	 * 	<li>Click Send</li>
	 * 	<li>Verify message box text</li>
	 * 	<li>Click OK button</li>
	 * 	<li>Get outside frames</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Verify Other Document is in Documents</li>
	 * 	<li>Get the new history text</li>
	 * 	<li>Verify SSR is in the history</li>
	 * 	<li>Verify FNM SSR is in the Documents</li>
	 * 	<li>View XSite order</li>
	 * 	<li>Get history text</li>
	 * 	<li>Recapture the text from the history</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Verify documents</li>
	 * 	<li>Verify comments</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Close XSite order</li>
	 * 	<li>Login to VMP Client Portal</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify the audit trail</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Verify the order details</li>
	 * 	<li>Verify Document is in Documents</li>
	 * 	<li>Click on Sales Contract</li>
	 * 	<li>Verify file name and uploaded by</li>
	 * 	<li>Create boolean for both Other documents</li>
	 * 	<li>Get Number Of Other documents</li>
	 * 	<li>Click first Other document</li>
	 * 	<li>Verify Uploaded By and Document Name</li>
	 * 	<li>Verify Uploaded By and Document Name</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Verify Other Document is in Documents</li>
	 * 	<li>Verify Sales ContractDocument is in Documents</li>
	 * 	<li>Click on Sales Contract</li>
	 * 	<li>Verify file name and uploaded by</li>
	 * 	<li>Create boolean for both Other documents</li>
	 * 	<li>Get Number Of Other documents</li>
	 * 	<li>docs = driver.findElements(By.xpath("td[text()='Other']"));</li>
	 * 	<li>Click first Other document</li>
	 * 	<li>Verify Uploaded By and Document Name</li>
	 * 	<li>Verify Uploaded By and Document Name</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Verify documents</li>
	 * 	<li>Verify comments</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Close XSite order</li>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify order status</li>
	 * 	<li>Click on the order from the orders grid</li>
	 * 	<li>Get order information text</li>
	 * 	<li>Verify audit trail</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Get comments</li>
	 * 	<li>Verify both VMP and MN comments are displayed</li>
	 * 	<li>View Order Details</li>
	 * 	<li>Verify Document is in Documents</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify order details0</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Verify Other Document is in Documents</li>
	 * 	<li>Click Set Status</li>
	 * 	<li>Click Request revision</li>
	 * 	<li>Enter notes</li>
	 * 	<li>Check the Update status on VMP XSite checkbox</li>
	 * 	<li>Click OK button</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Verify Other Document is in Documents</li>
	 * 	<li>View XSite order</li>
	 * 	<li>Get history text</li>
	 * 	<li>Recapture the text from the history</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Verify documents</li>
	 * 	<li>Verify comments</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Close XSite order</li>
	 * 	<li>Login to VMP Client Portal</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify the audit trail</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Verify the order details</li>
	 * 	<li>Verify Document is in Documents</li>
	 * 	<li>Click on Sales Contract</li>
	 * 	<li>Verify file name and uploaded by</li>
	 * 	<li>Create boolean for both Other documents</li>
	 * 	<li>Get Number Of Other documents</li>
	 * 	<li>docs = driver.findElements(By.xpath("td[text()='Other']"));</li>
	 * 	<li>Click first Other document</li>
	 * 	<li>Verify Uploaded By and Document Name</li>
	 * 	<li>Verify Uploaded By and Document Name</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Verify Other Document is in Documents</li>
	 * 	<li>Verify Sales ContractDocument is in Documents</li>
	 * 	<li>Click on Sales Contract</li>
	 * 	<li>Verify file name and uploaded by</li>
	 * 	<li>Create boolean for both Other documents</li>
	 * 	<li>Get Number Of Other documents</li>
	 * 	<li>docs = driver.findElements(By.xpath("td[text()='Other']"));</li>
	 * 	<li>Click first Other document</li>
	 * 	<li>Verify Uploaded By and Document Name</li>
	 * 	<li>Verify Uploaded By and Document Name</li>
	 * 	<li>View XSite order</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Verify documents</li>
	 * 	<li>Verify comments</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Close XSite order</li>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify order status</li>
	 * 	<li>Click on the order from the orders grid</li>
	 * 	<li>Get order information text</li>
	 * 	<li>Verify audit trail</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Get comments</li>
	 * 	<li>Verify both VMP and MN comments are displayed</li>
	 * 	<li>View Order Details</li>
	 * 	<li>Verify Document is in Documents</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify order details0</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Verify Other Document is in Documents</li>
	 * 	<li>Login to VMP Client Portal</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Click Other Actions</li>
	 * 	<li>Click Cancel Revision Request</li>
	 * 	<li>Enter Notes</li>
	 * 	<li>Click OK</li>
	 * 	<li>Click OK</li>
	 * 	<li>View XSite order</li>
	 * 	<li>Get history text</li>
	 * 	<li>Recapture the text from the history</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Verify documents</li>
	 * 	<li>Verify comments</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Close XSite order</li>
	 * 	<li>Login to VMP Client Portal</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify the audit trail</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Verify the order details</li>
	 * 	<li>Verify Document is in Documents</li>
	 * 	<li>Click on Sales Contract</li>
	 * 	<li>Verify file name and uploaded by</li>
	 * 	<li>Create boolean for both Other documents</li>
	 * 	<li>Get Number Of Other documents</li>
	 * 	<li>docs = driver.findElements(By.xpath("td[text()='Other']"));</li>
	 * 	<li>Click first Other document</li>
	 * 	<li>Verify Uploaded By and Document Name</li>
	 * 	<li>Verify Uploaded By and Document Name</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Assert.assertTrue(history.contains("History (In QC - Level One)"), "History (In QC - Level One) is missing from the order information"); changed from Revision Needed</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Verify Other Document is in Documents</li>
	 * 	<li>Verify Sales ContractDocument is in Documents</li>
	 * 	<li>Click on Sales Contract</li>
	 * 	<li>Verify file name and uploaded by</li>
	 * 	<li>Create boolean for both Other documents</li>
	 * 	<li>Get Number Of Other documents</li>
	 * 	<li>docs = driver.findElements(By.xpath("td[text()='Other']"));</li>
	 * 	<li>Click first Other document</li>
	 * 	<li>Verify Uploaded By and Document Name</li>
	 * 	<li>Verify Uploaded By and Document Name</li>
	 * 	<li>View XSite order</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Assert.assertTrue(history.contains("History (Pending Quality Review)"), "History (Pending Quality Review) is missing from the order information"); changed from Revision Needed</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Verify documents</li>
	 * 	<li>Verify comments</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Close XSite order</li>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify order status</li>
	 * 	<li>Assert.assertTrue(VOrders.ordersGrid_txt(driver).getText().contains("In QC - Level One"), "The order is not in the correct status"); changed from Revision Needed</li>
	 * 	<li>Click on the order from the orders grid</li>
	 * 	<li>Get order information text</li>
	 * 	<li>Verify audit trail</li>
	 * 	<li>Assert.assertTrue(history.contains("History (In QC - Level One)"), "History (In QC - Level One) is missing from the order information"); changed from Revision Needed</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Get comments</li>
	 * 	<li>Verify both VMP and MN comments are displayed</li>
	 * 	<li>View Order Details</li>
	 * 	<li>Verify Document is in Documents</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify order details0</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Assert.assertTrue(history.contains("History (In QC - Level One)"), "History (In QC - Level One) is missing from the order information"); changed from Revision Needed</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Verify Other Document is in Documents</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Click Set status</li>
	 * 	<li>Click Request revision</li>
	 * 	<li>Enter notes</li>
	 * 	<li>Check the Update status on VMP XSite checkbox</li>
	 * 	<li>Click OK button</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Verify Other Document is in Documents</li>
	 * 	<li>Click Preferences</li>
	 * 	<li>Click VMP XSites button</li>
	 * 	<li>Click Configure Status Mapping link</li>
	 * 	<li>Uncheck Pending Quality Review</li>
	 * 	<li>Uncheck Message VMP XSite arrow</li>
	 * 	<li>Uncheck Message Mercury Network arrow</li>
	 * 	<li>Click Save</li>
	 * 	<li>If browser is IE, set require window focus capability to false</li>
	 * 	<li>if (StoredVariables.getbrowser().get().equals("IE"))</li>
	 * 	<li>{</li>
	 * 	<li>perform.IE_setRequireWindowFocusToFalse();</li>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify order status</li>
	 * 	<li>Click on the order from the orders grid</li>
	 * 	<li>Complete the order using the HTTP Post</li>
	 * 	<li>Get order information text</li>
	 * 	<li>Verify audit trail</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Get comments</li>
	 * 	<li>Verify both VMP and MN comments are displayed</li>
	 * 	<li>View Order Details</li>
	 * 	<li>Verify Document is in Documents</li>
	 * 	<li>Click Report PDF</li>
	 * 	<li>Verify Uploaded By and Document Name</li>
	 * 	<li>Click MISMO XML</li>
	 * 	<li>Verify Uploaded By and Document Name</li>
	 * 	<li>If browser is IE, re-establish capabilites</li>
	 * 	<li>if (StoredVariables.getbrowser().get().equals("IE"))</li>
	 * 	<li>{</li>
	 * 	<li>perform.IE_reEstablishCapabilities();</li>
	 * 	<li>}</li>
	 * 	<li>If browser is IE, set require window focus capability to false</li>
	 * 	<li>if (StoredVariables.getbrowser().get().equals("IE"))</li>
	 * 	<li>{</li>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>vendors.loginToVendors("Appraiser3", StoredVariables.getpassword().get());</li>
	 * 	<li></li>
	 * 	<li>Search for order</li>
	 * 	<li>vendors.findOrderOnVendors(orderNumberAMC, "Tracking Number");</li>
	 * 	<li></li>
	 * 	<li>Verify order status</li>
	 * 	<li>Assert.assertTrue(VOrders.ordersGrid_txt(driver).getText().contains("Revised Report"), "The order is not in the correct status");</li>
	 * 	<li></li>
	 * 	<li>Click on the order from the orders grid</li>
	 * 	<li>perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());</li>
	 * 	<li></li>
	 * 	<li>}</li>
	 * 	<li>Click Message</li>
	 * 	<li>Add notes</li>
	 * 	<li>Click Send button</li>
	 * 	<li>View XSite order</li>
	 * 	<li>Get history text</li>
	 * 	<li>Recapture the text from the history</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Verify documents</li>
	 * 	<li>Verify comments</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Close XSite order</li>
	 * 	<li>Login to VMP Client Portal</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify the audit trail</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Verify the order details</li>
	 * 	<li>Verify Document is in Documents</li>
	 * 	<li>Click on Sales Contract</li>
	 * 	<li>Verify file name and uploaded by</li>
	 * 	<li>Create boolean for both Other documents</li>
	 * 	<li>Get Number Of Other documents</li>
	 * 	<li>docs = driver.findElements(By.xpath("td[text()='Other']"));</li>
	 * 	<li>Click first Other document</li>
	 * 	<li>Verify Uploaded By and Document Name</li>
	 * 	<li>Verify Uploaded By and Document Name</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Verify Other Document is in Documents</li>
	 * 	<li>Verify Sales ContractDocument is in Documents</li>
	 * 	<li>Click on Sales Contract</li>
	 * 	<li>Verify file name and uploaded by</li>
	 * 	<li>Create boolean for both Other documents</li>
	 * 	<li>Get Number Of Other documents</li>
	 * 	<li>docs = driver.findElements(By.xpath("td[text()='Other']"));</li>
	 * 	<li>Click first Other document</li>
	 * 	<li>Verify Uploaded By and Document Name</li>
	 * 	<li>Verify Uploaded By and Document Name</li>
	 * 	<li>View XSite order</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Verify documents</li>
	 * 	<li>Verify comments</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Close XSite order</li>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify order status</li>
	 * 	<li>Assert.assertTrue(VOrders.ordersGrid_txt(driver).getText().contains("Revised Report"), "The order is not in the correct status"); changed from Revision Needed</li>
	 * 	<li>Click on the order from the orders grid</li>
	 * 	<li>Get order information text</li>
	 * 	<li>Verify audit trail</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Get comments</li>
	 * 	<li>Verify both VMP and MN comments are displayed</li>
	 * 	<li>View Order Details</li>
	 * 	<li>Verify Document is in Documents</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify order details0</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Verify Other Document is in Documents</li>
	 * 	<li>Login to VMP Client Portal</li>
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
	 * 	<li>Verify order details</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Verify Other Document is in Documents</li>
	 * 	<li>Verify Sales ContractDocument is in Documents</li>
	 * 	<li>Click on Sales Contract</li>
	 * 	<li>Verify file name and uploaded by</li>
	 * 	<li>Create boolean for both Other documents</li>
	 * 	<li>Get Number Of Other documents</li>
	 * 	<li>docs = driver.findElements(By.xpath("td[text()='Other']"));</li>
	 * 	<li>Click first Other document</li>
	 * 	<li>Verify Uploaded By and Document Name</li>
	 * 	<li>Verify Uploaded By and Document Name</li>
	 * 	<li>View XSite order</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Verify documents</li>
	 * 	<li>Verify comments</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Close XSite order</li>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify order status</li>
	 * 	<li>Assert.assertTrue(VOrders.ordersGrid_txt(driver).getText().contains("Revised Report"), "The order is not in the correct status"); changed from Revision Needed</li>
	 * 	<li>Click on the order from the orders grid</li>
	 * 	<li>Get order information text</li>
	 * 	<li>Verify audit trail</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Get comments</li>
	 * 	<li>Verify both VMP and MN comments are displayed</li>
	 * 	<li>View Order Details</li>
	 * 	<li>Verify Document is in Documents</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify order details0</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Verify Other Document is in Documents</li>
	 * 	<li>View XSite order</li>
	 * 	<li>Click Sync to Mercury button</li>
	 * 	<li>Go to new window</li>
	 * 	<li>Get and pass the Window Handle for Send Message</li>
	 * 	<li>Switch to the new window</li>
	 * 	<li>Verify message text</li>
	 * 	<li>Click Save</li>
	 * 	<li>Switch to the XSite window</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Close XSite order</li>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify order status</li>
	 * 	<li>Assert.assertTrue(VOrders.ordersGrid_txt(driver).getText().contains("Revised Report"), "The order is not in the correct status"); changed from Revision Needed</li>
	 * 	<li>Click on the order from the orders grid</li>
	 * 	<li>Get order information text</li>
	 * 	<li>Verify audit trail</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Get comments</li>
	 * 	<li>Verify both VMP and MN comments are displayed</li>
	 * 	<li>View Order Details</li>
	 * 	<li>Verify Document is in Documents</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify order details0</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Verify Other Document is in Documents</li>
	 * 	<li>Click Sync to VMP button</li>
	 * 	<li>Verify message text</li>
	 * 	<li>Click OK</li>
	 * 	<li>View XSite order</li>
	 * 	<li>Get history text</li>
	 * 	<li>Recapture the text from the history</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Verify documents</li>
	 * 	<li>Verify comments</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Close XSite order</li>
	 * 	<li>Login to VMP Client Portal</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify the audit trail</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Verify the order details</li>
	 * 	<li>Verify Document is in Documents</li>
	 * 	<li>Click on Sales Contract</li>
	 * 	<li>Verify file name and uploaded by</li>
	 * 	<li>Create boolean for both Other documents</li>
	 * 	<li>Get Number Of Other documents</li>
	 * 	<li>docs = driver.findElements(By.xpath("td[text()='Other']"));</li>
	 * 	<li>Click first Other document</li>
	 * 	<li>Verify Uploaded By and Document Name</li>
	 * 	<li>Verify Uploaded By and Document Name</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Verify Other Document is in Documents</li>
	 * 	<li>Verify Sales ContractDocument is in Documents</li>
	 * 	<li>Click on Sales Contract</li>
	 * 	<li>Verify file name and uploaded by</li>
	 * 	<li>Create boolean for both Other documents</li>
	 * 	<li>Get Number Of Other documents</li>
	 * 	<li>docs = driver.findElements(By.xpath("td[text()='Other']"));</li>
	 * 	<li>Click first Other document</li>
	 * 	<li>Verify Uploaded By and Document Name</li>
	 * 	<li>Verify Uploaded By and Document Name</li>
	 * 	<li>View XSite order</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Verify documents</li>
	 * 	<li>Verify comments</li>
	 * 	<li>Verify new Due Date</li>
	 * 	<li>Verify fee</li>
	 * 	<li>Close XSite order</li>
	 * 	<li>Log test</li>
* </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"EVF", "Secure - Orders", "Secure - Set Status", "Secure - Submit To UCDP", "XSite - Order Details", "VMP - Orders", "Secure - Request Revision", 
			"VMP - Other Actions", "VMP - Cancel Revision Request", "VMP - Send Message", "XSite - Sync To Mercury", "Secure - Sync To VMP"}, dependsOnMethods="firstOrder")
	public void firstOrder2() throws Exception {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Log in to Secure
		secure.login(driver, "EVFAMC", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, orderNumberAMC, "Tracking number");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("In QC - Level One"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, awsAccountsID + "-" + orderNumberAMC);
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Click Set Status
		perform.clickInTable_Contains(driver, "Set status");
		
		// Wait for text
		perform.waitForText(driver, SNewOrder.setStatus_txt(driver), "Submit to UCDP");
		
		// Click Submit to UCDP
		perform.click(driver,SOrderDetails.submitToUCDP_btn(driver));
		
		// Wait for Overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for iFrames
		perform.waitForIFrames(driver);
		
		// Get outside frames
		driver.switchTo().defaultContent();
		// Get inside the attach document frame
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'UCDPSubmit.aspx')]")));
		
		// Wait for Internal notes to be clickable
		perform.waitForElementToBeClickable(driver, SSubmitToUCDP.internalNotes_txtbx(), "id");
		
		// Select Fannie Mae from Select GSE dropdown
		perform.selectDropdownOption(driver, SSubmitToUCDP.selectGSE_dropdown(driver), "Fannie Mae");
		
		// Select a la mode from Business unit dropdown
		perform.selectDropdownOption(driver, SSubmitToUCDP.businessUnit_dropdown(driver), "a la mode");
		
		// Verify unit number is correct
		Assert.assertTrue(SSubmitToUCDP.loanNumber_txtbx(driver).getAttribute("value").equals(StoredVariables.getassignmentInformationLoanNumber().get()), "The Loan Number is not correct");
		
		// Enter internal update notes
		perform.type(driver,SSubmitToUCDP.internalNotes_txtbx(driver), "These are internal notes from EVFAMC on Secure");
		
		// Verify Update status on VMP XSite is checked
		if (!SSubmitToUCDP.updateStatusOnVMPXSite_chkbx(driver).isSelected())
		{
			perform.click(driver,SSubmitToUCDP.updateStatusOnVMPXSite_chkbx(driver));
		}
		
		// Click Send
		perform.click(driver,SSubmitToUCDP.send_btn(driver));
		
		Thread.sleep(10000);
		
		// Wait for OK button to be clickable
		perform.waitForElementToBeClickable(driver, SSubmitToUCDP.ok_btn(), "id");
		
		// Verify message box text
		Assert.assertTrue(SSubmitToUCDP.ucdpSubmissionComplete_txt(driver).getText().contains("UCDP submission complete"), "The UCDP submission complete dialog text is incorrect");
		Assert.assertTrue(SSubmitToUCDP.ucdpSubmissionComplete_txt(driver).getText().contains("Your report has been successfully submitted to UCDP and the Doc File ID has been added to order details. You should receive the status of the appraisal shortly. If you haven't received a response with your Summary Submission Report in the next 24 hours, please contact Client Relations at 1-800-900-4954."), "The UCDP submission complete dialog text is incorrect");
		
		// Click OK button
		perform.click(driver,SSubmitToUCDP.ok_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Get outside frames
		driver.switchTo().defaultContent();
		
		// Get history text
		String history = SOrderDetails.history_txt(driver).getText();
		
		// Verify the history
		Assert.assertTrue(history.contains("History (In QC - Level One)"), "History (In QC - Level One) is missing from the order information");
		Assert.assertTrue(history.contains("UCDP Document File ID Updated by Client (Automation EVFAMC)"), "UCDP Document File ID Updated by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("Note Added (Automation EVFAMC)"), "Note Added (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are internal notes from EVFAMC on Secure"), "These are internal notes from EVFAMC on Secure is missing from the order information");
		Assert.assertTrue(history.contains("Order delivered by Appraiser (Automation Appraiser3) and is now In QC - Level One"), "Order delivered by Vendor (Automation Appraiser3) and is now In QC - Level One is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser3)"), "Message from Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser3"), "These are Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Complete by Appraiser (Automation Appraiser3)"), "Inspection Complete by Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspected on"), "Inspected on is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Scheduled by Appraiser (Automation Appraiser3)"), "Inspection Scheduled by Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection date is"), "Inspection date is is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFAMC)"), "Message from Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("This is a test message from EVFAMC on the XSite"), "This is a test message from EVFAMC on the XSite is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by Client (Automation EVFAMC)"), "Order Changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are EVFLender change fee comments"), "These are EVFLender change fee comments is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed by Client (Automation EVFAMC)"), "Vendor due date changed by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFLender change due date comments"), "These are EVFLender change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Fee Changed by Client (Automation EVFAMC)"), "Appraisal Fee Changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraisal fee changed from $350 to $525."), "Appraisal fee changed from $350 to $525. is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFAMC change fee comments"), "These are EVFAMC change fee comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed by Client (Automation EVFAMC)"), "Vendor due date changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the audit trail");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser3)"), "Message from Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Apostrophes License.pdf)"), "Document Uploaded from Vendor (Automation Appraiser3) (Apostrophes License.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Test PDF_1.pdf)"), "Document Uploaded from Vendor (Automation Appraiser3) (Test PDF_1.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Appraiser (Automation Appraiser3)"), "Resumed by Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Appraiser (Automation Appraiser3)"), "Delayed by Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order accepted by Appraiser (Automation Appraiser3) and In Progress"), "Order accepted by Vendor (Automation Appraiser3) and In Progress is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation EVFAMC)"), "Comment - Action Required by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFAMC)"), "Message from Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(!history.contains("Document Uploaded from Client (Automation EVFAMC) (Test PDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC) (Test PDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Client (Automation EVFAMC)"), "Delayed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Client (Automation EVFAMC)"), "On Hold by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser3"), "Awaiting acceptance by Automation Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Reassigned by Client (Automation EVFAMC) to Automation Appraiser3"), "Reassigned by Client (Automation EVFAMC) to Automation Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by Client (Automation EVFAMC)"), "Order Changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("To View Change History:"), "To View Change History: is missing from the audit trail");
		Assert.assertTrue(history.contains("Requires assignment"), "Requires assignment is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance"), "Awaiting acceptance is missing from the audit trail");
		
		// Verify new Due Date
		Assert.assertTrue(SOrderDetails.orderDue_txt(driver).getText().contains(StoredVariables.getorderDueDateShort().get()), "New Due Date is not correct");
		
		// Verify fee
		Assert.assertTrue(SOrderDetails.assignmentInformation_txt(driver).getText().contains("525"), "Fee should not have updated");
		
		// Verify Other Document is in Documents
		String documentText = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Report PDF"), "Report PDF did not sync to Secure");
		Assert.assertTrue(documentText.contains("MISMO XML"), "MISMO XML did not sync to Secure");
		Assert.assertTrue(documentText.contains("Other"), "Other did not sync to Secure");
		Assert.assertTrue(documentText.contains("Market Information"), "Market Information did not sync to Secure");
		Assert.assertTrue(!documentText.contains("Sales Contract"), "Sales Contract should not sync to Secure");
		
		// Wait for View FNM SSR to display in the history
		secure.waitForHistoryTextToUpdate(driver, "View FNM SSR");
		
		// Get the new history text
		history = SOrderDetails.history_txt(driver).getText();
		
		if (!history.contains("Appraisal Submission to FNM Not Successful")) {
			
			// Wait for View FNM SSR to display in the history
			secure.waitForHistoryTextToUpdate(driver, "View FNM SSR");
			
			// Get the new history text
			history = SOrderDetails.history_txt(driver).getText();
			
		} // end if
		
		// Verify SSR is in the history
		Assert.assertTrue(history.contains("Appraisal Submission to FNM Not Successful"), "Appraisal Submission to FNM Not Successful is missing from the order information");
		Assert.assertTrue(history.contains("View FNM SSR"), "View FNM SSR is missing from the order information");
		
		// Verify FNM SSR is in the Documents
		documentText = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("FNM SSR"), "FNM SSR did not sync to Secure");

		// View XSite order
		secure.viewXSiteOrderFromSecure(driver, "EVFLender", StoredVariables.getpassword().get(), StoredVariables.getloanID().get());
		
		// Get history text
		perform.waitForElementToBeVisible(driver, XOrders.toolbar(), "id");
		String address = StoredVariables.getpropertyInformationAddress().get() + " " + StoredVariables.getpropertyInformationCity().get() + ", " + StoredVariables.getpropertyInformationStateAbbr().get() + " " + StoredVariables.getpropertyInformationZip().get();
		
		// Wait for the history to update
		perform.waitForDBUpdateForHistoryTextInVMPXSite(driver, "Appraisal Submission to FNM Not Successful");
		
		// Recapture the text from the history
		history = XOrders.history_txt(driver).getText();
		
		// Verify the history
		Assert.assertTrue(history.contains("History (Inspection Complete)"), "History (Inspection Complete) is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Submission to FNM Not Successful"), "Appraisal Submission to FNM Not Successful is missing from the order information");
		Assert.assertTrue(history.contains("View FNM SSR"), "View FNM SSR is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Submitted to FNM via UCDP"), "Appraisal Submitted to FNM via UCDP is missing from the order information");
		Assert.assertTrue(history.contains("UCDP Document File ID Updated (Automation EVFLender)"), "UCDP Document File ID Updated (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(!history.contains("Pending Quality Review (Automation EVFLender)"), "Order delivered by Vendor (Automation EVFAMC) and is now Pending Quality Review is missing from the order information");
		Assert.assertTrue(history.contains("Message (Automation EVFLender)"), "Message (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser3"), "These are Message notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Inspection Complete (Automation EVFLender)"), "Inspection Complete (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("Inspected on"), "Inspected on is missing from the order information");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Inspection Scheduled (Automation EVFLender)"), "Inspection Scheduled (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("Inspection date is"), "Inspection date is is missing from the order information");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Comment - Action Required (Automation EVFLender)"), "Comment - Action Required (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("This is an action required message by EVFAMC"), "This is an action required message by EVFAMC is missing from the order information");
		Assert.assertTrue(history.contains("Order Changed (Automation EVFLender)"), "Order Changed (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("Message (Automation EVFLender)"), "Message (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("This is a test message from EVFAMC on the XSite"), "This is a test message from EVFAMC on the XSite is missing from the order information");
		Assert.assertTrue(!history.contains("These are EVFLender change fee comments"), "These are EVFLender change fee comments is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFLender change due date comments"), "These are EVFLender change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed (Automation EVFLender)"), "Vendor due date changed (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the order information");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Message (Automation EVFLender)"), "Message (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Document Uploaded (Automation EVFLender) (Test PDF_1.pdf)"), "Document Uploaded (Automation EVFLender) (Test PDF_1.pdf) is missing from the order information");
		Assert.assertTrue(history.contains("Resumed (Automation EVFLender)"), "Resumed (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Delayed (Automation EVFLender)"), "Delayed (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Vendor Accepted Assignment (Automation EVFLender)"), "Vendor Accepted Assignment (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the order information");
		Assert.assertTrue(history.contains("Resumed (Automation EVFLender)"), "Resumed (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required (Automation OriginatorEVF)"), "Comment - Action Required (Automation OriginatorEVF) is missing from the order information");
		Assert.assertTrue(history.contains("Comment - Action Required for " + address), "Comment - Action Required for " + address + " is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message (Automation OriginatorEVF)"), "Message (Automation OriginatorEVF) is missing from the audit trail");
		Assert.assertTrue(history.contains("Order message for " + address), "Order message for " + address + " is missing from the order information");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded (Automation OriginatorEVF) (TestPDF.pdf)"), "Document Uploaded (Automation OriginatorEVF) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded (Automation OriginatorEVF) (Test PDF.pdf)"), "Document Uploaded (Automation OriginatorEVF) (Test PDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed (Automation OriginatorEVF)"), "Delayed (Automation OriginatorEVF) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed (Automation OriginatorEVF)"), "Resumed (Automation OriginatorEVF) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold (Automation OriginatorEVF)"), "On Hold (Automation OriginatorEVF) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the order information");
		Assert.assertTrue(history.contains("In Progress (Automation OriginatorEVF)"), "In Progress (Automation OriginatorEVF) is missing from the audit trail");
		
		// Verify order details
		perform.verifyXSiteOrderDetailsForLender(driver);
		
		// Verify documents
		String documentsText = XOrders.documents_txt(driver).getText();
		Assert.assertTrue(documentsText.contains("Other"), "Other document is missing from the documents section of the XSite");
		Assert.assertTrue(documentsText.contains("TestPDF"), "TestPDF document is missing from the documents section of the XSite");
		Assert.assertTrue(documentsText.contains("Test PDF_1"), "TestPDF document is missing from the documents section of the XSite");
		Assert.assertTrue(documentsText.contains("Sales Contract"), "Sales Contract document is missing from the documents section of the XSite");
		Assert.assertTrue(documentsText.contains("Test PDF"), "Test PDF document is missing from the documents section of the XSite");
		Assert.assertTrue(!documentsText.contains("Apostrophes License"), "Apostrophes License should not sync to the XSite");
		Assert.assertTrue(!documentsText.contains("No UAD Hard Stops.xml"), "No UAD Hard Stops.xml should not sync to the XSite");
		
		// Verify comments
		String comments = XOrders.comments_txt(driver).getText();
		Assert.assertTrue(comments.contains("These are test additional comments"), "Additional Comments section is missing info");
		
		// Verify new Due Date
		Assert.assertTrue(XOrders.dueDate_txt(driver).getText().equals(StoredVariables.getorderDueDateShort().get()), "New Due Date is not correct - It is: " + XOrders.dueDate_txt(driver).getText() + ", but should be: " + StoredVariables.getorderDueDateShort().get());
		
		// Verify fee
		Assert.assertTrue(XOrders.fee_txt(driver).getText().equals("$350.00"), "Fee should not update");
		
		// Close XSite order
		perform.closeNewWindow(driver);

		// Login to VMP Client Portal
		vmp.login(driver, "EVFLender", "OriginatorEVF", StoredVariables.getpassword().get());
		
		// Search for order
		vmp.findOrder(driver, StoredVariables.getloanIDVMP().get(), "Tracking #");
		
		// Verify Order Status
		Assert.assertTrue(VMPOrders.orderStatus_txt(driver).getText().equals("Inspection Complete"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());
		
		Thread.sleep(1500);
		
		// Wait for Edit Property Contacts link
		perform.waitForElementToBeClickable(driver, VMPAppraisalOrderDetails.editPropertyContacts_lnk(), "id");
		
		// Verify the audit trail
		history = VMPAppraisalOrderDetails.history_txt(driver).getText();
		
		Assert.assertTrue(!history.contains("Pending Quality Review by Automation EVFLender"), "Pending Quality Review by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraisal Submission to FNM Not Successful by Automation EVFLender"), "Appraisal Submission to FNM Not Successful by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("View FNM SSR"), "View FNM SSR is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraisal Submitted to FNM via UCDP by Automation EVFLender"), "Appraisal Submitted to FNM via UCDP by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("UCDP Document File ID Updated by Automation EVFLender"), "UCDP Document File ID Updated by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation EVFLender"), "Message by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser3"), "These are Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Complete by Automation EVFLender"), "Inspection Complete by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspected on"), "Inspected on is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Scheduled by Automation EVFLender"), "Inspection Scheduled by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection date is"), "Inspection date is is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Automation EVFLender"), "Comment - Action Required by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("This is an action required message by EVFAMC"), "This is an action required message by EVFAMC is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by Automation EVFLender"), "Order Changed by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by Automation EVFLender"), "Order Changed by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation EVFLender"), "Message by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("This is a test message from EVFAMC on the XSite"), "This is a test message from EVFAMC on the XSite is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are EVFLender change fee comments"), "These are EVFLender change fee comments is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed by Automation EVFLender"), "Vendor due date changed by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the audit trail");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFLender change due date comments"), "These are EVFLender change due date comments is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation EVFLender"), "Message by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation EVFLender"), "Document Uploaded by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("Other"), "Other is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF_1.pdf"), "Test PDF_1.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation EVFLender"), "Resumed by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation EVFLender"), "Delayed by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraiser Accepted Assignment by Automation EVFLender"), "Appraiser Accepted Assignment by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorEVF"), "Resumed by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Automation OriginatorEVF"), "Comment - Action Required by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation OriginatorEVF"), "Message by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorEVF"), "Document Uploaded by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Other"), "Other is missing from the audit trail");
		Assert.assertTrue(history.contains("TestPDF.pdf"), "TestPDF.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorEVF"), "Document Uploaded by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Sales Contract"), "Sales Contract is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF.pdf"), "Test PDF.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation OriginatorEVF"), "Delayed by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorEVF"), "Resumed by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Automation OriginatorEVF"), "On Hold by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("In Progress by Automation OriginatorEVF"), "In Progress by Automation OriginatorEVF is missing from the audit trail");
		
		// Verify new Due Date
		Assert.assertTrue(VMPAppraisalOrderDetails.orderDetails_txt(driver).getText().contains(StoredVariables.getorderDueDateShort().get()), "New Due Date is not correct");
		
		// Verify fee
		Assert.assertTrue(VMPAppraisalOrderDetails.orderDetails_txt(driver).getText().contains("$350"), "Fee should not update");
		
		// Verify the order details
		vmp.verifyAppraisalOrderDetails(driver);
		
		// Verify Document is in Documents
		documentText = VMPAppraisalOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Other"), "Other document is not displayed in VMP Client Portal");
		Assert.assertTrue(documentText.contains("Sales Contract"), "Sales Contract did not sync to VMP Client Portal");
		Assert.assertTrue(!documentText.contains("Market Information"), "Market Information should not sync to VMP Client Portal");
		Assert.assertTrue(!documentText.contains("MISMO XML"), "MISMO XML should not sync to VMP Client Portal");
		Assert.assertTrue(!documentText.contains("Report PDF"), "Report PDF should not sync to VMP Client Portal");
		
		// Click on Sales Contract
		perform.clickInTable_Contains(driver, "Sales Contract");
		
		// Wait for text to update
		perform.waitForText(driver, VMPAppraisalOrderDetails.documents_txt(driver), "Test PDF.pdf");
		documentText = VMPAppraisalOrderDetails.documents_txt(driver).getText();
		
		// Verify file name and uploaded by
		Assert.assertTrue(documentText.contains("Test PDF.pdf"), "Document name is incorrect in Documents");
		Assert.assertTrue(documentText.contains("Automation OriginatorEVF"), "Uploaded By is incorrect in Documents");
		
		// Create boolean for both Other documents
		boolean originator = false;
		boolean lender = false;
		
		// Get Number Of Other documents
		List<WebElement> docs = driver.findElements(By.xpath("//td[text()='Other']"));
		for (WebElement doc: docs)
		{
			
			// Click first Other document
			perform.click(driver,doc);
			
			Thread.sleep(3000);
			
			documentText = VMPAppraisalOrderDetails.documents_txt(driver).getText();
			
			// Wait for text
			perform.waitForText(driver, VMPAppraisalOrderDetails.documents_txt(driver), "Automation");
			
			if (documentText.contains("Automation OriginatorEVF") && originator == false)
			{
				// Verify Uploaded By and Document Name
				Assert.assertTrue(documentText.contains("TestPDF.pdf"), "TestPDF.pdf is not showing as the Document Name in Order Documents");
				originator = true;
			}
			
			else if (documentText.contains("Automation EVFLender") && lender == false)
			{
				// Verify Uploaded By and Document Name
				Assert.assertTrue(documentText.contains("Test PDF_1.pdf"), "Test PDF_1.pdf is not showing as the Document Name in Order Documents");
				lender = true;
			}
				
		} // end for loop
		
		Assert.assertTrue(originator==true, "The Other document uploaded by Automation OriginatorEVF is not displaying");
		Assert.assertTrue(lender==true, "The Other document uploaded by Automation EVFLender is not displaying");

		// Log in to Secure
		secure.login(driver, "EVFLender", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, StoredVariables.getloanID().get(), "Tracking number");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("Pending Quality Review"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getAWSAccountsID().get() + "-" + StoredVariables.getloanID().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Verify order details
		secure.verifyResidentialAppraisalOrderDetails(driver);
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify the history
		Assert.assertTrue(history.contains("History (Pending Quality Review)"), "History (Pending Quality Review) is missing from the order information");
		Assert.assertTrue(history.contains("View FNM SSR"), "View FNM SSR is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Submission to FNM Not Successful"), "Appraisal Submission to FNM Not Successful is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Submitted to FNM via UCDP by AMC (" + amcCompany + ")"), "Appraisal Submitted to FNM via UCDP by Vendor (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("UCDP Document File ID Updated by AMC (" + amcCompany + ")"), "UCDP Document File ID Updated by Vendor (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("Order delivered by AMC (" + amcCompany + ") and is now Pending Quality Review"), "Order delivered by Vendor (Automation EVFAMC) and is now Pending Quality Review is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from AMC (" + amcCompany + ")"), "Message from Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser3"), "These are Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Complete by AMC (" + amcCompany + ")"), "Inspection Complete by Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspected on"), "Inspected on is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Scheduled by AMC (" + amcCompany + ")"), "Inspection Scheduled by Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection date is"), "Inspection date is is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by AMC (" + amcCompany + ")"), "Comment - Action Required by Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("This is an action required message by EVFAMC"), "This is an action required message by EVFAMC is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from AMC (" + amcCompany + ")"), "Message from Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("This is a test message from EVFAMC on the XSite"), "This is a test message from EVFAMC on the XSite is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by AMC (" + amcCompany + ")"), "Order Changed by Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraisal Fee Changed by Client (Automation EVFLender)"), "Appraisal Fee Changed by Client (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal fee changed from $0 to $673"), "Appraisal fee changed from $0 to $673 is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFLender change fee comment"), "These are EVFLender change fee comment is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed by Client (Automation EVFLender)"), "Vendor due date changed by Client (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the order information");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFLender change due date comments"), "These are EVFLender change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed by AMC (" + amcCompany + ")"), "Vendor due date changed by Vendor (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the order information");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Message from AMC (" + amcCompany + ")"), "Message from Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from AMC (" + amcCompany + ") (Test PDF_1.pdf)"), "Document Uploaded from Vendor (Automation EVFAMC) (Test PDF_1.pdf)�is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by AMC (" + amcCompany + ")"), "Resumed by Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by AMC (" + amcCompany + ")"), "Delayed by Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraiser Accepted assignment"), "Appraiser Accepted assignment is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFLender)"), "Resumed by Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation EVFLender)"), "Comment - Action Required by Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFLender)"), "Message from Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFLender) (TestPDF.pdf)"), "Document Uploaded from Client (Automation EVFLender) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFLender) (Test PDF.pdf)"), "Document Uploaded from Client (Automation EVFLender) (Test PDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Client (Automation EVFLender)"), "Delayed by Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFLender)"), "Resumed by Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Client (Automation EVFLender)"), "On Hold by Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by AMC (" + amcCompany + ")"), "Order Changed by Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Order accepted by AMC (" + amcCompany + ") and In Progress"), "Order accepted by Vendor (Automation EVFAMC) and In Progress is missing from the audit trail");
		Assert.assertTrue(history.contains("Order automatically accepted."), "Order automatically accepted. is missing from the audit trail");
		Assert.assertTrue(history.contains("Order automatically assigned"), "Order automatically assigned is missing from the audit trail");
		Assert.assertTrue(history.contains("Assigned to Automation"), "Assigned to Automation EVFAMC is missing from the audit trail");
		
		// Verify new Due Date
		Assert.assertTrue(SOrderDetails.orderDue_txt(driver).getText().contains(StoredVariables.getorderDueDateShort().get()), "New Due Date is not correct");
		
		// Verify fee
		Assert.assertTrue(SOrderDetails.assignmentInformation_txt(driver).getText().contains("673"), "Fee should have updated");
		
		// Verify Other Document is in Documents
		documentText = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(!documentText.contains("Market Information"), "Market Information should not sync to Secure");
		Assert.assertTrue(!documentText.contains("MISMO XML"), "MISMO XML should not sync to Secure");
		Assert.assertTrue(!documentText.contains("Report PDF"), "Report PDF should not sync to Secure");
		Assert.assertTrue(documentText.contains("Other"), "Other did not sync to Secure");
		Assert.assertTrue(documentText.contains("Sales Contract"), "Sales Contract did not sync to Secure");
		
		// Verify Sales ContractDocument is in Documents
		documentText = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Sales Contract"), "Sales Contract did not sync to Secure");
		
		// Click on Sales Contract
		perform.clickInTable_Contains(driver, "Sales Contract");
		
		// Wait for text to update
		perform.waitForText(driver, SOrderDetails.documents_txt(driver), "Test PDF.pdf");
		documentText = SOrderDetails.documents_txt(driver).getText();
		
		// Verify file name and uploaded by
		Assert.assertTrue(documentText.contains("Test PDF.pdf"), "Document name is incorrect in Documents");
		Assert.assertTrue(documentText.contains("Automation EVFLender"), "Uploaded By is incorrect in Documents");
		
		// Create boolean for both Other documents
		boolean amc = false;
		lender = false;
		
		// Get Number Of Other documents
		docs = driver.findElements(By.xpath("//td[text()='Other']"));
		for (WebElement doc: docs)
		{
			
			// Click first Other document
			perform.click(driver,doc);
			
			Thread.sleep(3000);
			
			documentText = SOrderDetails.documents_txt(driver).getText();
			
			// Wait for text
			perform.waitForText(driver, SOrderDetails.documents_txt(driver), "Automation");
			
			if (documentText.contains("Automation EVFAMC") && amc == false)
			{
				// Verify Uploaded By and Document Name
				Assert.assertTrue(documentText.contains("Test PDF_1.pdf"), "Test PDF_1.pdf is not showing as the Document Name in Order Documents");
				amc = true;
			}
			
			else if (documentText.contains("Automation EVFLender") && lender == false)
			{
				// Verify Uploaded By and Document Name
				Assert.assertTrue(documentText.contains("TestPDF.pdf"), "TestPDF.pdf is not showing as the Document Name in Order Documents");
				lender = true;
			}
				
		} // end for loop
		
		Assert.assertTrue(amc==true, "The Other document uploaded by Automation EVFAMC is not displaying");
		Assert.assertTrue(lender==true, "The Other document uploaded by Automation EVFLender is not displaying");

		secure.viewXSiteOrderFromSecure(driver, "EVFAMC", StoredVariables.getpassword().get(), orderNumberAMC);
		
		// Get history text
		perform.waitForElementToBeVisible(driver, XOrders.toolbar(), "id");
		history = XOrders.history_txt(driver).getText();
		address = StoredVariables.getpropertyInformationAddress().get() + " " + StoredVariables.getpropertyInformationCity().get() + ", " + StoredVariables.getpropertyInformationStateAbbr().get() + " " + StoredVariables.getpropertyInformationZip().get();
		
		// Verify the history
		Assert.assertTrue(history.contains("History (Pending Quality Review)"), "History (Pending Quality Review) is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Submission to FNM Not Successful"), "Appraisal Submission to FNM Not Successful is missing from the order information");
		Assert.assertTrue(history.contains("View FNM SSR"), "View FNM SSR is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Submitted to FNM via UCDP"), "Appraisal Submitted to FNM via UCDP is missing from the order information");
		Assert.assertTrue(history.contains("UCDP Document File ID Updated (Automation EVFAMC)"), "UCDP Document File ID Updated (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("Pending Quality Review (Automation EVFAMC)"), "Pending Quality Review (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Message (Automation EVFAMC)"), "Message (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser3"), "These are Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Complete (Automation EVFAMC)"), "Inspection Complete (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspected on"), "Inspected on is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Scheduled (Automation EVFAMC)"), "Inspection Scheduled (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection date is"), "Inspection date is is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required (Automation EVFAMC)"), "Comment - Action Required (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("This is an action required message by EVFAMC"), "This is an action required message by EVFAMC is missing from the audit trail");
		Assert.assertTrue(history.contains("Message (Automation EVFAMC)"), "Message (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("This is a test message from EVFAMC on the XSite"), "This is a test message from EVFAMC on the XSite is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed (Automation EVFAMC)"), "Order Changed (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraisal Fee Changed (Automation EVFLender)"), "Appraisal Fee Changed (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal fee changed from $0 to $673"), "Appraisal fee changed from $0 to $673 is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFLender change fee comments"), "These are EVFLender change fee comments is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed (Automation EVFLender)"), "Vendor due date changed (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFLender change due date comments"), "These are EVFLender change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed (Automation EVFAMC)"), "Vendor due date changed (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the order information");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Message (Automation EVFAMC)"), "Message (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded (Automation EVFAMC) (Test PDF_1.pdf)"), "Document Uploaded (Automation EVFAMC) (Test PDF_1.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed (Automation EVFAMC)"), "Resumed (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed (Automation EVFAMC)"), "Delayed (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraiser Accepted assignment by Appraiser"), "Appraiser Accepted assignment by Appraiser is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed (Automation EVFLender)"), "Resumed (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required (Automation EVFLender)"), "Comment - Action Required (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required for " + address), "Comment - Action Required for " + address + " is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message (Automation EVFLender)"), "Message (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("Order message for " + address), "Order message for " + address + " is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded (Automation EVFLender) (TestPDF.pdf)"), "Document Uploaded (Automation EVFLender) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded (Automation EVFLender) (Test PDF.pdf)"), "Document Uploaded (Automation EVFLender) (Test PDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed (Automation EVFLender)"), "Delayed (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed (Automation EVFLender)"), "Resumed (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold (Automation EVFLender)"), "On Hold (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed (Automation EVFAMC)"), "Order Changed (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("To View Change History:"), "To View Change History: is missing from the audit trail");
		Assert.assertTrue(history.contains("In Progress (Automation EVFAMC)"), "In Progress (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance"), "Awaiting acceptance is missing from the audit trail");
		
		// Verify order details
		perform.verifyXSiteOrderDetailsForAMC(driver);
		
		// Verify documents
		perform.waitForText(driver, XOrders.documents_txt(driver), "Other");
		documentsText = XOrders.documents_txt(driver).getText();
		Assert.assertTrue(!documentsText.contains("Market Information"), "Market Information should not sync to Secure");
		Assert.assertTrue(!documentsText.contains("No UAD Hard Stops.xml"), "No UAD Hard Stops.xml should not sync to the XSite");
		Assert.assertTrue(documentsText.contains("Other"), "Other document is missing from the documents section of the XSite - " + documentsText);
		Assert.assertTrue(documentsText.contains("TestPDF"), "TestPDF document is missing from the documents section of the XSite - " + documentsText);
		Assert.assertTrue(documentsText.contains("Test PDF_1"), "Test PDF_1 document is missing from the documents section of the XSite - " + documentsText);
		Assert.assertTrue(documentsText.contains("Sales Contract"), "Sales Contract document is missing from the documents section of the XSite - " + documentsText);
		Assert.assertTrue(documentsText.contains("Test PDF"), "Test PDF document is missing from the documents section of the XSite - " + documentsText);
		
		// Verify comments
		comments = XOrders.comments_txt(driver).getText();
		Assert.assertTrue(comments.contains("These are edited comments by EVFAMC"), "Additional Comments section is missing info");
		
		// Verify new Due Date
		Assert.assertTrue(XOrders.dueDate_txt(driver).getText().equals(StoredVariables.getorderDueDateShort().get()), "New Due Date is not correct");
		
		// Verify fee
		Assert.assertTrue(XOrders.fee_txt(driver).getText().equals("$673.00"), "Fee should have updated");
		
		// Close XSite order
		perform.closeNewWindow(driver);

		// Log in to Vendors
		vendors.login(driver, "Appraiser3", StoredVariables.getpassword().get());
		
		// Search for order
		vendors.findOrder(driver, orderNumberAMC, "Tracking Number");
		
		// Verify order status
		Assert.assertTrue(VOrders.ordersGrid_txt(driver).getText().contains("In QC - Level One"), "The order is not in the correct status");
		
		// Click on the order from the orders grid
		perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, VOrderDetails.orderInformation_txt(), "id");
		
		// Get order information text
		history = VOrderDetails.orderInformation_txt(driver).getText();
		System.out.println("viewThirdOrderDetailsFromVendors6 history = \n" + history);
		
		// Verify audit trail
		Assert.assertTrue(history.contains("History (In QC - Level One)"), "History (In QC - Level One) is missing from the order information");
		Assert.assertTrue(history.contains("Order delivered by Appraiser (Automation Appraiser3) and is now In QC - Level One"), "Order delivered by Appraiser (Automation Appraiser3) and is now In QC - Level One is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser3)"), "Message from Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser3"), "These are Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Complete by Appraiser (Automation Appraiser3)"), "Inspection Complete by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspected on"), "Inspected on is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Scheduled by Appraiser (Automation Appraiser3)"), "Inspection Scheduled by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection date is"), "Inspection date is is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFAMC)"), "Message from Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("This is a test message from EVFAMC on the XSite"), "This is a test message from EVFAMC on the XSite is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by AMC ("+amcCompany+")"), "Order Changed by AMC ("+amcCompany+") is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are EVFLender change fee comments"), "These are EVFLender change fee comments is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed by Client (Automation EVFAMC)"), "Vendor due date changed by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFLender change due date comments"), "These are EVFLender change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Fee Changed by Client (Automation EVFAMC)"), "Appraisal Fee Changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraisal fee changed from $350 to $525."), "Appraisal fee changed from $350 to $525. is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFAMC change fee comments"), "These are EVFAMC change fee comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed by Client (Automation EVFAMC)"), "Vendor due date changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the audit trail");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser3)"), "Message from Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Apostrophes License.pdf)"), "Document Uploaded from Appraiser (Automation Appraiser3) (Apostrophes License.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Test PDF_1.pdf)"), "Document Uploaded from Appraiser (Automation Appraiser3) (Test PDF_1.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Appraiser (Automation Appraiser3)"), "Resumed by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Appraiser (Automation Appraiser3)"), "Delayed by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order accepted by Appraiser (Automation Appraiser3) and In Progress"), "Order accepted by Appraiser (Automation Appraiser3) and In Progress is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation EVFAMC)"), "Comment - Action Required by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFAMC)"), "Message from Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(!history.contains("Document Uploaded from Client (Automation EVFAMC) (Test PDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC) (Test PDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Client (Automation EVFAMC)"), "Delayed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Client (Automation EVFAMC)"), "On Hold by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser3"), "Awaiting acceptance by Automation Appraiser3 is missing from the audit trail");
		
		// Verify new Due Date
		Assert.assertTrue(VOrderDetails.orderInformation_txt(driver).getText().contains(StoredVariables.getorderDueDateShort().get()), "New Due Date is not correct");
		
		// Verify fee
		Assert.assertTrue(VOrderDetails.orderInformation_txt(driver).getText().contains("$525"), "Fee should not have updated");
		
		// Get comments
		String additionalComments = VOrderDetails.additionalComments_txt(driver).getText();
		
		// Verify both VMP and MN comments are displayed
		Assert.assertTrue(additionalComments.contains("These are edited comments by EVFAMC"), "Additional Comments section is missing info");
		
		// View Order Details
		vendors.verifyOrderDetails(driver);
		
		// Verify Document is in Documents
		documentText = VOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Report PDF"), "Report PDF did not sync to Vendors");
		Assert.assertTrue(documentText.contains("MISMO XML"), "MISMO XML did not sync to Vendors");
		Assert.assertTrue(documentText.contains("Other"), "Other did not sync to Vendors");
		Assert.assertTrue(documentText.contains("Market Information"), "Market Information did not sync to Vendors");
		Assert.assertTrue(!documentText.contains("Sales Contract"), "Sales Contract should not sync to Vendors");
		
		// Log in to Secure
		secure.login(driver, "EVFAMC", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, orderNumberAMC, "Tracking number");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("Appraisal Submission to FNM Not Successful"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, awsAccountsID + "-" + orderNumberAMC);
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Verify order details0
		secure.verifyResidentialAppraisalOrderDetails(driver);
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify the history
		Assert.assertTrue(history.contains("History (In QC - Level One)"), "History (In QC - Level One) is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Submission to FNM Not Successful"), "Appraisal Submission to FNM Not Successful is missing from the order information");
		Assert.assertTrue(history.contains("View FNM SSR"), "View FNM SSR is missing from the order information");
		Assert.assertTrue(history.contains("UCDP Document File ID Updated by Client (Automation EVFAMC)"), "UCDP Document File ID Updated by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("Note Added (Automation EVFAMC)"), "Note Added (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are internal notes from EVFAMC on Secure"), "These are internal notes from EVFAMC on Secure is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Submitted to FNM via UCDP by Client (Automation EVFAMC)"), "Appraisal Submitted to FNM via UCDP by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("Order delivered by Appraiser (Automation Appraiser3) and is now In QC - Level One"), "Order delivered by Vendor (Automation Appraiser3) and is now In QC - Level One is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser3)"), "Message from Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser3"), "These are Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Complete by Appraiser (Automation Appraiser3)"), "Inspection Complete by Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspected on"), "Inspected on is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Scheduled by Appraiser (Automation Appraiser3)"), "Inspection Scheduled by Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection date is"), "Inspection date is is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFAMC)"), "Message from Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("This is a test message from EVFAMC on the XSite"), "This is a test message from EVFAMC on the XSite is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by Client (Automation EVFAMC)"), "Order Changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are EVFLender change fee comments"), "These are EVFLender change fee comments is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed by Client (Automation EVFAMC)"), "Vendor due date changed by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFLender change due date comments"), "These are EVFLender change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Fee Changed by Client (Automation EVFAMC)"), "Appraisal Fee Changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraisal fee changed from $350 to $525."), "Appraisal fee changed from $350 to $525. is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFAMC change fee comments"), "These are EVFAMC change fee comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed by Client (Automation EVFAMC)"), "Vendor due date changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the audit trail");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser3)"), "Message from Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Apostrophes License.pdf)"), "Document Uploaded from Vendor (Automation Appraiser3) (Apostrophes License.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Test PDF_1.pdf)"), "Document Uploaded from Vendor (Automation Appraiser3) (Test PDF_1.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Appraiser (Automation Appraiser3)"), "Resumed by Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Appraiser (Automation Appraiser3)"), "Delayed by Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order accepted by Appraiser (Automation Appraiser3) and In Progress"), "Order accepted by Vendor (Automation Appraiser3) and In Progress is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation EVFAMC)"), "Comment - Action Required by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFAMC)"), "Message from Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(!history.contains("Document Uploaded from Client (Automation EVFAMC) (Test PDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC) (Test PDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Client (Automation EVFAMC)"), "Delayed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Client (Automation EVFAMC)"), "On Hold by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser3"), "Awaiting acceptance by Automation Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Reassigned by Client (Automation EVFAMC) to Automation Appraiser3"), "Reassigned by Client (Automation EVFAMC) to Automation Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by Client (Automation EVFAMC)"), "Order Changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("To View Change History:"), "To View Change History: is missing from the audit trail");
		Assert.assertTrue(history.contains("Requires assignment"), "Requires assignment is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance"), "Awaiting acceptance is missing from the audit trail");
		
		// Verify new Due Date
		Assert.assertTrue(SOrderDetails.orderDue_txt(driver).getText().contains(StoredVariables.getorderDueDateShort().get()), "New Due Date is not correct");
		
		// Verify fee
		Assert.assertTrue(SOrderDetails.assignmentInformation_txt(driver).getText().contains("525"), "Fee should not have updated");
		
		// Verify Other Document is in Documents
		documentText = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Report PDF"), "Report PDF did not sync to Secure");
		Assert.assertTrue(documentText.contains("MISMO XML"), "MISMO XML did not sync to Secure");
		Assert.assertTrue(documentText.contains("FNM SSR"), "FNM SSR did not sync to Secure");
		Assert.assertTrue(documentText.contains("Other"), "Other did not sync to Secure");
		Assert.assertTrue(documentText.contains("Market Information"), "Market Information did not sync to Secure");
		Assert.assertTrue(!documentText.contains("Sales Contract"), "Sales Contract should not sync to Secure");
		
		// Click Set Status
		perform.clickInTable_Contains(driver, "Set status");
		
		// Wait for text
		perform.waitForText(driver, SNewOrder.setStatus_txt(driver), "Request revision");
		
		// Click Request revision
		perform.click(driver,SOrderDetails.requestRevision_btn(driver));
		
		// Wait for Overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SSetOrderStatus.ok_btn(), "id");
		
		// Enter notes
		perform.type(driver,SSetOrderStatus.notes_txtbx(driver), "These are request revision notes from EVFAMC on Secure");
		
		// Check the Update status on VMP XSite checkbox
		if (!SSetOrderStatus.updateStatusOnVMPXSite_chkbx(driver).isSelected())
		{
			perform.click(driver,SSetOrderStatus.updateStatusOnVMPXSite_chkbx(driver));
		}
		
		// Click OK button
		perform.click(driver,SSetOrderStatus.ok_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Wait for history
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify the history
		Assert.assertTrue(history.contains("History (Revision Needed)"), "History (Revision Needed) is missing from the order information");
		Assert.assertTrue(history.contains("Revision Needed by Client (Automation EVFAMC)"), "Revision Needed by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are request revision notes from EVFAMC on Secure"), "These are request revision notes from EVFAMC on Secure is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Submission to FNM Not Successful"), "Appraisal Submission to FNM Not Successful is missing from the order information");
		Assert.assertTrue(history.contains("View FNM SSR"), "View FNM SSR is missing from the order information");
		Assert.assertTrue(history.contains("UCDP Document File ID Updated by Client (Automation EVFAMC)"), "UCDP Document File ID Updated by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("Note Added (Automation EVFAMC)"), "Note Added (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are internal notes from EVFAMC on Secure"), "These are internal notes from EVFAMC on Secure is missing from the order information");
		Assert.assertTrue(history.contains("Order delivered by Appraiser (Automation Appraiser3) and is now In QC - Level One"), "Order delivered by Vendor (Automation Appraiser3) and is now In QC - Level One is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser3)"), "Message from Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser3"), "These are Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Complete by Appraiser (Automation Appraiser3)"), "Inspection Complete by Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspected on"), "Inspected on is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Scheduled by Appraiser (Automation Appraiser3)"), "Inspection Scheduled by Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection date is"), "Inspection date is is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFAMC)"), "Message from Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("This is a test message from EVFAMC on the XSite"), "This is a test message from EVFAMC on the XSite is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by Client (Automation EVFAMC)"), "Order Changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are EVFLender change fee comments"), "These are EVFLender change fee comments is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed by Client (Automation EVFAMC)"), "Vendor due date changed by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFLender change due date comments"), "These are EVFLender change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Fee Changed by Client (Automation EVFAMC)"), "Appraisal Fee Changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraisal fee changed from $350 to $525."), "Appraisal fee changed from $350 to $525. is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFAMC change fee comments"), "These are EVFAMC change fee comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed by Client (Automation EVFAMC)"), "Vendor due date changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the audit trail");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser3)"), "Message from Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Apostrophes License.pdf)"), "Document Uploaded from Vendor (Automation Appraiser3) (Apostrophes License.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Test PDF_1.pdf)"), "Document Uploaded from Vendor (Automation Appraiser3) (Test PDF_1.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Appraiser (Automation Appraiser3)"), "Resumed by Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Appraiser (Automation Appraiser3)"), "Delayed by Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order accepted by Appraiser (Automation Appraiser3) and In Progress"), "Order accepted by Vendor (Automation Appraiser3) and In Progress is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation EVFAMC)"), "Comment - Action Required by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFAMC)"), "Message from Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(!history.contains("Document Uploaded from Client (Automation EVFAMC) (Test PDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC) (Test PDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Client (Automation EVFAMC)"), "Delayed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Client (Automation EVFAMC)"), "On Hold by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser3"), "Awaiting acceptance by Automation Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Reassigned by Client (Automation EVFAMC) to Automation Appraiser3"), "Reassigned by Client (Automation EVFAMC) to Automation Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by Client (Automation EVFAMC)"), "Order Changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("To View Change History:"), "To View Change History: is missing from the audit trail");
		Assert.assertTrue(history.contains("Requires assignment"), "Requires assignment is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance"), "Awaiting acceptance is missing from the audit trail");
		
		// Verify new Due Date
		Assert.assertTrue(SOrderDetails.orderDue_txt(driver).getText().contains(StoredVariables.getorderDueDateShort().get()), "New Due Date is not correct");
		
		// Verify fee
		Assert.assertTrue(SOrderDetails.assignmentInformation_txt(driver).getText().contains("525"), "Fee should not have updated");
		
		// Verify Other Document is in Documents
		documentText = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Report PDF"), "Report PDF did not sync to Secure");
		Assert.assertTrue(documentText.contains("MISMO XML"), "MISMO XML did not sync to Secure");
		Assert.assertTrue(documentText.contains("FNM SSR"), "FNM SSR did not sync to Secure");
		Assert.assertTrue(documentText.contains("Other"), "Other did not sync to Secure");
		Assert.assertTrue(documentText.contains("Market Information"), "Market Information did not sync to Secure");
		Assert.assertTrue(!documentText.contains("Sales Contract"), "Sales Contract should not sync to Secure");
		
		// View XSite order
		secure.viewXSiteOrderFromSecure(driver, "EVFLender", StoredVariables.getpassword().get(), StoredVariables.getloanID().get());
		
		// Get history text
		perform.waitForElementToBeVisible(driver, XOrders.toolbar(), "id");
		history = XOrders.history_txt(driver).getText();
		address = StoredVariables.getpropertyInformationAddress().get() + " " + StoredVariables.getpropertyInformationCity().get() + ", " + StoredVariables.getpropertyInformationStateAbbr().get() + " " + StoredVariables.getpropertyInformationZip().get();
		
		// Recapture the text from the history
		history = XOrders.history_txt(driver).getText();
		
		// Verify the history
		Assert.assertTrue(history.contains("History (Revision Needed)"), "History (Revision Needed) is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Submission to FNM Not Successful"), "Appraisal Submission to FNM Not Successful is missing from the order information");
		Assert.assertTrue(history.contains("View FNM SSR"), "View FNM SSR is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Submitted to FNM via UCDP"), "Appraisal Submitted to FNM via UCDP is missing from the order information");
		Assert.assertTrue(history.contains("UCDP Document File ID Updated (Automation EVFLender)"), "UCDP Document File ID Updated (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(!history.contains("Pending Quality Review (Automation EVFLender)"), "Order delivered by Vendor (Automation EVFAMC) and is now Pending Quality Review is missing from the order information");
		Assert.assertTrue(history.contains("Message (Automation EVFLender)"), "Message (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser3"), "These are Message notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Inspection Complete (Automation EVFLender)"), "Inspection Complete (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("Inspected on"), "Inspected on is missing from the order information");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Inspection Scheduled (Automation EVFLender)"), "Inspection Scheduled (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("Inspection date is"), "Inspection date is is missing from the order information");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Comment - Action Required (Automation EVFLender)"), "Comment - Action Required (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("This is an action required message by EVFAMC"), "This is an action required message by EVFAMC is missing from the order information");
		Assert.assertTrue(history.contains("Order Changed (Automation EVFLender)"), "Order Changed (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("Message (Automation EVFLender)"), "Message (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("This is a test message from EVFAMC on the XSite"), "This is a test message from EVFAMC on the XSite is missing from the order information");
		Assert.assertTrue(!history.contains("These are EVFLender change fee comments"), "These are EVFLender change fee comments is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFLender change due date comments"), "These are EVFLender change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed (Automation EVFLender)"), "Vendor due date changed (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the order information");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Message (Automation EVFLender)"), "Message (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Document Uploaded (Automation EVFLender) (Test PDF_1.pdf)"), "Document Uploaded (Automation EVFLender) (Test PDF_1.pdf) is missing from the order information");
		Assert.assertTrue(history.contains("Resumed (Automation EVFLender)"), "Resumed (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Delayed (Automation EVFLender)"), "Delayed (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Vendor Accepted Assignment (Automation EVFLender)"), "Vendor Accepted Assignment (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the order information");
		Assert.assertTrue(history.contains("Resumed (Automation EVFLender)"), "Resumed (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required (Automation OriginatorEVF)"), "Comment - Action Required (Automation OriginatorEVF) is missing from the order information");
		Assert.assertTrue(history.contains("Comment - Action Required for " + address), "Comment - Action Required for " + address + " is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message (Automation OriginatorEVF)"), "Message (Automation OriginatorEVF) is missing from the audit trail");
		Assert.assertTrue(history.contains("Order message for " + address), "Order message for " + address + " is missing from the order information");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded (Automation OriginatorEVF) (TestPDF.pdf)"), "Document Uploaded (Automation OriginatorEVF) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded (Automation OriginatorEVF) (Test PDF.pdf)"), "Document Uploaded (Automation OriginatorEVF) (Test PDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed (Automation OriginatorEVF)"), "Delayed (Automation OriginatorEVF) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed (Automation OriginatorEVF)"), "Resumed (Automation OriginatorEVF) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold (Automation OriginatorEVF)"), "On Hold (Automation OriginatorEVF) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the order information");
		Assert.assertTrue(history.contains("In Progress (Automation OriginatorEVF)"), "In Progress (Automation OriginatorEVF) is missing from the audit trail");
		
		// Verify order details
		perform.verifyXSiteOrderDetailsForLender(driver);
		
		// Verify documents
		documentsText = XOrders.documents_txt(driver).getText();
		Assert.assertTrue(documentsText.contains("Other"), "Other document is missing from the documents section of the XSite");
		Assert.assertTrue(documentsText.contains("TestPDF"), "TestPDF document is missing from the documents section of the XSite");
		Assert.assertTrue(documentsText.contains("Test PDF_1"), "TestPDF document is missing from the documents section of the XSite");
		Assert.assertTrue(documentsText.contains("Sales Contract"), "Sales Contract document is missing from the documents section of the XSite");
		Assert.assertTrue(documentsText.contains("Test PDF"), "Test PDF document is missing from the documents section of the XSite");
		Assert.assertTrue(!documentsText.contains("Apostrophes License"), "Apostrophes License should not sync to the XSite");
		Assert.assertTrue(!documentsText.contains("No UAD Hard Stops.xml"), "No UAD Hard Stops.xml should not sync to the XSite");
		
		// Verify comments
		comments = XOrders.comments_txt(driver).getText();
		Assert.assertTrue(comments.contains("These are test additional comments"), "Additional Comments section is missing info");
		
		// Verify new Due Date
		Assert.assertTrue(XOrders.dueDate_txt(driver).getText().equals(StoredVariables.getorderDueDateShort().get()), "New Due Date is not correct - It is: " + XOrders.dueDate_txt(driver).getText() + ", but should be: " + StoredVariables.getorderDueDateShort().get());
		
		// Verify fee
		Assert.assertTrue(XOrders.fee_txt(driver).getText().equals("$350.00"), "Fee should not update");
		
		// Close XSite order
		perform.closeNewWindow(driver);
		
		// Login to VMP Client Portal
		vmp.login(driver, "EVFLender", "OriginatorEVF", StoredVariables.getpassword().get());
		
		// Search for order
		vmp.findOrder(driver, StoredVariables.getloanIDVMP().get(), "Tracking #");
		
		// Wait for db to update order status on Secure
		vmp.waitForDBUpdateForOrderStatus(driver, "Revision Needed");
		
		// Verify Order Status
		Assert.assertTrue(VMPOrders.orderStatus_txt(driver).getText().equals("Revision Needed"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());
		
		Thread.sleep(1500);
		
		// Wait for Edit Property Contacts link
		perform.waitForElementToBeClickable(driver, VMPAppraisalOrderDetails.editPropertyContacts_lnk(), "id");
		
		// Verify the audit trail
		history = VMPAppraisalOrderDetails.history_txt(driver).getText();
		
		Assert.assertTrue(history.contains("Revision Needed by Automation EVFLender"), "Revision Needed by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are request revision notes from EVFAMC on Secure"), "These are request revision notes from EVFAMC on Secure is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraisal Submission to FNM Not Successful by Automation EVFLender"), "Appraisal Submission to FNM Not Successful by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("View FNM SSR"), "View FNM SSR is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraisal Submitted to FNM via UCDP by Automation EVFLender"), "Appraisal Submitted to FNM via UCDP by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("UCDP Document File ID Updated by Automation EVFLender"), "UCDP Document File ID Updated by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(!history.contains("Pending Quality Review by Automation EVFLender"), "Pending Quality Review by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation EVFLender"), "Message by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser3"), "These are Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Complete by Automation EVFLender"), "Inspection Complete by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspected on"), "Inspected on is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Scheduled by Automation EVFLender"), "Inspection Scheduled by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection date is"), "Inspection date is is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Automation EVFLender"), "Comment - Action Required by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("This is an action required message by EVFAMC"), "This is an action required message by EVFAMC is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by Automation EVFLender"), "Order Changed by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by Automation EVFLender"), "Order Changed by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation EVFLender"), "Message by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("This is a test message from EVFAMC on the XSite"), "This is a test message from EVFAMC on the XSite is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are EVFLender change fee comments"), "These are EVFLender change fee comments is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed by Automation EVFLender"), "Vendor due date changed by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the audit trail");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFLender change due date comments"), "These are EVFLender change due date comments is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation EVFLender"), "Message by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation EVFLender"), "Document Uploaded by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("Other"), "Other is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF_1.pdf"), "Test PDF_1.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation EVFLender"), "Resumed by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation EVFLender"), "Delayed by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraiser Accepted Assignment by Automation EVFLender"), "Appraiser Accepted Assignment by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorEVF"), "Resumed by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Automation OriginatorEVF"), "Comment - Action Required by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation OriginatorEVF"), "Message by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorEVF"), "Document Uploaded by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Other"), "Other is missing from the audit trail");
		Assert.assertTrue(history.contains("TestPDF.pdf"), "TestPDF.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorEVF"), "Document Uploaded by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Sales Contract"), "Sales Contract is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF.pdf"), "Test PDF.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation OriginatorEVF"), "Delayed by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorEVF"), "Resumed by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Automation OriginatorEVF"), "On Hold by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("In Progress by Automation OriginatorEVF"), "In Progress by Automation OriginatorEVF is missing from the audit trail");
		
		// Verify new Due Date
		Assert.assertTrue(VMPAppraisalOrderDetails.orderDetails_txt(driver).getText().contains(StoredVariables.getorderDueDateShort().get()), "New Due Date is not correct");
		
		// Verify fee
		Assert.assertTrue(VMPAppraisalOrderDetails.orderDetails_txt(driver).getText().contains("$350"), "Fee should not update");
		
		// Verify the order details
		vmp.verifyAppraisalOrderDetails(driver);
		
		// Verify Document is in Documents
		documentText = VMPAppraisalOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Other"), "Other document is not displayed in VMP Client Portal");
		Assert.assertTrue(documentText.contains("Sales Contract"), "Sales Contract did not sync to VMP Client Portal");
		Assert.assertTrue(!documentText.contains("Market Information"), "Market Information should not sync to VMP Client Portal");
		Assert.assertTrue(!documentText.contains("MISMO XML"), "MISMO XML should not sync to VMP Client Portal");
		Assert.assertTrue(!documentText.contains("Report PDF"), "Report PDF should not sync to VMP Client Portal");
		
		// Click on Sales Contract
		perform.clickInTable_Contains(driver, "Sales Contract");
		
		// Wait for text to update
		perform.waitForText(driver, VMPAppraisalOrderDetails.documents_txt(driver), "Test PDF.pdf");
		documentText = VMPAppraisalOrderDetails.documents_txt(driver).getText();
		
		// Verify file name and uploaded by
		Assert.assertTrue(documentText.contains("Test PDF.pdf"), "Document name is incorrect in Documents");
		Assert.assertTrue(documentText.contains("Automation OriginatorEVF"), "Uploaded By is incorrect in Documents");
		
		// Create boolean for both Other documents
		originator = false;
		lender = false;
		
		// Get Number Of Other documents
		docs = driver.findElements(By.xpath("//td[text()='Other']"));
		for (WebElement doc: docs)
		{
			
			// Click first Other document
			perform.click(driver,doc);
			
			Thread.sleep(3000);
			
			documentText = VMPAppraisalOrderDetails.documents_txt(driver).getText();
			
			// Wait for text
			perform.waitForText(driver, VMPAppraisalOrderDetails.documents_txt(driver), "Automation");
			
			if (documentText.contains("Automation OriginatorEVF") && originator == false)
			{
				// Verify Uploaded By and Document Name
				Assert.assertTrue(documentText.contains("TestPDF.pdf"), "TestPDF.pdf is not showing as the Document Name in Order Documents");
				originator = true;
			}
			
			else if (documentText.contains("Automation EVFLender") && lender == false)
			{
				// Verify Uploaded By and Document Name
				Assert.assertTrue(documentText.contains("Test PDF_1.pdf"), "Test PDF_1.pdf is not showing as the Document Name in Order Documents");
				lender = true;
			}
				
		} // end for loop
		
		Assert.assertTrue(originator==true, "The Other document uploaded by Automation OriginatorEVF is not displaying");
		Assert.assertTrue(lender==true, "The Other document uploaded by Automation EVFLender is not displaying");
		
		// Log in to Secure
		secure.login(driver, "EVFLender", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, StoredVariables.getloanID().get(), "Tracking number");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("Revision Needed"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, awsAccountsID + "-" + StoredVariables.getloanID().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Verify order details
		secure.verifyResidentialAppraisalOrderDetails(driver);
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify the history
		Assert.assertTrue(history.contains("History (Revision Needed)"), "History (Revision Needed) is missing from the order information");
		Assert.assertTrue(history.contains("Revision Needed by AMC (" + amcCompany + ")"), "Revision Needed by Vendor (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are request revision notes from EVFAMC on Secure"), "These are request revision notes from EVFAMC on Secure is missing from the order information");
		Assert.assertTrue(history.contains("View FNM SSR"), "View FNM SSR is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Submission to FNM Not Successful"), "Appraisal Submission to FNM Not Successful is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Submitted to FNM via UCDP by AMC (" + amcCompany + ")"), "Appraisal Submitted to FNM via UCDP by Vendor (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("UCDP Document File ID Updated by AMC (" + amcCompany + ")"), "UCDP Document File ID Updated by Vendor (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("Order delivered by AMC (" + amcCompany + ") and is now Pending Quality Review"), "Order delivered by Vendor (Automation EVFAMC) and is now Pending Quality Review is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from AMC (" + amcCompany + ")"), "Message from Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser3"), "These are Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Complete by AMC (" + amcCompany + ")"), "Inspection Complete by Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspected on"), "Inspected on is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Scheduled by AMC (" + amcCompany + ")"), "Inspection Scheduled by Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection date is"), "Inspection date is is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by AMC (" + amcCompany + ")"), "Comment - Action Required by Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("This is an action required message by EVFAMC"), "This is an action required message by EVFAMC is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from AMC (" + amcCompany + ")"), "Message from Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("This is a test message from EVFAMC on the XSite"), "This is a test message from EVFAMC on the XSite is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by AMC (" + amcCompany + ")"), "Order Changed by Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraisal Fee Changed by Client (Automation EVFLender)"), "Appraisal Fee Changed by Client (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal fee changed from $0 to $673"), "Appraisal fee changed from $0 to $673 is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFLender change fee comment"), "These are EVFLender change fee comment is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed by Client (Automation EVFLender)"), "Vendor due date changed by Client (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the order information");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFLender change due date comments"), "These are EVFLender change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed by AMC (" + amcCompany + ")"), "Vendor due date changed by Vendor (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the order information");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Message from AMC (" + amcCompany + ")"), "Message from Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from AMC (" + amcCompany + ") (Test PDF_1.pdf)"), "Document Uploaded from Vendor (Automation EVFAMC) (Test PDF_1.pdf)�is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by AMC (" + amcCompany + ")"), "Resumed by Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by AMC (" + amcCompany + ")"), "Delayed by Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraiser Accepted assignment"), "Appraiser Accepted assignment is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFLender)"), "Resumed by Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation EVFLender)"), "Comment - Action Required by Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFLender)"), "Message from Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFLender) (TestPDF.pdf)"), "Document Uploaded from Client (Automation EVFLender) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFLender) (Test PDF.pdf)"), "Document Uploaded from Client (Automation EVFLender) (Test PDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Client (Automation EVFLender)"), "Delayed by Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFLender)"), "Resumed by Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Client (Automation EVFLender)"), "On Hold by Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by AMC (" + amcCompany + ")"), "Order Changed by Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Order accepted by AMC (" + amcCompany + ") and In Progress"), "Order accepted by Vendor (Automation EVFAMC) and In Progress is missing from the audit trail");
		Assert.assertTrue(history.contains("Order automatically accepted."), "Order automatically accepted. is missing from the audit trail");
		Assert.assertTrue(history.contains("Order automatically assigned"), "Order automatically assigned is missing from the audit trail");
		Assert.assertTrue(history.contains("Assigned to Automation"), "Assigned to Automation EVFAMC is missing from the audit trail");
		
		// Verify new Due Date
		Assert.assertTrue(SOrderDetails.orderDue_txt(driver).getText().contains(StoredVariables.getorderDueDateShort().get()), "New Due Date is not correct");
		
		// Verify fee
		Assert.assertTrue(SOrderDetails.assignmentInformation_txt(driver).getText().contains("673"), "Fee should have updated");
		
		// Verify Other Document is in Documents
		documentText = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(!documentText.contains("Market Information"), "Market Information should not sync to Secure");
		Assert.assertTrue(!documentText.contains("MISMO XML"), "MISMO XML should not sync to Secure");
		Assert.assertTrue(!documentText.contains("Report PDF"), "Report PDF should not sync to Secure");
		Assert.assertTrue(documentText.contains("Other"), "Other did not sync to Secure");
		Assert.assertTrue(documentText.contains("Sales Contract"), "Sales Contract did not sync to Secure");
		
		// Verify Sales ContractDocument is in Documents
		documentText = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Sales Contract"), "Sales Contract did not sync to Secure");
		
		// Click on Sales Contract
		perform.clickInTable_Contains(driver, "Sales Contract");
		
		// Wait for text to update
		perform.waitForText(driver, SOrderDetails.documents_txt(driver), "Test PDF.pdf");
		documentText = SOrderDetails.documents_txt(driver).getText();
		
		// Verify file name and uploaded by
		Assert.assertTrue(documentText.contains("Test PDF.pdf"), "Document name is incorrect in Documents");
		Assert.assertTrue(documentText.contains("Automation EVFLender"), "Uploaded By is incorrect in Documents");
		
		// Create boolean for both Other documents
		amc = false;
		lender = false;
		
		// Get Number Of Other documents
		docs = driver.findElements(By.xpath("//td[text()='Other']"));
		for (WebElement doc: docs)
		{
			
			// Click first Other document
			perform.click(driver,doc);
			
			Thread.sleep(3000);
			
			documentText = SOrderDetails.documents_txt(driver).getText();
			
			// Wait for text
			perform.waitForText(driver, SOrderDetails.documents_txt(driver), "Automation");
			
			if (documentText.contains("Automation EVFAMC") && amc == false)
			{
				// Verify Uploaded By and Document Name
				Assert.assertTrue(documentText.contains("Test PDF_1.pdf"), "Test PDF_1.pdf is not showing as the Document Name in Order Documents");
				amc = true;
			}
			
			else if (documentText.contains("Automation EVFLender") && lender == false)
			{
				// Verify Uploaded By and Document Name
				Assert.assertTrue(documentText.contains("TestPDF.pdf"), "TestPDF.pdf is not showing as the Document Name in Order Documents");
				lender = true;
			}
				
		} // end for loop
		
		Assert.assertTrue(amc==true, "The Other document uploaded by Automation EVFAMC is not displaying");
		Assert.assertTrue(lender==true, "The Other document uploaded by Automation EVFLender is not displaying");

		// View XSite order
		secure.viewXSiteOrderFromSecure(driver, "EVFAMC", StoredVariables.getpassword().get(), orderNumberAMC);
		
		// Get history text
		perform.waitForElementToBeVisible(driver, XOrders.toolbar(), "id");
		history = XOrders.history_txt(driver).getText();
		address = StoredVariables.getpropertyInformationAddress().get() + " " + StoredVariables.getpropertyInformationCity().get() + ", " + StoredVariables.getpropertyInformationStateAbbr().get() + " " + StoredVariables.getpropertyInformationZip().get();
		
		// Verify the history
		Assert.assertTrue(history.contains("History (Revision Needed)"), "History (Revision Needed) is missing from the order information");
		Assert.assertTrue(history.contains("Revision Needed (Automation EVFAMC)"), "Revision Needed (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are request revision notes from EVFAMC on Secure"), "These are request revision notes from EVFAMC on Secure is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Submission to FNM Not Successful"), "Appraisal Submission to FNM Not Successful is missing from the order information");
		Assert.assertTrue(history.contains("View FNM SSR"), "View FNM SSR is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Submitted to FNM via UCDP"), "Appraisal Submitted to FNM via UCDP is missing from the order information");
		Assert.assertTrue(history.contains("UCDP Document File ID Updated (Automation EVFAMC)"), "UCDP Document File ID Updated (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("Pending Quality Review (Automation EVFAMC)"), "Pending Quality Review (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Message (Automation EVFAMC)"), "Message (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser3"), "These are Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Complete (Automation EVFAMC)"), "Inspection Complete (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspected on"), "Inspected on is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Scheduled (Automation EVFAMC)"), "Inspection Scheduled (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection date is"), "Inspection date is is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required (Automation EVFAMC)"), "Comment - Action Required (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("This is an action required message by EVFAMC"), "This is an action required message by EVFAMC is missing from the audit trail");
		Assert.assertTrue(history.contains("Message (Automation EVFAMC)"), "Message (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("This is a test message from EVFAMC on the XSite"), "This is a test message from EVFAMC on the XSite is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed (Automation EVFAMC)"), "Order Changed (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraisal Fee Changed (Automation EVFLender)"), "Appraisal Fee Changed (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal fee changed from $0 to $673"), "Appraisal fee changed from $0 to $673 is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFLender change fee comments"), "These are EVFLender change fee comments is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed (Automation EVFLender)"), "Vendor due date changed (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFLender change due date comments"), "These are EVFLender change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed (Automation EVFAMC)"), "Vendor due date changed (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the order information");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Message (Automation EVFAMC)"), "Message (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded (Automation EVFAMC) (Test PDF_1.pdf)"), "Document Uploaded (Automation EVFAMC) (Test PDF_1.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed (Automation EVFAMC)"), "Resumed (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed (Automation EVFAMC)"), "Delayed (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraiser Accepted assignment by Appraiser"), "Appraiser Accepted assignment by Appraiser is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed (Automation EVFLender)"), "Resumed (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required (Automation EVFLender)"), "Comment - Action Required (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required for " + address), "Comment - Action Required for " + address + " is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message (Automation EVFLender)"), "Message (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("Order message for " + address), "Order message for " + address + " is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded (Automation EVFLender) (TestPDF.pdf)"), "Document Uploaded (Automation EVFLender) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded (Automation EVFLender) (Test PDF.pdf)"), "Document Uploaded (Automation EVFLender) (Test PDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed (Automation EVFLender)"), "Delayed (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed (Automation EVFLender)"), "Resumed (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold (Automation EVFLender)"), "On Hold (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed (Automation EVFAMC)"), "Order Changed (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("To View Change History:"), "To View Change History: is missing from the audit trail");
		Assert.assertTrue(history.contains("In Progress (Automation EVFAMC)"), "In Progress (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance"), "Awaiting acceptance is missing from the audit trail");
		
		// Verify order details
		perform.verifyXSiteOrderDetailsForAMC(driver);
		
		// Verify documents
		perform.waitForText(driver, XOrders.documents_txt(driver), "Other");
		documentsText = XOrders.documents_txt(driver).getText();
		Assert.assertTrue(!documentsText.contains("Market Information"), "Market Information should not sync to Secure");
		Assert.assertTrue(!documentsText.contains("No UAD Hard Stops.xml"), "No UAD Hard Stops.xml should not sync to the XSite");
		Assert.assertTrue(documentsText.contains("Other"), "Other document is missing from the documents section of the XSite - " + documentsText);
		Assert.assertTrue(documentsText.contains("TestPDF"), "TestPDF document is missing from the documents section of the XSite - " + documentsText);
		Assert.assertTrue(documentsText.contains("Test PDF_1"), "Test PDF_1 document is missing from the documents section of the XSite - " + documentsText);
		Assert.assertTrue(documentsText.contains("Sales Contract"), "Sales Contract document is missing from the documents section of the XSite - " + documentsText);
		Assert.assertTrue(documentsText.contains("Test PDF"), "Test PDF document is missing from the documents section of the XSite - " + documentsText);
		
		// Verify comments
		comments = XOrders.comments_txt(driver).getText();
		Assert.assertTrue(comments.contains("These are edited comments by EVFAMC"), "Additional Comments section is missing info");
		
		// Verify new Due Date
		Assert.assertTrue(XOrders.dueDate_txt(driver).getText().equals(StoredVariables.getorderDueDateShort().get()), "New Due Date is not correct");
		
		// Verify fee
		Assert.assertTrue(XOrders.fee_txt(driver).getText().equals("$673.00"), "Fee should have updated");
		
		// Close XSite order
		perform.closeNewWindow(driver);

		// Log in to Vendors
		vendors.login(driver, "Appraiser3", StoredVariables.getpassword().get());
		
		// Search for order
		vendors.findOrder(driver, orderNumberAMC, "Tracking Number");
		
		// Verify order status
		Assert.assertTrue(VOrders.ordersGrid_txt(driver).getText().contains("Revision Needed"), "The order is not in the correct status");
		
		// Click on the order from the orders grid
		perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, VOrderDetails.orderInformation_txt(), "id");
		
		// Get order information text
		history = VOrderDetails.orderInformation_txt(driver).getText();
		
		// Verify audit trail
		Assert.assertTrue(history.contains("History (Revision Needed)"), "History (Revision Needed) is missing from the order information");
		Assert.assertTrue(history.contains("Revision Needed by Client (Automation EVFAMC)"), "Revision Needed by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are request revision notes from EVFAMC on Secure"), "These are request revision notes from EVFAMC on Secure is missing from the order information");
		Assert.assertTrue(history.contains("Order delivered by Appraiser (Automation Appraiser3) and is now In QC - Level One"), "Order delivered by Appraiser (Automation Appraiser3) and is now In QC - Level One is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser3)"), "Message from Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser3"), "These are Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Complete by Appraiser (Automation Appraiser3)"), "Inspection Complete by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspected on"), "Inspected on is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Scheduled by Appraiser (Automation Appraiser3)"), "Inspection Scheduled by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection date is"), "Inspection date is is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFAMC)"), "Message from Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("This is a test message from EVFAMC on the XSite"), "This is a test message from EVFAMC on the XSite is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by AMC ("+amcCompany+")"), "Order Changed by AMC ("+amcCompany+") is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are EVFLender change fee comments"), "These are EVFLender change fee comments is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed by Client (Automation EVFAMC)"), "Vendor due date changed by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFLender change due date comments"), "These are EVFLender change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Fee Changed by Client (Automation EVFAMC)"), "Appraisal Fee Changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraisal fee changed from $350 to $525."), "Appraisal fee changed from $350 to $525. is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFAMC change fee comments"), "These are EVFAMC change fee comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed by Client (Automation EVFAMC)"), "Vendor due date changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the audit trail");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser3)"), "Message from Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Apostrophes License.pdf)"), "Document Uploaded from Appraiser (Automation Appraiser3) (Apostrophes License.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Test PDF_1.pdf)"), "Document Uploaded from Appraiser (Automation Appraiser3) (Test PDF_1.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Appraiser (Automation Appraiser3)"), "Resumed by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Appraiser (Automation Appraiser3)"), "Delayed by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order accepted by Appraiser (Automation Appraiser3) and In Progress"), "Order accepted by Appraiser (Automation Appraiser3) and In Progress is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation EVFAMC)"), "Comment - Action Required by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFAMC)"), "Message from Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(!history.contains("Document Uploaded from Client (Automation EVFAMC) (Test PDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC) (Test PDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Client (Automation EVFAMC)"), "Delayed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Client (Automation EVFAMC)"), "On Hold by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser3"), "Awaiting acceptance by Automation Appraiser3 is missing from the audit trail");
		
		// Verify new Due Date
		Assert.assertTrue(VOrderDetails.orderInformation_txt(driver).getText().contains(StoredVariables.getorderDueDateShort().get()), "New Due Date is not correct");
		
		// Verify fee
		Assert.assertTrue(VOrderDetails.orderInformation_txt(driver).getText().contains("$525"), "Fee should not have updated");
		
		// Get comments
		additionalComments = VOrderDetails.additionalComments_txt(driver).getText();
		
		// Verify both VMP and MN comments are displayed
		Assert.assertTrue(additionalComments.contains("These are edited comments by EVFAMC"), "Additional Comments section is missing info");
		
		// View Order Details
		vendors.verifyOrderDetails(driver);
		
		// Verify Document is in Documents
		documentText = VOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Report PDF"), "Report PDF did not sync to Vendors");
		Assert.assertTrue(documentText.contains("MISMO XML"), "MISMO XML did not sync to Vendors");
		Assert.assertTrue(documentText.contains("Other"), "Other did not sync to Vendors");
		Assert.assertTrue(documentText.contains("Market Information"), "Market Information did not sync to Vendors");
		Assert.assertTrue(!documentText.contains("Sales Contract"), "Sales Contract should not sync to Vendors");

		// Log in to Secure
		secure.login(driver, "EVFAMC", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, orderNumberAMC, "Tracking number");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("Appraisal Submission to FNM Not Successful"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, awsAccountsID + "-" + orderNumberAMC);
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Verify order details0
		secure.verifyResidentialAppraisalOrderDetails(driver);
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify the history
		Assert.assertTrue(history.contains("History (Revision Needed)"), "History (Revision Needed) is missing from the order information");
		Assert.assertTrue(history.contains("Revision Needed by Client (Automation EVFAMC)"), "Revision Needed by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are request revision notes from EVFAMC on Secure"), "These are request revision notes from EVFAMC on Secure is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Submission to FNM Not Successful"), "Appraisal Submission to FNM Not Successful is missing from the order information");
		Assert.assertTrue(history.contains("View FNM SSR"), "View FNM SSR is missing from the order information");
		Assert.assertTrue(history.contains("UCDP Document File ID Updated by Client (Automation EVFAMC)"), "UCDP Document File ID Updated by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("Note Added (Automation EVFAMC)"), "Note Added (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are internal notes from EVFAMC on Secure"), "These are internal notes from EVFAMC on Secure is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Submitted to FNM via UCDP by Client (Automation EVFAMC)"), "Appraisal Submitted to FNM via UCDP by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("Order delivered by Appraiser (Automation Appraiser3) and is now In QC - Level One"), "Order delivered by Appraiser (Automation Appraiser3) and is now In QC - Level One is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser3)"), "Message from Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser3"), "These are Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Complete by Appraiser (Automation Appraiser3)"), "Inspection Complete by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspected on"), "Inspected on is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Scheduled by Appraiser (Automation Appraiser3)"), "Inspection Scheduled by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection date is"), "Inspection date is is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFAMC)"), "Message from Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("This is a test message from EVFAMC on the XSite"), "This is a test message from EVFAMC on the XSite is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by Client (Automation EVFAMC)"), "Order Changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are EVFLender change fee comments"), "These are EVFLender change fee comments is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed by Client (Automation EVFAMC)"), "Vendor due date changed by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFLender change due date comments"), "These are EVFLender change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Fee Changed by Client (Automation EVFAMC)"), "Appraisal Fee Changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraisal fee changed from $350 to $525."), "Appraisal fee changed from $350 to $525. is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFAMC change fee comments"), "These are EVFAMC change fee comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed by Client (Automation EVFAMC)"), "Vendor due date changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the audit trail");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser3)"), "Message from Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Apostrophes License.pdf)"), "Document Uploaded from Vendor (Automation Appraiser3) (Apostrophes License.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Test PDF_1.pdf)"), "Document Uploaded from Vendor (Automation Appraiser3) (Test PDF_1.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Appraiser (Automation Appraiser3)"), "Resumed by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Appraiser (Automation Appraiser3)"), "Delayed by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order accepted by Appraiser (Automation Appraiser3) and In Progress"), "Order accepted by Appraiser (Automation Appraiser3) and In Progress is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation EVFAMC)"), "Comment - Action Required by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFAMC)"), "Message from Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(!history.contains("Document Uploaded from Client (Automation EVFAMC) (Test PDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC) (Test PDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Client (Automation EVFAMC)"), "Delayed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Client (Automation EVFAMC)"), "On Hold by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser3"), "Awaiting acceptance by Automation Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Reassigned by Client (Automation EVFAMC) to Automation Appraiser3"), "Reassigned by Client (Automation EVFAMC) to Automation Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by Client (Automation EVFAMC)"), "Order Changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("To View Change History:"), "To View Change History: is missing from the audit trail");
		Assert.assertTrue(history.contains("Requires assignment"), "Requires assignment is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance"), "Awaiting acceptance is missing from the audit trail");
		
		// Verify new Due Date
		Assert.assertTrue(SOrderDetails.orderDue_txt(driver).getText().contains(StoredVariables.getorderDueDateShort().get()), "New Due Date is not correct");
		
		// Verify fee
		Assert.assertTrue(SOrderDetails.assignmentInformation_txt(driver).getText().contains("525"), "Fee should not have updated");
		
		// Verify Other Document is in Documents
		documentText = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Report PDF"), "Report PDF did not sync to Secure");
		Assert.assertTrue(documentText.contains("MISMO XML"), "MISMO XML did not sync to Secure");
		Assert.assertTrue(documentText.contains("FNM SSR"), "FNM SSR did not sync to Secure");
		Assert.assertTrue(documentText.contains("Other"), "Other did not sync to Secure");
		Assert.assertTrue(documentText.contains("Market Information"), "Market Information did not sync to Secure");
		Assert.assertTrue(!documentText.contains("Sales Contract"), "Sales Contract should not sync to Secure");
		
		// Login to VMP Client Portal
		vmp.login(driver, "EVFLender", "OriginatorEVF", StoredVariables.getpassword().get());
		
		// Search for order
		vmp.findOrder(driver, StoredVariables.getloanIDVMP().get(), "Tracking #");
		
		// Verify Order Status
		Assert.assertTrue(VMPOrders.orderStatus_txt(driver).getText().equals("Revision Needed"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());
		
		Thread.sleep(1500);
		
		// Wait for Edit Property Contacts link
		perform.waitForElementToBeClickable(driver, VMPAppraisalOrderDetails.editPropertyContacts_lnk(), "id");
		
		// Click Other Actions
		perform.click(driver,VMPAppraisalOrderDetails.otherActions_btn(driver));
		
		// Click Cancel Revision Request
		perform.click(driver,VMPAppraisalOrderDetails.cancelRevisionRequest_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);

		// Wait for the ok button to be clickable
		perform.waitForElementToBeClickable(driver, VMPCancelRevisionRequest.ok_btn(), "cssSelector");
		
		// Enter Notes
		perform.type(driver,VMPCancelRevisionRequest.notes_txtbx(driver), "These are cancel revision request notes from OriginatorEVF");
		
		// Click OK
		perform.click(driver,VMPCancelRevisionRequest.ok_btn(driver));
		
		// Wait for alert ok button
		perform.waitForElementToBeClickable(driver, VMPAppraisalOrderDetails.alertDialogOk_btn(), "cssSelector");
		
		// Click OK
		perform.click(driver,VMPAppraisalOrderDetails.alertDialogOk_btn(driver));
		
		// Wait for overlay
		perform.waitForOverlayToBeHidden(driver);
		
		// View XSite order
		secure.viewXSiteOrderFromSecure(driver, "EVFLender", StoredVariables.getpassword().get(), StoredVariables.getloanID().get());
		
		// Get history text
		perform.waitForElementToBeVisible(driver, XOrders.toolbar(), "id");
		history = XOrders.history_txt(driver).getText();
		address = StoredVariables.getpropertyInformationAddress().get() + " " + StoredVariables.getpropertyInformationCity().get() + ", " + StoredVariables.getpropertyInformationStateAbbr().get() + " " + StoredVariables.getpropertyInformationZip().get();
		
		// Recapture the text from the history
		history = XOrders.history_txt(driver).getText();
		
		// Verify the history
		Assert.assertTrue(history.contains("History (Revision Needed)"), "History (Revision Needed) is missing from the order information");
		Assert.assertTrue(history.contains("Revision Request Cancelled (Automation OriginatorEVF)"), "Revision Request Cancelled (Automation OriginatorEVF) is missing from the order information");
		Assert.assertTrue(history.contains("These are cancel revision request notes from OriginatorEVF"), "These are cancel revision request notes from OriginatorEVF is missing from the order information");
		Assert.assertTrue(history.contains("Revision Needed (Automation EVFLender)"), "Revision Needed (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are request revision notes from EVFAMC on Secure"), "These are request revision notes from EVFAMC on Secure is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Submission to FNM Not Successful"), "Appraisal Submission to FNM Not Successful is missing from the order information");
		Assert.assertTrue(history.contains("View FNM SSR"), "View FNM SSR is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Submitted to FNM via UCDP"), "Appraisal Submitted to FNM via UCDP is missing from the order information");
		Assert.assertTrue(history.contains("UCDP Document File ID Updated (Automation EVFLender)"), "UCDP Document File ID Updated (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(!history.contains("Pending Quality Review (Automation EVFLender)"), "Order delivered by Vendor (Automation EVFAMC) and is now Pending Quality Review is missing from the order information");
		Assert.assertTrue(history.contains("Message (Automation EVFLender)"), "Message (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser3"), "These are Message notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Inspection Complete (Automation EVFLender)"), "Inspection Complete (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("Inspected on"), "Inspected on is missing from the order information");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Inspection Scheduled (Automation EVFLender)"), "Inspection Scheduled (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("Inspection date is"), "Inspection date is is missing from the order information");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Comment - Action Required (Automation EVFLender)"), "Comment - Action Required (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("This is an action required message by EVFAMC"), "This is an action required message by EVFAMC is missing from the order information");
		Assert.assertTrue(history.contains("Order Changed (Automation EVFLender)"), "Order Changed (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("Message (Automation EVFLender)"), "Message (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("This is a test message from EVFAMC on the XSite"), "This is a test message from EVFAMC on the XSite is missing from the order information");
		Assert.assertTrue(!history.contains("These are EVFLender change fee comments"), "These are EVFLender change fee comments is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFLender change due date comments"), "These are EVFLender change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed (Automation EVFLender)"), "Vendor due date changed (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the order information");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Message (Automation EVFLender)"), "Message (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Document Uploaded (Automation EVFLender) (Test PDF_1.pdf)"), "Document Uploaded (Automation EVFLender) (Test PDF_1.pdf) is missing from the order information");
		Assert.assertTrue(history.contains("Resumed (Automation EVFLender)"), "Resumed (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Delayed (Automation EVFLender)"), "Delayed (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Vendor Accepted Assignment (Automation EVFLender)"), "Vendor Accepted Assignment (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the order information");
		Assert.assertTrue(history.contains("Resumed (Automation EVFLender)"), "Resumed (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required (Automation OriginatorEVF)"), "Comment - Action Required (Automation OriginatorEVF) is missing from the order information");
		Assert.assertTrue(history.contains("Comment - Action Required for " + address), "Comment - Action Required for " + address + " is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message (Automation OriginatorEVF)"), "Message (Automation OriginatorEVF) is missing from the audit trail");
		Assert.assertTrue(history.contains("Order message for " + address), "Order message for " + address + " is missing from the order information");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded (Automation OriginatorEVF) (TestPDF.pdf)"), "Document Uploaded (Automation OriginatorEVF) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded (Automation OriginatorEVF) (Test PDF.pdf)"), "Document Uploaded (Automation OriginatorEVF) (Test PDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed (Automation OriginatorEVF)"), "Delayed (Automation OriginatorEVF) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed (Automation OriginatorEVF)"), "Resumed (Automation OriginatorEVF) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold (Automation OriginatorEVF)"), "On Hold (Automation OriginatorEVF) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the order information");
		Assert.assertTrue(history.contains("In Progress (Automation OriginatorEVF)"), "In Progress (Automation OriginatorEVF) is missing from the audit trail");
		
		// Verify order details
		perform.verifyXSiteOrderDetailsForLender(driver);
		
		// Verify documents
		documentsText = XOrders.documents_txt(driver).getText();
		Assert.assertTrue(documentsText.contains("Other"), "Other document is missing from the documents section of the XSite");
		Assert.assertTrue(documentsText.contains("TestPDF"), "TestPDF document is missing from the documents section of the XSite");
		Assert.assertTrue(documentsText.contains("Test PDF_1"), "TestPDF document is missing from the documents section of the XSite");
		Assert.assertTrue(documentsText.contains("Sales Contract"), "Sales Contract document is missing from the documents section of the XSite");
		Assert.assertTrue(documentsText.contains("Test PDF"), "Test PDF document is missing from the documents section of the XSite");
		Assert.assertTrue(!documentsText.contains("Apostrophes License"), "Apostrophes License should not sync to the XSite");
		Assert.assertTrue(!documentsText.contains("No UAD Hard Stops.xml"), "No UAD Hard Stops.xml should not sync to the XSite");
		
		// Verify comments
		comments = XOrders.comments_txt(driver).getText();
		Assert.assertTrue(comments.contains("These are test additional comments"), "Additional Comments section is missing info");
		
		// Verify new Due Date
		Assert.assertTrue(XOrders.dueDate_txt(driver).getText().equals(StoredVariables.getorderDueDateShort().get()), "New Due Date is not correct - It is: " + XOrders.dueDate_txt(driver).getText() + ", but should be: " + StoredVariables.getorderDueDateShort().get());
		
		// Verify fee
		Assert.assertTrue(XOrders.fee_txt(driver).getText().equals("$350.00"), "Fee should not update");
		
		// Close XSite order
		perform.closeNewWindow(driver);
		
		// Login to VMP Client Portal
		vmp.login(driver, "EVFLender", "OriginatorEVF", StoredVariables.getpassword().get());
		
		// Search for order
		vmp.findOrder(driver, StoredVariables.getloanIDVMP().get(), "Tracking #");
		
		// Wait for db to update order status on Secure
		vmp.waitForDBUpdateForOrderStatus(driver, "Revision Needed");
		
		// Verify Order Status
		Assert.assertTrue(VMPOrders.orderStatus_txt(driver).getText().equals("Revision Needed"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());
		
		Thread.sleep(1500);
		
		// Wait for Edit Property Contacts link
		perform.waitForElementToBeClickable(driver, VMPAppraisalOrderDetails.editPropertyContacts_lnk(), "id");
		
		// Verify the audit trail
		history = VMPAppraisalOrderDetails.history_txt(driver).getText();
		
		Assert.assertTrue(history.contains("Revision Request Cancelled by Automation OriginatorEVF"), "Revision Request Cancelled by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are cancel revision request notes from OriginatorEVF"), "These are cancel revision request notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Revision Needed by Automation EVFLender"), "Revision Needed by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are request revision notes from EVFAMC on Secure"), "These are request revision notes from EVFAMC on Secure is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraisal Submission to FNM Not Successful by Automation EVFLender"), "Appraisal Submission to FNM Not Successful by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("View FNM SSR"), "View FNM SSR is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraisal Submitted to FNM via UCDP by Automation EVFLender"), "Appraisal Submitted to FNM via UCDP by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("UCDP Document File ID Updated by Automation EVFLender"), "UCDP Document File ID Updated by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(!history.contains("Pending Quality Review by Automation EVFLender"), "Pending Quality Review by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation EVFLender"), "Message by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser3"), "These are Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Complete by Automation EVFLender"), "Inspection Complete by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspected on"), "Inspected on is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Scheduled by Automation EVFLender"), "Inspection Scheduled by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection date is"), "Inspection date is is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Automation EVFLender"), "Comment - Action Required by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("This is an action required message by EVFAMC"), "This is an action required message by EVFAMC is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by Automation EVFLender"), "Order Changed by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by Automation EVFLender"), "Order Changed by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation EVFLender"), "Message by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("This is a test message from EVFAMC on the XSite"), "This is a test message from EVFAMC on the XSite is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are EVFLender change fee comments"), "These are EVFLender change fee comments is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed by Automation EVFLender"), "Vendor due date changed by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the audit trail");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFLender change due date comments"), "These are EVFLender change due date comments is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation EVFLender"), "Message by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation EVFLender"), "Document Uploaded by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("Other"), "Other is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF_1.pdf"), "Test PDF_1.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation EVFLender"), "Resumed by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation EVFLender"), "Delayed by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraiser Accepted Assignment by Automation EVFLender"), "Appraiser Accepted Assignment by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorEVF"), "Resumed by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Automation OriginatorEVF"), "Comment - Action Required by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation OriginatorEVF"), "Message by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorEVF"), "Document Uploaded by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Other"), "Other is missing from the audit trail");
		Assert.assertTrue(history.contains("TestPDF.pdf"), "TestPDF.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorEVF"), "Document Uploaded by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Sales Contract"), "Sales Contract is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF.pdf"), "Test PDF.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation OriginatorEVF"), "Delayed by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorEVF"), "Resumed by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Automation OriginatorEVF"), "On Hold by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("In Progress by Automation OriginatorEVF"), "In Progress by Automation OriginatorEVF is missing from the audit trail");
		
		// Verify new Due Date
		Assert.assertTrue(VMPAppraisalOrderDetails.orderDetails_txt(driver).getText().contains(StoredVariables.getorderDueDateShort().get()), "New Due Date is not correct");
		
		// Verify fee
		Assert.assertTrue(VMPAppraisalOrderDetails.orderDetails_txt(driver).getText().contains("$350"), "Fee should not update");
		
		// Verify the order details
		vmp.verifyAppraisalOrderDetails(driver);
		
		// Verify Document is in Documents
		documentText = VMPAppraisalOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Other"), "Other document is not displayed in VMP Client Portal");
		Assert.assertTrue(documentText.contains("Sales Contract"), "Sales Contract did not sync to VMP Client Portal");
		Assert.assertTrue(!documentText.contains("Market Information"), "Market Information should not sync to VMP Client Portal");
		Assert.assertTrue(!documentText.contains("MISMO XML"), "MISMO XML should not sync to VMP Client Portal");
		Assert.assertTrue(!documentText.contains("Report PDF"), "Report PDF should not sync to VMP Client Portal");
		
		// Click on Sales Contract
		perform.clickInTable_Contains(driver, "Sales Contract");
		
		// Wait for text to update
		perform.waitForText(driver, VMPAppraisalOrderDetails.documents_txt(driver), "Test PDF.pdf");
		documentText = VMPAppraisalOrderDetails.documents_txt(driver).getText();
		
		// Verify file name and uploaded by
		Assert.assertTrue(documentText.contains("Test PDF.pdf"), "Document name is incorrect in Documents");
		Assert.assertTrue(documentText.contains("Automation OriginatorEVF"), "Uploaded By is incorrect in Documents");
		
		// Create boolean for both Other documents
		originator = false;
		lender = false;
		
		// Get Number Of Other documents
		docs = driver.findElements(By.xpath("//td[text()='Other']"));
		for (WebElement doc: docs)
		{
			
			// Click first Other document
			perform.click(driver,doc);
			
			Thread.sleep(3000);
			
			documentText = VMPAppraisalOrderDetails.documents_txt(driver).getText();
			
			// Wait for text
			perform.waitForText(driver, VMPAppraisalOrderDetails.documents_txt(driver), "Automation");
			
			if (documentText.contains("Automation OriginatorEVF") && originator == false)
			{
				// Verify Uploaded By and Document Name
				Assert.assertTrue(documentText.contains("TestPDF.pdf"), "TestPDF.pdf is not showing as the Document Name in Order Documents");
				originator = true;
			}
			
			else if (documentText.contains("Automation EVFLender") && lender == false)
			{
				// Verify Uploaded By and Document Name
				Assert.assertTrue(documentText.contains("Test PDF_1.pdf"), "Test PDF_1.pdf is not showing as the Document Name in Order Documents");
				lender = true;
			}
				
		} // end for loop
		
		Assert.assertTrue(originator==true, "The Other document uploaded by Automation OriginatorEVF is not displaying");
		Assert.assertTrue(lender==true, "The Other document uploaded by Automation EVFLender is not displaying");

		// Log in to Secure
		secure.login(driver, "EVFLender", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, StoredVariables.getloanID().get(), "Tracking number");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("Pending Quality Review"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, awsAccountsID + "-" + StoredVariables.getloanID().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Verify order details
		secure.verifyResidentialAppraisalOrderDetails(driver);
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify the history
		Assert.assertTrue(history.contains("History (Pending Quality Review)"), "History (Pending Quality Review) is missing from the order information"); //changed from Revision Needed
		Assert.assertTrue(history.contains("Revision Request Cancelled by Client (Automation EVFLender)"), "Revision Request Cancelled by Client (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are cancel revision request notes from OriginatorEVF"), "These are cancel revision request notes from OriginatorEVF is missing from the order information");
		Assert.assertTrue(history.contains("Revision Needed by AMC (" + amcCompany + ")"), "Revision Needed by Vendor (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are request revision notes from EVFAMC on Secure"), "These are request revision notes from EVFAMC on Secure is missing from the order information");
		Assert.assertTrue(history.contains("View FNM SSR"), "View FNM SSR is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Submission to FNM Not Successful"), "Appraisal Submission to FNM Not Successful is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Submitted to FNM via UCDP by AMC (" + amcCompany + ")"), "Appraisal Submitted to FNM via UCDP by Vendor (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("UCDP Document File ID Updated by AMC (" + amcCompany + ")"), "UCDP Document File ID Updated by Vendor (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("Order delivered by AMC (" + amcCompany + ") and is now Pending Quality Review"), "Order delivered by Vendor (Automation EVFAMC) and is now Pending Quality Review is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from AMC (" + amcCompany + ")"), "Message from Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser3"), "These are Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Complete by AMC (" + amcCompany + ")"), "Inspection Complete by Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspected on"), "Inspected on is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Scheduled by AMC (" + amcCompany + ")"), "Inspection Scheduled by Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection date is"), "Inspection date is is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by AMC (" + amcCompany + ")"), "Comment - Action Required by Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("This is an action required message by EVFAMC"), "This is an action required message by EVFAMC is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from AMC (" + amcCompany + ")"), "Message from Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("This is a test message from EVFAMC on the XSite"), "This is a test message from EVFAMC on the XSite is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by AMC (" + amcCompany + ")"), "Order Changed by Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraisal Fee Changed by Client (Automation EVFLender)"), "Appraisal Fee Changed by Client (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal fee changed from $0 to $673"), "Appraisal fee changed from $0 to $673 is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFLender change fee comment"), "These are EVFLender change fee comment is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed by Client (Automation EVFLender)"), "Vendor due date changed by Client (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the order information");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFLender change due date comments"), "These are EVFLender change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed by AMC (" + amcCompany + ")"), "Vendor due date changed by Vendor (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the order information");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Message from AMC (" + amcCompany + ")"), "Message from Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from AMC (" + amcCompany + ") (Test PDF_1.pdf)"), "Document Uploaded from Vendor (Automation EVFAMC) (Test PDF_1.pdf)�is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by AMC (" + amcCompany + ")"), "Resumed by Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by AMC (" + amcCompany + ")"), "Delayed by Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraiser Accepted assignment"), "Appraiser Accepted assignment is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFLender)"), "Resumed by Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation EVFLender)"), "Comment - Action Required by Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFLender)"), "Message from Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFLender) (TestPDF.pdf)"), "Document Uploaded from Client (Automation EVFLender) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFLender) (Test PDF.pdf)"), "Document Uploaded from Client (Automation EVFLender) (Test PDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Client (Automation EVFLender)"), "Delayed by Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFLender)"), "Resumed by Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Client (Automation EVFLender)"), "On Hold by Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by AMC (" + amcCompany + ")"), "Order Changed by Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Order accepted by AMC (" + amcCompany + ") and In Progress"), "Order accepted by Vendor (Automation EVFAMC) and In Progress is missing from the audit trail");
		Assert.assertTrue(history.contains("Order automatically accepted."), "Order automatically accepted. is missing from the audit trail");
		Assert.assertTrue(history.contains("Order automatically assigned"), "Order automatically assigned is missing from the audit trail");
		Assert.assertTrue(history.contains("Assigned to Automation"), "Assigned to Automation EVFAMC is missing from the audit trail");
		
		// Verify new Due Date
		Assert.assertTrue(SOrderDetails.orderDue_txt(driver).getText().contains(StoredVariables.getorderDueDateShort().get()), "New Due Date is not correct");
		
		// Verify fee
		Assert.assertTrue(SOrderDetails.assignmentInformation_txt(driver).getText().contains("673"), "Fee should have updated");
		
		// Verify Other Document is in Documents
		documentText = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(!documentText.contains("Market Information"), "Market Information should not sync to Secure");
		Assert.assertTrue(!documentText.contains("MISMO XML"), "MISMO XML should not sync to Secure");
		Assert.assertTrue(!documentText.contains("Report PDF"), "Report PDF should not sync to Secure");
		Assert.assertTrue(documentText.contains("Other"), "Other did not sync to Secure");
		Assert.assertTrue(documentText.contains("Sales Contract"), "Sales Contract did not sync to Secure");
		
		// Verify Sales ContractDocument is in Documents
		documentText = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Sales Contract"), "Sales Contract did not sync to Secure");
		
		// Click on Sales Contract
		perform.clickInTable_Contains(driver, "Sales Contract");
		
		// Wait for text to update
		perform.waitForText(driver, SOrderDetails.documents_txt(driver), "Test PDF.pdf");
		documentText = SOrderDetails.documents_txt(driver).getText();
		
		// Verify file name and uploaded by
		Assert.assertTrue(documentText.contains("Test PDF.pdf"), "Document name is incorrect in Documents");
		Assert.assertTrue(documentText.contains("Automation EVFLender"), "Uploaded By is incorrect in Documents");
		
		// Create boolean for both Other documents
		amc = false;
		lender = false;
		
		// Get Number Of Other documents
		docs = driver.findElements(By.xpath("//td[text()='Other']"));
		for (WebElement doc: docs)
		{
			
			// Click first Other document
			perform.click(driver,doc);
			
			Thread.sleep(3000);
			
			documentText = SOrderDetails.documents_txt(driver).getText();
			
			// Wait for text
			perform.waitForText(driver, SOrderDetails.documents_txt(driver), "Automation");
			
			if (documentText.contains("Automation EVFAMC") && amc == false)
			{
				// Verify Uploaded By and Document Name
				Assert.assertTrue(documentText.contains("Test PDF_1.pdf"), "Test PDF_1.pdf is not showing as the Document Name in Order Documents");
				amc = true;
			}
			
			else if (documentText.contains("Automation EVFLender") && lender == false)
			{
				// Verify Uploaded By and Document Name
				Assert.assertTrue(documentText.contains("TestPDF.pdf"), "TestPDF.pdf is not showing as the Document Name in Order Documents");
				lender = true;
			}
				
		} // end for loop
		
		Assert.assertTrue(amc==true, "The Other document uploaded by Automation EVFAMC is not displaying");
		Assert.assertTrue(lender==true, "The Other document uploaded by Automation EVFLender is not displaying");
		
		// View XSite order
		secure.viewXSiteOrderFromSecure(driver, "EVFAMC", StoredVariables.getpassword().get(), orderNumberAMC);
		
		// Get history text
		perform.waitForElementToBeVisible(driver, XOrders.toolbar(), "id");
		history = XOrders.history_txt(driver).getText();
		address = StoredVariables.getpropertyInformationAddress().get() + " " + StoredVariables.getpropertyInformationCity().get() + ", " + StoredVariables.getpropertyInformationStateAbbr().get() + " " + StoredVariables.getpropertyInformationZip().get();
		
		// Verify the history
		Assert.assertTrue(history.contains("History (Pending Quality Review)"), "History (Pending Quality Review) is missing from the order information"); //changed from Revision Needed
		Assert.assertTrue(history.contains("Revision Request Cancelled (Automation EVFLender)"), "Revision Request Cancelled (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are cancel revision request notes from OriginatorEVF"), "These are cancel revision request notes from OriginatorEVF is missing from the order information");
		Assert.assertTrue(history.contains("Revision Needed (Automation EVFAMC)"), "Revision Needed (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are request revision notes from EVFAMC on Secure"), "These are request revision notes from EVFAMC on Secure is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Submission to FNM Not Successful"), "Appraisal Submission to FNM Not Successful is missing from the order information");
		Assert.assertTrue(history.contains("View FNM SSR"), "View FNM SSR is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Submitted to FNM via UCDP"), "Appraisal Submitted to FNM via UCDP is missing from the order information");
		Assert.assertTrue(history.contains("UCDP Document File ID Updated (Automation EVFAMC)"), "UCDP Document File ID Updated (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("Pending Quality Review (Automation EVFAMC)"), "Pending Quality Review (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Message (Automation EVFAMC)"), "Message (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser3"), "These are Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Complete (Automation EVFAMC)"), "Inspection Complete (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspected on"), "Inspected on is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Scheduled (Automation EVFAMC)"), "Inspection Scheduled (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection date is"), "Inspection date is is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required (Automation EVFAMC)"), "Comment - Action Required (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("This is an action required message by EVFAMC"), "This is an action required message by EVFAMC is missing from the audit trail");
		Assert.assertTrue(history.contains("Message (Automation EVFAMC)"), "Message (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("This is a test message from EVFAMC on the XSite"), "This is a test message from EVFAMC on the XSite is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed (Automation EVFAMC)"), "Order Changed (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraisal Fee Changed (Automation EVFLender)"), "Appraisal Fee Changed (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal fee changed from $0 to $673"), "Appraisal fee changed from $0 to $673 is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFLender change fee comments"), "These are EVFLender change fee comments is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed (Automation EVFLender)"), "Vendor due date changed (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFLender change due date comments"), "These are EVFLender change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed (Automation EVFAMC)"), "Vendor due date changed (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the order information");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Message (Automation EVFAMC)"), "Message (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded (Automation EVFAMC) (Test PDF_1.pdf)"), "Document Uploaded (Automation EVFAMC) (Test PDF_1.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed (Automation EVFAMC)"), "Resumed (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed (Automation EVFAMC)"), "Delayed (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraiser Accepted assignment by Appraiser"), "Appraiser Accepted assignment by Appraiser is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed (Automation EVFLender)"), "Resumed (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required (Automation EVFLender)"), "Comment - Action Required (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required for " + address), "Comment - Action Required for " + address + " is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message (Automation EVFLender)"), "Message (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("Order message for " + address), "Order message for " + address + " is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded (Automation EVFLender) (TestPDF.pdf)"), "Document Uploaded (Automation EVFLender) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded (Automation EVFLender) (Test PDF.pdf)"), "Document Uploaded (Automation EVFLender) (Test PDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed (Automation EVFLender)"), "Delayed (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed (Automation EVFLender)"), "Resumed (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold (Automation EVFLender)"), "On Hold (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed (Automation EVFAMC)"), "Order Changed (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("To View Change History:"), "To View Change History: is missing from the audit trail");
		Assert.assertTrue(history.contains("In Progress (Automation EVFAMC)"), "In Progress (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance"), "Awaiting acceptance is missing from the audit trail");
		
		// Verify order details
		perform.verifyXSiteOrderDetailsForAMC(driver);
		
		// Verify documents
		perform.waitForText(driver, XOrders.documents_txt(driver), "Other");
		documentsText = XOrders.documents_txt(driver).getText();
		Assert.assertTrue(!documentsText.contains("Market Information"), "Market Information should not sync to Secure");
		Assert.assertTrue(!documentsText.contains("No UAD Hard Stops.xml"), "No UAD Hard Stops.xml should not sync to the XSite");
		Assert.assertTrue(documentsText.contains("Other"), "Other document is missing from the documents section of the XSite - " + documentsText);
		Assert.assertTrue(documentsText.contains("TestPDF"), "TestPDF document is missing from the documents section of the XSite - " + documentsText);
		Assert.assertTrue(documentsText.contains("Test PDF_1"), "Test PDF_1 document is missing from the documents section of the XSite - " + documentsText);
		Assert.assertTrue(documentsText.contains("Sales Contract"), "Sales Contract document is missing from the documents section of the XSite - " + documentsText);
		Assert.assertTrue(documentsText.contains("Test PDF"), "Test PDF document is missing from the documents section of the XSite - " + documentsText);
		
		// Verify comments
		comments = XOrders.comments_txt(driver).getText();
		Assert.assertTrue(comments.contains("These are edited comments by EVFAMC"), "Additional Comments section is missing info");
		
		// Verify new Due Date
		Assert.assertTrue(XOrders.dueDate_txt(driver).getText().equals(StoredVariables.getorderDueDateShort().get()), "New Due Date is not correct");
		
		// Verify fee
		Assert.assertTrue(XOrders.fee_txt(driver).getText().equals("$673.00"), "Fee should have updated");
		
		// Close XSite order
		perform.closeNewWindow(driver);
		
		// Log in to Vendors
		vendors.login(driver, "Appraiser3", StoredVariables.getpassword().get());
		
		// Search for order
		vendors.findOrder(driver, orderNumberAMC, "Tracking Number");
		
		// Verify order status
		Assert.assertTrue(VOrders.ordersGrid_txt(driver).getText().contains("In QC - Level One"), "The order is not in the correct status"); //changed from Revision Needed
		
		// Click on the order from the orders grid
		perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, VOrderDetails.orderInformation_txt(), "id");
		
		// Get order information text
		history = VOrderDetails.orderInformation_txt(driver).getText();
		
		// Verify audit trail
		Assert.assertTrue(history.contains("History (In QC - Level One)"), "History (In QC - Level One) is missing from the order information"); //changed from Revision Needed
		Assert.assertTrue(history.contains("Revision Request Cancelled by Client (Automation EVFAMC)"), "Revision Request Cancelled by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are cancel revision request notes from OriginatorEVF"), "These are cancel revision request notes from OriginatorEVF is missing from the order information");
		Assert.assertTrue(history.contains("Revision Needed by Client (Automation EVFAMC)"), "Revision Needed by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are request revision notes from EVFAMC on Secure"), "These are request revision notes from EVFAMC on Secure is missing from the order information");
		Assert.assertTrue(history.contains("Order delivered by Appraiser (Automation Appraiser3) and is now In QC - Level One"), "Order delivered by Appraiser (Automation Appraiser3) and is now In QC - Level One is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser3)"), "Message from Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser3"), "These are Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Complete by Appraiser (Automation Appraiser3)"), "Inspection Complete by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspected on"), "Inspected on is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Scheduled by Appraiser (Automation Appraiser3)"), "Inspection Scheduled by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection date is"), "Inspection date is is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFAMC)"), "Message from Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("This is a test message from EVFAMC on the XSite"), "This is a test message from EVFAMC on the XSite is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by AMC ("+amcCompany+")"), "Order Changed by AMC ("+amcCompany+") is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are EVFLender change fee comments"), "These are EVFLender change fee comments is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed by Client (Automation EVFAMC)"), "Vendor due date changed by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFLender change due date comments"), "These are EVFLender change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Fee Changed by Client (Automation EVFAMC)"), "Appraisal Fee Changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraisal fee changed from $350 to $525."), "Appraisal fee changed from $350 to $525. is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFAMC change fee comments"), "These are EVFAMC change fee comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed by Client (Automation EVFAMC)"), "Vendor due date changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the audit trail");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser3)"), "Message from Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Apostrophes License.pdf)"), "Document Uploaded from Appraiser (Automation Appraiser3) (Apostrophes License.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Test PDF_1.pdf)"), "Document Uploaded from Appraiser (Automation Appraiser3) (Test PDF_1.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Appraiser (Automation Appraiser3)"), "Resumed by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Appraiser (Automation Appraiser3)"), "Delayed by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order accepted by Appraiser (Automation Appraiser3) and In Progress"), "Order accepted by Appraiser (Automation Appraiser3) and In Progress is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation EVFAMC)"), "Comment - Action Required by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFAMC)"), "Message from Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(!history.contains("Document Uploaded from Client (Automation EVFAMC) (Test PDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC) (Test PDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Client (Automation EVFAMC)"), "Delayed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Client (Automation EVFAMC)"), "On Hold by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser3"), "Awaiting acceptance by Automation Appraiser3 is missing from the audit trail");
		
		// Verify new Due Date
		Assert.assertTrue(VOrderDetails.orderInformation_txt(driver).getText().contains(StoredVariables.getorderDueDateShort().get()), "New Due Date is not correct");
		
		// Verify fee
		Assert.assertTrue(VOrderDetails.orderInformation_txt(driver).getText().contains("$525"), "Fee should not have updated");
		
		// Get comments
		additionalComments = VOrderDetails.additionalComments_txt(driver).getText();
		
		// Verify both VMP and MN comments are displayed
		Assert.assertTrue(additionalComments.contains("These are edited comments by EVFAMC"), "Additional Comments section is missing info");
		
		// View Order Details
		vendors.verifyOrderDetails(driver);
		
		// Verify Document is in Documents
		documentText = VOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Report PDF"), "Report PDF did not sync to Vendors");
		Assert.assertTrue(documentText.contains("MISMO XML"), "MISMO XML did not sync to Vendors");
		Assert.assertTrue(documentText.contains("Other"), "Other did not sync to Vendors");
		Assert.assertTrue(documentText.contains("Market Information"), "Market Information did not sync to Vendors");
		Assert.assertTrue(!documentText.contains("Sales Contract"), "Sales Contract should not sync to Vendors");

		// Log in to Secure
		secure.login(driver, "EVFAMC", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, orderNumberAMC, "Tracking number");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("Appraisal Submission to FNM Not Successful"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, awsAccountsID + "-" + orderNumberAMC);
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Verify order details0
		secure.verifyResidentialAppraisalOrderDetails(driver);
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify the history
		Assert.assertTrue(history.contains("History (In QC - Level One)"), "History (In QC - Level One) is missing from the order information"); //changed from Revision Needed
		Assert.assertTrue(history.contains("Revision Request Cancelled by Client (Automation EVFAMC)"), "Revision Request Cancelled by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are cancel revision request notes from OriginatorEVF"), "These are cancel revision request notes from OriginatorEVF is missing from the order information");
		Assert.assertTrue(history.contains("Revision Needed by Client (Automation EVFAMC)"), "Revision Needed by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are request revision notes from EVFAMC on Secure"), "These are request revision notes from EVFAMC on Secure is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Submission to FNM Not Successful"), "Appraisal Submission to FNM Not Successful is missing from the order information");
		Assert.assertTrue(history.contains("View FNM SSR"), "View FNM SSR is missing from the order information");
		Assert.assertTrue(history.contains("UCDP Document File ID Updated by Client (Automation EVFAMC)"), "UCDP Document File ID Updated by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("Note Added (Automation EVFAMC)"), "Note Added (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are internal notes from EVFAMC on Secure"), "These are internal notes from EVFAMC on Secure is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Submitted to FNM via UCDP by Client (Automation EVFAMC)"), "Appraisal Submitted to FNM via UCDP by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("Order delivered by Appraiser (Automation Appraiser3) and is now In QC - Level One"), "Order delivered by Appraiser (Automation Appraiser3) and is now In QC - Level One is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser3)"), "Message from Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser3"), "These are Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Complete by Appraiser (Automation Appraiser3)"), "Inspection Complete by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspected on"), "Inspected on is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Scheduled by Appraiser (Automation Appraiser3)"), "Inspection Scheduled by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection date is"), "Inspection date is is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFAMC)"), "Message from Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("This is a test message from EVFAMC on the XSite"), "This is a test message from EVFAMC on the XSite is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by Client (Automation EVFAMC)"), "Order Changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are EVFLender change fee comments"), "These are EVFLender change fee comments is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed by Client (Automation EVFAMC)"), "Vendor due date changed by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFLender change due date comments"), "These are EVFLender change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Fee Changed by Client (Automation EVFAMC)"), "Appraisal Fee Changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraisal fee changed from $350 to $525."), "Appraisal fee changed from $350 to $525. is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFAMC change fee comments"), "These are EVFAMC change fee comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed by Client (Automation EVFAMC)"), "Vendor due date changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the audit trail");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser3)"), "Message from Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Apostrophes License.pdf)"), "Document Uploaded from Vendor (Automation Appraiser3) (Apostrophes License.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Test PDF_1.pdf)"), "Document Uploaded from Vendor (Automation Appraiser3) (Test PDF_1.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Appraiser (Automation Appraiser3)"), "Resumed by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Appraiser (Automation Appraiser3)"), "Delayed by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order accepted by Appraiser (Automation Appraiser3) and In Progress"), "Order accepted by Appraiser (Automation Appraiser3) and In Progress is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation EVFAMC)"), "Comment - Action Required by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFAMC)"), "Message from Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(!history.contains("Document Uploaded from Client (Automation EVFAMC) (Test PDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC) (Test PDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Client (Automation EVFAMC)"), "Delayed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Client (Automation EVFAMC)"), "On Hold by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser3"), "Awaiting acceptance by Automation Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Reassigned by Client (Automation EVFAMC) to Automation Appraiser3"), "Reassigned by Client (Automation EVFAMC) to Automation Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by Client (Automation EVFAMC)"), "Order Changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("To View Change History:"), "To View Change History: is missing from the audit trail");
		Assert.assertTrue(history.contains("Requires assignment"), "Requires assignment is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance"), "Awaiting acceptance is missing from the audit trail");
		
		// Verify new Due Date
		Assert.assertTrue(SOrderDetails.orderDue_txt(driver).getText().contains(StoredVariables.getorderDueDateShort().get()), "New Due Date is not correct");
		
		// Verify fee
		Assert.assertTrue(SOrderDetails.assignmentInformation_txt(driver).getText().contains("525"), "Fee should not have updated");
		
		// Verify Other Document is in Documents
		documentText = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Report PDF"), "Report PDF did not sync to Secure");
		Assert.assertTrue(documentText.contains("MISMO XML"), "MISMO XML did not sync to Secure");
		Assert.assertTrue(documentText.contains("FNM SSR"), "FNM SSR did not sync to Secure");
		Assert.assertTrue(documentText.contains("Other"), "Other did not sync to Secure");
		Assert.assertTrue(documentText.contains("Market Information"), "Market Information did not sync to Secure");
		Assert.assertTrue(!documentText.contains("Sales Contract"), "Sales Contract should not sync to Secure");

		// Log in to Secure
		secure.login(driver, "EVFAMC", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, orderNumberAMC, "Tracking number");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("Appraisal Submission to FNM Not Successful"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, awsAccountsID + "-" + orderNumberAMC);
		
		// Wait for history
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Click Set status
		perform.clickInTable_Contains(driver, "Set status");
		
		perform.waitForText(driver, SNewOrder.setStatus_txt(driver), "Request revision");
		
		// Click Request revision
		perform.click(driver,SOrderDetails.requestRevision_btn(driver));
		
		// Wait for Overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SSetOrderStatus.ok_btn(), "id");
		
		// Enter notes
		perform.type(driver,SSetOrderStatus.notes_txtbx(driver), "These are more request revision notes from EVFAMC on Secure");
		
		// Check the Update status on VMP XSite checkbox
		if (!SSetOrderStatus.updateStatusOnVMPXSite_chkbx(driver).isSelected())
		{
			perform.click(driver,SSetOrderStatus.updateStatusOnVMPXSite_chkbx(driver));
		}
		
		// Click OK button
		perform.click(driver,SSetOrderStatus.ok_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Wait for history
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify the history
		Assert.assertTrue(history.contains("History (Revision Needed)"), "History (Revision Needed) is missing from the order information");
		Assert.assertTrue(history.contains("These are more request revision notes from EVFAMC on Secure"), "These are more request revision notes from EVFAMC on Secure is missing from the order information");
		Assert.assertTrue(history.contains("Revision Request Cancelled by Client (Automation EVFAMC)"), "Revision Request Cancelled by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("Revision Needed by Client (Automation EVFAMC)"), "Revision Needed by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are request revision notes from EVFAMC on Secure"), "These are request revision notes from EVFAMC on Secure is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Submission to FNM Not Successful"), "Appraisal Submission to FNM Not Successful is missing from the order information");
		Assert.assertTrue(history.contains("View FNM SSR"), "View FNM SSR is missing from the order information");
		Assert.assertTrue(history.contains("UCDP Document File ID Updated by Client (Automation EVFAMC)"), "UCDP Document File ID Updated by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("Note Added (Automation EVFAMC)"), "Note Added (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are internal notes from EVFAMC on Secure"), "These are internal notes from EVFAMC on Secure is missing from the order information");
		Assert.assertTrue(history.contains("Order delivered by Appraiser (Automation Appraiser3) and is now In QC - Level One"), "Order delivered by Appraiser (Automation Appraiser3) and is now In QC - Level One is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser3)"), "Message from Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser3"), "These are Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Complete by Appraiser (Automation Appraiser3)"), "Inspection Complete by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspected on"), "Inspected on is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Scheduled by Appraiser (Automation Appraiser3)"), "Inspection Scheduled by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection date is"), "Inspection date is is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFAMC)"), "Message from Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("This is a test message from EVFAMC on the XSite"), "This is a test message from EVFAMC on the XSite is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by Client (Automation EVFAMC)"), "Order Changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are EVFLender change fee comments"), "These are EVFLender change fee comments is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed by Client (Automation EVFAMC)"), "Vendor due date changed by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFLender change due date comments"), "These are EVFLender change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Fee Changed by Client (Automation EVFAMC)"), "Appraisal Fee Changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraisal fee changed from $350 to $525."), "Appraisal fee changed from $350 to $525. is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFAMC change fee comments"), "These are EVFAMC change fee comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed by Client (Automation EVFAMC)"), "Vendor due date changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the audit trail");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser3)"), "Message from Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Apostrophes License.pdf)"), "Document Uploaded from Vendor (Automation Appraiser3) (Apostrophes License.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Test PDF_1.pdf)"), "Document Uploaded from Vendor (Automation Appraiser3) (Test PDF_1.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Appraiser (Automation Appraiser3)"), "Resumed by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Appraiser (Automation Appraiser3)"), "Delayed by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order accepted by Appraiser (Automation Appraiser3) and In Progress"), "Order accepted by Appraiser (Automation Appraiser3) and In Progress is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation EVFAMC)"), "Comment - Action Required by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFAMC)"), "Message from Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(!history.contains("Document Uploaded from Client (Automation EVFAMC) (Test PDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC) (Test PDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Client (Automation EVFAMC)"), "Delayed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Client (Automation EVFAMC)"), "On Hold by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser3"), "Awaiting acceptance by Automation Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Reassigned by Client (Automation EVFAMC) to Automation Appraiser3"), "Reassigned by Client (Automation EVFAMC) to Automation Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by Client (Automation EVFAMC)"), "Order Changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("To View Change History:"), "To View Change History: is missing from the audit trail");
		Assert.assertTrue(history.contains("Requires assignment"), "Requires assignment is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance"), "Awaiting acceptance is missing from the audit trail");
		
		// Verify new Due Date
		Assert.assertTrue(SOrderDetails.orderDue_txt(driver).getText().contains(StoredVariables.getorderDueDateShort().get()), "New Due Date is not correct");
		
		// Verify fee
		Assert.assertTrue(SOrderDetails.assignmentInformation_txt(driver).getText().contains("525"), "Fee should not have updated");
		
		// Verify Other Document is in Documents
		documentText = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Report PDF"), "Report PDF did not sync to Secure");
		Assert.assertTrue(documentText.contains("MISMO XML"), "MISMO XML did not sync to Secure");
		Assert.assertTrue(documentText.contains("FNM SSR"), "FNM SSR did not sync to Secure");
		Assert.assertTrue(documentText.contains("Other"), "Other did not sync to Secure");
		Assert.assertTrue(documentText.contains("Market Information"), "Market Information did not sync to Secure");
		Assert.assertTrue(!documentText.contains("Sales Contract"), "Sales Contract should not sync to Secure");
		
		// Click Preferences
		perform.click(driver,SOrders.preferences_btn(driver));
		
		// Wait for VMP XSites button
		perform.waitForElementToBeClickable(driver, SPreferences.vmpXSites_btn(), "cssSelector");
		
		// Click VMP XSites button
		perform.click(driver,SPreferences.vmpXSites_btn(driver));
		
		// Wait for Configure Status Mapping link
		perform.waitForElementToBeClickable(driver, SVMPXSites.configureStatusMapping_lnk(), "id");
		
		// Click Configure Status Mapping link
		perform.click(driver,SVMPXSites.configureStatusMapping_lnk(driver));
		
		// Wait for 
		perform.waitForElementToBeClickable(driver, SVMPXSites.amcFirm_btn(driver));
		
		// Uncheck Pending Quality Review
		secure.setStatusMapping(driver, "Pending Quality Review", "none");
		
		// Uncheck Message
		secure.setStatusMapping(driver, "Message", "none");
		
		// Click Save
		perform.click(driver,SVMPXSites.save_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Log in to Vendors
		vendors.login(driver, "Appraiser3", StoredVariables.getpassword().get());
		
		// Search for order
		vendors.findOrder(driver, orderNumberAMC, "Tracking Number");
		
		// Verify order status
		Assert.assertTrue(VOrders.ordersGrid_txt(driver).getText().contains("Revision Needed"), "The order is not in the correct status");
		
		// Click on the order from the orders grid
		perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, VOrderDetails.sendMessage_btn(), "cssSelector");
		
		Thread.sleep(1000);
		
		// Complete the order using the HTTP Post
		vendors.completeOrderByHTTPPost(driver, "Appraiser3", StoredVariables.getpassword().get(), StoredVariables.getloanID().get(), "Complete.xml");
		
		// Get order information text
		history = VOrderDetails.orderInformation_txt(driver).getText();
		
		// Verify audit trail
		Assert.assertTrue(history.contains("History (Revision Needed)"), "History (Revision Needed) is missing from the order information");
		Assert.assertTrue(!history.contains("Revised Report delivered by Appraiser (Automation Appraiser3)"), "Revised Report delivered by Appraiser (Automation Appraiser3) is missing from the order information");
		Assert.assertTrue(!history.contains("This is another Message to the client for completing the order from Appraiser3 on Vendors"), "This is another Message to the client for completing the order from Appraiser3 on Vendors is missing from the order information");
		Assert.assertTrue(history.contains("Revision Needed by Client (Automation EVFAMC)"), "Revision Needed by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are more request revision notes from EVFAMC on Secure"), "These are more request revision notes from EVFAMC on Secure is missing from the order information");
		Assert.assertTrue(history.contains("Revision Request Cancelled by Client (Automation EVFAMC)"), "Revision Request Cancelled by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are cancel revision request notes from OriginatorEVF"), "These are cancel revision request notes from OriginatorEVF is missing from the order information");
		Assert.assertTrue(history.contains("Revision Needed by Client (Automation EVFAMC)"), "Revision Needed by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are request revision notes from EVFAMC on Secure"), "These are request revision notes from EVFAMC on Secure is missing from the order information");
		Assert.assertTrue(history.contains("Order delivered by Appraiser (Automation Appraiser3) and is now In QC - Level One"), "Order delivered by Appraiser (Automation Appraiser3) and is now In QC - Level One is missing from the order information");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser3)"), "Message from Appraiser (Automation Appraiser3) is missing from the order information");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser3"), "These are Message notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Inspection Complete by Appraiser (Automation Appraiser3)"), "Inspection Complete by Appraiser (Automation Appraiser3) is missing from the order information");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Inspection Scheduled by Appraiser (Automation Appraiser3)"), "Inspection Scheduled by Appraiser (Automation Appraiser3) is missing from the order information");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFAMC)"), "Message from Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("This is a test message from EVFAMC on the XSite"), "This is a test message from EVFAMC on the XSite is missing from the order information");
		Assert.assertTrue(history.contains("Order Changed by AMC ("+amcCompany+")"), "Order Changed by AMC ("+amcCompany+") is missing from the order information");
		Assert.assertTrue(!history.contains("These are EVFLender change fee comments"), "These are EVFLender change fee comments is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed by Client (Automation EVFAMC)"), "Vendor due date changed by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFLender change due date comments"), "These are EVFLender change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Fee Changed by Client (Automation EVFAMC)"), "Appraisal Fee Changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraisal fee changed from $350 to $525."), "Appraisal fee changed from $350 to $525. is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFAMC change fee comments"), "These are EVFAMC change fee comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed by Client (Automation EVFAMC)"), "Vendor due date changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the audit trail");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser3)"), "Message from Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Apostrophes License.pdf)"), "Document Uploaded from Appraiser (Automation Appraiser3) (Apostrophes License.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Test PDF_1.pdf)"), "Document Uploaded from Appraiser (Automation Appraiser3) (Test PDF_1.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Appraiser (Automation Appraiser3)"), "Resumed by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Appraiser (Automation Appraiser3)"), "Delayed by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order accepted by Appraiser (Automation Appraiser3) and In Progress"), "Order accepted by Appraiser (Automation Appraiser3) and In Progress is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation EVFAMC)"), "Comment - Action Required by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFAMC)"), "Message from Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(!history.contains("Document Uploaded from Client (Automation EVFAMC) (Test PDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC) (Test PDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Client (Automation EVFAMC)"), "Delayed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Client (Automation EVFAMC)"), "On Hold by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser3"), "Awaiting acceptance by Automation Appraiser3 is missing from the audit trail");
		
		// Verify new Due Date
		Assert.assertTrue(VOrderDetails.orderInformation_txt(driver).getText().contains(StoredVariables.getorderDueDateShort().get()), "New Due Date is not correct");
		
		// Verify fee
		Assert.assertTrue(VOrderDetails.orderInformation_txt(driver).getText().contains("$525"), "Fee should not have updated");
		
		// Get comments
		additionalComments = VOrderDetails.additionalComments_txt(driver).getText();
		
		// Verify both VMP and MN comments are displayed
		Assert.assertTrue(additionalComments.contains("These are edited comments by EVFAMC"), "Additional Comments section is missing info");
		
		// View Order Details
		vendors.verifyOrderDetails(driver);
		
		// Verify Document is in Documents
		documentText = VOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Other"), "Other did not sync to Vendors");
		Assert.assertTrue(documentText.contains("Market Information"), "Market Information did not sync to Vendors");
		Assert.assertTrue(!documentText.contains("Sales Contract"), "Sales Contract should not sync to Vendors");
		Assert.assertTrue(documentText.contains("Order Documents"), "Order Documents is not showing in the Order Documents");
		Assert.assertTrue(documentText.contains("Report PDF"), "Report PDF is not showing in the Order Documents");
		Assert.assertTrue(documentText.contains("Completed Report (Current)"), "Completed Report (Current) is not showing in the Order Documents");
		Assert.assertTrue(documentText.contains("Completed Report"), "Completed Report is not showing in the Order Documents");
		Assert.assertTrue(!documentText.contains("Previously Completed Reports"), "Previously Completed Reports is not showing in the Order Documents");
		Assert.assertTrue(documentText.contains(StoredVariables.gettodaysDateLong().get()), "The Date Uploaded is not showing in the Order Documents");
		
		// Click Report PDF
		perform.clickInTable_Contains(driver, "Report PDF");
		
		// Wait for text
		perform.waitForText(driver, VOrderDetails.documents_txt(driver), "Automation Appraiser3");
		documentText = VOrderDetails.documents_txt(driver).getText();
		
		// Verify Uploaded By and Document Name
		Assert.assertTrue(documentText.contains("Test PDF.pdf"), "Test PDF.pdf is not showing as the Document Name in Order Documents");
		Assert.assertTrue(documentText.contains("Automation Appraiser3"), "Automation Appraiser3 is not showing as the Document Name in Order Documents");
		
		// Click MISMO XML
		perform.clickInTable_Contains(driver, "MISMO XML");
		
		Thread.sleep(1500);
		
		// Wait for text
		perform.waitForText(driver, VOrderDetails.documents_txt(driver), "Test PDF.xml");
		documentText = VOrderDetails.documents_txt(driver).getText();
		
		// Verify Uploaded By and Document Name
		Assert.assertTrue(documentText.contains("Test PDF.xml"), "Test PDF.xml is not showing as the Document Name in Order Documents");
		Assert.assertTrue(documentText.contains("Automation Appraiser3"), "Automation Appraiser3 is not showing as the Document Name in Order Documents");
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, VOrderDetails.sendMessage_btn(), "cssSelector");
		
		// Click Message
		perform.click(driver,VOrderDetails.sendMessage_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for OK button to be clickable
		perform.waitForElementToBeClickable(driver, VOrderDetails.sendMessageOk_btn(), "cssSelector");
		
		// Add notes
		perform.type(driver,VOrderDetails.sendMessageNotes_txtbx(driver), "These are even more additional Message notes from Appraiser3 testing unchecked sync status");
		
		// Click Send button
		perform.click(driver,VOrderDetails.sendMessageOk_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);

		// View XSite order
		secure.viewXSiteOrderFromSecure(driver, "EVFLender", StoredVariables.getpassword().get(), StoredVariables.getloanID().get());
		
		// Get history text
		perform.waitForElementToBeVisible(driver, XOrders.toolbar(), "id");
		history = XOrders.history_txt(driver).getText();
		address = StoredVariables.getpropertyInformationAddress().get() + " " + StoredVariables.getpropertyInformationCity().get() + ", " + StoredVariables.getpropertyInformationStateAbbr().get() + " " + StoredVariables.getpropertyInformationZip().get();
		
		// Wait for db to update
		perform.waitForDBUpdateForHistoryTextInVMPXSite(driver, "These are more request revision notes from EVFAMC on Secure");
		
		// Recapture the text from the history
		history = XOrders.history_txt(driver).getText();
		
		// Verify the history
		Assert.assertTrue(history.contains("History (Revision Needed)"), "History (Revision Needed) is missing from the order information");
		Assert.assertTrue(!history.contains("These are even more additional Message notes from Appraiser3 testing unchecked sync status"), "These are even more additional Message notes from Appraiser3 testing unchecked sync status is missing from the order information");
		Assert.assertTrue(history.contains("These are more request revision notes from EVFAMC on Secure"), "These are more request revision notes from EVFAMC on Secure is missing from the order information");
		Assert.assertTrue(history.contains("Revision Request Cancelled (Automation OriginatorEVF)"), "Revision Request Cancelled (Automation OriginatorEVF) is missing from the order information");
		Assert.assertTrue(history.contains("These are cancel revision request notes from OriginatorEVF"), "These are cancel revision request notes from OriginatorEVF is missing from the order information");
		Assert.assertTrue(history.contains("Revision Needed (Automation EVFLender)"), "Revision Needed (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are request revision notes from EVFAMC on Secure"), "These are request revision notes from EVFAMC on Secure is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Submission to FNM Not Successful"), "Appraisal Submission to FNM Not Successful is missing from the order information");
		Assert.assertTrue(history.contains("View FNM SSR"), "View FNM SSR is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Submitted to FNM via UCDP"), "Appraisal Submitted to FNM via UCDP is missing from the order information");
		Assert.assertTrue(history.contains("UCDP Document File ID Updated (Automation EVFLender)"), "UCDP Document File ID Updated (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(!history.contains("Pending Quality Review (Automation EVFLender)"), "Order delivered by Vendor (Automation EVFAMC) and is now Pending Quality Review is missing from the order information");
		Assert.assertTrue(history.contains("Message (Automation EVFLender)"), "Message (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser3"), "These are Message notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Inspection Complete (Automation EVFLender)"), "Inspection Complete (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("Inspected on"), "Inspected on is missing from the order information");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Inspection Scheduled (Automation EVFLender)"), "Inspection Scheduled (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("Inspection date is"), "Inspection date is is missing from the order information");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Comment - Action Required (Automation EVFLender)"), "Comment - Action Required (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("This is an action required message by EVFAMC"), "This is an action required message by EVFAMC is missing from the order information");
		Assert.assertTrue(history.contains("Order Changed (Automation EVFLender)"), "Order Changed (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("Message (Automation EVFLender)"), "Message (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("This is a test message from EVFAMC on the XSite"), "This is a test message from EVFAMC on the XSite is missing from the order information");
		Assert.assertTrue(!history.contains("These are EVFLender change fee comments"), "These are EVFLender change fee comments is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFLender change due date comments"), "These are EVFLender change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed (Automation EVFLender)"), "Vendor due date changed (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the order information");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Message (Automation EVFLender)"), "Message (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Document Uploaded (Automation EVFLender) (Test PDF_1.pdf)"), "Document Uploaded (Automation EVFLender) (Test PDF_1.pdf) is missing from the order information");
		Assert.assertTrue(history.contains("Resumed (Automation EVFLender)"), "Resumed (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Delayed (Automation EVFLender)"), "Delayed (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Vendor Accepted Assignment (Automation EVFLender)"), "Vendor Accepted Assignment (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the order information");
		Assert.assertTrue(history.contains("Resumed (Automation EVFLender)"), "Resumed (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required (Automation OriginatorEVF)"), "Comment - Action Required (Automation OriginatorEVF) is missing from the order information");
		Assert.assertTrue(history.contains("Comment - Action Required for " + address), "Comment - Action Required for " + address + " is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message (Automation OriginatorEVF)"), "Message (Automation OriginatorEVF) is missing from the audit trail");
		Assert.assertTrue(history.contains("Order message for " + address), "Order message for " + address + " is missing from the order information");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded (Automation OriginatorEVF) (TestPDF.pdf)"), "Document Uploaded (Automation OriginatorEVF) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded (Automation OriginatorEVF) (Test PDF.pdf)"), "Document Uploaded (Automation OriginatorEVF) (Test PDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed (Automation OriginatorEVF)"), "Delayed (Automation OriginatorEVF) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed (Automation OriginatorEVF)"), "Resumed (Automation OriginatorEVF) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold (Automation OriginatorEVF)"), "On Hold (Automation OriginatorEVF) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the order information");
		Assert.assertTrue(history.contains("In Progress (Automation OriginatorEVF)"), "In Progress (Automation OriginatorEVF) is missing from the audit trail");
		
		// Verify order details
		perform.verifyXSiteOrderDetailsForLender(driver);
		
		// Verify documents
		documentsText = XOrders.documents_txt(driver).getText();
		Assert.assertTrue(documentsText.contains("Other"), "Other document is missing from the documents section of the XSite");
		Assert.assertTrue(documentsText.contains("TestPDF"), "TestPDF document is missing from the documents section of the XSite");
		Assert.assertTrue(documentsText.contains("Test PDF_1"), "TestPDF document is missing from the documents section of the XSite");
		Assert.assertTrue(documentsText.contains("Sales Contract"), "Sales Contract document is missing from the documents section of the XSite");
		Assert.assertTrue(documentsText.contains("Test PDF"), "Test PDF document is missing from the documents section of the XSite");
		Assert.assertTrue(!documentsText.contains("Apostrophes License"), "Apostrophes License should not sync to the XSite");
		Assert.assertTrue(!documentsText.contains("No UAD Hard Stops.xml"), "No UAD Hard Stops.xml should not sync to the XSite");
		
		// Verify comments
		comments = XOrders.comments_txt(driver).getText();
		Assert.assertTrue(comments.contains("These are test additional comments"), "Additional Comments section is missing info");
		
		// Verify new Due Date
		Assert.assertTrue(XOrders.dueDate_txt(driver).getText().equals(StoredVariables.getorderDueDateShort().get()), "New Due Date is not correct - It is: " + XOrders.dueDate_txt(driver).getText() + ", but should be: " + StoredVariables.getorderDueDateShort().get());
		
		// Verify fee
		Assert.assertTrue(XOrders.fee_txt(driver).getText().equals("$350.00"), "Fee should not update");
		
		// Close XSite order
		perform.closeNewWindow(driver);
		
		// Login to VMP Client Portal
		vmp.login(driver, "EVFLender", "OriginatorEVF", StoredVariables.getpassword().get());
		
		// Search for order
		vmp.findOrder(driver, StoredVariables.getloanIDVMP().get(), "Tracking #");
		
		// Wait for db to update order status on Secure
		vmp.waitForDBUpdateForOrderStatus(driver, "Revision Needed");
		
		// Verify Order Status
		Assert.assertTrue(VMPOrders.orderStatus_txt(driver).getText().equals("Revision Needed"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());
		
		Thread.sleep(1500);
		
		// Wait for Edit Property Contacts link
		perform.waitForElementToBeClickable(driver, VMPAppraisalOrderDetails.editPropertyContacts_lnk(), "id");
		
		// Verify the audit trail
		history = VMPAppraisalOrderDetails.history_txt(driver).getText();

		Assert.assertTrue(!history.contains("These are even more additional Message notes from Appraiser3 testing unchecked sync status"), "These are even more additional Message notes from Appraiser3 testing unchecked sync status is missing from the order information");
		Assert.assertTrue(history.contains("Revision Needed by Automation EVFLender"), "Revision Needed by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are more request revision notes from EVFAMC on Secure"), "These are more request revision notes from EVFAMC on Secure is missing from the audit trail");
		Assert.assertTrue(history.contains("Revision Request Cancelled by Automation OriginatorEVF"), "Revision Request Cancelled by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are cancel revision request notes from OriginatorEVF"), "These are cancel revision request notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Revision Needed by Automation EVFLender"), "Revision Needed by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are request revision notes from EVFAMC on Secure"), "These are request revision notes from EVFAMC on Secure is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraisal Submission to FNM Not Successful by Automation EVFLender"), "Appraisal Submission to FNM Not Successful by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("View FNM SSR"), "View FNM SSR is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraisal Submitted to FNM via UCDP by Automation EVFLender"), "Appraisal Submitted to FNM via UCDP by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("UCDP Document File ID Updated by Automation EVFLender"), "UCDP Document File ID Updated by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(!history.contains("Pending Quality Review by Automation EVFLender"), "Pending Quality Review by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation EVFLender"), "Message by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser3"), "These are Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Complete by Automation EVFLender"), "Inspection Complete by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspected on"), "Inspected on is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Scheduled by Automation EVFLender"), "Inspection Scheduled by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection date is"), "Inspection date is is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Automation EVFLender"), "Comment - Action Required by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("This is an action required message by EVFAMC"), "This is an action required message by EVFAMC is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by Automation EVFLender"), "Order Changed by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by Automation EVFLender"), "Order Changed by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation EVFLender"), "Message by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("This is a test message from EVFAMC on the XSite"), "This is a test message from EVFAMC on the XSite is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are EVFLender change fee comments"), "These are EVFLender change fee comments is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed by Automation EVFLender"), "Vendor due date changed by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the audit trail");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFLender change due date comments"), "These are EVFLender change due date comments is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation EVFLender"), "Message by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation EVFLender"), "Document Uploaded by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("Other"), "Other is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF_1.pdf"), "Test PDF_1.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation EVFLender"), "Resumed by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation EVFLender"), "Delayed by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraiser Accepted Assignment by Automation EVFLender"), "Appraiser Accepted Assignment by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorEVF"), "Resumed by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Automation OriginatorEVF"), "Comment - Action Required by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation OriginatorEVF"), "Message by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorEVF"), "Document Uploaded by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Other"), "Other is missing from the audit trail");
		Assert.assertTrue(history.contains("TestPDF.pdf"), "TestPDF.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorEVF"), "Document Uploaded by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Sales Contract"), "Sales Contract is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF.pdf"), "Test PDF.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation OriginatorEVF"), "Delayed by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorEVF"), "Resumed by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Automation OriginatorEVF"), "On Hold by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("In Progress by Automation OriginatorEVF"), "In Progress by Automation OriginatorEVF is missing from the audit trail");
		
		// Verify new Due Date
		Assert.assertTrue(VMPAppraisalOrderDetails.orderDetails_txt(driver).getText().contains(StoredVariables.getorderDueDateShort().get()), "New Due Date is not correct");
		
		// Verify fee
		Assert.assertTrue(VMPAppraisalOrderDetails.orderDetails_txt(driver).getText().contains("$350"), "Fee should not update");
		
		// Verify the order details
		vmp.verifyAppraisalOrderDetails(driver);
		
		// Verify Document is in Documents
		documentText = VMPAppraisalOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Other"), "Other document is not displayed in VMP Client Portal");
		Assert.assertTrue(documentText.contains("Sales Contract"), "Sales Contract did not sync to VMP Client Portal");
		Assert.assertTrue(!documentText.contains("Market Information"), "Market Information should not sync to VMP Client Portal");
		Assert.assertTrue(!documentText.contains("MISMO XML"), "MISMO XML should not sync to VMP Client Portal");
		Assert.assertTrue(!documentText.contains("Report PDF"), "Report PDF should not sync to VMP Client Portal");
		
		// Click on Sales Contract
		perform.clickInTable_Contains(driver, "Sales Contract");
		
		// Wait for text to update
		perform.waitForText(driver, VMPAppraisalOrderDetails.documents_txt(driver), "Test PDF.pdf");
		documentText = VMPAppraisalOrderDetails.documents_txt(driver).getText();
		
		// Verify file name and uploaded by
		Assert.assertTrue(documentText.contains("Test PDF.pdf"), "Document name is incorrect in Documents");
		Assert.assertTrue(documentText.contains("Automation OriginatorEVF"), "Uploaded By is incorrect in Documents");
		
		// Create boolean for both Other documents
		originator = false;
		lender = false;
		
		// Get Number Of Other documents
		docs = driver.findElements(By.xpath("//td[text()='Other']"));
		for (WebElement doc: docs)
		{
			
			// Click first Other document
			perform.click(driver,doc);
			
			Thread.sleep(3000);
			
			documentText = VMPAppraisalOrderDetails.documents_txt(driver).getText();
			
			// Wait for text
			perform.waitForText(driver, VMPAppraisalOrderDetails.documents_txt(driver), "Automation");
			
			if (documentText.contains("Automation OriginatorEVF") && originator == false)
			{
				// Verify Uploaded By and Document Name
				Assert.assertTrue(documentText.contains("TestPDF.pdf"), "TestPDF.pdf is not showing as the Document Name in Order Documents");
				originator = true;
			}
			
			else if (documentText.contains("Automation EVFLender") && lender == false)
			{
				// Verify Uploaded By and Document Name
				Assert.assertTrue(documentText.contains("Test PDF_1.pdf"), "Test PDF_1.pdf is not showing as the Document Name in Order Documents");
				lender = true;
			}
				
		} // end for loop
		
		Assert.assertTrue(originator==true, "The Other document uploaded by Automation OriginatorEVF is not displaying");
		Assert.assertTrue(lender==true, "The Other document uploaded by Automation EVFLender is not displaying");
		
		// Log in to Secure
		secure.login(driver, "EVFLender", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, StoredVariables.getloanID().get(), "Tracking number");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("Revision Needed"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, awsAccountsID + "-" + StoredVariables.getloanID().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Verify order details
		secure.verifyResidentialAppraisalOrderDetails(driver);
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify the history
		Assert.assertTrue(history.contains("History (Revision Needed)"), "History (Revision Needed) is missing from the order information");
		Assert.assertTrue(!history.contains("These are even more additional Message notes from Appraiser3 testing unchecked sync status"), "These are even more additional Message notes from Appraiser3 testing unchecked sync status is missing from the order information");
		Assert.assertTrue(history.contains("Revision Needed by AMC (" + amcCompany + ")"), "Revision Needed by Vendor (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are more request revision notes from EVFAMC on Secure"), "These are more request revision notes from EVFAMC on Secure is missing from the order information");
		Assert.assertTrue(history.contains("Revision Request Cancelled by Client (Automation EVFLender)"), "Revision Request Cancelled by Client (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are cancel revision request notes from OriginatorEVF"), "These are cancel revision request notes from OriginatorEVF is missing from the order information");
		Assert.assertTrue(history.contains("Revision Needed by AMC (" + amcCompany + ")"), "Revision Needed by Vendor (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are request revision notes from EVFAMC on Secure"), "These are request revision notes from EVFAMC on Secure is missing from the order information");
		Assert.assertTrue(history.contains("View FNM SSR"), "View FNM SSR is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Submission to FNM Not Successful"), "Appraisal Submission to FNM Not Successful is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Submitted to FNM via UCDP by AMC (" + amcCompany + ")"), "Appraisal Submitted to FNM via UCDP by Vendor (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("UCDP Document File ID Updated by AMC (" + amcCompany + ")"), "UCDP Document File ID Updated by Vendor (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("Order delivered by AMC (" + amcCompany + ") and is now Pending Quality Review"), "Order delivered by Vendor (Automation EVFAMC) and is now Pending Quality Review is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from AMC (" + amcCompany + ")"), "Message from Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser3"), "These are Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Complete by AMC (" + amcCompany + ")"), "Inspection Complete by Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspected on"), "Inspected on is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Scheduled by AMC (" + amcCompany + ")"), "Inspection Scheduled by Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection date is"), "Inspection date is is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by AMC (" + amcCompany + ")"), "Comment - Action Required by Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("This is an action required message by EVFAMC"), "This is an action required message by EVFAMC is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from AMC (" + amcCompany + ")"), "Message from Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("This is a test message from EVFAMC on the XSite"), "This is a test message from EVFAMC on the XSite is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by AMC (" + amcCompany + ")"), "Order Changed by Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraisal Fee Changed by Client (Automation EVFLender)"), "Appraisal Fee Changed by Client (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal fee changed from $0 to $673"), "Appraisal fee changed from $0 to $673 is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFLender change fee comment"), "These are EVFLender change fee comment is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed by Client (Automation EVFLender)"), "Vendor due date changed by Client (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the order information");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFLender change due date comments"), "These are EVFLender change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed by AMC (" + amcCompany + ")"), "Vendor due date changed by Vendor (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the order information");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Message from AMC (" + amcCompany + ")"), "Message from Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from AMC (" + amcCompany + ") (Test PDF_1.pdf)"), "Document Uploaded from Vendor (Automation EVFAMC) (Test PDF_1.pdf)�is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by AMC (" + amcCompany + ")"), "Resumed by Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by AMC (" + amcCompany + ")"), "Delayed by Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraiser Accepted assignment"), "Appraiser Accepted assignment is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFLender)"), "Resumed by Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation EVFLender)"), "Comment - Action Required by Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFLender)"), "Message from Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFLender) (TestPDF.pdf)"), "Document Uploaded from Client (Automation EVFLender) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFLender) (Test PDF.pdf)"), "Document Uploaded from Client (Automation EVFLender) (Test PDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Client (Automation EVFLender)"), "Delayed by Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFLender)"), "Resumed by Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Client (Automation EVFLender)"), "On Hold by Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by AMC (" + amcCompany + ")"), "Order Changed by Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Order accepted by AMC (" + amcCompany + ") and In Progress"), "Order accepted by Vendor (Automation EVFAMC) and In Progress is missing from the audit trail");
		Assert.assertTrue(history.contains("Order automatically accepted."), "Order automatically accepted. is missing from the audit trail");
		Assert.assertTrue(history.contains("Order automatically assigned"), "Order automatically assigned is missing from the audit trail");
		Assert.assertTrue(history.contains("Assigned to Automation"), "Assigned to Automation EVFAMC is missing from the audit trail");
		
		// Verify new Due Date
		Assert.assertTrue(SOrderDetails.orderDue_txt(driver).getText().contains(StoredVariables.getorderDueDateShort().get()), "New Due Date is not correct");
		
		// Verify fee
		Assert.assertTrue(SOrderDetails.assignmentInformation_txt(driver).getText().contains("673"), "Fee should have updated");
		
		// Verify Other Document is in Documents
		documentText = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(!documentText.contains("Market Information"), "Market Information should not sync to Secure");
		Assert.assertTrue(!documentText.contains("MISMO XML"), "MISMO XML should not sync to Secure");
		Assert.assertTrue(!documentText.contains("Report PDF"), "Report PDF should not sync to Secure");
		Assert.assertTrue(documentText.contains("Other"), "Other did not sync to Secure");
		Assert.assertTrue(documentText.contains("Sales Contract"), "Sales Contract did not sync to Secure");
		
		// Verify Sales ContractDocument is in Documents
		documentText = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Sales Contract"), "Sales Contract did not sync to Secure");
		
		// Click on Sales Contract
		perform.clickInTable_Contains(driver, "Sales Contract");
		
		// Wait for text to update
		perform.waitForText(driver, SOrderDetails.documents_txt(driver), "Test PDF.pdf");
		documentText = SOrderDetails.documents_txt(driver).getText();
		
		// Verify file name and uploaded by
		Assert.assertTrue(documentText.contains("Test PDF.pdf"), "Document name is incorrect in Documents");
		Assert.assertTrue(documentText.contains("Automation EVFLender"), "Uploaded By is incorrect in Documents");
		
		// Create boolean for both Other documents
		amc = false;
		lender = false;
		
		// Get Number Of Other documents
		docs = driver.findElements(By.xpath("//td[text()='Other']"));
		for (WebElement doc: docs)
		{
			
			// Click first Other document
			perform.click(driver,doc);
			
			Thread.sleep(3000);
			
			documentText = SOrderDetails.documents_txt(driver).getText();
			
			// Wait for text
			perform.waitForText(driver, SOrderDetails.documents_txt(driver), "Automation");
			
			if (documentText.contains("Automation EVFAMC") && amc == false)
			{
				// Verify Uploaded By and Document Name
				Assert.assertTrue(documentText.contains("Test PDF_1.pdf"), "Test PDF_1.pdf is not showing as the Document Name in Order Documents");
				amc = true;
			}
			
			else if (documentText.contains("Automation EVFLender") && lender == false)
			{
				// Verify Uploaded By and Document Name
				Assert.assertTrue(documentText.contains("TestPDF.pdf"), "TestPDF.pdf is not showing as the Document Name in Order Documents");
				lender = true;
			}
				
		} // end for loop
		
		Assert.assertTrue(amc==true, "The Other document uploaded by Automation EVFAMC is not displaying");
		Assert.assertTrue(lender==true, "The Other document uploaded by Automation EVFLender is not displaying");

		// View XSite order
		secure.viewXSiteOrderFromSecure(driver, "EVFAMC", StoredVariables.getpassword().get(), orderNumberAMC);
		
		// Get history text
		perform.waitForElementToBeVisible(driver, XOrders.toolbar(), "id");
		history = XOrders.history_txt(driver).getText();
		address = StoredVariables.getpropertyInformationAddress().get() + " " + StoredVariables.getpropertyInformationCity().get() + ", " + StoredVariables.getpropertyInformationStateAbbr().get() + " " + StoredVariables.getpropertyInformationZip().get();
		
		// Verify the history
		Assert.assertTrue(history.contains("History (Revision Needed)"), "History (Revision Needed) is missing from the order information");
		Assert.assertTrue(!history.contains("These are even more additional Message notes from Appraiser3 testing unchecked sync status"), "These are even more additional Message notes from Appraiser3 testing unchecked sync status is missing from the order information");
		Assert.assertTrue(history.contains("Revision Needed (Automation EVFAMC)"), "Revision Needed (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are more request revision notes from EVFAMC on Secure"), "These are more request revision notes from EVFAMC on Secure is missing from the order information");
		Assert.assertTrue(history.contains("Revision Request Cancelled (Automation EVFLender)"), "Revision Request Cancelled (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are cancel revision request notes from OriginatorEVF"), "These are cancel revision request notes from OriginatorEVF is missing from the order information");
		Assert.assertTrue(history.contains("Revision Needed (Automation EVFAMC)"), "Revision Needed (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are request revision notes from EVFAMC on Secure"), "These are request revision notes from EVFAMC on Secure is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Submission to FNM Not Successful"), "Appraisal Submission to FNM Not Successful is missing from the order information");
		Assert.assertTrue(history.contains("View FNM SSR"), "View FNM SSR is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Submitted to FNM via UCDP"), "Appraisal Submitted to FNM via UCDP is missing from the order information");
		Assert.assertTrue(history.contains("UCDP Document File ID Updated (Automation EVFAMC)"), "UCDP Document File ID Updated (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("Pending Quality Review (Automation EVFAMC)"), "Pending Quality Review (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Message (Automation EVFAMC)"), "Message (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser3"), "These are Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Complete (Automation EVFAMC)"), "Inspection Complete (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspected on"), "Inspected on is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Scheduled (Automation EVFAMC)"), "Inspection Scheduled (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection date is"), "Inspection date is is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required (Automation EVFAMC)"), "Comment - Action Required (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("This is an action required message by EVFAMC"), "This is an action required message by EVFAMC is missing from the audit trail");
		Assert.assertTrue(history.contains("Message (Automation EVFAMC)"), "Message (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("This is a test message from EVFAMC on the XSite"), "This is a test message from EVFAMC on the XSite is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed (Automation EVFAMC)"), "Order Changed (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraisal Fee Changed (Automation EVFLender)"), "Appraisal Fee Changed (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal fee changed from $0 to $673"), "Appraisal fee changed from $0 to $673 is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFLender change fee comments"), "These are EVFLender change fee comments is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed (Automation EVFLender)"), "Vendor due date changed (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFLender change due date comments"), "These are EVFLender change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed (Automation EVFAMC)"), "Vendor due date changed (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the order information");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Message (Automation EVFAMC)"), "Message (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded (Automation EVFAMC) (Test PDF_1.pdf)"), "Document Uploaded (Automation EVFAMC) (Test PDF_1.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed (Automation EVFAMC)"), "Resumed (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed (Automation EVFAMC)"), "Delayed (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraiser Accepted assignment by Appraiser"), "Appraiser Accepted assignment by Appraiser is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed (Automation EVFLender)"), "Resumed (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required (Automation EVFLender)"), "Comment - Action Required (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required for " + address), "Comment - Action Required for " + address + " is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message (Automation EVFLender)"), "Message (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("Order message for " + address), "Order message for " + address + " is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded (Automation EVFLender) (TestPDF.pdf)"), "Document Uploaded (Automation EVFLender) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded (Automation EVFLender) (Test PDF.pdf)"), "Document Uploaded (Automation EVFLender) (Test PDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed (Automation EVFLender)"), "Delayed (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed (Automation EVFLender)"), "Resumed (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold (Automation EVFLender)"), "On Hold (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed (Automation EVFAMC)"), "Order Changed (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("To View Change History:"), "To View Change History: is missing from the audit trail");
		Assert.assertTrue(history.contains("In Progress (Automation EVFAMC)"), "In Progress (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance"), "Awaiting acceptance is missing from the audit trail");
		
		// Verify order details
		perform.verifyXSiteOrderDetailsForAMC(driver);
		
		// Verify documents
		perform.waitForText(driver, XOrders.documents_txt(driver), "Other");
		documentsText = XOrders.documents_txt(driver).getText();
		Assert.assertTrue(!documentsText.contains("Market Information"), "Market Information should not sync to Secure");
		Assert.assertTrue(!documentsText.contains("No UAD Hard Stops.xml"), "No UAD Hard Stops.xml should not sync to the XSite");
		Assert.assertTrue(documentsText.contains("Other"), "Other document is missing from the documents section of the XSite - " + documentsText);
		Assert.assertTrue(documentsText.contains("TestPDF"), "TestPDF document is missing from the documents section of the XSite - " + documentsText);
		Assert.assertTrue(documentsText.contains("Test PDF_1"), "Test PDF_1 document is missing from the documents section of the XSite - " + documentsText);
		Assert.assertTrue(documentsText.contains("Sales Contract"), "Sales Contract document is missing from the documents section of the XSite - " + documentsText);
		Assert.assertTrue(documentsText.contains("Test PDF"), "Test PDF document is missing from the documents section of the XSite - " + documentsText);
		
		// Verify comments
		comments = XOrders.comments_txt(driver).getText();
		Assert.assertTrue(comments.contains("These are edited comments by EVFAMC"), "Additional Comments section is missing info");
		
		// Verify new Due Date
		Assert.assertTrue(XOrders.dueDate_txt(driver).getText().equals(StoredVariables.getorderDueDateShort().get()), "New Due Date is not correct");
		
		// Verify fee
		Assert.assertTrue(XOrders.fee_txt(driver).getText().equals("$673.00"), "Fee should have updated");
		
		// Close XSite order
		perform.closeNewWindow(driver);

		// Log in to Vendors
		vendors.login(driver, "Appraiser3", StoredVariables.getpassword().get());
		
		// Search for order
		vendors.findOrder(driver, orderNumberAMC, "Tracking Number");
		
		// Verify order status
		Assert.assertTrue(VOrders.ordersGrid_txt(driver).getText().contains("Revision Needed"), "The order is not in the correct status"); //changed from Revision Needed
		
		// Click on the order from the orders grid
		perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, VOrderDetails.orderInformation_txt(), "id");
		
		// Get order information text
		history = VOrderDetails.orderInformation_txt(driver).getText();
		
		// Verify audit trail
		Assert.assertTrue(history.contains("History (Revision Needed)"), "History (Revision Needed) is missing from the order information");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser3)"), "Message from Appraiser (Automation Appraiser3) is missing from the order information");
		Assert.assertTrue(history.contains("These are even more additional Message notes from Appraiser3 testing unchecked sync status"), "These are even more additional Message notes from Appraiser3 testing unchecked sync status is missing from the order information");
		Assert.assertTrue(!history.contains("Revised Report delivered by Appraiser (Automation Appraiser3)"), "Revised Report delivered by Appraiser (Automation Appraiser3) is missing from the order information");
		Assert.assertTrue(!history.contains("This is another Message to the client for completing the order from Appraiser3 on Vendors"), "This is another Message to the client for completing the order from Appraiser3 on Vendors is missing from the order information");
		Assert.assertTrue(history.contains("Revision Needed by Client (Automation EVFAMC)"), "Revision Needed by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are more request revision notes from EVFAMC on Secure"), "These are more request revision notes from EVFAMC on Secure is missing from the order information");
		Assert.assertTrue(history.contains("Revision Request Cancelled by Client (Automation EVFAMC)"), "Revision Request Cancelled by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are cancel revision request notes from OriginatorEVF"), "These are cancel revision request notes from OriginatorEVF is missing from the order information");
		Assert.assertTrue(history.contains("Revision Needed by Client (Automation EVFAMC)"), "Revision Needed by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are request revision notes from EVFAMC on Secure"), "These are request revision notes from EVFAMC on Secure is missing from the order information");
		Assert.assertTrue(history.contains("Order delivered by Appraiser (Automation Appraiser3) and is now In QC - Level One"), "Order delivered by Appraiser (Automation Appraiser3) and is now In QC - Level One is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser3)"), "Message from Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser3"), "These are Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Complete by Appraiser (Automation Appraiser3)"), "Inspection Complete by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspected on"), "Inspected on is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Scheduled by Appraiser (Automation Appraiser3)"), "Inspection Scheduled by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection date is"), "Inspection date is is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFAMC)"), "Message from Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("This is a test message from EVFAMC on the XSite"), "This is a test message from EVFAMC on the XSite is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by AMC ("+amcCompany+")"), "Order Changed by AMC ("+amcCompany+") is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are EVFLender change fee comments"), "These are EVFLender change fee comments is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed by Client (Automation EVFAMC)"), "Vendor due date changed by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFLender change due date comments"), "These are EVFLender change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Fee Changed by Client (Automation EVFAMC)"), "Appraisal Fee Changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraisal fee changed from $350 to $525."), "Appraisal fee changed from $350 to $525. is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFAMC change fee comments"), "These are EVFAMC change fee comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed by Client (Automation EVFAMC)"), "Vendor due date changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the audit trail");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser3)"), "Message from Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Apostrophes License.pdf)"), "Document Uploaded from Appraiser (Automation Appraiser3) (Apostrophes License.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Test PDF_1.pdf)"), "Document Uploaded from Appraiser (Automation Appraiser3) (Test PDF_1.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Appraiser (Automation Appraiser3)"), "Resumed by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Appraiser (Automation Appraiser3)"), "Delayed by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order accepted by Appraiser (Automation Appraiser3) and In Progress"), "Order accepted by Appraiser (Automation Appraiser3) and In Progress is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation EVFAMC)"), "Comment - Action Required by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFAMC)"), "Message from Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(!history.contains("Document Uploaded from Client (Automation EVFAMC) (Test PDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC) (Test PDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Client (Automation EVFAMC)"), "Delayed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Client (Automation EVFAMC)"), "On Hold by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser3"), "Awaiting acceptance by Automation Appraiser3 is missing from the audit trail");
		
		// Verify new Due Date
		Assert.assertTrue(VOrderDetails.orderInformation_txt(driver).getText().contains(StoredVariables.getorderDueDateShort().get()), "New Due Date is not correct");
		
		// Verify fee
		Assert.assertTrue(VOrderDetails.orderInformation_txt(driver).getText().contains("$525"), "Fee should not have updated");
		
		// Get comments
		additionalComments = VOrderDetails.additionalComments_txt(driver).getText();
		
		// Verify both VMP and MN comments are displayed
		Assert.assertTrue(additionalComments.contains("These are edited comments by EVFAMC"), "Additional Comments section is missing info");
		
		// View Order Details
		vendors.verifyOrderDetails(driver);
		
		// Verify Document is in Documents
		documentText = VOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Report PDF"), "Report PDF did not sync to Vendors");
		Assert.assertTrue(documentText.contains("MISMO XML"), "MISMO XML did not sync to Vendors");
		Assert.assertTrue(documentText.contains("Other"), "Other did not sync to Vendors");
		Assert.assertTrue(documentText.contains("Market Information"), "Market Information did not sync to Vendors");
		Assert.assertTrue(!documentText.contains("Sales Contract"), "Sales Contract should not sync to Vendors");
		
		// Log in to Secure
		secure.login(driver, "EVFAMC", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, orderNumberAMC, "Tracking number");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("Appraisal Submission to FNM Not Successful"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, awsAccountsID + "-" + orderNumberAMC);
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Verify order details0
		secure.verifyResidentialAppraisalOrderDetails(driver);
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify the history
		Assert.assertTrue(history.contains("History (Revision Needed)"), "History (Revision Needed) is missing from the order information");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser3)"), "Message from Vendor (Automation Appraiser3) is missing from the order information");
		Assert.assertTrue(history.contains("These are even more additional Message notes from Appraiser3 testing unchecked sync status"), "These are even more additional Message notes from Appraiser3 testing unchecked sync status is missing from the order information");
		Assert.assertTrue(!history.contains("Revision Needed by Clientdelivered by Appraiser (Automation Appraiser3)"), "Revised Report delivered by Appraiser (Automation Appraiser3) is missing from the order information");
		Assert.assertTrue(!history.contains("This is another Message to the client for completing the order from Appraiser3 on Vendors"), "This is another Message to the client for completing the order from Appraiser3 on Vendors is missing from the order information");
		Assert.assertTrue(history.contains("Revision Needed by Client (Automation EVFAMC)"), "Revision Needed by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are more request revision notes from EVFAMC on Secure"), "These are more request revision notes from EVFAMC on Secure is missing from the order information");
		Assert.assertTrue(history.contains("Revision Request Cancelled by Client (Automation EVFAMC)"), "Revision Request Cancelled by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are cancel revision request notes from OriginatorEVF"), "These are cancel revision request notes from OriginatorEVF is missing from the order information");
		Assert.assertTrue(history.contains("Revision Needed by Client (Automation EVFAMC)"), "Revision Needed by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are request revision notes from EVFAMC on Secure"), "These are request revision notes from EVFAMC on Secure is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Submission to FNM Not Successful"), "Appraisal Submission to FNM Not Successful is missing from the order information");
		Assert.assertTrue(history.contains("View FNM SSR"), "View FNM SSR is missing from the order information");
		Assert.assertTrue(history.contains("UCDP Document File ID Updated by Client (Automation EVFAMC)"), "UCDP Document File ID Updated by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("Note Added (Automation EVFAMC)"), "Note Added (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are internal notes from EVFAMC on Secure"), "These are internal notes from EVFAMC on Secure is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Submitted to FNM via UCDP by Client (Automation EVFAMC)"), "Appraisal Submitted to FNM via UCDP by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("Order delivered by Appraiser (Automation Appraiser3) and is now In QC - Level One"), "Order delivered by Appraiser (Automation Appraiser3) and is now In QC - Level One is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser3)"), "Message from Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser3"), "These are Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Complete by Appraiser (Automation Appraiser3)"), "Inspection Complete by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspected on"), "Inspected on is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Scheduled by Appraiser (Automation Appraiser3)"), "Inspection Scheduled by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection date is"), "Inspection date is is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFAMC)"), "Message from Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("This is a test message from EVFAMC on the XSite"), "This is a test message from EVFAMC on the XSite is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by Client (Automation EVFAMC)"), "Order Changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are EVFLender change fee comments"), "These are EVFLender change fee comments is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed by Client (Automation EVFAMC)"), "Vendor due date changed by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFLender change due date comments"), "These are EVFLender change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Fee Changed by Client (Automation EVFAMC)"), "Appraisal Fee Changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraisal fee changed from $350 to $525."), "Appraisal fee changed from $350 to $525. is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFAMC change fee comments"), "These are EVFAMC change fee comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed by Client (Automation EVFAMC)"), "Vendor due date changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the audit trail");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser3)"), "Message from Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Apostrophes License.pdf)"), "Document Uploaded from Vendor (Automation Appraiser3) (Apostrophes License.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Test PDF_1.pdf)"), "Document Uploaded from Vendor (Automation Appraiser3) (Test PDF_1.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Appraiser (Automation Appraiser3)"), "Resumed by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Appraiser (Automation Appraiser3)"), "Delayed by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order accepted by Appraiser (Automation Appraiser3) and In Progress"), "Order accepted by Appraiser (Automation Appraiser3) and In Progress is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation EVFAMC)"), "Comment - Action Required by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFAMC)"), "Message from Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(!history.contains("Document Uploaded from Client (Automation EVFAMC) (Test PDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC) (Test PDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Client (Automation EVFAMC)"), "Delayed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Client (Automation EVFAMC)"), "On Hold by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser3"), "Awaiting acceptance by Automation Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Reassigned by Client (Automation EVFAMC) to Automation Appraiser3"), "Reassigned by Client (Automation EVFAMC) to Automation Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by Client (Automation EVFAMC)"), "Order Changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("To View Change History:"), "To View Change History: is missing from the audit trail");
		Assert.assertTrue(history.contains("Requires assignment"), "Requires assignment is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance"), "Awaiting acceptance is missing from the audit trail");
		
		// Verify new Due Date
		Assert.assertTrue(SOrderDetails.orderDue_txt(driver).getText().contains(StoredVariables.getorderDueDateShort().get()), "New Due Date is not correct");
		
		// Verify fee
		Assert.assertTrue(SOrderDetails.assignmentInformation_txt(driver).getText().contains("525"), "Fee should not have updated");
		
		// Verify Other Document is in Documents
		documentText = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Report PDF"), "Report PDF did not sync to Secure");
		Assert.assertTrue(documentText.contains("MISMO XML"), "MISMO XML did not sync to Secure");
		Assert.assertTrue(documentText.contains("Other"), "Other did not sync to Secure");
		Assert.assertTrue(documentText.contains("Market Information"), "Market Information did not sync to Secure");
		Assert.assertTrue(!documentText.contains("Sales Contract"), "Sales Contract should not sync to Secure");

		// Login to VMP Client Portal
		vmp.login(driver, "EVFLender", "OriginatorEVF", StoredVariables.getpassword().get());
		
		// Search for order
		vmp.findOrder(driver, StoredVariables.getloanIDVMP().get(), "Tracking #");
		
		// Verify Order Status
		Assert.assertTrue(VMPOrders.orderStatus_txt(driver).getText().equals("Revision Needed"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());
		
		Thread.sleep(1500);
		
		// Wait for Send Message button
		perform.waitForElementToBeVisible(driver, VMPAppraisalOrderDetails.sendMessage_btn(), "cssSelector");
		
		// Click Send Message
		perform.click(driver,VMPAppraisalOrderDetails.sendMessage_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for Send button
		perform.waitForElementToBeClickable(driver, VMPAppraisalOrderDetails.send_btn(), "cssSelector");
		
		// Add notes
		perform.type(driver,VMPAppraisalOrderDetails.sendMessage_txtbx(driver), "These are additional Send Message notes from OriginatorEVF to test sync");
		
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
		
		Assert.assertTrue(history.contains("Message by Automation OriginatorEVF"), "Message by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are additional Send Message notes from OriginatorEVF to test sync"), "These are additional Send Message notes from OriginatorEVF to test sync is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are even more additional Message notes from Appraiser3 testing unchecked sync status"), "These are even more additional Message notes from Appraiser3 testing unchecked sync status is missing from the order information");
		Assert.assertTrue(history.contains("Revision Needed by Automation EVFLender"), "Revision Needed by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are more request revision notes from EVFAMC on Secure"), "These are more request revision notes from EVFAMC on Secure is missing from the audit trail");
		Assert.assertTrue(history.contains("Revision Request Cancelled by Automation OriginatorEVF"), "Revision Request Cancelled by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are cancel revision request notes from OriginatorEVF"), "These are cancel revision request notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Revision Needed by Automation EVFLender"), "Revision Needed by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are request revision notes from EVFAMC on Secure"), "These are request revision notes from EVFAMC on Secure is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraisal Submission to FNM Not Successful by Automation EVFLender"), "Appraisal Submission to FNM Not Successful by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("View FNM SSR"), "View FNM SSR is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraisal Submitted to FNM via UCDP by Automation EVFLender"), "Appraisal Submitted to FNM via UCDP by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("UCDP Document File ID Updated by Automation EVFLender"), "UCDP Document File ID Updated by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(!history.contains("Pending Quality Review by Automation EVFLender"), "Pending Quality Review by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation EVFLender"), "Message by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser3"), "These are Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Complete by Automation EVFLender"), "Inspection Complete by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspected on"), "Inspected on is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Scheduled by Automation EVFLender"), "Inspection Scheduled by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection date is"), "Inspection date is is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Automation EVFLender"), "Comment - Action Required by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("This is an action required message by EVFAMC"), "This is an action required message by EVFAMC is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by Automation EVFLender"), "Order Changed by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by Automation EVFLender"), "Order Changed by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation EVFLender"), "Message by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("This is a test message from EVFAMC on the XSite"), "This is a test message from EVFAMC on the XSite is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are EVFLender change fee comments"), "These are EVFLender change fee comments is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed by Automation EVFLender"), "Vendor due date changed by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the audit trail");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFLender change due date comments"), "These are EVFLender change due date comments is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation EVFLender"), "Message by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation EVFLender"), "Document Uploaded by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("Other"), "Other is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF_1.pdf"), "Test PDF_1.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation EVFLender"), "Resumed by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation EVFLender"), "Delayed by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraiser Accepted Assignment by Automation EVFLender"), "Appraiser Accepted Assignment by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorEVF"), "Resumed by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Automation OriginatorEVF"), "Comment - Action Required by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation OriginatorEVF"), "Message by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorEVF"), "Document Uploaded by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Other"), "Other is missing from the audit trail");
		Assert.assertTrue(history.contains("TestPDF.pdf"), "TestPDF.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorEVF"), "Document Uploaded by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Sales Contract"), "Sales Contract is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF.pdf"), "Test PDF.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation OriginatorEVF"), "Delayed by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorEVF"), "Resumed by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Automation OriginatorEVF"), "On Hold by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("In Progress by Automation OriginatorEVF"), "In Progress by Automation OriginatorEVF is missing from the audit trail");
		
		// Log in to Secure
		secure.login(driver, "EVFLender", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, StoredVariables.getloanID().get(), "Tracking number");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("Revision Needed"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, awsAccountsID + "-" + StoredVariables.getloanID().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Verify order details
		secure.verifyResidentialAppraisalOrderDetails(driver);
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify the history
		Assert.assertTrue(history.contains("History (Revision Needed)"), "History (Revision Needed) is missing from the order information");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFLender)"), "Message from Client (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are additional Send Message notes from OriginatorEVF to test sync"), "These are additional Send Message notes from OriginatorEVF to test sync is missing from the order information");
		Assert.assertTrue(!history.contains("These are even more additional Message notes from Appraiser3 testing unchecked sync status"), "These are even more additional Message notes from Appraiser3 testing unchecked sync status is missing from the order information");
		Assert.assertTrue(history.contains("Revision Needed by AMC (" + amcCompany + ")"), "Revision Needed by Vendor (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are more request revision notes from EVFAMC on Secure"), "These are more request revision notes from EVFAMC on Secure is missing from the order information");
		Assert.assertTrue(history.contains("Revision Request Cancelled by Client (Automation EVFLender)"), "Revision Request Cancelled by Client (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are cancel revision request notes from OriginatorEVF"), "These are cancel revision request notes from OriginatorEVF is missing from the order information");
		Assert.assertTrue(history.contains("Revision Needed by AMC (" + amcCompany + ")"), "Revision Needed by Vendor (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are request revision notes from EVFAMC on Secure"), "These are request revision notes from EVFAMC on Secure is missing from the order information");
		Assert.assertTrue(history.contains("View FNM SSR"), "View FNM SSR is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Submission to FNM Not Successful"), "Appraisal Submission to FNM Not Successful is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Submitted to FNM via UCDP by AMC (" + amcCompany + ")"), "Appraisal Submitted to FNM via UCDP by Vendor (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("UCDP Document File ID Updated by AMC (" + amcCompany + ")"), "UCDP Document File ID Updated by Vendor (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("Order delivered by AMC (" + amcCompany + ") and is now Pending Quality Review"), "Order delivered by Vendor (Automation EVFAMC) and is now Pending Quality Review is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from AMC (" + amcCompany + ")"), "Message from Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser3"), "These are Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Complete by AMC (" + amcCompany + ")"), "Inspection Complete by Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspected on"), "Inspected on is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Scheduled by AMC (" + amcCompany + ")"), "Inspection Scheduled by Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection date is"), "Inspection date is is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by AMC (" + amcCompany + ")"), "Comment - Action Required by Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("This is an action required message by EVFAMC"), "This is an action required message by EVFAMC is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from AMC (" + amcCompany + ")"), "Message from Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("This is a test message from EVFAMC on the XSite"), "This is a test message from EVFAMC on the XSite is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by AMC (" + amcCompany + ")"), "Order Changed by Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraisal Fee Changed by Client (Automation EVFLender)"), "Appraisal Fee Changed by Client (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal fee changed from $0 to $673"), "Appraisal fee changed from $0 to $673 is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFLender change fee comment"), "These are EVFLender change fee comment is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed by Client (Automation EVFLender)"), "Vendor due date changed by Client (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the order information");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFLender change due date comments"), "These are EVFLender change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed by AMC (" + amcCompany + ")"), "Vendor due date changed by Vendor (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the order information");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Message from AMC (" + amcCompany + ")"), "Message from Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from AMC (" + amcCompany + ") (Test PDF_1.pdf)"), "Document Uploaded from Vendor (Automation EVFAMC) (Test PDF_1.pdf)�is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by AMC (" + amcCompany + ")"), "Resumed by Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by AMC (" + amcCompany + ")"), "Delayed by Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraiser Accepted assignment"), "Appraiser Accepted assignment is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFLender)"), "Resumed by Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation EVFLender)"), "Comment - Action Required by Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFLender)"), "Message from Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFLender) (TestPDF.pdf)"), "Document Uploaded from Client (Automation EVFLender) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFLender) (Test PDF.pdf)"), "Document Uploaded from Client (Automation EVFLender) (Test PDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Client (Automation EVFLender)"), "Delayed by Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFLender)"), "Resumed by Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Client (Automation EVFLender)"), "On Hold by Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by AMC (" + amcCompany + ")"), "Order Changed by Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Order accepted by AMC (" + amcCompany + ") and In Progress"), "Order accepted by Vendor (Automation EVFAMC) and In Progress is missing from the audit trail");
		Assert.assertTrue(history.contains("Order automatically accepted."), "Order automatically accepted. is missing from the audit trail");
		Assert.assertTrue(history.contains("Order automatically assigned"), "Order automatically assigned is missing from the audit trail");
		Assert.assertTrue(history.contains("Assigned to Automation"), "Assigned to Automation EVFAMC is missing from the audit trail");
		
		// Verify new Due Date
		Assert.assertTrue(SOrderDetails.orderDue_txt(driver).getText().contains(StoredVariables.getorderDueDateShort().get()), "New Due Date is not correct");
		
		// Verify fee
		Assert.assertTrue(SOrderDetails.assignmentInformation_txt(driver).getText().contains("673"), "Fee should have updated");
		
		// Verify Other Document is in Documents
		documentText = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(!documentText.contains("Market Information"), "Market Information should not sync to Secure");
		Assert.assertTrue(!documentText.contains("MISMO XML"), "MISMO XML should not sync to Secure");
		Assert.assertTrue(!documentText.contains("Report PDF"), "Report PDF should not sync to Secure");
		Assert.assertTrue(documentText.contains("Other"), "Other did not sync to Secure");
		Assert.assertTrue(documentText.contains("Sales Contract"), "Sales Contract did not sync to Secure");
		
		// Verify Sales ContractDocument is in Documents
		documentText = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Sales Contract"), "Sales Contract did not sync to Secure");
		
		// Click on Sales Contract
		perform.clickInTable_Contains(driver, "Sales Contract");
		
		// Wait for text to update
		perform.waitForText(driver, SOrderDetails.documents_txt(driver), "Test PDF.pdf");
		documentText = SOrderDetails.documents_txt(driver).getText();
		
		// Verify file name and uploaded by
		Assert.assertTrue(documentText.contains("Test PDF.pdf"), "Document name is incorrect in Documents");
		Assert.assertTrue(documentText.contains("Automation EVFLender"), "Uploaded By is incorrect in Documents");
		
		// Create boolean for both Other documents
		amc = false;
		lender = false;
		
		// Get Number Of Other documents
		docs = driver.findElements(By.xpath("//td[text()='Other']"));
		for (WebElement doc: docs)
		{
			
			// Click first Other document
			perform.click(driver,doc);
			
			Thread.sleep(3000);
			
			documentText = SOrderDetails.documents_txt(driver).getText();
			
			// Wait for text
			perform.waitForText(driver, SOrderDetails.documents_txt(driver), "Automation");
			
			if (documentText.contains("Automation EVFAMC") && amc == false)
			{
				// Verify Uploaded By and Document Name
				Assert.assertTrue(documentText.contains("Test PDF_1.pdf"), "Test PDF_1.pdf is not showing as the Document Name in Order Documents");
				amc = true;
			}
			
			else if (documentText.contains("Automation EVFLender") && lender == false)
			{
				// Verify Uploaded By and Document Name
				Assert.assertTrue(documentText.contains("TestPDF.pdf"), "TestPDF.pdf is not showing as the Document Name in Order Documents");
				lender = true;
			}
				
		} // end for loop
		
		Assert.assertTrue(amc==true, "The Other document uploaded by Automation EVFAMC is not displaying");
		Assert.assertTrue(lender==true, "The Other document uploaded by Automation EVFLender is not displaying");

		// View XSite order
		secure.viewXSiteOrderFromSecure(driver, "EVFAMC", StoredVariables.getpassword().get(), orderNumberAMC);
		
		// Get history text
		perform.waitForElementToBeVisible(driver, XOrders.toolbar(), "id");
		history = XOrders.history_txt(driver).getText();
		address = StoredVariables.getpropertyInformationAddress().get() + " " + StoredVariables.getpropertyInformationCity().get() + ", " + StoredVariables.getpropertyInformationStateAbbr().get() + " " + StoredVariables.getpropertyInformationZip().get();
		
		// Verify the history
		Assert.assertTrue(history.contains("History (Revision Needed)"), "History (Revision Needed) is missing from the order information");
		Assert.assertTrue(history.contains("Message (Automation EVFLender)"), "Message (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are additional Send Message notes from OriginatorEVF to test sync"), "These are additional Send Message notes from OriginatorEVF to test sync is missing from the order information");
		Assert.assertTrue(!history.contains("These are even more additional Message notes from Appraiser3 testing unchecked sync status"), "These are even more additional Message notes from Appraiser3 testing unchecked sync status is missing from the order information");
		Assert.assertTrue(history.contains("Revision Needed (Automation EVFAMC)"), "Revision Needed (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are more request revision notes from EVFAMC on Secure"), "These are more request revision notes from EVFAMC on Secure is missing from the order information");
		Assert.assertTrue(history.contains("Revision Request Cancelled (Automation EVFLender)"), "Revision Request Cancelled (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are cancel revision request notes from OriginatorEVF"), "These are cancel revision request notes from OriginatorEVF is missing from the order information");
		Assert.assertTrue(history.contains("Revision Needed (Automation EVFAMC)"), "Revision Needed (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are request revision notes from EVFAMC on Secure"), "These are request revision notes from EVFAMC on Secure is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Submission to FNM Not Successful"), "Appraisal Submission to FNM Not Successful is missing from the order information");
		Assert.assertTrue(history.contains("View FNM SSR"), "View FNM SSR is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Submitted to FNM via UCDP"), "Appraisal Submitted to FNM via UCDP is missing from the order information");
		Assert.assertTrue(history.contains("UCDP Document File ID Updated (Automation EVFAMC)"), "UCDP Document File ID Updated (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("Pending Quality Review (Automation EVFAMC)"), "Pending Quality Review (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Message (Automation EVFAMC)"), "Message (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser3"), "These are Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Complete (Automation EVFAMC)"), "Inspection Complete (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspected on"), "Inspected on is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Scheduled (Automation EVFAMC)"), "Inspection Scheduled (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection date is"), "Inspection date is is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required (Automation EVFAMC)"), "Comment - Action Required (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("This is an action required message by EVFAMC"), "This is an action required message by EVFAMC is missing from the audit trail");
		Assert.assertTrue(history.contains("Message (Automation EVFAMC)"), "Message (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("This is a test message from EVFAMC on the XSite"), "This is a test message from EVFAMC on the XSite is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed (Automation EVFAMC)"), "Order Changed (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraisal Fee Changed (Automation EVFLender)"), "Appraisal Fee Changed (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal fee changed from $0 to $673"), "Appraisal fee changed from $0 to $673 is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFLender change fee comments"), "These are EVFLender change fee comments is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed (Automation EVFLender)"), "Vendor due date changed (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFLender change due date comments"), "These are EVFLender change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed (Automation EVFAMC)"), "Vendor due date changed (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the order information");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Message (Automation EVFAMC)"), "Message (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded (Automation EVFAMC) (Test PDF_1.pdf)"), "Document Uploaded (Automation EVFAMC) (Test PDF_1.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed (Automation EVFAMC)"), "Resumed (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed (Automation EVFAMC)"), "Delayed (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraiser Accepted assignment by Appraiser"), "Appraiser Accepted assignment by Appraiser is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed (Automation EVFLender)"), "Resumed (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required (Automation EVFLender)"), "Comment - Action Required (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required for " + address), "Comment - Action Required for " + address + " is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message (Automation EVFLender)"), "Message (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("Order message for " + address), "Order message for " + address + " is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded (Automation EVFLender) (TestPDF.pdf)"), "Document Uploaded (Automation EVFLender) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded (Automation EVFLender) (Test PDF.pdf)"), "Document Uploaded (Automation EVFLender) (Test PDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed (Automation EVFLender)"), "Delayed (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed (Automation EVFLender)"), "Resumed (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold (Automation EVFLender)"), "On Hold (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed (Automation EVFAMC)"), "Order Changed (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("To View Change History:"), "To View Change History: is missing from the audit trail");
		Assert.assertTrue(history.contains("In Progress (Automation EVFAMC)"), "In Progress (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance"), "Awaiting acceptance is missing from the audit trail");
		
		// Verify order details
		perform.verifyXSiteOrderDetailsForAMC(driver);
		
		// Verify documents
		perform.waitForText(driver, XOrders.documents_txt(driver), "Other");
		documentsText = XOrders.documents_txt(driver).getText();
		Assert.assertTrue(!documentsText.contains("Market Information"), "Market Information should not sync to Secure");
		Assert.assertTrue(!documentsText.contains("No UAD Hard Stops.xml"), "No UAD Hard Stops.xml should not sync to the XSite");
		Assert.assertTrue(documentsText.contains("Other"), "Other document is missing from the documents section of the XSite - " + documentsText);
		Assert.assertTrue(documentsText.contains("TestPDF"), "TestPDF document is missing from the documents section of the XSite - " + documentsText);
		Assert.assertTrue(documentsText.contains("Test PDF_1"), "Test PDF_1 document is missing from the documents section of the XSite - " + documentsText);
		Assert.assertTrue(documentsText.contains("Sales Contract"), "Sales Contract document is missing from the documents section of the XSite - " + documentsText);
		Assert.assertTrue(documentsText.contains("Test PDF"), "Test PDF document is missing from the documents section of the XSite - " + documentsText);
		
		// Verify comments
		comments = XOrders.comments_txt(driver).getText();
		Assert.assertTrue(comments.contains("These are edited comments by EVFAMC"), "Additional Comments section is missing info");
		
		// Verify new Due Date
		Assert.assertTrue(XOrders.dueDate_txt(driver).getText().equals(StoredVariables.getorderDueDateShort().get()), "New Due Date is not correct");
		
		// Verify fee
		Assert.assertTrue(XOrders.fee_txt(driver).getText().equals("$673.00"), "Fee should have updated");
		
		// Close XSite order
		perform.closeNewWindow(driver);
		
		// Log in to Vendors
		vendors.login(driver, "Appraiser3", StoredVariables.getpassword().get());
		
		// Search for order
		vendors.findOrder(driver, orderNumberAMC, "Tracking Number");
		
		// Verify order status
		Assert.assertTrue(VOrders.ordersGrid_txt(driver).getText().contains("Revision Needed"), "The order is not in the correct status"); //changed from Revision Needed
		
		// Click on the order from the orders grid
		perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, VOrderDetails.orderInformation_txt(), "id");
		
		// Get order information text
		history = VOrderDetails.orderInformation_txt(driver).getText();
		
		// Verify audit trail
		Assert.assertTrue(history.contains("History (Revision Needed)"), "History (Revision Needed) is missing from the order information");
		Assert.assertTrue(!history.contains("These are additional Send Message notes from OriginatorEVF to test sync"), "These are additional Send Message notes from OriginatorEVF to test sync is missing from the order information");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser3)"), "Message from Appraiser (Automation Appraiser3) is missing from the order information");
		Assert.assertTrue(history.contains("These are even more additional Message notes from Appraiser3 testing unchecked sync status"), "These are even more additional Message notes from Appraiser3 testing unchecked sync status is missing from the order information");
		Assert.assertTrue(!history.contains("Revised Report delivered by Appraiser (Automation Appraiser3)"), "Revised Report delivered by Appraiser (Automation Appraiser3) is missing from the order information");
		Assert.assertTrue(!history.contains("This is another Message to the client for completing the order from Appraiser3 on Vendors"), "This is another Message to the client for completing the order from Appraiser3 on Vendors is missing from the order information");
		Assert.assertTrue(history.contains("Revision Needed by Client (Automation EVFAMC)"), "Revision Needed by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are more request revision notes from EVFAMC on Secure"), "These are more request revision notes from EVFAMC on Secure is missing from the order information");
		Assert.assertTrue(history.contains("Revision Request Cancelled by Client (Automation EVFAMC)"), "Revision Request Cancelled by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are cancel revision request notes from OriginatorEVF"), "These are cancel revision request notes from OriginatorEVF is missing from the order information");
		Assert.assertTrue(history.contains("Revision Needed by Client (Automation EVFAMC)"), "Revision Needed by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are request revision notes from EVFAMC on Secure"), "These are request revision notes from EVFAMC on Secure is missing from the order information");
		Assert.assertTrue(history.contains("Order delivered by Appraiser (Automation Appraiser3) and is now In QC - Level One"), "Order delivered by Appraiser (Automation Appraiser3) and is now In QC - Level One is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser3)"), "Message from Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser3"), "These are Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Complete by Appraiser (Automation Appraiser3)"), "Inspection Complete by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspected on"), "Inspected on is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Scheduled by Appraiser (Automation Appraiser3)"), "Inspection Scheduled by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection date is"), "Inspection date is is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFAMC)"), "Message from Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("This is a test message from EVFAMC on the XSite"), "This is a test message from EVFAMC on the XSite is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by AMC ("+amcCompany+")"), "Order Changed by AMC ("+amcCompany+") is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are EVFLender change fee comments"), "These are EVFLender change fee comments is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed by Client (Automation EVFAMC)"), "Vendor due date changed by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFLender change due date comments"), "These are EVFLender change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Fee Changed by Client (Automation EVFAMC)"), "Appraisal Fee Changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraisal fee changed from $350 to $525."), "Appraisal fee changed from $350 to $525. is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFAMC change fee comments"), "These are EVFAMC change fee comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed by Client (Automation EVFAMC)"), "Vendor due date changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the audit trail");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser3)"), "Message from Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Apostrophes License.pdf)"), "Document Uploaded from Appraiser (Automation Appraiser3) (Apostrophes License.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Test PDF_1.pdf)"), "Document Uploaded from Appraiser (Automation Appraiser3) (Test PDF_1.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Appraiser (Automation Appraiser3)"), "Resumed by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Appraiser (Automation Appraiser3)"), "Delayed by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order accepted by Appraiser (Automation Appraiser3) and In Progress"), "Order accepted by Appraiser (Automation Appraiser3) and In Progress is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation EVFAMC)"), "Comment - Action Required by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFAMC)"), "Message from Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(!history.contains("Document Uploaded from Client (Automation EVFAMC) (Test PDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC) (Test PDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Client (Automation EVFAMC)"), "Delayed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Client (Automation EVFAMC)"), "On Hold by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser3"), "Awaiting acceptance by Automation Appraiser3 is missing from the audit trail");
		
		// Verify new Due Date
		Assert.assertTrue(VOrderDetails.orderInformation_txt(driver).getText().contains(StoredVariables.getorderDueDateShort().get()), "New Due Date is not correct");
		
		// Verify fee
		Assert.assertTrue(VOrderDetails.orderInformation_txt(driver).getText().contains("$525"), "Fee should not have updated");
		
		// Get comments
		additionalComments = VOrderDetails.additionalComments_txt(driver).getText();
		
		// Verify both VMP and MN comments are displayed
		Assert.assertTrue(additionalComments.contains("These are edited comments by EVFAMC"), "Additional Comments section is missing info");
		
		// View Order Details
		vendors.verifyOrderDetails(driver);
		
		// Verify Document is in Documents
		documentText = VOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Report PDF"), "Report PDF did not sync to Vendors");
		Assert.assertTrue(documentText.contains("MISMO XML"), "MISMO XML did not sync to Vendors");
		Assert.assertTrue(documentText.contains("Other"), "Other did not sync to Vendors");
		Assert.assertTrue(documentText.contains("Market Information"), "Market Information did not sync to Vendors");
		Assert.assertTrue(!documentText.contains("Sales Contract"), "Sales Contract should not sync to Vendors");
		
		// Log in to Secure
		secure.login(driver, "EVFAMC", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, orderNumberAMC, "Tracking number");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("Appraisal Submission to FNM Not Successful"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, awsAccountsID + "-" + orderNumberAMC);
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Verify order details0
		secure.verifyResidentialAppraisalOrderDetails(driver);
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify the history
		Assert.assertTrue(history.contains("History (Revision Needed)"), "History (Revision Needed) is missing from the order information");
		Assert.assertTrue(!history.contains("These are additional Send Message notes from OriginatorEVF to test sync"), "These are additional Send Message notes from OriginatorEVF to test sync is missing from the order information");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser3)"), "Message from Vendor (Automation Appraiser3) is missing from the order information");
		Assert.assertTrue(history.contains("These are even more additional Message notes from Appraiser3 testing unchecked sync status"), "These are even more additional Message notes from Appraiser3 testing unchecked sync status is missing from the order information");
		Assert.assertTrue(!history.contains("Revised Report delivered by Appraiser (Automation Appraiser3)"), "Revised Report delivered by Appraiser (Automation Appraiser3) is missing from the order information");
		Assert.assertTrue(!history.contains("This is another Message to the client for completing the order from Appraiser3 on Vendors"), "This is another Message to the client for completing the order from Appraiser3 on Vendors is missing from the order information");
		Assert.assertTrue(history.contains("Revision Needed by Client (Automation EVFAMC)"), "Revision Needed by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are more request revision notes from EVFAMC on Secure"), "These are more request revision notes from EVFAMC on Secure is missing from the order information");
		Assert.assertTrue(history.contains("Revision Request Cancelled by Client (Automation EVFAMC)"), "Revision Request Cancelled by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are cancel revision request notes from OriginatorEVF"), "These are cancel revision request notes from OriginatorEVF is missing from the order information");
		Assert.assertTrue(history.contains("Revision Needed by Client (Automation EVFAMC)"), "Revision Needed by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are request revision notes from EVFAMC on Secure"), "These are request revision notes from EVFAMC on Secure is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Submission to FNM Not Successful"), "Appraisal Submission to FNM Not Successful is missing from the order information");
		Assert.assertTrue(history.contains("View FNM SSR"), "View FNM SSR is missing from the order information");
		Assert.assertTrue(history.contains("UCDP Document File ID Updated by Client (Automation EVFAMC)"), "UCDP Document File ID Updated by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("Note Added (Automation EVFAMC)"), "Note Added (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are internal notes from EVFAMC on Secure"), "These are internal notes from EVFAMC on Secure is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Submitted to FNM via UCDP by Client (Automation EVFAMC)"), "Appraisal Submitted to FNM via UCDP by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("Order delivered by Appraiser (Automation Appraiser3) and is now In QC - Level One"), "Order delivered by Appraiser (Automation Appraiser3) and is now In QC - Level One is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser3)"), "Message from Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser3"), "These are Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Complete by Appraiser (Automation Appraiser3)"), "Inspection Complete by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspected on"), "Inspected on is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Scheduled by Appraiser (Automation Appraiser3)"), "Inspection Scheduled by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection date is"), "Inspection date is is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFAMC)"), "Message from Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("This is a test message from EVFAMC on the XSite"), "This is a test message from EVFAMC on the XSite is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by Client (Automation EVFAMC)"), "Order Changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are EVFLender change fee comments"), "These are EVFLender change fee comments is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed by Client (Automation EVFAMC)"), "Vendor due date changed by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFLender change due date comments"), "These are EVFLender change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Fee Changed by Client (Automation EVFAMC)"), "Appraisal Fee Changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraisal fee changed from $350 to $525."), "Appraisal fee changed from $350 to $525. is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFAMC change fee comments"), "These are EVFAMC change fee comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed by Client (Automation EVFAMC)"), "Vendor due date changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the audit trail");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser3)"), "Message from Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Apostrophes License.pdf)"), "Document Uploaded from Vendor (Automation Appraiser3) (Apostrophes License.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Test PDF_1.pdf)"), "Document Uploaded from Vendor (Automation Appraiser3) (Test PDF_1.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Appraiser (Automation Appraiser3)"), "Resumed by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Appraiser (Automation Appraiser3)"), "Delayed by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order accepted by Appraiser (Automation Appraiser3) and In Progress"), "Order accepted by Appraiser (Automation Appraiser3) and In Progress is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation EVFAMC)"), "Comment - Action Required by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFAMC)"), "Message from Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(!history.contains("Document Uploaded from Client (Automation EVFAMC) (Test PDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC) (Test PDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Client (Automation EVFAMC)"), "Delayed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Client (Automation EVFAMC)"), "On Hold by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser3"), "Awaiting acceptance by Automation Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Reassigned by Client (Automation EVFAMC) to Automation Appraiser3"), "Reassigned by Client (Automation EVFAMC) to Automation Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by Client (Automation EVFAMC)"), "Order Changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("To View Change History:"), "To View Change History: is missing from the audit trail");
		Assert.assertTrue(history.contains("Requires assignment"), "Requires assignment is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance"), "Awaiting acceptance is missing from the audit trail");
		
		// Verify new Due Date
		Assert.assertTrue(SOrderDetails.orderDue_txt(driver).getText().contains(StoredVariables.getorderDueDateShort().get()), "New Due Date is not correct");
		
		// Verify fee
		Assert.assertTrue(SOrderDetails.assignmentInformation_txt(driver).getText().contains("525"), "Fee should not have updated");
		
		// Verify Other Document is in Documents
		documentText = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Report PDF"), "Report PDF did not sync to Secure");
		Assert.assertTrue(documentText.contains("MISMO XML"), "MISMO XML did not sync to Secure");
		Assert.assertTrue(documentText.contains("Other"), "Other did not sync to Secure");
		Assert.assertTrue(documentText.contains("Market Information"), "Market Information did not sync to Secure");
		Assert.assertTrue(!documentText.contains("Sales Contract"), "Sales Contract should not sync to Secure");
		
		// View XSite order
		secure.viewXSiteOrderFromSecure(driver, "EVFAMC", StoredVariables.getpassword().get(), orderNumberAMC);
		
		// Click Sync to Mercury button
		perform.click(driver,XOrders.syncToMercury_btn(driver));
		
		Thread.sleep(2000);
		
		// Go to new window
	    Iterator<String> windowIterator = driver.getWindowHandles()
	            .iterator();
	    while (windowIterator.hasNext()) {
	        String windowHandle1 = windowIterator.next();
	        driver.switchTo().window(windowHandle1);
	        String title = driver.getTitle();
	        System.out.println("title = " + title);
	        if (title.contains("Sync To Mercury")) {
	        	System.out.println("break");
	            break;
	        } // end if
	    } // end while loop
	    
		// Get and pass the Window Handle for Send Message
		StoredVariables.getthirdWinHandle().set(driver.getWindowHandle());
		System.out.println("thirdWinHandle = " + StoredVariables.getthirdWinHandle().get());
		
		// Switch to the new window
		driver.switchTo().window(StoredVariables.getthirdWinHandle().get());
		
		// Wait for Notes textbox
		perform.waitForElementToBeClickable(driver, XSyncToMercury.message_txtbx(), "id");
		
		// Verify message text
		Assert.assertTrue(XSyncToMercury.message_txtbx(driver).getAttribute("value").equals("These are additional Send Message notes from OriginatorEVF to test sync"), "The text in the message is not correct");
		
		// Click Save
		perform.click(driver,XSyncToMercury.send_btn(driver));
		
		Thread.sleep(5000);
		
		// Switch to the XSite window
		driver.switchTo().window(StoredVariables.getnewWinHandle().get());
		driver.switchTo().frame("Main");
		
		// Get history text
		history = XOrders.history_txt(driver).getText();
		
		// Verify the history
		Assert.assertTrue(history.contains("Message (Automation EVFLender)"), "Message (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are additional Send Message notes from OriginatorEVF to test sync"), "This is a test message from EVFAMC on the XSite is missing from the order information");
		
		// Close XSite order
		perform.closeNewWindow(driver);

		// Log in to Vendors
		vendors.login(driver, "Appraiser3", StoredVariables.getpassword().get());
		
		// Search for order
		vendors.findOrder(driver, orderNumberAMC, "Tracking Number");
		
		// Verify order status
		Assert.assertTrue(VOrders.ordersGrid_txt(driver).getText().contains("Revision Needed"), "The order is not in the correct status"); //changed from Revision Needed
		
		// Click on the order from the orders grid
		perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, VOrderDetails.orderInformation_txt(), "id");
		
		// Get order information text
		history = VOrderDetails.orderInformation_txt(driver).getText();
		
		// Verify audit trail
		Assert.assertTrue(history.contains("History (Revision Needed)"), "History (Revision Needed) is missing from the order information");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFAMC)"), "Message from Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are additional Send Message notes from OriginatorEVF to test sync"), "This is a test message from EVFAMC on the XSite is missing from the order information");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser3)"), "Message from Appraiser (Automation Appraiser3) is missing from the order information");
		Assert.assertTrue(history.contains("These are even more additional Message notes from Appraiser3 testing unchecked sync status"), "These are even more additional Message notes from Appraiser3 testing unchecked sync status is missing from the order information");
		Assert.assertTrue(!history.contains("Revised Report delivered by Appraiser (Automation Appraiser3)"), "Revised Report delivered by Appraiser (Automation Appraiser3) is missing from the order information");
		Assert.assertTrue(!history.contains("This is another Message to the client for completing the order from Appraiser3 on Vendors"), "This is another Message to the client for completing the order from Appraiser3 on Vendors is missing from the order information");
		Assert.assertTrue(history.contains("Revision Needed by Client (Automation EVFAMC)"), "Revision Needed by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are more request revision notes from EVFAMC on Secure"), "These are more request revision notes from EVFAMC on Secure is missing from the order information");
		Assert.assertTrue(history.contains("Revision Request Cancelled by Client (Automation EVFAMC)"), "Revision Request Cancelled by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are cancel revision request notes from OriginatorEVF"), "These are cancel revision request notes from OriginatorEVF is missing from the order information");
		Assert.assertTrue(history.contains("Revision Needed by Client (Automation EVFAMC)"), "Revision Needed by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are request revision notes from EVFAMC on Secure"), "These are request revision notes from EVFAMC on Secure is missing from the order information");
		Assert.assertTrue(history.contains("Order delivered by Appraiser (Automation Appraiser3) and is now In QC - Level One"), "Order delivered by Appraiser (Automation Appraiser3) and is now In QC - Level One is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser3)"), "Message from Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser3"), "These are Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Complete by Appraiser (Automation Appraiser3)"), "Inspection Complete by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspected on"), "Inspected on is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Scheduled by Appraiser (Automation Appraiser3)"), "Inspection Scheduled by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection date is"), "Inspection date is is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFAMC)"), "Message from Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("This is a test message from EVFAMC on the XSite"), "This is a test message from EVFAMC on the XSite is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by AMC ("+amcCompany+")"), "Order Changed by AMC ("+amcCompany+") is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are EVFLender change fee comments"), "These are EVFLender change fee comments is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed by Client (Automation EVFAMC)"), "Vendor due date changed by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFLender change due date comments"), "These are EVFLender change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Fee Changed by Client (Automation EVFAMC)"), "Appraisal Fee Changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraisal fee changed from $350 to $525."), "Appraisal fee changed from $350 to $525. is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFAMC change fee comments"), "These are EVFAMC change fee comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed by Client (Automation EVFAMC)"), "Vendor due date changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the audit trail");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser3)"), "Message from Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Apostrophes License.pdf)"), "Document Uploaded from Appraiser (Automation Appraiser3) (Apostrophes License.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Test PDF_1.pdf)"), "Document Uploaded from Appraiser (Automation Appraiser3) (Test PDF_1.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Appraiser (Automation Appraiser3)"), "Resumed by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Appraiser (Automation Appraiser3)"), "Delayed by Appraiser (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order accepted by Appraiser (Automation Appraiser3) and In Progress"), "Order accepted by Appraiser (Automation Appraiser3) and In Progress is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation EVFAMC)"), "Comment - Action Required by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFAMC)"), "Message from Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(!history.contains("Document Uploaded from Client (Automation EVFAMC) (Test PDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC) (Test PDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Client (Automation EVFAMC)"), "Delayed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Client (Automation EVFAMC)"), "On Hold by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser3"), "Awaiting acceptance by Automation Appraiser3 is missing from the audit trail");
		
		// Verify new Due Date
		Assert.assertTrue(VOrderDetails.orderInformation_txt(driver).getText().contains(StoredVariables.getorderDueDateShort().get()), "New Due Date is not correct");
		
		// Verify fee
		Assert.assertTrue(VOrderDetails.orderInformation_txt(driver).getText().contains("$525"), "Fee should not have updated");
		
		// Get comments
		additionalComments = VOrderDetails.additionalComments_txt(driver).getText();
		
		// Verify both VMP and MN comments are displayed
		Assert.assertTrue(additionalComments.contains("These are edited comments by EVFAMC"), "Additional Comments section is missing info");
		
		// View Order Details
		vendors.verifyOrderDetails(driver);
		
		// Verify Document is in Documents
		documentText = VOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Report PDF"), "Report PDF did not sync to Vendors");
		Assert.assertTrue(documentText.contains("MISMO XML"), "MISMO XML did not sync to Vendors");
		Assert.assertTrue(documentText.contains("Other"), "Other did not sync to Vendors");
		Assert.assertTrue(documentText.contains("Market Information"), "Market Information did not sync to Vendors");
		Assert.assertTrue(!documentText.contains("Sales Contract"), "Sales Contract should not sync to Vendors");
		
		// Log in to Secure
		secure.login(driver, "EVFAMC", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, orderNumberAMC, "Tracking number");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("Appraisal Submission to FNM Not Successful"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, awsAccountsID + "-" + orderNumberAMC);
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Verify order details0
		secure.verifyResidentialAppraisalOrderDetails(driver);
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify the history
		Assert.assertTrue(history.contains("History (Revision Needed)"), "History (Revision Needed) is missing from the order information");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFAMC)"), "Message from Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are additional Send Message notes from OriginatorEVF to test sync"), "This is a test message from EVFAMC on the XSite is missing from the order information");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser3)"), "Message from Vendor (Automation Appraiser3) is missing from the order information");
		Assert.assertTrue(history.contains("These are even more additional Message notes from Appraiser3 testing unchecked sync status"), "These are even more additional Message notes from Appraiser3 testing unchecked sync status is missing from the order information");
		Assert.assertTrue(!history.contains("Revised Report delivered by Appraiser (Automation Appraiser3)"), "Revised Report delivered by Vendor (Automation Appraiser3) is missing from the order information");
		Assert.assertTrue(!history.contains("This is another Message to the client for completing the order from Appraiser3 on Vendors"), "This is another Message to the client for completing the order from Appraiser3 on Vendors is missing from the order information");
		Assert.assertTrue(history.contains("Revision Needed by Client (Automation EVFAMC)"), "Revision Needed by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are more request revision notes from EVFAMC on Secure"), "These are more request revision notes from EVFAMC on Secure is missing from the order information");
		Assert.assertTrue(history.contains("Revision Request Cancelled by Client (Automation EVFAMC)"), "Revision Request Cancelled by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are cancel revision request notes from OriginatorEVF"), "These are cancel revision request notes from OriginatorEVF is missing from the order information");
		Assert.assertTrue(history.contains("Revision Needed by Client (Automation EVFAMC)"), "Revision Needed by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are request revision notes from EVFAMC on Secure"), "These are request revision notes from EVFAMC on Secure is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Submission to FNM Not Successful"), "Appraisal Submission to FNM Not Successful is missing from the order information");
		Assert.assertTrue(history.contains("View FNM SSR"), "View FNM SSR is missing from the order information");
		Assert.assertTrue(history.contains("UCDP Document File ID Updated by Client (Automation EVFAMC)"), "UCDP Document File ID Updated by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("Note Added (Automation EVFAMC)"), "Note Added (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are internal notes from EVFAMC on Secure"), "These are internal notes from EVFAMC on Secure is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Submitted to FNM via UCDP by Client (Automation EVFAMC)"), "Appraisal Submitted to FNM via UCDP by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("Order delivered by Appraiser (Automation Appraiser3) and is now In QC - Level One"), "Order delivered by Vendor (Automation Appraiser3) and is now In QC - Level One is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser3)"), "Message from Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser3"), "These are Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Complete by Appraiser (Automation Appraiser3)"), "Inspection Complete by Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspected on"), "Inspected on is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Scheduled by Appraiser (Automation Appraiser3)"), "Inspection Scheduled by Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection date is"), "Inspection date is is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFAMC)"), "Message from Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("This is a test message from EVFAMC on the XSite"), "This is a test message from EVFAMC on the XSite is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by Client (Automation EVFAMC)"), "Order Changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are EVFLender change fee comments"), "These are EVFLender change fee comments is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed by Client (Automation EVFAMC)"), "Vendor due date changed by Client (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFLender change due date comments"), "These are EVFLender change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Fee Changed by Client (Automation EVFAMC)"), "Appraisal Fee Changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraisal fee changed from $350 to $525."), "Appraisal fee changed from $350 to $525. is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFAMC change fee comments"), "These are EVFAMC change fee comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed by Client (Automation EVFAMC)"), "Vendor due date changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the audit trail");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Appraiser (Automation Appraiser3)"), "Message from Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Apostrophes License.pdf)"), "Document Uploaded from Vendor (Automation Appraiser3) (Apostrophes License.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Appraiser (Automation Appraiser3) (Test PDF_1.pdf)"), "Document Uploaded from Vendor (Automation Appraiser3) (Test PDF_1.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Appraiser (Automation Appraiser3)"), "Resumed by Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Appraiser (Automation Appraiser3)"), "Delayed by Vendor (Automation Appraiser3) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order accepted by Appraiser (Automation Appraiser3) and In Progress"), "Order accepted by Vendor (Automation Appraiser3) and In Progress is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation EVFAMC)"), "Comment - Action Required by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFAMC)"), "Message from Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(!history.contains("Document Uploaded from Client (Automation EVFAMC) (Test PDF.pdf)"), "Document Uploaded from Client (Automation EVFAMC) (Test PDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Client (Automation EVFAMC)"), "Delayed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFAMC)"), "Resumed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Client (Automation EVFAMC)"), "On Hold by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation Appraiser3"), "Awaiting acceptance by Automation Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Reassigned by Client (Automation EVFAMC) to Automation Appraiser3"), "Reassigned by Client (Automation EVFAMC) to Automation Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by Client (Automation EVFAMC)"), "Order Changed by Client (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("To View Change History:"), "To View Change History: is missing from the audit trail");
		Assert.assertTrue(history.contains("Requires assignment"), "Requires assignment is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance"), "Awaiting acceptance is missing from the audit trail");
		
		// Verify new Due Date
		Assert.assertTrue(SOrderDetails.orderDue_txt(driver).getText().contains(StoredVariables.getorderDueDateShort().get()), "New Due Date is not correct");
		
		// Verify fee
		Assert.assertTrue(SOrderDetails.assignmentInformation_txt(driver).getText().contains("525"), "Fee should not have updated");
		
		// Verify Other Document is in Documents
		documentText = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Report PDF"), "Report PDF did not sync to Secure");
		Assert.assertTrue(documentText.contains("MISMO XML"), "MISMO XML did not sync to Secure");
		Assert.assertTrue(documentText.contains("Other"), "Other did not sync to Secure");
		Assert.assertTrue(documentText.contains("Market Information"), "Market Information did not sync to Secure");
		Assert.assertTrue(!documentText.contains("Sales Contract"), "Sales Contract should not sync to Secure");
		
		// Click Sync to VMP button
		perform.click(driver,SOrderDetails.syncToVMP_btn(driver));
		
		// Wait for Notes textbox
		perform.waitForElementToBeClickable(driver, SSyncToVMP.message_txtbx(), "id");
		
		// Verify message text
		Assert.assertTrue(SSyncToVMP.message_txtbx(driver).getAttribute("value").equals("These are even more additional Message notes from Appraiser3 testing unchecked sync status"), "The text in the message is not correct");
		
		// Click OK
		perform.click(driver,SSyncToVMP.ok_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);

		// View XSite order
		secure.viewXSiteOrderFromSecure(driver, "EVFLender", StoredVariables.getpassword().get(), StoredVariables.getloanID().get());
		
		// Get history text
		perform.waitForElementToBeVisible(driver, XOrders.toolbar(), "id");
		history = XOrders.history_txt(driver).getText();
		address = StoredVariables.getpropertyInformationAddress().get() + " " + StoredVariables.getpropertyInformationCity().get() + ", " + StoredVariables.getpropertyInformationStateAbbr().get() + " " + StoredVariables.getpropertyInformationZip().get();
		
		// Recapture the text from the history
		history = XOrders.history_txt(driver).getText();
		
		// Verify the history
		Assert.assertTrue(history.contains("History (Revision Needed)"), "History (Revision Needed) is missing from the order information");
		Assert.assertTrue(history.contains("Message (Automation EVFLender)"), "Message (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are even more additional Message notes from Appraiser3 testing unchecked sync status"), "These are even more additional Message notes from Appraiser3 testing unchecked sync status is missing from the order information");
		Assert.assertTrue(history.contains("Message (Automation OriginatorEVF)"), "Message (Automation OriginatorEVF) is missing from the order information");
		Assert.assertTrue(history.contains("These are additional Send Message notes from OriginatorEVF to test sync"), "This is a test message from EVFAMC on the XSite is missing from the order information");
		Assert.assertTrue(history.contains("Revision Request Cancelled (Automation OriginatorEVF)"), "Revision Request Cancelled (Automation OriginatorEVF) is missing from the order information");
		Assert.assertTrue(history.contains("These are cancel revision request notes from OriginatorEVF"), "These are cancel revision request notes from OriginatorEVF is missing from the order information");
		Assert.assertTrue(history.contains("Revision Needed (Automation EVFLender)"), "Revision Needed (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are more request revision notes from EVFAMC on Secure"), "These are more request revision notes from EVFAMC on Secure is missing from the order information");
		Assert.assertTrue(history.contains("Revision Request Cancelled (Automation OriginatorEVF)"), "Revision Request Cancelled (Automation OriginatorEVF) is missing from the order information");
		Assert.assertTrue(history.contains("These are cancel revision request notes from OriginatorEVF"), "These are cancel revision request notes from OriginatorEVF is missing from the order information");
		Assert.assertTrue(history.contains("Revision Needed (Automation EVFLender)"), "Revision Needed (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are request revision notes from EVFAMC on Secure"), "These are request revision notes from EVFAMC on Secure is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Submission to FNM Not Successful"), "Appraisal Submission to FNM Not Successful is missing from the order information");
		Assert.assertTrue(history.contains("View FNM SSR"), "View FNM SSR is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Submitted to FNM via UCDP"), "Appraisal Submitted to FNM via UCDP is missing from the order information");
		Assert.assertTrue(history.contains("UCDP Document File ID Updated (Automation EVFLender)"), "UCDP Document File ID Updated (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(!history.contains("Pending Quality Review (Automation EVFLender)"), "Order delivered by Vendor (Automation EVFAMC) and is now Pending Quality Review is missing from the order information");
		Assert.assertTrue(history.contains("Message (Automation EVFLender)"), "Message (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser3"), "These are Message notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Inspection Complete (Automation EVFLender)"), "Inspection Complete (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("Inspected on"), "Inspected on is missing from the order information");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Inspection Scheduled (Automation EVFLender)"), "Inspection Scheduled (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("Inspection date is"), "Inspection date is is missing from the order information");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Comment - Action Required (Automation EVFLender)"), "Comment - Action Required (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("This is an action required message by EVFAMC"), "This is an action required message by EVFAMC is missing from the order information");
		Assert.assertTrue(history.contains("Order Changed (Automation EVFLender)"), "Order Changed (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("Message (Automation EVFLender)"), "Message (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("This is a test message from EVFAMC on the XSite"), "This is a test message from EVFAMC on the XSite is missing from the order information");
		Assert.assertTrue(!history.contains("These are EVFLender change fee comments"), "These are EVFLender change fee comments is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFLender change due date comments"), "These are EVFLender change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed (Automation EVFLender)"), "Vendor due date changed (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the order information");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Message (Automation EVFLender)"), "Message (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Document Uploaded (Automation EVFLender) (Test PDF_1.pdf)"), "Document Uploaded (Automation EVFLender) (Test PDF_1.pdf) is missing from the order information");
		Assert.assertTrue(history.contains("Resumed (Automation EVFLender)"), "Resumed (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Delayed (Automation EVFLender)"), "Delayed (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the order information");
		Assert.assertTrue(history.contains("Vendor Accepted Assignment (Automation EVFLender)"), "Vendor Accepted Assignment (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the order information");
		Assert.assertTrue(history.contains("Resumed (Automation EVFLender)"), "Resumed (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required (Automation OriginatorEVF)"), "Comment - Action Required (Automation OriginatorEVF) is missing from the order information");
		Assert.assertTrue(history.contains("Comment - Action Required for " + address), "Comment - Action Required for " + address + " is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message (Automation OriginatorEVF)"), "Message (Automation OriginatorEVF) is missing from the audit trail");
		Assert.assertTrue(history.contains("Order message for " + address), "Order message for " + address + " is missing from the order information");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded (Automation OriginatorEVF) (TestPDF.pdf)"), "Document Uploaded (Automation OriginatorEVF) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded (Automation OriginatorEVF) (Test PDF.pdf)"), "Document Uploaded (Automation OriginatorEVF) (Test PDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed (Automation OriginatorEVF)"), "Delayed (Automation OriginatorEVF) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed (Automation OriginatorEVF)"), "Resumed (Automation OriginatorEVF) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold (Automation OriginatorEVF)"), "On Hold (Automation OriginatorEVF) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the order information");
		Assert.assertTrue(history.contains("In Progress (Automation OriginatorEVF)"), "In Progress (Automation OriginatorEVF) is missing from the audit trail");
		
		// Verify order details
		perform.verifyXSiteOrderDetailsForLender(driver);
		
		// Verify documents
		documentsText = XOrders.documents_txt(driver).getText();
		Assert.assertTrue(documentsText.contains("Other"), "Other document is missing from the documents section of the XSite");
		Assert.assertTrue(documentsText.contains("TestPDF"), "TestPDF document is missing from the documents section of the XSite");
		Assert.assertTrue(documentsText.contains("Test PDF_1"), "TestPDF document is missing from the documents section of the XSite");
		Assert.assertTrue(documentsText.contains("Sales Contract"), "Sales Contract document is missing from the documents section of the XSite");
		Assert.assertTrue(documentsText.contains("Test PDF"), "Test PDF document is missing from the documents section of the XSite");
		Assert.assertTrue(!documentsText.contains("Apostrophes License"), "Apostrophes License should not sync to the XSite");
		Assert.assertTrue(!documentsText.contains("No UAD Hard Stops.xml"), "No UAD Hard Stops.xml should not sync to the XSite");
		
		// Verify comments
		comments = XOrders.comments_txt(driver).getText();
		Assert.assertTrue(comments.contains("These are test additional comments"), "Additional Comments section is missing info");
		
		// Verify new Due Date
		Assert.assertTrue(XOrders.dueDate_txt(driver).getText().equals(StoredVariables.getorderDueDateShort().get()), "New Due Date is not correct - It is: " + XOrders.dueDate_txt(driver).getText() + ", but should be: " + StoredVariables.getorderDueDateShort().get());
		
		// Verify fee
		Assert.assertTrue(XOrders.fee_txt(driver).getText().equals("$350.00"), "Fee should not update");
		
		// Close XSite order
		perform.closeNewWindow(driver);

		// Login to VMP Client Portal
		vmp.login(driver, "EVFLender", "OriginatorEVF", StoredVariables.getpassword().get());
		
		// Search for order
		vmp.findOrder(driver, StoredVariables.getloanIDVMP().get(), "Tracking #");
		
		// Wait for db to update order status on Secure
		vmp.waitForDBUpdateForOrderStatus(driver, "Revision Needed");
		
		// Verify Order Status
		Assert.assertTrue(VMPOrders.orderStatus_txt(driver).getText().equals("Revision Needed"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());
		
		Thread.sleep(1500);
		
		// Wait for Edit Property Contacts link
		perform.waitForElementToBeClickable(driver, VMPAppraisalOrderDetails.editPropertyContacts_lnk(), "id");
		
		// Verify the audit trail
		history = VMPAppraisalOrderDetails.history_txt(driver).getText();

		Assert.assertTrue(history.contains("Message by Automation EVFLender"), "Message by Automation EVFLender is missing from the order information");
		Assert.assertTrue(history.contains("These are even more additional Message notes from Appraiser3 testing unchecked sync status"), "These are even more additional Message notes from Appraiser3 testing unchecked sync status is missing from the order information");
		Assert.assertTrue(history.contains("Message by Automation OriginatorEVF"), "Message by Automation OriginatorEVF is missing from the order information");
		Assert.assertTrue(history.contains("These are additional Send Message notes from OriginatorEVF to test sync"), "This is a test message from EVFAMC on the XSite is missing from the order information");
		Assert.assertTrue(history.contains("Revision Needed by Automation EVFLender"), "Revision Needed by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are more request revision notes from EVFAMC on Secure"), "These are more request revision notes from EVFAMC on Secure is missing from the audit trail");
		Assert.assertTrue(history.contains("Revision Request Cancelled by Automation OriginatorEVF"), "Revision Request Cancelled by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are cancel revision request notes from OriginatorEVF"), "These are cancel revision request notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Revision Needed by Automation EVFLender"), "Revision Needed by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are request revision notes from EVFAMC on Secure"), "These are request revision notes from EVFAMC on Secure is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraisal Submission to FNM Not Successful by Automation EVFLender"), "Appraisal Submission to FNM Not Successful by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("View FNM SSR"), "View FNM SSR is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraisal Submitted to FNM via UCDP by Automation EVFLender"), "Appraisal Submitted to FNM via UCDP by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("UCDP Document File ID Updated by Automation EVFLender"), "UCDP Document File ID Updated by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(!history.contains("Pending Quality Review by Automation EVFLender"), "Pending Quality Review by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation EVFLender"), "Message by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser3"), "These are Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Complete by Automation EVFLender"), "Inspection Complete by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspected on"), "Inspected on is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Scheduled by Automation EVFLender"), "Inspection Scheduled by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection date is"), "Inspection date is is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Automation EVFLender"), "Comment - Action Required by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("This is an action required message by EVFAMC"), "This is an action required message by EVFAMC is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by Automation EVFLender"), "Order Changed by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by Automation EVFLender"), "Order Changed by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation EVFLender"), "Message by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("This is a test message from EVFAMC on the XSite"), "This is a test message from EVFAMC on the XSite is missing from the audit trail");
		Assert.assertTrue(!history.contains("These are EVFLender change fee comments"), "These are EVFLender change fee comments is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed by Automation EVFLender"), "Vendor due date changed by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the audit trail");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFLender change due date comments"), "These are EVFLender change due date comments is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation EVFLender"), "Message by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation EVFLender"), "Document Uploaded by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("Other"), "Other is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF_1.pdf"), "Test PDF_1.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation EVFLender"), "Resumed by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation EVFLender"), "Delayed by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraiser Accepted Assignment by Automation EVFLender"), "Appraiser Accepted Assignment by Automation EVFLender is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorEVF"), "Resumed by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Automation OriginatorEVF"), "Comment - Action Required by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message by Automation OriginatorEVF"), "Message by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorEVF"), "Document Uploaded by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Other"), "Other is missing from the audit trail");
		Assert.assertTrue(history.contains("TestPDF.pdf"), "TestPDF.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded by Automation OriginatorEVF"), "Document Uploaded by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Sales Contract"), "Sales Contract is missing from the audit trail");
		Assert.assertTrue(history.contains("Test PDF.pdf"), "Test PDF.pdf is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Automation OriginatorEVF"), "Delayed by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Automation OriginatorEVF"), "Resumed by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Automation OriginatorEVF"), "On Hold by Automation OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("In Progress by Automation OriginatorEVF"), "In Progress by Automation OriginatorEVF is missing from the audit trail");
		
		// Verify new Due Date
		Assert.assertTrue(VMPAppraisalOrderDetails.orderDetails_txt(driver).getText().contains(StoredVariables.getorderDueDateShort().get()), "New Due Date is not correct");
		
		// Verify fee
		Assert.assertTrue(VMPAppraisalOrderDetails.orderDetails_txt(driver).getText().contains("$350"), "Fee should not update");
		
		// Verify the order details
		vmp.verifyAppraisalOrderDetails(driver);
		
		// Verify Document is in Documents
		documentText = VMPAppraisalOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Other"), "Other document is not displayed in VMP Client Portal");
		Assert.assertTrue(documentText.contains("Sales Contract"), "Sales Contract did not sync to VMP Client Portal");
		Assert.assertTrue(!documentText.contains("Market Information"), "Market Information should not sync to VMP Client Portal");
		Assert.assertTrue(!documentText.contains("MISMO XML"), "MISMO XML should not sync to VMP Client Portal");
		Assert.assertTrue(!documentText.contains("Report PDF"), "Report PDF should not sync to VMP Client Portal");
		
		// Click on Sales Contract
		perform.clickInTable_Contains(driver, "Sales Contract");
		
		// Wait for text to update
		perform.waitForText(driver, VMPAppraisalOrderDetails.documents_txt(driver), "Test PDF.pdf");
		documentText = VMPAppraisalOrderDetails.documents_txt(driver).getText();
		
		// Verify file name and uploaded by
		Assert.assertTrue(documentText.contains("Test PDF.pdf"), "Document name is incorrect in Documents");
		Assert.assertTrue(documentText.contains("Automation OriginatorEVF"), "Uploaded By is incorrect in Documents");
		
		// Create boolean for both Other documents
		originator = false;
		lender = false;
		
		// Get Number Of Other documents
		docs = driver.findElements(By.xpath("//td[text()='Other']"));
		for (WebElement doc: docs)
		{
			
			// Click first Other document
			perform.click(driver,doc);
			
			Thread.sleep(3000);
			
			documentText = VMPAppraisalOrderDetails.documents_txt(driver).getText();
			
			// Wait for text
			perform.waitForText(driver, VMPAppraisalOrderDetails.documents_txt(driver), "Automation");
			
			if (documentText.contains("Automation OriginatorEVF") && originator == false)
			{
				// Verify Uploaded By and Document Name
				Assert.assertTrue(documentText.contains("TestPDF.pdf"), "TestPDF.pdf is not showing as the Document Name in Order Documents");
				originator = true;
			}
			
			else if (documentText.contains("Automation EVFLender") && lender == false)
			{
				// Verify Uploaded By and Document Name
				Assert.assertTrue(documentText.contains("Test PDF_1.pdf"), "Test PDF_1.pdf is not showing as the Document Name in Order Documents");
				lender = true;
			}
				
		} // end for loop
		
		Assert.assertTrue(originator==true, "The Other document uploaded by Automation OriginatorEVF is not displaying");
		Assert.assertTrue(lender==true, "The Other document uploaded by Automation EVFLender is not displaying");
		
		// Log in to Secure
		secure.login(driver, "EVFLender", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, StoredVariables.getloanID().get(), "Tracking number");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("Revision Needed"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, awsAccountsID + "-" + StoredVariables.getloanID().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Verify order details
		secure.verifyResidentialAppraisalOrderDetails(driver);
		
		// Get history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Verify the history
		Assert.assertTrue(history.contains("History (Revision Needed)"), "History (Revision Needed) is missing from the order information");
		Assert.assertTrue(history.contains("Message from AMC (" + amcCompany + ")"), "Message from Vendor (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are even more additional Message notes from Appraiser3 testing unchecked sync status"), "These are even more additional Message notes from Appraiser3 testing unchecked sync status is missing from the order information");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFLender)"), "Message from Client (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are additional Send Message notes from OriginatorEVF to test sync"), "This is a test message from EVFAMC on the XSite is missing from the order information");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFLender)"), "Message from Client (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are additional Send Message notes from OriginatorEVF to test sync"), "These are additional Send Message notes from OriginatorEVF to test sync is missing from the order information");
		Assert.assertTrue(history.contains("Revision Needed by AMC (" + amcCompany + ")"), "Revision Needed by Vendor (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are more request revision notes from EVFAMC on Secure"), "These are more request revision notes from EVFAMC on Secure is missing from the order information");
		Assert.assertTrue(history.contains("Revision Request Cancelled by Client (Automation EVFLender)"), "Revision Request Cancelled by Client (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are cancel revision request notes from OriginatorEVF"), "These are cancel revision request notes from OriginatorEVF is missing from the order information");
		Assert.assertTrue(history.contains("Revision Needed by AMC (" + amcCompany + ")"), "Revision Needed by Vendor (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are request revision notes from EVFAMC on Secure"), "These are request revision notes from EVFAMC on Secure is missing from the order information");
		Assert.assertTrue(history.contains("View FNM SSR"), "View FNM SSR is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Submission to FNM Not Successful"), "Appraisal Submission to FNM Not Successful is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Submitted to FNM via UCDP by AMC (" + amcCompany + ")"), "Appraisal Submitted to FNM via UCDP by Vendor (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("UCDP Document File ID Updated by AMC (" + amcCompany + ")"), "UCDP Document File ID Updated by Vendor (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("Order delivered by AMC (" + amcCompany + ") and is now Pending Quality Review"), "Order delivered by Vendor (Automation EVFAMC) and is now Pending Quality Review is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from AMC (" + amcCompany + ")"), "Message from Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser3"), "These are Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Complete by AMC (" + amcCompany + ")"), "Inspection Complete by Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspected on"), "Inspected on is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Scheduled by AMC (" + amcCompany + ")"), "Inspection Scheduled by Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection date is"), "Inspection date is is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by AMC (" + amcCompany + ")"), "Comment - Action Required by Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("This is an action required message by EVFAMC"), "This is an action required message by EVFAMC is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from AMC (" + amcCompany + ")"), "Message from Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("This is a test message from EVFAMC on the XSite"), "This is a test message from EVFAMC on the XSite is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by AMC (" + amcCompany + ")"), "Order Changed by Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraisal Fee Changed by Client (Automation EVFLender)"), "Appraisal Fee Changed by Client (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal fee changed from $0 to $673"), "Appraisal fee changed from $0 to $673 is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFLender change fee comment"), "These are EVFLender change fee comment is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed by Client (Automation EVFLender)"), "Vendor due date changed by Client (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the order information");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFLender change due date comments"), "These are EVFLender change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed by AMC (" + amcCompany + ")"), "Vendor due date changed by Vendor (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the order information");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the audit trail");
		Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Message from AMC (" + amcCompany + ")"), "Message from Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from AMC (" + amcCompany + ") (Test PDF_1.pdf)"), "Document Uploaded from Vendor (Automation EVFAMC) (Test PDF_1.pdf)�is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by AMC (" + amcCompany + ")"), "Resumed by Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by AMC (" + amcCompany + ")"), "Delayed by Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraiser Accepted assignment"), "Appraiser Accepted assignment is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFLender)"), "Resumed by Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required by Client (Automation EVFLender)"), "Comment - Action Required by Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message from Client (Automation EVFLender)"), "Message from Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFLender) (TestPDF.pdf)"), "Document Uploaded from Client (Automation EVFLender) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded from Client (Automation EVFLender) (Test PDF.pdf)"), "Document Uploaded from Client (Automation EVFLender) (Test PDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed by Client (Automation EVFLender)"), "Delayed by Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed by Client (Automation EVFLender)"), "Resumed by Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold by Client (Automation EVFLender)"), "On Hold by Client (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed by AMC (" + amcCompany + ")"), "Order Changed by Vendor (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Order accepted by AMC (" + amcCompany + ") and In Progress"), "Order accepted by Vendor (Automation EVFAMC) and In Progress is missing from the audit trail");
		Assert.assertTrue(history.contains("Order automatically accepted."), "Order automatically accepted. is missing from the audit trail");
		Assert.assertTrue(history.contains("Order automatically assigned"), "Order automatically assigned is missing from the audit trail");
		Assert.assertTrue(history.contains("Assigned to Automation"), "Assigned to Automation EVFAMC is missing from the audit trail");
		
		// Verify new Due Date
		Assert.assertTrue(SOrderDetails.orderDue_txt(driver).getText().contains(StoredVariables.getorderDueDateShort().get()), "New Due Date is not correct");
		
		// Verify fee
		Assert.assertTrue(SOrderDetails.assignmentInformation_txt(driver).getText().contains("673"), "Fee should have updated");
		
		// Verify Other Document is in Documents
		documentText = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(!documentText.contains("Market Information"), "Market Information should not sync to Secure");
		Assert.assertTrue(!documentText.contains("MISMO XML"), "MISMO XML should not sync to Secure");
		Assert.assertTrue(!documentText.contains("Report PDF"), "Report PDF should not sync to Secure");
		Assert.assertTrue(documentText.contains("Other"), "Other did not sync to Secure");
		Assert.assertTrue(documentText.contains("Sales Contract"), "Sales Contract did not sync to Secure");
		
		// Verify Sales ContractDocument is in Documents
		documentText = SOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(documentText.contains("Sales Contract"), "Sales Contract did not sync to Secure");
		
		// Click on Sales Contract
		perform.clickInTable_Contains(driver, "Sales Contract");
		
		// Wait for text to update
		perform.waitForText(driver, SOrderDetails.documents_txt(driver), "Test PDF.pdf");
		documentText = SOrderDetails.documents_txt(driver).getText();
		
		// Verify file name and uploaded by
		Assert.assertTrue(documentText.contains("Test PDF.pdf"), "Document name is incorrect in Documents");
		Assert.assertTrue(documentText.contains("Automation EVFLender"), "Uploaded By is incorrect in Documents");
		
		// Create boolean for both Other documents
		amc = false;
		lender = false;
		
		// Get Number Of Other documents
		docs = driver.findElements(By.xpath("//td[text()='Other']"));
		for (WebElement doc: docs)
		{
			
			// Click first Other document
			perform.click(driver,doc);
			
			Thread.sleep(3000);
			
			documentText = SOrderDetails.documents_txt(driver).getText();
			
			// Wait for text
			perform.waitForText(driver, SOrderDetails.documents_txt(driver), "Automation");
			
			if (documentText.contains("Automation EVFAMC") && amc == false)
			{
				// Verify Uploaded By and Document Name
				Assert.assertTrue(documentText.contains("Test PDF_1.pdf"), "Test PDF_1.pdf is not showing as the Document Name in Order Documents");
				amc = true;
			}
			
			else if (documentText.contains("Automation EVFLender") && lender == false)
			{
				// Verify Uploaded By and Document Name
				Assert.assertTrue(documentText.contains("TestPDF.pdf"), "TestPDF.pdf is not showing as the Document Name in Order Documents");
				lender = true;
			}
				
		} // end for loop
		
		Assert.assertTrue(amc==true, "The Other document uploaded by Automation EVFAMC is not displaying");
		Assert.assertTrue(lender==true, "The Other document uploaded by Automation EVFLender is not displaying");
		
		// View XSite order
		secure.viewXSiteOrderFromSecure(driver, "EVFAMC", StoredVariables.getpassword().get(), orderNumberAMC);
		
		// Get history text
		perform.waitForElementToBeVisible(driver, XOrders.toolbar(), "id");
		history = XOrders.history_txt(driver).getText();
		address = StoredVariables.getpropertyInformationAddress().get() + " " + StoredVariables.getpropertyInformationCity().get() + ", " + StoredVariables.getpropertyInformationStateAbbr().get() + " " + StoredVariables.getpropertyInformationZip().get();
		
		// Verify the history
		Assert.assertTrue(history.contains("History (Revision Needed)"), "History (Revision Needed) is missing from the order information");
		Assert.assertTrue(history.contains("Message (Automation EVFAMC)"), "Message (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are even more additional Message notes from Appraiser3 testing unchecked sync status"), "These are even more additional Message notes from Appraiser3 testing unchecked sync status is missing from the order information");
		Assert.assertTrue(history.contains("Message (Automation EVFLender)"), "Message (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are additional Send Message notes from OriginatorEVF to test sync"), "This is a test message from EVFAMC on the XSite is missing from the order information");
		Assert.assertTrue(history.contains("Message (Automation EVFLender)"), "Message (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are additional Send Message notes from OriginatorEVF to test sync"), "These are additional Send Message notes from OriginatorEVF to test sync is missing from the order information");
		Assert.assertTrue(history.contains("Revision Needed (Automation EVFAMC)"), "Revision Needed (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are more request revision notes from EVFAMC on Secure"), "These are more request revision notes from EVFAMC on Secure is missing from the order information");
		Assert.assertTrue(history.contains("Revision Request Cancelled (Automation EVFLender)"), "Revision Request Cancelled (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are cancel revision request notes from OriginatorEVF"), "These are cancel revision request notes from OriginatorEVF is missing from the order information");
		Assert.assertTrue(history.contains("Revision Needed (Automation EVFAMC)"), "Revision Needed (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("These are request revision notes from EVFAMC on Secure"), "These are request revision notes from EVFAMC on Secure is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Submission to FNM Not Successful"), "Appraisal Submission to FNM Not Successful is missing from the order information");
		Assert.assertTrue(history.contains("View FNM SSR"), "View FNM SSR is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal Submitted to FNM via UCDP"), "Appraisal Submitted to FNM via UCDP is missing from the order information");
		Assert.assertTrue(history.contains("UCDP Document File ID Updated (Automation EVFAMC)"), "UCDP Document File ID Updated (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("Pending Quality Review (Automation EVFAMC)"), "Pending Quality Review (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Message (Automation EVFAMC)"), "Message (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Message notes from Appraiser3"), "These are Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Complete (Automation EVFAMC)"), "Inspection Complete (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspected on"), "Inspected on is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Complete notes from Appraiser3"), "These are Inspection Complete notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection Scheduled (Automation EVFAMC)"), "Inspection Scheduled (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Inspection date is"), "Inspection date is is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes from Appraiser3"), "These are Inspection Scheduled notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required (Automation EVFAMC)"), "Comment - Action Required (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("This is an action required message by EVFAMC"), "This is an action required message by EVFAMC is missing from the audit trail");
		Assert.assertTrue(history.contains("Message (Automation EVFAMC)"), "Message (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("This is a test message from EVFAMC on the XSite"), "This is a test message from EVFAMC on the XSite is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed (Automation EVFAMC)"), "Order Changed (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraisal Fee Changed (Automation EVFLender)"), "Appraisal Fee Changed (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("Appraisal fee changed from $0 to $673"), "Appraisal fee changed from $0 to $673 is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFLender change fee comments"), "These are EVFLender change fee comments is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed (Automation EVFLender)"), "Vendor due date changed (Automation EVFLender) is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFLender change due date comments"), "These are EVFLender change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed (Automation EVFAMC)"), "Vendor due date changed (Automation EVFAMC) is missing from the order information");
		Assert.assertTrue(history.contains("Vendor due date changed from"), "Vendor due date changed from is missing from the order information");
		Assert.assertTrue(history.contains(StoredVariables.getcalendarDateShort().get()), StoredVariables.getcalendarDateShort().get() + " is missing from the order information");
		Assert.assertTrue(history.contains("These are EVFAMC change due date comments"), "These are EVFAMC change due date comments is missing from the order information");
		Assert.assertTrue(history.contains("Message (Automation EVFAMC)"), "Message (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are additional Message notes from Appraiser3"), "These are additional Message notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded (Automation EVFAMC) (Test PDF_1.pdf)"), "Document Uploaded (Automation EVFAMC) (Test PDF_1.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed (Automation EVFAMC)"), "Resumed (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume notes from Appraiser3"), "These are Resume notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed (Automation EVFAMC)"), "Delayed (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed notes from Appraiser3"), "These are Delayed notes from Appraiser3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraiser Accepted assignment by Appraiser"), "Appraiser Accepted assignment by Appraiser is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser3 accepting order notes"), "These are Appraiser3 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed (Automation EVFLender)"), "Resumed (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume2 test notes from OriginatorEVF"), "These are Resume2 test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required (Automation EVFLender)"), "Comment - Action Required (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("Comment - Action Required for " + address), "Comment - Action Required for " + address + " is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Action Required test notes from OriginatorEVF"), "These are Action Required test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Message (Automation EVFLender)"), "Message (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("Order message for " + address), "Order message for " + address + " is missing from the audit trail");
		Assert.assertTrue(history.contains("These are test Send Message notes from OriginatorEVF"), "These are test Send Message notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded (Automation EVFLender) (TestPDF.pdf)"), "Document Uploaded (Automation EVFLender) (TestPDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Document Uploaded (Automation EVFLender) (Test PDF.pdf)"), "Document Uploaded (Automation EVFLender) (Test PDF.pdf) is missing from the audit trail");
		Assert.assertTrue(history.contains("Delayed (Automation EVFLender)"), "Delayed (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Delayed test notes from OriginatorEVF"), "These are Delayed test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Resumed (Automation EVFLender)"), "Resumed (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Resume test notes from OriginatorEVF"), "These are Resume test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("On Hold (Automation EVFLender)"), "On Hold (Automation EVFLender) is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Place On Hold test notes from OriginatorEVF"), "These are Place On Hold test notes from OriginatorEVF is missing from the audit trail");
		Assert.assertTrue(history.contains("Order Changed (Automation EVFAMC)"), "Order Changed (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("To View Change History:"), "To View Change History: is missing from the audit trail");
		Assert.assertTrue(history.contains("In Progress (Automation EVFAMC)"), "In Progress (Automation EVFAMC) is missing from the audit trail");
		Assert.assertTrue(history.contains("Awaiting acceptance"), "Awaiting acceptance is missing from the audit trail");
		
		// Verify order details
		perform.verifyXSiteOrderDetailsForAMC(driver);
		
		// Verify documents
		perform.waitForText(driver, XOrders.documents_txt(driver), "Other");
		documentsText = XOrders.documents_txt(driver).getText();
		Assert.assertTrue(!documentsText.contains("Market Information"), "Market Information should not sync to Secure");
		Assert.assertTrue(!documentsText.contains("No UAD Hard Stops.xml"), "No UAD Hard Stops.xml should not sync to the XSite");
		Assert.assertTrue(documentsText.contains("Other"), "Other document is missing from the documents section of the XSite - " + documentsText);
		Assert.assertTrue(documentsText.contains("TestPDF"), "TestPDF document is missing from the documents section of the XSite - " + documentsText);
		Assert.assertTrue(documentsText.contains("Test PDF_1"), "Test PDF_1 document is missing from the documents section of the XSite - " + documentsText);
		Assert.assertTrue(documentsText.contains("Sales Contract"), "Sales Contract document is missing from the documents section of the XSite - " + documentsText);
		Assert.assertTrue(documentsText.contains("Test PDF"), "Test PDF document is missing from the documents section of the XSite - " + documentsText);
		
		// Verify comments
		comments = XOrders.comments_txt(driver).getText();
		Assert.assertTrue(comments.contains("These are edited comments by EVFAMC"), "Additional Comments section is missing info");
		
		// Verify new Due Date
		Assert.assertTrue(XOrders.dueDate_txt(driver).getText().equals(StoredVariables.getorderDueDateShort().get()), "New Due Date is not correct");
		
		// Verify fee
		Assert.assertTrue(XOrders.fee_txt(driver).getText().equals("$673.00"), "Fee should have updated");
		
		// Close XSite order
		perform.closeNewWindow(driver);

		// Log test
		test.log(LogStatus.INFO, "EVF", "Ran through the EVF martix");
	
	} // end viewSecondOrderDetailsOnXSiteAsAMC12
	
} // end the OrderManagement class
