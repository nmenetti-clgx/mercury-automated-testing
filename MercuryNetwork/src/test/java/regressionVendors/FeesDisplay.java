package regressionVendors;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Vendors.VOrderDetails;
import setup.DriverFactory;
import setup.TestSetup;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Vendors - Fees Display</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-02-2019
 */

@Listeners(utils.Listener.class)
public class FeesDisplay extends TestSetup {
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Create order from Secure and assign it to Appraiser1</li>
	 * 	<li>Login to Vendors</li>
	 * 	<li>Open the order</li>
	 * 	<li>Verify the Order Fee displays properly</li>
	 * 	<li>Verify the Transaction Fee displays properly</li>
	 * 	<li>Accept the order</li>
	 * 	<li>Verify the Order Fee displays properly</li>
	 * 	<li>Verify the Transaction Fee displays properly</li>
	 * 	<li>Log test</li>
	 * </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Create Order", "Vendors - Orders", "Vendors - Accept Order"}, alwaysRun=true)
	public void verifyFeesDisplays() throws Exception {
		
		// Create the driver
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
//		// Set the snapshot variable
//		String snapshot = StoredVariables.getenableSnapshots().get();
//		
//		// Get the environment
//		String env = StoredVariables.getenvironment().get();
		
		// Set the tracking number variable
		String trackingNumber = "";
		
//		if (!env.contains("QA")) {
			
			// Create order from Secure and assign it to Appraiser1
			secure.createAndAssignNewResidentialAppraisalOrderUsingCustomFeePanel(driver, "Baseline1", "Appraiser1");
	
			// Get the tracking number
			trackingNumber = StoredVariables.gettrackingNumber().get();

//		} // end if not on QA
		
//		// Restore the snapshot of the order
//		if (env.contains("QA") && snapshot.equals("true")) {
//			trackingNumber = "410221";
//			db.restoreOrderSnapshot(driver, trackingNumber);
//		} // end if
		
		// Login to Vendors
		vendors.login(driver, "Appraiser1", StoredVariables.getpassword().get());
		
		// Open the order
		vendors.findAndOpenOrder(driver, trackingNumber);
		
		// Verify the Order Fee displays properly
		String orderFee = VOrderDetails.orderFee_txt(driver).getText();
		perform.verification(driver, orderFee, "equals", "$350");
		
		// Verify the Transaction Fee displays properly
		String transactionFee = VOrderDetails.transactionFee_txtbx(driver).getText();
		perform.verification(driver, transactionFee, "!equal", "$0.00");
		
		// Accept the order
		vendors.acceptOrder(driver, trackingNumber);
		
		// Verify the Order Fee displays properly
		orderFee = VOrderDetails.orderFee_txt(driver).getText();
		perform.verification(driver, orderFee, "equals", "$350");
		
		// Verify the Transaction Fee displays properly
		transactionFee = VOrderDetails.transactionFee_txtbx(driver).getText();
		perform.verification(driver, transactionFee, "!equal", "$0.00");
		
		// Log test
		perform.addInfoToExtentReport(driver, "Regression Vendors", "Verified the Order and Transaction fees display correctly before and after accepting an order");
		
	} // end verifyFeesDisplay
	
} // end the FeeDisplays class
