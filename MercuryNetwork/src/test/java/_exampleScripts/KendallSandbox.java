package _exampleScripts;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

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
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import pageObjects.Secure.SConfirmOrder;
import pageObjects.Secure.SLogin;
import pageObjects.Secure.SNewOrder;
import pageObjects.Secure.SOrderDetails;
import pageObjects.Secure.SOrders;
import pageObjects.Secure.SSendViaSureReceipts;
import pageObjects.Vendors.VAccount;
import pageObjects.Vendors.VOrderDetails;
import pageObjects.Vendors.VOrders;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

/**
* <h1>Kendall's Sand Box</h1>
* This is a sand box to experiment with code
* <p>
* 
* @author  Dustin Norman
* @since   05-16-2018
*/

@SuppressWarnings("unused")
public class KendallSandbox extends TestSetup {
	
	/**
	 * @throws Exception
	 */
	@Test //(retryAnalyzer = Retry.class, groups={"example"})
	public void functionChecks() throws Exception {

		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Start writing code here

		//Log into Secure
		secure.login(driver, "managequicklists",StoredVariables.getpassword().get());

		//Find and open order
		secure.findAndOpenOrder(driver, "MERC-418298");

		perform.click(driver, SOrderDetails.message_btn(driver));
		
		// Wait for overlay
				perform.waitForOverlayToBeVisible(driver);
				
				// Switch iFrame
				perform.waitForiFrameSrcAndSwitchToIt(driver, "/SureReceipts/SendFiles.aspx", By.id(SSendViaSureReceipts.comments_txtbx()));
				
				// Wait for close button
				perform.waitForElementToBeClickable(driver, SSendViaSureReceipts.close_btn(), "id");
				Thread.sleep(2000);
				
				// Click the QL icon in the comments field
				perform.clickWithJavascript(driver, SSendViaSureReceipts.QL_btn(driver));
				
				// Wait for busy to be hidden
				perform.waitForBusyToBeHidden(driver);
				
				// Switch iFrame
				perform.waitForiFrameSrcAndSwitchToIt(driver, "/Common/Lists/Quick.aspx?", By.id(SSendViaSureReceipts.close_btn()));
				
				// Wait for close button
				perform.waitForElementToBeClickable(driver, SSendViaSureReceipts.close_btn(), "id");
				
				// Wait for busy to be hidden
				perform.waitForBusyToBeHidden(driver);
				
				// Click New
				perform.click(driver,SSendViaSureReceipts.new_btn(driver));
				
				// Wait for Cancel button
				perform.waitForElementToBeClickable(driver, SSendViaSureReceipts.save_btn(), "id");
				
				// Enter Description
				perform.type(driver,SSendViaSureReceipts.description_txtbx(driver), "Test");
				
				// Enter Text
				perform.type(driver,SSendViaSureReceipts.text_txtbx(driver), "These is test QuickList text");
				
				// Click Save
				perform.click(driver,SSendViaSureReceipts.save_btn(driver));
				
		
	}

}// end ExampleScripts class

