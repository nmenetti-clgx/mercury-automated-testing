package utils;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.apache.poi.EmptyFileException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import pageObjects.Overlay.Overlay;
import pageObjects.Secure.SOrderDetails;
import pageObjects.XSite.XOrders;

import com.google.common.net.InternetDomainName;
import com.jcabi.xml.XML;
import com.jcabi.xml.XMLDocument;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import setup.TestSetup;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

// TODO: Auto-generated Javadoc
/**
 * <h1>Function</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class Function extends TestSetup {

	/**
	 * Generate random letters
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Create a String with random letters based on the length given</li>
	 * </ul>
	 * @param driver The driver
	 * @param length The number of random letters to generate
	 * @return A String with random letters based on the length given
	 */
	public String randomLetters(RemoteWebDriver driver, int length) {

		String CHAR_LIST = 
				"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int RANDOM_STRING_LENGTH = length;

		StringBuffer randStr = new StringBuffer();
		for(int i=0; i<RANDOM_STRING_LENGTH; i++){
			Random value = new Random();
			int min = 0;
			int max = 51;
			int number = value.nextInt((max -  min) + 1) + min;
			char ch = CHAR_LIST.charAt(number);
			randStr.append(ch);
		}
		return randStr.toString();

	} // end randomLetters
	
	/**
	 * Generate unique timestamp
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Create a long with the unique timestamp</li>
	 * </ul>.
	 *
	 * @param driver The driver
	 * @return A String with random letters based on the length given
	 */
	public long getUniqueTimestamp(RemoteWebDriver driver) {

		AtomicLong LAST_TIME_MS = new AtomicLong();
		long now = System.currentTimeMillis();
	    while(true) {
	        long lastTime = LAST_TIME_MS.get();
	        if (lastTime >= now)
	            now = lastTime+1;
	        if (LAST_TIME_MS.compareAndSet(lastTime, now))
	            return now;
	    } // end while

	} // end getUniqueTimestamp

	/**
	 * Generate a random number
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Create a String with random letters based on the length given</li>
	 * </ul>
	 * @param driver The driver
	 * @param length The number of digits for the random number to generate
	 * @return A String with a random number based on the length given
	 */
	public String randomNumbers(RemoteWebDriver driver, int length) {

		String CHAR_LIST = 
				"123456789";
		int RANDOM_STRING_LENGTH = length;

		StringBuffer randStr = new StringBuffer();
		for(int i=0; i<RANDOM_STRING_LENGTH; i++){
			Random value = new Random();
			int min = 0;
			int max = 8;
			int number = value.nextInt((max -  min) + 1) + min;
			char ch = CHAR_LIST.charAt(number);
			randStr.append(ch);
		}
		return randStr.toString();

	} // end randomNumbers

	/**
	 * Generate a random number between 2 numbers
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Generate a random number between 2 numbers</li>
	 * </ul>
	 * @param driver The driver
	 * @param num1 The first number
	 * @param num2 The second number
	 * @return An random int between 2 numbers
	 */
	public int randomNumberBetween2Numbers(RemoteWebDriver driver, int num1, int num2) {

		int n1;
		int n2;
		if (num2 < num1) {
			n1 = num2;
			n2 = num1;
		} else {
			n1 = num1;
			n2 = num2;
		} // end if

		// Get random number between 2 numbers
		Random r = new Random();
		int Low = n1;
		int High = n2;
		int randomNumber = r.nextInt(High-Low) + Low;

		return randomNumber;

	} // end randomNumberBetween2Numbers

	/**
	 * Get random month
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get a random month and return it</li>
	 * </ul>
	 * @param driver The driver
	 * @return Return the random month as a String
	 */
	public String randomMonth(RemoteWebDriver driver) {

		// Generate Random Month
		Random randMonth = new Random();
		int MonthMin = 1;
		int MonthMax = 12;
		int randomMonth = randMonth.nextInt((MonthMax - MonthMin) + 1) + MonthMin;
		String Month = Integer.toString(randomMonth);
		return Month;
	} // end randomMonth

	/**
	 * Get a random day
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get a random day and return it</li>
	 * </ul>
	 * @param driver The driver
	 * @return Return the random day as a String
	 */
	public String randomDay(RemoteWebDriver driver) {

		Random randDay = new Random();
		int DayMin = 1;
		int DayMax = 27;
		int randomDay = randDay.nextInt((DayMax - DayMin) + 1) + DayMin;
		String Day = Integer.toString(randomDay);
		return Day;
	} // end random Day

	/**
	 * Get random year between 2 years
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get random year between 2 years</li>
	 * </ul>
	 * @param driver The driver
	 * @param YearMin The minimum year to use
	 * @param YearMax The maximum year to use
	 * @return The a random year between 2 years
	 */
	public String randomYear(RemoteWebDriver driver, int YearMin, int YearMax) {

		Random randYear = new Random();
		int randomYear = randYear.nextInt((YearMax - YearMin) + 1) + YearMin;
		String Year = Integer.toString(randomYear);
		return Year;
	} // end randomYear

	/**
	 * Number of days in month
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get the number of days in a given month and year</li>
	 * </ul>
	 * @param month The month
	 * @param year The year
	 * @return The number of days in a given month and year
	 */
	public int numDaysInMonth(int month, int year) {

		int numDays = 0;

		switch (month) {
		case 1: case 3: case 5:
		case 7: case 8: case 10:
		case 12:
			numDays = 31;
			break;
		case 4: case 6:
		case 9: case 11:
			numDays = 30;
			break;
		case 2:
			if (((year % 4 == 0) && 
					!(year % 100 == 0))
					|| (year % 400 == 0))
				numDays = 29;
			else
				numDays = 28;
			break;
		default:
			System.out.println("Invalid month.");
			break;
		}
		System.out.println("Number of Days = "
				+ numDays);
		return numDays;

	} // end numDaysInMonth
	
	/**
	 * Convert milliseconds to seconds.
	 *
	 * @param milliseconds the milliseconds
	 * @return the long
	 */
	public float convertMilliToSeconds(long milliseconds) {
        final float sec = milliseconds / 1000.0f;
        return sec;
    } // end convertMilliToSeconds
	
	/**
	 * Gets the page load time.
	 *
	 * @param driver the driver
	 * @return the page load time
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public String getPageLoadTime(RemoteWebDriver driver) throws IOException {
		
		// Init JavascriptExecutor
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		// Get the navigation start time
		long navigationStart = castObjectToLong(jse.executeScript("return window.performance.timing.navigationStart"));
		
		// Get the load event end time
		long loadEventEnd = castObjectToLong(jse.executeScript("return window.performance.timing.loadEventEnd"));
		
		// Calculate the total load time
		float totalLoadTime = perform.convertMilliToSeconds(loadEventEnd - navigationStart);
		
		return Float.toString(totalLoadTime);
		
    } // end getPageLoadTime
	
	/**
	 * Cast object to long.
	 *
	 * @param object the object
	 * @return the long
	 */
	public static Long castObjectToLong(Object object) {
		return new Long(object.toString());
	} // end castObjectToLong
	
	/**
	 * Gets the current time stamp.
	 *
	 * @return the current time stamp
	 */
	public long getCurrentMilliseconds() {

		// Get the current milliseconds
		long ms = ZonedDateTime.now().toInstant().toEpochMilli();
		
		return ms;
		
	} // end getCurrentMilliseconds

	/**
	 * Gets the current time stamp.
	 *
	 * @return the current time stamp
	 */
	public Timestamp getCurrentTimeStamp() {

		// Get the current timestamp
		Date date= new Date();
		long time = date.getTime();
		Timestamp ts = new Timestamp(time);
		
		return ts;
		
	} // end getCurrentTimeStamp
	
	/**
	 * Gets todays date formatted.
	 *
	 * @param driver the driver
	 * @param format the format
	 * @return the todays date formatted
	 */
	public String getTodaysDateFormatted (RemoteWebDriver driver, String format) {

		// Example = dd/MM/yyyy HH:mm:ss
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		Date date = new Date();
		System.out.println("Formatted date: " + formatter.format(date));
		return formatter.format(date);

	} // end getTodaysDateFormatted

	/**
	 * Pause the script
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Display a dialog saying script paused</li>
	 * </ul>
	 * @param driver The driver
	 */
	// Display alert dialog box to stop the script
	public void pauseScript(RemoteWebDriver driver) {

		System.out.println("\n\nThe script has been paused\n\n");
		JOptionPane.showMessageDialog(null, "Script paused");

	} // end randomYear
	
	/**
	 * Pause the script
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Display a dialog saying script paused</li>
	 * </ul>
	 * @param driver The driver
	 * @param text the text to be displayed
	 */
	// Display alert dialog box to stop the script
	public void pauseScript(RemoteWebDriver driver, String text) {

		System.out.println("\n\nThe script has been paused\n\n");
		JOptionPane.showMessageDialog(null, text);

	} // end randomYear

	/**
	 * Convert the XSite Product to a MN product
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>If the Secure form matches an XSite variation, return that variation</li>
	 * </ul>
	 * @param driver The driver
	 * @param form the form
	 * @return The variation of a form when it differs in the XSite
	 */
	public String convertXSiteProductToMNProduct(RemoteWebDriver driver, String form) 
	{

		String newForm = form;

		if (form.equals("1004 Full/URAR"))
		{
			newForm = "Uniform Residential Appraisal (FNMA 1004)";
		}

		return newForm;

	} // end getVendorInformationByCustomerNumber

	/**
	 * Get the Secure URL based for a given environment
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get the Secure URL based for a given environment</li>
	 * </ul>
	 * @param driver The driver
	 * @param environment The environment of the Secure URL to be returned
	 * @return The Secure URL based on the environment
	 */
	public String getSecureSite(RemoteWebDriver driver, String environment) 
	{

		String secureSite = perform.getSecureSite(environment);
		return secureSite;

	} // end getSecureSite

	/**
	 * Get the Internal Tools URL based for a given environment
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get the Internal Tools URL based for a given environment</li>
	 * </ul>
	 * @param environment The environment of the Internal Tools URL to be returned
	 * @return The Internal Tools URL based on the environment
	 */
	public String getInternalToolsSite(String environment)
	{

		String internalToolsSite = "";

		if (environment.equals("Dev") || environment.equals("Sprint QA") || environment.equals("QA") || environment.equals("NexGen")
				|| environment.equals("Beta QA") || environment.equals("QA2") || environment.equals("Production QA") || environment.equals("QA3"))
		{
			internalToolsSite = "https://internaltoolsqa.ad.mercuryvmp.com/";
		}
		else
		{
			internalToolsSite = "http://internaltools.ad.mercuryvmp.com/";
		}

		return internalToolsSite;

	} // end getInternalToolsSite
	
	/**
	 * Get the CRM URL based for a given environment
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get the CRM URL based for a given environment</li>
	 * </ul>
	 * @param environment The environment of the CRM URL to be returned
	 * @return The CRM URL based on the environment
	 */
	public String getCRMSite(String environment) 
	{

		String crmSite = "";

		if (environment.equals("Dev") || environment.equals("Sprint QA") || environment.equals("QA") || environment.equals("NexGen")
				|| environment.equals("Beta QA") || environment.equals("QA2") || environment.equals("Production QA") || environment.equals("QA3"))
		{
			crmSite = "https://crmqa.ad.mercuryvmp.com/customer/customermgt/customerinfo.aspx?ID=";
		}
		else
		{
			crmSite = "https://crm.ad.mercuryvmp.com/customer/customermgt/customerinfo.aspx?ID=";
		}

		return crmSite;

	} // end getSecureSite

	/**
	 * Get the Secure URL based for a given environment
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get the Secure URL based for a given environment</li>
	 * </ul>
	 * @param environment The environment of the Secure URL to be returned
	 * @return The Secure URL based on the environment
	 */
	public String getSecureSite(String environment) 
	{

		String secureSite = "";

		if (environment.equals("Dev"))
		{
			secureSite = "https://secure.mercuryvmpdev.com";
		}
		else if (environment.equals("Sprint QA") || environment.equals("QA") || environment.equals("NexGen"))
		{
			secureSite = "https://secure.mercuryvmpqa.com";
		}
		else if (environment.equals("Beta QA") || environment.equals("QA2"))
		{
			secureSite = "https://secure.mercuryvmpqa2.com";
		}
		else if (environment.equals("Production QA") || environment.equals("QA3"))
		{
			secureSite = "https://secure.mercuryvmpqa3.com";
		}
		else if (environment.equals("Beta") || environment.equals("Sprint Staging") || environment.equals("Beta Staging") || environment.equals("Beta Push 1") || environment.equals("Beta Push 2"))
		{
//			secureSite = "https://secure.mercuryvmpbeta.com";
			secureSite = "https://secure.mercuryvmp.com";
		}
		else if (environment.equals("Live") || environment.equals("Production Staging") || environment.equals("Live Offline"))
		{
			secureSite = "https://secure.mercuryvmp.com";
		}

		return secureSite;

	} // end getSecureSite

	/**
	 * Get the API URL based for a given environment
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get the Secure URL based for a given environment</li>
	 * </ul>
	 * @param environment The environment of the Secure URL to be returned
	 * @return The Secure URL based on the environment
	 */
	public String getAPIURL(String environment) 
	{

		String apiURL = "";

		if (environment.equals("Dev"))
		{
			apiURL = "https://mercurynetworkapidev.com/";
		}
		else if (environment.equals("Sprint QA") || environment.equals("QA") || environment.equals("NexGen"))
		{
			apiURL = "https://mercurynetworkapiqa.com/";
		}
		else if (environment.equals("Beta QA") || environment.equals("QA2"))
		{
			apiURL = "https://mercurynetworkapiqa.com/";
		}
		else if (environment.equals("Production QA") || environment.equals("QA3"))
		{
			apiURL = "https://mercurynetworkapiqa.com/";
		}
		else if (environment.equals("Beta") || environment.equals("Sprint Staging") || environment.equals("Beta Staging") || environment.equals("Beta Push 1") || environment.equals("Beta Push 2"))
		{
			apiURL = "https://mercurynetworkapi.com/";
		}
		else if (environment.equals("Live") || environment.equals("Production Staging") || environment.equals("Live Offline"))
		{
			apiURL = "https://mercurynetworkapi.com/";
		}

		return apiURL;

	} // end getAPIURL

	/**
	 * Get the Vendors URL based for a given environment
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get the Vendors URL based for a given environment</li>
	 * </ul>
	 * @param driver The driver
	 * @param environment The environment of the Vendors URL to be returned
	 * @return The Vendors URL based on the environment
	 */
	public String getVendorsSite(RemoteWebDriver driver, String environment) 
	{

		String vendorsSite = perform.getVendorsSite(environment);
		return vendorsSite;

	} // end getVendorsSite

	/**
	 * Get the Vendors URL based for a given environment
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get the Vendors URL based for a given environment</li>
	 * </ul>
	 * @param environment The environment of the Vendors URL to be returned
	 * @return The Vendors URL based on the environment
	 */
	public String getVendorsSite(String environment) 
	{

		String vendorsSite = "";

		if (environment.equals("Dev"))
		{
			vendorsSite = "https://vendors.mercuryvmpdev.com/";
		}
		else if (environment.equals("Sprint QA") || environment.equals("QA") || environment.equals("NexGen"))
		{
			vendorsSite = "https://vendors.mercuryvmpqa.com/";
		}
		else if (environment.equals("Beta QA") || environment.equals("QA2"))
		{
			vendorsSite = "https://vendors.mercuryvmpqa2.com/";
		}
		else if (environment.equals("Production QA") || environment.equals("QA3"))
		{
			vendorsSite = "https://vendors.mercuryvmpqa3.com/";
		}
		else if (environment.equals("Beta") || environment.equals("Sprint Staging") || environment.equals("Beta Staging") || environment.equals("Beta Push 1") || environment.equals("Beta Push 2"))
		{
//			vendorsSite = "https://vendors.mercuryvmpbeta.com/";
			vendorsSite = "https://vendors.mercuryvmp.com/";
		}
		else if (environment.equals("Live") || environment.equals("Production Staging") || environment.equals("Live Offline"))
		{
			vendorsSite = "https://vendors.mercuryvmp.com/";
		}

		return vendorsSite;

	} // end getVendorsSite

	/**
	 * Get the VMP Client URL based for a given environment
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get the VMP Client URL based for a given environment</li>
	 * </ul>
	 * @param driver The driver
	 * @param environment The environment of the VMP Client URL to be returned
	 * @return The VMP Client site suffix
	 */
	// Get VMP site suffix
	public String getvmpSiteSuffix(RemoteWebDriver driver, String environment) 
	{

		String vmpSiteSuffix = perform.getvmpSiteSuffix(environment);
		return vmpSiteSuffix;

	} // end getvmpSiteSuffix

	/**
	 * Get the VMP Client URL based for a given environment
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get the VMP Client URL based for a given environment</li>
	 * </ul>
	 * @param environment The environment of the VMP Client URL to be returned
	 * @return The VMP Client site suffix
	 */
	public String getvmpSiteSuffix(String environment) 
	{

		String vmpSiteSuffix = "";

		if (environment.contains("Dev"))
		{
			vmpSiteSuffix = "vmpclientdev.com";
		}
		else if (environment.equals("Sprint QA") || environment.equals("QA") || environment.equals("NexGen"))
		{
			vmpSiteSuffix = "vmpclientqa.com";
		}
		else if (environment.equals("Beta QA") || environment.equals("QA2"))
		{
			vmpSiteSuffix = "vmpclientqa2.com";
		}
		else if (environment.equals("Production QA") || environment.equals("QA3"))
		{
			vmpSiteSuffix = "vmpclientqa3.com";
		}
		else if (environment.equals("Beta") || environment.equals("Sprint Staging") || environment.equals("Beta Staging") || environment.equals("Beta Push 1") || environment.equals("Beta Push 2"))
		{
//			vmpSiteSuffix = "vmpclientbeta.com";
			vmpSiteSuffix = "vmpclient.com";
		}
		else if (environment.equals("Live") || environment.equals("Production Staging") || environment.equals("Live Offline"))
		{
			vmpSiteSuffix = "vmpclient.com";
		}

		return vmpSiteSuffix;

	} // end getvmpSiteSuffix

	/**
	 * Get the VMP XSite Make A Payment page URL
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get the VMP XSite Make A Payment page URL</li>
	 * </ul>
	 * @param user The user of the XSite
	 * @return The VMP Client site suffix
	 */
	public String getvmpXSiteBillingURL(String user) 
	{

		String environment = StoredVariables.getenvironment().get();
		String vmpXSiteBillingURL = "";

		if (environment.contains("Dev") || environment.equals("Sprint QA") || environment.equals("QA") || environment.equals("NexGen"))
		{
			vmpXSiteBillingURL = "https://automationqa"+user+".qavmpxsites.com/XBilling/Accounting/ClientPayment.aspx";
		}
		else if (environment.equals("Beta QA") || environment.equals("QA2"))
		{
			vmpXSiteBillingURL = "https://automationqa"+user+".qa2vmpxsites.com/XBilling/Accounting/ClientPayment.aspx";
		}
		else if (environment.equals("Production QA") || environment.equals("QA3"))
		{
			vmpXSiteBillingURL = "https://automationqa"+user+".qa3vmpxsites.com/XBilling/Accounting/ClientPayment.aspx";
		}
		else if (environment.equals("Beta") || environment.equals("Sprint Staging") || environment.equals("Beta Staging") || environment.equals("Beta Push 1") || environment.equals("Beta Push 2"))
		{
			vmpXSiteBillingURL = "https://automationbeta"+user+".betavmpxsites.com/XBilling/Accounting/ClientPayment.aspx";
		}
		else if (environment.equals("Live") || environment.equals("Production Staging") || environment.equals("Live Offline"))
		{
			vmpXSiteBillingURL = "https://automationlive"+user+".vmpxsites.com/XBilling/Accounting/ClientPayment.aspx";
		}

		return vmpXSiteBillingURL;

	} // end getvmpSiteSuffix

	/**
	 * Get the NexGen URL based for a given environment
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get the NexGen URL based for a given environment</li>
	 * </ul>
	 * @param driver The driver
	 * @param environment The environment of the NexGen URL to be returned
	 * @return The NexGen URL for a given environment
	 */
	public String ngsecureSite(RemoteWebDriver driver, String environment) 
	{

		String ngsecureSite = perform.ngsecureSite(environment);
		return ngsecureSite;

	} // end ngsecureSite

	/**
	 * Get the NexGen URL based for a given environment
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get the NexGen URL based for a given environment</li>
	 * </ul>
	 * @param environment The environment of the NexGen URL to be returned
	 * @return The NexGen URL for a given environment
	 */
	public String ngsecureSite(String environment) 
	{

		String ngsecureSite = "";

		if (environment.equals("NexGen"))
		{
			ngsecureSite = "https://secure.mercsat.net";
		}

		return ngsecureSite;

	} // end ngsecureSite

	/**
	 * Get State Abbreviation
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get the abbreviation of a given state</li>
	 * </ul>
	 * @param driver The driver
	 * @param state The state to get the abbreviation for
	 * @return The state abbreviation
	 */
	// Get State Abbreviation
	public  String getStateAbbreviation(RemoteWebDriver driver, String state)
	{

		Map<String, String> states = new HashMap<String, String>();
		states.put("Alabama","AL");
		states.put("Alaska","AK");
		states.put("Alberta","AB");
		states.put("American Samoa","AS");
		states.put("Arizona","AZ");
		states.put("Arkansas","AR");
		states.put("Armed Forces (AE)","AE");
		states.put("Armed Forces Americas","AA");
		states.put("Armed Forces Pacific","AP");
		states.put("British Columbia","BC");
		states.put("California","CA");
		states.put("Colorado","CO");
		states.put("Connecticut","CT");
		states.put("Delaware","DE");
		states.put("District Of Columbia","DC");
		states.put("Florida","FL");
		states.put("Georgia","GA");
		states.put("Guam","GU");
		states.put("Hawaii","HI");
		states.put("Idaho","ID");
		states.put("Illinois","IL");
		states.put("Indiana","IN");
		states.put("Iowa","IA");
		states.put("Kansas","KS");
		states.put("Kentucky","KY");
		states.put("Louisiana","LA");
		states.put("Maine","ME");
		states.put("Manitoba","MB");
		states.put("Maryland","MD");
		states.put("Massachusetts","MA");
		states.put("Michigan","MI");
		states.put("Minnesota","MN");
		states.put("Mississippi","MS");
		states.put("Missouri","MO");
		states.put("Montana","MT");
		states.put("Nebraska","NE");
		states.put("Nevada","NV");
		states.put("New Brunswick","NB");
		states.put("New Hampshire","NH");
		states.put("New Jersey","NJ");
		states.put("New Mexico","NM");
		states.put("New York","NY");
		states.put("Newfoundland","NF");
		states.put("North Carolina","NC");
		states.put("North Dakota","ND");
		states.put("Northwest Territories","NT");
		states.put("Nova Scotia","NS");
		states.put("Nunavut","NU");
		states.put("Ohio","OH");
		states.put("Oklahoma","OK");
		states.put("Ontario","ON");
		states.put("Oregon","OR");
		states.put("Pennsylvania","PA");
		states.put("Prince Edward Island","PE");
		states.put("Puerto Rico","PR");
		states.put("Quebec","QC");
		states.put("Rhode Island","RI");
		states.put("Saskatchewan","SK");
		states.put("South Carolina","SC");
		states.put("South Dakota","SD");
		states.put("Tennessee","TN");
		states.put("Texas","TX");
		states.put("Utah","UT");
		states.put("Vermont","VT");
		states.put("Virgin Islands","VI");
		states.put("Virginia","VA");
		states.put("Washington","WA");
		states.put("West Virginia","WV");
		states.put("Wisconsin","WI");
		states.put("Wyoming","WY");
		states.put("Yukon Territory","YT");

		StoredVariables.getstateAbbreviation().set(states.get(state));

		System.out.println("State abbreviation = " + StoredVariables.getstateAbbreviation().get());

		return StoredVariables.getstateAbbreviation().get();

	} // end getStateAbbreviation

	/**
	 * Get the number of rows in a table
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Create a list of all tr tags and count the number</li>
	 * </ul>
	 * @param driver The driver
	 * @param table The table to get the number of rows
	 * @return The number of rows in the table
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Get the number of rows or columns in a table
	public int getNumOfRowsInTableCSSSelector(RemoteWebDriver driver, String table) throws IOException{

		// Provide the table name and to get the number of rows
		WebElement tableName = driver.findElement(By.cssSelector(table));

		// Now get all the TR elements from the table 
		List<WebElement> allRows = tableName.findElements(By.tagName("tr"));

		// Return the result
		return allRows.size();

	} // end getNumOfRowsInTableCSSSelector

	/**
	 * Get the number of columns in a table
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Create a list of all td tags and count the number</li>
	 * </ul>
	 * @param driver The driver
	 * @param table The table to get the number of columns
	 * @return The number of columns in the table
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Get the number of rows or columns in a table
	public int getNumOfColumnsInTableCSSSelector(RemoteWebDriver driver, String table) throws IOException{

		// Provide the table name and to get the number of rows
		WebElement tableName = driver.findElement(By.cssSelector(table));

		// Now get all the TR elements from the table 
		List<WebElement> allColumns = tableName.findElements(By.tagName("td"));

		// Get number of rows for the table
		int rows = getNumOfRowsInTableCSSSelector(driver, table);

		int numColumns = allColumns.size()/rows;

		// Return the result
		return numColumns;

	} // end getNumOfColumnsInTableCSSSelector
	
	/**
	 * Get the row number of table that contains text
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Create a list of all td tags and count the number</li>
	 * </ul>.
	 *
	 * @param driver The driver
	 * @param element the element
	 * @param text the text
	 * @param startingIndexValue the starting index value
	 * @return The number of columns in the table
	 */
	// Get the number of rows or columns in a table
	public int getRowNumberThatContainsText(RemoteWebDriver driver, By element, String text, int startingIndexValue) {

		// Create a list of elements of the search results
		int index = startingIndexValue;
		List<WebElement> rowText = driver.findElements(element);
		for (WebElement el: rowText) {
			
			// Get the text of the current row
			String tableText = el.getText();
			
			// Check if the 
			if (tableText.contains(text)) {
				break;
			} // end if
			
			// Increment the row number
			index++;
			
		} // end for
		
		System.out.println("Index: " + index);

		// Return the result
		return index;

	} // end getRowNumberThatContainsText

	/**
	 * Get the number of rows in a table
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Create a list of all tr tags and count the number</li>
	 * </ul>
	 * @param driver The driver
	 * @param table The table to get the number of rows
	 * @return The number of rows in the table
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Get the number of rows or columns in a table
	public int getNumOfRowsInTableID(RemoteWebDriver driver, String table) throws IOException{

		// Provide the table name and to get the number of rows
		WebElement tableName = driver.findElement(By.id(table));

		// Now get all the TR elements from the table 
		List<WebElement> allRows = tableName.findElements(By.tagName("tr"));

		// Return the result
		return allRows.size();

	} // end getNumOfRowsInTableID

	/**
	 * Get the number of columns in a table
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Create a list of all td tags and count the number</li>
	 * </ul>
	 * @param driver The driver
	 * @param table The table to get the number of columns
	 * @return The number of columns in the table
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Get the number of rows or columns in a table
	public int getNumOfColumnsInTableID(RemoteWebDriver driver, String table) throws IOException{

		// Provide the table name and to get the number of rows
		WebElement tableName = driver.findElement(By.id(table));

		// Now get all the TR elements from the table 
		List<WebElement> allColumns = tableName.findElements(By.tagName("td"));

		// Get number of rows for the table
		int rows = getNumOfRowsInTableID(driver, table);

		int numColumns = allColumns.size()/rows;

		// Return the result
		return numColumns;

	} // end getNumOfColumnsInTableID

	/**
	 * Get all table data
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Wait for the table element</li>
	 * 	<li>Create a list of all the td tags</li>
	 * 	<li>Iterate through each element and add the data to an array</li>
	 * </ul>
	 * @param driver The driver
	 * @param table The table to get the data from
	 * @return The table data as an array
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	// Get all table data
	public ArrayList<String> getAllTableData(RemoteWebDriver driver, String table) throws IOException, InterruptedException{

		ArrayList<String> data = new ArrayList<String>();

		waitForElementToBeClickable(driver, table, "id");

		// Provide the table name and to get the number of rows
		WebElement tableName = driver.findElement(By.id(table));

		// Now get all the TR elements from the table 
		List<WebElement> columns = tableName.findElements(By.tagName("td"));

		for (WebElement c : columns) {
			data.add(c.getText());
		}

		System.out.println("Table data = " + data);
		// Return the result
		return data;

	} // end getAllTableData

	/**
	 * Get the automation users' phone number depending on the environment
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get the automation users' phone number depending on the environment</li>
	 * </ul>
	 * @param driver The driver
	 * @return The phone number for the environment the tests are being ran on
	 */
	// Get the environment phone number
	public String getEnvironmentPhoneNumber(RemoteWebDriver driver)
	{

		String envPhone = null;

		// Get the correct environment phone number
		if (StoredVariables.getenvironment().get().contains("Dev") || StoredVariables.getenvironment().get().contains("QA"))
		{
			envPhone = "111";
		}
		else if (StoredVariables.getenvironment().get().contains("Beta"))
		{
			envPhone = "222";
		}
		else if (StoredVariables.getenvironment().get().contains("Live"))
		{
			envPhone = "333";
		}

		return envPhone;

	} // end getEnvironmentPhoneNumber

	/**
	 * Click on text inside a label
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click on text inside a label</li>
	 * </ul>
	 * @param driver The driver
	 * @param text The text to be clicked inside a label attribute
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the exception
	 */
	// Click at text with label
	public void clickLabelText(RemoteWebDriver driver, String text) throws IOException, InterruptedException{
		
		// Create the element
		WebElement e = driver.findElement(By.xpath("//label[text()='" + text + "']"));
		
		// Wait for the element to be clickable
		waitForElementToBeClickable(driver, e);
		
		// Highlight element
		String original_style = highlightElement(driver, e);
		
		// Click the element
		if (StoredVariables.getmobile().get()==true) {
			e.click();
		} else {
			click(driver, e);
		} // end if/else
		
		// Unhighlight element
		unhighlightElement(driver, original_style, e);
		
	} // end clickLabelText

	/**
	 * Click on text inside a list
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click on text inside a list</li>
	 * </ul>
	 * @param driver The driver
	 * @param text The text to be clicked inside a list attribute
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the exception
	 */
	public void clickListText(RemoteWebDriver driver, String text) throws IOException, InterruptedException{
		
		// Create the element
		WebElement e = driver.findElement(By.xpath("//li[text()='" + text + "']"));
		
		// Wait for the element to be clickable
		waitForElementToBeClickable(driver, e);
		
		// Highlight element
		String original_style = highlightElement(driver, e);
		
		// Click the element
		if (StoredVariables.getmobile().get()==true) {
			e.click();
		} else {
			click(driver, e);
		} // end if/else
		
		// Unhighlight element
		unhighlightElement(driver, original_style, e);
		
	} // end clickLabelText

	/**
	 * Click on text inside a table
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click on text inside a table</li>
	 * </ul>
	 * @param driver The driver
	 * @param text The text to be clicked inside a table
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the exception
	 */
	// Click at text within table that contains a string
	public void clickInTable_Contains(RemoteWebDriver driver, String text) throws IOException, InterruptedException{
		
		// Create the element
		WebElement e = driver.findElement(By.xpath("//td[contains(text(), '" + text + "')]"));
		
		// Wait for the element to be clickable
		waitForElementToBeClickable(driver, e);
		
		// Highlight element
		String original_style = highlightElement(driver, e);
		
		// Click the element
		if (StoredVariables.getmobile().get()==true) {
			e.click();
		} else {
			click(driver, e);
		} // end if/else
		
		// Unhighlight element
		unhighlightElement(driver, original_style, e);
		
	} // end clickInTable_Contains

	/**
	 * Get element from table text
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get element using table text</li>
	 * </ul>
	 * @param driver The driver
	 * @param text The text of the element
	 * @return the WebElement
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the exception
	 */
	// Click at text within table that contains a string
	public WebElement getElementFromTableText_Contains(RemoteWebDriver driver, String text) throws IOException, InterruptedException{
		
		// Create the element
		WebElement e = driver.findElement(By.xpath("//td[contains(text(), '" + text + "')]"));
		
		// Wait for the element to be clickable
		waitForElementToBeClickable(driver, e);
		
		// Return the element
		return e;
		
	} // end getElementFromTableText_Contains

	/**
	 * Click on text inside a span
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click on text inside a span</li>
	 * </ul>
	 * @param driver The driver
	 * @param text The text to be clicked inside a span attribute
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the exception
	 */
	// Click at text within span that contains a string
	public void clickInSpan_Contains(RemoteWebDriver driver, String text) throws IOException, InterruptedException{
		
		// Create the element
		WebElement e = driver.findElement(By.xpath("//span[contains(text(), '" + text + "')]"));
		
		// Wait for the element to be clickable
		waitForElementToBeClickable(driver, e);
		
		// Highlight element
		String original_style = highlightElement(driver, e);
		
		// Click the element
		if (StoredVariables.getmobile().get()==true) {
			e.click();
		} else {
			click(driver, e);
		} // end if/else
		
		// Unhighlight element
		unhighlightElement(driver, original_style, e);
		
	} // end clickInSpan_Contains

	/**
	 * Click on text inside a p tag
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click on text inside a span</li>
	 * </ul>
	 * @param driver The driver
	 * @param text The text to be clicked inside a span attribute
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the exception
	 */
	// Click at text within span that contains a string
	public void clickInPTag_Contains(RemoteWebDriver driver, String text) throws IOException, InterruptedException{
		
		// Create the element
		WebElement e = driver.findElement(By.xpath("//p[contains(text(), '" + text + "')]"));
		
		// Wait for the element to be clickable
		waitForElementToBeClickable(driver, e);
		
		// Highlight element
		String original_style = highlightElement(driver, e);

		// Click the element
		if (StoredVariables.getmobile().get()==true) {
			e.click();
		} else {
			click(driver, e);
		} // end if/else
		
		// Unhighlight element
		unhighlightElement(driver, original_style, e);
		
	} // end clickInPTag_Contains

	/**
	 * Click on text inside a table
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click on text inside a table</li>
	 * </ul>
	 * @param driver The driver
	 * @param text The text to be clicked inside a table attribute
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the exception
	 */
	// Click at text within table that equals a string
	public void clickInTable_Equals(RemoteWebDriver driver, String text) throws IOException, InterruptedException{
		
		// Create the element
		WebElement e = driver.findElement(By.xpath("//td[text()='" + text + "']"));
		
		// Wait for the element to be clickable
		waitForElementToBeClickable(driver, e);
		
		// Highlight element
		String original_style = highlightElement(driver, e);
		
		// Click the element
		if (StoredVariables.getmobile().get()==true) {
			e.click();
		} else {
			click(driver, e);
		} // end if/else
		
		// Unhighlight element
		unhighlightElement(driver, original_style, e);
		
	} // end clickInTable_Equals

	/**
	 * Click on text inside a div
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click on text inside a div</li>
	 * </ul>
	 * @param driver The driver
	 * @param text The text to be clicked inside a div attribute
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the exception
	 */
	// Click at text within table that contains a string
	public void clickInDiv_Contains(RemoteWebDriver driver, String text) throws IOException, InterruptedException{
		
		// Create the element
		WebElement e = driver.findElement(By.xpath("//div[contains(text(), '" + text + "')]"));
		
		// Wait for the element to be clickable
		waitForElementToBeClickable(driver, e);
		
		// Highlight element
		String original_style = highlightElement(driver, e);
		
		// Click the element
		if (StoredVariables.getmobile().get()==true) {
			e.click();
		} else {
			click(driver, e);
		} // end if/else
		
		// Unhighlight element
		unhighlightElement(driver, original_style, e);
		
	} // end clickInDiv_Contains

	/**
	 * Double click on text inside a table
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Double click on text inside a table</li>
	 * </ul>
	 * @param driver The driver
	 * @param text The text to be double clicked inside a table attribute
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the exception
	 */
	// Double click at text within table
	public void doubleClickInTable(RemoteWebDriver driver, String text) throws IOException, InterruptedException{
		
		Actions action = new Actions(driver);
		
		// Create the element
		WebElement e = driver.findElement(By.xpath("//td[contains(text(), '" + text + "')]"));
		
		// Wait for the element to be clickable
		waitForElementToBeClickable(driver, e);
		
		// Highlight element
		String original_style = highlightElement(driver, e);
		
		// Double Click the matching element
		action.doubleClick(e).perform();
		
		// Unhighlight element
		unhighlightElement(driver, original_style, e);
		
	} // end doubleClickInTable
	
	/**
	 * Double click an element
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Double click an element</li>
	 * </ul>.
	 *
	 * @param driver The driver
	 * @param element the element
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the exception
	 */
	// Double click at text within table
	public void doubleClickElement(RemoteWebDriver driver, WebElement element) throws IOException, InterruptedException{
		
		Actions action = new Actions(driver);
		
		// Wait for the element to be clickable
		waitForElementToBeClickable(driver, element);
		
		// Highlight element
		String original_style = highlightElement(driver, element);
		
		// Double Click the matching element
		action.doubleClick(element).perform();
		
		// Unhighlight element
		unhighlightElement(driver, original_style, element);
		
	} // end doubleClickElement

	/**
	 * Click on text inside a column
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click on text inside a column</li>
	 * </ul>
	 * @param driver The driver
	 * @param text The text to be clicked inside a column
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the exception
	 */
	// Click at text within table that contains a string
	public void clickInTableColumn_Contains(RemoteWebDriver driver, String text) throws IOException, InterruptedException{
		
		// Create the element
		WebElement e = driver.findElement(By.xpath("//th[contains(text(), '" + text + "')]"));
		
		// Wait for the element to be clickable
		waitForElementToBeClickable(driver, e);
		
		// Highlight element
		String original_style = highlightElement(driver, e);
		
		// Click the element
		if (StoredVariables.getmobile().get()==true) {
			e.click();
		} else {
			click(driver, e);
		} // end if/else
		
		// Unhighlight element
		unhighlightElement(driver, original_style, e);
		
	} // end clickInTable_Contains


	/**
	 * Hover on an element
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Wait for the element to be visible</li>
	 * 	<li>Scroll to the element</li>
	 *  <li>Click the element</li>
	 * </ul>
	 * @param driver the driver
	 * @param element the element to be clicked
	 * @throws InterruptedException the exception
	 */
	public void hover(RemoteWebDriver driver, WebElement element) throws InterruptedException {

		Actions builder = new Actions(driver);

		// Try to click the element
		try {
			
			// Highlight element
			String original_style = highlightElement(driver, element);
			
			Action mouseOverHome = builder.moveToElement(element).build();
			mouseOverHome.perform();
			
			// Unhighlight element
			unhighlightElement(driver, original_style, element);
			
		} catch (Exception e) {
			element = rebuildElement(driver, element);
			Action mouseOverHome = builder.moveToElement(element).build();
			mouseOverHome.perform();
		} // end try/catch

	} // end hover

	/**
	 * Click on an element
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Wait for the element to be visible</li>
	 * 	<li>Scroll to the element</li>
	 *  <li>Click the element</li>
	 * </ul>
	 * @param driver the driver
	 * @param element the element to be clicked
	 * @throws InterruptedException the exception
	 */
	public void click(RemoteWebDriver driver, WebElement element) throws InterruptedException {

		String grid = StoredVariables.getuseLocalGrid().get();
		
		// Wait for the element to be clickable
		waitForElementToBeClickable(driver, element);
		
		// Highlight element
		String original_style = highlightElement(driver, element);
		
		// Try to click the element
		try {
			if (grid.equals("android")) {
				clickWithJavascript(driver, element);
			} else {
				element.click();
			} // end if android
		} catch (Exception e) {

			System.out.println("Click Exception: " + e);
			
			// Rebuild the element
			element = rebuildElement(driver, element);

			if (!grid.equals("android")) {

				// Wait for element
				waitForElementToBeClickable(driver, element);

				// Scroll the element into view
				scrollElementIntoView(driver, element);

			} // end if not android

			try {
				
				// Click the element
				element.click();
				
			} catch (Exception e1) {
				
				// Click the element with Javascript
				clickWithJavascript(driver, element);
				
			} // end try/catch

		} // end try/catch
		
		// Unhighlight element
		unhighlightElement(driver, original_style, element);
			
	} // end click

	/**
	 * Click on an element with Javascript
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Wait for the element to be clickable</li>
	 *  <li>Click the element</li>
	 * </ul>
	 * @param driver the driver
	 * @param element the element to be clicked
	 * @throws InterruptedException the exception
	 */
	public void clickWithJavascript(RemoteWebDriver driver, WebElement element) throws InterruptedException {

		// Click an element using Javascript
		try {
			
			// Highlight element
			String original_style = highlightElement(driver, element);
			
			// Click with Javascript
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
			
			// Unhighlight element
			unhighlightElement(driver, original_style, element);
			
		} catch (Exception e) {
			e.printStackTrace();
		} // end try/catch

	} // end clickWithJavascript

	/**
	 * Type in an element
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Wait for the element to be visible</li>
	 * 	<li>Scroll to the element</li>
	 *  <li>Clear the field</li>
	 *  <li>Enter the text</li>
	 *  <li>If the text is not entered correctly, clear it and re-enter it</li>
	 * </ul>
	 * @param driver the driver
	 * @param element the element to be typed in
	 * @param input the text to be input
	 * @throws InterruptedException the exception
	 */
	public void type(RemoteWebDriver driver, WebElement element, String input) throws InterruptedException {

		// Wait for the element to be clickable
		waitForElementToBeClickable(driver, element);
		
		// Highlight element
		String original_style = highlightElement(driver, element);
		
		// Enter a while loop to try to interact with the element
		boolean interacted = false;
		int i = 1;
		while (interacted == false && i <=10) {
			
			// Try to clear the field and enter text
			try {
				
				// Clear the field
				element.clear();
				
				// Enter the text
				element.sendKeys(input);
				
				interacted = true;
				
			} catch (Exception e) {

				System.out.println("Could not enter text. Creating a new element and trying again");

					// Rebuild the element
					element = rebuildElement(driver, element);
					
					// Scroll the element into view
					scrollElementIntoView(driver, element);
					
					// Wait for element
					waitForElementToBeClickable(driver, element);
					
			} // end try/catch
			
			i++;
			
		} // end while

		// Verify the text was entered correctly and re-enter it if it wasn't
		String value = element.getAttribute("value");
		int a = 1;
		while (!value.equals(input) && a <= 5) {
			System.out.println("Text is incorrct. Clearing the field and trying again. Try #"+a);
			System.out.println("Text value: " + value);
			System.out.println("Expected: " + input);
			element.clear();
			element.sendKeys(input);
			Thread.sleep(1000);
			value = element.getAttribute("value");
			System.out.println("New text value: " + value + "\n");
			a++;
		} // end while
		
		// Unhighlight element
		unhighlightElement(driver, original_style, element);

	} // end type

	/**
	 * Type in an element with Javascript
	 * <p>
	 * STEPS:
	 * <ul>
	 *  <li>Enter the text</li>
	 * </ul>
	 * @param driver the driver
	 * @param id the element id
	 * @param input the text to be input
	 * @throws InterruptedException the exception
	 */
	public void typeWithJavascript(RemoteWebDriver driver, String id, String input) throws InterruptedException {

		// Create the element
		WebElement element = driver.findElement(By.id(id));
		
		// Wait for the element to be clickable
		waitForElementToBeClickable(driver, element);
		
		// Highlight element
		String original_style = highlightElement(driver, element);
		
		// Type in textbox with Javascript
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("document.getElementById('"+id+"').value='"+input+"';");
		
		// Unhighlight element
		unhighlightElement(driver, original_style, element);

	} // end typeWithJavascript

	/**
	 * Select dropdown option
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Wait for the element to be visible</li>
	 * 	<li>Scroll to the element</li>
	 * 	<li>Select an option in a dropdown element</li>
	 * </ul>
	 * @param driver The driver
	 * @param element The dropdown WebElement
	 * @param text The option to select in the dropdown
	 * @throws InterruptedException the exception
	 */
	public void selectDropdownOption(RemoteWebDriver driver, WebElement element, String text) throws InterruptedException{

		// Wait for element
		waitForElementToBeClickable(driver, element);
		
		// Highlight element
		String original_style = highlightElement(driver, element);

		// Select the option from the dropdown
		try {
			Select documentType = new Select(element);   
			documentType.selectByVisibleText(text);
		} catch (UnexpectedTagNameException e) {
			try {
				element = rebuildElement(driver, element);
				Select documentType = new Select(element);   
				documentType.selectByVisibleText(text);
			} catch (Exception e1) {
				element = rebuildElement(driver, element);
				try {
					Select documentType = new Select(element);   
					documentType.selectByVisibleText(text);
				} catch (UnexpectedTagNameException e2) {
					Select documentType = new Select(element);   
					documentType.selectByVisibleText(text);
				} // end try/catch
			} // end nested try/catch
		} // end try/catch
		
		// Unhighlight element
		unhighlightElement(driver, original_style, element);

	} // end selectDropdownOption

	/**
	 * Check a checkbox
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Wait for the element to be visible</li>
	 * 	<li>Scroll the element into view</li>
	 *  <li>If the checkbox is not selected, click it</li>
	 * </ul>
	 * @param driver The driver
	 * @param element The checkbox WebElement to be checked
	 * @throws InterruptedException The exception
	 */
	public void checkCheckbox(RemoteWebDriver driver, WebElement element) throws InterruptedException{

		// Wait for element
		waitForElementToBeClickable(driver, element);
		
		// Highlight element
		String original_style = highlightElement(driver, element);
		
		//Wait 0.5 seconds
		Thread.sleep(500);

		// Scroll the element into view
		try {
			scrollElementIntoView(driver, element);
		} catch (Exception e1) {
			System.out.println("Could not scroll to element");
		}

		// If the element is not checked, check it
		if (!element.isSelected())
		{
			try {
				click(driver, element);
			} catch (StaleElementReferenceException e) {
//				element = rebuildElement(driver, element);
//				click(driver, element);
			} // end try/catch
		} // end if
		
		// Unhighlight element
		unhighlightElement(driver, original_style, element);

	} // end checkCheckbox

	/**
	 * Uncheck a checkbox
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Wait for the element to be visible</li>
	 * 	<li>Scroll to the element</li>
	 * 	<li>If the checkbox is selected, click it</li>
	 * </ul>
	 * @param driver The driver
	 * @param element The checkbox WebElement to be unchecked
	 * @throws InterruptedException The exception
	 */
	public void uncheckCheckbox(RemoteWebDriver driver, WebElement element) throws InterruptedException{

		// Wait for element
		waitForElementToBeClickable(driver, element);
		
		// Highlight element
		String original_style = highlightElement(driver, element);

		//Wait 0.5 seconds
		Thread.sleep(500);
				
		// Scroll the element into view
		scrollElementIntoView(driver, element);

		// If the element is checked, uncheck it
		if (element.isSelected())
		{
			try {
				element.click();
			} catch (StaleElementReferenceException e) {
				element = rebuildElement(driver, element);
				element.click();
			} // end try/catch
		} // end if
		
		// Unhighlight element
		unhighlightElement(driver, original_style, element);
		
	} // end uncheckCheckbox

	/**
	 * Get today's date
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get today's date and set a stored variable in the format of MM/dd/yyyy</li>
	 * <li>Get today's date and set a stored variable in the format of M/d/yyyy</li>
	 * </ul>
	 * @param driver The driver
	 */
	public void getTodaysDate(RemoteWebDriver driver)
	{

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		StoredVariables.gettodaysDateLong().set(dateFormat.format(date));

		DateFormat dateFormat2 = new SimpleDateFormat("M/d/yyyy");
		Date date2 = new Date();
		StoredVariables.gettodaysDateShort().set(dateFormat2.format(date2));

	} // end getTodaysDate

	/**
	 * Store new date as the Due Date
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Determine the format to store the new date based on the length</li>
	 * 	<li>Store the new date as the order due date StoredVariable</li>
	 * </ul>
	 * @param driver The driver
	 * @param newOrderDate The date to be stored as the new Due Date StoredVariable
	 * @throws InterruptedException the interrupted exception
	 * @throws ParseException the parse exception
	 */
	public void storeNewOrderDate(RemoteWebDriver driver, String newOrderDate) throws InterruptedException, ParseException 
	{

		// Initialize date format string
		SimpleDateFormat dateFormat = null;

		// determine format of date
		if (newOrderDate.length() == 10)
		{
			dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		}
		else
		{
			dateFormat = new SimpleDateFormat("M/d/yyyy");
		}

		SimpleDateFormat dateLong = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat dateShort = new SimpleDateFormat("M/d/yyyy");

		// Set Long date format
		StoredVariables.getorderDueDateLong().set(dateLong.format(dateFormat.parse(newOrderDate)));

		// Set Short date format
		StoredVariables.getorderDueDateShort().set(dateShort.format(dateFormat.parse(newOrderDate)));

	} // end storeNewOrderDate

	/**
	 * Get a new date based on the number of days from the current date
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get today's date</li>
	 * 	<li>Calculate the new date based on the number of days from the current date and store it as StoredVariables</li>
	 * </ul>
	 * @param driver The driver
	 * @param numOfDaysInTheFuture The number of days from the current date
	 * @throws InterruptedException the interrupted exception
	 */
	// Get new date
	public void getNewDate(RemoteWebDriver driver, int numOfDaysInTheFuture) throws InterruptedException 
	{

		// Get current month
		SimpleDateFormat s = new SimpleDateFormat("MM");
		StoredVariables.getcurrentMonth().set(s.format(new Date()));

		// Get today's date
		Calendar calendar = Calendar.getInstance();
		// Add number of days passed in
		calendar.add(Calendar.DAY_OF_MONTH, numOfDaysInTheFuture);
		// Set the date to the new date
		Date date = calendar.getTime();

		// Get new day and format it without leading 0
		StoredVariables.getnewDay().set(new SimpleDateFormat("d").format(date));
		// Get new day and format it with leading 0 if necessary
		StoredVariables.getnewDay2().set(new SimpleDateFormat("dd").format(date));
		// Get new month and format it
		StoredVariables.getnewMonth().set(new SimpleDateFormat("M").format(date));
		// Get new month and format it
		StoredVariables.getnewMonth2().set(new SimpleDateFormat("MM").format(date));
		// Get new year and format it
		StoredVariables.getnewYear().set(new SimpleDateFormat("yyyy").format(date));

		StoredVariables.getnewDateLong().set(StoredVariables.getnewMonth2().get()+"/"+StoredVariables.getnewDay2().get()+"/"+StoredVariables.getnewYear().get());
		StoredVariables.getnewDateShort().set(StoredVariables.getnewMonth().get()+"/"+StoredVariables.getnewDay().get()+"/"+StoredVariables.getnewYear().get());

	} // end getNewDate

	/**
	 * Get the month name from number
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Iterate through an array to get the month name</li>
	 * </ul>
	 * @param driver The driver
	 * @param month The month number you want to get the month name of
	 * @return The month name from the given month number
	 */
	public String getMonthName(RemoteWebDriver driver, int month){

		String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		return monthNames[month-1];
	}

	/**
	 * Report line number for test that contains a bug so it is commented out
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get the class, method and line number of the location calling this method</li>
	 * 	<li>Write the class, method and line number along with the given String to the log</li>
	 * </ul>
	 * @param driver The driver
	 * @param descriptionOfBug The description of the bug to add to the log
	 */	
	public void commentedBug(RemoteWebDriver driver, String descriptionOfBug) {

		ExtentTest test = ExtentTestManager.getTest();

		int callersLineNumber = new Exception().getStackTrace()[1].getLineNumber()-1;
		String callersClass = new Exception().getStackTrace()[1].getClassName();
		String callersMethod = new Exception().getStackTrace()[1].getMethodName();

		System.out.println("There is a test for a bug that is commented out on line #" + callersLineNumber + " of " + callersClass + "." + callersMethod + " in regards to " + descriptionOfBug);

		test.log(LogStatus.INFO, "commentedBug", "Line #" + callersLineNumber + " of " + callersClass + "." + callersMethod + " - " + descriptionOfBug);

	} // end commentedBug

	/**
	 * Scroll an element into view
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Move to the element using the Actions class</li>
	 * </ul>
	 * @param driver The driver
	 * @param element The element to be scrolled into view
	 * @throws InterruptedException the interrupted exception
	 */
	public void scrollElementIntoView(RemoteWebDriver driver, WebElement element) throws InterruptedException
	{
		
		// Scroll Save button into view
		Actions actions = new Actions(driver);
		try {
			try {
				actions.moveToElement(element);
				actions.perform();
			} catch (StaleElementReferenceException e) {
				element = rebuildElement(driver, element);
				perform.waitForElementToBeVisible(driver, element);
				try {
					actions.moveToElement(element);
					actions.perform();
				} catch (StaleElementReferenceException e2) {
					element = rebuildElement(driver, element);
					actions.moveToElement(element);
					actions.perform();
				} // end try/catch
			} // end try/catch
		} catch (Exception e) {
			System.out.println("Could not scroll to element");
		} // end try/catch

	} // end scrollElementIntoView

	/**
	 * Wait for the notice element to be hidden
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Count the number of div.notice elements</li>
	 * 	<li>Iterate through a while loop up to 10 times until there are no elements</li>
	 * </ul>
	 * @param driver The driver
	 * @throws InterruptedException the interrupted exception
	 */
	public void waitForNoticeToBeHidden(RemoteWebDriver driver) throws InterruptedException
	{

		Thread.sleep(1000);

		// Get the number of elements
		int numElements = driver.findElements(By.cssSelector(Overlay.notice())).size();

		// If the element is found, enter a while loop until there are none
		int attempt = 1;
		while (numElements > 0 && attempt <=10) {
			Thread.sleep(1000);
			try {
				numElements = driver.findElements(By.cssSelector(Overlay.notice())).size();
			} catch (StaleElementReferenceException e) {
				numElements = driver.findElements(By.cssSelector(Overlay.notice())).size();
			} // end try/catch
			attempt++;
		} // end while

	} // end waitForNoticeToBeHidden

	/**
	 * Wait for the notice element to be visible
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Count the number of div.notice elements</li>
	 * 	<li>Iterate through a while loop up to 10 times until the element is visible</li>
	 * </ul>
	 * @param driver The driver
	 * @throws InterruptedException the interrupted exception
	 */
	public void waitForNoticeToBeVisible(RemoteWebDriver driver) throws InterruptedException
	{

		Thread.sleep(1000);

		// Get the number of elements
		int numElements = driver.findElements(By.cssSelector(Overlay.notice())).size();

		// If the element is found, enter a while loop until there are none
		int attempt = 1;
		while (numElements > 0 && attempt <=10) {
			Thread.sleep(1000);
			try {
				numElements = driver.findElements(By.cssSelector(Overlay.notice())).size();
			} catch (StaleElementReferenceException e) {
				numElements = driver.findElements(By.cssSelector(Overlay.notice())).size();
			} // end try/catch
			attempt++;
		} // end while

	} // end waitForNoticeToBeVisible

	/**
	 * Wait for the overly to be hidden
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Make sure the overlay style attribute is visible</li>
	 * 	<li>Once it's found, set the style to a String</li>
	 * 	<li>Wait until the style does not contain visible</li>
	 * </ul>
	 * @param driver The driver
	 * @throws InterruptedException the interrupted exception
	 */
	public void waitForOverlayToBeHidden(RemoteWebDriver driver) throws InterruptedException
	{

		Thread.sleep(2000);

		boolean visible = false;
		boolean visible2 = false;
		int attempts = 0;
		while (attempts < 5) {
			try {
				Overlay.overlay(driver).getAttribute("style");
				visible = true;
				break;
			} catch(StaleElementReferenceException e) {
			}
			attempts++;
		}
		if (visible==true) {
			String overlayHidden = "";
			while (attempts < 5) {
				try {
					try {
						boolean present = perform.isAttribtuePresent(driver, Overlay.overlay(driver), "style");
						if (present==true) {
							Overlay.overlay(driver).getAttribute("style");
							visible2 = true;
							overlayHidden = Overlay.overlay(driver).getAttribute("style");
							break;
						}
					} catch (Exception e) {					}
				} catch(StaleElementReferenceException e) {
				}
				attempts++;
			} // end while
			// Wait for overlay to go away
			if (visible2==true) {
				// Set 40 second while loop timeout
				long start_time = System.currentTimeMillis();
				long wait_time = 40000;
				long end_time = start_time + wait_time;
				while (System.currentTimeMillis() < end_time && overlayHidden.contains("visible")){
					Thread.sleep(1000);
					try {
						overlayHidden = Overlay.overlay(driver).getAttribute("style");
					} catch (StaleElementReferenceException e) {
						Thread.sleep(2000);
						overlayHidden = Overlay.overlay(driver).getAttribute("style");
					} // end try/catch
					if (!overlayHidden.contains("visible"))
					{
						System.out.println("Overlay has been hidden");
						Thread.sleep(1000);
						break;
					} // end if
					Thread.sleep(1500);
				} // end while
			} // end if visible2
		} // end if

	} // end waitForOverlay

	/**
	 * Wait for the overlay to be visible
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Make sure the overlay style attribute is visible</li>
	 * 	<li>Once it's found, set the style to a String</li>
	 * 	<li>Wait until the style contains visible</li>
	 * </ul>
	 * @param driver The driver
	 * @throws InterruptedException the interrupted exception
	 */
	public void waitForOverlayToBeVisible(RemoteWebDriver driver) throws InterruptedException
	{

		Thread.sleep(2000);

		boolean visible = false;
		boolean visible2 = false;
		int attempts = 0;
		while (attempts < 5) {
			try {
				Overlay.overlay(driver).getAttribute("style");
				visible = true;
				break;
			} catch(StaleElementReferenceException e) {
			}
			attempts++;
		}
		if (visible==true) {
			String overlayHidden = "";
			while (attempts < 5) {
				try {
					Overlay.overlay(driver).getAttribute("style");
					visible2 = true;
					overlayHidden = Overlay.overlay(driver).getAttribute("style");
					break;
				} catch(StaleElementReferenceException e) {
				}
				attempts++;
			} // end while
			// Wait for overlay to go away
			if (visible2==true) {
				// Set 40 second while loop timeout
				long start_time = System.currentTimeMillis();
				long wait_time = 40000;
				long end_time = start_time + wait_time;
				while (System.currentTimeMillis() < end_time && !overlayHidden.contains("visible")){

					Thread.sleep(1000);
					try {
						overlayHidden = Overlay.overlay(driver).getAttribute("style");
					} catch (StaleElementReferenceException e) {
						Thread.sleep(2000);
						overlayHidden = Overlay.overlay(driver).getAttribute("style");
					} // end try/catch

					if (overlayHidden.contains("visible"))
					{
						System.out.println("Overlay is visible");
						Thread.sleep(1000);
						break;
					} // end if
					Thread.sleep(1500);
				} // end while
			} // end if visible2
		} // end if		

	} // end waitForOverlay

	/**
	 * Wait for the busy icon to be hidden
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get a list of all the WebElements that have the icon_loading.gif</li>
	 * 	<li>Get the parent element of each of those WebElements</li>
	 * 	<li>Go through each parent element and get the style attribute</li>
	 * 	<li>Wait until the style does not contain block</li>
	 * </ul>
	 * @param driver The driver
	 * @throws InterruptedException the interrupted exception
	 */
	public void waitForBusyToBeHidden(RemoteWebDriver driver) throws InterruptedException
	{

//		Thread.sleep(4000);

		System.out.println("Waiting for the busy message to go away");
		
		// Get all elements with the id of divMessageBusy and make sure they are hidden
		List<WebElement> busy = driver.findElements(By.cssSelector("img[src='/Images/icon_loading.gif']"));

		// Wait until the element is no longer visible
		new WebDriverWait(driver,90).until(ExpectedConditions.invisibilityOfAllElements(busy));
		
		System.out.println("Busy message is not displayed");
		
//		// For each element found
//		for(WebElement el : busy) 
//		{
//
//			// Initialize variables
//			boolean found = false;
//			String display = null;
//			int i = 1;
//			
//			// Get the parent element
//			WebElement parent = null;
//			try {
//				parent = el.findElement(By.xpath("./.."));
//				found = true;
//			} catch (Exception e) {
//				System.out.println("Parent element not found for loading gif");
//			}
//			
//			if (found==true) {
//				
//				try {
//					// Get the style attribute
//					display = parent.getAttribute("style");
//					
//					// Wait for the element to be gone
//					while (display.contains("block") && i++<=60) {
//						
//						sleep(driver, 1);
//						try {
//							// Get the style attribute
//							display = parent.getAttribute("style");
//						} catch (Exception e) {
////							waitForBusyToBeHidden(driver);
//						} // end try/catch
//						
//					} // end while
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
//			} // end if found
//		} // end for
		
	} // end waitForBusyToBeHidden

	/**
	 * Wait for the busy icon to be hidden in NexGen
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get the busy element .pageLoader class</li>
	 * 	<li>If the element exists, enter a while loop that checks for the element every 2 seconds until it is gone</li>
	 * </ul>
	 * @param driver The driver
	 * @throws InterruptedException the interrupted exception
	 */
	public void waitForBusyToBeHiddenNexGen(RemoteWebDriver driver) throws InterruptedException
	{

		System.out.println("Waiting for the busy message to go away");

		// Set implicit wait for this method to 0
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

		// Get the busy element
		int busy = driver.findElements(By.cssSelector(".pageLoader")).size();

		int attempts = 0;
		while (busy > 0 && attempts <= 10) {

			// Wait for 1 second
			Thread.sleep(1000);

			// Get busy element
			try {
				busy = driver.findElements(By.cssSelector(".pageLoader")).size();
			} catch (StaleElementReferenceException e) {
				busy = driver.findElements(By.cssSelector(".pageLoader")).size();
			} // end try/catch

			attempts++;

		} // end while

		// Set implicit wait back to 10
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	} // end waitForBusyToBeHiddenNexGen

	/**
	 * Check to see if a WebElement contains a particular attribute
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Try to get the attribute of an element</li>
	 * 	<li>If the element exists, return true, otherwise it will return false</li>
	 * </ul>
	 * @param driver The driver
	 * @param element The WebElement you want to check attributes of
	 * @param attribute The attribute you want to see if it exists
	 * @return Returns true if the attribute is part of the WebElement
	 */
	public boolean isAttribtuePresent(RemoteWebDriver driver, WebElement element, String attribute) {
		Boolean result = false;
		try {
			String value = element.getAttribute(attribute);
			if (value != null){
				result = true;
			}
		} catch (Exception e) {}

		return result;
	}

	/**
	 * Verify XSite Order Details for a Lender
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the order information to a String</li>
	 * 	<li>Verify the Property information contains certain StoredVariables</li>
	 * 	<li>Verify the Assignment information contains certain StoredVariables</li>
	 * 	<li>Verify the Lender information contains certain StoredVariables</li>
	 * 	<li>Verify the Contact and Access information contains certain StoredVariables</li>
	 * 	<li>Verify the Additional Data information contains certain StoredVariables</li>
	 * </ul>
	 * @param driver The driver
	 */
	public void verifyXSiteOrderDetailsForLender(RemoteWebDriver driver)
	{

		System.out.println("Verifying Order Details On XSite For Lender");

		String orderInformation = XOrders.orderInformation_txt(driver).getText();

		// Property Information
		Assert.assertTrue(orderInformation.contains(StoredVariables.getpropertyInformationAddress().get()), "Address is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getpropertyInformationCity().get()), "City is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getpropertyInformationStateAbbr().get()), "State is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getpropertyInformationZip().get()), "Zip Code is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getpropertyInformationPropType().get()), "Prop Type is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getpropertyInformationLegalDesc().get()), "Legal Description is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getpropertyInformationDirections().get()), "Directions is not displayed on the Order Confirmation page");

		// Assignment Information
		Assert.assertTrue(orderInformation.contains(StoredVariables.getassignmentInformationForm().get()), "Form is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getassignmentInformationOtherRefNumber().get()), "Other Ref Number is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getassignmentInformationLoanType().get()), "Loan Type is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getassignmentInformationLoanPurpose().get()), "Loan Purpose is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getassignmentInformationOrderedBy().get()), "Ordered By is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getassignmentInformationLoanNumber().get()), "Loan Number is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getassignmentInformationFileNumber().get()), "File Number is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getassignmentInformationSalesPrice().get()), "Sales Price is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getassignmentInformationFHACaseNumber().get()), "FHA Case Number is not displayed on the Order Confirmation page");

		// Lender Information
		Assert.assertTrue(orderInformation.contains(StoredVariables.getlenderInformationLenderName().get()), "Lender Name is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getlenderInformationAddress1().get()), "Lender Stret is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getlenderInformationCity().get()), "Lender City is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getlenderInformationZip().get()), "Lender Zip is not displayed on the Order Confirmation page");

		// Contact and Access Information
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactOccupancy().get()), "Occupancy is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactBorrower().get()), "Borrower is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactBorrowerInfo1().get()), "Borrower Info 1 is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactBorrowerInfo2().get()), "Borrower Info 2 is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactCoBorrower().get()), "CoBorrower is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactCoBorrowerInfo1().get()), "CoBorrower Info 1 is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactCoBorrowerInfo2().get()), "CoBorrower Info 2 is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactOwner().get()), "Owner is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactOwnerInfo1().get()), "Owner Info 1 is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactOwnerInfo2().get()), "Owner Info 2 is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactOccupant().get()), "Occupant is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactOccupantInfo1().get()), "Occupant Info 1 is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactOccupantInfo2().get()), "Occupant Info 2 is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactAgent().get()), "Agent is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactAgentInfo1().get()), "Agent Info 1 is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactAgentInfo2().get()), "Agent Info 2 is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactOther().get()), "Other is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactOtherInfo1().get()), "Other Info 1 is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactOtherInfo2().get()), "Other Info 2 is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactApptContact().get()), "Appt Contact is not displayed on the Order Confirmation page");

		// Additional Data
		Assert.assertTrue(orderInformation.contains(StoredVariables.getadditionalNotificationRecipientsAdditionalEmails().get()), "Additional Emails are not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getadditionalComments().get()), "Additional Comments are not displayed on the Order Confirmation page");

	} // end verifyXSiteOrderDetailsForLender

	/**
	 * Verify XSite Order Details for an AMC
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the order information to a String</li>
	 * 	<li>Verify the Property information contains certain StoredVariables</li>
	 * 	<li>Verify the Assignment information contains certain StoredVariables</li>
	 * 	<li>Verify the Lender information contains certain StoredVariables</li>
	 * 	<li>Verify the Contact and Access information contains certain StoredVariables</li>
	 * 	<li>Verify the Additional Data information contains certain StoredVariables</li>
	 * </ul>
	 * @param driver The driver
	 */
	public void verifyXSiteOrderDetailsForAMC(RemoteWebDriver driver)
	{

		System.out.println("Verifying Order Details On XSite For AMC");

		String orderInformation = XOrders.orderInformation_txt(driver).getText();

		// Property Information
		Assert.assertTrue(orderInformation.contains(StoredVariables.getpropertyInformationAddress().get()), "Address is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getpropertyInformationCity().get()), "City is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getpropertyInformationStateAbbr().get()), "State is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getpropertyInformationZip().get()), "Zip Code is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getpropertyInformationPropType().get()), "Prop Type is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getpropertyInformationLegalDesc().get()), "Legal Description is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getpropertyInformationDirections().get()), "Directions is not displayed on the Order Confirmation page");

		// Assignment Information
		String form = StoredVariables.getassignmentInformationForm().get();
		if (form.equals("1004 Full/URAR"))
		{
			form = "Uniform Residential Appraisal (FNMA 1004)";
		}
		Assert.assertTrue(orderInformation.contains(form), "Form is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getassignmentInformationOtherRefNumber().get()), "Other Ref Number is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getassignmentInformationLoanType().get()), "Loan Type is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getassignmentInformationLoanPurpose().get()), "Loan Purpose is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getassignmentInformationOrderedBy().get()), "Ordered By is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getassignmentInformationLoanNumber().get()), "Loan Number is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getassignmentInformationFileNumber().get()), "File Number is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getassignmentInformationSalesPrice().get()), "Sales Price is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getassignmentInformationFHACaseNumber().get()), "FHA Case Number is not displayed on the Order Confirmation page");

		// Lender Information
		Assert.assertTrue(orderInformation.contains(StoredVariables.getlenderInformationLenderName().get()), "Lender Name is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getlenderInformationAddress1().get()), "Lender Stret is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getlenderInformationCity().get()), "Lender City is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getlenderInformationZip().get()), "Lender Zip is not displayed on the Order Confirmation page");

		// Contact and Access Information
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactOccupancy().get()), "Occupancy is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactBorrower().get()), "Borrower is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactBorrowerInfo1().get()), "Borrower Info 1 is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactBorrowerInfo2().get()), "Borrower Info 2 is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactCoBorrower().get()), "CoBorrower is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactCoBorrowerInfo1().get()), "CoBorrower Info 1 is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactCoBorrowerInfo2().get()), "CoBorrower Info 2 is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactOwner().get()), "Owner is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactOwnerInfo1().get()), "Owner Info 1 is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactOwnerInfo2().get()), "Owner Info 2 is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactOccupant().get()), "Occupant is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactOccupantInfo1().get()), "Occupant Info 1 is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactOccupantInfo2().get()), "Occupant Info 2 is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactAgent().get()), "Agent is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactAgentInfo1().get()), "Agent Info 1 is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactAgentInfo2().get()), "Agent Info 2 is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactOther().get()), "Other is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactOtherInfo1().get()), "Other Info 1 is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactOtherInfo2().get()), "Other Info 2 is not displayed on the Order Confirmation page");
		Assert.assertTrue(orderInformation.contains(StoredVariables.getcontactApptContact().get()), "Appt Contact is not displayed on the Order Confirmation page");

		// Additional Data
		Assert.assertTrue(orderInformation.contains(StoredVariables.getadditionalComments().get()), "Additional Comments are not displayed on the Order Confirmation page");

	} // end verifyXSiteOrderDetailsForAMC

	/**
	 * Wait for element to be clickable
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Create a new WebDriverWait instance</li>
	 * 	<li>Create the element wait to be clickable based on the locatorType</li>
	 * </ul>
	 * @param driver The driver
	 * @param field The selector information of a WebElement
	 * @param locatorType The type of locator for the element (ie. id, cssSelector, etc)
	 * @throws InterruptedException the interrupted exception
	 */
	@SuppressWarnings("unused")
	public void waitForElementToBeClickable(RemoteWebDriver driver, String field, String locatorType) throws InterruptedException
	{

		System.out.println("Wait for element " + field);

		// Wait for element
		WebDriverWait wait = new WebDriverWait(driver, 90);
		if (locatorType.equals("id"))
		{
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id(field)));
		}
		else if (locatorType.startsWith("css"))
		{
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(field)));
		}
		else if (locatorType.equals("linkText"))
		{
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(field)));
		}
		else if (locatorType.equals("xpath"))
		{
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(field)));
		}

	} // end waitForElementToBeClickable

	/**
	 * Wait for element to be clickable
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Create a new WebDriverWait instance</li>
	 * 	<li>Create the element wait to be clickable</li>
	 * </ul>
	 * @param driver The driver
	 * @param element The WebElement locator
	 * @throws InterruptedException the interrupted exception
	 */
	public void waitForElementToBeClickable(RemoteWebDriver driver, WebElement element) throws InterruptedException
	{

		System.out.println("Wait for element " + element);

		// Wait for element
		WebDriverWait wait = new WebDriverWait(driver, 90);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (StaleElementReferenceException e) {
			System.err.println("Element became stale: " + element.toString());
			element = rebuildElement(driver, element);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}

	} // end waitForElementToBeClickable

	/**
	 * Wait for element to be visible
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Create a new WebDriverWait instance</li>
	 * 	<li>Create the element wait to be visible based on the locatorType</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @param field The selector information of a WebElement
	 * @param locatorType The type of locator for the element (ie. id, cssSelector, etc)
	 * @throws InterruptedException the interrupted exception
	 */
	@SuppressWarnings("unused")
	public void waitForElementToBeVisible(RemoteWebDriver driver, String field, String locatorType) throws InterruptedException
	{

		// Wait for element
		WebDriverWait wait = new WebDriverWait(driver, 90);
		if (locatorType.equals("id"))
		{
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(field)));
		}
		else if (locatorType.startsWith("cssSelector"))
		{
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(field)));
		}

	} // end waitForElementToBeVisible
	
	/**
	 * Rebuild Element
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Create a String for the element</li>
	 * 	<li>Create a String for the locatorType</li>
	 *  <li>Create a String for the locator of the element</li>
	 *  <li>Use a switch statement to rebuild the element based on the locatorType</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @param element the element
	 * @return the web element
	 */
	public WebElement rebuildElement(RemoteWebDriver driver, WebElement element){
		
	    String sElement = element.toString().split("-> ")[1];
	    String locatorType = sElement.split(": ")[0];
	    String loc0 = sElement.split(": ")[1];
	    String theLocator = loc0.substring(0,loc0.length()-1);
	    System.out.println("Refreshing element with "+locatorType+": "+theLocator);
	    
	    switch (locatorType) {
	    case "id":
	    	element = driver.findElement(By.id(theLocator));
	    	break;
	    case "css selector":
	    	element = driver.findElement(By.cssSelector(theLocator));
	    	break;
	    case "link text":
	    	element = driver.findElement(By.linkText(theLocator));
	    	break;
	    case "xpath":
	    	element = driver.findElement(By.xpath(theLocator));
	    	break;
	    default:
	    	element = null;
	    	break;
	    } // end switch
	    
	    return element;
	    
	} // end rebuildElement

	/**
	 * Wait for element to be visible
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Create a new WebDriverWait instance</li>
	 * 	<li>Create the element wait to be visible based on the locatorType</li>
	 * </ul>.
	 *
	 * @param driver The driver
	 * @param element The WebElement to wait for
	 * @throws InterruptedException the interrupted exception
	 */
	public void waitForElementToBeVisible(RemoteWebDriver driver, WebElement element) throws InterruptedException
	{
		try {
			(new WebDriverWait(driver,90)).until(ExpectedConditions.visibilityOf(element));
		} catch (StaleElementReferenceException e) {
			System.err.println("Element became stale: " + element.toString());
			element = rebuildElement(driver, element);
			(new WebDriverWait(driver,90)).until(ExpectedConditions.visibilityOf(element));
		}
	} // end waitForElementToBeVisible
	
	/**
	 * Wait for text
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the text of an element to a String</li>
	 * 	<li>Enter a while loop to keep checking the text of the element until the element contains the given text</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @param element The WebElement to wait for text to be displayed in
	 * @param text The text that should be displayed in a WebElement
	 * @throws InterruptedException the interrupted exception
	 * @return returns if the text was found
	 */
	public boolean waitForText(RemoteWebDriver driver, WebElement element, String text) throws InterruptedException
	{

		System.out.println("Wait for text - " + text);

		boolean textFound = false;
		
		// Set 40 second while loop timeout
		long start_time = System.currentTimeMillis();
		long wait_time = 300000;
		long end_time = start_time + wait_time;

		String getText;
		try {
			getText = element.getText();
		} catch (Exception e1) {
			element = rebuildElement(driver, element);
			getText = element.getText();
		} // end try/catch
		while(System.currentTimeMillis() < end_time && !getText.contains(text))
		{
			Thread.sleep(2000);
			try {
				getText = element.getText();
			} catch (StaleElementReferenceException e) {
				element = rebuildElement(driver, element);
			} // end try/catch
			if (getText.contains(text))
			{
				textFound = true;
				break;
			} // end if
		} // end while

		return textFound;
		
	} // end waitForText
	
	/**
	 * Wait for text of an attribute to update
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the text of an element to a String</li>
	 * 	<li>Enter a while loop to keep checking the attribute text of the element until the element contains the given text</li>
	 * </ul>.
	 *
	 * @param driver The driver
	 * @param element The WebElement to wait for text to be displayed in
	 * @param attribute the attribute
	 * @param expectedText the expected text
	 * @return returns if the text was found
	 * @throws InterruptedException the interrupted exception
	 */
	public boolean waitForAttributeValueToBePresent(RemoteWebDriver driver, WebElement element, String attribute, String expectedText) throws InterruptedException
	{

		System.out.println("Wait for attribute value to be present - " + expectedText);

		boolean textFound = false;
		
		// Set 40 second while loop timeout
		long start_time = System.currentTimeMillis();
		long wait_time = 90000;
		long end_time = start_time + wait_time;

		String getText;
		try {
			getText = element.getAttribute(attribute);
		} catch (Exception e1) {
			element = rebuildElement(driver, element);
			getText = element.getAttribute(attribute);
		} // end try/catch
		while(System.currentTimeMillis() < end_time && !getText.contains(expectedText))
		{
			Thread.sleep(2000);
			try {
				getText = element.getAttribute(attribute);
			} catch (StaleElementReferenceException e) {
				element = rebuildElement(driver, element);
			} // end try/catch
			if (getText.contains(expectedText))
			{
				textFound = true;
				break;
			} // end if
		} // end while

		return textFound;
		
	} // end waitForAttributeValueToBePresent

	/**
	 * Wait for text on a page written in Angular
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the text of an element to a String</li>
	 * 	<li>Enter a while loop to keep checking the text of the element until the element contains the given text</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @param element The WebElement to wait for text to be displayed in
	 * @param text The text that should be displayed in a WebElement
	 * @throws InterruptedException the interrupted exception
	 */
	// Wait for text (in Angular)
	public void waitForTextAngular(RemoteWebDriver driver, WebElement element, String text) throws InterruptedException
	{

		System.out.println("Wait for text - " + text);

		// Set 40 second while loop timeout
		long start_time = System.currentTimeMillis();
		long wait_time = 90000;
		long end_time = start_time + wait_time;

		String getText = element.getAttribute("value");
		while(System.currentTimeMillis() < end_time && !getText.contains(text))
		{
			Thread.sleep(2000);
			try {
				getText = element.getAttribute("value");
			} catch (StaleElementReferenceException e) {
				element = rebuildElement(driver, element);
			} // end try/catch
			if (getText.contains(text))
			{
				break;
			} // end if
		} // end while

	} // end waitForTextAngular

	/**
	 * Wait for text on a page written in Angular
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the text of an element to a String</li>
	 * 	<li>Enter a while loop to keep checking the text of the element until the element contains the given text</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @param element The WebElement to wait for text to be displayed in
	 * @param text The text that should be displayed in a WebElement
	 * @throws InterruptedException the interrupted exception
	 */
	// Wait for text (in Angular)
	public void waitForTextAngularGetText(RemoteWebDriver driver, WebElement element, String text) throws InterruptedException
	{

		System.out.println("Wait for text - " + text);

		// Set 40 second while loop timeout
		long start_time = System.currentTimeMillis();
		long wait_time = 90000;
		long end_time = start_time + wait_time;

		String getText = element.getText();
		System.out.println("getText: " + getText);
		while(System.currentTimeMillis() < end_time && !getText.contains(text))
		{
			Thread.sleep(500);
			try {
				getText = element.getText();
			} catch (StaleElementReferenceException e) {
				element = rebuildElement(driver, element);
			} // end try/catch
			System.out.println("getText: " + getText);
			if (getText.contains(text))
			{
				break;
			} // end if
		} // end while

	} // end waitForTextAngularGetText

	/**
	 * Wait for multiple iFrames
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Create a list of all iFrame elements</li>
	 * 	<li>Get the number of iFrames</li>
	 * 	<li>Enter a while loop that continues until there is an iFrame on the page</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @throws InterruptedException the interrupted exception
	 */
	@SuppressWarnings("unused")
	public void waitForIFrames(RemoteWebDriver driver) throws InterruptedException
	{

		System.out.println("Wait for iFrames");

		// Count the number of iFrames until there are more than 1
		List<WebElement> myIframes= driver.findElements(By.tagName("iframe"));
		int numOfFrames = myIframes.size();
		System.out.println("number of iFrames = " + myIframes.size());

		// Set 40 second while loop timeout
		long start_time = System.currentTimeMillis();
		long wait_time = 40000;
		long end_time = start_time + wait_time;
		while (System.currentTimeMillis() < end_time && myIframes.size() < 1)
		{
			System.out.println("number of iFrames = " + myIframes.size());
			myIframes= driver.findElements(By.tagName("iframe"));
			Thread.sleep(500);
			if (myIframes.size() > 1)
			{
				System.out.println("Found " + myIframes.size() + " iFrames");
				break;
			}
		} // end while statement

	} // end waitForIFrames

	/**
	 * Wait for multiple windows to be opened
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Wait until multiple windows are opened</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @throws InterruptedException the interrupted exception
	 */
	public void waitForMultipleWindowsToBeOpened(RemoteWebDriver driver) throws InterruptedException
	{

		// Wait for multiple windows to be opened
		int numOfWindows = driver.getWindowHandles().size();
		System.out.println("numOfWindows: " + numOfWindows);
		int a = 1;
		while (numOfWindows<2 && a<=15) {
			System.out.println("Number of windows: " + numOfWindows);
			perform.sleep(driver, 1);
			numOfWindows = driver.getWindowHandles().size();
			a++;
		} // end wait for multiple windows

	} // end waitForMultipleWindowsToBeOpened
	
	/**
	 * Switch to Frame by index value
	 * <p>
	 * STEPS:
	 * <ul>
	 *  <li>Wait for iframe to exist</li>
	 * 	<li>Switch to the iFrame by the index value</li>
	 * </ul>.
	 *
	 * @param driver The driver
	 * @param index the index
	 * @throws InterruptedException the interrupted exception
	 */
	public void switchToiFrameByIndex(RemoteWebDriver driver, int index) throws InterruptedException
	{
		
		System.out.println("Switch to frame index = " + index);
		
		// Get outside frames
		driver.switchTo().defaultContent();
		
		// Wait for iFrames
		waitForIFrames(driver);
		
		// Switch to the iFrame by the index value
		driver.switchTo().frame(index);

	} // end switchToiFrameByIndex

	/**
	 * Switch to Frame by src
	 * <p>
	 * STEPS:
	 * <ul>
	 *  <li>Wait for iframe to exist</li>
	 * 	<li>Create a new WebDriverWait instance</li>
	 * 	<li>Wait until the iFrame is visible and switch into it by the src attribute</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @param src The src attribute value of the iFrame you want to switch to
	 * @throws InterruptedException the interrupted exception
	 */
	public void switchToiFrameBySrc(RemoteWebDriver driver, String src) throws InterruptedException
	{
		
		System.out.println("Switch to frame src = " + src);
		
		// Get outside frames
		driver.switchTo().defaultContent();
		
		// Wait for iFrames
		waitForIFrames(driver);
		
		// Wait until the frame exists and switch to it
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//frame[contains(@src,'" + src + "')]")));

	} // end switchToiFrameBySrc

	/**
	 * Switch to iFrame by id
	 * <p>
	 * STEPS:
	 * <ul>
	 *  <li>Wait for iframe to exist</li>
	 * 	<li>Create a new WebDriverWait instance</li>
	 * 	<li>Wait until the iFrame is visible and switch into it by the id attribute</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @param id The id attribute of the iFrame you want to switch to
	 * @throws InterruptedException the interrupted exception
	 */
	public void switchToiFrameByID(RemoteWebDriver driver, String id) throws InterruptedException
	{

		System.out.println("Switch to frame id = " + id);
		
		// Get outside frames
		driver.switchTo().defaultContent();
		
		// Wait for iFrames
		waitForIFrames(driver);
		
		// Wait until the frame exists and switch to it
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id(id)));

	} // end switchToiFrameByID
	
	/**
	 * Switch to Frame by src
	 * <p>
	 * STEPS:
	 * <ul>
	 *  <li>Wait for iframe to exist</li>
	 * 	<li>Create a new WebDriverWait instance</li>
	 * 	<li>Wait until the iFrame is visible and switch into it by the src attribute</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @param src The src attribute value of the iFrame you want to switch to
	 * @throws InterruptedException the interrupted exception
	 */
	public void switchToNestediFrameBySrc(RemoteWebDriver driver, String src) throws InterruptedException
	{
		
		System.out.println("Switch to frame src = " + src);
		
		// Wait for iFrames
		waitForIFrames(driver);
		
		// Wait until the frame exists and switch to it
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//frame[contains(@src,'" + src + "')]")));

	} // end switchToNestediFrameBySrc

	/**
	 * Switch to iFrame by id
	 * <p>
	 * STEPS:
	 * <ul>
	 *  <li>Wait for iframe to exist</li>
	 * 	<li>Create a new WebDriverWait instance</li>
	 * 	<li>Wait until the iFrame is visible and switch into it by the id attribute</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @param id The id attribute of the iFrame you want to switch to
	 * @throws InterruptedException the interrupted exception
	 */
	public void switchToNestediFrameByID(RemoteWebDriver driver, String id) throws InterruptedException
	{

		System.out.println("Switch to frame id = " + id);
		
		// Wait for iFrames
		waitForIFrames(driver);
		
		// Wait until the frame exists and switch to it
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id(id)));

	} // end switchToNestediFrameByID
	
	/**
	 * Wait for the page to be loaded
	 *
	 * @param driver The driver
	 */
	public void waitForPageLoaded(RemoteWebDriver driver) {
		
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    } // end apply
                }; // end ExpectedCondition
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        } // end try/catch
        
    } // end waitForPageLoaded
	
	/**
	 * Check for window by title
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Iterate through list of windows</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @param windowTitle The title of the window expected
	 * @return found Whether or not the window was opened
	 * @throws InterruptedException the interrupted exception
	 */
	public boolean checkForWindowOpened(RemoteWebDriver driver, String windowTitle) throws InterruptedException
	{

		boolean found = false;

		// Get list of windows
		Iterator<String> windowIterator = driver.getWindowHandles().iterator();

		// Iterate through the windows and check for the expected window title
		while (windowIterator.hasNext()) {
			String windowHandle1 = windowIterator.next();
			try {
				driver.switchTo().window(windowHandle1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			waitForPageLoaded(driver);
			String title = driver.getTitle();
			System.out.println("title: " + title);
			if (title.contains(windowTitle)) {
				System.out.println("Window found");
				found = true;
				break;
			} // end if
		} // end while loop

		return found;

	} // end checkForWindowOpened
	
	/**
	 * Switch to a new window by the title
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Iterate through all of the existing windows and set the window handle for each one</li>
	 * 	<li>Set the title of each window to a String</li>
	 * 	<li>Check to see if the title contains the expected title given and break out of the while loop when a match is found</li>
	 * 	<li>Set the new window handle to a StoredVariable</li>
	 * 	<li>Switch to the new window by the window handle obtained</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @param windowTitle The title of the new window you want to switch to
	 * @throws InterruptedException the interrupted exception
	 */
	// Switch to window by title
	public void switchToWindowByTitle (RemoteWebDriver driver, String windowTitle) throws InterruptedException
	{

		sleep(driver, 3);

		// Wait for multiple windows to be opened
		int numOfWindows = driver.getWindowHandles().size();
		System.out.println("Number of windows: " + numOfWindows);
		int a = 1;
		while (numOfWindows<2 && a<=15) {
			System.out.println("Number of windows: " + numOfWindows);
			perform.sleep(driver, 1);
			numOfWindows = driver.getWindowHandles().size();
			a++;
		} // end wait for multiple windows

//		// Check for the window to be opened
//		boolean windowExists = perform.checkForWindowOpened(driver, windowTitle);
//		System.out.println("windowExists: " + windowExists);

		// Go to new window
		if (numOfWindows>1) {
			Iterator<String> windowIterator = driver.getWindowHandles().iterator();
			boolean found = false;
			int i = 1;
			while (found==false && i <=10) {
				while (windowIterator.hasNext()) {
					String windowHandle1 = windowIterator.next();
					driver.switchTo().window(windowHandle1);
					String title = driver.getTitle();
					System.out.println("title = " + title);
					if (title.contains(windowTitle)) {
						System.out.println("Switching to window: " + windowTitle);
						found = true;
						break;
					} // end if
				} // end while loop
				i++;
			}
			// Get the new Window Handle
			StoredVariables.getnewWinHandle().set(driver.getWindowHandle());
			System.out.println("newWinHandle = " + StoredVariables.getnewWinHandle().get());

			// Switch to the new window
			driver.switchTo().window(StoredVariables.getnewWinHandle().get());

		} else {

			// Throw exception because there is only 1 window
			throw new IllegalArgumentException("There is only 1 window open");

		} // end if switching to new window

	} // end switchToWindowByTitle

	/**
	 * Switch to a new window by the title
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the window handle of the current window to a StoredVariable</li>
	 * 	<li>Iterate through all of the existing windows and set the window handle for each one</li>
	 * 	<li>Set the title of each window to a String</li>
	 * 	<li>Check to see if the title contains the expected title given and break out of the while loop when a match is found</li>
	 * 	<li>Set the new window handle to a StoredVariable</li>
	 * 	<li>Switch to the new window by the window handle obtained</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @param windowTitle The title of the new window you want to switch to
	 * @throws InterruptedException the interrupted exception
	 */
	// Switch to window by title
	public void switchToXSiteWindowByTitle (RemoteWebDriver driver, String windowTitle) throws InterruptedException
	{

		sleep(driver, 3);

		// Get the Window Handle before the new window opens
		String windHandleBefore = driver.getWindowHandle();

		// Wait for multiple windows to be opened
		int numOfWindows = driver.getWindowHandles().size();
		System.out.println("Number of windows: " + numOfWindows);
		int a = 1;
		while (numOfWindows<2 && a<=15) {
			System.out.println("Number of windows: " + numOfWindows);
			perform.sleep(driver, 1);
			numOfWindows = driver.getWindowHandles().size();
			a++;
		} // end wait for multiple windows
		
		// Verify there are multiple windows opened
		Assert.assertTrue(numOfWindows>1, "There was a problem opening the other tab(s)");

		// Check for the window to be opened
		boolean windowExists = perform.checkForWindowOpened(driver, windowTitle);
		System.out.println("windowExists: " + windowExists);

		// While the window is not opened, try again
		int b = 1;
		while (windowExists==false && b<=15) {

			// Switch back to the original window
			driver.switchTo().window(windHandleBefore);

			// Click View XSite Order link
			perform.click(driver, SOrderDetails.viewXSiteOrder_lnk(driver));

			// Check if window exists
			windowExists = perform.checkForWindowOpened(driver, windowTitle);
			System.out.println("windowExists: " + windowExists);

			b++;

		} // end while

		if (numOfWindows>1) {
			// Go to new window
			Iterator<String> windowIterator = driver.getWindowHandles().iterator();
			while (windowIterator.hasNext()) {
				String windowHandle1 = windowIterator.next();
				driver.switchTo().window(windowHandle1);
				String title = driver.getTitle();
				System.out.println("title = " + title);
				if (title.contains(windowTitle)) {
					System.out.println("break");
					break;
				} // end if
			} // end while loop

			// Get the new Window Handle
			StoredVariables.getnewWinHandle().set(driver.getWindowHandle());
			System.out.println("newWinHandle = " + StoredVariables.getnewWinHandle().get());

			// Switch to the new window
			driver.switchTo().window(StoredVariables.getnewWinHandle().get());

		} else {

			// Throw exception because there is only 1 window
			throw new IllegalArgumentException("There is only 1 window open");

		} // end if switching to new window

	} // end switchToXSiteWindowByTitle

	/**
	 * Switch to a new window
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Wait for multiple windows to be opened</li>
	 * 	<li>Iterate through the open windows and getting the window handle</li>
	 *  <li>If the window handle does not match the window handle of the original screen, switch to it</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @param windHandleBefore The window handle of the original page
	 * @throws InterruptedException the exception
	 */
	public void switchToNewWindow(RemoteWebDriver driver, String windHandleBefore) throws InterruptedException
	{

		// Wait for multiple windows to be opened
		int numOfWindows = driver.getWindowHandles().size();
		System.out.println("Number of windows: " + numOfWindows);
		int a = 1;
		while (numOfWindows<2 && a<=15) {
			System.out.println("Number of windows: " + numOfWindows);
			perform.sleep(driver, 1);
			numOfWindows = driver.getWindowHandles().size();
			a++;
		} // end wait for multiple windows

		// Find the new window and switch to it
		if (numOfWindows>1) {
			// Go to new window
			Iterator<String> windowIterator = driver.getWindowHandles().iterator();
			while (windowIterator.hasNext()) {
				String windowHandle1 = windowIterator.next();
				if (!windowHandle1.equals(windHandleBefore)) {
					driver.switchTo().window(windowHandle1);
					System.out.println("Switched to new window");
					break;
				} // end if
			} // end while loop

			// Get the new Window Handle
			StoredVariables.getnewWinHandle().set(driver.getWindowHandle());
			System.out.println("newWinHandle = " + StoredVariables.getnewWinHandle().get());

			// Switch to the new window
			driver.switchTo().window(StoredVariables.getnewWinHandle().get());

		} else {

			// Throw exception because there is only 1 window
			throw new IllegalArgumentException("There is only 1 window open");

		} // end if switching to new window

	} // end switchToNewWindow

	/**
	 * Enable all options in Status Mapping Configuration
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Create a list of all grdCell elements</li>
	 * 	<li>Iterate through the list and if the cell enabled and unselected, click it</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @throws InterruptedException the interrupted exception
	 */
	public void enableAllOptionsInStatusMappingConfiguration(RemoteWebDriver driver) throws InterruptedException
	{

		ExtentTest test = ExtentTestManager.getTest();

		System.out.println("Enable all options in Status Mapping Configuration");
		
		// Wait for element to be clickable
		perform.waitForElementToBeClickable(driver, driver.findElement(By.cssSelector("td[class='grdCell']")));

		// Create a list of elements
		List<WebElement> els = driver.findElements(By.cssSelector("td[class='grdCell']"));
		for(WebElement el : els) 
		{
			// Get the class attribute
			String elClass = el.getAttribute("class");
			// if class contains grdCell_Gray, don't do anything
			if (elClass.contains("grdCell_Gray")){
				// don't do anything
			}
			else{
				// Get text
				String elText = el.getText();
				// If there is no text, click the cell
				if(elText.isEmpty() && el.findElement(By.tagName("img")).getAttribute("style").contains("hidden"))
				{
					click(driver, el);
				} // end if text is empty
			} // end if cell is not Gray
		} // end for loop

		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Enabled all options in Status Mapping");

	} // end enableAllOptionsInStatusMappingConfiguration

	/**
	 * Disable all options for Status Mapping Configuration
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Create a list of all grdCell elements</li>
	 * 	<li>Iterate through the list and if the cell enabled and selected, click it</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @throws InterruptedException the interrupted exception
	 */
	public void disableAllOptionsInStatusMappingConfiguration(RemoteWebDriver driver) throws InterruptedException
	{

		ExtentTest test = ExtentTestManager.getTest();

		System.out.println("Enable all options in Status Mapping Configuration");

		List<WebElement> els = driver.findElements(By.cssSelector("td[class='grdCell']"));
		for(WebElement el : els) 
		{
			// Get the class attribute
			String elClass = el.getAttribute("class");
			// if class contains grdCell_Gray, don't do anything
			if (elClass.contains("grdCell_Gray")){
				// don't do anything
			}
			else{
				// Get text
				String elText = el.getText();
				// If there is no text, click the cell
				if(elText.isEmpty() && el.findElement(By.tagName("img")).getAttribute("style").contains("visible"))
				{
					click(driver, el);
				} // end if text is empty
			} // end if cell is not Gray
		} // end for loop

		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Disabled all options in Status Mapping");

	} // end disableAllOptionsInStatusMappingConfiguration

	/**
	 * Check all checkboxes to sync to VMP
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Create a list of all checkbox elements</li>
	 * 	<li>Iterate through the list and if the checkbox is unchecked, check it</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @throws InterruptedException the interrupted exception
	 */
	public void enableAllCheckboxesToSyncToVMP(RemoteWebDriver driver) throws InterruptedException
	{

		ExtentTest test = ExtentTestManager.getTest();

		System.out.println("Enable all checkboxes to sync to VMP");

		List<WebElement> els = driver.findElements(By.cssSelector("input[type='checkbox']"));
		for(WebElement el : els) 
		{
			// If checkbox is not checked, check it
			if (!el.isSelected())
			{
				((JavascriptExecutor) driver).executeScript("arguments[0].click();",el);
			} // end if

		} // end for loop

		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Enabled all checkboxes to sync to VMP");

	} // end enableAllCheckboxesToSyncToVMP

	/**
	 * Close the new window/tab
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Close the current window</li>
	 * 	<li>Switch to the window handle set as the winHandleBefore StoredVariable</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void closeNewWindow(RemoteWebDriver driver) throws InterruptedException, IOException
	{

		System.out.println("Close new window");

		Thread.sleep(2000);

		// Close the new window
		driver.close();

		// Switch back to original browser (first window)
		driver.switchTo().window(StoredVariables.getwinHandleBefore().get());

		Thread.sleep(2000);

	} // end closeNewWindow

	/**
	 * Verify the number of rows returned in the MailQueue db table for a particular ProductItemID
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Query the MailQueue in the DB using the productItemID and get the number of rows returned</li>
	 * 	<li>If the number of rows don't match, try 5 times waiting 5 seconds between each check</li>
	 * 	<li>Verify the number of rows returned matches the number of rows expected</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @param expectedNumberOfRows The expected number of rows to be returned when querying the MailQueue DB
	 * @param productItemID The productItemID of the order you want to check the row count of
	 * @throws Exception the exception
	 */
	public void verifyTheNumberOfRowsInTheMailQueueDBResultsForProductItemID(RemoteWebDriver driver, int expectedNumberOfRows, String productItemID) throws Exception
	{

		ExtentTest test = ExtentTestManager.getTest();

		System.out.println("Verifying there were " + expectedNumberOfRows + " number or rows returned in the MailQueue query");

		// Verify MailQueue row count for this productItemID
		// Get the MailQueue data from the database and store it in an array
		Function_DB db = new Function_DB();
		ArrayList<String> mailQueue = db.getMailQueueInfoByProductItemIDToArray(driver, productItemID);

		// Get number of rows
		int numOfRows = (mailQueue.size()/19);

		// If the number of rows don't match, try 5 times waiting 5 seconds between each check
		if (numOfRows!=expectedNumberOfRows)
		{
			for (int a = 1; a <=60; a++)
			{
				// Refresh the browser every 20 iterations to Keep the session alive
				if (a%20==0)
				{
					driver.navigate().refresh();
				}

				// Check the db
				if (numOfRows!=expectedNumberOfRows)
				{
					// Wait for 10 seconds
					Thread.sleep(10000);

					// Run query again
					mailQueue = db.getMailQueueInfoByProductItemIDToArray(driver, productItemID);

					// Get number of rows
					numOfRows = (mailQueue.size()/19);

					System.out.println("numOfRows = " + numOfRows);
				} // end if
			} // end for loop
		} // end if

		// Set the number of expected rows
		Assert.assertTrue(numOfRows==expectedNumberOfRows, "There should be " + expectedNumberOfRows + " rows in the MailQueue at this time, but there are = " + numOfRows);

		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Verified there were " + expectedNumberOfRows + " number of rows in the MailQueue");

	} // end verifyTheNumberOfRowsInTheMailQueueDBResultsForProductItemID

	/**
	 * Execute AutoIT script
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Execute AutoIT script</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @param fileName The filename of the AutoIT script to run
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void autoIT(RemoteWebDriver driver, String fileName) throws InterruptedException, IOException
	{

		System.out.println("Execute AutoIT script - " + fileName);

		Thread.sleep(3000);

		Runtime.getRuntime().exec(StoredVariables.getautoIT().get() + fileName + ".exe");

	} // end autoIT

	/**
	 * Execute AutoIT script with variables passed in
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Execute AutoIT script with variables passed in</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @param fileName The filename of the AutoIT script to run
	 * @param variables Variables that will get passed in to the AutoIT script
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void autoIT_withVariables(RemoteWebDriver driver, String fileName, String variables) throws InterruptedException, IOException
	{

		System.out.println("Execute AutoIT script - " + fileName);

		Thread.sleep(3000);

		// Variables are used as an array item. Separate them with a space
		Runtime.getRuntime().exec(StoredVariables.getautoIT().get() + fileName + ".exe " + variables);

	} // end autoIT_withVariables

	/**
	 * Upload a document using AutoIT
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li></li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @param fileName The filename of the document to be uploaded by AutoIT
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void autoIT_uploadDocument(RemoteWebDriver driver, String fileName) throws InterruptedException, IOException
	{

		System.out.println("Upload the " + fileName + " document via AutoIT");

		Thread.sleep(6000);

		// Variables are used as an array item. Separate them with a space
		System.out.println("Upload file = " + StoredVariables.getautoIT().get() + "UploadDocument.exe " + StoredVariables.getautoIT().get() + " \"" + fileName + "\"");
		Runtime.getRuntime().exec(StoredVariables.getautoIT().get() + "UploadDocument.exe " + StoredVariables.getautoIT().get() + " \"" + fileName + "\"");

	} // end autoIT_uploadDocument

	/**
	 * Update the hosts file using AutoIT
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Execute the AutoIT script to update the hosts file based on the environment</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void autoIT_hostsSwitcher(RemoteWebDriver driver) throws InterruptedException, IOException
	{

		String env = StoredVariables.getenvironment().get();

		if (env.equals("Beta Offline"))
		{
			env = "BetaOffline";
		}
		if (env.equals("Live Offline"))
		{
			env = "LiveOffline";
		}

		System.out.println("Set hosts file to " + env + " via AutoIT");

		Thread.sleep(3000);

		Runtime.getRuntime().exec(StoredVariables.getautoIT().get()+"HostsSwitcher.exe " + StoredVariables.getautoIT().get() + " " + env);

	} // end autoIT_hostsSwitcher

	/**
	 * Clear Order Info Stored Variables
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set all of the Property Information variables to an empty String</li>
	 * 	<li>Set all of the Assignment Information variables to an empty String</li>
	 * 	<li>Set all of the Lender Information variables to an empty String</li>
	 * 	<li>Set all of the Contact and Access Information variables to an empty String</li>
	 * 	<li>Set all of the Additional Notification Recipients variables to an empty String</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @throws InterruptedException the interrupted exception
	 */
	public void clearOrderInfoStoredVariables(RemoteWebDriver driver) throws InterruptedException
	{

		System.out.println("Clear stored variable information");


		/***************************************
		 * Set New Order Information
		 ***************************************/

		// Set Property Information data
		StoredVariables.getpropertyInformationAddress().set("");
		StoredVariables.getpropertyInformationCity().set("");
		StoredVariables.getpropertyInformationState().set("");
		StoredVariables.getpropertyInformationStateAbbr().set(""); // Must set for a field check later on
		StoredVariables.getpropertyInformationZip().set("");
		StoredVariables.getpropertyInformationSqFt().set("");
		StoredVariables.getpropertyInformationSiteSize().set("");
		StoredVariables.getpropertyInformationPropType().set("");
		StoredVariables.getpropertyInformationPropRights().set("");
		StoredVariables.getpropertyInformationLegalDesc().set("");
		StoredVariables.getpropertyInformationDirections().set("");

		// Set Assignment Information data
		StoredVariables.getassignmentInformationForm().set("");
		StoredVariables.getassignmentInformationRushOrder().set(false);
		StoredVariables.getassignmentInformationComplex().set(false);
		StoredVariables.getassignmentInformationOrderDue().set(0);;
		StoredVariables.getassignmentInformationOtherRefNumber().set("");
		StoredVariables.getassignmentInformationLoanType().set("");
		StoredVariables.getassignmentInformationLoanPurpose().set("");
		StoredVariables.getassignmentInformationOrderedBy().set("");
		StoredVariables.getassignmentInformationOrderGroup().set("");
		StoredVariables.getassignmentInformationLoanNumber().set("");
		StoredVariables.getassignmentInformationFileNumber().set("");
		StoredVariables.getassignmentInformationSalesPrice().set("");
		StoredVariables.getassignmentInformationFHACaseNumber().set("");
		StoredVariables.getassignmentInformationDisclosure().set(0);
		StoredVariables.getassignmentInformationAssignedTo().set("");

		// Set Lender Information data
		StoredVariables.getlenderInformationLenderName().set("");
		StoredVariables.getlenderInformationAddress1().set("");
		StoredVariables.getlenderInformationAddress2().set("");
		StoredVariables.getlenderInformationCity().set("");
		StoredVariables.getlenderInformationState().set("");
		StoredVariables.getlenderInformationZip().set("");

		// Set Contact And Access Information data
		StoredVariables.getcontactOccupancy().set("");
		StoredVariables.getcontactBorrower().set("");
		StoredVariables.getcontactBorrowerInfo1Dropdown().set("");
		StoredVariables.getcontactBorrowerInfo1().set("");
		StoredVariables.getcontactBorrowerInfo2Dropdown().set("");
		StoredVariables.getcontactBorrowerInfo2().set("");
		StoredVariables.getcontactBorrowerAddress().set("");
		StoredVariables.getcontactBorrowerCity().set("");
		StoredVariables.getcontactBorrowerState().set("");
		StoredVariables.getcontactBorrowerZip().set("");
		StoredVariables.getcontactCoBorrower().set("");
		StoredVariables.getcontactCoBorrowerInfo1Dropdown().set("");
		StoredVariables.getcontactCoBorrowerInfo1().set("");
		StoredVariables.getcontactCoBorrowerInfo2Dropdown().set("");
		StoredVariables.getcontactCoBorrowerInfo2().set("");
		StoredVariables.getcontactCoBorrowerAddress().set("");
		StoredVariables.getcontactCoBorrowerCity().set("");
		StoredVariables.getcontactCoBorrowerState().set("");
		StoredVariables.getcontactCoBorrowerZip().set("");
		StoredVariables.getcontactOwner().set("");
		StoredVariables.getcontactOwnerInfo1Dropdown().set("");
		StoredVariables.getcontactOwnerInfo1().set("");
		StoredVariables.getcontactOwnerInfo2Dropdown().set("");
		StoredVariables.getcontactOwnerInfo2().set("");
		StoredVariables.getcontactOccupant().set("");
		StoredVariables.getcontactOccupantInfo1Dropdown().set("");
		StoredVariables.getcontactOccupantInfo1().set("");
		StoredVariables.getcontactOccupantInfo2Dropdown().set("");
		StoredVariables.getcontactOccupantInfo2().set("");
		StoredVariables.getcontactAgent().set("");
		StoredVariables.getcontactAgentInfo1Dropdown().set("");
		StoredVariables.getcontactAgentInfo1().set("");
		StoredVariables.getcontactAgentInfo2Dropdown().set("");
		StoredVariables.getcontactAgentInfo2().set("");
		StoredVariables.getcontactOther().set("");
		StoredVariables.getcontactOtherInfo1Dropdown().set("");
		StoredVariables.getcontactOtherInfo1().set("");
		StoredVariables.getcontactOtherInfo2Dropdown().set("");
		StoredVariables.getcontactOtherInfo2().set("");
		StoredVariables.getcontactApptContact().set("");

		// Set Additional Notification Recipients data
		StoredVariables.getadditionalNotificationRecipientsAdditionalEmails().set("");
		StoredVariables.getadditionalNotificationRecipientsAttachCompletedReport().set(false);
		StoredVariables.getadditionalComments().set("");

	} // end clearOrderInfoStoredVariables

	/**
	 * Wait for the database to update by checking the text in the history of the VMPXSite
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get the text of the history and check to see if the text you are looking for is there</li>
	 * 	<li>If the text is not there enter a while loop</li>
	 * 	<li>Switch into the LeftContent iFrame</li>
	 * 	<li>Search the tracking number set to the trackingNumberVMP StoredVariable</li>
	 * 	<li>Switch into the Main iFrame</li>
	 * 	<li>Open the order</li>
	 * 	<li>Get the history text</li>
	 * 	<li>Check to see if the text you are looking for is there. If it is, exit the while loop. If it is not, refresh the page and start the process over</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @param textToWaitFor The text expected to be in the history
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void waitForDBUpdateForHistoryTextInVMPXSite(RemoteWebDriver driver, String textToWaitFor) throws InterruptedException, IOException
	{

		System.out.println("Wait for db to update - " + textToWaitFor);

		// Wait for db to update
		boolean dbUpdate = false;

		String history = XOrders.history_txt(driver).getText();

		// Check for updated history
		if (history.contains(textToWaitFor))
		{
			dbUpdate = true;
		} // end if

		// Get start and end time for polling the db
		String startTime = new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime());
		Date dNow = new Date( ); // Instantiate a Date object
		Calendar cal = Calendar.getInstance();
		cal.setTime(dNow);
		cal.add(Calendar.MINUTE, 10);
		dNow = cal.getTime();
		String endTime = new SimpleDateFormat("HH:mm").format(dNow);

		System.out.println("Start polling for db update at " + startTime);
		System.out.println("Stop polling for db update at " + endTime);

		// Set 10 minute while loop timeout
		long start_time = System.currentTimeMillis();
		long wait_time = 600000;
		long end_time = start_time + wait_time;
		while (System.currentTimeMillis() < end_time && dbUpdate == false)
		{

			// Get inside the correct frame
			driver.switchTo().defaultContent();
			driver.switchTo().frame("LeftContent");

			// Enter tracking number in the Find textbox
			perform.type(driver, XOrders.find_txtbx(driver), StoredVariables.gettrackingNumberVMP().get());

			// Click Contains radio button
			click(driver, XOrders.contains_radioBtn(driver));

			// Select Tracking # in the Field dropdown
			// Select Borrower in the In Field dropdown
			selectDropdownOption(driver, XOrders.field_dropdown(driver), "Tracking #");

			// Click the magnifying glass
			click(driver, XOrders.magnifyingGlass_btn(driver));

			// Wait for order in grid
			Thread.sleep(3000);

			// Switch in to the correct frame
			driver.switchTo().defaultContent();
			driver.switchTo().frame("Main");

			// Open order
			doubleClickInTable(driver, StoredVariables.getborrowerIdentifier().get());

			Thread.sleep(3000);

			// Wait for history
			waitForElementToBeClickable(driver, XOrders.history_txt(driver));

			// Get new history text
			history = XOrders.history_txt(driver).getText();

			// Check if db has updated
			if (history.contains(textToWaitFor))
			{
				System.out.println("DB has been updated");
				dbUpdate = true;
				break;
			} // end if

			driver.navigate().refresh();

			Thread.sleep(15000);

		} // end while loop
		
		Assert.assertTrue(dbUpdate==true, "The database has not been updated with: " + textToWaitFor);

	} // end waitForDBUpdateForHistoryTextInVMPXSite

	/**
	 * Set clipboard data
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the String passed in to the clipboard</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @param string The value you want to set to the clipboard
	 */
	public void setClipboardData(RemoteWebDriver driver, String string)
	{

		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

	} // end setClipboardData

	/**
	 * Get the email session
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Decrypt the username for the email account</li>
	 *  <li>Decrypt the password for the email account</li>
	 *  <li>Set the SMTP information</li>
	 *  <li>Create the mail session<li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @throws Exception the exception
	 * @return the session
	 */
	private Session getEmailSession(RemoteWebDriver driver) throws Exception
	{
		
		final String username = perform.decrypt("email", "YjuDJ0beuAvkc+JE0fux4wd+cci6NLm0pj5dOtSVFW4sYoa9UvunNQ+8+LWl5tBs");
		final String password = perform.decrypt("email", "qSCvu2nuewzWvRbkkRuFa1G3GN62CQzf");

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
          });
        
        return session;
		
	} // end getEmailSession
	
	/**
	 * Send an email (overloaded method)
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Call the sendEmail without an attachment</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @param to The email address you want to send an email to
	 * @param cc The email address you want to copy on the email
	 * @param subject The subject of the email
	 * @param text The body of the email
	 * @throws Exception the exception
	 */
	public void sendEmail(RemoteWebDriver driver, String to, String cc, String subject, String text) throws Exception
	{
		
		Session session = getEmailSession(driver);
		
        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("automationQA@mercuryvmp.com"));
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(to));
            message.setRecipients(Message.RecipientType.CC,
                    InternetAddress.parse(cc));
            message.setSubject(subject);
            message.setContent(text, "text/html");

            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
		
	} // end sendEmail

	/**
	 * Send an email with an attachment
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the username and password of the automation gmail account</li>
	 * 	<li>Set the smtp properties for gmail</li>
	 * 	<li>Create a new email session</li>
	 * 	<li>Send the email</li>
	 * </ul>.
	 *
	 * @param driver The driver
	 * @param to The email address you want to send an email to
	 * @param cc The email address you want to copy on the email
	 * @param subject The subject of the email
	 * @param text The body of the email
	 * @param filePath the file path
	 * @param fileName the file name
	 * @throws Exception the exception
	 */
	public void sendEmail(RemoteWebDriver driver, String to, String cc, String subject, String text, String filePath, String fileName) throws Exception
	{

        Session session = getEmailSession(driver);

        try {

        	// Create a default MimeMessage object.
            Message message = new MimeMessage(session);
            
            // Set From header field
            message.setFrom(new InternetAddress("automationQA@mercuryvmp.com"));
            
            // Set To header field
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(to));
            
            // Set CC header field
            message.setRecipients(Message.RecipientType.CC,
                    InternetAddress.parse(cc));
            
            // Set Subject header field
            message.setSubject(subject);
            
            // Create the message part
            BodyPart messageBodyPart = new MimeBodyPart();

            // Set the message
            messageBodyPart.setText(text);
            
            // Create a multipart message
            Multipart multipart = new MimeMultipart();

            // Set text message part
            multipart.addBodyPart(messageBodyPart);
            
            // Part two is attachment
            messageBodyPart = new MimeBodyPart();
            String file = filePath+fileName;
            DataSource source = new FileDataSource(file);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(fileName);
            multipart.addBodyPart(messageBodyPart);

            // Send the complete message parts
            message.setContent(multipart);

            // Send message
            Transport.send(message);
            
            System.out.println("Email has been sent successfully");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        } // end try/catch
		
	} // end sendEmailWithAttachment

	/**
	 * Verify dropdown values
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Create a list of all of the dropdown options</li>
	 * 	<li>Iterate through all of the options and check against the expectedValues array to make sure it is expected</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @param element The dropdown element
	 * @param expectedValues An array of all the expected dropdown options
	 */	
	public void verifyDropdownOptions(RemoteWebDriver driver, WebElement element, String[] expectedValues)
	{

		//		String[] exampleString = {"Value1","Value2","Value3"};

		// Create dropdown element and select it
		Select select = new Select(element);  

		// Run through expected and actual list elements
		List<WebElement> options = select.getOptions();  
		for(WebElement we:options)  
		{  
			boolean match = false;
			for (int i=0; i<expectedValues.length; i++){
				if (we.getText().equals(expectedValues[i])){
					match = true;
				} // end if statement
			} // end for loop

			// Verify expected values exist in the dropdown
			Assert.assertTrue(match, we.getText() + " does not match");

		} // end for loop

	} // end verifyDropdownOptions

	/**
	 * Verify the selected dropdown value
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Verify the current selected option in the dropdown is what is expected</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @param element The dropdown element
	 * @param expectedValue The expected selected dropdown option
	 */	
	public void verifySelectedDropdownOption(RemoteWebDriver driver, WebElement element, String expectedValue)
	{

		// Set the Select element
		Select select = new Select(element);

		// Get the first selected option
		WebElement option = select.getFirstSelectedOption();

		// Set the selected option value to a String
		String selectedItem = option.getText();

		// Verify the selected dropdown option is correct
		Assert.assertTrue(selectedItem.equals(expectedValue), "The selected dropdown option is incorrect. It shoudl be: " + expectedValue + ", but is: " + selectedItem);

	} // end verifySelectedDropdownOption

	/**
	 * Get the selected dropdown value
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Verify the current selected option in the dropdown is what is expected</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @param element The dropdown element
	 * @return selectedItem
	 */	
	public String getSelectedDropdownOption(RemoteWebDriver driver, WebElement element)
	{

		// Set the Select element
		Select select = new Select(element);

		// Set the selected option value to a String
		String selectedItem = null;
		try {
			// Get the first selected option
			WebElement option = select.getFirstSelectedOption();
			selectedItem = option.getText();
		} catch (Exception e) {
			System.out.println(e);
		} // end try/catch

		// Return the selected item
		return selectedItem;

	} // end getSelectedDropdownOption

	/**
	 * Get a list of all options in a dropdown
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Create an array list</li>
	 * 	<li>Add each option in the dropdown to the list</li>
	 * 	<li>Return the list</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @param element The dropdown element
	 * @return List that contains all of the options in a dropdown
	 */
	public List<String> getAllDropdownOptions(RemoteWebDriver driver, WebElement element) {

		List<String> options = new ArrayList<String>();
		for (WebElement option : new Select(element).getOptions()) {
			if (option.getAttribute("value") != "") options.add(option.getText());
		} // end for

		return options;

	} // end getAllDropdownOptions

	/**
	 * Verify the URL is correct
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Verify the URL is correct</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @param url The expected URL
	 */	
	public void verifyURL(RemoteWebDriver driver, String url)
	{

		// Verify URL is correct
		Assert.assertTrue(driver.getCurrentUrl().contains(url), "The url is incorrect");

	} // end verifyURL

	/**
	 * Change tag elements in an XML file
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Read in the XML document</li>
	 * 	<li>Move to the root element</li>
	 * 	<li>Go to the tag you want to change and set the new value</li>
	 * 	<li>Write the new value to the file</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @param tagToChange the tag to change
	 * @param value the value
	 * @param filePath the file path
	 */
	public void changeTagElementInXML(RemoteWebDriver driver, String tagToChange, String value, String filePath)
	{

		try {

			File file = new File(filePath);
			file.setWritable(true);
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(filePath);

			// Get the root element
			@SuppressWarnings("unused")
			Node status = doc.getFirstChild();

			// Get the element by tag name directly
			Node tag = doc.getElementsByTagName(tagToChange).item(0);

			// Set the new value
			tag.setTextContent(value);

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(filePath));
			transformer.transform(source, result);

			System.out.println("Modified the XML File");

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (SAXException sae) {
			sae.printStackTrace();
		}

	} // end changeTagElementInXML

	/**
	 * HTTP POST request for completing an order on Vendors
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the web service URL based on the environment</li>
	 * 	<li>Create the connection</li>
	 * 	<li>Set the parameters to use in the POST</li>
	 * 	<li>Send the POST request</li>
	 * 	<li>Capture the response</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @param user The username to login with in the POST
	 * @param password The password to login with in the POST
	 * @param xml The XML file that completes the order to send in the POST
	 * @throws Exception the exception
	 */
	public void sendPost_UpdateAppraisalStatusGlobal(RemoteWebDriver driver, String user, String password, String xml) throws Exception {

		ExtentTest test = ExtentTestManager.getTest();
		String environment = StoredVariables.getusernameEnvironment().get();
		String catchAllDomain = StoredVariables.getcatchAllDomain().get();

		// Set username
		if (!user.contains("@"))
		{
			user = "automation" + environment + user + catchAllDomain;
		}

		// Get correct web service url
		String url = "";
		if (environment.equals("QA"))
		{
			url = "https://wbsvcintqa.ad.mercuryvmp.com/VendorOrder/VendorOrder.asmx/UpdateAppraisalStatusGlobal";
		}
		else
		{
			url = "https://wbsvcint.ad.mercuryvmp.com/VendorOrder/VendorOrder.asmx/UpdateAppraisalStatusGlobal";
		}

		// Create the connection
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// Add request header
		con.setRequestMethod("POST");
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		// Set the parameters for the Post
		String urlParameters = "UserName=" + user + "&Password=" + password + "&XMLPost=" + xml + "&IPAddress=127.0.0.1";

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		// Get the response
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		//		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());

		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Sent post to UpdateAppraisalStatusGlobal.<br>"
				+ "URL: " + url
				+ "<br>User: " + user
				+ "<br>Password: " + password);

	} // end sendPost_UpdateAppraisalStatusGlobal

	/**
	 * Convert a file to a String 
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Read in a file and convert it to a String</li>
	 * 	<li>Return the String</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @param file The file to be used to build a String
	 * @return The String created from the file
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public  String stringBuilder(RemoteWebDriver driver, String file) throws IOException {
		StringBuilder sb = new StringBuilder();
		String sCurrentLine = "";
		try (BufferedReader br = new BufferedReader(new FileReader(file))){
			while ((sCurrentLine = br.readLine()) != null) {
				sb.append(sCurrentLine);
			}
		}
		return sb.toString();
	} // end stringBuilder

	/**
	 * Verify Whitelilsting
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Wait for the element</li>
	 * 	<li>Clear the text field</li>
	 * 	<li>Enter the text</li>
	 * 	<li>Click out of the field</li>
	 * 	<li>Get the text of the element</li>
	 * 	<li>Verify the text matches the expectedText</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @param textElement The WebElement of the text field
	 * @param textToEnter The text to be entered into the text field
	 * @param clickOutField The WebElement to be clicked on to change focus from the text field
	 * @param expectedText The expected text to be displayed
	 * @throws InterruptedException the interrupted exception
	 */
	public void verifyWhitelisting(RemoteWebDriver driver, WebElement textElement, String textToEnter, WebElement clickOutField, String expectedText) throws InterruptedException {

		// Wait for element
		perform.waitForElementToBeClickable(driver, textElement);

		// Clear field
		textElement.clear();

		// Enter string into text field
//		type(driver, textElement, textToEnter);
		textElement.sendKeys(textToEnter);

		// Click out of field
		click(driver, clickOutField);

		// Get the text of the element
		String text = textElement.getAttribute("value");

		// Verify the new text has been stripped correctly
		Assert.assertTrue(text.equals(expectedText), "The whitelisting failed. Text = " + text + "     and should be = " + expectedText);

	} // end verifyWhitelisting1

	/**
	 * Send an HTTP POST
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Crate the connection and send the POST</li>
	 * 	<li>Capture the response and set it to an array</li>
	 * 	<li>Return the response array</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @param url The URL to send the POST to
	 * @param urlParameters The parameters to send in the POST
	 * @return An array of the response information
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public  String[] httpPost(RemoteWebDriver driver, String url, String urlParameters) throws IOException {

		// Create the connection
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// Add request header
		con.setRequestMethod("POST");
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		//		// Write Post URL to file
		//		writeToAFile(driver, "C:\\Users\\dustin.norman\\Downloads", "urlParameters.txt", urlParameters);

		// Get the response
		int responseCode = con.getResponseCode();
		String message = con.getResponseMessage();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);
		System.out.println("Response Message = " + message);

		String body = IOUtils.toString(con.getInputStream(), "UTF-8");
		System.out.println("Response Body = " + body);

		BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		String ar[] = new String[3];
		ar[0] = Integer.toString(responseCode);
		ar[1] = message;
		ar[2] = body;

		return ar;

	} // end httpPost

	/**
	 * Perform HTTP Post with individual parameters supplied
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Crate the connection, set the parameters and send the POST</li>
	 * 	<li>Capture the response</li>
	 * 	<li>Return the response body</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @param url The URL to send the POST to
	 * @param params A List of the parameters to send in the POST
	 * @return The body of the response
	 * @throws Exception the exception
	 */
	/* EXAMPLE:
	 * 	// Request parameters and other properties.
		List<NameValuePair> params = new ArrayList<NameValuePair>(2);
		params.add(new BasicNameValuePair("SessionKey", sessionKey));
		params.add(new BasicNameValuePair("XMLPost", xmlString));
	 */
	public  String httpPostWithIndividualParams(RemoteWebDriver driver, String url, List<NameValuePair> params) throws Exception {

		// Initialize the HTTP post
		HttpClient httpclient = HttpClients.createDefault();
		HttpPost httppost = new HttpPost(url);

		// Request parameters and other properties.
		httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

		//Execute and get the response.
		HttpResponse response = httpclient.execute(httppost);

		// Get the body
		InputStream ips  = response.getEntity().getContent();
		BufferedReader buf = new BufferedReader(new InputStreamReader(ips,"UTF-8"));
		if(response.getStatusLine().getStatusCode()!=HttpStatus.SC_OK)
		{
			throw new Exception(response.getStatusLine().getReasonPhrase());
		}
		StringBuilder sb = new StringBuilder();
		String s;
		while(true )
		{
			s = buf.readLine();
			if(s==null || s.length()==0)
				break;
			sb.append(s.trim());

		}
		buf.close();
		ips.close();
		String body = sb.toString();
		System.out.println("\n\nbody = " + body);

		return body;

	} // end httpPostWithIndividualParams

	/**
	 * Get a particular tag from a HTTP response
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Look for the tag name in the supplied body</li>
	 * 	<li>Find the match and return the value as a String</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @param tag The tag that contains the data you want to get
	 * @param body The body of text that contains the tag you want extract the data of
	 * @return The text of the tag within the body
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public  String getTagFromHTTPResponseAsString(RemoteWebDriver driver, String tag, String body) throws IOException {

		final Pattern pattern = Pattern.compile("<"+tag+">(.+?)</"+tag+">");
		final Matcher matcher = pattern.matcher(body);
		matcher.find();

		return matcher.group(1);

	} // end getTagFromHTTPResponseAsString

	/**
	 * Login through the api
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the URL of the API based on the environment</li>
	 * 	<li>Set the username and password parameters</li>
	 * 	<li>Send the POST</li>
	 * 	<li>Capture the sessionKey from the response and return the value</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @param username The username to login with
	 * @param password the password to use when logging in
	 * @return The sessionKey of the login session
	 * @throws Exception the exception
	 */
	public  String apiLogin(RemoteWebDriver driver, String username, String password) throws Exception {

		ExtentTest test = ExtentTestManager.getTest();

		// Set Login Method POST URL
		String url = "";
		if (StoredVariables.getusernameEnvironment().get().equals("QA")) {
			url = "https://mercurynetworkapiqa.com/mercuryapi.asmx/Login?";
		} else {
			url = "https://mercurynetworkapi.com/mercuryapi.asmx/Login?";
		} // end if/else

		String urlParameters = "username="+username+"&password="+password;

		// Call Login Method and get the response
		String[] response = perform.httpPost(driver, url, urlParameters);

		// Parse out the SessionKey
		String tag = "SessionKey";
		String sessionKey = perform.getTagFromHTTPResponseAsString(driver, tag, response[2]);
		System.out.println(tag + " = " + sessionKey); // Prints String to extract

		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Logged in through the API.<br>"
				+ "User: " + username
				+ "<br>Password: " + password);

		return sessionKey;

	} // end apiLogin

	/**
	 * Place an order from the VMP Client Portal using the API
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the VMP username</li>
	 * 	<li>Set the Secure username</li>
	 * 	<li>Query the database to get the First and Last name of the Secure user</li>
	 * 	<li>Login using the apiLogin method and set the sessionKey</li>
	 * 	<li>Query the database to get the entityID of the vendor and verify it is not empty</li>
	 * 	<li>Set the URL of the API to login based on the environment</li>
	 * 	<li>Set the path of the XML file to be used when completing the order</li>
	 * 	<li>Set the Description of the order to be used when looking up the order in the database</li>
	 * 	<li>Set the due date of the order</li>
	 * 	<li>Update the XML file with appraiser specific data to be used when assigning the order</li>
	 * 	<li>Send the HTTP POST to create the order and capture the response</li>
	 * 	<li>Parse out the TrackingID and TrackingNumber from the response and add them to an array</li>
	 * 	<li>Get the loan id's of the orders and set them to StoredVariables</li>
	 * 	<li>Return the postResponse</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @param vmpUsername The username for the VMP Client user
	 * @param vmpPassword The password for the VMP Client user
	 * @param secureUsername The username for the Secure user
	 * @param xmlFile The XML file used to place the order
	 * @return The postResponse from completing an order that contains the TrackingID and TrackingNumber
	 * @throws Exception the exception
	 */
	public  String[] apiPlaceOrderFromVMPClientPortal(RemoteWebDriver driver, String vmpUsername, String vmpPassword, String secureUsername, String xmlFile) throws Exception {

		// MUST LOGIN AS VMP CLIENT PORTAL TO GET SESSION_KEY

		// Get OS
		String os = StoredVariables.getos().get();

		// Set vmpUsername
		String env = StoredVariables.getusernameEnvironment().get();
		if (!vmpUsername.contains("automation"+env)) {
			vmpUsername = "automation" + env + vmpUsername;
		}

		// Set Secure username
		String catchAllDomain = StoredVariables.getcatchAllDomain().get();
		if (!secureUsername.contains("@"))
		{
			secureUsername = "automation" + env + secureUsername + catchAllDomain;	
		}

		// Get first name of the Secure user
		String sqlStatement = "SELECT TOP 1 FirstName FROM Entities WHERE Email = '"+secureUsername+"'";
		String firstNameSecure = db.queryDB(driver, "Mercury", sqlStatement);

		// Get last name of the Secure user
		sqlStatement = "SELECT TOP 1 LastName FROM Entities WHERE Email = '"+secureUsername+"'";
		String lastNameSecure = db.queryDB(driver, "Mercury", sqlStatement);

		// Get a session key for the VMP Client user
		String sessionKey = perform.apiLogin(driver, vmpUsername, vmpPassword);

		// Get the enity id of the appraiser to assign the order to
		String entityID = db.getVendorEntityID(driver, firstNameSecure, lastNameSecure);

		// Verify the Entity ID is not empty
		Assert.assertTrue(!entityID.equals(""), "The VendorEntityID should not be empty");

		// Set Login Method POST URL
		String url = "";
		if (StoredVariables.getusernameEnvironment().get().equals("QA")) {
			url = "https://mercurynetworkapiqa.com/mercuryapi.asmx/PlaceAppraisalOrderEx";
		} else {
			url = "https://mercurynetworkapi.com/mercuryapi.asmx/PlaceAppraisalOrderEx";
		} // end if/else

		// Set path to the XML file
		String placeOrderDirectory = null;
		if (os.equals("Windows")) {
			placeOrderDirectory = StoredVariables.getdocDir().get() + "PlaceOrderDocs\\";
		} else if (os.equals("Mac")) {
			placeOrderDirectory = StoredVariables.getdocDir().get() + "PlaceOrderDocs/";
		} // end if/else
		xmlFile = placeOrderDirectory+xmlFile+".xml";	

		// Set the description for db lookup purposes
		StoredVariables.getpropertyInformationAddress().set("501 NE 122nd");
		StoredVariables.getdirectionsIdentifier().set(new SimpleDateFormat("MMddHHmmss").format(Calendar.getInstance().getTime()) + " - " + perform.randomNumbers(driver, 5));
		StoredVariables.getpropertyInformationDirections().set("Automation Test - " + StoredVariables.getdirectionsIdentifier().get());		

		// Set due date
		perform.getNewDate(driver, 7);

		// Update the appraiserID in the XML file to assign the order to the specified appraiser 
		perform.changeTagElementInXML(driver, "APPRAISERID", entityID, xmlFile);
		perform.changeTagElementInXML(driver, "DUE_DATE", StoredVariables.getnewDateShort().get(), xmlFile);
		perform.changeTagElementInXML(driver, "MANUAL_CROSSST", StoredVariables.getpropertyInformationDirections().get(), xmlFile);
		perform.changeTagElementInXML(driver, "LENDERCASENUMBER", perform.randomNumbers(driver, 10), xmlFile);

		// Reading XML as String using jCabi library
		XML xml = new XMLDocument(new File(xmlFile));
		String xmlString = xml.toString();

		// Initialize the HTTP URL Connection
		HttpURLConnection con = null;
		
		// Initialize the post response variable
		String[] postResponse = new String[4];

		// Set the parameters
		String urlParameters = "sessionKey="+sessionKey+"&xmlpost="+xmlString+"&ipaddress=127.0.0.1";
		
		// Set the post data
        byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);

        try {

            URL myurl = new URL(url);
            con = (HttpURLConnection) myurl.openConnection();

            con.setDoOutput(true);
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", "Java client");
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                wr.write(postData);
            } // end try

            StringBuilder content;

            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {

                String line;
                content = new StringBuilder();

                while ((line = in.readLine()) != null) {
                    content.append(line);
                    content.append(System.lineSeparator());
                } // end while
                
            } // end try/catch

            System.out.println(content.toString());
            
            String body = content.toString();
            
            // Parse out the TrackingID
    		String tag = "TrackingID";
    		postResponse[0] = perform.getTagFromHTTPResponseAsString(driver, tag, body);
    		System.out.println(tag + " = " + postResponse[0]);

    		// Parse out the TrackingNumber
    		tag = "TrackingNumber";
    		postResponse[1] = perform.getTagFromHTTPResponseAsString(driver, tag, body);
    		System.out.println(tag + " = " + postResponse[1]);

    		// Set the order numbers
    		db.getLoanIDsFromVMPClientPortalOrder(driver);

        } finally {
            
            con.disconnect();
        } // end try/finally
		
		// Add info to Extent Report
        perform.addInfoToExtentReport(driver, "Info", "Placed on order from the VMP Client portal through the API.<br>"
				+ "Tracking Number: " + postResponse[1]);

		// Return the post response
		return postResponse;

	} // end apiPlaceOrderFromVMPClientPortal

	/**
	 * Place an order from Secure using the API
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the Secure username</li>
	 * 	<li>Set the URL of the API to login based on the environment</li>
	 * 	<li>Set the path of the XML file to be used when completing the order</li>
	 * 	<li>Set the Description of the order to be used when looking up the order in the database</li>
	 * 	<li>Set the due date of the order</li>
	 * 	<li>Update the XML file with appraiser specific data to be used when assigning the order</li>
	 * 	<li>Send the HTTP POST to create the order and capture the response</li>
	 * 	<li>Parse out the TrackingNumber from the response</li>
	 * 	<li>Get the loan id of the order and set it to a StoredVariable</li>
	 * 	<li>Return the tracking number</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @param secureUsername The username for the Secure user
	 * @param securePassword The password for the Secure user
	 * @param xmlFile The XML file used to place the order
	 * @return The tracking number of the order created
	 * @throws Exception the exception
	 */
	public  String apiPlaceOrderFromSecure(RemoteWebDriver driver, String secureUsername, String securePassword, String xmlFile) throws Exception {

		ExtentTest test = ExtentTestManager.getTest();

		// Place an order through the api from Secure

		// Set username
		String catchAllDomain = StoredVariables.getcatchAllDomain().get();
		String env = StoredVariables.getusernameEnvironment().get();
		if (!secureUsername.contains("@"))
		{
			secureUsername = "automation" + env + secureUsername + catchAllDomain;	
		}

		// Set Login Method POST URL
		String url = "";
		if (StoredVariables.getusernameEnvironment().get().equals("QA")) {
			url = "https://mercurynetworkapiqa.com/mercuryapi.asmx/PlaceMNOrder";
		} else {
			url = "https://mercurynetworkapi.com/mercuryapi.asmx/PlaceMNOrder";
		} // end if/else

		// Set path to the XML file
		String os = StoredVariables.getos().get();
		String placeOrderDirectory = null;
		if (os.equals("Windows")) {
			placeOrderDirectory = StoredVariables.getdocDir().get() + "PlaceOrderDocs\\";
		} else if (os.equals("Mac")) {
			placeOrderDirectory = StoredVariables.getdocDir().get() + "PlaceOrderDocs/";
		} // end if/else
		xmlFile = placeOrderDirectory+xmlFile+".xml";	

		// Set the description for db lookup purposes
		StoredVariables.getpropertyInformationAddress().set("501 NE 122nd");
		StoredVariables.getdirectionsIdentifier().set(new SimpleDateFormat("MMddHHmmss").format(Calendar.getInstance().getTime()) + " - " + perform.randomNumbers(driver, 5));
		StoredVariables.getpropertyInformationDirections().set("Automation Test - " + StoredVariables.getdirectionsIdentifier().get());

		// Set due date
		perform.getNewDate(driver, 7);

		// Update the appraiserID in the XML file to assign the order to the specified appraiser 
		perform.changeTagElementInXML(driver, "DUE_DATE", StoredVariables.getnewDateShort().get(), xmlFile);
		perform.changeTagElementInXML(driver, "MANUAL_CROSSST", StoredVariables.getpropertyInformationDirections().get(), xmlFile);
		perform.changeTagElementInXML(driver, "LENDERCASENUMBER", perform.randomNumbers(driver, 10), xmlFile);

		// Reading XML as String using jCabi library
		XML xml = new XMLDocument(new File(xmlFile));
		String xmlString = xml.toString();

		// Initialize the HTTP post
		HttpClient httpclient = HttpClients.createDefault();
		HttpPost httppost = new HttpPost(url);

		// Request parameters and other properties
		//		System.out.println("\n\n\n");
		//		System.out.println("UserName = " + secureUsername);
		//		System.out.println("Password = " + securePassword);
		//		System.out.println("\n");
		//		perform.writeToAFile(driver, StoredVariables.getdocDir().get(), "XMLString.txt", xmlString);
		//		perform.pauseScript(driver);
		List<NameValuePair> params = new ArrayList<NameValuePair>(2);
		params.add(new BasicNameValuePair("UserName", secureUsername));
		params.add(new BasicNameValuePair("Password", securePassword));
		params.add(new BasicNameValuePair("XMLPost", xmlString));
		params.add(new BasicNameValuePair("IPAddress", "127.0.0.1"));
		httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

		//Execute and get the response.
		HttpResponse response = httpclient.execute(httppost);

		InputStream ips  = response.getEntity().getContent();
		BufferedReader buf = new BufferedReader(new InputStreamReader(ips,"UTF-8"));
		if(response.getStatusLine().getStatusCode()!=HttpStatus.SC_OK)
		{
			throw new Exception(response.getStatusLine().getReasonPhrase());
		}
		StringBuilder sb = new StringBuilder();
		String s;
		while(true )
		{
			s = buf.readLine();
			if(s==null || s.length()==0)
				break;
			sb.append(s.trim());

		}
		buf.close();
		ips.close();
		String body = sb.toString();
		System.out.println("body = " + body);

		// Parse out the TrackingNumber
		String tag = "TrackingNumber";
		String trackingNumber = perform.getTagFromHTTPResponseAsString(driver, tag, body).replace("MERC-", "");
		System.out.println(tag + " = " + trackingNumber);

		// Get order number
		db.getLoanID(driver);

		// Add info to Extent Report
		test.log(LogStatus.INFO, "Info", "Placed on order from the VMP Client portal through the API.<br>"
				+ "Tracking Number: " + trackingNumber);

		return trackingNumber;

	} // end apiPlaceOrderFromSecure

	/**
	 * Place an order from the VMP Client Portal using the API
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Send the HTTP POST to create the order and capture the response</li>
	 * 	<li>Verify the response contains the correct text</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @param sessionKey The sessionKey for the login session
	 * @param xmlToCreateOrderWith The xml file used to create the order
	 * @param expectedResponse The expected response from VOWS
	 * @throws Exception the exception
	 */
	public void sendPostToPlaceAppraisalOrderEx(RemoteWebDriver driver, String sessionKey, String xmlToCreateOrderWith, String expectedResponse) throws Exception {

		ExtentTest test = ExtentTestManager.getTest();

		// Reading XML as String using jCabi library
		XML xml = new XMLDocument(new File(xmlToCreateOrderWith));
		String xmlString = xml.toString();

		// Set PlaceAppraisalOrderEx Method POST URL
		String url = "https://mercurynetworkapiqa.com/mercuryapi.asmx/PlaceAppraisalOrderEx";
		if (StoredVariables.getusernameEnvironment().get().equals("Live")) {
			url = "https://mercurynetworkapi.com/mercuryapi.asmx/PlaceAppraisalOrderEx";
		} // end if Live

		// Request parameters and other properties.
		List<NameValuePair> params = new ArrayList<NameValuePair>(2);
		params.add(new BasicNameValuePair("SessionKey", sessionKey));
		params.add(new BasicNameValuePair("XMLPost", xmlString));
		params.add(new BasicNameValuePair("IPAddress", "127.0.0.1"));

		// Send the post
		String body = perform.httpPostWithIndividualParams(driver, url, params);

		// Verify the XML is the same
		Assert.assertTrue(body.contains(expectedResponse), "XML file is incorrect. Response = " + body + "\nFile = " + expectedResponse);

		// Log test
		test.log(LogStatus.INFO, "Integration", "Tried to create an order and verified the IntegrationDeniedNACK error was returned");

	} // end sendPostToPlaceAppraisalOrderEx

	/**
	 * Write data to a file
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Write provided data to a specified file</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @param filePath The directory of where to write the file
	 * @param fileName The filename of the file to be written to
	 * @param data The data to write in the file
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void writeToAFile(RemoteWebDriver driver, String filePath, String fileName, String data) throws IOException {

		// Get OS
		String os = StoredVariables.getos().get();
		
		// Check if the file path exists and create it if it doesn't
		File directory = new File(filePath);
	    if (! directory.exists()){
	        directory.mkdir();
	        // If you require it to make the entire directory path including parents,
	        // use directory.mkdirs(); here instead.
	    }

		// Write Post URL to file
		if (os.equals("Windows")) {
			try(  PrintWriter out = new PrintWriter( filePath + fileName )  ){
				out.println( data );
			} // end try
		} else if (os.equals("Mac")) {
			try(  PrintWriter out = new PrintWriter( filePath + fileName )  ){
				out.println( data );
			} // end try
		} // end if/else

	} // end writeToAFile

	/**
	 * Write data to a file
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Write provided data to a specified file</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @param filePath The directory of where to write the file
	 * @param fileName The filename of the file to be written to
	 * @param data The data to write in the file
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void writeToAFileAppended(RemoteWebDriver driver, String filePath, String fileName, String data) throws IOException {

		// Check if the file path exists and create it if it doesn't
		File directory = new File(filePath);
	    if (! directory.exists()){
	        directory.mkdir();
	        // If you require it to make the entire directory path including parents,
	        // use directory.mkdirs(); here instead.
	    }
		
		// Append data to a file
		BufferedWriter writer = new BufferedWriter(
				new FileWriter(filePath + fileName, true)  //Set true for append mode
				); 
		writer.newLine();   //Add new line
		writer.write(data);
		writer.close();

	} // end writeToAFileAppended
	
	/**
	 * Write data to a file
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Write provided data to a specified file</li>
	 * </ul>
	 *
	 * @param filePath The directory of where to write the file
	 * @param fileName The filename of the file to be written to
	 * @param data The data to write in the file
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void writeToAFile(String filePath, String fileName, String data) throws IOException {

		// Get OS
		String os = StoredVariables.getos().get();
		
		// Check if the file path exists and create it if it doesn't
		File directory = new File(filePath);
	    if (! directory.exists()){
	        directory.mkdir();
	        // If you require it to make the entire directory path including parents,
	        // use directory.mkdirs(); here instead.
	    }

		// Write Post URL to file
		if (os.equals("Windows")) {
			try(  PrintWriter out = new PrintWriter( filePath + fileName )  ){
				out.println( data );
			} // end try
		} else if (os.equals("Mac")) {
			try(  PrintWriter out = new PrintWriter( filePath + fileName )  ){
				out.println( data );
			} // end try
		} // end if/else

	} // end writeToAFile

	/**
	 * Print XML Document
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Print XML Document</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @param doc The XML document you want to print out
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TransformerException the transformer exception
	 */
	public void printXMLDocument(RemoteWebDriver driver, Document doc) throws IOException, TransformerException {

		OutputStream out = System.out;
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
		transformer.setOutputProperty(OutputKeys.METHOD, "xml");
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

		transformer.transform(new DOMSource(doc), 
				new StreamResult(new OutputStreamWriter(out, "UTF-8")));

	} // end printXMLDocument

	/**
	 * Get XML Document
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Send a POST request</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @param url The URL to send the POST to
	 * @param urlParameters The parameters to supply in the POST
	 * @return The XML document
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParserConfigurationException the parser configuration exception
	 * @throws SAXException the SAX exception
	 * @throws TransformerException the transformer exception
	 */
	public  Document getXMLDocument(RemoteWebDriver driver, String url, String urlParameters) throws IOException, ParserConfigurationException, SAXException, TransformerException {

		// Create the connection
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// Add request header
		con.setRequestMethod("POST");
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		// Get the response
		int responseCode = con.getResponseCode();
		String message = con.getResponseMessage();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);
		System.out.println("message = " + message);

		InputStream xml = con.getInputStream();
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(xml);

		return doc;

	} // end getXML

	/**
	 * Build a String from file data
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Read in a file and create a String out of it</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @param file The file to read in and create a String out of
	 * @return The String built from the file
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public  String stringBuilderFromFileTrimmed(RemoteWebDriver driver, String file) throws IOException {

		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		StringBuilder sb = new StringBuilder();

		while((line=br.readLine())!= null){
			sb.append(line.trim());
		}

		return sb.toString();

	} // end stringBuilderFromFileTrimmed

	/**
	 * Build a String from a trimmed String
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Build a String from a trimmed String</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @param string The String to read in and create a new "trimmed" String out of
	 * @return The String built from the file
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TransformerException the transformer exception
	 */
	public  String stringBuilderFromStringTrimmed(RemoteWebDriver driver, String string) throws IOException, TransformerException {

		BufferedReader br = new BufferedReader(new StringReader(string));
		String line;
		StringBuilder sb = new StringBuilder();

		while((line=br.readLine())!= null){
			sb.append(line.trim());
		}

		return sb.toString();

	} // end stringBuilderFromStringTrimmed

	/**
	 * Set the filepath for the API XML test files
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the filepath for the API XML test files</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @return The filepath for the API XML test files
	 */
	public String filepathForAPIXMLFiles(RemoteWebDriver driver) {

		// Get OS
		String os = StoredVariables.getos().get();

		// Get userDir
		String userDir = StoredVariables.getuserDir().get();

		// Set the directory for the API XML Files
		String path = null;
		if (os.equals("Windows")) {
			path = userDir+"\\src\\main\\resources\\apiXMLFiles\\";
		} else if (os.equals("Mac")) {
			path = userDir+"/src/main/resources/apiXMLFiles/";;
		} // end if/else

		return path;

	} // end filepathForAPIXMLFiles
	
	/**
	 * Check if an element exists
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Check to see if the element exists</li>
	 * </ul>.
	 *
	 * @param driver The driver
	 * @param by the by
	 * @return Returns true if the element is found, otherwise it returns false
	 */
	public boolean checkIfElementExists(RemoteWebDriver driver, By by) {

		System.out.println("Check to see if element exists: " + by);
		
		int size = driver.findElements(by).size();
		
		if (size==0) {
			return false;
		} // end if 0

		return true;
	}

	/**
	 * Check if an element exists using cssSelector
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Check to see if the element exists using a cssSelector</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @param cssSelector The css selector for a WebElement
	 * @return Returns true if the element is found, otherwise it returns false
	 */
	public  boolean checkIfElementExistsByCssSelector(RemoteWebDriver driver, String cssSelector) {

		System.out.println("Check to see if element " + cssSelector + " exists.");

		try {
			driver.findElement(By.cssSelector(cssSelector));

		} catch (NoSuchElementException e) {
			return false;
		}
		return true;
	}

	/**
	 * Check if an element exists using id
	 * STEPS:
	 * <ul>
	 * 	<li>Check to see if the element exists using an id</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @param id The id for a WebElement
	 * @return Returns true if the element is found, otherwise it returns false
	 */
	public  boolean checkIfElementExistsByID(RemoteWebDriver driver, String id) {

		System.out.println("Check to see if element " + id + " exists.");

		try {
			driver.findElement(By.id(id));

		} catch (NoSuchElementException e) {
			return false;
		}
		return true;
	}

	/**
	 * Check to see if an iFrame exists by the src attribute
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Check to see if an iFrame exists using the src attribute</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @param src The src of the iFrame to check
	 * @return Returns true if the element is found, otherwise it returns false
	 */
	public  boolean checkIfIframeExists(RemoteWebDriver driver, String src) {

		System.out.println("Check to see if iFrame " + src + " exists.");

		try {
			driver.findElement(By.xpath("//iframe[contains(@src,'" + src + "')]"));

		} catch (NoSuchElementException e) {
			return false;
		}
		return true;
	} // end checkIfIframeExists

	/**
	 * Get the Hex color value of a WebElement
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get the Hex color value of a WebElement</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @param elementToGetColorOf WebElement to get the color of
	 * @return Returns the Hex color as a String
	 */
	public String getElementColor(RemoteWebDriver driver, WebElement elementToGetColorOf) {
		String color = Color.fromString(elementToGetColorOf.getCssValue("color")).asHex();
		return color;
	} // end getElementColor

	/**
	 * Verify the Hex color value of a WebElement
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get the Hex color value of a WebElement</li>
	 * 	<li>Verify the Hex color value of the WebElement equals the expected color</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @param elementToGetColorOf WebElement to get the color of
	 * @param expectedColor The expected color of the element
	 */
	public void verifyElementColor(RemoteWebDriver driver, WebElement elementToGetColorOf, String expectedColor) {
		//Verify text color
		String orderFeeColor = perform.getElementColor(driver, elementToGetColorOf);
		Assert.assertTrue(orderFeeColor.equals(expectedColor), "The color should be "+expectedColor+", but instead is = " + orderFeeColor);
	} // end getElementColor

	/**
	 * Take screenshot and add it to the ExtentReport
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the screenshot path from the StoredVariable</li>
	 * 	<li>Set the timestamp of the current time</li>
	 * 	<li>Set the name for the screenshot using the path and the timestamp</li>
	 * 	<li>Take screenshot and store as a file format</li>
	 * 	<li>Add these screenshot to the Extent Report</li>
	 * </ul>
	 *
	 * @param driver The driver
	 */
	public void takeScreenshot(RemoteWebDriver driver) {

		if (!StoredVariables.getuseLocalGrid().get().equals("android")) {

			ExtentTest test = ExtentTestManager.getTest();

			// Get OS
			String os = StoredVariables.getos().get();

			// Get path to the screenshots folder
			String screenshotPath = StoredVariables.getscreenshotPath().get();

			// Get the current time stamp
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); 

			// Set the screenshot name
			if (os.equals("Windows")) {
				StoredVariables.getscreenshotImage().set(screenshotPath + "\\" + "_" + timeStamp + ".png");
			} else if (os.equals("Mac")) {
				StoredVariables.getscreenshotImage().set(screenshotPath + "/" + "_" + timeStamp + ".png");
			} // end if/else
			String screenshotURL = "http://"+StoredVariables.getserverIP().get()+":897/SeleniumTestResults/MercuryNetwork/" + StoredVariables.getreportDir().get() + "/Screenshots/" + "_" + timeStamp + ".png";

			// Take screenshot and store as a file format
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

			try {
				FileUtils.copyFile(src, new File(StoredVariables.getscreenshotImage().get()));
			} catch (IOException e1) {
				e1.printStackTrace();
				System.out.println(e1.getMessage());
			}

			// Add screenshot to report
			test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture(screenshotURL));

		} // end if android

	} // end takeScreenshot

	/**
	 * Copy contents to the clipboard
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click on the element to get the text from</li>
	 * 	<li>Set the contents of the clipboard to a String value</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @param elementToGetTextOf WebElement used to get the text of and copy to the clipboard
	 * @return The information copied to the clipboard
	 * @throws InterruptedException the interrupted exception
	 * @throws UnsupportedFlavorException the unsupported flavor exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public  String copyToClipboard(RemoteWebDriver driver, WebElement elementToGetTextOf) throws InterruptedException, UnsupportedFlavorException, IOException {

		System.out.println("Copying contents of " + elementToGetTextOf.toString() + " to the clipboard");

		// Click the element to get the text from
		click(driver, elementToGetTextOf);

		Thread.sleep(1000);

		// Select all
		elementToGetTextOf.sendKeys(Keys.LEFT_CONTROL + "a");

		Thread.sleep(1000);

		// Copy to the clipboard
		elementToGetTextOf.sendKeys(Keys.LEFT_CONTROL + "c");

		// Set the contents of the clipboard to a String value
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Clipboard clipboard = toolkit.getSystemClipboard();
		String result = (String) clipboard.getData(DataFlavor.stringFlavor);
		System.out.println("String from Clipboard:\n" + result);

		return result;

	} // end copyToClipboard

	/**
	 * Perform an assertion/verification
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Perform an assertion between 2 sets of data. The type of assertion depends on the containsOrEquals param</li>
	 * </ul>
	 * @param driver The driver
	 * @param screenData The data on the screen to compare against
	 * @param condition The type of assertion to perform
	 * @param expectedData The data to compare against the screenData
	 */
	public void verification(RemoteWebDriver driver, String screenData, String condition, String expectedData) {

		System.out.println("Performing verification that the screen data - " + screenData + " " + condition + " the expected data - " + expectedData);

		if (condition.toLowerCase().startsWith("con")) {
			Assert.assertTrue(screenData.contains(expectedData), "The screen = " + screenData + "\nThe expected value = " + expectedData);
		} else if (condition.toLowerCase().startsWith("!con") || condition.toLowerCase().startsWith("does not con")) {
			Assert.assertTrue(!screenData.contains(expectedData), "The screen = " + screenData + "\nThe expected value = " + expectedData);
		} else if (condition.toLowerCase().startsWith("!eq") || condition.toLowerCase().startsWith("does not eq")) {
			Assert.assertTrue(!screenData.equals(expectedData), "The screen = " + screenData + "\nThe expected value = " + expectedData);
		} else if (condition.toLowerCase().startsWith("eq")) {
			Assert.assertTrue(screenData.equals(expectedData), "The screen = " + screenData + "\nThe expected value = " + expectedData);
		} else if (condition.toLowerCase().startsWith("starts")) {
			Assert.assertTrue(screenData.startsWith(expectedData), "The screen = " + screenData + "\nThe expected value = " + expectedData);
		} else if (condition.toLowerCase().startsWith("ends")) {
			Assert.assertTrue(screenData.endsWith(expectedData), "The screen = " + screenData + "\nThe expected value = " + expectedData);
		} // end if/else

	} // end verification
	
	/**
	 * Perform an assertion/verification
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Perform an assertion between 2 sets of data. The type of assertion depends on the containsOrEquals param</li>
	 * </ul>
	 * @param driver The driver
	 * @param screenData The data on the screen to compare against
	 * @param condition The type of assertion to perform
	 * @param expectedData The data to compare against the screenData
	 */
	public void verification(RemoteWebDriver driver, boolean screenData, String condition, boolean expectedData) {

		System.out.println("Performing verification that the screen data - " + screenData + " " + condition + " the expected data - " + expectedData);

		if (condition.toLowerCase().startsWith("equal")||(condition.toLowerCase().startsWith("=="))) {
			Assert.assertTrue(screenData==expectedData, "The screen = " + screenData + "\nThe expected value = " + expectedData);
		} else if (condition.toLowerCase().startsWith("!equal") || condition.toLowerCase().startsWith("does not equal")||(condition.toLowerCase().startsWith("!="))) {
			Assert.assertTrue(screenData!=expectedData, "The screen = " + screenData + "\nThe expected value = " + expectedData);
		} // end if/else

	} // end verification
	
	/**
	 * Perform an assertion/verification
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Perform an assertion between 2 sets of data. The type of assertion depends on the containsOrEquals param</li>
	 * </ul>
	 * @param driver The driver
	 * @param screenData The data on the screen to compare against
	 * @param condition The type of assertion to perform
	 * @param expectedData The data to compare against the screenData
	 */
	public void verification(RemoteWebDriver driver, int screenData, String condition, int expectedData) {

		System.out.println("Performing verification that the screen data - " + screenData + " " + condition + " the expected data - " + expectedData);

		if (condition.toLowerCase().startsWith("equal") || condition.toLowerCase().startsWith("==")) {
			Assert.assertTrue(screenData==expectedData, "The screen = " + screenData + "\nThe expected value = " + expectedData);
		} else if (condition.toLowerCase().startsWith("!equal") || condition.toLowerCase().startsWith("does not equal") || condition.toLowerCase().startsWith("!=")) {
			Assert.assertTrue(screenData!=expectedData, "The screen = " + screenData + "\nThe expected value = " + expectedData);
		} else if (condition.toLowerCase().startsWith(">") || condition.toLowerCase().startsWith("greater")) {
			Assert.assertTrue(screenData!=expectedData, "The screen = " + screenData + "\nThe expected value = " + expectedData);
		}else if (condition.toLowerCase().startsWith("<") || condition.toLowerCase().startsWith("less")) {
			Assert.assertTrue(screenData!=expectedData, "The screen = " + screenData + "\nThe expected value = " + expectedData);
		} // end if/else

	} // end verification

	/**
	 * Close the alert and get the text
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Check for an alert present</li>
	 * 	<li>If an alert exists, get the text of the alert</li>
	 * 	<li>Close the alert</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @param acceptNextAlert Whether or not to go to a new alert
	 * @return Returns the text of the alert
	 * @throws InterruptedException the exception
	 */
	public String closeAlertAndGetItsText(RemoteWebDriver driver, boolean acceptNextAlert) throws InterruptedException {

		String alertText = null;

		int i = 0;
		while (i++<20) {
			try {
				Alert alert = driver.switchTo().alert();
				alertText = alert.getText();
				if (acceptNextAlert) {
					alert.accept();
				} else {
					alert.dismiss();
				} // end if/else
			} catch (NoAlertPresentException e) {
				Thread.sleep(1000);
				continue;
			} finally {
				acceptNextAlert = true;
			} // end try
		} // end while

		return alertText;

	} // end closeAlertAndGetITsText
	
	/**
	 * Close the alert if it exists
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Check for an alert present</li>
	 * 	<li>If an alert exists, close the alert</li>
	 * </ul>.
	 *
	 * @param driver The driver
	 * @return Returns if an alert was displayed
	 */
	public boolean closeAlertIfItExists(RemoteWebDriver driver) {

		boolean alertDisplayed = false;
		
		// Switch to the alert and accept it if it exists
		try {
			
			// Switch to the alert
			Alert alert = driver.switchTo().alert();
			
			// Accept the alert
			alert.accept();
			
			// Set the return value to true
			alertDisplayed = true;
			
		} catch (NoAlertPresentException Ex) {

		} // end try/catch 
		
		// Return if the alert was displayed
		return alertDisplayed;

	} // end closeAlertAndGetITsText

	/**
	 * Wait for an iFrame by the src attribute and then switch to it
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Wait for multiple iFrames</li>
	 * 	<li>Count the number of iFrames</li>
	 * 	<li>Create a list of all iFrame elements</li>
	 * 	<li>Iterate through each iFrame and get the src attribute</li>
	 * 	<li>If the src matches the expected src, switch to that iFrame by the index value</li>
	 * 	<li>Look for an expected element inside that iFrame and wait for it to be displayed</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @param src The src of the iFrame to be switched to
	 * @param by The selector of an element inside the iFrame
	 * @throws InterruptedException the interrupted exception
	 */
	public void waitForiFrameSrcAndSwitchToIt(RemoteWebDriver driver, String src, By by) throws InterruptedException {

		// Wait for multiple iFrames
		perform.waitForIFrames(driver);

		// Count number of iFrame
		boolean staleElement = false;
		int index = 0;
		List<WebElement> frame = driver.findElements(By.cssSelector("iframe"));
		for (WebElement el: frame) {
			String source = "";
			try {
				source = el.getAttribute("src");
			} catch (StaleElementReferenceException e) {
				staleElement = true;
				frame = driver.findElements(By.cssSelector("iframe"));
				index = 0;
			} // end try/catch

			if (staleElement==false)
			{
				System.out.println("The source for index " + index + " = " + source);
				if (source.contains(src)) {
					// Switch into frame
					driver.switchTo().frame(index);
					System.out.println("Switched to index " + index);

					// Get element size
					int size = driver.findElements(by).size();
					System.out.println("Size = " + size);

					int iteration = 1;
					while (iteration <= 10 && size == 0) {
						System.out.println("Element is not currently displayed in the iFrame");
						Thread.sleep(500);
						driver.switchTo().defaultContent();
						driver.switchTo().frame(index);
						size = driver.findElements(by).size();
						iteration++;
						if (iteration > 10) {
							org.testng.Assert.fail("The element could not be found");
						} // end if
					} // end while
					System.out.println("Element has been found in the current iFrame. Continuing on...");
					break;
				} // end if

				// Increment to next iFrame
				index++;
			} // end if staleElement
		} // end for loop for frames

	} // end waitForiFrameSrcAndSwitchToIt

	/**
	 * Run a batch file
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Execute the batch file</li>
	 * </ul>
	 *
	 * @param fileDirectory The location of the batch file to be run
	 * @param fileName The name of the batch file to run
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	public void runBatchFile(String fileDirectory, String fileName) throws IOException, InterruptedException {

		final Runtime rt = Runtime.getRuntime();
		try {
			@SuppressWarnings("unused")
			Process p = rt.exec("cmd /C start " + fileDirectory+"\\"+fileName + " exit");
		} catch (final IOException e) {
			throw new RuntimeException("Failed to run bat file");
		} // end try/catch

	} // end runBatchFile

	/**
	 * Verify text contains a certain value(s)
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get the number of items expected from an array</li>
	 * 	<li>Iterate through each each expected item in the array and perform an assertion that the screenText contains the expected text</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @param screenText The String used to verify contains given text
	 * @param expected A String array of items expected to be in the given screenText
	 */
	public void verifyTextContains(RemoteWebDriver driver, String screenText, String[] expected) {

		// Get number of elements are in expected text
		int size = expected.length;

		// Verify element text contains expected text
		for (int i = 0; i < size; i++) {
			Assert.assertTrue(screenText.contains(expected[i]), expected[i]+" - should be displayed, but the text on the screen is:\n" + screenText + "\n");
		} // end for loop

	} // end verifyTextContains
	
	/**
	 * Verify text contains a value
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Verify the screenText contains the expected text</li>
	 * </ul>.
	 *
	 * @param driver The driver
	 * @param screenText The String used to verify contains given text
	 * @param expected A String expected to be in the given screenText
	 */
	public void verifyTextContains(RemoteWebDriver driver, String screenText, String expected) {

		// Verify element text contains expected text
		Assert.assertTrue(screenText.contains(expected), expected+" should be displayed, but the text on the screen is = " + screenText);

	} // end verifyTextContains

	
	
	/**
	 * Verify text does not contain a certain value(s)
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get the number of items not expected from an array</li>
	 * 	<li>Iterate through each each item not expected in the array and perform an assertion that the screenText does not contain the expected text</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @param screenText The String used to verify does not contain given text
	 * @param notExpected A String array of items not expected to be in the given String
	 */
	public void verifyTextDoesNotContain(RemoteWebDriver driver, String screenText, String[] notExpected) {

		// Get number of elements are in expected text
		int size = notExpected.length;

		// Verify element text does not contain expected text
		for (int i = 0; i < size; i++) {
			Assert.assertTrue(!screenText.contains(notExpected[i]), notExpected[i]+" should not be displayed, but the text on the screen is = " + screenText);
		} // end for loop

	} // end verifyTextDoesNotContain
	
	/**
	 * Verify text does not contains a value
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Verify the screenText contains the expected text</li>
	 * </ul>.
	 *
	 * @param driver The driver
	 * @param screenText The String used to verify contains given text
	 * @param expected A String expected to be in the given screenText
	 */
	public void verifyTextDoesNotContain(RemoteWebDriver driver, String screenText, String expected) {

		// Verify element text does not contain expected text
		Assert.assertTrue(!screenText.contains(expected), expected+" should be displayed, but the text on the screen is = " + screenText);

	} // end verifyTextDoesNotContain

	
	
	/**
	 * Verify text equals a certain value(s)
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get the number of items expected from an array</li>
	 * 	<li>Iterate through each each expected item in the array and perform an assertion that the screenText equals the expected text</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @param screenText The String used to verify equals given text
	 * @param expected A String array of items expected to be in the given String
	 */
	public void verifyTextEquals(RemoteWebDriver driver, String screenText, String[] expected) {

		// Get number of elements are in expected text
		int size = expected.length;

		// Verify element text equals expected text
		for (int i = 0; i < size; i++) {
			Assert.assertTrue(screenText.equals(expected[i]), expected[i]+" should be displayed, but the text on the screen is = " + screenText);
		} // end for loop

	} // end verifyTextEquals

	
	
	/**
	 * Verify text equals a certain value(s)
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get the number of items expected from an array</li>
	 * 	<li>Iterate through each each expected item in the array and perform an assertion that the screenText equals the expected text</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @param screenText The String used to verify equals given text
	 * @param expected A String array of items expected to be in the given String
	 */
	public void verifyTextEquals(RemoteWebDriver driver, String screenText, String expected) {


		// Verify element text equals expected text
			Assert.assertTrue(screenText.equals(expected), expected+" should be displayed, but the text on the screen is = " + screenText);
		// end for loop

	}   // end verifyTextEquals
	
	
	/**
	 * Verify text does not equal a certain value(s)
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get the number of items not expected from an array</li>
	 * 	<li>Iterate through each each item not expected in the array and perform an assertion that the screenText does not equal the expected text</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @param screenText The String used to verify does not equal given text
	 * @param notExpected A String array of items not expected to be in the given String
	 */
	public void verifyTextDoesNotEqual(RemoteWebDriver driver, String screenText, String[] notExpected) {

		// Get number of elements are in expected text
		int size = notExpected.length;

		// Verify element text does not equal expected text
		for (int i = 0; i < size; i++) {
			Assert.assertTrue(!screenText.equals(notExpected[i]), notExpected[i]+" should not be displayed, but the text on the screen is = " + screenText);
		} // end for loop

	} // end verifyTextDoesNotEqual
	
	/**
	 * Verify text does not equal a certain value(s)
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get the number of items not expected from an array</li>
	 * 	<li>Iterate through each each item not expected in the array and perform an assertion that the screenText does not equal the expected text</li>
	 * </ul>
	 *
	 * @param driver The driver
	 * @param screenText The String used to verify does not equal given text
	 * @param notExpected A String array of items not expected to be in the given String
	 */
	public void verifyTextDoesNotEqual(RemoteWebDriver driver, String screenText, String notExpected) {

		// Verify element text does not equal expected text
		Assert.assertTrue(!screenText.equals(notExpected), notExpected+" should not be displayed, but the text on the screen is = " + screenText);

	} // end verifyTextDoesNotEqual

	
	/**
	 * Reads an Excel .xlsx file and return all of the data as an array. The first row is to be used as a header row
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Read the Excel file using the file and sheetName values passed in</li>
	 *  	<li>Get the number of rows and columns in the Excel sheet</li>
	 *   <li>Iterate through the Excel sheet and build an array of all the data</li>
	 *   <li>Return the data as an array</li>
	 * </ul>
	 *
	 * @param file The file path and file name of the .xlsx file to be read
	 * @param sheetName The sheet name within the Excel file that has the data to be read
	 * @return data An array of all the data in the Excel file
	 * @throws InvalidFormatException the invalid format exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public String[][] readExcelData(String file, String sheetName) throws InvalidFormatException, IOException {

		// Read the Excel file
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = WorkbookFactory.create(stream);
		Sheet s = workbook.getSheet(sheetName);

		// Get the number of rows and columns
		int rowcount = s.getLastRowNum();
		int cellcount = s.getRow(0).getLastCellNum();

		// Create an array of the data
		String data[][] = new String[rowcount][cellcount];
		for (int i = 1; i <= rowcount; i++) {
			Row row = s.getRow(i);
			for (int j = 0; j < cellcount; j++) {
				Cell cell = row.getCell(j);
				try {
					if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
						data[i - 1][j] = cell.getStringCellValue();
					} else {
						data[i - 1][j] = String.valueOf(cell.getNumericCellValue());
					} // end if/else
				} catch (Exception e) {
					e.printStackTrace();
				} // end try/catch
			} // end for cell
		} // end for row

		return data;

	} // end getCellData
	
	/**
	 * Gain the ability to capture the response codes
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Send a GET request to the supplied URL</li>
	 * 	<li>Get the response code</li>
	 * </ul>
	 *
	 * @param urlString the url string
	 * @return The response code returned from the GET request
	 * @throws MalformedURLException the malformed URL exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */	
	public int getResponseCode(String urlString) throws MalformedURLException, IOException{
		URL url = new URL(urlString);
		HttpURLConnection huc = (HttpURLConnection)url.openConnection();
		huc.setRequestMethod("GET");
		huc.connect();
		return huc.getResponseCode();
	} // end getResponseCode

	/**
	 * Get the detailed info for http status codes
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Take the supplied status code and return the detailed information of that code</li>
	 * </ul>
	 *
	 * @param statusCode The status code from a request
	 * @return The status code detail from the given status code number
	 */
	public String getStatusCodeDetail(String statusCode) {

		String statusCodeDetail = null;

		String[] code = new String[63];

		code[0] = "100 - Continue";
		code[1] = "101 - Switching Protocols";
		code[2] = "102 - Processing";
		code[3] = "200 - OK";
		code[4] = "201 - Created";
		code[5] = "202 - Accepted";
		code[6] = "203 - Non-authoritative Information";
		code[7] = "204 - No Content";
		code[8] = "205 - Reset Content";
		code[9] = "206 - Partial Content";
		code[10] = "207 - Multi-Status";
		code[11] = "208 - Already Reported";
		code[12] = "226 - IM Used";
		code[13] = "300 - Multiple Choices";
		code[14] = "301 - Moved Permanently";
		code[15] = "302 - Found";
		code[16] = "303 - See Other";
		code[17] = "304 - Not Modified";
		code[18] = "305 - Use Proxy";
		code[19] = "307 - Temporary Redirect";
		code[20] = "308 - Permanent Redirect";
		code[21] = "400 - Bad Request";
		code[22] = "401 - Unauthorized";
		code[23] = "402 - Payment Required";
		code[24] = "403 - Forbidden";
		code[25] = "404 - Not Found";
		code[26] = "405 - Method Not Allowed";
		code[27] = "406 - Not Acceptable";
		code[28] = "407 - Proxy Authentication Required";
		code[29] = "408 - Request Timeout";
		code[30] = "409 - Conflict";
		code[31] = "410 - Gone";
		code[32] = "411 - Length Required";
		code[33] = "412 - Precondition Failed";
		code[34] = "413 - Payload Too Large";
		code[35] = "414 - Request-URI Too Long";
		code[36] = "415 - Unsupported Media Type";
		code[37] = "416 - Requested Range Not Satisfiable";
		code[38] = "417 - Expectation Failed";
		code[39] = "418 - I'm a teapot";
		code[40] = "421 - Misdirected Request";
		code[41] = "422 - Unprocessable Entity";
		code[42] = "423 - Locked";
		code[43] = "424 - Failed Dependency";
		code[44] = "426 - Upgrade Required";
		code[45] = "428 - Precondition Required";
		code[46] = "429 - Too Many Requests";
		code[47] = "431 - Request Header Fields Too Large";
		code[48] = "444 - Connection Closed Without Response";
		code[49] = "451 - Unavailable For Legal Reasons";
		code[50] = "499 - Client Closed Request";
		code[51] = "500 - Internal Server Error";
		code[52] = "501 - Not Implemented";
		code[53] = "502 - Bad Gateway";
		code[54] = "503 - Service Unavailable";
		code[55] = "504 - Gateway Timeout";
		code[56] = "505 - HTTP Version Not Supported";
		code[57] = "506 - Variant Also Negotiates";
		code[58] = "507 - Insufficient Storage";
		code[59] = "508 - Loop Detected";
		code[60] = "510 - Not Extended";
		code[61] = "511 - Network Authentication Required";
		code[62] = "599 - Network Connect Timeout Error";

		for (int i = 0; i < code.length; i++)
		{
			if (code[i].startsWith(statusCode))
			{
				statusCodeDetail = code[i];
				return statusCodeDetail;
			} // end if statement looking for matching code
		} // end for loop iterating through all the code details

		return (statusCode + " - Description not found");

	} // end getStatusCodeDetail

	/**
	 * Compares two Strings, and returns the portion where they differ.
	 * (More precisely, return the remainder of the second String,
	 * starting from where it's different from the first.)
	 *
	 * For example,
	 * <code>difference("i am a machine", "i am a robot")  "robot"</code>.
	 *
	 * <pre>
	 * StringUtils.difference(null, null) = null
	 * StringUtils.difference("", "") = ""
	 * StringUtils.difference("", "abc") = "abc"
	 * StringUtils.difference("abc", "") = ""
	 * StringUtils.difference("abc", "abc") = ""
	 * StringUtils.difference("ab", "abxyz") = "xyz"
	 * StringUtils.difference("abcde", "abxyz") = "xyz"
	 * StringUtils.difference("abcde", "xyz") = "xyz"
	 * </pre>
	 *
	 * @param str1  the first String, may be null
	 * @param str2  the second String, may be null
	 * @return the portion of str2 where it differs from str1; returns the
	 * empty String if they are equal
	 * @since 2.0
	 */
	public String difference(String str1, String str2) {
		if (str1 == null) {
			return str2;
		}
		if (str2 == null) {
			return str1;
		}
		int at = indexOfDifference(str1, str2);
		if (at == -1) {
			return "";
		}
		return str2.substring(at);
	} // end difference

	/**
	 * Compares two Strings, and returns the index at which the
	 * Strings begin to differ.
	 *
	 * For example,
	 * <code>indexOfDifference("i am a machine", "i am a robot") 7</code>
	 *
	 * <pre>
	 * StringUtils.indexOfDifference(null, null) = -1
	 * StringUtils.indexOfDifference("", "") = -1
	 * StringUtils.indexOfDifference("", "abc") = 0
	 * StringUtils.indexOfDifference("abc", "") = 0
	 * StringUtils.indexOfDifference("abc", "abc") = -1
	 * StringUtils.indexOfDifference("ab", "abxyz") = 2
	 * StringUtils.indexOfDifference("abcde", "abxyz") = 2
	 * StringUtils.indexOfDifference("abcde", "xyz") = 0
	 * </pre>
	 *
	 * @param str1  the first String, may be null
	 * @param str2  the second String, may be null
	 * @return the index where str2 and str1 begin to differ; -1 if they are equal
	 * @since 2.0
	 */
	public static int indexOfDifference(String str1, String str2) {
		if (str1 == str2) {
			return -1;
		}
		if (str1 == null || str2 == null) {
			return 0;
		}
		int i;
		for (i = 0; i < str1.length() && i < str2.length(); ++i) {
			if (str1.charAt(i) != str2.charAt(i)) {
				break;
			}
		}
		if (i < str2.length() || i < str1.length()) {
			return i;
		}
		return -1;
	}  // end indexOfDifference

	/**
	 * Manage the driver by setting the localFileDetector, implicit wait time and window size
	 *
	 * @param driver the driver
	 */
	public void manageDriver(RemoteWebDriver driver) {

		// Set file detector
		try {
			driver.setFileDetector(new LocalFileDetector());
		} catch (Exception e) {
			System.out.println("Could not set file detector: " + e);
		} // end try/catch

		//Put an Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		// Maximize the window (crucial for PhantomJS tests)
		if (StoredVariables.getuseLocalGrid().get().toLowerCase().equals("true") || StoredVariables.getuseLocalGrid().get().toLowerCase().equals("false")) {
			try {
				driver.manage().window().setSize(new Dimension(1280, 1024));
				try {
					driver.manage().window().maximize();
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Could not maximize window");
				}
			} catch (Exception e) {
				System.out.println("Could not change the window size: " + e);
			} // end try/catch
		} // end if maximize window

	} // end createSecondDriver

	/**
	 * Copy a file from one directory to another directory
	 *
	 * @param driver the driver
	 * @param fromPath the path to the file you want to copy from
	 * @param toPath the path to the file you want to copy to
	 * @throws IOException the exception
	 */
	public void copyFileFromOneDirToAnotherDir(RemoteWebDriver driver, String fromPath, String toPath) throws IOException {

		// Copy blank image for failure
		Path FROM = Paths.get(fromPath);
		Path TO = Paths.get(toPath);
		CopyOption[] options = new CopyOption[]{
				StandardCopyOption.REPLACE_EXISTING,
				StandardCopyOption.COPY_ATTRIBUTES
		}; 
		java.nio.file.Files.copy(FROM, TO, options);

	} // end copyFileFromOneDirToAnotherDir

	/**
	 * Copy a file from one directory to another directory
	 *
	 * @param fromPath the path to the file you want to copy from
	 * @param toPath the path to the file you want to copy to
	 * @throws IOException the exception
	 */
	public void copyFileFromOneDirToAnotherDir(String fromPath, String toPath) throws IOException {

		System.out.println("Copy file from: " + fromPath + " to " + toPath);

		// Copy blank image for failure
		Path FROM = Paths.get(fromPath);
		Path TO = Paths.get(toPath);
		CopyOption[] options = new CopyOption[]{
				StandardCopyOption.REPLACE_EXISTING,
				StandardCopyOption.COPY_ATTRIBUTES
		}; 
		java.nio.file.Files.copy(FROM, TO, options);

	} // end copyFileFromOneDirToAnotherDir

	/**
	 * Highlight an element.
	 *
	 * @param driver the driver
	 * @param element the element
	 * @return the string
	 */
	public String highlightElement(RemoteWebDriver driver, WebElement element) {

		String original_style = null;
		
		try {
			original_style = element.getAttribute("style");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // end try/catch
		
		return original_style;

	} // end highlightElement
	
	/**
	 * Highlight an element.
	 *
	 * @param driver the driver
	 * @param original_style the original style
	 * @param element the element
	 */
	public void unhighlightElement(RemoteWebDriver driver, String original_style, WebElement element) {

		try {
			
			if (element.isDisplayed()) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript(
		                "arguments[0].setAttribute(arguments[1], arguments[2])",
		                element,
		                "style",
		                original_style);
			} // end if
			
		} catch (Exception e) {}

	} // end unhighlightElement

	/**
	 * Wait for Angular page to load
	 *
	 * @param driver the driver
	 */
	public void waitForAngularPageToLoad(RemoteWebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 15, 100);
		wait.until(AdditionalConditions.angularHasFinishedProcessing());

	} // end waitForAngularPageToLoad

	/**
	 * Sleep
	 *
	 * @param driver the driver
	 * @param seconds the number of seconds to sleep
	 * @throws InterruptedException The exception
	 */
	public void sleep(RemoteWebDriver driver, int seconds) throws InterruptedException {

		for (int a = 1; a <=seconds; a++) {
			System.out.println("Sleep " + a + " of " + seconds);
			Thread.sleep(1000);
		} // end for

	} // end waitForAngularPageToLoad

	/**
	 * Sleep
	 *
	 * @param driver the driver
	 * @param d the number to round
	 * @param decimalPlace the number of decimal places
	 * @return the float value
	 * @throws InterruptedException The exception
	 */
	public float roundFloat(RemoteWebDriver driver, float d, int decimalPlace) throws InterruptedException {

		BigDecimal bd = new BigDecimal(Float.toString(d));
		bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
		return bd.floatValue();

	} // end waitForAngularPageToLoad

	/**
	 * Encrypt a String
	 *
	 * @param encryptionPassword the password for the encryption
	 * @param textToEncrypt the text to encrypt
	 * @return the encrypted text
	 * @throws Exception The exception
	 */
	public String encrypt(String encryptionPassword, String textToEncrypt) throws Exception {

		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		encryptor.setPassword(encryptionPassword);
		encryptor.setAlgorithm("PBEWithMD5AndTripleDES");
		String encryptedText = encryptor.encrypt(textToEncrypt);

		return encryptedText;

	} // end encrypt

	/**
	 * Decrypt a String
	 *
	 * @param encryptionPassword the password for the encryption
	 * @param encryptedText the String to decrypt
	 * @return the decrypted text
	 * @throws Exception The exception
	 */
	public String decrypt(String encryptionPassword, String encryptedText) throws Exception {

		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		encryptor.setPassword(encryptionPassword);
		encryptor.setAlgorithm("PBEWithMD5AndTripleDES");
		String decryptedText = encryptor.decrypt(encryptedText);

		return decryptedText;

	} // end decrypt

	/**
	 * Read text file to a String
	 *
	 * @param directoryPath the directory path to the file
	 * @param file the file to be read as a String
	 * @return the contents of the file
	 * @throws Exception The exception
	 */
	public String readTextFileToAString(String directoryPath, String file) throws Exception {

		String contents = new String(Files.readAllBytes(Paths.get(directoryPath+file)), StandardCharsets.US_ASCII).trim();

		return contents;

	} // end readTextFileToAString

	/**
	 * Set the DB connection string
	 * @param driver the driver
	 * @param database the database you want to use
	 * @return the connection string for the database
	 * @throws Exception The exception
	 */
	public String setDBConnectionString(RemoteWebDriver driver, String database) throws Exception {

		String os = StoredVariables.getos().get();
		String dbUrl = null;
		dbUrl = "jdbc:sqlserver://" + StoredVariables.getdbName().get() + ":" + StoredVariables.getdbPort().get() + ";"+
				"databaseName=" + database + ";integratedSecurity=true;";
		if (os.equals("Mac")) {
			dbUrl = "jdbc:jtds:sqlserver://" + StoredVariables.getdbName().get() + ":" + StoredVariables.getdbPort().get() + ";"+
					"databaseName="+database+";domain=MERCURYVMP;useNTLMv2=true;user="+StoredVariables.getdbUser().get()+";password="+StoredVariables.getdbPW().get();
		} // end if Mac

		return dbUrl;

	} // end setDBConnectionString
	
	/**
	 * Set the DB connection string.
	 *
	 * @param driver the driver
	 * @param environment the environment
	 * @param database the database you want to use
	 * @return the connection string for the database
	 * @throws Exception The exception
	 */
	public String setDBConnectionString(RemoteWebDriver driver, String environment, String database) throws Exception {

		// Set the env variable
		String env = environment.toLowerCase().startsWith("qa") ? "QA" : "Live";
		
		// Get the operating system
		String os = StoredVariables.getos().get();
		
		// Initialize the db url variable
		String dbUrl = null;
		
		// Set the db name and port
		String dbName = env.equals("QA") ? "sql1qa.ad.mercuryvmp.com" : "sql1.ad.mercuryvmp.com";
		String dbPort = "1433";
		
		// Set the connection url
		dbUrl = "jdbc:sqlserver://" + dbName + ":" + dbPort + ";"+
				"databaseName=" + database + ";integratedSecurity=true;";
		if (os.equals("Mac")) {
			dbUrl = "jdbc:jtds:sqlserver://" + dbName + ":" + dbPort + ";"+
					"databaseName="+database+";domain=MERCURYVMP;useNTLMv2=true;user="+StoredVariables.getdbUser().get()+";password="+StoredVariables.getdbPW().get();
		} // end if Mac

		return dbUrl;

	} // end setDBConnectionString
	
	/**
	 * Get the location of an element (x, y coordinates)
	 * @param driver the driver
	 * @param element the element to get the location of
	 * @return the location with the X and Y coordinates
	 */
	public int[] getElementLocation(RemoteWebDriver driver, WebElement element) {

		// Get the middle X coordinate
		int leftX = element.getLocation().getX();
		int rightX = leftX + element.getSize().getWidth();
		int middleX = (rightX + leftX) / 2;

		// Get the middle Y coordinate
		int upperY = element.getLocation().getY();
		int lowerY = upperY + element.getSize().getHeight();
		int middleY = (upperY + lowerY) / 2;

		// Set the array with the middle X and middle Y coordinates
		int[] location = {middleX, middleY};

		return location;

	} // end getElementLocation

	/**
	 * Click the location of an element (x, y coordinates)
	 * @param driver the driver
	 * @param element the element to be clicked
	 */
	public void clickElementLocation(RemoteWebDriver driver, WebElement element) {

		// Get the X and Y coordinates of the element
		int[] location = getElementLocation(driver, element);

		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver).executeScript("el = document.elementFromPoint("+location[0]+", "+location[1]+"); el.click();");
		} // end if

	} // end clickElementLocation

	/**
	 * Extract the JS logs
	 * @param driver the driver
	 * @return return the javascript errors as a String
	 */
	public String extractJSLogs(RemoteWebDriver driver) {

		System.out.println("Extracted JS Logs:");

		StringBuilder logBuilder = new StringBuilder();
		LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
		for (LogEntry entry : logEntries) {
			if (entry.getLevel().toString().contains("SEVERE")) {
				logBuilder.append(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage() + "<br><br>");
			} // end if level
			System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
		} // end for
		return logBuilder.toString();

	} // end clickElementLocation

	/**
	 * Wait for the DOM to finish loading
	 * @param driver the driver
	 */
	public void waitDom(RemoteWebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.onload = null;");
	} // end waitDOM
	
	/**
	 * Get the domain from a URL
	 * @param driver the driver
	 * @param url the url
	 * @return returns the domain
	 * @throws MalformedURLException the exception
	 */
	public String getTopLevelDomainFromURL(RemoteWebDriver driver, String url) throws MalformedURLException {

		// Get the domain name from a URL
		String domain = InternetDomainName.from(new URL(url).getHost()).topPrivateDomain().toString();
		
		return domain;
	
	} // end getTopLevelDomainFromURL
	
	/**
	 * Add information to Extent Reports.
	 *
	 * @param driver the driver
	 * @param stepName the step name
	 * @param info the info to add to Extent Reports
	 */
	public void addInfoToExtentReport(RemoteWebDriver driver, String stepName, String info) {

		ExtentTest test = ExtentTestManager.getTest();
		
		// Add info to Extent Reports
		test.log(LogStatus.INFO, stepName, info);
	
	} // end addInfoToExtentReport
	
	/**
	 * Add warning to Extent Reports.
	 *
	 * @param driver the driver
	 * @param stepName the step name
	 * @param info the info to add to Extent Reports
	 */
	public void addWarningToExtentReport(RemoteWebDriver driver, String stepName, String info) {

		ExtentTest test = ExtentTestManager.getTest();
		
		// Add info to Extent Reports
		test.log(LogStatus.WARNING, stepName, info);
	
	} // end addWarningToExtentReport
	
	/**
	 * Add fail to Extent Reports.
	 *
	 * @param driver the driver
	 * @param stepName the step name
	 * @param info the info to add to Extent Reports
	 */
	public void addFailToExtentReport(RemoteWebDriver driver, String stepName, String info) {

		ExtentTest test = ExtentTestManager.getTest();
		
		// Add info to Extent Reports
		test.log(LogStatus.FAIL, stepName, info);
	
	} // end addFailToExtentReport
	
	/**
	 * Verify a List contains text.
	 *
	 * @param driver the driver
	 * @param list the list
	 * @param keywordToSearch the keyword to search
	 * @return true, if successful
	 */
	public boolean verifyListContains(RemoteWebDriver driver, ArrayList<String> list, String keywordToSearch) {

		boolean hasKeyword = false;
	    for (String value : list) {
	    	System.out.println("Value: " + value);
	        if (value.contains(keywordToSearch)) {
	            hasKeyword = true;
	            break;
	        } // end if
	    } // end for

	    Assert.assertTrue(hasKeyword, keywordToSearch + " is not in the list. The list equals: " + list);
	    
	    return hasKeyword;
	
	} // end verifyListContains
	
	/**
	 * Read a pdf file from disk.
	 *
	 * @param driver the driver
	 * @param file the full path to file and filename or just the filename. If just the filename is given, it will look in the Downloads folder by default
	 * @return the string
	 * @throws EmptyFileException the empty file exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	public String readPDFInURL(RemoteWebDriver driver, String file) throws EmptyFileException, IOException, InterruptedException {

		// Create fileURL variable
		String fileURL = "";
		String fullFilePath = "";
		
		// Set the slash based on the OS
		String slash = "\\";
		if (StoredVariables.getos().get().equals("Mac")) {
			slash = "/";
		} // end if
		
		// If the file does not contain a slash, get the file from the Downloads folder by default
		if (!file.contains(slash)) {
			// Get the file from the Downloads folder
			fullFilePath = StoredVariables.getdownloadsDir().get()+slash+file;
			fileURL = "file:///"+StoredVariables.getdownloadsDir().get()+slash+file;
		} else {
			// Get the file from the specified path
			fullFilePath = file;
			fileURL = "file:///"+file;
		} // end if/else
		
		// Make sure the file exists
		waitForFileToExist(driver, fullFilePath);
		
		// Open the pdf
		driver.get(fileURL);
		
		// Create the output variable
		String output = "";
		
		// Create URL
        URL url = new URL(driver.getCurrentUrl());
        
        // Open the InputStream
        InputStream is = url.openStream();
        
        // Parse the file
        BufferedInputStream fileToParse = new BufferedInputStream(is);
        
        // Set the document
        PDDocument document = null;
        
        // Read the PDF
        try {
            document = PDDocument.load(fileToParse);
            output = new PDFTextStripper().getText(document);
        } finally {
            if (document != null) {
                document.close();
            } // end if
            fileToParse.close();
            is.close();
        } // end try
        
        return output;
        
    } // end readPDFInURL
	
	/**
	 * Check to see if a file exists.
	 *
	 * @param driver the driver
	 * @param file the file
	 * @return true, if successful
	 */
	public boolean checkIfFileExists(RemoteWebDriver driver, String file) {

		// Set the slash based on the OS
		String slash = "\\";
		if (StoredVariables.getos().get().equals("Mac")) {
			slash = "/";
		} // end if
		
		// If the file does not contain a slash, get the file from the Downloads folder by default
		if (!file.contains(slash)) {
			// Get the file from the Downloads folder
			file = StoredVariables.getdownloadsDir().get()+slash+file;
		} // end if
		
		// Create the file object
		File fileToCheck = new File(file);
		
		// Check to see if the file exists
		boolean exists = fileToCheck.exists();
	    
	    return exists;
	
	} // end checkIfFileExists
	
	/**
	 * Create directory it if it doesn't exist.
	 *
	 * @param driver the driver
	 * @param directoryPath the directory path
	 */
	public void createDirectory(RemoteWebDriver driver, String directoryPath) {

		// Create the directory if it doesn't exist
	    File directory = new File(directoryPath);
	    if (! directory.exists()){
	        directory.mkdirs();
	    } // end if

	} // end createDirectory
	
	/**
	 * Create directory it if it doesn't exist.
	 *
	 * @param directoryPath the directory path
	 */
	public void createDirectory(String directoryPath) {

		// Create the directory if it doesn't exist
	    File directory = new File(directoryPath);
	    if (! directory.exists()){
	        directory.mkdirs();
	    } // end if

	} // end createDirectory
	
	/**
	 * Wait for a file to exist.
	 *
	 * @param driver the driver
	 * @param file the file
	 * @throws InterruptedException the interrupted exception
	 */
	public void waitForFileToExist(RemoteWebDriver driver, String file) throws InterruptedException {

		// Set the slash based on the OS
		String slash = "\\";
		if (StoredVariables.getos().get().equals("Mac")) {
			slash = "/";
		} // end if
		
		// If the file does not contain a slash, get the file from the Downloads folder by default
		if (!file.contains(slash)) {
			// Get the file from the Downloads folder
			file = StoredVariables.getdownloadsDir().get()+slash+file;
		} // end if
		
		// Wait a maximum of 3 minutes for the file to exist
		int a = 1;
		boolean exists = false;
		while (exists==false && a<=180) {
			exists = perform.checkIfFileExists(driver, file);
			Thread.sleep(1000);
			a++;
		} // end while
		
		Assert.assertTrue(exists==true, "The file " + file + " does not exist!");
		
	} // end waitForFileToExist
	
	/**
	 * Delete a file from the disk.
	 *
	 * @param driver the driver
	 * @param file the file
	 */
	public void deleteFile(RemoteWebDriver driver, String file) {

		// Set the slash based on the OS
		String slash = "\\";
		if (StoredVariables.getos().get().equals("Mac")) {
			slash = "/";
		} // end if
		
		// If the file does not contain a slash, get the file from the Downloads folder by default
		if (!file.contains(slash)) {
			// Get the file from the Downloads folder
			file = StoredVariables.getdownloadsDir().get()+slash+file;
		} // end if
		
		File fileToDelete = new File(file);
		try {
			fileToDelete.delete();
		} catch (Exception e) {
			System.out.println("The file " + fileToDelete + " does not exist!");
		} // end try/catch
		
	} // end deleteFile
	
	/**
	 * Open a new tab and switch to it.
	 *
	 * @param driver the driver
	 * @throws InterruptedException the interrupted exception
	 */
	public void openNewTabAndSwitchToIt(RemoteWebDriver driver) throws InterruptedException {

		// Get out of the iFrame
		driver.switchTo().defaultContent();
		
		// Open a new tab
		((JavascriptExecutor) driver).executeScript("window.open()");
		
		// Switch to the new tab
		perform.switchToWindowByTitle(driver, "Untitled");
	
	} // end openNewTabAndSwitchToIt
	
	/**
	 * Verify payment settings.
	 *
	 * @param driver the driver
	 * @param customerNumber the customer number
	 * @param makeAPaymentModeIDExpected the make A payment mode ID
	 * @param accountIDExpected the account ID
	 * @param enabledExpected the enabled
	 * @param cyberSourceMerchantIDExpected the cyber source merchant ID
	 * @param accountTypeIDExpected the account type ID
	 * @throws Exception the exception
	 */
	public void verifyPaymentSettings(RemoteWebDriver driver, String customerNumber, String makeAPaymentModeIDExpected, String accountIDExpected,
			String enabledExpected, String cyberSourceMerchantIDExpected, String accountTypeIDExpected) throws Exception {
		
		ArrayList<String> paymentSettings = db.getPaymentSettings(driver, customerNumber);
		perform.verification(driver, paymentSettings.get(0), "equals", makeAPaymentModeIDExpected);
		perform.verification(driver, paymentSettings.get(1), "equals", accountIDExpected);
		perform.verification(driver, paymentSettings.get(2), "equals", enabledExpected);
		perform.verification(driver, paymentSettings.get(3), "equals", cyberSourceMerchantIDExpected);
		perform.verification(driver, paymentSettings.get(4), "equals", accountTypeIDExpected);
		
	} // end verifyPaymentSettings
	
	/**
	 * Verify send payment link settings.
	 *
	 * @param driver the driver
	 * @param customerNumber the customer number
	 * @param enabledExpected the enabled
	 * @param userDeferredCCEmailExpected the user deferred CC email
	 * @throws Exception the exception
	 */
	public void verifySendPaymentLinkSettings(RemoteWebDriver driver, String customerNumber, String enabledExpected, String userDeferredCCEmailExpected) throws Exception {
		
		ArrayList<String> sendPaymentLinkSettings = db.getSendPaymentLinkSettings(driver, customerNumber);
		perform.verification(driver, sendPaymentLinkSettings.get(0), "equals", enabledExpected);
		perform.verification(driver, sendPaymentLinkSettings.get(1), "equals", userDeferredCCEmailExpected);
		
	} // end verifySendPaymentLinkSettings
	
	/**
	 * Verify entity settings bit.
	 *
	 * @param driver the driver
	 * @param entityID the entity ID
	 * @param entitySettingTypeIDToGetInfoFrom the entity setting type ID to get info from
	 * @param settingExpected the setting expected
	 * @throws Exception the exception
	 */
	public void verifyEntitySettingsBit(RemoteWebDriver driver, String entityID, String entitySettingTypeIDToGetInfoFrom, String settingExpected) throws Exception {
		
		ArrayList<String> entitySettingsBitInfo = db.getEntitySettingsBitInfo(driver, entityID, entitySettingTypeIDToGetInfoFrom);
		if (entitySettingsBitInfo.size()==0) {
			System.out.println("settingExpected: " + settingExpected);
			Assert.assertTrue(settingExpected==null, "There were no results returned for entitySettingTypeID: " + entitySettingTypeIDToGetInfoFrom);
		} else {
			perform.verification(driver, entitySettingsBitInfo.get(1), "equals", settingExpected);
		} // end if/else
		
	} // end verifyEntitySettingsBit
	
	/**
	 * Get the number of elements.
	 *
	 * @param driver the driver
	 * @param by the by
	 * @return the number of elements
	 */
	public int getNumberOfElements(RemoteWebDriver driver, By by) {
		
		// Initialize the number of elements variable
		int numberOfElements = 0;
		
		// Create a list of the elements
		List<WebElement> elements;
		try {
			elements = driver.findElements(by);
		} catch (Exception e) {
			elements = driver.findElements(by);
		} // end try/catch
		
		// Get the number of elements in the List
		numberOfElements = elements.size();
		
		// Return the number of elements
		return numberOfElements;
		
	} // end verifyEntitySettingsBit
	
	/**
	 * Get Great Great Grandparent
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get Great Great Grandparent</li>
	 * </ul>.
	 *
	 * @param driver The driver
	 * @param element The element to get the great great grandparent
	 * @return the GGG parent
	 */
	public WebElement getGGGParent(RemoteWebDriver driver, WebElement element){
		
		//Get Great Great Grandparent
		WebElement grandParent = element.findElement(By.xpath("../.."));
		WebElement gGGrandParent = grandParent.findElement(By.xpath("../.."));
			
		return gGGrandParent;
		
	} // end clickInDiv_Contains
	
	/**
	 * Verify download link works.
	 *
	 * @param driver the driver
	 * @param link the link
	 * @return the http response
	 * @throws ClientProtocolException the client protocol exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public HttpResponse verifyDownloadLinkWorks(RemoteWebDriver driver, String link) throws ClientProtocolException, IOException {
		
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpHead request = new HttpHead(link);
        HttpResponse response = httpClient.execute(request);
        int contentLength = Integer.parseInt(response.getFirstHeader("Content-Length").getValue());
        int statusCode = response.getStatusLine().getStatusCode();
        perform.verification(driver, contentLength, ">", 200);
        perform.verification(driver, statusCode, "==", 200);
		
        return response;
        
	} // end verifyDownloadLinkWorks
	
	/**
	 * Key press and click an element.
	 *
	 * @param driver the driver
	 * @param keyToPress the key to press
	 * @param elementToClick the element to click
	 */
	public void keyPressAndClick (RemoteWebDriver driver, Keys keyToPress, WebElement elementToClick) {
		
		Actions actions = new Actions(driver);
		actions.keyDown(keyToPress)
		    .click(elementToClick)
		    .keyUp(keyToPress)
		    .build()
		    .perform();
		
	} // end keyPressAndClick
	
	/**
	 * Get Great Great Grandparent
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get Great Great Grandparent</li>
	 * </ul>.
	 *
	 * @param driver The driver
	 * @param element The element to get the great great grandparent
	 * @return the GGG parent
	 */
	public WebElement getParent(RemoteWebDriver driver, WebElement element){
		
		//Get Child element
		WebElement parent = element.findElement(By.xpath("./.."));
			
		return parent;
		
	} // end clickInDiv_Contains
	
	/**
	 * Wait for page to load.
	 *
	 * @param driver the driver
	 * @throws InterruptedException 
	 */
	public void waitForPageToLoad(WebDriver driver) throws InterruptedException {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(pageLoadCondition);
        waitForAjaxToLoad(driver);
    } // end waitForPageToLoad
	
	/**
	 * Wait for ajax to load.
	 *
	 * @param driver the driver
	 * @throws InterruptedException the interrupted exception
	 */
	public void waitForAjaxToLoad(WebDriver driver) throws InterruptedException{
	    JavascriptExecutor executor = (JavascriptExecutor)driver;
	    if((Boolean) executor.executeScript("return window.jQuery != undefined")){
	        while(!(Boolean) executor.executeScript("return jQuery.active == 0")){
	            Thread.sleep(1000);
	        }
	    }
	    return;
	} // end waitForAjaxToLoad
	
} // end Function class
