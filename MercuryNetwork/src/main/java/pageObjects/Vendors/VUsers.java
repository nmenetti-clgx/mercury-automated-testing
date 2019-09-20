package pageObjects.Vendors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Vendors Users page
 */
public class VUsers {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The css selector. */
	private static String cssSelector = null;
	
	/** The id. */
	private static String id = null;
	
	/** The linkText */
	private static String linkText = null;

	
	/**
	 * Save btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Save button
	public static WebElement save_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/Images/Save16x16.png']"));
		return element;
	}
	
	/**
	 * Save btn.
	 *
	 * @return the string
	 */
	public static String save_btn(){
		cssSelector = "img[src='/Images/Save16x16.png']";
		return cssSelector;
	}
	
	/**
	 * Dialog save txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Save Dialog text
	public static WebElement dialogSave_txt(WebDriver driver){
		element = driver.findElement(By.id("divMessageOK"));
		return element;
	}
	
	/**
	 * Dialog save txt.
	 *
	 * @return the string
	 */
	public static String dialogSave_txt(){
		id = "divMessageOK";
		return id;
	}
	
	/**
	 * Ok save btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// OK Save button
	public static WebElement okSave_btn(WebDriver driver){
		element = driver.findElement(By.id("sbdmButton1"));
		return element;
	}
	
	/**
	 * Ok save btn.
	 *
	 * @return the string
	 */
	public static String okSave_btn(){
		id = "sbdmButton1";
		return id;
	}
	
	/**
	 * No save btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// No Save button
	public static WebElement noSave_btn(WebDriver driver){
		element = driver.findElement(By.id("sbdmButton2"));
		return element;
	}
	
	/**
	 * No save btn.
	 *
	 * @return the string
	 */
	public static String noSave_btn(){
		id = "sbdmButton2";
		return id;
	}
	
	/**
	 * Ok alert btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// OK Alert button
	public static WebElement okAlert_btn(WebDriver driver){
		element = driver.findElement(By.id("sbdmButton1"));
		return element;
	}
	
	/**
	 * Ok alert btn.
	 *
	 * @return the string
	 */
	public static String okAlert_btn(){
		id = "sbdmButton1";
		return id;
	}
	
	/**
	 * Alert dialog txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Alert dialog text
	public static WebElement alertDialog_txt(WebDriver driver){
		element = driver.findElement(By.id("divMessageOK"));
		return element;
	}
	
	/**
	 * Alert dialog txt.
	 *
	 * @return the string
	 */
	public static String alertDialog_txt(){
		id = "divMessageOK";
		return id;
	}
	
	/**
	 * Details btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Details button
	public static WebElement details_btn(WebDriver driver){
		element = driver.findElement(By.id("tabDetails"));
		return element;
	}
	
	/**
	 * Details btn.
	 *
	 * @return the string
	 */
	public static String details_btn(){
		id = "tabDetails";
		return id;
	}
	
	/**
	 * Professional btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Professional button
	public static WebElement professional_btn(WebDriver driver){
		element = driver.findElement(By.id("tabProfessional"));
		return element;
	}
	
	/**
	 * Professional btn.
	 *
	 * @return the string
	 */
	public static String professional_btn(){
		id = "tabProfessional";
		return id;
	}
	
	/**
	 * Products btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Products button
	public static WebElement products_btn(WebDriver driver){
		element = driver.findElement(By.id("tabProducts"));
		return element;
	}
	
	/**
	 * Products btn.
	 *
	 * @return the string
	 */
	public static String products_btn(){
		id = "tabProducts";
		return id;
	}
	
	/**
	 * Coverage btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Coverage button
	public static WebElement coverage_btn(WebDriver driver){
		element = driver.findElement(By.id("tabCoverage"));
		return element;
	}
	
	/**
	 * Coverage btn.
	 *
	 * @return the string
	 */
	public static String coverage_btn(){
		id = "tabCoverage";
		return id;
	}
	
	/**
	 * My panels btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// My Panels button
	public static WebElement myPanels_btn(WebDriver driver){
		element = driver.findElement(By.id("tabMyPanels"));
		return element;
	}
	
	/**
	 * My panels btn.
	 *
	 * @return the string
	 */
	public static String myPanels_btn(){
		id = "tabMyPanels";
		return id;
	}
	
	/**
	 * Residential appraisal chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// residentialAppraisal chkbx	
	public static WebElement residentialAppraisal_chkbx(WebDriver driver){	
		element = driver.findElement(By.id("chkServiceOffered1"));
		return element;
	}	
	
	/**
	 * Residential appraisal chkbx.
	 *
	 * @return the string
	 */
	public static String residentialAppraisal_chkbx(){	
		id = "chkServiceOffered1";
		return id;
	}	
		
	/**
	 * Commercial appraisal chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// commercialAppraisal chkbx	
	public static WebElement commercialAppraisal_chkbx(WebDriver driver){	
		element = driver.findElement(By.id("chkServiceOffered5"));
		return element;
	}	
	
	/**
	 * Commercial appraisal chkbx.
	 *
	 * @return the string
	 */
	public static String commercialAppraisal_chkbx(){	
		id = "chkServiceOffered5";
		return id;
	}	
		
	/**
	 * Inspection chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// inspection chkbx	
	public static WebElement inspection_chkbx(WebDriver driver){	
		element = driver.findElement(By.id("chkServiceOffered4"));
		return element;
	}	
	
	/**
	 * Inspection chkbx.
	 *
	 * @return the string
	 */
	public static String inspection_chkbx(){	
		id = "chkServiceOffered4";
		return id;
	}	
		
	/**
	 * Broker price opinion chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// brokerPriceOpinion chkbx	
	public static WebElement brokerPriceOpinion_chkbx(WebDriver driver){	
		element = driver.findElement(By.id("chkServiceOffered6"));
		return element;
	}	
	
	/**
	 * Broker price opinion chkbx.
	 *
	 * @return the string
	 */
	public static String brokerPriceOpinion_chkbx(){	
		id = "chkServiceOffered6";
		return id;
	}	
		
	/**
	 * Residential appraisal year txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// residentialAppraisalYear txtbx	
	public static WebElement residentialAppraisalYear_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("txtServiceOffered1"));
		return element;
	}	
	
	/**
	 * Residential appraisal year txtbx.
	 *
	 * @return the string
	 */
	public static String residentialAppraisalYear_txtbx(){	
		id = "txtServiceOffered1";
		return id;
	}	
		
	/**
	 * Commercial appraisal year txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// commercialAppraisalYear txtbx	
	public static WebElement commercialAppraisalYear_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("txtServiceOffered5"));
		return element;
	}	
	
	/**
	 * Commercial appraisal year txtbx.
	 *
	 * @return the string
	 */
	public static String commercialAppraisalYear_txtbx(){	
		id = "txtServiceOffered5";
		return id;
	}	
		
	/**
	 * Inspection year txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// inspectionYear txtbx	
	public static WebElement inspectionYear_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("txtServiceOffered4"));
		return element;
	}	
	
	/**
	 * Inspection year txtbx.
	 *
	 * @return the string
	 */
	public static String inspectionYear_txtbx(){	
		id = "txtServiceOffered4";
		return id;
	}	
		
	/**
	 * Broker price opinion year txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// brokerPriceOpinionYear txtbx	
	public static WebElement brokerPriceOpinionYear_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("txtServiceOffered6"));
		return element;
	}	
	
	/**
	 * Broker price opinion year txtbx.
	 *
	 * @return the string
	 */
	public static String brokerPriceOpinionYear_txtbx(){	
		id = "txtServiceOffered6";
		return id;
	}	

	/**
	 * Ach chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// ach chkbx	
	public static WebElement ach_chkbx(WebDriver driver){	
		element = driver.findElement(By.id("chk_10"));
		return element;
	}	
	
	/**
	 * Ach chkbx.
	 *
	 * @return the string
	 */
	public static String ach_chkbx(){	
		id = "chk_10";
		return id;
	}	
		
	/**
	 * Cod chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// cod chkbx	
	public static WebElement cod_chkbx(WebDriver driver){	
		element = driver.findElement(By.id("chk_2"));
		return element;
	}	
	
	/**
	 * Cod chkbx.
	 *
	 * @return the string
	 */
	public static String cod_chkbx(){	
		id = "chk_2";
		return id;
	}	
		
	/**
	 * Check chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// check chkbx	
	public static WebElement check_chkbx(WebDriver driver){	
		element = driver.findElement(By.id("chk_1"));
		return element;
	}	
	
	/**
	 * Check chkbx.
	 *
	 * @return the string
	 */
	public static String check_chkbx(){	
		id = "chk_1";
		return id;
	}	
		
	/**
	 * Deferred C C chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// deferredCC chkbx	
	public static WebElement deferredCC_chkbx(WebDriver driver){	
		element = driver.findElement(By.id("chk_8"));
		return element;
	}	
	
	/**
	 * Deferred C C chkbx.
	 *
	 * @return the string
	 */
	public static String deferredCC_chkbx(){	
		id = "chk_8";
		return id;
	}	
		
	/**
	 * Invoice chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// invoice chkbx	
	public static WebElement invoice_chkbx(WebDriver driver){	
		element = driver.findElement(By.id("chk_7"));
		return element;
	}	
	
	/**
	 * Invoice chkbx.
	 *
	 * @return the string
	 */
	public static String invoice_chkbx(){	
		id = "chk_7";
		return id;
	}	
		
	/**
	 * Money order chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// moneyOrder chkbx	
	public static WebElement moneyOrder_chkbx(WebDriver driver){	
		element = driver.findElement(By.id("chk_4"));
		return element;
	}	
	
	/**
	 * Money order chkbx.
	 *
	 * @return the string
	 */
	public static String moneyOrder_chkbx(){	
		id = "chk_4";
		return id;
	}	
		
	/**
	 * Net 30 chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// net30 chkbx	
	public static WebElement net30_chkbx(WebDriver driver){	
		element = driver.findElement(By.id("chk_5"));
		return element;
	}	
	
	/**
	 * Net 30 chkbx.
	 *
	 * @return the string
	 */
	public static String net30_chkbx(){	
		id = "chk_5";
		return id;
	}	
		
	/**
	 * Paypal chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// paypal chkbx	
	public static WebElement paypal_chkbx(WebDriver driver){	
		element = driver.findElement(By.id("chk_6"));
		return element;
	}	
	
	/**
	 * Paypal chkbx.
	 *
	 * @return the string
	 */
	public static String paypal_chkbx(){	
		id = "chk_6";
		return id;
	}	

	/**
	 * Select btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Select button
	public static WebElement select_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("input[src='/Images/Select.png']"));
		return element;
	}
	
	/**
	 * Select btn.
	 *
	 * @return the string
	 */
	public static String select_btn(){
		cssSelector = "input[src='/Images/Select.png']";
		return cssSelector;
	}
	
	/**
	 * Counties txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// counties table txt
	public static WebElement counties_txt(WebDriver driver){	
		element = driver.findElement(By.id("tblccCounties"));
		return element;
	}	
	
	/**
	 * Counties txt.
	 *
	 * @return the string
	 */
	public static String counties_txt(){	
		id = "tblccCounties";
		return id;
	}	
	
	/**
	 * Profile page txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Profile Page text
	public static WebElement profilePage_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector("div.TabPanelContent.Selected"));
		return element;
	}
	
	/**
	 * Profile page txt.
	 *
	 * @return the string
	 */
	public static String profilePage_txt(){
		cssSelector = "div.TabPanelContent.Selected";
		return cssSelector;
	}
	
	/**
	 * Coverage page txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Coverage page text
	public static WebElement coveragePage_txt(WebDriver driver){	
		element = driver.findElement(By.id("divPanelCoverage"));
		return element;
	}	
	
	/**
	 * Coverage page txt.
	 *
	 * @return the string
	 */
	public static String coveragePage_txt(){	
		id = "divPanelCoverage";
		return id;
	}
	
	/**
	 * Profile status txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Profile Status text
	public static WebElement profileStatus_txt(WebDriver driver){	
		element = driver.findElement(By.id("ProfileStatusSection"));
		return element;
	}	
	
	/**
	 * Profile status txt.
	 *
	 * @return the string
	 */
	public static String profileStatus_txt(){	
		id = "ProfileStatusSection";
		return id;
	}
	
	/**
	 * Residential appraisal btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Residential appraisal button
	public static WebElement residentialAppraisal_btn(WebDriver driver){	
		element = driver.findElement(By.id("divProductTab0"));
		return element;
	}	
	
	/**
	 * Residential appraisal btn.
	 *
	 * @return the string
	 */
	public static String residentialAppraisal_btn(){	
		id = "divProductTab0";
		return id;
	}
	
	/**
	 * Commercial appraisal btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Commercial appraisal button
	public static WebElement commercialAppraisal_btn(WebDriver driver){	
		element = driver.findElement(By.id("divProductTab1"));
		return element;
	}	
	
	/**
	 * Commercial appraisal btn.
	 *
	 * @return the string
	 */
	public static String commercialAppraisal_btn(){	
		id = "divProductTab1";
		return id;
	}
	
	/**
	 * Broker price opinion btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Broker Price Opinion button
	public static WebElement brokerPriceOpinion_btn(WebDriver driver){	
		element = driver.findElement(By.id("divProductTab2"));
		return element;
	}	
	
	/**
	 * Broker price opinion btn.
	 *
	 * @return the string
	 */
	public static String brokerPriceOpinion_btn(){	
		id = "divProductTab2";
		return id;
	}
	
	/**
	 * Inspection btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Inspection button
	public static WebElement inspection_btn(WebDriver driver){	
		element = driver.findElement(By.id("divProductTab3"));
		return element;
	}	
	
	/**
	 * Inspection btn.
	 *
	 * @return the string
	 */
	public static String inspection_btn(){	
		id = "divProductTab3";
		return id;
	}
	
	/**
	 * Residential appraisal table header txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Residential Appraisal Table Header text
	public static WebElement residentialAppraisalTableHeader_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector("#tblProduct0 > thead > tr"));
		return element;
	}
	
	/**
	 * Residential appraisal table header txt.
	 *
	 * @return the string
	 */
	public static String residentialAppraisalTableHeader_txt(){
		cssSelector = "#tblProduct0 > thead > tr";
		return cssSelector;
	}
	
	/**
	 * Commercial appraisal table header txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Commercial Appraisal Table Header text
	public static WebElement commercialAppraisalTableHeader_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector("#tblProduct1 > thead > tr"));
		return element;
	}
	
	/**
	 * Commercial appraisal table header txt.
	 *
	 * @return the string
	 */
	public static String commercialAppraisalTableHeader_txt(){
		cssSelector = "#tblProduct1 > thead > tr";
		return cssSelector;
	}
	
	/**
	 * Broker price opinion table header txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Broker Price Opinion Header text
	public static WebElement brokerPriceOpinionTableHeader_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector("#tblProduct2 > thead > tr"));
		return element;
	}
	
	/**
	 * Broker price opinion table header txt.
	 *
	 * @return the string
	 */
	public static String brokerPriceOpinionTableHeader_txt(){
		cssSelector = "#tblProduct2 > thead > tr";
		return cssSelector;
	}
	
	/**
	 * Inspection table header txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Inspection Table Header text
	public static WebElement inspectionTableHeader_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector("#tblProduct3 > thead > tr"));
		return element;
	}
	
	/**
	 * Inspection table header txt.
	 *
	 * @return the string
	 */
	public static String inspectionTableHeader_txt(){
		cssSelector = "#tblProduct3 > thead > tr";
		return cssSelector;
	}
	
	/**
	 * Auto accept chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Auto-accept checkbox
	public static WebElement autoAccept_chkbx(WebDriver driver){
		element = driver.findElement(By.cssSelector("input[onclick='Mercury.Vendors.User.MyPanels.Event_AutoAccept_click(1070596)']"));
		return element;
	}
	
	/**
	 * Auto accept chkbx.
	 *
	 * @return the string
	 */
	public static String autoAccept_chkbx(){
		cssSelector = "input[onclick='Mercury.Vendors.User.MyPanels.Event_AutoAccept_click(1070596)']";
		return cssSelector;
	}
	
	/**
	 * Accept order from mercury network clients chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Accept orders from Mercury Network clients checkbox
	public static WebElement acceptOrderFromMercuryNetworkClients_chkbx(WebDriver driver){
		element = driver.findElement(By.id("chkAcceptOrders"));
		return element;
	}
	
	/**
	 * Accept order from mercury network clients chkbx.
	 *
	 * @return the string
	 */
	public static String acceptOrderFromMercuryNetworkClients_chkbx(){
		id = "chkAcceptOrders";
		return id;
	}
	
	/**
	 * Banner lnk.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Banner link
	public static WebElement banner_lnk(WebDriver driver){
		element = driver.findElement(By.id("imgDetailsBannerAd"));
		return element;
	}
	
	/**
	 * Banner lnk.
	 *
	 * @return the string
	 */
	public static String banner_lnk(){
		id = "imgDetailsBannerAd";
		return id;
	}
	
	/**
	 * Page txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Page text
	public static WebElement page_txt(WebDriver driver){
		element = driver.findElement(By.id("divTabContainer"));
		return element;
	}
	
	/**
	 * Page txt.
	 *
	 * @return the string
	 */
	public static String page_txt(){
		id = "divTabContainer";
		return id;
	}
	
	/**
	 * Creates the new user btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Create New User button
	public static WebElement createNewUser_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='Images/NewUserIcon16x16.png']"));
		return element;
	}
	
	/**
	 * Creates the new user btn.
	 *
	 * @return the string
	 */
	public static String createNewUser_btn(){
		cssSelector = "img[src='Images/NewUserIcon16x16.png']";
		return cssSelector;
	}
	
	/**
	 * Users txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Users text
	public static WebElement users_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector("td.BlueBox"));
		return element;
	}
	
	/**
	 * Users txt.
	 *
	 * @return the string
	 */
	public static String users_txt(){
		cssSelector = "td.BlueBox";
		return cssSelector;
	}
	
	/**
	 * Users table txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Users table text
	public static WebElement usersTable_txt(WebDriver driver){
		element = driver.findElement(By.id("tblUsers"));
		return element;
	}
	
	/**
	 * Users table txt.
	 *
	 * @return the string
	 */
	public static String usersTable_txt(){
		id = "tblUsers";
		return id;
	}
	
	/**
	 * Delete user btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Delete User button
	public static WebElement deleteUser_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='Images/Cancel.png']"));
		return element;
	}
	
	/**
	 * Delete user btn.
	 *
	 * @return the string
	 */
	public static String deleteUser_btn(){
		cssSelector = "img[src='Images/Cancel.png']";
		return cssSelector;
	}
	
	/**
	 * Yes delete user btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Yes delete user button
	public static WebElement yesDeleteUser_btn(WebDriver driver){
		element = driver.findElement(By.id("sbdmButton1"));
		return element;
	}
	
	/**
	 * Yes delete user btn.
	 *
	 * @return the string
	 */
	public static String yesDeleteUser_btn(){
		id = "sbdmButton1";
		return id;
	}
	
	/**
	 * Primary email txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Primary E-mail textbox
	public static WebElement primaryEmail_txtbx(WebDriver driver){
		element = driver.findElement(By.id("txtUserName"));
		return element;
	}
	
	/**
	 * Primary email txtbx.
	 *
	 * @return the string
	 */
	public static String primaryEmail_txtbx(){
		id = "txtUserName";
		return id;
	}
	
	/**
	 * additionalEmail_txtbx
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Primary E-mail textbox
	public static WebElement additionalEmail_txtbx(WebDriver driver){
		element = driver.findElement(By.id("txtAdditionalEmails"));
		return element;
	}
	
	/**
	 * additionalEmail_txtbx
	 *
	 * @return the string
	 */
	public static String additionalEmail_txtbx(){
		id = "txtAdditionalEmails";
		return id;
	}
	
	/**
	 * Password txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Password textbox
	public static WebElement password_txtbx(WebDriver driver){
		element = driver.findElement(By.id("txtNewPassword"));
		return element;
	}
	
	/**
	 * Password txtbx.
	 *
	 * @return the string
	 */
	public static String password_txtbx(){
		id = "txtNewPassword";
		return id;
	}
	
	/**
	 * Confirm password txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Confirm Password textbox
	public static WebElement confirmPassword_txtbx(WebDriver driver){
		element = driver.findElement(By.id("txtConfirmPassword"));
		return element;
	}
	
	/**
	 * Confirm password txtbx.
	 *
	 * @return the string
	 */
	public static String confirmPassword_txtbx(){
		id = "txtConfirmPassword";
		return id;
	}
	
	/**
	 * First name txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// First Name textbox
	public static WebElement firstName_txtbx(WebDriver driver){
		element = driver.findElement(By.id("txtFirstName"));
		return element;
	}
	
	/**
	 * First name txtbx.
	 *
	 * @return the string
	 */
	public static String firstName_txtbx(){
		id = "txtFirstName";
		return id;
	}
	
	/**
	 * Last name txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Last Name textbox
	public static WebElement lastName_txtbx(WebDriver driver){
		element = driver.findElement(By.id("txtLastName"));
		return element;
	}
	
	/**
	 * Last name txtbx.
	 *
	 * @return the string
	 */
	public static String lastName_txtbx(){
		id = "txtLastName";
		return id;
	}
	
	/**
	 * companyName_txtbx
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Last Name textbox
	public static WebElement companyName_txtbx(WebDriver driver){
		element = driver.findElement(By.id("txtCompanyName"));
		return element;
	}
	
	/**
	 * companyName_txtbx
	 *
	 * @return the string
	 */
	public static String companyName_txtbx(){
		id = "txtCompanyName";
		return id;
	}
	
	/**
	 * taxIdentification_txtbx
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Last Name textbox
	public static WebElement taxIdentification_txtbx(WebDriver driver){
		element = driver.findElement(By.id("txtFederalTaxID"));
		return element;
	}
	
	/**
	 * taxIdentification_txtbx
	 *
	 * @return the string
	 */
	public static String taxIdentification_txtbx(){
		id = "txtFederalTaxID";
		return id;
	}
	
	/**
	 * Adds the btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Add button
	public static WebElement add_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='Images/VendorAddIcon.png']"));
		return element;
	}
	
	/**
	 * Adds the btn.
	 *
	 * @return the string
	 */
	public static String add_btn(){
		cssSelector = "img[src='Images/VendorAddIcon.png']";
		return cssSelector;
	}
	
	/**
	 * License btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// License button
	public static WebElement license_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='Images/AddLicense.png']"));
		return element;
	}
	
	/**
	 * License btn.
	 *
	 * @return the string
	 */
	public static String license_btn(){
		cssSelector = "img[src='Images/AddLicense.png']";
		return cssSelector;
	}
	
	/**
	 * Insurance policy btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Insurance Policy button
	public static WebElement insurancePolicy_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='Images/AddInsurance.png']"));
		return element;
	}
	
	/**
	 * Insurance policy btn.
	 *
	 * @return the string
	 */
	public static String insurancePolicy_btn(){
		cssSelector = "img[src='Images/AddInsurance.png']";
		return cssSelector;
	}
	
	/**
	 * Attachment btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Attachment button
	public static WebElement attachment_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='Images/AddAttachment.png']"));
		return element;
	}
	
	/**
	 * Attachment btn.
	 *
	 * @return the string
	 */
	public static String attachment_btn(){
		cssSelector = "img[src='Images/AddAttachment.png']";
		return cssSelector;
	}
	
	/**
	 * License type dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// licenseType dropdown						
	public static WebElement licenseType_dropdown(WebDriver driver){						
		element = driver.findElement(By.id("ddlLicenseType"));					
		return element;					
	}						
	
	/**
	 * License type dropdown.
	 *
	 * @return the string
	 */
	public static String licenseType_dropdown(){						
		id = "ddlLicenseType";					
		return id;					
	}						
							
	/**
	 * State dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// state dropdown						
	public static WebElement state_dropdown(WebDriver driver){						
		element = driver.findElement(By.id("ddlLicenseState"));					
		return element;					
	}						
	
	/**
	 * State dropdown.
	 *
	 * @return the string
	 */
	public static String state_dropdown(){						
		id = "ddlLicenseState";					
		return id;					
	}						
							
	/**
	 * License number txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// licenseNumber txtbx						
	public static WebElement licenseNumber_txtbx(WebDriver driver){						
		element = driver.findElement(By.id("txtLicenseNumber"));					
		return element;					
	}						
	
	/**
	 * License number txtbx.
	 *
	 * @return the string
	 */
	public static String licenseNumber_txtbx(){						
		id = "txtLicenseNumber";					
		return id;					
	}						
							
	/**
	 * Expiration date txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// expirationDate txtbx						
	public static WebElement expirationDate_txtbx(WebDriver driver){						
		element = driver.findElement(By.id("txtLicenseExpirationDate"));					
		return element;					
	}						
	
	/**
	 * Expiration date txtbx.
	 *
	 * @return the string
	 */
	public static String expirationDate_txtbx(){						
		id = "txtLicenseExpirationDate";					
		return id;					
	}						

	/**
	 * Save license btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Save License button
	public static WebElement saveLicense_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("input.Button[value='Save'][type='button']"));
		return element;
	}
	
	/**
	 * Save license btn.
	 *
	 * @return the string
	 */
	public static String saveLicense_btn(){
		cssSelector = "input.Button[value='Save'][type='button']";
		return cssSelector;
	}
	
	/**
	 * Licenses txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Licenses txtbx						
	public static WebElement licenses_txt(WebDriver driver){						
		element = driver.findElement(By.id("divSectionLicenses"));					
		return element;					
	}						
	
	/**
	 * Licenses txt.
	 *
	 * @return the string
	 */
	public static String licenses_txt(){						
		id = "divSectionLicenses";					
		return id;					
	}
	
	/**
	 * Insurance policies txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Insurance Policies txtbx						
	public static WebElement insurancePolicies_txt(WebDriver driver){						
		element = driver.findElement(By.id("divSectionInsurance"));					
		return element;					
	}						
	
	/**
	 * Insurance policies txt.
	 *
	 * @return the string
	 */
	public static String insurancePolicies_txt(){						
		id = "divSectionInsurance";					
		return id;					
	}
	
	/**
	 * Insurance type dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// insuranceType dropdown					
	public static WebElement insuranceType_dropdown(WebDriver driver){					
		element = driver.findElement(By.id("ddlInsuranceType"));				
		return element;				
	}					
	
	/**
	 * Insurance type dropdown.
	 *
	 * @return the string
	 */
	public static String insuranceType_dropdown(){					
		id = "ddlInsuranceType";				
		return id;				
	}					
						
	/**
	 * Carrier name txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// carrierName txtbx					
	public static WebElement carrierName_txtbx(WebDriver driver){					
		element = driver.findElement(By.id("txtCarrierName"));				
		return element;				
	}					
	
	/**
	 * Carrier name txtbx.
	 *
	 * @return the string
	 */
	public static String carrierName_txtbx(){					
		id = "txtCarrierName";				
		return id;				
	}					
						
	/**
	 * Policy number txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// policyNumber txtbx					
	public static WebElement policyNumber_txtbx(WebDriver driver){					
		element = driver.findElement(By.id("txtPolicyNumber"));				
		return element;				
	}					
	
	/**
	 * Policy number txtbx.
	 *
	 * @return the string
	 */
	public static String policyNumber_txtbx(){					
		id = "txtPolicyNumber";				
		return id;				
	}					
						
	/**
	 * Policy amount txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// policyAmount txtbx					
	public static WebElement policyAmount_txtbx(WebDriver driver){					
		element = driver.findElement(By.id("txtPolicyAmount"));				
		return element;				
	}					
	
	/**
	 * Policy amount txtbx.
	 *
	 * @return the string
	 */
	public static String policyAmount_txtbx(){					
		id = "txtPolicyAmount";				
		return id;				
	}					
						
	/**
	 * Expiration date insurance policy txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// expirationDate txtbx					
	public static WebElement expirationDateInsurancePolicy_txtbx(WebDriver driver){					
		element = driver.findElement(By.id("txtInsuranceExpirationDate"));				
		return element;				
	}					
	
	/**
	 * Expiration date insurance policy txtbx.
	 *
	 * @return the string
	 */
	public static String expirationDateInsurancePolicy_txtbx(){					
		id = "txtInsuranceExpirationDate";				
		return id;				
	}					

	/**
	 * Attachments txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Attachments txtbx						
	public static WebElement attachments_txt(WebDriver driver){						
		element = driver.findElement(By.id("divSectionAttachments"));					
		return element;					
	}						
	
	/**
	 * Attachments txt.
	 *
	 * @return the string
	 */
	public static String attachments_txt(){						
		id = "divSectionAttachments";					
		return id;					
	}
	
	/**
	 * Attachment type dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Attachment type dropdown
	public static WebElement attachmentType_dropdown(WebDriver driver){						
		element = driver.findElement(By.id("ddlAttachmentType"));					
		return element;					
	}						
	
	/**
	 * Attachment type dropdown.
	 *
	 * @return the string
	 */
	public static String attachmentType_dropdown(){						
		id = "ddlAttachmentType";					
		return id;					
	}
	
	/**
	 * Cancel btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Cancel License button
	public static WebElement cancel_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#divAttachment > div.DialogFooter > div:nth-child(2) > input"));
		return element;
	}
	
	/**
	 * Cancel btn.
	 *
	 * @return the string
	 */
	public static String cancel_btn(){
		cssSelector = "#divAttachment > div.DialogFooter > div:nth-child(2) > input";
		return cssSelector;
	}
	
	/**
	 * Preview profile btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Preview Profile button
	public static WebElement previewProfile_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='Images/PrevewProfileIcon.png']"));
		return element;
	}
	
	/**
	 * Preview profile btn.
	 *
	 * @return the string
	 */
	public static String previewProfile_btn(){
		cssSelector = "img[src='Images/PrevewProfileIcon.png']";
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
		element = driver.findElement(By.cssSelector("#form1 > div.DialogFooter > div > input"));
		return element;
	}
	
	/**
	 * Ok btn.
	 *
	 * @return the string
	 */
	public static String ok_btn(){
		cssSelector = "#form1 > div.DialogFooter > div > input";
		return cssSelector;
	}
	
	/**
	 * Preview profile txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Preview Profile text
	public static WebElement previewProfile_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector(".PreviewSection"));
		return element;
	}
	
	/**
	 * Preview profile txt.
	 *
	 * @return the string
	 */
	public static String previewProfile_txt(){
		cssSelector = ".PreviewSection";
		return cssSelector;
	}
	
	/**
	 * Only accept orders from my fee panel clients checkbox.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Only accept orders from my fee panel clients checkbox
	public static WebElement onlyAcceptOrdersFromMyFeePanelClients_checkbox(WebDriver driver){						
		element = driver.findElement(By.id("chkAcceptOrdersFromFeePanel"));					
		return element;					
	}						
	
	/**
	 * Only accept orders from my fee panel clients checkbox.
	 *
	 * @return the string
	 */
	public static String onlyAcceptOrdersFromMyFeePanelClients_checkbox(){						
		id = "chkAcceptOrdersFromFeePanel";					
		return id;					
	}
	
	/**
	 * Removes the btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Remove button
	public static WebElement remove_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/Images/DeleteIcon16x16.png']"));
		return element;
	}
	
	/**
	 * Removes the btn.
	 *
	 * @return the string
	 */
	public static String remove_btn(){
		cssSelector = "img[src='/Images/DeleteIcon16x16.png']";
		return cssSelector;
	}
	
	/**
	 * Ok unavailable btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// OK Unavailable button
	public static WebElement okUnavailable_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#divUnavailable > div.MessageBoxFooter > div.MessageBoxButton > input[value='OK']"));
		return element;
	}
	
	/**
	 * Ok unavailable btn.
	 *
	 * @return the string
	 */
	public static String okUnavailable_btn(){
		cssSelector = "#divUnavailable > div.MessageBoxFooter > div.MessageBoxButton > input[value='OK']";
		return cssSelector;
	}
	
	/**
	 * Date leaving txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Date leaving textbox
	public static WebElement dateLeaving_txtbx(WebDriver driver){						
		element = driver.findElement(By.id("txtUnavailableBegin"));					
		return element;					
	}						
	
	/**
	 * Date leaving txtbx.
	 *
	 * @return the string
	 */
	public static String dateLeaving_txtbx(){						
		id = "txtUnavailableBegin";					
		return id;					
	}
	
	/**
	 * Date returning txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Date returning textbox
	public static WebElement dateReturning_txtbx(WebDriver driver){						
		element = driver.findElement(By.id("txtUnavailableEnd"));					
		return element;					
	}						
	
	/**
	 * Date returning txtbx.
	 *
	 * @return the string
	 */
	public static String dateReturning_txtbx(){						
		id = "txtUnavailableEnd";					
		return id;					
	}
	
	/**
	 * Ok open orders btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// OK open orders button
	public static WebElement okOpenOrders_btn(WebDriver driver){						
		element = driver.findElement(By.id("Dialogs_Dialogs_ctl05"));					
		return element;					
	}						
	
	/**
	 * Ok open orders btn.
	 *
	 * @return the string
	 */
	public static String okOpenOrders_btn(){						
		id = "Dialogs_Dialogs_ctl05";					
		return id;					
	}
	
	/**
	 * Open orders txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Open orders text
	public static WebElement openOrders_txt(WebDriver driver){						
		element = driver.findElement(By.id("divRemoveOrders"));					
		return element;					
	}						
	
	/**
	 * Open orders txt.
	 *
	 * @return the string
	 */
	public static String openOrders_txt(){						
		id = "divRemoveOrders";					
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
		element = driver.findElement(By.cssSelector("#divRemove > div.MessageBoxFooter > div.MessageBoxButton > input[value='Send']"));
		return element;
	}
	
	/**
	 * Send btn.
	 *
	 * @return the string
	 */
	public static String send_btn(){
		cssSelector = "#divRemove > div.MessageBoxFooter > div.MessageBoxButton > input[value='Send']";
		return cssSelector;
	}
	
	/**
	 * Removes the from fee panel txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Remove from fee panel text
	public static WebElement removeFromFeePanel_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector("#divRemove > div.MessageBoxContent"));
		return element;
	}
	
	/**
	 * Removes the from fee panel txt.
	 *
	 * @return the string
	 */
	public static String removeFromFeePanel_txt(){
		cssSelector = "#divRemove > div.MessageBoxContent";
		return cssSelector;
	}
	
	/**
	 * Almost done txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Almost done text
	public static WebElement almostDone_txt(WebDriver driver){						
		element = driver.findElement(By.id("divMessageOKText"));					
		return element;					
	}						
	
	/**
	 * Almost done txt.
	 *
	 * @return the string
	 */
	public static String almostDone_txt(){						
		id = "divMessageOKText";					
		return id;					
	}
	
	/**
	 * Reason txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Reason textbox
	public static WebElement reason_txtbx(WebDriver driver){						
		element = driver.findElement(By.id("Dialogs_Dialogs_ctlStatusMessage_txtMessage"));					
		return element;					
	}						
	
	/**
	 * Reason txtbx.
	 *
	 * @return the string
	 */
	public static String reason_txtbx(){						
		id = "Dialogs_Dialogs_ctlStatusMessage_txtMessage";					
		return id;					
	}
	
	/**
	 * Edits the document btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Edit document button
	public static WebElement editDocument_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/VendorAdmin/OrderManagement/Images/EditOrder16x16.png']"));
		return element;
	}
	
	/**
	 * Edits the document btn.
	 *
	 * @return the string
	 */
	public static String editDocument_btn(){
		cssSelector = "img[src='/VendorAdmin/OrderManagement/Images/EditOrder16x16.png']";
		return cssSelector;
	}
	
	/**
	 * Save update attachment btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Save Update Attachment button
	public static WebElement saveUpdateAttachment_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("input[type='button'][value='Save'][class='Button']"));
		return element;
	}
	
	/**
	 * Save update attachment btn.
	 *
	 * @return the string
	 */
	public static String saveUpdateAttachment_btn(){
		cssSelector = "input[type='button'][value='Save'][class='Button']";
		return cssSelector;
	}
	
	/**
	 * In business since month txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// In business since Month textbox
	public static WebElement inBusinessSinceMonth_txtbx(WebDriver driver){
		element = driver.findElement(By.cssSelector(".Month"));
		return element;
	}
	
	/**
	 * In business since month txtbx.
	 *
	 * @return the string
	 */
	public static String inBusinessSinceMonth_txtbx(){
		cssSelector = ".Month";
		return cssSelector;
	}
	
	/**
	 * In business since year txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// In business since Year textbox
	public static WebElement inBusinessSinceYear_txtbx(WebDriver driver){
		element = driver.findElement(By.cssSelector(".Year"));
		return element;
	}
	
	/**
	 * In business since year txtbx.
	 *
	 * @return the string
	 */
	public static String inBusinessSinceYear_txtbx(){
		cssSelector = ".Year";
		return cssSelector;
	}
	
	/**
	 * Oklahoma chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Oklahoma checkbox
	public static WebElement oklahoma_chkbx(WebDriver driver){						
		element = driver.findElement(By.id("chk_sc_OK"));					
		return element;					
	}						
	
	/**
	 * Oklahoma chkbx.
	 *
	 * @return the string
	 */
	public static String oklahoma_chkbx(){						
		id = "chk_sc_OK";					
		return id;					
	}
	
	/**
	 * Corporate office time zone dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Corporate Office Time Zone dropdown
	public static WebElement corporateOfficeTimeZone_dropdown(WebDriver driver){						
		element = driver.findElement(By.id("ddlTimeZone"));					
		return element;					
	}						
	
	/**
	 * Corporate office time zone dropdown.
	 *
	 * @return the string
	 */
	public static String corporateOfficeTimeZone_dropdown(){						
		id = "ddlTimeZone";					
		return id;					
	}
	
	/**
	 * officePhoneNumber_txtbx
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Corporate Office Time Zone dropdown
	public static WebElement officePhoneNumber_txtbx(WebDriver driver){						
		element = driver.findElement(By.id("txtPhoneNumber"));					
		return element;					
	}						
	
	/**
	 * officePhoneNumber_txtbx
	 *
	 * @return the string
	 */
	public static String officePhoneNumber_txtbx(){						
		id = "txtPhoneNumber";					
		return id;					
	}
	
	/**
	 * extension_txtbx
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Corporate Office Time Zone dropdown
	public static WebElement extension_txtbx(WebDriver driver){						
		element = driver.findElement(By.id("txtPhoneNumberExt"));					
		return element;					
	}						
	
	/**
	 * extension_txtbx
	 *
	 * @return the string
	 */
	public static String extension_txtbx(){						
		id = "txtPhoneNumberExt";					
		return id;					
	}
	
	/**
	 * cellPhoneNumber_txtbx
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Corporate Office Time Zone dropdown
	public static WebElement cellPhoneNumber_txtbx(WebDriver driver){						
		element = driver.findElement(By.id("txtMobileNumber"));					
		return element;					
	}						
	
	/**
	 * cellPhoneNumber_txtbx
	 *
	 * @return the string
	 */
	public static String cellPhoneNumber_txtbx(){						
		id = "txtMobileNumber";					
		return id;					
	}
	
	/**
	 * faxNumber_txtbx
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Corporate Office Time Zone dropdown
	public static WebElement faxNumber_txtbx(WebDriver driver){						
		element = driver.findElement(By.id("txtFaxNumber"));					
		return element;					
	}						
	
	/**
	 * faxNumber_txtbx
	 *
	 * @return the string
	 */
	public static String faxNumber_txtbx(){						
		id = "txtFaxNumber";					
		return id;					
	}
	
	/**
	 * Trainees table.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// trainees table
	public static WebElement traineesTable(WebDriver driver){	
		element = driver.findElement(By.id("tblTrainees"));
		return element;
	}	
	
	/**
	 * Trainees table.
	 *
	 * @return the string
	 */
	public static String traineesTable(){	
		id = "tblTrainees";
		return id;
	}
	
	/**
	 * Max trainee txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// maxTrainee_txt
	public static WebElement maxTrainee_txt(WebDriver driver){	
		element = driver.findElement(By.id("divMaximumTrainees"));
		return element;
	}	
	
	/**
	 * Max trainee txt.
	 *
	 * @return the string
	 */
	public static String maxTrainee_txt(){	
		id = "divMaximumTrainees";
		return id;
	}
	
	/**
	 * addNewW9_link
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// maxTrainee_txt
	public static WebElement addNewW9_link(WebDriver driver){	
		element = driver.findElement(By.linkText("Add new W-9"));
		return element;
	}	
	
	/**
	 * addNewW9_link
	 *
	 * @return the string
	 */
	public static String addNewW9_link(){	
		linkText = "Add new W-9";
		return linkText;
	}
	
	/**
	 * feeNotes_txt
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// maxTrainee_txt
	public static WebElement feeNotes_txt(WebDriver driver){	
		element = driver.findElement(By.id("txtFeeNotes"));
		return element;
	}	
	
	/**
	 * feeNotes_txt
	 *
	 * @return the string
	 */
	public static String feeNotes_txt(){	
		id = "txtFeeNotes";
		return id;
	}
	
	/**
	 * okFeeNotes_btn
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// In business since Year textbox
	public static WebElement okFeeNotes_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#divFeeNotes > div.MessageBoxFooter > .MessageBoxButton > input[value='OK']"));
		return element;
	}
	
	/**
	 * okFeeNotes_btn
	 *
	 * @return the string
	 */
	public static String okFeeNotes_btn(){
		cssSelector = "#divFeeNotes > div.MessageBoxFooter > .MessageBoxButton > input[value='OK']";
		return cssSelector;
	}
	
	/**
	 * cancelFeeNotes_btn
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// In business since Year textbox
	public static WebElement cancelFeeNotes_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#divFeeNotes > div.MessageBoxFooter > .MessageBoxButton > input[value='Cancel']"));
		return element;
	}
	
	/**
	 * cancelFeeNotes_btn
	 *
	 * @return the string
	 */
	public static String cancelFeeNotes_btn(){
		cssSelector = "#divFeeNotes > div.MessageBoxFooter > .MessageBoxButton > input[value='Cancel']";
		return cssSelector;
	}
	
	/**
	 * note_link
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// In business since Year textbox
	public static WebElement note_link(WebDriver driver){
		element = driver.findElement(By.cssSelector("#tblProduct0 > tbody > tr:nth-child(1) > td.IG_GridCenter > a"));
		return element;
	}
	
	/**
	 * note_link
	 *
	 * @return the string
	 */
	public static String note_link(){
		cssSelector = "#tblProduct0 > tbody > tr:nth-child(1) > td.IG_GridCenter > a";
		return cssSelector;
	}
	
	/**
	 * addLicense
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// maxTrainee_txt
	public static WebElement addLicense_link(WebDriver driver){	
		element = driver.findElement(By.id("lnkLicenseNoData"));
		return element;
	}	
	
	/**
	 * addLicense
	 *
	 * @return the string
	 */
	public static String addLicense_link(){	
		id = "lnkLicenseNoData";
		return id;
	}
	
	/**
	 * cancelAddLicense_btn
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// In business since Year textbox
	public static WebElement cancelAddLicense_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#divLicense > div.DialogFooter > div:nth-child(2) > input"));
		return element;
	}
	
	/**
	 * cancelAddLicense_btn
	 *
	 * @return the string
	 */
	public static String cancelAddLicense_btn(){
		cssSelector = "#divLicense > div.DialogFooter > div:nth-child(2) > input";
		return cssSelector;
	}
	
	/**
	 * addInsurancePolicies_link
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// maxTrainee_txt
	public static WebElement addInsurancePolicies_link(WebDriver driver){	
		element = driver.findElement(By.id("lnkInsuranceNoData"));
		return element;
	}	
	
	/**
	 * addInsurancePolicies_link
	 *
	 * @return the string
	 */
	public static String addInsurancePolicies_link(){	
		id = "lnkInsuranceNoData";
		return id;
	}
	
	/**
	 * cancelAddLicense_btn
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// In business since Year textbox
	public static WebElement cancelAddInsurancePolicy_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#divInsurancePolicy > div.DialogFooter > .DialogButton > input[value='Cancel']"));
		return element;
	}
	
	/**
	 * cancelAddLicense_btn
	 *
	 * @return the string
	 */
	public static String cancelAddInsurancePolicy_btn(){
		cssSelector = "#divInsurancePolicy > div.DialogFooter > .DialogButton > input[value='Cancel']";
		return cssSelector;
	}
	
	/**
	 * deleteLicense_btn
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement deleteLicense_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector(".Licenses > tbody > tr > td > img[src='/Images/DeleteIcon16x16.png']"));
		return element;
	}
	
	/**
	 * deleteLicense_btn
	 *
	 * @return the string
	 */
	public static String deleteLicense_btn(){
		cssSelector = ".Licenses > tbody > tr > td > img[src='/Images/DeleteIcon16x16.png']";
		return cssSelector;
	}
	
}
