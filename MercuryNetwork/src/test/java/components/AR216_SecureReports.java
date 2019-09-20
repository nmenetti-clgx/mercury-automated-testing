package components;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Secure.SFeePanel;
import pageObjects.Secure.SOrders;
import pageObjects.Secure.SReports;
import setup.DriverFactory;
import setup.TestSetup;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Baseline Vendors - Login</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   08-02-2019
 */

@Test(singleThreaded=true, retryAnalyzer = Retry.class)
@Listeners(utils.Listener.class)
public class AR216_SecureReports extends TestSetup {
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to Secure</li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 * 	<li>Log test</li>
	 * </ul>
	 * @throws Exception 
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Login", "AR223"}, alwaysRun=true)
	public void ar216_1_CompletedReports() throws Exception {

		// Create the driver for the test
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Delete files if they already exist
		deleteExistingFiles(driver);

		// Login to secure.mercuryvmp.com
		secure.login(driver, "RegressionSecure1", StoredVariables.getpassword().get());
		
		// Go to the Completed folder
		secure.findOrderFolder(driver, "Completed");
		
		// Take screenshot
		perform.takeScreenshot(driver);
		
		// Get the count
		String title = SOrders.ordersTitle_txt(driver).getText();
		String count = title.substring(title.indexOf("(")+1,title.indexOf(")"));
		int folderCount = Integer.parseInt(count);
		
		// Click Reports> Completed
		secure.goToCompletedReports(driver);
		
		// Get number of items in the report
		int numOfReports = getNumberOfReports(driver);
		
		// Verify a report with X amount of Completed orders is generated (X being the number of orders in your completed folder)
		perform.verification(driver, numOfReports, "==", folderCount);
		
		// Verify download of Excel 2007 Workbook
		perform.sleep(driver, 2);
		verifyDownloadFile(driver, SReports.excel2007_btn(driver), "OrderStatus.xlsx", folderCount);
		
		// Verify download of Excel 2003 Workbook
		perform.sleep(driver, 2);
		verifyDownloadFile(driver, SReports.excelXP_btn(driver), "OrderStatus.xls", folderCount);
		
		// Verify download of Comma Delimited
		perform.sleep(driver, 2);
		verifyDownloadFile(driver, SReports.commaDelimited_btn(driver), "OrderStatus.csv", folderCount);
		
		// Log test
		perform.addInfoToExtentReport(driver, "reports", "Verified the Completed Reports");
		
	} // end ar216_1_CompletedReports
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to Secure</li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 * 	<li>Log test</li>
	 * </ul>
	 * @throws Exception 
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Login", "AR223", "broken"}, alwaysRun=true)
	public void ar216_2_InProgressReports() throws Exception {

		// Create the driver for the test
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Delete files if they already exist
		deleteExistingFiles(driver);

		// Login to secure.mercuryvmp.com
		secure.login(driver, "RegressionSecure1", StoredVariables.getpassword().get());
		
		// Get the count of In Progress items
		int folderCount = 0;
		
		// Click Reports> In Progress
		secure.goToInProgressReports(driver);
		
		// Get number of items in the report
		int numOfReports = getNumberOfReports(driver);
		
		// Verify a report with X amount of Completed orders is generated (X being the number of orders in your completed folder)
		perform.verification(driver, numOfReports, "==", folderCount);
		
		// Verify download of Excel 2007 Workbook
		perform.sleep(driver, 2);
		verifyDownloadFile(driver, SReports.excel2007_btn(driver), "OrderStatus.xlsx", folderCount);
		
		// Verify download of Excel 2003 Workbook
		perform.sleep(driver, 2);
		verifyDownloadFile(driver, SReports.excelXP_btn(driver), "OrderStatus.xls", folderCount);
		
		// Verify download of Comma Delimited
		perform.sleep(driver, 2);
		verifyDownloadFile(driver, SReports.commaDelimited_btn(driver), "OrderStatus.csv", folderCount);
		
		// Log test
		perform.addInfoToExtentReport(driver, "reports", "Verified the In Progress Reports");
		
	} // end ar216_2_InProgressReports
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to Secure</li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 * 	<li>Log test</li>
	 * </ul>
	 * @throws Exception 
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Login", "AR223"}, alwaysRun=true)
	public void ar216_3_NewRequestReports() throws Exception {

		// Create the driver for the test
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Delete files if they already exist
		deleteExistingFiles(driver);

		// Login to secure.mercuryvmp.com
		secure.login(driver, "Baseline1", StoredVariables.getpassword().get());
		
		// Go to the Awaiting Acceptance folder
		secure.findOrderFolder(driver, "Awaiting Acceptance");
		
		// Take screenshot
		perform.takeScreenshot(driver);
		
		// Get the count
		String title = SOrders.ordersTitle_txt(driver).getText();
		String count = title.substring(title.indexOf("(")+1,title.indexOf(")"));
		int folderCount = Integer.parseInt(count);
		
		// Click Reports> New Requests
		secure.goToNewRequestsReports(driver);
		
		// Get number of items in the report
		int numOfReports = getNumberOfReports(driver);

		// Verify a report with X amount of New Request orders is generated (X being the number of orders in your Awaiting Acceptance folder)
		perform.verification(driver, numOfReports, "==", folderCount);
		
		// Verify download of Excel 2007 Workbook
		perform.sleep(driver, 2);
		verifyDownloadFile(driver, SReports.excel2007_btn(driver), "OrderStatus.xlsx", folderCount);
		
		// Verify download of Excel 2003 Workbook
		perform.sleep(driver, 2);
		verifyDownloadFile(driver, SReports.excelXP_btn(driver), "OrderStatus.xls", folderCount);
		
		// Verify download of Comma Delimited
		perform.sleep(driver, 2);
		verifyDownloadFile(driver, SReports.commaDelimited_btn(driver), "OrderStatus.csv", folderCount);
		
		// Log test
		perform.addInfoToExtentReport(driver, "reports", "Verified the New Request Reports");
		
	} // end ar216_3_NewRequestReports
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to Secure</li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 * 	<li>Log test</li>
	 * </ul>
	 * @throws Exception 
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Login", "AR223"}, alwaysRun=true)
	public void ar216_4_FeePanelReports() throws Exception {

		// Create the driver for the test
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Delete files if they already exist
		deleteExistingFiles(driver);

		// Login to secure.mercuryvmp.com
		secure.login(driver, "Notifications1", StoredVariables.getpassword().get());
		
		// Go to the Fee Panel
		secure.goToFeePanel(driver);
		
		// Count the number of appraisers
		int numOfAppraisers = driver.findElements(By.cssSelector("#tblGridStateData > tbody > tr")).size();
		
		// Click AMC/Firm fee panel
		perform.click(driver, SFeePanel.amcFirmFeePanel_tab(driver));
		
		// Wait for grid to load
		perform.waitForText(driver, SFeePanel.feePanelTable_txt(driver), "Automation");
		
		// Count the number of AMC's
		int numOfAMC = driver.findElements(By.cssSelector("#tblGridStateData > tbody > tr")).size();		
		
		// Add number of members on the fee panel
		int total = numOfAppraisers + numOfAMC;
		
		// Click Reports> Fee Panel
		secure.goToFeePanelReports(driver);
		
		// Get number of items in the report
		int totalReports = driver.findElements(By.cssSelector("#tblReport > tbody > tr:nth-child(4) > td > table > tbody")).size();		

		// Verify a report with X amount of Fee Panel members is generated (X being the number of members in the Fee Panel)
		perform.verification(driver, totalReports, "==", total);

		// Verify download of Excel 2007 Workbook
		perform.sleep(driver, 2);
		verifyDownloadFile(driver, SReports.excel2007_btn(driver), "FeePanel.xlsx", total);
		
		// Verify download of Excel 2003 Workbook
		perform.sleep(driver, 2);
		verifyDownloadFile(driver, SReports.excelXP_btn(driver), "FeePanel.xls", total);
		
		// Verify download of Comma Delimited
		perform.sleep(driver, 2);
		verifyDownloadFile(driver, SReports.commaDelimited_btn(driver), "FeePanel.csv", total);
		
		// Log test
		perform.addInfoToExtentReport(driver, "reports", "Verified the Fee Panel Reports");
		
	} // end ar216_4_FeePanelReports
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to Secure</li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 *  <li></li>
	 * 	<li>Log test</li>
	 * </ul>
	 * @throws Exception 
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - Login", "AR223", "broken"}, alwaysRun=true)
	public void ar216_5_WorkInProgressReports() throws Exception {

		// Create the driver for the test
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Delete files if they already exist
		deleteExistingFiles(driver);

		// Login to secure.mercuryvmp.com
		secure.login(driver, "RegressionSecure1", StoredVariables.getpassword().get());
		
		// Get the count of Work In Progress items
		int folderCount = 0;
		
		// Click Reports> Work In Progress
		secure.goToWorkInProgressReports(driver);
		
		// Get number of items in the report
		int numOfReports = getNumberOfReports(driver);
		
		// Verify a report with X amount of Completed orders is generated (X being the number of orders in your completed folder)
		perform.verification(driver, numOfReports, "==", folderCount);
		
		// Verify download of Excel 2007 Workbook
		perform.sleep(driver, 2);
		verifyDownloadFile(driver, SReports.excel2007_btn(driver), "OrderStatus.xlsx", folderCount);
		
		// Verify download of Excel 2003 Workbook
		perform.sleep(driver, 2);
		verifyDownloadFile(driver, SReports.excelXP_btn(driver), "OrderStatus.xls", folderCount);
		
		// Verify download of Comma Delimited
		perform.sleep(driver, 2);
		verifyDownloadFile(driver, SReports.commaDelimited_btn(driver), "OrderStatus.csv", folderCount);
		
		// Log test
		perform.addInfoToExtentReport(driver, "reports", "Verified the Work In Progress Reports");
		
	} // end ar216_5_WorkInProgressReports
	
	/**
	 * Verify download file.
	 *
	 * @param driver the driver
	 * @param downloadLink the download link
	 * @param file the file
	 * @return the int
	 * @throws InterruptedException the interrupted exception
	 * @throws EncryptedDocumentException the encrypted document exception
	 * @throws InvalidFormatException the invalid format exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private int verifyDownloadFile(RemoteWebDriver driver, WebElement downloadLink, String file, int folderCount) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
		
		// Click Export
		perform.click(driver, SReports.export_btn(driver));
		
		// Click download link
		perform.click(driver, downloadLink);
		
		// Wait for busy
		perform.waitForBusyToBeHidden(driver);
		
		// Wait for the file to be downloaded
		perform.waitForFileToExist(driver, file);
		
		// Click Export
		perform.click(driver, SReports.export_btn(driver));
		
		// Count the number of rows in the file
		// Set the slash based on the OS
		String slash = "\\";
		if (StoredVariables.getos().get().equals("Mac")) {
			slash = "/";
		} // end if
		
		// If the file does not contain a slash, get the file from the Downloads folder by default
		if (!file.contains(slash)) {
			// Get the file from the Downloads folder
			file = StoredVariables.getdownloadsDir().get()+slash+file;
		} // end if

		// Initialize the row count variable
		int rowcount = 0;
		
		// Read the Excel file and verify the number of rows
		if (file.toString().endsWith(".xlsx")) {
			
			Workbook wb = WorkbookFactory.create(new FileInputStream(file));
			Sheet s = wb.getSheetAt(0);
			
			// Get the number of rows
			int headers = file.toString().startsWith("FeePanel") ? 4 : 3;
			rowcount = s.getLastRowNum() - headers;
			
			// Close the workbook
			wb.close();
			
			// Verify the row count of the downloaded file matches the folder count
			perform.verification(driver, rowcount, "==", folderCount);
			
		} // end if/else
		
		// Return the row count
		return rowcount;
		
	} // end verifyDownloadFile
	
	/**
	 * Delete existing files.
	 *
	 * @param driver the driver
	 */
	private void deleteExistingFiles (RemoteWebDriver driver) {
		
		// Delete files if they already exist
		perform.deleteFile(driver, "OrderStatus.xlsx");
		perform.deleteFile(driver, "OrderStatus.xls");
		perform.deleteFile(driver, "OrderStatus.csv");
		perform.deleteFile(driver, "FeePanel.xlsx");
		perform.deleteFile(driver, "FeePanel.xls");
		perform.deleteFile(driver, "FeePanel.csv");
		
	} // end deleteExistingFiles
	
	/**
	 * Gets the number of reports.
	 *
	 * @param driver the driver
	 * @return the number of reports
	 * @throws InterruptedException the interrupted exception
	 */
	private int getNumberOfReports (RemoteWebDriver driver) throws InterruptedException {
		
		// Get number of items in the report
		int numOfReports = driver.findElements(By.cssSelector("#Main_Main_upRecords > table > tbody")).size();
		boolean morePages = perform.checkIfElementExists(driver, By.cssSelector(".Pager"));
		if (morePages==true) {
			
			// Get all of the options in the dropdown
			List<String> page = perform.getAllDropdownOptions(driver, SReports.pages_dropdown(driver));
			
			for (int d = 1; d < page.size(); d++) {
				
				// Select the dropdown option
				perform.selectDropdownOption(driver, SReports.pages_dropdown(driver), page.get(d));
				
				// Wait for busy
				perform.waitForBusyToBeHidden(driver);
				
				// Add the number of records
				numOfReports = numOfReports + driver.findElements(By.cssSelector("#Main_Main_upRecords > table > tbody")).size();
				System.out.println("numOfReports: " + numOfReports);
				
			} // end for
			
		} // end if
		
		return numOfReports;
		
	} // end getNumberOfReports

} // end the AR216_SecureReports class
