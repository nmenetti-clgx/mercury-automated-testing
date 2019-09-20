package regressionVendors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Vendors.VUsers;
import setup.DriverFactory;
import setup.TestSetup;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Vendors - Change Vendors Document Type</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-02-2019
 */

@Listeners(utils.Listener.class)
public class ChangeVendorsDocumentType extends TestSetup {
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to vendors</li>
	 * 	<li>Click Users</li>
	 * 	<li>Click Professional</li>
	 * 	<li>Get the document type</li>
	 * 	<li>In Attachments section, click Edit</li>
	 * 	<li>Change the document type in the drop down</li>
	 * 	<li>Click Save</li>
	 * 	<li>Verify the new document type is reflected in Attachments</li>
	 * 	<li>Verify document type changed</li>
	 * 	<li>Refresh the screen</li>
	 * 	<li>Click Professional</li>
	 * 	<li>Verify the document type is still correct</li>
	 * 	<li>Verify the header reads Edit and not Update</li>
	 * 	<li>Log test</li>
	 * </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Vendors - Users", "Vendors - Professional"}, alwaysRun=true)
	public void changeVendorsDocumentType() throws Exception {
		
		// Create the driver
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Login to vendors
		vendors.login(driver, "RegressionVendors1", StoredVariables.getpassword().get());
		
		// Click Users 
		vendors.goToUsers(driver);
		
		// Click Professional
		perform.click(driver,VUsers.professional_btn(driver));
		
		// Wait for Residential appraisal checkbox
		perform.waitForElementToBeClickable(driver, VUsers.residentialAppraisal_chkbx(), "id");
		
		// Get the document type
		WebElement docType = driver.findElement(By.cssSelector("#_scroll > table > tbody > tr > td:nth-child(2)"));
		String documentType = docType.getText();
		
		// In Attachments section, click Edit 
		perform.click(driver,VUsers.editDocument_btn(driver));
		
		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for Save button
		perform.waitForElementToBeClickable(driver, VUsers.saveUpdateAttachment_btn(), "cssSelector");
		
		// Change the document type in the drop down 
		String documentType2Expected = "";
		if (!documentType.equals("Other"))
		{
			perform.selectDropdownOption(driver, VUsers.attachmentType_dropdown(driver), "Other");
			documentType2Expected = "Other";
		}
		else
		{
			perform.selectDropdownOption(driver, VUsers.attachmentType_dropdown(driver), "Resume");
			documentType2Expected = "Resume";
		}
		
		// Click Save 
		perform.click(driver,VUsers.saveUpdateAttachment_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Verify the new document type is reflected in Attachments 
		docType = driver.findElement(By.cssSelector("#_scroll > table > tbody > tr > td:nth-child(2)"));
		String documentType2 = docType.getText();
		
		// Verify document type changed
		perform.verification(driver, documentType2, "equals", documentType2Expected);
		perform.verification(driver, documentType, "!equal", documentType2);
		
		// Refresh the screen 
		driver.navigate().refresh();
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Wait for Professional button
		perform.waitForElementToBeClickable(driver, VUsers.professional_btn(), "id");
		
		// Click Professional
		perform.click(driver,VUsers.professional_btn(driver));
		
		// Wait for Residential appraisal checkbox
		perform.waitForElementToBeClickable(driver, VUsers.residentialAppraisal_chkbx(), "id");
		
		// Verify the document type is still correct 
		perform.verification(driver, documentType2, "equals", documentType2Expected);
		
		// Verify the header reads Edit and not Update
		WebElement headerText = driver.findElement(By.cssSelector("#divAttachments > #_container > .ui-widget-header > #_headers > thead > tr > #_Edit > span"));
		perform.verification(driver, headerText.getText(), "equals", "Edit");
		
		// Log test
		perform.addInfoToExtentReport(driver, "Regression Vendors", "Verified a vendor can change their document types without having to upload the document again");
		
	} // end acceptOnlyFromFeePanel
	
} // end the OrderManagement class
