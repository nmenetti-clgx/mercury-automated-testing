package pageObjects.VMP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the VMP Appraisal Order Details page
 */
public class VMPAppraisalOrderDetails {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	/** The css selector. */
	private static String cssSelector = null;

	
	/**
	 * Order details txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Order details text
	public static WebElement orderDetails_txt(WebDriver driver){
		element = driver.findElement(By.id("divFields"));
		return element;
	}
	
	/**
	 * Order details txt.
	 *
	 * @return the string
	 */
	public static String orderDetails_txt(){
		id = "divFields";
		return id;
	}
	
	/**
	 * Contact details txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Contact details text
	public static WebElement contactDetails_txt(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_upContacts"));
		return element;
	}
	
	/**
	 * Contact details txt.
	 *
	 * @return the string
	 */
	public static String contactDetails_txt(){
		id = "ctl00_ctl00_Main_Main_upContacts";
		return id;
	}
	
	/**
	 * Additional notification recipients txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Additional Notification Recipients text
	public static WebElement additionalNotificationRecipients_txt(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_lblAdditionalRecipients"));
		return element;
	}
	
	/**
	 * Additional notification recipients txt.
	 *
	 * @return the string
	 */
	public static String additionalNotificationRecipients_txt(){
		id = "ctl00_ctl00_Main_Main_lblAdditionalRecipients";
		return id;
	}
	
	/**
	 * Special instructions txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Special instructions text
	public static WebElement specialInstructions_txt(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_divSpecialInstructionsContainer"));
		return element;
	}
	
	/**
	 * Special instructions txt.
	 *
	 * @return the string
	 */
	public static String specialInstructions_txt(){
		id = "ctl00_ctl00_Main_Main_divSpecialInstructionsContainer";
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
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_divHistoryItems"));
		return element;
	}
	
	/**
	 * History txt.
	 *
	 * @return the string
	 */
	public static String history_txt(){
		id = "ctl00_ctl00_Main_Main_divHistoryItems";
		return id;
	}
	
	/**
	 * Assigned A E txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Assigned AE text
	public static WebElement assignedAE_txt(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_divAssignedAE"));
		return element;
	}
	
	/**
	 * Assigned A E txt.
	 *
	 * @return the string
	 */
	public static String assignedAE_txt(){
		id = "ctl00_ctl00_Main_Main_divAssignedAE";
		return id;
	}
	
	/**
	 * Area below history txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Area below History text
	public static WebElement areaBelowHistory_txt(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_divNoHistory"));
		return element;
	}
	
	/**
	 * Area below history txt.
	 *
	 * @return the string
	 */
	public static String areaBelowHistory_txt(){
		id = "ctl00_ctl00_Main_Main_divNoHistory";
		return id;
	}
	
	/**
	 * Edits the property contacts lnk.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Edit Property Contacts link
	public static WebElement editPropertyContacts_lnk(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_lnkPropertyContacts"));
		return element;
	}
	
	/**
	 * Edits the property contacts lnk.
	 *
	 * @return the string
	 */
	public static String editPropertyContacts_lnk(){
		id = "ctl00_ctl00_Main_Main_lnkPropertyContacts";
		return id;
	}
	
	/**
	 * Other actions btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Other Actions button
	public static WebElement otherActions_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='Images/Toolbar/OtherActions16x16.png']"));
		return element;
	}
	
	/**
	 * Other actions btn.
	 *
	 * @return the string
	 */
	public static String otherActions_btn(){
		cssSelector = "img[src='Images/Toolbar/OtherActions16x16.png']";
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
		element = driver.findElement(By.cssSelector("img[src='Images/Toolbar/Delayed.png']"));
		return element;
	}
	
	/**
	 * Delayed btn.
	 *
	 * @return the string
	 */
	public static String delayed_btn(){
		cssSelector = "img[src='Images/Toolbar/Delayed.png']";
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
		element = driver.findElement(By.cssSelector("img[src='Images/Toolbar/Resume.png']"));
		return element;
	}
	
	/**
	 * Resume btn.
	 *
	 * @return the string
	 */
	public static String resume_btn(){
		cssSelector = "img[src='Images/Toolbar/Resume.png']";
		return cssSelector;
	}
	
	/**
	 * Place on hold btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// On Hold button
	public static WebElement placeOnHold_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='Images/Toolbar/PlaceOnHold.png']"));
		return element;
	}
	
	/**
	 * Place on hold btn.
	 *
	 * @return the string
	 */
	public static String placeOnHold_btn(){
		cssSelector = "img[src='Images/Toolbar/PlaceOnHold.png']";
		return cssSelector;
	}
	
	/**
	 * Duplicate order btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Duplicate Order button
	public static WebElement duplicateOrder_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#ctl00_ctl00_Main_Main_tbMain_3 > table > tbody > tr:nth-child(5) > td > div.MenuItemLabel"));
		return element;
	}
	
	/**
	 * Duplicate order btn.
	 *
	 * @return the string
	 */
	public static String duplicateOrder_btn(){
		cssSelector = "#ctl00_ctl00_Main_Main_tbMain_3 > table > tbody > tr:nth-child(5) > td > div.MenuItemLabel";
		return cssSelector;
	}
	
	/**
	 * Cancel revision request btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Cancel Revision Request button
	public static WebElement cancelRevisionRequest_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='Images/Toolbar/cancelrevision.png']"));
		return element;
	}
	
	/**
	 * Cancel revision request btn.
	 *
	 * @return the string
	 */
	public static String cancelRevisionRequest_btn(){
		cssSelector = "img[src='Images/Toolbar/cancelrevision.png']";
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
		element = driver.findElement(By.cssSelector("img[src='Images/Toolbar/SendMessage16x16.png']"));
		return element;
	}
	
	/**
	 * Send message btn.
	 *
	 * @return the string
	 */
	public static String sendMessage_btn(){
		cssSelector = "img[src='Images/Toolbar/SendMessage16x16.png']";
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
		element = driver.findElement(By.cssSelector("img[src='Images/Toolbar/AttachDocument16x16.png']"));
		return element;
	}
	
	/**
	 * Attach documents btn.
	 *
	 * @return the string
	 */
	public static String attachDocuments_btn(){
		cssSelector = "img[src='Images/Toolbar/AttachDocument16x16.png']";
		return cssSelector;
	}
	
	/**
	 * Delayed notes txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Delayed Notes text box
	public static WebElement delayedNotes_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Dialogs_Dialogs_txtDelayedNotes"));
		return element;
	}
	
	/**
	 * Delayed notes txtbx.
	 *
	 * @return the string
	 */
	public static String delayedNotes_txtbx(){
		id = "ctl00_ctl00_Dialogs_Dialogs_txtDelayedNotes";
		return id;
	}
	
	/**
	 * Delayed ok btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Delayed OK button
	public static WebElement delayedOk_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#divDelayed > div.MsgBoxContent > div.DialogButtons > input:nth-child(1)"));
		return element;
	}
	
	/**
	 * Delayed ok btn.
	 *
	 * @return the string
	 */
	public static String delayedOk_btn(){
		cssSelector = "#divDelayed > div.MsgBoxContent > div.DialogButtons > input:nth-child(1)";
		return cssSelector;
	}
	
	/**
	 * Resume notes txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Resume Notes text box
	public static WebElement resumeNotes_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Dialogs_Dialogs_txtResumeNotes"));
		return element;
	}
	
	/**
	 * Resume notes txtbx.
	 *
	 * @return the string
	 */
	public static String resumeNotes_txtbx(){
		id = "ctl00_ctl00_Dialogs_Dialogs_txtResumeNotes";
		return id;
	}
	
	/**
	 * Resume ok btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Resume OK button
	public static WebElement resumeOk_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#divResume > div.MsgBoxContent > div.DialogButtons > input:nth-child(1)"));
		return element;
	}
	
	/**
	 * Resume ok btn.
	 *
	 * @return the string
	 */
	public static String resumeOk_btn(){
		cssSelector = "#divResume > div.MsgBoxContent > div.DialogButtons > input:nth-child(1)";
		return cssSelector;
	}
	
	/**
	 * Place on hold notes txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Place On Hold Notes text box
	public static WebElement placeOnHoldNotes_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Dialogs_Dialogs_txtPlaceOnHoldNotes"));
		return element;
	}
	
	/**
	 * Place on hold notes txtbx.
	 *
	 * @return the string
	 */
	public static String placeOnHoldNotes_txtbx(){
		id = "ctl00_ctl00_Dialogs_Dialogs_txtPlaceOnHoldNotes";
		return id;
	}
	
	/**
	 * Place on hold ok btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Place On Hold OK button
	public static WebElement placeOnHoldOk_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#divPlaceOnHold > div.MsgBoxContent > div.DialogButtons > input:nth-child(1)"));
		return element;
	}
	
	/**
	 * Place on hold ok btn.
	 *
	 * @return the string
	 */
	public static String placeOnHoldOk_btn(){
		cssSelector = "#divPlaceOnHold > div.MsgBoxContent > div.DialogButtons > input:nth-child(1)";
		return cssSelector;
	}
	
	/**
	 * Place on hold cancel btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Place On Hold Cancel button
	public static WebElement placeOnHoldCancel_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#divPlaceOnHold > div.MsgBoxContent > div.DialogButtons > input:nth-child(2)"));
		return element;
	}
	
	/**
	 * Place on hold cancel btn.
	 *
	 * @return the string
	 */
	public static String placeOnHoldCancel_btn(){
		cssSelector = "#divPlaceOnHold > div.MsgBoxContent > div.DialogButtons > input:nth-child(2)";
		return cssSelector;
	}
	
	/**
	 * Send message txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Send Message Notes text box
	public static WebElement sendMessage_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Dialogs_Dialogs_txtSendMessageNotes"));
		return element;
	}
	
	/**
	 * Send message txtbx.
	 *
	 * @return the string
	 */
	public static String sendMessage_txtbx(){
		id = "ctl00_ctl00_Dialogs_Dialogs_txtSendMessageNotes";
		return id;
	}
	
	/**
	 * Action required chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Send Message Action Required check box
	public static WebElement actionRequired_chkbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Dialogs_Dialogs_chkSendMessageAction"));
		return element;
	}
	
	/**
	 * Action required chkbx.
	 *
	 * @return the string
	 */
	public static String actionRequired_chkbx(){
		id = "ctl00_ctl00_Dialogs_Dialogs_chkSendMessageAction";
		return id;
	}
	
	/**
	 * Send btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Send Message Send button
	public static WebElement send_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("input[type='button'][value='Send'][onclick='SendMessage_Save();']"));
		return element;
	}
	
	/**
	 * Send btn.
	 *
	 * @return the string
	 */
	public static String send_btn(){
		cssSelector = "input[type='button'][value='Send'][onclick='SendMessage_Save();']";
		return cssSelector;
	}
	
	/**
	 * Alert dialog txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Alert dialog text
	public static WebElement alertDialog_txt(WebDriver driver){
		element = driver.findElement(By.id("AlertDialogText"));
		return element;
	}
	
	/**
	 * Alert dialog txt.
	 *
	 * @return the string
	 */
	public static String alertDialog_txt(){
		id = "AlertDialogText";
		return id;
	}
	
	/**
	 * Alert dialog ok btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Alert Dialog OK button
	public static WebElement alertDialogOk_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("input[value='OK'][onclick='javascript:HideAlert();']"));
		return element;
	}
	
	/**
	 * Alert dialog ok btn.
	 *
	 * @return the string
	 */
	public static String alertDialogOk_btn(){
		cssSelector = "input[value='OK'][onclick='javascript:HideAlert();']";
		return cssSelector;
	}
	
	/**
	 * Tracking number txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Tracking# text
	public static WebElement trackingNumber_txt(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_divTrackingNumber"));
		return element;
	}
	
	/**
	 * Tracking number txt.
	 *
	 * @return the string
	 */
	public static String trackingNumber_txt(){
		id = "ctl00_ctl00_Main_Main_divTrackingNumber";
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
	 * Attached document name txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Attached Document Name text
	public static WebElement attachedDocumentName_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector("#tblODDetails > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2)"));
		return element;
	}
	
	/**
	 * Attached document name txt.
	 *
	 * @return the string
	 */
	public static String attachedDocumentName_txt(){
		cssSelector = "#tblODDetails > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2)";
		return cssSelector;
	}
	
	/**
	 * Attached document uploaded by txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Attached Document Name text
	public static WebElement attachedDocumentUploadedBy_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector("#tblODDetails > tbody:nth-child(1) > tr:nth-child(3) > td:nth-child(2)"));
		return element;
	}
	
	/**
	 * Attached document uploaded by txt.
	 *
	 * @return the string
	 */
	public static String attachedDocumentUploadedBy_txt(){
		cssSelector = "#tblODDetails > tbody:nth-child(1) > tr:nth-child(3) > td:nth-child(2)";
		return cssSelector;
	}
	
	/**
	 * Open btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Open document button
	public static WebElement open_btn(WebDriver driver){
		element = driver.findElement(By.id("thODOpen"));
		return element;
	}
	
	/**
	 * Open btn.
	 *
	 * @return the string
	 */
	public static String open_btn(){
		id = "thODOpen";
		return id;
	}
	
	/**
	 * Documents txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Documents text
	public static WebElement documents_txt(WebDriver driver){
		element = driver.findElement(By.id("divDocuments"));
		return element;
	}
	
	/**
	 * Documents txt.
	 *
	 * @return the string
	 */
	public static String documents_txt(){
		id = "divDocuments";
		return id;
	}
	
	/**
	 * Back btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Back button
	public static WebElement back_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='Images/Toolbar/Back16x16.png']"));
		return element;
	}
	
	/**
	 * Back btn.
	 *
	 * @return the string
	 */
	public static String back_btn(){
		cssSelector = "img[src='Images/Toolbar/Back16x16.png']";
		return cssSelector;
	}
	
}
