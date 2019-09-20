package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure Clients page
 */
public class SClients {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	/** The css selector. */
	private static String cssSelector = null;

	
	/**
	 * Page txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// page text
	public static WebElement page_txt(WebDriver driver){
		element = driver.findElement(By.id("divAdminMain"));
		return element;
	}
	
	/**
	 * Page txt.
	 *
	 * @return the string
	 */
	public static String page_txt(){
		id = "divAdminMain";
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
		element = driver.findElement(By.cssSelector("img[src='Images/AddContactIcon16x16.png']"));
		return element;
	}
	
	/**
	 * Adds the btn.
	 *
	 * @return the string
	 */
	public static String add_btn(){
		cssSelector = "img[src='Images/AddContactIcon16x16.png']";
		return cssSelector;
	}
	
	/**
	 * Edits the btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Edit button
	public static WebElement edit_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='Images/EditContactIcon16x16.png']"));
		return element;
	}
	
	/**
	 * Edits the btn.
	 *
	 * @return the string
	 */
	public static String edit_btn(){
		cssSelector = "img[src='Images/EditContactIcon16x16.png']";
		return cssSelector;
	}
	
	/**
	 * Delete btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Delete button
	public static WebElement delete_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='Images/DeleteContactIcon16x16.png']"));
		return element;
	}
	
	/**
	 * Delete btn.
	 *
	 * @return the string
	 */
	public static String delete_btn(){
		cssSelector = "img[src='Images/DeleteContactIcon16x16.png']";
		return cssSelector;
	}
	
	/**
	 * Order routing btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Order Routing button
	public static WebElement orderRouting_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='Images/OrderRoutingIcon16x16.png']"));
		return element;
	}
	
	/**
	 * Order routing btn.
	 *
	 * @return the string
	 */
	public static String orderRouting_btn(){
		cssSelector = "img[src='Images/OrderRoutingIcon16x16.png']";
		return cssSelector;
	}
	
	/**
	 * Fee tables btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Fee Tables button
	public static WebElement feeTables_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='Images/FeeTablesIcon16x16.png']"));
		return element;
	}
	
	/**
	 * Fee table btn.
	 *
	 * @return the string
	 */
	public static String feeTable_btn(){
		cssSelector = "img[src='Images/FeeTablesIcon16x16.png']";
		return cssSelector;
	}
	
	/**
	 * Client groups btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Client Groups button
	public static WebElement clientGroups_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='Images/ClientGroupsIcon16x16.png']"));
		return element;
	}
	
	/**
	 * Client groups btn.
	 *
	 * @return the string
	 */
	public static String clientGroups_btn(){
		cssSelector = "img[src='Images/ClientGroupsIcon16x16.png']";
		return cssSelector;
	}
	
	/**
	 * Search txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Search textbox
	public static WebElement search_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_ctlHeader_txtSearch"));
		return element;
	}
	
	/**
	 * Search txtbx.
	 *
	 * @return the string
	 */
	public static String search_txtbx(){
		id = "Main_Main_ctlHeader_txtSearch";
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
		element = driver.findElement(By.cssSelector("img[src='/Images/Magnify.png']"));
		return element;
	}
	
	/**
	 * Search btn.
	 *
	 * @return the string
	 */
	public static String search_btn(){
		cssSelector = "img[src='/Images/Magnify.png']";
		return cssSelector;
	}
	
	/**
	 * Search dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Search dropdown
	public static WebElement search_dropdown(WebDriver driver){
		element = driver.findElement(By.cssSelector("Main_Main_ctlHeader_ddlSearchColumn"));
		return element;
	}
	
	/**
	 * Search dropdown.
	 *
	 * @return the string
	 */
	public static String search_dropdown(){
		cssSelector = "Main_Main_ctlHeader_ddlSearchColumn";
		return cssSelector;
	}
	
	/**
	 * Yes delete btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// yes Delete btn								
	public static WebElement yesDelete_btn(WebDriver driver){								
		element = driver.findElement(By.cssSelector("input[onclick='javascript:btnConfirmDeleteYes_Click();']"));							
		return element;							
	}								
	
	/**
	 * Yes delete btn.
	 *
	 * @return the string
	 */
	public static String yesDelete_btn(){								
		cssSelector = "input[onclick='javascript:btnConfirmDeleteYes_Click();']";							
		return cssSelector;							
	}
	
	/**
	 * Confirm delete dialog txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Confirm Delete dialog text
	public static WebElement confirmDeleteDialog_txt(WebDriver driver){
		element = driver.findElement(By.id("divConfirmDelete"));
		return element;
	}
	
	/**
	 * Confirm delete dialog txt.
	 *
	 * @return the string
	 */
	public static String confirmDeleteDialog_txt(){
		id = "divConfirmDelete";
		return id;
	}
	
	/**
	 * Ok delete btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// OK Delete btn								
	public static WebElement okDelete_btn(WebDriver driver){								
		element = driver.findElement(By.cssSelector("input[onclick='javascript:HideAlert();']"));							
		return element;							
	}								
	
	/**
	 * Ok delete btn.
	 *
	 * @return the string
	 */
	public static String okDelete_btn(){								
		cssSelector = "input[onclick='javascript:HideAlert();']";							
		return cssSelector;							
	}
	
	/**
	 * Contacts deleted dialog txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Contacts Deleted dialog text
	public static WebElement contactsDeletedDialog_txt(WebDriver driver){
		element = driver.findElement(By.id("AlertDialog"));
		return element;
	}
	
	/**
	 * Contacts deleted dialog txt.
	 *
	 * @return the string
	 */
	public static String contactsDeletedDialog_txt(){
		id = "AlertDialog";
		return id;
	}

	/**
	 * Contacts grid txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Contacts grid text
	public static WebElement contactsGrid_txt(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_grdContacts"));
		return element;
	}
	
	/**
	 * Contacts grid txt.
	 *
	 * @return the string
	 */
	public static String contactsGrid_txt(){
		id = "Main_Main_grdContacts";
		return id;
	}
	
}
