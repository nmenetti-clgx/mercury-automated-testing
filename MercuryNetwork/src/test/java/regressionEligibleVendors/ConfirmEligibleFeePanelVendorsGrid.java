package regressionEligibleVendors;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjects.Secure.SModifySelectionSettings;
import pageObjects.Secure.SOrderDetails;
import pageObjects.Secure.SVendorSelectionSettings;
import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Eligible Vendors - Confirm Eligible Fee Panel Vendors Grid</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class ConfirmEligibleFeePanelVendorsGrid extends TestSetup {
	
	/** The Constant userSecure. */
	private final static String userSecure = "RegressionSecure9";
	
	/** The Constant userVendors. */
	private final static String userVendors = "Appraiser1";
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Go to Vendor Selection Settings</li>
	 * 	<li>Turn off Double-blind Communication switch</li>
	 * 	<li>Disable Automatic Vendor Selection</li>
	 * 	<li>Select Custom Fee Panel</li>
	 * 	<li>Uncheck Use Mercury Network Directory as backup checkbox</li>
	 * 	<li>Verify Mercury Network Directory as backup is unchecked</li>
	 * 	<li>Save Preferences</li>
	 * 	<li>Click OK in saved dialog box</li>
	 * 	<li>Create order and assign it to an appraiser</li>
	 * 	<li>Assign the order</li>
	 * 	<li>Log in as the vendor</li>
	 * 	<li>Decline the order</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Search for the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Confirm Eligible fee panel vendors displays in top right of order details</li>
	 * 	<li>Confirm the Eligible fee panel vendors pod does not display</li>
	 * 	<li>Confirm only eligible vendors on the custom fee panel are displayed</li>
	 * 	<li>Get the number of rows for eligible vendors</li>
	 * 	<li>Set expectedVendor to false</li>
	 * 	<li>Get row text</li>
	 * 	<li>Verify the vendor is expected</li>
	 * 	<li>Confirm if you change the vendor requirements via Modify selection settings the eligible vendors list is updated to match</li>
	 * 	<li>Click Modify selection settings button</li>
	 * 	<li>Check Require local vendor</li>
	 * 	<li>Enter 5 miles</li>
	 * 	<li>Click OK</li>
	 * 	<li>Confirm Eligible fee panel vendors table updated</li>
	 * 	<li>Click Modify selection settings button</li>
	 * 	<li>Uncheck Require local vendor</li>
	 * 	<li>Click OK</li>
	 * 	<li>Confirm Eligible fee panel vendors table updated</li>
	 * 	<li>Confirm you can check to select one or more vendors to contact</li>
	 * 	<li>Get checkbox element of both vendors</li>
	 * 	<li>Verify both check boxes are unchecked</li>
	 * 	<li>Check both vendors</li>
	 * 	<li>Get elements again</li>
	 * 	<li>Verify both vendors are checked</li>
	 * 	<li>Confirm you can click Email after selecting vendors</li>
	 * 	<li>Click Email</li>
	 * 	<li>Verify dialog text</li>
	 * 	<li>Confirm the Send button is not activated until you have entered text, or used a quicklist item (Spaces and Line Breaks/Returns do not count)</li>
	 * 	<li>Enter text into the message</li>
	 * 	<li>Verify Send button is now enabled</li>
	 * 	<li>Click Send</li>
	 * 	<li>Handle the alert dialog</li>
	 * 	<li>Refresh the page</li>
	 * 	<li>Verify history text</li>
	 * 	<li>Set the order to double-blind via the Modify selection settings</li>
	 * 	<li>Click Modify selection settings button</li>
	 * 	<li>Turn on Double-Blind</li>
	 * 	<li>Click OK</li>
	 * 	<li>Confirm the Eligible fee panel vendors pod does not display</li>
	 * 	<li>Go to Vendor Selection Settings</li>
	 * 	<li>Turn off Double-blind Communication switch</li>
	 * 	<li>Disable Automatic Vendor Selection</li>
	 * 	<li>Select Mercury Network directory</li>
	 * 	<li>Save Preferences</li>
	 * 	<li>Click OK in saved dialog box</li>
	 * 	<li>Create order and assign it to an appraiser</li>
	 * 	<li>Assign the order</li>
	 * 	<li>Log in as the vendor</li>
	 * 	<li>Decline the order</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Search for the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Confirm the Eligible fee panel vendors pod does not display</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Vendors Selection Settings", "Secure - Create Order", "Secure - Orders", "Vendors - Decline Order", "Eligible Vendors", "Secure - Modify Selection Settings", "Vendors - Orders"}, alwaysRun=true)
	public void confirmEligibleFeePanelVendorsGrid() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		String password = StoredVariables.getpassword().get();
		
		// Login to Secure
		secure.login(driver, userSecure, password);
		
		// Go to Vendor Selection Settings
		secure.goToVendorSelectionSettings(driver);
		
		// Turn off Double-blind Communication switch
		if (!SVendorSelectionSettings.doubleBlind_switch(driver).getAttribute("src").contains("switchOff.png"))
		{
			perform.click(driver,SVendorSelectionSettings.doubleBlind_switch(driver));
		}
		
		// Disable Automatic Vendor Selection
		if (SVendorSelectionSettings.automaticOrderAssignment_switch(driver).getAttribute("src").contains("switchOn.png"))
		{
			perform.click(driver,SVendorSelectionSettings.automaticOrderAssignment_switch(driver));
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
		
		// Wait for the OK button to be visible
		perform.waitForElementToBeClickable(driver, SVendorSelectionSettings.ok_btn(), "id");
		
		// Click OK in saved dialog box
		perform.click(driver,SVendorSelectionSettings.ok_btn(driver));
		
		// Create order and assign it to an appraiser
		perform.apiPlaceOrderFromSecure(driver, userSecure, password, "PlaceMNOrder-ConfirmEligibleFeePanelVendorsGrid");
		// Assign the order
		String trackingNumber = StoredVariables.gettrackingNumber().get();
		secure.loginAndAssignOrderToAppraiser(driver, userSecure, password, trackingNumber, userVendors);
		
		// Log in as the vendor
		vendors.login(driver, userVendors, password);
		
		// Decline the order
		vendors.declineOrder(driver, trackingNumber);
		
		// Login to Secure
		secure.login(driver, userSecure, password);
		
		// Search for the order
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Open the order
		secure.openOrder(driver, trackingNumber);
		
		// Confirm Eligible fee panel vendors displays in top right of order details
		WebElement element = SOrderDetails.eligibleFeePanelVendors_txt(driver);
		perform.waitForText(driver, element, "Vendor Name");
		String eligibleFeePanelVendors = element.getText();
		Assert.assertTrue(eligibleFeePanelVendors.contains("Eligible fee panel vendors"), "The Eligible fee panel vendors is not displayed properly");
		Assert.assertTrue(eligibleFeePanelVendors.contains("Vendor Name"), "The Eligible fee panel vendors is not displayed properly");
		Assert.assertTrue(eligibleFeePanelVendors.contains("Priority"), "The Eligible fee panel vendors is not displayed properly");
		Assert.assertTrue(eligibleFeePanelVendors.contains("Miles"), "The Eligible fee panel vendors is not displayed properly");
		Assert.assertTrue(eligibleFeePanelVendors.contains("Automation Appraiser1"), "The Eligible fee panel vendors is not displayed properly");
		Assert.assertTrue(eligibleFeePanelVendors.contains("Automation Appraiser3"), "The Eligible fee panel vendors is not displayed properly");
		
		// Confirm the Eligible fee panel vendors pod does not display
	    Assert.assertTrue(SOrderDetails.page_txt(driver).getText().contains("Eligible fee panel vendors"), "The Eligible fee panel vendors table should not be displayed after double blind has been turned on");
		
		// Confirm only eligible vendors on the custom fee panel are displayed
		// Get the number of rows for eligible vendors
	    List<WebElement> eligibleVendors = driver.findElements(By.cssSelector("#grdEligibleVendors > tbody > tr"));
	    String rowText = "";
	    for ( WebElement row: eligibleVendors) {
	    	
	    	// Set expectedVendor to false
	    	boolean expectedVendor = false;
	    	
	        // Get row text
	    	rowText = row.getText();
	    	System.out.println("rowText = " + rowText);
	    	if (rowText.contains("Automation Appraiser3") || rowText.contains("Automation Appraiser1"))
	    	{
	    		expectedVendor = true;
	    	}
	    	else
	    	{
	    		expectedVendor = false;
	    	}
	    	
	    	// Verify the vendor is expected
	    	Assert.assertTrue(expectedVendor==true, "There is an unexpected vendor in the list");
	    	
	    } // end for loop
		
		// Confirm if you change the vendor requirements via Modify selection settings the eligible vendors list is updated to match
		// Click Modify selection settings button
	    perform.click(driver, SOrderDetails.modifySelectionSettings_btn(driver));
	    
	    // Wait for overlay
	    perform.waitForOverlayToBeVisible(driver);
	    
	    // Wait for Require local vendor
	    perform.waitForElementToBeClickable(driver, SModifySelectionSettings.requireLocalVendor_chkbx(), "id");
	    
	    // Check Require local vendor
	    perform.checkCheckbox(driver, SModifySelectionSettings.requireLocalVendor_chkbx(driver));
	    
	    // Wait for located within textbox
	    perform.waitForElementToBeClickable(driver, SModifySelectionSettings.locatedWithin_txtbx(), "id");
	    
	    // Enter 5 miles
	    SModifySelectionSettings.locatedWithin_txtbx(driver).clear();
	    perform.type(driver, SModifySelectionSettings.locatedWithin_txtbx(driver), "5");
	    
	    // Click OK
	    perform.click(driver,SModifySelectionSettings.okPreVendorSelect_btn(driver));
	    
	    // Wait for overlay to be hidden
	    perform.waitForOverlayToBeHidden(driver);
	    
	    // Confirm Eligible fee panel vendors table updated
		element = SOrderDetails.eligibleFeePanelVendors_txt(driver);
		perform.waitForText(driver, element, "There are no vendors");
	    eligibleFeePanelVendors = element.getText();
		Assert.assertTrue(eligibleFeePanelVendors.contains("There are no vendors who meet your selection criteria. You may modify selection settings to change your criteria."), "The Eligible fee panel vendors did not update");
	    
		// Click Modify selection settings button
		perform.click(driver, SOrderDetails.modifySelectionSettings_btn(driver));
	    
	    // Wait for overlay
	    perform.waitForOverlayToBeVisible(driver);
	    
	    // Wait for Require local vendor
	    perform.waitForElementToBeClickable(driver, SModifySelectionSettings.requireLocalVendor_chkbx(), "id");
	    
	    // Uncheck Require local vendor
	    perform.uncheckCheckbox(driver, SModifySelectionSettings.requireLocalVendor_chkbx(driver));
	    
	    // Click OK
	    perform.click(driver,SModifySelectionSettings.okPreVendorSelect_btn(driver));
	    
	    // Wait for overlay to be hidden
	    perform.waitForOverlayToBeHidden(driver);
	    
	    // Confirm Eligible fee panel vendors table updated
		element = SOrderDetails.eligibleFeePanelVendors_txt(driver);
		perform.waitForText(driver, element, "Vendor Name");
	    eligibleFeePanelVendors = element.getText();
		Assert.assertTrue(eligibleFeePanelVendors.contains("Eligible fee panel vendors"), "The Eligible fee panel vendors is not displayed properly");
		Assert.assertTrue(eligibleFeePanelVendors.contains("Vendor Name"), "The Eligible fee panel vendors is not displayed properly");
		Assert.assertTrue(eligibleFeePanelVendors.contains("Priority"), "The Eligible fee panel vendors is not displayed properly");
		Assert.assertTrue(eligibleFeePanelVendors.contains("Miles"), "The Eligible fee panel vendors is not displayed properly");
		Assert.assertTrue(eligibleFeePanelVendors.contains("Automation Appraiser1"), "The Eligible fee panel vendors is not displayed properly");
		Assert.assertTrue(eligibleFeePanelVendors.contains("Automation Appraiser3"), "The Eligible fee panel vendors is not displayed properly");
	    
		// Confirm you can check to select one or more vendors to contact
		// Get checkbox element of both vendors
		WebElement firstVendor = driver.findElement(By.cssSelector("#grdEligibleVendors > tbody > tr:nth-child(1) > td:nth-child(1) > img"));
		WebElement secondVendor = driver.findElement(By.cssSelector("#grdEligibleVendors > tbody > tr:nth-child(2) > td:nth-child(1) > img"));
		
		// Verify both check boxes are unchecked
		Assert.assertTrue(firstVendor.getAttribute("src").contains("/images/Checkmark-Small-Unchecked.O.png"), "The vendor should not be checked yet");
		Assert.assertTrue(secondVendor.getAttribute("src").contains("/images/Checkmark-Small-Unchecked.O.png"), "The vendor should not be checked yet");
		
		// Check both vendors
		perform.click(driver,firstVendor);
		perform.click(driver,secondVendor);
		
		// Get elements again
		firstVendor = driver.findElement(By.cssSelector("#grdEligibleVendors > tbody > tr:nth-child(1) > td:nth-child(1) > img"));
		secondVendor = driver.findElement(By.cssSelector("#grdEligibleVendors > tbody > tr:nth-child(2) > td:nth-child(1) > img"));
		
		// Verify both vendors are checked
		Assert.assertTrue(firstVendor.getAttribute("src").contains("/images/Checkmark-Small-Checked-Blue.O.png"), "The vendor should not be checked yet");
		Assert.assertTrue(secondVendor.getAttribute("src").contains("/images/Checkmark-Small-Checked-Blue.O.png"), "The vendor should not be checked yet");
		
		// Confirm you can click Email after selecting vendors
		// Click Email
		perform.click(driver,SOrderDetails.email_btn(driver));
		
		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for Cancel button
		perform.waitForElementToBeClickable(driver, SOrderDetails.cancel_btn(), "id");
		
		// Verify dialog text
		String emailText = SOrderDetails.emailEligibleVendorsDialog_txt(driver).getText();
		Assert.assertTrue(emailText.contains("Email eligible vendors"), "The Email elibible vendors dialog is incorrect or not displayed properly");
		Assert.assertTrue(emailText.contains("This will generate an email with the address, product type, loan type, loan purpose and your message. The message and recipients are logged as a Note and become a permanent part of the order."), "The Email elibible vendors dialog is incorrect or not displayed properly");
		Assert.assertTrue(emailText.contains("This message will be delivered to the"), "The Email elibible vendors dialog is incorrect or not displayed properly");
		Assert.assertTrue(emailText.contains("2"), "The Email elibible vendors dialog is incorrect or not displayed properly");
		Assert.assertTrue(emailText.contains("vendors"), "The Email elibible vendors dialog is incorrect or not displayed properly");

		// Confirm the Send button is not activated until you have entered text, or used a quicklist item (Spaces and Line Breaks/Returns do not count)
		Assert.assertTrue(SOrderDetails.send_btn(driver).getAttribute("class").contains("SkinButtonDisabled"), "The Send button should not be enabled until text has been entered into the message box");
		
		// Enter text into the message
		perform.type(driver,SOrderDetails.emailEligibleVendorsMessage_txtbx(driver), "Testing email eligible vendors message");
		
		// Verify Send button is now enabled
		Assert.assertTrue(!SOrderDetails.send_btn(driver).getAttribute("class").contains("SkinButtonDisabled"), "The Send button should be enabled afater text has been entered into the message box");
		
		// Wait for the Send button
		perform.waitForElementToBeClickable(driver, SOrderDetails.send_btn(), "id");
		
		// Click Send
		perform.click(driver,SOrderDetails.send_btn(driver));
		
		// Handle the alert dialog
		int i=0;
		while(i++<5)
		{
		     try
		     {
		         @SuppressWarnings("unused")
		         Alert alert = driver.switchTo().alert();
		         driver.switchTo().alert().accept();
		         break;
		     }
		     catch(NoAlertPresentException e)
		    {
		       Thread.sleep(2000);
		       continue;
		     }
		}
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Refresh the page
		driver.navigate().refresh();
		
		// Verify history text
		String history = SOrderDetails.history_txt(driver).getText();
		Assert.assertTrue(history.contains("Note Added (Automation RegressionSecure9)"), "There should be an audit trail event with the email information sent");
		Assert.assertTrue(history.contains("The following message was emailed to Automation Appraiser1, Automation Appraiser3.") || history.contains("The following message was emailed to Automation Appraiser3, Automation Appraiser1."), "There should be an audit trail event with the email information sent");
		Assert.assertTrue(history.contains("Testing email eligible vendors message"), "There should be an audit trail event with the email information sent");
		
		// Set the order to double-blind via the Modify selection settings
		// Click Modify selection settings button
		perform.click(driver,SOrderDetails.modifySelectionSettings_btn(driver));
	    
	    // Wait for overlay
	    perform.waitForOverlayToBeVisible(driver);
	    
	    // Wait for Require local vendor
	    perform.waitForElementToBeClickable(driver, SModifySelectionSettings.requireLocalVendor_chkbx(), "id");
	    
	    // Turn on Double-Blind
	    if (SModifySelectionSettings.doubleBlindCommunication_btn(driver).getAttribute("src").contains("switchOff"))
	    {
	    	perform.click(driver,SModifySelectionSettings.doubleBlindCommunication_btn(driver));
	    }
	    
	    // Click OK
	    perform.click(driver, SModifySelectionSettings.okPreVendorSelect_btn(driver));
	    
	    // Wait for overlay to be hidden
	    perform.waitForOverlayToBeHidden(driver);
		
		// Confirm the Eligible fee panel vendors pod does not display
	    Assert.assertTrue(!SOrderDetails.page_txt(driver).getText().contains("Eligible fee panel vendors"), "The Eligible fee panel vendors table should not be displayed after double blind has been turned on");
		
		// Go to Vendor Selection Settings
		secure.goToVendorSelectionSettings(driver);
		
		// Turn off Double-blind Communication switch
		if (!SVendorSelectionSettings.doubleBlind_switch(driver).getAttribute("src").contains("switchOff.png"))
		{
			perform.click(driver,SVendorSelectionSettings.doubleBlind_switch(driver));
		}
		
		// Disable Automatic Vendor Selection
		if (SVendorSelectionSettings.automaticOrderAssignment_switch(driver).getAttribute("src").contains("switchOn.png"))
		{
			perform.click(driver,SVendorSelectionSettings.automaticOrderAssignment_switch(driver));
		}
		
		// Select Mercury Network directory
		perform.click(driver,SVendorSelectionSettings.mercuryNetworkDirectory_radio(driver));
		
		// Save Preferences
		perform.click(driver,SVendorSelectionSettings.save_btn(driver));
		
		// Wait for the OK button to be visible
		perform.waitForElementToBeClickable(driver, SVendorSelectionSettings.ok_btn(), "id");
		
		// Click OK in saved dialog box
		perform.click(driver,SVendorSelectionSettings.ok_btn(driver));
		
		// Create order and assign it to an appraiser
		perform.apiPlaceOrderFromSecure(driver, userSecure, password, "PlaceMNOrder-ConfirmEligibleFeePanelVendorsGrid");
		trackingNumber = StoredVariables.getloanID().get();
		// Assign the order
		secure.loginAndAssignOrderToAppraiser(driver, userSecure, password, trackingNumber, userVendors);
		
		// Log in as the vendor
		vendors.login(driver, userVendors, password);
		
		// Decline the order
		vendors.declineOrder(driver, trackingNumber);
		
		// Login to Secure
		secure.login(driver, userSecure, password);
		
		// Search for the order
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Open the order
		secure.openOrder(driver, trackingNumber);
		
		// Confirm the Eligible fee panel vendors pod does not display
	    Assert.assertTrue(!SOrderDetails.page_txt(driver).getText().contains("Eligible fee panel vendors"), "The Eligible fee panel vendors table should not be displayed after double blind has been turned on");
		
		// Log test
		test.log(LogStatus.INFO, "Eligible Vendors", "Verified the Eligible fee panel vendors grid functions correctly");
		
	} // end confirmEligibleFeePanelVendorsGrid
	
} // end the ConfirmEligibleFeePanelVendorsGrid class
