package pageObjects.InternalTools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Internal Tools Payments Console page
 */
public class ITPaymentsConsole {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	/** The css selector. */
	private static String cssSelector = null;

	
	/**
	 * Customer info btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Customer info button
	public static WebElement customerInfo_btn(WebDriver driver){
		element = driver.findElement(By.id("tabCustomerInfo"));
		return element;
	}
	
	/**
	 * Customer info btn.
	 *
	 * @return the string
	 */
	public static String customerInfo_btn(){
		id = "tabCustomerInfo";
		return id;
	}

	/**
	 * Daily activity btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Daily activity button
	public static WebElement dailyActivity_btn(WebDriver driver){
		element = driver.findElement(By.id("tabDailyActivity"));
		return element;
	}
	
	/**
	 * Daily activity btn.
	 *
	 * @return the string
	 */
	public static String dailyActivity_btn(){
		id = "tabDailyActivity";
		return id;
	}
	
	/**
	 * Customer number txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Customer number textbox
	public static WebElement customerNumber_txtbx(WebDriver driver){
		element = driver.findElement(By.cssSelector("#divTabContainer > app-customer-composition > div.PodSection.psBorder > div > app-customer-search > div > div.DataColumn_left > div:nth-child(1) > input"));
		return element;
	}
	
	/**
	 * Customer number txtbx.
	 *
	 * @return the string
	 */
	public static String customerNumber_txtbx(){
		cssSelector = "#divTabContainer > app-customer-composition > div.PodSection.psBorder > div > app-customer-search > div > div.DataColumn_left > div:nth-child(1) > input";
		return cssSelector;
	}
	
	/**
	 * Select btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Select button
	public static WebElement select_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#divTabContainer > app-customer-composition > div.PodSection.psBorder > div > app-customer-search > div > div.DataColumn_left > div:nth-child(1) > button"));
		return element;
	}
	
	/**
	 * Select btn.
	 *
	 * @return the string
	 */
	public static String select_btn(){
		cssSelector = "#divTabContainer > app-customer-composition > div.PodSection.psBorder > div > app-customer-search > div > div.DataColumn_left > div:nth-child(1) > button";
		return cssSelector;
	}
	
	/**
	 * Payments active chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Payments active checkbox
	public static WebElement paymentsActive_chkbx(WebDriver driver){
		element = driver.findElement(By.cssSelector("#divTabContainer > app-customer-composition > div:nth-child(2) > app-customer-info > form > div:nth-child(1) > div > div.DataColumns > div.DataColumn_left > div > input"));
		return element;
	}
	
	/**
	 * Payments active chkbx.
	 *
	 * @return the string
	 */
	public static String paymentsActive_chkbx(){
		cssSelector = "#divTabContainer > app-customer-composition > div:nth-child(2) > app-customer-info > form > div:nth-child(1) > div > div.DataColumns > div.DataColumn_left > div > input";
		return cssSelector;
	}
	
	/**
	 * Company name txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Company name textbox
	public static WebElement companyName_txtbx(WebDriver driver){
		element = driver.findElement(By.cssSelector("#divTabContainer > app-customer-composition > div:nth-child(2) > app-customer-info > form > div:nth-child(3) > div > div.DataColumns > div.DataColumn_left > div:nth-child(1) > input"));
		return element;
	}
	
	/**
	 * Company name txtbx.
	 *
	 * @return the string
	 */
	public static String companyName_txtbx(){
		cssSelector = "#divTabContainer > app-customer-composition > div:nth-child(2) > app-customer-info > form > div:nth-child(3) > div > div.DataColumns > div.DataColumn_left > div:nth-child(1) > input";
		return cssSelector;
	}
	
	/**
	 * Transaction description txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Transaction description textbox
	public static WebElement transactionDescription_txtbx(WebDriver driver){
		element = driver.findElement(By.cssSelector("#divTabContainer > app-customer-composition > div:nth-child(2) > app-customer-info > form > div:nth-child(3) > div > div.DataColumns > div.DataColumn_left > div:nth-child(2) > input"));
		return element;
	}
	
	/**
	 * Transaction description txtbx.
	 *
	 * @return the string
	 */
	public static String transactionDescription_txtbx(){
		cssSelector = "#divTabContainer > app-customer-composition > div:nth-child(2) > app-customer-info > form > div:nth-child(3) > div > div.DataColumns > div.DataColumn_left > div:nth-child(2) > input";
		return cssSelector;
	}
	
	/**
	 * Transaction detail txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Transaction detail textbox
	public static WebElement transactionDetail_txtbx(WebDriver driver){
		element = driver.findElement(By.cssSelector("#divTabContainer > app-customer-composition > div:nth-child(2) > app-customer-info > form > div:nth-child(3) > div > div.DataColumns > div.DataColumn_left > div:nth-child(3) > input"));
		return element;
	}
	
	/**
	 * Transaction detail txtbx.
	 *
	 * @return the string
	 */
	public static String transactionDetail_txtbx(){
		cssSelector = "#divTabContainer > app-customer-composition > div:nth-child(2) > app-customer-info > form > div:nth-child(3) > div > div.DataColumns > div.DataColumn_left > div:nth-child(3) > input";
		return cssSelector;
	}
	
	/**
	 * Auto pay variance chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Auto pay variance checkbox
	public static WebElement autoPayVariance_chkbx(WebDriver driver){
		element = driver.findElement(By.cssSelector("#divTabContainer > app-customer-composition > div:nth-child(2) > app-customer-info > form > div:nth-child(1) > div > div.DataColumns > div.DataColumn_middle > div > input"));
		return element;
	}
	
	/**
	 * Auto pay variance chkbx.
	 *
	 * @return the string
	 */
	public static String autoPayVariance_chkbx(){
		cssSelector = "#divTabContainer > app-customer-composition > div:nth-child(2) > app-customer-info > form > div:nth-child(1) > div > div.DataColumns > div.DataColumn_middle > div > input";
		return cssSelector;
	}
	
	/**
	 * Payment trigger dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Payment trigger dropdown
	public static WebElement paymentTrigger_dropdown(WebDriver driver){
		element = driver.findElement(By.cssSelector("#divTabContainer > app-customer-composition > div:nth-child(2) > app-customer-info > form > div:nth-child(3) > div > div.DataColumns > div.DataColumn_middle > div:nth-child(1) > select"));
		return element;
	}
	
	/**
	 * Payment trigger dropdown.
	 *
	 * @return the string
	 */
	public static String paymentTrigger_dropdown(){
		cssSelector = "#divTabContainer > app-customer-composition > div:nth-child(2) > app-customer-info > form > div:nth-child(3) > div > div.DataColumns > div.DataColumn_middle > div:nth-child(1) > select";
		return cssSelector;
	}
	
	/**
	 * Payment days dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Payment days dropdown
	public static WebElement paymentDays_dropdown(WebDriver driver){
		element = driver.findElement(By.cssSelector("#divTabContainer > app-customer-composition > div:nth-child(2) > app-customer-info > form > div:nth-child(3) > div > div.DataColumns > div.DataColumn_middle > div:nth-child(2) > select"));
		return element;
	}
	
	/**
	 * Payment days dropdown.
	 *
	 * @return the string
	 */
	public static String paymentDays_dropdown(){
		cssSelector = "#divTabContainer > app-customer-composition > div:nth-child(2) > app-customer-info > form > div:nth-child(3) > div > div.DataColumns > div.DataColumn_middle > div:nth-child(2) > select";
		return cssSelector;
	}
	
//	// Notification recipients textbox
//	public static WebElement notificationRecipients_txtbx(WebDriver driver){
//		element = driver.findElement(By.cssSelector("#divTabContainer > app-customer-composition > div.PodContent.psBorder > app-customer-info > form > div > div > div.DataColumn_middle > div:nth-child(4) > textarea"));
//		return element;
//	}
//	public static String notificationRecipients_txtbx(){
//		cssSelector = "#divTabContainer > app-customer-composition > div.PodContent.psBorder > app-customer-info > form > div > div > div.DataColumn_middle > div:nth-child(4) > textarea";
//		return cssSelector;
//	}
	
	/**
 * Notification recipients txtbx.
 *
 * @param driver the driver
 * @return the web element
 */
// Notification recipients textbox
	public static WebElement notificationRecipients_txtbx(WebDriver driver){
		element = driver.findElement(By.cssSelector("#divTabContainer > app-customer-composition > div:nth-child(2) > app-customer-info > form > div:nth-child(3) > div > div.DataColumns > div.DataColumn_middle > div:nth-child(3) > textarea"));
		return element;
	}
	
	/**
	 * Notification recipients txtbx.
	 *
	 * @return the string
	 */
	public static String notificationRecipients_txtbx(){
		cssSelector = "#divTabContainer > app-customer-composition > div:nth-child(2) > app-customer-info > form > div:nth-child(3) > div > div.DataColumns > div.DataColumn_middle > div:nth-child(3) > textarea";
		return cssSelector;
	}
	
	/**
	 * Save btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Save button
	public static WebElement save_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#divTabContainer > app-customer-composition > div:nth-child(2) > app-customer-info > form > div:nth-child(3) > div > div.DataColumns > div.DataColumn_middle > div.DialogFooter > button"));
		return element;
	}
	
	/**
	 * Save btn.
	 *
	 * @return the string
	 */
	public static String save_btn(){
		cssSelector = "#divTabContainer > app-customer-composition > div:nth-child(2) > app-customer-info > form > div:nth-child(3) > div > div.DataColumns > div.DataColumn_middle > div.DialogFooter > button";
		return cssSelector;
	}
	
	/**
	 * Alert txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Alert text
	public static WebElement alert_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector("#divTabContainer > app-customer-composition > div:nth-child(2) > app-customer-info > div"));
		return element;
	}
	
	/**
	 * Alert txt.
	 *
	 * @return the string
	 */
	public static String alert_txt(){
		cssSelector = "#divTabContainer > app-customer-composition > div:nth-child(2) > app-customer-info > div";
		return cssSelector;
	}
	
}
