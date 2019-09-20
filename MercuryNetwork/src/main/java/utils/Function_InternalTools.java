package utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EmptyFileException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import pageObjects.InternalTools.ITNotificationSearch;
import pageObjects.InternalTools.ITPaymentsConsole;
import pageObjects.Secure.SSureReceipts;
import setup.TestSetup;

// TODO: Auto-generated Javadoc
/**
 * <h1>Function Internal Tools</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-15-2019
 */

@Listeners(utils.Listener.class)
public class Function_InternalTools extends TestSetup {
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to Internal Tools</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws InterruptedException the interrupted exception
	 */
	// Go to Internal Tools
	public void goToInternalTools(RemoteWebDriver driver) throws InterruptedException {

		// Go to Internal Tools
		driver.get(StoredVariables.getinternalToolsSite().get());
		
		// Wait for link text
		perform.waitForElementToBeClickable(driver, driver.findElement(By.linkText("Mercury Network Tools")));
		
	} // end goToInternalTools
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to Internal Tools &gt; Payments Console</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws InterruptedException the interrupted exception
	 */
	// Go to Internal Tools
	public void goToPaymentsConsole(RemoteWebDriver driver) throws InterruptedException {

		// Go to Internal Tools > Payments Console
		driver.get(StoredVariables.getinternalToolsSite().get()+"PaymentsConsole/customerInfo");
		
		// Wait for Customer Number textbox
		perform.waitForElementToBeClickable(driver, ITPaymentsConsole.customerNumber_txtbx(driver));
		
	} // end goToPaymentsConsole
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to Internal Tools &gt; Notification Search</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @throws InterruptedException the interrupted exception
	 */
	public void goToNotificationSearch(RemoteWebDriver driver) throws InterruptedException {
		
		// Go to the Notification Search Internal Tool
		driver.get(StoredVariables.getinternalToolsSite().get()+"NotificationSearch/");

		// Wait for Search button
		perform.waitForElementToBeClickable(driver, ITNotificationSearch.search_btn(driver));
		
	} // end goToNotificationSearch
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Enter Customer number</li>
	 * 	<li>Click Select</li>
	 * 	<li>If description is still empty, refresh the page and try again</li>
	 * 	<li>Refresh the page</li>
	 * 	<li>Enter Customer number</li>
	 * 	<li>Click Select</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param phone the phone
	 * @throws InterruptedException the interrupted exception
	 */
	// Search for payment customer
	public void searchForPaymentCustomerInPaymentsConsole(RemoteWebDriver driver, String phone) throws InterruptedException {

		// Enter Customer number
		String customerNumber;
		if (phone.length()>4) {
			customerNumber = phone;
		} else {
			customerNumber = "501"+StoredVariables.getuserPhonePrefix().get()+phone;
		} // end if/else
		perform.type(driver, ITPaymentsConsole.customerNumber_txtbx(driver), customerNumber);
		
		// Click Select
		perform.click(driver, ITPaymentsConsole.select_btn(driver));
		
		// Wait for Notification recipients to not be empty
		String description = ITPaymentsConsole.transactionDescription_txtbx(driver).getAttribute("value");
		int a = 1;
		while (description.isEmpty() && a <= 30) {
			description = ITPaymentsConsole.transactionDescription_txtbx(driver).getAttribute("value");
			Thread.sleep(1000);
			a++;
		} // end while
		
		// If description is still empty, refresh the page and try again
		description = ITPaymentsConsole.transactionDescription_txtbx(driver).getAttribute("value");
		if (description.isEmpty()) {
			
			// Refresh the page 
			driver.navigate().refresh();
			
			// Wait for the customer number textbox
			perform.waitForElementToBeClickable(driver, ITPaymentsConsole.customerNumber_txtbx(driver));
			
			// Enter Customer number
			perform.type(driver, ITPaymentsConsole.customerNumber_txtbx(driver), customerNumber);
			
			// Click Select
			perform.click(driver, ITPaymentsConsole.select_btn(driver));
			
			// Wait for Notification recipients to not be empty
			description = ITPaymentsConsole.transactionDescription_txtbx(driver).getAttribute("value");
			a = 1;
			while (description.isEmpty() && a <= 30) {
				description = ITPaymentsConsole.transactionDescription_txtbx(driver).getAttribute("value");
				Thread.sleep(1000);
				a++;
			} // end while
			
		} // end if
		
	} // end searchForPaymentCustomerInPaymentsConsole
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click Mercury Network Tools</li>
	 * 	<li>Click Add Client to ULSAccounts</li>
	 * 	<li>Enter customer number</li>
	 * 	<li>Click Search</li>
	 * 	<li>Check Set up as AMC</li>
	 * 	<li>Click Save</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param custNo the cust no
	 * @param username the username
	 * @throws InterruptedException the interrupted exception
	 */
	// Link VMP XSite
	public void linkVMPXSite(RemoteWebDriver driver, String custNo, String username) throws InterruptedException {

		// Click Mercury Network Tools
		perform.click(driver, driver.findElement(By.linkText("Mercury Network Tools")));
		
		// Wait for Add Client to ULSAccounts link
		perform.waitForElementToBeClickable(driver, driver.findElement(By.linkText("Manage VMP XSite")));
		
		// Click Add Client to ULSAccounts
		perform.click(driver, driver.findElement(By.linkText("Manage VMP XSite")));
		
		// Wait for CustomerNumber textbox
		perform.waitForElementToBeClickable(driver, driver.findElement(By.id("Main_Main_nCustomerNumber")));
		
		// Enter customer number
		perform.type(driver, driver.findElement(By.id("Main_Main_nCustomerNumber")), custNo);
		
		// Click Search
		perform.click(driver, driver.findElement(By.id("Main_Main_btnSearch")));
		
		// Wait for dropdown
		perform.waitForElementToBeClickable(driver, driver.findElement(By.id("Main_Main_ddXSite")));
		String text = "";
		while(!text.contains(username))
		{
			Thread.sleep(2000);
			WebElement dropdown = driver.findElement(By.id("Main_Main_ddXSite"));
			text = dropdown.getText();
		} // end while
		
		// Check Set up as AMC
		perform.checkCheckbox(driver, driver.findElement(By.id("Main_Main_bIsAMC")));
		
		// Click Save
		perform.click(driver, driver.findElement(By.id("Main_Main_btnAdd")));
		
		// Wait for verification text
		perform.waitForElementToBeClickable(driver, driver.findElement(By.id("Main_Main_strFeedback")));
		
	} // end linkVMPXSite
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Click Payments Console</li>
	 * 	<li>Enter Customer number</li>
	 * 	<li>Click Select</li>
	 * 	<li>Check the Payments active checkbox</li>
	 * 	<li>Enter data into Company name, Transaction description, and Transaction detail fields</li>
	 * 	<li>Check the Auto pay variance checkbox</li>
	 * 	<li>Set Payment trigger to First deliver</li>
	 * 	<li>Set Payment days to 0</li>
	 * 	<li>Add at least one email in Notification recipients</li>
	 * 	<li>Save</li>
	 * 	<li>Verify alert text</li>
	 * 	<li>Query Mercury.dbo.VendorPaymentSettings using CustomerNumber and verify values are correct based on data entered in Step 4</li>
	 * 	<li>Verify the values are correct</li>
	 * </ul>
	 *
	 * @param driver the driver
	 * @param custNo the cust no
	 * @param paymentsActive the payments active
	 * @param companyName the company name
	 * @param transactionDescription the transaction description
	 * @param transactionDetail the transaction detail
	 * @param autoPayVariance the auto pay variance
	 * @param paymentTrigger the payment trigger
	 * @param paymentDays the payment days
	 * @param notificationRecipients the notification recipients
	 * @throws Exception the exception
	 */
	// Set the information in the Payments Console
	public void setPaymentConsoleInfo(RemoteWebDriver driver, String custNo, boolean paymentsActive, String companyName, String transactionDescription, String transactionDetail,
			boolean autoPayVariance, String paymentTrigger, String paymentDays, String notificationRecipients) throws Exception {

		// Click Payments Console
		perform.click(driver, driver.findElement(By.linkText("Payments Console")));
		
		// Wait for Customer Number textbox
		perform.waitForElementToBeClickable(driver, ITPaymentsConsole.customerNumber_txtbx(driver));
		
		// Enter Customer number
		perform.type(driver, ITPaymentsConsole.customerNumber_txtbx(driver), custNo);
		
		// Click Select
		perform.click(driver, ITPaymentsConsole.select_btn(driver));
		
		// Wait for text
		String errorTextElement = "#divTabContainer > app-customer-composition > div.PodSection.psBorder > div > app-customer-search > div > div.DataColumn_left > div:nth-child(2) > div";
		perform.waitForElementToBeClickable(driver, driver.findElement(By.cssSelector(errorTextElement)));
		perform.waitForText(driver, driver.findElement(By.cssSelector(errorTextElement)), "Please complete this form to enable this account");
		
		// Check the Payments active checkbox
		if (paymentsActive == true) {
			perform.checkCheckbox(driver, ITPaymentsConsole.paymentsActive_chkbx(driver));
		}
		
		// Enter data into â€œCompany nameâ€�, â€œTransaction descriptionâ€�, and â€œTransaction detailâ€� fields
		if (!companyName.isEmpty()) {
			perform.type(driver, ITPaymentsConsole.companyName_txtbx(driver), companyName);
		}
		
		if (!transactionDescription.isEmpty()) {
			perform.type(driver, ITPaymentsConsole.transactionDescription_txtbx(driver), transactionDescription);
		}
		
		if (!transactionDetail.isEmpty()) {
			perform.type(driver, ITPaymentsConsole.transactionDetail_txtbx(driver), transactionDetail);
		}
		
		// Check the â€œAuto pay varianceâ€� checkbox
		if (autoPayVariance == true) {
			perform.checkCheckbox(driver, ITPaymentsConsole.autoPayVariance_chkbx(driver));
		}
		
		// Set â€œPayment triggerâ€� to â€œFirst deliverâ€�
		if (!paymentTrigger.isEmpty()) {
			perform.selectDropdownOption(driver, ITPaymentsConsole.paymentTrigger_dropdown(driver), "First delivery");
		}
		
		// Set â€œPayment daysâ€� to â€œ0â€�
		if (!paymentDays.isEmpty()) {
			perform.selectDropdownOption(driver, ITPaymentsConsole.paymentDays_dropdown(driver), "0");
		}
		
		// Add at least one email in â€œNotification recipientsâ€�
		if (!notificationRecipients.isEmpty()) {
			perform.type(driver, ITPaymentsConsole.notificationRecipients_txtbx(driver), "automation@dntest.net");
		}
		
		// Save
		perform.click(driver, ITPaymentsConsole.save_btn(driver));
		
		// Verify alert text
		perform.waitForElementToBeClickable(driver, ITPaymentsConsole.alert_txt(driver));
		perform.waitForText(driver, ITPaymentsConsole.alert_txt(driver), "Successfully processed Customer number");
		String text = ITPaymentsConsole.alert_txt(driver).getText();
		Assert.assertTrue(text.contains("Successfully processed Customer number " + custNo), "The alert text should show the customer was processed successfully. On screen text = " + text);
		
		Thread.sleep(30000);
		
		// Query Mercury.dbo.VendorPaymentSettings using CustomerNumber and verify values are correct based on data entered in Step 4
		ArrayList<String> results = null;
		results = db.getVendorPaymentCustomerSettingsToArray(driver, custNo);
		String active = results.get(0);
		String autopay = results.get(1);
		String days = results.get(2);
		String notifications = results.get(3);
		
		// Verify the values are correct
		Assert.assertTrue(active.equals("1"), "Active is not set properly in the DB. It should be set to 1, but is set to " + active);
		Assert.assertTrue(autopay.equals("1"), "Autopay is not set properly in the DB. It should be set to 1, but is set to " + autopay);
		Assert.assertTrue(days.equals("0"), "Days is not set properly in the DB. It should be set to 0, but is set to " + days);
		Assert.assertTrue(notifications.equals("automation@dntest.net"), "Notifications is not set properly in the DB. It should be set to automation@dntest.net, but is set to " + notifications);

	} // end setupPayment
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Enter the product item id</li>
	 *  <li>Click Search</li>
	 *  <li>Wait for the grid to update the results by waiting for the text Email</li>
	 * </ul>.
	 *
	 * @param driver the driver
	 * @param productItemID the product item ID
	 * @throws InterruptedException the interrupted exception
	 */
	public void searchNotificationsByProductItemID(RemoteWebDriver driver, String productItemID) throws InterruptedException {
		
		boolean resultsDisplayed = false;
		int i = 1;
		while (resultsDisplayed==false && i <=10) {
			
			// Enter the product item id
			perform.type(driver, ITNotificationSearch.productItemID_txtbx(driver), productItemID);
			
			// Click Search
			perform.click(driver, ITNotificationSearch.search_btn(driver));
			
			// Wait for the grid to update
			perform.waitForText(driver, ITNotificationSearch.searchResults_txt(driver), "EMail");
			
			// Break out of the while loop if the results are displayed
			if (ITNotificationSearch.searchResults_txt(driver).getText().contains("EMail")) {
				resultsDisplayed = true;
				break;
			} // end if
			
			// Refresh the screen if the results are not displayed
			driver.navigate().refresh();
			
			i++;
			
		} // end while
		
	} // end searchNotificationsByProductItemID
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Enter the product item id</li>
	 *  <li>Click Search</li>
	 *  <li>Wait for the grid to update the results by waiting for the text Email</li>
	 * </ul>.
	 *
	 * @param driver the driver
	 * @param email the email
	 * @throws InterruptedException the interrupted exception
	 */
	public void searchNotificationsByToAddress(RemoteWebDriver driver, String email) throws InterruptedException {
		
		boolean resultsDisplayed = false;
		int i = 1;
		while (resultsDisplayed==false && i <=10) {
			
			// Enter the product item id
			perform.type(driver, ITNotificationSearch.toAddress_txtbx(driver), email);
			
			// Click Search
			perform.click(driver, ITNotificationSearch.search_btn(driver));
			
			// Wait for the grid to update
			perform.waitForText(driver, ITNotificationSearch.searchResults_txt(driver), "EMail");
			
			// Break out of the while loop if the results are displayed
			if (ITNotificationSearch.searchResults_txt(driver).getText().contains("EMail")) {
				resultsDisplayed = true;
				break;
			} // end if
			
			// Refresh the screen if the results are not displayed
			driver.navigate().refresh();
			
			i++;
			
		} // end while
		
	} // end searchNotificationsByToAddress
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Go to Internal Tools &gt; Notification Search</li>
	 * 	<li>Enter the product item id</li>
	 *  <li>Click Search</li>
	 *  <li>Wait for the grid to update the results by waiting for the text Email</li>
	 * </ul>.
	 *
	 * @param driver the driver
	 * @param productItemID the product item ID
	 * @throws InterruptedException the interrupted exception
	 */
	public void goToNotificationSearchAndSearchByProductItemID(RemoteWebDriver driver, String productItemID) throws InterruptedException {
		
		// Go to Notification Search
		goToNotificationSearch(driver);
		
		// Search by Product Item ID
		searchNotificationsByProductItemID(driver, productItemID);
		
	} // end goToNotificationSearchAndSearchByProductItemID
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get the row number of the notification that contains text</li>
	 *  <li>Click the Body link to open the email</li>
	 *  <li>Switch to the new window</li>
	 * </ul>.
	 *
	 * @param driver the driver
	 * @param textInRow the text in row
	 * @param newPageTitle the new page title
	 * @throws InterruptedException the interrupted exception
	 */
	public void clickBodyLinkOfRowThatContainsTextInNotificationSearchAndSwitchToIt(RemoteWebDriver driver, String textInRow, String newPageTitle) throws InterruptedException {

		// Get the row number of the notification that contains text
		int row = perform.getRowNumberThatContainsText(driver, By.cssSelector(ITNotificationSearch.rowSearchResults_txt()), textInRow, 1);
		
		// Click the Body link to open the email
		perform.click(driver, ITNotificationSearch.body_link(driver, row));
		
		// Switch to the new window
		perform.switchToWindowByTitle(driver, newPageTitle);
		
	} // end clickBodyLinkOfRowThatContainsTextInNotificationSearchAndSwitchToIt
	
	/**
	* <p>
	* STEPS:
	* <ul>
	* 	<li>Click the Download documents button</li>
	*  <li>Switch to the new window</li>
	* </ul>.
	*
	* @param driver the driver
	 * @throws InterruptedException 
	*/
	public void clickDownloadDocumentsAndSwitchToTheNewWindow(RemoteWebDriver driver) throws InterruptedException {
		
		// Click the Download documents link
		perform.click(driver, SSureReceipts.downloadDocuments_link(driver));
		
		// Switch to the new window
		perform.switchToWindowByTitle(driver, "Mercury Network");

	} // end clickDownloadDocumentsAndSwitchToTheNewWindow
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Switch into the iFrame</li>
	 *  <li>Select the I understand radio button</li>
	 *  <li>Click Continue</li>
	 *  <li>Click DOwnload Auth Code</li>
	 * </ul>.
	 *
	 * @param driver the driver
	 * @throws InterruptedException the interrupted exception
	 */
	public void acknowledgeElectricDeliveryAndDownloadAuthCode(RemoteWebDriver driver) throws InterruptedException {

		// Switch into the iFrame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "RoCO.aspx?Type", By.id(SSureReceipts.iUnderstand_radiobtn()));
		
		// Select the I understand radio button
		perform.click(driver, SSureReceipts.iUnderstand_radiobtn(driver));
		
		// Click Continue
		perform.click(driver, SSureReceipts.continue_btn(driver));
		
		// Click Download Auth Code
		perform.click(driver, SSureReceipts.downloadAuthCode_btn(driver));
		
	} // end acknowledgeElectricDeliveryAndDownloadAuthCode
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Open a new tab to load the PDF in</li>
	 *  <li>Open the PDF and get the Auth Code from the PDF</li>
	 *  <li>Close the window with the PDF</li>
	 * </ul>.
	 *
	 * @param driver the driver
	 * @param authCodeFileName the auth code file name
	 * @return the auth code from PDF
	 * @throws InterruptedException the interrupted exception
	 * @throws EmptyFileException the empty file exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public String getAuthCodeFromPDF(RemoteWebDriver driver, String authCodeFileName) throws InterruptedException, EmptyFileException, IOException {

		// Open a new tab to load the PDF in
		perform.openNewTabAndSwitchToIt(driver);
		
		// Open the PDF and get the Auth Code from the PDF
		String authCodePDFText = perform.readPDFInURL(driver, authCodeFileName);
		String authCodeExtracted = authCodePDFText.replace("Authorization Code", "")
				.replace("As an authentication measure, you must enter the", "")
				.replace("following code to gain access to the report.", "");
		String authCode = authCodeExtracted.trim();
		
		// Print out the Auth Code to the console
		System.out.println("Auth Code: " + authCode);
		
		// Close the window with the PDF
		driver.close();
		
		return authCode;

	} // end getAuthCodeFromPDF
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Switch into the iFrame</li>
	 *  <li>Enter the Auth code in the Auth Code: field</li>
	 *  <li>Click Download report</li>
	 * </ul>.
	 *
	 * @param driver the driver
	 * @param authCode the auth code
	 * @throws InterruptedException the interrupted exception
	 */
	public void enterAuthCodeAndDownloadReport(RemoteWebDriver driver, String authCode) throws InterruptedException {

		// Switch into the iFrame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "RoCO.aspx?Type", By.id(SSureReceipts.iUnderstand_radiobtn()));
		
		// Enter the Auth code in the Auth Code: field
		perform.type(driver, SSureReceipts.authCode_txtbx(driver), authCode);
		
		// Click Download report
		perform.click(driver, SSureReceipts.downloadReport_btn(driver));

	} // end enterAuthCodeAndDownloadReport
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Refresh the notification list</li>
	 *  <li>Wait for the grid to update</li>
	 *  <li>Get the search results</li>
	 *  <li>Wait for notification to be displayed by entering a while loop</li>
	 *  <li>Refresh the notification list</li>
	 *  <li>Get the text</li>
	 *  <li>Verify the notification exists</li>
	 * </ul>.
	 *
	 * @param driver the driver
	 * @param textToVerify the text to verify
	 * @throws InterruptedException the interrupted exception
	 */
	public void refreshNotificationListAndVerifyTextExists(RemoteWebDriver driver, String textToVerify) throws InterruptedException {

		// Refresh the notification list
		perform.click(driver, ITNotificationSearch.refresh_btn(driver));
		
		// Wait for the grid to update
		perform.waitForText(driver, ITNotificationSearch.searchResults_txt(driver), "EMail");
		
		// Get the search results
		String results = ITNotificationSearch.searchResults_txt(driver).getText();
		System.out.println("Results: " + results);
		
		// Wait for notification to be displayed
		int a = 1;
		while (a<=60 && !results.contains(textToVerify)) {
			
			perform.sleep(driver, 3);
			
			// Refresh the notification list
			perform.click(driver, ITNotificationSearch.refresh_btn(driver));
			
			// Get the text
			try {
				perform.waitForText(driver, ITNotificationSearch.searchResults_txt(driver), textToVerify);
				results = ITNotificationSearch.searchResults_txt(driver).getText();
				System.out.println("Results: " + results);
			} catch (Exception e) {
				perform.rebuildElement(driver, ITNotificationSearch.searchResults_txt(driver));
				perform.waitForText(driver, ITNotificationSearch.searchResults_txt(driver), textToVerify);
				results = ITNotificationSearch.searchResults_txt(driver).getText();
				System.out.println("Results: " + results);
			} // end try/catch
			
			a++;
			
		} // end while
		
		// Verify notification exists
		perform.verifyTextContains(driver, results, textToVerify);

	} // end refreshNotificationListAndVerifyTextExists
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Wait for the grid to update</li>
	 *  <li>Get the text from the given column and row</li>
	 * </ul>.
	 *
	 * @param driver the driver
	 * @param columnToCheck the column
	 * @param row the row
	 * @return the row of notification search results
	 * @throws InterruptedException the interrupted exception
	 */
	public String verifyColumnTextInNotificationSearchResultsByRow(RemoteWebDriver driver, String columnToCheck, int row) throws InterruptedException {

		// Set the column number
		String columnNumber = null;
		
		// Set the column number
		switch (columnToCheck.toLowerCase()) {
		case "type":
			columnNumber = "1";
			break;
		case "condition":
			columnNumber = "2";
			break;
		case "from":
			columnNumber = "3";
			break;
		case "fromid":
			columnNumber = "4";
			break;
		case "to":
			columnNumber = "5";
			break;
		case "toid":
			columnNumber = "6";
			break;
		case "subject":
			columnNumber = "7";
			break;
		case "link":
			columnNumber = "8";
			break;
		case "sent":
			columnNumber = "9";
			break;
		case "productitemid":
			columnNumber = "10";
			break;
		case "template":
			columnNumber = "11";
			break;
		case "attachments":
			columnNumber = "12";
			break;
		case "replyto":
			columnNumber = "13";
			break;
		case "cc":
			columnNumber = "14";
			break;
		default:
			columnNumber = null;
			break;
		} // end switch
		
		// Wait for the grid to update
		perform.waitForText(driver, ITNotificationSearch.searchResults_txt(driver), "EMail");
		
		// Get the text from the given column and row
		String text = driver.findElement(By.cssSelector("#grdResults > tbody > tr:nth-child("+row+") > td:nth-child("+columnNumber+")")).getText();
		
		// Return the row
		return text;

	} // end verifyColumnTextInNotificationSearchResultsByRow
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Wait for the grid to update</li>
	 *  <li>Get a list of the table to get the To and Subject fields</li>
	 *  <li>Get the To field text</li>
	 *  <li>Verify the record exists</li>
	 * </ul>.
	 *
	 * @param driver the driver
	 * @param column the column
	 * @param resultText the result text
	 * @return the row of notification search results
	 * @throws InterruptedException the interrupted exception
	 */
	public int getRowOfNotificationSearchResults(RemoteWebDriver driver, String column, String resultText) throws InterruptedException {

		// Set the column number
		String columnNumber = null;
		
		// Set the column number
		switch (column.toLowerCase()) {
		case "type":
			columnNumber = "1";
			break;
		case "condition":
			columnNumber = "2";
			break;
		case "from":
			columnNumber = "3";
			break;
		case "fromid":
			columnNumber = "4";
			break;
		case "to":
			columnNumber = "5";
			break;
		case "toid":
			columnNumber = "6";
			break;
		case "subject":
			columnNumber = "7";
			break;
		case "link":
			columnNumber = "8";
			break;
		case "sent":
			columnNumber = "9";
			break;
		case "productitemid":
			columnNumber = "10";
			break;
		case "template":
			columnNumber = "11";
			break;
		case "attachments":
			columnNumber = "12";
			break;
		case "replyto":
			columnNumber = "13";
			break;
		case "cc":
			columnNumber = "14";
			break;
		default:
			columnNumber = null;
			break;
		} // end switch
		
		// Wait for the grid to update
		perform.waitForText(driver, ITNotificationSearch.searchResults_txt(driver), "EMail");
		
		// Get a list of the table to get the To and Subject fields
		List<WebElement> searchResults = driver.findElements(By.cssSelector(ITNotificationSearch.rowSearchResults_txt()));
		int i = 0;
		int row = 0;
		for (WebElement el : searchResults.subList(1, searchResults.size())) {

			// Get the To field text
			if (el.findElement(By.cssSelector("td:nth-child("+columnNumber+")")).getText().contains(resultText)) {
				
				// Get the row number
				row = i+2;
				
			} // end if

			// Increment the row number
			i++;
			
		} // end for
		
		// Verify the record was found
		Assert.assertTrue(row>0, "The row for the record in Notification Search was not found");
		
		// Return the row
		return row;

	} // end getRowOfNotificationSearchResults
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Build a list of records</li>
	 *  <li>Set the number of records minus 1 to eliminate the header row</li>
	 * </ul>.
	 *
	 * @param driver the driver
	 * @return the row of notification search results
	 */
	public int getTheNumberOfRecordsInNotificationSearch(RemoteWebDriver driver) {

		// Build the list of elements to get the number of records in the table
		List<WebElement> searchResults = driver.findElements(By.cssSelector(ITNotificationSearch.rowSearchResults_txt()));
		int numOfRecords = searchResults.size()-1;
		
		// Return the number of records in the table
		return numOfRecords;

	} // end getTheNumberOfRecordsInNotificationSearch
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Get the number of records in the Notification Search table</li>
	 *  <li>Enter a while loop if the number of results does not equal the expected number of results</li>
	 * </ul>.
	 *
	 * @param driver the driver
	 * @param expectedNumberOfRecords the expected number of records
	 * @param productItemID the product item ID
	 * @throws InterruptedException the interrupted exception
	 */
	public void waitForTheNumberOfRecordsInNotificationSearch(RemoteWebDriver driver, int expectedNumberOfRecords, String productItemID) throws InterruptedException {

		perform.sleep(driver, 2);
		
		int numOfRecords = it.getTheNumberOfRecordsInNotificationSearch(driver);
		int a = 1;
		while (numOfRecords!=expectedNumberOfRecords && a <= 5) {
			
			// Refresh the results
			refreshNotificationListAndVerifyTextExists(driver, "EMail");
			
			// Get the number of records in the table
			numOfRecords = it.getTheNumberOfRecordsInNotificationSearch(driver);
			
			a++;
			
		} // end while

	} // end waitForTheNumberOfRecordsInNotificationSearch
	
} // end Function_Secure class
