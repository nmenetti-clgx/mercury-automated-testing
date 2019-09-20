package pageObjects.Vendors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Vendors Order Details page
 */
public class VOrderDetails {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	/** The css selector. */
	private static String cssSelector = null;
	
	/** The xpath. */
	private static String xpath = null;

	
	/**
	 * Accept decline btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Accept/Decline button
	public static WebElement acceptDecline_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='Images/OrderAcknowledgement.png']"));
		return element;
	}
	
	/**
	 * Accept decline btn.
	 *
	 * @return the string
	 */
	public static String acceptDecline_btn(){
		cssSelector = "img[src='Images/OrderAcknowledgement.png']";
		return cssSelector;
	}
	
	/**
	 * Ok btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Order acknowledgement OK button
	public static WebElement ok_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_sbTransactionFeeOK"));
		return element;
	}
	
	/**
	 * Ok btn.
	 *
	 * @return the string
	 */
	public static String ok_btn(){
		id = "Dialogs_Dialogs_sbTransactionFeeOK";
		return id;
	}
	
	/**
	 * History header txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// History text
	public static WebElement historyHeader_txt(WebDriver driver){
		element = driver.findElement(By.id("divHistoryCaption"));
		return element;
	}
	
	/**
	 * History header txt.
	 *
	 * @return the string
	 */
	public static String historyHeader_txt(){
		id = "divHistoryCaption";
		return id;
	}
	
	/**
	 * History txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Tracking # text
	public static WebElement history_txt(WebDriver driver){
		element = driver.findElement(By.id("divUpManageContent"));
		return element;
	}
	
	/**
	 * History txt.
	 *
	 * @return the string
	 */
	public static String history_txt(){
		id = "divUpManageContent";
		return id;
	}
	
	/**
	 * Tracking number txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Tracking # text
	public static WebElement trackingNumber_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector("#divDetails > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2)"));
		return element;
	}
	
	/**
	 * Tracking number txt.
	 *
	 * @return the string
	 */
	public static String trackingNumber_txt(){
		cssSelector = "#divDetails > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2)";
		return cssSelector;
	}
	
	/**
	 * Order information txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// All Vendor Order Info text
	public static WebElement orderInformation_txt(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_upManage"));
		return element;
	}
	
	/**
	 * Order information txt.
	 *
	 * @return the string
	 */
	public static String orderInformation_txt(){
		id = "Main_Main_upManage";
		return id;
	}
	
	/**
	 * In progress folder.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// In Progress folder
	public static WebElement inProgress_folder(WebDriver driver){
		element = driver.findElement(By.cssSelector("#tblFolders > tbody:nth-child(1) > tr:nth-child(5) > td:nth-child(1)"));
		return element;
	}
	
	/**
	 * In progress folder.
	 *
	 * @return the string
	 */
	public static String inProgress_folder(){
		cssSelector = "#tblFolders > tbody:nth-child(1) > tr:nth-child(5) > td:nth-child(1)";
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
		element = driver.findElement(By.cssSelector("#Main_Main_upMain > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(3) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2)"));
		return element;
	}
	
	/**
	 * Message btn.
	 *
	 * @return the string
	 */
	public static String message_btn(){
		cssSelector = "#Main_Main_upMain > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(3) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2)";
		return cssSelector;
	}
	
	/**
	 * Edits the order btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Edit Order button
	public static WebElement editOrder_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='Images/EditOrder16x16.png']"));
		return element;
	}
	
	/**
	 * Edits the order btn.
	 *
	 * @return the string
	 */
	public static String editOrder_btn(){
		cssSelector = "img[src='Images/EditOrder16x16.png']";
		return cssSelector;
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
	 * Sets the status txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Set Status text
	public static WebElement setStatus_txt(WebDriver driver){
		element = driver.findElement(By.id("divSetStatus"));
		return element;
	}
	
	/**
	 * Sets the status txt.
	 *
	 * @return the string
	 */
	public static String setStatus_txt(){
		id = "divSetStatus";
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
		element = driver.findElement(By.cssSelector("input.Button[onclick='SendMessage();']"));
		return element;
	}
	
	/**
	 * Send btn.
	 *
	 * @return the string
	 */
	public static String send_btn(){
		cssSelector = "input.Button[onclick='SendMessage();']";
		return cssSelector;
	}
	
	/**
	 * Actual depreciation for the subject is justifiable given the market area chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Actual depreciation for the Subject is justifiable given the market area
	public static WebElement actualDepreciationForTheSubjectIsJustifiableGivenTheMarketArea_chkbx(WebDriver driver){
		element = driver.findElement(By.cssSelector("#Dialogs_Dialogs_ctlSendMessages_cblMessage > li:nth-child(3) > label:nth-child(2)"));
		return element;
	}
	
	/**
	 * Actual depreciation for the subject is justifiable given the market area chkbx.
	 *
	 * @return the string
	 */
	public static String actualDepreciationForTheSubjectIsJustifiableGivenTheMarketArea_chkbx(){
		cssSelector = "#Dialogs_Dialogs_ctlSendMessages_cblMessage > li:nth-child(3) > label:nth-child(2)";
		return cssSelector;
	}
	
	/**
	 * Delayed btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Delayed button
	public static WebElement delayed_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='Images/Delayed.png']"));
		return element;
	}
	
	/**
	 * Delayed btn.
	 *
	 * @return the string
	 */
	public static String delayed_btn(){
		cssSelector = "img[src='Images/Delayed.png']";
		return cssSelector;
	}
	
	/**
	 * Cancel btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Cancel button
	public static WebElement cancel_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='Images/Cancel.png']"));
		return element;
	}
	
	/**
	 * Cancel btn.
	 *
	 * @return the string
	 */
	public static String cancel_btn(){
		cssSelector = "img[src='Images/Cancel.png']";
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
		element = driver.findElement(By.cssSelector("img[src='Images/Resume.png']"));
		return element;
	}
	
	/**
	 * Resume btn.
	 *
	 * @return the string
	 */
	public static String resume_btn(){
		cssSelector = "img[src='Images/Resume.png']";
		return cssSelector;
	}
	
	/**
	 * Inspection scheduled btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Inspection Scheduled button
	public static WebElement inspectionScheduled_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='Images/InspectionScheduled.png']"));
		return element;
	}
	
	/**
	 * Inspection scheduled btn.
	 *
	 * @return the string
	 */
	public static String inspectionScheduled_btn(){
		cssSelector = "img[src='Images/InspectionScheduled.png']";
		return cssSelector;
	}
	
	/**
	 * Inspection scheduled notes txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Inspection Scheduled Notes textbox
	public static WebElement inspectionScheduledNotes_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ctlSetInspectionMessage_txtMessage"));
		return element;
	}
	
	/**
	 * Inspection scheduled notes txtbx.
	 *
	 * @return the string
	 */
	public static String inspectionScheduledNotes_txtbx(){
		id = "Dialogs_Dialogs_ctlSetInspectionMessage_txtMessage";
		return id;
	}
	
	/**
	 * Inspection scheduled calendar btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Inspection Scheduled Calendar button
	public static WebElement inspectionScheduledCalendar_btn(WebDriver driver){
		element = driver.findElement(By.id("imgSetInspectionCalendar"));
		return element;
	}
	
	/**
	 * Inspection scheduled calendar btn.
	 *
	 * @return the string
	 */
	public static String inspectionScheduledCalendar_btn(){
		id = "imgSetInspectionCalendar";
		return id;
	}
	
	/**
	 * Inspection scheduled calendar txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Inspection Scheduled Calendar text box
	public static WebElement inspectionScheduledCalendar_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_txtSetInspectionDate"));
		return element;
	}
	
	/**
	 * Inspection scheduled calendar txtbx.
	 *
	 * @return the string
	 */
	public static String inspectionScheduledCalendar_txtbx(){
		id = "Dialogs_Dialogs_txtSetInspectionDate";
		return id;
	}
	
	/**
	 * Inspection complete btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Inspection Complete button
	public static WebElement inspectionComplete_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='Images/InspectionComplete.png']"));
		return element;
	}
	
	/**
	 * Inspection complete btn.
	 *
	 * @return the string
	 */
	public static String inspectionComplete_btn(){
		cssSelector = "img[src='Images/InspectionComplete.png']";
		return cssSelector;
	}
	
	/**
	 * Complete btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Complete button
	public static WebElement complete_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='Images/Check.png']"));
		return element;
	}
	
	/**
	 * Complete btn.
	 *
	 * @return the string
	 */
	public static String complete_btn(){
		cssSelector = "img[src='Images/Check.png']";
		return cssSelector;
	}
	
	/**
	 * Request modification btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Request Modification button
	public static WebElement requestModification_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='Images/RequestModification.png']"));
		return element;
	}
	
	/**
	 * Request modification btn.
	 *
	 * @return the string
	 */
	public static String requestModification_btn(){
		cssSelector = "img[src='Images/RequestModification.png']";
		return cssSelector;
	}
	
	/**
	 * Changed original appointment due to homeowner conflicts chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Changed original appointment due to homeowner conflicts checkbox
	public static WebElement changedOriginalAppointmentDueToHomeownerConflicts_chkbx(WebDriver driver){
		element = driver.findElement(By.xpath("//label[contains(text(), 'Changed original appointment due to homeowner conflicts')]"));
		return element;
	}
	
	/**
	 * Changed original appointment due to homeowner conflicts chkbx.
	 *
	 * @return the string
	 */
	public static String changedOriginalAppointmentDueToHomeownerConflicts_chkbx(){
		xpath = "//label[contains(text(), 'Changed original appointment due to homeowner conflicts')]";
		return xpath;
	}
	
	/**
	 * Received the ok to proceed from agent chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Received the OK to proceed from agent checkbox
	public static WebElement receivedTheOkToProceedFromAgent_chkbx(WebDriver driver){
		element = driver.findElement(By.xpath("//label[contains(text(), 'Received the OK to proceed from agent')]"));
		return element;
	}
	
	/**
	 * Received the ok to proceed from agent chkbx.
	 *
	 * @return the string
	 */
	public static String receivedTheOkToProceedFromAgent_chkbx(){
		xpath = "//label[contains(text(), 'Received the OK to proceed from agent')]";
		return xpath;
	}
	
	/**
	 * Sets the status ok btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Set Order Status OK button
	public static WebElement setStatusOk_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#divSetStatus > div.MsgBoxContent > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(3) > td:nth-child(1) > input.Button[value='OK']"));
//		element = driver.findElement(By.cssSelector("input.Button[value='OK'][onclick='SetStatus();']"));
		return element;
	}
	
	/**
	 * Sets the status ok btn.
	 *
	 * @return the string
	 */
	public static String setStatusOk_btn(){
		cssSelector = "#divSetStatus > div.MsgBoxContent > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(3) > td:nth-child(1) > input.Button[value='OK']";
//		cssSelector = "input.Button[value='OK'][onclick='SetStatus();']";
		return cssSelector;
	}
	
	/**
	 * Inspection scheduled ok btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Inspection Scheduled OK button
	public static WebElement inspectionScheduledOk_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("input.Button[value='OK'][onclick='SetStatusSetInspection();']"));
		return element;
	}
	
	/**
	 * Inspection scheduled ok btn.
	 *
	 * @return the string
	 */
	public static String inspectionScheduledOk_btn(){
		cssSelector = "input.Button[value='OK'][onclick='SetStatusSetInspection();']";
		return cssSelector;
	}
	
	/**
	 * Sets the status cancel btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Set Order Status Cancel button
	public static WebElement setStatusCancel_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#divSetStatus > div:nth-child(2) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(3) > td:nth-child(1) > input.Button[value='Cancel']"));
		return element;
	}
	
	/**
	 * Sets the status cancel btn.
	 *
	 * @return the string
	 */
	public static String setStatusCancel_btn(){
		cssSelector = "#divSetStatus > div:nth-child(2) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(3) > td:nth-child(1) > input.Button[value='Cancel']";
		return cssSelector;
	}
	
	/**
	 * Sets the order status notes txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Set Order Status Notes text box
	public static WebElement setOrderStatusNotes_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ctlStatusMessage_txtMessage"));
		return element;
	}
	
	/**
	 * Sets the order status notes txtbx.
	 *
	 * @return the string
	 */
	public static String setOrderStatusNotes_txtbx(){
		id = "Dialogs_Dialogs_ctlStatusMessage_txtMessage";
		return id;
	}
	
	/**
	 * Decline this assignment notes txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Decline this Assignment Notes text box
	public static WebElement declineThisAssignmentNotes_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ctlAcknowledgeMessage_Decline_txtMessage"));
		return element;
	}
	
	/**
	 * Decline this assignment notes txtbx.
	 *
	 * @return the string
	 */
	public static String declineThisAssignmentNotes_txtbx(){
		id = "Dialogs_Dialogs_ctlAcknowledgeMessage_Decline_txtMessage";
		return id;
	}
	
	/**
	 * Decline this assignment ok btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Decline this Assignment OK button
	public static WebElement declineThisAssignmentOk_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("input.Button[value='OK'][onclick='ShowTransactionFeeMsg();']"));
		return element;
	}
	
	/**
	 * Decline this assignment ok btn.
	 *
	 * @return the string
	 */
	public static String declineThisAssignmentOk_btn(){
		cssSelector = "input.Button[value='OK'][onclick='ShowTransactionFeeMsg();']";
		return cssSelector;
	}
	
	/**
	 * Send message btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Send Message button
	public static WebElement sendMessage_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='Images/SendMessage16x16.png']"));
		return element;
	}
	
	/**
	 * Send message btn.
	 *
	 * @return the string
	 */
	public static String sendMessage_btn(){
		cssSelector = "img[src='Images/SendMessage16x16.png']";
		return cssSelector;
	}
	
	/**
	 * Send message notes txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Send Message Notes text box
	public static WebElement sendMessageNotes_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ctlSendMessages_txtMessage"));
		return element;
	}
	
	/**
	 * Send message notes txtbx.
	 *
	 * @return the string
	 */
	public static String sendMessageNotes_txtbx(){
		id = "Dialogs_Dialogs_ctlSendMessages_txtMessage";
		return id;
	}
	
	/**
	 * Send message ok btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Send Message Ok button
	public static WebElement sendMessageOk_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#Dialogs_Dialogs_tdSendMessageButtons > input:nth-child(1)"));
		return element;
	}
	
	/**
	 * Send message ok btn.
	 *
	 * @return the string
	 */
	public static String sendMessageOk_btn(){
		cssSelector = "#Dialogs_Dialogs_tdSendMessageButtons > input:nth-child(1)";
		return cssSelector;
	}
	
	/**
	 * Send message cancel btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Send Message Cancel button
	public static WebElement sendMessageCancel_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#Dialogs_Dialogs_tdSendMessageButtons > input:nth-child(2)"));
		return element;
	}
	
	/**
	 * Send message cancel btn.
	 *
	 * @return the string
	 */
	public static String sendMessageCancel_btn(){
		cssSelector = "#Dialogs_Dialogs_tdSendMessageButtons > input:nth-child(2)";
		return cssSelector;
	}
	
	/**
	 * Attach documents btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Attach Documents button
	public static WebElement attachDocuments_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/Images/AttachDocument16x16.png']"));
		return element;
	}
	
	/**
	 * Attach documents btn.
	 *
	 * @return the string
	 */
	public static String attachDocuments_btn(){
		cssSelector = "img[src='/Images/AttachDocument16x16.png']";
		return cssSelector;
	}
	
	/**
	 * Upload documents btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Upload documents button
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
	 * Attach documents txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Attach Documents text
	public static WebElement attachDocuments_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector("#divMarkingComplete > div.MessageBoxText"));
		return element;
	}
	
	/**
	 * Attach documents txt.
	 *
	 * @return the string
	 */
	public static String attachDocuments_txt(){
		cssSelector = "#divMarkingComplete > div.MessageBoxText";
		return cssSelector;
	}
	
	/**
	 * Attach documents ok btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Attach documents OK button
	public static WebElement attachDocumentsOk_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ctl02"));
		return element;
	}
	
	/**
	 * Attach documents ok btn.
	 *
	 * @return the string
	 */
	public static String attachDocumentsOk_btn(){
		id = "Dialogs_Dialogs_ctl02";
		return id;
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
	 * Document type dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Attach Document Document Type dropdown
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
	 * Information in report is correct chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Attach Document Document Type dropdown
	public static WebElement informationInReportIsCorrect_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ctlCompleteMessage_cblMessage_0"));
		return element;
	}
	
	/**
	 * Information in report is correct chkbx.
	 *
	 * @return the string
	 */
	public static String informationInReportIsCorrect_chkbx(){
		id = "Dialogs_Dialogs_ctlCompleteMessage_cblMessage_0";
		return id;
	}
	
	/**
	 * Please send any contracts chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Please send any contracts checkbox
	public static WebElement pleaseSendAnyContracts_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ctlSendMessages_cblMessage_0"));
		return element;
	}
	
	/**
	 * Please send any contracts chkbx.
	 *
	 * @return the string
	 */
	public static String pleaseSendAnyContracts_chkbx(){
		id = "Dialogs_Dialogs_ctlSendMessages_cblMessage_0";
		return id;
	}
	
	/**
	 * Uploaded document progress txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Uploaded Document Progress text
	public static WebElement uploadedDocumentProgress_txt(WebDriver driver){
		element = driver.findElement(By.id("pbAttach0_ProgressText"));
		return element;
	}
	
	/**
	 * Uploaded document progress txt.
	 *
	 * @return the string
	 */
	public static String uploadedDocumentProgress_txt(){
		id = "pbAttach0_ProgressText";
		return id;
	}
	
	/**
	 * Uploaded report progress txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Uploaded Report Progress text
	public static WebElement uploadedReportProgress_txt(WebDriver driver){
		element = driver.findElement(By.id("pbFile_ProgressText"));
		return element;
	}
	
	/**
	 * Uploaded report progress txt.
	 *
	 * @return the string
	 */
	public static String uploadedReportProgress_txt(){
		id = "pbFile_ProgressText";
		return id;
	}
	
	/**
	 * Upload report message to client btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Upload Report Message To Client button
	public static WebElement uploadReportMessageToClient_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ctlCompleteMessage_txtMessage"));
		return element;
	}
	
	/**
	 * Upload report message to client btn.
	 *
	 * @return the string
	 */
	public static String uploadReportMessageToClient_btn(){
		id = "Dialogs_Dialogs_ctlCompleteMessage_txtMessage";
		return id;
	}
	
	/**
	 * Search canned comments txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Search canned comments textbox
	public static WebElement searchCannedComments_txtbx(WebDriver driver){
		element = driver.findElement(By.id("txtCannedCommentSearch"));
		return element;
	}
	
	/**
	 * Search canned comments txtbx.
	 *
	 * @return the string
	 */
	public static String searchCannedComments_txtbx(){
		id = "txtCannedCommentSearch";
		return id;
	}
	
	/**
	 * Complete ok btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Complete OK button
	public static WebElement completeOk_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_btnSetCompleteOK"));
		return element;
	}
	
	/**
	 * Complete ok btn.
	 *
	 * @return the string
	 */
	public static String completeOk_btn(){
		id = "Dialogs_Dialogs_btnSetCompleteOK";
		return id;
	}
	
	/**
	 * Documents txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Order Documents text
	public static WebElement documents_txt(WebDriver driver){
		element = driver.findElement(By.id("divODMain"));
		return element;
	}
	
	/**
	 * Documents txt.
	 *
	 * @return the string
	 */
	public static String documents_txt(){
		id = "divODMain";
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
	 * Upload btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Upload button
	public static WebElement upload_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_lbAttachUpload"));
		return element;
	}
	
	/**
	 * Upload btn.
	 *
	 * @return the string
	 */
	public static String upload_btn(){
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
		element = driver.findElement(By.id("Dialogs_Dialogs_btnCloseToOrder"));
		return element;
	}
	
	/**
	 * Close btn.
	 *
	 * @return the string
	 */
	public static String close_btn(){
		id = "Dialogs_Dialogs_btnCloseToOrder";
		return id;
	}
	
	/**
	 * Additional comments txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Additional comments text
	public static WebElement additionalComments_txt(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_divAdditionalComments"));
		return element;
	}
	
	/**
	 * Additional comments txt.
	 *
	 * @return the string
	 */
	public static String additionalComments_txt(){
		id = "Main_Main_divAdditionalComments";
		return id;
	}
	
	/**
	 * Sets the order status btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Set Order Status button
	public static WebElement setOrderStatus_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='Images/SetOrderStatus16x16.png']"));
		return element;
	}
	
	/**
	 * Sets the order status btn.
	 *
	 * @return the string
	 */
	public static String setOrderStatus_btn(){
		cssSelector = "img[src='Images/SetOrderStatus16x16.png']";
		return cssSelector;
	}
	
	/**
	 * Order fee txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Order Fee text
	public static WebElement orderFee_txt(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_spnFee"));
		return element;
	}
	
	/**
	 * Order fee txt.
	 *
	 * @return the string
	 */
	public static String orderFee_txt(){
		id = "Main_Main_spnFee";
		return id;
	}
	
	/**
	 * Due date txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Due Date text
	public static WebElement dueDate_txt(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_spnDueDate"));
		return element;
	}
	
	/**
	 * Due date txt.
	 *
	 * @return the string
	 */
	public static String dueDate_txt(){
		id = "Main_Main_spnDueDate";
		return id;
	}
	
	/**
	 * Submit bid btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Submit Bid button
	public static WebElement submitBid_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/Images/Toolbar/Submit.O.png']"));
		return element;
	}
	
	/**
	 * Submit bid btn.
	 *
	 * @return the string
	 */
	public static String submitBid_btn(){
		cssSelector = "img[src='/Images/Toolbar/Submit.O.png']";
		return cssSelector;
	}
	
	/**
	 * Update bid btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Update Bid button
	public static WebElement updateBid_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/Images/Toolbar/Review-blue.O.png']"));
		return element;
	}
	
	/**
	 * Update bid btn.
	 *
	 * @return the string
	 */
	public static String updateBid_btn(){
		cssSelector = "img[src='/Images/Toolbar/Review-blue.O.png']";
		return cssSelector;
	}
	
	/**
	 * Wont be charged txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Submit bit Won't be charged text
	public static WebElement wontBeCharged_txt(WebDriver driver){
		element = driver.findElement(By.id("divTransactionMessage"));
		return element;
	}
	
	/**
	 * Wont be charged txt.
	 *
	 * @return the string
	 */
	public static String wontBeCharged_txt(){
		id = "divTransactionMessage";
		return id;
	}
	
	/**
	 * Continue btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Submit bit Continue button
	public static WebElement continue_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_imgSubmitBidContinue"));
		return element;
	}
	
	/**
	 * Continue btn.
	 *
	 * @return the string
	 */
	public static String continue_btn(){
		id = "Main_imgSubmitBidContinue";
		return id;
	}
	
	/**
	 * Appraisal bid txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Submit bit Appraisal Bid textbox
	public static WebElement appraisalBid_txtbx(WebDriver driver){
		element = driver.findElement(By.id("txtBidFee"));
		return element;
	}
	
	/**
	 * Appraisal bid txtbx.
	 *
	 * @return the string
	 */
	public static String appraisalBid_txtbx(){
		id = "txtBidFee";
		return id;
	}
	
	/**
	 * Turn time txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Submit bit Turn time textbox
	public static WebElement turnTime_txtbx(WebDriver driver){
		element = driver.findElement(By.id("txtBidTurn"));
		return element;
	}
	
	/**
	 * Turn time txtbx.
	 *
	 * @return the string
	 */
	public static String turnTime_txtbx(){
		id = "txtBidTurn";
		return id;
	}
	
	/**
	 * Submit btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Submit bit Submit button
	public static WebElement submit_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_ctl01"));
		return element;
	}
	
	/**
	 * Submit btn.
	 *
	 * @return the string
	 */
	public static String submit_btn(){
		id = "Dialogs_ctl01";
		return id;
	}
	
	/**
	 * I have no interest chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Submit bit I have no interest checkbox
	public static WebElement iHaveNoInterest_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_biddingCertificationItems_isChecked_0"));
		return element;
	}
	
	/**
	 * I have no interest chkbx.
	 *
	 * @return the string
	 */
	public static String iHaveNoInterest_chkbx(){
		id = "Dialogs_biddingCertificationItems_isChecked_0";
		return id;
	}
	
	/**
	 * I have performed chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Submit bit I have performed checkbox
	public static WebElement iHavePerformed_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_biddingCertificationItems_isChecked_1"));
		return element;
	}
	
	/**
	 * I have performed chkbx.
	 *
	 * @return the string
	 */
	public static String iHavePerformed_chkbx(){
		id = "Dialogs_biddingCertificationItems_isChecked_1";
		return id;
	}
	
	/**
	 * I have no bias chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Submit bit I have no bias checkbox
	public static WebElement iHaveNoBias_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_biddingCertificationItems_isChecked_2"));
		return element;
	}
	
	/**
	 * I have no bias chkbx.
	 *
	 * @return the string
	 */
	public static String iHaveNoBias_chkbx(){
		id = "Dialogs_biddingCertificationItems_isChecked_2";
		return id;
	}
	
	/**
	 * My engagement chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Submit bit My engagement checkbox
	public static WebElement myEngagement_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_biddingCertificationItems_isChecked_3"));
		return element;
	}
	
	/**
	 * My engagement chkbx.
	 *
	 * @return the string
	 */
	public static String myEngagement_chkbx(){
		id = "Dialogs_biddingCertificationItems_isChecked_3";
		return id;
	}
	
	/**
	 * Decline dialog text
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement declineDialog_txt(WebDriver driver){
		element = driver.findElement(By.id("divMessageOKText"));
		return element;
	}
	
	/**
	 * Ok submit bid btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Submit bit OK button
	public static WebElement okSubmitBid_btn(WebDriver driver){
		element = driver.findElement(By.id("sbdmButton1"));
		return element;
	}
	
	/**
	 * Ok submit bid btn.
	 *
	 * @return the string
	 */
	public static String okSubmitBid_btn(){
		id = "sbdmButton1";
		return id;
	}
	
	/**
	 * Fee txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Request Modification Fee textbox
	public static WebElement fee_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_txtProposedPrice"));
		return element;
	}
	
	/**
	 * Fee txtbx.
	 *
	 * @return the string
	 */
	public static String fee_txtbx(){
		id = "Dialogs_Dialogs_txtProposedPrice";
		return id;
	}
	
	/**
	 * Ok request modification btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Request Modification OK button
	public static WebElement okRequestModification_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("input[onclick='SetStatusRequestMod();'][type='button']"));
		return element;
	}
	
	/**
	 * Ok request modification btn.
	 *
	 * @return the string
	 */
	public static String okRequestModification_btn(){
		cssSelector = "input[onclick='SetStatusRequestMod();'][type='button']";
		return cssSelector;
	}
	
	/**
	 * Notes txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Request Modification Notes textbox
	public static WebElement notes_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ctlRequestModMessage_txtMessage"));
		return element;
	}
	
	/**
	 * Notes txtbx.
	 *
	 * @return the string
	 */
	public static String notes_txtbx(){
		id = "Dialogs_Dialogs_ctlRequestModMessage_txtMessage";
		return id;
	}
	
	/**
	 * Ok attach document btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Attach Document OK button
	public static WebElement okAttachDocument_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ctl02"));
		return element;
	}
	
	/**
	 * Ok attach document btn.
	 *
	 * @return the string
	 */
	public static String okAttachDocument_btn(){
		id = "Dialogs_Dialogs_ctl02";
		return id;
	}
	
	/**
	 * Cancel inspection scheduled btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Cancel Inspection Scheduled button
	public static WebElement cancelInspectionScheduled_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#divSetInspection > div.MsgBoxContent > table > tbody > tr:nth-child(4) > td > input:nth-child(2)"));
		return element;
	}
	
	/**
	 * Cancel inspection scheduled btn.
	 *
	 * @return the string
	 */
	public static String cancelInspectionScheduled_btn(){
		cssSelector = "#divSetInspection > div.MsgBoxContent > table > tbody > tr:nth-child(4) > td > input:nth-child(2)";
		return cssSelector;
	}
	
	/**
	 * Order fee txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Order fee textbox
	public static WebElement orderFee_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_spnFee"));
		return element;
	}
	
	/**
	 * Order fee txtbx.
	 *
	 * @return the string
	 */
	public static String orderFee_txtbx(){
		id = "Main_Main_spnFee";
		return id;
	}
	
	/**
	 * Transaction fee txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Transaction fee textbox
	public static WebElement transactionFee_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_divTransFee"));
		return element;
	}
	
	/**
	 * Transaction fee txtbx.
	 *
	 * @return the string
	 */
	public static String transactionFee_txtbx(){
		id = "Main_Main_divTransFee";
		return id;
	}
	
	/**
	 * Payment method txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Payment Mehtod textbox
	public static WebElement paymentMethod_txtbx(WebDriver driver){
		element = driver.findElement(By.cssSelector("#divUpManageContent > div.GroupContent > div.FieldGroup > div.RightColumn > div:nth-child(1) > div.FieldValue"));
		return element;
	}
	
	/**
	 * Payment method txtbx.
	 *
	 * @return the string
	 */
	public static String paymentMethod_txtbx(){
		cssSelector = "#divUpManageContent > div.GroupContent > div.FieldGroup > div.RightColumn > div:nth-child(1) > div.FieldValue";
		return cssSelector;
	}
	
	/**
	 * Back btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Back button
	public static WebElement back_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/Images/Back16x16.png']"));
		return element;
	}
	
	/**
	 * Back btn.
	 *
	 * @return the string
	 */
	public static String back_btn(){
		cssSelector = "img[src='/Images/Back16x16.png']";
		return cssSelector;
	}
	
	/**
	 * Menu bar.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Menu bar
	public static WebElement menuBar(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_upMain"));
		return element;
	}
	
	/**
	 * Menu bar.
	 *
	 * @return the string
	 */
	public static String menuBar(){
		id = "Main_Main_upMain";
		return id;
	}
	
	/**
	 * Bid vendor information txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// bidVendorInformation_txt
	public static WebElement bidVendorInformation_txt(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_divAppraiserInformation"));
		return element;
	}
	
	/**
	 * Bid vendor information txt.
	 *
	 * @return the string
	 */
	public static String bidVendorInformation_txt(){
		id = "Main_Main_divAppraiserInformation";
		return id;
	}
	
	/**
	 * I accept these terms radiobtn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// iAcceptTheseTerms_radiobtn
	public static WebElement iAcceptTheseTerms_radiobtn(WebDriver driver){
		element = driver.findElement(By.id("Main_ctl00"));
		return element;
	}
	
	/**
	 * I accept these terms radiobtn.
	 *
	 * @return the string
	 */
	public static String iAcceptTheseTerms_radiobtn(){
		id = "Main_ctl00";
		return id;
	}
	
	/**
	 * I am unable to bid on this opportunity radiobtn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// iAcceptTheseTerms_radiobtn
	public static WebElement iAmUnableToBidOnThisOpportunity_radiobtn(WebDriver driver){
		element = driver.findElement(By.id("Main_rdNoBid"));
		return element;
	}
	
	/**
	 * I am unable to bid on this opportunity radiobtn.
	 *
	 * @return the string
	 */
	public static String iAmUnableToBidOnThisOpportunity_radiobtn(){
		id = "Main_rdNoBid";
		return id;
	}
	
	/**
	 * Provide A message to the client txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// provideAMessageToTheClient_txtbx
	public static WebElement provideAMessageToTheClient_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_txtClientMessage_txtMessage"));
		return element;
	}
	
	/**
	 * Provide A message to the client txtbx.
	 *
	 * @return the string
	 */
	public static String provideAMessageToTheClient_txtbx(){
		id = "Main_txtClientMessage_txtMessage";
		return id;
	}
	
	/**
	 * Upload mismo XM L btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// uploadMismoXML_btn
	public static WebElement uploadMismoXML_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_btnUploadMismo"));
		return element;
	}
	
	/**
	 * Upload mismo XM L btn.
	 *
	 * @return the string
	 */
	public static String uploadMismoXML_btn(){
		id = "Dialogs_Dialogs_btnUploadMismo";
		return id;
	}
	
	/**
	 * Mismo XML attached icon btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// MISMO XML attached icon
	public static WebElement mismoXMLAttachedIcon_btn(WebDriver driver){
		element = driver.findElement(By.id("pbMismo_Icon"));
		return element;
	}
	
	/**
	 * Mismo XML attached icon btn.
	 *
	 * @return the string
	 */
	public static String mismoXMLAttachedIcon_btn(){
		id = "pbMismo_Icon";
		return id;
	}
	
	/**
	 * orderDocuments_txt
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// MISMO XML attached icon
	public static WebElement orderDocuments_txt(WebDriver driver){
		element = driver.findElement(By.id("tblODFiles"));
		return element;
	}
	
	/**
	 * orderDocuments_txt
	 *
	 * @return the string
	 */
	public static String orderDocuments_txt(){
		id = "tblODFiles";
		return id;
	}
	
	/**
	 * status_txt
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// MISMO XML attached icon
	public static WebElement status_txt(WebDriver driver){
		element = driver.findElement(By.id("divHistoryCaption"));
		return element;
	}
	
	/**
	 * status_txt
	 *
	 * @return the string
	 */
	public static String status_txt(){
		id = "divHistoryCaption";
		return id;
	}
	
} // end VOrderDetails class