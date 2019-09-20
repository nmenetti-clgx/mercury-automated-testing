package pageObjects.XSite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the XSite Send Message page
 */
public class XSendMessage {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	/** The name. */
	private static String name = null;

	
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
	 * Status dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Status dropdown
	public static WebElement status_dropdown(WebDriver driver){
		element = driver.findElement(By.name("PB$ddlStatus"));
		return element;
	}
	
	/**
	 * Status dropdown.
	 *
	 * @return the string
	 */
	public static String status_dropdown(){
		name = "PB$ddlStatus";
		return name;
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
