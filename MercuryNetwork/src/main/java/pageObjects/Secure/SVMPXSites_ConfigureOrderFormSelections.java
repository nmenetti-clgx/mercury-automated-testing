package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure VMP XSites Configure Order Form Selections page
 */
public class SVMPXSites_ConfigureOrderFormSelections {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;

	
	/**
	 * *******************************************************
	 * 					SHOW
	 * *******************************************************.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Show row 1
	public static WebElement configureStatusMapping_lnk(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_navLinkStatusMapping"));
		return element;
	}
	
	/**
	 * Configure status mapping lnk.
	 *
	 * @return the string
	 */
	public static String configureStatusMapping_lnk(){
		id = "Main_Main_navLinkStatusMapping";
		return id;
	}
	
} // end class
