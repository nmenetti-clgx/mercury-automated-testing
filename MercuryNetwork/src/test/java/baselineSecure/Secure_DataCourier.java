package baselineSecure;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Secure.SDataCourier;
import pageObjects.Secure.SDataCourierOrderDetails;
import pageObjects.Secure.SDataCourierSubmitToUCDP;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Baseline Secure - Data Courier</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class Secure_DataCourier extends TestSetup {
	
	/** The user. */
	private static String user = "Baseline2";
	
	/** The loan number. */
	private static String loanNumber = null;
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Go to Data Courier</li>
	 * 	<li>Get number of existing files</li>
	 * 	<li>Click New File</li>
	 * 	<li>Click Upload XML</li>
	 * 	<li>Upload xml file</li>
	 * 	<li>Get number of files after the file upload</li>
	 * 	<li>Verify the file was uploaded successfully</li>
	 * 	<li>Go to Data Courier</li>
	 * 	<li>Click Uploaded folder</li>
	 * 	<li>Sort by uploaded desc</li>
	 * 	<li>Open the first record</li>
	 * 	<li>Click View Order</li>
	 * 	<li>Click Submit to UCDP button</li>
	 * 	<li>Switch to iFrame</li>
	 * 	<li>Select GSE</li>
	 * 	<li>Business unit</li>
	 * 	<li>Loan #</li>
	 * 	<li>Internal notes</li>
	 * 	<li>Click Send</li>
	 * 	<li>Verify Confirm change text</li>
	 * 	<li>Click Yes</li>
	 * 	<li>Verify alert text</li>
	 * 	<li>Click OK button</li>
	 * 	<li>Look up the order until the Documents button exists</li>
	 * 	<li>After 5 minutes, exit the loop</li>
	 * 	<li>Click the Back button</li>
	 * 	<li>Search for the document by loan number</li>
	 * 	<li>Open the first record</li>
	 * 	<li>Click View Order</li>
	 * 	<li>Look for Documents button</li>
	 * 	<li>Verify loan number was updated</li>
	 * 	<li>Verify history text</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - DataCourier", "Secure - Orders"}, alwaysRun=true)
	public void uploadAndSubmitXML() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		if (StoredVariables.getmobile().get()==false) {
		
			// Log in to Secure
			secure.login(driver, user, StoredVariables.getpassword().get());
			
			// Go to Data Courier
			secure.goToDataCourier(driver);
			
			// Get number of existing files
			String screenText = SDataCourier.numberOfFiles_txt(driver).getText();
		    Matcher numberOfFiles = Pattern.compile("\\(([^)]+)\\)").matcher(screenText);
		    String numOfFilesStringValue = null;
		    int files = 0;
		    while(numberOfFiles.find()) {
		    	numOfFilesStringValue = numberOfFiles.group(1);
		    	files = Integer.parseInt(numOfFilesStringValue);
		    }
		    
			// Click New File
			perform.click(driver, SDataCourier.newFile_btn(driver));
			
			// Click Upload XML
			perform.click(driver, SDataCourier.uploadXML_btn(driver));
			
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			// Upload xml file
			String filePath = StoredVariables.getdocDir().get()+"No UAD Hard Stops.xml";
			secure.uploadXMLFileInDataCourier(driver, filePath);
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			// Get number of files after the file upload
			screenText = SDataCourier.numberOfFiles_txt(driver).getText();
		    numberOfFiles = Pattern.compile("\\(([^)]+)\\)").matcher(screenText);
		    numOfFilesStringValue = null;
		    int filesAfter = 0;
		    while(numberOfFiles.find()) {
		    	numOfFilesStringValue = numberOfFiles.group(1);
		    	filesAfter = Integer.parseInt(numOfFilesStringValue);
		    }
			
			// Verify the file was uploaded successfully
		    Assert.assertTrue(filesAfter > files, "The file count is incorrect. The original count was = " + (files+1) + " but is now = " + filesAfter);
		    
			// Go to Data Courier
			secure.goToDataCourier(driver);
			
			// Click Uploaded folder
			perform.clickInTable_Equals(driver, "Uploaded");
			
			// Wait for busy to be hidden
			perform.waitForBusyToBeHidden(driver);
			
			// Sort by uploaded desc
			secure.sortByUploadedDesc(driver);
	
			// Open the first record
			perform.clickInTable_Contains(driver, "Test Name");
			
			// Click View Order
			perform.click(driver, SDataCourier.viewOrder_btn(driver));
			
			// Wait for the Back button
			perform.waitForElementToBeClickable(driver, SDataCourierOrderDetails.back_btn(), "cssSelector");
			
			// Click Submit to UCDP button
			perform.click(driver, SDataCourierOrderDetails.submitToUCDP_btn(driver));
			
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			Thread.sleep(2000);
			
			// Switch to iFrame
			perform.waitForiFrameSrcAndSwitchToIt(driver, "/Admin/OrderManagement/UCDPSubmit.aspx", By.id(SDataCourierSubmitToUCDP.selectGSE_dropdown()));
			
			// Select GSE
			perform.selectDropdownOption(driver, SDataCourierSubmitToUCDP.selectGSE_dropdown(driver), "Fannie Mae");
			
			// Business unit
			perform.selectDropdownOption(driver, SDataCourierSubmitToUCDP.businessUnit_dropdown(driver), "a la mode");
			
			// Loan #
			loanNumber = perform.randomNumbers(driver, 8);
			SDataCourierSubmitToUCDP.loanNumber_txtbx(driver).clear();
			perform.type(driver, SDataCourierSubmitToUCDP.loanNumber_txtbx(driver), loanNumber);
			
			// Internal notes
			perform.type(driver, SDataCourierSubmitToUCDP.internalNotes_txtbx(driver), "These are baseline test internal notes for Submit to UCDP");
			
			// Click Send
			perform.click(driver, SDataCourierSubmitToUCDP.send_btn(driver));
			
			// Wait for Yes button
			perform.waitForElementToBeClickable(driver, SDataCourierSubmitToUCDP.yes_btn(), "id");
			
			// Verify Confirm change text
			Assert.assertTrue(SDataCourierSubmitToUCDP.message_txt(driver).getText().contains("Changing the Loan # for UCDP submission will change the Loan # in your order. Do you wish to make this change?"), "Confirm change text is incorrect");
			
			// Click Yes
			perform.click(driver, SDataCourierSubmitToUCDP.yes_btn(driver));
			
			// Switch out of iFrame
			driver.switchTo().defaultContent();
			
			// Wait for OK alert button
			perform.waitForElementToBeClickable(driver, SDataCourierSubmitToUCDP.ok_btn(), "cssSelector");
			
			// Verify alert text
			Assert.assertTrue(SDataCourierSubmitToUCDP.alert_txt(driver).getText().contains("Your report has been successfully submitted to UCDP and the Doc File ID has been added to order details. You should receive the status of the appraisal shortly. If you haven't received a response with your Summary Submission Report in the next 24 hours, please contact Client Relations at 1-800-900-4954."), "UCDP Submission Complete alert text is incorrect");
			
			// Click OK button
			perform.click(driver, SDataCourierSubmitToUCDP.ok_btn(driver));
			
			// Look up the order until the Documents button exists
			// After 5 minutes, exit the loop
			long start_time = System.currentTimeMillis();
			long wait_time = 300000;
			long end_time = start_time + wait_time;
			List<WebElement> documents = driver.findElements(By.id(SDataCourierOrderDetails.documents_btn()));
			while (System.currentTimeMillis() < end_time && documents.isEmpty())
			{
				// Wait for the Back button
				perform.waitForElementToBeClickable(driver, SDataCourierOrderDetails.back_btn(), "cssSelector");
				
				// Click the Back button
				perform.click(driver, SDataCourierOrderDetails.back_btn(driver));
				
				// Wait for Find textbox
				perform.waitForElementToBeClickable(driver, SDataCourier.find_txtbx(), "id");
				
				// Search for the document by loan number
				secure.findDocument(driver, loanNumber, "Loan Number");
				
				// Open the first record
				perform.clickInTable_Contains(driver, "Test Name");
				
				// Click View Order
				perform.click(driver, SDataCourier.viewOrder_btn(driver));
				
				// Wait for the Back button
				perform.waitForElementToBeClickable(driver, SDataCourierOrderDetails.back_btn(), "cssSelector");
				
				// Look for Documents button
				documents = driver.findElements(By.id(SDataCourierOrderDetails.documents_btn()));
			}
			
			// Verify loan number was updated
			Assert.assertTrue(SDataCourierOrderDetails.loanNumber_txt(driver).getText().equals(loanNumber), "The loan number did not get updated. It should be = " + loanNumber + " , but it is = " + SDataCourierOrderDetails.loanNumber_txt(driver).getText());
			
			// Verify history text
			Assert.assertTrue(SDataCourierOrderDetails.history_txt(driver).getText().contains("UCDP Document File ID Updated by"), "The History table is missing information");
			Assert.assertTrue(SDataCourierOrderDetails.history_txt(driver).getText().contains("Note Added by"), "The History table is missing information");
			Assert.assertTrue(SDataCourierOrderDetails.history_txt(driver).getText().contains("These are baseline test internal notes for Submit to UCDP"), "The History table is missing information");
			Assert.assertTrue(SDataCourierOrderDetails.history_txt(driver).getText().contains("Appraisal Submitted to FNM via UCDP by"), "The History table is missing information");
		    
			// Log test
			test.log(LogStatus.INFO, "data courier", "Uploaded and submitted XML file successfully");
			
		} else {
			
			// Log test
			test.log(LogStatus.INFO, "data courier", "Did not run because files cannot be uploaded from mobile");
			
		} // end if/else
		
	} // end uploadAndSubmitXML
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Go to Data Courier</li>
	 * 	<li>Get number of existing files</li>
	 * 	<li>Click New File</li>
	 * 	<li>Click Upload PDF</li>
	 * 	<li>Upload xml file</li>
	 * 	<li>Set Data Courier File Information</li>
	 * 	<li>Enter Create Data Courier File information</li>
	 * 	<li>Get number of files after the file upload</li>
	 * 	<li>Verify the file was uploaded successfully</li>
	 * 	<li>Find document</li>
	 * 	<li>Open the first record</li>
	 * 	<li>Click View Order</li>
	 * 	<li>Verify loan number was updated</li>
	 * 	<li>Verify PDF button is displayed</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - DataCourier", "Secure - Orders"}, alwaysRun=true)
	public void uploadPDF() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		if (StoredVariables.getmobile().get()==false) {
		
			// Log in to Secure
			secure.login(driver, user, StoredVariables.getpassword().get());
			
			// Go to Data Courier
			secure.goToDataCourier(driver);
			
			// Get number of existing files
			String screenText = SDataCourier.numberOfFiles_txt(driver).getText();
		    Matcher numberOfFiles = Pattern.compile("\\(([^)]+)\\)").matcher(screenText);
		    String numOfFilesStringValue = null;
		    int files = 0;
		    while(numberOfFiles.find()) {
		    	numOfFilesStringValue = numberOfFiles.group(1);
		    	files = Integer.parseInt(numOfFilesStringValue);
		    }
			
			// Click New File
			perform.click(driver, SDataCourier.newFile_btn(driver));
			
			// Click Upload PDF
			perform.click(driver, SDataCourier.uploadPDF_btn(driver));
			
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			// Upload xml file
			String filePath = StoredVariables.getdocDir().get()+"Test PDF.pdf";
			secure.uploadXMLFileInDataCourier(driver, filePath);
			
			// Set Data Courier File Information
			String address = "501-D NE 122nd St";
			String city = "Oklahoma City";
			String state = "Oklahoma";
			String zip = "73114";
			String neighborhood = "Test Neighborhood";
			String salePrice = "180000";
			String product = "Uniform Residential Appraisal (FNMA 1004)";
			String loanType = "FHA";
			String appraisedValue = "188000";
			int appraisalDate = -3;
			String assignmentType = "Purchase";
			int priorDate = -7;
			String priorPrice = "178000";
			String borrowerName = "Automation Baseline" + perform.randomNumbers(driver, 8);
			String appraiserName = "Automation Appraiser1";
			String lenderName = "US Bank";
			String lenderAddress = "123 Test St";
			String lenderCity = "Yukon";
			String lenderState = "Oklahoma";
			String lenderZip = "73099";
			
			// Enter Create Data Courier File information
			secure.enterCreateDataCourierFile(driver, address, city, state, zip, neighborhood, salePrice, product, loanType, appraisedValue, appraisalDate, 
					assignmentType, priorDate, priorPrice, borrowerName, appraiserName, lenderName, lenderAddress, lenderCity, lenderState, lenderZip);
			
			// Get number of files after the file upload
			screenText = SDataCourier.numberOfFiles_txt(driver).getText();
		    numberOfFiles = Pattern.compile("\\(([^)]+)\\)").matcher(screenText);
		    numOfFilesStringValue = null;
		    int filesAfter = 0;
		    while(numberOfFiles.find()) {
		    	numOfFilesStringValue = numberOfFiles.group(1);
		    	filesAfter = Integer.parseInt(numOfFilesStringValue);
		    }
			
			// Verify the file was uploaded successfully
		    Assert.assertTrue(filesAfter > files, "The file count is incorrect. It should be " + (files+1) + " but is = " + filesAfter);
			
			// Find document
			secure.findDocument(driver, borrowerName, "Borrower");
			
			// Open the first record
			perform.clickInTable_Contains(driver, borrowerName);
			
			// Click View Order
			perform.click(driver, SDataCourier.viewOrder_btn(driver));
			
			// Wait for Back button
			perform.waitForElementToBeClickable(driver, SDataCourierOrderDetails.back_btn(), "cssSelector");
			
			// Verify loan number was updated
			Assert.assertTrue(SDataCourierOrderDetails.history_txt(driver).getText().contains("Appraisal Uploaded by"), "The history table is missing information");
			
			// Verify PDF button is displayed
			Assert.assertTrue(SDataCourierOrderDetails.pdf_btn(driver).isDisplayed(), "The PDF button is not displayed");
			
			// Log test
			test.log(LogStatus.INFO, "data courier", "Uploaded PDF file successfully");
			
		} else {
			
			// Log test
			test.log(LogStatus.INFO, "data courier", "Did not run because files cannot be uploaded from mobile");
			
		} // end if/else
		
	} // end uploadPDF
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Go to Data Courier</li>
	 * 	<li>Set element</li>
	 * 	<li>Get the element id</li>
	 * 	<li>Get column width for the borrower column before</li>
	 * 	<li>Expand column width for the borrower column</li>
	 * 	<li>Get the new column width for the borrower column</li>
	 * 	<li>Verify the column width got changed</li>
	 * 	<li>Click Restore Column Widths button</li>
	 * 	<li>Refresh the element</li>
	 * 	<li>Get the new column width for the borrower column</li>
	 * 	<li>Verify column width returns to original width</li>
	 * 	<li>Log test</li>
* </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Secure - DataCourier"}, alwaysRun=true)
	public void restoreColumnWidths() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Log in to Secure
		secure.login(driver, user, StoredVariables.getpassword().get());
		
		// Go to Data Courier
		secure.goToDataCourier(driver);
		
		Thread.sleep(2000);
		
		// Set element
		WebElement e = driver.findElement(By.cssSelector("th[idx='2']"));
		
		// Get the element id
		String id = e.getAttribute("id");
		
		// Get column width for the borrower column before
		String styleBefore = e.getAttribute("style");
		
		// Expand column width for the borrower column
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('" + id + "').setAttribute('style', 'width: 200px;')");
		
		// Get the new column width for the borrower column
		String styleAfter = e.getAttribute("style");
		
		// Verify the column width got changed
		Assert.assertTrue(!styleBefore.equals(styleAfter), "The column width did not change");
		
		// Click Restore Column Widths button
		perform.click(driver, SDataCourier.restoreColumnWidths_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Refresh the element
		e = driver.findElement(By.cssSelector("th[idx='2']"));
		
		// Get the new column width for the borrower column
		String styleAfterRestore = e.getAttribute("style");
		
		// Verify column width returns to original width
		Assert.assertTrue(styleBefore.equals(styleAfterRestore), "The column did not return to the original width");
	    
		// Log test
		test.log(LogStatus.INFO, "data courier", "Tested the Restore Column Widths button");
		
	} // end restoreColumnWidths
	
} // end the Secure_DataCourier class
