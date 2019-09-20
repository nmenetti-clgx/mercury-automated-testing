package matrixRoundTrip;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjects.Secure.SConfirmOrder;
import pageObjects.Secure.SNewOrder;
import pageObjects.Secure.SOrders;
import pageObjects.Secure.SPreferences;
import pageObjects.Secure.SVendorSelectionSettings;
import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Round Trip - Verify New Order</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class VerifyNewOrder extends TestSetup {
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>If browser is IE, set require window focus capability to false</li>
	 * 	<li>if (StoredVariables.getbrowser().get().equals("IE"))</li>
	 * 	<li>{</li>
	 * 	<li>perform.IE_setRequireWindowFocusToFalse();</li>
	 * 	<li>}</li>
	 * 	<li>Sign in to Secure</li>
	 * 	<li>Click to Preferences</li>
	 * 	<li>Select Vendor Selection Settings</li>
	 * 	<li>Turn on Double-blind Communication switch</li>
	 * 	<li>Verify Canned Comment Override switch is off</li>
	 * 	<li>Select Custom Fee Panel</li>
	 * 	<li>Uncheck Use Mercury Network Directory as backup checkbox</li>
	 * 	<li>Verify Mercury Network Directory as backup is unchecked</li>
	 * 	<li>Save Preferences</li>
	 * 	<li>Click OK in saved dialog box</li>
	 * 	<li>Clear order information variables before placing a new order</li>
	 * 	<li>Go to the Orders page</li>
	 * 	<li>Go to Residential Appraisal</li>
	 * 	<li>Set Property Information data</li>
	 * 	<li>StoredVariables.getpropertyInformationStateAbbr().set("OK");  Must set for a field check later on</li>
	 * 	<li>Set Assignment Information data</li>
	 * 	<li>Set Lender Information data</li>
	 * 	<li>Set Contact And Access Information data</li>
	 * 	<li>Set Additional Notification Recipients data</li>
	 * 	<li>Enter New Order data</li>
	 * 	<li>Click Next</li>
	 * 	<li>Confirm order screen loads</li>
	 * 	<li>Verify Vendor Information is correct</li>
	 * 	<li>Click back</li>
	 * 	<li>Click Borrower Address button</li>
	 * 	<li>Click Save</li>
	 * 	<li>Click Co-borrower Address button</li>
	 * 	<li>Click Save</li>
	 * 	<li>Verify the next button is clickable</li>
	 * 	<li>Click Next</li>
	 * 	<li>Verify the 'I have read and understand the vendor's fee notes' checkbox is unchecked</li>
	 * 	<li>Click Next</li>
	 * 	<li>Verify popup displays with correct text</li>
	 * 	<li>Click OK</li>
	 * 	<li>Check the agree to notes checkbox</li>
	 * 	<li>Change payment method to check</li>
	 * 	<li>Save new order (click next)</li>
	 * 	<li>Get inside the attach document frame</li>
	 * 	<li>Select document type</li>
	 * 	<li>Upload Document</li>
	 * 	<li>perform.waitForElementToBeClickable(driver, SConfirmOrder.printDirectFax_btn(), "id");</li>
	 * 	<li></li>
	 * 	<li>Get the Window Handle before the new window opens</li>
	 * 	<li>String winHandleBefore = driver.getWindowHandle();</li>
	 * 	<li></li>
	 * 	<li>Click Direct Fax</li>
	 * 	<li>SConfirmOrder.printDirectFax_btn(driver));</li>
	 * 	<li></li>
	 * 	<li>Sleep to let the Print dialog box finish loading</li>
	 * 	<li>Thread.sleep(15000);</li>
	 * 	<li></li>
	 * 	<li>Close print dialog</li>
	 * 	<li>Robot r = new Robot();</li>
	 * 	<li>r.keyPress(KeyEvent.VK_ESCAPE);</li>
	 * 	<li>r.keyRelease(KeyEvent.VK_ESCAPE);</li>
	 * 	<li></li>
	 * 	<li>Webdriver popup = null;</li>
	 * 	<li>Iterator&lt;String&gt; windowIterator = driver.getWindowHandles()</li>
	 * 	<li>.iterator();</li>
	 * 	<li>while (windowIterator.hasNext()) {</li>
	 * 	<li>String windowHandle1 = windowIterator.next();</li>
	 * 	<li>popup = driver.switchTo().window(windowHandle1);</li>
	 * 	<li>String title = popup.getTitle();</li>
	 * 	<li>if (title.contains("DirectFax")) {</li>
	 * 	<li>break;</li>
	 * 	<li></li>
	 * 	<li>Get the Window Handle before the new window opens</li>
	 * 	<li>String newWinHandle = driver.getWindowHandle();</li>
	 * 	<li></li>
	 * 	<li>Get inside the main frame for text</li>
	 * 	<li>driver.switchTo().frame("main");</li>
	 * 	<li></li>
	 * 	<li>Verify fax cover sheet heading text</li>
	 * 	<li>Assert.assertTrue(SDirectFax.faxCoverSheet_txt(driver).getText().contains("Fax Cover Sheet"), "DirectFax Fax Cover Sheet text heading is not displayed");</li>
	 * 	<li></li>
	 * 	<li>Verify company name text</li>
	 * 	<li>Assert.assertTrue(SDirectFax.company_txt(driver).getText().contains("Automation Test User"), "DirectFax company name is not displayed properly");</li>
	 * 	<li></li>
	 * 	<li>Get inside the contents frame for the Cancel button</li>
	 * 	<li>driver.switchTo().window(newWinHandle);</li>
	 * 	<li>driver.switchTo().frame("contents");</li>
	 * 	<li></li>
	 * 	<li>Click Cancel</li>
	 * 	<li>SDirectFax.cancel_btn(driver));</li>
	 * 	<li></li>
	 * 	<li>Switch back to original browser (first window)</li>
	 * 	<li>driver.switchTo().window(winHandleBefore);</li>
	 * 	<li></li>
	 * 	<li>perform.waitForIFrames(driver);</li>
	 * 	<li></li>
	 * 	<li>Switch back to the attach documents frame</li>
	 * 	<li>driver.switchTo().defaultContent();</li>
	 * 	<li>driver.switchTo().frame("iframeAttach");</li>
	 * 	<li>Click Close Button</li>
	 * 	<li>Switch back to the attach documents frame</li>
	 * 	<li>Verify you land on the orders grid</li>
	 * 	<li>Query the db to get the order number that was just created</li>
	 * 	<li>Verify Due date is ordered properly to display the most recent order first</li>
	 * 	<li>Verify the order just created is in the orders grid</li>
	 * 	<li>If browser is IE, re-establish capabilites</li>
	 * 	<li>if (StoredVariables.getbrowser().get().equals("IE"))</li>
	 * 	<li>{</li>
	 * 	<li>perform.IE_reEstablishCapabilities();</li>
	 * 	<li>}</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Vendor Selection Settings", "Secure - Create Order"}, alwaysRun=true)
	public void vendorSelectionSettings() throws Exception {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		if (StoredVariables.getbrowser().get().equals("PhantomJS"))
		{
			String callersClass = new Exception().getStackTrace()[0].getClassName();
			test.log(LogStatus.SKIP, "The " + callersClass + " class was skipped becuase the " + StoredVariables.getbrowser().get() + " browser has an issue completing an order and causing the site to error");
			throw new SkipException("The " + callersClass + " class was skipped becuase the " + StoredVariables.getbrowser().get() + " browser has an issue completing an order and causing the site to error");
		} // end if PhantomJS
		
		// Sign in to Secure
		secure.login(driver, "Lender1", StoredVariables.getpassword().get());
		
		// Wait for the Preferences button
		perform.waitForElementToBeClickable(driver, SOrders.preferences_btn(), "id");
		
		// Click to Preferences
		perform.click(driver,SOrders.preferences_btn(driver));
		
		// Wait for vendor selection settings
		perform.waitForElementToBeClickable(driver, SPreferences.vendorSelectionSettings_btn(), "cssSelector");
		
		// Select Vendor Selection Settings
		perform.click(driver,SPreferences.vendorSelectionSettings_btn(driver));
		
		// Turn on Double-blind Communication switch
		if (SVendorSelectionSettings.doubleBlind_switch(driver).getAttribute("src").contains("switchOff.png"))
		{
			perform.click(driver,SVendorSelectionSettings.doubleBlind_switch(driver));
		}
		
		// Verify Canned Comment Override switch is off
		if (SVendorSelectionSettings.cannedCommentOverride_switch(driver).getAttribute("src").contains("switchOn.png"))
		{
			perform.click(driver,SVendorSelectionSettings.cannedCommentOverride_switch(driver));
		}
		
		// Select Custom Fee Panel
		perform.click(driver,SVendorSelectionSettings.customFeePanel_radio(driver));
		
		// Uncheck Use Mercury Network Directory as backup checkbox
		if (SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver).isSelected())
		{
			perform.click(driver,SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver));
		}
		
		// Verify Mercury Network Directory as backup is unchecked
		Assert.assertTrue(SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver).isSelected()==false, "Mercury Network Directory as backup is still checked");
		
		// Save Preferences
		perform.click(driver,SVendorSelectionSettings.save_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for the OK button
		perform.waitForElementToBeClickable(driver, SVendorSelectionSettings.ok_btn(), "id");
		
		// Click OK in saved dialog box
		perform.click(driver,SVendorSelectionSettings.ok_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Clear order information variables before placing a new order
		perform.clearOrderInfoStoredVariables(driver);
		
		// Wait for Orders button
		perform.waitForElementToBeClickable(driver, SOrders.orders_btn(), "cssSelector");
		
		// Go to the Orders page
		perform.click(driver,SOrders.orders_btn(driver));
		
		if (StoredVariables.getbrowser().get().equals("Chrome"))
		{
			Thread.sleep(500);	
		}
		
		// Wait for dropdown options
		perform.waitForElementToBeClickable(driver, SOrders.orders_btn(), "cssSelector");
		
		// Go to Residential Appraisal
		secure.goToResidentialAppraisal(driver);
		
		/***************************************
		 * Set New Order Information
		 ***************************************/
		
		// Set Property Information data
		StoredVariables.getpropertyInformationAddress().set("2621 SW 136th St");
		StoredVariables.getpropertyInformationCity().set("Oklahoma City");
		StoredVariables.getpropertyInformationState().set("Oklahoma");
		StoredVariables.getpropertyInformationStateAbbr().set("OK"); // Must set for a field check later on
		StoredVariables.getpropertyInformationZip().set("73170");
		StoredVariables.getpropertyInformationSqFt().set("5688");
		StoredVariables.getpropertyInformationSiteSize().set("9,583 sq ft");
		StoredVariables.getpropertyInformationPropType().set("Single Family");
		StoredVariables.getpropertyInformationPropRights().set("Fee Simple");
		StoredVariables.getpropertyInformationLegalDesc().set("2844 Guilford Ln, Oklahoma City, OK 73120");
		StoredVariables.getpropertyInformationDirections().set("East of N May Ave and south of NW Britton Rd");
		
		// Set Assignment Information data
		StoredVariables.getassignmentInformationForm().set("Uniform Residential Appraisal (FNMA 1004)");
		StoredVariables.getassignmentInformationRushOrder().set(true);
		StoredVariables.getassignmentInformationComplex().set(true);
		StoredVariables.getassignmentInformationOrderDue().set(7);
		perform.getNewDate(driver, StoredVariables.getassignmentInformationOrderDue().get());
		StoredVariables.getassignmentInformationOtherRefNumber().set("8615406");
		StoredVariables.getassignmentInformationLoanType().set("All In One");
		StoredVariables.getassignmentInformationLoanPurpose().set("Purchase");
		StoredVariables.getassignmentInformationOrderedBy().set("Borrower Name");
		StoredVariables.getassignmentInformationOrderGroup().set("AppraisersGroupTest");
		StoredVariables.getassignmentInformationLoanNumber().set("74108641");
		StoredVariables.getassignmentInformationFileNumber().set("31849");
		StoredVariables.getassignmentInformationSalesPrice().set("645,715");
		StoredVariables.getassignmentInformationFHACaseNumber().set("564193");
		StoredVariables.getassignmentInformationDisclosure().set(0);
		StoredVariables.getassignmentInformationAssignedTo().set("Automation Lender1");
		
		// Set Lender Information data
		StoredVariables.getlenderInformationLenderName().set("BOKF, National Association");
		StoredVariables.getlenderInformationAddress1().set("One Williams Center");
		StoredVariables.getlenderInformationAddress2().set("Suite D");
		StoredVariables.getlenderInformationCity().set("Tulsa");
		StoredVariables.getlenderInformationState().set("OK");
		StoredVariables.getlenderInformationZip().set("74172");
		
		// Set Contact And Access Information data
		StoredVariables.getcontactOccupancy().set("Owner");
		StoredVariables.getcontactBorrower().set("Borrower Name");
		StoredVariables.getcontactBorrowerInfo1Dropdown().set("Home");
		StoredVariables.getcontactBorrowerInfo1().set("405-555-7818");
		StoredVariables.getcontactBorrowerInfo2Dropdown().set("E-mail");
		StoredVariables.getcontactBorrowerInfo2().set("borrower@dntest.net");
		StoredVariables.getcontactBorrowerAddress().set("8051 Falcon Crst");
		StoredVariables.getcontactBorrowerCity().set("Edmond");
		StoredVariables.getcontactBorrowerState().set("OK");
		StoredVariables.getcontactBorrowerZip().set("73034");
		StoredVariables.getcontactCoBorrower().set("Coborrower Name");
		StoredVariables.getcontactCoBorrowerInfo1Dropdown().set("Work");
		StoredVariables.getcontactCoBorrowerInfo1().set("405-555-9813");
		StoredVariables.getcontactCoBorrowerInfo2Dropdown().set("Mobile");
		StoredVariables.getcontactCoBorrowerInfo2().set("405-555-1679");
		StoredVariables.getcontactCoBorrowerAddress().set("1509 Rain Tree Dr");
		StoredVariables.getcontactCoBorrowerCity().set("Moore");
		StoredVariables.getcontactCoBorrowerState().set("OK");
		StoredVariables.getcontactCoBorrowerZip().set("73160");
		StoredVariables.getcontactOwner().set("Owner Name");
		StoredVariables.getcontactOwnerInfo1Dropdown().set("Pager");
		StoredVariables.getcontactOwnerInfo1().set("405-555-8618");
		StoredVariables.getcontactOwnerInfo2Dropdown().set("Fax");
		StoredVariables.getcontactOwnerInfo2().set("405-555-7410");
		StoredVariables.getcontactOccupant().set("Occupant Name");
		StoredVariables.getcontactOccupantInfo1Dropdown().set("Home");
		StoredVariables.getcontactOccupantInfo1().set("405-555-3549");
		StoredVariables.getcontactOccupantInfo2Dropdown().set("Mobile");
		StoredVariables.getcontactOccupantInfo2().set("405-555-8895");
		StoredVariables.getcontactAgent().set("Agent Name");
		StoredVariables.getcontactAgentInfo1Dropdown().set("E-mail");
		StoredVariables.getcontactAgentInfo1().set("agent@dntest.net");
		StoredVariables.getcontactAgentInfo2Dropdown().set("Pager");
		StoredVariables.getcontactAgentInfo2().set("405-555-4893");
		StoredVariables.getcontactOther().set("Other Name");
		StoredVariables.getcontactOtherInfo1Dropdown().set("Work");
		StoredVariables.getcontactOtherInfo1().set("405-555-7825");
		StoredVariables.getcontactOtherInfo2Dropdown().set("Fax");
		StoredVariables.getcontactOtherInfo2().set("405-555-8688");
		StoredVariables.getcontactApptContact().set("Borrower");
		
		// Set Additional Notification Recipients data
		StoredVariables.getadditionalNotificationRecipientsAdditionalEmails().set("additionalEmail1@dntest.net; additionalEmail2@dntest.net");
		StoredVariables.getadditionalNotificationRecipientsAttachCompletedReport().set(true);
		
		// Enter New Order data
		secure.enterNewResidentialAppraisalOrder(driver);
		
		// Click Next
		perform.click(driver,SNewOrder.next_btn(driver));
		
		perform.sleep(driver, 1);
		
		/***********************************************
		 * Confirm Order Page
		 ***********************************************/

		// Wait for the back button
		perform.waitForElementToBeClickable(driver, SConfirmOrder.backTop_btn(), "id");
		
		// Confirm order screen loads
		Assert.assertTrue(driver.getCurrentUrl().contains("ConfirmOrder"), "Order page did not load");
		
		// Verify Vendor Information is correct
		/***********************************************************************
		 * NEED TO PARSE OUT THE VENDORID FROM THE SOURCE CODE AND LOOK IT UP
		 * IN THE DATABASE TO MATCH THE INFORMATION
		 ***********************************************************************/
		int lineNumber = new Exception().getStackTrace()[0].getLineNumber();
		String thisClass = new Exception().getStackTrace()[0].getClassName();
		String thisMethod = new Exception().getStackTrace()[0].getMethodName();
		System.out.println("Line #" + lineNumber + " - " + thisClass + "." + thisMethod + " ***** Need to parse out the vendorid from the source code and look it up in the db to verify vendor info");
		
		secure.verifyOrderDetails(driver);
		
		// Wait for Back
		perform.waitForElementToBeClickable(driver, SConfirmOrder.backTop_btn(), "id");
		
		// Click back
		perform.click(driver,SConfirmOrder.backTop_btn(driver));
		
		// Wait for Address text box
		perform.waitForElementToBeClickable(driver, SNewOrder.address_txtbx(), "id");
		
		secure.verifyNewOrderInfo(driver);
		
		/****************************************************************
		 CODE TO RUN BECAUSE OF A BUG
		 ****************************************************************/
		perform.commentedBug(driver, "After filling out order information and clicking Next, when you go back into the order information, you have "
				+ "to open the borrower/coborrower address and save it again or else it doesn't write to the database.");
		System.out.println("Go back into the borrower address and save it again to get it to write to the database due to a bug");
		// Click Borrower Address button
		perform.click(driver,SNewOrder.borrowerAddress_btn(driver));
		
		// Click Save
		perform.click(driver,SNewOrder.borrowerSave_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Click Co-borrower Address button
		perform.click(driver,SNewOrder.coBorrowerAddress_btn(driver));
		
		// Click Save
		perform.click(driver,SNewOrder.coBorrowerSave_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		/****************************************************************
		 CODE TO RUN BECAUSE OF A BUG
		 ****************************************************************/
		
		// Verify the next button is clickable
		perform.waitForElementToBeClickable(driver, SNewOrder.next_btn(), "id");
		
		// Click Next
		perform.click(driver,SNewOrder.next_btn(driver));
		
		// Wait for fee note checkbox
		perform.waitForElementToBeClickable(driver, SConfirmOrder.readVendorsFeeNotes_chkbx(), "id");
		
		// Verify the 'I have read and understand the vendor's fee notes' checkbox is unchecked
		if (SConfirmOrder.readVendorsFeeNotes_chkbx(driver).isSelected())
		{
			perform.click(driver,SConfirmOrder.readVendorsFeeNotes_chkbx(driver));
		}
		
		// Click Next
		perform.click(driver,SConfirmOrder.nextBottom_btn(driver));
		
		// Wait for message text
		perform.waitForElementToBeClickable(driver, SConfirmOrder.messageOK_btn(), "id");
		
		// Verify popup displays with correct text
		Assert.assertTrue(SConfirmOrder.message_txt(driver).getText().contains("You must agree to the fee notes entered by the vendor."), "Message for not agreeing to vendor notes did not display properly");
		
		perform.waitForElementToBeClickable(driver, SConfirmOrder.messageOK_btn(), "id");
		
		// Click OK
		perform.click(driver,SConfirmOrder.messageOK_btn(driver));
		
		// Wait for the back button to be visible
		perform.waitForElementToBeClickable(driver, SConfirmOrder.backTop_btn(), "id");
		
		// Check the agree to notes checkbox
		if (!SConfirmOrder.readVendorsFeeNotes_chkbx(driver).isSelected())
		{
			perform.click(driver,SConfirmOrder.readVendorsFeeNotes_chkbx(driver));
		}
		
		// Change payment method to check
		perform.selectDropdownOption(driver, SConfirmOrder.paymentMethod_dropdown(driver), "Check");
		
		// Save new order (click next)
		secure.saveNewOrder(driver);
		
		// Get inside the attach document frame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "AttachDocument.aspx", By.id(SConfirmOrder.documentType_dropdown()));
		
		// Select document type
		perform.selectDropdownOption(driver, SConfirmOrder.documentType_dropdown(driver), "Other");
		
		// Wait for upload button
		perform.waitForElementToBeClickable(driver, SConfirmOrder.uploadDocuments_btn(), "id");
		
		// Upload Document
		String filePath = StoredVariables.getdocDir().get()+"Test PDF.pdf";
		secure.uploadDocumentOnSConfirmOrder(driver, filePath);
		
		// Click Close Button
		perform.click(driver,SConfirmOrder.finished_btn(driver));
		
		// Switch back to the attach documents frame
		driver.switchTo().defaultContent();
		
		// Wait for Orders page to load
		perform.waitForElementToBeClickable(driver, SOrders.find_txtbx(), "id");
		
		// Verify you land on the orders grid
		Assert.assertTrue(driver.getCurrentUrl().contains("OrderManagement"), "After completing an order, the orders grid did not load");
		
		// Query the db to get the order number that was just created
		db.getLoanID(driver);
		
		// Wait for the Order Types dropdown
		perform.waitForElementToBeClickable(driver, SOrders.orderTypes_dropdown(), "id");

		// Verify Due date is ordered properly to display the most recent order first
		secure.sortByUpdated(driver);
		
		// Wait for overlay to disappear
		perform.waitForOverlayToBeHidden(driver);
		
		// Verify the order just created is in the orders grid 
		Assert.assertTrue(SOrders.ordersTable_txt(driver).getText().contains(StoredVariables.getloanID().get()), "New order is not displayed");
		
		db.verifyNewOrderDataInDB_All(driver, StoredVariables.getloanID().get());
		
		// Log test
		test.log(LogStatus.INFO, "Round Trip", "Ran through the New Order process");
		
	} // end verifyDataInDB
	
} // end the OrderManagement class
