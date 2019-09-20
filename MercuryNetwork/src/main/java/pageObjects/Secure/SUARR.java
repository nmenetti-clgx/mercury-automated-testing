package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure UARR page
 */
public class SUARR {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The css selector. */
	private static String cssSelector = null;

	
	/**
	 * Save btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Save button
	public static WebElement save_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/Images/Save16x16.png']"));
		return element;
	}
	
	/**
	 * Save btn.
	 *
	 * @return the string
	 */
	public static String save_btn(){
		cssSelector = "img[src='/Images/Save16x16.png']";
		return cssSelector;
	}
	
	/**
	 * Restore btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Restore button
	public static WebElement restore_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/Images/RestoreIcon16x16.png']"));
		return element;
	}
	
	/**
	 * Restore btn.
	 *
	 * @return the string
	 */
	public static String restore_btn(){
		cssSelector = "img[src='/Images/RestoreIcon16x16.png']";
		return cssSelector;
	}
	
}
