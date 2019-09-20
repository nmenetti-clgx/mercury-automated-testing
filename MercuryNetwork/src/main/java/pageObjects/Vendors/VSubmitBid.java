package pageObjects.Vendors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Vendors Submit Bid page
 */
public class VSubmitBid {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;

	
	/**
	 * Submit btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Submit button
	public static WebElement submit_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_imgSubmitBidContinue"));
		return element;
	}
	
	/**
	 * Submit btn.
	 *
	 * @return the string
	 */
	public static String submit_btn(){
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
		element = driver.findElement(By.id("Main_sbSubmitBidCancel"));
		return element;
	}
	
	/**
	 * Cancel btn.
	 *
	 * @return the string
	 */
	public static String cancel_btn(){
		id = "Main_sbSubmitBidCancel";
		return id;
	}
	
	/**
	 * Message to the client txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Message to the client textbox
	public static WebElement messageToTheClient_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_txtClientMessage_txtMessage"));
		return element;
	}
	
	/**
	 * Message to the client txtbx.
	 *
	 * @return the string
	 */
	public static String messageToTheClient_txtbx(){
		id = "Main_txtClientMessage_txtMessage";
		return id;
	}
	
	/**
	 * I accept these terms radiobtn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// I accept these terms radio button
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
	 * I am unable to bid radiobtn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// I am unable to bid radio button
	public static WebElement iAmUnableToBid_radiobtn(WebDriver driver){
		element = driver.findElement(By.id("Main_rdNoBid"));
		return element;
	}
	
	/**
	 * I am unable to bid radiobtn.
	 *
	 * @return the string
	 */
	public static String iAmUnableToBid_radiobtn(){
		id = "Main_rdNoBid";
		return id;
	}
	
	/**
	 * I am unable to bid chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// I am unable to bid checkbox
	public static WebElement iAmUnableToBid_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_chkNoBid"));
		return element;
	}
	
	/**
	 * I am unable to bid chkbx.
	 *
	 * @return the string
	 */
	public static String iAmUnableToBid_chkbx(){
		id = "Main_chkNoBid";
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
		element = driver.findElement(By.id("bdyDialog"));
		return element;
	}
	
	/**
	 * Dialog txt.
	 *
	 * @return the string
	 */
	public static String dialog_txt(){
		id = "bdyDialog";
		return id;
	}
	
	/**
	 * Ql btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// QL button
	public static WebElement ql_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_txtClientMessage_hbStatusMessage_btnHover"));
		return element;
	}
	
	/**
	 * Ql btn.
	 *
	 * @return the string
	 */
	public static String ql_btn(){
		id = "Main_txtClientMessage_hbStatusMessage_btnHover";
		return id;
	}
	
	/**
	 * Bid txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Bid text
	public static WebElement bid_txt(WebDriver driver){
		element = driver.findElement(By.id("bid-fee"));
		return element;
	}
	
	/**
	 * Bid txt.
	 *
	 * @return the string
	 */
	public static String bid_txt(){
		id = "bid-fee";
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
		element = driver.findElement(By.id("bid-due-date-fee"));
		return element;
	}
	
	/**
	 * Due date txt.
	 *
	 * @return the string
	 */
	public static String dueDate_txt(){
		id = "bid-bid-due-date";
		return id;
	}
	
	/**
	 * Decline btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Decline button
	public static WebElement decline_btn(WebDriver driver){
		element = driver.findElement(By.id("sbdmButton1"));
		return element;
	}
	
	/**
	 * Decline btn.
	 *
	 * @return the string
	 */
	public static String decline_btn(){
		id = "sbdmButton1";
		return id;
	}
	
	/**
	 * Decline bid dialog txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Decline bid dialog text
	public static WebElement declineBidDialog_txt(WebDriver driver){
		element = driver.findElement(By.id("divMessageOK"));
		return element;
	}
	
	/**
	 * Decline bid dialog txt.
	 *
	 * @return the string
	 */
	public static String declineBidDialog_txt(){
		id = "divMessageOK";
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
	 * Appraisal bid txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Appraisal bid textbox
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
	// Turn time textbox
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
	 * Est due date txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Est Due Date text
	public static WebElement estDueDate_txt(WebDriver driver){
		element = driver.findElement(By.id("bid-estimated-date"));
		return element;
	}
	
	/**
	 * Est due date txt.
	 *
	 * @return the string
	 */
	public static String estDueDate_txt(){
		id = "bid-estimated-date";
		return id;
	}
	
	/**
	 * Est due date container.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Est Due Date Container
	public static WebElement estDueDateContainer(WebDriver driver){
		element = driver.findElement(By.id("bid-estimated-date-container"));
		return element;
	}
	
	/**
	 * Est due date container.
	 *
	 * @return the string
	 */
	public static String estDueDateContainer(){
		id = "bid-estimated-date-container";
		return id;
	}

}
