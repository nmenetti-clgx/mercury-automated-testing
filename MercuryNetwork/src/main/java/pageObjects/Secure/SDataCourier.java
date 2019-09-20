package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure Data Courier page
 */
public class SDataCourier {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The css selector. */
	private static String cssSelector = null;
	
	/** The id. */
	private static String id = null;

	
	/**
	 * View order btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// View Order button
	public static WebElement viewOrder_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='Images/ViewOrder16x16.png']"));
		return element;
	}
	
	/**
	 * View order btn.
	 *
	 * @return the string
	 */
	public static String viewOrder_btn(){
		cssSelector = "img[src='Images/ViewOrder16x16.png']";
		return cssSelector;
	}
	
	/**
	 * New file btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// New File button
	public static WebElement newFile_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='Images/AddIcon.png']"));
		return element;
	}
	
	/**
	 * New file btn.
	 *
	 * @return the string
	 */
	public static String newFile_btn(){
		cssSelector = "img[src='Images/AddIcon.png']";
		return cssSelector;
	}
	
	/**
	 * Upload XM L btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Upload XML button
	public static WebElement uploadXML_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/Images/FileIcons/xmldocumenticon18x16.png']"));
		return element;
	}
	
	/**
	 * Upload XM L btn.
	 *
	 * @return the string
	 */
	public static String uploadXML_btn(){
		cssSelector = "img[src='/Images/FileIcons/xmldocumenticon18x16.png']";
		return cssSelector;
	}
	
	/**
	 * Upload PD F btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Upload PDF button
	public static WebElement uploadPDF_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/Images/FileIcons/PDF.png']"));
		return element;
	}
	
	/**
	 * Upload PD F btn.
	 *
	 * @return the string
	 */
	public static String uploadPDF_btn(){
		cssSelector = "img[src='/Images/FileIcons/PDF.png']";
		return cssSelector;
	}
	
	/**
	 * Restore column widths btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Restore Column Widths button
	public static WebElement restoreColumnWidths_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/Images/RestoreIcon16x16.png']"));
		return element;
	}
	
	/**
	 * Restore column widths btn.
	 *
	 * @return the string
	 */
	public static String restoreColumnWidths_btn(){
		cssSelector = "img[src='/Images/RestoreIcon16x16.png']";
		return cssSelector;
	}
	
	/**
	 * Find txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Find textbox
	public static WebElement find_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_txtFind"));
		return element;
	}
	
	/**
	 * Find txtbx.
	 *
	 * @return the string
	 */
	public static String find_txtbx(){
		id = "Main_Main_txtFind";
		return id;
	}
	
	/**
	 * Upload report file btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Upload Report File button
	public static WebElement uploadReportFile_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_imgUpload"));
		return element;
	}
	
	/**
	 * Upload report file btn.
	 *
	 * @return the string
	 */
	public static String uploadReportFile_btn(){
		id = "Dialogs_Dialogs_imgUpload";
		return id;
	}
	
	/**
	 * Number of files txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Number of files text
	public static WebElement numberOfFiles_txt(WebDriver driver){
		element = driver.findElement(By.id("divFilterCaption"));
		return element;
	}
	
	/**
	 * Number of files txt.
	 *
	 * @return the string
	 */
	public static String numberOfFiles_txt(){
		id = "divFilterCaption";
		return id;
	}
	
}
