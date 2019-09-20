package pageObjects.Vendors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// TODO: Auto-generated Javadoc
/**
 * The elements on the Vendors Orders page.
 */
public class VOrders {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The css selector. */
	private static String cssSelector = null;
	
	/** The id. */
	private static String id = null;

	
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
	 * Credit card btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Credit Card button
	public static WebElement creditCard_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/Images/TopNav/Cards-Generic.O.png']"));
		return element;
	}
	
	/**
	 * Credit card btn.
	 *
	 * @return the string
	 */
	public static String creditCard_btn(){
		cssSelector = "img[src='/Images/TopNav/Cards-Generic.O.png']";
		return cssSelector;
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
	 * Orders grid txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Order Status text
	public static WebElement ordersGrid_txt(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_grdOrders"));
		return element;
	}
	
	/**
	 * Orders grid txt.
	 *
	 * @return the string
	 */
	public static String ordersGrid_txt(){
		id = "Main_Main_grdOrders";
		return id;
	}
	
	/**
	 * Order delete dialog txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Order Delete dialog text
	public static WebElement orderDeleteDialog_txtbx(WebDriver driver){
		element = driver.findElement(By.id("divConfirmDelete"));
		return element;
	}
	
	/**
	 * Order delete dialog txtbx.
	 *
	 * @return the string
	 */
	public static String orderDeleteDialog_txtbx(){
		id = "divConfirmDelete";
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
		element = driver.findElement(By.id("Dialogs_Dialogs_ctlStatusMessage_txtMessage"));
		return element;
	}
	
	/**
	 * Notes txtbx.
	 *
	 * @return the string
	 */
	public static String notes_txtbx(){
		id = "Dialogs_Dialogs_ctlStatusMessage_txtMessage";
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
		element = driver.findElement(By.cssSelector("input[onclick='Toolbar_Delete_DoPostBack();']"));
		return element;
	}
	
	/**
	 * Ok delete btn.
	 *
	 * @return the string
	 */
	public static String okDelete_btn(){
		cssSelector = "input[onclick='Toolbar_Delete_DoPostBack();']";
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
	 * Vendor profile banner txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Vendor Profile Banner text
	public static WebElement vendorProfileBanner_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector(".VendorProfileBanner"));
		return element;
	}
	
	/**
	 * Vendor profile banner txt.
	 *
	 * @return the string
	 */
	public static String vendorProfileBanner_txt(){
		cssSelector = ".VendorProfileBanner";
		return cssSelector;
	}
	
	//Search Options
	/**
	 * Search option 1 btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement searchOption1_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#divSearch > table > tbody > tr:nth-child(3) > td:nth-child(2) > a > img"));
		return element;
	}
	
	
	/**
	 * Search option 1 btn.
	 *
	 * @return the string
	 */
	public static String  searchOption1_btn(){
		cssSelector = "#divSearch > table > tbody > tr:nth-child(3) > td:nth-child(2) > a > img";
		return cssSelector;
	}
		
	/**
	 * Payment check btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	//Search Options fields Payment Check/Ref #
	public static WebElement paymentCheck_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_cblColumns_11"));
		return element;
	}
		
	/**
	 * Payment check btn.
	 *
	 * @return the string
	 */
	public static String  paymentCheck_btn(){
		id = "Dialogs_Dialogs_cblColumns_11";
		return id;
	}
	
	/**
	 * Payment invoice btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	//Search Options fields Payment Invoice #
	public static WebElement paymentInvoice_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_cblColumns_12"));
		return element;
	}
			
		
	/**
	 * Payment invoice btn.
	 *
	 * @return the string
	 */
	public static String  paymentInvoice_btn(){
		id = "Dialogs_Dialogs_cblColumns_12";
		return id;
	}
	
	/**
	 * Search option save btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	//Search Options Save Button
	public static WebElement searchOptionSave_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#divCustomSearch > div.MsgBoxContent > div > input[type=\"button\"]:nth-child(1)"));
		return element;
	}
				
	/**
	 * Search option save btn.
	 *
	 * @return the string
	 */
	public static String  searchOptionSave_btn(){
		cssSelector = "#divCustomSearch > div.MsgBoxContent > div > input[type=\"button\"]:nth-child(1)";
		return cssSelector;
	}
	
	/**
	 * Search option O K btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	//Search Options OK Button
	public static WebElement searchOptionOK_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#AlertDialog > div.MsgBoxContent > div > input[type=\"button\"]"));
		return element;
	}
					
	/**
	 * Search option O K btn.
	 *
	 * @return the string
	 */
	public static String  searchOptionOK_btn(){
		cssSelector = "#AlertDialog > div.MsgBoxContent > div > input[type=\"button\"]";
		return cssSelector;
	}
	
}
