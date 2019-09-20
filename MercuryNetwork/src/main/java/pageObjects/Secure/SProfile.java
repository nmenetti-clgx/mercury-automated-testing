package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure Profile page
 */
public class SProfile {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	/** The cssSelector. */
	private static String cssSelector = null;

	
	/**
	 * General tab.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// General tab
	public static WebElement general_tab(WebDriver driver){
		element = driver.findElement(By.id("tabGeneral"));
		return element;
	}
	
	/**
	 * General tab.
	 *
	 * @return the string
	 */
	public static String general_tab(){
		id = "tabGeneral";
		return id;
	}
	
	/**
	 * Assignment tab.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Assignment tab
	public static WebElement assignment_tab(WebDriver driver){
		element = driver.findElement(By.id("tabAssignment"));
		return element;
	}
	
	/**
	 * Assignment tab.
	 *
	 * @return the string
	 */
	public static String assignment_tab(){
		id = "tabAssignment";
		return id;
	}
	
	/**
	 * Products tab.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Products tab
	public static WebElement products_tab(WebDriver driver){
		element = driver.findElement(By.id("tabProducts"));
		return element;
	}
	
	/**
	 * Products tab.
	 *
	 * @return the string
	 */
	public static String products_tab(){
		id = "tabProducts";
		return id;
	}
	
	/**
	 * Coverage tab.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Coverage tab
	public static WebElement coverage_tab(WebDriver driver){
		element = driver.findElement(By.id("tabCoverage"));
		return element;
	}
	
	/**
	 * Coverage tab.
	 *
	 * @return the string
	 */
	public static String coverage_tab(){
		id = "tabCoverage";
		return id;
	}
	
	/**
	 * Statistics tab.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Statistics tab
	public static WebElement statistics_tab(WebDriver driver){
		element = driver.findElement(By.id("tabStatistics"));
		return element;
	}
	
	/**
	 * Statistics tab.
	 *
	 * @return the string
	 */
	public static String statistics_tab(){
		id = "tabStatistics";
		return id;
	}
	
	/**
	 * Ratings tab.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Ratings tab
	public static WebElement ratings_tab(WebDriver driver){
		element = driver.findElement(By.id("tabRatings"));
		return element;
	}
	
	/**
	 * Ratings tab.
	 *
	 * @return the string
	 */
	public static String ratings_tab(){
		id = "tabRatings";
		return id;
	}
	
	/**
	 * Notes tab.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Notes tab
	public static WebElement notes_tab(WebDriver driver){
		element = driver.findElement(By.id("tabNotes"));
		return element;
	}
	
	/**
	 * Notes tab.
	 *
	 * @return the string
	 */
	public static String notes_tab(){
		id = "tabNotes";
		return id;
	}
	
	/**
	 * Staff salaried vendor chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Staff/Salaried Vendor checkbox
	public static WebElement staffSalariedVendor_chkbx(WebDriver driver){
		element = driver.findElement(By.id("chkStaffVendor"));
		return element;
	}
	
	/**
	 * Staff salaried vendor chkbx.
	 *
	 * @return the string
	 */
	public static String staffSalariedVendor_chkbx(){
		id = "chkStaffVendor";
		return id;
	}
	
	/**
	 * Do not show order fee on assignment chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Do not show order fee on assignment checkbox
	public static WebElement doNotShowOrderFeeOnAssignment_chkbx(WebDriver driver){
		element = driver.findElement(By.id("chkHideOrderFee"));
		return element;
	}
	
	/**
	 * Do not show order fee on assignment chkbx.
	 *
	 * @return the string
	 */
	public static String doNotShowOrderFeeOnAssignment_chkbx(){
		id = "chkHideOrderFee";
		return id;
	}
	
	/**
	 * Vendor priority dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Vendor priority dropdown
	public static WebElement vendorPriority_dropdown(WebDriver driver){
		element = driver.findElement(By.id("ddlVendorPriority"));
		return element;
	}
	
	/**
	 * Vendor priority dropdown.
	 *
	 * @return the string
	 */
	public static String vendorPriority_dropdown(){
		id = "ddlVendorPriority";
		return id;
	}
	
	/**
	 * Save btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Save button
	public static WebElement save_btn(WebDriver driver){
		element = driver.findElement(By.id("btnOK"));
		return element;
	}
	
	/**
	 * Save btn.
	 *
	 * @return the string
	 */
	public static String save_btn(){
		id = "btnOK";
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
		element = driver.findElement(By.id("btnCancel"));
		return element;
	}
	
	/**
	 * Cancel btn.
	 *
	 * @return the string
	 */
	public static String cancel_btn(){
		id = "btnCancel";
		return id;
	}
	
	/**
	 * Notes txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Notes text
	public static WebElement notes_txt(WebDriver driver){
		element = driver.findElement(By.id("NotesBox"));
		return element;
	}
	
	/**
	 * Notes txt.
	 *
	 * @return the string
	 */
	public static String notes_txt(){
		id = "NotesBox";
		return id;
	}
	
	/**
	 * Notes first row txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement notesFirstRow_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector("#NotesBox > div:nth-child(1) > div > div:nth-child(1)"));
		return element;
	}
	
	/**
	 * Notes first row txt.
	 *
	 * @return the string
	 */
	public static String notesFirstRow_txt(){
		cssSelector = "#NotesBox > div:nth-child(1) > div > div:nth-child(1)";
		return cssSelector;
	}
	
	/**
	 * Capacity txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Capacity textbox
	public static WebElement capacity_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_txtCapacity"));
		return element;
	}
	
	/**
	 * Capacity txtbx.
	 *
	 * @return the string
	 */
	public static String capacity_txtbx(){
		id = "Main_txtCapacity";
		return id;
	}
	
	/**
	 * Adds the to fee panel btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Add to fee panel button
	public static WebElement addToFeePanel_btn(WebDriver driver){
		element = driver.findElement(By.id("btnAddRemoveFeePanel"));
		return element;
	}
	
	/**
	 * Adds the to fee panel btn.
	 *
	 * @return the string
	 */
	public static String addToFeePanel_btn(){
		id = "btnAddRemoveFeePanel";
		return id;
	}
	
	/**
	 * Always pay the transaction fee for this vendor chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Always pay the transaction fee for this vendor checkbox
	public static WebElement alwaysPayTheTransactionFeeForThisVendor_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_AlwaysPayCheckbox"));
		return element;
	}
	
	/**
	 * Always pay the transaction fee for this vendor chkbx.
	 *
	 * @return the string
	 */
	public static String alwaysPayTheTransactionFeeForThisVendor_chkbx(){
		id = "Main_AlwaysPayCheckbox";
		return id;
	}
	
	/**
	 * Primary phone txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Primary Phone text
	public static WebElement primaryPhone_txt(WebDriver driver){
		element = driver.findElement(By.id("PrimaryPhone"));
		return element;
	}
	
	/**
	 * Primary phone txt.
	 *
	 * @return the string
	 */
	public static String primaryPhone_txt(){
		id = "PrimaryPhone";
		return id;
	}
	
	/**
	 * Profile txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Profile text
	public static WebElement profile_txt(WebDriver driver){
		element = driver.findElement(By.id("divTabContainer"));
		return element;
	}
	
	/**
	 * Profile txt.
	 *
	 * @return the string
	 */
	public static String profile_txt(){
		id = "divTabContainer";
		return id;
	}
	
}
