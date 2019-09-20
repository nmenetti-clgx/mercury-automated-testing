package baselineVendors;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Vendors.VAccount;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Baseline Vendors - Account</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class Vendors_Account extends TestSetup {
	
	/** The user. */
	private final String user = "BaselineAppraiser1";
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Go to Account</li>
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
	@Test (retryAnalyzer = Retry.class, groups={"Vendors - Account", "Vendors - Credit Card", "Vendors - Delete Payment Method", "Vendors - Add Credit Card"}, alwaysRun=true)
	public void addCreditCard() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Log in to Vendors
		vendors.login(driver, user, StoredVariables.getpassword().get());
		
		// Go to Account
		vendors.goToAccount(driver);
		
		// Delete all payment methods
		vendors.deleteAllPaymentMethods(driver);
		
		// Go to Account
		vendors.goToAccount(driver);
		
		// Add credit card
		vendors.addTestCreditCard(driver, "4111111111111111", false);
		
		// Go to Account
		vendors.goToAccount(driver);
		
		// Verify card holder name
		Assert.assertTrue(VAccount.paymentMethods_data(driver, "1", "3").getText().contains("Auto"), "Cardholder name is incorrect");
		Assert.assertTrue(VAccount.paymentMethods_data(driver, "1", "3").getText().contains("TestUser"), "Cardholder name is incorrect");
		
		// Verify Account information
		Assert.assertTrue(VAccount.paymentMethods_data(driver, "1", "2").getText().contains("Active for fees (x1111)"), "Account information is incorrect");
		
		// Log test
		test.log(LogStatus.INFO, "Account", "Added a new credit card");
		
	} // end addCreditCard
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Go to Account</li>
	 * 	<li>Click on the Unpaid Invoices tab</li>
	 * 	<li>Verify table text</li>
	 * 	<li>Click on the Paid Invoices tab</li>
	 * 	<li>Verify table text</li>
	 * 	<li>Click on the Yearly Invoice Totals tab</li>
	 * 	<li>Verify table text</li>
	 * 	<li>Click on the Pending Transactions tab</li>
	 * 	<li>Verify table text</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Vendors - Account"}, alwaysRun=true)
	public void paymentHistoryTabs() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Log in to Vendors
		vendors.login(driver, user, StoredVariables.getpassword().get());
		
		// Go to Account
		vendors.goToAccount(driver);
		
		// Wait for Unpaid Invoices
		perform.waitForElementToBeClickable(driver, VAccount.unpaidInvoices_btn(), "id");
		
		// Click on the Unpaid Invoices tab
		perform.click(driver, VAccount.unpaidInvoices_btn(driver));
		
		// Wait for table
		perform.waitForElementToBeClickable(driver, VAccount.unpaidInvoicesTable_txt(), "id");
		
		// Verify table text
		String tableText = "Invoices that have not been paid.";
		Assert.assertTrue(VAccount.unpaidInvoicesTable_txt(driver).getText().contains(tableText), "The Unpaid Invoices table is not displayed properly");
		
		// Wait for Paid Invoices
		perform.waitForElementToBeClickable(driver, VAccount.paidInvoices_btn(), "id");
		
		// Click on the Paid Invoices tab
		perform.click(driver, VAccount.paidInvoices_btn(driver));
		
		// Wait for table
		perform.waitForElementToBeClickable(driver, VAccount.paidInvoicesTable_txt(), "id");
		
		// Verify table text
		tableText = "Paid invoices for the month of:";
		Assert.assertTrue(VAccount.paidInvoicesTable_txt(driver).getText().contains(tableText), "The Paid Invoices table is not displayed properly");
		
		// Wait for Yearly Invoice
		perform.waitForElementToBeClickable(driver, VAccount.yearlyInvoiceTotals_btn(), "id");
		
		// Click on the Yearly Invoice Totals tab
		perform.click(driver,VAccount.yearlyInvoiceTotals_btn(driver));
		
		// Wait for table
		perform.waitForElementToBeClickable(driver, VAccount.yearlyInvoiceTotals_btn(), "id");
		
		// Verify table text
		tableText = "Paid invoices for the year of:";
		Assert.assertTrue(VAccount.yearInvoiceTotalsTable_txt(driver).getText().contains(tableText), "The Year Invoice Totals table is not displayed properly");
		
		// Wait for Yearly Invoice
		perform.waitForElementToBeClickable(driver, VAccount.pendingTransactions_btn(), "id");
		
		// Click on the Pending Transactions tab
		perform.click(driver,VAccount.pendingTransactions_btn(driver));
		
		// Wait for table
		perform.waitForElementToBeClickable(driver, VAccount.pendingTransactions_btn(), "id");
		
		// Verify table text
		tableText = "Transactions that have not been processed.";
		Assert.assertTrue(VAccount.pendingTransactionsTable_txt(driver).getText().contains(tableText), "The Pending Transactions table is not displayed properly");
		
		// Log test
		test.log(LogStatus.INFO, "Account", "Verified Payment History tabs are working");
		
	} // end paymentHistoryTabs
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Go to Account</li>
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
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Vendors - Account", "Vendors - Payment Support"}, alwaysRun=true)
	public void paymentSupport() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Log in to Vendors
		vendors.login(driver, user, StoredVariables.getpassword().get());
		
		// Go to Account
		vendors.goToAccount(driver);
		
		// Click Mercury Network transaction fees link
		perform.click(driver,driver.findElement(By.linkText("Mercury Network transaction fees")));
		
		// Switch to new window
		perform.switchToXSiteWindowByTitle(driver, "2015 - Mercury Network");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().equals("https://help.mercuryvmp.com/docs/2015.htm"), "The page wasn't opened correctly");
		
		// Close the new window
		driver.close();
		
		// Switch back to the original window
		driver.switchTo().window(StoredVariables.getwinHandleBefore().get());
		
		// Click How to add or update card information link
		perform.click(driver,driver.findElement(By.linkText("How to add or update card information")));
		
		// Switch to new window
		perform.switchToXSiteWindowByTitle(driver, "2200 - Adding or updating a Credit Card to your account.");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().equals("https://help.mercuryvmp.com/docs/2200.htm"), "The page wasn't opened correctly");
		
		// Close the new window
		driver.close();
		
		// Switch back to the original window
		driver.switchTo().window(StoredVariables.getwinHandleBefore().get());
		
		// Click Cancelled orders & refunds link
		perform.click(driver,driver.findElement(By.linkText("Cancelled orders & refunds")));
		
		// Switch to new window
		perform.switchToXSiteWindowByTitle(driver, "2221 - When you'll receive a refund if an order is canceled on Mercury Network");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().equals("https://help.mercuryvmp.com/docs/2221.htm"), "The page wasn't opened correctly");
		
		// Close the new window
		driver.close();
		
		// Switch back to the original window
		driver.switchTo().window(StoredVariables.getwinHandleBefore().get());
		
		// Log test
		test.log(LogStatus.INFO, "Account", "Verified Payment Support links are working");
		
	} // end paymentSupport
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Go to Account</li>
	 * 	<li>Click Mercury Network User's guide link</li>
	 * 	<li>Switch to new window</li>
	 * 	<li>Verify url</li>
	 * 	<li>Assert.assertTrue(driver.getCurrentUrl().equals("https:help.mercuryvmp.com/vendor/Mercury/"), "The page wasn't opened correctly");</li>
	 * 	<li>Close the new window</li>
	 * 	<li>Switch back to the original window</li>
	 * 	<li>Click How to update your Mercury Network profile link</li>
	 * 	<li>Switch to new window</li>
	 * 	<li>Verify url</li>
	 * 	<li>Assert.assertTrue(driver.getCurrentUrl().equals("https:help.mercuryvmp.com/docs/2016.htm"), "The page wasn't opened correctly");</li>
	 * 	<li>Close the new window</li>
	 * 	<li>Switch back to the original window</li>
	 * 	<li>Click Mercury Network update information link</li>
	 * 	<li>Switch to new window</li>
	 * 	<li>Verify url</li>
	 * 	<li>String url1 = "http:www.mercuryvmp.com/featureupdates";</li>
	 * 	<li>String url2 = "http:www.mercuryvmp.com/mercurynetworkupdates";</li>
	 * 	<li>Close the new window</li>
	 * 	<li>Switch back to the original window</li>
	 * 	<li>Click Mercury Network FAQ link</li>
	 * 	<li>Switch to new window</li>
	 * 	<li>Verify url</li>
	 * 	<li>Assert.assertTrue(driver.getCurrentUrl().equals("http:www.mercuryvmp.com/faq"), "The page wasn't opened correctly");</li>
	 * 	<li>Close the new window</li>
	 * 	<li>Switch back to the original window</li>
	 * 	<li>Click Download Mercury Mobile for iOS link</li>
	 * 	<li>Switch to new window</li>
	 * 	<li>Verify url</li>
	 * 	<li>Close the new window</li>
	 * 	<li>Switch back to the original window</li>
	 * 	<li>Click Download Mercury Mobile for Android link</li>
	 * 	<li>Switch to new window</li>
	 * 	<li>Verify url</li>
	 * 	<li>Assert.assertTrue(driver.getCurrentUrl().equals("https:play.google.com/store/apps/details?id=com.alamode.mercurymobile"), "The page wasn't opened correctly");</li>
	 * 	<li>Close the new window</li>
	 * 	<li>Switch back to the original window</li>
	 * 	<li>Click Mercury Mobile for iOS User's Guide link</li>
	 * 	<li>Switch to new window</li>
	 * 	<li>Verify url</li>
	 * 	<li>Assert.assertTrue(driver.getCurrentUrl().equals("https:help.mercuryvmp.com/vendor/MercuryMobileiOS/"), "The page wasn't opened correctly");</li>
	 * 	<li>Close the new window</li>
	 * 	<li>Switch back to the original window</li>
	 * 	<li>Click Mercury Mobile for Android User's Guide link</li>
	 * 	<li>Switch to new window</li>
	 * 	<li>Verify url</li>
	 * 	<li>Assert.assertTrue(driver.getCurrentUrl().equals("https:help.mercuryvmp.com/vendor/MercuryMobileAndroid/"), "The page wasn't opened correctly");</li>
	 * 	<li>Close the new window</li>
	 * 	<li>Switch back to the original window</li>
	 * 	<li>Click Mercury Mobile update info link</li>
	 * 	<li>Switch to new window</li>
	 * 	<li>Verify url</li>
	 * 	<li>Assert.assertTrue(driver.getCurrentUrl().equals("http:www.mercuryvmp.com/mercury-mobile-updates/"), "The page wasn't opened correctly");</li>
	 * 	<li>Close the new window</li>
	 * 	<li>Switch back to the original window</li>
	 * 	<li>Click Learn more about Mercury Mobile link</li>
	 * 	<li>Switch to new window</li>
	 * 	<li>Verify url</li>
	 * 	<li>Assert.assertTrue(driver.getCurrentUrl().equals("http:www.mercuryvmp.com/mercurymobile"), "The page wasn't opened correctly");</li>
	 * 	<li>Close the new window</li>
	 * 	<li>Switch back to the original window</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Vendors - Account", "Vendors - Support"}, alwaysRun=true)
	public void support() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Log in to Vendors
		vendors.login(driver, user, StoredVariables.getpassword().get());
		
		// Go to Account
		vendors.goToAccount(driver);
		
		// Get window handle
		String winHandle = driver.getWindowHandle();
		
		// Click Mercury Network User's guide link
		perform.click(driver,driver.findElement(By.linkText("Mercury Network User's guide")));
		
		// Switch to new window
		perform.switchToXSiteWindowByTitle(driver, "Mercury Network Vendors User's Guide");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().equals("https://help.mercuryvmp.com/vendor/Mercury/"), "The page wasn't opened correctly");
		
		// Close the new window
		driver.close();
		
		// Switch back to the original window
		driver.switchTo().window(StoredVariables.getwinHandleBefore().get());
		
		// Click How to update your Mercury Network profile link
		perform.click(driver,driver.findElement(By.linkText("How to update your Mercury Network profile")));
		
		// Switch to new window
		perform.switchToXSiteWindowByTitle(driver, "2016 - Update Your Mercury Network Profile");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().equals("https://help.mercuryvmp.com/docs/2016.htm"), "The page wasn't opened correctly");
		
		// Close the new window
		driver.close();
		
		// Switch back to the original window
		driver.switchTo().window(StoredVariables.getwinHandleBefore().get());
		
		// Click Mercury Network update information link
		perform.click(driver,driver.findElement(By.linkText("Mercury Network update information")));
		
		// Switch to new window
		perform.switchToXSiteWindowByTitle(driver, "Mercury Network Updates — Mercury Network");
		
		// Verify url
		String url1 = "http://www.mercuryvmp.com/featureupdates";
		String url2 = "https://www.mercuryvmp.com/mercurynetworkupdates";
		boolean url = false;
		if (driver.getCurrentUrl().equals(url1) || driver.getCurrentUrl().equals(url2)) {
			url = true;
		} // end if
		Assert.assertTrue(url==true, "The URL is incorrect");
		
		// Close the new window
		driver.close();
		
		// Switch back to the original window
		driver.switchTo().window(StoredVariables.getwinHandleBefore().get());
		
		// Click Mercury Network FAQ link
		perform.click(driver,driver.findElement(By.linkText("Mercury Network FAQ")));
		
		// Switch to new window
		perform.switchToXSiteWindowByTitle(driver, "FAQ");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().equals("https://www.mercuryvmp.com/faq"), "The URL is incorrect");
		
		// Close the new window
		driver.close();
		
		// Switch back to the original window
		driver.switchTo().window(StoredVariables.getwinHandleBefore().get());
		
//		// Click Download Mercury Mobile for iOS link
//		perform.click(driver,driver.findElement(By.linkText("Download Mercury Mobile for iOS")));
//		
//		// Switch to new window
//		perform.switchToXSiteWindowByTitle(driver, "‎Mercury Mobile on the App Store");
//		
//		// Verify url
//		Assert.assertTrue(driver.getCurrentUrl().equals("https://itunes.apple.com/us/app/mercury-mobile/id740951383?ls=1&mt=8"), "The page wasn't opened correctly");
//		
//		// Close the new window
//		driver.close();
//		
//		// Switch back to the original window
//		driver.switchTo().window(StoredVariables.getwinHandleBefore().get());
//		
//		perform.sleep(driver, 1);
		
		// Click Download Mercury Mobile for Android link
		perform.click(driver,driver.findElement(By.linkText("Download Mercury Mobile for Android")));
		
		// Switch to new window
		perform.switchToXSiteWindowByTitle(driver, "Mercury Mobile for Android");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().equals("https://play.google.com/store/apps/details?id=com.alamode.mercurymobile"), "The page wasn't opened correctly");
		
		// Close the new window
		driver.close();
		
		// Switch back to the original window
		driver.switchTo().window(StoredVariables.getwinHandleBefore().get());
		
		// Click Mercury Mobile for iOS User's Guide link
		perform.click(driver,driver.findElement(By.linkText("Mercury Mobile for iOS User's Guide")));
		
		// Switch to new window
		perform.switchToXSiteWindowByTitle(driver, "Mercury Mobile for iOS User's Guide");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().equals("https://help.mercuryvmp.com/vendor/MercuryMobileiOS/"), "The page wasn't opened correctly");
		
		// Close the new window
		driver.close();
		
		// Switch back to the original window
		driver.switchTo().window(StoredVariables.getwinHandleBefore().get());
		
		// Click Mercury Mobile for Android User's Guide link
		perform.click(driver,driver.findElement(By.linkText("Mercury Mobile for Android User's Guide")));
		
		perform.sleep(driver, 5);
		
		// Switch to new window
		perform.switchToNewWindow(driver, winHandle);
		
		// Verify url
		System.out.println("URL: " + driver.getCurrentUrl());
		if (!driver.getCurrentUrl().contains("MercuryMobileAndroid")) {
			// Switch to new window
			perform.switchToNewWindow(driver, winHandle);
			System.out.println("URL: " + driver.getCurrentUrl());
		} // end if
		Assert.assertTrue(driver.getCurrentUrl().equals("https://help.mercuryvmp.com/vendor/MercuryMobileAndroid/"), "The URL is incorrect");
		
		// Close the new window
		driver.close();
		
		// Switch back to the original window
		driver.switchTo().window(StoredVariables.getwinHandleBefore().get());
		
		// Click Mercury Mobile update info link
		perform.click(driver,driver.findElement(By.linkText("Mercury Mobile update info")));
		
		// Switch to new window
		perform.switchToXSiteWindowByTitle(driver, "Mercury Mobile Appraisal Management Updates");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().equals("https://www.mercuryvmp.com/mercury-mobile-updates/"), "The page wasn't opened correctly");
		
		// Close the new window
		driver.close();
		
		// Switch back to the original window
		driver.switchTo().window(StoredVariables.getwinHandleBefore().get());
		
		// Click Learn more about Mercury Mobile link
		perform.click(driver, driver.findElement(By.linkText("Learn more about Mercury Mobile")));
		
		// Switch to new window
		perform.switchToXSiteWindowByTitle(driver, "Appraisal Vendor Management Software Mobile");
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().equals("https://www.mercuryvmp.com/mercurymobile"), "The page wasn't opened correctly");
		
		// Close the new window
		driver.close();
		
		// Switch back to the original window
		driver.switchTo().window(StoredVariables.getwinHandleBefore().get());

		// Log test
		test.log(LogStatus.INFO, "Account", "Verified Support links are working");
		
	} // end support
	
} // end the Secure_Login class
