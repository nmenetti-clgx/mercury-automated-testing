package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure VMP XSites Business Management page
 */
public class SVMPXSitesBusinessManagement {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;

	
	/**
	 * Allow clients to create accounts chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Allow clients to create accounts checkbox
	public static WebElement allowClientsToCreateAccounts_chkbx(WebDriver driver){
		element = driver.findElement(By.id("chkAllowClientCreateAccount"));
		return element;
	}
	
	/**
	 * Allow clients to create accounts chkbx.
	 *
	 * @return the string
	 */
	public static String allowClientsToCreateAccounts_chkbx(){
		id = "chkAllowClientCreateAccount";
		return id;
	}
	
	/**
	 * Allow clients to enter fee
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Allow clients to create accounts checkbox
	public static WebElement allowClientsToEnterFee_chkbx(WebDriver driver){
		element = driver.findElement(By.id("chkAllowClientEnterFee"));
		return element;
	}
	
	/**
	 * Allow clients to enter fee
	 *
	 * @return the string
	 */
	public static String allowClientsToEnterFee_chkbx(){
		id = "chkAllowClientEnterFee";
		return id;
	}
	
	/**
	 * Adds the to available products btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Add to available products button
	public static WebElement addToAvailableProducts_btn(WebDriver driver){
		element = driver.findElement(By.id("imgInsert"));
		return element;
	}
	
	/**
	 * Adds the to available products btn.
	 *
	 * @return the string
	 */
	public static String addToAvailableProducts_btn(){
		id = "imgInsert";
		return id;
	}
	
}
