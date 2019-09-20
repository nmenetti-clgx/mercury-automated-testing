package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure Configure Order Form page
 */
public class SConfigureOrderForm {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;

	
	/**
	 * Page txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// page text
	public static WebElement page_txt(WebDriver driver){
		element = driver.findElement(By.id("divData"));
		return element;
	}
	
	/**
	 * Page txt.
	 *
	 * @return the string
	 */
	public static String page_txt(){
		id = "divData";
		return id;
	}
	
	/**
	 * Allow clients to enter fee chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Allow clients to enter fee checkbox
	public static WebElement allowClientsToEnterFee_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_chkAllowEnterFee"));
		return element;
	}
	
	/**
	 * Allow clients to enter fee chkbx.
	 *
	 * @return the string
	 */
	public static String allowClientsToEnterFee_chkbx(){
		id = "Main_Main_Main_chkAllowEnterFee";
		return id;
	}
	
	/**
	 * Allow clients to select AMC firm chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Allow clients to select AMC/Firm checkbox
	public static WebElement allowClientsToSelectAMCFirm_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_chkAllowClientsToSelectAMC"));
		return element;
	}
	
	/**
	 * Allow clients to select AMC firm chkbx.
	 *
	 * @return the string
	 */
	public static String allowClientsToSelectAMCFirm_chkbx(){
		id = "Main_Main_Main_chkAllowClientsToSelectAMC";
		return id;
	}
	
}
