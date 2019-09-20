package pageObjects.VMP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the VMP Order Details page
 */
public class VMPOrderDetails {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	/** The css selector. */
	private static String cssSelector = null;

	
	/**
	 * Page txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Page text
	public static WebElement page_txt(WebDriver driver){
		element = driver.findElement(By.id("divDetails"));
		return element;
	}
	
	/**
	 * Page txt.
	 *
	 * @return the string
	 */
	public static String page_txt(){
		id = "divDetails";
		return id;
	}
	
	/**
	 * Tracking number txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Tracking Number text
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
	 * Accept decline btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Accept/Decline button
	public static WebElement acceptDecline_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#Main_Main_upMain > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2)"));
		return element;
	}
	
	/**
	 * Accept decline btn.
	 *
	 * @return the string
	 */
	public static String acceptDecline_btn(){
		cssSelector = "#Main_Main_upMain > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2)";
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
	 * Send btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Send button
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
	 * Notes txtbox.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Send Message textbox
	public static WebElement notes_txtbox(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Dialogs_Dialogs_txtSendMessageNotes"));
		return element;
	}
	
	/**
	 * Notes txtbox.
	 *
	 * @return the string
	 */
	public static String notes_txtbox(){
		id = "ctl00_ctl00_Dialogs_Dialogs_txtSendMessageNotes";
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
		element = driver.findElement(By.cssSelector("input[type='button'][value='OK'][onclick='javascript:HideAlert();']"));
		return element;
	}
	
	/**
	 * Ok btn.
	 *
	 * @return the string
	 */
	public static String ok_btn(){
		cssSelector = "input[type='button'][value='OK'][onclick='javascript:HideAlert();']";
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
		element = driver.findElement(By.cssSelector("#divSendMessage > div.MsgBoxContent > div.DialogButtons > input:nth-child(3)"));
		return element;
	}
	
	/**
	 * Cancel send message btn.
	 *
	 * @return the string
	 */
	public static String cancelSendMessage_btn(){
		cssSelector = "#divSendMessage > div.MsgBoxContent > div.DialogButtons > input:nth-child(3)";
		return cssSelector;
	}
	
	/**
	 * Documents txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Documents text
	public static WebElement documents_txt(WebDriver driver){
		element = driver.findElement(By.id("tblODFiles"));
		return element;
	}
	
	/**
	 * Documents txt.
	 *
	 * @return the string
	 */
	public static String documents_txt(){
		id = "tblODFiles";
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
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_upStatusHistory"));
		return element;
	}
	
	/**
	 * History txt.
	 *
	 * @return the string
	 */
	public static String history_txt(){
		id = "ctl00_ctl00_Main_Main_upStatusHistory";
		return id;
	}
	
} // end VOrderDetails class
