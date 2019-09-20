package regressionSecure;

import java.util.List;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Secure.SOrderDetails;
import pageObjects.Secure.SOrders;
import pageObjects.Vendors.VOrderDetails;
import pageObjects.Vendors.VOrders;
import setup.DriverFactory;
import setup.TestSetup;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Secure - Add Vendors To Existing Bid Order</h1>
 * 
 * <p>.
 *
 * @author  Kendall Riley
 * @since   03/11/2019
 */

@Listeners(utils.Listener.class)
public class MarkAsPaid extends TestSetup {
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log into Vendors</li>
	 * 	<li>Click the gear icon</li>
	 * 	<li>Click Payment Check/Ref #</li>
	 * 	<li>Click invoice</li>
	 * 	<li>Click Save</li>
	 * 	<li>Click OK button</li>
	 * 	<li>Click field dropdown</li>
	 * 	<li>Verify Payment Check/Ref# displays in the dropdown</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Go to Residential Appraisal</li>
	 * 	<li>Set Property Information data</li>
	 * 	<li>StoredVariables.getpropertyInformationStateAbbr().set("OK");  Must set for a field check later on</li>
	 * 	<li>Set Assignment Information data</li>
	 * 	<li>Set Lender Information data</li>
	 * 	<li>Set Contact And Access Information data</li>
	 * 	<li>Enter New Order data</li>
	 * 	<li>Click Next</li>
	 * 	<li>Assign vendor</li>
	 * 	<li>Confirm order screen loads</li>
	 * 	<li>finish placing order</li>
	 * 	<li>Get loan ID</li>
	 * 	<li>Get tracking number</li>
	 * 	<li>Log into Vendors</li>
	 * 	<li>Find and complete the order</li>
	 * 	<li>Log into Secure</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Click Mark as paid button</li>
	 * 	<li>Enter invoice number</li>
	 * 	<li>Enter check number</li>
	 * 	<li>Enter note</li>
	 * 	<li>Click save</li>
	 * 	<li>Get history text</li>
	 * 	<li>Verify the history</li>
	 * 	<li>Log back into vendors</li>
	 * 	<li>Click into Find field</li>
	 * 	<li>Click field dropdown</li>
	 * 	<li>Select Payment Invoice from dropdown</li>
	 * 	<li>Select Find field</li>
	 * 	<li>Enter Invoice #</li>
	 * 	<li>Click search icon</li>
	 * 	<li>Click View</li>
	 * 	<li>Verify the correct order is open</li>
	 * 	<li>Go back to the orders grid</li>
	 * 	<li>Click search icon</li>
	 * 	<li>Search for order by Check Number</li>
	 * 	<li>Open the order</li>
	 * 	<li>Verify the correct order is open</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Go to Residential Appraisal</li>
	 * 	<li>Set Property Information data</li>
	 * 	<li>StoredVariables.getpropertyInformationStateAbbr().set("OK");  Must set for a field check later on</li>
	 * 	<li>Set Assignment Information data</li>
	 * 	<li>Set Lender Information data</li>
	 * 	<li>Enter New Order data</li>
	 * 	<li>Click Next</li>
	 * 	<li>Assign vendor</li>
	 * 	<li>Confirm order screen loads</li>
	 * 	<li>finish placing order</li>
	 * 	<li>Get loan ID</li>
	 * 	<li>Log into Vendors</li>
	 * 	<li>Search for the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Click the Accept button</li>
	 * 	<li>Find and complete the order</li>
	 * 	<li>Log into Secure</li>
	 * 	<li>Click on completed orders folder</li>
	 * 	<li>Click Mark As paid</li>
	 * 	<li>Switch to iFrame</li>
	 * 	<li>Click select all</li>
	 * 	<li>Enter Invoice #</li>
	 * 	<li>Enter check number</li>
	 * 	<li>Save</li>
	 * 	<li>Login to vendors</li>
	 * 	<li>Click into Find field</li>
	 * 	<li>Click field dropdown</li>
	 * 	<li>Select Payment Invoice from dropdown</li>
	 * 	<li>Select Find field</li>
	 * 	<li>Enter Invoice #</li>
	 * 	<li>Click search icon</li>
	 * 	<li>Click View</li>
	 * 	<li>Verify the correct order is open</li>
	 * 	<li>Go back to the orders grid</li>
	 * 	<li>Click search icon</li>
	 * 	<li>Search for order by Check Number</li>
	 * 	<li>Open the order</li>
	 * 	<li>Verify the correct order is open</li>
	 * 	<li>Log test</li>

	 * 	<li>Log test</li>
* </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Create Order", "Secure - Create Residential Appraisal Order", "Secure - Orders", "Secure - Fee Panel", "Secure - Login", "Vendors - Accept Order", "Vendors - Complete Order", "Vendors - Login", "Vendors - Orders", "Vendors - Mark As Paid", "Secure - Mark As Paid"}, alwaysRun=true)
	public void markAsPaid() throws Exception{
		
		// Create the driver
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Set the password
		String password = StoredVariables.getpassword().get();
		
		// Set the Secure user
		String userSecure = "markaspaid1";
		
		// Set the Vendors user
		String userVendors = "MapAppraiser1";
		
		// Log in to Secure
		secure.login(driver, userSecure, password);
		
		// Go to the Completed folder
		secure.findOrderFolder(driver, "Completed");
		
		// Delete all Completed orders
		secure.deleteAllOrdersInFolder(driver);
		
		//Log into Vendors
		vendors.login(driver, userVendors, password);
		
		//Click the gear icon
		perform.click(driver, VOrders.searchOption1_btn(driver));
		
		//Wait for Search Options
		perform.waitForElementToBeClickable(driver, VOrders.paymentInvoice_btn(), "id");
		
		//Check Payment Check/Ref #
		perform.checkCheckbox(driver, VOrders.paymentCheck_btn(driver));
		
		//Click invoice
		perform.checkCheckbox(driver, VOrders.paymentInvoice_btn(driver));

		// Save the settings
		vendors.saveSearchSettings(driver);
		
		//Click field dropdown
	    perform.click(driver, VOrders.inField_dropdown(driver));
	    
	    //Verify Payment Check/Ref# displays in the dropdown
		List<String> dropdownOptions = perform.getAllDropdownOptions(driver, VOrders.inField_dropdown(driver));
	    Assert.assertTrue(dropdownOptions.contains("Payment Check/Ref #"), "The dropdown does not contain the correct options");
		
		// Create an order through the API
		String trackingNumber = perform.apiPlaceOrderFromSecure(driver, userSecure, password, "PlaceMNOrder-MarkAsPaid");
		
		// Get the loan id
		String loanID = db.getLoanIDFromTrackingNumber(driver, trackingNumber);

		// Assign the order to an appraiser
		secure.loginAndAssignOrderToAppraiserWithTrackingNumber(driver, userSecure, password, trackingNumber, userVendors);
		
		//Log into Vendors, accept the order and complete it
		vendors.loginAcceptAndCompleteOrder(driver, userVendors, password, trackingNumber);
		
        //Log into Secure and open the order
 		secure.loginAndOpenOrderByTrackingNumber(driver, userSecure, password, trackingNumber);
 		
 		//Click Mark as paid button
 	    perform.click(driver, SOrderDetails.markAsPaid_btn(driver));
        
 	    //Wait for dialog to load
 	    perform.waitForElementToBeClickable(driver, SOrderDetails.invoiceNumber_txtbx(driver));
 		
 	    // Set the invoice number
 	    String invoiceNumber = perform.randomNumbers(driver, 8);
 	    
 	    //Enter invoice number
        perform.type(driver, SOrderDetails.invoiceNumber_txtbx(driver),invoiceNumber);
        
        // Set the check number
        String checkNumber = perform.randomNumbers(driver, 8);
        
        //Enter check number
        perform.type(driver, SOrderDetails.checkNumber_txtbx(driver), checkNumber); 
        
        //Enter note
        perform.type(driver, SOrderDetails.noteEnterNewPayment_txtbx(driver), "Test Note");
        
        //Click save
        perform.click(driver, SOrderDetails.paymentSave_btn(driver));
        
        // Wait for busy to be hidden
        perform.waitForBusyToBeHidden(driver);
        
        // Get history text
     	String history = SOrderDetails.history_txt(driver).getText();
     		
     	// Verify the history
     	perform.verification(driver, history, "contains", "Paid in full");
     	
        //Log back into vendors
        vendors.login(driver, userVendors, password);
        
	    // Select Payment Invoice from dropdown
	 	perform.selectDropdownOption(driver, VOrders.inField_dropdown(driver), "Payment Invoice #");
	 	
	 	//Enter Invoice #
	 	perform.type(driver, VOrders.find_txtbx(driver), invoiceNumber);
	 	
	 	//Click search icon
	 	perform.click(driver, VOrders.find_btn(driver));
	 	
	 	// Wait for busy
		perform.waitForBusyToBeHidden(driver);
	 		  
	 	//Open the order
	 	vendors.openOrder(driver);
		
	 	//Verify the correct order is open
		perform.verification(driver, driver.getCurrentUrl(), "contains", loanID);
	 	
	 	//Search for order by Check Number
	 	vendors.findOrder(driver, checkNumber, "Payment Check/Ref #");
	 	
	 	//Open the order
	 	vendors.openOrder(driver);
	 	
	 	//Verify the correct order is open
	 	perform.verification(driver, driver.getCurrentUrl(), "contains", loanID);
	 	
	 	// Create an order through the API
 		trackingNumber = perform.apiPlaceOrderFromSecure(driver, userSecure, password, "PlaceMNOrder-MarkAsPaid2");
 		
		// Get the loan id
		loanID = db.getLoanIDFromTrackingNumber(driver, trackingNumber);
 		
 		// Assign the order to an appraiser
 		secure.loginAndAssignOrderToAppraiserWithTrackingNumber(driver, userSecure, password, trackingNumber, userVendors);
 		
 		// Log in to Vendors and open the order
 		vendors.loginAndOpenOrderByTrackingNumber(driver, userVendors, password, trackingNumber);
	 		
	 	// Wait for the Send Message button
	 	perform.waitForElementToBeClickable(driver, VOrderDetails.sendMessage_btn(), "cssSelector");
	 		
	 	// Click the Accept button
	 	perform.click(driver, VOrderDetails.acceptDecline_btn(driver));
	 	
	 	// Complete the order
	 	vendors.completeOrderByHTTPPost(driver, userVendors, password, loanID, "Complete.xml");
	 			
	 	//Log into Secure
	 	secure.login(driver, userSecure, password);
	    
	    // Click on completed orders folder
	    secure.findOrderFolder(driver, "Completed");
	    
	    // Wait for Mark as paid to be clickable
	    perform.waitForElementToBeClickable(driver, SOrders.markAsPaid_btn(driver));
	 	
	    //Click Mark As paid
	 	perform.click(driver, SOrders.markAsPaid_btn(driver));
	 	
	 	//Wait for iFrame to load
	 	perform.waitForIFrames(driver);
	 	
	 	//Switch to iFrame
	 	driver.switchTo().frame(0);
	 	Thread.sleep(5000);
	 	perform.waitForElementToBeClickable(driver, SOrders.selectAll_btn(driver));
	 	
	 	//Click select all
	 	perform.click(driver, SOrders.selectAll_btn(driver));
	 	
	 	// Get the invoice number
	 	invoiceNumber = perform.randomNumbers(driver, 8);
	 	
	 	//Enter Invoice #
	 	perform.type(driver, SOrders.invoiceNumber_txt(driver), invoiceNumber);
	 	
	 	// Get the check number
	 	checkNumber = perform.randomNumbers(driver, 8);
	 	System.out.println("Check Number: " + checkNumber);
	 	
	 	//Enter check number
        perform.type(driver, SOrders.checkNumber_txt(driver), checkNumber); 
        
        if ( SOrders.markAsPaidSave_btn(driver).getAttribute("class").contains("SkinButtonDisabled")) {
        	perform.click(driver, SOrders.selectAll_btn(driver));
        }
        	
        //Save
        perform.click(driver, SOrders.markAsPaidSave_btn(driver));
        
        //Login to vendors
        vendors.login(driver, "MapAppraiser1", StoredVariables.getpassword().get());
        
        //Click into Find field
        perform.click(driver, VOrders.find_txtbx(driver));
        
        //Click field dropdown
	    perform.click(driver, VOrders.inField_dropdown(driver));
	    
	    // Select Payment Invoice from dropdown
	 	perform.selectDropdownOption(driver, VOrders.inField_dropdown(driver), "Payment Invoice #");
	 	
	 	// Select Find field
	 	perform.click(driver, VOrders.find_txtbx(driver));
	 	
	 	//Enter Invoice #
	 	perform.type(driver, VOrders.find_txtbx(driver), invoiceNumber);
	 	
	 	//Click search icon
	 	perform.click(driver, VOrders.find_btn(driver));
	 	
	 	// Wait for busy to be hidden
	 	perform.waitForBusyToBeHidden(driver);
	 		  
	 	//Open the order
	 	vendors.openOrder(driver);
		
	 	//Verify the correct order is open
		perform.verification(driver, driver.getCurrentUrl(), "contains", loanID);
	 	
	 	//Search for order by Check Number
	 	vendors.findOrder(driver, checkNumber, "Payment Check/Ref #");
	 	
	 	//Open the order
	 	vendors.openOrder(driver);
	 	
	 	//Verify the correct order is open
	 	perform.verification(driver, driver.getCurrentUrl(), "contains", loanID);
	 	
	    // Log test
	 	perform.addInfoToExtentReport(driver, "Mark as Paid", "Verified Mark as Paid is working");
	 		
	} // end markAsPaid
	
} // end the MarkAsPaid class
