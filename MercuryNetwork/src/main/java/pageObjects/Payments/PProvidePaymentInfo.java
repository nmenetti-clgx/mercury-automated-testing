package pageObjects.Payments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Provide Payment Info page
 */
public class PProvidePaymentInfo {
	
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
		element = driver.findElement(By.id("FirstName"));
		return element;
	}	
	
	/**
	 * First name txtbx.
	 *
	 * @return the string
	 */
	public static String firstName_txtbx(){	
		id = "FirstName";
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
		element = driver.findElement(By.id("LastName"));
		return element;
	}	
	
	/**
	 * Last name txtbx.
	 *
	 * @return the string
	 */
	public static String lastName_txtbx(){	
		id = "LastName";
		return id;
	}	
		
	/**
	 * Card number txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// cardNumber txtbx	
	public static WebElement cardNumber_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("CreditCardNumber"));
		return element;
	}	
	
	/**
	 * Card number txtbx.
	 *
	 * @return the string
	 */
	public static String cardNumber_txtbx(){	
		id = "CreditCardNumber";
		return id;
	}	
		
	/**
	 * Month dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// month dropdown	
	public static WebElement month_dropdown(WebDriver driver){	
		element = driver.findElement(By.id("ExpirationMonth"));
		return element;
	}	
	
	/**
	 * Month dropdown.
	 *
	 * @return the string
	 */
	public static String month_dropdown(){	
		id = "ExpirationMonth";
		return id;
	}	
		
	/**
	 * Year dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// year dropdown	
	public static WebElement year_dropdown(WebDriver driver){	
		element = driver.findElement(By.id("ExpirationYear"));
		return element;
	}	
	
	/**
	 * Year dropdown.
	 *
	 * @return the string
	 */
	public static String year_dropdown(){	
		id = "ExpirationYear";
		return id;
	}	
		
	/**
	 * Billing zip code txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// billingZipCode txtbx	
	public static WebElement billingZipCode_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("PostalCode"));
		return element;
	}	
	
	/**
	 * Billing zip code txtbx.
	 *
	 * @return the string
	 */
	public static String billingZipCode_txtbx(){	
		id = "PostalCode";
		return id;
	}	
		
	/**
	 * Email address txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// emailAddress txtbx	
	public static WebElement emailAddress_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("EmailAddress"));
		return element;
	}	
	
	/**
	 * Email address txtbx.
	 *
	 * @return the string
	 */
	public static String emailAddress_txtbx(){	
		id = "EmailAddress";
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
		element = driver.findElement(By.cssSelector("input[type='submit'][value='Submit']"));
		return element;
	}	
	
	/**
	 * Submit btn.
	 *
	 * @return the string
	 */
	public static String submit_btn(){	
		cssSelector = "input[type='submit'][value='Submit']";
		return cssSelector;
	}	
		
	/**
	 * Address txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// address txt	
	public static WebElement address_txt(WebDriver driver){	
		element = driver.findElement(By.cssSelector("body > app-root > main > section > app-property-pay > app-address > div > div.leftItem > address"));
		return element;
	}	
	
	/**
	 * Address txt.
	 *
	 * @return the string
	 */
	public static String address_txt(){	
		cssSelector = "body > app-root > main > section > app-property-pay > app-address > div > div.leftItem > address";
		return cssSelector;
	}	
		
	/**
	 * Amount txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// amount txt	
	public static WebElement amount_txt(WebDriver driver){	
		element = driver.findElement(By.cssSelector("body > app-root > main > section > app-property-pay > app-address > div > div.rightItem.right-align-item > div"));
		return element;
	}	
	
	/**
	 * Amount txt.
	 *
	 * @return the string
	 */
	public static String amount_txt(){	
		cssSelector = "body > app-root > main > section > app-property-pay > app-address > div > div.rightItem.right-align-item > div";
		return cssSelector;
	}	
		
	/**
	 * Technology fee txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// technologyFee txt	
	public static WebElement technologyFee_txt(WebDriver driver){	
		element = driver.findElement(By.cssSelector("body > app-root > main > section > app-property-pay > app-address > div > div.rightItem.right-align-item > div:nth-child(2)"));
		return element;
	}	
	
	/**
	 * Technology fee txt.
	 *
	 * @return the string
	 */
	public static String technologyFee_txt(){	
		cssSelector = "body > app-root > main > section > app-property-pay > app-address > div > div.rightItem.right-align-item > div:nth-child(2)";
		return cssSelector;
	}	
		
	/**
	 * Total txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// total txt	
	public static WebElement total_txt(WebDriver driver){	
		element = driver.findElement(By.cssSelector("body > app-root > main > section > app-property-pay > app-address > div > div.rightItem.right-align-item > div:nth-child(3)"));
		return element;
	}	
	
	/**
	 * Total txt.
	 *
	 * @return the string
	 */
	public static String total_txt(){	
		cssSelector = "body > app-root > main > section > app-property-pay > app-address > div > div.rightItem.right-align-item > div:nth-child(3)";
		return cssSelector;
	}	
		
	/**
	 * Header txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// header txt	
	public static WebElement header_txt(WebDriver driver){	
		element = driver.findElement(By.cssSelector("body > app-root > main > section > app-property-pay > div.highlight"));
		return element;
	}	
	
	/**
	 * Header txt.
	 *
	 * @return the string
	 */
	public static String header_txt(){	
		cssSelector = "body > app-root > main > section > app-property-pay > div.highlight";
		return cssSelector;
	}	

	/**
	 * Main section.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// main section
	public static WebElement mainSection(WebDriver driver){	
		element = driver.findElement(By.id("mainSection"));
		return element;
	}	
	
	/**
	 * Main section.
	 *
	 * @return the string
	 */
	public static String mainSection(){	
		id = "mainSection";
		return id;
	}	
	
	/**
	 * Loading.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// loading
	public static WebElement loading(WebDriver driver){	
		element = driver.findElement(By.id("loading"));
		return element;
	}	
	
	/**
	 * Loading.
	 *
	 * @return the string
	 */
	public static String loading(){	
		id = "loading";
		return id;
	}	
	
	/**
	 * Confirmation txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// confirmation txt	
	public static WebElement confirmation_txt(WebDriver driver){	
		element = driver.findElement(By.cssSelector("body > app-root > main > section"));
		return element;
	}	
	
	/**
	 * Confirmation txt.
	 *
	 * @return the string
	 */
	public static String confirmation_txt(){	
		cssSelector = "body > app-root > main > section";
		return cssSelector;
	}	
	
	/**
	 * retry_btn
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement retry_btn(WebDriver driver){	
		element = driver.findElement(By.cssSelector("body > app-root > main > section > app-property-pay > div:nth-child(4) > div > div:nth-child(3) > button"));
		return element;
	}	
	
	/**
	 * retry_btn
	 *
	 * @return the string
	 */
	public static String retry_btn(){	
		cssSelector = "body > app-root > main > section > app-property-pay > div:nth-child(4) > div > div:nth-child(3) > button";
		return cssSelector;
	}	
	
}
