package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure Payments page
 */
public class SPayments {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	/** The css selector. */
	private static String cssSelector = null;
	
	
	/**
	 * Date range dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Date range dropdown
	public static WebElement dateRange_dropdown(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_DropDownOrderDateRanges"));
		return element;
	}
	
	/**
	 * Date range dropdown.
	 *
	 * @return the string
	 */
	public static String dateRange_dropdown(){
		id = "Main_Main_DropDownOrderDateRanges";
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
	 * Loan number txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// loanNumber txtbx					
	public static WebElement loanNumber_txtbx(WebDriver driver){					
		element = driver.findElement(By.id("Main_Main_OrderLoanNumber"));				
		return element;				
	}					
	
	/**
	 * Loan number txtbx.
	 *
	 * @return the string
	 */
	public static String loanNumber_txtbx(){					
		id = "Main_Main_OrderLoanNumber";				
		return id;				
	}					
						
	/**
	 * Invoice number txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// invoiceNumber txtbx					
	public static WebElement invoiceNumber_txtbx(WebDriver driver){					
		element = driver.findElement(By.id("Main_Main_OrderInvoiceNumber"));				
		return element;				
	}					
	
	/**
	 * Invoice number txtbx.
	 *
	 * @return the string
	 */
	public static String invoiceNumber_txtbx(){					
		id = "Main_Main_OrderInvoiceNumber";				
		return id;				
	}					
						
	/**
	 * Start date txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// startDate txtbx					
	public static WebElement startDate_txtbx(WebDriver driver){					
		element = driver.findElement(By.id("Main_Main_OrderStartDate"));				
		return element;				
	}					
	
	/**
	 * Start date txtbx.
	 *
	 * @return the string
	 */
	public static String startDate_txtbx(){					
		id = "Main_Main_OrderStartDate";				
		return id;				
	}					
						
	/**
	 * End date txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// EndDate txtbx					
	public static WebElement EndDate_txtbx(WebDriver driver){					
		element = driver.findElement(By.id("Main_Main_OrderEndDate"));				
		return element;				
	}					
	
	/**
	 * End date txtbx.
	 *
	 * @return the string
	 */
	public static String EndDate_txtbx(){					
		id = "Main_Main_OrderEndDate";				
		return id;				
	}					
						
	/**
	 * Client txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// client txtbx					
	public static WebElement client_txtbx(WebDriver driver){					
		element = driver.findElement(By.id("Main_Main_OrderClient"));				
		return element;				
	}					
	
	/**
	 * Client txtbx.
	 *
	 * @return the string
	 */
	public static String client_txtbx(){					
		id = "Main_Main_OrderClient";				
		return id;				
	}					
						
	/**
	 * Borrower txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// borrower txtbx					
	public static WebElement borrower_txtbx(WebDriver driver){					
		element = driver.findElement(By.id("Main_Main_OrderBorrower"));				
		return element;				
	}					
	
	/**
	 * Borrower txtbx.
	 *
	 * @return the string
	 */
	public static String borrower_txtbx(){					
		id = "Main_Main_OrderBorrower";				
		return id;				
	}					
						
	/**
	 * Vendor txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// vendor txtbx					
	public static WebElement vendor_txtbx(WebDriver driver){					
		element = driver.findElement(By.id("Main_Main_OrderVendor"));				
		return element;				
	}					
	
	/**
	 * Vendor txtbx.
	 *
	 * @return the string
	 */
	public static String vendor_txtbx(){					
		id = "Main_Main_OrderVendor";				
		return id;				
	}					
						
	/**
	 * Property address txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// propertyAddress txtbx					
	public static WebElement propertyAddress_txtbx(WebDriver driver){					
		element = driver.findElement(By.id("Main_Main_OrderPropertyAddress"));				
		return element;				
	}					
	
	/**
	 * Property address txtbx.
	 *
	 * @return the string
	 */
	public static String propertyAddress_txtbx(){					
		id = "Main_Main_OrderPropertyAddress";				
		return id;				
	}					
						
	/**
	 * Received chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// received chkbx					
	public static WebElement received_chkbx(WebDriver driver){					
		element = driver.findElement(By.id("Main_Main_OrderReceived"));				
		return element;				
	}					
	
	/**
	 * Received chkbx.
	 *
	 * @return the string
	 */
	public static String received_chkbx(){					
		id = "Main_Main_OrderReceived";				
		return id;				
	}					
						
	/**
	 * Outstanding chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// outstanding chkbx					
	public static WebElement outstanding_chkbx(WebDriver driver){					
		element = driver.findElement(By.id("Main_Main_OrderOutstanding"));				
		return element;				
	}					
	
	/**
	 * Outstanding chkbx.
	 *
	 * @return the string
	 */
	public static String outstanding_chkbx(){					
		id = "Main_Main_OrderOutstanding";				
		return id;				
	}					
						
	/**
	 * Paid chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// paid chkbx					
	public static WebElement paid_chkbx(WebDriver driver){					
		element = driver.findElement(By.id("Main_Main_OrderPaid"));				
		return element;				
	}					
	
	/**
	 * Paid chkbx.
	 *
	 * @return the string
	 */
	public static String paid_chkbx(){					
		id = "Main_Main_OrderPaid";				
		return id;				
	}					
						
	/**
	 * Unpaid chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// unpaid chkbx					
	public static WebElement unpaid_chkbx(WebDriver driver){					
		element = driver.findElement(By.id("Main_Main_OrderUnpaid"));				
		return element;				
	}					
	
	/**
	 * Unpaid chkbx.
	 *
	 * @return the string
	 */
	public static String unpaid_chkbx(){					
		id = "Main_Main_OrderUnpaid";				
		return id;				
	}					
						
	/**
	 * Search btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// search btn					
	public static WebElement search_btn(WebDriver driver){					
		element = driver.findElement(By.cssSelector("input[type='submit'][value='Search'][onclick='AccountingOrderSummary.SearchOrders();']"));				
		return element;				
	}					
	
	/**
	 * Search btn.
	 *
	 * @return the string
	 */
	public static String search_btn(){					
		cssSelector = "input[type='submit'][value='Search'][onclick='AccountingOrderSummary.SearchOrders();']";				
		return cssSelector;				
	}					
						
	/**
	 * Order summary btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// orderSummary btn					
	public static WebElement orderSummary_btn(WebDriver driver){					
		element = driver.findElement(By.id("tabOrderSummary"));				
		return element;				
	}					
	
	/**
	 * Order summary btn.
	 *
	 * @return the string
	 */
	public static String orderSummary_btn(){					
		id = "tabOrderSummary";				
		return id;				
	}					
						
	/**
	 * Invoices btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// invoices btn					
	public static WebElement invoices_btn(WebDriver driver){					
		element = driver.findElement(By.id("tabInvoices"));				
		return element;				
	}					
	
	/**
	 * Invoices btn.
	 *
	 * @return the string
	 */
	public static String invoices_btn(){					
		id = "tabInvoices";				
		return id;				
	}					
						
	/**
	 * Transactions btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// transactions btn					
	public static WebElement transactions_btn(WebDriver driver){					
		element = driver.findElement(By.id("tabTransactions"));				
		return element;				
	}					
	
	/**
	 * Transactions btn.
	 *
	 * @return the string
	 */
	public static String transactions_btn(){					
		id = "tabTransactions";				
		return id;				
	}					

	/**
	 * Processor dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// processor dropdown			
	public static WebElement processor_dropdown(WebDriver driver){					
		element = driver.findElement(By.id("processor"));				
		return element;				
	}					
	
	/**
	 * Processor dropdown.
	 *
	 * @return the string
	 */
	public static String processor_dropdown(){					
		id = "processor";				
		return id;				
	}		
	
	/**
	 * Visa chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// visa chkbx		
	public static WebElement visa_chkbx(WebDriver driver){		
		element = driver.findElement(By.id("cc_type_visa"));	
		return element;	
	}		
	
	/**
	 * Visa chkbx.
	 *
	 * @return the string
	 */
	public static String visa_chkbx(){		
		id = "cc_type_visa";	
		return id;	
	}		
			
	/**
	 * Mastercard chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// mastercard chkbx		
	public static WebElement mastercard_chkbx(WebDriver driver){		
		element = driver.findElement(By.id("cc_type_mastercard"));	
		return element;	
	}		
	
	/**
	 * Mastercard chkbx.
	 *
	 * @return the string
	 */
	public static String mastercard_chkbx(){		
		id = "cc_type_mastercard";	
		return id;	
	}		
			
	/**
	 * Amex chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// amex chkbx		
	public static WebElement amex_chkbx(WebDriver driver){		
		element = driver.findElement(By.id("cc_type_amex"));	
		return element;	
	}		
	
	/**
	 * Amex chkbx.
	 *
	 * @return the string
	 */
	public static String amex_chkbx(){		
		id = "cc_type_amex";	
		return id;	
	}		
			
	/**
	 * Discover chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// discover chkbx		
	public static WebElement discover_chkbx(WebDriver driver){		
		element = driver.findElement(By.id("cc_type_discover"));	
		return element;	
	}		
	
	/**
	 * Discover chkbx.
	 *
	 * @return the string
	 */
	public static String discover_chkbx(){		
		id = "cc_type_discover";	
		return id;	
	}		
			
	/**
	 * Cancel btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// cancel btn		
	public static WebElement cancel_btn(WebDriver driver){		
		element = driver.findElement(By.id("Main_btnMerchantAccountCancel"));	
		return element;	
	}		
	
	/**
	 * Cancel btn.
	 *
	 * @return the string
	 */
	public static String cancel_btn(){		
		id = "Main_btnMerchantAccountCancel";	
		return id;	
	}		
			
	/**
	 * Submit btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// submit btn		
	public static WebElement submit_btn(WebDriver driver){		
		element = driver.findElement(By.id("Main_btnMerchantAccountSave"));	
		return element;	
	}		
	
	/**
	 * Submit btn.
	 *
	 * @return the string
	 */
	public static String submit_btn(){		
		id = "Main_btnMerchantAccountSave";	
		return id;	
	}
	
	/**
	 * Merchant number txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// merchantNumber txtbx		
	public static WebElement merchantNumber_txtbx(WebDriver driver){		
		element = driver.findElement(By.id("gpe_merchant_number"));	
		return element;	
	}		
	
	/**
	 * Merchant number txtbx.
	 *
	 * @return the string
	 */
	public static String merchantNumber_txtbx(){		
		id = "gpe_merchant_number";	
		return id;	
	}		
			
	/**
	 * Acquirer bin txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// acquirerBin txtbx		
	public static WebElement acquirerBin_txtbx(WebDriver driver){		
		element = driver.findElement(By.id("gpe_acquirer_bin"));	
		return element;	
	}		
	
	/**
	 * Acquirer bin txtbx.
	 *
	 * @return the string
	 */
	public static String acquirerBin_txtbx(){		
		id = "gpe_acquirer_bin";	
		return id;	
	}		
			
	/**
	 * Contact name txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// contactName txtbx		
	public static WebElement contactName_txtbx(WebDriver driver){		
		element = driver.findElement(By.id("gpe_contact_name"));	
		return element;	
	}		
	
	/**
	 * Contact name txtbx.
	 *
	 * @return the string
	 */
	public static String contactName_txtbx(){		
		id = "gpe_contact_name";	
		return id;	
	}		
			
	/**
	 * Email txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// email txtbx		
	public static WebElement email_txtbx(WebDriver driver){		
		element = driver.findElement(By.id("gpe_email"));	
		return element;	
	}		
	
	/**
	 * Email txtbx.
	 *
	 * @return the string
	 */
	public static String email_txtbx(){		
		id = "gpe_email";	
		return id;	
	}		
	
	/**
	 * Yes btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// yes button
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
	 * Information updated txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Information updated text
	public static WebElement informationUpdated_txt(WebDriver driver){		
		element = driver.findElement(By.id("divMessageOKText"));	
		return element;	
	}		
	
	/**
	 * Information updated txt.
	 *
	 * @return the string
	 */
	public static String informationUpdated_txt(){		
		id = "divMessageOKText";	
		return id;	
	}
	
	/**
	 * Transaction page txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// transaction page text
	public static WebElement transactionPage_txt(WebDriver driver){		
		element = driver.findElement(By.id("divTransactionContainer"));	
		return element;	
	}		
	
	/**
	 * Transaction page txt.
	 *
	 * @return the string
	 */
	public static String transactionPage_txt(){		
		id = "divTransactionContainer";	
		return id;	
	}
	
	/**
	 * Grid txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// grid text
	public static WebElement grid_txt(WebDriver driver){		
		element = driver.findElement(By.id("tblGridOrders"));	
		return element;	
	}		
	
	/**
	 * Grid txt.
	 *
	 * @return the string
	 */
	public static String grid_txt(){		
		id = "tblGridOrders";	
		return id;	
	}
	
	/**
	 * Grid header txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// grid header text
	public static WebElement gridHeader_txt(WebDriver driver){		
		element = driver.findElement(By.id("tblGridOrders_headers"));	
		return element;	
	}		
	
	/**
	 * Grid header txt.
	 *
	 * @return the string
	 */
	public static String gridHeader_txt(){		
		id = "tblGridOrders_headers";	
		return id;	
	}
	
	/**
	 * Balance txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// balance text
	public static WebElement balance_txt(WebDriver driver){		
		element = driver.findElement(By.id("Main_Main_Balance"));	
		return element;	
	}		
	
	/**
	 * Balance txt.
	 *
	 * @return the string
	 */
	public static String balance_txt(){		
		id = "Main_Main_Balance";	
		return id;	
	}
	
	/**
	 * Loan number invoices txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Invoices loanNumber txtbx					
	public static WebElement loanNumberInvoices_txtbx(WebDriver driver){					
		element = driver.findElement(By.id("Main_Main_InvoiceLoanNumber"));				
		return element;				
	}					
	
	/**
	 * Loan number invoices txtbx.
	 *
	 * @return the string
	 */
	public static String loanNumberInvoices_txtbx(){					
		id = "Main_Main_InvoiceLoanNumber";				
		return id;				
	}
	
	/**
	 * Search invoices btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Invoices search btn					
	public static WebElement searchInvoices_btn(WebDriver driver){					
		element = driver.findElement(By.cssSelector("input[type='submit'][value='Search'][onclick='AccountingInvoices.SearchInvoices();']"));				
		return element;				
	}					
	
	/**
	 * Search invoices btn.
	 *
	 * @return the string
	 */
	public static String searchInvoices_btn(){					
		cssSelector = "input[type='submit'][value='Search'][onclick='AccountingInvoices.SearchInvoices();']";				
		return cssSelector;				
	}
	
	/**
	 * Grid invoices txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Invoices grid text
	public static WebElement gridInvoices_txt(WebDriver driver){		
		element = driver.findElement(By.id("tblGridInvoices"));	
		return element;	
	}		
	
	/**
	 * Grid invoices txt.
	 *
	 * @return the string
	 */
	public static String gridInvoices_txt(){		
		id = "tblGridInvoices";	
		return id;	
	}
	
	/**
	 * Loan number transactions txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Loan Number Transactions textbox
	public static WebElement loanNumberTransactions_txtbx(WebDriver driver){		
		element = driver.findElement(By.id("Main_Main_txtLoanNumber"));	
		return element;	
	}		
	
	/**
	 * Loan number transactions txtbx.
	 *
	 * @return the string
	 */
	public static String loanNumberTransactions_txtbx(){		
		id = "Main_Main_txtLoanNumber";	
		return id;	
	}
	
	/**
	 * Search transactions btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Search Transactions button
	public static WebElement searchTransactions_btn(WebDriver driver){		
		element = driver.findElement(By.cssSelector("input[type='submit'][value='Search'][onclick='AccountingTransactions.searchTransactions();']"));	
		return element;	
	}		
	
	/**
	 * Search transactions btn.
	 *
	 * @return the string
	 */
	public static String searchTransactions_btn(){		
		cssSelector = "input[type='submit'][value='Search'][onclick='AccountingTransactions.searchTransactions();']";	
		return cssSelector;	
	}
	
	/**
	 * Grid transactions txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// grid Transactions text
	public static WebElement gridTransactions_txt(WebDriver driver){		
		element = driver.findElement(By.id("tblGridTransactions_scroll"));	
		return element;	
	}		
	
	/**
	 * Grid transactions txt.
	 *
	 * @return the string
	 */
	public static String gridTransactions_txt(){		
		id = "tblGridTransactions_scroll";	
		return id;	
	}
	
}
