package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure Send Message page
 */
public class SSendMessage {
	
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
	 * Cancel btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Cancel button
	public static WebElement cancel_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ctl11"));
		return element;
	}
	
	/**
	 * Cancel btn.
	 *
	 * @return the string
	 */
	public static String cancel_btn(){
		id = "Dialogs_Dialogs_ctl11";
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
		element = driver.findElement(By.id("Dialogs_Dialogs_ctl12"));
		return element;
	}
	
	/**
	 * Send btn.
	 *
	 * @return the string
	 */
	public static String send_btn(){
		id = "Dialogs_Dialogs_ctl12";
		return id;
	}
	
	/**
	 * Update message on VMPX site chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Update the message status on the VMP XSite checkbox
	public static WebElement updateMessageOnVMPXSite_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_chkUpdateVMPSendMessage"));
		return element;
	}
	
	/**
	 * Update message on VMPX site chkbx.
	 *
	 * @return the string
	 */
	public static String updateMessageOnVMPXSite_chkbx(){
		id = "Dialogs_Dialogs_chkUpdateVMPSendMessage";
		return id;
	}
	
}
