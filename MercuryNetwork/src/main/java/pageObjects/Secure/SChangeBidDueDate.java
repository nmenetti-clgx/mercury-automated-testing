package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure Change Bid Due Date page
 */
public class SChangeBidDueDate {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;

	
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
	 * Cancel btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Cancel button
	public static WebElement cancel_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_ctl00"));
		return element;
	}
	
	/**
	 * Cancel btn.
	 *
	 * @return the string
	 */
	public static String cancel_btn(){
		id = "Main_ctl00";
		return id;
	}
	
	/**
	 * Sets the date btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Set date button
	public static WebElement setDate_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_btnSetDate"));
		return element;
	}
	
	/**
	 * Sets the date btn.
	 *
	 * @return the string
	 */
	public static String setDate_btn(){
		id = "Main_btnSetDate";
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
		element = driver.findElement(By.id("imgCalendar"));
		return element;
	}
	
	/**
	 * Calendar btn.
	 *
	 * @return the string
	 */
	public static String calendar_btn(){
		id = "imgCalendar";
		return id;
	}
	
	/**
	 * Bid due date txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Bid due date textbox
	public static WebElement bidDueDate_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_txtDueExpireDate"));
		return element;
	}
	
	/**
	 * Bid due date txtbx.
	 *
	 * @return the string
	 */
	public static String bidDueDate_txtbx(){
		id = "Main_txtDueExpireDate";
		return id;
	}
	
	/**
	 * Bid due time hour txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Bid due time hour textbox
	public static WebElement bidDueTimeHour_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_txtDueExpireHour"));
		return element;
	}
	
	/**
	 * Bid due time hour txtbx.
	 *
	 * @return the string
	 */
	public static String bidDueTimeHour_txtbx(){
		id = "Main_txtDueExpireHour";
		return id;
	}
	
	/**
	 * Bid due time minute txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Bid due time minute textbox
	public static WebElement bidDueTimeMinute_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_txtDueExpireMinute"));
		return element;
	}
	
	/**
	 * Bid due time minute txtbx.
	 *
	 * @return the string
	 */
	public static String bidDueTimeMinute_txtbx(){
		id = "Main_txtDueExpireMinute";
		return id;
	}
	
	/**
	 * Bid due time AMP M dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Bid due time AM/PM dropdown
	public static WebElement bidDueTimeAMPM_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Main_ddlAMPM"));
		return element;
	}
	
	/**
	 * Bid due time AMP M dropdown.
	 *
	 * @return the string
	 */
	public static String bidDueTimeAMPM_dropdown(){
		id = "Main_ddlAMPM";
		return id;
	}
	
}
