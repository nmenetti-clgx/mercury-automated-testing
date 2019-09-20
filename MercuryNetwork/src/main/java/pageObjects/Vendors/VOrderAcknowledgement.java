package pageObjects.Vendors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Vendors Order Acknowledgement page
 */
public class VOrderAcknowledgement {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	/** The css selector. */
	private static String cssSelector = null;

	
	/**
	 * Select action dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Select Action dropdown
	public static WebElement selectAction_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ddlAcknowledgeAction"));
		return element;
	}
	
	/**
	 * Select action dropdown.
	 *
	 * @return the string
	 */
	public static String selectAction_dropdown(){
		id = "Dialogs_Dialogs_ddlAcknowledgeAction";
		return id;
	}
	
	/**
	 * Fee txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Fee text box
	public static WebElement fee_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_txtAcknowledgeFee"));
		return element;
	}
	
	/**
	 * Fee txtbx.
	 *
	 * @return the string
	 */
	public static String fee_txtbx(){
		id = "Dialogs_Dialogs_txtAcknowledgeFee";
		return id;
	}
	
	/**
	 * Due date txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Due Date text box
	public static WebElement dueDate_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_txtAcknowledgeDueDate"));
		return element;
	}
	
	/**
	 * Due date txtbx.
	 *
	 * @return the string
	 */
	public static String dueDate_txtbx(){
		id = "Dialogs_Dialogs_txtAcknowledgeDueDate";
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
		element = driver.findElement(By.cssSelector("#tblAcknowledge_ConditionalDecline > tbody:nth-child(1) > tr:nth-child(3) > td:nth-child(2) > img:nth-child(2)"));
		return element;
	}
	
	/**
	 * Calendar btn.
	 *
	 * @return the string
	 */
	public static String calendar_btn(){
		cssSelector = "#tblAcknowledge_ConditionalDecline > tbody:nth-child(1) > tr:nth-child(3) > td:nth-child(2) > img:nth-child(2)";
		return cssSelector;
	}
	
	/**
	 * Search txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Search text box
	public static WebElement search_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ctlAcknowledgeMessage_ConditionalDecline_txtCannedCommentSearch"));
		return element;
	}
	
	/**
	 * Search txtbx.
	 *
	 * @return the string
	 */
	public static String search_txtbx(){
		id = "Dialogs_Dialogs_ctlAcknowledgeMessage_ConditionalDecline_txtCannedCommentSearch";
		return id;
	}
	
	/**
	 * Accept options.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// accept checkbox list
	public static WebElement acceptOptions(WebDriver driver){
		element = driver.findElement(By.id("divAcknowledgeMessage_Accept"));
		return element;
	}
	
	/**
	 * Accept options.
	 *
	 * @return the string
	 */
	public static String acceptOptions(){
		id = "divAcknowledgeMessage_Accept";
		return id;
	}
	
	/**
	 * Conditional decline options.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// conditionalDeclineOptions checkbox list
	public static WebElement conditionalDeclineOptions(WebDriver driver){
		element = driver.findElement(By.id("divAcknowledgeMessage_ConditionalDecline"));
		return element;
	}
	
	/**
	 * Conditional decline options.
	 *
	 * @return the string
	 */
	public static String conditionalDeclineOptions(){
		id = "divAcknowledgeMessage_ConditionalDecline";
		return id;
	}
	
	/**
	 * Decline options.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// decline checkbox list
	public static WebElement declineOptions(WebDriver driver){
		element = driver.findElement(By.id("divAcknowledgeMessage_Decline"));
		return element;
	}
	
	/**
	 * Decline options.
	 *
	 * @return the string
	 */
	public static String declineOptions(){
		id = "divAcknowledgeMessage_Decline";
		return id;
	}
	
	/**
	 * Extra charge chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Complexity of job requires extra charge checkbox
	public static WebElement extraCharge_chkbx(WebDriver driver){
		element = driver.findElement(By.cssSelector("input[value='Complexity of job requires extra charge']"));
		return element;
	}
	
	/**
	 * Extra charge chkbx.
	 *
	 * @return the string
	 */
	public static String extraCharge_chkbx(){
		cssSelector = "input[value='Complexity of job requires extra charge']";
		return cssSelector;
	}

	/**
	 * Extra time chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Current workload requires extra time checkbox
	public static WebElement extraTime_chkbx(WebDriver driver){
		element = driver.findElement(By.cssSelector("input[value='Complexity of job requires extra time']"));
		return element;
	}
	
	/**
	 * Extra time chkbx.
	 *
	 * @return the string
	 */
	public static String extraTime_chkbx(){
		cssSelector = "input[value='Complexity of job requires extra time']";
		return cssSelector;
	}
	
	/**
	 * Suggest A canned comment lnk.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Suggest a canned comment
	public static WebElement suggestACannedComment_lnk(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ctlAcknowledgeMessage_ConditionalDecline_cannedCommentsURL"));
		return element;
	}
	
	/**
	 * Suggest A canned comment lnk.
	 *
	 * @return the string
	 */
	public static String suggestACannedComment_lnk(){
		id = "Dialogs_Dialogs_ctlAcknowledgeMessage_ConditionalDecline_cannedCommentsURL";
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
		element = driver.findElement(By.cssSelector("#Dialogs_Dialogs_upAcknowledge > div.VendorAcceptanceFooter > div:nth-child(2) > input:nth-child(1)"));
		return element;
	}
	
	/**
	 * Ok btn.
	 *
	 * @return the string
	 */
	public static String ok_btn(){
		cssSelector = "#Dialogs_Dialogs_upAcknowledge > div.VendorAcceptanceFooter > div:nth-child(2) > input:nth-child(1)";
		return cssSelector;
	}
	
	/**
	 * Ok 2 btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// OK button
	public static WebElement ok2_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_imgSubmitBidContinue"));
		return element;
	}
	
	/**
	 * Ok 2 btn.
	 *
	 * @return the string
	 */
	public static String ok2_btn(){
		id = "Main_imgSubmitBidContinue";
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
		element = driver.findElement(By.cssSelector("input.Button[value='Cancel']"));
		return element;
	}
	
	/**
	 * Cancel btn.
	 *
	 * @return the string
	 */
	public static String cancel_btn(){
		cssSelector = "input.Button[value='Cancel']";
		return cssSelector;
	}
	
	/**
	 * Order acknowledgement O K btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Order acknowledgement OK button
	public static WebElement orderAcknowledgementOK_btn (WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_sbTransactionFeeOK"));
		return element;
	}
	
	/**
	 * Order acknowledgement O K btn.
	 *
	 * @return the string
	 */
	public static String orderAcknowledgementOK_btn(){
		id = "Dialogs_Dialogs_sbTransactionFeeOK";
		return id;
	}
	
	/**
	 * Order acknowledgement cancel btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Order acknowledgement Cancel button
	public static WebElement orderAcknowledgementCancel_btn (WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_sbTransactionFeeCancel"));
		return element;
	}
	
	/**
	 * Order acknowledgement cancel btn.
	 *
	 * @return the string
	 */
	public static String orderAcknowledgementCancel_btn(){
		id = "Dialogs_Dialogs_sbTransactionFeeCancel";
		return id;
	}
	
	/**
	 * Order acknowledgement txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Order acknowledgement text
	public static WebElement orderAcknowledgement_txt (WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_upTransactionFeeMessage"));
		return element;
	}
	
	/**
	 * Order acknowledgement txt.
	 *
	 * @return the string
	 */
	public static String orderAcknowledgement_txt(){
		id = "Dialogs_Dialogs_upTransactionFeeMessage";
		return id;
	}
	
	/**
	 * Alert txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Alert text
	public static WebElement alert_txt (WebDriver driver){
		element = driver.findElement(By.id("AlertDialogText"));
		return element;
	}
	
	/**
	 * Alert txt.
	 *
	 * @return the string
	 */
	public static String alert_txt(){
		id = "AlertDialogText";
		return id;
	}
	
	/**
	 * Alert ok btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Alert OK button
	public static WebElement alertOk_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("input[value='OK']"));
		return element;
	}
	
	/**
	 * Alert ok btn.
	 *
	 * @return the string
	 */
	public static String alertOk_btn(){
		cssSelector = "input[value='OK']";
		return cssSelector;
	}
	
	/**
	 * Conditional decline notes txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Conditional Decline Notes text box
	public static WebElement conditionalDeclineNotes_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ctlAcknowledgeMessage_ConditionalDecline_txtMessage"));
		return element;
	}
	
	/**
	 * Conditional decline notes txtbx.
	 *
	 * @return the string
	 */
	public static String conditionalDeclineNotes_txtbx(){
		id = "Dialogs_Dialogs_ctlAcknowledgeMessage_ConditionalDecline_txtMessage";
		return id;
	}
	
	/**
	 * Accept assignment notes txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Accept Assignment Notes text box
	public static WebElement acceptAssignmentNotes_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ctlAcknowledgeMessage_Accept_txtMessage"));
		return element;
	}
	
	/**
	 * Accept assignment notes txtbx.
	 *
	 * @return the string
	 */
	public static String acceptAssignmentNotes_txtbx(){
		id = "Dialogs_Dialogs_ctlAcknowledgeMessage_Accept_txtMessage";
		return id;
	}
	
	/**
	 * Decline assignment notes txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Decline Assignment Notes text box
	public static WebElement declineAssignmentNotes_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ctlAcknowledgeMessage_Decline_txtMessage"));
		return element;
	}
	
	/**
	 * Decline assignment notes txtbx.
	 *
	 * @return the string
	 */
	public static String declineAssignmentNotes_txtbx(){
		id = "Dialogs_Dialogs_ctlAcknowledgeMessage_Decline_txtMessage";
		return id;
	}
	
	/**
	 * Yes radiobtn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Yes, I accept this order radio button
	public static WebElement yes_radiobtn(WebDriver driver){
		element = driver.findElement(By.id("optAccept"));
		return element;
	}
	
	/**
	 * Yes radiobtn.
	 *
	 * @return the string
	 */
	public static String yes_radiobtn(){
		id = "optAccept";
		return id;
	}
	
	/**
	 * No radiobtn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// No, I must decline this order radio button
	public static WebElement no_radiobtn(WebDriver driver){
		element = driver.findElement(By.id("optDecline"));
		return element;
	}
	
	/**
	 * No radiobtn.
	 *
	 * @return the string
	 */
	public static String no_radiobtn(){
		id = "optDecline";
		return id;
	}
	
	/**
	 * Message to client txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Message to client text box
	public static WebElement messageToClient_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_txtClientMessage_txtMessage"));
		return element;
	}
	
	/**
	 * Message to client txtbx.
	 *
	 * @return the string
	 */
	public static String messageToClient_txtbx(){
		id = "Main_txtClientMessage_txtMessage";
		return id;
	}
	
	/**
	 * Canned comments txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// canned comment text
	public static WebElement cannedComments_txt(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ctlAcknowledgeMessage_Accept_cblMessage"));
		return element;
	}
	
	/**
	 * Canned comments txt.
	 *
	 * @return the string
	 */
	public static String cannedComments_txt(){
		id = "Dialogs_Dialogs_ctlAcknowledgeMessage_Accept_cblMessage";
		return id;
	}
	
	/**
	 * First canned comment chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// First canned comment checkbox
	public static WebElement firstCannedComment_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ctlAcknowledgeMessage_Accept_cblMessage_0"));
		return element;
	}
	
	/**
	 * First canned comment chkbx.
	 *
	 * @return the string
	 */
	public static String firstCannedComment_chkbx(){
		id = "Dialogs_Dialogs_ctlAcknowledgeMessage_Accept_cblMessage_0";
		return id;
	}
	
	/**
	 * Second canned comment chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Second canned comment checkbox
	public static WebElement secondCannedComment_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ctlAcknowledgeMessage_Accept_cblMessage_1"));
		return element;
	}
	
	/**
	 * Second canned comment chkbx.
	 *
	 * @return the string
	 */
	public static String secondCannedComment_chkbx(){
		id = "Dialogs_Dialogs_ctlAcknowledgeMessage_Accept_cblMessage_1";
		return id;
	}
	
}
