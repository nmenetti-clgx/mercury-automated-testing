package baselineSecure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Secure.SAppraisalQualityManagementSettings;
import pageObjects.Secure.SClientGroups_AQM;
import pageObjects.Secure.SClientGroups_Automated;
import pageObjects.Secure.SClientGroups_Details;
import pageObjects.Secure.SClientGroups_Members;
import pageObjects.Secure.SClientGroups_OrderGroups;
import pageObjects.Secure.SClients;
import pageObjects.Secure.SClients_AddContact;
import pageObjects.Secure.SClients_ClientGroups;
import pageObjects.Secure.SClients_FeeTables;
import pageObjects.Secure.SClients_OrderRouting;
import pageObjects.Secure.SConfigureAutomaticSettings;
import pageObjects.Secure.SConfigureOrderForm;
import pageObjects.Secure.SConnectionSettings;
import pageObjects.Secure.SVMPXSites;
import pageObjects.Secure.SVendorSelectionSettings;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Baseline Secure - Clients</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class Secure_Clients extends TestSetup {
	
	/** The user. */
	private static String user = "Baseline4";
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Go to Clients</li>
	 * 	<li>Get table text</li>
	 * 	<li>Delete existing contacts</li>
	 * 	<li>Get table text</li>
	 * 	<li>Click Add</li>
	 * 	<li>Click New Contact</li>
	 * 	<li>Switch to new window</li>
	 * 	<li>Check Client</li>
	 * 	<li>Scroll element into view</li>
	 * 	<li>Enter username</li>
	 * 	<li>Scroll element into view</li>
	 * 	<li>Enter password</li>
	 * 	<li>Scroll element into view</li>
	 * 	<li>Enter Confirm</li>
	 * 	<li>Scroll element into view</li>
	 * 	<li>Check Permitted access to ALL XSite orders</li>
	 * 	<li>Scroll element into view</li>
	 * 	<li>Click Yes</li>
	 * 	<li>Scroll element into view</li>
	 * 	<li>Enter First</li>
	 * 	<li>Scroll element into view</li>
	 * 	<li>Enter Middle</li>
	 * 	<li>Scroll element into view</li>
	 * 	<li>Enter Last</li>
	 * 	<li>Scroll element into view</li>
	 * 	<li>Enter Job Title</li>
	 * 	<li>Scroll element into view</li>
	 * 	<li>Enter Designation</li>
	 * 	<li>Scroll element into view</li>
	 * 	<li>Select Salutation</li>
	 * 	<li>Scroll element into view</li>
	 * 	<li>Select Suffix</li>
	 * 	<li>Scroll element into view</li>
	 * 	<li>Select Use address below radio button</li>
	 * 	<li>Scroll element into view</li>
	 * 	<li>Select Assign to Company</li>
	 * 	<li>Scroll element into view</li>
	 * 	<li>Enter Address 1</li>
	 * 	<li>Scroll element into view</li>
	 * 	<li>Enter Address 2</li>
	 * 	<li>Scroll element into view</li>
	 * 	<li>Enter City</li>
	 * 	<li>Scroll element into view</li>
	 * 	<li>Enter State</li>
	 * 	<li>Scroll element into view</li>
	 * 	<li>Enter Zip</li>
	 * 	<li>Scroll element into view</li>
	 * 	<li>Select Country</li>
	 * 	<li>Scroll element into view</li>
	 * 	<li>Enter Website</li>
	 * 	<li>Scroll element into view</li>
	 * 	<li>Enter Work</li>
	 * 	<li>Scroll element into view</li>
	 * 	<li>Enter Personal</li>
	 * 	<li>Scroll element into view</li>
	 * 	<li>Select Work Primary</li>
	 * 	<li>Scroll element into view</li>
	 * 	<li>Enter Business</li>
	 * 	<li>Scroll element into view</li>
	 * 	<li>Enter Business Extension</li>
	 * 	<li>Scroll element into view</li>
	 * 	<li>Select Business Primary</li>
	 * 	<li>Scroll element into view</li>
	 * 	<li>Enter Home</li>
	 * 	<li>Scroll element into view</li>
	 * 	<li>Enter Home Extension</li>
	 * 	<li>Scroll element into view</li>
	 * 	<li>Enter Fax</li>
	 * 	<li>Scroll element into view</li>
	 * 	<li>Enter Fax Extension</li>
	 * 	<li>Scroll element into view</li>
	 * 	<li>Enter Mobile</li>
	 * 	<li>Scroll element into view</li>
	 * 	<li>Enter Mobile Extension</li>
	 * 	<li>Scroll element into view</li>
	 * 	<li>Enter Assistant</li>
	 * 	<li>Scroll element into view</li>
	 * 	<li>Enter Assistant Extension</li>
	 * 	<li>Scroll the Save button into view</li>
	 * 	<li>Click Save</li>
	 * 	<li>Switch back to main window</li>
	 * 	<li>Verify new contact exists in the table</li>
	 * 	<li>Log test</li>
	 * </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Clients", "Secure - Add Contact"}, alwaysRun=true)
	public void addNewContact() throws Exception {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Login to Secure
		secure.login(driver, user, StoredVariables.getpassword().get());
		
		// Go to Clients
		secure.goToClients(driver);
		
		// Get table text
		String text = SClients_AddContact.contactsTable_txt(driver).getText();
		
		// Delete existing contacts
		while (text.contains("Contact"))
		{
			secure.deleteContactInClients(driver);
			
			// Get table text
			text = SClients_AddContact.contactsTable_txt(driver).getText();
			
		} // end while
		
		// Click Add
		perform.click(driver, SClients.add_btn(driver));
		
		// Click New Contact
		perform.clickInDiv_Contains(driver, "New Contact");
		
		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		// Switch to new window
		perform.switchToXSiteWindowByTitle(driver, "Contact Details");
		
		// Wait for First txtbx
		perform.waitForElementToBeClickable(driver, SClients_AddContact.first_txtbx(), "id");
		
		Thread.sleep(5000);
		
		// Check Client
		perform.click(driver, SClients_AddContact.client_chkbx(driver));
		
		Thread.sleep(500);
		
		// Scroll element into view
		perform.scrollElementIntoView(driver, SClients_AddContact.username_txtbx(driver));
		
		// Enter username
		perform.type(driver, SClients_AddContact.username_txtbx(driver), "testuser"+perform.randomNumbers(driver, 8));

		// Scroll element into view
		perform.scrollElementIntoView(driver, SClients_AddContact.password_txtbx(driver));
		
		// Enter password
		perform.type(driver, SClients_AddContact.password_txtbx(driver), StoredVariables.getpassword().get());

		// Scroll element into view
		perform.scrollElementIntoView(driver, SClients_AddContact.confirm_txtbx(driver));

		// Enter Confirm
		perform.type(driver, SClients_AddContact.confirm_txtbx(driver), StoredVariables.getpassword().get());

		// Scroll element into view
		perform.scrollElementIntoView(driver, SClients_AddContact.permittedAccessToAllXSiteOrders_chkbx(driver));
		
		// Check Permitted access to ALL XSite orders
		perform.click(driver,SClients_AddContact.permittedAccessToAllXSiteOrders_chkbx(driver));

		// Wait for yes
		perform.waitForElementToBeClickable(driver, SClients_AddContact.yes_btn(), "id");

		// Scroll element into view
		perform.scrollElementIntoView(driver, SClients_AddContact.yes_btn(driver));
		
		// Click Yes
		perform.click(driver, SClients_AddContact.yes_btn(driver));

		// Scroll element into view
		perform.scrollElementIntoView(driver, SClients_AddContact.first_txtbx(driver));
		
		// Enter First
		perform.type(driver, SClients_AddContact.first_txtbx(driver), "Automation");

		// Scroll element into view
		perform.scrollElementIntoView(driver, SClients_AddContact.middle_txtbx(driver));
		
		// Enter Middle
		perform.type(driver, SClients_AddContact.middle_txtbx(driver), "Mercury");

		// Scroll element into view
		perform.scrollElementIntoView(driver, SClients_AddContact.last_txtbx(driver));
		
		// Enter Last
		perform.type(driver, SClients_AddContact.last_txtbx(driver), "Contact");

		// Scroll element into view
		perform.scrollElementIntoView(driver, SClients_AddContact.jobTitle_txtbx(driver));
		
		// Enter Job Title
		perform.type(driver, SClients_AddContact.jobTitle_txtbx(driver), "Test Automation Engineer");

		// Scroll element into view
		perform.scrollElementIntoView(driver, SClients_AddContact.designation_txtbx(driver));
		
		// Enter Designation
		perform.type(driver, SClients_AddContact.designation_txtbx(driver), "Test");

		// Scroll element into view
		perform.scrollElementIntoView(driver, SClients_AddContact.salutation_dropdown(driver));
		
		// Select Salutation
		perform.selectDropdownOption(driver, SClients_AddContact.salutation_dropdown(driver), "Mr.");

		// Scroll element into view
		perform.scrollElementIntoView(driver, SClients_AddContact.suffix_dropdown(driver));
		
		// Select Suffix
		perform.selectDropdownOption(driver, SClients_AddContact.suffix_dropdown(driver), "None");

		// Scroll element into view
		perform.scrollElementIntoView(driver, SClients_AddContact.useAddressBelow_radiobtn(driver));
		
		// Select Use address below radio button
		perform.click(driver, SClients_AddContact.useAddressBelow_radiobtn(driver));

		// Scroll element into view
		perform.scrollElementIntoView(driver, SClients_AddContact.assignToCompany_dropdown(driver));
		
		// Select Assign to Company
		perform.selectDropdownOption(driver, SClients_AddContact.assignToCompany_dropdown(driver), "None");

		// Scroll element into view
		perform.scrollElementIntoView(driver, SClients_AddContact.address1_txtbx(driver));
		
		// Enter Address 1
		perform.type(driver, SClients_AddContact.address1_txtbx(driver), "501-D NE 122nd St");

		// Scroll element into view
		perform.scrollElementIntoView(driver, SClients_AddContact.address2_txtbx(driver));
		
		// Enter Address 2
		perform.type(driver, SClients_AddContact.address2_txtbx(driver), "Suite D");

		// Scroll element into view
		perform.scrollElementIntoView(driver, SClients_AddContact.city_txtbx(driver));
		
		// Enter City
		perform.type(driver, SClients_AddContact.city_txtbx(driver), "Oklahoma City");

		// Scroll element into view
		perform.scrollElementIntoView(driver, SClients_AddContact.state_txtbx(driver));
		
		// Enter State
		perform.type(driver, SClients_AddContact.state_txtbx(driver), "OK");

		// Scroll element into view
		perform.scrollElementIntoView(driver, SClients_AddContact.zip_txtbx(driver));
		
		// Enter Zip
		perform.type(driver, SClients_AddContact.zip_txtbx(driver), "73114");

		// Scroll element into view
		perform.scrollElementIntoView(driver, SClients_AddContact.country_dropdown(driver));
		
		// Select Country
		perform.selectDropdownOption(driver, SClients_AddContact.country_dropdown(driver), "United States");

		// Scroll element into view
		perform.scrollElementIntoView(driver, SClients_AddContact.website_txtbx(driver));
		
		// Enter Website
		perform.type(driver, SClients_AddContact.website_txtbx(driver), "mercuryvmp.com");

		// Scroll element into view
		perform.scrollElementIntoView(driver, SClients_AddContact.work_txtbx(driver));
		
		// Enter Work
		perform.type(driver, SClients_AddContact.work_txtbx(driver), "work@dntest.net");

		// Scroll element into view
		perform.scrollElementIntoView(driver, SClients_AddContact.personal_txtbx(driver));
		
		// Enter Personal
		perform.type(driver, SClients_AddContact.personal_txtbx(driver), "personal@dntest.net");

		// Scroll element into view
		perform.scrollElementIntoView(driver, SClients_AddContact.workPrimary_radiobtn(driver));
		
		// Select Work Primary
		perform.click(driver, SClients_AddContact.workPrimary_radiobtn(driver));

		// Scroll element into view
		perform.scrollElementIntoView(driver, SClients_AddContact.business_txtbx(driver));
		
		// Enter Business
		perform.type(driver, SClients_AddContact.business_txtbx(driver), "4053001450");

		// Scroll element into view
		perform.scrollElementIntoView(driver, SClients_AddContact.businessExtension_txtbx(driver));
		
		// Enter Business Extension
		perform.type(driver, SClients_AddContact.businessExtension_txtbx(driver), "123");

		// Scroll element into view
		perform.scrollElementIntoView(driver, SClients_AddContact.businessPrimary_radiobtn(driver));
		
		// Select Business Primary
		perform.click(driver, SClients_AddContact.businessPrimary_radiobtn(driver));

		// Scroll element into view
		perform.scrollElementIntoView(driver, SClients_AddContact.home_txtbx(driver));
		
		// Enter Home
		perform.type(driver, SClients_AddContact.home_txtbx(driver), "4055551234");

		// Scroll element into view
		perform.scrollElementIntoView(driver, SClients_AddContact.homeExtension_txtbx(driver));
		
		// Enter Home Extension
		perform.type(driver, SClients_AddContact.homeExtension_txtbx(driver), "234");

		// Scroll element into view
		perform.scrollElementIntoView(driver, SClients_AddContact.fax_txtbx(driver));
		
		// Enter Fax
		perform.type(driver, SClients_AddContact.fax_txtbx(driver), "4055552345");

		// Scroll element into view
		perform.scrollElementIntoView(driver, SClients_AddContact.faxExtension_txtbx(driver));
		
		// Enter Fax Extension
		perform.type(driver, SClients_AddContact.faxExtension_txtbx(driver), "345");

		// Scroll element into view
		perform.scrollElementIntoView(driver, SClients_AddContact.mobile_txtbx(driver));
		
		// Enter Mobile
		perform.type(driver, SClients_AddContact.mobile_txtbx(driver), "4055553456");

		// Scroll element into view
		perform.scrollElementIntoView(driver, SClients_AddContact.mobileExtension_txtbx(driver));
		
		// Enter Mobile Extension
		perform.type(driver, SClients_AddContact.mobileExtension_txtbx(driver), "456");

		// Scroll element into view
		perform.scrollElementIntoView(driver, SClients_AddContact.assistant_txtbx(driver));
		
		// Enter Assistant
		perform.type(driver, SClients_AddContact.assistant_txtbx(driver), "4055554567");

		// Scroll element into view
		perform.scrollElementIntoView(driver, SClients_AddContact.assistantExtension_txtbx(driver));
		
		// Enter Assistant Extension
		perform.type(driver, SClients_AddContact.assistantExtension_txtbx(driver), "567");
		
		// Scroll the Save button into view
		perform.scrollElementIntoView(driver, SClients_AddContact.save_btn(driver));
		
		// Click Save
		perform.click(driver, SClients_AddContact.save_btn(driver));
		
		// Switch back to main window
		driver.switchTo().window(StoredVariables.getwinHandleBefore().get());
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Wait for table
		perform.waitForElementToBeClickable(driver, SClients_AddContact.contactsTable_txt(), "id");
		
		Thread.sleep(5000);
		
		// Wait for text
		perform.waitForText(driver, SClients_AddContact.contactsTable_txt(driver), "Contact");
		
		// Verify new contact exists in the table
		text = SClients_AddContact.contactsTable_txt(driver).getText();
		Assert.assertTrue(text.contains("Contact"), "The new contact is not displayed in the Contacts table");
		
		// Log test
		test.log(LogStatus.INFO, "clients", "Added a new contact");
		
	} // end addNewContact
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Go to Clients</li>
	 * 	<li>Click Contact</li>
	 * 	<li>Click Edit</li>
	 * 	<li>Switch to new window</li>
	 * 	<li>Edit the Last name</li>
	 * 	<li>Click Save</li>
	 * 	<li>Switch back to main window</li>
	 * 	<li>Verify new contact exists in the table</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Clients", "Secure - Edit Contact"}, dependsOnMethods={"addNewContact"})
	public void editNewContact() throws Exception {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Login to Secure
		secure.login(driver, user, StoredVariables.getpassword().get());
		
		// Go to Clients
		secure.goToClients(driver);
		
		perform.waitForText(driver, SClients.contactsGrid_txt(driver), "Contact");
		
		// Click Contact
		perform.clickInTable_Contains(driver, "Contact");
		
		// Click Edit
		perform.click(driver, SClients.edit_btn(driver));
		
		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		// Switch to new window
		perform.switchToXSiteWindowByTitle(driver, "Contact Details");
		
		// Wait for First txtbx
		perform.waitForElementToBeClickable(driver, SClients_AddContact.first_txtbx(), "id");
		
		// Edit the Last name
		SClients_AddContact.first_txtbx(driver).clear();
		perform.type(driver, SClients_AddContact.first_txtbx(driver), "Automation Edited");
		
		// Click Save
		perform.click(driver, SClients_AddContact.save_btn(driver));
		
		// Switch back to main window
		driver.switchTo().window(StoredVariables.getwinHandleBefore().get());
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Verify new contact exists in the table
		perform.waitForElementToBeClickable(driver, SClients_AddContact.contactsTable_txt(), "id");
		String text = SClients_AddContact.contactsTable_txt(driver).getText();
		perform.waitForText(driver, SClients_AddContact.contactsTable_txt(driver), "Automation Edited");
		Assert.assertTrue(text.contains("Automation Edited"), "The new contact is not displayed in the Contacts table");
		
		// Log test
		test.log(LogStatus.INFO, "clients", "Edited the new contact");
		
	} // end editNewContact
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Go to Clients</li>
	 * 	<li>Delete the contact</li>
	 * 	<li>Verify new contact exists in the table</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Clients", "Secure - Delete Contact"}, dependsOnMethods={"editNewContact"})
	public void deleteNewContact() throws Exception {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Login to Secure
		secure.login(driver, user, StoredVariables.getpassword().get());
		
		// Go to Clients
		secure.goToClients(driver);
 
		// Delete the contact
		secure.deleteContactInClients(driver);
			
		// Verify new contact exists in the table
		String text = SClients_AddContact.contactsTable_txt(driver).getText();
		Assert.assertTrue(!text.contains("Contact"), "The new contact was not deleted in the Contacts table");
		
		// Log test
		test.log(LogStatus.INFO, "clients", "Deleted the new contact");
		
	} // end deleteNewContact
	
	/**
 * <p>
 * STEPS:
 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Go to Clients</li>
	 * 	<li>Click Order Routing</li>
	 * 	<li>Click Manage Round Robin Groups</li>
	 * 	<li>Verify popup header text</li>
	 * 	<li>Check if group already exists, if so delete them</li>
	 * 	<li>Click on Test Round Robin Group</li>
	 * 	<li>Click Delete Group</li>
	 * 	<li>Verify Confirm Delete dialog text</li>
	 * 	<li>Click Yes</li>
	 * 	<li>Verify group got deleted</li>
	 * 	<li>Click New Group</li>
	 * 	<li>Enter Round Robin Group Description</li>
	 * 	<li>Click Save</li>
	 * 	<li>Verify group got created</li>
	 * 	<li>Click close</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Clients", "Secure - Create Round Robin Group"}, alwaysRun=true, dependsOnMethods={"deleteNewContact"})
	public void createRoundRobinGroup() throws Exception {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Login to Secure
		secure.login(driver, user, StoredVariables.getpassword().get());
		
		// Go to Clients
		secure.goToClients(driver);
		
		// Click Order Routing
		perform.click(driver, SClients.orderRouting_btn(driver));
		
		// Click Manage Round Robin Groups
		perform.clickInDiv_Contains(driver, "Manage Round Robin Groups...");
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		Thread.sleep(1500);
		
		// Switch into iFrame
		perform.switchToiFrameByID(driver, "frameDialogL1");
		
		// Verify popup header text
		String text = SClients_OrderRouting.dialogRoundRobinGroups_txt(driver).getText();
		Assert.assertTrue(text.contains("Round Robin Groups"), "The dialog is incorrect");
		
		// Check if group already exists, if so delete them
		while (text.contains("Test Round Robin Group"))
		{
			
			// Click on Test Round Robin Group
			perform.clickInDiv_Contains(driver, "Test Round Robin Group");
			
			// Click Delete Group
			perform.clickInTable_Equals(driver, "Delete Group");
			
			// Wait for Yes button
			perform.waitForElementToBeClickable(driver, SClients_OrderRouting.yesDelete_btn(), "cssSelector");
			
			// Verify Confirm Delete dialog text
			Assert.assertTrue(SClients_OrderRouting.dialogConfirmDelete_txt(driver).getText().contains("Are you sure you want to delete the selected Round Robin Group?"), "The dialog text is incorrect");
			
			// Click Yes
			perform.click(driver, SClients_OrderRouting.yesDelete_btn(driver));
			
			// Wait for delete dialog to go away
			String style = SClients_OrderRouting.dialogConfirmDelete_txt(driver).getAttribute("style");
			while (style.contains("block"))
			{
				Thread.sleep(500);
				style = SClients_OrderRouting.dialogConfirmDelete_txt(driver).getAttribute("style");
			}
			
			Thread.sleep(2000);
			
			// Verify group got deleted
			Assert.assertTrue(!SClients_OrderRouting.dialogRoundRobinGroups_txt(driver).getText().contains("Test Round Robin Group"), "The group was not deleted");
			
			text = SClients_OrderRouting.dialogRoundRobinGroups_txt(driver).getText();
			
		} // end while
		
		// Click New Group
		perform.clickInTable_Equals(driver, "New Group");
		
		Thread.sleep(2000);
		
		// Switch into iFrame
		driver.switchTo().defaultContent();
		perform.switchToiFrameByID(driver, "frameDialogL1");
		
		// Wait for Round Robin Group Description
		perform.waitForElementToBeClickable(driver, SClients_OrderRouting.roundRobinGroupDescription_txtbx(), "id");
		
		// Enter Round Robin Group Description
		perform.type(driver, SClients_OrderRouting.roundRobinGroupDescription_txtbx(driver), "Test Round Robin Group");
		
		// Click Save
		perform.clickInTable_Equals(driver, "Save");
		
		Thread.sleep(2000);
		
		// Switch into iFrame
		driver.switchTo().defaultContent();
		perform.switchToiFrameByID(driver, "frameDialogL1");
		
		// Wait for group to be saved
		perform.waitForText(driver, SClients_OrderRouting.dialogRoundRobinGroups_txt(driver), "Test Round Robin Group");
		
		// Verify group got created
		Assert.assertTrue(SClients_OrderRouting.dialogRoundRobinGroups_txt(driver).getText().contains("Test Round Robin Group"), "The group was not created");
		
//		// Click close
//		perform.click(driver, SClients_OrderRouting.closeDialog_btn(driver));
		
		// Switch out of iFrame
		driver.switchTo().defaultContent();
		
		// Log test
		test.log(LogStatus.INFO, "clients", "Created new Round Robin Group");
		
	} // end createRoundRobinGroup
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Go to Clients</li>
	 * 	<li>Click Order Routing</li>
	 * 	<li>Click Manage Round Robin Groups</li>
	 * 	<li>Click on Test Round Robin Group</li>
	 * 	<li>Click Delete Group</li>
	 * 	<li>Verify Confirm Delete dialog text</li>
	 * 	<li>Click Yes</li>
	 * 	<li>Verify group got deleted</li>
	 * 	<li>Click close</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Clients", "Secure - Delete Round Robin Group"}, dependsOnMethods={"createRoundRobinGroup"})
	public void deleteRoundRobinGroup() throws Exception {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Login to Secure
		secure.login(driver, user, StoredVariables.getpassword().get());
		
		// Go to Clients
		secure.goToClients(driver);
		
		// Click Order Routing
		perform.click(driver, SClients.orderRouting_btn(driver));
		
		// Click Manage Round Robin Groups
		perform.clickInDiv_Contains(driver, "Manage Round Robin Groups...");
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Switch into iFrame
		perform.switchToiFrameByID(driver, "frameDialogL1");
		
		// Click on Test Round Robin Group
		perform.clickInDiv_Contains(driver, "Test Round Robin Group");
		
		// Click Delete Group
		perform.clickInTable_Equals(driver, "Delete Group");
		
		// Wait for Yes button
		perform.waitForElementToBeClickable(driver, SClients_OrderRouting.yesDelete_btn(), "cssSelector");
		
		// Verify Confirm Delete dialog text
		Assert.assertTrue(SClients_OrderRouting.dialogConfirmDelete_txt(driver).getText().contains("Are you sure you want to delete the selected Round Robin Group?"), "The dialog text is incorrect");
		
		// Click Yes
		perform.click(driver, SClients_OrderRouting.yesDelete_btn(driver));
		
		// Wait for delete dialog to go away
		String style = SClients_OrderRouting.dialogConfirmDelete_txt(driver).getAttribute("style");
		while (style.contains("block"))
		{
			Thread.sleep(500);
			style = SClients_OrderRouting.dialogConfirmDelete_txt(driver).getAttribute("style");
		}
		
		Thread.sleep(2000);
		
		// Verify group got deleted
		Assert.assertTrue(!SClients_OrderRouting.dialogRoundRobinGroups_txt(driver).getText().contains("Test Round Robin Group"), "The group was not deleted");
		
//		// Click close
//		perform.click(driver, SClients_OrderRouting.closeDialog_btn(driver));
		
		// Switch out of iFrame
		driver.switchTo().defaultContent();
		
		// Log test
		test.log(LogStatus.INFO, "clients", "Deleted Round Robin Group");
		
	} // end deleteRoundRobinGroup
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Go to Clients</li>
	 * 	<li>Click Fee Tables</li>
	 * 	<li>Click Manage Custom Fee Tables</li>
	 * 	<li>Verify popup header text</li>
	 * 	<li>Check if group already exists, if so delete them</li>
	 * 	<li>Click on Test Fee Table</li>
	 * 	<li>Click Delete Fee Table</li>
	 * 	<li>Verify Confirm Delete dialog text</li>
	 * 	<li>Click Yes</li>
	 * 	<li>Verify group got deleted</li>
	 * 	<li>Click New Fee Table</li>
	 * 	<li>Enter Round Robin Group Description</li>
	 * 	<li>Click Save</li>
	 * 	<li>Verify group got created</li>
	 * 	<li>Click close</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Clients", "Secure - Fee Tables", "Secure - Create Fee Table"}, alwaysRun=true, dependsOnMethods={"deleteRoundRobinGroup"})
	public void createFeeTable() throws Exception {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Login to Secure
		secure.login(driver, user, StoredVariables.getpassword().get());
		
		// Go to Clients
		secure.goToClients(driver);
		
		// Click Fee Tables
		perform.click(driver, SClients.feeTables_btn(driver));
		
		// Click Manage Custom Fee Tables
		perform.clickInDiv_Contains(driver, "Manage Custom Fee Tables...");
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Switch into iFrame
		perform.switchToiFrameByID(driver, "frameDialogL1");
		
		// Verify popup header text
		perform.waitForElementToBeClickable(driver, SClients_FeeTables.dialogFeeTables_txt(driver));
		String text = SClients_FeeTables.dialogFeeTables_txt(driver).getText();
		Assert.assertTrue(SClients_FeeTables.dialogFeeTables_txt(driver).getText().contains("Fee Tables"), "The dialog is incorrect");
		
		// Check if group already exists, if so delete them
		while (text.contains("Test Fee Table"))
		{
			
			// Click on Test Fee Table
			perform.clickInDiv_Contains(driver, "Test Fee Table");
			
			// Click Delete Fee Table
			perform.clickInTable_Equals(driver, "Delete Fee Table");
			
			// Wait for Yes button
			perform.waitForElementToBeClickable(driver, SClients_FeeTables.yesDelete_btn(), "cssSelector");
			
			// Verify Confirm Delete dialog text
			Assert.assertTrue(SClients_FeeTables.dialogConfirmDelete_txt(driver).getText().contains("Are you sure you want to delete the selected fee table?"), "The dialog text is incorrect");
			
			// Click Yes
			perform.click(driver, SClients_FeeTables.yesDelete_btn(driver));
			
			// Wait for delete dialog to go away
			String style = SClients_FeeTables.dialogConfirmDelete_txt(driver).getAttribute("style");
			while (style.contains("block"))
			{
				Thread.sleep(500);
				style = SClients_FeeTables.dialogConfirmDelete_txt(driver).getAttribute("style");
			}
			
			Thread.sleep(2000);
			
			// Verify group got deleted
			Assert.assertTrue(!SClients_FeeTables.dialogFeeTables_txt(driver).getText().contains("Test Fee Table"), "The group was not deleted");
			
			text = SClients_FeeTables.dialogFeeTables_txt(driver).getText();
			
		} // end while
		
		// Click New Fee Table
		perform.clickInTable_Equals(driver, "New Fee Table");
		
		// Switch into iFrame
		driver.switchTo().defaultContent();
		perform.switchToiFrameByID(driver, "frameDialogL1");
		
		// Wait for Fee Table Description
		perform.waitForElementToBeClickable(driver, SClients_FeeTables.feeTableDescription_txtbx(), "id");
		
		// Enter Round Robin Group Description
		perform.type(driver, SClients_FeeTables.feeTableDescription_txtbx(driver), "Test Fee Table");
		
		// Click Save
		perform.clickInTable_Equals(driver, "Save");
		
		Thread.sleep(2000);
		
		// Switch into iFrame
		driver.switchTo().defaultContent();
		perform.switchToiFrameByID(driver, "frameDialogL1");
		
		// Wait for group to be saved
		perform.waitForText(driver, SClients_FeeTables.dialogFeeTables_txt(driver), "Test Fee Table");
		
		// Verify group got created
		Assert.assertTrue(SClients_FeeTables.dialogFeeTables_txt(driver).getText().contains("Test Fee Table"), "The fee table was not created");
		
//		// Click close
//		perform.click(driver, SClients_OrderRouting.closeDialog_btn(driver));
		
		// Switch out of iFrame
		driver.switchTo().defaultContent();
		
		// Log test
		test.log(LogStatus.INFO, "clients", "Created a new Fee Table");
		
	} // end createFeeTable
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Go to Clients</li>
	 * 	<li>Click Fee Tables</li>
	 * 	<li>Click Manage Custom Fee Tables</li>
	 * 	<li>Click on Test Fee Table</li>
	 * 	<li>Click Delete Fee Table</li>
	 * 	<li>Verify Confirm Delete dialog text</li>
	 * 	<li>Click Yes</li>
	 * 	<li>Verify group got deleted</li>
	 * 	<li>Click close</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Clients", "Secure - Fee Tables", "Secure - Delete Fee Table"}, dependsOnMethods={"createFeeTable"})
	public void deleteFeeTable() throws Exception {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Login to Secure
		secure.login(driver, user, StoredVariables.getpassword().get());
		
		// Go to Clients
		secure.goToClients(driver);
		
		// Click Fee Tables
		perform.click(driver, SClients.feeTables_btn(driver));
		
		// Click Manage Custom Fee Tables
		perform.clickInDiv_Contains(driver, "Manage Custom Fee Tables...");
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Switch into iFrame
		perform.switchToiFrameByID(driver, "frameDialogL1");
		
		// Wait for text
		perform.waitForText(driver, driver.findElement(By.id("bdyDialog")), "Test Fee Table");
		
		// Click on Test Fee Table
		perform.clickInDiv_Contains(driver, "Test Fee Table");
		
		// Click Delete Fee Table
		perform.clickInTable_Equals(driver, "Delete Fee Table");
		
		// Wait for Yes button
		perform.waitForElementToBeClickable(driver, SClients_FeeTables.yesDelete_btn(), "cssSelector");
		
		// Verify Confirm Delete dialog text
		Assert.assertTrue(SClients_FeeTables.dialogConfirmDelete_txt(driver).getText().contains("Are you sure you want to delete the selected fee table?"), "The dialog text is incorrect");
		
		// Click Yes
		perform.click(driver, SClients_FeeTables.yesDelete_btn(driver));
		
		// Wait for delete dialog to go away
		String style = SClients_FeeTables.dialogConfirmDelete_txt(driver).getAttribute("style");
		while (style.contains("block"))
		{
			Thread.sleep(500);
			style = SClients_FeeTables.dialogConfirmDelete_txt(driver).getAttribute("style");
		}
		
		Thread.sleep(2000);
		
		// Verify group got deleted
		Assert.assertTrue(!SClients_FeeTables.dialogFeeTables_txt(driver).getText().contains("Test Fee Table"), "The group was not deleted");
		
//		// Click close
//		perform.click(driver, SClients_OrderRouting.closeDialog_btn(driver));
		
		// Switch out of iFrame
		driver.switchTo().defaultContent();
		
		// Log test
		test.log(LogStatus.INFO, "clients", "Deleted Fee Table");
		
	} // end deleteFeeTable
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Go to Vendor Selection Settings</li>
	 * 	<li>Turn off Unattended Assignment</li>
	 * 	<li>Go to Configure Automatic Settings</li>
	 * 	<li>Make sure that Use vendor override fee whenever possible checkbox is checked</li>
	 * 	<li>Select vendor's published fee when assigning order</li>
	 * 	<li>Make sure Use QC Folders is checked</li>
	 * 	<li>Make sure Attach invoice when credit card is charged checkbox is unchecked</li>
	 * 	<li>Make sure Attach invoice when order is marked complete checkbox is unchecked</li>
	 * 	<li>Save settings</li>
	 * 	<li>Click on Configure Order Form</li>
	 * 	<li>Uncheck Allow clients to enter fee checkbox</li>
	 * 	<li>Uncheck Allow clients to select AMC/Firm checkbox</li>
	 * 	<li>Save the new settings</li>
	 * 	<li>Go to AQM Settings</li>
	 * 	<li>Set Automatically order default modules to "the first time"</li>
	 * 	<li>Make sure RealView is unchecked</li>
	 * 	<li>Save settings</li>
	 * 	<li>Go to Clients</li>
	 * 	<li>Click Client Groups</li>
	 * 	<li>Click Manage Client Groups</li>
	 * 	<li>Verify popup header text</li>
	 * 	<li>Check if group already exists, if so delete them</li>
	 * 	<li>Click on Test Client Group Name</li>
	 * 	<li>Click Delete Group</li>
	 * 	<li>Verify Confirm Delete dialog text</li>
	 * 	<li>Click Yes</li>
	 * 	<li>Verify group got deleted</li>
	 * 	<li>Click New Group</li>
	 * 	<li>Enter Group Name</li>
	 * 	<li>Select ACH</li>
	 * 	<li>Click Save</li>
	 * 	<li>Verify dialog text</li>
	 * 	<li>Click OK</li>
	 * 	<li>Click close</li>
	 * 	<li>Click Client Groups</li>
	 * 	<li>Click Manage Client Groups</li>
	 * 	<li>Verify the Client Group got created</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Vendor Selection Settings", "Secure - VMP XSite Settings", "Secure - Configure Automatic Settings", "Secure - Appraisal Quality Management Settings", "Secure - Clients", "Secure - Client Groups", "Secure - Create Client Group"}, alwaysRun=true, dependsOnMethods={"deleteFeeTable"})
	public void createClientGroup() throws Exception {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Login to Secure
		secure.login(driver, user, StoredVariables.getpassword().get());
		
		// Go to Vendor Selection Settings
		secure.goToVendorSelectionSettings(driver);
		
		// Turn off Unattended Assignment
		if (SVendorSelectionSettings.unattendedOrderAssignment_switch(driver).getAttribute("src").contains("On")) {
			perform.click(driver, SVendorSelectionSettings.unattendedOrderAssignment_switch(driver));
		}
		
		// Go to Configure Automatic Settings
		secure.goToVMPXSites(driver);
		perform.click(driver, SVMPXSites.configureAutomaticSettings_lnk(driver));
		
		// Wait for Use vendor override checkbox
		perform.waitForElementToBeClickable(driver, SConfigureAutomaticSettings.useVendorOverrideFeeWheneverPossible_chkbx(), "id");
		
		// Make sure that Use vendor override fee whenever possible checkbox is checked
		perform.checkCheckbox(driver, SConfigureAutomaticSettings.useVendorOverrideFeeWheneverPossible_chkbx(driver));
		
		// Select vendor's published fee when assigning order
		perform.selectDropdownOption(driver, SConfigureAutomaticSettings.useWhenAssigningOrders_dropdown(driver), "vendor's published fee");
		
		// Make sure Use QC Folders is checked
		perform.checkCheckbox(driver, SConfigureAutomaticSettings.useQCFolders_chkbx(driver));
		
		// Make sure Attach invoice when credit card is charged checkbox is unchecked
		perform.uncheckCheckbox(driver, SConfigureAutomaticSettings.attachInvoiceWhenCreditCardIsCharged_chkbx(driver));
		
		// Make sure Attach invoice when order is marked complete checkbox is unchecked
		perform.uncheckCheckbox(driver, SConfigureAutomaticSettings.attachInvoiceWhenOrderIsMarkedComplete_chkbx(driver));
		
		// Save settings
		secure.saveVMPXSiteSettings(driver);
		
		// Click on Configure Order Form
		perform.click(driver, SVMPXSites.configureOrderForm_lnk(driver));
		
		// Wait for Allow clients to enter fee checkbox
		perform.waitForElementToBeClickable(driver, SConfigureOrderForm.allowClientsToEnterFee_chkbx(), "id");

		// Uncheck Allow clients to enter fee checkbox
		perform.uncheckCheckbox(driver, SConfigureOrderForm.allowClientsToEnterFee_chkbx(driver));
		
		// Uncheck Allow clients to select AMC/Firm checkbox
		perform.uncheckCheckbox(driver, SConfigureOrderForm.allowClientsToSelectAMCFirm_chkbx(driver));
		
		// Save the new settings
		secure.saveVMPXSiteSettings(driver);
		
		// Go to AQM Settings
		secure.goToAppraisalQualityManagementSettings(driver);
		
		// Set Automatically order default modules to "the first time"
		perform.selectDropdownOption(driver, SAppraisalQualityManagementSettings.automaticallyOrderDefaultModules_dropdown(driver), "the first time");
		
		// Make sure RealView is unchecked
		if (SAppraisalQualityManagementSettings.realView_btn(driver).getAttribute("src").contains("Checkmark-Checked")) {
			perform.click(driver, SAppraisalQualityManagementSettings.realView_btn(driver));
		}
		
		// Save settings
		secure.saveAppraisalQualityManagementSettings(driver);
		
		// Go to Manage Client Groups
		secure.goToManageClientGroups(driver);
		
		// Verify popup header text
		String text = SClients_ClientGroups.dialogClientGroups_txt(driver).getText();
		Assert.assertTrue(text.contains("Client Groups"), "The dialog is incorrect");
		
		// Check if group already exists, if so delete them
		while (text.contains("Test Client Group Name"))
		{
			
			// Click on Test Client Group Name
			perform.clickInTable_Contains(driver, "Test Client Group Name");
			
			// Click Delete Group
			perform.clickInTable_Equals(driver, "Delete Group");
			
			// Wait for Yes button
			perform.waitForElementToBeClickable(driver, SClients_ClientGroups.yesDelete_btn(), "cssSelector");
			
			// Verify Confirm Delete dialog text
			Assert.assertTrue(SClients_ClientGroups.dialogConfirmDelete_txt(driver).getText().contains("Are you sure you want to delete the selected client group?"), "The dialog text is incorrect");
			
			// Click Yes
			perform.click(driver, SClients_ClientGroups.yesDelete_btn(driver));
			
			// Wait for delete dialog to go away
			String style = SClients_ClientGroups.dialogConfirmDelete_txt(driver).getAttribute("style");
			while (style.contains("block"))
			{
				Thread.sleep(500);
				style = SClients_ClientGroups.dialogConfirmDelete_txt(driver).getAttribute("style");
			}
			
			Thread.sleep(2000);
			
			// Verify group got deleted
			Assert.assertTrue(!SClients_ClientGroups.dialogClientGroups_txt(driver).getText().contains("Test Round Robin Group"), "The group was not deleted");
			
			text = SClients_ClientGroups.dialogClientGroups_txt(driver).getText();
			
		} // end while
		
		// Click New Group
		perform.clickInTable_Equals(driver, "New Group");
		
		// Switch into iFrame
		driver.switchTo().defaultContent();
		perform.waitForIFrames(driver);
		perform.switchToiFrameByID(driver, "frameDialogL1");
		
		// Wait for Group Name
		perform.waitForElementToBeClickable(driver, SClientGroups_Details.groupName_txtbx(), "id");
		
		// Enter Group Name
		perform.type(driver, SClientGroups_Details.groupName_txtbx(driver), "Test Client Group Name");
		
		// Select ACH
		perform.click(driver, SClientGroups_Details.ach_chkbx(driver));
		
		// Click Save
		perform.clickInTable_Equals(driver, "Save");
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SClients_ClientGroups.okSave_btn(), "cssSelector");
		
		// Verify dialog text
		Assert.assertTrue(SClients_ClientGroups.dialogSave_txt(driver).getText().contains("Your changes were successfully saved."), "The dialog text is incorrect");
		
		// Click OK
		perform.click(driver, SClients_ClientGroups.okSave_btn(driver));

		// Click close
		perform.click(driver, SClients_OrderRouting.closeDialog_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Switch out of iFrame
		driver.switchTo().defaultContent();
		
		// Click Client Groups
		perform.click(driver, SClients.clientGroups_btn(driver));
		
		// Click Manage Client Groups
		perform.clickInDiv_Contains(driver, "Manage Client Groups...");
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Switch into iFrame
		perform.switchToiFrameByID(driver, "frameDialogL1");
		
		// Verify the Client Group got created
		text = SClients_ClientGroups.dialogClientGroups_txt(driver).getText();
		Assert.assertTrue(text.contains("Test Client Group Name"), "The client group did not get created");
		
		// Switch out of iFrame
		driver.switchTo().defaultContent();
		
		// Log test
		test.log(LogStatus.INFO, "clients", "Create new Client Group");
		
	} // end createClientGroup
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Go to Vendor Selection Settings</li>
	 * 	<li>Get the Vendor Selection Settings</li>
	 * 	<li>Go to Configure Automatic Settings</li>
	 * 	<li>Get the Configure Automatic Settings</li>
	 * 	<li>Go to Connection Settings</li>
	 * 	<li>Get "an order's status changes to" element</li>
	 * 	<li>Get the Connection Settings</li>
	 * 	<li>Go to AQM Settings</li>
	 * 	<li>Get the AQM settings</li>
	 * 	<li>Go to Clients</li>
	 * 	<li>Click Client Groups</li>
	 * 	<li>Click Manage Client Groups</li>
	 * 	<li>Click on Test Client Group Name</li>
	 * 	<li>Click Edit</li>
	 * 	<li>Verify the Group Name textbox is displayed</li>
	 * 	<li>Verify Unattended Assignment matches the global setting</li>
	 * 	<li>Verify Automatic Order Reassignment matches the global setting</li>
	 * 	<li>Verify Stop and notify me after attempts matches the global setting</li>
	 * 	<li>Verify Do not pass VMP Comments to the vendor matches the global setting</li>
	 * 	<li>Verify Use when assigning orders dropdown matches global setting</li>
	 * 	<li>Verify Use vendor override fee matches the global setting</li>
	 * 	<li>Verify Always use the new vendors published fee matches the global setting</li>
	 * 	<li>Verify Set the payment method to matches the global setting</li>
	 * 	<li>Click Automated tab</li>
	 * 	<li>Verify the comments to borrower textbox is displayed</li>
	 * 	<li>Verify Automatically submit to FHA checkbox matches the global setting</li>
	 * 	<li>Verify Automatically submit to FHA dropdown matches the global setting</li>
	 * 	<li>Verify An Order Status Changed To matches the global setting</li>
	 * 	<li>Verify For all orders matches the global setting</li>
	 * 	<li>Verify Automatically Send The Selected Appraisal Products To The Borrower matches the global setting</li>
	 * 	<li>Verify Comments To Borrower matches the global setting</li>
	 * 	<li>Verify Include co-borrower when present matches the global setting</li>
	 * 	<li>Verify Cancel scheduled delivery when revision is requested matches the global setting</li>
	 * 	<li>Verify Use QC folders checkbox matches the global setting</li>
	 * 	<li>Get the Invoice Options</li>
	 * 	<li>Click Customize your invoice number and due date options link</li>
	 * 	<li>Get the rest of the Invoice Options</li>
	 * 	<li>Click OK</li>
	 * 	<li>Verify the Invoice Options match the global settings</li>
	 * 	<li>Click AQM tab</li>
	 * 	<li>Verify the Additional AQI Recipients textbox is displayed</li>
	 * 	<li>Get the AQM settings</li>
	 * 	<li>Verify the AQM settings match the global settings</li>
	 * 	<li>Click Members tab</li>
	 * 	<li>Verify the Placing Orders In This Group div is displayed</li>
	 * 	<li>Click Order Groups tab</li>
	 * 	<li>Verify the Add available groups button is displayed</li>
	 * 	<li>Remove Eligible vendor</li>
	 * 	<li>Select Eligible</li>
	 * 	<li>Click the remove button</li>
	 * 	<li>Verify Eligible was removed</li>
	 * 	<li>Remove Ineligible vendor</li>
	 * 	<li>Select Ineligible</li>
	 * 	<li>Click the remove button</li>
	 * 	<li>Verify Ineligible was removed</li>
	 * 	<li>Add the Eligible order group to Eligible vendors</li>
	 * 	<li>Click Add to Eligible vendors button</li>
	 * 	<li>Verify that the Eligible order group was added to Eligible vendors</li>
	 * 	<li>Add the Ineligible order group to Ineligible vendors</li>
	 * 	<li>Click Add to Ineligible vendors button</li>
	 * 	<li>Verify that the Ineligible order group was added to Ineligible vendors</li>
	 * 	<li>Click Save</li>
	 * 	<li>Verify dialog text</li>
	 * 	<li>Click OK</li>
	 * 	<li>Click close</li>
	 * 	<li>Click Client Groups</li>
	 * 	<li>Click Manage Client Groups</li>
	 * 	<li>Click on Test Client Group Name</li>
	 * 	<li>Click Edit</li>
	 * 	<li>Click Order Groups tab</li>
	 * 	<li>Verify the Eligible order group is in the Eligible vendors list</li>
	 * 	<li>Verify the Ineligible order group is in the Ineligible vendors list</li>
	 * 	<li>Click close</li>
	 * 	<li>Go to Configure Automatic Settings</li>
	 * 	<li>Make sure that Use vendor override fee whenever possible checkbox is unchecked</li>
	 * 	<li>Save settings</li>
	 * 	<li>Go to Clients</li>
	 * 	<li>Click Client Groups</li>
	 * 	<li>Click Manage Client Groups</li>
	 * 	<li>Click on Test Client Group Name</li>
	 * 	<li>Click Edit</li>
	 * 	<li>Verify Use vendor override fee whenever possible</li>
	 * 	<li>Click close</li>
	 * 	<li>Click the Test contact</li>
	 * 	<li>Click Client Groups</li>
	 * 	<li>Click Add to Client Groups</li>
	 * 	<li>Click Test Client Group Name</li>
	 * 	<li>Click Save</li>
	 * 	<li>Click View button</li>
	 * 	<li>Verify Test Client Group Name is displayed</li>
	 * 	<li>Click Test Client Group Name</li>
	 * 	<li>Verify that Test Test contact is in the Group Members</li>
	 * 	<li>Select the contact Test Test</li>
	 * 	<li>Uncheck the Place Orders checkbox</li>
	 * 	<li>Click Save</li>
	 * 	<li>Verify dialog text</li>
	 * 	<li>Click OK</li>
	 * 	<li>Click close</li>
	 * 	<li>Click Client Groups</li>
	 * 	<li>Click Manage Client Groups</li>
	 * 	<li>Click on Test Client Group Name</li>
	 * 	<li>Click Edit</li>
	 * 	<li>Go through each tab and make a change to separate it from the global settings</li>
	 * 	<li>Details</li>
	 * 	<li>Uncheck Use vendor override fee whenever possible checkbox</li>
	 * 	<li>Automated</li>
	 * 	<li>Click Automated tab</li>
	 * 	<li>Check Attach invoice when credit card is charged checkbox</li>
	 * 	<li>AQM</li>
	 * 	<li>Click AQM tab</li>
	 * 	<li>Select every time for Automatically order default modules dropdown</li>
	 * 	<li>Save your changes and confirm the changes saved</li>
	 * 	<li>Click Save</li>
	 * 	<li>Get Dialog text</li>
	 * 	<li>Click OK</li>
	 * 	<li>Click Save</li>
	 * 	<li>Verify dialog text</li>
	 * 	<li>Click OK</li>
	 * 	<li>Click close</li>
	 * 	<li>Click Client Groups</li>
	 * 	<li>Click Manage Client Groups</li>
	 * 	<li>Click on Test Client Group Name</li>
	 * 	<li>Click Edit</li>
	 * 	<li>Verify Allow clients to enter fee checkbox is checked</li>
	 * 	<li>Click Automated tab</li>
	 * 	<li>Verify Attach invoice when credit card is charged checkbox is checked</li>
	 * 	<li>AQM</li>
	 * 	<li>Click AQM tab</li>
	 * 	<li>Verify every time is selected for Automatically order default modules dropdown</li>
	 * 	<li>Click close</li>
	 * 	<li>Change some of the global settings to be different from what is saved in the client group</li>
	 * 	<li>Go to VMP XSite Settings</li>
	 * 	<li>Click on Configure Automatic Settings</li>
	 * 	<li>Select VMP XSite fee when assigning orders</li>
	 * 	<li>Check Attach invoice when order is marked complete checkbox</li>
	 * 	<li>Save the new settings</li>
	 * 	<li>Click on Configure Order Form</li>
	 * 	<li>Check Allow clients to select AMC/Firm checkbox</li>
	 * 	<li>Save the new settings</li>
	 * 	<li>Go to AQM Settings</li>
	 * 	<li>Check RealView</li>
	 * 	<li>Save the settings</li>
	 * 	<li>Edit the client group</li>
	 * 	<li>Go to Clients</li>
	 * 	<li>Click Client Groups</li>
	 * 	<li>Click Manage Client Groups</li>
	 * 	<li>Click on Test Client Group Name</li>
	 * 	<li>Click Edit</li>
	 * 	<li>Confirm the changes to the global settings did not change the altered settings in the client group</li>
	 * 	<li>The Allow clients to select AMC/Firm checkbox should be unchecked</li>
	 * 	<li>Click Automated tab</li>
	 * 	<li>The Create invoice when new order is placed checkbox should be unchecked</li>
	 * 	<li>Click AQM tab</li>
	 * 	<li>The RealView setting should be unselected</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Vendor Selection Settings", "Secure - VMP XSite Settings", "Secure - Configure Automatic Settings", "Secure - Appraisal Quality Management Settings", 
			"Secure - Connection Settings", "Secure - Clients", "Secure - Client Groups", "Secure - Edit Client Group"}, dependsOnMethods={"createClientGroup"})
	public void editClientGroup() throws Exception {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Login to Secure
		secure.login(driver, user, StoredVariables.getpassword().get());
		
		// Go to Vendor Selection Settings
		secure.goToVendorSelectionSettings(driver);
		
		// Get the Vendor Selection Settings
		boolean unattendedAssignment = SVendorSelectionSettings.unattendedOrderAssignment_switch(driver).getAttribute("src").contains("On");
		boolean automaticOrderReassignment = SVendorSelectionSettings.unattendedOrderReassignment_switch(driver).getAttribute("src").contains("On");
		boolean stopAndNotify = !perform.isAttribtuePresent(driver, SVendorSelectionSettings.stopAndNotifyMeAfterAttempts_chkbx(driver), "disabled");
		
		// Go to Configure Automatic Settings
		secure.goToVMPXSites(driver);
		perform.click(driver, SVMPXSites.configureAutomaticSettings_lnk(driver));
		
		// Wait for Use vendor override checkbox
		perform.waitForElementToBeClickable(driver, SConfigureAutomaticSettings.useVendorOverrideFeeWheneverPossible_chkbx(), "id");
		
		// Get the Configure Automatic Settings
		boolean doNotPassVMPCommentsToTheVendor = !perform.isAttribtuePresent(driver, SConfigureAutomaticSettings.doNotPassVMPCommentsToTheVendor_chkbx(driver), "disabled");
		String useWhenAssigningOrders = new Select(SConfigureAutomaticSettings.useWhenAssigningOrders_dropdown(driver)).getFirstSelectedOption().getText();
		boolean useVendorOverrideFee = SConfigureAutomaticSettings.useVendorOverrideFeeWheneverPossible_chkbx(driver).isSelected();
		boolean alwaysUseTheNewVendorsPublishedFee = SConfigureAutomaticSettings.alwaysUseTheNewVendorsPublishedFee_chkbx(driver).isSelected();
		String setThePaymentMethodTo = new Select(SConfigureAutomaticSettings.setThePaymentMethodTo_dropdown(driver)).getFirstSelectedOption().getText();
		boolean createInvoiceWhenOrderIsPlaced = SConfigureAutomaticSettings.createInvoiceWhenOrderIsPlaced_chkbx(driver).isSelected();
		boolean attachInvoiceWhenCreditCardIsCharged = SConfigureAutomaticSettings.attachInvoiceWhenCreditCardIsCharged_chkbx(driver).isSelected();
		boolean attachInvoiceWhenOrderIsMarkedComplete = SConfigureAutomaticSettings.attachInvoiceWhenOrderIsMarkedComplete_chkbx(driver).isSelected();
		boolean includeTheVendorsFeeOnTheInvoice = SConfigureAutomaticSettings.includeTheVendorsFeeOnTheInvoice_chkbx(driver).isSelected();
		String setTheInvoiceDueDateTo = SConfigureAutomaticSettings.setTheInvoiceDueDateTo_txtbx(driver).getAttribute("value");
		boolean useTrackingNumber = SConfigureAutomaticSettings.useTrackingNumber_chkbx(driver).isSelected();
		String prefix = SConfigureAutomaticSettings.prefix_txtbx(driver).getAttribute("value");
		String startNumberSequence = SConfigureAutomaticSettings.startNumberSequence_txtbx(driver).getAttribute("value");
		boolean useQCFolders = SConfigureAutomaticSettings.useQCFolders_chkbx(driver).isSelected();
		
		// Go to Connection Settings
		secure.goToConnectionSettings(driver);

		// Get "an order's status changes to" element
		String text = driver.findElement(By.cssSelector("#"+SConnectionSettings.anOrdersStatusChangesto_dropdown()+" > div")).getAttribute("id").replace("0:mkr:Target", "2:mkr:Input");
		WebElement changesTo = driver.findElement(By.id(text));

		// Get the Connection Settings
		boolean automaticallySubmitToFHA_chkbx = SConnectionSettings.automaticallySubmitToFHA_chkbx(driver).isSelected();
		String automaticallySubmitToFHA_dropdown = new Select(SConnectionSettings.automaticallySubmitToFHA_dropdown(driver)).getFirstSelectedOption().getText();
		String anOrdersStatusChangesTo = changesTo.getAttribute("value");
		String forAllOrders = new Select(SConnectionSettings.forAllOrders_dropdown(driver)).getFirstSelectedOption().getText();
		String automaticallySendTheSelectedAppraisalProductsToTheBorrower = new Select(SConnectionSettings.automaticallySendTheSelectedAppraisalProductsToTheBorrower_dropdown(driver)).getFirstSelectedOption().getText();
		String commentsToBorrower = SConnectionSettings.commentsToBorrower_txtbx(driver).getAttribute("value");
		boolean includeCoBorrowerWhenPresent = SConnectionSettings.includeCoBorrowerWhenPresent_chkbx(driver).isSelected();
		boolean cancelScheduledDeliveryWhenRevisionIsRequested = SConnectionSettings.cancelScheduledDeliveryWhenRevisionIsRequested_chkbx(driver).isSelected();
		
		// Go to AQM Settings
		secure.goToAppraisalQualityManagementSettings(driver);
		
		// Get the AQM settings
		boolean realView = SAppraisalQualityManagementSettings.realView_btn(driver).getAttribute("src").contains("Checkmark-Checked");
		boolean aqi = SAppraisalQualityManagementSettings.realView_btn(driver).getAttribute("src").contains("Checkmark-Checked");
		boolean aqm = SAppraisalQualityManagementSettings.realView_btn(driver).getAttribute("src").contains("Checkmark-Checked");
		boolean manualRules = SAppraisalQualityManagementSettings.realView_btn(driver).isSelected();
		boolean validateData = SAppraisalQualityManagementSettings.realView_btn(driver).getAttribute("src").contains("Checkmark-Checked");
		boolean masterServ = SAppraisalQualityManagementSettings.realView_btn(driver).getAttribute("src").contains("Checkmark-Checked");
		boolean alwaysOrderDefaultModules = SAppraisalQualityManagementSettings.realView_btn(driver).isSelected();
		boolean automticallyOrderDefaultModules_chkbox  = SAppraisalQualityManagementSettings.realView_btn(driver).isSelected();
		String automticallyOrderDefaultModules_dropdown = new Select(SAppraisalQualityManagementSettings.automaticallyOrderDefaultModules_dropdown(driver)).getFirstSelectedOption().getText();
		String anOrdersStatusChangesToAQM = SAppraisalQualityManagementSettings.anOrdersStatusChangesTo_dropdown(driver).getText();
		boolean onlyAutomaticallyOrderWhen = perform.isAttribtuePresent(driver, SAppraisalQualityManagementSettings.onlyAutomaticallyOrder_chkbx(driver), "disabled");
		
		// Go to Clients
		secure.goToClients(driver);
		
		// Click Client Groups
		perform.click(driver, SClients.clientGroups_btn(driver));
		
		// Click Manage Client Groups
		perform.clickInDiv_Contains(driver, "Manage Client Groups...");
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		Thread.sleep(3000);
		
		// Switch into iFrame
		perform.switchToiFrameByID(driver, "frameDialogL1");
		
		// Click on Test Client Group Name
		perform.clickInTable_Contains(driver, "Test Client Group Name");
		
		// Click Edit
		perform.click(driver, SClients_ClientGroups.editGroup_btn(driver));
		
		// Switch into iFrame
		driver.switchTo().defaultContent();
		perform.switchToiFrameByID(driver, "frameDialogL1");
		
		// Wait for Details tab
		perform.waitForElementToBeClickable(driver, SClients_ClientGroups.details_btn(), "id");
		
		// Verify the Group Name textbox is displayed
		Assert.assertTrue(SClientGroups_Details.groupName_txtbx(driver).isDisplayed(), "The Group Name textbox should be displayed");
		
		// Verify Unattended Assignment matches the global setting
		boolean unattendedAssignment_CG = SClientGroups_Details.enableUnattendedAssignmentMode_chkbx(driver).isSelected();
		Assert.assertTrue(unattendedAssignment==unattendedAssignment_CG, "The Unattended Assingment does not match the global setting.");
		
		// Verify Automatic Order Reassignment matches the global setting
		boolean automaticOrderReassignment_CG = SClientGroups_Details.enableAutomaticOrderReassignment_chkbx(driver).isSelected();
		Assert.assertTrue(automaticOrderReassignment==automaticOrderReassignment_CG, "The Automatic Order Reassignment does not match the global setting.");
		
		// Verify Stop and notify me after attempts matches the global setting
		boolean stopAndNotify_CG = !perform.isAttribtuePresent(driver, SClientGroups_Details.stopAndNotifyMeAfterAttempts_chkbx(driver), "disabled");
		Assert.assertTrue(stopAndNotify==stopAndNotify_CG, "The Stop and notify me after attempts does not match the global setting.");
		
		// Verify Do not pass VMP Comments to the vendor matches the global setting
		boolean doNotPassVMPCommentsToTheVendor_CG = !perform.isAttribtuePresent(driver, SClientGroups_Details.doNotPassVMPComments_chkbx(driver), "disabled");
		Assert.assertTrue(doNotPassVMPCommentsToTheVendor==doNotPassVMPCommentsToTheVendor_CG, "The Do not pass VMP Comments to the vendor does not match the global setting.");
		
		// Verify Use when assigning orders dropdown matches global setting
		String useWhenAssigningOrders_CG = new Select(SClientGroups_Details.useWhenAssigningOrders_dropdown(driver)).getFirstSelectedOption().getText();
		Assert.assertTrue(useWhenAssigningOrders_CG.equals("vendor's published fee"), "The Use when assigning orders dropdown does not match the global settting. The selected option is = " + useWhenAssigningOrders_CG + " and should be = " + useWhenAssigningOrders);
		
		// Verify Use vendor override fee matches the global setting
		boolean useVendorOverrideFee_CG = SClientGroups_Details.useVendorOverrideFeeWheneverPossible_chkbx(driver).isSelected();
		Assert.assertTrue(useVendorOverrideFee==useVendorOverrideFee_CG, "The Use vendor override fee does not match the global setting.");
		
		// Verify Always use the new vendors published fee matches the global setting
		boolean alwaysUseTheNewVendorsPublishedFee_CG = SClientGroups_Details.alwaysUseTheNewVendorsPublishedFee_chkbx(driver).isSelected();
		Assert.assertTrue(alwaysUseTheNewVendorsPublishedFee==alwaysUseTheNewVendorsPublishedFee_CG, "The Always use the new vendors published fee does not match the global setting.");
		
		// Verify Set the payment method to matches the global setting
		String setThePaymentMethodTo_CG = new Select(SClientGroups_Details.setThePaymentMethodTo_dropdown(driver)).getFirstSelectedOption().getText();
		Assert.assertTrue(setThePaymentMethodTo.equals(setThePaymentMethodTo_CG), "The Set the payment method to does not match the global setting.");
		
		// Click Automated tab
		perform.click(driver, SClients_ClientGroups.automated_btn(driver));
		
		// Wait for comments to borrower textbox
		perform.waitForElementToBeClickable(driver, SClientGroups_Automated.commentsToBorrower_txtbx(), "id");
		
		// Verify the comments to borrower textbox is displayed
		Assert.assertTrue(SClientGroups_Automated.commentsToBorrower_txtbx(driver).isDisplayed(), "The comments to borrower textbox should be displayed");
		
		// Verify Automatically submit to FHA checkbox matches the global setting
		boolean automaticallySubmitToFHA_chkbx_CG = SClientGroups_Automated.automaticallySubmitToFHA_chkbx(driver).isSelected();
		Assert.assertTrue(automaticallySubmitToFHA_chkbx==automaticallySubmitToFHA_chkbx_CG, "The Automatically submit to FHA checkbox does not match the global setting.");
		
		// Verify Automatically submit to FHA dropdown matches the global setting
		String automaticallySubmitToFHA_dropdown_CG = new Select(SClientGroups_Automated.automaticallySubmitToFHA_dropdown(driver)).getFirstSelectedOption().getText();
		Assert.assertTrue(automaticallySubmitToFHA_dropdown.equals(automaticallySubmitToFHA_dropdown_CG), "The Automatically submit to FHA dropdown does not match the global setting.");
		
		// Verify An Order Status Changed To matches the global setting
		String anOrdersStatusChangesTo_CG = new Select(SClientGroups_Automated.anOrdersStatusChangesTo_dropdown(driver)).getFirstSelectedOption().getText();
		Assert.assertTrue(anOrdersStatusChangesTo.equals(anOrdersStatusChangesTo_CG), "The An Order Status Changed To does not match the global setting. Global setting = " + anOrdersStatusChangesTo + " and the Client Group setting = " + anOrdersStatusChangesTo_CG);
		
		// Verify For all orders matches the global setting
		String forAllOrders_CG = new Select(SClientGroups_Automated.forThisClientGroup_dropdown(driver)).getFirstSelectedOption().getText();
		Assert.assertTrue(forAllOrders.equals(forAllOrders_CG), "The For all orders does not match the global setting.");
		
		// Verify Automatically Send The Selected Appraisal Products To The Borrower matches the global setting
		String automaticallySendTheSelectedAppraisalProductsToTheBorrower_CG = new Select(SClientGroups_Automated.automaticallySendTheSelectedAppraisalProductsToTheBorrower_dropdown(driver)).getFirstSelectedOption().getText();
		Assert.assertTrue(automaticallySendTheSelectedAppraisalProductsToTheBorrower.equals(automaticallySendTheSelectedAppraisalProductsToTheBorrower_CG), "The Automatically Send The Selected Appraisal Products To The Borrower does not match the global setting.");
		
		// Verify Comments To Borrower matches the global setting
		String commentsToBorrower_CG = SClientGroups_Automated.commentsToBorrower_txtbx(driver).getAttribute("value");
		Assert.assertTrue(commentsToBorrower.equals(commentsToBorrower_CG), "The Comments To Borrower does not match the global setting.");
		
		// Verify Include co-borrower when present matches the global setting
		boolean includeCoBorrowerWhenPresent_CG = SClientGroups_Automated.includeCoBorrowerWhenPresent_chkbx(driver).isSelected();
		Assert.assertTrue(includeCoBorrowerWhenPresent==includeCoBorrowerWhenPresent_CG, "The Include co-borrower when present does not match the global setting.");
		
		// Verify Cancel scheduled delivery when revision is requested matches the global setting
		boolean cancelScheduledDeliveryWhenRevisionIsRequested_CG = SClientGroups_Automated.cancelScheduledDeliveryWhenRevisionIsRequested_chkbx(driver).isSelected();
		Assert.assertTrue(cancelScheduledDeliveryWhenRevisionIsRequested==cancelScheduledDeliveryWhenRevisionIsRequested_CG, "The Cancel scheduled delivery when revision is requested does not match the global setting.");
		
		// Verify Use QC folders checkbox matches the global setting
		boolean useQCFolders_CG = SClientGroups_Automated.useQCFolders_chkbx(driver).isSelected();
		Assert.assertTrue(useQCFolders==useQCFolders_CG, "The Use QC folders checkbox does not match the global setting.");
		
		// Get the Invoice Options
		boolean createInvoiceWhenOrderIsPlaced_CG = SClientGroups_Automated.createInvoiceWhenOrderIsPlaced_chkbx(driver).isSelected();
		boolean attachInvoiceWhenCreditCardIsCharged_CG = SClientGroups_Automated.attachInvoiceWhenCreditCardIsCharged_chkbx(driver).isSelected();
		boolean attachInvoiceWhenOrderIsMarkedComplete_CG = SClientGroups_Automated.attachInvoiceWhenOrderIsMarkedComplete_chkbx(driver).isSelected();
		boolean includeTheVendorsFeeOnTheInvoice_CG = SClientGroups_Automated.includeTheVendorsFeeOnTheInvoice_chkbx(driver).isSelected();
		
		// Click Customize your invoice number and due date options link
		perform.click(driver, SClientGroups_Automated.customizeYourInvoiceNumberAndDueDateOptions_lnk(driver));
		
		// Wait for Set the invoice date to textbox
		perform.waitForElementToBeClickable(driver, SClientGroups_Automated.setTheInvoiceDueDateTo_txtbx(), "id");
		
		// Get the rest of the Invoice Options
		String setTheInvoiceDueDateTo_CG = SClientGroups_Automated.setTheInvoiceDueDateTo_txtbx(driver).getAttribute("value");
		boolean useTrackingNumber_CG = SClientGroups_Automated.useTrackingNumber_chkbx(driver).isSelected();
		String prefix_CG = SClientGroups_Automated.prefix_txtbx(driver).getAttribute("value");
		String startNumberSequence_CG = SClientGroups_Automated.startNumberSequence_txtbx(driver).getAttribute("value");
		
		// Click OK
		perform.click(driver, SClientGroups_Automated.ok_btn(driver));
		
		// Wait for comments to borrower textbox
		perform.waitForElementToBeClickable(driver, SClientGroups_Automated.commentsToBorrower_txtbx(), "id");
		
		// Verify the Invoice Options match the global settings
		Assert.assertTrue(createInvoiceWhenOrderIsPlaced==createInvoiceWhenOrderIsPlaced_CG, "The Client Group option does not match the global option");
		Assert.assertTrue(attachInvoiceWhenCreditCardIsCharged==attachInvoiceWhenCreditCardIsCharged_CG, "The Client Group option does not match the global option");
		Assert.assertTrue(attachInvoiceWhenOrderIsMarkedComplete==attachInvoiceWhenOrderIsMarkedComplete_CG, "The Client Group option does not match the global option");
		Assert.assertTrue(includeTheVendorsFeeOnTheInvoice==includeTheVendorsFeeOnTheInvoice_CG, "The Client Group option does not match the global option");
		Assert.assertTrue(setTheInvoiceDueDateTo.equals(setTheInvoiceDueDateTo_CG), "The Client Group option does not match the global option");
		Assert.assertTrue(useTrackingNumber==useTrackingNumber_CG, "The Client Group option does not match the global option");
		Assert.assertTrue(prefix.equals(prefix_CG), "The Client Group option does not match the global option");
		Assert.assertTrue(startNumberSequence.equals(startNumberSequence_CG), "The Client Group option does not match the global option");
		
		// Click AQM tab
		perform.click(driver, SClients_ClientGroups.aqm_btn(driver));
		
		// Wait for Additional AQI Recipients textbox
		perform.waitForElementToBeClickable(driver, SClientGroups_AQM.additionalAQIRecipients_txtbx(), "id");
		
		// Verify the Additional AQI Recipients textbox is displayed
		Assert.assertTrue(SClientGroups_AQM.additionalAQIRecipients_txtbx(driver).isDisplayed(), "The Additional AQI Recipients textbox should be displayed");
		
		// Get the AQM settings
		boolean realView_CG = SClientGroups_AQM.realView_btn(driver).getAttribute("src").contains("Checkmark-Checked");
		boolean aqi_CG = SClientGroups_AQM.realView_btn(driver).getAttribute("src").contains("Checkmark-Checked");
		boolean aqm_CG = SClientGroups_AQM.realView_btn(driver).getAttribute("src").contains("Checkmark-Checked");
		boolean manualRules_CG = SClientGroups_AQM.realView_btn(driver).isSelected();
		boolean validateData_CG = SClientGroups_AQM.realView_btn(driver).getAttribute("src").contains("Checkmark-Checked");
		boolean masterServ_CG = SClientGroups_AQM.realView_btn(driver).getAttribute("src").contains("Checkmark-Checked");
		boolean alwaysOrderDefaultModules_CG = SClientGroups_AQM.realView_btn(driver).isSelected();
		boolean automticallyOrderDefaultModules_chkbox_CG  = SClientGroups_AQM.realView_btn(driver).isSelected();
		String automticallyOrderDefaultModules_dropdown_CG = new Select(SClientGroups_AQM.automaticallyOrderDefaultModules_dropdown(driver)).getFirstSelectedOption().getText();
		String anOrdersStatusChangesToAQM_CG = SClientGroups_AQM.anOrdersStatusChangesTo_dropdown(driver).getText();
		boolean onlyAutomaticallyOrderWhen_CG = perform.isAttribtuePresent(driver, SClientGroups_AQM.onlyAutomaticallyOrder_chkbx(driver), "disabled");
		
		// Verify the AQM settings match the global settings
		Assert.assertTrue(realView==realView_CG, "The AQM Client Group settings do not match the global option");
		Assert.assertTrue(aqi==aqi_CG, "The AQM Client Group settings do not match the global option");
		Assert.assertTrue(aqm==aqm_CG, "The AQM Client Group settings do not match the global option");
		Assert.assertTrue(manualRules==manualRules_CG, "The AQM Client Group settings do not match the global option");
		Assert.assertTrue(validateData==validateData_CG, "The AQM Client Group settings do not match the global option");
		Assert.assertTrue(masterServ==masterServ_CG, "The AQM Client Group settings do not match the global option");
		Assert.assertTrue(alwaysOrderDefaultModules==alwaysOrderDefaultModules_CG, "The AQM Client Group settings do not match the global option");
		Assert.assertTrue(automticallyOrderDefaultModules_chkbox==automticallyOrderDefaultModules_chkbox_CG, "The AQM Client Group settings do not match the global option");
		Assert.assertTrue(automticallyOrderDefaultModules_dropdown.equals(automticallyOrderDefaultModules_dropdown_CG), "The AQM Client Group settings do not match the global option");
		Assert.assertTrue(anOrdersStatusChangesToAQM.equals(anOrdersStatusChangesToAQM_CG), "The AQM Client Group settings do not match the global option");
		Assert.assertTrue(onlyAutomaticallyOrderWhen==onlyAutomaticallyOrderWhen_CG, "The AQM Client Group settings do not match the global option. Global = " + onlyAutomaticallyOrderWhen + " and Client Groups = " + onlyAutomaticallyOrderWhen_CG);
		
		// Click Members tab
		perform.click(driver, SClients_ClientGroups.members_btn(driver));
		
		// Wait for Placing Orders In This Group div
		perform.waitForElementToBeClickable(driver, SClients_ClientGroups.placingOrdersInThisGroup_div(), "id");
		
		// Verify the Placing Orders In This Group div is displayed
		Assert.assertTrue(SClients_ClientGroups.placingOrdersInThisGroup_div(driver).isDisplayed(), "The Place Orders checkbox should be displayed");
		
		// Click Order Groups tab
		perform.click(driver, SClients_ClientGroups.orderGroups_btn(driver));
		
		// Wait for Add available groups button
		perform.waitForElementToBeClickable(driver, SClients_ClientGroups.addAvailableGroups_btn(), "cssSelector");
		
		// Verify the Add available groups button is displayed
		Assert.assertTrue(SClients_ClientGroups.addAvailableGroups_btn(driver).isDisplayed(), "The Add available groups button should be displayed");
		
		// Remove Eligible vendor
		if (SClientGroups_OrderGroups.eligibleVendors_txt(driver).getText().contains("Eligible")) {
			
			// Select Eligible
			perform.clickListText(driver, "Eligible");
			
			// Click the remove button
			perform.click(driver, SClientGroups_OrderGroups.removeFromEligible_btn(driver));
			
			// Wait for the group to be moved to Available groups
			perform.waitForText(driver, SClientGroups_OrderGroups.availableGroups_txt(driver), "Eligible");
			
			// Verify Eligible was removed
			Assert.assertTrue(!SClientGroups_OrderGroups.eligibleVendors_txt(driver).getText().contains("Eligible"), "The Eligible group should have been removed from the Eligible vendors group");
			
		} // end if to remove Eligible vendors
		
		// Remove Ineligible vendor
		if (SClientGroups_OrderGroups.ineligibleVendors_txt(driver).getText().contains("Ineligible")) {
			
			// Select Ineligible
			perform.clickListText(driver, "Ineligible");
			
			// Click the remove button
			perform.click(driver, SClientGroups_OrderGroups.removeFromIneligible_btn(driver));
			
			// Wait for the group to be moved to Available groups
			perform.waitForText(driver, SClientGroups_OrderGroups.availableGroups_txt(driver), "Ineligible");
			
			// Verify Ineligible was removed
			Assert.assertTrue(!SClientGroups_OrderGroups.ineligibleVendors_txt(driver).getText().contains("Ineligible"), "The Ineligible group should have been removed from the Ineligible vendors group");
			
		} // end if to remove Ineligible vendors
		
		// Add the Eligible order group to Eligible vendors
		perform.clickListText(driver, "Eligible");
		
		// Click Add to Eligible vendors button
		perform.click(driver, SClientGroups_OrderGroups.addToEligible_btn(driver));
		
		// Wait for the Eligible order group to be added to Eligible vendors
		perform.waitForText(driver, SClientGroups_OrderGroups.eligibleVendors_txt(driver), "Eligible");
		
		// Verify that the Eligible order group was added to Eligible vendors
		Assert.assertTrue(SClientGroups_OrderGroups.eligibleVendors_txt(driver).getText().contains("Eligible"), "The Eligible order group should have been added to the Eligible vendors table");
		
		// Add the Ineligible order group to Ineligible vendors
		perform.clickListText(driver, "Ineligible");
		
		// Click Add to Ineligible vendors button
		perform.click(driver, SClientGroups_OrderGroups.addToIneligible_btn(driver));
		
		// Wait for the Ineligible order group to be added to Ineligible vendors
		perform.waitForText(driver, SClientGroups_OrderGroups.ineligibleVendors_txt(driver), "Ineligible");
		
		// Verify that the Ineligible order group was added to Ineligible vendors
		Assert.assertTrue(SClientGroups_OrderGroups.ineligibleVendors_txt(driver).getText().contains("Ineligible"), "The Ineligible order group should have been added to the Ineligible vendors table");
		
		// Click Save
		perform.clickInTable_Equals(driver, "Save");
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SClients_ClientGroups.okSave_btn(), "cssSelector");
		
		// Verify dialog text
		Assert.assertTrue(SClients_ClientGroups.dialogSave_txt(driver).getText().contains("Your changes were successfully saved."), "The dialog text is incorrect");
		
		// Click OK
		perform.click(driver, SClients_ClientGroups.okSave_btn(driver));

		// Click close
		perform.click(driver, SClients_OrderRouting.closeDialog_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Switch out of iFrame
		driver.switchTo().defaultContent();
		
		// Click Client Groups
		perform.click(driver, SClients.clientGroups_btn(driver));
		
		// Click Manage Client Groups
		perform.clickInDiv_Contains(driver, "Manage Client Groups...");
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Switch into iFrame
		perform.switchToiFrameByID(driver, "frameDialogL1");
		
		// Click on Test Client Group Name
		perform.clickInTable_Contains(driver, "Test Client Group Name");
		
		// Click Edit
		perform.click(driver, SClients_ClientGroups.editGroup_btn(driver));
		
		// Switch into iFrame
		driver.switchTo().defaultContent();
		perform.switchToiFrameByID(driver, "frameDialogL1");
		
		// Wait for Details tab
		perform.waitForElementToBeClickable(driver, SClients_ClientGroups.details_btn(), "id");
		
		// Click Order Groups tab
		perform.click(driver, SClients_ClientGroups.orderGroups_btn(driver));
		
		// Wait for Add available groups button
		perform.waitForElementToBeClickable(driver, SClients_ClientGroups.addAvailableGroups_btn(), "cssSelector");
		
		// Verify the Eligible order group is in the Eligible vendors list
		Assert.assertTrue(SClientGroups_OrderGroups.eligibleVendors_txt(driver).getText().contains("Eligible"), "The Eligible order group should be in the Eligible vendors list");
		
		// Verify the Ineligible order group is in the Ineligible vendors list
		Assert.assertTrue(SClientGroups_OrderGroups.ineligibleVendors_txt(driver).getText().contains("Ineligible"), "The Ineligible order group should be in the Ineligible vendors list");		
		
		// Click close
		perform.click(driver, SClients_OrderRouting.closeDialog_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Switch out of iFrame
		driver.switchTo().defaultContent();
		
		// Go to Configure Automatic Settings
		secure.goToVMPXSites(driver);
		perform.click(driver, SVMPXSites.configureAutomaticSettings_lnk(driver));
		
		// Wait for Use vendor override checkbox
		perform.waitForElementToBeClickable(driver, SConfigureAutomaticSettings.useVendorOverrideFeeWheneverPossible_chkbx(), "id");
		
		// Make sure that Use vendor override fee whenever possible checkbox is unchecked
		perform.uncheckCheckbox(driver, SConfigureAutomaticSettings.useVendorOverrideFeeWheneverPossible_chkbx(driver));
		
		// Save settings
		secure.saveVMPXSiteSettings(driver);
		
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
		
		// Click on Test Client Group Name
		perform.clickInTable_Contains(driver, "Test Client Group Name");
		
		// Click Edit
		perform.click(driver, SClients_ClientGroups.editGroup_btn(driver));
		
		// Switch into iFrame
		driver.switchTo().defaultContent();
		perform.switchToiFrameByID(driver, "frameDialogL1");
		
		// Wait for Details tab
		perform.waitForElementToBeClickable(driver, SClients_ClientGroups.details_btn(), "id");
		
		// Verify Use vendor override fee whenever possible
		Assert.assertTrue(!SClientGroups_Details.useVendorOverrideFeeWheneverPossible_chkbx(driver).isSelected(), "The Use vendor override fee whenever possible checkbox is unchecked");
		
		// Click close
		perform.click(driver, SClients_OrderRouting.closeDialog_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Switch out of iFrame
		driver.switchTo().defaultContent();
		
		// Click the Test contact
		perform.clickInTable_Contains(driver, "Test");
		
		Thread.sleep(1000);
		
		// Click Client Groups
		perform.click(driver, SClients.clientGroups_btn(driver));
		
		// Click Add to Client Groups
		perform.clickInDiv_Contains(driver, "Add to Client Groups...");
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for the Save button
		perform.waitForElementToBeClickable(driver, SClients_ClientGroups.saveAddToClientGroups_btn(), "cssSelector");
		
		// Click Test Client Group Name
		perform.clickInTable_Contains(driver, "Test Client Group Name");
		
		// Click Save
		perform.click(driver, SClients_ClientGroups.saveAddToClientGroups_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Click View button
		perform.click(driver, SClients_ClientGroups.viewClientGroups_btn(driver));
		
		// Verify Test Client Group Name is displayed
		Assert.assertTrue(SClients_ClientGroups.clientGroups_table(driver).getText().contains("Test Client Group Name"), "Test Client Group Name is not displayed");
		
		// Click Test Client Group Name
		perform.clickInDiv_Contains(driver, "Test Client Group Name");
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Switch into iFrame
		driver.switchTo().defaultContent();
		perform.switchToiFrameByID(driver, "frameDialogL1");
		
		// Wait for Placing Orders In This Group div
		perform.waitForElementToBeClickable(driver, SClients_ClientGroups.placingOrdersInThisGroup_div(), "id");
		
		// Verify that Test Test contact is in the Group Members
		Assert.assertTrue(SClientGroups_Members.groupMembers_txt(driver).getText().contains("Test Test"), "The contact is not in the Group Members table");
		
		// Wait for busy
		perform.waitForBusyToBeHidden(driver);
		
		// Select the contact Test Test
		perform.clickInTable_Contains(driver, "Test Test");
		
		// Uncheck the Place Orders checkbox
		perform.uncheckCheckbox(driver, SClientGroups_Members.placeOrders_chkbx(driver));
		
		// Click Save
		perform.clickInTable_Equals(driver, "Save");
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SClients_ClientGroups.okSave_btn(), "cssSelector");
		
		// Verify dialog text
		Assert.assertTrue(SClients_ClientGroups.dialogSave_txt(driver).getText().contains("Your changes were successfully saved."), "The dialog text is incorrect");
		
		// Click OK
		perform.click(driver, SClients_ClientGroups.okSave_btn(driver));

		// Click close
		perform.click(driver, SClients_OrderRouting.closeDialog_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Switch out of iFrame
		driver.switchTo().defaultContent();
		
		// Click Client Groups
		perform.click(driver, SClients.clientGroups_btn(driver));
		
		// Click Manage Client Groups
		perform.clickInDiv_Contains(driver, "Manage Client Groups...");
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Switch into iFrame
		perform.switchToiFrameByID(driver, "frameDialogL1");
		
		// Click on Test Client Group Name
		perform.clickInTable_Contains(driver, "Test Client Group Name");
		
		// Click Edit
		perform.click(driver, SClients_ClientGroups.editGroup_btn(driver));
		
		// Switch into iFrame
		driver.switchTo().defaultContent();
		perform.switchToiFrameByID(driver, "frameDialogL1");
		
		// Wait for Details tab
		perform.waitForElementToBeClickable(driver, SClients_ClientGroups.details_btn(), "id");
		
		// Go through each tab and make a change to separate it from the global settings
		// Details
		// Uncheck Use vendor override fee whenever possible checkbox
		perform.checkCheckbox(driver, SClientGroups_Details.allowClientsToEnterFee_chkbx(driver));

		// Automated
		// Click Automated tab
		perform.click(driver, SClients_ClientGroups.automated_btn(driver));
		
		// Wait for comments to borrower textbox
		perform.waitForElementToBeClickable(driver, SClientGroups_Automated.commentsToBorrower_txtbx(), "id");
		
		// Check Attach invoice when credit card is charged checkbox
		perform.checkCheckbox(driver, SClientGroups_Automated.attachInvoiceWhenCreditCardIsCharged_chkbx(driver));
		
		// AQM
		// Click AQM tab
		perform.click(driver, SClients_ClientGroups.aqm_btn(driver));
		
		// Wait for Additional AQI Recipients textbox
		perform.waitForElementToBeClickable(driver, SClientGroups_AQM.additionalAQIRecipients_txtbx(), "id");
		
		// Select every time for Automatically order default modules dropdown
		perform.selectDropdownOption(driver, SClientGroups_AQM.automaticallyOrderDefaultModules_dropdown(driver), "every time");
		
		// Save your changes and confirm the changes saved
		// Click Save
		perform.clickInTable_Equals(driver, "Save");
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SClients_ClientGroups.okSave_btn(), "cssSelector");
		
		Thread.sleep(1500);

		// Get Dialog text
		String dialogText = SClients_ClientGroups.dialogSave_txt(driver).getText();
		if (dialogText.contains("not saved")) {
			// Click OK
			perform.click(driver, SClients_ClientGroups.okSave_btn(driver));
			
			// Click Save
			perform.clickInTable_Equals(driver, "Save");
			
			// Wait for OK button
			perform.waitForElementToBeClickable(driver, SClients_ClientGroups.okSave_btn(), "cssSelector");
		} // end if
		
		// Verify dialog text
		Assert.assertTrue(SClients_ClientGroups.dialogSave_txt(driver).getText().contains("Your changes were successfully saved."), "The dialog text is incorrect");
		
		// Click OK
		perform.click(driver, SClients_ClientGroups.okSave_btn(driver));

		// Click close
		perform.click(driver, SClients_OrderRouting.closeDialog_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Switch out of iFrame
		driver.switchTo().defaultContent();
		
		// Click Client Groups
		perform.click(driver, SClients.clientGroups_btn(driver));
		
		// Click Manage Client Groups
		perform.clickInDiv_Contains(driver, "Manage Client Groups...");
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Switch into iFrame
		perform.switchToiFrameByID(driver, "frameDialogL1");
		
		// Click on Test Client Group Name
		perform.clickInTable_Contains(driver, "Test Client Group Name");
		
		// Click Edit
		perform.click(driver, SClients_ClientGroups.editGroup_btn(driver));
		
		// Switch into iFrame
		driver.switchTo().defaultContent();
		perform.switchToiFrameByID(driver, "frameDialogL1");
		
		// Wait for Details tab
		perform.waitForElementToBeClickable(driver, SClients_ClientGroups.details_btn(), "id");
		
		// Verify Allow clients to enter fee checkbox is checked
		Assert.assertTrue(SClientGroups_Details.allowClientsToEnterFee_chkbx(driver).isSelected(), "The Allow clients to enter fee checkbox should be checked");
		
		// Click Automated tab
		perform.click(driver, SClients_ClientGroups.automated_btn(driver));
		
		// Wait for comments to borrower textbox
		perform.waitForElementToBeClickable(driver, SClientGroups_Automated.commentsToBorrower_txtbx(), "id");
		
		// Verify Attach invoice when credit card is charged checkbox is checked
		Assert.assertTrue(SClientGroups_Automated.attachInvoiceWhenCreditCardIsCharged_chkbx(driver).isSelected(), "The Use QC Folders checkbox should be unchecked");
		
		// AQM
		// Click AQM tab
		perform.click(driver, SClients_ClientGroups.aqm_btn(driver));
		
		// Wait for Additional AQI Recipients textbox
		perform.waitForElementToBeClickable(driver, SClientGroups_AQM.additionalAQIRecipients_txtbx(), "id");
		
		// Verify every time is selected for Automatically order default modules dropdown
		perform.selectDropdownOption(driver, SClientGroups_AQM.automaticallyOrderDefaultModules_dropdown(driver), "every time");
		Assert.assertTrue(new Select(SClientGroups_AQM.automaticallyOrderDefaultModules_dropdown(driver)).getFirstSelectedOption().getText().equals("every time"), "every time should be selected for Automatically order default modules dropdown");

		// Click close
		perform.click(driver, SClients_OrderRouting.closeDialog_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Switch out of iFrame
		driver.switchTo().defaultContent();
		
		// Change some of the global settings to be different from what is saved in the client group
		// Go to VMP XSite Settings
		secure.goToVMPXSites(driver);
		
		// Click on Configure Automatic Settings
		perform.click(driver, SVMPXSites.configureAutomaticSettings_lnk(driver));
		
		// Wait for Use vendor overrirde checkbox
		perform.waitForElementToBeClickable(driver, SVMPXSites.useVendorOverrideFeeWheneverPossible_chkbx(), "id");
		
		// Select VMP XSite fee when assigning orders
		perform.selectDropdownOption(driver, SConfigureAutomaticSettings.useWhenAssigningOrders_dropdown(driver), "VMP XSite fee");
		
		// Check Attach invoice when order is marked complete checkbox
		perform.checkCheckbox(driver, SConfigureAutomaticSettings.attachInvoiceWhenOrderIsMarkedComplete_chkbx(driver));
		
		// Save the new settings
		secure.saveVMPXSiteSettings(driver);
		
		// Click on Configure Order Form
		perform.click(driver, SVMPXSites.configureOrderForm_lnk(driver));
		
		// Wait for Allow clients to enter fee checkbox
		perform.waitForElementToBeClickable(driver, SConfigureOrderForm.allowClientsToEnterFee_chkbx(), "id");
		
		// Check Allow clients to select AMC/Firm checkbox
		perform.checkCheckbox(driver, SConfigureOrderForm.allowClientsToSelectAMCFirm_chkbx(driver));
		
		// Save the new settings
		secure.saveVMPXSiteSettings(driver);
		
		// Go to AQM Settings
		secure.goToAppraisalQualityManagementSettings(driver);
		
		// Check RealView
		if (!SAppraisalQualityManagementSettings.realView_btn(driver).getAttribute("src").contains("Checkmark-Checked")) {
			perform.click(driver, SAppraisalQualityManagementSettings.realView_btn(driver));
		}
		
		// Save the settings
		secure.saveAppraisalQualityManagementSettings(driver);
		
		// Edit the client group
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
		
		// Click on Test Client Group Name
		perform.clickInTable_Contains(driver, "Test Client Group Name");
		
		// Click Edit
		perform.click(driver, SClients_ClientGroups.editGroup_btn(driver));
		
		// Switch into iFrame
		driver.switchTo().defaultContent();
		perform.switchToiFrameByID(driver, "frameDialogL1");
		
		// Wait for Details tab
		perform.waitForElementToBeClickable(driver, SClients_ClientGroups.details_btn(), "id");
		
		// Confirm the changes to the global settings did not change the altered settings in the client group
		// The Allow clients to select AMC/Firm checkbox should be unchecked
		Assert.assertTrue(!SClientGroups_Details.allowClientsToSelectAMC_chkbx(driver).isSelected(), "The Allow clients to select AMC/Firm checkbox should be unchecked and not affected by the Global setting");
		
		// Click Automated tab
		perform.click(driver, SClients_ClientGroups.automated_btn(driver));
		
		// Wait for comments to borrower textbox
		perform.waitForElementToBeClickable(driver, SClientGroups_Automated.commentsToBorrower_txtbx(), "id");
		
		// The Create invoice when new order is placed checkbox should be unchecked
		Assert.assertTrue(!SClientGroups_Automated.createInvoiceWhenOrderIsPlaced_chkbx(driver).isSelected(), "The Create invoice when new order is placed checkbox should be unchecked and not affected by the Global setting");
		
		// Click AQM tab
		perform.click(driver, SClients_ClientGroups.aqm_btn(driver));
		
		// Wait for Additional AQI Recipients textbox
		perform.waitForElementToBeClickable(driver, SClientGroups_AQM.additionalAQIRecipients_txtbx(), "id");
		
		// The RealView setting should be unselected
		Assert.assertTrue(!SClientGroups_AQM.realView_btn(driver).getAttribute("src").contains("Checkmark-Checked"), "The RealView setting should be unselected and not affected by the Global setting");
		
		// Log test
		test.log(LogStatus.INFO, "clients", "Edit Client Group");
		
	} // end editClientGroup
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Go to Clients</li>
	 * 	<li>Click Client Groups</li>
	 * 	<li>Click Manage Client Groups</li>
	 * 	<li>Click on Test Client Group Name</li>
	 * 	<li>Click Delete Group</li>
	 * 	<li>Verify Confirm Delete dialog text</li>
	 * 	<li>Click Yes</li>
	 * 	<li>Verify group got deleted</li>
	 * 	<li>Click close</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Clients", "Secure - Client Groups", "Secure - Delete Client Group"}, dependsOnMethods={"editClientGroup"})
	public void deleteClientGroup() throws Exception {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Login to Secure
		secure.login(driver, user, StoredVariables.getpassword().get());
		
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
		
		// Click on Test Client Group Name
		perform.clickInTable_Contains(driver, "Test Client Group Name");
		
		// Click Delete Group
		perform.clickInTable_Equals(driver, "Delete Group");
		
		// Wait for Yes button
		perform.waitForElementToBeClickable(driver, SClients_ClientGroups.yesDelete_btn(), "cssSelector");
		
		// Verify Confirm Delete dialog text
		Assert.assertTrue(SClients_ClientGroups.dialogConfirmDelete_txt(driver).getText().contains("Are you sure you want to delete the selected client group?"), "The dialog text is incorrect");
		
		// Click Yes
		perform.click(driver, SClients_ClientGroups.yesDelete_btn(driver));
		
		// Wait for delete dialog to go away
		String style = SClients_ClientGroups.dialogConfirmDelete_txt(driver).getAttribute("style");
		while (style.contains("block"))
		{
			Thread.sleep(500);
			style = SClients_ClientGroups.dialogConfirmDelete_txt(driver).getAttribute("style");
		}
		
		Thread.sleep(2000);
		
		// Verify group got deleted
		Assert.assertTrue(!SClients_ClientGroups.dialogClientGroups_txt(driver).getText().contains("Test Client Group Name"), "The group was not deleted");
		
//		// Click close
//		perform.click(driver, SClients_OrderRouting.closeDialog_btn(driver));
		
		// Switch out of iFrame
		driver.switchTo().defaultContent();
		
		// Log test
		test.log(LogStatus.INFO, "clients", "Deleted Round Robin Group");
		
	} // end deleteClientGroup
	
} // end the Secure_Login class
