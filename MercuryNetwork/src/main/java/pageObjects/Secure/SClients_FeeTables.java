package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure Clients Fee Tables page
 */
public class SClients_FeeTables {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	/** The css selector. */
	private static String cssSelector = null;

	
	/**
	 * Dialog fee tables txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Manage Round Robin Groups Dialog text
	public static WebElement dialogFeeTables_txt(WebDriver driver){	
		element = driver.findElement(By.id("bdyDialog"));
		return element;
	}	
	
	/**
	 * Dialog fee tables txt.
	 *
	 * @return the string
	 */
	public static String dialogFeeTables_txt(){	
		id = "bdyDialog";
		return id;
	}	
		
		
	/**
	 * Close dialog btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Close Dialog button
	public static WebElement closeDialog_btn(WebDriver driver){	
		element = driver.findElement(By.cssSelector("img[src='/Images/DialogCloseButton.png']"));
		return element;
	}	
	
	/**
	 * Close dialog btn.
	 *
	 * @return the string
	 */
	public static String closeDialog_btn(){	
		cssSelector = "img[src='/Images/DialogCloseButton.png']";
		return cssSelector;
	}	
	
	/**
	 * Fee table description txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Fee Table Description textbox
	public static WebElement feeTableDescription_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("Main_txtName"));
		return element;
	}	
	
	/**
	 * Fee table description txtbx.
	 *
	 * @return the string
	 */
	public static String feeTableDescription_txtbx(){	
		id = "Main_txtName";
		return id;
	}	
	
	/**
	 * Dialog confirm delete txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Confirm Delete dialog text
	public static WebElement dialogConfirmDelete_txt(WebDriver driver){	
		element = driver.findElement(By.id("divConfirmDelete"));
		return element;
	}	
	
	/**
	 * Dialog confirm delete txt.
	 *
	 * @return the string
	 */
	public static String dialogConfirmDelete_txt(){	
		id = "divConfirmDelete";
		return id;
	}	
	
	/**
	 * Yes delete btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Yes Delete button
	public static WebElement yesDelete_btn(WebDriver driver){	
		element = driver.findElement(By.cssSelector("input[onclick='javascript:btnConfirmDeleteYes_Click();']"));
		return element;
	}	
	
	/**
	 * Yes delete btn.
	 *
	 * @return the string
	 */
	public static String yesDelete_btn(){	
		cssSelector = "input[onclick='javascript:btnConfirmDeleteYes_Click();']";
		return cssSelector;
	}
		
}
