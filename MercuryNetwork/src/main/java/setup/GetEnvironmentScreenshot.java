package setup;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import setup.TestSetup;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Get Environment Screenshot</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class GetEnvironmentScreenshot extends TestSetup {
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li></li>
	 * </ul>.
	 *
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Test
	public synchronized void getSecureEnvironmentScreenshot() throws InterruptedException, IOException {
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		// Go to login page
		driver.get(StoredVariables.getsecureSite().get() + "//sessioninfo.aspx");
		
	} // end getSecureEnvironmentScreenshot
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li></li>
	 * </ul>.
	 *
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Test
	public synchronized void getVendorsEnvironmentScreenshot() throws InterruptedException, IOException {
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		// Go to login page
		driver.get(StoredVariables.getvendorsSite().get() + "//sessioninfo.aspx");
		
	} // end getVendorsEnvironmentScreenshot
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li></li>
	 * </ul>.
	 *
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Test
	public synchronized void getVMPEnvironmentScreenshot() throws InterruptedException, IOException {
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		// Get environment
		String environment = StoredVariables.getenvironment().get();
		String env = "";
		if (environment.startsWith("Dev") || environment.startsWith("QA"))
		{
			env = "QA";
		}
		else if (environment.startsWith("Beta"))
		{
			env = "Beta";
		}
		if (environment.startsWith("Live"))
		{
			env = "Live";
		}
		
		// Go to login page
		driver.get("https://automation" + env + "evflender." + StoredVariables.getvmpSiteSuffix().get() + "//sessioninfo.aspx");
		
	} // end getVMPEnvironmentScreenshot
	
} // end the GetEnvironmentScreenshot class
