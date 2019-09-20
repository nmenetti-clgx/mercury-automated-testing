package setup;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Listeners;

import utils.StoredVariables;

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
public class DriverFactorySecond {
	
	 /**
   	 * Instantiates a new driver factory.
   	 */
   	private DriverFactorySecond()
	   {
	      //Do-nothing..Do not allow to initialize this class from outside
	   }
	   
   	/** The instance of the driver */
   	private static DriverFactorySecond instance = new DriverFactorySecond();
		
   		/**
   		 * Get the instance of the driver
   		 * @return single instance of DriverFactory
   		 */
	   public static DriverFactorySecond getInstance()
	   {
	      return instance;
	   }

	   /** The ThreadLocal driver */
	   ThreadLocal<RemoteWebDriver> driver2 = new ThreadLocal<RemoteWebDriver>() // thread local driver object for webdriver
	   {
		   
	      @SuppressWarnings("deprecation")
	      @Override
	      protected RemoteWebDriver initialValue()
	      {
	    	  
				String browser = StoredVariables.getbrowser2().get();
				String env = StoredVariables.getenvironment().get();
				
				// Set DesiredCapabilities
				DesiredCapabilities dc = new DesiredCapabilities();
				
				// Set ChromeOptions
				ChromeOptions options = new ChromeOptions();
				
				// Set FirefoxOptions
//				FirefoxOptions ffOptions = new FirefoxOptions();
				
				String node = env.replace(" ", "");
				if (!StoredVariables.getuseLocalGrid().get().equals("docker")) {
				
					if (StoredVariables.getuseLocalGrid().get().equals("true"))
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
				}
				else if (os.contains("Mac"))
				{
					os = "Mac";
				}
				
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
					if (os.equals("Mac")) {
					System.setProperty("webdriver.chrome.driver" ,  "/drivers/chromedriver");
					} // end if Mac
					
					if (os.equals("Windows")) {
						String chromeDriver = "C:\\workspace\\drivers\\chromedriver.exe";
						System.setProperty("webdriver.chrome.driver", chromeDriver);
						options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
					} // end if Windows
					
					// Set ChromeOptions
					options.addArguments("start-maximized");
					//options.addArguments("ignore-certificate-errors");
					
					options.getBrowserName();
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
				
				// Set the driver
				if (browser.equals("Chrome")) {
					try {
						driver2.set(new RemoteWebDriver(new URL(hubURL), options));
					} catch (MalformedURLException e) {
						e.printStackTrace();
					}
				} else if (browser.equals("Firefox")) {
					try {
						driver2.set(new RemoteWebDriver(new URL(hubURL), dc));
					} catch (MalformedURLException e) {
						e.printStackTrace();
					}
				} else {
					try {
						driver2.set(new RemoteWebDriver(new URL(hubURL), dc));
					} catch (MalformedURLException e) {
						e.printStackTrace();
					}
				} // end if/else
				
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
	      return driver2.get();
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
		   if (!StoredVariables.getbrowser().get().toLowerCase().equals("firefox")) {
				System.out.println("Kill Non-Firefox driver");
				driver2.get().close();
				driver2.get().quit();
			} // end if not firefox

			if (StoredVariables.getbrowser().get().toLowerCase().equals("firefox")) {
				System.out.println("Kill Firefox driver");
				driver2.get().quit();
			} // end if firefox

			driver2.remove();
			System.out.println("Removed the driver");
	   }	
	
} // end DriverFactory class