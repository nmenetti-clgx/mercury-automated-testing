package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure Update Client  page
 */
public class SUpdateClient {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;

	
	/**
	 * Ok btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// OK button
	public static WebElement ok_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_btnSendVMPChangesOK"));
		return element;
	}
	
	/**
	 * Ok btn.
	 *
	 * @return the string
	 */
	public static String ok_btn(){
		id = "Dialogs_Dialogs_btnSendVMPChangesOK";
		return id;
	}
	
	/**
	 * Update 1 btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Update 1 button
	public static WebElement update1_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_chkVMPChangedItems_0"));
		return element;
	}
	
	/**
	 * Update 1 btn.
	 *
	 * @return the string
	 */
	public static String update1_btn(){
		id = "Dialogs_Dialogs_chkVMPChangedItems_0";
		return id;
	}
	
}
