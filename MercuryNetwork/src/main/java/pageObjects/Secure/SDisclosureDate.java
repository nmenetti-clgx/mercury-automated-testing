package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure Disclosure Date page
 */
public class SDisclosureDate {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;

	
	/**
	 * Disclosure date calendar btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Disclosure Date calendar button
	public static WebElement disclosureDateCalendar_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_imgChangeDisclosureDate"));
		return element;
	}
	
	/**
	 * Disclosure date calendar btn.
	 *
	 * @return the string
	 */
	public static String disclosureDateCalendar_btn(){
		id = "Dialogs_Dialogs_imgChangeDisclosureDate";
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
		element = driver.findElement(By.id("Dialogs_Dialogs_sbChangeDisclosureDateOK"));
		return element;
	}
	
	/**
	 * Ok btn.
	 *
	 * @return the string
	 */
	public static String ok_btn(){
		id = "Dialogs_Dialogs_sbChangeDisclosureDateOK";	
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
		element = driver.findElement(By.id("Dialogs_Dialogs_sbChangeDisclosureDateCancel"));
		return element;
	}
	
	/**
	 * Cancel btn.
	 *
	 * @return the string
	 */
	public static String cancel_btn(){
		id = "Dialogs_Dialogs_sbChangeDisclosureDateCancel";
		return id;
	}
	
}
