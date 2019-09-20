package regressionEligibleVendors;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjects.Secure.SConfirmOrder;
import pageObjects.Secure.SEligibleVendors;
import pageObjects.Secure.SNewOrder;
import pageObjects.Secure.SOrderDetails;
import pageObjects.Secure.SOrders;
import pageObjects.Secure.SVendorSelectionSettings;
import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Eligible Vendors - Link Shows Non Fee Panel And Fee Panel Vendors</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class LinkShowsNonFeePanelAndFeePanelVendors extends TestSetup {
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Click Preferences &gt; VSS</li>
	 * 	<li>Click Commercial tab</li>
	 * 	<li>Turn on Allow order bidding</li>
	 * 	<li>Turn on Automatic vendor selection</li>
	 * 	<li>'Select at least' [a number higher than your total eligible fee panel vendors]</li>
	 * 	<li>'and at most' [equal to or greater than above number]</li>
	 * 	<li>Use 'Custom fee panel'</li>
	 * 	<li>'Use Mercury Network as a backup'</li>
	 * 	<li>Save</li>
	 * 	<li>Click Orders</li>
	 * 	<li>Set Property Information data</li>
	 * 	<li>Set Assignment Information data</li>
	 * 	<li>Set Lender Information data</li>
	 * 	<li>Set Contact And Access Information data</li>
	 * 	<li>Set Additional Notification Recipients data</li>
	 * 	<li>Enter New Order data</li>
	 * 	<li>Click Next</li>
	 * 	<li>Verify Confirm Order url</li>
	 * 	<li>Verify order details</li>
	 * 	<li>Click Next</li>
	 * 	<li>Get inside the attach document frame</li>
	 * 	<li>Select document type</li>
	 * 	<li>Upload Document</li>
	 * 	<li>Click Finished Button</li>
	 * 	<li>Switch back to the attach documents frame</li>
	 * 	<li>Verify you land on the orders grid</li>
	 * 	<li>Query the db to get the order number that was just created</li>
	 * 	<li>Search for new order</li>
	 * 	<li>Verify the order is in the correct status</li>
	 * 	<li>Verify the order just created is in the orders grid</li>
	 * 	<li>Verify data in the database</li>
	 * 	<li>Open order</li>
	 * 	<li>Get the audit trail text</li>
	 * 	<li>Verify delayed is in the history</li>
	 * 	<li>Verify View eligible vendors link</li>
	 * 	<li>Click the View eligible vendors link</li>
	 * 	<li>Verify dialog text</li>
	 * 	<li>Set empty rowText variable</li>
	 * 	<li>Set iteration for loop</li>
	 * 	<li>Set expectedVendor to false</li>
	 * 	<li>Get the number of rows for eligible vendors</li>
	 * 	<li>iterate through the rows</li>
	 * 	<li>Get row text</li>
	 * 	<li>Set checkbox cssSelector</li>
	 * 	<li>Verify fee panel vendors show a check mark in this column</li>
	 * 	<li>Verify the vendors are correct</li>
	 * 	<li>Verify the 'Fee panel' column exists</li>
	 * 	<li>Log test</li>
	 * </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Vendor Selection Settings", "Secure - Create Order", "Secure - Orders", "Eligible Vendors"}, alwaysRun=true)
	public void linkShowsNonFeePanelAndFeePanelVendors() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Log in to Secure
		secure.login(driver, "RegressionSecure7", StoredVariables.getpassword().get());
		
		// Click Preferences > VSS
		secure.goToVendorSelectionSettings(driver);
		
		// Click Commercial tab
		perform.click(driver,SVendorSelectionSettings.commercialAppraisers_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for Allow order bidding button
		perform.waitForElementToBeClickable(driver, SVendorSelectionSettings.requireValidLicense_chkbx(), "id");
		
		// Turn on Allow order bidding
		WebElement allowOrderBidding = SVendorSelectionSettings.allowOrderBidding_btn(driver);
		String src = allowOrderBidding.getAttribute("src");
		System.out.println("allowOrderBidding src = " + src);
		if (src.contains("switchOff.png"))
		{
			System.out.println("Turn on Allow order bidding");
			perform.click(driver,allowOrderBidding);
		}
		
		// Wait for Automatic Vendor Selection button
		perform.waitForElementToBeClickable(driver, SVendorSelectionSettings.automaticVendorSelection_switch(), "id");
		
		// Turn on Automatic vendor selection
//		WebElement autoVendorSelect = SVendorSelectionSettings.automaticVendorSelection_switch(driver);
//		src = autoVendorSelect.getAttribute("src");
//		System.out.println("autoVendorSelect src = " + src);
//		if (src.contains("switchOff.png"))
//		{
//			System.out.println("Turn on Automatic vendor selection");
//			SVendorSelectionSettings.automaticVendorSelection_switch(driver));
//		}
//		
//		Thread.sleep(3000);
		String disabled = driver.findElement(By.id("lblMinVendors1")).getAttribute("class");
		if (disabled.equals("Disabled"))
		{
			perform.click(driver,SVendorSelectionSettings.automaticVendorSelection_switch(driver));
		}
		
		// Wait for Select at least textbox
		perform.waitForElementToBeClickable(driver, SVendorSelectionSettings.selectAtLeast_txtbx(), "id");
		
		// 'Select at least' [a number higher than your total eligible fee panel vendors]
		SVendorSelectionSettings.selectAtLeast_txtbx(driver).clear();
		perform.type(driver,SVendorSelectionSettings.selectAtLeast_txtbx(driver), "3");
		
		// 'and at most' [equal to or greater than above number]
		SVendorSelectionSettings.andAtMost_txtbx(driver).clear();
		perform.type(driver,SVendorSelectionSettings.andAtMost_txtbx(driver), "5");		
		
		// Use 'Custom fee panel'
		perform.click(driver,SVendorSelectionSettings.customFeePanel_radio(driver));
		
		// 'Use Mercury Network as a backup'
		if (SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver).isSelected()==false)
		{
			perform.click(driver,SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver));
		}
		
		// Save
		secure.saveVendorSelectionSettings(driver);
		
		// Click Orders
		secure.goToCommercialAppraisal(driver);
		
		/***************************************
		 * Set New Order Information
		 ***************************************/
		perform.clearOrderInfoStoredVariables(driver);
		// Set Property Information data
		StoredVariables.getpropertyInformationAddress().set("501-D NE 122nd St");
		StoredVariables.getpropertyInformationCity().set("Oklahoma City");
		StoredVariables.getpropertyInformationState().set("Oklahoma");
		StoredVariables.getpropertyInformationStateAbbr().set("OK"); // Must set for a field check later on
		StoredVariables.getpropertyInformationZip().set("73114");
		StoredVariables.getpropertyInformationSqFt().set("5688");
		StoredVariables.getpropertyInformationSiteSize().set("9,583 sq ft");
		StoredVariables.getpropertyInformationPropType().set("Office");
		StoredVariables.getpropertyInformationPropRights().set("Fee Simple");
		StoredVariables.getpropertyInformationLegalDesc().set("501-D NE 122nd St");
		StoredVariables.getpropertyInformationDirections().set("122nd and Kelley");
		
		// Set Assignment Information data
		StoredVariables.getassignmentInformationForm().set("Commercial Appraisal Report");
		StoredVariables.getassignmentInformationRushOrder().set(true);
		StoredVariables.getassignmentInformationComplex().set(true);
		StoredVariables.getassignmentInformationIssueAsBid().set(true);
		StoredVariables.getassignmentInformationOrderDue().set(7);
		perform.getNewDate(driver, StoredVariables.getassignmentInformationOrderDue().get());
		StoredVariables.getassignmentInformationOtherRefNumber().set(perform.randomNumbers(driver, 7));
		StoredVariables.getassignmentInformationLoanType().set("All In One");
		StoredVariables.getassignmentInformationLoanPurpose().set("Purchase");
		StoredVariables.getassignmentInformationOrderedBy().set("Borrower Name");
		StoredVariables.getassignmentInformationOrderGroup().set("");
		StoredVariables.getassignmentInformationLoanNumber().set(perform.randomNumbers(driver, 8));
		StoredVariables.getassignmentInformationFileNumber().set(perform.randomNumbers(driver, 5));
		StoredVariables.getassignmentInformationSalesPrice().set("645,715");
		StoredVariables.getassignmentInformationFHACaseNumber().set(perform.randomNumbers(driver, 6));
		StoredVariables.getassignmentInformationDisclosure().set(0);
		StoredVariables.getassignmentInformationAssignedTo().set("Automation RegressionSecure7");
		
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
		secure.enterNewCommercialAppraisalOrder(driver);
		
		// Click Next
		perform.click(driver,SNewOrder.next_btn(driver));
		
		// Wait for Next button
		perform.waitForElementToBeClickable(driver, SConfirmOrder.nextTop_btn(), "id");
		
		// Verify Confirm Order url
		Assert.assertTrue(driver.getCurrentUrl().contains("ConfirmOrder"), "The Confirm Order screen did not load properly");
		
		// Verify order details
		secure.verifyOrderDetails(driver);
		
		// Click Next
		perform.click(driver,SConfirmOrder.nextBottom_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Get inside the attach document frame
//		perform.waitForiFrameSrcAndSwitchToIt(driver, "AttachDocument.aspx", By.id(SConfirmOrder.documentType_dropdown()));
		perform.switchToiFrameByID(driver, "iframeAttach");
		
		// Select document type
		perform.selectDropdownOption(driver, SConfirmOrder.documentType_dropdown(driver), "Other");
		
		// Wait for upload button
		perform.waitForElementToBeClickable(driver, SConfirmOrder.uploadDocuments_btn(), "id");
		
		// Upload Document
		String filePath = StoredVariables.getdocDir().get()+"Test PDF.pdf";
		secure.uploadDocumentOnSConfirmOrder(driver, filePath);
		
		// Click Finished Button
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

		// Search for new order
		String trackingNumber = StoredVariables.gettrackingNumber().get();
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Verify the order is in the correct status
		Assert.assertTrue(SOrders.ordersTable_txt(driver).getText().contains("Out for Bid"), "The order is not in the correct status");
		
		// Verify the order just created is in the orders grid 
		Assert.assertTrue(SOrders.ordersTable_txt(driver).getText().contains(trackingNumber), "New order is not displayed");
		
		// Verify data in the database
		db.verifyNewOrderDataInDB_All(driver, StoredVariables.getloanID().get());
		
		// Open order
		perform.doubleClickInTable(driver, trackingNumber);
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Get the audit trail text
		String history = SOrderDetails.history_txt(driver).getText();
		
		// Verify delayed is in the history
		Assert.assertTrue(history.contains("Out for Bid by Client (Automation RegressionSecure7)"), "Out for Bid by Client (Automation RegressionSecure7) is missing from the order information");
		Assert.assertTrue(history.contains("View eligible vendors"), "View eligible vendors is missing from the order information");
		
		// Verify View eligible vendors link
		Assert.assertTrue(driver.findElement(By.linkText("View eligible vendors")).isDisplayed(), "The View eligible vendors link is not displayed");
		
		// Click the View eligible vendors link
		perform.click(driver,driver.findElement(By.linkText("View eligible vendors")));
		
		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for Close button
		perform.waitForElementToBeClickable(driver, SEligibleVendors.close_btn(), "id");
		
		// Wait for dialog text
		perform.waitForElementToBeClickable(driver, SEligibleVendors.dialog_txt(), "id");
		
		// Verify dialog text
		Assert.assertTrue(SEligibleVendors.dialog_txt(driver).getText().contains("The following vendors from the Fee Panel and ISS Ranked were considered for this order when placed. The selected vendors are highlighted."), "The dialog text is incorrect");

	    // Set empty rowText variable
	    String rowText = "";
	    
	    // Set iteration for loop
	    int a = 1;
    	
	    // Set expectedVendor to false
    	boolean expectedAutomationVendor = false;
    	boolean expectedNonAutomationVendor = false;
    	
		// Get the number of rows for eligible vendors
	    List<WebElement> eligibleVendors = driver.findElements(By.cssSelector("#tblEligibleVendors > tbody > tr"));
    	
    	System.out.println("\nEligible vendors:");
    	// iterate through the rows
    	for ( WebElement row: eligibleVendors) {
	    	
	        // Get row text
	    	rowText = row.getText();
	    	System.out.println("rowText = " + rowText);
	    	
	    	// Set checkbox cssSelector
	    	String checkboxSelector = "#tblEligibleVendors > tbody > tr:nth-child(" + a + ") > td:nth-child(8) > img";
	    	
	    	// Verify fee panel vendors show a check mark in this column
	    	if (rowText.contains("Automation"))
	    	{
	    		expectedAutomationVendor = true;
	    		WebElement checkbox = driver.findElement(By.cssSelector(checkboxSelector));
	    		Assert.assertTrue(checkbox.getAttribute("src").contains("Checkmark-13-white.png"), "The checkbox for the fee panel member is missing");
	    	}
	    	if (!rowText.contains("Automation"))
	    	{
	    		expectedNonAutomationVendor = true;
	    	}
	    	
	    	a++;
	    	
	    } // end for loop
    	System.out.println("");
	    
    	// Verify the vendors are correct
    	Assert.assertTrue(expectedAutomationVendor==true && expectedNonAutomationVendor==true, "There should be both autoamtion and non-automation vendors in the list that is in the Fee Panel for RegressionSecure7");
		
		// Verify the 'Fee panel' column exists 
    	Assert.assertTrue(SEligibleVendors.feePanelColumn_txt(driver).isDisplayed()==true, "The Fee panel column is missing from the table");
    	
		// Log test
		test.log(LogStatus.INFO, "Eligible Vendors", "Verified View elibible vendors link shows both non-fee panel and fee panel vendors");
		
	} // end linkShowsNonFeePanelAndFeePanelVendors
	
} // end the linkShowsNonFeePanelAndFeePanelVendors class
