package _exampleScripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.Toolkit;
import java.io.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.crypto.Cipher;
import javax.mail.Store;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu.Separator;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.util.PDFTextStripper;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xerces.xinclude.XInclude11TextReader;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import pageObjects.InternalTools.ITNotificationSearch;
import pageObjects.Overlay.Overlay;
import pageObjects.Secure.SAQMQCModule;
import pageObjects.Secure.SClients;
import pageObjects.Secure.SClients_ClientGroups;
import pageObjects.Secure.SConfigureAutomaticSettings;
import pageObjects.Secure.SConfirmOrder;
import pageObjects.Secure.SConnectionSettings;
import pageObjects.Secure.SFeePanel;
import pageObjects.Secure.SLogin;
import pageObjects.Secure.SNewOrder;
import pageObjects.Secure.SOrderDetails;
import pageObjects.Secure.SOrders;
import pageObjects.Secure.SPayments;
import pageObjects.Secure.SProductRequirements;
import pageObjects.Secure.SReviewBids;
import pageObjects.Secure.SSendViaSureReceipts;
import pageObjects.Secure.SSureReceipts;
import pageObjects.Secure.SVMPXSites;
import pageObjects.Secure.SVendorSelection;
import pageObjects.Secure.SVendorSelectionSettings;
import pageObjects.VMP.VMPConfirmOrder;
import pageObjects.VMP.VMPNewOrder;
import pageObjects.VMP.VMPOrders;
import pageObjects.Vendors.VAccount;
import pageObjects.Vendors.VOrderDetails;
import pageObjects.Vendors.VQuickList;
import pageObjects.Vendors.VQuickListOld;
import pageObjects.Vendors.VSubmitBid;
import pageObjects.Vendors.VUsers;
import pageObjects.XSite.XBusinessManagement;
import pageObjects.XSite.XInvoice;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
* <h1>Dustin's Sand Box</h1>
* This is a sand box to experiment with code
* <p>
* 
* @author  Dustin Norman
* @since   05-16-2018
*/

@Listeners(utils.Listener.class)
@SuppressWarnings("unused")
public class DustinSandbox extends TestSetup {
	
	// Set user information
	private static String userEmailAddressName = "BaselineAppraiser1"; // Not the full email address, just the users last name (This will be used to create the standardized email address)
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main (String[] args) throws Exception {
		System.out.println("Running main");
		String phoneNumber = "405-555-1111";
		String[] part = phoneNumber.split("-");
		System.out.println("part 0: " + part[0]);
		System.out.println("part 1: " + part[1]);
		System.out.println("part 2: " + part[2]);
		String check = "("+part[0]+") "+part[1]+"-"+part[2];
		System.out.println("check: " + check);
		System.out.println("Ending main");
	} // end main
	
	/**
	 * @throws Exception
	 */
	@Test (groups={}, alwaysRun=true)
	public void quickFailure() throws Exception {
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		driver.get("http://www.google.com");
		int a = 1;
		int b = 2;
		Assert.assertTrue(a==b, a+ " does not equal " + b);
	} // end quickFailure
	
//	@DataProvider
//	public String[][] loginData() throws InvalidFormatException, IOException{
//	return perform.readExcelData("C:\\Users\\dustin.norman\\Desktop\\SecureLogin.xlsx", "Sheet1");
//	}
//	
//	@Test (dataProvider="loginData", groups={}, alwaysRun=true)
//	public void testUsingExcel(String user, String password) throws Exception {
//		
//		ExtentTest test = ExtentTestManager.getTest();
//		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
//		
//		System.out.println("user: " + user + "\t\t password: " + password);
//		secure.login(driver, user, password);
//		
//	} // end testUsingExcel
	
	/**
	 * @throws Exception
	 */
	@Test (groups={}, alwaysRun=true)
	public void functionChecks() throws Exception {

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		String password = StoredVariables.getpassword().get();
		System.out.println("This is functionChecks");
		
		
	} // end functionChecks

} // end ExampleScripts class