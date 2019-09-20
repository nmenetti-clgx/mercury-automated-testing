package performance;

import java.util.ArrayList;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import setup.DriverFactory;
import setup.TestSetup;
import utils.Retry;
import utils.StoredVariables;

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
 * @since   08-21-2019
 */

@Listeners(utils.Listener.class)
public class Prime extends TestSetup {
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Create the driver</li>
	 * 	<li>Load CRM for the first time</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"broken"}, alwaysRun=true)
	public void prime() throws Exception{
		
		// Create the driver
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Set the environment
		String env = StoredVariables.getusernameEnvironment().get();
		
		// Set the Excel file info
		String filePath = StoredVariables.getdocDir().get()+"Performance"+StoredVariables.getdirSlashes().get();
		String fileName = env.equals("QA") ? "MercuryPageLoadTimesPrime-QA.xlsx" : "MercuryPageLoadTimesPrime.xlsx";
		
		// Get the hour
		int hour = Integer.parseInt(perform.getTodaysDateFormatted(driver, "HH"));
		
		// Set the time for the sheet
		String sheet = null;
		if (hour >= 8 && hour < 10) {
			sheet = "8";
		} else if (hour >= 10 && hour < 12) {
			sheet = "10";
		} else if (hour >= 12 && hour < 14) {
			sheet = "12";
		} else if (hour >= 14 && hour < 16) {
			sheet = "14";
		} else if (hour >= 16 && hour < 18) {
			sheet = "16";
		} else if (hour >= 18 && hour < 20) {
			sheet = "18";
		} // end if/else hour
		
		// Load CRM for the first time
		performance.loadCRM(driver);
		
		// Initialize the company variables
		String customer = "Prime";
		String url = "http://crm.ad.mercuryvmp.com/products/MercuryAutoLogin.aspx?ID=737303&type=0";
		String trackingNumber = "29716357-29716358";
		String subUser = "Greg Bell";
		String customerName = "Prime";
		String customerNumber = "8668391041";
		System.out.println("Customer: " + customer);
			
		// Create the timing array to store all of the page load times
		ArrayList<String> times = new ArrayList<String>();

		// Perform the timing test
		times = performance.performanceTest(driver, times, url, trackingNumber, subUser, customerName, customerNumber);
	
		// Write the timing data to database
		performance.writeTimingDataToDatabase(driver, customerName, customerNumber, times);
		
		// Write the timing data to Excel
		performance.writeTimingDataToExcel(driver, filePath, fileName, sheet, times);
		
		// Clear the array
		times.clear();
		
		// Email the report
		String to = "rupace@corelogic.com,phperkins@corelogic.com,keriley@corelogic.com,dnorman@corelogic.com";
		perform.sendEmail(driver, to, "", "Mercury Network Benchmarking", "Attached are the latest automated test findings for today's timing run.", filePath, fileName);
		
		// Log test
		perform.addInfoToExtentReport(driver, "Performance", "Captured page load times for multiple companies");
		
	} // end prime
	
} // end the Secure class
