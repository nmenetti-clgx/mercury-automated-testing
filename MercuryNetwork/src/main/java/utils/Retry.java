package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
* <h1>Retry</h1>
* Gets implemented by adding retryAnalyzer = Retry.class at the Test annotation level and will re-run failed tests 
* <p>
* 
* @author  Dustin Norman
* @since   05-16-2018
*/

public class Retry implements IRetryAnalyzer {
    
	private int retryCount = 0;
    private int maxRetryCount = 2;
	
	/**
	* Retry the test based on the maxRetryCount value
	* <p>
	* STEPS:
	* <ul>
	* 	<li>Returns true if the retryCount is less than the maxRetryCount which will re-run a failed test</li>
	* </ul>
	*/
    public boolean retry(ITestResult result) {

    	if (StoredVariables.getdebug().get().equals("false"))
    	{
    		if (retryCount < maxRetryCount) {
                retryCount++;
                return true;
            } // end if
    	} // end if
        
        return false;
        
    } // end retry
	
}
