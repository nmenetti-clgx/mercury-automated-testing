package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure Product Requirements page
 */
public class SProductRequirements {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The css selector. */
	private static String cssSelector = null;
	
	/** The id. */
	private static String id = null;

	
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
	 * Edits the btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Edit button
	public static WebElement edit_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='Images/EditIcon16x16.png']"));
		return element;
	}
	
	/**
	 * Edits the btn.
	 *
	 * @return the string
	 */
	public static String edit_btn(){
		cssSelector = "img[src='Images/EditIcon16x16.png']";
		return cssSelector;
	}
	
	/**
	 * Cancel btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Cancel button
	public static WebElement cancel_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='Images/Cancel16x16.png']"));
		return element;
	}
	
	/**
	 * Cancel btn.
	 *
	 * @return the string
	 */
	public static String cancel_btn(){
		cssSelector = "img[src='Images/Cancel16x16.png']";
		return cssSelector;
	}
	
	/**
	 * First product name in table txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// First product name in table text
	public static WebElement firstProductNameInTable_txt(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_grdProducts_it0_0_lblDescription"));
		return element;
	}
	
	/**
	 * First product name in table txt.
	 *
	 * @return the string
	 */
	public static String firstProductNameInTable_txt(){
		id = "ctl00_ctl00_Main_Main_grdProducts_it0_0_lblDescription";
		return id;
	}
	
	/**
	 * Edits the product page txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Edit product page text
	public static WebElement editProductPage_txt(WebDriver driver){
		element = driver.findElement(By.id("divAdminMain"));
		return element;
	}
	
	/**
	 * Edits the product page txt.
	 *
	 * @return the string
	 */
	public static String editProductPage_txt(){
		id = "divAdminMain";
		return id;
	}
	
	/**
	 * Cancel changes dialog txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Cancel Changes dialog text
	public static WebElement cancelChangesDialog_txt(WebDriver driver){
		element = driver.findElement(By.id("divCancel"));
		return element;
	}
	
	/**
	 * Cancel changes dialog txt.
	 *
	 * @return the string
	 */
	public static String cancelChangesDialog_txt(){
		id = "divCancel";
		return id;
	}
	
	/**
	 * Yes cancel btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Yes Cancel button
	public static WebElement yesCancel_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("input[type='button'][onclick='javascript: TakeOutChanges();']"));
		return element;
	}
	
	/**
	 * Yes cancel btn.
	 *
	 * @return the string
	 */
	public static String yesCancel_btn(){
		cssSelector = "input[type='button'][onclick='javascript: TakeOutChanges();']";
		return cssSelector;
	}
	
	/**
	 * No cancel btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// No Cancel button
	public static WebElement noCancel_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("input[type='button'][onclick='javascript: HideDialog();']"));
		return element;
	}
	
	/**
	 * No cancel btn.
	 *
	 * @return the string
	 */
	public static String noCancel_btn(){
		cssSelector = "input[type='button'][onclick='javascript: HideDialog();']";
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
		element = driver.findElement(By.cssSelector("input[type='button'][onclick='javascript:HideAlert();']"));
		return element;
	}
	
	/**
	 * Ok btn.
	 *
	 * @return the string
	 */
	public static String ok_btn(){
		cssSelector = "input[type='button'][onclick='javascript:HideAlert();']";
		return cssSelector;
	}
	
	/**
	 * Alert dialog txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Alert dialog text
	public static WebElement alertDialog_txt(WebDriver driver){
		element = driver.findElement(By.id("AlertDialogText"));
		return element;
	}
	
	/**
	 * Alert dialog txt.
	 *
	 * @return the string
	 */
	public static String alertDialog_txt(){
		id = "AlertDialogText";
		return id;
	}
	
	/**
	 * Document templates btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Document templates button
	public static WebElement documentTemplates_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/Images/EditOrder16x16.png']"));
		return element;
	}
	
	/**
	 * Document templates btn.
	 *
	 * @return the string
	 */
	public static String documentTemplates_btn(){
		cssSelector = "img[src='/Images/EditOrder16x16.png']";
		return cssSelector;
	}
	
	/**
	 * Cancel document templates btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Cancel Document templates button
	public static WebElement cancelDocumentTemplates_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_btnCancel"));
		return element;
	}
	
	/**
	 * Cancel document templates btn.
	 *
	 * @return the string
	 */
	public static String cancelDocumentTemplates_btn(){
		id = "Main_btnCancel";
		return id;
	}
	
	/**
	 * Save document templates btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// saveDocumentTemplates_btn
	public static WebElement saveDocumentTemplates_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_btnSave"));
		return element;
	}
	
	/**
	 * Save document templates btn.
	 *
	 * @return the string
	 */
	public static String saveDocumentTemplates_btn(){
		id = "Main_btnSave";
		return id;
	}
	
	/**
	 * Preview document templates btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// previewDocumentTemplates_btn
	public static WebElement previewDocumentTemplates_btn(WebDriver driver){
		element = driver.findElement(By.id("btnPreview"));
		return element;
	}
	
	/**
	 * Preview document templates btn.
	 *
	 * @return the string
	 */
	public static String previewDocumentTemplates_btn(){
		id = "btnPreview";
		return id;
	}
	
	/**
	 * Creates the document templates txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// createDocumentTemplates_txt
	public static WebElement createDocumentTemplates_txt(WebDriver driver){
		element = driver.findElement(By.id("form1"));
		return element;
	}
	
	/**
	 * Creates the document templates txt.
	 *
	 * @return the string
	 */
	public static String createDocumentTemplates_txt(){
		id = "form1";
		return id;
	}
	
	/**
	 * Select template dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// selectTemplate_dropdown
	public static WebElement selectTemplate_dropdown(WebDriver driver){
		element = driver.findElement(By.id("templateList"));
		return element;
	}
	
	/**
	 * Select template dropdown.
	 *
	 * @return the string
	 */
	public static String selectTemplate_dropdown(){
		id = "templateList";
		return id;
	}
	
	/**
	 * Cancel enter template name btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// cancelEnterTemplateName_btn
	public static WebElement cancelEnterTemplateName_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_sbCancelNew"));
		return element;
	}
	
	/**
	 * Cancel enter template name btn.
	 *
	 * @return the string
	 */
	public static String cancelEnterTemplateName_btn(){
		id = "Dialogs_sbCancelNew";
		return id;
	}
	
	/**
	 * Ok enter template name btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// okEnterTemplateName_btn
	public static WebElement okEnterTemplateName_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_sbSaveNew"));
		return element;
	}
	
	/**
	 * Ok enter template name btn.
	 *
	 * @return the string
	 */
	public static String okEnterTemplateName_btn(){
		id = "Dialogs_sbSaveNew";
		return id;
	}
	
	/**
	 * Template name txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// templateName_txtbx
	public static WebElement templateName_txtbx(WebDriver driver){
		element = driver.findElement(By.id("txtNewName"));
		return element;
	}
	
	/**
	 * Template name txtbx.
	 *
	 * @return the string
	 */
	public static String templateName_txtbx(){
		id = "txtNewName";
		return id;
	}
	
	/**
	 * Editor txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// editor_txtbx
	public static WebElement editor_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_Main_templateEditor_radEditorCenter"));
		return element;
	}
	
	/**
	 * Editor txtbx.
	 *
	 * @return the string
	 */
	public static String editor_txtbx(){
		id = "ctl00_Main_templateEditor_radEditorCenter";
		return id;
	}
	
	/**
	 * Creates the new lnk.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// createNew_lnk
	public static WebElement createNew_lnk(WebDriver driver){
		element = driver.findElement(By.cssSelector("button[class='link'][id='btnNew']"));
		return element;
	}
	
	/**
	 * Creates the new lnk.
	 *
	 * @return the string
	 */
	public static String createNew_lnk(){
		cssSelector = "button[class='link'][id='btnNew']";
		return cssSelector;
	}
	
	/**
	 * No save changes btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// noSaveChanges_btn
	public static WebElement noSaveChanges_btn(WebDriver driver){
		element = driver.findElement(By.id("sbdmButton2"));
		return element;
	}
	
	/**
	 * No save changes btn.
	 *
	 * @return the string
	 */
	public static String noSaveChanges_btn(){
		id = "sbdmButton2";
		return id;
	}
	
	/**
	 * Statement of engagement dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// statementOfEngagement_dropdown
	public static WebElement statementOfEngagement_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_ddlTemplates"));
		return element;
	}
	
	/**
	 * Statement of engagement dropdown.
	 *
	 * @return the string
	 */
	public static String statementOfEngagement_dropdown(){
		id = "Main_Main_ddlTemplates";
		return id;
	}
	
}
