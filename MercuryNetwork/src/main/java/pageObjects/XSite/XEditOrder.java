package pageObjects.XSite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the XSite Edit Order page
 */
public class XEditOrder {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;

	
	/**
	 * Order date txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Order Date textbox
	public static WebElement orderDate_txtbx(WebDriver driver){
		element = driver.findElement(By.id("PB_txtOrderDate"));
		return element;
	}
	
	/**
	 * Order date txtbx.
	 *
	 * @return the string
	 */
	public static String orderDate_txtbx(){
		id = "PB_txtOrderDate";
		return id;
	}
	
	/**
	 * Due date txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Due Date textbox
	public static WebElement dueDate_txtbx(WebDriver driver){
		element = driver.findElement(By.id("PB_txtDueDate"));
		return element;
	}
	
	/**
	 * Due date txtbx.
	 *
	 * @return the string
	 */
	public static String dueDate_txtbx(){
		id = "PB_txtDueDate";
		return id;
	}
	
	/**
	 * Fha case number txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// FHA Case Number textbox
	public static WebElement fhaCaseNumber_txtbx(WebDriver driver){
		element = driver.findElement(By.id("PB_txtFHA"));
		return element;
	}
	
	/**
	 * Fha case number txtbx.
	 *
	 * @return the string
	 */
	public static String fhaCaseNumber_txtbx(){
		id = "PB_txtFHA";
		return id;
	}
	
	/**
	 * Loan number txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Loan Number textbox
	public static WebElement loanNumber_txtbx(WebDriver driver){
		element = driver.findElement(By.id("PB_txtLoanNumber"));
		return element;
	}
	
	/**
	 * Loan number txtbx.
	 *
	 * @return the string
	 */
	public static String loanNumber_txtbx(){
		id = "PB_txtLoanNumber";
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
		element = driver.findElement(By.id("PB_btnSend2"));
		return element;
	}
	
	/**
	 * Ok btn.
	 *
	 * @return the string
	 */
	public static String ok_btn(){
		id = "PB_btnSend2";
		return id;
	}
	
	/**
	 * Fha case number chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// FHA Case Number checkbox
	public static WebElement fhaCaseNumber_chkbx(WebDriver driver){
		element = driver.findElement(By.id("PB_chkItems_0"));
		return element;
	}
	
	/**
	 * Fha case number chkbx.
	 *
	 * @return the string
	 */
	public static String fhaCaseNumber_chkbx(){
		id = "PB_chkItems_0";
		return id;
	}
	
	/**
	 * Lender case number chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Lender Case Number checkbox
	public static WebElement lenderCaseNumber_chkbx(WebDriver driver){
		element = driver.findElement(By.id("PB_chkItems_1"));
		return element;
	}
	
	/**
	 * Lender case number chkbx.
	 *
	 * @return the string
	 */
	public static String lenderCaseNumber_chkbx(){
		id = "PB_chkItems_1";
		return id;
	}
	
	/**
	 * Order edit O K btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Order Edit OK button
	public static WebElement orderEditOK_btn(WebDriver driver){
		element = driver.findElement(By.id("PB_btnSend"));
		return element;
	}
	
	/**
	 * Order edit O K btn.
	 *
	 * @return the string
	 */
	public static String orderEditOK_btn(){
		id = "PB_btnSend";
		return id;
	}
	
	/**
	 * Sale price txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Sale Price textbox
	public static WebElement salePrice_txtbx(WebDriver driver){
		element = driver.findElement(By.id("PB_txtSalesPrice"));
		return element;
	}
	
	/**
	 * Sale price txtbx.
	 *
	 * @return the string
	 */
	public static String salePrice_txtbx(){
		id = "PB_txtSalesPrice";
		return id;
	}
	
	/**
	 * Update 1 chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Update 1 checkbox
	public static WebElement update1_chkbx(WebDriver driver){
		element = driver.findElement(By.id("PB_chkItems_0"));
		return element;
	}
	
	/**
	 * Update 1 chkbx.
	 *
	 * @return the string
	 */
	public static String update1_chkbx(){
		id = "PB_chkItems_0";
		return id;
	}
	
	/**
	 * Ok update btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// OK Update button
	public static WebElement okUpdate_btn(WebDriver driver){
		element = driver.findElement(By.id("PB_btnSend"));
		return element;
	}
	
	/**
	 * Ok update btn.
	 *
	 * @return the string
	 */
	public static String okUpdate_btn(){
		id = "PB_btnSend";
		return id;
	}
	
	/**
	 * Attach completed report chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Attach completed report checkbox
	public static WebElement attachCompletedReport_chkbx(WebDriver driver){
		element = driver.findElement(By.id("PB_chkAttachCompletedReport"));
		return element;
	}
	
	/**
	 * Attach completed report chkbx.
	 *
	 * @return the string
	 */
	public static String attachCompletedReport_chkbx(){
		id = "PB_chkAttachCompletedReport";
		return id;
	}

	/**
	 * Client information txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Client Information text
	public static WebElement clientInformation_txt(WebDriver driver){
		element = driver.findElement(By.id("PB_tblClientInformation"));
		return element;
	}
	
	/**
	 * Client information txt.
	 *
	 * @return the string
	 */
	public static String clientInformation_txt(){
		id = "PB_tblClientInformation";
		return id;
	}
	
}
