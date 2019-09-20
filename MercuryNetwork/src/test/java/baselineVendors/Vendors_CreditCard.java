package baselineVendors;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Vendors.VCreditCard;
import pageObjects.Vendors.VMerchantInformation;
import pageObjects.Vendors.VReceipt;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Baseline Vendors - Credit Card</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class Vendors_CreditCard extends TestSetup {
	
	/** The user. */
	private final String user = "EVFAMC";
	
	/** The first name. */
	private String firstName = "";
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Vendors</li>
	 * 	<li>Go to Credit Card</li>
	 * 	<li>Click New charge</li>
	 * 	<li>Switch iFrame</li>
	 * 	<li>Enter First Name</li>
	 * 	<li>Enter Last Name</li>
	 * 	<li>Enter Zip Code</li>
	 * 	<li>Enter Credit Card Number</li>
	 * 	<li>Select Exp month</li>
	 * 	<li>Select Exp year</li>
	 * 	<li>Enter Amount</li>
	 * 	<li>Enter Email Address</li>
	 * 	<li>Check Email Receipt</li>
	 * 	<li>Enter Notes</li>
	 * 	<li>Click Charge Card</li>
	 * 	<li>Go to Credit Card</li>
	 * 	<li>Enter Name</li>
	 * 	<li>Click Search</li>
	 * 	<li>Verify the charge is in the first row of the table</li>
	 * 	<li>Log test</li>

* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Vendors - Credit Card", "Vendors - Charge Card"}, alwaysRun=true)
	public void newChargeAndSearch() throws Exception {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Login to Vendors
		vendors.login(driver, user, StoredVariables.getpassword().get());
		
		// Go to Credit Card
		vendors.goToCreditCard(driver);
		
		// Click New charge
		perform.clickInTable_Equals(driver, "New charge");
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Switch iFrame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "StoreCard.aspx", By.id(VCreditCard.firstName_txtbx()));
		
		// Wait for First Name textbox
		perform.waitForElementToBeClickable(driver, VCreditCard.firstName_txtbx(), "id");
		
		// Enter First Name
		firstName = "Automation" + perform.randomNumbers(driver, 5);
		perform.type(driver, VCreditCard.firstName_txtbx(driver), firstName);
		
		// Enter Last Name
		perform.type(driver, VCreditCard.lastName_txtbx(driver), "Baseline");
		
		// Enter Zip Code
		perform.type(driver, VCreditCard.zipCode_txtbx(driver), "73099");
		
		// Enter Credit Card Number
		perform.type(driver, VCreditCard.creditCardNumber_txtbx(driver), "4111111111111111");
		
		// Select Exp month
		perform.selectDropdownOption(driver, VCreditCard.expMonth_dropdown(driver), "12");
		
		// Select Exp year
		perform.selectDropdownOption(driver, VCreditCard.expYear_dropdown(driver), "2025");
		
		// Enter Amount
		perform.type(driver, VCreditCard.amount_txtbx(driver), perform.randomNumbers(driver, 3));
		
		// Enter Email Address
		perform.type(driver, VCreditCard.emailAddress_txtbx(driver), "test"+StoredVariables.getcatchAllDomain().get());
		
		// Check Email Receipt
		perform.checkCheckbox(driver, VCreditCard.emailReceipt_chkbx(driver));
		
		// Enter Notes
		perform.type(driver, VCreditCard.notes_txtbx(driver), "These are test new charge notes for the baseline");
		
		// Click Charge Card
        perform.click(driver,VCreditCard.chargeCard_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Switch out of iFrame
		driver.switchTo().defaultContent();
		
		// Wait for name textbox
		perform.waitForElementToBeClickable(driver, VCreditCard.name_txtbx(), "id");
		
		// Go to Credit Card
		vendors.goToCreditCard(driver);
		
		// Enter Name
		perform.type(driver, VCreditCard.name_txtbx(driver), firstName);
		
		// Click Search
        perform.click(driver,VCreditCard.search_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Verify the charge is in the first row of the table
		Assert.assertTrue(VCreditCard.transactionTableFirstRow_txt(driver).getText().contains(firstName), "The charge was not found when searching");
		
		// Log test
		test.log(LogStatus.INFO, "Credit Card", "Verify you can add a charge");
		
	} // end newChargeAndSearch
	
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Vendors</li>
	 * 	<li>Go to Credit Card</li>
	 * 	<li>Click Receipts</li>
	 * 	<li>Clear all of the fields</li>
	 * 	<li>Set variables</li>
	 * 	<li>Enter First Name</li>
	 * 	<li>Enter Last Name</li>
	 * 	<li>Enter Company Name</li>
	 * 	<li>Enter Address</li>
	 * 	<li>Enter Address 2</li>
	 * 	<li>Enter City</li>
	 * 	<li>Select State</li>
	 * 	<li>Enter Zip Code</li>
	 * 	<li>Enter Phone</li>
	 * 	<li>Enter Contact Email</li>
	 * 	<li>Enter Website Address</li>
	 * 	<li>Enter Email Subject</li>
	 * 	<li>Enter From Address</li>
	 * 	<li>Enter Additional Message</li>
	 * 	<li>Click Preview</li>
	 * 	<li>Switch window</li>
	 * 	<li>Get invoice text</li>
	 * 	<li>Verify text exists</li>
	 * 	<li>Close the new window</li>
	 * 	<li>Click Save</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Vendors - Credit Card", "Vendors - Receipt"}, alwaysRun=true)
	public void receipts() throws Exception {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Login to Vendors
		vendors.login(driver, user, StoredVariables.getpassword().get());
		
		// Go to Credit Card
		vendors.goToCreditCard(driver);
		
		// Click Receipts
		perform.clickInTable_Contains(driver, "Receipts");
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for First Name textbox
		perform.waitForElementToBeClickable(driver, VReceipt.firstName_txtbx(), "id");
		
		// Clear all of the fields
		VReceipt.firstName_txtbx(driver).clear();
		VReceipt.lastName_txtbx(driver).clear();
		VReceipt.companyName_txtbx(driver).clear();
		VReceipt.address_txtbx(driver).clear();
		VReceipt.address2_txtbx(driver).clear();
		VReceipt.city_txtbx(driver).clear();
		VReceipt.zipCode_txtbx(driver).clear();
		VReceipt.phone_txtbx(driver).clear();
		VReceipt.contactEmail_txtbx(driver).clear();
		VReceipt.websiteAddress_txtbx(driver).clear();
		VReceipt.emailSubjectLine_txtbx(driver).clear();
		VReceipt.fromAddress_txtbx(driver).clear();
		VReceipt.additionalMessage_txtbx(driver).clear();
		
		// Set variables
		String first = "Automation" + perform.randomNumbers(driver, 3);
		String last = "Invoice Receipt" + perform.randomNumbers(driver, 3);
		String companyName = "Merucry Network" + perform.randomNumbers(driver, 3);
		String address = perform.randomNumbers(driver, 3) + " Test St.";
		String address2 = "Suite " + perform.randomLetters(driver, 1);
		String city = "Yukon";
		String state = "Oklahoma";
		String zipCode = "73099";
		String phone = "405555" + perform.randomNumbers(driver, 4);
		String contactEmail = "test" + perform.randomNumbers(driver, 3) + StoredVariables.getcatchAllDomain().get();
		String websiteAddress = "mercuryvmp" + perform.randomNumbers(driver, 3) + ".com";
		String emailSubject = "Subject " + perform.randomNumbers(driver, 3);
		String fromAddress = "automationBaseline" + perform.randomNumbers(driver, 3) + StoredVariables.getcatchAllDomain().get();
		String additionalMessage = "Test baseline additional message " + perform.randomNumbers(driver, 3);
		
		// Enter First Name
		perform.type(driver, VReceipt.firstName_txtbx(driver), first);
		
		// Enter Last Name
		perform.type(driver, VReceipt.lastName_txtbx(driver), last);
		
		// Enter Company Name
		perform.type(driver, VReceipt.companyName_txtbx(driver), companyName);
		
		// Enter Address
		perform.type(driver, VReceipt.address_txtbx(driver), address);
		
		// Enter Address 2
		perform.type(driver, VReceipt.address2_txtbx(driver), address2);
		
		// Enter City
		perform.type(driver, VReceipt.city_txtbx(driver), city);
		
		// Select State
		perform.selectDropdownOption(driver, VReceipt.state_dropdown(driver), state);
		
		// Enter Zip Code
		perform.type(driver, VReceipt.zipCode_txtbx(driver), zipCode);
		
		// Enter Phone
		perform.type(driver, VReceipt.phone_txtbx(driver), phone);
		
		// Enter Contact Email
		perform.type(driver, VReceipt.contactEmail_txtbx(driver), contactEmail);
		
		// Enter Website Address
		perform.type(driver, VReceipt.websiteAddress_txtbx(driver), websiteAddress);
		
		// Enter Email Subject
		perform.type(driver, VReceipt.emailSubjectLine_txtbx(driver), emailSubject);
		
		// Enter From Address
		perform.type(driver, VReceipt.fromAddress_txtbx(driver), fromAddress);
		
		// Enter Additional Message
		perform.type(driver, VReceipt.additionalMessage_txtbx(driver), additionalMessage);
		
		// Click Preview
        perform.click(driver,VReceipt.preview_btn(driver));
		
		// Switch window
		perform.switchToXSiteWindowByTitle(driver, "Invoice");
		
		// Get invoice text
		String text = VReceipt.invoice_txt(driver).getText();
		
		// Verify text exists
		Assert.assertTrue(text.contains(first), "Text is missing from the invoice");
		Assert.assertTrue(text.contains(last), "Text is missing from the invoice");
		Assert.assertTrue(text.contains(companyName), "Text is missing from the invoice");
		Assert.assertTrue(text.contains(address), "Text is missing from the invoice");
		Assert.assertTrue(text.contains(address2), "Text is missing from the invoice");
		Assert.assertTrue(text.contains(city), "Text is missing from the invoice");
		Assert.assertTrue(text.contains(zipCode), "Text is missing from the invoice");
		Assert.assertTrue(text.contains(phone), "Text is missing from the invoice");
		Assert.assertTrue(text.contains(contactEmail), "Text is missing from the invoice");
		Assert.assertTrue(text.contains(websiteAddress), "Text is missing from the invoice");
		
		// Close the new window
		perform.closeNewWindow(driver);
		
		// Click Save
        perform.click(driver,VReceipt.save_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Log test
		test.log(LogStatus.INFO, "Credit Card", "Verify receipt and invoice text");
		
	} // end receipts
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Vendors</li>
	 * 	<li>Go to Credit Card</li>
	 * 	<li>Click Merchant information</li>
	 * 	<li>Clear fields</li>
	 * 	<li>Set variables</li>
	 * 	<li>Check AMEX</li>
	 * 	<li>Check Discover</li>
	 * 	<li>Enter Acquirer Bin</li>
	 * 	<li>Enter Merchant Number</li>
	 * 	<li>Enter Terminal ID</li>
	 * 	<li>Enter Store Number</li>
	 * 	<li>Enter Terminal Number</li>
	 * 	<li>Enter Merchant Location Number</li>
	 * 	<li>Enter Agent Number</li>
	 * 	<li>Enter Chain Number</li>
	 * 	<li>Enter Merchant Category</li>
	 * 	<li>Enter Contact Name</li>
	 * 	<li>Enter Email</li>
	 * 	<li>Click Submit</li>
	 * 	<li>Verify dialog text</li>
	 * 	<li>Click Yes</li>
	 * 	<li>Click Merchant information</li>
	 * 	<li>Verify data got saved</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Vendors - Credit Card", "Vendors - Merchant Information"}, alwaysRun=true)
	public void merchantInformation() throws Exception {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		if (StoredVariables.getmobile().get()==false) {
		
			// Login to Vendors
			vendors.login(driver, user, StoredVariables.getpassword().get());
			
			// Go to Credit Card
			vendors.goToCreditCard(driver);
			
			// Click Merchant information
			perform.clickInTable_Contains(driver, "Merchant information");
			
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			// Wait for Acquire bin textbox
			perform.waitForElementToBeClickable(driver, VMerchantInformation.acquirerBin_txtbx(), "id");
			
			// Clear fields
			perform.uncheckCheckbox(driver, VMerchantInformation.amex_chkbx(driver));
			perform.uncheckCheckbox(driver, VMerchantInformation.discover_chkbx(driver));
			VMerchantInformation.acquirerBin_txtbx(driver).clear();
			VMerchantInformation.merchantNumber_txtbx(driver).clear();
			VMerchantInformation.terminalID_txtbx(driver).clear();
			VMerchantInformation.storeNumber_txtbx(driver).clear();
			VMerchantInformation.terminalNumber_txtbx(driver).clear();
			VMerchantInformation.merchantLocationNumber_txtbx(driver).clear();
			VMerchantInformation.agentNumber_txtbx(driver).clear();
			VMerchantInformation.chainNumber_txtbx(driver).clear();
			VMerchantInformation.merchantCategory_txtbx(driver).clear();
			VMerchantInformation.contactName_txtbx(driver).clear();
			VMerchantInformation.email_txtbx(driver).clear();
			
			// Set variables
			String acquirerBin = perform.randomNumbers(driver, 6);
			String merchantNumber = perform.randomNumbers(driver, 12);
			String terminalID = perform.randomNumbers(driver, 8);
			String storeNumber = perform.randomNumbers(driver, 4);
			String terminalNumber = perform.randomNumbers(driver, 4);
			String merchantLocationNumber = perform.randomNumbers(driver, 5);
			String agentNumber = perform.randomNumbers(driver, 6);
			String chainNumber = perform.randomNumbers(driver, 6);
			String merchantCategory = perform.randomNumbers(driver, 4);
			String contactName = "Automation Baseline" + perform.randomNumbers(driver, 3);
			String email = "automationBaseline" + perform.randomNumbers(driver, 3) + StoredVariables.getcatchAllDomain().get();
			
			// Check AMEX
			perform.checkCheckbox(driver, VMerchantInformation.amex_chkbx(driver));
			
			// Check Discover
			perform.checkCheckbox(driver, VMerchantInformation.discover_chkbx(driver));
			
			// Enter Acquirer Bin
			perform.type(driver, VMerchantInformation.acquirerBin_txtbx(driver), acquirerBin);
			
			// Enter Merchant Number
			perform.type(driver, VMerchantInformation.merchantNumber_txtbx(driver), merchantNumber);
			
			// Enter Terminal ID
			perform.type(driver, VMerchantInformation.terminalID_txtbx(driver), terminalID);
			
			// Enter Store Number
			perform.type(driver, VMerchantInformation.storeNumber_txtbx(driver), storeNumber);
			
			// Enter Terminal Number
			perform.type(driver, VMerchantInformation.terminalNumber_txtbx(driver), terminalNumber);
			
			// Enter Merchant Location Number
			perform.type(driver, VMerchantInformation.merchantLocationNumber_txtbx(driver), merchantLocationNumber);
			
			// Enter Agent Number
			perform.type(driver, VMerchantInformation.agentNumber_txtbx(driver), agentNumber);
			
			// Enter Chain Number
			perform.type(driver, VMerchantInformation.chainNumber_txtbx(driver), chainNumber);
			
			// Enter Merchant Category
			perform.type(driver, VMerchantInformation.merchantCategory_txtbx(driver), merchantCategory);
			
			// Enter Contact Name
			perform.type(driver, VMerchantInformation.contactName_txtbx(driver), contactName);
			
			// Enter Email
			perform.type(driver, VMerchantInformation.email_txtbx(driver), email);
			
			// Click Submit
	        perform.click(driver,VMerchantInformation.submit_btn(driver));
			
			// Wait for Yes button
			perform.waitForElementToBeClickable(driver, VMerchantInformation.yes_btn(), "id");
			
			// Verify dialog text
			Assert.assertTrue(VMerchantInformation.informationUpdatedDialog_txt(driver).getText().contains("Processing merchant account changes will take 4-5 business days. Your current merchant account settings will be used until processing is complete. Do you wish to submit your changes?"), "The Information updated dialog text is incorrect");
			
			// Click Yes
	        perform.click(driver,VMerchantInformation.yes_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			// Click Merchant information
			perform.clickInTable_Contains(driver, "Merchant information");
			
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			// Wait for Acquirer bin textbox
			perform.waitForElementToBeClickable(driver, VMerchantInformation.acquirerBin_txtbx(), "id");
			
			// Verify data got saved
			Assert.assertTrue(VMerchantInformation.amex_chkbx(driver).isSelected(), "AMEX is not checked and should be");
			Assert.assertTrue(VMerchantInformation.discover_chkbx(driver).isSelected(), "Discover is not checked and should be");
			Assert.assertTrue(VMerchantInformation.acquirerBin_txtbx(driver).getAttribute("value").equals(acquirerBin), "Text is incorrect");
			Assert.assertTrue(VMerchantInformation.merchantNumber_txtbx(driver).getAttribute("value").equals(merchantNumber), "Text is incorrect");
			Assert.assertTrue(VMerchantInformation.terminalID_txtbx(driver).getAttribute("value").equals(terminalID), "Text is incorrect");
			Assert.assertTrue(VMerchantInformation.storeNumber_txtbx(driver).getAttribute("value").equals(storeNumber), "Text is incorrect");
			Assert.assertTrue(VMerchantInformation.terminalNumber_txtbx(driver).getAttribute("value").equals(terminalNumber), "Text is incorrect");
			Assert.assertTrue(VMerchantInformation.merchantLocationNumber_txtbx(driver).getAttribute("value").equals(merchantLocationNumber), "Text is incorrect");
			Assert.assertTrue(VMerchantInformation.agentNumber_txtbx(driver).getAttribute("value").equals(agentNumber), "Text is incorrect");
			Assert.assertTrue(VMerchantInformation.chainNumber_txtbx(driver).getAttribute("value").equals(chainNumber), "Text is incorrect");
			Assert.assertTrue(VMerchantInformation.merchantCategory_txtbx(driver).getAttribute("value").equals(merchantCategory), "Text is incorrect");
			Assert.assertTrue(VMerchantInformation.contactName_txtbx(driver).getAttribute("value").equals(contactName), "Text is incorrect");
			Assert.assertTrue(VMerchantInformation.email_txtbx(driver).getAttribute("value").equals(email), "Text is incorrect");
	
			// Log test
			test.log(LogStatus.INFO, "Credit Card", "Verify Merchant Information data");
			
		} else {
			
			// Log test
			test.log(LogStatus.INFO, "Credit Card", "Could not verify merchant information due to issue with mobile");
			
		} // end if/else
		
	} // end merchantInformation
	
} // end the Secure_Login class
