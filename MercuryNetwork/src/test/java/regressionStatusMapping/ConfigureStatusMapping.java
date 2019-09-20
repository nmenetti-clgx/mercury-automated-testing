package regressionStatusMapping;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Secure.SVMPXSites;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Status Mapping - Configure Status Mapping</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class ConfigureStatusMapping extends TestSetup {
	
	/** The user. */
	private final String user = "RegressionSecure13";
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Click Preferences &gt; VMP XSites</li>
	 * 	<li>Click Configure Status Mapping</li>
	 * 	<li>Confirm the option "Requires Reassignment" is available in the list</li>
	 * 	<li>Get the row text</li>
	 * 	<li>Confirm the option is located between Conditionally Declined and Modification Statuses</li>
	 * 	<li>Confirm the option exists on AMC tab</li>
	 * 	<li>Click AMC button</li>
	 * 	<li>Confirm the option "Requires Reassignment" is available in the list</li>
	 * 	<li>Get the row text</li>
	 * 	<li>Confirm the sync option is only available to sync to client</li>
	 * 	<li>Get the row text</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Status Mapping", "Secure - VMP XSite Settings", "Secure - Configure Status Mapping", "Secure - Require Reassignment"}, alwaysRun=true)
	public void requiresReassignment() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Login to Secure
		secure.login(driver, user, StoredVariables.getpassword().get());
		
		// Click Preferences > VMP XSites
		secure.goToVMPXSites(driver);
		
		// Click Configure Status Mapping
		perform.click(driver,SVMPXSites.configureStatusMapping_lnk(driver));
		
		// Wait for Appraiser button
		perform.waitForElementToBeClickable(driver, SVMPXSites.appraiser_btn(), "cssSelector");
		
		// Confirm the option "Requires Reassignment" is available in the list
		boolean requiresReassignment = false;
		List<WebElement> rr = driver.findElements(By.cssSelector(".igg_ListItem > tr > td:nth-child(1)"));
		for(WebElement row : rr) 
		{
			// Get the row text
			String rowText = row.getText();
			// if class contains grdCell_Gray, don't do anything
			if (rowText.contains("Requires Reassignment")){
				requiresReassignment = true;
				break;
			}
		} // end for loop
		Assert.assertTrue(requiresReassignment==true, "Requires Reassignment is not found in Status Mapping on the Appraiser tab");
		
		// Confirm the option is located between Conditionally Declined and Modification Statuses
		List<WebElement> text = driver.findElements(By.cssSelector(".igg_ListItem > tr > td:nth-child(1)"));
	    for (int i =0; i<text.size();i++) {
	    	String status = text.get(i).getText();
		    if (status.equalsIgnoreCase("Requires Reassignment")) {
		        if (text.get(i-1).getText().equalsIgnoreCase("Conditionally Declined") 
		                && text.get(i+1).getText().equalsIgnoreCase("Modification Statuses"))
		        break;
		    } // end if
	    } // end for loop
		
		// Confirm the option exists on AMC tab
		// Click AMC button
	    perform.click(driver,SVMPXSites.amcFirm_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Wait for Appraiser button
		perform.waitForElementToBeClickable(driver, SVMPXSites.appraiser_btn(), "cssSelector");
		
		// Confirm the option "Requires Reassignment" is available in the list
		requiresReassignment = false;
		rr = driver.findElements(By.cssSelector(".igg_ListItem > tr > td:nth-child(1)"));
		for(WebElement row : rr) 
		{
			// Get the row text
			String rowText = row.getText();
			// if class contains grdCell_Gray, don't do anything
			if (rowText.contains("Requires Reassignment")){
				requiresReassignment = true;
				break;
			}
		} // end for loop
		Assert.assertTrue(requiresReassignment==true, "Requires Reassignment is not found in Status Mapping on the AMC tab");
		
		// Confirm the sync option is only available to sync to client
		int a = 1;
		List<WebElement> sync = driver.findElements(By.cssSelector(".igg_ListItem > tr > td:nth-child(1)"));
		for(WebElement row : sync) 
		{
			// Get the row text
			String rowText = row.getText();
			if (rowText.contains("Requires Reassignment")){
				Assert.assertTrue(!driver.findElement(By.cssSelector(".igg_ListItem > tr:nth-child(" + a + ") > td:nth-child(4)")).getAttribute("class").contains("grdCell_Gray"), "The sync option should be available");
				Assert.assertTrue(driver.findElement(By.cssSelector(".igg_ListItem > tr:nth-child(" + a + ") > td:nth-child(7)")).getAttribute("class").contains("grdCell_Gray"), "The sync option should not be available");
				break;
			}
			a++;
		} // end for loop
		
		// Log test
		test.log(LogStatus.INFO, "Status Mapping Regression Test", "Verified Requires reassignment status mapping configuration");
		
	} // end requiresReassignment
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Click Preferences &gt; VMP XSites</li>
	 * 	<li>Click Configure Status Mapping</li>
	 * 	<li>Confirm the option "Modification Statuses" is available in the list</li>
	 * 	<li>Get the row text</li>
	 * 	<li>Confirm the option is located between Requires Reassignment and Inspection Scheduled</li>
	 * 	<li>Make sure sync option is unchecked</li>
	 * 	<li>Click on the Modification Statuses gear icon</li>
	 * 	<li>Verify all checkboxes are unchecked</li>
	 * 	<li>Click OK</li>
	 * 	<li>Check the sync option</li>
	 * 	<li>Click on the Modification Statuses gear icon</li>
	 * 	<li>Verify all checkboxes are checked</li>
	 * 	<li>Uncheck all options</li>
	 * 	<li>Verify all checkboxes are unchecked</li>
	 * 	<li>Click OK</li>
	 * 	<li>Verify sync status is unchecked</li>
	 * 	<li>Click on the Modification Statuses gear icon</li>
	 * 	<li>Check Requested checkbox</li>
	 * 	<li>Click OK</li>
	 * 	<li>Verify sync status is checked</li>
	 * 	<li>Make sure sync option is unchecked</li>
	 * 	<li>Save</li>
	 * 	<li>Confirm the option exists on AMC tab</li>
	 * 	<li>Click AMC button</li>
	 * 	<li>Confirm the option "Modification Statuses" is available in the list</li>
	 * 	<li>Get the row text</li>
	 * 	<li>Confirm the sync option is only available to sync to client</li>
	 * 	<li>Get the row text</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Status Mapping", "Secure - VMP XSite Settings", "Secure - Configure Status Mapping"}, alwaysRun=true)
	public void modificationStatuses() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Login to Secure
		secure.login(driver, user, StoredVariables.getpassword().get());
		
		// Click Preferences > VMP XSites
		secure.goToVMPXSites(driver);
		
		// Click Configure Status Mapping
		perform.click(driver,SVMPXSites.configureStatusMapping_lnk(driver));
		
		// Wait for Appraiser button
		perform.waitForElementToBeClickable(driver, SVMPXSites.appraiser_btn(), "cssSelector");
		
		// Confirm the option "Modification Statuses" is available in the list
		boolean modificationStatuses = false;
		List<WebElement> rr = driver.findElements(By.cssSelector(".igg_ListItem > tr > td:nth-child(1)"));
		for(WebElement row : rr) 
		{
			// Get the row text
			String rowText = row.getText();
			// if class contains grdCell_Gray, don't do anything
			if (rowText.contains("Modification Statuses")){
				modificationStatuses = true;
				break;
			}
		} // end for loop
		Assert.assertTrue(modificationStatuses==true, "Modification Statuses is not found in Status Mapping on the Appraiser tab");
		
		// Confirm the option is located between Requires Reassignment and Inspection Scheduled
		List<WebElement> text = driver.findElements(By.cssSelector(".igg_ListItem > tr > td:nth-child(1)"));
	    for (int i =0; i<text.size();i++) {
	    	String status = text.get(i).getText();
		    if (status.equalsIgnoreCase("Modification Statuses")) {
		        if (text.get(i-1).getText().equalsIgnoreCase("Requires Reassignment") 
		                && text.get(i+1).getText().equalsIgnoreCase("Inspection Scheduled"))
		        break;
		    } // end if
	    } // end for loop
	    
	    // Make sure sync option is unchecked
	    secure.setStatusMapping(driver, "Modification Statuses", "none");
	    
	    // Click on the Modification Statuses gear icon
	    perform.click(driver, SVMPXSites.modificationStatusesGear_btn(driver));
	    
	    // Wait for overlay
	    perform.waitForOverlayToBeVisible(driver);
	    
	    // Wait for Requested checkbox
	    perform.waitForElementToBeClickable(driver, SVMPXSites.requested_chkbx(), "id");
	    
	    // Verify all checkboxes are unchecked
	    Assert.assertTrue(SVMPXSites.requested_chkbx(driver).isSelected()==false, "Requested checkbox should be checked");
	    Assert.assertTrue(SVMPXSites.accepted_chkbx(driver).isSelected()==false, "Accepted checkbox should be checked");
	    Assert.assertTrue(SVMPXSites.declined_chkbx(driver).isSelected()==false, "Declined checkbox should be checked");	    
	    
	    // Click OK
	    perform.click(driver,SVMPXSites.modificationStatusesOk_btn(driver));
	    
	    // Wait for overlay to be hidden
	    perform.waitForOverlayToBeHidden(driver);
	    
	    // Check the sync option
	    secure.setStatusMapping(driver, "Modification Statuses", "left");
	    WebElement element = secure.getStatusMappingElement(driver, "Modification Statuses", "left");
	    Assert.assertTrue(!element.getAttribute("style").contains("hidden"), "The sync status should be unchecked. Status: " + element.getAttribute("style"));
	    
	    // Click on the Modification Statuses gear icon
	    perform.click(driver,SVMPXSites.modificationStatusesGear_btn(driver));
	    
	    // Wait for overlay
	    perform.waitForOverlayToBeVisible(driver);
	    
	    // Wait for Requested checkbox
	    perform.waitForElementToBeClickable(driver, SVMPXSites.requested_chkbx(), "id");
	    
	    // Verify all checkboxes are checked
	    Assert.assertTrue(SVMPXSites.requested_chkbx(driver).isSelected()==true, "Requested checkbox should be checked");
	    Assert.assertTrue(SVMPXSites.accepted_chkbx(driver).isSelected()==true, "Accepted checkbox should be checked");
	    Assert.assertTrue(SVMPXSites.declined_chkbx(driver).isSelected()==true, "Declined checkbox should be checked");
	    
	    // Uncheck all options
	    perform.click(driver,SVMPXSites.none_link(driver));
	    
	    // Verify all checkboxes are unchecked
	    Assert.assertTrue(SVMPXSites.requested_chkbx(driver).isSelected()==false, "Requested checkbox should be checked");
	    Assert.assertTrue(SVMPXSites.accepted_chkbx(driver).isSelected()==false, "Accepted checkbox should be checked");
	    Assert.assertTrue(SVMPXSites.declined_chkbx(driver).isSelected()==false, "Declined checkbox should be checked");	    
	    
	    // Click OK
	    perform.click(driver,SVMPXSites.modificationStatusesOk_btn(driver));
	    
	    // Wait for overlay to be hidden
	    perform.waitForOverlayToBeHidden(driver);
	    
	    // Verify sync status is unchecked
	    element = secure.getStatusMappingElement(driver, "Modification Statuses", "left");
	    Assert.assertTrue(element.getAttribute("style").contains("hidden"), "The sync status for Modification Statuses should be unchecked");
	    
	    // Click on the Modification Statuses gear icon
	    perform.click(driver, SVMPXSites.modificationStatusesGear_btn(driver));
	    
	    // Wait for overlay
	    perform.waitForOverlayToBeVisible(driver);
	    
	    // Wait for Requested checkbox
	    perform.waitForElementToBeClickable(driver, SVMPXSites.requested_chkbx(), "id");
	    
	    // Check Requested checkbox
	    perform.clickLabelText(driver, "Requested");
	    Assert.assertTrue(SVMPXSites.requested_chkbx(driver).isSelected()==true, "Requested checkbox should be checked");
	    
	    // Click OK
	    perform.click(driver,SVMPXSites.modificationStatusesOk_btn(driver));
	    
	    // Wait for overlay to be hidden
	    perform.waitForOverlayToBeHidden(driver);
	    
	    // Verify sync status is checked
	    element = secure.getStatusMappingElement(driver, "Modification Statuses", "left");
	    Assert.assertTrue(element.getAttribute("style").contains("visible"), "The sync status for Modification Statuses should be unchecked");
	    
	    // Make sure sync option is unchecked
	    secure.setStatusMapping(driver, "Modification Statuses", "none");
	    element = secure.getStatusMappingElement(driver, "Modification Statuses", "left");
	    Assert.assertTrue(element.getAttribute("style").contains("hidden"), "The sync status should be unchecked");
	    
	    // Save
	    perform.click(driver, SVMPXSites.save_btn(driver));
	    
	    // Wait for overlay to be hidden
	    perform.waitForOverlayToBeHidden(driver);
	    
		// Confirm the option exists on AMC tab
		// Click AMC button
	    perform.click(driver,SVMPXSites.amcFirm_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Wait for Appraiser button
		perform.waitForElementToBeClickable(driver, SVMPXSites.appraiser_btn(), "cssSelector");
		
		// Confirm the option "Modification Statuses" is available in the list
		modificationStatuses = false;
		rr = driver.findElements(By.cssSelector(".igg_ListItem > tr > td:nth-child(1)"));
		for(WebElement row : rr) 
		{
			// Get the row text
			String rowText = row.getText();
			// if class contains grdCell_Gray, don't do anything
			if (rowText.contains("Modification Statuses")){
				modificationStatuses = true;
				break;
			}
		} // end for loop
		Assert.assertTrue(modificationStatuses==true, "Modification Statuses is not found in Status Mapping on the AMC tab");
		
		// Confirm the sync option is only available to sync to client
		int a = 1;
		List<WebElement> sync = driver.findElements(By.cssSelector(".igg_ListItem > tr > td:nth-child(1)"));
		for(WebElement row : sync) 
		{
			// Get the row text
			String rowText = row.getText();
			if (rowText.contains("Modification Statuses")){
				Assert.assertTrue(!driver.findElement(By.cssSelector(".igg_ListItem > tr:nth-child(" + a + ") > td:nth-child(4)")).getAttribute("class").contains("grdCell_Gray"), "The sync option should be available");
				Assert.assertTrue(driver.findElement(By.cssSelector(".igg_ListItem > tr:nth-child(" + a + ") > td:nth-child(7)")).getAttribute("class").contains("grdCell_Gray"), "The sync option should not be available");
				break;
			}
			a++;
		} // end for loop
		
		// Log test
		test.log(LogStatus.INFO, "Status Mapping Regression Test", "Verified Modification Statuses status mapping configuration");
		
	} // end requiresReassignment
	
} // end the ConfigureStatusMapping class
