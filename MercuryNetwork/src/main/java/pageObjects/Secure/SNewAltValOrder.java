package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure Account page
 */
public class SNewAltValOrder {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;

	
	/**
	 * Product dropdown
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Product dropdown
	public static WebElement product_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_ddlProduct"));
		return element;
	}
	
	/**
	 * Product dropdown
	 *
	 * @return the string
	 */
	public static String product_dropdown(){
		id = "Main_Main_ddlProduct";
		return id;
	}
	
	/**
	 * Address textbox
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Product dropdown
	public static WebElement address_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_txtAddress"));
		return element;
	}
	
	/**
	 * Address textbox
	 *
	 * @return the string
	 */
	public static String address_txtbx(){
		id = "Main_Main_txtAddress";
		return id;
	}
	
	/**
	 * City textbox
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	//  textbox
	public static WebElement city_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_txtCity"));
		return element;
	}
	
	/**
	 * City textbox
	 *
	 * @return the string
	 */
	public static String city_txtbx(){
		id = "Main_Main_txtCity";
		return id;
	}
	
	/**
	 * Zip code textbox
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	//  textbox
	public static WebElement zipCode_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_txtZipCode"));
		return element;
	}
	
	/**
	 * Zip code textbox
	 *
	 * @return the string
	 */
	public static String zipCode_txtbx(){
		id = "Main_Main_txtZipCode";
		return id;
	}
	
	/**
	 * State dropdown
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	//  textbox
	public static WebElement state_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_ddlState"));
		return element;
	}
	
	/**
	 * State dropdown
	 *
	 * @return the string
	 */
	public static String state_dropdown(){
		id = "Main_Main_ddlState";
		return id;
	}
	
	/**
	 * Name textbox
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	//  textbox
	public static WebElement name_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_txtPropertyAccessName"));
		return element;
	}
	
	/**
	 * Name textbox
	 *
	 * @return the string
	 */
	public static String name_txtbx(){
		id = "Main_Main_txtPropertyAccessName";
		return id;
	}
	
	/**
	 * Phone textbox
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	//  textbox
	public static WebElement phone_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_txtPropertyAccessPhone"));
		return element;
	}
	
	/**
	 * Phone textbox
	 *
	 * @return the string
	 */
	public static String phone_txtbx(){
		id = "Main_Main_txtPropertyAccessPhone";
		return id;
	}
	
	/**
	 * Alt phone textbox
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	//  textbox
	public static WebElement altPhone_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_txtPropertyAccessAltPhone"));
		return element;
	}
	
	/**
	 * Alt phone textbox
	 *
	 * @return the string
	 */
	public static String altPhone_txtbx(){
		id = "Main_Main_txtPropertyAccessAltPhone";
		return id;
	}
	
	/**
	 * Notes textbox
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	//  textbox
	public static WebElement notes_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_ctlPropertyContactNotes_txtMessage"));
		return element;
	}
	
	/**
	 * Notes textbox
	 *
	 * @return the string
	 */
	public static String notes_txtbx(){
		id = "Main_Main_ctlPropertyContactNotes_txtMessage";
		return id;
	}
	
	/**
	 * Loan numbedr textbox
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	//  textbox
	public static WebElement loanNumber_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_txtLoanNumber"));
		return element;
	}
	
	/**
	 * Loan number textbox
	 *
	 * @return the string
	 */
	public static String loanNumber_txtbx(){
		id = "Main_Main_txtLoanNumber";
		return id;
	}
	
	/**
	 * Borrower textbox
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	//  textbox
	public static WebElement borrower_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_txtBorrowerName"));
		return element;
	}
	
	/**
	 * Borrower textbox
	 *
	 * @return the string
	 */
	public static String borrower_txtbx(){
		id = "Main_Main_txtBorrowerName";
		return id;
	}
	
	/**
	 * Borrower email textbox
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	//  textbox
	public static WebElement borrowerEmail_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_txtBorrowerEmail"));
		return element;
	}
	
	/**
	 * Borrower email textbox
	 *
	 * @return the string
	 */
	public static String borrowerEmail_txtbx(){
		id = "Main_Main_txtBorrowerEmail";
		return id;
	}
	
	/**
	 * Rush order checkbox
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	//  textbox
	public static WebElement rushOrder_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_cbRushOrder"));
		return element;
	}
	
	/**
	 * Rush order checkbox
	 *
	 * @return the string
	 */
	public static String rushOrder_chkbx(){
		id = "Main_Main_cbRushOrder";
		return id;
	}
	
	/**
	 * Coborrower textbox
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	//  textbox
	public static WebElement coborrower_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_txtCoborrowerName"));
		return element;
	}
	
	/**
	 * Coborrower textbox
	 *
	 * @return the string
	 */
	public static String coborrower_txtbx(){
		id = "Main_Main_txtCoborrowerName";
		return id;
	}
	
	/**
	 * Coborrower email textbox
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	//  textbox
	public static WebElement coborrowerEmail_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_txtCoborrowerEmail"));
		return element;
	}
	
	/**
	 * Coborrower email textbox
	 *
	 * @return the string
	 */
	public static String coborrowerEmail_txtbx(){
		id = "Main_Main_txtCoborrowerEmail";
		return id;
	}
	
	/**
	 * Finish Top button
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	//  textbox
	public static WebElement finishTop_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_btnFinish"));
		return element;
	}
	
	/**
	 * Finish Top textbox
	 *
	 * @return the string
	 */
	public static String finishTop_btn(){
		id = "Main_Main_btnFinish";
		return id;
	}
	
	/**
	 * Finish Bottom textbox
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	//  textbox
	public static WebElement finishBottom_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_btnBottomFinish"));
		return element;
	}
	
	/**
	 * Finish Bottom textbox
	 *
	 * @return the string
	 */
	public static String finishBottom_btn(){
		id = "Main_Main_btnBottomFinish";
		return id;
	}

}