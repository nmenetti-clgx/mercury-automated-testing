package pageObjects.Vendors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Vendors Chat And Tutorials page
 */
public class VChatAndTutorials {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	/** The css selector. */
	private static String cssSelector = null;

	
	/**
	 * Dialog chat and tutorials txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Chat and Tutorials page text
	public static WebElement dialogChatAndTutorials_txt(WebDriver driver){	
		element = driver.findElement(By.id("walkme-main"));
		return element;
	}	
	
	/**
	 * Dialog chat and tutorials txt.
	 *
	 * @return the string
	 */
	public static String dialogChatAndTutorials_txt(){	
		id = "walkme-main";
		return id;
	}
	
	/**
	 * Chat with us btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Chat With Us button
	public static WebElement chatWithUs_btn(WebDriver driver){	
		element = driver.findElement(By.cssSelector("div.walkme-livechat-title"));
		return element;
	}	
	
	/**
	 * Chat with us btn.
	 *
	 * @return the string
	 */
	public static String chatWithUs_btn(){	
		cssSelector = "div.walkme-livechat-title";
		return cssSelector;
	}

}
