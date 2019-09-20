package regressionSecure;

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
import pageObjects.Secure.SOrderDetails;
import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
* Verify the Statement of Engagement is attached to the order when the vendor is assigned.<br>
* Verify a new Statement of Engagement is attached to the order if the order is reassigned.
* <p>
* 
* @author  Dustin Norman
* @since   05-16-2018
*/

@Listeners(utils.Listener.class)
public class StatementOfEngagement extends TestSetup {
	
	/**
	 * Verify the Statement of Engagement is attached to the order when the vendor is assigned.<br>
	 * Verify a new Statement of Engagement is attached to the order if the order is reassigned.
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Sign in and create a new Commercial order</li>
	 * 	<li>Find and open the order</li>
	 * 	<li>Verify the Statement of Engagement is attached to the order</li>
	 * 	<li>Login to Vendors</li>
	 * 	<li>Conditionally decline the order as the vendor</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Find and open the order</li>
	 * 	<li>Reassign the order to a different appraiser</li>
	 * 	<li>Click OK</li>
	 * 	<li>Assign the order to a new vendor</li>
	 * 	<li>Click Finish</li>
	 * 	<li>Verify there are now 2 Statement of Engagements attached to the order</li>
	 * 	<li>Get the text of the attached documents</li>
	 * 	<li>Check if the document is an SoE</li>
	 * 	<li>Click the document</li>
	 * 	<li>Verify the document name starts with SOE</li>
	 * 	<li>Increment the soe variable</li>
	 * 	<li>Verify it is a Statement of Engagement</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Create Order", "Secure - Orders", "Vendors - Orders", "Vendors - Conditionally Decline Order", "Secure - Reassign Order"}, alwaysRun=true)
	public void statementOfEngagement() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		String userSecure = "RegressionSecure19";
		String userVendors = "Appraiser1";
		String userVendors3 = "Appraiser3";
		String password = StoredVariables.getpassword().get();
		
		// Sign in and create a new Commercial order
		secure.createAndAssignNewCommercialAppraisalOrderUsingCustomFeePanel(driver, userSecure, userVendors);
		
		// Find and open the order
		String trackingNumber = StoredVariables.gettrackingNumber().get();
		secure.findAndOpenOrder(driver, trackingNumber);
		
		// Verify the Statement of Engagement is attached to the order
		String orderDocuments = SOrderDetails.orderDocuments_txt(driver).getText();
		Assert.assertTrue(orderDocuments.contains("Statement of Engagement"), "The Statement of Engagement should have been attached to the order");
		
		// Login to Vendors
		vendors.login(driver, userVendors, password);
		
		// Conditionally decline the order as the vendor
		vendors.conditionallyDeclineOrder(driver, trackingNumber, "600");
		
		// Log in to Secure
		secure.login(driver, userSecure, password);
		
		// Find and open the order
		secure.findAndOpenOrder(driver, trackingNumber);
		
		// Reassign the order to a different appraiser
		perform.click(driver,SOrderDetails.reassign_radioBtn(driver));
		
		// Click OK
		perform.click(driver,SOrderDetails.ok_btn(driver));
		
		// Assign the order to a new vendor
		secure.selectVendor(driver, userVendors3);
		
		// Click Finish
		perform.click(driver,SConfirmOrder.finishTop_btn(driver));
		
		// Wait for the history
		perform.waitForElementToBeClickable(driver, SOrderDetails.history_txt(driver));
		
		// Verify there are now 2 Statement of Engagements attached to the order
		List<WebElement> docs = driver.findElements(By.cssSelector("#tblODFiles > tbody > tr[level='2']"));
		int soe = 0;
		for (WebElement el : docs) {
			
			// Get the text of the attached documents
			String document = el.getText();
			
			// Check if the document is an SoE
			if (document.contains("Statement of Engagement")) {
				
				// Click the document
				perform.click(driver,el);
				
				// Wait for text to update
				perform.waitForText(driver, SOrderDetails.orderDocumentsMain_txt(driver), "SOE_");
				
				// Verify the document name starts with SOE
				Assert.assertTrue(SOrderDetails.orderDocumentsMain_txt(driver).getText().contains("SOE_"), "The SoE document name is incorrect");
				
				// Increment the soe variable
				soe++;
				
			} // end if
			
		} // end for
		
		// Verify it is a Statement of Engagement
		Assert.assertTrue(soe==2, "There should be 2 Statement of Engagements attached to the order");
		
		// Log test
		test.log(LogStatus.INFO, "Secure Regression Test", "Verified that the Statment of Engagement is attached to the order");
		
	} // end invoiceNumbersDoNotResetWhenChangingClientGroupSettings
	
} // end the commercialFeesAfterAddingAdditionalVendorToOrder class
