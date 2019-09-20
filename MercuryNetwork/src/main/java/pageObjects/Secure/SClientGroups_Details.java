package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure Client Group Details page
 */
public class SClientGroups_Details {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;

	
	/**
	 * Group name txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// groupName txtbx	
	public static WebElement groupName_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("Main_txtGroupName"));
		return element;
	}	
	
	/**
	 * Group name txtbx.
	 *
	 * @return the string
	 */
	public static String groupName_txtbx(){	
		id = "Main_txtGroupName";
		return id;
	}	
		
	/**
	 * Company txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// company txtbx	
	public static WebElement company_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("Main_txtCompany"));
		return element;
	}	
	
	/**
	 * Company txtbx.
	 *
	 * @return the string
	 */
	public static String company_txtbx(){	
		id = "Main_txtCompany";
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
		element = driver.findElement(By.id("Main_txtAddress"));
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
	// city txtbx	
	public static WebElement city_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("Main_txtCity"));
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
	// state dropdown	
	public static WebElement state_dropdown(WebDriver driver){	
		element = driver.findElement(By.id("Main_ddlState"));
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
	// zip txtbx	
	public static WebElement zip_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("Main_txtZip"));
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
	 * Use this lender information automatically chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// useThisLenderInformationAutomatically chkbx	
	public static WebElement useThisLenderInformationAutomatically_chkbx(WebDriver driver){	
		element = driver.findElement(By.id("Main_chkAutoPopulate"));
		return element;
	}	
	
	/**
	 * Use this lender information automatically chkbx.
	 *
	 * @return the string
	 */
	public static String useThisLenderInformationAutomatically_chkbx(){	
		id = "Main_chkAutoPopulate";
		return id;
	}	
		
	/**
	 * Report group txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// reportGroup txtbx	
	public static WebElement reportGroup_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("Main_txtReportGroup"));
		return element;
	}	
	
	/**
	 * Report group txtbx.
	 *
	 * @return the string
	 */
	public static String reportGroup_txtbx(){	
		id = "Main_txtReportGroup";
		return id;
	}	
		
	/**
	 * Order routing dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// orderRouting dropdown	
	public static WebElement orderRouting_dropdown(WebDriver driver){	
		element = driver.findElement(By.id("Main_ddlRoutingGroup"));
		return element;
	}	
	
	/**
	 * Order routing dropdown.
	 *
	 * @return the string
	 */
	public static String orderRouting_dropdown(){	
		id = "Main_ddlRoutingGroup";
		return id;
	}	
		
	/**
	 * Fee table dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// feeTable dropdown	
	public static WebElement feeTable_dropdown(WebDriver driver){	
		element = driver.findElement(By.id("Main_ddlFeeTable"));
		return element;
	}	
	
	/**
	 * Fee table dropdown.
	 *
	 * @return the string
	 */
	public static String feeTable_dropdown(){	
		id = "Main_ddlFeeTable";
		return id;
	}	
		
	/**
	 * Allow clients to enter fee chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// allowClientsToEnterFee chkbx	
	public static WebElement allowClientsToEnterFee_chkbx(WebDriver driver){	
		element = driver.findElement(By.id("Main_chkClientEnterFee"));
		return element;
	}	
	
	/**
	 * Allow clients to enter fee chkbx.
	 *
	 * @return the string
	 */
	public static String allowClientsToEnterFee_chkbx(){	
		id = "Main_chkClientEnterFee";
		return id;
	}	
		
	/**
	 * Allow clients to select AM C chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// allowClientsToSelectAMC chkbx	
	public static WebElement allowClientsToSelectAMC_chkbx(WebDriver driver){	
		element = driver.findElement(By.id("Main_chkAllowClientsToSelectAMC"));
		return element;
	}	
	
	/**
	 * Allow clients to select AM C chkbx.
	 *
	 * @return the string
	 */
	public static String allowClientsToSelectAMC_chkbx(){	
		id = "Main_chkAllowClientsToSelectAMC";
		return id;
	}	
		
	/**
	 * Ach chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// ach chkbx	
	public static WebElement ach_chkbx(WebDriver driver){	
		element = driver.findElement(By.id("Main_cblPaymentMethods_Group_0"));
		return element;
	}	
	
	/**
	 * Ach chkbx.
	 *
	 * @return the string
	 */
	public static String ach_chkbx(){	
		id = "Main_cblPaymentMethods_Group_0";
		return id;
	}	
		
	/**
	 * Cc to vendor chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// ccToVendor chkbx	
	public static WebElement ccToVendor_chkbx(WebDriver driver){	
		element = driver.findElement(By.id("Main_cblPaymentMethods_Group_3"));
		return element;
	}	
	
	/**
	 * Cc to vendor chkbx.
	 *
	 * @return the string
	 */
	public static String ccToVendor_chkbx(){	
		id = "Main_cblPaymentMethods_Group_3";
		return id;
	}	
		
	/**
	 * Money order chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// moneyOrder chkbx	
	public static WebElement moneyOrder_chkbx(WebDriver driver){	
		element = driver.findElement(By.id("Main_cblPaymentMethods_Group_6"));
		return element;
	}	
	
	/**
	 * Money order chkbx.
	 *
	 * @return the string
	 */
	public static String moneyOrder_chkbx(){	
		id = "Main_cblPaymentMethods_Group_6";
		return id;
	}	
		
	/**
	 * Cod chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// cod chkbx	
	public static WebElement cod_chkbx(WebDriver driver){	
		element = driver.findElement(By.id("Main_cblPaymentMethods_Group_1"));
		return element;
	}	
	
	/**
	 * Cod chkbx.
	 *
	 * @return the string
	 */
	public static String cod_chkbx(){	
		id = "Main_cblPaymentMethods_Group_1";
		return id;
	}	
		
	/**
	 * Deferred C C chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// deferredCC chkbx	
	public static WebElement deferredCC_chkbx(WebDriver driver){	
		element = driver.findElement(By.id("Main_cblPaymentMethods_Group_4"));
		return element;
	}	
	
	/**
	 * Deferred C C chkbx.
	 *
	 * @return the string
	 */
	public static String deferredCC_chkbx(){	
		id = "Main_cblPaymentMethods_Group_4";
		return id;
	}	
		
	/**
	 * Net 30 chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// net30 chkbx	
	public static WebElement net30_chkbx(WebDriver driver){	
		element = driver.findElement(By.id("Main_cblPaymentMethods_Group_7"));
		return element;
	}	
	
	/**
	 * Net 30 chkbx.
	 *
	 * @return the string
	 */
	public static String net30_chkbx(){	
		id = "Main_cblPaymentMethods_Group_7";
		return id;
	}	
		
	/**
	 * Check chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// check chkbx	
	public static WebElement check_chkbx(WebDriver driver){	
		element = driver.findElement(By.id("Main_cblPaymentMethods_Group_2"));
		return element;
	}	
	
	/**
	 * Check chkbx.
	 *
	 * @return the string
	 */
	public static String check_chkbx(){	
		id = "Main_cblPaymentMethods_Group_2";
		return id;
	}	
		
	/**
	 * Invoice chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// invoice chkbx	
	public static WebElement invoice_chkbx(WebDriver driver){	
		element = driver.findElement(By.id("Main_cblPaymentMethods_Group_5"));
		return element;
	}	
	
	/**
	 * Invoice chkbx.
	 *
	 * @return the string
	 */
	public static String invoice_chkbx(){	
		id = "Main_cblPaymentMethods_Group_5";
		return id;
	}	
		
	/**
	 * Paypal chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// paypal chkbx	
	public static WebElement paypal_chkbx(WebDriver driver){	
		element = driver.findElement(By.id("Main_cblPaymentMethods_Group_8"));
		return element;
	}	
	
	/**
	 * Paypal chkbx.
	 *
	 * @return the string
	 */
	public static String paypal_chkbx(){	
		id = "Main_cblPaymentMethods_Group_8";
		return id;
	}	
	
	/**
	 * Assign all orders for this client group to an AMC firm chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Assign all orders for this client group to an AMC/Firm checkbox
	public static WebElement assignAllOrdersForThisClientGroupToAnAMCFirm_chkbx(WebDriver driver){	
		element = driver.findElement(By.id("Main_chkAssignToAMC"));
		return element;
	}	
	
	/**
	 * Assign all orders for this client group to an AMC firm chkbx.
	 *
	 * @return the string
	 */
	public static String assignAllOrdersForThisClientGroupToAnAMCFirm_chkbx(){	
		id = "Main_chkAssignToAMC";
		return id;
	}
	
	/**
	 * Enable unattended assignment mode chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Enable Unattended Assignment Mode checkbox
	public static WebElement enableUnattendedAssignmentMode_chkbx(WebDriver driver){	
		element = driver.findElement(By.id("Main_cbEnable_UAM"));
		return element;
	}	
	
	/**
	 * Enable unattended assignment mode chkbx.
	 *
	 * @return the string
	 */
	public static String enableUnattendedAssignmentMode_chkbx(){	
		id = "Main_cbEnable_UAM";
		return id;
	}
	
	/**
	 * Enable automatic order reassignment chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Enable Automatic Order Reassignment checkbox
	public static WebElement enableAutomaticOrderReassignment_chkbx(WebDriver driver){	
		element = driver.findElement(By.id("Main_cbEnable_AOR"));
		return element;
	}	
	
	/**
	 * Enable automatic order reassignment chkbx.
	 *
	 * @return the string
	 */
	public static String enableAutomaticOrderReassignment_chkbx(){	
		id = "Main_cbEnable_AOR";
		return id;
	}
	
	/**
	 * Stop and notify me after attempts chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Stop and notify me after attempts checkbox
	public static WebElement stopAndNotifyMeAfterAttempts_chkbx(WebDriver driver){	
		element = driver.findElement(By.id("Main_chkReassignLimit"));
		return element;
	}	
	
	/**
	 * Stop and notify me after attempts chkbx.
	 *
	 * @return the string
	 */
	public static String stopAndNotifyMeAfterAttempts_chkbx(){	
		id = "Main_chkReassignLimit";
		return id;
	}
	
	/**
	 * Use when assigning orders dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// useWhenAssigningOrders dropdown	
	public static WebElement useWhenAssigningOrders_dropdown(WebDriver driver){	
		element = driver.findElement(By.id("Main_ddlVendorFeeOptions"));
		return element;
	}	
	
	/**
	 * Use when assigning orders dropdown.
	 *
	 * @return the string
	 */
	public static String useWhenAssigningOrders_dropdown(){	
		id = "Main_ddlVendorFeeOptions";
		return id;
	}
	
	/**
	 * Use vendor override fee whenever possible chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// useVendorOverrideFeeWheneverPossible chkbx	
	public static WebElement useVendorOverrideFeeWheneverPossible_chkbx(WebDriver driver){	
		element = driver.findElement(By.id("Main_cbEnable_UseVendorOverride"));
		return element;
	}	
	
	/**
	 * Use vendor override fee whenever possible chkbx.
	 *
	 * @return the string
	 */
	public static String useVendorOverrideFeeWheneverPossible_chkbx(){	
		id = "Main_cbEnable_UseVendorOverride";
		return id;
	}	
	
	/**
	 * Always use the new vendors published fee chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// alwaysUseTheNewVendorsPublishedFee chkbx	
	public static WebElement alwaysUseTheNewVendorsPublishedFee_chkbx(WebDriver driver){	
		element = driver.findElement(By.id("Main_cbEnable_AlwaysUseNewVendorFeeReassign"));
		return element;
	}	
	
	/**
	 * Always use the new vendors published fee chkbx.
	 *
	 * @return the string
	 */
	public static String alwaysUseTheNewVendorsPublishedFee_chkbx(){	
		id = "Main_cbEnable_AlwaysUseNewVendorFeeReassign";
		return id;
	}	
	
	/**
	 * Sets the the payment method to dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// setThePaymentMethodTo dropdown	
	public static WebElement setThePaymentMethodTo_dropdown(WebDriver driver){	
		element = driver.findElement(By.id("Main_ddlDefaultPaymentMethod"));
		return element;
	}	
	
	/**
	 * Sets the the payment method to dropdown.
	 *
	 * @return the string
	 */
	public static String setThePaymentMethodTo_dropdown(){	
		id = "Main_ddlDefaultPaymentMethod";
		return id;
	}
	
	/**
	 * Do not pass VMP comments chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Do not pass VMP Comments checkbox	
	public static WebElement doNotPassVMPComments_chkbx(WebDriver driver){	
		element = driver.findElement(By.id("Main_cbEnable_VMPComment_DoNotSync"));
		return element;
	}	
	
	/**
	 * Do not pass VMP comments chkbx.
	 *
	 * @return the string
	 */
	public static String doNotPassVMPComments_chkbx(){	
		id = "Main_cbEnable_VMPComment_DoNotSync";
		return id;
	}
	
}
