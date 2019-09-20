package regressionDB;

import java.util.ArrayList;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import setup.DriverFactory;
import setup.TestSetup;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Automatic Assignment Settings</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   07-30-2019
 */

@Listeners(utils.Listener.class)
@Test (singleThreaded=true)
public class Archiving extends TestSetup {

	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Create the array of loan id's</li>
	 *  <li>Iterate through the loan id's and verify the results</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"broken"}, alwaysRun=true)
	public void archive() throws Exception{
		
		// Create the driver
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Set the environment
		String env = StoredVariables.getusernameEnvironment().get();
		
		if (env.equals("QA")) {
		
			// Create the Duplicate folder LoanID's array list
			ArrayList<String> duplicateFolderData = new ArrayList<String>();
			duplicateFolderData.add("138866");
			duplicateFolderData.add("138867");
			duplicateFolderData.add("138868");
			duplicateFolderData.add("138869");
			
			// Iterate through the data
			iterateThroughData(driver, duplicateFolderData);
			
			// Create the Sync Status LoanID's array list
			ArrayList<String> syncStatusData = new ArrayList<String>();
			syncStatusData.add("428843");
			syncStatusData.add("428844");
			syncStatusData.add("428849");
			syncStatusData.add("428885");
			syncStatusData.add("428887");
			
			// Iterate through the data
			iterateThroughData(driver, syncStatusData);
			
			// Create the ULS Orders LoanID's array list
			ArrayList<String> ulSOrdersData = new ArrayList<String>();
			ulSOrdersData.add("403663");
			ulSOrdersData.add("403664");
			ulSOrdersData.add("403665");
			
			// Iterate through the data
			iterateThroughData(driver, ulSOrdersData);
			
			// Create the three order LoanID's array list
			ArrayList<String> threeOrderData = new ArrayList<String>();
			threeOrderData.add("410951");
			threeOrderData.add("410952");
			threeOrderData.add("410953");
			
			// Iterate through the data
			iterateThroughData(driver, threeOrderData);
			
			// Create the AMC two order  LoanID's array list
			ArrayList<String> amcTwoOrderData = new ArrayList<String>();
			amcTwoOrderData.add("295610");
			amcTwoOrderData.add("295611");
			
			// Iterate through the data
			iterateThroughData(driver, amcTwoOrderData);
			
			// Create the Lender two order LoanID's array list
			ArrayList<String> lenderTwoOrderData = new ArrayList<String>();
			lenderTwoOrderData.add("385867");
			lenderTwoOrderData.add("385868");
			
			// Iterate through the data
			iterateThroughData(driver, lenderTwoOrderData);
			
			// Create the Lender no vmp two order LoanID's array list
			ArrayList<String> lenderNoVMPTwoOrderData = new ArrayList<String>();
			lenderNoVMPTwoOrderData.add("428498");
			lenderNoVMPTwoOrderData.add("428499");
			
			// Iterate through the data
			iterateThroughData(driver, lenderNoVMPTwoOrderData);
			
			// Create the Duped Order LoanID's array list
			ArrayList<String> dupedOrderData = new ArrayList<String>();
			dupedOrderData.add("428895");
			dupedOrderData.add("428896");
			dupedOrderData.add("428897");
			
			// Iterate through the data
			iterateThroughData(driver, dupedOrderData);
			
			// Log test
			perform.addInfoToExtentReport(driver, "Archive DB", "Verified correct Loan ID's are returned from the Order_Archive_DependentOrders_Get stored procedure");
			
		} // end if QA
		
	} // end archive
	
	/**
	 * Iterate through data.
	 *
	 * @param driver the driver
	 * @param data the data
	 * @throws Exception the exception
	 */
	private void iterateThroughData (RemoteWebDriver driver, ArrayList<String> data) throws Exception {
		
		// Iterate through the data 
		int i = 0;
		while (i < data.size()) {
			
			// Execute the stored procedure for each item in the array
			ArrayList<String> result = db.executeOrder_Archive_DependentOrders_Get(driver, data.get(i));
			
			// Verify the number of results equals the number of items in the data array
			perform.verification(driver, result.size(), "equals", data.size());
			
			// Verify the result contains every Loan ID in the data array
			int a = 0;
			while (a < data.size()) {
				
				Assert.assertTrue(result.contains(data.get(i)), data.get(i) + " is missing from the results");
				
				a++;
				
			} // end while for verifying the results
			
			i++;
			
		} // end while for iterating through the data
		
	} // end iterateThroughData
	
} // end the Archiving class
