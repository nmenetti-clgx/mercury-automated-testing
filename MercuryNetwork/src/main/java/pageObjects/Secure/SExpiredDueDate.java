package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure Expired Due Date page
 */
public class SExpiredDueDate {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;

	
	/**
	 * Calendar btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Calendar button
	public static WebElement calendar_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_imgDueDateCalendar"));
		return element;
	}
	
	/**
	 * Calendar btn.
	 *
	 * @return the string
	 */
	public static String calendar_btn(){
		id = "Dialogs_Dialogs_imgDueDateCalendar";
		return id;
	}
	
	/**
	 * Calendar.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Calendar
	public static WebElement calendar(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_calSelectDate_tblControl"));
		return element;
	}
	
	/**
	 * Calendar.
	 *
	 * @return the string
	 */
	public static String calendar(){
		id = "Dialogs_Dialogs_calSelectDate_tblControl";
		return id;
	}
	
	/**
	 * Calendar month txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Calendar month
	public static WebElement calendarMonth_txt(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_calSelectDate_lblHeaderMonth"));
		return element;
	}
	
	/**
	 * Calendar month txt.
	 *
	 * @return the string
	 */
	public static String calendarMonth_txt(){
		id = "Dialogs_Dialogs_calSelectDate_lblHeaderMonth";
		return id;
	}
	
	/**
	 * Calendar year txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Calendar year
	public static WebElement calendarYear_txt(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_calSelectDate_lblHeaderYear"));
		return element;
	}
	
	/**
	 * Calendar year txt.
	 *
	 * @return the string
	 */
	public static String calendarYear_txt(){
		id = "Dialogs_Dialogs_calSelectDate_lblHeaderYear";
		return id;
	}
	
	/**
	 * Calendar previous month btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Calendar previous month
	public static WebElement calendarPreviousMonth_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_calSelectDate_imgCalendarChangeLeft"));
		return element;
	}
	
	/**
	 * Calendar previous month btn.
	 *
	 * @return the string
	 */
	public static String calendarPreviousMonth_btn(){
		id = "Dialogs_Dialogs_calSelectDate_imgCalendarChangeLeft";
		return id;
	}
	
	/**
	 * Calendar next month btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Calendar next month
	public static WebElement calendarNextMonth_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_calSelectDate_imgCalendarChangeRight"));
		return element;
	}
	
	/**
	 * Calendar next month btn.
	 *
	 * @return the string
	 */
	public static String calendarNextMonth_btn(){
		id = "Dialogs_Dialogs_calSelectDate_imgCalendarChangeRight";
		return id;
	}
	
}
