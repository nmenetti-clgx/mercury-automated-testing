package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure Preferences page
 */
public class SPreferences {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The css selector. */
	private static String cssSelector = null;
	
	/** The id. */
	private static String id = null;

	
	/**
	 * Vendor selection settings btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Vendor Selection Settings
	public static WebElement vendorSelectionSettings_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#tblPreferencesSubMenu > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > b:nth-child(1)"));
		return element;
	}
	
	/**
	 * Vendor selection settings btn.
	 *
	 * @return the string
	 */
	public static String vendorSelectionSettings_btn(){
		cssSelector = "#tblPreferencesSubMenu > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > b:nth-child(1)";
		return cssSelector;
	}
	
	/**
	 * Product requirements btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Product Requirements
	public static WebElement productRequirements_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#tblPreferencesSubMenu > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2)"));
		return element;
	}
	
	/**
	 * Product requirements btn.
	 *
	 * @return the string
	 */
	public static String productRequirements_btn(){
		cssSelector = "#tblPreferencesSubMenu > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2)";
		return cssSelector;
	}
	
	/**
	 * Connection settings btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Connection Settings
	public static WebElement connectionSettings_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#tblPreferencesSubMenu > tbody:nth-child(1) > tr:nth-child(3) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2)"));
		return element;
	}
	
	/**
	 * Connection settings btn.
	 *
	 * @return the string
	 */
	public static String connectionSettings_btn(){
		cssSelector = "#tblPreferencesSubMenu > tbody:nth-child(1) > tr:nth-child(3) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2)";
		return cssSelector;
	}
	
	/**
	 * Appraisal quality management settings btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Appraisal Quality Management Settings
	public static WebElement appraisalQualityManagementSettings_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#tblPreferencesSubMenu > tbody:nth-child(1) > tr:nth-child(4) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2)"));
		return element;
	}
	
	/**
	 * Appraisal quality management settings btn.
	 *
	 * @return the string
	 */
	public static String appraisalQualityManagementSettings_btn(){
		cssSelector = "#tblPreferencesSubMenu > tbody:nth-child(1) > tr:nth-child(4) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2)";
		return cssSelector;
	}
	
	/**
	 * Vmp X sites btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// VMP XSites
	public static WebElement vmpXSites_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#tblPreferencesSubMenu > tbody:nth-child(1) > tr:nth-child(5) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2)"));
		return element;
	}
	
	/**
	 * Vmp X sites btn.
	 *
	 * @return the string
	 */
	public static String vmpXSites_btn(){
		cssSelector = "#tblPreferencesSubMenu > tbody:nth-child(1) > tr:nth-child(5) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2)";
		return cssSelector;
	}
	
	/**
	 * Body txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Body text
	public static WebElement body_txt(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_upMain"));
		return element;
	}
	
	/**
	 * Body txt.
	 *
	 * @return the string
	 */
	public static String body_txt(){
		id = "Main_Main_upMain";
		return id;
	}
	
}
