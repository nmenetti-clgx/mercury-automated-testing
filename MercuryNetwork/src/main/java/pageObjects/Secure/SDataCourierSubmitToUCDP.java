package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure Data Courier Submit To UCDP page
 */
public class SDataCourierSubmitToUCDP {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	/** The css selector. */
	private static String cssSelector = null;

	
	/**
	 * Select GS E dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Select GSE dropdown
	public static WebElement selectGSE_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Main_ddlUCDPGSEs"));
		return element;
	}
	
	/**
	 * Select GS E dropdown.
	 *
	 * @return the string
	 */
	public static String selectGSE_dropdown(){
		id = "Main_ddlUCDPGSEs";
		return id;
	}
	
	/**
	 * Business unit dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Business Unit dropdown
	public static WebElement businessUnit_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Main_ddlUCDPBusinessUnits"));
		return element;
	}
	
	/**
	 * Business unit dropdown.
	 *
	 * @return the string
	 */
	public static String businessUnit_dropdown(){
		id = "Main_ddlUCDPBusinessUnits";
		return id;
	}
	
	/**
	 * Loan number txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Loan number textbox
	public static WebElement loanNumber_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_txtUCDPLoanNumber"));
		return element;
	}
	
	/**
	 * Loan number txtbx.
	 *
	 * @return the string
	 */
	public static String loanNumber_txtbx(){
		id = "Main_txtUCDPLoanNumber";
		return id;
	}
	
	/**
	 * Internal notes txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Internal notes textbox
	public static WebElement internalNotes_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_txtUCDPNotes"));
		return element;
	}
	
	/**
	 * Internal notes txtbx.
	 *
	 * @return the string
	 */
	public static String internalNotes_txtbx(){
		id = "Main_txtUCDPNotes";
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
	 * Send btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Send button
	public static WebElement send_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_btnSend"));
		return element;
	}
	
	/**
	 * Send btn.
	 *
	 * @return the string
	 */
	public static String send_btn(){
		id = "Main_btnSend";
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
		element = driver.findElement(By.id("divMessageOKText"));
		return element;
	}
	
	/**
	 * Message txt.
	 *
	 * @return the string
	 */
	public static String message_txt(){
		id = "divMessageOKText";
		return id;
	}
	
	/**
	 * No btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// No button
	public static WebElement no_btn(WebDriver driver){
		element = driver.findElement(By.id("sbdmButton2"));
		return element;
	}
	
	/**
	 * No btn.
	 *
	 * @return the string
	 */
	public static String no_btn(){
		id = "sbdmButton2";
		return id;
	}
	
	/**
	 * Yes btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Yes button
	public static WebElement yes_btn(WebDriver driver){
		element = driver.findElement(By.id("sbdmButton1"));
		return element;
	}
	
	/**
	 * Yes btn.
	 *
	 * @return the string
	 */
	public static String yes_btn(){
		id = "sbdmButton1";
		return id;
	}
	
	/**
	 * Alert txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Alert text
	public static WebElement alert_txt(WebDriver driver){
		element = driver.findElement(By.id("AlertDialogText"));
		return element;
	}
	
	/**
	 * Alert txt.
	 *
	 * @return the string
	 */
	public static String alert_txt(){
		id = "AlertDialogText";
		return id;
	}
	
	/**
	 * Ok btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// OK Alert button
	public static WebElement ok_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("input[onclick='javascript:HideAlert();']"));
		return element;
	}
	
	/**
	 * Ok btn.
	 *
	 * @return the string
	 */
	public static String ok_btn(){
		cssSelector = "input[onclick='javascript:HideAlert();']";
		return cssSelector;
	}
	
}
