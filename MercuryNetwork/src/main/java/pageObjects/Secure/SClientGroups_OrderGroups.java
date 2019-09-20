package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure Order Groups page
 */
public class SClientGroups_OrderGroups {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	/** The css selector. */
	private static String cssSelector = null;

	
	/**
	 * Available groups txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Available groups
	public static WebElement availableGroups_txt(WebDriver driver){	
		element = driver.findElement(By.id("grdAvailableGroups"));
		return element;
	}	
	
	/**
	 * Available groups txt.
	 *
	 * @return the string
	 */
	public static String availableGroups_txt(){	
		id = "grdAvailableGroups";
		return id;
	}
	
	/**
	 * Eligible vendors txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Eligible groups
	public static WebElement eligibleVendors_txt(WebDriver driver){	
		element = driver.findElement(By.id("grdIncludedGroups"));
		return element;
	}	
	
	/**
	 * Eligible vendors txt.
	 *
	 * @return the string
	 */
	public static String eligibleVendors_txt(){	
		id = "grdIncludedGroups";
		return id;
	}
	
	/**
	 * Ineligible vendors txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Ineligible groups
	public static WebElement ineligibleVendors_txt(WebDriver driver){	
		element = driver.findElement(By.id("grdExcludedGroups"));
		return element;
	}	
	
	/**
	 * Ineligible vendors txt.
	 *
	 * @return the string
	 */
	public static String ineligibleVendors_txt(){	
		id = "grdExcludedGroups";
		return id;
	}
	
	/**
	 * Adds the to eligible btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Add to Eligible button
	public static WebElement addToEligible_btn(WebDriver driver){	
		element = driver.findElement(By.cssSelector("#colMid_OrderGroups > div:nth-child(1) > img:nth-child(1)"));
		return element;
	}	
	
	/**
	 * Adds the to eligible btn.
	 *
	 * @return the string
	 */
	public static String addToEligible_btn(){	
		cssSelector = "#colMid_OrderGroups > div:nth-child(1) > img:nth-child(1)";
		return cssSelector;
	}
	
	/**
	 * Removes the from eligible btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Remove from Eligible button
	public static WebElement removeFromEligible_btn(WebDriver driver){	
		element = driver.findElement(By.cssSelector("#colMid_OrderGroups > div:nth-child(1) > img:nth-child(2)"));
		return element;
	}	
	
	/**
	 * Removes the from eligible btn.
	 *
	 * @return the string
	 */
	public static String removeFromEligible_btn(){	
		cssSelector = "#colMid_OrderGroups > div:nth-child(1) > img:nth-child(2)";
		return cssSelector;
	}
	
	/**
	 * Adds the to ineligible btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Add to Ineligible button
	public static WebElement addToIneligible_btn(WebDriver driver){	
		element = driver.findElement(By.cssSelector("#colMid_OrderGroups > div:nth-child(2) > img:nth-child(1)"));
		return element;
	}	
	
	/**
	 * Adds the to ineligible btn.
	 *
	 * @return the string
	 */
	public static String addToIneligible_btn(){	
		cssSelector = "#colMid_OrderGroups > div:nth-child(2) > img:nth-child(1)";
		return cssSelector;
	}
	
	/**
	 * Removes the from ineligible btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Remove from Ineligible button
	public static WebElement removeFromIneligible_btn(WebDriver driver){	
		element = driver.findElement(By.cssSelector("#colMid_OrderGroups > div:nth-child(2) > img:nth-child(2)"));
		return element;
	}	
	
	/**
	 * Removes the from ineligible btn.
	 *
	 * @return the string
	 */
	public static String removeFromIneligible_btn(){	
		cssSelector = "#colMid_OrderGroups > div:nth-child(2) > img:nth-child(2)";
		return cssSelector;
	}
	
}
