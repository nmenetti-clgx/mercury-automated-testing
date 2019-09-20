package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure Vendor Assignment page
 */
public class SVendorAssignment {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;

	
	/**
	 * Vendor profile btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Vendor Profile button
	public static WebElement vendorProfile_btn(WebDriver driver){
		element = driver.findElement(By.id("imgAppraiserProfile2"));
		return element;
	}
	
	/**
	 * Vendor profile btn.
	 *
	 * @return the string
	 */
	public static String vendorProfile_btn(){
		id = "imgAppraiserProfile2";
		return id;
	}
	
	/**
	 * Vendor assignment txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Vendor assignment text
	public static WebElement vendorAssignment_txt(WebDriver driver){
		element = driver.findElement(By.id("form1"));
		return element;
	}
	
	/**
	 * Vendor assignment txt.
	 *
	 * @return the string
	 */
	public static String vendorAssignment_txt(){
		id = "form1";
		return id;
	}
	
	/**
	 * Decline btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Decline button
	public static WebElement decline_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_ctl01"));
		return element;
	}
	
	/**
	 * Decline btn.
	 *
	 * @return the string
	 */
	public static String decline_btn(){
		id = "Main_ctl01";
		return id;
	}
	
	/**
	 * Approve btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Approve button
	public static WebElement approve_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_ctl02"));
		return element;
	}
	
	/**
	 * Approve btn.
	 *
	 * @return the string
	 */
	public static String approve_btn(){
		id = "Main_ctl02";
		return id;
	}
	
	/**
	 * Notes required txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Notes required text
	public static WebElement notesRequired_txt(WebDriver driver){
		element = driver.findElement(By.id("divMessageOKText"));
		return element;
	}
	
	/**
	 * Notes required txt.
	 *
	 * @return the string
	 */
	public static String notesRequired_txt(){
		id = "divMessageOKText";
		return id;
	}
	
	/**
	 * Notes required ok btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Notes required OK button
	public static WebElement notesRequiredOk_btn(WebDriver driver){
		element = driver.findElement(By.id("sbdmButton1"));
		return element;
	}
	
	/**
	 * Notes required ok btn.
	 *
	 * @return the string
	 */
	public static String notesRequiredOk_btn(){
		id = "sbdmButton1";
		return id;
	}
	
	/**
	 * Notes txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Notes text box
	public static WebElement notes_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_txtNotes"));
		return element;
	}
	
	/**
	 * Notes txtbx.
	 *
	 * @return the string
	 */
	public static String notes_txtbx(){
		id = "Main_txtNotes";
		return id;
	}

	/**
	 * Name txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Name text
	public static WebElement name_txt(WebDriver driver){
		element = driver.findElement(By.id("divName"));
		return element;
	}
	
	/**
	 * Name txt.
	 *
	 * @return the string
	 */
	public static String name_txt(){
		id = "divName";
		return id;
	}
	
	/**
	 * Company name txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Company text
	public static WebElement companyName_txt(WebDriver driver){
		element = driver.findElement(By.id("divCompany"));
		return element;
	}
	
	/**
	 * Company name txt.
	 *
	 * @return the string
	 */
	public static String companyName_txt(){
		id = "divCompany";
		return id;
	}
	
	/**
	 * Address txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Address text
	public static WebElement address_txt(WebDriver driver){
		element = driver.findElement(By.id("divStreet1"));
		return element;
	}
	
	/**
	 * Address txt.
	 *
	 * @return the string
	 */
	public static String address_txt(){
		id = "divStreet1";
		return id;
	}
	
	/**
	 * City state zip txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// City, State, Zip text
	public static WebElement cityStateZip_txt(WebDriver driver){
		element = driver.findElement(By.id("divCityStreetZip"));
		return element;
	}
	
	/**
	 * City state zip txt.
	 *
	 * @return the string
	 */
	public static String cityStateZip_txt(){
		id = "divCityStreetZip";
		return id;
	}
	
	/**
	 * Phone txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Phone text
	public static WebElement phone_txt(WebDriver driver){
		element = driver.findElement(By.id("divPhone"));
		return element;
	}
	
	/**
	 * Phone txt.
	 *
	 * @return the string
	 */
	public static String phone_txt(){
		id = "divPhone";
		return id;
	}
	
	/**
	 * Email txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Email text
	public static WebElement email_txt(WebDriver driver){
		element = driver.findElement(By.id("divEmail"));
		return element;
	}
	
	/**
	 * Email txt.
	 *
	 * @return the string
	 */
	public static String email_txt(){
		id = "divEmail";
		return id;
	}
	
}
