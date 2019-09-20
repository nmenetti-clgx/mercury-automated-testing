package regressionSecure;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Secure.SClientGroups_Details;
import pageObjects.Secure.SClients;
import pageObjects.Secure.SClients_ClientGroups;
import pageObjects.Secure.SClients_OrderRouting;
import pageObjects.Secure.SOrderDetails;
import pageObjects.Secure.SOrders;
import pageObjects.Secure.SVMPXSites;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Secure - Invoice Numbers Do Not Reset When Changing Client Group Settings</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class InvoiceNumbersDoNotResetWhenChangingClientGroupSettings extends TestSetup {
	
	/** The user secure. */
	private final String userSecure = "ClientGroup1";
	
	/** The user VMP. */
	private final String userVMP ="OriginatorClientGroup1";
	
	/** The user vendors. */
	private final String userVendors = "Appraiser1";
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set preferences and enable all status mapping</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Go to VMPXSites</li>
	 * 	<li>Verify the dropdown is the correct VMP site</li>
	 * 	<li>Click Configure Automatic Settings</li>
	 * 	<li>Check Create invoice when order is placed</li>
	 * 	<li>Check Attach invoice when credit card is charged</li>
	 * 	<li>Attach invoice when order is marked complete</li>
	 * 	<li>Check Include the vendor's fee on the invoice</li>
	 * 	<li>Enter 7 for Set the invoice due date</li>
	 * 	<li>Auto numbers prefix</li>
	 * 	<li>Auto number start number</li>
	 * 	<li>Save Preferences</li>
	 * 	<li>Click OK button</li>
	 * 	<li>Click on Configure Status Mapping</li>
	 * 	<li>Enable all sync status options</li>
	 * 	<li>Click Save</li>
	 * 	<li>Place at least two orders with the client group (to trigger the invoice sequencing)</li>
	 * 	<li>Create new order</li>
	 * 	<li>Get invoice number</li>
	 * 	<li>Create new order</li>
	 * 	<li>Get invoice number</li>
	 * 	<li>Verify invoice number incremented by 1</li>
	 * 	<li>Go back to Clients</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Go to Clients</li>
	 * 	<li>Click Client Groups</li>
	 * 	<li>Click Manage Client Groups</li>
	 * 	<li>Click on Test Client Group Name</li>
	 * 	<li>Modify the Company</li>
	 * 	<li>Click Save</li>
	 * 	<li>Verify dialog text</li>
	 * 	<li>Click OK</li>
	 * 	<li>Click close</li>
	 * 	<li>Place another order</li>
	 * 	<li>Create new order</li>
	 * 	<li>Get invoice number</li>
	 * 	<li>Verify the invoice sequence is correct</li>
	 * 	<li>Open the client group again</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Go to Clients</li>
	 * 	<li>Click Client Groups</li>
	 * 	<li>Click Manage Client Groups</li>
	 * 	<li>Click on Test Client Group Name</li>
	 * 	<li>Save Client Group Settings</li>
	 * 	<li>Place another order</li>
	 * 	<li>Create new order</li>
	 * 	<li>Get invoice number</li>
	 * 	<li>Verify the invoice sequence is correct</li>
	 * 	<li>Log test</li>
	 * 	<li>Login to Vendors</li>
	 * 	<li>Accept the order</li>
	 * 	<li>Complete the order</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Find Order</li>
	 * 	<li>Open Order</li>
	 * 	<li>Click Accept this report radio button</li>
	 * 	<li>Check Attach completed report to XSite</li>
	 * 	<li>Check Attach completed report to additional recipients</li>
	 * 	<li>Click OK</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - VMP XSite Settings", "Secure - Configure Automatic Settings", "Secure - Configure Status Mapping", "VMP - Create Order Via API", "Vendors - Orders", "vendors - Accept Order", "Vendors - Complete Order", "Secure - Orders", "Secure - Clients", "Secure - Client Groups"}, alwaysRun=true)
	public void invoiceNumbersDoNotResetWhenChangingClientGroupSettings() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		String password = StoredVariables.getpassword().get();
		
		// Set preferences and enable all status mapping
		// Login to Secure
		secure.login(driver, userSecure, password);
		
		// Go to VMPXSites
		secure.goToVMPXSites(driver);
		
		// Verify the dropdown is the correct VMP site
		secure.verifyXSiteURLDropdownValue(driver, userSecure);
		
		// Click Configure Automatic Settings
		perform.click(driver, SVMPXSites.configureAutomaticSettings_lnk(driver));
		
		// Wait for Allow clients to enter fee
		perform.waitForElementToBeClickable(driver, SVMPXSites.createInvoiceWhenOrderIsPlaced_chkbx(), "id");
		
		// Check Create invoice when order is placed
		if (!SVMPXSites.createInvoiceWhenOrderIsPlaced_chkbx(driver).isSelected())
		{
			perform.click(driver, SVMPXSites.createInvoiceWhenOrderIsPlaced_chkbx(driver));
		}
		
		// Check Attach invoice when credit card is charged
		if (!SVMPXSites.attachInvoiceWhenCreditCardIsCharged_chkbx(driver).isSelected())
		{
			perform.click(driver, SVMPXSites.attachInvoiceWhenCreditCardIsCharged_chkbx(driver));
		}
		
		// Attach invoice when order is marked complete
		if (!SVMPXSites.attachInvoiceWhenOrderIsMarkedComplete_chkbx(driver).isSelected())
		{
			perform.click(driver, SVMPXSites.attachInvoiceWhenOrderIsMarkedComplete_chkbx(driver));
		}
		
		// Check Include the vendor's fee on the invoice
		if (!SVMPXSites.includeTheVendorsFeeOnTheInvoice_chkbx(driver).isSelected())
		{
			perform.click(driver, SVMPXSites.includeTheVendorsFeeOnTheInvoice_chkbx(driver));
		}
		
		// Enter 7 for Set the invoice due date
		perform.type(driver, SVMPXSites.setTheInvoiceDueDate_txtbx(driver), "7");
		
		// Auto numbers prefix
		perform.type(driver, SVMPXSites.prefix_txtbx(driver), "87");
		
		// Auto number start number
		perform.type(driver, SVMPXSites.startNumberSequence_txtbx(driver), "58");
		
		// Save Preferences
		perform.click(driver, SVMPXSites.save_btn(driver));
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SVMPXSites.saveCompleteOK_btn(), "cssSelector");
		
		// Click OK button
		perform.click(driver, SVMPXSites.saveCompleteOK_btn(driver));
		
		// Wait for button
		perform.waitForElementToBeClickable(driver, SVMPXSites.configureStatusMapping_lnk(), "id");
		
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
		
		// Place at least two orders with the client group (to trigger the invoice sequencing)
		// Create new order
		completeVMPOrder(driver);
		
		// Get invoice number
		String trackingNumber = StoredVariables.gettrackingNumber().get();
		int invoiceNumber1 = Integer.parseInt(secure.getInvoiceNumber(driver, trackingNumber).replaceAll("[^\\d.]", ""));
		
		// Create new order
		completeVMPOrder(driver);
		
		// Get invoice number
		trackingNumber = StoredVariables.gettrackingNumber().get();
		int invoiceNumber2 = Integer.parseInt(secure.getInvoiceNumber(driver, trackingNumber).replaceAll("[^\\d.]", ""));
		
		// Verify invoice number incremented by 1
		System.out.println("invoiceNumber1 = " + invoiceNumber1);
		System.out.println("invoiceNumber2 = " + invoiceNumber2);
		Assert.assertTrue(invoiceNumber2>invoiceNumber1, "The invoice number should have incremented by 1. Invoice Number 2 = " + invoiceNumber2 + ". Invoice Number 1 = " + invoiceNumber1);
		
		// Go back to Clients
		// Login to Secure
		secure.login(driver, "ClientGroup1", password);
		
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
		perform.doubleClickInTable(driver, "AutomationClientGroup");
		
		// Switch into iFrame
		driver.switchTo().defaultContent();
		perform.switchToiFrameByID(driver, "frameDialogL1");
		
		// Wait for Company textbox
		perform.waitForElementToBeClickable(driver, SClientGroups_Details.company_txtbx(), "id");
		
		// Modify the Company
		String companyName = perform.randomLetters(driver, 5)+perform.randomNumbers(driver, 8);
		perform.type(driver, SClientGroups_Details.company_txtbx(driver), companyName);
		
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
		
		// Switch out of iFrame
		driver.switchTo().defaultContent();
		
		// Place another order
		// Create new order
		completeVMPOrder(driver);
		
		// Get invoice number
		trackingNumber = StoredVariables.gettrackingNumber().get();
		int invoiceNumber3 = Integer.parseInt(secure.getInvoiceNumber(driver, trackingNumber).replaceAll("[^\\d.]", ""));
		
		// Verify the invoice sequence is correct
		System.out.println("invoiceNumber1 = " + invoiceNumber1);
		System.out.println("invoiceNumber2 = " + invoiceNumber2);
		System.out.println("invoiceNumber3 = " + invoiceNumber3);
		Assert.assertTrue(invoiceNumber3>invoiceNumber2, "The invoice number should have incremented by 1. Invoice Number 3 = " + invoiceNumber3 + ". Invoice Number 2 = " + invoiceNumber2);
		
		// Open the client group again
		// Login to Secure
		secure.login(driver, "ClientGroup1", password);
		
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
		perform.doubleClickInTable(driver, "AutomationClientGroup");
		
		// Switch into iFrame
		driver.switchTo().defaultContent();
		perform.switchToiFrameByID(driver, "frameDialogL1");
		
		// Wait for Company textbox
		perform.waitForElementToBeClickable(driver, SClientGroups_Details.company_txtbx(), "id");
		
		// Save Client Group Settings
		secure.saveClientGroupSettings(driver);
		
		// Place another order
		// Create new order
		completeVMPOrder(driver);
		
		// Get invoice number
		trackingNumber = StoredVariables.gettrackingNumber().get();
		int invoiceNumber4 = Integer.parseInt(secure.getInvoiceNumber(driver, trackingNumber).replaceAll("[^\\d.]", ""));
		
		// Verify the invoice sequence is correct
		System.out.println("invoiceNumber1 = " + invoiceNumber1);
		System.out.println("invoiceNumber2 = " + invoiceNumber2);
		System.out.println("invoiceNumber3 = " + invoiceNumber3);
		System.out.println("invoiceNumber4 = " + invoiceNumber4);
		Assert.assertTrue(invoiceNumber4>invoiceNumber3, "The invoice number should have incremented by 1. Invoice Number 4 = " + invoiceNumber4 + ". Invoice Number 3 = " + invoiceNumber3);
		
		// Log test
		test.log(LogStatus.INFO, "Secure Regression Test", "Verified that the invoice numbers to not reset when you change the client group settings");
		
	} // end invoiceNumbersDoNotResetWhenChangingClientGroupSettings
	
	/**
	 * Complete VMP order.
	 *
	 * @param driver the driver
	 * @throws Exception the exception
	 */
	private void completeVMPOrder(RemoteWebDriver driver) throws Exception{
	
		String password = StoredVariables.getpassword().get();
		
		perform.apiPlaceOrderFromVMPClientPortal(driver, userVMP, password, userSecure, "PlaceAppraisalOrderExLenderNoGroups-InvoiceNumbersDoNotResetWhenChangingClientGroupSettings");
		String trackingNumber = StoredVariables.gettrackingNumber().get();
		
		// Login to Vendors
		vendors.login(driver, userVendors, password);
		
		// Accept the order
		vendors.acceptOrder(driver, trackingNumber);
		
		// Complete the order
		vendors.completeOrderByHTTPPost(driver, userVendors, password, trackingNumber, "Complete.xml");
		
		// Login to Secure
		secure.login(driver, userSecure, password);
		
		// Find Order
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Open Order
		secure.openOrder(driver, trackingNumber);

		try {
			
			// Click Accept this report radio button
			perform.click(driver, SOrderDetails.acceptThisReportAsIs_radioBtn(driver));
			
			// Check Attach completed report to XSite
			perform.checkCheckbox(driver, SOrderDetails.attachCompletedReportToXSite_chkbx(driver));
			
			// Check Attach completed report to additional recipients
			perform.checkCheckbox(driver, SOrderDetails.attachCompletedReportToAdditionalRecipients_chkbx(driver));		
			
			// Click OK
			perform.click(driver, SOrderDetails.okProcessReceivedReport_btn(driver));
			
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			// Wait for Find textbox
			perform.waitForElementToBeClickable(driver, SOrders.find_txtbx(), "id");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	} // end completeVMPOrder
	
} // end the InvoiceNumbersDoNotResetWhenChangingClientGroupSettings class
