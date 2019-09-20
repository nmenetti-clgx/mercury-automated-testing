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
import pageObjects.Secure.SVendorAssignment;
import pageObjects.Secure.SVendorSelectionSettings;
import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Eligible Vendors - Link Shows Non Fee Panel Vendors Only</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class LinkShowsNonFeePanelVendorsOnly extends TestSetup {
	
	/** The secure username. */
	private final String secureUsername = "RegressionSecure6";
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Click Preferences &gt; VSS</li>
	 * 	<li>Turn on Automatic vendor selection</li>
	 * 	<li>Set RAS to use Mercury Network directory</li>
	 * 	<li>Save</li>
	 * 	<li>Click Orders</li>
	 * 	<li>Enter New Order data</li>
	 * 	<li>Click Next</li>
	 * 	<li>Switch frame</li>
	 * 	<li>Click Approve</li>
	 * 	<li>Switch out of frame</li>
	 * 	<li>Check I have read and understand checkbox if it exists</li>
	 * 	<li>Check I have read and understand checkbox</li>
	 * 	<li>Click Next</li>
	 * 	<li>Get outside frames</li>
	 * 	<li>Get inside the attach document frame</li>
	 * 	<li>Click Finished</li>
	 * 	<li>Query the db to get the order number that was just created</li>
	 * 	<li>Get Vendor the order is assigned to</li>
	 * 	<li>Go to Orders</li>
	 * 	<li>Search for order</li>
	 * 	<li>Open order</li>
	 * 	<li>Get the audit trail text</li>
	 * 	<li>Verify delayed is in the history</li>
	 * 	<li>Verify View eligible vendors link</li>
	 * 	<li>Click the View eligible vendors link</li>
	 * 	<li>Verify dialog text</li>
	 * 	<li>Get the number of rows for eligible vendors</li>
	 * 	<li>Set expectedVendor to false</li>
	 * 	<li>Get row text</li>
	 * 	<li>A different account not created by DLN and is now expected in the list</li>
	 * 	<li>Verify the vendor is expected</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Vendor Selection Settings", "Secure - Create Order", "Secure - Orders", "Eligible Vendors"}, alwaysRun=true)
	public void linkShowsNonFeePanelVendorsOnly() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		String password = StoredVariables.getpassword().get();
		
		// Log in to Secure
		secure.login(driver, secureUsername, password);
		
		// Click Preferences > VSS
		secure.goToVendorSelectionSettings(driver);
		
		// Turn on Automatic vendor selection
		if (SVendorSelectionSettings.automaticOrderAssignment_switch(driver).getAttribute("src").contains("switchOff.png"))
		{
			perform.click(driver,SVendorSelectionSettings.automaticOrderAssignment_switch(driver));
		}
		
		// Set RAS to use Mercury Network directory
		perform.click(driver,SVendorSelectionSettings.mercuryNetworkDirectory_radio(driver));
		
		// Save
		secure.saveVendorSelectionSettings(driver);
		
//		// Click Orders
//		secure.goToResidentialAppraisal(driver);
//		
//		/***************************************
//		 * Set New Order Information
//		 ***************************************/
//		perform.clearOrderInfoStoredVariables(driver);
//		secure.setNewResidentialAppraisalOrderVariablesMinimum(driver);
//		
//		// Enter New Order data
//		secure.enterNewResidentialAppraisalOrder(driver);
//		
//		// Click Next
//		perform.click(driver,SNewOrder.next_btn(driver));
//		
//		// Wait for busy to be hidden
//		perform.waitForBusyToBeHidden(driver);
//		
//		// Wait for overlay to be visible
//		perform.waitForOverlayToBeVisible(driver);
//
//		// Switch frame
//		Thread.sleep(3000);
//		perform.waitForiFrameSrcAndSwitchToIt(driver, "/Admin/NewOrder/AutoAssignmentApproval.aspx", By.id(SVendorAssignment.approve_btn()));
//		
//		// Wait for Approve button
//		perform.waitForElementToBeClickable(driver, SVendorAssignment.approve_btn(driver));
//		
//		// Click Approve
//		perform.click(driver,SVendorAssignment.approve_btn(driver));
//		
//		// Wait for overlay to be hidden
//		perform.waitForOverlayToBeHidden(driver);
//		
//		// Switch out of frame
//		driver.switchTo().defaultContent();
//		
//		// Wait for the Payment Method dropdown
//		perform.waitForElementToBeClickable(driver, SConfirmOrder.paymentMethod_dropdown(driver));
//		
//		// Check the Payment Method dropdown for data
//		String dropdownOption = perform.getSelectedDropdownOption(driver, SConfirmOrder.paymentMethod_dropdown(driver));
		
		// Enter the order
		String dropdownOption = enterOrder(driver);
		
		// If the dropdown option is blank, retry loading the screen
		int a = 1;
		while (dropdownOption==null && a <= 10) {
			
			System.out.println("The Payment Method dropdown is empty. Refreshing the screen " + a + " of 10 tries");
			
			// Click Cancel
			perform.click(driver, SConfirmOrder.cancel_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			// Restart test
			dropdownOption = enterOrder(driver);
			
			a++;
			
		} // end while
		
		// Check I have read and understand checkbox if it exists
		if (driver.findElements(By.id(SConfirmOrder.readVendorsFeeNotes_chkbx())).size() != 0)
		{		
			// Check I have read and understand checkbox
			if (!SConfirmOrder.readVendorsFeeNotes_chkbx(driver).isSelected())
			{
				perform.click(driver,SConfirmOrder.readVendorsFeeNotes_chkbx(driver));
			}
		} // end if
		
		// Click Finish
		perform.click(driver,SConfirmOrder.finishBottom_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for frames
		perform.waitForIFrames(driver);
		
		// Get outside frames
		driver.switchTo().defaultContent();
		// Get inside the attach document frame
		driver.switchTo().frame("iframeAttach");
		
		// Wait for message text
		perform.waitForElementToBeClickable(driver, SConfirmOrder.uploadDocuments_btn(), "id");
		
		// Click Finished
		perform.click(driver,SConfirmOrder.finished_btn(driver));
		
		// Switch out of iFrame
		driver.switchTo().defaultContent();
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Query the db to get the order number that was just created
		db.getLoanID(driver);
		
		// Get Vendor the order is assigned to
		String trackingNumber = StoredVariables.gettrackingNumber().get();
		String vendorLastName = db.getVendorLastNameFromLoanID(driver, StoredVariables.getloanID().get());
		
		// Go to Orders
		secure.goToOrders(driver);
		
		// Search for order
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Open order
		perform.doubleClickInTable(driver, trackingNumber);
		
		// Wait for History
		perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(), "id");
		
		// Get the audit trail text
		String history = SOrderDetails.history_txt(driver).getText();
		
		// Verify delayed is in the history
		Assert.assertTrue(history.contains("Awaiting acceptance by "), "Awaiting acceptance by is missing from the order information");
		Assert.assertTrue(history.contains(vendorLastName), vendorLastName + " is missing from the order information");
		Assert.assertTrue(!history.contains("Awaiting acceptance by Automation Appraiser"), "Awaiting acceptance by Automation Appraiser is in the audit trail and shouldn't be");
		Assert.assertTrue(history.contains("View eligible vendors"), "View eligible vendors is missing from the order information");
		
		// Verify View eligible vendors link
		Assert.assertTrue(driver.findElement(By.linkText("View eligible vendors")).isDisplayed(), "The View eligible vendors link is not displayed");
		
		// Click the View eligible vendors link
		perform.click(driver,driver.findElement(By.linkText("View eligible vendors")));
		
		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for Close button
		perform.waitForElementToBeClickable(driver, SEligibleVendors.close_btn(), "id");
		
		// Verify dialog text
		Assert.assertTrue(SEligibleVendors.dialog_txt(driver).getText().contains("The following vendors from the ISS Ranked were considered for this order when placed. The assigned vendor is highlighted."), "The dialog text is incorrect");
		
		// Get the number of rows for eligible vendors
	    List<WebElement> eligibleVendors = driver.findElements(By.cssSelector("#tblEligibleVendors > tbody > tr"));
	    String rowText = "";
	    for ( WebElement row: eligibleVendors) {
	    	
	    	// Set expectedVendor to false
	    	boolean expectedVendor = true;
	    	
	        // Get row text
	    	rowText = row.getText();
	    	System.out.println("rowText = " + rowText);
	    	if (rowText.contains("Automation Appraiser"))
	    	{
    			expectedVendor = false;
	    	} // end if
	    	
	    	// Verify the vendor is expected
	    	Assert.assertTrue(expectedVendor==true, "There should not be an autoamtion vendor in the list that is in the Fee Panel for RegressionSecure6");
	    	
	    } // end for loop
		
		// Log test
		test.log(LogStatus.INFO, "Eligible Vendors", "Verified View elibible vendors link shows non-fee panel vendors only");
		
	} // end linkShowsNonFeePanelVendorsOnly
	
	// Enter the order
	private String enterOrder (RemoteWebDriver driver) throws Exception {
	
		// Click Orders
		secure.goToResidentialAppraisal(driver);
		
		/***************************************
		 * Set New Order Information
		 ***************************************/
		perform.clearOrderInfoStoredVariables(driver);
		secure.setNewResidentialAppraisalOrderVariablesMinimum(driver);
		
		// Enter New Order data
		secure.enterNewResidentialAppraisalOrder(driver);
		
		// Click Next
		perform.click(driver,SNewOrder.next_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);

		// Switch frame
		Thread.sleep(3000);
		perform.waitForiFrameSrcAndSwitchToIt(driver, "/Admin/NewOrder/AutoAssignmentApproval.aspx", By.id(SVendorAssignment.approve_btn()));
		
		// Wait for Approve button
		perform.waitForElementToBeClickable(driver, SVendorAssignment.approve_btn(driver));
		
		// Click Approve
		perform.click(driver,SVendorAssignment.approve_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Switch out of frame
		driver.switchTo().defaultContent();
		
		// Wait for the Payment Method dropdown
		perform.waitForElementToBeClickable(driver, SConfirmOrder.paymentMethod_dropdown(driver));
		
		// Check the Payment Method dropdown for data
		String dropdownOption = perform.getSelectedDropdownOption(driver, SConfirmOrder.paymentMethod_dropdown(driver));
		
		return dropdownOption;
		
	} // end enterOrder
	
} // end the linkShowsNonFeePanelVendorsOnly class
