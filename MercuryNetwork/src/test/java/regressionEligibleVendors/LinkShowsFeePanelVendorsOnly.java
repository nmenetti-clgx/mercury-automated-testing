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

import pageObjects.Secure.SEligibleVendors;
import pageObjects.Secure.SOrderDetails;
import pageObjects.Secure.SVendorSelectionSettings;
import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Eligible Vendors - Link Shows Fee Panel Vendors Only</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class LinkShowsFeePanelVendorsOnly extends TestSetup {
	
	/** The secure username. */
	private final String secureUsername = "RegressionSecure5";
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Click Preferences &gt; VSS</li>
	 * 	<li>Turn on Automatic vendor selection</li>
	 * 	<li>Select Custom Fee panel radio button</li>
	 * 	<li>Uncheck Use Mercury Network directory as backup</li>
	 * 	<li>Save</li>
	 * 	<li>Place order via the API</li>
	 * 	<li>Assign order</li>
	 * 	<li>Get the audit trail text</li>
	 * 	<li>Verify delayed is in the history</li>
	 * 	<li>Verify View eligible vendors link</li>
	 * 	<li>Click the View eligible vendors link</li>
	 * 	<li>Verify dialog text</li>
	 * 	<li>Get the number of rows for eligible vendors</li>
	 * 	<li>Set expectedVendor to false</li>
	 * 	<li>Get row text</li>
	 * 	<li>Verify the vendor is expected</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Vendor Selection Settings", "Secure - Create Order", "Secure - Orders", "Eligible Vendors"}, alwaysRun=true)
	public void linkShowsFeePanelVendorsOnly() throws Exception{
		
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
		
		// Select Custom Fee panel radio button
		perform.click(driver,SVendorSelectionSettings.customFeePanel_radio(driver));
		
		// Uncheck Use Mercury Network directory as backup
		if (SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver).isSelected()==true)
		{
			perform.click(driver,SVendorSelectionSettings.useMercuryNetworkDirectoryAsBackup_chkbx(driver));	
		}
		
		// Save
		secure.saveVendorSelectionSettings(driver);
		
		// Place order via the API
		perform.apiPlaceOrderFromSecure(driver, secureUsername, password, "PlaceMNOrder-LinkShowsFeePanelVendorsOnly");
		
		// Assign order
		String vendorLastName = secure.assignAutomaticVendorSelection(driver, StoredVariables.getloanID().get());
		
		// Get the audit trail text
		String history = SOrderDetails.history_txt(driver).getText();
		
		// Verify delayed is in the history
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation " + vendorLastName), "Awaiting acceptance by Automation " + vendorLastName + " is missing from the order information");
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
		Assert.assertTrue(SEligibleVendors.dialog_txt(driver).getText().contains("The following vendors from the Fee Panel were considered for this order when placed. The assigned vendor is highlighted."), "The dialog text is incorrect");
		
		// Get the number of rows for eligible vendors
	    List<WebElement> eligibleVendors = driver.findElements(By.cssSelector("#tblEligibleVendors > tbody > tr"));
	    String rowText = "";
	    for ( WebElement row: eligibleVendors) {
	    	
	    	// Set expectedVendor to false
	    	boolean expectedVendor = false;
	    	
	        // Get row text
	    	rowText = row.getText();
	    	System.out.println("rowText = " + rowText);
	    	if (rowText.contains("Appraiser3"))
	    	{
	    		expectedVendor = true;
	    	}
	    	else if (rowText.contains("Appraiser1"))
	    	{
	    		expectedVendor = true;
	    	}

	    	// Verify the vendor is expected
	    	Assert.assertTrue(expectedVendor==true, "There is an unexpected vendor in the list");
	    	
	    } // end for loop
		
		// Log test
		test.log(LogStatus.INFO, "Eligible Vendors", "Verified View elibible vendors link shows Fee panel vendors only");
		
	} // end linkShowsFeePanelVendorsOnly
	
} // end the LinkShowsFeePanelVendorsOnly class
