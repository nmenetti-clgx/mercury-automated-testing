package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**
 * The elements on the Secure Verify Certificate Information page
 */
public class SVerifyCertificateInformation {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	/** The css selector. */
	private static String cssSelector = null;

	
	/**
	 * Lender name txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Lender Name
	public static WebElement lenderName_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_vcValidateCert_txtLenderName"));
		return element;
	}
	
	/**
	 * Lender name txtbx.
	 *
	 * @return the string
	 */
	public static String lenderName_txtbx(){
		id = "Dialogs_Dialogs_vcValidateCert_txtLenderName";
		return id;
	}
	
	/**
	 * Property street txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Property Street
	public static WebElement propertyStreet_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_vcValidateCert_txtSubjectStreet"));
		return element;
	}
	
	/**
	 * Property street txtbx.
	 *
	 * @return the string
	 */
	public static String propertyStreet_txtbx(){
		id = "Dialogs_Dialogs_vcValidateCert_txtSubjectStreet";
		return id;
	}
	
	/**
	 * Property city txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Property City
	public static WebElement propertyCity_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_vcValidateCert_txtSubjectCity"));
		return element;
	}
	
	/**
	 * Property city txtbx.
	 *
	 * @return the string
	 */
	public static String propertyCity_txtbx(){
		id = "Dialogs_Dialogs_vcValidateCert_txtSubjectCity";
		return id;
	}
	
	/**
	 * Property state txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Property State
	public static WebElement propertyState_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_vcValidateCert_txtSubjectState"));
		return element;
	}
	
	/**
	 * Property state txtbx.
	 *
	 * @return the string
	 */
	public static String propertyState_txtbx(){
		id = "Dialogs_Dialogs_vcValidateCert_txtSubjectState";
		return id;
	}
	
	/**
	 * Property zip txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Property Zip
	public static WebElement propertyZip_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_vcValidateCert_txtSubjectZip"));
		return element;
	}
	
	/**
	 * Property zip txtbx.
	 *
	 * @return the string
	 */
	public static String propertyZip_txtbx(){
		id = "Dialogs_Dialogs_vcValidateCert_txtSubjectZip";
		return id;
	}
	
	/**
	 * Borrower name txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Borrower Name
	public static WebElement borrowerName_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_vcValidateCert_txtBorrowerName"));
		return element;
	}
	
	/**
	 * Borrower name txtbx.
	 *
	 * @return the string
	 */
	public static String borrowerName_txtbx(){
		id = "Dialogs_Dialogs_vcValidateCert_txtBorrowerName";
		return id;
	}
	
	/**
	 * Loan number txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Loan #
	public static WebElement loanNumber_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_vcValidateCert_txtLoanNumber"));
		return element;
	}
	
	/**
	 * Loan number txtbx.
	 *
	 * @return the string
	 */
	public static String loanNumber_txtbx(){
		id = "Dialogs_Dialogs_vcValidateCert_txtLoanNumber";
		return id;
	}
	
	/**
	 * Appraised date txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Appraised Date
	public static WebElement appraisedDate_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_vcValidateCert_txtAppraisedDate"));
		return element;
	}
	
	/**
	 * Appraised date txtbx.
	 *
	 * @return the string
	 */
	public static String appraisedDate_txtbx(){
		id = "Dialogs_Dialogs_vcValidateCert_txtAppraisedDate";
		return id;
	}
	
	/**
	 * Appraised value txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Appraised Value
	public static WebElement appraisedValue_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_vcValidateCert_txtAppraisedValue"));
		return element;
	}
	
	/**
	 * Appraised value txtbx.
	 *
	 * @return the string
	 */
	public static String appraisedValue_txtbx(){
		id = "Dialogs_Dialogs_vcValidateCert_txtAppraisedValue";
		return id;
	}
	
	/**
	 * Appraised date chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Appraised Date checkbox
	public static WebElement appraisedDate_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_vcValidateCert_chkAppraisedDate"));
		return element;
	}
	
	/**
	 * Appraised date chkbx.
	 *
	 * @return the string
	 */
	public static String appraisedDate_chkbx(){
		id = "Dialogs_Dialogs_vcValidateCert_chkAppraisedDate";
		return id;
	}
	
	/**
	 * Appraised value chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Appraised Value checkbox
	public static WebElement appraisedValue_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_vcValidateCert_chkAppraisedValue"));
		return element;
	}
	
	/**
	 * Appraised value chkbx.
	 *
	 * @return the string
	 */
	public static String appraisedValue_chkbx(){
		id = "Dialogs_Dialogs_vcValidateCert_chkAppraisedValue";
		return id;
	}
	
	/**
	 * Save btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Save button
	public static WebElement save_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/images/Save16x16.png']"));
		return element;
	}
	
	/**
	 * Save btn.
	 *
	 * @return the string
	 */
	public static String save_btn(){
		cssSelector = "img[src='/images/Save16x16.png']";
		return cssSelector;
	}
	
}
