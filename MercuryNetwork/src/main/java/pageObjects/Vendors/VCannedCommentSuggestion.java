package pageObjects.Vendors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Vendors Canned Comment Suggestion page
 */
public class VCannedCommentSuggestion {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;

	
	/**
	 * Status dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Status dropdown
	public static WebElement status_dropdown(WebDriver driver){	
		element = driver.findElement(By.id("Main_Main_ddlStatus"));
		return element;
	}	
	
	/**
	 * Status dropdown.
	 *
	 * @return the string
	 */
	public static String status_dropdown(){	
		id = "Main_Main_ddlStatus";
		return id;
	}
	
	/**
	 * Comment suggestion txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Comment Suggestion textbox
	public static WebElement commentSuggestion_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("Main_Main_txtCommentRequest"));
		return element;
	}	
	
	/**
	 * Comment suggestion txtbx.
	 *
	 * @return the string
	 */
	public static String commentSuggestion_txtbx(){	
		id = "Main_Main_txtCommentRequest";
		return id;
	}
	
	/**
	 * Reason for comment txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Reason for Comment textbox
	public static WebElement reasonForComment_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("Main_Main_txtReason"));
		return element;
	}	
	
	/**
	 * Reason for comment txtbx.
	 *
	 * @return the string
	 */
	public static String reasonForComment_txtbx(){	
		id = "Main_Main_txtReason";
		return id;
	}
	
	/**
	 * Phone chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Phone checkbox
	public static WebElement phone_chkbx(WebDriver driver){	
		element = driver.findElement(By.id("Main_Main_chkPhone"));
		return element;
	}	
	
	/**
	 * Phone chkbx.
	 *
	 * @return the string
	 */
	public static String phone_chkbx(){	
		id = "Main_Main_chkPhone";
		return id;
	}
	
	/**
	 * Email chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Email checkbox
	public static WebElement email_chkbx(WebDriver driver){	
		element = driver.findElement(By.id("Main_Main_chkEmail"));
		return element;
	}	
	
	/**
	 * Email chkbx.
	 *
	 * @return the string
	 */
	public static String email_chkbx(){	
		id = "Main_Main_chkEmail";
		return id;
	}
	
	/**
	 * Phone txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Phone textbox
	public static WebElement phone_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("Main_Main_txtPhone"));
		return element;
	}	
	
	/**
	 * Phone txtbx.
	 *
	 * @return the string
	 */
	public static String phone_txtbx(){	
		id = "Main_Main_txtPhone";
		return id;
	}
	
	/**
	 * Email txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Email textbox
	public static WebElement email_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("Main_Main_txtEmail"));
		return element;
	}	
	
	/**
	 * Email txtbx.
	 *
	 * @return the string
	 */
	public static String email_txtbx(){	
		id = "Main_Main_txtEmail";
		return id;
	}
	
	/**
	 * Submit btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Submit button
	public static WebElement submit_btn(WebDriver driver){	
		element = driver.findElement(By.id("Main_Main_btnOK"));
		return element;
	}	
	
	/**
	 * Submit btn.
	 *
	 * @return the string
	 */
	public static String submit_btn(){	
		id = "Main_Main_btnOK";
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
		element = driver.findElement(By.id("Main_Main_btnCancel"));
		return element;
	}	
	
	/**
	 * Cancel btn.
	 *
	 * @return the string
	 */
	public static String cancel_btn(){	
		id = "Main_Main_btnCancel";
		return id;
	}
	
	/**
	 * Text.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// text
	public static WebElement text(WebDriver driver){	
		element = driver.findElement(By.id("Main_Main_lblTitle"));
		return element;
	}	
	
	/**
	 * Text.
	 *
	 * @return the string
	 */
	public static String text(){	
		id = "Main_Main_lblTitle";
		return id;
	}
	
}
