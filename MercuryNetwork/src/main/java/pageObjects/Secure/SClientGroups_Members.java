package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure Memebers page
 */
public class SClientGroups_Members {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;

	
	/**
	 * Group members txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Group Members text
	public static WebElement groupMembers_txt(WebDriver driver){	
		element = driver.findElement(By.id("divGroupMembersGrid"));
		return element;
	}	
	
	/**
	 * Group members txt.
	 *
	 * @return the string
	 */
	public static String groupMembers_txt(){	
		id = "divGroupMembersGrid";
		return id;
	}
	
	/**
	 * Place orders chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Place Orders checkbox
	public static WebElement placeOrders_chkbx(WebDriver driver){	
		element = driver.findElement(By.id("Main_cblPlacingOrders_0"));
		return element;
	}	
	
	/**
	 * Place orders chkbx.
	 *
	 * @return the string
	 */
	public static String placeOrders_chkbx(){	
		id = "Main_cblPlacingOrders_0";
		return id;
	}
	
	
	
}
