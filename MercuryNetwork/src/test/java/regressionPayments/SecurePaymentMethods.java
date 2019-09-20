package regressionPayments;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Secure.SAccount;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Payments - Secure Payment Methods</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class SecurePaymentMethods extends TestSetup {

	/** The user. */
	private final String user = "PaymentMethods1";

	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Go to Account</li>
	 * 	<li>Ensure all payment methods are deleted before starting all these tests</li>
	 * 	<li>Go to Account</li>
	 * 	<li>Add credit card</li>
	 * 	<li>Go to Account</li>
	 * 	<li>Verify card holder name</li>
	 * 	<li>Verify Account information</li>
	 * 	<li>Log test</li>
* </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Payments"}, alwaysRun=true)
	public void addCreditCard() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Log in to Secure
		secure.login(driver, user, StoredVariables.getpassword().get());
		
		// Go to Account
		secure.goToAccount(driver);
		
		// Ensure all payment methods are deleted before starting all these tests
		secure.deleteAllPaymentMethods(driver);

		// Go to Account
		secure.goToAccount(driver);
		
		// Add credit card
		String creditCardNumber = "4111111111111111";
		secure.addTestCreditCard(driver, creditCardNumber, false);
		
		// Go to Account
		secure.goToAccount(driver);
		
		// Verify card holder name
		Assert.assertTrue(SAccount.paymentMethods_data(driver, "1", "3").getText().contains("Auto"), "Cardholder name is incorrect");
		Assert.assertTrue(SAccount.paymentMethods_data(driver, "1", "3").getText().contains("TestUser"), "Cardholder name is incorrect");
		
		// Verify Account information
		Assert.assertTrue(SAccount.paymentMethods_data(driver, "1", "2").getText().contains("Active for fees (x1111)"), "Account information is incorrect");
		
		// Log test
		test.log(LogStatus.INFO, "Payment Methods", "Verified you can add a credit card");
		
	} // end addCreditCard
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Go to Account</li>
	 * 	<li>Delete all payment methods</li>
	 * 	<li>Go to Account</li>
	 * 	<li>Verify there are no payment methods</li>
	 * 	<li>Log test</li>
* </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Payments"}, dependsOnMethods = {"addCreditCard"})
	public void deleteCreditCard() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Log in to Secure
		secure.login(driver, user, StoredVariables.getpassword().get());
		
		// Go to Account
		secure.goToAccount(driver);
		
		// Delete all payment methods
		secure.deleteAllPaymentMethods(driver);

		// Go to Account
		secure.goToAccount(driver);
		
		// Verify there are no payment methods
		int numOfPaymentMethods = perform.getNumOfRowsInTableID(driver, SAccount.paymentMethods_table())-1;
		Assert.assertTrue(numOfPaymentMethods==0, "There should be no payment methods displayed");
		
		// Log test
		test.log(LogStatus.INFO, "Payment Methods", "Verified you can delete a credit card");
		
	} // end deleteCreditCard
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Go to Account</li>
	 * 	<li>Click Manage</li>
	 * 	<li>Get the number of payment methods</li>
	 * 	<li>Click Add a checking account</li>
	 * 	<li>Switch iFrame</li>
	 * 	<li>Enter First Name</li>
	 * 	<li>Enter Bank routing number</li>
	 * 	<li>Click out of the routing number field</li>
	 * 	<li>Verify INVALID ROUTING NUMBER text displays</li>
	 * 	<li>Enter Account number</li>
	 * 	<li>Enter Confirm account number</li>
	 * 	<li>Select Personal radio button</li>
	 * 	<li>Click Save</li>
	 * 	<li>Verify valid routing number text</li>
	 * 	<li>Log test</li>
* </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Payments"}, dependsOnMethods = {"deleteCreditCard"}, alwaysRun=true)
	public void verifyCanNotAddInvalidRoutingNumberOnACHAccount() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Log in to Secure
		secure.login(driver, user, StoredVariables.getpassword().get());
		
		// Go to Account
		secure.goToAccount(driver);
		
		// Click Manage
		perform.click(driver,SAccount.manage_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SAccount.okManagePaymentMethods_btn(), "id");
		
		// Get the number of payment methods
		int numOfPaymentMethods = perform.getNumOfRowsInTableID(driver, SAccount.managePaymentMethods_table())-1;
		System.out.println("Number of payment methods = " + (numOfPaymentMethods));
		Assert.assertTrue(numOfPaymentMethods < 2, "No more payment methods can be added becasue there are already 2 payment methods");
		
		// Click Add a checking account
		perform.click(driver,SAccount.addCheckingAccount_btn(driver));
		
		// Switch iFrame
		driver.switchTo().defaultContent();
		perform.waitForiFrameSrcAndSwitchToIt(driver, "/manage.aspx", By.id(SAccount.nameOnAccount_txtbx()));	
		
		// Wait for Name on account textbox
		perform.waitForElementToBeClickable(driver, SAccount.nameOnAccount_txtbx(), "id");
		
		// Enter First Name
		String nameOnAccount = "Auto" + perform.randomNumbers(driver, 3) + " ACHUser";
		perform.type(driver, SAccount.nameOnAccount_txtbx(driver), nameOnAccount);
		
		// Enter Bank routing number
		perform.type(driver, SAccount.routingNumber_txtbx(driver), "123456789");
		
		// Click out of the routing number field
		perform.click(driver,SAccount.accountNumber_txtbx(driver));
		
		// Wait for invalid text to update
		perform.waitForText(driver, SAccount.routingNumberValidation_txt(driver), "INVALID ROUTING NUMBER");
		
		// Verify INVALID ROUTING NUMBER text displays
		Assert.assertTrue(SAccount.routingNumberValidation_txt(driver).getText().contains("INVALID ROUTING NUMBER"), "The Invalid Routing Number text is incorrect");
		
		// Enter Account number
		perform.type(driver, SAccount.accountNumber_txtbx(driver), perform.randomNumbers(driver, 6));
		
		// Enter Confirm account number
		perform.type(driver, SAccount.confirmAccountNumber_txtbx(driver), perform.randomNumbers(driver, 6));
		
		// Select Personal radio button
		perform.click(driver,SAccount.personal_radiobtn(driver));
		
		// Click Save
		perform.click(driver,SAccount.saveACH_btn(driver));
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SAccount.ok_btn(), "id");
		
		// Verify valid routing number text
		Assert.assertTrue(SAccount.message_txt(driver).getText().contains("The following is required."), "The message text is incorrect");
		
		// Log test
		test.log(LogStatus.INFO, "Payment Methods", "Verified you can not add an invalid routing number on an ACH account");
		
	} // end verifyCanNotAddInvalidRoutingNumberOnACHAccount
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Go to Account</li>
	 * 	<li>Add ACH Account</li>
	 * 	<li>Go to Account</li>
	 * 	<li>Verify Name on account</li>
	 * 	<li>Verify Account information</li>
	 * 	<li>Log test</li>
* </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Payments"}, dependsOnMethods = {"verifyCanNotAddInvalidRoutingNumberOnACHAccount"}, alwaysRun=true)
	public void addACHAccount() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Log in to Secure
		secure.login(driver, user, StoredVariables.getpassword().get());
		
		// Go to Account
		secure.goToAccount(driver);
		
		// Add ACH Account
		String accountNumber = perform.randomNumbers(driver, 15);
		secure.addTestACHAccount(driver, accountNumber);
		
		// Go to Account
		secure.goToAccount(driver);
		
		// Verify Name on account
		Assert.assertTrue(SAccount.paymentMethods_data(driver, "1", "3").getText().contains("Auto"), "Name on account is incorrect");
		Assert.assertTrue(SAccount.paymentMethods_data(driver, "1", "3").getText().contains("ACHUser"), "Name on account is incorrect");
		
		// Verify Account information
		String last4OfAccountNumber = accountNumber.substring(11,15);
		System.out.println("last4 = " + last4OfAccountNumber);
		Assert.assertTrue(SAccount.paymentMethods_data(driver, "1", "2").getText().contains("account ending in " + last4OfAccountNumber), "Account information is incorrect");
		
		// Log test
		test.log(LogStatus.INFO, "Payment Methods", "Verified you can add an ACH account");
		
	} // end addACHAccount
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Go to Account</li>
	 * 	<li>Delete all payment methods</li>
	 * 	<li>Go to Account</li>
	 * 	<li>Verify there are no payment methods</li>
	 * 	<li>Log test</li>
* </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Payments"}, dependsOnMethods = {"addACHAccount"})
	public void deleteACHAccount() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Log in to Secure
		secure.login(driver, user, StoredVariables.getpassword().get());
		
		// Go to Account
		secure.goToAccount(driver);
		
		// Delete all payment methods
		secure.deleteAllPaymentMethods(driver);

		// Go to Account
		secure.goToAccount(driver);
		
		// Verify there are no payment methods
		int numOfPaymentMethods = perform.getNumOfRowsInTableID(driver, SAccount.paymentMethods_table())-1;
		Assert.assertTrue(numOfPaymentMethods==0, "There should be no payment methods displayed");
		
		// Log test
		test.log(LogStatus.INFO, "Payment Methods", "Verified you can delete an ACH account");
		
	} // end deleteACHAccount
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Go to Account</li>
	 * 	<li>Ensure all payment methods are deleted before starting all these tests</li>
	 * 	<li>Go to Account</li>
	 * 	<li>Add credit card</li>
	 * 	<li>Go to Account</li>
	 * 	<li>Add credit card</li>
	 * 	<li>Go to Account</li>
	 * 	<li>Click Manage</li>
	 * 	<li>Get the number of payment methods</li>
	 * 	<li>Click Add a credit card</li>
	 * 	<li>Verify maximum reached dialog text</li>
	 * 	<li>Click OK</li>
	 * 	<li>Click Add checking account</li>
	 * 	<li>Verify maximum reached dialog text</li>
	 * 	<li>Click OK</li>
	 * 	<li>Click OK</li>
	 * 	<li>Log test</li>
* </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Payments"}, dependsOnMethods = {"deleteACHAccount"}, alwaysRun=true)
	public void cannotAddMoreThan2PaymentMethods() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Log in to Secure
		secure.login(driver, user, StoredVariables.getpassword().get());
		
		// Go to Account
		secure.goToAccount(driver);
		
		// Ensure all payment methods are deleted before starting all these tests
		secure.deleteAllPaymentMethods(driver);

		// Go to Account
		secure.goToAccount(driver);
		
		// Add credit card
		String creditCardNumber = "4111111111111111";
		secure.addTestCreditCard(driver, creditCardNumber, false);
		
		// Go to Account
		secure.goToAccount(driver);
		
		// Add credit card
		creditCardNumber = "6011111111111117";
		secure.addTestCreditCard(driver, creditCardNumber, false);
		
		// Go to Account
		secure.goToAccount(driver);
		
		// Click Manage
		perform.click(driver,SAccount.manage_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SAccount.okManagePaymentMethods_btn(), "id");
		
		// Get the number of payment methods
		int numOfPaymentMethods = perform.getNumOfRowsInTableID(driver, SAccount.managePaymentMethods_table())-1;
		System.out.println("Number of payment methods = " + (numOfPaymentMethods));
		Assert.assertTrue(numOfPaymentMethods == 2, "No more payment methods can be added becasue there are already 2 payment methods");
		
		// Click Add a credit card
		perform.click(driver,SAccount.addCreditCard_btn(driver));
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SAccount.ok_btn(), "id");
		
		// Verify maximum reached dialog text
		Assert.assertTrue(SAccount.dialog_txt(driver).getText().contains("Maximum reached"), "The Maximum reached dialog text is incorrect");
		Assert.assertTrue(SAccount.dialog_txt(driver).getText().contains("You may only store a maximum of two (2) payment methods."), "The Maximum reached dialog text is incorrect");
		
		// Click OK
		perform.click(driver,SAccount.ok_btn(driver));
		
		// Wait for Manage payment methods ok button
		perform.waitForElementToBeClickable(driver, SAccount.okManagePaymentMethods_btn(), "id");
		
		// Click Add checking account
		perform.click(driver,SAccount.addCheckingAccount_btn(driver));
		
		// Verify maximum reached dialog text
		Assert.assertTrue(SAccount.dialog_txt(driver).getText().contains("Maximum reached"), "The Maximum reached dialog text is incorrect");
		Assert.assertTrue(SAccount.dialog_txt(driver).getText().contains("You may only store a maximum of two (2) payment methods."), "The Maximum reached dialog text is incorrect");
		
		// Click OK
		perform.click(driver,SAccount.ok_btn(driver));
		
		// Wait for Manage payment methods ok button
		perform.waitForElementToBeClickable(driver, SAccount.okManagePaymentMethods_btn(), "id");
		
		// Click OK
		perform.click(driver,SAccount.okManagePaymentMethods_btn(driver));
		
		// Log test
		test.log(LogStatus.INFO, "Payment Methods", "Verified you cannot add more than 2 payment methods");
		
	} // end cannotAddMoreThan2PaymentMethods
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Go to Account</li>
	 * 	<li>Delete the Backup payment method</li>
	 * 	<li>Go to Account</li>
	 * 	<li>Add credit card</li>
	 * 	<li>Go to Account</li>
	 * 	<li>Verify the new card is now the Primary</li>
	 * 	<li>Verify Account information</li>
	 * 	<li>Verify second payment method is listed as the backup</li>
	 * 	<li>Log test</li>
* </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Payments"}, dependsOnMethods = {"cannotAddMoreThan2PaymentMethods"}, alwaysRun=true)
	public void ensurePrimary() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Log in to Secure
		secure.login(driver, user, StoredVariables.getpassword().get());
		
		// Go to Account
		secure.goToAccount(driver);
		
		// Delete the Backup payment method
		secure.deleteIndividualPaymentMethod(driver, "2");

		// Go to Account
		secure.goToAccount(driver);
		
		// Add credit card
		String creditCardNumber = "5555555555554444";
		secure.addTestCreditCard(driver, creditCardNumber, true);
		
		// Go to Account
		secure.goToAccount(driver);
		
		// Verify the new card is now the Primary
		// Verify Account information
		Assert.assertTrue(SAccount.paymentMethods_data(driver, "1", "2").getText().contains("Active for fees (x4444)"), "This account should be the primary");
		Assert.assertTrue(SAccount.paymentMethods_data(driver, "1", "5").getText().equals("Primary"), "This account should be the primary");
		
		// Verify second payment method is listed as the backup
		Assert.assertTrue(SAccount.paymentMethods_data(driver, "2", "5").getText().equals("Backup"), "This account should be the backup");
		
		// Log test
		test.log(LogStatus.INFO, "Payment Methods", "Verified you can add a Primary payment method");
		
	} // end ensurePrimary
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Go to Account</li>
	 * 	<li>Delete the Backup payment method</li>
	 * 	<li>Go to Account</li>
	 * 	<li>Add credit card</li>
	 * 	<li>Go to Account</li>
	 * 	<li>Verify the new card is now the Primary</li>
	 * 	<li>Verify Account information</li>
	 * 	<li>Verify second payment method is listed as the backup</li>
	 * 	<li>Log test</li>
* </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Payments"}, dependsOnMethods = {"ensurePrimary"})
	public void ensureBackup() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Log in to Secure
		secure.login(driver, user, StoredVariables.getpassword().get());
		
		// Go to Account
		secure.goToAccount(driver);
		
		// Delete the Backup payment method
		secure.deleteIndividualPaymentMethod(driver, "2");

		// Go to Account
		secure.goToAccount(driver);
		
		// Add credit card
		String creditCardNumber = "378282246310005";
		secure.addTestCreditCard(driver, creditCardNumber, false);
		
		// Go to Account
		secure.goToAccount(driver);
		
		// Verify the new card is now the Primary
		// Verify Account information
		Assert.assertTrue(SAccount.paymentMethods_data(driver, "2", "2").getText().contains("Active for fees (x0005)"), "This account should be the backup");
		Assert.assertTrue(SAccount.paymentMethods_data(driver, "2", "5").getText().equals("Backup"), "This account should be the backup");
		
		// Verify second payment method is listed as the backup
		Assert.assertTrue(SAccount.paymentMethods_data(driver, "1", "5").getText().equals("Primary"), "This account should be the primary");
		
		// Log test
		test.log(LogStatus.INFO, "Payment Methods", "Verified you can add a Primary payment method");
		
	} // end ensureBackup
	
} // end the SecurePaymentMethods class
