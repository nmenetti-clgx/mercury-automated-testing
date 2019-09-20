package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure Send Via Sure Receipts page
 */
public class SSendViaSureReceipts {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	/** The css selector. */
	private static String cssSelector = null;

	
	/**
	 * Comments txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Comments textbox
	public static WebElement comments_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_txtComments"));
		return element;
	}
	
	/**
	 * Comments txtbx.
	 *
	 * @return the string
	 */
	public static String comments_txtbx(){
		id = "Main_txtComments";
		return id;
	}
	
	/**
	 * Q L btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// QL button
	public static WebElement QL_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/Images/QuickListImages/QL.png']"));
		return element;
	}
	
	/**
	 * Q L btn.
	 *
	 * @return the string
	 */
	public static String QL_btn(){
		cssSelector = "img[src='/Images/QuickListImages/QL.png']";
		return cssSelector;
	}
	
	/**
	 * Close btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Close button
	public static WebElement close_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_ctl00"));
		return element;
	}
	
	/**
	 * Close btn.
	 *
	 * @return the string
	 */
	public static String close_btn(){
		id = "Main_ctl00";
		return id;
	}
	
	/**
	 * New btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// New button
	public static WebElement new_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_ctl01"));
		return element;
	}
	
	/**
	 * New btn.
	 *
	 * @return the string
	 */
	public static String new_btn(){
		id = "Main_ctl01";
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
		element = driver.findElement(By.id("Main_btnCancel"));
		return element;
	}
	
	/**
	 * Cancel btn.
	 *
	 * @return the string
	 */
	public static String cancel_btn(){
		id = "Main_btnCancel";
		return id;
	}
	
	/**
	 * Description txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Description textbox
	public static WebElement description_txtbx(WebDriver driver){
		element = driver.findElement(By.id("txtDescription"));
		return element;
	}
	
	/**
	 * Description txtbx.
	 *
	 * @return the string
	 */
	public static String description_txtbx(){
		id = "txtDescription";
		return id;
	}
	
	/**
	 * Text txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Text textbox
	public static WebElement text_txtbx(WebDriver driver){
		element = driver.findElement(By.id("txtText"));
		return element;
	}
	
	/**
	 * Text txtbx.
	 *
	 * @return the string
	 */
	public static String text_txtbx(){
		id = "txtText";
		return id;
	}
	
	/**
	 * Save btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Save button
	public static WebElement save_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_ctl04"));
		return element;
	}
	
	/**
	 * Save btn.
	 *
	 * @return the string
	 */
	public static String save_btn(){
		id = "Main_ctl04";
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
		element = driver.findElement(By.cssSelector("img[src='/images/DeleteIcon_std.O.png']"));
		return element;
	}
	
	/**
	 * Delete btn.
	 *
	 * @return the string
	 */
	public static String delete_btn(){
		cssSelector = "img[src='/images/DeleteIcon_std.O.png']";
		return cssSelector;
	}
	
	/**
	 * Edits the btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Edit button
	public static WebElement edit_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/images/EditBlue16.O.png']"));
		return element;
	}
	
	/**
	 * Edits the btn.
	 *
	 * @return the string
	 */
	public static String edit_btn(){
		cssSelector = "img[src='/images/EditBlue16.O.png']";
		return cssSelector;
	}
	
	/**
	 * Yes btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Yes button
	public static WebElement yes_btn(WebDriver driver){
		element = driver.findElement(By.id("sbdmButton1"));
		return element;
	}
	
	/**
	 * Yes btn.
	 *
	 * @return the string
	 */
	public static String yes_btn(){
		id = "sbdmButton1";
		return id;
	}
	
	/**
	 * Delete dialog txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Delete dialog text
	public static WebElement deleteDialog_txt(WebDriver driver){
		element = driver.findElement(By.id("divMessageOKText"));
		return element;
	}
	
	/**
	 * Delete dialog txt.
	 *
	 * @return the string
	 */
	public static String deleteDialog_txt(){
		id = "divMessageOKText";
		return id;
	}
	
	/**
	 * Select btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Select button
	public static WebElement select_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/images/Checkmark-Small-Unchecked.O.png']"));
		return element;
	}
	
	/**
	 * Select btn.
	 *
	 * @return the string
	 */
	public static String select_btn(){
		cssSelector = "img[src='/images/Checkmark-Small-Unchecked.O.png']";
		return cssSelector;
	}
	
	/**
	 * Use btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Use button
	public static WebElement use_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_btnUse"));
		return element;
	}
	
	/**
	 * Use btn.
	 *
	 * @return the string
	 */
	public static String use_btn(){
		id = "Main_btnUse";
		return id;
	}
	
	/**
	 * Message txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Message textbox
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
	 * Send btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Send button
	public static WebElement send_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_btnSend"));
		return element;
	}
	
	/**
	 * Send btn.
	 *
	 * @return the string
	 */
	public static String send_btn(){
		id = "Main_btnSend";
		return id;
	}
	
}
