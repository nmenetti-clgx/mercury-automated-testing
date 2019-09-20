package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure Order Details page
 */
public class SOrderDetails {

	/** The element. */
	private static WebElement element = null;

	/** The id. */
	private static String id = null;

	/** The css selector. */
	private static String cssSelector = null;

	/** The xpath. */
	private static String xpath = null;


	/**
	 * Tracking number txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Tracking# text
	public static WebElement trackingNumber_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector("div.TrackingNumber"));
		return element;
	}

	/**
	 * Tracking number txt.
	 *
	 * @return the string
	 */
	public static String trackingNumber_txt(){
		cssSelector = "div.TrackingNumber";
		return cssSelector;
	}

	/**
	 * Agree radio btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Agree radio button
	public static WebElement agree_radioBtn(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_optLenderAccept"));
		return element;
	}

	/**
	 * Agree radio btn.
	 *
	 * @return the string
	 */
	public static String agree_radioBtn(){
		id = "Main_Main_optLenderAccept";
		return id;
	}

	/**
	 * Do not agree radio btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Do Not Agree radio button
	public static WebElement doNotAgree_radioBtn(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_optLenderCondDecline"));
		return element;
	}

	/**
	 * Do not agree radio btn.
	 *
	 * @return the string
	 */
	public static String doNotAgree_radioBtn(){
		id = "Main_Main_optLenderCondDecline";
		return id;
	}

	/**
	 * Reassign radio btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Reassign radio button
	public static WebElement reassign_radioBtn(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_optLenderReassign"));
		return element;
	}

	/**
	 * Reassign radio btn.
	 *
	 * @return the string
	 */
	public static String reassign_radioBtn(){
		id = "Main_Main_optLenderReassign";
		return id;
	}

	/**
	 * Fee txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// fee text box
	public static WebElement fee_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_txtLenderProposedFee"));
		return element;
	}

	/**
	 * Fee txtbx.
	 *
	 * @return the string
	 */
	public static String fee_txtbx(){
		id = "Main_Main_txtLenderProposedFee";
		return id;
	}

	/**
	 * Due date txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// due date text box
	public static WebElement dueDate_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_txtLenderProposedDueDate"));
		return element;
	}

	/**
	 * Due date txtbx.
	 *
	 * @return the string
	 */
	public static String dueDate_txtbx(){
		id = "Main_Main_txtLenderProposedDueDate";
		return id;
	}

	/**
	 * Calendar btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// calendar button
	public static WebElement calendar_btn(WebDriver driver){
		element = driver.findElement(By.id("imgConditionalDate"));
		return element;
	}

	/**
	 * Calendar btn.
	 *
	 * @return the string
	 */
	public static String calendar_btn(){
		id = "imgConditionalDate";
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
		element = driver.findElement(By.id("Main_Main_btnConditionalDecline"));
		return element;
	}

	/**
	 * Ok btn.
	 *
	 * @return the string
	 */
	public static String ok_btn(){
		id = "Main_Main_btnConditionalDecline";
		return id;
	}

	/**
	 * Ok modification requested btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// OK Modification Requested button
	public static WebElement okModificationRequested_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_btnModificationRequested"));
		return element;
	}

	/**
	 * Ok modification requested btn.
	 *
	 * @return the string
	 */
	public static String okModificationRequested_btn(){
		id = "Main_Main_btnModificationRequested";
		return id;
	}

	/**
	 * History txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// History text
	public static WebElement history_txt(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_upStatusHistory"));
		return element;
	}

	/**
	 * History txt.
	 *
	 * @return the string
	 */
	public static String history_txt(){
		id = "Main_Main_upStatusHistory";
		return id;
	}

	/**
	 * Vendor information txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Vendor Information text
	public static WebElement vendorInformation_txt(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_divVendorInformation"));
		return element;
	}

	/**
	 * Vendor information txt.
	 *
	 * @return the string
	 */
	public static String vendorInformation_txt(){
		id = "Main_Main_divVendorInformation";
		return id;
	}

	/**
	 * Vendor name txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Vendor Name text
	public static WebElement vendorName_txt(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_divVendorName"));
		return element;
	}

	/**
	 * Vendor name txt.
	 *
	 * @return the string
	 */
	public static String vendorName_txt(){
		id = "ctl00_ctl00_Main_Main_divVendorName";
		return id;
	}

	/**
	 * Vendor email txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Vendor Email text
	public static WebElement vendorEmail_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector("#Main_Main_divVendorInformation > div.psContent > table.EntityData > tbody:nth-child(1) > tr:nth-child(1) > td.EntityEmail"));
		return element;
	}

	/**
	 * Vendor email txt.
	 *
	 * @return the string
	 */
	public static String vendorEmail_txt(){
		cssSelector = "#Main_Main_divVendorInformation > div.psContent > table.EntityData > tbody:nth-child(1) > tr:nth-child(1) > td.EntityEmail";
		return cssSelector;
	}

	/**
	 * Property information txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Property Information text
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
	// Assignment Information text
	public static WebElement assignmentInformation_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector("div.AssignmentContent"));
		//		element = driver.findElement(By.cssSelector("div.AssignmentInformation"));
		return element;
	}

	/**
	 * Assignment information txt.
	 *
	 * @return the string
	 */
	public static String assignmentInformation_txt(){
		cssSelector = "div.AssignmentContent";
		//		cssSelector = "div.AssignmentInformation";
		return cssSelector;
	}

	/**
	 * Contact information txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Contact and Access Information text
	public static WebElement contactInformation_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector("div.Contacts"));
		return element;
	}

	/**
	 * Contact information txt.
	 *
	 * @return the string
	 */
	public static String contactInformation_txt(){
		cssSelector = "div.Contacts";
		return cssSelector;
	}

	/**
	 * Additional notification recipients txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Additional Notification Recipients text
	public static WebElement additionalNotificationRecipients_txt(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_divAdditionalRecipients"));
		return element;
	}

	/**
	 * Additional notification recipients txt.
	 *
	 * @return the string
	 */
	public static String additionalNotificationRecipients_txt(){
		id = "Main_Main_divAdditionalRecipients";
		return id;
	}

	/**
	 * Product requirements txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Product Requirements text
	public static WebElement productRequirements_txt(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_divProductRequirements"));
		return element;
	}

	/**
	 * Product requirements txt.
	 *
	 * @return the string
	 */
	public static String productRequirements_txt(){
		id = "Main_Main_divProductRequirements";
		return id;
	}

	/**
	 * Error txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Error text
	public static WebElement error_txt(WebDriver driver){
		element = driver.findElement(By.id("divMessageOKText"));
		return element;
	}

	/**
	 * Error txt.
	 *
	 * @return the string
	 */
	public static String error_txt(){
		id = "divMessageOKText";
		return id;
	}

	/**
	 * Error ok btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Error Ok Button
	public static WebElement errorOk_btn(WebDriver driver){
		element = driver.findElement(By.id("sbdmButton1"));
		return element;
	}

	/**
	 * Error ok btn.
	 *
	 * @return the string
	 */
	public static String errorOk_btn(){
		id = "sbdmButton1";
		return id;
	}

	/**
	 * Agree txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Agree text
	public static WebElement agree_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector(".RightMargin0"));
		return element;
	}

	/**
	 * Agree txt.
	 *
	 * @return the string
	 */
	public static String agree_txt(){
		cssSelector = ".RightMargin0";
		return cssSelector;
	}

	/**
	 * Do not agree txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Do Not Agree text
	public static WebElement doNotAgree_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector("div.OptionWrapper:nth-child(5) > div:nth-child(2)"));
		return element;
	}

	/**
	 * Do not agree txt.
	 *
	 * @return the string
	 */
	public static String doNotAgree_txt(){
		cssSelector = "div.OptionWrapper:nth-child(5) > div:nth-child(2)";
		return cssSelector;
	}

	/**
	 * Reassign txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Reassign text
	public static WebElement reassign_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector("div.OptionWrapper:nth-child(7) > div:nth-child(2) > label:nth-child(1)"));
		return element;
	}

	/**
	 * Reassign txt.
	 *
	 * @return the string
	 */
	public static String reassign_txt(){
		cssSelector = "div.OptionWrapper:nth-child(7) > div:nth-child(2) > label:nth-child(1)";
		return cssSelector;
	}

	/**
	 * Message btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Message button
	public static WebElement message_btn(WebDriver driver){
		element = driver.findElement(By.xpath("//td[contains(text(), 'Message')]"));
		return element;
	}

	/**
	 * Message btn.
	 *
	 * @return the string
	 */
	public static String message_btn(){
		xpath = "//td[contains(text(), 'Message')]";
		return xpath;
	}

	/**
	 * Sets the status btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Set Status button
	public static WebElement setStatus_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/App_Themes/FlatGrayscale/Icons/Bullhorn.O.png']"));
		return element;
	}

	/**
	 * Sets the status btn.
	 *
	 * @return the string
	 */
	public static String setStatus_btn(){
		cssSelector = "img[src='/App_Themes/FlatGrayscale/Icons/Bullhorn.O.png']";
		return cssSelector;
	}

	/**
	 * Place on hold btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Place On Hold button
	public static WebElement placeOnHold_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("tr.MenuBar_Menu_Item:nth-child(3) > td:nth-child(2)"));
		return element;
	}

	/**
	 * Place on hold btn.
	 *
	 * @return the string
	 */
	public static String placeOnHold_btn(){
		cssSelector = "tr.MenuBar_Menu_Item:nth-child(3) > td:nth-child(2)";
		return cssSelector;
	}

	/**
	 * Resume btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Resume button
	public static WebElement resume_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("tr.MenuBar_Menu_Item:nth-child(5) > td:nth-child(2)"));
		return element;
	}

	/**
	 * Resume btn.
	 *
	 * @return the string
	 */
	public static String resume_btn(){
		cssSelector = "tr.MenuBar_Menu_Item:nth-child(5) > td:nth-child(2)";
		return cssSelector;
	}

	/**
	 * Submit to UCD P btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Submit to UCDP button
	public static WebElement submitToUCDP_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#Main_Main_mbMain_3 > table > tbody > tr:nth-child(9) > td.MenuBar_Menu_Item_Label"));
		return element;
	}

	/**
	 * Submit to UCD P btn.
	 *
	 * @return the string
	 */
	public static String submitToUCDP_btn(){
		cssSelector = "#Main_Main_mbMain_3 > table > tbody > tr:nth-child(9) > td.MenuBar_Menu_Item_Label";
		return cssSelector;
	}

	/**
	 * Request revision btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Request revision button
	public static WebElement requestRevision_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#Main_Main_mbMain_3 > table > tbody > tr:nth-child(6) > td.MenuBar_Menu_Item_Label"));
		return element;
	}

	/**
	 * Request revision btn.
	 *
	 * @return the string
	 */
	public static String requestRevision_btn(){
		cssSelector = "#Main_Main_mbMain_3 > table > tbody > tr:nth-child(6) > td.MenuBar_Menu_Item_Label";
		return cssSelector;
	}

	/**
	 * Send via sure receipts btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Send via SureReceipts button
	public static WebElement sendViaSureReceipts_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#Main_Main_mbMain_3 > table > tbody > tr:nth-child(16) > td.MenuBar_Menu_Item_Label"));
		return element;
	}

	/**
	 * Send via sure receipts btn.
	 *
	 * @return the string
	 */
	public static String sendViaSureReceipts_btn(){
		cssSelector = "#Main_Main_mbMain_3 > table > tbody > tr:nth-child(16) > td.MenuBar_Menu_Item_Label";
		return cssSelector;
	}

	/**
	 * Send in send via sure receipts btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Send button in Send via SureReceipts
	public static WebElement sendInSendViaSureReceipts_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_btnSend"));
		return element;
	}

	/**
	 * Send in send via sure receipts btn.
	 *
	 * @return the string
	 */
	public static String sendInSendViaSureReceipts_btn(){
		id = "Main_btnSend";
		return id;
	}

	/**
	 * Sets the status cancel btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Set Status Cancel button
	public static WebElement setStatusCancel_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("tr.MenuBar_Menu_Item:nth-child(13) > td:nth-child(2)"));
		return element;
	}

	/**
	 * Sets the status cancel btn.
	 *
	 * @return the string
	 */
	public static String setStatusCancel_btn(){
		cssSelector = "tr.MenuBar_Menu_Item:nth-child(13) > td:nth-child(2)";
		return cssSelector;
	}

	/**
	 * Sets the order status txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Set Order Status text
	public static WebElement setOrderStatus_txt(WebDriver driver){
		element = driver.findElement(By.id("divSetStatus"));
		return element;
	}

	/**
	 * Sets the order status txt.
	 *
	 * @return the string
	 */
	public static String setOrderStatus_txt(){
		id = "divSetStatus";
		return id;
	}

	/**
	 * Resume set order status txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Resume Set Order Status text
	public static WebElement resumeSetOrderStatus_txt(WebDriver driver){
		element = driver.findElement(By.id("divSetStatusNewDate"));
		return element;
	}

	/**
	 * Resume set order status txt.
	 *
	 * @return the string
	 */
	public static String resumeSetOrderStatus_txt(){
		id = "divSetStatusNewDate";
		return id;
	}

	/**
	 * Sets the order status resume txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Set Order Status Resume text
	public static WebElement setOrderStatusResume_txt(WebDriver driver){
		element = driver.findElement(By.id("divSetStatusNewDate"));
		return element;
	}

	/**
	 * Sets the order status resume txt.
	 *
	 * @return the string
	 */
	public static String setOrderStatusResume_txt(){
		id = "divSetStatusNewDate";
		return id;
	}

	/**
	 * Message txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Send Message text
	public static WebElement message_txt(WebDriver driver){
		element = driver.findElement(By.id("divSendMessage"));
		return element;
	}

	/**
	 * Message txt.
	 *
	 * @return the string
	 */
	public static String message_txt(){
		id = "divSendMessage";
		return id;
	}

	/**
	 * Send message txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Message textbox
	public static WebElement sendMessage_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ctlSendMessages_txtMessage"));
		return element;
	}

	/**
	 * Send message txtbx.
	 *
	 * @return the string
	 */
	public static String sendMessage_txtbx(){
		id = "Dialogs_Dialogs_ctlSendMessages_txtMessage";
		return id;
	}

	/**
	 * Borrower requests to place everything on hold chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Borrower requests to place everything on hold checkbox
	public static WebElement borrowerRequestsToPlaceEverythingOnHold_chkbx(WebDriver driver){
		element = driver.findElement(By.xpath("//label[contains(text(), 'Borrower requests to place everything on hold')]"));
		return element;
	}

	/**
	 * Borrower requests to place everything on hold chkbx.
	 *
	 * @return the string
	 */
	public static String borrowerRequestsToPlaceEverythingOnHold_chkbx(){
		xpath = "//label[contains(text(), 'Borrower requests to place everything on hold')]";
		return xpath;
	}

	/**
	 * Sets the order status cancel btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Set Order Status Cancel button
	public static WebElement setOrderStatusCancel_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ctl02"));
		return element;
	}

	/**
	 * Sets the order status cancel btn.
	 *
	 * @return the string
	 */
	public static String setOrderStatusCancel_btn(){
		id = "Dialogs_Dialogs_ctl02";
		return id;
	}

	/**
	 * Sets the order status ok btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Set Order Status Ok button
	public static WebElement setOrderStatusOk_btn(WebDriver driver){
			element = driver.findElement(By.id("Dialogs_Dialogs_sbSetStatusOK"));
		return element;
	}

	/**
	 * Sets the order status ok btn.
	 *
	 * @return the string
	 */
	public static String setOrderStatusOk_btn(){
			id = "Dialogs_Dialogs_sbSetStatusOK";
		return id;
	}

	/**
	 * Sets the order status due date txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Set Order Status Due Date txtbx
	public static WebElement setOrderStatusDueDate_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_txtNewDueDate"));
		return element;
	}

	/**
	 * Sets the order status due date txtbx.
	 *
	 * @return the string
	 */
	public static String setOrderStatusDueDate_txtbx(){
		id = "Dialogs_Dialogs_txtNewDueDate";
		return id;
	}

	/**
	 * Sets the order status calendar btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Set Order Status Calendar button
	public static WebElement setOrderStatusCalendar_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_imgCalendar"));
		return element;
	}

	/**
	 * Sets the order status calendar btn.
	 *
	 * @return the string
	 */
	public static String setOrderStatusCalendar_btn(){
		id = "Dialogs_Dialogs_imgCalendar";
		return id;
	}

	/**
	 * Borrower ready to continue chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Borrower ready to continue checkbox
	public static WebElement borrowerReadyToContinue_chkbx(WebDriver driver){
		element = driver.findElement(By.xpath("//label[contains(text(), 'Borrower ready to continue')]"));
		return element;
	}

	/**
	 * Borrower ready to continue chkbx.
	 *
	 * @return the string
	 */
	public static String borrowerReadyToContinue_chkbx(){
		xpath = "//label[contains(text(), 'Borrower ready to continue')]";
		return xpath;
	}

	/**
	 * Sets the order status resume cancel btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Set Order Status Resume Cancel button
	public static WebElement setOrderStatusResumeCancel_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ctl06"));
		return element;
	}

	/**
	 * Sets the order status resume cancel btn.
	 *
	 * @return the string
	 */
	public static String setOrderStatusResumeCancel_btn(){
		id = "Dialogs_Dialogs_ctl06";
		return id;
	}

	/**
	 * Sets the order status resume ok btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Set Order Status Resume Ok button
	public static WebElement setOrderStatusResumeOk_btn(WebDriver driver){
			element = driver.findElement(By.id("Dialogs_Dialogs_sbNewDateOK"));
		return element;
	}

	/**
	 * Sets the order status resume ok btn.
	 *
	 * @return the string
	 */
	public static String setOrderStatusResumeOk_btn(){
			id = "Dialogs_Dialogs_sbNewDateOK";
			return id;
	}

	/**
	 * Mc is not required for this job chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// 1004MC is not required for this job checkbox
	public static WebElement mcIsNotRequiredForThisJob_chkbx(WebDriver driver){
		element = driver.findElement(By.xpath("//label[contains(text(), '1004MC is not required for this job.')]"));
		return element;
	}

	/**
	 * Mc is not required for this job chkbx.
	 *
	 * @return the string
	 */
	public static String mcIsNotRequiredForThisJob_chkbx(){
		xpath = "//label[contains(text(), '1004MC is not required for this job.')]";
		return xpath;
	}

	/**
	 * Message cancel btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Message Cancel button
	public static WebElement messageCancel_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ctl11"));
		return element;
	}

	/**
	 * Message cancel btn.
	 *
	 * @return the string
	 */
	public static String messageCancel_btn(){
		id = "Dialogs_Dialogs_ctl11";
		return id;
	}

	/**
	 * Message ok btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Message Ok button
	public static WebElement messageOk_btn(WebDriver driver){
			element = driver.findElement(By.id("Dialogs_Dialogs_sbSendMessageOK"));
		return element;
	}

	/**
	 * Message ok btn.
	 *
	 * @return the string
	 */
	public static String messageOk_btn(){
			id = "Dialogs_Dialogs_sbSendMessageOK";
		return id;
	}

	/**
	 * Sets the status cancel cancel btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Set Status Cancel Cancel button
	public static WebElement setStatusCancelCancel_btn(WebDriver driver){
			element = driver.findElement(By.id("Dialogs_Dialogs_sbSetStatusCancel"));
		return element;
	}

	/**
	 * Sets the status cancel cancel btn.
	 *
	 * @return the string
	 */
	public static String setStatusCancelCancel_btn(){
			id = "Dialogs_Dialogs_sbSetStatusCancel";
		return id;
	}

	/**
	 * Assign btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Assign button
	public static WebElement assign_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_btnReassign"));
		return element;
	}

	/**
	 * Assign btn.
	 *
	 * @return the string
	 */
	public static String assign_btn(){
		id = "Main_Main_btnReassign";
		return id;
	}

	/**
	 * Modify selection settings btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Modify selection settings button
	public static WebElement modifySelectionSettings_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_btnModifySelectionSettings"));
		return element;
	}

	/**
	 * Modify selection settings btn.
	 *
	 * @return the string
	 */
	public static String modifySelectionSettings_btn(){
		id = "Main_Main_btnModifySelectionSettings";
		return id;
	}

	/**
	 * Documents txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Order Documents Text
	public static WebElement documents_txt(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_divDocuments"));
		return element;
	}

	/**
	 * Documents txt.
	 *
	 * @return the string
	 */
	public static String documents_txt(){
		id = "Main_Main_divDocuments";
		return id;
	}

	/**
	 * Request revision radio btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Request vendor make revisions to this report
	public static WebElement requestRevision_radioBtn(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_optRevision"));
		return element;
	}

	/**
	 * Request revision radio btn.
	 *
	 * @return the string
	 */
	public static String requestRevision_radioBtn(){
		id = "Main_Main_optRevision";
		return id;
	}

	/**
	 * Comments to client txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Comments to client text box
	public static WebElement commentsToClient_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_txtPendingReviewComments_Client"));
		return element;
	}

	/**
	 * Comments to client txtbx.
	 *
	 * @return the string
	 */
	public static String commentsToClient_txtbx(){
		id = "Main_Main_txtPendingReviewComments_Client";
		return id;
	}

	/**
	 * Comments to vendor txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Comments to vendor text box
	public static WebElement commentsToVendor_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_txtPendingReviewComments_Vendor"));
		return element;
	}

	/**
	 * Comments to vendor txtbx.
	 *
	 * @return the string
	 */
	public static String commentsToVendor_txtbx(){
		id = "Main_Main_txtPendingReviewComments_Vendor";
		return id;
	}

	/**
	 * Comments to vendor modification requested txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Comments to vendor Modification Requested text box
	public static WebElement commentsToVendorModificationRequested_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_txtModificationRequestedComments_txtMessage"));
		return element;
	}

	/**
	 * Comments to vendor modification requested txtbx.
	 *
	 * @return the string
	 */
	public static String commentsToVendorModificationRequested_txtbx(){
		id = "Main_Main_txtModificationRequestedComments_txtMessage";
		return id;
	}

	/**
	 * Comments to borrower txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Comments to borrower text box
	public static WebElement commentsToBorrower_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_txtCommentsToBorrower"));
		return element;
	}

	/**
	 * Comments to borrower txtbx.
	 *
	 * @return the string
	 */
	public static String commentsToBorrower_txtbx(){
		id = "Main_Main_txtCommentsToBorrower";
		return id;
	}

	/**
	 * Update status on VM P chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Update status on VMP XSite and notify client checkbox
	public static WebElement updateStatusOnVMP_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_chkMarkRevisionRequestedSyncVMPStatus"));
		return element;
	}

	/**
	 * Update status on VM P chkbx.
	 *
	 * @return the string
	 */
	public static String updateStatusOnVMP_chkbx(){
		id = "Main_Main_chkMarkRevisionRequestedSyncVMPStatus";
		return id;
	}

	/**
	 * Send message update status on VM P chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Update status on VMP XSite and notify client checkbox on Send Message screen
	public static WebElement sendMessageUpdateStatusOnVMP_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_chkUpdateVMPSendMessage"));
		return element;
	}

	/**
	 * Send message update status on VM P chkbx.
	 *
	 * @return the string
	 */
	public static String sendMessageUpdateStatusOnVMP_chkbx(){
		id = "Dialogs_Dialogs_chkUpdateVMPSendMessage";
		return id;
	}

	/**
	 * Ok process received report btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// OK button
	public static WebElement okProcessReceivedReport_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_PendingReviewButton"));
		return element;
	}

	/**
	 * Ok process received report btn.
	 *
	 * @return the string
	 */
	public static String okProcessReceivedReport_btn(){
		id = "Main_Main_PendingReviewButton";
		return id;
	}

	/**
	 * Sync to VM P btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Sync to VMP button
	public static WebElement syncToVMP_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/App_Themes/FlatGrayscale/Icons/SyncTo.O.png']"));
		return element;
	}

	/**
	 * Sync to VM P btn.
	 *
	 * @return the string
	 */
	public static String syncToVMP_btn(){
		cssSelector = "img[src='/App_Themes/FlatGrayscale/Icons/SyncTo.O.png']";
		return cssSelector;
	}

	/**
	 * Sync to VMP ok btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Sync to VMP OK button
	public static WebElement syncToVMPOk_btn(WebDriver driver){
			element = driver.findElement(By.id("Dialogs_Dialogs_sbSyncToVMPOK"));
		return element;
	}

	/**
	 * Sync to VMP ok btn.
	 *
	 * @return the string
	 */
	public static String syncToVMPOk_btn(){
			id = "Dialogs_Dialogs_sbSyncToVMPOK";
		return id;
	}

	/**
	 * Sync to VMP action required chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Sync to VMP Action Required checkbox
	public static WebElement syncToVMPActionRequired_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_chkSyncAsActionRequired"));
		return element;
	}

	/**
	 * Sync to VMP action required chkbx.
	 *
	 * @return the string
	 */
	public static String syncToVMPActionRequired_chkbx(){
		id = "Dialogs_Dialogs_chkSyncAsActionRequired";
		return id;
	}

	/**
	 * Sync to VMP notes txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Sync to VMP Notes text box
	public static WebElement syncToVMPNotes_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ctlStatusMessageSyncToVMP_txtMessage"));
		return element;
	}

	/**
	 * Sync to VMP notes txtbx.
	 *
	 * @return the string
	 */
	public static String syncToVMPNotes_txtbx(){
		id = "Dialogs_Dialogs_ctlStatusMessageSyncToVMP_txtMessage";
		return id;
	}

	/**
	 * Sync tool tip icon.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Sync tool tip icon
	public static WebElement syncToolTip_icon(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='Images/Push-Icon-blue.png']"));
		return element;
	}

	/**
	 * Sync tool tip icon.
	 *
	 * @return the string
	 */
	public static String syncToolTip_icon(){
		cssSelector = "img[src='Images/Push-Icon-blue.png']";
		return cssSelector;
	}

	/**
	 * Mark order as complete without syncing to X site chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Mark order as complete without syncing to XSite checkbox
	public static WebElement markOrderAsCompleteWithoutSyncingToXSite_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_chkMarkCompleteSyncVMPStatus"));
		return element;
	}

	/**
	 * Mark order as complete without syncing to X site chkbx.
	 *
	 * @return the string
	 */
	public static String markOrderAsCompleteWithoutSyncingToXSite_chkbx(){
		id = "Main_Main_chkMarkCompleteSyncVMPStatus";
		return id;
	}

	/**
	 * Client documents txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Client documents text
	public static WebElement clientDocuments_txt(WebDriver driver){
		element = driver.findElement(By.id("divDocumentListItems"));
		return element;
	}

	/**
	 * Client documents txt.
	 *
	 * @return the string
	 */
	public static String clientDocuments_txt(){
		id = "divDocumentListItems";
		return id;
	}

	/**
	 * Accept this report as is radio btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Accept this report as is
	public static WebElement acceptThisReportAsIs_radioBtn(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_optPendingOK"));
		return element;
	}

	/**
	 * Accept this report as is radio btn.
	 *
	 * @return the string
	 */
	public static String acceptThisReportAsIs_radioBtn(){
		id = "Main_Main_optPendingOK";
		return id;
	}

	/**
	 * Email A copy of the report to the borrower chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Email a copy of the report to the borrower checkbox
	public static WebElement emailACopyOfTheReportToTheBorrower_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_chkSendCompletedReport"));
		return element;
	}

	/**
	 * Email A copy of the report to the borrower chkbx.
	 *
	 * @return the string
	 */
	public static String emailACopyOfTheReportToTheBorrower_chkbx(){
		id = "Main_Main_chkSendCompletedReport";
		return id;
	}

	/**
	 * Borrowers email txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Borrowers email text
	public static WebElement borrowersEmail_txt(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_txtBorrowerEmail"));
		return element;
	}

	/**
	 * Borrowers email txt.
	 *
	 * @return the string
	 */
	public static String borrowersEmail_txt(){
		id = "Main_Main_txtBorrowerEmail";
		return id;
	}

	/**
	 * Edits the btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Edit button
	public static WebElement edit_btn(WebDriver driver){
		element = driver.findElement(By.xpath("//td[contains(text(), 'Edit')]"));
		return element;
	}

	/**
	 * Edits the btn.
	 *
	 * @return the string
	 */
	public static String edit_btn(){
		xpath = "//td[contains(text(), 'Edit')]";
		return xpath;
	}

	/**
	 * View X site order lnk.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// View XSite Order link
	public static WebElement viewXSiteOrder_lnk(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_lnkXSiteOrder"));
		return element;
	}

	/**
	 * View X site order lnk.
	 *
	 * @return the string
	 */
	public static String viewXSiteOrder_lnk(){
		id = "Main_Main_lnkXSiteOrder";
		return id;
	}

	/**
	 * Order due txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Order due text
	public static WebElement orderDue_txt(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_lnkOrderDue"));
		return element;
	}

	/**
	 * Order due txt.
	 *
	 * @return the string
	 */
	public static String orderDue_txt(){
		id = "Main_Main_lnkOrderDue";
		return id;
	}

	/**
	 * Order fee txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Order fee text
	public static WebElement orderFee_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector("#divAssignmentContent > div:nth-child(1) > div:nth-child(3) > div.MercuryDataItem.BreakAll"));
		return element;
	}

	/**
	 * Order fee txt.
	 *
	 * @return the string
	 */
	public static String orderFee_txt(){
		cssSelector = "#divAssignmentContent > div:nth-child(1) > div:nth-child(3) > div.MercuryDataItem.BreakAll";
		return cssSelector;
	}

	/**
	 * Vendor information btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Vendor Information button
	public static WebElement vendorInformation_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_imgAppraiserProfile"));
		return element;
	}

	/**
	 * Vendor information btn.
	 *
	 * @return the string
	 */
	public static String vendorInformation_btn(){
		id = "Main_Main_imgAppraiserProfile";
		return id;
	}

	/**
	 * Reassign btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Reassign button
	public static WebElement reassign_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_btnReassign"));
		return element;
	}

	/**
	 * Reassign btn.
	 *
	 * @return the string
	 */
	public static String reassign_btn(){
		id = "Main_Main_btnReassign";
		return id;
	}

	/**
	 * FRE quality risk txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// FRE Quality Risk text
	public static WebElement FREQualityRisk_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector("#Main_Main_divQualityRiskScore > div.MercuryDataItem.BreakAll"));
		return element;
	}

	/**
	 * FRE quality risk txt.
	 *
	 * @return the string
	 */
	public static String FREQualityRisk_txt(){
		cssSelector = "#Main_Main_divQualityRiskScore > div.MercuryDataItem.BreakAll";
		return cssSelector;
	}

	/**
	 * FRE valuation risk txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// FRE Valuation Risk text
	public static WebElement FREValuationRisk_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector("#Main_Main_divValuationRiskScore > div.MercuryDataItem.BreakAll"));
		return element;
	}

	/**
	 * FRE valuation risk txt.
	 *
	 * @return the string
	 */
	public static String FREValuationRisk_txt(){
		cssSelector = "#Main_Main_divValuationRiskScore > div.MercuryDataItem.BreakAll";
		return cssSelector;
	}

	/**
	 * Eligible fee panel vendors txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Eligible fee panel vendors text
	public static WebElement eligibleFeePanelVendors_txt(WebDriver driver){
		element = driver.findElement(By.id("divEligibleFeePanelVendorsContainer"));
		return element;
	}

	/**
	 * Eligible fee panel vendors txt.
	 *
	 * @return the string
	 */
	public static String eligibleFeePanelVendors_txt(){
		id = "divEligibleFeePanelVendorsContainer";
		return id;
	}

	/**
	 * Email btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Email button
	public static WebElement email_btn(WebDriver driver){
		element = driver.findElement(By.id("btnEmailEligibleVendors"));
		return element;
	}

	/**
	 * Email btn.
	 *
	 * @return the string
	 */
	public static String email_btn(){
		id = "btnEmailEligibleVendors";
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
		element = driver.findElement(By.id("Dialogs_Dialogs_sbEmailVendorsCancel"));
		return element;
	}

	/**
	 * Cancel btn.
	 *
	 * @return the string
	 */
	public static String cancel_btn(){
		id = "Dialogs_Dialogs_sbEmailVendorsCancel";
		return id;
	}

	/**
	 * Send btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Send button
	public static WebElement send_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_btnSendEmailEligibleVendors"));
		return element;
	}

	/**
	 * Send btn.
	 *
	 * @return the string
	 */
	public static String send_btn(){
		id = "Dialogs_Dialogs_btnSendEmailEligibleVendors";
		return id;
	}

	/**
	 * Email eligible vendors dialog txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Email eligible vendors dialog text
	public static WebElement emailEligibleVendorsDialog_txt(WebDriver driver){
		element = driver.findElement(By.id("divEmailVendors"));
		return element;
	}

	/**
	 * Email eligible vendors dialog txt.
	 *
	 * @return the string
	 */
	public static String emailEligibleVendorsDialog_txt(){
		id = "divEmailVendors";
		return id;
	}

	/**
	 * Email eligible vendors message txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Email eligible vendors message textbox
	public static WebElement emailEligibleVendorsMessage_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_txtEmailEligibleVendorsMessage_txtMessage"));
		return element;
	}

	/**
	 * Email eligible vendors message txtbx.
	 *
	 * @return the string
	 */
	public static String emailEligibleVendorsMessage_txtbx(){
		id = "Dialogs_Dialogs_txtEmailEligibleVendorsMessage_txtMessage";
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
	 * I agree to the requested product modifications radio btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// I agree to the requested product modifications radio button
	public static WebElement iAgreeToTheRequestedProductModifications_radioBtn(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_optAcceptModification"));
		return element;
	}

	/**
	 * I agree to the requested product modifications radio btn.
	 *
	 * @return the string
	 */
	public static String iAgreeToTheRequestedProductModifications_radioBtn(){
		id = "Main_Main_optAcceptModification";
		return id;
	}

	/**
	 * I do not agree to the requested product modifications requested radio btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// I do not agree to the requested product modifications requested radio button
	public static WebElement iDoNotAgreeToTheRequestedProductModificationsRequested_radioBtn(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_optDeclineModification"));
		return element;
	}

	/**
	 * I do not agree to the requested product modifications requested radio btn.
	 *
	 * @return the string
	 */
	public static String iDoNotAgreeToTheRequestedProductModificationsRequested_radioBtn(){
		id = "Main_Main_optDeclineModification";
		return id;
	}

	/**
	 * Banner txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Banner text
	public static WebElement banner_txt(WebDriver driver){
		element = driver.findElement(By.id("divOrderAlerts"));
		return element;
	}

	/**
	 * Banner txt.
	 *
	 * @return the string
	 */
	public static String banner_txt(){
		id = "divOrderAlerts";
		return id;
	}

	/**
	 * Appraiser radiobtn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Appraiser radio button
	public static WebElement appraiser_radiobtn(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_rbVendorTypeAppraiser"));
		return element;
	}

	/**
	 * Appraiser radiobtn.
	 *
	 * @return the string
	 */
	public static String appraiser_radiobtn(){
		id = "Main_Main_rbVendorTypeAppraiser";
		return id;
	}

	/**
	 * Amc firm radiobtn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// AMC/Firm radio button
	public static WebElement amcFirm_radiobtn(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_rbVendorTypeAMC"));
		return element;
	}

	/**
	 * Amc firm radiobtn.
	 *
	 * @return the string
	 */
	public static String amcFirm_radiobtn(){
		id = "Main_Main_rbVendorTypeAMC";
		return id;
	}

	/**
	 * Attach btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Attach button
	public static WebElement attach_btn(WebDriver driver){
		element = driver.findElement(By.xpath("//td[contains(text(), 'Attach')]"));
		return element;
	}

	/**
	 * Attach btn.
	 *
	 * @return the string
	 */
	public static String attach_btn(){
		xpath = "//td[contains(text(), 'Attach')]";
		return xpath;
	}

	/**
	 * Upload documents btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Upload Documents button
	public static WebElement uploadDocuments_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_lbAttachUpload"));
		return element;
	}

	/**
	 * Upload documents btn.
	 *
	 * @return the string
	 */
	public static String uploadDocuments_btn(){
		id = "Dialogs_Dialogs_lbAttachUpload";
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
		element = driver.findElement(By.id("Dialogs_Dialogs_lbAttachCancel"));
		return element;
	}

	/**
	 * Close btn.
	 *
	 * @return the string
	 */
	public static String close_btn(){
		id = "Dialogs_Dialogs_lbAttachCancel";
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
	 * Document type dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Document Type dropdown
	public static WebElement documentType_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ddlDocumentTypes"));
		return element;
	}

	/**
	 * Document type dropdown.
	 *
	 * @return the string
	 */
	public static String documentType_dropdown(){
		id = "Dialogs_Dialogs_ddlDocumentTypes";
		return id;
	}

	/**
	 * Attach completed report to X site chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Attach completed report to XSite checkbox
	public static WebElement attachCompletedReportToXSite_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_chkCOAOClientAttachments"));
		return element;
	}

	/**
	 * Attach completed report to X site chkbx.
	 *
	 * @return the string
	 */
	public static String attachCompletedReportToXSite_chkbx(){
		id = "Main_Main_chkCOAOClientAttachments";
		return id;
	}

	/**
	 * Attach completed report to additional recipients chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Attach completed report to Additional Recipients checkbox
	public static WebElement attachCompletedReportToAdditionalRecipients_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_chkCOAOAddtlRecipientAttachments"));
		return element;
	}

	/**
	 * Attach completed report to additional recipients chkbx.
	 *
	 * @return the string
	 */
	public static String attachCompletedReportToAdditionalRecipients_chkbx(){
		id = "Main_Main_chkCOAOAddtlRecipientAttachments";
		return id;
	}

	/**
	 * Start AQ M btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Start AQM button
	public static WebElement startAQM_btn(WebDriver driver){
		element = driver.findElement(By.xpath("//td[contains(text(), 'Start AQM')]"));
		return element;
	}

	/**
	 * Start AQ M btn.
	 *
	 * @return the string
	 */
	public static String startAQM_btn(){
		xpath = "//td[contains(text(), 'Start AQM')]";
		return xpath;
	}

	/**
	 * AQM Agree btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement aqmAgree_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_sbAQMEULAAgree"));
		return element;
	}

	/**
	 * AQM Agree btn.
	 *
	 * @return the string
	 */
	public static String aqmAgree_btn(){
		id = "Dialogs_Dialogs_sbAQMEULAAgree";
		return id;
	}
	
	/**
	 * AQM RealView btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement aqmRealView_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_ctlAQMModulesList_grdNonMNModules_imgProduct_0"));
		return element;
	}

	/**
	 * AQM RealView btn.
	 *
	 * @return the string
	 */
	public static String aqmRealView_btn(){
		id = "Main_ctlAQMModulesList_grdNonMNModules_imgProduct_0";
		return id;
	}
	
	/**
	 * Ok start AQ M btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// OK button for Start AQM
	public static WebElement okStartAQM_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_btnStartingAQMOK"));
		return element;
	}

	/**
	 * Ok start AQ M btn.
	 *
	 * @return the string
	 */
	public static String okStartAQM_btn(){
		id = "Main_btnStartingAQMOK";
		return id;
	}
	
	/**
	 * PlatData Username txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// OK button for Start AQM
	public static WebElement platdataUsername_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_txtUsername"));
		return element;
	}

	/**
	 * PlatData Username txtbx.
	 *
	 * @return the string
	 */
	public static String platdataUsername_txtbx(){
		id = "Dialogs_txtUsername";
		return id;
	}
	
	/**
	 * PlatData Password txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// OK button for Start AQM
	public static WebElement platdataPassword_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_txtPassword"));
		return element;
	}

	/**
	 * PlatData Password txtbx.
	 *
	 * @return the string
	 */
	public static String platdataPassword_txtbx(){
		id = "Dialogs_txtPassword";
		return id;
	}
	
	/**
	 * PlatData Save btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// OK button for Start AQM
	public static WebElement platdataSave_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_sbPlatinumDataAccountSave"));
		return element;
	}

	/**
	 * PlatData Save btn.
	 *
	 * @return the string
	 */
	public static String platdataSave_btn(){
		id = "Dialogs_sbPlatinumDataAccountSave";
		return id;
	}
	
	/**
	 * PlatData Save OK btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// OK button for Start AQM
	public static WebElement platdataSaveOK_btn(WebDriver driver){
		element = driver.findElement(By.id("sbdmButton1"));
		return element;
	}

	/**
	 * PlatData Save OK btn.
	 *
	 * @return the string
	 */
	public static String platdataSaveOK_btn(){
		id = "sbdmButton1";
		return id;
	}
	
	/**
	 * Aqi chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// AQI checkbox
	public static WebElement aqi_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_ctlAQMModulesList_gvAQMModules_imgProduct_0"));
		return element;
	}

	/**
	 * Aqi chkbx.
	 *
	 * @return the string
	 */
	public static String aqi_chkbx(){
		id = "Main_ctlAQMModulesList_gvAQMModules_imgProduct_0";
		return id;
	}

	/**
	 * Aqm Q C chcbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// AQM QC checkbox
	public static WebElement aqmQC_chcbx(WebDriver driver){
		element = driver.findElement(By.id("Main_ctlAQMModulesList_gvAQMModules_imgProduct_1"));
		return element;
	}

	/**
	 * Aqm Q C chcbx.
	 *
	 * @return the string
	 */
	public static String aqmQC_chcbx(){
		id = "Main_ctlAQMModulesList_gvAQMModules_imgProduct_1";
		return id;
	}

	/**
	 * Ok payment acknowledgement btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// OK button for Payment acknowledgement
	public static WebElement okPaymentAcknowledgement_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_sbPaymentAckOK"));
		return element;
	}

	/**
	 * Ok payment acknowledgement btn.
	 *
	 * @return the string
	 */
	public static String okPaymentAcknowledgement_btn(){
		id = "Dialogs_sbPaymentAckOK";
		return id;
	}

	/**
	 * Finish btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Finish button
	public static WebElement finish_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_sbFinish1"));
		return element;
	}

	/**
	 * Finish btn.
	 *
	 * @return the string
	 */
	public static String finish_btn(){
		id = "Main_Main_sbFinish1";
		return id;
	}

	/**
	 * Review bids btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Review Bids button
	public static WebElement reviewBids_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/App_Themes/FlatGrayscale/Icons/Review.O.png']"));
		return element;
	}

	/**
	 * Review bids btn.
	 *
	 * @return the string
	 */
	public static String reviewBids_btn(){
		cssSelector = "img[src='/App_Themes/FlatGrayscale/Icons/Review.O.png']";
		return cssSelector;
	}

	/**
	 * Order fee award bid txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Order fee text
	public static WebElement orderFeeAwardBid_txt(WebDriver driver){
		element = driver.findElement(By.id("spnOrderFee"));
		return element;
	}

	/**
	 * Order fee award bid txt.
	 *
	 * @return the string
	 */
	public static String orderFeeAwardBid_txt(){
		id = "spnOrderFee";
		return id;
	}

	/**
	 * Order fee award bid grid txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Order fee grid text
	public static WebElement orderFeeAwardBidGrid_txt(WebDriver driver){
		element = driver.findElement(By.id("tblGridAward"));
		return element;
	}

	/**
	 * Order fee award bid grid txt.
	 *
	 * @return the string
	 */
	public static String orderFeeAwardBidGrid_txt(){
		id = "tblGridAward";
		return id;
	}

	/**
	 * Tool tip txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Tool tip text
	public static WebElement toolTip_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='Images/Push-Icon-blue.png']"));
		return element;
	}

	/**
	 * Tool tip txt.
	 *
	 * @return the string
	 */
	public static String toolTip_txt(){
		cssSelector = "img[src='Images/Push-Icon-blue.png']";
		return cssSelector;
	}

	/**
	 * Placed dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Placed dropdown
	public static WebElement placed_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_ddlPlaced"));
		return element;
	}

	/**
	 * Placed dropdown.
	 *
	 * @return the string
	 */
	public static String placed_dropdown(){
		id = "Main_Main_ddlPlaced";
		return id;
	}

	/**
	 * Comments txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Comments ratings
	public static WebElement comments_txtbx(WebDriver driver){
		element = driver.findElement(By.id("txtRatingsComments"));
		return element;
	}

	/**
	 * Comments txtbx.
	 *
	 * @return the string
	 */
	public static String comments_txtbx(){
		id = "txtRatingsComments";
		return id;
	}

	/**
	 * Send message txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Send Message text
	public static WebElement sendMessage_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector("#divSendMessage > div:nth-child(2)"));
		return element;
	}

	/**
	 * Send message txt.
	 *
	 * @return the string
	 */
	public static String sendMessage_txt(){
		cssSelector = "#divSendMessage > div:nth-child(2)";
		return cssSelector;
	}

	/**
	 * Cancel send message btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Cancel button
	public static WebElement cancelSendMessage_btn(WebDriver driver){
			element = driver.findElement(By.id("Dialogs_Dialogs_sbSendMessageCancel"));
		return element;
	}

	/**
	 * Cancel send message btn.
	 *
	 * @return the string
	 */
	public static String cancelSendMessage_btn(){
			id = "Dialogs_Dialogs_sbSendMessageCancel";
		return id;
	}

	/**
	 * Adds the note btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Add note button
	public static WebElement addNote_btn(WebDriver driver){
		element = driver.findElement(By.xpath("//td[contains(text(), 'Add note')]"));
		return element;
	}

	/**
	 * Adds the note btn.
	 *
	 * @return the string
	 */
	public static String addNote_btn(){
		xpath = "//td[contains(text(), 'Add note')]";
		return xpath;
	}

	/**
	 * Duplicate btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Duplicate button
	public static WebElement duplicate_btn(WebDriver driver){
		element = driver.findElement(By.xpath("//td[contains(text(), 'Duplicate')]"));
		return element;
	}

	/**
	 * Duplicate btn.
	 *
	 * @return the string
	 */
	public static String duplicate_btn(){
		xpath = "\\\"//td[contains(text(), 'Duplicate')]\\\"";
		return xpath;
	}

	/**
	 * Ok add note btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// OK Add Note button
	public static WebElement okAddNote_btn(WebDriver driver){
			element = driver.findElement(By.id("Dialogs_Dialogs_sbddNoteWarningOK"));
		return element;
	}

	/**
	 * Ok add note btn.
	 *
	 * @return the string
	 */
	public static String okAddNote_btn(){
			id = "Dialogs_DiaDialogs_Dialogs_sbddNoteWarningOKlogs_ctl30";		
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
		element = driver.findElement(By.id("Dialogs_Dialogs_txtAddNote"));
		return element;
	}

	/**
	 * Note txtbx.
	 *
	 * @return the string
	 */
	public static String note_txtbx(){
		id = "Dialogs_Dialogs_txtAddNote";
		return id;
	}

	/**
	 * Adds the note txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Add note text
	public static WebElement addNote_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector("#divAddNote > div:nth-child(2)"));
		return element;
	}

	/**
	 * Adds the note txt.
	 *
	 * @return the string
	 */
	public static String addNote_txt(){
		cssSelector = "#divAddNote > div:nth-child(2)";
		return cssSelector;
	}

	/**
	 * Cancel add note btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Add note Cancel button
	public static WebElement cancelAddNote_btn(WebDriver driver){
			element = driver.findElement(By.id("Dialogs_Dialogs_sbAddNoteCancel"));
		return element;
	}

	/**
	 * Cancel add note btn.
	 *
	 * @return the string
	 */
	public static String cancelAddNote_btn(){
			id = "Dialogs_Dialogs_sbAddNoteCancel";
		return id;
	}

	/**
	 * Mark as paid btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Mark as paid button
	public static WebElement markAsPaid_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/App_Themes/FlatGrayscale/Icons/DollarSign.O.png']"));
		return element;
	}

	/**
	 * Mark as paid btn.
	 *
	 * @return the string
	 */
	public static String markAsPaid_btn(){
		cssSelector = "img[src='/App_Themes/FlatGrayscale/Icons/DollarSign.O.png']";
		return cssSelector;
	}

	/**
	 * Invoice number txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Invoice # textbox
	public static WebElement invoiceNumber_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_txtInvoiceNumber"));
		return element;
	}

	/**
	 * Invoice number txtbx.
	 *
	 * @return the string
	 */
	public static String invoiceNumber_txtbx(){
		id = "Dialogs_Dialogs_txtInvoiceNumber";
		return id;
	}

	/**
	 * Check number txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Check # textbox
	public static WebElement checkNumber_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_txtCheckNumber"));
		return element;
	}

	/**
	 * Check number txtbx.
	 *
	 * @return the string
	 */
	public static String checkNumber_txtbx(){
		id = "Dialogs_Dialogs_txtCheckNumber";
		return id;
	}

	/**
	 * Note enter new payment txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Note Enter new payment textbox
	public static WebElement noteEnterNewPayment_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_txtPaymentNote"));
		return element;
	}

	/**
	 * Note enter new payment txtbx.
	 *
	 * @return the string
	 */
	public static String noteEnterNewPayment_txtbx(){
		id = "Dialogs_Dialogs_txtPaymentNote";
		return id;
	}

	/**
	 * Cancel enter new payment btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Cancel Enter new payment button
	public static WebElement cancelEnterNewPayment_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_btnMarkAsPaidCancel"));
		return element;
	}

	/**
	 * Cancel enter new payment btn.
	 *
	 * @return the string
	 */
	public static String cancelEnterNewPayment_btn(){
		id = "Dialogs_Dialogs_btnMarkAsPaidCancel";
		return id;
	}

	/**
	 * Note set order status txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Set order status note textbox
	public static WebElement noteSetOrderStatus_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ctlStatusMessageInspection_txtMessage"));
		return element;
	}

	/**
	 * Note set order status txtbx.
	 *
	 * @return the string
	 */
	public static String noteSetOrderStatus_txtbx(){
		id = "Dialogs_Dialogs_ctlStatusMessageInspection_txtMessage";
		return id;
	}

	/**
	 * Inspection scheduled for txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Inspection scheduled textbox
	public static WebElement inspectionScheduledFor_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_txtInspectionDate"));
		return element;
	}

	/**
	 * Inspection scheduled for txtbx.
	 *
	 * @return the string
	 */
	public static String inspectionScheduledFor_txtbx(){
		id = "Dialogs_Dialogs_txtInspectionDate";
		return id;
	}

	/**
	 * Cancel set order status btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Cancel Set order status button
	public static WebElement cancelSetOrderStatus_btn(WebDriver driver){
			element = driver.findElement(By.id("Dialogs_Dialogs_sbInspectionCancel"));
		return element;
	}

	/**
	 * Cancel set order status btn.
	 *
	 * @return the string
	 */
	public static String cancelSetOrderStatus_btn(){
			id = "Dialogs_Dialogs_sbInspectionCancel";
		return id;
	}

	/**
	 * Notes revision required txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Notes Revision required textbox
	public static WebElement notesRevisionRequired_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_txtRevisionRequired"));
		return element;
	}

	/**
	 * Notes revision required txtbx.
	 *
	 * @return the string
	 */
	public static String notesRevisionRequired_txtbx(){
		id = "Dialogs_Dialogs_txtRevisionRequired";
		return id;
	}

	/**
	 * Request revision set order status text txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Request revision Set order status text text
	public static WebElement requestRevisionSetOrderStatusText_txt(WebDriver driver){
		element = driver.findElement(By.id("divSetStatusRevisionRequiredText"));
		return element;
	}

	/**
	 * Request revision set order status text txt.
	 *
	 * @return the string
	 */
	public static String requestRevisionSetOrderStatusText_txt(){
		id = "divSetStatusRevisionRequiredText";
		return id;
	}

	/**
	 * Cancel request revision btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Cancel Request revision button
	public static WebElement cancelRequestRevision_btn(WebDriver driver){
			element = driver.findElement(By.id("Dialogs_Dialogs_sbRevisionRequiredCancel"));
		return element;
	}

	/**
	 * Cancel request revision btn.
	 *
	 * @return the string
	 */
	public static String cancelRequestRevision_btn(){
			id = "Dialogs_Dialogs_sbRevisionRequiredCancel";
		return id;
	}

	/**
	 * Comments change due date txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Comments Change Due Date textbox
	public static WebElement commentsChangeDueDate_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ctlChangeDueDateMessage_txtMessage"));
		return element;
	}

	/**
	 * Comments change due date txtbx.
	 *
	 * @return the string
	 */
	public static String commentsChangeDueDate_txtbx(){
		id = "Dialogs_Dialogs_ctlChangeDueDateMessage_txtMessage";
		return id;
	}

	/**
	 * New due date txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// New due date textbox
	public static WebElement newDueDate_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_txtChangedDueDate"));
		return element;
	}

	/**
	 * New due date txtbx.
	 *
	 * @return the string
	 */
	public static String newDueDate_txtbx(){
		id = "Dialogs_Dialogs_txtChangedDueDate";
		return id;
	}

	/**
	 * Cancel change due date btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Cancel Change due date button
	public static WebElement cancelChangeDueDate_btn(WebDriver driver){
			element = driver.findElement(By.id("Dialogs_Dialogs_sbChangeDueDateCancel"));
		return element;
	}

	/**
	 * Cancel change due date btn.
	 *
	 * @return the string
	 */
	public static String cancelChangeDueDate_btn(){
			id = "Dialogs_Dialogs_sbChangeDueDateCancel";
		return id;
	}

	/**
	 * Comments change fee txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Comments Change Fee textbox
	public static WebElement commentsChangeFee_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ctlChangeFee_txtMessage"));
		return element;
	}

	/**
	 * Comments change fee txtbx.
	 *
	 * @return the string
	 */
	public static String commentsChangeFee_txtbx(){
		id = "Dialogs_Dialogs_ctlChangeFee_txtMessage";
		return id;
	}

	/**
	 * New fee txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// New fee textbox
	public static WebElement newFee_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_txtChangeFee"));
		return element;
	}

	/**
	 * New fee txtbx.
	 *
	 * @return the string
	 */
	public static String newFee_txtbx(){
		id = "Dialogs_Dialogs_txtChangeFee";
		return id;
	}

	/**
	 * Cancel change fee btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Cancel Change fee button
	public static WebElement cancelChangeFee_btn(WebDriver driver){
			element = driver.findElement(By.id("Dialogs_Dialogs_sbChangeFeeCancel"));
		
		return element;
	}

	/**
	 * Cancel change fee btn.
	 *
	 * @return the string
	 */
	public static String cancelChangeFee_btn(){
			id = "Dialogs_Dialogs_sbChangeFeeCancel";
		return id;
	}

	/**
	 * No btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// No button
	public static WebElement no_btn(WebDriver driver){
		element = driver.findElement(By.id("sbdmButton2"));
		return element;
	}

	/**
	 * No btn.
	 *
	 * @return the string
	 */
	public static String no_btn(){
		id = "sbdmButton2";
		return id;
	}

	/**
	 * Note remove UCPD status txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Note Remove UCDP Status textbox
	public static WebElement noteRemoveUCPDStatus_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ctlStatusMessage_txtMessage"));
		return element;
	}

	/**
	 * Note remove UCPD status txtbx.
	 *
	 * @return the string
	 */
	public static String noteRemoveUCPDStatus_txtbx(){
		id = "Dialogs_Dialogs_ctlStatusMessage_txtMessage";
		return id;
	}

	/**
	 * Removes the UCDP status set order status text txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Remove UCDP Status Set order status text
	public static WebElement removeUCDPStatusSetOrderStatusText_txt(WebDriver driver){
		element = driver.findElement(By.id("divSetStatusText"));
		return element;
	}

	/**
	 * Removes the UCDP status set order status text txt.
	 *
	 * @return the string
	 */
	public static String removeUCDPStatusSetOrderStatusText_txt(){
		id = "divSetStatusText";
		return id;
	}

	/**
	 * Cancel remove UCDP status btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Cancel Remove UCDP Status button
	public static WebElement cancelRemoveUCDPStatus_btn(WebDriver driver){
			element = driver.findElement(By.id("Dialogs_Dialogs_sbSetStatusCancel"));
		return element;
	}

	/**
	 * Cancel remove UCDP status btn.
	 *
	 * @return the string
	 */
	public static String cancelRemoveUCDPStatus_btn(){
			id = "Dialogs_Dialogs_sbSetStatusCancel";
		return id;
	}

	/**
	 * Comments to vendor proposed conditions txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Comments to vendor Vendor proposed conditions textbox
	public static WebElement commentsToVendorProposedConditions_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_txtConditionalDeclineComments"));
		return element;
	}

	/**
	 * Comments to vendor proposed conditions txtbx.
	 *
	 * @return the string
	 */
	public static String commentsToVendorProposedConditions_txtbx(){
		id = "Main_Main_txtConditionalDeclineComments";
		return id;
	}

	/**
	 * I agree vendor proposed conditions btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// I agree Vendor proposed conditions button
	public static WebElement iAgreeVendorProposedConditions_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_optLenderAccept"));
		return element;
	}

	/**
	 * I agree vendor proposed conditions btn.
	 *
	 * @return the string
	 */
	public static String iAgreeVendorProposedConditions_btn(){
		id = "Main_Main_optLenderAccept";
		return id;
	}

	/**
	 * Calendar change due date btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Calendar change due date button
	public static WebElement calendarChangeDueDate_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/Images/calendar.gif'][onclick='imgChangedDueDateCalendar_click(event);']"));
		return element;
	}

	/**
	 * Calendar change due date btn.
	 *
	 * @return the string
	 */
	public static String calendarChangeDueDate_btn(){
		cssSelector = "img[src='/Images/calendar.gif'][onclick='imgChangedDueDateCalendar_click(event);']";
		return cssSelector;
	}

	/**
	 * Note complete assignment txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Note Complete assignment textbox
	public static WebElement noteCompleteAssignment_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ctlStatusMessageCompleteUpload_txtMessage"));
		return element;
	}

	/**
	 * Note complete assignment txtbx.
	 *
	 * @return the string
	 */
	public static String noteCompleteAssignment_txtbx(){
		id = "Dialogs_Dialogs_ctlStatusMessageCompleteUpload_txtMessage";
		return id;
	}

	/**
	 * Complete assignment txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Complete assignment text
	public static WebElement completeAssignment_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector("#divSetCompleteFields > div.dsCaption"));
		return element;
	}

	/**
	 * Complete assignment txt.
	 *
	 * @return the string
	 */
	public static String completeAssignment_txt(){
		cssSelector = "#divSetCompleteFields > div.dsCaption";
		return cssSelector;
	}

	/**
	 * Upload report btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Upload Report button
	public static WebElement uploadReport_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_btnUploadFile"));
		return element;
	}

	/**
	 * Upload report btn.
	 *
	 * @return the string
	 */
	public static String uploadReport_btn(){
		id = "Dialogs_Dialogs_btnUploadFile";
		return id;
	}

	/**
	 * Ok complete assignment btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// OK Complete assignment button
	public static WebElement okCompleteAssignment_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_btnSetCompleteOK"));
		return element;
	}

	/**
	 * Ok complete assignment btn.
	 *
	 * @return the string
	 */
	public static String okCompleteAssignment_btn(){
		id = "Dialogs_Dialogs_btnSetCompleteOK";
		return id;
	}

	/**
	 * Document upload progress txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Document upload progress text
	public static WebElement documentUploadProgress_txt(WebDriver driver){
		element = driver.findElement(By.id("pbFile_EmptyText"));
		return element;
	}

	/**
	 * Document upload progress txt.
	 *
	 * @return the string
	 */
	public static String documentUploadProgress_txt(){
		id = "pbFile_EmptyText";
		return id;
	}

	/**
	 * Creates the A note in your blitz docs txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Create a note in your BlitzDocs textbox
	public static WebElement createANoteInYourBlitzDocs_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ctlStatusMessageSendToBlitzDocs_txtMessage"));
		return element;
	}

	/**
	 * Creates the A note in your blitz docs txtbx.
	 *
	 * @return the string
	 */
	public static String createANoteInYourBlitzDocs_txtbx(){
		id = "Dialogs_Dialogs_ctlStatusMessageSendToBlitzDocs_txtMessage";
		return id;
	}

	/**
	 * Cancel send to blitz docs btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Cancel Send to BlitzDocs button
	public static WebElement cancelSendToBlitzDocs_btn(WebDriver driver){
			element = driver.findElement(By.id("Dialogs_Dialogs_sbSendToBlitzDocsCancel"));
		return element;
	}

	/**
	 * Cancel send to blitz docs btn.
	 *
	 * @return the string
	 */
	public static String cancelSendToBlitzDocs_btn(){
			id = "Dialogs_Dialogs_sbSendToBlitzDocsCancel";
		return id;
	}

	/**
	 * Send to blitz docs txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Send to BlitzDocs text
	public static WebElement sendToBlitzDocs_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector("#Dialogs_Dialogs_upSetStatusSendToBlitzDocs > div:nth-child(1)"));
		return element;
	}

	/**
	 * Send to blitz docs txt.
	 *
	 * @return the string
	 */
	public static String sendToBlitzDocs_txt(){
		cssSelector = "#Dialogs_Dialogs_upSetStatusSendToBlitzDocs > div:nth-child(1)";
		return cssSelector;
	}

	/**
	 * Note set order status delayed txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Note Set Order Status Delay textbox
	public static WebElement noteSetOrderStatusDelayed_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ctlStatusMessageNewDate_txtMessage"));
		return element;
	}

	/**
	 * Note set order status delayed txtbx.
	 *
	 * @return the string
	 */
	public static String noteSetOrderStatusDelayed_txtbx(){
		id = "Dialogs_Dialogs_ctlStatusMessageNewDate_txtMessage";
		return id;
	}

	/**
	 * Cancel set order status delayed btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Cancel Set Order Status Delay button
	public static WebElement cancelSetOrderStatusDelayed_btn(WebDriver driver){
			element = driver.findElement(By.id("Dialogs_Dialogs_sbNewDateCancel"));
		return element;
	}

	/**
	 * Cancel set order status delayed btn.
	 *
	 * @return the string
	 */
	public static String cancelSetOrderStatusDelayed_btn(){
			id = "Dialogs_Dialogs_sbNewDateCancel";	
		return id;
	}

	/**
	 * Eligible fee panel vendors table.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Eligible Fee Panel Vendors table
	public static WebElement eligibleFeePanelVendors_table(WebDriver driver){
		element = driver.findElement(By.id("grdEligibleVendors"));
		return element;
	}

	/**
	 * Eligible fee panel vendors table.
	 *
	 * @return the string
	 */
	public static String eligibleFeePanelVendors_table(){
		id = "grdEligibleVendors";
		return id;
	}

	/**
	 * Checkmark btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Checkmark button
	public static WebElement checkmark_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/images/Checkmark-Small-Unchecked.O.png']"));
		return element;
	}

	/**
	 * Checkmark btn.
	 *
	 * @return the string
	 */
	public static String checkmark_btn(){
		cssSelector = "img[src='/images/Checkmark-Small-Unchecked.O.png']";
		return cssSelector;
	}

	/**
	 * Email eligible vendors txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Email eligible vendors text
	public static WebElement emailEligibleVendors_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector("#divEmailVendors > div:nth-child(2)"));
		return element;
	}

	/**
	 * Email eligible vendors txt.
	 *
	 * @return the string
	 */
	public static String emailEligibleVendors_txt(){
		cssSelector = "#divEmailVendors > div:nth-child(2)";
		return cssSelector;
	}

	/**
	 * Cancel email eligible vendors btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Cancel email eligible vendors button
	public static WebElement cancelEmailEligibleVendors_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ctl57"));
		return element;
	}

	/**
	 * Cancel email eligible vendors btn.
	 *
	 * @return the string
	 */
	public static String cancelEmailEligibleVendors_btn(){
		id = "Dialogs_Dialogs_ctl57";
		return id;
	}

	/**
	 * Delete btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Delete button
	public static WebElement delete_btn(WebDriver driver){
		element = driver.findElement(By.id("imgODDeleteNew"));
		return element;
	}

	/**
	 * Delete btn.
	 *
	 * @return the string
	 */
	public static String delete_btn(){
		id = "imgODDeleteNew";
		return id;
	}

	/**
	 * Ok delete completed report btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// OK Delete Completed Report button
	public static WebElement okDeleteCompletedReport_btn(WebDriver driver){
			element = driver.findElement(By.id("Dialogs_Dialogs_sbConfirmDeleteReportWarningOK"));
		return element;
	}

	/**
	 * Ok delete completed report btn.
	 *
	 * @return the string
	 */
	public static String okDeleteCompletedReport_btn(){
			id = "Dialogs_Dialogs_sbConfirmDeleteReportWarningOK";
		return id;
	}

	/**
	 * Notes delete completed report txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Notes Delete Completed Report textbox
	public static WebElement notesDeleteCompletedReport_txtbx(WebDriver driver){
		element = driver.findElement(By.id("txtDeleteReportNotes"));
		return element;
	}

	/**
	 * Notes delete completed report txtbx.
	 *
	 * @return the string
	 */
	public static String notesDeleteCompletedReport_txtbx(){
		id = "txtDeleteReportNotes";
		return id;
	}

	/**
	 * Delete completed report dialog txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Delete Completed Report dialog text
	public static WebElement deleteCompletedReportDialog_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector("#divConfirmDeleteReport > div:nth-child(2)"));
		return element;
	}

	/**
	 * Delete completed report dialog txt.
	 *
	 * @return the string
	 */
	public static String deleteCompletedReportDialog_txt(){
		cssSelector = "#divConfirmDeleteReport > div:nth-child(2)";
		return cssSelector;
	}

	/**
	 * Cancel delete completed report btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Cancel Delete Completed Report button
	public static WebElement cancelDeleteCompletedReport_btn(WebDriver driver){
			element = driver.findElement(By.id("Dialogs_Dialogs_sbConfirmDeleteReportCancel"));
		return element;
	}

	/**
	 * Cancel delete completed report btn.
	 *
	 * @return the string
	 */
	public static String cancelDeleteCompletedReport_btn(){
			id = "Dialogs_Dialogs_sbConfirmDeleteReportCancel";
		return id;
	}

	/**
	 * Note place on hold txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Note Place on Hold textbox
	public static WebElement notePlaceOnHold_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ctlStatusMessage_txtMessage"));
		return element;
	}

	/**
	 * Note place on hold txtbx.
	 *
	 * @return the string
	 */
	public static String notePlaceOnHold_txtbx(){
		id = "Dialogs_Dialogs_ctlStatusMessage_txtMessage";
		return id;
	}

	/**
	 * Ok place on hold btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Ok Place on Hold button
	public static WebElement okPlaceOnHold_btn(WebDriver driver){
			element = driver.findElement(By.id("Dialogs_Dialogs_sbSetStatusOK"));
		return element;
	}

	/**
	 * Ok place on hold btn.
	 *
	 * @return the string
	 */
	public static String okPlaceOnHold_btn(){
			id = "Dialogs_Dialogs_sbSetStatusOK";
		return id;
	}

	/**
	 * Sync to VMP dialog txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Sync to VMP dialog text
	public static WebElement syncToVMPDialog_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector("#divSyncToVMP > div.DialogSection"));
		return element;
	}

	/**
	 * Sync to VMP dialog txt.
	 *
	 * @return the string
	 */
	public static String syncToVMPDialog_txt(){
		cssSelector = "#divSyncToVMP > div.DialogSection";
		return cssSelector;
	}

	/**
	 * Update VMPX site chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Update VMP XSite checkbox
	public static WebElement updateVMPXSite_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_chkUpdateVMPExpireDate"));
		return element;
	}

	/**
	 * Update VMPX site chkbx.
	 *
	 * @return the string
	 */
	public static String updateVMPXSite_chkbx(){
		id = "Dialogs_Dialogs_chkUpdateVMPExpireDate";
		return id;
	}

	/**
	 * Ok due date btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// OK Due Date button
	public static WebElement okDueDate_btn(WebDriver driver){
			element = driver.findElement(By.id("Dialogs_Dialogs_sbExpiredDueDateOK"));
		return element;
	}

	/**
	 * Ok due date btn.
	 *
	 * @return the string
	 */
	public static String okDueDate_btn(){
			id = "Dialogs_Dialogs_sbExpiredDueDateOK";
		return id;
	}

	/**
	 * Issue as bid btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Issue as bid button
	public static WebElement issueAsBid_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector(".blue-check-small"));
		return element;
	}

	/**
	 * Issue as bid btn.
	 *
	 * @return the string
	 */
	public static String issueAsBid_btn(){
		cssSelector = ".blue-check-small";
		return cssSelector;
	}

	/**
	 * Review bids vendors table txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Review bids vendors table
	public static WebElement reviewBidsVendorsTable_txt(WebDriver driver){
		element = driver.findElement(By.id("tblReview_scroll"));
		return element;
	}

	/**
	 * Review bids vendors table txt.
	 *
	 * @return the string
	 */
	public static String reviewBidsVendorsTable_txt(){
		id = "tblReview_scroll";
		return id;
	}

	/**
	 * Place A new order to the same vendor radiobtn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Place a new order and assign it to the same vendor radio button
	public static WebElement placeANewOrderToTheSameVendor_radiobtn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_rbDuplicateOrder_FollowUp"));
		return element;
	}

	/**
	 * Place A new order to the same vendor radiobtn.
	 *
	 * @return the string
	 */
	public static String placeANewOrderToTheSameVendor_radiobtn(){
		id = "Dialogs_Dialogs_rbDuplicateOrder_FollowUp";
		return id;
	}

	/**
	 * Place A new order to A different vendor radiobtn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Place a new order and assign it to a different vendor radio button
	public static WebElement placeANewOrderToADifferentVendor_radiobtn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_rbDuplicateOrder_Cancelled"));
		return element;
	}

	/**
	 * Place A new order to A different vendor radiobtn.
	 *
	 * @return the string
	 */
	public static String placeANewOrderToADifferentVendor_radiobtn(){
		id = "Dialogs_Dialogs_rbDuplicateOrder_Cancelled";
		return id;
	}

	/**
	 * Enter new order btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Enter New Order button
	public static WebElement enterNewOrder_btn(WebDriver driver){
			element = driver.findElement(By.id("Dialogs_Dialogs_sbDuplicateOrderNew"));
		return element;
	}

	/**
	 * Enter new order btn.
	 *
	 * @return the string
	 */
	public static String enterNewOrder_btn(){
			id = "Dialogs_Dialogs_sbDuplicateOrderNew";
		return id;
	}

	/**
	 * Assign div.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Assign div
	public static WebElement assign_div(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_divReassign"));
		return element;
	}

	/**
	 * Assign div.
	 *
	 * @return the string
	 */
	public static String assign_div(){
		id = "Main_Main_divReassign";
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
		element = driver.findElement(By.cssSelector("#Main_Main_divBidLocks > div:nth-child(1) > div > div"));
		return element;
	}

	/**
	 * Fee lock btn.
	 *
	 * @return the string
	 */
	public static String feeLock_btn(){
		cssSelector = "#Main_Main_divBidLocks > div:nth-child(1) > div > div";
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
		element = driver.findElement(By.cssSelector("#Main_Main_divBidLocks > div:nth-child(2) > div > div"));
		return element;
	}

	/**
	 * Date lock btn.
	 *
	 * @return the string
	 */
	public static String dateLock_btn(){
		cssSelector = "#Main_Main_divBidLocks > div:nth-child(2) > div > div";
		return cssSelector;
	}

	/**
	 * Fee lock img.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Fee lock image
	public static WebElement feeLock_img(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_imgFeeLock"));
		return element;
	}

	/**
	 * Fee lock img.
	 *
	 * @return the string
	 */
	public static String feeLock_img(){
		id = "Main_Main_imgFeeLock";
		return id;
	}

	/**
	 * Date lock img.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Date lock image
	public static WebElement dateLock_img(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_imgDateLock"));
		return element;
	}

	/**
	 * Date lock img.
	 *
	 * @return the string
	 */
	public static String dateLock_img(){
		id = "Main_Main_imgDateLock";
		return id;
	}

	/**
	 * Edits the disclosure lnk.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Edit Disclosure date link
	public static WebElement editDisclosure_lnk(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_lnkDisclosureDate"));
		return element;
	}

	/**
	 * Edits the disclosure lnk.
	 *
	 * @return the string
	 */
	public static String editDisclosure_lnk(){
		id = "Main_Main_lnkDisclosureDate";
		return id;
	}

	/**
	 * Bidding information txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Bidding information text
	public static WebElement biddingInformation_txt(WebDriver driver){
		element = driver.findElement(By.id("divVendorsSection"));
		return element;
	}

	/**
	 * Bidding information txt.
	 *
	 * @return the string
	 */
	public static String biddingInformation_txt(){
		id = "divVendorsSection";
		return id;
	}

	/**
	 * Zillow lnk.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// zillow_lnk
	public static WebElement zillow_lnk(WebDriver driver){
		element = driver.findElement(By.id("lnkZillow"));
		return element;
	}

	/**
	 * Zillow lnk.
	 *
	 * @return the string
	 */
	public static String zillow_lnk(){
		id = "lnkZillow";
		return id;
	}

	/**
	 * Zoom out btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// map zoomOut_btn
	public static WebElement zoomOut_btn(WebDriver driver){
		element = driver.findElement(By.id("ZoomOutButton"));
		return element;
	}

	/**
	 * Zoom out btn.
	 *
	 * @return the string
	 */
	public static String zoomOut_btn(){
		id = "ZoomOutButton";
		return id;
	}

	/**
	 * Status details txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// statusDetails_txt
	public static WebElement statusDetails_txt(WebDriver driver){
		element = driver.findElement(By.id("divStatusDetails"));
		return element;
	}

	/**
	 * Status details txt.
	 *
	 * @return the string
	 */
	public static String statusDetails_txt(){
		id = "divStatusDetails";
		return id;
	}

	/**
	 * Close status details btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// closeStatusDetails_btn
	public static WebElement closeStatusDetails_btn(WebDriver driver){
			element = driver.findElement(By.id("Dialogs_Dialogs_sbStatusDetailsClose"));
		return element;
	}

	/**
	 * Close status details btn.
	 *
	 * @return the string
	 */
	public static String closeStatusDetails_btn(){
			id = "Dialogs_Dialogs_sbStatusDetailsClose";
		return id;
	}

	/**
	 * Status details row one txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// statusDetailsRowOne_txt
	public static WebElement statusDetailsRowOne_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector("#tblOrderChangeData > tbody > tr:nth-child(1)"));
		return element;
	}

	/**
	 * Status details row one txt.
	 *
	 * @return the string
	 */
	public static String statusDetailsRowOne_txt(){
		cssSelector = "#tblOrderChangeData > tbody > tr:nth-child(1)";
		return cssSelector;
	}

	/**
	 * Status details row two txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// statusDetailsRowTwo_txt
	public static WebElement statusDetailsRowTwo_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector("#tblOrderChangeData > tbody > tr:nth-child(2)"));
		return element;
	}

	/**
	 * Status details row two txt.
	 *
	 * @return the string
	 */
	public static String statusDetailsRowTwo_txt(){
		cssSelector = "#tblOrderChangeData > tbody > tr:nth-child(2)";
		return cssSelector;
	}

	/**
	 * Order documents txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// orderDocuments_txt
	public static WebElement orderDocuments_txt(WebDriver driver){
		element = driver.findElement(By.id("divOrderDocuments"));
		return element;
	}

	/**
	 * Order documents txt.
	 *
	 * @return the string
	 */
	public static String orderDocuments_txt(){
		id = "divOrderDocuments";
		return id;
	}

	/**
	 * Order documents main txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// orderDocumentsMain_txt
	public static WebElement orderDocumentsMain_txt(WebDriver driver){
		element = driver.findElement(By.id("divODMain"));
		return element;
	}

	/**
	 * Order documents main txt.
	 *
	 * @return the string
	 */
	public static String orderDocumentsMain_txt(){
		id = "divODMain";
		return id;
	}

	// Enter New Payment save button
	/**
	 * @param driver
	 * @return the web element
	 */
	public static WebElement paymentSave_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_btnMarkAsPaidSave"));
		return element;
	}

	/**
	 * Order documents txt.
	 *
	 * @return the string
	 */
	public static String paymentSave_btn(){
		id = "divOrdeDialogs_Dialogs_btnMarkAsPaidSaverDocuments";
		return id;
	}
	
	/**
	 * Loan number txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement loanNumber_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector("#divAssignmentContent > div:nth-child(1) > div:nth-child(2) > div.MercuryDataItem.BreakAll"));
		return element;
	}

	/**
	 * Loan number txt.
	 *
	 * @return the string
	 */
	public static String loanNumber_txt(){
		cssSelector = "#divAssignmentContent > div:nth-child(1) > div:nth-child(2) > div.MercuryDataItem.BreakAll";
		return cssSelector;
	}
	/**
	 *  Vendor profile txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement vendorProfile_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector("#form1 > div:nth-child(16) > div.PodTitle"));
		return element;
	}

	/**
	 * Vendor profile txt.
	 *
	 * @return the string
	 */
	public static String vendorProfile_txt(){
		cssSelector = "#form1 > div:nth-child(16) > div.PodTitle";
		return cssSelector;

	}
	/**
	 * Message txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Send Message text box
	public static WebElement message_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ctlSendMessages_txtMessage"));
		return element;
	}

	/**
	 * Message txtbx.
	 *
	 * @return the string
	 */
	public static String message_txtbx(){
		id = "Dialogs_Dialogs_ctlSendMessages_txtMessage";
		return id;
	}


	/**
	 * Messageql btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Send Message QL button
	public static WebElement messageql_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ctlSendMessages_txtMessage"));
		return element;
	}

	/**
	 * Send Message QL button.
	 *
	 * @return the string
	 */
	public static String messageql_btn(){
		id = "Dialogs_Dialogs_ctlSendMessages_txtMessage";
		return id;
	}
	
	/**
	 * New messageql btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Send Message QL button
		public static WebElement newMessageql_btn(WebDriver driver){
			element = driver.findElement(By.id("Main_ctl01"));
			return element;
		}

		/**
		 * Send Message QL button.
		 *
		 * @return the string
		 */
		public static String newMmessageql_btn(){
			id = "Main_ctl01";
			return id;
		}

		/**
		 * Not authorized dialog.
		 *
		 * @param driver the driver
		 * @return the web element
		 */
		//  Not Authorized Dialog
		public static WebElement notAuthorized_dialog(WebDriver driver){
			element = driver.findElement(By.id("AlertDialog"));
			return element;
		}

		/**
		 * Not Authorized Dialog.
		 *
		 * @return the string
		 */
		public static String notAuthorized_dialog(){
			id = "AlertDialog";
			return id;
		}
		
		/**
		 * Sets the status drpdwn.
		 *
		 * @param driver the driver
		 * @return the web element
		 */
		// Set Status Dropdown
		public static WebElement setStatus_drpdwn(WebDriver driver){
			element = driver.findElement(By.id("Main_Main_mbMain_3"));
			return element;
		}

		/**
		 * Set Status Dropdown.
		 *
		 * @return the string
		 */
		public static String setStatus_drpdwn(){
			id = "Main_Main_mbMain_3";
			return id;
		}
		
		/**
		 * Assignment ratings chkbx.
		 *
		 * @param driver the driver
		 * @return the web element
		 */
		// Set Status Dropdown
		public static WebElement assignmentRatings_chkbx(WebDriver driver){
			element = driver.findElement(By.id("Main_Main_divRatings"));
			return element;
		}

		/**
		 * Set Status Dropdown.
		 *
		 * @return the string
		 */
		public static String assignmentRatings_chkbx(){
			id = "Main_Main_divRatings";
			return id;
		}
		
		/**
		 * Back arrow button
		 *
		 * @param driver the driver
		 * @return the web element
		 */
		public static WebElement backArrow_btn(WebDriver driver){
			element = driver.findElement(By.cssSelector("#Main_Main_upMenuBar > div > table > tbody > tr > td:nth-child(1) > table > tbody > tr > td.MenuBar_Item_Icon"));
			return element;
		}
		
}