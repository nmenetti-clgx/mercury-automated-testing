package pageObjects.XSite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the XSite Status page
 */
public class XStatus {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;

	
	/**
	 * Status dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Status dropdown
	public static WebElement status_dropdown(WebDriver driver){
		element = driver.findElement(By.id("PB_ddlStatus"));
		return element;
	}
	
	/**
	 * Status dropdown.
	 *
	 * @return the string
	 */
	public static String status_dropdown(){
		id = "PB_ddlStatus";
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
		element = driver.findElement(By.id("PB_txtNotes"));
		return element;
	}
	
	/**
	 * Message txtbx.
	 *
	 * @return the string
	 */
	public static String message_txtbx(){
		id = "PB_txtNotes";
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
		element = driver.findElement(By.id("PB_btnSave"));
		return element;
	}
	
	/**
	 * Save btn.
	 *
	 * @return the string
	 */
	public static String save_btn(){
		id = "PB_btnSave";
		return id;
	}
	
}
