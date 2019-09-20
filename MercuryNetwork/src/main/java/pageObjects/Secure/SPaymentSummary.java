package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure Payment Summary page
 */
public class SPaymentSummary {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	/** The css selector. */
	private static String cssSelector = null;
	
	
	/**
	 * Payment summary grid txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Payment Summary grid text
	public static WebElement paymentSummaryGrid_txt(WebDriver driver){
		element = driver.findElement(By.id("Main_grdPaymentSummary"));
		return element;
	}
	
	/**
	 * Payment summary grid txt.
	 *
	 * @return the string
	 */
	public static String paymentSummaryGrid_txt(){
		id = "Main_grdPaymentSummary";
		return id;
	}
	
	/**
	 * Date txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Date textbox
	public static WebElement date_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_txtPaymentDate"));
		return element;
	}
	
	/**
	 * Date txtbx.
	 *
	 * @return the string
	 */
	public static String date_txtbx(){
		id = "Main_txtPaymentDate";
		return id;
	}
	
	/**
	 * Calendar btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Calendar button
	public static WebElement calendar_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_imgCalendar"));
		return element;
	}
	
	/**
	 * Calendar btn.
	 *
	 * @return the string
	 */
	public static String calendar_btn(){
		id = "Main_imgCalendar";
		return id;
	}
	
	/**
	 * Method dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Method dropdown
	public static WebElement method_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Main_ddlPaymentMethod"));
		return element;
	}
	
	/**
	 * Method dropdown.
	 *
	 * @return the string
	 */
	public static String method_dropdown(){
		id = "Main_ddlPaymentMethod";
		return id;
	}
	
	/**
	 * Check txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Check textbox
	public static WebElement check_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_txtCheckNumber"));
		return element;
	}
	
	/**
	 * Check txtbx.
	 *
	 * @return the string
	 */
	public static String check_txtbx(){
		id = "Main_txtCheckNumber";
		return id;
	}
	
	/**
	 * Invoice number txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Invoice number textbox
	public static WebElement invoiceNumber_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_txtInvoiceNumber"));
		return element;
	}
	
	/**
	 * Invoice number txtbx.
	 *
	 * @return the string
	 */
	public static String invoiceNumber_txtbx(){
		id = "Main_txtInvoiceNumber";
		return id;
	}
	
	/**
	 * Note txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Note textbox
	public static WebElement note_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_txtNote"));
		return element;
	}
	
	/**
	 * Note txtbx.
	 *
	 * @return the string
	 */
	public static String note_txtbx(){
		id = "Main_txtNote";
		return id;
	}
	
	/**
	 * Notify vendor of payment chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Notify vendor of payment checkbox
	public static WebElement notifyVendorOfPayment_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_cbDisplayToVendor"));
		return element;
	}
	
	/**
	 * Notify vendor of payment chkbx.
	 *
	 * @return the string
	 */
	public static String notifyVendorOfPayment_chkbx(){
		id = "Main_cbDisplayToVendor";
		return id;
	}
	
	/**
	 * Export btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Export button
	public static WebElement export_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_btnExport"));
		return element;
	}
	
	/**
	 * Export btn.
	 *
	 * @return the string
	 */
	public static String export_btn(){
		id = "Main_btnExport";
		return id;
	}
	
	/**
	 * Upload btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Upload button
	public static WebElement upload_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_btnUpload"));
		return element;
	}
	
	/**
	 * Upload btn.
	 *
	 * @return the string
	 */
	public static String upload_btn(){
		id = "Main_btnUpload";
		return id;
	}
	
	/**
	 * Close btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Close button
	public static WebElement close_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_btnClose"));
		return element;
	}
	
	/**
	 * Close btn.
	 *
	 * @return the string
	 */
	public static String close_btn(){
		id = "Main_btnClose";
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
		element = driver.findElement(By.id("Main_btnSave"));
		return element;
	}
	
	/**
	 * Save btn.
	 *
	 * @return the string
	 */
	public static String save_btn(){
		id = "Main_btnSave";
		return id;
	}
	
	/**
	 * Save disabled btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Save button disabled
	public static WebElement saveDisabled_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#Main_btnSave.SkinButtonDisabled"));
		return element;
	}
	
	/**
	 * Save disabled btn.
	 *
	 * @return the string
	 */
	public static String saveDisabled_btn(){
		cssSelector = "#Main_btnSave.SkinButtonDisabled";
		return cssSelector;
	}
	
	/**
	 * Amount txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Amount text
	public static WebElement amount_txt(WebDriver driver){
		element = driver.findElement(By.id("Main_lblAmount"));
		return element;
	}
	
	/**
	 * Amount txt.
	 *
	 * @return the string
	 */
	public static String amount_txt(){
		id = "Main_lblAmount";
		return id;
	}
}
