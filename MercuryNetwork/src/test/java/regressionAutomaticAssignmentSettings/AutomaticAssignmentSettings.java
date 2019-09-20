package regressionAutomaticAssignmentSettings;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Secure.SVMPXSites;
import pageObjects.Secure.SVendorSelectionSettings;
import pageObjects.VMP.VMPAppraisalOrderDetails;
import pageObjects.VMP.VMPConfirmOrder;
import pageObjects.VMP.VMPNewOrder;
import pageObjects.VMP.VMPOrders;
import pageObjects.Vendors.VOrderDetails;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Automatic Assignment Settings</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
@Test (singleThreaded=true)
public class AutomaticAssignmentSettings extends TestSetup {

	/** The user secure. */
	private static String userSecure = "RegressionSecure15";
	
	/** The user VMP. */
	private static String userVMP = "OriginatorRegressionSecure15";
	
	/** The user vendors. */
	private static String userVendors = "";
	
	/** The password. */
	private static String password = "";
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Go to Vendor Selection Settings</li>
	 * 	<li>Set changed boolean</li>
	 * 	<li>Turn on Automatic vendor selection</li>
	 * 	<li>Turn on Unattended Order Assignment</li>
	 * 	<li>Click the Off switch</li>
	 * 	<li>Click OK</li>
	 * 	<li>Turn on Unattended Order Reassignment</li>
	 * 	<li>Save settings</li>
	 * 	<li>Go to VMP XSite settings</li>
	 * 	<li>Click Configure Automatic Settings</li>
	 * 	<li>Verify elements on the page exists</li>
	 * 	<li>Check Do not pass VMP Comments to the vendor checkbox</li>
	 * 	<li>Uncheck Assign supplemental orders to the vendor that completed the original appraisal checkbox</li>
	 * 	<li>Verify "vendor's published fee" is selected when assigning orders dropdown</li>
	 * 	<li>Check Use vendor override fee whenever possible</li>
	 * 	<li>Check Always use the new vendor's published fee when re-assigning an order checkbox</li>
	 * 	<li>Verify % VMP fee is grayed out</li>
	 * 	<li>Set the payment method to COD</li>
	 * 	<li>Save settings</li>
	 * 	<li>Login to VMP Client Portal</li>
	 * 	<li>Set variables for new order</li>
	 * 	<li>Place an order from VMP Client Portal</li>
	 * 	<li>Get order numbers</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Get the vendor assigned to the order</li>
	 * 	<li>Login to Vendors</li>
	 * 	<li>Open the order</li>
	 * 	<li>Verify the comment did not get passed</li>
	 * 	<li>Verify order fee is $300</li>
	 * 	<li>Verify Payment Method</li>
	 * 	<li>Decline the order</li>
	 * 	<li>Get the vendor reassigned to the order</li>
	 * 	<li>Login to Vendors</li>
	 * 	<li>Open the order</li>
	 * 	<li>Verify the comment did not get passed</li>
	 * 	<li>Verify order fee is $300</li>
	 * 	<li>Verify Payment Method</li>
	 * 	<li>Log test</li>
* </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Vendor Selection Settings", "Secure - VMP XSite Settings", "VMP - Create Order", "Vendors - Decline Order", "Automatic Assignment Settings"}, alwaysRun=true)
	public void vendorsFeeNoVMPComment() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		password = "T3sting1";
		
		// Log in to Secure
		secure.login(driver, userSecure, StoredVariables.getpassword().get());

		// Go to Vendor Selection Settings
		secure.goToVendorSelectionSettings(driver);
		
		// Set changed boolean
		boolean changed = false;

		// Turn on Automatic vendor selection
		if (SVendorSelectionSettings.automaticVendorSelection_switch(driver).getAttribute("src").contains("switchOff.png")) {
			perform.click(driver, SVendorSelectionSettings.automaticVendorSelection_switch(driver));
			changed = true;
		}

		// Turn on Unattended Order Assignment
		if (SVendorSelectionSettings.unattendedOrderAssignment_switch(driver).getAttribute("src").contains("switchOff.png"))
		{
			// Click the Off switch
			perform.click(driver, SVendorSelectionSettings.unattendedOrderAssignment_switch(driver));
			
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			// Click OK
			perform.click(driver, SVendorSelectionSettings.unattendedOrderAssignmentDialogOk_btn(driver));
			changed = true;
		}

		// Turn on Unattended Order Reassignment
		if (SVendorSelectionSettings.unattendedOrderReassignment_switch(driver).getAttribute("src").contains("switchOff.png"))
		{
			perform.click(driver, SVendorSelectionSettings.unattendedOrderReassignment_switch(driver));
			changed = true;
		}
		
		// Save settings
		if (changed==true) {
			secure.saveVendorSelectionSettings(driver);	
		}
		
		// Go to VMP XSite settings
		secure.goToVMPXSites(driver);
		
		// Click Configure Automatic Settings
		perform.click(driver, SVMPXSites.configureAutomaticSettings_lnk(driver));
		
		// Wait for Do not pass checkbox
		perform.waitForElementToBeClickable(driver, SVMPXSites.doNotPassVMPCommentsToTheVendor_chkbx(), "id");
		
		// Verify elements on the page exists
		Assert.assertTrue(SVMPXSites.doNotPassVMPCommentsToTheVendor_chkbx(driver).isDisplayed(), "The Do not pass VMP Comments to the vendor checkbox is missing from the page");
		Assert.assertTrue(SVMPXSites.assignSupplementalOrdersToTheVendorThatCompletedTheOriginalAppraisal_chkbx(driver).isDisplayed(), "The Assign supplemental orders to the vendor that completed the original appraisal checkbox is missing from the page");
		Assert.assertTrue(SVMPXSites.useFeeWhenAssigningOrders_dropdown(driver).isDisplayed(), "The Use fee when assigning orders dropdown is missing from the page");
		Assert.assertTrue(SVMPXSites.useVendorOverrideFeeWheneverPossible_chkbx(driver).isDisplayed(), "The Use vendor override fee whenever possible checkbox is missing from the page");
		Assert.assertTrue(SVMPXSites.alwaysUseTheNewVendorsPublishedFeeWhenReassigningAnOrder_chkbx(driver).isDisplayed(), "The Always use the new vendor's published fee when re-assigning an order checkbox is missing from the page");
		Assert.assertTrue(SVMPXSites.applyPercentOfTheVMPXSiteFeeAsTheVendorsFee_txtbx(driver).isDisplayed(), "The Apply % of the VMP XSite fee as the vendor's fee textbox is missing from the page");
		Assert.assertTrue(SVMPXSites.setThePaymentMethodTo_dropdown(driver).isDisplayed(), "The Set the payment method to dropdown is missing from the page");

		// Check Do not pass VMP Comments to the vendor checkbox
		perform.checkCheckbox(driver, SVMPXSites.doNotPassVMPCommentsToTheVendor_chkbx(driver));
		
		// Uncheck Assign supplemental orders to the vendor that completed the original appraisal checkbox
		perform.uncheckCheckbox(driver, SVMPXSites.assignSupplementalOrdersToTheVendorThatCompletedTheOriginalAppraisal_chkbx(driver));
		
		// Verify "vendor's published fee" is selected when assigning orders dropdown
		perform.selectDropdownOption(driver, SVMPXSites.useFeeWhenAssigningOrders_dropdown(driver), "vendor's published fee");
		
		// Check Use vendor override fee whenever possible
		perform.checkCheckbox(driver, SVMPXSites.useVendorOverrideFeeWheneverPossible_chkbx(driver));
		
		// Check Always use the new vendor's published fee when re-assigning an order checkbox
		perform.checkCheckbox(driver, SVMPXSites.alwaysUseTheNewVendorsPublishedFeeWhenReassigningAnOrder_chkbx(driver));
		
		// Verify % VMP fee is grayed out
		String attr = SVMPXSites.applyPercentOfTheVMPXSiteFeeAsTheVendorsFee_txtbx(driver).getAttribute("disabled");
		Assert.assertTrue(attr.equals("true"), "The % VMP fee should be grayed out");
		
		// Set the payment method to COD
		perform.selectDropdownOption(driver, SVMPXSites.setThePaymentMethodTo_dropdown(driver), "C.O.D.");
		
		// Save settings
		secure.saveVMPXSiteSettings(driver);
		
		// Login to VMP Client Portal
		vmp.login(driver, userSecure, userVMP, password);
		
		// Set variables for new order
		vmp.setVariables(driver);
		
		// Place an order from VMP Client Portal
		vmp.createVMPOrder(driver);
		
		// Get order numbers
		db.getLoanIDsFromVMPClientPortalOrder(driver);
		
		// Login to Secure
		secure.login(driver, userSecure, password);
		
		// Find the order
		String trackingNumber = StoredVariables.gettrackingNumber().get();
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Open the order
		secure.openOrder(driver, trackingNumber);
		
		// Verify order details
		secure.verifyResidentialAppraisalOrderDetails(driver);
		
		// Get the vendor assigned to the order
		String loanID = StoredVariables.getloanID().get();
		userVendors = db.getVendorEmailFromLoanID(driver, loanID);
		System.out.println("Vendor = " + userVendors);
		
		// Login to Vendors 
		vendors.login(driver, userVendors, password);
		
		// Open the order
		vendors.findAndOpenOrder(driver, trackingNumber);
		
		// Verify the comment did not get passed
		String comments = VOrderDetails.additionalComments_txt(driver).getText();
		Assert.assertTrue(!comments.contains("These are test additional comments"), "The VMP comment should not get passed to the appraiser");
		
		// Verify order fee is $300
		Assert.assertTrue(VOrderDetails.orderFee_txt(driver).getText().equals("$300"), "The Order Fee should be $300");
		
		// Verify Payment Method
		Assert.assertTrue(VOrderDetails.paymentMethod_txtbx(driver).getText().equals("C.O.D."), "The Payment Method should be C.O.D.");
		
		// Decline the order
		vendors.declineOrder(driver, trackingNumber);
		
		// Get the vendor reassigned to the order
		userVendors = db.getVendorEmailFromLoanID(driver, loanID);
		System.out.println("Vendor = " + userVendors);
		
		// Login to Vendors 
		vendors.login(driver, userVendors, password);
		
		// Open the order
		vendors.findAndOpenOrder(driver, trackingNumber);
		
		// Verify the comment did not get passed
		comments = VOrderDetails.additionalComments_txt(driver).getText();
		Assert.assertTrue(!comments.contains("These are test additional comments"), "The VMP comment should not get passed to the appraiser");
		
		// Verify order fee is $300
		Assert.assertTrue(VOrderDetails.orderFee_txt(driver).getText().equals("$300"), "The Order Fee should be $300");
		
		// Verify Payment Method
		Assert.assertTrue(VOrderDetails.paymentMethod_txtbx(driver).getText().equals("C.O.D."), "The Payment Method should be C.O.D.");
		
		// Log test
		test.log(LogStatus.INFO, "Automatic Assignment Settings", "Verified vendor's fee is used and the VMP comment is not passed");
		
	} // end vendorsFeeNoVMPComment
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Go to Vendor Selection Settings</li>
	 * 	<li>Set changed boolean</li>
	 * 	<li>Turn on Automatic vendor selection</li>
	 * 	<li>Turn on Unattended Order Assignment</li>
	 * 	<li>Click the Off switch</li>
	 * 	<li>Click OK</li>
	 * 	<li>Turn on Unattended Order Reassignment</li>
	 * 	<li>Save settings</li>
	 * 	<li>Go to VMP XSite settings</li>
	 * 	<li>Click Configure Automatic Settings</li>
	 * 	<li>Verify elements on the page exists</li>
	 * 	<li>Uncheck Do not pass VMP Comments to the vendor checkbox</li>
	 * 	<li>Uncheck Assign supplemental orders to the vendor that completed the original appraisal checkbox</li>
	 * 	<li>Verify "vendor's published fee" is selected when assigning orders dropdown</li>
	 * 	<li>Check Use vendor override fee whenever possible</li>
	 * 	<li>Verify % VMP fee is grayed out</li>
	 * 	<li>Set the payment method to PayPal</li>
	 * 	<li>Save settings</li>
	 * 	<li>Login to VMP Client Portal</li>
	 * 	<li>Set variables for new order</li>
	 * 	<li>Place an order from VMP Client Portal</li>
	 * 	<li>Get order numbers</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Get the vendor assigned to the order</li>
	 * 	<li>Login to Vendors</li>
	 * 	<li>Open the order</li>
	 * 	<li>Verify the comment did not get passed</li>
	 * 	<li>Verify order fee is $500</li>
	 * 	<li>Verify Payment Method</li>
	 * 	<li>Log test</li>
* </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Vendor Selection Settings", "Secure - VMP XSite Settings", "VMP - Create Order", "Automatic Assignment Settings"}, alwaysRun=true)
	public void vendorsFeeWithVMPComment() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		password = "T3sting1";
		
		// Log in to Secure
		secure.login(driver, userSecure, StoredVariables.getpassword().get());

		// Go to Vendor Selection Settings
		secure.goToVendorSelectionSettings(driver);
		
		// Set changed boolean
		boolean changed = false;

		// Turn on Automatic vendor selection
		if (SVendorSelectionSettings.automaticVendorSelection_switch(driver).getAttribute("src").contains("switchOff.png")) {
			perform.click(driver, SVendorSelectionSettings.automaticVendorSelection_switch(driver));
			changed = true;
		}

		// Turn on Unattended Order Assignment
		if (SVendorSelectionSettings.unattendedOrderAssignment_switch(driver).getAttribute("src").contains("switchOff.png"))
		{
			// Click the Off switch
			perform.click(driver, SVendorSelectionSettings.unattendedOrderAssignment_switch(driver));
			
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			// Click OK
			perform.click(driver, SVendorSelectionSettings.unattendedOrderAssignmentDialogOk_btn(driver));
			changed = true;
		}

		// Turn on Unattended Order Reassignment
		if (SVendorSelectionSettings.unattendedOrderReassignment_switch(driver).getAttribute("src").contains("switchOff.png"))
		{
			perform.click(driver, SVendorSelectionSettings.unattendedOrderReassignment_switch(driver));
			changed = true;
		}
		
		// Save settings
		if (changed==true) {
			secure.saveVendorSelectionSettings(driver);	
		}
		
		// Go to VMP XSite settings
		secure.goToVMPXSites(driver);
		
		// Click Configure Automatic Settings
		perform.click(driver, SVMPXSites.configureAutomaticSettings_lnk(driver));
		
		// Wait for Do not pass checkbox
		perform.waitForElementToBeClickable(driver, SVMPXSites.doNotPassVMPCommentsToTheVendor_chkbx(), "id");
		
		// Verify elements on the page exists
		Assert.assertTrue(SVMPXSites.doNotPassVMPCommentsToTheVendor_chkbx(driver).isDisplayed(), "The Do not pass VMP Comments to the vendor checkbox is missing from the page");
		Assert.assertTrue(SVMPXSites.assignSupplementalOrdersToTheVendorThatCompletedTheOriginalAppraisal_chkbx(driver).isDisplayed(), "The Assign supplemental orders to the vendor that completed the original appraisal checkbox is missing from the page");
		Assert.assertTrue(SVMPXSites.useFeeWhenAssigningOrders_dropdown(driver).isDisplayed(), "The Use fee when assigning orders dropdown is missing from the page");
		Assert.assertTrue(SVMPXSites.useVendorOverrideFeeWheneverPossible_chkbx(driver).isDisplayed(), "The Use vendor override fee whenever possible checkbox is missing from the page");
		Assert.assertTrue(SVMPXSites.alwaysUseTheNewVendorsPublishedFeeWhenReassigningAnOrder_chkbx(driver).isDisplayed(), "The Always use the new vendor's published fee when re-assigning an order checkbox is missing from the page");
		Assert.assertTrue(SVMPXSites.applyPercentOfTheVMPXSiteFeeAsTheVendorsFee_txtbx(driver).isDisplayed(), "The Apply % of the VMP XSite fee as the vendor's fee textbox is missing from the page");
		Assert.assertTrue(SVMPXSites.setThePaymentMethodTo_dropdown(driver).isDisplayed(), "The Set the payment method to dropdown is missing from the page");

		// Uncheck Do not pass VMP Comments to the vendor checkbox
		perform.uncheckCheckbox(driver, SVMPXSites.doNotPassVMPCommentsToTheVendor_chkbx(driver));
		
		// Uncheck Assign supplemental orders to the vendor that completed the original appraisal checkbox
		perform.uncheckCheckbox(driver, SVMPXSites.assignSupplementalOrdersToTheVendorThatCompletedTheOriginalAppraisal_chkbx(driver));
		
		// Verify "vendor's published fee" is selected when assigning orders dropdown
		perform.selectDropdownOption(driver, SVMPXSites.useFeeWhenAssigningOrders_dropdown(driver), "my product fee");
		
		// Check Use vendor override fee whenever possible
		perform.checkCheckbox(driver, SVMPXSites.useVendorOverrideFeeWheneverPossible_chkbx(driver));
		
		// Verify % VMP fee is grayed out
		String attr = SVMPXSites.applyPercentOfTheVMPXSiteFeeAsTheVendorsFee_txtbx(driver).getAttribute("disabled");
		Assert.assertTrue(attr.equals("true"), "The % VMP fee should be grayed out");
		
		// Set the payment method to PayPal
		perform.selectDropdownOption(driver, SVMPXSites.setThePaymentMethodTo_dropdown(driver), "PayPal");
		
		// Save settings
		secure.saveVMPXSiteSettings(driver);
		
		// Login to VMP Client Portal
		vmp.login(driver, userSecure, userVMP, password);
		
		// Set variables for new order
		vmp.setVariables(driver);
		
		// Place an order from VMP Client Portal
		vmp.createVMPOrder(driver);
		
		// Get order numbers
		db.getLoanIDsFromVMPClientPortalOrder(driver);
		
		// Login to Secure
		secure.login(driver, userSecure, password);
		
		// Find the order
		String trackingNumber = StoredVariables.gettrackingNumber().get();
		String loanID = StoredVariables.getloanID().get();
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Open the order
		secure.openOrder(driver, trackingNumber);
		
		// Verify order details
		secure.verifyResidentialAppraisalOrderDetails(driver);
		
		// Get the vendor assigned to the order
		userVendors = db.getVendorEmailFromLoanID(driver, loanID);
		System.out.println("Vendor = " + userVendors);
		
		// Login to Vendors 
		vendors.login(driver, userVendors, password);
		
		// Open the order
		vendors.findAndOpenOrder(driver, trackingNumber);
		
		// Verify the comment did not get passed
		String comments = VOrderDetails.additionalComments_txt(driver).getText();
		Assert.assertTrue(comments.contains("These are test additional comments"), "The VMP comment should not get passed to the appraiser");
		
		// Verify order fee is $500
		Assert.assertTrue(VOrderDetails.orderFee_txt(driver).getText().equals("$500"), "The Order Fee should be $500");
		
		// Verify Payment Method
		Assert.assertTrue(VOrderDetails.paymentMethod_txtbx(driver).getText().equals("PayPal"), "The Payment Method should be C.O.D.");
		
		// Log test
		test.log(LogStatus.INFO, "Automatic Assignment Settings", "Verified vendor's fee is used");
		
	} // end vendorsFeeWithVMPComment
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Go to Vendor Selection Settings</li>
	 * 	<li>Set changed boolean</li>
	 * 	<li>Turn on Automatic vendor selection</li>
	 * 	<li>Turn on Unattended Order Assignment</li>
	 * 	<li>Click the Off switch</li>
	 * 	<li>Click OK</li>
	 * 	<li>Turn on Unattended Order Reassignment</li>
	 * 	<li>Save settings</li>
	 * 	<li>Go to VMP XSite settings</li>
	 * 	<li>Click Configure Automatic Settings</li>
	 * 	<li>Verify elements on the page exists</li>
	 * 	<li>Uncheck Do not pass VMP Comments to the vendor checkbox</li>
	 * 	<li>Check Assign supplemental orders to the vendor that completed the original appraisal checkbox</li>
	 * 	<li>Verify "vendor's published fee" is selected when assigning orders dropdown</li>
	 * 	<li>Uncheck Use vendor override fee whenever possible</li>
	 * 	<li>Verify Always use the new vendor's published fee when re-assigning an order is grayed out</li>
	 * 	<li>Set the % of XSite Fee to 50</li>
	 * 	<li>Set the payment method to Money order</li>
	 * 	<li>Save settings</li>
	 * 	<li>Login to VMP Client Portal</li>
	 * 	<li>Set variables for new order</li>
	 * 	<li>Place an order from VMP Client Portal</li>
	 * 	<li>Go to New Order</li>
	 * 	<li>Enter order details</li>
	 * 	<li>Click Next</li>
	 * 	<li>Enter the Order Fee</li>
	 * 	<li>Save the order</li>
	 * 	<li>Click Finished</li>
	 * 	<li>Click OK</li>
	 * 	<li>Get order numbers</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Get the vendor assigned to the order</li>
	 * 	<li>Login to Vendors</li>
	 * 	<li>Open the order</li>
	 * 	<li>Verify the comment did not get passed</li>
	 * 	<li>Verify order fee is $225</li>
	 * 	<li>Verify Payment Method</li>
	 * 	<li>Accept the order</li>
	 * 	<li>Login to VMP Client Portal</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Click Other Actions</li>
	 * 	<li>Duplicate VMP order</li>
	 * 	<li>Select 1004D (3/05) Update/Completion Form</li>
	 * 	<li>Select the Order Due date</li>
	 * 	<li>Enter Order Due date</li>
	 * 	<li>Click the Order Due calendar button</li>
	 * 	<li>Select the date</li>
	 * 	<li>Verify the correct order due date is correct</li>
	 * 	<li>Change the Directions for Order Number lookup purposes</li>
	 * 	<li>Click Next</li>
	 * 	<li>Enter the Order Fee</li>
	 * 	<li>Save the order</li>
	 * 	<li>Click Finished</li>
	 * 	<li>Click OK</li>
	 * 	<li>Get order numbers</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Get the vendor assigned to the order</li>
	 * 	<li>Order should be assigned to the same appraiser</li>
	 * 	<li>Login to Vendors</li>
	 * 	<li>Open the order</li>
	 * 	<li>Verify the comment did not get passed</li>
	 * 	<li>Verify order fee is $325</li>
	 * 	<li>Verify Payment Method</li>
	 * 	<li>Log test</li>
* </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Vendor Selection Settings", "Secure - VMP XSite Settings", "VMP - Create Order", "Vendors - Accept Order", "VMP - Duplicate VMP Order", "Automatic Assignment Settings"}, alwaysRun=true)
	public void VMPXSiteFeeWithVMPComment() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		password = "T3sting1";
		
		// Log in to Secure
		secure.login(driver, userSecure, StoredVariables.getpassword().get());

		// Go to Vendor Selection Settings
		secure.goToVendorSelectionSettings(driver);
		
		// Set changed boolean
		boolean changed = false;

		// Turn on Automatic vendor selection
		if (SVendorSelectionSettings.automaticVendorSelection_switch(driver).getAttribute("src").contains("switchOff.png")) {
			perform.click(driver, SVendorSelectionSettings.automaticVendorSelection_switch(driver));
			changed = true;
		}

		// Turn on Unattended Order Assignment
		if (SVendorSelectionSettings.unattendedOrderAssignment_switch(driver).getAttribute("src").contains("switchOff.png"))
		{
			// Click the Off switch
			perform.click(driver, SVendorSelectionSettings.unattendedOrderAssignment_switch(driver));
			
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			// Click OK
			perform.click(driver, SVendorSelectionSettings.unattendedOrderAssignmentDialogOk_btn(driver));
			changed = true;
		}

		// Turn on Unattended Order Reassignment
		if (SVendorSelectionSettings.unattendedOrderReassignment_switch(driver).getAttribute("src").contains("switchOff.png"))
		{
			perform.click(driver, SVendorSelectionSettings.unattendedOrderReassignment_switch(driver));
			changed = true;
		}
		
		// Save settings
		if (changed==true) {
			secure.saveVendorSelectionSettings(driver);	
		}
		
		// Go to VMP XSite settings
		secure.goToVMPXSites(driver);
		
		// Click Configure Automatic Settings
		perform.click(driver, SVMPXSites.configureAutomaticSettings_lnk(driver));
		
		// Wait for Do not pass checkbox
		perform.waitForElementToBeClickable(driver, SVMPXSites.doNotPassVMPCommentsToTheVendor_chkbx(), "id");
		
		// Verify elements on the page exists
		Assert.assertTrue(SVMPXSites.doNotPassVMPCommentsToTheVendor_chkbx(driver).isDisplayed(), "The Do not pass VMP Comments to the vendor checkbox is missing from the page");
		Assert.assertTrue(SVMPXSites.assignSupplementalOrdersToTheVendorThatCompletedTheOriginalAppraisal_chkbx(driver).isDisplayed(), "The Assign supplemental orders to the vendor that completed the original appraisal checkbox is missing from the page");
		Assert.assertTrue(SVMPXSites.useFeeWhenAssigningOrders_dropdown(driver).isDisplayed(), "The Use fee when assigning orders dropdown is missing from the page");
		Assert.assertTrue(SVMPXSites.useVendorOverrideFeeWheneverPossible_chkbx(driver).isDisplayed(), "The Use vendor override fee whenever possible checkbox is missing from the page");
		Assert.assertTrue(SVMPXSites.alwaysUseTheNewVendorsPublishedFeeWhenReassigningAnOrder_chkbx(driver).isDisplayed(), "The Always use the new vendor's published fee when re-assigning an order checkbox is missing from the page");
		Assert.assertTrue(SVMPXSites.applyPercentOfTheVMPXSiteFeeAsTheVendorsFee_txtbx(driver).isDisplayed(), "The Apply % of the VMP XSite fee as the vendor's fee textbox is missing from the page");
		Assert.assertTrue(SVMPXSites.setThePaymentMethodTo_dropdown(driver).isDisplayed(), "The Set the payment method to dropdown is missing from the page");

		// Uncheck Do not pass VMP Comments to the vendor checkbox
		perform.uncheckCheckbox(driver, SVMPXSites.doNotPassVMPCommentsToTheVendor_chkbx(driver));
		
		// Check Assign supplemental orders to the vendor that completed the original appraisal checkbox
		perform.checkCheckbox(driver, SVMPXSites.assignSupplementalOrdersToTheVendorThatCompletedTheOriginalAppraisal_chkbx(driver));
		
		// Verify "vendor's published fee" is selected when assigning orders dropdown
		perform.selectDropdownOption(driver, SVMPXSites.useFeeWhenAssigningOrders_dropdown(driver), "VMP XSite fee");
		
		// Uncheck Use vendor override fee whenever possible
		perform.uncheckCheckbox(driver, SVMPXSites.useVendorOverrideFeeWheneverPossible_chkbx(driver));
		
		// Verify Always use the new vendor's published fee when re-assigning an order is grayed out
		String attr = SVMPXSites.alwaysUseTheNewVendorsPublishedFeeWhenReassigningAnOrder_chkbx(driver).getAttribute("disabled");
		Assert.assertTrue(attr.equals("true"), "The Always use the new vendor's published fee when re-assigning an order checkbox should be grayed out");
		
		// Set the % of XSite Fee to 50
		SVMPXSites.applyPercentOfTheVMPXSiteFeeAsTheVendorsFee_txtbx(driver).clear();
		perform.type(driver,SVMPXSites.applyPercentOfTheVMPXSiteFeeAsTheVendorsFee_txtbx(driver), "50");
		
		// Set the payment method to Money order
		String paymentMethod = "";
		String env = StoredVariables.getusernameEnvironment().get();
		if (env.equals("QA")) {
			paymentMethod = "Money order";
		}
		else {
			paymentMethod = "Money Order";
		}
		perform.selectDropdownOption(driver, SVMPXSites.setThePaymentMethodTo_dropdown(driver), paymentMethod);
		
		// Save settings
		secure.saveVMPXSiteSettings(driver);
		
		// Login to VMP Client Portal
		vmp.login(driver, userSecure, userVMP, password);
		
		// Set variables for new order
		vmp.setVariables(driver);
		
		// Place an order from VMP Client Portal
		// Go to New Order
		vmp.goToNewOrder(driver);
		
		// Enter order details
		vmp.enterNewOrder(driver);
		
		// Click Next
		perform.click(driver, VMPNewOrder.nextBottom_btn(driver));
		
		// Handle address mismatch
		vmp.handleAddressMismatch(driver);
		
		// Wait for the Order Fee textbox
		perform.waitForElementToBeClickable(driver, VMPConfirmOrder.orderFee_txtbx(), "id");
		
		// Enter the Order Fee
		VMPConfirmOrder.orderFee_txtbx(driver).clear();
		perform.type(driver,VMPConfirmOrder.orderFee_txtbx(driver), "450");
		
		// Save the order
		vmp.saveNewOrder(driver);
		
		// Click Finished
		perform.click(driver, VMPConfirmOrder.finished_btn(driver));
		
		// Switch out of iFrame
		driver.switchTo().defaultContent();
		
		// Click OK
		perform.click(driver, VMPConfirmOrder.ok_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Wait for Find textbox
		perform.waitForElementToBeClickable(driver, VMPOrders.find_txtbx(), "id");
		
		// Get order numbers
		db.getLoanIDsFromVMPClientPortalOrder(driver);
		String vmpTrackingNumber = StoredVariables.gettrackingNumberVMP().get();
		String trackingNumber = StoredVariables.gettrackingNumber().get();
		String loanID = StoredVariables.getloanID().get();
		System.out.println("VMP Order Number = " + vmpTrackingNumber);
		System.out.println("Order Number = " + trackingNumber);
		
		// Login to Secure
		secure.login(driver, userSecure, password);
		
		// Find the order
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Open the order
		secure.openOrder(driver, trackingNumber);
		
		// Verify order details
		secure.verifyResidentialAppraisalOrderDetails(driver);
		
		// Get the vendor assigned to the order
		userVendors = db.getVendorEmailFromLoanID(driver, loanID);
		System.out.println("Vendor = " + userVendors);
		
		// Login to Vendors 
		vendors.login(driver, userVendors, password);
		
		// Open the order
		vendors.findAndOpenOrder(driver, trackingNumber);
		
		// Verify the comment did not get passed
		String comments = VOrderDetails.additionalComments_txt(driver).getText();
		Assert.assertTrue(comments.contains("These are test additional comments"), "The VMP comment should not get passed to the appraiser");
		
		// Verify order fee is $225
		Assert.assertTrue(VOrderDetails.orderFee_txt(driver).getText().equals("$225"), "The Order Fee should be $225");
		
		// Verify Payment Method
		Assert.assertTrue(VOrderDetails.paymentMethod_txtbx(driver).getText().equals(paymentMethod), "The Payment Method should be " + paymentMethod);
		
		// Accept the order
		vendors.acceptOrder(driver, trackingNumber);
		
		// Login to VMP Client Portal
		vmp.login(driver, userSecure, userVMP, password);
		
		// Find the order
		vmp.findOrder(driver, vmpTrackingNumber, "Tracking #");
		
		// Open the order
		vmp.openOrder(driver, vmpTrackingNumber);
		
		// Click Other Actions
		perform.click(driver, VMPAppraisalOrderDetails.otherActions_btn(driver));
		
		// Duplicate VMP order
		perform.click(driver, VMPAppraisalOrderDetails.duplicateOrder_btn(driver));
		
		// Wait for Address textbox
		perform.waitForElementToBeClickable(driver, VMPNewOrder.address_txtbx(), "id");
		
		// Select 1004D (3/05) Update/Completion Form
		StoredVariables.getassignmentInformationForm().set("1004D (3/05) Update/Completion");
		perform.selectDropdownOption(driver, VMPNewOrder.form_dropdown(driver), "1004D (3/05) Update/Completion");
		
		// Select the Order Due date
		if (StoredVariables.getbrowser().get().equals("PhantomJS") || StoredVariables.getbrowser().get().equals("HtmlUnit") || StoredVariables.getbrowser().get().equals("IE") || StoredVariables.getmobile().get()==true)
		{
			// Enter Order Due date
			perform.type(driver,VMPNewOrder.orderDue_txtbx(driver), StoredVariables.getorderDueDateLong().get());
		}
		else
		{
			// Click the Order Due calendar button
			perform.click(driver, VMPNewOrder.orderDueCalendar_btn(driver));
			
			// Select the date
			vmp.selectDateFromCalendar(driver, StoredVariables.getassignmentInformationOrderDue().get());
			
			// Verify the correct order due date is correct
			Assert.assertTrue(VMPNewOrder.orderDue_txtbx(driver).getAttribute("value").equals(StoredVariables.getcalendarDateLong().get()), "Date selected from calendar is the wrong date. Trying to match - " + StoredVariables.getcalendarDateLong().get());
		}
		
		// Change the Directions for Order Number lookup purposes
		String directions = perform.randomNumbers(driver, 10);
		StoredVariables.getpropertyInformationDirections().set("");
		StoredVariables.getdirectionsIdentifier().set(directions);
		VMPNewOrder.directions_txtbx(driver).clear();
		perform.type(driver,VMPNewOrder.directions_txtbx(driver), directions);
		
		// Click Next
		perform.click(driver, VMPNewOrder.nextTop_btn(driver));
		
		// Handle Address Mismatch
		vmp.handleAddressMismatch(driver);
		
		// Wait for the Order Fee textbox
		perform.waitForElementToBeClickable(driver, VMPConfirmOrder.orderFee_txtbx(), "id");
		
		// Enter the Order Fee
		VMPConfirmOrder.orderFee_txtbx(driver).clear();
		perform.type(driver,VMPConfirmOrder.orderFee_txtbx(driver), "650");
		
		// Save the order
		vmp.saveNewOrder(driver);
		
		// Click Finished
		perform.click(driver, VMPConfirmOrder.finished_btn(driver));
		
		// Switch out of iFrame
		driver.switchTo().defaultContent();
		
		// Click OK
		perform.click(driver, VMPConfirmOrder.ok_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Wait for Find textbox
		perform.waitForElementToBeClickable(driver, VMPOrders.find_txtbx(), "id");
		
		// Get order numbers
		db.getLoanIDsFromVMPClientPortalOrder(driver);
		
		// Login to Secure
		secure.login(driver, userSecure, password);
		
		// Find the order
		trackingNumber = StoredVariables.gettrackingNumber().get();
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Open the order
		secure.openOrder(driver, trackingNumber);
		
		// Verify order details
		secure.verifyResidentialAppraisalOrderDetails(driver);
		
		// Get the vendor assigned to the order
		String userVendors2 = db.getVendorEmailFromLoanID(driver, StoredVariables.getloanID().get());
		System.out.println("Vendor = " + userVendors2);
		
		// Order should be assigned to the same appraiser
		Assert.assertTrue(userVendors.equals(userVendors2), "The order should have been assigned to the same appraiser. The original vendor was " + userVendors + " and the new vendor is " + userVendors2);
		
		// Login to Vendors 
		vendors.login(driver, userVendors2, password);
		
		// Open the order
		vendors.findAndOpenOrder(driver, trackingNumber);
		
		// Verify the comment did not get passed
		comments = VOrderDetails.additionalComments_txt(driver).getText();
		Assert.assertTrue(comments.contains("These are test additional comments"), "The VMP comment should not get passed to the appraiser");
		
		// Verify order fee is $325
		Assert.assertTrue(VOrderDetails.orderFee_txt(driver).getText().equals("$325"), "The Order Fee should be $325");
		
		// Verify Payment Method
		Assert.assertTrue(VOrderDetails.paymentMethod_txtbx(driver).getText().equals(paymentMethod), "The Payment Method should be " + paymentMethod);
		
		// Log test
		test.log(LogStatus.INFO, "Automatic Assignment Settings", "Verified VMP XSite  fee is used");
		
	} // end VMPXSiteFeeWithVMPComment
	
} // end the AutomaticAssignmentSettings class
