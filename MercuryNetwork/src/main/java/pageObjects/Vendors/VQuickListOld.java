package pageObjects.Vendors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Vendors Quick List page
 */
public class VQuickListOld {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The css selector. */
	private static String cssSelector = null;
	
	/** The id. */
	private static String id = null;

	
	/**
	 * New item btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// New Item button
	public static WebElement newItem_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/Images/NewIcon16x16.png']"));
		return element;
	}
	
	/**
	 * New item btn.
	 *
	 * @return the string
	 */
	public static String newItem_btn(){
		cssSelector = "img[src='/Images/NewIcon16x16.png']";
		return cssSelector;
	}
	
	/**
	 * Delete selected btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Delete Selected button
	public static WebElement deleteSelected_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/Images/DeleteIcon16x16.png']"));
		return element;
	}
	
	/**
	 * Delete selected btn.
	 *
	 * @return the string
	 */
	public static String deleteSelected_btn(){
		cssSelector = "img[src='/Images/DeleteIcon16x16.png']";
		return cssSelector;
	}
	
	/**
	 * Use selected btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Use Selected button
	public static WebElement useSelected_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/Images/UseIconEnabled.png']"));
		return element;
	}
	
	/**
	 * Use selected btn.
	 *
	 * @return the string
	 */
	public static String useSelected_btn(){
		cssSelector = "img[src='/Images/UseIconEnabled.png']";
		return cssSelector;
	}
	
	/**
	 * Quick list dialog.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Quick List dialog
	public static WebElement quickListDialog(WebDriver driver){
		element = driver.findElement(By.id("divQuickList"));
		return element;
	}
	
	/**
	 * Quick list dialog.
	 *
	 * @return the string
	 */
	public static String quickListDialog(){
		id = "divQuickList";
		return id;
	}
	
	/**
	 * Quick list exists.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Quick List exists
	public static WebElement quickListExists(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_QuickList_gvQLItems"));
		return element;
	}
	
	/**
	 * Quick list exists.
	 *
	 * @return the string
	 */
	public static String quickListExists(){
		id = "Dialogs_Dialogs_QuickList_gvQLItems";
		return id;
	}
	
	// Confirm Delete Quick List Dialog
//	public static WebElement confirmDeleteQuickListDialog(WebDriver driver){
//		element = driver.findElement(By.id("Dialogs_Dialogs_QuickList_pnlConfirmDeleteSelected"));
//		return element;
//	}
//	public static String confirmDeleteQuickListDialog(){
//		id = "Dialogs_Dialogs_QuickList_pnlConfirmDeleteSelected";
//		return id;
/**
	 * Confirm delete quick list dialog.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	//	}
	public static WebElement confirmDeleteQuickListDialog(WebDriver driver){
		element = driver.findElement(By.cssSelector("#div1 > div.MsgBoxContent > table > tbody > tr > td.DialogMessage"));
		return element;
	}
	
	/**
	 * Confirm delete quick list dialog.
	 *
	 * @return the string
	 */
	public static String confirmDeleteQuickListDialog(){
		cssSelector = "#div1 > div.MsgBoxContent > table > tbody > tr > td.DialogMessage";
		return cssSelector;
	}
	
	/**
	 * Yes btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Yes button
	public static WebElement yes_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_QuickList_btnConfirmDeleteSelected"));
		return element;
	}
	
	/**
	 * Yes btn.
	 *
	 * @return the string
	 */
	public static String yes_btn(){
		id = "Dialogs_Dialogs_QuickList_btnConfirmDeleteSelected";
		return id;
	}
	
	/**
	 * No btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// No button
	public static WebElement no_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_QuickList_btnCancelDeleteSelected"));
		return element;
	}
	
	/**
	 * No btn.
	 *
	 * @return the string
	 */
	public static String no_btn(){
		id = "Dialogs_Dialogs_QuickList_btnCancelDeleteSelected";
		return id;
	}
	
	/**
	 * Description txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Description textbox
	public static WebElement description_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_QuickList_txtAddItemDescription"));
		return element;
	}
	
	/**
	 * Description txtbx.
	 *
	 * @return the string
	 */
	public static String description_txtbx(){
		id = "Dialogs_Dialogs_QuickList_txtAddItemDescription";
		return id;
	}
	
	/**
	 * Text txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Text textbox
	public static WebElement text_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_QuickList_txtAddItemText"));
		return element;
	}
	
	/**
	 * Text txtbx.
	 *
	 * @return the string
	 */
	public static String text_txtbx(){
		id = "Dialogs_Dialogs_QuickList_txtAddItemText";
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
		element = driver.findElement(By.cssSelector("#Dialogs_Dialogs_QuickList_divAddItem > table > tbody > tr > td > div > table > tbody > tr > td:nth-child(1) > table > tbody > tr > td:nth-child(1) > img"));
		return element;
	}
	
	/**
	 * Save btn.
	 *
	 * @return the string
	 */
	public static String save_btn(){
		cssSelector = "#Dialogs_Dialogs_QuickList_divAddItem > table > tbody > tr > td > div > table > tbody > tr > td:nth-child(1) > table > tbody > tr > td:nth-child(1) > img";
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
		element = driver.findElement(By.id("Dialogs_Dialogs_QuickList_gvQLItems_btnEditItem_0"));
		return element;
	}
	
	/**
	 * Edits the btn.
	 *
	 * @return the string
	 */
	public static String edit_btn(){
		id = "Dialogs_Dialogs_QuickList_gvQLItems_btnEditItem_0";
		return id;
	}
	
	/**
	 * Edits the text txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Edit Text textbox
	public static WebElement editText_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_QuickList_txtEditItemDescription"));
		return element;
	}
	
	/**
	 * Edits the text txtbx.
	 *
	 * @return the string
	 */
	public static String editText_txtbx(){
		id = "Dialogs_Dialogs_QuickList_txtEditItemDescription";
		return id;
	}
	
	/**
	 * Edits the description txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Edit Text textbox
	public static WebElement editDescription_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_QuickList_txtEditItemText"));
		return element;
	}
	
	/**
	 * Edits the description txtbx.
	 *
	 * @return the string
	 */
	public static String editDescription_txtbx(){
		id = "Dialogs_Dialogs_QuickList_txtEditItemText";
		return id;
	}
	
	/**
	 * Edits the save btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Edit Save button
	public static WebElement editSave_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#Dialogs_Dialogs_QuickList_divEditItem > table > tbody > tr > td > div > table > tbody > tr > td:nth-child(1) > table > tbody > tr > td:nth-child(1) > img"));
		return element;
	}
	
	/**
	 * Edits the save btn.
	 *
	 * @return the string
	 */
	public static String editSave_btn(){
		cssSelector = "#Dialogs_Dialogs_QuickList_divEditItem > table > tbody > tr > td > div > table > tbody > tr > td:nth-child(1) > table > tbody > tr > td:nth-child(1) > img";
		return cssSelector;
	}
	
}
