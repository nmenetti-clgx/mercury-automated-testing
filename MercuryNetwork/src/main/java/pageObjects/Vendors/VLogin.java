package pageObjects.Vendors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Vendors Login page
 */
public class VLogin {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	/** The css selector. */
	private static String cssSelector = null;
	
	/** The link text. */
	private static String linkText = null;

	
	/**
	 * Email txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// email text box
	public static WebElement email_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_txtEmail"));
		return element;
	}
	
	/**
	 * Email txtbx.
	 *
	 * @return the string
	 */
	public static String email_txtbx(){
		id = "Main_Main_txtEmail";
		return id;
	}
	
	/**
	 * Password txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// password text box
	public static WebElement password_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_txtPassword"));
		return element;
	}
	
	/**
	 * Password txtbx.
	 *
	 * @return the string
	 */
	public static String password_txtbx(){
		id = "Main_Main_txtPassword";
		return id;
	}
	
	/**
	 * Sign in btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// sign in button
	public static WebElement signIn_btn(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_btnSignIn"));
		return element;
	}
	
	/**
	 * Sign in btn.
	 *
	 * @return the string
	 */
	public static String signIn_btn(){
		id = "Main_Main_btnSignIn";
		return id;
	}
	
	/**
	 * Remember me chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// remember me checkbox
	public static WebElement rememberMe_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_cbRememberMe"));
		return element;
	}
	
	/**
	 * Remember me chkbx.
	 *
	 * @return the string
	 */
	public static String rememberMe_chkbx(){
		id = "Main_Main_cbRememberMe";
		return id;
	}
	
	/**
	 * Forgot password lnk.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// forgot your password link
	public static WebElement forgotPassword_lnk(WebDriver driver){
		element = driver.findElement(By.linkText("Forgot your password?"));
		return element;
	}
	
	/**
	 * Forgot password lnk.
	 *
	 * @return the string
	 */
	public static String forgotPassword_lnk(){
		linkText = "Forgot your password?";
		return linkText;
	}
	
	/**
	 * Sign up btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// sign up button
	public static WebElement signUp_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("input[value=\"Sign Up\"][type=button]"));
		return element;
	}
	
	/**
	 * Sign up btn.
	 *
	 * @return the string
	 */
	public static String signUp_btn(){
		cssSelector = "input[value=\"Sign Up\"][type=button]";
		return cssSelector;
	}
	
	/**
	 * Send email lnk.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// click here to send an e-mail link
	public static WebElement sendEmail_lnk(WebDriver driver){
		element = driver.findElement(By.linkText("click here to send an e-mail"));
		return element;
	}
	
	/**
	 * Send email lnk.
	 *
	 * @return the string
	 */
	public static String sendEmail_lnk(){
		linkText = "click here to send an e-mail";
		return linkText;
	}
	
	/**
	 * Terms of use lnk.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// terms of use link
	public static WebElement termsOfUse_lnk(WebDriver driver){
		element = driver.findElement(By.linkText("Terms of Use"));
		return element;
	}
	
	/**
	 * Terms of use lnk.
	 *
	 * @return the string
	 */
	public static String termsOfUse_lnk(){
		linkText = "Terms of Use";
		return linkText;
	}
	
	/**
	 * Login error txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// login error text
	public static WebElement loginError_txt(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_pnlError"));
		return element;
	}
	
	/**
	 * Login error txt.
	 *
	 * @return the string
	 */
	public static String loginError_txt(){
		id = "Main_Main_pnlError";
		return id;
	}
	
	/**
	 * Invalid information dialog txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// invalid information dialog text
	public static WebElement invalidInformationDialog_txt(WebDriver driver){
		element = driver.findElement(By.id("SummaryDialog"));
		return element;
	}
	
	/**
	 * Invalid information dialog txt.
	 *
	 * @return the string
	 */
	public static String invalidInformationDialog_txt(){
		id = "SummaryDialog";
		return id;
	}
	
	/**
	 * Ok btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Ok button
	public static WebElement ok_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("input[value='OK'][onclick='javascript:HideSummaryDialog();']"));
		return element;
	}
	
	/**
	 * Ok btn.
	 *
	 * @return the string
	 */
	public static String ok_btn(){
		cssSelector = "input[value='OK'][onclick='javascript:HideSummaryDialog();']";
		return cssSelector;
	}
	
	
	/**
	 * @param driver
	 * @return the web element
	 */
	public static WebElement emailSignup_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_Main_wizSignUp_ctl07_ctlAccountSearchCriteria_txtEmail"));
		return element;
}

	/**
	 * @return the string
	 */
	public static String emailSignup_txtbx(){
		id = "Main_Main_Main_wizSignUp_ctl07_ctlAccountSearchCriteria_txtEmail";
		return id;
		
}
}