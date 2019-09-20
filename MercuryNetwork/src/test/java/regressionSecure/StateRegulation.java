package regressionSecure;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Secure.SConfirmOrder;
import pageObjects.Secure.SOrderDetails;
import pageObjects.Secure.SVMPXSites;
import pageObjects.Vendors.VOrderDetails;
import pageObjects.XSite.XInvoice;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Secure - State Regulation</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
@Test(singleThreaded=true)
public class StateRegulation extends TestSetup {
	
	/** The user VMP. */
	private final String userVMP = "OriginatorStateRegulation1";
	
	/** The user secure. */
	private final String userSecure = "StateRegulation1";
	
	/** The user AMC. */
	private final String userAMC = "StateRegulationAMC1";
	
	/** The user appraiser. */
	private final String userAppraiser = "StateRegulationAppraiser1";
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set preferences and enable all status mapping</li>
	 * 	<li>Login to Secure as Lender</li>
	 * 	<li>Go to VMPXSites</li>
	 * 	<li>Click on Configure Status Mapping</li>
	 * 	<li>Enable all sync status options</li>
	 * 	<li>Click Save</li>
	 * 	<li>Click AMC/Firm</li>
	 * 	<li>Enable all sync status options</li>
	 * 	<li>Click Save</li>
	 * 	<li>Log into Secure as an AMC</li>
	 * 	<li>Go to VMPXSites</li>
	 * 	<li>Click on Configure Status Mapping</li>
	 * 	<li>Enable all sync status options</li>
	 * 	<li>Click Save</li>
	 * 	<li>Click AMC/Firm</li>
	 * 	<li>Enable all sync status options</li>
	 * 	<li>Click Save</li>
	 * 	<li>Create order through the API</li>
	 * 	<li>Set Order Number</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Find order</li>
	 * 	<li>Open order</li>
	 * 	<li>Select Appraiser radio button</li>
	 * 	<li>Click Assign</li>
	 * 	<li>Assign the order</li>
	 * 	<li>Click Finish</li>
	 * 	<li>Set win1</li>
	 * 	<li>View the XSite order of the Lender</li>
	 * 	<li>Click View XSite Order link</li>
	 * 	<li>Switch to the new window</li>
	 * 	<li>Get the Window Handle before the new window opens</li>
	 * 	<li>Open Billing &gt; Invoice</li>
	 * 	<li>Verify Fee paid to Appraiser is in the Fees section</li>
	 * 	<li>Close third window</li>
	 * 	<li>Switch back to second window</li>
	 * 	<li>Close second window</li>
	 * 	<li>Switch back to original window</li>
	 * 	<li>Switch out of frame</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - VMP XSite Settings", "Secure - Configure Status Mapping", "VMP - Create Order Via API", "Secure - Orders", "XSite - Order Details", "XSite - Invoice"}, alwaysRun=true)
	public void lenderConfiguredState() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		String password = StoredVariables.getpassword().get();
		
		// Set preferences and enable all status mapping
		// Login to Secure as Lender
		secure.login(driver, userSecure, password);
		
		// Go to VMPXSites
		secure.goToVMPXSites(driver);
		
		// Click on Configure Status Mapping
		perform.click(driver, SVMPXSites.configureStatusMapping_lnk(driver));
		
		// Wait for element
		perform.waitForElementToBeVisible(driver, SVMPXSites.statusMappingConfiguration_txt(), "id");
		
		// Enable all sync status options
		perform.enableAllOptionsInStatusMappingConfiguration(driver);
		
		// Click Save
		perform.clickInTable_Contains(driver, "Save");
		
		// Wait for save dialog to be hidden 
		perform.waitForOverlayToBeHidden(driver);
		
		// Click AMC/Firm
		perform.click(driver, SVMPXSites.amcFirm_btn(driver));

		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Enable all sync status options
		perform.enableAllOptionsInStatusMappingConfiguration(driver);
		
		// Click Save
		perform.clickInTable_Contains(driver, "Save");
		
		// Wait for save dialog to be hidden 
		perform.waitForOverlayToBeHidden(driver);
		
		// Log into Secure as an AMC
		secure.login(driver, userAMC, password);
		
		// Go to VMPXSites
		secure.goToVMPXSites(driver);
		
		// Click on Configure Status Mapping
		perform.click(driver, SVMPXSites.configureStatusMapping_lnk(driver));
		
		// Wait for element
		perform.waitForElementToBeVisible(driver, SVMPXSites.statusMappingConfiguration_txt(), "id");
		
		// Enable all sync status options
		perform.enableAllOptionsInStatusMappingConfiguration(driver);
		
		// Click Save
		perform.clickInTable_Contains(driver, "Save");
		
		// Wait for save dialog to be hidden 
		perform.waitForOverlayToBeHidden(driver);
		
		// Click AMC/Firm
		perform.click(driver, SVMPXSites.amcFirm_btn(driver));

		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Enable all sync status options
		perform.enableAllOptionsInStatusMappingConfiguration(driver);
		
		// Click Save
		perform.clickInTable_Contains(driver, "Save");
		
		// Wait for save dialog to be hidden 
		perform.waitForOverlayToBeHidden(driver);
		
		// Create order through the API
		perform.apiPlaceOrderFromVMPClientPortal(driver, userVMP, password, userSecure, "PlaceAppraisalOrderExLenderNoGroups-StateRegulation-lenderConfiguredState");
		
		// Set Order Number
		String trackingNumber = StoredVariables.gettrackingNumber().get();
		
		// Log in to Secure
		secure.login(driver, userSecure, password);
		
		// Find order
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Open order
		secure.openOrder(driver, trackingNumber);
		
		// Select Appraiser radio button
		perform.click(driver, SOrderDetails.appraiser_radiobtn(driver));
		
		// Wait for Assign button
		perform.waitForElementToBeClickable(driver, SOrderDetails.assign_btn(), "id");
		
		// Click Assign
		perform.click(driver, SOrderDetails.assign_btn(driver));
		
		// Assign the order
		secure.selectVendor(driver, userAppraiser);
		
		// Click Finish
		perform.click(driver, SConfirmOrder.finishTop_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Set win1
		StoredVariables.getwin1().set(driver.getWindowHandle());
		
		// View the XSite order of the Lender
		// Click View XSite Order link
		perform.click(driver, SOrderDetails.viewXSiteOrder_lnk(driver));
		
		// Switch to the new window
		perform.switchToXSiteWindowByTitle(driver, "Business Management");
		
		// Get the Window Handle before the new window opens
		StoredVariables.getwin2().set(driver.getWindowHandle());
		
		// Open Billing > Invoice
		secure.viewInvoiceFromXSiteBusinessManagement(driver);
		
		// Verify Fee paid to Appraiser is in the Fees section
		Assert.assertTrue(XInvoice.fees_txt(driver).getText().contains("Fee paid to Appraiser:"), "Fee paid to Appraiser should be in the Fees line items");
		
		// Close third window
		driver.close();
		
		// Switch back to second window
		driver.switchTo().window(StoredVariables.getwin2().get());
		
		// Close second window
		driver.close();
		
		// Switch back to original window
		driver.switchTo().window(StoredVariables.getwin1().get());
		
		// Switch out of frame
		driver.switchTo().defaultContent();
		
		// Log test
		test.log(LogStatus.INFO, "Secure Regression Test", "Verified that Fee paid to Appraiser is in the Fees line items on the Billing Invoice if the state regulation bit is on");
		
	} // end lenderConfiguredState
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Create order through the API</li>
	 * 	<li>Get order numbers</li>
	 * 	<li>Set Order Number</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Find order</li>
	 * 	<li>Open order</li>
	 * 	<li>Select Appraiser radio button</li>
	 * 	<li>Click Assign</li>
	 * 	<li>Assign the order</li>
	 * 	<li>Click Finish</li>
	 * 	<li>Set win1</li>
	 * 	<li>View the XSite order of the Lender</li>
	 * 	<li>Click View XSite Order link</li>
	 * 	<li>Switch to the new window</li>
	 * 	<li>Set win2</li>
	 * 	<li>Open Billing &gt; Invoice</li>
	 * 	<li>Verify Fee paid to Appraiser is not in the Fees section</li>
	 * 	<li>Close third window</li>
	 * 	<li>Switch back to second window</li>
	 * 	<li>Close second window</li>
	 * 	<li>Switch back to original window</li>
	 * 	<li>Switch out of frame</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"VMP - Create Order Via API", "Secure - Orders", "XSite - Order Details", "XSite - Invoice"}, alwaysRun=true)
	public void lenderNonConfiguredState() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		String password = StoredVariables.getpassword().get();
		
		// Create order through the API
		perform.apiPlaceOrderFromVMPClientPortal(driver, userVMP, password, userSecure, "PlaceAppraisalOrderExLenderNoGroups-StateRegulation-lenderNonConfiguredState");
		
		// Get order numbers
		db.getLoanIDsFromVMPClientPortalOrder(driver);
		
		// Set Order Number
		String trackingNumber = StoredVariables.gettrackingNumber().get();
		
		// Log in to Secure
		secure.login(driver, userSecure, password);
		
		// Find order
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Open order
		secure.openOrder(driver, trackingNumber);
		
		// Select Appraiser radio button
		perform.click(driver, SOrderDetails.appraiser_radiobtn(driver));
		
		// Wait for Assign button
		perform.waitForElementToBeClickable(driver, SOrderDetails.assign_btn(), "id");
		
		// Click Assign
		perform.click(driver, SOrderDetails.assign_btn(driver));
		
		// Assign the order
		secure.selectVendor(driver, userAppraiser);
		
		// Click Finish
		perform.click(driver, SConfirmOrder.finishTop_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Set win1
		StoredVariables.getwin1().set(driver.getWindowHandle());
		
		// View the XSite order of the Lender
		// Click View XSite Order link
		perform.click(driver, SOrderDetails.viewXSiteOrder_lnk(driver));
		
		// Switch to the new window
		perform.switchToXSiteWindowByTitle(driver, "Business Management");
		
		// Set win2
		StoredVariables.getwin2().set(driver.getWindowHandle());
		
		// Open Billing > Invoice
		secure.viewInvoiceFromXSiteBusinessManagement(driver);
		
		// Verify Fee paid to Appraiser is not in the Fees section
		Assert.assertTrue(!XInvoice.fees_txt(driver).getText().contains("Fee paid to Appraiser:"), "Fee paid to Appraiser should not be in the Fees line items");
		
		// Close third window
		driver.close();
		
		// Switch back to second window
		driver.switchTo().window(StoredVariables.getwin2().get());
		
		// Close second window
		driver.close();
		
		// Switch back to original window
		driver.switchTo().window(StoredVariables.getwin1().get());
		
		// Switch out of frame
		driver.switchTo().defaultContent();
		
		// Log test
		test.log(LogStatus.INFO, "Secure Regression Test", "Verified that Fee paid to Appraiser is not in the Fees line items on the Billing Invoice if the state regulation bit is on");
		
	} // end lenderNonConfiguredState
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Create order through the API</li>
	 * 	<li>Set Order Number</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Find order</li>
	 * 	<li>Open order</li>
	 * 	<li>Select AMC radio button</li>
	 * 	<li>Click Assign</li>
	 * 	<li>Assign the order</li>
	 * 	<li>Click Finish</li>
	 * 	<li>Set win1</li>
	 * 	<li>View the XSite order of the Lender</li>
	 * 	<li>Click View XSite Order link</li>
	 * 	<li>Switch to the new window</li>
	 * 	<li>Set win2</li>
	 * 	<li>Open Billing &gt; Invoice</li>
	 * 	<li>Verify Fee paid to Appraiser is in the Fees section</li>
	 * 	<li>Close third window</li>
	 * 	<li>Switch back to second window</li>
	 * 	<li>Close second window</li>
	 * 	<li>Switch back to original window</li>
	 * 	<li>Switch out of frame</li>
	 * 	<li>Log in to Secure as the AMC</li>
	 * 	<li>Find order</li>
	 * 	<li>Open order</li>
	 * 	<li>Click Assign</li>
	 * 	<li>Assign the order</li>
	 * 	<li>Click Finish</li>
	 * 	<li>View the XSite order of the AMC</li>
	 * 	<li>Click View XSite Order link</li>
	 * 	<li>Switch to the new window</li>
	 * 	<li>Set win2</li>
	 * 	<li>Open Billing &gt; Invoice</li>
	 * 	<li>Verify Fee paid to Appraiser is in the Fees section</li>
	 * 	<li>Close third window</li>
	 * 	<li>Switch back to second window</li>
	 * 	<li>Close second window</li>
	 * 	<li>Switch back to original window</li>
	 * 	<li>Switch out of frame</li>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Open the order</li>
	 * 	<li>Verify AMC Fee is in the additional comments section</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"VMP - Create Order Via API", "Secure - Orders", "XSite - Order Details", "XSite - Invoice", "Vendors - Orders", "Secure - Assign Order To AMC"}, alwaysRun=true)
	public void amcConfiguredState() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		String password = StoredVariables.getpassword().get();
		
		// Create order through the API
		perform.apiPlaceOrderFromVMPClientPortal(driver, userVMP, password, userSecure, "PlaceAppraisalOrderExLenderNoGroups-StateRegulation-amcConfiguredState");
		
		// Set Order Number
		String trackingNumber = StoredVariables.gettrackingNumber().get();
		
		// Log in to Secure
		secure.login(driver, userSecure, password);
		
		// Find order
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Open order
		secure.openOrder(driver, trackingNumber);
		
		// Select AMC radio button
		perform.click(driver, SOrderDetails.amcFirm_radiobtn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for Assign button
		perform.waitForElementToBeClickable(driver, SOrderDetails.assign_btn(), "id");
		
		// Click Assign
		perform.click(driver, SOrderDetails.assign_btn(driver));
		
		// Assign the order
		secure.selectVendor(driver, userAMC);
		
		Thread.sleep(2000);
		
		// Click Finish
		perform.click(driver, SConfirmOrder.finishTop_btn(driver));
		
		Thread.sleep(1500);
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Set win1
		StoredVariables.getwin1().set(driver.getWindowHandle());
		
		// View the XSite order of the Lender
		// Click View XSite Order link
		perform.click(driver, SOrderDetails.viewXSiteOrder_lnk(driver));
		
		// Switch to the new window
		perform.switchToXSiteWindowByTitle(driver, "Business Management");
		
		// Set win2
		StoredVariables.getwin2().set(driver.getWindowHandle());
		
		// Open Billing > Invoice
		secure.viewInvoiceFromXSiteBusinessManagement(driver);
		
		// Verify Fee paid to Appraiser is in the Fees section
		Assert.assertTrue(XInvoice.fees_txt(driver).getText().contains("Fee paid to Appraiser:"), "Fee paid to Appraiser should be in the Fees line items");
		
		// Close third window
		driver.close();
		
		// Switch back to second window
		driver.switchTo().window(StoredVariables.getwin2().get());
		
		// Close second window
		driver.close();
		
		// Switch back to original window
		driver.switchTo().window(StoredVariables.getwin1().get());
		
		// Switch out of frame
		driver.switchTo().defaultContent();
		
		// Log in to Secure as the AMC
		secure.login(driver, userAMC, password);
		
		// Find order
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Open order
		secure.openOrder(driver, trackingNumber);
		
		// Click Assign
		perform.click(driver, SOrderDetails.assign_btn(driver));
		
		// Assign the order
		secure.selectVendor(driver, userAppraiser);
		
		// Click Finish
		perform.click(driver, SConfirmOrder.finishTop_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// View the XSite order of the AMC
		// Click View XSite Order link
		perform.click(driver, SOrderDetails.viewXSiteOrder_lnk(driver));
		
		// Switch to the new window
		perform.switchToXSiteWindowByTitle(driver, "Business Management");
		
		// Set win2
		StoredVariables.getwin2().set(driver.getWindowHandle());
		
		// Open Billing > Invoice
		secure.viewInvoiceFromXSiteBusinessManagement(driver);
		
		// Verify Fee paid to Appraiser is in the Fees section
		Assert.assertTrue(XInvoice.fees_txt(driver).getText().contains("Fee paid to Appraiser:"), "Fee paid to Appraiser should be in the Fees line items");
		
		// Close third window
		driver.close();
		
		// Switch back to second window
		driver.switchTo().window(StoredVariables.getwin2().get());
		
		// Close second window
		driver.close();
		
		// Switch back to original window
		driver.switchTo().window(StoredVariables.getwin1().get());
		
		// Switch out of frame
		driver.switchTo().defaultContent();
		
		// Log in to Vendors
		vendors.login(driver, userAppraiser, password);
		
		// Open the order
		vendors.findAndOpenOrder(driver, trackingNumber);
		
		// Wait for Additional Comments text
		perform.waitForElementToBeClickable(driver, VOrderDetails.additionalComments_txt(), "id");
		
		// Verify AMC Fee is in the additional comments section
		Assert.assertTrue(VOrderDetails.additionalComments_txt(driver).getText().contains("AMC Fee:"), "The AMC Fee should be displayed in the Additional Comments section");
		
		// Log test
		test.log(LogStatus.INFO, "Secure Regression Test", "Verified that Fee paid to Appraiser is in the Fees line items on the Billing Invoice if the state regulation bit is on");
		
	} // end amcConfiguredState
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Create order through the API</li>
	 * 	<li>Set Order Number</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Find order</li>
	 * 	<li>Open order</li>
	 * 	<li>Select AMC radio button</li>
	 * 	<li>Click Assign</li>
	 * 	<li>Assign the order</li>
	 * 	<li>Click Finish</li>
	 * 	<li>Set win1</li>
	 * 	<li>View the XSite order of the Lender</li>
	 * 	<li>Click View XSite Order link</li>
	 * 	<li>Switch to the new window</li>
	 * 	<li>Set win2</li>
	 * 	<li>Open Billing &gt; Invoice</li>
	 * 	<li>Verify Fee paid to Appraiser is not in the Fees section</li>
	 * 	<li>Close third window</li>
	 * 	<li>Switch back to second window</li>
	 * 	<li>Close second window</li>
	 * 	<li>Switch back to original window</li>
	 * 	<li>Switch out of frame</li>
	 * 	<li>Log in to Secure as the AMC</li>
	 * 	<li>Find order</li>
	 * 	<li>Open order</li>
	 * 	<li>Click Assign</li>
	 * 	<li>Assign the order</li>
	 * 	<li>Click Finish</li>
	 * 	<li>View the XSite order of the AMC</li>
	 * 	<li>Click View XSite Order link</li>
	 * 	<li>Switch to the new window</li>
	 * 	<li>Set win2</li>
	 * 	<li>Open Billing &gt; Invoice</li>
	 * 	<li>Verify Fee paid to Appraiser is not in the Fees section</li>
	 * 	<li>Close third window</li>
	 * 	<li>Switch back to second window</li>
	 * 	<li>Close second window</li>
	 * 	<li>Switch back to original window</li>
	 * 	<li>Switch out of frame</li>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Open the order</li>
	 * 	<li>Verify AMC Fee is not in the additional comments section</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"VMP - Create Order Via API", "Secure - Orders", "XSite - Order Details", "XSite - Invoice", "Vendors - Orders", "Secure - Assign Order To AMC"}, alwaysRun=true)
	public void amcNonConfiguredState() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		String password = StoredVariables.getpassword().get();
		
		// Create order through the API
		perform.apiPlaceOrderFromVMPClientPortal(driver, userVMP, password, userSecure, "PlaceAppraisalOrderExLenderNoGroups-StateRegulation-amcNonConfiguredState");
		
		// Set Order Number
		String trackingNumber = StoredVariables.gettrackingNumber().get();
		
		// Log in to Secure
		secure.login(driver, userSecure, password);
		
		// Find order
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Open order
		secure.openOrder(driver, trackingNumber);
		
		// Select AMC radio button
		perform.click(driver, SOrderDetails.amcFirm_radiobtn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for Assign button
		perform.waitForElementToBeClickable(driver, SOrderDetails.assign_btn(), "id");
		
		// Click Assign
		perform.click(driver, SOrderDetails.assign_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Assign the order
		secure.selectVendorSearchByLastName(driver, "StateRegulationAMC1");
		
		Thread.sleep(2000);
		
		// Click Finish
		perform.click(driver, SConfirmOrder.finishTop_btn(driver));
		
		Thread.sleep(2000);
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Set win1
		StoredVariables.getwin1().set(driver.getWindowHandle());
		
		// View the XSite order of the Lender
		// Click View XSite Order link
		perform.click(driver, SOrderDetails.viewXSiteOrder_lnk(driver));
		
		// Switch to the new window
		perform.switchToXSiteWindowByTitle(driver, "Business Management");
		
		// Set win2
		StoredVariables.getwin2().set(driver.getWindowHandle());
		
		// Open Billing > Invoice
		secure.viewInvoiceFromXSiteBusinessManagement(driver);
		
		// Verify Fee paid to Appraiser is not in the Fees section
		Assert.assertTrue(!XInvoice.fees_txt(driver).getText().contains("Fee paid to Appraiser:"), "Fee paid to Appraiser should not be in the Fees line items");
		
		// Close third window
		driver.close();
		
		// Switch back to second window
		driver.switchTo().window(StoredVariables.getwin2().get());
		
		// Close second window
		driver.close();
		
		// Switch back to original window
		driver.switchTo().window(StoredVariables.getwin1().get());
		
		// Switch out of frame
		driver.switchTo().defaultContent();
		
		// Log in to Secure as the AMC
		secure.login(driver, userAMC, password);
		
		// Find order
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Open order
		secure.openOrder(driver, trackingNumber);
		
		// Click Assign
		perform.click(driver, SOrderDetails.assign_btn(driver));
		
		// Assign the order
		secure.selectVendor(driver, userAppraiser);
		
		// Click Finish
		perform.click(driver, SConfirmOrder.finishTop_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// View the XSite order of the AMC
		// Click View XSite Order link
		perform.click(driver, SOrderDetails.viewXSiteOrder_lnk(driver));
		
		// Switch to the new window
		perform.switchToXSiteWindowByTitle(driver, "Business Management");
		
		// Set win2
		StoredVariables.getwin2().set(driver.getWindowHandle());
		
		// Open Billing > Invoice
		secure.viewInvoiceFromXSiteBusinessManagement(driver);
		
		// Verify Fee paid to Appraiser is not in the Fees section
		Assert.assertTrue(!XInvoice.fees_txt(driver).getText().contains("Fee paid to Appraiser:"), "Fee paid to Appraiser should not be in the Fees line items");
		
		// Close third window
		driver.close();
		
		// Switch back to second window
		driver.switchTo().window(StoredVariables.getwin2().get());
		
		// Close second window
		driver.close();
		
		// Switch back to original window
		driver.switchTo().window(StoredVariables.getwin1().get());
		
		// Switch out of frame
		driver.switchTo().defaultContent();
		
		// Log in to Vendors
		vendors.login(driver, userAppraiser, password);
		
		// Open the order
		vendors.findAndOpenOrder(driver, trackingNumber);
		
		// Wait for Additional Comments text
		perform.waitForElementToBeClickable(driver, VOrderDetails.additionalComments_txt(), "id");
		
		// Verify AMC Fee is not in the additional comments section
		Assert.assertTrue(!VOrderDetails.additionalComments_txt(driver).getText().contains("AMC Fee:"), "The AMC Fee should not be displayed in the Additional Comments section");
		
		// Log test
		test.log(LogStatus.INFO, "Secure Regression Test", "Verified that Fee paid to Appraiser is not in the Fees line items on the Billing Invoice if the state regulation bit is on");
		
	} // end amcNonConfiguredState
	
} // end the StateRegulation class
