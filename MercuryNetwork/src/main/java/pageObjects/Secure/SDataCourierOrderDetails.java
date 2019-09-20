package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure Data Courier Order Details page
 */
public class SDataCourierOrderDetails {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The css selector. */
	private static String cssSelector = null;
	
	/** The id. */
	private static String id = null;

	
	/**
	 * Back btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Back button
	public static WebElement back_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/Images/Back16x16.png']"));
		return element;
	}
	
	/**
	 * Back btn.
	 *
	 * @return the string
	 */
	public static String back_btn(){
		cssSelector = "img[src='/Images/Back16x16.png']";
		return cssSelector;
	}
	
	/**
	 * Submit to UCD P btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Submit to UCDP button
	public static WebElement submitToUCDP_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/Images/SubmitUCDPMenuIcon-16x16.png']"));
		return element;
	}
	
	/**
	 * Submit to UCD P btn.
	 *
	 * @return the string
	 */
	public static String submitToUCDP_btn(){
		cssSelector = "img[src='/Images/SubmitUCDPMenuIcon-16x16.png']";
		return cssSelector;
	}
	
	/**
	 * Start AQ M btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Start AQM button
	public static WebElement startAQM_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/Common/AQMForms/Images/AQI.png']"));
		return element;
	}
	
	/**
	 * Start AQ M btn.
	 *
	 * @return the string
	 */
	public static String startAQM_btn(){
		cssSelector = "img[src='/Common/AQMForms/Images/AQI.png']";
		return cssSelector;
	}
	
	/**
	 * Address txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Address text
	public static WebElement address_txt(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_ctlDetails_lblAddress"));
		return element;
	}
	
	/**
	 * Address txt.
	 *
	 * @return the string
	 */
	public static String address_txt(){
		id = "Main_Main_ctlDetails_lblAddress";
		return id;
	}
	
	/**
	 * Borrower name txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Borrower Name text
	public static WebElement borrowerName_txt(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_ctlDetails_lblBorrower"));
		return element;
	}
	
	/**
	 * Borrower name txt.
	 *
	 * @return the string
	 */
	public static String borrowerName_txt(){
		id = "Main_Main_ctlDetails_lblBorrower";
		return id;
	}
	
	/**
	 * Loan number txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Loan Number text
	public static WebElement loanNumber_txt(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_ctlDetails_lblLoanNumber"));
		return element;
	}
	
	/**
	 * Loan number txt.
	 *
	 * @return the string
	 */
	public static String loanNumber_txt(){
		id = "Main_Main_ctlDetails_lblLoanNumber";
		return id;
	}
	
	/**
	 * History txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// History text
	public static WebElement history_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector(".HistoryItems"));
		return element;
	}
	
	/**
	 * History txt.
	 *
	 * @return the string
	 */
	public static String history_txt(){
		cssSelector = ".HistoryItems";
		return cssSelector;
	}
	
	/**
	 * Documents btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Documents button
	public static WebElement documents_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_ctlDetails_tdDocuments"));
		return element;
	}
	
	/**
	 * Documents btn.
	 *
	 * @return the string
	 */
	public static String documents_btn(){
		id = "Main_Main_ctlDetails_tdDocuments";
		return id;
	}
	
	/**
	 * Pdf btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// PDF button
	public static WebElement pdf_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_ctlDetails_tdPDF"));
		return element;
	}
	
	/**
	 * Pdf btn.
	 *
	 * @return the string
	 */
	public static String pdf_btn(){
		id = "Main_Main_ctlDetails_tdPDF";
		return id;
	}
	
}
