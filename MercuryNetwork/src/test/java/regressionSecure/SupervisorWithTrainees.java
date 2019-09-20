package regressionSecure;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjects.Secure.SModifySelectionSettings;
import pageObjects.Secure.SNewOrder;
import pageObjects.Secure.SOrderDetails;
import pageObjects.Secure.SVendorProfile;
import pageObjects.Secure.SVendorSelection;
import pageObjects.Secure.SVendorSelectionSettings;
import pageObjects.Vendors.VOrderDetails;
import pageObjects.Vendors.VOrderEdit;
import pageObjects.Vendors.VSelectTrainee;
import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
* <h1>Secure - Supervisor with Trainees</h1>
* Verify when Use Supervisor - Preferred is set, Supervisors are at the top of the
* list when assigning a vendor and that only Supervisors are displayed
* as available vendors when set to Use Supervisor - Required. 
* <p>
* Verify the Trainee hyperlinks are displayed and open and all trainees are listed.
* <p>
* Verify Order Details displays Trainee information correctly
* @author  Dustin Norman
* @since   05-10-2018
*/

@Listeners(utils.Listener.class)
public class SupervisorWithTrainees extends TestSetup {
	
	/** The user secure. */
	private final String userSecure = "RegressionSecure17";
	
	/** The user appraiser. */
	private final String userAppraiser = "TraineeAppraiser2";
	
	/** The password. */
	private final String password = "T3sting1";
	
	/**
	 * Verify Supervisor with Trainees functionality
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set preferences and enable all status mapping</li>
	 * 	<li>Login to Secure as Lender</li>
	 * 	<li>Go to Vendor Selection Settings</li>
	 * 	<li>Enable the option and set to Prefer</li>
	 * 	<li>Check Use Supervisor</li>
	 * 	<li>Set Use Supervisor to Prefer</li>
	 * 	<li>Save settings</li>
	 * 	<li>Place a new order</li>
	 * 	<li>Go to new order</li>
	 * 	<li>Enter order info</li>
	 * 	<li>Click Next</li>
	 * 	<li>Check for Related Orders dialog</li>
	 * 	<li>On the Vendor Selection Step, confirm supervisors are sorted to the top of the list</li>
	 * 	<li>Check for TraineeAppraiser in the first 2 positions</li>
	 * 	<li>View the profile of a supervisor</li>
	 * 	<li>Confirm in the contact vendor section there is a line "Supervisor:" and the number of trainees is set to a hyperlink</li>
	 * 	<li>Click on the hyperlink</li>
	 * 	<li>Confirm the Trainee appraisers dialog opens</li>
	 * 	<li>Confirm it lists all trainees under the supervisor</li>
	 * 	<li>Click Close</li>
	 * 	<li>Click Cancel</li>
	 * 	<li>Click Back</li>
	 * 	<li>Modify selection settings to require supervisor</li>
	 * 	<li>Verify Use supervisor is checked</li>
	 * 	<li>Set Use supervisor to Require</li>
	 * 	<li>Click OK</li>
	 * 	<li>Click Next</li>
	 * 	<li>Check for Related Orders dialog</li>
	 * 	<li>On the Vendor Selection step, confirm only supervisors are displayed as eligible vendors</li>
	 * 	<li>Verify TraineeAppraiser are the only 2 available appraisers</li>
	 * 	<li>Select a supervisor vendor and finish placing the order</li>
	 * 	<li>Click Next</li>
	 * 	<li>Confirm the order</li>
	 * 	<li>Get the tracking number</li>
	 * 	<li>As the vendor, accept the order</li>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Accept the order</li>
	 * 	<li>Confirm in the Vendor Information section there is a field for Trainee with an Edit hyperlink</li>
	 * 	<li>Confirm clicking on the hyperlink opens the Select trainee dialog</li>
	 * 	<li>Confirm the trainee drop down displays the supervisor's trainees</li>
	 * 	<li>Confirm you can select a trainee and the change saves and is displayed on the details correctly</li>
	 * 	<li>Select the trainee from the dropdown</li>
	 * 	<li>Click OK</li>
	 * 	<li>Get the Vendor Information text</li>
	 * 	<li>Verify the Trainee is listed</li>
	 * 	<li>Verify the Trainee is a link</li>
	 * 	<li>Click to Edit the order</li>
	 * 	<li>Change the Assigned to Employee to another supervisor on the account</li>
	 * 	<li>Confirm the trainee drop down shows only the trainees assigned to the newly selected employee</li>
	 * 	<li>Get the list of dropdown options</li>
	 * 	<li>Get the number of options and verify there are only 2</li>
	 * 	<li>Select a trainee and save</li>
	 * 	<li>Click Save</li>
	 * 	<li>Confirm the changes saved and displayed correctly</li>
	 * 	<li>In Secure, view the order details</li>
	 * 	<li>Find and open the order</li>
	 * 	<li>Confirm there are audit trail events showing the order changes</li>
	 * 	<li>Confirm the view change history displays the old and new trainees correctly</li>
	 * 	<li>Get and verify text from the first row</li>
	 * 	<li>Get and verify text from the second row</li>
	 * 	<li>Click Close</li>
	 * 	<li>Confirm in the order details &gt; Vendor information section, the trainee is displayed underneath the assigned vendor</li>
	 * 	<li>Log test</li>
* </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Vendor Selection Settings", "Secure - Create Order", "Secure - Vendor Profile", "Secure - Modify Selection Settings", "Vendors - Accept Order", "Vendors - Trainee", "Secure - Orders"}, alwaysRun=true)
	public void supervisorWithTrainees() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Set preferences and enable all status mapping
		// Login to Secure as Lender
		secure.login(driver, userSecure, password);
		
		// Go to Vendor Selection Settings
		secure.goToVendorSelectionSettings(driver);

		// Enable the option and set to Prefer
		// Check Use Supervisor
		perform.checkCheckbox(driver, SVendorSelectionSettings.useSupervisor_chkbx(driver));
		
		// Set Use Supervisor to Prefer
		perform.selectDropdownOption(driver, SVendorSelectionSettings.supervisorWithTrainees_dropdown(driver), "Prefer");
		
		// Save settings
		secure.saveVendorSelectionSettings(driver);
		
		// Place a new order
		// Go to new order
		secure.goToResidentialAppraisal(driver);
		
		// Enter order info
		secure.setNewResidentialAppraisalOrderVariablesMinimum(driver);
		secure.enterNewResidentialAppraisalOrder(driver);
		
		// Click Next
		perform.click(driver, SNewOrder.next_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Check for Related Orders dialog
		secure.checkForRelatedOrdersDialog(driver);
		
		// On the Vendor Selection Step, confirm supervisors are sorted to the top of the list
		List<WebElement> vendorsList = driver.findElements(By.cssSelector("#tblFeePanel > tbody > tr > td.VendorSelectVendorName"));
		int i = 1;
		for (WebElement el : vendorsList) {
			System.out.println("vendor " + i + " = " + el.getText());
			String vendor = el.getText();
			// Check for TraineeAppraiser in the first 2 positions
			if (i <= 3) {
				Assert.assertTrue(vendor.equals("Automation TraineeAppraiser1") || vendor.equals("Automation TraineeAppraiser2") || vendor.equals("Automation Trainee2SU1"), "The first 3 appraisers should be TraineeAppraiser1, TraineeAppraiser2 or Trainee2SU1");
			} else {
				Assert.assertTrue(!vendor.contains("TraineeAppraiser") || !vendor.contains("Trainee2SU1"), "TraineeAppraiser1, TraineeAppraiser2 or Trainee2SU1 should not be outside the first 2 spots");
			} // end if/else
			i++;
		} // end for
		
		// View the profile of a supervisor
		secure.viewVendorProfile(driver, SVendorSelection.viewProfileFirstRow_btn(driver), "TraineeAppraiser");
		
		// Confirm in the contact vendor section there is a line "Supervisor:" and the number of trainees is set to a hyperlink
		WebElement traineeLink = driver.findElement(By.linkText("1 trainee"));
		Assert.assertTrue(traineeLink.isDisplayed(), "There should be a clickable link for the trainee");
		
		// Click on the hyperlink
		perform.click(driver, traineeLink);
		
		// Confirm the Trainee appraisers dialog opens
		perform.waitForElementToBeClickable(driver, SVendorProfile.closeTrainee_btn(driver));
		
		// Confirm it lists all trainees under the supervisor
		String traineeDialog = SVendorProfile.trainee_txt(driver).getText();
		String[] expected = {"The following trainee is under the supervision of Automation Trainee", "Auto", "Test", "OK", "Mercury Network does not utilize a service to validate trainee licenses."};
		perform.verifyTextContains(driver, traineeDialog, expected);
		
		// Click Close
		perform.click(driver, SVendorProfile.closeTrainee_btn(driver));
		
		// Click Cancel
		perform.click(driver, SVendorProfile.cancel_btn(driver));
		
		// Switch out of iFrame
		driver.switchTo().defaultContent();
		
		// Click Back
		perform.click(driver, SVendorSelection.backTop_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for Modify selection settings
		perform.waitForElementToBeClickable(driver, SNewOrder.modifySelectionSettings_btn(driver));
		
		// Modify selection settings to require supervisor
		secure.openModifySelectionSettingsFromNewOrder(driver);
		
		// Verify Use supervisor is checked
		perform.checkCheckbox(driver, SModifySelectionSettings.useSupervisor_chkbx(driver));
		
		// Set Use supervisor to Require
		perform.selectDropdownOption(driver, SModifySelectionSettings.supervisorWithTrainees_dropdown(driver), "Require");
		
		// Click OK
		perform.click(driver, SModifySelectionSettings.ok_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Click Next
		perform.click(driver, SNewOrder.next_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Check for Related Orders dialog
		secure.checkForRelatedOrdersDialog(driver);
		
		// On the Vendor Selection step, confirm only supervisors are displayed as eligible vendors
		int vendorsListCount = driver.findElements(By.cssSelector("#tblFeePanel > tbody > tr > td.VendorSelectVendorName")).size();
		Assert.assertTrue(vendorsListCount==3, "There should only be 3 available appraisers to choose from");
		vendorsList = driver.findElements(By.cssSelector("#tblFeePanel > tbody > tr > td.VendorSelectVendorName"));
		i = 1;
		for (WebElement el : vendorsList) {
			System.out.println("vendor " + i + " = " + el.getText());
			String vendor = el.getText();
			// Verify TraineeAppraiser are the only 2 available appraisers
			Assert.assertTrue(vendor.contains("TraineeAppraiser") || vendor.contains("Trainee2SU1"), "TraineeAppraiser1, TraineeAppraiser2 or Trainee2SU1 should not be outside the first 2 spots");
			i++;
		} // end for
		
		// Select a supervisor vendor and finish placing the order
		perform.clickInTable_Contains(driver, "TraineeAppraiser2");
		
		// Click Next
		perform.click(driver, SVendorSelection.nextTop_btn(driver));
		
		// Confirm the order
		secure.finishOrderAfterAssignment(driver, "", "", "");
		
		// Get the tracking number
		String trackingNumber = db.getTrackingNumber(driver, db.getLoanID(driver));
		
		// As the vendor, accept the order
		// Log in to Vendors
		vendors.login(driver, userAppraiser, password);
		
		// Accept the order
		vendors.acceptOrder(driver, trackingNumber);
		
		// Confirm in the Vendor Information section there is a field for Trainee with an Edit hyperlink
		int editLink = driver.findElements(By.linkText("Edit")).size();
		Assert.assertTrue(editLink==1, "There should be an Edit link");
		String vendorInformation = VOrderDetails.bidVendorInformation_txt(driver).getText();
		Assert.assertTrue(vendorInformation.contains("Edit"), "There should be an Edit link in the Vendor Information section");
		
		// Confirm clicking on the hyperlink opens the Select trainee dialog
		perform.click(driver, driver.findElement(By.linkText("Edit")));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Confirm the trainee drop down displays the supervisor's trainees
		// Wait for trainee dropdown
		perform.waitForElementToBeClickable(driver, VSelectTrainee.trainee_dropdown(driver));		
		
		// Confirm you can select a trainee and the change saves and is displayed on the details correctly
		// Select the trainee from the dropdown
		perform.selectDropdownOption(driver, VSelectTrainee.trainee_dropdown(driver), "Automation Test");
		
		// Click OK
		perform.click(driver, VSelectTrainee.ok_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Get the Vendor Information text
		vendorInformation = VOrderDetails.bidVendorInformation_txt(driver).getText();
		
		// Verify the Trainee is listed
		Assert.assertTrue(vendorInformation.contains("Automation Test"), "The trainee should be displayed in the Vendor Information section");
		
		// Verify the Trainee is a link
		Assert.assertTrue(driver.findElement(By.linkText("Automation Test")).isDisplayed(), "The Trainee should be a link option");
		
		// Click to Edit the order
		perform.click(driver, VOrderDetails.editOrder_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for Address txtbx
		perform.waitForElementToBeClickable(driver, VOrderEdit.address_txtbx(driver));
		
		// Change the Assigned to Employee to another supervisor on the account
		perform.selectDropdownOption(driver, VOrderEdit.assignedToSupervisor_dropdown(driver), "Automation Trainee2SU1");
		
		// Confirm the trainee drop down shows only the trainees assigned to the newly selected employee
		// Get the list of dropdown options
		List<String> dropdownOptions;
		try {
			dropdownOptions = perform.getAllDropdownOptions(driver, VOrderEdit.assignedToSupervisor_dropdown(driver));
		} catch (StaleElementReferenceException e) {
			dropdownOptions = perform.getAllDropdownOptions(driver, VOrderEdit.assignedToSupervisor_dropdown(driver));
		} // end try/catch
		Assert.assertTrue(dropdownOptions.contains("Automation Trainee2SU1") && dropdownOptions.contains("Automation TraineeAppraiser2"), "The dropdown options should only contain Trainee2SU1 and TraineeAppraiser2");
		
		// Get the number of options and verify there are only 2
		int numberOfOptions = driver.findElements(By.cssSelector("#"+VOrderEdit.assignedToSupervisor_dropdown()+" > option")).size();
		Assert.assertTrue(numberOfOptions==2, "There should only be 2 options in the dropdown");
		
		Thread.sleep(2000);
		
		// Select a trainee and save
		perform.selectDropdownOption(driver, VOrderEdit.trainee_dropdown(driver), "Auto Tester");
		
		// Click Save
		perform.click(driver, VOrderEdit.save_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for history text
		perform.waitForElementToBeClickable(driver, VOrderDetails.history_txt(driver));
		
		// Confirm the changes saved and displayed correctly
		vendorInformation = VOrderDetails.bidVendorInformation_txt(driver).getText();
		expected = new String[] {"automation"+StoredVariables.getusernameEnvironment().get()+"Trainee2SU1@dntest.net", "Auto Tester", "Automation Trainee2SU1"};
		perform.verifyTextContains(driver, vendorInformation, expected);
		
		// In Secure, view the order details
		secure.login(driver, userSecure, password);
		
		// Find and open the order
		secure.findAndOpenOrder(driver, trackingNumber);
		
		// Confirm there are audit trail events showing the order changes
		String history = SOrderDetails.history_txt(driver).getText();
		String expected1 = "Order reassigned internally by Appraiser (Automation TraineeAppraiser2)";
		String expected2 = "From Automation TraineeAppraiser2 to Automation Trainee2SU1";
		String expected3 = "Order Changed by Appraiser (Automation TraineeAppraiser2)";
		String expected4 = "Order accepted by Appraiser (Automation TraineeAppraiser2) and In Progress";
		String expected5 = "These are accepting notes";
		String expected6 = "Default Vendor Selection Settings were changed for this order by Client (Automation RegressionSecure17)";
		String expected7 = "Awaiting acceptance by Automation TraineeAppraiser2";
		String expected8 = "Opportunity expires at";
		expected = new String[] {expected1, expected2, expected3, expected4, expected5, expected6, expected7, expected8};
		perform.verifyTextContains(driver, history, expected);
		
		// Confirm the view change history displays the old and new trainees correctly
		perform.click(driver, driver.findElement(By.linkText("Click here.")));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);

		// Get and verify text from the first row
		String rowOne = SOrderDetails.statusDetailsRowOne_txt(driver).getText();
		expected = new String[] {"Appraiser Contact", "Automation TraineeAppraiser2", "Automation Trainee2SU1"};
		perform.verifyTextContains(driver, rowOne, expected);
		
		// Get and verify text from the second row
		String rowTwo = SOrderDetails.statusDetailsRowTwo_txt(driver).getText();
		expected = new String[] {"Trainee", "Automation Test", "Auto Tester"};
		perform.verifyTextContains(driver, rowTwo, expected);
		
		// Click Close
		perform.click(driver, SOrderDetails.closeStatusDetails_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Confirm in the order details > Vendor information section, the trainee is displayed underneath the assigned vendor
		vendorInformation = SOrderDetails.vendorInformation_txt(driver).getText();
		expected = new String[] {"Automation Trainee2SU1", "Auto Tester (Trainee)", "automation"+StoredVariables.getusernameEnvironment().get()+"Trainee2SU1@dntest.net"};
		perform.verifyTextContains(driver, vendorInformation, expected);
		
		// Log test
		test.log(LogStatus.INFO, "Secure Regression Test", "Verified that Trainees are displayed correctly and the Require/Prefer setting works");
		
	} // end supervisorWithTrainees
	
} // end the StateRegulation class
