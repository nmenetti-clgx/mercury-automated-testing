package pageObjects.Secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The elements on the Secure Login page
 */
public class SLogin {
	
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
	 * Sign up btn.
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	// Sign Up button
	public static WebElement signUp_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("input[value='Sign Up']"));
		return element;
	}
	
	/**
	 * Sign up btn.
	 *
	 * @return the string
	 */
	public static String signUp_btn(){
		cssSelector = "input[value='Sign Up']";
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
	 * chat window dialog
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement chatWindowDialog(WebDriver driver){
		element = driver.findElement(By.id("SnapABug_P"));
		return element;
	}
	
	/**
	 * chat window dialog
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement chatWindowDialogTitle_txt(WebDriver driver){
		element = driver.findElement(By.id("pcTitle"));
		return element;
	}
	
	/**
	 * Name textbox
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement chatWindowName_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Name"));
		return element;
	}
	
	/**
	 * Email textbox
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement chatWindowEmail_txtbx(WebDriver driver){
		element = driver.findElement(By.id("email"));
		return element;
	}
	
	/**
	 * Phone textbox
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement chatWindowPhone_txtbx(WebDriver driver){
		element = driver.findElement(By.id("Number"));
		return element;
	}
	
	/**
	 * Question textbox
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement chatWindowQuestion_txtbx(WebDriver driver){
		element = driver.findElement(By.cssSelector("textarea[name='description']"));
		return element;
	}
	
	/**
	 * EmailUs button
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement chatWindowEmailUs_btn(WebDriver driver){
		element = driver.findElement(By.id("SnapABug_OSB"));
		return element;
	}
	
	/**
	 * ChatWithUs button
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement chatWindowChatWithUs_btn(WebDriver driver){
		element = driver.findElement(By.id("SnapABug_OCB"));
		return element;
	}
	
	/**
	 * Email text
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement chatWindowEmail_txt(WebDriver driver){
		element = driver.findElement(By.id("SnapABug_email"));
		return element;
	}
	
	/**
	 * Phone text
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement chatWindowPhone_txt(WebDriver driver){
		element = driver.findElement(By.id("SnapABug_Number"));
		return element;
	}
	
	/**
	 * Question text
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement chatWindowQuestion_txt(WebDriver driver){
		element = driver.findElement(By.id("SnapABug_desc"));
		return element;
	}
	
	/**
	 * Chat with us close button
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement chatWindowClose_btn(WebDriver driver){
		element = driver.findElement(By.cssSelector("div[title='Close']"));
		return element;
	}
	
	/**
	 * Chat with us now link
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement chatWithUsNow_link(WebDriver driver){
		element = driver.findElement(By.linkText("chat with us now"));
		return element;
	}
	
	/**
	 * Terms of use link
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement termsOfUse_link(WebDriver driver){
		element = driver.findElement(By.linkText("Terms of Use"));
		return element;
	}
	
	/**
	 * Forgot your password link
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement forgotYourPassword_link(WebDriver driver){
		element = driver.findElement(By.linkText("Forgot your password?"));
		return element;
	}
	
	/**
	 * Remember me checkbox
	 *
	 * @param driver the driver
	 * @return the web element
	 */
	public static WebElement rememberMe_chkbx(WebDriver driver){
		element = driver.findElement(By.id("Main_Main_cbRememberMe"));
		return element;
	}
	
}
