package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure Fee Panel page
 */
public class SFeePanel {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	/** The css selector. */
	private static String cssSelector = null;

	
	/**
	 * Fee panel page txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Fee Panel Page text
	public static WebElement feePanelPage_txt(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_upMain"));
		return element;
	}
	
	/**
	 * Fee panel page txt.
	 *
	 * @return the string
	 */
	public static String feePanelPage_txt(){
		id = "Main_Main_upMain";
		return id;
	}
	
	/**
	 * Fee panel tab.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Fee Panel tab
	public static WebElement feePanel_tab(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_divTabFeePanel"));
		return element;
	}
	
	/**
	 * Fee panel tab.
	 *
	 * @return the string
	 */
	public static String feePanel_tab(){
		id = "Main_Main_divTabFeePanel";
		return id;
	}
	
	/**
	 * Appraiser fee panel tab.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Appraiser/Agent fee panel tab
	public static WebElement appraiserFeePanel_tab(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_divTabFeePanel"));
		return element;
	}
	
	/**
	 * Appraiser fee panel tab.
	 *
	 * @return the string
	 */
	public static String appraiserFeePanel_tab(){
		id = "Main_Main_divTabFeePanel";
		return id;
	}
	
	/**
	 * Amc firm fee panel tab.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// AMC/Firm fee panel tab
	public static WebElement amcFirmFeePanel_tab(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_divTabFeePanelAMC"));
		return element;
	}
	
	/**
	 * Amc firm fee panel tab.
	 *
	 * @return the string
	 */
	public static String amcFirmFeePanel_tab(){
		id = "Main_Main_divTabFeePanelAMC";
		return id;
	}
	
	/**
	 * Candidate list tab.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Candidate list tab
	public static WebElement candidateList_tab(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_divTabCandidateList"));
		return element;
	}
	
	/**
	 * Candidate list tab.
	 *
	 * @return the string
	 */
	public static String candidateList_tab(){
		id = "Main_Main_divTabCandidateList";
		return id;
	}
	
	/**
	 * Ineligible vendors tab.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Ineligible vendors tab
	public static WebElement ineligibleVendors_tab(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_divTabExcluded"));
		return element;
	}
	
	/**
	 * Ineligible vendors tab.
	 *
	 * @return the string
	 */
	public static String ineligibleVendors_tab(){
		id = "Main_Main_divTabExcluded";
		return id;
	}
	
	/**
	 * States sidebar txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// States sidebar text
	public static WebElement statesSidebar_txt(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_grdStates"));
		return element;
	}
	
	/**
	 * States sidebar txt.
	 *
	 * @return the string
	 */
	public static String statesSidebar_txt(){
		id = "Main_Main_grdStates";
		return id;
	}
	
	/**
	 * Adds the new btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Add New button
	public static WebElement addNew_btn(WebDriver driver){
		element = driver.findElement(By.id("btnAdd"));
		return element;
	}
	
	/**
	 * Adds the new btn.
	 *
	 * @return the string
	 */
	public static String addNew_btn(){
		id = "btnAdd";
		return id;
	}
	
	/**
	 * Group name txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Group Name text
	public static WebElement groupName_txt(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_txtNewOrderGroupName"));
		return element;
	}
	
	/**
	 * Group name txt.
	 *
	 * @return the string
	 */
	public static String groupName_txt(){
		id = "Dialogs_txtNewOrderGroupName";
		return id;
	}
	
	/**
	 * Adds the order group btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Add button
	public static WebElement addOrderGroup_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_btnDialogAdd"));
		return element;
	}
	
	/**
	 * Adds the order group btn.
	 *
	 * @return the string
	 */
	public static String addOrderGroup_btn(){
		id = "Dialogs_btnDialogAdd";
		return id;
	}
	
	/**
	 * Close btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Close button
	public static WebElement close_btn(WebDriver driver){
		element = driver.findElement(By.id("btnClose"));
		return element;
	}
	
	/**
	 * Close btn.
	 *
	 * @return the string
	 */
	public static String close_btn(){
		id = "btnClose";
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
		element = driver.findElement(By.cssSelector("img[src='/App_Themes/FlatGrayscale/Icons/Add.O.png']"));
		return element;
	}
	
	/**
	 * Adds the btn.
	 *
	 * @return the string
	 */
	public static String add_btn(){
		cssSelector = "img[src='/App_Themes/FlatGrayscale/Icons/Add.O.png']";
		return cssSelector;
	}
	
	/**
	 * Removes the btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Remove button
	public static WebElement remove_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/App_Themes/FlatGrayscale/Icons/CancelDelete.O.png']"));
		return element;
	}
	
	/**
	 * Removes the btn.
	 *
	 * @return the string
	 */
	public static String remove_btn(){
		cssSelector = "img[src='/App_Themes/FlatGrayscale/Icons/CancelDelete.O.png']";
		return cssSelector;
	}
	
	/**
	 * Mark ineligible btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Mark Ineligible button
	public static WebElement markIneligible_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/App_Themes/FlatGrayscale/Icons/Stop.png']"));
		return element;
	}
	
	/**
	 * Mark ineligible btn.
	 *
	 * @return the string
	 */
	public static String markIneligible_btn(){
		cssSelector = "img[src='/App_Themes/FlatGrayscale/Icons/Stop.png']";
		return cssSelector;
	}
	
	/**
	 * Contact vendor btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Contact vendor button
	public static WebElement contactVendor_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/App_Themes/FlatGrayscale/Icons/Send.O.png']"));
		return element;
	}
	
	/**
	 * Contact vendor btn.
	 *
	 * @return the string
	 */
	public static String contactVendor_btn(){
		cssSelector = "img[src='/App_Themes/FlatGrayscale/Icons/Send.O.png']";
		return cssSelector;
	}
	
	/**
	 * Order groups btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Order groups button
	public static WebElement orderGroups_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/App_Themes/FlatGrayscale/Icons/Groups.png']"));
		return element;
	}
	
	/**
	 * Order groups btn.
	 *
	 * @return the string
	 */
	public static String orderGroups_btn(){
		cssSelector = "img[src='/App_Themes/FlatGrayscale/Icons/Groups.png']";
		return cssSelector;
	}
	
	/**
	 * Builds the fee panel btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Build Fee Panel button
	public static WebElement buildFeePanel_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/App_Themes/FlatGrayscale/Icons/Wrench.png']"));
		return element;
	}
	
	/**
	 * Builds the fee panel btn.
	 *
	 * @return the string
	 */
	public static String buildFeePanel_btn(){
		cssSelector = "img[src='/App_Themes/FlatGrayscale/Icons/Wrench.png']";
		return cssSelector;
	}
	
	/**
	 * Options btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Options button
	public static WebElement options_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/App_Themes/FlatGrayscale/Icons/Gear.O.png']"));
		return element;
	}
	
	/**
	 * Options btn.
	 *
	 * @return the string
	 */
	public static String options_btn(){
		cssSelector = "img[src='/App_Themes/FlatGrayscale/Icons/Gear.O.png']";
		return cssSelector;
	}
	
	/**
	 * Move to fee panel btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Move to fee panel button
	public static WebElement moveToFeePanel_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/App_Themes/FlatGrayscale/Icons/Undo.png']"));
		return element;
	}
	
	/**
	 * Move to fee panel btn.
	 *
	 * @return the string
	 */
	public static String moveToFeePanel_btn(){
		cssSelector = "img[src='/App_Themes/FlatGrayscale/Icons/Undo.png']";
		return cssSelector;
	}
	
	/**
	 * Company name txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Company Name textbox
	public static WebElement companyName_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_txtCompanyName"));
		return element;
	}
	
	/**
	 * Company name txtbx.
	 *
	 * @return the string
	 */
	public static String companyName_txtbx(){
		id = "Main_txtCompanyName";
		return id;
	}
	
	/**
	 * Email address txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Email Address textbox
	public static WebElement emailAddress_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_txtEmail"));
		return element;
	}
	
	/**
	 * Email address txtbx.
	 *
	 * @return the string
	 */
	public static String emailAddress_txtbx(){
		id = "Main_txtEmail";
		return id;
	}
	
	/**
	 * Phone txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Phone textbox
	public static WebElement phone_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_txtPhone"));
		return element;
	}
	
	/**
	 * Phone txtbx.
	 *
	 * @return the string
	 */
	public static String phone_txtbx(){
		id = "Main_txtPhone";
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
		element = driver.findElement(By.id("Main_btnNext"));
		return element;
	}
	
	/**
	 * Next btn.
	 *
	 * @return the string
	 */
	public static String next_btn(){
		id = "Main_btnNext";
		return id;
	}
	
	/**
	 * Back btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Back button
	public static WebElement back_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_btnBack"));
		return element;
	}
	
	/**
	 * Back btn.
	 *
	 * @return the string
	 */
	public static String back_btn(){
		id = "Main_btnBack";
		return id;
	}
	
	/**
	 * Vendor chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Vendor checkbox
	public static WebElement vendor_chkbx(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/images/Checkmark-Small-Unchecked.O.png']"));
		return element;
	}
	
	/**
	 * Vendor chkbx.
	 *
	 * @return the string
	 */
	public static String vendor_chkbx(){
		cssSelector = "img[src='/images/Checkmark-Small-Unchecked.O.png']";
		return cssSelector;
	}
	
	/**
	 * Adds the vendor btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Add vendor button
	public static WebElement addVendor_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_btnAdd"));
		return element;
	}
	
	/**
	 * Adds the vendor btn.
	 *
	 * @return the string
	 */
	public static String addVendor_btn(){
		id = "Main_btnAdd";
		return id;
	}
	
	/**
	 * Vendor type dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Vendor Type dropdown
	public static WebElement vendorType_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_ddlVendorTypes"));
		return element;
	}
	
	/**
	 * Vendor type dropdown.
	 *
	 * @return the string
	 */
	public static String vendorType_dropdown(){
		id = "Main_Main_ddlVendorTypes";
		return id;
	}
	
	/**
	 * Fee panel table txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Fee panel table text
	public static WebElement feePanelTable_txt(WebDriver driver){
		element = driver.findElement(By.id("tblGridStateData_container"));
		return element;
	}
	
	/**
	 * Fee panel table txt.
	 *
	 * @return the string
	 */
	public static String feePanelTable_txt(){
		id = "tblGridStateData_container";
		return id;
	}
	
	/**
	 * Yes btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Yes button
	public static WebElement yes_btn(WebDriver driver){
		element = driver.findElement(By.id("sbdmButton1"));
		return element;
	}
	
	/**
	 * Yes btn.
	 *
	 * @return the string
	 */
	public static String yes_btn(){
		id = "sbdmButton1";
		return id;
	}
	
	/**
	 * Dialog txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Dialog text
	public static WebElement dialog_txt(WebDriver driver){
		element = driver.findElement(By.id("divMessageOK"));
		return element;
	}
	
	/**
	 * Dialog txt.
	 *
	 * @return the string
	 */
	public static String dialog_txt(){
		id = "divMessageOK";
		return id;
	}
	
	/**
	 * Vendor exists dialog txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Vendor Exists Dialog text
	public static WebElement vendorExistsDialog_txt(WebDriver driver){
		element = driver.findElement(By.id("divMessageOKText"));
		return element;
	}
	
	/**
	 * Vendor exists dialog txt.
	 *
	 * @return the string
	 */
	public static String vendorExistsDialog_txt(){
		id = "divMessageOKText";
		return id;
	}
	
	/**
	 * Order group name txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Order group group name textbox
	public static WebElement orderGroupName_txtbx(WebDriver driver){
		element = driver.findElement(By.cssSelector("input.ui-igedit-field[tabindex='1']"));
		return element;
	}
	
	/**
	 * Order group name txtbx.
	 *
	 * @return the string
	 */
	public static String orderGroupName_txtbx(){
		cssSelector = "input.ui-igedit-field[tabindex='1']";
		return cssSelector;
	}
	
	/**
	 * Order groups table txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Order Groups table text
	public static WebElement orderGroupsTable_txt(WebDriver driver){
		element = driver.findElement(By.id("tblOrderGroups"));
		return element;
	}
	
	/**
	 * Order groups table txt.
	 *
	 * @return the string
	 */
	public static String orderGroupsTable_txt(){
		id = "tblOrderGroups";
		return id;
	}
	
	/**
	 * Save order groups btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Save button
	public static WebElement saveOrderGroups_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_btnSaveOrderGroups"));
		return element;
	}
	
	/**
	 * Save order groups btn.
	 *
	 * @return the string
	 */
	public static String saveOrderGroups_btn(){
		id = "Main_btnSaveOrderGroups";
		return id;
	}
	
	/**
	 * Cancel order groups btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Cancel button
	public static WebElement cancelOrderGroups_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_btnCancelOrderGroups"));
		return element;
	}
	
	/**
	 * Cancel order groups btn.
	 *
	 * @return the string
	 */
	public static String cancelOrderGroups_btn(){
		id = "Main_btnCancelOrderGroups";
		return id;
	}
	
	/**
	 * Delete btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Delete button
	public static WebElement delete_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/images/CancelUpload.O.png']"));
		return element;
	}
	
	/**
	 * Delete btn.
	 *
	 * @return the string
	 */
	public static String delete_btn(){
		cssSelector = "img[src='/images/CancelUpload.O.png']";
		return cssSelector;
	}
	
	/**
	 * Undelete btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Undelete button
	public static WebElement undelete_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/images/Undelete.png']"));
		return element;
	}
	
	/**
	 * Undelete btn.
	 *
	 * @return the string
	 */
	public static String undelete_btn(){
		cssSelector = "img[src='/images/Undelete.png']";
		return cssSelector;
	}
	
	/**
	 * Contact fee panel header txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Contact fee panel header text
	public static WebElement contactFeePanelHeader_txt(WebDriver driver){
		element = driver.findElement(By.id("divEmailTitle"));
		return element;
	}
	
	/**
	 * Contact fee panel header txt.
	 *
	 * @return the string
	 */
	public static String contactFeePanelHeader_txt(){
		id = "divEmailTitle";
		return id;
	}
	
	/**
	 * Close contact fee panel btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Close Contact fee panel button
	public static WebElement closeContactFeePanel_btn(WebDriver driver){
		element = driver.findElement(By.id("imgEmailSendClose"));
		return element;
	}
	
	/**
	 * Close contact fee panel btn.
	 *
	 * @return the string
	 */
	public static String closeContactFeePanel_btn(){
		id = "imgEmailSendClose";
		return id;
	}
	
	/**
	 * Builds the custom fee panel txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Build custom fee panel dialog text
	public static WebElement buildCustomFeePanel_txt(WebDriver driver){
		element = driver.findElement(By.id("bdyDialog"));
		return element;
	}
	
	/**
	 * Builds the custom fee panel txt.
	 *
	 * @return the string
	 */
	public static String buildCustomFeePanel_txt(){
		id = "bdyDialog";
		return id;
	}
	
	/**
	 * Options txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Options dialog text
	public static WebElement options_txt(WebDriver driver){
		element = driver.findElement(By.id("divFeePanelOptions"));
		return element;
	}
	
	/**
	 * Options txt.
	 *
	 * @return the string
	 */
	public static String options_txt(){
		id = "divFeePanelOptions";
		return id;
	}
	
	/**
	 * Cancel custom fee panel btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Cancel Custom Fee Panel button
	public static WebElement cancelCustomFeePanel_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_btnCancel"));
		return element;
	}
	
	/**
	 * Cancel custom fee panel btn.
	 *
	 * @return the string
	 */
	public static String cancelCustomFeePanel_btn(){
		id = "Main_btnCancel";
		return id;
	}
	
	/**
	 * Cancel fee panel options btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Cancel Fee Panel Options button
	public static WebElement cancelFeePanelOptions_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ctl02"));
		return element;
	}
	
	/**
	 * Cancel fee panel options btn.
	 *
	 * @return the string
	 */
	public static String cancelFeePanelOptions_btn(){
		id = "Dialogs_Dialogs_ctl02";
		return id;
	}
	
	/**
	 * Fee panel table.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Fee Panel table
	public static WebElement feePanel_table(WebDriver driver){
		element = driver.findElement(By.id("tblFeePanel"));
		return element;
	}
	
	/**
	 * Fee panel table.
	 *
	 * @return the string
	 */
	public static String feePanel_table(){
		id = "tblFeePanel";
		return id;
	}
	
	/**
	 * View profile first row btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// View profile of first vendor button
	public static WebElement viewProfileFirstRow_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#tblGridStateData > tbody > tr:nth-child(1) > td:nth-child(5)"));
		return element;
	}
	
	/**
	 * View profile first row btn.
	 *
	 * @return the string
	 */
	public static String viewProfileFirstRow_btn(){
		cssSelector = "#tblGridStateData > tbody > tr:nth-child(1) > td:nth-child(5)";
		return cssSelector;
	}
	
	/**
	 * View profile second row btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// View profile of second vendor button
	public static WebElement viewProfileSecondRow_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#tblGridStateData > tbody > tr.ui-ig-altrecord.ui-iggrid-altrecord.IG_GridEmployee > td:nth-child(5) > a > img"));
		return element;
	}
	
	/**
	 * View profile second row btn.
	 *
	 * @return the string
	 */
	public static String viewProfileSecondRow_btn(){
		cssSelector = "#tblGridStateData > tbody > tr.ui-ig-altrecord.ui-iggrid-altrecord.IG_GridEmployee > td:nth-child(5) > a > img";
		return cssSelector;
	}
	
	/**
	 * Notices txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Notices text
	public static WebElement notices_txt(WebDriver driver){
		element = driver.findElement(By.id("divFeePanelInfoText"));
		return element;
	}
	
	/**
	 * Notices txt.
	 *
	 * @return the string
	 */
	public static String notices_txt(){
		id = "divFeePanelInfoText";
		return id;
	}
	
	// Add button
		public static WebElement add_btndisabled(WebDriver driver){
			element = driver.findElement(By.cssSelector("img[src='/App_Themes/FlatGrayscale/Icons/Add.O-disabled.png']"));
			return element;
		}
		
		/**
		 * Adds the btn.
		 *
		 * @return the string
		 */
		public static String add_btndisabled(){
			cssSelector = "img[src='/App_Themes/FlatGrayscale/Icons/Add.O-disabled.png']";
			return cssSelector;
		}
		
		// Remove button disabled
		public static WebElement removedisabled_btn(WebDriver driver){
			element = driver.findElement(By.cssSelector("img[src='/App_Themes/FlatGrayscale/Icons/CancelDelete.O-disabled.png']"));
			return element;
		}

		/**
		 * Removes the btn diabled.
		 *
		 * @return the string
		 */
		public static String removedisabled_btn(){
			cssSelector = "img[src='/App_Themes/FlatGrayscale/Icons/CancelDelete.O-disabled.png']";
			return cssSelector;

		}
		// Mark Ineligible disabled
		public static WebElement markIneligibledisabled_btn(WebDriver driver){
			element = driver.findElement(By.cssSelector("img[src='/App_Themes/FlatGrayscale/Icons/Stop-disabled.png']"));
			return element;
		}

		/**
		 *  Mark Ineligible disabled.
		 *
		 * @return the string
		 */
		public static String markIneligibledisabled_btn(){
			cssSelector = "img[src='/App_Themes/FlatGrayscale/Icons/Stop-disabled.png']";
			return cssSelector;

		}
		

		// Mark Ineligible disabled
		public static WebElement buildFeePaneldisabled_btn(WebDriver driver){
			element = driver.findElement(By.cssSelector("img[src='/App_Themes/FlatGrayscale/Icons/Wrench-disabled.png']"));
			return element;
		}

		/**
		 *  Mark Ineligible disabled.
		 *
		 * @return the string
		 */
		public static String buildFeePaneldisabled_btn(){
			cssSelector = "img[src='/App_Themes/FlatGrayscale/Icons/Wrench-disabled.png']";
			return cssSelector;

		}
		

		// Mark Ineligible disabled
		public static WebElement Optionsdisabled_btn(WebDriver driver){
			element = driver.findElement(By.cssSelector("img[src='/App_Themes/FlatGrayscale/Icons/Gear.O-disabled.png']"));
			return element;
		}

		/**
		 *  Mark Ineligible disabled.
		 *
		 * @return the string
		 */
		public static String Optionsdisabled_btn(){
			cssSelector = "img[src='/App_Themes/FlatGrayscale/Icons/Gear.O-disabled.png']";
			return cssSelector;

		}

}
