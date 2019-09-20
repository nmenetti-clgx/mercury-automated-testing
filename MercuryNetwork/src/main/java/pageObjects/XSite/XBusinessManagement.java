package pageObjects.XSite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the XSite Business Management page
 */
public class XBusinessManagement {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	/** The css selector. */
	private static String cssSelector = null;

	
	/**
	 * Adds the arrow btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Add arrow
	public static WebElement addArrow_btn(WebDriver driver){
		element = driver.findElement(By.id("imgInsert"));
		return element;
	}
	
	/**
	 * Adds the arrow btn.
	 *
	 * @return the string
	 */
	public static String addArrow_btn(){
		id = "imgInsert";
		return id;
	}
	
	/**
	 * Edits the btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Edit icon
	public static WebElement edit_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/graphics/btnEdit.jpg']"));
		return element;
	}
	
	/**
	 * Edits the btn.
	 *
	 * @return the string
	 */
	public static String edit_btn(){
		cssSelector = "img[src='/graphics/btnEdit.jpg']";
		return cssSelector;
	}
	
	/**
	 * Default fee txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Default Fee textbox
	public static WebElement defaultFee_txtbx(WebDriver driver){
		element = driver.findElement(By.id("PB_txtFee"));
		return element;
	}
	
	/**
	 * Default fee txtbx.
	 *
	 * @return the string
	 */
	public static String defaultFee_txtbx(){
		id = "PB_txtFee";
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
		element = driver.findElement(By.id("PB_btnSave"));
		return element;
	}
	
	/**
	 * Ok btn.
	 *
	 * @return the string
	 */
	public static String ok_btn(){
		id = "PB_btnSave";
		return id;
	}
	
	/**
	 * Fees setup btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Fees Setup button
	public static WebElement feesSetup_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#trFeeSetup > td.Data1"));
		return element;
	}
	
	/**
	 * Fees setup btn.
	 *
	 * @return the string
	 */
	public static String feesSetup_btn(){
		cssSelector = "#trFeeSetup > td.Data1";
		return cssSelector;
	}
	
	/**
	 * Billing btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Billing button
	public static WebElement billing_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/graphics/btnBilling.jpg']"));
		return element;
	}
	
	/**
	 * Billing btn.
	 *
	 * @return the string
	 */
	public static String billing_btn(){
		cssSelector = "img[src='/graphics/btnBilling.jpg']";
		return cssSelector;
	}
	
	/**
	 * Charge card btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Charge Card button
	public static WebElement chargeCard_btn(WebDriver driver){
		element = driver.findElement(By.id("lnkChargeCard"));
		return element;
	}
	
	/**
	 * Charge card btn.
	 *
	 * @return the string
	 */
	public static String chargeCard_btn(){
		id = "lnkChargeCard";
		return id;
	}
	
}
