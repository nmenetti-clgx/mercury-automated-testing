package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure Decline Bid page
 */
public class SDeclineBid {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;

	
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
	 * Decline btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Decline button
	public static WebElement decline_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_btnDecline"));
		return element;
	}
	
	/**
	 * Decline btn.
	 *
	 * @return the string
	 */
	public static String decline_btn(){
		id = "Main_btnDecline";
		return id;
	}
	
	/**
	 * Decline note txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Decline Note textbox
	public static WebElement declineNote_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_txtComments"));
		return element;
	}
	
	/**
	 * Decline note txtbx.
	 *
	 * @return the string
	 */
	public static String declineNote_txtbx(){
		id = "Main_txtComments";
		return id;
	}
	
	/**
	 * Vendor table txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// vendor table text
	public static WebElement vendorTable_txt(WebDriver driver){
		element = driver.findElement(By.id("tblGrid_scroll"));
		return element;
	}
	
	/**
	 * Vendor table txt.
	 *
	 * @return the string
	 */
	public static String vendorTable_txt(){
		id = "tblGrid_scroll";
		return id;
	}
	
}
