package components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.VMP.VMPLogin;
import pageObjects.VMP.VMPOrders;
import pageObjects.VMP.VMPSignUp;
import setup.DriverFactory;
import setup.TestSetup;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Baseline VMP - Login</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   06-27-2019
 */

@Listeners(utils.Listener.class)
public class AR228_VMPSignUp extends TestSetup {
	
	/** The user. */
	private final String user = "RegressionSecure13";

	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get environment</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws InterruptedException the interrupted exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"VMP - Login", "AR228"}, alwaysRun=true)
	public void ar228_1_SignUpTesting() throws InterruptedException {

		// Create the driver
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Get environment
		String environment = StoredVariables.getusernameEnvironment().get();

		// Go to login page
		driver.get("https://automation" + environment + user + "." + StoredVariables.getvmpSiteSuffix().get());

		// Verify the text for the Sign Up banner reads 'Don't have a free account? Sign Up'
		String text = VMPLogin.signUp_btn(driver).getText();
		perform.verification(driver, text, "contains", "Don't have a free account?");
		perform.verification(driver, text, "contains", "Sign Up");
		
		// Click The Sign Up banner
		perform.click(driver, VMPLogin.signUp_btn(driver));
		
		// Verify a new page is loaded with the URL https://lendersxsite.vmpclientqa.com/SignUp.aspx
		String url = driver.getCurrentUrl();
		perform.verification(driver, url, "contains", "/SignUp.aspx");
		
		// Verify there is a Banner title that matches the Lender's Company Name
		perform.verification(driver, VMPSignUp.lenderCompanyName_txt(driver).getText(), "contains", user);
		
		// Verify the pod title test is 'Enter Account Information'
		perform.verification(driver, VMPSignUp.podTitle_txt(driver).getText(), "contains", "Enter Account Information");
		
		// Verify the pod instructional text is 'Enter or verify your contact information for your account and choose a username and password. Fields marked with a red asterisk (*) are required.
		String podText = VMPSignUp.pod_txt(driver).getText();
		perform.verification(driver, podText, "contains", "Enter or verify your contact information for your account and choose a username and password.");
		perform.verification(driver, podText, "contains", "Fields marked with a red asterisk (");
		perform.verification(driver, podText, "contains", "*");
		perform.verification(driver, podText, "contains", ") are required.");
		
		// Verify the following fields are marked as required with a red asterisk: Company Name, First Name, Last Name, Address, City, State, Zip, Account Type, Phone, Time Zone, E-mail, Username, Password, Confirm Password
		List<WebElement> labels = driver.findElements(By.cssSelector("td.FieldLabel"));
		perform.verification(driver, labels.get(0).getText(), "contains", "*");
		perform.verification(driver, labels.get(1).getText(), "contains", "*");
		perform.verification(driver, labels.get(2).getText(), "does not contain", "*");
		perform.verification(driver, labels.get(3).getText(), "contains", "*");
		perform.verification(driver, labels.get(4).getText(), "contains", "*");
		perform.verification(driver, labels.get(5).getText(), "does not contain", "*");
		perform.verification(driver, labels.get(6).getText(), "contains", "*");
		perform.verification(driver, labels.get(7).getText(), "contains", "*");
		perform.verification(driver, labels.get(8).getText(), "contains", "*");
		perform.verification(driver, labels.get(9).getText(), "contains", "*");
		perform.verification(driver, labels.get(10).getText(), "does not contain", "*");
		perform.verification(driver, labels.get(11).getText(), "contains", "*");
		perform.verification(driver, labels.get(12).getText(), "contains", "*");
		perform.verification(driver, labels.get(13).getText(), "contains", "*");
		perform.verification(driver, labels.get(14).getText(), "contains", "*");
		perform.verification(driver, labels.get(15).getText(), "contains", "*");
		perform.verification(driver, labels.get(16).getText(), "contains", "*");
		perform.verification(driver, labels.get(17).getText(), "does not contain", "*");
		
		// Click Next
		perform.click(driver, VMPSignUp.next_btn(driver));
		
		// Wait for the overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Verify the title bar text is 'Invalid Information'
		perform.verification(driver, VMPSignUp.summaryDialogTitle_txt(driver).getText(), "equals", "Invalid Information");
		
		// Verify the pod text is 'There is a problem with some of the information you have provided for the order. Please correct the following issues and then try again.
		perform.verification(driver, VMPSignUp.summary_dialog(driver).getText(), "contains", "There is a problem with some of the information you have provided for the order. Please correct the following issues and then try again.");
		
		// Verify there is a bullet item for each empty required field in the Sign Up form
		List<WebElement> reqItems = driver.findElements(By.cssSelector("#SummaryContent > ul > li"));
		perform.verification(driver, reqItems.get(0).getText(), "contains", "Company Name is required");
		perform.verification(driver, reqItems.get(1).getText(), "contains", "Account Type is required");
		perform.verification(driver, reqItems.get(2).getText(), "contains", "First Name is required");
		perform.verification(driver, reqItems.get(3).getText(), "contains", "Last Name is required");
		perform.verification(driver, reqItems.get(4).getText(), "contains", "Address is required");
		perform.verification(driver, reqItems.get(5).getText(), "contains", "Phone is required");
		perform.verification(driver, reqItems.get(6).getText(), "contains", "E-mail is required");
		perform.verification(driver, reqItems.get(7).getText(), "contains", "City is required");
		perform.verification(driver, reqItems.get(8).getText(), "contains", "State is required");
		perform.verification(driver, reqItems.get(9).getText(), "contains", "Zip is required");
		perform.verification(driver, reqItems.get(10).getText(), "contains", "Time Zone is required");
		perform.verification(driver, reqItems.get(11).getText(), "contains", "Username is required");
		perform.verification(driver, reqItems.get(12).getText(), "contains", "Password is required");
		
		// Click OK
		perform.click(driver, VMPSignUp.dialogOK_btn(driver));
		
		// Wait for the overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Fill out all required fields on the left hand side
		perform.type(driver, VMPSignUp.companyName_txtbx(driver), "Company Name");
		perform.type(driver, VMPSignUp.firstName_txtbx(driver), "First");
		perform.type(driver, VMPSignUp.lastName_txtbx(driver), "Last");
		perform.type(driver, VMPSignUp.address_txtbx(driver), "123 Test St.");
		perform.type(driver, VMPSignUp.city_txtbx(driver), "Yukon");
		perform.selectDropdownOption(driver, VMPSignUp.state_dropdown(driver), "Oklahoma");
		perform.type(driver, VMPSignUp.zip_txtbx(driver), "73099");
		
		// Click Next
		perform.click(driver, VMPSignUp.next_btn(driver));
		
		// Wait for the overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Verify there is a bullet item for each empty required field in the Sign Up form
		reqItems = driver.findElements(By.cssSelector("#SummaryContent > ul > li"));
		perform.verification(driver, reqItems.get(0).getText(), "contains", "Account Type is required");
		perform.verification(driver, reqItems.get(1).getText(), "contains", "Phone is required");
		perform.verification(driver, reqItems.get(2).getText(), "contains", "E-mail is required");
		perform.verification(driver, reqItems.get(3).getText(), "contains", "Time Zone is required");
		perform.verification(driver, reqItems.get(4).getText(), "contains", "Username is required");
		perform.verification(driver, reqItems.get(5).getText(), "contains", "Password is required");
		
		// Verify there is NOT a bullet item for 'Title'
		for (WebElement items : reqItems) {
			perform.verification(driver, items.getText(), "does not contain", "Title");
		} // end for

		// Click OK
		perform.click(driver, VMPSignUp.dialogOK_btn(driver));
		
		// Wait for the overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Remove all entries from the left hand side
		VMPSignUp.companyName_txtbx(driver).clear();
		VMPSignUp.firstName_txtbx(driver).clear();
		VMPSignUp.lastName_txtbx(driver).clear();
		VMPSignUp.address_txtbx(driver).clear();
		VMPSignUp.city_txtbx(driver).clear();
		perform.selectDropdownOption(driver, VMPSignUp.state_dropdown(driver), "(None Selected)");
		VMPSignUp.zip_txtbx(driver).clear();
		
		// Fill out all required fields on the right hand side
		perform.selectDropdownOption(driver, VMPSignUp.accountType_dropdown(driver), "Lender");
		perform.type(driver, VMPSignUp.phone_txtbx(driver), "4055551234");
		perform.selectDropdownOption(driver, VMPSignUp.timeZone_dropdown(driver), "Central");
		perform.type(driver, VMPSignUp.email_txtbx(driver), "test@dntest.net");
		perform.type(driver, VMPSignUp.username_txtbx(driver), "testuser12345");
		perform.type(driver, VMPSignUp.password_txtbx(driver), "T3sting1");
		perform.type(driver, VMPSignUp.confirmPassword_txtbx(driver), "T3sting1");
		
		// Click Next
		perform.click(driver, VMPSignUp.next_btn(driver));
		
		// Wait for the overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Verify there is a bullet item for each empty required field in the Sign Up form
		reqItems = driver.findElements(By.cssSelector("#SummaryContent > ul > li"));
		perform.verification(driver, reqItems.get(0).getText(), "contains", "Company Name is required");
		perform.verification(driver, reqItems.get(1).getText(), "contains", "First Name is required");
		perform.verification(driver, reqItems.get(2).getText(), "contains", "Last Name is required");
		perform.verification(driver, reqItems.get(3).getText(), "contains", "Address is required");
		perform.verification(driver, reqItems.get(4).getText(), "contains", "City is required");
		perform.verification(driver, reqItems.get(5).getText(), "contains", "State is required");
		perform.verification(driver, reqItems.get(6).getText(), "contains", "Zip is required");
		
		// Verify there is NOT a bullet item for 'Fax'
		for (WebElement items : reqItems) {
			perform.verification(driver, items.getText(), "does not contain", "Fax");
		} // end for
		
		// Log test
		perform.addInfoToExtentReport(driver, "VMP Login", "Verified the Sign Up process errors");

	} // end ar225_1_SignInAttemptWithNoPassword

	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get environment</li>
	 * 	<li>Go to login page</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws InterruptedException the interrupted exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"VMP - Login", "AR228"}, alwaysRun=true)
	public void ar228_2_PasswordValidationTesting() throws InterruptedException {

		// Create the driver
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Get environment
		String environment = StoredVariables.getusernameEnvironment().get();

		// Go to login page
		driver.get("https://automation" + environment + user + "." + StoredVariables.getvmpSiteSuffix().get());
		
		// Click The Sign Up banner
		perform.click(driver, VMPLogin.signUp_btn(driver));
		
		// Fill out all required fields except for Password and Confirm Password
		// Fill out all required fields on the left hand side
		perform.type(driver, VMPSignUp.companyName_txtbx(driver), "Company Name");
		perform.type(driver, VMPSignUp.firstName_txtbx(driver), "First");
		perform.type(driver, VMPSignUp.lastName_txtbx(driver), "Last");
		perform.type(driver, VMPSignUp.address_txtbx(driver), "123 Test St.");
		perform.type(driver, VMPSignUp.city_txtbx(driver), "Yukon");
		perform.selectDropdownOption(driver, VMPSignUp.state_dropdown(driver), "Oklahoma");
		perform.type(driver, VMPSignUp.zip_txtbx(driver), "73099");
		// Fill out all required fields on the right hand side
		perform.selectDropdownOption(driver, VMPSignUp.accountType_dropdown(driver), "Lender");
		perform.type(driver, VMPSignUp.phone_txtbx(driver), "4055551234");
		perform.selectDropdownOption(driver, VMPSignUp.timeZone_dropdown(driver), "Central");
		perform.type(driver, VMPSignUp.email_txtbx(driver), "test@dntest.net");
		String uniqueTimestamp = Long.toString(perform.getUniqueTimestamp(driver));
		perform.type(driver, VMPSignUp.username_txtbx(driver), "automationtestuser"+uniqueTimestamp);
		
		// Click Next
		perform.click(driver, VMPSignUp.next_btn(driver));
		
		// Wait for the overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Verify the title bar text is 'Invalid Information'
		perform.verification(driver, VMPSignUp.summaryDialogTitle_txt(driver).getText(), "equals", "Invalid Information");
		
		// Verify the pod text is 'There is a problem with some of the information you have provided for the order. Please correct the following issues and then try again.
		perform.verification(driver, VMPSignUp.summary_dialog(driver).getText(), "contains", "There is a problem with some of the information you have provided for the order. Please correct the following issues and then try again.");
		
		// Verify there is a bullet item for 'Password is required'
		List<WebElement> reqItems = driver.findElements(By.cssSelector("#SummaryContent > ul > li"));
		perform.verification(driver, reqItems.get(0).getText(), "contains", "Password is required");
		
		// Click OK
		perform.click(driver, VMPSignUp.dialogOK_btn(driver));
		
		// Wait for the overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Enter 'password' for the Password and Confirm Password
		perform.type(driver, VMPSignUp.password_txtbx(driver), "password");
		perform.type(driver, VMPSignUp.confirmPassword_txtbx(driver), "password");
		
		// Verify the Password Strength shows weak
		System.out.println("style: " + VMPSignUp.passwordStrength1(driver).getAttribute("style"));
		perform.verification(driver, VMPSignUp.passwordStrength1(driver).getText(), "equals", "Weak");
		perform.verification(driver, VMPSignUp.passwordStrength1(driver).getAttribute("style"), "contains", "display: inline;");
		
		// Click Next
		perform.click(driver, VMPSignUp.next_btn(driver));
		
		// Wait for the overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Verify an Invalid Information window is displayed
		perform.verification(driver, VMPSignUp.summaryDialogTitle_txt(driver).getText(), "equals", "Invalid Information");
		
		// Verify the pod text is 'There is a problem with some of the information you have provided for the order. Please correct the following issues and then try again.
		perform.verification(driver, VMPSignUp.summary_dialog(driver).getText(), "contains", "There is a problem with some of the information you have provided for the order. Please correct the following issues and then try again.");
		
		// Verify there is a bullet item with the following text 'Your password must be at least 8 characters long and contain at least 3 of the following: uppercase letters, lowercase letters, numbers and special characters'
		reqItems = driver.findElements(By.cssSelector("#SummaryContent > ul > li"));
		perform.verification(driver, reqItems.get(0).getText(), "contains", "Your password must be at least 8 characters long and contain at least 3 of the following: uppercase letters, lowercase letters, numbers and special characters.");
		
		// Click OK
		perform.click(driver, VMPSignUp.dialogOK_btn(driver));
		
		// Wait for the overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Enter 'Password' for the Password and Confirm Password
		VMPSignUp.password_txtbx(driver).clear();
		VMPSignUp.confirmPassword_txtbx(driver).clear();
		perform.type(driver, VMPSignUp.password_txtbx(driver), "Password");
		perform.type(driver, VMPSignUp.confirmPassword_txtbx(driver), "Password");
		
		// Verify the Password Strength shows Medium
		perform.verification(driver, VMPSignUp.passwordStrength2(driver).getText(), "equals", "Medium");
		perform.verification(driver, VMPSignUp.passwordStrength2(driver).getAttribute("style"), "contains", "display: inline;");
		
		// Click Next
		perform.click(driver, VMPSignUp.next_btn(driver));
		
		// Wait for the overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Verify an Invalid Information window is displayed
		perform.verification(driver, VMPSignUp.summaryDialogTitle_txt(driver).getText(), "equals", "Invalid Information");
		
		// Verify the pod text is 'There is a problem with some of the information you have provided for the order. Please correct the following issues and then try again.
		perform.verification(driver, VMPSignUp.summary_dialog(driver).getText(), "contains", "There is a problem with some of the information you have provided for the order. Please correct the following issues and then try again.");
		
		// Verify there is a bullet item with the following text 'Your password must be at least 8 characters long and contain at least 3 of the following: uppercase letters, lowercase letters, numbers and special characters'
		reqItems = driver.findElements(By.cssSelector("#SummaryContent > ul > li"));
		perform.verification(driver, reqItems.get(0).getText(), "contains", "Your password must be at least 8 characters long and contain at least 3 of the following: uppercase letters, lowercase letters, numbers and special characters.");
		
		// Click OK
		perform.click(driver, VMPSignUp.dialogOK_btn(driver));
		
		// Wait for the overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Enter Password1! for the Password only (leave previous password in Confirm Password)
		VMPSignUp.password_txtbx(driver).clear();
		VMPSignUp.confirmPassword_txtbx(driver).clear();
		perform.type(driver, VMPSignUp.password_txtbx(driver), "Password1!");
		
		// Verify the Password Strength shows Strong
		perform.verification(driver, VMPSignUp.passwordStrength3(driver).getText(), "equals", "Strong");
		perform.verification(driver, VMPSignUp.passwordStrength3(driver).getAttribute("style"), "contains", "display: inline;");
		
		// Click Next
		perform.click(driver, VMPSignUp.next_btn(driver));
		
		// Wait for the overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Verify an Invalid Information window is displayed
		perform.verification(driver, VMPSignUp.summaryDialogTitle_txt(driver).getText(), "equals", "Invalid Information");
		
		// Verify the pod text is 'There is a problem with some of the information you have provided for the order. Please correct the following issues and try again.'
		perform.verification(driver, VMPSignUp.summary_dialog(driver).getText(), "contains", "There is a problem with some of the information you have provided for the order. Please correct the following issues and then try again.");
		
		// Verify the bullet item test is 'Your passwords do not match'
		reqItems = driver.findElements(By.cssSelector("#SummaryContent > ul > li"));
		perform.verification(driver, reqItems.get(0).getText(), "contains", "");
		
		// Click OK
		perform.click(driver, VMPSignUp.dialogOK_btn(driver));
		
		// Wait for the overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Enter Password1! for the Confirm Password
		perform.type(driver, VMPSignUp.confirmPassword_txtbx(driver), "Password1!");
		
		// Click Next
		perform.click(driver, VMPSignUp.next_btn(driver));
		
		// Wait for the overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);

		// Click the Find textbox to ensure you are on the correct page
		perform.click(driver, VMPOrders.find_txtbx(driver));
		
		// Verify you are logged into the newly created Client Account
		perform.verification(driver, driver.getCurrentUrl(), "contains", "/Admin/OrderManagement/Orders.aspx");
		
		// Log test
		perform.addInfoToExtentReport(driver, "VMP Login", "Verified password strengths and that you can successfully create an account");

	} // end ar225_2_SignInAttemptWithInvalidPassword
	
} // end the Secure_Login class
