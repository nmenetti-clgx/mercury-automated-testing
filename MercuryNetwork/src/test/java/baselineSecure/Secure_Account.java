package baselineSecure;

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
 * <h1>Baseline Secure - Account</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */
@Listeners(utils.Listener.class)
public class Secure_Account extends TestSetup {
	
	/** The user. */
	private static String user = "Baseline3";
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Go to Account</li>
	 * 	<li>Verify Billing type is Daily</li>
	 * 	<li>Delete all payment methods</li>
	 * 	<li>Go to Account</li>
	 * 	<li>Add credit card</li>
	 * 	<li>Go to Account</li>
	 * 	<li>Verify card holder name</li>
	 * 	<li>Verify Account information</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Account", "Secure - Delete Payment Method", "Secure - Add Credit Card"}, alwaysRun=true)
	public void addCreditCard() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Log in to Secure
		secure.login(driver, user, StoredVariables.getpassword().get());
		
		// Go to Account
		secure.goToAccount(driver);
		
		// Verify Billing type is Daily
		String billingType = SAccount.billingType_txt(driver).getText();
		Assert.assertTrue(billingType.equals("Daily"), "The billing account should be Daily but it is = " + billingType);
		
		// Delete all payment methods
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
		Assert.assertTrue(SAccount.paymentMethods_data(driver, "1", "2").getText().contains("Active for fees (x1111)"), "Account information is incorrect. Screen: " + SAccount.paymentMethods_data(driver, "1", "2").getText());
		
		// Log test
		test.log(LogStatus.INFO, "Account", "Added a new credit card");
		
	} // end addCreditCard
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Go to Account</li>
	 * 	<li>Verify Billing type is Monthly</li>
	 * 	<li>Delete all payment methods</li>
	 * 	<li>Go to Account</li>
	 * 	<li>Add credit card</li>
	 * 	<li>Go to Account</li>
	 * 	<li>Verify card holder name</li>
	 * 	<li>Verify Account information</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Account", "Secure - Delete Payment Method", "Secure - Add Credit Card"}, alwaysRun=true)
	public void addCreditCardMonthlyBilling() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Log in to Secure
		secure.login(driver, "Baseline2", StoredVariables.getpassword().get());
		
		// Go to Account
		secure.goToAccount(driver);
		
		// Verify Billing type is Monthly
		String billingType = SAccount.billingType_txt(driver).getText();
		Assert.assertTrue(billingType.equals("Monthly"), "The billing account should be Monthly but it is = " + billingType);
		
		// Delete all payment methods
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
		test.log(LogStatus.INFO, "Account", "Added a new credit card");
		
	} // end addCreditCard
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Go to Account</li>
	 * 	<li>Click on the Unpaid Invoices tab</li>
	 * 	<li>Verify table text</li>
	 * 	<li>Click on the Paid Invoices tab</li>
	 * 	<li>Verify table text</li>
	 * 	<li>Click on the Yearly Invoice Totals tab</li>
	 * 	<li>Verify table text</li>
	 * 	<li>Click on the Pending Transactions tab</li>
	 * 	<li>Verify table text</li>
	 * 	<li>Click Mercury Network transaction fees link</li>
	 * 	<li>Switch to new window</li>
	 * 	<li>Verify url</li>
	 * 	<li>Assert.assertTrue(driver.getCurrentUrl().equals("https:help.mercuryvmp.com/docs/2015.htm"), "The page wasn't opened correctly");</li>
	 * 	<li>Close the new window</li>
	 * 	<li>Switch back to the original window</li>
	 * 	<li>Click How to add or update card information link</li>
	 * 	<li>Switch to new window</li>
	 * 	<li>Verify url</li>
	 * 	<li>Assert.assertTrue(driver.getCurrentUrl().equals("https:help.mercuryvmp.com/docs/2200.htm"), "The page wasn't opened correctly");</li>
	 * 	<li>Close the new window</li>
	 * 	<li>Switch back to the original window</li>
	 * 	<li>Click Cancelled orders &amp; refunds link</li>
	 * 	<li>Switch to new window</li>
	 * 	<li>Verify url</li>
	 * 	<li>Assert.assertTrue(driver.getCurrentUrl().equals("https:help.mercuryvmp.com/docs/2221.htm"), "The page wasn't opened correctly");</li>
	 * 	<li>Close the new window</li>
	 * 	<li>Switch back to the original window</li>
	 * 	<li>Click Mercury Network User's guide link</li>
	 * 	<li>Switch to new window</li>
	 * 	<li>Verify url</li>
	 * 	<li>Assert.assertTrue(driver.getCurrentUrl().equals("https:help.mercuryvmp.com/lender/Mercury/"), "The page wasn't opened correctly");</li>
	 * 	<li>Close the new window</li>
	 * 	<li>Switch back to the original window</li>
	 * 	<li>Click Mercury Network Power Tips library link</li>
	 * 	<li>Switch to new window</li>
	 * 	<li>Verify url</li>
	 * 	<li>Assert.assertTrue(driver.getCurrentUrl().equals("http:www.mercuryvmp.com/powertips"), "The page wasn't opened correctly");</li>
	 * 	<li>Close the new window</li>
	 * 	<li>Switch back to the original window</li>
	 * 	<li>Click Understanding UCDP submission errors link</li>
	 * 	<li>Switch to new window</li>
	 * 	<li>Verify url</li>
	 * 	<li>Assert.assertTrue(driver.getCurrentUrl().equals("https:help.mercuryvmp.com/docs/9310.htm"), "The page wasn't opened correctly");</li>
	 * 	<li>Close the new window</li>
	 * 	<li>Switch back to the original window</li>
	 * 	<li>Click Mercury Network update information link</li>
	 * 	<li>Switch to new window</li>
	 * 	<li>Verify url</li>
	 * 	<li>String url1 = "http:www.mercuryvmp.com/featureupdates";</li>
	 * 	<li>String url2 = "http:www.mercuryvmp.com/mercurynetworkupdates";</li>
	 * 	<li>Close the new window</li>
	 * 	<li>Switch back to the original window</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Account"}, alwaysRun=true)
	public void paymentHistoryTabsAndLinks() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Log in to Secure
		secure.login(driver, user, StoredVariables.getpassword().get());
		
		// Go to Account
		secure.goToAccount(driver);
		
		// Wait for Unpaid Invoices
		perform.waitForElementToBeClickable(driver, SAccount.unpaidInvoices_btn(driver));
		
		Thread.sleep(1500);
		
		// Click on the Unpaid Invoices tab
		perform.click(driver, SAccount.unpaidInvoices_btn(driver));
		
		// Wait for table
		perform.waitForElementToBeClickable(driver, SAccount.unpaidInvoicesTable_txt(driver));
		
		// Verify table text
		String tableText = "Invoices that have not been paid.";
		Assert.assertTrue(SAccount.unpaidInvoicesTable_txt(driver).getText().contains(tableText), "The Unpaid Invoices table is not displayed properly");
		
		// Wait for Paid Invoices
		perform.waitForElementToBeClickable(driver, SAccount.paidInvoices_btn(driver));
		
		// Click on the Paid Invoices tab
		perform.click(driver, SAccount.paidInvoices_btn(driver));
		
		// Wait for table
		perform.waitForElementToBeClickable(driver, SAccount.paidInvoicesTable_txt(driver));
		
		// Verify table text
		tableText = "Paid invoices for the month of:";
		Assert.assertTrue(SAccount.paidInvoicesTable_txt(driver).getText().contains(tableText), "The Paid Invoices table is not displayed properly");
		
		// Wait for Yearly Invoice
		perform.waitForElementToBeClickable(driver, SAccount.yearlyInvoiceTotals_btn(driver));
		
		// Click on the Yearly Invoice Totals tab
		perform.click(driver, SAccount.yearlyInvoiceTotals_btn(driver));
		
		// Wait for table
		perform.waitForElementToBeClickable(driver, SAccount.yearlyInvoiceTotals_btn(driver));
		
		// Verify table text
		tableText = "Paid invoices for the year of:";
		System.out.println("Text = " + SAccount.yearInvoiceTotalsTable_txt(driver).getText());
		Assert.assertTrue(SAccount.yearInvoiceTotalsTable_txt(driver).getText().contains(tableText), "The Year Invoice Totals table is not displayed properly");
		
		// Wait for Yearly Invoice
		perform.waitForElementToBeClickable(driver, SAccount.pendingTransactions_btn(driver));
		
		// Click on the Pending Transactions tab
		perform.click(driver, SAccount.pendingTransactions_btn(driver));
		
		// Wait for table
		perform.waitForElementToBeClickable(driver, SAccount.pendingTransactions_btn(driver));
		
		// Verify table text
		tableText = "Transactions that have not been processed.";
		Assert.assertTrue(SAccount.pendingTransactionsTable_txt(driver).getText().contains(tableText), "The Pending Transactions table is not displayed properly");
		
		// Click Mercury Network transaction fees link
		perform.click(driver, driver.findElement(By.linkText("Mercury Network transaction fees")));
		
		// Switch to new window
		perform.switchToXSiteWindowByTitle(driver, "2015 - Mercury Network");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().equals("https://help.mercuryvmp.com/docs/2015.htm"), "The page wasn't opened correctly");
		
		// Close the new window
		driver.close();
		
		// Switch back to the original window
		driver.switchTo().window(StoredVariables.getwinHandleBefore().get());
		
		// Click How to add or update card information link
		perform.click(driver, driver.findElement(By.linkText("How to add or update card information")));
		
		// Switch to new window
		perform.switchToXSiteWindowByTitle(driver, "2200 - Adding or updating a Credit Card to your account.");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().equals("https://help.mercuryvmp.com/docs/2200.htm"), "The page wasn't opened correctly");
		
		// Close the new window
		driver.close();
		
		// Switch back to the original window
		driver.switchTo().window(StoredVariables.getwinHandleBefore().get());
		
		// Click Cancelled orders & refunds link
		perform.click(driver, driver.findElement(By.linkText("Cancelled orders & refunds")));
		
		// Switch to new window
		perform.switchToXSiteWindowByTitle(driver, "2221 - When you'll receive a refund if an order is canceled on Mercury Network");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().equals("https://help.mercuryvmp.com/docs/2221.htm"), "The page wasn't opened correctly");
		
		// Close the new window
		driver.close();
		
		// Switch back to the original window
		driver.switchTo().window(StoredVariables.getwinHandleBefore().get());
		
		// Click Mercury Network User's guide link
		perform.click(driver, driver.findElement(By.linkText("Mercury Network User's guide")));
		
		// Switch to new window
		perform.switchToXSiteWindowByTitle(driver, "Mercury Network User's Guide");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().equals("https://help.mercuryvmp.com/lender/Mercury/"), "The page wasn't opened correctly");
		
		// Close the new window
		driver.close();
		
		// Switch back to the original window
		driver.switchTo().window(StoredVariables.getwinHandleBefore().get());
		
		// Click Mercury Network Power Tips library link
		perform.click(driver, driver.findElement(By.linkText("Mercury Network Power Tips library")));
		
		// Switch to new window
		perform.switchToXSiteWindowByTitle(driver, "Power Tips");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().equals("https://www.mercuryvmp.com/powertips"), "The page wasn't opened correctly");
		
		// Close the new window
		driver.close();
		
		// Switch back to the original window
		driver.switchTo().window(StoredVariables.getwinHandleBefore().get());
		
		// Click Understanding UCDP submission errors link
		perform.click(driver, driver.findElement(By.linkText("Understanding UCDP submission errors")));
		
		// Switch to new window
		perform.switchToXSiteWindowByTitle(driver, "9310 - Understanding UCDP Duplicate Submission Errors");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().equals("https://help.mercuryvmp.com/docs/9310.htm"), "The page wasn't opened correctly");
		
		// Close the new window
		driver.close();
		
		// Switch back to the original window
		driver.switchTo().window(StoredVariables.getwinHandleBefore().get());
		
		// Click Mercury Network update information link
		perform.click(driver, driver.findElement(By.linkText("Mercury Network update information")));
		
		// Switch to new window
		perform.switchToXSiteWindowByTitle(driver, "Mercury Network Updates — Mercury Network");
		
		// Verify url
		String url1 = "https://www.mercuryvmp.com/featureupdates";
		String url2 = "https://www.mercuryvmp.com/mercurynetworkupdates";
		Assert.assertTrue(driver.getCurrentUrl().equals(url1) || driver.getCurrentUrl().equals(url2), "The page wasn't opened correctly");
		
		// Close the new window
		driver.close();
		
		// Switch back to the original window
		driver.switchTo().window(StoredVariables.getwinHandleBefore().get());
		
		// Log test
		test.log(LogStatus.INFO, "Account", "Verified Payment History tabs are working");
		
	} // end paymentHistoryTabsAndLinks
	
} // end the Secure_Account class
