package userTools;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.LogStatus;

import setup.DriverFactory;
import setup.TestSetup;

// TODO: Auto-generated Javadoc
/**
 * The Class CheckForBrokenLinks.
 */
public class CheckForBrokenLinks extends TestSetup {
	
	/**
	 * ************************************************************************************************
	 * 
	 * Code used to check for broken links
	 * 
	 * ************************************************************************************************.
	 *
	 * @param urlString the url string
	 * @return the response code
	 * @throws MalformedURLException the malformed URL exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	
	// Gain the ability to capture the response codes
	public int getResponseCode(String urlString) throws MalformedURLException, IOException{
	    URL url = new URL(urlString);
	    HttpURLConnection huc = (HttpURLConnection)url.openConnection();
	    huc.setRequestMethod("GET");
	    huc.connect();
	    return huc.getResponseCode();
	} // end getResponseCode
	
	// Disable SSL Verification
	static {
	    disableSslVerification();
	}

	/**
	 * Disable ssl verification.
	 */
	// Disable SSL Verification
	private static void disableSslVerification() {
	    try
	    {
	        // Create a trust manager that does not validate certificate chains
	        TrustManager[] trustAllCerts = new TrustManager[] {new X509TrustManager() {
	            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
	                return null;
	            }
	            public void checkClientTrusted(X509Certificate[] certs, String authType) {
	            }
	            public void checkServerTrusted(X509Certificate[] certs, String authType) {
	            }
	        }
	        };

	        // Install the all-trusting trust manager
	        SSLContext sc = SSLContext.getInstance("SSL");
	        sc.init(null, trustAllCerts, new java.security.SecureRandom());
	        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

	        // Create all-trusting host name verifier
	        HostnameVerifier allHostsValid = new HostnameVerifier() {
	            public boolean verify(String hostname, SSLSession session) {
	                return true;
	            }
	        };

	        // Install the all-trusting host verifier
	        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
	    } catch (NoSuchAlgorithmException e) {
	        e.printStackTrace();
	    } catch (KeyManagementException e) {
	        e.printStackTrace();
	    }
	}
	
	/**
	 * Gets the status code detail.
	 *
	 * @param statusCode the status code
	 * @return the status code detail
	 */
	// Get the detailed info for http status codes
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
	 * Check for broken links.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Check for broken links on a page
	public void checkForBrokenLinks() throws IOException{
		
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Get all elements on the page with the tag of a
	    List<WebElement> links = driver.findElements(By.tagName("a"));
	    
	    // iterate through all elements
	    for(int i = 0; i < links.size(); i++){
	    	
	    	// if link isn't null or blank
	        if(!(links.get(i).getAttribute("href") == null) && !(links.get(i).getAttribute("href").equals(""))){
	        	
	        	// if link contains http
	            if(links.get(i).getAttribute("href").contains("http")){
	            	
	            	// set string values for links
	                int statusCodeInt = getResponseCode(links.get(i).getAttribute("href").trim());
	                String statusCode = Integer.toString(statusCodeInt);
	                String linkName = links.get(i).getText();
	                String statusCodeDetail = getStatusCodeDetail(statusCode);
	                String statusCodeInfo = "The " + linkName + " link returned a status code of <a href=\"https://httpstatuses.com/" + statusCode + "\" target=\"_blank\">" + statusCodeDetail + "</a> --- <a href=\"" + links.get(i).getAttribute("href") + "\" target=\"_blank\">" + links.get(i).getAttribute("href") + "</a>";
	                
	                System.out.println("linkName = " + links + "\tstatusCode = " + statusCode);
	                
	                // if status code does not start with a 2
	                if(!statusCode.startsWith("2")){
	                	// if status code starts with a 3 or 1, throw a warning
	                	if(statusCode.startsWith("3") || statusCode.startsWith("1")){
	                		System.out.println(linkName + " returned a status code of " + statusCodeDetail);
		                    test.log(LogStatus.WARNING, "check links", statusCodeInfo);
	                	} // end 3xx status code warnings
	                	// else, fail the link because it is broken
	                	else
	                	{
	                		System.out.println(linkName + " returned a status code of " + statusCodeDetail);
	                		test.log(LogStatus.FAIL, "check links", statusCodeInfo);
	                	} // end else for 1xx, 4xx and 5xx status codes
	                } // end if statement for bad status codes
	            } // end if statement for checking for http links
	        } // end if statement for null href values  
	    } // end for loop
	} // end checkForBrokenLinks
	
	/**************************************************************************************************
	 * 
	 * End code used to check for broken links
	 * 
	**************************************************************************************************/
	
}
