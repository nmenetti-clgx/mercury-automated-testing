package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure AQM QC Module page
 */
public class SAQMQCModule {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;

	
	/**
	 * Save btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Save button
	public static WebElement save_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_btnSaveS"));
		return element;
	}
	
	/**
	 * Save btn.
	 *
	 * @return the string
	 */
	public static String save_btn(){
		id = "Main_btnSaveS";
		return id;
	}
	
	/**
	 * Calculate btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Calculate button
	public static WebElement calculate_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_btnCalculate"));
		return element;
	}
	
	/**
	 * Calculate btn.
	 *
	 * @return the string
	 */
	public static String calculate_btn(){
		id = "Main_btnCalculate";
		return id;
	}
	
	/**
	 * Table.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Table
	public static WebElement table(WebDriver driver){
		element = driver.findElement(By.id("tblResults"));
		return element;
	}
	
	/**
	 * Table.
	 *
	 * @return the string
	 */
	public static String table(){
		id = "tblResults";
		return id;
	}
	
	/**
	 * Pass btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Pass button
	public static WebElement pass_btn(WebDriver driver){
		element = driver.findElement(By.id("divActionMenu_2"));
		return element;
	}
	
	/**
	 * Pass btn.
	 *
	 * @return the string
	 */
	public static String pass_btn(){
		id = "divActionMenu_2";
		return id;
	}
	
}
