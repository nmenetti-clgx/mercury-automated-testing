package pageObjects.Payments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Provide Payment Info page
 */
public class MakeAPaymentSelect {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The css selector. */
	private static String cssSelector = null;

	
	/**
	 * Order
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Order
	public static WebElement order(WebDriver driver){	
		element = driver.findElement(By.cssSelector("body > app-root > main > section > app-property-select > div:nth-child(2) > app-address > div"));
		return element;
	}	
	
	/**
	 * Order
	 *
	 * @return the string
	 */
	public static String order(){	
		cssSelector = "body > app-root > main > section > app-property-select > div:nth-child(2) > app-address > div";
		return cssSelector;
	}
	
}
