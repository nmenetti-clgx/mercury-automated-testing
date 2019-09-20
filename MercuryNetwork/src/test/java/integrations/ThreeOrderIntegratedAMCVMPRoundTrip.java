package integrations;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
import pageObjects.Vendors.VOrderDetails;
import pageObjects.XSite.XOrders;
import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

/**
 * <h1>Integrations - Three Order Integrated AMC VMP Round Trip</h1>
 * 
 * <p>Test Case 3
 *
 * @author  Dustin Norman
 * @since   07-16-2018
 */

@Listeners(utils.Listener.class)
@Test(singleThreaded=true, retryAnalyzer = Retry.class)
public class ThreeOrderIntegratedAMCVMPRoundTrip extends TestSetup {
	
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
	
	/** The mnProductItemID */
	private static String mnProductItemID = "";
	
	/** The mnLoanID */
	private static String mnLoanID = "";
	
	/** The password */
	private final String password = "@utoma7ionT3sting!";
	
	/** The Appraiser ID */
	private static String appraiserID = "";

	/** The Lender */
	private static String lender = "";

	/** The Lender User */
	private static String lenderUser = "";

	/** The Client User */
	private static String clientUser = "";

	/** The AMC */
	private static String amc = "";

	/** The AMC User */
	private static String amcUser = "";
	
	/** The file1 file */
	private static String file1 = "";

	/** The file2 file */
	private static String file2 = "";
	
	/** The file3 file */
	private static String file3 = "";
	
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
		lender = "AutomationIntegrationQA TestingLender";
		lenderUser = "AutomationIntQATestingLender@mercuryvmp.com";
		clientUser = "AutomationIntQATestingClient2";
		amc = "AutomationIntQATestingIntAMC";
		amcUser = "AutomationIntQATestingIntAMC@mercuryvmp.com";
		file1 = "Lender3Groups.xml";
		file2 = "PlaceAppraisalOrderExLenderNoGroups3.xml";
		file3 = "PlaceAppraisalOrderExLenderClientGroup2.xml";
		if (StoredVariables.getusernameEnvironment().get().equals("Live")) {
			appraiserID = "5711240";
			lender = "AutomationInt TestingLender";
			lenderUser = "AutomationIntTestingLender@mercuryvmp.com";
			clientUser = "AutomationIntTestingClient2";
			amc = "AutomationIntTestingIntAMC";
			amcUser = "AutomationIntTestingIntAMC@mercuryvmp.com";
			file1 = "Lender3GroupsLive.xml";
			file2 = "PlaceAppraisalOrderExLenderNoGroups3Live.xml";
			file3 = "PlaceAppraisalOrderExLenderClientGroup2Live.xml";
		} // end if
		
		// Login and get the session key
		sessionKey = perform.apiLogin(driver, clientUser, "@utoma7ionT3sting!");
		
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
	    } // end if/esle

		// Verify the XML is the same
		Assert.assertTrue(responseXML.equals(fileXML), "XML file is incorrect. Response: " + responseXML + "\n\n\nFile: " + fileXML);
		
		// Log test
		test.log(LogStatus.INFO, "Integration", "Verified the correct XML file was retruned when calling GetVMPOrderFormFields");
		
	} // end getVMPOrderFormFields
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set path to the XML file to place the order</li>
	 * 	<li>Reading XML as String using jCabi library</li>
	 * 	<li>Set PlaceAppraisalOrderEx Method POST URL</li>
	 * 	<li>Initialize the HTTP post</li>
	 * 	<li>Request parameters and other properties.</li>
	 * 	<li>Execute and get the response.</li>
	 * 	<li>Convert XML File to single line String for the expected response</li>
	 * 	<li>Verify the XML is the same</li>
	 * 	<li>Set path to the new XML file to place the order</li>
	 * 	<li>Reading XML as String using jCabi library</li>
	 * 	<li>Set PlaceAppraisalOrderEx Method POST URL</li>
	 * 	<li>Initialize the HTTP post</li>
	 * 	<li>Request parameters and other properties.</li>
	 * 	<li>Execute and get the response.</li>
	 * 	<li>Convert XML File to single line String of the expected results</li>
	 * 	<li>Verify the XML is the same</li>
	 * 	<li>Parse out the TrackingID</li>
	 * 	<li>Parse out the TrackingNumber</li>
	 * 	<li>Parse out the Fee</li>
	 * 	<li>Parse out the DueDate</li>
	 * 	<li>Set Mercury Product Item ID</li>
	 * 	<li>Set Mercury Loan ID</li>
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
		
		// Set path to the XML file to place the order
		String xmlFilePath = null;
		if (os.equals("Windows")) {
			xmlFilePath = perform.filepathForAPIXMLFiles(driver)+"PlaceAppraisalOrderEx\\"+file2;
		} else if (os.equals("Mac")) {
			xmlFilePath = perform.filepathForAPIXMLFiles(driver)+"PlaceAppraisalOrderEx/"+file2;
		} // end if/else
		
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
		
	    // Convert XML File to single line String for the expected response
	    String fileXMLFail = null;
	    if (os.equals("Windows")) {
	    	fileXMLFail = perform.stringBuilderFromFileTrimmed(driver, perform.filepathForAPIXMLFiles(driver)+"PlaceAppraisalOrderEx\\ClientGroupNotSuppliedNACK.xml");
	    } else if (os.equals("Mac")) {
	    	fileXMLFail = perform.stringBuilderFromFileTrimmed(driver, perform.filepathForAPIXMLFiles(driver)+"PlaceAppraisalOrderEx/ClientGroupNotSuppliedNACK.xml");
	    } // end if/else

		// Verify the XML is the same
	    Assert.assertTrue(body.contains("<?xml version=\"1.0\" encoding=\"utf-8\"?><OrderResponse xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"http://alamode.com/\"><bResult>false</bResult><iError>5</iError><szError>System Error! (ClientGroupID was not supplied.)</szError><Fee>0</Fee></OrderResponse>"), "XML file is incorrect. Response = " + body + "\nFile = " + fileXMLFail);
	    
		// Set path to the new XML file to place the order
	    String xmlFilePath2 = null;
	    if (os.equals("Windows")) {
	    	xmlFilePath2 = perform.filepathForAPIXMLFiles(driver)+"PlaceAppraisalOrderEx\\"+file3;
	    } else if (os.equals("Mac")) {
	    	xmlFilePath2 = perform.filepathForAPIXMLFiles(driver)+"PlaceAppraisalOrderEx/"+file3;
	    } // end if/else
		
        // Reading XML as String using jCabi library
	    XML xml2 = new XMLDocument(new File(xmlFilePath2));
        String xmlString2 = xml2.toString();
        
		// Set PlaceAppraisalOrderEx Method POST URL
		String url2 = StoredVariables.getapiURL().get()+"mercuryapi.asmx/PlaceAppraisalOrderEx";

		// Initialize the HTTP post
		HttpClient httpclient2 = HttpClients.createDefault();
		HttpPost httppost2 = new HttpPost(url2);

		// Request parameters and other properties.
		List<NameValuePair> params2 = new ArrayList<NameValuePair>(2);
		params2.add(new BasicNameValuePair("SessionKey", sessionKey));
		params2.add(new BasicNameValuePair("XMLPost", xmlString2));
		params2.add(new BasicNameValuePair("IPAddress", "127.0.0.1"));
		httppost2.setEntity(new UrlEncodedFormEntity(params2, "UTF-8"));

		//Execute and get the response.
		HttpResponse response2 = httpclient2.execute(httppost2);
		
		InputStream ips2  = response2.getEntity().getContent();
		BufferedReader buf2 = new BufferedReader(new InputStreamReader(ips2,"UTF-8"));
        if(response2.getStatusLine().getStatusCode()!=HttpStatus.SC_OK)
        {
            throw new Exception(response2.getStatusLine().getReasonPhrase());
        }
        StringBuilder sb2 = new StringBuilder();
        String s2;
        while(true )
        {
            s2 = buf2.readLine();
            if(s2==null || s2.length()==0)
                break;
            sb2.append(s2.trim());

        }
        buf2.close();
        ips2.close();
        String body2 = sb2.toString();
		System.out.println("\n\nbody = " + body2);
	    
	    // Convert XML File to single line String of the expected results
	    String fileXML = null;
	    if (os.equals("Windows")) {
	    	fileXML = perform.stringBuilderFromFileTrimmed(driver, perform.filepathForAPIXMLFiles(driver)+"PlaceAppraisalOrderEx\\SuccessfulACK3.xml");
	    } else if (os.equals("Mac")) {
	    	fileXML = perform.stringBuilderFromFileTrimmed(driver, perform.filepathForAPIXMLFiles(driver)+"PlaceAppraisalOrderEx/SuccessfulACK3.xml");
	    } // end if/else
	    
		// Verify the XML is the same
		Assert.assertTrue(body2.contains("<?xml version=\"1.0\" encoding=\"utf-8\"?><OrderResponse xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"http://alamode.com/\"><bResult>true</bResult><iError>0</iError><szError /><TrackingID>"), "XML file is incorrect. Response = " + body2 + "\nFile = " + fileXML);
	    Assert.assertTrue(body2.contains("</TrackingID><TrackingNumber>MERC-"), "XML file is incorrect. Response = " + body2 + "\nFile = " + fileXML);
	    Assert.assertTrue(body2.contains("</TrackingNumber><Fee>0</Fee><DueDate>5/30/2017</DueDate></OrderResponse>"), "XML file is incorrect. Response = " + body2 + "\nFile = " + fileXML);
		
		// Parse out the TrackingID
		String tag = "TrackingID";
		trackingID = perform.getTagFromHTTPResponseAsString(driver, tag, body2);
		System.out.println(tag + " = " + trackingID);

		// Parse out the TrackingNumber
		tag = "TrackingNumber";
		trackingNumber = perform.getTagFromHTTPResponseAsString(driver, tag, body2);
		System.out.println(tag + " = " + trackingNumber);
		
		// Parse out the Fee
		tag = "Fee";
		fee = perform.getTagFromHTTPResponseAsString(driver, tag, body2);
		System.out.println(tag + " = " + fee);
		
		// Parse out the DueDate
		tag = "DueDate";
		dueDate = perform.getTagFromHTTPResponseAsString(driver, tag, body2);
		System.out.println(tag + " = " + dueDate);
		
		// Set Mercury Product Item ID
		String getMNProductItemID = "SELECT MNProductItemID, * FROM ULSOrders " + 
				"WHERE XSiteProductItemID LIKE '"+trackingID+"'";
		mnProductItemID = db.queryDB(driver, "Mercury", getMNProductItemID);
		
		// Set Mercury Loan ID
		String getMNLoanID = "SELECT LoanID FROM ProductItems " + 
				"WHERE ProductItemID = (SELECT MNProductItemID FROM ULSOrders " + 
				"WHERE MNProductItemID LIKE '"+mnProductItemID+"')";
		mnLoanID = db.queryDB(driver, "Mercury", getMNLoanID);
		
		System.out.println("\n\nmnProductItemID: " + mnProductItemID);
		System.out.println("mnLoanID: " + mnLoanID + "\n\n");
		
		// Log tracking numbers
		test.log(LogStatus.INFO, "Order Numbers", "TrackingID: " + trackingID + "<br>TrackingNumber: " + trackingNumber + "<br>mnProductItemID: " + mnProductItemID + "<br>mnLoanID: " + mnLoanID);
		
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
	 * 	<li>Verify the Client Group is Test Group 2</li>
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
		String user = lenderUser;
		String orderNumber = trackingNumber.replace("MERC-", "");
		secure.viewXSiteOrderFromSecure(driver, user, password, orderNumber);
		
	    // Convert XML File to single line String
	    String fileXML = null;
	    if (os.equals("Windows")) {
	    	fileXML = perform.stringBuilderFromFileTrimmed(driver, perform.filepathForAPIXMLFiles(driver)+"PlaceAppraisalOrderEx\\"+file3);
	    } else if (os.equals("Mac")) {
	    	fileXML = perform.stringBuilderFromFileTrimmed(driver, perform.filepathForAPIXMLFiles(driver)+"PlaceAppraisalOrderEx/"+file3);
	    } // end if/else
	    
	    // Parse XML File to get values
		String fhaCaseNumber = perform.getTagFromHTTPResponseAsString(driver, "FHA_CASENUMBER", fileXML);
		String loanType = perform.getTagFromHTTPResponseAsString(driver, "LOAN_TYPE", fileXML);
		String loanPurpose = perform.getTagFromHTTPResponseAsString(driver, "LOAN_PURPOSE", fileXML);
		String lenderCaseNumber = perform.getTagFromHTTPResponseAsString(driver, "LENDERCASENUMBER", fileXML);
		String clientFileNo = perform.getTagFromHTTPResponseAsString(driver, "CLIENT_FILE_NO", fileXML);
		String subLenClient = "Test Company 2";
		String lenderAddress1 = "Test Address 2 Ave";
		String lenderCity = "Dallas";
		String lenderState = "TX";
		String lenderZip = "75001";
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
		String fee = "";
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
		
		// Verify the Client Group is Test Group 2
		Assert.assertTrue(XOrders.clientGroup_txt(driver).getText().equals("Test Group 2"), "The Client Group should be Test Group 2, but is " + XOrders.clientGroup_txt(driver).getText());
		
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
	 * 	<li>Click the AMC/Firm radio button</li>
	 * 	<li>Click Assign</li>
	 * 	<li>Assign the order to "+amc+"</li>
	 * 	<li>Verify the client group values (lender info and order group)</li>
	 * 	<li>Enter Fee</li>
	 * 	<li>Click Finish</li>
	 * 	<li>Verify history</li>
	 * 	<li>Log test</li>
	 * </ul>
	 * @throws Exception the exception
	 */
	@Test (groups={"Integrations", "Secure - Orders", "Secure - Assign Order To AMC"}, dependsOnMethods="viewBusinessManagement")
	public void assignOrderToAMC() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();

		// Login to Secure
		secure.login(driver, lenderUser, password);
		
		// Find the order
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Open the order
		secure.openOrder(driver, trackingNumber);
		
		// Click the AMC/Firm radio button
		perform.click(driver,SOrderDetails.amcFirm_radiobtn(driver));
		
		// Wait for busy to be hidden
		perform.waitForBusyToBeHidden(driver);

		// Click Assign
		perform.click(driver,SOrderDetails.assign_btn(driver));
		
		// Assign the order to "+amc+"
		secure.selectVendor(driver, amc);
		
		// Verify the client group values (lender info and order group)
		String orderGroup = SConfirmOrder.orderGroup_txt(driver).getText();
		String lender = SConfirmOrder.lender_txt(driver).getText();
		Assert.assertTrue(orderGroup.equals("Integrated AMC"), "The Order Group shold be Integrated AMC, but is " + orderGroup);
		Assert.assertTrue(lender.equals("Test Company 2"), "The Order Group shold be Test Company 2, but is " + lender);
		
		// Enter Fee
		perform.type(driver,SConfirmOrder.orderFee_txtbx(driver), "459");
		
		// Click Finish
		perform.click(driver,SConfirmOrder.finishTop_btn(driver));
		
		// Wait for the history
		perform.waitForElementToBeClickable(driver, SOrderDetails.history_txt(), "id");
		
		// Verify history
		String history = SOrderDetails.history_txt(driver).getText();
		String expected1 = "Order accepted by AMC ("+amc+") and In Progress";
		String expected2 = "Order automatically accepted";
		String[] expected = {expected1, expected2};
		perform.verifyTextContains(driver, history, expected);
		
		// Log test
		test.log(LogStatus.INFO, "Integration", "Assigned the order to an AMC");
		
	} // end assignOrderToAMC
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Send Message through updateAppraisalStatusGlobal</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Find the order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Set expected audit trail events</li>
	 * 	<li>Verify history</li>
	 * 	<li>Send Comment - Action Required through updateAppraisalStatusGlobal</li>
	 * 	<li>Refresh the page and get the history text</li>
	 * 	<li>Set expected audit trail events</li>
	 * 	<li>Verify history</li>
	 * 	<li>Send Delayed through updateAppraisalStatusGlobal</li>
	 * 	<li>Refresh the page and get the history text</li>
	 * 	<li>Set expected audit trail events</li>
	 * 	<li>Verify history</li>
	 * 	<li>Send Resumed through updateAppraisalStatusGlobal</li>
	 * 	<li>Refresh the page and get the history text</li>
	 * 	<li>Set expected audit trail events</li>
	 * 	<li>Verify history</li>
	 * 	<li>Send On Hold through updateAppraisalStatusGlobal</li>
	 * 	<li>Refresh the page and get the history text</li>
	 * 	<li>Set expected audit trail events</li>
	 * 	<li>Verify history</li>
	 * 	<li>Send Resumed through updateAppraisalStatusGlobal</li>
	 * 	<li>Refresh the page and get the history text</li>
	 * 	<li>Set expected audit trail events</li>
	 * 	<li>Verify history</li>
	 * 	<li>Send Inspection Scheduled through updateAppraisalStatusGlobal</li>
	 * 	<li>Refresh the page and get the history text</li>
	 * 	<li>Set expected audit trail events</li>
	 * 	<li>Verify history</li>
	 * 	<li>Send Inspection Complete through updateAppraisalStatusGlobal</li>
	 * 	<li>Refresh the page and get the history text</li>
	 * 	<li>Set expected audit trail events</li>
	 * 	<li>Verify history</li>
	 * 	<li>Send Order Changed through updateAppraisalStatusGlobal</li>
	 * 	<li>Refresh the page and get the history text</li>
	 * 	<li>Set expected audit trail events</li>
	 * 	<li>Verify history</li>
	 * 	<li>Send Document Upload through updateAppraisalStatusGlobal</li>
	 * 	<li>Refresh the page and get the history text</li>
	 * 	<li>Set expected audit trail events</li>
	 * 	<li>Verify history</li>
	 * 	<li>Send Completed through updateAppraisalStatusGlobal</li>
	 * 	<li>Refresh the page and get the history text</li>
	 * 	<li>Set expected audit trail events</li>
	 * 	<li>Verify history</li>
	 * 	<li>Get the order status</li>
	 * 	<li>Verify the order is in QC - Level One</li>
	 * 	<li>Get list of documents</li>
	 * 	<li>Verify documents exists</li>
	 * 	<li>Click Accept this report radio button</li>
	 * 	<li>Click OK</li>
	 * 	<li>Log test</li>
	 * </ul>
	 * @throws Exception the exception
	 */
	@Test (groups={"Integrations", "Secure - Orders", "API - UpdateAppraisalStatusGlobal", "Secure - Accept Order"}, dependsOnMethods="assignOrderToAMC")
	public void updateStatusesFromWebService() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Send Message through updateAppraisalStatusGlobal
		updateAppraisalStatusGlobal(driver, "SampleMessage");
		
		// Login to Secure
		secure.login(driver, lenderUser, password);
		
		// Find the order
		secure.findOrder(driver, trackingNumber, "Tracking number");
		
		// Open the order
		secure.openOrder(driver, trackingNumber);
		
		// Wait for the history
		perform.waitForElementToBeClickable(driver, SOrderDetails.history_txt(), "id");
		
		// Set expected audit trail events
		String history = SOrderDetails.history_txt(driver).getText();
		String expected1 = "Message to appraiser.";
		String expected2 = "Message from AMC ("+amc+")";
		String[] expected = {expected1, expected2};
		
		// Verify history
		perform.verifyTextContains(driver, history, expected);
		
		// Send Comment - Action Required through updateAppraisalStatusGlobal
		updateAppraisalStatusGlobal(driver, "SampleCommentActionRequired");
		
		// Refresh the page and get the history text
		history = refreshThePage(driver);
		
		// Set expected audit trail events
		expected1 = "Comment - Action Required by AMC ("+amc+")";
		expected2 = "CampbellTest LenderQA | Step 5. Comment action required.";
		expected = new String[] {expected1, expected2};
		
		// Verify history
		perform.verifyTextContains(driver, history, expected);
		
		// Send Delayed through updateAppraisalStatusGlobal
		updateAppraisalStatusGlobal(driver, "SampleDelayed");
		
		// Refresh the page and get the history text
		history = refreshThePage(driver);
		
		// Set expected audit trail events
		expected1 = "Delayed by AMC ("+amc+")";
		expected2 = "Delayed Message";
		expected = new String[] {expected1, expected2};
		
		// Verify history
		perform.verifyTextContains(driver, history, expected);
		
		// Send Resumed through updateAppraisalStatusGlobal
		updateAppraisalStatusGlobal(driver, "SampleResumed");
		
		// Refresh the page and get the history text
		history = refreshThePage(driver);
		
		// Set expected audit trail events
		expected1 = "Resumed by AMC ("+amc+")";
		expected2 = "Descriptive Message";
		expected = new String[] {expected1, expected2};
		
		// Verify history
		perform.verifyTextContains(driver, history, expected);
		
		// Send On Hold through updateAppraisalStatusGlobal
		updateAppraisalStatusGlobal(driver, "SampleOnHold");
		
		// Refresh the page and get the history text
		history = refreshThePage(driver);
		
		// Set expected audit trail events
		expected1 = "On Hold by Client ("+amc+")";
		expected2 = "Descriptive Message";
		expected = new String[] {expected1, expected2};
		
		// Verify history
		perform.verifyTextContains(driver, history, expected);
		
		// Send Resumed through updateAppraisalStatusGlobal
		updateAppraisalStatusGlobal(driver, "SampleResumed");
		
		// Refresh the page and get the history text
		history = refreshThePage(driver);
		
		// Set expected audit trail events
		expected1 = "Resumed by AMC ("+amc+")";
		expected2 = "Descriptive Message";
		expected = new String[] {expected1, expected2};
		
		// Verify history
		perform.verifyTextContains(driver, history, expected);
		
		// Send Inspection Scheduled through updateAppraisalStatusGlobal
		updateAppraisalStatusGlobal(driver, "SampleInspectionScheduled");
		
		// Refresh the page and get the history text
		history = refreshThePage(driver);
		
		// Set expected audit trail events
		expected1 = "Inspection Scheduled by AMC ("+amc+")";
		expected2 = "Inspection date is";
		expected = new String[] {expected1, expected2};
		
		// Verify history
		perform.verifyTextContains(driver, history, expected);
		
		// Send Inspection Complete through updateAppraisalStatusGlobal
		updateAppraisalStatusGlobal(driver, "SampleInspectionComplete");
		
		// Refresh the page and get the history text
		history = refreshThePage(driver);
		
		// Set expected audit trail events
		expected1 = "Inspection Complete by AMC ("+amc+")";
		expected2 = "Inspected on";
		expected = new String[] {expected1, expected2};
		
		// Verify history
		perform.verifyTextContains(driver, history, expected);
		
		// Send Order Changed through updateAppraisalStatusGlobal
		updateAppraisalStatusGlobal(driver, "SampleOrderChanged");
		
		// Refresh the page and get the history text
		history = refreshThePage(driver);
		
		// Set expected audit trail events
		expected1 = "Order Changed by AMC ("+amc+")";
		expected2 = "To View Change History";
		expected = new String[] {expected1, expected2};
		
		// Verify history
		perform.verifyTextContains(driver, history, expected);
		
		// Send Document Upload through updateAppraisalStatusGlobal
		updateAppraisalStatusGlobal(driver, "SampleDocumentUpload");
		
		// Refresh the page and get the history text
		history = refreshThePage(driver);
		
		// Set expected audit trail events
		expected1 = "Document Uploaded from AMC ("+amc+") (FNMSSR.PDF)";
		expected = new String[] {expected1};
		
		// Verify history
		perform.verifyTextContains(driver, history, expected);
		
		// Send Completed through updateAppraisalStatusGlobal
		updateAppraisalStatusGlobal(driver, "SampleCompleted");
		
		// Refresh the page and get the history text
		history = refreshThePage(driver);
		
		// Set expected audit trail events
		expected1 = "Order delivered by AMC ("+amc+") and is now In QC - Level One";
		expected2 = "Document Uploaded from AMC ("+amc+") (Invoice.PDF)";
		expected = new String[] {expected1, expected2};
		
		// Verify history
		perform.verifyTextContains(driver, history, expected);
		
		// Get the order status
		String status = driver.findElement(By.cssSelector("#Main_Main_upStatusHistory > div > div.psCaption.psSeparator.psBold")).getText();
		
		// Verify the order is in QC - Level One
		Assert.assertTrue(status.contains("History (In QC - Level One)"), "The order status should be in QC - Level One");
		
		// Get list of documents
		String docs = SOrderDetails.orderDocuments_txt(driver).getText();
		
		// Verify documents exists
		expected1 = "Report PDF";
		expected2 = "MISMO XML";
		String expected3 = "Invoice";
		String expected4 = "FNM SSR";
		String expected5 = "Sales Contract";
		String expected6 = "Other";
		expected = new String[] {expected1, expected2, expected3, expected4, expected5, expected6};
		perform.verifyTextContains(driver, docs, expected);
		
		// Click Accept this report radio button
		perform.click(driver,SOrderDetails.acceptThisReportAsIs_radioBtn(driver));
		
		// Click OK
		perform.click(driver,SOrderDetails.okProcessReceivedReport_btn(driver));

		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Log test
		test.log(LogStatus.INFO, "Integration", "Verified the audit trail events were displayed when calling UpdateAppraisalStatusGlobal and released the order from QC - Level One");
		
	} // end updateStatusesFromWebService
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Send Message through updateAppraisalStatusGlobal</li>
	 * 	<li>Login to Secure</li>
	 * 	<li>Find the order</li>
	 * 	<li>Set expected audit trail events</li>
	 * 	<li>Verify history</li>
	 * 	<li>Get the order status</li>
	 * 	<li>Verify the order is in QC - Level One</li>
	 * 	<li>Get list of documents</li>
	 * 	<li>Verify documents exists</li>
	 * 	<li>Log test</li>
	 * </ul>
	 * @throws Exception the exception
	 */
	@Test (groups={"Integrations", "API - UpdateAppraisalStatusGlobal", "Vendors - Orders"}, dependsOnMethods="updateStatusesFromWebService")
	public void verifyAuditTrailForAMC() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Send Message through updateAppraisalStatusGlobal
		updateAppraisalStatusGlobal(driver, "SampleMessage");
		
		// Login to Secure
		vendors.login(driver, amcUser, password);
		
		// Find the order
		vendors.findAndOpenOrder(driver, trackingNumber);
		
		// Wait for the history
		perform.waitForElementToBeClickable(driver, VOrderDetails.history_txt(), "id");
		
		// Set expected audit trail events
		String history = VOrderDetails.history_txt(driver).getText();
		String expected1 = "Message to appraiser.";
		String expected2 = "Message from AMC ("+amc+")";
		String expected3 = "Comment - Action Required by AMC ("+amc+")";
		String expected4 = "CampbellTest LenderQA | Step 5. Comment action required.";
		String expected5 = "Delayed by AMC ("+amc+")";
		String expected6 = "Delayed Message";
		String expected7 = "Resumed by AMC ("+amc+")";
		String expected8 = "Descriptive Message";
		String expected9 = "On Hold by Client ("+amc+")";
		String expected10 = "Descriptive Message";
		String expected11 = "Resumed by AMC ("+amc+")";
		String expected12 = "Descriptive Message";
		String expected13 = "Inspection Scheduled by AMC ("+amc+")";
		String expected14 = "Inspection date is";
		String expected15 = "Inspection Complete by AMC ("+amc+")";
		String expected16 = "Inspected on";
		String expected17 = "Order Changed by AMC ("+amc+")";
		String expected18 = "To View Change History";
		String expected19 = "Document Uploaded from AMC ("+amc+") (FNMSSR.PDF)";
		String expected20 = "Order delivered by AMC ("+amc+") and is now In QC - Level One";
		String expected21 = "Document Uploaded from AMC ("+amc+") (Invoice.PDF)";
		String[] expected = {expected1, expected2, expected3, expected4, expected5, expected6, expected7, expected8, expected9, expected10, expected11,
				expected12, expected13, expected14, expected15, expected16, expected17, expected18, expected19, expected20, expected21};
		
		// Verify history
		perform.verifyTextContains(driver, history, expected);
		
		// Get the order status
		String status = VOrderDetails.status_txt(driver).getText();
		
		// Verify the order is in QC - Level One
		Assert.assertTrue(status.contains("History (Completed)"), "The order status should be Completed");
		
		// Get list of documents
		String docs = VOrderDetails.orderDocuments_txt(driver).getText();
		
		// Verify documents exists
		expected1 = "Report PDF";
		expected2 = "MISMO XML";
		expected3 = "Invoice";
		expected4 = "FNM SSR";
		expected5 = "Sales Contract";
		expected6 = "Other";
		expected = new String[] {expected1, expected2, expected3, expected4, expected5, expected6};
		perform.verifyTextContains(driver, docs, expected);
		
		// Log test
		test.log(LogStatus.INFO, "Integration", "Verified the audit trail events were displayed for the AMC");
		
	} // end verifyAuditTrailForAMC
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set GetOrderStatusHistoryClient Method POST URL</li>
	 * 	<li>Call GetOrderStatusHistoryClient Method and get the response</li>
	 * 	<li>Convert Response to single line String</li>
	 * 	<li>Write data to a file</li>
	 * 	<li>Verify the XML</li>
	 * 	<li>Log test</li>
	 * 	<li>Get OS</li>
	 * 	<li>Update TrackingID's in XML Files</li>
	 * 	<li>Convert xml file to a string</li>
	 * 	<li>Set UpdateAppraisalStatusEx Method POST URL</li>
	 * 	<li>Call UpdateAppraisalStatusEx method and get the response</li>
	 * 	<li>Convert Response XML to single line String</li>
	 * 	<li>Verify the response is correct</li>
	 * 	<li>Refresh the page</li>
	 * 	<li>Verify history</li>
	 * 	<li>Return the history</li>
	 * </ul>
	 * @throws IOException the exception
	 * @throws TransformerException the TransformerException
	 */
	@Test (groups={"Integrations", "API - GetCurrentStatusXSiteClientEx"}, dependsOnMethods="verifyAuditTrailForAMC")
	public void getCurrentStatusXSiteClientEx() throws IOException, TransformerException {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		String os = StoredVariables.getos().get();
		
		// Set GetOrderStatusHistoryClient Method POST URL
		String url = StoredVariables.getapiURL().get()+"mercuryapi.asmx/GetCurrentStatusXSiteClientEx";
		String urlParameters = "SessionKey="+sessionKey+"&ProductItemID="+trackingID+"&IPAddress=127.0.0.1";
		
		// Call GetOrderStatusHistoryClient Method and get the response
		String[] response = perform.httpPost(driver, url, urlParameters);
		String body = response[2];
		
	    // Convert Response to single line String 
	    String responseText = perform.stringBuilderFromStringTrimmed(driver, body);
	    
		// Write data to a file
		String fileName = "body.txt";
		perform.writeToAFile(driver, StoredVariables.getdocDir().get(), fileName, responseText);
		
		// Verify the XML
	    Assert.assertTrue(responseText.contains("<?xml version=\"1.0\" encoding=\"utf-8\"?><CurrentStatusEx xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"http://alamode.com/\"><Success>true</Success><Message>Call to GetCurrentStatus successful</Message><ProductItemID>"+trackingID
	    		+"</ProductItemID><StatusID>301000</StatusID><StatusName>Completed</StatusName><StatusComment>Set by vendor ("+lender+")</StatusComment><StatusDocuments><StatusDocument><Type>XML</Type><FileName>MISMORpt.XML</FileName><Base64Document>"), "The XML in the response is incorrect. Response = " + responseText);
	    String base64Text = null;
	    if (os.equals("Windows")) {
	    	base64Text = perform.stringBuilderFromFileTrimmed(driver, perform.filepathForAPIXMLFiles(driver)+"GetCurrentStatusXSiteClientEx\\Base64DocumentVerification3.txt");
	    } else if (os.equals("Mac")) {
	    	base64Text = perform.stringBuilderFromFileTrimmed(driver, perform.filepathForAPIXMLFiles(driver)+"GetCurrentStatusXSiteClientEx/Base64DocumentVerification3.txt");
	    } // end if/else
	    Assert.assertTrue(responseText.contains(base64Text), "The XML in the response is incorrect. Response = " + responseText);
		
		// Log test
		test.log(LogStatus.INFO, "Integration", "Verified the correct XML file was retruned when calling GetCurrentStatusXSiteClientEx");
		
	} // end getCurrentStatusXSiteClientEx
	
	private void updateAppraisalStatusGlobal(RemoteWebDriver driver, String fileName) throws Exception {
		
		// Get OS
		String os = StoredVariables.getos().get();
		
		// Update TrackingID's in XML Files
		String file = null;
		if (os.equals("Windows")) {
			file = StoredVariables.getapiXMLFilesDir().get()+"UpdateAppraisalStatusGlobal\\"+fileName+".xml";
		} else if (os.equals("Mac")) {
			file = StoredVariables.getapiXMLFilesDir().get()+"UpdateAppraisalStatusGlobal/"+fileName+".xml";
		} // end if/else
		System.out.println("file: " + file);
		try {
			perform.changeTagElementInXML(driver, "LOANNUMBER",mnLoanID, file);
		} catch (Exception e) {
			System.out.println("There is no LOANNUMBER to update");
		} // end try/catch
		perform.changeTagElementInXML(driver, "TRACKINGID",mnProductItemID, file);
		
		// Convert xml file to a string
		String xml = perform.stringBuilder(driver, file);
		System.out.println("Document to be uploaded = " + file);
		
		// Set UpdateAppraisalStatusEx Method POST URL
		String url = StoredVariables.getapiURL().get()+"mercuryapi.asmx/UpdateAppraisalStatusGlobal";
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("Username",amcUser));
		params.add(new BasicNameValuePair("Password",password));
		params.add(new BasicNameValuePair("XMLPost",xml));
		
		// Call UpdateAppraisalStatusEx method and get the response
		String body = perform.httpPostWithIndividualParams(driver, url, params);
		
	    // Convert Response XML to single line String
	    String xml1 = body.trim();
	    String responseXML = perform.stringBuilderFromStringTrimmed(driver, xml1);
	    
		// Verify the response is correct
		String expected = "<?xml version=\"1.0\" encoding=\"utf-8\"?><UpdateAppraisalStatusGlobalResult xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"http://alamode.com/\"><bResult>true</bResult><iError>0</iError><TrackingID>"+mnProductItemID+"</TrackingID></UpdateAppraisalStatusGlobalResult>";
		Assert.assertTrue(responseXML.contains(expected), "XML response is incorrect. Response = " + responseXML + "\nFile = " + expected);
		
	} // end updateAppraisalStatusGlobal
	
	private String refreshThePage(RemoteWebDriver driver) throws InterruptedException, IOException {
	
	// Refresh the page
	driver.navigate().refresh();
		
	// Wait for the history
	perform.waitForElementToBeClickable(driver, SOrderDetails.history_txt(), "id");
	
	// Verify history
	String history = SOrderDetails.history_txt(driver).getText();
	
	// Return the history
	return history;

	} // end refreshThePage
	
} // end the VMPRoundTrip class