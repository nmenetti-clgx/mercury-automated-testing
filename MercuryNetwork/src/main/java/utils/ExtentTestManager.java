package utils;

import java.util.HashMap;
import java.util.Map;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

// TODO: Auto-generated Javadoc
/**
 * <h1>Extent Test Manager</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

public class ExtentTestManager {
	
    /** The extent test map. */
    static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();
    
    /** The extent. */
    private static ExtentReports extent = ExtentManager.getReporter();
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li></li>
	 * </ul>.
	 *
	 * @return the test
	 */
    public static  ExtentTest getTest() {
        return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
    } // end getTest
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li></li>
	 * </ul>.
	 */
    public static  void endTest() {
        extent.endTest((ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId())));
    } // end endTest
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li></li>
	 * </ul>.
	 *
	 * @param testName the test name
	 * @return the extent test
	 */
    public static  ExtentTest startTest(String testName) {
        return startTest(testName, "");
    } // end startTest
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li></li>
	 * </ul>.
	 *
	 * @param testName the test name
	 * @param desc the desc
	 * @return the extent test
	 */
    public static  ExtentTest startTest(String testName, String desc) {
        ExtentTest test = extent.startTest(testName, desc);
        extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);

        return test;
    } // end startTest
    
} // end ExtentTestManager
