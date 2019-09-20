package regressionVendorOrderCapacity;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjects.Secure.SFeePanel;
import pageObjects.Secure.SProfile;
import pageObjects.Vendors.VUsers;
import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Vendor Order Capacity - Remove</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class Remove extends TestSetup {
	
	/** The user secure. */
	private final String userSecure = "VendorOrderCapacity7";
	
	/** The user secure 2. */
	private final String userSecure2 = "VendorOrderCapacity8";
	
	/** The user vendors. */
	private final String userVendors = "VendorOrderCapacityAppraiser7";
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get environment</li>
	 * 	<li>Get phone prefix</li>
	 * 	<li>Place order through the API</li>
	 * 	<li>Log in to secure and make sure vendor is in fee panel</li>
	 * 	<li>Go to Fee Panel</li>
	 * 	<li>Add vendor to fee panel</li>
	 * 	<li>Login to Vendors</li>
	 * 	<li>Go to Users</li>
	 * 	<li>Click My Panels</li>
	 * 	<li>Select one of the fee panel memberships and click Remove</li>
	 * 	<li>Get text from dialog</li>
	 * 	<li>Verify if the vendor still has open or new orders, the error message Open/Pending orders displays and lists the orders (title and message text depends on type of orders Open or Pending or both)</li>
	 * 	<li>Click OK</li>
	 * 	<li>Select one of the fee panel memberships and click Remove</li>
	 * 	<li>Verify if the vendor does not have any open or new orders, verify the Remove from fee panel reason window displays</li>
	 * 	<li>Click Send</li>
	 * 	<li>Verify text</li>
	 * 	<li>Click OK</li>
	 * 	<li>Include a reason</li>
	 * 	<li>Click Send</li>
	 * 	<li>Verify the fee panel membership no longer shows</li>
	 * 	<li>Save</li>
	 * 	<li>Log in to secure and make sure vendor is in fee panel</li>
	 * 	<li>Go to Fee Panel</li>
	 * 	<li>Click Add button</li>
	 * 	<li>Get outside frames</li>
	 * 	<li>Get inside the vendor assignment frame</li>
	 * 	<li>Enter Phone</li>
	 * 	<li>Click Next</li>
	 * 	<li>View the profile</li>
	 * 	<li>Get in the correct iFrames</li>
	 * 	<li>Verify the vendor is not currently on the fee panel</li>
	 * 	<li>Click the Notes tab</li>
	 * 	<li>Verify the latest note was added detailing the removed from fee panel at vendor's request</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Create Order Via API", "Secure - Fee Panel", "Vendors - Users", "Vendors - My Panels", "Secure - Vendor Profile", "Vendor Order Capcity"}, alwaysRun=true)
	public void remove() throws Exception{

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		String password = StoredVariables.getpassword().get();
		
		// Get environment
		String environment = StoredVariables.getusernameEnvironment().get();
		
		// Get phone prefix
		String phonePrefix = "";
		if (environment.equals("QA"))
		{
			phonePrefix = "111";
		}
		if (environment.equals("Beta"))
		{
			phonePrefix = "222";
		}
		if (environment.equals("Live"))
		{
			phonePrefix = "333";
		}
		
		// Place order through the API
//		perform.apiPlaceOrderFromSecure(driver, userSecure, password, "PlaceMNOrder-Remove");
//		String trackingNumber = StoredVariables.gettrackingNumber().get();
		String trackingNumber = perform.apiPlaceOrderFromSecure(driver, userSecure, password, "PlaceMNOrder-Remove");
		secure.loginAndAssignOrderToAppraiser(driver, userSecure, password, trackingNumber, userVendors);
		
		// Log in to secure and make sure vendor is in fee panel
		secure.login(driver, userSecure2, password);
		
		// Go to Fee Panel
		secure.goToFeePanel(driver);
		
		// Add vendor to fee panel
		secure.addVendorToFeePanel(driver, "phone", "501"+phonePrefix+"2026", userVendors);
		
		// Login to Vendors
		vendors.login(driver, userVendors, password);
		
		// Go to Users
		vendors.goToUsers(driver);
		
		// Click My Panels
		perform.click(driver,VUsers.myPanels_btn(driver));
		
		// Wait for Remove button
		perform.waitForElementToBeClickable(driver, VUsers.remove_btn(), "cssSelector");
		
		List<WebElement> numOfRows = driver.findElements(By.cssSelector("#_scroll > table > tbody > tr"));
		Assert.assertTrue(numOfRows.size()==2, "There should be 2 appraisers, but there are not");
		
		// Select one of the fee panel memberships and click Remove
		perform.click(driver,driver.findElement(By.cssSelector("img[src='/Images/DeleteIcon16x16.png'][onclick*='Automation" + environment + "VendorOrderCapacity7']")));

		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for OK button
		try {
			perform.waitForElementToBeClickable(driver, VUsers.okOpenOrders_btn(), "id");
		} catch (Exception e) {
			perform.waitForElementToBeClickable(driver, VUsers.okOpenOrders_btn(), "id");
		} // end try/catch
		
		// Get text from dialog
		String openOrdersText = VUsers.openOrders_txt(driver).getText();
		
		// Verify if the vendor still has open or new orders, the error message Open/Pending orders displays and lists the orders (title and message text depends on type of orders Open or Pending or both)
		Assert.assertTrue(openOrdersText.contains("Open orders - Automation" + environment + userSecure), "The dialog text is incorrect");
		Assert.assertTrue(openOrdersText.contains("You have pending order(s) with Automation" + environment + userSecure), "The dialog text is incorrect");
		Assert.assertTrue(openOrdersText.contains("In order to remove yourself from the fee panel, you must first respond to the following order(s)"), "The dialog text is incorrect");
		
		// Click OK
		perform.click(driver,VUsers.okOpenOrders_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Select one of the fee panel memberships and click Remove
		perform.click(driver,driver.findElement(By.cssSelector("img[src='/Images/DeleteIcon16x16.png'][onclick*='Automation" + environment + "VendorOrderCapacity8']")));
		
		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for Send button
		perform.waitForElementToBeClickable(driver, VUsers.send_btn(), "cssSelector");
		
		// Verify if the vendor does not have any open or new orders, verify the Remove from fee panel reason window displays
		Assert.assertTrue(VUsers.removeFromFeePanel_txt(driver).getText().contains("will be notified you no longer wish to be included on their fee panel. Please provide a reason to include in the notification."), "The dialog text is incorrect");
		
		// Click Send
		perform.click(driver,VUsers.send_btn(driver));
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, VUsers.okSave_btn(), "id");
		
		// Verify text
		Assert.assertTrue(VUsers.almostDone_txt(driver).getText().contains("A reason is required."), "The dialog text is incorrect");
		
		// Click OK
		perform.click(driver,VUsers.okSave_btn(driver));
		
		// Wait for Send button
		perform.waitForElementToBeClickable(driver, VUsers.send_btn(), "cssSelector");
		
		// Include a reason
		perform.type(driver,VUsers.reason_txtbx(driver), "These are reasons to remove VendorOrderCapacity8 from the fee panel");
		
		// Click Send
		perform.click(driver,VUsers.send_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Verify the fee panel membership no longer shows
		numOfRows = driver.findElements(By.cssSelector("#_scroll > table > tbody > tr"));
		Assert.assertTrue(numOfRows.size()==1, "There should only be 1 appraiser, but there are not");
		Assert.assertTrue(driver.findElement(By.cssSelector("td[aria-describedby='_CompanyName']")).getText().contains(userSecure), "VendorOrderCapacity7 should be the only vendor in the fee panel");
		
		// Save
		vendors.saveUsersSettings(driver);
		
		// Log in to secure and make sure vendor is in fee panel
		secure.login(driver, userSecure2, password);
		
		// Go to Fee Panel
		secure.goToFeePanel(driver);
		
		// Click Add button
		perform.click(driver,SFeePanel.add_btn(driver));
		
		// Get outside frames
		driver.switchTo().defaultContent();
		
		// Get inside the vendor assignment frame
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[src='Build/Single/SingleInfo.aspx']")));
		
		// Enter Phone
		perform.type(driver,SFeePanel.phone_txtbx(driver), "501" + phonePrefix + "2026");
		
		// Click Next
		perform.click(driver,SFeePanel.next_btn(driver));
		
		Thread.sleep(8000);
		
		// Switch out of iFrames
		driver.switchTo().defaultContent();
		perform.waitForiFrameSrcAndSwitchToIt(driver, "Build/Single/SingleChoose.aspx", By.id(SFeePanel.back_btn()));
		
		// View the profile
		WebElement profile = driver.findElement(By.cssSelector("img[src='/Images/Profile.png']"));
		perform.waitForElementToBeClickable(driver, profile);
		perform.click(driver,profile);
		
		Thread.sleep(8000);
		
		// Get in the correct iFrames
		driver.switchTo().defaultContent();
		perform.waitForiFrameSrcAndSwitchToIt(driver, "/Common/VendorProfile/Profile.aspx", By.id(SProfile.addToFeePanel_btn()));
		
		// Verify the vendor is not currently on the fee panel
		Assert.assertTrue(SProfile.addToFeePanel_btn(driver).getText().equals("Add to fee panel"), "The button does not say Add to fee panel");
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Click the Notes tab
		perform.click(driver,SProfile.notes_tab(driver));
		
		// Wait for Notes section
		perform.waitForElementToBeClickable(driver, SProfile.notes_txt(), "id");
		
		// Verify the latest note was added detailing the removed from fee panel at vendor's request	
		perform.getTodaysDate(driver);
		String mostRecentNote = driver.findElement(By.cssSelector("#NotesBox > div:nth-child(1) > div.VendorNoteRowText > div:nth-child(1)")).getText();
		Assert.assertTrue(mostRecentNote.contains("Removed from fee panel"), "The most recent note should be the removal of VendorOrderCapacity8 from the fee panel");
		Assert.assertTrue(mostRecentNote.contains(StoredVariables.gettodaysDateLong().get()), "The most recent note should be the removal of VendorOrderCapacity8 from the fee panel");
		Assert.assertTrue(mostRecentNote.contains("Automation VendorOrderCapacityAppraiser7"), "The most recent note should be the removal of VendorOrderCapacity8 from the fee panel");
		
		// Log test
		test.log(LogStatus.INFO, "Vendor Order Capacity", "Verified vendor can remove originator from Fee Panel");
		
	} // end remove
	
} // end the OrderManagement class
