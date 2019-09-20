package baselineSecure;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Secure.SAppraisalQualityManagementSettings;
import pageObjects.Secure.SComplianceCertificate;
import pageObjects.Secure.SConfigureAutomaticSettings;
import pageObjects.Secure.SConfigureOrderForm;
import pageObjects.Secure.SConnectionSettings;
import pageObjects.Secure.SPreferences;
import pageObjects.Secure.SProductRequirements;
import pageObjects.Secure.SVMPXSites;
import pageObjects.Secure.SVendorSelectionSettings;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Baseline Secure - Preferences</h1>
 * 
 * <p>
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class Secure_Preferences extends TestSetup {
	
	/** The user. */
	private static String user = "Baseline1";
	
	/** The unit name. */
	private static String unitName = "";
	
	/** The unit number. */
	private static String unitNumber = "";
	
	/** The fnm. */
	private static String fnm = "";
	
	/** The fre. */
	private static String fre = "";
	
	/** The product description. */
	private static String productDescription = "";
	
	/** The default fee. */
	private static String defaultFee = "";
	
	/** The default fee notes. */
	private static String defaultFeeNotes = "";
	
	/**
	 * Verify the pages in Vendors Selection Settings load properly
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Go to Vendor Selection settings</li>
	 * 	<li>Click Residential Appraisers tab</li>
	 * 	<li>Verify text</li>
	 * 	<li>Click AMC/Firms tab</li>
	 * 	<li>Verify text</li>
	 * 	<li>Click Commercial Appraisers tab</li>
	 * 	<li>Verify text</li>
	 * 	<li>Click Agent/Brokers tab</li>
	 * 	<li>Verify text</li>
	 * 	<li>Click Inspectors tab</li>
	 * 	<li>Verify text</li>
	 * 	<li>Click Default vendors button</li>
	 * 	<li>Verify dialog text</li>
	 * 	<li>Verify Residential products dropdown options</li>
	 * 	<li>Verify Commercial products dropdown options</li>
	 * 	<li>Verify Broker Price Opinion dropdown options</li>
	 * 	<li>Verify Inspection products dropdown options</li>
	 * 	<li>Click Save</li>
	 * 	<li>Click Save</li>
	 * 	<li>Verify dialog text</li>
	 * 	<li>Click OK</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Vendor Selection Settings"}, alwaysRun=true)
	public void vendorSelectionSettings() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Login to Secure
		secure.login(driver, user, StoredVariables.getpassword().get());
		
		// Go to Vendor Selection settings
		secure.goToVendorSelectionSettings(driver);
		
		// Click Residential Appraisers tab
		perform.click(driver, SVendorSelectionSettings.residentialAppraisers_btn(driver));
		
		// Wait for page to load
		perform.waitForElementToBeClickable(driver, SPreferences.body_txt(), "id");
		
		// Verify text
		String text = SPreferences.body_txt(driver).getText();
		Assert.assertTrue(text.contains("Lender compliance"), "Text is missing from Vendor Selection Settings");
		Assert.assertTrue(text.contains("Residential appraisal selection"), "Text is missing from Vendor Selection Settings");
		Assert.assertTrue(text.contains("Ordering options"), "Text is missing from Vendor Selection Settings");
		Assert.assertTrue(text.contains("Intelligent Selection System (ISS)"), "Text is missing from Vendor Selection Settings");
		
		// Click AMC/Firms tab
		perform.click(driver, SVendorSelectionSettings.amcFirms_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Wait for page to load
		perform.waitForElementToBeClickable(driver, SPreferences.body_txt(), "id");
		
		// Verify text
		text = SPreferences.body_txt(driver).getText();
		Assert.assertTrue(text.contains("AMC/Firm selection"), "Text is missing from Vendor Selection Settings - " + text);
		Assert.assertTrue(text.contains("Ordering options"), "Text is missing from Vendor Selection Settings");
		Assert.assertTrue(text.contains("Intelligent Selection System (ISS)"), "Text is missing from Vendor Selection Settings");
		
		// Click Commercial Appraisers tab
		perform.click(driver, SVendorSelectionSettings.commercialAppraisers_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Wait for page to load
		perform.waitForElementToBeClickable(driver, SPreferences.body_txt(), "id");
		
		// Verify text
		text = SPreferences.body_txt(driver).getText();
		Assert.assertTrue(text.contains("Commercial appraisal selection"), "Text is missing from Vendor Selection Settings");
		Assert.assertTrue(text.contains("Ordering options"), "Text is missing from Vendor Selection Settings");
		Assert.assertTrue(text.contains("Intelligent Selection System (ISS)"), "Text is missing from Vendor Selection Settings");
		
		// Click Agent/Brokers tab
		perform.click(driver, SVendorSelectionSettings.agentBrokers_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Wait for page to load
		perform.waitForElementToBeClickable(driver, SPreferences.body_txt(), "id");
		
		// Verify text
		text = SPreferences.body_txt(driver).getText();
		Assert.assertTrue(text.contains("Broker Price Opinion selection"), "Text is missing from Vendor Selection Settings");
		Assert.assertTrue(text.contains("Ordering options"), "Text is missing from Vendor Selection Settings");
		Assert.assertTrue(text.contains("Intelligent Selection System (ISS)"), "Text is missing from Vendor Selection Settings");
		
		// Click Inspectors tab
		perform.click(driver, SVendorSelectionSettings.inspectors_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Wait for page to load
		perform.waitForElementToBeClickable(driver, SPreferences.body_txt(), "id");
		
		// Verify text
		text = SPreferences.body_txt(driver).getText();
		Assert.assertTrue(text.contains("Inspection selection"), "Text is missing from Vendor Selection Settings");
		Assert.assertTrue(text.contains("Ordering options"), "Text is missing from Vendor Selection Settings");
		Assert.assertTrue(text.contains("Intelligent Selection System (ISS)"), "Text is missing from Vendor Selection Settings");
		
		// Click Default vendors button
		perform.click(driver, SVendorSelectionSettings.defaultVendors_btn(driver));
		
		// Wait for Save button
		perform.waitForElementToBeClickable(driver, SVendorSelectionSettings.saveDefaultVendors_btn(), "id");
		
		// Verify dialog text
		Assert.assertTrue(SVendorSelectionSettings.defaultVendorsDialog_txt(driver).getText().contains("Choose the vendor you prefer for each product type. You may override the default vendor on a per order basis."), "Dialog text is incorrect");
		
		// Verify Residential products dropdown options
		String[] residentialProducts = {"Residential appraiser","Appraisal Management Company/Appraisal Firm"};
		perform.verifyDropdownOptions(driver, SVendorSelectionSettings.residentialProducts_dropdown(driver), residentialProducts);
		
		// Verify Commercial products dropdown options
		String[] commercialProducts = {"Commercial appraiser","Appraisal Management Company/Appraisal Firm"};
		perform.verifyDropdownOptions(driver, SVendorSelectionSettings.commercialProducts_dropdown(driver), commercialProducts);
		
		// Verify Broker Price Opinion dropdown options
		String[] brokerPriceOpinions = {"Residential appraiser","Agent/Broker","Appraisal Management Company/Appraisal Firm"};
		perform.verifyDropdownOptions(driver, SVendorSelectionSettings.brokerPriceOpinions_dropdown(driver), brokerPriceOpinions);
		
		// Verify Inspection products dropdown options
		String[] inspectionProducts = {"Residential appraiser","Inspector","Appraisal Management Company/Appraisal Firm"};
		perform.verifyDropdownOptions(driver, SVendorSelectionSettings.inspectionProducts_dropdown(driver), inspectionProducts);
		
		// Click Save
		perform.click(driver, SVendorSelectionSettings.saveDefaultVendors_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Click Save
		perform.click(driver, SVendorSelectionSettings.save_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Verify dialog text
		Assert.assertTrue(SVendorSelectionSettings.saveDialog_txt(driver).getText().contains("Your settings have been successfully saved."), "The save dialog box text is incorrect. On-screen data = " + SVendorSelectionSettings.saveDialog_txt(driver).getText());
		
		// Click OK
		perform.click(driver, SVendorSelectionSettings.ok_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Log test
		test.log(LogStatus.INFO, "preferences", "Verified Vendor Selection Settings");
		
	} // end vendorSelectionSettings
	
	/**
	 * Verify the Product Requirements page is loading properly
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Go to Product Requirements</li>
	 * 	<li>Click on Commercial Appraisal Report</li>
	 * 	<li>Click Edit</li>
	 * 	<li>Verify URL</li>
	 * 	<li>Verify text on the page</li>
	 * 	<li>Verify Statement of Engagement dropdown</li>
	 * 	<li>Click Cancel</li>
	 * 	<li>Click Document templates</li>
	 * 	<li>Switch iFrame</li>
	 * 	<li>Get the text of the Create document templates dialog</li>
	 * 	<li>Confirm the Commercial statement of engagement (Default) is populated in the drop down</li>
	 * 	<li>Confirm any other templates created are displayed underneath</li>
	 * 	<li>Confirm there is a 'create new' link to make a new template</li>
	 * 	<li>Confirm clicking on 'create new' opens the Enter template name window</li>
	 * 	<li>Confirm able to cancel, or enter a name and click OK</li>
	 * 	<li>Enter template name</li>
	 * 	<li>Click OK</li>
	 * 	<li>Confirm entering a name and clicking OK opens a blank editor to compose the template</li>
	 * 	<li>Confirm the drop downs populate with the corresponding fields for My Fields, Client Fields, Vendor Fields, Order Fields</li>
	 * 	<li>Confirm there is a Preview button and clicking it prompts the user to open/save the Preview pdf</li>
	 * 	<li>Confirm if the user clicks cancel there is a save prompt</li>
	 * 	<li>Click Cancel</li>
	 * 	<li>Click No</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Product Requirements"}, alwaysRun=true)
	public void productRequirements() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		if (StoredVariables.getmobile().get()==false) {
		
			// Login to Secure
			secure.login(driver, user, StoredVariables.getpassword().get());
			
			// Go to Product Requirements
			secure.goToProductRequirements(driver);
			
			// Click on Commercial Appraisal Report
			WebElement element = driver.findElement(By.id("ctl00_ctl00_Main_Main_grdProducts_it0_103_lblDescription"));
			Actions actions = new Actions(driver);
			actions.moveToElement(element);
			actions.perform();
			perform.clickInSpan_Contains(driver, "Commercial Appraisal Report");
			
			// Click Edit
			perform.click(driver, SProductRequirements.edit_btn(driver));
			
			// Wait for cancel button
			perform.waitForElementToBeClickable(driver, SProductRequirements.cancel_btn(), "cssSelector");
			
			// Verify URL
			perform.verifyURL(driver, "Admin/Preferences/EditProductOptions.aspx");
			
			// Verify text on the page
			String text = SProductRequirements.editProductPage_txt(driver).getText();
			String[] expected = {"Comments / Special Instructions", "Required Forms", "Designations", "Order Options", "Document Templates", "Statement of Engagement"};
			perform.verifyTextContains(driver, text, expected);
			
			// Verify Statement of Engagement dropdown
			List<String> availableOptions = perform.getAllDropdownOptions(driver, SProductRequirements.statementOfEngagement_dropdown(driver));
			Assert.assertTrue(availableOptions.contains("(None Selected)"), "The options in the Statement Of Engagement dropdown are incorrect");
			Assert.assertTrue(availableOptions.contains("Commercial statement of engagement (Default)"), "The options in the Statement Of Engagement dropdown are incorrect");
			Assert.assertTrue(availableOptions.contains("Commercial request for proposal (Default)"), "The options in the Statement Of Engagement dropdown are incorrect");
			
			// Click Cancel
			perform.click(driver, SProductRequirements.cancel_btn(driver));
			
			// Wait for busy to be hidden
			perform.waitForBusyToBeHidden(driver);
			
			// Click Document templates
			perform.click(driver, SProductRequirements.documentTemplates_btn(driver));
			
			// Wait for busy to be hidden
			perform.waitForBusyToBeHidden(driver);
			
			// Switch iFrame
			perform.waitForiFrameSrcAndSwitchToIt(driver, "/Admin/Preferences/TemplateBuilder.aspx", By.id(SProductRequirements.cancelDocumentTemplates_btn()));
			
			// Get the text of the Create document templates dialog
			text = SProductRequirements.createDocumentTemplates_txt(driver).getText();
			Assert.assertTrue(text.contains("Create document templates"), "Create document templates dialog is incorrect");
			
			// Confirm the Commercial statement of engagement (Default) is populated in the drop down
			Select select = new Select(SProductRequirements.selectTemplate_dropdown(driver));
			WebElement option = select.getFirstSelectedOption();
			String defaultItem = option.getText();
			Assert.assertTrue(defaultItem.equals("Commercial statement of engagement (Default)"), "Commercial statement of engagement (Default) should be selected in the dropdown");
			
			// Confirm any other templates created are displayed underneath 
			availableOptions = perform.getAllDropdownOptions(driver, SProductRequirements.selectTemplate_dropdown(driver));
			Assert.assertTrue(availableOptions.contains("Commercial statement of engagement (Default)"), "The options in the Select template dropdown are incorrect");
			Assert.assertTrue(availableOptions.contains("Commercial request for proposal (Default)"), "The options in the Select template dropdown are incorrect");
			
			// Confirm there is a 'create new' link to make a new template 
			Assert.assertTrue(SProductRequirements.createNew_lnk(driver).isDisplayed(), "The create new link is not displayed");
			
			// Confirm clicking on 'create new' opens the Enter template name window 
			perform.click(driver, SProductRequirements.createNew_lnk(driver));
			
			// Wait for the Cancel button
			perform.waitForElementToBeClickable(driver, SProductRequirements.cancelEnterTemplateName_btn(driver));
			
			// Confirm able to cancel, or enter a name and click OK 
			// Enter template name
			perform.type(driver, SProductRequirements.templateName_txtbx(driver), "Test");
			
			// Click OK
			perform.click(driver, SProductRequirements.okEnterTemplateName_btn(driver));
			
			// Confirm entering a name and clicking OK opens a blank editor to compose the template
			text = SProductRequirements.editor_txtbx(driver).getText().replace("Your browser does not support inline frames or is currently configured not to display inline frames.", "");
			Assert.assertTrue(text.equals(""), "The editor should be empty but it is not. Editor = " + text);
			
			// Confirm the drop downs populate with the corresponding fields for My Fields, Client Fields, Vendor Fields, Order Fields 
			String options = driver.findElement(By.cssSelector("#ctl00_Main_templateEditor_radEditorTop > div > ul:nth-child(4)")).getText();
			expected = new String[] {"My Fields", "Client Fields", "Vendor Fields", "Order Fields"};
			perform.verifyTextContains(driver, options, expected);
			
			// Confirm there is a Preview button and clicking it prompts the user to open/save the Preview pdf 
			Assert.assertTrue(SProductRequirements.previewDocumentTemplates_btn(driver).isDisplayed(), "There should be a Preview button");
			
			// Confirm if the user clicks cancel there is a save prompt 
			// Click Cancel
			perform.click(driver, SProductRequirements.cancelDocumentTemplates_btn(driver));
			
			// Wait for No
			perform.waitForElementToBeClickable(driver, SProductRequirements.noSaveChanges_btn(driver));
			
			// Click No
			perform.click(driver, SProductRequirements.noSaveChanges_btn(driver));
			
			// Switch out of iFrames
			driver.switchTo().defaultContent();
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			// Log test
			test.log(LogStatus.INFO, "preferences", "Verify the Edit page and Document templates of Product Requirements");
			
		} else {
			
			// Log test
			test.log(LogStatus.INFO, "preferences", "Could not test on mobile due to scroll issue");
			
		} // end if/else
		
	} // end productRequirements
	
	/**
	 * Verify the Connection Settings page is loading properly
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Go to Connection Settings</li>
	 * 	<li>Remove test UCDP Business Unit if it exists</li>
	 * 	<li>Hover over the text area</li>
	 * 	<li>Click Remove</li>
	 * 	<li>Verify dialog text</li>
	 * 	<li>Click Yes</li>
	 * 	<li>Get text</li>
	 * 	<li>Remove test FHA Business Unit if it exists</li>
	 * 	<li>Hover over the text area</li>
	 * 	<li>Click Remove</li>
	 * 	<li>Verify dialog text</li>
	 * 	<li>Click Yes</li>
	 * 	<li>Get text</li>
	 * 	<li>Save settings</li>
	 * 	<li>Set user id and password</li>
	 * 	<li>Enter UCDP Direct Integration User ID</li>
	 * 	<li>Enter UCDP Password</li>
	 * 	<li>Enter FHA Direct Integration User ID</li>
	 * 	<li>Enter FHA Password</li>
	 * 	<li>Save changes</li>
	 * 	<li>Go to Orders</li>
	 * 	<li>Go to Connection Settings</li>
	 * 	<li>Get value of User ID</li>
	 * 	<li>Verify the id was saved</li>
	 * 	<li>Click Add</li>
	 * 	<li>Click UCDP Business Unit</li>
	 * 	<li>Verify text</li>
	 * 	<li>Enter Business Unit Name</li>
	 * 	<li>Enter Business Unit Number</li>
	 * 	<li>Enter FNM ID</li>
	 * 	<li>Enter FRE Number</li>
	 * 	<li>Click OK</li>
	 * 	<li>Get UCDP Business Units text</li>
	 * 	<li>Verify the newly added business is displayed</li>
	 * 	<li>Save the changes</li>
	 * 	<li>Go to Orders</li>
	 * 	<li>Go to Connection Settings</li>
	 * 	<li>Get UCDP Business Units text</li>
	 * 	<li>Verify the newly added business was saved</li>
	 * 	<li>Hover over the text area</li>
	 * 	<li>Click Remove</li>
	 * 	<li>Verify dialog text</li>
	 * 	<li>Click Yes</li>
	 * 	<li>Verify unit was removed</li>
	 * 	<li>Save settings</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Connection Settings"}, alwaysRun=true)
	public void connectionSettings() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Login to Secure
		secure.login(driver, user, StoredVariables.getpassword().get());
		
		// Go to Connection Settings
		secure.goToConnectionSettings(driver);
		
		boolean changed = false;
		
		// Remove test UCDP Business Unit if it exists
		String ucdpBusinessUnits = SConnectionSettings.ucdpBusinessUnits_txt(driver).getText();
		while (ucdpBusinessUnits.toLowerCase().contains("test"))
		{
			
			if (StoredVariables.getmobile().get()==false) {
				// Hover over the text area
				Actions action = new Actions(driver);
				WebElement we = SConnectionSettings.removeBusinessUnit_btn(driver);
				action.moveToElement(we).build().perform();
			} else {
				// Click the Business Unit
				perform.click(driver, SConnectionSettings.ucdpBusinessUnit_row1(driver));
			} // end if/else
			
			// Click Remove
			perform.click(driver, SConnectionSettings.removeBusinessUnit_btn(driver));
			
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			// Wait for Yes button
			perform.waitForElementToBeClickable(driver, SConnectionSettings.yesDelete_btn(), "cssSelector");
			
			// Verify dialog text
			Assert.assertTrue(SConnectionSettings.confirmDelete_txt(driver).getText().contains("Are you sure you want to remove the selected Business Unit?"), "The delete dialog is incorrect");
			
			// Click Yes
			perform.click(driver, SConnectionSettings.yesDelete_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			// Get text
			ucdpBusinessUnits = SConnectionSettings.ucdpBusinessUnits_txt(driver).getText();
			
			changed = true;
			
		} // end while
		
		// Remove test FHA Business Unit if it exists
		String fhaBusinessUnits = SConnectionSettings.fhaBusinessUnits_txt(driver).getText();
		while (fhaBusinessUnits.toLowerCase().contains("mercury"))
		{
			
			if (StoredVariables.getmobile().get()==false) {
				// Hover over the text area
				Actions action = new Actions(driver);
				WebElement we = SConnectionSettings.removeBusinessUnit_btn(driver);
				action.moveToElement(we).build().perform();
			} else {
				// Click the Business Unit
				perform.click(driver, SConnectionSettings.ucdpBusinessUnit_row1(driver));
			} // end if/else
			
			// Click Remove
			perform.click(driver, SConnectionSettings.removeBusinessUnit_btn(driver));
			
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			// Wait for Yes button
			perform.waitForElementToBeClickable(driver, SConnectionSettings.yesDeleteFHA_btn(), "cssSelector");
			
			// Verify dialog text
			Assert.assertTrue(SConnectionSettings.confirmDeleteFHA_txt(driver).getText().contains("Are you sure you want to remove the selected Business Unit?"), "The delete dialog is incorrect");
			
			// Click Yes
			perform.click(driver, SConnectionSettings.yesDeleteFHA_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			// Get text
			fhaBusinessUnits = SConnectionSettings.fhaBusinessUnits_txt(driver).getText();
			
			changed = true;
			
		} // end while
		
		// Save settings
		if (changed==true) {
			secure.saveConnectionSettings(driver);	
		} // end if
		
		// Set user id and password
		String id = "testuserid" + perform.randomNumbers(driver, 5);
		String password = "testpassword";
		
		// Enter UCDP Direct Integration User ID
		SConnectionSettings.directIntegrationUserID_txtbx(driver).clear();
		perform.type(driver, SConnectionSettings.directIntegrationUserID_txtbx(driver), id);
		
		// Enter UCDP Password
		SConnectionSettings.directIntegrationPassword_txtbx(driver).clear();
		perform.type(driver, SConnectionSettings.directIntegrationPassword_txtbx(driver), password);
		
		// Enter FHA Direct Integration User ID
		SConnectionSettings.directIntegrationUserIDFHA_txtbx(driver).clear();
		perform.type(driver, SConnectionSettings.directIntegrationUserIDFHA_txtbx(driver), "eadvi02_di");
		
		// Enter FHA Password
		SConnectionSettings.directIntegrationPasswordFHA_txtbx(driver).clear();
		perform.type(driver, SConnectionSettings.directIntegrationPasswordFHA_txtbx(driver), "Eivke5se@2");
		
		// Save changes
		secure.saveConnectionSettings(driver);
		
		// Go to Orders
		secure.goToOrders(driver);
		
		// Go to Connection Settings
		secure.goToConnectionSettings(driver);
		
		// Get value of User ID
		String idText = SConnectionSettings.directIntegrationUserID_txtbx(driver).getAttribute("value");
		
		// Verify the id was saved
		Assert.assertTrue(idText.equals(id), "The id was not saved");
		
		// Click Add
		perform.click(driver, SConnectionSettings.add_btn(driver));
		
		// Click UCDP Business Unit
		perform.clickInDiv_Contains(driver, "UCDP Business Unit");
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SConnectionSettings.okBusinessUnit_btn(), "cssSelector");
		
		// Verify text
		Assert.assertTrue(SConnectionSettings.dialogAddBusinessUnit_txt(driver).getText().contains("Use the fields below to enter your UCDP Business Unit information for Fannie Mae and/or Freddie Mac."), "The dialog text is incorrect");
		
		// Enter Business Unit Name
		unitName = "Test Name" + perform.randomNumbers(driver, 4);
		perform.type(driver, SConnectionSettings.businessUnitName_txtbx(driver), unitName);
		
		// Enter Business Unit Number
		unitNumber = perform.randomNumbers(driver, 8);
		perform.type(driver, SConnectionSettings.businessUnitNumber_txtbx(driver), unitNumber);
		
		// Enter FNM ID
		fnm = perform.randomNumbers(driver, 9);
		perform.type(driver, SConnectionSettings.fnmID_txtbx(driver), fnm);
		
		// Enter FRE Number
		fre = perform.randomNumbers(driver, 9);
		perform.type(driver, SConnectionSettings.freNumber_txtbx(driver), fre);
				
		// Click OK
		perform.click(driver, SConnectionSettings.okBusinessUnit_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Get UCDP Business Units text
		ucdpBusinessUnits = SConnectionSettings.ucdpBusinessUnits_txt(driver).getText();
		
		// Verify the newly added business is displayed
		Assert.assertTrue(ucdpBusinessUnits.contains(unitName), "The newly added business unit is not displayed properly");
		Assert.assertTrue(ucdpBusinessUnits.contains(unitNumber), "The newly added business unit is not displayed properly");
		Assert.assertTrue(ucdpBusinessUnits.contains(fnm), "The newly added business unit is not displayed properly");
		Assert.assertTrue(ucdpBusinessUnits.contains(fre), "The newly added business unit is not displayed properly");
		
		// Save the changes
		secure.saveConnectionSettings(driver);
		
		// Go to Orders
		secure.goToOrders(driver);
		
		// Go to Connection Settings
		secure.goToConnectionSettings(driver);
		
		// Get UCDP Business Units text
		ucdpBusinessUnits = SConnectionSettings.ucdpBusinessUnits_txt(driver).getText();
		
		// Verify the newly added business was saved
		Assert.assertTrue(ucdpBusinessUnits.contains(unitName), "The newly added business unit is not displayed properly");
		Assert.assertTrue(ucdpBusinessUnits.contains(unitNumber), "The newly added business unit is not displayed properly");
		Assert.assertTrue(ucdpBusinessUnits.contains(fnm), "The newly added business unit is not displayed properly");
		Assert.assertTrue(ucdpBusinessUnits.contains(fre), "The newly added business unit is not displayed properly");
		
		if (StoredVariables.getmobile().get()==false) {
			// Hover over the text area
			Actions action = new Actions(driver);
			WebElement we = SConnectionSettings.removeBusinessUnit_btn(driver);
			action.moveToElement(we).build().perform();
		} else {
			// Click the Business Unit
			perform.click(driver, SConnectionSettings.ucdpBusinessUnit_row1(driver));
		} // end if/else
		
		// Click Remove
		perform.click(driver, SConnectionSettings.removeBusinessUnit_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for Yes button
		perform.waitForElementToBeClickable(driver, SConnectionSettings.yesDelete_btn(), "cssSelector");
		
		// Verify dialog text
		Assert.assertTrue(SConnectionSettings.confirmDelete_txt(driver).getText().contains("Are you sure you want to remove the selected Business Unit?"), "The delete dialog is incorrect");
		
		// Click Yes
		perform.click(driver, SConnectionSettings.yesDelete_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Verify unit was removed
		ucdpBusinessUnits = SConnectionSettings.ucdpBusinessUnits_txt(driver).getText();
		Assert.assertTrue(!ucdpBusinessUnits.contains(unitName), "The newly added business unit was not removed");
		Assert.assertTrue(!ucdpBusinessUnits.contains(unitNumber), "The newly added business unit was not removed");
		Assert.assertTrue(!ucdpBusinessUnits.contains(fnm), "The newly added business unit was not removed");
		Assert.assertTrue(!ucdpBusinessUnits.contains(fre), "The newly added business unit was not removed");
		
		// Save settings
		secure.saveConnectionSettings(driver);
		
		// Log test
		test.log(LogStatus.INFO, "preferences", "Remove Business Units in Connection Settings");
		
	} // end connectionSettings
	
	/**
	 * Verify Preferences &gt; AAppraisal Quality Management Settings page loads correctly
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Go to Appraisal Quality Management Settings</li>
	 * 	<li>Get text</li>
	 * 	<li>Verify page text</li>
	 * 	<li>Check the Enable RealView Bridge checkbox</li>
	 * 	<li>Verify the dialog is displayed properly</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Appraisal Quality Management Settings"}, alwaysRun=true)
	public void appraisalQualityManagementSettings() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Login to Secure
		secure.login(driver, user, StoredVariables.getpassword().get());
		
		// Go to Appraisal Quality Management Settings
		secure.goToAppraisalQualityManagementSettings(driver);
		
		// Get text
		String text = SAppraisalQualityManagementSettings.page_txt(driver).getText();
		
		// Verify page text
		Assert.assertTrue(text.contains("Default AQM modules"), "The page is missing text");
		Assert.assertTrue(text.contains("QC comments"), "The page is missing text");
		Assert.assertTrue(text.contains("Default messaging"), "The page is missing text");
		Assert.assertTrue(text.contains("Custom logo"), "The page is missing text");
		Assert.assertTrue(text.contains("Preferences"), "The page is missing text");
		
		// Check the Enable RealView Bridge checkbox
		perform.checkCheckbox(driver, SAppraisalQualityManagementSettings.enableRealViewBridge_chkbx(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, SAppraisalQualityManagementSettings.okEnableRealViewBridge_btn(driver));
		
		// Verify the dialog is displayed properly
		String screenText = SAppraisalQualityManagementSettings.enableRealViewBridgeDialog_txt(driver).getText();
		String[] expected = {"Thank you for your interest in using", "Your account needs to be configured before ordering this product.", "Please contact your sales representative to get started.", "RealView Bridge"};
		perform.verifyTextContains(driver, screenText, expected);
		
		// Log test
		test.log(LogStatus.INFO, "preferences", "Verified the Appraisal Quality Management Settings page loaded properly and a dialog is displayed informing the user to contact a sales representative to get started with RealView Bridge");
		
	} // end appraisalQualityManagementSettings
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Go to VMP XSites</li>
	 * 	<li>If product currently exists, delete it</li>
	 * 	<li>Click on product</li>
	 * 	<li>Click on Delete Product</li>
	 * 	<li>Verify dialog text</li>
	 * 	<li>Click Yes</li>
	 * 	<li>Save settings</li>
	 * 	<li>Get Product Information table text</li>
	 * 	<li>Click New Product</li>
	 * 	<li>Enter Product Description</li>
	 * 	<li>Enter Default Fee</li>
	 * 	<li>Enter Default Fee Notes</li>
	 * 	<li>Click OK</li>
	 * 	<li>Get Product Information text</li>
	 * 	<li>Verify New Product exists in the table</li>
	 * 	<li>Save settings</li>
	 * 	<li>Click on product</li>
	 * 	<li>Click Edit Product</li>
	 * 	<li>Get Product Info text</li>
	 * 	<li>Verify existing info</li>
	 * 	<li>Clear the fields and enter new info</li>
	 * 	<li>Set new info</li>
	 * 	<li>Enter new info</li>
	 * 	<li>Click OK</li>
	 * 	<li>wait for overlay to be hidden</li>
	 * 	<li>Get Product Information table text</li>
	 * 	<li>Verify the product was edited</li>
	 * 	<li>Save settings</li>
	 * 	<li>Click on product</li>
	 * 	<li>Get Product Info text</li>
	 * 	<li>Verify existing info</li>
	 * 	<li>Clear the fields and enter new info</li>
	 * 	<li>Enter new info</li>
	 * 	<li>Click OK</li>
	 * 	<li>wait for overlay to be hidden</li>
	 * 	<li>Get Product Information table text</li>
	 * 	<li>Verify the product was edited</li>
	 * 	<li>Save settings</li>
	 * 	<li>Click on product</li>
	 * 	<li>Click on Delete Product</li>
	 * 	<li>Verify dialog text</li>
	 * 	<li>Click Yes</li>
	 * 	<li>Save settings</li>
	 * 	<li>Get Product Information table text</li>
	 * 	<li>Verify the product was deleted</li>
	 * 	<li>Click Add Fees</li>
	 * 	<li>Enter Complex Order Amount</li>
	 * 	<li>Enter Rush Order Amount</li>
	 * 	<li>Click Save</li>
	 * 	<li>Click Add Fees</li>
	 * 	<li>Verify Fees were added</li>
	 * 	<li>Click Save</li>
	 * 	<li>Click Configure Order Form</li>
	 * 	<li>Click Product List</li>
	 * 	<li>Verify url</li>
	 * 	<li>Click Configure Order Form</li>
	 * 	<li>Verify url</li>
	 * 	<li>Get page text</li>
	 * 	<li>Verify text on screen</li>
	 * 	<li>Click Configure Automatic Settings</li>
	 * 	<li>Verify url</li>
	 * 	<li>Get page text</li>
	 * 	<li>Verify text on screen</li>
	 * 	<li>Click Configure Status Mapping</li>
	 * 	<li>Verify url</li>
	 * 	<li>Get page text</li>
	 * 	<li>Verify text on screen</li>
	 * 	<li>Click Compliance Certificate</li>
	 * 	<li>Verify url</li>
	 * 	<li>Get page text</li>
	 * 	<li>Verify text on screen</li>
	 * 	<li>Click XSite Wizard link</li>
	 * 	<li>Switch window</li>
	 * 	<li>Verify url</li>
	 * 	<li>Close the window</li>
	 * 	<li>Click Business Management link</li>
	 * 	<li>Switch window</li>
	 * 	<li>Verify url</li>
	 * 	<li>Close the window</li>
	 * 	<li>Click Contacts link</li>
	 * 	<li>Switch window</li>
	 * 	<li>Verify url</li>
	 * 	<li>Close the window</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - VMP XSite Settings"}, alwaysRun=true)
	public void vmpXSites() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		if (StoredVariables.getmobile().get()==false) {
		
			// Login to Secure
			secure.login(driver, user, StoredVariables.getpassword().get());
			
			// Go to VMP XSites
			secure.goToVMPXSites(driver);
			
			// If product currently exists, delete it
			String text = SVMPXSites.productInformation_txt(driver).getText();
			while (text.contains("Test Product"))
			{
				
				// Click on product
				perform.clickInTable_Contains(driver, "Test Product");
				
				// Click on Delete Product
				perform.click(driver, SVMPXSites.deleteProduct_btn(driver));
				
				// Wait for overlay to be visible
				perform.waitForOverlayToBeVisible(driver);
				
				// Wait for Yes button
				perform.waitForElementToBeClickable(driver, SVMPXSites.yesDeleteProduct_btn(), "cssSelector");
				
				// Verify dialog text
				Assert.assertTrue(SVMPXSites.deleteDialog_txt(driver).getText().contains("Deleting this product will also remove the product from any client specific fee tables."), "The delete dialog box is incorrect");
				
				// Click Yes
				perform.click(driver, SVMPXSites.yesDeleteProduct_btn(driver));
				
				// Wait for overlay to be hidden
				perform.waitForOverlayToBeHidden(driver);
				
				// Save settings
				secure.saveVMPXSiteSettings(driver);
				
				// Get Product Information table text
				text = SVMPXSites.productInformation_txt(driver).getText();
				
			} // end while
			
			// Click New Product
			perform.click(driver, SVMPXSites.newProduct_btn(driver));
			
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			// Wait for OK button
			perform.waitForElementToBeClickable(driver, SVMPXSites.okProduct_btn(), "cssSelector");
			
			// Enter Product Description
			productDescription = "Test Product Description";
			perform.type(driver, SVMPXSites.productDescription_txtbx(driver), productDescription);
			
			// Enter Default Fee
			defaultFee = "300";
			perform.type(driver, SVMPXSites.defaultFee_txtbx(driver), defaultFee);
			
			// Enter Default Fee Notes
			defaultFeeNotes = "These are the default fee notes";
			perform.type(driver, SVMPXSites.defaultFeeNotes_txtbx(driver), defaultFeeNotes);
			
			// Click OK
			perform.click(driver, SVMPXSites.okProduct_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			// Get Product Information text
			text = SVMPXSites.productInformation_txt(driver).getText();
			
			// Verify New Product exists in the table
			Assert.assertTrue(text.contains(productDescription), "The new product was not added");
			
			// Save settings
			secure.saveVMPXSiteSettings(driver);
			
			// Click on product
			perform.clickInTable_Contains(driver, "Test Product");
			
			// Click Edit Product
			perform.click(driver, SVMPXSites.editProduct_btn(driver));
			
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			// Wait for ok button
			perform.waitForElementToBeClickable(driver, SVMPXSites.okProduct_btn(), "cssSelector");
			
			// Get Product Info text
			String pd = SVMPXSites.productDescription_txtbx(driver).getAttribute("value");
			String df = SVMPXSites.defaultFee_txtbx(driver).getAttribute("value");
			String dfn = SVMPXSites.defaultFeeNotes_txtbx(driver).getAttribute("value");
			
			// Verify existing info
			Assert.assertTrue(pd.equals(productDescription), "The product description is incorrect");
			Assert.assertTrue(df.equals(defaultFee), "The default is incorrect");
			Assert.assertTrue(dfn.equals(defaultFeeNotes), "The default fee notes is incorrect");
			
			// Clear the fields and enter new info
			SVMPXSites.productDescription_txtbx(driver).clear();
			SVMPXSites.defaultFee_txtbx(driver).clear();
			SVMPXSites.defaultFeeNotes_txtbx(driver).clear();
			
			// Set new info
			String newProductDescription = "Test Product Edited";
			String newDefaultFee = "450";
			String newDefaultFeeNotes = "These are edited default fee notes";
			
			// Enter new info
			perform.type(driver, SVMPXSites.productDescription_txtbx(driver), newProductDescription);
			perform.type(driver, SVMPXSites.defaultFee_txtbx(driver), newDefaultFee);
			perform.type(driver, SVMPXSites.defaultFeeNotes_txtbx(driver), newDefaultFeeNotes);
			
			// Click OK
			perform.click(driver, SVMPXSites.okProduct_btn(driver));
			
			// wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			// Get Product Information table text
			text = SVMPXSites.productInformation_txt(driver).getText();
			
			// Verify the product was edited
			Assert.assertTrue(text.contains("Test Product Edited"), "The product was not edited");
			
			// Save settings
			secure.saveVMPXSiteSettings(driver);
			
			// Click on product
			perform.doubleClickInTable(driver, "Test Product Edited");
			
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			// Wait for ok button
			perform.waitForElementToBeClickable(driver, SVMPXSites.okProduct_btn(), "cssSelector");
			
			// Get Product Info text
			pd = SVMPXSites.productDescription_txtbx(driver).getAttribute("value");
			df = SVMPXSites.defaultFee_txtbx(driver).getAttribute("value");
			dfn = SVMPXSites.defaultFeeNotes_txtbx(driver).getAttribute("value");
			
			// Verify existing info
			Assert.assertTrue(!pd.equals(productDescription), "The product description is incorrect");
			Assert.assertTrue(!df.equals(defaultFee), "The default is incorrect");
			Assert.assertTrue(!dfn.equals(defaultFeeNotes), "The default fee notes is incorrect");
			
			// Clear the fields and enter new info
			SVMPXSites.productDescription_txtbx(driver).clear();
			SVMPXSites.defaultFee_txtbx(driver).clear();
			SVMPXSites.defaultFeeNotes_txtbx(driver).clear();
			
			// Enter new info
			perform.type(driver, SVMPXSites.productDescription_txtbx(driver), productDescription);
			perform.type(driver, SVMPXSites.defaultFee_txtbx(driver), defaultFee);
			perform.type(driver, SVMPXSites.defaultFeeNotes_txtbx(driver), defaultFeeNotes);
			
			// Click OK
			perform.click(driver, SVMPXSites.okProduct_btn(driver));
			
			// wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			// Get Product Information table text
			text = SVMPXSites.productInformation_txt(driver).getText();
			
			// Verify the product was edited
			Assert.assertTrue(!text.contains("Test Product Edited"), "The product was not edited");
			
			// Save settings
			secure.saveVMPXSiteSettings(driver);
			
			// Click on product
			perform.clickInTable_Contains(driver, "Test Product");
			
			// Click on Delete Product
			perform.click(driver, SVMPXSites.deleteProduct_btn(driver));
			
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			// Wait for Yes button
			perform.waitForElementToBeClickable(driver, SVMPXSites.yesDeleteProduct_btn(), "cssSelector");
			
			// Verify dialog text
			Assert.assertTrue(SVMPXSites.deleteDialog_txt(driver).getText().contains("Deleting this product will also remove the product from any client specific fee tables."), "The delete dialog box is incorrect");
			
			// Click Yes
			perform.click(driver, SVMPXSites.yesDeleteProduct_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			// Save settings
			secure.saveVMPXSiteSettings(driver);
			
			// Get Product Information table text
			text = SVMPXSites.productInformation_txt(driver).getText();
			
			// Verify the product was deleted
			Assert.assertTrue(!text.contains("Test Product"), "The product was not deleted");
			
			// Click Add Fees
			perform.click(driver, SVMPXSites.addFees_btn(driver));
			
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			// Wait for Save button
			perform.waitForElementToBeClickable(driver, SVMPXSites.saveAdditionalFees_btn(), "id");
			
			// Enter Complex Order Amount
			String complexOrder = perform.randomNumbers(driver, 3);
			SVMPXSites.complexOrder_txtbx(driver).clear();
			perform.type(driver, SVMPXSites.complexOrder_txtbx(driver), complexOrder);
			
			// Enter Rush Order Amount
			String rushOrder = perform.randomNumbers(driver, 3);
			SVMPXSites.rushOrder_txtbx(driver).clear();
			perform.type(driver, SVMPXSites.rushOrder_txtbx(driver), rushOrder);
			
			// Click Save
			perform.click(driver, SVMPXSites.saveAdditionalFees_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
	
			// Click Add Fees
			perform.click(driver, SVMPXSites.addFees_btn(driver));
			
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			// Wait for Save button
			perform.waitForElementToBeClickable(driver, SVMPXSites.saveAdditionalFees_btn(), "id");
			
			// Verify Fees were added
			Assert.assertTrue(SVMPXSites.complexOrder_txtbx(driver).getAttribute("value").equals(complexOrder), "The new fee was not added");
			Assert.assertTrue(SVMPXSites.rushOrder_txtbx(driver).getAttribute("value").equals(rushOrder), "The new fee was not added");
			
			// Click Save
			perform.click(driver, SVMPXSites.saveAdditionalFees_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			// Click Configure Order Form
			perform.click(driver, SVMPXSites.configureOrderForm_lnk(driver));
			
			// Wait for page text
			perform.waitForElementToBeClickable(driver, SConfigureOrderForm.page_txt(), "id");
			
			// Click Product List
			perform.click(driver, SVMPXSites.productList_lnk(driver));
			
			// Wait for product information table
			perform.waitForElementToBeClickable(driver, SVMPXSites.productInformation_txt(), "id");
			
			// Verify url
			perform.verifyURL(driver, "Admin/Preferences/VMPProducts.aspx");
			
			// Click Configure Order Form
			perform.click(driver, SVMPXSites.configureOrderForm_lnk(driver));
			
			// Wait for page text
			perform.waitForElementToBeClickable(driver, SConfigureOrderForm.page_txt(), "id");
			
			// Verify url
			perform.verifyURL(driver, "Admin/Preferences/VMPOrderForm.aspx");
			
			// Get page text
			text = SConfigureOrderForm.page_txt(driver).getText();
			
			// Verify text on screen
			Assert.assertTrue(text.contains("Configure Order Form"), "Text on the page is incorrect");
			Assert.assertTrue(text.contains("Acceptable Payment Methods"), "Text on the page is incorrect");
			
			// Click Configure Automatic Settings
			perform.click(driver, SVMPXSites.configureAutomaticSettings_lnk(driver));
			
			// Wait for page text
			perform.waitForElementToBeClickable(driver, SConfigureAutomaticSettings.page_txt(), "id");
			
			// Verify url
			perform.verifyURL(driver, "Admin/Preferences/VMPAutomaticSettings.aspx");
			
			// Get page text
			text = SConfigureAutomaticSettings.page_txt(driver).getText();
			
			// Verify text on screen
			Assert.assertTrue(text.contains("Settings"), "Text on the page is incorrect");
			Assert.assertTrue(text.contains("Automatic Assignment Settings"), "Text on the page is incorrect");
			Assert.assertTrue(text.contains("AMC/Firm Assignment Options"), "Text on the page is incorrect");
			Assert.assertTrue(text.contains("Automatic Invoice Settings"), "Text on the page is incorrect");
			Assert.assertTrue(text.contains("Automatic Order Settings"), "Text on the page is incorrect");
			
			// Click Configure Status Mapping
			perform.click(driver, SVMPXSites.configureStatusMapping_lnk(driver));
			
			// Wait for page text
			perform.waitForElementToBeClickable(driver, SConfigureAutomaticSettings.page_txt(), "id");
			
			// Verify url
			perform.verifyURL(driver, "Admin/Preferences/VMPStatusMapping.aspx");
			
			// Get page text
			text = SConfigureAutomaticSettings.page_txt(driver).getText();
			
			// Verify text on screen
			Assert.assertTrue(text.contains("Status Mapping Configuration"), "Text on the page is incorrect");
			
			// Click Compliance Certificate
			perform.click(driver, SVMPXSites.complianceCertificate_lnk(driver));
			
			// Wait for page text
			perform.waitForElementToBeClickable(driver, SComplianceCertificate.page_txt(), "id");
			
			// Verify url
			perform.verifyURL(driver, "Admin/Preferences/VMPComplianceCert.aspx");
			
			// Get page text
			text = SComplianceCertificate.page_txt(driver).getText();
			
			// Verify text on screen
			Assert.assertTrue(text.contains("Compliance Certificate"), "Text on the page is incorrect");
			
			// Click XSite Wizard link
			perform.click(driver, driver.findElement(By.linkText("XSite Wizard")));
			
			// Switch window
			perform.switchToXSiteWindowByTitle(driver, "Wizard");
			
			// Verify url
			perform.verifyURL(driver, "admin/Wizard.aspx");
			
			// Close the window
			perform.closeNewWindow(driver);
			
			// Click Business Management link
			perform.click(driver, driver.findElement(By.linkText("Business Management")));
			
			// Switch window
			perform.switchToXSiteWindowByTitle(driver, "Business Management");
			
			// Verify url
			perform.verifyURL(driver, "BusinessMgt/BusinessMgt.aspx?Load=Orders");
			
			// Close the window
			perform.closeNewWindow(driver);
			
			// Click Contacts link
			perform.click(driver, driver.findElement(By.linkText("Contacts")));
			
			// Switch window
			perform.switchToXSiteWindowByTitle(driver, "Contact Management");
			
			// Verify url
			perform.verifyURL(driver, "ContactManagement/Default.aspx");
			
			// Close the window
			perform.closeNewWindow(driver);
			
			// Log test
			test.log(LogStatus.INFO, "preferences", "Verified the VMP XSite pages load properly");
			
		} else {
			
			// Log test
			test.log(LogStatus.INFO, "preferences", "Could not test on mobile due to scroll issue");
			
		} // end if/else
		
	} // end vmpXSites
	
} // end the Secure_Login class
