package pageObjects.VMP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the VMP Cancel Revision Request page
 */
public class VMPCancelRevisionRequest {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	/** The css selector. */
	private static String cssSelector = null;

	
	/**
	 * Notes txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Notes text box
	public static WebElement notes_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Dialogs_Dialogs_txtCancelRevisionRequestNotes"));
		return element;
	}
	
	/**
	 * Notes txtbx.
	 *
	 * @return the string
	 */
	public static String notes_txtbx(){
		id = "ctl00_ctl00_Dialogs_Dialogs_txtCancelRevisionRequestNotes";
		return id;
	}
	
	/**
	 * Ok btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// OK button
	public static WebElement ok_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("input[type='button'][value='OK'][onclick='CancelRevisionRequest_Save();']"));
		return element;
	}
	
	/**
	 * Ok btn.
	 *
	 * @return the string
	 */
	public static String ok_btn(){
		cssSelector = "input[type='button'][value='OK'][onclick='CancelRevisionRequest_Save();']";
		return cssSelector;
	}
	
}
