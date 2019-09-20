package pageObjects.VMP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the VMP Profile page
 */
public class VMPProfile {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	/** The css selector. */
	private static String cssSelector = null;

	
	/**
	 * Username txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Username text box
	public static WebElement username_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtUsername"));
		return element;
	}
	
	/**
	 * Username txtbx.
	 *
	 * @return the string
	 */
	public static String username_txtbx(){
		id = "ctl00_ctl00_Main_Main_txtUsername";
		return id;
	}
	
	/**
	 * Title txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Title text box
	public static WebElement title_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtTitle"));
		return element;
	}
	
	/**
	 * Title txtbx.
	 *
	 * @return the string
	 */
	public static String title_txtbx(){
		id = "ctl00_ctl00_Main_Main_txtTitle";
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
		element = driver.findElement(By.cssSelector("img[src='Images/SaveIcon16x16.png']"));
		return element;
	}
	
	/**
	 * Save btn.
	 *
	 * @return the string
	 */
	public static String save_btn(){
		cssSelector = "img[src='Images/SaveIcon16x16.png']";
		return cssSelector;
	}
	
	/**
	 * Save dialog txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Save dialog text
	public static WebElement saveDialog_txt(WebDriver driver){
		element = driver.findElement(By.id("AlertDialog"));
		return element;
	}
	
	/**
	 * Save dialog txt.
	 *
	 * @return the string
	 */
	public static String saveDialog_txt(){
		id = "AlertDialog";
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
