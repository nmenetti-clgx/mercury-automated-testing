package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure Client Groups page
 */
public class SClients_ClientGroups {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	/** The css selector. */
	private static String cssSelector = null;

	
	/**
	 * Dialog client groups txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Manage Client Groups text
	public static WebElement dialogClientGroups_txt(WebDriver driver){	
		element = driver.findElement(By.id("bdyDialog"));
		return element;
	}	
	
	/**
	 * Dialog client groups txt.
	 *
	 * @return the string
	 */
	public static String dialogClientGroups_txt(){	
		id = "bdyDialog";
		return id;
	}	
		
	/**
	 * Close dialog btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Close Dialog button
	public static WebElement closeDialog_btn(WebDriver driver){	
		element = driver.findElement(By.cssSelector("img[src='/Images/DialogCloseButton.png']"));
		return element;
	}	
	
	/**
	 * Close dialog btn.
	 *
	 * @return the string
	 */
	public static String closeDialog_btn(){	
		cssSelector = "img[src='/Images/DialogCloseButton.png']";
		return cssSelector;
	}	
	
	/**
	 * Dialog save txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Save dialog
	public static WebElement dialogSave_txt(WebDriver driver){	
		element = driver.findElement(By.id("AlertDialogText"));
		return element;
	}	
	
	/**
	 * Dialog save txt.
	 *
	 * @return the string
	 */
	public static String dialogSave_txt(){	
		id = "AlertDialogText";
		return id;
	}
	
	/**
	 * Ok save btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// OK save button
	public static WebElement okSave_btn(WebDriver driver){	
		element = driver.findElement(By.cssSelector("#AlertDialog > div.MsgBoxContent > div > input[type='button']"));
		return element;
	}	
	
	/**
	 * Ok save btn.
	 *
	 * @return the string
	 */
	public static String okSave_btn(){	
		cssSelector = "#AlertDialog > div.MsgBoxContent > div > input[type='button']";
		return cssSelector;
	}	
	
	/**
	 * Dialog confirm delete txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Confirm Delete dialog text
	public static WebElement dialogConfirmDelete_txt(WebDriver driver){	
		element = driver.findElement(By.id("divConfirmDelete"));
		return element;
	}	
	
	/**
	 * Dialog confirm delete txt.
	 *
	 * @return the string
	 */
	public static String dialogConfirmDelete_txt(){	
		id = "divConfirmDelete";
		return id;
	}	
	
	/**
	 * Yes delete btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Yes Delete button
	public static WebElement yesDelete_btn(WebDriver driver){	
		element = driver.findElement(By.cssSelector("input[onclick='btnConfirmDeleteYes_Click()']"));
		return element;
	}	
	
	/**
	 * Yes delete btn.
	 *
	 * @return the string
	 */
	public static String yesDelete_btn(){	
		cssSelector = "input[onclick='btnConfirmDeleteYes_Click()']";
		return cssSelector;
	}
	
	/**
	 * Automated btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Automated button
	public static WebElement automated_btn(WebDriver driver){	
		element = driver.findElement(By.id("divTabAutomated"));
		return element;
	}	
	
	/**
	 * Automated btn.
	 *
	 * @return the string
	 */
	public static String automated_btn(){	
		id = "divTabAutomated";
		return id;
	}
	
	/**
	 * Customize your invoice number link.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Customize your invoice number link
	public static WebElement customizeYourInvoiceNumber_link(WebDriver driver){	
		element = driver.findElement(By.id("hlInvoice_CustomizeNumberAndDueDate"));
		return element;
	}	
	
	/**
	 * Customize your invoice number link.
	 *
	 * @return the string
	 */
	public static String customizeYourInvoiceNumber_link(){	
		id = "hlInvoice_CustomizeNumberAndDueDate";
		return id;
	}
	
	/**
	 * Use tracking number chckbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Use tracking number checkbox
	public static WebElement useTrackingNumber_chckbx(WebDriver driver){	
		element = driver.findElement(By.id("Dialogs_cbInvoice_UseTrackingNoAsInvoiceNo"));
		return element;
	}	
	
	/**
	 * Use tracking number chckbx.
	 *
	 * @return the string
	 */
	public static String useTrackingNumber_chckbx(){	
		id = "Dialogs_cbInvoice_UseTrackingNoAsInvoiceNo";
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
		element = driver.findElement(By.cssSelector("input[onclick='btnInvoice_AutomaticInvoiceOptions_ClickOK();']"));
		return element;
	}	
	
	/**
	 * Ok btn.
	 *
	 * @return the string
	 */
	public static String ok_btn(){	
		cssSelector = "input[onclick='btnInvoice_AutomaticInvoiceOptions_ClickOK();']";
		return cssSelector;
	}
	
	/**
	 * Edits the group btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Edit Group button
	public static WebElement editGroup_btn(WebDriver driver){	
		element = driver.findElement(By.cssSelector("img[src='../Images/EditItemIcon16x16.png']"));
		return element;
	}	
	
	/**
	 * Edits the group btn.
	 *
	 * @return the string
	 */
	public static String editGroup_btn(){	
		cssSelector = "img[src='../Images/EditItemIcon16x16.png']";
		return cssSelector;
	}
	
	/**
	 * Details btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Details button
	public static WebElement details_btn(WebDriver driver){	
		element = driver.findElement(By.id("divTabDetails"));
		return element;
	}	
	
	/**
	 * Details btn.
	 *
	 * @return the string
	 */
	public static String details_btn(){	
		id = "divTabDetails";
		return id;
	}
	
	/**
	 * Aqm btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// AQM button
	public static WebElement aqm_btn(WebDriver driver){	
		element = driver.findElement(By.id("divTabAQM"));
		return element;
	}	
	
	/**
	 * Aqm btn.
	 *
	 * @return the string
	 */
	public static String aqm_btn(){	
		id = "divTabAQM";
		return id;
	}
	
	/**
	 * Members btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Members button
	public static WebElement members_btn(WebDriver driver){	
		element = driver.findElement(By.id("divTabMembers"));
		return element;
	}	
	
	/**
	 * Members btn.
	 *
	 * @return the string
	 */
	public static String members_btn(){	
		id = "divTabMembers";
		return id;
	}
	
	/**
	 * Order groups btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Order Groups button
	public static WebElement orderGroups_btn(WebDriver driver){	
		element = driver.findElement(By.id("divTabOrderGroups"));
		return element;
	}	
	
	/**
	 * Order groups btn.
	 *
	 * @return the string
	 */
	public static String orderGroups_btn(){	
		id = "divTabOrderGroups";
		return id;
	}
	
	/**
	 * Place orders chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Place Orders checkbox
	public static WebElement placeOrders_chkbx(WebDriver driver){	
		element = driver.findElement(By.id("Main_cblPlacingOrders_0"));
		return element;
	}	
	
	/**
	 * Place orders chkbx.
	 *
	 * @return the string
	 */
	public static String placeOrders_chkbx(){	
		id = "Main_cblPlacingOrders_0";
		return id;
	}
	
	/**
	 * Adds the available groups btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Add available groups button
	public static WebElement addAvailableGroups_btn(WebDriver driver){	
		element = driver.findElement(By.cssSelector("img[src='/Images/Button-Add.png']"));
		return element;
	}	
	
	/**
	 * Adds the available groups btn.
	 *
	 * @return the string
	 */
	public static String addAvailableGroups_btn(){	
		cssSelector = "img[src='/Images/Button-Add.png']";
		return cssSelector;
	}
	
	/**
	 * Placing orders in this group div.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Placing Orders In This Group div
	public static WebElement placingOrdersInThisGroup_div(WebDriver driver){	
		element = driver.findElement(By.id("divPermissions"));
		return element;
	}	
	
	/**
	 * Placing orders in this group div.
	 *
	 * @return the string
	 */
	public static String placingOrdersInThisGroup_div(){	
		id = "divPermissions";
		return id;
	}
	
	/**
	 * Save add to client groups btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Save Add to Client Groups button
	public static WebElement saveAddToClientGroups_btn(WebDriver driver){	
		element = driver.findElement(By.cssSelector("#divAssignClientGroups > div.MsgBoxContent > div:nth-child(4) > input:nth-child(1)"));
		return element;
	}	
	
	/**
	 * Save add to client groups btn.
	 *
	 * @return the string
	 */
	public static String saveAddToClientGroups_btn(){	
		cssSelector = "#divAssignClientGroups > div.MsgBoxContent > div:nth-child(4) > input:nth-child(1)";
		return cssSelector;
	}
	
	/**
	 * View client groups btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// View Client Groups button
	public static WebElement viewClientGroups_btn(WebDriver driver){	
		element = driver.findElement(By.cssSelector("img[src='/Images/ToolbarDropDownArrow.png']"));
		return element;
	}	
	
	/**
	 * View client groups btn.
	 *
	 * @return the string
	 */
	public static String viewClientGroups_btn(){	
		cssSelector = "img[src='/Images/ToolbarDropDownArrow.png']";
		return cssSelector;
	}
	
	/**
	 * Client groups table.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Client Groups table
	public static WebElement clientGroups_table(WebDriver driver){	
		element = driver.findElement(By.id("tblMemberGroups_Items"));
		return element;
	}	
	
	/**
	 * Client groups table.
	 *
	 * @return the string
	 */
	public static String clientGroups_table(){	
		id = "tblMemberGroups_Items";
		return id;
	}
		
}
