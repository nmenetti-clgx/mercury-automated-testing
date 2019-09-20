package regressionVendors;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjects.Vendors.VUsers;
import pageObjects.Vendors.VW9Form;
import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Vendors - W9 Information</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class W9Information extends TestSetup {
	
	/** The requesters name. */
	private static String requestersName = "";
	
	/** The name. */
	private static String name = "";
	
	/** The address. */
	private static String address = "";
	
	/** The city state zip. */
	private static String cityStateZip = "";
	
	/** The date. */
	private static String date = ""; 
	
	/** The ssn. */
	private static String ssn = "";
	
	/** The ein. */
	private static String ein = "";
	
	/** The exempt payee. */
	private static String exemptPayee = "";
	
	/** The exemption from FATCA. */
	private static String exemptionFromFATCA = "";
	
	/** The list account number. */
	private static String listAccountNumber = "";
	
	/** The num. */
	private static int num = 0;
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to vendors</li>
	 * 	<li>Click Users</li>
	 * 	<li>Click Professional</li>
	 * 	<li>Delete W-9 information if it exists</li>
	 * 	<li>Click Add new W-9 link</li>
	 * 	<li>Click Delete</li>
	 * 	<li>Click Yes</li>
	 * 	<li>Click Add new W-9 link</li>
	 * 	<li>Switch iFrame</li>
	 * 	<li>Enter text in Exempt payee code textbox</li>
	 * 	<li>Click Cancel</li>
	 * 	<li>Verify Save changes dialog text</li>
	 * 	<li>Click Cancel</li>
	 * 	<li>Click Click for Form W-9 Instructions link</li>
	 * 	<li>Switch to the new window</li>
	 * 	<li>Verify the link takes you to https:mktrsc.mercuryvmp.com/helpdocs/W-9Instructions.pdf</li>
	 * 	<li>Go back to the W-9 entry form in vendors</li>
	 * 	<li>Switch back to the original window</li>
	 * 	<li>Switch iFrame</li>
	 * 	<li>Fill out one more field</li>
	 * 	<li>Click Save</li>
	 * 	<li>Verify dialog text</li>
	 * 	<li>Verify you receive an Almost Done message</li>
	 * 	<li>Click OK</li>
	 * 	<li>Remove Business Name</li>
	 * 	<li>Fill out all remaining fields</li>
	 * 	<li>Verify Name is not blank</li>
	 * 	<li>Select Individual radio button</li>
	 * 	<li>Verify Exempt payee code is not empty</li>
	 * 	<li>Enter Exemption from FATCA</li>
	 * 	<li>Verify Address is not empty</li>
	 * 	<li>Verify City State Zip is not empty</li>
	 * 	<li>Enter List account number</li>
	 * 	<li>Verify Requester's name is not empty</li>
	 * 	<li>Generate random number to determine whether to enter SSN or EIN</li>
	 * 	<li>Enter Social security number</li>
	 * 	<li>Enter Employer identification number</li>
	 * 	<li>Check Cross out item 2 above</li>
	 * 	<li>Enter Signature of US Person</li>
	 * 	<li>Verify Date is not empty</li>
	 * 	<li>Click Save</li>
	 * 	<li>Verify dialog text</li>
	 * 	<li>Click OK</li>
	 * 	<li>Verify you receive no warning for Business Name field being blank</li>
	 * 	<li>Verify database info</li>
	 * 	<li>Set database values</li>
	 * 	<li>Verify businessName is blank</li>
	 * 	<li>Verify Name</li>
	 * 	<li>Verify exemptPayee</li>
	 * 	<li>Verify RequesterAddress</li>
	 * 	<li>Verify exemptionFromFATCA</li>
	 * 	<li>Verify address01</li>
	 * 	<li>Verify address02</li>
	 * 	<li>Verify accountNumbers</li>
	 * 	<li>Verify signature</li>
	 * 	<li>Verify signatureDate</li>
	 * 	<li>Verify signatureDate</li>
	 * 	<li>Verify ssn</li>
	 * 	<li>Verify ein is NULL</li>
	 * 	<li>Verify ein</li>
	 * 	<li>Verify ssn is NULL</li>
	 * 	<li>Log test</li>
	 * </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Vendors - Users", "Vendors - Professional", "Vendors - W9"}, alwaysRun=true)
	public void addW9Information() throws Exception {
		
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Login to vendors
		vendors.login(driver, "RegressionVendors3", StoredVariables.getpassword().get());
		
		// Click Users 
		vendors.goToUsers(driver);
		
		// Click Professional
		perform.click(driver,VUsers.professional_btn(driver));
		
		// Wait for Residential appraisal checkbox
		perform.waitForElementToBeClickable(driver, VUsers.residentialAppraisal_chkbx(), "id");
		
		// Delete W-9 information if it exists
		try {
			// Click Add new W-9 link
			perform.click(driver,driver.findElement(By.linkText("Add new W-9")));
		} catch (Exception e) {
			// Click Delete
			perform.click(driver,VW9Form.deleteW9_btn(driver));
			
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			// Wait for Yes button
			perform.waitForElementToBeClickable(driver, VW9Form.okAlmostDone_btn(), "id");
			
			// Click Yes
			perform.click(driver,VW9Form.okAlmostDone_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			// Click Add new W-9 link
			perform.click(driver,driver.findElement(By.linkText("Add new W-9")));
		}
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Switch iFrame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "Dialogs/W9.aspx", By.id(VW9Form.name_txtbx()));
		
		// Wait for Name textbox
		perform.waitForElementToBeClickable(driver, VW9Form.name_txtbx(), "id");
		
		// Enter text in Exempt payee code textbox
		if (!VW9Form.exemptPayeeCode_txtbx(driver).getAttribute("value").isEmpty())
		{
			VW9Form.exemptPayeeCode_txtbx(driver).clear();
		} // end if
		exemptPayee = perform.randomLetters(driver, 6);
		perform.type(driver, VW9Form.exemptPayeeCode_txtbx(driver), exemptPayee);
		
		// Click Cancel
		perform.click(driver,VW9Form.cancel_btn(driver));
		
		// Wait for dialog Cancel button
		perform.waitForElementToBeClickable(driver, VW9Form.cancelSaveChanges_btn(), "id");
		
		// Verify Save changes dialog text
		String dialogText = VW9Form.message_dialog(driver).getText();
		String[] expected = {"Save changes", 
				"You have unsaved changes. Save before continuing?"};
		perform.verifyTextContains(driver, dialogText, expected);
       		
		// Click Cancel
		perform.click(driver,VW9Form.cancelSaveChanges_btn(driver));
		
//		// Wait for Name textbox
//		perform.waitForElementToBeClickable(driver, VW9Form.name_txtbx(), "id");
//		
//		// Click Click for Form W-9 Instructions link
//		driver.findElement(By.linkText("Click for Form W-9 Instructions")));
//		
//		// Switch to the new window
//		perform.switchToWindowByTitle(driver, "Form W-9");
//		
//		// Verify the link takes you to https://mktrsc.mercuryvmp.com/helpdocs/W-9Instructions.pdf
//		Assert.assertTrue(driver.getCurrentUrl().equals("https://mktrsc.mercuryvmp.com/helpdocs/W-9Instructions.pdf"), "The Click for Form W-9 Instructions link opens the wrong URL");
//		
//		// Go back to the W-9 entry form in vendors
//		driver.close();
//		
//		// Switch back to the original window
//		driver.switchTo().window(StoredVariables.getwinHandleBefore().get());
		
		// Switch iFrame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "Dialogs/W9.aspx", By.id(VW9Form.requestersNameAndAddress_txtbx()));
		
		// Fill out one more field 
		if (!VW9Form.requestersNameAndAddress_txtbx(driver).getAttribute("value").isEmpty())
		{
			VW9Form.requestersNameAndAddress_txtbx(driver).clear();
		}
		requestersName = perform.randomLetters(driver, 12);
		System.out.println("requestersName = " + requestersName);
		perform.type(driver, VW9Form.requestersNameAndAddress_txtbx(driver), requestersName);
		
		// Click Save 
		perform.waitForElementToBeClickable(driver, VW9Form.save_btn(), "id");
		perform.click(driver,VW9Form.save_btn(driver));
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, VW9Form.okAlmostDone_btn(), "id");
		
		// Verify dialog text
		String dialog = VW9Form.message_dialog(driver).getText();
		perform.verifyTextDoesNotContain(driver, dialog, "An error occured");
		
		// Verify you receive an Almost Done message 
		dialogText = VW9Form.message_dialog(driver).getText();
		Assert.assertTrue(dialogText.contains("Almost done"), "The Almost done dialog text is incorrect");
		Assert.assertTrue(dialogText.contains("The following is required:"), "The Almost done dialog text is incorrect");
		
		// Click OK 
		perform.click(driver,VW9Form.okAlmostDone_btn(driver));
		
		// Wait for Name textbox
		perform.waitForElementToBeClickable(driver, VW9Form.name_txtbx(), "id");
		
		// Remove Business Name 
		VW9Form.businessName_txtbx(driver).clear();
		
		// Fill out all remaining fields
		// Verify Name is not blank
		Assert.assertTrue(!VW9Form.name_txtbx(driver).getAttribute("value").isEmpty(), "The Name should not be blank");
		name = VW9Form.name_txtbx(driver).getAttribute("value");
		
		// Select Individual radio button
		perform.click(driver,VW9Form.individual_radiobtn(driver));
		
		// Verify Exempt payee code is not empty
		Assert.assertTrue(!VW9Form.exemptPayeeCode_txtbx(driver).getAttribute("value").isEmpty(), "Exempt payee code should not be blank");
		
		// Enter Exemption from FATCA
		exemptionFromFATCA = perform.randomLetters(driver, 6);
		perform.type(driver, VW9Form.exemptionFromFATCA_txtbx(driver), exemptionFromFATCA);
		
		// Verify Address is not empty
		Assert.assertTrue(!VW9Form.address_txtbx(driver).getAttribute("value").isEmpty(), "Address should not be blank");
		address = VW9Form.address_txtbx(driver).getAttribute("value");
		
		// Verify City State Zip is not empty
		Assert.assertTrue(!VW9Form.cityStateZip_txtbx(driver).getAttribute("value").isEmpty(), "City, state, Zip should not be blank");
		cityStateZip = VW9Form.cityStateZip_txtbx(driver).getAttribute("value");
		
		// Enter List account number
		listAccountNumber = perform.randomLetters(driver, 8);
		perform.type(driver, VW9Form.listAccountNumbers_txtbx(driver), listAccountNumber);
		
		// Verify Requester's name is not empty
		Assert.assertTrue(!VW9Form.requestersNameAndAddress_txtbx(driver).getAttribute("value").isEmpty(), "Requeser's name and address should not be blank");
		
		// Generate random number to determine whether to enter SSN or EIN
		num = Integer.parseInt(perform.randomNumbers(driver, 1));
		System.out.println("num = " + num);
		
		if (num < 5)
		{
			// Enter Social security number
			String ssn1 = perform.randomNumbers(driver, 1);
			String ssn2 = perform.randomNumbers(driver, 1);
			String ssn3 = perform.randomNumbers(driver, 1);
			String ssn4 = perform.randomNumbers(driver, 1);
			String ssn5 = perform.randomNumbers(driver, 1);
			String ssn6 = perform.randomNumbers(driver, 1);
			String ssn7 = perform.randomNumbers(driver, 1);
			String ssn8 = perform.randomNumbers(driver, 1);
			String ssn9 = perform.randomNumbers(driver, 1);
			ssn = ssn1 + ssn2 + ssn3 + ssn4 + ssn5 + ssn6 + ssn7 + ssn8 + ssn9;
			perform.type(driver, VW9Form.ssn1_txtbx(driver), ssn1);
			perform.type(driver, VW9Form.ssn2_txtbx(driver), ssn2);
			perform.type(driver, VW9Form.ssn3_txtbx(driver), ssn3);
			perform.type(driver, VW9Form.ssn4_txtbx(driver), ssn4);
			perform.type(driver, VW9Form.ssn5_txtbx(driver), ssn5);
			perform.type(driver, VW9Form.ssn6_txtbx(driver), ssn6);
			perform.type(driver, VW9Form.ssn7_txtbx(driver), ssn7);
			perform.type(driver, VW9Form.ssn8_txtbx(driver), ssn8);
			perform.type(driver, VW9Form.ssn9_txtbx(driver), ssn9);
		} // end if
		else
		{
			// Enter Employer identification number
			String ein1 = perform.randomNumbers(driver, 1);
			String ein2 = perform.randomNumbers(driver, 1);
			String ein3 = perform.randomNumbers(driver, 1);
			String ein4 = perform.randomNumbers(driver, 1);
			String ein5 = perform.randomNumbers(driver, 1);
			String ein6 = perform.randomNumbers(driver, 1);
			String ein7 = perform.randomNumbers(driver, 1);
			String ein8 = perform.randomNumbers(driver, 1);
			String ein9 = perform.randomNumbers(driver, 1);
			ein = ein1 + ein2 + ein3 + ein4 + ein5 + ein6 + ein7 + ein8 + ein9;
			perform.type(driver, VW9Form.EIN1_txtbx(driver), ein1);
			perform.type(driver, VW9Form.EIN2_txtbx(driver), ein2);
			perform.type(driver, VW9Form.EIN3_txtbx(driver), ein3);
			perform.type(driver, VW9Form.EIN4_txtbx(driver), ein4);
			perform.type(driver, VW9Form.EIN5_txtbx(driver), ein5);
			perform.type(driver, VW9Form.EIN6_txtbx(driver), ein6);
			perform.type(driver, VW9Form.EIN7_txtbx(driver), ein7);
			perform.type(driver, VW9Form.EIN8_txtbx(driver), ein8);
			perform.type(driver, VW9Form.EIN9_txtbx(driver), ein9);
		} // end else
		
		// Check Cross out item 2 above
		perform.checkCheckbox(driver, VW9Form.crossOutItem2_chkbx(driver));
		
		// Enter Signature of US Person
		perform.type(driver, VW9Form.signatureOfUSPerson_txtbx(driver), name);
		
		// Verify Date is not empty
		Assert.assertTrue(!VW9Form.date_txtbx(driver).getAttribute("value").isEmpty(), "Date should not be blank");
		String date = VW9Form.date_txtbx(driver).getAttribute("value");
		
		Thread.sleep(3000);
		
		// Wait for Save button
		perform.waitForElementToBeClickable(driver, VW9Form.save_btn(), "id");
		
		// Click Save 
		perform.waitForElementToBeClickable(driver, VW9Form.save_btn(), "id");
		perform.click(driver,VW9Form.save_btn(driver));
		
		Thread.sleep(3000);
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, VW9Form.okAlmostDone_btn(), "id");
		
		// Verify dialog text
		dialog = VW9Form.message_dialog(driver).getText();
		Assert.assertTrue(!dialog.contains("An error occured"), "There was an error saving the W9 information. Dialog = " + dialog);
		
		// Click OK
		perform.click(driver,VW9Form.okAlmostDone_btn(driver));
		
		Thread.sleep(3000);
		
		// Verify you receive no warning for Business Name field being blank 
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Wait for remove button
		perform.waitForElementToBeClickable(driver, VW9Form.deleteW9_btn(), "cssSelector");
		
		if (StoredVariables.getusernameEnvironment().get().contains("QA") || StoredVariables.getusernameEnvironment().get().contains("Dev"))
		{
		
			//Verify database info
			ArrayList<String> results = db.getTaxInformationByRequesterAddressToArray(driver, requestersName);
			
			// Set database values
			String nameDB = results.get(1);
			String businessNameDB = results.get(2);
			String taxClassificationIDDB = results.get(3);
			String exemptPayeeDB = results.get(14);
			String requesterNameDB = results.get(7);
			String exemptionFromFATCADB = results.get(15);
			String address01DB = results.get(5);
			String address02DB = results.get(6);
			String listAccountNumberDB = results.get(8);
			String ssnDB = results.get(9);
			String signatureDB = results.get(12);
			String signatureDateDB = results.get(13);
			String einDB = results.get(10);
			
			// Verify businessName is blank
			Assert.assertTrue(businessNameDB.equals(""),
					"The businessName entry in the database should be blank. DB value = "
							+ businessNameDB + " and should be blank");
			
			// Verify Name
			Assert.assertTrue(nameDB.equals(name),
					"The Name entry in the database is incorrect. DB value = " + nameDB
							+ " and should be = " + name);
			
			// Verify exemptPayee
			Assert.assertTrue(exemptPayeeDB.equals(exemptPayee),
					"The exemptPayee entry in the database is incorrect. DB value = " + exemptPayeeDB
							+ " and should be = " + exemptPayee);
			
			// Verify RequesterAddress
			Assert.assertTrue(requesterNameDB.equals(requestersName),
					"The requesterAddress entry in the database is incorrect. DB value = " + requesterNameDB
							+ " and should be = " + requestersName);
			
			// Verify exemptionFromFATCA
			Assert.assertTrue(exemptionFromFATCADB.equals(exemptionFromFATCA),
					"The exemptionFromFATCA entry in the database is incorrect. DB value = "
							+ exemptionFromFATCADB + " and should be = " + exemptionFromFATCA);
			
			// Verify address01
			Assert.assertTrue(address01DB.equals(address),
					"The address01 entry in the database is incorrect. DB value = "
							+ address01DB + " and should be = " + address);
			
			// Verify address02
			Assert.assertTrue(address02DB.equals(cityStateZip),
					"The address02 entry in the database is incorrect. DB value = "
							+ address02DB + " and should be = " + cityStateZip);
			
			// Verify accountNumbers
			Assert.assertTrue(listAccountNumberDB.equals(listAccountNumber),
					"The ToEntityID entry in the database is incorrect. DB value = "
							+ listAccountNumberDB + " and should be = " + listAccountNumber);
			
			// Verify signature
			Assert.assertTrue(signatureDB.equals(name),
					"The Signature entry in the database is incorrect. DB value = "
							+ signatureDB + " and should be = " + name);
			
			// Verify signatureDate
			Assert.assertTrue(signatureDateDB.contains(date),
					"The ToEntityID entry in the database is incorrect. DB value = "
							+ signatureDateDB + " and should be = " + date);
			
			// Verify signatureDate
			Assert.assertTrue(taxClassificationIDDB.equals("1"),
					"The taxClassificationIDDB entry in the database is incorrect. DB value = "
							+ taxClassificationIDDB + " and should be = 1");
			
			if (num < 5)
			{
				// Verify ssn
				Assert.assertTrue(ssnDB.equals(ssn),
						"The SSN entry in the database is incorrect. DB value = "
								+ ssnDB + " and should be = " + ssn);
				
				// Verify ein is NULL
				Assert.assertTrue(einDB.equals("NULL"),
						"The ein entry in the database is incorrect. DB value = "
								+ einDB + " and should be NULL");
			} // end if enter SSN
			else
			{
				// Verify ein
				Assert.assertTrue(ssnDB.equals("NULL"),
						"The SSN entry in the database is incorrect. DB value = "
								+ ssnDB + " and should be NULL");
				
				// Verify ssn is NULL
				Assert.assertTrue(einDB.equals(ein),
						"The ein entry in the database is incorrect. DB value = "
								+ einDB + " and should be = " + ein);
			} // end if enter EIN
			
		} // end if QA, check the database
		
		// Log test
		perform.addInfoToExtentReport(driver, "Regression Vendors", "Verified you can add a W-9 and that the data gets in the DB correctly");
		
	} // end addW9Information
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to vendors</li>
	 * 	<li>Click Users</li>
	 * 	<li>Click Professional</li>
	 * 	<li>Click Edit</li>
	 * 	<li>Switch iFrame</li>
	 * 	<li>Clear the List account field</li>
	 * 	<li>Click Cancel</li>
	 * 	<li>Verify Save changes dialog text</li>
	 * 	<li>Click Cancel</li>
	 * 	<li>Enter List account number</li>
	 * 	<li>Click Save</li>
	 * 	<li>Verify dialog text</li>
	 * 	<li>Click OK</li>
	 * 	<li>Verify database info</li>
	 * 	<li>Set database values</li>
	 * 	<li>Verify businessName is blank</li>
	 * 	<li>Verify Name</li>
	 * 	<li>Verify exemptPayee</li>
	 * 	<li>Verify RequesterAddress</li>
	 * 	<li>Verify exemptionFromFATCA</li>
	 * 	<li>Verify address01</li>
	 * 	<li>Verify address02</li>
	 * 	<li>Verify accountNumbers</li>
	 * 	<li>Verify signature</li>
	 * 	<li>Verify signatureDate</li>
	 * 	<li>Verify signatureDate</li>
	 * 	<li>Verify ssn</li>
	 * 	<li>Verify ein is NULL</li>
	 * 	<li>Verify ein</li>
	 * 	<li>Verify ssn is NULL</li>
	 * 	<li>Log test</li>
	 * </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Vendors - Users", "Vendors - Professional", "Vendors - W9"}, dependsOnMethods="addW9Information")
	public void editW9Information() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Login to vendors
		vendors.login(driver, "RegressionVendors3", StoredVariables.getpassword().get());
		
		// Click Users 
		vendors.goToUsers(driver);
		
		// Click Professional
		perform.click(driver,VUsers.professional_btn(driver));
		
		// Wait for Residential appraisal checkbox
		perform.waitForElementToBeClickable(driver, VUsers.residentialAppraisal_chkbx(), "id");
		
		// Click Edit
		perform.click(driver,VW9Form.editW9_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Switch iFrame
		perform.waitForiFrameSrcAndSwitchToIt(driver, "Dialogs/W9.aspx", By.id(VW9Form.name_txtbx()));
		
		// Wait for Name textbox
		perform.waitForElementToBeClickable(driver, VW9Form.name_txtbx(), "id");

		// Clear the List account field
		VW9Form.listAccountNumbers_txtbx(driver).clear();
		
		// Click Cancel
		perform.click(driver,VW9Form.cancel_btn(driver));
		
		// Wait for dialog Cancel button
		perform.waitForElementToBeClickable(driver, VW9Form.cancelSaveChanges_btn(), "id");
		
		// Verify Save changes dialog text
		String dialogText = VW9Form.message_dialog(driver).getText();
		Assert.assertTrue(dialogText.contains("Save changes"), "The Save changes text is incorrect");
		Assert.assertTrue(dialogText.contains("You have unsaved changes. Save before continuing?"), "The Save changes text is incorrect");
		
		// Click Cancel
		perform.click(driver,VW9Form.cancelSaveChanges_btn(driver));
		
		// Wait for Name textbox
		perform.waitForElementToBeClickable(driver, VW9Form.name_txtbx(), "id");
		
		// Enter List account number
		String listAccountNumber = perform.randomLetters(driver, 8);
		perform.type(driver, VW9Form.listAccountNumbers_txtbx(driver), listAccountNumber);
		
		Thread.sleep(3000);
		
		// Click Save 
		perform.waitForElementToBeClickable(driver, VW9Form.save_btn(), "id");
		perform.click(driver,VW9Form.save_btn(driver));
		
		// Wait for OK button
		perform.waitForElementToBeClickable(driver, VW9Form.okAlmostDone_btn(), "id");
		
		// Verify dialog text
		String dialog = VW9Form.message_dialog(driver).getText();
		Assert.assertTrue(!dialog.contains("An error occured"), "There was an error saving the W9 information. Dialog = " + dialog);
		
		// Click OK
		perform.click(driver,VW9Form.okAlmostDone_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Wait for remove button
		perform.waitForElementToBeClickable(driver, VW9Form.deleteW9_btn(), "cssSelector");
		
		if (StoredVariables.getusernameEnvironment().get().contains("QA") || StoredVariables.getusernameEnvironment().get().contains("Dev"))
		{
		
			//Verify database info
			ArrayList<String> results = db.getTaxInformationByRequesterAddressToArray(driver, requestersName);
			
			// Set database values
			String nameDB = results.get(1);
			String businessNameDB = results.get(2);
			String taxClassificationIDDB = results.get(3);
			String exemptPayeeDB = results.get(14);
			String requesterNameDB = results.get(7);
			String exemptionFromFATCADB = results.get(15);
			String address01DB = results.get(5);
			String address02DB = results.get(6);
			String listAccountNumberDB = results.get(8);
			String ssnDB = results.get(9);
			String signatureDB = results.get(12);
			String signatureDateDB = results.get(13);
			String einDB = results.get(10);
			
			// Verify businessName is blank
			Assert.assertTrue(businessNameDB.equals(""),
					"The businessName entry in the database should be blank. DB value = "
							+ businessNameDB + " and should be blank");
			
			// Verify Name
			Assert.assertTrue(nameDB.equals(name),
					"The Name entry in the database is incorrect. DB value = " + nameDB
							+ " and should be = " + name);
			
			// Verify exemptPayee
			Assert.assertTrue(exemptPayeeDB.equals(exemptPayee),
					"The exemptPayee entry in the database is incorrect. DB value = " + exemptPayeeDB
							+ " and should be = " + exemptPayee);
			
			// Verify RequesterAddress
			Assert.assertTrue(requesterNameDB.equals(requestersName),
					"The requesterAddress entry in the database is incorrect. DB value = " + requesterNameDB
							+ " and should be = " + requestersName);
			
			// Verify exemptionFromFATCA
			Assert.assertTrue(exemptionFromFATCADB.equals(exemptionFromFATCA),
					"The exemptionFromFATCA entry in the database is incorrect. DB value = "
							+ exemptionFromFATCADB + " and should be = " + exemptionFromFATCA);
			
			// Verify address01
			Assert.assertTrue(address01DB.equals(address),
					"The address01 entry in the database is incorrect. DB value = "
							+ address01DB + " and should be = " + address);
			
			// Verify address02
			Assert.assertTrue(address02DB.equals(cityStateZip),
					"The address02 entry in the database is incorrect. DB value = "
							+ address02DB + " and should be = " + cityStateZip);
			
			// Verify accountNumbers
			Assert.assertTrue(listAccountNumberDB.equals(listAccountNumber),
					"The ToEntityID entry in the database is incorrect. DB value = "
							+ listAccountNumberDB + " and should be = " + listAccountNumber);
			
			// Verify signature
			Assert.assertTrue(signatureDB.equals(name),
					"The Signature entry in the database is incorrect. DB value = "
							+ signatureDB + " and should be = " + name);
			
			// Verify signatureDate
			Assert.assertTrue(signatureDateDB.contains(date),
					"The ToEntityID entry in the database is incorrect. DB value = "
							+ signatureDateDB + " and should be = " + date);
			
			// Verify signatureDate
			Assert.assertTrue(taxClassificationIDDB.equals("1"),
					"The taxClassificationIDDB entry in the database is incorrect. DB value = "
							+ taxClassificationIDDB + " and should be = 1");
			
			if (num < 5)
			{
				// Verify ssn
				Assert.assertTrue(ssnDB.equals(ssn),
						"The SSN entry in the database is incorrect. DB value = "
								+ ssnDB + " and should be = " + ssn);
				
				// Verify ein is NULL
				Assert.assertTrue(einDB.equals("NULL"),
						"The ein entry in the database is incorrect. DB value = "
								+ einDB + " and should be NULL");
			} // end if enter SSN
			else
			{
				// Verify ein
				Assert.assertTrue(ssnDB.equals("NULL"),
						"The SSN entry in the database is incorrect. DB value = "
								+ ssnDB + " and should be NULL");
				
				// Verify ssn is NULL
				Assert.assertTrue(einDB.equals(ein),
						"The ein entry in the database is incorrect. DB value = "
								+ einDB + " and should be = " + ein);
			} // end if enter EIN
			
		} // end if QA, check database
		
		// Log test
		test.log(LogStatus.INFO, "Regression Vendors", "Verified you can edit the W-9 and that the data gets in the DB correctly");
		
	} // end editW9Information
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Login to vendors</li>
	 * 	<li>Click Users</li>
	 * 	<li>Click Professional</li>
	 * 	<li>Click Delete</li>
	 * 	<li>Click Yes</li>
	 * 	<li>Log test</li>
	 * </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Vendors - Users", "Vendors - Professional", "Vendors - W9"}, dependsOnMethods="editW9Information")
	public void deleteW9Information() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		// Login to vendors
		vendors.login(driver, "RegressionVendors3", StoredVariables.getpassword().get());
		
		// Click Users 
		vendors.goToUsers(driver);
		
		// Click Professional
		perform.click(driver,VUsers.professional_btn(driver));
		
		// Wait for Residential appraisal checkbox
		perform.waitForElementToBeClickable(driver, VUsers.residentialAppraisal_chkbx(), "id");
		
		// Click Delete
		perform.click(driver,VW9Form.deleteW9_btn(driver));
		
		// Wait for overlay to be visible
		perform.waitForOverlayToBeVisible(driver);
		
		// Wait for Yes button
		perform.waitForElementToBeClickable(driver, VW9Form.okAlmostDone_btn(), "id");
		
		// Click Yes
		perform.click(driver,VW9Form.okAlmostDone_btn(driver));
		
		// Wait for overlay to be hidden
		perform.waitForOverlayToBeHidden(driver);
		
		// Wait for Add W-9 link
		perform.waitForElementToBeClickable(driver, "Add new W-9", "linkText");
		
		// Log test
		test.log(LogStatus.INFO, "Regression Vendors", "Verified you can delete the W-9");
		
	} // end deleteW9Information
	
} // end the W9Information class
