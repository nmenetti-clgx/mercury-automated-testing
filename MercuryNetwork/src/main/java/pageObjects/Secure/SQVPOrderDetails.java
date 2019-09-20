package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure Send Message page
 */
public class SQVPOrderDetails {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;

	
	/**
	 * History text
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Message textbox
	public static WebElement history_txt(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_upStatusHistory"));
		return element;
	}
	
	/**
	 * History text
	 *
	 * @return the string
	 */
	public static String history_txt(){
		id = "Main_Main_upStatusHistory";
		return id;
	}
	
	/**
	 * Property and Borrower Info text
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Message textbox
	public static WebElement propertyAndBorrowerInfo_txt(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_upData"));
		return element;
	}
	
	/**
	 * Property and Borrower Info text
	 *
	 * @return the string
	 */
	public static String propertyAndBorrowerInfo_txt(){
		id = "Main_Main_upData";
		return id;
	}
	
}
