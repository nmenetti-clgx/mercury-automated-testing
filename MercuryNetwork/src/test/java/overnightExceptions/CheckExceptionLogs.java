package overnightExceptions;

import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.StoredVariables;

/**
 * <h1>Check Exception Logs</h1>
 * 
 * <p>
 *
 * @author  Dustin Norman
 * @since   11-27-2018
 */

public class CheckExceptionLogs extends TestSetup {


	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li></li>
	 * </ul>
	 * @throws Exception the exception
	 */
	@Test (groups={}, alwaysRun=true)
	public void queryForExceptions() throws Exception{

		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Set the Database to QA
		StoredVariables.getusernameEnvironment().set("QA");
		StoredVariables.getdbName().set("sql1qa.ad.mercuryvmp.com");
		StoredVariables.getdbPort().set("1433");
		
		// Set the SQL statement
		String sqlStatement = ""
		+ "SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED "
		+ "SELECT DateEntered, "
		+ "'http://wbsvcqa.mercuryvmp.com/exceptionlog/Details.aspx?GUID=' + Cast(ExceptionLogID AS VarChar(36)) AS BugURL, "
		+ "Message, "
		+ "ModuleName "
		+ "FROM CustomerData.dbo.Exceptionlog EL "
		+ "LEFT JOIN CustomerData.dbo.PassportProductFamily PPF ON PPF.PassProdFamilyID = EL.PassProdFamilyID "
		+ "LEFT JOIN CustomerData.dbo.PassportProducts PPS ON PPS.PassProductID = EL.PassProductID "
		+ "WHERE 1 = 1 "
		+ "AND IPAddress IN ( '"+StoredVariables.getserverIP().get()+"', '10.60.10.140', '10.60.10.141', '10.60.10.142', '10.60.10.143', '10.60.10.144', '10.60.10.146', '10.60.10.147', '10.60.10.149' ) "
		+ "AND Message NOT LIKE ('Login Failed:%') "
		+ "AND EL.DateEntered >= DATEADD(hh,17,DATEADD(day, DATEDIFF(day, 1, GETDATE()), 0)) "
		+ "AND EL.DateEntered <  DATEADD(hh,7,DATEADD(day, DATEDIFF(day, 0, GETDATE()), 0)) "
		+ "ORDER BY DateEntered DESC";
		
		// Set the DB Connection String
		String dbUrl = perform.setDBConnectionString(driver, "Mercury");
		
		//Load the required JDBC Driver class
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
		
	 	Connection conn = null;
	 	
	 	ArrayList<String> results = new ArrayList<String>();
	 	
	 	String exceptions = null;
	 	
	 	try {
	 	    	conn = DriverManager.getConnection(dbUrl);

			 	Statement stmt = null;
			 	ResultSet rs = null;

			 	try
			 	{
			 	  	stmt = conn.createStatement();
			 	   
				    // Execute the sql query
			 	  	System.out.println("sqlStatement = " + sqlStatement);
				    rs = stmt.executeQuery(sqlStatement);
				    
				    // Get number of columns
				    ResultSetMetaData rsmd = rs.getMetaData();
				    int columnsNumber = rsmd.getColumnCount();
				    
	         		// While Loop to iterate through all data and print results		
					while (rs.next()){
						for (int a = 1; a <=columnsNumber; a++) {
							String column = rs.getString(a);
		                    if (rs.wasNull())
		                    {
		                    	column = "NULL";
		                    }
		                    results.add(column.replace(",", "")+"\t");
		                    if (a==columnsNumber) {
		                    	results.add("\n\n");
		                    }
						} // end for loop
					} // end while rs.next
				    
					Calendar now = Calendar.getInstance();
					int year = now.get(Calendar.YEAR);
					String yearInString = String.valueOf(year);
					
					
					exceptions = results.toString().replace(", "+yearInString, yearInString);
					System.out.println("results = " + exceptions);
				 	
			 	} // end try
			 	catch (SQLException ex)
			 	{
			 	    // handle any errors
			 	    System.out.println("SQLException: " + ex.getMessage());
			 	    System.out.println("SQLState: " + ex.getSQLState());
			 	    System.out.println("VendorError: " + ex.getErrorCode());
			 	} // end catch
			 	finally {
			 	    // it is a good idea to release resources in a finally{} block
			 	    // if they are no-longer needed in reverse-order of their creation
			 	    if (rs != null) {
			 	        try {
			 	            rs.close();
			 	        } catch (SQLException sqlEx) { } // ignore
		
			 	        rs = null;
			 	    } // end if
		
			 	    if (stmt != null) {
			 	        try {
			 	            stmt.close();
			 	        } catch (SQLException sqlEx) { } // ignore
		
			 	        stmt = null;
			 	    } // end if
			 	} // end finally
	 	
	 	} catch (SQLException ex) {
	 	    // handle any errors
	 	    System.out.println("SQLException: " + ex.getMessage());
	 	    System.out.println("SQLState: " + ex.getSQLState());
	 	    System.out.println("VendorError: " + ex.getErrorCode());
	 	} // end catch
	 	
		// Close the database connection
		conn.close();
		
		// Set the date
		Date todaysDate = new Date();
		DateFormat df = new SimpleDateFormat("MMM-dd-yyyy");
		String date = df.format(todaysDate);
		
		// Set the file
		String directory = "C:\\AutomationSite\\OvernightRunExceptions\\";
		if (StoredVariables.getos().get().equals("Mac")) {
			directory = "/Volumes/AutomationSite/OvernightRunExceptions/";
		} // end if
		String fileName = "Exceptions-"+date+".csv";
		String file = directory+fileName;

		// Write the exceptions to a .csv file
		try {
            Files.write(Paths.get(file), exceptions.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } // end try/catch

		// Send an email that contains the exceptions from the overnight run on QA
		perform.sendEmail(driver, "dnorman@corelogic.com, rupace@corelogic.com, keriley@corelogic.com", "", "Exceptions from the overnight runs on QA", 
				"To see the full exception log, run the following SQL statement on QA or click the link in the description:\n\n" + sqlStatement + "\n\n" + exceptions.toString(), directory, fileName);
		
		// Log test
		test.log(LogStatus.INFO, "Exceptions", "Checked the database for exceptions");
		
	} // end queryForExceptions
	
} // end the CheckExceptionLogs class
