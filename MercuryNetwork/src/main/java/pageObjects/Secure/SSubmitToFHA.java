package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure Submit to FHA page
 */
public class SSubmitToFHA {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	/** The css selector. */
	private static String cssSelector = null;

	
	/**
	 * Business unit dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Business unit dropdown
	public static WebElement businessUnit_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Main_ddlEADBusinessUnits"));
		return element;
	}
	
	/**
	 * Business unit dropdown.
	 *
	 * @return the string
	 */
	public static String businessUnit_dropdown(){
		id = "Main_ddlEADBusinessUnits";
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
		element = driver.findElement(By.id("Main_txtEADLoanNumber"));
		return element;
	}
	
	/**
	 * Loan number txtbx.
	 *
	 * @return the string
	 */
	public static String loanNumber_txtbx(){
		id = "Main_txtEADLoanNumber";
		return id;
	}
	
	/**
	 * Fha case number txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// FHA Case number textbox
	public static WebElement fhaCaseNumber_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_txtEADCaseNumber"));
		return element;
	}
	
	/**
	 * Fha case number txtbx.
	 *
	 * @return the string
	 */
	public static String fhaCaseNumber_txtbx(){
		id = "Main_txtEADCaseNumber";
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
		element = driver.findElement(By.id("Main_txtEADNotes"));
		return element;
	}
	
	/**
	 * Internal notes txtbx.
	 *
	 * @return the string
	 */
	public static String internalNotes_txtbx(){
		id = "Main_txtEADNotes";
		return id;
	}
	
//	// Update status on VMP XSite checkbox
//	public static WebElement updateStatusOnVMPXSite_chkbx(WebDriver driver){
//		element = driver.findElement(By.id("Main_chkUCDPSyncStatus"));
//		return element;
//	}
//	public static String updateStatusOnVMPXSite_chkbx(){
//		id = "Main_chkUCDPSyncStatus";
//		return id;
//	}
	
	/**
 * Send btn.
 *
 * @param driver the driver
 * @return the web element
 */
// Send button
	public static WebElement send_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_btnSubmit"));
		return element;
	}
	
	/**
	 * Send btn.
	 *
	 * @return the string
	 */
	public static String send_btn(){
		id = "Main_btnSubmit";
		return id;
	}
	
	/**
	 * Fha submission failed txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// FHA submission failed text
	public static WebElement fhaSubmissionFailed_txt(WebDriver driver){
		element = driver.findElement(By.id("divMessageOK"));
		return element;
	}
	
	/**
	 * Fha submission failed txt.
	 *
	 * @return the string
	 */
	public static String fhaSubmissionFailed_txt(){
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
		element = driver.findElement(By.id("divMessageOK"));
		return element;
	}
	
	/**
	 * Confirm change txt.
	 *
	 * @return the string
	 */
	public static String confirmChange_txt(){
		id = "divMessageOK";
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
	 * Fha doc file I D txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// FHA Doc File ID textbox
	public static WebElement fhaDocFileID_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_txtEADDocumentFileID"));
		return element;
	}
	
	/**
	 * Fha doc file I D txtbx.
	 *
	 * @return the string
	 */
	public static String fhaDocFileID_txtbx(){
		id = "Dialogs_Dialogs_txtEADDocumentFileID";
		return id;
	}
	
	/**
	 * Ok FHA doc file I D btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// FHA Doc File ID OK button
	public static WebElement okFHADocFileID_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_sbEADDocumentFileIDOK"));
		return element;
	}
	
	/**
	 * Ok FHA doc file I D btn.
	 *
	 * @return the string
	 */
	public static String okFHADocFileID_btn(){
		id = "Dialogs_Dialogs_sbEADDocumentFileIDOK";
		return id;
	}
	
	/**
	 * Ok FHA appraisal file location btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// FHA appraisal file location OK button
	public static WebElement okFHAAppraisalFileLocation_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_ctl01"));
		return element;
	}
	
	/**
	 * Ok FHA appraisal file location btn.
	 *
	 * @return the string
	 */
	public static String okFHAAppraisalFileLocation_btn(){
		id = "Main_ctl01";
		return id;
	}
	
	/**
	 * Ok UCDP appraisal file location txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// FHA appraisal file location text
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
	
	/**
	 * Appraisal check.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Appraisal check
	public static WebElement submitToFha_dlg(WebDriver driver){
		element = driver.findElement(By.cssSelector("#form1 > div.DialogTitle"));
		return element;
	}
	
	/**
	 * Appraisal check.
	 *
	 * @return the string
	 */
	public static String submitToFha_dlg(){
		cssSelector = "#form1 > div.DialogTitle";
		return cssSelector;
}
	
}
