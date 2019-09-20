package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import setup.TestSetup;

/**
 * The elements on the Secure Connection Settings page
 */
public class SConnectionSettings extends TestSetup{
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	/** The css selector. */
	private static String cssSelector = null;

	
	/**
	 * Direct integration user I D txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Direct Integration User ID textbox
	public static WebElement directIntegrationUserID_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_txtUCDPUserID"));
		return element;
	}
	
	/**
	 * Direct integration user I D txtbx.
	 *
	 * @return the string
	 */
	public static String directIntegrationUserID_txtbx(){
		id = "Main_Main_txtUCDPUserID";
		return id;
	}
	
	/**
	 * Direct integration password txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Direct Integration Password textbox
	public static WebElement directIntegrationPassword_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_txtUCDPPassword"));
		return element;
	}
	
	/**
	 * Direct integration password txtbx.
	 *
	 * @return the string
	 */
	public static String directIntegrationPassword_txtbx(){
		id = "Main_Main_txtUCDPPassword";
		return id;
	}
	
	/**
	 * Direct integration user IDFH A txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// FHA Direct Integration User ID textbox
	public static WebElement directIntegrationUserIDFHA_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_txtFHAUserID"));
		return element;
	}
	
	/**
	 * Direct integration user IDFH A txtbx.
	 *
	 * @return the string
	 */
	public static String directIntegrationUserIDFHA_txtbx(){
		id = "Main_Main_txtFHAUserID";
		return id;
	}
	
	/**
	 * Direct integration password FH A txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// FHA Direct Integration Password textbox
	public static WebElement directIntegrationPasswordFHA_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_txtFHAPassword"));
		return element;
	}
	
	/**
	 * Direct integration password FH A txtbx.
	 *
	 * @return the string
	 */
	public static String directIntegrationPasswordFHA_txtbx(){
		id = "Main_Main_txtFHAPassword";
		return id;
	}
	
	/**
	 * Connection settings txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Connection Settings text
	public static WebElement connectionSettings_txt(WebDriver driver){
		element = driver.findElement(By.id("divAdminMain"));
		return element;
	}
	
	/**
	 * Connection settings txt.
	 *
	 * @return the string
	 */
	public static String connectionSettings_txt(){
		id = "divAdminMain";
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
		element = driver.findElement(By.cssSelector("img[src='Images/Save16x16.png']"));
		return element;
	}
	
	/**
	 * Save btn.
	 *
	 * @return the string
	 */
	public static String save_btn(){
		cssSelector = "img[src='Images/Save16x16.png']";
		return cssSelector;
	}
	
	/**
	 * Adds the btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Add button
	public static WebElement add_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='Images/NewProductIcon16x16.png']"));
		return element;
	}
	
	/**
	 * Adds the btn.
	 *
	 * @return the string
	 */
	public static String add_btn(){
		cssSelector = "img[src='Images/NewProductIcon16x16.png']";
		return cssSelector;
	}
	
	/**
	 * Ucdp business unit btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// UCDP Business Unit button
	public static WebElement ucdpBusinessUnit_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("td[onclick='if(toolbar_UCDPBusinessUnit_Add() != false){document.getElementById(\'Main_Main_tbMain_ctl02\').click();}']"));
		return element;
	}
	
	/**
	 * Ucdp business unit btn.
	 *
	 * @return the string
	 */
	public static String ucdpBusinessUnit_btn(){
		cssSelector = "td[onclick='if(toolbar_UCDPBusinessUnit_Add() != false){document.getElementById(\'Main_Main_tbMain_ctl02\').click();}']";
		return cssSelector;
	}
	
	/**
	 * Fha business unit btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// FHA Business Unit button
	public static WebElement fhaBusinessUnit_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("td[onclick='if(toolbar_FHABusinessUnit_Add() != false){document.getElementById(\'Main_Main_tbMain_ctl02\').click();}']"));
		return element;
	}
	
	/**
	 * Fha business unit btn.
	 *
	 * @return the string
	 */
	public static String fhaBusinessUnit_btn(){
		cssSelector = "td[onclick='if(toolbar_FHABusinessUnit_Add() != false){document.getElementById(\'Main_Main_tbMain_ctl02\').click();}']";
		return cssSelector;
	}
	
	/**
	 * Ok save btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// OK Save button
	public static WebElement okSave_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("input[onclick='javascript:HideAlert();']"));
		return element;
	}
	
	/**
	 * Ok save btn.
	 *
	 * @return the string
	 */
	public static String okSave_btn(){
		cssSelector = "input[onclick='javascript:HideAlert();']";
		return cssSelector;
	}
	
	/**
	 * Save dialog txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Save dialog text
	public static WebElement saveDialog_txt(WebDriver driver){
		element = driver.findElement(By.id("AlertDialog"));
		return element;
	}
	
	/**
	 * Save dialog txt.
	 *
	 * @return the string
	 */
	public static String saveDialog_txt(){
		id = "AlertDialog";
		return id;
	}
	
	/**
	 * Dialog add business unit txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Add Business Unit dialog text
	public static WebElement dialogAddBusinessUnit_txt(WebDriver driver){
		element = driver.findElement(By.id("divAddUCDPBusinessUnit"));
		return element;
	}
	
	/**
	 * Dialog add business unit txt.
	 *
	 * @return the string
	 */
	public static String dialogAddBusinessUnit_txt(){
		id = "divAddUCDPBusinessUnit";
		return id;
	}
	
	/**
	 * Business unit name txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Business Unit Name textbox
	public static WebElement businessUnitName_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_txtUCDPBusinessUnitName"));
		return element;
	}
	
	/**
	 * Business unit name txtbx.
	 *
	 * @return the string
	 */
	public static String businessUnitName_txtbx(){
		id = "Dialogs_Dialogs_txtUCDPBusinessUnitName";
		return id;
	}
	
	/**
	 * Business unit number txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Business Unit Number textbox
	public static WebElement businessUnitNumber_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_txtUCDPBusinessUnitNumber"));
		return element;
	}
	
	/**
	 * Business unit number txtbx.
	 *
	 * @return the string
	 */
	public static String businessUnitNumber_txtbx(){
		id = "Dialogs_Dialogs_txtUCDPBusinessUnitNumber";
		return id;
	}
	
	/**
	 * Fnm I D txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// FNM ID textbox
	public static WebElement fnmID_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_txtUCDPBusinessUnitFNMSSN"));
		return element;
	}
	
	/**
	 * Fnm I D txtbx.
	 *
	 * @return the string
	 */
	public static String fnmID_txtbx(){
		id = "Dialogs_Dialogs_txtUCDPBusinessUnitFNMSSN";
		return id;
	}
	
	/**
	 * Fre number txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// FRE Number textbox
	public static WebElement freNumber_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_txtUCDPBusinessUnitFRESSN"));
		return element;
	}
	
	/**
	 * Fre number txtbx.
	 *
	 * @return the string
	 */
	public static String freNumber_txtbx(){
		id = "Dialogs_Dialogs_txtUCDPBusinessUnitFRESSN";
		return id;
	}
	
	/**
	 * Ok business unit btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// OK Business Unit button
	public static WebElement okBusinessUnit_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("input[onclick='javascript:UCDPBusinessUnit_Update();']"));
		return element;
	}
	
	/**
	 * Ok business unit btn.
	 *
	 * @return the string
	 */
	public static String okBusinessUnit_btn(){
		cssSelector = "input[onclick='javascript:UCDPBusinessUnit_Update();']";
		return cssSelector;
	}
	
	/**
	 * Ucdp business units txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// UCDP Business Units text
	public static WebElement ucdpBusinessUnits_txt(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_grdUCDPBusinessUnits"));
		return element;
	}
	
	/**
	 * Ucdp business units txt.
	 *
	 * @return the string
	 */
	public static String ucdpBusinessUnits_txt(){
		id = "Main_Main_grdUCDPBusinessUnits";
		return id;
	}
	
	/**
	 * Ok FHA business unit btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// OK FHA Business Unit button
	public static WebElement okFHABusinessUnit_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("input[onclick='javascript:FHABusinessUnit_Update();']"));
		return element;
	}
	
	/**
	 * Ok FHA business unit btn.
	 *
	 * @return the string
	 */
	public static String okFHABusinessUnit_btn(){
		cssSelector = "input[onclick='javascript:FHABusinessUnit_Update();']";
		return cssSelector;
	}
	
	/**
	 * Dialog add FHA business unit txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Add FHA Business Unit dialog text
	public static WebElement dialogAddFHABusinessUnit_txt(WebDriver driver){
		element = driver.findElement(By.id("divAddFHABusinessUnit"));
		return element;
	}
	
	/**
	 * Dialog FHA add business unit txt.
	 *
	 * @return the string
	 */
	public static String dialogFHAAddBusinessUnit_txt(){
		id = "divAddFHABusinessUnit";
		return id;
	}
	
	/**
	 * Business unit name FH A txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// FHA Business Unit Name textbox
	public static WebElement businessUnitNameFHA_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_txtFHABusinessUnitName"));
		return element;
	}
	
	/**
	 * Business unit name FH A txtbx.
	 *
	 * @return the string
	 */
	public static String businessUnitNameFHA_txtbx(){
		id = "Dialogs_Dialogs_txtFHABusinessUnitName";
		return id;
	}
	
	/**
	 * Business unit number FH A txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// FHA Business Unit Number textbox
	public static WebElement businessUnitNumberFHA_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_txtFHABusinessUnitNumber"));
		return element;
	}
	
	/**
	 * Business unit number FH A txtbx.
	 *
	 * @return the string
	 */
	public static String businessUnitNumberFHA_txtbx(){
		id = "Dialogs_Dialogs_txtFHABusinessUnitNumber";
		return id;
	}
	
	/**
	 * Fha lender I D txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// FHA Lender ID textbox
	public static WebElement fhaLenderID_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_txtFHALenderID"));
		return element;
	}
	
	/**
	 * Fha lender I D txtbx.
	 *
	 * @return the string
	 */
	public static String fhaLenderID_txtbx(){
		id = "Dialogs_Dialogs_txtFHALenderID";
		return id;
	}
	
	/**
	 * Fha business units txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// FHA Business Units text
	public static WebElement fhaBusinessUnits_txt(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_grdFHABusinessUnits"));
		return element;
	}
	
	/**
	 * Fha business units txt.
	 *
	 * @return the string
	 */
	public static String fhaBusinessUnits_txt(){
		id = "Main_Main_grdFHABusinessUnits";
		return id;
	}
	
	/**
	 * Removes the business unit btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Remove Business Unit button
	public static WebElement removeBusinessUnit_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='Images/DeleteIcon16x16.png']"));
		return element;
	}
	
	/**
	 * Removes the business unit btn.
	 *
	 * @return the string
	 */
	public static String removeBusinessUnit_btn(){
		cssSelector = "img[src='Images/DeleteIcon16x16.png']";
		return cssSelector;
	}
	
	/**
	 * Confirm delete txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Confirm delete text
	public static WebElement confirmDelete_txt(WebDriver driver){
		element = driver.findElement(By.id("tdUCDPBusinessUnitConfirmDelete"));
		return element;
	}
	
	/**
	 * Confirm delete txt.
	 *
	 * @return the string
	 */
	public static String confirmDelete_txt(){
		id = "tdUCDPBusinessUnitConfirmDelete";
		return id;
	}
	
	/**
	 * Yes delete btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Yes delete button
	public static WebElement yesDelete_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("input[onclick='javascript:UCDPBusinessUnit_Remove();']"));
		return element;
	}
	
	/**
	 * Yes delete btn.
	 *
	 * @return the string
	 */
	public static String yesDelete_btn(){
		cssSelector = "input[onclick='javascript:UCDPBusinessUnit_Remove();']";
		return cssSelector;
	}
	
	/**
	 * Confirm delete FH A txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Confirm delete text
	public static WebElement confirmDeleteFHA_txt(WebDriver driver){
		element = driver.findElement(By.id("tdFHABusinessUnitConfirmDelete"));
		return element;
	}
	
	/**
	 * Confirm delete FH A txt.
	 *
	 * @return the string
	 */
	public static String confirmDeleteFHA_txt(){
		id = "tdFHABusinessUnitConfirmDelete";
		return id;
	}
	
	/**
	 * Yes delete FH A btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Yes delete FHA button
	public static WebElement yesDeleteFHA_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("input[onclick='javascript:FHABusinessUnit_Remove();']"));
		return element;
	}
	
	/**
	 * Yes delete FH A btn.
	 *
	 * @return the string
	 */
	public static String yesDeleteFHA_btn(){
		cssSelector = "input[onclick='javascript:FHABusinessUnit_Remove();']";
		return cssSelector;
	}
	
	/**
	 * Automatically submit to FH A chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Automatically submit to FHA checkbox
	public static WebElement automaticallySubmitToFHA_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_chkFHAAutoSubmit"));
		return element;
	}
	
	/**
	 * Automatically submit to FH A chkbx.
	 *
	 * @return the string
	 */
	public static String automaticallySubmitToFHA_chkbx(){
		id = "Main_Main_chkFHAAutoSubmit";
		return id;
	}
	
	/**
	 * Automatically submit to FH A dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Automatically submit to FHA dropdown
	public static WebElement automaticallySubmitToFHA_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_ddlFHAAutoSubmitFrequency"));
		return element;
	}
	
	/**
	 * Automatically submit to FH A dropdown.
	 *
	 * @return the string
	 */
	public static String automaticallySubmitToFHA_dropdown(){
		id = "Main_Main_ddlFHAAutoSubmitFrequency";
		return id;
	}
	
	/**
	 * An orders status changesto dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// An order's status changes to dropdown
	public static WebElement anOrdersStatusChangesto_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_ddlFHAAutoSubmitStatus"));
		return element;
	}
	
	/**
	 * An orders status changesto dropdown.
	 *
	 * @return the string
	 */
	public static String anOrdersStatusChangesto_dropdown(){
		id = "Main_Main_ddlFHAAutoSubmitStatus";
		return id;
	}
	
	/**
	 * For all orders dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// For all orders dropdown
	public static WebElement forAllOrders_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_ddlSureReceiptsFrequency"));
		return element;
	}
	
	/**
	 * For all orders dropdown.
	 *
	 * @return the string
	 */
	public static String forAllOrders_dropdown(){
		id = "Main_Main_ddlSureReceiptsFrequency";
		return id;
	}
	
	/**
	 * Automatically send the selected appraisal products to the borrower dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Automatically Send The Selected Appraisal Products To The Borrower dropdown
	public static WebElement automaticallySendTheSelectedAppraisalProductsToTheBorrower_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_ddlSureReceiptsDelay"));
		return element;
	}
	
	/**
	 * Automatically send the selected appraisal products to the borrower dropdown.
	 *
	 * @return the string
	 */
	public static String automaticallySendTheSelectedAppraisalProductsToTheBorrower_dropdown(){
		id = "Main_Main_ddlSureReceiptsDelay";
		return id;
	}
	
	/**
	 * Comments to borrower txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Comments to borrower textbox
	public static WebElement commentsToBorrower_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_txtSureReceiptsComments"));
		return element;
	}
	
	/**
	 * Comments to borrower txtbx.
	 *
	 * @return the string
	 */
	public static String commentsToBorrower_txtbx(){
		id = "Main_Main_txtSureReceiptsComments";
		return id;
	}
	
	/**
	 * Include co borrower when present chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Include co-borrower when present checkbox
	public static WebElement includeCoBorrowerWhenPresent_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_chkSureReceiptsIncludeCoborrower"));
		return element;
	}
	
	/**
	 * Include co borrower when present chkbx.
	 *
	 * @return the string
	 */
	public static String includeCoBorrowerWhenPresent_chkbx(){
		id = "Main_Main_chkSureReceiptsIncludeCoborrower";
		return id;
	}
	
	/**
	 * Cancel scheduled delivery when revision is requested chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Cancel scheduled delivery when revision is requested checkbox
	public static WebElement cancelScheduledDeliveryWhenRevisionIsRequested_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_chkSureReceiptsCancelOnRevisionRequest"));
		return element;
	}
	
	/**
	 * Cancel scheduled delivery when revision is requested chkbx.
	 *
	 * @return the string
	 */
	public static String cancelScheduledDeliveryWhenRevisionIsRequested_chkbx(){
		id = "Main_Main_chkSureReceiptsCancelOnRevisionRequest";
		return id;
	}

	/**
	 * UCDP Business Unit Row 1
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// UCDP Business Unit Row 1
	public static WebElement ucdpBusinessUnit_row1(WebDriver driver){
		element = driver.findElement(By.cssSelector("tbody[mkr='rows'] > tr > td:nth-child(2)"));
		return element;
	}
	
	/**
	 * UCDP Business Unit Row 1
	 *
	 * @return the string
	 */
	public static String ucdpBusinessUnit_row1(){
		cssSelector = "tbody[mkr='rows'] > tr > td:nth-child(2)";
		return cssSelector;
	}
	
}
