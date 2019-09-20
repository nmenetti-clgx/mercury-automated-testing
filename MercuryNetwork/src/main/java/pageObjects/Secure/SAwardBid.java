package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure Award Bid page
 */
public class SAwardBid {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;

	
	/**
	 * Cancel btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Cancel button
	public static WebElement cancel_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_btnCancel"));
		return element;
	}
	
	/**
	 * Cancel btn.
	 *
	 * @return the string
	 */
	public static String cancel_btn(){
		id = "Main_btnCancel";
		return id;
	}
	
	/**
	 * Award btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Award button
	public static WebElement award_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_btnAward"));
		return element;
	}
	
	/**
	 * Award btn.
	 *
	 * @return the string
	 */
	public static String award_btn(){
		id = "Main_btnAward";
		return id;
	}
	
	/**
	 * Award note txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Award note
	public static WebElement awardNote_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_txtNoteAward"));
		return element;
	}
	
	/**
	 * Award note txtbx.
	 *
	 * @return the string
	 */
	public static String awardNote_txtbx(){
		id = "Main_txtNoteAward";
		return id;
	}
	
	/**
	 * Decline note txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Decline note
	public static WebElement declineNote_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_txtNoteDeclined"));
		return element;
	}
	
	/**
	 * Decline note txtbx.
	 *
	 * @return the string
	 */
	public static String declineNote_txtbx(){
		id = "Main_txtNoteDeclined";
		return id;
	}
	
	/**
	 * Payment method dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Payment method dropdown
	public static WebElement paymentMethod_dropdown(WebDriver driver){
		element = driver.findElement(By.id("ddlPaymentMethod"));
		return element;
	}
	
	/**
	 * Payment method dropdown.
	 *
	 * @return the string
	 */
	public static String paymentMethod_dropdown(){
		id = "ddlPaymentMethod";
		return id;
	}
	
	/**
	 * Order fee txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Order Fee text
	public static WebElement orderFee_txt(WebDriver driver){
		element = driver.findElement(By.id("spnOrderFee"));
		return element;
	}
	
	/**
	 * Order fee txt.
	 *
	 * @return the string
	 */
	public static String orderFee_txt(){
		id = "spnOrderFee";
		return id;
	}
	
	/**
	 * Decline txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Decline text
	public static WebElement decline_txt(WebDriver driver){
		element = driver.findElement(By.id("tblGridDeclined_scroll"));
		return element;
	}
	
	/**
	 * Decline txt.
	 *
	 * @return the string
	 */
	public static String decline_txt(){
		id = "tblGridDeclined_scroll";
		return id;
	}
	
	/**
	 * Vendor grid txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Vendor grid text
	public static WebElement vendorGrid_txt(WebDriver driver){
		element = driver.findElement(By.id("tblGridAward"));
		return element;
	}
	
	/**
	 * Vendor grid txt.
	 *
	 * @return the string
	 */
	public static String vendorGrid_txt(){
		id = "tblGridAward";
		return id;
	}
	
}
