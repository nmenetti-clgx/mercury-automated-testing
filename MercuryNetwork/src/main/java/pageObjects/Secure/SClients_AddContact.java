package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure Add Contact page
 */
public class SClients_AddContact {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	/** The css selector. */
	private static String cssSelector = null;


	/**
	 * Appraiser chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// appraiser chkbx	
	public static WebElement appraiser_chkbx(WebDriver driver){	
		element = driver.findElement(By.id("ucContactsOverview_CO_CheckBoxAppraiser"));
		return element;
	}	
	
	/**
	 * Appraiser chkbx.
	 *
	 * @return the string
	 */
	public static String appraiser_chkbx(){	
		id = "ucContactsOverview_CO_CheckBoxAppraiser";
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
		element = driver.findElement(By.id("ucContactsOverview_CO_CheckBoxClient"));
		return element;
	}	
	
	/**
	 * Client chkbx.
	 *
	 * @return the string
	 */
	public static String client_chkbx(){	
		id = "ucContactsOverview_CO_CheckBoxClient";
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
		element = driver.findElement(By.id("ucContactsOverview_CO_CheckBoxLender"));
		return element;
	}	
	
	/**
	 * Lender chkbx.
	 *
	 * @return the string
	 */
	public static String lender_chkbx(){	
		id = "ucContactsOverview_CO_CheckBoxLender";
		return id;
	}	
		
	/**
	 * Agent chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// agent chkbx	
	public static WebElement agent_chkbx(WebDriver driver){	
		element = driver.findElement(By.id("ucContactsOverview_CO_CheckBoxAgent"));
		return element;
	}	
	
	/**
	 * Agent chkbx.
	 *
	 * @return the string
	 */
	public static String agent_chkbx(){	
		id = "ucContactsOverview_CO_CheckBoxAgent";
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
		element = driver.findElement(By.id("ucContactsOverview_CO_CheckBoxOwner"));
		return element;
	}	
	
	/**
	 * Owner chkbx.
	 *
	 * @return the string
	 */
	public static String owner_chkbx(){	
		id = "ucContactsOverview_CO_CheckBoxOwner";
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
		element = driver.findElement(By.id("ucContactsOverview_CO_CheckBoxOther"));
		return element;
	}	
	
	/**
	 * Other chkbx.
	 *
	 * @return the string
	 */
	public static String other_chkbx(){	
		id = "ucContactsOverview_CO_CheckBoxOther";
		return id;
	}	
		
	/**
	 * First txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// first txtbx	
	public static WebElement first_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("ucContactsOverview_txtFirst"));
		return element;
	}	
	
	/**
	 * First txtbx.
	 *
	 * @return the string
	 */
	public static String first_txtbx(){	
		id = "ucContactsOverview_txtFirst";
		return id;
	}	
		
	/**
	 * Middle txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// middle txtbx	
	public static WebElement middle_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("ucContactsOverview_txtMiddle"));
		return element;
	}	
	
	/**
	 * Middle txtbx.
	 *
	 * @return the string
	 */
	public static String middle_txtbx(){	
		id = "ucContactsOverview_txtMiddle";
		return id;
	}	
		
	/**
	 * Last txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// last txtbx	
	public static WebElement last_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("ucContactsOverview_txtLast"));
		return element;
	}	
	
	/**
	 * Last txtbx.
	 *
	 * @return the string
	 */
	public static String last_txtbx(){	
		id = "ucContactsOverview_txtLast";
		return id;
	}	
		
	/**
	 * Job title txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// jobTitle txtbx	
	public static WebElement jobTitle_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("ucContactsOverview_txtJobTitle"));
		return element;
	}	
	
	/**
	 * Job title txtbx.
	 *
	 * @return the string
	 */
	public static String jobTitle_txtbx(){	
		id = "ucContactsOverview_txtJobTitle";
		return id;
	}	
		
	/**
	 * Designation txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// designation txtbx	
	public static WebElement designation_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("ucContactsOverview_txtDesignation"));
		return element;
	}	
	
	/**
	 * Designation txtbx.
	 *
	 * @return the string
	 */
	public static String designation_txtbx(){	
		id = "ucContactsOverview_txtDesignation";
		return id;
	}	
		
	/**
	 * Salutation dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// salutation dropdown	
	public static WebElement salutation_dropdown(WebDriver driver){	
		element = driver.findElement(By.id("ucContactsOverview_ddlSalutation"));
		return element;
	}	
	
	/**
	 * Salutation dropdown.
	 *
	 * @return the string
	 */
	public static String salutation_dropdown(){	
		id = "ucContactsOverview_ddlSalutation";
		return id;
	}	
		
	/**
	 * Suffix dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// suffix dropdown	
	public static WebElement suffix_dropdown(WebDriver driver){	
		element = driver.findElement(By.id("ucContactsOverview_ddlSuffix"));
		return element;
	}	
	
	/**
	 * Suffix dropdown.
	 *
	 * @return the string
	 */
	public static String suffix_dropdown(){	
		id = "ucContactsOverview_ddlSuffix";
		return id;
	}	
		
	/**
	 * Use company address radiobtn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// useCompanyAddress radiobtn	
	public static WebElement useCompanyAddress_radiobtn(WebDriver driver){	
		element = driver.findElement(By.id("ucContactsOverview_rbcompanyaddress"));
		return element;
	}	
	
	/**
	 * Use company address radiobtn.
	 *
	 * @return the string
	 */
	public static String useCompanyAddress_radiobtn(){	
		id = "ucContactsOverview_rbcompanyaddress";
		return id;
	}	
		
	/**
	 * Use address below radiobtn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// useAddressBelow radiobtn	
	public static WebElement useAddressBelow_radiobtn(WebDriver driver){	
		element = driver.findElement(By.id("ucContactsOverview_rbaddressbelow"));
		return element;
	}	
	
	/**
	 * Use address below radiobtn.
	 *
	 * @return the string
	 */
	public static String useAddressBelow_radiobtn(){	
		id = "ucContactsOverview_rbaddressbelow";
		return id;
	}	
		
	/**
	 * Assign to company dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// assignToCompany dropdown	
	public static WebElement assignToCompany_dropdown(WebDriver driver){	
		element = driver.findElement(By.id("ucContactsOverview_ddlCompany"));
		return element;
	}	
	
	/**
	 * Assign to company dropdown.
	 *
	 * @return the string
	 */
	public static String assignToCompany_dropdown(){	
		id = "ucContactsOverview_ddlCompany";
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
		element = driver.findElement(By.id("ucContactsOverview_txtAddress1"));
		return element;
	}	
	
	/**
	 * Address 1 txtbx.
	 *
	 * @return the string
	 */
	public static String address1_txtbx(){	
		id = "ucContactsOverview_txtAddress1";
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
		element = driver.findElement(By.id("ucContactsOverview_txtAddress2"));
		return element;
	}	
	
	/**
	 * Address 2 txtbx.
	 *
	 * @return the string
	 */
	public static String address2_txtbx(){	
		id = "ucContactsOverview_txtAddress2";
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
		element = driver.findElement(By.id("ucContactsOverview_txtCity"));
		return element;
	}	
	
	/**
	 * City txtbx.
	 *
	 * @return the string
	 */
	public static String city_txtbx(){	
		id = "ucContactsOverview_txtCity";
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
		element = driver.findElement(By.id("ucContactsOverview_txtST"));
		return element;
	}	
	
	/**
	 * State txtbx.
	 *
	 * @return the string
	 */
	public static String state_txtbx(){	
		id = "ucContactsOverview_txtST";
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
		element = driver.findElement(By.id("ucContactsOverview_txtZip"));
		return element;
	}	
	
	/**
	 * Zip txtbx.
	 *
	 * @return the string
	 */
	public static String zip_txtbx(){	
		id = "ucContactsOverview_txtZip";
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
		element = driver.findElement(By.id("ucContactsOverview_ddlCountry"));
		return element;
	}	
	
	/**
	 * Country dropdown.
	 *
	 * @return the string
	 */
	public static String country_dropdown(){	
		id = "ucContactsOverview_ddlCountry";
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
		element = driver.findElement(By.id("ucContactsOverview_txtWebsite"));
		return element;
	}	
	
	/**
	 * Website txtbx.
	 *
	 * @return the string
	 */
	public static String website_txtbx(){	
		id = "ucContactsOverview_txtWebsite";
		return id;
	}	
		
	/**
	 * Work txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// work txtbx	
	public static WebElement work_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("ucContactsOverview_txtMailWork"));
		return element;
	}	
	
	/**
	 * Work txtbx.
	 *
	 * @return the string
	 */
	public static String work_txtbx(){	
		id = "ucContactsOverview_txtMailWork";
		return id;
	}	
		
	/**
	 * Work primary radiobtn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// workPrimary radiobtn	
	public static WebElement workPrimary_radiobtn(WebDriver driver){	
		element = driver.findElement(By.id("ucContactsOverview_rbMailWork"));
		return element;
	}	
	
	/**
	 * Work primary radiobtn.
	 *
	 * @return the string
	 */
	public static String workPrimary_radiobtn(){	
		id = "ucContactsOverview_rbMailWork";
		return id;
	}	
		
	/**
	 * Personal txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// personal txtbx	
	public static WebElement personal_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("ucContactsOverview_txtMailHome"));
		return element;
	}	
	
	/**
	 * Personal txtbx.
	 *
	 * @return the string
	 */
	public static String personal_txtbx(){	
		id = "ucContactsOverview_txtMailHome";
		return id;
	}	
		
	/**
	 * Personal primary radiobtn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// personalPrimary radiobtn	
	public static WebElement personalPrimary_radiobtn(WebDriver driver){	
		element = driver.findElement(By.id("ucContactsOverview_rbMailHome"));
		return element;
	}	
	
	/**
	 * Personal primary radiobtn.
	 *
	 * @return the string
	 */
	public static String personalPrimary_radiobtn(){	
		id = "ucContactsOverview_rbMailHome";
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
		element = driver.findElement(By.id("ucContactsOverview_txtBusinessNumber"));
		return element;
	}	
	
	/**
	 * Business txtbx.
	 *
	 * @return the string
	 */
	public static String business_txtbx(){	
		id = "ucContactsOverview_txtBusinessNumber";
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
		element = driver.findElement(By.id("ucContactsOverview_txtBusinessExt"));
		return element;
	}	
	
	/**
	 * Business extension txtbx.
	 *
	 * @return the string
	 */
	public static String businessExtension_txtbx(){	
		id = "ucContactsOverview_txtBusinessExt";
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
		element = driver.findElement(By.id("ucContactsOverview_rbBusiness"));
		return element;
	}	
	
	/**
	 * Business primary radiobtn.
	 *
	 * @return the string
	 */
	public static String businessPrimary_radiobtn(){	
		id = "ucContactsOverview_rbBusiness";
		return id;
	}	
		
	/**
	 * Home txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// home txtbx	
	public static WebElement home_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("ucContactsOverview_txtHomeNumber"));
		return element;
	}	
	
	/**
	 * Home txtbx.
	 *
	 * @return the string
	 */
	public static String home_txtbx(){	
		id = "ucContactsOverview_txtHomeNumber";
		return id;
	}	
		
	/**
	 * Home extension txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// homeExtension txtbx	
	public static WebElement homeExtension_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("ucContactsOverview_txtHomeExt"));
		return element;
	}	
	
	/**
	 * Home extension txtbx.
	 *
	 * @return the string
	 */
	public static String homeExtension_txtbx(){	
		id = "ucContactsOverview_txtHomeExt";
		return id;
	}	
		
	/**
	 * Home primary radiobtn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// homePrimary radiobtn	
	public static WebElement homePrimary_radiobtn(WebDriver driver){	
		element = driver.findElement(By.id("ucContactsOverview_rbHome"));
		return element;
	}	
	
	/**
	 * Home primary radiobtn.
	 *
	 * @return the string
	 */
	public static String homePrimary_radiobtn(){	
		id = "ucContactsOverview_rbHome";
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
		element = driver.findElement(By.id("ucContactsOverview_txtFaxNumber"));
		return element;
	}	
	
	/**
	 * Fax txtbx.
	 *
	 * @return the string
	 */
	public static String fax_txtbx(){	
		id = "ucContactsOverview_txtFaxNumber";
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
		element = driver.findElement(By.id("ucContactsOverview_txtFaxExt"));
		return element;
	}	
	
	/**
	 * Fax extension txtbx.
	 *
	 * @return the string
	 */
	public static String faxExtension_txtbx(){	
		id = "ucContactsOverview_txtFaxExt";
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
		element = driver.findElement(By.id("ucContactsOverview_rbFax"));
		return element;
	}	
	
	/**
	 * Fax primary radiobtn.
	 *
	 * @return the string
	 */
	public static String faxPrimary_radiobtn(){	
		id = "ucContactsOverview_rbFax";
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
		element = driver.findElement(By.id("ucContactsOverview_txtMobileNumber"));
		return element;
	}	
	
	/**
	 * Mobile txtbx.
	 *
	 * @return the string
	 */
	public static String mobile_txtbx(){	
		id = "ucContactsOverview_txtMobileNumber";
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
		element = driver.findElement(By.id("ucContactsOverview_txtMobileExt"));
		return element;
	}	
	
	/**
	 * Mobile extension txtbx.
	 *
	 * @return the string
	 */
	public static String mobileExtension_txtbx(){	
		id = "ucContactsOverview_txtMobileExt";
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
		element = driver.findElement(By.id("ucContactsOverview_rbMobile"));
		return element;
	}	
	
	/**
	 * Mobile primary radiobtn.
	 *
	 * @return the string
	 */
	public static String mobilePrimary_radiobtn(){	
		id = "ucContactsOverview_rbMobile";
		return id;
	}	
		
	/**
	 * Assistant txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// assistant txtbx	
	public static WebElement assistant_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("ucContactsOverview_txtAssistantNumber"));
		return element;
	}	
	
	/**
	 * Assistant txtbx.
	 *
	 * @return the string
	 */
	public static String assistant_txtbx(){	
		id = "ucContactsOverview_txtAssistantNumber";
		return id;
	}	
		
	/**
	 * Assistant extension txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// assistantExtension txtbx	
	public static WebElement assistantExtension_txtbx(WebDriver driver){	
		element = driver.findElement(By.id("ucContactsOverview_txtAssistantExt"));
		return element;
	}	
	
	/**
	 * Assistant extension txtbx.
	 *
	 * @return the string
	 */
	public static String assistantExtension_txtbx(){	
		id = "ucContactsOverview_txtAssistantExt";
		return id;
	}	
		
	/**
	 * Assistant primary radiobtn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// assistantPrimary radiobtn	
	public static WebElement assistantPrimary_radiobtn(WebDriver driver){	
		element = driver.findElement(By.id("ucContactsOverview_rbAssistant"));
		return element;
	}	
	
	/**
	 * Assistant primary radiobtn.
	 *
	 * @return the string
	 */
	public static String assistantPrimary_radiobtn(){	
		id = "ucContactsOverview_rbAssistant";
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
		element = driver.findElement(By.id("imgSave"));
		return element;							
	}								
	
	/**
	 * Save btn.
	 *
	 * @return the string
	 */
	public static String save_btn(){								
		id = "imgSave";							
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
	
	/**
	 * Xsite user dropdown.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// XSite User dropdown			
	public static WebElement xsiteUser_dropdown(WebDriver driver){								
		element = driver.findElement(By.id("ucContactsOverview_ddlXSiteUserAssignment"));							
		return element;							
	}								
	
	/**
	 * Xsite user dropdown.
	 *
	 * @return the string
	 */
	public static String xsiteUser_dropdown(){								
		id = "ucContactsOverview_ddlXSiteUserAssignment";							
		return id;							
	}	
	
	/**
	 * Username txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Username textbox		
	public static WebElement username_txtbx(WebDriver driver){								
		element = driver.findElement(By.id("ucContactsOverview_XLB_txtUserName"));							
		return element;							
	}								
	
	/**
	 * Username txtbx.
	 *
	 * @return the string
	 */
	public static String username_txtbx(){								
		id = "ucContactsOverview_XLB_txtUserName";							
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
		element = driver.findElement(By.id("ucContactsOverview_XLB_txtPassword"));							
		return element;							
	}								
	
	/**
	 * Password txtbx.
	 *
	 * @return the string
	 */
	public static String password_txtbx(){								
		id = "ucContactsOverview_XLB_txtPassword";							
		return id;							
	}	
	
	/**
	 * Confirm txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Confirm textbox	
	public static WebElement confirm_txtbx(WebDriver driver){								
		element = driver.findElement(By.id("ucContactsOverview_XLB_txtPassword2"));							
		return element;							
	}								
	
	/**
	 * Confirm txtbx.
	 *
	 * @return the string
	 */
	public static String confirm_txtbx(){								
		id = "ucContactsOverview_XLB_txtPassword2";							
		return id;							
	}	
	
	/**
	 * Permitted access to all X site orders chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Permitted access to ALL XSite orders
	public static WebElement permittedAccessToAllXSiteOrders_chkbx(WebDriver driver){								
		element = driver.findElement(By.id("ucContactsOverview_chkCreateSuperClient"));							
		return element;							
	}								
	
	/**
	 * Permitted access to all X site orders chkbx.
	 *
	 * @return the string
	 */
	public static String permittedAccessToAllXSiteOrders_chkbx(){								
		id = "ucContactsOverview_chkCreateSuperClient";							
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
		element = driver.findElement(By.id("btnOldMessage2"));							
		return element;							
	}								
	
	/**
	 * Yes btn.
	 *
	 * @return the string
	 */
	public static String yes_btn(){								
		id = "btnOldMessage2";							
		return id;							
	}	
	
	/**
	 * Contacts table txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Contacts Table text
	public static WebElement contactsTable_txt(WebDriver driver){								
		element = driver.findElement(By.id("Main_Main_grdContacts"));							
		return element;							
	}								
	
	/**
	 * Contacts table txt.
	 *
	 * @return the string
	 */
	public static String contactsTable_txt(){								
		id = "Main_Main_grdContacts";							
		return id;							
	}
	
}
