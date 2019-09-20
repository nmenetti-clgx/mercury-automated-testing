package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure Vendor Profile page
 */
public class SVendorProfile {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;

	
	/**
	 * Vendor profile txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Vendor Profile text
	public static WebElement vendorProfile_txt(WebDriver driver){
		element = driver.findElement(By.id("divDetails"));
		return element;
	}
	
	/**
	 * Vendor profile txt.
	 *
	 * @return the string
	 */
	public static String vendorProfile_txt(){
		id = "divDetails";
		return id;
	}
	
	/**
	 * Vendor profile name txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Vendor Profile Name text
	public static WebElement vendorProfileName_txt(WebDriver driver){
		element = driver.findElement(By.id("AppraiserName"));
		return element;
	}
	
	/**
	 * Vendor profile name txt.
	 *
	 * @return the string
	 */
	public static String vendorProfileName_txt(){
		id = "AppraiserName";
		return id;
	}
	
	/**
	 * Vendor profile company name txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Vendor Profile Company Name text
	public static WebElement vendorProfileCompanyName_txt(WebDriver driver){
		element = driver.findElement(By.id("AppraiserCompanyName"));
		return element;
	}
	
	/**
	 * Vendor profile company name txt.
	 *
	 * @return the string
	 */
	public static String vendorProfileCompanyName_txt(){
		id = "AppraiserCompanyName";
		return id;
	}
	
	/**
	 * Vendor profile address txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Vendor Profile Address text
	public static WebElement vendorProfileAddress_txt(WebDriver driver){
		element = driver.findElement(By.id("dPhysicalAddress"));
		return element;
	}
	
	/**
	 * Vendor profile address txt.
	 *
	 * @return the string
	 */
	public static String vendorProfileAddress_txt(){
		id = "dPhysicalAddress";
		return id;
	}
	
	/**
	 * Vendor profile phone txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Vendor Profile Phone text
	public static WebElement vendorProfilePhone_txt(WebDriver driver){
		element = driver.findElement(By.id("PrimaryPhone"));
		return element;
	}
	
	/**
	 * Vendor profile phone txt.
	 *
	 * @return the string
	 */
	public static String vendorProfilePhone_txt(){
		id = "PrimaryPhone";
		return id;
	}
	
	/**
	 * Vendor profile email txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Vendor Profile Email text
	public static WebElement vendorProfileEmail_txt(WebDriver driver){
		element = driver.findElement(By.id("EmailAddress"));
		return element;
	}
	
	/**
	 * Vendor profile email txt.
	 *
	 * @return the string
	 */
	public static String vendorProfileEmail_txt(){
		id = "EmailAddress";
		return id;
	}
	
	/**
	 * Tabs.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Vendor Profile tabs button
	public static WebElement tabs(WebDriver driver){
		element = driver.findElement(By.id("Tabs"));
		return element;
	}
	
	/**
	 * Tabs.
	 *
	 * @return the string
	 */
	public static String tabs(){
		id = "Tabs";
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
		element = driver.findElement(By.id("btnCancel"));
		return element;
	}
	
	/**
	 * Cancel btn.
	 *
	 * @return the string
	 */
	public static String cancel_btn(){
		id = "btnCancel";
		return id;
	}
	
	/**
	 * Removes the this vendor from your custom fee panel lnk.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Remove this vendor from your custom fee panel link
	public static WebElement removeThisVendorFromYourCustomFeePanel_lnk(WebDriver driver){
		element = driver.findElement(By.id("btnAddRemoveFeePanel"));
		return element;
	}
	
	/**
	 * Removes the this vendor from your custom fee panel lnk.
	 *
	 * @return the string
	 */
	public static String removeThisVendorFromYourCustomFeePanel_lnk(){
		id = "btnAddRemoveFeePanel";
		return id;
	}
	
	/**
	 * Alert txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Alert text
	public static WebElement alert_txt(WebDriver driver){
		element = driver.findElement(By.id("divMessageOK"));
		return element;
	}
	
	/**
	 * Alert txt.
	 *
	 * @return the string
	 */
	public static String alert_txt(){
		id = "divMessageOK";
		return id;
	}
	
	/**
	 * Alert ok btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Alert OK button
	public static WebElement alertOk_btn(WebDriver driver){
		element = driver.findElement(By.id("sbdmButton1"));
		return element;
	}
	
	/**
	 * Alert ok btn.
	 *
	 * @return the string
	 */
	public static String alertOk_btn(){
		id = "sbdmButton1";
		return id;
	}
	
	/**
	 * Adds the this vendor from your custom fee panel lnk.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Add this vendor from your custom fee panel link
	public static WebElement addThisVendorFromYourCustomFeePanel_lnk(WebDriver driver){
		element = driver.findElement(By.id("btnAddRemoveFeePanel"));
		return element;
	}
	
	/**
	 * Adds the this vendor from your custom fee panel lnk.
	 *
	 * @return the string
	 */
	public static String addThisVendorFromYourCustomFeePanel_lnk(){
		id = "btnAddRemoveFeePanel";
		return id;
	}
	
	/**
	 * Ok btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Profile OK button
	public static WebElement ok_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_btnOK"));
		return element;
	}
	
	/**
	 * Ok btn.
	 *
	 * @return the string
	 */
	public static String ok_btn(){
		id = "Main_btnOK";
		return id;
	}
	
	/**
	 * Vendor I D txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Vendor ID txt
	public static WebElement vendorID_txt(WebDriver driver){
		element = driver.findElement(By.id("divData"));
		return element;
	}
	
	/**
	 * Vendor I D txt.
	 *
	 * @return the string
	 */
	public static String vendorID_txt(){
		id = "divData";
		return id;
	}
	
	/**
	 * Close trainee btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// closeTrainee_btn
	public static WebElement closeTrainee_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_btnCloseTrainee"));
		return element;
	}
	
	/**
	 * Close trainee btn.
	 *
	 * @return the string
	 */
	public static String closeTrainee_btn(){
		id = "Dialogs_btnCloseTrainee";
		return id;
	}
	
	/**
	 * Trainee txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// trainee_txt
	public static WebElement trainee_txt(WebDriver driver){
		element = driver.findElement(By.id("divTrainees"));
		return element;
	}
	
	/**
	 * Trainee txt.
	 *
	 * @return the string
	 */
	public static String trainee_txt(){
		id = "divTrainees";
		return id;
	}
	
}
