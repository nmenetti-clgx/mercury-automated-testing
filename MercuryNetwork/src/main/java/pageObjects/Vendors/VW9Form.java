package pageObjects.Vendors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Vendors W9 Form page
 */
public class VW9Form {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	/** The css selector. */
	private static String cssSelector = null;

	
	/**
	 * Name txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Name textbox
	public static WebElement name_txtbx(WebDriver driver){						
		element = driver.findElement(By.id("txtName"));					
		return element;					
	}						
	
	/**
	 * Name txtbx.
	 *
	 * @return the string
	 */
	public static String name_txtbx(){						
		id = "txtName";					
		return id;					
	}
	
	/**
	 * Business name txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// businessName txtbx					
	public static WebElement businessName_txtbx(WebDriver driver){					
		element = driver.findElement(By.id("txtBusinessName"));				
		return element;				
	}					
	
	/**
	 * Business name txtbx.
	 *
	 * @return the string
	 */
	public static String businessName_txtbx(){					
		id = "txtBusinessName";				
		return id;				
	}					
						
	/**
	 * Individual radiobtn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// individual radiobtn					
	public static WebElement individual_radiobtn(WebDriver driver){					
		element = driver.findElement(By.id("optClassification1"));				
		return element;				
	}					
	
	/**
	 * Individual radiobtn.
	 *
	 * @return the string
	 */
	public static String individual_radiobtn(){					
		id = "optClassification1";				
		return id;				
	}					
						
	/**
	 * C corporation radiobtn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// cCorporation radiobtn					
	public static WebElement cCorporation_radiobtn(WebDriver driver){					
		element = driver.findElement(By.id("optClassification2"));				
		return element;				
	}					
	
	/**
	 * C corporation radiobtn.
	 *
	 * @return the string
	 */
	public static String cCorporation_radiobtn(){					
		id = "optClassification2";				
		return id;				
	}					
						
	/**
	 * S corporation radiobtn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// sCorporation radiobtn					
	public static WebElement sCorporation_radiobtn(WebDriver driver){					
		element = driver.findElement(By.id("optClassification3"));				
		return element;				
	}					
	
	/**
	 * S corporation radiobtn.
	 *
	 * @return the string
	 */
	public static String sCorporation_radiobtn(){					
		id = "optClassification3";				
		return id;				
	}					
						
	/**
	 * Partnership radiobtn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// partnership radiobtn					
	public static WebElement partnership_radiobtn(WebDriver driver){					
		element = driver.findElement(By.id("optClassification4"));				
		return element;				
	}					
	
	/**
	 * Partnership radiobtn.
	 *
	 * @return the string
	 */
	public static String partnership_radiobtn(){					
		id = "optClassification4";				
		return id;				
	}					
						
	/**
	 * Trust estate radiobtn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// trustEstate radiobtn					
	public static WebElement trustEstate_radiobtn(WebDriver driver){					
		element = driver.findElement(By.id("optClassification5"));				
		return element;				
	}					
	
	/**
	 * Trust estate radiobtn.
	 *
	 * @return the string
	 */
	public static String trustEstate_radiobtn(){					
		id = "optClassification5";				
		return id;				
	}					
						
	/**
	 * Limited liability radiobtn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// limitedLiability radiobtn					
	public static WebElement limitedLiability_radiobtn(WebDriver driver){					
		element = driver.findElement(By.id("optClassification6"));				
		return element;				
	}					
	
	/**
	 * Limited liability radiobtn.
	 *
	 * @return the string
	 */
	public static String limitedLiability_radiobtn(){					
		id = "optClassification6";				
		return id;				
	}					
						
	/**
	 * Limited liability txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// limitedLiability txtbx					
	public static WebElement limitedLiability_txtbx(WebDriver driver){					
		element = driver.findElement(By.id("txtLLCTaxClassification"));				
		return element;				
	}					
	
	/**
	 * Limited liability txtbx.
	 *
	 * @return the string
	 */
	public static String limitedLiability_txtbx(){					
		id = "txtLLCTaxClassification";				
		return id;				
	}					
						
	/**
	 * Other radiobtn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// other radiobtn					
	public static WebElement other_radiobtn(WebDriver driver){					
		element = driver.findElement(By.id("optClassification7"));				
		return element;				
	}					
	
	/**
	 * Other radiobtn.
	 *
	 * @return the string
	 */
	public static String other_radiobtn(){					
		id = "optClassification7";				
		return id;				
	}					
						
	/**
	 * Other txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// other txtbx					
	public static WebElement other_txtbx(WebDriver driver){					
		element = driver.findElement(By.id("txtOther"));				
		return element;				
	}					
	
	/**
	 * Other txtbx.
	 *
	 * @return the string
	 */
	public static String other_txtbx(){					
		id = "txtOther";				
		return id;				
	}					
						
	/**
	 * Exempt payee code txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// exemptPayeeCode txtbx					
	public static WebElement exemptPayeeCode_txtbx(WebDriver driver){					
		element = driver.findElement(By.id("txtExemptPayeeCode"));				
		return element;				
	}					
	
	/**
	 * Exempt payee code txtbx.
	 *
	 * @return the string
	 */
	public static String exemptPayeeCode_txtbx(){					
		id = "txtExemptPayeeCode";				
		return id;				
	}					
						
	/**
	 * Exemption from FATC A txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// exemptionFromFATCA txtbx					
	public static WebElement exemptionFromFATCA_txtbx(WebDriver driver){					
		element = driver.findElement(By.id("txtExemptionFromFATCA"));				
		return element;				
	}					
	
	/**
	 * Exemption from FATC A txtbx.
	 *
	 * @return the string
	 */
	public static String exemptionFromFATCA_txtbx(){					
		id = "txtExemptionFromFATCA";				
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
		element = driver.findElement(By.id("txtAddress"));				
		return element;				
	}					
	
	/**
	 * Address txtbx.
	 *
	 * @return the string
	 */
	public static String address_txtbx(){					
		id = "txtAddress";				
		return id;				
	}					
						
	/**
	 * City state zip txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// cityStateZip txtbx					
	public static WebElement cityStateZip_txtbx(WebDriver driver){					
		element = driver.findElement(By.id("txtCityStateZip"));				
		return element;				
	}					
	
	/**
	 * City state zip txtbx.
	 *
	 * @return the string
	 */
	public static String cityStateZip_txtbx(){					
		id = "txtCityStateZip";				
		return id;				
	}					
						
	/**
	 * List account numbers txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// listAccountNumbers txtbx					
	public static WebElement listAccountNumbers_txtbx(WebDriver driver){					
		element = driver.findElement(By.id("txtAccountNumbers"));				
		return element;				
	}					
	
	/**
	 * List account numbers txtbx.
	 *
	 * @return the string
	 */
	public static String listAccountNumbers_txtbx(){					
		id = "txtAccountNumbers";				
		return id;				
	}					
						
	/**
	 * Requesters name and address txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// requestersNameAndAddress txtbx					
	public static WebElement requestersNameAndAddress_txtbx(WebDriver driver){					
		element = driver.findElement(By.id("txtRequestersName"));				
		return element;				
	}					
	
	/**
	 * Requesters name and address txtbx.
	 *
	 * @return the string
	 */
	public static String requestersNameAndAddress_txtbx(){					
		id = "txtRequestersName";				
		return id;				
	}					

	/**
	 * Ssn 1 txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// SSN1 txtbx					
	public static WebElement ssn1_txtbx(WebDriver driver){					
		element = driver.findElement(By.id("txtSSN1"));				
		return element;				
	}					
	
	/**
	 * Ssn 1 txtbx.
	 *
	 * @return the string
	 */
	public static String ssn1_txtbx(){					
		id = "txtSSN1";				
		return id;				
	}
	
	/**
	 * Ssn 2 txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// SSN2 txtbx					
	public static WebElement ssn2_txtbx(WebDriver driver){					
		element = driver.findElement(By.id("txtSSN2"));				
		return element;				
	}					
	
	/**
	 * Ssn 2 txtbx.
	 *
	 * @return the string
	 */
	public static String ssn2_txtbx(){					
		id = "txtSSN2";				
		return id;				
	}	
	
	/**
	 * Ssn 3 txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// SSN3 txtbx					
	public static WebElement ssn3_txtbx(WebDriver driver){					
		element = driver.findElement(By.id("txtSSN3"));				
		return element;				
	}					
	
	/**
	 * Ssn 3 txtbx.
	 *
	 * @return the string
	 */
	public static String ssn3_txtbx(){					
		id = "txtSSN3";				
		return id;				
	}	
	
	/**
	 * Ssn 4 txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// SSN4 txtbx					
	public static WebElement ssn4_txtbx(WebDriver driver){					
		element = driver.findElement(By.id("txtSSN4"));				
		return element;				
	}					
	
	/**
	 * Ssn 4 txtbx.
	 *
	 * @return the string
	 */
	public static String ssn4_txtbx(){					
		id = "txtSSN4";				
		return id;				
	}	
	
	/**
	 * Ssn 5 txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// SSN5 txtbx					
	public static WebElement ssn5_txtbx(WebDriver driver){					
		element = driver.findElement(By.id("txtSSN5"));				
		return element;				
	}					
	
	/**
	 * Ssn 5 txtbx.
	 *
	 * @return the string
	 */
	public static String ssn5_txtbx(){					
		id = "txtSSN5";				
		return id;				
	}	
	
	/**
	 * Ssn 6 txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// SSN6 txtbx					
	public static WebElement ssn6_txtbx(WebDriver driver){					
		element = driver.findElement(By.id("txtSSN6"));				
		return element;				
	}					
	
	/**
	 * Ssn 6 txtbx.
	 *
	 * @return the string
	 */
	public static String ssn6_txtbx(){					
		id = "txtSSN6";				
		return id;				
	}	
	
	/**
	 * Ssn 7 txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// SSN7 txtbx					
	public static WebElement ssn7_txtbx(WebDriver driver){					
		element = driver.findElement(By.id("txtSSN7"));				
		return element;				
	}					
	
	/**
	 * Ssn 7 txtbx.
	 *
	 * @return the string
	 */
	public static String ssn7_txtbx(){					
		id = "txtSSN7";				
		return id;				
	}	
	
	/**
	 * Ssn 8 txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// SSN8 txtbx					
	public static WebElement ssn8_txtbx(WebDriver driver){					
		element = driver.findElement(By.id("txtSSN8"));				
		return element;				
	}					
	
	/**
	 * Ssn 8 txtbx.
	 *
	 * @return the string
	 */
	public static String ssn8_txtbx(){					
		id = "txtSSN8";				
		return id;				
	}	
	
	/**
	 * Ssn 9 txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// SSN9 txtbx					
	public static WebElement ssn9_txtbx(WebDriver driver){					
		element = driver.findElement(By.id("txtSSN9"));				
		return element;				
	}					
	
	/**
	 * Ssn 9 txtbx.
	 *
	 * @return the string
	 */
	public static String ssn9_txtbx(){					
		id = "txtSSN9";				
		return id;				
	}
	
	/**
	 * EIN 1 txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// EIN1 txtbx					
	public static WebElement EIN1_txtbx(WebDriver driver){					
		element = driver.findElement(By.id("txtEIN1"));				
		return element;				
	}					
	
	/**
	 * EIN 1 txtbx.
	 *
	 * @return the string
	 */
	public static String EIN1_txtbx(){					
		id = "txtEIN1";				
		return id;				
	}
	
	/**
	 * EIN 2 txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// EIN2 txtbx					
	public static WebElement EIN2_txtbx(WebDriver driver){					
		element = driver.findElement(By.id("txtEIN2"));				
		return element;				
	}					
	
	/**
	 * EIN 2 txtbx.
	 *
	 * @return the string
	 */
	public static String EIN2_txtbx(){					
		id = "txtEIN2";				
		return id;				
	}	
	
	/**
	 * EIN 3 txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// EIN3 txtbx					
	public static WebElement EIN3_txtbx(WebDriver driver){					
		element = driver.findElement(By.id("txtEIN3"));				
		return element;				
	}					
	
	/**
	 * EIN 3 txtbx.
	 *
	 * @return the string
	 */
	public static String EIN3_txtbx(){					
		id = "txtEIN3";				
		return id;				
	}	
	
	/**
	 * EIN 4 txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// EIN4 txtbx					
	public static WebElement EIN4_txtbx(WebDriver driver){					
		element = driver.findElement(By.id("txtEIN4"));				
		return element;				
	}					
	
	/**
	 * EIN 4 txtbx.
	 *
	 * @return the string
	 */
	public static String EIN4_txtbx(){					
		id = "txtEIN4";				
		return id;				
	}	
	
	/**
	 * EIN 5 txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// EIN5 txtbx					
	public static WebElement EIN5_txtbx(WebDriver driver){					
		element = driver.findElement(By.id("txtEIN5"));				
		return element;				
	}					
	
	/**
	 * EIN 5 txtbx.
	 *
	 * @return the string
	 */
	public static String EIN5_txtbx(){					
		id = "txtEIN5";				
		return id;				
	}	
	
	/**
	 * EIN 6 txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// EIN6 txtbx					
	public static WebElement EIN6_txtbx(WebDriver driver){					
		element = driver.findElement(By.id("txtEIN6"));				
		return element;				
	}					
	
	/**
	 * EIN 6 txtbx.
	 *
	 * @return the string
	 */
	public static String EIN6_txtbx(){					
		id = "txtEIN6";				
		return id;				
	}	
	
	/**
	 * EIN 7 txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// EIN7 txtbx					
	public static WebElement EIN7_txtbx(WebDriver driver){					
		element = driver.findElement(By.id("txtEIN7"));				
		return element;				
	}					
	
	/**
	 * EIN 7 txtbx.
	 *
	 * @return the string
	 */
	public static String EIN7_txtbx(){					
		id = "txtEIN7";				
		return id;				
	}	
	
	/**
	 * EIN 8 txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// EIN8 txtbx					
	public static WebElement EIN8_txtbx(WebDriver driver){					
		element = driver.findElement(By.id("txtEIN8"));				
		return element;				
	}					
	
	/**
	 * EIN 8 txtbx.
	 *
	 * @return the string
	 */
	public static String EIN8_txtbx(){					
		id = "txtEIN8";				
		return id;				
	}	
	
	/**
	 * EIN 9 txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// EIN9 txtbx					
	public static WebElement EIN9_txtbx(WebDriver driver){					
		element = driver.findElement(By.id("txtEIN9"));				
		return element;				
	}					
	
	/**
	 * EIN 9 txtbx.
	 *
	 * @return the string
	 */
	public static String EIN9_txtbx(){					
		id = "txtEIN9";				
		return id;				
	}
	
	/**
	 * Cross out item 2 chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Cross out item 2 checkbox					
	public static WebElement crossOutItem2_chkbx(WebDriver driver){					
		element = driver.findElement(By.id("chkCrossOutItem2"));				
		return element;				
	}					
	
	/**
	 * Cross out item 2 chkbx.
	 *
	 * @return the string
	 */
	public static String crossOutItem2_chkbx(){					
		id = "chkCrossOutItem2";				
		return id;				
	}
	
	/**
	 * Signature of US person txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Signature of US person textbox				
	public static WebElement signatureOfUSPerson_txtbx(WebDriver driver){					
		element = driver.findElement(By.id("txtSignature"));				
		return element;				
	}					
	
	/**
	 * Signature of US person txtbx.
	 *
	 * @return the string
	 */
	public static String signatureOfUSPerson_txtbx(){					
		id = "txtSignature";				
		return id;				
	}
	
	/**
	 * Date txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Date textbox				
	public static WebElement date_txtbx(WebDriver driver){					
		element = driver.findElement(By.id("txtSignatureDate"));				
		return element;				
	}					
	
	/**
	 * Date txtbx.
	 *
	 * @return the string
	 */
	public static String date_txtbx(){					
		id = "txtSignatureDate";				
		return id;				
	}
	
	/**
	 * Cancel btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Cancel button			
	public static WebElement cancel_btn(WebDriver driver){					
		element = driver.findElement(By.id("btnCancel"));				
		return element;				
	}					
	
	/**
	 * Cancel btn.
	 *
	 * @return the string
	 */
	public static String cancel_btn(){					
		id = "btnCancel";				
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
		element = driver.findElement(By.id("btnSave"));				
		return element;				
	}					
	
	/**
	 * Save btn.
	 *
	 * @return the string
	 */
	public static String save_btn(){					
		id = "btnSave";				
		return id;				
	}
	
	/**
	 * Cancel save changes btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Cancel save changes button
	public static WebElement cancelSaveChanges_btn(WebDriver driver){					
		element = driver.findElement(By.id("sbdmButton3"));				
		return element;				
	}					
	
	/**
	 * Cancel save changes btn.
	 *
	 * @return the string
	 */
	public static String cancelSaveChanges_btn(){					
		id = "sbdmButton3";				
		return id;				
	}
	
	/**
	 * No save changes btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// No save changes button
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
	 * Yes save changes btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Yes save changes button
	public static WebElement yesSaveChanges_btn(WebDriver driver){					
		element = driver.findElement(By.id("sbdmButton1"));				
		return element;				
	}					
	
	/**
	 * Yes save changes btn.
	 *
	 * @return the string
	 */
	public static String yesSaveChanges_btn(){					
		id = "sbdmButton1";				
		return id;				
	}
	
	/**
	 * Message dialog.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Message dialog
	public static WebElement message_dialog(WebDriver driver){					
		element = driver.findElement(By.id("divMessageOK"));				
		return element;				
	}					
	
	/**
	 * Message dialog.
	 *
	 * @return the string
	 */
	public static String message_dialog(){					
		id = "divMessageOK";				
		return id;				
	}
	
	/**
	 * Ok almost done btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// OK Almost done button
	public static WebElement okAlmostDone_btn(WebDriver driver){					
		element = driver.findElement(By.id("sbdmButton1"));				
		return element;				
	}					
	
	/**
	 * Ok almost done btn.
	 *
	 * @return the string
	 */
	public static String okAlmostDone_btn(){					
		id = "sbdmButton1";				
		return id;				
	}
	
	/**
	 * Delete W 9 btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Delete W9 button
	public static WebElement deleteW9_btn(WebDriver driver){					
		element = driver.findElement(By.cssSelector("#tblW9 > tbody > tr > td:nth-child(8) > img"));				
		return element;				
	}					
	
	/**
	 * Delete W 9 btn.
	 *
	 * @return the string
	 */
	public static String deleteW9_btn(){					
		cssSelector = "#tblW9 > tbody > tr > td:nth-child(8) > img";				
		return cssSelector;				
	}
	
	/**
	 * Edits the W 9 btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Edit W9 button
	public static WebElement editW9_btn(WebDriver driver){					
		element = driver.findElement(By.cssSelector("#tblW9 > tbody > tr > td:nth-child(7) > img"));				
		return element;				
	}					
	
	/**
	 * Edits the W 9 btn.
	 *
	 * @return the string
	 */
	public static String editW9_btn(){					
		cssSelector = "#tblW9 > tbody > tr > td:nth-child(7) > img";				
		return cssSelector;				
	}
	
	/**
	 * enterYourW9Information_txt
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// OK Almost done button
	public static WebElement enterYourW9Information_txt(WebDriver driver){					
		element = driver.findElement(By.id("divDialogIntro"));				
		return element;				
	}					
	
	/**
	 * enterYourW9Information_txt
	 *
	 * @return the string
	 */
	public static String enterYourW9Information_txt(){					
		id = "divDialogIntro";				
		return id;				
	}
	
}
