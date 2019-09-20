package pageObjects.VMP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the VMP Confirm Order page
 */
public class VMPConfirmOrder {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	/** The css selector. */
	private static String cssSelector = null;

	
	/**
	 * Back top btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Top Back button
	public static WebElement backTop_btn(WebDriver driver){
		element = driver.findElement(By.id("btnBack1"));
		return element;
	}
	
	/**
	 * Back top btn.
	 *
	 * @return the string
	 */
	public static String backTop_btn(){
		id = "btnBack1";
		return id;
	}
	
	/**
	 * Next top btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Top Next Button
	public static WebElement nextTop_btn(WebDriver driver){
		element = driver.findElement(By.id("btnNext1"));
		return element;
	}
	
	/**
	 * Next top btn.
	 *
	 * @return the string
	 */
	public static String nextTop_btn(){
		id = "btnNext1";
		return id;
	}
	
	/**
	 * Order information txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Order Information text
	public static WebElement orderInformation_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector("div.InputSection"));
		return element;
	}
	
	/**
	 * Order information txt.
	 *
	 * @return the string
	 */
	public static String orderInformation_txt(){
		cssSelector = "div.InputSection";
		return cssSelector;
	}
	
	/**
	 * Order fee txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Order fee text field
	public static WebElement orderFee_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtFee"));
		return element;
	}
	
	/**
	 * Order fee txtbx.
	 *
	 * @return the string
	 */
	public static String orderFee_txtbx(){
		id = "ctl00_ctl00_Main_Main_txtFee";
		return id;
	}
	
	/**
	 * Payment method dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Payment method dropdown
	public static WebElement paymentMethod_dropdown(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_ddlPaymentMethod"));
		return element;
	}
	
	/**
	 * Payment method dropdown.
	 *
	 * @return the string
	 */
	public static String paymentMethod_dropdown(){
		id = "ctl00_ctl00_Main_Main_ddlPaymentMethod";
		return id;
	}
	
	/**
	 * Back bottom btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Bottom Back button
	public static WebElement backBottom_btn(WebDriver driver){
		element = driver.findElement(By.id("btnBack2"));
		return element;
	}
	
	/**
	 * Back bottom btn.
	 *
	 * @return the string
	 */
	public static String backBottom_btn(){
		id = "btnBack2";
		return id;
	}
	
	/**
	 * Next bottom btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Bottom Next button
	public static WebElement nextBottom_btn(WebDriver driver){
		element = driver.findElement(By.id("btnNext2"));
		return element;
	}
	
	/**
	 * Next bottom btn.
	 *
	 * @return the string
	 */
	public static String nextBottom_btn(){
		id = "btnNext2";
		return id;
	}
	
	/**
	 * Attach document header.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Attach Document popup
	public static WebElement attachDocument_header(WebDriver driver){
		element = driver.findElement(By.cssSelector("#divCompleteFrame"));
		return element;
	}
	
	/**
	 * Attach document header.
	 *
	 * @return the string
	 */
	public static String attachDocument_header(){
		cssSelector = "#divCompleteFrame";
		return cssSelector;
	}
	
	/**
	 * Document type dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Document type dropdown
	public static WebElement documentType_dropdown(WebDriver driver){
		element = driver.findElement(By.id("ctl00_Main_ddlDocumentTypes"));
		return element;
	}
	
	/**
	 * Document type dropdown.
	 *
	 * @return the string
	 */
	public static String documentType_dropdown(){
		id = "ctl00_Main_ddlDocumentTypes";
		return id;
	}
	
	/**
	 * Prints the direct fax btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Print DirectFax cover sheet button
	public static WebElement printDirectFax_btn(WebDriver driver){
		element = driver.findElement(By.id("ctl00_Main_ctl00"));
		return element;
	}
	
	/**
	 * Prints the direct fax btn.
	 *
	 * @return the string
	 */
	public static String printDirectFax_btn(){
		id = "ctl00_Main_ctl00";
		return id;
	}
	
	/**
	 * Upload documents btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Upload documents button
	public static WebElement uploadDocuments_btn(WebDriver driver){
		element = driver.findElement(By.id("ctl00_Main_sbAttachUpload"));
		return element;
	}
	
	/**
	 * Upload documents btn.
	 *
	 * @return the string
	 */
	public static String uploadDocuments_btn(){
		id = "ctl00_Main_sbAttachUpload";
		return id;
	}
	
	/**
	 * Finished btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Finish button
	public static WebElement finished_btn(WebDriver driver){
		element = driver.findElement(By.id("ctl00_Main_btnCloseToOrder"));
		return element;
	}
	
	/**
	 * Finished btn.
	 *
	 * @return the string
	 */
	public static String finished_btn(){
		id = "ctl00_Main_btnCloseToOrder";
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
		element = driver.findElement(By.cssSelector("#AlertDialog > div.MsgBoxContent > div > input[type='button']"));
		return element;
	}
	
	/**
	 * Ok btn.
	 *
	 * @return the string
	 */
	public static String ok_btn(){
		cssSelector = "#AlertDialog > div.MsgBoxContent > div > input[type='button']";
		return cssSelector;
	}
	
	/**
	 * Map rotate left btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Map rotate left button
	public static WebElement mapRotateLeft_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("a.NavBar_rotateLeft"));
		return element;
	}
	
	/**
	 * Map rotate left btn.
	 *
	 * @return the string
	 */
	public static String mapRotateLeft_btn(){
		cssSelector = "a.NavBar_rotateLeft";
		return cssSelector;
	}
	
	/**
	 * Header txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Header text
	public static WebElement header_txt(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_vsMain"));
		return element;
	}
	
	/**
	 * Header txt.
	 *
	 * @return the string
	 */
	public static String header_txt(){
		id = "ctl00_ctl00_Main_Main_vsMain";
		return id;
	}
	
	/**
	 * Saving dialog.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Saving dialog
	public static WebElement saving_dialog(WebDriver driver){
		element = driver.findElement(By.id("ClockDialog"));
		return element;
	}
	
	/**
	 * Saving dialog.
	 *
	 * @return the string
	 */
	public static String saving_dialog(){
		id = "ClockDialog";
		return id;
	}
	
	/**
	 * Page txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Page text
	public static WebElement page_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector(".InputSection"));
		return element;
	}
	
	/**
	 * Page txt.
	 *
	 * @return the string
	 */
	public static String page_txt(){
		cssSelector = ".InputSection";
		return cssSelector;
	}
	
	/**
	 * Upload sales contract btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Upload sales contract button
	public static WebElement uploadSalesContract_btn(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_btnSalesContract"));
		return element;
	}
	
	/**
	 * Upload sales contract btn.
	 *
	 * @return the string
	 */
	public static String uploadSalesContract_btn(){
		id = "ctl00_ctl00_Main_Main_btnSalesContract";
		return id;
	}
	
	/**
	 * Delete file btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Delete file button
	public static WebElement deleteFile_btn(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_imgDeleteSalesContract"));
		return element;
	}
	
	/**
	 * Delete file btn.
	 *
	 * @return the string
	 */
	public static String deleteFile_btn(){
		id = "ctl00_ctl00_Main_Main_imgDeleteSalesContract";
		return id;
	}
	
	/**
	 * Ok invalid information btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// OK Invalid Information button
	public static WebElement okInvalidInformation_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("input[type='button'][value='OK'][onclick='javascript:HideSummaryDialog();']"));
		return element;
	}
	
	/**
	 * Ok invalid information btn.
	 *
	 * @return the string
	 */
	public static String okInvalidInformation_btn(){
		cssSelector = "input[type='button'][value='OK'][onclick='javascript:HideSummaryDialog();']";
		return cssSelector;
	}
	
	/**
	 * Invalid information dialog txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Invalid Information dialog text
	public static WebElement invalidInformationDialog_txt(WebDriver driver){
		element = driver.findElement(By.id("SummaryDialog"));
		return element;
	}
	
	/**
	 * Invalid information dialog txt.
	 *
	 * @return the string
	 */
	public static String invalidInformationDialog_txt(){
		id = "SummaryDialog";
		return id;
	}
	
	/**
	 * Removes the upload btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Remove upload button
	public static WebElement removeUpload_btn(WebDriver driver){
		element = driver.findElement(By.id("pbAttach0_HoverIcon"));
		return element;
	}
	
	/**
	 * Removes the upload btn.
	 *
	 * @return the string
	 */
	public static String removeUpload_btn(){
		id = "pbAttach0_HoverIcon";
		return id;
	}
	
	/**
	 * Upload complete btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Upload complete button
	public static WebElement uploadComplete_btn(WebDriver driver){
		element = driver.findElement(By.id("pbAttach0_Icon"));
		return element;
	}
	
	/**
	 * Upload complete btn.
	 *
	 * @return the string
	 */
	public static String uploadComplete_btn(){
		id = "pbAttach0_Icon";
		return id;
	}
	
	/**
	 * Upload progress bar txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Upload progress bar text
	public static WebElement uploadProgressBar_txt(WebDriver driver){
		element = driver.findElement(By.id("pbAttach0_ProgressText"));
		return element;
	}
	
	/**
	 * Upload progress bar txt.
	 *
	 * @return the string
	 */
	public static String uploadProgressBar_txt(){
		id = "pbAttach0_ProgressText";
		return id;
	}
	
}
