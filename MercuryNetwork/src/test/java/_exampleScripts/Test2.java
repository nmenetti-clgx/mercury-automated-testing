package _exampleScripts;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import setup.DriverFactory;
import setup.TestSetup;
import utils.Retry;
import utils.StoredVariables;

/**
* <h1>Test Class</h1>
* This is a class used to test running parallel 
* <p>
* 
* @author  Dustin Norman
* @since   05-16-2018
*/
@SuppressWarnings("javadoc")
public class Test2 extends TestSetup {
	
	@Test (retryAnalyzer = Retry.class, groups={"example"})
	public void amazon() {
		
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		StoredVariables.getbaseURL().set("http://www.amazon.com");
		
		String url = StoredVariables.getbaseURL().get();
		
		for (int a = 1; a < 2; a++)
		{
			url = StoredVariables.getbaseURL().get();
			driver.get(url);
		}
		
	} // end amazon
	
	@Test (retryAnalyzer = Retry.class, groups={"example"})
	public void nhl() {
		
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		StoredVariables.getbaseURL().set("http://www.nhl.com");
		
		String url = StoredVariables.getbaseURL().get();
		
		for (int a = 1; a < 2; a++)
		{
			url = StoredVariables.getbaseURL().get();
			driver.get(url);
		}
		
	} // end nhl
	
	@Test (retryAnalyzer = Retry.class, groups={"example"})
	public void nba() {
		
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		StoredVariables.getbaseURL().set("http://www.nba.com");
		
		String url = StoredVariables.getbaseURL().get();
		
		for (int a = 1; a < 2; a++)
		{
			url = StoredVariables.getbaseURL().get();
			driver.get(url);
		}
		
	} // end nba
	
} // end ExampleScripts class
