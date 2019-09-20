package baselineWhitelist;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjects.Secure.SConfirmOrder;
import pageObjects.Secure.SNewOrder;
import pageObjects.Secure.SOrderDetails;
import setup.DriverFactory;
import setup.TestSetup;
import utils.ExtentTestManager;
import utils.Retry;
import utils.StoredVariables;

// TODO: Auto-generated Javadoc
/**
 * <h1>Baseline - Whitelist Secure New Order</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   05-16-2018
 */

@Listeners(utils.Listener.class)
public class WhitelistSecureNewOrder extends TestSetup {
	
	/** The user secure. */
	private static String userSecure = "Whitelist1";
	
	/** The user vendors. */
	private static String userVendors = "WhitelistingAppraiser1";
	
	/** The password. */
	private static String password = "";
	
	/** The tracking number. */
	private static String trackingNumber = "";
	
	/** The whitelist characters 1. */
//	private static String whitelistCharacters1 = "��������������������������������������������������������������������������������������������������������������������������";
	private static String whitelistCharacters1 = "€‚ƒ„…†‡ˆ‰Š‹ŒŽ‘’“”•–—˜˜˜™š›œŸ ¡¢£¤¥¦§¨ª«¬­¯°±²³´µ¶·¸¹º»¼½¾¿ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚÛÜÝÞßàáâãäåæçèéêëìíîïðñòóôõö÷øùúûüýþÿ";
	
	/** The whitelist characters multi line 1. */
//	private static String whitelistCharactersMultiLine1 = "��������������������������������������������������������������������������������������������������������������������������";
	private static String whitelistCharactersMultiLine1 = "€‚ƒ„…†‡ˆ‰Š‹ŒŽ‘’“”•–—˜˜˜™š›œŸ ¡¢£¤¥¦§¨ª«¬­¯°±²³´µ¶·¸¹º»¼½¾¿ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚÛÜÝÞßàáâãäåæçèéêëìíîïðñòóôõö÷øùúûüýþÿ";
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Set the password for all tests</li>
	 * 	<li>Set Property Information data</li>
	 * 	<li>Get directionsIdentifier used to uniquely identify the order number and store it</li>
	 * 	<li>Set Assignment Information data</li>
	 * 	<li>Set Lender Information data</li>
	 * 	<li>Set Contact And Access Information data</li>
	 * 	<li>Set Additional Notification Recipients data</li>
	 * 	<li>Log in to secure</li>
	 * 	<li>Start a new Residential Appraisal order</li>
	 * 	<li>Click Edit Order Groups</li>
	 * 	<li>Switch focus to new dialog box iFrame</li>
	 * 	<li>Select Order Group To Add</li>
	 * 	<li>Create WebElement for Available Groups</li>
	 * 	<li>List all the options in Available Groups</li>
	 * 	<li>Loop through all Available Groups and click on the desired one</li>
	 * 	<li>click the desired option</li>
	 * 	<li>Add selected group to Eligible Vendors</li>
	 * 	<li>Click OK</li>
	 * 	<li>Switch to original iFrame</li>
	 * 	<li>Set Disclosure Date (Long and Short)</li>
	 * 	<li>Select Disclosure Date</li>
	 * 	<li>Enter Order Due date</li>
	 * 	<li>Click calendar for Disclosure</li>
	 * 	<li>Select the date</li>
	 * 	<li>Verify the date is correct</li>
	 * 	<li>Set Order Due Date (Long and Short)</li>
	 * 	<li>Select the Order Due date</li>
	 * 	<li>Click the Order Due calendar button</li>
	 * 	<li>Select the date</li>
	 * 	<li>Verify the correct order due date is correct</li>
	 * 	<li>Click Borrower Address button</li>
	 * 	<li>Click Save</li>
	 * 	<li>Enter additional email addresses</li>
	 * 	<li>Check Attach completed report</li>
	 * 	<li>Enter Product Requirements</li>
	 * 	<li>Enter Additional Comments</li>
	 * 	<li>Click the Click here link</li>
	 * 	<li>Verify information text</li>
	 * 	<li>Click the OK button</li>
	 * 	<li>Click Borrower Address button</li>
	 * 	<li>Verify property address populated</li>
	 * 	<li>Click Cancel</li>
	 * 	<li>Click Co-borrower Address button</li>
	 * 	<li>Verify borrower address populated</li>
	 * 	<li>Click Cancel</li>
	 * 	<li>Enter additional email addresses</li>
	 * 	<li>Verify Product requirements</li>
	 * 	<li>Verify additional comments</li>
	 * 	<li>Click Next</li>
	 * 	<li>Assign vendor</li>
	 * 	<li>Verify order information</li>
	 * 	<li>Click Next</li>
	 * 	<li>Set 40 second while loop timeout</li>
	 * 	<li>Get outside frames</li>
	 * 	<li>Get inside the attach document frame</li>
	 * 	<li>Click Finished</li>
	 * 	<li>Get outside frames</li>
	 * 	<li>Query the db to get the order number that was just created</li>
	 * 	<li>Set orderNumber</li>
	 * 	<li>Get database info</li>
	 * 	<li>Log in to Vendors</li>
	 * 	<li>Accept the order</li>
	 * 	<li>Log test</li>
	 * </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Whitelist", "Secure - Create Order", "Secure - Order Groups", "Vendors - Orders", "vendors - Accept Order"}, alwaysRun=true)
	public void whitelistNewOrderFormOnSecure() throws Exception{
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		if (StoredVariables.getmobile().get()==false) {
		
			// Set the password for all tests
			password = StoredVariables.getpassword().get();
			
			/***************************************
			 * New Order Information
			 ***************************************/
			
			// Set Property Information data
			StoredVariables.getpropertyInformationAddress().set("501-D NE 122nd St");
			StoredVariables.getpropertyInformationCity().set("Oklahoma City");
			StoredVariables.getpropertyInformationState().set("Oklahoma");
			StoredVariables.getpropertyInformationStateAbbr().set("OK"); // Must set for a field check later on
			StoredVariables.getpropertyInformationZip().set("73114");
			StoredVariables.getpropertyInformationCounty().set("Oklahoma");
			StoredVariables.getpropertyInformationSqFt().set("5688");
			StoredVariables.getpropertyInformationSiteSize().set("9,583 sq ft");
			StoredVariables.getpropertyInformationPropType().set("Single Family");
			StoredVariables.getpropertyInformationPropRights().set("Fee Simple");
			StoredVariables.getpropertyInformationLegalDesc().set("2844 Guilford Ln, Oklahoma City, OK 73120");
			// Get directionsIdentifier used to uniquely identify the order number and store it
			StoredVariables.getdirectionsIdentifier().set(new SimpleDateFormat("MMddHHmmss").format(Calendar.getInstance().getTime()));
			StoredVariables.getpropertyInformationDirections().set(StoredVariables.getpropertyInformationDirections().get() + " - " + StoredVariables.getdirectionsIdentifier().get());
			
			// Set Assignment Information data
			StoredVariables.getassignmentInformationForm().set("Uniform Residential Appraisal (FNMA 1004)");
			StoredVariables.getassignmentInformationRushOrder().set(true);
			StoredVariables.getassignmentInformationComplex().set(true);
			StoredVariables.getassignmentInformationOrderDue().set(7);
			perform.getNewDate(driver, StoredVariables.getassignmentInformationOrderDue().get());
			StoredVariables.getassignmentInformationOtherRefNumber().set(perform.randomNumbers(driver, 7));
			StoredVariables.getassignmentInformationLoanType().set("All In One");
			StoredVariables.getassignmentInformationLoanPurpose().set("Purchase");
			StoredVariables.getassignmentInformationOrderedBy().set("Borrower Name");
			StoredVariables.getassignmentInformationOrderGroup().set("");
			StoredVariables.getassignmentInformationLoanNumber().set(perform.randomNumbers(driver, 10));
			StoredVariables.getassignmentInformationFileNumber().set(perform.randomNumbers(driver, 5));
			StoredVariables.getassignmentInformationSalesPrice().set("645,715");
			StoredVariables.getassignmentInformationFHACaseNumber().set(perform.randomNumbers(driver, 5));
			StoredVariables.getassignmentInformationDisclosure().set(0);
			StoredVariables.getassignmentInformationAssignedTo().set("");
			
			// Set Lender Information data
			StoredVariables.getlenderInformationLenderName().set("BOKF, National Association");
			StoredVariables.getlenderInformationAddress1().set("One Williams Center");
			StoredVariables.getlenderInformationAddress2().set("Suite D");
			StoredVariables.getlenderInformationCity().set("Tulsa");
			StoredVariables.getlenderInformationState().set("OK");
			StoredVariables.getlenderInformationZip().set("74172");
			
			// Set Contact And Access Information data
			StoredVariables.getcontactOccupancy().set("Owner");
			StoredVariables.getborrowerIdentifier().set(new SimpleDateFormat("MMddHHmmss").format(Calendar.getInstance().getTime()));
			StoredVariables.getcontactBorrower().set("Borrower Name - " + StoredVariables.getborrowerIdentifier().get());
			StoredVariables.getcontactBorrowerInfo1Dropdown().set("Home");
			StoredVariables.getcontactBorrowerInfo1().set("405-555-7818");
			StoredVariables.getcontactBorrowerInfo2Dropdown().set("E-mail");
			StoredVariables.getcontactBorrowerInfo2().set("borrower@dntest.net");
			StoredVariables.getcontactBorrowerAddress().set("8051 Falcon Crst");
			StoredVariables.getcontactBorrowerCity().set("Edmond");
			StoredVariables.getcontactBorrowerState().set("OK");
			StoredVariables.getcontactBorrowerZip().set("73034");
			StoredVariables.getcontactCoBorrower().set("Coborrower Name");
			StoredVariables.getcontactCoBorrowerInfo1Dropdown().set("Work");
			StoredVariables.getcontactCoBorrowerInfo1().set("405-555-9813");
			StoredVariables.getcontactCoBorrowerInfo2Dropdown().set("Mobile");
			StoredVariables.getcontactCoBorrowerInfo2().set("405-555-1679");
			StoredVariables.getcontactCoBorrowerAddress().set("1509 Rain Tree Dr");
			StoredVariables.getcontactCoBorrowerCity().set("Moore");
			StoredVariables.getcontactCoBorrowerState().set("OK");
			StoredVariables.getcontactCoBorrowerZip().set("73160");
			StoredVariables.getcontactOwner().set("Owner Name");
			StoredVariables.getcontactOwnerInfo1Dropdown().set("Pager");
			StoredVariables.getcontactOwnerInfo1().set("405-555-8618");
			StoredVariables.getcontactOwnerInfo2Dropdown().set("Fax");
			StoredVariables.getcontactOwnerInfo2().set("405-555-7410");
			StoredVariables.getcontactOccupant().set("Occupant Name");
			StoredVariables.getcontactOccupantInfo1Dropdown().set("Home");
			StoredVariables.getcontactOccupantInfo1().set("405-555-3549");
			StoredVariables.getcontactOccupantInfo2Dropdown().set("Mobile");
			StoredVariables.getcontactOccupantInfo2().set("405-555-8895");
			StoredVariables.getcontactAgent().set("Agent Name");
			StoredVariables.getcontactAgentInfo1Dropdown().set("E-mail");
			StoredVariables.getcontactAgentInfo1().set("agent@dntest.net");
			StoredVariables.getcontactAgentInfo2Dropdown().set("Pager");
			StoredVariables.getcontactAgentInfo2().set("405-555-4893");
			StoredVariables.getcontactOther().set("Other Name");
			StoredVariables.getcontactOtherInfo1Dropdown().set("Work");
			StoredVariables.getcontactOtherInfo1().set("405-555-7825");
			StoredVariables.getcontactOtherInfo2Dropdown().set("Fax");
			StoredVariables.getcontactOtherInfo2().set("405-555-8688");
			StoredVariables.getcontactApptContact().set("Borrower");
			
			// Set Additional Notification Recipients data
			StoredVariables.getadditionalNotificationRecipientsAdditionalEmails().set("additionalEmail1@dntest.net; additionalEmail2@dntest.net");
			StoredVariables.getadditionalNotificationRecipientsAttachCompletedReport().set(true);
			StoredVariables.getproductRequirements().set("These are product requirements");
			StoredVariables.getadditionalComments().set("These are additional comments");
			
			/***************************************
			 * Check new order
			 ***************************************/
			
			// Log in to secure
			secure.login(driver, userSecure, password);
			
			// Start a new Residential Appraisal order
			secure.goToResidentialAppraisal(driver);
			
			/***************************************
			 * Enter Property Information
			 ***************************************/
			
			// Address
			perform.type(driver,SNewOrder.address_txtbx(driver), StoredVariables.getpropertyInformationAddress().get() + whitelistCharacters1);
	
			// City
			perform.type(driver,SNewOrder.city_txtbx(driver), StoredVariables.getpropertyInformationCity().get() + whitelistCharacters1);
			
			// State
			perform.selectDropdownOption(driver, SNewOrder.state_dropdown(driver), StoredVariables.getpropertyInformationState().get());
			
			// Zip Code
			perform.waitForElementToBeClickable(driver, SNewOrder.zipCode_txtbx(), "id");
			perform.type(driver,SNewOrder.zipCode_txtbx(driver), StoredVariables.getpropertyInformationZip().get());
			
			// Sq ft
			perform.type(driver,SNewOrder.sqFt_txtbx(driver), StoredVariables.getpropertyInformationSqFt().get() + whitelistCharacters1);
			
			// Verify Sq ft is entered correctly
			if (!SNewOrder.sqFt_txtbx(driver).getAttribute("value").equals(StoredVariables.getpropertyInformationSqFt().get() + whitelistCharacters1))
			{
				SNewOrder.sqFt_txtbx(driver).clear();
				perform.type(driver,SNewOrder.sqFt_txtbx(driver), StoredVariables.getpropertyInformationSqFt().get() + whitelistCharacters1);
			}
			
			// Wait for site size
			perform.waitForElementToBeClickable(driver, SNewOrder.siteSize_txtbx(), "id");
			
			// Site Size
			perform.type(driver,SNewOrder.siteSize_txtbx(driver), StoredVariables.getpropertyInformationSiteSize().get() + whitelistCharacters1);
			
			// Prop Type
			perform.selectDropdownOption(driver, SNewOrder.propType_dropdown(driver), StoredVariables.getpropertyInformationPropType().get());
			
			// Prop rights
			perform.selectDropdownOption(driver, SNewOrder.propRights_dropdown(driver), StoredVariables.getpropertyInformationPropRights().get());
			
			// Legal desc
			perform.type(driver,SNewOrder.legalDesc_txtbx(driver), StoredVariables.getpropertyInformationLegalDesc().get() + whitelistCharacters1);
			
			// Directions
			perform.type(driver,SNewOrder.directions_txtbx(driver), StoredVariables.getpropertyInformationDirections().get() + whitelistCharacters1);
	
			/***************************************
			 * Enter Assignment Information
			 ***************************************/
			
			// Form/type
			perform.selectDropdownOption(driver, SNewOrder.form_dropdown(driver), StoredVariables.getassignmentInformationForm().get());
			
			// Check Rush Order
			if (StoredVariables.getassignmentInformationRushOrder().get() == true && !SNewOrder.rushOrder_chkbx(driver).isSelected())
			{
				perform.click(driver,SNewOrder.rushOrder_chkbx(driver));
			}
			else if (StoredVariables.getassignmentInformationRushOrder().get() == false && SNewOrder.rushOrder_chkbx(driver).isSelected())
			{
				perform.click(driver,SNewOrder.rushOrder_chkbx(driver));
			}
			
			// Check Complex checkbox
			if (StoredVariables.getassignmentInformationComplex().get() == true && !SNewOrder.complex_chkbx(driver).isSelected())
			{
				perform.click(driver,SNewOrder.complex_chkbx(driver));				
			}
			else if (StoredVariables.getassignmentInformationComplex().get() == false && SNewOrder.complex_chkbx(driver).isSelected())
			{
				perform.click(driver,SNewOrder.complex_chkbx(driver));
			}
			
			// Other Ref #
			perform.type(driver,SNewOrder.otherRefNumber_txtbx(driver), StoredVariables.getassignmentInformationOtherRefNumber().get() + whitelistCharacters1);
			
			// Loan Type
			perform.selectDropdownOption(driver, SNewOrder.loanType_dropdown(driver), StoredVariables.getassignmentInformationLoanType().get());
			
			// Loan Purpose
			perform.selectDropdownOption(driver, SNewOrder.loanPurpose_dropdown(driver), StoredVariables.getassignmentInformationLoanPurpose().get());
			
			// Ordered By
			perform.type(driver,SNewOrder.orderedBy_txtbx(driver), StoredVariables.getassignmentInformationOrderedBy().get() + whitelistCharacters1);
			
			if (!StoredVariables.getassignmentInformationOrderGroup().get().equals(""))
			{
			
				// Click Edit Order Groups
				perform.click(driver,SNewOrder.editOrderGroups_lnk(driver));
				
				if (StoredVariables.getbrowser().get().equals("Chrome"))
				{
					Thread.sleep(500);				
				}
				
				// Switch focus to new dialog box iFrame
				driver.switchTo().defaultContent();
				driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'Controls/OrderGroupManagement.aspx')]")));
				
				// Select Order Group To Add
				// Create WebElement for Available Groups
				WebElement availableGroups = driver.findElement(By.id(SNewOrder.availableGroups_grid()));
				// List all the options in Available Groups
				List<WebElement> options = availableGroups.findElements(By.tagName("li"));
				// Loop through all Available Groups and click on the desired one
				for (WebElement option : options)
				{
				    if (option.getText().equals(StoredVariables.getassignmentInformationOrderGroup().get()))
				    {
				    	// click the desired option
				    	perform.click(driver,option);
				        break;
				    }
				}
				
				// Add selected group to Eligible Vendors
				perform.waitForElementToBeClickable(driver, SNewOrder.addEligibleVendors_btn(), "cssSelector");
				perform.click(driver,SNewOrder.addEligibleVendors_btn(driver));
				
				perform.waitForElementToBeClickable(driver, SNewOrder.ok_btn(), "id");
				
				// Click OK
				perform.click(driver,SNewOrder.ok_btn(driver));
				
				// Switch to original iFrame
				driver.switchTo().defaultContent();
				
				// Wait for overlay to be hidden
				perform.waitForOverlayToBeHidden(driver);
			
			} // end if for non-empty order group
			
			// Loan #
			perform.type(driver,SNewOrder.loanNumber_txtbx(driver), StoredVariables.getassignmentInformationLoanNumber().get() + whitelistCharacters1);
			
			// File #
			perform.type(driver,SNewOrder.fileNumber_txtbx(driver), StoredVariables.getassignmentInformationFileNumber().get() + whitelistCharacters1);
			
			// Sales Price
			perform.type(driver,SNewOrder.salesPrice_txtbx(driver), StoredVariables.getassignmentInformationSalesPrice().get());
			
			// FHA Case #
			perform.type(driver,SNewOrder.fhaCaseNumber_txtbx(driver), StoredVariables.getassignmentInformationFHACaseNumber().get());
			
			// Set Disclosure Date (Long and Short)
			perform.getNewDate(driver, StoredVariables.getassignmentInformationDisclosure().get());
			StoredVariables.getdisclosureDateLong().set(StoredVariables.getnewDateLong().get());
			StoredVariables.getdisclosureDateShort().set(StoredVariables.getnewDateShort().get());
			
			// Select Disclosure Date
			if (StoredVariables.getbrowser().get().equals("PhantomJS") || StoredVariables.getbrowser().get().equals("HtmlUnit") || StoredVariables.getbrowser().get().equals("IE") || StoredVariables.getmobile().get()==true)
			{
				// Enter Order Due date
				perform.type(driver,SNewOrder.disclosure_txtbx(driver), StoredVariables.getdisclosureDateLong().get());
			}
			else
			{
				// Click calendar for Disclosure
				perform.click(driver,SNewOrder.disclosureCalendar_btn(driver));
				
				// Select the date
				secure.selectDateFromCalendar(driver, StoredVariables.getassignmentInformationDisclosure().get());
				
				// Verify the date is correct
				Assert.assertTrue(SNewOrder.disclosure_txtbx(driver).getAttribute("value").equals(StoredVariables.getdisclosureDateLong().get()), "Date selected from calendar is the wrong date. It is - " + SNewOrder.disclosure_txtbx(driver).getAttribute("value") + " but should be " + StoredVariables.getdisclosureDateLong().get());
			}
			
			// Set Order Due Date (Long and Short)
			perform.getNewDate(driver, StoredVariables.getassignmentInformationOrderDue().get());
			StoredVariables.getorderDueDateLong().set(StoredVariables.getnewDateLong().get());
			StoredVariables.getorderDueDateShort().set(StoredVariables.getnewDateShort().get());
			
			// Select the Order Due date
			if (StoredVariables.getmobile().get()==false) {
				
				// Click the Order Due calendar button
				perform.waitForElementToBeClickable(driver, SNewOrder.orderDueCalendar_btn(), "id");
				perform.click(driver,SNewOrder.orderDueCalendar_btn(driver));
				
				// Select the date
				secure.selectDateFromCalendar(driver, StoredVariables.getassignmentInformationOrderDue().get());
				
			} else {
				
				StoredVariables.getcalendarDateLong().set(StoredVariables.getorderDueDateLong().get());
				// Enter the date
				perform.type(driver, SNewOrder.orderDue_txtbx(driver), StoredVariables.getorderDueDateLong().get());
				
			} // end if/else
			
			// Verify the correct order due date is correct
			Assert.assertTrue(SNewOrder.orderDue_txtbx(driver).getAttribute("value").equals(StoredVariables.getcalendarDateLong().get()), "Date selected from calendar is the wrong date. Trying to match - " + StoredVariables.getcalendarDateLong().get());
			
			// Assigned To
			if (!StoredVariables.getassignmentInformationAssignedTo().get().equals(""))
			{
				perform.selectDropdownOption(driver, SNewOrder.assignedTo_dropdown(driver), StoredVariables.getassignmentInformationAssignedTo().get());
			}
			
			/***************************************
			 * Enter Lender Information
			 ***************************************/
			
			// Lender name
			perform.type(driver,SNewOrder.lenderName_txtbx(driver), StoredVariables.getlenderInformationLenderName().get() + whitelistCharacters1);
			
			// Address 1
			perform.type(driver,SNewOrder.lenderAddress1_txtbx(driver), StoredVariables.getlenderInformationAddress1().get() + whitelistCharacters1);
			
			// Address 2
			perform.type(driver,SNewOrder.lenderAddress2_txtbx(driver), StoredVariables.getlenderInformationAddress2().get() + whitelistCharacters1);
			
			// City
			perform.type(driver,SNewOrder.lenderCity_txtbx(driver), StoredVariables.getlenderInformationCity().get() + whitelistCharacters1);
			
			// State
			perform.selectDropdownOption(driver, SNewOrder.lenderState_dropdown(driver), StoredVariables.getlenderInformationState().get());
			
			// Zip
			perform.type(driver,SNewOrder.lenderZip_txtbx(driver), StoredVariables.getlenderInformationZip().get());
			
			/***************************************
			 * Enter Contact And Access Information
			 ***************************************/
			
			// Occupancy
			perform.selectDropdownOption(driver, SNewOrder.occupancy_dropdown(driver), StoredVariables.getcontactOccupancy().get());
			
			// Borrower
			perform.type(driver,SNewOrder.borrower_txtbx(driver), StoredVariables.getcontactBorrower().get() + whitelistCharacters1);
			
			// Borrower Info 1 dropdown
			perform.selectDropdownOption(driver, SNewOrder.borrowerInfo1_dropdown(driver), StoredVariables.getcontactBorrowerInfo1Dropdown().get());
			
			// Borrower Info 1
			perform.type(driver,SNewOrder.borrowerInfo1_txtbx(driver), StoredVariables.getcontactBorrowerInfo1().get() + whitelistCharacters1);
			
			// Borrower Info 2 dropdown
			perform.selectDropdownOption(driver, SNewOrder.borrowerInfo2_dropdown(driver), StoredVariables.getcontactBorrowerInfo2Dropdown().get());
			
			// Borrower Info 2
			perform.type(driver,SNewOrder.borrowerInfo2_txtbx(driver), StoredVariables.getcontactBorrowerInfo2().get() + whitelistCharacters1);
			
			// Click Borrower Address button
			perform.click(driver,SNewOrder.borrowerAddress_btn(driver));
			
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			// Address
			perform.type(driver,SNewOrder.borrowerAddress_txtbx(driver), StoredVariables.getcontactBorrowerAddress().get() + whitelistCharacters1);
			
			// City
			perform.type(driver,SNewOrder.borrowerCity_txtbx(driver), StoredVariables.getcontactBorrowerCity().get() + whitelistCharacters1);
			
			// State
			perform.type(driver,SNewOrder.borrowerState_txtbx(driver), StoredVariables.getcontactBorrowerState().get() + whitelistCharacters1);
			
			// Zip
			perform.type(driver,SNewOrder.borrowerZip_txtbx(driver), StoredVariables.getcontactBorrowerZip().get() + whitelistCharacters1);
			
			// Click Save
			perform.click(driver,SNewOrder.borrowerSave_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			// Co-borrower
			perform.type(driver,SNewOrder.coBorrower_txtbx(driver), StoredVariables.getcontactCoBorrower().get() + whitelistCharacters1);
			
			// Co-borrower Info 1 dropdown
			perform.selectDropdownOption(driver, SNewOrder.coBorrowerInfo1_dropdown(driver), StoredVariables.getcontactCoBorrowerInfo1Dropdown().get());
			
			// Co-borrower Info 1
			perform.type(driver,SNewOrder.coBorrowerInfo1_txtbx(driver), StoredVariables.getcontactCoBorrowerInfo1().get() + whitelistCharacters1);
			
			// Co-borrower Info 2 dropdown
			perform.selectDropdownOption(driver, SNewOrder.coBorrowerInfo2_dropdown(driver), StoredVariables.getcontactCoBorrowerInfo2Dropdown().get());
			
			// Co-borrower Info 2
			perform.type(driver,SNewOrder.coBorrowerInfo2_txtbx(driver), StoredVariables.getcontactCoBorrowerInfo2().get() + whitelistCharacters1);
			
			// Click Co-borrower Address button
			perform.click(driver,SNewOrder.coBorrowerAddress_btn(driver));
			
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			// Address
			perform.type(driver,SNewOrder.coBorrowerAddress_txtbx(driver), StoredVariables.getcontactCoBorrowerAddress().get() + whitelistCharacters1);
			
			// City
			perform.type(driver,SNewOrder.coBorrowerCity_txtbx(driver), StoredVariables.getcontactCoBorrowerCity().get() + whitelistCharacters1);
			
			// State
			perform.type(driver,SNewOrder.coBorrowerState_txtbx(driver), StoredVariables.getcontactCoBorrowerState().get() + whitelistCharacters1);
			
			// Zip
			perform.type(driver,SNewOrder.coBorrowerZip_txtbx(driver), StoredVariables.getcontactCoBorrowerZip().get() + whitelistCharacters1);
			
			// Click Save
			perform.click(driver,SNewOrder.coBorrowerSave_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			// Owner
			perform.type(driver,SNewOrder.owner_txtbx(driver), StoredVariables.getcontactOwner().get() + whitelistCharacters1);
			
			// Owner Info 1 dropdown
			perform.selectDropdownOption(driver, SNewOrder.ownerInfo1_dropdown(driver), StoredVariables.getcontactOwnerInfo1Dropdown().get());
			
			// Owner Info 1
			perform.type(driver,SNewOrder.ownerInfo1_txtbx(driver), StoredVariables.getcontactOwnerInfo1().get() + whitelistCharacters1);
			
			// Owner Info 2 dropdown
			perform.selectDropdownOption(driver, SNewOrder.ownerInfo2_dropdown(driver), StoredVariables.getcontactOwnerInfo2Dropdown().get());
			
			// Owner Info 2
			perform.type(driver,SNewOrder.ownerInfo2_txtbx(driver), StoredVariables.getcontactOwnerInfo2().get() + whitelistCharacters1);
			
			// Occupant
			perform.type(driver,SNewOrder.occupant_txtbx(driver), StoredVariables.getcontactOccupant().get() + whitelistCharacters1);
			
			// Occupant Info 1 dropdown
			perform.selectDropdownOption(driver, SNewOrder.occupantInfo1_dropdown(driver), StoredVariables.getcontactOccupantInfo1Dropdown().get());
			
			// Occupant Info 1
			perform.type(driver,SNewOrder.occupantInfo1_txtbx(driver), StoredVariables.getcontactOccupantInfo1().get() + whitelistCharacters1);
			
			// Occupant Info 2 dropdown
			perform.selectDropdownOption(driver, SNewOrder.occupantInfo2_dropdown(driver), StoredVariables.getcontactOccupantInfo2Dropdown().get());
			
			// Occupant Info 2
			perform.type(driver,SNewOrder.occupantInfo2_txtbx(driver), StoredVariables.getcontactOccupantInfo2().get() + whitelistCharacters1);
			
			// Agent
			perform.type(driver,SNewOrder.agent_txtbx(driver), StoredVariables.getcontactAgent().get() + whitelistCharacters1);
			
			// Agent Info 1 dropdown
			perform.selectDropdownOption(driver, SNewOrder.agentInfo1_dropdown(driver), StoredVariables.getcontactAgentInfo1Dropdown().get());
			
			// Agent Info 1
			perform.type(driver,SNewOrder.agentInfo1_txtbx(driver), StoredVariables.getcontactAgentInfo1().get() + whitelistCharacters1);
			
			// Agent Info 2 dropdown
			perform.selectDropdownOption(driver, SNewOrder.agentInfo2_dropdown(driver), StoredVariables.getcontactAgentInfo2Dropdown().get());
			
			// Agent Info 2
			perform.type(driver,SNewOrder.agentInfo2_txtbx(driver), StoredVariables.getcontactAgentInfo2().get() + whitelistCharacters1);
			
			// Other
			perform.type(driver,SNewOrder.other_txtbx(driver), StoredVariables.getcontactOther().get() + whitelistCharacters1);
			
			// Other Info 1 dropdown
			perform.selectDropdownOption(driver, SNewOrder.otherInfo1_dropdown(driver), StoredVariables.getcontactOtherInfo1Dropdown().get());
			
			// Other Info 1
			perform.type(driver,SNewOrder.otherInfo1_txtbx(driver), StoredVariables.getcontactOtherInfo1().get() + whitelistCharacters1);
			
			// Other Info 2 dropdown
			perform.selectDropdownOption(driver, SNewOrder.otherInfo2_dropdown(driver), StoredVariables.getcontactOtherInfo2Dropdown().get());
			
			// Other Info 2
			perform.type(driver,SNewOrder.otherInfo2_txtbx(driver), StoredVariables.getcontactOtherInfo2().get() + whitelistCharacters1);
			
			// Appt. Contact
			System.out.println("ApptContact = " + StoredVariables.getcontactApptContact().get());
			if (!StoredVariables.getcontactApptContact().get().equals(""))
			{
				try {
					perform.selectDropdownOption(driver, SNewOrder.apptContact_dropdown(driver), StoredVariables.getcontactApptContact().get());
				}
				catch (Exception e){}
			}
			
			/***********************************************
			 * Enter Additional Notifications Recipients
			 ***********************************************/
			
			// Enter additional email addresses
			perform.type(driver,SNewOrder.additionalEmailRecipients_txtbx(driver), StoredVariables.getadditionalNotificationRecipientsAdditionalEmails().get() + whitelistCharacters1);
			
			// Check Attach completed report
			if (StoredVariables.getadditionalNotificationRecipientsAttachCompletedReport().get() == true && !SNewOrder.attachCompletedReport_chkbx(driver).isSelected())
			{
				perform.click(driver,SNewOrder.attachCompletedReport_chkbx(driver));
			}
			else if (StoredVariables.getadditionalNotificationRecipientsAttachCompletedReport().get() == false && SNewOrder.attachCompletedReport_chkbx(driver).isSelected())
			{
				perform.click(driver,SNewOrder.attachCompletedReport_chkbx(driver));
			}
			
			// Enter Product Requirements
			StoredVariables.getproductRequirements().set(SNewOrder.productRequirements_txtbx(driver).getAttribute("value"));
			SNewOrder.productRequirements_txtbx(driver).clear();
			perform.type(driver,SNewOrder.productRequirements_txtbx(driver), StoredVariables.getproductRequirements().get() + whitelistCharactersMultiLine1);
			
			// Enter Additional Comments
			perform.type(driver,SNewOrder.additionalComments_txtbx(driver), StoredVariables.getadditionalComments().get() + whitelistCharactersMultiLine1);
			
			// Click the Click here link
			perform.click(driver,SNewOrder.clickHere_lnk(driver));
			
			// Verify information text
			Assert.assertTrue(SNewOrder.clickHere_txt(driver).getText().equals("The notification sent to additional recipients is an unsecured e-mail. Because the vendor and client documents contain non-public personal information (NPI), sending such information via an unsecured channel is a violation of the Gramm-Leach-Bliley Act (GLB), and can cause compliance issues for the lender."), "Sending via E-mail text has changed");
			
			// Click the OK button
			perform.click(driver,SNewOrder.clickHereOK_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			/**********************************************
			 * VERIFY ALL FIELDS WERE WHITELISTED
			 **********************************************/
			
			/***************************************
			 * Verify Property Information
			 ***************************************/
			
			// Address
			Assert.assertTrue(SNewOrder.address_txtbx(driver).getAttribute("value").equals(StoredVariables.getpropertyInformationAddress().get()), "The Address field did not get whitelisted correctly");
	
			// City
			Assert.assertTrue(SNewOrder.city_txtbx(driver).getAttribute("value").equals(StoredVariables.getpropertyInformationCity().get()), "The City field did not get whitelisted correctly");
			
			// Zip Code
			Assert.assertTrue(SNewOrder.zipCode_txtbx(driver).getAttribute("value").equals(StoredVariables.getpropertyInformationZip().get()), "The Zip code field did not get whitelisted correctly");
			
			// Sq ft
			Assert.assertTrue(SNewOrder.sqFt_txtbx(driver).getAttribute("value").equals(StoredVariables.getpropertyInformationSqFt().get()), "The Sq Ft field did not get whitelisted correctly");
			
			// Site Size
			Assert.assertTrue(SNewOrder.siteSize_txtbx(driver).getAttribute("value").equals(StoredVariables.getpropertyInformationSiteSize().get()), "The Site Size field did not get whitelisted correctly");
			
			// Legal desc
			Assert.assertTrue(SNewOrder.legalDesc_txtbx(driver).getAttribute("value").equals(StoredVariables.getpropertyInformationLegalDesc().get()), "The Legal desc field did not get whitelisted correctly");
			
			// Directions
			Assert.assertTrue(SNewOrder.directions_txtbx(driver).getAttribute("value").equals(StoredVariables.getpropertyInformationDirections().get()), "The Directions field did not get whitelisted correctly");
	
			/***************************************
			 * Verify Assignment Information
			 ***************************************/
			
			// Other Ref #
			Assert.assertTrue(SNewOrder.otherRefNumber_txtbx(driver).getAttribute("value").equals(StoredVariables.getassignmentInformationOtherRefNumber().get()), "The Other Ref # field did not get whitelisted correctly");
			
			// Ordered By
			Assert.assertTrue(SNewOrder.orderedBy_txtbx(driver).getAttribute("value").equals(StoredVariables.getassignmentInformationOrderedBy().get()), "The Ordered By field did not get whitelisted correctly");
			
			// Loan #
			Assert.assertTrue(SNewOrder.loanNumber_txtbx(driver).getAttribute("value").equals(StoredVariables.getassignmentInformationLoanNumber().get()), "The Loan # field did not get whitelisted correctly");
			
			// File #
			Assert.assertTrue(SNewOrder.fileNumber_txtbx(driver).getAttribute("value").equals(StoredVariables.getassignmentInformationFileNumber().get()), "The File # field did not get whitelisted correctly");
			
			// Sales Price
			Assert.assertTrue(SNewOrder.salesPrice_txtbx(driver).getAttribute("value").equals(StoredVariables.getassignmentInformationSalesPrice().get()), "The Sales Price field did not get whitelisted correctly");
			
			// FHA Case #
			Assert.assertTrue(SNewOrder.fhaCaseNumber_txtbx(driver).getAttribute("value").equals(StoredVariables.getassignmentInformationFHACaseNumber().get()), "The FHA Case # field did not get whitelisted correctly");
			
			/***************************************
			 * Verify Lender Information
			 ***************************************/
			
			// Lender name
			Assert.assertTrue(SNewOrder.lenderName_txtbx(driver).getAttribute("value").equals(StoredVariables.getlenderInformationLenderName().get()), "The Lender name field did not get whitelisted correctly");
			
			// Address 1
			Assert.assertTrue(SNewOrder.lenderAddress1_txtbx(driver).getAttribute("value").equals(StoredVariables.getlenderInformationAddress1().get()), "The Address 1 field did not get whitelisted correctly");
			
			// Address 2
			Assert.assertTrue(SNewOrder.lenderAddress2_txtbx(driver).getAttribute("value").equals(StoredVariables.getlenderInformationAddress2().get()), "The Address 2 field did not get whitelisted correctly");
			
			// City
			Assert.assertTrue(SNewOrder.lenderCity_txtbx(driver).getAttribute("value").equals(StoredVariables.getlenderInformationCity().get()), "The City field did not get whitelisted correctly");
			
			// Zip
			Assert.assertTrue(SNewOrder.lenderZip_txtbx(driver).getAttribute("value").equals(StoredVariables.getlenderInformationZip().get()), "The Zip field did not get whitelisted correctly");
			
			/***************************************
			 * Verify Contact And Access Information
			 ***************************************/
			
			// Borrower
			Assert.assertTrue(SNewOrder.borrower_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactBorrower().get()), "The Borrower field did not get whitelisted correctly");
			
			// Borrower Info 1
			Assert.assertTrue(SNewOrder.borrowerInfo1_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactBorrowerInfo1().get()), "The Borrower Info 1 field did not get whitelisted correctly");
			
			// Borrower Info 2
			Assert.assertTrue(SNewOrder.borrowerInfo2_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactBorrowerInfo2().get()), "The Borrower Info 2 field did not get whitelisted correctly");
			
			// Click Borrower Address button
			perform.click(driver,SNewOrder.borrowerAddress_btn(driver));
			
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			// Verify property address populated
			Assert.assertTrue(SNewOrder.borrowerAddress_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactBorrowerAddress().get()), "The Borrower Address field did not get whitelisted correctly");
			Assert.assertTrue(SNewOrder.borrowerCity_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactBorrowerCity().get()), "The Borrower City field did not get whitelisted correctly");
			Assert.assertTrue(SNewOrder.borrowerState_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactBorrowerState().get()), "The Borrower State field did not get whitelisted correctly");
			Assert.assertTrue(SNewOrder.borrowerZip_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactBorrowerZip().get()), "The Borrower Zip field did not get whitelisted correctly");
			
			// Click Cancel
			perform.click(driver,SNewOrder.borrowerCancel_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			// Co-borrower
			Assert.assertTrue(SNewOrder.coBorrower_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactCoBorrower().get()), "The Co-borrower field did not get whitelisted correctly");
			
			// Co-borrower Info 1
			Assert.assertTrue(SNewOrder.coBorrowerInfo1_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactCoBorrowerInfo1().get()), "The Co-borrower Info 1 field did not get whitelisted correctly");
			
			// Co-borrower Info 2
			Assert.assertTrue(SNewOrder.coBorrowerInfo2_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactCoBorrowerInfo2().get()), "The Co-borrower Info 2 field did not get whitelisted correctly");
			
			// Click Co-borrower Address button
			perform.click(driver,SNewOrder.coBorrowerAddress_btn(driver));
			
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			// Verify borrower address populated
			Assert.assertTrue(SNewOrder.coBorrowerAddress_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactCoBorrowerAddress().get()), "The co-borrower address did not get whitelisted correctly");
			Assert.assertTrue(SNewOrder.coBorrowerCity_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactCoBorrowerCity().get()), "The co-borrower contact property city did  not get whitelisted correctly");
			Assert.assertTrue(SNewOrder.coBorrowerState_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactCoBorrowerState().get()), "The co-borrower contact property state did not get whitelisted correctly");
			Assert.assertTrue(SNewOrder.coBorrowerZip_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactCoBorrowerZip().get()), "The co-borrower contact property zip code did not get whitelisted correctly");
			
			// Click Cancel
			perform.click(driver,SNewOrder.coBorrowerCancel_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			// Owner
			Assert.assertTrue(SNewOrder.owner_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactOwner().get()), "The Owner field did not get whitelisted correctly");
			
			// Owner Info 1
			Assert.assertTrue(SNewOrder.ownerInfo1_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactOwnerInfo1().get()), "The Owner Info 1 field did not get whitelisted correctly");
			
			// Owner Info 2
			Assert.assertTrue(SNewOrder.ownerInfo2_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactOwnerInfo2().get()), "The Owner Info 2 field did not get whitelisted correctly");
			
			// Occupant
			Assert.assertTrue(SNewOrder.occupant_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactOccupant().get()), "The Occupant field did not get whitelisted correctly");
			
			// Occupant Info 1
			Assert.assertTrue(SNewOrder.occupantInfo1_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactOccupantInfo1().get()), "The Occupant Info 1 field did not get whitelisted correctly");
			
			// Occupant Info 2
			Assert.assertTrue(SNewOrder.occupantInfo2_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactOccupantInfo2().get()), "The Occupant Info 2 field did not get whitelisted correctly");
			
			// Agent
			Assert.assertTrue(SNewOrder.agent_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactAgent().get()), "The Agent field did not get whitelisted correctly");
			
			// Agent Info 1
			Assert.assertTrue(SNewOrder.agentInfo1_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactAgentInfo1().get()), "The Agent Info 1 field did not get whitelisted correctly");
			
			// Agent Info 2
			Assert.assertTrue(SNewOrder.agentInfo2_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactAgentInfo2().get()), "The Agent Info 2 field did not get whitelisted correctly");
			
			// Other
			Assert.assertTrue(SNewOrder.other_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactOther().get()), "The Other field did not get whitelisted correctly");
			
			// Other Info 1
			Assert.assertTrue(SNewOrder.otherInfo1_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactOtherInfo1().get()), "The Other Info 1 field did not get whitelisted correctly");
			
			// Other Info 2
			Assert.assertTrue(SNewOrder.otherInfo2_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactOtherInfo2().get()), "The Other Info 2 field did not get whitelisted correctly");
			
			/***********************************************
			 * Verify Additional Notifications Recipients
			 ***********************************************/
			
			// Enter additional email addresses
			Assert.assertTrue(SNewOrder.additionalEmailRecipients_txtbx(driver).getAttribute("value").equals(StoredVariables.getadditionalNotificationRecipientsAdditionalEmails().get()), "The Additional Notifications Recipients field did not get whitelisted correctly");
			
			// Verify Product requirements
			Assert.assertTrue(SNewOrder.productRequirements_txtbx(driver).getAttribute("value").equals(StoredVariables.getproductRequirements().get()), "The Product Requirements field did not get whitelisted correctly");
			
			// Verify additional comments
			Assert.assertTrue(SNewOrder.additionalComments_txtbx(driver).getAttribute("value").equals(StoredVariables.getadditionalComments().get()), "The Additional Comments field did not get whitelisted correctly");
			
			// Click Next
			perform.click(driver,SNewOrder.next_btn(driver));
			
			// Assign vendor
			secure.selectVendor(driver, userVendors);
			
			// Verify order information
			secure.verifyOrderDetails(driver);
			
			// Click Next
			perform.click(driver,SConfirmOrder.nextBottom_btn(driver));
			
			// Wait for frames
			perform.waitForIFrames(driver);
			
			// Wait for dialog to move
			String dialogText = driver.findElement(By.id("ClickDialogText")).getAttribute("style");
			// Set 40 second while loop timeout
			long start_time = System.currentTimeMillis();
			long wait_time = 40000;
			long end_time = start_time + wait_time;
			while(System.currentTimeMillis() < end_time && !dialogText.contains("display: none;"))
			{
				Thread.sleep(500);
				dialogText = driver.findElement(By.id("ClickDialogText")).getAttribute("style");
				if (dialogText.contains("display: none;"))
				{
					break;
				} // end if
			} // end while
			
			// Get outside frames
			driver.switchTo().defaultContent();
			// Get inside the attach document frame
			driver.switchTo().frame("iframeAttach");
			
			// Wait for message text
			perform.waitForElementToBeClickable(driver, SConfirmOrder.uploadDocuments_btn(), "id");
			
			// Click Finished
			perform.click(driver,SConfirmOrder.finished_btn(driver));
			
			// Get outside frames
			driver.switchTo().defaultContent();
			
			// Query the db to get the order number that was just created
			db.getLoanID(driver);
			
			// Set orderNumber
			trackingNumber = StoredVariables.gettrackingNumber().get();
			
			// Get database info
			db.verifyNewOrderDataInDB_All(driver, StoredVariables.getloanID().get());
			
			// Log in to Vendors
			vendors.login(driver, userVendors, password);
			
			// Accept the order
			vendors.acceptOrder(driver, trackingNumber);
			
			// Log test
			test.log(LogStatus.INFO, "Whitelist", "Verified that the New Order is whitelisted and the characters get stripped correctly");
		
		} // end if
		
	} // end whitelistNewOrderFormOnSecure
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Edit the order from VMP XSite and check the box for "Attach completed report to the completion or pending quality review�"  **Must have this bit enabled by dev</li>
	 * 	<li>Log in to Secure</li>
	 * 	<li>Find order</li>
	 * 	<li>Open the order</li>
	 * 	<li>Click Edit</li>
	 * 	<li>Click on Lender Name</li>
	 * 	<li>Verify FHA Doc File ID and Appraised textboxes were whitelisted</li>
	 * 	<li>Click Borrower Address button</li>
	 * 	<li>Click Save</li>
	 * 	<li>Click Co-borrower Address button</li>
	 * 	<li>Click Save</li>
	 * 	<li>Enter additional email addresses</li>
	 * 	<li>Enter Product Requirements</li>
	 * 	<li>Enter Additional Comments</li>
	 * 	<li>Click Product Requirements</li>
	 * 	<li>Click Borrower Address button</li>
	 * 	<li>Verify property address populated</li>
	 * 	<li>Click Cancel</li>
	 * 	<li>Click Co-borrower Address button</li>
	 * 	<li>Verify borrower address populated</li>
	 * 	<li>Click Cancel</li>
	 * 	<li>Enter additional email addresses</li>
	 * 	<li>Verify Product requirements</li>
	 * 	<li>Verify additional comments</li>
	 * 	<li>Verify order fee</li>
	 * 	<li>Log test</li>
	 * </ul>
	 * @throws Exception the exception
	 */
	@Test (retryAnalyzer = Retry.class, groups={"Whitelist", "Secure - Orders", "Secure - Edit Order"}, dependsOnMethods="whitelistNewOrderFormOnSecure")
	public void whitelistEditOrderFormOnSecure() throws Exception {
		
		ExtentTest test = ExtentTestManager.getTest();
		RemoteWebDriver driver = DriverFactory.getInstance().getDriver();
		
		if (StoredVariables.getmobile().get()==false) {
		
			// Edit the order from VMP XSite and check the box for "Attach completed report to the completion or pending quality review�"  **Must have this bit enabled by dev
			// Log in to Secure
			secure.login(driver, userSecure, password);
			
			// Find order
			secure.findOrder(driver, trackingNumber, "Tracking number");
			
			// Open the order
			secure.openOrder(driver, trackingNumber);
			
			// Click Edit
			perform.click(driver,SOrderDetails.edit_btn(driver));
			
			// Wait for Address textbox
			perform.waitForElementToBeClickable(driver, SNewOrder.address_txtbx(), "id");
			
			// Address
			SNewOrder.address_txtbx(driver).clear();
			perform.type(driver,SNewOrder.address_txtbx(driver), StoredVariables.getpropertyInformationAddress().get() + whitelistCharacters1);
	
			// City
			SNewOrder.city_txtbx(driver).clear();
			perform.type(driver,SNewOrder.city_txtbx(driver), StoredVariables.getpropertyInformationCity().get() + whitelistCharacters1);
			
			// Zip Code
			perform.waitForElementToBeClickable(driver, SNewOrder.zipCode_txtbx(), "id");
			SNewOrder.zipCode_txtbx(driver).clear();
			perform.type(driver,SNewOrder.zipCode_txtbx(driver), StoredVariables.getpropertyInformationZip().get());
			
			// Sq ft
			SNewOrder.sqFt_txtbx(driver).clear();
			perform.type(driver,SNewOrder.sqFt_txtbx(driver), StoredVariables.getpropertyInformationSqFt().get() + whitelistCharacters1);
			
			// Verify Sq ft is entered correctly
			if (!SNewOrder.sqFt_txtbx(driver).getAttribute("value").equals(StoredVariables.getpropertyInformationSqFt().get() + whitelistCharacters1))
			{
				SNewOrder.sqFt_txtbx(driver).clear();
				perform.type(driver,SNewOrder.sqFt_txtbx(driver), StoredVariables.getpropertyInformationSqFt().get() + whitelistCharacters1);
			}
			
			// Site Size
			SNewOrder.siteSize_txtbx(driver).clear();
			perform.type(driver,SNewOrder.siteSize_txtbx(driver), StoredVariables.getpropertyInformationSiteSize().get() + whitelistCharacters1);
			
			// Legal desc
			SNewOrder.legalDesc_txtbx(driver).clear();
			perform.type(driver,SNewOrder.legalDesc_txtbx(driver), StoredVariables.getpropertyInformationLegalDesc().get() + whitelistCharacters1);
			
			// Directions
			SNewOrder.directions_txtbx(driver).clear();
			perform.type(driver,SNewOrder.directions_txtbx(driver), StoredVariables.getpropertyInformationDirections().get() + whitelistCharacters1);
	
			/***************************************
			 * Enter Assignment Information
			 ***************************************/
			
			// Other Ref #
			SNewOrder.otherRefNumber_txtbx(driver).clear();
			perform.type(driver,SNewOrder.otherRefNumber_txtbx(driver), StoredVariables.getassignmentInformationOtherRefNumber().get() + whitelistCharacters1);
			
			// Ordered By
			SNewOrder.orderedBy_txtbx(driver).clear();
			perform.type(driver,SNewOrder.orderedBy_txtbx(driver), StoredVariables.getassignmentInformationOrderedBy().get() + whitelistCharacters1);
			
			// UCDP Doc File ID
			String ucdpDocFileID = perform.randomNumbers(driver, 6); 
			perform.type(driver,SNewOrder.ucdpDocFileID_txtbx(driver), ucdpDocFileID);
			
			// Loan #
			SNewOrder.loanNumber_txtbx(driver).clear();
			perform.type(driver,SNewOrder.loanNumber_txtbx(driver), StoredVariables.getassignmentInformationLoanNumber().get() + whitelistCharacters1);
			
			// File #
			SNewOrder.fileNumber_txtbx(driver).clear();
			perform.type(driver,SNewOrder.fileNumber_txtbx(driver), StoredVariables.getassignmentInformationFileNumber().get() + whitelistCharacters1);
			
			// Sales Price
			SNewOrder.salesPrice_txtbx(driver).clear();
			perform.type(driver,SNewOrder.salesPrice_txtbx(driver), StoredVariables.getassignmentInformationSalesPrice().get());
			
			// FHA Case #
			SNewOrder.fhaCaseNumber_txtbx(driver).clear();
			perform.type(driver,SNewOrder.fhaCaseNumber_txtbx(driver), StoredVariables.getassignmentInformationFHACaseNumber().get() + whitelistCharacters1);
			
			// FHA Doc File ID
			String fhaDocFileID = perform.randomNumbers(driver, 6);
			perform.type(driver,SNewOrder.fhaDocFileID_txtbx(driver), fhaDocFileID);
			
			// Appraised
			String appraised = perform.randomLetters(driver, 6);
			perform.type(driver,SNewOrder.appraised_txtbx(driver), appraised + whitelistCharacters1);
			
			// Click on Lender Name
			perform.click(driver,SNewOrder.lenderName_txtbx(driver));
			
			// Verify FHA Doc File ID and Appraised textboxes were whitelisted
			Assert.assertTrue(SNewOrder.fhaDocFileID_txtbx(driver).getAttribute("value").equals(fhaDocFileID), "The FHA Doc File ID field did not get whitelisted correctly");
			Assert.assertTrue(SNewOrder.appraised_txtbx(driver).getAttribute("value").equals(appraised), "The Appraised field did not get whitelisted correctly");
			
			/***************************************
			 * Enter Lender Information
			 ***************************************/
			
			// Lender name
			SNewOrder.lenderName_txtbx(driver).clear();
			perform.type(driver,SNewOrder.lenderName_txtbx(driver), StoredVariables.getlenderInformationLenderName().get() + whitelistCharacters1);
			
			// Address 1
			SNewOrder.lenderAddress1_txtbx(driver).clear();
			perform.type(driver,SNewOrder.lenderAddress1_txtbx(driver), StoredVariables.getlenderInformationAddress1().get() + whitelistCharacters1);
			
			// Address 2
			SNewOrder.lenderAddress2_txtbx(driver).clear();
			perform.type(driver,SNewOrder.lenderAddress2_txtbx(driver), StoredVariables.getlenderInformationAddress2().get() + whitelistCharacters1);
			
			// City
			SNewOrder.lenderCity_txtbx(driver).clear();
			perform.type(driver,SNewOrder.lenderCity_txtbx(driver), StoredVariables.getlenderInformationCity().get() + whitelistCharacters1);
			
			// Zip
			SNewOrder.lenderZip_txtbx(driver).clear();
			perform.type(driver,SNewOrder.lenderZip_txtbx(driver), StoredVariables.getlenderInformationZip().get());
			
			/***************************************
			 * Enter Contact And Access Information
			 ***************************************/
			
			// Borrower
			SNewOrder.borrower_txtbx(driver).clear();
			perform.type(driver,SNewOrder.borrower_txtbx(driver), StoredVariables.getcontactBorrower().get() + whitelistCharacters1);
			
			// Borrower Info 1
			SNewOrder.borrowerInfo1_txtbx(driver).clear();
			perform.type(driver,SNewOrder.borrowerInfo1_txtbx(driver), StoredVariables.getcontactBorrowerInfo1().get() + whitelistCharacters1);
			
			// Borrower Info 2
			SNewOrder.borrowerInfo2_txtbx(driver).clear();
			perform.type(driver,SNewOrder.borrowerInfo2_txtbx(driver), StoredVariables.getcontactBorrowerInfo2().get() + whitelistCharacters1);
			
			// Click Borrower Address button
			perform.click(driver,SNewOrder.borrowerAddress_btn(driver));
			
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			// Address
			SNewOrder.borrowerAddress_txtbx(driver).clear();
			perform.type(driver,SNewOrder.borrowerAddress_txtbx(driver), StoredVariables.getcontactBorrowerAddress().get() + whitelistCharacters1);
			
			// City
			SNewOrder.borrowerCity_txtbx(driver).clear();
			perform.type(driver,SNewOrder.borrowerCity_txtbx(driver), StoredVariables.getcontactBorrowerCity().get() + whitelistCharacters1);
			
			// State
			SNewOrder.borrowerState_txtbx(driver).clear();
			perform.type(driver,SNewOrder.borrowerState_txtbx(driver), StoredVariables.getcontactBorrowerState().get() + whitelistCharacters1);
			
			// Zip
			SNewOrder.borrowerZip_txtbx(driver).clear();
			perform.type(driver,SNewOrder.borrowerZip_txtbx(driver), StoredVariables.getcontactBorrowerZip().get() + whitelistCharacters1);
			
			// Click Save
			perform.click(driver,SNewOrder.borrowerSave_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			// Co-borrower
			SNewOrder.coBorrower_txtbx(driver).clear();
			perform.type(driver,SNewOrder.coBorrower_txtbx(driver), StoredVariables.getcontactCoBorrower().get() + whitelistCharacters1);
			
			// Co-borrower Info 1
			SNewOrder.coBorrowerInfo1_txtbx(driver).clear();
			perform.type(driver,SNewOrder.coBorrowerInfo1_txtbx(driver), StoredVariables.getcontactCoBorrowerInfo1().get() + whitelistCharacters1);
			
			// Co-borrower Info 2
			SNewOrder.coBorrowerInfo2_txtbx(driver).clear();
			perform.type(driver,SNewOrder.coBorrowerInfo2_txtbx(driver), StoredVariables.getcontactCoBorrowerInfo2().get() + whitelistCharacters1);
			
			// Click Co-borrower Address button
			perform.click(driver,SNewOrder.coBorrowerAddress_btn(driver));
			
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			// Address
			SNewOrder.coBorrowerAddress_txtbx(driver).clear();
			perform.type(driver,SNewOrder.coBorrowerAddress_txtbx(driver), StoredVariables.getcontactCoBorrowerAddress().get() + whitelistCharacters1);
			
			// City
			SNewOrder.coBorrowerCity_txtbx(driver).clear();
			perform.type(driver,SNewOrder.coBorrowerCity_txtbx(driver), StoredVariables.getcontactCoBorrowerCity().get() + whitelistCharacters1);
			
			// State
			SNewOrder.coBorrowerState_txtbx(driver).clear();
			perform.type(driver,SNewOrder.coBorrowerState_txtbx(driver), StoredVariables.getcontactCoBorrowerState().get() + whitelistCharacters1);
			
			// Zip
			SNewOrder.coBorrowerZip_txtbx(driver).clear();
			perform.type(driver,SNewOrder.coBorrowerZip_txtbx(driver), StoredVariables.getcontactCoBorrowerZip().get() + whitelistCharacters1);
			
			// Click Save
			perform.click(driver,SNewOrder.coBorrowerSave_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			// Owner
			SNewOrder.owner_txtbx(driver).clear();
			perform.type(driver,SNewOrder.owner_txtbx(driver), StoredVariables.getcontactOwner().get() + whitelistCharacters1);
			
			// Owner Info 1
			SNewOrder.ownerInfo1_txtbx(driver).clear();
			perform.type(driver,SNewOrder.ownerInfo1_txtbx(driver), StoredVariables.getcontactOwnerInfo1().get() + whitelistCharacters1);
			
			// Owner Info 2
			SNewOrder.ownerInfo2_txtbx(driver).clear();
			perform.type(driver,SNewOrder.ownerInfo2_txtbx(driver), StoredVariables.getcontactOwnerInfo2().get() + whitelistCharacters1);
			
			// Occupant
			SNewOrder.occupant_txtbx(driver).clear();
			perform.type(driver,SNewOrder.occupant_txtbx(driver), StoredVariables.getcontactOccupant().get() + whitelistCharacters1);
			
			// Occupant Info 1
			SNewOrder.occupantInfo1_txtbx(driver).clear();
			perform.type(driver,SNewOrder.occupantInfo1_txtbx(driver), StoredVariables.getcontactOccupantInfo1().get() + whitelistCharacters1);
			
			// Occupant Info 2
			SNewOrder.occupantInfo2_txtbx(driver).clear();
			perform.type(driver,SNewOrder.occupantInfo2_txtbx(driver), StoredVariables.getcontactOccupantInfo2().get() + whitelistCharacters1);
			
			// Agent
			SNewOrder.agent_txtbx(driver).clear();
			perform.type(driver,SNewOrder.agent_txtbx(driver), StoredVariables.getcontactAgent().get() + whitelistCharacters1);
			
			// Agent Info 1
			SNewOrder.agentInfo1_txtbx(driver).clear();
			perform.type(driver,SNewOrder.agentInfo1_txtbx(driver), StoredVariables.getcontactAgentInfo1().get() + whitelistCharacters1);
			
			// Agent Info 2
			SNewOrder.agentInfo2_txtbx(driver).clear();
			perform.type(driver,SNewOrder.agentInfo2_txtbx(driver), StoredVariables.getcontactAgentInfo2().get() + whitelistCharacters1);
			
			// Other
			SNewOrder.other_txtbx(driver).clear();
			perform.type(driver,SNewOrder.other_txtbx(driver), StoredVariables.getcontactOther().get() + whitelistCharacters1);
			
			// Other Info 1
			SNewOrder.otherInfo1_txtbx(driver).clear();
			perform.type(driver,SNewOrder.otherInfo1_txtbx(driver), StoredVariables.getcontactOtherInfo1().get() + whitelistCharacters1);
			
			// Other Info 2
			SNewOrder.otherInfo2_txtbx(driver).clear();
			perform.type(driver,SNewOrder.otherInfo2_txtbx(driver), StoredVariables.getcontactOtherInfo2().get() + whitelistCharacters1);
			
			/***********************************************
			 * Enter Additional Notifications Recipients
			 ***********************************************/
			
			// Enter additional email addresses
			SNewOrder.additionalEmailRecipients_txtbx(driver).clear();
			perform.type(driver,SNewOrder.additionalEmailRecipients_txtbx(driver), StoredVariables.getadditionalNotificationRecipientsAdditionalEmails().get() + whitelistCharacters1);
			
			// Enter Product Requirements
			SNewOrder.productRequirements_txtbx(driver).clear();
			perform.type(driver,SNewOrder.productRequirements_txtbx(driver), StoredVariables.getproductRequirements().get() + whitelistCharactersMultiLine1);
			
			// Enter Additional Comments
			SNewOrder.additionalComments_txtbx(driver).clear();
			perform.type(driver,SNewOrder.additionalComments_txtbx(driver), StoredVariables.getadditionalComments().get() + whitelistCharactersMultiLine1);
			
			// Order Fee
			String orderFee = SNewOrder.orderFee_txtbx(driver).getAttribute("value");
			SNewOrder.orderFee_txtbx(driver).clear();
			perform.type(driver,SNewOrder.orderFee_txtbx(driver), orderFee);
			
			// Click Product Requirements
			perform.click(driver,SNewOrder.productRequirements_txtbx(driver));
			
			/**********************************************
			 * VERIFY ALL FIELDS WERE WHITELISTED
			 **********************************************/
			
			/***************************************
			 * Verify Property Information
			 ***************************************/
			
			// Address
			Assert.assertTrue(SNewOrder.address_txtbx(driver).getAttribute("value").equals(StoredVariables.getpropertyInformationAddress().get()), "The Address field did not get whitelisted correctly");
	
			// City
			Assert.assertTrue(SNewOrder.city_txtbx(driver).getAttribute("value").equals(StoredVariables.getpropertyInformationCity().get()), "The City field did not get whitelisted correctly");
			
			// Zip Code
			Assert.assertTrue(SNewOrder.zipCode_txtbx(driver).getAttribute("value").equals(StoredVariables.getpropertyInformationZip().get()), "The Zip code field did not get whitelisted correctly");
			
			// Sq ft
			Assert.assertTrue(SNewOrder.sqFt_txtbx(driver).getAttribute("value").equals(StoredVariables.getpropertyInformationSqFt().get()), "The Sq Ft field did not get whitelisted correctly");
			
			// Site Size
			Assert.assertTrue(SNewOrder.siteSize_txtbx(driver).getAttribute("value").equals(StoredVariables.getpropertyInformationSiteSize().get()), "The Site Size field did not get whitelisted correctly");
			
			// Legal desc
			Assert.assertTrue(SNewOrder.legalDesc_txtbx(driver).getAttribute("value").equals(StoredVariables.getpropertyInformationLegalDesc().get()), "The Legal desc field did not get whitelisted correctly");
			
			// Directions
			Assert.assertTrue(SNewOrder.directions_txtbx(driver).getAttribute("value").equals(StoredVariables.getpropertyInformationDirections().get()), "The Directions field did not get whitelisted correctly");
	
			/***************************************
			 * Verify Assignment Information
			 ***************************************/
			
			// Other Ref #
			Assert.assertTrue(SNewOrder.otherRefNumber_txtbx(driver).getAttribute("value").equals(StoredVariables.getassignmentInformationOtherRefNumber().get()), "The Other Ref # field did not get whitelisted correctly");
			
			// Ordered By
			Assert.assertTrue(SNewOrder.orderedBy_txtbx(driver).getAttribute("value").equals(StoredVariables.getassignmentInformationOrderedBy().get()), "The Ordered By field did not get whitelisted correctly");
			
			// UCDP Doc File ID
			Assert.assertTrue(SNewOrder.ucdpDocFileID_txtbx(driver).getAttribute("value").equals(ucdpDocFileID), "The UCDP Doc File ID field did not get whitelisted correctly");
			
			// Loan #
			Assert.assertTrue(SNewOrder.loanNumber_txtbx(driver).getAttribute("value").equals(StoredVariables.getassignmentInformationLoanNumber().get()), "The Loan # field did not get whitelisted correctly");
			
			// File #
			Assert.assertTrue(SNewOrder.fileNumber_txtbx(driver).getAttribute("value").equals(StoredVariables.getassignmentInformationFileNumber().get()), "The File # field did not get whitelisted correctly");
			
			// Sales Price
			Assert.assertTrue(SNewOrder.salesPrice_txtbx(driver).getAttribute("value").equals(StoredVariables.getassignmentInformationSalesPrice().get()), "The Sales Price field did not get whitelisted correctly");
			
			// FHA Case #
			Assert.assertTrue(SNewOrder.fhaCaseNumber_txtbx(driver).getAttribute("value").equals(StoredVariables.getassignmentInformationFHACaseNumber().get()), "The FHA Case # field did not get whitelisted correctly");
			
			// FHA Doc File ID
			Assert.assertTrue(SNewOrder.fhaDocFileID_txtbx(driver).getAttribute("value").equals(fhaDocFileID), "The FHA Doc File ID field did not get whitelisted correctly");
			
			// Appraised
			Assert.assertTrue(SNewOrder.appraised_txtbx(driver).getAttribute("value").equals(appraised), "The Appraised field did not get whitelisted correctly");
			
			/***************************************
			 * Verify Lender Information
			 ***************************************/
			
			// Lender name
			Assert.assertTrue(SNewOrder.lenderName_txtbx(driver).getAttribute("value").equals(StoredVariables.getlenderInformationLenderName().get()), "The Lender name field did not get whitelisted correctly");
			
			// Address 1
			Assert.assertTrue(SNewOrder.lenderAddress1_txtbx(driver).getAttribute("value").equals(StoredVariables.getlenderInformationAddress1().get()), "The Address 1 field did not get whitelisted correctly");
			
			// Address 2
			Assert.assertTrue(SNewOrder.lenderAddress2_txtbx(driver).getAttribute("value").equals(StoredVariables.getlenderInformationAddress2().get()), "The Address 2 field did not get whitelisted correctly");
			
			// City
			Assert.assertTrue(SNewOrder.lenderCity_txtbx(driver).getAttribute("value").equals(StoredVariables.getlenderInformationCity().get()), "The City field did not get whitelisted correctly");
			
			// Zip
			Assert.assertTrue(SNewOrder.lenderZip_txtbx(driver).getAttribute("value").equals(StoredVariables.getlenderInformationZip().get()), "The Zip field did not get whitelisted correctly");
			
			/***************************************
			 * Verify Contact And Access Information
			 ***************************************/
			
			// Borrower
			Assert.assertTrue(SNewOrder.borrower_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactBorrower().get()), "The Borrower field did not get whitelisted correctly");
			
			// Borrower Info 1
			Assert.assertTrue(SNewOrder.borrowerInfo1_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactBorrowerInfo1().get()), "The Borrower Info 1 field did not get whitelisted correctly");
			
			// Borrower Info 2
			Assert.assertTrue(SNewOrder.borrowerInfo2_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactBorrowerInfo2().get()), "The Borrower Info 2 field did not get whitelisted correctly");
			
			// Click Borrower Address button
			perform.click(driver,SNewOrder.borrowerAddress_btn(driver));
			
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			// Verify property address populated
			Assert.assertTrue(SNewOrder.borrowerAddress_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactBorrowerAddress().get()), "The Borrower Address field did not get whitelisted correctly");
			Assert.assertTrue(SNewOrder.borrowerCity_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactBorrowerCity().get()), "The Borrower City field did not get whitelisted correctly");
			Assert.assertTrue(SNewOrder.borrowerState_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactBorrowerState().get()), "The Borrower State field did not get whitelisted correctly");
			Assert.assertTrue(SNewOrder.borrowerZip_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactBorrowerZip().get()), "The Borrower Zip field did not get whitelisted correctly");
			
			// Click Cancel
			perform.click(driver,SNewOrder.borrowerCancel_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			// Co-borrower
			Assert.assertTrue(SNewOrder.coBorrower_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactCoBorrower().get()), "The Co-borrower field did not get whitelisted correctly");
			
			// Co-borrower Info 1
			Assert.assertTrue(SNewOrder.coBorrowerInfo1_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactCoBorrowerInfo1().get()), "The Co-borrower Info 1 field did not get whitelisted correctly");
			
			// Co-borrower Info 2
			Assert.assertTrue(SNewOrder.coBorrowerInfo2_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactCoBorrowerInfo2().get()), "The Co-borrower Info 2 field did not get whitelisted correctly");
			
			// Click Co-borrower Address button
			perform.click(driver,SNewOrder.coBorrowerAddress_btn(driver));
			
			// Wait for overlay to be visible
			perform.waitForOverlayToBeVisible(driver);
			
			// Verify borrower address populated
			Assert.assertTrue(SNewOrder.coBorrowerAddress_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactCoBorrowerAddress().get()), "The co-borrower address did not get whitelisted correctly");
			Assert.assertTrue(SNewOrder.coBorrowerCity_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactCoBorrowerCity().get()), "The co-borrower contact property city did  not get whitelisted correctly");
			Assert.assertTrue(SNewOrder.coBorrowerState_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactCoBorrowerState().get()), "The co-borrower contact property state did not get whitelisted correctly");
			Assert.assertTrue(SNewOrder.coBorrowerZip_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactCoBorrowerZip().get()), "The co-borrower contact property zip code did not get whitelisted correctly");
			
			// Click Cancel
			perform.click(driver,SNewOrder.coBorrowerCancel_btn(driver));
			
			// Wait for overlay to be hidden
			perform.waitForOverlayToBeHidden(driver);
			
			// Owner
			Assert.assertTrue(SNewOrder.owner_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactOwner().get()), "The Owner field did not get whitelisted correctly");
			
			// Owner Info 1
			Assert.assertTrue(SNewOrder.ownerInfo1_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactOwnerInfo1().get()), "The Owner Info 1 field did not get whitelisted correctly");
			
			// Owner Info 2
			Assert.assertTrue(SNewOrder.ownerInfo2_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactOwnerInfo2().get()), "The Owner Info 2 field did not get whitelisted correctly");
			
			// Occupant
			Assert.assertTrue(SNewOrder.occupant_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactOccupant().get()), "The Occupant field did not get whitelisted correctly");
			
			// Occupant Info 1
			Assert.assertTrue(SNewOrder.occupantInfo1_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactOccupantInfo1().get()), "The Occupant Info 1 field did not get whitelisted correctly");
			
			// Occupant Info 2
			Assert.assertTrue(SNewOrder.occupantInfo2_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactOccupantInfo2().get()), "The Occupant Info 2 field did not get whitelisted correctly");
			
			// Agent
			Assert.assertTrue(SNewOrder.agent_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactAgent().get()), "The Agent field did not get whitelisted correctly");
			
			// Agent Info 1
			Assert.assertTrue(SNewOrder.agentInfo1_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactAgentInfo1().get()), "The Agent Info 1 field did not get whitelisted correctly");
			
			// Agent Info 2
			Assert.assertTrue(SNewOrder.agentInfo2_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactAgentInfo2().get()), "The Agent Info 2 field did not get whitelisted correctly");
			
			// Other
			Assert.assertTrue(SNewOrder.other_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactOther().get()), "The Other field did not get whitelisted correctly");
			
			// Other Info 1
			Assert.assertTrue(SNewOrder.otherInfo1_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactOtherInfo1().get()), "The Other Info 1 field did not get whitelisted correctly");
			
			// Other Info 2
			Assert.assertTrue(SNewOrder.otherInfo2_txtbx(driver).getAttribute("value").equals(StoredVariables.getcontactOtherInfo2().get()), "The Other Info 2 field did not get whitelisted correctly");
			
			/***********************************************
			 * Verify Additional Notifications Recipients
			 ***********************************************/
			
			// Enter additional email addresses
			Assert.assertTrue(SNewOrder.additionalEmailRecipients_txtbx(driver).getAttribute("value").equals(StoredVariables.getadditionalNotificationRecipientsAdditionalEmails().get()), "The Additional Notifications Recipients field did not get whitelisted correctly");
			
			// Verify Product requirements
			Assert.assertTrue(SNewOrder.productRequirements_txtbx(driver).getAttribute("value").equals(StoredVariables.getproductRequirements().get()), "The Product Requirements field did not get whitelisted correctly");
			
			// Verify additional comments
			Assert.assertTrue(SNewOrder.additionalComments_txtbx(driver).getAttribute("value").equals(StoredVariables.getadditionalComments().get()), "The Additional Comments field did not get whitelisted correctly");
			
			// Verify order fee
			Assert.assertTrue(SNewOrder.orderFee_txtbx(driver).getAttribute("value").equals(orderFee), "The Order Fee field did not get whitelisted correctly");
			
			// Log test
			test.log(LogStatus.INFO, "Whitelist", "Verified that the Edit Order is whitelisted and the characters get stripped correctly");
			
		} // end if
		
	} // end whitelistEditOrderFormOnSecure
	
} // end the WhitelistSecureNewOrder class
