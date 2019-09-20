package pageObjects.XSite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the XSite Orders page
 */
public class XOrders {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	/** The css selector. */
	private static String cssSelector = null;

	
	/**
	 * History txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// History text
	public static WebElement history_txt(WebDriver driver){
		element = driver.findElement(By.id("PB_tdStatus"));
		return element;
	}
	
	/**
	 * History txt.
	 *
	 * @return the string
	 */
	public static String history_txt(){
		id = "PB_tdStatus";
		return id;
	}
	
	/**
	 * Toolbar.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Tool bar
	public static WebElement toolbar(WebDriver driver){
		element = driver.findElement(By.id("divToolbar"));
		return element;
	}
	
	/**
	 * Toolbar.
	 *
	 * @return the string
	 */
	public static String toolbar(){
		id = "divToolbar";
		return id;
	}
	
	/**
	 * Order information txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Order Information text
	public static WebElement orderInformation_txt(WebDriver driver){
		element = driver.findElement(By.id("PB_divMain"));
		return element;
	}
	
	/**
	 * Order information txt.
	 *
	 * @return the string
	 */
	public static String orderInformation_txt(){
		id = "PB_divMain";
		return id;
	}
	
	/**
	 * Comments txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Comments text
	public static WebElement comments_txt(WebDriver driver){
		element = driver.findElement(By.id("PB_tdComments"));
		return element;
	}
	
	/**
	 * Comments txt.
	 *
	 * @return the string
	 */
	public static String comments_txt(){
		id = "PB_tdComments";
		return id;
	}
	
	/**
	 * Documents txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Documents text
	public static WebElement documents_txt(WebDriver driver){
		element = driver.findElement(By.id("PB_trFiles"));
		return element;
	}
	
	/**
	 * Documents txt.
	 *
	 * @return the string
	 */
	public static String documents_txt(){
		id = "PB_trFiles";
		return id;
	}
	
	/**
	 * Find txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Find textbox
	public static WebElement find_txtbx(WebDriver driver){
		element = driver.findElement(By.id("txtFind"));
		return element;
	}
	
	/**
	 * Find txtbx.
	 *
	 * @return the string
	 */
	public static String find_txtbx(){
		id = "txtFind";
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
		element = driver.findElement(By.id("rbContains"));
		return element;
	}
	
	/**
	 * Contains radio btn.
	 *
	 * @return the string
	 */
	public static String contains_radioBtn(){
		id = "txtFind";
		return id;
	}
	
	/**
	 * Field dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Field dropdown
	public static WebElement field_dropdown(WebDriver driver){
		element = driver.findElement(By.id("ddlField"));
		return element;
	}
	
	/**
	 * Field dropdown.
	 *
	 * @return the string
	 */
	public static String field_dropdown(){
		id = "ddlField";
		return id;
	}
	
	/**
	 * Magnifying glass btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Magnifying glass button
	public static WebElement magnifyingGlass_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/images/magnify.png']"));
		return element;
	}
	
	/**
	 * Magnifying glass btn.
	 *
	 * @return the string
	 */
	public static String magnifyingGlass_btn(){
		cssSelector = "img[src='/images/magnify.png']";
		return cssSelector;
	}
	
	/**
	 * Due date txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Due Date text
	public static WebElement dueDate_txt(WebDriver driver){
		element = driver.findElement(By.id("PB_txtDueDate"));
		return element;
	}
	
	/**
	 * Due date txt.
	 *
	 * @return the string
	 */
	public static String dueDate_txt(){
		id = "PB_txtDueDate";
		return id;
	}
	
	/**
	 * Fee txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Fee text
	public static WebElement fee_txt(WebDriver driver){
		element = driver.findElement(By.id("PB_txtFee"));
		return element;
	}
	
	/**
	 * Fee txt.
	 *
	 * @return the string
	 */
	public static String fee_txt(){
		id = "PB_txtFee";
		return id;
	}
	
	/**
	 * Edits the btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Edit button
	public static WebElement edit_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/graphics/btnEdit.jpg']"));
		return element;
	}
	
	/**
	 * Edits the btn.
	 *
	 * @return the string
	 */
	public static String edit_btn(){
		cssSelector = "img[src='/graphics/btnEdit.jpg']";
		return cssSelector;
	}
	
	/**
	 * Message btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Message button
	public static WebElement message_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/graphics/btnMsg.jpg']"));
		return element;
	}
	
	/**
	 * Message btn.
	 *
	 * @return the string
	 */
	public static String message_btn(){
		cssSelector = "img[src='/graphics/btnMsg.jpg']";
		return cssSelector;
	}
	
	/**
	 * Status btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Status button
	public static WebElement status_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/graphics/btnStatus.jpg']"));
		return element;
	}
	
	/**
	 * Status btn.
	 *
	 * @return the string
	 */
	public static String status_btn(){
		cssSelector = "img[src='/graphics/btnStatus.jpg']";
		return cssSelector;
	}
	
	/**
	 * Sync to mercury btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Sync to Mercury button
	public static WebElement syncToMercury_btn(WebDriver driver){
		element = driver.findElement(By.id("btnSyncToMercury"));
		return element;
	}
	
	/**
	 * Sync to mercury btn.
	 *
	 * @return the string
	 */
	public static String syncToMercury_btn(){
		id = "btnSyncToMercury";
		return id;
	}
	
	/**
	 * First row txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// First row text
	public static WebElement firstRow_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector("#PB_tdStatus > table > tbody > tr:nth-child(1) > td:nth-child(2)"));
		return element;
	}
	
	/**
	 * First row txt.
	 *
	 * @return the string
	 */
	public static String firstRow_txt(){
		cssSelector = "#PB_tdStatus > table > tbody > tr:nth-child(1) > td:nth-child(2)";
		return cssSelector;
	}
	
	/**
	 * Fha number txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// FHA Number text
	public static WebElement fhaNumber_txt(WebDriver driver){
		element = driver.findElement(By.id("PB_txtFHA"));
		return element;
	}
	
	/**
	 * Fha number txt.
	 *
	 * @return the string
	 */
	public static String fhaNumber_txt(){
		id = "PB_txtFHA";
		return id;
	}
	
	/**
	 * Loan number txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Loan Number text
	public static WebElement loanNumber_txt(WebDriver driver){
		element = driver.findElement(By.id("PB_txtLoanNumber"));
		return element;
	}
	
	/**
	 * Loan number txt.
	 *
	 * @return the string
	 */
	public static String loanNumber_txt(){
		id = "PB_txtLoanNumber";
		return id;
	}
	
	/**
	 * Occupancy txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Occupancy text
	public static WebElement occupancy_txt(WebDriver driver){
		element = driver.findElement(By.id("PB_txtOccupancy"));
		return element;
	}
	
	/**
	 * Occupancy txt.
	 *
	 * @return the string
	 */
	public static String occupancy_txt(){
		id = "PB_txtOccupancy";
		return id;
	}
	
	/**
	 * Loan type txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// loanType txt								
	public static WebElement loanType_txt(WebDriver driver){								
		element = driver.findElement(By.id("PB_txtLoanType"));							
		return element;							
	}								
	
	/**
	 * Loan type txt.
	 *
	 * @return the string
	 */
	public static String loanType_txt(){								
		id = "PB_txtLoanType";							
		return id;							
	}								
									
	/**
	 * Loan purpose txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// loanPurpose txt								
	public static WebElement loanPurpose_txt(WebDriver driver){								
		element = driver.findElement(By.id("PB_txtLoanPurpose"));							
		return element;							
	}								
	
	/**
	 * Loan purpose txt.
	 *
	 * @return the string
	 */
	public static String loanPurpose_txt(){								
		id = "PB_txtLoanPurpose";							
		return id;							
	}								
									
	/**
	 * Lender case number txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// lenderCaseNumber txt								
	public static WebElement lenderCaseNumber_txt(WebDriver driver){								
		element = driver.findElement(By.id("PB_txtLoanNumber"));							
		return element;							
	}								
	
	/**
	 * Lender case number txt.
	 *
	 * @return the string
	 */
	public static String lenderCaseNumber_txt(){								
		id = "PB_txtLoanNumber";							
		return id;							
	}								
									
	/**
	 * Fha case number txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// fhaCaseNumber txt								
	public static WebElement fhaCaseNumber_txt(WebDriver driver){								
		element = driver.findElement(By.id("PB_txtFHA"));							
		return element;							
	}								
	
	/**
	 * Fha case number txt.
	 *
	 * @return the string
	 */
	public static String fhaCaseNumber_txt(){								
		id = "PB_txtFHA";							
		return id;							
	}								
									
	/**
	 * Client file number txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// clientFileNumber txt								
	public static WebElement clientFileNumber_txt(WebDriver driver){								
		element = driver.findElement(By.id("PB_txtFileNumber"));							
		return element;							
	}								
	
	/**
	 * Client file number txt.
	 *
	 * @return the string
	 */
	public static String clientFileNumber_txt(){								
		id = "PB_txtFileNumber";							
		return id;							
	}								
									
	/**
	 * Sub len client txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// subLenClient txt								
	public static WebElement subLenClient_txt(WebDriver driver){								
		element = driver.findElement(By.id("PB_txtLenderCompany"));							
		return element;							
	}								
	
	/**
	 * Sub len client txt.
	 *
	 * @return the string
	 */
	public static String subLenClient_txt(){								
		id = "PB_txtLenderCompany";							
		return id;							
	}								
									
	/**
	 * Lender address txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// lenderAddress txt								
	public static WebElement lenderAddress_txt(WebDriver driver){								
		element = driver.findElement(By.id("PB_tdLenderAddress"));							
		return element;							
	}								
	
	/**
	 * Lender address txt.
	 *
	 * @return the string
	 */
	public static String lenderAddress_txt(){								
		id = "PB_tdLenderAddress";							
		return id;							
	}								
									
	/**
	 * Sub borrower txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// subBorrower txt								
	public static WebElement subBorrower_txt(WebDriver driver){								
		element = driver.findElement(By.id("PB_ucContactAndAccessInfo_lbBorrowerName"));							
		return element;							
	}								
	
	/**
	 * Sub borrower txt.
	 *
	 * @return the string
	 */
	public static String subBorrower_txt(){								
		id = "PB_ucContactAndAccessInfo_lbBorrowerName";							
		return id;							
	}								
									
	/**
	 * Borrower contact type 2 txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// borrowerContactType2 txt								
	public static WebElement borrowerContactType2_txt(WebDriver driver){								
		element = driver.findElement(By.id("PB_ucContactAndAccessInfo_lbBorrowerContactType2"));							
		return element;							
	}								
	
	/**
	 * Borrower contact type 2 txt.
	 *
	 * @return the string
	 */
	public static String borrowerContactType2_txt(){								
		id = "PB_ucContactAndAccessInfo_lbBorrowerContactType2";							
		return id;							
	}								
									
	/**
	 * Borrower contact 2 txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// borrowerContact2 txt								
	public static WebElement borrowerContact2_txt(WebDriver driver){								
		element = driver.findElement(By.id("PB_ucContactAndAccessInfo_lbBorrowerContact2"));							
		return element;							
	}								
	
	/**
	 * Borrower contact 2 txt.
	 *
	 * @return the string
	 */
	public static String borrowerContact2_txt(){								
		id = "PB_ucContactAndAccessInfo_lbBorrowerContact2";							
		return id;							
	}								
									
	/**
	 * Borrower contact type 1 txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// borrowerContactType1 txt								
	public static WebElement borrowerContactType1_txt(WebDriver driver){								
		element = driver.findElement(By.id("PB_ucContactAndAccessInfo_lbBorrowerContactType1"));							
		return element;							
	}								
	
	/**
	 * Borrower contact type 1 txt.
	 *
	 * @return the string
	 */
	public static String borrowerContactType1_txt(){								
		id = "PB_ucContactAndAccessInfo_lbBorrowerContact1";							
		return id;							
	}								
									
	/**
	 * Borrower contact 1 txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// borrowerContact1 txt								
	public static WebElement borrowerContact1_txt(WebDriver driver){								
		element = driver.findElement(By.id("PB_ucContactAndAccessInfo_lbBorrowerContact1"));							
		return element;							
	}								
	
	/**
	 * Borrower contact 1 txt.
	 *
	 * @return the string
	 */
	public static String borrowerContact1_txt(){								
		id = "PB_ucContactAndAccessInfo_lbBorrowerContact1";							
		return id;							
	}								
									
	/**
	 * Co borrower txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// coBorrower txt								
	public static WebElement coBorrower_txt(WebDriver driver){								
		element = driver.findElement(By.id("PB_ucContactAndAccessInfo_lbCoBorrowerName"));							
		return element;							
	}								
	
	/**
	 * Co borrower txt.
	 *
	 * @return the string
	 */
	public static String coBorrower_txt(){								
		id = "PB_ucContactAndAccessInfo_lbCoBorrowerName";							
		return id;							
	}								
									
	/**
	 * Co borrower contact type 2 txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// coBorrowerContactType2 txt								
	public static WebElement coBorrowerContactType2_txt(WebDriver driver){								
		element = driver.findElement(By.id("PB_ucContactAndAccessInfo_lbCoBorrowerContactType2"));							
		return element;							
	}								
	
	/**
	 * Co borrower contact type 2 txt.
	 *
	 * @return the string
	 */
	public static String coBorrowerContactType2_txt(){								
		id = "PB_ucContactAndAccessInfo_lbCoBorrowerContactType2";							
		return id;							
	}								
									
	/**
	 * Co borrower contact 2 txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// coBorrowerContact2 txt								
	public static WebElement coBorrowerContact2_txt(WebDriver driver){								
		element = driver.findElement(By.id("PB_ucContactAndAccessInfo_lbCoBorrowerContact2"));							
		return element;							
	}								
	
	/**
	 * Co borrower contact 2 txt.
	 *
	 * @return the string
	 */
	public static String coBorrowerContact2_txt(){								
		id = "PB_ucContactAndAccessInfo_lbCoBorrowerContact2";							
		return id;							
	}								
									
	/**
	 * Co borrower contact type 1 txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// coBorrowerContactType1 txt								
	public static WebElement coBorrowerContactType1_txt(WebDriver driver){								
		element = driver.findElement(By.id("PB_ucContactAndAccessInfo_lbCoBorrowerContactType1"));							
		return element;							
	}								
	
	/**
	 * Co borrower contact type 1 txt.
	 *
	 * @return the string
	 */
	public static String coBorrowerContactType1_txt(){								
		id = "PB_ucContactAndAccessInfo_lbCoBorrowerContactType1";							
		return id;							
	}								
									
	/**
	 * Co borrower contact 1 txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// coBorrowerContact1 txt								
	public static WebElement coBorrowerContact1_txt(WebDriver driver){								
		element = driver.findElement(By.id("PB_ucContactAndAccessInfo_lbCoBorrowerContact1"));							
		return element;							
	}								
	
	/**
	 * Co borrower contact 1 txt.
	 *
	 * @return the string
	 */
	public static String coBorrowerContact1_txt(){								
		id = "PB_ucContactAndAccessInfo_lbCoBorrowerContact1";							
		return id;							
	}								
									
	/**
	 * Sub agent txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// subAgent txt								
	public static WebElement subAgent_txt(WebDriver driver){								
		element = driver.findElement(By.id("PB_ucContactAndAccessInfo_lbAgentName"));							
		return element;							
	}								
	
	/**
	 * Sub agent txt.
	 *
	 * @return the string
	 */
	public static String subAgent_txt(){								
		id = "PB_ucContactAndAccessInfo_lbAgentName";							
		return id;							
	}								
									
	/**
	 * Agent contact type 2 txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// agentContactType2 txt								
	public static WebElement agentContactType2_txt(WebDriver driver){								
		element = driver.findElement(By.id("PB_ucContactAndAccessInfo_lbAgent2"));							
		return element;							
	}								
	
	/**
	 * Agent contact type 2 txt.
	 *
	 * @return the string
	 */
	public static String agentContactType2_txt(){								
		id = "PB_ucContactAndAccessInfo_lbAgent2";							
		return id;							
	}								
									
	/**
	 * Agent contact 2 txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// agentContact2 txt								
	public static WebElement agentContact2_txt(WebDriver driver){								
		element = driver.findElement(By.id("PB_ucContactAndAccessInfo_lbAgentContact2"));							
		return element;							
	}								
	
	/**
	 * Agent contact 2 txt.
	 *
	 * @return the string
	 */
	public static String agentContact2_txt(){								
		id = "PB_ucContactAndAccessInfo_lbAgentContact2";							
		return id;							
	}								
									
	/**
	 * Agent contact type 1 txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// agentContactType1 txt								
	public static WebElement agentContactType1_txt(WebDriver driver){								
		element = driver.findElement(By.id("PB_ucContactAndAccessInfo_lbAgent1"));							
		return element;							
	}								
	
	/**
	 * Agent contact type 1 txt.
	 *
	 * @return the string
	 */
	public static String agentContactType1_txt(){								
		id = "PB_ucContactAndAccessInfo_lbAgent1";							
		return id;							
	}								
									
	/**
	 * Agent contact 1 txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// agentContact1 txt								
	public static WebElement agentContact1_txt(WebDriver driver){								
		element = driver.findElement(By.id("PB_ucContactAndAccessInfo_lbAgentContact1"));							
		return element;							
	}								
	
	/**
	 * Agent contact 1 txt.
	 *
	 * @return the string
	 */
	public static String agentContact1_txt(){								
		id = "PB_ucContactAndAccessInfo_lbAgentContact1";							
		return id;							
	}								
									
	/**
	 * Sub other txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// subOther txt								
	public static WebElement subOther_txt(WebDriver driver){								
		element = driver.findElement(By.id("PB_ucContactAndAccessInfo_lbOtherName"));							
		return element;							
	}								
	
	/**
	 * Sub other txt.
	 *
	 * @return the string
	 */
	public static String subOther_txt(){								
		id = "PB_ucContactAndAccessInfo_lbOtherName";							
		return id;							
	}								
									
	/**
	 * Other contact type 2 txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// otherContactType2 txt								
	public static WebElement otherContactType2_txt(WebDriver driver){								
		element = driver.findElement(By.id("PB_ucContactAndAccessInfo_lbOtherType2"));							
		return element;							
	}								
	
	/**
	 * Other contact type 2 txt.
	 *
	 * @return the string
	 */
	public static String otherContactType2_txt(){								
		id = "PB_ucContactAndAccessInfo_lbOtherType2";							
		return id;							
	}								
									
	/**
	 * Other contact 2 txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// otherContact2 txt								
	public static WebElement otherContact2_txt(WebDriver driver){								
		element = driver.findElement(By.id("PB_ucContactAndAccessInfo_lbOtherContact2"));							
		return element;							
	}								
	
	/**
	 * Other contact 2 txt.
	 *
	 * @return the string
	 */
	public static String otherContact2_txt(){								
		id = "PB_ucContactAndAccessInfo_lbOtherContact2";							
		return id;							
	}								
									
	/**
	 * Other contact type 1 txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// otherContactType1 txt								
	public static WebElement otherContactType1_txt(WebDriver driver){								
		element = driver.findElement(By.id("PB_ucContactAndAccessInfo_lbOtherType1"));							
		return element;							
	}								
	
	/**
	 * Other contact type 1 txt.
	 *
	 * @return the string
	 */
	public static String otherContactType1_txt(){								
		id = "PB_ucContactAndAccessInfo_lbOtherType1";							
		return id;							
	}								
									
	/**
	 * Other contact 1 txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// otherContact1 txt								
	public static WebElement otherContact1_txt(WebDriver driver){								
		element = driver.findElement(By.id("PB_ucContactAndAccessInfo_lbOtherContact1"));							
		return element;							
	}								
	
	/**
	 * Other contact 1 txt.
	 *
	 * @return the string
	 */
	public static String otherContact1_txt(){								
		id = "PB_ucContactAndAccessInfo_lbOtherContact1";							
		return id;							
	}								
									
	/**
	 * Sub occupant txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// subOccupant txt								
	public static WebElement subOccupant_txt(WebDriver driver){								
		element = driver.findElement(By.id("PB_ucContactAndAccessInfo_lbOccName"));							
		return element;							
	}								
	
	/**
	 * Sub occupant txt.
	 *
	 * @return the string
	 */
	public static String subOccupant_txt(){								
		id = "PB_ucContactAndAccessInfo_lbOccName";							
		return id;							
	}								
									
	/**
	 * Occupant contact type 2 txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// occupantContactType2 txt								
	public static WebElement occupantContactType2_txt(WebDriver driver){								
		element = driver.findElement(By.id("PB_ucContactAndAccessInfo_lbOcc2"));							
		return element;							
	}								
	
	/**
	 * Occupant contact type 2 txt.
	 *
	 * @return the string
	 */
	public static String occupantContactType2_txt(){								
		id = "PB_ucContactAndAccessInfo_lbOcc2";							
		return id;							
	}								
									
	/**
	 * Occupant contact 2 txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// occupantContact2 txt								
	public static WebElement occupantContact2_txt(WebDriver driver){								
		element = driver.findElement(By.id("PB_ucContactAndAccessInfo_lbOccContact2"));							
		return element;							
	}								
	
	/**
	 * Occupant contact 2 txt.
	 *
	 * @return the string
	 */
	public static String occupantContact2_txt(){								
		id = "PB_ucContactAndAccessInfo_lbOccContact2";							
		return id;							
	}								
									
	/**
	 * Occupant contact type 1 txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// occupantContactType1 txt								
	public static WebElement occupantContactType1_txt(WebDriver driver){								
		element = driver.findElement(By.id("PB_ucContactAndAccessInfo_lbOcc1"));							
		return element;							
	}								
	
	/**
	 * Occupant contact type 1 txt.
	 *
	 * @return the string
	 */
	public static String occupantContactType1_txt(){								
		id = "PB_ucContactAndAccessInfo_lbOcc1";							
		return id;							
	}								
									
	/**
	 * Occupant contact 1 txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// occupantContact1 txt								
	public static WebElement occupantContact1_txt(WebDriver driver){								
		element = driver.findElement(By.id("PB_ucContactAndAccessInfo_lbOccContact1"));							
		return element;							
	}								
	
	/**
	 * Occupant contact 1 txt.
	 *
	 * @return the string
	 */
	public static String occupantContact1_txt(){								
		id = "PB_ucContactAndAccessInfo_lbOccContact1";							
		return id;							
	}								
									
	/**
	 * Sub cur owner txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// subCurOwner txt								
	public static WebElement subCurOwner_txt(WebDriver driver){								
		element = driver.findElement(By.id("PB_ucContactAndAccessInfo_lbOwnerName"));							
		return element;							
	}								
	
	/**
	 * Sub cur owner txt.
	 *
	 * @return the string
	 */
	public static String subCurOwner_txt(){								
		id = "PB_ucContactAndAccessInfo_lbOwnerName";							
		return id;							
	}								
									
	/**
	 * Owner contact type 2 txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// ownerContactType2 txt								
	public static WebElement ownerContactType2_txt(WebDriver driver){								
		element = driver.findElement(By.id("PB_ucContactAndAccessInfo_lbOwner2"));							
		return element;							
	}								
	
	/**
	 * Owner contact type 2 txt.
	 *
	 * @return the string
	 */
	public static String ownerContactType2_txt(){								
		id = "PB_ucContactAndAccessInfo_lbOwner2";							
		return id;							
	}								
									
	/**
	 * Owner contact 2 txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// ownerContact2 txt								
	public static WebElement ownerContact2_txt(WebDriver driver){								
		element = driver.findElement(By.id("PB_ucContactAndAccessInfo_lbOwnerContact2"));							
		return element;							
	}								
	
	/**
	 * Owner contact 2 txt.
	 *
	 * @return the string
	 */
	public static String ownerContact2_txt(){								
		id = "PB_ucContactAndAccessInfo_lbOwnerContact2";							
		return id;							
	}								
									
	/**
	 * Owner contact type 1 txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// ownerContactType1 txt								
	public static WebElement ownerContactType1_txt(WebDriver driver){								
		element = driver.findElement(By.id("PB_ucContactAndAccessInfo_lbOwner1"));							
		return element;							
	}								
	
	/**
	 * Owner contact type 1 txt.
	 *
	 * @return the string
	 */
	public static String ownerContactType1_txt(){								
		id = "PB_ucContactAndAccessInfo_lbOwner1";							
		return id;							
	}								
									
	/**
	 * Owner contact 1 txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// ownerContact1 txt								
	public static WebElement ownerContact1_txt(WebDriver driver){								
		element = driver.findElement(By.id("PB_ucContactAndAccessInfo_lbOwnerContact1"));							
		return element;							
	}								
	
	/**
	 * Owner contact 1 txt.
	 *
	 * @return the string
	 */
	public static String ownerContact1_txt(){								
		id = "PB_ucContactAndAccessInfo_lbOwnerContact1";							
		return id;							
	}								
									
	/**
	 * Sub sale price txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// subSalePrice txt								
	public static WebElement subSalePrice_txt(WebDriver driver){								
		element = driver.findElement(By.id("PB_txtSalePrice"));							
		return element;							
	}								
	
	/**
	 * Sub sale price txt.
	 *
	 * @return the string
	 */
	public static String subSalePrice_txt(){								
		id = "PB_txtSalePrice";							
		return id;							
	}								
									
	/**
	 * Loan amount txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// loanAmount txt								
	public static WebElement loanAmount_txt(WebDriver driver){								
		element = driver.findElement(By.id("PB_txtLoanAmount"));							
		return element;							
	}								
	
	/**
	 * Loan amount txt.
	 *
	 * @return the string
	 */
	public static String loanAmount_txt(){								
		id = "PB_txtLoanAmount";							
		return id;							
	}								
									
	/**
	 * Sub prop address txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// subProperAddress txt								
	public static WebElement subPropAddress_txt(WebDriver driver){								
		element = driver.findElement(By.id("PB_txtAddress"));							
		return element;							
	}								
	
	/**
	 * Sub prop address txt.
	 *
	 * @return the string
	 */
	public static String subPropAddress_txt(){								
		id = "PB_txtAddress";							
		return id;							
	}								
									
	/**
	 * Sub city txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// subCity txt								
	public static WebElement subCity_txt(WebDriver driver){								
		element = driver.findElement(By.id("PB_txtCity"));							
		return element;							
	}								
	
	/**
	 * Sub city txt.
	 *
	 * @return the string
	 */
	public static String subCity_txt(){								
		id = "PB_txtCity";							
		return id;							
	}								
									
	/**
	 * Sub state txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// subState txt								
	public static WebElement subState_txt(WebDriver driver){								
		element = driver.findElement(By.id("PB_txtState"));							
		return element;							
	}								
	
	/**
	 * Sub state txt.
	 *
	 * @return the string
	 */
	public static String subState_txt(){								
		id = "PB_txtState";							
		return id;							
	}								
									
	/**
	 * Sub zip txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// subZip txt								
	public static WebElement subZip_txt(WebDriver driver){								
		element = driver.findElement(By.id("PB_txtZip"));							
		return element;							
	}								
	
	/**
	 * Sub zip txt.
	 *
	 * @return the string
	 */
	public static String subZip_txt(){								
		id = "PB_txtZip";							
		return id;							
	}								
									
	/**
	 * Sub county txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// subCounty txt								
	public static WebElement subCounty_txt(WebDriver driver){								
		element = driver.findElement(By.id("PB_txtCounty"));							
		return element;							
	}								
	
	/**
	 * Sub county txt.
	 *
	 * @return the string
	 */
	public static String subCounty_txt(){								
		id = "PB_txtCounty";							
		return id;							
	}								
									
	/**
	 * Sub legal descrip txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// subLegalDescrip txt								
	public static WebElement subLegalDescrip_txt(WebDriver driver){								
		element = driver.findElement(By.id("PB_txtLegalDescription"));							
		return element;							
	}								
	
	/**
	 * Sub legal descrip txt.
	 *
	 * @return the string
	 */
	public static String subLegalDescrip_txt(){								
		id = "PB_txtLegalDescription";							
		return id;							
	}								
									
	/**
	 * Gds type txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// gdsType txt								
	public static WebElement gdsType_txt(WebDriver driver){								
		element = driver.findElement(By.id("PB_txtPropertyType"));							
		return element;							
	}								
	
	/**
	 * Gds type txt.
	 *
	 * @return the string
	 */
	public static String gdsType_txt(){								
		id = "PB_txtPropertyType";							
		return id;							
	}								
									
	/**
	 * Type of appraisal txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// typeOfAppraisal txt								
	public static WebElement typeOfAppraisal_txt(WebDriver driver){								
		element = driver.findElement(By.id("PB_txtFormType"));							
		return element;							
	}								
	
	/**
	 * Type of appraisal txt.
	 *
	 * @return the string
	 */
	public static String typeOfAppraisal_txt(){								
		id = "PB_txtFormType";							
		return id;							
	}								
									
	/**
	 * Disclosure date txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// disclosureDate txt								
	public static WebElement disclosureDate_txt(WebDriver driver){								
		element = driver.findElement(By.id("PB_lblDisclosureDate"));							
		return element;							
	}								
	
	/**
	 * Disclosure date txt.
	 *
	 * @return the string
	 */
	public static String disclosureDate_txt(){								
		id = "PB_lblDisclosureDate";							
		return id;							
	}								
									
	/**
	 * Request date txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// requestDate txt								
	public static WebElement requestDate_txt(WebDriver driver){								
		element = driver.findElement(By.id("PB_txtOrderDate"));							
		return element;							
	}								
	
	/**
	 * Request date txt.
	 *
	 * @return the string
	 */
	public static String requestDate_txt(){								
		id = "PB_txtOrderDate";							
		return id;							
	}								
									
	/**
	 * Request notes txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// requestNotes txt								
	public static WebElement requestNotes_txt(WebDriver driver){								
		element = driver.findElement(By.id("PB_tdComments"));							
		return element;							
	}								
	
	/**
	 * Request notes txt.
	 *
	 * @return the string
	 */
	public static String requestNotes_txt(){								
		id = "PB_tdComments";							
		return id;							
	}								
									
	/**
	 * Prelim value txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// prelimValue txt								
	public static WebElement prelimValue_txt(WebDriver driver){								
		element = driver.findElement(By.id("PB_txtEstimatedValue"));							
		return element;							
	}								
	
	/**
	 * Prelim value txt.
	 *
	 * @return the string
	 */
	public static String prelimValue_txt(){								
		id = "PB_txtEstimatedValue";							
		return id;							
	}								
									
	/**
	 * Other file number txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// otherFileNumber txt								
	public static WebElement otherFileNumber_txt(WebDriver driver){								
		element = driver.findElement(By.id("PB_txtOtherRef"));							
		return element;							
	}								
	
	/**
	 * Other file number txt.
	 *
	 * @return the string
	 */
	public static String otherFileNumber_txt(){								
		id = "PB_txtOtherRef";							
		return id;							
	}								
									
	/**
	 * Order no txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// orderNumber txt								
	public static WebElement orderNo_txt(WebDriver driver){								
		element = driver.findElement(By.id("PB_lblInternalOrderNumber"));							
		return element;							
	}								
	
	/**
	 * Order no txt.
	 *
	 * @return the string
	 */
	public static String orderNo_txt(){								
		id = "PB_lblInternalOrderNumber";							
		return id;							
	}								
									
	/**
	 * Who ordered per txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// whoOrderedPer txt								
	public static WebElement whoOrderedPer_txt(WebDriver driver){								
		element = driver.findElement(By.id("PB_txtOrderedBy"));							
		return element;							
	}								
	
	/**
	 * Who ordered per txt.
	 *
	 * @return the string
	 */
	public static String whoOrderedPer_txt(){								
		id = "PB_txtOrderedBy";							
		return id;							
	}								
									
	/**
	 * Appt contact txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// apptContact txt								
	public static WebElement apptContact_txt(WebDriver driver){								
		element = driver.findElement(By.id("PB_ucContactAndAccessInfo_lbApptContactName"));							
		return element;							
	}								
	
	/**
	 * Appt contact txt.
	 *
	 * @return the string
	 */
	public static String apptContact_txt(){								
		id = "PB_ucContactAndAccessInfo_lbApptContactName";							
		return id;							
	}								
									
	/**
	 * Rights appraised txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// rightsAppraised txt								
	public static WebElement rightsAppraised_txt(WebDriver driver){								
		element = driver.findElement(By.id("PB_txtPropertyRights"));							
		return element;							
	}								
	
	/**
	 * Rights appraised txt.
	 *
	 * @return the string
	 */
	public static String rightsAppraised_txt(){								
		id = "PB_txtPropertyRights";							
		return id;							
	}								
									
	/**
	 * Occupant type txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// occupantType txt								
	public static WebElement occupantType_txt(WebDriver driver){								
		element = driver.findElement(By.id("PB_txtOccupancy"));							
		return element;							
	}								
	
	/**
	 * Occupant type txt.
	 *
	 * @return the string
	 */
	public static String occupantType_txt(){								
		id = "PB_txtOccupancy";							
		return id;							
	}	
	
	/**
	 * clientGroup_txt
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// occupantType txt								
	public static WebElement clientGroup_txt(WebDriver driver){								
		element = driver.findElement(By.id("PB_lblClientGroup"));							
		return element;							
	}								
	
	/**
	 * clientGroup_txt
	 *
	 * @return the string
	 */
	public static String clientGroup_txt(){								
		id = "PB_lblClientGroup";							
		return id;							
	}	
	
}
