package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure Contact Management page
 */
public class SContactManagement {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;

	
	/**
	 * Company table txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// company table text
	public static WebElement companyTable_txt(WebDriver driver){	
		element = driver.findElement(By.id("ctl01_agCompany_alacdiv"));
		return element;
	}	
	
	/**
	 * Company table txt.
	 *
	 * @return the string
	 */
	public static String companyTable_txt(){	
		id = "ctl01_agCompany_alacdiv";
		return id;
	}
	
	/**
	 * Select all chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// select all checkbox
	public static WebElement selectAll_chkbx(WebDriver driver){	
		element = driver.findElement(By.id("ctl01_agCompany_alahchk"));
		return element;
	}	
	
	/**
	 * Select all chkbx.
	 *
	 * @return the string
	 */
	public static String selectAll_chkbx(){	
		id = "ctl01_agCompany_alahchk";
		return id;
	}
	
	/**
	 * Delete btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// delete button
	public static WebElement delete_btn(WebDriver driver){	
		element = driver.findElement(By.id("btnDelete"));
		return element;
	}	
	
	/**
	 * Delete btn.
	 *
	 * @return the string
	 */
	public static String delete_btn(){	
		id = "btnDelete";
		return id;
	}
	
	
}
