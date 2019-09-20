package utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.NetworkMode;

// TODO: Auto-generated Javadoc
/**
 * <h1>Extent Manager</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

public class ExtentManager {
	
    /** The extent. */
    private static ExtentReports extent;
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li></li>
	 * </ul>.
	 *
	 * @param filePath the file path
	 * @return the reporter
	 */
    public  static ExtentReports getReporter(String filePath) {
        if (extent == null) {
            extent = new ExtentReports(filePath, true, NetworkMode.ONLINE);
            
            extent
                .addSystemInfo("Host Name", "Anshoo")
                .addSystemInfo("Environment", "QA");
        }
        
        return extent;
    } // end getReporter
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li></li>
	 * </ul>.
	 *
	 * @return the reporter
	 */
    public  static ExtentReports getReporter() {
        return extent;
    } // end getReporter
    
} // end ExtentManager
