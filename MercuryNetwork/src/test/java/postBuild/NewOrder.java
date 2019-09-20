package postBuild;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Secure.SConfirmOrder;
import pageObjects.Secure.SOrderDetails;
import pageObjects.Vendors.VOrderDetails;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Post Build - New Order</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class NewOrder extends TestSetup {
	
	/** The user secure. */
	private String userSecure = "PostBuild1";
	
	/** The user VMP. */
	private String userVMP = "OriginatorPostBuild1";
	
	/** The user vendors. */
	private String userVendors = "PostBuildAppraiser1";
	
	/** The password. */
	private String password = "";
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to the VMP Client portal and sign in</li>
	 * 	<li>Set variables</li>
	 * 	<li>Create a new order</li>
	 * 	<li>Get order number information</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Find order</li>
	 * 	<li>Open order</li>
	 * 	<li>Click Assign</li>
	 * 	<li>Assign the order</li>
	 * 	<li>Click Finish</li>
	 * 	<li>Verify history</li>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Accept the order</li>
	 * 	<li>Verify history</li>
	 * 	<li>Log test</li>
* </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"VMP - Create Order", "Secure - Orders", "Vendors - Orders", "Vendors - Accept Order"}, alwaysRun=true)
	public void newOrder() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		password = StoredVariables.getpassword().get();
		
		// Go to the VMP Client portal and sign in
		vmp.login(driver, userSecure, userVMP, password);
		
		// Set variables
		vmp.setMinimumVariables(driver);
		
		// Create a new order
		vmp.createVMPOrder(driver);
		
		// Get order number information
		db.getLoanIDsFromVMPClientPortalOrder(driver);
		String trackingNumber = StoredVariables.gettrackingNumber().get();
		
		// Log in to Secure
		secure.login(driver, userSecure, password);
		
		// Find order
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Open order
		secure.openOrder(driver, trackingNumber);
		
		// Click Assign
		perform.click(driver, SOrderDetails.assign_btn(driver));
		
		// Assign the order
		secure.selectVendor(driver, userVendors);
		
		// Click Finish
		perform.click(driver, SConfirmOrder.finishTop_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Verify history
		String history = SOrderDetails.history_txt(driver).getText();
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation PostBuildAppraiser1"), "The history is incorrect on Secure. \n" + history);
		Assert.assertTrue(history.contains("Reassigned by Client (Automation PostBuild1) to Automation PostBuildAppraiser1"), "The history is incorrect on Secure. \n" + history);
		Assert.assertTrue(history.contains("Order Changed by Client (Automation PostBuild1)"), "The history is incorrect on Secure. \n" + history);
		Assert.assertTrue(history.contains("Requires assignment"), "The history is incorrect on Secure. \n" + history);
		Assert.assertTrue(history.contains("Awaiting acceptance"), "The history is incorrect on Secure. \n" + history);
		
		// Log in to Vendors
		vendors.login(driver, userVendors, password);
		
		// Accept the order
		vendors.acceptOrder(driver, trackingNumber);
		
		// Verify history
		history = VOrderDetails.history_txt(driver).getText();
		Assert.assertTrue(history.contains("Order accepted by Appraiser (Automation PostBuildAppraiser1) and In Progress"), "The history is incorrect on Secure. \n" + history);
		Assert.assertTrue(history.contains("These are accepting notes"), "The history is incorrect on Secure. \n" + history);
		Assert.assertTrue(history.contains("Awaiting acceptance by Automation PostBuildAppraiser1"), "The history is incorrect on Secure. \n" + history);
			
		// Log test
		test.log(LogStatus.INFO, "Post-Build New Order", "Verified that you can create an order on VMP, assign it from Secure and accept it on Vendors");
		
	} // end newOrder
	
} // end the NewOrder class
