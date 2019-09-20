package pageObjects.Vendors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Vendors Merchant Information page
 */
public class VMerchantInformation {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;

	
	/**
	 * Amex chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// amex chkbx							
	public static WebElement amex_chkbx(WebDriver driver){							
		element = driver.findElement(By.id("Dialogs_Dialogs_cbAmex"));						
		return element;						
	}							
	
	/**
	 * Amex chkbx.
	 *
	 * @return the string
	 */
	public static String amex_chkbx(){							
		id = "Dialogs_Dialogs_cbAmex";						
		return id;						
	}							
								
	/**
	 * Discover chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// discover chkbx							
	public static WebElement discover_chkbx(WebDriver driver){							
		element = driver.findElement(By.id("Dialogs_Dialogs_cbDiscover"));						
		return element;						
	}							
	
	/**
	 * Discover chkbx.
	 *
	 * @return the string
	 */
	public static String discover_chkbx(){							
		id = "Dialogs_Dialogs_cbDiscover";						
		return id;						
	}							
								
	/**
	 * Acquirer bin txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// acquirerBin txtbx							
	public static WebElement acquirerBin_txtbx(WebDriver driver){							
		element = driver.findElement(By.id("Dialogs_Dialogs_txtAcquirerBin"));						
		return element;						
	}							
	
	/**
	 * Acquirer bin txtbx.
	 *
	 * @return the string
	 */
	public static String acquirerBin_txtbx(){							
		id = "Dialogs_Dialogs_txtAcquirerBin";						
		return id;						
	}							
								
	/**
	 * Merchant number txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// merchantNumber txtbx							
	public static WebElement merchantNumber_txtbx(WebDriver driver){							
		element = driver.findElement(By.id("Dialogs_Dialogs_txtMerchantNumber"));						
		return element;						
	}							
	
	/**
	 * Merchant number txtbx.
	 *
	 * @return the string
	 */
	public static String merchantNumber_txtbx(){							
		id = "Dialogs_Dialogs_txtMerchantNumber";						
		return id;						
	}							
								
	/**
	 * Terminal I D txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// terminalID txtbx							
	public static WebElement terminalID_txtbx(WebDriver driver){							
		element = driver.findElement(By.id("Dialogs_Dialogs_txtTerminalID"));						
		return element;						
	}							
	
	/**
	 * Terminal I D txtbx.
	 *
	 * @return the string
	 */
	public static String terminalID_txtbx(){							
		id = "Dialogs_Dialogs_txtTerminalID";						
		return id;						
	}							
								
	/**
	 * Store number txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// storeNumber txtbx							
	public static WebElement storeNumber_txtbx(WebDriver driver){							
		element = driver.findElement(By.id("Dialogs_Dialogs_txtStoreNumber"));						
		return element;						
	}							
	
	/**
	 * Store number txtbx.
	 *
	 * @return the string
	 */
	public static String storeNumber_txtbx(){							
		id = "Dialogs_Dialogs_txtStoreNumber";						
		return id;						
	}							
								
	/**
	 * Terminal number txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// terminalNumber dropdown							
	public static WebElement terminalNumber_txtbx(WebDriver driver){							
		element = driver.findElement(By.id("Dialogs_Dialogs_txtTerminalNumber"));						
		return element;						
	}							
	
	/**
	 * Terminal number txtbx.
	 *
	 * @return the string
	 */
	public static String terminalNumber_txtbx(){							
		id = "Dialogs_Dialogs_txtTerminalNumber";						
		return id;						
	}							
								
	/**
	 * Merchant location number txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// merchantLocationNumber txtbx							
	public static WebElement merchantLocationNumber_txtbx(WebDriver driver){							
		element = driver.findElement(By.id("Dialogs_Dialogs_txtMerchantLocationNumber"));						
		return element;						
	}							
	
	/**
	 * Merchant location number txtbx.
	 *
	 * @return the string
	 */
	public static String merchantLocationNumber_txtbx(){							
		id = "Dialogs_Dialogs_txtMerchantLocationNumber";						
		return id;						
	}							
								
	/**
	 * Agent number txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// agentNumber txtbx							
	public static WebElement agentNumber_txtbx(WebDriver driver){							
		element = driver.findElement(By.id("Dialogs_Dialogs_txtAgentNumber"));						
		return element;						
	}							
	
	/**
	 * Agent number txtbx.
	 *
	 * @return the string
	 */
	public static String agentNumber_txtbx(){							
		id = "Dialogs_Dialogs_txtAgentNumber";						
		return id;						
	}							
								
	/**
	 * Chain number txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// chainNumber txtbx							
	public static WebElement chainNumber_txtbx(WebDriver driver){							
		element = driver.findElement(By.id("Dialogs_Dialogs_txtChainNumber"));						
		return element;						
	}							
	
	/**
	 * Chain number txtbx.
	 *
	 * @return the string
	 */
	public static String chainNumber_txtbx(){							
		id = "Dialogs_Dialogs_txtChainNumber";						
		return id;						
	}							
								
	/**
	 * Merchant category txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// merchantCategory txtbx							
	public static WebElement merchantCategory_txtbx(WebDriver driver){							
		element = driver.findElement(By.id("Dialogs_Dialogs_txtMerchantCategory"));						
		return element;						
	}							
	
	/**
	 * Merchant category txtbx.
	 *
	 * @return the string
	 */
	public static String merchantCategory_txtbx(){							
		id = "Dialogs_Dialogs_txtMerchantCategory";						
		return id;						
	}							
								
	/**
	 * Contact name txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// contactName txtbx							
	public static WebElement contactName_txtbx(WebDriver driver){							
		element = driver.findElement(By.id("Dialogs_Dialogs_txtContactName"));						
		return element;						
	}							
	
	/**
	 * Contact name txtbx.
	 *
	 * @return the string
	 */
	public static String contactName_txtbx(){							
		id = "Dialogs_Dialogs_txtContactName";						
		return id;						
	}							
								
	/**
	 * Email txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// email txtbx							
	public static WebElement email_txtbx(WebDriver driver){							
		element = driver.findElement(By.id("Dialogs_Dialogs_txtEmail"));						
		return element;						
	}							
	
	/**
	 * Email txtbx.
	 *
	 * @return the string
	 */
	public static String email_txtbx(){							
		id = "Dialogs_Dialogs_txtEmail";						
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
		element = driver.findElement(By.id("Dialogs_Dialogs_btnMerchantAccountCancel"));						
		return element;						
	}							
	
	/**
	 * Cancel btn.
	 *
	 * @return the string
	 */
	public static String cancel_btn(){							
		id = "Dialogs_Dialogs_btnMerchantAccountCancel";						
		return id;						
	}							
								
	/**
	 * Submit btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// submit btn							
	public static WebElement submit_btn(WebDriver driver){							
		element = driver.findElement(By.id("Dialogs_Dialogs_btnMerchantAccountSave"));						
		return element;						
	}							
	
	/**
	 * Submit btn.
	 *
	 * @return the string
	 */
	public static String submit_btn(){							
		id = "Dialogs_Dialogs_btnMerchantAccountSave";						
		return id;						
	}		
	
	/**
	 * Yes btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// yes btn							
	public static WebElement yes_btn(WebDriver driver){							
		element = driver.findElement(By.id("sbdmButton1"));						
		return element;						
	}							
	
	/**
	 * Yes btn.
	 *
	 * @return the string
	 */
	public static String yes_btn(){							
		id = "sbdmButton1";						
		return id;						
	}	
	
	/**
	 * Information updated dialog txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Information updated dialog text				
	public static WebElement informationUpdatedDialog_txt(WebDriver driver){							
		element = driver.findElement(By.id("divMessageOK"));						
		return element;						
	}							
	
	/**
	 * Information updated dialog txt.
	 *
	 * @return the string
	 */
	public static String informationUpdatedDialog_txt(){							
		id = "divMessageOK";						
		return id;						
	}
	
}
