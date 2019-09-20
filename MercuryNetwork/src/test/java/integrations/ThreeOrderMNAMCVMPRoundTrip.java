package integrations;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import com.jcabi.xml.XMLDocument;
import com.jcabi.xml.XML;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjects.Secure.SConfirmOrder;
import pageObjects.Secure.SOrderDetails;
import pageObjects.VMP.VMPOrderDetails;
import pageObjects.Vendors.VOrderDetails;
import pageObjects.XSite.XOrders;
import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Integrations - Three Order AMC VMP Round Trip</h1>
 * 
 * <p>Test Case 2
 *
 * @author  Dustin Norman
 * @since   07-16-2018
 */

@Listeners(utils.Listener.class)
@Test(singleThreaded=true, retryAnalyzer = Retry.class)
public class ThreeOrderMNAMCVMPRoundTrip extends TestSetup {
	
	/** The session key. */
	private static String sessionKey = "";
	
	/** The tracking ID. */
	private static String trackingID = "";
	
	/** The tracking number. */
	private static String trackingNumber = "";
	
	/** The fee. */
	private static String fee = "";
	
	/** The due date. */
	private static String dueDate = "";
	
	/** The second loan ID. */
	private static String secondLoanID = "";
	
	/** The document ID. */
	private static String documentID = "";
	
	/** The AMC Tracking Number */
	private static String amcTrackingNumber = "";
	
	/** The password */
	private final String password = "@utoma7ionT3sting!";
	
	/** The Appraiser ID */
	private static String appraiserID = "";

	/** The Vendor */
	private static String vendor = "";

	/** The Vendor User */
	private static String vendorUser = "";

	/** The Lender */
	private static String lender = "";

	/** The Lender User */
	private static String lenderUser = "";

	/** The Client */
	private static String client = "";

	/** The Client User */
	private static String clientUser = "";

	/** The AMC */
	private static String amc = "";

	/** The AMC User */
	private static String amcUser = "";
	
	/** The AMC User */
	private static String amcName = "";

	/** The file1 file */
	private static String file1 = "";

	/** The file2 file */
	private static String file2 = "";
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set user variables</li>
	 * 	<li>Login and get the session key</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (groups={"Integrations", "API - Login"}, alwaysRun=true)
	public void login() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Set user variables
		appraiserID = "1071187";
		vendor = "AutomationIntQA TestingAppraiser";
		vendorUser = "AutomationIntQATestingAppraiser@mercuryvmp.com";
		lender = "AutomationIntegrationQA TestingLender";
		lenderUser = "AutomationIntQATestingLender@mercuryvmp.com";
		client = "AutomationIntQA Client4";
		clientUser = "AutomationIntQATestingClient4";
		amc = "AutomationIntQATestingAMC";
		amcUser = "AutomationIntQATestingAMC@mercuryvmp.com";
		amcName = "AutomationIntQA TestingAMC";
		file1 = "LenderNoGroups2.xml";
		file2 = "PlaceAppraisalOrderExLenderNoGroups2.xml";
		if (StoredVariables.getusernameEnvironment().get().equals("Live")) {
			appraiserID = "5711240";
			vendor = "AutomationInt TestingAppraiser";
			vendorUser = "AutomationIntTestingAppraiser@mercuryvmp.com";
			lender = "AutomationInt TestingLender";
			lenderUser = "AutomationIntTestingLender@mercuryvmp.com";
			client = "AutomationInt TestingClient4";
			clientUser = "AutomationIntTestingClient4";
			amc = "AutomationIntTestingAMC";
			amcUser = "AutomationIntTestingAMC@mercuryvmp.com";
			amcName = "AutomationInt TestingAMC";
			file1 = "LenderNoGroups2Live.xml";
			file2 = "PlaceAppraisalOrderExLenderNoGroups2Live.xml";
		} // end if
		
		// Login and get the session key
		sessionKey = perform.apiLogin(driver, clientUser, password);
		
		// Log test
		test.log(LogStatus.INFO, "Integration", "Logged in by calling the Login method and storing the SessionKey");
		
	} // end login
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set GetVMPOrderFormFields Method POST URL</li>
	 * 	<li>Call GetVMPOrderFormFields Method and get the response</li>
	 * 	<li>Convert Response XML to single line String</li>
	 * 	<li>Convert XML File to single line String</li>
	 * 	<li>Verify the XML is the same</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ClassNotFoundException the ClassNotFoundExceptionthe class not found exception
	 * @throws SQLException the SQLExceptionthe SQL exception
	 * @throws ParserConfigurationException the parser configuration exception
	 * @throws SAXException the SAX exception
	 * @throws TransformerException the transformer exception
	 */
	@Test (groups={"Integrations", "API - GetVMPOrderFormFields"}, dependsOnMethods="login")
	public void getVMPOrderFormFields() throws InterruptedException, IOException, ClassNotFoundException, SQLException, ParserConfigurationException, SAXException, TransformerException{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		String os = StoredVariables.getos().get();

		// Set GetVMPOrderFormFields Method POST URL
		String url = StoredVariables.getapiURL().get()+"mercuryapi.asmx/GetVMPOrderFormFields";
		String urlParameters = "SessionKey="+sessionKey+"&AppraiserID="+appraiserID+"&IPAddress=127.0.0.1";
		
		// Call GetVMPOrderFormFields Method and get the response
		String[] response = perform.httpPost(driver, url, urlParameters);
		String body = response[2];
		
	    // Convert Response XML to single line String
	    String xml1 = body.replace("<?xml version=\"1.0\" encoding=\"utf-8\"?>", "").trim();
	    String responseXML = perform.stringBuilderFromStringTrimmed(driver, xml1);
		
	    // Convert XML File to single line String
	    String fileXML = null;
	    if (os.equals("Windows")) {
	    	fileXML = perform.stringBuilderFromFileTrimmed(driver, perform.filepathForAPIXMLFiles(driver)+"GetVMPOrderFormFields\\"+file1);
	    } else if (os.equals("Mac")) {
	    	fileXML = perform.stringBuilderFromFileTrimmed(driver, perform.filepathForAPIXMLFiles(driver)+"GetVMPOrderFormFields/"+file1);
	    } // end if/else

		// Verify the XML is the same
		Assert.assertTrue(responseXML.equals(fileXML), "XML file is incorrect. Response = " + responseXML + "\nFile = " + fileXML);
		
		// Log test
		test.log(LogStatus.INFO, "Integration", "Verified the correct XML file was retruned when calling GetVMPOrderFormFields");
		
	} // end getVMPOrderFormFields
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set path to the XML file</li>
	 * 	<li>Generate a random loan number</li>
	 * 	<li>Update LENDERCASENUMBER in XML File</li>
	 * 	<li>Reading XML as String using jCabi library</li>
	 * 	<li>Set PlaceAppraisalOrderEx Method POST URL</li>
	 * 	<li>Initialize the HTTP post</li>
	 * 	<li>Request parameters and other properties.</li>
	 * 	<li>Execute and get the response.</li>
	 * 	<li>Convert XML File to single line String</li>
	 * 	<li>Verify the XML is the same</li>
	 * 	<li>Parse out the TrackingID</li>
	 * 	<li>Parse out the TrackingNumber</li>
	 * 	<li>Parse out the Fee</li>
	 * 	<li>Parse out the DueDate</li>
	 * 	<li>Log tracking numbers</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (groups={"Integrations", "API - PlaceAppraisalOrderEx"}, dependsOnMethods="getVMPOrderFormFields")
	public void placeAppraisalOrderEx() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		String os = StoredVariables.getos().get();
		
		// Set path to the XML file
	    String xmlFilePath = null;
	    if (os.equals("Windows")) {
	    	xmlFilePath = perform.filepathForAPIXMLFiles(driver)+"PlaceAppraisalOrderEx\\"+file2;
	    } else if (os.equals("Mac")) {
	    	xmlFilePath = perform.filepathForAPIXMLFiles(driver)+"PlaceAppraisalOrderEx/"+file2;
	    } // end if/else
		
		// Generate a random loan number
		String loanNumber = perform.randomNumbers(driver, 14);
		
		// Update LENDERCASENUMBER in XML File
		perform.changeTagElementInXML(driver, "LENDERCASENUMBER", loanNumber, xmlFilePath);
		
        // Reading XML as String using jCabi library
        XML xml = new XMLDocument(new File(xmlFilePath));
        String xmlString = xml.toString();
        
		// Set PlaceAppraisalOrderEx Method POST URL
		String url = StoredVariables.getapiURL().get()+"mercuryapi.asmx/PlaceAppraisalOrderEx";

		// Initialize the HTTP post
		HttpClient httpclient = HttpClients.createDefault();
		HttpPost httppost = new HttpPost(url);

		// Request parameters and other properties.
		List<NameValuePair> params = new ArrayList<NameValuePair>(2);
		params.add(new BasicNameValuePair("SessionKey", sessionKey));
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
		System.out.println("\n\nbody = " + body);
		
	    // Convert XML File to single line String
	    String fileXML = null;
	    if (os.equals("Windows")) {
	    	fileXML = perform.stringBuilderFromFileTrimmed(driver, perform.filepathForAPIXMLFiles(driver)+"PlaceAppraisalOrderEx\\SuccessfulACK2.xml");
	    } else if (os.equals("Mac")) {
	    	fileXML = perform.stringBuilderFromFileTrimmed(driver, perform.filepathForAPIXMLFiles(driver)+"PlaceAppraisalOrderEx/SuccessfulACK2.xml");
	    } // end if/else

		// Verify the XML is the same
		Assert.assertTrue(body.contains("<?xml version=\"1.0\" encoding=\"utf-8\"?><OrderResponse xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"http://alamode.com/\"><bResult>true</bResult><iError>0</iError><szError /><TrackingID>"), "XML file is incorrect. Response = " + body + "\nFile = " + fileXML);
	    Assert.assertTrue(body.contains("</TrackingID><TrackingNumber>MERC-"), "XML file is incorrect. Response = " + body + "\nFile = " + fileXML);
	    Assert.assertTrue(body.contains("</TrackingNumber><Fee>459</Fee><DueDate>5/30/2017</DueDate></OrderResponse>"), "XML file is incorrect. Response = " + body + "\nFile = " + fileXML);
		
		// Parse out the TrackingID
		String tag = "TrackingID";
		trackingID = perform.getTagFromHTTPResponseAsString(driver, tag, body);
		System.out.println(tag + " = " + trackingID);

		// Parse out the TrackingNumber
		tag = "TrackingNumber";
		trackingNumber = perform.getTagFromHTTPResponseAsString(driver, tag, body);
		System.out.println(tag + " = " + trackingNumber);
		
		// Parse out the Fee
		tag = "Fee";
		fee = perform.getTagFromHTTPResponseAsString(driver, tag, body);
		System.out.println(tag + " = " + fee);
		
		// Parse out the DueDate
		tag = "DueDate";
		dueDate = perform.getTagFromHTTPResponseAsString(driver, tag, body);
		System.out.println(tag + " = " + dueDate);
	    
		// Log tracking numbers
		test.log(LogStatus.INFO, "Order Numbers", "TrackingID: " + trackingID + "<br>TrackingNumber: " + trackingNumber);
		
		// Log test
		test.log(LogStatus.INFO, "Integration", "Placed an order through the API");
		
	} // end placeAppraisalOrderEx
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>View the XSite order</li>
	 * 	<li>Convert XML File to single line String</li>
	 * 	<li>Parse XML File to get values</li>
	 * 	<li>Formatting several dates so that the XML values match the values from the Business Management.</li>
	 * 	<li>Verify values in Business Management match the XML File</li>
	 * 	<li>Checking to see if the XML document says it's a rush order, if so checking the relevant data field in Business Management.</li>
	 * 	<li>Get the documents text</li>
	 * 	<li>Verify that the documents were uploaded as a Document Upload event</li>
	 * 	<li>Verify there is 1 Sales Contract and 3 Other documents</li>
	 * 	<li>Close XSite order</li>
	 * 	<li>Switch back to original window</li>
	 * 	<li>Log test</li>
	 * </ul>
	 * @throws Exception the exception
	 */
	@Test (groups={"Integrations", "XSite - Order Details"}, dependsOnMethods="placeAppraisalOrderEx")
	public void viewBusinessManagement() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		String os = StoredVariables.getos().get();
		
		// View the XSite order
		String orderNumber = trackingNumber.replace("MERC-", "");
		secure.viewXSiteOrderFromSecure(driver, lenderUser, password, orderNumber);
		
	    // Convert XML File to single line String
	    String fileXML = null;
	    if (os.equals("Windows")) {
	    	fileXML = perform.stringBuilderFromFileTrimmed(driver, perform.filepathForAPIXMLFiles(driver)+"PlaceAppraisalOrderEx\\"+file2);
	    } else if (os.equals("Mac")) {
	    	fileXML = perform.stringBuilderFromFileTrimmed(driver, perform.filepathForAPIXMLFiles(driver)+"PlaceAppraisalOrderEx/"+file2);
	    } // end if/else
	    
	    // Parse XML File to get values
		String fhaCaseNumber = perform.getTagFromHTTPResponseAsString(driver, "FHA_CASENUMBER", fileXML);
		String loanType = perform.getTagFromHTTPResponseAsString(driver, "LOAN_TYPE", fileXML);
		String loanPurpose = perform.getTagFromHTTPResponseAsString(driver, "LOAN_PURPOSE", fileXML);
		String lenderCaseNumber = perform.getTagFromHTTPResponseAsString(driver, "LENDERCASENUMBER", fileXML);
		String clientFileNo = perform.getTagFromHTTPResponseAsString(driver, "CLIENT_FILE_NO", fileXML);
		String subLenClient = perform.getTagFromHTTPResponseAsString(driver, "SUBLENCLIENT", fileXML);
		String lenderAddress1 = perform.getTagFromHTTPResponseAsString(driver, "LENDERADDRESS1", fileXML);
		String lenderAddress2 = perform.getTagFromHTTPResponseAsString(driver, "LENDERADDRESS2", fileXML);
		String lenderCity = perform.getTagFromHTTPResponseAsString(driver, "LENDERCITY", fileXML);
		String lenderState = perform.getTagFromHTTPResponseAsString(driver, "LENDERSTATE", fileXML);
		String lenderZip = perform.getTagFromHTTPResponseAsString(driver, "LENDERZIP", fileXML);
		String subBorrower = perform.getTagFromHTTPResponseAsString(driver, "SUBBORROWER", fileXML);
		String borrowerContactType1 = perform.getTagFromHTTPResponseAsString(driver, "BORROWERCONTACTTYPE1", fileXML);
		String borrowerContact1 = perform.getTagFromHTTPResponseAsString(driver, "BORROWERCONTACT1", fileXML);
		String borrowerContactType2 = perform.getTagFromHTTPResponseAsString(driver, "BORROWERCONTACTTYPE2", fileXML);
		String borrowerContact2 = perform.getTagFromHTTPResponseAsString(driver, "BORROWERCONTACT2", fileXML);
		String coBorrower = perform.getTagFromHTTPResponseAsString(driver, "COBORROWER", fileXML);
		String coBorrowerContactType1 = perform.getTagFromHTTPResponseAsString(driver, "COBORROWERCONTACTTYPE1", fileXML);
		String coBorrowerContact1 = perform.getTagFromHTTPResponseAsString(driver, "COBORROWERCONTACT1", fileXML);
		String coBorrowerContactType2 = perform.getTagFromHTTPResponseAsString(driver, "COBORROWERCONTACTTYPE2", fileXML);
		String coBorrowerContact2 = perform.getTagFromHTTPResponseAsString(driver, "COBORROWERCONTACT2", fileXML);
		String subAgent = perform.getTagFromHTTPResponseAsString(driver, "SUBAGENT", fileXML);
		String agentContactType1 = perform.getTagFromHTTPResponseAsString(driver, "AGENTCONTACTTYPE1", fileXML);
		String agentContact1 = perform.getTagFromHTTPResponseAsString(driver, "AGENTCONTACT1", fileXML);
		String agentContactType2 = perform.getTagFromHTTPResponseAsString(driver, "AGENTCONTACTTYPE2", fileXML);
		String agentContact2 = perform.getTagFromHTTPResponseAsString(driver, "AGENTCONTACT2", fileXML);
		String subOther = perform.getTagFromHTTPResponseAsString(driver, "SUBOTHER", fileXML);
		String otherContactType1 = perform.getTagFromHTTPResponseAsString(driver, "OTHERCONTACTTYPE1", fileXML);
		String otherContact1 = perform.getTagFromHTTPResponseAsString(driver, "OTHERCONTACT1", fileXML);
		String otherContactType2 = perform.getTagFromHTTPResponseAsString(driver, "OTHERCONTACTTYPE2", fileXML);
		String otherContact2 = perform.getTagFromHTTPResponseAsString(driver, "OTHERCONTACT2", fileXML);
		String subOccupant = perform.getTagFromHTTPResponseAsString(driver, "SUBOCCUPANT", fileXML);
		String occupantContactType1 = perform.getTagFromHTTPResponseAsString(driver, "OCCUPANTCONTACTTYPE1", fileXML);
		String occupantContact1 = perform.getTagFromHTTPResponseAsString(driver, "OCCUPANTCONTACT1", fileXML);
		String occupantContactType2 = perform.getTagFromHTTPResponseAsString(driver, "OCCUPANTCONTACTTYPE2", fileXML);
		String occupantContact2 = perform.getTagFromHTTPResponseAsString(driver, "OCCUPANTCONTACT2", fileXML);
		String subCurOwner = perform.getTagFromHTTPResponseAsString(driver, "SUBCUROWNER", fileXML);
		String ownerContactType1 = perform.getTagFromHTTPResponseAsString(driver, "OWNERCONTACTTYPE1", fileXML);
		String ownerContact1 = perform.getTagFromHTTPResponseAsString(driver, "OWNERCONTACT1", fileXML);
		String ownerContactType2 = perform.getTagFromHTTPResponseAsString(driver, "OWNERCONTACTTYPE2", fileXML);
		String ownerContact2 = perform.getTagFromHTTPResponseAsString(driver, "OWNERCONTACT2", fileXML);
		String subSalePrice = perform.getTagFromHTTPResponseAsString(driver, "SUBSALEPRICE", fileXML);
		String loanAmount = perform.getTagFromHTTPResponseAsString(driver, "LOAN_AMOUNT", fileXML);
		String subPropAddress = perform.getTagFromHTTPResponseAsString(driver, "SUBPROPADDRESS", fileXML);
		String subCity = perform.getTagFromHTTPResponseAsString(driver, "SUBCITY", fileXML);
		String subState = perform.getTagFromHTTPResponseAsString(driver, "SUBSTATE", fileXML);
		String subZip = perform.getTagFromHTTPResponseAsString(driver, "SUBZIP", fileXML);
		String subCounty = perform.getTagFromHTTPResponseAsString(driver, "SUBCOUNTY", fileXML);
		String subLegalDescrip = perform.getTagFromHTTPResponseAsString(driver, "SUBLEGALDESCRIP", fileXML);
		String gdsType = perform.getTagFromHTTPResponseAsString(driver, "GDSTYPE", fileXML);
		String typeOfAppraisal = perform.getTagFromHTTPResponseAsString(driver, "TYPE_OF_APPRAISAL", fileXML);
		String dueDate = perform.getTagFromHTTPResponseAsString(driver, "DUE_DATE", fileXML);
		String disclosureDate = perform.getTagFromHTTPResponseAsString(driver, "DISCLOSURE_DATE", fileXML);
		String fee = perform.getTagFromHTTPResponseAsString(driver, "FEE", fileXML);
		String requestDate = perform.getTagFromHTTPResponseAsString(driver, "REQUEST_DATE", fileXML);
		String requestNotes = perform.getTagFromHTTPResponseAsString(driver, "REQUEST_NOTES", fileXML);
		String prelimValue = perform.getTagFromHTTPResponseAsString(driver, "PRELIM_VALUE", fileXML);
		String otherFileNumber = perform.getTagFromHTTPResponseAsString(driver, "OTHERFILENUMBER", fileXML);
		String orderNo = perform.getTagFromHTTPResponseAsString(driver, "ORDER_NO", fileXML);
		String clientRevisedNotes = perform.getTagFromHTTPResponseAsString(driver, "CLIENTREVISED_NOTES", fileXML);
		String whoOrderedPer = perform.getTagFromHTTPResponseAsString(driver, "WHO_ORDERED_PER", fileXML);
		String rightsAppraised = perform.getTagFromHTTPResponseAsString(driver, "RIGHTSAPPRAISED", fileXML);
		String occupantType = perform.getTagFromHTTPResponseAsString(driver, "OCCUPANTTYPE", fileXML);
		String rushOrder = perform.getTagFromHTTPResponseAsString(driver, "RUSH_ORDER", fileXML);
//		String additionalNotificationRecipients = perform.getTagFromHTTPResponseAsString(driver, "ADDITIONAL_NOTIFICATION_RECIPIENTS", fileXML);
//		String apptContact = perform.getTagFromHTTPResponseAsString(driver, "APPT_CONTACT", fileXML);
		
		//Formatting several dates so that the XML values match the values from the Business Management.
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat newFormat = new SimpleDateFormat("M/d/yyyy");
		Date dueDatePreFormat = (Date)formatter.parse(dueDate);
		String dueDateFormatted = newFormat.format(dueDatePreFormat);
		Date disclosureDatePreFormat = (Date)formatter.parse(disclosureDate);
		String disclosureDateFormatted = newFormat.format(disclosureDatePreFormat);
		Date requestDatePreFormat = (Date)formatter.parse(requestDate);
		String requestDateFormatted = newFormat.format(requestDatePreFormat);		
		
		// Verify values in Business Management match the XML File
		Assert.assertTrue(XOrders.loanType_txt(driver).getText().equalsIgnoreCase(loanType), "Loan Type is incorrect. Loan Type = " + loanType + "   On-screen value = " + XOrders.loanType_txt(driver).getText());
		Assert.assertTrue(XOrders.loanPurpose_txt(driver).getText().equalsIgnoreCase(loanPurpose), "Loan Purpose is incorrect. Loan Purpose = " + loanPurpose + "   On-screen value = " + XOrders.loanPurpose_txt(driver).getText());
		Assert.assertTrue(XOrders.lenderCaseNumber_txt(driver).getText().equalsIgnoreCase(lenderCaseNumber), "Lender Case number is incorrect. Lender Case Number = " + lenderCaseNumber + "   On-screen value = " + XOrders.lenderCaseNumber_txt(driver).getText());
		Assert.assertTrue(XOrders.fhaNumber_txt(driver).getText().equalsIgnoreCase(fhaCaseNumber), "FHA Case number is incorrect. FHA Case Number = " + fhaCaseNumber + "   On-screen value = " + XOrders.fhaNumber_txt(driver).getText());
		Assert.assertTrue(XOrders.clientFileNumber_txt(driver).getText().equalsIgnoreCase(clientFileNo), "Client File Number is incorrect. Client File Number = " + clientFileNo + "   On-screen value = " + XOrders.clientFileNumber_txt(driver).getText());
		Assert.assertTrue(XOrders.subLenClient_txt(driver).getText().equalsIgnoreCase(subLenClient), "Sub Lender Client is incorrect. Sub Lender Client = " + subLenClient + "   On-screen value = " + XOrders.subLenClient_txt(driver).getText());
		Assert.assertTrue(XOrders.lenderAddress_txt(driver).getText().contains(lenderAddress1), "Lender Address is incorrect. Lender Address = " + lenderAddress1 + "   On-screen value = " + XOrders.lenderAddress_txt(driver).getText());
		Assert.assertTrue(!XOrders.lenderAddress_txt(driver).getText().contains(lenderAddress2), "Lender Address 2 is incorrect. Lender Address 2 = " + lenderAddress2 + "   On-screen value = " + XOrders.lenderAddress_txt(driver).getText());
		Assert.assertTrue(XOrders.lenderAddress_txt(driver).getText().contains(lenderCity), "Lender City is incorrect. Lender City = " + lenderCity + "   On-screen value = " + XOrders.lenderAddress_txt(driver).getText());
		Assert.assertTrue(XOrders.lenderAddress_txt(driver).getText().contains(lenderState), "Lender State is incorrect. Lender State = " + lenderState + "   On-screen value = " + XOrders.lenderAddress_txt(driver).getText());
		Assert.assertTrue(XOrders.lenderAddress_txt(driver).getText().contains(lenderZip), "Lender Zip is incorrect. Lender Zip = " + lenderZip + "   On-screen value = " + XOrders.lenderAddress_txt(driver).getText());
		Assert.assertTrue(XOrders.subBorrower_txt(driver).getText().equalsIgnoreCase(subBorrower), "Borrower is incorrect. Borrower = " + subBorrower + "   On-screen value = " + XOrders.subBorrower_txt(driver).getText());
		Assert.assertTrue(XOrders.borrowerContactType2_txt(driver).getText().replace("-", "").replace(":", "").equalsIgnoreCase(borrowerContactType1), "Borrower Contact Type 1 is incorrect. Borrower Contact Type 1 = " + borrowerContactType1 + "   On-screen value = " + XOrders.borrowerContactType2_txt(driver).getText());
		Assert.assertTrue(XOrders.borrowerContact2_txt(driver).getText().equalsIgnoreCase(borrowerContact1), "Borrower Contact 1 is incorrect. Borrower Contact 1 = " + borrowerContact1 + "   On-screen value = " + XOrders.borrowerContact2_txt(driver).getText());
		Assert.assertTrue(XOrders.borrowerContactType1_txt(driver).getText().replace("-", "").replace(":", "").equalsIgnoreCase(borrowerContactType2), "Borrower Contact Type 2 is incorrect. Borrower Contact Type 2 = " + borrowerContactType2 + "   On-screen value = " + XOrders.borrowerContactType1_txt(driver).getText());
		Assert.assertTrue(XOrders.borrowerContact1_txt(driver).getText().equalsIgnoreCase(borrowerContact2), "Borrower Contact 2 is incorrect. Borrower Contact 2 = " + borrowerContact2 + "   On-screen value = " + XOrders.borrowerContact1_txt(driver).getText());		
		Assert.assertTrue(XOrders.coBorrower_txt(driver).getText().equalsIgnoreCase(coBorrower), "Co-Borrower is incorrect. Co-Borrower = " + coBorrower + "   On-screen value = " + XOrders.coBorrower_txt(driver).getText());
		Assert.assertTrue(XOrders.coBorrowerContactType2_txt(driver).getText().replace("-", "").replace(":", "").equalsIgnoreCase(coBorrowerContactType1), "Co-Borrower Contact Type 1 is incorrect. Co-Borrower Contact Type 1 = " + coBorrowerContactType1 + "   On-screen value = " + XOrders.coBorrowerContactType2_txt(driver).getText());
		Assert.assertTrue(XOrders.coBorrowerContact2_txt(driver).getText().equalsIgnoreCase(coBorrowerContact1), "Co-Borrower Contact 1 is incorrect. Co-Borrower Contact 1 = " + coBorrowerContact1 + "   On-screen value = " + XOrders.coBorrowerContact2_txt(driver).getText());
		Assert.assertTrue(XOrders.coBorrowerContactType1_txt(driver).getText().replace("-", "").replace(":", "").equalsIgnoreCase(coBorrowerContactType2), "Co-Borrower Contact Type 2 is incorrect. Co-Borrower Contact Type 2 = " + coBorrowerContactType2 + "   On-screen value = " + XOrders.coBorrowerContactType1_txt(driver).getText());
		Assert.assertTrue(XOrders.coBorrowerContact1_txt(driver).getText().equalsIgnoreCase(coBorrowerContact2), "Co-Borrower Contact 2 is incorrect. Co-Borrower Contact 2 = " + coBorrowerContact2 + "   On-screen value = " + XOrders.coBorrowerContact1_txt(driver).getText());		
		Assert.assertTrue(XOrders.subAgent_txt(driver).getText().equalsIgnoreCase(subAgent), "Agent is incorrect. Agent = " + subAgent + "   On-screen value = " + XOrders.subAgent_txt(driver).getText());
		Assert.assertTrue(XOrders.agentContactType2_txt(driver).getText().replace("-", "").replace(":", "").equalsIgnoreCase(agentContactType1), "Agent Contact Type 1 is incorrect. Agent Contact Type 1 = " + agentContactType1 + "   On-screen value = " + XOrders.agentContactType2_txt(driver).getText());
		Assert.assertTrue(XOrders.agentContact2_txt(driver).getText().equalsIgnoreCase(agentContact1), "Agent Contact 1 is incorrect. Agent Contact 1 = " + agentContact1 + "   On-screen value = " + XOrders.agentContact2_txt(driver).getText());
		Assert.assertTrue(XOrders.agentContactType1_txt(driver).getText().replace("-", "").replace(":", "").equalsIgnoreCase(agentContactType2), "Agent Contact Type 2 is incorrect. Agent Contact Type 2 = " + agentContactType2 + "   On-screen value = " + XOrders.agentContactType1_txt(driver).getText());
		Assert.assertTrue(XOrders.agentContact1_txt(driver).getText().equalsIgnoreCase(agentContact2), "Agent Contact 2 is incorrect. Agent Contact 2 = " + agentContact2 + "   On-screen value = " + XOrders.agentContact1_txt(driver).getText());
		Assert.assertTrue(XOrders.subOther_txt(driver).getText().equalsIgnoreCase(subOther), "Other is incorrect. Other = " + subOther+ "   On-screen value = " + XOrders.subOther_txt(driver).getText());
		Assert.assertTrue(XOrders.otherContactType2_txt(driver).getText().replace("-", "").replace(":", "").equalsIgnoreCase(otherContactType1), "Other Contact Type 1 is incorrect. Other Contact Type 1 = " + otherContactType1 + "   On-screen value = " + XOrders.otherContactType2_txt(driver).getText());
		Assert.assertTrue(XOrders.otherContact2_txt(driver).getText().equalsIgnoreCase(otherContact1), "Other Contact 1 is incorrect. Other Contact 1 = " + otherContact1 + "   On-screen value = " + XOrders.otherContact2_txt(driver).getText());
		Assert.assertTrue(XOrders.otherContactType1_txt(driver).getText().replace("-", "").replace(":", "").equalsIgnoreCase(otherContactType2), "Other Contact Type 2 is incorrect. Other Contact Type 2 = " + otherContactType2 + "   On-screen value = " + XOrders.otherContactType1_txt(driver).getText());
		Assert.assertTrue(XOrders.otherContact1_txt(driver).getText().equalsIgnoreCase(otherContact2), "Other Contact 2 is incorrect. Other Contact 2 = " + otherContact2 + "   On-screen value = " + XOrders.otherContact1_txt(driver).getText());		
		Assert.assertTrue(XOrders.subOccupant_txt(driver).getText().equalsIgnoreCase(subOccupant), "Occupant is incorrect. Occupant = " + subOccupant + "   On-screen value = " + XOrders.subOccupant_txt(driver).getText());
		Assert.assertTrue(XOrders.occupantContactType2_txt(driver).getText().replace("-", "").replace(":", "").equalsIgnoreCase(occupantContactType1), "Occupant Contact Type 1 is incorrect. Occupant Contact Type 1 = " + occupantContactType1 + "   On-screen value = " + XOrders.occupantContactType2_txt(driver).getText());
		Assert.assertTrue(XOrders.occupantContact2_txt(driver).getText().equalsIgnoreCase(occupantContact1), "Occupant Contact 1 is incorrect. Occupant Contact 1 = " + occupantContact1 + "   On-screen value = " + XOrders.occupantContact2_txt(driver).getText());
		Assert.assertTrue(XOrders.occupantContactType1_txt(driver).getText().replace("-", "").replace(":", "").equalsIgnoreCase(occupantContactType2), "Occupant Contact Type 2 is incorrect. Occupant Contact Type 2 = " + occupantContactType2 + "   On-screen value = " + XOrders.occupantContactType1_txt(driver).getText());
		Assert.assertTrue(XOrders.occupantContact1_txt(driver).getText().equalsIgnoreCase(occupantContact2), "Occupant Contact 2 is incorrect. Occupant Contact 2 = " + occupantContact2 + "   On-screen value = " + XOrders.occupantContact1_txt(driver).getText());		
		Assert.assertTrue(XOrders.subCurOwner_txt(driver).getText().equalsIgnoreCase(subCurOwner), "Owner is incorrect. Owner = " + subCurOwner + "   On-screen value = " + XOrders.subCurOwner_txt(driver).getText());
		Assert.assertTrue(XOrders.ownerContactType2_txt(driver).getText().replace("-", "").replace(":", "").equalsIgnoreCase(ownerContactType1), "Owner Contact Type 1 is incorrect. Owner Contact Type 1 = " + ownerContactType1 + "   On-screen value = " + XOrders.ownerContactType2_txt(driver).getText());
		Assert.assertTrue(XOrders.ownerContact2_txt(driver).getText().equalsIgnoreCase(ownerContact1), "Owner Contact 1 is incorrect. Owner Contact 1 = " + ownerContact1 + "   On-screen value = " + XOrders.ownerContact2_txt(driver).getText());
		Assert.assertTrue(XOrders.ownerContactType1_txt(driver).getText().replace("-", "").replace(":", "").equalsIgnoreCase(ownerContactType2), "Owner Contact Type 2 is incorrect. Owner Contact Type 2 = " + ownerContactType2 + "   On-screen value = " + XOrders.ownerContactType1_txt(driver).getText());
		Assert.assertTrue(XOrders.ownerContact1_txt(driver).getText().equalsIgnoreCase(ownerContact2), "Owner Contact 2 is incorrect. Owner Contact 2 = " + ownerContact2 + "   On-screen value = " + XOrders.ownerContact1_txt(driver).getText());		
		Assert.assertTrue(XOrders.subSalePrice_txt(driver).getText().replace("$", "").replace(",", "").equalsIgnoreCase(subSalePrice), "Sale Price is incorrect. Sale Price = " + subSalePrice + "   On-screen value = " + XOrders.subSalePrice_txt(driver).getText());
		Assert.assertTrue(XOrders.loanAmount_txt(driver).getText().replace("$", "").replace(",", "").equalsIgnoreCase(loanAmount), "Loan Amount is incorrect. Loan Amount = " + loanAmount + "   On-screen value = " + XOrders.loanAmount_txt(driver).getText());
		Assert.assertTrue(XOrders.subPropAddress_txt(driver).getText().equalsIgnoreCase(subPropAddress), "Property Address is incorrect. Property Address = " + subPropAddress+ "   On-screen value = " + XOrders.subPropAddress_txt(driver).getText());
		Assert.assertTrue(XOrders.subCity_txt(driver).getText().equalsIgnoreCase(subCity), "City is incorrect. City = " + subCity + "   On-screen value = " + XOrders.subCity_txt(driver).getText());
		Assert.assertTrue(XOrders.subState_txt(driver).getText().equalsIgnoreCase(subState), "State is incorrect. State = " + subState + "   On-screen value = " + XOrders.subState_txt(driver).getText());
		Assert.assertTrue(XOrders.subZip_txt(driver).getText().equalsIgnoreCase(subZip), "Zip is incorrect. Zip = " + subZip + "   On-screen value = " + XOrders.subZip_txt(driver).getText());
		Assert.assertTrue(XOrders.subCounty_txt(driver).getText().equalsIgnoreCase(subCounty), "County is incorrect. County = " + subCounty + "   On-screen value = " + XOrders.subCounty_txt(driver).getText());
		Assert.assertTrue(XOrders.subLegalDescrip_txt(driver).getText().equalsIgnoreCase(subLegalDescrip), "Legal Description is incorrect. Legal Description = " + subLegalDescrip + "   On-screen value = " + XOrders.subLegalDescrip_txt(driver).getText());
		Assert.assertTrue(XOrders.gdsType_txt(driver).getText().replace(" ", "").equalsIgnoreCase(gdsType), "GDS Type is incorrect. GDS Type = " + gdsType + "   On-screen value = " + XOrders.gdsType_txt(driver).getText());
		Assert.assertTrue(XOrders.typeOfAppraisal_txt(driver).getText().equalsIgnoreCase(typeOfAppraisal), "Type of Appraisal is incorrect. Type of Appraisal = " + typeOfAppraisal + "   On-screen value = " + XOrders.typeOfAppraisal_txt(driver).getText());
		Assert.assertTrue(XOrders.dueDate_txt(driver).getText().replace(" (Rush)", "").equalsIgnoreCase(dueDateFormatted), "Due Date is incorrect. Due Date = " + dueDateFormatted + "   On-screen value = " + XOrders.dueDate_txt(driver).getText());
		Assert.assertTrue(XOrders.disclosureDate_txt(driver).getText().equalsIgnoreCase(disclosureDateFormatted), "Disclosure Date is incorrect. Disclosure Date = " + disclosureDateFormatted + "   On-screen value = " + XOrders.disclosureDate_txt(driver).getText());
		Assert.assertTrue(XOrders.fee_txt(driver).getText().equalsIgnoreCase(fee), "Fee is incorrect. Fee = " + fee + "   On-screen value = " + XOrders.fee_txt(driver).getText());
		Assert.assertTrue(XOrders.requestDate_txt(driver).getText().equalsIgnoreCase(requestDateFormatted), "Request Date is incorrect. Request Date = " + requestDateFormatted + "   On-screen value = " + XOrders.requestDate_txt(driver).getText());
		Assert.assertTrue(XOrders.requestNotes_txt(driver).getText().contains(requestNotes), "Request Notes are incorrect. Request Notes = " + requestNotes + "   On-screen value = " + XOrders.requestNotes_txt(driver).getText());
		Assert.assertTrue(XOrders.prelimValue_txt(driver).getText().replace("$", "").replace(",", "").equalsIgnoreCase(prelimValue), "Preliminary Value is incorrect. Preliminary Value = " + prelimValue + "   On-screen value = " + XOrders.prelimValue_txt(driver).getText());
		Assert.assertTrue(XOrders.otherFileNumber_txt(driver).getText().equalsIgnoreCase(otherFileNumber), "Other File Number is incorrect. Other File Number = " + otherFileNumber + "   On-screen value = " + XOrders.otherFileNumber_txt(driver).getText());
		Assert.assertTrue(XOrders.orderNo_txt(driver).getText().equalsIgnoreCase(orderNo), "Order Number is incorrect. Order Number = " + orderNo + "   On-screen value = " + XOrders.orderNo_txt(driver).getText());
		Assert.assertTrue(XOrders.whoOrderedPer_txt(driver).getText().equalsIgnoreCase(whoOrderedPer), "Ordered By is incorrect. Ordered By = " + whoOrderedPer + "   On-screen value = " + XOrders.whoOrderedPer_txt(driver).getText());
		Assert.assertTrue(XOrders.apptContact_txt(driver).getText().equalsIgnoreCase(coBorrower), "Appointment Contact is incorrect. Appointment Contact = " + coBorrower + "   On-screen value = " + XOrders.apptContact_txt(driver).getText());
		Assert.assertTrue(XOrders.rightsAppraised_txt(driver).getText().equalsIgnoreCase(rightsAppraised), "Rights Appraised is incorrect. Rights Appraised = " + rightsAppraised + "   On-screen value = " + XOrders.rightsAppraised_txt(driver).getText());
		Assert.assertTrue(XOrders.occupancy_txt(driver).getText().equalsIgnoreCase(occupantType), "Occupant Type is incorrect. Occupant Type = " + occupantType + "   On-screen value = " + XOrders.occupancy_txt(driver).getText());	
		Assert.assertTrue(XOrders.requestNotes_txt(driver).getText().contains(clientRevisedNotes), "Client Revised Notes are incorrect. Client Revised Notes = " + clientRevisedNotes + "   On-screen value = " + XOrders.requestNotes_txt(driver).getText());
		
		//Checking to see if the XML document says it's a rush order, if so checking the relevant data field in Business Management.
		if(rushOrder.equals("True"))
		{
			Assert.assertTrue(XOrders.dueDate_txt(driver).getText().contains("Rush"), "Rush is incorrect. Rush = " + rushOrder + "   On-screen value = " + XOrders.dueDate_txt(driver).getText());
		}
		
		// Get the documents text
		String document1 = driver.findElement(By.cssSelector("#PB_trFiles > td > div > div:nth-child(1)")).getText();
		String document2 = driver.findElement(By.cssSelector("#PB_trFiles > td > div > div:nth-child(2)")).getText();
		String document3 = driver.findElement(By.cssSelector("#PB_trFiles > td > div > div:nth-child(3)")).getText();
		String document4 = driver.findElement(By.cssSelector("#PB_trFiles > td > div > div:nth-child(4)")).getText();
		
		// Verify that the documents were uploaded as a Document Upload event
		Assert.assertTrue(document1.contains("Uploaded Document"), "The document did not upload properly. It should have uploaded as a Document Upload event");
		Assert.assertTrue(document2.contains("Uploaded Document"), "The document did not upload properly. It should have uploaded as a Document Upload event");
		Assert.assertTrue(document3.contains("Uploaded Document"), "The document did not upload properly. It should have uploaded as a Document Upload event");
		Assert.assertTrue(document4.contains("Uploaded Document"), "The document did not upload properly. It should have uploaded as a Document Upload event");
		
		// Verify there is 1 Sales Contract and 3 Other documents
		int salesContractDocuments = 0;
		int otherDocuments = 0;
		
		// document1
		if (document1.contains("Sales Contract"))
		{
			salesContractDocuments++;
		}
		else if (document1.contains("Other"))
		{
			otherDocuments++;
		} // end document1
		
		// document2
		if (document2.contains("Sales Contract"))
		{
			salesContractDocuments++;
		}
		else if (document2.contains("Other"))
		{
			otherDocuments++;
		} // end document2
		
		// document3
		if (document3.contains("Sales Contract"))
		{
			salesContractDocuments++;
		}
		else if (document3.contains("Other"))
		{
			otherDocuments++;
		} // end document3
		
		// document4
		if (document4.contains("Sales Contract"))
		{
			salesContractDocuments++;
		}
		else if (document4.contains("Other"))
		{
			otherDocuments++;
		} // end document4
		
		Assert.assertTrue(salesContractDocuments==1, "The should be 1 Sales Contract document uploaed.");
		Assert.assertTrue(otherDocuments==3, "The should be 3 Other documents uploaed.");
		
		// Close XSite order
		perform.closeNewWindow(driver);
		
		// Switch back to original window
		driver.switchTo().defaultContent();
		
		// Log test
		test.log(LogStatus.INFO, "Integration", "Verified the data sent via the placeAppraisalOrderEx method matches what is in Business Management and that the documents got attached properly");
		
	} // end viewBusinessManagement
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Change order to AMC</li>
	 * 	<li>Click Assign</li>
	 * 	<li>Assign the order to AutomationIntQATestingAMC</li>
	 * 	<li>Enter a fee</li>
	 * 	<li>Click Finish</li>
	 * 	<li>Verify the order was automatically accepted by the AMC</li>
	 * 	<li>Log test</li>
	 * </ul>
	 * @throws Exception the exception
	 */
	@Test (groups={"Integrations", "Secure - Orders", "Secure - Asign Order To AMC"}, dependsOnMethods="viewBusinessManagement")
	public void assignOrderToAMC() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Login to Secure
		secure.login(driver, lenderUser, password);
		
		// Find the order
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Open the order
		secure.openOrder(driver, trackingNumber);
		
		// Change order to AMC
		perform.click(driver,SOrderDetails.amcFirm_radiobtn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);

		// Click Assign
		perform.click(driver,SOrderDetails.assign_btn(driver));
		
		// Assign the order to AutomationIntQATestingAMC
		secure.selectVendor(driver, amc);
		
		// Enter a fee
		perform.type(driver, SConfirmOrder.orderFee_txtbx(driver), "500");
		
		// Click Finish
		perform.click(driver,SConfirmOrder.finishTop_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);

		// Wait for the history
		perform.waitForElementToBeClickable(driver, SOrderDetails.history_txt(driver));
		
		// Verify the order was automatically accepted by the AMC
		String history = SOrderDetails.history_txt(driver).getText();
		Assert.assertTrue(history.contains("Order accepted by AMC ("+amc+") and In Progress"), "The order was not automatically accepted. History: " + history);
		
		// Log test
		test.log(LogStatus.INFO, "Integration", "Assigned the order to an AMC");
		
	} // end assignOrderToAMC
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Get the AMC Tracking Number</li>
	 * 	<li>Click Assign</li>
	 * 	<li>Assign the order to AutomationIntQATestingAppraiser</li>
	 * 	<li>Click Finish</li>
	 * 	<li>Verify the order was automatically accepted by the AMC</li>
	 * 	<li>Log test</li>
	 * </ul>
	 * @throws Exception the exception
	 */
	@Test (groups={"Integrations", "Secure - Orders"}, dependsOnMethods="assignOrderToAMC")
	public void assignOrderToAppraiserAsAMC() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Login to Secure
		secure.login(driver, amcUser, password);
		
		// Find the order
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Open the order
		secure.openOrder(driver, trackingNumber);
		
		// Get the AMC Tracking Number
		amcTrackingNumber = SOrderDetails.trackingNumber_txt(driver).getText().replace("Tracking #", "");
		
		// Click Assign
		perform.click(driver,SOrderDetails.assign_btn(driver));
		
		// Assign the order to AutomationIntQATestingAppraiser
		secure.selectVendor(driver, vendor);
		
		// Click Finish
		perform.click(driver,SConfirmOrder.finishTop_btn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);

		// Wait for the history
		perform.waitForElementToBeClickable(driver, SOrderDetails.history_txt(), "id");
		
		// Verify the order was automatically accepted by the AMC
		String history = SOrderDetails.history_txt(driver).getText();
		Assert.assertTrue(history.contains("Awaiting acceptance by "+vendor+""), "The order was not assigned to "+vendor+". History: " + history);
		
		// Log test
		test.log(LogStatus.INFO, "Integration", "Assigned the order to an appraiser as the AMC");
		
	} // end assignOrderToAppraiserAsAMC
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Vendors</li>
	 * 	<li>Accept the order</li>
	 * 	<li>Set Inspection Scheduled</li>
	 * 	<li>Set Message status</li>
	 * 	<li>Log test</li>
	 * </ul>
	 * @throws Exception the exception
	 */
	@Test (groups={"Integrations", "Vendors - Accept Order", "Vendors - Accept Order", "Vendors - Inspection Scheduled", "Vendors - Send Message"}, dependsOnMethods="assignOrderToAppraiserAsAMC")
	public void acceptOrderAsAppraiser() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		db.checkForUnpaidInvoices(driver);

		// Login to Vendors
		vendors.login(driver, vendorUser, password);
		
		// Accept the order
		vendors.acceptOrder(driver, amcTrackingNumber);
		
		// Set Inspection Scheduled
		vendors.inspectionScheduled(driver, 1, "These are Inspection Scheduled notes");
		
		// Set Message status
		vendors.sendMessage(driver, "These are test message notes");
		
		// Log test
		test.log(LogStatus.INFO, "Integration", "Accepted the order, set Inspection Scheduled and sent a message");
		
	} // end acceptOrderAsAppraiser
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Get the History text</li>
	 * 	<li>Verify the Inspection Scheduled and Message synced</li>
	 * 	<li>Open the XSite</li>
	 * 	<li>Verify the Inspection Scheduled and Message synced to the XSite</li>
	 * 	<li>Get the History text</li>
	 * 	<li>Verify the Inspection Scheduled and Message synced</li>
	 * 	<li>Close the XSite window</li>
	 * 	<li>Log test</li>
	 * </ul>
	 * @throws Exception the exception
	 */
	@Test (groups={"Integrations", "Secure - Orders", "XSite - Order Details"}, dependsOnMethods="acceptOrderAsAppraiser")
	public void verifyStatusSync() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Login to Secure
		secure.login(driver, amcUser, password);
		
		// Find the order
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Open the order
		secure.openOrder(driver, trackingNumber);
		
		// Get the History text
		String history = SOrderDetails.history_txt(driver).getText();
		
		// Verify the Inspection Scheduled and Message synced
		String expected1 = "Message from Appraiser ("+vendor+")";
		String expected2 = "These are test message notes";
		String expected3 = "Inspection Scheduled by Appraiser ("+vendor+")";
		String expected4 = "These are Inspection Scheduled notes";
		String[] expected = {expected1, expected2, expected3, expected4};
		perform.verifyTextContains(driver, history, expected);
		
		// Open the XSite
		secure.openXSiteOrder(driver);
		
		// Verify the Inspection Scheduled and Message synced to the XSite
		// Get the History text
		history = XOrders.history_txt(driver).getText();
		
		// Verify the Inspection Scheduled and Message synced
		expected1 = "Message ("+amcName+")";
		expected2 = "These are test message notes";
		expected3 = "Inspection Scheduled ("+amcName+")";
		expected4 = "These are Inspection Scheduled notes";
		expected = new String[] {expected1, expected2, expected3, expected4};
		perform.verifyTextContains(driver, history, expected);
		
		// Close the XSite window
		perform.closeNewWindow(driver);
		
		// Log test
		test.log(LogStatus.INFO, "Integration", "Verify the Insepection Scheduled and Message sync to the AMC and XSite orders");
		
	} // end verifyStatusSync
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get OS</li>
	 * 	<li>Update TrackingID's in XML Files</li>
	 * 	<li>Convert xml file to a string</li>
	 * 	<li>URL Encode the xml string</li>
	 * 	<li>Set UpdateAppraisalStatusEx Method POST URL</li>
	 * 	<li>Call UpdateAppraisalStatusEx method and get the response</li>
	 * 	<li>Convert Response XML to single line String</li>
	 * 	<li>Verify the response is correct</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TransformerException the transformer exception
	 */
	@Test (groups={"Integrations", "API - UpdateAppraisalStatusEx"}, dependsOnMethods="verifyStatusSync")
	public void updateAppraisalStatusEx() throws IOException, TransformerException {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Get OS
		String os = StoredVariables.getos().get();
		
		// Update TrackingID's in XML Files
		String file = null;
		String file2 = null;
		if (os.equals("Windows")) {
			file = StoredVariables.getapiXMLFilesDir().get()+"UpdateAppraisalStatusEx\\TestMessage2.xml";
			file2 = StoredVariables.getapiXMLFilesDir().get()+"UpdateAppraisalStatusEx\\UpdateAppraisalStatusExSuccessfulACK2.xml";
		} else if (os.equals("Mac")) {
			file = StoredVariables.getapiXMLFilesDir().get()+"UpdateAppraisalStatusEx/TestMessage2.xml";
			file2 = StoredVariables.getapiXMLFilesDir().get()+"UpdateAppraisalStatusEx/UpdateAppraisalStatusExSuccessfulACK2.xml";
		} // end if/else
		perform.changeTagElementInXML(driver, "TRACKINGID",trackingID, file);
		perform.changeTagElementInXML(driver, "TrackingID",trackingID, file2);
		
		// Convert xml file to a string
		String xml = perform.stringBuilder(driver, file);
		System.out.println("Document to be uploaded = " + file);
		
		// URL Encode the xml string
		xml = URLEncoder.encode(xml, "UTF-8");
		
		// Set UpdateAppraisalStatusEx Method POST URL
		String url = StoredVariables.getapiURL().get()+"mercuryapi.asmx/UpdateAppraisalStatusEx";
		String urlParameters = "SessionKey="+sessionKey+"&XMLPost="+xml+"&IPAddress=127.0.0.1";

		// Call UpdateAppraisalStatusEx method and get the response
		String[] response = perform.httpPost(driver, url, urlParameters);
		String body = response[2];
		
	    // Convert Response XML to single line String
	    String xml1 = body.trim();
	    String responseXML = perform.stringBuilderFromStringTrimmed(driver, xml1);
		
		// Verify the response is correct
	    String expected = "<?xml version=\"1.0\" encoding=\"utf-8\"?><OrderResponse xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"http://alamode.com/\"><bResult>true</bResult><iError>0</iError><TrackingID>"+trackingID+"</TrackingID><Fee>0</Fee></OrderResponse>";
		Assert.assertTrue(responseXML.contains(expected), "XML response is incorrect. Response = " + responseXML + "\nFile = " + expected);
		
		// Log test
		test.log(LogStatus.INFO, "Integration", "Verified the correct XML was retruned when calling UpdateAppraisalStatusEx");
		
	} // end updateAppraisalStatusEx
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to VMP Client Portal</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Verify the Message status shows</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ClassNotFoundException the ClassNotFoundExceptionthe class not found exception
	 * @throws SQLException the SQLExceptionthe SQL exception
	 */
	@Test (groups={"Integrations", "Vendors - Orders"}, dependsOnMethods="updateAppraisalStatusEx")
	public void verifyMessageStatusOnVMPOrder() throws InterruptedException, IOException, ClassNotFoundException, SQLException {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Login to VMP Client Portal
		String URL = "https://automationintegrationqatestinglender.vmpclientqa.com";
		String user = "AutomationIntQATestingClient1";
		if (StoredVariables.getusernameEnvironment().get().equals("Live")) {
			URL = "https://automationinttestinglender.vmpclient.com";
			user = "AutomationIntTestingClient1";
		} // end if
		vmp.login(driver, URL, user, password);
		
		// Find the order
		vmp.findOrder(driver, trackingNumber, "Tracking #");
		
		// Open the order
		vmp.openOrder(driver, trackingNumber);
		
		// Verify the Message status shows
		String history = VMPOrderDetails.history_txt(driver).getText();
		Assert.assertTrue(history.contains("Message by "+client+""), "The Message status does not show on the VMP order");
		Assert.assertTrue(history.contains("Message to appraiser."), "The Message status does not show on the VMP order");
		Assert.assertTrue(history.contains("Message by "+lender+""), "The Message status does not show on the VMP order");
		Assert.assertTrue(history.contains("These are test message notes"), "The Message status does not show on the VMP order");
		Assert.assertTrue(history.contains("Inspection Scheduled by "+lender+""), "The Message status does not show on the VMP order");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes"), "The Message status does not show on the VMP order");
		
		// Log test
		test.log(LogStatus.INFO, "Integration", "Verified the Message status shows on the VMP order and followed the set sync setting to Mercury Network");
		
	} // end verifyMessageStatusOnVMPOrder
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Verify the Revision Needed status synced to Secure</li>
	 * 	<li>Log test</li>
	 * </ul>
	 * @throws Exception the exception
	 */
	@Test (groups={"Integrations", "Secure - Orders"}, dependsOnMethods="verifyMessageStatusOnVMPOrder")
	public void verifyMessageStatusOnSecure() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Login to Secure
		secure.login(driver, lenderUser, password);
		
		// Find the order
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Open the order
		secure.openOrder(driver, trackingNumber);
		
		// Verify the Revision Needed status synced to Secure
		String history = SOrderDetails.history_txt(driver).getText();
		Assert.assertTrue(history.contains("Message from Client ("+lender+")"), "The Message status does not show on the Secure order");
		Assert.assertTrue(history.contains("Message to appraiser."), "The Message status does not show on the Secure order");
		Assert.assertTrue(history.contains("Message from AMC ("+amc+")"), "The Message status does not show on the Secure order");
		Assert.assertTrue(history.contains("These are test message notes"), "The Message status does not show on the Secure order");
		Assert.assertTrue(history.contains("Inspection Scheduled by AMC ("+amc+")"), "The Inspection Scheduled status does not show on the Secure order");
		Assert.assertTrue(history.contains("These are Inspection Scheduled notes"), "The Inspection Scheduled status does not show on the Secure order");
		
		// Log test
		test.log(LogStatus.INFO, "Integration", "Verified the Message status message synced to the Secure order");
		
	} // end verifyMessageStatusOnSecure
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Place on Hold</li>
	 * 	<li>Log test</li>
	 * </ul>
	 * @throws Exception the exception
	 */
	@Test (groups={"Integrations", "Secure - Orders", "Secure - Place On Hold"}, dependsOnMethods="verifyMessageStatusOnSecure")
	public void placeOrderOnHold() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Login to Secure
		secure.login(driver, amcUser, password);
		
		// Find the order
		secure.findOrder(driver, amcTrackingNumber, "Tracking number");
		
		// Open the order
		secure.openOrder(driver, amcTrackingNumber);
		
		// Place on Hold
		secure.placeOnHold(driver, "These are Place On Hold notes", true);
		
		// Log test
		test.log(LogStatus.INFO, "Integration", "Placed the order on hold and synced the status to the XSite order");
		
	} // end placeOrderOnHold
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set GetOrderStatusHistoryClient Method POST URL</li>
	 * 	<li>Call GetOrderStatusHistoryClient Method and get the response</li>
	 * 	<li>Convert Response to single line String</li>
	 * 	<li>Verify the XML returned contains the On Hold and Message statuses</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TransformerException the transformer exception
	 */
	@Test (groups={"Integrations", "API - GetOrderStatusHistoryClient"}, dependsOnMethods="placeOrderOnHold")
	public void getOrderStatusHistoryClient() throws IOException, TransformerException {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Set GetOrderStatusHistoryClient Method POST URL
		String url = StoredVariables.getapiURL().get()+"mercuryapi.asmx/GetOrderStatusHistoryClient";
		String urlParameters = "SessionKey="+sessionKey+"&TrackingID="+trackingID+"&IPAddress=127.0.0.1";
		
		// Call GetOrderStatusHistoryClient Method and get the response
		String[] response = perform.httpPost(driver, url, urlParameters);
		String body = response[2];
		
	    // Convert Response to single line String 
	    String responseText = perform.stringBuilderFromStringTrimmed(driver, body);
	    System.out.println("responseText = " + responseText);
		
		// Verify the XML returned contains the On Hold and Message statuses
	    Assert.assertTrue(responseText.contains("<StatusName>Inspection Scheduled</StatusName>"), "The history returned in the XML is missing the Inspection Scheduled status");
	    Assert.assertTrue(responseText.contains("<Message>Set by vendor ("+lender+")Inspection date is"), "The history returned in the XML is missing the Inspection Scheduled status");
	    Assert.assertTrue(responseText.contains("These are Inspection Scheduled notes</Message>"), "The history returned in the XML is missing the Inspection Scheduled status");
	    Assert.assertTrue(responseText.contains("<StatusName>Message</StatusName>"), "The history returned in the XML is missing the Message status");
	    Assert.assertTrue(responseText.contains("<Message>Set by vendor ("+lender+")These are test message notes</Message>"), "The history returned in the XML is missing the Message status");
	    Assert.assertTrue(responseText.contains("<Message>Set by client ("+client+")Message to appraiser.</Message>"), "The history returned in the XML is missing the Message status");
	    Assert.assertTrue(responseText.contains("<StatusName>On Hold</StatusName>"), "The history returned in the XML is missing the On Hold status");
	    Assert.assertTrue(responseText.contains("<Message>Set by vendor ("+lender+")These are Place On Hold notes</Message>"), "The history returned in the XML is missing the On Hold status");
		
		// Log test
		test.log(LogStatus.INFO, "Integration", "Verified the correct statuses are in the XML file was retruned when calling getOrderStatusHistoryClient");
		
	} // end getOrderStatusHistoryClient
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set GetOrderStatusHistoryClient Method POST URL</li>
	 * 	<li>Call GetOrderStatusHistoryClient Method and get the response</li>
	 * 	<li>Convert Response to single line String</li>
	 * 	<li>Verify the XML returned contains the On Hold and Message statuses</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TransformerException the transformer exception
	 */
	@Test (groups={"Integrations", "API - GetCurrentStatusXSiteClientEx"}, dependsOnMethods="getOrderStatusHistoryClient")
	public void getCurrentStatusXSiteClientEx() throws IOException, TransformerException {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Set GetCurrentStatusXSiteClientEx Method POST URL
		String url = StoredVariables.getapiURL().get()+"mercuryapi.asmx/GetCurrentStatusXSiteClientEx";
		String urlParameters = "SessionKey="+sessionKey+"&ProductItemID="+trackingID+"&IPAddress=127.0.0.1";
		
		// Call GetCurrentStatusXSiteClientEx Method and get the response
		String[] response = perform.httpPost(driver, url, urlParameters);
		String body = response[2];
		
	    // Convert Response to single line String 
	    String responseText = perform.stringBuilderFromStringTrimmed(driver, body);
	    System.out.println("responseText = " + responseText);
		
		// Verify the XML returned contains the On Hold and Message statuses
	    Assert.assertTrue(responseText.contains("<?xml version=\"1.0\" encoding=\"utf-8\"?><CurrentStatusEx xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"http://alamode.com/\"><Success>true</Success><Message>Call to GetCurrentStatus successful</Message><ProductItemID>"+trackingID+"</ProductItemID><StatusID>201070</StatusID><StatusName>On Hold</StatusName><StatusComment>Set by vendor ("+lender+")These are Place On Hold notes</StatusComment><StatusTime>"), "The history returned in the XML is incorrect. Response = " + responseText);
		
		// Log test
		test.log(LogStatus.INFO, "Integration", "Verified the correct XML file was retruned when calling GetCurrentStatusXSiteClientEx");
		
	} // end getCurrentStatusXSiteClientEx
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Resume the order</li>
	 * 	<li>Log test</li>
	 * </ul>
	 * @throws Exception the exception
	 */
	@Test (groups={"Integrations", "Secure - Orders", "Secure - Resume Order"}, dependsOnMethods="getCurrentStatusXSiteClientEx")
	public void resumeOrder() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Login to Secure
		secure.login(driver, amcUser, password);
		
		// Find the order
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Open the order
		secure.openOrder(driver, trackingNumber);
		
		// Resume the order
		secure.resumeOrder(driver, 2, "These are resume notes", true);
		
		// Log test
		test.log(LogStatus.INFO, "Integration", "Resumed the order on hold and synced the status to the XSite order");
		
	} // end resumeOrder
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Vendors</li>
	 * 	<li>Open the order</li>
	 * 	<li>Click Attach Documents</li>
	 * 	<li>Select Invoice</li>
	 * 	<li>Upload an Invoice</li>
	 * 	<li>Click Close Button</li>
	 * 	<li>Set Inspection Complete</li>
	 * 	<li>Get the LoanID of the 3rd order</li>
	 * 	<li>Complete the order</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (groups={"Integrations", "VMP - Orders", "Vendors - Upload Invoice", "Vendors - Inspection Complete", "Vendors - Complete Order"}, dependsOnMethods="resumeOrder")
	public void completeTheOrder() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Login to Vendors
		vendors.login(driver, vendorUser, password);

		// Open the order
		vendors.findAndOpenOrder(driver, trackingNumber);
		
		// Click Attach Documents
		perform.click(driver,VOrderDetails.attachDocuments_btn(driver));
		
		// Wait for the document type dropdown
		perform.waitForElementToBeClickable(driver, VOrderDetails.documentType_dropdown(), "id");
		
		// Select Invoice
		perform.selectDropdownOption(driver, VOrderDetails.documentType_dropdown(driver), "Invoice");
		
		Thread.sleep(2000);
		
		// Upload an Invoice
		String filePath = StoredVariables.getdocDir().get()+"Invoice2.pdf";
		vendors.uploadDocument(driver, filePath, trackingNumber, "Invoice");
		
		Thread.sleep(1000);
		
		// Click Close Button
		perform.click(driver,VOrderDetails.close_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Wait for text to be visible
		perform.waitForElementToBeVisible(driver, VOrderDetails.documents_txt(), "id");
		
		// Set Inspection Complete
		vendors.inspectionComplete(driver, 2, "These are Inspection Complete notes");
		
		// Get the LoanID of the 3rd order
		String sqlStatement = "SELECT LoanID FROM ProductItems WHERE ProductItemID = "
				+ "(SELECT AMCProductItemID FROM ULSOrders WHERE XSiteProductItemID = "
				+ "(SELECT ProductItemID FROM ProductItems WHERE LoanID = '"+trackingNumber.replace("MERC-", "")+"'))";
		secondLoanID = db.queryDB(driver, "Mercury", sqlStatement);
		
		// Complete the order
		String user = vendorUser;
		vendors.completeOrderByHTTPPost(driver, user, password, secondLoanID, "SampleCompletedforUCDP.xml");
		
		// Log test
		test.log(LogStatus.INFO, "Integration", "Accepted the order, set Inspection Scheduled and sent a message");
		
	} // end completeTheOrder
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Find and open the order</li>
	 * 	<li>Submit the order to UCDP</li>
	 * 	<li>Open XSite</li>
	 * 	<li>Get the History text</li>
	 * 	<li>Verify the UCDP messages synced</li>
	 * 	<li>Close the XSite window</li>
	 * 	<li>Log test</li>
	 * </ul>
	 * @throws Exception the exception
	 */
	@Test (groups={"Integrations", "Secure - Orders", "Secure - Submit To UCDP", "XSite - Order Details"}, dependsOnMethods="completeTheOrder")
	public void submitOrderToUCDP() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Login to Secure
		secure.login(driver, amcUser, password);
		
		// Find and open the order
		secure.findAndOpenOrder(driver, amcTrackingNumber);
		
		// Submit the order to UCDP
		secure.submitToUCDP(driver, "Fannie Mae and Freddie Mac", "", "", "Uploading to UCDP", true);
		
		// Wait for Successful Submission
		boolean ucdpSuccessful = secure.waitForHistoryTextToUpdate(driver, "Appraisal Submission Accepted");
		
		if (ucdpSuccessful==true) {
			// Open XSite
			secure.openXSiteOrder(driver);
			
			// Wait for UCDP to return results
			try {
				perform.waitForText(driver, XOrders.history_txt(driver), "Appraisal Submission Accepted by FNM and FRE via UCDP");
			} catch (Exception e) {
				perform.waitForText(driver, XOrders.history_txt(driver), "Appraisal Submission Accepted by FNM and FRE via UCDP");
			} // end try/catch
			
			// Get the History text
			String history = XOrders.history_txt(driver).getText();
			
			// Verify the UCDP messages synced
			String expected1 = "Appraisal Submission Accepted by FNM and FRE via UCDP";
			String expected2 = "Appraisal Submitted to FNM and FRE via UCDP";
			String expected3 = "UCDP Document File ID Updated";
			String[] expected = {expected1, expected2, expected3};
			perform.verifyTextContains(driver, history, expected);
			
			// Close the XSite window
			perform.closeNewWindow(driver);
		} // end if
		
		// Log test
		test.log(LogStatus.INFO, "Integration", "Submitted to UCDP and verified the DocFileID and Submission Accepted status synced to the XSite");
		
	} // end submitOrderToUCDP
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Click Accept this report radio button</li>
	 * 	<li>Click OK</li>
	 * 	<li>Log test</li>
	 * </ul>
	 * @throws Exception the exception
	 */
	@Test (groups={"Integrations", "Secure - Orders", "Secure - Accept Order"}, dependsOnMethods="submitOrderToUCDP")
	public void markOrderCompleteOnSecureAsAMC() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Login to Secure
		secure.login(driver, amcUser, password);
		
		// Find the order
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Open the order
		secure.openOrder(driver, trackingNumber);
		
		// Click Accept this report radio button
		perform.click(driver,SOrderDetails.acceptThisReportAsIs_radioBtn(driver));
		
		// Click OK
		perform.click(driver,SOrderDetails.okProcessReceivedReport_btn(driver));

		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Log test
		test.log(LogStatus.INFO, "Integration", "Marked the order complete on Secure");
		
	} // end markOrderCompleteOnSecureAsAMC
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Click Accept this report radio button</li>
	 * 	<li>Click OK</li>
	 * 	<li>Log test</li>
	 * </ul>
	 * @throws Exception the exception
	 */
	@Test (groups={"Integrations", "Secure - Orders", "Secure - Accept Order"}, dependsOnMethods="markOrderCompleteOnSecureAsAMC")
	public void markOrderCompleteOnSecureAsLender() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Login to Secure
		secure.login(driver, lenderUser, password);
		
		// Find the order
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Open the order
		secure.openOrder(driver, trackingNumber);
		
		// Click Accept this report radio button
		perform.click(driver,SOrderDetails.acceptThisReportAsIs_radioBtn(driver));
		
		// Click OK
		perform.click(driver,SOrderDetails.okProcessReceivedReport_btn(driver));

		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Log test
		test.log(LogStatus.INFO, "Integration", "Marked the order complete on Secure");
		
	} // end markOrderCompleteOnSecureAsLender
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set GetOrderStatusHistoryClient Method POST URL</li>
	 * 	<li>Call GetOrderStatusHistoryClient Method and get the response</li>
	 * 	<li>Convert Response to single line String</li>
	 * 	<li>Verify the XML returned contains the On Hold and Message statuses</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TransformerException the transformer exception
	 */
	@Test (groups={"Integrations", "API - GetCurrentStatusXSiteClientEx"}, dependsOnMethods="markOrderCompleteOnSecureAsLender")
	public void getCurrentStatusXSiteClientEx2() throws IOException, TransformerException {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Set GetCurrentStatusXSiteClientEx Method POST URL
		String url = StoredVariables.getapiURL().get()+"mercuryapi.asmx/GetCurrentStatusXSiteClientEx";
		String urlParameters = "SessionKey="+sessionKey+"&ProductItemID="+trackingID+"&IPAddress=127.0.0.1";
		
		// Call GetCurrentStatusXSiteClientEx Method and get the response
		String[] response = perform.httpPost(driver, url, urlParameters);
		String body = response[2];
		
	    // Convert Response to single line String 
	    String responseText = perform.stringBuilderFromStringTrimmed(driver, body);
		
		// Verify the XML returned contains the On Hold and Message statuses
	    Assert.assertTrue(responseText.contains("<?xml version=\"1.0\" encoding=\"utf-8\"?><CurrentStatusEx xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"http://alamode.com/\"><Success>true</Success><Message>Call to GetCurrentStatus successful</Message><ProductItemID>"+trackingID+"</ProductItemID><StatusID>301000</StatusID><StatusName>Completed</StatusName><StatusComment>Set by vendor ("+lender+")</StatusComment><StatusDocuments><StatusDocument><Type>XML</Type><FileName>MISMORpt.XML</FileName><Base64Document>"), "The XML in the response is incorrect. Response = " + responseText + "\nIt should contain = <?xml version=\"1.0\" encoding=\"utf-8\"?><CurrentStatusEx xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"http://alamode.com/\"><Success>true</Success><Message>Call to GetCurrentStatus successful</Message><ProductItemID>"+trackingID+"</ProductItemID><StatusID>301000</StatusID><StatusName>Completed</StatusName><StatusComment>Set by vendor ("+lender+")</StatusComment><StatusDocuments><StatusDocument><Type>XML</Type><FileName>Test PDF.xml</FileName><Base64Document>");
		
		// Log test
		test.log(LogStatus.INFO, "Integration", "Verified the correct XML file was retruned when calling GetCurrentStatusXSiteClientEx");
		
	} // end getCurrentStatusXSiteClientEx2
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set GetOrderStatusHistoryClient Method POST URL</li>
	 * 	<li>Call GetOrderStatusHistoryClient Method and get the response</li>
	 * 	<li>Convert Response to single line String</li>
	 * 	<li>Verify the XML returned contains the On Hold and Message statuses</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TransformerException the transformer exception
	 */
	@Test (groups={"Integrations", "API - GetOrderStatusHistoryClient"}, dependsOnMethods="getCurrentStatusXSiteClientEx2")
	public void getOrderStatusHistoryClient2() throws IOException, TransformerException {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Set GetOrderStatusHistoryClient Method POST URL
		String url = StoredVariables.getapiURL().get()+"mercuryapi.asmx/GetOrderStatusHistoryClient";
		String urlParameters = "SessionKey="+sessionKey+"&TrackingID="+trackingID+"&IPAddress=127.0.0.1";
		
		// Call GetOrderStatusHistoryClient Method and get the response
		String[] response = perform.httpPost(driver, url, urlParameters);
		String body = response[2];
		
	    // Convert Response to single line String 
	    String responseText = perform.stringBuilderFromStringTrimmed(driver, body);
	    
		// Verify the XML returned contains the On Hold and Message statuses
	    Assert.assertTrue(responseText.contains("<?xml version=\"1.0\" encoding=\"utf-8\"?><Order TrackingID=\""+trackingID+"\" TrackingNumber=\""+trackingNumber+"\" xmlns=\"\"><ErrorMessage /><StatusHistory><Status NUM=\"1\"><StatusUniqueID>"), "The response is incorrect. Response = " + responseText);
	    Assert.assertTrue(responseText.contains("</StatusUniqueID><StatusID>201000</StatusID><StatusName>In Progress</StatusName><Message>Set by client ("+client+")</Message><StatusTime>"), "The response is incorrect. Response = " + responseText);
	    Assert.assertTrue(responseText.contains("</StatusTime></Status><Status NUM=\"2\"><StatusUniqueID>"), "The response is incorrect. Response = " + responseText);
	    Assert.assertTrue(responseText.contains("</StatusUniqueID><StatusID>202000</StatusID><StatusName>Document Uploaded</StatusName><Message>Set by client ("+client+")</Message><StatusTime>"), "The response is incorrect. Response = " + responseText);
	    Assert.assertTrue(responseText.contains("</StatusTime><StatusDocument><DocumentDate>"), "The response is incorrect. Response = " + responseText);
	    Assert.assertTrue(responseText.contains("</DocumentDate><FileName>4215.pdf</FileName><Type>Sales Contract</Type><TypeID>1</TypeID><Description>Uploaded Document</Description><DocumentID>"), "The response is incorrect. Response = " + responseText);
	    Assert.assertTrue(responseText.contains("</StatusUniqueID><StatusID>202000</StatusID><StatusName>Document Uploaded</StatusName><Message>Set by client ("+client+")</Message><StatusTime>"), "The response is incorrect. Response = " + responseText);
	    Assert.assertTrue(responseText.contains("</DocumentDate><FileName>Apex_Shortcuts.pdf</FileName><Type>Other</Type><TypeID>5</TypeID><Description>Uploaded Document</Description><DocumentID>"), "The response is incorrect. Response = " + responseText);
	    Assert.assertTrue(responseText.contains("</StatusUniqueID><StatusID>202000</StatusID><StatusName>Document Uploaded</StatusName><Message>Set by client ("+client+")</Message><StatusTime>"), "The response is incorrect. Response = " + responseText);
	    Assert.assertTrue(responseText.contains("</DocumentDate><FileName>mercury.pdf</FileName><Type>Other</Type><TypeID>5</TypeID><Description>Uploaded Document</Description><DocumentID>"), "The response is incorrect. Response = " + responseText);
	    Assert.assertTrue(responseText.contains("</StatusUniqueID><StatusID>202000</StatusID><StatusName>Document Uploaded</StatusName><Message>Set by client ("+client+")</Message><StatusTime>"), "The response is incorrect. Response = " + responseText);
	    Assert.assertTrue(responseText.contains("</DocumentDate><FileName>CRAddend.pdf</FileName><Type>Other</Type><TypeID>5</TypeID><Description>Uploaded Document</Description><DocumentID>"), "The response is incorrect. Response = " + responseText);
	    Assert.assertTrue(responseText.contains("</StatusUniqueID><StatusID>101020</StatusID><StatusName>Vendor Accepted Assignment</StatusName><Message>Set by vendor ("+lender+")Order automatically accepted.</Message><StatusTime>"), "The response is incorrect. Response = " + responseText);
	    Assert.assertTrue(responseText.contains("</StatusTime><AssignedAMC>"+amc+"</AssignedAMC></Status><Status NUM=\"8\"><StatusUniqueID>"), "The response is incorrect. Response = " + responseText);
	    Assert.assertTrue(responseText.contains("</StatusUniqueID><StatusID>201040</StatusID><StatusName>Inspection Scheduled</StatusName><Message>Set by vendor ("+lender+")Inspection date is"), "The response is incorrect. Response = " + responseText);
	    Assert.assertTrue(responseText.contains("These are Inspection Scheduled notes</Message><StatusTime>"), "The response is incorrect. Response = " + responseText);
	    Assert.assertTrue(responseText.contains("</StatusUniqueID><StatusID>900000</StatusID><StatusName>Message</StatusName><Message>Set by vendor ("+lender+")These are test message notes</Message><StatusTime>"), "The response is incorrect. Response = " + responseText);
	    Assert.assertTrue(responseText.contains("</StatusUniqueID><StatusID>900000</StatusID><StatusName>Message</StatusName><Message>Set by client ("+client+")Message to appraiser.</Message><StatusTime>"), "The response is incorrect. Response = " + responseText);
	    Assert.assertTrue(responseText.contains("</StatusUniqueID><StatusID>201070</StatusID><StatusName>On Hold</StatusName><Message>Set by vendor ("+lender+")These are Place On Hold notes</Message><StatusTime>"), "The response is incorrect. Response = " + responseText);
	    Assert.assertTrue(responseText.contains("</StatusUniqueID><StatusID>900050</StatusID><StatusName>Vendor due date changed</StatusName><Message>Set by vendor ("+lender+")Vendor due date changed from"), "The response is incorrect. Response = " + responseText);
	    Assert.assertTrue(responseText.contains("Reason: These are resume notes</Message><StatusTime>"), "The response is incorrect. Response = " + responseText);
	    Assert.assertTrue(responseText.contains("</StatusUniqueID><StatusID>201090</StatusID><StatusName>Resumed</StatusName><Message>Set by vendor ("+lender+")These are resume notes</Message><StatusTime>"), "The response is incorrect. Response = " + responseText);
	    Assert.assertTrue(responseText.contains("</StatusUniqueID><StatusID>202000</StatusID><StatusName>Document Uploaded</StatusName><Message>Set by vendor ("+lender+")</Message><StatusTime>"), "The response is incorrect. Response = " + responseText);
	    Assert.assertTrue(responseText.contains("</DocumentDate><FileName>Invoice2.pdf</FileName><Type>Invoice</Type><TypeID>11</TypeID><Description>Invoice2</Description><DocumentID>"), "The response is incorrect. Response = " + responseText);
	    Assert.assertTrue(responseText.contains("</StatusUniqueID><StatusID>201050</StatusID><StatusName>Inspection Complete</StatusName><Message>Set by vendor ("+lender+")Inspected on"), "The response is incorrect. Response = " + responseText);
	    Assert.assertTrue(responseText.contains("These are Inspection Complete notes</Message><StatusTime>"), "The response is incorrect. Response = " + responseText);
	    Assert.assertTrue(responseText.contains("</StatusUniqueID><StatusID>301002</StatusID><StatusName>Pending Quality Review</StatusName><Message>Set by vendor ("+lender+")</Message><StatusTime>"), "The response is incorrect. Response = " + responseText);
	    Assert.assertTrue(responseText.contains("</StatusUniqueID><StatusID>301000</StatusID><StatusName>Completed</StatusName><Message>Set by vendor ("+lender+")</Message><StatusTime>"), "The response is incorrect. Response = " + responseText);
	    Assert.assertTrue(responseText.contains("</StatusTime></Status></StatusHistory></Order>"), "The response is incorrect. Response = " + responseText);
		
		// Log test
		test.log(LogStatus.INFO, "Integration", "Verified the Completed status is in the XML file was retruned when calling getOrderStatusHistoryClient");
		
	} // end getOrderStatusHistoryClient2
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set GetOrderStatusHistoryClient Method POST URL</li>
	 * 	<li>Call GetOrderStatusHistoryClient Method and get the response</li>
	 * 	<li>Convert Response to single line String</li>
	 * 	<li>Verify the XML returned contains the On Hold and Message statuses</li>
	 * 	<li>Get the Invoice DocumentID</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TransformerException the transformer exception
	 */
	@Test (groups={"Integrations", "API - GetOrderDocumentListEx"}, dependsOnMethods="getOrderStatusHistoryClient2")
	public void getOrderDocumentListEx() throws IOException, TransformerException {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Set GetOrderStatusHistoryClient Method POST URL
		String url = StoredVariables.getapiURL().get()+"mercuryapi.asmx/GetOrderDocumentListEx";
		String urlParameters = "SessionKey="+sessionKey+"&TrackingID="+trackingID+"&ExcludeClientDocs=False&IPAddress=127.0.0.1";
		
		// Call GetOrderStatusHistoryClient Method and get the response
		String[] response = perform.httpPost(driver, url, urlParameters);
		String body = response[2];
		
	    // Convert Response to single line String 
	    String responseText = perform.stringBuilderFromStringTrimmed(driver, body);
	    
		// Verify the XML returned contains the On Hold and Message statuses
	    Assert.assertTrue(responseText.contains("<?xml version=\"1.0\" encoding=\"utf-8\"?><Order TrackingID=\""+trackingID+"\" TrackingNumber=\""+trackingNumber+"\" xmlns=\"\"><ErrorMessage /><StatusDocuments><StatusDocument NUM=\"1\"><DocumentDate>"), "The document list returned is incorrect. Response = " + responseText);
	    Assert.assertTrue(responseText.contains("</DocumentDate><FileName>4215.pdf</FileName><Type>Sales Contract</Type><Description>Uploaded Document</Description><DocumentID>"), "The document list returned is incorrect. Response = " + responseText);
	    Assert.assertTrue(responseText.contains("</DocumentID><DocumentPlaceHolder /></StatusDocument><StatusDocument NUM=\"2\"><DocumentDate>"), "The document list returned is incorrect. Response = " + responseText);
	    Assert.assertTrue(responseText.contains("</DocumentDate><FileName>Apex_Shortcuts.pdf</FileName><Type>Other</Type><Description>Uploaded Document</Description><DocumentID>"), "The document list returned is incorrect. Response = " + responseText);
	    Assert.assertTrue(responseText.contains("</DocumentID><DocumentPlaceHolder /></StatusDocument><StatusDocument NUM=\"3\"><DocumentDate>"), "The document list returned is incorrect. Response = " + responseText);
	    Assert.assertTrue(responseText.contains("</DocumentDate><FileName>CRAddend.pdf</FileName><Type>Other</Type><Description>Uploaded Document</Description><DocumentID>"), "The document list returned is incorrect. Response = " + responseText);
	    Assert.assertTrue(responseText.contains("</DocumentID><DocumentPlaceHolder /></StatusDocument><StatusDocument NUM=\"4\"><DocumentDate>"), "The document list returned is incorrect. Response = " + responseText);
	    Assert.assertTrue(responseText.contains("</DocumentDate><FileName>mercury.pdf</FileName><Type>Other</Type><Description>Uploaded Document</Description><DocumentID>"), "The document list returned is incorrect. Response = " + responseText);
	    Assert.assertTrue(responseText.contains("</DocumentID><DocumentPlaceHolder /></StatusDocument><StatusDocument NUM=\"5\"><DocumentDate>"), "The document list returned is incorrect. Response = " + responseText);
	    Assert.assertTrue(responseText.contains("</DocumentDate><FileName>Invoice2.pdf</FileName><Type>Invoice</Type><Description>Invoice2</Description><DocumentID>"), "The document list returned is incorrect. Response = " + responseText);
	    Assert.assertTrue(responseText.contains("</DocumentID><DocumentPlaceHolder /></StatusDocument></StatusDocuments></Order>"), "The document list returned is incorrect. Response = " + responseText);
		
	    // Get the Invoice DocumentID
	    String xml = body;        
        Document doc = Jsoup.parse(xml);
        Elements StatusDocuments = doc.select("StatusDocument");
        for(Element e : StatusDocuments){
            if(e.select("Description").text().equals("Invoice2")){
            	documentID = e.select("DocumentID").text();
                System.out.println("documentID = " + e.select("DocumentID").text());
            } // end if
        } // end for loop
		
		// Log test
		test.log(LogStatus.INFO, "Integration", "Verified the correct document list in the XML file was retruned when calling getOrderDocumentListEx");
		
	} // end getOrderDocumentListEx
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set GetOrderStatusHistoryClient Method POST URL</li>
	 * 	<li>Call GetOrderStatusHistoryClient Method and get the response</li>
	 * 	<li>Convert Response to single line String</li>
	 * 	<li>Verify the XML returned contains the On Hold and Message statuses</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TransformerException the transformer exception
	 */
	@Test (groups={"Integrations", "API - GetOrderDocumentEx"}, dependsOnMethods="getOrderDocumentListEx")
	public void getOrderDocumentEx() throws IOException, TransformerException {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		System.out.println("SessionKey: " + sessionKey);
		System.out.println("DocumentID: " + documentID);
		
		// Set GetOrderDocumentEx Method POST URL
		String url = StoredVariables.getapiURL().get()+"mercuryapi.asmx/GetOrderDocumentEx";
		String urlParameters = "SessionKey="+sessionKey+"&DocumentID="+documentID+"&DocumentType=Invoice&IPAddress=127.0.0.1";
		
		// Call GetOrderDocumentEx Method and get the response
		String[] response = perform.httpPost(driver, url, urlParameters);
		String body = response[2];
		
	    // Convert Response to single line String 
	    String responseText = perform.stringBuilderFromStringTrimmed(driver, body);
		
		// Verify the XML returned contains the On Hold and Message statuses
	    Assert.assertTrue(responseText.contains("<?xml version=\"1.0\" encoding=\"utf-8\"?><StatusDocument DocumentID=\""+documentID+"\" xmlns=\"\"><ErrorMessage /><DocumentDate>"), "The Invoice was not returned correctly after calling GetOrderDocumentEx. Response = " + responseText);
	    Assert.assertTrue(responseText.contains("</DocumentDate><FileName>Invoice2.pdf</FileName><Type>Invoice</Type><Description>Invoice2</Description><Base64Document>"), "The Invoice was not returned correctly after calling GetOrderDocumentEx. Response = " + responseText);
	    Assert.assertTrue(responseText.contains("</Base64Document><DocumentPlaceHolder /></StatusDocument>"), "The Invoice was not returned correctly after calling GetOrderDocumentEx. Response = " + responseText);
	    Assert.assertTrue(responseText.contains("JVBERi0xLjQKJcfsj6IKNSAwIG9iago8PC9MZW5ndGggNiAwIFIvRmlsdGVyIC9GbGF0ZURlY29kZT4+CnN0cmVhbQp4nJWS3UvDMBTF2da1msncOj/f7mMqNCZp1iavggjiiyNv06eJA6HC5v8P9mOS2F4Qk5cf4d5zT06yA86EBF7vH9iU5HZVwPaLNMewejjAfkt2RLOsXs2Bz5sS7mzVaMAwk4N9J5wZo3nRigqQWkIhJJNgS0IHw1EwGodRYj9IKqVmSkHadr6RNT"
	    		+ "1KUsF4primxwdUigYOXz4dT/5TMXLoKYctZoXwa08cDj3hveMpOvq0J9wxEbUoTeEreG2zJOeSLTPzah+JqHKpUnsi9mZNBy6Zuasfo5bi3sSOpQh1518wcMHEfxaHaF4R6m2Bv9TMJXOGCi/QvM7Rggvcpic8703uCE/Rtl/PIzPF1FJCmnPNRPOB6WV8FU6u6899b8lztb8BAsOfY2VuZHN0cmVhbQplbmRvYmoKNiAwIG9iagoyOTYKZW5kb2JqCjQgMCBvYmoKPDwvVHlwZS9QYWdlL01lZGlhQm94IFswIDA"
	    		+ "gNjEyIDc5Ml0KL1JvdGF0ZSAwL1BhcmVudCAzIDAgUgovUmVzb3VyY2VzPDwvUHJvY1NldFsvUERGIC9UZXh0XQovRXh0R1N0YXRlIDEwIDAgUgovRm9udCAxMSAwIFIKPj4KL0NvbnRlbnRzIDUgMCBSCj4+CmVuZG9iagozIDAgb2JqCjw8IC9UeXBlIC9QYWdlcyAvS2lkcyBbCjQgMCBSCl0gL0NvdW50IDEKL1JvdGF0ZSAwPj4KZW5kb2JqCjEgMCBvYmoKPDwvVHlwZSAvQ2F0YWxvZyAvUGFnZXMgMyAwI"
	    		+ "FIKPj4KZW5kb2JqCjcgMCBvYmoKPDwvVHlwZS9FeHRHU3RhdGUKL09QTSAxPj5lbmRvYmoKMTAgMCBvYmoKPDwvUjcKNyAwIFI+PgplbmRvYmoKMTEgMCBvYmoKPDwvUjkKOSAwIFI+PgplbmRvYmoKMTIgMCBvYmoKPDwvTGVuZ3RoMSA2MjQ0L0ZpbHRlci9GbGF0ZURlY29kZS9MZW5ndGggMTMgMCBSPj5zdHJlYW0KeJztWHt0VNW5//Z5zTM5+5x5h8SZSQhQE5qQyZBAQnKUJGB4JAQSiTIIIpEUKYNAysMlA"
	    		+ "aU3QgVaByy4WmNtpYqRV1c10nUv2om1NCoCYbVlymM11C67coHbq6nCnNxvn0lEVmsff/WP6/lm73P2PnP2/vbv933f/s4BAgBp0A481NfNLSgC43D/BaumJSsWR1NtF57JQ0va1gSmnpm1DTsSWP63Jfrgiq/OOcHjvZPYznrwofUtqf/zxTgot2zp4gfe3XzgUwBvPnZOXIYdtoXiN/H/V7E9etmKNetS//fUY/Wzh1YuWZxq01IAsXTF4nVRoYwMAnBO7Ax8ffGKpcP6sfl90ZWr16TaXju7H314adTdV/sg/h/nBx"
	    		+ "1g6BKWD7CcE3kxW6gQmsS3xQEpT6rS1+oLoAdOQQy6pXo4ODR8iG/DeamK3Dn0Tx7wBDw3fHUCBsVi6IKX4Rj8GF4XcsFHnofzUASDnB/2kChshCXcC1y//mvoIOPIHdj7I5gML0AX1wo/gTx8doHeDY/ATFgJj0I3/Af0wwHYxO2TqmCQjBM6uc1Qy/2W53HkO8g4GIQO+DEn6fW4gnegFXbDusN+OT8nsG1bdf38YHBUdVXz+PwZDfOrq0YFg83jGVTIt1SvI97CacTlF6KN9dxyENbDPQPr4DaoBhE4oOCGPXjnNK6S"
	    		+ "B6LVZFgf8N8zM8dfac7xy+k5/jR7jt9mLfBbpTS/KOT6ea7AbzGX+wkU+E1SgX/J/ffIkXsvygvXXZTX3TtPnqV2ylPU10hAK5PL1aty2eSL8lzV4Z9Dff4q2ik/7Dol308XyffRi/J8PDfheR6WCiyT6U/kEjwXhdjzshyiW2QXth1YFPoa0bRRskq/L1NV9cuZ0cxoVnuW4JdWSs9KfBHpJkNgnjF3/iFyiOxo3voku2zPal69muT99QF/oy8PceAYZPwpESswAQSVoJKLFQHuVPLrXEPyFRGugya0I5akD/+eRK548Gs2"
	    		+ "jczGZ2aDW2jPoGzqqW3NZ71JqExmTChkw5A+NIxxaCDIQTdyFBMHwALFmqdRJAIvSiaigiDZLCbKCcC5rcYg1WyQRDlNJqCyMllOj588HplQGAoHFTGcqwRd3WS7vparJ9tjwqbmDd2f7o/h6F04eq7Igw3KNb9ZUEXJgmODyWaxsLGR80NwHE4i/167Mcs0NksknvAmaSKOGsfxl5olGA66sHZ1kWZ9P79O30+aY/y5WOxGbgwXjzYMwlZjJgfcqeWKwsT06vRm2krX0+3UZFetVgKqSiQ0TEUGuw2tzfk5cOI0kWTrUtRJB"
	    		+ "ckJhZGQEizyuF1OIZjjI6GAUjwmj/ST5y7c96b+C31g10ay6+lDcZEfN+/qiT/oPm4j8ba14Hp9qEW3yPiaq1VKnMrjfCBSMSDWi+3iLrFTPCSeFC+KVipq2BUd7jyOnRYR8Q6gT3KdOBDHmelZmoisStIzkVVMs7jBnQECOqND6MSyMha7/m3G4t6hS8IknFeFAs1TIzaJnAUkUZWJjZo5SlWiuh3GamsMfAfYYpOVcSTQEVKc7lDRxLCCFyYpmM0pe3s27/ruN1+etF7/8NoHIn/jo95XX32fl5Kea60XiBn546BjaED4vt"
	    		+ "AEfhgHTVoJ76TOcXLAWSoXOjXnBnmbvFe2mmuzszk1TVUtPvW2sSrHt4rrRS7TTS0QGK3I4rSv0Laz3vhA4ng8mYhA5cCZGyn8237nRcVypZzsMeHi0WUkXDwmJ9sUnhgqcrsMZUs8eI9XcgIu1uKnHj2y+w2S//GGlrYDr5567b0Dt0925KlLQt9pKNOXL2va/Niel7a8+G5k9f2LXpzxw1/qk+6fZm0LEDdRz9UtQuyeH/pAqMO1uCCkjUpTzRYH6uqmY2gxfZwKtkL8C1VEr/umFwwkIvEIAzBpqBkAhQKaiwvVlAyVSo"
	    		+ "S6g6/o/fo7pICkv3zwjY4jv/rNf+08mlOOfkeJjeQX/6j64s97LkxllrsJ5w9LeZAOXrhD+4qPZHqrbLyXgN2uqBYLOuAUnk/Hx7zVzkYn51RAohIn+ejZyEAkUV5uUIk/ajhkMIzYcGGqhoo8SClv6ERRJT6668xrfTd6D27o6dn2+Jadl/c/1XuZ3PYxSSezYlzrJ338V2P97+mbTzKdnkSdahETBXWareXtUYiqpk1L48xuxEdGfHLTJqZVpzWmbXC2WyTVkQZ2xZGGKPluWhkaWRzpTAGFF20FXuZZKcCKIVSkKq6gGi"
	    		+ "wqIcEwRS2F2ncO6H/UT5PghUt9yUw3WffsfyZHcfaP2p7KqyIBYk+SGv1/9N9X6jtnku5MMuYlpulGfYEwUbgbPW80ahreQ4hPysyopnyWmm5RzDlTzByveuWZQnVgvtAYWOpe7ZYcVJRoRkABsFEbZ8tFJHsHEvH48WRKWUQTkYw4Stzo+SU38Qyji0jMR4jyGdVnXIe/S8otj/zp9XP6r57d1106a6P+6T5ybuuOzbseXXVQ3/3CDDI+fomMukpEMm33IzeeOd3X8BifSw7suXjiwBtoXD/FmJGN/CswTctdLTwmcFQTFk"
	    		+ "nEnl4uWazAWai1FgSFUngPIyUPXvWmJUYwELclWGyPMwvI+HXG2ywoI/GuiaGAj+Qohu8oP+3p+JCEe+oisR9Iebqjt1//dtLHHd60vC85maGIcZp3ow4i7gNjNJepVJqEwcsMnFRqESnHQoyVno/0Js8YUZIZvhGMFD4ccnGlLPCfH+Rfil1/UyweHIRU5B8eMUujOJYdOGMgirNJGNh6jYFGhuHq9QjXKj4d+6QPn40gIm1GdGnV7oraiaPMah1VJlqIWfYAlz5ZlkmBXClvknfKggxm92TZQwo8mzycB3g/rocEoBA0qI"
	    		+ "coppy7oBM3GYw5yPIqhCvxWY2gxSsrB3BLS2GGkBV5QqkwMwJc6iyZlEjXptVP3W5a9q2WBV0Zoxeu6MoYe/vqPKGit7+/f/cLNy7zjmbtSnIqdyU644mWZPUIr7gKynhdwz/Oc7LGLxKJOa1cZG5tppZa4OlNXpXP8xr/27x+Ia1Mk8+TykEr+nArzm8DD2ja+AZTg40L2yer1fZaNcI1CJKqSha7CrxFAZnILoXyhXw938kLvJfFlkTEiCwMHBIRs1mQCxWxeizuFsXDDsC1XtGvEPW/rxBFv3JlR2fnDiw+DHtIFinQ39"
	    		+ "f/og/q78fOv9Vz/nzPW+eZrR3V1xp6sXhXq+U5+BlpGOIYu4pq4yH9LnOts9l8j1MwKyudxAlpvIwYERiOLSN2zzhk/jriro4UgaqLcjnZY33E2NQwrpiO9uw8020Evie2GmFPXyv+EsH6/ccYTY7Ekp9y+2KX3yXtJzGPwoxeaDI4m6plP8xvHebMYjf0Q18sMOMJFWImPkzY1BFHTERYalQ5kBjhKzhsU0pOOGVEpLhnT7J5VSx/9KoDEcaYT+992tr6aHIKDncM+fLj3JgDaHdw9rQs1Z6VVWu5x7LUt9a3zbLVZ/V5M9"
	    		+ "1mi2SzuaVMwZ/uwAjHq36+QyIjd5TMCgncFTZv0FCtyojD8VQgnsTKSDT2TPqsZ0JhSdgAq7iA4IbLFB7eyfzkNuJyYvw7dnn/uu8dOz14oXfviZ8/99Dmpz7p+IZ+9lj+kSWLa+8rr64/EftBQWfZ7DvnhO4u3Pq1fa/iarbgamaLMtpehRaQcWEFQqUgyCbVbq60Si7cQtJBtFNqMYle701ie8sZkHFjS8PLz/IAFiUw1LDsx+n2GFvs7Ni2a6/o14j8Frmk+z1jqrZsXE8yuq5x9tiHH8aSZyI1GeMzUZNDqEmmUIGcTtf"
	    		+ "GfosnKS/k0At5ajYTymM48ct18kGZl630PRMx3eKJ6Aer2B5b/jlHJMgobmOYGabyEUXI7On4k97bM3sh88Trb+LOGuU+SNa1Lz/LvYU6VLAsG3WQYIU2vYqfxz/AR/l2XiwTarh7hfWwXtgOW6XdnFmgoihxFN+OeJYFCsSMKaQUNa5BEkTCEscovmeaiQkTxLMRRmVBJIFMsliBJ5NIkyaaJBFgFkhCFhIiHOgVJ0grWXNQLxIqbuzjW66/iUM2oic+g1rJsFibYjFTk0myWyRg6X+62WrjTeaJ9rus1fZma6P9a+Jy60br"
	    		+ "Wvt2q9VstUiiXbKZCm3ENl0BUw01MjlWGfqgkXnKjT1/kqGOUI7uGUYTqyQpfdJJzo76aEvpBL20lywhLYeTv9OO/FBfG5v+jWVC+o3T/PjrJTtXpT4K/EMpMmTxvyh7bpHfpIS4yKwvkKMof+amcN9B+TMf5hca8gh/AU17udCNMiguFJ8XL0uFhmz+Ur6UL+VL+XcI+3o0/MXNiZkl+9yWgYV9jCidc/fMuunTSmY08fnNDTXK3KrG+vkLQrVO+P9xCNBg1ALD56pvaAhrwmpsC1iXwhy4G2ZCHUyHaVACM6AJEcyHZnyuB"
	    		+ "t/R5kIVNOKrxXxYACGoBafxJPsmgi83uL+bAObNK61eU1gIxh0gu/Ad6J89zLc2r8LVoVs6hr+iCqdI6gPq3zlIHxPo/hel6xbpHxYf7P0C6UB5HjbBkygb8Z1n5MkIXrfCUTiKOfUx2IKvYBWGNKbs8e8pjgURO3zo4Ov3yeUfgS0FyovKhix2fuPOP5YD6PWiTWLf8+0jMPwfgNIMFAplbmRzdHJlYW0KZW5kb2JqCjEzIDAgb2JqCjM0ODcKZW5kb2JqCjkgMCBvYmoKPDwvQmFzZUZvbnQvWkJQVUZEK1RUOEV0MDAvRm"
	    		+ "9udERlc2NyaXB0b3IgOCAwIFIvVHlwZS9Gb250Ci9GaXJzdENoYXIgMS9MYXN0Q2hhciAyNS9XaWR0aHNbIDYwMyA2MDMgNjAzIDYwMyA2MDMgNjAzIDYwMyA2MDMgNjAzIDYwMyA2MDMgNjAzIDYwMyA2MDMgNjAzCjYwMyA2MDMgNjAzIDYwMyA2MDMgNjAzIDYwMyA2MDMgNjAzIDYwM10KL0VuY29kaW5nIDE0IDAgUi9TdWJ0eXBlL1RydWVUeXBlPj4KZW5kb2JqCjE0IDAgb2JqCjw8L1R5cGUvRW5jb2RpbmcvQmF"
	    		+ "zZUVuY29kaW5nL1dpbkFuc2lFbmNvZGluZy9EaWZmZXJlbmNlc1sKMS9VL24vdC9pL2wvZS9kL1QvaC9zL3NwYWNlL0kvdi9vL2MvcGVyaW9kL3AvYS9yL20vdS95L1AvZy9vbmVdPj4KZW5kb2JqCjggMCBvYmoKPDwvVHlwZS9Gb250RGVzY3JpcHRvci9Gb250TmFtZS9aQlBVRkQrVFQ4RXQwMC9Gb250QkJveFswIC0yMDUgNTkwIDc3MF0vRmxhZ3MgNAovQXNjZW50IDc3MAovQ2FwSGVpZ2h0IDc3MAovRGVzY2Vu"
	    		+ "dCAtMjA1Ci9JdGFsaWNBbmdsZSAwCi9TdGVtViA4OAovTWlzc2luZ1dpZHRoIDYwMgovRm9udEZpbGUyIDEyIDAgUj4+CmVuZG9iagoyIDAgb2JqCjw8L1Byb2R1Y2VyKEdQTCBHaG9zdHNjcmlwdCA4LjE1KQovQ3JlYXRpb25EYXRlKEQ6MjAxMzA5MDQxMzQwMDApCi9Nb2REYXRlKEQ6MjAxMzA5MDQxMzQwMDApCi9UaXRsZShVbnRpdGxlZCAtIE5vdGVwYWQpCi9DcmVhdG9yKFBTY3JpcHQ1LmRsbCBWZXJzaW9uI"
	    		+ "DUuMi4yKQovQXV0aG9yKFJ1c3NfUCk+PmVuZG9iagp4cmVmCjAgMTUKMDAwMDAwMDAwMCA2NTUzNSBmIAowMDAwMDAwNjI4IDAwMDAwIG4gCjAwMDAwMDQ5NTIgMDAwMDAgbiAKMDAwMDAwMDU2MCAwMDAwMCBuIAowMDAwMDAwNDAwIDAwMDAwIG4gCjAwMDAwMDAwMTUgMDAwMDAgbiAKMDAwMDAwMDM4MSAwMDAwMCBuIAowMDAwMDAwNjc2IDAwMDAwIG4gCjAwMDAwMDQ3NTMgMDAwMDAgbiAKMDAwMDAwNDM2OSAwMDA"
	    		+ "wMCBuIAowMDAwMDAwNzE3IDAwMDAwIG4gCjAwMDAwMDA3NDcgMDAwMDAgbiAKMDAwMDAwMDc3NyAwMDAwMCBuIAowMDAwMDA0MzQ4IDAwMDAwIG4gCjAwMDAwMDQ2MTIgMDAwMDAgbiAKdHJhaWxlcgo8PCAvU2l6ZSAxNSAvUm9vdCAxIDAgUiAvSW5mbyAyIDAgUgovSUQgWyjSYAJmoJONVL6+I4dccnO9tyko0mACZqCTjVS+viOHXHJzvbcpXQo+PgpzdGFydHhyZWYKNTE0MQolJUVPRgo=")
	    		, "The Invoice was not returned correctly after calling GetOrderDocumentEx. Response = " + responseText);
		
		// Log test
		test.log(LogStatus.INFO, "Integration", "Verified the correct document list in the XML file was retruned when calling getOrderDocumentListEx");
		
	} // end getOrderDocumentEx
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get OS</li>
	 * 	<li>Update TrackingID's in XML Files</li>
	 * 	<li>Convert xml file to a string</li>
	 * 	<li>URL Encode the xml string</li>
	 * 	<li>Set UpdateAppraisalStatusEx Method POST URL</li>
	 * 	<li>Call UpdateAppraisalStatusEx method and get the response</li>
	 * 	<li>Convert Response XML to single line String</li>
	 * 	<li>Verify the response is correct</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TransformerException the transformer exception
	 */
	@Test (groups={"Integrations", "API - UpdateAppraisalStatusEx"}, dependsOnMethods="getOrderDocumentEx")
	public void updateAppraisalStatusEx2() throws IOException, TransformerException {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Get OS
		String os = StoredVariables.getos().get();
		
		// Update TrackingID's in XML Files
		String file = null;
		if (os.equals("Windows")) {
			file = StoredVariables.getapiXMLFilesDir().get()+"UpdateAppraisalStatusEx\\TestRevisionNeeded2.xml";
		} else if (os.equals("Mac")) {
			file = StoredVariables.getapiXMLFilesDir().get()+"UpdateAppraisalStatusEx/TestRevisionNeeded2.xml";
		} // end if/else
		perform.changeTagElementInXML(driver, "TRACKINGID",trackingID, file);
		
		// Convert xml file to a string
		String xml = perform.stringBuilder(driver, file);
		System.out.println("Document to be uploaded = " + file);
		
		// URL Encode the xml string
		xml = URLEncoder.encode(xml, "UTF-8");
		
		// Set UpdateAppraisalStatusEx Method POST URL
		String url = StoredVariables.getapiURL().get()+"mercuryapi.asmx/UpdateAppraisalStatusEx";
		String urlParameters = "SessionKey="+sessionKey+"&XMLPost="+xml+"&IPAddress=127.0.0.1";

		// Call UpdateAppraisalStatusEx method and get the response
		String[] response = perform.httpPost(driver, url, urlParameters);
		String body = response[2];
		
	    // Convert Response XML to single line String
	    String xml1 = body.trim();
	    String responseXML = perform.stringBuilderFromStringTrimmed(driver, xml1);
	    
		// Verify the response is correct
	    String expected = "<?xml version=\"1.0\" encoding=\"utf-8\"?><OrderResponse xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"http://alamode.com/\"><bResult>true</bResult><iError>0</iError><TrackingID>"+trackingID+"</TrackingID><Fee>0</Fee></OrderResponse>";
		Assert.assertTrue(responseXML.contains(expected), "XML response is incorrect. Response = " + responseXML + "\nFile = " + expected);
		
		// Log test
		test.log(LogStatus.INFO, "Integration", "Verified the correct XML was retruned when calling UpdateAppraisalStatusEx");
		
	} // end updateAppraisalStatusEx2
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to VMP Client Portal</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Verify the Message status shows</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ClassNotFoundException the ClassNotFoundExceptionthe class not found exception
	 * @throws SQLException the SQLExceptionthe SQL exception
	 */
	@Test (groups={"Integrations", "VMP - Orders"}, dependsOnMethods="updateAppraisalStatusEx2")
	public void verifyRevisionNeededMessageStatusOnVMPOrder() throws InterruptedException, IOException, ClassNotFoundException, SQLException {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Login to VMP Client Portal
		String URL = "https://automationintegrationqatestinglender.vmpclientqa.com";
		if (StoredVariables.getusernameEnvironment().get().equals("Live")) {
			URL = "https://automationinttestinglender.vmpclient.com";
		} // end if
		vmp.login(driver, URL, clientUser, password);
		
		// Find the order
		vmp.findOrder(driver, trackingNumber, "Tracking #");
		
		// Open the order
		vmp.openOrder(driver, trackingNumber);
		
		// Verify the Message status shows
		String history = VMPOrderDetails.history_txt(driver).getText();
		Assert.assertTrue(history.contains("Revision Needed by "+client+""), "The Revision Needed status does not show on the VMP order");
		Assert.assertTrue(history.contains("Descriptive Message"), "The Revision Needed status does not show on the VMP order");
		Assert.assertTrue(history.contains("Completed by "+lender+""), "The Completed status does not show on the VMP order");
		Assert.assertTrue(history.contains("Pending Quality Review by "+lender+""), "The Pending Quality Review status does not show on the VMP order");
		Assert.assertTrue(history.contains("Inspection Complete by "+lender+""), "The Inspection Complete status does not show on the VMP order");
		
		// Log test
		test.log(LogStatus.INFO, "Integration", "Verified the Revision Needed status shows on the VMP order and followed the set sync setting to Mercury Network");
		
	} // end verifyRevisionNeededMessageStatusOnVMPOrder
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Vendors</li>
	 * 	<li>Open the order</li>
	 * 	<li>Complete the order</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (groups={"Integrations", "Vendors - Orders", "Vendors - Complete Order"}, dependsOnMethods="verifyRevisionNeededMessageStatusOnVMPOrder")
	public void completeTheOrder2() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Login to Vendors
		vendors.login(driver, vendorUser, password);
		
		// Open the order
		vendors.findAndOpenOrder(driver, trackingNumber);

		// Complete the order
		String user = vendorUser;
		vendors.completeOrderByHTTPPost(driver, user, password, secondLoanID, "CompleteFHA.xml");
		
		// Log test
		test.log(LogStatus.INFO, "Integration", "Completed the order with a different MISMO XML");
		
	} // end completeTheOrder2
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Click Accept this report radio button</li>
	 * 	<li>Click OK</li>
	 * 	<li>Log test</li>
	 * </ul>
	 * @throws Exception the exception
	 */
	@Test (groups={"Integrations", "Secure - Orders", "Secure - Accept Order"}, dependsOnMethods="completeTheOrder2")
	public void markOrderCompleteOnSecureAsAMC2() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Login to Secure
		secure.login(driver, amcUser, password);
		
		// Find the order
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Open the order
		secure.openOrder(driver, trackingNumber);
		
		// Click Accept this report radio button
		perform.click(driver,SOrderDetails.acceptThisReportAsIs_radioBtn(driver));
		
		// Click OK
		perform.click(driver,SOrderDetails.okProcessReceivedReport_btn(driver));

		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Log test
		test.log(LogStatus.INFO, "Integration", "Marked the order complete on Secure");
		
	} // end markOrderCompleteOnSecureAsAMC2
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to Secure</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Click Accept this report radio button</li>
	 * 	<li>Click OK</li>
	 * 	<li>Log test</li>
	 * </ul>
	 * @throws Exception the exception
	 */
	@Test (groups={"Integrations", "Secure - Orders", "Secure - Accept Order"}, dependsOnMethods="markOrderCompleteOnSecureAsAMC2")
	public void markOrderCompleteOnSecureAsLender2() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Login to Secure
		secure.login(driver, lenderUser, password);
		
		// Find the order
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Open the order
		secure.openOrder(driver, trackingNumber);
		
		// Click Accept this report radio button
		perform.click(driver,SOrderDetails.acceptThisReportAsIs_radioBtn(driver));
		
		// Click OK
		perform.click(driver,SOrderDetails.okProcessReceivedReport_btn(driver));

		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Log test
		test.log(LogStatus.INFO, "Integration", "Marked the order complete on Secure");
		
	} // end markOrderCompleteOnSecureAsLender2
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get a new sessionKey</li>
	 * 	<li>Set GetOrderStatusHistoryClient Method POST URL</li>
	 * 	<li>Call GetOrderStatusHistoryClient Method and get the response</li>
	 * 	<li>Convert Response to single line String</li>
	 * 	<li>Verify the XML returned contains the On Hold and Message statuses</li>
	 * 	<li>Log test</li>
	 * </ul>
	 * @throws Exception exception
	 */
	@Test (groups={"Integrations", "API - GetCurrentStatusXSiteClientEx"}, dependsOnMethods="markOrderCompleteOnSecureAsLender2")
	public void getCurrentStatusXSiteClientEx3() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		String os = StoredVariables.getos().get();
		
		// Get a new sessionKey
		sessionKey = perform.apiLogin(driver, clientUser, password);
		
		// Set GetOrderStatusHistoryClient Method POST URL
		String url = StoredVariables.getapiURL().get()+"mercuryapi.asmx/GetCurrentStatusXSiteClientEx";
		String urlParameters = "SessionKey="+sessionKey+"&ProductItemID="+trackingID+"&IPAddress=127.0.0.1";
		
		// Call GetOrderStatusHistoryClient Method and get the response
		String[] response = perform.httpPost(driver, url, urlParameters);
		String body = response[2];
		
	    // Convert Response to single line String 
	    String responseText = perform.stringBuilderFromStringTrimmed(driver, body);
		
		// Verify the XML returned contains the On Hold and Message statuses
	    Assert.assertTrue(responseText.contains("<?xml version=\"1.0\" encoding=\"utf-8\"?><CurrentStatusEx xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"http://alamode.com/\"><Success>true</Success><Message>Call to GetCurrentStatus successful</Message><ProductItemID>"+trackingID
	    		+"</ProductItemID><StatusID>301000</StatusID><StatusName>Completed</StatusName><StatusComment>Set by vendor ("+lender+")</StatusComment><StatusDocuments><StatusDocument><Type>XML</Type><FileName>Test PDF.xml</FileName><Base64Document>"), "The XML in the response is incorrect. \nResponse: " + responseText);
	    
	    String base64Text = null;
	    if (os.equals("Windows")) {
	    	base64Text = perform.stringBuilderFromFileTrimmed(driver, perform.filepathForAPIXMLFiles(driver)+"GetCurrentStatusXSiteClientEx\\Base64DocumentVerification2.txt");
	    } else if (os.equals("Mac")) {
	    	base64Text = perform.stringBuilderFromFileTrimmed(driver, perform.filepathForAPIXMLFiles(driver)+"GetCurrentStatusXSiteClientEx/Base64DocumentVerification2.txt");
	    } // end if/else
	    
	    Assert.assertTrue(responseText.contains(base64Text), "The XML in the response is incorrect. Response = " + responseText);
		
		// Log test
		test.log(LogStatus.INFO, "Integration", "Verified the correct XML file was retruned when calling GetCurrentStatusXSiteClientEx");
		
	} // end getCurrentStatusXSiteClientEx3
	
} // end the VMPRoundTrip class