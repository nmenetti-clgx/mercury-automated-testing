package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.StoredVariables;

/**
 * The elements on the Secure Account page
 */
public class SAccount {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	/** The css selector. */
	private static String cssSelector = null;

	
	/**
	 * New card radiobtn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// New Card radio button
	public static WebElement newCard_radiobtn(WebDriver driver){
		element = driver.findElement(By.id("rbNewCard"));
		return element;
	}
	
	/**
	 * New card radiobtn.
	 *
	 * @return the string
	 */
	public static String newCard_radiobtn(){
		id = "rbNewCard";
		return id;
	}
	
	/**
	 * Payment information txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Payment Information text
	public static WebElement paymentInformation_txt(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_ucPaymentMethod_pnlPayment"));
		return element;
	}
	
	/**
	 * Payment information txt.
	 *
	 * @return the string
	 */
	public static String paymentInformation_txt(){
		id = "Main_Main_ucPaymentMethod_pnlPayment";
		return id;
	}
	
	/**
	 * First name txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// First Name text
	public static WebElement firstName_txtbx(WebDriver driver){
			element = driver.findElement(By.id("Main_txtFirstName"));	
		return element;
	}
	
	/**
	 * First name txtbx.
	 *
	 * @return the string
	 */
	public static String firstName_txtbx(){
		id = "Main_txtFirstName";
		return id;
	}
	
	/**
	 * Last name txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Last Name text
	public static WebElement lastName_txtbx(WebDriver driver){
		if (!StoredVariables.getusernameEnvironment().get().equals("Live")) {
			element = driver.findElement(By.id("Main_txtLastName"));	
		} else {
		element = driver.findElement(By.id("Main_txtLastName"));
		}
		return element;
	}
	
	/**
	 * Last name txtbx.
	 *
	 * @return the string
	 */
	public static String lastName_txtbx(){
		if (!StoredVariables.getusernameEnvironment().get().equals("Live")) {
			id = "Main_txtLastName";
		}
		id = "Main_txtLastName";
		return id;
	}
	
	/**
	 * Address txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Address text
	public static WebElement address_txtbx(WebDriver driver){
		if (!StoredVariables.getusernameEnvironment().get().equals("Live")) {
			element = driver.findElement(By.id("Main_txtAddress"));	
		} else {
		element = driver.findElement(By.id("Main_txtAddress"));
		}
		return element;
	}
	
	/**
	 * Address txtbx.
	 *
	 * @return the string
	 */
	public static String address_txtbx(){
		id = "Main_txtAddress";
		return id;
	}
	
	/**
	 * City txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// City text
	public static WebElement city_txtbx(WebDriver driver){
		if (!StoredVariables.getusernameEnvironment().get().equals("Live")) {
			element = driver.findElement(By.id("Main_txtCity"));	
		} else {
		element = driver.findElement(By.id("Main_txtCity"));
		}
		return element;
	}
	
	/**
	 * City txtbx.
	 *
	 * @return the string
	 */
	public static String city_txtbx(){
		id = "Main_txtCity";
		return id;
	}
	
	/**
	 * State dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// State dropdown
	public static WebElement state_dropdown(WebDriver driver){
		if (!StoredVariables.getusernameEnvironment().get().equals("Live")) {
			element = driver.findElement(By.id("Main_ddlState"));	
		} else {
		element = driver.findElement(By.id("Main_ddlState"));
		}
		return element;
	}
	
	/**
	 * State dropdown.
	 *
	 * @return the string
	 */
	public static String state_dropdown(){
		id = "Main_ddlState";
		return id;
	}
	
	/**
	 * Zip txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Zip text
	public static WebElement zip_txtbx(WebDriver driver){
		if (!StoredVariables.getusernameEnvironment().get().equals("Live")) {
			element = driver.findElement(By.id("Main_txtZip"));	
		} else {
		element = driver.findElement(By.id("Main_txtZip"));
		}
		return element;
	}
	
	/**
	 * Zip txtbx.
	 *
	 * @return the string
	 */
	public static String zip_txtbx(){
		id = "Main_txtZip";
		return id;
	}
	
	/**
	 * Email txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Email text
	public static WebElement email_txtbx(WebDriver driver){
		if (!StoredVariables.getusernameEnvironment().get().equals("Live")) {
			element = driver.findElement(By.id("Main_txtEmail"));	
		} else {
		element = driver.findElement(By.id("Main_txtEmail"));
		}
		return element;
	}
	
	/**
	 * Email txtbx.
	 *
	 * @return the string
	 */
	public static String email_txtbx(){
		id = "Main_txtEmail";
		return id;
	}
	
	/**
	 * Visa radiobtn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Visa radio button
	public static WebElement visa_radiobtn(WebDriver driver){
		if (!StoredVariables.getusernameEnvironment().get().equals("Live")) {
			element = driver.findElement(By.id("card_type_001"));	
		} else {
		element = driver.findElement(By.id("card_type_001"));
		}
		return element;
	}
	
	/**
	 * Visa radiobtn.
	 *
	 * @return the string
	 */
	public static String visa_radiobtn(){
		id = "card_type_001";
		return id;
	}
	
	/**
	 * Card number txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Card Number text
	public static WebElement cardNumber_txtbx(WebDriver driver){
		if (!StoredVariables.getusernameEnvironment().get().equals("Live")) {
			element = driver.findElement(By.id("Main_txtCardNumber"));	
		} else {
		element = driver.findElement(By.id("Main_txtCardNumber"));
		}
		return element;
	}
	
	/**
	 * Card number txtbx.
	 *
	 * @return the string
	 */
	public static String cardNumber_txtbx(){
		id = "Main_txtCardNumber";
		return id;
	}
	
	/**
	 * Expiration month dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Expiration Month dropdown
	public static WebElement expirationMonth_dropdown(WebDriver driver){
		if (!StoredVariables.getusernameEnvironment().get().equals("Live")) {
			element = driver.findElement(By.id("Main_ddlExpMonth"));	
		} else {
		element = driver.findElement(By.id("Main_ddlExpMonth"));
		}
		return element;
	}
	
	/**
	 * Expiration month dropdown.
	 *
	 * @return the string
	 */
	public static String expirationMonth_dropdown(){
		id = "Main_ddlExpMonth";
		return id;
	}
	
	/**
	 * Expiration year dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Expiration Year dropdown
	public static WebElement expirationYear_dropdown(WebDriver driver){
		if (!StoredVariables.getusernameEnvironment().get().equals("Live")) {
			element = driver.findElement(By.id("Main_ddlExpYear"));	
		} else {
		element = driver.findElement(By.id("Main_ddlExpYear"));
		}
		return element;
	}
	
	/**
	 * Expiration year dropdown.
	 *
	 * @return the string
	 */
	public static String expirationYear_dropdown(){
		id = "Main_ddlExpYear";
		return id;
	}
	
	/**
	 * Save credit card btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Save credit card button
	public static WebElement saveCreditCard_btn(WebDriver driver){
		if (!StoredVariables.getusernameEnvironment().get().equals("Live")) {
			element = driver.findElement(By.id("Main_btnSave"));	
		} else {
		element = driver.findElement(By.id("Main_btnSave"));
		}
		return element;
	}
	
	/**
	 * Save credit card btn.
	 *
	 * @return the string
	 */
	public static String saveCreditCard_btn(){
		id = "Main_btnSave";
		return id;
	}
	
	/**
	 * Cancel credit card btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Cancel credit card button
	public static WebElement cancelCreditCard_btn(WebDriver driver){
		if (!StoredVariables.getusernameEnvironment().get().equals("Live")) {
			element = driver.findElement(By.id("Main_btnCancel"));	
		} else {
		element = driver.findElement(By.id("Main_btnCancel"));
		}
		return element;
	}
	
	/**
	 * Cancel credit card btn.
	 *
	 * @return the string
	 */
	public static String cancelCreditCard_btn(){
		id = "Main_btnCancel";
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
		element = driver.findElement(By.cssSelector("img[src='/App_Themes/FlatGrayscale/Icons/Save.O.png']"));
		return element;
	}
	
	/**
	 * Save btn.
	 *
	 * @return the string
	 */
	public static String save_btn(){
		cssSelector = "img[src='/App_Themes/FlatGrayscale/Icons/Save.O.png']";
		return cssSelector;
	}
	
	/**
	 * Finish btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Finish button
	public static WebElement finish_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("input[value='Finish']"));
		return element;
	}
	
	/**
	 * Finish btn.
	 *
	 * @return the string
	 */
	public static String finish_btn(){
		cssSelector = "input[value='Finish']";
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
		element = driver.findElement(By.id("sbdmButton1"));
		return element;
	}
	
	/**
	 * Ok btn.
	 *
	 * @return the string
	 */
	public static String ok_btn(){
		id = "sbdmButton1";
		return id;
	}
	
	/**
	 * Alert dialog txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Alert Dialog text
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
	 * Cardholder name txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Card holder Name text
	public static WebElement cardholderName_txt(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_ucPaymentMethod_rptCards_lblCardHolderName_0"));
		return element;
	}
	
	/**
	 * Cardholder name txt.
	 *
	 * @return the string
	 */
	public static String cardholderName_txt(){
		id = "Main_Main_ucPaymentMethod_rptCards_lblCardHolderName_0";
		return id;
	}
	
	/**
	 * Pending transactions btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Pending Transactions button
	public static WebElement pendingTransactions_btn(WebDriver driver){
		element = driver.findElement(By.id("divPH_Pending"));
		return element;
	}
	
	/**
	 * Pending transactions btn.
	 *
	 * @return the string
	 */
	public static String pendingTransactions_btn(){
		id = "divPH_Pending";
		return id;
	}
	
	/**
	 * Unpaid invoices btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Unpaid Invoices button
	public static WebElement unpaidInvoices_btn(WebDriver driver){
		element = driver.findElement(By.id("divPH_UnPaid"));
		return element;
	}
	
	/**
	 * Unpaid invoices btn.
	 *
	 * @return the string
	 */
	public static String unpaidInvoices_btn(){
		id = "divPH_UnPaid";
		return id;
	}
	
	/**
	 * Paid invoices btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Paid Invoices button
	public static WebElement paidInvoices_btn(WebDriver driver){
		element = driver.findElement(By.id("divPH_Paid"));
		return element;
	}
	
	/**
	 * Paid invoices btn.
	 *
	 * @return the string
	 */
	public static String paidInvoices_btn(){
		id = "divPH_Paid";
		return id;
	}
	
	/**
	 * Yearly invoice totals btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Yearly Invoice Totals button
	public static WebElement yearlyInvoiceTotals_btn(WebDriver driver){
		element = driver.findElement(By.id("divPH_YearTotals"));
		return element;
	}
	
	/**
	 * Yearly invoice totals btn.
	 *
	 * @return the string
	 */
	public static String yearlyInvoiceTotals_btn(){
		id = "divPH_YearTotals";
		return id;
	}
	
	/**
	 * Pending transactions table txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Pending Transactions table text
	public static WebElement pendingTransactionsTable_txt(WebDriver driver){
		element = driver.findElement(By.id("divPHC_Pending"));
		return element;
	}
	
	/**
	 * Pending transactions table txt.
	 *
	 * @return the string
	 */
	public static String pendingTransactionsTable_txt(){
		id = "divPHC_Pending";
		return id;
	}
	
	/**
	 * Unpaid invoices table txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Unpaid Invoices table text
	public static WebElement unpaidInvoicesTable_txt(WebDriver driver){
		element = driver.findElement(By.id("divPHC_Unpaid"));
		return element;
	}
	
	/**
	 * Unpaid invoices table txt.
	 *
	 * @return the string
	 */
	public static String unpaidInvoicesTable_txt(){
		id = "divPHC_Unpaid";
		return id;
	}
	
	/**
	 * Paid invoices table txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Paid Invoices table text
	public static WebElement paidInvoicesTable_txt(WebDriver driver){
		element = driver.findElement(By.id("divPHC_Paid"));
		return element;
	}
	
	/**
	 * Paid invoices table txt.
	 *
	 * @return the string
	 */
	public static String paidInvoicesTable_txt(){
		id = "divPHC_Paid";
		return id;
	}
	
	/**
	 * Year invoice totals table txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Year Invoice Totals table text
	public static WebElement yearInvoiceTotalsTable_txt(WebDriver driver){
		element = driver.findElement(By.id("divPHC_YearTotals"));
		return element;
	}
	
	/**
	 * Year invoice totals table txt.
	 *
	 * @return the string
	 */
	public static String yearInvoiceTotalsTable_txt(){
		id = "divPHC_YearTotals";
		return id;
	}
	
	/**
	 * Page txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Page text
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
	
//	/**
//	 * Require strong passwords chkbx.
//	 *
//	 * @param driver the driver
//	 * @return the web element
//	 */
//	// Require strong passwords checkbox
//	public static WebElement requireStrongPasswords_chkbx(WebDriver driver){
//		element = driver.findElement(By.id("chkRequireStrongPassword"));
//		return element;
//	}
//	
//	/**
//	 * Require strong passwords chkbx.
//	 *
//	 * @return the string
//	 */
//	public static String requireStrongPasswords_chkbx(){
//		id = "chkRequireStrongPassword";
//		return id;
//	}
	
	/**
	 * Require password reset chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Require password reset checkbox
	public static WebElement requirePasswordReset_chkbx(WebDriver driver){
		element = driver.findElement(By.id("chkPasswordReset"));
		return element;
	}
	
	/**
	 * Require password reset chkbx.
	 *
	 * @return the string
	 */
	public static String requirePasswordReset_chkbx(){
		id = "chkPasswordReset";
		return id;
	}
	
	/**
	 * Require password reset in number of days dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Require password reset in number of days dropdown
	public static WebElement requirePasswordResetInNumberOfDays_dropdown(WebDriver driver){
		element = driver.findElement(By.id("selPasswordReset"));
		return element;
	}
	
	/**
	 * Require password reset in number of days dropdown.
	 *
	 * @return the string
	 */
	public static String requirePasswordResetInNumberOfDays_dropdown(){
		id = "selPasswordReset";
		return id;
	}
	
	/**
	 * Enable password expiration chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Enable password expiration checkbox
	public static WebElement enablePasswordExpiration_chkbx(WebDriver driver){
		element = driver.findElement(By.id("chkPasswordExpiration"));
		return element;
	}
	
	/**
	 * Enable password expiration chkbx.
	 *
	 * @return the string
	 */
	public static String enablePasswordExpiration_chkbx(){
		id = "chkPasswordExpiration";
		return id;
	}
	
	/**
	 * Passwords expire every number of days dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Passwords expire every number of days dropdown
	public static WebElement passwordsExpireEveryNumberOfDays_dropdown(WebDriver driver){
		element = driver.findElement(By.id("selPasswordExpire"));
		return element;
	}
	
	/**
	 * Passwords expire every number of days dropdown.
	 *
	 * @return the string
	 */
	public static String passwordsExpireEveryNumberOfDays_dropdown(){
		id = "selPasswordExpire";
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
	 * Reset required txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Reset required text
	public static WebElement resetRequired_txt(WebDriver driver){
		element = driver.findElement(By.id("divPasswordResetText"));
		return element;
	}
	
	/**
	 * Reset required txt.
	 *
	 * @return the string
	 */
	public static String resetRequired_txt(){
		id = "divPasswordResetText";
		return id;
	}
	
	/**
	 * Manage btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Manage button
	public static WebElement manage_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_ctl00"));
		return element;
	}
	
	/**
	 * Manage btn.
	 *
	 * @return the string
	 */
	public static String manage_btn(){
		id = "Main_Main_ctl00";
		return id;
	}
	
	/**
	 * Ok manage payment methods btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// OK Manage payment methods button
	public static WebElement okManagePaymentMethods_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_btnClose"));
		return element;
	}
	
	/**
	 * Ok manage payment methods btn.
	 *
	 * @return the string
	 */
	public static String okManagePaymentMethods_btn(){
		id = "Dialogs_Dialogs_btnClose";
		return id;
	}
	
	/**
	 * Payment methods table.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Payment methods table
	public static WebElement paymentMethods_table(WebDriver driver){
		element = driver.findElement(By.id("tblPaymentMethods"));
		return element;
	}
	
	/**
	 * Payment methods table.
	 *
	 * @return the string
	 */
	public static String paymentMethods_table(){
		id = "tblPaymentMethods";
		return id;
	}
	
	/**
	 * Payment methods data.
	 *
	 * @param driver the driver
	 * @param row the row
	 * @param column the column
	 * @return the web element
	 */
	// Payment methods data
	public static WebElement paymentMethods_data(WebDriver driver, String row, String column){
		element = driver.findElement(By.cssSelector("#tblPaymentMethods > tbody > tr:nth-child("+row+") > td:nth-child("+column+")"));
		return element;
	}
	
	/**
	 * Payment methods data.
	 *
	 * @param row the row
	 * @param column the column
	 * @return the string
	 */
	public static String paymentMethods_data(String row, String column){
		cssSelector = "#tblPaymentMethods > tbody > tr:nth-child("+row+") > td:nth-child("+column+")";
		return cssSelector;
	}
	
	/**
	 * Manage payment methods table.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Manage payment methods table
	public static WebElement managePaymentMethods_table(WebDriver driver){
		element = driver.findElement(By.id("tblManagePaymentMethods"));
		return element;
	}
	
	/**
	 * Manage payment methods table.
	 *
	 * @return the string
	 */
	public static String managePaymentMethods_table(){
		id = "tblManagePaymentMethods";
		return id;
	}
	
	/**
	 * Deleted card btn.
	 *
	 * @param driver the driver
	 * @param cardIndex the card index
	 * @return the web element
	 */
	// Delete card button
	public static WebElement deletedCard_btn(WebDriver driver, String cardIndex){
		element = driver.findElement(By.cssSelector("#tblManagePaymentMethods > tbody > tr:nth-child("+cardIndex+") > td:nth-child(5) > a.GridRowDeleteButton"));
		return element;
	}
	
	/**
	 * Delete card btn.
	 *
	 * @param cardIndex the card index
	 * @return the string
	 */
	public static String deleteCard_btn(String cardIndex){
		cssSelector = "#tblManagePaymentMethods > tbody > tr:nth-child("+cardIndex+") > td:nth-child(5) > a.GridRowDeleteButton";
		return cssSelector;
	}
	
	/**
	 * Edits the card btn.
	 *
	 * @param driver the driver
	 * @param cardIndex the card index
	 * @return the web element
	 */
	// Edit card button
	public static WebElement editCard_btn(WebDriver driver, String cardIndex){
		element = driver.findElement(By.cssSelector("#tblManagePaymentMethods > tbody > tr:nth-child("+cardIndex+") > td:nth-child(5) > a.GridRowEditButton"));
		return element;
	}
	
	/**
	 * Edits the card btn.
	 *
	 * @param cardIndex the card index
	 * @return the string
	 */
	public static String editCard_btn(String cardIndex){
		cssSelector = "#tblManagePaymentMethods > tbody > tr:nth-child("+cardIndex+") > td:nth-child(5) > a.GridRowEditButton";
		return cssSelector;
	}
	
	/**
	 * Adds the credit card btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Add credit card button
	public static WebElement addCreditCard_btn(WebDriver driver){
		element = driver.findElement(By.id("lnkAddCreditCard"));
		return element;
	}
	
	/**
	 * Adds the credit card btn.
	 *
	 * @return the string
	 */
	public static String addCreditCard_btn(){
		id = "lnkAddCreditCard";
		return id;
	}
	
	/**
	 * Adds the checking account btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Add checking account button
	public static WebElement addCheckingAccount_btn(WebDriver driver){
		element = driver.findElement(By.id("lnkAddBankAccount"));
		return element;
	}
	
	/**
	 * Adds the checking account btn.
	 *
	 * @return the string
	 */
	public static String addCheckingAccount_btn(){
		id = "lnkAddBankAccount";
		return id;
	}
	
	/**
	 * Name on account txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Name on account ACH textbox
	public static WebElement nameOnAccount_txtbx(WebDriver driver){
		element = driver.findElement(By.id("txtName"));
		return element;
	}
	
	/**
	 * Name on account txtbx.
	 *
	 * @return the string
	 */
	public static String nameOnAccount_txtbx(){
		id = "txtName";
		return id;
	}
	
	/**
	 * Routing number txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Bank routing number ACH textbox
	public static WebElement routingNumber_txtbx(WebDriver driver){
		element = driver.findElement(By.id("txtRoutingNumber"));
		return element;
	}
	
	/**
	 * Routing number txtbx.
	 *
	 * @return the string
	 */
	public static String routingNumber_txtbx(){
		id = "txtRoutingNumber";
		return id;
	}
	
	/**
	 * Account number txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Account number ACH textbox
	public static WebElement accountNumber_txtbx(WebDriver driver){
		element = driver.findElement(By.id("txtAccountNumber"));
		return element;
	}
	
	/**
	 * Account number txtbx.
	 *
	 * @return the string
	 */
	public static String accountNumber_txtbx(){
		id = "txtAccountNumber";
		return id;
	}
	
	/**
	 * Confirm account number txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Confirm account number ACH textbox
	public static WebElement confirmAccountNumber_txtbx(WebDriver driver){
		element = driver.findElement(By.id("txtAccountNumberConfirm"));
		return element;
	}
	
	/**
	 * Confirm account number txtbx.
	 *
	 * @return the string
	 */
	public static String confirmAccountNumber_txtbx(){
		id = "txtAccountNumberConfirm";
		return id;
	}
	
	/**
	 * Business radiobtn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Business ACH radio button
	public static WebElement business_radiobtn(WebDriver driver){
		element = driver.findElement(By.id("optBusiness"));
		return element;
	}
	
	/**
	 * Business radiobtn.
	 *
	 * @return the string
	 */
	public static String business_radiobtn(){
		id = "optBusiness";
		return id;
	}
	
	/**
	 * Personal radiobtn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Personal ACH radio button
	public static WebElement personal_radiobtn(WebDriver driver){
		element = driver.findElement(By.id("optPersonal"));
		return element;
	}
	
	/**
	 * Personal radiobtn.
	 *
	 * @return the string
	 */
	public static String personal_radiobtn(){
		id = "optPersonal";
		return id;
	}
	
	/**
	 * Save AC H btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Save ACH button
	public static WebElement saveACH_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_btnSave"));
		return element;
	}
	
	/**
	 * Save AC H btn.
	 *
	 * @return the string
	 */
	public static String saveACH_btn(){
		id = "Main_btnSave";
		return id;
	}
	
	/**
	 * Cancel AC H btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Cancel ACH button
	public static WebElement cancelACH_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_btnCancel"));
		return element;
	}
	
	/**
	 * Cancel AC H btn.
	 *
	 * @return the string
	 */
	public static String cancelACH_btn(){
		id = "Main_btnCancel";
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
	 * Primary chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Primary checkbox
	public static WebElement primary_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_optPrimary"));
		return element;
	}
	
	/**
	 * Primary chkbx.
	 *
	 * @return the string
	 */
	public static String primary_chkbx(){
		id = "Main_optPrimary";
		return id;
	}
	
	/**
	 * Routing number validation txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Routing number validation text
	public static WebElement routingNumberValidation_txt(WebDriver driver){
		element = driver.findElement(By.id("routingNumberValidation"));
		return element;
	}
	
	/**
	 * Routing number validation txt.
	 *
	 * @return the string
	 */
	public static String routingNumberValidation_txt(){
		id = "routingNumberValidation";
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
		element = driver.findElement(By.id("divMessageOKText"));
		return element;
	}
	
	/**
	 * Message txt.
	 *
	 * @return the string
	 */
	public static String message_txt(){
		id = "divMessageOKText";
		return id;
	}
	
	/**
	 * Billing type txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Billing Type text
	public static WebElement billingType_txt(WebDriver driver){
		element = driver.findElement(By.id("divBillingType"));
		return element;
	}
	
	/**
	 * Billing type txt.
	 *
	 * @return the string
	 */
	public static String billingType_txt(){
		id = "divBillingType";
		return id;
	}
	
}
