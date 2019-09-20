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
public class Secure extends TestSetup {
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Create the driver</li>
	 * 	<li>Load CRM for the first time</li>
	 * 	<li>Set the Excel file info</li>
	 * 	<li>Initialize the start load time variable</li>
	 * 	<li>Create the timing array to store all of the page load times</li>
	 * 	<li>Create the customer array</li>
	 * 	<li>Initialize the company variables</li>
	 * 	<li>Set the company variables</li>
	 * 	<li>Login through CRM</li>
	 * 	<li>Go to Vendor Selection Settings</li>
	 * 	<li>Go to Orders</li>
	 * 	<li>Click on the All Open Orders folder</li>
	 * 	<li>Search for an order</li>
	 * 	<li>Click the Contains radio button</li>
	 * 	<li>Select Borrower in the In Field dropdown</li>
	 * 	<li>Select Placed as All</li>
	 * 	<li>Click the Find magnifying glass</li>
	 * 	<li>Open the order</li>
	 * 	<li>Go to Users</li>
	 * 	<li>Select sub user</li>
	 * 	<li>Go to Fee Panel</li>
	 * 	<li>Go to Orders</li>
	 * 	<li>Click on the Action Required folder</li>
	 * 	<li>Go to Clients</li>
	 * 	<li>Go to VMP XSites settings</li>
	 * 	<li>Go to Account</li>
	 * 	<li>Write the timing data to Excel</li>
	 * 	<li>Clear the array</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={}, alwaysRun=true)
	public void securePageLoadTimes() throws Exception{
		
		// Create the driver
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		System.out.println("USER: " + System.getProperty("user.name"));
		
		// Set the environment
		String env = StoredVariables.getusernameEnvironment().get();
		
		// Load CRM for the first time
		performance.loadCRM(driver);
		
		// Set the Excel file info
		String filePath = StoredVariables.getdocDir().get()+"Performance"+StoredVariables.getdirSlashes().get();
		String fileName = env.equals("QA") ? "MercuryPageLoadTimes-QA.xlsx" : "MercuryPageLoadTimes.xlsx";
		
		// Create the customer array
		ArrayList<String> customers = new ArrayList<String>();
		customers.add("Axis");
		customers.add("Academy");
		customers.add("Dwellworks");
		customers.add("Unison");
		customers.add("PHH");
		customers.add("Service 1st");
		customers.add("K&M");
		customers.add("Guardian");
		customers.add("Prime");
		
		/**
		 * EXECUTE THE TIMED TESTS
		 */
		
		for (String customer : customers) {
			
			// Initialize the company variables
			String url = null;
			String trackingNumber = null;
			String subUser = null;
			String customerName = null;
			String customerNumber = null;
			
			if (env.equals("QA")) {
				// Set the company variables
				switch (customer) {
				case "Axis":
					url = "";
					trackingNumber = "";
					subUser = "";
					customerName = "";
					customerNumber = "";
					break;
				case "Prime":
					url = "";
					trackingNumber = "";
					subUser = "";
					customerName = "";
					customerNumber = "";
				case "Academy":
					url = "";
					trackingNumber = "";
					subUser = "";
					customerName = "";
					customerNumber = "";
					break;
				case "Dwellworks":
					url = "";
					trackingNumber = "";
					subUser = "";
					customerName = "";
					customerNumber = "";
					break;
				case "Unison":
					url = "";
					trackingNumber = "";
					subUser = "";
					customerName = "";
					customerNumber = "";
					break;
				case "PHH":
					url = "";
					trackingNumber = "";
					subUser = "";
					customerName = "";
					customerNumber = "";
					break;
				case "Service 1st":
					url = "";
					trackingNumber = "";
					subUser = "";
					customerName = "";
					customerNumber = "";
					break;
				case "K&M":
					url = "";
					trackingNumber = "";
					subUser = "";
					customerName = "";
					customerNumber = "";
					break;
				case "Guardian":
					url = "";
					trackingNumber = "";
					subUser = "";
					customerName = "";
					customerNumber = "";
					break;
				default:
					break;
				} // end switch statement
			} else {
				switch (customer) {
				case "Axis":
					url = "http://crm.ad.mercuryvmp.com/products/MercuryAutoLogin.aspx?ID=512378&type=0";
					trackingNumber = "597356-29384064";
					subUser = "Holly Graves";
					customerName = "Axis Appraisal Management Solutions";
					customerNumber = "4158748180";
					break;
				case "Prime":
					url = "http://crm.ad.mercuryvmp.com/products/MercuryAutoLogin.aspx?ID=737303&type=0";
					trackingNumber = "29716357-29716358";
					subUser = "Greg Bell";
					customerName = "Prime";
					customerNumber = "8668391041";
				case "Academy":
					url = "http://crm.ad.mercuryvmp.com/products/MercuryAutoLogin.aspx?ID=728030&type=0";
					trackingNumber = "29601922-29601935";
					subUser = "Steven Caldwell";
					customerName = "Academy Mortgage Corporation";
					customerNumber = "8012333796";
					break;
				case "Dwellworks":
					url = "http://crm.ad.mercuryvmp.com/products/MercuryAutoLogin.aspx?ID=730336&type=0";
					trackingNumber = "29534181-29534182";
					subUser = "Norm Koenig";
					customerName = "Dwellworks Residential Services, LLC";
					customerNumber = "2166824222";
					break;
				case "Unison":
					url = "http://crm.ad.mercuryvmp.com/products/MercuryAutoLogin.aspx?ID=747781&type=0";
					trackingNumber = "29572931-29572932";
					subUser = "Brittany Turner";
					customerName = "Unison Agreement Corp";
					customerNumber = "4157236623";
					break;
				case "PHH":
					url = "http://crm.ad.mercuryvmp.com/products/MercuryAutoLogin.aspx?ID=718333&type=0";
					trackingNumber = "29318078-29318081";
					subUser = "Mary Norman";
					customerName = "PHH Mortgage ";
					customerNumber = "9165893416";
					break;
				case "Service 1st":
					url = "http://crm.ad.mercuryvmp.com/products/MercuryAutoLogin.aspx?ID=597066&type=0";
					trackingNumber = "754748-28120007";
					subUser = "Gloria Bondi";
					customerName = "Service 1st LLC";
					customerNumber = "4129529547";
					break;
				case "K&M":
					url = "http://crm.ad.mercuryvmp.com/products/MercuryAutoLogin.aspx?ID=631650&type=0";
					trackingNumber = "29603710-29603721";
					subUser = "Lisa Downes";
					customerName = "K & M Appraisal Management Company";
					customerNumber = "2623730791";
					break;
				case "Guardian":
					url = "http://crm.ad.mercuryvmp.com/products/MercuryAutoLogin.aspx?ID=516987&type=0";
					trackingNumber = "29615121-29615125";
					subUser = "Liza Law";
					customerName = "Guardian/Sunflower Bank, N.A.";
					customerNumber = "9728081746";
					break;
				default:
					break;
				} // end switch statement
			} // end if
			System.out.println("Customer: " + customer);
			
			// Create the timing array to store all of the page load times
			ArrayList<String> times = new ArrayList<String>();

			// Perform the timing test
			try {
				times = performance.performanceTest(driver, times, url, trackingNumber, subUser, customerName, customerNumber);
			} catch (Exception e) {
				times = new ArrayList<String>();
				times = performance.performanceTest(driver, times, url, trackingNumber, subUser, customerName, customerNumber);
			} // end try/catch
			
			// Write the timing data to Excel
			performance.writeTimingDataToExcel(driver, filePath, fileName, customer, times);
			
			// Write the timing data to database
			performance.writeTimingDataToDatabase(driver, customerName, customerNumber, times);
			
			// Clear the array
			times.clear();
		
		} // end for loop to go through timings
		
		// Email the report
		if (env.equals("Live")) {
			String to = "dumoore@corelogic.com,lizmoore@corelogic.com,temitchum@corelogic.com,rupace@corelogic.com,phperkins@corelogic.com,peensey@corelogic.com,kehill@corelogic.com,janegrete@corelogic.com,hlively@corelogic.com,keriley@corelogic.com,dnorman@corelogic.com";
			perform.sendEmail(driver, to, "", "Mercury Network Benchmarking", "Attached are the latest automated test findings for today's timing run.", filePath, fileName);
		} // end if
		
		// Log test
		perform.addInfoToExtentReport(driver, "Performance", "Captured page load times for multiple companies");
		
	} // end securePageLoadTimes
	
} // end the Secure class
