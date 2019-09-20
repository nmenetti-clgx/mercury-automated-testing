package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure Sign Up page
 */
public class SSignUp {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;

	
	/**
	 * Type of account dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Type of Account dropdown
	public static WebElement typeOfAccount_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_wizSignUp_ctl07_ctlAccountSearchCriteria_lbType"));
		return element;
	}
	
	/**
	 * Type of account dropdown.
	 *
	 * @return the string
	 */
	public static String typeOfAccount_dropdown(){
		id = "Main_Main_Main_wizSignUp_ctl07_ctlAccountSearchCriteria_lbType";
		return id;
	}
	
	/**
	 * State dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// State dropdown
	public static WebElement state_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_wizSignUp_ctl07_ctlAccountSearchCriteria_lbState"));
		return element;
	}
	
	/**
	 * State dropdown.
	 *
	 * @return the string
	 */
	public static String state_dropdown(){
		id = "Main_Main_Main_wizSignUp_ctl07_ctlAccountSearchCriteria_lbState";
		return id;
	}
	
	/**
	 * Company name textbox.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Company Name textbox
	public static WebElement companyName_textbox(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_wizSignUp_ctl07_ctlAccountSearchCriteria_txtCompany"));
		return element;
	}
	
	/**
	 * Company name textbox.
	 *
	 * @return the string
	 */
	public static String companyName_textbox(){
		id = "Main_Main_Main_wizSignUp_ctl07_ctlAccountSearchCriteria_txtCompany";
		return id;
	}
	
	/**
	 * Phone number textbox.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Phone Number textbox
	public static WebElement phoneNumber_textbox(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_wizSignUp_ctl07_ctlAccountSearchCriteria_txtPhone"));
		return element;
	}
	
	/**
	 * Phone number textbox.
	 *
	 * @return the string
	 */
	public static String phoneNumber_textbox(){
		id = "Main_Main_Main_wizSignUp_ctl07_ctlAccountSearchCriteria_txtPhone";
		return id;
	}
	
	/**
	 * Email address textbox.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// E-mail Address textbox
	public static WebElement emailAddress_textbox(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_wizSignUp_ctl07_ctlAccountSearchCriteria_txtEmail"));
		return element;
	}
	
	/**
	 * Email address textbox.
	 *
	 * @return the string
	 */
	public static String emailAddress_textbox(){
		id = "Main_Main_Main_wizSignUp_ctl07_ctlAccountSearchCriteria_txtEmail";
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
		element = driver.findElement(By.id("Main_Main_Main_wizSignUp___CustomNav0_btnStepSignUp"));
		return element;
	}
	
	/**
	 * Next btn.
	 *
	 * @return the string
	 */
	public static String next_btn(){
		id = "Main_Main_Main_wizSignUp___CustomNav0_btnStepSignUp";
		return id;
	}
	
	/**
	 * First name txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// First Name textbox
	public static WebElement firstName_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_wizSignUp_ctl08_ctlAccountDetails_txtFirst"));
		return element;
	}
	
	/**
	 * First name txtbx.
	 *
	 * @return the string
	 */
	public static String firstName_txtbx(){
		id = "Main_Main_Main_wizSignUp_ctl08_ctlAccountDetails_txtFirst";
		return id;
	}
	
	/**
	 * Last name txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Last Name textbox
	public static WebElement lastName_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_wizSignUp_ctl08_ctlAccountDetails_txtLast"));
		return element;
	}
	
	/**
	 * Last name txtbx.
	 *
	 * @return the string
	 */
	public static String lastName_txtbx(){
		id = "Main_Main_Main_wizSignUp_ctl08_ctlAccountDetails_txtLast";
		return id;
	}
	
	/**
	 * Address txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Address textbox
	public static WebElement address_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_wizSignUp_ctl08_ctlAccountDetails_txtAddress1"));
		return element;
	}
	
	/**
	 * Address txtbx.
	 *
	 * @return the string
	 */
	public static String address_txtbx(){
		id = "Main_Main_Main_wizSignUp_ctl08_ctlAccountDetails_txtAddress1";
		return id;
	}
	
	/**
	 * City txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// City textbox
	public static WebElement city_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_wizSignUp_ctl08_ctlAccountDetails_txtCity"));
		return element;
	}
	
	/**
	 * City txtbx.
	 *
	 * @return the string
	 */
	public static String city_txtbx(){
		id = "Main_Main_Main_wizSignUp_ctl08_ctlAccountDetails_txtCity";
		return id;
	}
	
	/**
	 * Zip txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Zip textbox
	public static WebElement zip_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_wizSignUp_ctl08_ctlAccountDetails_txtZip"));
		return element;
	}
	
	/**
	 * Zip txtbx.
	 *
	 * @return the string
	 */
	public static String zip_txtbx(){
		id = "Main_Main_Main_wizSignUp_ctl08_ctlAccountDetails_txtZip";
		return id;
	}
	
	/**
	 * Appraisal volume per month dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Appraisal Volume per Month dropdown
	public static WebElement appraisalVolumePerMonth_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_wizSignUp_ctl08_ctlAccountDetails_ddlAppraisalVolPerMonth"));
		return element;
	}
	
	/**
	 * Appraisal volume per month dropdown.
	 *
	 * @return the string
	 */
	public static String appraisalVolumePerMonth_dropdown(){
		id = "Main_Main_Main_wizSignUp_ctl08_ctlAccountDetails_ddlAppraisalVolPerMonth";
		return id;
	}
	
	/**
	 * Password txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Password textbox
	public static WebElement password_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_wizSignUp_ctl08_ctlAccountDetails_txtPassword"));
		return element;
	}
	
	/**
	 * Password txtbx.
	 *
	 * @return the string
	 */
	public static String password_txtbx(){
		id = "Main_Main_Main_wizSignUp_ctl08_ctlAccountDetails_txtPassword";
		return id;
	}
	
	/**
	 * Confirm password txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Confirm Password textbox
	public static WebElement confirmPassword_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_wizSignUp_ctl08_ctlAccountDetails_txtPasswordConfirm"));
		return element;
	}
	
	/**
	 * Confirm password txtbx.
	 *
	 * @return the string
	 */
	public static String confirmPassword_txtbx(){
		id = "Main_Main_Main_wizSignUp_ctl08_ctlAccountDetails_txtPasswordConfirm";
		return id;
	}
	
	/**
	 * Next btn enter account info.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Next button on the Enter Account Info screen
	public static WebElement next_btn_EnterAccountInfo(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_wizSignUp___CustomNav2_btnStepCreate"));
		return element;
	}
	
	/**
	 * Next btn enter account info.
	 *
	 * @return the string
	 */
	public static String next_btn_EnterAccountInfo(){
		id = "Main_Main_Main_wizSignUp___CustomNav2_btnStepCreate";
		return id;
	}
	
	/**
	 * Confirmation txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Confirmation text
	public static WebElement confirmation_txt(WebDriver driver){
		element = driver.findElement(By.id("divPublicMainContent"));
		return element;
	}
	
	/**
	 * Confirmation txt.
	 *
	 * @return the string
	 */
	public static String confirmation_txt(){
		id = "divPublicMainContent";
		return id;
	}
	
	/**
	 * I agree radiobtn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// I Agree radio button
	public static WebElement iAgree_radiobtn(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_ucEULA_rbAgree"));
		return element;
	}
	
	/**
	 * I agree radiobtn.
	 *
	 * @return the string
	 */
	public static String iAgree_radiobtn(){
		id = "Main_Main_ucEULA_rbAgree";
		return id;
	}
	
	/**
	 * Continue btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Continue button
	public static WebElement continue_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_btnContinue"));
		return element;
	}
	
	/**
	 * Continue btn.
	 *
	 * @return the string
	 */
	public static String continue_btn(){
		id = "Main_Main_btnContinue";
		return id;
	}
	
	/**
	 * Security question dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Security Question dropdown
	public static WebElement securityQuestion_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ddlSecurityQuestions"));
		return element;
	}
	
	/**
	 * Security question dropdown.
	 *
	 * @return the string
	 */
	public static String securityQuestion_dropdown(){
		id = "Dialogs_Dialogs_ddlSecurityQuestions";
		return id;
	}
	
	/**
	 * Answer txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Answer textbox
	public static WebElement answer_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_txtAnswer_txtMasked"));
		return element;
	}
	
	/**
	 * Answer txtbx.
	 *
	 * @return the string
	 */
	public static String answer_txtbx(){
		id = "Dialogs_Dialogs_txtAnswer_txtMasked";
		return id;
	}
	
	/**
	 * Ok btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// OK button
	public static WebElement ok_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_btnSaveSecurityAnswer"));
		return element;
	}
	
	/**
	 * Ok btn.
	 *
	 * @return the string
	 */
	public static String ok_btn(){
		id = "Dialogs_Dialogs_btnSaveSecurityAnswer";
		return id;
	}
	
	/**
	 * Company txtbox.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Company textbox
	public static WebElement company_txtbox(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_wizSignUp_ctl08_ctlAccountDetails_txtCompany"));
		return element;
	}
	
	/**
	 * Company txtbox.
	 *
	 * @return the string
	 */
	public static String company_txtbox(){
		id = "Main_Main_Main_wizSignUp_ctl08_ctlAccountDetails_txtCompany";
		return id;
	}
	
	/**
	 * Business phone txtbox.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Business Phone textbox
	public static WebElement businessPhone_txtbox(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_wizSignUp_ctl08_ctlAccountDetails_txtPhone"));
		return element;
	}
	
	/**
	 * Business phone txtbox.
	 *
	 * @return the string
	 */
	public static String businessPhone_txtbox(){
		id = "Main_Main_Main_wizSignUp_ctl08_ctlAccountDetails_txtPhone";
		return id;
	}
	
	/**
	 * State 2 dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// State2 dropdown
	public static WebElement state2_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_wizSignUp_ctl08_ctlAccountDetails_ddlState"));
		return element;
	}
	
	/**
	 * State 2 dropdown.
	 *
	 * @return the string
	 */
	public static String state2_dropdown(){
		id = "Main_Main_Main_wizSignUp_ctl08_ctlAccountDetails_ddlState";
		return id;
	}
	
	/**
	 * Email address 2 txtbox.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// E-mail Address textbox
	public static WebElement emailAddress2_txtbox(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_wizSignUp_ctl08_ctlAccountDetails_txtEmail"));
		return element;
	}
	
	/**
	 * Email address 2 txtbox.
	 *
	 * @return the string
	 */
	public static String emailAddress2_txtbox(){
		id = "Main_Main_Main_wizSignUp_ctl08_ctlAccountDetails_txtEmail";
		return id;
	}
	
	/**
	 * I dont match any of these radiobtn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// I don't match any of these radio button
	public static WebElement iDontMatchAnyOfThese_radiobtn(WebDriver driver){
		element = driver.findElement(By.id("ExistingAccount-1"));
		return element;
	}
	
	/**
	 * I dont match any of these radiobtn.
	 *
	 * @return the string
	 */
	public static String iDontMatchAnyOfThese_radiobtn(){
		id = "ExistingAccount-1";
		return id;
	}
	
	/**
	 * Next possible duplicate btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Next button for Possible Duplicate Account Found
	public static WebElement nextPossibleDuplicate_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_wizSignUp_StepNavigationTemplateContainerID_StepNextButton"));
		return element;
	}
	
	/**
	 * Next possible duplicate btn.
	 *
	 * @return the string
	 */
	public static String nextPossibleDuplicate_btn(){
		id = "Main_Main_Main_wizSignUp_StepNavigationTemplateContainerID_StepNextButton";
		return id;
	}
	
}
