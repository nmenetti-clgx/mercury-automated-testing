package utils;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.xml.XmlSuite;

import setup.TestSetup;
 
/**
* <h1>Listener</h1>
* 
* <p>
* 
* @author  Dustin Norman
* @since   05-16-2018
*/

public class Listener extends TestSetup implements ITestListener, ISuiteListener, IInvokedMethodListener, IReporter {
	
	/** The list of failed tests */
	public static List<String> failedTests = new ArrayList<String>();
	
	/** The failed tests XML */
	public static List<String> failedTestsXML = new ArrayList<String>();
	
	/** Boolean indicating a failed test during the run */
	public static boolean testFailed = false;
	
	/** The class name */
	public static String className = null;
	
	/**
	* 
	* <p>
	* STEPS:
	* <ul>
	* 	<li></li>
	* </ul>
	*/	
	// This belongs to ISuiteListener and will execute before the Suite start
	public void onStart(ISuite arg0) {
 
		Reporter.log("About to begin executing Suite " + arg0.getName(), true);
 
	} // end onStart
	
	/**
	* 
	* <p>
	* STEPS:
	* <ul>
	* 	<li></li>
	* </ul>
	*/ 
	// This belongs to ISuiteListener and will execute, once the Suite is finished
	public void onFinish(ISuite arg0) {
 
		// Set the OS
		String os = StoredVariables.getos().get();
		
		// Set the suite name
		String suiteName = arg0.getName();
		if (suiteName.equals("Default suite")) {
			suiteName = className;
		} // end if
		Reporter.log("About to end executing Suite " + suiteName, true);
		
		// If there are failed tests, create a FailedTests.xml file in the report directory
		if (testFailed==true) {
			
			// Set the beginning of the FailedTests.xml
			String retestXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
					+ "<!DOCTYPE suite SYSTEM \"http://testng.org/testng-1.0.dtd\">\r\n"
					+ "<suite name=\"FailedTests\" verbose=\"2\" parallel=\"methods\">\r\n" + "\r\n"
					+ "  <listeners>\r\n" + "      <listener class-name=\"utils.ThreadCountChanger\"/>\r\n"
					+ "  </listeners>\r\n" + "\r\n" + " <test name=\"FailedTests\">\r\n" + " \r\n" + "  <groups>\r\n"
					+ "   <run>\r\n" + "    <exclude name=\"broken\" />\r\n" + "   </run>\r\n" + "  </groups>\r\n"
					+ "\r\n" + "  <classes>\r";
			
			// Set the ending of the FailedTests.xml
			String retestXML2 = "\n  </classes>\r\n" + "\r\n" + " </test>\r\n" + "\r\n" + "</suite>";
			
			// Build the FailedTests.xml
			failedTestsXML.add(retestXML);
			for (String failed : failedTests) {
				failedTestsXML.add("\n   <class name =\"" + failed + "\"/>\r");
			} // end for
			failedTestsXML.add(retestXML2);
			
			// Create the String for FailedTests.xml
			String joined = String.join("", failedTestsXML);
			System.out.println("joined:\n\n" + joined);
			
			// Get the host name
			InetAddress inetAddr = null;
			try {
				inetAddr = InetAddress.getLocalHost();
			} catch (UnknownHostException e1) {
				e1.printStackTrace();
			} // end try/catch
			String hostname = inetAddr.getHostName().replaceAll(" ", "");
			
			// Set the hostname
			switch (hostname) {
			case "C02LK6MTFD57":
				hostname = "DustinsMac";
				break;
			case "VMP-2316":
				hostname = "DustinsDesktop";
				break;
			case "OKC4AUTOQA-1":
				hostname = "Jenkins";
				break;
			case "OKCLW10FFJ0SN2":
				hostname = "KendallsLaptop";
				break;
			} // end switch
			
			// Create the file for the FailedTests.xml
			String fileName = StoredVariables.gettodaysDateLong().get().replaceAll("/", "")+"-"+StoredVariables.gettimeStamp().get()+"-"+hostname+"-"+StoredVariables.getenvironment().get()+"-"+suiteName+".xml";
			fileName = fileName.replace(" ", "");
			
			try {
				
				// Create the failed test xml file in the report directory
				if (os.contains("Windows")) {
					perform.writeToAFile(StoredVariables.getreportPath().get() + "\\", fileName, joined);
				} else {
					perform.writeToAFile(StoredVariables.getreportPath().get() + "/", fileName, joined);
				}
				
				// Create the failed test xml file locally
				String localPath = StoredVariables.getuserDir().get()+"\\src\\test\\resources\\_failedTests\\";
				if (os.equals("Mac")) {
					localPath = StoredVariables.getuserDir().get()+"/src/test/resources/_failedTests/";
				} // end if Mac
				perform.writeToAFile(localPath, fileName, joined);
				
				// Create the failed test xml file on the server
				String serverPath = "\\\\"+StoredVariables.getserverIP().get()+"\\c$\\Code\\VMP\\automatedtesting\\MercuryNetwork\\src\\test\\resources\\_failedTests\\";
				if (os.equals("Mac")) {
					serverPath = "/Volumes/Code/VMP/automatedtesting/MercuryNetwork/src/test/resources/_failedTests/";
				} // end if Mac
				perform.writeToAFile(serverPath, fileName, joined);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // end try/catch
			
		} // end if testFailed
		
	} // end onFinish
	
	/**
	* 
	* <p>
	* STEPS:
	* <ul>
	* 	<li></li>
	* </ul>
	*/ 
	// This belongs to ITestListener and will execute before starting of Test set/batch 
	public void onStart(ITestContext arg0) {
 
		Reporter.log("About to begin executing Test " + arg0.getName(), true);
 
	} // end onStart
	
	/**
	* 
	* <p>
	* STEPS:
	* <ul>
	* 	<li></li>
	* </ul>
	*/
	// This belongs to ITestListener and will execute, once the Test set/batch is finished
	public void onFinish(ITestContext arg0) {
 
		Reporter.log("Completed executing Test " + arg0.getName(), true);
 
	} // end onFinish
	
	/**
	* 
	* <p>
	* STEPS:
	* <ul>
	* 	<li></li>
	* </ul>
	*/ 
	// This belongs to ITestListener and will execute only when the test is pass
	public void onTestSuccess(ITestResult arg0) {
 
		// This is calling the printTestResults method
 
		printTestResults(arg0);
 
	} // end onTestSuccess
	
	/**
	* 
	* <p>
	* STEPS:
	* <ul>
	* 	<li></li>
	* </ul>
	*/
	// This belongs to ITestListener and will execute only on the event of fail test
	public void onTestFailure(ITestResult tr) {
 
		// This is calling the printTestResults method
		printTestResults(tr);
		
		// Set testFailed to true
		testFailed = true;
		
		// Get the package and class name
		String pkg = tr.getTestClass().getRealClass().getPackage().getName();
		String cs = tr.getTestClass().getRealClass().getSimpleName();
		
		// Add the failed test to the array
    	String failedTest = pkg+"."+cs;
    	if (!failedTests.contains(failedTest)) {
    		failedTests.add(failedTest);	    		
    	} // end if
    	System.out.println("Array: " + failedTests);
		
	} // end onTestFailure
	
	/**
	* 
	* <p>
	* STEPS:
	* <ul>
	* 	<li></li>
	* </ul>
	*/
	// This belongs to ITestListener and will execute before the main test start (@Test)
	public void onTestStart(ITestResult arg0) {
 
		System.out.println("The execution of the main test starts now");
		
		className = arg0.getTestClass().getRealClass().getSimpleName();
 
	} // end onTestStart
	
	/**
	* 
	* <p>
	* STEPS:
	* <ul>
	* 	<li></li>
	* </ul>
	*/
	// This belongs to ITestListener and will execute only if any of the main test(@Test) get skipped
	public void onTestSkipped(ITestResult arg0) {
 
		printTestResults(arg0);
 
	} // end onTestSkipped
	
	/**
	* 
	* <p>
	* STEPS:
	* <ul>
	* 	<li></li>
	* </ul>
	*/
	// This is just a piece of shit, ignore this
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
 
	} // end onTestFailedButWithinSuccessPercentage
	
	// This is the method which will be executed in case of test pass or fail
	// This will provide the information on the test
	private void printTestResults(ITestResult result) {
 
		Reporter.log("Test Method resides in " + result.getTestClass().getName(), true);
 
		if (result.getParameters().length != 0) {
 
			String params = null;
 
			for (Object parameter : result.getParameters()) {
 
				params += parameter.toString() + ",";
 
			}
 
			Reporter.log("Test Method had the following parameters : " + params, true);
 
		}
 
		String status = null;
 
		switch (result.getStatus()) {
 
		case ITestResult.SUCCESS:
 
			status = "Pass";
 
			break;
 
		case ITestResult.FAILURE:
 
			status = "Failed";
 
			break;
 
		case ITestResult.SKIP:
 
			status = "Skipped";
 
		}
 
		Reporter.log("Test Status: " + status, true);
 
	} // end printTestResults
	
	/**
	* 
	* <p>
	* STEPS:
	* <ul>
	* 	<li></li>
	* </ul>
	*/
	// This belongs to IInvokedMethodListener and will execute before every method including @Before @After @Test
	public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {
		
		Thread.currentThread().getId();
		String textMsg = "About to begin executing following method : " + returnMethodName(arg0.getTestMethod());
 
		Reporter.log(textMsg, true);
 
	} // end beforeInvocation
	
	/**
	* 
	* <p>
	* STEPS:
	* <ul>
	* 	<li></li>
	* </ul>
	*/
	// This belongs to IInvokedMethodListener and will execute after every method including @Before @After @Test
	public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {
 
		Thread.currentThread().getId();
		String textMsg = "Completed executing following method : " + returnMethodName(arg0.getTestMethod());
 
		Reporter.log(textMsg, true);
 
	} // end afterInvocation
	
	/**
	* 
	* <p>
	* STEPS:
	* <ul>
	* 	<li></li>
	* </ul>
	*/
	// This will return method names to the calling function
	private String returnMethodName(ITestNGMethod method) {
 
		return method.getRealClass().getSimpleName() + "." + method.getMethodName();
 
	} // end returnMethodName

	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		
//		System.out.println("*****Custom Report******");
//		ISuite suite = suites.get(0);
//		Map<String, Collection> methodsByGroup = suite.getMethodsByGroups();
//		Map<String, ISuiteResult> tests = suite.getResults();
//		for (String key : tests.keySet()) {
//			System.out.println("Key: " + key + ", Value: " + tests.get(key));
//		}
//		Collection suiteResults = tests.values();
//		ISuiteResult suiteResult = suiteResults.iterator().next();
//		ITestContext testContext = suiteResult.getTestContext();
//		Collection perfMethods = methodsByGroup.get("perf");
//		IResultMap failedTests = testContext.getFailedTests();
//		for (ITestNGMethod perfMethod : perfMethods) {
//			Set testResultSet = failedTests.getResults(perfMethod);
//			for (ITestResult testResult : testResultSet) {
//				System.out.println("Test " + testResult.getName() + " failed, error " + testResult.getThrowable());
//			}
//		}
//		IResultMap passedTests = testContext.getPassedTests();
//		for (ITestNGMethod perfMethod : perfMethods) {
//			Set testResultSet = passedTests.getResults(perfMethod);
//			for (ITestResult testResult : testResultSet) {
//				System.out.println("Test " + testResult.getName() + " passed, time took " +
//						(testResult.getStartMillis() - testResult.getEndMillis()));
//			}
//		}
//		System.out.println("*****End of Report******");

	}
 
} // end Listener
