package setup;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
//import java.nio.file.Files;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.swing.JOptionPane;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.IClass;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import net.gpedro.integrations.slack.SlackApi;
import net.gpedro.integrations.slack.SlackMessage;
import utils.ExtentManager;
import utils.ExtentTestManager;
import utils.Function;
import utils.Function_CRM;
import utils.Function_DB;
import utils.Function_InternalTools;
import utils.Function_Performance;
import utils.Function_Secure;
import utils.Function_VMP;
import utils.Function_Vendors;
import utils.InitializeThreadSafeVariables;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
* <h1>Test Setup</h1>
* This class is responsible for setting up the test properties and variables, where the tests are supposed to run, reporting, 
* creating drivers to run the tests in, etc. are all done within this class.
* <p>
* 
* @author  Dustin Norman
* @since   05-16-2018
*/

@Listeners(utils.Listener.class)
public class TestSetup {
	
	/** The prop. */
	public static Properties prop;
	
	/** The extent. */
	public static ExtentReports extent;
	
	/** The test. */
	public static ExtentTest test;
	
	/** The secure. */
	public static Function_Secure secure = new Function_Secure();
	
	/** The vendors. */
	public static Function_Vendors vendors = new Function_Vendors();
	
	/** The vmp. */
	public static Function_VMP vmp = new Function_VMP();
	
	/** The db. */
	public static Function_DB db = new Function_DB();
	
	/** The perform. */
	public static Function perform = new Function();
	
	/** The crm. */
	public static Function_CRM crm = new Function_CRM();
	
	/** The performance. */
	public static Function_Performance performance = new Function_Performance();
	
	/** The it. */
	public static Function_InternalTools it = new Function_InternalTools();
	
	/** The init. */
	public static InitializeThreadSafeVariables init = new InitializeThreadSafeVariables();
	
	/**
	 * The afterSuite runs at the very end of the test run.
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Close Extent Reports</li>
	 * 	<li>Open the Extent Report if the variable is set to true</li>
	 * 	<li>Kill the Docker container if the test was ran in Docker</li>
	 * </ul>
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 * @throws URISyntaxException the URI syntax exception
	 */
	// Closes all drivers (eyes, selenium webdriver and extent reports)
	@AfterSuite(alwaysRun = true)
	public void afterSuite () throws IOException, InterruptedException, URISyntaxException {
		
		// Close extent reports
	    extent.flush();
		
		// Open the Extent Report if set to true
		if (StoredVariables.getopenReport().get().equals("true"))
		{
			String report = StoredVariables.getextentReportURL().get();
		    try {
		    	  Desktop desktop = java.awt.Desktop.getDesktop();
		    	  URI oURL = new URI(report);
		    	  desktop.browse(oURL);
		    	} catch (Exception e) {
		    	  e.printStackTrace();
		    	}
		} // end check to open report on script end
		
		// Stop Docker
		String environment = StoredVariables.getenvironment().get();
		if (StoredVariables.getuseLocalGrid().get().equals("docker")) {
			if (environment.equals("Sprint QA") || environment.equals("QA") || environment.equals("Beta") || environment.equals("Live")) {
				System.out.println("Killing Docker containers");
				if (StoredVariables.getos().get().equals("Windows")) {
					perform.runBatchFile(StoredVariables.getuserDir().get()+"\\Docker", "StopDocker.bat");
				} // end if
			} // end if environment
		} // end if docker
		
		/** Delete Chrome profile directory contents older than x minutes **/
		
//			// Get the OS
//			String os = System.getProperty("os.name");
//			
//			// Set the directory of the Chrome profiles
//			String directory = os.contains("Windows") ? "C:\\tmp\\chromeprofiles\\" : "/private/tmp/chromeprofiles/";
//			File dir = new File(directory);
//			
//			// Delete the Chrome profile directories
//			deleteChromeProfiles(dir, 180);
		
	    /** End delete of Chrome profile directory contents older than x minutes **/
		
		// Write to Slack channel
		if (environment.equals("This is a placeholder")) {
			SlackApi api = new SlackApi("https://hooks.slack.com/services/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 ");
			api.call(new SlackMessage("Test from MN Automation"));
		} // end write to slack
		
		// Clean ThreadSafe Variables
		try {
			init.cleanThreadLocals();
		} catch (Exception e) {}
		
	} // end teardown

	/**
	 * The beforeSuite method runs at the beginning of ever run. This is used to set up a lot of the variables to be used 
	 * throughout the tests.
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Initialize the ThreadSafe variables. - Since values set on a ThreadLocal object only are visible to the thread who set the value, no thread can set an initial value on a ThreadLocal 
	 * using set() which is visible to all threads.Instead you can specify an initial value for a ThreadLocal object by 
	 * subclassing ThreadLocal and overriding the initialValue() method</li>
	 * 	<li>Set the operating system (Windows/Mac)</li>
	 * 	<li>Get the user directory</li>
	 * 	<li>Set the directory that contains the AutoIT scripts</li>
	 * 	<li>Set the directory that contains test documents</li>
	 * 	<li>Set the default iteration - This is used to handle logging on tests that run more than one iteration</li>
	 * 	<li>Read the GlobalVariables.properties file to get information such as which environment to run in, which Selenium Grid to use, the browser, etc.</li>
	 * 	<li>Get the name of the project</li>
	 * 	<li>Set the environment the tests are to be ran in</li>
	 * 	<li>Set the Selenium Hub URL to connect to</li>
	 * 	<li>Set the debug option from the GlobalVariables.properties file</li>
	 * 	<li>Set the browser to be used</li>
	 * 	<li>Set variable to open Extent Reports after the tests finish</li>
	 * 	<li>Set the username environment (QA, Beta or Live)</li>
	 * 	<li>Set the Vendors URL</li>
	 * 	<li>Set the Secure URL</li>
	 * 	<li>Set the NexGen URL</li>
	 * 	<li>Set the VMP URL</li>
	 * 	<li>Set the Internal Tools URL</li>
	 * 	<li>Set the CRM URL</li>
	 * 	<li>Set the automation users' phone number prefix</li>
	 * 	<li>Set the database connection info (name and port number)</li>
	 * 	<li>Set the "catch all" domain to be used</li>
	 * 	<li>Set the global password</li>
	 * 	<li>Set the report name and get the current timestamp to add to the report name</li>
	 * 	<li>Set the report directory</li>
	 * 	<li>Set the screenshot directory</li>
	 * 	<li>Set the report filename</li>
	 * 	<li>Add the system info to the report log</li>
	 * 	<li>Get the location of the ExtentReport configuration .xml file</li>
	 * 	<li>Create a temp driver</li>
	 * 	<li>Set today's date</li>
	 * 	<li>Update the hosts file depending on where the test is being ran</li>
	 * 	<li>Check for unpaid invoices on automation accounts and take care of them</li>
	 * 	<li>Kill the temp driver</li>
	 * </ul>
	 *
	 * @param browserParam This is an optional param that can can be passed in when using Maven to set the browser
	 * @param environmentParam This is an optional param that can can be passed in when using Maven to set the environment the tests should run in
	 * @param debugParam This is an optional param that can can be passed in when using Maven to set whether or not to leave the window open on a failure
	 * @param buildNumber This is an optional param that can can be passed in when using Maven to set the build number when ran from Jenkins
	 * @param jobNameParam This is an optional param that can can be passed in when using Maven to set the job name when ran from Jenkins
	 * @param openReportParam This is an optional param that can can be passed in when using Maven to set whether or not to open the Extent Report when the tests finish
	 * @param localGridParam This is an optional param that can can be passed in when using Maven to determine which Selenium Hub to connect to
	 * @param ctx This is used to get the name of the test that called it
	 * @param emulatorParam This is an optional param that can can be passed in when using Maven to set the emulator name for Android tests
	 * @param versionParam This is an optional param that can be passed in when using Maven to set the version of the Android emulator being used
	 * @param enableSnapshotsParam the enable snapshots param
	 * @throws Exception the exception
	 */
	// Initialize Extent Reports, set the path for the report file, initialize global variables and open the browser
	@Parameters({"browserParam","environmentParam","debugParam","buildNumber","jobParam","openReportParam","localGridParam","emulatorParam","versionParam","enableSnapshotsParam"})
	@BeforeSuite(alwaysRun = true)
    public void beforeSuite(@Optional("") String browserParam, @Optional("") String environmentParam, @Optional("") String debugParam, @Optional("") String buildNumber, @Optional("") String jobNameParam, @Optional("") String openReportParam, @Optional("") String localGridParam, ITestContext ctx, @Optional("") String emulatorParam, @Optional("") String versionParam, @Optional("") String enableSnapshotsParam) throws Exception {

		// Initialize Thread Safe Variables
		init.initializeVariables();
		
		// Get operating system
		String os = System.getProperty("os.name");
		if (os.contains("Windows")) {
			os = "Windows";
		} else if (os.contains("Mac")) {
			os = "Mac";
		} // end if/else
		System.out.println("Operating System = " + os);
		StoredVariables.getos().set(os);
		
		// Get user directory
		StoredVariables.getuserDir().set(System.getProperty("user.dir"));
		System.out.println("userDir = " + StoredVariables.getuserDir().get());
		
		// Directory for AutoIT scripts
		if (os.equals("Windows")) {
			StoredVariables.getautoIT().set(StoredVariables.getuserDir().get()+"\\src\\main\\resources\\");
		} else if (os.equals("Mac")) {
			StoredVariables.getautoIT().set(StoredVariables.getuserDir().get()+"/src/main/resources/");
		} // end if/else
		
		// Directory for testDocuments and set directory slashes
		if (os.equals("Windows")) {
			StoredVariables.getdocDir().set(StoredVariables.getuserDir().get()+"\\src\\main\\resources\\testDocuments\\");
			StoredVariables.getdirSlashes().set("\\");
		} else if (os.equals("Mac")) {
			StoredVariables.getdocDir().set(StoredVariables.getuserDir().get()+"/src/main/resources/testDocuments/");
			StoredVariables.getdirSlashes().set("/");
		} // end if/else
		
		// Directory for apiXMLFiles
		if (os.equals("Windows")) {
			StoredVariables.getapiXMLFilesDir().set(StoredVariables.getuserDir().get()+"\\src\\main\\resources\\apiXMLFiles\\");
		} else if (os.equals("Mac")) {
			StoredVariables.getapiXMLFilesDir().set(StoredVariables.getuserDir().get()+"/src/main/resources/apiXMLFiles/");
		} // end if/else
		
		// Set default iteration
		StoredVariables.getiteration().set(0);
		
		// Read the global variables file
		String globalPropertiesFile = "";
		if (os.contains("Windows")) {
			globalPropertiesFile = StoredVariables.getuserDir().get()+"\\src\\main\\resources\\GlobalVariables.properties";
		} else if (os.equals("Mac")) {
			globalPropertiesFile = StoredVariables.getuserDir().get()+"/src/main/resources/GlobalVariables.properties";
		} // end if
		File file = new File(globalPropertiesFile);
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} // end try/catch
		Properties prop = new Properties();
	  
		// Load the global variables file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		} // end try/catch
		
		// Get the project name
		StoredVariables.getproject().set(prop.getProperty("project"));
		
		// Get and Set Environment
		String environment = "";
		// Check if a variable got passed in from Parameter, if it is not, read the GlobalProperties file
		if (environmentParam.equals("")) {
			environment = prop.getProperty("environment");
		} else {
			environment = environmentParam;
		} // end if/else
		System.out.println("Environment = " + environment);
		StoredVariables.getenvironment().set(environment);
		
		// Get useLocalGrid switch
		String localGrid = "";
		if (localGridParam.equals("")) {
			localGrid = prop.getProperty("useLocalGrid");
		} else {
			localGrid = localGridParam;
		} // end if/else
		StoredVariables.getuseLocalGrid().set(localGrid);
		
		// Set enable snapshot variable
		String enableSnapshots = "";
		if (enableSnapshotsParam.equals("")) {
			enableSnapshots = prop.getProperty("enableSnapshots");
		} else {
			enableSnapshots = enableSnapshotsParam;
		} // end if/else
		StoredVariables.getenableSnapshots().set(enableSnapshots);
		
		// Set mobile variable
		boolean mobile = false;
		if (localGrid.equals("android") || localGrid.equals("ios")) {
			mobile = true;
		} // end if
		StoredVariables.getmobile().set(mobile);
		
		// Create the Downloads directory if it doesn't exist
		String downloadsDirectory = "\\\\10.60.10.217\\c$\\Code\\VMP\\automatedtesting\\MercuryNetwork\\Downloads";
		if (localGrid.equals("true")) {
			downloadsDirectory = StoredVariables.getuserDir().get()+"\\Downloads";
			if (os.equals("Mac")) {
				downloadsDirectory = StoredVariables.getuserDir().get()+"/Downloads";
			} // end if Mac
		} // end if local grid is true
		perform.createDirectory(downloadsDirectory);
		StoredVariables.getdownloadsDir().set(downloadsDirectory);
		
		// Set the Hub URL
		// If trying to run with Docker on an environment that requires hosts file, set code to use the VM Grid
		System.out.println("localGrid = " + localGrid);
		if (localGrid.equals("true")) {
			StoredVariables.gethubURL().set("http://localhost:4444/wd/hub");			
		} else if (localGrid.equals("ios") || localGrid.equals("android")) {
			StoredVariables.gethubURL().set("http://127.0.0.1:4723/wd/hub");
		} else if (localGrid.equals("docker")) {
			if (environment.equals("QA") || environment.equals("Sprint QA") || environment.equals("Beta") || environment.equals("Live")) {
				System.out.println("Spinning up Docker containers");
				if (os.equals("Windows")) {
					perform.runBatchFile(StoredVariables.getuserDir().get()+"\\Docker", "StartDocker.bat");
				} else if (os.equals("Mac")) {
					// TODO Add shell script for Mac to start Docker
				} // end if/else
				StoredVariables.gethubURL().set("http://localhost:4442/wd/hub");
				Thread.sleep(5000);
			} else {
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog (null, "Docker cannot be used for tests on " + environment
						+ "\nAre you sure you want to connect to the VM Grid?\n\nSelect No to use the Local Grid","Use VM Grid",dialogButton);
				if(dialogResult == JOptionPane.YES_OPTION){
					System.out.println("Connecting to the VM Grid");
					StoredVariables.gethubURL().set(prop.getProperty("hubURL"));
				} // end if yes
				if(dialogResult == JOptionPane.NO_OPTION){
					  System.out.println("Connecting to the Local Grid");
					  StoredVariables.gethubURL().set("http://localhost:4444/wd/hub");
				} // end if no
			} // end if/else
		}/*end docker*/ 
		else if (localGrid.equals("sauce")) {
			StoredVariables.gethubURL().set("https://ondemand.saucelabs.com/wd/hub");
		} else {
			StoredVariables.gethubURL().set(prop.getProperty("hubURL"));
		} // end if/else
		
		// Set the IP address of the server
		StoredVariables.getserverIP().set("10.60.10.217");
		
		// Set the debug option
		String debug = "";
		if (debugParam.equals("")) {
			debug = prop.getProperty("debug");
		} else {
			debug = debugParam;
		} // end if/else
		StoredVariables.getdebug().set(debug);
		
		// Get and pass browser to stored variables
		String browser = "";
		if (browserParam.equals("")) {
			browser = prop.getProperty("browser");
		} else {
			browser = browserParam;
		} // end if/else
		StoredVariables.getbrowser().set(browser);
		System.out.println("Browser = " + browser);
		
		// Set running headless
		String headless = prop.getProperty("headless");
		StoredVariables.getheadless().set(headless);
		System.out.println("Headless = " + headless);
		
		// Get and pass switch to open extent reports after tests finish to stored variables
		String openReport = "";
		if (openReportParam.equals(""))	{
			openReport = prop.getProperty("openReport");
		} else {
			openReport = openReportParam;
		} // end if/else
		StoredVariables.getopenReport().set(openReport);
		System.out.println("openReport = " + StoredVariables.getopenReport().get());
		
		// Set the Android emulator and version
		if (localGrid.equals("android")) {
		
			// Get the Android Emulator name
			String emulator = "";
			if (emulatorParam.equals(""))	{
				emulator = prop.getProperty("emulator");
			} else {
				emulator = emulatorParam;
			} // end if/else
			StoredVariables.getemulator().set(emulator);
			
			// Get the Android Emulator version
			String version = "";
			if (versionParam.equals(""))	{
				version = prop.getProperty("version");
			} else {
				version = versionParam;
			} // end if/else
			StoredVariables.getversion().set(version);
		
		} // end if
		
		/***************************************
		 * ENVIRONMENTS
		 ***************************************
		 * Dev = Dev 
		 * QA = Sprint QA
		 * QA2 = Beta QA
		 * QA3 = Production QA
		 * Beta Push 1 = Sprint Staging
		 * Beta Push 2 = Beta Staging
		 * Beta = Beta
		 * Live Offline = Production Staging
		 * Live = Live
		***************************************/
		
		// Set username environment
		String usernameEnvironment = "";
		if (environment.equals("Dev") || environment.equals("QA") || environment.equals("Sprint QA") || environment.equals("Beta QA") || environment.equals("Production QA") || environment.equals("Dev") || environment.equals("Production QA") || environment.equals("QA2") || environment.equals("QA3") || environment.equals("NexGen")) {
			usernameEnvironment = "QA";
		} else if (environment.equals("Beta") || environment.equals("Sprint Staging") || environment.equals("Beta Staging") || environment.equals("Beta Push 1") || environment.equals("Beta Push 2")) {
			usernameEnvironment = "Beta";
		} else if (environment.equals("Live") || environment.equals("Production Staging") || environment.equals("Live Offline")) {
			usernameEnvironment = "Live";
		} // end if/else
		StoredVariables.getusernameEnvironment().set(usernameEnvironment);
		
		// Vendors site url
		String vendorsSite = perform.getVendorsSite(environment);
		StoredVariables.getvendorsSite().set(vendorsSite);
		
		// Secure site url
		String secureSite = perform.getSecureSite(environment);
		StoredVariables.getsecureSite().set(secureSite);
		
		// API url
		String apiURL = perform.getAPIURL(environment);
		StoredVariables.getapiURL().set(apiURL);
		
		// NexGen Secure site url
		String ngsecureSite = perform.ngsecureSite(environment);
		StoredVariables.getngsecureSite().set(ngsecureSite);
		
		// VMP site url suffix
		String vmpSiteSuffix = perform.getvmpSiteSuffix(environment);
		StoredVariables.getvmpSiteSuffix().set(vmpSiteSuffix);
		
		// Internal Tools site url
		String internalToolsSite = perform.getInternalToolsSite(environment);
		StoredVariables.getinternalToolsSite().set(internalToolsSite);
		
		// CRM site url
		String crmSite = perform.getCRMSite(environment);
		StoredVariables.getcrmSite().set(crmSite);
		
		// Set the userPhonePrefix
		String userPhonePrefix = "";
		if (usernameEnvironment.equals("QA")) {
			userPhonePrefix = "111";
		} else if (usernameEnvironment.equals("Beta")) {
			userPhonePrefix = "222";
		} else if (usernameEnvironment.equals("Live")) {
			userPhonePrefix = "333";
		} // end if/else
		StoredVariables.getuserPhonePrefix().set(userPhonePrefix);
		
		// Get database login info
		String dbName = "";
		String dbPort = "";
		
		if (!usernameEnvironment.equals("QA")) {
			dbName = "sql1.ad.mercuryvmp.com";
			dbPort = "1433";
		} else {
			dbName = "sql1qa.ad.mercuryvmp.com";
			dbPort = "1433";
		} // end if/else
		StoredVariables.getdbName().set(dbName);
		StoredVariables.getdbPort().set(dbPort);
		
		// Set the username and password for the SQL Server connection if on a Mac
		if (StoredVariables.getos().get().equals("Mac")) {
			
			// Get encrypted text
			String directoryPath = System.getProperty("user.home")+"/DBConnection/";
			String encryptedUsername = perform.readTextFileToAString(directoryPath, "User.txt");
			String encryptedPassword = perform.readTextFileToAString(directoryPath, "PW.txt");
			String passwordForEncryption = perform.readTextFileToAString(directoryPath, "PWPW.txt");
			
			// Decrypt username and pw for db
			StoredVariables.getdbUser().set(perform.decrypt(passwordForEncryption, encryptedUsername));
			StoredVariables.getdbPW().set(perform.decrypt(passwordForEncryption, encryptedPassword));
			
		} // end if Mac
		
		// Set and Pass Catch All Domain to stored variables
		StoredVariables.getcatchAllDomain().set(prop.getProperty("catchAllDomain"));
		
		// Set and Pass test users password to stored variables
		StoredVariables.getpassword().set(prop.getProperty("password"));
		
		// Set the report name and timestamp
		String reportName = ctx.getCurrentXmlTest().getSuite().getName();
		if (reportName.equals("Default suite")) {
			List<ITestNGMethod> allMethods = ctx.getSuite().getAllMethods();
			for (ITestNGMethod method : allMethods)	{
				String fullMethod = method.toString();
				int indexOf = fullMethod.indexOf(".");
				reportName = fullMethod.replace(fullMethod.substring(indexOf), "");
			} // end for
		} // end if
		String timeStamp = new SimpleDateFormat("HH.mm.ss").format(new Date());
		StoredVariables.gettimeStamp().set(timeStamp);
		
		// Set and Pass Report Directory to stored variables
		String reportDir = reportName+"-"+environment+"-"+timeStamp;
		String reportPath = "";
		if (os.equals("Mac")) {
			reportPath = "/Volumes/AutomationSite/SeleniumTestResults/MercuryNetwork/"+reportDir;
			if (localGrid.equals("docker")) {
				reportPath = StoredVariables.getuserDir().get().replace(StoredVariables.getproject().get(), "") + "SeleniumTestResults/"+reportDir;
			} // end if
		} else if (os.contains("Windows")) {
			if (localGrid.equals("true")) {
				reportPath = "\\\\"+StoredVariables.getserverIP().get()+"\\c$\\AutomationSite\\SeleniumTestResults\\MercuryNetwork\\"+reportDir;
			} else if (localGrid.equals("docker")) {
				reportPath = StoredVariables.getuserDir().get().replace(StoredVariables.getproject().get(), "") + "SeleniumTestResults\\"+reportDir;
			} 
			else {
				reportDir = reportName+"-"+environment+"-"+buildNumber;
				reportPath = "\\\\"+StoredVariables.getserverIP().get()+"\\c$\\AutomationSite\\SeleniumTestResults\\MercuryNetwork\\"+reportDir;
			} // end if/else
		} // end setting the report path
		StoredVariables.getreportPath().set(reportPath);
		StoredVariables.getreportDir().set(reportDir);
		
		// Set and Pass Screenshot Directory to stored variables
		String screenshotFolder = "";
		if (os.contains("Windows"))	{
			screenshotFolder = "\\Screenshots";
		} else {
			screenshotFolder = "/Screenshots";
		} // end if/else
		StoredVariables.getscreenshotPath().set(reportPath + screenshotFolder);
		new File(StoredVariables.getscreenshotPath().get()).mkdirs();
		
		// Leave a blank line in the console before the tests execute
		System.out.println("");
		
		// Set Extent Report file name from the global properties file
		String extentReportPath = "";
		if (os.equals("Mac")) {
			extentReportPath = reportPath + "/index.html";
		} else if (os.contains("Windows")) {
			extentReportPath = reportPath + "\\index.html";
		} // end if/else
		
		// Pass extent report file name and path to stored variables
		StoredVariables.getextentReportPath().set(extentReportPath);
		
		// Set the Extent Report URL
		String reportURL = "http://"+StoredVariables.getserverIP().get()+":897/SeleniumTestResults/MercuryNetwork/" + StoredVariables.getreportDir().get().replace(" ", "%20") + "/index.html";
		StoredVariables.getextentReportURL().set(reportURL);
		
		extent = ExtentManager.getReporter(extentReportPath);
		
        // Add System Info to report
        extent
            .addSystemInfo("Environment", environment)
            .addSystemInfo("Browser", browser);
			
		// Get the path for the extent-config.xml file
        String extentConfigPath = null;
        if (os.equals("Mac")) {
        	extentConfigPath = StoredVariables.getuserDir().get()+"/extent-config.xml";
        } else if (os.contains("Windows")) {          	
        	extentConfigPath = StoredVariables.getuserDir().get()+"\\extent-config.xml";
        } // end if/else
        
        extent.loadConfig(new File(extentConfigPath));
        
		// Switch to correct hosts file if running the tests locally
		if (localGrid.equals("true")) {
			System.out.println("Set hosts file to " + environment);
			String hostFile = "";
			if (environment.equals("QA") || environment.equals("Sprint QA")|| environment.equals("Beta") || environment.equals("Live")) {
				hostFile = "No";
			} else if (environment.equals("Dev")) {
				hostFile = "Dev";
			} else if (environment.equals("QA2") || environment.equals("Beta QA")) {
				hostFile = "QA2";
			} else if (environment.equals("QA3") || environment.equals("Production QA")) {
				hostFile = "QA3";
			} else if (environment.equals("Beta Push 1") || environment.equals("Sprint Staging")) {
				hostFile = "BetaPush1";
			} else if (environment.equals("Beta Push 2") || environment.equals("Beta Staging")) {
				hostFile = "BetaPush2";
			} else if (environment.equals("Live Offline") || environment.equals("Production Staging")) {
				hostFile = "LiveOffline";
			} // end if/else
			if (!environment.equals("NexGen") && !os.equals("Mac")) {
				// Run batch file to switch hosts file
				String batchFile = hostFile+"HostsSwitcher.bat - Shortcut.lnk";
				System.out.println("batchFile = " + batchFile);
				perform.runBatchFile("C:\\Code\\VMP\\automatedtesting\\MercuryNetwork\\src\\main\\resources\\hostFiles", batchFile);
				System.out.println("Finished running batch file to modify the hosts file");
			} // end if
		} // End setting the hosts file
		
		// Create driver
		if (localGrid.equals("true") || localGrid.equals("false") || localGrid.equals("docker")) {
	        RemoteWebDriver driver = null;
	    	int d = 1;
			while (d < 50) {
		        try {
		        	driver = DriverFactory.getInstance().getDriver();
		        	break;
				} catch (WebDriverException e) {
					Thread.sleep(1000);
					d++;
				} // end try/catch
			} // end while
			
			// Get todays date
			perform.getTodaysDate(driver);
			System.out.println("Today's date = " + StoredVariables.gettodaysDateLong().get());
	        
			// Check for unpaid invoices
			if (prop.getProperty("checkUnpaidInvoices").equals("yes")) {
		    	System.out.println("Checking for unpaid invoices");
		    	db.checkForUnpaidInvoices(driver);
			} // end if
	    	
	    	// Kill temp driver
	    	DriverFactory.getInstance().removeDriver();
		} // end if not ios or android
		
    } // end setup
	
	/**
	* The beforeMethod runs at the beginning of every Test method.
	* <p>
	* STEPS:
	* <ul>
	* 	<li>Create a new driver</li>
	* 	<li>Use LocalFileDetector to detect files on the local disk</li>
	* 	<li>Set the implicit wait time</li>
	* 	<li>Set the window size</li>
	* 	<li>Maximize the window</li>
	* 	<li>Print the thread number to the console</li>
	* 	<li>Get the iteration of the test</li>
	* 	<li>Start the logging for the test method</li>
	* </ul>
	* @param method Used to get the name of the method being called
	 * @throws Exception the exception
	*/
	// Start Extent Report test
	@BeforeMethod(alwaysRun = true)
    protected void beforeMetod(Method method) throws Exception {
		
		// Create driver
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		perform.manageDriver(driver);
		String localGrid = StoredVariables.getuseLocalGrid().get();
		
		// Add job name if using Sauce Labs
		if (localGrid.equals("sauce")) {
			((JavascriptExecutor)driver).executeScript("sauce:job-build=Mercury Network Automation");
		} // end if sauce
		
		// Add test name if using Sauce Labs
		if (localGrid.equals("sauce")) {
			((JavascriptExecutor)driver).executeScript("sauce:job-name="+method.getDeclaringClass().toString()+"."+method.getName());
		} // end if sauce
		
		// Set the current date
		perform.getTodaysDate(driver);
		
		// Print out the thread number
 		long id = Thread.currentThread().getId();
		
		// Get iteration for quote entry scripts
		int a = StoredVariables.getiteration().get()+1;
		
		// Do not append the iteration if it is 0
		if (a<2) {
			// Start the extent report test logging
			System.out.println("Starting test: " + method.getName() + " - Thread " + id);
			ExtentTest test = ExtentTestManager.startTest("Thread " + id + " - " + method.getName() + " - " + method.getDeclaringClass().toString());
	        test.assignCategory(method.getDeclaringClass().toString());
		} else {
			// Start the extent report test logging
			System.out.println("Test = " + method.getName() + " " + a + " - Thread = " + id);
			ExtentTest test = ExtentTestManager.startTest("Thread " + id + " - " + method.getName() + " - " + method.getDeclaringClass().toString() + " " + a);
	        test.assignCategory(method.getDeclaringClass().toString());
		} // end if/else
		
    } // end beforeMethod
	
	/**
	 * The afterMethod runs at the end of every Test method.
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get the ExtentTest session</li>
	 * 	<li>Get the driver</li>
	 * 	<li>Get the thread id</li>
	 * 	<li>Get the test name</li>
	 * 	<li>Set the operating system</li>
	 * 	<li>Get the test iteration</li>
	 * 	<li>Get the screenshot path to store screenshots</li>
	 * 	<li>Get the current timestamp to append to the screenshot filename</li>
	 * 	<li>Set the screenshot filename</li>
	 * 	<li>Take a screenshot</li>
	 * 	<li>Attach the screenshot to the Extent Report</li>
	 * 	<li>Write the test status to the report (Pass, Fail, Skip, etc)</li>
	 * 	<li>Send an email if the test failed</li>
	 * 	<li>End logging for the test</li>
	 * 	<li>Leave the browser open if the debug variable is set to true</li>
	 * </ul>
	 *
	 * @param result Used to get the status of the test run
	 * @param method Used to get the name of the method being called
	 * @throws Exception the exception
	 */
	// Take a screenshot and add it as well as write the results of the tests to extent reports at the end of each test
	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult result, Method method) throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		String env = StoredVariables.getenvironment().get();
		
		// Get thread id
 		long id = Thread.currentThread().getId();
 		
		// Get the test name that failed
		IClass cls = result.getTestClass();
		String failure = cls.getName() + "-" + method.getName();
		
		// Get the package and class name
		String pkg = result.getTestClass().getRealClass().getPackage().getName();
		String cs = result.getTestClass().getRealClass().getSimpleName();
//		String methodName = result.getMethod().getMethodName();
		
		// Set the operating system
		String os = StoredVariables.getos().get();
		
		// Set the JavaDoc directory path
		String javadocPath = "http://"+StoredVariables.getserverIP().get()+":897/mercury_javadoc/" + pkg + "/" + cs + ".html";
		
		// Add the Javadoc file to the log
		test.log(LogStatus.INFO, "JavaDoc", "Open <a href=\"" + javadocPath + "\">JavaDoc</a>");
		
		// Do not log JS errors on mobile
		String localGrid = StoredVariables.getuseLocalGrid().get();
		if (localGrid.equals("ios") || localGrid.equals("android")) {} else {
			// Log the JS Errors from the test run
			String jsErrors = perform.extractJSLogs(driver);
			if (!jsErrors.isEmpty()) {
				test.log(LogStatus.UNKNOWN, "JS Errors", jsErrors);
			} // end if jsErrors is not empty
		} // end if Windows
		
		// Get iteration for quote entry scripts
		int a = StoredVariables.getiteration().get();
		
		// Get path to the screenshots folder
		String screenshotPath = StoredVariables.getscreenshotPath().get();
		
		// Get the current time stamp
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); 

		// Set the screenshot name
		if (os.equals("Windows")) {
			StoredVariables.getscreenshotImage().set(screenshotPath + "\\" + result.getName() + "_" + timeStamp + ".png");
		} else if (os.equals("Mac")) {
			StoredVariables.getscreenshotImage().set(screenshotPath + "/" + result.getName() + "_" + timeStamp + ".png");
		} // end if/else
		
		// Set the screenshot URL
		StoredVariables.getscreenshotURL().set("http://"+StoredVariables.getserverIP().get()+":897/SeleniumTestResults/MercuryNetwork/" + StoredVariables.getreportDir().get() + "/Screenshots/" + result.getName() + "_" + timeStamp + ".png");
		
		// Set the browser being used
		String browser = StoredVariables.getbrowser().get();
		if (!browser.equals("HtmlUnit")) {
			if (!StoredVariables.getuseLocalGrid().get().equals("android")) {
				
				// Take screenshot and store as a file format
				File src = null;
				try {
					src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				} catch (WebDriverException e) {
					System.out.println("Could not take screenshot");
				} // end try/catch
				
				if (a<1) {
	
					try {
						if (!src.equals(null)) {
							FileUtils.copyFile(src, new File(StoredVariables.getscreenshotImage().get()));
						} // end if
					} catch (Exception e) {
						e.printStackTrace();
					} // end try/catch
			        
					// Add screenshot to report
					test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture(StoredVariables.getscreenshotURL().get()));
					
				} else {
					
					try {
						if (!src.equals(null)) {
							FileUtils.copyFile(src, new File(StoredVariables.getscreenshotImage().get()));
						} // end if
					} catch (Exception e) {
						e.printStackTrace();
					} // end try/catch
					
					// Add screenshot to report
					test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture(StoredVariables.getscreenshotURL().get()));
	
				} // end else
				
			} // end if android
			
		} // end if browser not HtmlUnit
		
		String resultStatus = "";
		// Write passing tests to Extent Reports
		if (result.getStatus() == ITestResult.SUCCESS) {
	      	test.log(LogStatus.PASS, "<span class='label success'>" + result.getName() + "</span>");
	      	resultStatus = "Passed";
	      	StoredVariables.getfailedTest().set(false);
      	} // end if 
		
		// Write failing tests to Extent Reports
	    if (result.getStatus() == ITestResult.FAILURE) {
	    	
	    	perform.addInfoToExtentReport(driver, "Screen URL", driver.getCurrentUrl());
	    	
	    	test.log(LogStatus.FAIL, "<span class='label failure'>" + result.getName() + "</span>", "<pre>Failure:\n" + result + "\n\n" + result.getThrowable().getMessage() + "</pre>");
			
	    	// Set the stacktrace to a String
			StringWriter sw = new StringWriter(); 
	        result.getThrowable().printStackTrace(new PrintWriter(sw)); 
	        String stacktrace = sw.toString();
	    	
	        // Write the stack trace to extent reports
	        test.log(LogStatus.INFO, "<span class='label failure'>" + result.getName() + "</span>", "<pre>Stacktrace:\n" + stacktrace + "</pre>");
	    	
	        // Set the test result status to Failed
	      	resultStatus = "Failed";
	      	StoredVariables.getfailedTest().set(true);
	      	
	        // Save a duplicate failure screenshot and name it a static name to attach to email
	      	if (!StoredVariables.getuseLocalGrid().get().equals("android")) {
	      		
	      		boolean screenshot = true;
				File src = null;
				try {
					src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				} catch (WebDriverException e) {
					System.out.println("Could not take screenshot");
					screenshot = false;
				} // end try/catch
				if (screenshot == true) {
			        try {
			        	if (os.equals("Windows") && !src.equals(null)) {
			        		FileUtils.copyFile(src, new File(screenshotPath + "\\Failure.png"));
			        	} else if (os.equals("Mac") && !src.equals(null)) {
			        		FileUtils.copyFile(src, new File(screenshotPath + "/Failure.png"));
			        	} // end if/else
					} catch (IOException e1) {
						e1.printStackTrace();
						System.out.println(e1.getMessage());
					} // end try/catch
				} // end if screenshot is true
		        
	      	} // end if android

	      	// Send an email
			System.out.println("Sending mail...");
			
			// Set the subject
			String subject = "Failed test on "+StoredVariables.getenvironment().get()+": " + failure;
			
			// Set the text
			String text = "<h2>Failed test on "+ env + ": " + failure + "</h2>"
	        		+ "<body>"+StoredVariables.getextentReportURL().get()+"<br><br>Screen URL: "+driver.getCurrentUrl()+"<br><br><strong>Cause of the failure:</strong></br>"+result.getThrowable().getMessage()+"</body><p>"
	        		+ "<strong>Screenshot at the time of the failure:</strong></br>"
	        		+ "<img src=\""+StoredVariables.getscreenshotURL().get()+"\" alt=\"Failed Test\"/><p><strong>Stacktrace:</strong></br>" + stacktrace;
			
			// Set the TO recipients
			String to = "dnorman@corelogic.com,keriley@corelogic.com";
	        if (env.equals("Beta") || env.equals("Live")) {
	        	System.out.println("");
	        	to = "dnorman@corelogic.com,keriley@corelogic.com";
	        } // end if
	        
	        perform.sendEmail(driver, to, "", subject, text);
	        
	    } // end if Failure 
	    
		// Write skipped tests to Extent Reports
	    if (result.getStatus() == ITestResult.SKIP) {
	    	test.log(LogStatus.SKIP, "<span class='label info'>" + result.getName() + "</span>", "<pre>" + result.getThrowable().getMessage() + "</pre>");
			// Set the stacktrace to a String
			StringWriter sw = new StringWriter(); 
	        result.getThrowable().printStackTrace(new PrintWriter(sw)); 
	        String stacktrace = sw.toString();
	    	// Write the stack trace to extent reports
	        test.log(LogStatus.INFO, "<span class='label failure'>" + result.getName() + "</span>", "<pre>Stacktrace:\n" + stacktrace + "</pre>");
	    	resultStatus = "Skipped";
	    	StoredVariables.getfailedTest().set(false);
	    } // end if
		
	    System.out.println("TEST RESULT: " + method.getName() + " - Thread " + id + " = " + resultStatus);
		
		Thread.sleep(1000);
		
		extent.endTest(test);
		
		if (driver != null)
		{
			if (resultStatus.equals("Failed") && StoredVariables.getdebug().get().equals("true")){
				System.out.println("Leave browser open to debug the failure");
			} else {
				//Gets browser logs if available.
				if (localGrid.equals("sauce")) {
					((JavascriptExecutor)driver).executeScript("sauce:job-result=" + (result.isSuccess() ? "passed" : "failed"));
				} // end if sauce
				DriverFactory.getInstance().removeDriver();				
			} // end else
		} // end if
		
		System.out.println("");
		
	} // end afterMethod
	
	/**
	 * The beforeClass runs before every class.
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Currently does not contain any steps</li>
	 * </ul>
	 *
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws InterruptedException, IOException {
		
  	} // end beforeClass
	
	/**
	* The afterClass runs at the end of every class.
	* <p>
	* STEPS:
	* <ul>
	* 	<li>Currently does not contain any steps</li>
	* </ul>
	*/
	// Close browser and quit the driver
 	@AfterClass(alwaysRun = true)
 	public void afterClass() {
 		
 	} // end afterClass
 	
	// Disable SSL Verification
	static {
	    disableSslVerification();
	} // end disableSslVerification

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
	        } // end trustAllCerts
	        }; // end newX509TrustManager

	        // Install the all-trusting trust manager
	        SSLContext sc = SSLContext.getInstance("SSL");
	        sc.init(null, trustAllCerts, new java.security.SecureRandom());
	        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

	        // Create all-trusting host name verifier
	        HostnameVerifier allHostsValid = new HostnameVerifier() {
	            public boolean verify(String hostname, SSLSession session) {
	                return true;
	            } // end verify
	        }; // end allHostsValid

	        // Install the all-trusting host verifier
	        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
	    } catch (NoSuchAlgorithmException e) {
	        e.printStackTrace();
	    } catch (KeyManagementException e) {
	        e.printStackTrace();
	    } // end try/catch/catch
	    
	} // end disableSslVerification
	
//	/**
//	 * Delete Chrome profiles.
//	 *
//	 * @param folder the folder
//	 * @param olderThanMinutes the older than minutes
//	 * @throws IOException Signals that an I/O exception has occurred.
//	 */
//	public static void deleteChromeProfiles(File folder, int olderThanMinutes) throws IOException {
//		String[] directories = folder.list(new FilenameFilter() {
//			
//			/* (non-Javadoc)
//			 * @see java.io.FilenameFilter#accept(java.io.File, java.lang.String)
//			 */
//			@Override
//			public boolean accept(File current, String name) {
//				return new File(current, name).isDirectory();
//			}
//		});
//		for (String dir : directories) {
//			File directory = new File(folder + "/" +dir);
//			Path directoryPath = directory.toPath();
//
//			if (getDirOlderThanMinutes(directoryPath, -olderThanMinutes)) {
//				System.out.println("remove -> " + directoryPath);
//				try {
//					removeDirectory(directoryPath);
//					System.out.println("ok");
//				} catch (IOException e) {
//					System.out.println("error: " + e);
//				}
//			} else {
//				continue;
//			}
//		};
//		
//		//System.out.println(Arrays.toString(directories));
//		
//	} // end deleteChromeProfiles
//
//	/**
//	 * Gets the directory older than minutes.
//	 *
//	 * @param directoryPath the directory path
//	 * @param timeMinutes the time minutes
//	 * @return the directory older than minutes
//	 * @throws IOException Signals that an I/O exception has occurred.
//	 */
//	private static boolean getDirOlderThanMinutes (
//			Path directoryPath, Integer timeMinutes) throws IOException {
//		
//		BasicFileAttributes attr = Files.readAttributes(
//				directoryPath, BasicFileAttributes.class);
//		System.out.println("creationTime: " + attr.creationTime());
//		Calendar calendarNow = Calendar.getInstance();
//		calendarNow.add(Calendar.MINUTE, timeMinutes);
//		java.util.Date dateCreationDirTime = new java.util.Date(
//				attr.creationTime().toMillis() );
//		Calendar calendarDir = Calendar.getInstance();
//		calendarDir.setTime(dateCreationDirTime);
//		
//		return calendarNow.compareTo(calendarDir) > -1;
//		
//	} // end getDirOlderThanMinutes
//
//	/**
//	 * Removes the directory.
//	 *
//	 * @param directoryPath the directory path
//	 * @throws IOException Signals that an I/O exception has occurred.
//	 */
//	private static void removeDirectory(Path directoryPath)
//			throws IOException {
//		Files.walkFileTree(directoryPath, new SimpleFileVisitor<Path>() {
//			public FileVisitResult visitFile(
//					Path file, BasicFileAttributes attrs) throws IOException {
//				Files.delete(file);
//				return FileVisitResult.CONTINUE;
//			}
//			public FileVisitResult postVisitDirectory(
//					Path dir, IOException exc) throws IOException {
//				Files.delete(dir);
//				return FileVisitResult.CONTINUE;
//			}
//		});
//	} // end removeDirectory

} // end TestSetup class
