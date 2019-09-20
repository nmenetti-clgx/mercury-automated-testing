package integrations;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

/**
 * <h1>Integrations - Three Order Integrated AMC QA VMP Round Trip</h1>
 * 
 * <p>Test Case 4
 *
 * @author  Dustin Norman
 * @since   10-03-2018
 */

@Listeners(utils.Listener.class)
@Test(retryAnalyzer = Retry.class)
public class ThreeOrderIntegratedAMCQAVMPRoundTrip extends TestSetup {
	
	/** The password */
	private final String password = "@utoma7ionT3sting!";
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set variables</li>
	 * 	<li>Login and get the session key</li>
	 * 	<li>Set path to the XML file to place the order</li>
	 * 	<li>Convert XML File to single line String for the expected response</li>
	 * 	<li>Send the POST to PlaceAppraisalOrderEx and verify the response</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (groups={"Integrations", "API - Login", "API - PlaceAppraisalOrderEx"}, alwaysRun=true)
	public void integrationDeniedNACK() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		String os = StoredVariables.getos().get();

		// Set variables
		String user = "AutomationIntQATestingClient5";
		String file1 = "PlaceAppraisalOrderExLenderClientGroup3.xml";
		String file2 = "IntegrationDeniedNACK.xml";
		if (StoredVariables.getusernameEnvironment().get().equals("Live")) {
			user = "AutomationIntTestingClient5";
			file1 = "PlaceAppraisalOrderExLenderClientGroup3Live.xml";
			file2 = "IntegrationDeniedNACKLive.xml";
		} // end if Live
		
		// Login and get the session key
		String sessionKey = perform.apiLogin(driver, user, password);
		
		// Set path to the XML file to place the order
	    String xmlToCreateOrderWith = null;
	    if (os.equals("Windows")) {
	    	xmlToCreateOrderWith = perform.filepathForAPIXMLFiles(driver)+"PlaceAppraisalOrderEx\\"+file1;
	    } else if (os.equals("Mac")) {
	    	xmlToCreateOrderWith = perform.filepathForAPIXMLFiles(driver)+"PlaceAppraisalOrderEx/"+file1;
	    } // end if/else
		
	    // Convert XML File to single line String for the expected response
	    String expectedResponse = null;
	    if (os.equals("Windows")) {
	    	expectedResponse = perform.stringBuilderFromFileTrimmed(driver, perform.filepathForAPIXMLFiles(driver)+"PlaceAppraisalOrderEx\\"+file2);
	    } else if (os.equals("Mac")) {
	    	expectedResponse = perform.stringBuilderFromFileTrimmed(driver, perform.filepathForAPIXMLFiles(driver)+"PlaceAppraisalOrderEx/"+file2);
	    } // end if/else
		
	    // Send the POST to PlaceAppraisalOrderEx and verify the response
	    perform.sendPostToPlaceAppraisalOrderEx(driver, sessionKey, xmlToCreateOrderWith, expectedResponse);
	    
		// Log test
		test.log(LogStatus.INFO, "Integration", "Tried to create an order and verified the IntegrationDeniedNACK error was returned");
		
	} // end integrationDeniedNACK

	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set variables</li>
	 * 	<li>Login and get the session key</li>
	 * 	<li>Set path to the XML file to place the order</li>
	 * 	<li>Convert XML File to single line String for the expected response</li>
	 * 	<li>Send the POST to PlaceAppraisalOrderEx and verify the response</li>
	 * 	<li>Log test</li>
	 * </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (groups={"Integrations", "API - Login", "API - PlaceAppraisalOrderEx"}, alwaysRun=true)
	public void globalAccountNACK() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		String os = StoredVariables.getos().get();
		
		// Set variables
		String user = "AutomationIntQATestingClient6";
		String file1 = "PlaceAppraisalOrderExLenderClientGroup4.xml";
		String file2 = "GlobalAccountNACK.xml";
		if (StoredVariables.getusernameEnvironment().get().equals("Live")) {
			user = "AutomationIntTestingClient6";
			file1 = "PlaceAppraisalOrderExLenderClientGroup4Live.xml";
			file2 = "GlobalAccountNACKLive.xml";
		} // end if Live
		
		// Login and get the session key
		String sessionKey = perform.apiLogin(driver, user, password);
		
		// Set path to the XML file to place the order
	    String xmlToCreateOrderWith = null;
	    if (os.equals("Windows")) {
	    	xmlToCreateOrderWith = perform.filepathForAPIXMLFiles(driver)+"PlaceAppraisalOrderEx\\"+file1;
	    } else if (os.equals("Mac")) {
	    	xmlToCreateOrderWith = perform.filepathForAPIXMLFiles(driver)+"PlaceAppraisalOrderEx/"+file1;
	    } // end if/else
		
	    // Convert XML File to single line String for the expected response
	    String expectedResponse = null;
	    if (os.equals("Windows")) {
	    	expectedResponse = perform.stringBuilderFromFileTrimmed(driver, perform.filepathForAPIXMLFiles(driver)+"PlaceAppraisalOrderEx\\"+file2);
	    } else if (os.equals("Mac")) {
	    	expectedResponse = perform.stringBuilderFromFileTrimmed(driver, perform.filepathForAPIXMLFiles(driver)+"PlaceAppraisalOrderEx/"+file2);
	    } // end if/else
		
	    // Send the POST to PlaceAppraisalOrderEx and verify the response
	    perform.sendPostToPlaceAppraisalOrderEx(driver, sessionKey, xmlToCreateOrderWith, expectedResponse);
		
		// Log test
		test.log(LogStatus.INFO, "Integration", "Tried to create an order and verified the GlobalAccountNACK error was returned");
		
	} // end globalAccountNACK
	
} // end the VMPRoundTrip class