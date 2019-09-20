package regressionResidentialBidding;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Secure.SAwardBid;
import pageObjects.Secure.SConfirmOrder;
import pageObjects.Secure.SNewOrder;
import pageObjects.Secure.SOrderDetails;
import pageObjects.Secure.SProfile;
import pageObjects.Secure.SReviewBids;
import pageObjects.Secure.SUsers;
import pageObjects.Secure.SVendorSelection;
import pageObjects.Secure.SVendorSelectionSettings;
import pageObjects.Vendors.VOrderDetails;
import pageObjects.Vendors.VOrders;
import pageObjects.Vendors.VQuickList;
import pageObjects.Vendors.VSubmitBid;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Residential Bidding - Fee And Date Unlocked</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class FeeAndDateUnlocked extends TestSetup {

	/** The user secure. */
	private final String userSecure = "ResBidding2";
	
	/** The user secure SU. */
	private final String userSecureSU = "ResBidding2SU";
	
	/** The user vendors. */
	private final String userVendors = "Appraiser1";

/** The password. */
//	private String userVMP = "OriginatorResBidding2";
	private final String password = "T3sting1";
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Go to Vendor Selection Settings</li>
	 * 	<li>Set changed boolean</li>
	 * 	<li>Turn off Automatic vendor selection</li>
	 * 	<li>Turn off Unattended Order Assignment</li>
	 * 	<li>Click OK</li>
	 * 	<li>Turn off Unattended Order Reassignment</li>
	 * 	<li>Confirm there is an option in the Residential appraisal selection section for Allow order bidding</li>
	 * 	<li>Enable Allow order bidding</li>
	 * 	<li>Confirm it has two sub options to lock or unlock the Fee and Date</li>
	 * 	<li>Unlock Fee and Date Locks</li>
	 * 	<li>Confirm the locks are unlocked</li>
	 * 	<li>Confirm under Ordering options section &gt; default order expiration time, there is a sub option for Default bid due</li>
	 * 	<li>Confirm the default bid due time is 12 hours</li>
	 * 	<li>Save settings</li>
	 * 	<li>Go to Users</li>
	 * 	<li>Select the sub user</li>
	 * 	<li>Click the hyperlink in the permission Edit/Update Orders</li>
	 * 	<li>Confirm there is an option for Issue/Review Bids</li>
	 * 	<li>Uncheck the Issue/Review Bids permission for the sub user</li>
	 * 	<li>Click OK</li>
	 * 	<li>Check View/Manage Other Users' Orders</li>
	 * 	<li>Save</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Create a Residential Order</li>
	 * 	<li>Set variables</li>
	 * 	<li>Enter order info</li>
	 * 	<li>Click Edit Order Groups</li>
	 * 	<li>Switch focus to new dialog box iFrame</li>
	 * 	<li>Select Order Group To Add</li>
	 * 	<li>Create WebElement for Available Groups</li>
	 * 	<li>List all the options in Available Groups</li>
	 * 	<li>Loop through all Available Groups and click on the desired one</li>
	 * 	<li>click the desired option</li>
	 * 	<li>Add selected group to Eligible Vendors</li>
	 * 	<li>Click OK</li>
	 * 	<li>Switch to original iFrame</li>
	 * 	<li>Set Order Due Date (Long and Short)</li>
	 * 	<li>Set Disclosure Date (Long and Short)</li>
	 * 	<li>Select Disclosure Date</li>
	 * 	<li>Enter Order Due date</li>
	 * 	<li>Click calendar for Disclosure</li>
	 * 	<li>Select the date</li>
	 * 	<li>Verify the date is correct</li>
	 * 	<li>Assigned To</li>
	 * 	<li>Click Issue as Bid Yes radio button</li>
	 * 	<li>Verify Fee lock is unlocked</li>
	 * 	<li>Verify Date lock is unlocked</li>
	 * 	<li>Click Next</li>
	 * 	<li>Select available vendors and confirm selected vendors show in the Selected Vendors pod on the right</li>
	 * 	<li>Select Appraiser1</li>
	 * 	<li>Select Appraiser3</li>
	 * 	<li>Verify which line is Appraiser1 and set the Profile button</li>
	 * 	<li>View the Vendor Profile</li>
	 * 	<li>Click the Products tab</li>
	 * 	<li>Check the box 'Always pay the transaction fee for this vendor.'</li>
	 * 	<li>Click Save</li>
	 * 	<li>Verify which line is Appraiser3 and set the Profile button</li>
	 * 	<li>View the Vendor Profile</li>
	 * 	<li>Click the Products tab</li>
	 * 	<li>Uncheck the box 'Always pay the transaction fee for this vendor.'</li>
	 * 	<li>Click Save</li>
	 * 	<li>Click Next</li>
	 * 	<li>Confirm there is a Bidding information pod on the confirmation step</li>
	 * 	<li>Confirm the selected vendors display in the Bidding information pod</li>
	 * 	<li>Verify the Fee and Date are not displayed</li>
	 * 	<li>Click I agree to pay the Mercury transaction fee</li>
	 * 	<li>Click Finish</li>
	 * 	<li>Click Finished</li>
	 * 	<li>Get order number</li>
	 * 	<li>Log the tracking number</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Confirm the order is placed</li>
	 * 	<li>Confirm there is an Issue as bid field in Assignment information</li>
	 * 	<li>Confirm the locks for Fee and Date show as locked as the order was placed with them locked</li>
	 * 	<li>Log in as the vendor with the transaction fee paid for by the client</li>
	 * 	<li>Open the order</li>
	 * 	<li>Confirm the status shows Bid Pending</li>
	 * 	<li>Confirm the Order Fee value is blank</li>
	 * 	<li>Confirm the Due Date value is displayed in purple text</li>
	 * 	<li>Confirm there is a Submit Bid button instead of Accept/Decline Assignment</li>
	 * 	<li>Click Submit Bid</li>
	 * 	<li>Confirm there is a message stating the vendor will not be charged the fee as the client is covering the fee</li>
	 * 	<li>Confirm Submit is currently not active and cannot be clicked</li>
	 * 	<li>Enter Appraisal bid amount</li>
	 * 	<li>Enter Turn time</li>
	 * 	<li>Estimated due date</li>
	 * 	<li>Confirm you can add a message to the client</li>
	 * 	<li>Confirm you can use the QuickList icon to add and use a QuickList item</li>
	 * 	<li>Open the QL dialog</li>
	 * 	<li>Delete any existing QL items</li>
	 * 	<li>Create a new QL item</li>
	 * 	<li>Select the first QL item</li>
	 * 	<li>Click Use</li>
	 * 	<li>Switch to Submit Bid iFrame</li>
	 * 	<li>Verify the new QL item is displayed</li>
	 * 	<li>Confirm you can now click on Submit</li>
	 * 	<li>Click Submit</li>
	 * 	<li>Confirm the Submit Bid button now states Update Bid</li>
	 * 	<li>Confirm there is an audit trail event showing any vendor notes and the vendor agreed to the bid terms</li>
	 * 	<li>Log in as the vendor who will be paying the transaction fee</li>
	 * 	<li>View the order details</li>
	 * 	<li>Click Submit Bid</li>
	 * 	<li>Switch to iFrame</li>
	 * 	<li>Confirm the message shows the vendor will be responsible for the transaction fee</li>
	 * 	<li>Confirm the transaction fee amount is displayed and includes any sales tax if applicable</li>
	 * 	<li>Confirm the Submit button is not active and cannot be clicked</li>
	 * 	<li>Enter Appraisal bid amount</li>
	 * 	<li>Enter Turn time</li>
	 * 	<li>Estimated due date</li>
	 * 	<li>Switch to iFrame</li>
	 * 	<li>Grab the estimated due date</li>
	 * 	<li>Confirm you can add a message to the client</li>
	 * 	<li>Click on Submit</li>
	 * 	<li>Click Update Bid</li>
	 * 	<li>Switch to iFrame</li>
	 * 	<li>Click I am unable to bid on this opportunity</li>
	 * 	<li>Verify Appraisal bid and Turn time textboxes are now blank</li>
	 * 	<li>Add notes to the client</li>
	 * 	<li>Click on Submit</li>
	 * 	<li>Confirm the vendor receives the Are you sure message stating</li>
	 * 	<li>Click Decline</li>
	 * 	<li>Confirm the vendor receives the Success message stating 'The client will be notified you are unable to bid at this time.'</li>
	 * 	<li>Click OK</li>
	 * 	<li>Go to Orders</li>
	 * 	<li>Search for the order</li>
	 * 	<li>Verify the order is not found</li>
	 * 	<li>From Secure Mercury Network:</li>
	 * 	<li>Log in as the sub user without Issue/Review Bids permission</li>
	 * 	<li>View the order details</li>
	 * 	<li>Confirm the Review bids option is not active and cannot be clicked on</li>
	 * 	<li>Log in as the Admin</li>
	 * 	<li>View the order details</li>
	 * 	<li>Confirm there are audit trail events for the vendor accepting the terms and the vendor declining to bid</li>
	 * 	<li>Click Review bids</li>
	 * 	<li>Switch into iframe</li>
	 * 	<li>Confirm it displays all selected vendors and any bid information</li>
	 * 	<li>Find Appraiser1 row</li>
	 * 	<li>Appraiser1 should display Bid Submitted</li>
	 * 	<li>Appraiser3 should display Vendor declined</li>
	 * 	<li>Confirm Award bid, Decline bid, and send message are not active until a vendor bid is selected in the list</li>
	 * 	<li>Select Appraiser1</li>
	 * 	<li>Confirm Award bid, Decline bid, and send message are active</li>
	 * 	<li>Click on Add Vendor</li>
	 * 	<li>Switch to default content</li>
	 * 	<li>Confirm the Add additional vendors displays with eligible vendors to choose from</li>
	 * 	<li>Select a vendor (not from a company currently selected)</li>
	 * 	<li>Click Next</li>
	 * 	<li>Confirm the additional vendor is displayed in Bidding information</li>
	 * 	<li>Confirm you cannot change the status of the Fee and Date locks</li>
	 * 	<li>Click Finish</li>
	 * 	<li>Confirm you are returned to the Review bids window</li>
	 * 	<li>Confirm the new vendor is listed</li>
	 * 	<li>Select Automation Appraiser1</li>
	 * 	<li>Confirm Award bid, Decline bid, and Send message are now active</li>
	 * 	<li>Click Award bid</li>
	 * 	<li>Switch to iFrame</li>
	 * 	<li>Confirm you can include an Award note</li>
	 * 	<li>Confirm the Order fee is displayed and cannot be changed</li>
	 * 	<li>Confirm you can change the payment method</li>
	 * 	<li>Verify ResBidAppraiser2 is in the Decline section</li>
	 * 	<li>Confirm you can enter a Decline note</li>
	 * 	<li>Confirm you can click Award</li>
	 * 	<li>Click Close on the attach document window</li>
	 * 	<li>Get the history text</li>
	 * 	<li>Confirm there is an audit trail event showing the bid awarded including the fee and date</li>
	 * 	<li>Confirm the order is automatically accepted by the vendor and there is an audit trail event</li>
	 * 	<li>Confirm there is bid decline info in the audit trail</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Residential Bidding", "Secure - Vendor Selection Settings", "Secure - Users", "Secure - Create Order", "Secure - Order Groups", "Secure - Orders", "Secure - Issue As Bid", "Secure - Vendor Profile", "Secure - Products", "Vendors - Orders",
			"Vendors - Submit Bid", "Vendors - QuickList", "Secure - Review Bids", "Secure - Send Message", "Secure - Decline Bid", "Secure - Award Bid"}, alwaysRun=true)
	public void feeAndDateUnlocked() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Log in to Secure
		secure.login(driver, userSecure, password);

		// Go to Vendor Selection Settings
		secure.goToVendorSelectionSettings(driver);
		
		// Set changed boolean
		boolean changed = false;
		
		// Turn off Automatic vendor selection
		if (SVendorSelectionSettings.automaticVendorSelection_switch(driver).getAttribute("src").contains("switchOn.png")) {
			perform.click(driver, SVendorSelectionSettings.automaticVendorSelection_switch(driver));
			changed = true;
		}

		// Turn off Unattended Order Assignment
		if (SVendorSelectionSettings.unattendedOrderAssignment_switch(driver).getAttribute("src").contains("switchOn.png")) {
			
			perform.click(driver, SVendorSelectionSettings.unattendedOrderAssignment_switch(driver));
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			// Click OK
			perform.click(driver, SVendorSelectionSettings.unattendedOrderAssignmentDialogOk_btn(driver));
			changed = true;
		}

		// Turn off Unattended Order Reassignment
		if (SVendorSelectionSettings.unattendedOrderReassignment_switch(driver).getAttribute("src").contains("switchOn.png")) {
			perform.click(driver, SVendorSelectionSettings.unattendedOrderReassignment_switch(driver));
			changed = true;
		}
		
		// Confirm there is an option in the Residential appraisal selection section for Allow order bidding
		Assert.assertTrue(SVendorSelectionSettings.allowOrderBidding_switch(driver).isDisplayed(), "There should be an option to Allow order bidding");
		
		// Enable Allow order bidding
		if (SVendorSelectionSettings.allowOrderBidding_switch(driver).getAttribute("src").contains("switchOff.png")) {
			perform.click(driver, SVendorSelectionSettings.allowOrderBidding_switch(driver));
			Thread.sleep(1500);
			changed = true;
		}
		
		// Confirm it has two sub options to lock or unlock the Fee and Date
		WebElement feeLock = SVendorSelectionSettings.feeLock_btn(driver);
		WebElement dateLock = SVendorSelectionSettings.dateLock_btn(driver);
		Assert.assertTrue(feeLock.isDisplayed(), "There should be a Fee lock button");
		Assert.assertTrue(dateLock.isDisplayed(), "There should be a Date lock button");
		
		// Unlock Fee and Date Locks
		if (!feeLock.getAttribute("src").contains("/Images/Unlocked-Blue.png")) {
			perform.click(driver, feeLock);
		}
		if (!dateLock.getAttribute("src").contains("/Images/Unlocked-Blue.png")) {
			perform.click(driver, dateLock);
		}
		
		// Confirm the locks are unlocked
		Assert.assertTrue(!feeLock.getAttribute("src").contains("/Images/Locked-Blue.png"), "The Fee lock should be locked");
		Assert.assertTrue(!dateLock.getAttribute("src").contains("/Images/Locked-Blue.png"), "The Date lock should be locked");
		
		// Confirm under Ordering options section > default order expiration time, there is a sub option for Default bid due
		Assert.assertTrue(SVendorSelectionSettings.defaultBidDue_div(driver).getText().contains("Default bid due"), "There should be an option to set the Default bid due");
		
		// Confirm the default bid due time is 12 hours
		Assert.assertTrue(SVendorSelectionSettings.defaultBidDueHours_txtbx(driver).getAttribute("value").equals("12"), "The hours should be set to 12");
		
		// Save settings
		if (changed==true) {
			secure.saveVendorSelectionSettings(driver);	
		}
		
		// Go to Users
		secure.goToUsers(driver);
		
		// Select the sub user
		perform.click(driver, SUsers.subUser_btn(driver));
		
		// Wait for Edit/Update link
		perform.waitForElementToBeClickable(driver, "Edit/Update", "linkText");
		
		// Click the hyperlink in the permission Edit/Update Orders
		perform.click(driver, driver.findElement(By.linkText("Edit/Update")));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SUsers.okEditUpdateOrders_btn(), "id");
		
		// Confirm there is an option for Issue/Review Bids
		Assert.assertTrue(SUsers.issueReviewBids_txtbx(driver).getText().equals("Issue/Review Bids"), "There should be an option to Issue/Review Bids");
		
		// Uncheck the Issue/Review Bids permission for the sub user
		if (SUsers.issueReviewBids_chkbx(driver).isSelected()) {
			perform.clickLabelText(driver, "Issue/Review Bids");	
		}
		Assert.assertTrue(!SUsers.issueReviewBids_chkbx(driver).isSelected(), "Issue/Review Bids checkbox should be checked");
		
		// Click OK
		perform.click(driver, SUsers.okEditUpdateOrders_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Check View/Manage Other Users' Orders
		perform.checkCheckbox(driver, SUsers.viewManageOtherUsersOrders_chkbx(driver));
		
		// Save
		secure.saveUsersSettings(driver);
		
		// Login to Secure
		secure.login(driver, userSecure, password);
		
		// Create a Residential Order
		secure.goToResidentialAppraisal(driver);
		
		// Set variables
		secure.setNewResidentialAppraisalOrderVariables(driver);
		
		// Enter order info
		/***************************************
		 * Enter Property Information
		 ***************************************/
		
		// Wait for address
		perform.waitForElementToBeClickable(driver, SNewOrder.address_txtbx(), "id");
		
		// Address
		perform.type(driver, SNewOrder.address_txtbx(driver), StoredVariables.getpropertyInformationAddress().get());

		// City
		perform.type(driver, SNewOrder.city_txtbx(driver), StoredVariables.getpropertyInformationCity().get());
		
		// State
		perform.selectDropdownOption(driver, SNewOrder.state_dropdown(driver), StoredVariables.getpropertyInformationState().get());
		
		// Zip Code
		perform.waitForElementToBeClickable(driver, SNewOrder.zipCode_txtbx(), "id");
		perform.type(driver, SNewOrder.zipCode_txtbx(driver), StoredVariables.getpropertyInformationZip().get());
		
		// Click out of Zip Code field
		perform.click(driver, SNewOrder.sqFt_txtbx(driver));
		
		Thread.sleep(3000);
		
		// Sq ft
		perform.type(driver, SNewOrder.sqFt_txtbx(driver), StoredVariables.getpropertyInformationSqFt().get());
		
		// Verify Sq ft is entered correctly
		if (!SNewOrder.sqFt_txtbx(driver).getAttribute("value").equals(StoredVariables.getpropertyInformationSqFt().get()))
		{
			SNewOrder.sqFt_txtbx(driver).clear();
			perform.type(driver, SNewOrder.sqFt_txtbx(driver), StoredVariables.getpropertyInformationSqFt().get());
		}
		
		// Site Size
		perform.type(driver, SNewOrder.siteSize_txtbx(driver), StoredVariables.getpropertyInformationSiteSize().get());
		
		// Prop Type
		perform.selectDropdownOption(driver, SNewOrder.propType_dropdown(driver), StoredVariables.getpropertyInformationPropType().get());
		
		// Prop rights
		perform.selectDropdownOption(driver, SNewOrder.propRights_dropdown(driver), StoredVariables.getpropertyInformationPropRights().get());
		
		// Legal desc
		perform.type(driver, SNewOrder.legalDesc_txtbx(driver), StoredVariables.getpropertyInformationLegalDesc().get());
		
		// Directions
		// Get directionsIdentifier used to uniquely identify the order number and store it
		StoredVariables.getdirectionsIdentifier().set(new SimpleDateFormat("MMddHHmmss").format(Calendar.getInstance().getTime()));
		StoredVariables.getpropertyInformationDirections().set(StoredVariables.getpropertyInformationDirections().get() + " - " + StoredVariables.getdirectionsIdentifier().get());
		// Enter Directions
		perform.type(driver, SNewOrder.directions_txtbx(driver), StoredVariables.getpropertyInformationDirections().get());
		
		// Verify Directions were entered correctly
		if (SNewOrder.directions_txtbx(driver).getAttribute("value").equals(StoredVariables.getpropertyInformationDirections().get()))
		{
			// Enter Directions
			SNewOrder.directions_txtbx(driver).clear();
			perform.type(driver, SNewOrder.directions_txtbx(driver), StoredVariables.getpropertyInformationDirections().get());
		} // end if
		
		// Verify Legal was entered correctly
		if (SNewOrder.legalDesc_txtbx(driver).getAttribute("value").equals(StoredVariables.getpropertyInformationLegalDesc().get()))
		{
			// Enter Directions
			SNewOrder.legalDesc_txtbx(driver).clear();
			perform.type(driver, SNewOrder.legalDesc_txtbx(driver), StoredVariables.getpropertyInformationLegalDesc().get());
		} // end if
		

		/***************************************
		 * Enter Assignment Information
		 ***************************************/
		
		// Form/type
		perform.selectDropdownOption(driver, SNewOrder.form_dropdown(driver), StoredVariables.getassignmentInformationForm().get());
		
		// Check Rush Order
		if (StoredVariables.getassignmentInformationRushOrder().get() == true && !SNewOrder.rushOrder_chkbx(driver).isSelected())
		{
			perform.click(driver, SNewOrder.rushOrder_chkbx(driver));
		}
		else if (StoredVariables.getassignmentInformationRushOrder().get() == false && SNewOrder.rushOrder_chkbx(driver).isSelected())
		{
			perform.click(driver, SNewOrder.rushOrder_chkbx(driver));
		}
		
		// Check Complex checkbox
		if (StoredVariables.getassignmentInformationComplex().get() == true && !SNewOrder.complex_chkbx(driver).isSelected())
		{
			perform.click(driver, SNewOrder.complex_chkbx(driver));				
		}
		else if (StoredVariables.getassignmentInformationComplex().get() == false && SNewOrder.complex_chkbx(driver).isSelected())
		{
			perform.click(driver, SNewOrder.complex_chkbx(driver));
		}
		
		// Other Ref #
		perform.type(driver, SNewOrder.otherRefNumber_txtbx(driver), StoredVariables.getassignmentInformationOtherRefNumber().get());
		
		// Loan Type
		perform.selectDropdownOption(driver, SNewOrder.loanType_dropdown(driver), StoredVariables.getassignmentInformationLoanType().get());
		
		// Loan Purpose
		perform.selectDropdownOption(driver, SNewOrder.loanPurpose_dropdown(driver), StoredVariables.getassignmentInformationLoanPurpose().get());
		
		// Ordered By
		perform.type(driver, SNewOrder.orderedBy_txtbx(driver), StoredVariables.getassignmentInformationOrderedBy().get());
		
		if (!StoredVariables.getassignmentInformationOrderGroup().get().equals(""))
		{
		
			// Click Edit Order Groups
			perform.click(driver, SNewOrder.editOrderGroups_lnk(driver));
			
			if (StoredVariables.getbrowser().get().equals("Chrome"))
			{
				Thread.sleep(500);				
			}
			
			// Switch focus to new dialog box iFrame
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'Controls/OrderGroupManagement.aspx')]")));
			
			// Select Order Group To Add
			// Create WebElement for Available Groups
			WebElement availableGroups = driver.findElement(By.id(SNewOrder.availableGroups_grid()));
			// List all the options in Available Groups
			List<WebElement> options = availableGroups.findElements(By.tagName("li"));
			// Loop through all Available Groups and click on the desired one
			for (WebElement option : options)
			{
			    if (option.getText().equals(StoredVariables.getassignmentInformationOrderGroup().get()))
			    {
			    	// click the desired option
			        perform.click(driver, option);
			        break;
			    }
			}
			
			// Add selected group to Eligible Vendors
			perform.waitForElementToBeClickable(driver, SNewOrder.addEligibleVendors_btn(), "cssSelector");
			perform.click(driver, SNewOrder.addEligibleVendors_btn(driver));
			
			perform.waitForElementToBeClickable(driver, SNewOrder.ok_btn(), "id");
			
			// Click OK
			perform.click(driver, SNewOrder.ok_btn(driver));
			
			// Switch to original iFrame
			driver.switchTo().defaultContent();
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
		
		} // end if for non-empty order group
		
		// Loan #
		perform.type(driver, SNewOrder.loanNumber_txtbx(driver), StoredVariables.getassignmentInformationLoanNumber().get());
		
		// File #
		perform.type(driver, SNewOrder.fileNumber_txtbx(driver), StoredVariables.getassignmentInformationFileNumber().get());
		
		// Sales Price
		perform.type(driver, SNewOrder.salesPrice_txtbx(driver), StoredVariables.getassignmentInformationSalesPrice().get());
		
		// FHA Case #
		perform.type(driver, SNewOrder.fhaCaseNumber_txtbx(driver), StoredVariables.getassignmentInformationFHACaseNumber().get());
		
		// Set Order Due Date (Long and Short)
		perform.getNewDate(driver, StoredVariables.getassignmentInformationOrderDue().get());
		StoredVariables.getorderDueDateLong().set(StoredVariables.getnewDateLong().get());
		StoredVariables.getorderDueDateShort().set(StoredVariables.getnewDateShort().get());
		
		// Set Disclosure Date (Long and Short)
		perform.getNewDate(driver, StoredVariables.getassignmentInformationDisclosure().get());
		StoredVariables.getdisclosureDateLong().set(StoredVariables.getnewDateLong().get());
		StoredVariables.getdisclosureDateShort().set(StoredVariables.getnewDateShort().get());
		
		// Select Disclosure Date
		if (StoredVariables.getbrowser().get().equals("PhantomJS") || StoredVariables.getbrowser().get().equals("HtmlUnit") || StoredVariables.getbrowser().get().equals("IE"))
		{
			// Enter Order Due date
			perform.type(driver, SNewOrder.disclosure_txtbx(driver), StoredVariables.getdisclosureDateLong().get());
		}
		else
		{
			// Click calendar for Disclosure
			perform.click(driver, SNewOrder.disclosureCalendar_btn(driver));
			
			// Select the date
			secure.selectDateFromCalendar(driver, StoredVariables.getassignmentInformationDisclosure().get());
			
			// Verify the date is correct
			Assert.assertTrue(SNewOrder.disclosure_txtbx(driver).getAttribute("value").equals(StoredVariables.getdisclosureDateLong().get()), "Date selected from calendar is the wrong date. It is - " + SNewOrder.disclosure_txtbx(driver).getAttribute("value") + " but should be " + StoredVariables.getdisclosureDateLong().get());
		}
		
		// Assigned To
		if (!StoredVariables.getassignmentInformationAssignedTo().get().equals(""))
		{
			perform.selectDropdownOption(driver, SNewOrder.assignedTo_dropdown(driver), StoredVariables.getassignmentInformationAssignedTo().get());
		}
		
		// Click Issue as Bid Yes radio button
		perform.click(driver, SNewOrder.issueAsBidYes_radiobtn(driver));
		
		// Wait for Locks
		perform.waitForElementToBeVisible(driver, SNewOrder.bidLock_group(), "id");
		
		// Verify Fee lock is unlocked
		Assert.assertTrue(!driver.findElement(By.cssSelector("#divBidLocks > div:nth-child(1) > div > div")).getAttribute("class").contains("imagecheckbox-container-checked"), "The Fee lock should be unlocked");

		// Verify Date lock is unlocked
		Assert.assertTrue(!driver.findElement(By.cssSelector("#divBidLocks > div:nth-child(2) > div > div")).getAttribute("class").contains("imagecheckbox-container-checked"), "The Fee lock should be unlocked");
		
		// Click Next
		perform.click(driver, SNewOrder.next_btn(driver));

		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Close Related Orders popup
		secure.checkForRelatedOrdersDialog(driver);

		// Wait for Fee Panel tab
		perform.waitForElementToBeClickable(driver, SVendorSelection.feePanelTab_tab(), "id");
		
		// Select available vendors and confirm selected vendors show in the Selected Vendors pod on the right
		// Select Appraiser1
		perform.clickInTable_Contains(driver, userVendors);
		
		// Wait for the vendor to be added to the Selected vendors table
		perform.waitForText(driver, SVendorSelection.selectedVendorsTable_txt(driver), userVendors);
		
		Thread.sleep(3000);

		// Select Appraiser3
		perform.clickInTable_Contains(driver, "Appraiser3");
		
		// Wait for the vendor to be added to the Selected vendors table
		perform.waitForText(driver, SVendorSelection.selectedVendorsTable_txt(driver), "Appraiser3");
		
		Thread.sleep(3000);
		
		// Verify which line is Appraiser1 and set the Profile button
		WebElement profile = null;
		WebElement firstAppraiser = driver.findElement(By.cssSelector("#tblBidVendors > tbody > tr:nth-child(1) > td.VendorSelectVendorName"));
		if (firstAppraiser.getText().contains(userVendors)) {
			profile = driver.findElement(By.cssSelector("#tblBidVendors > tbody > tr:nth-child(1) > td:nth-child(3) > img"));
		}
		else {
			profile = driver.findElement(By.cssSelector("#tblBidVendors > tbody > tr.ui-ig-altrecord.ui-iggrid-altrecord > td:nth-child(3) > img"));
		}
		
		// View the Vendor Profile
		secure.viewVendorProfile(driver, profile, "Appraiser");
		
		// Click the Products tab
		perform.click(driver, SProfile.products_tab(driver));
		
		// Wait for Always pay the transaction fee checkbox
		perform.waitForElementToBeClickable(driver, SProfile.alwaysPayTheTransactionFeeForThisVendor_chkbx(), "id");
		
		// Check the box 'Always pay the transaction fee for this vendor.'
		perform.checkCheckbox(driver, SProfile.alwaysPayTheTransactionFeeForThisVendor_chkbx(driver));
		
		// Click Save
		perform.click(driver, SProfile.save_btn(driver));
		
		// Switch out of iFrame
		driver.switchTo().defaultContent();
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);

		// Verify which line is Appraiser3 and set the Profile button
		profile = null;
		firstAppraiser = driver.findElement(By.cssSelector("#tblBidVendors > tbody > tr:nth-child(1) > td.VendorSelectVendorName"));
		if (firstAppraiser.getText().contains("Appraiser3")) {
			profile = driver.findElement(By.cssSelector("#tblBidVendors > tbody > tr:nth-child(1) > td:nth-child(3) > img"));
		}
		else {
			profile = driver.findElement(By.cssSelector("#tblBidVendors > tbody > tr.ui-ig-altrecord.ui-iggrid-altrecord > td:nth-child(3) > img"));
		}
		
		// View the Vendor Profile
		secure.viewVendorProfile(driver, profile, "Appraiser");
		
		// Click the Products tab
		perform.click(driver, SProfile.products_tab(driver));
		
		// Wait for Always pay the transaction fee checkbox
		perform.waitForElementToBeClickable(driver, SProfile.alwaysPayTheTransactionFeeForThisVendor_chkbx(), "id");
		
		// Uncheck the box 'Always pay the transaction fee for this vendor.'
		perform.uncheckCheckbox(driver, SProfile.alwaysPayTheTransactionFeeForThisVendor_chkbx(driver));
		
		// Click Save
		perform.click(driver, SProfile.save_btn(driver));
		
		// Switch out of iFrame
		driver.switchTo().defaultContent();
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Click Next
		perform.click(driver, SVendorSelection.nextBottom_btn(driver));
		
		// Wait for Bidding information
		perform.waitForElementToBeClickable(driver, SConfirmOrder.vendorSection_txt(), "id");
		
		// Confirm there is a Bidding information pod on the confirmation step
		String vendorSection = SConfirmOrder.vendorSection_txt(driver).getText();
		Assert.assertTrue(vendorSection.contains("Bidding information"), "There should be Bidding information in the vendor section");
		
		// Confirm the selected vendors display in the Bidding information pod
		Assert.assertTrue(vendorSection.contains(userVendors), "Appraiser1 should be in the Bidding information pod");
		Assert.assertTrue(vendorSection.contains("Appraiser3"), "Appraiser3 should be in the Bidding information pod");
		
		// Verify the Fee and Date are not displayed
		Assert.assertTrue(SConfirmOrder.bidFee_txt(driver).getAttribute("style").contains("none"), "The Fee should not be displayed");
		Assert.assertTrue(SConfirmOrder.bidDate_txt(driver).getAttribute("style").contains("none"), "The Date should not be displayed");
		
		// Click I agree to pay the Mercury transaction fee
		perform.checkCheckbox(driver, SConfirmOrder.iAgreeToPayTheMercuryNetworkTransactionFee_chkbx(driver));
		
		// Click Finish
		perform.click(driver, SConfirmOrder.finishBottom_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Switch into iFrame
		perform.switchToiFrameByID(driver, "iframeAttach");
		
		// Wait for Finished button
		perform.waitForElementToBeClickable(driver, SConfirmOrder.finished_btn(), "id");
		
		// Click Finished
		perform.click(driver, SConfirmOrder.finished_btn(driver));
		
		// Get order number
		db.getLoanID(driver);
		String trackingNumber = StoredVariables.gettrackingNumber().get();
		
		// Log the tracking number
		test.log(LogStatus.INFO, "Tracking Number", "Tracking #: " + trackingNumber);
		
		// Find the order
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Open the order
		secure.openOrder(driver, trackingNumber);
		
		// Wait for the history
		perform.waitForElementToBeClickable(driver, SOrderDetails.history_txt(), "id");
		
		// Confirm the order is placed
		Assert.assertTrue(SOrderDetails.history_txt(driver).getText().contains("Out for Bid by Client"), "The history does not reflect the order being 'Out for Bid by Client'");
		
		// Confirm there is an Issue as bid field in Assignment information
		Assert.assertTrue(SOrderDetails.assignmentInformation_txt(driver).getText().contains("Issue as bid"), "There should be an Issue as bid field in the Assignment information pod");
		
		// Confirm the locks for Fee and Date show as locked as the order was placed with them locked
		Assert.assertTrue(!SOrderDetails.feeLock_img(driver).getAttribute("src").contains("/Images/Locked.png"), "The Fee lock should be locked");
		Assert.assertTrue(!SOrderDetails.dateLock_img(driver).getAttribute("src").contains("/Images/Locked.png"), "The Date lock should be locked");
		
		// Log in as the vendor with the transaction fee paid for by the client
		vendors.login(driver, userVendors, password);
		
		// Open the order
		vendors.findAndOpenOrder(driver, trackingNumber);
		
		// Confirm the status shows Bid Pending
		String status = VOrderDetails.historyHeader_txt(driver).getText();
		Assert.assertTrue(status.contains("(Bid Pending)"), "The status should be Bid Pending but is = " + status);
		
		// Confirm the Order Fee value is blank
		Assert.assertTrue(VOrderDetails.orderFee_txt(driver).getText().equals("$"), "The Order Fee should be blank");
		
		// Confirm the Due Date value is displayed in purple text
		Assert.assertTrue(VOrderDetails.dueDate_txt(driver).getText().equals(""), "The Due Date should be blank");
		
		// Confirm there is a Submit Bid button instead of Accept/Decline Assignment
		Assert.assertTrue(VOrderDetails.submitBid_btn(driver).isDisplayed(), "There should be a Submit Bid button instead of an Accept/Decline button");
		
		// Click Submit Bid
		perform.click(driver, VOrderDetails.submitBid_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Switch into iFrame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "Bidding/SubmitBid.aspx", By.id(VSubmitBid.cancel_btn()));
		
		// Wait for the Cancel button
		perform.waitForElementToBeClickable(driver, VSubmitBid.cancel_btn(), "id");
		
		// Confirm there is a message stating the vendor will not be charged the fee as the client is covering the fee
		String dialogText = VSubmitBid.dialog_txt(driver).getText();
		Assert.assertTrue(dialogText.contains("You won't be charged a transaction fee for this order because the client has agreed to cover the transaction fee."), "There should be a message stating the vendor will not be charged the fee as the client is covering the fee. The text in the dialog = " + dialogText);
		
		// Confirm Submit is currently not active and cannot be clicked
		Assert.assertTrue(VSubmitBid.submit_btn(driver).getAttribute("class").contains("SkinButtonDisabled"), "The Submit button should be disabled but is not");
		
		// Enter Appraisal bid amount
		perform.type(driver, VSubmitBid.appraisalBid_txtbx(driver), "525");
		
		// Enter Turn time
		perform.type(driver, VSubmitBid.turnTime_txtbx(driver), "8");
		perform.click(driver, VSubmitBid.messageToTheClient_txtbx(driver));
		
		Thread.sleep(3000);
		
		// Estimated due date
		Assert.assertTrue(!VSubmitBid.estDueDateContainer(driver).getAttribute("style").contains("none"), "The estimated due date should now be displayed");
		String estDueDate = VSubmitBid.estDueDate_txt(driver).getText();
		Assert.assertTrue(!estDueDate.equals(""), "The est due date should not be blank. estDueDate = " + estDueDate);
		
		// Confirm you can add a message to the client
		perform.type(driver, VSubmitBid.messageToTheClient_txtbx(driver), "These are test message notes to the client");
		Thread.sleep(500);
		VSubmitBid.messageToTheClient_txtbx(driver).clear();
		
		// Confirm you can use the QuickList icon to add and use a QuickList item
		// Open the QL dialog
		vendors.openQLDialog(driver, VSubmitBid.messageToTheClient_txtbx(driver), VSubmitBid.ql_btn(driver));
		
		// Delete any existing QL items
		vendors.deleteAllQLItems(driver);
		
		// Create a new QL item
		vendors.createNewQLItem(driver, "Test QL text", "This is test QL text");
		
		// Wait for the checkmark
		perform.waitForElementToBeClickable(driver, VQuickList.checkmark_btn(), "cssSelector");
		
		// Select the first QL item
		perform.click(driver, VQuickList.checkmark_btn(driver));
		
		// Click Use
		perform.click(driver, VQuickList.use_btn(driver));
		
		// Switch to Submit Bid iFrame
		driver.switchTo().defaultContent();
		perform.waitForiFrameSrcAndSwitchToIt(driver, "Bidding/SubmitBid.aspx", By.id(VSubmitBid.messageToTheClient_txtbx()));
		
		// Wait for the message textbox
		perform.waitForElementToBeClickable(driver, VSubmitBid.messageToTheClient_txtbx(), "id");
		
		// Verify the new QL item is displayed
		String messageText = VSubmitBid.messageToTheClient_txtbx(driver).getAttribute("value");
		Assert.assertTrue(messageText.equals("This is test QL text"), "The message textbox should be the new QL item. Message text = " + messageText);
		
		// Confirm you can now click on Submit
		Assert.assertTrue(!VSubmitBid.submit_btn(driver).getAttribute("class").contains("SkinButtonDisabled"), "The Submit button should not be disabled");
		
		// Click Submit
		perform.click(driver, VSubmitBid.submit_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Confirm the Submit Bid button now states Update Bid
		perform.waitForElementToBeVisible(driver, VOrderDetails.menuBar(), "id");
		perform.waitForElementToBeClickable(driver, VOrderDetails.menuBar(), "id");
		String menuBar = VOrderDetails.menuBar(driver).getText();
		Assert.assertTrue(menuBar.contains("Update Bid"), "There should be an Update Bid button in the menu bar. Menu Bar = " + menuBar);
		
		// Confirm there is an audit trail event showing any vendor notes and the vendor agreed to the bid terms
		String history = VOrderDetails.history_txt(driver).getText();
		Assert.assertTrue(history.contains("Appraiser Automation Appraiser1 submitted a bid on this order."), "The history should contain 'Appraiser Automation Appraiser1 submitted a bid on this order.'. History = " + history);
		Assert.assertTrue(history.contains("This is test QL text"), "The history should contain 'This is test QL text'. History = " + history);
		Assert.assertTrue(history.contains("Bid Pending by Automation Appraiser1"), "The history should contain 'Bid Pending by Automation Appraiser1'. History = " + history);
		Assert.assertTrue(history.contains("Amount: $525;"), "The history should contain 'Amount: $525;'. History = " + history);
		Assert.assertTrue(history.contains("Turn Time: 8 business days"), "The history should contain 'Turn Time: 8 business days'. History = " + history);

		// Log in as the vendor who will be paying the transaction fee
		vendors.login(driver, "Appraiser3", password);
		
		// View the order details
		vendors.findAndOpenOrder(driver, trackingNumber);
		
		// Click Submit Bid
		perform.click(driver, VOrderDetails.submitBid_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Switch to iFrame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "Bidding/SubmitBid.aspx", By.id(VSubmitBid.dialog_txt()));
		
		// Confirm the message shows the vendor will be responsible for the transaction fee
		dialogText = VSubmitBid.dialog_txt(driver).getText();
		Assert.assertTrue(dialogText.contains("By selecting continue, I acknowledge the Mercury Network transaction fee shown below will be charged to my account (discounts may apply)."), "The message should show the vendor will be responsible for the transaction fee. Dialog = " + dialogText);
		
		// Confirm the transaction fee amount is displayed and includes any sales tax if applicable
		Assert.assertTrue(dialogText.contains("Transaction fee $"), "Dialog = " + dialogText);
//		String transactionFee = "16.89";
//		Assert.assertTrue(dialogText.contains(transactionFee), "The transaction fee is missing. Dialog = " + dialogText);
		
		// Confirm the Submit button is not active and cannot be clicked
		Assert.assertTrue(VSubmitBid.submit_btn(driver).getAttribute("class").contains("SkinButtonDisabled"), "The Submit button should be disabled but is not");
		
		// Enter Appraisal bid amount
		perform.type(driver, VSubmitBid.appraisalBid_txtbx(driver), "625");
		
		// Enter Turn time
		perform.type(driver, VSubmitBid.turnTime_txtbx(driver), "7");
		
		// Estimated due date
		Assert.assertTrue(!VSubmitBid.estDueDateContainer(driver).getAttribute("style").contains("none"), "The estimated due date should now be displayed");
		estDueDate = VSubmitBid.estDueDate_txt(driver).getText();
		if (estDueDate.isEmpty()) {
			
			// Switch out of iFrames
			driver.switchTo().defaultContent();
			
			// Switch to iFrame
			perform.waitForiFrameSrcAndSwitchToIt(driver, "Bidding/SubmitBid.aspx", By.id(VSubmitBid.estDueDate_txt()));
			
			// Grab the estimated due date
			estDueDate = VSubmitBid.estDueDate_txt(driver).getText();
			
		} // end if
		Assert.assertTrue(!estDueDate.isEmpty(), "The est due date should not be blank");
		
		// Confirm you can add a message to the client
		perform.type(driver, VSubmitBid.messageToTheClient_txtbx(driver), "These are test message notes to the client");
		Thread.sleep(500);
		
		// Click on Submit
		perform.click(driver, VSubmitBid.submit_btn(driver));
		
		// Switch out of iFrame
		driver.switchTo().defaultContent();
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Wait for Update bid button
		perform.waitForElementToBeClickable(driver, VOrderDetails.updateBid_btn(), "cssSelector");
		
		// Click Update Bid
		perform.click(driver, VOrderDetails.updateBid_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for the overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for update bid dialog
		String msgBoxIFrame = "";
		int i = 1;
		while (!msgBoxIFrame.contains("block") && i++ < 10) {
			
			// Try to verify the class of MsgBoxIFrame
			try {
				msgBoxIFrame = driver.findElement(By.cssSelector(".msgBoxIFrame")).getAttribute("class");
			} catch (Exception e) {
				// Element not found
			} // end try/catch
			
		} // end while

		// Switch to iFrame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "Bidding/SubmitBid.aspx", By.id(VSubmitBid.iAmUnableToBid_chkbx()));
		
		// Click I am unable to bid on this opportunity
//		VSubmitBid.iAmUnableToBid_chkbx(driver)
		perform.checkCheckbox(driver, VSubmitBid.iAmUnableToBid_chkbx(driver));
		
		// Verify Appraisal bid and Turn time textboxes are now blank
		Assert.assertTrue(VSubmitBid.appraisalBid_txtbx(driver).getAttribute("value").equals(""), "The Appraisal bid textbox should be blank");
		Assert.assertTrue(VSubmitBid.turnTime_txtbx(driver).getAttribute("value").equals(""), "The Turn time textbox should be blank");
		
		// Add notes to the client
		VSubmitBid.messageToTheClient_txtbx(driver).clear();
		perform.type(driver, VSubmitBid.messageToTheClient_txtbx(driver), "I do not want to bid");
		
		// Click on Submit
		perform.click(driver, VSubmitBid.submit_btn(driver));
		
		// Wait for Decline dialog
		perform.waitForElementToBeClickable(driver, VSubmitBid.declineBidDialog_txt(), "id");
		
		// Confirm the vendor receives the Are you sure message stating
		String declineDialog = VSubmitBid.declineBidDialog_txt(driver).getText();
		Assert.assertTrue(declineDialog.contains("If you decline to bid, you will no longer be eligible for this order. If you wish to discuss options with your client, please send a message instead."), "The dialog should say 'If you decline to bid, you will no longer be eligible for this order. If you wish to discuss options with your client, please send a message instead.'. Dialog = " + declineDialog);
		
		// Click Decline
		perform.click(driver, VSubmitBid.decline_btn(driver));
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, VSubmitBid.ok_btn(), "id");
		
		// Confirm the vendor receives the Success message stating 'The client will be notified you are unable to bid at this time.'		
		declineDialog = VSubmitBid.declineBidDialog_txt(driver).getText();
		Assert.assertTrue(declineDialog.contains("The client will be notified you are unable to bid at this time."), "The dialog should contain 'The client will be notified you are unable to bid at this time.' The dialog = " + declineDialog);
		
		// Click OK
		perform.click(driver, VSubmitBid.ok_btn(driver));
		
		// Get out of iFrame
		driver.switchTo().defaultContent();
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Go to Orders
		vendors.goToOrders(driver);
		
		// Search for the order
		vendors.findOrder(driver, trackingNumber, "Tracking Number");
		
		// Verify the order is not found
		String gridText = VOrders.ordersGrid_txt(driver).getText();
		Assert.assertTrue(gridText.contains("No orders found for the selected filter."), "The order should not be displayed. Orders Grid = " + gridText);
		
		// From Secure Mercury Network:
		// Log in as the sub user without Issue/Review Bids permission
		secure.login(driver, userSecureSU, password);
		
		// View the order details
		secure.findOrder(driver, trackingNumber, "Tracking number");
		secure.openOrder(driver, trackingNumber);
		
		// Confirm the Review bids option is not active and cannot be clicked on
		Assert.assertTrue(driver.findElement(By.cssSelector("img[src='/App_Themes/FlatGrayscale/Icons/Review.O-disabled.png']")).isDisplayed(), "The Review bids button should be disabled");
		
		// Log in as the Admin
		secure.login(driver, userSecure, password);
		
		// View the order details
		secure.findOrder(driver, trackingNumber, "Tracking number");
		secure.openOrder(driver, trackingNumber);
		
		// Confirm there are audit trail events for the vendor accepting the terms and the vendor declining to bid
		history = SOrderDetails.history_txt(driver).getText();
		Assert.assertTrue(history.contains("Vendor Automation Appraiser1 submitted a bid on this order."), "The history is missing audit trail events for the vendor accepting the terms. The history = " + history);
		Assert.assertTrue(history.contains("This is test QL text"), "The history is missing audit trail events for the vendor accepting the terms. The history = " + history);
		Assert.assertTrue(history.contains("Amount: $525.00;"), "The history is missing audit trail events for the vendor accepting the terms. The history = " + history);
		Assert.assertTrue(history.contains("Turn Time: 8 business days"), "The history is missing audit trail events for the vendor accepting the terms. The history = " + history);
		Assert.assertTrue(history.contains("Vendor Automation Appraiser3 declined to bid on this order."), "The history is missing audit trail events for the vendor declining to bid. The history = " + history);
		Assert.assertTrue(history.contains("I do not want to bid"), "The history is missing audit trail events for the vendor declining to bid. The history = " + history);
		Assert.assertTrue(history.contains("Vendor Automation Appraiser3 submitted a bid on this order."), "The history is missing audit trail events for the vendor who declined the bid originally accepting. The history = " + history);
		Assert.assertTrue(history.contains("These are test message notes to the client"), "The history is missing audit trail events for the vendor who declined the bid originally accepting. The history = " + history);
		Assert.assertTrue(history.contains("Amount: $625.00;"), "The history is missing audit trail events for the vendor who declined the bid originally accepting. The history = " + history);
		Assert.assertTrue(history.contains("Turn Time: 7 business days"), "The history is missing audit trail events for the vendor who declined the bid originally accepting. The history = " + history);
		Assert.assertTrue(history.contains("Out for Bid by Client (Automation ResBidding2)"), "The history is missing audit trail events showing the order out for bid. The history = " + history);
		
		// Click Review bids
		perform.click(driver, SOrderDetails.reviewBids_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		Thread.sleep(1000);
		
		// Switch into iframe
		perform.waitForiFrameSrcAndSwitchToIt(driver, "Bidding/Review.aspx", By.id(SReviewBids.closeReviewBids_btn()));
		
		// Wait for the Close button
		perform.waitForElementToBeClickable(driver, SReviewBids.closeReviewBids_btn(), "id");
		
		// Confirm it displays all selected vendors and any bid information
		String table = SReviewBids.appraiserTable_txt(driver).getText();
		Assert.assertTrue(table.contains("Automation Appraiser1"), "Automation Appraiser1 is missing from the table");
		Assert.assertTrue(table.contains("Automation Appraiser3"), "Automation Appraiser3 is missing from the table");
		
		// Find Appraiser1 row
		WebElement row1 = driver.findElement(By.cssSelector("#"+SReviewBids.appraiserTable_txt()+" > tbody > tr:nth-child(1)"));
		WebElement statusRow1 = driver.findElement(By.cssSelector("#"+SReviewBids.appraiserTable_txt()+" > tbody > tr:nth-child(1) > td:nth-child(11)"));
		WebElement statusRow2 = driver.findElement(By.cssSelector("#"+SReviewBids.appraiserTable_txt()+" > tbody > tr:nth-child(2) > td:nth-child(11)"));
		
		// Appraiser1 should display Bid Submitted
		String vendorStatus = "";
		if (row1.getText().contains(userVendors)) {
			vendorStatus = statusRow1.getText();
		} else {
			vendorStatus = statusRow2.getText();
		}
		Assert.assertTrue(vendorStatus.contains("Bid Submitted"), "Appraiser1 status should be Bid Submitted. vendorStatus = " + vendorStatus);
		
		// Appraiser3 should display Vendor declined
		vendorStatus = "";
		if (row1.getText().contains("Appraiser3")) {
			vendorStatus = statusRow1.getText();
		} else {
			vendorStatus = statusRow2.getText();
		}
		Assert.assertTrue(vendorStatus.contains("Vendor declined"), "Appraiser3 status should be Vendor declined");
		
		// Confirm Award bid, Decline bid, and send message are not active until a vendor bid is selected in the list
		Assert.assertTrue(SReviewBids.awardBidDisabled_btn(driver).isDisplayed(), "The Award Bid button should be disabled");
		Assert.assertTrue(SReviewBids.declineBidDisabled_btn(driver).isDisplayed(), "The Decline Bid button should be disabled");
		Assert.assertTrue(SReviewBids.sendMessageDisabled_btn(driver).isDisplayed(), "The Send Message button should be disabled");
		
		// Select Appraiser1
		perform.clickInTable_Contains(driver, userVendors);
		
		// Confirm Award bid, Decline bid, and send message are active
		Assert.assertTrue(SReviewBids.awardBid_btn(driver).isDisplayed(), "The Award Bid button should not be disabled");
		Assert.assertTrue(SReviewBids.declineBid_btn(driver).isDisplayed(), "The Decline Bid button should not be disabled");
		Assert.assertTrue(SReviewBids.sendMessage_btn(driver).isDisplayed(), "The Send Message button should not be disabled");
		
		// Click on Add Vendor
		perform.click(driver, SReviewBids.addVendor_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Switch to default content
		driver.switchTo().defaultContent();
		
		// Wait for the Next button
		perform.waitForElementToBeClickable(driver, SVendorSelection.nextTop_btn(), "id");
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Confirm the Add additional vendors displays with eligible vendors to choose from
		Assert.assertTrue(SVendorSelection.feePanelTable_txt(driver).getText().contains("ResBidAppraiser2"), "ResBidAppraiser2 should be an available vendor. Vendors availabe = " + SVendorSelection.feePanelTable_txt(driver).getText());
		
		// Select a vendor (not from a company currently selected)
		perform.clickInTable_Contains(driver, "ResBidAppraiser2");
		
		// Wait for the vendor to be added to the Selected vendors table
		perform.waitForText(driver, SVendorSelection.selectedVendorsTable_txt(driver), "ResBidAppraiser2");
		
		// Click Next
		perform.click(driver, SVendorSelection.nextTop_btn(driver));
		
		// Confirm the additional vendor is displayed in Bidding information
		Assert.assertTrue(SConfirmOrder.vendorSection_txt(driver).getText().contains("ResBidAppraiser2"), "The ResBidAppraiser2 info shoudl be displayed in the Bidding information table");
		
		// Confirm you cannot change the status of the Fee and Date locks
		Assert.assertTrue(driver.findElement(By.cssSelector("#divBidLocks > div:nth-child(1) > div > div")).getAttribute("class").contains("imagecheckbox-container-disabled"), "The Fee button should be locked");
		Assert.assertTrue(driver.findElement(By.cssSelector("#divBidLocks > div:nth-child(3) > div > div")).getAttribute("class").contains("imagecheckbox-container-disabled"), "The Date button should be locked");
		
		// Click Finish
		perform.click(driver, SConfirmOrder.finishTop_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Confirm you are returned to the Review bids window
		perform.waitForIFrames(driver);
		perform.waitForiFrameSrcAndSwitchToIt(driver, "Bidding/Review.aspx", By.id(SReviewBids.appraiserTable_txt()));
		
		// Confirm the new vendor is listed
		perform.waitForElementToBeVisible(driver, SReviewBids.appraiserTable_txt(driver));
		table = SReviewBids.appraiserTable_txt(driver).getText();
		Assert.assertTrue(table.contains("Automation ResBidAppraiser2"), "Automation ResBidAppraiser2 is missing from the table");

		// Select Automation Appraiser1
		perform.clickInTable_Contains(driver, "Automation Appraiser1");
		
		// Confirm Award bid, Decline bid, and Send message are now active
		Assert.assertTrue(SReviewBids.awardBid_btn(driver).isDisplayed(), "The Award Bid button should not be disabled");
		Assert.assertTrue(SReviewBids.declineBid_btn(driver).isDisplayed(), "The Decline Bid button should not be disabled");
		Assert.assertTrue(SReviewBids.sendMessage_btn(driver).isDisplayed(), "The Send Message button should not be disabled");
		
		// Click Award bid
		perform.click(driver, SReviewBids.awardBid_btn(driver));
		
		// Switch to iFrame
		driver.switchTo().defaultContent();
		perform.waitForiFrameSrcAndSwitchToIt(driver, "Bidding/Award.aspx", By.id(SAwardBid.awardNote_txtbx()));
		
		// Wait for Award note textbox
		perform.waitForElementToBeClickable(driver, SAwardBid.awardNote_txtbx(), "id");
		
		// Confirm you can include an Award note
		perform.type(driver, SAwardBid.awardNote_txtbx(driver), "These are award notes");
		
		// Confirm the Order fee is displayed and cannot be changed
		Assert.assertTrue(SAwardBid.vendorGrid_txt(driver).getText().contains("$525.00"), "Thte order fee should be $525.00");
		
		// Confirm you can change the payment method
		perform.selectDropdownOption(driver, SAwardBid.paymentMethod_dropdown(driver), "PayPal");
		
		// Verify ResBidAppraiser2 is in the Decline section
		String declineText = SAwardBid.decline_txt(driver).getText();
		Assert.assertTrue(declineText.contains("ResBidAppraiser2"), "ResBidAppraiser2 should be in the Decline text grid. declineText = " + declineText);
		
		// Confirm you can enter a Decline note
		perform.type(driver, SAwardBid.declineNote_txtbx(driver), "These are decline notes");
		
		// Confirm you can click Award
		perform.click(driver, SAwardBid.award_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Switch out of iFrames
		driver.switchTo().defaultContent();
		
		// Wait for Close button
		perform.waitForElementToBeClickable(driver, SOrderDetails.close_btn(), "id");
		
		// Click Close on the attach document window
		perform.click(driver, SOrderDetails.close_btn(driver));
		
		// Wait for history text to update
		perform.waitForText(driver, SOrderDetails.history_txt(driver), "History (In Progress)");
		
		// Get the history text
		history = SOrderDetails.history_txt(driver).getText();
		
		// Confirm there is an audit trail event showing the bid awarded including the fee and date
		Assert.assertTrue(history.contains("Bid Awarded by Client (Automation ResBidding2) to Appraiser (Automation Appraiser1)"), "The history should contain 'Bid Awarded by Client (Automation ResBidding1) to Appraiser (Automation Appraiser1)'. History = " + history);
		Assert.assertTrue(history.contains("Amount: $525.00; Order due date set to:"), "The history should contain 'Amount: $500.00; Order due date set to:'. History = " + history);
		Assert.assertTrue(history.contains("These are award notes"), "The history should contain 'These are award notes'. History = " + history);
		
		// Confirm the order is automatically accepted by the vendor and there is an audit trail event
		Assert.assertTrue(history.contains("Order accepted by Appraiser (Automation Appraiser1) and In Progress"), "The history should contain 'Order accepted by Appraiser (Automation Appraiser1) and In Progress'. History = " + history);
		Assert.assertTrue(history.contains("Order automatically accepted"), "The history should contain 'Order automatically accepted'. History = " + history);
		
		// Confirm there is bid decline info in the audit trail
		Assert.assertTrue(history.contains("Bid declined by Client (Automation ResBidding2) for Vendor (Automation ResBidAppraiser2)"), "The history should contain 'Bid declined by Client (Automation ResBidding2) for Vendor (Automation ResBidAppraiser2)'. History = " + history);
		Assert.assertTrue(history.contains("These are decline notes"), "The history should contain 'These are decline notes'. History = " + history);
		
		// Log test
		test.log(LogStatus.INFO, "Residential Bidding", "Verified Residential Bidding with the Fee and Date unlocked");
		
	} // end VMPXSiteFeeWithVMPComment
	
} // end the FeeAndDateUnlocked class
