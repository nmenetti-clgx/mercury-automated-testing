package pageObjects.XSite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the XSite Charge Card page
 */
public class XChargeCard {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;

	
	/**
	 * First name txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// First Name textbox
	public static WebElement firstName_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_txtFirstName"));
		return element;
	}
	
	/**
	 * First name txtbx.
	 *
	 * @return the string
	 */
	public static String firstName_txtbx(){
		id = "Main_txtFirstName";
		return id;
	}
	
	/**
	 * Last name txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Last Name textbox
	public static WebElement lastName_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_txtLastName"));
		return element;
	}
	
	/**
	 * Last name txtbx.
	 *
	 * @return the string
	 */
	public static String lastName_txtbx(){
		id = "Main_txtLastName";
		return id;
	}
	
	/**
	 * Zip code txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Zip Code textbox
	public static WebElement zipCode_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_txtZip"));
		return element;
	}
	
	/**
	 * Zip code txtbx.
	 *
	 * @return the string
	 */
	public static String zipCode_txtbx(){
		id = "Main_txtZip";
		return id;
	}
	
	/**
	 * Credit card number txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Credit card number textbox
	public static WebElement creditCardNumber_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_txtCardNumber"));
		return element;
	}
	
	/**
	 * Credit card number txtbx.
	 *
	 * @return the string
	 */
	public static String creditCardNumber_txtbx(){
		id = "Main_txtCardNumber";
		return id;
	}
	
	/**
	 * Exp month dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Exp month dropdown
	public static WebElement expMonth_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Main_ddlExpMonth"));
		return element;
	}
	
	/**
	 * Exp month dropdown.
	 *
	 * @return the string
	 */
	public static String expMonth_dropdown(){
		id = "Main_ddlExpMonth";
		return id;
	}
	
	/**
	 * Exp year dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Exp year dropdown
	public static WebElement expYear_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Main_ddlExpYear"));
		return element;
	}
	
	/**
	 * Exp year dropdown.
	 *
	 * @return the string
	 */
	public static String expYear_dropdown(){
		id = "Main_ddlExpYear";
		return id;
	}
	
	/**
	 * Amount txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Amount textbox
	public static WebElement amount_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_txtAmount"));
		return element;
	}
	
	/**
	 * Amount txtbx.
	 *
	 * @return the string
	 */
	public static String amount_txtbx(){
		id = "Main_txtAmount";
		return id;
	}
	
	/**
	 * Email address txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Email address textbox
	public static WebElement emailAddress_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_txtEmail"));
		return element;
	}
	
	/**
	 * Email address txtbx.
	 *
	 * @return the string
	 */
	public static String emailAddress_txtbx(){
		id = "Main_txtEmail";
		return id;
	}
	
	/**
	 * Email invoice chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Email invoice checkbox
	public static WebElement emailInvoice_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_chkEmailInvoice"));
		return element;
	}
	
	/**
	 * Email invoice chkbx.
	 *
	 * @return the string
	 */
	public static String emailInvoice_chkbx(){
		id = "Main_chkEmailInvoice";
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
	 * Charge card btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Charge card button
	public static WebElement chargeCard_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_btnSave"));
		return element;
	}
	
	/**
	 * Charge card btn.
	 *
	 * @return the string
	 */
	public static String chargeCard_btn(){
		id = "Main_btnSave";
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
		element = driver.findElement(By.id("btnSummaryClose"));
		return element;
	}
	
	/**
	 * Close btn.
	 *
	 * @return the string
	 */
	public static String close_btn(){
		id = "btnSummaryClose";
		return id;
	}
	
	/**
	 * Payment summary txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Payment Summary text
	public static WebElement paymentSummary_txt(WebDriver driver){
		element = driver.findElement(By.id("Form1"));
		return element;
	}
	
	/**
	 * Payment summary txt.
	 *
	 * @return the string
	 */
	public static String paymentSummary_txt(){
		id = "Form1";
		return id;
	}
	
}
