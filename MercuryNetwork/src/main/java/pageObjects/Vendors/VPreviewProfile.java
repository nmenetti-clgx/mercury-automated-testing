package pageObjects.Vendors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Vendors Preview Profile page
 */
public class VPreviewProfile {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	/** The css selector. */
	private static String cssSelector = null;

	
	/**
	 * Page txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// page_txt					
	public static WebElement page_txt(WebDriver driver){							
		element = driver.findElement(By.id("bdyDialog"));						
		return element;						
	}							
	
	/**
	 * Page txt.
	 *
	 * @return the string
	 */
	public static String page_txt(){							
		id = "bdyDialog";						
		return id;						
	}
	
	/**
	 * Ok btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// ok_btn				
	public static WebElement ok_btn(WebDriver driver){							
		element = driver.findElement(By.cssSelector(".DialogFooter > .DialogButton > input[type='button'][value='OK']"));						
		return element;						
	}							
	
	/**
	 * Ok btn.
	 *
	 * @return the string
	 */
	public static String ok_btn(){							
		cssSelector = ".DialogFooter > .DialogButton > input[type='button'][value='OK']";						
		return cssSelector;						
	}
								
}
