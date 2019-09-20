package regressionPayments;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjects.XSite.XChargeCard;
import pageObjects.XSite.XMakeAPayment;
import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

/**
 * <h1>Payments - Old Make A Payment Page</h1>
 * Verify the old Make A Payment page loads
 *
 * @author  Dustin Norman
 * @since   10-24-2018
 */

@Listeners(utils.Listener.class)
@Test(singleThreaded=true, groups={"Payments"}, enabled=false)
public class OldMakeAPaymentPage extends TestSetup {

	/**
	 * Verify the old Make A Payment page loads correctly
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li></li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Payments", "XSite - Charge Card"}, alwaysRun=true)
	public void placeNewPaymentOrder() throws Exception{
		
		// Create variables
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		String password = StoredVariables.getpassword().get();
		
		// Set user variables
		String vmpUser = "OriginatorSecure1";
		String secureUser = "Secure1";
		
		// Get a random Order Fee
		String getOrderFee = Integer.toString(perform.randomNumberBetween2Numbers(driver, 600, 999));
		String setOrderFee = "$" + getOrderFee + ".00";
		System.out.println("Order Fee: " + setOrderFee);

		// Login to VMP Client Portal
		vmp.login(driver, "secure1", vmpUser, password);
		
		// Set variables for a new VMP Order
		vmp.setVariables(driver);
		
		// Create a new order using deferred CC
		vmp.createNewOrderUsingDeferredCC(driver, setOrderFee);

		// Get order numbers
		db.getLoanIDsFromVMPClientPortalOrder(driver);

		// Go to the old Make A Payment page
		driver.get(perform.getvmpXSiteBillingURL(secureUser));
		
		// Enter Address
		System.out.println("Address: " + StoredVariables.getpropertyInformationAddress().get());
		perform.type(driver, XMakeAPayment.streetAddress_txtbx(driver), StoredVariables.getpropertyInformationAddress().get());
		
		// Enter Zip Code
		System.out.println("Zip: " + StoredVariables.getpropertyInformationZip().get());
		perform.type(driver, XMakeAPayment.zipCode_txtbx(driver), StoredVariables.getpropertyInformationZip().get());
		
		// Click Search
		perform.click(driver, XMakeAPayment.search_btn(driver));
		
		// Wait for the address radio button
		perform.waitForElementToBeClickable(driver, XMakeAPayment.address_radiobtn(driver));
		
		// Click the address radio button
		perform.click(driver, XMakeAPayment.address_radiobtn(driver));
		
		// Click Submit
		perform.click(driver, XMakeAPayment.submit_btn(driver));
		
		// Switch to the new window
		perform.switchToXSiteWindowByTitle(driver, "Charge Card");

		// Get heading
		String heading = XMakeAPayment.heading_txt(driver).getText();
		Assert.assertTrue(heading.equals("Complete these fields to charge a credit card."), "The heading is incorrect. It should be Complete these fields to charge a credit card., but it is " + heading);

		// Switch into the iFrame
		perform.switchToiFrameByID(driver, "PB_ctlStoreCardFrame");
//		perform.waitForIFrames(driver);
//		perform.switchToFrameBySrc(driver, "StoreCard.aspx");
		
		// Enter First Name
		perform.verification(driver, XChargeCard.firstName_txtbx(driver).getAttribute("value"), "equals", "Automation");

		// Enter Last Name
		perform.verification(driver, XChargeCard.lastName_txtbx(driver).getAttribute("value"), "equals", "Test");
		
		// Enter Zip Code
		perform.verification(driver, XChargeCard.zipCode_txtbx(driver).getAttribute("value"), "equals", "73099");
		
		// Enter Credit Card Number
		perform.type(driver, XChargeCard.creditCardNumber_txtbx(driver), "4111111111111111");
		
		// Select Expiration Month
		perform.selectDropdownOption(driver, XChargeCard.expMonth_dropdown(driver), "12");
		
		// Select Expiration Year
		perform.selectDropdownOption(driver, XChargeCard.expYear_dropdown(driver), "2027");
		
		// Enter Amount
		perform.verification(driver, XChargeCard.amount_txtbx(driver).getAttribute("value"), "equals", getOrderFee);
		
		// Enter Email Address
		perform.verification(driver, XChargeCard.emailAddress_txtbx(driver).getAttribute("value"), "equals", "test@dntest.net");
		
		// Click Charge Card
		perform.click(driver, XChargeCard.chargeCard_btn(driver));
		
		// Switch back to original browser (first window)
		driver.switchTo().window(StoredVariables.getwinHandleBefore().get());
		
		// Accept the alert
		perform.closeAlertAndGetItsText(driver, true);
		
		// Log test
		test.log(LogStatus.INFO, "Payments", "Verified the old Make A Payment page loads");
		
	} // end placeNewPaymentOrder
	
} // end the SecurePaymentMethods class
