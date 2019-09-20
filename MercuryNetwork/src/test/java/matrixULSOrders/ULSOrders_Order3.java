package matrixULSOrders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjects.Secure.SConfirmOrder;
import pageObjects.Secure.SOrderDetails;
import pageObjects.Secure.SOrders;
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
import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>ULS Orders - Order 3</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class ULSOrders_Order3 extends TestSetup {
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Go to VMP XSites</li>
	 * 	<li>Verify the dropdown is the correct VMP site</li>
	 * 	<li>Click Configure Status Mapping</li>
	 * 	<li>Enable all status mappings</li>
	 * 	<li>Click the Document Upload button</li>
	 * 	<li>Check every option for syncing</li>
	 * 	<li>Click OK</li>
	 * 	<li>Click the Pending Quality Review gear icon</li>
	 * 	<li>Uncheck Always include appraisal report</li>
	 * 	<li>Uncheck Attach appraisal report</li>
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
	 * 	<li>Verify Vendor Information is correct</li>
	 * 	<li>Click back</li>
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
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify order status</li>
	 * 	<li>Click on the order from the orders grid</li>
	 * 	<li>Click Accept/Decline button</li>
	 * 	<li>Enter notes</li>
	 * 	<li>Click OK</li>
	 * 	<li>Close Order Acknowledgement dialog</li>
	 * 	<li>Get order information text</li>
	 * 	<li>Set 40 second while loop timeout</li>
	 * 	<li>Verify audit trail</li>
	 * 	<li>If browser is IE, set require window focus capability to false</li>
	 * 	<li>if (StoredVariables.getbrowser().get().equals("IE"))</li>
	 * 	<li>{</li>
	 * 	<li>perform.IE_setRequireWindowFocusToFalse();</li>
	 * 	<li></li>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>vendors.login(driver, "Appraiser1", StoredVariables.getpassword().get());</li>
	 * 	<li></li>
	 * 	<li>Search for order</li>
	 * 	<li>vendors.findOrder(driver, StoredVariables.getorderNumber().get(), "Tracking Number");</li>
	 * 	<li></li>
	 * 	<li>Verify order status</li>
	 * 	<li>Assert.assertTrue(VOrders.ordersGrid_txt(driver).getText().contains("In Progress"), "The order is not in the correct status");</li>
	 * 	<li></li>
	 * 	<li>Click on the order from the orders grid</li>
	 * 	<li>perform.doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());</li>
	 * 	<li></li>
	 * 	<li>perform.waitForElementToBeVisible(driver, VOrderDetails.orderInformation_txt(), "id");</li>
	 * 	<li></li>
	 * 	<li>}</li>
	 * 	<li>Complete the order using the HTTP Post</li>
	 * 	<li>Verify Report is in the Order Documents pane</li>
	 * 	<li>Get order information text</li>
	 * 	<li>Verify audit trail</li>
	 * 	<li>Click Report PDF</li>
	 * 	<li>Verify Uploaded By and Document Name</li>
	 * 	<li>If browser is IE, re-establish capabilites</li>
	 * 	<li>if (StoredVariables.getbrowser().get().equals("IE"))</li>
	 * 	<li>{</li>
	 * 	<li>perform.IE_reEstablishCapabilities();</li>
	 * 	<li>}</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify Order Status</li>
	 * 	<li>Open order</li>
	 * 	<li>Check the Mark order as complete without updating XSite order</li>
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
	 * 	<li>Log in to VMP</li>
	 * 	<li>Search for order</li>
	 * 	<li>Verify order status</li>
	 * 	<li>Open order</li>
	 * 	<li>Verify history</li>
	 * 	<li>Verify there are no Document in Documents</li>
	 * 	<li>Log test</li>
* </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - VMP XSite Settings", "Secure - Configure Status Mapping", "Secure - Vendor Selection Settings", "VMP - Create Order", "VMP - Orders", "Secure - Orders", "Vendors - Orders", "Vendors - Accept Order", "Vendors - Complete Order"}, alwaysRun=true)
	public void order3() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Login to Secure
		secure.login(driver, "VMP3", StoredVariables.getpassword().get());
		
		// Go to VMP XSites
		secure.goToVMPXSites(driver);
		
		// Verify the dropdown is the correct VMP site
		secure.verifyXSiteURLDropdownValue(driver, "VMP3");
		
		// Click Configure Status Mapping
		perform.click(driver,SVMPXSites.configureStatusMapping_lnk(driver));
		
		// Wait for status mapping configuration text
		perform.waitForElementToBeVisible(driver, SVMPXSites.statusMappingConfiguration_txt(), "id");
		
		// Enable all status mappings
		perform.enableAllOptionsInStatusMappingConfiguration(driver);
		
		// Click the Document Upload button
		perform.click(driver,SVMPXSites.documentUploadedAppraiserClientGearIcon_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Check every option for syncing
		perform.enableAllCheckboxesToSyncToVMP(driver);

		// Click OK
		perform.click(driver,SVMPXSites.okSyncToVMPCheckboxesClient_btn(driver));
		
		// Click the Pending Quality Review gear icon
		perform.click(driver,SVMPXSites.pendingQualityReviewGearIcon_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for Always include checkbox
		perform.waitForElementToBeClickable(driver, SVMPXSites.alwaysIncludeAppraisalReport_chckbx(), "id");
		
		// Uncheck Always include appraisal report
		perform.uncheckCheckbox(driver, SVMPXSites.alwaysIncludeAppraisalReport_chckbx(driver));
		
		// Uncheck Attach appraisal report
		perform.uncheckCheckbox(driver, SVMPXSites.attachAppraisalReport_chckbx(driver));
		
		// Click OK
		List<WebElement> ok = driver.findElements(By.cssSelector(SVMPXSites.okSync_btn()));
		perform.click(driver,ok.get(1));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Click Save
		perform.clickInTable_Contains(driver, "Save");
		
		// Wait for save dialog to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for save dialog to be hidden 
		perform.waitForOverlayToBeHidden(driver);
		
		System.out.println("Verifying the database values");
		
		// Get the AWSAccountsID
		String getAWSAccountsIDSQL = "SELECT AWSAccountsID FROM ULSAccounts u JOIN Entities e ON u.AppraiserEntityID = e.EntityID "
				+ "WHERE CompanyName = 'Automation" + StoredVariables.getenvironment().get() + "VMP3' AND EntityTypeID = 1";		
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
		vmp.login(driver, "VMP3", "OriginatorVMP3", StoredVariables.getpassword().get());
		
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
		StoredVariables.getassignmentInformationAssignedTo().set("Automation OriginatorVMP3");
		
		// Enter New Order data
		vmp.enterNewOrder(driver);
		
		// Click Next
		perform.click(driver,VMPNewOrder.nextBottom_btn(driver));
		
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
		
		// Wait for Address text box
		perform.waitForElementToBeClickable(driver, VMPNewOrder.address_txtbx(), "id");
		
		vmp.verifyNewOrderInfo(driver);

		// Click Next
		perform.click(driver,VMPNewOrder.nextBottom_btn(driver));
		
		// Wait for next button
		perform.waitForElementToBeClickable(driver, VMPConfirmOrder.nextTop_btn(), "id");
		
		// Check the order information again
		vmp.verifyOrderDetails(driver);
		
		// Click Next
		perform.click(driver,VMPConfirmOrder.nextTop_btn(driver));
		
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
		db.getLoanIDsFromVMPClientPortalOrder(driver);
		
		// Search for order
		vmp.findOrder(driver, StoredVariables.getloanIDVMP().get(), "Tracking #");
		
		// Verify the order just created is in the orders grid 
		Assert.assertTrue(SOrders.ordersTable_txt(driver).getText().contains(StoredVariables.getAWSAccountsID().get() + "-" + StoredVariables.getloanIDVMP().get()), "New order is not displayed");

		// Verify data in the database
		db.verifyNewOrderDataInDB_All(driver, StoredVariables.getloanIDVMP().get());
		
		// Log in to Secure
		secure.login(driver, "VMP3", StoredVariables.getpassword().get());
		
		// Wait for Find text box
		perform.waitForElementToBeClickable(driver, SOrders.find_txtbx(), "id");
		
		// Search for order
		secure.findOrder(driver, StoredVariables.getloanID().get(), "Tracking number");
		
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
		Assert.assertTrue(historyText.contains("Reassigned by Client (Automation VMP3) to Automation Appraiser1"), "Reassigned by Client (Automation VMP3) to Automation Appraiser1 is missing from the audit trail");
		Assert.assertTrue(historyText.contains("Requires assignment"), "Requires assignment is missing from the audit trail");
		Assert.assertTrue(historyText.contains("Awaiting acceptance"), "Awaiting acceptance is missing from the audit trail");
		
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
		
		// Click Accept/Decline button
		perform.click(driver,VOrderDetails.acceptDecline_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for Select Action dropdown
		perform.waitForElementToBeClickable(driver, VOrderAcknowledgement.selectAction_dropdown(), "id");
		
		// Enter notes
		perform.type(driver,VOrderAcknowledgement.acceptAssignmentNotes_txtbx(driver), "These are Appraiser1 accepting order notes");
		
		// Click OK
		perform.click(driver,VOrderAcknowledgement.ok_btn(driver));
		
		// Close Order Acknowledgement dialog
		vendors.closeOrderAcknowledgementDialog(driver);
		
		// Get order information text
		String orderInformation = VOrderDetails.orderInformation_txt(driver).getText();
		
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
		Assert.assertTrue(orderInformation.contains("Awaiting acceptance by Automation Appraiser1"), "Awaiting acceptance by Automation Appraiser1 is missing from the order information");
		
		// Complete the order using the HTTP Post
		vendors.completeOrderByHTTPPost(driver, "Appraiser1", StoredVariables.getpassword().get(), StoredVariables.getloanID().get(), "Complete.xml");
		
		// Verify Report is in the Order Documents pane
		String orderDocumentsText = VOrderDetails.documents_txt(driver).getText();
		Assert.assertTrue(orderDocumentsText.contains("Report PDF"), "Report PDF is not showing in the Order Documents");
		Assert.assertTrue(orderDocumentsText.contains("Completed Report (Current)"), "Completed Report (Current) is not showing in the Order Documents");
		Assert.assertTrue(orderDocumentsText.contains(StoredVariables.gettodaysDateLong().get()), "The Date Uploaded is not showing in the Order Documents");

		// Get order information text
		orderInformation = VOrderDetails.orderInformation_txt(driver).getText();
		
		// Verify audit trail
		Assert.assertTrue(orderInformation.contains("History (In QC - Level One)"), "History (In QC - Level One) is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Order delivered by Appraiser (Automation Appraiser1) and is now In QC - Level One"), "Order delivered by Appraiser (Automation Appraiser1) and is now In QC - Level One is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Order accepted by Appraiser (Automation Appraiser1) and In Progress"), "Order accepted by Appraiser (Automation Appraiser1) and In Progress is missing from the order information");
		Assert.assertTrue(orderInformation.contains("These are Appraiser1 accepting order notes"), "These are Appraiser1 accepting order notes is missing from the order information");
		Assert.assertTrue(orderInformation.contains("Awaiting acceptance by Automation Appraiser1"), "Awaiting acceptance by Automation Appraiser1 is missing from the order information");
		
		// Click Report PDF
		perform.clickInTable_Contains(driver, "Report PDF");
		
		// Wait for text
		perform.waitForText(driver, VOrderDetails.documents_txt(driver), "Automation Appraiser1");
		orderDocumentsText = VOrderDetails.documents_txt(driver).getText();
		
		// Verify Uploaded By and Document Name
		Assert.assertTrue(orderDocumentsText.contains("Test PDF.pdf"), "Test PDF.pdf is not showing as the Document Name in Order Documents");
		Assert.assertTrue(orderDocumentsText.contains("Automation Appraiser1"), "Automation Appraiser1 is not showing as the Document Name in Order Documents");
		
		// Log in to Secure
		secure.login(driver, "VMP3", StoredVariables.getpassword().get());
		
		// Search for order
		secure.findOrder(driver, StoredVariables.getloanID().get(), "Tracking number");
		
		// Verify Order Status
		Assert.assertTrue(SOrders.orderStatus_txt(driver).getText().equals("In QC - Level One"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getAWSAccountsID().get() + "-" + StoredVariables.getloanID().get());
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Check the Mark order as complete without updating XSite order
		if (!SOrderDetails.markOrderAsCompleteWithoutSyncingToXSite_chkbx(driver).isSelected())
		{
			perform.click(driver,SOrderDetails.markOrderAsCompleteWithoutSyncingToXSite_chkbx(driver));
		}
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SOrderDetails.okProcessReceivedReport_btn(), "id");
		
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
			Assert.assertTrue(SVerifyCertificateInformation.borrowerName_txtbx(driver).getAttribute("value").equals(StoredVariables.getassignmentInformationOrderedBy().get()+"-"+StoredVariables.getborrowerIdentifier().get()), "Borrower Name field is incorrect");
			
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
			
		}
		
		// Wait for Find textbox
		perform.waitForElementToBeClickable(driver, SOrders.find_txtbx(), "id");
		

		// Log in to VMP
		vmp.login(driver, "VMP3", "OriginatorVMP3", StoredVariables.getpassword().get());
		
		// Search for order
		vmp.findOrder(driver, StoredVariables.getloanIDVMP().get(), "Tracking #");
		
		// Verify order status
		Assert.assertTrue(VMPOrders.orderStatus_txt(driver).getText().equals("Pending Quality Review"), "The order is not in the correct status");
		
		// Open order
		perform.doubleClickInTable(driver, StoredVariables.getAWSAccountsID().get() + "-" + StoredVariables.getloanIDVMP().get());
		
		// Wait for Other Actions button
		perform.waitForElementToBeVisible(driver, VMPAppraisalOrderDetails.otherActions_btn(), "cssSelector");
		
		// Verify history
		String history = VMPAppraisalOrderDetails.history_txt(driver).getText();
		Assert.assertTrue(history.contains("Pending Quality Review by Automation VMP3"), "Pending Quality Review by Automation VMP3 is missing from the audit trail");
		Assert.assertTrue(history.contains("Appraiser Accepted Assignment by Automation VMP3"), "Appraiser Accepted Assignment by Automation VMP3 is missing from the audit trail");
		Assert.assertTrue(history.contains("These are Appraiser1 accepting order notes"), "These are Appraiser1 accepting order notes is missing from the audit trail");
		Assert.assertTrue(history.contains("In Progress by Automation OriginatorVMP3"), "In Progress by Automation OriginatorVMP3 is missing from the audit trail");
		
		// Verify there are no Document in Documents
		Assert.assertTrue(!VMPAppraisalOrderDetails.documents_txt(driver).getText().contains("Report PDF"), "Documents area is showing and shouldn't be");
		
		// Log test
		test.log(LogStatus.INFO, "ULS Orders", "Ran through the ULS Orders martix");
		
	} // end verifyOrderCompleteNotOnVMPClientPortal
	
} // end the ULSOrders_Order3 class
