package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure Payment Details page
 */
public class SPaymentDetails {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	
	/**
	 * Received txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Received text
	public static WebElement received_txt(WebDriver driver){
		element = driver.findElement(By.id("receivable_transactions"));
		return element;
	}
	
	/**
	 * Received txt.
	 *
	 * @return the string
	 */
	public static String received_txt(){
		id = "receivable_transactions";
		return id;
	}
	
	/**
	 * Ok btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// OK button
	public static WebElement ok_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_btnClose"));
		return element;
	}
	
	/**
	 * Ok btn.
	 *
	 * @return the string
	 */
	public static String ok_btn(){
		id = "Main_btnClose";
		return id;
	}

}
