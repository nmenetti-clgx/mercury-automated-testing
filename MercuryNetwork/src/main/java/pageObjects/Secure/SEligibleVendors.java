package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure Eligible Vendors page
 */
public class SEligibleVendors {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	/** The css selector. */
	private static String cssSelector = null;

	
	/**
	 * Close btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Close button
	public static WebElement close_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_sbEligibleVendorsClose"));
		return element;
	}
	
	/**
	 * Close btn.
	 *
	 * @return the string
	 */
	public static String close_btn(){
		id = "Dialogs_Dialogs_sbEligibleVendorsClose";
		return id;
	}
	
	/**
	 * Dialog txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Dialog text
	public static WebElement dialog_txt(WebDriver driver){
		element = driver.findElement(By.id("divEligibleVendors"));
		return element;
	}
	
	/**
	 * Dialog txt.
	 *
	 * @return the string
	 */
	public static String dialog_txt(){
		id = "divEligibleVendors";
		return id;
	}
	
	/**
	 * Appraiser txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Appraiser text
	public static WebElement appraiser_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector("#tblEligibleVendors > tbody > tr > td:nth-child(2)"));
		return element;
	}
	
	/**
	 * Appraiser txt.
	 *
	 * @return the string
	 */
	public static String appraiser_txt(){
		cssSelector = "#tblEligibleVendors > tbody > tr > td:nth-child(2)";
		return cssSelector;
	}
	
	/**
	 * Eligible vendors list txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Eligible Vendors List text
	public static WebElement eligibleVendorsList_txt(WebDriver driver){
		element = driver.findElement(By.id("tblEligibleVendors"));
		return element;
	}
	
	/**
	 * Eligible vendors list txt.
	 *
	 * @return the string
	 */
	public static String eligibleVendorsList_txt(){
		id = "tblEligibleVendors";
		return id;
	}
	
	/**
	 * Fee panel column txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Fee panel column text
	public static WebElement feePanelColumn_txt(WebDriver driver){
		element = driver.findElement(By.id("tblEligibleVendors_SourceID"));
		return element;
	}
	
	/**
	 * Fee panel column txt.
	 *
	 * @return the string
	 */
	public static String feePanelColumn_txt(){
		id = "tblEligibleVendors_SourceID";
		return id;
	}
	
}
