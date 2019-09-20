package pageObjects.VMP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the VMP Forgot Password page
 */
public class VMPForgotPassword {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	/** The css selector. */
	private static String cssSelector = null;

	
	/**
	 * Email txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Email textbox
	public static WebElement email_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("ctl00_ctl00_Dialogs_Dialogs_txtEmailAddress"));
		return element;
	}	
	
	/**
	 * Email txtbx.
	 *
	 * @return the string
	 */
	public static String email_txtbx(){	
		id = "ctl00_ctl00_Dialogs_Dialogs_txtEmailAddress";
		return id;
	}
	
	/**
	 * Send account info btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Send Account Info button
	public static WebElement sendAccountInfo_btn(WebDriver driver){	
		element = driver.findElement(By.cssSelector("input[type='button'][onclick='SendAccountInfo();']"));
		return element;
	}	
	
	/**
	 * Send account info btn.
	 *
	 * @return the string
	 */
	public static String sendAccountInfo_btn(){	
		cssSelector = "input[type='button'][onclick='SendAccountInfo();']";
		return cssSelector;
	}
	
	/**
	 * Send account info txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Send Account Info text
	public static WebElement sendAccountInfo_txt(WebDriver driver){	
		element = driver.findElement(By.id("divSendAccountInfo"));
		return element;
	}	
	
	/**
	 * Send account info txt.
	 *
	 * @return the string
	 */
	public static String sendAccountInfo_txt(){	
		id = "divSendAccountInfo";
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
		element = driver.findElement(By.cssSelector("img[src='/Images/DialogCloseButton.png'][onclick='HideDialogs();']"));
		return element;
	}	
	
	/**
	 * Close btn.
	 *
	 * @return the string
	 */
	public static String close_btn(){	
		cssSelector = "img[src='/Images/DialogCloseButton.png'][onclick='HideDialogs();']";
		return cssSelector;
	}
		
}
