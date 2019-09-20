package systemsCheck;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;

// TODO: Auto-generated Javadoc
/**
 * <h1>Code Compile Check</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class CodeCompileCheck extends TestSetup {
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log test</li>
* </ul>
	 *
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={}, alwaysRun=true)
	public void codeCompileCheck() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		
		System.out.println("The code compiled successfully");
		
		// Log test
		test.log(LogStatus.INFO, "Systems Check", "Verified the code can compile successfully");
		
	} // end codeCompileCheck
	
} // end the SystmesCheck class
