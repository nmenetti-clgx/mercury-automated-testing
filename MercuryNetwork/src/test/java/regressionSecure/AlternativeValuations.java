package regressionSecure;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import setup.DriverFactory;
import setup.TestSetup;
import utils.Retry;

// TODO: Auto-generated Javadoc
/**
 * <h1>Alternative Valuations</h1>
 * 
 * <p>Place orders for RealCondition Report, OptiVal AVM Cascade and OptiVal+ 
 *
 * @author  Dustin Norman
 * @since   95-07-2018
 */

@Test (groups={"broken"})
@Listeners(utils.Listener.class)
public class AlternativeValuations extends TestSetup {
	
	/** The user secure. */
	private final String userSecure = "RegressionSecure20";
	
	/** The password. */
	private final String password = "T3sting1";	
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li></li>
	 * </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Alternative Valuations"}, alwaysRun=true)
	public void createRealConditionReportOrder() throws Exception {
		
		// Create the driver
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Get the current hour
		Date date = new Date();
        String strDateFormat = "HH";
        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        String formattedDate = dateFormat.format(date);
        int currentHour = Integer.parseInt(formattedDate);
        
        // Only run between 7am and 5pm
        if (currentHour > 7 && currentHour < 17) {
		
			// Login to Secure
			secure.login(driver, userSecure, password);
			
			// Go to new alternative valuations
			secure.goToAlternativeValuations(driver);
			
			// Set order information
			secure.setNewAlternativeValuationOrderVariables(driver);
			
			// Enter order information
			secure.enterNewAlternativeValuationOrder(driver, "RealCondition Report");
			
			// Complete the order
			secure.completeNewAlternativeValuationOrder(driver);
			
			// Wait for Alternative Valuation Order To Return
			secure.waitForRealConditionReport(driver);
			
			//Verify correct document is displayed
			Assert.assertTrue(secure.verifyCorrectDocumentsAttached(driver, "Report PDF")==true, "The document is not displayed");
			
			// Log test
			perform.addInfoToExtentReport(driver, "Secure Regression Test", "Verified you can Add Vendors to Existing Bid Order");
			
        } else {
        	
			// Log test
        	perform.addInfoToExtentReport(driver, "Secure Regression Test", "Did not run because it is not between 7am and 5pm");
			
        } // end if/else
		
	} // end createRealConditionReportOrder
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li></li>
	 * </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Alternative Valuations"}, alwaysRun=true)
	public void createOptivValtOrder() throws Exception {

		// Create the driver
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Login to Secure
		secure.login(driver, userSecure, password);
		
		// Go to new alternative valuations
		secure.goToAlternativeValuations(driver);
		
		// Set order information
		secure.setNewAlternativeValuationOrderVariables(driver);
		
		// Enter order information
		secure.enterNewAlternativeValuationOrder(driver, "OptiVal AVM Cascade");
		
		// Complete the order
		secure.completeNewAlternativeValuationOrder(driver);
		
		// Wait for Alternative Valuation Order To Return
		secure.waitForAlternativeValuationOrderToReturn(driver);
		
		//Verify correct document is displayed
		Assert.assertTrue(secure.verifyCorrectDocumentsAttached(driver, "Report PDF")==true, "The document is not displayed");
		
		// Log test
		perform.addInfoToExtentReport(driver, "Secure Regression Test", "Verified you can Add Vendors to Existing Bid Order");
		
	} // end createOptivValtOrder
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li></li>
	 * </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Alternative Valuations"}, alwaysRun=true)
	public void createOptiValCombinedWithRCROrder() throws Exception {

		// Create the driver
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Login to Secure
		secure.login(driver, userSecure, password);
		
		// Go to new alternative valuations
		secure.goToAlternativeValuations(driver);
		
		// Set order information
		secure.setNewAlternativeValuationOrderVariables(driver);
		
		// Enter order information
		secure.enterNewAlternativeValuationOrder(driver, "OptiVal+");
		
		// Complete the order
		secure.completeNewAlternativeValuationOrder(driver);
		
		// Wait for Alternative Valuation Order To Return
		secure.waitForAlternativeValuationOrderToReturn(driver);
		
		//Verify correct document is displayed
		Assert.assertTrue(secure.verifyCorrectDocumentsAttached(driver, "AVM")==true, "The document is not displayed");
		
		// Log test
		perform.addInfoToExtentReport(driver, "Secure Regression Test", "Verified you can Add Vendors to Existing Bid Order");
		
	} // end createOptiValCombinedWithRCROrder
	
} // end the AddVendorsToExistingBidOrder class
