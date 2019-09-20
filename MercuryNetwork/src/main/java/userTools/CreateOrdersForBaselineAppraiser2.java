package userTools;

import org.openqa.selenium.remote.RemoteWebDriver;
//import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//import pageObjects.Secure.SConfirmOrder;
//import pageObjects.Secure.SNewOrder;
//import pageObjects.Secure.SOrders;
//import pageObjects.Secure.SVendorSelectionSettings;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * The Class CreateOrdersForBaselineAppraiser2.
 */
@Listeners(utils.Listener.class)

public class CreateOrdersForBaselineAppraiser2 extends TestSetup {
	
	/** The user. */
	private static String user = "Baseline2";
	
	/** The borrower number. */
	@SuppressWarnings("unused")
	private String borrowerNumber;
	
	/**
	 * Creates the new residential appraisal order.
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"baseline", "positive", "newOrder"})
	public synchronized void createNewResidentialAppraisalOrder() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Login to Secure
		secure.login(driver, user, StoredVariables.getpassword().get());
		
		for (int a = 1; a <= 50; a++)
			
		{
			secure.createAndAssignNewResidentialAppraisalOrderUsingCustomFeePanel(driver, user, "Automation BaselineAppraiser2");
		
		} // end for loop
	
		// Log test
		test.log(LogStatus.INFO, "Orders", "Created new Resiential Appraisal order on Secure");
			
		} // end createNewResidentialAppraisalOrder
	
} // end the Secure_OrderManagement class

