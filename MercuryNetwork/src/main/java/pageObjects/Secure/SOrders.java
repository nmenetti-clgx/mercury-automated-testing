package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import setup.TestSetup;

/**
 * The elements on the Secure Orders page
 */
public class SOrders extends TestSetup{

	/** The element. */
	private static WebElement element = null;

	/** The id. */
	private static String id = null;

	/** The css selector. */
	private static String cssSelector = null;


	/**
	 * Data courier btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Data Courier button
	public static WebElement dataCourier_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/Images/TopNav/DCLogo.png']"));
		return element;
	}

	/**
	 * Data courier btn.
	 *
	 * @return the string
	 */
	public static String dataCourier_btn(){
		cssSelector = "img[src='/Images/TopNav/DCLogo.png']";
		return cssSelector;
	}

	/**
	 * Orders btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Orders button
	public static WebElement orders_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/Images/TopNav/Orders.png']"));
		return element;
	}

	/**
	 * Orders btn.
	 *
	 * @return the string
	 */
	public static String orders_btn(){
		cssSelector = "img[src='/Images/TopNav/Orders.png']";
		return cssSelector;
	}

	/**
	 * Fee panel btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Fee Panel button
	public static WebElement feePanel_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/Images/TopNav/FeePanel.png']"));
		return element;
	}

	/**
	 * Fee panel btn.
	 *
	 * @return the string
	 */
	public static String feePanel_btn(){
		cssSelector = "img[src='/Images/TopNav/FeePanel.png']";
		return cssSelector;
	}

	/**
	 * Clients btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Clients button
	public static WebElement clients_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/Images/TopNav/Clients.png']"));
		return element;
	}

	/**
	 * Clients btn.
	 *
	 * @return the string
	 */
	public static String clients_btn(){
		cssSelector = "img[src='/Images/TopNav/Clients.png']";
		return cssSelector;
	}

	/**
	 * Uarr btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// UARR button
	public static WebElement uarr_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/Images/TopNav/UARR.png']"));
		return element;
	}

	/**
	 * Uarr btn.
	 *
	 * @return the string
	 */
	public static String uarr_btn(){
		cssSelector = "img[src='/Images/TopNav/UARR.png']";
		return cssSelector;
	}

	/**
	 * Users btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Users button
	public static WebElement users_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/Images/TopNav/Profile.png']"));
		return element;
	}

	/**
	 * Users btn.
	 *
	 * @return the string
	 */
	public static String users_btn(){
		cssSelector = "img[src='/Images/TopNav/Profile.png']";
		return cssSelector;
	}

	/**
	 * Preferences btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Preferences button
	public static WebElement preferences_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_TopNavButtonPreferences"));
		return element;
	}

	/**
	 * Preferences btn.
	 *
	 * @return the string
	 */
	public static String preferences_btn(){
		id = "Main_TopNavButtonPreferences";
		return id;
	}

	/**
	 * Reports btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Reports button
	public static WebElement reports_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_TopNavButtonReports"));
		return element;
	}

	/**
	 * Reports btn.
	 *
	 * @return the string
	 */
	public static String reports_btn(){
		id = "Main_TopNavButtonReports";
		return id;
	}

	/**
	 * Account btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Account button
	public static WebElement account_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/Images/TopNav/Account-Icon.png']"));
		return element;
	}

	/**
	 * Account btn.
	 *
	 * @return the string
	 */
	public static String account_btn(){
		cssSelector = "img[src='/Images/TopNav/Account-Icon.png']";
		return cssSelector;
	}

	/**
	 * Payments main btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Payments menu button
	public static WebElement paymentsMain_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_TopNavButtonMyAccounting"));
		return element;
	}

	/**
	 * Payments main btn.
	 *
	 * @return the string
	 */
	public static String paymentsMain_btn(){
		id = "Main_TopNavButtonMyAccounting";
		return id;
	}

	/**
	 * Residential appraisal btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// New > Residential Appraisal button
	public static WebElement residentialAppraisal_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("tr.MenuBar_Menu_Item:nth-child(1) > td:nth-child(2)"));
		return element;
	}

	/**
	 * Residential appraisal btn.
	 *
	 * @return the string
	 */
	public static String residentialAppraisal_btn(){
		cssSelector = "tr.MenuBar_Menu_Item:nth-child(1) > td:nth-child(2)";
		return cssSelector;
	}

	/**
	 * Commercial appraisal btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// New > Commercial Appraisal button
	public static WebElement commercialAppraisal_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("tr.MenuBar_Menu_Item:nth-child(2) > td:nth-child(2)"));
		return element;
	}

	/**
	 * Commercial appraisal btn.
	 *
	 * @return the string
	 */
	public static String commercialAppraisal_btn(){
		cssSelector = "tr.MenuBar_Menu_Item:nth-child(2) > td:nth-child(2)";
		return cssSelector;
	}

	/**
	 * Broker price opinion btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// New > Broker Price Opinion button
	public static WebElement brokerPriceOpinion_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("tr.MenuBar_Menu_Item:nth-child(3) > td:nth-child(2)"));
		return element;
	}

	/**
	 * Broker price opinion btn.
	 *
	 * @return the string
	 */
	public static String brokerPriceOpinion_btn(){
		cssSelector = "tr.MenuBar_Menu_Item:nth-child(3) > td:nth-child(2)";
		return cssSelector;
	}

	/**
	 * Inspection btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// New > Inspection button
	public static WebElement inspection_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("tr.MenuBar_Menu_Item:nth-child(4) > td:nth-child(2)"));
		return element;
	}

	/**
	 * Inspection btn.
	 *
	 * @return the string
	 */
	public static String inspection_btn(){
		cssSelector = "tr.MenuBar_Menu_Item:nth-child(4) > td:nth-child(2)";
		return cssSelector;
	}

	/**
	 * Optival AVM cascade btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// New > OptiVal AVM Cascade button
	public static WebElement optivalAVMCascade_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("tr.MenuBar_Menu_Item:nth-child(5) > td:nth-child(2)"));
		return element;
	}

	/**
	 * Optival AVM cascade btn.
	 *
	 * @return the string
	 */
	public static String optivalAVMCascade_btn(){
		cssSelector = "tr.MenuBar_Menu_Item:nth-child(5) > td:nth-child(2)";
		return cssSelector;
	}

	/**
	 * Order types dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Oder Types dropdown
	public static WebElement orderTypes_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_ddlOrderTypes"));
		return element;
	}

	/**
	 * Order types dropdown.
	 *
	 * @return the string
	 */
	public static String orderTypes_dropdown(){
		id = "Main_Main_ddlOrderTypes";
		return id;
	}

	/**
	 * Assigned dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Assigned dropdown
	public static WebElement assigned_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_ddlAssignedTo"));
		return element;
	}

	/**
	 * Assigned dropdown.
	 *
	 * @return the string
	 */
	public static String assigned_dropdown(){
		id = "Main_Main_ddlAssignedTo";
		return id;
	}

	/**
	 * Sort arrow.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Sort Arrow (indicating descending or ascending)
	public static WebElement sortArrow(WebDriver driver){
		element = driver.findElement(By.cssSelector("span.ui-iggrid-colindicator:nth-child(1)"));
		return element;
	}

	/**
	 * Sort arrow.
	 *
	 * @return the string
	 */
	public static String sortArrow(){
		cssSelector = "span.ui-iggrid-colindicator:nth-child(1)";
		return cssSelector;
	}

	/**
	 * Column headers.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Column Headers
	public static WebElement columnHeaders(WebDriver driver){
		element = driver.findElement(By.cssSelector("ui-iggrid-headertext"));
		return element;
	}

	/**
	 * Column headers.
	 *
	 * @return the string
	 */
	public static String columnHeaders(){
		cssSelector = "ui-iggrid-headertext";
		return cssSelector;
	}

	/**
	 * Orders table txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Orders table
	public static WebElement ordersTable_txt(WebDriver driver){
		element = driver.findElement(By.id("tblOrders_scroll"));
		return element;
	}

	/**
	 * Orders table txt.
	 *
	 * @return the string
	 */
	public static String ordersTable_txt(){
		id = "tblOrders_scroll";
		return id;
	}

	/**
	 * Find txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Find text box
	public static WebElement find_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_txtFind"));
		return element;
	}

	/**
	 * Find txtbx.
	 *
	 * @return the string
	 */
	public static String find_txtbx(){
		id = "Main_Main_txtFind";
		return id;
	}

	/**
	 * Contains radio btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Contains radio button
	public static WebElement contains_radioBtn(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_rbContains"));
		return element;
	}

	/**
	 * Contains radio btn.
	 *
	 * @return the string
	 */
	public static String contains_radioBtn(){
		id = "Main_Main_rbContains";
		return id;
	}

	/**
	 * In field dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// In Field dropdown
	public static WebElement inField_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_ddlField"));
		return element;
	}

	/**
	 * In field dropdown.
	 *
	 * @return the string
	 */
	public static String inField_dropdown(){
		id = "Main_Main_ddlField";
		return id;
	}

	/**
	 * Placed dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Placed dropdown
	public static WebElement placed_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_ddlPlaced"));
		return element;
	}

	/**
	 * Placed dropdown.
	 *
	 * @return the string
	 */
	public static String placed_dropdown(){
		id = "Main_Main_ddlPlaced";
		return id;
	}

	/**
	 * Find btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Find magnifying glass button
	public static WebElement find_btn(WebDriver driver){
		element = driver.findElement(By.id("imgFind"));
		return element;
	}

	/**
	 * Find btn.
	 *
	 * @return the string
	 */
	public static String find_btn(){
		id = "imgFind";
		return id;
	}

	/**
	 * Close overlay btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Close Overlay button
	public static WebElement closeOverlay_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img.iFrameCloseButton"));
		return element;
	}

	/**
	 * Close overlay btn.
	 *
	 * @return the string
	 */
	public static String closeOverlay_btn(){
		cssSelector = "img.iFrameCloseButton";
		return cssSelector;
	}

	/**
	 * Order status txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Order Status text
	public static WebElement orderStatus_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector("tbody.ui-widget-content > tr:nth-child(1) > td:nth-child(2)"));
		return element;
	}

	/**
	 * Order status txt.
	 *
	 * @return the string
	 */
	public static String orderStatus_txt(){
		cssSelector = "tbody.ui-widget-content > tr:nth-child(1) > td:nth-child(2)";
		return cssSelector;
	}

	/**
	 * Message txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Message textbox
	public static WebElement message_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ctlSendMessages_txtMessage"));
		return element;
	}

	/**
	 * Message txtbx.
	 *
	 * @return the string
	 */
	public static String message_txtbx(){
		id = "Dialogs_Dialogs_ctlSendMessages_txtMessage";
		return id;
	}

	/**
	 * Send message btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Send message button
	public static WebElement sendMessage_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ctl12"));
		return element;
	}

	/**
	 * Send message btn.
	 *
	 * @return the string
	 */
	public static String sendMessage_btn(){
		id = "Dialogs_Dialogs_ctl12";
		return id;
	}

	/**
	 * Ok message btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// OK message button
	public static WebElement okMessage_btn(WebDriver driver){
		element = driver.findElement(By.id("sbdmButton1"));
		return element;
	}

	/**
	 * Ok message btn.
	 *
	 * @return the string
	 */
	public static String okMessage_btn(){
		id = "sbdmButton1";
		return id;
	}

	/**
	 * Delete message txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Delete textbox
	public static WebElement deleteMessage_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_txtDeleteOrderMessage"));
		return element;
	}

	/**
	 * Delete message txtbx.
	 *
	 * @return the string
	 */
	public static String deleteMessage_txtbx(){
		id = "Dialogs_Dialogs_txtDeleteOrderMessage";
		return id;
	}

	/**
	 * Ok send delete message btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// OK delete message button
	public static WebElement okSendDeleteMessage_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ctl09"));
		return element;
	}

	/**
	 * Ok send delete message btn.
	 *
	 * @return the string
	 */
	public static String okSendDeleteMessage_btn(){
		id = "Dialogs_Dialogs_ctl09";
		return id;
	}

	/**
	 * Message txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Message text
	public static WebElement message_txt(WebDriver driver){
		element = driver.findElement(By.id("divMessageOK"));
		return element;
	}

	/**
	 * Message txt.
	 *
	 * @return the string
	 */
	public static String message_txt(){
		id = "divMessageOK";
		return id;
	}

	/**
	 * Chat and tutorials btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Chat and Tutorials button
	public static WebElement chatAndTutorials_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("div.SkipThisFixedPosition"));
		return element;
	}

	/**
	 * Chat and tutorials btn.
	 *
	 * @return the string
	 */
	public static String chatAndTutorials_btn(){
		cssSelector = "div.SkipThisFixedPosition";
		return cssSelector;
	}

	/**
	 * No btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// No button (Password Expiring)
	public static WebElement no_btn(WebDriver driver){
		element = driver.findElement(By.id("sbdmButton2"));
		return element;
	}

	/**
	 * No btn.
	 *
	 * @return the string
	 */
	public static String no_btn(){
		id = "sbdmButton2";
		return id;
	}

	/**
	 * Yes btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Yes button (Password Expiring)
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
	 * Agree btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Agree button
	public static WebElement agree_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ctl01"));
		return element;
	}

	/**
	 * Agree btn.
	 *
	 * @return the string
	 */
	public static String agree_btn(){
		id = "Dialogs_Dialogs_ctl01";
		return id;
	}

	/**
	 * My columns btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// My columns button
	public static WebElement myColumns_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/App_Themes/FlatGrayscale/Icons/ColumnsIcon.O.png']"));
		return element;
	}

	/**
	 * My columns btn.
	 *
	 * @return the string
	 */
	public static String myColumns_btn(){
		cssSelector = "img[src='/App_Themes/FlatGrayscale/Icons/ColumnsIcon.O.png']";
		return cssSelector;
	}

	/**
	 * Available columns txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Available columns text
	public static WebElement availableColumns_txt(WebDriver driver){
		element = driver.findElement(By.id("Main_lbManageColumns_list1"));
		return element;
	}

	/**
	 * Available columns txt.
	 *
	 * @return the string
	 */
	public static String availableColumns_txt(){
		id = "Main_lbManageColumns_list1";
		return id;
	}

	/**
	 * Displayed columns txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Displayed columns text
	public static WebElement displayedColumns_txt(WebDriver driver){
		element = driver.findElement(By.id("Main_lbManageColumns_list2"));
		return element;
	}

	/**
	 * Displayed columns txt.
	 *
	 * @return the string
	 */
	public static String displayedColumns_txt(){
		id = "Main_lbManageColumns_list2";
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
		element = driver.findElement(By.id("Main_ctl00"));
		return element;
	}

	/**
	 * Close btn.
	 *
	 * @return the string
	 */
	public static String close_btn(){
		id = "Main_ctl00";
		return id;
	}

	/**
	 * New options list.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// New Options List
	public static WebElement newOptions_list(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_mbMain_0"));
		return element;
	}

	/**
	 * New options list.
	 *
	 * @return the string
	 */
	public static String newOptions_list(){
		id = "Main_Main_mbMain_0";
		return id;
	}

	/**
	 * Payments btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Payments button
	public static WebElement payments_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/App_Themes/FlatGrayscale/Icons/DollarSign.O.png']"));
		return element;
	}

	/**
	 * Payments btn.
	 *
	 * @return the string
	 */
	public static String payments_btn(){
		cssSelector = "img[src='/App_Themes/FlatGrayscale/Icons/DollarSign.O.png']";
		return cssSelector;
	}

	/**
	 * View btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// View button
	public static WebElement view_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("td.MenuBar_Item:nth-child(2) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1)"));
		return element;
	}

	/**
	 * View btn.
	 *
	 * @return the string
	 */
	public static String view_btn(){
		cssSelector = "td.MenuBar_Item:nth-child(2) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1)";
		return cssSelector;
	}

	/**
	 * Payments tab btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Payments tab button
	public static WebElement paymentsTab_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_TopNavButtonMyAccounting"));
		return element;
	}

	/**
	 * Payments tab btn.
	 *
	 * @return the string
	 */
	public static String paymentsTab_btn(){
		id = "Main_TopNavButtonMyAccounting";
		return id;
	}

	/**
	 * No Update Payment Method btn
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Payments tab button
	public static WebElement noUpdatePaymentMethod_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_ctl02"));
		return element;
	}

	/**
	 * No Update Payment Method btn
	 *
	 * @return the string
	 */
	public static String noUpdatePaymentMethod_btn(){
		id = "Dialogs_Dialogs_ctl02";
		return id;
	}

	// Mark as paid
	/**
	 * @param driver
	 * @return The web element
	 */
	public static WebElement markAsPaid_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#divToolbarContainer > div > table > tbody > tr > td:nth-child(7) > table > tbody > tr > td.MenuBar_Item_Label"));
		return element;
	}

	/**
	 *
	 * @return the string
	 */
	// Mark as paid
	public static String markAsPaid_btn(){
		cssSelector = "#divToolbarContainer > div > table > tbody > tr > td:nth-child(7) > table > tbody > tr > td.MenuBar_Item_Label";
		return cssSelector;
	}

	/**
	 * @param driver
	 * @return The web element
	 */
	// Completed order folder
	public static WebElement completedFolder_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#Main_Main_rptOrderFolder_divOrderFolder_35 > div.OrderFolderText"));
		return element;
	}

	/**
	 *
	 * @return the string
	 */
	// Completed order folder	
	public static String completedFolder_btn(){
		cssSelector = "#Main_Main_rptOrderFolder_divOrderFolder_35 > div.OrderFolderText";
		return cssSelector;

	}

	/**
	 * @param driver
	 * @return The web element
	 */
	// Select All button in Mark as Paid dialog
	public static WebElement selectAll_btn(WebDriver driver){
		element = driver.findElement(By.id("lnkSelectAll"));
		return element;
	}

	/**
	 *
	 * @return the string
	 */
	// Select All button in Mark as Paid dialog	
	public static String selectAll_btn(){
		id = "lnkSelectAll";
		return id;

	}

	/**
	 * @param driver
	 * @return The web element
	 */
	// Check# textbox in Mark as Paid dialog
	public static WebElement checkNumber_txt(WebDriver driver){
		element = driver.findElement(By.id("Main_txtCheckNumber"));
		return element;
	}

	/**
	 *
	 * @return the string
	 */
	// Check# textbox in Mark as Paid dialog
	public static String checkNumber_txt(){
		id = "Main_txtCheckNumber";
		return id;

	}

	/**
	 * @param driver
	 * @return The web element
	 */
	// Invoice# textbox in Mark as Paid dialog
	public static WebElement invoiceNumber_txt(WebDriver driver){
		element = driver.findElement(By.id("Main_txtInvoiceNumber"));
		return element;
	}

	/**
	 *
	 * @return the string
	 */
	// Invoice# textbox in Mark as Paid dialog
	public static String invoiceNumber_txt(){
		id = "Main_txtInvoiceNumber";
		return id;
	}

	/**
	 * @param driver
	 * @return The web element
	 */
	// Invoice# textbox in Mark as Paid dialog
	public static WebElement markAsPaid_dialog(WebDriver driver){
		element = driver.findElement(By.id("divOverlay"));
		return element;
	}

	/**
	 *
	 * @return the string
	 */
	// Invoice# textbox in Mark as Paid dialog
	public static String markAsPaid_dialog(){
		id = "divOverlay";
		return id;
	}	

	/**
	 * @param driver
	 * @return The web element
	 */
	// Mark As Paid Save Button
	public static WebElement markAsPaidSave_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_btnSave"));
		return element;
	}

	/**
	 *
	 * @return the string
	 */
	// Mark As Paid Save Button
	public static String markAsPaidSave_btn(){
		id = "Main_btnSave";
		return id;
	}		

	/**
	 * @param driver
	 * @return The web element
	 */
	// New Enabled
	public static WebElement new_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#divToolbarContainer > div > table > tbody > tr > td:nth-child(1) > table > tbody > tr > td.MenuBar_Item_LabelMain_btnSave"));
		return element;
	}

	/**
	 *
	 * @return the string
	 */
	//  New Enabled
	public static String new_btn(){
		cssSelector = "#divToolbarContainer > div > table > tbody > tr > td:nth-child(1) > table > tbody > tr > td.MenuBar_Item_Label";
		return cssSelector;
	}		

	/**
	 * @param driver
	 * @return The web element
	 */
	// New disabled
	public static WebElement newDisabled_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#divToolbarContainer > div > table > tbody > tr > td.MenuBar_Item_Disabled"));
		return element;
	}

	/**
	 *
	 * @return the string
	 */
	// New disabled
	public static String newDisabled_btn(){
		cssSelector = "#divToolbarContainer > div > table > tbody > tr > td.MenuBar_Item_Disabled";
		return cssSelector;
	}	

	/**
	 * @param driver
	 * @return The web element
	 */
	// ISS Ranked tab
	public static WebElement issRanked_btn(WebDriver driver){
		element = driver.findElement(By.id("tab1"));
		return element;
	}

	/**
	 *
	 * @return the string
	 */
	// ISS Ranked tab
	public static String issRanked_btn(){
		id = "tab1";
		return id;

	}

	/**
	 * @param driver
	 * @return The web element
	 */
	// Next Order Entry
	public static WebElement nextNewOrder_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_ctl07"));
		return element;
	}

	/**
	 *
	 * @return the string
	 */
	// Next Order Entry
	public static String nextNewOrder_btn(){
		id = "Main_Main_ctl07";
		return id;

	}

	/**
	 * @param driver
	 * @return The web element
	 */
	// Search tab
	public static WebElement feePanelSearch_btn(WebDriver driver){
		element = driver.findElement(By.id("tab2"));
		return element;
	}

	/**
	 *
	 * @return the string
	 */
	// Search tab
	public static String feePanelSearch_btn(){
		id = "tab2";
		return id;

	}
	/**
	 * @param driver
	 * @return The web element
	 */
	// Delete button
	public static WebElement deleteOrder_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#divToolbarContainer > div > table > tbody > tr > td:nth-child(4) > table > tbody > tr > td.MenuBar_Item_Label"));
		return element;
	}

	/**
	 *
	 * @return the string
	 */
	// Delete button
	public static String deleteOrder_btn(){
		cssSelector = "#divToolbarContainer > div > table > tbody > tr > td:nth-child(4) > table > tbody > tr > td.MenuBar_Item_Label";
		return cssSelector;

	}
	/**
	 * @param driver
	 * @return The web element
	 */
	// Delete OK button
	public static WebElement deleteOrderOK_btn(WebDriver driver){
		element = driver.findElement(By.id("sbdmButton1"));
		return element;
	}

	/**
	 *
	 * @return the string
	 */
	// Delete OK button
	public static String deleteOrderOK_btn(){
		id = "sbdmButton1";
		return id;

	}

	/**
	 * @param driver
	 * @return The web element
	 */
	// Delete OK button
	public static WebElement deleteOrdersdialog_txt(WebDriver driver){
		element = driver.findElement(By.id("divMessageOKText"));
		return element;
	}

	/**
	 *
	 * @return the string
	 */
	// Delete OK button
	public static String deleteOrdersdialog_txt(){
		id = "divMessageOKText";
		return id;

	}

	/**
	 * @param driver
	 * @return The web element
	 */
	public static WebElement ordersTitle_txt(WebDriver driver){
		element = driver.findElement(By.id("divOrdersTitle"));
		return element;
	}

	/**
	 * @param driver
	 * @return The web element
	 */
	public static WebElement updateStatusOnVMPXSite_chkkbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_chkUpdateIntegrated"));
		return element;
	}

}