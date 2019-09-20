package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import setup.TestSetup;

/**
 * The elements on the Secure Confirm Order page
 */
public class SConfirmOrder extends TestSetup{
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	/** The css selector. */
	private static String cssSelector = null;
	
	/** The link text. */
	private static String linkText = null;

	
	/**
	 * Back top btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Top Back button
	public static WebElement backTop_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_sbBack1"));
		return element;
	}
	
	/**
	 * Back top btn.
	 *
	 * @return the string
	 */
	public static String backTop_btn(){
		id = "Main_Main_sbBack1";
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
		element = driver.findElement(By.id("Main_Main_sbFinish1"));
		return element;
	}
	
	/**
	 * Next top btn.
	 *
	 * @return the string
	 */
	public static String nextTop_btn(){
		id = "Main_Main_sbFinish1";
		return id;
	}
	
	/**
	 * Vendor information txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Vendor Information table
	public static WebElement vendorInformation_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector("div.VendorList"));
		return element;
	}
	
	/**
	 * Vendor information txt.
	 *
	 * @return the string
	 */
	public static String vendorInformation_txt(){
		cssSelector = "div.VendorList";
		return cssSelector;
	}
	
	/**
	 * Property information txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Property Information table
	public static WebElement propertyInformation_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector("div.PropertyInformation"));
		return element;
	}
	
	/**
	 * Property information txt.
	 *
	 * @return the string
	 */
	public static String propertyInformation_txt(){
		cssSelector = "div.PropertyInformation";
		return cssSelector;
	}
	
	/**
	 * Assignment information txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Assignment Information table
	public static WebElement assignmentInformation_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector("div.AssignmentContent"));
		return element;
	}
	
	/**
	 * Assignment information txt.
	 *
	 * @return the string
	 */
	public static String assignmentInformation_txt(){
		cssSelector = "div.AssignmentContent";
		return cssSelector;
	}
	
	/**
	 * Contact and access information txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Contact and access information table
	public static WebElement contactAndAccessInformation_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector("div.Contacts"));
		return element;
	}
	
	/**
	 * Contact and access information txt.
	 *
	 * @return the string
	 */
	public static String contactAndAccessInformation_txt(){
		cssSelector = "div.Contacts";
		return cssSelector;
	}
	
	/**
	 * Additional comments txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Additional comments text
	public static WebElement additionalComments_txt(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_divComments"));
		return element;
	}
	
	/**
	 * Additional comments txt.
	 *
	 * @return the string
	 */
	public static String additionalComments_txt(){
		id = "Main_Main_divComments";
		return id;
	}
	
	/**
	 * Require mismo xml chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Require MISMO XML checkbox
	public static WebElement requireMismoXml_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_chkRequireXML"));
		return element;
	}
	
	/**
	 * Require mismo xml chkbx.
	 *
	 * @return the string
	 */
	public static String requireMismoXml_chkbx(){
		id = "Main_Main_chkRequireXML";
		return id;
	}
	
	/**
	 * Expiration date txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Expiration date text field
	public static WebElement expirationDate_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_txtDueExpireDate"));
		return element;
	}
	
	/**
	 * Expiration date txtbx.
	 *
	 * @return the string
	 */
	public static String expirationDate_txtbx(){
		id = "Main_Main_txtDueExpireDate";
		return id;
	}
	
	/**
	 * Expiration date calendar btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Expiration date calendar
	public static WebElement expirationDateCalendar_btn(WebDriver driver){
		element = driver.findElement(By.id("imgCalendar"));
		return element;
	}
	
	/**
	 * Expiration date calendar btn.
	 *
	 * @return the string
	 */
	public static String expirationDateCalendar_btn(){
		id = "imgCalendar";
		return id;
	}
	
	/**
	 * Expiration time hour txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Expiration time hour
	public static WebElement expirationTimeHour_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_txtDueExpireHour"));
		return element;
	}
	
	/**
	 * Expiration time hour txtbx.
	 *
	 * @return the string
	 */
	public static String expirationTimeHour_txtbx(){
		id = "Main_Main_txtDueExpireHour";
		return id;
	}
	
	/**
	 * Expiration time minute txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Expiration time minute
	public static WebElement expirationTimeMinute_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_txtDueExpireMinute"));
		return element;
	}
	
	/**
	 * Expiration time minute txtbx.
	 *
	 * @return the string
	 */
	public static String expirationTimeMinute_txtbx(){
		id = "Main_Main_txtDueExpireMinute";
		return id;
	}
	
	/**
	 * Expiration time am pm dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Expiration date am/pm dropdown
	public static WebElement expirationTimeAmPm_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_ddlAMPM"));
		return element;
	}
	
	/**
	 * Expiration time am pm dropdown.
	 *
	 * @return the string
	 */
	public static String expirationTimeAmPm_dropdown(){
		id = "Main_Main_ddlAMPM";
		return id;
	}
	
	/**
	 * Time zone dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Time Zone dropdown
	public static WebElement timeZone_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_ddlTimeZone"));
		return element;
	}
	
	/**
	 * Time zone dropdown.
	 *
	 * @return the string
	 */
	public static String timeZone_dropdown(){
		id = "Main_Main_ddlTimeZone";
		return id;
	}
	
	/**
	 * Vendors notes txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Vendors notes text
	public static WebElement vendorsNotes_txt(WebDriver driver){
		element = driver.findElement(By.id("divFeeNotes"));
		return element;
	}
	
	/**
	 * Vendors notes txt.
	 *
	 * @return the string
	 */
	public static String vendorsNotes_txt(){
		id = "divFeeNotes";
		return id;
	}
	
	/**
	 * Read vendors fee notes chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Read vendor's fee notes checkbox
	public static WebElement readVendorsFeeNotes_chkbx(WebDriver driver){
		element = driver.findElement(By.id("chkAgree"));
		return element;
	}
	
	/**
	 * Read vendors fee notes chkbx.
	 *
	 * @return the string
	 */
	public static String readVendorsFeeNotes_chkbx(){
		id = "chkAgree";
		return id;
	}
	
	/**
	 * Payment information txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Payment information header text
	public static WebElement paymentInformation_txt(WebDriver driver){
		element = driver.findElement(By.id("spnTransactionHeader"));
		return element;
	}
	
	/**
	 * Payment information txt.
	 *
	 * @return the string
	 */
	public static String paymentInformation_txt(){
		id = "spnTransactionHeader";
		return id;
	}
	
	/**
	 * Order fee staff txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Order fee Staff text field
	public static WebElement orderFeeStaff_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_spnStaff"));
		return element;
	}
	
	/**
	 * Order fee staff txtbx.
	 *
	 * @return the string
	 */
	public static String orderFeeStaff_txtbx(){
		id = "Main_Main_spnStaff";
		return id;
	}
	
	/**
	 * Order fee txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Order fee text field
	public static WebElement orderFee_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_txtOrderFee"));
		return element;
	}
	
	/**
	 * Order fee txtbx.
	 *
	 * @return the string
	 */
	public static String orderFee_txtbx(){
		id = "Main_Main_txtOrderFee";
		return id;
	}
	
	/**
	 * Source dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Source dropdown
	public static WebElement source_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_ddlFeeOptions"));
		return element;
	}
	
	/**
	 * Source dropdown.
	 *
	 * @return the string
	 */
	public static String source_dropdown(){
		id = "Main_Main_ddlFeeOptions";
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
		element = driver.findElement(By.id("Main_Main_ctlCC_ddlPaymentMethod"));
		return element;
	}
	
	/**
	 * Payment method dropdown.
	 *
	 * @return the string
	 */
	public static String paymentMethod_dropdown(){
		id = "Main_Main_ctlCC_ddlPaymentMethod";
		return id;
	}
	
	/**
	 * Transaction fee chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Transaction fee checkbox
	public static WebElement transactionFee_chkbx(WebDriver driver){
		element = driver.findElement(By.id("chkPayTransaction"));
		return element;
	}
	
	/**
	 * Transaction fee chkbx.
	 *
	 * @return the string
	 */
	public static String transactionFee_chkbx(){
		id = "chkPayTransaction";
		return id;
	}
	
	/**
	 * Transaction fee txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement transactionFee_txt(WebDriver driver){
		element = driver.findElement(By.id("lblPaymentNoticeAgree"));
		return element;
	}
	
	/**
	 * Back bottom btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Bottom Back button
	public static WebElement backBottom_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_sbBack2"));
		return element;
	}
	
	/**
	 * Back bottom btn.
	 *
	 * @return the string
	 */
	public static String backBottom_btn(){
		id = "Main_Main_sbBack2";
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
		element = driver.findElement(By.id("Main_Main_sbFinish2"));
		return element;
	}
	
	/**
	 * Next bottom btn.
	 *
	 * @return the string
	 */
	public static String nextBottom_btn(){
		id = "Main_Main_sbFinish2";
		return id;
	}
	
	/**
	 * Message txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Message popup
	public static WebElement message_txt(WebDriver driver){
		element = driver.findElement(By.id("divMessageOK"));
		return element;
	}
	
	/**
	 * Message txt.
	 *
	 * @return the string
	 */
	public static String message_txt(){
		id = "divMessageOK";
		return id;
	}
	
	/**
	 * Message O K btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Message OK button
	public static WebElement messageOK_btn(WebDriver driver){
		element = driver.findElement(By.id("sbdmButton1"));
		return element;
	}
	
	/**
	 * Message O K btn.
	 *
	 * @return the string
	 */
	public static String messageOK_btn(){
		id = "sbdmButton1";
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
		element = driver.findElement(By.cssSelector("#divComplete > div.DialogTitle"));
		return element;
	}
	
	/**
	 * Attach document header.
	 *
	 * @return the string
	 */
	public static String attachDocument_header(){
		cssSelector = "#divComplete > div.DialogTitle";
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
		element = driver.findElement(By.id("Main_ddlDocumentTypes"));
		return element;
	}
	
	/**
	 * Document type dropdown.
	 *
	 * @return the string
	 */
	public static String documentType_dropdown(){
		id = "Main_ddlDocumentTypes";
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
		element = driver.findElement(By.id("Main_ctl00"));
		return element;
	}
	
	/**
	 * Prints the direct fax btn.
	 *
	 * @return the string
	 */
	public static String printDirectFax_btn(){
		id = "Main_ctl00";
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
		element = driver.findElement(By.id("Main_sbAttachUpload"));
		return element;
	}
	
	/**
	 * Upload documents btn.
	 *
	 * @return the string
	 */
	public static String uploadDocuments_btn(){
		id = "Main_sbAttachUpload";
		return id;
	}
	
	/**
	 * Place another order lnk.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Place another order link
	public static WebElement placeAnotherOrder_lnk(WebDriver driver){
		element = driver.findElement(By.linkText("Place another order"));
		return element;
	}
	
	/**
	 * Place another order lnk.
	 *
	 * @return the string
	 */
	public static String placeAnotherOrder_lnk(){
		linkText = "Place another order";
		return linkText;
	}
	
	/**
	 * Finished lnk.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Finished link
	public static WebElement finished_lnk(WebDriver driver){
		element = driver.findElement(By.linkText("Finished"));
		return element;
	}
	
	/**
	 * Finished lnk.
	 *
	 * @return the string
	 */
	public static String finished_lnk(){
		linkText = "Finished";
		return linkText;
	}
	
	/**
	 * Vendor information email address txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Entity Email Address
	public static WebElement vendorInformationEmailAddress_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector("td.EntityEmail"));
		return element;
	}
	
	/**
	 * Vendor information email address txt.
	 *
	 * @return the string
	 */
	public static String vendorInformationEmailAddress_txt(){
		cssSelector = "td.EntityEmail";
		return cssSelector;
	}
	
	/**
	 * Finish top btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Finish top button
	public static WebElement finishTop_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_sbFinish1"));
		return element;
	}
	
	/**
	 * Finish top btn.
	 *
	 * @return the string
	 */
	public static String finishTop_btn(){
		id = "Main_Main_sbFinish1";
		return id;
	}
	
	/**
	 * Finish bottom btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Finish bottom button
	public static WebElement finishBottom_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_sbFinish2"));
		return element;
	}
	
	/**
	 * Finish bottom btn.
	 *
	 * @return the string
	 */
	public static String finishBottom_btn(){
		id = "Main_Main_sbFinish2";
		return id;
	}
	
	/**
	 * Finished btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Finished button
	public static WebElement finished_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_btnCloseToOrder"));
		return element;
	}
	
	/**
	 * Finished btn.
	 *
	 * @return the string
	 */
	public static String finished_btn(){
		id = "Main_btnCloseToOrder";
		return id;
	}
	
	/**
	 * Attached icon.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Attached Icon
	public static WebElement attached_icon(WebDriver driver){
		element = driver.findElement(By.id("pbAttach0_Icon"));
		return element;
	}
	
	/**
	 * Attached icon.
	 *
	 * @return the string
	 */
	public static String attached_icon(){
		id = "pbAttach0_Icon";
		return id;
	}
	
	/**
	 * Header txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Header text
	public static WebElement header_txt(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_vsMain"));
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
	 * Vendor section txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Vendor Section text
	public static WebElement vendorSection_txt(WebDriver driver){
		element = driver.findElement(By.id("divVendorsSection"));
		return element;
	}
	
	/**
	 * Vendor section txt.
	 *
	 * @return the string
	 */
	public static String vendorSection_txt(){
		id = "divVendorsSection";
		return id;
	}
	
	/**
	 * Fee lock btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Fee lock button
	public static WebElement feeLock_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#divBidLocks > div:nth-child(1) > div > div"));
		return element;
	}
	
	/**
	 * Fee lock btn.
	 *
	 * @return the string
	 */
	public static String feeLock_btn(){
		cssSelector = "#divBidLocks > div:nth-child(1) > div > div";
		return cssSelector;
	}
	
	/**
	 * Date lock btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Date lock button
	public static WebElement dateLock_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#divBidLocks > div:nth-child(3) > div > div"));
		return element;
	}
	
	/**
	 * Date lock btn.
	 *
	 * @return the string
	 */
	public static String dateLock_btn(){
		cssSelector = "#divBidLocks > div:nth-child(3) > div > div";
		return cssSelector;
	}
	
	/**
	 * Bid fee txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Bid Fee text
	public static WebElement bidFee_txt(WebDriver driver){
		element = driver.findElement(By.id("bidFeeData"));
		return element;
	}
	
	/**
	 * Bid fee txt.
	 *
	 * @return the string
	 */
	public static String bidFee_txt(){
		id = "bidFeeData";
		return id;
	}
	
	/**
	 * Bid date txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Bid Date text
	public static WebElement bidDate_txt(WebDriver driver){
		element = driver.findElement(By.id("bidDateData"));
		return element;
	}
	
	/**
	 * Bid date txt.
	 *
	 * @return the string
	 */
	public static String bidDate_txt(){
		id = "bidDateData";
		return id;
	}
	
	/**
	 * Order due date txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Order Due Date text
	public static WebElement orderDueDate_txt(WebDriver driver){
		element = driver.findElement(By.id("orderDueDate"));
		return element;
	}
	
	/**
	 * Order due date txt.
	 *
	 * @return the string
	 */
	public static String orderDueDate_txt(){
		id = "orderDueDate";
		return id;
	}
	
	/**
	 * I agree to pay the mercury network transaction fee chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// I agree to pay the Mercury Network transaction fee checkbox
	public static WebElement iAgreeToPayTheMercuryNetworkTransactionFee_chkbx(WebDriver driver){
		element = driver.findElement(By.id("chkPaymentNoticeAgree"));
		return element;
	}
	
	/**
	 * I agree to pay the mercury network transaction fee chkbx.
	 *
	 * @return the string
	 */
	public static String iAgreeToPayTheMercuryNetworkTransactionFee_chkbx(){
		id = "chkPaymentNoticeAgree";
		return id;
	}
	
	/**
	 * orderGroup_txt
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// I agree to pay the Mercury Network transaction fee checkbox
	public static WebElement orderGroup_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector("#divAssignmentInformationFields > div:nth-child(4) > div:nth-child(1) > div.MercuryDataItem.BreakAll"));
		return element;
	}
	
	/**
	 * orderGroup_txt
	 *
	 * @return the string
	 */
	public static String orderGroup_txt(){
		cssSelector = "#divAssignmentInformationFields > div:nth-child(4) > div:nth-child(1) > div.MercuryDataItem.BreakAll";
		return cssSelector;
	}
	
	/**
	 * lender_txt
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// I agree to pay the Mercury Network transaction fee checkbox
	public static WebElement lender_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector("#divAssignmentInformationFields > div:nth-child(4) > div:nth-child(2) > div.MercuryDataItem.BreakAll"));
		return element;
	}
	
	/**
	 * lender_txt
	 *
	 * @return the string
	 */
	public static String lender_txt(){
		cssSelector = "#divAssignmentInformationFields > div:nth-child(4) > div:nth-child(2) > div.MercuryDataItem.BreakAll";
		return cssSelector;
	}
	
	/**
	 * cancel button
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Cancel button
	public static WebElement cancel_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("td.MenuBar_Item_Label"));
		return element;
	}
	
	/**
	 * cancel button
	 *
	 * @return the string
	 */
	public static String cancel_btn(){
		cssSelector = "td.MenuBar_Item_Label";
		return cssSelector;
	}
	
}
