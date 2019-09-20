package pageObjects.InternalTools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Internal Tools Notification Search page
 */
public class ITNotificationSearch {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	/** The cssSelector. */
	private static String cssSelector = null;
	
	
	/**
	 * Product Item ID textbox.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement productItemID_txtbx(WebDriver driver){
		element = driver.findElement(By.id("txtPID"));
		return element;
	}
	
	/**
	 * Product Item ID textbox.
	 *
	 * @return the string
	 */
	public static String productItemID_txtbx(){
		id = "txtPID";
		return id;
	}
	
	/**
	 * To Address textbox.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement toAddress_txtbx(WebDriver driver){
		element = driver.findElement(By.id("txtTo"));
		return element;
	}
	
	/**
	 * Search button.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement search_btn(WebDriver driver){
		element = driver.findElement(By.id("btnSearch"));
		return element;
	}
	
	/**
	 * Search button.
	 *
	 * @return the string
	 */
	public static String search_btn(){
		id = "btnSearch";
		return id;
	}
	
	/**
	 * Search results text.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement searchResults_txt(WebDriver driver){
		element = driver.findElement(By.id("grdResults"));
		return element;
	}
	
	/**
	 * Search results text.
	 *
	 * @return the string
	 */
	public static String searchResults_txt(){
		id = "grdResults";
		return id;
	}
	
	/**
	 * Subject results text.
	 *
	 * @return the string
	 */
	public static String subjectSearchResults_txt(){
		cssSelector = "#grdResults > tbody > tr > td:nth-child(7)";
		return cssSelector;
	}
	
	/**
	 * To results text.
	 *
	 * @return the string
	 */
	public static String toSearchResults_txt(){
		cssSelector = "#grdResults > tbody > tr > td:nth-child(5)";
		return cssSelector;
	}
	
	/**
	 * Row results text.
	 *
	 * @return the string
	 */
	public static String rowSearchResults_txt(){
		cssSelector = "#grdResults > tbody > tr";
		return cssSelector;
	}
	
	/**
	 * Body link.
	 *
	 * @param driver the driver
	 * @param row the row
	 * @return the web element
	 */
	public static WebElement body_link(WebDriver driver, int row){
		element = driver.findElement(By.cssSelector("#grdResults > tbody > tr:nth-child("+row+") > td:nth-child(8) > a"));
		return element;
	}
	
	/**
	 * Result by column and row txt.
	 *
	 * @param driver the driver
	 * @param row the row
	 * @param column the column
	 * @return the web element
	 */
	public static WebElement resultByColumnAndRow_txt(WebDriver driver, int row, String column){

		// Set the columnNumber variable
		String columnNumber = null;
		
		// Set the column number
		switch (column.toLowerCase()) {
		case "type":
			columnNumber = "1";
			break;
		case "condition":
			columnNumber = "2";
			break;
		case "from":
			columnNumber = "3";
			break;
		case "fromid":
			columnNumber = "4";
			break;
		case "to":
			columnNumber = "5";
			break;
		case "toid":
			columnNumber = "6";
			break;
		case "subject":
			columnNumber = "7";
			break;
		case "link":
			columnNumber = "8";
			break;
		case "sent":
			columnNumber = "9";
			break;
		case "productitemid":
			columnNumber = "10";
			break;
		case "template":
			columnNumber = "11";
			break;
		case "attachments":
			columnNumber = "12";
			break;
		case "replyto":
			columnNumber = "13";
			break;
		case "cc":
			columnNumber = "14";
			break;
		default:
			columnNumber = null;
			break;
		} // end switch
		element = driver.findElement(By.cssSelector("#grdResults > tbody > tr:nth-child("+row+") > td:nth-child("+columnNumber+")"));
		return element;
	}
	
	/**
	 * Refresh button.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement refresh_btn(WebDriver driver){
		element = driver.findElement(By.id("btnRefresh"));
		return element;
	}
	
}
