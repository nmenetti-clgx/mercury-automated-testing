package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure New Order page
 */
public class SNewOrder {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	/** The css selector. */
	private static String cssSelector = null;
	
	/** The link text. */
	private static String linkText = null;

	
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
		element = driver.findElement(By.id("Main_Main_txtAddress"));
		return element;
	}
	
	/**
	 * Address txtbx.
	 *
	 * @return the string
	 */
	public static String address_txtbx(){
		id = "Main_Main_txtAddress";
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
		element = driver.findElement(By.id("Main_Main_txtCity"));
		return element;
	}
	
	/**
	 * City txtbx.
	 *
	 * @return the string
	 */
	public static String city_txtbx(){
		id = "Main_Main_txtCity";
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
		element = driver.findElement(By.id("Main_Main_ddlState"));
		return element;
	}
	
	/**
	 * State dropdown.
	 *
	 * @return the string
	 */
	public static String state_dropdown(){
		id = "Main_Main_ddlState";
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
		element = driver.findElement(By.id("Main_Main_txtZipCode"));
		return element;
	}
	
	/**
	 * Zip code txtbx.
	 *
	 * @return the string
	 */
	public static String zipCode_txtbx(){
		id = "Main_Main_txtZipCode";
		return id;
	}
	
	/**
	 * County txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// County
	public static WebElement county_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_txtCounty"));
		return element;
	}
	
	/**
	 * County txtbx.
	 *
	 * @return the string
	 */
	public static String county_txtbx(){
		id = "Main_Main_txtCounty";
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
		element = driver.findElement(By.id("Main_Main_txtSquareFeet"));
		return element;
	}
	
	/**
	 * Sq ft txtbx.
	 *
	 * @return the string
	 */
	public static String sqFt_txtbx(){
		id = "Main_Main_txtSquareFeet";
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
		element = driver.findElement(By.id("Main_Main_txtSiteSize"));
		return element;
	}
	
	/**
	 * Site size txtbx.
	 *
	 * @return the string
	 */
	public static String siteSize_txtbx(){
		id = "Main_Main_txtSiteSize";
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
		element = driver.findElement(By.id("Main_Main_ddlPropertyType"));
		return element;
	}
	
	/**
	 * Prop type dropdown.
	 *
	 * @return the string
	 */
	public static String propType_dropdown(){
		id = "Main_Main_ddlPropertyType";
		return id;
	}
	
	/**
	 * Prop rights dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Prop rights
	public static WebElement propRights_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_ddlPropertyRights"));
		return element;
	}
	
	/**
	 * Prop rights dropdown.
	 *
	 * @return the string
	 */
	public static String propRights_dropdown(){
		id = "Main_Main_ddlPropertyRights";
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
		element = driver.findElement(By.id("Main_Main_txtLegalDescription"));
		return element;
	}
	
	/**
	 * Legal desc txtbx.
	 *
	 * @return the string
	 */
	public static String legalDesc_txtbx(){
		id = "Main_Main_txtLegalDescription";
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
		element = driver.findElement(By.id("Main_Main_txtDirections"));
		return element;
	}
	
	/**
	 * Directions txtbx.
	 *
	 * @return the string
	 */
	public static String directions_txtbx(){
		id = "Main_Main_txtDirections";
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
	 * Gets the zillow report lnk.
	 *
	 * @param driver the driver
	 * @return the zillow report lnk
	 */
	// Get Zillow report link
	public static WebElement getZillowReport_lnk(WebDriver driver){
		element = driver.findElement(By.id("lnkZillow"));
		return element;
	}
	
	/**
	 * Gets the zillow report lnk.
	 *
	 * @return the zillow report lnk
	 */
	public static String getZillowReport_lnk(){
		id = "lnkZillow";
		return id;
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
		element = driver.findElement(By.id("Main_Main_ddlFormType"));
		return element;
	}
	
	/**
	 * Form dropdown.
	 *
	 * @return the string
	 */
	public static String form_dropdown(){
		id = "Main_Main_ddlFormType";
		return id;
	}
	
	/**
	 * Rush order chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Rush Order checkbox
	public static WebElement rushOrder_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_cbRushOrder"));
		return element;
	}
	
	/**
	 * Rush order chkbx.
	 *
	 * @return the string
	 */
	public static String rushOrder_chkbx(){
		id = "Main_Main_cbRushOrder";
		return id;
	}
	
	/**
	 * Complex chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Complex checkbox
	public static WebElement complex_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_cbComplexOrder"));
		return element;
	}
	
	/**
	 * Complex chkbx.
	 *
	 * @return the string
	 */
	public static String complex_chkbx(){
		id = "Main_Main_cbComplexOrder";
		return id;
	}
	
	/**
	 * Issue as bid no radiobtn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Issue as bid radio button No
	public static WebElement issueAsBidNo_radiobtn(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_rdoBidNo"));
		return element;
	}
	
	/**
	 * Issue as bid no radiobtn.
	 *
	 * @return the string
	 */
	public static String issueAsBidNo_radiobtn(){
		id = "Main_Main_rdoBidNo";
		return id;
	}
	
	/**
	 * Issue as bid yes radiobtn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Issue as bid radio button Yes
	public static WebElement issueAsBidYes_radiobtn(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_rdoBidYes"));
		return element;
	}
	
	/**
	 * Issue as bid yes radiobtn.
	 *
	 * @return the string
	 */
	public static String issueAsBidYes_radiobtn(){
		id = "Main_Main_rdoBidYes";
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
		element = driver.findElement(By.id("Main_Main_txtDueDate"));
		return element;
	}
	
	/**
	 * Order due txtbx.
	 *
	 * @return the string
	 */
	public static String orderDue_txtbx(){
		id = "Main_Main_txtDueDate";
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
		element = driver.findElement(By.id("Main_Main_imgCalendar"));
		return element;
	}
	
	/**
	 * Order due calendar btn.
	 *
	 * @return the string
	 */
	public static String orderDueCalendar_btn(){
		id = "Main_Main_imgCalendar";
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
		element = driver.findElement(By.id("Main_Main_calPopUp_tblControl"));
		return element;
	}
	
	/**
	 * Calendar.
	 *
	 * @return the string
	 */
	public static String calendar(){
		id = "Main_Main_calPopUp_tblControl";
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
		element = driver.findElement(By.id("Main_Main_calPopUp_lblHeaderMonth"));
		return element;
	}
	
	/**
	 * Calendar month txt.
	 *
	 * @return the string
	 */
	public static String calendarMonth_txt(){
		id = "Main_Main_calPopUp_lblHeaderMonth";
		return id;
	}
	
	/**
	 * Calendar month txt 2.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Calendar Month2
	public static WebElement calendarMonth_txt2(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_calPopUp_lblHeaderMonth"));
		return element;
	}
	
	/**
	 * Calendar month txt 2.
	 *
	 * @return the string
	 */
	public static String calendarMonth_txt2(){
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
		element = driver.findElement(By.id("Main_Main_calPopUp_imgCalendarChangeLeft"));
		return element;
	}
	
	/**
	 * Calendar previous month btn.
	 *
	 * @return the string
	 */
	public static String calendarPreviousMonth_btn(){
		id = "Main_Main_calPopUp_imgCalendarChangeLeft";
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
		element = driver.findElement(By.id("Main_Main_calPopUp_imgCalendarChangeRight"));
		return element;
	}
	
	/**
	 * Calendar next month btn.
	 *
	 * @return the string
	 */
	public static String calendarNextMonth_btn(){
		id = "Main_Main_calPopUp_imgCalendarChangeRight";
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
		element = driver.findElement(By.id("Main_Main_calPopUp_imgClose"));
		return element;
	}
	
	/**
	 * Calendar close btn.
	 *
	 * @return the string
	 */
	public static String calendarClose_btn(){
		id = "Main_Main_calPopUp_imgClose";
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
		element = driver.findElement(By.id("Main_Main_txtOtherRefNumber"));
		return element;
	}
	
	/**
	 * Other ref number txtbx.
	 *
	 * @return the string
	 */
	public static String otherRefNumber_txtbx(){
		id = "Main_Main_txtOtherRefNumber";
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
		element = driver.findElement(By.id("Main_Main_ddlLoanType"));
		return element;
	}
	
	/**
	 * Loan type dropdown.
	 *
	 * @return the string
	 */
	public static String loanType_dropdown(){
		id = "Main_Main_ddlLoanType";
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
		element = driver.findElement(By.id("Main_Main_ddlLoanPurpose"));
		return element;
	}
	
	/**
	 * Loan purpose dropdown.
	 *
	 * @return the string
	 */
	public static String loanPurpose_dropdown(){
		id = "Main_Main_ddlLoanPurpose";
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
		element = driver.findElement(By.id("Main_Main_txtOrderedBy"));
		return element;
	}
	
	/**
	 * Ordered by txtbx.
	 *
	 * @return the string
	 */
	public static String orderedBy_txtbx(){
		id = "Main_Main_txtOrderedBy";
		return id;
	}
	
	/**
	 * Edits the order groups lnk.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Order Group link
	public static WebElement editOrderGroups_lnk(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_EditOrderGroups"));
		return element;
	}
	
	/**
	 * Edits the order groups lnk.
	 *
	 * @return the string
	 */
	public static String editOrderGroups_lnk(){
		id = "Main_Main_EditOrderGroups";
		return id;
	}
	
	/**
	 * Adds the eligible vendors btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Add to Eligible Vendors
	public static WebElement addEligibleVendors_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#colMid_OrderGroups > div:nth-child(1) > img:nth-child(1)"));
		return element;
	}
	
	/**
	 * Adds the eligible vendors btn.
	 *
	 * @return the string
	 */
	public static String addEligibleVendors_btn(){
		cssSelector = "#colMid_OrderGroups > div:nth-child(1) > img:nth-child(1)";
		return cssSelector;
	}
	
	/**
	 * Removes the eligible vendors btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Remove from Eligible Vendors
	public static WebElement removeEligibleVendors_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#colMid_OrderGroups > div:nth-child(1) > img:nth-child(2)"));
		return element;
	}
	
	/**
	 * Removes the eligible vendors btn.
	 *
	 * @return the string
	 */
	public static String removeEligibleVendors_btn(){
		cssSelector = "#colMid_OrderGroups > div:nth-child(1) > img:nth-child(2)";
		return cssSelector;
	}
	
	/**
	 * Adds the ineligible vendors btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Add to Ineligible Vendors
	public static WebElement addIneligibleVendors_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#colMid_OrderGroups > div:nth-child(2) > img:nth-child(1)"));
		return element;
	}
	
	/**
	 * Adds the ineligible vendors btn.
	 *
	 * @return the string
	 */
	public static String addIneligibleVendors_btn(){
		cssSelector = "#colMid_OrderGroups > div:nth-child(2) > img:nth-child(1)";
		return cssSelector;
	}
	
	/**
	 * Removes the ineligible vendors btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Remove from Ineligible Vendors
	public static WebElement removeIneligibleVendors_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#colMid_OrderGroups > div:nth-child(2) > img:nth-child(2)"));
		return element;
	}
	
	/**
	 * Removes the ineligible vendors btn.
	 *
	 * @return the string
	 */
	public static String removeIneligibleVendors_btn(){
		cssSelector = "#colMid_OrderGroups > div:nth-child(2) > img:nth-child(2)";
		return cssSelector;
	}
	
	/**
	 * Cancel btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Cancel button
	public static WebElement cancel_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_btnCancel"));
		return element;
	}
	
	/**
	 * Cancel btn.
	 *
	 * @return the string
	 */
	public static String cancel_btn(){
		id = "Main_btnCancel";
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
		element = driver.findElement(By.id("Main_btnOK"));
		return element;
	}
	
	/**
	 * Ok btn.
	 *
	 * @return the string
	 */
	public static String ok_btn(){
		id = "Main_btnOK";
		return id;
	}
	
	/**
	 * Available groups grid.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Available Groups
	public static WebElement availableGroups_grid(WebDriver driver){
		element = driver.findElement(By.id("grdAvailableGroups"));
		return element;
	}
	
	/**
	 * Available groups grid.
	 *
	 * @return the string
	 */
	public static String availableGroups_grid(){
		id = "grdAvailableGroups";
		return id;
	}
	
	/**
	 * Eligible groups grid.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Eligible Vendors
	public static WebElement eligibleGroups_grid(WebDriver driver){
		element = driver.findElement(By.id("grdIncludedGroups"));
		return element;
	}
	
	/**
	 * Eligible groups grid.
	 *
	 * @return the string
	 */
	public static String eligibleGroups_grid(){
		id = "grdIncludedGroups";
		return id;
	}
	
	/**
	 * Ineligible groups grid.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Ineligible Vendors
	public static WebElement ineligibleGroups_grid(WebDriver driver){
		element = driver.findElement(By.id("grdExcludedGroups"));
		return element;
	}
	
	/**
	 * Ineligible groups grid.
	 *
	 * @return the string
	 */
	public static String ineligibleGroups_grid(){
		id = "grdExcludedGroups";
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
		element = driver.findElement(By.id("Main_Main_txtLoanNum"));
		return element;
	}
	
	/**
	 * Loan number txtbx.
	 *
	 * @return the string
	 */
	public static String loanNumber_txtbx(){
		id = "Main_Main_txtLoanNum";
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
		element = driver.findElement(By.id("Main_Main_txtFileNumber"));
		return element;
	}
	
	/**
	 * File number txtbx.
	 *
	 * @return the string
	 */
	public static String fileNumber_txtbx(){
		id = "Main_Main_txtFileNumber";
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
		element = driver.findElement(By.id("Main_Main_txtSalesPrice"));
		return element;
	}
	
	/**
	 * Sales price txtbx.
	 *
	 * @return the string
	 */
	public static String salesPrice_txtbx(){
		id = "Main_Main_txtSalesPrice";
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
		element = driver.findElement(By.id("Main_Main_txtFHA"));
		return element;
	}
	
	/**
	 * Fha case number txtbx.
	 *
	 * @return the string
	 */
	public static String fhaCaseNumber_txtbx(){
		id = "Main_Main_txtFHA";
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
		element = driver.findElement(By.id("imgCalendarDisclosureDate"));
		return element;
	}
	
	/**
	 * Disclosure calendar btn.
	 *
	 * @return the string
	 */
	public static String disclosureCalendar_btn(){
		id = "imgCalendarDisclosureDate";
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
		element = driver.findElement(By.id("Main_Main_txtDisclosureDate"));
		return element;
	}
	
	/**
	 * Disclosure txtbx.
	 *
	 * @return the string
	 */
	public static String disclosure_txtbx(){
		id = "Main_Main_txtDisclosureDate";
		return id;
	}
	
	/**
	 * Assigned to dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Assigned to
	public static WebElement assignedTo_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_ddlEmployee"));
		return element;
	}
	
	/**
	 * Assigned to dropdown.
	 *
	 * @return the string
	 */
	public static String assignedTo_dropdown(){
		id = "Main_Main_ddlEmployee";
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
		element = driver.findElement(By.id("Main_Main_txtLender"));
		return element;
	}
	
	/**
	 * Lender name txtbx.
	 *
	 * @return the string
	 */
	public static String lenderName_txtbx(){
		id = "Main_Main_txtLender";
		return id;
	}
	
	/**
	 * Lender address 1 txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Address 1
	public static WebElement lenderAddress1_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_txtLenderAddress1"));
		return element;
	}
	
	/**
	 * Lender address 1 txtbx.
	 *
	 * @return the string
	 */
	public static String lenderAddress1_txtbx(){
		id = "Main_Main_txtLenderAddress1";
		return id;
	}
	
	/**
	 * Lender address 2 txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Address 2
	public static WebElement lenderAddress2_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_txtLenderAddress2"));
		return element;
	}
	
	/**
	 * Lender address 2 txtbx.
	 *
	 * @return the string
	 */
	public static String lenderAddress2_txtbx(){
		id = "Main_Main_txtLenderAddress2";
		return id;
	}
	
	/**
	 * Lender city txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// City
	public static WebElement lenderCity_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_txtLenderCity"));
		return element;
	}
	
	/**
	 * Lender city txtbx.
	 *
	 * @return the string
	 */
	public static String lenderCity_txtbx(){
		id = "Main_Main_txtLenderCity";
		return id;
	}
	
	/**
	 * Lender state dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// State
	public static WebElement lenderState_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_ddlLenderState"));
		return element;
	}
	
	/**
	 * Lender state dropdown.
	 *
	 * @return the string
	 */
	public static String lenderState_dropdown(){
		id = "Main_Main_ddlLenderState";
		return id;
	}
	
	/**
	 * Lender zip txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Zip
	public static WebElement lenderZip_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_txtLenderZip"));
		return element;
	}
	
	/**
	 * Lender zip txtbx.
	 *
	 * @return the string
	 */
	public static String lenderZip_txtbx(){
		id = "Main_Main_txtLenderZip";
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
		element = driver.findElement(By.id("Main_Main_ddlOccupancy"));
		return element;
	}
	
	/**
	 * Occupancy dropdown.
	 *
	 * @return the string
	 */
	public static String occupancy_dropdown(){
		id = "Main_Main_ddlOccupancy";
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
		element = driver.findElement(By.id("Main_Main_txtBorrowerName"));
		return element;
	}
	
	/**
	 * Borrower txtbx.
	 *
	 * @return the string
	 */
	public static String borrower_txtbx(){
		id = "Main_Main_txtBorrowerName";
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
		element = driver.findElement(By.id("Main_Main_ddlBorrowerContactType1"));
		return element;
	}
	
	/**
	 * Borrower info 1 dropdown.
	 *
	 * @return the string
	 */
	public static String borrowerInfo1_dropdown(){
		id = "Main_Main_ddlBorrowerContactType1";
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
		element = driver.findElement(By.id("Main_Main_txtBorrowerContact1"));
		return element;
	}
	
	/**
	 * Borrower info 1 txtbx.
	 *
	 * @return the string
	 */
	public static String borrowerInfo1_txtbx(){
		id = "Main_Main_txtBorrowerContact1";
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
		element = driver.findElement(By.id("Main_Main_ddlBorrowerContactType2"));
		return element;
	}
	
	/**
	 * Borrower info 2 dropdown.
	 *
	 * @return the string
	 */
	public static String borrowerInfo2_dropdown(){
		id = "Main_Main_ddlBorrowerContactType2";
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
		element = driver.findElement(By.id("Main_Main_txtBorrowerContact2"));
		return element;
	}
	
	/**
	 * Borrower info 2 txtbx.
	 *
	 * @return the string
	 */
	public static String borrowerInfo2_txtbx(){
		id = "Main_Main_txtBorrowerContact2";
		return id;
	}
	
	/**
	 * Borrower address btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Borrower Address button
	public static WebElement borrowerAddress_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#Contacts > div:nth-child(2) > div:nth-child(7) > img:nth-child(1)"));
		return element;
	}
	
	/**
	 * Borrower address btn.
	 *
	 * @return the string
	 */
	public static String borrowerAddress_btn(){
		cssSelector = "#Contacts > div:nth-child(2) > div:nth-child(7) > img:nth-child(1)";
		return cssSelector;
	}
	
	/**
	 * Same as property address chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Same as subject property address checkbox
	public static WebElement sameAsPropertyAddress_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_cbUsePropertyAddress"));
		return element;
	}
	
	/**
	 * Same as property address chkbx.
	 *
	 * @return the string
	 */
	public static String sameAsPropertyAddress_chkbx(){
		id = "Dialogs_Dialogs_cbUsePropertyAddress";
		return id;
	}
	
	/**
	 * Borrower address txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Borrower Address
	public static WebElement borrowerAddress_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_txtBorrowerAddress"));
		return element;
	}
	
	/**
	 * Borrower address txtbx.
	 *
	 * @return the string
	 */
	public static String borrowerAddress_txtbx(){
		id = "Dialogs_Dialogs_txtBorrowerAddress";
		return id;
	}
	
	/**
	 * Borrower city txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Borrower City
	public static WebElement borrowerCity_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_txtBorrowerCity"));
		return element;
	}
	
	/**
	 * Borrower city txtbx.
	 *
	 * @return the string
	 */
	public static String borrowerCity_txtbx(){
		id = "Dialogs_Dialogs_txtBorrowerCity";
		return id;
	}
	
	/**
	 * Borrower state txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Borrower State
	public static WebElement borrowerState_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_txtBorrowerState"));
		return element;
	}
	
	/**
	 * Borrower state txtbx.
	 *
	 * @return the string
	 */
	public static String borrowerState_txtbx(){
		id = "Dialogs_Dialogs_txtBorrowerState";
		return id;
	}
	
	/**
	 * Borrower zip txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Borrower Zip
	public static WebElement borrowerZip_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_txtBorrowerZip"));
		return element;
	}
	
	/**
	 * Borrower zip txtbx.
	 *
	 * @return the string
	 */
	public static String borrowerZip_txtbx(){
		id = "Dialogs_Dialogs_txtBorrowerZip";
		return id;
	}
	
	/**
	 * Borrower cancel btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Cancel button
	public static WebElement borrowerCancel_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ctl00"));
		return element;
	}
	
	/**
	 * Borrower cancel btn.
	 *
	 * @return the string
	 */
	public static String borrowerCancel_btn(){
		id = "Dialogs_Dialogs_ctl00";
		return id;
	}
	
	/**
	 * Borrower save btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Save button
	public static WebElement borrowerSave_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ctl01"));
		return element;
	}
	
	/**
	 * Borrower save btn.
	 *
	 * @return the string
	 */
	public static String borrowerSave_btn(){
		id = "Dialogs_Dialogs_ctl01";
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
		element = driver.findElement(By.id("Main_Main_txtCoBorrowerName"));
		return element;
	}
	
	/**
	 * Co borrower txtbx.
	 *
	 * @return the string
	 */
	public static String coBorrower_txtbx(){
		id = "Main_Main_txtCoBorrowerName";
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
		element = driver.findElement(By.id("Main_Main_ddlCoBorrowerContactType1"));
		return element;
	}
	
	/**
	 * Co borrower info 1 dropdown.
	 *
	 * @return the string
	 */
	public static String coBorrowerInfo1_dropdown(){
		id = "Main_Main_ddlCoBorrowerContactType1";
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
		element = driver.findElement(By.id("Main_Main_txtCoBorrowerContact1"));
		return element;
	}
	
	/**
	 * Co borrower info 1 txtbx.
	 *
	 * @return the string
	 */
	public static String coBorrowerInfo1_txtbx(){
		id = "Main_Main_txtCoBorrowerContact1";
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
		element = driver.findElement(By.id("Main_Main_ddlCoBorrowerContactType2"));
		return element;
	}
	
	/**
	 * Co borrower info 2 dropdown.
	 *
	 * @return the string
	 */
	public static String coBorrowerInfo2_dropdown(){
		id = "Main_Main_ddlCoBorrowerContactType2";
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
		element = driver.findElement(By.id("Main_Main_txtCoBorrowerContact2"));
		return element;
	}
	
	/**
	 * Co borrower info 2 txtbx.
	 *
	 * @return the string
	 */
	public static String coBorrowerInfo2_txtbx(){
		id = "Main_Main_txtCoBorrowerContact2";
		return id;
	}
	
	/**
	 * Co borrower address btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Co-Borrower Address button
	public static WebElement coBorrowerAddress_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#Contacts > div:nth-child(3) > div:nth-child(7) > img:nth-child(1)"));
		return element;
	}
	
	/**
	 * Co borrower address btn.
	 *
	 * @return the string
	 */
	public static String coBorrowerAddress_btn(){
		cssSelector = "#Contacts > div:nth-child(3) > div:nth-child(7) > img:nth-child(1)";
		return cssSelector;
	}
	
	/**
	 * Co borrower same as subject property address chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Same as subject property address checkbox
	public static WebElement coBorrowerSameAsSubjectPropertyAddress_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_cbUseBorrowerAddress"));
		return element;
	}
	
	/**
	 * Co borrower same as subject property address chkbx.
	 *
	 * @return the string
	 */
	public static String coBorrowerSameAsSubjectPropertyAddress_chkbx(){
		id = "Dialogs_Dialogs_cbUseBorrowerAddress";
		return id;
	}
	
	/**
	 * Co borrower address txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Co-Borrower Address
	public static WebElement coBorrowerAddress_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_txtCoBorrowerAddress"));
		return element;
	}
	
	/**
	 * Co borrower address txtbx.
	 *
	 * @return the string
	 */
	public static String coBorrowerAddress_txtbx(){
		id = "Dialogs_Dialogs_txtCoBorrowerAddress";
		return id;
	}
	
	/**
	 * Co borrower city txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Co-Borrower City
	public static WebElement coBorrowerCity_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_txtCoBorrowerCity"));
		return element;
	}
	
	/**
	 * Co borrower city txtbx.
	 *
	 * @return the string
	 */
	public static String coBorrowerCity_txtbx(){
		id = "Dialogs_Dialogs_txtCoBorrowerCity";
		return id;
	}
	
	/**
	 * Co borrower state txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Co-Borrower State
	public static WebElement coBorrowerState_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_txtCoBorrowerState"));
		return element;
	}
	
	/**
	 * Co borrower state txtbx.
	 *
	 * @return the string
	 */
	public static String coBorrowerState_txtbx(){
		id = "Dialogs_Dialogs_txtCoBorrowerState";
		return id;
	}
	
	/**
	 * Co borrower zip txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Co-Borrower Zip
	public static WebElement coBorrowerZip_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_txtCoBorrowerZip"));
		return element;
	}
	
	/**
	 * Co borrower zip txtbx.
	 *
	 * @return the string
	 */
	public static String coBorrowerZip_txtbx(){
		id = "Dialogs_Dialogs_txtCoBorrowerZip";
		return id;
	}
	
	/**
	 * Co borrower cancel btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Cancel button
	public static WebElement coBorrowerCancel_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ctl02"));
		return element;
	}
	
	/**
	 * Co borrower cancel btn.
	 *
	 * @return the string
	 */
	public static String coBorrowerCancel_btn(){
		id = "Dialogs_Dialogs_ctl02";
		return id;
	}
	
	/**
	 * Co borrower save btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Save button
	public static WebElement coBorrowerSave_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ctl03"));
		return element;
	}
	
	/**
	 * Co borrower save btn.
	 *
	 * @return the string
	 */
	public static String coBorrowerSave_btn(){
		id = "Dialogs_Dialogs_ctl03";
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
		element = driver.findElement(By.id("Main_Main_txtOwner"));
		return element;
	}
	
	/**
	 * Owner txtbx.
	 *
	 * @return the string
	 */
	public static String owner_txtbx(){
		id = "Main_Main_txtOwner";
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
		element = driver.findElement(By.id("Main_Main_ddlOwner1"));
		return element;
	}
	
	/**
	 * Owner info 1 dropdown.
	 *
	 * @return the string
	 */
	public static String ownerInfo1_dropdown(){
		id = "Main_Main_ddlOwner1";
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
		element = driver.findElement(By.id("Main_Main_txtOwnerContact1"));
		return element;
	}
	
	/**
	 * Owner info 1 txtbx.
	 *
	 * @return the string
	 */
	public static String ownerInfo1_txtbx(){
		id = "Main_Main_txtOwnerContact1";
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
		element = driver.findElement(By.id("Main_Main_ddlOwner2"));
		return element;
	}
	
	/**
	 * Owner info 2 dropdown.
	 *
	 * @return the string
	 */
	public static String ownerInfo2_dropdown(){
		id = "Main_Main_ddlOwner2";
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
		element = driver.findElement(By.id("Main_Main_txtOwnerContact2"));
		return element;
	}
	
	/**
	 * Owner info 2 txtbx.
	 *
	 * @return the string
	 */
	public static String ownerInfo2_txtbx(){
		id = "Main_Main_txtOwnerContact2";
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
		element = driver.findElement(By.id("Main_Main_txtOcc"));
		return element;
	}
	
	/**
	 * Occupant txtbx.
	 *
	 * @return the string
	 */
	public static String occupant_txtbx(){
		id = "Main_Main_txtOcc";
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
		element = driver.findElement(By.id("Main_Main_ddlOcc1"));
		return element;
	}
	
	/**
	 * Occupant info 1 dropdown.
	 *
	 * @return the string
	 */
	public static String occupantInfo1_dropdown(){
		id = "Main_Main_ddlOcc1";
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
		element = driver.findElement(By.id("Main_Main_txtOccContact1"));
		return element;
	}
	
	/**
	 * Occupant info 1 txtbx.
	 *
	 * @return the string
	 */
	public static String occupantInfo1_txtbx(){
		id = "Main_Main_txtOccContact1";
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
		element = driver.findElement(By.id("Main_Main_ddlOcc2"));
		return element;
	}
	
	/**
	 * Occupant info 2 dropdown.
	 *
	 * @return the string
	 */
	public static String occupantInfo2_dropdown(){
		id = "Main_Main_ddlOcc2";
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
		element = driver.findElement(By.id("Main_Main_txtOccContact2"));
		return element;
	}
	
	/**
	 * Occupant info 2 txtbx.
	 *
	 * @return the string
	 */
	public static String occupantInfo2_txtbx(){
		id = "Main_Main_txtOccContact2";
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
		element = driver.findElement(By.id("Main_Main_txtAgent"));
		return element;
	}
	
	/**
	 * Agent txtbx.
	 *
	 * @return the string
	 */
	public static String agent_txtbx(){
		id = "Main_Main_txtAgent";
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
		element = driver.findElement(By.id("Main_Main_ddlAgent1"));
		return element;
	}
	
	/**
	 * Agent info 1 dropdown.
	 *
	 * @return the string
	 */
	public static String agentInfo1_dropdown(){
		id = "Main_Main_ddlAgent1";
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
		element = driver.findElement(By.id("Main_Main_txtAgentContact1"));
		return element;
	}
	
	/**
	 * Agent info 1 txtbx.
	 *
	 * @return the string
	 */
	public static String agentInfo1_txtbx(){
		id = "Main_Main_txtAgentContact1";
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
		element = driver.findElement(By.id("Main_Main_ddlAgent2"));
		return element;
	}
	
	/**
	 * Agent info 2 dropdown.
	 *
	 * @return the string
	 */
	public static String agentInfo2_dropdown(){
		id = "Main_Main_ddlAgent2";
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
		element = driver.findElement(By.id("Main_Main_txtAgentContact2"));
		return element;
	}
	
	/**
	 * Agent info 2 txtbx.
	 *
	 * @return the string
	 */
	public static String agentInfo2_txtbx(){
		id = "Main_Main_txtAgentContact2";
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
		element = driver.findElement(By.id("Main_Main_txtOtherName"));
		return element;
	}
	
	/**
	 * Other txtbx.
	 *
	 * @return the string
	 */
	public static String other_txtbx(){
		id = "Main_Main_txtOtherName";
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
		element = driver.findElement(By.id("Main_Main_ddlOtherType1"));
		return element;
	}
	
	/**
	 * Other info 1 dropdown.
	 *
	 * @return the string
	 */
	public static String otherInfo1_dropdown(){
		id = "Main_Main_ddlOtherType1";
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
		element = driver.findElement(By.id("Main_Main_txtOtherContact1"));
		return element;
	}
	
	/**
	 * Other info 1 txtbx.
	 *
	 * @return the string
	 */
	public static String otherInfo1_txtbx(){
		id = "Main_Main_txtOtherContact1";
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
		element = driver.findElement(By.id("Main_Main_ddlOtherType2"));
		return element;
	}
	
	/**
	 * Other info 2 dropdown.
	 *
	 * @return the string
	 */
	public static String otherInfo2_dropdown(){
		id = "Main_Main_ddlOtherType2";
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
		element = driver.findElement(By.id("Main_Main_txtOtherContact2"));
		return element;
	}
	
	/**
	 * Other info 2 txtbx.
	 *
	 * @return the string
	 */
	public static String otherInfo2_txtbx(){
		id = "Main_Main_txtOtherContact2";
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
		element = driver.findElement(By.id("Main_Main_ddlAppointmentContact"));
		return element;
	}
	
	/**
	 * Appt contact dropdown.
	 *
	 * @return the string
	 */
	public static String apptContact_dropdown(){
		id = "Main_Main_ddlAppointmentContact";
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
		element = driver.findElement(By.id("Main_Main_txtAdditionalNotificationRecipients"));
		return element;
	}
	
	/**
	 * Additional email recipients txtbx.
	 *
	 * @return the string
	 */
	public static String additionalEmailRecipients_txtbx(){
		id = "Main_Main_txtAdditionalNotificationRecipients";
		return id;
	}
	
	/**
	 * Attach completed report chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Attach completed report
	public static WebElement attachCompletedReport_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_chkAttachCompletedReport"));
		return element;
	}
	
	/**
	 * Attach completed report chkbx.
	 *
	 * @return the string
	 */
	public static String attachCompletedReport_chkbx(){
		id = "Main_Main_chkAttachCompletedReport";
		return id;
	}
	
	/**
	 * Click here lnk.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Click here for more information
	public static WebElement clickHere_lnk(WebDriver driver){
		element = driver.findElement(By.linkText("Click here"));
		return element;
	}
	
	/**
	 * Click here lnk.
	 *
	 * @return the string
	 */
	public static String clickHere_lnk(){
		linkText = "Click here";
		return linkText;
	}
	
	/**
	 * Click here O K btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Click here dialog box OK button
	public static WebElement clickHereOK_btn(WebDriver driver){
		element = driver.findElement(By.id("sbdmButton1"));
		return element;
	}
	
	/**
	 * Click here O K btn.
	 *
	 * @return the string
	 */
	public static String clickHereOK_btn(){
		id = "sbdmButton1";
		return id;
	}
	
	/**
	 * Click here txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Click Here dialog box text
	public static WebElement clickHere_txt(WebDriver driver){
		element = driver.findElement(By.id("divMessageOKText"));
		return element;
	}
	
	/**
	 * Click here txt.
	 *
	 * @return the string
	 */
	public static String clickHere_txt(){
		id = "divMessageOKText";
		return id;
	}
	
	/**
	 * Next btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Next button
	public static WebElement next_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_sbNext2"));
		return element;
	}
	
	/**
	 * Next btn.
	 *
	 * @return the string
	 */
	public static String next_btn(){
		id = "Main_Main_sbNext2";
		return id;
	}
	
	/**
	 * Next top btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Next button at the top of the page when duplicating an order
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
	 * Vmp comments txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// VMP Comments
	public static WebElement vmpComments_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_txtVMPComments"));
		return element;
	}
	
	/**
	 * Vmp comments txtbx.
	 *
	 * @return the string
	 */
	public static String vmpComments_txtbx(){
		id = "Main_Main_txtVMPComments";
		return id;
	}
	
	/**
	 * Save top btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Top Save button
	public static WebElement saveTop_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/App_Themes/FlatGrayscale/Icons/Save.O.png']"));
		return element;
	}
	
	/**
	 * Save top btn.
	 *
	 * @return the string
	 */
	public static String saveTop_btn(){
		cssSelector = "img[src='/App_Themes/FlatGrayscale/Icons/Save.O.png']";
		return cssSelector;
	}
	
	/**
	 * Vmp comments chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// VMP Comments checkbox (Update client dialog box)
	public static WebElement vmpComments_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_chkVMPChangedItems_0"));
		return element;
	}
	
	/**
	 * Vmp comments chkbx.
	 *
	 * @return the string
	 */
	public static String vmpComments_chkbx(){
		id = "Dialogs_Dialogs_chkVMPChangedItems_0";
		return id;
	}
	
	/**
	 * Ok update client btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// OK button (Update client dialog box)
	public static WebElement okUpdateClient_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_btnSendVMPChangesOK"));
		return element;
	}
	
	/**
	 * Ok update client btn.
	 *
	 * @return the string
	 */
	public static String okUpdateClient_btn(){
		id = "Dialogs_Dialogs_btnSendVMPChangesOK";
		return id;
	}
	
	/**
	 * Order fee txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Order fee text box
	public static WebElement orderFee_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_txtOrderFee"));
		return element;
	}
	
	/**
	 * Order fee txtbx.
	 *
	 * @return the string
	 */
	public static String orderFee_txtbx(){
		id = "Main_Main_txtOrderFee";
		return id;
	}
	
	/**
	 * Due date chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Due Date checkbox
	public static WebElement dueDate_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_chkVMPChangedItems_0"));
		return element;
	}
	
	/**
	 * Due date chkbx.
	 *
	 * @return the string
	 */
	public static String dueDate_chkbx(){
		id = "Dialogs_Dialogs_chkVMPChangedItems_0";
		return id;
	}
	
	/**
	 * Fee chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Fee checkbox
	public static WebElement fee_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_chkVMPChangedItems_1"));
		return element;
	}
	
	/**
	 * Fee chkbx.
	 *
	 * @return the string
	 */
	public static String fee_chkbx(){
		id = "Dialogs_Dialogs_chkVMPChangedItems_1";
		return id;
	}
	
	/**
	 * Change due date calendar btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Change Due Date Calendar button
	public static WebElement changeDueDateCalendar_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[onclick='imgChangedDueDateCalendar_click(event);']"));
		return element;
	}
	
	/**
	 * Change due date calendar btn.
	 *
	 * @return the string
	 */
	public static String changeDueDateCalendar_btn(){
		cssSelector = "img[onclick='imgChangedDueDateCalendar_click(event);']";
		return cssSelector;
	}
	
	/**
	 * Change due date set date btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Set date button (Change Due Date dialog box)
	public static WebElement changeDueDateSetDate_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_sbChangeDueDateSetDate"));
		return element;
	}
	
	/**
	 * Change due date set date btn.
	 *
	 * @return the string
	 */
	public static String changeDueDateSetDate_btn(){
		id = "Dialogs_Dialogs_sbChangeDueDateSetDate";	
		return id;
	}
	
	/**
	 * Change due date comments txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Change due date comments textbox
	public static WebElement changeDueDateComments_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ctlChangeDueDateMessage_txtMessage"));
		return element;
	}
	
	/**
	 * Change due date comments txtbx.
	 *
	 * @return the string
	 */
	public static String changeDueDateComments_txtbx(){
		id = "Dialogs_Dialogs_ctlChangeDueDateMessage_txtMessage";
		return id;
	}
	
	/**
	 * Update due date on VMPX site chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Update the due date on VMP XSite checkbox
	public static WebElement updateDueDateOnVMPXSite_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_chkUpdateVMPChangeDueDate"));
		return element;
	}
	
	/**
	 * Update due date on VMPX site chkbx.
	 *
	 * @return the string
	 */
	public static String updateDueDateOnVMPXSite_chkbx(){
		id = "Dialogs_Dialogs_chkUpdateVMPChangeDueDate";
		return id;
	}
	
	/**
	 * New fee txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// New Fee textbox
	public static WebElement newFee_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_txtChangeFee"));
		return element;
	}
	
	/**
	 * New fee txtbx.
	 *
	 * @return the string
	 */
	public static String newFee_txtbx(){
		id = "Dialogs_Dialogs_txtChangeFee";
		return id;
	}
	
	/**
	 * Sets the fee btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Set fee button (Change Due Date dialog box)
	public static WebElement setFee_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_sbChangeFeeSetFee"));
		return element;
	}
	
	/**
	 * Sets the fee btn.
	 *
	 * @return the string
	 */
	public static String setFee_btn(){
		id = "Dialogs_Dialogs_sbChangeFeeSetFee";
		return id;
	}
	
	/**
	 * Change fee comments txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Change fee comments textbox
	public static WebElement changeFeeComments_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ctlChangeFee_txtMessage"));
		return element;
	}
	
	/**
	 * Change fee comments txtbx.
	 *
	 * @return the string
	 */
	public static String changeFeeComments_txtbx(){
		id = "Dialogs_Dialogs_ctlChangeFee_txtMessage";
		return id;
	}
	
	/**
	 * Sets the status txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Set Status text
	public static WebElement setStatus_txt(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_mbMain_3"));
		return element;
	}
	
	/**
	 * Sets the status txt.
	 *
	 * @return the string
	 */
	public static String setStatus_txt(){
		id = "Main_Main_mbMain_3";
		return id;
	}
	
	/**
	 * Change due date as AM C btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Change due date as AMC button
	public static WebElement changeDueDateAsAMC_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#Main_Main_mbMain_3 > table > tbody > tr:nth-child(13) > td.MenuBar_Menu_Item_Label"));
		return element;
	}
	
	/**
	 * Change due date as AM C btn.
	 *
	 * @return the string
	 */
	public static String changeDueDateAsAMC_btn(){
		cssSelector = "#Main_Main_mbMain_3 > table > tbody > tr:nth-child(13) > td.MenuBar_Menu_Item_Label";
		return cssSelector;
	}
	
	/**
	 * Change fee as AM C btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Change fee as AMC button
	public static WebElement changeFeeAsAMC_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#Main_Main_mbMain_3 > table > tbody > tr:nth-child(14) > td.MenuBar_Menu_Item_Label"));
		return element;
	}
	
	/**
	 * Change fee as AM C btn.
	 *
	 * @return the string
	 */
	public static String changeFeeAsAMC_btn(){
		cssSelector = "#Main_Main_mbMain_3 > table > tbody > tr:nth-child(14) > td.MenuBar_Menu_Item_Label";
		return cssSelector;
	}
	
	/**
	 * Change due date as lender btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Change due date as Lender button
	public static WebElement changeDueDateAsLender_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#Main_Main_mbMain_3 > table > tbody > tr:nth-child(11)"));
		return element;
	}
	
	/**
	 * Change due date as lender btn.
	 *
	 * @return the string
	 */
	public static String changeDueDateAsLender_btn(){
		cssSelector = "#Main_Main_mbMain_3 > table > tbody > tr:nth-child(11)";
		return cssSelector;
	}
	
	/**
	 * Change fee as lender btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Change fee as Lender button
	public static WebElement changeFeeAsLender_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#Main_Main_mbMain_3 > table > tbody > tr:nth-child(12)"));
		return element;
	}
	
	/**
	 * Change fee as lender btn.
	 *
	 * @return the string
	 */
	public static String changeFeeAsLender_btn(){
		cssSelector = "#Main_Main_mbMain_3 > table > tbody > tr:nth-child(12)";
		return cssSelector;
	}
	
	/**
	 * Ok vendor assignment btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// OK Vendor Assignment button
	public static WebElement okVendorAssignment_btn(WebDriver driver){
		element = driver.findElement(By.id("sbdmButton1"));
		return element;
	}
	
	/**
	 * Ok vendor assignment btn.
	 *
	 * @return the string
	 */
	public static String okVendorAssignment_btn(){
		id = "sbdmButton1";
		return id;
	}
	
	/**
	 * Vendor assignment dialog txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Vendor Assignment dialog text
	public static WebElement vendorAssignmentDialog_txt(WebDriver driver){
		element = driver.findElement(By.id("divMessageOKText"));
		return element;
	}
	
	/**
	 * Vendor assignment dialog txt.
	 *
	 * @return the string
	 */
	public static String vendorAssignmentDialog_txt(){
		id = "divMessageOKText";
		return id;
	}
	
	/**
	 * Product requirements txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Product Requirements textbox
	public static WebElement productRequirements_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_txtProductRequirements"));
		return element;
	}
	
	/**
	 * Product requirements txtbx.
	 *
	 * @return the string
	 */
	public static String productRequirements_txtbx(){
		id = "Main_Main_txtProductRequirements";
		return id;
	}
	
	/**
	 * Additional comments txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Additional comments or instructions to vendor textbox
	public static WebElement additionalComments_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_txtAdditionalComments"));
		return element;
	}
	
	/**
	 * Additional comments txtbx.
	 *
	 * @return the string
	 */
	public static String additionalComments_txtbx(){
		id = "Main_Main_txtAdditionalComments";
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
		element = driver.findElement(By.id("Main_Main_txtFHADocumentFileID"));
		return element;
	}
	
	/**
	 * Fha doc file I D txtbx.
	 *
	 * @return the string
	 */
	public static String fhaDocFileID_txtbx(){
		id = "Main_Main_txtFHADocumentFileID";
		return id;
	}
	
	/**
	 * Appraised txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Appraised textbox
	public static WebElement appraised_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_txtAppraisedValue"));
		return element;
	}
	
	/**
	 * Appraised txtbx.
	 *
	 * @return the string
	 */
	public static String appraised_txtbx(){
		id = "Main_Main_txtAppraisedValue";
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
		element = driver.findElement(By.id("Main_Main_txtUCDPDocumentFileID"));
		return element;
	}
	
	/**
	 * Ucdp doc file I D txtbx.
	 *
	 * @return the string
	 */
	public static String ucdpDocFileID_txtbx(){
		id = "Main_Main_txtUCDPDocumentFileID";
		return id;
	}
	
	/**
	 * Bid lock group.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Bid Lock group
	public static WebElement bidLock_group(WebDriver driver){
		element = driver.findElement(By.id("divBidLocks"));
		return element;
	}
	
	/**
	 * Bid lock group.
	 *
	 * @return the string
	 */
	public static String bidLock_group(){
		id = "divBidLocks";
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
		element = driver.findElement(By.id("Main_Main_ctlCC_ddlPaymentMethod"));
		return element;
	}
	
	/**
	 * Payment method dropdown.
	 *
	 * @return the string
	 */
	public static String paymentMethod_dropdown(){
		id = "Main_Main_ctlCC_ddlPaymentMethod";
		return id;
	}
	
	/**
	 * Calendar display.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// calendarDisplay
	public static WebElement calendarDisplay(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_calPopUp_divControl"));
		return element;
	}
	
	/**
	 * Calendar display.
	 *
	 * @return the string
	 */
	public static String calendarDisplay(){
		id = "Main_Main_calPopUp_divControl";
		return id;
	}
	
	/**
	 * Modify selection settings btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// modifySelectionSettings_btn
	public static WebElement modifySelectionSettings_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/App_Themes/FlatGrayscale/Icons/Gear.O.png']"));
		return element;
	}
	
	/**
	 * Modify selection settings btn.
	 *
	 * @return the string
	 */
	public static String modifySelectionSettings_btn(){
		cssSelector = "img[src='/App_Themes/FlatGrayscale/Icons/Gear.O.png']";
		return cssSelector;
	}
	
	/**
	 * Map display.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// calendarDisplay
	public static WebElement mapDisplay(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_ctlAnalytics_divMapError"));
		return element;
	}
	
	/**
	 * Map display.
	 *
	 * @return the string
	 */
	public static String mapDisplay(){
		id = "Main_Main_ctlAnalytics_divMapError";
		return id;
	}
	
	/**
	 * Auto Assign text.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Auto Assign text
	public static WebElement autoAssign_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector("#form1 > div.DialogTitle"));
		return element;
	}
	
	/**
	 * Auto Assign text.
	 *
	 * @return the string
	 */
	public static String autoAssign_txt(){
		cssSelector = "#form1 > div.DialogTitle";
		return cssSelector;
	}
	
	/**
	 * Auto Assign textbox.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Auto Assign textbox
	public static WebElement autoAssignApprove_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_ctl02"));
		return element;
	}
	
	/**
	 * Auto Assign textbox.
	 *
	 * @return the string
	 */
	public static String autoAssignApprove_btn(){
		id = "Main_ctl02";
		return id;
	}

	// Pay Transaction Fee CheckBox
	public static WebElement payTransactionFee_chkbx(WebDriver driver){
		element = driver.findElement(By.id("chkPayTransaction"));
		return element;
	}

	/**
	 * Pay Transaction Fee CheckBox.
	 *
	 * @return the string
	 */
	public static String payTransactionFee_chkbx(){
		id = "chkPayTransaction";
		return id;
	}

	// Pay Transaction Fee CheckBox Message
	public static WebElement payTransactionFee_txt(WebDriver driver){
		element = driver.findElement(By.id("divTransactionMessage"));
		return element;
	}

	/**
	 * Pay Transaction Fee CheckBox Message
	 *
	 * @return the string
	 */
	public static String payTransactionFee_txt(){
		id = "divTransactionMessage";
		return id;
	}

	// Pay Transaction Fee Second Check box
	public static WebElement payTransactionFeesecond_txtbx(WebDriver driver){
		element = driver.findElement(By.id("chkPaymentNoticeAgree"));
		return element;
	}

	/**
	 * Pay Transaction Fee Second Checkbox
	 *
	 * @return the string
	 */
	public static String payTransactionFeesecond_txtbx(){
		id = "chkPaymentNoticeAgree";
		return id;
	}
}