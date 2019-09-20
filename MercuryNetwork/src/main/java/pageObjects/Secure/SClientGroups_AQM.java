package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure Client Groups AQM page
 */
public class SClientGroups_AQM {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;

	
	/**
	 * Additional AQI recipients txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Additional AQI Recipients textbox
	public static WebElement additionalAQIRecipients_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("Main_txtAdditionalAQIRecipients"));
		return element;
	}	
	
	/**
	 * Additional AQI recipients txtbx.
	 *
	 * @return the string
	 */
	public static String additionalAQIRecipients_txtbx(){	
		id = "Main_txtAdditionalAQIRecipients";
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
		element = driver.findElement(By.id("Main_gvAQMModules_imgProduct_0"));
		return element;
	}
	
	/**
	 * Real view btn.
	 *
	 * @return the string
	 */
	public static String realView_btn(){
		id = "Main_gvAQMModules_imgProduct_0";
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
		element = driver.findElement(By.id("Main_gvAQMModules_imgProduct_1"));
		return element;
	}
	
	/**
	 * Aqi btn.
	 *
	 * @return the string
	 */
	public static String aqi_btn(){
		id = "Main_gvAQMModules_imgProduct_1";
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
		element = driver.findElement(By.id("Main_gvAQMModules_imgProduct_2"));
		return element;
	}
	
	/**
	 * Aqm btn.
	 *
	 * @return the string
	 */
	public static String aqm_btn(){
		id = "Main_gvAQMModules_imgProduct_2";
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
		element = driver.findElement(By.id("Main_gvAQMModules_chkManualRules_2"));
		return element;
	}
	
	/**
	 * Manual rules chkbx.
	 *
	 * @return the string
	 */
	public static String manualRules_chkbx(){
		id = "Main_gvAQMModules_chkManualRules_2";
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
		element = driver.findElement(By.id("Main_gvAQMModules_imgProduct_3"));
		return element;
	}
	
	/**
	 * Validate data btn.
	 *
	 * @return the string
	 */
	public static String validateData_btn(){
		id = "Main_gvAQMModules_imgProduct_3";
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
		element = driver.findElement(By.id("Main_gvAQMModules_imgProduct_4"));
		return element;
	}
	
	/**
	 * Master serv btn.
	 *
	 * @return the string
	 */
	public static String masterServ_btn(){
		id = "Main_gvAQMModules_imgProduct_4";
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
		element = driver.findElement(By.id("Main_chkAQMAutoOrderModules"));
		return element;
	}
	
	/**
	 * Always order default modules chkbx.
	 *
	 * @return the string
	 */
	public static String alwaysOrderDefaultModules_chkbx(){
		id = "Main_chkAQMAutoOrderModules";
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
		element = driver.findElement(By.id("Main_chkAQMAutoStart"));
		return element;
	}
	
	/**
	 * Automatically order default modules chkbx.
	 *
	 * @return the string
	 */
	public static String automaticallyOrderDefaultModules_chkbx(){
		id = "Main_chkAQMAutoStart";
		return id;
	}
	
	/**
	 * Automatically order default modules dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Always order default modules dropdown
	public static WebElement automaticallyOrderDefaultModules_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Main_ddlAQMAutoStartFreq"));
		return element;
	}
	
	/**
	 * Automatically order default modules dropdown.
	 *
	 * @return the string
	 */
	public static String automaticallyOrderDefaultModules_dropdown(){
		id = "Main_ddlAQMAutoStartFreq";
		return id;
	}
	
	/**
	 * Automatically download the RealView report checkbox.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement automaticallyDownloadTheRealViewReport_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_chkAQMAutoDownloadRealviewPDF"));
		return element;
	}
	
	/**
	 * Automatically download the RealView report checkbox.
	 *
	 * @return the string
	 */
	public static String automaticallyDownloadTheRealViewReport_chkbx(){
		id = "Main_chkAQMAutoDownloadRealviewPDF";
		return id;
	}
	
	/**
	 * Automatically download the RealView report txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement automaticallyDownloadTheRealViewReport_txt(WebDriver driver){
		element = driver.findElement(By.id("Main_lblAQMAutoDownloadRealviewPDF"));
		return element;
	}
	
	/**
	 * Automatically download the RealView report txt.
	 *
	 * @return the string
	 */
	public static String automaticallyDownloadTheRealViewReport_txt(){
		id = "Main_lblAQMAutoDownloadRealviewPDF";
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
		element = driver.findElement(By.id("x:1173019412.2:mkr:Input"));
		return element;
	}
	
	/**
	 * An orders status changes to dropdown.
	 *
	 * @return the string
	 */
	public static String anOrdersStatusChangesTo_dropdown(){
		id = "x:1173019412.2:mkr:Input";
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
		element = driver.findElement(By.id("Main_chkCUScore"));
		return element;
	}
	
	/**
	 * Only automatically order chkbx.
	 *
	 * @return the string
	 */
	public static String onlyAutomaticallyOrder_chkbx(){
		id = "Main_chkCUScore";
		return id;
	}
	
}
