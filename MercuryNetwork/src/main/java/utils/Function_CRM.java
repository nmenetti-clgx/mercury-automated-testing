package utils;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import setup.TestSetup;

// TODO: Auto-generated Javadoc
/**
 * <h1>Function CRM</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class Function_CRM extends TestSetup {
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the CRM url</li>
	 * 	<li>Go to CRM</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param env the env
	 * @param customerNumber the customer number
	 * @return the string
	 * @throws InterruptedException the interrupted exception
	 */
	// Go to CRM
	public String goToCRM(RemoteWebDriver driver, String env, String customerNumber) throws InterruptedException {

		// Set url
		String url = "";
		if (env.equals("QA"))
		{
			url = "https://crmqa.ad.mercuryvmp.com/customer/customermgt/customerinfo.aspx?ID="+customerNumber;
		} else {
			url = "https://crm.ad.mercuryvmp.com/customer/customermgt/customerinfo.aspx?ID="+customerNumber;
		} // end if/else
		
		// Go to CRM
		driver.get(url);
		
		return url;
		
	} // end activateUser
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Switch iFrame</li>
	 * 	<li>Wait for Name</li>
	 * 	<li>Verify name</li>
	 * 	<li>Switch out of iFrame</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param username the username
	 * @param crmURL the crm URL
	 * @throws InterruptedException the interrupted exception
	 */
	// Verify the name in CRM
	public void verifyName(RemoteWebDriver driver, String username, String crmURL) throws InterruptedException {

		// Switch iFrame
		perform.switchToiFrameByID(driver, "CrmHeadingIframe");
		
		// Wait for Name
		perform.waitForElementToBeClickable(driver, driver.findElement(By.id("uxNameCell")));
		
		// Verify name
		Assert.assertTrue(driver.findElement(By.id("uxNameCell")).getText().contains(username), "The name is incorrect in CRM. URL = " + crmURL);
		
		// Switch out of iFrame
		driver.switchTo().defaultContent();
		
	} // end activateUser
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Wait for element</li>
	 * 	<li>Click Products</li>
	 * 	<li>Change iFrame</li>
	 * 	<li>Select All from the dropdown</li>
	 * 	<li>Click Activate</li>
	 * 	<li>Wait for X to display</li>
	 * 	<li>Get out of iFrame</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param custNo the cust no
	 * @throws InterruptedException the interrupted exception
	 * @throws ClassNotFoundException the ClassNotFoundExceptionthe class not found exception
	 * @throws SQLException the SQLExceptionthe SQL exception
	 */
	// Activate user
	public void activateUser(RemoteWebDriver driver, String custNo) throws InterruptedException, ClassNotFoundException, SQLException {

		// Wait for element
		WebDriverWait wait = new WebDriverWait(driver, 40);
		
		// Click Products
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("ui-id-4")));
		perform.click(driver, element);
		
		// Change iFrame
		perform.switchToiFrameByID(driver, "productsTab");
		
		// Select All from the dropdown
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("ctl00_cphBody_ddlLenderUserStatusFilter")));
		Select documentType = new Select(element);   
		documentType.selectByVisibleText("All");
		
		// Click Activate
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("ctl00_cphBody_rpLenderUsers_ctl01_ibToggleEntityStatus")));
		perform.click(driver, element);
		
		// Wait for X to display
		element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[src='Images/cross.png']")));
		
		// Get out of iFrame
		driver.switchTo().defaultContent();
		
//		// Verify that the EntityStatusID is set to 1
//		String sqlStatement = "SELECT EntityStatusID FROM Entities "
//				+ "WHERE ALMCustomerNumber = '" + custNo + "'";
//		Thread.sleep(5000);
//		String entityStatusID = db.queryDB(driver, "Mercury", sqlStatement);
//		Assert.assertTrue(entityStatusID.equals("1"), "The EntityStatusID is not set to 1. DB value = " + entityStatusID);
		
	} // end activateUser
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click Orders</li>
	 * 	<li>Switch iFrame</li>
	 * 	<li>Click New Order link</li>
	 * 	<li>Switch to new window</li>
	 * 	<li>Select Ad Code</li>
	 * 	<li>Select Ad Media</li>
	 * 	<li>Enter Product</li>
	 * 	<li>Click Add</li>
	 * 	<li>Click the Process button</li>
	 * 	<li>Click the Close button</li>
	 * 	<li>Switch back to main window</li>
	 * 	<li>Click Products</li>
	 * 	<li>Switch iFrame</li>
	 * 	<li>Select Go to dropdown</li>
	 * 	<li>Switch to new window</li>
	 * 	<li>Click Submit</li>
	 * 	<li>Click Close</li>
	 * 	<li>Switch back to main window</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param env the env
	 * @param custNo the cust no
	 * @throws InterruptedException the interrupted exception
	 * @throws ClassNotFoundException the ClassNotFoundExceptionthe class not found exception
	 * @throws SQLException the SQLExceptionthe SQL exception
	 */
	// Add new order for XSite
	public void enterNewOrderForXSite(RemoteWebDriver driver, String env, String custNo) throws InterruptedException, ClassNotFoundException, SQLException {

		// Click Orders
		perform.click(driver, driver.findElement(By.id("ui-id-6")));
		
		// Switch iFrame
		perform.switchToiFrameByID(driver, "orderHistoryTab");
		
		// Wait for Enter New Order link
		perform.waitForElementToBeClickable(driver, driver.findElement(By.linkText("Enter New Order")));
		
		// Click New Order link
		perform.click(driver, driver.findElement(By.linkText("Enter New Order")));
		
		// Switch out of iFrame
		driver.switchTo().defaultContent();

		// Switch to new window
		perform.switchToXSiteWindowByTitle(driver, "New Order");
		
		// Wait for Ad Code dropdown
		perform.waitForElementToBeClickable(driver, driver.findElement(By.id("uxMarketing_uxAdCodeDropDownList")));
		
		// Select Ad Code
		perform.selectDropdownOption(driver, driver.findElement(By.id("uxMarketing_uxAdCodeDropDownList")), "N/A");
		
		Thread.sleep(3000);
		
		// Select Ad Media
		perform.selectDropdownOption(driver, driver.findElement(By.id("uxMarketing_uxAdMediaDropDownList")), "N/A");
		
		// Enter Product
		perform.type(driver, driver.findElement(By.id("uxProducts_uxProductCodeTextBox")), "XSNE");
		
		// Click Add
		perform.click(driver, driver.findElement(By.id("uxProducts_uxAddProductButton")));
		
		// Wait for the Process button
		perform.waitForElementToBeClickable(driver, driver.findElement(By.id("uxProcessButton")));
		
		// Click the Process button
		perform.click(driver, driver.findElement(By.id("uxProcessButton")));
		
		// Wait for the Close button
		WebDriverWait wait2 = new WebDriverWait(driver, 400);
		WebElement close = wait2.until(ExpectedConditions.elementToBeClickable(By.id("uxProcessing_uxCloseButton")));
		
		// Click the Close button
		perform.click(driver, close);
		
		// Switch back to main window
		driver.switchTo().window(StoredVariables.getwinHandleBefore().get());
		driver.switchTo().defaultContent();
		
		if (env.equals("Beta"))
		{
			
			// Click Products
			perform.click(driver, driver.findElement(By.id("ui-id-4")));
			
			// Switch iFrame
			perform.switchToiFrameByID(driver, "productsTab");
			
			// Wait for Go to dropdown
			perform.waitForElementToBeClickable(driver, driver.findElement(By.id("ctl00_ddlProduct")));
			
			// Select Go to dropdown
			perform.selectDropdownOption(driver, driver.findElement(By.id("ctl00_ddlProduct")), "XSites");
			
			// Wait for Change to Beta link
			WebElement element = wait2.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#dgXSiteAccounts > tbody > tr:nth-child(2) > td:nth-child(3) > a:nth-child(6)")));
			perform.click(driver, element);
			
			// Switch out of iFrame
			driver.switchTo().defaultContent();
			
			// Switch to new window
			perform.switchToXSiteWindowByTitle(driver, "Convert XSite");
			
			// Wait for Submit button
			perform.waitForElementToBeClickable(driver, driver.findElement(By.id("Submit")));
			
			// Click Submit
			perform.click(driver, driver.findElement(By.id("Submit")));
			
			// Wait for Close button
			perform.waitForElementToBeClickable(driver, driver.findElement(By.id("Close2")));
			
			// Click Close
			perform.click(driver, driver.findElement(By.id("Close2")));
			
			// Switch back to main window
			driver.switchTo().window(StoredVariables.getwinHandleBefore().get());
			driver.switchTo().defaultContent();
			
		} // end Beta
		
	} // end enterNewOrderForXSite
	
} // end Function_Secure class
