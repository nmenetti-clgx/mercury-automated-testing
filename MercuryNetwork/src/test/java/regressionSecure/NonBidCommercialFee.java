package regressionSecure;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Secure.SConfirmOrder;
import pageObjects.Secure.SNewOrder;
import setup.DriverFactory;
import setup.TestSetup;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Alternative Valuations</h1>
 * 
 * <p>Place orders for RealCondition Report, OptiVal AVM Cascade and OptiVal+ 
 *
 * @author  Dustin Norman
 * @since   95-07-2018
 */

@Listeners(utils.Listener.class)
public class NonBidCommercialFee extends TestSetup {
	
	/** The user secure. */
	private final String userSecure = "RegressionSecure20";
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li></li>
	 * </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Create Order"}, alwaysRun=true)
	public void verifyTransactionFee() throws Exception {
		
		// Create the driver
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Set the password
		String password = StoredVariables.getpassword().get();
		
		// Log in to Secure
		secure.login(driver, userSecure, password);
		
		// Go to new commercial appraisal
		secure.goToCommercialAppraisal(driver);
		
		// Set the minimum order details
		secure.setNewCommercialAppraisalOrderVariablesMinimum(driver);
		StoredVariables.getassignmentInformationForm().set("Commercial Appraisal Report");
		StoredVariables.getassignmentInformationIssueAsBid().set(false);
		
		// Enter order details
		secure.enterNewCommercialAppraisalOrder(driver);
		
		// Click Next
		perform.click(driver, SNewOrder.next_btn(driver));
		
		// Select vendor
		secure.selectVendor(driver, "Appraiser3");
		
		// Check the Pay transaction fee checkbox
		perform.checkCheckbox(driver, SConfirmOrder.transactionFee_chkbx(driver));
		
		// Verify the transaction fee
		perform.verification(driver, SConfirmOrder.transactionFee_txt(driver).getText(), "contains", "$30.00");
		
		// Go to new commercial appraisal
		secure.goToCommercialAppraisal(driver);
		
		// Set the minimum order details
		secure.setNewCommercialAppraisalOrderVariablesMinimum(driver);
		StoredVariables.getassignmentInformationForm().set("Commercial Land Appraisal Report");
		StoredVariables.getassignmentInformationIssueAsBid().set(false);
		
		// Enter order details
		secure.enterNewCommercialAppraisalOrder(driver);
		
		// Click Next
		perform.click(driver, SNewOrder.next_btn(driver));
		
		// Select vendor
		secure.selectVendor(driver, "Appraiser3");
		
		// Check the Pay transaction fee checkbox
		perform.checkCheckbox(driver, SConfirmOrder.transactionFee_chkbx(driver));
		
		// Verify the transaction fee
		String fee = "$13.00";
		if (!StoredVariables.getusernameEnvironment().get().equals("QA")) {
			fee = "$14.50";
		} // end if
		perform.verification(driver, SConfirmOrder.transactionFee_txt(driver).getText(), "contains", fee);

		// Log test
		perform.addInfoToExtentReport(driver, "Order Fee", "Verified transaction fee displays correctly for non-bid commercial orders");
			
	} // end verifyTransactionFee
	
} // end the NonBidCommercialFee class
