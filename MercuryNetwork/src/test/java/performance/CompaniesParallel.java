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
public class CompaniesParallel extends TestSetup {
	
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
	public void axis() throws Exception{
		
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
		customer = "Axis";
		url = "http://crm.ad.mercuryvmp.com/products/MercuryAutoLogin.aspx?ID=512378&type=0";
		trackingNumber = "597356-29384064";
		subUser = "Holly Graves";
		customerName = "Axis Appraisal Management Solutions";
		customerNumber = "4158748180";
		System.out.println("Customer: " + customer);
			
		// Create the timing array to store all of the page load times
		ArrayList<String> times = new ArrayList<String>();

		// Perform the timing test
		times = performance.performanceTest(driver, times, url, trackingNumber, subUser, customerName, customerNumber);
		
		// Write the timing data to database
		performance.writeTimingDataToDatabase(driver, customerName, customerNumber, times);
		
		// Clear the array
		times.clear();
		
		// Log test
		perform.addInfoToExtentReport(driver, "Performance", "Captured page load times for multiple companies");
		
	} // end axis
	
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
	public void academy() throws Exception{
		
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
		customer = "Academy";
		url = "http://crm.ad.mercuryvmp.com/products/MercuryAutoLogin.aspx?ID=728030&type=0";
		trackingNumber = "29601922-29601935";
		subUser = "Steven Caldwell";
		customerName = "Academy Mortgage Corporation";
		customerNumber = "8012333796";
		System.out.println("Customer: " + customer);
			
		// Create the timing array to store all of the page load times
		ArrayList<String> times = new ArrayList<String>();

		// Perform the timing test
		times = performance.performanceTest(driver, times, url, trackingNumber, subUser, customerName, customerNumber);
		
		// Write the timing data to database
		performance.writeTimingDataToDatabase(driver, customerName, customerNumber, times);
		
		// Clear the array
		times.clear();
		
		// Log test
		perform.addInfoToExtentReport(driver, "Performance", "Captured page load times for multiple companies");
		
	} // end academy
	
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
	public void dwellworks() throws Exception{
		
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
		customer = "Dwellworks";
		url = "http://crm.ad.mercuryvmp.com/products/MercuryAutoLogin.aspx?ID=730336&type=0";
		trackingNumber = "29534181-29534182";
		subUser = "Norm Koenig";
		customerName = "Dwellworks Residential Services, LLC";
		customerNumber = "2166824222";
		System.out.println("Customer: " + customer);
			
		// Create the timing array to store all of the page load times
		ArrayList<String> times = new ArrayList<String>();

		// Perform the timing test
		times = performance.performanceTest(driver, times, url, trackingNumber, subUser, customerName, customerNumber);
		
		// Write the timing data to database
		performance.writeTimingDataToDatabase(driver, customerName, customerNumber, times);
		
		// Clear the array
		times.clear();
		
		// Log test
		perform.addInfoToExtentReport(driver, "Performance", "Captured page load times for multiple companies");
		
	} // end dwellworks
	
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
	public void unison() throws Exception{
		
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
		customer = "Unison";
		url = "http://crm.ad.mercuryvmp.com/products/MercuryAutoLogin.aspx?ID=747781&type=0";
		trackingNumber = "29572931-29572932";
		subUser = "Brittany Turner";
		customerName = "Unison Agreement Corp";
		customerNumber = "4157236623";
		System.out.println("Customer: " + customer);
			
		// Create the timing array to store all of the page load times
		ArrayList<String> times = new ArrayList<String>();

		// Perform the timing test
		times = performance.performanceTest(driver, times, url, trackingNumber, subUser, customerName, customerNumber);
		
		// Write the timing data to database
		performance.writeTimingDataToDatabase(driver, customerName, customerNumber, times);
		
		// Clear the array
		times.clear();
		
		// Log test
		perform.addInfoToExtentReport(driver, "Performance", "Captured page load times for multiple companies");
		
	} // end unison
	
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
	public void phh() throws Exception{
		
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
		customer = "PHH";
		url = "http://crm.ad.mercuryvmp.com/products/MercuryAutoLogin.aspx?ID=718333&type=0";
		trackingNumber = "29318078-29318081";
		subUser = "Mary Norman";
		customerName = "PHH Mortgage ";
		customerNumber = "9165893416";
		System.out.println("Customer: " + customer);
			
		// Create the timing array to store all of the page load times
		ArrayList<String> times = new ArrayList<String>();

		// Perform the timing test
		times = performance.performanceTest(driver, times, url, trackingNumber, subUser, customerName, customerNumber);
		
		// Write the timing data to database
		performance.writeTimingDataToDatabase(driver, customerName, customerNumber, times);
		
		// Clear the array
		times.clear();
		
		// Log test
		perform.addInfoToExtentReport(driver, "Performance", "Captured page load times for multiple companies");
		
	} // end phh
	
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
	public void serviceFirst() throws Exception{
		
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
		customer = "Service 1st";
		url = "http://crm.ad.mercuryvmp.com/products/MercuryAutoLogin.aspx?ID=597066&type=0";
		trackingNumber = "754748-28120007";
		subUser = "Gloria Bondi";
		customerName = "Service 1st LLC";
		customerNumber = "4129529547";
		System.out.println("Customer: " + customer);
			
		// Create the timing array to store all of the page load times
		ArrayList<String> times = new ArrayList<String>();

		// Perform the timing test
		times = performance.performanceTest(driver, times, url, trackingNumber, subUser, customerName, customerNumber);
		
		// Write the timing data to database
		performance.writeTimingDataToDatabase(driver, customerName, customerNumber, times);
		
		// Clear the array
		times.clear();
		
		// Log test
		perform.addInfoToExtentReport(driver, "Performance", "Captured page load times for multiple companies");
		
	} // end serviceFirst
	
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
	public void KandM() throws Exception{
		
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
		customer = "K&M";
		url = "http://crm.ad.mercuryvmp.com/products/MercuryAutoLogin.aspx?ID=631650&type=0";
		trackingNumber = "29603710-29603721";
		subUser = "Lisa Downes";
		customerName = "K & M Appraisal Management Company";
		customerNumber = "2623730791";
		System.out.println("Customer: " + customer);
			
		// Create the timing array to store all of the page load times
		ArrayList<String> times = new ArrayList<String>();

		// Perform the timing test
		times = performance.performanceTest(driver, times, url, trackingNumber, subUser, customerName, customerNumber);
		
		// Write the timing data to database
		performance.writeTimingDataToDatabase(driver, customerName, customerNumber, times);
		
		// Clear the array
		times.clear();
		
		// Log test
		perform.addInfoToExtentReport(driver, "Performance", "Captured page load times for multiple companies");
		
	} // end KandM
	
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
	public void guardian() throws Exception{
		
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
		customer = "Guardian";
		url = "http://crm.ad.mercuryvmp.com/products/MercuryAutoLogin.aspx?ID=516987&type=0";
		trackingNumber = "29615121-29615125";
		subUser = "Liza Law";
		customerName = "Guardian/Sunflower Bank, N.A.";
		customerNumber = "9728081746";
		System.out.println("Customer: " + customer);
			
		// Create the timing array to store all of the page load times
		ArrayList<String> times = new ArrayList<String>();

		// Perform the timing test
		times = performance.performanceTest(driver, times, url, trackingNumber, subUser, customerName, customerNumber);
		
		// Write the timing data to database
		performance.writeTimingDataToDatabase(driver, customerName, customerNumber, times);
		
		// Clear the array
		times.clear();
		
		// Log test
		perform.addInfoToExtentReport(driver, "Performance", "Captured page load times for multiple companies");
		
	} // end guardian
	
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
		performance.writeTimingDataToDatabase(driver, customerName, customerNumber, times);
		
		// Clear the array
		times.clear();
		
		// Log test
		perform.addInfoToExtentReport(driver, "Performance", "Captured page load times for multiple companies");
		
	} // end prime
	
} // end the Secure class
