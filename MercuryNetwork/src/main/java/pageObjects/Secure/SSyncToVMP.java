package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure Sync To VMP page
 */
public class SSyncToVMP {
	
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
		element = driver.findElement(By.id("Dialogs_Dialogs_ctlStatusMessageSyncToVMP_txtMessage"));
		return element;
	}
	
	/**
	 * Message txtbx.
	 *
	 * @return the string
	 */
	public static String message_txtbx(){
		id = "Dialogs_Dialogs_ctlStatusMessageSyncToVMP_txtMessage";
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
		element = driver.findElement(By.id("Dialogs_Dialogs_ddlSyncToVMP"));
		return element;
	}
	
	/**
	 * Status dropdown.
	 *
	 * @return the string
	 */
	public static String status_dropdown(){
		id = "Dialogs_Dialogs_ddlSyncToVMP";
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
		element = driver.findElement(By.id("Dialogs_Dialogs_chkSyncAsActionRequired"));
		return element;
	}
	
	/**
	 * Action required chkbx.
	 *
	 * @return the string
	 */
	public static String actionRequired_chkbx(){
		id = "Dialogs_Dialogs_chkSyncAsActionRequired";
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
		element = driver.findElement(By.id("Dialogs_Dialogs_sbSyncToVMPOK"));
		return element;
	}
	
	/**
	 * Ok btn.
	 *
	 * @return the string
	 */
	public static String ok_btn(){
		id = "Dialogs_Dialogs_sbSyncToVMPOK";
		return id;
	}
	
}
