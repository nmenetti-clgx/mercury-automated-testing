package regressionSecure;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Secure.SOrderDetails;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Secure - Confirm Display Of FRE Quality And Valuation Risk Scores</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class ConfirmDisplayOfFREQualityAndValuationRiskScores extends TestSetup {
	
	/** The user secure. */
	private final String userSecure = "RegressionSecure8";
	
	/** The user vendors. */
	private final String userVendors = "Appraiser1";
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Place a new order and assign to a vendor</li>
	 * 	<li>Log in as the vendor</li>
	 * 	<li>Accept the order</li>
	 * 	<li>Complete the order using the HTTP Post</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Search for the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Submit the delivered report to Freddie Mac</li>
	 * 	<li>Refresh screen</li>
	 * 	<li>Verify the order details show either FRE Quality Risk score or FRE Valuation Risk score depending upon the test file used</li>
	 * 	<li>Request a revision</li>
	 * 	<li>Deliver a different test file as the vendor</li>
	 * 	<li>Log in as the vendor</li>
	 * 	<li>Open the order</li>
	 * 	<li>Complete the order using the HTTP Post</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Search for the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Submit the delivered report to Freddie Mac</li>
	 * 	<li>Verify the order details show either FRE Quality Risk score or FRE Valuation Risk score depending upon the test file used</li>
	 * 	<li>Get Quality risk</li>
	 * 	<li>Get Valuation risk</li>
	 * 	<li>Log test</li>
* </ul>
	 *
	 * @throws Exception the exception
	 */
	// Marked as broken because the scores are no longer displayed
	@Test (retryAnalyzer = Retry.class, groups={"broken", "Secure - Create Order Via API", "Vendors - Orders", "Vendors - Accept Order", "Vendors - Complete Order", "Secure - Orders", "Secure - Set Status", "Secure - Submit To UCDP", "Secure - Request Revision"}, alwaysRun=true)
	public void confirmDisplayOfFREQualityAndValuationRiskScores() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		String password = StoredVariables.getpassword().get();
		
		// Place a new order and assign to a vendor
		perform.apiPlaceOrderFromSecure(driver, userSecure, password, "PlaceMNOrder-ConfirmDisplayOfFREQualityAndValuationRiskScores");
		String trackingNumber = StoredVariables.gettrackingNumber().get();
		secure.loginAndAssignOrderToAppraiser(driver, userSecure, password, trackingNumber, userVendors);
		
		// Log in as the vendor
		vendors.login(driver, userVendors, password);
		
		// Accept the order
		vendors.acceptOrder(driver, trackingNumber);
		
		// Complete the order using the HTTP Post
		vendors.completeOrderByHTTPPost(driver, userVendors, password, StoredVariables.getloanID().get(), "FRE_Complete.xml");
		
		// Login to Secure
		secure.login(driver, userSecure, password);
		
		// Search for the order
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Open the order
		secure.openOrder(driver, trackingNumber);
		
		// Submit the delivered report to Freddie Mac
		secure.submitToUCDP(driver, "Freddie Mac", "", "", "", false);

		// Wait for Appraisal Submission Accepted to display in the history
		secure.waitForHistoryTextToUpdate(driver, "Appraisal Submission Accepted");
		
		Thread.sleep(1500);
		
		// Refresh screen
		driver.navigate().refresh();
		
		// Verify the order details show either FRE Quality Risk score or FRE Valuation Risk score depending upon the test file used
		boolean returned = false;
		try
		{
			WebElement qualityRisk = SOrderDetails.FREQualityRisk_txt(driver);
			perform.scrollElementIntoView(driver, qualityRisk);
			Assert.assertTrue(!qualityRisk.getText().isEmpty(), "The FRE Quality Risk score is incorrect or missing");
			returned = true;
		}
		catch(Exception e){}
		try
		{
			WebElement evaluationRisk = SOrderDetails.FREValuationRisk_txt(driver);
			perform.scrollElementIntoView(driver, evaluationRisk);
			Assert.assertTrue(!evaluationRisk.getText().isEmpty(), "The FRE Evaluation Risk score is incorrect or missing");
			returned = true;
		}
		catch(Exception e){}
		Assert.assertTrue(returned==true, "The FRE Quality Risk or FRE Evaluation Risk score did not return");		
		
		// Request a revision
		secure.requestRevision(driver, "");
		
		// Deliver a different test file as the vendor 
		// Log in as the vendor
		vendors.login(driver, userVendors, password);
		
		// Open the order
		vendors.findAndOpenOrder(driver, trackingNumber);
		
		// Complete the order using the HTTP Post
		vendors.completeOrderByHTTPPost(driver, userVendors, password, StoredVariables.getloanID().get(), "FRE_Complete2.xml");
		
		// Login to Secure
		secure.login(driver, userSecure, password);
		
		// Search for the order
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Open the order
		secure.openOrder(driver, trackingNumber);
		
		// Submit the delivered report to Freddie Mac
		secure.submitToUCDP(driver, "Freddie Mac", "", "", "", false);

		// Wait for Appraisal Submission Accepted to display in the history
		secure.waitForHistoryTextFirstRowToUpdate(driver, "Appraisal Submission");
		
		// Verify the order details show either FRE Quality Risk score or FRE Valuation Risk score depending upon the test file used
		// Get Quality risk
		try {
			String quality = SOrderDetails.FREQualityRisk_txt(driver).getText();
			Assert.assertTrue(quality.equals("5"), "The FRE Quality Risk score is incorrect or missing");
		} catch (Exception e) {
			test.log(LogStatus.WARNING, "Secure Regression Test", "FRE Quality Risk scores is not displayed in the details");
		}
		
		// Get Valuation risk
		try {
			String valuation= SOrderDetails.FREValuationRisk_txt(driver).getText();
			Assert.assertTrue(valuation.equals("2"), "The FRE Valuation Risk score is incorrect or missing");			
		} catch (Exception e) {
			test.log(LogStatus.WARNING, "Secure Regression Test", "FRE Valuation Risk scores is not displayed in the details");
		}
		
		// Log test
		test.log(LogStatus.INFO, "Secure Regression Test", "Verified the display of FRE Quality and Valuation Risk scores in order details when there is a score");
		
	} // end confirmDisplayOfFREQualityAndValuationRiskScores
	
} // end the ConfirmDisplayOfFREQualityAndValuationRiskScores class
