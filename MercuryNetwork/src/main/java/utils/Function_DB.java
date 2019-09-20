package utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import setup.TestSetup;

// TODO: Auto-generated Javadoc
/**
 * <h1>Function DB</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class Function_DB extends TestSetup {
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the DB Connection String</li>
	 * 	<li>Load the required JDBC Driver class</li>
	 * 	<li>Execute the sql query</li>
	 * 	<li>Retrieve the values of all returned rows and store them in a list</li>
	 * 	<li>Set the string from the sql results and pass the results</li>
	 * 	<li>Handle any errors</li>
	 * 	<li>Close the database connection</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param database the database
	 * @param sqlStatement the sql statement
	 * @return the string
	 * @throws Exception the exception
	 */
	// Query the database
	public String queryDB(RemoteWebDriver driver, String database, String sqlStatement) throws Exception {

		ExtentTest test = ExtentTestManager.getTest();
		
		// Set the DB Connection String
		String dbUrl = perform.setDBConnectionString(driver, database);
		
		//Load the required JDBC Driver class
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
		
	 	Connection conn = null;
	 	
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
				    
				    // retrieve the values of all returned rows and store them in a list
				    List<String> results = new ArrayList<String>();
					while(rs.next())
					results.add(rs.getString(1));
			 	   
				 	// Set the string from the sql results and pass the results
				 	StoredVariables.getdbResults().set(results.toString().replace("[","").replace("]",""));
				 	
				 	System.out.println("Database query result = " + StoredVariables.getdbResults().get());
				 	
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
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Database", "Queried the "+database+" database.<br>"
				+ "SQL Statement: " + sqlStatement
				+ "<br><br>Result: " + StoredVariables.getdbResults().get());
		
		return StoredVariables.getdbResults().get();
		
	} // end queryDB
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the DB Connection String</li>
	 * 	<li>Load the required JDBC Driver class</li>
	 * 	<li>Execute the sql query</li>
	 * 	<li>Retrieve the values of all returned rows and store them in a list</li>
	 * 	<li>Set the string from the sql results and pass the results</li>
	 * 	<li>Handle any errors</li>
	 * 	<li>Close the database connection</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param database the database
	 * @param sqlStatement the sql statement
	 * @return the string
	 * @throws Exception the exception
	 */
	// Query the database
	public String queryDBNoLog(RemoteWebDriver driver, String database, String sqlStatement) throws Exception {

		// Set the DB Connection String
		String dbUrl = perform.setDBConnectionString(driver, database);
		
		//Load the required JDBC Driver class
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
		
	 	Connection conn = null;
	 	
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
				    
				    // retrieve the values of all returned rows and store them in a list
				    List<String> results = new ArrayList<String>();
					while(rs.next())
					results.add(rs.getString(1));
			 	   
				 	// Set the string from the sql results and pass the results
				 	StoredVariables.getdbResults().set(results.toString().replace("[","").replace("]",""));
				 	
				 	System.out.println("Database query result = " + StoredVariables.getdbResults().get());
				 	
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
		
		return StoredVariables.getdbResults().get();
		
	} // end queryDBNoLog
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the DB Connection String</li>
	 * 	<li>Load the required JDBC Driver class</li>
	 * 	<li>Execute the sql query</li>
	 * 	<li>Get number of columns</li>
	 * 	<li>While Loop to iterate through all data and print results</li>
	 * 	<li>Get MailQueueID</li>
	 * 	<li>Handle any errors</li>
	 * 	<li>Close the database connection</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param database the database
	 * @param sqlStatement the sql statement
	 * @return the array list
	 * @throws Exception the exception
	 */
	// Query the database
	public  ArrayList<String> queryDBArray(RemoteWebDriver driver, String database, String sqlStatement) throws Exception {

		ExtentTest test = ExtentTestManager.getTest();
		
		// Set the DB Connection String
		String dbUrl = perform.setDBConnectionString(driver, database);
		
		//Load the required JDBC Driver class
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
		
	 	Connection conn = null;
	 	
	 	ArrayList<String> results = new ArrayList<String>();
	 	
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
							// Get MailQueueID
							String column = rs.getString(a);
		                    if (rs.wasNull())
		                    {
		                    	column = "NULL";
		                    }
		                    results.add(column);
						} // end for loop
					} // end while rs.next
					
					System.out.println("results = " + results);
				 	
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
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Database", "Queried the "+database+" database.<br>"
				+ "SQL Statement: " + sqlStatement
				+ "<br><br>Result: " + results);
		
		return results;
		
	} // end queryDBArray
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Build database url</li>
	 * 	<li>Load the required JDBC Driver class</li>
	 * 	<li>Execute the sql query</li>
	 * 	<li>Get number of columns</li>
	 * 	<li>While Loop to iterate through all data and print results</li>
	 * 	<li>Get MailQueueID</li>
	 * 	<li>Handle any errors</li>
	 * 	<li>Close the database connection</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param database the database
	 * @param sqlStatement the sql statement
	 * @return the array list
	 * @throws Exception The exception
	 */
	// Query the database
	public  ArrayList<String> queryDBArrayNoLog(RemoteWebDriver driver, String database, String sqlStatement) throws Exception {

		// Build database url
		String dbUrl = perform.setDBConnectionString(driver, database);
		
		//Load the required JDBC Driver class
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
		
	 	Connection conn = null;
	 	
	 	ArrayList<String> results = new ArrayList<String>();
	 	
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
							// Get MailQueueID
							String column = rs.getString(a);
		                    if (rs.wasNull())
		                    {
		                    	column = "NULL";
		                    }
		                    results.add(column);
						} // end for loop
					} // end while rs.next
					
					System.out.println("results = " + results);
				 	
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
		
		return results;
		
	} // end queryDBArrayNoLog
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the DB Connection String</li>
	 * 	<li>Load the required JDBC Driver class</li>
	 * 	<li>Execute the sql query</li>
	 * 	<li>While Loop to iterate through all data and print results</li>
	 * 	<li>Handle any errors</li>
	 * 	<li>Close the database connection</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param customerNumber the customer number
	 * @throws Exception the exception
	 */
	// Get Vendor Information By Customer Number
	public  void getVendorInformationByCustomerNumber(RemoteWebDriver driver, String customerNumber) throws Exception 
	{

		// Set the DB Connection String
		String dbUrl = perform.setDBConnectionString(driver, "Mercury");
		
		String getVendorInformationSQL = "SELECT FirstName, LastName, CompanyName, Address1, City, State, Zip, Phone, Email FROM Entities WHERE ALMCustomerNumber = '" + customerNumber + "'";
		
		//Load the required JDBC Driver class
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
		
	 	Connection conn = null;
	 	
	 	try {
	 	    	conn = DriverManager.getConnection(dbUrl);

			 	Statement stmt = null;
			 	ResultSet rs = null;

			 	try
			 	{
			 	  	stmt = conn.createStatement();
			 	   
				    // Execute the sql query
				    rs = stmt.executeQuery(getVendorInformationSQL);
				    
	         		// While Loop to iterate through all data and print results		
					while (rs.next()){

						StoredVariables.getvendorFirstName().set(rs.getString(1));
	                    StoredVariables.getvendorLastName().set(rs.getString(2));
	                    StoredVariables.getvendorCompanyName().set(rs.getString(3));
	                    StoredVariables.getvendorAddress1().set(rs.getString(4));
	                    StoredVariables.getvendorCity().set(rs.getString(5));
	                    StoredVariables.getvendorState().set(rs.getString(6));
	                    StoredVariables.getvendorZip().set(rs.getString(7));
	                    StoredVariables.getvendorPhone().set(rs.getString(8));
	                    StoredVariables.getvendorEmail().set(rs.getString(9));
	                    
	            		System.out.println("vendorFirstName = " + StoredVariables.getvendorFirstName().get());
	            		System.out.println("vendorLastName = " + StoredVariables.getvendorLastName().get());
	            		System.out.println("vendorCompanyName = " + StoredVariables.getvendorCompanyName().get());
	            		System.out.println("vendorAddress1 = " + StoredVariables.getvendorAddress1().get());
	            		System.out.println("vendorCity = " + StoredVariables.getvendorCity().get());
	            		System.out.println("vendorState = " + StoredVariables.getvendorState().get());
	            		System.out.println("vendorZip = " + StoredVariables.getvendorZip().get());
	            		System.out.println("vendorPhone = " + StoredVariables.getvendorPhone().get());
	            		System.out.println("vendorEmail = " + StoredVariables.getvendorEmail().get());
	                            
					} // end while loop
				    
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
		
	} // end getVendorInformationByCustomerNumber
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the DB Connection String</li>
	 * 	<li>Load the required JDBC Driver class</li>
	 * 	<li>Execute the sql query</li>
	 * 	<li>While Loop to iterate through all data and print results</li>
	 * 	<li>Handle any errors</li>
	 * 	<li>Close the database connection</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param Email the email
	 * @throws Exception the exception
	 */
	// Get Vendor Information By Email
	public  void getVendorInformationByEmail(RemoteWebDriver driver, String Email) throws Exception 
	{

		// Set the DB Connection String
		String dbUrl = perform.setDBConnectionString(driver, "Mercury");
		
		String getVendorInformationSQL = "SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED SELECT FirstName, LastName, CompanyName, Address1, City, State, Zip, Phone, Email FROM Entities WHERE Email = '" + Email + "'";
		
		//Load the required JDBC Driver class
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
		
	 	Connection conn = null;
	 	
	 	try {
	 	    	conn = DriverManager.getConnection(dbUrl);

			 	Statement stmt = null;
			 	ResultSet rs = null;

			 	try
			 	{
			 	  	stmt = conn.createStatement();
			 	   
				    // Execute the sql query
				    rs = stmt.executeQuery(getVendorInformationSQL);
				    
	         		// While Loop to iterate through all data and print results		
					while (rs.next()){

						StoredVariables.getvendorFirstName().set(rs.getString(1));
	                    StoredVariables.getvendorLastName().set(rs.getString(2));
	                    StoredVariables.getvendorCompanyName().set(rs.getString(3));
	                    StoredVariables.getvendorAddress1().set(rs.getString(4));
	                    StoredVariables.getvendorCity().set(rs.getString(5));
	                    StoredVariables.getvendorState().set(rs.getString(6));
	                    StoredVariables.getvendorZip().set(rs.getString(7));
	                    StoredVariables.getvendorPhone().set(rs.getString(8));
	                    StoredVariables.getvendorEmail().set(rs.getString(9));
	                    
	            		System.out.println("vendorFirstName = " + StoredVariables.getvendorFirstName().get());
	            		System.out.println("vendorLastName = " + StoredVariables.getvendorLastName().get());
	            		System.out.println("vendorCompanyName = " + StoredVariables.getvendorCompanyName().get());
	            		System.out.println("vendorAddress1 = " + StoredVariables.getvendorAddress1().get());
	            		System.out.println("vendorCity = " + StoredVariables.getvendorCity().get());
	            		System.out.println("vendorState = " + StoredVariables.getvendorState().get());
	            		System.out.println("vendorZip = " + StoredVariables.getvendorZip().get());
	            		System.out.println("vendorPhone = " + StoredVariables.getvendorPhone().get());
	            		System.out.println("vendorEmail = " + StoredVariables.getvendorEmail().get());
	                            
					} // end while loop
				    
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
		
	} // end getVendorInformationByEmail
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the DB Connection String</li>
	 * 	<li>Load the required JDBC Driver class</li>
	 * 	<li>Execute the sql query</li>
	 * 	<li>While Loop to iterate through all data and print results</li>
	 * 	<li>Handle any errors</li>
	 * 	<li>Close the database connection</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param LastName the last name
	 * @param CustomerNumber the customer number
	 * @throws Exception the exception
	 */
	// Get Vendor Information By Last Name and Customer Number
	public  void getVendorInformationByLastNameAndCustomerNumber(RemoteWebDriver driver, String LastName, String CustomerNumber) throws Exception 
	{

		// Set the DB Connection String
		String dbUrl = perform.setDBConnectionString(driver, "Mercury");
		
		String getVendorInformationSQL = "SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED SELECT FirstName, LastName, CompanyName, Address1, City, State, Zip, Phone, Email FROM Entities WHERE LastName = '" + LastName + "' AND ALMCustomerNumber = '" + CustomerNumber + "'";
		
		//Load the required JDBC Driver class
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
		
	 	Connection conn = null;
	 	
	 	try {
	 	    	conn = DriverManager.getConnection(dbUrl);

			 	Statement stmt = null;
			 	ResultSet rs = null;

			 	try
			 	{
			 	  	stmt = conn.createStatement();
			 	   
				    // Execute the sql query
				    rs = stmt.executeQuery(getVendorInformationSQL);
				    
	         		// While Loop to iterate through all data and print results		
					while (rs.next()){

						StoredVariables.getvendorFirstName().set(rs.getString(1));
	                    StoredVariables.getvendorLastName().set(rs.getString(2));
	                    StoredVariables.getvendorCompanyName().set(rs.getString(3));
	                    StoredVariables.getvendorAddress1().set(rs.getString(4));
	                    StoredVariables.getvendorCity().set(rs.getString(5));
	                    StoredVariables.getvendorState().set(rs.getString(6));
	                    StoredVariables.getvendorZip().set(rs.getString(7));
	                    StoredVariables.getvendorPhone().set(rs.getString(8));
	                    StoredVariables.getvendorEmail().set(rs.getString(9));
	                    
	            		System.out.println("vendorFirstName = " + StoredVariables.getvendorFirstName().get());
	            		System.out.println("vendorLastName = " + StoredVariables.getvendorLastName().get());
	            		System.out.println("vendorCompanyName = " + StoredVariables.getvendorCompanyName().get());
	            		System.out.println("vendorAddress1 = " + StoredVariables.getvendorAddress1().get());
	            		System.out.println("vendorCity = " + StoredVariables.getvendorCity().get());
	            		System.out.println("vendorState = " + StoredVariables.getvendorState().get());
	            		System.out.println("vendorZip = " + StoredVariables.getvendorZip().get());
	            		System.out.println("vendorPhone = " + StoredVariables.getvendorPhone().get());
	            		System.out.println("vendorEmail = " + StoredVariables.getvendorEmail().get());
	                            
					} // end while loop
				    
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
		
	} // end getVendorInformationByLastNameAndCustomerNumber
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Check Property Information</li>
	 * 	<li>Check Assignment Information</li>
	 * 	<li>Check Lender Information</li>
	 * 	<li>Check Contact And Access Information</li>
	 * 	<li>Check Additional Notification Recipients</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param loanID the loan ID
	 * @throws Exception the exception
	 */
	// Verify New Order Property Information data got entered into the db correctly
	public  void verifyNewOrderDataInDB_All(RemoteWebDriver driver, String loanID) throws Exception 
	{
		System.out.println("Verify New Order data got entered in the database correctly");

		String callersClass = new Exception().getStackTrace()[1].getClassName();
		String callersMethod = new Exception().getStackTrace()[1].getMethodName();
		StoredVariables.getcalledFrom().set(callersClass + "." + callersMethod);
		System.out.println("calledFrom = " + StoredVariables.getcalledFrom().get());
		
		// Check Property Information
		verifyNewOrderDataInDB_PropertyInformation(driver, loanID);
		
		// Check Assignment Information
		verifyNewOrderDataInDB_AssignmentInformation(driver, loanID);
		
		// Check Lender Information
		verifyNewOrderDataInDB_LenderInformation(driver, loanID);
		
		// Check Contact And Access Information
		verifyNewOrderDataInDB_BorrowerInformation(driver, loanID);
		verifyNewOrderDataInDB_CoBorrowerInformation(driver, loanID);
		verifyNewOrderDataInDB_OwnerInformation(driver, loanID);
		verifyNewOrderDataInDB_OccupantInformation(driver, loanID);
		verifyNewOrderDataInDB_AgentInformation(driver, loanID);
		verifyNewOrderDataInDB_OtherInformation(driver, loanID);
		
		// Check Additional Notification Recipients
		String additionalNotificationRecipientsSQL = "SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED SELECT AddtlNotifyRecipients FROM ProductItems WHERE LoanID = '" + loanID + "'";
		queryDB(driver, "Mercury", additionalNotificationRecipientsSQL);
		Assert.assertTrue(StoredVariables.getdbResults().get().equals(StoredVariables.getadditionalNotificationRecipientsAdditionalEmails().get()), "Additional Notification Recipients in the database doesn't equal what it should for this order - " + loanID + 
				" ----- Should be = " + StoredVariables.getadditionalNotificationRecipientsAdditionalEmails().get() + " DB - " + StoredVariables.getdbResults().get());
		
	} // end verifyNewOrderDataInDB_All
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the DB Connection String</li>
	 * 	<li>Load the required JDBC Driver class</li>
	 * 	<li>Execute the sql query</li>
	 * 	<li>While Loop to iterate through all data and print results</li>
	 * 	<li>Print out info to the console</li>
	 * 	<li>Verify data is correct in the database</li>
	 * 	<li>handle any errors</li>
	 * 	<li>it is a good idea to release resources in a finally{} block</li>
	 * 	<li>if they are no-longer needed in reverse-order of their creation</li>
	 * 	<li>handle any errors</li>
	 * 	<li>Close the database connection</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param loanID the loan ID
	 * @throws Exception the exception
	 */
	// Verify New Order Property Information data got entered into the db correctly
	public  void verifyNewOrderDataInDB_PropertyInformation(RemoteWebDriver driver, String loanID) throws Exception 
	{

		// Set the DB Connection String
		String dbUrl = perform.setDBConnectionString(driver, "Mercury");
		
		String propertyInformationSQL = "SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED  SELECT p.Address1, p.City, p.State, p.Zip, p.GLA,"
				+ "p.SiteSize, pt.LongName as PropType, p.LegalDescription, p.Directions "
				+ "FROM Properties p INNER JOIN PropertyTypes pt ON pt.PropertyTypeID = p.PropertyTypeID "
				+ "WHERE p.LoanID = '" + loanID + "'";
		
		System.out.println("propertyInformationSQL = " + propertyInformationSQL);
		
		//Load the required JDBC Driver class
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
		
	 	Connection conn = null;
	 	
	 	try {
	 	    	conn = DriverManager.getConnection(dbUrl);

			 	Statement stmt = null;
			 	ResultSet rs = null;

			 	try
			 	{
			 	  	stmt = conn.createStatement();
			 	   
				    // Execute the sql query
				    rs = stmt.executeQuery(propertyInformationSQL);
				    
	         		// While Loop to iterate through all data and print results		
					while (rs.next()){

						StoredVariables.getDBpropertyInformationAddress().set(rs.getString(1));
	                    if (rs.wasNull())
	                    {
	                    	StoredVariables.getDBpropertyInformationAddress().set("NULL");
	                    }
	                    StoredVariables.getDBpropertyInformationCity().set(rs.getString(2));
	                    if (rs.wasNull())
	                    {
	                    	StoredVariables.getDBpropertyInformationCity().set("NULL");
	                    }
	                    StoredVariables.getDBpropertyInformationStateAbbr().set(rs.getString(3));
	                    if (rs.wasNull())
	                    {
	                    	StoredVariables.getDBpropertyInformationStateAbbr().set("NULL");
	                    }
	                    StoredVariables.getDBpropertyInformationZip().set(rs.getString(4));
	                    if (rs.wasNull())
	                    {
	                    	StoredVariables.getDBpropertyInformationZip().set("NULL");
	                    }
	                    StoredVariables.getDBpropertyInformationSqFt().set(rs.getString(5));
	                    if (rs.wasNull())
	                    {
	                    	StoredVariables.getDBpropertyInformationSqFt().set("NULL");
	                    }
	                    StoredVariables.getDBpropertyInformationSiteSize().set(rs.getString(6));
	                    if (rs.wasNull())
	                    {
	                    	StoredVariables.getDBpropertyInformationSiteSize().set("NULL");
	                    }
	                    StoredVariables.getDBpropertyInformationPropType().set(rs.getString(7));
	                    if (rs.wasNull())
	                    {
	                    	StoredVariables.getDBpropertyInformationPropType().set("NULL");
	                    }
	                    StoredVariables.getDBpropertyInformationLegalDesc().set(rs.getString(8));
	                    if (rs.wasNull())
	                    {
	                    	StoredVariables.getDBpropertyInformationLegalDesc().set("NULL");
	                    }
	                    StoredVariables.getDBpropertyInformationDirections().set(rs.getString(9));
	                    if (rs.wasNull())
	                    {
	                    	StoredVariables.getDBpropertyInformationDirections().set("NULL");
	                    }
	            		
	            		// Print out info to the console
	            		System.out.println("DBpropertyInformationAddress = " + StoredVariables.getDBpropertyInformationAddress().get());
	            		System.out.println("DBpropertyInformationCity = " +StoredVariables.getDBpropertyInformationCity().get());
	            		System.out.println("DBpropertyInformationStateAbbr = " + StoredVariables.getDBpropertyInformationStateAbbr().get());
	            		System.out.println("DBpropertyInformationZip = " + StoredVariables.getDBpropertyInformationZip().get());
	            		System.out.println("DBpropertyInformationSqFt = " + StoredVariables.getDBpropertyInformationSqFt().get());
	            		System.out.println("DBpropertyInformationSiteSize = " + StoredVariables.getDBpropertyInformationSiteSize().get());
	            		System.out.println("DBpropertyInformationPropType = " + StoredVariables.getDBpropertyInformationPropType().get());
	            		System.out.println("DBpropertyInformationLegalDesc = " + StoredVariables.getDBpropertyInformationLegalDesc().get());
	            		System.out.println("DBpropertyInformationDirections = " + StoredVariables.getDBpropertyInformationDirections().get());
	            		System.out.println("");
	            		
	            		String propertyInformationAddress = "NULL";
	            		String propertyInformationCity = "NULL";
	            		String propertyInformationStateAbbr = "NULL";
	            		String propertyInformationZip = "NULL";
	            		String propertyInformationSqFt = "";
	            		String propertyInformationSiteSize = "";
	            		String propertyInformationPropType = "NULL";
	            		String propertyInformationLegalDesc = "NULL";
	            		String propertyInformationDirections = "NULL";

	            		if (!StoredVariables.getpropertyInformationAddress().get().equals("") || !StoredVariables.getpropertyInformationAddress().get().isEmpty())
	            		{
	            			propertyInformationAddress = StoredVariables.getpropertyInformationAddress().get();
	            		}
	            		if (!StoredVariables.getpropertyInformationCity().get().equals("") || !StoredVariables.getpropertyInformationCity().get().isEmpty())
	            		{
	            			propertyInformationCity = StoredVariables.getpropertyInformationCity().get();
	            		}
	            		if (!StoredVariables.getpropertyInformationStateAbbr().get().equals("") || !StoredVariables.getpropertyInformationStateAbbr().get().isEmpty())
	            		{
	            			propertyInformationStateAbbr = StoredVariables.getpropertyInformationStateAbbr().get();
	            		}
	            		if (!StoredVariables.getpropertyInformationZip().get().equals("") || !StoredVariables.getpropertyInformationZip().get().isEmpty())
	            		{
	            			propertyInformationZip = StoredVariables.getpropertyInformationZip().get();
	            		}
	            		if (!StoredVariables.getpropertyInformationSqFt().get().equals("") || !StoredVariables.getpropertyInformationSqFt().get().isEmpty())
	            		{
	            			propertyInformationSqFt = StoredVariables.getpropertyInformationSqFt().get();
	            		}
	            		if (!StoredVariables.getpropertyInformationSiteSize().get().equals("") || !StoredVariables.getpropertyInformationSiteSize().get().isEmpty())
	            		{
	            			propertyInformationSiteSize = StoredVariables.getpropertyInformationSiteSize().get();
	            		}
	            		if (!StoredVariables.getpropertyInformationPropType().get().equals("") || !StoredVariables.getpropertyInformationPropType().get().isEmpty())
	            		{
	            			propertyInformationPropType = StoredVariables.getpropertyInformationPropType().get();
	            		}
	            		if (!StoredVariables.getpropertyInformationLegalDesc().get().equals("") || !StoredVariables.getpropertyInformationLegalDesc().get().isEmpty())
	            		{
	            			propertyInformationLegalDesc = StoredVariables.getpropertyInformationLegalDesc().get();
	            		}
	            		if (!StoredVariables.getpropertyInformationDirections().get().equals("") || !StoredVariables.getpropertyInformationDirections().get().isEmpty())
	            		{
	            			propertyInformationDirections = StoredVariables.getpropertyInformationDirections().get();
	            		}

	            		// Verify data is correct in the database
	            		Assert.assertTrue(propertyInformationAddress.equals(StoredVariables.getDBpropertyInformationAddress().get()), "Property Information in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + propertyInformationAddress + " DB - " + StoredVariables.getDBpropertyInformationAddress().get());
	            		
	            		Assert.assertTrue(propertyInformationCity.equals(StoredVariables.getDBpropertyInformationCity().get()), "Property City in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + propertyInformationCity + " DB - " + StoredVariables.getDBpropertyInformationCity().get());
	            		
	            		Assert.assertTrue(propertyInformationStateAbbr.equals(StoredVariables.getDBpropertyInformationStateAbbr().get()), "Property State Abbreviation in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + propertyInformationStateAbbr + " DB - " +StoredVariables.getDBpropertyInformationStateAbbr().get());
	            		
	            		Assert.assertTrue(propertyInformationZip.equals(StoredVariables.getDBpropertyInformationZip().get()), "Property Zip in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + propertyInformationZip + " DB - " + StoredVariables.getDBpropertyInformationZip().get());
	            		
	            		Assert.assertTrue(propertyInformationSqFt.equals(StoredVariables.getDBpropertyInformationSqFt().get()), "Property Sq Ft in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + propertyInformationSqFt + " DB - " + StoredVariables.getDBpropertyInformationSqFt().get());
	            		
	            		Assert.assertTrue(propertyInformationSiteSize.equals(StoredVariables.getDBpropertyInformationSiteSize().get()), "Property Site Size in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + propertyInformationSiteSize + " DB - " + StoredVariables.getDBpropertyInformationSiteSize().get());
	            		
	            		Assert.assertTrue(propertyInformationPropType.equals(StoredVariables.getDBpropertyInformationPropType().get()), "Property Prop Type in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + propertyInformationPropType + " DB - " + StoredVariables.getDBpropertyInformationPropType().get());
	            		
	            		Assert.assertTrue(propertyInformationLegalDesc.equals(StoredVariables.getDBpropertyInformationLegalDesc().get()), "Property Legal Description in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + propertyInformationLegalDesc + " DB - " + StoredVariables.getDBpropertyInformationLegalDesc().get());
	            		
	            		Assert.assertTrue(propertyInformationDirections.equals(StoredVariables.getDBpropertyInformationDirections().get()), "Property Directions in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + propertyInformationDirections + " DB - " +StoredVariables.getDBpropertyInformationDirections().get());
	            		
					} // end while loop
				    
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
		
	} // end verifyNewOrderDataInDB_PropertyInformation
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the DB Connection String</li>
	 * 	<li>Load the required JDBC Driver class</li>
	 * 	<li>Execute the sql query</li>
	 * 	<li>While Loop to iterate through all data and print results</li>
	 * 	<li>Convert Rush Order from DB to boolean</li>
	 * 	<li>Convert Complex from DB to boolean</li>
	 * 	<li>Print out info to the console</li>
	 * 	<li>Get Due Date</li>
	 * 	<li>Get Disclosure Date</li>
	 * 	<li>Verify data is correct in the database</li>
	 * 	<li>Handle any errors</li>
	 * 	<li>Close the database connection</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param loanID the loan ID
	 * @throws Exception the exception
	 */
	// Verify New Order Assignment Information data got entered into the db correctly
	public  void verifyNewOrderDataInDB_AssignmentInformation(RemoteWebDriver driver, String loanID) throws Exception 
	{
		// Set the DB Connection String
		String dbUrl = perform.setDBConnectionString(driver, "Mercury");
		
		String assignmentInformationSQL = "SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED SELECT p.JobType, pi.IsRushOrder, pi.IsComplexOrder, CONVERT(VARCHAR(10), pi.DueDate, 101) as DueDate, "
				+ "l.OtherRefNumber, lt.LoanName, lp.Name, l.OrderedByFirst, l.LoanNumber, l.ClientFileNumber, "
				+ "l.SalePrice, l.FHA, CONVERT(VARCHAR(10), l.DisclosureDate, 101) as DisclosureDate, e.FirstName + ' ' + e.LastName as AssignedTo "
				+ "FROM ProductItems pi INNER JOIN   l ON pi.LoanID = l.LoanID INNER JOIN Products p ON pi.ProductID = p.ProductID "
				+ "INNER JOIN LoanTypes lt ON l.LoanTypeID = lt.LoanTypeID INNER JOIN LoanPurposes lp ON l.LoanPurposeID = lp.LoanPurposeID "
				+ "INNER JOIN Entities e ON l.EntityID = e.EntityID WHERE pi.LoanID = '" + loanID + "'";
		
		System.out.println("assignmentInformationSQL = " + assignmentInformationSQL);
		
		//Load the required JDBC Driver class
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
		
	 	Connection conn = null;
	 	
	 	try {
	 	    	conn = DriverManager.getConnection(dbUrl);

			 	Statement stmt = null;
			 	ResultSet rs = null;

			 	try
			 	{
			 	  	stmt = conn.createStatement();
			 	   
				    // Execute the sql query
				    rs = stmt.executeQuery(assignmentInformationSQL);
				    
	         		// While Loop to iterate through all data and print results		
					while (rs.next()){

						StoredVariables.getDBassignmentInformationForm().set(rs.getString(1));
	                    if (rs.wasNull())
	                    {
	                    	StoredVariables.getDBassignmentInformationForm().set("NULL");
	                    }
	                    StoredVariables.getDBassignmentInformationRushOrderDB().set(rs.getString(2));
	                    if (rs.wasNull())
	                    {
	                    	StoredVariables.getDBassignmentInformationRushOrderDB().set("NULL");
	                    }
	                    StoredVariables.getDBassignmentInformationComplexDB().set(rs.getString(3));
	                    if (rs.wasNull())
	                    {
	                    	StoredVariables.getDBassignmentInformationComplexDB().set("NULL");
	                    }
	                    StoredVariables.getDBassignmentInformationOrderDue().set(rs.getString(4));
	                    if (rs.wasNull())
	                    {
	                    	StoredVariables.getDBassignmentInformationOrderDue().set("NULL");
	                    }
	                    StoredVariables.getDBassignmentInformationOtherRefNumber().set(rs.getString(5));
	                    if (rs.wasNull())
	                    {
	                    	StoredVariables.getDBassignmentInformationOtherRefNumber().set("NULL");
	                    }
	                    StoredVariables.getDBassignmentInformationLoanType().set(rs.getString(6));
	                    if (rs.wasNull())
	                    {
	                    	StoredVariables.getDBassignmentInformationLoanType().set("NULL");
	                    }
	                    StoredVariables.getDBassignmentInformationLoanPurpose().set(rs.getString(7));
	                    if (rs.wasNull())
	                    {
	                    	StoredVariables.getDBassignmentInformationLoanPurpose().set("NULL");
	                    }
	                    StoredVariables.getDBassignmentInformationOrderedBy().set(rs.getString(8));
	                    if (rs.wasNull())
	                    {
	                    	StoredVariables.getDBassignmentInformationOrderedBy().set("NULL");
	                    }
	                    StoredVariables.getDBassignmentInformationLoanNumber().set(rs.getString(9));
	                    if (rs.wasNull())
	                    {
	                    	StoredVariables.getDBassignmentInformationLoanNumber().set("NULL");
	                    }
	                    StoredVariables.getDBassignmentInformationFileNumber().set(rs.getString(10));
	                    if (rs.wasNull())
	                    {
	                    	StoredVariables.getDBassignmentInformationFileNumber().set("NULL");
	                    }
	                    StoredVariables.getDBassignmentInformationSalesPrice().set(rs.getString(11));
	                    if (rs.wasNull())
	                    {
	                    	StoredVariables.getDBassignmentInformationSalesPrice().set("NULL");
	                    }
	                    StoredVariables.getDBassignmentInformationFHACaseNumber().set(rs.getString(12));
	                    if (rs.wasNull())
	                    {
	                    	StoredVariables.getDBassignmentInformationFHACaseNumber().set("NULL");
	                    }
	                    StoredVariables.getDBassignmentInformationDisclosure().set(rs.getString(13));
	                    if (rs.wasNull())
	                    {
	                    	StoredVariables.getDBassignmentInformationDisclosure().set("NULL");
	                    }
	                    StoredVariables.getDBassignmentInformationAssignedTo().set(rs.getString(14));
	                    if (rs.wasNull())
	                    {
	                    	StoredVariables.getDBassignmentInformationAssignedTo().set("NULL");
	                    }
	                    
	                    // Convert Rush Order from DB to boolean
	                    boolean DBassignmentInformationRushOrder;
	                    if (StoredVariables.getDBassignmentInformationRushOrderDB().get().equals("1"))
	                    {
	                    	DBassignmentInformationRushOrder = true;
	                    }
	                    else
	                    {
	                    	DBassignmentInformationRushOrder = false;
	                    }
	                    
	                    // Convert Complex from DB to boolean
	                    boolean DBassignmentInformationComplex;
	                    if (StoredVariables.getDBassignmentInformationComplexDB().get().equals("1"))
	                    {
	                    	DBassignmentInformationComplex = true;
	                    }
	                    else
	                    {
	                    	DBassignmentInformationComplex = false;
	                    }
	                    
	            		// Print out info to the console
	            		System.out.println("DBassignmentInformationForm = " + StoredVariables.getDBassignmentInformationForm().get());
	            		System.out.println("DBassignmentInformationRushOrder = " + DBassignmentInformationRushOrder);
	            		System.out.println("DBassignmentInformationComplex = " + DBassignmentInformationComplex);
	            		System.out.println("DBassignmentInformationOrderDue = " + StoredVariables.getDBassignmentInformationOrderDue().get());
	            		System.out.println("DBassignmentInformationOtherRefNumber = " + StoredVariables.getDBassignmentInformationOtherRefNumber().get());
	            		System.out.println("DBassignmentInformationLoanType = " + StoredVariables.getDBassignmentInformationLoanType().get());
	            		System.out.println("DBassignmentInformationLoanPurpose = " + StoredVariables.getDBassignmentInformationLoanPurpose().get());
	            		System.out.println("DBassignmentInformationOrderedBy = " + StoredVariables.getDBassignmentInformationOrderedBy().get());
	            		System.out.println("DBassignmentInformationLoanNumber = " + StoredVariables.getDBassignmentInformationLoanNumber().get());
	            		System.out.println("DBassignmentInformationFileNumber = " + StoredVariables.getDBassignmentInformationFileNumber().get());
	            		System.out.println("DBassignmentInformationSalesPrice = " + StoredVariables.getDBassignmentInformationSalesPrice().get());
	            		System.out.println("DBassignmentInformationFHACaseNumber = " + StoredVariables.getDBassignmentInformationFHACaseNumber().get());
	            		System.out.println("DBassignmentInformationDisclosure = " + StoredVariables.getDBassignmentInformationDisclosure().get());
	            		System.out.println("DBassignmentInformationAssignedTo = " + StoredVariables.getDBassignmentInformationAssignedTo().get());
	            		System.out.println("");
	            		
	            		String assignmentInformationForm = "NULL";
	            		String assignmentInformationOtherRefNumber = "NULL";
	            		String assignmentInformationLoanType = "NULL";
	            		String assignmentInformationLoanPurpose = "NULL";
	            		String assignmentInformationOrderedBy = "NULL";
	            		String assignmentInformationLoanNumber = "NULL";
	            		String assignmentInformationFileNumber = "NULL";
	            		String assignmentInformationSalesPrice = "NULL";
	            		String assignmentInformationFHACaseNumber = "NULL";
	            		String assignmentInformationAssignedTo = "NULL";

	            		if (!StoredVariables.getassignmentInformationForm().get().equals("") || !StoredVariables.getassignmentInformationForm().get().isEmpty())
	            		{
	            			assignmentInformationForm = StoredVariables.getassignmentInformationForm().get();
	            		}
	            		if (!StoredVariables.getassignmentInformationOtherRefNumber().get().equals("") || !StoredVariables.getassignmentInformationOtherRefNumber().get().isEmpty())
	            		{
	            			assignmentInformationOtherRefNumber = StoredVariables.getassignmentInformationOtherRefNumber().get();
	            		}
	            		if (!StoredVariables.getassignmentInformationLoanType().get().equals("") || !StoredVariables.getassignmentInformationLoanType().get().isEmpty())
	            		{
	            			assignmentInformationLoanType = StoredVariables.getassignmentInformationLoanType().get();
	            		}
	            		if (!StoredVariables.getassignmentInformationLoanPurpose().get().equals("") || !StoredVariables.getassignmentInformationLoanPurpose().get().isEmpty())
	            		{
	            			assignmentInformationLoanPurpose = StoredVariables.getassignmentInformationLoanPurpose().get();
	            		}
	            		if (!StoredVariables.getassignmentInformationOrderedBy().get().equals("") || !StoredVariables.getassignmentInformationOrderedBy().get().isEmpty())
	            		{
	            			assignmentInformationOrderedBy = StoredVariables.getassignmentInformationOrderedBy().get();
	            		}
	            		if (!StoredVariables.getassignmentInformationLoanNumber().get().equals("") || !StoredVariables.getassignmentInformationLoanNumber().get().isEmpty())
	            		{
	            			assignmentInformationLoanNumber = StoredVariables.getassignmentInformationLoanNumber().get();
	            		}
	            		if (!StoredVariables.getassignmentInformationFileNumber().get().equals("") || !StoredVariables.getassignmentInformationFileNumber().get().isEmpty())
	            		{
	            			assignmentInformationFileNumber = StoredVariables.getassignmentInformationFileNumber().get();
	            		}
	            		if (!StoredVariables.getassignmentInformationSalesPrice().get().equals("") || !StoredVariables.getassignmentInformationSalesPrice().get().isEmpty())
	            		{
	            			assignmentInformationSalesPrice = StoredVariables.getassignmentInformationSalesPrice().get();
	            		}
	            		if (!StoredVariables.getassignmentInformationFHACaseNumber().get().equals("") || !StoredVariables.getassignmentInformationFHACaseNumber().get().isEmpty())
	            		{
	            			assignmentInformationFHACaseNumber = StoredVariables.getassignmentInformationFHACaseNumber().get();
	            		}
	            		if (!StoredVariables.getassignmentInformationAssignedTo().get().equals("") || !StoredVariables.getassignmentInformationAssignedTo().get().isEmpty())
	            		{
	            			assignmentInformationAssignedTo = StoredVariables.getassignmentInformationAssignedTo().get();
	            		}
	            		
	                    // Get Due Date
	            		String DueDate = "NULL";
	            		if (!Integer.toString(StoredVariables.getassignmentInformationOrderDue().get()).isEmpty())
	            		{
		                    perform.getNewDate(driver, StoredVariables.getassignmentInformationOrderDue().get());
		                    DueDate = StoredVariables.getorderDueDateLong().get();
		                    StoredVariables.getorderDueDateLong().set(DueDate);
		                    StoredVariables.getorderDueDateShort().set(StoredVariables.getnewDateShort().get());
	            		}
	                    
	            		String DisclosureDate = "NULL";
	                    // Get Disclosure Date
	            		if (!Integer.toString(StoredVariables.getassignmentInformationDisclosure().get()).isEmpty())
	            		{
		                    perform.getNewDate(driver, StoredVariables.getassignmentInformationDisclosure().get());
		                    DisclosureDate = StoredVariables.getnewDateLong().get();
		                    StoredVariables.getdisclosureDateLong().set(DisclosureDate);
		                    StoredVariables.getdisclosureDateShort().set(StoredVariables.getnewDateShort().get());
	            		}
	            		
	            		// Verify data is correct in the database
	            		String Form = "";
	            		if (StoredVariables.getassignmentInformationForm().get().equals("1004 Full/URAR"))
	            		{
	            			Form = "1004/URAR with interior inspection";
	            		}
	            		else
	            		{
	            			Form = assignmentInformationForm;
	            		}
	            		
	            		Assert.assertTrue(Form.equals(StoredVariables.getDBassignmentInformationForm().get()), "Assignment Form in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + Form + " DB - " + StoredVariables.getDBassignmentInformationForm().get());
	            		
	            		Assert.assertTrue(StoredVariables.getassignmentInformationRushOrder().get()==(DBassignmentInformationRushOrder), "Assignment Rush Order in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + StoredVariables.getassignmentInformationRushOrder().get() + " DB - " + DBassignmentInformationRushOrder);
	            		
	            		Assert.assertTrue(StoredVariables.getassignmentInformationComplex().get()==(DBassignmentInformationComplex), "Assignment Complex in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + StoredVariables.getassignmentInformationComplex().get() + " DB - " + DBassignmentInformationComplex);
	            		
	            		Assert.assertTrue(DueDate.equals(StoredVariables.getDBassignmentInformationOrderDue().get()), "Assignment Order Due in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + DueDate + " DB - " + StoredVariables.getDBassignmentInformationOrderDue().get());
	            		
	            		Assert.assertTrue(assignmentInformationOtherRefNumber.equals(StoredVariables.getDBassignmentInformationOtherRefNumber().get()), "Assignment Other Ref Number in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + assignmentInformationOtherRefNumber + " DB - " + StoredVariables.getDBassignmentInformationOtherRefNumber().get());
	            		
	            		Assert.assertTrue(assignmentInformationLoanType.equals(StoredVariables.getDBassignmentInformationLoanType().get()), "Assignment Loan Type in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + assignmentInformationLoanType + " DB - " + StoredVariables.getDBassignmentInformationLoanType().get());
	            		
	            		Assert.assertTrue(assignmentInformationLoanPurpose.equals(StoredVariables.getDBassignmentInformationLoanPurpose().get()), "Assignment Loan Purpose in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + assignmentInformationLoanPurpose + " DB - " + StoredVariables.getDBassignmentInformationLoanPurpose().get());
	            		
	            		Assert.assertTrue(assignmentInformationOrderedBy.equals(StoredVariables.getDBassignmentInformationOrderedBy().get()), "Assignment Ordered By in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + assignmentInformationOrderedBy + " DB - " + StoredVariables.getDBassignmentInformationOrderedBy().get());
	            		
	            		Assert.assertTrue(assignmentInformationLoanNumber.equals(StoredVariables.getDBassignmentInformationLoanNumber().get()), "Assignment Loan Number in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + assignmentInformationLoanNumber + " DB - " + StoredVariables.getDBassignmentInformationLoanNumber().get());
	            		
	            		Assert.assertTrue(assignmentInformationFileNumber.equals(StoredVariables.getDBassignmentInformationFileNumber().get()), "Assignment File Number in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + assignmentInformationFileNumber + " DB - " + StoredVariables.getDBassignmentInformationFileNumber().get());
	            		
	            		Assert.assertTrue(assignmentInformationSalesPrice.replace(",","").replace(".00","").equals(StoredVariables.getDBassignmentInformationSalesPrice().get().replace(",","").replace(".0000","")), "Assignment Sales Price in the database doesn't equal what it should for this order - " + StoredVariables.getloanID() + 
	            				" ----- Should be = " + assignmentInformationSalesPrice.replace(",","").replace(".00","") + " DB - " + StoredVariables.getDBassignmentInformationSalesPrice().get().replace(",","").replace(".0000",""));
	            		
	            		Assert.assertTrue(assignmentInformationFHACaseNumber.equals(StoredVariables.getDBassignmentInformationFHACaseNumber().get()), "Assignment FHA Case Number in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + assignmentInformationFHACaseNumber + " DB - " + StoredVariables.getDBassignmentInformationFHACaseNumber().get());
	            		
	            		Assert.assertTrue(DisclosureDate.equals(StoredVariables.getDBassignmentInformationDisclosure().get()), "Assignment Disclosure in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + DisclosureDate + " DB - " + StoredVariables.getDBassignmentInformationDisclosure().get());
	            		
	            		Assert.assertTrue(assignmentInformationAssignedTo.equals(StoredVariables.getDBassignmentInformationAssignedTo().get()), "Assignment Assigned To in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + assignmentInformationAssignedTo + " DB - " + StoredVariables.getDBassignmentInformationAssignedTo().get());
	            		
					} // end while loop
				    
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
		
	} // end verifyNewOrderDataInDB_AssignmentInformation
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the DB Connection String</li>
	 * 	<li>Load the required JDBC Driver class</li>
	 * 	<li>Execute the sql query</li>
	 * 	<li>While Loop to iterate through all data and print results</li>
	 * 	<li>Print out info to the console</li>
	 * 	<li>Verify data is correct in the database</li>
	 * 	<li>Look up abbreviation if state is spelled out</li>
	 * 	<li>Look up abbreviation</li>
	 * 	<li>Verify state in db</li>
	 * 	<li>Handle any errors</li>
	 * 	<li>Close the database connection</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param loanID the loan ID
	 * @throws Exception the exception
	 */
	// Verify New Order Lender Information data got entered into the db correctly
	public  void verifyNewOrderDataInDB_LenderInformation(RemoteWebDriver driver, String loanID) throws Exception 
	{
		
		// Set the DB Connection String
		String dbUrl = perform.setDBConnectionString(driver, "Mercury");
		
		String lendorInformationSQL = "SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED SELECT l.Lender, c.Address1, c.Address2, c.City, c.State, c.Zip "
				+ "FROM Loans l INNER JOIN Contacts c ON l.LoanID = c.LoanID WHERE l.LoanID = '" + loanID + "' AND c.ListPropertyContactID = '7'";
		
		System.out.println("lendorInformationSQL = " + lendorInformationSQL);
		
		//Load the required JDBC Driver class
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
		
	 	Connection conn = null;
	 	
	 	try {
	 	    	conn = DriverManager.getConnection(dbUrl);

			 	Statement stmt = null;
			 	ResultSet rs = null;

			 	try
			 	{
			 	  	stmt = conn.createStatement();
			 	   
				    // Execute the sql query
				    rs = stmt.executeQuery(lendorInformationSQL);
				    
	         		// While Loop to iterate through all data and print results		
					while (rs.next()){

						StoredVariables.getDBlenderInformationLenderName().set(rs.getString(1));
	                    if (rs.wasNull())
	                    {
	                    	StoredVariables.getDBlenderInformationLenderName().set("NULL");
	                    }
	                    StoredVariables.getDBlenderInformationAddress1().set(rs.getString(2));
	                    if (rs.wasNull())
	                    {
	                    	StoredVariables.getDBlenderInformationAddress1().set("NULL");
	                    }
	                    StoredVariables.getDBlenderInformationAddress2().set(rs.getString(3));
	                    if (rs.wasNull())
	                    {
	                    	StoredVariables.getDBlenderInformationAddress2().set("NULL");
	                    }
	                    StoredVariables.getDBlenderInformationCity().set(rs.getString(4));
	                    if (rs.wasNull())
	                    {
	                    	StoredVariables.getDBlenderInformationCity().set("NULL");
	                    }
	                    StoredVariables.getDBlenderInformationState().set(rs.getString(5));
	                    if (rs.wasNull())
	                    {
	                    	StoredVariables.getDBlenderInformationState().set("NULL");
	                    }
	                    StoredVariables.getDBlenderInformationZip().set(rs.getString(6));
	                    if (rs.wasNull())
	                    {
	                    	StoredVariables.getDBlenderInformationZip().set("NULL");
	                    }
	                    
	            		// Print out info to the console
	            		System.out.println("DBlenderInformationLenderName = " + StoredVariables.getDBlenderInformationLenderName().get());
	            		System.out.println("DBlenderInformationAddress1 = " + StoredVariables.getDBlenderInformationAddress1().get());
	            		System.out.println("DBlenderInformationAddress2 = " + StoredVariables.getDBlenderInformationAddress2().get());
	            		System.out.println("DBlenderInformationCity = " + StoredVariables.getDBlenderInformationCity().get());
	            		System.out.println("DBlenderInformationState = " + StoredVariables.getDBlenderInformationState().get());
	            		System.out.println("DBlenderInformationZip = " + StoredVariables.getDBlenderInformationZip().get());
	            		System.out.println("");
	            		
	            		String lenderInformationLenderName = "NULL";
	            		String lenderInformationAddress1 = "NULL";
	            		String lenderInformationAddress2 = "NULL";
	            		String lenderInformationCity = "NULL";
	            		String lenderInformationState = "NULL";
	            		String lenderInformationZip = "NULL";
	            		
	            		if (!StoredVariables.getlenderInformationLenderName().get().equals("") || !StoredVariables.getlenderInformationLenderName().get().isEmpty())
	            		{
	            			lenderInformationLenderName = StoredVariables.getlenderInformationLenderName().get();
	            		}
	            		if (!StoredVariables.getlenderInformationAddress1().get().equals("") || !StoredVariables.getlenderInformationAddress1().get().isEmpty())
	            		{
	            			lenderInformationAddress1 = StoredVariables.getlenderInformationAddress1().get();
	            		}
	            		if (!StoredVariables.getlenderInformationAddress2().get().equals("") || !StoredVariables.getlenderInformationAddress2().get().isEmpty())
	            		{
	            			lenderInformationAddress2 = StoredVariables.getlenderInformationAddress2().get();
	            		}
	            		if (!StoredVariables.getlenderInformationCity().get().equals("") || !StoredVariables.getlenderInformationCity().get().isEmpty())
	            		{
	            			lenderInformationCity = StoredVariables.getlenderInformationCity().get();
	            		}
	            		if (!StoredVariables.getlenderInformationState().get().equals("") || !StoredVariables.getlenderInformationState().get().isEmpty())
	            		{
	            			lenderInformationState = StoredVariables.getlenderInformationState().get();
	            		}
	            		if (!StoredVariables.getlenderInformationZip().get().equals("") || !StoredVariables.getlenderInformationZip().get().isEmpty())
	            		{
	            			lenderInformationZip = StoredVariables.getlenderInformationZip().get();
	            		}
	            		

	            		// Verify data is correct in the database
	            		Assert.assertTrue(lenderInformationLenderName.equals(StoredVariables.getDBlenderInformationLenderName().get()), "Lender Name in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + lenderInformationLenderName + " DB - " + StoredVariables.getDBlenderInformationLenderName().get());
	            		
	            		Assert.assertTrue(lenderInformationAddress1.equals(StoredVariables.getDBlenderInformationAddress1().get()), "Lender Address1 in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + lenderInformationAddress1 + " DB - " + StoredVariables.getDBlenderInformationAddress1().get());
	            		
	            		Assert.assertTrue(lenderInformationAddress2.equals(StoredVariables.getDBlenderInformationAddress2().get()), "Lender Address2 in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
		            			" ----- Should be = " + lenderInformationAddress2 + " DB - " + StoredVariables.getDBlenderInformationAddress2().get());	            			
	            		
	            		Assert.assertTrue(lenderInformationCity.equals(StoredVariables.getDBlenderInformationCity().get()), "Lender City in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + lenderInformationCity + " DB - " + StoredVariables.getDBlenderInformationCity().get());
	            		
	            		// Look up abbreviation if state is spelled out
	            		if (lenderInformationState.length() > 2)
	            		{
	            			// look up abbreviation
	            			perform.getStateAbbreviation(driver, lenderInformationState);
	            			lenderInformationState = StoredVariables.getstateAbbreviation().get();
	            			
	            			// verify state in db
	            			Assert.assertTrue(lenderInformationState.equals(StoredVariables.getDBlenderInformationState().get()), "Lender State in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            					" ----- Should be = " + lenderInformationState + " DB - " + StoredVariables.getDBlenderInformationState().get());
	            		}
	            		else
	            		{
	            			
	            			Assert.assertTrue(lenderInformationState.equals(StoredVariables.getDBlenderInformationState().get()), "Lender State in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            					" ----- Should be = " + lenderInformationState + " DB - " + StoredVariables.getDBlenderInformationState().get());
	            		}
	            		
	            		Assert.assertTrue(lenderInformationZip.equals(StoredVariables.getDBlenderInformationZip().get()), "Lender Zip in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + lenderInformationZip + " DB - " + StoredVariables.getDBlenderInformationZip().get());
	            		
					} // end while loop
				    
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
		
	} // end verifyNewOrderDataInDB_LenderInformation
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the DB Connection String</li>
	 * 	<li>Load the required JDBC Driver class</li>
	 * 	<li>Execute the sql query</li>
	 * 	<li>While Loop to iterate through all data and print results</li>
	 * 	<li>Print out info to the console</li>
	 * 	<li>Set info to null</li>
	 * 	<li>Set info used for Info 1 dropdown</li>
	 * 	<li>Set info used for Info 2 dropdown</li>
	 * 	<li>Verify data is correct in the database</li>
	 * 	<li>Handle any errors</li>
	 * 	<li>Close the database connection</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param loanID the loan ID
	 * @throws Exception the exception
	 */
	// Verify New Order Borrower Information data got entered into the db correctly
	public  void verifyNewOrderDataInDB_BorrowerInformation(RemoteWebDriver driver, String loanID) throws Exception 
	{
		
		// Set the DB Connection String
		String dbUrl = perform.setDBConnectionString(driver, "Mercury");
		
		String borrowerInformationSQL = "SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED SELECT FirstName, DayPhone, EveningPhone, Fax, Email, Pager, Mobile, Address1, City, State, Zip "
				+ "FROM Contacts c WHERE c.LoanID = '" + loanID + "' AND ListPropertyContactID = '5'";
		
		System.out.println("borrowerInformationSQL = " + borrowerInformationSQL);
		
		//Load the required JDBC Driver class
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
		
	 	Connection conn = null;
	 	
	 	try {
	 	    	conn = DriverManager.getConnection(dbUrl);

			 	Statement stmt = null;
			 	ResultSet rs = null;

			 	try
			 	{
			 	  	stmt = conn.createStatement();
			 	   
				    // Execute the sql query
				    rs = stmt.executeQuery(borrowerInformationSQL);
				    
	         		// While Loop to iterate through all data and print results		
					while (rs.next()){

						StoredVariables.getDBcontactBorrower().set(rs.getString(1));
	                    if (rs.wasNull())
	                    {
	                    	StoredVariables.getDBcontactBorrower().set("NULL");
	                    }
	                    String DBcontactBorrowerDayPhone = rs.getString(2);
	                    if (rs.wasNull())
	                    {
	                    	DBcontactBorrowerDayPhone = "NULL";
	                    }
	                    String DBcontactBorrowerEveningPhone = rs.getString(3);
	                    if (rs.wasNull())
	                    {
	                    	DBcontactBorrowerEveningPhone = "NULL";
	                    }
	                    String DBcontactBorrowerFax = rs.getString(4);
	                    if (rs.wasNull())
	                    {
	                    	DBcontactBorrowerFax = "NULL";
	                    }
	                    String DBcontactBorrowerEmail = rs.getString(5);
	                    if (rs.wasNull())
	                    {
	                    	DBcontactBorrowerEmail = "NULL";
	                    }
	                    String DBcontactBorrowerPager = rs.getString(6);
	                    if (rs.wasNull())
	                    {
	                    	DBcontactBorrowerPager = "NULL";
	                    }
	                    String DBcontactBorrowerMobile = rs.getString(7);
	                    if (rs.wasNull())
	                    {
	                    	DBcontactBorrowerMobile = "NULL";
	                    }
	                    String DBcontactBorrowerAddress1 = rs.getString(8);
	                    if (rs.wasNull())
	                    {
	                    	DBcontactBorrowerAddress1 = "NULL";
	                    }
	                    StoredVariables.getDBcontactBorrowerCity().set(rs.getString(9));
	                    if (rs.wasNull())
	                    {
	                    	StoredVariables.getDBcontactBorrowerCity().set("NULL");
	                    }
	                    StoredVariables.getDBcontactBorrowerState().set(rs.getString(10));
	                    if (rs.wasNull())
	                    {
	                    	StoredVariables.getDBcontactBorrowerState().set("NULL");
	                    }
	                    StoredVariables.getDBcontactBorrowerZip().set(rs.getString(11));
	                    if (rs.wasNull())
	                    {
	                    	StoredVariables.getDBcontactBorrowerZip().set("NULL");
	                    }
	                    
	            		// Print out info to the console
	            		System.out.println("DBcontactBorrower = " + StoredVariables.getDBcontactBorrower().get());
	            		System.out.println("DBcontactBorrowerDayPhone = " + DBcontactBorrowerDayPhone);
	            		System.out.println("DBcontactBorrowerEveningPhone = " + DBcontactBorrowerEveningPhone);
	            		System.out.println("DBcontactBorrowerFax = " + DBcontactBorrowerFax);
	            		System.out.println("DBcontactBorrowerEmail = " + DBcontactBorrowerEmail);
	            		System.out.println("DBcontactBorrowerPager = " + DBcontactBorrowerPager);
	            		System.out.println("DBcontactBorrowerMobile = " + DBcontactBorrowerMobile);
	            		System.out.println("DBcontactBorrowerAddress1 = " + DBcontactBorrowerAddress1);
	            		System.out.println("DBcontactBorrowerCity = " + StoredVariables.getDBcontactBorrowerCity().get());
	            		System.out.println("DBcontactBorrowerState = " + StoredVariables.getDBcontactBorrowerState().get());
	            		System.out.println("DBcontactBorrowerZip = " + StoredVariables.getDBcontactBorrowerZip().get());
	            		System.out.println("");
	            		
	            		// Set info to null
	            		String borrowerDayPhone = "NULL";
	            		String borrowerEveningPhone = "NULL";
	            		String borrowerFax = "NULL";
	            		String borrowerEmail = "NULL";
	            		String borrowerPager = "NULL";
	            		String borrowerMobile = "NULL";
	            		
	            		// Set info used for Info 1 dropdown
	            		if (StoredVariables.getcontactBorrowerInfo1Dropdown().get().equals("Work"))
	            		{
	            			borrowerDayPhone = StoredVariables.getcontactBorrowerInfo1().get().replace("-","");
	            		}
	            		else if (StoredVariables.getcontactBorrowerInfo1Dropdown().get().equals("Home"))
	            		{
	            			borrowerEveningPhone = StoredVariables.getcontactBorrowerInfo1().get().replace("-","");
	            		}
	            		else if (StoredVariables.getcontactBorrowerInfo1Dropdown().get().equals("Fax"))
	            		{
	            			borrowerFax = StoredVariables.getcontactBorrowerInfo1().get().replace("-","");
	            		}
	            		else if (StoredVariables.getcontactBorrowerInfo1Dropdown().get().equals("E-mail"))
	            		{
	            			borrowerEmail = StoredVariables.getcontactBorrowerInfo1().get();
	            		}
	            		else if (StoredVariables.getcontactBorrowerInfo1Dropdown().get().equals("Pager"))
	            		{
	            			borrowerPager = StoredVariables.getcontactBorrowerInfo1().get().replace("-","");
	            		}
	            		else if (StoredVariables.getcontactBorrowerInfo1Dropdown().get().equals("Mobile"))
	            		{
	            			borrowerMobile = StoredVariables.getcontactBorrowerInfo1().get().replace("-","");
	            		}
	            		
	            		// Set info used for Info 2 dropdown
	            		if (StoredVariables.getcontactBorrowerInfo2Dropdown().get().equals("Work"))
	            		{
	            			borrowerDayPhone = StoredVariables.getcontactBorrowerInfo2().get().replace("-","");
	            		}
	            		else if (StoredVariables.getcontactBorrowerInfo2Dropdown().get().equals("Home"))
	            		{
	            			borrowerEveningPhone = StoredVariables.getcontactBorrowerInfo2().get().replace("-","");
	            		}
	            		else if (StoredVariables.getcontactBorrowerInfo2Dropdown().get().equals("Fax"))
	            		{
	            			borrowerFax = StoredVariables.getcontactBorrowerInfo2().get().replace("-","");
	            		}
	            		else if (StoredVariables.getcontactBorrowerInfo2Dropdown().get().equals("E-mail"))
	            		{
	            			borrowerEmail = StoredVariables.getcontactBorrowerInfo2().get();
	            		}
	            		else if (StoredVariables.getcontactBorrowerInfo2Dropdown().get().equals("Pager"))
	            		{
	            			borrowerPager = StoredVariables.getcontactBorrowerInfo2().get().replace("-","");
	            		}
	            		else if (StoredVariables.getcontactBorrowerInfo2Dropdown().get().equals("Mobile"))
	            		{
	            			borrowerMobile = StoredVariables.getcontactBorrowerInfo2().get().replace("-","");
	            		}
	            		
	            		String borrowerAddress1 = "NULL";
	            		String borrowerCity = "NULL";
	            		String borrowerState = "NULL";
	            		String borrowerZip = "NULL";

	            		if (!StoredVariables.getcontactBorrowerAddress().get().equals("") || !StoredVariables.getcontactBorrowerAddress().get().isEmpty())
	            		{
	            			borrowerAddress1 = StoredVariables.getcontactBorrowerAddress().get();
	            		}
	            		
	            		if (!StoredVariables.getcontactBorrowerCity().get().equals("") || !StoredVariables.getcontactBorrowerCity().get().isEmpty())
	            		{
	            			borrowerCity = StoredVariables.getcontactBorrowerCity().get();
	            		}
	            		
	            		if (!StoredVariables.getcontactBorrowerState().get().equals("") || !StoredVariables.getcontactBorrowerState().get().isEmpty())
	            		{
	            			borrowerState = StoredVariables.getcontactBorrowerState().get();
	            		}
	            		
	            		if (!StoredVariables.getcontactBorrowerZip().get().equals("") || !StoredVariables.getcontactBorrowerZip().get().isEmpty())
	            		{
	            			borrowerZip = StoredVariables.getcontactBorrowerZip().get();
	            		}

	            		// Verify data is correct in the database
	            		String borrowerName = StoredVariables.getcontactBorrower().get() + "-" + StoredVariables.getborrowerIdentifier().get();
	            		Assert.assertTrue(borrowerName.contains(StoredVariables.getDBcontactBorrower().get()), "Borrower Name in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + borrowerName + " DB - " + StoredVariables.getDBcontactBorrower().get());
	            		
	            		Assert.assertTrue(borrowerDayPhone.equals(DBcontactBorrowerDayPhone), "Borrower Work/Day Phone in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + borrowerDayPhone + " DB - " + DBcontactBorrowerDayPhone);
	            		
	            		Assert.assertTrue(borrowerEveningPhone.equals(DBcontactBorrowerEveningPhone), "Borrower Home/Evening Phone in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + borrowerEveningPhone + " DB - " + DBcontactBorrowerEveningPhone);
	            		
	            		Assert.assertTrue(borrowerFax.equals(DBcontactBorrowerFax), "Borrower Fax in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + borrowerFax + " DB - " + DBcontactBorrowerFax);
	            		
	            		Assert.assertTrue(borrowerEmail.equals(DBcontactBorrowerEmail), "Borrower Email in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + borrowerEmail + " DB - " + DBcontactBorrowerEmail);
	            		
	            		Assert.assertTrue(borrowerPager.equals(DBcontactBorrowerPager), "Borrower Pager in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + borrowerPager + " DB - " + DBcontactBorrowerPager);
	            		
	            		Assert.assertTrue(borrowerMobile.equals(DBcontactBorrowerMobile), "Borrower Mobile in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + borrowerMobile + " DB - " + DBcontactBorrowerMobile);
	            		
	            		if (!StoredVariables.getcalledFrom().get().contains("ulsOrders"))
	            		{
	            			
		            		Assert.assertTrue(borrowerAddress1.equals(DBcontactBorrowerAddress1), "Borrower Address1 in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
		            				" ----- Should be = " + borrowerAddress1 + " DB - " + DBcontactBorrowerAddress1);
		            		
		            		Assert.assertTrue(borrowerCity.equals(StoredVariables.getDBcontactBorrowerCity().get()), "Borrower City in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
		            				" ----- Should be = " + borrowerCity + " DB - " + StoredVariables.getDBcontactBorrowerCity().get());
		            		
		            		Assert.assertTrue(borrowerState.equals(StoredVariables.getDBcontactBorrowerState().get()), "Borrower State in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
		            				" ----- Should be = " + borrowerState + " DB - " + StoredVariables.getDBcontactBorrowerState().get());
		            		
		            		Assert.assertTrue(borrowerZip.equals(StoredVariables.getDBcontactBorrowerZip().get()), "Borrower Zip in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
		            				" ----- Should be = " + borrowerZip + " DB - " + StoredVariables.getDBcontactBorrowerZip().get());
	            			
	            		}
	            		
					} // end while loop
				    
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
		
	} // end verifyNewOrderDataInDB_BorrowerInformation
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the DB Connection String</li>
	 * 	<li>Load the required JDBC Driver class</li>
	 * 	<li>Execute the sql query</li>
	 * 	<li>While Loop to iterate through all data and print results</li>
	 * 	<li>Print out info to the console</li>
	 * 	<li>Set info to null</li>
	 * 	<li>Set info used for Info 1 dropdown</li>
	 * 	<li>Set info used for Info 2 dropdown</li>
	 * 	<li>Verify data is correct in the database</li>
	 * 	<li>Handle any errors</li>
	 * 	<li>Close the database connection</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param loanID the loan ID
	 * @throws Exception the exception
	 */
	// Verify New Order CoBorrower Information data got entered into the db correctly
	public  void verifyNewOrderDataInDB_CoBorrowerInformation(RemoteWebDriver driver, String loanID) throws Exception 
	{
		
		// Set the DB Connection String
		String dbUrl = perform.setDBConnectionString(driver, "Mercury");
		
		String coBorrowerInformationSQL = "SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED SELECT FirstName, DayPhone, EveningPhone, Fax, Email, Pager, Mobile, Address1, City, State, Zip "
				+ "FROM Contacts c WHERE c.LoanID = '" + loanID + "' AND ListPropertyContactID = '6'";
		
		System.out.println("coBorrowerInformationSQL" + coBorrowerInformationSQL);
		
		//Load the required JDBC Driver class
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
		
	 	Connection conn = null;
	 	
	 	try {
	 	    	conn = DriverManager.getConnection(dbUrl);

			 	Statement stmt = null;
			 	ResultSet rs = null;

			 	try
			 	{
			 	  	stmt = conn.createStatement();
			 	   
				    // Execute the sql query
				    rs = stmt.executeQuery(coBorrowerInformationSQL);
				    
	         		// While Loop to iterate through all data and print results		
					while (rs.next()){

						StoredVariables.getDBcontactCoBorrower().set(rs.getString(1));
	                    if (rs.wasNull())
	                    {
	                    	StoredVariables.getDBcontactCoBorrower().set("NULL");
	                    }
	                    String DBcontactCoBorrowerDayPhone = rs.getString(2);
	                    if (rs.wasNull())
	                    {
	                    	DBcontactCoBorrowerDayPhone = "NULL";
	                    }
	                    String DBcontactCoBorrowerEveningPhone = rs.getString(3);
	                    if (rs.wasNull())
	                    {
	                    	DBcontactCoBorrowerEveningPhone = "NULL";
	                    }
	                    String DBcontactCoBorrowerFax = rs.getString(4);
	                    if (rs.wasNull())
	                    {
	                    	DBcontactCoBorrowerFax = "NULL";
	                    }
	                    String DBcontactCoBorrowerEmail = rs.getString(5);
	                    if (rs.wasNull())
	                    {
	                    	DBcontactCoBorrowerEmail = "NULL";
	                    }
	                    String DBcontactCoBorrowerPager = rs.getString(6);
	                    if (rs.wasNull())
	                    {
	                    	DBcontactCoBorrowerPager = "NULL";
	                    }
	                    String DBcontactCoBorrowerMobile = rs.getString(7);
	                    if (rs.wasNull())
	                    {
	                    	DBcontactCoBorrowerMobile = "NULL";
	                    }
	                    String DBcontactCoBorrowerAddress1 = rs.getString(8);
	                    if (rs.wasNull())
	                    {
	                    	DBcontactCoBorrowerAddress1 = "NULL";
	                    }
	                    StoredVariables.getDBcontactCoBorrowerCity().set(rs.getString(9));
	                    if (rs.wasNull())
	                    {
	                    	StoredVariables.getDBcontactCoBorrowerCity().set("NULL");
	                    }
	                    StoredVariables.getDBcontactCoBorrowerState().set(rs.getString(10));
	                    if (rs.wasNull())
	                    {
	                    	StoredVariables.getDBcontactCoBorrowerState().set("NULL");
	                    }
	                    StoredVariables.getDBcontactCoBorrowerZip().set(rs.getString(11));
	                    if (rs.wasNull())
	                    {
	                    	StoredVariables.getDBcontactCoBorrowerZip().set("NULL");
	                    }
	                    
	            		// Print out info to the console
	            		System.out.println("DBcontactCoBorrower = " + StoredVariables.getDBcontactCoBorrower().get());
	            		System.out.println("DBcontactCoBorrowerDayPhone = " + DBcontactCoBorrowerDayPhone);
	            		System.out.println("DBcontactCoBorrowerEveningPhone = " + DBcontactCoBorrowerEveningPhone);
	            		System.out.println("DBcontactCoBorrowerFax = " + DBcontactCoBorrowerFax);
	            		System.out.println("DBcontactCoBorrowerEmail = " + DBcontactCoBorrowerEmail);
	            		System.out.println("DBcontactCoBorrowerPager = " + DBcontactCoBorrowerPager);
	            		System.out.println("DBcontactCoBorrowerMobile = " + DBcontactCoBorrowerMobile);
	            		System.out.println("DBcontactCoBorrowerAddress1 = " + DBcontactCoBorrowerAddress1);
	            		System.out.println("DBcontactCoBorrowerCity = " + StoredVariables.getDBcontactCoBorrowerCity().get());
	            		System.out.println("DBcontactCoBorrowerState = " + StoredVariables.getDBcontactCoBorrowerState().get());
	            		System.out.println("DBcontactCoBorrowerZip = " + StoredVariables.getDBcontactCoBorrowerZip().get());
	            		System.out.println("");
	            		
	            		// Set info to null
	            		String CoBorrowerDayPhone = "NULL";
	            		String CoBorrowerEveningPhone = "NULL";
	            		String CoBorrowerFax = "NULL";
	            		String CoBorrowerEmail = "NULL";
	            		String CoBorrowerPager = "NULL";
	            		String CoBorrowerMobile = "NULL";
	            		
	            		// Set info used for Info 1 dropdown
	            		if (StoredVariables.getcontactCoBorrowerInfo1Dropdown().get().equals("Work"))
	            		{
	            			CoBorrowerDayPhone = StoredVariables.getcontactCoBorrowerInfo1().get().replace("-","");
	            		}
	            		else if (StoredVariables.getcontactCoBorrowerInfo1Dropdown().get().equals("Home"))
	            		{
	            			CoBorrowerEveningPhone = StoredVariables.getcontactCoBorrowerInfo1().get().replace("-","");
	            		}
	            		else if (StoredVariables.getcontactCoBorrowerInfo1Dropdown().get().equals("Fax"))
	            		{
	            			CoBorrowerFax = StoredVariables.getcontactCoBorrowerInfo1().get().replace("-","");
	            		}
	            		else if (StoredVariables.getcontactCoBorrowerInfo1Dropdown().get().equals("E-mail"))
	            		{
	            			CoBorrowerEmail = StoredVariables.getcontactCoBorrowerInfo1().get();
	            		}
	            		else if (StoredVariables.getcontactCoBorrowerInfo1Dropdown().get().equals("Pager"))
	            		{
	            			CoBorrowerPager = StoredVariables.getcontactCoBorrowerInfo1().get().replace("-","");
	            		}
	            		else if (StoredVariables.getcontactCoBorrowerInfo1Dropdown().get().equals("Mobile"))
	            		{
	            			CoBorrowerMobile = StoredVariables.getcontactCoBorrowerInfo1().get().replace("-","");
	            		}
	            		
	            		// Set info used for Info 2 dropdown
	            		if (StoredVariables.getcontactCoBorrowerInfo2Dropdown().get().equals("Work"))
	            		{
	            			CoBorrowerDayPhone = StoredVariables.getcontactCoBorrowerInfo2().get().replace("-","");
	            		}
	            		else if (StoredVariables.getcontactCoBorrowerInfo2Dropdown().get().equals("Home"))
	            		{
	            			CoBorrowerEveningPhone = StoredVariables.getcontactCoBorrowerInfo2().get().replace("-","");
	            		}
	            		else if (StoredVariables.getcontactCoBorrowerInfo2Dropdown().get().equals("Fax"))
	            		{
	            			CoBorrowerFax = StoredVariables.getcontactCoBorrowerInfo2().get().replace("-","");
	            		}
	            		else if (StoredVariables.getcontactCoBorrowerInfo2Dropdown().get().equals("E-mail"))
	            		{
	            			CoBorrowerEmail = StoredVariables.getcontactCoBorrowerInfo2().get();
	            		}
	            		else if (StoredVariables.getcontactCoBorrowerInfo2Dropdown().get().equals("Pager"))
	            		{
	            			CoBorrowerPager = StoredVariables.getcontactCoBorrowerInfo2().get().replace("-","");
	            		}
	            		else if (StoredVariables.getcontactCoBorrowerInfo2Dropdown().get().equals("Mobile"))
	            		{
	            			CoBorrowerMobile = StoredVariables.getcontactCoBorrowerInfo2().get().replace("-","");
	            		}
	            		
	            		String CoBorrowerAddress1 = "NULL";
	            		String CoBorrowerCity = "NULL";
	            		String CoBorrowerState = "NULL";
	            		String CoBorrowerZip = "NULL";

	            		if (!StoredVariables.getcontactCoBorrowerAddress().get().equals("") || !StoredVariables.getcontactCoBorrowerAddress().get().isEmpty())
	            		{
	            			CoBorrowerAddress1 = StoredVariables.getcontactCoBorrowerAddress().get();
	            		}
	            		
	            		if (!StoredVariables.getcontactCoBorrowerCity().get().equals("") || !StoredVariables.getcontactCoBorrowerCity().get().isEmpty())
	            		{
	            			CoBorrowerCity = StoredVariables.getcontactCoBorrowerCity().get();
	            		}
	            		
	            		if (!StoredVariables.getcontactCoBorrowerState().get().equals("") || !StoredVariables.getcontactCoBorrowerState().get().isEmpty())
	            		{
	            			CoBorrowerState = StoredVariables.getcontactCoBorrowerState().get();
	            		}
	            		
	            		if (!StoredVariables.getcontactCoBorrowerZip().get().equals("") || !StoredVariables.getcontactCoBorrowerZip().get().isEmpty())
	            		{
	            			CoBorrowerZip = StoredVariables.getcontactCoBorrowerZip().get();
	            		}

	            		// Verify data is correct in the database
	            		String CoBorrowerName = StoredVariables.getcontactCoBorrower().get();
	            		Assert.assertTrue(CoBorrowerName.equals(StoredVariables.getDBcontactCoBorrower().get()), "CoBorrower Name in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + CoBorrowerName + " DB - " + StoredVariables.getDBcontactCoBorrower().get());
	            		
	            		Assert.assertTrue(CoBorrowerDayPhone.equals(DBcontactCoBorrowerDayPhone), "CoBorrower Work/Day Phone in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + CoBorrowerDayPhone + " DB - " + DBcontactCoBorrowerDayPhone);
	            		
	            		Assert.assertTrue(CoBorrowerEveningPhone.equals(DBcontactCoBorrowerEveningPhone), "CoBorrower Home/Evening Phone in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + CoBorrowerEveningPhone + " DB - " + DBcontactCoBorrowerEveningPhone);
	            		
	            		Assert.assertTrue(CoBorrowerFax.equals(DBcontactCoBorrowerFax), "CoBorrower Fax in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + CoBorrowerFax + " DB - " + DBcontactCoBorrowerFax);
	            		
	            		Assert.assertTrue(CoBorrowerEmail.equals(DBcontactCoBorrowerEmail), "CoBorrower Email in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + CoBorrowerEmail + " DB - " + DBcontactCoBorrowerEmail);
	            		
	            		Assert.assertTrue(CoBorrowerPager.equals(DBcontactCoBorrowerPager), "CoBorrower Pager in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + CoBorrowerPager + " DB - " + DBcontactCoBorrowerPager);
	            		
	            		Assert.assertTrue(CoBorrowerMobile.equals(DBcontactCoBorrowerMobile), "CoBorrower Mobile in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + CoBorrowerMobile + " DB - " + DBcontactCoBorrowerMobile);
	            		
	            		if (!StoredVariables.getcalledFrom().get().contains("ulsOrders"))
	            		{
	            			
		            		Assert.assertTrue(CoBorrowerAddress1.equals(DBcontactCoBorrowerAddress1), "CoBorrower Address1 in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
		            				" ----- Should be = " + CoBorrowerAddress1 + " DB - " + DBcontactCoBorrowerAddress1);
		            		
		            		Assert.assertTrue(CoBorrowerCity.equals(StoredVariables.getDBcontactCoBorrowerCity().get()), "CoBorrower City in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
		            				" ----- Should be = " + CoBorrowerCity + " DB - " + StoredVariables.getDBcontactCoBorrowerCity().get());
		            		
		            		Assert.assertTrue(CoBorrowerState.equals(StoredVariables.getDBcontactCoBorrowerState().get()), "CoBorrower State in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
		            				" ----- Should be = " + CoBorrowerState + " DB - " + StoredVariables.getDBcontactCoBorrowerState().get());
		            		
		            		Assert.assertTrue(CoBorrowerZip.equals(StoredVariables.getDBcontactCoBorrowerZip().get()), "CoBorrower Zip in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
		            				" ----- Should be = " + CoBorrowerZip + " DB - " + StoredVariables.getDBcontactCoBorrowerZip().get());
	            			
	            		}
	            		
					} // end while loop
				    
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
		
	} // end verifyNewOrderDataInDB_CoBorrowerInformation
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the DB Connection String</li>
	 * 	<li>Load the required JDBC Driver class</li>
	 * 	<li>Execute the sql query</li>
	 * 	<li>While Loop to iterate through all data and print results</li>
	 * 	<li>Print out info to the console</li>
	 * 	<li>Set info to null</li>
	 * 	<li>Set info used for Info 1 dropdown</li>
	 * 	<li>Set info used for Info 2 dropdown</li>
	 * 	<li>Verify data is correct in the database</li>
	 * 	<li>Handle any errors</li>
	 * 	<li>Close the database connection</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param loanID the loan ID
	 * @throws Exception the exception
	 */
	// Verify New Order Owner Information data got entered into the db correctly
	public  void verifyNewOrderDataInDB_OwnerInformation(RemoteWebDriver driver, String loanID) throws Exception 
	{
		
		// Set the DB Connection String
		String dbUrl = perform.setDBConnectionString(driver, "Mercury");
		
		String ownerInformationSQL = "SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED SELECT FirstName, DayPhone, EveningPhone, Fax, Email, Pager, Mobile "
				+ "FROM Contacts c WHERE c.LoanID = '" + loanID + "' AND ListPropertyContactID = '1'";		
		
		System.out.println("ownerInformationSQL" + ownerInformationSQL);
		
		//Load the required JDBC Driver class
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
		
	 	Connection conn = null;
	 	
	 	try {
	 	    	conn = DriverManager.getConnection(dbUrl);

			 	Statement stmt = null;
			 	ResultSet rs = null;

			 	try
			 	{
			 	  	stmt = conn.createStatement();
			 	   
				    // Execute the sql query
				    rs = stmt.executeQuery(ownerInformationSQL);
				    
	         		// While Loop to iterate through all data and print results		
					while (rs.next()){

						StoredVariables.getDBcontactOwner().set(rs.getString(1));
	                    if (rs.wasNull())
	                    {
	                    	StoredVariables.getDBcontactOwner().set("NULL");
	                    }
	                    String DBcontactOwnerDayPhone = rs.getString(2);
	                    if (rs.wasNull())
	                    {
	                    	DBcontactOwnerDayPhone = "NULL";
	                    }
	                    String DBcontactOwnerEveningPhone = rs.getString(3);
	                    if (rs.wasNull())
	                    {
	                    	DBcontactOwnerEveningPhone = "NULL";
	                    }
	                    String DBcontactOwnerFax = rs.getString(4);
	                    if (rs.wasNull())
	                    {
	                    	DBcontactOwnerFax = "NULL";
	                    }
	                    String DBcontactOwnerEmail = rs.getString(5);
	                    if (rs.wasNull())
	                    {
	                    	DBcontactOwnerEmail = "NULL";
	                    }
	                    String DBcontactOwnerPager = rs.getString(6);
	                    if (rs.wasNull())
	                    {
	                    	DBcontactOwnerPager = "NULL";
	                    }
	                    String DBcontactOwnerMobile = rs.getString(7);
	                    if (rs.wasNull())
	                    {
	                    	DBcontactOwnerMobile = "NULL";
	                    }
	                    String DBcontactOwnerAddress1 = rs.getString(8);
	                    if (rs.wasNull())
	                    {
	                    	DBcontactOwnerAddress1 = "NULL";
	                    }
	                    
	            		// Print out info to the console
	            		System.out.println("DBcontactOwner = " + StoredVariables.getDBcontactOwner().get());
	            		System.out.println("DBcontactOwnerDayPhone = " + DBcontactOwnerDayPhone);
	            		System.out.println("DBcontactOwnerEveningPhone = " + DBcontactOwnerEveningPhone);
	            		System.out.println("DBcontactOwnerFax = " + DBcontactOwnerFax);
	            		System.out.println("DBcontactOwnerEmail = " + DBcontactOwnerEmail);
	            		System.out.println("DBcontactOwnerPager = " + DBcontactOwnerPager);
	            		System.out.println("DBcontactOwnerMobile = " + DBcontactOwnerMobile);
	            		System.out.println("DBcontactOwnerAddress1 = " + DBcontactOwnerAddress1);
	            		System.out.println("");
	            		
	            		// Set info to null
	            		String OwnerDayPhone = "NULL";
	            		String OwnerEveningPhone = "NULL";
	            		String OwnerFax = "NULL";
	            		String OwnerEmail = "NULL";
	            		String OwnerPager = "NULL";
	            		String OwnerMobile = "NULL";
	            		
	            		// Set info used for Info 1 dropdown
	            		if (StoredVariables.getcontactOwnerInfo1Dropdown().get().equals("Work"))
	            		{
	            			OwnerDayPhone = StoredVariables.getcontactOwnerInfo1().get().replace("-","");
	            		}
	            		else if (StoredVariables.getcontactOwnerInfo1Dropdown().get().equals("Home"))
	            		{
	            			OwnerEveningPhone = StoredVariables.getcontactOwnerInfo1().get().replace("-","");
	            		}
	            		else if (StoredVariables.getcontactOwnerInfo1Dropdown().get().equals("Fax"))
	            		{
	            			OwnerFax = StoredVariables.getcontactOwnerInfo1().get().replace("-","");
	            		}
	            		else if (StoredVariables.getcontactOwnerInfo1Dropdown().get().equals("E-mail"))
	            		{
	            			OwnerEmail = StoredVariables.getcontactOwnerInfo1().get();
	            		}
	            		else if (StoredVariables.getcontactOwnerInfo1Dropdown().get().equals("Pager"))
	            		{
	            			OwnerPager = StoredVariables.getcontactOwnerInfo1().get().replace("-","");
	            		}
	            		else if (StoredVariables.getcontactOwnerInfo1Dropdown().get().equals("Mobile"))
	            		{
	            			OwnerMobile = StoredVariables.getcontactOwnerInfo1().get().replace("-","");
	            		}
	            		
	            		// Set info used for Info 2 dropdown
	            		if (StoredVariables.getcontactOwnerInfo2Dropdown().get().equals("Work"))
	            		{
	            			OwnerDayPhone = StoredVariables.getcontactOwnerInfo2().get().replace("-","");
	            		}
	            		else if (StoredVariables.getcontactOwnerInfo2Dropdown().get().equals("Home"))
	            		{
	            			OwnerEveningPhone = StoredVariables.getcontactOwnerInfo2().get().replace("-","");
	            		}
	            		else if (StoredVariables.getcontactOwnerInfo2Dropdown().get().equals("Fax"))
	            		{
	            			OwnerFax = StoredVariables.getcontactOwnerInfo2().get().replace("-","");
	            		}
	            		else if (StoredVariables.getcontactOwnerInfo2Dropdown().get().equals("E-mail"))
	            		{
	            			OwnerEmail = StoredVariables.getcontactOwnerInfo2().get();
	            		}
	            		else if (StoredVariables.getcontactOwnerInfo2Dropdown().get().equals("Pager"))
	            		{
	            			OwnerPager = StoredVariables.getcontactOwnerInfo2().get().replace("-","");
	            		}
	            		else if (StoredVariables.getcontactOwnerInfo2Dropdown().get().equals("Mobile"))
	            		{
	            			OwnerMobile = StoredVariables.getcontactOwnerInfo2().get().replace("-","");
	            		}
	            		
	            		// Verify data is correct in the database
	            		String OwnerName = StoredVariables.getcontactOwner().get();
	            		Assert.assertTrue(OwnerName.equals(StoredVariables.getDBcontactOwner().get()), "Owner Name in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + OwnerName + " DB - " + StoredVariables.getDBcontactOwner().get());
	            		
	            		Assert.assertTrue(OwnerDayPhone.equals(DBcontactOwnerDayPhone), "Owner Work/Day Phone in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + OwnerDayPhone + " DB - " + DBcontactOwnerDayPhone);
	            		
	            		Assert.assertTrue(OwnerEveningPhone.equals(DBcontactOwnerEveningPhone), "Owner Home/Evening Phone in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + OwnerEveningPhone + " DB - " + DBcontactOwnerEveningPhone);
	            		
	            		Assert.assertTrue(OwnerFax.equals(DBcontactOwnerFax), "Owner Fax in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + OwnerFax + " DB - " + DBcontactOwnerFax);
	            		
	            		Assert.assertTrue(OwnerEmail.equals(DBcontactOwnerEmail), "Owner Email in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + OwnerEmail + " DB - " + DBcontactOwnerEmail);
	            		
	            		Assert.assertTrue(OwnerPager.equals(DBcontactOwnerPager), "Owner Pager in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + OwnerPager + " DB - " + DBcontactOwnerPager);
	            		
	            		Assert.assertTrue(OwnerMobile.equals(DBcontactOwnerMobile), "Owner Mobile in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + OwnerMobile + " DB - " + DBcontactOwnerMobile);
	            		
					} // end while loop
				    
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
		
	} // end verifyNewOrderDataInDB_OwnerInformation
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the DB Connection String</li>
	 * 	<li>Load the required JDBC Driver class</li>
	 * 	<li>Execute the sql query</li>
	 * 	<li>While Loop to iterate through all data and print results</li>
	 * 	<li>Print out info to the console</li>
	 * 	<li>Set info to null</li>
	 * 	<li>Set info used for Info 1 dropdown</li>
	 * 	<li>Set info used for Info 2 dropdown</li>
	 * 	<li>Verify data is correct in the database</li>
	 * 	<li>handle any errors</li>
	 * 	<li>Close the database connection</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param loanID the loan ID
	 * @throws Exception the exception
	 */
	// Verify New Order Occupant Information data got entered into the db correctly
	public  void verifyNewOrderDataInDB_OccupantInformation(RemoteWebDriver driver, String loanID) throws Exception 
	{
		
		// Set the DB Connection String
		String dbUrl = perform.setDBConnectionString(driver, "Mercury");
		
		String occupantInformationSQL = "SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED SELECT FirstName, DayPhone, EveningPhone, Fax, Email, Pager, Mobile "
				+ "FROM Contacts c WHERE c.LoanID = '" + loanID + "' AND ListPropertyContactID = '2'";
		
		System.out.println("occupantInformationSQL" + occupantInformationSQL);
		
		//Load the required JDBC Driver class
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
		
	 	Connection conn = null;
	 	
	 	try {
	 	    	conn = DriverManager.getConnection(dbUrl);

			 	Statement stmt = null;
			 	ResultSet rs = null;

			 	try
			 	{
			 	  	stmt = conn.createStatement();
			 	   
				    // Execute the sql query
				    rs = stmt.executeQuery(occupantInformationSQL);
				    
	         		// While Loop to iterate through all data and print results		
					while (rs.next()){

						StoredVariables.getDBcontactOccupant().set(rs.getString(1));
	                    if (rs.wasNull())
	                    {
	                    	StoredVariables.getDBcontactOccupant().set("NULL");
	                    }
	                    String DBcontactOccupantDayPhone = rs.getString(2);
	                    if (rs.wasNull())
	                    {
	                    	DBcontactOccupantDayPhone = "NULL";
	                    }
	                    String DBcontactOccupantEveningPhone = rs.getString(3);
	                    if (rs.wasNull())
	                    {
	                    	DBcontactOccupantEveningPhone = "NULL";
	                    }
	                    String DBcontactOccupantFax = rs.getString(4);
	                    if (rs.wasNull())
	                    {
	                    	DBcontactOccupantFax = "NULL";
	                    }
	                    String DBcontactOccupantEmail = rs.getString(5);
	                    if (rs.wasNull())
	                    {
	                    	DBcontactOccupantEmail = "NULL";
	                    }
	                    String DBcontactOccupantPager = rs.getString(6);
	                    if (rs.wasNull())
	                    {
	                    	DBcontactOccupantPager = "NULL";
	                    }
	                    String DBcontactOccupantMobile = rs.getString(7);
	                    if (rs.wasNull())
	                    {
	                    	DBcontactOccupantMobile = "NULL";
	                    }
	                    String DBcontactOccupantAddress1 = rs.getString(8);
	                    if (rs.wasNull())
	                    {
	                    	DBcontactOccupantAddress1 = "NULL";
	                    }
	                    
	            		// Print out info to the console
	            		System.out.println("DBcontactOccupant = " + StoredVariables.getDBcontactOccupant().get());
	            		System.out.println("DBcontactOccupantDayPhone = " + DBcontactOccupantDayPhone);
	            		System.out.println("DBcontactOccupantEveningPhone = " + DBcontactOccupantEveningPhone);
	            		System.out.println("DBcontactOccupantFax = " + DBcontactOccupantFax);
	            		System.out.println("DBcontactOccupantEmail = " + DBcontactOccupantEmail);
	            		System.out.println("DBcontactOccupantPager = " + DBcontactOccupantPager);
	            		System.out.println("DBcontactOccupantMobile = " + DBcontactOccupantMobile);
	            		System.out.println("DBcontactOccupantAddress1 = " + DBcontactOccupantAddress1);
	            		System.out.println("");
	            		
	            		// Set info to null
	            		String OccupantDayPhone = "NULL";
	            		String OccupantEveningPhone = "NULL";
	            		String OccupantFax = "NULL";
	            		String OccupantEmail = "NULL";
	            		String OccupantPager = "NULL";
	            		String OccupantMobile = "NULL";
	            		
	            		// Set info used for Info 1 dropdown
	            		if (StoredVariables.getcontactOccupantInfo1Dropdown().get().equals("Work"))
	            		{
	            			OccupantDayPhone = StoredVariables.getcontactOccupantInfo1().get().replace("-","");
	            		}
	            		else if (StoredVariables.getcontactOccupantInfo1Dropdown().get().equals("Home"))
	            		{
	            			OccupantEveningPhone = StoredVariables.getcontactOccupantInfo1().get().replace("-","");
	            		}
	            		else if (StoredVariables.getcontactOccupantInfo1Dropdown().get().equals("Fax"))
	            		{
	            			OccupantFax = StoredVariables.getcontactOccupantInfo1().get().replace("-","");
	            		}
	            		else if (StoredVariables.getcontactOccupantInfo1Dropdown().get().equals("E-mail"))
	            		{
	            			OccupantEmail = StoredVariables.getcontactOccupantInfo1().get();
	            		}
	            		else if (StoredVariables.getcontactOccupantInfo1Dropdown().get().equals("Pager"))
	            		{
	            			OccupantPager = StoredVariables.getcontactOccupantInfo1().get().replace("-","");
	            		}
	            		else if (StoredVariables.getcontactOccupantInfo1Dropdown().get().equals("Mobile"))
	            		{
	            			OccupantMobile = StoredVariables.getcontactOccupantInfo1().get().replace("-","");
	            		}
	            		
	            		// Set info used for Info 2 dropdown
	            		if (StoredVariables.getcontactOccupantInfo2Dropdown().get().equals("Work"))
	            		{
	            			OccupantDayPhone = StoredVariables.getcontactOccupantInfo2().get().replace("-","");
	            		}
	            		else if (StoredVariables.getcontactOccupantInfo2Dropdown().get().equals("Home"))
	            		{
	            			OccupantEveningPhone = StoredVariables.getcontactOccupantInfo2().get().replace("-","");
	            		}
	            		else if (StoredVariables.getcontactOccupantInfo2Dropdown().get().equals("Fax"))
	            		{
	            			OccupantFax = StoredVariables.getcontactOccupantInfo2().get().replace("-","");
	            		}
	            		else if (StoredVariables.getcontactOccupantInfo2Dropdown().get().equals("E-mail"))
	            		{
	            			OccupantEmail = StoredVariables.getcontactOccupantInfo2().get();
	            		}
	            		else if (StoredVariables.getcontactOccupantInfo2Dropdown().get().equals("Pager"))
	            		{
	            			OccupantPager = StoredVariables.getcontactOccupantInfo2().get().replace("-","");
	            		}
	            		else if (StoredVariables.getcontactOccupantInfo2Dropdown().get().equals("Mobile"))
	            		{
	            			OccupantMobile = StoredVariables.getcontactOccupantInfo2().get().replace("-","");
	            		}
	            		
	            		// Verify data is correct in the database
	            		String OccupantName = StoredVariables.getcontactOccupant().get();
	            		Assert.assertTrue(OccupantName.equals(StoredVariables.getDBcontactOccupant().get()), "Occupant Name in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + OccupantName + " DB - " + StoredVariables.getDBcontactOccupant().get());
	            		
	            		Assert.assertTrue(OccupantDayPhone.equals(DBcontactOccupantDayPhone), "Occupant Work/Day Phone in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + OccupantDayPhone + " DB - " + DBcontactOccupantDayPhone);
	            		
	            		Assert.assertTrue(OccupantEveningPhone.equals(DBcontactOccupantEveningPhone), "Occupant Home/Evening Phone in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + OccupantEveningPhone + " DB - " + DBcontactOccupantEveningPhone);
	            		
	            		Assert.assertTrue(OccupantFax.equals(DBcontactOccupantFax), "Occupant Fax in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + OccupantFax + " DB - " + DBcontactOccupantFax);
	            		
	            		Assert.assertTrue(OccupantEmail.equals(DBcontactOccupantEmail), "Occupant Email in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + OccupantEmail + " DB - " + DBcontactOccupantEmail);
	            		
	            		Assert.assertTrue(OccupantPager.equals(DBcontactOccupantPager), "Occupant Pager in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + OccupantPager + " DB - " + DBcontactOccupantPager);
	            		
	            		Assert.assertTrue(OccupantMobile.equals(DBcontactOccupantMobile), "Occupant Mobile in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + OccupantMobile + " DB - " + DBcontactOccupantMobile);
	            		
					} // end while loop
				    
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
		
	} // end verifyNewOrderDataInDB_OccupantInformation
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the DB Connection String</li>
	 * 	<li>Load the required JDBC Driver class</li>
	 * 	<li>Execute the sql query</li>
	 * 	<li>While Loop to iterate through all data and print results</li>
	 * 	<li>Print out info to the console</li>
	 * 	<li>Set info to null</li>
	 * 	<li>Set info used for Info 1 dropdown</li>
	 * 	<li>Set info used for Info 2 dropdown</li>
	 * 	<li>Verify data is correct in the database</li>
	 * 	<li>handle any errors</li>
	 * 	<li>Close the database connection</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param loanID the loan ID
	 * @throws Exception the exception
	 */
	// Verify New Order Agent Information data got entered into the db correctly
	public  void verifyNewOrderDataInDB_AgentInformation(RemoteWebDriver driver, String loanID) throws Exception 
	{
		
		// Set the DB Connection String
		String dbUrl = perform.setDBConnectionString(driver, "Mercury");
		
		String agentInformationSQL = "SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED SELECT FirstName, DayPhone, EveningPhone, Fax, Email, Pager, Mobile "
				+ "FROM Contacts c WHERE c.LoanID = '" + loanID + "' AND ListPropertyContactID = '3'";
		
		System.out.println("agentInformationSQL" + agentInformationSQL);
		
		//Load the required JDBC Driver class
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
		
	 	Connection conn = null;
	 	
	 	try {
	 	    	conn = DriverManager.getConnection(dbUrl);

			 	Statement stmt = null;
			 	ResultSet rs = null;

			 	try
			 	{
			 	  	stmt = conn.createStatement();
			 	   
				    // Execute the sql query
				    rs = stmt.executeQuery(agentInformationSQL);
				    
	         		// While Loop to iterate through all data and print results		
					while (rs.next()){

						StoredVariables.getDBcontactAgent().set(rs.getString(1));
	                    if (rs.wasNull())
	                    {
	                    	StoredVariables.getDBcontactAgent().set("NULL");
	                    }
	                    String DBcontactAgentDayPhone = rs.getString(2);
	                    if (rs.wasNull())
	                    {
	                    	DBcontactAgentDayPhone = "NULL";
	                    }
	                    String DBcontactAgentEveningPhone = rs.getString(3);
	                    if (rs.wasNull())
	                    {
	                    	DBcontactAgentEveningPhone = "NULL";
	                    }
	                    String DBcontactAgentFax = rs.getString(4);
	                    if (rs.wasNull())
	                    {
	                    	DBcontactAgentFax = "NULL";
	                    }
	                    String DBcontactAgentEmail = rs.getString(5);
	                    if (rs.wasNull())
	                    {
	                    	DBcontactAgentEmail = "NULL";
	                    }
	                    String DBcontactAgentPager = rs.getString(6);
	                    if (rs.wasNull())
	                    {
	                    	DBcontactAgentPager = "NULL";
	                    }
	                    String DBcontactAgentMobile = rs.getString(7);
	                    if (rs.wasNull())
	                    {
	                    	DBcontactAgentMobile = "NULL";
	                    }
	                    String DBcontactAgentAddress1 = rs.getString(8);
	                    if (rs.wasNull())
	                    {
	                    	DBcontactAgentAddress1 = "NULL";
	                    }
	                    
	            		// Print out info to the console
	            		System.out.println("DBcontactAgent = " + StoredVariables.getDBcontactAgent().get());
	            		System.out.println("DBcontactAgentDayPhone = " + DBcontactAgentDayPhone);
	            		System.out.println("DBcontactAgentEveningPhone = " + DBcontactAgentEveningPhone);
	            		System.out.println("DBcontactAgentFax = " + DBcontactAgentFax);
	            		System.out.println("DBcontactAgentEmail = " + DBcontactAgentEmail);
	            		System.out.println("DBcontactAgentPager = " + DBcontactAgentPager);
	            		System.out.println("DBcontactAgentMobile = " + DBcontactAgentMobile);
	            		System.out.println("DBcontactAgentAddress1 = " + DBcontactAgentAddress1);
	            		System.out.println("");
	            		
	            		// Set info to null
	            		String AgentDayPhone = "NULL";
	            		String AgentEveningPhone = "NULL";
	            		String AgentFax = "NULL";
	            		String AgentEmail = "NULL";
	            		String AgentPager = "NULL";
	            		String AgentMobile = "NULL";
	            		
	            		// Set info used for Info 1 dropdown
	            		if (StoredVariables.getcontactAgentInfo1Dropdown().get().equals("Work"))
	            		{
	            			AgentDayPhone = StoredVariables.getcontactAgentInfo1().get().replace("-","");
	            		}
	            		else if (StoredVariables.getcontactAgentInfo1Dropdown().get().equals("Home"))
	            		{
	            			AgentEveningPhone = StoredVariables.getcontactAgentInfo1().get().replace("-","");
	            		}
	            		else if (StoredVariables.getcontactAgentInfo1Dropdown().get().equals("Fax"))
	            		{
	            			AgentFax = StoredVariables.getcontactAgentInfo1().get().replace("-","");
	            		}
	            		else if (StoredVariables.getcontactAgentInfo1Dropdown().get().equals("E-mail"))
	            		{
	            			AgentEmail = StoredVariables.getcontactAgentInfo1().get();
	            		}
	            		else if (StoredVariables.getcontactAgentInfo1Dropdown().get().equals("Pager"))
	            		{
	            			AgentPager = StoredVariables.getcontactAgentInfo1().get().replace("-","");
	            		}
	            		else if (StoredVariables.getcontactAgentInfo1Dropdown().get().equals("Mobile"))
	            		{
	            			AgentMobile = StoredVariables.getcontactAgentInfo1().get().replace("-","");
	            		}
	            		
	            		// Set info used for Info 2 dropdown
	            		if (StoredVariables.getcontactAgentInfo2Dropdown().get().equals("Work"))
	            		{
	            			AgentDayPhone = StoredVariables.getcontactAgentInfo2().get().replace("-","");
	            		}
	            		else if (StoredVariables.getcontactAgentInfo2Dropdown().get().equals("Home"))
	            		{
	            			AgentEveningPhone = StoredVariables.getcontactAgentInfo2().get().replace("-","");
	            		}
	            		else if (StoredVariables.getcontactAgentInfo2Dropdown().get().equals("Fax"))
	            		{
	            			AgentFax = StoredVariables.getcontactAgentInfo2().get().replace("-","");
	            		}
	            		else if (StoredVariables.getcontactAgentInfo2Dropdown().get().equals("E-mail"))
	            		{
	            			AgentEmail = StoredVariables.getcontactAgentInfo2().get();
	            		}
	            		else if (StoredVariables.getcontactAgentInfo2Dropdown().get().equals("Pager"))
	            		{
	            			AgentPager = StoredVariables.getcontactAgentInfo2().get().replace("-","");
	            		}
	            		else if (StoredVariables.getcontactAgentInfo2Dropdown().get().equals("Mobile"))
	            		{
	            			AgentMobile = StoredVariables.getcontactAgentInfo2().get().replace("-","");
	            		}
	            		
	            		// Verify data is correct in the database
	            		String AgentName = StoredVariables.getcontactAgent().get();
	            		Assert.assertTrue(AgentName.equals(StoredVariables.getDBcontactAgent().get()), "Agent Name in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + AgentName + " DB - " + StoredVariables.getDBcontactAgent().get());
	            		
	            		Assert.assertTrue(AgentDayPhone.equals(DBcontactAgentDayPhone), "Agent Work/Day Phone in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + AgentDayPhone + " DB - " + DBcontactAgentDayPhone);
	            		
	            		Assert.assertTrue(AgentEveningPhone.equals(DBcontactAgentEveningPhone), "Agent Home/Evening Phone in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + AgentEveningPhone + " DB - " + DBcontactAgentEveningPhone);
	            		
	            		Assert.assertTrue(AgentFax.equals(DBcontactAgentFax), "Agent Fax in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + AgentFax + " DB - " + DBcontactAgentFax);
	            		
	            		Assert.assertTrue(AgentEmail.equals(DBcontactAgentEmail), "Agent Email in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + AgentEmail + " DB - " + DBcontactAgentEmail);
	            		
	            		Assert.assertTrue(AgentPager.equals(DBcontactAgentPager), "Agent Pager in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + AgentPager + " DB - " + DBcontactAgentPager);
	            		
	            		Assert.assertTrue(AgentMobile.equals(DBcontactAgentMobile), "Agent Mobile in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + AgentMobile + " DB - " + DBcontactAgentMobile);
	            		
					} // end while loop
				    
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
		
	} // end verifyNewOrderDataInDB_AgentInformation
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the DB Connection String</li>
	 * 	<li>Load the required JDBC Driver class</li>
	 * 	<li>Execute the sql query</li>
	 * 	<li>While Loop to iterate through all data and print results</li>
	 * 	<li>Print out info to the console</li>
	 * 	<li>Set info to null</li>
	 * 	<li>Set info used for Info 1 dropdown</li>
	 * 	<li>Set info used for Info 2 dropdown</li>
	 * 	<li>Verify data is correct in the database</li>
	 * 	<li>handle any errors</li>
	 * 	<li>Close the database connection</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param loanID the loan ID
	 * @throws Exception the exception
	 */
	// Verify New Order Other Information data got entered into the db correctly
	public  void verifyNewOrderDataInDB_OtherInformation(RemoteWebDriver driver, String loanID) throws Exception 
	{
		
		// Set the DB Connection String
		String dbUrl = perform.setDBConnectionString(driver, "Mercury");
		
		String otherInformationSQL = "SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED SELECT FirstName, DayPhone, EveningPhone, Fax, Email, Pager, Mobile "
				+ "FROM Contacts c WHERE c.LoanID = '" + loanID + "' AND ListPropertyContactID = '4'";
		
		System.out.println("otherInformationSQL" + otherInformationSQL);
		
		//Load the required JDBC Driver class
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
		
	 	Connection conn = null;
	 	
	 	try {
	 	    	conn = DriverManager.getConnection(dbUrl);

			 	Statement stmt = null;
			 	ResultSet rs = null;

			 	try
			 	{
			 	  	stmt = conn.createStatement();
			 	   
				    // Execute the sql query
				    rs = stmt.executeQuery(otherInformationSQL);
				    
	         		// While Loop to iterate through all data and print results		
					while (rs.next()){

						StoredVariables.getDBcontactOther().set(rs.getString(1));
	                    if (rs.wasNull())
	                    {
	                    	StoredVariables.getDBcontactOther().set("NULL");
	                    }
	                    String DBcontactOtherDayPhone = rs.getString(2);
	                    if (rs.wasNull())
	                    {
	                    	DBcontactOtherDayPhone = "NULL";
	                    }
	                    String DBcontactOtherEveningPhone = rs.getString(3);
	                    if (rs.wasNull())
	                    {
	                    	DBcontactOtherEveningPhone = "NULL";
	                    }
	                    String DBcontactOtherFax = rs.getString(4);
	                    if (rs.wasNull())
	                    {
	                    	DBcontactOtherFax = "NULL";
	                    }
	                    String DBcontactOtherEmail = rs.getString(5);
	                    if (rs.wasNull())
	                    {
	                    	DBcontactOtherEmail = "NULL";
	                    }
	                    String DBcontactOtherPager = rs.getString(6);
	                    if (rs.wasNull())
	                    {
	                    	DBcontactOtherPager = "NULL";
	                    }
	                    String DBcontactOtherMobile = rs.getString(7);
	                    if (rs.wasNull())
	                    {
	                    	DBcontactOtherMobile = "NULL";
	                    }
	                    String DBcontactOtherAddress1 = rs.getString(8);
	                    if (rs.wasNull())
	                    {
	                    	DBcontactOtherAddress1 = "NULL";
	                    }
	                    
	            		// Print out info to the console
	            		System.out.println("DBcontactOther = " + StoredVariables.getDBcontactOther().get());
	            		System.out.println("DBcontactOtherDayPhone = " + DBcontactOtherDayPhone);
	            		System.out.println("DBcontactOtherEveningPhone = " + DBcontactOtherEveningPhone);
	            		System.out.println("DBcontactOtherFax = " + DBcontactOtherFax);
	            		System.out.println("DBcontactOtherEmail = " + DBcontactOtherEmail);
	            		System.out.println("DBcontactOtherPager = " + DBcontactOtherPager);
	            		System.out.println("DBcontactOtherMobile = " + DBcontactOtherMobile);
	            		System.out.println("DBcontactOtherAddress1 = " + DBcontactOtherAddress1);
	            		System.out.println("");
	            		
	            		// Set info to null
	            		String OtherDayPhone = "NULL";
	            		String OtherEveningPhone = "NULL";
	            		String OtherFax = "NULL";
	            		String OtherEmail = "NULL";
	            		String OtherPager = "NULL";
	            		String OtherMobile = "NULL";
	            		
	            		// Set info used for Info 1 dropdown
	            		if (StoredVariables.getcontactOtherInfo1Dropdown().get().equals("Work"))
	            		{
	            			OtherDayPhone = StoredVariables.getcontactOtherInfo1().get().replace("-","");
	            		}
	            		else if (StoredVariables.getcontactOtherInfo1Dropdown().get().equals("Home"))
	            		{
	            			OtherEveningPhone = StoredVariables.getcontactOtherInfo1().get().replace("-","");
	            		}
	            		else if (StoredVariables.getcontactOtherInfo1Dropdown().get().equals("Fax"))
	            		{
	            			OtherFax = StoredVariables.getcontactOtherInfo1().get().replace("-","");
	            		}
	            		else if (StoredVariables.getcontactOtherInfo1Dropdown().get().equals("E-mail"))
	            		{
	            			OtherEmail = StoredVariables.getcontactOtherInfo1().get();
	            		}
	            		else if (StoredVariables.getcontactOtherInfo1Dropdown().get().equals("Pager"))
	            		{
	            			OtherPager = StoredVariables.getcontactOtherInfo1().get().replace("-","");
	            		}
	            		else if (StoredVariables.getcontactOtherInfo1Dropdown().get().equals("Mobile"))
	            		{
	            			OtherMobile = StoredVariables.getcontactOtherInfo1().get().replace("-","");
	            		}
	            		
	            		// Set info used for Info 2 dropdown
	            		if (StoredVariables.getcontactOtherInfo2Dropdown().get().equals("Work"))
	            		{
	            			OtherDayPhone = StoredVariables.getcontactOtherInfo2().get().replace("-","");
	            		}
	            		else if (StoredVariables.getcontactOtherInfo2Dropdown().get().equals("Home"))
	            		{
	            			OtherEveningPhone = StoredVariables.getcontactOtherInfo2().get().replace("-","");
	            		}
	            		else if (StoredVariables.getcontactOtherInfo2Dropdown().get().equals("Fax"))
	            		{
	            			OtherFax = StoredVariables.getcontactOtherInfo2().get().replace("-","");
	            		}
	            		else if (StoredVariables.getcontactOtherInfo2Dropdown().get().equals("E-mail"))
	            		{
	            			OtherEmail = StoredVariables.getcontactOtherInfo2().get();
	            		}
	            		else if (StoredVariables.getcontactOtherInfo2Dropdown().get().equals("Pager"))
	            		{
	            			OtherPager = StoredVariables.getcontactOtherInfo2().get().replace("-","");
	            		}
	            		else if (StoredVariables.getcontactOtherInfo2Dropdown().get().equals("Mobile"))
	            		{
	            			OtherMobile = StoredVariables.getcontactOtherInfo2().get().replace("-","");
	            		}
	            		
	            		// Verify data is correct in the database
	            		String OtherName = StoredVariables.getcontactOther().get();
	            		Assert.assertTrue(OtherName.equals(StoredVariables.getDBcontactOther().get()), "Other Name in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + OtherName + " DB - " + StoredVariables.getDBcontactOther().get());
	            		
	            		Assert.assertTrue(OtherDayPhone.equals(DBcontactOtherDayPhone), "Other Work/Day Phone in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + OtherDayPhone + " DB - " + DBcontactOtherDayPhone);
	            		
	            		Assert.assertTrue(OtherEveningPhone.equals(DBcontactOtherEveningPhone), "Other Home/Evening Phone in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + OtherEveningPhone + " DB - " + DBcontactOtherEveningPhone);
	            		
	            		Assert.assertTrue(OtherFax.equals(DBcontactOtherFax), "Other Fax in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + OtherFax + " DB - " + DBcontactOtherFax);
	            		
	            		Assert.assertTrue(OtherEmail.equals(DBcontactOtherEmail), "Other Email in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + OtherEmail + " DB - " + DBcontactOtherEmail);
	            		
	            		Assert.assertTrue(OtherPager.equals(DBcontactOtherPager), "Other Pager in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + OtherPager + " DB - " + DBcontactOtherPager);
	            		
	            		Assert.assertTrue(OtherMobile.equals(DBcontactOtherMobile), "Other Mobile in the database doesn't equal what it should for this order - " + StoredVariables.getloanID().get() + 
	            				" ----- Should be = " + OtherMobile + " DB - " + DBcontactOtherMobile);
	            		
					} // end while loop
				    
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
		
	} // end verifyNewOrderDataInDB_OtherInformation
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set SQL query</li>
	 * 	<li>Execute query against the database</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param loanID the loan ID
	 * @return the tracking number
	 * @throws Exception the exception
	 */
	// Get tracking number
	public String getTrackingNumber(RemoteWebDriver driver, String loanID) throws Exception 
	{
	
		// Set SQL query
		String getTrackingNumberSQL = "SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED SELECT TrackingNumber FROM Loans WHERE LoanID = '"+loanID.replaceAll("[^\\d.]", "")+"'";

		// Execute query against the database
		String trackingNumber = queryDB(driver, "Mercury", getTrackingNumberSQL);
	
		return trackingNumber;
		
	} // end getTrackingNumber
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set SQL query</li>
	 * 	<li>Set the DB Connection String</li>
	 * 	<li>Load the required JDBC Driver class</li>
	 * 	<li>Execute the sql query</li>
	 * 	<li>retrieve the values of all returned rows and store them in a list</li>
	 * 	<li>Get order numbers</li>
	 * 	<li>handle any errors</li>
	 * 	<li>Close the database connection</li>
	 * 	<li>Set the Tracking Numbers</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @return the loan Ids from EVF client portal order
	 * @throws Exception the exception
	 */
	// Get Loan ID's From VMP Client Portal Order
	public  List<String> getLoanIDsFromEVFClientPortalOrder(RemoteWebDriver driver) throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		
		// Set SQL query
		String getLoanIDsSQL = "SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED SELECT pi.LoanID FROM Properties p JOIN ProductItems pi ON p.LoanID = pi.LoanID " +
									"WHERE p.Address1 = '" + StoredVariables.getpropertyInformationAddress().get() + "' AND Directions LIKE '%" + StoredVariables.getdirectionsIdentifier().get() + "'";
		
		// Set the DB Connection String
		String dbUrl = perform.setDBConnectionString(driver, "Mercury");
		
		//Load the required JDBC Driver class
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
		
	 	Connection conn = null;
	 	List<String> results = null;
	 	
	 	try {
	 	    	conn = DriverManager.getConnection(dbUrl);

			 	Statement stmt = null;
			 	ResultSet rs = null;

			 	try
			 	{
			 	  	stmt = conn.createStatement();
			 	   
				    // Execute the sql query
			 	  	System.out.println("sqlStatement = " + getLoanIDsSQL);
				    rs = stmt.executeQuery(getLoanIDsSQL);
				    
				    // retrieve the values of all returned rows and store them in a list
				    results = new ArrayList<String>();
					while(rs.next()) {
					results.add(rs.getString(1));
					}
					
					// Get order numbers
					StoredVariables.getloanIDVMP().set(results.get(0));
					StoredVariables.getloanID().set(results.get(1));
					StoredVariables.getloanIDAMC().set(results.get(2));
					
					StoredVariables.getresults().set(results);
					
				 	System.out.println("Database query result = " + results);
				 	
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
		
		// Set the Tracking Numbers
		StoredVariables.gettrackingNumber().set(getTrackingNumber(driver, results.get(1)));
		StoredVariables.gettrackingNumberVMP().set(getTrackingNumber(driver, results.get(0)));
		StoredVariables.gettrackingNumberAMC().set(getTrackingNumber(driver, results.get(2)));
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Database", "Got loan ID's from the database.<br>"
				+ "SQL Query: " + getLoanIDsSQL
				+ "<br><br>Resuls:"
				+ "<br>VMP Tracking Number: " + results.get(0)
				+ "<br>Secure Tracking Number: " + results.get(1)
				+ "<br>AMC Tracking Number: " + results.get(2));
		
		return results;
		
	} // end getOrderNumbersFromVMPClientPortalOrder
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set SQL query</li>
	 * 	<li>Set the DB Connection String</li>
	 * 	<li>Load the required JDBC Driver class</li>
	 * 	<li>Execute the sql query</li>
	 * 	<li>Execute the sql query</li>
	 * 	<li>retrieve the values of all returned rows and store them in a list</li>
	 * 	<li>Get order numbers</li>
	 * 	<li>handle any errors</li>
	 * 	<li>Close the database connection</li>
	 * 	<li>Set the Tracking Numbers</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @return the loan I ds from VMP client portal order
	 * @throws Exception the exception
	 */
	// Get Loan ID's From VMP Client Portal Order
	public  List<String> getLoanIDsFromVMPClientPortalOrder(RemoteWebDriver driver) throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		
		Thread.sleep(10000);
		
		// Set SQL query
		String getLoanIDsSQL = "SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED SELECT pi.LoanID FROM Properties p JOIN ProductItems pi ON p.LoanID = pi.LoanID " +
									"WHERE Directions LIKE '%" + StoredVariables.getdirectionsIdentifier().get() + "'";
		
		// Set the DB Connection String
		String dbUrl = perform.setDBConnectionString(driver, "Mercury");
		
		//Load the required JDBC Driver class
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
		
	 	Connection conn = null;
	 	List<String> results = null;
	 	
	 	try {
	 	    	conn = DriverManager.getConnection(dbUrl);

			 	Statement stmt = null;
			 	ResultSet rs = null;

			 	try
			 	{
			 	  	stmt = conn.createStatement();
			 	   
				    // Execute the sql query
			 	  	System.out.println("sqlStatement = " + getLoanIDsSQL);
			 	  	
			 	  	int size = 0;
					int attempt = 1;
					while (size < 2 && attempt <= 10) {
					    // Execute the sql query
				 	  	System.out.println("Executing attempt " + attempt);
					    rs = stmt.executeQuery(getLoanIDsSQL);
						
					    // retrieve the values of all returned rows and store them in a list
					    results = new ArrayList<String>();
						while(rs.next()) {
						results.add(rs.getString(1));
						}
						size = results.size();
						Thread.sleep(3000);
						attempt++;
					} // end while
					
					// Get order numbers
					StoredVariables.getloanIDVMP().set(results.get(0));
					StoredVariables.getloanID().set(results.get(1));
					
					StoredVariables.getresults().set(results);
				 	
				 	System.out.println("Database query result = " + results);
				 	
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
		
		// Set the Tracking Numbers
		StoredVariables.gettrackingNumber().set(getTrackingNumber(driver, results.get(1)));
		StoredVariables.gettrackingNumberVMP().set(getTrackingNumber(driver, results.get(0)));
		
		
		// Add info to Extent Report
		test.log(LogStatus.INFO, "Database", "Got loan ID's from the database.<br>"
				+ "SQL Query: " + getLoanIDsSQL
				+ "<br><br>Resuls:"
				+ "<br>VMP Tracking Number: " + results.get(0)
				+ "<br>Secure Tracking Number: " + results.get(1));
		
		return results;
		
	} // end getOrderNumbersFromVMPClientPortalOrder
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set SQL query</li>
	 * 	<li>Execute query against the database</li>
	 * 	<li>Set the Tracking Numbers</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @return the loan ID
	 * @throws Exception the exception
	 */
	// Get Loan ID
	public String getLoanID(RemoteWebDriver driver) throws Exception 
	{

		// Set SQL query
		String getLoanIDSQL = "SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED SELECT pi.LoanID FROM Properties p JOIN ProductItems pi ON p.LoanID = pi.LoanID " +
									"WHERE p.Address1 = '" + StoredVariables.getpropertyInformationAddress().get() + "' AND Directions like '%" + StoredVariables.getdirectionsIdentifier().get() + "%'";
		
		// Execute query against the database
		StoredVariables.getloanID().set(queryDB(driver, "Mercury", getLoanIDSQL));
		
		// Set the Tracking Numbers
		StoredVariables.gettrackingNumber().set(getTrackingNumber(driver, StoredVariables.getloanID().get()));

		System.out.println("Loan ID = " + StoredVariables.getloanID().get());
		
		return StoredVariables.getloanID().get();
		
	} // end getOrderNumber
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set SQL query</li>
	 * 	<li>Execute query against the database</li>
	 * 	<li>Set the Loan ID</li>
	 * </ul>.
	 *
	 * @param driver the driver
	 * @param trackingNumber the tracking number
	 * @return the loan ID
	 * @throws Exception the exception
	 */
	// Get Loan ID
	public String getLoanIDFromTrackingNumber(RemoteWebDriver driver, String trackingNumber) throws Exception 
	{

		// Set SQL query
		String getLoanIDSQL = "SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED SELECT LoanID FROM Loans " + 
				"WHERE TrackingNumber LIKE '%"+trackingNumber+"%'";
		
		// Execute query against the database
		StoredVariables.getloanID().set(queryDB(driver, "Mercury", getLoanIDSQL));
		
		System.out.println("Loan ID = " + StoredVariables.getloanID().get());
		
		return StoredVariables.getloanID().get();
		
	} // end getLoanIDFromTrackingNumber
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Remove MERC- from the String</li>
	 * 	<li>If there are multiple parts to the loanID, get the last part</li>
	 * 	<li>Count the number of parts</li>
	 * 	<li>Get the last part</li>
	 * 	<li>Set the loanID1</li>
	 * 	<li>Set SQL query</li>
	 * 	<li>Execute query against the database</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param loanID the loan ID
	 * @return the product item ID
	 * @throws Exception the exception
	 */
	// Get property id
	public String getProductItemID(RemoteWebDriver driver, String loanID) throws Exception 
	{

		// Remove MERC- from the String
		loanID = loanID.replace("MERC-", "");
		
		// If there are multiple parts to the loanID, get the last part
		if (loanID.contains("-")) {
			
			// Count the number of parts
			String parts[] = loanID.split("-");
			
			// Get the last part
			int length = parts.length-1;
			
			// Set the loanID1
			loanID = parts[length];
			
		} // end if
		
		// Set SQL query
		String getProductItemIDSQL = "SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED SELECT ProductItemID FROM ProductItems " +
									"WHERE LoanID = '" + loanID + "'";
		
		// Execute query against the database
		String productItemID = queryDB(driver, "Mercury", getProductItemIDSQL);

		System.out.println("ProductItemID = " + productItemID);
		
		return productItemID;
		
	} // end getProductItemID
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set SQL query</li>
	 * 	<li>Execute query against the database</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param firstName the first name
	 * @param lastName the last name
	 * @return the vendor entity ID
	 * @throws Exception the exception
	 */
	// Get Entity ID
	public String getVendorEntityID(RemoteWebDriver driver, String firstName, String lastName) throws Exception 
	{

		System.out.println("Get the Entity ID of " + firstName + " " + lastName);
		
		String env = StoredVariables.getusernameEnvironment().get();
		
		// Set SQL query
		String getEntityIDIdSQL = "SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED SELECT TOP 1 EntityID FROM Entities WHERE FirstName = '"+firstName+"' AND LastName = '"+lastName+"' AND EntityTypeID in (1,32) AND Email LIKE '%"+env+"%'";
		
		// Execute query against the database
		String entityID = queryDB(driver, "Mercury", getEntityIDIdSQL);
		
		System.out.println("Entity ID = " + entityID);
		
		return entityID;
		
	} // end getEntityID
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get orderNumber</li>
	 * 	<li>Set SQL query</li>
	 * 	<li>Execute query against the database</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @return the vendor ID for order
	 * @throws Exception the exception
	 */
	// Get Vendor ID for on order
	public String getVendorIDForOrder(RemoteWebDriver driver) throws Exception 
	{

		// Get orderNumber
		getLoanID(driver);
		
		// Set SQL query
		String getVendorIdSQL = "SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED SELECT VendorID FROM ProductItems WHERE LoanID = " + StoredVariables.getloanID().get();
		
		// Execute query against the database
		StoredVariables.getvendorID().set(queryDB(driver, "Mercury", getVendorIdSQL));
		
		System.out.println("Vendor ID = " + StoredVariables.getvendorID().get());
		
		return StoredVariables.getvendorID().get();
		
	} // end getVendorID
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get Vendor ID</li>
	 * 	<li>Set SQL query</li>
	 * 	<li>Execute query against the database</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @return the vendor email
	 * @throws Exception the exception
	 */
	// Get Vendor Email Address
	public String getVendorEmail(RemoteWebDriver driver) throws Exception 
	{

		// Get Vendor ID
		getVendorIDForOrder(driver);
		
		// Set SQL query
		String getVendorEmailSQL = "SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED SELECT Email FROM Entities WHERE EntityID = " + StoredVariables.getvendorID().get();
		
		// Execute query against the database
		StoredVariables.getvendorEmail().set(queryDB(driver, "Mercury", getVendorEmailSQL));
		
		System.out.println("Vendor Email = " + StoredVariables.getvendorEmail().get());
		
		return StoredVariables.getvendorEmail().get();
		
	} // end getVendorEmail
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set SQL Query</li>
	 * 	<li>Execute query against the database</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param loanID the loan ID
	 * @return the vendor email from loan ID
	 * @throws Exception the exception
	 */
	// Get Vendor Email Address from Order Number
	public String getVendorEmailFromLoanID(RemoteWebDriver driver, String loanID) throws Exception 
	{

		// Set SQL Query
		String getVendorEmailSQL = "SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED SELECT Email FROM Entities WHERE EntityID = "
				+ "(SELECT EntityID FROM mercuryvendors WHERE certcontactid = "
				+ "(SELECT AssignedCertContactID FROM ProductItems WHERE LoanID = '" + loanID + "'))";
		
		// Execute query against the database
		StoredVariables.getvendorEmail().set(queryDB(driver, "Mercury", getVendorEmailSQL));
		
		System.out.println("Vendor Email = " + StoredVariables.getvendorEmail().get());
		
		return StoredVariables.getvendorEmail().get();
		
	} // end getVendorEmail
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set SQL Query</li>
	 * 	<li>Execute query against the database</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param loanID the loan ID
	 * @return the vendor last name from loan ID
	 * @throws Exception the exception
	 */
	// Get Vendor Last Name from Order Number
	public String getVendorLastNameFromLoanID(RemoteWebDriver driver, String loanID) throws Exception 
	{

		// Set SQL Query
		String getVendorEmailSQL = "SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED SELECT LastName FROM Entities WHERE EntityID = "
				+ "(SELECT EntityID FROM mercuryvendors WHERE certcontactid = "
				+ "(SELECT AssignedCertContactID FROM ProductItems WHERE LoanID = '" + loanID + "'))";
		
		// Execute query against the database
		StoredVariables.getvendorEmail().set(queryDB(driver, "Mercury", getVendorEmailSQL));
		
		System.out.println("Vendor Last Name = " + StoredVariables.getvendorEmail().get());
		
		return StoredVariables.getvendorEmail().get();
		
	} // end getVendorEmail
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get environment</li>
	 * 	<li>Set SQL query</li>
	 * 	<li>Execute query against the database</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param user the user
	 * @return the AWS account number
	 * @throws Exception the exception
	 */
	// Get AWS Account number
	public String getAWSAccountNumber(RemoteWebDriver driver, String user) throws Exception 
	{

		// Get environment
		String env = StoredVariables.getusernameEnvironment().get();
		
		// Set SQL query
		String getAWSAccountNumberSQL = "SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED SELECT AWSAccountsID FROM AWSAccounts " +
									"WHERE Email like 'automation"+env+user+"%' ";
		
		// Execute query against the database
		String awsAccountNumber = queryDB(driver, "XSData", getAWSAccountNumberSQL);

		return awsAccountNumber;
		
	} // end getAWSAccountNumber
	
	/**
	 * Update DB.
	 *
	 * @param driver the driver
	 * @param database the database
	 * @param sqlStatement the sql statement
	 * @throws Exception the exception
	 */
	public void updateDB(RemoteWebDriver driver, String database, String sqlStatement) throws Exception {
		
		// Set the DB Connection String
		String dbUrl = perform.setDBConnectionString(driver, database);
		
		// Execute the update statement
		executeUpdateDB(driver, database, sqlStatement, dbUrl);
		
	} // end updateDB
	
	/**
	 * Update DB.
	 *
	 * @param driver the driver
	 * @param environment the environment
	 * @param database the database
	 * @param sqlStatement the sql statement
	 * @throws Exception the exception
	 */
	public void updateDB(RemoteWebDriver driver, String environment, String database, String sqlStatement) throws Exception {
		
		// Set the DB Connection String
		String dbUrl = perform.setDBConnectionString(driver, environment, database);
		
		// Execute the update statement
		executeUpdateDB(driver, database, sqlStatement, dbUrl);
		
	} // end updateDB
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the DB Connection String</li>
	 * 	<li>Load the required JDBC Driver class</li>
	 * 	<li>Connect to the database and run the insert statements</li>
	 * 	<li>Execute sql statements</li>
	 * 	<li>Log if no rows were inserted</li>
	 * 	<li>handle any errors</li>
	 * 	<li>Close the database connection</li>
	 * </ul>.
	 *
	 * @param driver the driver
	 * @param database the database
	 * @param sqlStatement the sql statement
	 * @param dbUrl the db url
	 * @throws Exception the exception
	 */
	// Update the database
	public void executeUpdateDB(RemoteWebDriver driver, String database, String sqlStatement, String dbUrl) throws Exception {

		//Load the required JDBC Driver class
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		// Connect to the database and run the insert statements
		Connection conn = null;
	 	
	 	try {
	 		
	 			conn = DriverManager.getConnection(dbUrl);

			 	Statement stmt = null;
			 	stmt = conn.createStatement();
			 	
			 	// Execute sql statements
			 	StoredVariables.getnumRowsUpdated().set(stmt.executeUpdate(sqlStatement));
			 	
				// Log if no rows were inserted
				if (StoredVariables.getnumRowsUpdated().get() < 1)
				{
					System.out.println("No rows were inserted into the database");
				}
				else
				{
					System.out.println("Executing the following update statement = \n\n" + sqlStatement + "\n\n");
				}
			 	
	 	} catch (SQLException ex) {
	 	    // handle any errors
	 	    System.out.println("SQLException: " + ex.getMessage());
	 	    System.out.println("SQLState: " + ex.getSQLState());
	 	    System.out.println("VendorError: " + ex.getErrorCode());
	 	} // end try/catch statement to run sql
		
		// Close the database connection
		conn.close();
			
	} // end updateDB
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Query to run against the DB to get all of the automation unpaid invoices</li>
	 * 	<li>Get the array of the unpaid invoices order numbers</li>
	 * 	<li>Build Strings to execute the MarkPaid StoredProc</li>
	 * 	<li>If there are unpaid invoices, print the SQL to the console</li>
	 * 	<li>If there are unpaid invoices and tests are being ran on a QA environment, execute the StoredProcs</li>
	 * 	<li>Execute query against the database</li>
	 * 	<li>If there are unpaid invoices and tests are being ran on a non-QA environment, send email that contains the SQL to execute the StoredProcs</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws Exception the exception
	 */
	// Check for Unpaid Invoices and send an email if found
	public  void checkForUnpaidInvoices(RemoteWebDriver driver) throws Exception 
	{
		
		// Query to run against the DB to get all of the automation unpaid invoices
		String getUnpaidInvoicesSQL = ""
				+ "SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED SELECT DISTINCT OrderNumber FROM CompanyData.dbo.MercuryLineItems" + 
				" WHERE PassportID IN (" + 
				" SELECT PassportID" + 
				" FROM Mercury.dbo.MercuryLenders" + 
				" WHERE CustomerNumber IN (" + 
				" SELECT DISTINCT ALMCustomerNumber" + 
				" FROM Mercury.dbo.Entities" + 
				" WHERE (CompanyName LIKE 'automation%' AND Email LIKE '%@dntest.net')" + 
				" OR (CompanyName LIKE '%auto%payment%' AND Email LIKE '%@dntest.net')" + 
				" OR (CompanyName LIKE '%full%store%' AND Email LIKE '%@cliftonc.com')" + 
				" OR (CompanyName LIKE '%vendor%store%' AND Email LIKE '%@cliftonc.com')" + 
				" OR (CompanyName LIKE '%mode%real%' AND Email LIKE '%@cliftonc.com')" + 
				" OR (CompanyName LIKE '%mode%fake%' AND Email LIKE '%@cliftonc.com')" + 
				" OR (FirstName LIKE '%Auto%Int%QA%')" + 
				" AND ALMCustomerNumber IS NOT NULL)" + 
				" UNION ALL" + 
				" SELECT PassportID" + 
				" FROM Mercury.dbo.MercuryVendors" + 
				" WHERE CustomerNumber IN (" + 
				" SELECT DISTINCT ALMCustomerNumber" + 
				" FROM Mercury.dbo.Entities" + 
				" WHERE (CompanyName LIKE 'automation%' AND Email LIKE '%@dntest.net')" + 
				" OR (CompanyName LIKE '%auto%payment%' AND Email LIKE '%@dntest.net')" + 
				" OR (CompanyName LIKE '%full%store%' AND Email LIKE '%@cliftonc.com')" + 
				" OR (CompanyName LIKE '%vendor%store%' AND Email LIKE '%@cliftonc.com')" + 
				" OR (CompanyName LIKE '%mode%real%' AND Email LIKE '%@cliftonc.com')" + 
				" OR (CompanyName LIKE '%mode%fake%' AND Email LIKE '%@cliftonc.com')" + 
				" OR (FirstName LIKE '%Auto%Int%QA%')" + 
				" AND ALMCustomerNumber IS NOT NULL)" + 
				" )" + 
				" AND MercuryBillingStatusID NOT IN (4,8)";
		
		// Get the array of the unpaid invoices order numbers
		ArrayList<String> unpaidInvoices = queryDBArrayNoLog(driver, "Mercury", getUnpaidInvoicesSQL);
		
		// Build Strings to execute the MarkPaid StoredProc  
		StringBuilder out = new StringBuilder();
		for (Object o : unpaidInvoices)
		{
		  out.append("exec Mercury.dbo.MNUtil_Invoice_MarkPaid '" + o.toString() + "'");
		  out.append("\n");
		} // end for
		String removeUnpaidInvoicesSQL = out.toString();
		
		// If there are unpaid invoices, print the SQL to the console
		if (!removeUnpaidInvoicesSQL.isEmpty()) {
			System.out.println("removeUnpaidInvoicesSQL = " + removeUnpaidInvoicesSQL);	
		} // end if
		
		// If there are unpaid invoices and tests are being ran on a QA environment, execute the StoredProcs
		if (!unpaidInvoices.isEmpty() && StoredVariables.getusernameEnvironment().get().contains("QA"))
		{
			// Execute query against the database
			queryDBNoLog(driver, "Mercury", removeUnpaidInvoicesSQL);
			perform.sendEmail(driver, "dnorman@corelogic.com","","Removed Unpaid Invoices On " + StoredVariables.getusernameEnvironment().get(), removeUnpaidInvoicesSQL);
			System.out.println("\n\nUnpaid invoices have been removed\n\n");
		} // end if
		
		// If there are unpaid invoices and tests are being ran on a non-QA environment, send email that contains the SQL to execute the StoredProcs
		if (!unpaidInvoices.isEmpty() && !StoredVariables.getusernameEnvironment().get().contains("QA"))
		{
			perform.sendEmail(driver, "dnorman@corelogic.com","","Unpaid Invoices On " + StoredVariables.getusernameEnvironment().get(), removeUnpaidInvoicesSQL);
			System.out.println("\n\nUnpaid invoices have been found and the query to update them has been emailed\n\n");
		} // end if
		
	} // end checkForUnpaidInvoices
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the DB Connection String</li>
	 * 	<li>Load the required JDBC Driver class</li>
	 * 	<li>Create an empty array</li>
	 * 	<li>Execute the sql query</li>
	 * 	<li>While Loop to iterate through all data and print results</li>
	 * 	<li>Get MailQueueID</li>
	 * 	<li>Get UserID</li>
	 * 	<li>Get Type</li>
	 * 	<li>Get MailQueueTypeID</li>
	 * 	<li>Get MailFrom</li>
	 * 	<li>Get MailTo</li>
	 * 	<li>Get MailReplyTo</li>
	 * 	<li>Get MailCC</li>
	 * 	<li>Get Subject</li>
	 * 	<li>Get TemplateUsed</li>
	 * 	<li>Get Attachments</li>
	 * 	<li>Get SentDateTime</li>
	 * 	<li>Get Successful</li>
	 * 	<li>Get FromEntityID</li>
	 * 	<li>Get ToEntityID</li>
	 * 	<li>Get ProductItemID</li>
	 * 	<li>Get EnteredStamp</li>
	 * 	<li>Get MailQueueStatusID</li>
	 * 	<li>Get BodyFileID</li>
	 * 	<li>handle any errors</li>
	 * 	<li>Close the database connection</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param productItemID the product item ID
	 * @return the mail queue info by product item ID to array
	 * @throws Exception the exception
	 */
	// Get Mail Queue Information By ProductItemID to an Array
	public  ArrayList<String> getMailQueueInfoByProductItemIDToArray(RemoteWebDriver driver, String productItemID) throws Exception 
	{

		// Set the DB Connection String
		String dbUrl = perform.setDBConnectionString(driver, "Mercury");
		
		String getMailQueueSQL = "SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED SELECT * FROM [dbo].[MailQueue] WHERE ProductItemID = '" + productItemID + "'";
		System.out.println("getMailQueueSQL = " + getMailQueueSQL);
		
		//Load the required JDBC Driver class
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
		
	 	Connection conn = null;
	 	
	    // Create an empty array
	    ArrayList<String> resultList = new ArrayList<String>();
	    
	 	try {
	 	    	conn = DriverManager.getConnection(dbUrl);

			 	Statement stmt = null;
			 	ResultSet rs = null;

			 	try
			 	{
			 	  	stmt = conn.createStatement();
			 	   
				    // Execute the sql query
				    rs = stmt.executeQuery(getMailQueueSQL);
				    
	         		// While Loop to iterate through all data and print results		
					while (rs.next()){

						// Get MailQueueID
						String mailQueueID = rs.getString(1);
	                    if (rs.wasNull())
	                    {
	                    	mailQueueID = "NULL";
	                    }
				        resultList.add(mailQueueID);
				        
				        // Get UserID
				        String userID= rs.getString(2);
	                    if (rs.wasNull())
	                    {
	                    	userID = "NULL";
	                    }
				        resultList.add(userID);
				        
				        // Get Type
				        String type = rs.getString(3);
	                    if (rs.wasNull())
	                    {
	                    	type = "NULL";
	                    }
				        resultList.add(type);
				        
				        // Get MailQueueTypeID
				        String mailQueueTypeID = rs.getString(4);
	                    if (rs.wasNull())
	                    {
	                    	mailQueueTypeID = "NULL";
	                    }
				        resultList.add(mailQueueTypeID);
				        
				        // Get MailFrom
				        String mailFrom = rs.getString(5);
	                    if (rs.wasNull())
	                    {
	                    	mailFrom = "NULL";
	                    }
				        resultList.add(mailFrom);
				        
				        // Get MailTo
				        String mailTo = rs.getString(6);
	                    if (rs.wasNull())
	                    {
	                    	mailTo = "NULL";
	                    }
				        resultList.add(mailTo);
				        
				        // Get MailReplyTo
				        String mailReplyTo = rs.getString(7);
	                    if (rs.wasNull())
	                    {
	                    	mailReplyTo = "NULL";
	                    }
				        resultList.add(mailReplyTo);
				        
				        // Get MailCC
				        String mailCC = rs.getString(8);
	                    if (rs.wasNull())
	                    {
	                    	mailCC = "NULL";
	                    }
				        resultList.add(mailCC);
				        
				        // Get Subject
				        String subject = rs.getString(9);
	                    if (rs.wasNull())
	                    {
	                    	subject = "NULL";
	                    }
				        resultList.add(subject);
				        
				        // Get TemplateUsed
				        String templateUsed = rs.getString(10);
	                    if (rs.wasNull())
	                    {
	                    	templateUsed = "NULL";
	                    }
				        resultList.add(templateUsed);
				        
				        // Get Attachments
				        String attachments = rs.getString(11);
	                    if (rs.wasNull())
	                    {
	                    	attachments = "NULL";
	                    }
				        resultList.add(attachments);
				        
				        // Get SentDateTime
				        String sentDateTime = rs.getString(12);
	                    if (rs.wasNull())
	                    {
	                    	sentDateTime = "NULL";
	                    }
				        resultList.add(sentDateTime);
				        
				        // Get Successful
				        String successful = rs.getString(13);
	                    if (rs.wasNull())
	                    {
	                    	successful = "NULL";
	                    }
				        resultList.add(successful);
				        
				        // Get FromEntityID
				        String fromEntityID = rs.getString(14);
	                    if (rs.wasNull())
	                    {
	                    	fromEntityID = "NULL";
	                    }
				        resultList.add(fromEntityID);
				        
				        // Get ToEntityID
				        String toEntityID = rs.getString(15);
	                    if (rs.wasNull())
	                    {
	                    	toEntityID = "NULL";
	                    }
				        resultList.add(toEntityID);
				        
				        // Get ProductItemID
				        String productItem = rs.getString(16);
	                    if (rs.wasNull())
	                    {
	                    	productItem = "NULL";
	                    }
				        resultList.add(productItem);
				        
				        // Get EnteredStamp
				        String enteredStamp = rs.getString(17);
	                    if (rs.wasNull())
	                    {
	                    	enteredStamp = "NULL";
	                    }
				        resultList.add(enteredStamp);
				        
				        // Get MailQueueStatusID
				        String mailQueueStatusID = rs.getString(18);
	                    if (rs.wasNull())
	                    {
	                    	mailQueueStatusID = "NULL";
	                    }
				        resultList.add(mailQueueStatusID);
				        
				        // Get BodyFileID
				        String bodyFileID = rs.getString(19);
	                    if (rs.wasNull())
	                    {
	                    	bodyFileID = "NULL";
	                    }
				        resultList.add(bodyFileID);
				        
				        System.out.println(mailQueueID+"\t"+userID+"\t"+type+"\t"+mailQueueTypeID+"\t"+mailFrom+"\t"+mailTo+"\t"+mailReplyTo+"\t"+mailCC+"\t"+subject+"\t"+templateUsed+"\t"+attachments+"\t"+sentDateTime+"\t"+successful+"\t"+fromEntityID+"\t"+toEntityID+"\t"+productItem+"\t"+enteredStamp+"\t"+mailQueueStatusID+"\t"+bodyFileID);
				        
					} // end while loop
					
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
		System.out.println("MailQueue Results = " + resultList);
		return resultList;
		
	} // end getMailQueueInfoByProductItemIDToArray
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the DB Connection String</li>
	 * 	<li>Load the required JDBC Driver class</li>
	 * 	<li>Create an empty array</li>
	 * 	<li>Execute the sql query</li>
	 * 	<li>While Loop to iterate through all data and print results</li>
	 * 	<li>Get MailQueueID</li>
	 * 	<li>Get UserID</li>
	 * 	<li>Get Type</li>
	 * 	<li>Get MailQueueTypeID</li>
	 * 	<li>Get MailFrom</li>
	 * 	<li>Get MailTo</li>
	 * 	<li>Get MailReplyTo</li>
	 * 	<li>Get MailCC</li>
	 * 	<li>Get Subject</li>
	 * 	<li>Get TemplateUsed</li>
	 * 	<li>Get Attachments</li>
	 * 	<li>Get SentDateTime</li>
	 * 	<li>Get Successful</li>
	 * 	<li>Get FromEntityID</li>
	 * 	<li>Get ToEntityID</li>
	 * 	<li>Get ProductItemID</li>
	 * 	<li>Get EnteredStamp</li>
	 * 	<li>Get MailQueueStatusID</li>
	 * 	<li>Get BodyFileID</li>
	 * 	<li>handle any errors</li>
	 * 	<li>Close the database connection</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param sqlStatement the sql statement
	 * @return the mail queue info by SQL to array
	 * @throws Exception the exception
	 */
	// Get Mail Queue Information By SQL to an Array
	public  ArrayList<String> getMailQueueInfoBySQLToArray(RemoteWebDriver driver, String sqlStatement) throws Exception 
	{

		// Set the DB Connection String
		String dbUrl = perform.setDBConnectionString(driver, "Mercury");
		
		String getMailQueueSQL = sqlStatement;
		System.out.println("getMailQueueSQL = " + getMailQueueSQL);
		
		//Load the required JDBC Driver class
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
		
	 	Connection conn = null;
	 	
	    // Create an empty array
	    ArrayList<String> resultList = new ArrayList<String>();
	    
	 	try {
	 	    	conn = DriverManager.getConnection(dbUrl);

			 	Statement stmt = null;
			 	ResultSet rs = null;

			 	try
			 	{
			 	  	stmt = conn.createStatement();
			 	   
				    // Execute the sql query
				    rs = stmt.executeQuery(getMailQueueSQL);
				    
	         		// While Loop to iterate through all data and print results		
					while (rs.next()){

						// Get MailQueueID
						String mailQueueID = rs.getString(1);
	                    if (rs.wasNull())
	                    {
	                    	mailQueueID = "NULL";
	                    }
				        resultList.add(mailQueueID);
				        
				        // Get UserID
				        String userID= rs.getString(2);
	                    if (rs.wasNull())
	                    {
	                    	userID = "NULL";
	                    }
				        resultList.add(userID);
				        
				        // Get Type
				        String type = rs.getString(3);
	                    if (rs.wasNull())
	                    {
	                    	type = "NULL";
	                    }
				        resultList.add(type);
				        
				        // Get MailQueueTypeID
				        String mailQueueTypeID = rs.getString(4);
	                    if (rs.wasNull())
	                    {
	                    	mailQueueTypeID = "NULL";
	                    }
				        resultList.add(mailQueueTypeID);
				        
				        // Get MailFrom
				        String mailFrom = rs.getString(5);
	                    if (rs.wasNull())
	                    {
	                    	mailFrom = "NULL";
	                    }
				        resultList.add(mailFrom);
				        
				        // Get MailTo
				        String mailTo = rs.getString(6);
	                    if (rs.wasNull())
	                    {
	                    	mailTo = "NULL";
	                    }
				        resultList.add(mailTo);
				        
				        // Get MailReplyTo
				        String mailReplyTo = rs.getString(7);
	                    if (rs.wasNull())
	                    {
	                    	mailReplyTo = "NULL";
	                    }
				        resultList.add(mailReplyTo);
				        
				        // Get MailCC
				        String mailCC = rs.getString(8);
	                    if (rs.wasNull())
	                    {
	                    	mailCC = "NULL";
	                    }
				        resultList.add(mailCC);
				        
				        // Get Subject
				        String subject = rs.getString(9);
	                    if (rs.wasNull())
	                    {
	                    	subject = "NULL";
	                    }
				        resultList.add(subject);
				        
				        // Get TemplateUsed
				        String templateUsed = rs.getString(10);
	                    if (rs.wasNull())
	                    {
	                    	templateUsed = "NULL";
	                    }
				        resultList.add(templateUsed);
				        
				        // Get Attachments
				        String attachments = rs.getString(11);
	                    if (rs.wasNull())
	                    {
	                    	attachments = "NULL";
	                    }
				        resultList.add(attachments);
				        
				        // Get SentDateTime
				        String sentDateTime = rs.getString(12);
	                    if (rs.wasNull())
	                    {
	                    	sentDateTime = "NULL";
	                    }
				        resultList.add(sentDateTime);
				        
				        // Get Successful
				        String successful = rs.getString(13);
	                    if (rs.wasNull())
	                    {
	                    	successful = "NULL";
	                    }
				        resultList.add(successful);
				        
				        // Get FromEntityID
				        String fromEntityID = rs.getString(14);
	                    if (rs.wasNull())
	                    {
	                    	fromEntityID = "NULL";
	                    }
				        resultList.add(fromEntityID);
				        
				        // Get ToEntityID
				        String toEntityID = rs.getString(15);
	                    if (rs.wasNull())
	                    {
	                    	toEntityID = "NULL";
	                    }
				        resultList.add(toEntityID);
				        
				        // Get ProductItemID
				        String productItem = rs.getString(16);
	                    if (rs.wasNull())
	                    {
	                    	productItem = "NULL";
	                    }
				        resultList.add(productItem);
				        
				        // Get EnteredStamp
				        String enteredStamp = rs.getString(17);
	                    if (rs.wasNull())
	                    {
	                    	enteredStamp = "NULL";
	                    }
				        resultList.add(enteredStamp);
				        
				        // Get MailQueueStatusID
				        String mailQueueStatusID = rs.getString(18);
	                    if (rs.wasNull())
	                    {
	                    	mailQueueStatusID = "NULL";
	                    }
				        resultList.add(mailQueueStatusID);
				        
				        // Get BodyFileID
				        String bodyFileID = rs.getString(19);
	                    if (rs.wasNull())
	                    {
	                    	bodyFileID = "NULL";
	                    }
				        resultList.add(bodyFileID);
				        
				        System.out.println(mailQueueID+"\t"+userID+"\t"+type+"\t"+mailQueueTypeID+"\t"+mailFrom+"\t"+mailTo+"\t"+mailReplyTo+"\t"+mailCC+"\t"+subject+"\t"+templateUsed+"\t"+attachments+"\t"+sentDateTime+"\t"+successful+"\t"+fromEntityID+"\t"+toEntityID+"\t"+productItem+"\t"+enteredStamp+"\t"+mailQueueStatusID+"\t"+bodyFileID);
				        
					} // end while loop
					
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
		System.out.println("MailQueue Results = " + resultList);
		return resultList;
		
	} // end getMailQueueInfoByProductItemIDToArray
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the DB Connection String</li>
	 * 	<li>Load the required JDBC Driver class</li>
	 * 	<li>Create an empty array</li>
	 * 	<li>Execute the sql query</li>
	 * 	<li>While Loop to iterate through all data and print results</li>
	 * 	<li>Get mercuryBillingAccountID</li>
	 * 	<li>Get LoanID</li>
	 * 	<li>Get BillingCustNumber</li>
	 * 	<li>Get EntityID</li>
	 * 	<li>Get FirstName</li>
	 * 	<li>Get LastName</li>
	 * 	<li>Get EntityCustNumber</li>
	 * 	<li>Get Amount</li>
	 * 	<li>Get Description</li>
	 * 	<li>Get EnteredStamp</li>
	 * 	<li>handle any errors</li>
	 * 	<li>Close the database connection</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param loanNumber the loan number
	 * @return the billing queue to array
	 * @throws Exception the exception
	 */
	// Get Mail Queue Information By SQL to an Array
	public  ArrayList<String> getBillingQueueToArray(RemoteWebDriver driver, String loanNumber) throws Exception 
	{

		// Set the DB Connection String
		String dbUrl = perform.setDBConnectionString(driver, "Mercury");
		
		String getBillingQueueSQL = "SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED Select MBA.MercuryBillingAccountID "
				+ "    , MBQ.LoanID "
				+ "    , MBA.CustomerNumber AS 'BillingCustNumber' "
				+ "    , MBA.EntityID "
				+ "    , E.FirstName "
				+ "    , E.LastName "
				+ "    , E.ALMCustomerNumber AS 'EntityCustNumber' "
				+ "    , MBQ.Amount "
				+ "    , LMP.[Description] "
				+ "    , MBQ.EnteredStamp "
				+ "FROM Mercury.dbo.MercuryBillingQueue MBQ "
				+ "    JOIN Mercury.dbo.MercuryBillingAccount MBA "
				+ "        ON MBA.MercuryBillingAccountID = MBQ.MercuryBillingAccountID "
				+ "    JOIN Mercury.dbo.Entities E "
				+ "        ON E.EntityID = MBA.EntityID "
				+ "    JOIN Mercury.dbo.ListMercuryPaymentReason LMP "
				+ "        ON LMP.ListMercuryPaymentReasonID = MBQ.ListMercuryPaymentReasonID "
				+ "Where 1=1 "
				+ "    AND MBQ.LoanID = "+loanNumber+"";
		System.out.println("getBillingQueueSQL = " + getBillingQueueSQL);
		
		//Load the required JDBC Driver class
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
		
	 	Connection conn = null;
	 	
	    // Create an empty array
	    ArrayList<String> resultList = new ArrayList<String>();
	    
	 	try {
	 	    	conn = DriverManager.getConnection(dbUrl);

			 	Statement stmt = null;
			 	ResultSet rs = null;

			 	try
			 	{
			 	  	stmt = conn.createStatement();
			 	   
				    // Execute the sql query
				    rs = stmt.executeQuery(getBillingQueueSQL);
				    
	         		// While Loop to iterate through all data and print results		
					while (rs.next()){

						// Get mercuryBillingAccountID
						String mercuryBillingAccountID = rs.getString(1);
	                    if (rs.wasNull())
	                    {
	                    	mercuryBillingAccountID = "NULL";
	                    }
				        resultList.add(mercuryBillingAccountID);
				        
				        // Get LoanID
				        String loanID= rs.getString(2);
	                    if (rs.wasNull())
	                    {
	                    	loanID = "NULL";
	                    }
				        resultList.add(loanID);
				        
				        // Get BillingCustNumber
				        String billingCustNumber = rs.getString(3);
	                    if (rs.wasNull())
	                    {
	                    	billingCustNumber = "NULL";
	                    }
				        resultList.add(billingCustNumber);
				        
				        // Get EntityID
				        String entityID = rs.getString(4);
	                    if (rs.wasNull())
	                    {
	                    	entityID = "NULL";
	                    }
				        resultList.add(entityID);
				        
				        // Get FirstName
				        String firstName = rs.getString(5);
	                    if (rs.wasNull())
	                    {
	                    	firstName = "NULL";
	                    }
				        resultList.add(firstName);
				        
				        // Get LastName
				        String lastName = rs.getString(6);
	                    if (rs.wasNull())
	                    {
	                    	lastName = "NULL";
	                    }
				        resultList.add(lastName);
				        
				        // Get EntityCustNumber
				        String entityCustNumber = rs.getString(7);
	                    if (rs.wasNull())
	                    {
	                    	entityCustNumber = "NULL";
	                    }
				        resultList.add(entityCustNumber);
				        
				        // Get Amount
				        String amount = rs.getString(8);
	                    if (rs.wasNull())
	                    {
	                    	amount = "NULL";
	                    }
				        resultList.add(amount);
				        
				        // Get Description
				        String description = rs.getString(9);
	                    if (rs.wasNull())
	                    {
	                    	description = "NULL";
	                    }
				        resultList.add(description);
				        
				        // Get EnteredStamp
				        String enteredStamp = rs.getString(10);
	                    if (rs.wasNull())
	                    {
	                    	enteredStamp = "NULL";
	                    }
				        resultList.add(enteredStamp);
				        
				        System.out.println(mercuryBillingAccountID+"\t"+loanID+"\t"+billingCustNumber+"\t"+entityID+"\t"+firstName+"\t"+lastName+"\t"+entityCustNumber+"\t"+amount+"\t"+description+"\t"+enteredStamp);
				        
					} // end while loop
					
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
		System.out.println("BillingQueue Results = " + resultList);
		return resultList;
		
	} // end getMailQueueInfoByProductItemIDToArray
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the DB Connection String</li>
	 * 	<li>Load the required JDBC Driver class</li>
	 * 	<li>Create an empty array</li>
	 * 	<li>Execute the sql query</li>
	 * 	<li>While Loop to iterate through all data and print results</li>
	 * 	<li>Get taxInformationID</li>
	 * 	<li>Get name</li>
	 * 	<li>Get businessName</li>
	 * 	<li>Get taxClassificationID</li>
	 * 	<li>Get taxClassificationSupplemental</li>
	 * 	<li>Get address01</li>
	 * 	<li>Get address02</li>
	 * 	<li>Get requesterAddress</li>
	 * 	<li>Get accountNumbers</li>
	 * 	<li>Get socialSecurityNumber</li>
	 * 	<li>Get employerIdentificationNumber</li>
	 * 	<li>Get backupWithholdingExemption</li>
	 * 	<li>Get signature</li>
	 * 	<li>Get signatureDate</li>
	 * 	<li>Get exemptPayeeCode</li>
	 * 	<li>Get exemptionFromFATCA</li>
	 * 	<li>handle any errors</li>
	 * 	<li>Close the database connection</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param requestersName the requesters name
	 * @return the tax information by requester address to array
	 * @throws Exception the exception
	 */
	// Get TaxInformation by RequesterAddress to an Array
	public  ArrayList<String> getTaxInformationByRequesterAddressToArray(RemoteWebDriver driver, String requestersName) throws Exception 
	{

		// Set the DB Connection String
		String dbUrl = perform.setDBConnectionString(driver, "ACH");
		
		String getTaxInformationSQL = "SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED SELECT TOP 1 [TaxInformationID], [Name], [BusinessName], [TaxClassificationID], [TaxClassificationSupplemental], [Address01], [Address02], "
				+ "[RequesterAddress], [AccountNumbers], [SocialSecurityNumber], [EmployerIdentificationNumber], [BackupWithholdingExemption], [Signature], CONVERT(VARCHAR(10), "
				+ "[SignatureDate], 101) AS SignatureDate, [ExemptPayeeCode], [ExemptionFromFATCA] FROM [ACH].[dbo].[TaxInformation] WHERE RequesterAddress = '" + requestersName + "' ORDER BY SignatureDate DESC";
		System.out.println("getTaxInformationSQL = " + getTaxInformationSQL);
		
		//Load the required JDBC Driver class
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
		
	 	Connection conn = null;
	 	
	    // Create an empty array
	    ArrayList<String> resultList = new ArrayList<String>();
	    
	 	try {
	 	    	conn = DriverManager.getConnection(dbUrl);

			 	Statement stmt = null;
			 	ResultSet rs = null;

			 	try
			 	{
			 	  	stmt = conn.createStatement();
			 	   
				    // Execute the sql query
				    rs = stmt.executeQuery(getTaxInformationSQL);
				    
	         		// While Loop to iterate through all data and print results		
					while (rs.next()){

						// Get taxInformationID
						String taxInformationID = rs.getString(1);
	                    if (rs.wasNull())
	                    {
	                    	taxInformationID = "NULL";
	                    }
				        resultList.add(taxInformationID);
				        
				        // Get name
				        String name= rs.getString(2);
	                    if (rs.wasNull())
	                    {
	                    	name = "NULL";
	                    }
				        resultList.add(name);
				        
				        // Get businessName
				        String businessName = rs.getString(3);
	                    if (rs.wasNull())
	                    {
	                    	businessName = "NULL";
	                    }
				        resultList.add(businessName);
				        
				        // Get taxClassificationID
				        String taxClassificationID = rs.getString(4);
	                    if (rs.wasNull())
	                    {
	                    	taxClassificationID = "NULL";
	                    }
				        resultList.add(taxClassificationID);
				        
				        // Get taxClassificationSupplemental
				        String taxClassificationSupplemental = rs.getString(5);
	                    if (rs.wasNull())
	                    {
	                    	taxClassificationSupplemental = "NULL";
	                    }
				        resultList.add(taxClassificationSupplemental);
				        
				        // Get address01
				        String address01 = rs.getString(6);
	                    if (rs.wasNull())
	                    {
	                    	address01 = "NULL";
	                    }
				        resultList.add(address01);
				        
				        // Get address02
				        String address02 = rs.getString(7);
	                    if (rs.wasNull())
	                    {
	                    	address02 = "NULL";
	                    }
				        resultList.add(address02);
				        
				        // Get requesterAddress
				        String requesterAddress = rs.getString(8);
	                    if (rs.wasNull())
	                    {
	                    	requesterAddress = "NULL";
	                    }
				        resultList.add(requesterAddress);
				        
				        // Get accountNumbers
				        String accountNumbers = rs.getString(9);
	                    if (rs.wasNull())
	                    {
	                    	accountNumbers = "NULL";
	                    }
				        resultList.add(accountNumbers);
				        
				        // Get socialSecurityNumber
				        String socialSecurityNumber = rs.getString(10);
	                    if (rs.wasNull())
	                    {
	                    	socialSecurityNumber = "NULL";
	                    }
				        resultList.add(socialSecurityNumber);
				        
				        // Get employerIdentificationNumber
				        String employerIdentificationNumber = rs.getString(11);
	                    if (rs.wasNull())
	                    {
	                    	employerIdentificationNumber = "NULL";
	                    }
				        resultList.add(employerIdentificationNumber);
				        
				        // Get backupWithholdingExemption
				        String backupWithholdingExemption = rs.getString(12);
	                    if (rs.wasNull())
	                    {
	                    	backupWithholdingExemption = "NULL";
	                    }
				        resultList.add(backupWithholdingExemption);
				        
				        // Get signature
				        String signature = rs.getString(13);
	                    if (rs.wasNull())
	                    {
	                    	signature = "NULL";
	                    }
				        resultList.add(signature);
				        
				        // Get signatureDate
				        String signatureDate = rs.getString(14);
	                    if (rs.wasNull())
	                    {
	                    	signatureDate = "NULL";
	                    }
				        resultList.add(signatureDate);
				        
				        // Get exemptPayeeCode
				        String exemptPayeeCode = rs.getString(15);
	                    if (rs.wasNull())
	                    {
	                    	exemptPayeeCode = "NULL";
	                    }
				        resultList.add(exemptPayeeCode);
				        
				        // Get exemptionFromFATCA
				        String exemptionFromFATCA = rs.getString(16);
	                    if (rs.wasNull())
	                    {
	                    	exemptionFromFATCA = "NULL";
	                    }
				        resultList.add(exemptionFromFATCA);
				        
					} // end while loop
					
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
		System.out.println("TaxInformation Results = " + resultList);
		return resultList;
		
	} // end getTaxInformationByRequesterAddressToArray
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the DB Connection String</li>
	 * 	<li>Load the required JDBC Driver class</li>
	 * 	<li>Create an empty array</li>
	 * 	<li>Execute the sql query</li>
	 * 	<li>While Loop to iterate through all data and print results</li>
	 * 	<li>Get MailQueueID</li>
	 * 	<li>Get UserID</li>
	 * 	<li>Get Type</li>
	 * 	<li>Get MailQueueTypeID</li>
	 * 	<li>handle any errors</li>
	 * 	<li>Close the database connection</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param customerNumber the customer number
	 * @return the vendor payment customer settings to array
	 * @throws Exception the exception
	 */
	// Get VendorPaymentCustomerSettings to an Array
	public  ArrayList<String> getVendorPaymentCustomerSettingsToArray(RemoteWebDriver driver, String customerNumber) throws Exception 
	{

		// Set the DB Connection String
		String dbUrl = perform.setDBConnectionString(driver, "Mercury");
		
		String sqlStatement = "SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED SELECT Active, AutoPaySecondary, VendorPaymentDateDays, PaymentsMadeNotificationEmails FROM Mercury.dbo.VendorPaymentCustomerSettings "
				+ "WHERE CustomerNumber = '"+customerNumber+"'";
		
		System.out.println("sqlStatement = \n\n" + sqlStatement + "\n\n");
		
		//Load the required JDBC Driver class
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
		
	 	Connection conn = null;
	 	
	    // Create an empty array
	    ArrayList<String> resultList = new ArrayList<String>();
	    
	 	try {
	 	    	conn = DriverManager.getConnection(dbUrl);

			 	Statement stmt = null;
			 	ResultSet rs = null;

			 	try
			 	{
			 	  	stmt = conn.createStatement();
			 	   
				    // Execute the sql query
				    rs = stmt.executeQuery(sqlStatement);
				    
	         		// While Loop to iterate through all data and print results		
					while (rs.next()){

						// Get MailQueueID
						String active = rs.getString(1);
	                    if (rs.wasNull())
	                    {
	                    	active = "NULL";
	                    }
				        resultList.add(active);
				        
				        // Get UserID
				        String autopay= rs.getString(2);
	                    if (rs.wasNull())
	                    {
	                    	autopay = "NULL";
	                    }
				        resultList.add(autopay);
				        
				        // Get Type
				        String days = rs.getString(3);
	                    if (rs.wasNull())
	                    {
	                    	days = "NULL";
	                    }
				        resultList.add(days);
				        
				        // Get MailQueueTypeID
				        String notifications = rs.getString(4);
	                    if (rs.wasNull())
	                    {
	                    	notifications = "NULL";
	                    }
				        resultList.add(notifications);
				        
				        System.out.println(active+"\t"+autopay+"\t"+days+"\t"+notifications);
				        
					} // end while loop
					
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
		System.out.println("SQL Results = " + resultList);
		return resultList;
		
	} // end getVendorPaymentCustomerSettingsToArray
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the DB Connection String</li>
	 * 	<li>Load the required JDBC Driver class</li>
	 * 	<li>Create an empty array</li>
	 * 	<li>Execute the sql query</li>
	 * 	<li>While Loop to iterate through all data and print results</li>
	 * 	<li>Get MailQueueID</li>
	 * 	<li>Get UserID</li>
	 * 	<li>Get Type</li>
	 * 	<li>handle any errors</li>
	 * 	<li>Close the database connection</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param customerNumber the customer number
	 * @return the merchant account info to array
	 * @throws Exception the exception
	 */
	// Get Merchant Account info to an Array
	public  ArrayList<String> getMerchantAccountInfoToArray(RemoteWebDriver driver, String customerNumber) throws Exception 
	{

		// Set the DB Connection String
		String dbUrl = perform.setDBConnectionString(driver, "Merchants");
		
		String sqlStatement = "SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED SELECT MerchantNumber, AmexEnabled, DiscoverEnabled FROM Merchants.dbo.Accounts "
				+ "WHERE CustomerNumber = '"+customerNumber+"'";
		
		//Load the required JDBC Driver class
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
		
	 	Connection conn = null;
	 	
	    // Create an empty array
	    ArrayList<String> resultList = new ArrayList<String>();
	    
	 	try {
	 	    	conn = DriverManager.getConnection(dbUrl);

			 	Statement stmt = null;
			 	ResultSet rs = null;

			 	try
			 	{
			 	  	stmt = conn.createStatement();
			 	   
				    // Execute the sql query
				    rs = stmt.executeQuery(sqlStatement);
				    
	         		// While Loop to iterate through all data and print results		
					while (rs.next()){

						// Get MailQueueID
						String merchantNumber = rs.getString(1);
	                    if (rs.wasNull())
	                    {
	                    	merchantNumber = "NULL";
	                    }
				        resultList.add(merchantNumber);
				        
				        // Get UserID
				        String amex= rs.getString(2);
	                    if (rs.wasNull())
	                    {
	                    	amex = "NULL";
	                    }
				        resultList.add(amex);
				        
				        // Get Type
				        String discover = rs.getString(3);
	                    if (rs.wasNull())
	                    {
	                    	discover = "NULL";
	                    }
				        resultList.add(discover);
				        
				        
				        System.out.println(merchantNumber+"\t"+amex+"\t"+discover);
				        
					} // end while loop
					
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
		System.out.println("MailQueue Results = " + resultList);
		return resultList;
		
	} // end getMerchantAccountInfoToArray
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the DB Connection String</li>
	 * 	<li>Load the required JDBC Driver class</li>
	 * 	<li>Create an empty array</li>
	 * 	<li>Execute the sql query</li>
	 * 	<li>While Loop to iterate through all data and print results</li>
	 * 	<li>Get MakeAPaymentModeID</li>
	 * 	<li>Get AccountID</li>
	 * 	<li>Get Enabled</li>
	 *  <li>Get CyberSourceMerchantID</li>
	 *  <li>Get AccountTypeID</li>
	 * 	<li>handle any errors</li>
	 * 	<li>Close the database connection</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param customerNumber the customer number
	 * @return the merchant account info to array
	 * @throws Exception the exception
	 */
	public  ArrayList<String> getPaymentSettings(RemoteWebDriver driver, String customerNumber) throws Exception 
	{

		// Set the DB Connection String
		String dbUrl = perform.setDBConnectionString(driver, "Mercury");
		
		String sqlStatement = "SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED " +
								"SELECT cs.MakeAPaymentModeID, a.AccountID, a.Enabled, a.CyberSourceMerchantID, a.AccountTypeID " + 
								"FROM Mercury.dbo.CustomerSettings cs " + 
								"JOIN Merchants.dbo.Accounts a " + 
								"ON a.CustomerNumber = cs.CustomerNumber " + 
								"WHERE cs.CustomerNumber = " + customerNumber;
		
		//Load the required JDBC Driver class
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
		
	 	Connection conn = null;
	 	
	    // Create an empty array
	    ArrayList<String> resultList = new ArrayList<String>();
	    
	 	try {
	 	    	conn = DriverManager.getConnection(dbUrl);

			 	Statement stmt = null;
			 	ResultSet rs = null;

			 	try
			 	{
			 	  	stmt = conn.createStatement();
			 	   
				    // Execute the sql query
				    rs = stmt.executeQuery(sqlStatement);
				    
	         		// While Loop to iterate through all data and print results		
					while (rs.next()){

						// Get MakeAPaymentModeID
						String makeAPaymentModeID = rs.getString(1);
	                    if (rs.wasNull())
	                    {
	                    	makeAPaymentModeID = "NULL";
	                    }
				        resultList.add(makeAPaymentModeID);
				        
				        // Get AccountID
				        String accountID= rs.getString(2);
	                    if (rs.wasNull())
	                    {
	                    	accountID = "NULL";
	                    }
				        resultList.add(accountID);
				        
				        // Get Enabled
				        String enabled = rs.getString(3);
	                    if (rs.wasNull())
	                    {
	                    	enabled = "NULL";
	                    }
				        resultList.add(enabled);
				        
				        // Get CyberSourceMerchantID
				        String cyberSourceMerchantID = rs.getString(4);
	                    if (rs.wasNull())
	                    {
	                    	cyberSourceMerchantID = "NULL";
	                    }
				        resultList.add(cyberSourceMerchantID);
				        
				        // Get AccountTypeID
				        String accountTypeID = rs.getString(5);
	                    if (rs.wasNull())
	                    {
	                    	accountTypeID = "NULL";
	                    }
				        resultList.add(accountTypeID);
				        
					} // end while loop
					
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
		System.out.println("Payment Settings Results: " + resultList);
		return resultList;
		
	} // end getPaymentSettings
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the DB Connection String</li>
	 * 	<li>Load the required JDBC Driver class</li>
	 * 	<li>Create an empty array</li>
	 * 	<li>Execute the sql query</li>
	 * 	<li>While Loop to iterate through all data and print results</li>
	 * 	<li>Get Enabled</li>
	 * 	<li>Get UserDeferredCCEmail</li>
	 * 	<li>handle any errors</li>
	 * 	<li>Close the database connection</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param customerNumber the customer number
	 * @return the merchant account info to array
	 * @throws Exception the exception
	 */
	public  ArrayList<String> getSendPaymentLinkSettings(RemoteWebDriver driver, String customerNumber) throws Exception 
	{

		// Set the DB Connection String
		String dbUrl = perform.setDBConnectionString(driver, "Mercury");
		
		String sqlStatement = "SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED " +
								"SELECT Enabled, UseDeferredCCEmail " + 
								"FROM Mercury.dbo.SendPaymentLinkSettings " + 
								"WHERE CustomerNumber = " + customerNumber;
		
		//Load the required JDBC Driver class
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
		
	 	Connection conn = null;
	 	
	    // Create an empty array
	    ArrayList<String> resultList = new ArrayList<String>();
	    
	 	try {
	 	    	conn = DriverManager.getConnection(dbUrl);

			 	Statement stmt = null;
			 	ResultSet rs = null;

			 	try
			 	{
			 	  	stmt = conn.createStatement();
			 	   
				    // Execute the sql query
				    rs = stmt.executeQuery(sqlStatement);
				    
	         		// While Loop to iterate through all data and print results		
					while (rs.next()){

						// Get Enabled
						String enabled = rs.getString(1);
	                    if (rs.wasNull())
	                    {
	                    	enabled = "NULL";
	                    }
				        resultList.add(enabled);
				        
				        // Get UserDeferredCCEmail
				        String userDeferredCCEmail= rs.getString(2);
	                    if (rs.wasNull())
	                    {
	                    	userDeferredCCEmail = "NULL";
	                    }
				        resultList.add(userDeferredCCEmail);
				        
					} // end while loop
					
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
		System.out.println("Payment Settings Results: " + resultList);
		return resultList;
		
	} // end getSendPaymentLinkSettings
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the DB Connection String</li>
	 * 	<li>Load the required JDBC Driver class</li>
	 * 	<li>Create an empty array</li>
	 * 	<li>Execute the sql query</li>
	 * 	<li>While Loop to iterate through all data and print results</li>
	 * 	<li>Get EntitySettingTypeID</li>
	 * 	<li>Get Setting</li>
	 * 	<li>handle any errors</li>
	 * 	<li>Close the database connection</li>
	 * </ul>.
	 *
	 * @param driver the driver
	 * @param entityID the entity ID
	 * @param entitySettingTypeIDToGetInfoFrom the entity setting type ID to get info from
	 * @return the merchant account info to array
	 * @throws Exception the exception
	 */
	public  ArrayList<String> getEntitySettingsBitInfo(RemoteWebDriver driver, String entityID, String entitySettingTypeIDToGetInfoFrom) throws Exception 
	{

		// Set the DB Connection String
		String dbUrl = perform.setDBConnectionString(driver, "Mercury");
		
		String sqlStatement = "SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED " +
								"SELECT EntitySettingTypeID, Setting " + 
								"FROM Mercury.dbo.EntitySettingsBit " + 
								"WHERE EntitySettingTypeID = " + entitySettingTypeIDToGetInfoFrom + " " + 
								"AND EntityID = " + entityID;
		
		//Load the required JDBC Driver class
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
		
	 	Connection conn = null;
	 	
	    // Create an empty array
	    ArrayList<String> resultList = new ArrayList<String>();
	    
	 	try {
	 	    	conn = DriverManager.getConnection(dbUrl);

			 	Statement stmt = null;
			 	ResultSet rs = null;

			 	try
			 	{
			 	  	stmt = conn.createStatement();
			 	   
				    // Execute the sql query
				    rs = stmt.executeQuery(sqlStatement);
				    
	         		// While Loop to iterate through all data and print results		
					while (rs.next()){

						// Get EntitySettingTypeID
						String entitySettingTypeID = rs.getString(1);
	                    if (rs.wasNull())
	                    {
	                    	entitySettingTypeID = "NULL";
	                    }
				        resultList.add(entitySettingTypeID);
				        
				        // Get Setting
				        String setting= rs.getString(2);
	                    if (rs.wasNull())
	                    {
	                    	setting = "NULL";
	                    }
				        resultList.add(setting);
				        
					} // end while loop
					
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
		System.out.println("Payment Settings Results: " + resultList);
		return resultList;
		
	} // end getEntitySettingsBitInfo
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Query to run against the DB to get all of the automation unpaid invoices</li>
	 * 	<li>If there are unpaid invoices and tests are being ran on a QA environment, execute the StoredProcs</li>
	 * 	<li>Execute query against the database</li>
	 * 	<li>If there are unpaid invoices and tests are being ran on a non-QA environment, send email that contains the SQL to execute the StoredProcs</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param env the env
	 * @param phoneNumber the phone number
	 * @throws Exception the exception
	 */
	// Check for Unpaid Invoices and send an email if found
	public  void markSMSNumberAsBad(RemoteWebDriver driver, String env, String phoneNumber) throws Exception 
	{
		
		// Query to run against the DB to get all of the automation unpaid invoices
		String SMSBadNumber = "exec dbo.SMSBadNumber_InsertAutomation '"+phoneNumber+"'";
		
		// If there are unpaid invoices and tests are being ran on a QA environment, execute the StoredProcs
		if (env.contains("QA")) {
			// Execute query against the database
			queryDB(driver, "Mercury", SMSBadNumber);
			perform.sendEmail(driver, "dnorman@corelogic.com","","Updated SMS Number As Bad", SMSBadNumber);
			System.out.println("\n\nThe SMS number '"+SMSBadNumber+"' has been updated as bad\n\n");
		} // end if
		
		// If there are unpaid invoices and tests are being ran on a non-QA environment, send email that contains the SQL to execute the StoredProcs
		if (!env.contains("QA")) {
			perform.sendEmail(driver, "rupace@corelogic.com","dnorman@corelogic.com","Please Update SMS Number As Bad", "Can you please run the following on the Prod DB:\n\n" + SMSBadNumber);
			System.out.println("\n\nAn email has been sent to update the SMS number '"+SMSBadNumber+"' as bad\n\n");
		} // end if
		
	} // end markSMSNumberAsBad
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Update the database and set the user to monthly billing</li>
	 * 	<li>Send an email with the SQL needed to update the user to Monthly billing</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param customerNumber the customer number
	 * @throws Exception the exception
	 */
	// Set user to Monthly billing
	public  void setUserToMonthlyBilling(RemoteWebDriver driver, String customerNumber) throws Exception 
	{
		
		System.out.println("Set customer number " + customerNumber + " to Monthly billing");
		
		String env = StoredVariables.getusernameEnvironment().get();
		
		String setToMonthlyBillingSQL = ""
				+ "SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED DECLARE @customer varchar(10) "
				+ "SET @customer = "+customerNumber+" "

				+ "DECLARE @entity varchar(10) "
				+ "DECLARE @passport varchar(10) "
				+ "DECLARE @nextDate varchar(10) "

				+ "SET @entity = (SELECT EntityID FROM [Mercury].[dbo].[Entities] WHERE ALMCustomerNumber = @customer AND MercuryNetworkMember = 0 AND EntityTypeID NOT IN (32)) "
				+ "SET @passport = (SELECT PassportID FROM [CustomerData].[dbo].[PassportSecurity] WHERE PassProdFamilyID = 5 AND PassProductID = 13 AND ProductPrimaryID = @entity) "
				+ "SET @nextDate = DATEADD(d, 1, EOMONTH(current_timestamp)) "

				+ "IF (SELECT EntityID FROM [Mercury].[dbo].[MercuryBillingAccount] WHERE EntityID = @entity) IS NULL "
				+ "BEGIN "
				+ "    EXEC dbo.spMercuryNetworkUpdateMercuryBillingAccount NULL, @customer, @entity, @passport, 2, 2, @nextDate, 1, 'DLN', 2, 1 "
				+ "END "
				+ " "
				+ "ELSE IF (SELECT MercuryBillingTypeID FROM [Mercury].[dbo].[MercuryBillingAccount] WHERE EntityID = @entity) = 1 "
				+ "BEGIN "
				+ "    UPDATE [Mercury].[dbo].[MercuryBillingAccount] "
				+ "    SET MercuryBillingTypeID = 2 "
				+ "	, MercuryNotificationMethodID = 2 "
				+ "	, MercuryInvoicePresentationTypeID = 2 "
				+ "    WHERE CustomerNumber = @customer "
				+ "END "
				+ " "
				+ "ELSE "
				+ "BEGIN "
				+ "    PRINT 'Customer number ' + @customer + ' is already set to Monthly billing' "
				+ "END";

		if (env.equals("QA")) {
			// Update the database and set the user to monthly billing
			updateDB(driver, "Mercury", setToMonthlyBillingSQL);
		}
		else {
			// Send an email with the SQL needed to update the user to Monthly billing
			perform.sendEmail(driver, "rupace@corelogic.com","dnorman@corelogic.com","Set to Monhtly billing", setToMonthlyBillingSQL);
			System.out.println("\n\nThe SQL statement to set the customer to Monthly billing has been emailed\n\n");			
		} // end if/else
		
	} // end markSMSNumberAsBad
	
	/**
	 * Verify the VendorPaymentResponsibilityID in Mercury.dbo.MercuryOrderInformation
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the SQL statement using the ProductItemID</li>
	 * 	<li>Query the database for the VendorPaymentResponsibilityID in Mercury.dbo.MercuryOrderInformation</li>
	 * 	<li>Enter a while loop to check if the VendorPaymentResponsibilityID matches what is expected</li>
	 * 	<li>Verify the VendorPaymentResponsibilityID in Mercury.dbo.MercuryOrderInformation matches what is expected</li>
	 * </ul>
	 * @param driver the driver
	 * @param productItemID the ProductItemID
	 * @param expectedValue The expected value of the vendorPaymentResponsibilityID in Mercury.dbo.MercuryOrderInformation
	 * @return The vendorPaymentResponsibilityID in Mercury.dbo.MercuryOrderInformation
	 * @throws Exception the exception
	 */
	public String verifyVendorPaymentResponsibilityID(RemoteWebDriver driver, String productItemID, String expectedValue) throws Exception {
		String sqlStatement = "SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED SELECT VendorPaymentResponsibilityID FROM Mercury.dbo.MercuryOrderInformation WHERE ProductItemID = '"+productItemID+"'";
		String vendorPaymentResponsibilityID = db.queryDB(driver, "Mercury", sqlStatement);
		int i = 1;
		while (!vendorPaymentResponsibilityID.equals(expectedValue) && i <= 15) {
			Thread.sleep(2000);
			vendorPaymentResponsibilityID = db.queryDBNoLog(driver, "Mercury", sqlStatement);
			i++;
		} // end while
		perform.verification(driver, vendorPaymentResponsibilityID, "equals", expectedValue);
		return vendorPaymentResponsibilityID;
	} // end verifyVendorPaymentResponsibilityID
	
	/**
	 * Verify the Price in Mercury.dbo.ProductItems
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the SQL statement using the ProductItemID</li>
	 * 	<li>Query the database for the Price in Mercury.dbo.ProductItems</li>
	 * 	<li>Enter a while loop to check if the Price matches what is expected</li>
	 * 	<li>Verify the Price in Mercury.dbo.ProductItems matches what is expected</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param productItemID the ProductItemID
	 * @param expectedValue The expected value of the vendorPaymentResponsibilityID in Mercury.dbo.MercuryOrderInformation
	 * @return the price in Mercury.dbo.ProductItems
	 * @throws Exception the exception
	 */
	public String verifyPriceInProductItems(RemoteWebDriver driver, String productItemID, String expectedValue) throws Exception {
		String sqlStatement = "SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED SELECT Price FROM Mercury.dbo.ProductItems WHERE ProductItemID = '"+productItemID+"'";
		String price = db.queryDB(driver, "Mercury", sqlStatement);
		perform.verification(driver, price, "startsWith", expectedValue);
		return price;
	} // end verifyPriceInProductItems
	
	/**
	 * Verify the Price in Mercury.dbo.ProductItems
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the SQL statement using the ProductItemID</li>
	 * 	<li>Query the database for the Price in Mercury.dbo.ProductItems</li>
	 * 	<li>Enter a while loop to check if the Price matches what is expected</li>
	 * 	<li>Verify the Price in Mercury.dbo.ProductItems matches what is expected</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param productItemID the ProductItemID
	 * @param expectedValue The expected value of the vendorPaymentResponsibilityID in Mercury.dbo.MercuryOrderInformation
	 * @return the price in Mercury.dbo.ProductItems
	 * @throws Exception the exception
	 */
	public String verifyPaymentMethodInProductItems(RemoteWebDriver driver, String productItemID, String expectedValue) throws Exception {
		String sqlStatement = "SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED SELECT PaymentMethod FROM Mercury.dbo.ProductItems WHERE ProductItemID = '"+productItemID+"'";
		String paymentMethod = db.queryDB(driver, "Mercury", sqlStatement);
		perform.verification(driver, paymentMethod, "equals", expectedValue);
		return paymentMethod;
	} // end verifyPriceInProductItems
	
	/**
	 * Get the customer number from an email
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the SQL statement</li>
	 * 	<li>Query the database for the ALMCustomerNumber in Mercury.dbo.Entities</li>
	 * </ul>
	 * @param driver the driver
	 * @param email the email
	 * @return The customer in Mercury.dbo.Entities
	 * @throws Exception the exception
	 */
	public String getCustomerNumber(RemoteWebDriver driver, String email) throws Exception {
		String sqlStatement = "SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED " + 
				"SELECT DISTINCT ALMCustomerNumber FROM Entities " + 
				"WHERE Email = '"+email+"' " + 
				"AND ALMCustomerNumber IS NOT NULL";
		String customerNumber = db.queryDBNoLog(driver, "Mercury", sqlStatement);
		return customerNumber;
	} // end getCustomerNumber
	
	/**
	 * Save a snapshot of an order
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the SQL statement</li>
	 * 	<li>Execute the SP to save the snapshot of an order</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param loanID the loan ID
	 * @throws Exception the exception
	 */
	public void saveOrderSnapshot(RemoteWebDriver driver, String loanID) throws Exception {
		String sqlStatement = "DECLARE @Success BIT, @ArchiveOrderLogID INT " + 
				"EXEC MercuryArchive.dbo.Order_Archive @LoanID = "+loanID.replace("MERC-", "")+", @IsSnapshot = 1, @MinLastModifiedDays = 0, @Success = @Success OUTPUT, @ArchiveOrderLogID = @ArchiveOrderLogID OUTPUT " + 
				"SELECT Success = @Success, ArchiveOrderLogID = @ArchiveOrderLogID";
		db.queryDB(driver, "MercuryArchive", sqlStatement);
	} // end saveOrderSnapshot
	
	/**
	 * Restore a snapshot of an order
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the SQL statement</li>
	 * 	<li>Execute the SP to save the snapshot of an order</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param loanID the loan ID
	 * @throws Exception the exception
	 */
	public void restoreOrderSnapshot(RemoteWebDriver driver, String loanID) throws Exception {
		String sqlStatement = "DECLARE @Success BIT, @ArchiveOrderLogID INT " + 
				"EXEC MercuryArchive.dbo.Order_Unarchive @LoanID = "+loanID.replace("MERC-", "")+", @Success = @Success OUTPUT, @ArchiveOrderLogID = @ArchiveOrderLogID OUTPUT " + 
				"SELECT Success = @Success, ArchiveOrderLogID = @ArchiveOrderLogID";
		db.queryDB(driver, "MercuryArchive", sqlStatement);
	} // end restoreOrderSnapshot

	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the DB Connection String</li>
	 * 	<li>Load the required JDBC Driver class</li>
	 * 	<li>Execute the sql query</li>
	 * 	<li>Get number of columns</li>
	 * 	<li>While Loop to iterate through all data and print results</li>
	 * 	<li>Get MailQueueID</li>
	 * 	<li>Handle any errors</li>
	 * 	<li>Close the database connection</li>
	 * 	<li>Add info to Extent Report</li>
	 * </ul>.
	 *
	 * @param driver the driver
	 * @param loanID the loan ID
	 * @return the array list
	 * @throws Exception the exception
	 */
	// Query the database
	public  ArrayList<String> executeOrder_Archive_DependentOrders_Get(RemoteWebDriver driver, String loanID) throws Exception {
	
		// Set the DB Connection String
		String dbUrl = perform.setDBConnectionString(driver, "Mercury");
		
		//Load the required JDBC Driver class
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		// Set the SQL Statement
		String sqlStatement = "EXEC MercuryArchive.dbo.Order_Archive_DependentOrders_Get @LoanID = " + loanID;
		
	 	Connection conn = null;
	 	
	 	ArrayList<String> results = new ArrayList<String>();
	 	
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
							// Get MailQueueID
							String column = rs.getString(a);
		                    if (rs.wasNull())
		                    {
		                    	column = "NULL";
		                    }
		                    results.add(column);
						} // end for loop
					} // end while rs.next
					
					System.out.println("results = " + results);
				 	
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
		
		// Add info to Extent Report
		perform.addInfoToExtentReport(driver, "Database", "Executed the Order_Archive_DependentOrders_Get stored procedure.<br>"
				+ "SQL Statement: " + sqlStatement
				+ "<br><br>Result: " + results);
		
		return results;
		
	} // end queryDBArray
	
} // end Do class
