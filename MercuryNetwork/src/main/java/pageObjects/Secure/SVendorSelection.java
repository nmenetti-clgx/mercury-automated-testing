package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure Vendor Selection page
 */
public class SVendorSelection {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	/** The css selector. */
	private static String cssSelector = null;

	
//	// Related orders close button
//	public static WebElement relatedOrdersClose_btn(WebDriver driver){
//		element = driver.findElement(By.id("Main_ctl00"));
//		return element;
//	}
//	public static String relatedOrdersClose_btn(){
//		id = "Main_ctl00";
//		return id;
//	}
	
	/**
 * Related orders close btn.
 *
 * @param driver the driver
 * @return the web element
 */
// Related orders close button
	public static WebElement relatedOrdersClose_btn(WebDriver driver){
//		element = driver.findElement(By.cssSelector("div.MessageBoxButton > a#Main_ctl00"));
		element = driver.findElement(By.id("Main_ctl00"));
		return element;
	}
	
	/**
	 * Related orders close btn.
	 *
	 * @return the string
	 */
	public static String relatedOrdersClose_btn(){
		id = "Main_ctl00";
		return id;
	}
	
	/**
	 * Fee panel tab tab.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Fee Panel tab
	public static WebElement feePanelTab_tab(WebDriver driver){
		element = driver.findElement(By.id("tab0"));
		return element;
	}
	
	/**
	 * Fee panel tab tab.
	 *
	 * @return the string
	 */
	public static String feePanelTab_tab(){
		id = "tab0";
		return id;
	}
	
	/**
	 * Iss ranked tab.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// ISS ranked tab
	public static WebElement issRanked_tab(WebDriver driver){
		element = driver.findElement(By.id("tab1"));
		return element;
	}
	
	/**
	 * Iss ranked tab.
	 *
	 * @return the string
	 */
	public static String issRanked_tab(){
		id = "tab1";
		return id;
	}
	
	/**
	 * Search tab.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Search tab
	public static WebElement search_tab(WebDriver driver){
		element = driver.findElement(By.id("tab2"));
		return element;
	}
	
	/**
	 * Search tab.
	 *
	 * @return the string
	 */
	public static String search_tab(){
		id = "tab2";
		return id;
	}
	
	/**
	 * First vendor row.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// View profile link
	public static WebElement firstVendorRow(WebDriver driver){
//		element = driver.findElement(By.cssSelector("tr.IG_IsEmployee:nth-child(1) > td:nth-child(10)"));
		element = driver.findElement(By.cssSelector("tr.IG_IsEmployee:nth-child(1)"));
		return element;
	}
	
	/**
	 * First vendor row.
	 *
	 * @return the string
	 */
	public static String firstVendorRow(){
		cssSelector = "tr.IG_IsEmployee:nth-child(1)";
		return cssSelector;
	}
	
	/**
	 * Vendor name header btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Vendor name header button
	public static WebElement vendorNameHeader_btn(WebDriver driver){
		element = driver.findElement(By.id("tblFeePanel_LastName"));
		return element;
	}
	
	/**
	 * Vendor name header btn.
	 *
	 * @return the string
	 */
	public static String vendorNameHeader_btn(){
		id = "tblFeePanel_LastName";
		return id;
	}
	
	/**
	 * Sort arrow btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Sort arrow button
	public static WebElement sortArrow_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("span.ui-iggrid-colindicator:nth-child(1)"));
		return element;
	}
	
	/**
	 * Sort arrow btn.
	 *
	 * @return the string
	 */
	public static String sortArrow_btn(){
		cssSelector = "span.ui-iggrid-colindicator:nth-child(1)";
		return cssSelector;
	}
	
	/**
	 * Search tab btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Search tab button
	public static WebElement searchTab_btn(WebDriver driver){
		element = driver.findElement(By.id("tab2"));
		return element;
	}
	
	/**
	 * Search tab btn.
	 *
	 * @return the string
	 */
	public static String searchTab_btn(){
		id = "tab2";
		return id;
	}
	
	/**
	 * First name txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// First Name text box
	public static WebElement firstName_txtbx(WebDriver driver){
		element = driver.findElement(By.id("txtFirst"));
		return element;
	}
	
	/**
	 * First name txtbx.
	 *
	 * @return the string
	 */
	public static String firstName_txtbx(){
		id = "txtFirst";
		return id;
	}
	
	/**
	 * Last name txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Last Name text box
	public static WebElement lastName_txtbx(WebDriver driver){
		element = driver.findElement(By.id("txtLast"));
		return element;
	}
	
	/**
	 * Last name txtbx.
	 *
	 * @return the string
	 */
	public static String lastName_txtbx(){
		id = "txtLast";
		return id;
	}
	
	/**
	 * Company txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Company text box
	public static WebElement company_txtbx(WebDriver driver){
		element = driver.findElement(By.id("txtCompany"));
		return element;
	}
	
	/**
	 * Company txtbx.
	 *
	 * @return the string
	 */
	public static String company_txtbx(){
		id = "txtCompany";
		return id;
	}
	
	/**
	 * Address txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Address text box
	public static WebElement address_txtbx(WebDriver driver){
		element = driver.findElement(By.id("txtAddress"));
		return element;
	}
	
	/**
	 * Address txtbx.
	 *
	 * @return the string
	 */
	public static String address_txtbx(){
		id = "txtAddress";
		return id;
	}
	
	/**
	 * City txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// City text box
	public static WebElement city_txtbx(WebDriver driver){
		element = driver.findElement(By.id("txtCity"));
		return element;
	}
	
	/**
	 * City txtbx.
	 *
	 * @return the string
	 */
	public static String city_txtbx(){
		id = "txtCity";
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
		element = driver.findElement(By.id("cboStates"));
		return element;
	}
	
	/**
	 * State dropdown.
	 *
	 * @return the string
	 */
	public static String state_dropdown(){
		id = "cboStates";
		return id;
	}
	
	/**
	 * County txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// County text box
	public static WebElement county_txtbx(WebDriver driver){
		element = driver.findElement(By.id("txtCounty"));
		return element;
	}
	
	/**
	 * County txtbx.
	 *
	 * @return the string
	 */
	public static String county_txtbx(){
		id = "txtCounty";
		return id;
	}
	
	/**
	 * Zip code txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Zip Code text box
	public static WebElement zipCode_txtbx(WebDriver driver){
		element = driver.findElement(By.id("txtZip"));
		return element;
	}
	
	/**
	 * Zip code txtbx.
	 *
	 * @return the string
	 */
	public static String zipCode_txtbx(){
		id = "txtZip";
		return id;
	}
	
	/**
	 * Search in dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Search In dropdown
	public static WebElement searchIn_dropdown(WebDriver driver){
		element = driver.findElement(By.id("cboPanel"));
		return element;
	}
	
	/**
	 * Search in dropdown.
	 *
	 * @return the string
	 */
	public static String searchIn_dropdown(){
		id = "cboPanel";
		return id;
	}
	
	/**
	 * Search btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Search button
	public static WebElement search_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_sbSearch"));
		return element;
	}
	
	/**
	 * Search btn.
	 *
	 * @return the string
	 */
	public static String search_btn(){
		id = "Main_Main_sbSearch";
		return id;
	}
	
	/**
	 * Fha roster lnk.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// FHA roster link
	public static WebElement fhaRoster_lnk(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_divFHARosterLink"));
		return element;
	}
	
	/**
	 * Fha roster lnk.
	 *
	 * @return the string
	 */
	public static String fhaRoster_lnk(){
		id = "Main_Main_divFHARosterLink";
		return id;
	}
	
	/**
	 * Search results table txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Search Results Table
	public static WebElement searchResultsTable_txt(WebDriver driver){
		element = driver.findElement(By.id("tblSearch"));
		return element;
	}
	
	/**
	 * Search results table txt.
	 *
	 * @return the string
	 */
	public static String searchResultsTable_txt(){
		id = "tblSearch";
		return id;
	}
	
	/**
	 * Fee panel table txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Fee Panel Table text
	public static WebElement feePanelTable_txt(WebDriver driver){
		element = driver.findElement(By.id("tblFeePanel"));
		return element;
	}
	
	/**
	 * Fee panel table txt.
	 *
	 * @return the string
	 */
	public static String feePanelTable_txt(){
		id = "tblFeePanel";
		return id;
	}
	
	/**
	 * Fee panel table rows.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Fee Panel Table rows
	public static WebElement feePanelTable_rows(WebDriver driver){
		element = driver.findElement(By.cssSelector("#tblFeePanel > tbody > tr"));
		return element;
	}
	
	/**
	 * Fee panel table rows.
	 *
	 * @return the string
	 */
	public static String feePanelTable_rows(){
		cssSelector = "#tblFeePanel > tbody > tr";
		return cssSelector;
	}
	
	/**
	 * Vendor search result name txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Vendor search result name
	public static WebElement vendorSearchResultName_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector("#tblSearch > tbody > tr:nth-child(1) > td:nth-child(4)"));
		return element;
	}
	
	/**
	 * Vendor search result name txt.
	 *
	 * @return the string
	 */
	public static String vendorSearchResultName_txt(){
		cssSelector = "#tblSearch > tbody > tr:nth-child(1) > td:nth-child(4)";
		return cssSelector;
	}
	
	/**
	 * Back bottom btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Back bottom button
	public static WebElement backBottom_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_ctl02"));
		return element;
	}
	
	/**
	 * Back bottom btn.
	 *
	 * @return the string
	 */
	public static String backBottom_btn(){
		id = "Main_Main_ctl02";
		return id;
	}
	
	/**
	 * Back top btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Back top button
	public static WebElement backTop_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_ctl00"));
		return element;
	}
	
	/**
	 * Back top btn.
	 *
	 * @return the string
	 */
	public static String backTop_btn(){
		id = "Main_Main_ctl00";
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
		element = driver.findElement(By.id("Main_Main_ctl01"));
		return element;
	}
	
	/**
	 * Next top btn.
	 *
	 * @return the string
	 */
	public static String nextTop_btn(){
		id = "Main_Main_ctl01";
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
		element = driver.findElement(By.id("Main_Main_ctl03"));
		return element;
	}
	
	/**
	 * Next bottom btn.
	 *
	 * @return the string
	 */
	public static String nextBottom_btn(){
		id = "Main_Main_ctl03";
		return id;
	}
	
	/**
	 * Fee panel yoe first row txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Fee Panel YOE First Row text
	public static WebElement feePanelYoeFirstRow_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector("tr.IG_IsEmployee:nth-child(1) > td:nth-child(5)"));
		return element;
	}
	
	/**
	 * Fee panel yoe first row txt.
	 *
	 * @return the string
	 */
	public static String feePanelYoeFirstRow_txt(){
		cssSelector = "tr.IG_IsEmployee:nth-child(1) > td:nth-child(5)";
		return cssSelector;
	}
	
	/**
	 * Fee panel select first row btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Fee Panel Select First Row button
	public static WebElement feePanelSelectFirstRow_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("td.ui-iggrid-selectedcell:nth-child(1) > img:nth-child(1)"));
		return element;
	}
	
	/**
	 * Fee panel select first row btn.
	 *
	 * @return the string
	 */
	public static String feePanelSelectFirstRow_btn(){
		cssSelector = "td.ui-iggrid-selectedcell:nth-child(1) > img:nth-child(1)";
		return cssSelector;
	}
	
	/**
	 * View profile first row btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// View profile of first vendor button
	public static WebElement viewProfileFirstRow_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#tblFeePanel > tbody > tr > td:nth-child(2)"));
		return element;
	}
	
	/**
	 * View profile first row btn.
	 *
	 * @return the string
	 */
	public static String viewProfileFirstRow_btn(){
		cssSelector = "#tblFeePanel > tbody > tr > td:nth-child(2)";
		return cssSelector;
	}
	
	/**
	 * Vendor search result first name txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Vendor search result second name
	public static WebElement vendorSearchResultFirstName_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector("#tblFeePanel > tbody > tr:nth-child(1) > td.VendorSelectVendorName"));
		return element;
	}
	
	/**
	 * Vendor search result first name txt.
	 *
	 * @return the string
	 */
	public static String vendorSearchResultFirstName_txt(){
		cssSelector = "#tblFeePanel > tbody > tr:nth-child(1) > td.VendorSelectVendorName";
		return cssSelector;
	}
	
	/**
	 * Vendor search result second name txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Vendor search result second name
	public static WebElement vendorSearchResultSecondName_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector("#tblFeePanel > tbody > tr:nth-child(2) > td:nth-child(5)"));
		return element;
	}
	
	/**
	 * Vendor search result second name txt.
	 *
	 * @return the string
	 */
	public static String vendorSearchResultSecondName_txt(){
		cssSelector = "#tblFeePanel > tbody > tr:nth-child(2) > td:nth-child(5)";
		return cssSelector;
	}
	
	/**
	 * Vendor search result third name txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Vendor search result third name
	public static WebElement vendorSearchResultThirdName_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector("#tblFeePanel > tbody > tr:nth-child(3) > td:nth-child(5)"));
		return element;
	}
	
	/**
	 * Vendor search result third name txt.
	 *
	 * @return the string
	 */
	public static String vendorSearchResultThirdName_txt(){
		cssSelector = "#tblFeePanel > tbody > tr:nth-child(3) > td:nth-child(5)";
		return cssSelector;
	}
	
	/**
	 * Save btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Save button
	public static WebElement save_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/App_Themes/FlatGrayscale/Icons/save.O.png']"));
		return element;
	}
	
	/**
	 * Save btn.
	 *
	 * @return the string
	 */
	public static String save_btn(){
		cssSelector = "img[src='/App_Themes/FlatGrayscale/Icons/save.O.png']";
		return cssSelector;
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
	 * Saved dialog txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Saved dialog text
	public static WebElement savedDialog_txt(WebDriver driver){
		element = driver.findElement(By.id("divMessageOKText"));
		return element;
	}
	
	/**
	 * Saved dialog txt.
	 *
	 * @return the string
	 */
	public static String savedDialog_txt(){
		id = "divMessageOKText";
		return id;
	}
	
	/**
	 * Switch to AMC firm btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Switch to AMC/Firm button
	public static WebElement switchToAMCFirm_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/App_Themes/FlatGrayscale/Icons/Switch.png']"));
		return element;
	}
	
	/**
	 * Switch to AMC firm btn.
	 *
	 * @return the string
	 */
	public static String switchToAMCFirm_btn(){
		cssSelector = "img[src='/App_Themes/FlatGrayscale/Icons/Switch.png']";
		return cssSelector;
	}
	
	/**
	 * Selected vendors table txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Selected vendors table text
	public static WebElement selectedVendorsTable_txt(WebDriver driver){
		element = driver.findElement(By.id("tblBidVendors_scroll"));
		return element;
	}
	
	/**
	 * Selected vendors table txt.
	 *
	 * @return the string
	 */
	public static String selectedVendorsTable_txt(){
		id = "tblBidVendors_scroll";
		return id;
	}
	
	/**
	 * Expand map btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// expandMap_btn
	public static WebElement expandMap_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_ctlAnalytics_divAnalyticsMapExpand"));
		return element;
	}
	
	/**
	 * Expand map btn.
	 *
	 * @return the string
	 */
	public static String expandMap_btn(){
		id = "Main_Main_ctlAnalytics_divAnalyticsMapExpand";
		return id;
	}
	
}
