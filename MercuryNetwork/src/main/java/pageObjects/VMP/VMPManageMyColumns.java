package pageObjects.VMP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the VMP Manage My Columns page
 */
public class VMPManageMyColumns {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;

	
	/**
	 * Manage my colulmns txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Manage My Columns text
	public static WebElement manageMyColulmns_txt(WebDriver driver){
		element = driver.findElement(By.id("bdyDialog"));
		return element;
	}
	
	/**
	 * Manage my colulmns txt.
	 *
	 * @return the string
	 */
	public static String manageMyColulmns_txt(){
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
		element = driver.findElement(By.id("ctl00_Main_ctl00"));
		return element;
	}
	
	/**
	 * Close btn.
	 *
	 * @return the string
	 */
	public static String close_btn(){
		id = "ctl00_Main_ctl00";
		return id;
	}
	
	/**
	 * Folder dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Folder dropdown
	public static WebElement folder_dropdown(WebDriver driver){
		element = driver.findElement(By.id("ctl00_Main_ddlFolders"));
		return element;
	}
	
	/**
	 * Folder dropdown.
	 *
	 * @return the string
	 */
	public static String folder_dropdown(){
		id = "ctl00_Main_ddlFolders";
		return id;
	}
	
}
