package pageObjects.Vendors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Vendors Contact Support page
 */
public class VContactSupport {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;

	
	/**
	 * Send btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Send button
	public static WebElement send_btn(WebDriver driver){	
		element = driver.findElement(By.id("Main_sbBtnSend"));
		return element;
	}	
	
	/**
	 * Send btn.
	 *
	 * @return the string
	 */
	public static String send_btn(){	
		id = "Main_sbBtnSend";
		return id;
	}
	
	/**
	 * Contact support page txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Contact Support page text
	public static WebElement contactSupportPage_txt(WebDriver driver){	
		element = driver.findElement(By.id("Main_upContactSupport"));
		return element;
	}	
	
	/**
	 * Contact support page txt.
	 *
	 * @return the string
	 */
	public static String contactSupportPage_txt(){	
		id = "Main_upContactSupport";
		return id;
	}
	
	/**
	 * Close btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Close button
	public static WebElement close_btn(WebDriver driver){	
		element = driver.findElement(By.id("Main_sbBtnClose"));
		return element;
	}	
	
	/**
	 * Close btn.
	 *
	 * @return the string
	 */
	public static String close_btn(){	
		id = "Main_sbBtnClose";
		return id;
	}

}
