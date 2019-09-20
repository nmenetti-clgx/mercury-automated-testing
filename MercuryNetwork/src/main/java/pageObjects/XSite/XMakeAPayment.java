package pageObjects.XSite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the XSite Charge Card page
 */
public class XMakeAPayment {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	/** The cssSelector. */
	private static String cssSelector = null;

	
	/**
	 * Street address txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// First Name textbox
	public static WebElement streetAddress_txtbx(WebDriver driver){
		element = driver.findElement(By.id("txtAddress"));
		return element;
	}
	
	/**
	 * Street address txtbx.
	 *
	 * @return the string
	 */
	public static String streetAddress_txtbx(){
		id = "txtAddress";
		return id;
	}
	
	/**
	 * Zip code txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// First Name textbox
	public static WebElement zipCode_txtbx(WebDriver driver){
		element = driver.findElement(By.id("txtZip"));
		return element;
	}
	
	/**
	 * Zip code txtbx.
	 *
	 * @return the string
	 */
	public static String zipCode_txtbx(){
		id = "txtZip";
		return id;
	}
	
	/**
	 * Search button
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// First Name textbox
	public static WebElement search_btn(WebDriver driver){
		element = driver.findElement(By.id("btnSearch"));
		return element;
	}
	
	/**
	 * Search button
	 *
	 * @return the string
	 */
	public static String search_btn(){
		id = "btnSearch";
		return id;
	}
	
	/**
	 * Address radio button
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// First Name textbox
	public static WebElement address_radiobtn(WebDriver driver){
		element = driver.findElement(By.cssSelector("input[name='rblOrders'][type='radio']"));
		return element;
	}
	
	/**
	 * Address radio button
	 *
	 * @return the string
	 */
	public static String address_radiobtn(){
		cssSelector = "input[name='rblOrders'][type='radio']";
		return cssSelector;
	}
	
	/**
	 * Submit button
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// First Name textbox
	public static WebElement submit_btn(WebDriver driver){
		element = driver.findElement(By.id("btnChargeCard"));
		return element;
	}
	
	/**
	 * Submit button
	 *
	 * @return the string
	 */
	public static String submit_btn(){
		id = "btnChargeCard";
		return id;
	}
	
	/**
	 * Heading text of the Charge Card page
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// First Name textbox
	public static WebElement heading_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector("#form1 > table > tbody > tr:nth-child(1) > td.old-pod-top > table > tbody > tr > td > div > nobr"));
		return element;
	}
	
	/**
	 * Heading text of the Charge Card page
	 *
	 * @return the string
	 */
	public static String heading_txt(){
		cssSelector = "#form1 > table > tbody > tr:nth-child(1) > td.old-pod-top > table > tbody > tr > td > div > nobr";
		return cssSelector;
	}
	
}
