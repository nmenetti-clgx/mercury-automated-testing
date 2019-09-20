package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure Set Order Status page
 */
public class SSetOrderStatus {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	
	/**
	 * Notes txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Notes
	public static WebElement notes_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_txtRevisionRequired"));
		return element;
	}
	
	/**
	 * Notes txtbx.
	 *
	 * @return the string
	 */
	public static String notes_txtbx(){
		id = "Dialogs_Dialogs_txtRevisionRequired";
		return id;
	}
	
	/**
	 * Message txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Message text
	public static WebElement message_txt(WebDriver driver){
		element = driver.findElement(By.id("divSetStatusRevisionRequiredText"));
		return element;
	}
	
	/**
	 * Message txt.
	 *
	 * @return the string
	 */
	public static String message_txt(){
		id = "divSetStatusRevisionRequiredText";
		return id;
	}
	
	/**
	 * Update status on VMPX site chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Update status on VMP XSite checkbox
	public static WebElement updateStatusOnVMPXSite_chkbx(WebDriver driver){
		element = driver.findElement(By.id("divSetStatusRevisionRequired_chk"));
		return element;
	}
	
	/**
	 * Update status on VMPX site chkbx.
	 *
	 * @return the string
	 */
	public static String updateStatusOnVMPXSite_chkbx(){
		id = "divSetStatusRevisionRequired_chk";
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
		element = driver.findElement(By.id("Dialogs_Dialogs_sbRevisionRequiredOK"));
		return element;
	}
	
	/**
	 * Ok btn.
	 *
	 * @return the string
	 */
	public static String ok_btn(){
		id = "Dialogs_Dialogs_sbRevisionRequiredOK";
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
		element = driver.findElement(By.id("Dialogs_Dialogs_sbSetStatusCancel"));
		return element;
	}
	
	/**
	 * Cancel btn.
	 *
	 * @return the string
	 */
	public static String cancel_btn(){
		id = "Dialogs_Dialogs_sbSetStatusCancel";
		return id;
	}
	
	/**
	 * Note place on hold txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Note Place On Hold textbox
	public static WebElement notePlaceOnHold_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ctlStatusMessage_txtMessage"));
		return element;
	}
	
	/**
	 * Note place on hold txtbx.
	 *
	 * @return the string
	 */
	public static String notePlaceOnHold_txtbx(){
		id = "Dialogs_Dialogs_ctlStatusMessage_txtMessage";
		return id;
	}
	
	/**
	 * Update status on VMPX site place on hold chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Update status on VMP XSite Place On Hold checkbox
	public static WebElement updateStatusOnVMPXSitePlaceOnHold_chkbx(WebDriver driver){
		element = driver.findElement(By.id("divSetStatus_chk"));
		return element;
	}
	
	/**
	 * Update status on VMPX site place on hold chkbx.
	 *
	 * @return the string
	 */
	public static String updateStatusOnVMPXSitePlaceOnHold_chkbx(){
		id = "divSetStatus_chk";
		return id;
	}
	
	/**
	 * Ok place on hold btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// OK Place on HOld button
	public static WebElement okPlaceOnHold_btn(WebDriver driver){
			element = driver.findElement(By.id("Dialogs_Dialogs_sbSetStatusOK"));
		return element;
	}
	
	/**
	 * Ok place on hold btn.
	 *
	 * @return the string
	 */
	public static String okPlaceOnHold_btn(){
			id = "Dialogs_Dialogs_sbSetStatusOK";
		return id;
	}
	
	/**
	 * Note resume txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Note Resume textbox
	public static WebElement noteResume_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ctlStatusMessageNewDate_txtMessage"));
		return element;
	}
	
	/**
	 * Note resume txtbx.
	 *
	 * @return the string
	 */
	public static String noteResume_txtbx(){
		id = "Dialogs_Dialogs_ctlStatusMessageNewDate_txtMessage";
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
		element = driver.findElement(By.id("Dialogs_Dialogs_imgCalendar"));
		return element;
	}
	
	/**
	 * Calendar btn.
	 *
	 * @return the string
	 */
	public static String calendar_btn(){
		id = "Dialogs_Dialogs_imgCalendar";
		return id;
	}
	
	/**
	 * Update status on VMPX site resume chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Update status on VMP XSite Resume checkbox
	public static WebElement updateStatusOnVMPXSiteResume_chkbx(WebDriver driver){
		element = driver.findElement(By.id("divSetStatusNewDate_chk"));
		return element;
	}
	
	/**
	 * Update status on VMPX site resume chkbx.
	 *
	 * @return the string
	 */
	public static String updateStatusOnVMPXSiteResume_chkbx(){
		id = "divSetStatusNewDate_chk";
		return id;
	}
	
	/**
	 * Ok resume btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// OK Resume button
	public static WebElement okResume_btn(WebDriver driver){
			element = driver.findElement(By.id("Dialogs_Dialogs_sbNewDateOK"));
		return element;
	}
	
	/**
	 * Ok resume btn.
	 *
	 * @return the string
	 */
	public static String okResume_btn(){
			id = "Dialogs_Dialogs_sbNewDateOK";
		return id;
	}
	
}
