package baselineWhitelist;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjects.Vendors.VOrders;
import pageObjects.Vendors.VUsers;
import pageObjects.Vendors.VUsers_AddTrainee;
import pageObjects.Vendors.VW9Form;
import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.StoredVariables;

/**
 * <h1>Baseline - Whitelist</h1>
 * 
 * <p>
 *
 * @author  Dustin Norman
 * @since   07-23-2018
 */

@Listeners(utils.Listener.class)
public class VendorsProfileWhitelist extends TestSetup {
	
	/** The user secure. */
	private static String userVendors = "BaselineAppraiser3";
	
	/** The whitelist string 1 */
	private static String whitelistString1 = "Test String €‚ƒ„…†‡ˆ‰Š‹ŒŽ‘’“”•–—˜˜˜™š›œŸ ¡¢£¤¥¦§¨©ª«¬­®¯°±²³´µ¶·¸¹º»¼½¾¿ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚÛÜÝÞßàáâãäåæçèéêëìíîïðñòóôõö÷øùúûüýþÿ !\"#$%&'()*+,-./0123456789:;<=>?@[\\]^_`{|}~";
	
	/** The whitelist string 2 */
	private static String whitelistString2 = "‚ƒ„…†‡ˆ‰Š‹Œ“”•–—˜˜˜™š›¡¢£¤¥¦§¨©ª«¬­®¯°±²¶·¸¹º»¼½¾¿ÀÁÂÃÄÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚÞßàáâãäåæçèéêëìðñòóôõö÷øùúûüýþÿ !\"#$%&'()*+,-./0123duek89:;<=>?@[\\]^_`{|}~";
	
	/** The whitelist string 3 */
	private static String whitelistString3 = "Test€‚ƒ„…†‘’”•—˜§©ª°±²³´µ¶·¸¹º»½ÜÝßóþÿ-./2euid8>`~";
	
	/** The whitelist 1 expected */
	private static String whitelist1Expected = "Test String ©® !\"#$%&'()*+,-./0123456789:;<=>?@[\\]^_`{|}~";
	
	/** The whitelist 2 expected */
	private static String whitelist2Expected = "Test String ©®";
	
	/** The whitelist 3 expected */
	private static String whitelist3Expected = "Test©-./2euid8`~";
	
	/** The whitelist 4 expected */
	private static String whitelist4Expected = "©® !\"#$%&'()*+,-./0123duek89:;=?@[\\]^_`{|}~";
	
	/** The whitelist 5 expected */
	private static String whitelist5Expected = "Test String ©® !\"#$%&'()*+,-./0123456789:;=?@[\\]^_`{|}~";
	
	/** The whitelist 6 expected */
	private static String whitelist6Expected = "Test String ©® !\"#$%&\'()*+,-./0123456789:;<=>?@[\\]^_`{|}~";

	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Vendors</li>
	 * 	<li>Go to Users</li>
	 * 	<li>Set click out field to have the whitelisting take place</li>
	 * 	<li>Test Primary E-mail Address/Username field</li>
	 * 	<li>Test Additional E-mail addresses field</li>
	 * 	<li>Test First Name field</li>
	 * 	<li>Test Last Name field</li>
	 * 	<li>Test Company Name field</li>
	 * 	<li>Test Tax Identification field</li>
	 * 	<li>Test Office Phone Number field</li>
	 * 	<li>Test Extension Number field</li>
	 * 	<li>Test Cell Phone Number field</li>
	 * 	<li>Test Fax Number field</li>
	 * 	<li>Go to Professional tab</li>
	 * 	<li>Click Add new W-9 link</li>
	 * 	<li>Test Name field</li>
	 * 	<li>Test Business Name field</li>
	 * 	<li>Test Tax Classification field</li>
	 * 	<li>Test Other field</li>
	 * 	<li>Test Exempt payee code field</li>
	 * 	<li>Test Exemption from FATCA field</li>
	 * 	<li>Test Address field</li>
	 * 	<li>Test City, State, Zip code field</li>
	 * 	<li>Test List account number field</li>
	 * 	<li>Test Requestor's name and address field</li>
	 * 	<li>Test Signature field</li>
	 * 	<li>Test Date field</li>
	 * 	<li>Click Cancel</li>
	 * 	<li>Click No</li>
	 * 	<li>Verify Licenses</li>
	 * 	<li>Set click out field to have the whitelisting take place</li>
	 * 	<li>Test License Number field</li>
	 * 	<li>Test Expiration Date field</li>
	 * 	<li>Click Cancel</li>
	 * 	<li>CLick No</li>
	 * 	<li>Click add Insurance Policies</li>
	 * 	<li>Set click out field to have the whitelisting take place</li>
	 * 	<li>Test Carrier Name field</li>
	 * 	<li>Test Policy Number field</li>
	 * 	<li>Test Policy Amount field</li>
	 * 	<li>Test Expiration Date field</li>
	 * 	<li>Click Cancel</li>
	 * 	<li>CLick No</li>
	 * 	<li>Click add Trainees</li>
	 * 	<li>Set click out field to have the whitelisting take place</li>
	 * 	<li>Test First Name field</li>
	 * 	<li>Test Last Name field</li>
	 * 	<li>Test License Number field</li>
	 * 	<li>Test Expiration Date field</li>
	 * 	<li>Click Cancel</li>
	 * 	<li>Click Orders</li>
	 * 	<li>CLick No</li>
	 * 	<li>Go to Users</li>
	 * 	<li>Click Products</li>
	 * 	<li>Click Note</li>
	 * 	<li>Test Fee Notes field</li>
	 * 	<li>Click OK</li>
	 * 	<li>Save settings</li>
	 * 	<li>Click Note</li>
	 * 	<li>Verify Fee Notes field was whitelisted</li>
	 * 	<li>Clear the Fee Notes</li>
	 * 	<li>Click OK</li>
	 * 	<li>Save settings</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (groups={"Whitelist", "Vendors - Users", "Vendors - Professional", "Vendors - Products"}, alwaysRun=true)
	public void orderDetailsWhitelisting() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		if (StoredVariables.getmobile().get()==false) {
		
			String password = StoredVariables.getpassword().get();
			
			// Login to Vendors
			vendors.login(driver, userVendors, password);
			
			// Go to Users
			vendors.goToUsers(driver);
			
			// Set click out field to have the whitelisting take place
			WebElement contactInformationBar = driver.findElement(By.cssSelector("#divDetails > div.BlackBar"));
			
			// Wait for busy
			perform.waitForBusyToBeHidden(driver);

			// Test Primary E-mail Address/Username field
			perform.verifyWhitelisting(driver, VUsers.primaryEmail_txtbx(driver), whitelistString1, contactInformationBar, whitelist1Expected);
			
			// Test Additional E-mail addresses field
			perform.verifyWhitelisting(driver, VUsers.additionalEmail_txtbx(driver), whitelistString1, contactInformationBar, whitelist1Expected);
			
			// Test First Name field
			perform.verifyWhitelisting(driver, VUsers.firstName_txtbx(driver), whitelistString1, contactInformationBar, whitelist1Expected);
			
			// Test Last Name field
			perform.verifyWhitelisting(driver, VUsers.lastName_txtbx(driver), whitelistString1, contactInformationBar, whitelist1Expected);
			
			// Test Company Name field
			perform.verifyWhitelisting(driver, VUsers.companyName_txtbx(driver), whitelistString1, contactInformationBar, whitelist1Expected);
			
			// Test Tax Identification field
			perform.verifyWhitelisting(driver, VUsers.taxIdentification_txtbx(driver), whitelistString1, contactInformationBar, whitelist1Expected);
			
			// Test Office Phone Number field
			perform.verifyWhitelisting(driver, VUsers.officePhoneNumber_txtbx(driver), whitelistString1, contactInformationBar, whitelist1Expected);
			
			// Test Extension Number field
			perform.verifyWhitelisting(driver, VUsers.extension_txtbx(driver), whitelistString1, contactInformationBar, whitelist1Expected);
			
			// Test Cell Phone Number field
			perform.verifyWhitelisting(driver, VUsers.cellPhoneNumber_txtbx(driver), whitelistString1, contactInformationBar, whitelist1Expected);
			
			// Test Fax Number field
			perform.verifyWhitelisting(driver, VUsers.faxNumber_txtbx(driver), whitelistString1, contactInformationBar, whitelist1Expected);
			
			// Go to Professional tab
			perform.click(driver,VUsers.professional_btn(driver));
	
			// Wait for element
			perform.waitForElementToBeClickable(driver, VUsers.addNewW9_link(driver));
			
			// Click Add new W-9 link
			perform.click(driver,VUsers.addNewW9_link(driver));
			
			// Wait for busy to be hidden
			perform.waitForBusyToBeHidden(driver);
	
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			// Switch into iFrame
			perform.waitForiFrameSrcAndSwitchToIt(driver, "Dialogs/W9.aspx?", By.id(VW9Form.name_txtbx()));
			
			// Wait for element
			perform.waitForElementToBeClickable(driver, VW9Form.name_txtbx(driver));
			
			// Test Name field
			perform.verifyWhitelisting(driver, VW9Form.name_txtbx(driver), whitelistString1, VW9Form.enterYourW9Information_txt(driver), whitelist2Expected);
			
			// Test Business Name field
			perform.verifyWhitelisting(driver, VW9Form.businessName_txtbx(driver), whitelistString3, VW9Form.enterYourW9Information_txt(driver), whitelist3Expected);
			
			// Test Tax Classification field
			perform.verifyWhitelisting(driver, VW9Form.limitedLiability_txtbx(driver), whitelistString3, VW9Form.enterYourW9Information_txt(driver), whitelist3Expected);
			
			// Test Other field
			perform.verifyWhitelisting(driver, VW9Form.other_txtbx(driver), whitelistString3, VW9Form.enterYourW9Information_txt(driver), whitelist3Expected);
			
			// Test Exempt payee code field
			perform.verifyWhitelisting(driver, VW9Form.exemptPayeeCode_txtbx(driver), whitelistString1, VW9Form.enterYourW9Information_txt(driver), whitelist5Expected);
			
			// Test Exemption from FATCA field
			perform.verifyWhitelisting(driver, VW9Form.exemptionFromFATCA_txtbx(driver), whitelistString1, VW9Form.enterYourW9Information_txt(driver), whitelist5Expected);
			
			// Test Address field
			perform.verifyWhitelisting(driver, VW9Form.address_txtbx(driver), whitelistString2, VW9Form.enterYourW9Information_txt(driver), whitelist4Expected);
			
			// Test City, State, Zip code field
			perform.verifyWhitelisting(driver, VW9Form.cityStateZip_txtbx(driver), whitelistString2, VW9Form.enterYourW9Information_txt(driver), whitelist4Expected);
			
			// Test List account number field
			perform.verifyWhitelisting(driver, VW9Form.listAccountNumbers_txtbx(driver), whitelistString3, VW9Form.enterYourW9Information_txt(driver), whitelist3Expected);
			
			// Test Requestor's name and address field
			perform.verifyWhitelisting(driver, VW9Form.requestersNameAndAddress_txtbx(driver), whitelistString1, VW9Form.enterYourW9Information_txt(driver), whitelist5Expected);
			
			// Test Signature field
			perform.verifyWhitelisting(driver, VW9Form.signatureOfUSPerson_txtbx(driver), whitelistString3, VW9Form.enterYourW9Information_txt(driver), whitelist3Expected);
			
			// Test Date field
			perform.verifyWhitelisting(driver, VW9Form.date_txtbx(driver), whitelistString1, VW9Form.enterYourW9Information_txt(driver), whitelist5Expected);
			
			// Click Cancel
			perform.click(driver,VW9Form.cancel_btn(driver));
			
			// Wait for element
			perform.waitForElementToBeClickable(driver, VW9Form.noSaveChanges_btn(driver));
			
			// Click No
			perform.click(driver,VW9Form.noSaveChanges_btn(driver));
			
			// Switch out of iFrame
			driver.switchTo().defaultContent();
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			// Verify Licenses
			perform.click(driver,VUsers.addLicense_link(driver));
			
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
	
			// Wait for element
			perform.waitForElementToBeClickable(driver, VUsers.licenseNumber_txtbx(driver));
			
			// Set click out field to have the whitelisting take place
			WebElement addLicenseBar = driver.findElement(By.cssSelector("#divLicense > div.BlackBarNoMargin"));
			
			// Test License Number field
			perform.verifyWhitelisting(driver, VUsers.licenseNumber_txtbx(driver), whitelistString1, addLicenseBar, whitelist1Expected);
			
			// Test Expiration Date field
			perform.verifyWhitelisting(driver, VUsers.expirationDate_txtbx(driver), whitelistString1, addLicenseBar, whitelist1Expected);
			
			// Click Cancel
			perform.click(driver,VUsers.cancelAddLicense_btn(driver));
			
			// Wait for element
			perform.waitForElementToBeClickable(driver, VUsers.noSave_btn(driver));
	
			// CLick No
			perform.click(driver,VUsers.noSave_btn(driver));
			
			// Wait for busy to be hidden
			perform.waitForBusyToBeHidden(driver);
			
			// Click add Insurance Policies
			perform.click(driver,VUsers.addInsurancePolicies_link(driver));
			
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
	
			// Wait for element
			perform.waitForElementToBeClickable(driver, VUsers.carrierName_txtbx(driver));
			
			// Set click out field to have the whitelisting take place
			WebElement addInsurancePolicyBar = driver.findElement(By.cssSelector("#divHeader"));
			
			// Test Carrier Name field
			perform.verifyWhitelisting(driver, VUsers.carrierName_txtbx(driver), whitelistString1, addInsurancePolicyBar, whitelist1Expected);
			
			// Test Policy Number field
			perform.verifyWhitelisting(driver, VUsers.policyNumber_txtbx(driver), whitelistString1, addInsurancePolicyBar, whitelist1Expected);
			
			// Test Policy Amount field
			perform.verifyWhitelisting(driver, VUsers.policyAmount_txtbx(driver), whitelistString1, addInsurancePolicyBar, whitelist1Expected);
			
			// Test Expiration Date field
			perform.verifyWhitelisting(driver, VUsers.expirationDateInsurancePolicy_txtbx(driver), whitelistString1, addInsurancePolicyBar, whitelist1Expected);
			
			// Click Cancel
			perform.click(driver,VUsers.cancelAddInsurancePolicy_btn(driver));
			
			// Wait for element
			perform.waitForElementToBeClickable(driver, VUsers.noSave_btn(driver));
	
			// CLick No
			perform.click(driver,VUsers.noSave_btn(driver));
			
			// Wait for busy to be hidden
			perform.waitForBusyToBeHidden(driver);
			
			// Click add Trainees
			perform.click(driver,driver.findElement(By.linkText("Add trainee")));
			
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			// Wait for element
			perform.waitForElementToBeClickable(driver, VUsers_AddTrainee.firstName_txtbx(driver));
	
			// Set click out field to have the whitelisting take place
			WebElement addTraineeBar = driver.findElement(By.id("spnTraineeTitle"));
			
			// Test First Name field
			perform.verifyWhitelisting(driver, VUsers_AddTrainee.firstName_txtbx(driver), whitelistString1, addTraineeBar, whitelist1Expected);
			
			// Test Last Name field
			perform.verifyWhitelisting(driver, VUsers_AddTrainee.lastName_txtbx(driver), whitelistString1, addTraineeBar, whitelist1Expected);
			
			// Test License Number field
			perform.verifyWhitelisting(driver, VUsers_AddTrainee.licenseNumber_txtbx(driver), whitelistString1, addTraineeBar, whitelist1Expected);
			
			// Test Expiration Date field
			perform.verifyWhitelisting(driver, VUsers_AddTrainee.expirationDate_txtbx(driver), whitelistString1, addTraineeBar, whitelist1Expected);
			
			// Click Cancel
			perform.click(driver,VUsers_AddTrainee.cancel_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			// Click Orders
			perform.click(driver,VOrders.orders_btn(driver));
			
			// Wait for element
			perform.waitForElementToBeClickable(driver, VUsers.noSave_btn(driver));
	
			// CLick No
			perform.click(driver,VUsers.noSave_btn(driver));
			
			// Wait for busy to be hidden
			perform.waitForBusyToBeHidden(driver);
			
			// Go to Users
			vendors.goToUsers(driver);
			
			// Click Products
			perform.click(driver,VUsers.products_btn(driver));
			
			// Wait for element
			perform.waitForElementToBeClickable(driver, VUsers.note_link(driver));
			
			// Click Note
			perform.click(driver,VUsers.note_link(driver));
			
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
	
			// Wait for element
			perform.waitForElementToBeClickable(driver, VUsers.feeNotes_txt(driver));
			
			// Test Fee Notes field
			VUsers.feeNotes_txt(driver).clear();
			perform.type(driver,VUsers.feeNotes_txt(driver), whitelistString1);
			
			// Click OK
			perform.click(driver,VUsers.okFeeNotes_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			// Save settings
			vendors.saveUsersSettings(driver);
			
			// Click Note
			perform.click(driver,VUsers.note_link(driver));
			
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
	
			// Wait for element
			perform.waitForElementToBeClickable(driver, VUsers.feeNotes_txt(driver));
			
			// Verify Fee Notes field was whitelisted
			String feeNotes = VUsers.feeNotes_txt(driver).getAttribute("value");
			Assert.assertTrue(feeNotes.equals(whitelist6Expected), "The Fee Notes textbox was not whitelisted properly\n"
					+ "Screen:\n" + VUsers.feeNotes_txt(driver).getAttribute("value") + "\nExpected:\n" + whitelist6Expected);
			
			// Clear the Fee Notes
			VUsers.feeNotes_txt(driver).clear();
	
			// Click OK
			perform.click(driver,VUsers.okFeeNotes_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			// Save settings
			vendors.saveUsersSettings(driver);
			
			// Log test
			test.log(LogStatus.INFO, "Whitelisting", "Verified whitelisting in Vendors Profile");
			
		} // end if
		
	} // end orderDetailsWhitelisting
	
} // end the Whitelisting class
