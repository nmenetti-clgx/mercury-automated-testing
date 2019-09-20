package pageObjects.XSite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the XSite Invoice page
 */
public class XInvoice {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;

	
	/**
	 * Invoice number txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Invoice Number textbox
	public static WebElement invoiceNumber_txtbx(WebDriver driver){
		element = driver.findElement(By.id("PB_txtInvoiceNo"));
		return element;
	}
	
	/**
	 * Invoice number txtbx.
	 *
	 * @return the string
	 */
	public static String invoiceNumber_txtbx(){
		id = "PB_txtInvoiceNo";
		return id;
	}
	
	/**
	 * Fees txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Fees text
	public static WebElement fees_txt(WebDriver driver){
		element = driver.findElement(By.id("PB_objFees_dgFees"));
		return element;
	}
	
	/**
	 * Fees txt.
	 *
	 * @return the string
	 */
	public static String fees_txt(){
		id = "PB_objFees_dgFees";
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
		element = driver.findElement(By.id("imgPDF"));
		return element;
	}
	
	/**
	 * Pdf btn.
	 *
	 * @return the string
	 */
	public static String pdf_btn(){
		id = "imgPDF";
		return id;
	}
	
	/**
	 * Pdf.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// PDF
	public static WebElement pdf(WebDriver driver){
		element = driver.findElement(By.id("plugin"));
		return element;
	}
	
	/**
	 * Pdf.
	 *
	 * @return the string
	 */
	public static String pdf(){
		id = "plugin";
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
		element = driver.findElement(By.id("imgClose"));
		return element;
	}
	
	/**
	 * Close btn.
	 *
	 * @return the string
	 */
	public static String close_btn(){
		id = "imgClose";
		return id;
	}
	
}
