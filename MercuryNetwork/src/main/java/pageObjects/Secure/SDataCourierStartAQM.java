package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure Data Courier Start AQM page
 */
public class SDataCourierStartAQM {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	/** The css selector. */
	private static String cssSelector = null;

	
	/**
	 * Agree btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Agree button
	public static WebElement agree_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("input[onclick='HideDialog(); toolbar_AQMRequest('agree');']"));
		return element;
	}
	
	/**
	 * Agree btn.
	 *
	 * @return the string
	 */
	public static String agree_btn(){
		cssSelector = "input[onclick='HideDialog(); toolbar_AQMRequest('agree');']";
		return cssSelector;
	}
	
	/**
	 * Qc this appraisal btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// QC this appraisal button
	public static WebElement qcThisAppraisal_btn(WebDriver driver){
		element = driver.findElement(By.id("imgQCThisAppraisal"));
		return element;
	}
	
	/**
	 * Qc this appraisal btn.
	 *
	 * @return the string
	 */
	public static String qcThisAppraisal_btn(){
		id = "imgQCThisAppraisal";
		return id;
	}
	
	/**
	 * Aqm QC module chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// AQM QC module checkbox
	public static WebElement aqmQCModule_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_ctlAQMModulesList_gvAQMModules_imgProduct_1"));
		return element;
	}
	
	/**
	 * Aqm QC module chkbx.
	 *
	 * @return the string
	 */
	public static String aqmQCModule_chkbx(){
		id = "Main_ctlAQMModulesList_gvAQMModules_imgProduct_1";
		return id;
	}
	
	/**
	 * Appraisal quality index chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Appraisal Quality Index checkbox
	public static WebElement appraisalQualityIndex_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_ctlAQMModulesList_gvAQMModules_imgProduct_0"));
		return element;
	}
	
	/**
	 * Appraisal quality index chkbx.
	 *
	 * @return the string
	 */
	public static String appraisalQualityIndex_chkbx(){
		id = "Main_ctlAQMModulesList_gvAQMModules_imgProduct_0";
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
		element = driver.findElement(By.id("Main_btnStartingAQMOK"));
		return element;
	}
	
	/**
	 * Ok btn.
	 *
	 * @return the string
	 */
	public static String ok_btn(){
		id = "Main_btnStartingAQMOK";
		return id;
	}
	
	/**
	 * Ok payment acknowledgement btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// OK Payment Acknowledgement button
	public static WebElement okPaymentAcknowledgement_btn(WebDriver driver){
		element = driver.findElement(By.id("Dialogs_sbPaymentAckOK"));
		return element;
	}
	
	/**
	 * Ok payment acknowledgement btn.
	 *
	 * @return the string
	 */
	public static String okPaymentAcknowledgement_btn(){
		id = "Dialogs_sbPaymentAckOK";
		return id;
	}
	
}
