package pageObjects.Vendors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Vendors Credit Card page
 */
public class VCreditCard {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	/** The css selector. */
	private static String cssSelector = null;

	
	/**
	 * Search btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Search button
	public static WebElement search_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_btnSearchTransactions"));
		return element;
	}
	
	/**
	 * Search btn.
	 *
	 * @return the string
	 */
	public static String search_btn(){
		id = "Main_Main_btnSearchTransactions";
		return id;
	}
	
	/**
	 * Date range dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// dateRange dropdown							
	public static WebElement dateRange_dropdown(WebDriver driver){							
		element = driver.findElement(By.id("Main_Main_ddlDateRange"));						
		return element;						
	}							
	
	/**
	 * Date range dropdown.
	 *
	 * @return the string
	 */
	public static String dateRange_dropdown(){							
		id = "Main_Main_ddlDateRange";						
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
		element = driver.findElement(By.id("Main_Main_txtStartDate"));						
		return element;						
	}							
	
	/**
	 * Start date txtbx.
	 *
	 * @return the string
	 */
	public static String startDate_txtbx(){							
		id = "Main_Main_txtStartDate";						
		return id;						
	}	
	
	/**
	 * Start date calendar btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Start Date Calendar button							
	public static WebElement startDateCalendar_btn(WebDriver driver){							
		element = driver.findElement(By.cssSelector("img[src='/Images/Calendar.O.png'][onclick='imgCalendar_click('txtStartDate');']"));						
		return element;						
	}							
	
	/**
	 * Start date calendar btn.
	 *
	 * @return the string
	 */
	public static String startDateCalendar_btn(){							
		cssSelector = "img[src='/Images/Calendar.O.png'][onclick='imgCalendar_click('txtStartDate');']";						
		return cssSelector;						
	}
								
	/**
	 * End date txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// endDate txtbx							
	public static WebElement endDate_txtbx(WebDriver driver){							
		element = driver.findElement(By.id("Main_Main_txtEndDate"));						
		return element;						
	}							
	
	/**
	 * End date txtbx.
	 *
	 * @return the string
	 */
	public static String endDate_txtbx(){							
		id = "Main_Main_txtEndDate";						
		return id;						
	}		
	
	/**
	 * End date calendar btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// End Date Calendar button							
	public static WebElement endDateCalendar_btn(WebDriver driver){							
		element = driver.findElement(By.cssSelector("img[src='/Images/Calendar.O.png'][onclick='imgCalendar_click('txtEndDate');']"));						
		return element;						
	}							
	
	/**
	 * End date calendar btn.
	 *
	 * @return the string
	 */
	public static String endDateCalendar_btn(){							
		cssSelector = "img[src='/Images/Calendar.O.png'][onclick='imgCalendar_click('txtEndDate');']";						
		return cssSelector;						
	}
								
	/**
	 * Name txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// name txtbx							
	public static WebElement name_txtbx(WebDriver driver){							
		element = driver.findElement(By.id("Main_Main_txtName"));						
		return element;						
	}							
	
	/**
	 * Name txtbx.
	 *
	 * @return the string
	 */
	public static String name_txtbx(){							
		id = "Main_Main_txtName";						
		return id;						
	}							
								
	/**
	 * Address txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// address txtbx							
	public static WebElement address_txtbx(WebDriver driver){							
		element = driver.findElement(By.id("Main_Main_txtAddress"));						
		return element;						
	}							
	
	/**
	 * Address txtbx.
	 *
	 * @return the string
	 */
	public static String address_txtbx(){							
		id = "Main_Main_txtAddress";						
		return id;						
	}							
								
	/**
	 * City txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// city txtbx							
	public static WebElement city_txtbx(WebDriver driver){							
		element = driver.findElement(By.id("Main_Main_txtCity"));						
		return element;						
	}							
	
	/**
	 * City txtbx.
	 *
	 * @return the string
	 */
	public static String city_txtbx(){							
		id = "Main_Main_txtCity";						
		return id;						
	}							
								
	/**
	 * State txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// state txtbx							
	public static WebElement state_txtbx(WebDriver driver){							
		element = driver.findElement(By.id("Main_Main_txtState"));						
		return element;						
	}							
	
	/**
	 * State txtbx.
	 *
	 * @return the string
	 */
	public static String state_txtbx(){							
		id = "Main_Main_txtState";						
		return id;						
	}							
								
	/**
	 * Last 4 of C C txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// last4OfCC txtbx							
	public static WebElement last4OfCC_txtbx(WebDriver driver){							
		element = driver.findElement(By.id("Main_Main_txt4CC"));						
		return element;						
	}							
	
	/**
	 * Last 4 of C C txtbx.
	 *
	 * @return the string
	 */
	public static String last4OfCC_txtbx(){							
		id = "Main_Main_txt4CC";						
		return id;						
	}							
								
	/**
	 * Trans I D txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// transID txtbx							
	public static WebElement transID_txtbx(WebDriver driver){							
		element = driver.findElement(By.id("Main_Main_txtTransID"));						
		return element;						
	}							
	
	/**
	 * Trans I D txtbx.
	 *
	 * @return the string
	 */
	public static String transID_txtbx(){							
		id = "Main_Main_txtTransID";						
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
		element = driver.findElement(By.id("Main_Main_txtLoanNumber"));						
		return element;						
	}							
	
	/**
	 * Loan number txtbx.
	 *
	 * @return the string
	 */
	public static String loanNumber_txtbx(){							
		id = "Main_Main_txtLoanNumber";						
		return id;						
	}							
								
	/**
	 * Amount from txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// amountFrom txtbx							
	public static WebElement amountFrom_txtbx(WebDriver driver){							
		element = driver.findElement(By.id("Main_Main_txtAmountFrom"));						
		return element;						
	}							
	
	/**
	 * Amount from txtbx.
	 *
	 * @return the string
	 */
	public static String amountFrom_txtbx(){							
		id = "Main_Main_txtAmountFrom";						
		return id;						
	}							
								
	/**
	 * Amount to txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// amountTo txtbx							
	public static WebElement amountTo_txtbx(WebDriver driver){							
		element = driver.findElement(By.id("Main_Main_txtAmountTo"));						
		return element;						
	}							
	
	/**
	 * Amount to txtbx.
	 *
	 * @return the string
	 */
	public static String amountTo_txtbx(){							
		id = "Main_Main_txtAmountTo";						
		return id;						
	}							
								
	/**
	 * Prop addr txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// propAddr txtbx							
	public static WebElement propAddr_txtbx(WebDriver driver){							
		element = driver.findElement(By.id("Main_Main_txtPropAddress"));						
		return element;						
	}							
	
	/**
	 * Prop addr txtbx.
	 *
	 * @return the string
	 */
	public static String propAddr_txtbx(){							
		id = "Main_Main_txtPropAddress";						
		return id;						
	}							
								
	/**
	 * Charge chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// charge chkbx							
	public static WebElement charge_chkbx(WebDriver driver){							
		element = driver.findElement(By.id("Main_Main_cbCharge"));						
		return element;						
	}							
	
	/**
	 * Charge chkbx.
	 *
	 * @return the string
	 */
	public static String charge_chkbx(){							
		id = "Main_Main_cbCharge";						
		return id;						
	}							
								
	/**
	 * Refund chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// refund chkbx							
	public static WebElement refund_chkbx(WebDriver driver){							
		element = driver.findElement(By.id("Main_Main_cbRefund"));						
		return element;						
	}							
	
	/**
	 * Refund chkbx.
	 *
	 * @return the string
	 */
	public static String refund_chkbx(){							
		id = "Main_Main_cbRefund";						
		return id;						
	}							
								
	/**
	 * Chargeback chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// chargeback chkbx							
	public static WebElement chargeback_chkbx(WebDriver driver){							
		element = driver.findElement(By.id("Main_Main_cbChargeback"));						
		return element;						
	}							
	
	/**
	 * Chargeback chkbx.
	 *
	 * @return the string
	 */
	public static String chargeback_chkbx(){							
		id = "Main_Main_cbChargeback";						
		return id;						
	}							
								
	/**
	 * Settled chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// settled chkbx							
	public static WebElement settled_chkbx(WebDriver driver){							
		element = driver.findElement(By.id("Main_Main_cbSettled"));						
		return element;						
	}							
	
	/**
	 * Settled chkbx.
	 *
	 * @return the string
	 */
	public static String settled_chkbx(){							
		id = "Main_Main_cbSettled";						
		return id;						
	}							
								
	/**
	 * Declined chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// declined chkbx							
	public static WebElement declined_chkbx(WebDriver driver){							
		element = driver.findElement(By.id("Main_Main_cbDeclined"));						
		return element;						
	}							
	
	/**
	 * Declined chkbx.
	 *
	 * @return the string
	 */
	public static String declined_chkbx(){							
		id = "Main_Main_cbDeclined";						
		return id;						
	}							
								
	/**
	 * Failed chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// failed chkbx							
	public static WebElement failed_chkbx(WebDriver driver){							
		element = driver.findElement(By.id("Main_Main_cbFailed"));						
		return element;						
	}							
	
	/**
	 * Failed chkbx.
	 *
	 * @return the string
	 */
	public static String failed_chkbx(){							
		id = "Main_Main_cbFailed";						
		return id;						
	}							
								
	/**
	 * Voided chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// voided chkbx							
	public static WebElement voided_chkbx(WebDriver driver){							
		element = driver.findElement(By.id("Main_Main_cbVoid"));						
		return element;						
	}							
	
	/**
	 * Voided chkbx.
	 *
	 * @return the string
	 */
	public static String voided_chkbx(){							
		id = "Main_Main_cbVoid";						
		return id;						
	}
	
	/**
	 * First name txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// firstName txtbx							
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
	// lastName txtbx							
	public static WebElement lastName_txtbx(WebDriver driver){							
		element = driver.findElement(By.id("Main_txtLastName"));						
		return element;						
	}							
	
	/**
	 * Last name txtbx.
	 *
	 * @return the string
	 */
	public static String lastName_txtbx(){							
		id = "Main_txtLastName";						
		return id;						
	}							
								
	/**
	 * Zip code txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// zipCode txtbx							
	public static WebElement zipCode_txtbx(WebDriver driver){							
		element = driver.findElement(By.id("Main_txtZip"));						
		return element;						
	}							
	
	/**
	 * Zip code txtbx.
	 *
	 * @return the string
	 */
	public static String zipCode_txtbx(){							
		id = "Main_txtZip";						
		return id;						
	}							
								
	/**
	 * Credit card number txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// creditCardNumber txtbx							
	public static WebElement creditCardNumber_txtbx(WebDriver driver){							
		element = driver.findElement(By.id("Main_txtCardNumber"));						
		return element;						
	}							
	
	/**
	 * Credit card number txtbx.
	 *
	 * @return the string
	 */
	public static String creditCardNumber_txtbx(){							
		id = "Main_txtCardNumber";						
		return id;						
	}							
								
	/**
	 * Exp month dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// expMonth dropdown							
	public static WebElement expMonth_dropdown(WebDriver driver){							
		element = driver.findElement(By.id("Main_ddlExpMonth"));						
		return element;						
	}							
	
	/**
	 * Exp month dropdown.
	 *
	 * @return the string
	 */
	public static String expMonth_dropdown(){							
		id = "Main_ddlExpMonth";						
		return id;						
	}							
								
	/**
	 * Exp year dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// expYear dropdown							
	public static WebElement expYear_dropdown(WebDriver driver){							
		element = driver.findElement(By.id("Main_ddlExpYear"));						
		return element;						
	}							
	
	/**
	 * Exp year dropdown.
	 *
	 * @return the string
	 */
	public static String expYear_dropdown(){							
		id = "Main_ddlExpYear";						
		return id;						
	}							
								
	/**
	 * Amount txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// amount txtbx							
	public static WebElement amount_txtbx(WebDriver driver){							
		element = driver.findElement(By.id("Main_txtAmount"));						
		return element;						
	}							
	
	/**
	 * Amount txtbx.
	 *
	 * @return the string
	 */
	public static String amount_txtbx(){							
		id = "Main_txtAmount";						
		return id;						
	}							
								
	/**
	 * Email address txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// emailAddress txtbx							
	public static WebElement emailAddress_txtbx(WebDriver driver){							
		element = driver.findElement(By.id("Main_txtEmail"));						
		return element;						
	}							
	
	/**
	 * Email address txtbx.
	 *
	 * @return the string
	 */
	public static String emailAddress_txtbx(){							
		id = "Main_txtEmail";						
		return id;						
	}							
								
	/**
	 * Email receipt chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// emailReceipt chkbx							
	public static WebElement emailReceipt_chkbx(WebDriver driver){							
		element = driver.findElement(By.id("Main_chkEmailInvoice"));						
		return element;						
	}							
	
	/**
	 * Email receipt chkbx.
	 *
	 * @return the string
	 */
	public static String emailReceipt_chkbx(){							
		id = "Main_chkEmailInvoice";						
		return id;						
	}							
								
	/**
	 * Notes txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// notes txtbx							
	public static WebElement notes_txtbx(WebDriver driver){							
		element = driver.findElement(By.id("Main_txtNotes"));						
		return element;						
	}							
	
	/**
	 * Notes txtbx.
	 *
	 * @return the string
	 */
	public static String notes_txtbx(){							
		id = "Main_txtNotes";						
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
		element = driver.findElement(By.id("Main_btnCancel"));						
		return element;						
	}							
	
	/**
	 * Cancel btn.
	 *
	 * @return the string
	 */
	public static String cancel_btn(){							
		id = "Main_btnCancel";						
		return id;						
	}							
								
	/**
	 * Charge card btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// chargeCard btn							
	public static WebElement chargeCard_btn(WebDriver driver){							
		element = driver.findElement(By.id("Main_btnSave"));						
		return element;						
	}							
	
	/**
	 * Charge card btn.
	 *
	 * @return the string
	 */
	public static String chargeCard_btn(){							
		id = "Main_btnSave";						
		return id;						
	}	
	
	/**
	 * Transaction table txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// transaction table text							
	public static WebElement transactionTable_txt(WebDriver driver){							
		element = driver.findElement(By.id("tblGridTransactions"));						
		return element;						
	}							
	
	/**
	 * Transaction table txt.
	 *
	 * @return the string
	 */
	public static String transactionTable_txt(){							
		id = "tblGridTransactions";						
		return id;						
	}	
	
	/**
	 * Transaction table first row txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// transaction table first row text							
	public static WebElement transactionTableFirstRow_txt(WebDriver driver){							
		element = driver.findElement(By.cssSelector("#tblGridTransactions > tbody > tr"));						
		return element;						
	}							
	
	/**
	 * Transaction table first row txt.
	 *
	 * @return the string
	 */
	public static String transactionTableFirstRow_txt(){							
		cssSelector = "#tblGridTransactions > tbody > tr";						
		return cssSelector;						
	}	
	
}
