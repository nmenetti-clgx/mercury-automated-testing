package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure Review Bids page
 */
public class SReviewBids {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	/** The css selector. */
	private static String cssSelector = null;

	
	/**
	 * Close review bids btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Review Bids Close button
	public static WebElement closeReviewBids_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_btnClose"));
		return element;
	}
	
	/**
	 * Close review bids btn.
	 *
	 * @return the string
	 */
	public static String closeReviewBids_btn(){
		id = "Main_btnClose";
		return id;
	}
	
	/**
	 * Adds the vendor btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Add vendor button
	public static WebElement addVendor_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/App_Themes/FlatGrayscale/Icons/Add.O.png']"));
		return element;
	}
	
	/**
	 * Adds the vendor btn.
	 *
	 * @return the string
	 */
	public static String addVendor_btn(){
		cssSelector = "img[src='/App_Themes/FlatGrayscale/Icons/Add.O.png']";
		return cssSelector;
	}
	
	/**
	 * Appraiser table txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Review Bids appraiser table text
	public static WebElement appraiserTable_txt(WebDriver driver){
		element = driver.findElement(By.id("tblReview"));
		return element;
	}
	
	/**
	 * Appraiser table txt.
	 *
	 * @return the string
	 */
	public static String appraiserTable_txt(){
		id = "tblReview";
		return id;
	}
	
	/**
	 * Award bid btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Award bid button
	public static WebElement awardBid_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/App_Themes/FlatGrayscale/Icons/Trophy.O.png']"));
		return element;
	}
	
	/**
	 * Award bid btn.
	 *
	 * @return the string
	 */
	public static String awardBid_btn(){
		cssSelector = "img[src='/App_Themes/FlatGrayscale/Icons/Trophy.O.png']";
		return cssSelector;
	}
	
	/**
	 * Award btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Review Bids Award button
	public static WebElement award_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_btnAward"));
		return element;
	}
	
	/**
	 * Award btn.
	 *
	 * @return the string
	 */
	public static String award_btn(){
		id = "Main_btnAward";
		return id;
	}
	
	/**
	 * Table txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Table text
	public static WebElement table_txt(WebDriver driver){
		element = driver.findElement(By.id("tblReview_scroll"));
		return element;
	}
	
	/**
	 * Table txt.
	 *
	 * @return the string
	 */
	public static String table_txt(){
		id = "tblReview_scroll";
		return id;
	}
	
	/**
	 * Award bid disabled btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Award bid disabled button
	public static WebElement awardBidDisabled_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/App_Themes/FlatGrayscale/Icons/Trophy.O-Disabled.png']"));
		return element;
	}
	
	/**
	 * Award bid disabled btn.
	 *
	 * @return the string
	 */
	public static String awardBidDisabled_btn(){
		cssSelector = "img[src='/App_Themes/FlatGrayscale/Icons/Trophy.O-Disabled.png']";
		return cssSelector;
	}
	
	/**
	 * Decline bid disabled btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Decline bid disabled button
	public static WebElement declineBidDisabled_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/App_Themes/FlatGrayscale/Icons/CancelDelete.O-Disabled.png']"));
		return element;
	}
	
	/**
	 * Decline bid disabled btn.
	 *
	 * @return the string
	 */
	public static String declineBidDisabled_btn(){
		cssSelector = "img[src='/App_Themes/FlatGrayscale/Icons/CancelDelete.O-Disabled.png']";
		return cssSelector;
	}
	
	/**
	 * Send message disabled btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Send Message disabled button
	public static WebElement sendMessageDisabled_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/App_Themes/FlatGrayscale/Icons/Send.O-Disabled.png']"));
		return element;
	}
	
	/**
	 * Send message disabled btn.
	 *
	 * @return the string
	 */
	public static String sendMessageDisabled_btn(){
		cssSelector = "img[src='/App_Themes/FlatGrayscale/Icons/Send.O-Disabled.png']";
		return cssSelector;
	}
	
	/**
	 * Decline bid btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Decline bid button
	public static WebElement declineBid_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/App_Themes/FlatGrayscale/Icons/CancelDelete.O.png']"));
		return element;
	}
	
	/**
	 * Decline bid btn.
	 *
	 * @return the string
	 */
	public static String declineBid_btn(){
		cssSelector = "img[src='/App_Themes/FlatGrayscale/Icons/CancelDelete.O.png']";
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
		element = driver.findElement(By.cssSelector("img[src='/App_Themes/FlatGrayscale/Icons/Send.O.png']"));
		return element;
	}
	
	/**
	 * Send message btn.
	 *
	 * @return the string
	 */
	public static String sendMessage_btn(){
		cssSelector = "img[src='/App_Themes/FlatGrayscale/Icons/Send.O.png']";
		return cssSelector;
	}
	
	/**
	 * Rank vendors btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Rank Vendors button
	public static WebElement rankVendors_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/App_Themes/FlatGrayscale/Icons/Star.O.png']"));
		return element;
	}
	
	/**
	 * Rank vendors btn.
	 *
	 * @return the string
	 */
	public static String rankVendors_btn(){
		cssSelector = "img[src='/App_Themes/FlatGrayscale/Icons/Star.O.png']";
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
		element = driver.findElement(By.id("Main_btnClose"));
		return element;
	}
	
	/**
	 * Save btn.
	 *
	 * @return the string
	 */
	public static String save_btn(){
		id = "Main_btnClose";
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
		element = driver.findElement(By.id("sbdmButton1"));
		return element;
	}
	
	/**
	 * Ok btn.
	 *
	 * @return the string
	 */
	public static String ok_btn(){
		id = "sbdmButton1";
		return id;
	}
	
	/**
	 * Dialog txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Dialog text
	public static WebElement dialog_txt(WebDriver driver){
		element = driver.findElement(By.id("divMessageOK"));
		return element;
	}
	
	/**
	 * Dialog txt.
	 *
	 * @return the string
	 */
	public static String dialog_txt(){
		id = "divMessageOK";
		return id;
	}
	
	/**
	 * Change bid due btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Change bid due button
	public static WebElement changeBidDue_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/App_Themes/FlatGrayscale/Icons/ChangeDate.O.png']"));
		return element;
	}
	
	/**
	 * Change bid due btn.
	 *
	 * @return the string
	 */
	public static String changeBidDue_btn(){
		cssSelector = "img[src='/App_Themes/FlatGrayscale/Icons/ChangeDate.O.png']";
		return cssSelector;
	}
	
	/**
	 * Cancel send message btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Cancel Send Message button
	public static WebElement cancelSendMessage_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_ctl00"));
		return element;
	}
	
	/**
	 * Cancel send message btn.
	 *
	 * @return the string
	 */
	public static String cancelSendMessage_btn(){
		id = "Dialogs_ctl00";
		return id;
	}
	
	/**
	 * Send send message btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Send Send Message button
	public static WebElement sendSendMessage_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_btnSendMessage"));
		return element;
	}
	
	/**
	 * Send send message btn.
	 *
	 * @return the string
	 */
	public static String sendSendMessage_btn(){
		id = "Dialogs_btnSendMessage";
		return id;
	}
	
	/**
	 * To send message txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// To Send Message textbox
	public static WebElement toSendMessage_txtbx(WebDriver driver){
		element = driver.findElement(By.id("divSendVendors"));
		return element;
	}
	
	/**
	 * To send message txtbx.
	 *
	 * @return the string
	 */
	public static String toSendMessage_txtbx(){
		id = "divSendVendors";
		return id;
	}
	
	/**
	 * Message send message txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Message Send Message textbox
	public static WebElement messageSendMessage_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_txtSendComments"));
		return element;
	}
	
	/**
	 * Message send message txtbx.
	 *
	 * @return the string
	 */
	public static String messageSendMessage_txtbx(){
		id = "Dialogs_txtSendComments";
		return id;
	}
	
	/**
	 * Calendar.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Calendar ID
	public static WebElement calendar(WebDriver driver){
		element = driver.findElement(By.id("Main_calPopUp_tblControl"));
		return element;
	}
	
	/**
	 * Calendar.
	 *
	 * @return the string
	 */
	public static String calendar(){
		id = "Main_calPopUp_tblControl";
		return id;
	}
	
	/**
	 * Calendar month txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Calendar Month text
	public static WebElement calendarMonth_txt(WebDriver driver){
		element = driver.findElement(By.id("Main_calPopUp_lblHeaderMonth"));
		return element;
	}
	
	/**
	 * Calendar month txt.
	 *
	 * @return the string
	 */
	public static String calendarMonth_txt(){
		id = "Main_calPopUp_lblHeaderMonth";
		return id;
	}
	
	/**
	 * Calendar previous month btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Calendar Previous Month
	public static WebElement calendarPreviousMonth_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_calPopUp_imgCalendarChangeLeft"));
		return element;
	}
	
	/**
	 * Calendar previous month btn.
	 *
	 * @return the string
	 */
	public static String calendarPreviousMonth_btn(){
		id = "Main_calPopUp_imgCalendarChangeLeft";
		return id;
	}
	
	/**
	 * Calendar next month btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Calendar Next Month
	public static WebElement calendarNextMonth_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_calPopUp_imgCalendarChangeRight"));
		return element;
	}
	
	/**
	 * Calendar next month btn.
	 *
	 * @return the string
	 */
	public static String calendarNextMonth_btn(){
		id = "Main_calPopUp_imgCalendarChangeRight";
		return id;
	}
	
	/**
	 * Calendar close btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Calendar Close
	public static WebElement calendarClose_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_calPopUp_imgClose"));
		return element;
	}
	
	/**
	 * Calendar close btn.
	 *
	 * @return the string
	 */
	public static String calendarClose_btn(){
		id = "Main_calPopUp_imgClose";
		return id;
	}
	
	/**
	 * Award note txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Award note textbox
	public static WebElement awardNote_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_txtNoteAward"));
		return element;
	}
	
	/**
	 * Award note txtbx.
	 *
	 * @return the string
	 */
	public static String awardNote_txtbx(){
		id = "Main_txtNoteAward";
		return id;
	}
	
	/**
	 * Decline note txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Decline note textbox
	public static WebElement declineNote_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_txtNoteDeclined"));
		return element;
	}
	
	/**
	 * Decline note txtbx.
	 *
	 * @return the string
	 */
	public static String declineNote_txtbx(){
		id = "Main_txtNoteDeclined";
		return id;
	}

	/**
	 * Payment method dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// paymentMethod_dropdown
	public static WebElement paymentMethod_dropdown(WebDriver driver){
		element = driver.findElement(By.id("ddlPaymentMethod"));
		return element;
	}
	
	/**
	 * Payment method dropdown.
	 *
	 * @return the string
	 */
	public static String paymentMethod_dropdown(){
		id = "ddlPaymentMethod";
		return id;
	}
	
}