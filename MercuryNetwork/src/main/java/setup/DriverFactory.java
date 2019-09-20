package setup;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
//import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Listeners;

import utils.Function;
import utils.StoredVariables;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

// TODO: Auto-generated Javadoc
/**
 * <h1>Driver Factory</h1>
 * This is where the driver gets built and managed in each instance.
 * <p>
 * STEPS:
 * <ul>
 * 	<li>Set the browser to use</li>
 * 	<li>Set the environment to run the tests in</li>
 * 	<li>Set the version of the Selenium Node based on the environment</li>
 * 	<li>Set the Selenium Hub URL</li>
 * 	<li>Set the user directory</li>
 * 	<li>Set the project name</li>
 * 	<li>Get the operating system</li>
 * 	<li>Set the DesiredCapabilities and ChromeOptions to be used when creating the driver</li>
 * 	<li>Set the driver</li>
 * </ul>
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class DriverFactory {
	
	/** The perform. */
	public static Function perform = new Function();

	/**
	 * Instantiates a new driver factory.
	 */
	private DriverFactory() 
	{
		//Do-nothing..Do not allow to initialize this class from outside
	}

	/** The instance of the driver */
	private static DriverFactory instance = new DriverFactory();

	/**
	 * Get the instance of the driver
	 * @return single instance of DriverFactory
	 */
	public static DriverFactory getInstance()
	{
		return instance;
	}
	
	

	/** The ThreadLocal driver */
	ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>() // thread local driver object for webdriver
			{

		@SuppressWarnings("deprecation")
		@Override
		protected RemoteWebDriver initialValue()
		{

			String browser = StoredVariables.getbrowser().get();
			String env = StoredVariables.getenvironment().get();
			String localGrid = StoredVariables.getuseLocalGrid().get();

			// Set DesiredCapabilities
			DesiredCapabilities dc = new DesiredCapabilities();

			// Set ChromeOptions
			ChromeOptions options = new ChromeOptions();
			
			// Set FirefoxOptions
			//				FirefoxOptions ffOptions = new FirefoxOptions();

			String node = env.replace(" ", "");
			if (!localGrid.equals("docker") || !localGrid.equals("ios") || !localGrid.equals("sauce")) {

				if (localGrid.equals("true"))
				{
					node = "Local";
				}
				else if (env.equals("Sprint QA") || env.equals("QA"))
				{
					node = "QA";
				}
				else if (env.equals("Beta"))
				{
					node = "Beta";
				}
				else if (env.equals("Live"))
				{
					node = "Live";
				}
				else if (env.equals("Beta QA") || env.equals("Production QA") || env.equals("Dev") || env.equals("QA2") || env.equals("QA3"))
				{
					node = "QA2";
				}
				else if (env.equals("Sprint Staging") || env.equals("Beta Push 1"))
				{
					node = "BetaPush1";
				}
				else if (env.equals("Beta Staging") || env.equals("Beta Push 2"))
				{
					node = "BetaPush2";
				}
				else if (env.equals("Production Staging") || env.equals("Live Offline"))
				{
					node = "LiveOffline";
				}
				options.setCapability("version", node);
				dc.setCapability("version", node);
				System.out.println("Node = " + node);
			} // end if

			// Get other variables
			String hubURL = StoredVariables.gethubURL().get();
			String userDir = StoredVariables.getuserDir().get();
			String project = StoredVariables.getproject().get();
			System.out.println("hubURL = " + hubURL);

			// Get operating system
			String os = System.getProperty("os.name");
			if (os.contains("Windows"))
			{
				os = "Windows";
			} else if (os.contains("Mac")) {
				os = "Mac";
			} // end if/else
			
			// Set the file download location
			String downloadFilepath = StoredVariables.getdownloadsDir().get();
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		       chromePrefs.put("profile.default_content_settings.popups", 0);
		       chromePrefs.put("download.default_directory", downloadFilepath);

		    if (localGrid.equals("sauce")) {

		    	// Set the directory for the credentials
		    	String directoryPath = System.getProperty("user.home")+"/Code/VMP/SauceLabs/";
		    	String username = null;
		    	String accesskey = null;
		    	
		    	// Get the Sauce Labs credentials
		    	try {
		    		
		    		// Get encrypted text
					String encryptedUsername = perform.readTextFileToAString(directoryPath, "user.txt");
					String encryptedAccessKey = perform.readTextFileToAString(directoryPath, "accesskey.txt");
					String passwordForEncryption = perform.readTextFileToAString(directoryPath, "PWPW.txt");
					
					// Decrypt user and accesskey for sauce labs
					username = perform.decrypt(passwordForEncryption, encryptedUsername);
					accesskey = perform.decrypt(passwordForEncryption, encryptedAccessKey);
					
		    	} catch (Exception e) {
		    		
					System.out.println("Could not set Sauce Labs credentials");
					
				} // end try/catch
		    	
		        // Create a map of capabilities called "sauce:options", which contain the info necessary to run on Sauce Labs
		        MutableCapabilities sauceOptions = new MutableCapabilities();
		        sauceOptions.setCapability("username", username);
		        sauceOptions.setCapability("access-key", accesskey);
		      	//sauceOptions.setCapability("seleniumVersion", "3.141.59");
		      	//sauceOptions.setCapability("build", "parallel-TestNG-single-browser-demo");
	  
		      	// Set browser capabilites
		    	dc = DesiredCapabilities.chrome();
		    	dc.setCapability("platform", "Windows 10");
		    	dc.setCapability("version", "75.0");
		    	dc.setCapability("screenResolution", "1280x1024");
		    	dc.setCapability("recordVideo", "false");
		    	
		        // Assign the Sauce Options to the base capabilities
		      	dc.setCapability("sauce:options", sauceOptions);
		    	
		    } else if (localGrid.equals("ios"))	{

				dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.1");
				dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"iOS");
				dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"XCUITest");
				dc.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone XR");
				dc.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
				dc.setCapability(MobileCapabilityType.SUPPORTS_JAVASCRIPT, true);
				dc.setCapability("newCommandTimeout", 15000);

			} // end ios
			else if (localGrid.equals("android"))
			{

				// Get the Android emulator name and version
				String emulator = StoredVariables.getemulator().get();
				String version = StoredVariables.getversion().get();
				
				// Set the Chromedriver directories
				String chromedriverExecutableDir = "";
				String chromedriverChromeMappingFile = "";
				if (os.equals("Mac")) {
					chromedriverExecutableDir = userDir+"/AppiumChromeDrivers/";
					chromedriverChromeMappingFile = userDir+"/AppiumChromeDrivers/chromedriverChromeMappingFile.json";
				} else if (os.equals("Windwos")) {
					chromedriverExecutableDir = userDir+"\\AppiumChromeDrivers\\";
					chromedriverChromeMappingFile = userDir+"\\AppiumChromeDrivers\\chromedriverChromeMappingFile.json";
				} // end if/else
				
				// Set the capabilities for Android
				dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);
				dc.setCapability(MobileCapabilityType.DEVICE_NAME, emulator);
				dc.setCapability("avd", emulator.replace(" ", "_"));
				dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
				dc.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
				dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
//				dc.setCapability("autoAcceptAlerts", true);
				dc.setCapability("chromedriverExecutableDir", chromedriverExecutableDir);
				dc.setCapability("chromedriverChromeMappingFile", chromedriverChromeMappingFile);
				dc.setCapability("newCommandTimeout", 15000);
				options.addArguments("ignore-certificate-errors");
				options.addArguments("disable-translate");
				options.addArguments("no-first-run");
				options.setExperimentalOption("prefs", chromePrefs);
				options.addArguments("--test-type");
			    options.addArguments("--disable-extensions"); //to disable browser extension popup
			    options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				dc.setCapability(ChromeOptions.CAPABILITY, options);

			} // end android
			else {

				// Set Capabilities depending on what browser you're using
				if (browser.equals("PhantomJS"))
				{
					if (os.equals("Mac"))
					{
						dc.setBrowserName(DesiredCapabilities.phantomjs().getBrowserName());
					} // end Mac

					if (os.contains("Windows"))
					{
						dc.setJavascriptEnabled(true);  
						dc.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, userDir.replace(project, "drivers\\phantomjs.exe"));
					} // end Windows

				} // end PhantomJS

				if (browser.equals("Firefox"))
				{
					System.out.println("Setting Firefox options");

					// Set the location of the geckodriver
					String firefoxDriver = "C:\\workspace\\drivers\\geckodriver.exe";
					if (os.equals("Mac")) {
						firefoxDriver = "/drivers/geckodriver";
					} // end if Mac
					System.setProperty("webdriver.gecko.driver", firefoxDriver);

					// Get the browser name
					dc.setBrowserName(DesiredCapabilities.firefox().getBrowserName());
				} // end if for Firefox browser

				if (browser.equals("Chrome"))
				{

					if (localGrid.equals("true") || localGrid.equals("false") || localGrid.equals("docker")) {
						if (os.equals("Mac")) {
							System.setProperty("webdriver.chrome.driver", "/Users/dnorman/drivers/chromedriver");
//							options.addArguments("--user-data-dir=/private/tmp/chromeprofiles/profile_"+getUniqueTimestamp());
						} // end if Mac
						if (os.equals("Windows")) {
							String chromeDriver = "C:\\workspace\\drivers\\chromedriver.exe";
							System.setProperty("webdriver.chrome.driver", chromeDriver);
							options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
//							options.addArguments("--user-data-dir=C:\\tmp\\chromeprofiles\\profile_"+getUniqueTimestamp());
						} // end if Windows
						// Set ChromeOptions
						options.addArguments("start-maximized");
						options.addArguments("--always-authorize-plugins");
//						options.addArguments("enable-automation");
						options.setExperimentalOption("useAutomationExtension", false);
						options.addArguments("--disable-infobars");
						options.addArguments("--no-sandbox");
				        options.addArguments("--disable-dev-shm-usage");
						options.addArguments("--ignore-certificate-errors");
						options.addArguments("--disable-infobars");
						options.addArguments("--disable-browser-side-navigation");
				        options.addArguments("--disable-gpu");
				        if (StoredVariables.getheadless().get().toLowerCase().equals("true")) {
				        	options.addArguments("--headless");
				        } // end if headless
						options.getBrowserName();
						LoggingPreferences loggingprefs = new LoggingPreferences();
				        loggingprefs.enable(LogType.BROWSER, Level.ALL);
				        dc.setCapability(CapabilityType.LOGGING_PREFS, loggingprefs);
				        dc.setCapability(ChromeOptions.CAPABILITY, options);
						options.setExperimentalOption("prefs", chromePrefs);
						options.addArguments("--test-type");
					    options.addArguments("--disable-extensions"); //to disable browser extension popup
					    options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				        options.merge(dc);
					} // end if

				} // end Chrome

				if (browser.equals("IE"))
				{

					StoredVariables.getIEDir().set(userDir.replace(project, "drivers\\IEDriverServer.exe"));

					dc.setBrowserName(DesiredCapabilities.internetExplorer().getBrowserName());
					//dc.setCapability("nativeEvents", true); // this causes IE to hang on windows dialog boxes when set to false
					dc.setCapability("unexpectedAlertBehaviour", "accept");
					dc.setCapability("ignoreProtectedModeSettings", true);
					dc.setCapability("disable-popup-blocking", true);
					dc.setCapability("enablePersistentHover", true);
					//dc.setCapability("requireWindowFocus", true);
					dc.setCapability("ensureCleanSession", true);
					dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

					System.setProperty("webdriver.ie.driver", StoredVariables.getIEDir().get());

				} // end IE

				if (browser.equals("Edge"))
				{

					String edgeDriver = "";
					if (os.contains("Windows"))
					{
						edgeDriver = userDir.replace(project, "drivers\\MicrosoftWebDriver.exe");
					} // end Windows
					else
					{
						edgeDriver = userDir.replace(project, "drivers/MicrosoftWebDriver");
					} // end Mac

					System.setProperty("webdriver.edge.driver", edgeDriver);

					dc.setBrowserName(DesiredCapabilities.edge().getBrowserName());

				} // end Edge

				if (browser.equals("Safari"))
				{
					dc.setBrowserName(DesiredCapabilities.safari().getBrowserName());
				} // end Safari

				if (browser.equals("Opera"))
				{
					String chromeDriver = "";
					if (os.contains("Windows"))
					{
						chromeDriver = userDir.replace(project, "drivers\\operadriver.exe");
					} // end Windows
					else
					{
						chromeDriver = userDir.replace(project, "drivers/operadriver");
					} // end Mac

					System.setProperty("webdriver.chrome.driver", chromeDriver);

					dc.setBrowserName(DesiredCapabilities.chrome().getBrowserName());
				} // end Opera

			} // end set driver capabilities

			// Set the driver
			if (localGrid.equals("true")) {
				if (browser.equals("Chrome")) {
					driver.set(new ChromeDriver(options));
				} // end if browser is Chrome and running locally
			} else {
				if (localGrid.equals("ios")) {
					try {
						driver.set(new IOSDriver<>(new URL(hubURL), dc));
					} catch (MalformedURLException e) {
						e.printStackTrace();
					} // end try/catch
				} // end if ios
				else if (localGrid.equals("android")) {
					try {
						driver.set(new AndroidDriver<>(new URL(hubURL), dc));
					} catch (MalformedURLException e) {
						e.printStackTrace();
					} // end try/catch
				} // end if android
				else if (localGrid.equals("sauce")) {
					try {
						driver.set(new RemoteWebDriver(new URL(hubURL), dc));
					} catch (MalformedURLException e) {
						e.printStackTrace();
					} // end try/catch
				} // end if sauce
				else {
					if (browser.equals("Chrome")) {
						try {
							driver.set(new RemoteWebDriver(new URL(hubURL), options));
						} catch (MalformedURLException e) {
							e.printStackTrace();
						} // end try/catch
					} // end if Chrome
					else if (browser.equals("Firefox")) {
						try {
							driver.set(new RemoteWebDriver(new URL(hubURL), dc));
						} catch (MalformedURLException e) {
							e.printStackTrace();
						} // end try/catch
					} // end if Firefox
					else {
						try {
							driver.set(new RemoteWebDriver(new URL(hubURL), dc));
						} catch (MalformedURLException e) {
							e.printStackTrace();
						} // end try/catch
					} // end if/else
				} // end if grid
			} // end set driver

			return getDriver();
		} // end Override
	}; // end ThreadLocal

	/**
	 * This method gets the driver object and launches a browser.
	 *
	 * @return the driver
	 */
	public RemoteWebDriver getDriver() // call this method to get the driver object and launch the browser
	{
		return driver.get();
	}

	/**
	 * Closes the browser and quits the driver
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Close the browser</li>
	 * 	<li>Quit the browser before removing it if it is a Firefox driver</li>
	 * 	<li>Remove the driver</li>
	 * </ul>
	 * @throws InterruptedException the interrupted exception
	 */
	public void removeDriver() throws InterruptedException // Quits the driver and closes the browser
	{
		
		String browser = StoredVariables.getbrowser().get();
		if (!browser.toLowerCase().equals("firefox")) {
			System.out.println("Kill Non-Firefox driver");
//			driver.get().close();
			driver.get().quit();
		} // end if not firefox

		if (browser.toLowerCase().equals("firefox")) {
			System.out.println("Kill Firefox driver");
			driver.get().quit();
		} // end if firefox

		driver.remove();
		System.out.println("Removed the driver");
	}
	
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
//	private long getUniqueTimestamp() {
//
//		AtomicLong LAST_TIME_MS = new AtomicLong();
//		long now = System.currentTimeMillis();
//	    while(true) {
//	        long lastTime = LAST_TIME_MS.get();
//	        if (lastTime >= now)
//	            now = lastTime+1;
//	        if (LAST_TIME_MS.compareAndSet(lastTime, now))
//	            return now;
//	    } // end while
//
//	} // end getUniqueTimestamp

} // end DriverFactory class