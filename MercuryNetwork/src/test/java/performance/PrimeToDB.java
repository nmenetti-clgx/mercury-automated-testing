package performance;

import java.util.ArrayList;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import setup.DriverFactory;
import setup.TestSetup;
import utils.Retry;

// TODO: Auto-generated Javadoc
/**
 * <h1>Secure Performance</h1>
 * 
 * <p>To add new customers, you will need to do the following:<br>
 * Add the customer to the customers array (must match the sheet name in Excel)<br>
 * Add the customers CRM login url in the switch statement<br>
 * Add the tracking number of an order to search for in the switch statement<br>
 * Add the sub user to choose in the switch statement<br>
 * Create a new tab in the MercuryPageLoadTimes.xlsx file.
 *
 * @author  Dustin Norman
 * @since   09-05-2019
 */

@Listeners(utils.Listener.class)
public class PrimeToDB extends TestSetup {
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log test</li>
	 * </ul>.
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={}, alwaysRun=true)
	public void prime() throws Exception{
		
		// Create the driver
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		String customer = null;
		String url = null;
		String trackingNumber = null;
		String subUser = null;
		String customerName = null;
		String customerNumber = null;
		
		// Load CRM for the first time
		performance.loadCRM(driver);
		
		// Initialize the company variables
		customer = "Prime";
		url = "http://crm.ad.mercuryvmp.com/products/MercuryAutoLogin.aspx?ID=737303&type=0";
		trackingNumber = "29716357-29716358";
		subUser = "Greg Bell";
		customerName = "Prime";
		customerNumber = "8668391041";
		System.out.println("Customer: " + customer);
			
		// Create the timing array to store all of the page load times
		ArrayList<String> times = new ArrayList<String>();

		// Perform the timing test
		times = performance.performanceTest(driver, times, url, trackingNumber, subUser, customerName, customerNumber);
		
		// Write the timing data to database
		performance.writeTimingDataToDatabaseForPrime(driver, customerName, customerNumber, times);
		
		// Clear the array
		times.clear();
		
		// Log test
		perform.addInfoToExtentReport(driver, "Performance", "Captured page load times for multiple companies");
		
	} // end prime
	
} // end the Secure class
