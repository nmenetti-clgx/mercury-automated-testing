package utils;

import java.util.List;

import setup.TestSetup;

/**
* <h1>Stored Variables</h1>
* Set variables that can be used globally
* <p>
* 
* @author  Dustin Norman
* @since   05-16-2018
*/
@SuppressWarnings("javadoc")
public class StoredVariables extends TestSetup{
	
	private static ThreadLocal<String> environment;
	public static ThreadLocal<String> getenvironment() {return environment;}
	public void setenvironment(ThreadLocal<String> s) {environment = s;}
	
	private static ThreadLocal<String> usernameEnvironment;
	public static ThreadLocal<String> getusernameEnvironment() {return usernameEnvironment;}
	public void setusernameEnvironment(ThreadLocal<String> s) {usernameEnvironment = s;}
	
	private static ThreadLocal<String> userDir;
	public static ThreadLocal<String> getuserDir() {return userDir;}
	public void setuserDir(ThreadLocal<String> s) {userDir = s;}
	
	private static ThreadLocal<String> downloadsDir;
	public static ThreadLocal<String> getdownloadsDir() {return downloadsDir;}
	public void setdownloadsDir(ThreadLocal<String> s) {downloadsDir = s;}
	
	private static ThreadLocal<String> docDir;
	public static ThreadLocal<String> getdocDir() {return docDir;}
	public void setdocDir(ThreadLocal<String> s) {docDir = s;}
	
	private static ThreadLocal<String> dirSlashes;
	public static ThreadLocal<String> getdirSlashes() {return dirSlashes;}
	public void setdirSlashes(ThreadLocal<String> s) {dirSlashes = s;}
	
	private static ThreadLocal<String> serverIP;
	public static ThreadLocal<String> getserverIP() {return serverIP;}
	public void setserverIP(ThreadLocal<String> s) {serverIP = s;}
	
	private static ThreadLocal<String> apiXMLFilesDir;
	public static ThreadLocal<String> getapiXMLFilesDir() {return apiXMLFilesDir;}
	public void setapiXMLFilesDir(ThreadLocal<String> s) {apiXMLFilesDir = s;}
	
	private static ThreadLocal<String> parallelParameter;
	public static ThreadLocal<String> getparallelParameter() {return parallelParameter;}
	public void setparallelParameter(ThreadLocal<String> s) {parallelParameter = s;}
	
	private static ThreadLocal<String> IEDir;
	public static ThreadLocal<String> getIEDir() {return IEDir;}
	public void setIEDir(ThreadLocal<String> s) {IEDir = s;}
	
	private static ThreadLocal<String> os;
	public static ThreadLocal<String> getos() {return os;}
	public void setos(ThreadLocal<String> s) {os = s;}
	
	private static ThreadLocal<String> timeStamp;
	public static ThreadLocal<String> gettimeStamp() {return timeStamp;}
	public void settimeStamp(ThreadLocal<String> s) {timeStamp = s;}
	
	private static ThreadLocal<String> autoIT;
	public static ThreadLocal<String> getautoIT() {return autoIT;}
	public void setautoIT(ThreadLocal<String> s) {autoIT = s;}
	
	private static ThreadLocal<String> browser;
	public static ThreadLocal<String> getbrowser() {return browser;}
	public void setbrowser(ThreadLocal<String> s) {browser = s;}
	
	private static ThreadLocal<String> headless;
	public static ThreadLocal<String> getheadless() {return headless;}
	public void setheadless(ThreadLocal<String> s) {headless = s;}
	
	private static ThreadLocal<String> browser2;
	public static ThreadLocal<String> getbrowser2() {return browser2;}
	public void setbrowser2(ThreadLocal<String> s) {browser2 = s;}
	
	private static ThreadLocal<String> recordVideo;
	public static ThreadLocal<String> getrecordVideo() {return recordVideo;}
	public void setrecordVideo(ThreadLocal<String> s) {recordVideo = s;}
	
	private static ThreadLocal<String> project;
	public static ThreadLocal<String> getproject() {return project;}
	public void setproject(ThreadLocal<String> s) {project = s;}
	
	private static ThreadLocal<String> hubURL;
	public static ThreadLocal<String> gethubURL() {return hubURL;}
	public void sethubURL(ThreadLocal<String> s) {hubURL = s;}
	
	private static ThreadLocal<String> useLocalGrid;
	public static ThreadLocal<String> getuseLocalGrid() {return useLocalGrid;}
	public void setuseLocalGrid(ThreadLocal<String> s) {useLocalGrid = s;}
	
	private static ThreadLocal<String> enableSnapshots;
	public static ThreadLocal<String> getenableSnapshots() {return enableSnapshots;}
	public void setenableSnapshots(ThreadLocal<String> s) {enableSnapshots = s;}
	
	private static ThreadLocal<Boolean> mobile;
	public static ThreadLocal<Boolean> getmobile() {return mobile;}
	public void setmobile(ThreadLocal<Boolean> s) {mobile = s;}
	
	private static ThreadLocal<String> debug;
	public static ThreadLocal<String> getdebug() {return debug;}
	public void setdebug(ThreadLocal<String> s) {debug = s;}
	
	private static ThreadLocal<String> baseURL;
	public static ThreadLocal<String> getbaseURL() {return baseURL;}
	public void setbaseURL(ThreadLocal<String> s) {baseURL = s;}
	
	private static ThreadLocal<String> screenshotPath;
	public static ThreadLocal<String> getscreenshotPath() {return screenshotPath;}
	public void setscreenshotPath(ThreadLocal<String> s) {screenshotPath = s;}
	
	private static ThreadLocal<String> screenshotImage;
	public static ThreadLocal<String> getscreenshotImage() {return screenshotImage;}
	public void setscreenshotImage(ThreadLocal<String> s) {screenshotImage = s;}
	
	private static ThreadLocal<String> screenshotURL;
	public static ThreadLocal<String> getscreenshotURL() {return screenshotURL;}
	public void setscreenshotURL(ThreadLocal<String> s) {screenshotURL = s;}
	
	private static ThreadLocal<String> reportPath;
	public static ThreadLocal<String> getreportPath() {return reportPath;}
	public void setreportPath(ThreadLocal<String> s) {reportPath = s;}
	
	private static ThreadLocal<String> reportDir;
	public static ThreadLocal<String> getreportDir() {return reportDir;}
	public void setreportDir(ThreadLocal<String> s) {reportDir = s;}
	
	private static ThreadLocal<String> eyes;
	public static ThreadLocal<String> geteyes() {return eyes;}
	public void seteyes(ThreadLocal<String> s) {eyes = s;}
	
	private static ThreadLocal<String> dbName;
	public static ThreadLocal<String> getdbName() {return dbName;}
	public void setdbName(ThreadLocal<String> s) {dbName = s;}
	
	private static ThreadLocal<String> dbPort;
	public static ThreadLocal<String> getdbPort() {return dbPort;}
	public void setdbPort(ThreadLocal<String> s) {dbPort = s;}
	
	private static ThreadLocal<String> dbUser;
	public static ThreadLocal<String> getdbUser() {return dbUser;}
	public void setdbUser(ThreadLocal<String> s) {dbUser = s;}
	
	private static ThreadLocal<String> dbPW;
	public static ThreadLocal<String> getdbPW() {return dbPW;}
	public void setdbPW(ThreadLocal<String> s) {dbPW = s;}
	
	private static ThreadLocal<String> extentReportPath;
	public static ThreadLocal<String> getextentReportPath() {return extentReportPath;}
	public void setextentReportPath(ThreadLocal<String> s) {extentReportPath = s;}
	
	private static ThreadLocal<String> extentReportURL;
	public static ThreadLocal<String> getextentReportURL() {return extentReportURL;}
	public void setextentReportURL(ThreadLocal<String> s) {extentReportURL = s;}
	
	private static ThreadLocal<String> openReport;
	public static ThreadLocal<String> getopenReport() {return openReport;}
	public void setopenReport(ThreadLocal<String> s) {openReport = s;}
	
	private static ThreadLocal<String> emulator;
	public static ThreadLocal<String> getemulator() {return emulator;}
	public void setemulator(ThreadLocal<String> s) {emulator = s;}
	
	private static ThreadLocal<String> version;
	public static ThreadLocal<String> getversion() {return version;}
	public void setversion(ThreadLocal<String> s) {version = s;}
	
	private static ThreadLocal<String> dbUrl;
	public static ThreadLocal<String> getdbUrl() {return dbUrl;}
	public void setdbUrl(ThreadLocal<String> s) {dbUrl = s;}
	
	private static ThreadLocal<String> dbResults;
	public static ThreadLocal<String> getdbResults() {return dbResults;}
	public void setdbResults(ThreadLocal<String> s) {dbResults = s;}
	
	private static ThreadLocal<List<String>> results;
	public static ThreadLocal<List<String>> getresults() {return results;}
	public void setresults(ThreadLocal<List<String>> s) {results = s;}
	
	private static ThreadLocal<String> secureSite;
	public static ThreadLocal<String> getsecureSite() {return secureSite;}
	public void setsecureSite(ThreadLocal<String> s) {secureSite = s;}
	
	private static ThreadLocal<String> apiURL;
	public static ThreadLocal<String> getapiURL() {return apiURL;}
	public void setapiURL(ThreadLocal<String> s) {apiURL = s;}
	
	private static ThreadLocal<String> internalToolsSite;
	public static ThreadLocal<String> getinternalToolsSite() {return internalToolsSite;}
	public void setinternalToolsSite(ThreadLocal<String> s) {internalToolsSite = s;}
	
	private static ThreadLocal<String> crmSite;
	public static ThreadLocal<String> getcrmSite() {return crmSite;}
	public void setcrmSite(ThreadLocal<String> s) {crmSite = s;}
	
	private static ThreadLocal<String> ngsecureSite;
	public static ThreadLocal<String> getngsecureSite() {return ngsecureSite;}
	public void setngsecureSite(ThreadLocal<String> s) {ngsecureSite = s;}
	
	private static ThreadLocal<String> vendorsSite;
	public static ThreadLocal<String> getvendorsSite() {return vendorsSite;}
	public void setvendorsSite(ThreadLocal<String> s) {vendorsSite = s;}
	
	private static ThreadLocal<String> vmpSiteSuffix;
	public static ThreadLocal<String> getvmpSiteSuffix() {return vmpSiteSuffix;}
	public void setvmpSiteSuffix(ThreadLocal<String> s) {vmpSiteSuffix = s;}
	
	private static ThreadLocal<String> catchAllDomain;
	public static ThreadLocal<String> getcatchAllDomain() {return catchAllDomain;}
	public void setcatchAllDomain(ThreadLocal<String> s) {catchAllDomain = s;}
	
	private static ThreadLocal<String> password;
	public static ThreadLocal<String> getpassword() {return password;}
	public void setpassword(ThreadLocal<String> s) {password = s;}
	
	private static ThreadLocal<String> userPhonePrefix;
	public static ThreadLocal<String> getuserPhonePrefix() {return userPhonePrefix;}
	public void setuserPhonePrefix(ThreadLocal<String> s) {userPhonePrefix = s;}
	
	private static ThreadLocal<String> newDay;
	public static ThreadLocal<String> getnewDay() {return newDay;}
	public void setnewDay(ThreadLocal<String> s) {newDay = s;}
	
	private static ThreadLocal<String> newDay2;
	public static ThreadLocal<String> getnewDay2() {return newDay2;}
	public void setnewDay2(ThreadLocal<String> s) {newDay2 = s;}
	
	private static ThreadLocal<String> newMonth;
	public static ThreadLocal<String> getnewMonth() {return newMonth;}
	public void setnewMonth(ThreadLocal<String> s) {newMonth = s;}
	
	private static ThreadLocal<String> newMonth2;
	public static ThreadLocal<String> getnewMonth2() {return newMonth2;}
	public void setnewMonth2(ThreadLocal<String> s) {newMonth2 = s;}
	
	private static ThreadLocal<String> newYear;
	public static ThreadLocal<String> getnewYear() {return newYear;}
	public void setnewYear(ThreadLocal<String> s) {newYear = s;}
	
	private static ThreadLocal<String> currentMonth;
	public static ThreadLocal<String> getcurrentMonth() {return currentMonth;}
	public void setcurrentMonth(ThreadLocal<String> s) {currentMonth = s;}
	
	private static ThreadLocal<String> directionsIdentifier;
	public static ThreadLocal<String> getdirectionsIdentifier() {return directionsIdentifier;}
	public void setdirectionsIdentifier(ThreadLocal<String> s) {directionsIdentifier = s;}
	
	private static ThreadLocal<String> borrowerIdentifier;
	public static ThreadLocal<String> getborrowerIdentifier() {return borrowerIdentifier;}
	public void setborrowerIdentifier(ThreadLocal<String> s) {borrowerIdentifier = s;}

	private static ThreadLocal<String> trackingNumber;
	public static ThreadLocal<String> gettrackingNumber() {return trackingNumber;}
	public void settrackingNumber(ThreadLocal<String> s) {trackingNumber = s;}
	
	private static ThreadLocal<String> trackingNumberVMP;
	public static ThreadLocal<String> gettrackingNumberVMP() {return trackingNumberVMP;}
	public void settrackingNumberVMP(ThreadLocal<String> s) {trackingNumberVMP = s;}
	
	private static ThreadLocal<String> trackingNumberAMC;
	public static ThreadLocal<String> gettrackingNumberAMC() {return trackingNumberAMC;}
	public void settrackingNumberAMC(ThreadLocal<String> s) {trackingNumberAMC = s;}
	
	private static ThreadLocal<String> loanID;
	public static ThreadLocal<String> getloanID() {return loanID;}
	public void setloanID(ThreadLocal<String> s) {loanID = s;}
	
	private static ThreadLocal<String> loanIDVMP;
	public static ThreadLocal<String> getloanIDVMP() {return loanIDVMP;}
	public void setloanIDVMP(ThreadLocal<String> s) {loanIDVMP = s;}
	
	private static ThreadLocal<String> loanIDAMC;
	public static ThreadLocal<String> getloanIDAMC() {return loanIDAMC;}
	public void setloanIDAMC(ThreadLocal<String> s) {loanIDAMC = s;}
	
	private static ThreadLocal<String> firstVendorName;
	public static ThreadLocal<String> getfirstVendorName() {return firstVendorName;}
	public void setfirstVendorName(ThreadLocal<String> s) {firstVendorName = s;}
	
	private static ThreadLocal<String> secondVendorName;
	public static ThreadLocal<String> getsecondVendorName() {return secondVendorName;}
	public void setsecondVendorName(ThreadLocal<String> s) {secondVendorName = s;}
	
	private static ThreadLocal<String> vendorID;
	public static ThreadLocal<String> getvendorID() {return vendorID;}
	public void setvendorID(ThreadLocal<String> s) {vendorID = s;}
	
	private static ThreadLocal<String> assignedCertContactID;
	public static ThreadLocal<String> getassignedCertContactID() {return assignedCertContactID;}
	public void setassignedCertContactID(ThreadLocal<String> s) {assignedCertContactID = s;}
	
	private static ThreadLocal<String> vendorEmail;
	public static ThreadLocal<String> getvendorEmail() {return vendorEmail;}
	public void setvendorEmail(ThreadLocal<String> s) {vendorEmail = s;}
	
	private static ThreadLocal<String> vendorFirstName;
	public static ThreadLocal<String> getvendorFirstName() {return vendorFirstName;}
	public void setvendorFirstName(ThreadLocal<String> s) {vendorFirstName = s;}
	
	private static ThreadLocal<String> vendorLastName;
	public static ThreadLocal<String> getvendorLastName() {return vendorLastName;}
	public void setvendorLastName(ThreadLocal<String> s) {vendorLastName = s;}
	
	private static ThreadLocal<String> vendorCompanyName;
	public static ThreadLocal<String> getvendorCompanyName() {return vendorCompanyName;}
	public void setvendorCompanyName(ThreadLocal<String> s) {vendorCompanyName = s;}
	
	private static ThreadLocal<String> vendorAddress1;
	public static ThreadLocal<String> getvendorAddress1() {return vendorAddress1;}
	public void setvendorAddress1(ThreadLocal<String> s) {vendorAddress1 = s;}
	
	private static ThreadLocal<String> vendorCity;
	public static ThreadLocal<String> getvendorCity() {return vendorCity;}
	public void setvendorCity(ThreadLocal<String> s) {vendorCity = s;}
	
	private static ThreadLocal<String> vendorState;
	public static ThreadLocal<String> getvendorState() {return vendorState;}
	public void setvendorState(ThreadLocal<String> s) {vendorState = s;}
	
	private static ThreadLocal<String> vendorZip;
	public static ThreadLocal<String> getvendorZip() {return vendorZip;}
	public void setvendorZip(ThreadLocal<String> s) {vendorZip = s;}
	
	private static ThreadLocal<String> vendorPhone;
	public static ThreadLocal<String> getvendorPhone() {return vendorPhone;}
	public void setvendorPhone(ThreadLocal<String> s) {vendorPhone = s;}
	
	private static ThreadLocal<String> feeAmount;
	public static ThreadLocal<String> getfeeAmount() {return feeAmount;}
	public void setfeeAmount(ThreadLocal<String> s) {feeAmount = s;}
	
	private static ThreadLocal<String> orderDueDate;
	public static ThreadLocal<String> getorderDueDate() {return orderDueDate;}
	public void setorderDueDate(ThreadLocal<String> s) {orderDueDate = s;}
	
	private static ThreadLocal<String> newDueDate;
	public static ThreadLocal<String> getnewDueDate() {return newDueDate;}
	public void setnewDueDate(ThreadLocal<String> s) {newDueDate = s;}
	
	private static ThreadLocal<String> calendarDateShort;
	public static ThreadLocal<String> getcalendarDateShort() {return calendarDateShort;}
	public void setcalendarDateShort(ThreadLocal<String> s) {calendarDateShort = s;}
	
	private static ThreadLocal<String> calendarDateLong;
	public static ThreadLocal<String> getcalendarDateLong() {return calendarDateLong;}
	public void setcalendarDateLong(ThreadLocal<String> s) {calendarDateLong = s;}
	
	private static ThreadLocal<String> todaysDateLong;
	public static ThreadLocal<String> gettodaysDateLong() {return todaysDateLong;}
	public void settodaysDateLong(ThreadLocal<String> s) {todaysDateLong = s;}
	
	private static ThreadLocal<String> todaysDateShort;
	public static ThreadLocal<String> gettodaysDateShort() {return todaysDateShort;}
	public void settodaysDateShort(ThreadLocal<String> s) {todaysDateShort = s;}
	
	private static ThreadLocal<String> AWSAccountsID;
	public static ThreadLocal<String> getAWSAccountsID() {return AWSAccountsID;}
	public void setAWSAccountsID(ThreadLocal<String> s) {AWSAccountsID = s;}
	
	private static ThreadLocal<String> stateAbbreviation;
	public static ThreadLocal<String> getstateAbbreviation() {return stateAbbreviation;}
	public void setstateAbbreviation(ThreadLocal<String> s) {stateAbbreviation = s;}
	
	private static ThreadLocal<String> calledFrom;
	public static ThreadLocal<String> getcalledFrom() {return calledFrom;}
	public void setcalledFrom(ThreadLocal<String> s) {calledFrom = s;}
	
	private static ThreadLocal<String> win1;
	public static ThreadLocal<String> getwin1() {return win1;}
	public void setwin1(ThreadLocal<String> s) {win1 = s;}
	
	private static ThreadLocal<String> win2;
	public static ThreadLocal<String> getwin2() {return win2;}
	public void setwin2(ThreadLocal<String> s) {win2 = s;}
	
	private static ThreadLocal<String> win3;
	public static ThreadLocal<String> getwin3() {return win3;}
	public void setwin3(ThreadLocal<String> s) {win3 = s;}
	
	private static ThreadLocal<String> winHandleBefore;
	public static ThreadLocal<String> getwinHandleBefore() {return winHandleBefore;}
	public void setwinHandleBefore(ThreadLocal<String> s) {winHandleBefore = s;}
	
	private static ThreadLocal<String> newWinHandle;
	public static ThreadLocal<String> getnewWinHandle() {return newWinHandle;}
	public void setnewWinHandle(ThreadLocal<String> s) {newWinHandle = s;}
	
	private static ThreadLocal<String> thirdWinHandle;
	public static ThreadLocal<String> getthirdWinHandle() {return thirdWinHandle;}
	public void setthirdWinHandle(ThreadLocal<String> s) {thirdWinHandle = s;}
	
	private static ThreadLocal<Integer> dbNumRows;
	public static ThreadLocal<Integer> getdbNumRows() {return dbNumRows;}
	public void setdbNumRows(ThreadLocal<Integer> s) {dbNumRows = s;}
	
	private static ThreadLocal<Integer> dbNumColumns;
	public static ThreadLocal<Integer> getdbNumColumns() {return dbNumColumns;}
	public void setdbNumColumns(ThreadLocal<Integer> s) {dbNumColumns = s;}
	
	private static ThreadLocal<Integer> numRowsUpdated;
	public static ThreadLocal<Integer> getnumRowsUpdated() {return numRowsUpdated;}
	public void setnumRowsUpdated(ThreadLocal<Integer> s) {numRowsUpdated = s;}
	
	private static ThreadLocal<Integer> iteration;
	public static ThreadLocal<Integer> getiteration() {return iteration;}
	public void setiteration(ThreadLocal<Integer> s) {iteration = s;}
	
	private static ThreadLocal<Boolean> failedTest;
	public static ThreadLocal<Boolean> getfailedTest() {return failedTest;}
	public void setfailedTest(ThreadLocal<Boolean> s) {failedTest = s;}
	

	// New Order Data/Information
	// Property Information
	private static ThreadLocal<String> orderDueDateShort;
	public static ThreadLocal<String> getorderDueDateShort() {return orderDueDateShort;}
	public void setorderDueDateShort(ThreadLocal<String> s) {orderDueDateShort = s;}
	
	private static ThreadLocal<String> orderDueDateLong;
	public static ThreadLocal<String> getorderDueDateLong() {return orderDueDateLong;}
	public void setorderDueDateLong(ThreadLocal<String> s) {orderDueDateLong = s;}
	
	private static ThreadLocal<String> newDateShort;
	public static ThreadLocal<String> getnewDateShort() {return newDateShort;}
	public void setnewDateShort(ThreadLocal<String> s) {newDateShort = s;}
	
	private static ThreadLocal<String> newDateLong;
	public static ThreadLocal<String> getnewDateLong() {return newDateLong;}
	public void setnewDateLong(ThreadLocal<String> s) {newDateLong = s;}
	
	private static ThreadLocal<String> disclosureDateShort;
	public static ThreadLocal<String> getdisclosureDateShort() {return disclosureDateShort;}
	public void setdisclosureDateShort(ThreadLocal<String> s) {disclosureDateShort = s;}
	
	private static ThreadLocal<String> disclosureDateLong;
	public static ThreadLocal<String> getdisclosureDateLong() {return disclosureDateLong;}
	public void setdisclosureDateLong(ThreadLocal<String> s) {disclosureDateLong = s;}
	
	private static ThreadLocal<String> propertyInformationAddress;
	public static ThreadLocal<String> getpropertyInformationAddress() {return propertyInformationAddress;}
	public void setpropertyInformationAddress(ThreadLocal<String> s) {propertyInformationAddress = s;}
	
	private static ThreadLocal<String> propertyInformationCity;
	public static ThreadLocal<String> getpropertyInformationCity() {return propertyInformationCity;}
	public void setpropertyInformationCity(ThreadLocal<String> s) {propertyInformationCity = s;}
	
	private static ThreadLocal<String> propertyInformationState;
	public static ThreadLocal<String> getpropertyInformationState() {return propertyInformationState;}
	public void setpropertyInformationState(ThreadLocal<String> s) {propertyInformationState = s;}
	
	private static ThreadLocal<String> propertyInformationStateAbbr;
	public static ThreadLocal<String> getpropertyInformationStateAbbr() {return propertyInformationStateAbbr;}
	public void setpropertyInformationStateAbbr(ThreadLocal<String> s) {propertyInformationStateAbbr = s;}
	
	private static ThreadLocal<String> propertyInformationZip;
	public static ThreadLocal<String> getpropertyInformationZip() {return propertyInformationZip;}
	public void setpropertyInformationZip(ThreadLocal<String> s) {propertyInformationZip = s;}
	
	private static ThreadLocal<String> propertyInformationCounty;
	public static ThreadLocal<String> getpropertyInformationCounty() {return propertyInformationCounty;}
	public void setpropertyInformationCounty(ThreadLocal<String> s) {propertyInformationCounty = s;}
	
	private static ThreadLocal<String> propertyInformationSqFt;
	public static ThreadLocal<String> getpropertyInformationSqFt() {return propertyInformationSqFt;}
	public void setpropertyInformationSqFt(ThreadLocal<String> s) {propertyInformationSqFt = s;}
	
	private static ThreadLocal<String> propertyInformationSiteSize;
	public static ThreadLocal<String> getpropertyInformationSiteSize() {return propertyInformationSiteSize;}
	public void setpropertyInformationSiteSize(ThreadLocal<String> s) {propertyInformationSiteSize = s;}
	
	private static ThreadLocal<String> propertyInformationPropType;
	public static ThreadLocal<String> getpropertyInformationPropType() {return propertyInformationPropType;}
	public void setpropertyInformationPropType(ThreadLocal<String> s) {propertyInformationPropType = s;}
	
	private static ThreadLocal<String> propertyInformationPropRights;
	public static ThreadLocal<String> getpropertyInformationPropRights() {return propertyInformationPropRights;}
	public void setpropertyInformationPropRights(ThreadLocal<String> s) {propertyInformationPropRights = s;}
	
	private static ThreadLocal<String> propertyInformationLegalDesc;
	public static ThreadLocal<String> getpropertyInformationLegalDesc() {return propertyInformationLegalDesc;}
	public void setpropertyInformationLegalDesc(ThreadLocal<String> s) {propertyInformationLegalDesc = s;}
	
	private static ThreadLocal<String> propertyInformationDirections;
	public static ThreadLocal<String> getpropertyInformationDirections() {return propertyInformationDirections;}
	public void setpropertyInformationDirections(ThreadLocal<String> s) {propertyInformationDirections = s;}
	
	
	// Assignment Information
	private static ThreadLocal<String> assignmentInformationForm;
	public static ThreadLocal<String> getassignmentInformationForm() {return assignmentInformationForm;}
	public void setassignmentInformationForm(ThreadLocal<String> s) {assignmentInformationForm = s;}
	
	private static ThreadLocal<Boolean> assignmentInformationRushOrder;
	public static ThreadLocal<Boolean> getassignmentInformationRushOrder() {return assignmentInformationRushOrder;}
	public void setassignmentInformationRushOrder(ThreadLocal<Boolean> s) {assignmentInformationRushOrder = s;}
	
	private static ThreadLocal<Boolean> assignmentInformationComplex;
	public static ThreadLocal<Boolean> getassignmentInformationComplex() {return assignmentInformationComplex;}
	public void setassignmentInformationComplex(ThreadLocal<Boolean> s) {assignmentInformationComplex = s;}
	
	private static ThreadLocal<Boolean> assignmentInformationIssueAsBid;
	public static ThreadLocal<Boolean> getassignmentInformationIssueAsBid() {return assignmentInformationIssueAsBid;}
	public void setassignmentInformationIssueAsBid(ThreadLocal<Boolean> s) {assignmentInformationIssueAsBid = s;}
	
	private static ThreadLocal<Integer> assignmentInformationOrderDue;
	public static ThreadLocal<Integer> getassignmentInformationOrderDue() {return assignmentInformationOrderDue;}
	public void setassignmentInformationOrderDue(ThreadLocal<Integer> s) {assignmentInformationOrderDue = s;}
	
	private static ThreadLocal<String> assignmentInformationOtherRefNumber;
	public static ThreadLocal<String> getassignmentInformationOtherRefNumber() {return assignmentInformationOtherRefNumber;}
	public void setassignmentInformationOtherRefNumber(ThreadLocal<String> s) {assignmentInformationOtherRefNumber = s;}
	
	private static ThreadLocal<String> assignmentInformationLoanType;
	public static ThreadLocal<String> getassignmentInformationLoanType() {return assignmentInformationLoanType;}
	public void setassignmentInformationLoanType(ThreadLocal<String> s) {assignmentInformationLoanType = s;}
	
	private static ThreadLocal<String> assignmentInformationLoanPurpose;
	public static ThreadLocal<String> getassignmentInformationLoanPurpose() {return assignmentInformationLoanPurpose;}
	public void setassignmentInformationLoanPurpose(ThreadLocal<String> s) {assignmentInformationLoanPurpose = s;}
	
	private static ThreadLocal<String> assignmentInformationOrderedBy;
	public static ThreadLocal<String> getassignmentInformationOrderedBy() {return assignmentInformationOrderedBy;}
	public void setassignmentInformationOrderedBy(ThreadLocal<String> s) {assignmentInformationOrderedBy = s;}
	
	private static ThreadLocal<String> assignmentInformationOrderGroup;
	public static ThreadLocal<String> getassignmentInformationOrderGroup() {return assignmentInformationOrderGroup;}
	public void setassignmentInformationOrderGroup(ThreadLocal<String> s) {assignmentInformationOrderGroup = s;}
	
	private static ThreadLocal<String> assignmentInformationLoanNumber;
	public static ThreadLocal<String> getassignmentInformationLoanNumber() {return assignmentInformationLoanNumber;}
	public void setassignmentInformationLoanNumber(ThreadLocal<String> s) {assignmentInformationLoanNumber = s;}
	
	private static ThreadLocal<String> assignmentInformationFileNumber;
	public static ThreadLocal<String> getassignmentInformationFileNumber() {return assignmentInformationFileNumber;}
	public void setassignmentInformationFileNumber(ThreadLocal<String> s) {assignmentInformationFileNumber = s;}
	
	private static ThreadLocal<String> assignmentInformationSalesPrice;
	public static ThreadLocal<String> getassignmentInformationSalesPrice() {return assignmentInformationSalesPrice;}
	public void setassignmentInformationSalesPrice(ThreadLocal<String> s) {assignmentInformationSalesPrice = s;}
	
	private static ThreadLocal<String> assignmentInformationFHACaseNumber;
	public static ThreadLocal<String> getassignmentInformationFHACaseNumber() {return assignmentInformationFHACaseNumber;}
	public void setassignmentInformationFHACaseNumber(ThreadLocal<String> s) {assignmentInformationFHACaseNumber = s;}
	
	private static ThreadLocal<Integer> assignmentInformationDisclosure;
	public static ThreadLocal<Integer> getassignmentInformationDisclosure() {return assignmentInformationDisclosure;}
	public void setassignmentInformationDisclosure(ThreadLocal<Integer> s) {assignmentInformationDisclosure = s;}
	
	private static ThreadLocal<Boolean> skipDisclosureDate;
	public static ThreadLocal<Boolean> getskipDisclosureDate() {return skipDisclosureDate;}
	public void setskipDisclosureDate(ThreadLocal<Boolean> s) {skipDisclosureDate = s;}
	
	private static ThreadLocal<String> assignmentInformationAssignedTo;
	public static ThreadLocal<String> getassignmentInformationAssignedTo() {return assignmentInformationAssignedTo;}
	public void setassignmentInformationAssignedTo(ThreadLocal<String> s) {assignmentInformationAssignedTo = s;}
	
	private static ThreadLocal<String> assignmentInformationAccountExec;
	public static ThreadLocal<String> getassignmentInformationAccountExec() {return assignmentInformationAccountExec;}
	public void setassignmentInformationAccountExec(ThreadLocal<String> s) {assignmentInformationAccountExec = s;}

	
	// Lender Information
	private static ThreadLocal<String> lenderInformationLenderName;
	public static ThreadLocal<String> getlenderInformationLenderName() {return lenderInformationLenderName;}
	public void setlenderInformationLenderName(ThreadLocal<String> s) {lenderInformationLenderName = s;}
	
	private static ThreadLocal<String> lenderInformationAddress1;
	public static ThreadLocal<String> getlenderInformationAddress1() {return lenderInformationAddress1;}
	public void setlenderInformationAddress1(ThreadLocal<String> s) {lenderInformationAddress1 = s;}
	
	private static ThreadLocal<String> lenderInformationAddress2;
	public static ThreadLocal<String> getlenderInformationAddress2() {return lenderInformationAddress2;}
	public void setlenderInformationAddress2(ThreadLocal<String> s) {lenderInformationAddress2 = s;}
	
	private static ThreadLocal<String> lenderInformationCity;
	public static ThreadLocal<String> getlenderInformationCity() {return lenderInformationCity;}
	public void setlenderInformationCity(ThreadLocal<String> s) {lenderInformationCity = s;}
	
	private static ThreadLocal<String> lenderInformationState;
	public static ThreadLocal<String> getlenderInformationState() {return lenderInformationState;}
	public void setlenderInformationState(ThreadLocal<String> s) {lenderInformationState = s;}
	
	private static ThreadLocal<String> lenderInformationZip;
	public static ThreadLocal<String> getlenderInformationZip() {return lenderInformationZip;}
	public void setlenderInformationZip(ThreadLocal<String> s) {lenderInformationZip = s;}

	
	// Contact and Access Information
	private static ThreadLocal<String> contactOccupancy;
	public static ThreadLocal<String> getcontactOccupancy() {return contactOccupancy;}
	public void setcontactOccupancy(ThreadLocal<String> s) {contactOccupancy = s;}
	
	private static ThreadLocal<String> contactBorrower;
	public static ThreadLocal<String> getcontactBorrower() {return contactBorrower;}
	public void setcontactBorrower(ThreadLocal<String> s) {contactBorrower = s;}
	
	private static ThreadLocal<String> contactBorrowerInfo1Dropdown;
	public static ThreadLocal<String> getcontactBorrowerInfo1Dropdown() {return contactBorrowerInfo1Dropdown;}
	public void setcontactBorrowerInfo1Dropdown(ThreadLocal<String> s) {contactBorrowerInfo1Dropdown = s;}
	
	private static ThreadLocal<String> contactBorrowerInfo1;
	public static ThreadLocal<String> getcontactBorrowerInfo1() {return contactBorrowerInfo1;}
	public void setcontactBorrowerInfo1(ThreadLocal<String> s) {contactBorrowerInfo1 = s;}
	
	private static ThreadLocal<String> contactBorrowerInfo2Dropdown;
	public static ThreadLocal<String> getcontactBorrowerInfo2Dropdown() {return contactBorrowerInfo2Dropdown;}
	public void setcontactBorrowerInfo2Dropdown(ThreadLocal<String> s) {contactBorrowerInfo2Dropdown = s;}
	
	private static ThreadLocal<String> contactBorrowerInfo2;
	public static ThreadLocal<String> getcontactBorrowerInfo2() {return contactBorrowerInfo2;}
	public void setcontactBorrowerInfo2(ThreadLocal<String> s) {contactBorrowerInfo2 = s;}
	
	private static ThreadLocal<String> contactBorrowerAddress;
	public static ThreadLocal<String> getcontactBorrowerAddress() {return contactBorrowerAddress;}
	public void setcontactBorrowerAddress(ThreadLocal<String> s) {contactBorrowerAddress = s;}
	
	private static ThreadLocal<String> contactBorrowerCity;
	public static ThreadLocal<String> getcontactBorrowerCity() {return contactBorrowerCity;}
	public void setcontactBorrowerCity(ThreadLocal<String> s) {contactBorrowerCity = s;}
	
	private static ThreadLocal<String> contactBorrowerState;
	public static ThreadLocal<String> getcontactBorrowerState() {return contactBorrowerState;}
	public void setcontactBorrowerState(ThreadLocal<String> s) {contactBorrowerState = s;}
	
	private static ThreadLocal<String> contactBorrowerZip;
	public static ThreadLocal<String> getcontactBorrowerZip() {return contactBorrowerZip;}
	public void setcontactBorrowerZip(ThreadLocal<String> s) {contactBorrowerZip = s;}
	
	private static ThreadLocal<String> contactCoBorrower;
	public static ThreadLocal<String> getcontactCoBorrower() {return contactCoBorrower;}
	public void setcontactCoBorrower(ThreadLocal<String> s) {contactCoBorrower = s;}
	
	private static ThreadLocal<String> contactCoBorrowerInfo1Dropdown;
	public static ThreadLocal<String> getcontactCoBorrowerInfo1Dropdown() {return contactCoBorrowerInfo1Dropdown;}
	public void setcontactCoBorrowerInfo1Dropdown(ThreadLocal<String> s) {contactCoBorrowerInfo1Dropdown = s;}
	
	private static ThreadLocal<String> contactCoBorrowerInfo1;
	public static ThreadLocal<String> getcontactCoBorrowerInfo1() {return contactCoBorrowerInfo1;}
	public void setcontactCoBorrowerInfo1(ThreadLocal<String> s) {contactCoBorrowerInfo1 = s;}
	
	private static ThreadLocal<String> contactCoBorrowerInfo2Dropdown;
	public static ThreadLocal<String> getcontactCoBorrowerInfo2Dropdown() {return contactCoBorrowerInfo2Dropdown;}
	public void setcontactCoBorrowerInfo2Dropdown(ThreadLocal<String> s) {contactCoBorrowerInfo2Dropdown = s;}
	
	private static ThreadLocal<String> contactCoBorrowerInfo2;
	public static ThreadLocal<String> getcontactCoBorrowerInfo2() {return contactCoBorrowerInfo2;}
	public void setcontactCoBorrowerInfo2(ThreadLocal<String> s) {contactCoBorrowerInfo2 = s;}
	
	private static ThreadLocal<String> contactCoBorrowerAddress;
	public static ThreadLocal<String> getcontactCoBorrowerAddress() {return contactCoBorrowerAddress;}
	public void setcontactCoBorrowerAddress(ThreadLocal<String> s) {contactCoBorrowerAddress = s;}
	
	private static ThreadLocal<String> contactCoBorrowerCity;
	public static ThreadLocal<String> getcontactCoBorrowerCity() {return contactCoBorrowerCity;}
	public void setcontactCoBorrowerCity(ThreadLocal<String> s) {contactCoBorrowerCity = s;}
	
	private static ThreadLocal<String> contactCoBorrowerState;
	public static ThreadLocal<String> getcontactCoBorrowerState() {return contactCoBorrowerState;}
	public void setcontactCoBorrowerState(ThreadLocal<String> s) {contactCoBorrowerState = s;}
	
	private static ThreadLocal<String> contactCoBorrowerZip;
	public static ThreadLocal<String> getcontactCoBorrowerZip() {return contactCoBorrowerZip;}
	public void setcontactCoBorrowerZip(ThreadLocal<String> s) {contactCoBorrowerZip = s;}
	
	private static ThreadLocal<String> contactOwner;
	public static ThreadLocal<String> getcontactOwner() {return contactOwner;}
	public void setcontactOwner(ThreadLocal<String> s) {contactOwner = s;}
	
	private static ThreadLocal<String> contactOwnerInfo1Dropdown;
	public static ThreadLocal<String> getcontactOwnerInfo1Dropdown() {return contactOwnerInfo1Dropdown;}
	public void setcontactOwnerInfo1Dropdown(ThreadLocal<String> s) {contactOwnerInfo1Dropdown = s;}
	
	private static ThreadLocal<String> contactOwnerInfo1;
	public static ThreadLocal<String> getcontactOwnerInfo1() {return contactOwnerInfo1;}
	public void setcontactOwnerInfo1(ThreadLocal<String> s) {contactOwnerInfo1 = s;}
	
	private static ThreadLocal<String> contactOwnerInfo2Dropdown;
	public static ThreadLocal<String> getcontactOwnerInfo2Dropdown() {return contactOwnerInfo2Dropdown;}
	public void setcontactOwnerInfo2Dropdown(ThreadLocal<String> s) {contactOwnerInfo2Dropdown = s;}
	
	private static ThreadLocal<String> contactOwnerInfo2;
	public static ThreadLocal<String> getcontactOwnerInfo2() {return contactOwnerInfo2;}
	public void setcontactOwnerInfo2(ThreadLocal<String> s) {contactOwnerInfo2 = s;}
	
	private static ThreadLocal<String> contactOccupant;
	public static ThreadLocal<String> getcontactOccupant() {return contactOccupant;}
	public void setcontactOccupant(ThreadLocal<String> s) {contactOccupant = s;}
	
	private static ThreadLocal<String> contactOccupantInfo1Dropdown;
	public static ThreadLocal<String> getcontactOccupantInfo1Dropdown() {return contactOccupantInfo1Dropdown;}
	public void setcontactOccupantInfo1Dropdown(ThreadLocal<String> s) {contactOccupantInfo1Dropdown = s;}
	
	private static ThreadLocal<String> contactOccupantInfo1;
	public static ThreadLocal<String> getcontactOccupantInfo1() {return contactOccupantInfo1;}
	public void setcontactOccupantInfo1(ThreadLocal<String> s) {contactOccupantInfo1 = s;}
	
	private static ThreadLocal<String> contactOccupantInfo2Dropdown;
	public static ThreadLocal<String> getcontactOccupantInfo2Dropdown() {return contactOccupantInfo2Dropdown;}
	public void setcontactOccupantInfo2Dropdown(ThreadLocal<String> s) {contactOccupantInfo2Dropdown = s;}
	
	private static ThreadLocal<String> contactOccupantInfo2;
	public static ThreadLocal<String> getcontactOccupantInfo2() {return contactOccupantInfo2;}
	public void setcontactOccupantInfo2(ThreadLocal<String> s) {contactOccupantInfo2 = s;}
	
	private static ThreadLocal<String> contactAgent;
	public static ThreadLocal<String> getcontactAgent() {return contactAgent;}
	public void setcontactAgent(ThreadLocal<String> s) {contactAgent = s;}
	
	private static ThreadLocal<String> contactAgentInfo1Dropdown;
	public static ThreadLocal<String> getcontactAgentInfo1Dropdown() {return contactAgentInfo1Dropdown;}
	public void setcontactAgentInfo1Dropdown(ThreadLocal<String> s) {contactAgentInfo1Dropdown = s;}
	
	private static ThreadLocal<String> contactAgentInfo1;
	public static ThreadLocal<String> getcontactAgentInfo1() {return contactAgentInfo1;}
	public void setcontactAgentInfo1(ThreadLocal<String> s) {contactAgentInfo1 = s;}
	
	private static ThreadLocal<String> contactAgentInfo2Dropdown;
	public static ThreadLocal<String> getcontactAgentInfo2Dropdown() {return contactAgentInfo2Dropdown;}
	public void setcontactAgentInfo2Dropdown(ThreadLocal<String> s) {contactAgentInfo2Dropdown = s;}
	
	private static ThreadLocal<String> contactAgentInfo2;
	public static ThreadLocal<String> getcontactAgentInfo2() {return contactAgentInfo2;}
	public void setcontactAgentInfo2(ThreadLocal<String> s) {contactAgentInfo2 = s;}
	
	private static ThreadLocal<String> contactOther;
	public static ThreadLocal<String> getcontactOther() {return contactOther;}
	public void setcontactOther(ThreadLocal<String> s) {contactOther = s;}
	
	private static ThreadLocal<String> contactOtherInfo1Dropdown;
	public static ThreadLocal<String> getcontactOtherInfo1Dropdown() {return contactOtherInfo1Dropdown;}
	public void setcontactOtherInfo1Dropdown(ThreadLocal<String> s) {contactOtherInfo1Dropdown = s;}
	
	private static ThreadLocal<String> contactOtherInfo1;
	public static ThreadLocal<String> getcontactOtherInfo1() {return contactOtherInfo1;}
	public void setcontactOtherInfo1(ThreadLocal<String> s) {contactOtherInfo1 = s;}
	
	private static ThreadLocal<String> contactOtherInfo2Dropdown;
	public static ThreadLocal<String> getcontactOtherInfo2Dropdown() {return contactOtherInfo2Dropdown;}
	public void setcontactOtherInfo2Dropdown(ThreadLocal<String> s) {contactOtherInfo2Dropdown = s;}
	
	private static ThreadLocal<String> contactOtherInfo2;
	public static ThreadLocal<String> getcontactOtherInfo2() {return contactOtherInfo2;}
	public void setcontactOtherInfo2(ThreadLocal<String> s) {contactOtherInfo2 = s;}

	private static ThreadLocal<String> contactApptContact;
	public static ThreadLocal<String> getcontactApptContact() {return contactApptContact;}
	public void setcontactApptContact(ThreadLocal<String> s) {contactApptContact = s;}
	
	// Additional Notification Recipients
	private static ThreadLocal<String> additionalNotificationRecipientsAdditionalEmails;
	public static ThreadLocal<String> getadditionalNotificationRecipientsAdditionalEmails() {return additionalNotificationRecipientsAdditionalEmails;}
	public void setadditionalNotificationRecipientsAdditionalEmails(ThreadLocal<String> s) {additionalNotificationRecipientsAdditionalEmails = s;}
	
	private static ThreadLocal<Boolean> additionalNotificationRecipientsAttachCompletedReport;
	public static ThreadLocal<Boolean> getadditionalNotificationRecipientsAttachCompletedReport() {return additionalNotificationRecipientsAttachCompletedReport;}
	public void setadditionalNotificationRecipientsAttachCompletedReport(ThreadLocal<Boolean> s) {additionalNotificationRecipientsAttachCompletedReport = s;}
	
	private static ThreadLocal<String> productRequirements;
	public static ThreadLocal<String> getproductRequirements() {return productRequirements;}
	public void setproductRequirements(ThreadLocal<String> s) {productRequirements = s;}
	
	private static ThreadLocal<String> additionalComments;
	public static ThreadLocal<String> getadditionalComments() {return additionalComments;}
	public void setadditionalComments(ThreadLocal<String> s) {additionalComments = s;}
	

	
	
	// New Order Data/Information - IN THE DATABASE
	// Property Information
	private static ThreadLocal<String> DBorderDueDateShort;
	public static ThreadLocal<String> getDBorderDueDateShort() {return DBorderDueDateShort;}
	public void setDBorderDueDateShort(ThreadLocal<String> s) {DBorderDueDateShort = s;}
	
	private static ThreadLocal<String> DBorderDueDateLong;
	public static ThreadLocal<String> getDBorderDueDateLong() {return DBorderDueDateLong;}
	public void setDBorderDueDateLong(ThreadLocal<String> s) {DBorderDueDateLong = s;}
	
	private static ThreadLocal<String> DBdisclosureDateShort;
	public static ThreadLocal<String> getDBdisclosureDateShort() {return DBdisclosureDateShort;}
	public void setDBdisclosureDateShort(ThreadLocal<String> s) {DBdisclosureDateShort = s;}
	
	private static ThreadLocal<String> DBdisclosureDateLong;
	public static ThreadLocal<String> getDBdisclosureDateLong() {return DBdisclosureDateLong;}
	public void setDBdisclosureDateLong(ThreadLocal<String> s) {DBdisclosureDateLong = s;}
	
	private static ThreadLocal<String> DBpropertyInformationAddress;
	public static ThreadLocal<String> getDBpropertyInformationAddress() {return DBpropertyInformationAddress;}
	public void setDBpropertyInformationAddress(ThreadLocal<String> s) {DBpropertyInformationAddress = s;}
	
	private static ThreadLocal<String> DBpropertyInformationCity;
	public static ThreadLocal<String> getDBpropertyInformationCity() {return DBpropertyInformationCity;}
	public void setDBpropertyInformationCity(ThreadLocal<String> s) {DBpropertyInformationCity = s;}
	
	private static ThreadLocal<String> DBpropertyInformationState;
	public static ThreadLocal<String> getDBpropertyInformationState() {return DBpropertyInformationState;}
	public void setDBpropertyInformationState(ThreadLocal<String> s) {DBpropertyInformationState = s;}
	
	private static ThreadLocal<String> DBpropertyInformationStateAbbr;
	public static ThreadLocal<String> getDBpropertyInformationStateAbbr() {return DBpropertyInformationStateAbbr;}
	public void setDBpropertyInformationStateAbbr(ThreadLocal<String> s) {DBpropertyInformationStateAbbr = s;}
	
	private static ThreadLocal<String> DBpropertyInformationZip;
	public static ThreadLocal<String> getDBpropertyInformationZip() {return DBpropertyInformationZip;}
	public void setDBpropertyInformationZip(ThreadLocal<String> s) {DBpropertyInformationZip = s;}
	
	private static ThreadLocal<String> DBpropertyInformationSqFt;
	public static ThreadLocal<String> getDBpropertyInformationSqFt() {return DBpropertyInformationSqFt;}
	public void setDBpropertyInformationSqFt(ThreadLocal<String> s) {DBpropertyInformationSqFt = s;}
	
	private static ThreadLocal<String> DBpropertyInformationSiteSize;
	public static ThreadLocal<String> getDBpropertyInformationSiteSize() {return DBpropertyInformationSiteSize;}
	public void setDBpropertyInformationSiteSize(ThreadLocal<String> s) {DBpropertyInformationSiteSize = s;}
	
	private static ThreadLocal<String> DBpropertyInformationPropType;
	public static ThreadLocal<String> getDBpropertyInformationPropType() {return DBpropertyInformationPropType;}
	public void setDBpropertyInformationPropType(ThreadLocal<String> s) {DBpropertyInformationPropType = s;}
	
	private static ThreadLocal<String> DBpropertyInformationPropRights;
	public static ThreadLocal<String> getDBpropertyInformationPropRights() {return DBpropertyInformationPropRights;}
	public void setDBpropertyInformationPropRights(ThreadLocal<String> s) {DBpropertyInformationPropRights = s;}
	
	private static ThreadLocal<String> DBpropertyInformationLegalDesc;
	public static ThreadLocal<String> getDBpropertyInformationLegalDesc() {return DBpropertyInformationLegalDesc;}
	public void setDBpropertyInformationLegalDesc(ThreadLocal<String> s) {DBpropertyInformationLegalDesc = s;}
	
	private static ThreadLocal<String> DBpropertyInformationDirections;
	public static ThreadLocal<String> getDBpropertyInformationDirections() {return DBpropertyInformationDirections;}
	public void setDBpropertyInformationDirections(ThreadLocal<String> s) {DBpropertyInformationDirections = s;}
	
	
	// Assignment Information
	private static ThreadLocal<String> DBassignmentInformationForm;
	public static ThreadLocal<String> getDBassignmentInformationForm() {return DBassignmentInformationForm;}
	public void setDBassignmentInformationForm(ThreadLocal<String> s) {DBassignmentInformationForm = s;}
	
	private static ThreadLocal<Boolean> DBassignmentInformationRushOrder;
	public static ThreadLocal<Boolean> getDBassignmentInformationRushOrder() {return DBassignmentInformationRushOrder;}
	public void setDBassignmentInformationRushOrder(ThreadLocal<Boolean> s) {DBassignmentInformationRushOrder = s;}
	
	private static ThreadLocal<Boolean> DBassignmentInformationComplex;
	public static ThreadLocal<Boolean> getDBassignmentInformationComplex() {return DBassignmentInformationComplex;}
	public void setDBassignmentInformationComplex(ThreadLocal<Boolean> s) {DBassignmentInformationComplex = s;}
	
	private static ThreadLocal<String> DBassignmentInformationOrderDue;
	public static ThreadLocal<String> getDBassignmentInformationOrderDue() {return DBassignmentInformationOrderDue;}
	public void setDBassignmentInformationOrderDue(ThreadLocal<String> s) {DBassignmentInformationOrderDue = s;}
	
	private static ThreadLocal<String> DBassignmentInformationOtherRefNumber;
	public static ThreadLocal<String> getDBassignmentInformationOtherRefNumber() {return DBassignmentInformationOtherRefNumber;}
	public void setDBassignmentInformationOtherRefNumber(ThreadLocal<String> s) {DBassignmentInformationOtherRefNumber = s;}
	
	private static ThreadLocal<String> DBassignmentInformationLoanType;
	public static ThreadLocal<String> getDBassignmentInformationLoanType() {return DBassignmentInformationLoanType;}
	public void setDBassignmentInformationLoanType(ThreadLocal<String> s) {DBassignmentInformationLoanType = s;}
	
	private static ThreadLocal<String> DBassignmentInformationLoanPurpose;
	public static ThreadLocal<String> getDBassignmentInformationLoanPurpose() {return DBassignmentInformationLoanPurpose;}
	public void setDBassignmentInformationLoanPurpose(ThreadLocal<String> s) {DBassignmentInformationLoanPurpose = s;}
	
	private static ThreadLocal<String> DBassignmentInformationOrderedBy;
	public static ThreadLocal<String> getDBassignmentInformationOrderedBy() {return DBassignmentInformationOrderedBy;}
	public void setDBassignmentInformationOrderedBy(ThreadLocal<String> s) {DBassignmentInformationOrderedBy = s;}
	
	private static ThreadLocal<String> DBassignmentInformationOrderGroup;
	public static ThreadLocal<String> getDBassignmentInformationOrderGroup() {return DBassignmentInformationOrderGroup;}
	public void setDBassignmentInformationOrderGroup(ThreadLocal<String> s) {DBassignmentInformationOrderGroup = s;}
	
	private static ThreadLocal<String> DBassignmentInformationLoanNumber;
	public static ThreadLocal<String> getDBassignmentInformationLoanNumber() {return DBassignmentInformationLoanNumber;}
	public void setDBassignmentInformationLoanNumber(ThreadLocal<String> s) {DBassignmentInformationLoanNumber = s;}
	
	private static ThreadLocal<String> DBassignmentInformationFileNumber;
	public static ThreadLocal<String> getDBassignmentInformationFileNumber() {return DBassignmentInformationFileNumber;}
	public void setDBassignmentInformationFileNumber(ThreadLocal<String> s) {DBassignmentInformationFileNumber = s;}
	
	private static ThreadLocal<String> DBassignmentInformationSalesPrice;
	public static ThreadLocal<String> getDBassignmentInformationSalesPrice() {return DBassignmentInformationSalesPrice;}
	public void setDBassignmentInformationSalesPrice(ThreadLocal<String> s) {DBassignmentInformationSalesPrice = s;}
	
	private static ThreadLocal<String> DBassignmentInformationFHACaseNumber;
	public static ThreadLocal<String> getDBassignmentInformationFHACaseNumber() {return DBassignmentInformationFHACaseNumber;}
	public void setDBassignmentInformationFHACaseNumber(ThreadLocal<String> s) {DBassignmentInformationFHACaseNumber = s;}
	
	private static ThreadLocal<String> DBassignmentInformationDisclosure;
	public static ThreadLocal<String> getDBassignmentInformationDisclosure() {return DBassignmentInformationDisclosure;}
	public void setDBassignmentInformationDisclosure(ThreadLocal<String> s) {DBassignmentInformationDisclosure = s;}
	
	private static ThreadLocal<String> DBassignmentInformationAssignedTo;
	public static ThreadLocal<String> getDBassignmentInformationAssignedTo() {return DBassignmentInformationAssignedTo;}
	public void setDBassignmentInformationAssignedTo(ThreadLocal<String> s) {DBassignmentInformationAssignedTo = s;}
	
	private static ThreadLocal<String> DBassignmentInformationRushOrderDB;
	public static ThreadLocal<String> getDBassignmentInformationRushOrderDB() {return DBassignmentInformationRushOrderDB;}
	public void setDBassignmentInformationRushOrderDB(ThreadLocal<String> s) {DBassignmentInformationRushOrderDB = s;}
	
	private static ThreadLocal<String> DBassignmentInformationComplexDB;
	public static ThreadLocal<String> getDBassignmentInformationComplexDB() {return DBassignmentInformationComplexDB;}
	public void setDBassignmentInformationComplexDB(ThreadLocal<String> s) {DBassignmentInformationComplexDB = s;}
	
	
	// Lender Information
	private static ThreadLocal<String> DBlenderInformationLenderName;
	public static ThreadLocal<String> getDBlenderInformationLenderName() {return DBlenderInformationLenderName;}
	public void setDBlenderInformationLenderName(ThreadLocal<String> s) {DBlenderInformationLenderName = s;}
	
	private static ThreadLocal<String> DBlenderInformationAddress1;
	public static ThreadLocal<String> getDBlenderInformationAddress1() {return DBlenderInformationAddress1;}
	public void setDBlenderInformationAddress1(ThreadLocal<String> s) {DBlenderInformationAddress1 = s;}
	
	private static ThreadLocal<String> DBlenderInformationAddress2;
	public static ThreadLocal<String> getDBlenderInformationAddress2() {return DBlenderInformationAddress2;}
	public void setDBlenderInformationAddress2(ThreadLocal<String> s) {DBlenderInformationAddress2 = s;}
	
	private static ThreadLocal<String> DBlenderInformationCity;
	public static ThreadLocal<String> getDBlenderInformationCity() {return DBlenderInformationCity;}
	public void setDBlenderInformationCity(ThreadLocal<String> s) {DBlenderInformationCity = s;}
	
	private static ThreadLocal<String> DBlenderInformationState;
	public static ThreadLocal<String> getDBlenderInformationState() {return DBlenderInformationState;}
	public void setDBlenderInformationState(ThreadLocal<String> s) {DBlenderInformationState = s;}
	
	private static ThreadLocal<String> DBlenderInformationZip;
	public static ThreadLocal<String> getDBlenderInformationZip() {return DBlenderInformationZip;}
	public void setDBlenderInformationZip(ThreadLocal<String> s) {DBlenderInformationZip = s;}

	
	// Contact and Access Information
	private static ThreadLocal<String> DBcontactOccupancy;
	public static ThreadLocal<String> getDBcontactOccupancy() {return DBcontactOccupancy;}
	public void setDBcontactOccupancy(ThreadLocal<String> s) {DBcontactOccupancy = s;}
	
	private static ThreadLocal<String> DBcontactBorrower;
	public static ThreadLocal<String> getDBcontactBorrower() {return DBcontactBorrower;}
	public void setDBcontactBorrower(ThreadLocal<String> s) {DBcontactBorrower = s;}
	
	private static ThreadLocal<String> DBcontactBorrowerInfo1Dropdown;
	public static ThreadLocal<String> getDBcontactBorrowerInfo1Dropdown() {return DBcontactBorrowerInfo1Dropdown;}
	public void setDBcontactBorrowerInfo1Dropdown(ThreadLocal<String> s) {DBcontactBorrowerInfo1Dropdown = s;}
	
	private static ThreadLocal<String> DBcontactBorrowerInfo1;
	public static ThreadLocal<String> getDBcontactBorrowerInfo1() {return DBcontactBorrowerInfo1;}
	public void setDBcontactBorrowerInfo1(ThreadLocal<String> s) {DBcontactBorrowerInfo1 = s;}
	
	private static ThreadLocal<String> DBcontactBorrowerInfo2Dropdown;
	public static ThreadLocal<String> getDBcontactBorrowerInfo2Dropdown() {return DBcontactBorrowerInfo2Dropdown;}
	public void setDBcontactBorrowerInfo2Dropdown(ThreadLocal<String> s) {DBcontactBorrowerInfo2Dropdown = s;}
	
	private static ThreadLocal<String> DBcontactBorrowerInfo2;
	public static ThreadLocal<String> getDBcontactBorrowerInfo2() {return DBcontactBorrowerInfo2;}
	public void setDBcontactBorrowerInfo2(ThreadLocal<String> s) {DBcontactBorrowerInfo2 = s;}
	
	private static ThreadLocal<String> DBcontactBorrowerAddress;
	public static ThreadLocal<String> getDBcontactBorrowerAddress() {return DBcontactBorrowerAddress;}
	public void setDBcontactBorrowerAddress(ThreadLocal<String> s) {DBcontactBorrowerAddress = s;}
	
	private static ThreadLocal<String> DBcontactBorrowerCity;
	public static ThreadLocal<String> getDBcontactBorrowerCity() {return DBcontactBorrowerCity;}
	public void setDBcontactBorrowerCity(ThreadLocal<String> s) {DBcontactBorrowerCity = s;}
	
	private static ThreadLocal<String> DBcontactBorrowerState;
	public static ThreadLocal<String> getDBcontactBorrowerState() {return DBcontactBorrowerState;}
	public void setDBcontactBorrowerState(ThreadLocal<String> s) {DBcontactBorrowerState = s;}
	
	private static ThreadLocal<String> DBcontactBorrowerZip;
	public static ThreadLocal<String> getDBcontactBorrowerZip() {return DBcontactBorrowerZip;}
	public void setDBcontactBorrowerZip(ThreadLocal<String> s) {DBcontactBorrowerZip = s;}
	
	private static ThreadLocal<String> DBcontactCoBorrower;
	public static ThreadLocal<String> getDBcontactCoBorrower() {return DBcontactCoBorrower;}
	public void setDBcontactCoBorrower(ThreadLocal<String> s) {DBcontactCoBorrower = s;}
	
	private static ThreadLocal<String> DBcontactCoBorrowerInfo1Dropdown;
	public static ThreadLocal<String> getDBcontactCoBorrowerInfo1Dropdown() {return DBcontactCoBorrowerInfo1Dropdown;}
	public void setDBcontactCoBorrowerInfo1Dropdown(ThreadLocal<String> s) {DBcontactCoBorrowerInfo1Dropdown = s;}
	
	private static ThreadLocal<String> DBcontactCoBorrowerInfo1;
	public static ThreadLocal<String> getDBcontactCoBorrowerInfo1() {return DBcontactCoBorrowerInfo1;}
	public void setDBcontactCoBorrowerInfo1(ThreadLocal<String> s) {DBcontactCoBorrowerInfo1 = s;}
	
	private static ThreadLocal<String> DBcontactCoBorrowerInfo2Dropdown;
	public static ThreadLocal<String> getDBcontactCoBorrowerInfo2Dropdown() {return DBcontactCoBorrowerInfo2Dropdown;}
	public void setDBcontactCoBorrowerInfo2Dropdown(ThreadLocal<String> s) {DBcontactCoBorrowerInfo2Dropdown = s;}
	
	private static ThreadLocal<String> DBcontactCoBorrowerInfo2;
	public static ThreadLocal<String> getDBcontactCoBorrowerInfo2() {return DBcontactCoBorrowerInfo2;}
	public void setDBcontactCoBorrowerInfo2(ThreadLocal<String> s) {DBcontactCoBorrowerInfo2 = s;}
	
	private static ThreadLocal<String> DBcontactCoBorrowerAddress;
	public static ThreadLocal<String> getDBcontactCoBorrowerAddress() {return DBcontactCoBorrowerAddress;}
	public void setDBcontactCoBorrowerAddress(ThreadLocal<String> s) {DBcontactCoBorrowerAddress = s;}
	
	private static ThreadLocal<String> DBcontactCoBorrowerCity;
	public static ThreadLocal<String> getDBcontactCoBorrowerCity() {return DBcontactCoBorrowerCity;}
	public void setDBcontactCoBorrowerCity(ThreadLocal<String> s) {DBcontactCoBorrowerCity = s;}
	
	private static ThreadLocal<String> DBcontactCoBorrowerState;
	public static ThreadLocal<String> getDBcontactCoBorrowerState() {return DBcontactCoBorrowerState;}
	public void setDBcontactCoBorrowerState(ThreadLocal<String> s) {DBcontactCoBorrowerState = s;}
	
	private static ThreadLocal<String> DBcontactCoBorrowerZip;
	public static ThreadLocal<String> getDBcontactCoBorrowerZip() {return DBcontactCoBorrowerZip;}
	public void setDBcontactCoBorrowerZip(ThreadLocal<String> s) {DBcontactCoBorrowerZip = s;}
	
	private static ThreadLocal<String> DBcontactOwner;
	public static ThreadLocal<String> getDBcontactOwner() {return DBcontactOwner;}
	public void setDBcontactOwner(ThreadLocal<String> s) {DBcontactOwner = s;}
	
	private static ThreadLocal<String> DBcontactOwnerInfo1Dropdown;
	public static ThreadLocal<String> getDBcontactOwnerInfo1Dropdown() {return DBcontactOwnerInfo1Dropdown;}
	public void setDBcontactOwnerInfo1Dropdown(ThreadLocal<String> s) {DBcontactOwnerInfo1Dropdown = s;}
	
	private static ThreadLocal<String> DBcontactOwnerInfo1;
	public static ThreadLocal<String> getDBcontactOwnerInfo1() {return DBcontactOwnerInfo1;}
	public void setDBcontactOwnerInfo1(ThreadLocal<String> s) {DBcontactOwnerInfo1 = s;}
	
	private static ThreadLocal<String> DBcontactOwnerInfo2Dropdown;
	public static ThreadLocal<String> getDBcontactOwnerInfo2Dropdown() {return DBcontactOwnerInfo2Dropdown;}
	public void setDBcontactOwnerInfo2Dropdown(ThreadLocal<String> s) {DBcontactOwnerInfo2Dropdown = s;}
	
	private static ThreadLocal<String> DBcontactOwnerInfo2;
	public static ThreadLocal<String> getDBcontactOwnerInfo2() {return DBcontactOwnerInfo2;}
	public void setDBcontactOwnerInfo2(ThreadLocal<String> s) {DBcontactOwnerInfo2 = s;}
	
	private static ThreadLocal<String> DBcontactOccupant;
	public static ThreadLocal<String> getDBcontactOccupant() {return DBcontactOccupant;}
	public void setDBcontactOccupant(ThreadLocal<String> s) {DBcontactOccupant = s;}
	
	private static ThreadLocal<String> DBcontactOccupantInfo1Dropdown;
	public static ThreadLocal<String> getDBcontactOccupantInfo1Dropdown() {return DBcontactOccupantInfo1Dropdown;}
	public void setDBcontactOccupantInfo1Dropdown(ThreadLocal<String> s) {DBcontactOccupantInfo1Dropdown = s;}
	
	private static ThreadLocal<String> DBcontactOccupantInfo1;
	public static ThreadLocal<String> getDBcontactOccupantInfo1() {return DBcontactOccupantInfo1;}
	public void setDBcontactOccupantInfo1(ThreadLocal<String> s) {DBcontactOccupantInfo1 = s;}
	
	private static ThreadLocal<String> DBcontactOccupantInfo2Dropdown;
	public static ThreadLocal<String> getDBcontactOccupantInfo2Dropdown() {return DBcontactOccupantInfo2Dropdown;}
	public void setDBcontactOccupantInfo2Dropdown(ThreadLocal<String> s) {DBcontactOccupantInfo2Dropdown = s;}
	
	private static ThreadLocal<String> DBcontactOccupantInfo2;
	public static ThreadLocal<String> getDBcontactOccupantInfo2() {return DBcontactOccupantInfo2;}
	public void setDBcontactOccupantInfo2(ThreadLocal<String> s) {DBcontactOccupantInfo2 = s;}
	
	private static ThreadLocal<String> DBcontactAgent;
	public static ThreadLocal<String> getDBcontactAgent() {return DBcontactAgent;}
	public void setDBcontactAgent(ThreadLocal<String> s) {DBcontactAgent = s;}
	
	private static ThreadLocal<String> DBcontactAgentInfo1Dropdown;
	public static ThreadLocal<String> getDBcontactAgentInfo1Dropdown() {return DBcontactAgentInfo1Dropdown;}
	public void setDBcontactAgentInfo1Dropdown(ThreadLocal<String> s) {DBcontactAgentInfo1Dropdown = s;}
	
	private static ThreadLocal<String> DBcontactAgentInfo1;
	public static ThreadLocal<String> getDBcontactAgentInfo1() {return DBcontactAgentInfo1;}
	public void setDBcontactAgentInfo1(ThreadLocal<String> s) {DBcontactAgentInfo1 = s;}
	
	private static ThreadLocal<String> DBcontactAgentInfo2Dropdown;
	public static ThreadLocal<String> getDBcontactAgentInfo2Dropdown() {return DBcontactAgentInfo2Dropdown;}
	public void setDBcontactAgentInfo2Dropdown(ThreadLocal<String> s) {DBcontactAgentInfo2Dropdown = s;}
	
	private static ThreadLocal<String> DBcontactAgentInfo2;
	public static ThreadLocal<String> getDBcontactAgentInfo2() {return DBcontactAgentInfo2;}
	public void setDBcontactAgentInfo2(ThreadLocal<String> s) {DBcontactAgentInfo2 = s;}
	
	private static ThreadLocal<String> DBcontactOther;
	public static ThreadLocal<String> getDBcontactOther() {return DBcontactOther;}
	public void setDBcontactOther(ThreadLocal<String> s) {DBcontactOther = s;}
	
	private static ThreadLocal<String> DBcontactOtherInfo1Dropdown;
	public static ThreadLocal<String> getDBcontactOtherInfo1Dropdown() {return DBcontactOtherInfo1Dropdown;}
	public void setDBcontactOtherInfo1Dropdown(ThreadLocal<String> s) {DBcontactOtherInfo1Dropdown = s;}
	
	private static ThreadLocal<String> DBcontactOtherInfo1;
	public static ThreadLocal<String> getDBcontactOtherInfo1() {return DBcontactOtherInfo1;}
	public void setDBcontactOtherInfo1(ThreadLocal<String> s) {DBcontactOtherInfo1 = s;}
	
	private static ThreadLocal<String> DBcontactOtherInfo2Dropdown;
	public static ThreadLocal<String> getDBcontactOtherInfo2Dropdown() {return DBcontactOtherInfo2Dropdown;}
	public void setDBcontactOtherInfo2Dropdown(ThreadLocal<String> s) {DBcontactOtherInfo2Dropdown = s;}
	
	private static ThreadLocal<String> DBcontactOtherInfo2;
	public static ThreadLocal<String> getDBcontactOtherInfo2() {return DBcontactOtherInfo2;}
	public void setDBcontactOtherInfo2(ThreadLocal<String> s) {DBcontactOtherInfo2 = s;}

	private static ThreadLocal<String> DBcontactApptContact;
	public static ThreadLocal<String> getDBcontactApptContact() {return DBcontactApptContact;}
	public void setDBcontactApptContact(ThreadLocal<String> s) {DBcontactApptContact = s;}
	
	
	// Additional Notification Recipients
	private static ThreadLocal<String> DBadditionalNotificationRecipientsAdditionalEmails;
	public static ThreadLocal<String> getDBadditionalNotificationRecipientsAdditionalEmails() {return DBadditionalNotificationRecipientsAdditionalEmails;}
	public void setDBadditionalNotificationRecipientsAdditionalEmails(ThreadLocal<String> s) {DBadditionalNotificationRecipientsAdditionalEmails = s;}
	
	private static ThreadLocal<Boolean> DBadditionalNotificationRecipientsAttachCompletedReport;
	public static ThreadLocal<Boolean> getDBadditionalNotificationRecipientsAttachCompletedReport() {return DBadditionalNotificationRecipientsAttachCompletedReport;}
	public void setDBadditionalNotificationRecipientsAttachCompletedReport(ThreadLocal<Boolean> s) {DBadditionalNotificationRecipientsAttachCompletedReport = s;}
	
	
}
