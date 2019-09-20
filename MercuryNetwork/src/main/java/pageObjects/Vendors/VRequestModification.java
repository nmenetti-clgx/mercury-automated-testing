package pageObjects.Vendors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Vendors Request Modification page
 */
public class VRequestModification {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	/** The css selector. */
	private static String cssSelector = null;

	
	/**
	 * Product dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Product dropdown
	public static WebElement product_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ddlProducts"));
		return element;
	}
	
	/**
	 * Product dropdown.
	 *
	 * @return the string
	 */
	public static String product_dropdown(){
		id = "Dialogs_Dialogs_ddlProducts";
		return id;
	}
	
	/**
	 * Due datetextbox.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Due Date textbox
	public static WebElement dueDatetextbox(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_txtPropsedDueDate"));
		return element;
	}
	
	/**
	 * Due datetextbox.
	 *
	 * @return the string
	 */
	public static String dueDatetextbox(){
		id = "Dialogs_Dialogs_txtPropsedDueDate";
		return id;
	}
	
	/**
	 * Due date calender btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Due Date Calendar button
	public static WebElement dueDateCalender_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='Images/calendar.gif']"));
		return element;
	}
	
	/**
	 * Due date calender btn.
	 *
	 * @return the string
	 */
	public static String dueDateCalender_btn(){
		cssSelector = "img[src='Images/calendar.gif']";
		return id;
	}
	
	/**
	 * Fee txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Fee textbox
	public static WebElement fee_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_txtProposedPrice"));
		return element;
	}
	
	/**
	 * Fee txtbx.
	 *
	 * @return the string
	 */
	public static String fee_txtbx(){
		id = "Dialogs_Dialogs_txtProposedPrice";
		return id;
	}
	
	/**
	 * Payment method dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Payment Method dropdown
	public static WebElement paymentMethod_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ddlPaymentMethods"));
		return element;
	}
	
	/**
	 * Payment method dropdown.
	 *
	 * @return the string
	 */
	public static String paymentMethod_dropdown(){
		id = "Dialogs_Dialogs_ddlPaymentMethods";
		return id;
	}
	
	/**
	 * Notes txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Notes textbox
	public static WebElement notes_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ctlRequestModMessage_txtMessage"));
		return element;
	}
	
	/**
	 * Notes txtbx.
	 *
	 * @return the string
	 */
	public static String notes_txtbx(){
		id = "Dialogs_Dialogs_ctlRequestModMessage_txtMessage";
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
		element = driver.findElement(By.cssSelector("input[type='button'][value='OK'][class='Button'][onclick='SetStatusRequestMod();']"));
		return element;
	}
	
	/**
	 * Ok btn.
	 *
	 * @return the string
	 */
	public static String ok_btn(){
		cssSelector = "input[type='button'][value='OK'][class='Button'][onclick='SetStatusRequestMod();']";
		return cssSelector;
	}
	
	/**
	 * Cancel btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Cancel button
	public static WebElement cancel_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("input[type='button'][value='Cancel'][class='Button'][onclick='HideDialogs();']"));
		return element;
	}
	
	/**
	 * Cancel btn.
	 *
	 * @return the string
	 */
	public static String cancel_btn(){
		cssSelector = "input[type='button'][value='Cancel'][class='Button'][onclick='HideDialogs();']";
		return cssSelector;
	}
	
} // end VOrderDetails class
