package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure Appraisal Quality Management Settings page
 */
public class SAppraisalQualityManagementSettings {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The css selector. */
	private static String cssSelector = null;
	
	/** The id. */
	private static String id = null;

	
	/**
	 * Save btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Save button
	public static WebElement save_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/App_Themes/FlatGrayscale/Icons/Save.O.png']"));
		return element;
	}
	
	/**
	 * Save btn.
	 *
	 * @return the string
	 */
	public static String save_btn(){
		cssSelector = "img[src='/App_Themes/FlatGrayscale/Icons/Save.O.png']";
		return cssSelector;
	}
	
	/**
	 * Page txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// page text
	public static WebElement page_txt(WebDriver driver){
		element = driver.findElement(By.id("divAdminMain"));
		return element;
	}
	
	/**
	 * Page txt.
	 *
	 * @return the string
	 */
	public static String page_txt(){
		id = "divAdminMain";
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
		element = driver.findElement(By.id("sbdmButton1"));
		return element;
	}
	
	/**
	 * Ok btn.
	 *
	 * @return the string
	 */
	public static String ok_btn(){
		id = "sbdmButton1";
		return id;
	}
	
	/**
	 * Real view btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// RealView button
	public static WebElement realView_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_gvProducts_imgProduct_0"));
		return element;
	}
	
	/**
	 * Real view btn.
	 *
	 * @return the string
	 */
	public static String realView_btn(){
		id = "Main_Main_gvProducts_imgProduct_0";
		return id;
	}
	
	/**
	 * Aqi btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// AQI button
	public static WebElement aqi_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_gvProducts_imgProduct_1"));
		return element;
	}
	
	/**
	 * Aqi btn.
	 *
	 * @return the string
	 */
	public static String aqi_btn(){
		id = "Main_Main_gvProducts_imgProduct_1";
		return id;
	}
	
	/**
	 * Aqm btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// AQM button
	public static WebElement aqm_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_gvProducts_imgProduct_2"));
		return element;
	}
	
	/**
	 * Aqm btn.
	 *
	 * @return the string
	 */
	public static String aqm_btn(){
		id = "Main_Main_gvProducts_imgProduct_2";
		return id;
	}
	
	/**
	 * Manual rules chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Manual rules checkbox
	public static WebElement manualRules_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_gvProducts_chkManualRules_2"));
		return element;
	}
	
	/**
	 * Manual rules chkbx.
	 *
	 * @return the string
	 */
	public static String manualRules_chkbx(){
		id = "Main_Main_gvProducts_chkManualRules_2";
		return id;
	}
	
	/**
	 * Validate data btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Validate data button
	public static WebElement validateData_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_gvProducts_imgProduct_3"));
		return element;
	}
	
	/**
	 * Validate data btn.
	 *
	 * @return the string
	 */
	public static String validateData_btn(){
		id = "Main_Main_gvProducts_imgProduct_3";
		return id;
	}
	
	/**
	 * Master serv btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// MasterServ button
	public static WebElement masterServ_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_gvProducts_imgProduct_4"));
		return element;
	}
	
	/**
	 * Master serv btn.
	 *
	 * @return the string
	 */
	public static String masterServ_btn(){
		id = "Main_Main_gvProducts_imgProduct_4";
		return id;
	}
	
	/**
	 * Always order default modules chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Always order default modules checkbox
	public static WebElement alwaysOrderDefaultModules_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_chkOnlyUseDefaultModules"));
		return element;
	}
	
	/**
	 * Always order default modules chkbx.
	 *
	 * @return the string
	 */
	public static String alwaysOrderDefaultModules_chkbx(){
		id = "Main_Main_chkOnlyUseDefaultModules";
		return id;
	}
	
	/**
	 * Automatically order default modules chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Automatically order default modules checkbox
	public static WebElement automaticallyOrderDefaultModules_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_chkAutoAQMByStatus"));
		return element;
	}
	
	/**
	 * Automatically order default modules chkbx.
	 *
	 * @return the string
	 */
	public static String automaticallyOrderDefaultModules_chkbx(){
		id = "Main_Main_chkAutoAQMByStatus";
		return id;
	}
	
	/**
	 * Automatically order default modules dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Automatically order default modules dropdown
	public static WebElement automaticallyOrderDefaultModules_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_ddlAutoStartFirstTimeOnly"));
		return element;
	}
	
	/**
	 * Automatically order default modules dropdown.
	 *
	 * @return the string
	 */
	public static String automaticallyOrderDefaultModules_dropdown(){
		id = "Main_Main_ddlAutoStartFirstTimeOnly";
		return id;
	}
	
	/**
	 * Automatically download the RealView Report PDF when results are returned checkbox.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Automatically order default modules dropdown
	public static WebElement automaticallyDownloadTheRealViewReportPDFWhenResultsAreReturned_checkbox(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_chkAutoDownloadRealviewPDF"));
		return element;
	}
	
	/**
	 * Automatically download the RealView Report PDF when results are returned checkbox.
	 *
	 * @return the string
	 */
	public static String automaticallyDownloadTheRealViewReportPDFWhenResultsAreReturned_checkbox(){
		id = "Main_Main_chkAutoDownloadRealviewPDF";
		return id;
	}
	
	/**
	 * Automatically download the RealView Report PDF when results are returned text.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement automaticallyDownloadTheRealViewReportPDFWhenResultsAreReturned_txt(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_lblAutoDownloadRealviewPDF"));
		return element;
	}
	
	/**
	 * Automatically download the RealView Report PDF when results are returned text.
	 *
	 * @return the string
	 */
	public static String automaticallyDownloadTheRealViewReportPDFWhenResultsAreReturned_txt(){
		id = "Main_Main_lblAutoDownloadRealviewPDF";
		return id;
	}
	
	/**
	 * An orders status changes to dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// An order's status changes to dropdown
	public static WebElement anOrdersStatusChangesTo_dropdown(WebDriver driver){
		element = driver.findElement(By.id("x:1815479748.2:mkr:Input"));
		return element;
	}
	
	/**
	 * An orders status changes to dropdown.
	 *
	 * @return the string
	 */
	public static String anOrdersStatusChangesTo_dropdown(){
		id = "x:1815479748.2:mkr:Input";
		return id;
	}
	
	/**
	 * Only automatically order chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Only automatically order when the CU score is greater checkbox
	public static WebElement onlyAutomaticallyOrder_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_chkCUScore"));
		return element;
	}
	
	/**
	 * Only automatically order chkbx.
	 *
	 * @return the string
	 */
	public static String onlyAutomaticallyOrder_chkbx(){
		id = "Main_Main_chkCUScore";
		return id;
	}
	
	/**
	 * Enable real view bridge chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Enable RealView Bridge checkbox
	public static WebElement enableRealViewBridge_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_gvProducts_chkRealViewBridge_0"));
		return element;
	}
	
	/**
	 * Enable real view bridge chkbx.
	 *
	 * @return the string
	 */
	public static String enableRealViewBridge_chkbx(){
		id = "Main_Main_gvProducts_chkRealViewBridge_0";
		return id;
	}
	
	/**
	 * Ok enable real view bridge btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// OK Enable RealView Bridge button
	public static WebElement okEnableRealViewBridge_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_SkinButton1"));
		return element;
	}
	
	/**
	 * Ok enable real view bridge btn.
	 *
	 * @return the string
	 */
	public static String okEnableRealViewBridge_btn(){
		id = "Dialogs_Dialogs_SkinButton1";
		return id;
	}
	
	/**
	 * Enable real view bridge dialog txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Enable RealView Bridge dialog text
	public static WebElement enableRealViewBridgeDialog_txt(WebDriver driver){
		element = driver.findElement(By.id("divRealViewBridgeSalesLead"));
		return element;
	}
	
	/**
	 * Enable real view bridge dialog txt.
	 *
	 * @return the string
	 */
	public static String enableRealViewBridgeDialog_txt(){
		id = "divRealViewBridgeSalesLead";
		return id;
	}
	
}
