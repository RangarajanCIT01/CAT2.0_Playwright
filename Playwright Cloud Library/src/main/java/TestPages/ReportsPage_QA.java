package TestPages;

import com.microsoft.playwright.Page;

import PlaywrightFactory.PlaywrightFactory;

public class ReportsPage_QA extends PlaywrightFactory {

	public ReportsPage_QA(Page page) {
		this.page = page;
	}

	/** WELCOME **/
	
	public String txtUsrName = "UserName";
	public String txtPswd = "Password";
	public String btnLogOn = "//input[@value='Log On']";
	
	/****** Circulation Summary ****/
	public String lnkReports = "//a[text='Reports']";
	public String lnkCirculationSummary = "//a[text='Circulation Comparison']";
	public String StartDate = "//input[@id='StartDate']";
	public String EndDate = "//input[@id='EndDate']";
	public String btnSearch = "//input[@value='Search']";
	public String txtContProv = "//td[text='Content Provider']";
	public String txtTotalItems = "//b[@class='dxp-lead dxp-summary']";
	
	/****** Purchase History ****/
	public String lnkPurchaseHistory = "//a[text='Purchase History']";
	public String txtLibrary = "//td[text='Library']";
	
	/****** Content Expiration ****/
	public String lnkContentExpiration = "//a[text='Content Expiration']";
	public String txtLibraryName = "//td[text='Library Name']";
	
	/****** Library Current Stock ****/
	public String lnkLibraryCurrentStock = "//a[text='Library Current Stock']";
	
	/****** PPU Activity ****/
	public String lnkPPUActivity = "//a[text='PPU Activity']";
	public String txtPatron = "//td[text='Patron']";
	
	/****** PPU Titles ****/
	public String lnkPPUTitles = "//a[text='PPU Titles']";
	public String txtTitle = "//td[text='Title']";
	
	/****** Hold Ratio ****/
	public String lnkHoldsRatio = "//a[text='Holds Ratio']";
	
	/****** Patron Utilization ****/
	public String lnkPatronUtilization = "//a[text='Patron Utilization']";
	
	/****** Current Suggestions ****/
	public String lnkSuggestionsList = "//a[text='Suggestions List']";
	
	/****** Top Circulating ****/
	public String lnkTopCirculating = "//a[text='Top Circulating']";
	public String country = "//select[@id='CountryId']";
	
	/****** Top Purchased ****/
	public String lnkTopPurchased = "//a[text='Top Purchased']";
	
	/****** Consortia Patron Activity ****/
	public String lnkConsortiaPatronActivity = "//a[text='Consortia Patron Activity']";
	public String txtPatLibName = "//td[text='Patron Library Name']";
	
	/****** Consortia Content Activity ****/
	public String lnkConsortiaContentActivity = "//a[text='Consortia Content Activity']";
	
	/****** Consortia Group Patron Activity ****/
	public String lnkConsortiaGroupPatronActivity = "//a[text='Consortia Group Patron Activity']";
	
	/****** Consortia Group Content Activity ****/
	public String lnkConsortiaGroupContentActivity = "//a[text='Consortia Group Content Activity']";
	
	/****** Library Sales Summary ****/
	public String lnkLibrarySalesSummary = "//a[text='Library Sales Summary']";
	public String txtLibID = "//td[text='Library Id']";
	
	/****** Library Reports ****/
	public String lnkLibraryReports = "//a[text='Library Reports']";
	public String lnkReportsLib = "//a[text='ReportsLibrary']";
	public String lnkUATLib = "//a[text='UATLibrary']";
	public String lblReports = "//b[text='Files In ReportsLibrary']";
	public String lblUAT = "//b[text='Files In UATLibrary']";
	
	/****** MARC Request****/
	public String lnkMarcRequest = "//a[text='MARC Request']";
	public String lblMarcRequest = "//h2[text='MARC Request']";
	
	/****** Collection HQ****/
	public String lnkCollectionHQ = "//a[text='collectionHQ']";
	public String lblAuthor = "//td[text='author']";
	
	
}
