package baselineSecure;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Secure.SFeePanel;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Baseline Secure - Fee Panel</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class Secure_FeePanel extends TestSetup {
	
	/** The user. */
	private static String user = "Baseline1";
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Go to Fee Panel</li>
	 * 	<li>Check if the order group already exists, if it does, delete it</li>
	 * 	<li>Delete the TestOrderGroup Order Groups</li>
	 * 	<li>Click Order Groups</li>
	 * 	<li>Switch iFrame</li>
	 * 	<li>Click Add new</li>
	 * 	<li>Enter TestOrderGroup</li>
	 * 	<li>Click Done</li>
	 * 	<li>Verify TestOrderGroup is in the table</li>
	 * 	<li>Click Save</li>
	 * 	<li>Switch out of the iFrame</li>
	 * 	<li>Click Order Groups</li>
	 * 	<li>Switch iFrame</li>
	 * 	<li>Verify TestOrderGroup is in the table</li>
	 * 	<li>Click Cancel</li>
	 * 	<li>Switch out of the iFrame</li>
	 * 	<li>Delete the TestOrderGroup Order Groups</li>
	 * 	<li>Click Order Groups</li>
	 * 	<li>Switch iFrame</li>
	 * 	<li>Verify TestOrderGroup is not in the table</li>
	 * 	<li>Click Cancel</li>
	 * 	<li>Switch out of the iFrame</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Order Groups", "Secure - Fee Panel", "Secure - Delete Order Group", "Secure - Add Order Group"}, alwaysRun=true)
	public void addAndDeleteOrderGroup() throws Exception {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Log in to Secure
		secure.login(driver, user, StoredVariables.getpassword().get());
		
		// Go to Fee Panel
		secure.goToFeePanel(driver);
		
		// Wait for the Fee panel table
		perform.waitForElementToBeVisible(driver, SFeePanel.feePanelTable_txt(), "id");
		
		// Check if the order group already exists, if it does, delete it
		// Delete the TestOrderGroup Order Groups
		secure.deleteOrderGroup(driver, "TestOrderGroup");
		
		// Click Order Groups
		perform.click(driver, SFeePanel.orderGroups_btn(driver));
		
		// Switch iFrame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "Appraisers/OrderGroupsManage.aspx", By.linkText("Add new"));
		
		// Wait for Add new link text
		perform.waitForElementToBeClickable(driver, "Add new", "linkText");
		
		// Click Add new
		perform.click(driver, driver.findElement(By.linkText("Add new")));
		
		// Enter TestOrderGroup
		perform.type(driver, SFeePanel.orderGroupName_txtbx(driver), "TestOrderGroup");
		
		// Click Done
		perform.click(driver, driver.findElement(By.xpath("//span[text()='Done']")));
		
		// Verify TestOrderGroup is in the table
		Assert.assertTrue(SFeePanel.orderGroupsTable_txt(driver).getText().contains("TestOrderGroup"), "The TestOrderGroup order group was not created");
		
		// Click Save
		perform.click(driver, SFeePanel.saveOrderGroups_btn(driver));
		
		// Switch out of the iFrame
		driver.switchTo().defaultContent();
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Click Order Groups
		perform.click(driver, SFeePanel.orderGroups_btn(driver));
		
		// Switch iFrame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "Appraisers/OrderGroupsManage.aspx", By.linkText("Add new"));
		
		// Wait for Add new link text
		perform.waitForElementToBeClickable(driver, "Add new", "linkText");
		
		// Verify TestOrderGroup is in the table
		Assert.assertTrue(SFeePanel.orderGroupsTable_txt(driver).getText().contains("TestOrderGroup"), "The TestOrderGroup order group was not created");
		
		// Click Cancel
		perform.click(driver, SFeePanel.cancelOrderGroups_btn(driver));
		
		// Switch out of the iFrame
		driver.switchTo().defaultContent();
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Delete the TestOrderGroup Order Groups
		secure.deleteOrderGroup(driver, "TestOrderGroup");
		
		// Click Order Groups
		perform.click(driver, SFeePanel.orderGroups_btn(driver));
		
		Thread.sleep(3000);
		
		// Switch iFrame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "Appraisers/OrderGroupsManage.aspx", By.linkText("Add new"));
		
		// Wait for Add new link text
		perform.waitForElementToBeClickable(driver, "Add new", "linkText");
		
		// Verify TestOrderGroup is not in the table
		Assert.assertTrue(!SFeePanel.orderGroupsTable_txt(driver).getText().contains("TestOrderGroup"), "The TestOrderGroup order group did not get deleted");
		
		// Click Cancel
		perform.click(driver, SFeePanel.cancelOrderGroups_btn(driver));
		
		// Switch out of the iFrame
		driver.switchTo().defaultContent();
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Log test
		test.log(LogStatus.INFO, "fee panel", "Added and deleted an Order group");
		
	} // end addAndDeleteOrderGroup
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Go to Fee Panel</li>
	 * 	<li>Check if the vendor is already in the Fee Panel, if so, delete them</li>
	 * 	<li>Click Ineligible vendors tab</li>
	 * 	<li>See if AppraiserTest is in the table</li>
	 * 	<li>Select the AppraiserTest</li>
	 * 	<li>Click Move to Fee Panel</li>
	 * 	<li>Verify dialog text</li>
	 * 	<li>Click Yes</li>
	 * 	<li>Click Appraisers tab</li>
	 * 	<li>Remove vendor from fee panel</li>
	 * 	<li>Add Vendor</li>
	 * 	<li>Click Ineligible vendors tab</li>
	 * 	<li>If vendor is already ineligible, make them eligible</li>
	 * 	<li>Select the AppraiserTest</li>
	 * 	<li>Click Move to Fee Panel</li>
	 * 	<li>Verify dialog text</li>
	 * 	<li>Click Yes</li>
	 * 	<li>Click Appraiser/Agent fee panel tab</li>
	 * 	<li>Mark vendor ineligible</li>
	 * 	<li>Click Ineligible vendors tab</li>
	 * 	<li>Select the AppraiserTest</li>
	 * 	<li>Click Move to Fee Panel</li>
	 * 	<li>Verify dialog text</li>
	 * 	<li>Click Yes</li>
	 * 	<li>Click Appraisers tab</li>
	 * 	<li>Verify AppraiserTest is in the table</li>
	 * 	<li>Select the AppraiserTest</li>
	 * 	<li>Click Contact Vendor</li>
	 * 	<li>Verify popup is displayed</li>
	 * 	<li>Click Close</li>
	 * 	<li>Create list of expected items in dropdown</li>
	 * 	<li>Verify dropdown values</li>
	 * 	<li>Remove vendor</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Fee Panel", "Secure - Add Vendor To Fee Panel", "Secure - Delete Vendor From Fee Panel"}, alwaysRun=true)
	public void addAndDeleteVendor() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Log in to Secure
		secure.login(driver, user, StoredVariables.getpassword().get());
		
		// Go to Fee Panel
		secure.goToFeePanel(driver);
		
		// Check if the vendor is already in the Fee Panel, if so, delete them
		// Click Ineligible vendors tab
		perform.click(driver, SFeePanel.ineligibleVendors_tab(driver));
		
		// Wait for Appraiser/Agent fee panel tab
		perform.waitForElementToBeClickable(driver, SFeePanel.appraiserFeePanel_tab(), "id");
		
		// See if AppraiserTest is in the table
		if (SFeePanel.feePanelTable_txt(driver).getText().contains("AppraiserTest"))
		{
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			// Wait for fee panel table to load
			perform.waitForText(driver, SFeePanel.feePanelTable_txt(driver), "AppraiserTest");
			
			// Select the AppraiserTest
			perform.clickInTable_Equals(driver, "AppraiserTest");
			
			// Wait for Move to fee panel button
			perform.waitForElementToBeClickable(driver, SFeePanel.moveToFeePanel_btn(), "cssSelector");
			
			// Click Move to Fee Panel
			perform.click(driver, SFeePanel.moveToFeePanel_btn(driver));
			
			// Wait for the Yes button
			perform.waitForElementToBeClickable(driver, SFeePanel.yes_btn(), "id");
			
			// Verify dialog text
			Assert.assertTrue(SFeePanel.dialog_txt(driver).getText().contains("Clear the selected vendors to recieve orders and move them to your fee panel?"), "The Move to fee panel dialog text is incorrect");
			
			// Click Yes
			perform.click(driver, SFeePanel.yes_btn(driver));
			
			// Wait for the overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			Thread.sleep(2000);
			
		} // end if appraiser is in ineligible list
		
		// Click Appraisers tab
		perform.click(driver, SFeePanel.appraiserFeePanel_tab(driver));
		
		// Wait for table
		perform.waitForElementToBeClickable(driver, SFeePanel.feePanelTable_txt(), "id");
		
		if (SFeePanel.feePanelTable_txt(driver).getText().contains("AppraiserTest"))
		{
			// Remove vendor from fee panel
			secure.removeVendorFromFeePanel(driver, "AppraiserTest");
			
		} // end if appraiser is in table, remove them
		
		// Add Vendor
		String phone = "";
		String env = StoredVariables.getusernameEnvironment().get();
		if (env.equals("QA")) {
			phone = "111";
		} else if (env.equals("Beta")) {
			phone = "222";
		} else if (env.equals("Live")) {
			phone = "333";
		} // end if/else
		secure.addVendorToFeePanel(driver, "phone", "501" + phone + "0999", "AppraiserTest");
		
		// Click Ineligible vendors tab
		perform.click(driver, SFeePanel.ineligibleVendors_tab(driver));
		
		// Wait for Appraiser/Agent fee panel tab
		perform.waitForElementToBeClickable(driver, SFeePanel.appraiserFeePanel_tab(), "id");
		
		// If vendor is already ineligible, make them eligible
		if (SFeePanel.feePanelTable_txt(driver).getText().contains("AppraiserTest"))
		{
			
			// Wait for fee panel table to load
			perform.waitForText(driver, SFeePanel.feePanelTable_txt(driver), "AppraiserTest");
			
			Thread.sleep(2000);
			
			// Select the AppraiserTest
			perform.clickInTable_Equals(driver, "AppraiserTest");
			
			// Wait for Move to fee panel button
			perform.waitForElementToBeClickable(driver, SFeePanel.moveToFeePanel_btn(), "cssSelector");
			
			// Click Move to Fee Panel
			perform.click(driver, SFeePanel.moveToFeePanel_btn(driver));
			
			// Wait for the Yes button
			perform.waitForElementToBeClickable(driver, SFeePanel.yes_btn(), "id");
			
			// Verify dialog text
			Assert.assertTrue(SFeePanel.dialog_txt(driver).getText().contains("Clear the selected vendors to recieve orders and move them to your fee panel?"), "The Move to fee panel dialog text is incorrect");
			
			// Click Yes
			perform.click(driver, SFeePanel.yes_btn(driver));
			
			// Wait for the overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			Thread.sleep(2000);
			
		} // end if vendor is already ineligible
		
		// Click Appraiser/Agent fee panel tab
		perform.click(driver, SFeePanel.appraiserFeePanel_tab(driver));
		
		// Wait for the Ineligible vendors tab
		perform.waitForElementToBeClickable(driver, SFeePanel.ineligibleVendors_tab(), "id");
		
		// Mark vendor ineligible
		secure.markVendorIneligible(driver, "AppraiserTest");

		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);

		// Click Ineligible vendors tab
		perform.click(driver, SFeePanel.ineligibleVendors_tab(driver));
		
		Thread.sleep(4000);
		
		// Wait for fee panel table to load
		perform.waitForText(driver, SFeePanel.feePanelTable_txt(driver), "AppraiserTest");
		
		Thread.sleep(10000);
		
		// Select the AppraiserTest
		perform.clickInTable_Equals(driver, "AppraiserTest");
		
		// Wait for Move to fee panel button
		perform.waitForElementToBeClickable(driver, SFeePanel.moveToFeePanel_btn(), "cssSelector");
		
		// Click Move to Fee Panel
		perform.click(driver, SFeePanel.moveToFeePanel_btn(driver));
		
		// Wait for the Yes button
		perform.waitForElementToBeClickable(driver, SFeePanel.yes_btn(), "id");
		
		// Verify dialog text
		Assert.assertTrue(SFeePanel.dialog_txt(driver).getText().contains("Clear the selected vendors to recieve orders and move them to your fee panel?"), "The Move to fee panel dialog text is incorrect");
		
		// Click Yes
		perform.click(driver, SFeePanel.yes_btn(driver));
		
		// Wait for the overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		Thread.sleep(2000);
		
		// Click Appraisers tab
		perform.click(driver, SFeePanel.appraiserFeePanel_tab(driver));
		
		// Wait for table
		perform.waitForElementToBeClickable(driver, SFeePanel.feePanelTable_txt(), "id");
		
		Thread.sleep(2000);
		
		// Wait for text
		perform.waitForText(driver, SFeePanel.feePanelTable_txt(driver), "AppraiserTest");
		
		// Verify AppraiserTest is in the table
		Assert.assertTrue(SFeePanel.feePanelTable_txt(driver).getText().contains("AppraiserTest"), "AppraiserTest was not added to the Fee Panel");
		
		// Select the AppraiserTest
		perform.clickInTable_Equals(driver, "AppraiserTest");
		
		// Wait for Move to fee panel button
		perform.waitForElementToBeClickable(driver, SFeePanel.contactVendor_btn(), "cssSelector");
		
		// Click Contact Vendor
		perform.click(driver, SFeePanel.contactVendor_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for the popup to load
		perform.waitForText(driver, SFeePanel.contactFeePanelHeader_txt(driver), "Contact fee panel");
		
		// Verify popup is displayed
		Assert.assertTrue(SFeePanel.contactFeePanelHeader_txt(driver).getText().contains("Contact fee panel"), "The title text for Contact fee panel is incorrect. On-screen = " + SFeePanel.contactFeePanelHeader_txt(driver).getText());
		
		// Click Close
		perform.click(driver, SFeePanel.closeContactFeePanel_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Create list of expected items in dropdown
		String[] expectedValues = {"All","Residential appraiser","Commercial appraiser","Agent/Broker","AMC/Appraisal Firm","Inspector"};
		
		// Verify dropdown values
		perform.verifyDropdownOptions(driver, SFeePanel.vendorType_dropdown(driver), expectedValues);

		// Remove vendor
		secure.removeVendorFromFeePanel(driver, "AppraiserTest");
	
		// Log test
		test.log(LogStatus.INFO, "fee panel", "Added vendor to Fee Panel");
		
	} // end addAndDeleteVendor

	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Go to Fee Panel</li>
	 * 	<li>Click Build Fee Panel</li>
	 * 	<li>Switch iFrame</li>
	 * 	<li>Verify text</li>
	 * 	<li>Click Cancel</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Fee Panel"}, alwaysRun=true)
	public void buildFeePanel() throws Exception {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Log in to Secure
		secure.login(driver, user, StoredVariables.getpassword().get());
		
		// Go to Fee Panel
		secure.goToFeePanel(driver);
		
		// Click Build Fee Panel
		perform.click(driver, SFeePanel.buildFeePanel_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Switch iFrame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "Build/BuildSelectSource.aspx", By.id(SFeePanel.buildCustomFeePanel_txt()));
		
		// Verify text
		Assert.assertTrue(SFeePanel.buildCustomFeePanel_txt(driver).getText().contains("Choose a source to build your candidate list. From there, you can review each vendor's profile and either add them to your panel or reject them."), "The text in the dialog box is incorrect");
		
		// Click Cancel
		perform.click(driver, SFeePanel.cancelCustomFeePanel_btn(driver));
		
		// Switch out of iFrame
		driver.switchTo().defaultContent();
		
		// Wait for the overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Log test
		test.log(LogStatus.INFO, "fee panel", "Verified the Build Fee Panel dialog");
		
	} // end buildFeePanel
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Go to Fee Panel</li>
	 * 	<li>Click Options</li>
	 * 	<li>Verify text</li>
	 * 	<li>Click Cancel</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Fee Panel"}, alwaysRun=true)
	public void options() throws Exception {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Log in to Secure
		secure.login(driver, user, StoredVariables.getpassword().get());
		
		// Go to Fee Panel
		secure.goToFeePanel(driver);
		
		// Click Options
		perform.click(driver, SFeePanel.options_btn(driver));
		
		// Wait for the Cancel button
		perform.waitForElementToBeClickable(driver, SFeePanel.cancelFeePanelOptions_btn(), "id");
		
		// Verify text
		Assert.assertTrue(SFeePanel.options_txt(driver).getText().contains("Configure the preferences you'd like applied to your Fee panel."), "The text in the dialog box is incorrect");
		
		Thread.sleep(2000);
		
		// Click Cancel
		perform.click(driver, SFeePanel.cancelFeePanelOptions_btn(driver));
		
		// Wait for the overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Log test
		test.log(LogStatus.INFO, "fee panel", "Verified the Options dialog");
		
	} // end options
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Go to Fee Panel</li>
	 * 	<li>Click Candidate list tab</li>
	 * 	<li>Switch iFrame</li>
	 * 	<li>Verify text</li>
	 * 	<li>Click Cancel</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Fee Panel"}, alwaysRun=true)
	public void candidateList() throws Exception {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Log in to Secure
		secure.login(driver, "Baseline3", StoredVariables.getpassword().get());
		
		// Go to Fee Panel
		secure.goToFeePanel(driver);
		
		// Click Candidate list tab
		perform.click(driver, SFeePanel.candidateList_tab(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for vendor profile button to be clickable
		perform.waitForElementToBeClickable(driver, driver.findElement(By.cssSelector("#tblCandidateList > tbody > tr > td:nth-child(5)")));
		
		// View the vendor profile of the first row
		secure.viewVendorProfileByCompanyName(driver, "Automation Test User");
		
		// Log test
		test.log(LogStatus.INFO, "fee panel", "Verified Candidate List dialog");
		
	} // end candidateList
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Go to Fee Panel</li>
	 * 	<li>Click AMC/Firm fee panel tab</li>
	 * 	<li>Verify url</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Fee Panel"}, alwaysRun=true)
	public void amcFeePanel() throws Exception {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Log in to Secure
		secure.login(driver, user, StoredVariables.getpassword().get());
		
		// Go to Fee Panel
		secure.goToFeePanel(driver);
		
		// Click AMC/Firm fee panel tab
		perform.click(driver, SFeePanel.amcFirmFeePanel_tab(driver));
		
		// Verify url
		Assert.assertTrue(driver.getCurrentUrl().contains("Admin/feepanel/FeePanel.aspx?amc=1"), "The url is incorrect");
		
		// Log test
		test.log(LogStatus.INFO, "fee panel", "Verified AMC/Firm fee panel opened");
		
	} // end amcFeePanel
	
//	@Test (retryAnalyzer = Retry.class, groups={})
//	public void removeVendorFromIneligibleVendors() throws InterruptedException, IOException {
//
//		ExtentTest test = ExtentTestManager.getTest();
//		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
//		
//		// Log in to Secure
//		secure.login(driver, user, StoredVariables.getpassword().get());
//		
//		// Go to Fee Panel
//		secure.goToFeePanel(driver);
//		
//		// Add Vendor
//		secure.addVendorToFeePanel(driver, "phone", "501" + perform.getEnvironmentPhoneNumber(driver) + "0999", "AppraiserTest");
//		
//		// Click Ineligible vendors tab
//		perform.click(driver, SFeePanel.ineligibleVendors_tab(driver));
//		
//		// Wait for busy to be hidden
//		perform.waitForBusyToBeHidden(driver);
//		
//		// Wait for Appraiser/Agent fee panel tab
//		perform.waitForElementToBeClickable(driver, SFeePanel.appraiserFeePanel_tab(), "id");
//		
//		// Check to see if vendor is already ineligible, if not, make them ineligible
//		String feePanelTableText = "";
//		try {
//			feePanelTableText = SFeePanel.feePanelTable_txt(driver).getText();
//		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
//			feePanelTableText = SFeePanel.feePanelTable_txt(driver).getText();
//		} // end catch
//		
//		if (!feePanelTableText.contains("AppraiserTest"))
//		{
//			// Click Appraiser/Agent fee panel tab
//			perform.click(driver, SFeePanel.appraiserFeePanel_tab(driver));
//			
//			// Wait for the Ineligible vendors tab
//			perform.waitForElementToBeClickable(driver, SFeePanel.ineligibleVendors_tab(), "id");
//			
//			// Make the vendor ineligible
//			secure.markVendorIneligible(driver, "AppraiserTest");
//		}
//		
//		// Remove the vendor
//		secure.removeIneligibleVendorFromFeePanel(driver, "AppraiserTest");
//		
//		// Log test
//		test.log(LogStatus.INFO, "fee panel", "Remove vendor from the Fee Panel");
//		
//	} // end removeVendorFromIneligibleVendors
	
} // end the Secure_Login class
