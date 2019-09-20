package pageObjects.CRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the CRM page
 */
public class CRM {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;

	
	/**
	 * Products btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Products button
	public static WebElement products_btn(WebDriver driver){
		element = driver.findElement(By.id("ui-id-4"));
		return element;
	}
	
	/**
	 * Products btn.
	 *
	 * @return the string
	 */
	public static String products_btn(){
		id = "ui-id-4";
		return id;
	}
	
}
