package pageObjects.Payments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Provide Payment Info page
 */
public class MakeAPaymentSearch {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	/** The css selector. */
	private static String cssSelector = null;

	
	/**
	 * Address txtbx
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// address txtbx
	public static WebElement address_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("address"));
		return element;
	}	
	
	/**
	 * Address txtbx
	 *
	 * @return the string
	 */
	public static String address_txtbx(){	
		id = "address";
		return id;
	}
	
	/**
	 * Zip Code txtbx
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// zip code
	public static WebElement zipCode_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("zipcode"));
		return element;
	}	
	
	/**
	 * Zip Code txtbx
	 *
	 * @return the string
	 */
	public static String zipCode_txtbx(){	
		id = "zipcode";
		return id;
	}
	
	/**
	 * Search button
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Search button
	public static WebElement search_btn(WebDriver driver){	
		element = driver.findElement(By.cssSelector("button[class='btn pull-right']"));
		return element;
	}	
	
	/**
	 * Search button
	 *
	 * @return the string
	 */
	public static String search_btn(){	
		cssSelector = "button[class='btn pull-right']";
		return cssSelector;
	}
	
}
