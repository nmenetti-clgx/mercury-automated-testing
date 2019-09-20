package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure Users page
 */
public class SUsers {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	/** The css selector. */
	private static String cssSelector = null;

	
	/**
	 * Compliance chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Compliance checkbox
	public static WebElement compliance_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_dlPermissionOrderManagement_chkPermission_0"));
		return element;
	}
	
	/**
	 * Compliance chkbx.
	 *
	 * @return the string
	 */
	public static String compliance_chkbx(){
		id = "Main_Main_dlPermissionOrderManagement_chkPermission_0";
		return id;
	}
	
	/**
	 * Auto assignment approval chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Auto Assignment Approval checkbox
	public static WebElement autoAssignmentApproval_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_dlPermissionOrderManagement_chkPermission_1"));
		return element;
	}
	
	/**
	 * Auto assignment approval chkbx.
	 *
	 * @return the string
	 */
	public static String autoAssignmentApproval_chkbx(){
		id = "Main_Main_dlPermissionOrderManagement_chkPermission_1";
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
		element = driver.findElement(By.cssSelector("img[src='/Images/Save16x16.png']"));
		return element;
	}
	
	/**
	 * Save btn.
	 *
	 * @return the string
	 */
	public static String save_btn(){
		cssSelector = "img[src='/Images/Save16x16.png']";
		return cssSelector;
	}
	
	/**
	 * Creates the new user btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Create New User button
	public static WebElement createNewUser_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='Images/NewUserIcon16x16.png']"));
		return element;
	}
	
	/**
	 * Creates the new user btn.
	 *
	 * @return the string
	 */
	public static String createNewUser_btn(){
		cssSelector = "img[src='Images/NewUserIcon16x16.png']";
		return cssSelector;
	}
	
	/**
	 * Delete user btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Delete User button
	public static WebElement deleteUser_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("img[src='/Images/Save16x16.png']"));
		return element;
	}
	
	/**
	 * Delete user btn.
	 *
	 * @return the string
	 */
	public static String deleteUser_btn(){
		cssSelector = "img[src='/Images/Save16x16.png']";
		return cssSelector;
	}
	
	/**
	 * Primary email txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Primary E-mail textbox
	public static WebElement primaryEmail_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_m_oContactInfo_txtEmail"));
		return element;
	}
	
	/**
	 * Primary email txtbx.
	 *
	 * @return the string
	 */
	public static String primaryEmail_txtbx(){
		id = "Main_Main_m_oContactInfo_txtEmail";
		return id;
	}
	
	/**
	 * Password txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Password textbox
	public static WebElement password_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_m_oContactInfo_txtFalsePassword"));
		return element;
	}
	
	/**
	 * Password txtbx.
	 *
	 * @return the string
	 */
	public static String password_txtbx(){
		id = "Main_Main_m_oContactInfo_txtFalsePassword";
		return id;
	}
	
	/**
	 * Current Password
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Current Password
	public static WebElement currentPassword_txtbx(WebDriver driver){
		element = driver.findElement(By.id("divNewPassword_txtExisting"));
		return element;
	}
	
	/**
	 * Current Pasword
	 *
	 * @return the string
	 */
	public static String currentPassword_txtbx(){
		id = "divNewPassword_txtExisting";
		return id;
	}
	
	/**
	 * Password security options txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Password Security Options textbox
	public static WebElement passwordSecurityOptions_txtbx(WebDriver driver){
		element = driver.findElement(By.id("divNewPassword_txtNew"));
		return element;
	}
	
	/**
	 * Password security options txtbx.
	 *
	 * @return the string
	 */
	public static String passwordSecurityOptions_txtbx(){
		id = "divNewPassword_txtNew";
		return id;
	}
	
	/**
	 * Confirm password security options txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Confirm Password textbox
	public static WebElement confirmPasswordSecurityOptions_txtbx(WebDriver driver){
		element = driver.findElement(By.id("divNewPassword_txtConfirm"));
		return element;
	}
	
	/**
	 * Confirm password security options txtbx.
	 *
	 * @return the string
	 */
	public static String confirmPasswordSecurityOptions_txtbx(){
		id = "divNewPassword_txtConfirm";
		return id;
	}
	
	/**
	 * Save security options btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// OK Security Options button
	public static WebElement saveSecurityOptions_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_securityOptions_Save"));
		return element;
	}
	
	/**
	 * Save security options btn.
	 *
	 * @return the string
	 */
	public static String saveSecurityOptions_btn(){
		id = "Dialogs_Dialogs_securityOptions_Save";
		return id;
	}
	
	/**
	 * First name txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// First Name textbox
	public static WebElement firstName_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_m_oContactInfo_txtFirst"));
		return element;
	}
	
	/**
	 * First name txtbx.
	 *
	 * @return the string
	 */
	public static String firstName_txtbx(){
		id = "Main_Main_m_oContactInfo_txtFirst";
		return id;
	}
	
	/**
	 * Last name txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Last Name textbox
	public static WebElement lastName_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_m_oContactInfo_txtLast"));
		return element;
	}
	
	/**
	 * Last name txtbx.
	 *
	 * @return the string
	 */
	public static String lastName_txtbx(){
		id = "Main_Main_m_oContactInfo_txtLast";
		return id;
	}
	
	/**
	 * Phone txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Phone textbox
	public static WebElement phone_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_m_oContactInfo_txtPhone"));
		return element;
	}
	
	/**
	 * Phone txtbx.
	 *
	 * @return the string
	 */
	public static String phone_txtbx(){
		id = "Main_Main_m_oContactInfo_txtPhone";
		return id;
	}
	
	/**
	 * Users txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Users text
	public static WebElement users_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector("td.BlueBox"));
		return element;
	}
	
	/**
	 * Users txt.
	 *
	 * @return the string
	 */
	public static String users_txt(){
		cssSelector = "td.BlueBox";
		return cssSelector;
	}
	
	/**
	 * Ok account restored btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// OK Account Restored button
	public static WebElement okAccountRestored_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("input[onclick='javascript:HideAlert();']"));
		return element;
	}
	
	/**
	 * Ok account restored btn.
	 *
	 * @return the string
	 */
	public static String okAccountRestored_btn(){
		cssSelector = "input[onclick='javascript:HideAlert();']";
		return cssSelector;
	}
	
	/**
	 * Yes delete user btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Yes delete user button
	public static WebElement yesDeleteUser_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_btnDelete"));
		return element;
	}
	
	/**
	 * Yes delete user btn.
	 *
	 * @return the string
	 */
	public static String yesDeleteUser_btn(){
		id = "Dialogs_Dialogs_btnDelete";
		return id;
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
	 * Ok alert dialog btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// OK Alert Dialog button
	public static WebElement okAlertDialog_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("input[onclick='javascript:HideAlert();']"));
		return element;
	}
	
	/**
	 * Ok alert dialog btn.
	 *
	 * @return the string
	 */
	public static String okAlertDialog_btn(){
		cssSelector = "input[onclick='javascript:HideAlert();']";
		return cssSelector;
	}
	
	/**
	 * Ok minimum characters btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// OK minimum characters button
	public static WebElement okMinimumCharacters_btn(WebDriver driver){
		element = driver.findElement(By.id("sbdmButton1"));
		return element;
	}
	
	/**
	 * Ok minimum characters btn.
	 *
	 * @return the string
	 */
	public static String okMinimumCharacters_btn(){
		id = "sbdmButton1";
		return id;
	}
	
	/**
	 * Residential appraisal checkbox.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Residential appraisal checkbox
	public static WebElement residentialAppraisal_checkbox(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_m_ctrlPlaceNewOrders_chkItems_0"));
		return element;
	}
	
	/**
	 * Residential appraisal checkbox.
	 *
	 * @return the string
	 */
	public static String residentialAppraisal_checkbox(){
		id = "Dialogs_Dialogs_m_ctrlPlaceNewOrders_chkItems_0";
		return id;
	}
	
	/**
	 * Commercial appraisal checkbox.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Commercial appraisal checkbox
	public static WebElement commercialAppraisal_checkbox(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_m_ctrlPlaceNewOrders_chkItems_1"));
		return element;
	}
	
	/**
	 * Commercial appraisal checkbox.
	 *
	 * @return the string
	 */
	public static String commercialAppraisal_checkbox(){
		id = "Dialogs_Dialogs_m_ctrlPlaceNewOrders_chkItems_1";
		return id;
	}
	
	/**
	 * Inspection checkbox.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Inspection checkbox
	public static WebElement inspection_checkbox(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_m_ctrlPlaceNewOrders_chkItems_2"));
		return element;
	}
	
	/**
	 * Inspection checkbox.
	 *
	 * @return the string
	 */
	public static String inspection_checkbox(){
		id = "Dialogs_Dialogs_m_ctrlPlaceNewOrders_chkItems_2";
		return id;
	}
	
	/**
	 * Ok place new orders btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// OK Place New Orders
	public static WebElement okPlaceNewOrders_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_m_ctrlPlaceNewOrders_btnCheckboxGroupPopup_OK"));
		return element;
	}
	
	/**
	 * Ok place new orders btn.
	 *
	 * @return the string
	 */
	public static String okPlaceNewOrders_btn(){
		id = "Dialogs_Dialogs_m_ctrlPlaceNewOrders_btnCheckboxGroupPopup_OK";
		return id;
	}

	/**
	 * Sub user btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Sub User button
	public static WebElement subUser_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#divAdminMain > table > tbody > tr > td.BlueBox > div.User.Ellipsis"));
		return element;
	}
	
	/**
	 * Sub user btn.
	 *
	 * @return the string
	 */
	public static String subUser_btn(){
		cssSelector = "#divAdminMain > table > tbody > tr > td.BlueBox > div.User.Ellipsis";
		return cssSelector;
	}
	
	/**
	 * Ok edit update orders btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// OK Edit/Update Orders
	public static WebElement okEditUpdateOrders_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_m_ctrlEditUpdateOrders_btnCheckboxGroupPopup_OK"));
		return element;
	}
	
	/**
	 * Ok edit update orders btn.
	 *
	 * @return the string
	 */
	public static String okEditUpdateOrders_btn(){
		id = "Dialogs_Dialogs_m_ctrlEditUpdateOrders_btnCheckboxGroupPopup_OK";
		return id;
	}
	
	/**
	 * Issue review bids chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Issue/Review Bids checkbox
	public static WebElement issueReviewBids_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_Dialogs_m_ctrlEditUpdateOrders_chkItems_18"));
		return element;
	}
	
	/**
	 * Issue review bids chkbx.
	 *
	 * @return the string
	 */
	public static String issueReviewBids_chkbx(){
		id = "Dialogs_Dialogs_m_ctrlEditUpdateOrders_chkItems_18";
		return id;
	}
	
	/**
	 * Issue review bids txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Issue/Review Bids textbox
	public static WebElement issueReviewBids_txtbx(WebDriver driver){
		element = driver.findElement(By.cssSelector("label[for='Dialogs_Dialogs_m_ctrlEditUpdateOrders_chkItems_18']"));
		return element;
	}
	
	/**
	 * Issue review bids txtbx.
	 *
	 * @return the string
	 */
	public static String issueReviewBids_txtbx(){
		cssSelector = "label[for='Dialogs_Dialogs_m_ctrlEditUpdateOrders_chkItems_18']";
		return cssSelector;
	}
	
	/**
	 * Password gear icon.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Password Gear Icon
	public static WebElement passwordGear_icon(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_m_oContactInfo_lnkPwd"));
		return element;
	}
	
	/**
	 * Password gear icon.
	 *
	 * @return the string
	 */
	public static String passwordGear_icon(){
		id = "Main_Main_m_oContactInfo_lnkPwd";
		return id;
	}
	
	/**
	 * View manage other users orders chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// View/Manage Other Users' Orders checkbox
	public static WebElement viewManageOtherUsersOrders_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_dlPermissionOrderManagement_chkPermission_6"));
		return element;
	}
	
	/**
	 * View manage other users orders chkbx.
	 *
	 * @return the string
	 */
	public static String viewManageOtherUsersOrders_chkbx(){
		id = "Main_Main_dlPermissionOrderManagement_chkPermission_6";
		return id;
	}
	/**
	 * Place New Orders permission chkbx
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Place New Orders permission chkbx
	public static WebElement placeNewOrders_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_dlPermissionOrderManagement_chkPermission_0"));
		return element;
	}
	
	/**
	 * Place New Orders permission chkbx
	 *
	 * @return the string
	 */
	public static String  placeNewOrders_chkbx(){
		id = "Main_Main_dlPermissionOrderManagement_chkPermission_0";
		return id;
	
    }
	/**
	 * Required to Use Fee Panel chkbx
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Required to Use Fee Panel chkbx
	public static WebElement requiredToUseFeePanel_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_dlPermissionOrderManagement_chkPermission_5"));
		return element;
	}
	
	/**
	 * Required to Use Fee Panel chkbx
	 *
	 * @return the string
	 */
	public static String   requiredToUseFeePanel_chkbx(){
		id = "Main_Main_dlPermissionOrderManagement_chkPermission_5";
		return id;
    }
	/**
	 * Compliance chkbx
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Compliance chkbx
	public static WebElement compliancePermission_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_dlPermissionOrderManagement_chkPermission_8"));
		return element;
	}
	
	/**
	 * Compliance chkbx
	 *
	 * @return the string
	 */
	public static String compliancePermission_chkbx(){
		id = "Main_Main_dlPermissionOrderManagement_chkPermission_8";
		return id;
    }
	/**
	 * Auto Assignment Approval chkbx
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Auto Assignment Approval chkbx
	public static WebElement autoAssignmentApprovalPermission_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_dlPermissionOrderManagement_chkPermission_12"));
		return element;
	}
	
	/**
	 * Auto Assignment Approval chkbx
	 *
	 * @return the string
	 */
	public static String autoAssignmentApprovalPermission_chkbx(){
		id = "Main_Main_dlPermissionOrderManagement_chkPermission_12";
		return id;
    }

	/**
	 * Mark Orders as Paid chkbx
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Mark Orders as Paid chkbx
	public static WebElement markOrdersAsPaid_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_dlPermissionOrderManagement_chkPermission_15"));
		return element;
	}
	
	/**
	 * Mark Orders as Paid chkbx
	 *
	 * @return the string
	 */
	public static String markOrdersAsPaid_chkbx(){
		id = "Main_Main_dlPermissionOrderManagement_chkPermission_15";
		return id;
    }
	/**
	 * Edit Orders chkbx
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Edit Orders chkbx
	public static WebElement editOrders_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_dlPermissionOrderManagement_chkPermission_1"));
		return element;
	}
	
	/**
	 * Edit Orders chkbx
	 *
	 * @return the string
	 */
	public static String editOrders_chkbx(){
		id = "Main_Main_dlPermissionOrderManagement_chkPermission_1";
		return id;
    }
	/**
	 * Selection Settings  chkbx
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Selection Settings  chkbx
	public static WebElement selectionSettings_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_dlPermissionOrderManagement_chkPermission_4"));
		return element;
	}
	
	/**
	 * Selection Settings  chkbx
	 *
	 * @return the string
	 */
	public static String selectionSettings_chkbx(){
		id = "Main_Main_dlPermissionOrderManagement_chkPermission_4";
		return id;
    }
	/**
	 * Manage QuickLists  chkbx
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Manage QuickLists  chkbx
	public static WebElement manageQuicklists_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_dlPermissionOrderManagement_chkPermission_9"));
		return element;
	}
	
	/**
	 * Manage QuickLists  chkbx
	 *
	 * @return the string
	 */
	public static String manageQuicklists_chkbx(){
		id = "Main_Main_dlPermissionOrderManagement_chkPermission_9";
		return id;
}
	/**
	 * Submit to AQM  chkbx
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Submit to AQM  chkbx
	public static WebElement submitToAqm_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_dlPermissionOrderManagement_chkPermission_13"));
		return element;
	}
	
	/**
	 * Submit to AQM  chkbx
	 *
	 * @return the string
	 */
	public static String submitToAqm_chkbx_chkbx(){
		id = "Main_Main_dlPermissionOrderManagement_chkPermission_13";
		return id;
    }
	/**
	 * Manage Orders By Product chkbx
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Manage Orders By Product chkbx
	public static WebElement manageOrdersByProduct_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_dlPermissionOrderManagement_chkPermission_2"));
		return element;
	}
	
	/**
	 * Manage Orders By Product chkbx
	 *
	 * @return the string
	 */
	public static String manageOrdersByProduct_chkbx(){
		id = "Main_Main_dlPermissionOrderManagement_chkPermission_2";
		return id;
    }
	/**
	 * Manage Other Users Orders chkbx
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Manage Other Users Orders chkbx
	public static WebElement manageOtherUsersOrders_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_dlPermissionOrderManagement_chkPermission_6"));
		return element;
	}
	
	/**
	 * Manage Other Users Orders chkbx
	 *
	 * @return the string
	 */
	public static String manageOtherUsersOrders_chkbx(){
		id = "Main_Main_dlPermissionOrderManagement_chkPermission_6";
		return id;
    }
	/**
	 * Cover Vendor's Transaction Fee chkbx
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Cover Vendor's Transaction Fee chkbx
	public static WebElement coverVendorsTransactionFee_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_dlPermissionOrderManagement_chkPermission_10"));
		return element;
	}
	
	/**
	 * Cover Vendor's Transaction Fee chkbx
	 *
	 * @return the string
	 */
	public static String coverVendorsTransactionFee_chkbx(){
		id = "Main_Main_dlPermissionOrderManagement_chkPermission_10";
		return id;
    }
	/**
	 * Rate Vendors chkbx
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Rate Vendors chkbx
	public static WebElement rateVendors_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_dlPermissionOrderManagement_chkPermission_14"));
		return element;
	}
	
	/**
	 * Rate Vendors chkbx
	 *
	 * @return the string
	 */
	public static String rateVendors_chkbx(){
		id = "Main_Main_dlPermissionOrderManagement_chkPermission_14";
		return id;
    }
	/**
	 * Manage Orders By Folder chkbx
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Manage Orders By Folder chkbx
	public static WebElement manageOrdersByFolder_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_dlPermissionOrderManagement_chkPermission_3"));
		return element;
	}
	
	/**
	 * Manage Orders By Folder chkbx
	 *
	 * @return the string
	 */
	public static String manageOrdersByFolder_chkbx(){
		id = "Main_Main_dlPermissionOrderManagement_chkPermission_3";
		return id;
    }
	/**
	 * Submit To UCDP chkbx
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Submit To UCDP chkbx
	public static WebElement submitToUcdp_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_dlPermissionOrderManagement_chkPermission_7"));
		return element;
	}
	
	/**
	 * Submit To UCDP chkbx
	 *
	 * @return the string
	 */
	public static String submitToUcdp_chkbx(){
		id = "Main_Main_dlPermissionOrderManagement_chkPermission_7";
		return id;
    }
	/**
	 * Submit To FHA chkbx
	 *
	 * @return the string
	 */

	/**
	 * Submit To FHA chkbx
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Submit To FHA chkbx
	public static WebElement submitToFha_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_dlPermissionOrderManagement_chkPermission_11"));
		return element;
	}
	
	/**
	 * Submit To FHA chkbx
	 *
	 * @return the string
	 */
	public static String submitToFha_chkbx(){
		id = "Main_Main_dlPermissionOrderManagement_chkPermission_11";
		return id;
    }
	/**
	 * Access VMP XSite chkbx
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Access VMP XSite chkbx
	public static WebElement accessVmpXsite_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_dlPermissionOrderManagement_chkPermission_15"));
		return element;
	}
	
	/**
	 * Access VMP XSite chkbx
	 *
	 * @return the string
	 */
	public static String accessVmpXsite_chkbx(){
		id = "Main_Main_dlPermissionOrderManagement_chkPermission_15";
		return id;
    }
	/**
	 * UARR Configuration chkbx
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// UARR Configuration chkbx
	public static WebElement uarrConfiguration_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_dlPermissionPreferencesManagement_chkPermission_0"));
		return element;
	}
	
	/**
	 * UARR Configuration chkbx
	 *
	 * @return the string
	 */
	public static String uarrConfiguration_chkbx(){
		id = "Main_Main_dlPermissionPreferencesManagement_chkPermission_0";
		return id;
    }
	/**
	 * AQM Settings chkbx
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// AQM Settings chkbx
	public static WebElement aqmSettings_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_dlPermissionPreferencesManagement_chkPermission_3"));
		return element;
	}
	
	/**
	 * AQM Settings chkbx
	 *
	 * @return the string
	 */
	public static String aqmSettings_chkbx(){
		id = "Main_Main_dlPermissionPreferencesManagement_chkPermission_3";
		return id;
    }
	/**
	 * Order Product Requirements chkbx
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Order Product Requirements chkbx
	public static WebElement orderProductRequirements_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_dlPermissionPreferencesManagement_chkPermission_1"));
		return element;
	}
	
	/**
	 * Order Product Requirements chkbx
	 *
	 * @return the string
	 */
	public static String orderProductRequirements_chkbx(){
		id = "Main_Main_dlPermissionPreferencesManagement_chkPermission_1";
		return id;
    }
	/**
	 * VMP XSites chkbx
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// VMP XSites chkbx
	public static WebElement vmpXsites_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_dlPermissionPreferencesManagement_chkPermission_2"));
		return element;
	 }
	
	/**
	 * VMP XSites chkbx
	 *
	 * @return the string
	 */
	public static String vmpXsites_chkbx(){
		id = "Main_Main_dlPermissionPreferencesManagement_chkPermission_2";
		return id;
    }
	/**
	 * Vendor Selection chkbx
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Vendor Selection chkbx
	public static WebElement vendorSelection_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_dlPermissionPreferencesManagement_chkPermission_3"));
		return element;
	}
	
	/**
	 * Vendor Selection chkbx
	 *
	 * @return the string
	 */
	public static String  vendorSelection_chkbx(){
		id = "Main_Main_dlPermissionPreferencesManagement_chkPermission_3";
		return id;
     }
	/**
	 *Client Management chkbx
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Client Management chkbx
	public static WebElement clientManagement_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_dlPermissionAccountsManagement_chkPermission_0"));
		return element;
	}
	
	/**
	 * Client Management chkbx
	 *
	 * @return the string
	 */
	public static String  clientManagement_chkbx(){
		id = "Main_Main_dlPermissionAccountsManagement_chkPermission_0";
		return id;
    }
	/**
	 * Manage Fee Panel chkbx
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Manage Fee Panel chkbx
	public static WebElement manageFeePanel_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_dlPermissionAccountsManagement_chkPermission_3"));
		return element;
	}
	
	/**
	 * Manage Fee Panel chkbx
	 *
	 * @return the string
	 */
	public static String  manageFeePanel_chkbx(){
		id = "Main_Main_dlPermissionAccountsManagement_chkPermission_3";
		return id;
    }
	/**
	 * View Management Report chkbx
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	//View Management Report chkbx
	public static WebElement viewManageReports_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_dlPermissionAccountsManagement_chkPermission_1"));
		return element;
	}
	
	/**
	 * View Management Report chkbx
	 *
	 * @return the string
	 */
	public static String  viewManageReports_chkbx(){
		id = "Main_Main_dlPermissionAccountsManagement_chkPermission_1";
		return id;
    }
	/**
	 * Fee Panel (Read Only) chkbx
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	//Fee Panel (Read Only) chkbx
	public static WebElement feePanelReadOnly_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_dlPermissionAccountsManagement_chkPermission_4"));
		return element;
	}
	
	/**
	 * Fee Panel (Read Only) chkbx
	 *
	 * @return the string
	 */
	public static String  feePanelReadOnly_chkbx(){
		id = "Main_Main_dlPermissionAccountsManagement_chkPermission_4";
		return id;
    }
	/**
	 * Add/Manage User Accounts chkbx
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	//Add/Manage User Accounts chkbx
	public static WebElement manageUserAccounts_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_dlPermissionAccountsManagement_chkPermission_2"));
		return element;
	}
	
	/**
	 * Add/Manage User Accounts chkbx
	 *
	 * @return the string
	 */
	public static String  manageUserAccounts_chkbx(){
		id = "Main_Main_dlPermissionAccountsManagement_chkPermission_2";
		return id;
    }
	/**
	 * Add/Manage Connections chkbx
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	//Add/Manage Connections chkbx
	public static WebElement manageConnections_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_dlPermissionAccountsManagement_chkPermission_5"));
		return element;
	}
	
	/**
	 * Add/Manage Connections chkbx
	 *
	 * @return the string
	 */
	public static String  manageConnections_chkbx(){
		id = "Main_Main_dlPermissionAccountsManagement_chkPermission_5";
		return id;
    }
	/**
	 * Manage Account chkbx 
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	//Manage Account chkbx
	public static WebElement manageAccount_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_dlPermissionAccountsManagement_chkPermission_2"));
		return element;
	}
	
	/**
	 * Manage Account chkbx 
	 *
	 * @return the string
	 */
	public static String  manageAccount_chkbx(){
		id = "Main_Main_dlPermissionAccountsManagement_chkPermission_2";
		return id;
    }
	/**
	 * Manage Payments chkbx 
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	//Manage Payments chkbx
	public static WebElement managePayments_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_dlPermissionAccountsManagement_chkPermission_6"));
		return element;
	}
	
	/**
	 * Manage Payments chkbx 
	 *
	 * @return the string
	 */
	public static String  managePayments_chkbx(){
		id = "Main_Main_dlPermissionAccountsManagement_chkPermission_6";
		return id;
    }
	/**
	 * Compliance Security OK btn 
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	//Compliance Security OK btn 
	public static WebElement complianceSecurityOk_btn(WebDriver driver){
		element = driver.findElement(By.id("btnComplianceOK"));
		return element;
	}
	
	/**
	 * Compliance Security OK btn  
	 *
	 * @return the string
	 */
	public static String  complianceSecurityOk_btn(){
		id = "btnComplianceOK";
		return id;
    }
	
    }