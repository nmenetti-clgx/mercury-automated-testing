package pageObjects.VMP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the VMP New Order page
 */
public class VMPNewOrder {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	/** The css selector. */
	private static String cssSelector = null;

	
	/**
	 * ****************************
	 * 	Property Information
	 * ****************************.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	
	// Address
	public static WebElement address_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtAddress"));
		return element;
	}
	
	/**
	 * Address txtbx.
	 *
	 * @return the string
	 */
	public static String address_txtbx(){
		id = "ctl00_ctl00_Main_Main_txtAddress";
		return id;
	}
	
	/**
	 * City txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// City
	public static WebElement city_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtCity"));
		return element;
	}
	
	/**
	 * City txtbx.
	 *
	 * @return the string
	 */
	public static String city_txtbx(){
		id = "ctl00_ctl00_Main_Main_txtCity";
		return id;
	}
	
	/**
	 * State dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// State
	public static WebElement state_dropdown(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_ddlState"));
		return element;
	}
	
	/**
	 * State dropdown.
	 *
	 * @return the string
	 */
	public static String state_dropdown(){
		id = "ctl00_ctl00_Main_Main_ddlState";
		return id;
	}
	
	/**
	 * Zip code txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Zip Code
	public static WebElement zipCode_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtZip"));
		return element;
	}
	
	/**
	 * Zip code txtbx.
	 *
	 * @return the string
	 */
	public static String zipCode_txtbx(){
		id = "ctl00_ctl00_Main_Main_txtZip";
		return id;
	}
	
	/**
	 * Sq ft txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Sq ft
	public static WebElement sqFt_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtSquareFootage"));
		return element;
	}
	
	/**
	 * Sq ft txtbx.
	 *
	 * @return the string
	 */
	public static String sqFt_txtbx(){
		id = "ctl00_ctl00_Main_Main_txtSquareFootage";
		return id;
	}
	
	/**
	 * Site size txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Site size
	public static WebElement siteSize_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtSiteSize"));
		return element;
	}
	
	/**
	 * Site size txtbx.
	 *
	 * @return the string
	 */
	public static String siteSize_txtbx(){
		id = "ctl00_ctl00_Main_Main_txtSiteSize";
		return id;
	}
	
	/**
	 * Prop type dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Prop type
	public static WebElement propType_dropdown(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_ddlPropertyType"));
		return element;
	}
	
	/**
	 * Prop type dropdown.
	 *
	 * @return the string
	 */
	public static String propType_dropdown(){
		id = "ctl00_ctl00_Main_Main_ddlPropertyType";
		return id;
	}
	
	/**
	 * Legal desc txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Legal desc
	public static WebElement legalDesc_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtLegalDescription"));
		return element;
	}
	
	/**
	 * Legal desc txtbx.
	 *
	 * @return the string
	 */
	public static String legalDesc_txtbx(){
		id = "ctl00_ctl00_Main_Main_txtLegalDescription";
		return id;
	}
	
	/**
	 * Directions txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Directions
	public static WebElement directions_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtDirections"));
		return element;
	}
	
	/**
	 * Directions txtbx.
	 *
	 * @return the string
	 */
	public static String directions_txtbx(){
		id = "ctl00_ctl00_Main_Main_txtDirections";
		return id;
	}
	
	/**
	 * Map rotate left btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Map rotate left button
	public static WebElement mapRotateLeft_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("a.NavBar_rotateLeft"));
		return element;
	}
	
	/**
	 * Map rotate left btn.
	 *
	 * @return the string
	 */
	public static String mapRotateLeft_btn(){
		cssSelector = "a.NavBar_rotateLeft";
		return cssSelector;
	}
	
	/**
	 * Map compass btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Map compass button
	public static WebElement mapCompass_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("a.NavBar_compassN"));
		return element;
	}
	
	/**
	 * Map compass btn.
	 *
	 * @return the string
	 */
	public static String mapCompass_btn(){
		cssSelector = "a.NavBar_compassN";
		return cssSelector;
	}
	
	/**
	 * Map rotate right btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Map rotate right button
	public static WebElement mapRotateRight_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("a.NavBar_rotateRight"));
		return element;
	}
	
	/**
	 * Map rotate right btn.
	 *
	 * @return the string
	 */
	public static String mapRotateRight_btn(){
		cssSelector = "a.NavBar_rotateRight";
		return cssSelector;
	}
	
	/**
	 * Map zoom out btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Map zoom out button
	public static WebElement mapZoomOut_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("a.NavBar_zoomOut"));
		return element;
	}
	
	/**
	 * Map zoom out btn.
	 *
	 * @return the string
	 */
	public static String mapZoomOut_btn(){
		cssSelector = "a.NavBar_zoomOut";
		return cssSelector;
	}
	
	/**
	 * Map zoom in btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Map zoom in button
	public static WebElement mapZoomIn_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("a.NavBar_zoomIn"));
		return element;
	}
	
	/**
	 * Map zoom in btn.
	 *
	 * @return the string
	 */
	public static String mapZoomIn_btn(){
		cssSelector = "a.NavBar_zoomIn";
		return cssSelector;
	}
	
	/**
	 * Map automatic dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Map automatic dropdown
	public static WebElement mapAutomatic_dropdown(WebDriver driver){
		element = driver.findElement(By.cssSelector("a.NavBar_MapType_auto"));
		return element;
	}
	
	/**
	 * Map automatic dropdown.
	 *
	 * @return the string
	 */
	public static String mapAutomatic_dropdown(){
		cssSelector = "a.NavBar_MapType_auto";
		return cssSelector;
	}
	
	/**
	 * Map road btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Map road button
	public static WebElement mapRoad_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("a.NavBar_itemContainer_r"));
		return element;
	}
	
	/**
	 * Map road btn.
	 *
	 * @return the string
	 */
	public static String mapRoad_btn(){
		cssSelector = "a.NavBar_itemContainer_r";
		return cssSelector;
	}
	
	/**
	 * Map automatic btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Map automatic button
	public static WebElement mapAutomatic_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("a.NavBar_itemContainer_auto"));
		return element;
	}
	
	/**
	 * Map automatic btn.
	 *
	 * @return the string
	 */
	public static String mapAutomatic_btn(){
		cssSelector = "a.NavBar_itemContainer_auto";
		return cssSelector;
	}
	
	/**
	 * Map birds eye btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Map birds eye button
	public static WebElement mapBirdsEye_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("a.NavBar_itemContainer_be"));
		return element;
	}
	
	/**
	 * Map birds eye btn.
	 *
	 * @return the string
	 */
	public static String mapBirdsEye_btn(){
		cssSelector = "a.NavBar_itemContainer_be";
		return cssSelector;
	}
	
	/**
	 * ****************************
	 * 	Assignment Information
	 * ****************************.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	
	// Form/type
	public static WebElement form_dropdown(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_ddlFormType"));
		return element;
	}
	
	/**
	 * Form dropdown.
	 *
	 * @return the string
	 */
	public static String form_dropdown(){
		id = "ctl00_ctl00_Main_Main_ddlFormType";
		return id;
	}
	
	/**
	 * Order due txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Order Due
	public static WebElement orderDue_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtDueDate"));
		return element;
	}
	
	/**
	 * Order due txtbx.
	 *
	 * @return the string
	 */
	public static String orderDue_txtbx(){
		id = "ctl00_ctl00_Main_Main_txtDueDate";
		return id;
	}
	
	/**
	 * Order due calendar btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Order Due Calendar button
	public static WebElement orderDueCalendar_btn(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_imgCalendar"));
		return element;
	}
	
	/**
	 * Order due calendar btn.
	 *
	 * @return the string
	 */
	public static String orderDueCalendar_btn(){
		id = "ctl00_ctl00_Main_Main_imgCalendar";
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
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_calPopUp_tblControl"));
		return element;
	}
	
	/**
	 * Calendar.
	 *
	 * @return the string
	 */
	public static String calendar(){
		id = "ctl00_ctl00_Main_Main_calPopUp_tblControl";
		return id;
	}
	
	/**
	 * Calendar month txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Calendar Month
	public static WebElement calendarMonth_txt(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_calPopUp_lblHeaderMonth"));
		return element;
	}
	
	/**
	 * Calendar month txt.
	 *
	 * @return the string
	 */
	public static String calendarMonth_txt(){
		id = "ctl00_ctl00_Main_Main_calPopUp_lblHeaderMonth";
		return id;
	}
	
	/**
	 * Calendar previous month btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Calendar Previous Month
	public static WebElement calendarPreviousMonth_btn(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_calPopUp_imgCalendarChangeLeft"));
		return element;
	}
	
	/**
	 * Calendar previous month btn.
	 *
	 * @return the string
	 */
	public static String calendarPreviousMonth_btn(){
		id = "ctl00_ctl00_Main_Main_calPopUp_imgCalendarChangeLeft";
		return id;
	}
	
	/**
	 * Calendar next month btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Calendar Next Month
	public static WebElement calendarNextMonth_btn(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_calPopUp_imgCalendarChangeRight"));
		return element;
	}
	
	/**
	 * Calendar next month btn.
	 *
	 * @return the string
	 */
	public static String calendarNextMonth_btn(){
		id = "ctl00_ctl00_Main_Main_calPopUp_imgCalendarChangeRight";
		return id;
	}
	
	/**
	 * Calendar close btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Calendar Close
	public static WebElement calendarClose_btn(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_calPopUp_imgClose"));
		return element;
	}
	
	/**
	 * Calendar close btn.
	 *
	 * @return the string
	 */
	public static String calendarClose_btn(){
		id = "ctl00_ctl00_Main_Main_calPopUp_imgClose";
		return id;
	}
	
	/**
	 * Other ref number txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Other ref#
	public static WebElement otherRefNumber_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtOtherRefNumber"));
		return element;
	}
	
	/**
	 * Other ref number txtbx.
	 *
	 * @return the string
	 */
	public static String otherRefNumber_txtbx(){
		id = "ctl00_ctl00_Main_Main_txtOtherRefNumber";
		return id;
	}
	
	/**
	 * Loan type dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Loan Type
	public static WebElement loanType_dropdown(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_ddlLoanType"));
		return element;
	}
	
	/**
	 * Loan type dropdown.
	 *
	 * @return the string
	 */
	public static String loanType_dropdown(){
		id = "ctl00_ctl00_Main_Main_ddlLoanType";
		return id;
	}
	
	/**
	 * Loan purpose dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Loan Purpose
	public static WebElement loanPurpose_dropdown(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_ddlLoanPurpose"));
		return element;
	}
	
	/**
	 * Loan purpose dropdown.
	 *
	 * @return the string
	 */
	public static String loanPurpose_dropdown(){
		id = "ctl00_ctl00_Main_Main_ddlLoanPurpose";
		return id;
	}
	
	/**
	 * Ordered by txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Ordered By
	public static WebElement orderedBy_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtOrderedBy"));
		return element;
	}
	
	/**
	 * Ordered by txtbx.
	 *
	 * @return the string
	 */
	public static String orderedBy_txtbx(){
		id = "ctl00_ctl00_Main_Main_txtOrderedBy";
		return id;
	}
	
	/**
	 * Account exec dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Account Exec. dropdown
	public static WebElement accountExec_dropdown(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_ddlAccountExec"));
		return element;
	}
	
	/**
	 * Account exec dropdown.
	 *
	 * @return the string
	 */
	public static String accountExec_dropdown(){
		id = "ctl00_ctl00_Main_Main_ddlAccountExec";
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
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtLoanNumber"));
		return element;
	}
	
	/**
	 * Loan number txtbx.
	 *
	 * @return the string
	 */
	public static String loanNumber_txtbx(){
		id = "ctl00_ctl00_Main_Main_txtLoanNumber";
		return id;
	}
	
	/**
	 * File number txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// File #
	public static WebElement fileNumber_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtFileNumber"));
		return element;
	}
	
	/**
	 * File number txtbx.
	 *
	 * @return the string
	 */
	public static String fileNumber_txtbx(){
		id = "ctl00_ctl00_Main_Main_txtFileNumber";
		return id;
	}
	
	/**
	 * Sales price txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Sales Price
	public static WebElement salesPrice_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtSalesPrice"));
		return element;
	}
	
	/**
	 * Sales price txtbx.
	 *
	 * @return the string
	 */
	public static String salesPrice_txtbx(){
		id = "ctl00_ctl00_Main_Main_txtSalesPrice";
		return id;
	}
	
	/**
	 * Fha case number txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// FHA case #
	public static WebElement fhaCaseNumber_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtFHANumber"));
		return element;
	}
	
	/**
	 * Fha case number txtbx.
	 *
	 * @return the string
	 */
	public static String fhaCaseNumber_txtbx(){
		id = "ctl00_ctl00_Main_Main_txtFHANumber";
		return id;
	}
	
	/**
	 * Disclosure calendar btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Disclosure Calendar
	public static WebElement disclosureCalendar_btn(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_img1"));
		return element;
	}
	
	/**
	 * Disclosure calendar btn.
	 *
	 * @return the string
	 */
	public static String disclosureCalendar_btn(){
		id = "ctl00_ctl00_Main_Main_img1";
		return id;
	}
	
	/**
	 * Disclosure txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Disclosure
	public static WebElement disclosure_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtDisclosureDate"));
		return element;
	}
	
	/**
	 * Disclosure txtbx.
	 *
	 * @return the string
	 */
	public static String disclosure_txtbx(){
		id = "ctl00_ctl00_Main_Main_txtDisclosureDate";
		return id;
	}
	
	/**
	 * ****************************
	 * 	Lender Information
	 * ****************************.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	
	// Lender Name
	public static WebElement lenderName_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtLender"));
		return element;
	}
	
	/**
	 * Lender name txtbx.
	 *
	 * @return the string
	 */
	public static String lenderName_txtbx(){
		id = "ctl00_ctl00_Main_Main_txtLender";
		return id;
	}
	
	/**
	 * Lender address 1 txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Lender Street
	public static WebElement lenderAddress1_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtLenderStreet"));
		return element;
	}
	
	/**
	 * Lender address 1 txtbx.
	 *
	 * @return the string
	 */
	public static String lenderAddress1_txtbx(){
		id = "ctl00_ctl00_Main_Main_txtLenderStreet";
		return id;
	}
	
	/**
	 * Lender city txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Lender City
	public static WebElement lenderCity_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtLenderCity"));
		return element;
	}
	
	/**
	 * Lender city txtbx.
	 *
	 * @return the string
	 */
	public static String lenderCity_txtbx(){
		id = "ctl00_ctl00_Main_Main_txtLenderCity";
		return id;
	}
	
	/**
	 * Lender state dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Lender State
	public static WebElement lenderState_dropdown(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_ddlLenderState"));
		return element;
	}
	
	/**
	 * Lender state dropdown.
	 *
	 * @return the string
	 */
	public static String lenderState_dropdown(){
		id = "ctl00_ctl00_Main_Main_ddlLenderState";
		return id;
	}
	
	/**
	 * Lender zip txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Lender Zip
	public static WebElement lenderZip_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtLenderZip"));
		return element;
	}
	
	/**
	 * Lender zip txtbx.
	 *
	 * @return the string
	 */
	public static String lenderZip_txtbx(){
		id = "ctl00_ctl00_Main_Main_txtLenderZip";
		return id;
	}
	
	/**
	 * **************************************
	 * 	Contact and access  Information
	 * **************************************.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	
	// Occupancy
	public static WebElement occupancy_dropdown(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_ddlOccupancy"));
		return element;
	}
	
	/**
	 * Occupancy dropdown.
	 *
	 * @return the string
	 */
	public static String occupancy_dropdown(){
		id = "ctl00_ctl00_Main_Main_ddlOccupancy";
		return id;
	}
	
	/**
	 * Borrower txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Borrower
	public static WebElement borrower_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtBorrowerName"));
		return element;
	}
	
	/**
	 * Borrower txtbx.
	 *
	 * @return the string
	 */
	public static String borrower_txtbx(){
		id = "ctl00_ctl00_Main_Main_txtBorrowerName";
		return id;
	}
	
	/**
	 * Borrower info 1 dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Borrower Info 1 Dropdown
	public static WebElement borrowerInfo1_dropdown(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_ddlBorrowerContactType1"));
		return element;
	}
	
	/**
	 * Borrower info 1 dropdown.
	 *
	 * @return the string
	 */
	public static String borrowerInfo1_dropdown(){
		id = "ctl00_ctl00_Main_Main_ddlBorrowerContactType1";
		return id;
	}
	
	/**
	 * Borrower info 1 txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Borrower Info 1
	public static WebElement borrowerInfo1_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtBorrowerContact1"));
		return element;
	}
	
	/**
	 * Borrower info 1 txtbx.
	 *
	 * @return the string
	 */
	public static String borrowerInfo1_txtbx(){
		id = "ctl00_ctl00_Main_Main_txtBorrowerContact1";
		return id;
	}
	
	/**
	 * Borrower info 2 dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Borrower Info 2 dropdown
	public static WebElement borrowerInfo2_dropdown(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_ddlBorrowerContactType2"));
		return element;
	}
	
	/**
	 * Borrower info 2 dropdown.
	 *
	 * @return the string
	 */
	public static String borrowerInfo2_dropdown(){
		id = "ctl00_ctl00_Main_Main_ddlBorrowerContactType2";
		return id;
	}
	
	/**
	 * Borrower info 2 txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Borrower Info 2
	public static WebElement borrowerInfo2_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtBorrowerContact2"));
		return element;
	}
	
	/**
	 * Borrower info 2 txtbx.
	 *
	 * @return the string
	 */
	public static String borrowerInfo2_txtbx(){
		id = "ctl00_ctl00_Main_Main_txtBorrowerContact2";
		return id;
	}
	
	/**
	 * Co borrower txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Co-Borrower
	public static WebElement coBorrower_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtCoBorrowerName"));
		return element;
	}
	
	/**
	 * Co borrower txtbx.
	 *
	 * @return the string
	 */
	public static String coBorrower_txtbx(){
		id = "ctl00_ctl00_Main_Main_txtCoBorrowerName";
		return id;
	}
	
	/**
	 * Co borrower info 1 dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Co-Borrower Info 1 dropdown
 	public static WebElement coBorrowerInfo1_dropdown(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_ddlCoBorrowerContactType1"));
		return element;
	}
	
	/**
	 * Co borrower info 1 dropdown.
	 *
	 * @return the string
	 */
	public static String coBorrowerInfo1_dropdown(){
		id = "ctl00_ctl00_Main_Main_ddlCoBorrowerContactType1";
		return id;
	}
	
	/**
	 * Co borrower info 1 txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Co-Borrower Info 1
	public static WebElement coBorrowerInfo1_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtCoBorrowerContact1"));
		return element;
	}
	
	/**
	 * Co borrower info 1 txtbx.
	 *
	 * @return the string
	 */
	public static String coBorrowerInfo1_txtbx(){
		id = "ctl00_ctl00_Main_Main_txtCoBorrowerContact1";
		return id;
	}
	
	/**
	 * Co borrower info 2 dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Co-Borrower Info 2 dropdown
	public static WebElement coBorrowerInfo2_dropdown(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_ddlCoBorrowerContactType2"));
		return element;
	}
	
	/**
	 * Co borrower info 2 dropdown.
	 *
	 * @return the string
	 */
	public static String coBorrowerInfo2_dropdown(){
		id = "ctl00_ctl00_Main_Main_ddlCoBorrowerContactType2";
		return id;
	}
	
	/**
	 * Co borrower info 2 txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Co-Borrower Info 2
	public static WebElement coBorrowerInfo2_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtCoBorrowerContact2"));
		return element;
	}
	
	/**
	 * Co borrower info 2 txtbx.
	 *
	 * @return the string
	 */
	public static String coBorrowerInfo2_txtbx(){
		id = "ctl00_ctl00_Main_Main_txtCoBorrowerContact2";
		return id;
	}
	
	/**
	 * Owner txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Owner
	public static WebElement owner_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtOwnerName"));
		return element;
	}
	
	/**
	 * Owner txtbx.
	 *
	 * @return the string
	 */
	public static String owner_txtbx(){
		id = "ctl00_ctl00_Main_Main_txtOwnerName";
		return id;
	}
	
	/**
	 * Owner info 1 dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Owner Info 1 dropdown
	public static WebElement ownerInfo1_dropdown(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_ddlOwnerContactType1"));
		return element;
	}
	
	/**
	 * Owner info 1 dropdown.
	 *
	 * @return the string
	 */
	public static String ownerInfo1_dropdown(){
		id = "ctl00_ctl00_Main_Main_ddlOwnerContactType1";
		return id;
	}
	
	/**
	 * Owner info 1 txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Owner Info 1
	public static WebElement ownerInfo1_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtOwnerContact1"));
		return element;
	}
	
	/**
	 * Owner info 1 txtbx.
	 *
	 * @return the string
	 */
	public static String ownerInfo1_txtbx(){
		id = "ctl00_ctl00_Main_Main_txtOwnerContact1";
		return id;
	}
	
	/**
	 * Owner info 2 dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Owner Info 2 dropdown
	public static WebElement ownerInfo2_dropdown(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_ddlOwnerContactType2"));
		return element;
	}
	
	/**
	 * Owner info 2 dropdown.
	 *
	 * @return the string
	 */
	public static String ownerInfo2_dropdown(){
		id = "ctl00_ctl00_Main_Main_ddlOwnerContactType2";
		return id;
	}
	
	/**
	 * Owner info 2 txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Owner Info 2
	public static WebElement ownerInfo2_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtOwnerContact2"));
		return element;
	}
	
	/**
	 * Owner info 2 txtbx.
	 *
	 * @return the string
	 */
	public static String ownerInfo2_txtbx(){
		id = "ctl00_ctl00_Main_Main_txtOwnerContact2";
		return id;
	}
	
	/**
	 * Occupant txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Occupant
	public static WebElement occupant_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtOccupantName"));
		return element;
	}
	
	/**
	 * Occupant txtbx.
	 *
	 * @return the string
	 */
	public static String occupant_txtbx(){
		id = "ctl00_ctl00_Main_Main_txtOccupantName";
		return id;
	}
	
	/**
	 * Occupant info 1 dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Occupant Info 1 dropdown
	public static WebElement occupantInfo1_dropdown(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_ddlOccupantContactType1"));
		return element;
	}
	
	/**
	 * Occupant info 1 dropdown.
	 *
	 * @return the string
	 */
	public static String occupantInfo1_dropdown(){
		id = "ctl00_ctl00_Main_Main_ddlOccupantContactType1";
		return id;
	}
	
	/**
	 * Occupant info 1 txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Occupant Info 1
	public static WebElement occupantInfo1_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtOccupantContact1"));
		return element;
	}
	
	/**
	 * Occupant info 1 txtbx.
	 *
	 * @return the string
	 */
	public static String occupantInfo1_txtbx(){
		id = "ctl00_ctl00_Main_Main_txtOccupantContact1";
		return id;
	}
	
	/**
	 * Occupant info 2 dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Occupant Info 2 dropdown
	public static WebElement occupantInfo2_dropdown(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_ddlOccupantContactType2"));
		return element;
	}
	
	/**
	 * Occupant info 2 dropdown.
	 *
	 * @return the string
	 */
	public static String occupantInfo2_dropdown(){
		id = "ctl00_ctl00_Main_Main_ddlOccupantContactType2";
		return id;
	}
	
	/**
	 * Occupant info 2 txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Occupant Info 2
	public static WebElement occupantInfo2_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtOccupantContact2"));
		return element;
	}
	
	/**
	 * Occupant info 2 txtbx.
	 *
	 * @return the string
	 */
	public static String occupantInfo2_txtbx(){
		id = "ctl00_ctl00_Main_Main_txtOccupantContact2";
		return id;
	}
	
	/**
	 * Agent txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Agent
	public static WebElement agent_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtAgentName"));
		return element;
	}
	
	/**
	 * Agent txtbx.
	 *
	 * @return the string
	 */
	public static String agent_txtbx(){
		id = "ctl00_ctl00_Main_Main_txtAgentName";
		return id;
	}
	
	/**
	 * Agent info 1 dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Agent Info 1 dropdown
	public static WebElement agentInfo1_dropdown(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_ddlAgentContactType1"));
		return element;
	}
	
	/**
	 * Agent info 1 dropdown.
	 *
	 * @return the string
	 */
	public static String agentInfo1_dropdown(){
		id = "ctl00_ctl00_Main_Main_ddlAgentContactType1";
		return id;
	}
	
	/**
	 * Agent info 1 txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Agent Info 1
	public static WebElement agentInfo1_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtAgentContact1"));
		return element;
	}
	
	/**
	 * Agent info 1 txtbx.
	 *
	 * @return the string
	 */
	public static String agentInfo1_txtbx(){
		id = "ctl00_ctl00_Main_Main_txtAgentContact1";
		return id;
	}
	
	/**
	 * Agent info 2 dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Agent Info 2 dropdown
	public static WebElement agentInfo2_dropdown(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_ddlAgentContactType2"));
		return element;
	}
	
	/**
	 * Agent info 2 dropdown.
	 *
	 * @return the string
	 */
	public static String agentInfo2_dropdown(){
		id = "ctl00_ctl00_Main_Main_ddlAgentContactType2";
		return id;
	}
	
	/**
	 * Agent info 2 txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Agent Info 2
	public static WebElement agentInfo2_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtAgentContact2"));
		return element;
	}
	
	/**
	 * Agent info 2 txtbx.
	 *
	 * @return the string
	 */
	public static String agentInfo2_txtbx(){
		id = "ctl00_ctl00_Main_Main_txtAgentContact2";
		return id;
	}
	
	/**
	 * Other txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Other
	public static WebElement other_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtOtherName"));
		return element;
	}
	
	/**
	 * Other txtbx.
	 *
	 * @return the string
	 */
	public static String other_txtbx(){
		id = "ctl00_ctl00_Main_Main_txtOtherName";
		return id;
	}
	
	/**
	 * Other info 1 dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Other Info 1 dropdown
	public static WebElement otherInfo1_dropdown(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_ddlOtherContactType1"));
		return element;
	}
	
	/**
	 * Other info 1 dropdown.
	 *
	 * @return the string
	 */
	public static String otherInfo1_dropdown(){
		id = "ctl00_ctl00_Main_Main_ddlOtherContactType1";
		return id;
	}
	
	/**
	 * Other info 1 txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Other Info 1
	public static WebElement otherInfo1_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtOtherContact1"));
		return element;
	}
	
	/**
	 * Other info 1 txtbx.
	 *
	 * @return the string
	 */
	public static String otherInfo1_txtbx(){
		id = "ctl00_ctl00_Main_Main_txtOtherContact1";
		return id;
	}
	
	/**
	 * Other info 2 dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Other Info 2 dropdown
	public static WebElement otherInfo2_dropdown(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_ddlOtherContactType2"));
		return element;
	}
	
	/**
	 * Other info 2 dropdown.
	 *
	 * @return the string
	 */
	public static String otherInfo2_dropdown(){
		id = "ctl00_ctl00_Main_Main_ddlOtherContactType2";
		return id;
	}
	
	/**
	 * Other info 2 txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Other Info 2
	public static WebElement otherInfo2_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtOtherContact2"));
		return element;
	}
	
	/**
	 * Other info 2 txtbx.
	 *
	 * @return the string
	 */
	public static String otherInfo2_txtbx(){
		id = "ctl00_ctl00_Main_Main_txtOtherContact2";
		return id;
	}
	
	/**
	 * Appt contact dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Appt. Contact dropdown
	public static WebElement apptContact_dropdown(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_ddlAppointmentContact"));
		return element;
	}
	
	/**
	 * Appt contact dropdown.
	 *
	 * @return the string
	 */
	public static String apptContact_dropdown(){
		id = "ctl00_ctl00_Main_Main_ddlAppointmentContact";
		return id;
	}
	
	/**
	 * **************************************
	 * 	Additional notification recipients
	 * **************************************.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	
	// Enter additional e-mail addresses
	public static WebElement additionalEmailRecipients_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtAdditionalRecipients"));
		return element;
	}
	
	/**
	 * Additional email recipients txtbx.
	 *
	 * @return the string
	 */
	public static String additionalEmailRecipients_txtbx(){
		id = "ctl00_ctl00_Main_Main_txtAdditionalRecipients";
		return id;
	}
	
	/**
	 * Additional comments txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Additional comments textbox
	public static WebElement additionalComments_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtAdditionalComments"));
		return element;
	}
	
	/**
	 * Additional comments txtbx.
	 *
	 * @return the string
	 */
	public static String additionalComments_txtbx(){
		id = "ctl00_ctl00_Main_Main_txtAdditionalComments";
		return id;
	}
	
	/**
	 * Next top btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Next top button
	public static WebElement nextTop_btn(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_btnNextTop"));
		return element;
	}
	
	/**
	 * Next top btn.
	 *
	 * @return the string
	 */
	public static String nextTop_btn(){
		id = "ctl00_ctl00_Main_Main_btnNextTop";
		return id;
	}
	
	/**
	 * Next bottom btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Next bottom button
	public static WebElement nextBottom_btn(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_btnNextBottom"));
		return element;
	}
	
	/**
	 * Next bottom btn.
	 *
	 * @return the string
	 */
	public static String nextBottom_btn(){
		id = "ctl00_ctl00_Main_Main_btnNextBottom";
		return id;
	}
	
	/**
	 * Payment method dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Payment Method dropdown
	public static WebElement paymentMethod_dropdown(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_ddlPaymentMethod"));
		return element;
	}
	
	/**
	 * Payment method dropdown.
	 *
	 * @return the string
	 */
	public static String paymentMethod_dropdown(){
		id = "ctl00_ctl00_Main_Main_ddlPaymentMethod";
		return id;
	}
	
	/**
	 * Order fee txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Order Fee textbox
	public static WebElement orderFee_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtFee"));
		return element;
	}
	
	/**
	 * Order fee txtbx.
	 *
	 * @return the string
	 */
	public static String orderFee_txtbx(){
		id = "ctl00_ctl00_Main_Main_txtFee";
		return id;
	}
	
	/**
	 * First name txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// firstName txtbx	
	public static WebElement firstName_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtCCFirstName"));
		return element;
	}	
	
	/**
	 * First name txtbx.
	 *
	 * @return the string
	 */
	public static String firstName_txtbx(){	
		id = "ctl00_ctl00_Main_Main_txtCCFirstName";
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
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtCCLastName"));
		return element;
	}	
	
	/**
	 * Last name txtbx.
	 *
	 * @return the string
	 */
	public static String lastName_txtbx(){	
		id = "ctl00_ctl00_Main_Main_txtCCLastName";
		return id;
	}	
		
	/**
	 * Street address txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// streetAddress txtbx	
	public static WebElement streetAddress_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtCCAddress1"));
		return element;
	}	
	
	/**
	 * Street address txtbx.
	 *
	 * @return the string
	 */
	public static String streetAddress_txtbx(){	
		id = "ctl00_ctl00_Main_Main_txtCCAddress1";
		return id;
	}	
	
	/**
	 * Street address 2 txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// streetAddress txtbx	
	public static WebElement streetAddress2_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtCCAddress2"));
		return element;
	}	
	
	/**
	 * Street address 2 txtbx.
	 *
	 * @return the string
	 */
	public static String streetAddress2_txtbx(){	
		id = "ctl00_ctl00_Main_Main_txtCCAddress2";
		return id;
	}	
		
	/**
	 * City payment method txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// city txtbx	
	public static WebElement cityPaymentMethod_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtCCCity"));
		return element;
	}	
	
	/**
	 * City payment method txtbx.
	 *
	 * @return the string
	 */
	public static String cityPaymentMethod_txtbx(){	
		id = "ctl00_ctl00_Main_Main_txtCCCity";
		return id;
	}	
		
	/**
	 * State payment method dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// state dropdown	
	public static WebElement statePaymentMethod_dropdown(WebDriver driver){	
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_ddlCCState"));
		return element;
	}	
	
	/**
	 * State payment method dropdown.
	 *
	 * @return the string
	 */
	public static String statePaymentMethod_dropdown(){	
		id = "ctl00_ctl00_Main_Main_ddlCCState";
		return id;
	}	
		
	/**
	 * Zip txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// zip txtbx	
	public static WebElement zip_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtCCZip"));
		return element;
	}	
	
	/**
	 * Zip txtbx.
	 *
	 * @return the string
	 */
	public static String zip_txtbx(){	
		id = "ctl00_ctl00_Main_Main_txtCCZip";
		return id;
	}	
		
	/**
	 * Email txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// email txtbx	
	public static WebElement email_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtCCEmail"));
		return element;
	}	
	
	/**
	 * Email txtbx.
	 *
	 * @return the string
	 */
	public static String email_txtbx(){	
		id = "ctl00_ctl00_Main_Main_txtCCEmail";
		return id;
	}
	
	/**
	 * OK button
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// email txtbx	
	public static WebElement ok_btn(WebDriver driver){	
		element = driver.findElement(By.cssSelector("input[onclick='ConfirmMismatchAddressOK_Click();']"));
		return element;
	}	
	
	/**
	 * OK button
	 *
	 * @return the string
	 */
	public static String ok_btn(){	
		cssSelector = "input[onclick='ConfirmMismatchAddressOK_Click();']";
		return cssSelector;
	}
	
	/**
	 * Cancel button
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// email txtbx	
	public static WebElement cancel_btn(WebDriver driver){	
		element = driver.findElement(By.cssSelector("input[onclick='ConfirmMismatchAddressCancel_Click();']"));
		return element;
	}	
	
	/**
	 * Cancel button
	 *
	 * @return the string
	 */
	public static String cancel_btn(){	
		cssSelector = "input[onclick='ConfirmMismatchAddressCancel_Click();']";
		return cssSelector;
	}
	
	/**
	 * Yes button
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// email txtbx	
	public static WebElement yes_btn(WebDriver driver){	
		element = driver.findElement(By.cssSelector("input[onclick='ConfirmInvalidAddressOK_Click();']"));
		return element;
	}	
	
}
