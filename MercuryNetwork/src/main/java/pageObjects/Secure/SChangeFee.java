package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure Change Fee page
 */
public class SChangeFee {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;

	
	/**
	 * Sets the fee btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Set Fee button
	public static WebElement setFee_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ctl14"));
		return element;
	}
	
	/**
	 * Sets the fee btn.
	 *
	 * @return the string
	 */
	public static String setFee_btn(){
		id = "Dialogs_Dialogs_ctl14";
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
		element = driver.findElement(By.id("Dialogs_Dialogs_ctl13"));
		return element;
	}
	
	/**
	 * Cancel btn.
	 *
	 * @return the string
	 */
	public static String cancel_btn(){
		id = "Dialogs_Dialogs_ctl13";
		return id;
	}
	
	/**
	 * New fee txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// New Fee textbox
	public static WebElement newFee_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_txtChangeFee"));
		return element;
	}
	
	/**
	 * New fee txtbx.
	 *
	 * @return the string
	 */
	public static String newFee_txtbx(){
		id = "Dialogs_Dialogs_txtChangeFee";
		return id;
	}
	
	/**
	 * Comments txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Comments textbox
	public static WebElement comments_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ctlChangeFee_txtMessage"));
		return element;
	}
	
	/**
	 * Comments txtbx.
	 *
	 * @return the string
	 */
	public static String comments_txtbx(){
		id = "Dialogs_Dialogs_ctlChangeFee_txtMessage";
		return id;
	}
	
}
