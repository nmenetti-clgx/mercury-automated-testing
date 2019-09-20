package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure Configure Automatic Settings page
 */
public class SConfigureAutomaticSettings {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	/** The css selector. */
	private static String cssSelector = null;

	
	/**
	 * Page txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// page text
	public static WebElement page_txt(WebDriver driver){
		element = driver.findElement(By.id("divData"));
		return element;
	}
	
	/**
	 * Page txt.
	 *
	 * @return the string
	 */
	public static String page_txt(){
		id = "divData";
		return id;
	}
	
	/**
	 * Do not pass VMP comments to the vendor chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Do not pass VMP comments to the vendor checkbox
	public static WebElement doNotPassVMPCommentsToTheVendor_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_cbEnable_VMPComment_DoNotSync"));
		return element;
	}
	
	/**
	 * Do not pass VMP comments to the vendor chkbx.
	 *
	 * @return the string
	 */
	public static String doNotPassVMPCommentsToTheVendor_chkbx(){
		id = "Main_Main_Main_cbEnable_VMPComment_DoNotSync";
		return id;
	}
	
	/**
	 * Assign supplemental orders to the vendor that coompleted the original appraisal chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Assign supplemental orders to the vendor that completed the original appraisal checkbox
	public static WebElement assignSupplementalOrdersToTheVendorThatCoompletedTheOriginalAppraisal_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_cbEnable_AssignSupplementalOrders"));
		return element;
	}
	
	/**
	 * Assign supplemental orders to the vendor that coompleted the original appraisal chkbx.
	 *
	 * @return the string
	 */
	public static String assignSupplementalOrdersToTheVendorThatCoompletedTheOriginalAppraisal_chkbx(){
		id = "Main_Main_Main_cbEnable_AssignSupplementalOrders";
		return id;
	}
	
	/**
	 * Assign supplemental orders gear icon btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Assign supplemental orders to the vendor that completed the original appraisal gear icon button
	public static WebElement assignSupplementalOrdersGearIcon_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img.imgInlineGear[alt='Configure supplemental order options']"));
		return element;
	}
	
	/**
	 * Assign supplemental orders gear icon btn.
	 *
	 * @return the string
	 */
	public static String assignSupplementalOrdersGearIcon_btn(){
		cssSelector = "img.imgInlineGear[alt='Configure supplemental order options']";
		return cssSelector;
	}
	
	/**
	 * Use when assigning orders dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Use when assigning orders dropdown
	public static WebElement useWhenAssigningOrders_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_ddlVendorFeeOptions"));
		return element;
	}
	
	/**
	 * Use when assigning orders dropdown.
	 *
	 * @return the string
	 */
	public static String useWhenAssigningOrders_dropdown(){
		id = "Main_Main_Main_ddlVendorFeeOptions";
		return id;
	}
	
	/**
	 * Use vendor override fee whenever possible chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Use vendor override fee whenever possible checkbox
	public static WebElement useVendorOverrideFeeWheneverPossible_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_cbEnable_UseVendorOverride"));
		return element;
	}
	
	/**
	 * Use vendor override fee whenever possible chkbx.
	 *
	 * @return the string
	 */
	public static String useVendorOverrideFeeWheneverPossible_chkbx(){
		id = "Main_Main_Main_cbEnable_UseVendorOverride";
		return id;
	}
	
	/**
	 * Always use the new vendors published fee chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Always use the new vendors published fee checkbox
	public static WebElement alwaysUseTheNewVendorsPublishedFee_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_cbEnable_AlwaysUseNewVendorFeeReassign"));
		return element;
	}
	
	/**
	 * Always use the new vendors published fee chkbx.
	 *
	 * @return the string
	 */
	public static String alwaysUseTheNewVendorsPublishedFee_chkbx(){
		id = "Main_Main_Main_cbEnable_AlwaysUseNewVendorFeeReassign";
		return id;
	}
	
	/**
	 * Sets the the payment method to dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Set the payment method to dropdown
	public static WebElement setThePaymentMethodTo_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_ddlDefaultPaymentMethod"));
		return element;
	}
	
	/**
	 * Sets the the payment method to dropdown.
	 *
	 * @return the string
	 */
	public static String setThePaymentMethodTo_dropdown(){
		id = "Main_Main_Main_ddlDefaultPaymentMethod";
		return id;
	}
	
	/**
	 * Creates the invoice when order is placed chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Create invoice when order is placed checkbox
	public static WebElement createInvoiceWhenOrderIsPlaced_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_cbInvoice_CreateWhenOrderPlaced"));
		return element;
	}
	
	/**
	 * Creates the invoice when order is placed chkbx.
	 *
	 * @return the string
	 */
	public static String createInvoiceWhenOrderIsPlaced_chkbx(){
		id = "Main_Main_Main_cbInvoice_CreateWhenOrderPlaced";
		return id;
	}
	
	/**
	 * Attach invoice when credit card is charged chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Attach invoice when credit card is charged checkbox
	public static WebElement attachInvoiceWhenCreditCardIsCharged_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_cbInvoice_AttachWhenCCCharged"));
		return element;
	}
	
	/**
	 * Attach invoice when credit card is charged chkbx.
	 *
	 * @return the string
	 */
	public static String attachInvoiceWhenCreditCardIsCharged_chkbx(){
		id = "Main_Main_Main_cbInvoice_AttachWhenCCCharged";
		return id;
	}
	
	/**
	 * Attach invoice when order is marked complete chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Attach invoice when order is marked complete checkbox
	public static WebElement attachInvoiceWhenOrderIsMarkedComplete_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_cbInvoice_AttachWhenComplete"));
		return element;
	}
	
	/**
	 * Attach invoice when order is marked complete chkbx.
	 *
	 * @return the string
	 */
	public static String attachInvoiceWhenOrderIsMarkedComplete_chkbx(){
		id = "Main_Main_Main_cbInvoice_AttachWhenComplete";
		return id;
	}
	
	/**
	 * Include the vendors fee on the invoice chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Include the vendor's fee on the invoice checkbox
	public static WebElement includeTheVendorsFeeOnTheInvoice_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_cbInvoice_IncludeVendorFee"));
		return element;
	}
	
	/**
	 * Include the vendors fee on the invoice chkbx.
	 *
	 * @return the string
	 */
	public static String includeTheVendorsFeeOnTheInvoice_chkbx(){
		id = "Main_Main_Main_cbInvoice_IncludeVendorFee";
		return id;
	}
	
	/**
	 * Sets the the invoice due date to txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Set the invoice due date to textbox
	public static WebElement setTheInvoiceDueDateTo_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_tbInvoice_DueDateDaysFrom"));
		return element;
	}
	
	/**
	 * Sets the the invoice due date to txtbx.
	 *
	 * @return the string
	 */
	public static String setTheInvoiceDueDateTo_txtbx(){
		id = "Main_Main_Main_tbInvoice_DueDateDaysFrom";
		return id;
	}
	
	/**
	 * Use tracking number chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Use tracking number checkbox
	public static WebElement useTrackingNumber_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_cbInvoice_UseTrackingNoAsInvoiceNo"));
		return element;
	}
	
	/**
	 * Use tracking number chkbx.
	 *
	 * @return the string
	 */
	public static String useTrackingNumber_chkbx(){
		id = "Main_Main_Main_cbInvoice_UseTrackingNoAsInvoiceNo";
		return id;
	}
	
	/**
	 * Prefix txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Prefix textbox
	public static WebElement prefix_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_tbInvoice_Prefix"));
		return element;
	}
	
	/**
	 * Prefix txtbx.
	 *
	 * @return the string
	 */
	public static String prefix_txtbx(){
		id = "Main_Main_Main_tbInvoice_Prefix";
		return id;
	}
	
	/**
	 * Start number sequence txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Start Number Sequence textbox
	public static WebElement startNumberSequence_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_tbInvoice_StartNumber"));
		return element;
	}
	
	/**
	 * Start number sequence txtbx.
	 *
	 * @return the string
	 */
	public static String startNumberSequence_txtbx(){
		id = "Main_Main_Main_tbInvoice_StartNumber";
		return id;
	}
	
	/**
	 * Use QC folders chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Use Quality Control (QC) folders checkbox
	public static WebElement useQCFolders_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_cbUseInQC"));
		return element;
	}
	
	/**
	 * Use QC folders chkbx.
	 *
	 * @return the string
	 */
	public static String useQCFolders_chkbx(){
		id = "Main_Main_Main_cbUseInQC";
		return id;
	}
	
}
