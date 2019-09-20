package pageObjects.Vendors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Vendors Quick List page
 */
public class VQuickList {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	/** The css selector. */
	private static String cssSelector = null;

	
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
	 * Quick list dialog.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Quick List dialog
	public static WebElement quickListDialog(WebDriver driver){
		element = driver.findElement(By.id("bdyDialog"));
		return element;
	}
	
	/**
	 * Quick list dialog.
	 *
	 * @return the string
	 */
	public static String quickListDialog(){
		id = "bdyDialog";
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
	 * Cancel btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Cancel button
	public static WebElement cancel_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_ctl02"));
		return element;
	}
	
	/**
	 * Cancel btn.
	 *
	 * @return the string
	 */
	public static String cancel_btn(){
		id = "Main_ctl02";
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
	 * Checkmark btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// checkmark button
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
	 * Message dialog txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Message Dialog text
	public static WebElement messageDialog_txt(WebDriver driver){
		element = driver.findElement(By.id("divMessageOK"));
		return element;
	}
	
	/**
	 * Message dialog txt.
	 *
	 * @return the string
	 */
	public static String messageDialog_txt(){
		id = "divMessageOK";
		return id;
	}

}
