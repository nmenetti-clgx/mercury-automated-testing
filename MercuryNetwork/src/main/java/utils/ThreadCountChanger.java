package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.testng.IAlterSuiteListener;
import org.testng.xml.XmlSuite;

import setup.TestSetup;
 
/**
* <h1>Thread Count Changer</h1>
* Used as a listener class to set the threadCount. If a value is supplied, the threadCount is set to that value. If the 
* environment being ran in does not require hosts entries, the threadCount is set to 15. If not value is supplied, the default of 
* 5 threads is used for the threadCount. 
* <p>
* 
* @author  Dustin Norman
* @since   05-16-2018
*/

public class ThreadCountChanger extends TestSetup implements IAlterSuiteListener {
	
	/**
	* 
	* <p>
	* STEPS:
	* <ul>
	* 	<li>Read the GlobalVariables.properties file</li>
	* 	<li>Get the Grid that the tests are going to be ran in</li>
	* 	<li>Get the environment the tests are going to be ran in</li>
	* 	<li>Determine if the hosts file needs to be modified</li>
	* 	<li>Set the default threadCount to -1</li>
	* 	<li>If the threadCount is greater than 0, update the threadCount to the number supplied</li>
	* 	<li>If the environment does not require a hosts file config, set the threadCount to 15</li>
	* </ul>
	* @param suites Looks at the XML suite info for the test run
	*/
	@Override
	public void alter(List<XmlSuite> suites) {
		
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
		
		// Read the global variables file
		String globalPropertiesFile = "";
		if (os.contains("Windows"))
		{
			globalPropertiesFile = System.getProperty("user.dir")+"\\src\\main\\resources\\GlobalVariables.properties";
		}
		else if (os.equals("Mac"))
		{
			globalPropertiesFile = System.getProperty("user.dir")+"/src/main/resources/GlobalVariables.properties";
		}
		File file = new File(globalPropertiesFile);
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
	  
		// Load the global variables file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Get the localGridParam
		String localGridParam;
		if (System.getProperty("localGridParam")==null) {
			localGridParam = prop.getProperty("useLocalGrid");
		} else {
			localGridParam = System.getProperty("localGridParam");
		}
		System.out.println("localGridParam = " + localGridParam);
		
		// Get the environmentParam
		String environmentParam;
		if (System.getProperty("environmentParam")==null) {
			environmentParam = prop.getProperty("environment");
		} else {
			environmentParam = System.getProperty("environmentParam");
		}
		System.out.println("environmentParam = " + environmentParam);
		
		// Determine if the environment requires hosts entries
		boolean requireHosts = true;
		if (environmentParam.equals("QA") || environmentParam.equals("Sprint QA") || environmentParam.equals("Beta") || environmentParam.equals("Live")) {
			requireHosts = false;
		} // end if environmentParam
		
		// Get the threadCount and set to -1 if not supplied to exit loop
		int count = Integer.parseInt(System.getProperty("threadCount", "-1"));
		
		// Set the threadCount to the value that was passed in
		if (count > 0) {
			
	        System.err.println("**Alter is invoked because the threadCount parameter was supplied**");
	        
	        // Set the threadCount
	        for (XmlSuite suite : suites) {
	            suite.setThreadCount(count);
	            System.err.println("Set threadCount = " + count);
	        } // end for suites
			
		} // end if count
		
		// Change the thread count if using the VM Grid and test does not require hosts file entries
		else if (localGridParam.equals("false") && count <=0) {
		
	        System.err.println("**Alter is invoked because to increase the number of threads**");
	        
	        if (requireHosts==false) {
	        	
		        // Set the threadCount
		        count = 40;
		        for (XmlSuite suite : suites) {
		            suite.setThreadCount(count);
		            System.err.println("Set threadCount = " + count);
		        } // end for suites
	        
	        } // end if requireHosts
        
		} // end if localGridParam
		
    } // end alter method
	 
} // end class
