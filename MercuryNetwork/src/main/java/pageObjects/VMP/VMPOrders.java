package pageObjects.VMP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the VMP Orders page
 */
public class VMPOrders {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	/** The css selector. */
	private static String cssSelector = null;

	
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
	 * Profile btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Profile button
	public static WebElement profile_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/Images/TopNav/Profile.png']"));
		return element;
	}
	
	/**
	 * Profile btn.
	 *
	 * @return the string
	 */
	public static String profile_btn(){
		cssSelector = "img[src='/Images/TopNav/Profile.png']";
		return cssSelector;
	}
	
	/**
	 * New order btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// New Order button
	public static WebElement newOrder_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='Images/Toolbar/NewOrderIcon16x16.png']"));
		return element;
	}
	
	/**
	 * New order btn.
	 *
	 * @return the string
	 */
	public static String newOrder_btn(){
		cssSelector = "img[src='Images/Toolbar/NewOrderIcon16x16.png']";
		return cssSelector;
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
		element = driver.findElement(By.cssSelector("ui-iggrid-headertable"));
		return element;
	}
	
	/**
	 * Column headers.
	 *
	 * @return the string
	 */
	public static String columnHeaders(){
		cssSelector = "ui-iggrid-headertable";
		return cssSelector;
	}
	
	/**
	 * Orders table.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Orders table
	public static WebElement ordersTable(WebDriver driver){
		element = driver.findElement(By.id("tblOrders_scroll"));
		return element;
	}
	
	/**
	 * Orders table.
	 *
	 * @return the string
	 */
	public static String ordersTable(){
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
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtFind"));
		return element;
	}
	
	/**
	 * Find txtbx.
	 *
	 * @return the string
	 */
	public static String find_txtbx(){
		id = "ctl00_ctl00_Main_Main_txtFind";
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
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_rbContains"));
		return element;
	}
	
	/**
	 * Contains radio btn.
	 *
	 * @return the string
	 */
	public static String contains_radioBtn(){
		id = "ctl00_ctl00_Main_Main_rbContains";
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
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_ddlField"));
		return element;
	}
	
	/**
	 * In field dropdown.
	 *
	 * @return the string
	 */
	public static String inField_dropdown(){
		id = "ctl00_ctl00_Main_Main_ddlField";
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
	 * Orders table txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Orders table text
	public static WebElement ordersTable_txt(WebDriver driver){
		element = driver.findElement(By.id("tblOrders_container"));
		return element;
	}
	
	/**
	 * Orders table txt.
	 *
	 * @return the string
	 */
	public static String ordersTable_txt(){
		id = "tblOrders_container";
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
	 * Order delete dialog txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Order Delete dialog text
	public static WebElement orderDeleteDialog_txtbx(WebDriver driver){
		element = driver.findElement(By.id("divConfirmDeleteComment"));
		return element;
	}
	
	/**
	 * Order delete dialog txtbx.
	 *
	 * @return the string
	 */
	public static String orderDeleteDialog_txtbx(){
		id = "divConfirmDeleteComment";
		return id;
	}
	
	/**
	 * Notes txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Order Delete notes textbox
	public static WebElement notes_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Dialogs_Dialogs_txtCancelNotes"));
		return element;
	}
	
	/**
	 * Notes txtbx.
	 *
	 * @return the string
	 */
	public static String notes_txtbx(){
		id = "ctl00_ctl00_Dialogs_Dialogs_txtCancelNotes";
		return id;
	}
	
	/**
	 * Ok delete btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// OK Delete button
	public static WebElement okDelete_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("input[onclick='Toolbar_DeleteOrders_DoPostBack();'][value='OK']"));
		return element;
	}
	
	/**
	 * Ok delete btn.
	 *
	 * @return the string
	 */
	public static String okDelete_btn(){
		cssSelector = "input[onclick='Toolbar_DeleteOrders_DoPostBack();'][value='OK']";
		return cssSelector;
	}
	
	/**
	 * Ok deleted btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// OK Deleted button
	public static WebElement okDeleted_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("input[onclick='javascript:HideAlert();']"));
		return element;
	}
	
	/**
	 * Ok deleted btn.
	 *
	 * @return the string
	 */
	public static String okDeleted_btn(){
		cssSelector = "input[onclick='javascript:HideAlert();']";
		return cssSelector;
	}
	
	/**
	 * Deleted order dialog txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Deleted Orders text
	public static WebElement deletedOrderDialog_txt(WebDriver driver){
		element = driver.findElement(By.id("AlertDialog"));
		return element;
	}
	
	/**
	 * Deleted order dialog txt.
	 *
	 * @return the string
	 */
	public static String deletedOrderDialog_txt(){
		id = "AlertDialog";
		return id;
	}
	
	/**
	 * Orders grid txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Order Status text
	public static WebElement ordersGrid_txt(WebDriver driver){
		element = driver.findElement(By.id("tblOrders_scroll"));
		return element;
	}
	
	/**
	 * Orders grid txt.
	 *
	 * @return the string
	 */
	public static String ordersGrid_txt(){
		id = "tblOrders_scroll";
		return id;
	}
	
	/**
	 * View order btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// View Order button
	public static WebElement viewOrder_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='Images/Toolbar/ViewOrder16x16.png']"));
		return element;
	}
	
	/**
	 * View order btn.
	 *
	 * @return the string
	 */
	public static String viewOrder_btn(){
		cssSelector = "img[src='Images/Toolbar/ViewOrder16x16.png']";
		return cssSelector;
	}
	
	/**
	 * Delete order btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Delete Order button
	public static WebElement deleteOrder_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='Images/Toolbar/Cancel.png']"));
		return element;
	}
	
	/**
	 * Delete order btn.
	 *
	 * @return the string
	 */
	public static String deleteOrder_btn(){
		cssSelector = "img[src='Images/Toolbar/Cancel.png']";
		return cssSelector;
	}
	
	/**
	 * Opti val AVM cascade btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// OptiVal AVM Cascade button
	public static WebElement optiValAVMCascade_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/Images/windows.png']"));
		return element;
	}
	
	/**
	 * Opti val AVM cascade btn.
	 *
	 * @return the string
	 */
	public static String optiValAVMCascade_btn(){
		cssSelector = "img[src='/Images/windows.png']";
		return cssSelector;
	}
	
	/**
	 * My columns btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// My Columns button
	public static WebElement myColumns_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/Images/ColumnsIcon15x15.png']"));
		return element;
	}
	
	/**
	 * My columns btn.
	 *
	 * @return the string
	 */
	public static String myColumns_btn(){
		cssSelector = "img[src='/Images/ColumnsIcon15x15.png']";
		return cssSelector;
	}
	
	/**
	 * Table header txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Table Header text
	public static WebElement tableHeader_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector("#tblOrders_headers > thead > tr"));
		return element;
	}
	
	/**
	 * Table header txt.
	 *
	 * @return the string
	 */
	public static String tableHeader_txt(){
		cssSelector = "#tblOrders_headers > thead > tr";
		return cssSelector;
	}
	
	/**
	 * Sign out btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement signOut_btn(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_lnkSignOut"));
		return element;
	}
	
}
