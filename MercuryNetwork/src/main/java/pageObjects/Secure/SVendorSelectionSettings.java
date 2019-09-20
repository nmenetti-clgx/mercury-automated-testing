package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure Vendor Selection Settings page
 */
public class SVendorSelectionSettings {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	/** The css selector. */
	private static String cssSelector = null;

	
	/**
	 * Residential appraisers btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Residential appraisers tab
	public static WebElement residentialAppraisers_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#Tabs > div[data-name='Residential appraiser']"));
		return element;
	}
	
	/**
	 * Residential appraisers btn.
	 *
	 * @return the string
	 */
	public static String residentialAppraisers_btn(){
		cssSelector = "#Tabs > div[data-name='Residential appraiser']";
		return cssSelector;
	}
	
	/**
	 * Amc firms btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// AMC/Firms tab
	public static WebElement amcFirms_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#Tabs > div[data-name='AMC/Firm']"));
		return element;
	}
	
	/**
	 * Amc firms btn.
	 *
	 * @return the string
	 */
	public static String amcFirms_btn(){
		cssSelector = "#Tabs > div[data-name='AMC/Firm']";
		return cssSelector;
	}
	
	/**
	 * Commercial appraisers btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Commercial appraisers tab
	public static WebElement commercialAppraisers_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#Tabs > div[data-name='Commercial appraiser']"));
		return element;
	}
	
	/**
	 * Commercial appraisers btn.
	 *
	 * @return the string
	 */
	public static String commercialAppraisers_btn(){
		cssSelector = "#Tabs > div[data-name='Commercial appraiser']";
		return cssSelector;
	}
	
	/**
	 * Agent brokers btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Agent/Brokers tab
	public static WebElement agentBrokers_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#Tabs > div[data-name='Agent/Broker']"));
		return element;
	}
	
	/**
	 * Agent brokers btn.
	 *
	 * @return the string
	 */
	public static String agentBrokers_btn(){
		cssSelector = "#Tabs > div[data-name='Agent/Broker']";
		return cssSelector;
	}
	
	/**
	 * Inspectors btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Inspectors tab
	public static WebElement inspectors_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#Tabs > div[data-name='Inspector']"));
		return element;
	}
	
	/**
	 * Inspectors btn.
	 *
	 * @return the string
	 */
	public static String inspectors_btn(){
		cssSelector = "#Tabs > div[data-name='Inspector']";
		return cssSelector;
	}
	
	/**
	 * Double blind switch.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Double-blind Communication Switch
	public static WebElement doubleBlind_switch(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_swDoubleBlind_imgSwitch"));
		return element;
	}
	
	/**
	 * Double blind switch.
	 *
	 * @return the string
	 */
	public static String doubleBlind_switch(){
		id = "Main_Main_swDoubleBlind_imgSwitch";
		return id;
	}
	
	/**
	 * Canned comment override switch.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Canned Comment Override Switch
	public static WebElement cannedCommentOverride_switch(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_swCannedComments_imgSwitch"));
		return element;
	}
	
	/**
	 * Canned comment override switch.
	 *
	 * @return the string
	 */
	public static String cannedCommentOverride_switch(){
		id = "Main_Main_swCannedComments_imgSwitch";
		return id;
	}
	
	/**
	 * Automatic order assignment switch.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Automatic Order Assignment Switch
	public static WebElement automaticOrderAssignment_switch(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_swAutoAssign_imgSwitch"));
		return element;
	}
	
	/**
	 * Automatic order assignment switch.
	 *
	 * @return the string
	 */
	public static String automaticOrderAssignment_switch(){
		id = "Main_Main_swAutoAssign_imgSwitch";
		return id;
	}
	
	/**
	 * Order auto reassignment switch.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Automatic Order Assignment Switch
	public static WebElement orderAutoReassignment_switch(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_swAutoReassign_imgSwitch"));
		return element;
	}
	
	/**
	 * Order auto reassignment switch.
	 *
	 * @return the string
	 */
	public static String orderAutoReassignment_switch(){
		id = "Main_Main_swAutoReassign_imgSwitch";
		return id;
	}
	
	/**
	 * Unattended order assignment switch.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Unattended Order Assignment Switch
	public static WebElement unattendedOrderAssignment_switch(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_swUnattendedAssignment_imgSwitch"));
		return element;
	}
	
	/**
	 * Unattended order assignment switch.
	 *
	 * @return the string
	 */
	public static String unattendedOrderAssignment_switch(){
		id = "Main_Main_swUnattendedAssignment_imgSwitch";
		return id;
	}
	
	/**
	 * Unattended order reassignment switch.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Unattended Order Reassignment Switch
	public static WebElement unattendedOrderReassignment_switch(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_swAutoReassign_imgSwitch"));
		return element;
	}
	
	/**
	 * Unattended order reassignment switch.
	 *
	 * @return the string
	 */
	public static String unattendedOrderReassignment_switch(){
		id = "Main_Main_swAutoReassign_imgSwitch";
		return id;
	}
	
	/**
	 * Unattended order assignment dialog txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Unattended Order Assignment dialog text
	public static WebElement unattendedOrderAssignmentDialog_txt(WebDriver driver){
		element = driver.findElement(By.id("divMessageOK"));
		return element;
	}
	
	/**
	 * Unattended order assignment dialog txt.
	 *
	 * @return the string
	 */
	public static String unattendedOrderAssignmentDialog_txt(){
		id = "divMessageOK";
		return id;
	}
	
	/**
	 * Unattended order assignment dialog ok btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Unattended Order Assignment dialog OK button
	public static WebElement unattendedOrderAssignmentDialogOk_btn(WebDriver driver){
		element = driver.findElement(By.id("sbdmButton1"));
		return element;
	}
	
	/**
	 * Unattended order assignment dialog ok btn.
	 *
	 * @return the string
	 */
	public static String unattendedOrderAssignmentDialogOk_btn(){
		id = "sbdmButton1";
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
		element = driver.findElement(By.cssSelector("img[src='/App_Themes/FlatGrayscale/Icons/save.O.png']"));
//		element = driver.findElement(By.cssSelector("img[src='/Images/Save16x16.png']"));
		return element;
	}
	
	/**
	 * Save btn.
	 *
	 * @return the string
	 */
	public static String save_btn(){
		cssSelector = "img[src='/App_Themes/FlatGrayscale/Icons/save.O.png']";
//		cssSelector = "img[src='/Images/Save16x16.png']";
		return cssSelector;
	}
	
	/**
	 * Save custom settings btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Save Custom Settings button
	public static WebElement saveCustomSettings_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ctl00"));
		return element;
	}
	
	/**
	 * Save custom settings btn.
	 *
	 * @return the string
	 */
	public static String saveCustomSettings_btn(){
		id = "Dialogs_Dialogs_ctl00";
		return id;
	}
	
	/**
	 * Save dialog txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Save dialog text
	public static WebElement saveDialog_txt(WebDriver driver){
		element = driver.findElement(By.id("divMessageOK"));
		return element;
	}
	
	/**
	 * Save dialog txt.
	 *
	 * @return the string
	 */
	public static String saveDialog_txt(){
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
	 * Ok alert btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Default vendors button
	public static WebElement okAlert_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("input[value='OK'][type='button'][onclick='javascript:HideAlert();']"));
		return element;
	}
	
	/**
	 * Ok alert btn.
	 *
	 * @return the string
	 */
	public static String okAlert_btn(){
		cssSelector = "input[value='OK'][type='button'][onclick='javascript:HideAlert();']";
		return cssSelector;
	}
	
	/**
	 * Default vendors btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Default vendors button
	public static WebElement defaultVendors_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/App_Themes/FlatGrayscale/Icons/checkbox.png']"));
		return element;
	}
	
	/**
	 * Default vendors btn.
	 *
	 * @return the string
	 */
	public static String defaultVendors_btn(){
		cssSelector = "img[src='/App_Themes/FlatGrayscale/Icons/checkbox.png']";
		return cssSelector;
	}
	
	/**
	 * Save default vendors btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Default vendors Save button
	public static WebElement saveDefaultVendors_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_btnDefaultVendorsSave"));
		return element;
	}
	
	/**
	 * Save default vendors btn.
	 *
	 * @return the string
	 */
	public static String saveDefaultVendors_btn(){
		id = "Dialogs_Dialogs_btnDefaultVendorsSave";
		return id;
	}
	
	/**
	 * Default vendors dialog txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Default vendors Dialog text
	public static WebElement defaultVendorsDialog_txt(WebDriver driver){
		element = driver.findElement(By.id("divDefaultVendors"));
		return element;
	}
	
	/**
	 * Default vendors dialog txt.
	 *
	 * @return the string
	 */
	public static String defaultVendorsDialog_txt(){
		id = "divDefaultVendors";
		return id;
	}
	
	/**
	 * Residential products dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Residential products dropdown
	public static WebElement residentialProducts_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ddlResidentialAppraiser"));
		return element;
	}
	
	/**
	 * Residential products dropdown.
	 *
	 * @return the string
	 */
	public static String residentialProducts_dropdown(){
		id = "Dialogs_Dialogs_ddlResidentialAppraiser";
		return id;
	}
	
	/**
	 * Commercial products dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Commercial products dropdown
	public static WebElement commercialProducts_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ddlCommercialAppraiser"));
		return element;
	}
	
	/**
	 * Commercial products dropdown.
	 *
	 * @return the string
	 */
	public static String commercialProducts_dropdown(){
		id = "Dialogs_Dialogs_ddlCommercialAppraiser";
		return id;
	}
	
	/**
	 * Broker price opinions dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Broker Price Opinions dropdown
	public static WebElement brokerPriceOpinions_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ddlAgentBroker"));
		return element;
	}
	
	/**
	 * Broker price opinions dropdown.
	 *
	 * @return the string
	 */
	public static String brokerPriceOpinions_dropdown(){
		id = "Dialogs_Dialogs_ddlAgentBroker";
		return id;
	}
	
	/**
	 * Inspection products dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Inspection products dropdown
	public static WebElement inspectionProducts_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ddlInspector"));
		return element;
	}
	
	/**
	 * Inspection products dropdown.
	 *
	 * @return the string
	 */
	public static String inspectionProducts_dropdown(){
		id = "Dialogs_Dialogs_ddlInspector";
		return id;
	}
	
	/**
	 * Mercury network directory radio.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Mercury Network Directory radio button
	public static WebElement mercuryNetworkDirectory_radio(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_rdMercuryPanel"));
		return element;
	}
	
	/**
	 * Mercury network directory radio.
	 *
	 * @return the string
	 */
	public static String mercuryNetworkDirectory_radio(){
		id = "Main_Main_rdMercuryPanel";
		return id;
	}
	
	/**
	 * Custom fee panel radio.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Custom Fee Panel radio button
	public static WebElement customFeePanel_radio(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_rdCustomPanel"));
		return element;
	}
	
	/**
	 * Custom fee panel radio.
	 *
	 * @return the string
	 */
	public static String customFeePanel_radio(){
		id = "Main_Main_rdCustomPanel";
		return id;
	}
	
	/**
	 * Use mercury network directory as backup chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Use Mercury Network Directory as backup checkbox
	public static WebElement useMercuryNetworkDirectoryAsBackup_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_chkMercuryPanelBackup"));
		return element;
	}
	
	/**
	 * Use mercury network directory as backup chkbx.
	 *
	 * @return the string
	 */
	public static String useMercuryNetworkDirectoryAsBackup_chkbx(){
		id = "Main_Main_chkMercuryPanelBackup";
		return id;
	}
	
	/**
	 * Sets the default order expiration time chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Set Default Order Expiration Time checkbox
	public static WebElement setDefaultOrderExpirationTime_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_chkExpireTime"));
		return element;
	}
	
	/**
	 * Sets the default order expiration time chkbx.
	 *
	 * @return the string
	 */
	public static String setDefaultOrderExpirationTime_chkbx(){
		id = "Main_Main_chkExpireTime";
		return id;
	}
	
	/**
	 * Pay all transaction fees chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Pay All Transaction Fees checkbox
	public static WebElement payAllTransactionFees_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_chkPayAllTransctionFees"));
		return element;
	}
	
	/**
	 * Pay all transaction fees chkbx.
	 *
	 * @return the string
	 */
	public static String payAllTransactionFees_chkbx(){
		id = "Main_Main_chkPayAllTransctionFees";
		return id;
	}
	
	/**
	 * Require valid license chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Require valid license checkbox
	public static WebElement requireValidLicense_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_ucRanking_chkRequireValidLicense"));
		return element;
	}
	
	/**
	 * Require valid license chkbx.
	 *
	 * @return the string
	 */
	public static String requireValidLicense_chkbx(){
		id = "Main_Main_ucRanking_chkRequireValidLicense";
		return id;
	}
	
	/**
	 * Require local vendor chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Require local vendor checkbox
	public static WebElement requireLocalVendor_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_ucRanking_chkRequireLocalVendor"));
		return element;
	}
	
	/**
	 * Require local vendor chkbx.
	 *
	 * @return the string
	 */
	public static String requireLocalVendor_chkbx(){
		id = "Main_Main_ucRanking_chkRequireLocalVendor";
		return id;
	}
	
	/**
	 * Require years of experience chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Require years of experience checkbox
	public static WebElement requireYearsOfExperience_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_ucRanking_chkRequireExperience"));
		return element;
	}
	
	/**
	 * Require years of experience chkbx.
	 *
	 * @return the string
	 */
	public static String requireYearsOfExperience_chkbx(){
		id = "Main_Main_ucRanking_chkRequireExperience";
		return id;
	}
	
	/**
	 * Require staff vendor chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Require staff vendor checkbox
	public static WebElement requireStaffVendor_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_ucRanking_chkRequireStaffVendor"));
		return element;
	}
	
	/**
	 * Require staff vendor chkbx.
	 *
	 * @return the string
	 */
	public static String requireStaffVendor_chkbx(){
		id = "Main_Main_ucRanking_chkRequireStaffVendor";
		return id;
	}
	
	/**
	 * Require staff vendor dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Require staff vendor dropdown
	public static WebElement requireStaffVendor_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_ucRanking_ddlRequireStaffVendor"));
		return element;
	}
	
	/**
	 * Require staff vendor dropdown.
	 *
	 * @return the string
	 */
	public static String requireStaffVendor_dropdown(){
		id = "Main_Main_ucRanking_ddlRequireStaffVendor";
		return id;
	}
	
	/**
	 * Exclude past due vendors chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Exclude past due vendors checkbox
	public static WebElement excludePastDueVendors_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_ucRanking_chkExcludePastDueVendors"));
		return element;
	}
	
	/**
	 * Exclude past due vendors chkbx.
	 *
	 * @return the string
	 */
	public static String excludePastDueVendors_chkbx(){
		id = "Main_Main_ucRanking_chkExcludePastDueVendors";
		return id;
	}
	
	/**
	 * Require errors and omissions chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Require errors and omissions checkbox
	public static WebElement requireErrorsAndOmissions_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_ucRanking_chkRequireInsurance"));
		return element;
	}
	
	/**
	 * Require errors and omissions chkbx.
	 *
	 * @return the string
	 */
	public static String requireErrorsAndOmissions_chkbx(){
		id = "Main_Main_ucRanking_chkRequireInsurance";
		return id;
	}
	
	/**
	 * Require vendor rating chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Require vendor rating checkbox
	public static WebElement requireVendorRating_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_ucRanking_chkRequireVendorRating"));
		return element;
	}
	
	/**
	 * Require vendor rating chkbx.
	 *
	 * @return the string
	 */
	public static String requireVendorRating_chkbx(){
		id = "Main_Main_ucRanking_chkRequireVendorRating";
		return id;
	}
	
	/**
	 * Limit vendor capacity chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Limit vendor capacity checkbox
	public static WebElement limitVendorCapacity_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_ucRanking_chkLimitVendorCapacity"));
		return element;
	}
	
	/**
	 * Limit vendor capacity chkbx.
	 *
	 * @return the string
	 */
	public static String limitVendorCapacity_chkbx(){
		id = "Main_Main_ucRanking_chkLimitVendorCapacity";
		return id;
	}
	
	/**
	 * Limit vendor capacity dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Limit vendor capacity dropdown
	public static WebElement limitVendorCapacity_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_ucRanking_ddlLimitVendorCapacity"));
		return element;
	}
	
	/**
	 * Limit vendor capacity dropdown.
	 *
	 * @return the string
	 */
	public static String limitVendorCapacity_dropdown(){
		id = "Main_Main_ucRanking_ddlLimitVendorCapacity";
		return id;
	}
	
	/**
	 * Limit vendor capacity open orders txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Limit vendor capacity open orders
	public static WebElement limitVendorCapacityOpenOrders_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_ucRanking_txtLimitVendorOrderCapacity"));
		return element;
	}
	
	/**
	 * Limit vendor capacity open orders txtbx.
	 *
	 * @return the string
	 */
	public static String limitVendorCapacityOpenOrders_txtbx(){
		id = "Main_Main_ucRanking_txtLimitVendorOrderCapacity";
		return id;
	}
	
	/**
	 * Enforce vendor priority chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Enforce vendor priority checkbox
	public static WebElement enforceVendorPriority_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_ucRanking_chkEnforceVendorPriority"));
		return element;
	}
	
	/**
	 * Enforce vendor priority chkbx.
	 *
	 * @return the string
	 */
	public static String enforceVendorPriority_chkbx(){
		id = "Main_Main_ucRanking_chkEnforceVendorPriority";
		return id;
	}
	
	/**
	 * Consider unranked vendors chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Consider unranked vendors checkbox
	public static WebElement considerUnrankedVendors_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_ucRanking_chkConsiderUnranked"));
		return element;
	}
	
	/**
	 * Consider unranked vendors chkbx.
	 *
	 * @return the string
	 */
	public static String considerUnrankedVendors_chkbx(){
		id = "Main_Main_ucRanking_chkConsiderUnranked";
		return id;
	}
	
	/**
	 * Allow order bidding btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Allow order bidding button
	public static WebElement allowOrderBidding_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_swBidAllow_imgSwitch"));
		return element;
	}
	
	/**
	 * Allow order bidding btn.
	 *
	 * @return the string
	 */
	public static String allowOrderBidding_btn(){
		id = "Main_Main_swBidAllow_imgSwitch";
		return id;
	}
	
	/**
	 * Automatic vendor selection switch.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Automatic vendor selection button
	public static WebElement automaticVendorSelection_switch(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_swAutoAssign_imgSwitch"));
		return element;
	}
	
	/**
	 * Automatic vendor selection switch.
	 *
	 * @return the string
	 */
	public static String automaticVendorSelection_switch(){
		id = "Main_Main_swAutoAssign_imgSwitch";
		return id;
	}
	
	/**
	 * Select at least txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Select at least textbox
	public static WebElement selectAtLeast_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_txtSelectMinimum"));
		return element;
	}
	
	/**
	 * Select at least txtbx.
	 *
	 * @return the string
	 */
	public static String selectAtLeast_txtbx(){
		id = "Main_Main_txtSelectMinimum";
		return id;
	}
	
	/**
	 * And at most txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// And at most textbox
	public static WebElement andAtMost_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_txtSelectMaximum"));
		return element;
	}
	
	/**
	 * And at most txtbx.
	 *
	 * @return the string
	 */
	public static String andAtMost_txtbx(){
		id = "Main_Main_txtSelectMaximum";
		return id;
	}
	
	/**
	 * Allow order bidding switch.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Allow order bidding button
	public static WebElement allowOrderBidding_switch(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_swBidAllow_imgSwitch"));
		return element;
	}
	
	/**
	 * Allow order bidding switch.
	 *
	 * @return the string
	 */
	public static String allowOrderBidding_switch(){
		id = "Main_Main_swBidAllow_imgSwitch";
		return id;
	}
	
	/**
	 * Fee lock btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Fee lock button
	public static WebElement feeLock_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_imgFeeLock"));
		return element;
	}
	
	/**
	 * Fee lock btn.
	 *
	 * @return the string
	 */
	public static String feeLock_btn(){
		id = "Main_Main_imgFeeLock";
		return id;
	}
	
	/**
	 * Date lock btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Date lock button
	public static WebElement dateLock_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_imgDateLock"));
		return element;
	}
	
	/**
	 * Date lock btn.
	 *
	 * @return the string
	 */
	public static String dateLock_btn(){
		id = "Main_Main_imgDateLock";
		return id;
	}
	
	/**
	 * Default bid due div.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Default bid due div
	public static WebElement defaultBidDue_div(WebDriver driver){
		element = driver.findElement(By.id("divBidExpirationDate"));
		return element;
	}
	
	/**
	 * Default bid due div.
	 *
	 * @return the string
	 */
	public static String defaultBidDue_div(){
		id = "divBidExpirationDate";
		return id;
	}
	
	/**
	 * Default bid due chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Default bid due checkbox
	public static WebElement defaultBidDue_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_chkSetDefaultBidDue"));
		return element;
	}
	
	/**
	 * Default bid due chkbx.
	 *
	 * @return the string
	 */
	public static String defaultBidDue_chkbx(){
		id = "Main_Main_chkSetDefaultBidDue";
		return id;
	}
	
	/**
	 * Default bid due hours txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Default bid due hours txtbx
	public static WebElement defaultBidDueHours_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_txtBidDueHours"));
		return element;
	}
	
	/**
	 * Default bid due hours txtbx.
	 *
	 * @return the string
	 */
	public static String defaultBidDueHours_txtbx(){
		id = "Main_Main_txtBidDueHours";
		return id;
	}
	
	/**
	 * Stop and notify me after attempts chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Stop and notify me after attempts checkbox
	public static WebElement stopAndNotifyMeAfterAttempts_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_chkReassignLimit"));
		return element;
	}
	
	/**
	 * Stop and notify me after attempts chkbx.
	 *
	 * @return the string
	 */
	public static String stopAndNotifyMeAfterAttempts_chkbx(){
		id = "Main_Main_chkReassignLimit";
		return id;
	}
	
	/**
	 * Use supervisor chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Use supervisor checkbox
	public static WebElement useSupervisor_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_ucRanking_chkUseSupervisor"));
		return element;
	}
	
	/**
	 * Use supervisor chkbx.
	 *
	 * @return the string
	 */
	public static String useSupervisor_chkbx(){
		id = "Main_Main_ucRanking_chkUseSupervisor";
		return id;
	}
	
	/**
	 * Supervisor with trainees dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// supervisorWithTrainees_dropdown
	public static WebElement supervisorWithTrainees_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_ucRanking_ddlUseSupervisor"));
		return element;
	}
	
	/**
	 * Supervisor with trainees dropdown.
	 *
	 * @return the string
	 */
	public static String supervisorWithTrainees_dropdown(){
		id = "Main_Main_ucRanking_ddlUseSupervisor";
		return id;
	}
	
}
