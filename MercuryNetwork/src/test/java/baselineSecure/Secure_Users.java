package baselineSecure;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Secure.SAccount;
import pageObjects.Secure.SConfirmOrder;
import pageObjects.Secure.SFeePanel;
import pageObjects.Secure.SNewOrder;
import pageObjects.Secure.SOrderDetails;
import pageObjects.Secure.SOrders;
import pageObjects.Secure.SPreferences;
import pageObjects.Secure.SSendViaSureReceipts;
import pageObjects.Secure.SSetOrderStatus;
import pageObjects.Secure.SSubmitToFHA;
import pageObjects.Secure.SSubmitToUCDP;
import pageObjects.Secure.SUsers;
import pageObjects.Secure.SVendorSelectionSettings;
import pageObjects.Vendors.VOrderDetails;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Baseline Secure - Users</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class Secure_Users extends TestSetup {
	
	/** The user. */
	private static String user = "Baseline1";
	
	/** The email. */
	private static String email = "";

	/** The user VMP. */
	private final String userVMP = "automationQAOriginatorpermissions";
	
	/** The user secure. */
	private final String userSecure = "accessvmpxsite";
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Go to Users</li>
	 * 	<li>if user already exists, delete it</li>
	 * 	<li>Click Create New User</li>
	 * 	<li>Enter primary email</li>
	 * 	<li>Click password</li>
	 * 	<li>Enter Password</li>
	 * 	<li>Enter Retype password</li>
	 * 	<li>Click Save</li>
	 * 	<li>Click OK</li>
	 * 	<li>Enter Password</li>
	 * 	<li>Enter Retype password</li>
	 * 	<li>Click Save</li>
	 * 	<li>Enter First Name</li>
	 * 	<li>Enter Last Name</li>
	 * 	<li>Click Save</li>
	 * 	<li>Verify user is displayed in Users</li>
	 * 	<li>Click Create New User</li>
	 * 	<li>Enter primary email</li>
	 * 	<li>Click password</li>
	 * 	<li>Enter Password</li>
	 * 	<li>Enter Retype password</li>
	 * 	<li>Click OK</li>
	 * 	<li>Enter First Name</li>
	 * 	<li>Enter Last Name</li>
	 * 	<li>Click Save</li>
	 * 	<li>Verify alert dialog text</li>
	 * 	<li>Click OK</li>
	 * 	<li>Verify user is displayed in Users</li>
	 * 	<li>Go to Users</li>
	 * 	<li>Delete sub user</li>
	 * 	<li>Log test</li>
	 * 	<li>Select user</li>
	 * 	<li>Click Delete User</li>
	 * 	<li>Click Yes</li>
	 * 	<li>Verify url</li>
	 * 	<li>Verify user is displayed in Users</li>
	 * </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Users", "Secure - Create Sub User", "Secure - Delete Sub User"}, alwaysRun=true)
	public void users() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		if (StoredVariables.getmobile().get()==false) {
		
			// Log in to Secure
			secure.login(driver, user, StoredVariables.getpassword().get());
			
			// Go to Users
			secure.goToUsers(driver);
			
			// if user already exists, delete it
			if (SUsers.users_txt(driver).getText().contains("Automation TestUser")) {
				deleteFirstSubUser(driver);
			} // end if
			
			// Click Create New User
			perform.click(driver, SUsers.createNewUser_btn(driver));
			
			// Wait for Primary Email textbox
			perform.waitForElementToBeClickable(driver, SUsers.primaryEmail_txtbx(), "id");
			
			// Enter primary email
			email = "automationtestuser" + perform.randomNumbers(driver, 15) + StoredVariables.getcatchAllDomain().get();
			perform.type(driver, SUsers.primaryEmail_txtbx(driver), email);
			
			// Click password
			perform.click(driver, SUsers.password_txtbx(driver));
			
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			// Enter Password
			perform.type(driver, SUsers.passwordSecurityOptions_txtbx(driver), "test");
			
			// Enter Retype password
			perform.type(driver, SUsers.confirmPasswordSecurityOptions_txtbx(driver), "test");
			
			// Click Save
			Assert.assertTrue(driver.findElementById("Dialogs_Dialogs_securityOptions_Save").isEnabled());
		    
			// Enter Password
			SUsers.passwordSecurityOptions_txtbx(driver).clear();
			perform.type(driver, SUsers.passwordSecurityOptions_txtbx(driver), "T3sting!");
			
			// Enter Retype password
			SUsers.confirmPasswordSecurityOptions_txtbx(driver).clear();
			perform.type(driver, SUsers.confirmPasswordSecurityOptions_txtbx(driver), "T3sting!");
			
			// Click Save
			perform.click(driver, SUsers.saveSecurityOptions_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			// Enter First Name
			perform.type(driver, SUsers.firstName_txtbx(driver), "Automation");
			
			// Enter Last Name
			perform.type(driver, SUsers.lastName_txtbx(driver), "TestUser");
			
			// Click Save
			perform.click(driver, SUsers.save_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			// Wait for User to be added
			perform.waitForText(driver, SUsers.users_txt(driver), "Automation TestUser");
			
			// Verify user is displayed in Users
			Assert.assertTrue(SUsers.users_txt(driver).getText().contains("Automation TestUser"), "The new created user is not displayed in the Users area");
			
			// Click Create New User
			perform.click(driver, SUsers.createNewUser_btn(driver));
			
			// Wait for Primary Email textbox
			perform.waitForElementToBeClickable(driver, SUsers.primaryEmail_txtbx(), "id");
			
			// Enter primary email
			perform.type(driver, SUsers.primaryEmail_txtbx(driver), email);
			
			// Click password
			perform.click(driver, SUsers.password_txtbx(driver));
			
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			// Enter Password
			SUsers.passwordSecurityOptions_txtbx(driver).clear();
			perform.type(driver, SUsers.passwordSecurityOptions_txtbx(driver), StoredVariables.getpassword().get());
			
			// Enter Retype password
			SUsers.confirmPasswordSecurityOptions_txtbx(driver).clear();
			perform.type(driver, SUsers.confirmPasswordSecurityOptions_txtbx(driver), StoredVariables.getpassword().get());
			
			// Click OK
			perform.click(driver, SUsers.saveSecurityOptions_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			// Enter First Name
			perform.type(driver, SUsers.firstName_txtbx(driver), "Automation");
			
			// Enter Last Name
			perform.type(driver, SUsers.lastName_txtbx(driver), "TestUser");
			
			// Click Save
			perform.click(driver, SUsers.save_btn(driver));
			
			// Wait for overlay
			perform.waitForOverlayToBeVisible(driver);
			
			// Verify alert dialog text
			Assert.assertTrue(SUsers.alertDialog_txt(driver).getText().contains("A sub-account already exists with this e-mail address."), "Error message is incorrect");
			
			// Click OK
			perform.click(driver, SUsers.okAlertDialog_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			perform.waitForText(driver, SUsers.users_txt(driver), "Automation TestUser");
			
			// Verify user is displayed in Users
			Assert.assertTrue(SUsers.users_txt(driver).getText().contains("Automation TestUser"), "The new created user is not displayed in the Users area");
			
			// Go to Users
			secure.goToUsers(driver);
			
			// Delete sub user
			deleteFirstSubUser(driver);
			
			// Log test
			test.log(LogStatus.INFO, "users", "Cretaed a new user");
			
		} else {
			
			// Log test
			test.log(LogStatus.INFO, "users", "Could not test on mobile due to dialog not opening when clicking password textbox");
			
		} // end if/else
		
	} // end users
	
	/**
	 * Delete first sub user.
	 *
	 * @param driver the driver
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void deleteFirstSubUser(RemoteWebDriver driver) throws InterruptedException, IOException {
		
		// Select user
		perform.click(driver, driver.findElement(By.cssSelector("#divAdminMain > table > tbody > tr > td.BlueBox > div.User.Ellipsis")));
		
		// Wait for delete button
		perform.waitForElementToBeClickable(driver, SUsers.deleteUser_btn(), "cssSelector");
		
		// Click Delete User
		perform.clickInTable_Contains(driver, "Delete User");
		
		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		// Click Yes
		perform.click(driver, SUsers.yesDeleteUser_btn(driver));
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().contains("UserManagement"), "The url is incorrect");
		
		// Verify user is displayed in Users
		Assert.assertTrue(!SUsers.users_txt(driver).getText().contains("Automation TestUser"), "The user was not deleted");
		
	} // end deleteFirstSubUser
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	  * 	<li>Log into Secure</li>
	  * 	<li>Go to the users tab</li>
	  * 	<li>Select a subuser</li>
	  * 	<li>Check Compliance Permission</li>
	  * 	<li>Click OK on Compliance Security Dialog</li>
	  * 	<li>}end if</li>
	  * 	<li>Check all permissions</li>
	  * 	<li>Save</li>
	  * 	<li>Check database</li>
	  * 	<li>Uncheck all permissions</li>
	  * 	<li>Check database</li>
	  * 	<li>}End database check</li>
	 * </ul>
	 * @throws Exception the exception
	 */
	
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Users", "Secure - Permissions", "Secure - User Permissions", "AR207"}, alwaysRun=true)
	public void checkMercuryRightsDataBase() throws Exception {
     
	    //Log into Secure
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		secure.login(driver, "databasecheck",StoredVariables.getpassword().get());
		
		//Go to the users tab
		secure.goToUsers(driver);
		
		//Select a subuser
		perform.click(driver, driver.findElement(By.cssSelector("#divAdminMain > table > tbody > tr > td.BlueBox > div.User.Ellipsis")));
		
		boolean verifyCheck = SUsers.compliancePermission_chkbx(driver).isSelected();
		if (verifyCheck == false) {
			//Check Compliance Permission
			perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Compliance"));    
		    
		    //Click OK on Compliance Security Dialog
			perform.click(driver, SUsers.complianceSecurityOk_btn(driver));
		}//end if 
		
		
		
		//Check all permissions
		
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Required to Use Fee Panel"));
		
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Place New Orders"));
		
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Auto Assignment Approval"));
		
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Mark Orders as Paid"));
		
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Edit/Update Orders"));
		
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Selection Settings (Per Order)"));
		
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Manage QuickLists"));
		
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Submit to AQM"));
		
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Manage Orders by Product"));
		
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"View/Manage Other Users' Orders"));
		
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Cover Vendor's Transaction Fee"));
		
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Rate Vendors"));
		
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Manage Orders by Folder"));
		
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Submit to UCDP"));
		
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Submit to FHA"));
		
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Access VMP XSite"));
		
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Mark Orders as Paid"));
		
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"UARR Configuration"));
		
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"AQM Settings"));
		
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Order Product Requirements"));
		
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"VMP XSites"));
		
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Vendor Selection"));
		
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Client Management"));
		
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Manage Fee Panel"));
		
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"View Management Reports"));
		
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Fee Panel (Read Only)"));
		
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Add/Manage User Accounts"));
		
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Add/Manage Connections"));
		
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Manage Account"));
		
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Manage Payments"));
		
		
		//Save
		secure.saveUsersSettings(driver);
		
		//Check database
	    databaseCheck(driver, "1");
		
	    
		//Uncheck all permissions
	    perform.uncheckCheckbox(driver, secure.getPermissionsCheckbox(driver,"Compliance"));  
	    
        perform.uncheckCheckbox(driver, secure.getPermissionsCheckbox(driver,"Place New Orders"));
		
		perform.uncheckCheckbox(driver, secure.getPermissionsCheckbox(driver,"Required to Use Fee Panel"));
		
		perform.uncheckCheckbox(driver, secure.getPermissionsCheckbox(driver,"Auto Assignment Approval"));
		
		perform.uncheckCheckbox(driver, secure.getPermissionsCheckbox(driver,"Mark Orders as Paid"));
		
		perform.uncheckCheckbox(driver, secure.getPermissionsCheckbox(driver,"Edit/Update Orders"));
		
		perform.uncheckCheckbox(driver, secure.getPermissionsCheckbox(driver,"Selection Settings (Per Order)"));
		
		perform.uncheckCheckbox(driver, secure.getPermissionsCheckbox(driver,"Manage QuickLists"));
		
		perform.uncheckCheckbox(driver, secure.getPermissionsCheckbox(driver,"Submit to AQM"));
		
		perform.uncheckCheckbox(driver, secure.getPermissionsCheckbox(driver,"Manage Orders by Product"));
		
		perform.uncheckCheckbox(driver, secure.getPermissionsCheckbox(driver,"View/Manage Other Users' Orders"));
		
		perform.uncheckCheckbox(driver, secure.getPermissionsCheckbox(driver,"Cover Vendor's Transaction Fee"));
		
		perform.uncheckCheckbox(driver, secure.getPermissionsCheckbox(driver,"Rate Vendors"));
		
		perform.uncheckCheckbox(driver, secure.getPermissionsCheckbox(driver,"Manage Orders by Folder"));
		
		perform.uncheckCheckbox(driver, secure.getPermissionsCheckbox(driver,"Submit to UCDP"));
		
		perform.uncheckCheckbox(driver, secure.getPermissionsCheckbox(driver,"Submit to FHA"));
		
		perform.uncheckCheckbox(driver, secure.getPermissionsCheckbox(driver,"Access VMP XSite"));
		
		perform.uncheckCheckbox(driver, secure.getPermissionsCheckbox(driver,"UARR Configuration"));
		
		perform.uncheckCheckbox(driver, secure.getPermissionsCheckbox(driver,"AQM Settings"));
		
		perform.uncheckCheckbox(driver, secure.getPermissionsCheckbox(driver,"Order Product Requirements"));
		
		perform.uncheckCheckbox(driver, secure.getPermissionsCheckbox(driver,"VMP XSites"));
		
		perform.uncheckCheckbox(driver, secure.getPermissionsCheckbox(driver,"Vendor Selection"));
		
		perform.uncheckCheckbox(driver, secure.getPermissionsCheckbox(driver,"Client Management"));
		
		perform.uncheckCheckbox(driver, secure.getPermissionsCheckbox(driver,"Manage Fee Panel"));
		
		perform.uncheckCheckbox(driver, secure.getPermissionsCheckbox(driver,"View Management Reports"));
		
		perform.uncheckCheckbox(driver, secure.getPermissionsCheckbox(driver,"Fee Panel (Read Only)"));
		
		perform.uncheckCheckbox(driver, secure.getPermissionsCheckbox(driver,"Add/Manage User Accounts"));
		
		perform.uncheckCheckbox(driver, secure.getPermissionsCheckbox(driver,"Add/Manage Connections"));
		
		perform.uncheckCheckbox(driver, secure.getPermissionsCheckbox(driver,"Manage Account"));
		
		perform.uncheckCheckbox(driver, secure.getPermissionsCheckbox(driver,"Manage Payments"));
		
		secure.saveUsersSettings(driver);
		
		//Check database
		databaseCheck(driver, "0");
		
		
	} // end the Secure_Login class
	   
	
	private void databaseCheck (RemoteWebDriver driver, String expectedValue) throws Exception {
		String EntityID="";
		String env = StoredVariables.getenvironment().get();
		if (env.equals("QA")) {
			EntityID = "1074809";
		}
		else if(env.equals("Live")) {
			EntityID = "5728550";
		}
		 String sqlStatement = "SELECT HasPermission FROM MercuryRights WHERE EntityID = "+ EntityID;
		    ArrayList<String> result = db.queryDBArray(driver, "Mercury", sqlStatement);
		    boolean hasKeyword = true;
		    for (String value : result) {
		    	System.out.println("Value: " + value);
		        if (!value.equals(expectedValue)) {
		            hasKeyword = false;
		            break;
		        } // end if
		    } // end for
			
		    Assert.assertTrue(hasKeyword, "Permissions not set to "+ expectedValue);
	}//End database check
	


	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log into Secure as the admin</li>
	 * 	<li>Go to the users tab</li>
	 * 	<li>Select SubUser</li>
	 * 	<li>Check Place New Orders permission</li>
	 * 	<li>Save</li>
	 * 	<li>Login as SubUser</li>
	 * 	<li>Click on the orders button</li>
	 * 	<li>Place new residential appraisal order</li>
	 * 	<li>Log into Secure as the admin</li>
	 * 	<li>Go back to the users tab</li>
	 * 	<li>Select SubUser</li>
	 * 	<li>Uncheck the 'Place new orders' permission</li>
	 * 	<li>Save</li>
	 * 	<li>Log in as the subuser</li>
	 * 	<li>Verify start New Order button is greyed out</li>
	 * </ul>
	 * @throws Exception the exception
	 */

	@Test (retryAnalyzer = Retry.class, groups={"Secure - Users", "Secure - Permissions", "Secure - User Permissions", "AR207"}, alwaysRun=true)
	public void placeNewOrdersPermission() throws Exception {

		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		//Log into Secure as the admin
		secure.login(driver, "userpermissions",StoredVariables.getpassword().get());

		// Go to Vendor Selection Settings
		secure.goToVendorSelectionSettings(driver);

		// Turn off Double-blind Communication switch
		if (!SVendorSelectionSettings.doubleBlind_switch(driver).getAttribute("src").contains("switchOff.png"))
		{
			perform.click(driver, SVendorSelectionSettings.doubleBlind_switch(driver));
		} //end if

		secure.switchOff(driver, SVendorSelectionSettings.automaticOrderAssignment_switch(driver));

		secure.switchOff(driver, SVendorSelectionSettings.unattendedOrderReassignment_switch(driver));

		// Save Preferences
		secure.saveVendorSelectionSettings(driver);

		//Go to the users tab
		secure.goToUsers(driver);

		//Select SubUser
		secure.selectSubUser(driver, "Place NewOrders");

		//Check Place New Orders Permission
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Place New Orders"));

		//Check Place New Orders permission
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Place New Orders"));
		
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"View/Manage Other Users' Orders"));

		//Save
		secure.saveUsersSettings(driver);

		//Login as SubUser
		secure.login(driver, "placeneworders",StoredVariables.getpassword().get());

		//Click on the orders button
		secure.goToOrders(driver);

		//Place new residential appraisal order
		secure.goToResidentialAppraisal(driver);

		//Log into Secure as the admin
		secure.login(driver, "userpermissions",StoredVariables.getpassword().get());

		//Go back to the users tab
		secure.goToUsers(driver);

		//Select SubUser
		secure.selectSubUser(driver, "Place NewOrders");

		//Uncheck the 'Place new orders' permission
		perform.uncheckCheckbox(driver, secure.getPermissionsCheckbox(driver,"Place New Orders"));

		//Save
		secure.saveUsersSettings(driver);

		//Log in as the subuser
		secure.login(driver, "placeneworders",StoredVariables.getpassword().get());

		//Verify start New Order button is greyed out
		perform.click(driver, SOrders.newDisabled_btn(driver));
        
		Assert.assertTrue(SOrders.newDisabled_btn(driver).getAttribute("class").contains("MenuBar_Item_Disabled"), "The New button is not disabled");

		
	}//End placeNewOrdersPermission
	
	
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log into Secure as the admin</li>
	 * 	<li>Go to the users tab</li>
	 * 	<li>Select SubUser</li>
	 * 	<li>Check Required to Use Fee Panel</li>
	 * 	<li>Save</li>
	 * 	<li>Login as Subuser</li>
	 * 	<li>Start New Residential Order</li>
	 * 	<li>Entered required data</li>
	 * 	<li>Click the Next Button</li>
	 * 	<li>Click ISS Ranked tab</li>
	 * 	<li>Verify button is disabled</li>
	 * 	<li>Clicked the Search tab</li>
	 * 	<li>Verify button is disabled</li>
	 * 	<li>Log into Secure as the admin</li>
	 * 	<li>Go to the users tab</li>
	 * 	<li>Select SubUser</li>
	 * 	<li>Check Required to Use Fee Panel</li>
	 * 	<li>Save</li>
	 * 	<li>Login as Subuser</li>
	 * 	<li>Start New Residential Order</li>
	 * 	<li>Entered required data and click Next</li>
	 * 	<li>Click the Next Button</li>
	 * 	<li>Click the ISS Ranked tab</li>
	 * 	<li>Verify the tab is not disabled</li>
	 * 	<li>Click the Search tab</li>
	 * 	<li>verify the Search Tab is no longer disabled</li>
	 * 	<li>} End requiredToUseFeePanelPermission</li>
     * </ul>
	 * @throws Exception the exception
	 */
	
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Users", "Secure - Permissions", "Secure - User Permissions", "AR207"}, alwaysRun=true)
	public void requiredToUseFeePanelPermission() throws Exception {
		
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		//Log into Secure as the admin
		secure.login(driver, "userpermissions",StoredVariables.getpassword().get());


		// Go to Vendor Selection Settings
		secure.goToVendorSelectionSettings(driver);

		// Turn off Double-blind Communication switch
		if (!SVendorSelectionSettings.doubleBlind_switch(driver).getAttribute("src").contains("switchOff.png"))
		{
			perform.click(driver, SVendorSelectionSettings.doubleBlind_switch(driver));
		} //end if

		secure.switchOff(driver, SVendorSelectionSettings.automaticOrderAssignment_switch(driver));

		secure.switchOff(driver, SVendorSelectionSettings.unattendedOrderReassignment_switch(driver));

		// Save Preferences
		secure.saveVendorSelectionSettings(driver);

		//Go to the users tab
		secure.goToUsers(driver);

		//Select SubUser
		secure.selectSubUser(driver, "Required Fee Panel");

		//Check Place New Orders Permission
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Place New Orders"));

		//Check Required to Use Fee Panel
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Required to Use Fee Panel"));
		
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"View/Manage Other Users' Orders"));

		//Save
		secure.saveUsersSettings(driver);

		//Login as Subuser
		secure.login(driver, "requiredfeepanel",StoredVariables.getpassword().get());
		
		//Start New Residential Order
		secure.goToResidentialAppraisal(driver);

		//Entered required data
		secure.setNewResidentialAppraisalOrderVariablesMinimum(driver);

		secure.enterNewResidentialAppraisalOrder(driver);

		//Click the Next Button
		perform.click(driver, SOrders.nextNewOrder_btn(driver));

		//Click ISS Ranked tab
		perform.click(driver, SOrders.issRanked_btn(driver));

		//Verify button is disabled
		Assert.assertTrue(SOrders.issRanked_btn(driver).getAttribute("class").contains("NewTab Disabled"), "The ISS Ranked Tab is not disabled");

		//Clicked the Search tab
		perform.click(driver, SOrders.feePanelSearch_btn(driver));

		//Verify button is disabled
		Assert.assertTrue(SOrders.feePanelSearch_btn(driver).getAttribute("class").contains("NewTab Disabled"), "The Search Tab is not disabled");

		//Log into Secure as the admin
		secure.login(driver, "userpermissions",StoredVariables.getpassword().get());

		//Go to the users tab
		secure.goToUsers(driver);

		//Select SubUser
		secure.selectSubUser(driver, "Required Fee Panel");

		//Check Required to Use Fee Panel
		perform.uncheckCheckbox(driver, secure.getPermissionsCheckbox(driver,"Required to Use Fee Panel"));
		
		//Check Place New Orders Permission
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver, "Place New Orders"));
		
		//Save
		secure.saveUsersSettings(driver);

		//Login as Subuser
		secure.login(driver, "requiredfeepanel",StoredVariables.getpassword().get());

		//Start New Residential Order
		secure.goToResidentialAppraisal(driver);

		//Entered required data and click Next
		secure.setNewResidentialAppraisalOrderVariablesMinimum(driver);

		secure.enterNewResidentialAppraisalOrder(driver);

		//Click the Next Button
		perform.click(driver, SOrders.nextNewOrder_btn(driver));

		//Click the ISS Ranked tab
		perform.click(driver, SOrders.issRanked_btn(driver));

		perform.sleep(driver, 10);

		//Verify the tab is not disabled
		Assert.assertTrue(SOrders.issRanked_btn(driver).getAttribute("class").contains("NewTab Selected"), "The Search Tab is disabled");

		//Click the Search tab
		perform.click(driver, SOrders.feePanelSearch_btn(driver));

		perform.sleep(driver, 3);

		//verify the Search Tab is no longer disabled
		Assert.assertTrue(SOrders.feePanelSearch_btn(driver).getAttribute("class").contains("NewTab Selected"), "The Search Tab is disabled");

	}// End requiredToUseFeePanelPermission
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log into Secure as the admin</li>
	 * 	<li>Go to the users tab</li>
	 * 	<li>Select SubUser</li>
	 * 	<li>Check Mark Orders as paid</li>
	 * 	<li>Check Place New Orders</li>
	 * 	<li>Check Manage order by folder</li>
	 * 	<li>Check Manage Orders by product</li>
	 * 	<li>Save</li>
	 * 	<li>Login as Subuser</li>
	 * 	<li>Go to Residential Appraisal</li>
	 * 	<li>Set Property Information data</li>
	 * 	<li>StoredVariables.getpropertyInformationStateAbbr().set("OK");  Must set for a field check later on</li>
	 * 	<li>Set Assignment Information data</li>
	 * 	<li>Set Lender Information data</li>
	 * 	<li>Enter New Order data</li>
	 * 	<li>Click Next</li>
	 * 	<li>Assign vendor</li>
	 * 	<li>Confirm order screen loads</li>
	 * 	<li>finish placing order</li>
	 * 	<li>Get loan ID</li>
	 * 	<li>Get the tracking number</li>
	 * 	<li>Log into Vendors</li>
	 * 	<li>Search for the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Click the Accept button</li>
	 * 	<li>Complete the order</li>
	 * 	<li>Log into Secure as the subuser</li>
	 * 	<li>Click on the completed orders folder</li>
	 * 	<li>Click Mark As paid</li>
	 * 	<li>Switch to iFrame</li>
	 * 	<li>Click select all</li>
	 * 	<li>Get the invoice number</li>
	 * 	<li>Enter Invoice #</li>
	 * 	<li>Get the check number</li>
	 * 	<li>Enter check number</li>
	 * 	<li>Save</li>
	 * 	<li>Log into Secure as the admin</li>
	 * 	<li>Go to the users tab</li>
	 * 	<li>Select SubUser</li>
	 * 	<li>Uncheck Mark Orders as paid</li>
	 * 	<li>Save</li>
	 * 	<li>Login as Subuser</li>
	 * 	<li>Click on the completed orders folder</li>
	 * 	<li>Verify the mark as paid button is no longer visible</li>
	 * </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Users", "Secure - Permissions", "Secure - User Permissions", "AR207" ,"Mark as paid permission"}, alwaysRun=true)
	public void markOrderAsPaidPermission() throws Exception {

		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		//Log into Secure as the admin
		secure.login(driver, "userpermissions",StoredVariables.getpassword().get());
		
		// Go to the Completed folder
		secure.findOrderFolder(driver, "Completed");
		
		// Delete all Completed orders
		secure.deleteAllOrdersInFolder(driver);
		
		// Go to Vendor Selection Settings
		secure.goToVendorSelectionSettings(driver);
		
		// Turn off Double-blind Communication switch
		if (!SVendorSelectionSettings.doubleBlind_switch(driver).getAttribute("src").contains("switchOff.png"))
		{
			perform.click(driver, SVendorSelectionSettings.doubleBlind_switch(driver));
		} //end if
		
		secure.switchOff(driver, SVendorSelectionSettings.automaticOrderAssignment_switch(driver));
		
		secure.switchOff(driver, SVendorSelectionSettings.unattendedOrderReassignment_switch(driver));
		
		// Save Preferences
		secure.saveVendorSelectionSettings(driver);

		//Go to the users tab
		secure.goToUsers(driver);

		//Select SubUser
		secure.selectSubUser(driver, "Markorders Aspaid");

		//Check Mark Orders as paid
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Mark Orders as Paid"));

		//Check Place New Orders
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Place New Orders"));

		//Check Manage order by folder
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Manage Orders by Folder"));

		//Check Manage Orders by product
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Manage Orders by Product"));
		
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"View/Manage Other Users' Orders"));

		//Save
		secure.saveUsersSettings(driver);

		//Login as Subuser
		secure.login(driver, "markordersaspaid",StoredVariables.getpassword().get());
		
		// Go to Residential Appraisal
		secure.goToResidentialAppraisal(driver);

		// Set Property Information data
		StoredVariables.getpropertyInformationAddress().set("1100 NW 38th st");
		StoredVariables.getpropertyInformationCity().set("Oklahoma City");
		StoredVariables.getpropertyInformationState().set("Oklahoma");
		StoredVariables.getpropertyInformationStateAbbr().set("OK"); // Must set for a field check later on
		StoredVariables.getpropertyInformationZip().set("73118");
		StoredVariables.getpropertyInformationSqFt().set("3697");
		StoredVariables.getpropertyInformationSiteSize().set("9,583 sq ft");
		StoredVariables.getpropertyInformationPropType().set("Single Family");
		StoredVariables.getpropertyInformationPropRights().set("Fee Simple");
		StoredVariables.getpropertyInformationLegalDesc().set("2320 NW 196th terrace");
		StoredVariables.getpropertyInformationDirections().set(perform.randomNumbers(driver, 8));

		// Set Assignment Information data
		StoredVariables.getassignmentInformationForm().set("Uniform Residential Appraisal (FNMA 1004)");
		StoredVariables.getassignmentInformationOrderDue().set(7);
		perform.getNewDate(driver, StoredVariables.getassignmentInformationOrderDue().get());
		StoredVariables.getassignmentInformationLoanNumber().set("564897123");
		StoredVariables.getassignmentInformationAssignedTo().set("");

		// Set Lender Information data
		StoredVariables.getlenderInformationLenderName().set("Lending tree bank");
		StoredVariables.getlenderInformationAddress1().set("1100 bank rd");
		StoredVariables.getlenderInformationAddress2().set("Suite D");
		StoredVariables.getlenderInformationCity().set("Tulsa");
		StoredVariables.getlenderInformationState().set("OK");
		StoredVariables.getlenderInformationZip().set("74172");

		// Enter New Order data
		secure.enterNewResidentialAppraisalOrder(driver);

		// Click Next
		perform.click(driver, SNewOrder.next_btn(driver));

		// Assign vendor
		secure.selectVendor(driver, "Permissions Testvendor");

		// Confirm order screen loads
		Assert.assertTrue(driver.getCurrentUrl().contains("ConfirmOrder"), "Confirm Order page did not load");

		//finish placing order
		secure.finishOrderAfterAssignment(driver, "check", "", "");

		//Get loan ID
		String loanID = db.getLoanID(driver);

		//Log into Vendors
		vendors.login(driver, "permissiontestvendor", StoredVariables.getpassword().get());

		// Search for the order
		vendors.findOrder(driver, StoredVariables.getloanID().get(), "Tracking Number");

		// Open the order
		vendors.openOrder(driver);

		// Wait for the Send Message button
		perform.waitForElementToBeClickable(driver, VOrderDetails.sendMessage_btn(), "cssSelector");

		// Accept the order
		vendors.acceptOrder(driver, loanID);

		// Complete the order
		vendors.completeOrderByHTTPPost(driver, "permissiontestvendor", StoredVariables.getpassword().get(), StoredVariables.getloanID().get(), "Complete.xml");

		//Log into Secure as the subuser
		secure.login(driver, "markordersaspaid", StoredVariables.getpassword().get());

		//Click on the completed orders folder
		secure.findOrderFolder(driver, "Completed");

		// Wait for Mark as paid to be clickable
		perform.waitForElementToBeClickable(driver, SOrders.markAsPaid_btn(driver));

		//Click Mark As paid
		perform.click(driver, SOrders.markAsPaid_btn(driver));

		//Wait for iFrame to load
		perform.waitForIFrames(driver);

		//Switch to iFrame
		driver.switchTo().frame(0);
		Thread.sleep(5000);
		perform.waitForElementToBeClickable(driver, SOrders.selectAll_btn(driver));

		//Click select all
		perform.click(driver, SOrders.selectAll_btn(driver));

		// Get the invoice number
		String invoiceNumber = perform.randomNumbers(driver, 8);

		//Enter Invoice #
		perform.type(driver, SOrders.invoiceNumber_txt(driver), invoiceNumber);

		// Get the check number
		String checkNumber = perform.randomNumbers(driver, 8);

		//Enter check number
		perform.type(driver, SOrders.checkNumber_txt(driver), checkNumber); 

		if ( SOrders.markAsPaidSave_btn(driver).getAttribute("class").contains("SkinButtonDisabled")) {
			perform.click(driver, SOrders.selectAll_btn(driver));
		}

		//Save
		perform.click(driver, SOrders.markAsPaidSave_btn(driver));

		//Log into Secure as the admin
		secure.login(driver, "userpermissions",StoredVariables.getpassword().get());

		//Go to the users tab
		secure.goToUsers(driver);

		//Select SubUser
		secure.selectSubUser(driver, "Markorders Aspaid");

		//Uncheck Mark Orders as paid
		perform.uncheckCheckbox(driver, secure.getPermissionsCheckbox(driver,"Mark Orders as Paid"));

		//Save
		secure.saveUsersSettings(driver);

		//Login as Subuser
		secure.login(driver, "markordersaspaid",StoredVariables.getpassword().get());

		//Click on the completed orders folder
		secure.findOrderFolder(driver, "Completed");

		//Verify the mark as paid button is no longer visible
		List<WebElement> button = driver.findElements(By.cssSelector("img[src='/App_Themes/FlatGrayscale/Icons/DollarSign.O-selected.png']"));

		Assert.assertTrue(button.size()==0, "Mark as Paid button is displayed and shouldn't be.");


	}// End markOrderAsPaidPermission

	@Test (retryAnalyzer = Retry.class, groups={"Secure - Users", "Secure - Permissions", "Secure - User Permissions", "AR207" ,"Mark as paid permission","broken"}, alwaysRun=true)
	public void compliancePermission() throws Exception {

		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		//Log into Secure as the admin
		secure.login(driver, "userpermissions",StoredVariables.getpassword().get());


		//Go to the users tab
		secure.goToUsers(driver);

		//Select SubUser
		secure.selectSubUser(driver, "Compliance Permission");

		//Check Place New Orders permission
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Place New Orders"));

		boolean verifyCheck = SUsers.compliancePermission_chkbx(driver).isSelected();
		if (verifyCheck == false) {

			//Check Compliance Permission
			perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Compliance"));    

			//Click OK on Compliance Security Dialog
			perform.click(driver, SUsers.complianceSecurityOk_btn(driver));
		}//end if 

		//Check Vendor Selection Settings Permission
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Vendor Selection"));

		//Save
		secure.saveUsersSettings(driver);

		//Create Double-Blind order
		secure.createAndAssignNewDoubleBlindResidentialAppraisalOrder(driver, "compliance");

		String TrackingNumber = db.getLoanID(driver);

		// Go to Orders
		secure.goToOrders(driver);

		// Find order
		secure.findOrder(driver, TrackingNumber, "Tracking number");

		// Open order
		secure.openOrder(driver, TrackingNumber);

		//Verify the vendor section is displayed
		Assert.assertTrue(SOrderDetails.vendorInformation_btn(driver).isDisplayed(), "Vendor information is not displayed");

		//Click the Vendor Profile Button
		perform.click(driver, SOrderDetails.vendorInformation_btn(driver));

		//Log into Vendors
		vendors.login(driver, "permissiontestvendor", StoredVariables.getpassword().get());

		// Search for the order
		vendors.findOrder(driver, StoredVariables.getloanID().get(), "Tracking Number");

		// Open the order
		vendors.openOrder(driver);

		// Wait for the Send Message button
		perform.waitForElementToBeClickable(driver, VOrderDetails.sendMessage_btn(), "cssSelector");

		// Click the Accept button
		perform.click(driver, VOrderDetails.acceptDecline_btn(driver));

		// Complete the order
		vendors.completeOrderByHTTPPost(driver, "permissiontestvendor", StoredVariables.getpassword().get(), StoredVariables.getloanID().get(), "Complete.xml");

		//Log into Secure as the subuser
		secure.login(driver, "compliance",StoredVariables.getpassword().get());

		//Click on the completed orders folder
		secure.findOrderFolder(driver, "Completed");
		
		perform.sleep(driver, 5);
		
		//Delete the orders
		secure.deleteAllOrdersInFolder(driver);

		//Find and open the order
		secure.openOrder(driver, TrackingNumber);

		//verify the order is in the correct status
		Assert.assertTrue(SOrders.ordersTable_txt(driver).getText().contains("Cancelled"), "The order is not in the correct status");
		
		//Log into Secure as the admin
		secure.login(driver, "userpermissions",StoredVariables.getpassword().get());

		//Go to the users tab
		secure.goToUsers(driver);

		//Select SubUser
		secure.selectSubUser(driver, "Compliance Permission");

		//Check Place New Orders permission
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Place New Orders"));

		//Uncheck Compliance Permission
		perform.uncheckCheckbox(driver, secure.getPermissionsCheckbox(driver,"Compliance"));   

		//Save
		secure.saveUsersSettings(driver);

		//Create Double-Blind order
		secure.createAndAssignNewDoubleBlindResidentialAppraisalOrder(driver, "compliance");
		
		secure.findAndOpenOrder(driver, TrackingNumber);
		

	}//End of compliancePermission
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log into Secure as the admin</li>
	 * 	<li>Go to Vendor Selection Settings</li>
	 * 	<li>Turn off Double-blind Communication switch</li>
	 * 	<li>Save Preferences</li>
	 * 	<li>Click OK in saved dialog box</li>
	 * 	<li>Go to the users tab</li>
	 * 	<li>Select SubUser</li>
	 * 	<li>Check Place New Orders permission</li>
	 * 	<li>Check Auto Assignment Approval Permission</li>
	 * 	<li>Save</li>
	 * 	<li>Log in as the subuser</li>
	 * 	<li>Go to Residential Appraisal</li>
	 * 	<li>Set Property Information data</li>
	 * 	<li>StoredVariables.getpropertyInformationStateAbbr().set("OK");  Must set for a field check later on</li>
	 * 	<li>Set Assignment Information data</li>
	 * 	<li>Set Lender Information data</li>
	 * 	<li>Enter New Order data</li>
	 * 	<li>Click Next</li>
	 * 	<li>Get outside frames</li>
	 * 	<li>Get inside the attach document frame</li>
	 * 	<li>driver.switchTo().frame(driver.findElement(By.xpath("iframe[contains(@src,'/Admin/NewOrder/AutoAssignmentApproval.aspx')]")));</li>
	 * 	<li>Verify dialog text</li>
	 * 	<li>Click Approve</li>
	 * 	<li>finish placing order</li>
	 * 	<li>Log into Secure as the admin</li>
	 * 	<li>Go to Vendor Selection Settings</li>
	 * 	<li>Turn off Double-blind Communication switch</li>
	 * 	<li>Save Preferences</li>
	 * 	<li>Click OK in saved dialog box</li>
	 * 	<li>Go to the users tab</li>
	 * 	<li>Select SubUser</li>
	 * 	<li>Check Place New Orders permission</li>
	 * 	<li>Check Auto Assignment Approval Permission</li>
	 * 	<li>Save</li>
	 * 	<li>Log in as the subuser</li>
	 * 	<li>Go to Residential Appraisal</li>
	 * 	<li>Set Property Information data</li>
	 * 	<li>StoredVariables.getpropertyInformationStateAbbr().set("OK");  Must set for a field check later on</li>
	 * 	<li>Set Assignment Information data</li>
	 * 	<li>Set Lender Information data</li>
	 * 	<li>Enter New Order data</li>
	 * 	<li>Click Next</li>
	 * 	<li>finish placing order</li>
	 * 	<li>}End of autoAssignmentPermission</li>
     * </ul>
	 * @throws Exception the exception
	 */
	
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Users", "Secure - Permissions", "Secure - User Permissions", "AR207" ,"Auto Assignment Approval",}, alwaysRun=true)
	public void autoAssignmentPermission() throws Exception {
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		//Log into Secure as the admin
		secure.login(driver, "userpermissions2",StoredVariables.getpassword().get());
		
		// Go to Vendor Selection Settings
		secure.goToVendorSelectionSettings(driver);

		// Turn off Double-blind Communication switch
		if (!SVendorSelectionSettings.doubleBlind_switch(driver).getAttribute("src").contains("switchOff.png"))
		{
			perform.click(driver, SVendorSelectionSettings.doubleBlind_switch(driver));
		} //end if

		secure.switchOn(driver, SVendorSelectionSettings.automaticOrderAssignment_switch(driver));

		secure.switchOff(driver, SVendorSelectionSettings.unattendedOrderReassignment_switch(driver));

		// Save Preferences
		perform.click(driver, SVendorSelectionSettings.save_btn(driver));

		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);

		// Wait for the OK button to be visible
		perform.waitForElementToBeClickable(driver, SVendorSelectionSettings.ok_btn(), "id");

		// Click OK in saved dialog box
		perform.click(driver, SVendorSelectionSettings.ok_btn(driver));

		//Go to the users tab
		secure.goToUsers(driver);

		//Select SubUser
		secure.selectSubUser(driver, "Auto Assignment");

		//Check Place New Orders permission
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Place New Orders"));

		//Check Auto Assignment Approval Permission
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Auto Assignment Approval"));
		
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"View/Manage Other Users' Orders"));

		//Save
		secure.saveUsersSettings(driver);
        
		//Log in as the subuser
		secure.login(driver, "autoassignmentpermissions",StoredVariables.getpassword().get());

		// Go to Residential Appraisal
		secure.goToResidentialAppraisal(driver);
		

		// Set Property Information data
		StoredVariables.getpropertyInformationAddress().set("1100 NW 38th st");
		StoredVariables.getpropertyInformationCity().set("Oklahoma City");
		StoredVariables.getpropertyInformationState().set("Oklahoma");
		StoredVariables.getpropertyInformationStateAbbr().set("OK"); // Must set for a field check later on
		StoredVariables.getpropertyInformationZip().set("73118");
		StoredVariables.getpropertyInformationSqFt().set("3697");
		StoredVariables.getpropertyInformationSiteSize().set("9,583 sq ft");
		StoredVariables.getpropertyInformationPropType().set("Single Family");
		StoredVariables.getpropertyInformationPropRights().set("Fee Simple");
		StoredVariables.getpropertyInformationLegalDesc().set("2320 NW 196th terrace");
		StoredVariables.getpropertyInformationDirections().set(perform.randomNumbers(driver, 8));

		// Set Assignment Information data
		StoredVariables.getassignmentInformationForm().set("Uniform Residential Appraisal (FNMA 1004)");
		StoredVariables.getassignmentInformationOrderDue().set(7);
		perform.getNewDate(driver, StoredVariables.getassignmentInformationOrderDue().get());
		StoredVariables.getassignmentInformationLoanNumber().set("564897123");
		StoredVariables.getassignmentInformationAssignedTo().set("");
		
		// Set Lender Information data
		StoredVariables.getlenderInformationLenderName().set("Lending tree bank");
		StoredVariables.getlenderInformationAddress1().set("1100 bank rd");
		StoredVariables.getlenderInformationAddress2().set("Suite D");
		StoredVariables.getlenderInformationCity().set("Tulsa");
		StoredVariables.getlenderInformationState().set("OK");
		StoredVariables.getlenderInformationZip().set("74172");

		// Enter New Order data
		secure.enterNewResidentialAppraisalOrder(driver);

		// Click Next
		perform.click(driver, SNewOrder.next_btn(driver));

		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);

		// Get outside frames
		driver.switchTo().defaultContent();
		
		// Get inside the attach document frame
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'/Admin/NewOrder/AutoAssignmentApproval.aspx')]")));
		
		//Verify dialog text
		String dialog = SNewOrder.autoAssign_txt(driver).getText();
		Assert.assertTrue(dialog.equals("Vendor assignment"), "Vendor assignment dialog is not displayed");
        
		//Click Approve
		perform.click(driver, SNewOrder.autoAssignApprove_btn(driver));

		//finish placing order
		secure.finishOrderAfterAssignment(driver, "check", "", "");

		//Log into Secure as the admin
		secure.login(driver, "userpermissions2",StoredVariables.getpassword().get());

		// Go to Vendor Selection Settings
		secure.goToVendorSelectionSettings(driver);

		// Turn off Double-blind Communication switch
		if (!SVendorSelectionSettings.doubleBlind_switch(driver).getAttribute("src").contains("switchOff.png"))
		{
			perform.click(driver, SVendorSelectionSettings.doubleBlind_switch(driver));
		} //end if

		secure.switchOn(driver, SVendorSelectionSettings.automaticOrderAssignment_switch(driver));

		secure.switchOff(driver, SVendorSelectionSettings.unattendedOrderReassignment_switch(driver));

		// Save Preferences
		perform.click(driver, SVendorSelectionSettings.save_btn(driver));

		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);

		// Wait for the OK button to be visible
		perform.waitForElementToBeClickable(driver, SVendorSelectionSettings.ok_btn(), "id");

		// Click OK in saved dialog box
		perform.click(driver, SVendorSelectionSettings.ok_btn(driver));

		//Go to the users tab
		secure.goToUsers(driver);

		//Select SubUser
		secure.selectSubUser(driver, "Auto Assignment");

		//Check Place New Orders permission
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Place New Orders"));

		//Check Auto Assignment Approval Permission
		perform.uncheckCheckbox(driver, secure.getPermissionsCheckbox(driver,"Auto Assignment Approval"));

		//Save
		secure.saveUsersSettings(driver);

		//Log in as the subuser
		secure.login(driver, "autoassignmentpermissions",StoredVariables.getpassword().get());

		// Go to Residential Appraisal
		secure.goToResidentialAppraisal(driver);


		// Set Property Information data
		StoredVariables.getpropertyInformationAddress().set("1100 NW 38th st");
		StoredVariables.getpropertyInformationCity().set("Oklahoma City");
		StoredVariables.getpropertyInformationState().set("Oklahoma");
		StoredVariables.getpropertyInformationStateAbbr().set("OK"); // Must set for a field check later on
		StoredVariables.getpropertyInformationZip().set("73118");
		StoredVariables.getpropertyInformationSqFt().set("3697");
		StoredVariables.getpropertyInformationSiteSize().set("9,583 sq ft");
		StoredVariables.getpropertyInformationPropType().set("Single Family");
		StoredVariables.getpropertyInformationPropRights().set("Fee Simple");
		StoredVariables.getpropertyInformationLegalDesc().set("2320 NW 196th terrace");
		StoredVariables.getpropertyInformationDirections().set(perform.randomNumbers(driver, 8));

		// Set Assignment Information data
		StoredVariables.getassignmentInformationForm().set("Uniform Residential Appraisal (FNMA 1004)");
		StoredVariables.getassignmentInformationOrderDue().set(7);
		perform.getNewDate(driver, StoredVariables.getassignmentInformationOrderDue().get());
		StoredVariables.getassignmentInformationLoanNumber().set("564897123");

		// Set Lender Information data
		StoredVariables.getlenderInformationLenderName().set("Lending tree bank");
		StoredVariables.getlenderInformationAddress1().set("1100 bank rd");
		StoredVariables.getlenderInformationAddress2().set("Suite D");
		StoredVariables.getlenderInformationCity().set("Tulsa");
		StoredVariables.getlenderInformationState().set("OK");
		StoredVariables.getlenderInformationZip().set("74172");

		// Enter New Order data
		secure.enterNewResidentialAppraisalOrder(driver);

		// Click Next
		perform.click(driver, SNewOrder.next_btn(driver));

		//finish placing order
		secure.finishOrderAfterAssignment(driver, "check", "", "");


	}//End of autoAssignmentPermission

	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log into Secure as the admin</li>
	 * 	<li>Go to Vendor Selection Settings</li>
	 * 	<li>Turn off Double-blind Communication switch</li>
	 * 	<li>Save Preferences</li>
	 * 	<li>Click OK in saved dialog box</li>
	 * 	<li>Go to the users tab</li>
	 * 	<li>Select SubUser</li>
	 * 	<li>Check Edit/Update Orders permission</li>
	 * 	<li>Save</li>
	 * 	<li>Login as SubUser</li>
	 * 	<li>Click on the orders button</li>
	 * 	<li>Go to Residential Appraisal</li>
	 * 	<li>Set Property Information data</li>
	 * 	<li>StoredVariables.getpropertyInformationStateAbbr().set("OK");  Must set for a field check later on</li>
	 * 	<li>Set Assignment Information data</li>
	 * 	<li>Set Lender Information data</li>
	 * 	<li>Enter New Order data</li>
	 * 	<li>Click Next</li>
	 * 	<li>Assign vendor</li>
	 * 	<li>Confirm order screen loads</li>
	 * 	<li>finish placing order</li>
	 * 	<li>Get loan ID</li>
	 * 	<li>Get the tracking number</li>
	 * 	<li>Search for the order</li>
	 * 	<li>Verify the message button is not disabled</li>
	 * 	<li>Verify the attach button is not disabled</li>
	 * 	<li>Verify the Add Note button is not disabled</li>
	 * 	<li>Verify the duplicate button is not disabled</li>
	 * 	<li>Log into Vendors</li>
	 * 	<li>Search for the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Click the Accept button</li>
	 * 	<li>Complete the order</li>
	 * 	<li>Login to Secure as SubUser</li>
	 * 	<li>Search for the order</li>
	 * 	<li>Verify the edit button is not disabled</li>
	 * 	<li>Log into Secure as the admin</li>
	 * 	<li>Go to the users tab</li>
	 * 	<li>Select SubUser</li>
	 * 	<li>Uncheck Edit/Update orders permission</li>
	 * 	<li>Save</li>
	 * 	<li>Login as SubUser</li>
	 * 	<li>Click on the orders button</li>
	 * 	<li>Go to Residential Appraisal</li>
	 * 	<li>Set Property Information data</li>
	 * 	<li>StoredVariables.getpropertyInformationStateAbbr().set("OK");  Must set for a field check later on</li>
	 * 	<li>Set Assignment Information data</li>
	 * 	<li>Set Lender Information data</li>
	 * 	<li>Enter New Order data</li>
	 * 	<li>Click Next</li>
	 * 	<li>Assign vendor</li>
	 * 	<li>Confirm order screen loads</li>
	 * 	<li>finish placing order</li>
	 * 	<li>Get loan ID</li>
	 * 	<li>Get the tracking number</li>
	 * 	<li>Search for the order</li>
	 * 	<li>Verify the message button is disabled</li>
	 * 	<li>Verify the attach button is disabled</li>
	 * 	<li>Verify the Add Note button is disabled</li>
	 * 	<li>Verify the duplicate button is disabled</li>
	 * 	<li>Log into Vendors</li>
	 * 	<li>Search for the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Click the Accept button</li>
	 * 	<li>Complete the order</li>
	 * 	<li>Login to Secure as SubUser</li>
	 * 	<li>Search for the order</li>
	 * 	<li>Verify the edit button is now disabled</li>
	 * 	<li>}End of updateOrdersPermission</li>
	 * </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Users", "Secure - Permissions", "Secure - User Permissions", "AR207" ,"Edit/Update Orders",}, alwaysRun=true)
	public void updateOrdersPermission() throws Exception {
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		//Log into Secure as the admin
		secure.login(driver, "userpermissions",StoredVariables.getpassword().get());

		// Go to Vendor Selection Settings
		secure.goToVendorSelectionSettings(driver);

		// Turn off Double-blind Communication switch
		if (!SVendorSelectionSettings.doubleBlind_switch(driver).getAttribute("src").contains("switchOff.png"))
		{
			perform.click(driver, SVendorSelectionSettings.doubleBlind_switch(driver));
		} //end if

		secure.switchOff(driver, SVendorSelectionSettings.automaticOrderAssignment_switch(driver));

		secure.switchOff(driver, SVendorSelectionSettings.unattendedOrderReassignment_switch(driver));

		// Save Preferences
		secure.saveVendorSelectionSettings(driver);

		//Go to the users tab
		secure.goToUsers(driver);

		//Select SubUser
		secure.selectSubUser(driver, "Update Orders");

		//Check Edit/Update Orders permission
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Edit/Update Orders"));
		
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"View/Manage Other Users' Orders"));

		//Save
		secure.saveUsersSettings(driver);

		//Login as SubUser
		secure.login(driver, "updateorders",StoredVariables.getpassword().get());

		//Click on the orders button
		secure.goToOrders(driver);

		// Go to Residential Appraisal
		secure.goToResidentialAppraisal(driver);

		// Set Property Information data
		StoredVariables.getpropertyInformationAddress().set("1100 NW 38th st");
		StoredVariables.getpropertyInformationCity().set("Oklahoma City");
		StoredVariables.getpropertyInformationState().set("Oklahoma");
		StoredVariables.getpropertyInformationStateAbbr().set("OK"); // Must set for a field check later on
		StoredVariables.getpropertyInformationZip().set("73118");
		StoredVariables.getpropertyInformationSqFt().set("3697");
		StoredVariables.getpropertyInformationSiteSize().set("9,583 sq ft");
		StoredVariables.getpropertyInformationPropType().set("Single Family");
		StoredVariables.getpropertyInformationPropRights().set("Fee Simple");
		StoredVariables.getpropertyInformationLegalDesc().set("2320 NW 196th terrace");
		StoredVariables.getpropertyInformationDirections().set(perform.randomNumbers(driver, 8));

		// Set Assignment Information data
		StoredVariables.getassignmentInformationForm().set("Uniform Residential Appraisal (FNMA 1004)");
		StoredVariables.getassignmentInformationOrderDue().set(7);
		perform.getNewDate(driver, StoredVariables.getassignmentInformationOrderDue().get());
		StoredVariables.getassignmentInformationLoanNumber().set("564897123");
		StoredVariables.getassignmentInformationAssignedTo().set("");

		// Set Lender Information data
		StoredVariables.getlenderInformationLenderName().set("Lending tree bank");
		StoredVariables.getlenderInformationAddress1().set("1100 bank rd");
		StoredVariables.getlenderInformationAddress2().set("Suite D");
		StoredVariables.getlenderInformationCity().set("Tulsa");
		StoredVariables.getlenderInformationState().set("OK");
		StoredVariables.getlenderInformationZip().set("74172");

		// Enter New Order data
		secure.enterNewResidentialAppraisalOrder(driver);

		// Click Next
		perform.click(driver, SNewOrder.next_btn(driver));

		// Assign vendor
		secure.selectVendor(driver, "Permissions Testvendor");

		// Confirm order screen loads
		Assert.assertTrue(driver.getCurrentUrl().contains("ConfirmOrder"), "Confirm Order page did not load");

		//finish placing order
		secure.finishOrderAfterAssignment(driver, "check", "", "");

		//Get loan ID
		String loanID = db.getLoanID(driver);

		// Get the tracking number
		String TrackingNumber = db.getTrackingNumber(driver, loanID);

		// Search for the order
		secure.findAndOpenOrder(driver, TrackingNumber);

		//Verify the message button is not disabled
		Assert.assertTrue(SOrderDetails.message_btn(driver).getAttribute("class").contains("MenuBar_Item"), "The Message is enabled");

		//Verify the attach button is not disabled
		Assert.assertTrue(SOrderDetails.attach_btn(driver).getAttribute("class").contains("MenuBar_Item_Label"), "The Attach button is enabled");

		//Verify the Add Note button is not disabled
		Assert.assertTrue(SOrderDetails.addNote_btn(driver).getAttribute("class").contains("MenuBar_Item_Label"), "The Add Note button is enabled");

		//Verify the duplicate button is not disabled
		Assert.assertTrue(SOrderDetails.duplicate_btn(driver).getAttribute("class").contains("MenuBar_Item_Label"), "The Duplicate button is enabled");

		//Log into Vendors
		vendors.login(driver, "permissiontestvendor", StoredVariables.getpassword().get());

		// Search for the order
		vendors.findOrder(driver, StoredVariables.getloanID().get(), "Tracking Number");

		// Open the order
		vendors.openOrder(driver);

		// Wait for the Send Message button
		perform.waitForElementToBeClickable(driver, VOrderDetails.sendMessage_btn(), "cssSelector");

		// Click the Accept button
		perform.click(driver, VOrderDetails.acceptDecline_btn(driver));

		// Complete the order
		vendors.completeOrderByHTTPPost(driver, "permissiontestvendor", StoredVariables.getpassword().get(), StoredVariables.getloanID().get(), "Complete.xml");

		//Login to Secure as SubUser
		secure.login(driver, "updateorders",StoredVariables.getpassword().get());

		// Search for the order
		secure.findAndOpenOrder(driver, TrackingNumber);

		//Verify the edit button is not disabled
		Assert.assertTrue(SOrderDetails.edit_btn(driver).getAttribute("class").contains("MenuBar_Item_Label"), "The Duplicate button is enabled");

		//Log into Secure as the admin
		secure.login(driver, "userpermissions",StoredVariables.getpassword().get());

		//Go to the users tab
		secure.goToUsers(driver);

		//Select SubUser
		secure.selectSubUser(driver, "Update Orders");

		//Uncheck Edit/Update orders permission
		perform.uncheckCheckbox(driver, secure.getPermissionsCheckbox(driver,"Edit/Update Orders"));

		//Save
		secure.saveUsersSettings(driver);

		//Login as SubUser
		secure.login(driver, "updateorders",StoredVariables.getpassword().get());

		//Click on the orders button
		secure.goToOrders(driver);

		// Go to Residential Appraisal
		secure.goToResidentialAppraisal(driver);


		// Set Property Information data
		StoredVariables.getpropertyInformationAddress().set("1100 NW 38th st");
		StoredVariables.getpropertyInformationCity().set("Oklahoma City");
		StoredVariables.getpropertyInformationState().set("Oklahoma");
		StoredVariables.getpropertyInformationStateAbbr().set("OK"); // Must set for a field check later on
		StoredVariables.getpropertyInformationZip().set("73118");
		StoredVariables.getpropertyInformationSqFt().set("3697");
		StoredVariables.getpropertyInformationSiteSize().set("9,583 sq ft");
		StoredVariables.getpropertyInformationPropType().set("Single Family");
		StoredVariables.getpropertyInformationPropRights().set("Fee Simple");
		StoredVariables.getpropertyInformationLegalDesc().set("2320 NW 196th terrace");
		StoredVariables.getpropertyInformationDirections().set(perform.randomNumbers(driver, 8));

		// Set Assignment Information data
		StoredVariables.getassignmentInformationForm().set("Uniform Residential Appraisal (FNMA 1004)");
		StoredVariables.getassignmentInformationOrderDue().set(7);
		perform.getNewDate(driver, StoredVariables.getassignmentInformationOrderDue().get());
		StoredVariables.getassignmentInformationLoanNumber().set("564897123");

		// Set Lender Information data
		StoredVariables.getlenderInformationLenderName().set("Lending tree bank");
		StoredVariables.getlenderInformationAddress1().set("1100 bank rd");
		StoredVariables.getlenderInformationAddress2().set("Suite D");
		StoredVariables.getlenderInformationCity().set("Tulsa");
		StoredVariables.getlenderInformationState().set("OK");
		StoredVariables.getlenderInformationZip().set("74172");

		// Enter New Order data
		secure.enterNewResidentialAppraisalOrder(driver);

		// Click Next
		perform.click(driver, SNewOrder.next_btn(driver));

		// Assign vendor
		secure.selectVendor(driver, "Permissions Testvendor");

		// Confirm order screen loads
		Assert.assertTrue(driver.getCurrentUrl().contains("ConfirmOrder"), "Confirm Order page did not load");

		//finish placing order
		secure.finishOrderAfterAssignment(driver, "check", "", "");

		//Get loan ID
		loanID = db.getLoanID(driver);

		// Get the tracking number
		TrackingNumber = db.getTrackingNumber(driver, loanID);

		// Search for the order
		secure.findAndOpenOrder(driver, TrackingNumber);

		//Verify the message button is disabled
		perform.verification(driver, perform.getGGGParent(driver, SOrderDetails.message_btn(driver)).getAttribute("class"), 
				"equals", "MenuBar_Item_Disabled");

		//Verify the attach button is disabled
		perform.verification(driver, perform.getGGGParent(driver, SOrderDetails.attach_btn(driver)).getAttribute("class"), 
				"equals", "MenuBar_Item_Disabled");

		//Verify the Add Note button is disabled
		perform.verification(driver, perform.getGGGParent(driver, SOrderDetails.addNote_btn(driver)).getAttribute("class"), 
				"equals", "MenuBar_Item_Disabled");

		//Verify the duplicate button is disabled
		perform.verification(driver, perform.getGGGParent(driver, SOrderDetails.duplicate_btn(driver)).getAttribute("class"), 
				"equals", "MenuBar_Item_Disabled");

		//Log into Vendors
		vendors.login(driver, "permissiontestvendor", StoredVariables.getpassword().get());

		// Search for the order
		vendors.findOrder(driver, StoredVariables.getloanID().get(), "Tracking Number");

		// Open the order
		vendors.openOrder(driver);

		// Wait for the Send Message button
		perform.waitForElementToBeClickable(driver, VOrderDetails.sendMessage_btn(), "cssSelector");

		// Click the Accept button
		perform.click(driver, VOrderDetails.acceptDecline_btn(driver));

		// Complete the order
		vendors.completeOrderByHTTPPost(driver, "permissiontestvendor", StoredVariables.getpassword().get(), StoredVariables.getloanID().get(), "Complete.xml");

		//Login to Secure as SubUser
		secure.login(driver, "updateorders",StoredVariables.getpassword().get());

		// Search for the order
		secure.findAndOpenOrder(driver, TrackingNumber);

		//Verify the edit button is now disabled
		perform.verification(driver, perform.getGGGParent(driver, SOrderDetails.edit_btn(driver)).getAttribute("class"), 
				"equals", "MenuBar_Item_Disabled");


	}//End of updateOrdersPermission

	/**
	 * <p>
	 * STEPS:
	 *  <li>Log into Secure as the admin</li>
	 * 	<li>Go to Vendor Selection Settings</li>
	 * 	<li>Turn off Double-blind Communication switch</li>
	 * 	<li>Save Preferences</li>
	 * 	<li>Go to the users tab</li>
	 * 	<li>Select SubUser</li>
	 * 	<li>Check Manage QuickLists permission</li>
	 * 	<li>Save</li>
	 * 	<li>Login as Subuser</li>
	 * 	<li>Create an order through the API</li>
	 * 	<li>Log into Secure as the subuser</li>
	 * 	<li>Find and open the order</li>
	 * 	<li>Click the message button</li>
	 * 	<li>QuickList test</li>
	 * 	<li>Click the QL icon in the comments field</li>
	 * 	<li>Switch iFrame</li>
	 * 	<li>}End if</li>
	 * 	<li>Click New</li>
	 * 	<li>Enter a Description</li>
	 * 	<li>Enter the Text</li>
	 * 	<li>Click Save</li>
	 * 	<li>Select the new QL item</li>
	 * 	<li>Click Use button</li>
	 * 	<li>Click the QL icon in the comments field</li>
	 * 	<li>Switch iFrame</li>
	 * 	<li>Click Delete on QuickList item</li>
	 * 	<li>Verify dialog text</li>
	 * 	<li>Click Yes</li>
	 * 	<li>Check for more QL items</li>
	 * 	<li>Log into Secure as the admin</li>
	 * 	<li>Go to the users tab</li>
	 * 	<li>Select SubUser</li>
	 * 	<li>Check Manage QuickLists permission</li>
	 * 	<li>Save</li>
	 * 	<li>Login as Subuser</li>
	 * 	<li>Log into Secure as the subuser</li>
	 * 	<li>Find and open the order</li>
	 * 	<li>Click the message button</li>
	 * 	<li>Click the QL icon in the comments field</li>
	 * 	<li>Switch iFrame</li>
	 * 	<li>Verify user is unable to edit anything in the QL form</li>
	 * 	<li>}End manageQuicklistPermissions</li>
	 * <ul>
	 * </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Users", "Secure - Permissions", "Secure - User Permissions", "AR207" ,"Edit/Update Orders",}, alwaysRun=true)
	public void manageQuicklistsPermission() throws Exception {
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		//Log into Secure as the admin
		secure.login(driver, "userpermissions",StoredVariables.getpassword().get());
		
		// Go to Vendor Selection Settings
		secure.goToVendorSelectionSettings(driver);

		// Turn off Double-blind Communication switch
		if (!SVendorSelectionSettings.doubleBlind_switch(driver).getAttribute("src").contains("switchOff.png"))
		{
			perform.click(driver, SVendorSelectionSettings.doubleBlind_switch(driver));
		} //end if

		secure.switchOff(driver, SVendorSelectionSettings.automaticOrderAssignment_switch(driver));

		secure.switchOff(driver, SVendorSelectionSettings.unattendedOrderReassignment_switch(driver));

		// Save Preferences
		secure.saveVendorSelectionSettings(driver);

		//Go to the users tab
		secure.goToUsers(driver);

		//Select SubUser
		secure.selectSubUser(driver, "Manage Quicklists");

		//Check Manage QuickLists permission
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Manage QuickLists"));
		
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"View/Manage Other Users' Orders"));

		//Save
		secure.saveUsersSettings(driver);

		//Login as Subuser
		secure.login(driver, "managequicklists",StoredVariables.getpassword().get());

		// Create an order through the API
		String trackingNumber = perform.apiPlaceOrderFromSecure(driver, "managequicklists","T3sting1", "PlaceMNOrder-manageQuicklistsPermission");

		secure.loginAndAssignOrderToAppraiserWithTrackingNumber(driver, "managequicklists", "T3sting1", trackingNumber, "Testvendor");

		vendors.loginAndOpenOrderByTrackingNumber(driver, "permissiontestvendor", "T3sting1", trackingNumber);

		//Log into Secure as the subuser
		secure.login(driver, "managequicklists",StoredVariables.getpassword().get());

		//Find and open the order
		secure.findAndOpenOrder(driver, trackingNumber);

		//Click the message button
		perform.click(driver, SOrderDetails.message_btn(driver));


		// QuickList test
		WebElement menu = null;
		WebElement subMenu = null;
		Actions builder = new Actions(driver);
		if (StoredVariables.getmobile().get()==false) {

			// Click the QL icon in the comments field
			menu = driver.findElement(By.id("Dialogs_Dialogs_ctlSendMessages_txtMessage"));
			subMenu = driver.findElement(By.id("Dialogs_Dialogs_ctlSendMessages_hbStatusMessage_btnHover"));
			builder = new Actions(driver);
			builder.moveToElement(menu).perform();
			perform.waitForElementToBeClickable(driver, "Dialogs_Dialogs_ctlSendMessages_hbStatusMessage_btnHover", "id");
			subMenu.click();

			// Wait for busy to be hidden
			perform.waitForBusyToBeHidden(driver);

			// Switch iFrame
			perform.waitForiFrameSrcAndSwitchToIt(driver, "/Common/Lists/Quick.aspx?", By.id(SSendViaSureReceipts.close_btn()));

			// Wait for close button
			perform.waitForElementToBeClickable(driver, SSendViaSureReceipts.close_btn(), "id");
		}//End if

		// Click New
		perform.click(driver, SSendViaSureReceipts.new_btn(driver));

		// Wait for Description textbox
		perform.waitForElementToBeClickable(driver, SSendViaSureReceipts.description_txtbx(), "id");

		// Enter a Description
		perform.type(driver, SSendViaSureReceipts.description_txtbx(driver), "Test QL Message");

		// Enter the Text
		perform.type(driver, SSendViaSureReceipts.text_txtbx(driver), "This is test QL Message text");

		// Click Save
		perform.click(driver, SSendViaSureReceipts.save_btn(driver));

		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);

		// Select the new QL item
		perform.click(driver, SSendViaSureReceipts.select_btn(driver));

		Thread.sleep(5000);

		// Click Use button
		perform.click(driver, SSendViaSureReceipts.use_btn(driver));

		// Click the QL icon in the comments field
		perform.clickWithJavascript(driver, SSendViaSureReceipts.QL_btn(driver));

		// Switch iFrame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "/Common/Lists/Quick.aspx?", By.id(SSendViaSureReceipts.close_btn()));

		// Wait for close button
		perform.waitForElementToBeClickable(driver, SSendViaSureReceipts.close_btn(), "id");

		int deleteVisible = driver.findElements(By.cssSelector(SSendViaSureReceipts.delete_btn())).size();
		System.out.println("deleteVisible = " + deleteVisible);
		while (deleteVisible > 0)
		{

			// Click Delete on QuickList item
			perform.click(driver,SSendViaSureReceipts.delete_btn(driver));

			// Verify dialog text
			Assert.assertTrue(SSendViaSureReceipts.deleteDialog_txt(driver).getText().equals("Are you sure you want to delete the selected item?"), "The dialog text is incorrect");

			// Click Yes
			perform.click(driver,SSendViaSureReceipts.yes_btn(driver));

			// Wait for Close button
			perform.waitForElementToBeClickable(driver, SSendViaSureReceipts.close_btn(), "id");

			// Check for more QL items
			deleteVisible = driver.findElements(By.cssSelector(SSendViaSureReceipts.delete_btn())).size();

		} // end while loop


		//Log into Secure as the admin
		secure.login(driver, "userpermissions",StoredVariables.getpassword().get());

		//Go to the users tab
		secure.goToUsers(driver);

		//Select SubUser
		secure.selectSubUser(driver, "Manage Quicklists");

		//Check Manage QuickLists permission
		perform.uncheckCheckbox(driver, secure.getPermissionsCheckbox(driver,"Manage QuickLists"));

		//Save
		secure.saveUsersSettings(driver);

		//Login as Subuser
		secure.login(driver, "managequicklists",StoredVariables.getpassword().get());

		//Log into Secure as the subuser
		secure.login(driver, "managequicklists",StoredVariables.getpassword().get());

		//Find and open the order
		secure.findAndOpenOrder(driver, trackingNumber);

		//Click the message button
		perform.click(driver, SOrderDetails.message_btn(driver));

		// Click the QL icon in the comments field
		perform.clickWithJavascript(driver, SSendViaSureReceipts.QL_btn(driver));

		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);

		// Switch iFrame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "/Common/Lists/Quick.aspx?", By.id(SSendViaSureReceipts.close_btn()));

		// Wait for close button
		perform.waitForElementToBeClickable(driver, SSendViaSureReceipts.close_btn(), "id");

		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);

		// Verify user is unable to edit anything in the QL form 
		boolean visible = driver.findElement(By.id(SSendViaSureReceipts.new_btn())).isDisplayed();
		Assert.assertTrue(visible == false, "The New button is displayed and should not be");


	}//End manageQuicklistPermissions
	
	/**
	 * <p>
	 * STEPS:
	 * 	<li>Log into Secure as the admin</li>
	 * 	<li>Go to Vendor Selection Settings</li>
	 * 	<li>Turn off Double-blind Communication switch</li>
	 * 	<li>Save Preferences</li>
	 * 	<li>Go to the users tab</li>
	 * 	<li>Select SubUser</li>
	 * 	<li>Check Place New Orders checkbox</li>
	 * 	<li>Check Submit to AQM permission</li>
	 * 	<li>Save User Settings</li>
	 * 	<li>Log into Secure as the subuser</li>
	 * 	<li>Place a new order via the API</li>
	 * 	<li>Assign the order to a vendor</li>
	 * 	<li>Accept and complete order as the vendor</li>
	 * 	<li>Log into Secure as the subuser</li>
	 * 	<li>Find and open the order</li>
	 * 	<li>Verify the Start AQM button is not disabled</li>
	 * 	<li>Log into Secure as the admin</li>
	 * 	<li>Go to the users tab</li>
	 * 	<li>Select SubUser</li>
	 * 	<li>Uncheck Place New Orders checkbox</li>
	 * 	<li>Save User Settings</li>
	 * 	<li>Log into Secure as the subuser</li>
	 * 	<li>Place a new order via the API</li>
	 * 	<li>Assign the order to a vendor</li>
	 * 	<li>Accept and complete order as the vendor</li>
	 * 	<li>Log into Secure as the subuser</li>
	 * 	<li>Find and open the order</li>
	 * 	<li>Click Start AQM</li>
	 * 	<li>Click OK in the Not Authorized dialog</li>
	 * 	<li>}End submitToAqmPermission</li>
	 * <ul>
	 * </ul>
	 * @throws Exception the exception
	 */

	@Test (retryAnalyzer = Retry.class, groups={"Secure - Users", "Secure - Permissions", "Secure - User Permissions", "AR207" ,"Edit/Update Orders",}, alwaysRun=true)
	public void submitToAqmPermission() throws Exception {
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		//Log into Secure as the admin
		secure.login(driver, "userpermissions",StoredVariables.getpassword().get());
		
		// Go to Vendor Selection Settings
		secure.goToVendorSelectionSettings(driver);

		// Turn off Double-blind Communication switch
		if (!SVendorSelectionSettings.doubleBlind_switch(driver).getAttribute("src").contains("switchOff.png"))
		{
			perform.click(driver, SVendorSelectionSettings.doubleBlind_switch(driver));
		} //end if

		secure.switchOff(driver, SVendorSelectionSettings.automaticOrderAssignment_switch(driver));

		secure.switchOff(driver, SVendorSelectionSettings.unattendedOrderReassignment_switch(driver));

		// Save Preferences
		secure.saveVendorSelectionSettings(driver);

		//Go to the users tab
		secure.goToUsers(driver);

		//Select SubUser
		secure.selectSubUser(driver, "Submit ToAQM");
		
		//Check Place New Orders checkbox
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Place New Orders"));
		
		//Check Submit to AQM permission
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver, "Submit to AQM"));
		
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"View/Manage Other Users' Orders"));
		
		//Save User Settings
		secure.saveUsersSettings(driver);
		
		//Log into Secure as the subuser
		secure.login(driver, "submittoaqm",StoredVariables.getpassword().get());
		
		//Place a new order via the API
		String trackingNumber = perform.apiPlaceOrderFromSecure(driver, "submittoaqm", "T3sting1", "PlaceMNOrder-SubmittoAQMPermission");
        
		//Assign the order to a vendor
		secure.loginAndAssignOrderToAppraiserWithTrackingNumber(driver, "submittoaqm", "T3sting1", trackingNumber, "Testvendor");
		
		//Accept and complete order as the vendor
		vendors.loginAcceptAndCompleteOrder(driver, "permissiontestvendor", "T3sting1", trackingNumber);

		//Log into Secure as the subuser
		secure.login(driver, "submittoaqm",StoredVariables.getpassword().get());

		//Find and open the order
		secure.findAndOpenOrder(driver, trackingNumber);

		//Verify the Start AQM button is not disabled
		Assert.assertTrue(SOrderDetails.startAQM_btn(driver).getAttribute("class").contains("MenuBar_Item"), "The Start AQM button is enabled");
		
		//Log into Secure as the admin
		secure.login(driver, "userpermissions",StoredVariables.getpassword().get());

		//Go to the users tab
		secure.goToUsers(driver);

		//Select SubUser
		secure.selectSubUser(driver, "Submit ToAQM");

		//Uncheck Place New Orders checkbox
		perform.uncheckCheckbox(driver, secure.getPermissionsCheckbox(driver, "Submit to AQM"));

		//Save User Settings
		secure.saveUsersSettings(driver);

		//Log into Secure as the subuser
		secure.login(driver, "submittoaqm",StoredVariables.getpassword().get());

		//Place a new order via the API
		trackingNumber = perform.apiPlaceOrderFromSecure(driver, "submittoaqm", "T3sting1", "PlaceMNOrder-SubmittoAQMPermission");

		//Assign the order to a vendor
		secure.loginAndAssignOrderToAppraiserWithTrackingNumber(driver, "submittoaqm", "T3sting1", trackingNumber, "Testvendor");

		//Accept and complete order as the vendor
		vendors.loginAcceptAndCompleteOrder(driver, "permissiontestvendor", "T3sting1", trackingNumber);

		//Log into Secure as the subuser
		secure.login(driver, "submittoaqm",StoredVariables.getpassword().get());

		//Find and open the order
		secure.findAndOpenOrder(driver, trackingNumber);

		//Click Start AQM
	    perform.click(driver, SOrderDetails.startAQM_btn(driver));
	    
	    //Click OK in the Not Authorized dialog
	    perform.verification(driver, SOrderDetails.notAuthorized_dialog(driver).getText(), "contains", "Not Authorized");
	    

}//End submitToAqmPermission

	@Test (retryAnalyzer = Retry.class, groups={"Secure - Users", "Secure - Permissions", "Secure - User Permissions", "AR207" ,"Edit/Update Orders","broken"}, alwaysRun=true)
	public void accessVmpXsitePermission() throws Exception {
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		String password = StoredVariables.getpassword().get();

		//Log into Secure as the admin
		secure.login(driver, "userpermissions",StoredVariables.getpassword().get());

		// Go to Vendor Selection Settings
		secure.goToVendorSelectionSettings(driver);

		// Turn off Double-blind Communication switch
		if (!SVendorSelectionSettings.doubleBlind_switch(driver).getAttribute("src").contains("switchOff.png"))
		{
			perform.click(driver, SVendorSelectionSettings.doubleBlind_switch(driver));
		} //end if

		secure.switchOff(driver, SVendorSelectionSettings.automaticOrderAssignment_switch(driver));

		secure.switchOff(driver, SVendorSelectionSettings.unattendedOrderReassignment_switch(driver));

		// Save Preferences
		secure.saveVendorSelectionSettings(driver);

		//Go to the users tab
		secure.goToUsers(driver);

		//Select SubUser
		secure.selectSubUser(driver, "Access VMPXSite");

		//Check Place New Orders checkbox
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Place New Orders"));

		//Check Submit to Access VMP XSite Permission
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver, "Access VMP XSite"));

		//Save
		secure.saveUsersSettings(driver);

		//PLace a new order through the API
		perform.apiPlaceOrderFromVMPClientPortal(driver, userVMP, password, userSecure, "PlaceMNOrder-AccessVMPXSitePermission");
		String trackingNumber = StoredVariables.gettrackingNumber().get();

		//Assign the order to a vendor
		secure.loginAndAssignOrderToAppraiserWithTrackingNumber(driver, "accessvmpxsite", "T3sting1", trackingNumber, "Testvendor");

		//Log into Secure as the subuser
		secure.login(driver, "accessvmpxsite",StoredVariables.getpassword().get());

		//Open the details of the order
		secure.findAndOpenOrder(driver, trackingNumber);

		perform.click(driver, SOrderDetails.viewXSiteOrder_lnk(driver));

		// Switch window
		perform.switchToXSiteWindowByTitle(driver, "Business Management");

		// Verify url
		perform.verifyURL(driver, "BusinessMgt/BusinessMgt.aspx?Load=Orders");

	}//End accessVmpXsitePermission

	/**
	 * <p>
	 * STEPS:
	 * 	<li>Log into Secure as the admin</li>
	 * 	<li>Go to Vendor Selection Settings</li>
	 * 	<li>Turn off Double-blind Communication switch</li>
	 * 	<li>Save Preferences</li>
	 * 	<li>Go to the users tab</li>
	 * 	<li>Select SubUser</li>
	 * 	<li>Check Place New Orders checkbox</li>
	 * 	<li>Check Submit to UCDP permission</li>
	 * 	<li>Save User settings</li>
	 * 	<li>Place a new order via the API</li>
	 * 	<li>Assign the order to a vendor</li>
	 * 	<li>Accept and complete order as the vendor</li>
	 * 	<li>Log into Secure as the subuser</li>
	 * 	<li>Find and open the order</li>
	 * 	<li>Click Set status</li>
	 * 	<li>Click Submit to UCDP</li>
	 * 	<li>Get outside frames</li>
	 * 	<li>Get inside the attach document frame</li>
	 * 	<li>driver.switchTo().frame(driver.findElement(By.xpath("iframe[contains(@src,'UCDPSubmit.aspx')]")));</li>
	 * 	<li>Select GSE dropdown</li>
	 * 	<li>Click Send</li>
	 * 	<li>Log into Secure as the admin</li>
	 * 	<li>Go to the users tab</li>
	 * 	<li>Select SubUser</li>
	 * 	<li>Check Submit to UCDP permission</li>
	 * 	<li>Save User Settings</li>
	 * 	<li>Place a new order via the API</li>
	 * 	<li>Assign the order to a vendor</li>
	 * 	<li>Accept and complete order as the vendor</li>
	 * 	<li>Log into Secure as the subuser</li>
	 * 	<li>Find and open the order</li>
	 * 	<li>Click Set status</li>
	 * 	<li>Verify UCDP is not displayed in the list of dropdown options</li>
	 * 	<li>}End submitToUcdpPermission</li>
	 * <ul>
	 * </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Users", "Secure - Permissions", "Secure - User Permissions", "AR207" ,"Edit/Update Orders",}, alwaysRun=true)
	public void submitToUcdpPermission() throws Exception {
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		//Log into Secure as the admin
		secure.login(driver, "userpermissions",StoredVariables.getpassword().get());

		// Go to Vendor Selection Settings
		secure.goToVendorSelectionSettings(driver);

		// Turn off Double-blind Communication switch
		if (!SVendorSelectionSettings.doubleBlind_switch(driver).getAttribute("src").contains("switchOff.png"))
		{
			perform.click(driver, SVendorSelectionSettings.doubleBlind_switch(driver));
		} //end if

		secure.switchOff(driver, SVendorSelectionSettings.automaticOrderAssignment_switch(driver));

		secure.switchOff(driver, SVendorSelectionSettings.unattendedOrderReassignment_switch(driver));

		// Save Preferences
		secure.saveVendorSelectionSettings(driver);

		//Go to the users tab
		secure.goToUsers(driver);

		//Select SubUser
		secure.selectSubUser(driver, "Submit ToUCDP");

		//Check Place New Orders checkbox
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Place New Orders"));

		//Check Submit to UCDP permission
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Submit to UCDP"));

		//Save User settings
		secure.saveUsersSettings(driver);

		//Place a new order via the API
		String trackingNumber = perform.apiPlaceOrderFromSecure(driver, "submittoucdppermission", "T3sting1", "PlaceMNOrder-SubmittoUCDPPermission");

		//Assign the order to a vendor
		secure.loginAndAssignOrderToAppraiserWithTrackingNumber(driver, "submittoaqm", "T3sting1", trackingNumber, "Testvendor");

		//Accept and complete order as the vendor
		vendors.loginAcceptAndCompleteOrder(driver, "permissiontestvendor", "T3sting1", trackingNumber);				

		//Log into Secure as the subuser
		secure.login(driver, "submittoucdppermission",StoredVariables.getpassword().get());

		//Find and open the order
		secure.findAndOpenOrder(driver, trackingNumber);

		// Click Set status
		perform.click(driver,SOrderDetails.setStatus_btn(driver));

		// Wait for Submit to UCDP button
		perform.waitForElementToBeClickable(driver, SOrderDetails.submitToUCDP_btn(), "cssSelector");

		// Click Submit to UCDP
		perform.clickInTable_Contains(driver, "Submit to UCDP");

		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);

		// Get outside frames
		driver.switchTo().defaultContent();
		// Get inside the attach document frame
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'UCDPSubmit.aspx')]")));

		// Wait for Internal notes to be clickable
		perform.waitForElementToBeClickable(driver, SSubmitToUCDP.internalNotes_txtbx(), "id");

		// Wait for Select GSE dropdown
		perform.waitForElementToBeClickable(driver, SSubmitToUCDP.selectGSE_dropdown(), "id");

		// Select GSE dropdown
		perform.selectDropdownOption(driver, SSubmitToUCDP.selectGSE_dropdown(driver), "Freddie Mac");

		// Click Send
		perform.click(driver,SSubmitToUCDP.send_btn(driver));
		
		//Log into Secure as the admin
		secure.login(driver, "userpermissions",StoredVariables.getpassword().get());

		//Go to the users tab
		secure.goToUsers(driver);

		//Select SubUser
		secure.selectSubUser(driver, "Submit ToUCDP");

		//Check Submit to UCDP permission
		perform.uncheckCheckbox(driver, secure.getPermissionsCheckbox(driver,"Submit to UCDP"));

		//Save User Settings
		secure.saveUsersSettings(driver);

		//Place a new order via the API
		trackingNumber = perform.apiPlaceOrderFromSecure(driver, "submittoucdppermission", "T3sting1", "PlaceMNOrder-SubmittoUCDPPermission");

		//Assign the order to a vendor
		secure.loginAndAssignOrderToAppraiserWithTrackingNumber(driver, "submittoaqm", "T3sting1", trackingNumber, "Testvendor");

		//Accept and complete order as the vendor
		vendors.loginAcceptAndCompleteOrder(driver, "permissiontestvendor", "T3sting1", trackingNumber);				

		//Log into Secure as the subuser
		secure.login(driver, "submittoucdppermission",StoredVariables.getpassword().get());

		//Find and open the order
		secure.findAndOpenOrder(driver, trackingNumber);

		// Click Set status
		perform.click(driver,SOrderDetails.setStatus_btn(driver));

		//Verify UCDP is not displayed in the list of dropdown options
		String submitToUcdp = SOrderDetails.setStatus_drpdwn(driver).getText();
		Assert.assertTrue(!submitToUcdp.contains("Submit To UCDP"), "The Submit to UCDP option is displayed");

	}//End submitToUcdpPermission
	
	/**
	 * <p>
	 * STEPS:
	 * 	<li>Log into Secure as the admin</li>
	 * 	<li>Go to Vendor Selection Settings</li>
	 * 	<li>Turn off Double-blind Communication switch</li>
	 * 	<li>Save Preferences</li>
	 * 	<li>Go to the users tab</li>
	 * 	<li>Select SubUser</li>
	 * 	<li>Check Place New Orders checkbox</li>
	 * 	<li>Check Submit to FHA permission</li>
	 * 	<li>Save User settings</li>
	 * 	<li>Place a new order via the API</li>
	 * 	<li>Assign the order to a vendor</li>
	 * 	<li>Accept and complete order as the vendor</li>
	 * 	<li>Log into Secure as the subuser</li>
	 * 	<li>Find and open the order</li>
	 * 	<li>Click Set status</li>
	 * 	<li>Click Submit to FHA</li>
	 * 	<li>Get outside frames</li>
	 * 	<li>Get inside the iframe</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the dialog contains text</li>
	 * 	<li>Log into Secure as the admin</li>
	 * 	<li>Go to the users tab</li>
	 * 	<li>Select SubUser</li>
	 * 	<li>UnCheck Submit to FHA permission</li>
	 * 	<li>Save User settings</li>
	 * 	<li>Place a new order via the API</li>
	 * 	<li>Assign the order to a vendor</li>
	 * 	<li>Accept and complete order as the vendor</li>
	 * 	<li>Log into Secure as the subuser</li>
	 * 	<li>Find and open the order</li>
	 * 	<li>Click Set status</li>
	 * 	<li>Verify FHA is not displayed in the list of dropdown options</li>
	 * 	<li>}End submitToFhaPermission</li>
	 * <ul>
	 * </ul>
	 * @throws Exception the exception
	 */

	@Test (retryAnalyzer = Retry.class, groups={"Secure - Users", "Secure - Permissions", "Secure - User Permissions", "AR207" ,"Edit/Update Orders",}, alwaysRun=true)
	public void submitToFhaPermission() throws Exception {
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		//Log into Secure as the admin
		secure.login(driver, "userpermissions",StoredVariables.getpassword().get());
		
		// Go to Vendor Selection Settings
		secure.goToVendorSelectionSettings(driver);

		// Turn off Double-blind Communication switch
		if (!SVendorSelectionSettings.doubleBlind_switch(driver).getAttribute("src").contains("switchOff.png"))
		{
			perform.click(driver, SVendorSelectionSettings.doubleBlind_switch(driver));
		} //end if

		secure.switchOff(driver, SVendorSelectionSettings.automaticOrderAssignment_switch(driver));

		secure.switchOff(driver, SVendorSelectionSettings.unattendedOrderReassignment_switch(driver));

		// Save Preferences
		secure.saveVendorSelectionSettings(driver);

		//Go to the users tab
		secure.goToUsers(driver);

		//Select SubUser
		secure.selectSubUser(driver, "Submit ToFHA");
		
		//Check Place New Orders checkbox
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Place New Orders"));

		//Check Submit to FHA permission
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Submit to FHA"));
		
		//Save User settings
		secure.saveUsersSettings(driver);
		
		//Place a new order via the API
		String trackingNumber = perform.apiPlaceOrderFromSecure(driver, "submittofhapermission", "T3sting1", "PlaceMNOrder-SubmittoFHAPermission");

		//Assign the order to a vendor
		secure.loginAndAssignOrderToAppraiserWithTrackingNumber(driver, "submittofhapermission", "T3sting1", trackingNumber, "Testvendor");

		//Accept and complete order as the vendor
		vendors.loginAcceptAndCompleteOrder(driver, "permissiontestvendor", "T3sting1", trackingNumber);				

		//Log into Secure as the subuser
		secure.login(driver, "submittofhapermission",StoredVariables.getpassword().get());

		//Find and open the order
		secure.findAndOpenOrder(driver, trackingNumber);

		// Click Set status
		perform.click(driver,SOrderDetails.setStatus_btn(driver));

		// Click Submit to FHA
		perform.clickInTable_Contains(driver, "Submit to FHA");

		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);

		// Get outside frames
		driver.switchTo().defaultContent();

		// Get inside the iframe
		perform.waitForiFrameSrcAndSwitchToIt(driver, "EADSubmit.aspx", By.id(SSubmitToFHA.internalNotes_txtbx()));

		// Get history text
		String screenText = SSubmitToFHA.submitToFha_dlg(driver).getText();

		// Verify the dialog contains text
		perform.verifyTextContains(driver, screenText, "Submit to FHA");

		//Log into Secure as the admin
		secure.login(driver, "userpermissions",StoredVariables.getpassword().get());

		//Go to the users tab
		secure.goToUsers(driver);

		//Select SubUser
		secure.selectSubUser(driver, "Submit ToFHA");

		//UnCheck Submit to FHA permission
		perform.uncheckCheckbox(driver, secure.getPermissionsCheckbox(driver,"Submit to FHA"));

		//Save User settings
		secure.saveUsersSettings(driver);

		//Place a new order via the API
		String trackingNumber1 = perform.apiPlaceOrderFromSecure(driver, "submittofhapermission", "T3sting1", "PlaceMNOrder-SubmittoFHAPermission");

		//Assign the order to a vendor
		secure.loginAndAssignOrderToAppraiserWithTrackingNumber(driver, "submittofhapermission", "T3sting1", trackingNumber1, "Testvendor");

		//Accept and complete order as the vendor
		vendors.loginAcceptAndCompleteOrder(driver, "permissiontestvendor", "T3sting1", trackingNumber1);				

		//Log into Secure as the subuser
		secure.login(driver, "submittofhapermission",StoredVariables.getpassword().get());

		//Find and open the order
		secure.findAndOpenOrder(driver, trackingNumber1);

		// Click Set status
		perform.click(driver,SOrderDetails.setStatus_btn(driver));

		//Verify FHA is not displayed in the list of dropdown options
		String submitToFha = SOrderDetails.setStatus_drpdwn(driver).getText();
		Assert.assertTrue(!submitToFha.contains("Submit To FHA"), "The Submit to FHA option is displayed");

	}//End submitToFhaPermission
	
	/**
	 * <p>
	 * STEPS:
	 * 	<li>Log into Secure as the admin</li>
	 * 	<li>Go to Vendor Selection Settings</li>
	 * 	<li>Turn off Double-blind Communication switch</li>
	 * 	<li>Save Preferences</li>
	 * 	<li>Go to the users tab</li>
	 * 	<li>Select SubUser</li>
	 * 	<li>Check Place New Orders checkbox</li>
	 * 	<li>Check Rate Vendors permission</li>
	 * 	<li>Save User settings</li>
	 * 	<li>Place a new order via the API</li>
	 * 	<li>Assign the order to a vendor</li>
	 * 	<li>Accept and complete order as the vendor</li>
	 * 	<li>Log into Secure as the subuser</li>
	 * 	<li>Find and open the order</li>
	 * 	<li>Verify the ratings section is displayed</li>
	 * 	<li>Log into Secure as the admin</li>
	 * 	<li>Go to the users tab</li>
	 * 	<li>Select SubUser</li>
	 * 	<li>Uncheck Rate Vendors permission</li>
	 * 	<li>Save User settings</li>
	 * 	<li>Place a new order via the API</li>
	 * 	<li>Assign the order to a vendor</li>
	 * 	<li>Accept and complete order as the vendor</li>
	 * 	<li>Log into Secure as the subuser</li>
	 * 	<li>Find and open the order</li>
	 * 	<li>Verify the ratings settings is not displayed</li>
	 * 	<li>}End rateVendorsPermission</li>
	 * <ul>
	 * </ul>
	 * @throws Exception the exception
	 */

	@Test (retryAnalyzer = Retry.class, groups={"Secure - Users", "Secure - Permissions", "Secure - User Permissions", "AR207" ,"Edit/Update Orders",}, alwaysRun=true)
	public void rateVendorsPermission() throws Exception {
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		//Log into Secure as the admin
		secure.login(driver, "userpermissions",StoredVariables.getpassword().get());
		
		// Go to Vendor Selection Settings
		secure.goToVendorSelectionSettings(driver);

		// Turn off Double-blind Communication switch
		if (!SVendorSelectionSettings.doubleBlind_switch(driver).getAttribute("src").contains("switchOff.png"))
		{
			perform.click(driver, SVendorSelectionSettings.doubleBlind_switch(driver));
		} //end if

		secure.switchOff(driver, SVendorSelectionSettings.automaticOrderAssignment_switch(driver));

		secure.switchOff(driver, SVendorSelectionSettings.unattendedOrderReassignment_switch(driver));

		// Save Preferences
		secure.saveVendorSelectionSettings(driver);

		//Go to the users tab
		secure.goToUsers(driver);

		//Select SubUser
		secure.selectSubUser(driver, "Rate Vendors");

		//Check Place New Orders checkbox
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Place New Orders"));

		//Check Rate Vendors permission
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Rate Vendors"));

		//Save User settings
		secure.saveUsersSettings(driver);

		//Place a new order via the API
		String trackingNumber = perform.apiPlaceOrderFromSecure(driver, "ratevendorspermission", "T3sting1", "PlaceMNOrder-RateVendorsPermission");

		//Assign the order to a vendor
		secure.loginAndAssignOrderToAppraiserWithTrackingNumber(driver, "ratevendorspermission", "T3sting1", trackingNumber, "Testvendor");

		//Accept and complete order as the vendor
		vendors.loginAcceptAndCompleteOrder(driver, "permissiontestvendor", "T3sting1", trackingNumber);				

		//Log into Secure as the subuser
		secure.login(driver, "ratevendorspermission",StoredVariables.getpassword().get());

		//Find and open the order
		secure.findAndOpenOrder(driver, trackingNumber);

		//Verify the ratings section is displayed
		String assignmentratings = SOrderDetails.assignmentRatings_chkbx(driver).getText();
		Assert.assertTrue(assignmentratings.contains("Assignment ratings"), "The Assignment Ratings section is not displayed");

		//Log into Secure as the admin
		secure.login(driver, "userpermissions",StoredVariables.getpassword().get());

		//Go to the users tab
		secure.goToUsers(driver);

		//Select SubUser
		secure.selectSubUser(driver, "Rate Vendors");

		//Uncheck Rate Vendors permission
		perform.uncheckCheckbox(driver, secure.getPermissionsCheckbox(driver,"Rate Vendors"));

		//Save User settings
		secure.saveUsersSettings(driver);

		//Place a new order via the API
		String trackingNumber1 = perform.apiPlaceOrderFromSecure(driver, "ratevendorspermission", "T3sting1", "PlaceMNOrder-RateVendorsPermission");

		//Assign the order to a vendor
		secure.loginAndAssignOrderToAppraiserWithTrackingNumber(driver, "ratevendorspermission", "T3sting1", trackingNumber1, "Testvendor");

		//Accept and complete order as the vendor
		vendors.loginAcceptAndCompleteOrder(driver, "permissiontestvendor", "T3sting1", trackingNumber1);				

		//Log into Secure as the subuser
		secure.login(driver, "ratevendorspermission",StoredVariables.getpassword().get());

		//Find and open the order
		secure.findAndOpenOrder(driver, trackingNumber1);

		//Verify the ratings settings is not displayed
		boolean exists = perform.checkIfElementExists(driver, By.id(SOrderDetails.assignmentRatings_chkbx()));
	    Assert.assertTrue(exists==false, "Assignment Ratings checkbox is displayed");
	    
	}//End rateVendorsPermission
	
	/**
	 * <p>
	 * STEPS:
	 * 	<li>Log into Secure as the admin</li>
	 * 	<li>Go to Vendor Selection Settings</li>
	 * 	<li>Turn off Double-blind Communication switch</li>
	 * 	<li>Save Preferences</li>
	 * 	<li>Go to the users tab</li>
	 * 	<li>Select SubUser</li>
	 * 	<li>Check Place New Orders checkbox</li>
	 * 	<li>Check Cover Vendor's Transaction Fee Permission</li>
	 * 	<li>Save User settings</li>
	 * 	<li>Log in as the subuser</li>
	 * 	<li>Go to Residential Appraisal</li>
	 * 	<li>Set Property Information data</li>
	 * 	<li>StoredVariables.getpropertyInformationStateAbbr().set("OK");  Must set for a field check later on</li>
	 * 	<li>Set Assignment Information data</li>
	 * 	<li>Set Lender Information data</li>
	 * 	<li>Enter New Order data</li>
	 * 	<li>Click Next</li>
	 * 	<li>Assign vendor</li>
	 * 	<li>Confirm order screen loads</li>
	 * 	<li>Log into Secure as the admin</li>
	 * 	<li>Go to the users tab</li>
	 * 	<li>Select SubUser</li>
	 * 	<li>Check Cover Vendor's Transaction Fee Permission</li>
	 * 	<li>Save User settings</li>
	 * 	<li>Log in as the subuser</li>
	 * 	<li>Go to Residential Appraisal</li>
	 * 	<li>Set Property Information data</li>
	 * 	<li>StoredVariables.getpropertyInformationStateAbbr().set("OK");  Must set for a field check later on</li>
	 * 	<li>Set Assignment Information data</li>
	 * 	<li>Set Lender Information data</li>
	 * 	<li>Enter New Order data</li>
	 * 	<li>Click Next</li>
	 * 	<li>Assign vendor</li>
	 * 	<li>Confirm order screen loads</li>
	 * <ul>
	 * </ul>
	 * @throws Exception the exception
	 */

	@Test (retryAnalyzer = Retry.class, groups={"Secure - Users", "Secure - Permissions", "Secure - User Permissions", "AR207" ,"Edit/Update Orders",}, alwaysRun=true)
	public void coverVendorsTransactionFeePermission() throws Exception {
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		//Log into Secure as the admin
		secure.login(driver, "userpermissions",StoredVariables.getpassword().get());
		
		// Go to Vendor Selection Settings
		secure.goToVendorSelectionSettings(driver);

		// Turn off Double-blind Communication switch
		if (!SVendorSelectionSettings.doubleBlind_switch(driver).getAttribute("src").contains("switchOff.png"))
		{
			perform.click(driver, SVendorSelectionSettings.doubleBlind_switch(driver));
		} //end if

		secure.switchOff(driver, SVendorSelectionSettings.automaticOrderAssignment_switch(driver));

		secure.switchOff(driver, SVendorSelectionSettings.unattendedOrderReassignment_switch(driver));

		// Save Preferences
		secure.saveVendorSelectionSettings(driver);

		//Go to the users tab
		secure.goToUsers(driver);

		//Select SubUser
		secure.selectSubUser(driver, "Cover Transactionfee");

		//Check Place New Orders checkbox
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Place New Orders"));

		//Check Cover Vendor's Transaction Fee Permission
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Cover Vendor's Transaction Fee"));

		//Save User settings
		secure.saveUsersSettings(driver);

		//Log in as the subuser
		secure.login(driver, "covertransactionfee",StoredVariables.getpassword().get());

		// Go to Residential Appraisal
		secure.goToResidentialAppraisal(driver);

		// Set Property Information data
		StoredVariables.getpropertyInformationAddress().set("1100 NW 38th st");
		StoredVariables.getpropertyInformationCity().set("Oklahoma City");
		StoredVariables.getpropertyInformationState().set("Oklahoma");
		StoredVariables.getpropertyInformationStateAbbr().set("OK"); // Must set for a field check later on
		StoredVariables.getpropertyInformationZip().set("73118");
		StoredVariables.getpropertyInformationSqFt().set("3697");
		StoredVariables.getpropertyInformationSiteSize().set("9,583 sq ft");
		StoredVariables.getpropertyInformationPropType().set("Single Family");
		StoredVariables.getpropertyInformationPropRights().set("Fee Simple");
		StoredVariables.getpropertyInformationLegalDesc().set("2320 NW 196th terrace");
		StoredVariables.getpropertyInformationDirections().set(perform.randomNumbers(driver, 8));

		// Set Assignment Information data
		StoredVariables.getassignmentInformationForm().set("Uniform Residential Appraisal (FNMA 1004)");
		StoredVariables.getassignmentInformationOrderDue().set(7);
		perform.getNewDate(driver, StoredVariables.getassignmentInformationOrderDue().get());
		StoredVariables.getassignmentInformationLoanNumber().set("564897123");
		StoredVariables.getassignmentInformationAssignedTo().set("");

		// Set Lender Information data
		StoredVariables.getlenderInformationLenderName().set("Lending tree bank");
		StoredVariables.getlenderInformationAddress1().set("1100 bank rd");
		StoredVariables.getlenderInformationAddress2().set("Suite D");
		StoredVariables.getlenderInformationCity().set("Tulsa");
		StoredVariables.getlenderInformationState().set("OK");
		StoredVariables.getlenderInformationZip().set("74172");

		// Enter New Order data
		secure.enterNewResidentialAppraisalOrder(driver);

		// Click Next
		perform.click(driver, SNewOrder.next_btn(driver));

		// Assign vendor
		secure.selectVendor(driver, "Permissions Testvendor");

		// Confirm order screen loads
		Assert.assertTrue(driver.getCurrentUrl().contains("ConfirmOrder"), "Confirm Order page did not load");

		boolean checkbox = perform.checkIfElementExists(driver, By.id("chkPayTransaction"));
		Assert.assertTrue(checkbox == true, "The Pay Transaction Fee Checkbox is displayed");

		perform.click(driver, SNewOrder.payTransactionFee_chkbx(driver));

		perform.verifyTextContains(driver, SNewOrder.payTransactionFee_txt(driver).getText(), "You have chosen to cover the transaction fee for the current order. Therefore, your account will be charged the Mercury Network transaction fee of $14.50 when the vendor accepts this order.");

		perform.checkIfElementExists(driver, By.id("chkPaymentNoticeAgree"));

		perform.checkCheckbox(driver, SNewOrder.payTransactionFeesecond_txtbx(driver));

		//Log into Secure as the admin
		secure.login(driver, "userpermissions",StoredVariables.getpassword().get());

		//Go to the users tab
		secure.goToUsers(driver);

		//Select SubUser
		secure.selectSubUser(driver, "Cover Transactionfee");

		//Check Cover Vendor's Transaction Fee Permission
		perform.uncheckCheckbox(driver, secure.getPermissionsCheckbox(driver,"Cover Vendor's Transaction Fee"));

		//Save User settings
		secure.saveUsersSettings(driver);

		//Log in as the subuser
		secure.login(driver, "covertransactionfee",StoredVariables.getpassword().get());

		// Go to Residential Appraisal
		secure.goToResidentialAppraisal(driver);

		// Set Property Information data
		StoredVariables.getpropertyInformationAddress().set("1100 NW 38th st");
		StoredVariables.getpropertyInformationCity().set("Oklahoma City");
		StoredVariables.getpropertyInformationState().set("Oklahoma");
		StoredVariables.getpropertyInformationStateAbbr().set("OK"); // Must set for a field check later on
		StoredVariables.getpropertyInformationZip().set("73118");
		StoredVariables.getpropertyInformationSqFt().set("3697");
		StoredVariables.getpropertyInformationSiteSize().set("9,583 sq ft");
		StoredVariables.getpropertyInformationPropType().set("Single Family");
		StoredVariables.getpropertyInformationPropRights().set("Fee Simple");
		StoredVariables.getpropertyInformationLegalDesc().set("2320 NW 196th terrace");
		StoredVariables.getpropertyInformationDirections().set(perform.randomNumbers(driver, 8));

		// Set Assignment Information data
		StoredVariables.getassignmentInformationForm().set("Uniform Residential Appraisal (FNMA 1004)");
		StoredVariables.getassignmentInformationOrderDue().set(7);
		perform.getNewDate(driver, StoredVariables.getassignmentInformationOrderDue().get());
		StoredVariables.getassignmentInformationLoanNumber().set("564897123");
		StoredVariables.getassignmentInformationAssignedTo().set("");

		// Set Lender Information data
		StoredVariables.getlenderInformationLenderName().set("Lending tree bank");
		StoredVariables.getlenderInformationAddress1().set("1100 bank rd");
		StoredVariables.getlenderInformationAddress2().set("Suite D");
		StoredVariables.getlenderInformationCity().set("Tulsa");
		StoredVariables.getlenderInformationState().set("OK");
		StoredVariables.getlenderInformationZip().set("74172");

		// Enter New Order data
		secure.enterNewResidentialAppraisalOrder(driver);

		// Click Next
		perform.click(driver, SNewOrder.next_btn(driver));

		// Assign vendor
		secure.selectVendor(driver, "Permissions Testvendor");

		// Confirm order screen loads
		Assert.assertTrue(driver.getCurrentUrl().contains("ConfirmOrder"), "Confirm Order page did not load");

		Assert.assertTrue(SNewOrder.payTransactionFee_chkbx(driver).getAttribute("disabled").equals("true"), "The transaction fee checkbox is not disabled");


	}

	/**
	 * <p>
	 * STEPS:
	 * 	<li>Log into Secure as the admin</li>
	 * 	<li>Go to the users tab</li>
	 * 	<li>Select SubUser</li>
	 * 	<li>Check Place New Orders checkbox</li>
	 * 	<li>Check AQM Settings Permission</li>
	 * 	<li>Save User settings</li>
	 * 	<li>Log in as the subuser</li>
	 * 	<li>Go to Preferences &gt; AQM settings</li>
	 * 	<li>Verify AQM settings page loaded</li>
	 * 	<li>Log into Secure as the admin</li>
	 * 	<li>Go to the users tab</li>
	 * 	<li>Select SubUser</li>
	 * 	<li>Check AQM Settings Permission</li>
	 * 	<li>Save User settings</li>
	 * 	<li>Log in as the subuser</li>
	 * 	<li>Click to Preferences</li>
	 * 	<li>Select Appraisal Quality Management Settings</li>
	 * 	<li>Verify the Not Authorized dialg is displayed</li>
	 * 	<li>}End aqmSettingsPermission</li>
	 * <ul>
	 * </ul>
	 * @throws Exception the exception
	 */

	@Test (retryAnalyzer = Retry.class, groups={"Secure - Users", "Secure - Permissions", "Secure - User Permissions", "AR207" ,"Edit/Update Orders",}, alwaysRun=true)
	public void aqmSettingsPermission() throws Exception {
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		//Log into Secure as the admin
		secure.login(driver, "userpermissions",StoredVariables.getpassword().get());

		//Go to the users tab
		secure.goToUsers(driver);

		//Select SubUser
		secure.selectSubUser(driver, "AQM Settings");

		//Check Place New Orders checkbox
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Place New Orders"));

		//Check AQM Settings Permission
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"AQM Settings"));

		//Save User settings
		secure.saveUsersSettings(driver);

		//Log in as the subuser
		secure.login(driver, "aqmsettings",StoredVariables.getpassword().get());

		//Go to Preferences > AQM settings
		secure.goToAppraisalQualityManagementSettings(driver);

		//Verify AQM settings page loaded
		perform.verifyURL(driver, "AQM.aspx");

		//Log into Secure as the admin
		secure.login(driver, "userpermissions",StoredVariables.getpassword().get());

		//Go to the users tab
		secure.goToUsers(driver);

		//Select SubUser
		secure.selectSubUser(driver, "AQM Settings");

		//Check AQM Settings Permission
		perform.uncheckCheckbox(driver, secure.getPermissionsCheckbox(driver,"AQM Settings"));

		//Save User settings
		secure.saveUsersSettings(driver);

		//Log in as the subuser
		secure.login(driver, "aqmsettings",StoredVariables.getpassword().get());

		// Click to Preferences
		perform.click(driver, SOrders.preferences_btn(driver));

		// Select Appraisal Quality Management Settings
		perform.click(driver, SPreferences.appraisalQualityManagementSettings_btn(driver));

		//Verify the Not Authorized dialog is displayed
		perform.verification(driver, SOrderDetails.notAuthorized_dialog(driver).getText(), "contains", "Not Authorized");


	}//End aqmSettingsPermission
	
	/**
	 * <p>
	 * STEPS:
	 * 	<li>Log into Secure as the admin</li>
	 * 	<li>Go to the users tab</li>
	 * 	<li>Select SubUser</li>
	 * 	<li>Check Place New Orders checkbox</li>
	 * 	<li>Check Order Product Requirements Permission</li>
	 * 	<li>Save User settings</li>
	 * 	<li>Log in as the subuser</li>
	 * 	<li>Go to Preferences &gt; Product Requirements</li>
	 * 	<li>Verify Product Requirements page loaded</li>
	 * 	<li>Log into Secure as the admin</li>
	 * 	<li>Go to the users tab</li>
	 * 	<li>Select SubUser</li>
	 * 	<li>Uncheck Product Requirements Permission</li>
	 * 	<li>Save User settings</li>
	 * 	<li>Log in as the subuser</li>
	 * 	<li>Click to Preferences</li>
	 * 	<li>Select Product Requirements</li>
	 * 	<li>Verify the Not Authorized dialog is displayed</li>
	 * 	<li>}End productRequirementsPermission</li>
	 * <ul>
	 * </ul>
	 * @throws Exception the exception
	 */

	@Test (retryAnalyzer = Retry.class, groups={"Secure - Users", "Secure - Permissions", "Secure - User Permissions", "AR207" ,"Edit/Update Orders",}, alwaysRun=true)
	public void productRequirementsPermission() throws Exception {
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		//Log into Secure as the admin
		secure.login(driver, "userpermissions",StoredVariables.getpassword().get());
		
		//Go to the users tab
		secure.goToUsers(driver);

		//Select SubUser
		secure.selectSubUser(driver, "Product Requirements");
		
		//Check Place New Orders checkbox
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Place New Orders"));

		//Check Order Product Requirements Permission
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Order Product Requirements"));
		
		//Save User settings
		secure.saveUsersSettings(driver);

		//Log in as the subuser
		secure.login(driver, "productrequirements",StoredVariables.getpassword().get());

		//Go to Preferences > Product Requirements
		secure.goToProductRequirements(driver);

		//Verify Product Requirements page loaded
		perform.verifyURL(driver, "ProductOptions.aspx");

		//Log into Secure as the admin
		secure.login(driver, "userpermissions",StoredVariables.getpassword().get());

		//Go to the users tab
		secure.goToUsers(driver);

		//Select SubUser
		secure.selectSubUser(driver, "Product Requirements");

		//Uncheck Product Requirements Permission
		perform.uncheckCheckbox(driver, secure.getPermissionsCheckbox(driver,"Order Product Requirements"));

		//Save User settings
		secure.saveUsersSettings(driver);

		//Log in as the subuser
		secure.login(driver, "productrequirements",StoredVariables.getpassword().get());

		// Click to Preferences
		perform.click(driver, SOrders.preferences_btn(driver));

		// Select Product Requirements
		perform.click(driver, SPreferences.productRequirements_btn(driver));

		//Verify the Not Authorized dialog is displayed
		perform.verification(driver, SOrderDetails.notAuthorized_dialog(driver).getText(), "contains", "Not Authorized");


	}//End productRequirementsPermission
	
	/**
	 * <p>
	 * STEPS:
	* 	<li>Log into Secure as the admin</li>
	 * 	<li>Go to the users tab</li>
	 * 	<li>Select SubUser</li>
	 * 	<li>Check VMP XSites Permission</li>
	 * 	<li>Save User settings</li>
	 * 	<li>Log in as the subuser</li>
	 * 	<li>Go to Preferences &gt; VMP XSites</li>
	 * 	<li>Verify Product Requirements page loaded</li>
	 * 	<li>Log into Secure as the admin</li>
	 * 	<li>Go to the users tab</li>
	 * 	<li>Select SubUser</li>
	 * 	<li>Uncheck Product Requirements Permission</li>
	 * 	<li>Save User settings</li>
	 * 	<li>Log in as the subuser</li>
	 * 	<li>Click to Preferences</li>
	 * 	<li>Select VMP XSites</li>
	 * 	<li>Verify the Not Authorized dialog is displayed</li>
	 * 	<li>}End productRequirementsPermission</li>
	 * <ul>
	 * </ul>
	 * @throws Exception the exception
	 */
	
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Users", "Secure - Permissions", "Secure - User Permissions", "AR207" ,"Edit/Update Orders",}, alwaysRun=true)
	public void vmpXsitesPermission() throws Exception {
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		//Log into Secure as the admin
		secure.login(driver, "userpermissions",StoredVariables.getpassword().get());
		
		//Go to the users tab
		secure.goToUsers(driver);

		//Select SubUser
		secure.selectSubUser(driver, "VMP XSites");

		//Check VMP XSites Permission
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"VMP XSites"));

		//Save User settings
		secure.saveUsersSettings(driver);

		//Log in as the subuser
		secure.login(driver, "vmpxsitespermission",StoredVariables.getpassword().get());

		//Go to Preferences > VMP XSites
		secure.goToVMPXSites(driver);

		//Verify Product Requirements page loaded
		perform.verifyURL(driver, "VMPProducts.aspx");

		//Log into Secure as the admin
		secure.login(driver, "userpermissions",StoredVariables.getpassword().get());

		//Go to the users tab
		secure.goToUsers(driver);

		//Select SubUser
		secure.selectSubUser(driver, "VMP XSites");

		//Uncheck Product Requirements Permission
		perform.uncheckCheckbox(driver, secure.getPermissionsCheckbox(driver,"VMP XSites"));

		//Save User settings
		secure.saveUsersSettings(driver);

		//Log in as the subuser
		secure.login(driver, "vmpxsitespermission",StoredVariables.getpassword().get());

		// Click to Preferences
		perform.click(driver, SOrders.preferences_btn(driver));

		// Select VMP XSites
		perform.click(driver, SPreferences.vmpXSites_btn(driver));

		//Verify the Not Authorized dialog is displayed
		perform.verification(driver, SOrderDetails.notAuthorized_dialog(driver).getText(), "contains", "Not Authorized");


	}//End productRequirementsPermission
	
	/**
	 * <p>
	 * STEPS:
	 * 	<li>Log into Secure as the admin</li>
	 * 	<li>Go to the users tab</li>
	 * 	<li>Select SubUser</li>
	 * 	<li>Check Vendor Selection Settings permission</li>
	 * 	<li>Save User settings</li>
	 * 	<li>Log in as the subuser</li>
	 * 	<li>Go to Preferences &gt; Vendor Selection Settings</li>
	 * 	<li>Verify the vendor seletion page loads</li>
	 * 	<li>Log into Secure as the admin</li>
	 * 	<li>Go to the users tab</li>
	 * 	<li>Select SubUser</li>
	 * 	<li>Uncheck Product Vendor Selection Settings</li>
	 * 	<li>Save User settings</li>
	 * 	<li>Log in as the subuser</li>
	 * 	<li>Click to Preferences</li>
	 * 	<li>Select Vendor Selection Settings</li>
	 * 	<li>Verify the Not Authorized dialog is displayed</li>
	 * 	<li>}End productRequirementsPermission</li>
	 * <ul>
	 * </ul>
	 * @throws Exception the exception
	 */
	
	
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Users", "Secure - Permissions", "Secure - User Permissions", "AR207" ,"Edit/Update Orders",}, alwaysRun=true)
	public void vendorSlectionSettingsPermission() throws Exception {
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		//Log into Secure as the admin
		secure.login(driver, "userpermissions",StoredVariables.getpassword().get());
		
		//Go to the users tab
		secure.goToUsers(driver);

		//Select SubUser
		secure.selectSubUser(driver, "Vendor Selection");

		//Check Vendor Selection Settings permission
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Vendor Selection Settings"));

		//Save User settings
		secure.saveUsersSettings(driver);

		//Log in as the subuser
		secure.login(driver, "vendorselectionsettings",StoredVariables.getpassword().get());

		//Go to Preferences > Vendor Selection Settings
		secure.goToVendorSelectionSettings(driver);

		//Verify the vendor seletion page loads
		perform.verifyURL(driver, "VendorSelection.aspx");

		//Log into Secure as the admin
		secure.login(driver, "userpermissions",StoredVariables.getpassword().get());

		//Go to the users tab
		secure.goToUsers(driver);

		//Select SubUser
		secure.selectSubUser(driver, "Vendor Selection");

		//Uncheck Product Vendor Selection Settings
		perform.uncheckCheckbox(driver, secure.getPermissionsCheckbox(driver,"Vendor Selection Settings"));

		//Save User settings
		secure.saveUsersSettings(driver);

		//Log in as the subuser
		secure.login(driver, "vendorselectionsettings",StoredVariables.getpassword().get());

		// Click to Preferences
		perform.click(driver, SOrders.preferences_btn(driver));

		// Select Vendor Selection Settings
		perform.click(driver, SPreferences.vendorSelectionSettings_btn(driver));
		
		//Verify the Not Authorized dialog is displayed
		perform.verification(driver, SOrderDetails.notAuthorized_dialog(driver).getText(), "contains", "Not Authorized");


	}//End productRequirementsPermission
	
	/**
	 * <p>
	 * STEPS:
	 * 	<li>Log into Secure as the admin</li>
	 * 	<li>Go to the users tab</li>
	 * 	<li>Select SubUser</li>
	 * 	<li>Check Vendor Selection Settings permission</li>
	 * 	<li>Save User settings</li>
	 * 	<li>Log in as the subuser</li>
	 * 	<li>Go to Preferences &gt; Vendor Selection Settings</li>
	 * 	<li>Verify the Client page loads</li>
	 * 	<li>Log into Secure as the admin</li>
	 * 	<li>Go to the users tab</li>
	 * 	<li>Select SubUser</li>
	 * 	<li>Uncheck Vendor Selection Settings permission</li>1
	 * 	<li>Save User Settings</li>
	 * 	<li>Log in as the subuser</li>
	 * 	<li>Click the Clients tab</li>
	 * 	<li>Verify the Not Authorized dialog is displayed</li>
	 * 	<li>}End clientManagementPermission</li>
	 * <ul>
	 * </ul>
	 * @throws Exception the exception
	 */

	@Test (retryAnalyzer = Retry.class, groups={"Secure - Users", "Secure - Permissions", "Secure - User Permissions", "AR207" ,"Edit/Update Orders",}, alwaysRun=true)
	public void clientManagementPermission() throws Exception {
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();


		//Log into Secure as the admin
		secure.login(driver, "userpermissions",StoredVariables.getpassword().get());

		//Go to the users tab
		secure.goToUsers(driver);

		//Select SubUser
		secure.selectSubUser(driver, "Client Management");
		
		//Check Vendor Selection Settings permission
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Client Management"));

		//Save User settings
		secure.saveUsersSettings(driver);

		//Log in as the subuser
		secure.login(driver, "clientmanagement",StoredVariables.getpassword().get());

		//Go to Preferences > Vendor Selection Settings
		secure.goToClients(driver);

		//Verify the Client page loads
		perform.verifyURL(driver, "ClientManagement/Contacts.aspx");

		//Log into Secure as the admin
		secure.login(driver, "userpermissions",StoredVariables.getpassword().get());

		//Go to the users tab
		secure.goToUsers(driver);

		//Select SubUser
		secure.selectSubUser(driver, "Client Management");

		//Uncheck Vendor Selection Settings permission
		perform.uncheckCheckbox(driver, secure.getPermissionsCheckbox(driver,"Client Management"));

		//Save User Settings
		secure.saveUsersSettings(driver);

		//Log in as the subuser
		secure.login(driver, "clientmanagement",StoredVariables.getpassword().get());

		// Click Clients
		perform.click(driver, SOrders.clients_btn(driver));

		//Verify the Not Authorized dialog is displayed
		perform.verification(driver, SOrderDetails.notAuthorized_dialog(driver).getText(), "contains", "Not Authorized");

	}//End clientManagementPermission
	
	/**
	 * <p>
	 * STEPS:
	 * 	<li>Log into Secure as the admin</li>
	 * 	<li>Go to the users tab</li>
	 * 	<li>Select SubUser</li>
	 * 	<li>Check View Management Reports permission</li>
	 * 	<li>Check Manage Fee Panel Permission</li>
	 * 	<li>Save User Settings</li>
	 * 	<li>Login as the subuser</li>
	 * 	<li>Go to the in progress tab in reports</li>
	 * 	<li>Verify the correct page loads</li>
	 * 	<li>Go to the completed tab in reports</li>
	 * 	<li>Verify the correct page loads</li>
	 * 	<li>Go to the New Requests tab in reports</li>
	 * 	<li>Verify the correct page loads</li>
	 * 	<li>Go to the Fee panel reports tab in reports</li>
	 * 	<li>Verify the correct page loads</li>
	 * 	<li>Go to the Work in progress tab in reports</li>
	 * 	<li>Verify the correct page loads</li>
	 * 	<li>Log into Secure as the admin</li>
	 * 	<li>Go to the users tab</li>
	 * 	<li>Select SubUser</li>
	 * 	<li>Uncheck View Management Reports permission</li>
	 * 	<li>Save User Settings</li>
	 * 	<li>Login as the subuser</li>
	 * 	<li>Click on Reports</li>
	 * 	<li>Verify the Not Authorized dialog is displayed</li>
	 * <ul>
	 * </ul>
	 * @throws Exception the exception
	 */

	@Test (retryAnalyzer = Retry.class, groups={"Secure - Users", "Secure - Permissions", "Secure - User Permissions", "AR207" ,"Edit/Update Orders",}, alwaysRun=true)
	public void viewManagementReportsPermission() throws Exception {
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		//Log into Secure as the admin
		secure.login(driver, "userpermissions",StoredVariables.getpassword().get());

		//Go to the users tab
		secure.goToUsers(driver);

		//Select SubUser
		secure.selectSubUser(driver, "View Reports");

		//Check View Management Reports permission
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"View Management Reports"));

		//Check Manage Fee Panel Permission
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Manage Fee Panel"));

		//Save User Settings
		secure.saveUsersSettings(driver);

		//Login as the subuser
		secure.login(driver, "viewreportspermission", StoredVariables.getpassword().get());

		//Go to the in progress tab in reports
		secure.goToInProgressReports(driver);

		//Verify the correct page loads
		perform.verifyURL(driver, "OrderStatus.aspx?status=InProgress");

		//Go to the completed tab in reports
		secure.goToCompletedReports(driver);

		//Verify the correct page loads
		perform.verifyURL(driver, "OrderStatus.aspx?status=Completed");

		//Go to the New Requests tab in reports
		secure.goToNewRequestsReports(driver);

		//Verify the correct page loads
		perform.verifyURL(driver, "OrderStatus.aspx?status=Pending");

		//Go to the Fee panel reports tab in reports
		secure.goToFeePanelReports(driver);

		//Verify the correct page loads
		perform.verifyURL(driver, "Admin/Reporting/FeePanel.aspx");

		//Go to the Work in progress tab in reports
		secure.goToWorkInProgressReports(driver);

		//Verify the correct page loads
		perform.verifyURL(driver, "Reporting/WorkInProgress.aspx");

		//Log into Secure as the admin
		secure.login(driver, "userpermissions",StoredVariables.getpassword().get());

		//Go to the users tab
		secure.goToUsers(driver);

		//Select SubUser
		secure.selectSubUser(driver, "View Reports");

		//Uncheck View Management Reports permission
		perform.uncheckCheckbox(driver, secure.getPermissionsCheckbox(driver,"View Management Reports"));

		//Save User Settings
		secure.saveUsersSettings(driver);

		//Login as the subuser
		secure.login(driver, "viewreportspermission", StoredVariables.getpassword().get());

		// Click on Reports
		perform.click(driver, SOrders.reports_btn(driver));

		//Verify the Not Authorized dialog is displayed
		perform.verification(driver, SOrderDetails.notAuthorized_dialog(driver).getText(), "contains", "Not Authorized");


	}//End viewManagementReportsPermission test
	
	/**
	 * <p>
	 * STEPS:
	 * 	<li>Log into Secure as the admin</li>
	 * 	<li>Go to the users tab</li>
	 * 	<li>Select SubUser</li>
	 * 	<li>Check View Management Reports permission</li>
	 * 	<li>Check Manage Fee Panel Permission</li>
	 * 	<li>Save User Settings</li>
	 * 	<li>Login as the subuser</li>
	 * 	<li>Go to the in progress tab in reports</li>
	 * 	<li>Verify the correct page loads</li>
	 * 	<li>Go to the completed tab in reports</li>
	 * 	<li>Verify the correct page loads</li>
	 * 	<li>Go to the New Requests tab in reports</li>
	 * 	<li>Verify the correct page loads</li>
	 * 	<li>Go to the Fee panel reports tab in reports</li>
	 * 	<li>Verify the correct page loads</li>
	 * 	<li>Go to the Work in progress tab in reports</li>
	 * 	<li>Verify the correct page loads</li>
	 * 	<li>Log into Secure as the admin</li>
	 * 	<li>Go to the users tab</li>
	 * 	<li>Select SubUser</li>
	 * 	<li>Uncheck View Management Reports permission</li>
	 * 	<li>Save User Settings</li>
	 * 	<li>Login as the subuser</li>
	 * 	<li>Click on Reports</li>
	 * 	<li>Verify the Not Authorized dialog is displayed</li>
	 * <ul>
	 * </ul>
	 * @throws Exception the exception
	 */
	
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Users", "Secure - Permissions", "Secure - User Permissions", "AR207" ,"Edit/Update Orders",}, alwaysRun=true)
	public void manageAccountPermission() throws Exception {
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		//Log into Secure as the admin
		secure.login(driver, "userpermissions",StoredVariables.getpassword().get());

		//Go to the users tab
		secure.goToUsers(driver);

		//Select SubUser
		secure.selectSubUser(driver, "Manage Account");

		//Check View Management Reports permission
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Manage Account"));

		//Save User Settings
		secure.saveUsersSettings(driver);

		//Login as the subuser
		secure.login(driver, "manageaccountpermission", StoredVariables.getpassword().get());
		
		//Go to the Account tab
		secure.goToAccount(driver);
		
		//Verify the correct page loads
		perform.verifyURL(driver, "AccountManagement/Account.aspx");
		
		//Log into Secure as the admin
		secure.login(driver, "userpermissions",StoredVariables.getpassword().get());

		//Go to the users tab
		secure.goToUsers(driver);

		//Select SubUser
		secure.selectSubUser(driver, "Manage Account");

		//Uncheck View Management Reports permission
		perform.uncheckCheckbox(driver, secure.getPermissionsCheckbox(driver,"Manage Account"));

		//Save User Settings
		secure.saveUsersSettings(driver);

		//Login as the subuser
		secure.login(driver, "manageaccountpermission", StoredVariables.getpassword().get());

		//Verify the account tab is not displayed
		boolean exists = perform.checkIfElementExists(driver, By.id(SOrders.account_btn()));
		perform.verification(driver, exists, "==", false);


	}//End manageAccountPermission
	
	/**
	 * <p>
	 * STEPS:
	 * 	<li>Log into Secure as the admin</li>
	 * 	<li>Go to the users tab</li>
	 * 	<li>Select SubUser</li>
	 * 	<li>Check Manage Payments permission</li>
	 * 	<li>Save User Settings</li>
	 * 	<li>Log into Secure as the subuser</li>
	 * 	<li>Go to the payments tab</li>
	 * 	<li>Verify the payments page loads correctly</li>
	 * 	<li>Login to Secure as the admin</li>
	 * 	<li>Go to users tab</li>
	 * 	<li>Select SubUser</li>
	 * 	<li>Uncheck Manage Payments permission</li>
	 * 	<li>Save User Settings</li>
	 * 	<li>Log into Secure as the subuser</li>
	 * 	<li>Verify the Payments tab is not displayed</li>
	 * 	<li>} End managePaymentsPermission</li>
	 *  <ul>
	 * </ul>
	 * @throws Exception the exception
	 */
	

	@Test (retryAnalyzer = Retry.class, groups={"Secure - Users", "Secure - Permissions", "Secure - User Permissions", "AR207" ,"Edit/Update Orders",}, alwaysRun=true)
	public void managePaymentsPermission() throws Exception {
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		

		//Log into Secure as the admin
		secure.login(driver, "userpermissions",StoredVariables.getpassword().get());

		//Go to the users tab
		secure.goToUsers(driver);

		//Select SubUser
		secure.selectSubUser(driver, "Manage Payments");
		
		//Check Manage Payments permission
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver, "Manage Payments"));
		
		//Save User Settings
		secure.saveUsersSettings(driver);
		
		//Log into Secure as the subuser
		secure.login(driver, "managepaymentstpermission", StoredVariables.getpassword().get());
		
		//Go to the payments tab
		perform.click(driver, SOrders.paymentsMain_btn(driver));

		//Verify the payments page loads correctly
		perform.verifyURL(driver, "Payments/Accounting.aspx");

		//Login to Secure as the admin
		secure.login(driver, "userpermissions",StoredVariables.getpassword().get());
		
		//Go to users tab
		secure.goToUsers(driver);

		//Select SubUser
		secure.selectSubUser(driver, "Manage Payments");
		
		//Uncheck Manage Payments permission
		perform.uncheckCheckbox(driver, secure.getPermissionsCheckbox(driver,"Manage Payments"));

		//Save User Settings
		secure.saveUsersSettings(driver);

		//Log into Secure as the subuser
		secure.login(driver, "managepaymentstpermission", StoredVariables.getpassword().get());
		
		//Verify the Payments tab is not displayed
		String style = SOrders.paymentsMain_btn(driver).getAttribute("style"); 
		perform.verification(driver, style, "contains", "none");
		

	}// End managePaymentsPermission
	
	/**
	 * <p>
	 * STEPS:
	 * 	<li>Log into Secure as the admin</li>
	 * 	<li>Go to the users tab</li>
	 * 	<li>Select SubUser</li>
	 * 	<li>Check Manage Connections permission</li>
	 * 	<li>Save User Settings</li>
	 * 	<li>Log in as subuser</li>
	 * 	<li>Go to Connection Settings</li>
	 * 	<li>Verify Connection Settings loads</li>
	 * 	<li>Log back into Secure as the admin</li>
	 * 	<li>Go to the users tab</li>
	 * 	<li>Select SubUser</li>
	 * 	<li>Uncheck Manage Connections permission</li>
	 * 	<li>Save User Settings</li>
	 * 	<li>Log in as subuser</li>
	 * 	<li>Click to Preferences</li>
	 * 	<li>Select Connection Settings</li>
	 * 	<li>Verify the Not Authorized dialog is displayed</li>
	 * 	<li>}End manageConnectionsPermission</li>
	 *  <ul>
	 * </ul>
	 * @throws Exception the exception
	 */
	
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Users", "Secure - Permissions", "Secure - User Permissions", "AR207" ,"Edit/Update Orders",}, alwaysRun=true)
	public void manageConnectionsPermission() throws Exception {
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		//Log into Secure as the admin
		secure.login(driver, "userpermissions", StoredVariables.getpassword().get());
		
		//Go to the users tab
		secure.goToUsers(driver);

		//Select SubUser
		secure.selectSubUser(driver, "Manage Connections");
		
		//Check Manage Connections permission
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver, "Add/Manage Connections"));
		
		//Save User Settings
		secure.saveUsersSettings(driver);
		
		//Log in as subuser
		secure.login(driver, "manageconnections", StoredVariables.getpassword().get());
		
		//Go to Connection Settings
		secure.goToConnectionSettings(driver);
		
		//Verify Connection Settings loads
		perform.verifyURL(driver, "Preferences/ConnectionSettings.aspx");
		
		//Log back into Secure as the admin
		secure.login(driver, "userpermissions", StoredVariables.getpassword().get());
		
		//Go to the users tab
		secure.goToUsers(driver);

		//Select SubUser
		secure.selectSubUser(driver, "Manage Connections");
		
		//Uncheck Manage Connections permission
		perform.uncheckCheckbox(driver, secure.getPermissionsCheckbox(driver, "Add/Manage Connections"));
		
		//Save User Settings
		secure.saveUsersSettings(driver);

		//Log in as subuser
		secure.login(driver, "manageconnections", StoredVariables.getpassword().get());

		// Click to Preferences
		perform.click(driver, SOrders.preferences_btn(driver));

		// Select Connection Settings
		perform.click(driver, SPreferences.connectionSettings_btn(driver));

		//Verify the Not Authorized dialog is displayed
		perform.verification(driver, SOrderDetails.notAuthorized_dialog(driver).getText(), "contains", "Not Authorized");


	}//End manageConnectionsPermission
	
	/**
	 * <p>
	 * STEPS:
	  * 	<li>Login to Secure as the admin</li>
	 * 	<li>Go to the users tab</li>
	 * 	<li>Select a subuser</li>
	 * 	<li>Check Add/Manage User Accounts permission</li>
	 * 	<li>Save user settings</li>
	 * 	<li>login as the subuser</li>
	 * 	<li>Go to the Users tab</li>
	 * 	<li>Verify the Users page loaded</li>
	 * 	<li>Login to Secure as the admin</li>
	 * 	<li>Go to the users tab</li>
	 * 	<li>Select a subuser</li>
	 * 	<li>Uncheck Add/Manage User Accounts permission</li>
	 * 	<li>Save user settings</li>
	 * 	<li>login as the subuser</li>
	 * 	<li>Verify the User's tab is not displayed</li>
	 * 	<li>}End manageUserAccountsPermission</li>
	 *  <ul>
	 * </ul>
	 * @throws Exception the exception
	 */

	@Test (retryAnalyzer = Retry.class, groups={"Secure - Users", "Secure - Permissions", "Secure - User Permissions", "AR207" ,"Edit/Update Orders",}, alwaysRun=true)
	public void manageUserAccountsPermission() throws Exception {
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		//Login to Secure as the admin
		secure.login(driver, "userpermissions", StoredVariables.getpassword().get());

		//Go to the users tab
		secure.goToUsers(driver);

		//Select a subuser
		secure.selectSubUser(driver, "Manage Useraccounts");

		//Check Add/Manage User Accounts permission
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Add/Manage User Accounts"));

		//Save user settings
		secure.saveUsersSettings(driver);

		//login as the subuser
		secure.login(driver, "manageuseraccounts", StoredVariables.getpassword().get());

		//Go to the Users tab
		secure.goToUsers(driver);

		//Verify the Users page loaded
		perform.verifyURL(driver, "UserManagement/UserManagement.aspx");

		//Login to Secure as the admin
		secure.login(driver, "userpermissions", StoredVariables.getpassword().get());

		//Go to the users tab
		secure.goToUsers(driver);

		//Select a subuser
		secure.selectSubUser(driver, "Manage Useraccounts");

		//Uncheck Add/Manage User Accounts permission
		perform.uncheckCheckbox(driver, secure.getPermissionsCheckbox(driver,"Add/Manage User Accounts"));

		//Save user settings
		secure.saveUsersSettings(driver);

		//login as the subuser
		secure.login(driver, "manageuseraccounts", StoredVariables.getpassword().get());
		
		perform.verification(driver, perform.getParent(driver, SOrders.users_btn(driver)).getAttribute("style"),
				"contains", "none");
		
		
	}//End manageUserAccountsPermission
	
	/**
	 * <p>
	 * STEPS:
     *  <li>Log into Secure as the admin</li>
	 * 	<li>Go to the users tab</li>
	 * 	<li>Select SubUser</li>
	 * 	<li>Uncheck Manage Fee Panel permission</li>
	 * 	<li>Check Fee Panel Read Only Permission</li>
	 * 	<li>Save User Settings</li>
	 * 	<li>login to Secure as the subuser</li>
	 * 	<li>Go to the Fee Panel tab</li>
	 * 	<li>Select vendor</li>
	 * 	<li>Verify the add button is disabled</li>
	 * 	<li>Verify the remove button is disabled</li>
	 * 	<li>Verify the Mark Ineligible button is disabled</li>
	 * 	<li>Verify the Build Fee Panel button is disabled</li>
	 * 	<li>Verify the Options button is disabled</li>
	 * 	<li>Log into Secure as the admin</li>
	 * 	<li>Go to the users tab</li>
	 * 	<li>Select SubUser</li>
	 * 	<li>Check Manage Fee Panel</li>
	 * 	<li>Save User Settings</li>
	 * 	<li>login to Secure as the subuser</li>
	 * 	<li>Go to the fee panel tab</li>
	 * 	<li>Verify the add button is enabled</li>
	 * 	<li>Go to the Fee Panel tab</li>
	 * 	<li>Select vendor</li>
	 * 	<li>Verify the Mark Ineligible button is enabled</li>
	 * 	<li>Verify the Contact Vendor button is displayed</li>
	 * 	<li>Verify build fee panel is displayed</li>
	 * 	<li>Verify options is displayed</li>
	 *  <ul>
	 * </ul>
	 * @throws Exception the exception
	 */

	@Test (retryAnalyzer = Retry.class, groups={"Secure - Users", "Secure - Permissions", "Secure - User Permissions", "AR207" ,"Edit/Update Orders",}, alwaysRun=true)
	public void feePanelReadOnlyPermission() throws Exception {
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		//Log into Secure as the admin
		secure.login(driver, "userpermissions", StoredVariables.getpassword().get());

		//Go to the users tab
		secure.goToUsers(driver);

		//Select SubUser
		secure.selectSubUser(driver, "Feepanel Readonly");

		//Uncheck Manage Fee Panel permission
		perform.uncheckCheckbox(driver, secure.getPermissionsCheckbox(driver,"Manage Fee Panel"));

		//Check Fee Panel Read Only Permission
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Fee Panel (Read Only"));

		//Save User Settings
		secure.saveUsersSettings(driver);

		//login to Secure as the subuser
		secure.login(driver, "feepanelreadonly", StoredVariables.getpassword().get());

		//Go to the Fee Panel tab
		secure.goToFeePanel(driver);

		// Select vendor
		perform.clickInTable_Contains(driver, "Permissions");

		perform.sleep(driver, 2);

		//Verify the add button is disabled
		perform.verification(driver, SFeePanel.add_btndisabled(driver).isDisplayed(),"==",true);

		//Verify the remove button is disabled
		perform.verification(driver, SFeePanel.removedisabled_btn(driver).isDisplayed(),"==", true);
		
		//Verify the Mark Ineligible button is disabled
		perform.verification(driver, SFeePanel.markIneligibledisabled_btn(driver).isDisplayed(),"==", true);
		
		//Verify the Build Fee Panel button is disabled
		perform.verification(driver, SFeePanel.buildFeePaneldisabled_btn(driver).isDisplayed(),"==", true);
		
		//Verify the Options button is disabled
		perform.verification(driver, SFeePanel.Optionsdisabled_btn(driver).isDisplayed(), "==", true);
		
		//Log into Secure as the admin
		secure.login(driver, "userpermissions", StoredVariables.getpassword().get());

		//Go to the users tab
		secure.goToUsers(driver);

		//Select SubUser
		secure.selectSubUser(driver, "Feepanel Readonly");

		//Check Manage Fee Panel
		perform.checkCheckbox(driver, secure.getPermissionsCheckbox(driver,"Manage Fee Panel"));
		
		//Save User Settings
		secure.saveUsersSettings(driver);

		//login to Secure as the subuser
		secure.login(driver, "feepanelreadonly", StoredVariables.getpassword().get());
		
		//Go to the fee panel tab
		secure.goToFeePanel(driver);

		//Verify the add button is enabled
		perform.verification(driver, SFeePanel.add_btn(driver).isDisplayed(),"==",true);

		//Go to the Fee Panel tab
		secure.goToFeePanel(driver);

		// Select vendor
		perform.clickInTable_Contains(driver, "Permissions");
		
		perform.sleep(driver, 2);
		
		//Verify the Mark Ineligible button is enabled
	    perform.verification(driver, SFeePanel.markIneligible_btn(driver).isDisplayed(),"==",true);
	    
	    //Verify the Contact Vendor button is displayed
	    perform.verification(driver, SFeePanel.contactVendor_btn(driver).isDisplayed(),"==",true);
	    
	    //Verify build fee panel is displayed
	    perform.verification(driver, SFeePanel.buildFeePanel_btn(driver).isDisplayed(),"==",true);
	    
	    //Verify options is displayed
	    perform.verification(driver, SFeePanel.options_btn(driver).isDisplayed(),"==",true);
	    


	}//End feePanelReadOnlyPermission

}














