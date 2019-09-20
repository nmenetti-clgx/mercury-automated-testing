package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure Add Company page
 */
public class SClients_AddCompany {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	/** The css selector. */
	private static String cssSelector = null;

	
	/**
	 * Agent chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// agent chkbx	
	public static WebElement agent_chkbx(WebDriver driver){	
		element = driver.findElement(By.id("CheckBoxAgent"));
		return element;
	}	
	
	/**
	 * Agent chkbx.
	 *
	 * @return the string
	 */
	public static String agent_chkbx(){	
		id = "CheckBoxAgent";
		return id;
	}	
		
	/**
	 * Client chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// client chkbx	
	public static WebElement client_chkbx(WebDriver driver){	
		element = driver.findElement(By.id("CheckBoxClient"));
		return element;
	}	
	
	/**
	 * Client chkbx.
	 *
	 * @return the string
	 */
	public static String client_chkbx(){	
		id = "CheckBoxClient";
		return id;
	}	
		
	/**
	 * Other chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// other chkbx	
	public static WebElement other_chkbx(WebDriver driver){	
		element = driver.findElement(By.id("CheckBoxOther"));
		return element;
	}	
	
	/**
	 * Other chkbx.
	 *
	 * @return the string
	 */
	public static String other_chkbx(){	
		id = "CheckBoxOther";
		return id;
	}	
		
	/**
	 * Appraiser chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// appraiser chkbx	
	public static WebElement appraiser_chkbx(WebDriver driver){	
		element = driver.findElement(By.id("CheckBoxAppraiser"));
		return element;
	}	
	
	/**
	 * Appraiser chkbx.
	 *
	 * @return the string
	 */
	public static String appraiser_chkbx(){	
		id = "CheckBoxAppraiser";
		return id;
	}	
		
	/**
	 * Lender chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// lender chkbx	
	public static WebElement lender_chkbx(WebDriver driver){	
		element = driver.findElement(By.id("CheckBoxLender"));
		return element;
	}	
	
	/**
	 * Lender chkbx.
	 *
	 * @return the string
	 */
	public static String lender_chkbx(){	
		id = "CheckBoxLender";
		return id;
	}	
		
	/**
	 * Owner chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// owner chkbx	
	public static WebElement owner_chkbx(WebDriver driver){	
		element = driver.findElement(By.id("CheckBoxOwner"));
		return element;
	}	
	
	/**
	 * Owner chkbx.
	 *
	 * @return the string
	 */
	public static String owner_chkbx(){	
		id = "CheckBoxOwner";
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
		element = driver.findElement(By.id("txtCompany"));
		return element;
	}	
	
	/**
	 * Company txtbx.
	 *
	 * @return the string
	 */
	public static String company_txtbx(){	
		id = "txtCompany";
		return id;
	}	
		
	/**
	 * Branch txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// branch txtbx	
	public static WebElement branch_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("txtBranch"));
		return element;
	}	
	
	/**
	 * Branch txtbx.
	 *
	 * @return the string
	 */
	public static String branch_txtbx(){	
		id = "txtBranch";
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
		element = driver.findElement(By.id("txtEmail"));
		return element;
	}	
	
	/**
	 * Email txtbx.
	 *
	 * @return the string
	 */
	public static String email_txtbx(){	
		id = "txtEmail";
		return id;
	}	
		
	/**
	 * Website txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// website txtbx	
	public static WebElement website_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("txtWebsite"));
		return element;
	}	
	
	/**
	 * Website txtbx.
	 *
	 * @return the string
	 */
	public static String website_txtbx(){	
		id = "txtWebsite";
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
		element = driver.findElement(By.id("txtNotes"));
		return element;
	}	
	
	/**
	 * Notes txtbx.
	 *
	 * @return the string
	 */
	public static String notes_txtbx(){	
		id = "txtNotes";
		return id;
	}	
		
	/**
	 * Address 1 txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// address1 txtbx	
	public static WebElement address1_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("txtAddress1"));
		return element;
	}	
	
	/**
	 * Address 1 txtbx.
	 *
	 * @return the string
	 */
	public static String address1_txtbx(){	
		id = "txtAddress1";
		return id;
	}	
		
	/**
	 * Address 2 txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// address2 txtbx	
	public static WebElement address2_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("txtAddress2"));
		return element;
	}	
	
	/**
	 * Address 2 txtbx.
	 *
	 * @return the string
	 */
	public static String address2_txtbx(){	
		id = "txtAddress2";
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
		element = driver.findElement(By.id("txtCity"));
		return element;
	}	
	
	/**
	 * City txtbx.
	 *
	 * @return the string
	 */
	public static String city_txtbx(){	
		id = "txtCity";
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
		element = driver.findElement(By.id("txtState"));
		return element;
	}	
	
	/**
	 * State txtbx.
	 *
	 * @return the string
	 */
	public static String state_txtbx(){	
		id = "txtState";
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
		element = driver.findElement(By.id("txtZipCode"));
		return element;
	}	
	
	/**
	 * Zip txtbx.
	 *
	 * @return the string
	 */
	public static String zip_txtbx(){	
		id = "txtZipCode";
		return id;
	}	
		
	/**
	 * Country dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// country dropdown	
	public static WebElement country_dropdown(WebDriver driver){	
		element = driver.findElement(By.id("ddlCountry"));
		return element;
	}	
	
	/**
	 * Country dropdown.
	 *
	 * @return the string
	 */
	public static String country_dropdown(){	
		id = "ddlCountry";
		return id;
	}	
		
	/**
	 * Business txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// business txtbx	
	public static WebElement business_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("txtPhonePhone"));
		return element;
	}	
	
	/**
	 * Business txtbx.
	 *
	 * @return the string
	 */
	public static String business_txtbx(){	
		id = "txtPhonePhone";
		return id;
	}	
		
	/**
	 * Business extension txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// businessExtension txtbx	
	public static WebElement businessExtension_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("txtPhoneExtension"));
		return element;
	}	
	
	/**
	 * Business extension txtbx.
	 *
	 * @return the string
	 */
	public static String businessExtension_txtbx(){	
		id = "txtPhoneExtension";
		return id;
	}	
		
	/**
	 * Business primary radiobtn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// businessPrimary radiobtn	
	public static WebElement businessPrimary_radiobtn(WebDriver driver){	
		element = driver.findElement(By.id("rdoPrimary_Phone"));
		return element;
	}	
	
	/**
	 * Business primary radiobtn.
	 *
	 * @return the string
	 */
	public static String businessPrimary_radiobtn(){	
		id = "rdoPrimary_Phone";
		return id;
	}	
		
	/**
	 * Alternate txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// alternate txtbx	
	public static WebElement alternate_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("txtAltPhone"));
		return element;
	}	
	
	/**
	 * Alternate txtbx.
	 *
	 * @return the string
	 */
	public static String alternate_txtbx(){	
		id = "txtAltPhone";
		return id;
	}	
		
	/**
	 * Alternate extension txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// alternateExtension txtbx	
	public static WebElement alternateExtension_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("txtAltPhoneExtension"));
		return element;
	}	
	
	/**
	 * Alternate extension txtbx.
	 *
	 * @return the string
	 */
	public static String alternateExtension_txtbx(){	
		id = "txtAltPhoneExtension";
		return id;
	}	
		
	/**
	 * Alternate primary radiobtn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// alternatePrimary radiobtn	
	public static WebElement alternatePrimary_radiobtn(WebDriver driver){	
		element = driver.findElement(By.id("rdoPrimary_AltPhone"));
		return element;
	}	
	
	/**
	 * Alternate primary radiobtn.
	 *
	 * @return the string
	 */
	public static String alternatePrimary_radiobtn(){	
		id = "rdoPrimary_AltPhone";
		return id;
	}	
		
	/**
	 * Fax txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// fax txtbx	
	public static WebElement fax_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("txtFaxPhone"));
		return element;
	}	
	
	/**
	 * Fax txtbx.
	 *
	 * @return the string
	 */
	public static String fax_txtbx(){	
		id = "txtFaxPhone";
		return id;
	}	
		
	/**
	 * Fax extension txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// faxExtension txtbx	
	public static WebElement faxExtension_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("txtFaxExtension"));
		return element;
	}	
	
	/**
	 * Fax extension txtbx.
	 *
	 * @return the string
	 */
	public static String faxExtension_txtbx(){	
		id = "txtFaxExtension";
		return id;
	}	
		
	/**
	 * Fax primary radiobtn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// faxPrimary radiobtn	
	public static WebElement faxPrimary_radiobtn(WebDriver driver){	
		element = driver.findElement(By.id("rdoPrimary_Fax"));
		return element;
	}	
	
	/**
	 * Fax primary radiobtn.
	 *
	 * @return the string
	 */
	public static String faxPrimary_radiobtn(){	
		id = "rdoPrimary_Fax";
		return id;
	}	
		
	/**
	 * Mobile txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// mobile txtbx	
	public static WebElement mobile_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("txtMobilePhone"));
		return element;
	}	
	
	/**
	 * Mobile txtbx.
	 *
	 * @return the string
	 */
	public static String mobile_txtbx(){	
		id = "txtMobilePhone";
		return id;
	}	
		
	/**
	 * Mobile extension txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// mobileExtension txtbx	
	public static WebElement mobileExtension_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("txtMobileExtension"));
		return element;
	}	
	
	/**
	 * Mobile extension txtbx.
	 *
	 * @return the string
	 */
	public static String mobileExtension_txtbx(){	
		id = "txtMobileExtension";
		return id;
	}	
		
	/**
	 * Mobile primary radiobtn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// mobilePrimary radiobtn	
	public static WebElement mobilePrimary_radiobtn(WebDriver driver){	
		element = driver.findElement(By.id("rdoPrimary_Mobile"));
		return element;
	}	
	
	/**
	 * Mobile primary radiobtn.
	 *
	 * @return the string
	 */
	public static String mobilePrimary_radiobtn(){	
		id = "rdoPrimary_Mobile";
		return id;
	}	
		
	/**
	 * Save btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// save btn	
	public static WebElement save_btn(WebDriver driver){	
//		element = driver.findElement(By.cssSelector("img[src='images/buttons/Save.gif']"));
		element = driver.findElement(By.id("tdSave"));
		return element;
	}	
	
	/**
	 * Save btn.
	 *
	 * @return the string
	 */
	public static String save_btn(){	
//		cssSelector = "img[src='images/buttons/Save.gif']";
//		return cssSelector;
		id = "tdSave";
		return id;
	}	
		
	/**
	 * Exit btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// exit btn	
	public static WebElement exit_btn(WebDriver driver){	
		element = driver.findElement(By.cssSelector("img[src='images/buttons/Exit.gif']"));
		return element;
	}	
	
	/**
	 * Exit btn.
	 *
	 * @return the string
	 */
	public static String exit_btn(){	
		cssSelector = "img[src='images/buttons/Exit.gif']";
		return cssSelector;
	}	
		
	/**
	 * Shared chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// shared chkbx	
	public static WebElement shared_chkbx(WebDriver driver){	
		element = driver.findElement(By.id("chkPublic"));
		return element;
	}	
	
	/**
	 * Shared chkbx.
	 *
	 * @return the string
	 */
	public static String shared_chkbx(){	
		id = "chkPublic";
		return id;
	}	
		
	/**
	 * Ad hoc chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// adHoc chkbx	
	public static WebElement adHoc_chkbx(WebDriver driver){	
		element = driver.findElement(By.id("chkAdHoc"));
		return element;
	}	
	
	/**
	 * Ad hoc chkbx.
	 *
	 * @return the string
	 */
	public static String adHoc_chkbx(){	
		id = "chkAdHoc";
		return id;
	}	
	
}
