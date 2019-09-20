package pageObjects.Vendors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Vendors Forgot Password page
 */
public class VForgotPassword {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	
	/**
	 * Username txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Username textbox
	public static WebElement username_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("body_uxUserNameTextBox"));
		return element;
	}	
	
	/**
	 * Username txtbx.
	 *
	 * @return the string
	 */
	public static String username_txtbx(){	
		id = "body_uxUserNameTextBox";
		return id;
	}
	
	/**
	 * Continue btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Continue button
	public static WebElement continue_btn(WebDriver driver){	
		element = driver.findElement(By.id("body_uxVerifyUserNameButton"));
		return element;
	}	
	
	/**
	 * Continue btn.
	 *
	 * @return the string
	 */
	public static String continue_btn(){	
		id = "body_uxVerifyUserNameButton";
		return id;
	}
	
	/**
	 * Page txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Page text
	public static WebElement page_txt(WebDriver driver){	
		element = driver.findElement(By.id("divPublicMainContent"));
		return element;
	}	
	
	/**
	 * Page txt.
	 *
	 * @return the string
	 */
	public static String page_txt(){	
		id = "divPublicMainContent";
		return id;
	}
	
	/**
	 * Username forgot password txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Username Forgot Password screen textbox
	public static WebElement usernameForgotPassword_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("Main_Main_txtEmailAddress"));
		return element;
	}	
	
	/**
	 * Username forgot password txtbx.
	 *
	 * @return the string
	 */
	public static String usernameForgotPassword_txtbx(){	
		id = "Main_Main_txtEmailAddress";
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
		element = driver.findElement(By.id("Main_Main_btnCancelResetPassword"));
		return element;
	}	
	
	/**
	 * Cancel btn.
	 *
	 * @return the string
	 */
	public static String cancel_btn(){	
		id = "Main_Main_btnCancelResetPassword";
		return id;
	}
	
	/**
	 * Reset password btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement resetPassword_btn(WebDriver driver){	
		element = driver.findElement(By.id("Main_Main_btnResetPassword"));
		return element;
	}	
	
	/**
	 * Reset password btn.
	 *
	 * @return the string
	 */
	public static String resetPassword_btn(){	
		id = "Main_Main_btnResetPassword";
		return id;
	}
	
	/**
	 * Pod caption text.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement podCaption_txt(WebDriver driver){	
		element = driver.findElement(By.cssSelector(".PodCaption"));
		return element;
	}
	
	/**
	 * Pod header text.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement podHeader_txt(WebDriver driver){	
		element = driver.findElement(By.cssSelector(".PodHeader"));
		return element;
	}
	
	/**
	 * Return to sign in btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement returnToSignIn_btn(WebDriver driver){	
		element = driver.findElement(By.id("Main_Main_btnReturnFromConfirmation"));
		return element;
	}
		
}
