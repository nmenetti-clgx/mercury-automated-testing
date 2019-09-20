package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure Data Courier Upload PDF page
 */
public class SDataCourierUploadPDF {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;

	
	/**
	 * Address txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Address textbox
	public static WebElement address_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_txtSubjectAddress"));
		return element;
	}
	
	/**
	 * Address txtbx.
	 *
	 * @return the string
	 */
	public static String address_txtbx(){
		id = "Dialogs_Dialogs_txtSubjectAddress";
		return id;
	}
	
	/**
	 * City txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// City textbox
	public static WebElement city_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_txtCity"));
		return element;
	}
	
	/**
	 * City txtbx.
	 *
	 * @return the string
	 */
	public static String city_txtbx(){
		id = "Dialogs_Dialogs_txtCity";
		return id;
	}
	
	/**
	 * State dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// State dropdown
	public static WebElement state_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ddlState"));
		return element;
	}
	
	/**
	 * State dropdown.
	 *
	 * @return the string
	 */
	public static String state_dropdown(){
		id = "Dialogs_Dialogs_ddlState";
		return id;
	}
	
	/**
	 * Zip txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Zip textbox
	public static WebElement zip_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_txtZip"));
		return element;
	}
	
	/**
	 * Zip txtbx.
	 *
	 * @return the string
	 */
	public static String zip_txtbx(){
		id = "Dialogs_Dialogs_txtZip";
		return id;
	}
	
	/**
	 * Neighborhood txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Neighborhood textbox
	public static WebElement neighborhood_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_txtNeighborhood"));
		return element;
	}
	
	/**
	 * Neighborhood txtbx.
	 *
	 * @return the string
	 */
	public static String neighborhood_txtbx(){
		id = "Dialogs_Dialogs_txtNeighborhood";
		return id;
	}
	
	/**
	 * Sale price txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Sale Price textbox
	public static WebElement salePrice_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_txtSalePrice"));
		return element;
	}
	
	/**
	 * Sale price txtbx.
	 *
	 * @return the string
	 */
	public static String salePrice_txtbx(){
		id = "Dialogs_Dialogs_txtSalePrice";
		return id;
	}
	
	/**
	 * Product dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Product dropdown
	public static WebElement product_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ddlProduct"));
		return element;
	}
	
	/**
	 * Product dropdown.
	 *
	 * @return the string
	 */
	public static String product_dropdown(){
		id = "Dialogs_Dialogs_ddlProduct";
		return id;
	}
	
	/**
	 * Loan type dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Loan Type dropdown
	public static WebElement loanType_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ddlLoanType"));
		return element;
	}
	
	/**
	 * Loan type dropdown.
	 *
	 * @return the string
	 */
	public static String loanType_dropdown(){
		id = "Dialogs_Dialogs_ddlLoanType";
		return id;
	}
	
	/**
	 * Appraised value txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Appraised Value textbox
	public static WebElement appraisedValue_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_txtAppraisedValue"));
		return element;
	}
	
	/**
	 * Appraised value txtbx.
	 *
	 * @return the string
	 */
	public static String appraisedValue_txtbx(){
		id = "Dialogs_Dialogs_txtAppraisedValue";
		return id;
	}
	
	/**
	 * Appraisal date txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Appraisal Date textbox
	public static WebElement appraisalDate_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_txtAppraisalDate"));
		return element;
	}
	
	/**
	 * Appraisal date txtbx.
	 *
	 * @return the string
	 */
	public static String appraisalDate_txtbx(){
		id = "Dialogs_Dialogs_txtAppraisalDate";
		return id;
	}
	
	/**
	 * Appraisal date calendar btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Appraisal Date Calendar button
	public static WebElement appraisalDateCalendar_btn(WebDriver driver){
		element = driver.findElement(By.id("imgAppraisalDate"));
		return element;
	}
	
	/**
	 * Appraisal date calendar btn.
	 *
	 * @return the string
	 */
	public static String appraisalDateCalendar_btn(){
		id = "imgAppraisalDate";
		return id;
	}
	
	/**
	 * Assignment type dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Assignment Type dropdown
	public static WebElement assignmentType_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ddlAssignmentType"));
		return element;
	}
	
	/**
	 * Assignment type dropdown.
	 *
	 * @return the string
	 */
	public static String assignmentType_dropdown(){
		id = "Dialogs_Dialogs_ddlAssignmentType";
		return id;
	}
	
	/**
	 * Prior date txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Prior Date textbox
	public static WebElement priorDate_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_txtPriorDate"));
		return element;
	}
	
	/**
	 * Prior date txtbx.
	 *
	 * @return the string
	 */
	public static String priorDate_txtbx(){
		id = "Dialogs_Dialogs_txtPriorDate";
		return id;
	}
	
	/**
	 * Prior date calendar btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Prior Date Calendar button
	public static WebElement priorDateCalendar_btn(WebDriver driver){
		element = driver.findElement(By.id("imgPriorDate"));
		return element;
	}
	
	/**
	 * Prior date calendar btn.
	 *
	 * @return the string
	 */
	public static String priorDateCalendar_btn(){
		id = "imgPriorDate";
		return id;
	}
	
	/**
	 * Prior price txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Prior Price textbox
	public static WebElement priorPrice_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_txtPriorPrice"));
		return element;
	}
	
	/**
	 * Prior price txtbx.
	 *
	 * @return the string
	 */
	public static String priorPrice_txtbx(){
		id = "Dialogs_Dialogs_txtPriorPrice";
		return id;
	}
	
	/**
	 * Borrower name txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Borrower Name textbox
	public static WebElement borrowerName_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_txtBorrowerName"));
		return element;
	}
	
	/**
	 * Borrower name txtbx.
	 *
	 * @return the string
	 */
	public static String borrowerName_txtbx(){
		id = "Dialogs_Dialogs_txtBorrowerName";
		return id;
	}
	
	/**
	 * Appraiser name txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Appraiser Name textbox
	public static WebElement appraiserName_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_txtAppraiserName"));
		return element;
	}
	
	/**
	 * Appraiser name txtbx.
	 *
	 * @return the string
	 */
	public static String appraiserName_txtbx(){
		id = "Dialogs_Dialogs_txtAppraiserName";
		return id;
	}
	
	/**
	 * Lender name txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Lender Name textbox
	public static WebElement lenderName_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_txtLenderName"));
		return element;
	}
	
	/**
	 * Lender name txtbx.
	 *
	 * @return the string
	 */
	public static String lenderName_txtbx(){
		id = "Dialogs_Dialogs_txtLenderName";
		return id;
	}
	
	/**
	 * Lender address txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Lender Address textbox
	public static WebElement lenderAddress_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_txtLenderAddress"));
		return element;
	}
	
	/**
	 * Lender address txtbx.
	 *
	 * @return the string
	 */
	public static String lenderAddress_txtbx(){
		id = "Dialogs_Dialogs_txtLenderAddress";
		return id;
	}
	
	/**
	 * Lender city txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Lender City textbox
	public static WebElement lenderCity_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_txtLenderCity"));
		return element;
	}
	
	/**
	 * Lender city txtbx.
	 *
	 * @return the string
	 */
	public static String lenderCity_txtbx(){
		id = "Dialogs_Dialogs_txtLenderCity";
		return id;
	}
	
	/**
	 * Lender state dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Lender State dropdown
	public static WebElement lenderState_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ddlLenderState"));
		return element;
	}
	
	/**
	 * Lender state dropdown.
	 *
	 * @return the string
	 */
	public static String lenderState_dropdown(){
		id = "Dialogs_Dialogs_ddlLenderState";
		return id;
	}
	
	/**
	 * Lender zip txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Lender Zip textbox
	public static WebElement lenderZip_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_txtLenderZip"));
		return element;
	}
	
	/**
	 * Lender zip txtbx.
	 *
	 * @return the string
	 */
	public static String lenderZip_txtbx(){
		id = "Dialogs_Dialogs_txtLenderZip";
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
		element = driver.findElement(By.id("Dialogs_Dialogs_btnSTBCancel"));
		return element;
	}
	
	/**
	 * Cancel btn.
	 *
	 * @return the string
	 */
	public static String cancel_btn(){
		id = "Dialogs_Dialogs_btnSTBCancel";
		return id;
	}
	
	/**
	 * Creates the file btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Create File button
	public static WebElement createFile_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_btnCreateFile"));
		return element;
	}
	
	/**
	 * Creates the file btn.
	 *
	 * @return the string
	 */
	public static String createFile_btn(){
		id = "Dialogs_Dialogs_btnCreateFile";
		return id;
	}
	
	/**
	 * Calendar month txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Calendar month text
	public static WebElement calendarMonth_txt(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_calPopUp_lblHeaderMonth"));
		return element;
	}
	
	/**
	 * Calendar month txt.
	 *
	 * @return the string
	 */
	public static String calendarMonth_txt(){
		id = "Dialogs_Dialogs_calPopUp_lblHeaderMonth";
		return id;
	}
	
	/**
	 * Calendar next month btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Calendar month text
	public static WebElement calendarNextMonth_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_calPopUp_imgCalendarChangeRight"));
		return element;
	}
	
	/**
	 * Calendar next month btn.
	 *
	 * @return the string
	 */
	public static String calendarNextMonth_btn(){
		id = "Dialogs_Dialogs_calPopUp_imgCalendarChangeRight";
		return id;
	}
	
	/**
	 * Calendar previous month btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Calendar month text
	public static WebElement calendarPreviousMonth_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_calPopUp_imgCalendarChangeLeft"));
		return element;
	}
	
	/**
	 * Calendar previous month btn.
	 *
	 * @return the string
	 */
	public static String calendarPreviousMonth_btn(){
		id = "Dialogs_Dialogs_calPopUp_imgCalendarChangeLeft";
		return id;
	}
	
	/**
	 * Calendar.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Calendar ID
	public static WebElement calendar(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_calPopUp_tblControl"));
		return element;
	}
	
	/**
	 * Calendar.
	 *
	 * @return the string
	 */
	public static String calendar(){
		id = "Dialogs_Dialogs_calPopUp_tblControl";
		return id;
	}
	
	/**
	 * Creates the PDF overlay.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Data Courier Create PDF overlay
	public static WebElement createPDFOverlay(WebDriver driver){
		element = driver.findElement(By.id("divUploadPDF"));
		return element;
	}
	
	/**
	 * Creates the PDF overlay.
	 *
	 * @return the string
	 */
	public static String createPDFOverlay(){
		id = "divUploadPDF";
		return id;
	}
	
}
