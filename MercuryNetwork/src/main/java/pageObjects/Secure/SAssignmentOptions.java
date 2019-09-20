package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure Assignment Options page
 */
public class SAssignmentOptions {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;

	
	/**
	 * Appraisal update inspection of repairs chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Appraisal Update/Inspection of Repairs checkbox
	public static WebElement appraisalUpdateInspectionOfRepairs_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_Dialogs_cgpAssignSupplementalOrders_chkItems_0"));
		return element;
	}
	
	/**
	 * Appraisal update inspection of repairs chkbx.
	 *
	 * @return the string
	 */
	public static String appraisalUpdateInspectionOfRepairs_chkbx(){
		id = "Dialogs_Dialogs_Dialogs_cgpAssignSupplementalOrders_chkItems_0";
		return id;
	}
	
	/**
	 * Construction inspection report chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Construction Inspection Report checkbox
	public static WebElement constructionInspectionReport_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_Dialogs_cgpAssignSupplementalOrders_chkItems_1"));
		return element;
	}
	
	/**
	 * Construction inspection report chkbx.
	 *
	 * @return the string
	 */
	public static String constructionInspectionReport_chkbx(){
		id = "Dialogs_Dialogs_Dialogs_cgpAssignSupplementalOrders_chkItems_1";
		return id;
	}
	
	/**
	 * Appraisal update recertification chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Appraisal Update/Recertification checkbox
	public static WebElement appraisalUpdateRecertification_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_Dialogs_cgpAssignSupplementalOrders_chkItems_2"));
		return element;
	}
	
	/**
	 * Appraisal update recertification chkbx chkbx.
	 *
	 * @return the string
	 */
	public static String appraisalUpdateRecertification_chkbx_chkbx(){
		id = "Dialogs_Dialogs_Dialogs_cgpAssignSupplementalOrders_chkItems_2";
		return id;
	}
	
	/**
	 * Comparable rent schedule chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Comparable Rent Schedule checkbox
	public static WebElement comparableRentSchedule_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_Dialogs_cgpAssignSupplementalOrders_chkItems_3"));
		return element;
	}
	
	/**
	 * Comparable rent schedule chkbx chkbx.
	 *
	 * @return the string
	 */
	public static String comparableRentSchedule_chkbx_chkbx(){
		id = "Dialogs_Dialogs_Dialogs_cgpAssignSupplementalOrders_chkItems_3";
		return id;
	}
	
	/**
	 * Operating income statement chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Operating Income Statement checkbox
	public static WebElement operatingIncomeStatement_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_Dialogs_cgpAssignSupplementalOrders_chkItems_4"));
		return element;
	}
	
	/**
	 * Operating income statement chkbx chkbx.
	 *
	 * @return the string
	 */
	public static String operatingIncomeStatement_chkbx_chkbx(){
		id = "Dialogs_Dialogs_Dialogs_cgpAssignSupplementalOrders_chkItems_4";
		return id;
	}
	
	/**
	 * Comparable rent schedule with operating income statement chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Comparable Rent Schedule w/Operating Income Statement checkbox
	public static WebElement comparableRentScheduleWithOperatingIncomeStatement_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_Dialogs_cgpAssignSupplementalOrders_chkItems_5"));
		return element;
	}
	
	/**
	 * Comparable rent schedule with operating income statement chkbx.
	 *
	 * @return the string
	 */
	public static String comparableRentScheduleWithOperatingIncomeStatement_chkbx(){
		id = "Dialogs_Dialogs_Dialogs_cgpAssignSupplementalOrders_chkItems_5";
		return id;
	}
	
	/**
	 * Fha conversion appraisal update chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// FHA Conversion Appraisal Update checkbox
	public static WebElement fhaConversionAppraisalUpdate_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_Dialogs_cgpAssignSupplementalOrders_chkItems_6"));
		return element;
	}
	
	/**
	 * Fha conversion appraisal update chkbx.
	 *
	 * @return the string
	 */
	public static String fhaConversionAppraisalUpdate_chkbx(){
		id = "Dialogs_Dialogs_Dialogs_cgpAssignSupplementalOrders_chkItems_6";
		return id;
	}
	
	/**
	 * Fha inspection chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// FHA Inspection checkbox
	public static WebElement fhaInspection_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_Dialogs_cgpAssignSupplementalOrders_chkItems_7"));
		return element;
	}
	
	/**
	 * Fha inspection chkbx.
	 *
	 * @return the string
	 */
	public static String fhaInspection_chkbx(){
		id = "Dialogs_Dialogs_Dialogs_cgpAssignSupplementalOrders_chkItems_7";
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
		element = driver.findElement(By.id("Dialogs_Dialogs_Dialogs_cgpAssignSupplementalOrders_btnCheckboxGroupPopup_OK"));
		return element;
	}
	
	/**
	 * Ok btn.
	 *
	 * @return the string
	 */
	public static String ok_btn(){
		id = "Dialogs_Dialogs_Dialogs_cgpAssignSupplementalOrders_btnCheckboxGroupPopup_OK";
		return id;
	}
	
	/**
	 * Cancel btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Cancel button
	public static WebElement cancel_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_Dialogs_cgpAssignSupplementalOrders_btnCheckboxGroupPopup_Cancel"));
		return element;
	}
	
	/**
	 * Cancel btn.
	 *
	 * @return the string
	 */
	public static String cancel_btn(){
		id = "Dialogs_Dialogs_Dialogs_cgpAssignSupplementalOrders_btnCheckboxGroupPopup_Cancel";
		return id;
	}
	
}
