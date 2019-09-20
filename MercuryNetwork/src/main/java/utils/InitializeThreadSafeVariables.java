package utils;

import java.lang.ref.Reference;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.List;

import setup.TestSetup;

/**
* <h1>Initialize Thread Safe Variables</h1>
* 
* <p>
* 
* @author  Dustin Norman
* @since   05-16-2018
*/

public class InitializeThreadSafeVariables extends TestSetup{
	
	/**
	* 
	* <p>
	* STEPS:
	* <ul>
	* 	<li></li>
	* </ul>
	*/
	// Initialize thread safe variables
	public void initializeVariables()
	{
		
		System.out.println("Initialize thread safe variables");

		/*******************************************************************************************************
		*************************************************************************************
		* 		SETUP VARIABLES
		*************************************************************************************
		*******************************************************************************************************/

		ThreadLocal<String> userDir = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newuserDir = new StoredVariables(); newuserDir.setuserDir(userDir);
		
		ThreadLocal<String> downloadsDir = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newdownloadsDir = new StoredVariables(); newdownloadsDir.setdownloadsDir(downloadsDir);
		
		ThreadLocal<String> docDir = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newdocDir = new StoredVariables(); newdocDir.setdocDir(docDir);
		
		ThreadLocal<String> dirSlashes = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newdirSlashes = new StoredVariables(); newdirSlashes.setdirSlashes(dirSlashes);
		
		ThreadLocal<String> serverIP = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newserverIP = new StoredVariables(); newserverIP.setserverIP(serverIP);
		
		ThreadLocal<String> apiXMLFilesDir = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newapiXMLFilesDir = new StoredVariables(); newapiXMLFilesDir.setapiXMLFilesDir(apiXMLFilesDir);
		
		ThreadLocal<String> parallelParameter = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newparallelParameter = new StoredVariables(); newparallelParameter.setparallelParameter(parallelParameter);
		
		ThreadLocal<String> os = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newos = new StoredVariables(); newos.setos(os);
		
		ThreadLocal<String> timeStamp = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newtimeStamp = new StoredVariables(); newtimeStamp.settimeStamp(timeStamp);

		ThreadLocal<String> autoIT = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newautoIT = new StoredVariables(); newautoIT.setautoIT(autoIT);
		
		ThreadLocal<String> recordVideo = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newrecordVideo = new StoredVariables(); newrecordVideo.setrecordVideo(recordVideo);
		
		ThreadLocal<String> project = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newproject = new StoredVariables(); newproject.setproject(project);

		ThreadLocal<String> hubURL = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newhubURL = new StoredVariables(); newhubURL.sethubURL(hubURL);
		
		ThreadLocal<String> useLocalGrid = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newuseLocalGrid = new StoredVariables(); newuseLocalGrid.setuseLocalGrid(useLocalGrid);
		
		ThreadLocal<String> enableSnapshots = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newenableSnapshots = new StoredVariables(); newenableSnapshots.setenableSnapshots(enableSnapshots);
		
		ThreadLocal<Boolean> mobile = new InheritableThreadLocal<Boolean>() {@Override protected Boolean initialValue() {return false;}};
		StoredVariables newmobile = new StoredVariables(); newmobile.setmobile(mobile);
		
		ThreadLocal<String> debug = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newdebug = new StoredVariables(); newdebug.setdebug(debug);
		
		ThreadLocal<String> browser = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newbrowser = new StoredVariables(); newbrowser.setbrowser(browser);
		
		ThreadLocal<String> headless = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newheadless = new StoredVariables(); newheadless.setheadless(headless);
		
		ThreadLocal<String> browser2 = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newbrowser2 = new StoredVariables(); newbrowser2.setbrowser2(browser2);
		
		ThreadLocal<String> eyes = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables neweyes = new StoredVariables(); neweyes.seteyes(eyes);
		
		ThreadLocal<String> openReport = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newopenReport = new StoredVariables(); newopenReport.setopenReport(openReport);
		
		ThreadLocal<String> emulator = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newemulator = new StoredVariables(); newemulator.setemulator(emulator);
		
		ThreadLocal<String> version = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newversion = new StoredVariables(); newversion.setversion(version);
		
		ThreadLocal<String> environment = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newenvironment = new StoredVariables(); newenvironment.setenvironment(environment);
		
		ThreadLocal<String> usernameEnvironment = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newusernameEnvironment = new StoredVariables(); newusernameEnvironment.setusernameEnvironment(usernameEnvironment);
		
		ThreadLocal<String> vendorsSite = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newvendorsSite = new StoredVariables(); newvendorsSite.setvendorsSite(vendorsSite);
		
		ThreadLocal<String> secureSite = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newsecureSite = new StoredVariables(); newsecureSite.setsecureSite(secureSite);
		
		ThreadLocal<String> apiURL = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newapiURL = new StoredVariables(); newapiURL.setapiURL(apiURL);
		
		ThreadLocal<String> internalToolsSite = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newinternalToolsSite = new StoredVariables(); newinternalToolsSite.setinternalToolsSite(internalToolsSite);
		
		ThreadLocal<String> crmSite = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newcrmSite = new StoredVariables(); newcrmSite.setcrmSite(crmSite);
		
		ThreadLocal<String> ngsecureSite = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newngsecureSite = new StoredVariables(); newngsecureSite.setngsecureSite(ngsecureSite);

		ThreadLocal<String> vmpSiteSuffix = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newvmpSiteSuffix = new StoredVariables(); newvmpSiteSuffix.setvmpSiteSuffix(vmpSiteSuffix);
		
		ThreadLocal<String> dbName = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newdbName = new StoredVariables(); newdbName.setdbName(dbName);
		
		ThreadLocal<String> dbPort = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newdbPort = new StoredVariables(); newdbPort.setdbPort(dbPort);
		
		ThreadLocal<String> dbUser = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newdbUser = new StoredVariables(); newdbUser.setdbUser(dbUser);
		
		ThreadLocal<String> dbPW = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newdbPW = new StoredVariables(); newdbPW.setdbPW(dbPW);

		ThreadLocal<List<String>> results = new InheritableThreadLocal<List<String>>() {@Override protected List<String> initialValue() {return null;}};
		StoredVariables newresults = new StoredVariables(); newresults.setresults(results);
		
		ThreadLocal<String> dbUrl = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newdbUrl = new StoredVariables(); newdbUrl.setdbUrl(dbUrl);
		
		ThreadLocal<String> dbResults = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newdbResults = new StoredVariables(); newdbResults.setdbResults(dbResults);
		
		ThreadLocal<String> catchAllDomain = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newcatchAllDomain = new StoredVariables(); newcatchAllDomain.setcatchAllDomain(catchAllDomain);
		
		ThreadLocal<String> password = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newpassword = new StoredVariables(); newpassword.setpassword(password);
		
		ThreadLocal<String> userPhonePrefix = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newuserPhonePrefix = new StoredVariables(); newuserPhonePrefix.setuserPhonePrefix(userPhonePrefix);
		
		ThreadLocal<String> reportPath = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newreportPath = new StoredVariables(); newreportPath.setreportPath(reportPath);
		
		ThreadLocal<String> reportDir = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newreportDir = new StoredVariables(); newreportDir.setreportDir(reportDir);
		
		ThreadLocal<String> screenshotPath = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newscreenshotPath = new StoredVariables(); newscreenshotPath.setscreenshotPath(screenshotPath);
		
		ThreadLocal<String> screenshotImage = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newscreenshotImage = new StoredVariables(); newscreenshotImage.setscreenshotImage(screenshotImage);

		ThreadLocal<String> screenshotURL = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newscreenshotURL = new StoredVariables(); newscreenshotURL.setscreenshotURL(screenshotURL);
		
		ThreadLocal<String> extentReportPath = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newextentReportPath = new StoredVariables(); newextentReportPath.setextentReportPath(extentReportPath);
		
		ThreadLocal<String> extentReportURL = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newextentReportURL = new StoredVariables(); newextentReportURL.setextentReportURL(extentReportURL);

		ThreadLocal<Boolean> failedTest = new InheritableThreadLocal<Boolean>() {@Override protected Boolean initialValue() {return false;}};
		StoredVariables newfailedTest = new StoredVariables(); newfailedTest.setfailedTest(failedTest);

		ThreadLocal<String> IEDir = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newIEDir = new StoredVariables(); newIEDir.setIEDir(IEDir);
		
		ThreadLocal<String> baseURL = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newbaseURL = new StoredVariables(); newbaseURL.setbaseURL(baseURL);
		
		ThreadLocal<Integer> iteration = new InheritableThreadLocal<Integer>() {@Override protected Integer initialValue() {return null;}};
		StoredVariables newiteration = new StoredVariables(); newiteration.setiteration(iteration);
		
		ThreadLocal<String> newDateShort = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newnewDateShort = new StoredVariables(); newnewDateShort.setnewDateShort(newDateShort);

		ThreadLocal<String> newDateLong = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newnewDateLong = new StoredVariables(); newnewDateLong.setnewDateLong(newDateLong);
		
		/*******************************************************************************************************
		*************************************************************************************
		* 		NEW ORDER INFORMATION
		*************************************************************************************
		*******************************************************************************************************/
		
		ThreadLocal<String> orderDueDateShort = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables neworderDueDateShort = new StoredVariables(); neworderDueDateShort.setorderDueDateShort(orderDueDateShort);

		ThreadLocal<String> orderDueDateLong = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables neworderDueDateLong = new StoredVariables(); neworderDueDateLong.setorderDueDateLong(orderDueDateLong);

		ThreadLocal<String> disclosureDateShort = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newdisclosureDateShort = new StoredVariables(); newdisclosureDateShort.setdisclosureDateShort(disclosureDateShort);

		ThreadLocal<String> disclosureDateLong = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newdisclosureDateLong = new StoredVariables(); newdisclosureDateLong.setdisclosureDateLong(disclosureDateLong);

		ThreadLocal<String> propertyInformationAddress = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newpropertyInformationAddress = new StoredVariables(); newpropertyInformationAddress.setpropertyInformationAddress(propertyInformationAddress);

		ThreadLocal<String> propertyInformationCity = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newpropertyInformationCity = new StoredVariables(); newpropertyInformationCity.setpropertyInformationCity(propertyInformationCity);
		
		ThreadLocal<String> propertyInformationState = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newpropertyInformationState = new StoredVariables(); newpropertyInformationState.setpropertyInformationState(propertyInformationState);
		
		ThreadLocal<String> propertyInformationStateAbbr = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newpropertyInformationStateAbbr = new StoredVariables(); newpropertyInformationStateAbbr.setpropertyInformationStateAbbr(propertyInformationStateAbbr);

		ThreadLocal<String> propertyInformationZip = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newpropertyInformationZip = new StoredVariables(); newpropertyInformationZip.setpropertyInformationZip(propertyInformationZip);
		
		ThreadLocal<String> propertyInformationCounty = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newpropertyInformationCounty = new StoredVariables(); newpropertyInformationCounty.setpropertyInformationCounty(propertyInformationCounty);
		
		ThreadLocal<String> propertyInformationSqFt = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newpropertyInformationSqFt = new StoredVariables(); newpropertyInformationSqFt.setpropertyInformationSqFt(propertyInformationSqFt);

		ThreadLocal<String> propertyInformationSiteSize = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newpropertyInformationSiteSize = new StoredVariables(); newpropertyInformationSiteSize.setpropertyInformationSiteSize(propertyInformationSiteSize);

		ThreadLocal<String> propertyInformationPropType = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newpropertyInformationPropType = new StoredVariables(); newpropertyInformationPropType.setpropertyInformationPropType(propertyInformationPropType);
		
		ThreadLocal<String> propertyInformationPropRights = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newpropertyInformationPropRights = new StoredVariables(); newpropertyInformationPropRights.setpropertyInformationPropRights(propertyInformationPropRights);

		ThreadLocal<String> propertyInformationLegalDesc = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newpropertyInformationLegalDesc = new StoredVariables(); newpropertyInformationLegalDesc.setpropertyInformationLegalDesc(propertyInformationLegalDesc);

		ThreadLocal<String> propertyInformationDirections = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newpropertyInformationDirections = new StoredVariables(); newpropertyInformationDirections.setpropertyInformationDirections(propertyInformationDirections);

		ThreadLocal<String> assignmentInformationForm = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newassignmentInformationForm = new StoredVariables(); newassignmentInformationForm.setassignmentInformationForm(assignmentInformationForm);

		ThreadLocal<Boolean> assignmentInformationRushOrder = new InheritableThreadLocal<Boolean>() {@Override protected Boolean initialValue() {return false;}};
		StoredVariables newassignmentInformationRushOrder = new StoredVariables(); newassignmentInformationRushOrder.setassignmentInformationRushOrder(assignmentInformationRushOrder);

		ThreadLocal<Boolean> assignmentInformationComplex = new InheritableThreadLocal<Boolean>() {@Override protected Boolean initialValue() {return false;}};
		StoredVariables newassignmentInformationComplex = new StoredVariables(); newassignmentInformationComplex.setassignmentInformationComplex(assignmentInformationComplex);
		
		ThreadLocal<Boolean> assignmentInformationIssueAsBid = new InheritableThreadLocal<Boolean>() {@Override protected Boolean initialValue() {return false;}};
		StoredVariables newassignmentInformationIssueAsBid = new StoredVariables(); newassignmentInformationIssueAsBid.setassignmentInformationIssueAsBid(assignmentInformationIssueAsBid);

		ThreadLocal<Integer> assignmentInformationOrderDue = new InheritableThreadLocal<Integer>() {@Override protected Integer initialValue() {return null;}};
		StoredVariables newassignmentInformationOrderDue = new StoredVariables(); newassignmentInformationOrderDue.setassignmentInformationOrderDue(assignmentInformationOrderDue);

		ThreadLocal<String> assignmentInformationOtherRefNumber = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newassignmentInformationOtherRefNumber = new StoredVariables(); newassignmentInformationOtherRefNumber.setassignmentInformationOtherRefNumber(assignmentInformationOtherRefNumber);

		ThreadLocal<String> assignmentInformationLoanType = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newassignmentInformationLoanType = new StoredVariables(); newassignmentInformationLoanType.setassignmentInformationLoanType(assignmentInformationLoanType);
		
		ThreadLocal<String> assignmentInformationLoanPurpose = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newassignmentInformationLoanPurpose = new StoredVariables(); newassignmentInformationLoanPurpose.setassignmentInformationLoanPurpose(assignmentInformationLoanPurpose);
		
		ThreadLocal<String> assignmentInformationOrderedBy = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newassignmentInformationOrderedBy = new StoredVariables(); newassignmentInformationOrderedBy.setassignmentInformationOrderedBy(assignmentInformationOrderedBy);
		
		ThreadLocal<String> assignmentInformationOrderGroup = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newassignmentInformationOrderGroup = new StoredVariables(); newassignmentInformationOrderGroup.setassignmentInformationOrderGroup(assignmentInformationOrderGroup);
		
		ThreadLocal<String> assignmentInformationAccountExec = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newassignmentInformationAccountExec = new StoredVariables(); newassignmentInformationAccountExec.setassignmentInformationAccountExec(assignmentInformationAccountExec);
		
		ThreadLocal<String> assignmentInformationLoanNumber = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newassignmentInformationLoanNumber = new StoredVariables(); newassignmentInformationLoanNumber.setassignmentInformationLoanNumber(assignmentInformationLoanNumber);
		
		ThreadLocal<String> assignmentInformationFileNumber = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newassignmentInformationFileNumber = new StoredVariables(); newassignmentInformationFileNumber.setassignmentInformationFileNumber(assignmentInformationFileNumber);
		
		ThreadLocal<String> assignmentInformationSalesPrice = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newassignmentInformationSalesPrice = new StoredVariables(); newassignmentInformationSalesPrice.setassignmentInformationSalesPrice(assignmentInformationSalesPrice);
		
		ThreadLocal<String> assignmentInformationFHACaseNumber = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newassignmentInformationFHACaseNumber = new StoredVariables(); newassignmentInformationFHACaseNumber.setassignmentInformationFHACaseNumber(assignmentInformationFHACaseNumber);

		ThreadLocal<Integer> assignmentInformationDisclosure = new InheritableThreadLocal<Integer>() {@Override protected Integer initialValue() {return null;}};
		StoredVariables newassignmentInformationDisclosure = new StoredVariables(); newassignmentInformationDisclosure.setassignmentInformationDisclosure(assignmentInformationDisclosure);
		
		ThreadLocal<Boolean> skipDisclosureDate = new InheritableThreadLocal<Boolean>() {@Override protected Boolean initialValue() {return false;}};
		StoredVariables newskipDisclosureDate = new StoredVariables(); newskipDisclosureDate.setskipDisclosureDate(skipDisclosureDate);
		
		ThreadLocal<String> assignmentInformationAssignedTo = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newassignmentInformationAssignedTo = new StoredVariables(); newassignmentInformationAssignedTo.setassignmentInformationAssignedTo(assignmentInformationAssignedTo);
		
		ThreadLocal<String> lenderInformationLenderName = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newlenderInformationLenderName = new StoredVariables(); newlenderInformationLenderName.setlenderInformationLenderName(lenderInformationLenderName);
		
		ThreadLocal<String> lenderInformationAddress1 = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newlenderInformationAddress1 = new StoredVariables(); newlenderInformationAddress1.setlenderInformationAddress1(lenderInformationAddress1);
		
		ThreadLocal<String> lenderInformationAddress2 = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newlenderInformationAddress2 = new StoredVariables(); newlenderInformationAddress2.setlenderInformationAddress2(lenderInformationAddress2);

		ThreadLocal<String> lenderInformationCity = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newlenderInformationCity = new StoredVariables(); newlenderInformationCity.setlenderInformationCity(lenderInformationCity);

		ThreadLocal<String> lenderInformationState = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newlenderInformationState = new StoredVariables(); newlenderInformationState.setlenderInformationState(lenderInformationState);

		ThreadLocal<String> lenderInformationZip = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newlenderInformationZip = new StoredVariables(); newlenderInformationZip.setlenderInformationZip(lenderInformationZip);
		
		ThreadLocal<String> contactOccupancy = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newcontactOccupancy = new StoredVariables(); newcontactOccupancy.setcontactOccupancy(contactOccupancy);
		
		ThreadLocal<String> contactBorrower = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newcontactBorrower = new StoredVariables(); newcontactBorrower.setcontactBorrower(contactBorrower);
		
		ThreadLocal<String> contactBorrowerInfo1Dropdown = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newcontactBorrowerInfo1Dropdown = new StoredVariables(); newcontactBorrowerInfo1Dropdown.setcontactBorrowerInfo1Dropdown(contactBorrowerInfo1Dropdown);
		
		ThreadLocal<String> contactBorrowerInfo1 = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newcontactBorrowerInfo1 = new StoredVariables(); newcontactBorrowerInfo1.setcontactBorrowerInfo1(contactBorrowerInfo1);

		ThreadLocal<String> contactBorrowerInfo2Dropdown = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newcontactBorrowerInfo2Dropdown = new StoredVariables(); newcontactBorrowerInfo2Dropdown.setcontactBorrowerInfo2Dropdown(contactBorrowerInfo2Dropdown);

		ThreadLocal<String> contactBorrowerInfo2 = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newcontactBorrowerInfo2 = new StoredVariables(); newcontactBorrowerInfo2.setcontactBorrowerInfo2(contactBorrowerInfo2);
		
		ThreadLocal<String> contactBorrowerAddress = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newcontactBorrowerAddress = new StoredVariables(); newcontactBorrowerAddress.setcontactBorrowerAddress(contactBorrowerAddress);

		ThreadLocal<String> contactBorrowerCity = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newcontactBorrowerCity = new StoredVariables(); newcontactBorrowerCity.setcontactBorrowerCity(contactBorrowerCity);

		ThreadLocal<String> contactBorrowerState = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newcontactBorrowerState = new StoredVariables(); newcontactBorrowerState.setcontactBorrowerState(contactBorrowerState);

		ThreadLocal<String> contactBorrowerZip = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newcontactBorrowerZip = new StoredVariables(); newcontactBorrowerZip.setcontactBorrowerZip(contactBorrowerZip);

		ThreadLocal<String> contactCoBorrower = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newcontactCoBorrower = new StoredVariables(); newcontactCoBorrower.setcontactCoBorrower(contactCoBorrower);
		
		ThreadLocal<String> contactCoBorrowerInfo1Dropdown = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newcontactCoBorrowerInfo1Dropdown = new StoredVariables(); newcontactCoBorrowerInfo1Dropdown.setcontactCoBorrowerInfo1Dropdown(contactCoBorrowerInfo1Dropdown);

		ThreadLocal<String> contactCoBorrowerInfo1 = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newcontactCoBorrowerInfo1 = new StoredVariables(); newcontactCoBorrowerInfo1.setcontactCoBorrowerInfo1(contactCoBorrowerInfo1);

		ThreadLocal<String> contactCoBorrowerInfo2Dropdown = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newcontactCoBorrowerInfo2Dropdown = new StoredVariables(); newcontactCoBorrowerInfo2Dropdown.setcontactCoBorrowerInfo2Dropdown(contactCoBorrowerInfo2Dropdown);

		ThreadLocal<String> contactCoBorrowerInfo2 = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newcontactCoBorrowerInfo2 = new StoredVariables(); newcontactCoBorrowerInfo2.setcontactCoBorrowerInfo2(contactCoBorrowerInfo2);
		
		ThreadLocal<String> contactCoBorrowerAddress = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newcontactCoBorrowerAddress = new StoredVariables(); newcontactCoBorrowerAddress.setcontactCoBorrowerAddress(contactCoBorrowerAddress);

		ThreadLocal<String> contactCoBorrowerCity = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newcontactCoBorrowerCity = new StoredVariables(); newcontactCoBorrowerCity.setcontactCoBorrowerCity(contactCoBorrowerCity);

		ThreadLocal<String> contactCoBorrowerState = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newcontactCoBorrowerState = new StoredVariables(); newcontactCoBorrowerState.setcontactCoBorrowerState(contactCoBorrowerState);

		ThreadLocal<String> contactCoBorrowerZip = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newcontactCoBorrowerZip = new StoredVariables(); newcontactCoBorrowerZip.setcontactCoBorrowerZip(contactCoBorrowerZip);
		
		ThreadLocal<String> contactOwner = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newcontactOwner = new StoredVariables(); newcontactOwner.setcontactOwner(contactOwner);
		
		ThreadLocal<String> contactOwnerInfo1Dropdown = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newcontactOwnerInfo1Dropdown = new StoredVariables(); newcontactOwnerInfo1Dropdown.setcontactOwnerInfo1Dropdown(contactOwnerInfo1Dropdown);

		ThreadLocal<String> contactOwnerInfo1 = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newcontactOwnerInfo1 = new StoredVariables(); newcontactOwnerInfo1.setcontactOwnerInfo1(contactOwnerInfo1);

		ThreadLocal<String> contactOwnerInfo2Dropdown = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newcontactOwnerInfo2Dropdown = new StoredVariables(); newcontactOwnerInfo2Dropdown.setcontactOwnerInfo2Dropdown(contactOwnerInfo2Dropdown);
		
		ThreadLocal<String> contactOwnerInfo2 = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newcontactOwnerInfo2 = new StoredVariables(); newcontactOwnerInfo2.setcontactOwnerInfo2(contactOwnerInfo2);
		
		ThreadLocal<String> contactOccupant = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newcontactOccupant = new StoredVariables(); newcontactOccupant.setcontactOccupant(contactOccupant);

		ThreadLocal<String> contactOccupantInfo1Dropdown = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newcontactOccupantInfo1Dropdown = new StoredVariables(); newcontactOccupantInfo1Dropdown.setcontactOccupantInfo1Dropdown(contactOccupantInfo1Dropdown);
		
		ThreadLocal<String> contactOccupantInfo1 = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newcontactOccupantInfo1 = new StoredVariables(); newcontactOccupantInfo1.setcontactOccupantInfo1(contactOccupantInfo1);
		
		ThreadLocal<String> contactOccupantInfo2Dropdown = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newcontactOccupantInfo2Dropdown = new StoredVariables(); newcontactOccupantInfo2Dropdown.setcontactOccupantInfo2Dropdown(contactOccupantInfo2Dropdown);
		
		ThreadLocal<String> contactOccupantInfo2 = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newcontactOccupantInfo2 = new StoredVariables(); newcontactOccupantInfo2.setcontactOccupantInfo2(contactOccupantInfo2);
		
		ThreadLocal<String> contactAgent = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newcontactAgent = new StoredVariables(); newcontactAgent.setcontactAgent(contactAgent);

		ThreadLocal<String> contactAgentInfo1Dropdown = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newcontactAgentInfo1Dropdown = new StoredVariables(); newcontactAgentInfo1Dropdown.setcontactAgentInfo1Dropdown(contactAgentInfo1Dropdown);
		
		ThreadLocal<String> contactAgentInfo1 = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newcontactAgentInfo1 = new StoredVariables(); newcontactAgentInfo1.setcontactAgentInfo1(contactAgentInfo1);

		ThreadLocal<String> contactAgentInfo2Dropdown = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newcontactAgentInfo2Dropdown = new StoredVariables(); newcontactAgentInfo2Dropdown.setcontactAgentInfo2Dropdown(contactAgentInfo2Dropdown);
		
		ThreadLocal<String> contactAgentInfo2 = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newcontactAgentInfo2 = new StoredVariables(); newcontactAgentInfo2.setcontactAgentInfo2(contactAgentInfo2);
		
		ThreadLocal<String> contactOther = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newcontactOther = new StoredVariables(); newcontactOther.setcontactOther(contactOther);
		
		ThreadLocal<String> contactOtherInfo1Dropdown = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newcontactOtherInfo1Dropdown = new StoredVariables(); newcontactOtherInfo1Dropdown.setcontactOtherInfo1Dropdown(contactOtherInfo1Dropdown);
		
		ThreadLocal<String> contactOtherInfo1 = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newcontactOtherInfo1 = new StoredVariables(); newcontactOtherInfo1.setcontactOtherInfo1(contactOtherInfo1);

		ThreadLocal<String> contactOtherInfo2Dropdown = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newcontactOtherInfo2Dropdown = new StoredVariables(); newcontactOtherInfo2Dropdown.setcontactOtherInfo2Dropdown(contactOtherInfo2Dropdown);

		ThreadLocal<String> contactOtherInfo2 = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newcontactOtherInfo2 = new StoredVariables(); newcontactOtherInfo2.setcontactOtherInfo2(contactOtherInfo2);

		ThreadLocal<String> contactApptContact = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newcontactApptContact = new StoredVariables(); newcontactApptContact.setcontactApptContact(contactApptContact);

		ThreadLocal<String> additionalNotificationRecipientsAdditionalEmails = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newadditionalNotificationRecipientsAdditionalEmails = new StoredVariables(); newadditionalNotificationRecipientsAdditionalEmails.setadditionalNotificationRecipientsAdditionalEmails(additionalNotificationRecipientsAdditionalEmails);
		
		ThreadLocal<Boolean> additionalNotificationRecipientsAttachCompletedReport = new InheritableThreadLocal<Boolean>() {@Override protected Boolean initialValue() {return false;}};
		StoredVariables newadditionalNotificationRecipientsAttachCompletedReport = new StoredVariables(); newadditionalNotificationRecipientsAttachCompletedReport.setadditionalNotificationRecipientsAttachCompletedReport(additionalNotificationRecipientsAttachCompletedReport);

		ThreadLocal<String> additionalComments = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newadditionalComments = new StoredVariables(); newadditionalComments.setadditionalComments(additionalComments);
		
		ThreadLocal<String> productRequirements = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newproductRequirements = new StoredVariables(); newproductRequirements.setproductRequirements(productRequirements);
		
		/*******************************************************************************************************
		*************************************************************************************
		* 		DATABASE VARIABLES
		*************************************************************************************
		*******************************************************************************************************/
		
		ThreadLocal<String> DBorderDueDateShort = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBorderDueDateShort = new StoredVariables(); newDBorderDueDateShort.setDBorderDueDateShort(DBorderDueDateShort);
		
		ThreadLocal<String> DBorderDueDateLong = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBorderDueDateLong = new StoredVariables(); newDBorderDueDateLong.setDBorderDueDateLong(DBorderDueDateLong);
		
		ThreadLocal<String> DBdisclosureDateShort = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBdisclosureDateShort = new StoredVariables(); newDBdisclosureDateShort.setDBdisclosureDateShort(DBdisclosureDateShort);
		
		ThreadLocal<String> DBdisclosureDateLong = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBdisclosureDateLong = new StoredVariables(); newDBdisclosureDateLong.setDBdisclosureDateLong(DBdisclosureDateLong);
		
		ThreadLocal<String> DBpropertyInformationAddress = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBpropertyInformationAddress = new StoredVariables(); newDBpropertyInformationAddress.setDBpropertyInformationAddress(DBpropertyInformationAddress);
		
		ThreadLocal<String> DBpropertyInformationCity = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBpropertyInformationCity = new StoredVariables(); newDBpropertyInformationCity.setDBpropertyInformationCity(DBpropertyInformationCity);
		
		ThreadLocal<String> DBpropertyInformationState = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBpropertyInformationState = new StoredVariables(); newDBpropertyInformationState.setDBpropertyInformationState(DBpropertyInformationState);
		
		ThreadLocal<String> DBpropertyInformationStateAbbr = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBpropertyInformationStateAbbr = new StoredVariables(); newDBpropertyInformationStateAbbr.setDBpropertyInformationStateAbbr(DBpropertyInformationStateAbbr);
		
		ThreadLocal<String> DBpropertyInformationZip = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBpropertyInformationZip = new StoredVariables(); newDBpropertyInformationZip.setDBpropertyInformationZip(DBpropertyInformationZip);
		
		ThreadLocal<String> DBpropertyInformationSqFt = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBpropertyInformationSqFt = new StoredVariables(); newDBpropertyInformationSqFt.setDBpropertyInformationSqFt(DBpropertyInformationSqFt);
		
		ThreadLocal<String> DBpropertyInformationSiteSize = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBpropertyInformationSiteSize = new StoredVariables(); newDBpropertyInformationSiteSize.setDBpropertyInformationSiteSize(DBpropertyInformationSiteSize);
		
		ThreadLocal<String> DBpropertyInformationPropType = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBpropertyInformationPropType = new StoredVariables(); newDBpropertyInformationPropType.setDBpropertyInformationPropType(DBpropertyInformationPropType);
		
		ThreadLocal<String> DBpropertyInformationPropRights = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBpropertyInformationPropRights = new StoredVariables(); newDBpropertyInformationPropRights.setDBpropertyInformationPropRights(DBpropertyInformationPropRights);
		
		ThreadLocal<String> DBpropertyInformationLegalDesc = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBpropertyInformationLegalDesc = new StoredVariables(); newDBpropertyInformationLegalDesc.setDBpropertyInformationLegalDesc(DBpropertyInformationLegalDesc);
		
		ThreadLocal<String> DBpropertyInformationDirections = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBpropertyInformationDirections = new StoredVariables(); newDBpropertyInformationDirections.setDBpropertyInformationDirections(DBpropertyInformationDirections);
		
		ThreadLocal<String> DBassignmentInformationForm = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBassignmentInformationForm = new StoredVariables(); newDBassignmentInformationForm.setDBassignmentInformationForm(DBassignmentInformationForm);
		
		ThreadLocal<Boolean> DBassignmentInformationRushOrder = new InheritableThreadLocal<Boolean>() {@Override protected Boolean initialValue() {return false;}};
		StoredVariables newDBassignmentInformationRushOrder = new StoredVariables(); newDBassignmentInformationRushOrder.setDBassignmentInformationRushOrder(DBassignmentInformationRushOrder);
		
		ThreadLocal<Boolean> DBassignmentInformationComplex = new InheritableThreadLocal<Boolean>() {@Override protected Boolean initialValue() {return false;}};
		StoredVariables newDBassignmentInformationComplex = new StoredVariables(); newDBassignmentInformationComplex.setDBassignmentInformationComplex(DBassignmentInformationComplex);
		
		ThreadLocal<String> DBassignmentInformationOrderDue = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBassignmentInformationOrderDue = new StoredVariables(); newDBassignmentInformationOrderDue.setDBassignmentInformationOrderDue(DBassignmentInformationOrderDue);
		
		ThreadLocal<String> DBassignmentInformationOtherRefNumber = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBassignmentInformationOtherRefNumber = new StoredVariables(); newDBassignmentInformationOtherRefNumber.setDBassignmentInformationOtherRefNumber(DBassignmentInformationOtherRefNumber);
		
		ThreadLocal<String> DBassignmentInformationLoanType = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBassignmentInformationLoanType = new StoredVariables(); newDBassignmentInformationLoanType.setDBassignmentInformationLoanType(DBassignmentInformationLoanType);
		
		ThreadLocal<String> DBassignmentInformationLoanPurpose = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBassignmentInformationLoanPurpose = new StoredVariables(); newDBassignmentInformationLoanPurpose.setDBassignmentInformationLoanPurpose(DBassignmentInformationLoanPurpose);
		
		ThreadLocal<String> DBassignmentInformationOrderedBy = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBassignmentInformationOrderedBy = new StoredVariables(); newDBassignmentInformationOrderedBy.setDBassignmentInformationOrderedBy(DBassignmentInformationOrderedBy);
		
		ThreadLocal<String> DBassignmentInformationOrderGroup = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBassignmentInformationOrderGroup = new StoredVariables(); newDBassignmentInformationOrderGroup.setDBassignmentInformationOrderGroup(DBassignmentInformationOrderGroup);
		
		ThreadLocal<String> DBassignmentInformationLoanNumber = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBassignmentInformationLoanNumber = new StoredVariables(); newDBassignmentInformationLoanNumber.setDBassignmentInformationLoanNumber(DBassignmentInformationLoanNumber);
		
		ThreadLocal<String> DBassignmentInformationFileNumber = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBassignmentInformationFileNumber = new StoredVariables(); newDBassignmentInformationFileNumber.setDBassignmentInformationFileNumber(DBassignmentInformationFileNumber);
		
		ThreadLocal<String> DBassignmentInformationSalesPrice = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBassignmentInformationSalesPrice = new StoredVariables(); newDBassignmentInformationSalesPrice.setDBassignmentInformationSalesPrice(DBassignmentInformationSalesPrice);
		
		ThreadLocal<String> DBassignmentInformationFHACaseNumber = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBassignmentInformationFHACaseNumber = new StoredVariables(); newDBassignmentInformationFHACaseNumber.setDBassignmentInformationFHACaseNumber(DBassignmentInformationFHACaseNumber);
		
		ThreadLocal<String> DBassignmentInformationDisclosure = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBassignmentInformationDisclosure = new StoredVariables(); newDBassignmentInformationDisclosure.setDBassignmentInformationDisclosure(DBassignmentInformationDisclosure);
		
		ThreadLocal<String> DBassignmentInformationAssignedTo = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBassignmentInformationAssignedTo = new StoredVariables(); newDBassignmentInformationAssignedTo.setDBassignmentInformationAssignedTo(DBassignmentInformationAssignedTo);
		
		ThreadLocal<String> DBassignmentInformationRushOrderDB = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBassignmentInformationRushOrderDB = new StoredVariables(); newDBassignmentInformationRushOrderDB.setDBassignmentInformationRushOrderDB(DBassignmentInformationRushOrderDB);

		ThreadLocal<String> DBassignmentInformationComplexDB = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBassignmentInformationComplexDB = new StoredVariables(); newDBassignmentInformationComplexDB.setDBassignmentInformationComplexDB(DBassignmentInformationComplexDB);

		ThreadLocal<String> DBlenderInformationLenderName = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBlenderInformationLenderName = new StoredVariables(); newDBlenderInformationLenderName.setDBlenderInformationLenderName(DBlenderInformationLenderName);
		
		ThreadLocal<String> DBlenderInformationAddress1 = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBlenderInformationAddress1 = new StoredVariables(); newDBlenderInformationAddress1.setDBlenderInformationAddress1(DBlenderInformationAddress1);
		
		ThreadLocal<String> DBlenderInformationAddress2 = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBlenderInformationAddress2 = new StoredVariables(); newDBlenderInformationAddress2.setDBlenderInformationAddress2(DBlenderInformationAddress2);
		
		ThreadLocal<String> DBlenderInformationCity = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBlenderInformationCity = new StoredVariables(); newDBlenderInformationCity.setDBlenderInformationCity(DBlenderInformationCity);
		
		ThreadLocal<String> DBlenderInformationState = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBlenderInformationState = new StoredVariables(); newDBlenderInformationState.setDBlenderInformationState(DBlenderInformationState);
		
		ThreadLocal<String> DBlenderInformationZip = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBlenderInformationZip = new StoredVariables(); newDBlenderInformationZip.setDBlenderInformationZip(DBlenderInformationZip);
		
		ThreadLocal<String> DBcontactOccupancy = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBcontactOccupancy = new StoredVariables(); newDBcontactOccupancy.setDBcontactOccupancy(DBcontactOccupancy);
		
		ThreadLocal<String> DBcontactBorrower = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBcontactBorrower = new StoredVariables(); newDBcontactBorrower.setDBcontactBorrower(DBcontactBorrower);
		
		ThreadLocal<String> DBcontactBorrowerInfo1Dropdown = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBcontactBorrowerInfo1Dropdown = new StoredVariables(); newDBcontactBorrowerInfo1Dropdown.setDBcontactBorrowerInfo1Dropdown(DBcontactBorrowerInfo1Dropdown);
		
		ThreadLocal<String> DBcontactBorrowerInfo1 = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBcontactBorrowerInfo1 = new StoredVariables(); newDBcontactBorrowerInfo1.setDBcontactBorrowerInfo1(DBcontactBorrowerInfo1);

		ThreadLocal<String> DBcontactBorrowerInfo2Dropdown = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBcontactBorrowerInfo2Dropdown = new StoredVariables(); newDBcontactBorrowerInfo2Dropdown.setDBcontactBorrowerInfo2Dropdown(DBcontactBorrowerInfo2Dropdown);
		
		ThreadLocal<String> DBcontactBorrowerInfo2 = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBcontactBorrowerInfo2 = new StoredVariables(); newDBcontactBorrowerInfo2.setDBcontactBorrowerInfo2(DBcontactBorrowerInfo2);
		
		ThreadLocal<String> DBcontactBorrowerAddress = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBcontactBorrowerAddress = new StoredVariables(); newDBcontactBorrowerAddress.setDBcontactBorrowerAddress(DBcontactBorrowerAddress);
		
		ThreadLocal<String> DBcontactBorrowerCity = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBcontactBorrowerCity = new StoredVariables(); newDBcontactBorrowerCity.setDBcontactBorrowerCity(DBcontactBorrowerCity);
		
		ThreadLocal<String> DBcontactBorrowerState = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBcontactBorrowerState = new StoredVariables(); newDBcontactBorrowerState.setDBcontactBorrowerState(DBcontactBorrowerState);
		
		ThreadLocal<String> DBcontactBorrowerZip = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBcontactBorrowerZip = new StoredVariables(); newDBcontactBorrowerZip.setDBcontactBorrowerZip(DBcontactBorrowerZip);
		
		ThreadLocal<String> DBcontactCoBorrower = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBcontactCoBorrower = new StoredVariables(); newDBcontactCoBorrower.setDBcontactCoBorrower(DBcontactCoBorrower);
		
		ThreadLocal<String> DBcontactCoBorrowerInfo1Dropdown = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBcontactCoBorrowerInfo1Dropdown = new StoredVariables(); newDBcontactCoBorrowerInfo1Dropdown.setDBcontactCoBorrowerInfo1Dropdown(DBcontactCoBorrowerInfo1Dropdown);
		
		ThreadLocal<String> DBcontactCoBorrowerInfo1 = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBcontactCoBorrowerInfo1 = new StoredVariables(); newDBcontactCoBorrowerInfo1.setDBcontactCoBorrowerInfo1(DBcontactCoBorrowerInfo1);
		
		ThreadLocal<String> DBcontactCoBorrowerInfo2Dropdown = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBcontactCoBorrowerInfo2Dropdown = new StoredVariables(); newDBcontactCoBorrowerInfo2Dropdown.setDBcontactCoBorrowerInfo2Dropdown(DBcontactCoBorrowerInfo2Dropdown);
		
		ThreadLocal<String> DBcontactCoBorrowerInfo2 = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBcontactCoBorrowerInfo2 = new StoredVariables(); newDBcontactCoBorrowerInfo2.setDBcontactCoBorrowerInfo2(DBcontactCoBorrowerInfo2);
		
		ThreadLocal<String> DBcontactCoBorrowerAddress = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBcontactCoBorrowerAddress = new StoredVariables(); newDBcontactCoBorrowerAddress.setDBcontactCoBorrowerAddress(DBcontactCoBorrowerAddress);
		
		ThreadLocal<String> DBcontactCoBorrowerCity = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBcontactCoBorrowerCity = new StoredVariables(); newDBcontactCoBorrowerCity.setDBcontactCoBorrowerCity(DBcontactCoBorrowerCity);
		
		ThreadLocal<String> DBcontactCoBorrowerState = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBcontactCoBorrowerState = new StoredVariables(); newDBcontactCoBorrowerState.setDBcontactCoBorrowerState(DBcontactCoBorrowerState);
		
		ThreadLocal<String> DBcontactCoBorrowerZip = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBcontactCoBorrowerZip = new StoredVariables(); newDBcontactCoBorrowerZip.setDBcontactCoBorrowerZip(DBcontactCoBorrowerZip);
		
		ThreadLocal<String> DBcontactOwner = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBcontactOwner = new StoredVariables(); newDBcontactOwner.setDBcontactOwner(DBcontactOwner);
		
		ThreadLocal<String> DBcontactOwnerInfo1Dropdown = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBcontactOwnerInfo1Dropdown = new StoredVariables(); newDBcontactOwnerInfo1Dropdown.setDBcontactOwnerInfo1Dropdown(DBcontactOwnerInfo1Dropdown);
		
		ThreadLocal<String> DBcontactOwnerInfo1 = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBcontactOwnerInfo1 = new StoredVariables(); newDBcontactOwnerInfo1.setDBcontactOwnerInfo1(DBcontactOwnerInfo1);
		
		ThreadLocal<String> DBcontactOwnerInfo2Dropdown = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBcontactOwnerInfo2Dropdown = new StoredVariables(); newDBcontactOwnerInfo2Dropdown.setDBcontactOwnerInfo2Dropdown(DBcontactOwnerInfo2Dropdown);
		
		ThreadLocal<String> DBcontactOwnerInfo2 = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBcontactOwnerInfo2 = new StoredVariables(); newDBcontactOwnerInfo2.setDBcontactOwnerInfo2(DBcontactOwnerInfo2);
		
		ThreadLocal<String> DBcontactOccupant = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBcontactOccupant = new StoredVariables(); newDBcontactOccupant.setDBcontactOccupant(DBcontactOccupant);
		
		ThreadLocal<String> DBcontactOccupantInfo1Dropdown = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBcontactOccupantInfo1Dropdown = new StoredVariables(); newDBcontactOccupantInfo1Dropdown.setDBcontactOccupantInfo1Dropdown(DBcontactOccupantInfo1Dropdown);
		
		ThreadLocal<String> DBcontactOccupantInfo1 = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBcontactOccupantInfo1 = new StoredVariables(); newDBcontactOccupantInfo1.setDBcontactOccupantInfo1(DBcontactOccupantInfo1);
		
		ThreadLocal<String> DBcontactOccupantInfo2Dropdown = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBcontactOccupantInfo2Dropdown = new StoredVariables(); newDBcontactOccupantInfo2Dropdown.setDBcontactOccupantInfo2Dropdown(DBcontactOccupantInfo2Dropdown);
		
		ThreadLocal<String> DBcontactOccupantInfo2 = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBcontactOccupantInfo2 = new StoredVariables(); newDBcontactOccupantInfo2.setDBcontactOccupantInfo2(DBcontactOccupantInfo2);
		
		ThreadLocal<String> DBcontactAgent = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBcontactAgent = new StoredVariables(); newDBcontactAgent.setDBcontactAgent(DBcontactAgent);
		
		ThreadLocal<String> DBcontactAgentInfo1Dropdown = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBcontactAgentInfo1Dropdown = new StoredVariables(); newDBcontactAgentInfo1Dropdown.setDBcontactAgentInfo1Dropdown(DBcontactAgentInfo1Dropdown);
		
		ThreadLocal<String> DBcontactAgentInfo1 = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBcontactAgentInfo1 = new StoredVariables(); newDBcontactAgentInfo1.setDBcontactAgentInfo1(DBcontactAgentInfo1);
		
		ThreadLocal<String> DBcontactAgentInfo2Dropdown = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBcontactAgentInfo2Dropdown = new StoredVariables(); newDBcontactAgentInfo2Dropdown.setDBcontactAgentInfo2Dropdown(DBcontactAgentInfo2Dropdown);
		
		ThreadLocal<String> DBcontactAgentInfo2 = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBcontactAgentInfo2 = new StoredVariables(); newDBcontactAgentInfo2.setDBcontactAgentInfo2(DBcontactAgentInfo2);
		
		ThreadLocal<String> DBcontactOther = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBcontactOther = new StoredVariables(); newDBcontactOther.setDBcontactOther(DBcontactOther);
		
		ThreadLocal<String> DBcontactOtherInfo1Dropdown = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBcontactOtherInfo1Dropdown = new StoredVariables(); newDBcontactOtherInfo1Dropdown.setDBcontactOtherInfo1Dropdown(DBcontactOtherInfo1Dropdown);
		
		ThreadLocal<String> DBcontactOtherInfo1 = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBcontactOtherInfo1 = new StoredVariables(); newDBcontactOtherInfo1.setDBcontactOtherInfo1(DBcontactOtherInfo1);
		
		ThreadLocal<String> DBcontactOtherInfo2Dropdown = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBcontactOtherInfo2Dropdown = new StoredVariables(); newDBcontactOtherInfo2Dropdown.setDBcontactOtherInfo2Dropdown(DBcontactOtherInfo2Dropdown);
		
		ThreadLocal<String> DBcontactOtherInfo2 = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBcontactOtherInfo2 = new StoredVariables(); newDBcontactOtherInfo2.setDBcontactOtherInfo2(DBcontactOtherInfo2);
		
		ThreadLocal<String> DBcontactApptContact = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBcontactApptContact = new StoredVariables(); newDBcontactApptContact.setDBcontactApptContact(DBcontactApptContact);
		
		ThreadLocal<String> DBadditionalNotificationRecipientsAdditionalEmails = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newDBadditionalNotificationRecipientsAdditionalEmails = new StoredVariables(); newDBadditionalNotificationRecipientsAdditionalEmails.setDBadditionalNotificationRecipientsAdditionalEmails(DBadditionalNotificationRecipientsAdditionalEmails);
		
		ThreadLocal<Boolean> DBadditionalNotificationRecipientsAttachCompletedReport = new InheritableThreadLocal<Boolean>() {@Override protected Boolean initialValue() {return false;}};
		StoredVariables newDBadditionalNotificationRecipientsAttachCompletedReport = new StoredVariables(); newDBadditionalNotificationRecipientsAttachCompletedReport.setDBadditionalNotificationRecipientsAttachCompletedReport(DBadditionalNotificationRecipientsAttachCompletedReport);

		/*******************************************************************************************************
		*************************************************************************************
		* 		OTHER VARIABLES
		*************************************************************************************
		*******************************************************************************************************/
		
		ThreadLocal<String> directionsIdentifier = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newdirectionsIdentifier = new StoredVariables(); newdirectionsIdentifier.setdirectionsIdentifier(directionsIdentifier);
		
		ThreadLocal<String> borrowerIdentifier = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newborrowerIdentifier = new StoredVariables(); newborrowerIdentifier.setborrowerIdentifier(borrowerIdentifier);

		ThreadLocal<String> todaysDateLong = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newtodaysDateLong = new StoredVariables(); newtodaysDateLong.settodaysDateLong(todaysDateLong);

		ThreadLocal<String> todaysDateShort = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newtodaysDateShort = new StoredVariables(); newtodaysDateShort.settodaysDateShort(todaysDateShort);
		
		ThreadLocal<String> newDay = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newnewDay = new StoredVariables(); newnewDay.setnewDay(newDay);
		
		ThreadLocal<String> newDay2 = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newnewDay2 = new StoredVariables(); newnewDay2.setnewDay2(newDay2);
		
		ThreadLocal<String> newMonth = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newnewMonth = new StoredVariables(); newnewMonth.setnewMonth(newMonth);
		
		ThreadLocal<String> newMonth2 = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newnewMonth2 = new StoredVariables(); newnewMonth2.setnewMonth2(newMonth2);
		
		ThreadLocal<String> newYear = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newnewYear = new StoredVariables(); newnewYear.setnewYear(newYear);
		
		ThreadLocal<String> currentMonth = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newcurrentMonth = new StoredVariables(); newcurrentMonth.setcurrentMonth(currentMonth);
		
		ThreadLocal<String> trackingNumber = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newtrackingNumber = new StoredVariables(); newtrackingNumber.settrackingNumber(trackingNumber);
		
		ThreadLocal<String> trackingNumberVMP = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newtrackingNumberVMP = new StoredVariables(); newtrackingNumberVMP.settrackingNumberVMP(trackingNumberVMP);
		
		ThreadLocal<String> trackingNumberAMC = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newtrackingNumberAMC = new StoredVariables(); newtrackingNumberAMC.settrackingNumberAMC(trackingNumberAMC);

		ThreadLocal<String> loanID = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newloanID = new StoredVariables(); newloanID.setloanID(loanID);
		
		ThreadLocal<String> loanIDVMP = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newloanIDVMP = new StoredVariables(); newloanIDVMP.setloanIDVMP(loanIDVMP);
		
		ThreadLocal<String> loanIDAMC = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newloanIDAMC = new StoredVariables(); newloanIDAMC.setloanIDAMC(loanIDAMC);
		
		ThreadLocal<String> firstVendorName = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newfirstVendorName = new StoredVariables(); newfirstVendorName.setfirstVendorName(firstVendorName);

		ThreadLocal<String> secondVendorName = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newsecondVendorName = new StoredVariables(); newsecondVendorName.setsecondVendorName(secondVendorName);

		ThreadLocal<String> vendorID = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newvendorID = new StoredVariables(); newvendorID.setvendorID(vendorID);

		ThreadLocal<String> assignedCertContactID = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newassignedCertContactID = new StoredVariables(); newassignedCertContactID.setassignedCertContactID(assignedCertContactID);

		ThreadLocal<String> vendorEmail = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newvendorEmail = new StoredVariables(); newvendorEmail.setvendorEmail(vendorEmail);

		ThreadLocal<String> vendorFirstName = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newvendorFirstName = new StoredVariables(); newvendorFirstName.setvendorFirstName(vendorFirstName);

		ThreadLocal<String> vendorLastName = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newvendorLastName = new StoredVariables(); newvendorLastName.setvendorLastName(vendorLastName);

		ThreadLocal<String> vendorCompanyName = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newvendorCompanyName = new StoredVariables(); newvendorCompanyName.setvendorCompanyName(vendorCompanyName);

		ThreadLocal<String> vendorAddress1 = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newvendorAddress1 = new StoredVariables(); newvendorAddress1.setvendorAddress1(vendorAddress1);

		ThreadLocal<String> vendorCity = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newvendorCity = new StoredVariables(); newvendorCity.setvendorCity(vendorCity);

		ThreadLocal<String> vendorState = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newvendorState = new StoredVariables(); newvendorState.setvendorState(vendorState);

		ThreadLocal<String> vendorZip = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newvendorZip = new StoredVariables(); newvendorZip.setvendorZip(vendorZip);

		ThreadLocal<String> vendorPhone = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newvendorPhone = new StoredVariables(); newvendorPhone.setvendorPhone(vendorPhone);

		ThreadLocal<String> feeAmount = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newfeeAmount = new StoredVariables(); newfeeAmount.setfeeAmount(feeAmount);

		ThreadLocal<String> orderDueDate = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables neworderDueDate = new StoredVariables(); neworderDueDate.setorderDueDate(orderDueDate);

		ThreadLocal<String> newDueDate = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newnewDueDate = new StoredVariables(); newnewDueDate.setnewDueDate(newDueDate);

		ThreadLocal<String> calendarDateShort = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newcalendarDateShort = new StoredVariables(); newcalendarDateShort.setcalendarDateShort(calendarDateShort);

		ThreadLocal<String> calendarDateLong = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newcalendarDateLong = new StoredVariables(); newcalendarDateLong.setcalendarDateLong(calendarDateLong);

		ThreadLocal<String> AWSAccountsID = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newAWSAccountsID = new StoredVariables(); newAWSAccountsID.setAWSAccountsID(AWSAccountsID);

		ThreadLocal<String> stateAbbreviation = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newstateAbbreviation = new StoredVariables(); newstateAbbreviation.setstateAbbreviation(stateAbbreviation);

		ThreadLocal<String> calledFrom = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newcalledFrom = new StoredVariables(); newcalledFrom.setcalledFrom(calledFrom);
		
		ThreadLocal<String> win1 = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newwin1 = new StoredVariables(); newwin1.setwin1(win1);
		
		ThreadLocal<String> win2 = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newwin2 = new StoredVariables(); newwin2.setwin2(win2);
		
		ThreadLocal<String> win3 = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newwin3 = new StoredVariables(); newwin3.setwin3(win3);
		
		ThreadLocal<String> winHandleBefore = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newwinHandleBefore = new StoredVariables(); newwinHandleBefore.setwinHandleBefore(winHandleBefore);

		ThreadLocal<String> newWinHandle = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newnewWinHandle = new StoredVariables(); newnewWinHandle.setnewWinHandle(newWinHandle);

		ThreadLocal<String> thirdWinHandle = new InheritableThreadLocal<String>() {@Override protected String initialValue() {return "";}};
		StoredVariables newthirdWinHandle = new StoredVariables(); newthirdWinHandle.setthirdWinHandle(thirdWinHandle);

		ThreadLocal<Integer> dbNumRows = new InheritableThreadLocal<Integer>() {@Override protected Integer initialValue() {return null;}};
		StoredVariables newdbNumRows = new StoredVariables(); newdbNumRows.setdbNumRows(dbNumRows);

		ThreadLocal<Integer> dbNumColumns = new InheritableThreadLocal<Integer>() {@Override protected Integer initialValue() {return null;}};
		StoredVariables newdbNumColumns = new StoredVariables(); newdbNumColumns.setdbNumColumns(dbNumColumns);

		ThreadLocal<Integer> numRowsUpdated = new InheritableThreadLocal<Integer>() {@Override protected Integer initialValue() {return null;}};
		StoredVariables newnumRowsUpdated = new StoredVariables(); newnumRowsUpdated.setnumRowsUpdated(numRowsUpdated);
		
	} // end initializeVariables
	
	/**
	* 
	* <p>
	* STEPS:
	* <ul>
	* 	<li></li>
	* </ul>
	*/
	public void cleanThreadLocals() {
        try {
            // Get a reference to the thread locals table of the current thread
            Thread thread = Thread.currentThread();
            Field threadLocalsField = Thread.class.getDeclaredField("threadLocals");
            threadLocalsField.setAccessible(true);
            Object threadLocalTable = threadLocalsField.get(thread);

            // Get a reference to the array holding the thread local variables inside the
            // ThreadLocalMap of the current thread
            @SuppressWarnings("rawtypes")
			Class threadLocalMapClass = Class.forName("java.lang.ThreadLocal$ThreadLocalMap");
            Field tableField = threadLocalMapClass.getDeclaredField("table");
            tableField.setAccessible(true);
            Object table = tableField.get(threadLocalTable);

            // The key to the ThreadLocalMap is a WeakReference object. The referent field of this object
            // is a reference to the actual ThreadLocal variable
            Field referentField = Reference.class.getDeclaredField("referent");
            referentField.setAccessible(true);

            for (int i=0; i < Array.getLength(table); i++) {
                // Each entry in the table array of ThreadLocalMap is an Entry object
                // representing the thread local reference and its value
                Object entry = Array.get(table, i);
                if (entry != null) {
                    // Get a reference to the thread local object and remove it from the table
                    @SuppressWarnings("rawtypes")
					ThreadLocal threadLocal = (ThreadLocal)referentField.get(entry);
                    threadLocal.remove();
                } // end if
            } // end for
        } catch(Exception e) {
            // We will tolerate an exception here and just log it
            throw new IllegalStateException(e);
        } // end try/catch
    } // end cleanThreadLocals
	
} // end initializeThreadSaveVariables class
