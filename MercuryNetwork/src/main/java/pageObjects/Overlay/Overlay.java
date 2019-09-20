package pageObjects.Overlay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Overlay divs
 */
public class Overlay {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	/** The cssSelector */
	private static String cssSelector = null;

	
	/**
	 * Overlay.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Div Overlay
	public static WebElement overlay(WebDriver driver){
		element = driver.findElement(By.id("divOverlay"));
		return element;
	}
	
	/**
	 * Overlay.
	 *
	 * @return the string
	 */
	public static String overlay(){
		id = "divOverlay";
		return id;
	}
	
	/**
	 * Overlay disabled.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Div Overlay
	public static WebElement overlayDisabled(WebDriver driver){
		element = driver.findElement(By.id("divOverlayDisabled"));
		return element;
	}
	
	/**
	 * Overlay disabled.
	 *
	 * @return the string
	 */
	public static String overlayDisabled(){
		id = "divOverlayDisabled";
		return id;
	}
	
	/**
	 * Alert dialog.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Alert Dialog
	public static WebElement alertDialog(WebDriver driver){
		element = driver.findElement(By.id("AlertDialog"));
		return element;
	}
	
	/**
	 * Alert dialog.
	 *
	 * @return the string
	 */
	public static String alertDialog(){
		id = "AlertDialog";
		return id;
	}
	
	/**
	 * Ok Alert btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement okAlert_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#AlertDialog > div.MsgBoxContent > div > input[type=\"button\"]"));
		
		return element;
	}
	
	/**
	 * Clock dialog.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Clock Dialog
	public static WebElement clockDialog(WebDriver driver){
		element = driver.findElement(By.id("ClockDialog"));
		return element;
	}
	
	/**
	 * Clock dialog.
	 *
	 * @return the string
	 */
	public static String clockDialog(){
		id = "ClockDialog";
		return id;
	}
	
	/**
	 * Summary dialog.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Summary Dialog
	public static WebElement summaryDialog(WebDriver driver){
		element = driver.findElement(By.id("SummaryDialog"));
		return element;
	}
	
	/**
	 * Summary dialog.
	 *
	 * @return the string
	 */
	public static String summaryDialog(){
		id = "SummaryDialog";
		return id;
	}
	
	/**
	 * Ok Summary btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement okSummary_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#SummaryDialog > div.MsgBoxContent > div > input[type=\"button\"]"));
		return element;
	}
	
	/**
	 * Message busy.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Message Busy
	public static WebElement messageBusy(WebDriver driver){
		element = driver.findElement(By.id("divMessageBusy"));
		return element;
	}
	
	/**
	 * Message busy.
	 *
	 * @return the string
	 */
	public static String messageBusy(){
		id = "divMessageBusy";
		return id;
	}
	
	/**
	 * Message ok.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Message OK
	public static WebElement messageOk(WebDriver driver){
		element = driver.findElement(By.id("divMessageOK"));
		return element;
	}
	
	/**
	 * Message ok.
	 *
	 * @return the string
	 */
	public static String messageOk(){
		id = "divMessageOK";
		return id;
	}
	
	/**
	 * Generic dialog.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Generic Dialog
	public static WebElement genericDialog(WebDriver driver){
		element = driver.findElement(By.id("GenericDialog"));
		return element;
	}
	
	/**
	 * Generic dialog.
	 *
	 * @return the string
	 */
	public static String genericDialog(){
		id = "GenericDialog";
		return id;
	}
	
	/**
	 * The notice overlay.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Div Overlay
	public static WebElement notice(WebDriver driver){
		element = driver.findElement(By.cssSelector("div.notice"));
		return element;
	}
	
	/**
	 * The notice overlay.
	 *
	 * @return the string
	 */
	public static String notice(){
		cssSelector = "div.notice";
		return cssSelector;
	}
	
	/**
	 * Address mismatch dialog.
	 *
	 * @param driver the driver
	 * @return the string
	 */
	public static WebElement addressMismatchDialog(WebDriver driver){
		element = driver.findElement(By.id("divConfirmMismatchAddress"));
		return element;
	}
	
	/**
	 * Invalid address dialog.
	 *
	 * @param driver the driver
	 * @return the string
	 */
	public static WebElement invalidAddressDialog(WebDriver driver){
		element = driver.findElement(By.id("divConfirmInvalidAddress"));
		return element;
	}
	
}
