package pageObjects.Vendors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Vendors Receipt page
 */
public class VReceipt {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	/** The css selector. */
	private static String cssSelector = null;

	
	/**
	 * First name txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// firstName txtbx							
	public static WebElement firstName_txtbx(WebDriver driver){							
		element = driver.findElement(By.id("Dialogs_Dialogs_txtReceiptFirstName"));						
		return element;						
	}							
	
	/**
	 * First name txtbx.
	 *
	 * @return the string
	 */
	public static String firstName_txtbx(){							
		id = "Dialogs_Dialogs_txtReceiptFirstName";						
		return id;						
	}							
								
	/**
	 * Last name txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// lastName txtbx							
	public static WebElement lastName_txtbx(WebDriver driver){							
		element = driver.findElement(By.id("Dialogs_Dialogs_txtReceiptLastName"));						
		return element;						
	}							
	
	/**
	 * Last name txtbx.
	 *
	 * @return the string
	 */
	public static String lastName_txtbx(){							
		id = "Dialogs_Dialogs_txtReceiptLastName";						
		return id;						
	}							
								
	/**
	 * Company name txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// companyName txtbx							
	public static WebElement companyName_txtbx(WebDriver driver){							
		element = driver.findElement(By.id("Dialogs_Dialogs_txtReceiptCompanyName"));						
		return element;						
	}							
	
	/**
	 * Company name txtbx.
	 *
	 * @return the string
	 */
	public static String companyName_txtbx(){							
		id = "Dialogs_Dialogs_txtReceiptCompanyName";						
		return id;						
	}							
								
	/**
	 * Address txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// address txtbx							
	public static WebElement address_txtbx(WebDriver driver){							
		element = driver.findElement(By.id("Dialogs_Dialogs_txtReceiptAddress1"));						
		return element;						
	}							
	
	/**
	 * Address txtbx.
	 *
	 * @return the string
	 */
	public static String address_txtbx(){							
		id = "Dialogs_Dialogs_txtReceiptAddress1";						
		return id;						
	}							
								
	/**
	 * Address 2 txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// address2 txtbx							
	public static WebElement address2_txtbx(WebDriver driver){							
		element = driver.findElement(By.id("Dialogs_Dialogs_txtReceiptAddress2"));						
		return element;						
	}							
	
	/**
	 * Address 2 txtbx.
	 *
	 * @return the string
	 */
	public static String address2_txtbx(){							
		id = "Dialogs_Dialogs_txtReceiptAddress2";						
		return id;						
	}							
								
	/**
	 * City txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// city txtbx							
	public static WebElement city_txtbx(WebDriver driver){							
		element = driver.findElement(By.id("Dialogs_Dialogs_txtReceiptCity"));						
		return element;						
	}							
	
	/**
	 * City txtbx.
	 *
	 * @return the string
	 */
	public static String city_txtbx(){							
		id = "Dialogs_Dialogs_txtReceiptCity";						
		return id;						
	}							
								
	/**
	 * State dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// state dropdown							
	public static WebElement state_dropdown(WebDriver driver){							
		element = driver.findElement(By.id("Dialogs_Dialogs_ddlReceiptState"));						
		return element;						
	}							
	
	/**
	 * State dropdown.
	 *
	 * @return the string
	 */
	public static String state_dropdown(){							
		id = "Dialogs_Dialogs_ddlReceiptState";						
		return id;						
	}							
								
	/**
	 * Zip code txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// zipCode txtbx							
	public static WebElement zipCode_txtbx(WebDriver driver){							
		element = driver.findElement(By.id("Dialogs_Dialogs_txtReceiptZip"));						
		return element;						
	}							
	
	/**
	 * Zip code txtbx.
	 *
	 * @return the string
	 */
	public static String zipCode_txtbx(){							
		id = "Dialogs_Dialogs_txtReceiptZip";						
		return id;						
	}							
								
	/**
	 * Phone txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// phone txtbx							
	public static WebElement phone_txtbx(WebDriver driver){							
		element = driver.findElement(By.id("Dialogs_Dialogs_txtReceiptPhone"));						
		return element;						
	}							
	
	/**
	 * Phone txtbx.
	 *
	 * @return the string
	 */
	public static String phone_txtbx(){							
		id = "Dialogs_Dialogs_txtReceiptPhone";						
		return id;						
	}							
								
	/**
	 * Contact email txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// contactEmail txtbx							
	public static WebElement contactEmail_txtbx(WebDriver driver){							
		element = driver.findElement(By.id("Dialogs_Dialogs_txtReceiptEmail"));						
		return element;						
	}							
	
	/**
	 * Contact email txtbx.
	 *
	 * @return the string
	 */
	public static String contactEmail_txtbx(){							
		id = "Dialogs_Dialogs_txtReceiptEmail";						
		return id;						
	}							
								
	/**
	 * Website address txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// websiteAddress txtbx							
	public static WebElement websiteAddress_txtbx(WebDriver driver){							
		element = driver.findElement(By.id("Dialogs_Dialogs_txtReceiptWebAddress"));						
		return element;						
	}							
	
	/**
	 * Website address txtbx.
	 *
	 * @return the string
	 */
	public static String websiteAddress_txtbx(){							
		id = "Dialogs_Dialogs_txtReceiptWebAddress";						
		return id;						
	}							
								
	/**
	 * Email subject line txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// emailSubjectLine txtbx							
	public static WebElement emailSubjectLine_txtbx(WebDriver driver){							
		element = driver.findElement(By.id("Dialogs_Dialogs_txtReceiptSubjectLine"));						
		return element;						
	}							
	
	/**
	 * Email subject line txtbx.
	 *
	 * @return the string
	 */
	public static String emailSubjectLine_txtbx(){							
		id = "Dialogs_Dialogs_txtReceiptSubjectLine";						
		return id;						
	}							
								
	/**
	 * From address txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// fromAddress txtbx							
	public static WebElement fromAddress_txtbx(WebDriver driver){							
		element = driver.findElement(By.id("Dialogs_Dialogs_txtReceiptFrom"));						
		return element;						
	}							
	
	/**
	 * From address txtbx.
	 *
	 * @return the string
	 */
	public static String fromAddress_txtbx(){							
		id = "Dialogs_Dialogs_txtReceiptFrom";						
		return id;						
	}							
								
	/**
	 * Additional message txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// additionalMessage txtbx							
	public static WebElement additionalMessage_txtbx(WebDriver driver){							
		element = driver.findElement(By.id("Dialogs_Dialogs_txtReceiptAdditional"));						
		return element;						
	}							
	
	/**
	 * Additional message txtbx.
	 *
	 * @return the string
	 */
	public static String additionalMessage_txtbx(){							
		id = "Dialogs_Dialogs_txtReceiptAdditional";						
		return id;						
	}							
								
	/**
	 * Preview btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// preview btn							
	public static WebElement preview_btn(WebDriver driver){							
		element = driver.findElement(By.id("Dialogs_Dialogs_SkinButton3"));						
		return element;						
	}							
	
	/**
	 * Preview btn.
	 *
	 * @return the string
	 */
	public static String preview_btn(){							
		id = "Dialogs_Dialogs_SkinButton3";						
		return id;						
	}							
								
	/**
	 * Cancel btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// cancel btn							
	public static WebElement cancel_btn(WebDriver driver){							
		element = driver.findElement(By.id("Dialogs_Dialogs_SkinButton1"));						
		return element;						
	}							
	
	/**
	 * Cancel btn.
	 *
	 * @return the string
	 */
	public static String cancel_btn(){							
		id = "Dialogs_Dialogs_SkinButton1";						
		return id;						
	}							
								
	/**
	 * Save btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// save btn							
	public static WebElement save_btn(WebDriver driver){							
		element = driver.findElement(By.id("Dialogs_Dialogs_SkinButton2"));						
		return element;						
	}							
	
	/**
	 * Save btn.
	 *
	 * @return the string
	 */
	public static String save_btn(){							
		id = "Dialogs_Dialogs_SkinButton2";						
		return id;						
	}
	
	/**
	 * Invoice txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Invoice text						
	public static WebElement invoice_txt(WebDriver driver){							
		element = driver.findElement(By.cssSelector("body > table"));						
		return element;						
	}							
	
	/**
	 * Invoice txt.
	 *
	 * @return the string
	 */
	public static String invoice_txt(){							
		cssSelector = "body > table";						
		return cssSelector;						
	}	
	
}
