package pageObjects.XSite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the XSite Sync to Mercury page
 */
public class XSyncToMercury {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;

	
	/**
	 * Message txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Notes textbox
	public static WebElement message_txtbx(WebDriver driver){
		element = driver.findElement(By.id("PB_txtSyncToMercury_Notes"));
		return element;
	}
	
	/**
	 * Message txtbx.
	 *
	 * @return the string
	 */
	public static String message_txtbx(){
		id = "PB_txtSyncToMercury_Notes";
		return id;
	}
	
	/**
	 * Status dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Status dropdown
	public static WebElement status_dropdown(WebDriver driver){
		element = driver.findElement(By.id("PB_ddlSyncToMercury_Statuses"));
		return element;
	}
	
	/**
	 * Status dropdown.
	 *
	 * @return the string
	 */
	public static String status_dropdown(){
		id = "PB_ddlSyncToMercury_Statuses";
		return id;
	}
	
	/**
	 * Action required chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Action required checkbox
	public static WebElement actionRequired_chkbx(WebDriver driver){
		element = driver.findElement(By.id("PB_chkSyncAsActionRequired"));
		return element;
	}
	
	/**
	 * Action required chkbx.
	 *
	 * @return the string
	 */
	public static String actionRequired_chkbx(){
		id = "PB_chkSyncAsActionRequired";
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
		element = driver.findElement(By.id("PB_btnSave"));
		return element;
	}
	
	/**
	 * Send btn.
	 *
	 * @return the string
	 */
	public static String send_btn(){
		id = "PB_btnSave";
		return id;
	}
	
}
