package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.ZonedDateTime;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Listeners;

import pageObjects.Secure.SOrderDetails;
import pageObjects.Secure.SOrders;
import setup.TestSetup;

// TODO: Auto-generated Javadoc
/**
 * <h1>Function CRM</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   09-05-2019
 */

@Listeners(utils.Listener.class)
public class Function_Performance extends TestSetup {

	/**
	 * Performance test.
	 *
	 * @param driver the driver
	 * @param timingArray the timing array
	 * @param url the url
	 * @param trackingNumber the tracking number
	 * @param subUser the sub user
	 * @param customerName the customer name
	 * @param customerNumber the customer number
	 * @return the array list
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	public ArrayList<String> performanceTest (RemoteWebDriver driver, ArrayList<String> timingArray, String url, String trackingNumber, String subUser, String customerName, String customerNumber) throws IOException, InterruptedException {
		
		// Initialize the start load time variable
		long start = 0;
		
		// Login through CRM
		System.out.println("Login through CRM");
		driver.get(url);
		timingArray.add(perform.getPageLoadTime(driver));
		
		// Go to Vendor Selection Settings
		perform.sleep(driver, 1);
		secure.goToVendorSelectionSettings(driver);
		timingArray.add(perform.getPageLoadTime(driver));
		
		// Go to Orders
		perform.sleep(driver, 1);
		secure.goToOrders(driver);
		timingArray.add(perform.getPageLoadTime(driver));
		
		// Get tracking number
		if (customerName.equals("Prime")) {
			trackingNumber = driver.findElement(By.cssSelector("#tblOrders > tbody > tr > td:nth-child(3)")).getText();
		} // end if
		
		// Click on the All Open Orders folder
		perform.sleep(driver, 1);
		start = getStartTime(driver);
		secure.findOrderFolder(driver, "All Open Orders");
		timingArray.add(Float.toString(calcTimeToLoad(driver, start)));
		
		// Click on the Completed folder
		perform.sleep(driver, 1);
		start = getStartTime(driver);
		secure.findOrderFolder(driver, "Completed");
		// Wait for busy
		perform.waitForBusyToBeHidden(driver);
		timingArray.add(Float.toString(calcTimeToLoad(driver, start)));
		
		// Go to Users
		perform.sleep(driver, 1);
		secure.goToUsers(driver);
		timingArray.add(perform.getPageLoadTime(driver));
		
		// Select sub user
		perform.sleep(driver, 1);
		secure.selectSubUser(driver, subUser);
		timingArray.add(perform.getPageLoadTime(driver));
		
		// Go to Fee Panel
		perform.sleep(driver, 1);
		secure.goToFeePanel(driver);
		timingArray.add(perform.getPageLoadTime(driver));
		
		// Go to Orders
		perform.sleep(driver, 1);
		secure.goToOrders(driver);
		timingArray.add(perform.getPageLoadTime(driver));
		
		// Click on the Action Required folder
		perform.sleep(driver, 1);
		start = getStartTime(driver);
		secure.findOrderFolder(driver, "Action Required");
		// Wait for busy
		perform.waitForBusyToBeHidden(driver);
		timingArray.add(Float.toString(calcTimeToLoad(driver, start)));
		
		// Click on the FHA Not Accepted folder
		perform.sleep(driver, 1);
		start = getStartTime(driver);
		secure.findOrderFolder(driver, "FHA Not Accepted");
		// Wait for busy
		perform.waitForBusyToBeHidden(driver);
		timingArray.add(Float.toString(calcTimeToLoad(driver, start)));
		
		// Click on the Action Required folder
		perform.sleep(driver, 1);
		start = getStartTime(driver);
		secure.findOrderFolder(driver, "Action Required");
		// Wait for busy
		perform.waitForBusyToBeHidden(driver);
		timingArray.add(Float.toString(calcTimeToLoad(driver, start)));
		
		// Click on the FHA Failed folder
		perform.sleep(driver, 1);
		start = getStartTime(driver);
		secure.findOrderFolder(driver, "FHA Failed");
		// Wait for busy
		perform.waitForBusyToBeHidden(driver);
		timingArray.add(Float.toString(calcTimeToLoad(driver, start)));
		
		// Click on the Action Required folder
		perform.sleep(driver, 1);
		start = getStartTime(driver);
		secure.findOrderFolder(driver, "Action Required");
		// Wait for busy
		perform.waitForBusyToBeHidden(driver);
		timingArray.add(Float.toString(calcTimeToLoad(driver, start)));
		
		// Click on the UCDP Not Accepted folder
		perform.sleep(driver, 1);
		start = getStartTime(driver);
		secure.findOrderFolder(driver, "UCDP Not Accepted");
		// Wait for busy
		perform.waitForBusyToBeHidden(driver);
		timingArray.add(Float.toString(calcTimeToLoad(driver, start)));
		
		// Click on the Action Required folder
		perform.sleep(driver, 1);
		start = getStartTime(driver);
		secure.findOrderFolder(driver, "Action Required");
		// Wait for busy
		perform.waitForBusyToBeHidden(driver);
		timingArray.add(Float.toString(calcTimeToLoad(driver, start)));
		
		// Click on the UCDP Failed folder
		perform.sleep(driver, 1);
		start = getStartTime(driver);
		secure.findOrderFolder(driver, "UCDP Failed");
		// Wait for busy
		perform.waitForBusyToBeHidden(driver);
		timingArray.add(Float.toString(calcTimeToLoad(driver, start)));
		
		// Click on the Action Required folder
		perform.sleep(driver, 1);
		start = getStartTime(driver);
		secure.findOrderFolder(driver, "Action Required");
		// Wait for busy
		perform.waitForBusyToBeHidden(driver);
		timingArray.add(Float.toString(calcTimeToLoad(driver, start)));
		
		// Search for an order
		if (customerName.toLowerCase().startsWith("service")) {
			timingArray.add("NULL");
			timingArray.add("NULL");
			timingArray.add("NULL");
		} else {
			perform.sleep(driver, 1);
			SOrders.find_txtbx(driver).clear();
			SOrders.find_txtbx(driver).sendKeys(trackingNumber);
			// Click the Contains radio button
			perform.click(driver, SOrders.contains_radioBtn(driver));
			Thread.sleep(1000);
			// Select Borrower in the In Field dropdown
			perform.selectDropdownOption(driver, SOrders.inField_dropdown(driver), "Tracking number");
			// Wait for dropdown
			perform.waitForElementToBeClickable(driver, SOrders.placed_dropdown(driver));
			// Select Placed as All
			perform.selectDropdownOption(driver, SOrders.placed_dropdown(driver), "All");
			// Click the Find magnifying glass
			perform.click(driver, SOrders.find_btn(driver));
			start = getStartTime(driver);
			// Wait for busy
			perform.waitForBusyToBeHidden(driver);
			WebElement firstOrder = driver.findElement(By.cssSelector("#tblOrders > tbody > tr > td"));
			// Wait for element to be clickable
			perform.waitForElementToBeClickable(driver, firstOrder);
			timingArray.add(Float.toString(calcTimeToLoad(driver, start)));
		
			// Open the order
			perform.sleep(driver, 1);
			System.out.println("Open the order: " + trackingNumber);
			perform.click(driver, firstOrder);
			perform.click(driver, SOrders.view_btn(driver));
			// Wait for busy
			perform.waitForBusyToBeHidden(driver);
			// Wait for element to be clickable
			perform.waitForElementToBeVisible(driver, SOrderDetails.history_txt(driver));
			timingArray.add(perform.getPageLoadTime(driver));
			
			// Back out of the order
			perform.sleep(driver, 1);
			perform.click(driver, SOrderDetails.backArrow_btn(driver));
			timingArray.add(perform.getPageLoadTime(driver));
		
		} // end if/else
		
		// Go to Clients
		perform.sleep(driver, 1);
		secure.goToClients(driver);
		timingArray.add(perform.getPageLoadTime(driver));
		
		// Go to VMP XSites settings
		perform.sleep(driver, 1);
		secure.goToVMPXSites(driver);
		timingArray.add(perform.getPageLoadTime(driver));
		
		// Go to Account
		secure.goToAccount(driver);
		perform.sleep(driver, 1);
		timingArray.add(perform.getPageLoadTime(driver));
		
//		// Go to Completed Orders report
//		perform.sleep(driver, 1);
//		secure.goToCompletedReports(driver);
//		timingArray.add(perform.getPageLoadTime(driver));
//		
//		// Go to In Progress report
//		perform.sleep(driver, 1);
//		driver.get(url);
//		secure.goToInProgressReports(driver);
//		timingArray.add(perform.getPageLoadTime(driver));
//		
//		// Go to Works In Progress report
//		perform.sleep(driver, 1);
//		driver.get(url);
//		secure.goToWorkInProgressReports(driver);
//		timingArray.add(perform.getPageLoadTime(driver));
		
		System.out.println("Timing array: " + timingArray);
		
		return timingArray;
		
	} // end performanceTest
	
	/**
	 * Write timing data to excel.
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the file</li>
	 * 	<li>Get the date</li>
	 * 	<li>Write data to Excel</li>
	 * 	<li>Create the File Input Stream</li>
	 * 	<li>Get the last column</li>
	 * 	<li>Set the date font to be white bold text on blue background</li>
	 * 	<li>Set the font for errors</li>
	 * 	<li>Write the date in on row 3</li>
	 * 	<li>Write the timing info into cells</li>
	 * 	<li>Write the timing data from the array to Excel</li>
	 * 	<li>Convert time to 3 decimal places</li>
	 * 	<li>Write time value to Excel</li>
	 * 	<li>Print in red text if it takes longer than x seconds to load</li>
	 * 	<li>Close the File Input Stream</li>
	 * 	<li>Create the File Output Stream</li>
	 * 	<li>Write the changes to the file</li>
	 * 	<li>Close the File Output Stream</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param filePath the file path
	 * @param fileName the file name
	 * @param sheetName the sheet name
	 * @param dataToWrite the data to write
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void writeTimingDataToExcel(RemoteWebDriver driver, String filePath, String fileName, String sheetName, ArrayList<String> dataToWrite) throws IOException {

		// Set the file
		String file = filePath + fileName;
		System.out.println("Write timing data in: " + file);
		
		// Get the date
		String todaysDate = perform.getTodaysDateFormatted(driver, "M/dd/yy");
		
		// Write data to Excel
		// Create the File Input Stream
		FileInputStream myxlsx = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(myxlsx);
		XSSFSheet worksheet = workbook.getSheet(sheetName);
		System.out.println("sheetName: " + sheetName);
		
		// Get the last column
		Row row = worksheet.getRow(2);
		int maxCell = row.getLastCellNum();
		System.out.println("maxCell: " + maxCell);
		
		// Set the date font to be white bold text on blue background
		XSSFCellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setColor(IndexedColors.WHITE.getIndex());
		style.setFillForegroundColor(IndexedColors.ROYAL_BLUE.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setFont(font);
		
		// Set the font for errors
		XSSFCellStyle styleRed = workbook.createCellStyle();
		XSSFFont fontError = workbook.createFont();
		fontError.setColor(IndexedColors.RED.getIndex());
		styleRed.setFont(fontError);
		
		// Set the font for errors
		XSSFCellStyle styleBlue = workbook.createCellStyle();
		XSSFFont fontWarning = workbook.createFont();
		fontWarning.setColor(IndexedColors.BLUE.getIndex());
		styleBlue.setFont(fontWarning);
		
		// Write the date in on row 3
		Cell cell = row.createCell(maxCell);
		cell.setCellValue(todaysDate);
		cell.setCellStyle(style);
		
		float time;
		// Write the timing info into cells
		int rowToWrite = 3;
		int dataIndex = 0;
		for (@SuppressWarnings("unused") String data : dataToWrite) {

			// Write the timing data from the array to Excel
			try {
				
				// Convert time to 3 decimal places
				time = Float.parseFloat(dataToWrite.get(dataIndex));
				DecimalFormat df = new DecimalFormat();
				df.setMaximumFractionDigits(3);
				time = Float.parseFloat(df.format(time));
				System.out.println("Print time to Excel: " + time);
				
				// Write time value to Excel
				row = worksheet.getRow(rowToWrite);
				cell = row.createCell(maxCell);
				cell.setCellValue(time);
				
				// Print in red text if it takes longer than x seconds to load
				if (time >= 5 && time < 10) {
					cell.setCellStyle(styleBlue);
				} // end if
				if (time >= 10) {
					cell.setCellStyle(styleRed);
				} // end if
				
			} catch (Exception e) {
				System.out.println("EXCEPTION:");
				e.printStackTrace();
			} // end try/catch
			
			rowToWrite++;
			dataIndex++;
			
		} // end for loop

		// Close the File Input Stream
		myxlsx.close();
		
		// Create the File Output Stream
		FileOutputStream output_file =new FileOutputStream(new File(file));
		
		// Write the changes to the file
		workbook.write(output_file);
		
		// Close the File Output Stream
		output_file.close();
			
	} // end writeTimingDataToExcel
	
	/**
	 * Write timing data to the database.
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get the date</li>
	 * 	<li>Write data to the database</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param customerName the customer name
	 * @param customerNumber the customer number
	 * @param dataToWrite the data to write
	 * @throws Exception 
	 */
	public void writeTimingDataToDatabase(RemoteWebDriver driver, String customerName, String customerNumber, ArrayList<String> dataToWrite) throws Exception {

		// Get the date
		String todaysDate = perform.getTodaysDateFormatted(driver, "MM/dd/yyyy HH:mm:ss");
		
		// Get the timing data
		String login = dataToWrite.get(0);
		String vss = dataToWrite.get(1);
		String orders1 = dataToWrite.get(2);
		String allOpenOrdersFolder = dataToWrite.get(3);
		String completedFolder = dataToWrite.get(4);
		String users = dataToWrite.get(5);
		String selectSubUser = dataToWrite.get(6);
		String feePanel = dataToWrite.get(7);
		String orders2 = dataToWrite.get(8);
		String actionReqFolder1 = dataToWrite.get(9);
		String fhaNotAcceptedFolder = dataToWrite.get(10);
		String actionReqFolder2 = dataToWrite.get(11);
		String fhaFailedFolder = dataToWrite.get(12);
		String actionReqFolder3 = dataToWrite.get(13);
		String ucdpNotAcceptedFolder = dataToWrite.get(14);
		String actionReqFolder4 = dataToWrite.get(15);
		String ucdpFailedFolder = dataToWrite.get(16);
		String actionReqFolder5 = dataToWrite.get(17);
		String searchForOrder = dataToWrite.get(18);
		String openOrder = dataToWrite.get(19);
		String backOutOfOrder = dataToWrite.get(20);
		String clients = dataToWrite.get(21);
		String vmpXSites = dataToWrite.get(22);
		String account = dataToWrite.get(23);
		
		// Set the update statement
		String sqlStatement = "INSERT INTO QAStats.dbo.MercuryBenchmarking (CustomerName, CustomerNumber, Environment, RunDate, Login, " + 
				"VendorSelectionSettings, Orders, AllOpenOrdersFolder, CompletedFolder, Users, SelectSubUser, FeePanel, Orders2, " + 
				"ActionRequiredFolder, FHANotAcceptedFolder, ActionRequiredFolder2, FHAFailedFolder, ActionRequiredFolder3, UCDPNotAcceptedFolder, " + 
				"ActionRequiredFolder4, UCDPFailedFolder, ActionRequiredFolder5, SearchForOrder, OpenOrder, BackOutOfOrder, Clients, VMPXSitesSettings, Account) "
				+ "VALUES ('"+customerName+"', '"+customerNumber+"', '"+StoredVariables.getusernameEnvironment().get()+"', "
				+ "'"+todaysDate+"', '"+login+"', '"+vss+"', '"+orders1+"', '"+allOpenOrdersFolder+"', '"+completedFolder+"', '"+users+"', '"+selectSubUser+"', "
				+ "'"+feePanel+"', '"+orders2+"', '"+actionReqFolder1+"', '"+fhaNotAcceptedFolder+"', '"+actionReqFolder2+"', '"+fhaFailedFolder+"', '"+actionReqFolder3+"', "
				+ "'"+ucdpNotAcceptedFolder+"', '"+actionReqFolder4+"', '"+ucdpFailedFolder+"', '"+actionReqFolder5+"', '"+searchForOrder+"', '"+openOrder+"', '"+backOutOfOrder+"', "
				+ "'"+clients+"', '"+vmpXSites+"', '"+account+"');";
		
		sqlStatement = sqlStatement.replace("'NULL'", "NULL");
		
		System.out.println("SQL STATEMENT: " + sqlStatement);
		
		// Write data to the database
		db.updateDB(driver, "QA", "Mercury", sqlStatement);
			
	} // end writeTimingDataToDatabase

	/**
	 * Write timing data to the database.
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get the date</li>
	 * 	<li>Write data to the database</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param customerName the customer name
	 * @param customerNumber the customer number
	 * @param dataToWrite the data to write
	 * @throws Exception 
	 */
	public void writeTimingDataToDatabaseForPrime(RemoteWebDriver driver, String customerName, String customerNumber, ArrayList<String> dataToWrite) throws Exception {

		// Get the date
		String todaysDate = perform.getTodaysDateFormatted(driver, "MM/dd/yyyy HH:mm:ss");
		
		// Get the timing data
		String login = dataToWrite.get(0);
		String vss = dataToWrite.get(1);
		String orders1 = dataToWrite.get(2);
		String allOpenOrdersFolder = dataToWrite.get(3);
		String completedFolder = dataToWrite.get(4);
		String users = dataToWrite.get(5);
		String selectSubUser = dataToWrite.get(6);
		String feePanel = dataToWrite.get(7);
		String orders2 = dataToWrite.get(8);
		String actionReqFolder1 = dataToWrite.get(9);
		String fhaNotAcceptedFolder = dataToWrite.get(10);
		String actionReqFolder2 = dataToWrite.get(11);
		String fhaFailedFolder = dataToWrite.get(12);
		String actionReqFolder3 = dataToWrite.get(13);
		String ucdpNotAcceptedFolder = dataToWrite.get(14);
		String actionReqFolder4 = dataToWrite.get(15);
		String ucdpFailedFolder = dataToWrite.get(16);
		String actionReqFolder5 = dataToWrite.get(17);
		String searchForOrder = dataToWrite.get(18);
		String openOrder = dataToWrite.get(19);
		String backOutOfOrder = dataToWrite.get(20);
		String clients = dataToWrite.get(21);
		String vmpXSites = dataToWrite.get(22);
		String account = dataToWrite.get(23);
		
		// Set the update statement
		String sqlStatement = "INSERT INTO QAStats.dbo.MercuryBenchmarkingPrime (CustomerName, CustomerNumber, Environment, RunDate, Login, " + 
				"VendorSelectionSettings, Orders, AllOpenOrdersFolder, CompletedFolder, Users, SelectSubUser, FeePanel, Orders2, " + 
				"ActionRequiredFolder, FHANotAcceptedFolder, ActionRequiredFolder2, FHAFailedFolder, ActionRequiredFolder3, UCDPNotAcceptedFolder, " + 
				"ActionRequiredFolder4, UCDPFailedFolder, ActionRequiredFolder5, SearchForOrder, OpenOrder, BackOutOfOrder, Clients, VMPXSitesSettings, Account) "
				+ "VALUES ('"+customerName+"', '"+customerNumber+"', '"+StoredVariables.getusernameEnvironment().get()+"', "
				+ "'"+todaysDate+"', '"+login+"', '"+vss+"', '"+orders1+"', '"+allOpenOrdersFolder+"', '"+completedFolder+"', '"+users+"', '"+selectSubUser+"', "
				+ "'"+feePanel+"', '"+orders2+"', '"+actionReqFolder1+"', '"+fhaNotAcceptedFolder+"', '"+actionReqFolder2+"', '"+fhaFailedFolder+"', '"+actionReqFolder3+"', "
				+ "'"+ucdpNotAcceptedFolder+"', '"+actionReqFolder4+"', '"+ucdpFailedFolder+"', '"+actionReqFolder5+"', '"+searchForOrder+"', '"+openOrder+"', '"+backOutOfOrder+"', "
				+ "'"+clients+"', '"+vmpXSites+"', '"+account+"');";
		
		System.out.println("SQL STATEMENT: " + sqlStatement);
		
		// Write data to the database
		db.updateDB(driver, "QA", "Mercury", sqlStatement);
			
	} // end writeTimingDataToDatabaseForPrime
	
	/**
	 * Calculate the time to load.
	 *
	 * @param driver the driver
	 * @param start the start
	 * @return the float
	 */
	public float calcTimeToLoad (RemoteWebDriver driver, long start) {

		// Get the current milliseconds
		long endLong = ZonedDateTime.now().toInstant().toEpochMilli();
		
		// Calculate the time to load
		float totalLoadTime = perform.convertMilliToSeconds(endLong - start);
		
		return totalLoadTime;
		
	} // end calcTimeToLoad
	
	/**
	 * Gets the start time.
	 *
	 * @param driver the driver
	 * @return the start time
	 */
	public long getStartTime (RemoteWebDriver driver) {
		
		// Get the current milliseconds
		long start = ZonedDateTime.now().toInstant().toEpochMilli();
		
		return start;
		
	} // end getStartTime
	
	/**
	 * Login to CRM.
	 *
	 * @param driver the driver
	 * @throws Exception the exception
	 */
	public void loadCRM (RemoteWebDriver driver) throws Exception {
		
		// Set credentials
		String ip = perform.decrypt("df1k8k4msv1ssg64c8d", "qOettnxOSeZM+pjK6pSmsmZBpHWUG/PQ");
		String directoryPath = null;
		directoryPath = StoredVariables.getos().get().toLowerCase().startsWith("win") ? "\\\\"+ip+"\\c$\\Connection\\" : System.getProperty("user.home")+"/DBConnection/";
		String encryptedUsername = perform.readTextFileToAString(directoryPath, "JU.txt");
		String encryptedPassword = perform.readTextFileToAString(directoryPath, "JPW.txt");
		String passwordForEncryption = perform.readTextFileToAString(directoryPath, "PWPW.txt");
		String user = perform.decrypt(passwordForEncryption, encryptedUsername);
		String pw = perform.decrypt(passwordForEncryption, encryptedPassword);

		// Load CRM for the first time
		driver.get("http://"+user+":"+pw+"@crm.ad.mercuryvmp.com/customer/customermgt/customerinfo.aspx?ID=5013334001");
		
	} // end loginToCRM
	
} // end Function_Secure class
