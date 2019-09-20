package pageObjects.Vendors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Vendors Add Trainee page
 */
public class VUsers_AddTrainee {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The css selector. */
	private static String cssSelector = null;
	
	/** The id. */
	private static String id = null;

	
	/**
	 * First name txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// firstName txtbx	
	public static WebElement firstName_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("txtTraineeFirstName"));
		return element;
	}	
	
	/**
	 * First name txtbx.
	 *
	 * @return the string
	 */
	public static String firstName_txtbx(){	
		id = "txtTraineeFirstName";
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
		element = driver.findElement(By.id("txtTraineeLastName"));
		return element;
	}	
	
	/**
	 * Last name txtbx.
	 *
	 * @return the string
	 */
	public static String lastName_txtbx(){	
		id = "txtTraineeLastName";
		return id;
	}	
		
	/**
	 * Training state dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// trainingState dropdown	
	public static WebElement trainingState_dropdown(WebDriver driver){	
		element = driver.findElement(By.id("ddlTrainingState"));
		return element;
	}	
	
	/**
	 * Training state dropdown.
	 *
	 * @return the string
	 */
	public static String trainingState_dropdown(){	
		id = "ddlTrainingState";
		return id;
	}	
		
	/**
	 * License number txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// licenseNumber txtbx	
	public static WebElement licenseNumber_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("txtTraineeLicenseNumber"));
		return element;
	}	
	
	/**
	 * License number txtbx.
	 *
	 * @return the string
	 */
	public static String licenseNumber_txtbx(){	
		id = "txtTraineeLicenseNumber";
		return id;
	}	
		
	/**
	 * Calendar add trainee btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// calendarAddTrainee btn	
	public static WebElement calendarAddTrainee_btn(WebDriver driver){	
		element = driver.findElement(By.id("imgTraineeExpirationDate"));
		return element;
	}	
	
	/**
	 * Calendar add trainee btn.
	 *
	 * @return the string
	 */
	public static String calendarAddTrainee_btn(){	
		id = "imgTraineeExpirationDate";
		return id;
	}	
		
	/**
	 * Adds the trainee txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// addTrainee txt	
	public static WebElement addTrainee_txt(WebDriver driver){	
		element = driver.findElement(By.id("divTrainee"));
		return element;
	}	
	
	/**
	 * Adds the trainee txt.
	 *
	 * @return the string
	 */
	public static String addTrainee_txt(){	
		id = "divTrainee";
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
		element = driver.findElement(By.cssSelector(".MessageBoxButton > .Button[value='Save']"));
		return element;
	}	
	
	/**
	 * Save btn.
	 *
	 * @return the string
	 */
	public static String save_btn(){	
		cssSelector = ".MessageBoxButton > .Button[value='Save']";
		return cssSelector;
	}	
		
	/**
	 * Cancel btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// cancel btn	
	public static WebElement cancel_btn(WebDriver driver){	
		element = driver.findElement(By.cssSelector("#divTrainee > div.MessageBoxFooter > .MessageBoxButton > input[value='Cancel']"));
		return element;
	}	
	
	/**
	 * Cancel btn.
	 *
	 * @return the string
	 */
	public static String cancel_btn(){	
		cssSelector = "#divTrainee > div.MessageBoxFooter > .MessageBoxButton > input[value='Cancel']";
		return cssSelector;
	}	
		
	/**
	 * Expiration date txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// expirationDate txtbx	
	public static WebElement expirationDate_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("txtTraineeExpirationDate"));
		return element;
	}	
	
	/**
	 * Expiration date txtbx.
	 *
	 * @return the string
	 */
	public static String expirationDate_txtbx(){	
		id = "txtTraineeExpirationDate";
		return id;
	}
	
	/**
	 * Ok btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// ok_btn
	public static WebElement ok_btn(WebDriver driver){	
		element = driver.findElement(By.id("sbdmButton1"));
		return element;
	}	
	
	/**
	 * Ok btn.
	 *
	 * @return the string
	 */
	public static String ok_btn(){	
		id = "sbdmButton1";
		return id;
	}
	
	/**
	 * Error message txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// error message text
	public static WebElement errorMessage_txt(WebDriver driver){	
		element = driver.findElement(By.id("divMessageOKText"));
		return element;
	}	
	
	/**
	 * Error message txt.
	 *
	 * @return the string
	 */
	public static String errorMessage_txt(){	
		id = "divMessageOKText";
		return id;
	}
	
}
