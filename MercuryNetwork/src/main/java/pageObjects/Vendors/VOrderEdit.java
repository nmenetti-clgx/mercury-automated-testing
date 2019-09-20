package pageObjects.Vendors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Vendors Order Edit page
 */
public class VOrderEdit {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	/** The css selector. */
	private static String cssSelector = null;

	
	/**
	 * Address txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Address text
	public static WebElement address_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_txtAddress"));
		return element;
	}
	
	/**
	 * Address txtbx.
	 *
	 * @return the string
	 */
	public static String address_txtbx(){
		id = "Main_Main_txtAddress";
		return id;
	}
	
	/**
	 * Assigned to supervisor dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// assigned to supervisor dropdown
	public static WebElement assignedToSupervisor_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_ddlEmployee"));
		return element;
	}
	
	/**
	 * Assigned to supervisor dropdown.
	 *
	 * @return the string
	 */
	public static String assignedToSupervisor_dropdown(){
		id = "Main_Main_ddlEmployee";
		return id;
	}
	
	/**
	 * Trainee dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// trainee dropdown
	public static WebElement trainee_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_ddlTrainee"));
		return element;
	}
	
	/**
	 * Trainee dropdown.
	 *
	 * @return the string
	 */
	public static String trainee_dropdown(){
		id = "Main_Main_ddlTrainee";
		return id;
	}
	
	/**
	 * Save btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// save button
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
	
}
