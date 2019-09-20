package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure Reports page
 */
public class SReports {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The css selector. */
	private static String cssSelector = null;
	
	/** The id. */
	private static String id = null;

	
	/**
	 * Completed btn.
	 *
	 * @param driver the  driver
	 * @return the web element
	 */
	// Completed button
	public static WebElement completed_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#tblReportsSubMenu > tbody > tr:nth-child(1) > td"));
		return element;
	}
	
	/**
	 * Completed btn.
	 *
	 * @return the string
	 */
	public static String completed_btn(){
		cssSelector = "#tblReportsSubMenu > tbody > tr:nth-child(1) > td";
		return cssSelector;
	}
	
	/**
	 * In progress btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// In Progress button
	public static WebElement inProgress_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#tblReportsSubMenu > tbody > tr:nth-child(2) > td"));
		return element;
	}
	
	/**
	 * In progress btn.
	 *
	 * @return the string
	 */
	public static String inProgress_btn(){
		cssSelector = "#tblReportsSubMenu > tbody > tr:nth-child(2) > td";
		return cssSelector;
	}
	
	/**
	 * New requests btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// New Requests button
	public static WebElement newRequests_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#tblReportsSubMenu > tbody > tr:nth-child(3) > td"));
		return element;
	}
	
	/**
	 * New requests btn.
	 *
	 * @return the string
	 */
	public static String newRequests_btn(){
		cssSelector = "#tblReportsSubMenu > tbody > tr:nth-child(3) > td";
		return cssSelector;
	}
	
	/**
	 * Fee panel btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Fee Panel button
	public static WebElement feePanel_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#tblReportsSubMenu > tbody > tr:nth-child(4) > td"));
		return element;
	}
	
	/**
	 * Fee panel btn.
	 *
	 * @return the string
	 */
	public static String feePanel_btn(){
		cssSelector = "#tblReportsSubMenu > tbody > tr:nth-child(4) > td";
		return cssSelector;
	}
	
	/**
	 * Work in progress btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Work In Progress button
	public static WebElement workInProgress_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#tblReportsSubMenu > tbody > tr:nth-child(5) > td"));
		return element;
	}
	
	/**
	 * Work in progress btn.
	 *
	 * @return the string
	 */
	public static String workInProgress_btn(){
		cssSelector = "#tblReportsSubMenu > tbody > tr:nth-child(5) > td";
		return cssSelector;
	}
	
	/**
	 * Header txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Header text
	public static WebElement header_txt(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_lblReportDescription"));
		return element;
	}
	
	/**
	 * Header txt.
	 *
	 * @return the string
	 */
	public static String header_txt(){
		id = "Main_Main_lblReportDescription";
		return id;
	}
	
	/**
	 * Prints the btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Print button
	public static WebElement print_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='Images/Print16x16.png']"));
		return element;
	}
	
	/**
	 * Prints the btn.
	 *
	 * @return the string
	 */
	public static String print_btn(){
		cssSelector = "img[src='Images/Print16x16.png']";
		return cssSelector;
	}
	
	/**
	 * Export btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Export button
	public static WebElement export_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='Images/ExportIcon16x16.png']"));
		return element;
	}
	
	/**
	 * Export btn.
	 *
	 * @return the string
	 */
	public static String export_btn(){
		cssSelector = "img[src='Images/ExportIcon16x16.png']";
		return cssSelector;
	}
	
	/**
	 * Excel 2007 button
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement excel2007_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_btnExportExcel2007"));
		return element;
	}
	
	/**
	 * Excel XP button
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement excelXP_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_btnExportExcel2003"));
		return element;
	}
	
	/**
	 * Comma Delimited button
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement commaDelimited_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_btnExportExcelCSV"));
		return element;
	}
	
	/**
	 * Pages dropdown
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement pages_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_ddlPaging"));
		return element;
	}
	
}
