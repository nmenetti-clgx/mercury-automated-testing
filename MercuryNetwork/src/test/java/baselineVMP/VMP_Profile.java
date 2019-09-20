package baselineVMP;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.VMP.VMPProfile;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Baseline VMP - Login</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class VMP_Profile extends TestSetup {
	
	/** The user. */
	private final String user = "EVFLender2";
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to VMP Client Portal</li>
	 * 	<li>Go to Profile</li>
	 * 	<li>Enter a new Title</li>
	 * 	<li>Click Save</li>
	 * 	<li>Verify save dialog</li>
	 * 	<li>Click OK</li>
	 * 	<li>Go to Orders</li>
	 * 	<li>Go to Profile</li>
	 * 	<li>Verify Title text was saved</li>
	 * 	<li>Log test</li>
* </ul>
	 *
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws SQLException the SQLException
	 * @throws ClassNotFoundException the ClassNotFoundException
	 */
	@Test (retryAnalyzer = Retry.class, groups={"VMP - Profile"}, alwaysRun=true)
	public void changeTitle() throws InterruptedException, IOException, ClassNotFoundException, SQLException {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Login to VMP Client Portal
		vmp.login(driver, user, "Originator"+user, StoredVariables.getpassword().get());
		
		// Go to Profile
		vmp.goToProfile(driver);
		
		// Enter a new Title
		String title = "TestTitle " + perform.randomNumbers(driver, 5);
		VMPProfile.title_txtbx(driver).clear();
		perform.type(driver, VMPProfile.title_txtbx(driver), title);
		
		// Click Save
		perform.click(driver,VMPProfile.save_btn(driver));
		
		// Wait for overlay
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for ok button
		perform.waitForElementToBeClickable(driver, VMPProfile.ok_btn(), "cssSelector");
		
		// Verify save dialog
		Assert.assertTrue(VMPProfile.saveDialog_txt(driver).getText().contains("Your changes were successfully saved."), "Save dialog is incorrect");
		
		// Click OK
		perform.click(driver,VMPProfile.ok_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Go to Orders
		vmp.goToOrders(driver);
		
		// Go to Profile
		vmp.goToProfile(driver);
		
		// Verify Title text was saved
		Assert.assertTrue(VMPProfile.title_txtbx(driver).getAttribute("value").equals(title), "The Title did not get saved");
		
		// Log test
		test.log(LogStatus.INFO, "profile", "Verified changes get saved in the Profile section");
		
	} // end changeTitle
	
} // end the Secure_Login class
