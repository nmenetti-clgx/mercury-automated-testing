package baselineWebServices;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Baseline - Web Service Links</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class WebServiceLinks extends TestSetup {
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get the environment</li>
	 * 	<li>Set passed boolean</li>
	 * 	<li>Create the List</li>
	 * 	<li>Build the List of URL's to check depending on the environment</li>
	 * 	<li>url.add("https:wbsvcintqa.ad.mercuryvmp.com/mercury/ucdp.asmx");</li>
	 * 	<li>url.add("https:wbsvcintqa.ad.mercuryvmp.com/mercury/crmdata.asmx");</li>
	 * 	<li>url.add("https:wbsvcintqa.ad.mercuryvmp.com/mercury/smsinbound.asmx");</li>
	 * 	<li>url.add("https:wbsvcintqa.ad.mercuryvmp.com/mercury/productbilling.asmx");</li>
	 * 	<li>url.add("https:wbsvcintqa.ad.mercuryvmp.com/vendororder/vendororder.asmx");</li>
	 * 	<li>url.add("https:wbsvcintqa.ad.mercuryvmp.com/merchants/merchantssvc.asmx");</li>
	 * 	<li>url.add("https:wbsvcqa.mercuryvmp.com/mercurynetwork/ucdp.asmx");</li>
	 * 	<li>url.add("https:wbsvcqa.mercuryvmp.com/mercurynetwork/mobileservice.asmx");</li>
	 * 	<li>url.add("https:wbsvcqa.mercuryvmp.com/mercurydesktop/datacouriersvc.asmx");</li>
	 * 	<li>url.add("https:wbsvcqa.mercuryvmp.com/mercurydesktop/mercury.asmx");</li>
	 * 	<li>url.add("https:secure.mercuryvmpqa.com/");</li>
	 * 	<li>url.add("https:vendors.mercuryvmpqa.com/");</li>
	 * 	<li>url.add("https:automationqaregressionsecure15.vmpclientqa.com/SignIn.aspx");</li>
	 * 	<li>url.add("https:qaautotestpayments1.qavmpxsites.com/Admin/Wizard.aspx");</li>
	 * 	<li>url.add("https:wbsvcqa.mercuryvmp.com/MercuryNetwork/PlatinumDataReceive.aspx?ProductID=1&amp;ID=AC52B286-4F42-4755-9DAD-230CB4A7BF39&amp;ResultType=1");</li>
	 * 	<li>url.add("http:wbsvcqa.mercuryvmp.com/MercuryNetwork/MasterServReceive.aspx");</li>
	 * 	<li>url.add("https:wbsvcbetaint.ad.mercuryvmp.com/mercury/ucdp.asmx");</li>
	 * 	<li>url.add("https:wbsvcbetaint.ad.mercuryvmp.com/mercury/crmdata.asmx");</li>
	 * 	<li>url.add("https:wbsvcbetaint.ad.mercuryvmp.com/mercury/smsinbound.asmx");</li>
	 * 	<li>url.add("https:wbsvcbetaint.ad.mercuryvmp.com/mercury/productbilling.asmx");</li>
	 * 	<li>url.add("https:wbsvcbetaint.ad.mercuryvmp.com/vendororder/vendororder.asmx");</li>
	 * 	<li>url.add("https:wbsvcbetaint.ad.mercuryvmp.com/merchants/merchantssvc.asmx");</li>
	 * 	<li>url.add("https:wbsvcbeta.mercuryvmp.com/mercurynetwork/ucdp.asmx");</li>
	 * 	<li>url.add("https:wbsvcbeta.mercuryvmp.com/mercurynetwork/mobileservice.asmx");</li>
	 * 	<li>url.add("https:wbsvcbeta.mercuryvmp.com/mercurydesktop/datacouriersvc.asmx");</li>
	 * 	<li>url.add("https:wbsvcbeta.mercuryvmp.com/mercurydesktop/mercury.asmx");</li>
	 * 	<li>url.add("https:secure.mercuryvmpbeta.com/");</li>
	 * 	<li>url.add("https:vendors.mercuryvmpbeta.com/");</li>
	 * 	<li>url.add("https:automationbetaregressionsecure15.vmpclientbeta.com/SignIn.aspx");</li>
	 * 	<li>url.add("https:betaautotestpayments1.betavmpxsites.com");</li>
	 * 	<li>url.add("https:wbsvcbeta.mercuryvmp.com/MercuryNetwork/PlatinumDataReceive.aspx");</li>
	 * 	<li>url.add("https:wbsvcbeta.mercuryvmp.com/MercuryNetwork/MasterServReceive.aspx");</li>
	 * 	<li>url.add("https:wbsvcint.ad.mercuryvmp.com/mercury/ucdp.asmx");</li>
	 * 	<li>url.add("https:wbsvcint.ad.mercuryvmp.com/mercury/crmdata.asmx");</li>
	 * 	<li>url.add("https:wbsvcint.ad.mercuryvmp.com/mercury/smsinbound.asmx");</li>
	 * 	<li>url.add("https:wbsvcint.ad.mercuryvmp.com/mercury/productbilling.asmx");</li>
	 * 	<li>url.add("https:wbsvcint.ad.mercuryvmp.com/vendororder/vendororder.asmx");</li>
	 * 	<li>url.add("https:wbsvcint.ad.mercuryvmp.com/merchants/merchantssvc.asmx");</li>
	 * 	<li>url.add("https:wbsvc.mercuryvmp.com/mercurynetwork/ucdp.asmx");</li>
	 * 	<li>url.add("https:wbsvc.mercuryvmp.com/mercurynetwork/mobileservice.asmx");</li>
	 * 	<li>url.add("https:wbsvc.mercuryvmp.com/mercurydesktop/datacouriersvc.asmx");</li>
	 * 	<li>url.add("https:wbsvc.mercuryvmp.com/mercurydesktop/mercury.asmx");</li>
	 * 	<li>url.add("https:secure.mercuryvmp.com/");</li>
	 * 	<li>url.add("https:vendors.mercuryvmp.com/");</li>
	 * 	<li>url.add("https:automationliveregressionsecure15.vmpclient.com/SignIn.aspx");</li>
	 * 	<li>url.add("https:liveautotestpayments1.vmpxsites.com");</li>
	 * 	<li>url.add("https:wbsvc.mercuryvmp.com/MercuryNetwork/PlatinumDataReceive.aspx");</li>
	 * 	<li>url.add("https:wbsvc.mercuryvmp.com/MercuryNetwork/MasterServReceive.aspx");</li>
	 * 	<li>Check all URL's</li>
	 * 	<li>Check URL</li>
	 * 	<li>String statusCodeInfo = "The " + check + " link returned a status code of &gt;a href=\"https:httpstatuses.com/" + statusCode + "\" target=\"_blank\"&lt;" + statusCodeDetail;</li>
	 * 	<li>if status code does not equal 200</li>
	 * 	<li>Login and get the session key</li>
	 * 	<li>Verify tests passed</li>
* </ul>
	 *
	 * @throws Exception the exception
	 */
	// Check for broken links on a page
	@Test (groups={"Webservices"}, alwaysRun=true)
	public void checkForBrokenLinks() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Get the environment
		String env = StoredVariables.getusernameEnvironment().get();
		
		// Set passed boolean
		boolean passed = true;

		// Create the List
		List<String> url = new ArrayList<String>();
		
		// Build the List of URL's to check depending on the environment
		if (env.equals("QA")) {
			url.add("https://wbsvcintqa.ad.mercuryvmp.com/mercury/ucdp.asmx");
			url.add("https://wbsvcintqa.ad.mercuryvmp.com/mercury/crmdata.asmx");
			url.add("https://wbsvcintqa.ad.mercuryvmp.com/mercury/smsinbound.asmx");
			url.add("https://wbsvcintqa.ad.mercuryvmp.com/mercury/productbilling.asmx");
			url.add("https://wbsvcintqa.ad.mercuryvmp.com/vendororder/vendororder.asmx");
			url.add("https://wbsvcintqa.ad.mercuryvmp.com/merchants/merchantssvc.asmx");
			url.add("https://wbsvcqa.mercuryvmp.com/mercurynetwork/ucdp.asmx");
			url.add("https://wbsvcqa.mercuryvmp.com/mercurynetwork/mobileservice.asmx");
			url.add("https://wbsvcqa.mercuryvmp.com/mercurydesktop/datacouriersvc.asmx");
			url.add("https://wbsvcqa.mercuryvmp.com/mercurydesktop/mercury.asmx");
			url.add("https://secure.mercuryvmpqa.com/");
			url.add("https://vendors.mercuryvmpqa.com/");
			url.add("https://automationqaregressionsecure15.vmpclientqa.com/SignIn.aspx");
			url.add("https://qaautotestpayments1.qavmpxsites.com/Admin/Wizard.aspx");
			url.add("https://wbsvcqa.mercuryvmp.com/MercuryNetwork/PlatinumDataReceive.aspx?ProductID=1&ID=AC52B286-4F42-4755-9DAD-230CB4A7BF39&ResultType=1");
			url.add("https://wbsvcqa.mercuryvmp.com/MercuryNetwork/MasterServReceive.aspx");
		} // end if QA
		
//		if (env.equals("Beta")) {
//			url.add("https://wbsvcbetaint.ad.mercuryvmp.com/mercury/ucdp.asmx");
//			url.add("https://wbsvcbetaint.ad.mercuryvmp.com/mercury/crmdata.asmx");
//			url.add("https://wbsvcbetaint.ad.mercuryvmp.com/mercury/smsinbound.asmx");
//			url.add("https://wbsvcbetaint.ad.mercuryvmp.com/mercury/productbilling.asmx");
//			//url.add("https://wbsvcbetaint.ad.mercuryvmp.com/vendororder/vendororder.asmx");
//			url.add("https://wbsvcbetaint.ad.mercuryvmp.com/merchants/merchantssvc.asmx");
//			url.add("https://wbsvcbeta.mercuryvmp.com/mercurynetwork/ucdp.asmx");
//			url.add("https://wbsvcbeta.mercuryvmp.com/mercurynetwork/mobileservice.asmx");
//			url.add("https://wbsvcbeta.mercuryvmp.com/mercurydesktop/datacouriersvc.asmx");
//			url.add("https://wbsvcbeta.mercuryvmp.com/mercurydesktop/mercury.asmx");
//			url.add("https://secure.mercuryvmpbeta.com/");
//			url.add("https://vendors.mercuryvmpbeta.com/");
//			url.add("https://automationbetaregressionsecure15.vmpclientbeta.com/SignIn.aspx");
//			url.add("https://betaautotestpayments1.betavmpxsites.com");
//			//url.add("https://wbsvcbeta.mercuryvmp.com/MercuryNetwork/PlatinumDataReceive.aspx");
//			url.add("https://wbsvcbeta.mercuryvmp.com/MercuryNetwork/MasterServReceive.aspx");
//		} // end if Beta
		
		if (env.equals("Live")) {
			url.add("https://wbsvcint.ad.mercuryvmp.com/mercury/ucdp.asmx");
			url.add("https://wbsvcint.ad.mercuryvmp.com/mercury/crmdata.asmx");
			url.add("https://wbsvcint.ad.mercuryvmp.com/mercury/smsinbound.asmx");
			url.add("https://wbsvcint.ad.mercuryvmp.com/mercury/productbilling.asmx");
			url.add("https://wbsvcint.ad.mercuryvmp.com/vendororder/vendororder.asmx");
			url.add("https://wbsvcint.ad.mercuryvmp.com/merchants/merchantssvc.asmx");
			url.add("https://wbsvc.mercuryvmp.com/mercurynetwork/ucdp.asmx");
			url.add("https://wbsvc.mercuryvmp.com/mercurynetwork/mobileservice.asmx");
			url.add("https://wbsvc.mercuryvmp.com/mercurydesktop/datacouriersvc.asmx");
			url.add("https://wbsvc.mercuryvmp.com/mercurydesktop/mercury.asmx");
			url.add("https://secure.mercuryvmp.com/");
			url.add("https://vendors.mercuryvmp.com/");
			url.add("https://automationliveregressionsecure15.vmpclient.com/SignIn.aspx");
			url.add("https://liveautotestpayments1.vmpxsites.com");
			//url.add("https://wbsvc.mercuryvmp.com/MercuryNetwork/PlatinumDataReceive.aspx");
			url.add("https://wbsvc.mercuryvmp.com/MercuryNetwork/MasterServReceive.aspx");
		} // end if Live
		
		// Check all URL's
		for (String check : url) {
			
			// Check URL
			int statusCodeInt = perform.getResponseCode(check);
            String statusCode = Integer.toString(statusCodeInt);
            String statusCodeDetail = perform.getStatusCodeDetail(statusCode);
            String statusCodeInfo = "The " + check + " link returned a status code of <a href=\"https://httpstatuses.com/" + statusCode + "\" target=\"_blank\">" + statusCodeDetail;
            
            System.out.println("URL = " + check + "\nstatusCode = " + statusCode + "\n");
            
            // if status code does not equal 200
            if(!statusCode.equals("200")){
            	passed = false;
        		System.out.println(check + " returned a status code of " + statusCodeDetail);
        		test.log(LogStatus.FAIL, "check links", statusCodeInfo);
            } // end if statement for bad status codes
			
		} // end for loop
		
		// Login and get the session key
		String sessionKey = perform.apiLogin(driver, "automation"+StoredVariables.getusernameEnvironment().get()+"OriginatorEVFLender2", "T3sting1");

		// Verify tests passed
		Assert.assertTrue(passed==true, "There were errors in the HTTP responses");
		Assert.assertTrue(!sessionKey.isEmpty(), "The sessionKey is empty");
		
	} // end checkForBrokenLinks
	
} // end the WebServiceLinks class
