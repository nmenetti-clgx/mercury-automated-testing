package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure Direct Fax page
 */
public class SDirectFax {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The css selector. */
	private static String cssSelector = null;
	
	/** The id. */
	private static String id = null;

	
	/**
	 * Fax cover sheet txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// fax cover sheet heading
	public static WebElement faxCoverSheet_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector(".Heading"));
		return element;
	}
	
	/**
	 * Fax cover sheet txt.
	 *
	 * @return the string
	 */
	public static String faxCoverSheet_txt(){
		cssSelector = ".Heading";
		return cssSelector;
	}
	
	/**
	 * Company txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// from company text
	public static WebElement company_txt(WebDriver driver){
		element = driver.findElement(By.id("lblFromCompanyName"));
		return element;
	}
	
	/**
	 * Company txt.
	 *
	 * @return the string
	 */
	public static String company_txt(){
		id = "lblFromCompanyName";
		return id;
	}
	
	/**
	 * Cancel btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Cancel button
	public static WebElement cancel_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#divButtons > a:nth-child(3) > img:nth-child(1)"));
		return element;
	}
	
	/**
	 * Cancel btn.
	 *
	 * @return the string
	 */
	public static String cancel_btn(){
		cssSelector = "#divButtons > a:nth-child(3) > img:nth-child(1)";
		return cssSelector;
	}

}
