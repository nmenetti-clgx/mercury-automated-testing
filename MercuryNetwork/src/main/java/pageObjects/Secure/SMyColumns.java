package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure My Columns page
 */
public class SMyColumns {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;

	
	/**
	 * Manage my columns dialog txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Manage my columns dialog text
	public static WebElement manageMyColumnsDialog_txt(WebDriver driver){
		element = driver.findElement(By.id("bdyDialog"));
		return element;
	}
	
	/**
	 * Manage my columns dialog txt.
	 *
	 * @return the string
	 */
	public static String manageMyColumnsDialog_txt(){
		id = "bdyDialog";
		return id;
	}
	
	/**
	 * Close btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Close button
	public static WebElement close_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_ctl00"));
		return element;
	}
	
	/**
	 * Close btn.
	 *
	 * @return the string
	 */
	public static String close_btn(){
		id = "Main_ctl00";
		return id;
	}
	
	
	
}
