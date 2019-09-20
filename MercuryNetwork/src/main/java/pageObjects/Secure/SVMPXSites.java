package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure VMP XSites page
 */
public class SVMPXSites {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The css selector. */
	private static String cssSelector = null;
	
	/** The id. */
	private static String id = null;
	
	/** The link text. */
	private static String linkText = null;

	
	/**
	 * Product list lnk.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Product List link
	public static WebElement productList_lnk(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_navLinkProducts"));
		return element;
	}
	
	/**
	 * Product list lnk.
	 *
	 * @return the string
	 */
	public static String productList_lnk(){
		id = "Main_Main_navLinkProducts";
		return id;
	}
	
	/**
	 * Configure status mapping lnk.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Configure Status Mapping link
	public static WebElement configureStatusMapping_lnk(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_navLinkStatusMapping"));
		return element;
	}
	
	/**
	 * Configure status mapping lnk.
	 *
	 * @return the string
	 */
	public static String configureStatusMapping_lnk(){
		id = "Main_Main_navLinkStatusMapping";
		return id;
	}
	
	/**
	 * Configure order form lnk.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Configure Order Form link
	public static WebElement configureOrderForm_lnk(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_navLinkOrderForm"));
		return element;
	}
	
	/**
	 * Configure order form lnk.
	 *
	 * @return the string
	 */
	public static String configureOrderForm_lnk(){
		id = "Main_Main_navLinkOrderForm";
		return id;
	}
	
	/**
	 * Configure automatic settings lnk.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Configure Automatic Settings link
	public static WebElement configureAutomaticSettings_lnk(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_navLinkAutomaticSettings"));
		return element;
	}
	
	/**
	 * Configure automatic settings lnk.
	 *
	 * @return the string
	 */
	public static String configureAutomaticSettings_lnk(){
		id = "Main_Main_navLinkAutomaticSettings";
		return id;
	}
	
	/**
	 * Compliance certificate lnk.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Compliance Certificate link
	public static WebElement complianceCertificate_lnk(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_navLinkComplianceCert"));
		return element;
	}
	
	/**
	 * Compliance certificate lnk.
	 *
	 * @return the string
	 */
	public static String complianceCertificate_lnk(){
		id = "Main_Main_navLinkComplianceCert";
		return id;
	}
	
	/**
	 * Product information txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Product Information text
	public static WebElement productInformation_txt(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_grdProductMappings"));
		return element;
	}
	
	/**
	 * Product information txt.
	 *
	 * @return the string
	 */
	public static String productInformation_txt(){
		id = "Main_Main_Main_grdProductMappings";
		return id;
	}
	
	/**
	 * Do not pass VMP comments to the vendor chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Do not pass VMP Comments to the vendor checkbox
	public static WebElement doNotPassVMPCommentsToTheVendor_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_cbEnable_VMPComment_DoNotSync"));
		return element;
	}
	
	/**
	 * Do not pass VMP comments to the vendor chkbx.
	 *
	 * @return the string
	 */
	public static String doNotPassVMPCommentsToTheVendor_chkbx(){
		id = "Main_Main_Main_cbEnable_VMPComment_DoNotSync";
		return id;
	}
	
	/**
	 * Assign supplemental orders to the vendor that completed the original appraisal chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Assign supplemental orders to the vendor that completed the original appraisal checkbox
	public static WebElement assignSupplementalOrdersToTheVendorThatCompletedTheOriginalAppraisal_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_cbEnable_AssignSupplementalOrders"));
		return element;
	}
	
	/**
	 * Assign supplemental orders to the vendor that completed the original appraisal chkbx.
	 *
	 * @return the string
	 */
	public static String assignSupplementalOrdersToTheVendorThatCompletedTheOriginalAppraisal_chkbx(){
		id = "Main_Main_Main_cbEnable_AssignSupplementalOrders";
		return id;
	}
	
	/**
	 * Use fee when assigning orders dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Use fee when assigning orders
	public static WebElement useFeeWhenAssigningOrders_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_ddlVendorFeeOptions"));
		return element;
	}
	
	/**
	 * Use fee when assigning orders dropdown.
	 *
	 * @return the string
	 */
	public static String useFeeWhenAssigningOrders_dropdown(){
		id = "Main_Main_Main_ddlVendorFeeOptions";
		return id;
	}
	
	/**
	 * Use vendor override fee whenever possible chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Use vendor override fee whenever possible checkbox
	public static WebElement useVendorOverrideFeeWheneverPossible_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_cbEnable_UseVendorOverride"));
		return element;
	}
	
	/**
	 * Use vendor override fee whenever possible chkbx.
	 *
	 * @return the string
	 */
	public static String useVendorOverrideFeeWheneverPossible_chkbx(){
		id = "Main_Main_Main_cbEnable_UseVendorOverride";
		return id;
	}
	
	/**
	 * Always use the new vendors published fee when reassigning an order chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Always use the new vendor's published fee when re-assigning an order checkbox
	public static WebElement alwaysUseTheNewVendorsPublishedFeeWhenReassigningAnOrder_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_cbEnable_AlwaysUseNewVendorFeeReassign"));
		return element;
	}
	
	/**
	 * Always use the new vendors published fee when reassigning an order chkbx.
	 *
	 * @return the string
	 */
	public static String alwaysUseTheNewVendorsPublishedFeeWhenReassigningAnOrder_chkbx(){
		id = "Main_Main_Main_cbEnable_AlwaysUseNewVendorFeeReassign";
		return id;
	}
	
	/**
	 * Apply percent of the VMPX site fee as the vendors fee txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Apply % of the VMP XSite fee as the vendor's fee textbox
	public static WebElement applyPercentOfTheVMPXSiteFeeAsTheVendorsFee_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_tbFeePercent"));
		return element;
	}
	
	/**
	 * Apply percent of the VMPX site fee as the vendors fee txtbx.
	 *
	 * @return the string
	 */
	public static String applyPercentOfTheVMPXSiteFeeAsTheVendorsFee_txtbx(){
		id = "Main_Main_Main_tbFeePercent";
		return id;
	}
	
	/**
	 * Sets the the payment method to dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Set the payment method to dropdown
	public static WebElement setThePaymentMethodTo_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_ddlDefaultPaymentMethod"));
		return element;
	}
	
	/**
	 * Sets the the payment method to dropdown.
	 *
	 * @return the string
	 */
	public static String setThePaymentMethodTo_dropdown(){
		id = "Main_Main_Main_ddlDefaultPaymentMethod";
		return id;
	}
	
	/**
	 * Creates the invoice when order is placed chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Create invoice when order is placed checkbox
	public static WebElement createInvoiceWhenOrderIsPlaced_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_cbInvoice_CreateWhenOrderPlaced"));
		return element;
	}
	
	/**
	 * Creates the invoice when order is placed chkbx.
	 *
	 * @return the string
	 */
	public static String createInvoiceWhenOrderIsPlaced_chkbx(){
		id = "Main_Main_Main_cbInvoice_CreateWhenOrderPlaced";
		return id;
	}
	
	/**
	 * Attach invoice when credit card is charged chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Attach invoice when credit card is charged checkbox
	public static WebElement attachInvoiceWhenCreditCardIsCharged_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_cbInvoice_AttachWhenCCCharged"));
		return element;
	}
	
	/**
	 * Attach invoice when credit card is charged chkbx.
	 *
	 * @return the string
	 */
	public static String attachInvoiceWhenCreditCardIsCharged_chkbx(){
		id = "Main_Main_Main_cbInvoice_AttachWhenCCCharged";
		return id;
	}
	
	/**
	 * Attach invoice when order is marked complete chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Attach invoice when order is marked complete checkbox
	public static WebElement attachInvoiceWhenOrderIsMarkedComplete_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_cbInvoice_AttachWhenComplete"));
		return element;
	}
	
	/**
	 * Attach invoice when order is marked complete chkbx.
	 *
	 * @return the string
	 */
	public static String attachInvoiceWhenOrderIsMarkedComplete_chkbx(){
		id = "Main_Main_Main_cbInvoice_AttachWhenComplete";
		return id;
	}
	
	/**
	 * Include the vendors fee on the invoice chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Include the vendors fee on the invoice checkbox
	public static WebElement includeTheVendorsFeeOnTheInvoice_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_cbInvoice_IncludeVendorFee"));
		return element;
	}
	
	/**
	 * Include the vendors fee on the invoice chkbx.
	 *
	 * @return the string
	 */
	public static String includeTheVendorsFeeOnTheInvoice_chkbx(){
		id = "Main_Main_Main_cbInvoice_IncludeVendorFee";
		return id;
	}
	
	/**
	 * Sets the the invoice due date txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Set the invoice due date text box
	public static WebElement setTheInvoiceDueDate_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_tbInvoice_DueDateDaysFrom"));
		return element;
	}
	
	/**
	 * Sets the the invoice due date txtbx.
	 *
	 * @return the string
	 */
	public static String setTheInvoiceDueDate_txtbx(){
		id = "Main_Main_Main_tbInvoice_DueDateDaysFrom";
		return id;
	}
	
	/**
	 * Prefix txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Auto number prefix text box
	public static WebElement prefix_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_tbInvoice_Prefix"));
		return element;
	}
	
	/**
	 * Prefix txtbx.
	 *
	 * @return the string
	 */
	public static String prefix_txtbx(){
		id = "Main_Main_Main_tbInvoice_Prefix";
		return id;
	}
	
	/**
	 * Start number sequence txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Start number sequence text box
	public static WebElement startNumberSequence_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_tbInvoice_StartNumber"));
		return element;
	}
	
	/**
	 * Start number sequence txtbx.
	 *
	 * @return the string
	 */
	public static String startNumberSequence_txtbx(){
		id = "Main_Main_Main_tbInvoice_StartNumber";
		return id;
	}
	
	/**
	 * Status mapping configuration txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Status Mapping Configuration text
	public static WebElement statusMappingConfiguration_txt(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_upMain"));
		return element;
	}
	
	/**
	 * Status mapping configuration txt.
	 *
	 * @return the string
	 */
	public static String statusMappingConfiguration_txt(){
		id = "Main_Main_Main_upMain";
		return id;
	}
	
	/**
	 * Vmp X site dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Connected VMP XSite dropdown
	public static WebElement vmpXSite_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_ddlVMPXSites"));
		return element;
	}
	
	/**
	 * Vmp X site dropdown.
	 *
	 * @return the string
	 */
	public static String vmpXSite_dropdown(){
		id = "Main_Main_ddlVMPXSites";
		return id;
	}
	
	/**
	 * Document uploaded appraiser client gear icon as AM C btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Document Uploaded Appraiser Client Gear icon button
	public static WebElement documentUploadedAppraiserClientGearIconAsAMC_btn(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_ctl00_Main_Main_Main_gridStatusSyncMappings_it0_9_imgConfigureDocumentSync_Client"));
		return element;
	}
	
	/**
	 * Document uploaded appraiser client gear icon as AM C btn.
	 *
	 * @return the string
	 */
	public static String documentUploadedAppraiserClientGearIconAsAMC_btn(){
		id = "ctl00_ctl00_ctl00_Main_Main_Main_gridStatusSyncMappings_it0_9_imgConfigureDocumentSync_Client";
		return id;
	}
	
	/**
	 * Document uploaded appraiser vendor gear icon as AM C btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Document Uploaded Appraiser Vendor Gear icon button
	public static WebElement documentUploadedAppraiserVendorGearIconAsAMC_btn(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_ctl00_Main_Main_Main_gridStatusSyncMappings_it7_9_imgConfigureDocumentSync_Vendor"));
		return element;
	}
	
	/**
	 * Document uploaded appraiser vendor gear icon as AM C btn.
	 *
	 * @return the string
	 */
	public static String documentUploadedAppraiserVendorGearIconAsAMC_btn(){
		id = "ctl00_ctl00_ctl00_Main_Main_Main_gridStatusSyncMappings_it7_9_imgConfigureDocumentSync_Vendor";
		return id;
	}
	
	/**
	 * Document uploaded appraiser vendor gear icon as AMC 2 btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Document Uploaded Appraiser Vendor Gear icon button
	public static WebElement documentUploadedAppraiserVendorGearIconAsAMC2_btn(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_ctl00_Main_Main_Main_gridStatusSyncMappings_it7_12_imgConfigureDocumentSync_Vendor"));
		return element;
	}
	
	/**
	 * Document uploaded appraiser vendor gear icon as AMC 2 btn.
	 *
	 * @return the string
	 */
	public static String documentUploadedAppraiserVendorGearIconAsAMC2_btn(){
		id = "ctl00_ctl00_ctl00_Main_Main_Main_gridStatusSyncMappings_it7_12_imgConfigureDocumentSync_Vendor";
		return id;
	}
	
	/**
	 * Document uploaded appraiser client gear icon btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Document Uploaded Appraiser Client Gear icon button
	public static WebElement documentUploadedAppraiserClientGearIcon_btn(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_ctl00_Main_Main_Main_gridStatusSyncMappings_it0_11_imgConfigureDocumentSync_Client"));
		return element;
	}
	
	/**
	 * Document uploaded appraiser client gear icon btn.
	 *
	 * @return the string
	 */
	public static String documentUploadedAppraiserClientGearIcon_btn(){
		id = "ctl00_ctl00_ctl00_Main_Main_Main_gridStatusSyncMappings_it0_11_imgConfigureDocumentSync_Client";
		return id;
	}
	
	/**
	 * Document uploaded appraiser client gear icon 2 btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Document Uploaded Appraiser Client Gear icon button
	public static WebElement documentUploadedAppraiserClientGearIcon2_btn(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_ctl00_Main_Main_Main_gridStatusSyncMappings_it0_12_imgConfigureDocumentSync_Client"));
		return element;
	}
	
	/**
	 * Document uploaded appraiser client gear icon 2 btn.
	 *
	 * @return the string
	 */
	public static String documentUploadedAppraiserClientGearIcon2_btn(){
		id = "ctl00_ctl00_ctl00_Main_Main_Main_gridStatusSyncMappings_it0_12_imgConfigureDocumentSync_Client";
		return id;
	}
	
	/**
	 * Document uploaded appraiser vendor gear icon btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Document Uploaded Appraiser Vendor Gear icon button
	public static WebElement documentUploadedAppraiserVendorGearIcon_btn(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_ctl00_Main_Main_Main_gridStatusSyncMappings_it7_11_imgConfigureDocumentSync_Vendor"));
		return element;
	}
	
	/**
	 * Document uploaded appraiser vendor gear icon btn.
	 *
	 * @return the string
	 */
	public static String documentUploadedAppraiserVendorGearIcon_btn(){
		id = "ctl00_ctl00_ctl00_Main_Main_Main_gridStatusSyncMappings_it7_11_imgConfigureDocumentSync_Vendor";
		return id;
	}
	
	/**
	 * Document uploaded AMC client gear icon btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Document Uploaded AMC Client Gear icon button
	public static WebElement documentUploadedAMCClientGearIcon_btn(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_ctl00_Main_Main_Main_gridStatusSyncMappings_it0_8_imgConfigureDocumentSync_Client"));
		return element;
	}
	
	/**
	 * Document uploaded AMC client gear icon btn.
	 *
	 * @return the string
	 */
	public static String documentUploadedAMCClientGearIcon_btn(){
		id = "ctl00_ctl00_ctl00_Main_Main_Main_gridStatusSyncMappings_it0_8_imgConfigureDocumentSync_Client";
		return id;
	}
	
	/**
	 * Document uploaded AMC vendor gear icon btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Document Uploaded AMC Vendor Gear icon button
	public static WebElement documentUploadedAMCVendorGearIcon_btn(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_ctl00_Main_Main_Main_gridStatusSyncMappings_it7_8_imgConfigureDocumentSync_Vendor"));
		return element;
	}
	
	/**
	 * Document uploaded AMC vendor gear icon btn.
	 *
	 * @return the string
	 */
	public static String documentUploadedAMCVendorGearIcon_btn(){
		id = "ctl00_ctl00_ctl00_Main_Main_Main_gridStatusSyncMappings_it7_8_imgConfigureDocumentSync_Vendor";
		return id;
	}
	
	/**
	 * Document uploaded AMC vendor gear icon 2 btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Document Uploaded AMC Vendor Gear icon button
	public static WebElement documentUploadedAMCVendorGearIcon2_btn(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_ctl00_Main_Main_Main_gridStatusSyncMappings_it7_6_imgConfigureDocumentSync_Vendor"));
		return element;
	}
	
	/**
	 * Document uploaded AMC vendor gear icon 2 btn.
	 *
	 * @return the string
	 */
	public static String documentUploadedAMCVendorGearIcon2_btn(){
		id = "ctl00_ctl00_ctl00_Main_Main_Main_gridStatusSyncMappings_it7_6_imgConfigureDocumentSync_Vendor";
		return id;
	}
	
	/**
	 * Market information chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Market Information checkbox
	public static WebElement marketInformation_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_Dialogs_ctrlViewVMPSyncDocumentOptions_Client_chkItems_17"));
		return element;
	}
	
	/**
	 * Market information chkbx.
	 *
	 * @return the string
	 */
	public static String marketInformation_chkbx(){
		id = "Dialogs_Dialogs_Dialogs_ctrlViewVMPSyncDocumentOptions_Client_chkItems_17";
		return id;
	}
	
	/**
	 * Market information txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Market Information Label text
	public static WebElement marketInformation_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector("#Dialogs_Dialogs_Dialogs_ctrlViewVMPSyncDocumentOptions_Client_chkItems > tbody:nth-child(1) > tr:nth-child(4) > td:nth-child(2) > label:nth-child(2)"));
		return element;
	}
	
	/**
	 * Market information txt.
	 *
	 * @return the string
	 */
	public static String marketInformation_txt(){
		cssSelector = "#Dialogs_Dialogs_Dialogs_ctrlViewVMPSyncDocumentOptions_Client_chkItems > tbody:nth-child(1) > tr:nth-child(4) > td:nth-child(2) > label:nth-child(2)";
		return cssSelector;
	}
	
	/**
	 * Sales contract chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Sales Contract checkbox
	public static WebElement salesContract_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_Dialogs_ctrlViewVMPSyncDocumentOptions_Vendor_chkItems_22"));
		return element;
	}
	
	/**
	 * Sales contract chkbx.
	 *
	 * @return the string
	 */
	public static String salesContract_chkbx(){
		id = "Dialogs_Dialogs_Dialogs_ctrlViewVMPSyncDocumentOptions_Vendor_chkItems_22";
		return id;
	}
	
	/**
	 * Sales contract txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Sales Contract text
	public static WebElement salesContract_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector("#Dialogs_Dialogs_Dialogs_ctrlViewVMPSyncDocumentOptions_Vendor_chkItems > tbody > tr:nth-child(9) > td:nth-child(2) > label"));
		return element;
	}
	
	/**
	 * Sales contract txt.
	 *
	 * @return the string
	 */
	public static String salesContract_txt(){
		cssSelector = "#Dialogs_Dialogs_Dialogs_ctrlViewVMPSyncDocumentOptions_Vendor_chkItems > tbody > tr:nth-child(9) > td:nth-child(2) > label";
		return cssSelector;
	}
	
	/**
	 * Ok product btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// OK Product button
	public static WebElement okProduct_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("input[onclick='javascript:btnAddEditProductOk_Click();']"));
		return element;
	}
	
	/**
	 * Ok product btn.
	 *
	 * @return the string
	 */
	public static String okProduct_btn(){
		cssSelector = "input[onclick='javascript:btnAddEditProductOk_Click();']";
		return cssSelector;
	}
	
	/**
	 * Ok sync to VMP checkboxes client btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Sync To VMP OK Client button 
	public static WebElement okSyncToVMPCheckboxesClient_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_Dialogs_ctrlViewVMPSyncDocumentOptions_Client_btnCheckboxGroupPopup_OK"));
		return element;
	}
	
	/**
	 * Ok sync to VMP checkboxes client btn.
	 *
	 * @return the string
	 */
	public static String okSyncToVMPCheckboxesClient_btn(){
		id = "Dialogs_Dialogs_Dialogs_ctrlViewVMPSyncDocumentOptions_Client_btnCheckboxGroupPopup_OK";
		return id;
	}
	
	/**
	 * Ok sync to VMP checkboxes client 2 btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Sync To VMP OK Client button 
	public static WebElement okSyncToVMPCheckboxesClient2_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_Dialogs_ctrlViewVMPSyncDocumentOptions_Client_btnCheckboxGroupPopup_OK"));
		return element;
	}
	
	/**
	 * Ok sync to VMP checkboxes client 2 btn.
	 *
	 * @return the string
	 */
	public static String okSyncToVMPCheckboxesClient2_btn(){
		id = "Dialogs_Dialogs_Dialogs_ctrlViewVMPSyncDocumentOptions_Client_btnCheckboxGroupPopup_OK";
		return id;
	}
	
	/**
	 * Ok sync to VMP checkboxes vendor btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Sync To VMP OK Vendor button 
	public static WebElement okSyncToVMPCheckboxesVendor_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_Dialogs_ctrlViewVMPSyncDocumentOptions_Vendor_btnCheckboxGroupPopup_OK"));
		return element;
	}
	
	/**
	 * Ok sync to VMP checkboxes vendor btn.
	 *
	 * @return the string
	 */
	public static String okSyncToVMPCheckboxesVendor_btn(){
		id = "Dialogs_Dialogs_Dialogs_ctrlViewVMPSyncDocumentOptions_Vendor_btnCheckboxGroupPopup_OK";
		return id;
	}
	
//	/**
//	 * Pending quality review VM P btn.
//	 *
//	 * @param driver the driver
//	 * @return the web element
//	 */
//	// Pending Quality Review VMP arrow
//	public static WebElement pendingQualityReviewVMP_btn(WebDriver driver){
//		element = driver.findElement(By.id("ctl00_ctl00_ctl00_Main_Main_Main_gridStatusSyncMappings_it3_20_imgSync"));
//		return element;
//	}
//	
//	/**
//	 * Pending quality review VM P btn.
//	 *
//	 * @return the string
//	 */
//	public static String pendingQualityReviewVMP_btn(){
//		id = "ctl00_ctl00_ctl00_Main_Main_Main_gridStatusSyncMappings_it3_20_imgSync";
//		return id;
//	}
//	
//	/**
//	 * Message VM P btn.
//	 *
//	 * @param driver the driver
//	 * @return the web element
//	 */
//	// Message VMP arrow
//	public static WebElement messageVMP_btn(WebDriver driver){
//		element = driver.findElement(By.id("ctl00_ctl00_ctl00_Main_Main_Main_gridStatusSyncMappings_it3_14_imgSync"));
//		return element;
//	}
//	
//	/**
//	 * Message VM P btn.
//	 *
//	 * @return the string
//	 */
//	public static String messageVMP_btn(){
//		id = "ctl00_ctl00_ctl00_Main_Main_Main_gridStatusSyncMappings_it3_14_imgSync";
//		return id;
//	}
//	
//	/**
//	 * Message mercury btn.
//	 *
//	 * @param driver the driver
//	 * @return the web element
//	 */
//	// Message Mercury arrow
//	public static WebElement messageMercury_btn(WebDriver driver){
//		element = driver.findElement(By.id("ctl00_ctl00_ctl00_Main_Main_Main_gridStatusSyncMappings_it6_14_imgSync"));
//		return element;
//	}
//	
//	/**
//	 * Message mercury btn.
//	 *
//	 * @return the string
//	 */
//	public static String messageMercury_btn(){
//		id = "ctl00_ctl00_ctl00_Main_Main_Main_gridStatusSyncMappings_it6_14_imgSync";
//		return id;
//	}
	
	/**
	 * Allow clients to enter fee chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Allow clients to enter fee checkbox
	public static WebElement allowClientsToEnterFee_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_chkAllowEnterFee"));
		return element;
	}
	
	/**
	 * Allow clients to enter fee chkbx.
	 *
	 * @return the string
	 */
	public static String allowClientsToEnterFee_chkbx(){
		id = "Main_Main_Main_chkAllowEnterFee";
		return id;
	}
	
	/**
	 * Provides disclosure tracking chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Provides disclosure tracking checkbox
	public static WebElement providesDisclosureTracking_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_chkProvideDisclosureTracking"));
		return element;
	}
	
	/**
	 * Provides disclosure tracking chkbx.
	 *
	 * @return the string
	 */
	public static String providesDisclosureTracking_chkbx(){
		id = "Main_Main_Main_chkProvideDisclosureTracking";
		return id;
	}
	
	/**
	 * Require sales contract chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Require sales contract checkbox
	public static WebElement requireSalesContract_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_chkRequireSalesContract"));
		return element;
	}
	
	/**
	 * Require sales contract chkbx.
	 *
	 * @return the string
	 */
	public static String requireSalesContract_chkbx(){
		id = "Main_Main_Main_chkRequireSalesContract";
		return id;
	}
	
	/**
	 * Options btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Options button
	public static WebElement options_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("td > img[src='/images/GearsIcon16x16.png']"));
		return element;
	}
	
	/**
	 * Options btn.
	 *
	 * @return the string
	 */
	public static String options_btn(){
		cssSelector = "td > img[src='/images/GearsIcon16x16.png']";
		return cssSelector;
	}
	
	/**
	 * Always attach A copy of the compliance certificate chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Always attach a copy of the Compliance Certificate checkbox
	public static WebElement alwaysAttachACopyOfTheComplianceCertificate_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_Dialogs_chkAttachCert"));
		return element;
	}
	
	/**
	 * Always attach A copy of the compliance certificate chkbx.
	 *
	 * @return the string
	 */
	public static String alwaysAttachACopyOfTheComplianceCertificate_chkbx(){
		id = "Dialogs_Dialogs_Dialogs_chkAttachCert";
		return id;
	}
	
	/**
	 * O K btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// OK button
	public static WebElement OK_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("input.Button[value='OK'][onclick='javascript:btnDocSettingsOK_Click();']"));
		return element;
	}
	
	/**
	 * O K btn.
	 *
	 * @return the string
	 */
	public static String OK_btn(){
		cssSelector = "input.Button[value='OK'][onclick='javascript:btnDocSettingsOK_Click();']";
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
		element = driver.findElement(By.cssSelector("img[src='Images/Save16x16.png']"));
		return element;
	}
	
	/**
	 * Save btn.
	 *
	 * @return the string
	 */
	public static String save_btn(){
		cssSelector = "img[src='Images/Save16x16.png']";
		return cssSelector;
	}
	
	/**
	 * New product btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// New Product button
	public static WebElement newProduct_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='Images/NewProductIcon16x16.png']"));
		return element;
	}
	
	/**
	 * New product btn.
	 *
	 * @return the string
	 */
	public static String newProduct_btn(){
		cssSelector = "img[src='Images/NewProductIcon16x16.png']";
		return cssSelector;
	}
	
	/**
	 * Edits the product btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Edit Product button
	public static WebElement editProduct_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='Images/EditProductIcon16x16.png']"));
		return element;
	}
	
	/**
	 * Edits the product btn.
	 *
	 * @return the string
	 */
	public static String editProduct_btn(){
		cssSelector = "img[src='Images/EditProductIcon16x16.png']";
		return cssSelector;
	}
	
	/**
	 * Delete product btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Delete Product button
	public static WebElement deleteProduct_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='Images/DeleteIcon16x16.png']"));
		return element;
	}
	
	/**
	 * Delete product btn.
	 *
	 * @return the string
	 */
	public static String deleteProduct_btn(){
		cssSelector = "img[src='Images/DeleteIcon16x16.png']";
		return cssSelector;
	}
	
	/**
	 * Adds the fees btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Add Fees button
	public static WebElement addFees_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/Images/PlusSquare-Green.O.png']"));
		return element;
	}
	
	/**
	 * Adds the fees btn.
	 *
	 * @return the string
	 */
	public static String addFees_btn(){
		cssSelector = "img[src='/Images/PlusSquare-Green.O.png']";
		return cssSelector;
	}
	
	/**
	 * Save complete O K btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Save Complete OK button
	public static WebElement saveCompleteOK_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("input[value='OK'][onclick='javascript:HideAlert();']"));
		return element;
	}
	
	/**
	 * Save complete O K btn.
	 *
	 * @return the string
	 */
	public static String saveCompleteOK_btn(){
		cssSelector = "input[value='OK'][onclick='javascript:HideAlert();']";
		return cssSelector;
	}
	
	/**
	 * Compliance certificate save btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Compliance Certificate Save button
	public static WebElement complianceCertificateSave_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/images/Save16x16.png']"));
		return element;
	}
	
	/**
	 * Compliance certificate save btn.
	 *
	 * @return the string
	 */
	public static String complianceCertificateSave_btn(){
		cssSelector = "img[src='/images/Save16x16.png']";
		return cssSelector;
	}
	
	/**
	 * Amc firm btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// AMC/Firm button
	public static WebElement amcFirm_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("div[data-name='AMC']"));
		return element;
	}
	
	/**
	 * Amc firm btn.
	 *
	 * @return the string
	 */
	public static String amcFirm_btn(){
		cssSelector = "div[data-name='AMC']";
		return cssSelector;
	}
	
	/**
	 * Product description txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Product Description textbox
	public static WebElement productDescription_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_Dialogs_txtProductDescription"));
		return element;
	}
	
	/**
	 * Product description txtbx.
	 *
	 * @return the string
	 */
	public static String productDescription_txtbx(){
		id = "Dialogs_Dialogs_Dialogs_txtProductDescription";
		return id;
	}
	
	/**
	 * Default fee txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Default Fee textbox
	public static WebElement defaultFee_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_Dialogs_txtDefaultFee"));
		return element;
	}
	
	/**
	 * Default fee txtbx.
	 *
	 * @return the string
	 */
	public static String defaultFee_txtbx(){
		id = "Dialogs_Dialogs_Dialogs_txtDefaultFee";
		return id;
	}
	
	/**
	 * Default fee notes txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Default Fee Notes textbox
	public static WebElement defaultFeeNotes_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_Dialogs_txtFeeNotes"));
		return element;
	}
	
	/**
	 * Default fee notes txtbx.
	 *
	 * @return the string
	 */
	public static String defaultFeeNotes_txtbx(){
		id = "Dialogs_Dialogs_Dialogs_txtFeeNotes";
		return id;
	}
	
	/**
	 * Yes delete product btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Yes Delete Product button
	public static WebElement yesDeleteProduct_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("input[onclick='javascript:btnDeleteProductYes_Click();']"));
		return element;
	}
	
	/**
	 * Yes delete product btn.
	 *
	 * @return the string
	 */
	public static String yesDeleteProduct_btn(){
		cssSelector = "input[onclick='javascript:btnDeleteProductYes_Click();']";
		return cssSelector;
	}
	
	/**
	 * Delete dialog txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Delete Product dialog text
	public static WebElement deleteDialog_txt(WebDriver driver){
		element = driver.findElement(By.id("divConfirmDeleteProduct"));
		return element;
	}
	
	/**
	 * Delete dialog txt.
	 *
	 * @return the string
	 */
	public static String deleteDialog_txt(){
		id = "divConfirmDeleteProduct";
		return id;
	}
	
	/**
	 * Products dialog txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Products Dialog textbox
	public static WebElement productsDialog_txt(WebDriver driver){
		element = driver.findElement(By.id("AlertDialog"));
		return element;
	}
	
	/**
	 * Products dialog txt.
	 *
	 * @return the string
	 */
	public static String productsDialog_txt(){
		id = "AlertDialog";
		return id;
	}
	
	/**
	 * Save additional fees btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Save Additional Fees button
	public static WebElement saveAdditionalFees_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_Dialogs_ctl01"));
		return element;
	}
	
	/**
	 * Save additional fees btn.
	 *
	 * @return the string
	 */
	public static String saveAdditionalFees_btn(){
		id = "Dialogs_Dialogs_Dialogs_ctl01";
		return id;
	}
	
	/**
	 * Complex order txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Complex Order textbox
	public static WebElement complexOrder_txtbx(WebDriver driver){
		element = driver.findElement(By.cssSelector("input.AdditionalFeeInput[tabindex='1']"));
		return element;
	}
	
	/**
	 * Complex order txtbx.
	 *
	 * @return the string
	 */
	public static String complexOrder_txtbx(){
		cssSelector = "input.AdditionalFeeInput[tabindex='1']";
		return cssSelector;
	}
	
	/**
	 * Rush order txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Rush Order textbox
	public static WebElement rushOrder_txtbx(WebDriver driver){
		element = driver.findElement(By.cssSelector("input.AdditionalFeeInput[tabindex='2']"));
		return element;
	}
	
	/**
	 * Rush order txtbx.
	 *
	 * @return the string
	 */
	public static String rushOrder_txtbx(){
		cssSelector = "input.AdditionalFeeInput[tabindex='2']";
		return cssSelector;
	}
	
//	/**
//	 * Requires reassignment btn.
//	 *
//	 * @param driver the driver
//	 * @return the web element
//	 */
//	// Requires Reassignment button
//	public static WebElement requiresReassignment_btn(WebDriver driver){
//		element = driver.findElement(By.id("ctl00_ctl00_ctl00_Main_Main_Main_gridStatusSyncMappings_it3_6_imgSync"));
//		return element;
//	}
//	
//	/**
//	 * Requires reassignment btn.
//	 *
//	 * @return the string
//	 */
//	public static String requiresReassignment_btn(){
//		id = "ctl00_ctl00_ctl00_Main_Main_Main_gridStatusSyncMappings_it3_6_imgSync";
//		return id;
//	}
	
	/**
	 * Appraiser btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Appraiser button
	public static WebElement appraiser_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#Tabs > div[data-name='Appraiser']"));
		return element;
	}
	
	/**
	 * Appraiser btn.
	 *
	 * @return the string
	 */
	public static String appraiser_btn(){
		cssSelector = "#Tabs > div[data-name='Appraiser']";
		return cssSelector;
	}
	
//	/**
//	 * Modification statuses btn.
//	 *
//	 * @param driver the driver
//	 * @return the web element
//	 */
//	// Modification Statuses button
//	public static WebElement modificationStatuses_btn(WebDriver driver){
//		element = driver.findElement(By.id("ctl00_ctl00_ctl00_Main_Main_Main_gridStatusSyncMappings_it3_7_imgSync"));
//		return element;
//	}
//	
//	/**
//	 * Modification statuses btn.
//	 *
//	 * @return the string
//	 */
//	public static String modificationStatuses_btn(){
//		id = "ctl00_ctl00_ctl00_Main_Main_Main_gridStatusSyncMappings_it3_7_imgSync";
//		return id;
//	}
	
	/**
	 * Modification statuses gear btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Modification Statuses Gear button
	public static WebElement modificationStatusesGear_btn(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_ctl00_Main_Main_Main_gridStatusSyncMappings_it0_7_imgConfigureDocumentSync_Client"));
		return element;
	}
	
	/**
	 * Modification statuses gear btn.
	 *
	 * @return the string
	 */
	public static String modificationStatusesGear_btn(){
		id = "ctl00_ctl00_ctl00_Main_Main_Main_gridStatusSyncMappings_it0_7_imgConfigureDocumentSync_Client";
		return id;
	}
	
	/**
	 * Requested chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Requested checkbox
	public static WebElement requested_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_Dialogs_ctrlViewModificationStatusesOptions_Client_chkItems_0"));
		return element;
	}
	
	/**
	 * Requested chkbx.
	 *
	 * @return the string
	 */
	public static String requested_chkbx(){
		id = "Dialogs_Dialogs_Dialogs_ctrlViewModificationStatusesOptions_Client_chkItems_0";
		return id;
	}
	
	/**
	 * Accepted chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Accepted checkbox
	public static WebElement accepted_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_Dialogs_ctrlViewModificationStatusesOptions_Client_chkItems_1"));
		return element;
	}
	
	/**
	 * Accepted chkbx.
	 *
	 * @return the string
	 */
	public static String accepted_chkbx(){
		id = "Dialogs_Dialogs_Dialogs_ctrlViewModificationStatusesOptions_Client_chkItems_1";
		return id;
	}
	
	/**
	 * Declined chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Declined checkbox
	public static WebElement declined_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_Dialogs_ctrlViewModificationStatusesOptions_Client_chkItems_2"));
		return element;
	}
	
	/**
	 * Declined chkbx.
	 *
	 * @return the string
	 */
	public static String declined_chkbx(){
		id = "Dialogs_Dialogs_Dialogs_ctrlViewModificationStatusesOptions_Client_chkItems_2";
		return id;
	}
	
	/**
	 * All link.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// All link
	public static WebElement all_link(WebDriver driver){
		element = driver.findElement(By.linkText("All"));
		return element;
	}
	
	/**
	 * All link.
	 *
	 * @return the string
	 */
	public static String all_link(){
		linkText = "All";
		return linkText;
	}
	
	/**
	 * None link.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// None link
	public static WebElement none_link(WebDriver driver){
		element = driver.findElement(By.linkText("None"));
		return element;
	}
	
	/**
	 * None link.
	 *
	 * @return the string
	 */
	public static String none_link(){
		linkText = "None";
		return linkText;
	}
	
	/**
	 * Modification statuses ok btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Modification Statuses OK button
	public static WebElement modificationStatusesOk_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_Dialogs_ctrlViewModificationStatusesOptions_Client_btnCheckboxGroupPopup_OK"));
		return element;
	}
	
	/**
	 * Modification statuses ok btn.
	 *
	 * @return the string
	 */
	public static String modificationStatusesOk_btn(){
		id = "Dialogs_Dialogs_Dialogs_ctrlViewModificationStatusesOptions_Client_btnCheckboxGroupPopup_OK";
		return id;
	}
	
	/**
	 * Modification statuses cancel btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Modification Statuses Cancel button
	public static WebElement modificationStatusesCancel_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_Dialogs_ctrlViewModificationStatusesOptions_Client_btnCheckboxGroupPopup_Cancel"));
		return element;
	}
	
	/**
	 * Modification statuses cancel btn.
	 *
	 * @return the string
	 */
	public static String modificationStatusesCancel_btn(){
		id = "Dialogs_Dialogs_Dialogs_ctrlViewModificationStatusesOptions_Client_btnCheckboxGroupPopup_Cancel";
		return id;
	}
	
	/**
	 * Pending quality review gear icon btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Pending Quality Review gear icon button
	public static WebElement pendingQualityReviewGearIcon_btn(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_ctl00_Main_Main_Main_gridStatusSyncMappings_it0_20_imgConfigureDocumentSync_Client"));
		return element;
	}
	
	/**
	 * Pending quality review gear icon btn.
	 *
	 * @return the string
	 */
	public static String pendingQualityReviewGearIcon_btn(){
		id = "ctl00_ctl00_ctl00_Main_Main_Main_gridStatusSyncMappings_it0_20_imgConfigureDocumentSync_Client";
		return id;
	}
	
	/**
	 * Always include appraisal report chckbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Always include appraisal report checkbox
	public static WebElement alwaysIncludeAppraisalReport_chckbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_Dialogs_chkPendingReviewIncludeAppraisalOnSync"));
		return element;
	}
	
	/**
	 * Always include appraisal report chckbx.
	 *
	 * @return the string
	 */
	public static String alwaysIncludeAppraisalReport_chckbx(){
		id = "Dialogs_Dialogs_Dialogs_chkPendingReviewIncludeAppraisalOnSync";
		return id;
	}
	
	/**
	 * Attach appraisal report chckbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Attach appraisal report checkbox
	public static WebElement attachAppraisalReport_chckbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_Dialogs_chkPendingReviewIncludeReportInNotification"));
		return element;
	}
	
	/**
	 * Attach appraisal report chckbx.
	 *
	 * @return the string
	 */
	public static String attachAppraisalReport_chckbx(){
		id = "Dialogs_Dialogs_Dialogs_chkPendingReviewIncludeReportInNotification";
		return id;
	}
	
	/**
	 * Ok sync btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// OK button
	public static WebElement okSync_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("input[onclick='UpdateVMPSyncComment();'][class='Button'][value='OK']"));
		return element;
	}
	
	/**
	 * Ok sync btn.
	 *
	 * @return the string
	 */
	public static String okSync_btn(){
		cssSelector = "input[onclick='UpdateVMPSyncComment();'][class='Button'][value='OK']";
		return cssSelector;
	}
	
	/**
	 * Pending quality review gear icon AM C btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Pending Quality Review gear icon button AMC
	public static WebElement pendingQualityReviewGearIconAMC_btn(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_ctl00_Main_Main_Main_gridStatusSyncMappings_it0_17_imgConfigureDocumentSync_Client"));
		return element;
	}
	
	/**
	 * Pending quality review gear icon AM C btn.
	 *
	 * @return the string
	 */
	public static String pendingQualityReviewGearIconAMC_btn(){
		id = "ctl00_ctl00_ctl00_Main_Main_Main_gridStatusSyncMappings_it0_17_imgConfigureDocumentSync_Client";
		return id;
	}
	
	/**
	 * Use tracking number chckbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Use tracking number checkbox
	public static WebElement useTrackingNumber_chckbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_cbInvoice_UseTrackingNoAsInvoiceNo"));
		return element;
	}
	
	/**
	 * Use tracking number chckbx.
	 *
	 * @return the string
	 */
	public static String useTrackingNumber_chckbx(){
		id = "Main_Main_Main_cbInvoice_UseTrackingNoAsInvoiceNo";
		return id;
	}
	
	/**
	 * Use QC folders chckbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Use QC Folders checkbox
	public static WebElement useQCFolders_chckbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_cbUseInQC"));
		return element;
	}
	
	/**
	 * Use QC folders chckbx.
	 *
	 * @return the string
	 */
	public static String useQCFolders_chckbx(){
		id = "Main_Main_Main_cbUseInQC";
		return id;
	}
	
	/**
	 * Enable global login chckbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Enable global login checkbox
	public static WebElement enableGlobalLogin_chckbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_chkEnableGlobalLogin"));
		return element;
	}
	
	/**
	 * Enable global login chckbx.
	 *
	 * @return the string
	 */
	public static String enableGlobalLogin_chckbx(){
		id = "Main_Main_Main_chkEnableGlobalLogin";
		return id;
	}
	
	/**
	 * Ok invalid information btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// OK Invalid information button
	public static WebElement okInvalidInformation_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("input[type='button'][value='OK'][onclick='btnInvoiceOrder_IncompleteSummary_ClickOK();']"));
		return element;
	}
	
	/**
	 * Ok invalid information btn.
	 *
	 * @return the string
	 */
	public static String okInvalidInformation_btn(){
		cssSelector = "input[type='button'][value='OK'][onclick='btnInvoiceOrder_IncompleteSummary_ClickOK();']";
		return cssSelector;
	}
	
}
