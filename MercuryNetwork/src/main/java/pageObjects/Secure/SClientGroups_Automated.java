package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure Client Groups Automated page
 */
public class SClientGroups_Automated {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	/** The css selector. */
	private static String cssSelector = null;

	
	/**
	 * Comments to borrower txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Comments to borrower textbox
	public static WebElement commentsToBorrower_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("Main_txtCommentsToBorrower"));
		return element;
	}	
	
	/**
	 * Comments to borrower txtbx.
	 *
	 * @return the string
	 */
	public static String commentsToBorrower_txtbx(){	
		id = "Main_txtCommentsToBorrower";
		return id;
	}
	
	/**
	 * For this client group dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Comments to borrower textbox
	public static WebElement forThisClientGroup_dropdown(WebDriver driver){	
		element = driver.findElement(By.id("Main_ddlSureReceiptsFreq"));
		return element;
	}	
	
	/**
	 * For this client group dropdown.
	 *
	 * @return the string
	 */
	public static String forThisClientGroup_dropdown(){	
		id = "Main_ddlSureReceiptsFreq";
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
		element = driver.findElement(By.id("Main_ddlSureReceiptsDelay"));
		return element;
	}	
	
	/**
	 * Automatically send the selected appraisal products to the borrower dropdown.
	 *
	 * @return the string
	 */
	public static String automaticallySendTheSelectedAppraisalProductsToTheBorrower_dropdown(){	
		id = "Main_ddlSureReceiptsDelay";
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
		element = driver.findElement(By.id("Main_chkIncludeCoborrower"));
		return element;
	}	
	
	/**
	 * Include co borrower when present chkbx.
	 *
	 * @return the string
	 */
	public static String includeCoBorrowerWhenPresent_chkbx(){	
		id = "Main_chkIncludeCoborrower";
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
		element = driver.findElement(By.id("Main_chkIncludeCoborrower"));
		return element;
	}	
	
	/**
	 * Cancel scheduled delivery when revision is requested chkbx.
	 *
	 * @return the string
	 */
	public static String cancelScheduledDeliveryWhenRevisionIsRequested_chkbx(){	
		id = "Main_chkIncludeCoborrower";
		return id;
	}
	
	/**
	 * Automatically submit to FH A chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Automatically submit to FHA checkbox
	public static WebElement automaticallySubmitToFHA_chkbx(WebDriver driver){	
		element = driver.findElement(By.id("Main_chkFHAAutoSubmit"));
		return element;
	}	
	
	/**
	 * Automatically submit to FH A chkbx.
	 *
	 * @return the string
	 */
	public static String automaticallySubmitToFHA_chkbx(){	
		id = "Main_chkFHAAutoSubmit";
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
		element = driver.findElement(By.id("Main_ddlFHAAutoSubmitFreq"));
		return element;
	}	
	
	/**
	 * Automatically submit to FH A dropdown.
	 *
	 * @return the string
	 */
	public static String automaticallySubmitToFHA_dropdown(){	
		id = "Main_ddlFHAAutoSubmitFreq";
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
		element = driver.findElement(By.id("Main_ddlFHAAutoSubmitFreq"));
		return element;
	}	
	
	/**
	 * An orders status changes to dropdown.
	 *
	 * @return the string
	 */
	public static String anOrdersStatusChangesTo_dropdown(){	
		id = "Main_ddlFHAAutoSubmitFreq";
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
		element = driver.findElement(By.id("Main_cbInvoice_CreateWhenOrderPlaced"));
		return element;
	}
	
	/**
	 * Creates the invoice when order is placed chkbx.
	 *
	 * @return the string
	 */
	public static String createInvoiceWhenOrderIsPlaced_chkbx(){
		id = "Main_cbInvoice_CreateWhenOrderPlaced";
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
		element = driver.findElement(By.id("Main_cbInvoice_AttachWhenCCCharged"));
		return element;
	}
	
	/**
	 * Attach invoice when credit card is charged chkbx.
	 *
	 * @return the string
	 */
	public static String attachInvoiceWhenCreditCardIsCharged_chkbx(){
		id = "Main_cbInvoice_AttachWhenCCCharged";
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
		element = driver.findElement(By.id("Main_cbInvoice_AttachWhenComplete"));
		return element;
	}
	
	/**
	 * Attach invoice when order is marked complete chkbx.
	 *
	 * @return the string
	 */
	public static String attachInvoiceWhenOrderIsMarkedComplete_chkbx(){
		id = "Main_cbInvoice_AttachWhenComplete";
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
		element = driver.findElement(By.id("Main_cbInvoice_IncludeVendorFee"));
		return element;
	}
	
	/**
	 * Include the vendors fee on the invoice chkbx.
	 *
	 * @return the string
	 */
	public static String includeTheVendorsFeeOnTheInvoice_chkbx(){
		id = "Main_cbInvoice_IncludeVendorFee";
		return id;
	}
	
	/**
	 * Customize your invoice number and due date options lnk.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Customize your invoice number and due date options link
	public static WebElement customizeYourInvoiceNumberAndDueDateOptions_lnk(WebDriver driver){
		element = driver.findElement(By.id("hlInvoice_CustomizeNumberAndDueDate"));
		return element;
	}
	
	/**
	 * Customize your invoice number and due date options lnk.
	 *
	 * @return the string
	 */
	public static String customizeYourInvoiceNumberAndDueDateOptions_lnk(){
		id = "hlInvoice_CustomizeNumberAndDueDate";
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
		element = driver.findElement(By.id("Dialogs_tbInvoice_DueDateDaysFrom"));
		return element;
	}
	
	/**
	 * Sets the the invoice due date to txtbx.
	 *
	 * @return the string
	 */
	public static String setTheInvoiceDueDateTo_txtbx(){
		id = "Dialogs_tbInvoice_DueDateDaysFrom";
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
		element = driver.findElement(By.id("Dialogs_cbInvoice_UseTrackingNoAsInvoiceNo"));
		return element;
	}
	
	/**
	 * Use tracking number chkbx.
	 *
	 * @return the string
	 */
	public static String useTrackingNumber_chkbx(){
		id = "Dialogs_cbInvoice_UseTrackingNoAsInvoiceNo";
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
		element = driver.findElement(By.id("Dialogs_tbInvoice_Prefix"));
		return element;
	}
	
	/**
	 * Prefix txtbx.
	 *
	 * @return the string
	 */
	public static String prefix_txtbx(){
		id = "Dialogs_tbInvoice_Prefix";
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
		element = driver.findElement(By.id("Dialogs_tbInvoice_StartNumber"));
		return element;
	}
	
	/**
	 * Start number sequence txtbx.
	 *
	 * @return the string
	 */
	public static String startNumberSequence_txtbx(){
		id = "Dialogs_tbInvoice_StartNumber";
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
		element = driver.findElement(By.cssSelector("#divInvoice_AutomaticInvoiceOptions > div.MsgBoxContent > table > tbody > tr:nth-child(2) > td > input:nth-child(1)"));
		return element;
	}
	
	/**
	 * Ok btn.
	 *
	 * @return the string
	 */
	public static String ok_btn(){
		cssSelector = "#divInvoice_AutomaticInvoiceOptions > div.MsgBoxContent > table > tbody > tr:nth-child(2) > td > input:nth-child(1)";
		return cssSelector;
	}
	
	/**
	 * Use QC folders chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Use Quality Control (QC) folders checkbox
	public static WebElement useQCFolders_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_chkUseInQC"));
		return element;
	}
	
	/**
	 * Use QC folders chkbx.
	 *
	 * @return the string
	 */
	public static String useQCFolders_chkbx(){
		id = "Main_chkUseInQC";
		return id;
	}
	
}
