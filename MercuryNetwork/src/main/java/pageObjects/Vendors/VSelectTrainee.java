package pageObjects.Vendors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Vendors Select Trainee page
 */
public class VSelectTrainee {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;

	
	/**
	 * Ok btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// ok_btn
	public static WebElement ok_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_btnSetTrainee"));
		return element;
	}
	
	/**
	 * Ok btn.
	 *
	 * @return the string
	 */
	public static String ok_btn(){
		id = "Dialogs_Dialogs_btnSetTrainee";
		return id;
	}
	
	/**
	 * Cancel btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// cancel_btn
	public static WebElement cancel_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ctl00"));
		return element;
	}
	
	/**
	 * Cancel btn.
	 *
	 * @return the string
	 */
	public static String cancel_btn(){
		id = "Dialogs_Dialogs_ctl00";
		return id;
	}
	
	/**
	 * Select trainee txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// selectTrainee_txt
	public static WebElement selectTrainee_txt(WebDriver driver){
		element = driver.findElement(By.id("divEditTrainee"));
		return element;
	}
	
	/**
	 * Select trainee txt.
	 *
	 * @return the string
	 */
	public static String selectTrainee_txt(){
		id = "divEditTrainee";
		return id;
	}
	
	/**
	 * Trainee dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// trainee_dropdown
	public static WebElement trainee_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ddlTrainee"));
		return element;
	}
	
	/**
	 * Trainee dropdown.
	 *
	 * @return the string
	 */
	public static String trainee_dropdown(){
		id = "Dialogs_Dialogs_ddlTrainee";
		return id;
	}
	
}
