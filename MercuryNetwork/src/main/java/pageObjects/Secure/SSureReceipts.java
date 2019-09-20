package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure Send Via Sure Receipts page
 */
public class SSureReceipts {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	
	/**
	 * I understand radio button.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement iUnderstand_radiobtn(WebDriver driver){
		element = driver.findElement(By.id("rbConsent_Accept"));
		return element;
	}
	
	/**
	 * I understand radio button.
	 *
	 * @return the string
	 */
	public static String iUnderstand_radiobtn(){
		id = "rbConsent_Accept";
		return id;
	}
	
	/**
	 * Continue button.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement continue_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_upMain"));
		return element;
	}
	
	/**
	 * Download Auth Code button.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement downloadAuthCode_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_btnDownloadAuthCode"));
		return element;
	}
	
	/**
	 * Auth Code textbox.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement authCode_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_txtAuthCode"));
		return element;
	}
	
	/**
	 * Download Report button.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement downloadReport_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_btnDownloadAppraisal"));
		return element;
	}
	
	/**
	 * Download Documents link.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement downloadDocuments_link(WebDriver driver){
		element = driver.findElement(By.linkText("Download documents"));
		return element;
	}
	
}
