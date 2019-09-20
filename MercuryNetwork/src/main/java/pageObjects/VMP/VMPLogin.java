package pageObjects.VMP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the VMP Login page
 */
public class VMPLogin {
	
	/** The element. */
	private static WebElement element = null;
	
	/** The id. */
	private static String id = null;
	
	/** The class name. */
	private static String className = null;
	
	/** The xpath. */
	private static String xpath = null;
	
	/** The css selector. */
	private static String cssSelector = null;

	
	/**
	 * Email txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Username text box
	public static WebElement email_txtbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtUsername"));
		return element;
	}
	
	/**
	 * Email txtbx.
	 *
	 * @return the string
	 */
	public static String email_txtbx(){
		id = "ctl00_ctl00_Main_Main_txtUsername";
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
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_txtPassword"));
		return element;
	}
	
	/**
	 * Password txtbx.
	 *
	 * @return the string
	 */
	public static String password_txtbx(){
		id = "ctl00_ctl00_Main_Main_txtPassword";
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
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_btnSignIn"));
		return element;
	}
	
	/**
	 * Sign in btn.
	 *
	 * @return the string
	 */
	public static String signIn_btn(){
		id = "ctl00_ctl00_Main_Main_btnSignIn";
		return id;
	}
	
	/**
	 * Sign up btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// sign up button
	public static WebElement signUp_btn(WebDriver driver){
		element = driver.findElement(By.id("SignUpLink"));
		return element;
	}
	
	/**
	 * Sign up btn.
	 *
	 * @return the string
	 */
	public static String signUp_btn(){
		id = "SignUpLink";
		return id;
	}
	
	/**
	 * Contacts entry txtbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// contacts entry text box
	public static WebElement contactsEntry_txtbx(WebDriver driver){
		element = driver.findElement(By.className("contactEntry"));
		return element;
	}
	
	/**
	 * Contacts entry txtbx.
	 *
	 * @return the string
	 */
	public static String contactsEntry_txtbx(){
		className = "contactEntry";
		return className;
	}
	
	/**
	 * Close did you know popup btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// close Did You Know popup
	public static WebElement closeDidYouKnowPopup_btn(WebDriver driver){
		element = driver.findElement(By.xpath(".//*[@id='header_didYouMean']/a"));
		return element;
	}
	
	/**
	 * Close did you know popup btn.
	 *
	 * @return the string
	 */
	public static String closeDidYouKnowPopup_btn(){
		xpath = ".//*[@id='header_didYouMean']/a";
		return xpath;
	}
	
	/**
	 * Contact info txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// contact info text
	public static WebElement contactInfo_txt(WebDriver driver){
		element = driver.findElement(By.cssSelector(".contactInfoDisplay"));
		return element;
	}
	
	/**
	 * Contact info txt.
	 *
	 * @return the string
	 */
	public static String contactInfo_txt(){
		cssSelector = ".contactInfoDisplay";
		return cssSelector;
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
		element = driver.findElement(By.id("AlertDialog"));
		return element;
	}
	
	/**
	 * Invalid information dialog txt.
	 *
	 * @return the string
	 */
	public static String invalidInformationDialog_txt(){
		id = "AlertDialog";
		return id;
	}
	
	/**
	 * Invalid information dialog 2 txt.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// invalid information dialog text
	public static WebElement invalidInformationDialog2_txt(WebDriver driver){
		element = driver.findElement(By.id("SummaryDialog"));
		return element;
	}
	
	/**
	 * Invalid information dialog 2 txt.
	 *
	 * @return the string
	 */
	public static String invalidInformationDialog2_txt(){
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
	 * Ok btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Ok button
	public static WebElement ok2_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("#AlertDialog > div.MsgBoxContent > div > input[type=\"button\"]"));
		return element;
	}
	
	/**
	 * Remember me chkbx.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement rememberMe_chkbx(WebDriver driver){
		element = driver.findElement(By.id("ctl00_ctl00_Main_Main_cbRememberMe"));
		return element;
	}
	
	/**
	 * Powered by Mercury Network btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement poweredByMercuryNetwork_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("div.Footer > a:nth-child(1) > img"));
		return element;
	}
	
}
