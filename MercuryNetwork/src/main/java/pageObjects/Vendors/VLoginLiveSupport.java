package pageObjects.Vendors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Vendors Chat And Tutorials page
 */
public class VLoginLiveSupport {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	
	/**
	 * Name txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement name_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("Name"));
		return element;
	}
	
	/**
	 * Email txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement email_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("email"));
		return element;
	}
	
	/**
	 * Customer ID or Phone txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement customerIDOrPhone_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("Number"));
		return element;
	}
	
	/**
	 * Question txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement question_txtbx(WebDriver driver){	
		element = driver.findElement(By.cssSelector("textarea[name='description']"));
		return element;
	}
	
	/**
	 * Name txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement name_txt(WebDriver driver){	
		element = driver.findElement(By.id("SnapABug_Name"));
		return element;
	}
	
	/**
	 * Email txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement email_txt(WebDriver driver){	
		element = driver.findElement(By.id("SnapABug_email"));
		return element;
	}
	
	/**
	 * Customer ID or Phone txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement customerIDOrPhone_txt(WebDriver driver){	
		element = driver.findElement(By.id("SnapABug_Number"));
		return element;
	}
	
	/**
	 * Question txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement question_txt(WebDriver driver){	
		element = driver.findElement(By.id("SnapABug_desc"));
		return element;
	}
	
	/**
	 * Chat with us btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement chatWithUs_btn(WebDriver driver){	
		element = driver.findElement(By.id("SnapABug_OCB"));
		return element;
	}
	
	/**
	 * Chat with us btn.
	 *
	 * @return the web element
	 */
	public static String chatWithUs_btn(){	
		id = "SnapABug_OCB";
		return id;
	}
	
	/**
	 * Email us btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement emailUs_btn(WebDriver driver){	
		element = driver.findElement(By.id("SnapABug_SB"));
		return element;
	}
	
	/**
	 * Close btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement close_btn(WebDriver driver){	
		element = driver.findElement(By.cssSelector("div[title='Close']"));
		return element;
	}
	
	/**
	 * Live Support dialog.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement liveSupport_dialog(WebDriver driver){	
		element = driver.findElement(By.id("SnapABug_WP"));
		return element;
	}
	
	/**
	 * Live Chat title text.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement liveChat_dialog(WebDriver driver){	
		element = driver.findElement(By.id("SnapABug_WP"));
		return element;
	}
	
	/**
	 * Live Chat Arrow btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement liveChatArrow_btn(WebDriver driver){	
		element = driver.findElement(By.id("SnapABug_CBMHoverHelper"));
		return element;
	}
	
	/**
	 * Minimize btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement minimize_btn(WebDriver driver){	
		element = driver.findElement(By.id("SnapABug_minBtn"));
		return element;
	}
	
	/**
	 * End chat btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement endChat_btn(WebDriver driver){	
		element = driver.findElement(By.id("SnapABug_closeBtn"));
		return element;
	}
	
}
