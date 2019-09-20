package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure Submit to UCDP page
 */
public class SSubmitToUCDP {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	/** The css selector. */
	private static String cssSelector = null;

	
	/**
	 * Select GS E dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Select SGE dropdown
	public static WebElement selectGSE_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Main_ddlUCDPGSEs"));
		return element;
	}
	
	/**
	 * Select GS E dropdown.
	 *
	 * @return the string
	 */
	public static String selectGSE_dropdown(){
		id = "Main_ddlUCDPGSEs";
		return id;
	}
	
	/**
	 * Business unit dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Business unit dropdown
	public static WebElement businessUnit_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Main_ddlUCDPBusinessUnits"));
		return element;
	}
	
	/**
	 * Business unit dropdown.
	 *
	 * @return the string
	 */
	public static String businessUnit_dropdown(){
		id = "Main_ddlUCDPBusinessUnits";
		return id;
	}
	
	/**
	 * Loan number txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Loan number textbox
	public static WebElement loanNumber_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_txtUCDPLoanNumber"));
		return element;
	}
	
	/**
	 * Loan number txtbx.
	 *
	 * @return the string
	 */
	public static String loanNumber_txtbx(){
		id = "Main_txtUCDPLoanNumber";
		return id;
	}
	
	/**
	 * Internal notes txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Internal Notes textbox
	public static WebElement internalNotes_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_txtUCDPNotes"));
		return element;
	}
	
	/**
	 * Internal notes txtbx.
	 *
	 * @return the string
	 */
	public static String internalNotes_txtbx(){
		id = "Main_txtUCDPNotes";
		return id;
	}
	
	/**
	 * Update status on VMPX site chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Update status on VMP XSite checkbox
	public static WebElement updateStatusOnVMPXSite_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_chkUCDPSyncStatus"));
		return element;
	}
	
	/**
	 * Update status on VMPX site chkbx.
	 *
	 * @return the string
	 */
	public static String updateStatusOnVMPXSite_chkbx(){
		id = "Main_chkUCDPSyncStatus";
		return id;
	}
	
	/**
	 * Send btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Send button
	public static WebElement send_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_btnSend"));
		return element;
	}
	
	/**
	 * Send btn.
	 *
	 * @return the string
	 */
	public static String send_btn(){
		id = "Main_btnSend";
		return id;
	}
	
	/**
	 * Ucdp submission complete txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// UCDP submission complete text
	public static WebElement ucdpSubmissionComplete_txt(WebDriver driver){
		element = driver.findElement(By.id("divMessageOK"));
		return element;
	}
	
	/**
	 * Ucdp submission complete txt.
	 *
	 * @return the string
	 */
	public static String ucdpSubmissionComplete_txt(){
		id = "divMessageOK";
		return id;
	}
	
	/**
	 * Ok btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// OK button
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
	 * Confirm change txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Confirm Change text
	public static WebElement confirmChange_txt(WebDriver driver){
		element = driver.findElement(By.id("divMessageOKText"));
		return element;
	}
	
	/**
	 * Confirm change txt.
	 *
	 * @return the string
	 */
	public static String confirmChange_txt(){
		id = "divMessageOKText";
		return id;
	}
	
	/**
	 * Ucdp submission failed txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Message OK Dialog text
	public static WebElement ucdpSubmissionFailed_txt(WebDriver driver){
		element = driver.findElement(By.id("divMessageOK"));
		return element;
	}
	
	/**
	 * Ucdp submission failed txt.
	 *
	 * @return the string
	 */
	public static String ucdpSubmissionFailed_txt(){
		id = "divMessageOK";
		return id;
	}
	
	/**
	 * Ucdp doc file I D txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// UCDP Doc File ID textbox
	public static WebElement ucdpDocFileID_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_txtDocumentFileID"));
		return element;
	}
	
	/**
	 * Ucdp doc file I D txtbx.
	 *
	 * @return the string
	 */
	public static String ucdpDocFileID_txtbx(){
		id = "Dialogs_Dialogs_txtDocumentFileID";
		return id;
	}
	
	/**
	 * Ok UCDP doc file I D btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// UCDP Doc File ID OK button
	public static WebElement okUCDPDocFileID_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ctl35"));
		return element;
	}
	
	/**
	 * Ok UCDP doc file I D btn.
	 *
	 * @return the string
	 */
	public static String okUCDPDocFileID_btn(){
		id = "Dialogs_Dialogs_ctl35";
		return id;
	}
	
	/**
	 * Ok UCDP appraisal file location btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// UCDP appraisal file location OK button
	public static WebElement okUCDPAppraisalFileLocation_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_ctl01"));
		return element;
	}
	
	/**
	 * Ok UCDP appraisal file location btn.
	 *
	 * @return the string
	 */
	public static String okUCDPAppraisalFileLocation_btn(){
		id = "Main_ctl01";
		return id;
	}
	
	/**
	 * Ok UCDP appraisal file location txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// UCDP appraisal file location text
	public static WebElement okUCDPAppraisalFileLocation_txt(WebDriver driver){
		element = driver.findElement(By.id("divDescription"));
		return element;
	}
	
	/**
	 * Ok UCDP appraisal file location txt.
	 *
	 * @return the string
	 */
	public static String okUCDPAppraisalFileLocation_txt(){
		id = "divDescription";
		return id;
	}
	
	/**
	 * Appraisal check.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Appraisal check
	public static WebElement appraisal_check(WebDriver driver){
		element = driver.findElement(By.cssSelector("td > img[src='/images/Checkmark-Small-Unchecked.O.png']"));
		return element;
	}
	
	/**
	 * Appraisal check.
	 *
	 * @return the string
	 */
	public static String appraisal_check(){
		cssSelector = "td > img[src='/images/Checkmark-Small-Unchecked.O.png']";
		return cssSelector;
	}
	
}
