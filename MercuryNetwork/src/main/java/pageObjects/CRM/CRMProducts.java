package pageObjects.CRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the CRM Products page
 */
public class CRMProducts {
	
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
	
	/**
	 * Status filter dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Status Filter dropdown
	public static WebElement statusFilter_dropdown(WebDriver driver){
		element = driver.findElement(By.id("ctl00_cphBody_ddlLenderUserStatusFilter"));
		return element;
	}
	
	/**
	 * Status filter dropdown.
	 *
	 * @return the string
	 */
	public static String statusFilter_dropdown(){
		id = "ctl00_cphBody_ddlLenderUserStatusFilter";
		return id;
	}
	
}
