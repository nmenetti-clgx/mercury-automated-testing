package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure Modify Selection Settings page
 */
public class SModifySelectionSettings {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;

	
	/**
	 * Ok btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// OK button
	public static WebElement ok_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ctl08"));
		return element;
	}
	
	/**
	 * Ok btn.
	 *
	 * @return the string
	 */
	public static String ok_btn(){
		id = "Dialogs_Dialogs_ctl08";
		return id;
	}
	
	/**
	 * Cancel btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Cancel button
	public static WebElement cancel_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ctl07"));
		return element;
	}
	
	/**
	 * Cancel btn.
	 *
	 * @return the string
	 */
	public static String cancel_btn(){
		id = "Dialogs_Dialogs_ctl07";
		return id;
	}
	
	/**
	 * Require valid license chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Require valid license checkbox
	public static WebElement requireValidLicense_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ucRanking_chkRequireValidLicense"));
		return element;
	}
	
	/**
	 * Require valid license chkbx.
	 *
	 * @return the string
	 */
	public static String requireValidLicense_chkbx(){
		id = "Dialogs_Dialogs_ucRanking_chkRequireValidLicense";
		return id;
	}
	
	/**
	 * Require local vendor chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Require local vendor checkbox
	public static WebElement requireLocalVendor_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ucRanking_chkRequireLocalVendor"));
		return element;
	}
	
	/**
	 * Require local vendor chkbx.
	 *
	 * @return the string
	 */
	public static String requireLocalVendor_chkbx(){
		id = "Dialogs_Dialogs_ucRanking_chkRequireLocalVendor";
		return id;
	}
	
	/**
	 * Require years of experience chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Require years of experience checkbox
	public static WebElement requireYearsOfExperience_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ucRanking_chkRequireExperience"));
		return element;
	}
	
	/**
	 * Require years of experience chkbx.
	 *
	 * @return the string
	 */
	public static String requireYearsOfExperience_chkbx(){
		id = "Dialogs_Dialogs_ucRanking_chkRequireExperience";
		return id;
	}
	
	/**
	 * Require staff vendor chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Require staff vendor checkbox
	public static WebElement requireStaffVendor_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ucRanking_chkRequireStaffVendor"));
		return element;
	}
	
	/**
	 * Require staff vendor chkbx.
	 *
	 * @return the string
	 */
	public static String requireStaffVendor_chkbx(){
		id = "Dialogs_Dialogs_ucRanking_chkRequireStaffVendor";
		return id;
	}
	
	/**
	 * Require staff vendor dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Require staff vendor dropdown
	public static WebElement requireStaffVendor_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ucRanking_ddlRequireStaffVendor"));
		return element;
	}
	
	/**
	 * Require staff vendor dropdown.
	 *
	 * @return the string
	 */
	public static String requireStaffVendor_dropdown(){
		id = "Dialogs_Dialogs_ucRanking_ddlRequireStaffVendor";
		return id;
	}
	
	/**
	 * Exclude past due vendors chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Exclude past due vendors checkbox
	public static WebElement excludePastDueVendors_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ucRanking_chkExcludePastDueVendors"));
		return element;
	}
	
	/**
	 * Exclude past due vendors chkbx.
	 *
	 * @return the string
	 */
	public static String excludePastDueVendors_chkbx(){
		id = "Dialogs_Dialogs_ucRanking_chkExcludePastDueVendors";
		return id;
	}
	
	/**
	 * Require errors and omissions chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Require errors and omissions checkbox
	public static WebElement requireErrorsAndOmissions_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ucRanking_chkRequireInsurance"));
		return element;
	}
	
	/**
	 * Require errors and omissions chkbx.
	 *
	 * @return the string
	 */
	public static String requireErrorsAndOmissions_chkbx(){
		id = "Dialogs_Dialogs_ucRanking_chkRequireInsurance";
		return id;
	}
	
	/**
	 * Require vendor rating chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Require vendor rating checkbox
	public static WebElement requireVendorRating_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ucRanking_chkRequireVendorRating"));
		return element;
	}
	
	/**
	 * Require vendor rating chkbx.
	 *
	 * @return the string
	 */
	public static String requireVendorRating_chkbx(){
		id = "Dialogs_Dialogs_ucRanking_chkRequireVendorRating";
		return id;
	}
	
	/**
	 * Limit vendor capacity chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Limit vendor capacity checkbox
	public static WebElement limitVendorCapacity_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ucRanking_chkLimitVendorCapacity"));
		return element;
	}
	
	/**
	 * Limit vendor capacity chkbx.
	 *
	 * @return the string
	 */
	public static String limitVendorCapacity_chkbx(){
		id = "Dialogs_Dialogs_ucRanking_chkLimitVendorCapacity";
		return id;
	}
	
	/**
	 * Limit vendor capacity dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Limit vendor capacity dropdown
	public static WebElement limitVendorCapacity_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ucRanking_ddlLimitVendorCapacity"));
		return element;
	}
	
	/**
	 * Limit vendor capacity dropdown.
	 *
	 * @return the string
	 */
	public static String limitVendorCapacity_dropdown(){
		id = "Dialogs_Dialogs_ucRanking_ddlLimitVendorCapacity";
		return id;
	}
	
	/**
	 * Limit vendor capacity open orders txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Limit vendor capacity open orders
	public static WebElement limitVendorCapacityOpenOrders_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ucRanking_txtLimitVendorOrderCapacity"));
		return element;
	}
	
	/**
	 * Limit vendor capacity open orders txtbx.
	 *
	 * @return the string
	 */
	public static String limitVendorCapacityOpenOrders_txtbx(){
		id = "Dialogs_Dialogs_ucRanking_txtLimitVendorOrderCapacity";
		return id;
	}
	
	/**
	 * Enforce vendor priority chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Enforce vendor priority checkbox
	public static WebElement enforceVendorPriority_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ucRanking_chkEnforceVendorPriority"));
		return element;
	}
	
	/**
	 * Enforce vendor priority chkbx.
	 *
	 * @return the string
	 */
	public static String enforceVendorPriority_chkbx(){
		id = "Dialogs_Dialogs_ucRanking_chkEnforceVendorPriority";
		return id;
	}
	
	/**
	 * Double blind communication btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Double-Blind Communication button
	public static WebElement doubleBlindCommunication_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ucSetting_swDoubleBlind_imgSwitch"));
		return element;
	}
	
	/**
	 * Double blind communication btn.
	 *
	 * @return the string
	 */
	public static String doubleBlindCommunication_btn(){
		id = "Dialogs_Dialogs_ucSetting_swDoubleBlind_imgSwitch";
		return id;
	}
	
	/**
	 * Order auto reassignment btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Order Auto Reassignment button
	public static WebElement orderAutoReassignment_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ucSetting_swAutoReassign_imgSwitch"));
		return element;
	}
	
	/**
	 * Order auto reassignment btn.
	 *
	 * @return the string
	 */
	public static String orderAutoReassignment_btn(){
		id = "Dialogs_Dialogs_ucSetting_swAutoReassign_imgSwitch";
		return id;
	}
	
	/**
	 * Automatic order assignment btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Automatic Order Assignment button
	public static WebElement automaticOrderAssignment_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ucSetting_swAutoAssign_imgSwitch"));
		return element;
	}
	
	/**
	 * Automatic order assignment btn.
	 *
	 * @return the string
	 */
	public static String automaticOrderAssignment_btn(){
		id = "Dialogs_Dialogs_ucSetting_swAutoAssign_imgSwitch";
		return id;
	}
	
	/**
	 * Consider unranked vendors chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Consider unranked vendors checkbox
	public static WebElement considerUnrankedVendors_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ucRanking_chkConsiderUnranked"));
		return element;
	}
	
	/**
	 * Consider unranked vendors chkbx.
	 *
	 * @return the string
	 */
	public static String considerUnrankedVendors_chkbx(){
		id = "Dialogs_Dialogs_ucRanking_chkConsiderUnranked";
		return id;
	}
	
	/**
	 * Ok pre vendor select btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// OK button
	public static WebElement okPreVendorSelect_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_sbSelectionSettingsSave"));
		return element;
	}
	
	/**
	 * Ok pre vendor select btn.
	 *
	 * @return the string
	 */
	public static String okPreVendorSelect_btn(){
		id = "Dialogs_Dialogs_sbSelectionSettingsSave";
		return id;
	}
	
	/**
	 * Cancel pre vendor select btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Cancel button
	public static WebElement cancelPreVendorSelect_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_sbSelectionSettingsCancel"));
		return element;
	}
	
	/**
	 * Cancel pre vendor select btn.
	 *
	 * @return the string
	 */
	public static String cancelPreVendorSelect_btn(){
		id = "Dialogs_Dialogs_sbSelectionSettingsCancel";
		return id;
	}
	
	/**
	 * Located within txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// located within textbox
	public static WebElement locatedWithin_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ucRanking_txtRequireLocalVendor"));
		return element;
	}
	
	/**
	 * Located within txtbx.
	 *
	 * @return the string
	 */
	public static String locatedWithin_txtbx(){
		id = "Dialogs_Dialogs_ucRanking_txtRequireLocalVendor";
		return id;
	}
	
	/**
	 * Use supervisor chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// useSupervisor_chkbx
	public static WebElement useSupervisor_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ucRanking_chkUseSupervisor"));
		return element;
	}
	
	/**
	 * Use supervisor chkbx.
	 *
	 * @return the string
	 */
	public static String useSupervisor_chkbx(){
		id = "Dialogs_Dialogs_ucRanking_chkUseSupervisor";
		return id;
	}
	
	/**
	 * Supervisor with trainees dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// supervisorWithTrainees_dropdown
	public static WebElement supervisorWithTrainees_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ucRanking_ddlUseSupervisor"));
		return element;
	}
	
	/**
	 * Supervisor with trainees dropdown.
	 *
	 * @return the string
	 */
	public static String supervisorWithTrainees_dropdown(){
		id = "Dialogs_Dialogs_ucRanking_ddlUseSupervisor";
		return id;
	}
	
}
