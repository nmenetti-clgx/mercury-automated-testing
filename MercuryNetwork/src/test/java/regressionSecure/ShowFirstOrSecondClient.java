package regressionSecure;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Secure.SConfirmOrder;
import pageObjects.Secure.SOrderDetails;
import pageObjects.XSite.XEditOrder;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Secure - Show First Or Second Client</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class ShowFirstOrSecondClient extends TestSetup {
	
	/** The user secure 1. */
	private final String userSecure1 = "SC1";
	
	/** The user VMP 1. */
	private final String userVMP1 = "OriginatorSC1";
	
	/** The user AMC 1. */
	private final String userAMC1 = "ClientAMC1";
	
	/** The user secure 2. */
	private final String userSecure2 = "SC2";
	
	/** The user VMP 2. */
	private final String userVMP2 = "OriginatorSC2";
	
	/** The user AMC 2. */
	private final String userAMC2 = "ClientAMC2";
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set preferences and enable all status mapping for all users</li>
	 * 	<li>Create order through the API</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Find order</li>
	 * 	<li>Open order</li>
	 * 	<li>Select AMC radio button</li>
	 * 	<li>Click Assign</li>
	 * 	<li>Assign the order</li>
	 * 	<li>Click Finish</li>
	 * 	<li>Verify history</li>
	 * 	<li>Log in to Secure as AMC</li>
	 * 	<li>Find order</li>
	 * 	<li>Open order</li>
	 * 	<li>Click View XSite order link</li>
	 * 	<li>Switch to new window</li>
	 * 	<li>Switch to iFrame</li>
	 * 	<li>Verify the Client Information text</li>
	 * 	<li>Close the Business Management window</li>
	 * 	<li>Switch back to original window</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - VMP XSite Settings", "Secure - Configure Status Mapping", "Secure - Create Order Via API", "Secure - Orders", "Secure - Assign Order To AMC", "XSite - Order Details"}, alwaysRun=true)
	public void showFirstOrder() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		String password = StoredVariables.getpassword().get();
		
		// Set preferences and enable all status mapping for all users
		secure.enableAllSyncOptionsSettings(driver, userSecure1);
		secure.enableAllSyncOptionsSettings(driver, userAMC1);
		
		// Create order through the API
		perform.apiPlaceOrderFromVMPClientPortal(driver, userVMP1, password, userSecure1, "PlaceAppraisalOrderExLenderNoGroups-ShowFirstOrder");
		String trackingNumber = StoredVariables.gettrackingNumber().get();
		
		// Log in to Secure
		secure.login(driver, userSecure1, password);
		
		// Find order
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Open order
		secure.openOrder(driver, trackingNumber);
		
		// Select AMC radio button
		perform.click(driver,SOrderDetails.amcFirm_radiobtn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Click Assign
		perform.click(driver,SOrderDetails.assign_btn(driver));
		
		// Assign the order
		secure.selectVendorSearchByLastName(driver, userAMC1);
		
		// Click Finish
		perform.click(driver,SConfirmOrder.finishTop_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Verify history
		String history = SOrderDetails.history_txt(driver).getText();
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation"+StoredVariables.getusernameEnvironment().get()+"ClientAMC1"), "The history is incorrect on Secure. \n" + history);
		Assert.assertTrue(history.contains("Order automatically accepted"), "The history is incorrect on Secure. \n" + history);
		Assert.assertTrue(history.contains("Order accepted by AMC (Automation"+StoredVariables.getusernameEnvironment().get()+"ClientAMC1) and In Progress"), "The history is incorrect on Secure. \n" + history);
		
		// Log in to Secure as AMC
		secure.login(driver, userAMC1, password);
		
		// Find order
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Open order
		secure.openOrder(driver, trackingNumber);

		// Click View XSite order link
		perform.click(driver,SOrderDetails.viewXSiteOrder_lnk(driver));
		
		// Switch to new window
		perform.switchToXSiteWindowByTitle(driver, "Business Management");
		
		// Switch to iFrame
		perform.switchToiFrameByID(driver, "Main");
		
		// Verify the Client Information text
		String phone = "";
		String env = StoredVariables.getusernameEnvironment().get();
		if (env.equals("QA"))
		{
			phone = "111";
		}
		if (env.equals("Beta"))
		{
			phone = "222";
		}
		if (env.equals("Live"))
		{
			phone = "333";
		}
		perform.waitForElementToBeClickable(driver, XEditOrder.clientInformation_txt(), "id");
		String clientInformation = XEditOrder.clientInformation_txt(driver).getText();
		Assert.assertTrue(clientInformation.contains("Automation OriginatorSC1"), "The Client Information Name is incorrect. It should be the Originator info");
		Assert.assertTrue(clientInformation.contains("(501) "+phone+"-9213"), "The Client Information Phone is incorrect. It should be the Originator info");
		
		// Close the Business Management window
		driver.close();
		
		// Switch back to original window
		driver.switchTo().window(StoredVariables.getwinHandleBefore().get());
		driver.switchTo().defaultContent();
		
		// Log test
		test.log(LogStatus.INFO, "Secure Regression Test", "Verified that the first order client is displayed with the ShowFirstOrderOrderedByClientName bit set to 1");
		
	} // end showFirstOrder
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set preferences and enable all status mapping for all users</li>
	 * 	<li>Create order through the API</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Find order</li>
	 * 	<li>Open order</li>
	 * 	<li>Select AMC radio button</li>
	 * 	<li>Click Assign</li>
	 * 	<li>Assign the order</li>
	 * 	<li>Click Finish</li>
	 * 	<li>Verify history</li>
	 * 	<li>Log in to Secure as AMC</li>
	 * 	<li>Find order</li>
	 * 	<li>Open order</li>
	 * 	<li>Click View XSite order link</li>
	 * 	<li>Switch to new window</li>
	 * 	<li>Switch to iFrame</li>
	 * 	<li>Verify the Client Information text</li>
	 * 	<li>Close the Business Management window</li>
	 * 	<li>Switch back to original window</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - VMP XSite Settings", "Secure - Configure Status Mapping", "Secure - Create Order Via API", "Secure - Orders", "Secure - Assign Order To AMC", "XSite - Order Details"}, alwaysRun=true)
	public void showSecondOrder() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		String password = StoredVariables.getpassword().get();
		
		// Set preferences and enable all status mapping for all users
		secure.enableAllSyncOptionsSettings(driver, userSecure2);
		secure.enableAllSyncOptionsSettings(driver, userAMC2);
		
		// Create order through the API
		perform.apiPlaceOrderFromVMPClientPortal(driver, userVMP2, password, userSecure2, "PlaceAppraisalOrderExLenderNoGroups-ShowSecondOrder");
		String trackingNumber = StoredVariables.gettrackingNumber().get();
		
		// Log in to Secure
		secure.login(driver, userSecure2, password);
		
		// Find order
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Open order
		secure.openOrder(driver, trackingNumber);
		
		// Select AMC radio button
		perform.click(driver,SOrderDetails.amcFirm_radiobtn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Click Assign
		perform.click(driver,SOrderDetails.assign_btn(driver));
		
		// Assign the order
		secure.selectVendorSearchByLastName(driver, userAMC2);
		
		// Click Finish
		perform.click(driver,SConfirmOrder.finishTop_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Verify history
		String env = StoredVariables.getusernameEnvironment().get();
		String history = SOrderDetails.history_txt(driver).getText();
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation"+env+"ClientAMC2"), "The history is incorrect on Secure. \n" + history);
		Assert.assertTrue(history.contains("Reassigned by Client (Automation SC2) to Automation"+env+"ClientAMC2"), "The history is incorrect on Secure. \n" + history);
		Assert.assertTrue(history.contains("Order Changed by Client (Automation SC2)"), "The history is incorrect on Secure. \n" + history);
		Assert.assertTrue(history.contains("Requires assignment"), "The history is incorrect on Secure. \n" + history);
		Assert.assertTrue(history.contains("Awaiting acceptance"), "The history is incorrect on Secure. \n" + history);
		
		// Log in to Secure as AMC
		secure.login(driver, userAMC2, password);
		
		// Find order
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Open order
		secure.openOrder(driver, trackingNumber);

		// Click View XSite order link
		perform.click(driver,SOrderDetails.viewXSiteOrder_lnk(driver));
		
		// Switch to new window
		perform.switchToXSiteWindowByTitle(driver, "Business Management");
		
		// Switch to iFrame
		perform.switchToiFrameByID(driver, "Main");
		
		// Wait for client information
		perform.waitForElementToBeClickable(driver, XEditOrder.clientInformation_txt(), "id");
		
		// Verify the Client Information text
		String phone = "";
		if (env.equals("QA"))
		{
			phone = "111";
		}
		if (env.equals("Beta"))
		{
			phone = "222";
		}
		if (env.equals("Live"))
		{
			phone = "333";
		}
		String clientInformation = XEditOrder.clientInformation_txt(driver).getText();
		Assert.assertTrue(clientInformation.contains("Automation SC2"), "The Client Information Name is incorrect. It should be the Originator info");
		Assert.assertTrue(clientInformation.contains("(501) "+phone+"-5412"), "The Client Information Phone is incorrect. It should be the Originator info");
		
		// Close the Business Management window
		driver.close();
		
		// Switch back to original window
		driver.switchTo().window(StoredVariables.getwinHandleBefore().get());
		driver.switchTo().defaultContent();
		
		// Log test
		test.log(LogStatus.INFO, "Secure Regression Test", "Verified that the first order client is displayed with the ShowFirstOrderOrderedByClientName bit set to 1");
		
	} // end showSecondOrder
	
} // end the ShowFirstOrSecondClient class
