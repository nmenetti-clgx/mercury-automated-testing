package pageObjects.VMP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the VMP Sign Up page
 */
public class VMPSignUp {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	/** The cssSelector. */
	private static String cssSelector = null;

	
	/**
	 * Company name txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Company Name
	public static WebElement companyName_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtCompanyName"));
		return element;
	}
	
	/**
	 * Company name txtbx.
	 *
	 * @return the string
	 */
	public static String companyName_txtbx(){
		id = "ctl00_ctl00_Main_Main_txtCompanyName";
		return id;
	}
	
	/**
	 * First name txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// First Name
	public static WebElement firstName_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtFirstName"));
		return element;
	}
	
	/**
	 * First name txtbx.
	 *
	 * @return the string
	 */
	public static String firstName_txtbx(){
		id = "ctl00_ctl00_Main_Main_txtFirstName";
		return id;
	}
	
	/**
	 * Last name txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Last Name
	public static WebElement lastName_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtLastName"));
		return element;
	}
	
	/**
	 * Last name txtbx.
	 *
	 * @return the string
	 */
	public static String lastName_txtbx(){
		id = "ctl00_ctl00_Main_Main_txtLastName";
		return id;
	}
	
	/**
	 * Address txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Address
	public static WebElement address_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtAddress1"));
		return element;
	}
	
	/**
	 * Address txtbx.
	 *
	 * @return the string
	 */
	public static String address_txtbx(){
		id = "ctl00_ctl00_Main_Main_txtAddress1";
		return id;
	}
	
	/**
	 * City txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// City
	public static WebElement city_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtCity"));
		return element;
	}
	
	/**
	 * City txtbx.
	 *
	 * @return the string
	 */
	public static String city_txtbx(){
		id = "ctl00_ctl00_Main_Main_txtCity";
		return id;
	}
	
	/**
	 * State dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// State
	public static WebElement state_dropdown(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_ddlState"));
		return element;
	}
	
	/**
	 * State dropdown.
	 *
	 * @return the string
	 */
	public static String state_dropdown(){
		id = "ctl00_ctl00_Main_Main_ddlState";
		return id;
	}
	
	/**
	 * Zip txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Zip
	public static WebElement zip_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtZip"));
		return element;
	}
	
	/**
	 * Zip txtbx.
	 *
	 * @return the string
	 */
	public static String zip_txtbx(){
		id = "ctl00_ctl00_Main_Main_txtZip";
		return id;
	}
	
	/**
	 * Account type dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Account Type
	public static WebElement accountType_dropdown(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_ddlType"));
		return element;
	}
	
	/**
	 * Account type dropdown.
	 *
	 * @return the string
	 */
	public static String accountType_dropdown(){
		id = "ctl00_ctl00_Main_Main_ddlType";
		return id;
	}
	
	/**
	 * Phone txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Phone
	public static WebElement phone_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtPhone"));
		return element;
	}
	
	/**
	 * Phone txtbx.
	 *
	 * @return the string
	 */
	public static String phone_txtbx(){
		id = "ctl00_ctl00_Main_Main_txtPhone";
		return id;
	}
	
	/**
	 * Time zone dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Time Zone
	public static WebElement timeZone_dropdown(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_ddlTimezone"));
		return element;
	}
	
	/**
	 * Time zone dropdown.
	 *
	 * @return the string
	 */
	public static String timeZone_dropdown(){
		id = "ctl00_ctl00_Main_Main_ddlTimezone";
		return id;
	}
	
	/**
	 * Email txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Email
	public static WebElement email_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtEmail"));
		return element;
	}
	
	/**
	 * Email txtbx.
	 *
	 * @return the string
	 */
	public static String email_txtbx(){
		id = "ctl00_ctl00_Main_Main_txtEmail";
		return id;
	}
	
	/**
	 * Username txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Username
	public static WebElement username_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtUserName"));
		return element;
	}
	
	/**
	 * Username txtbx.
	 *
	 * @return the string
	 */
	public static String username_txtbx(){
		id = "ctl00_ctl00_Main_Main_txtUserName";
		return id;
	}
	
	/**
	 * Password txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Password
	public static WebElement password_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtPassword"));
		return element;
	}
	
	/**
	 * Password txtbx.
	 *
	 * @return the string
	 */
	public static String password_txtbx(){
		id = "ctl00_ctl00_Main_Main_txtPassword";
		return id;
	}
	
	/**
	 * Confirm password txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Confirm Password
	public static WebElement confirmPassword_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtPasswordConfirm"));
		return element;
	}
	
	/**
	 * Confirm password txtbx.
	 *
	 * @return the string
	 */
	public static String confirmPassword_txtbx(){
		id = "ctl00_ctl00_Main_Main_txtPasswordConfirm";
		return id;
	}
	
	/**
	 * Next btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Next button
	public static WebElement next_btn(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_btnNext"));
		return element;
	}
	
	/**
	 * Next btn.
	 *
	 * @return the string
	 */
	public static String next_btn(){
		id = "ctl00_ctl00_Main_Main_btnNext";
		return id;
	}
	
	/**
	 * Lender Company Name text.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement lenderCompanyName_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector(".Header"));
		return element;
	}
	
	/**
	 * Lender Company Name text.
	 *
	 * @return the string
	 */
	public static String lenderCompanyName_txt(){
		cssSelector = ".Header";
		return cssSelector;
	}
	
	/**
	 * Pod title text.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement podTitle_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector(".GroupHeader"));
		return element;
	}
	
	/**
	 * Pod title text.
	 *
	 * @return the string
	 */
	public static String podTitle_txt(){
		cssSelector = ".GroupHeader";
		return cssSelector;
	}
	
	/**
	 * Pod text.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement pod_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector(".PaperContent"));
		return element;
	}
	
	/**
	 * Pod text.
	 *
	 * @return the string
	 */
	public static String pod_txt(){
		cssSelector = ".PaperContent";
		return cssSelector;
	}
	
	/**
	 * Summary dialog.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Next button
	public static WebElement summary_dialog(WebDriver driver){
		element = driver.findElement(By.id("SummaryDialog"));
		return element;
	}
	
	/**
	 * Summary dialog.
	 *
	 * @return the string
	 */
	public static String summary_dialog(){
		id = "SummaryDialog";
		return id;
	}
	
	/**
	 * Summary dialog title text.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Next button
	public static WebElement summaryDialogTitle_txt(WebDriver driver){
		element = driver.findElement(By.id("SummaryDialogTitle"));
		return element;
	}
	
	/**
	 * Summary dialog title text.
	 *
	 * @return the string
	 */
	public static String summaryDialogTitle_txt(){
		id = "SummaryDialogTitle";
		return id;
	}

	/**
	 * Dialog OK button.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement dialogOK_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("input[type='button'][value='OK'][onclick='javascript:HideSummaryDialog();']"));
		return element;
	}
	
	/**
	 * Dialog OK button.
	 *
	 * @return the string
	 */
	public static String dialogOK_btn(){
		cssSelector = "input[type='button'][value='OK'][onclick='javascript:HideSummaryDialog();']";
		return cssSelector;
	}
	
	/**
	 * Password strength 1
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement passwordStrength1(WebDriver driver){
		element = driver.findElement(By.id("idSMT1"));
		return element;
	}
	
	/**
	 * Password strength 2
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement passwordStrength2(WebDriver driver){
		element = driver.findElement(By.id("idSMT2"));
		return element;
	}
	
	/**
	 * Password strength 3
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement passwordStrength3(WebDriver driver){
		element = driver.findElement(By.id("idSMT3"));
		return element;
	}
	
	/**
	 * Password strength 4
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement passwordStrength4(WebDriver driver){
		element = driver.findElement(By.id("idSMT4"));
		return element;
	}
	
}
