package TestCases;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
/*
import Helper.DataInputProvider;
import Helper.Efficacies;
import Helper.ExtentTestManager;
import Helper.StartApp;
import ReportsPages.ReportsPage;
import WPT.WPTSetUp;
import WebPages.WPTBasePage;
import WebPages.WPTSanityPage;
*/
public class ReportsTest_PROD {
	/*
	public StartApp startApp;
	public Efficacies eff;
	public ReportsPage reportsPage;
	public WPTBasePage basePageWeb;
	public WebDriver web_driver;
	
	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		startApp = new StartApp();
		eff = new Efficacies();
		web_driver = startApp.startApp_ReportsPROD();
		reportsPage = new ReportsPage(web_driver);
		basePageWeb = new WPTBasePage(web_driver);
		
		Map<String, String> testData = eff.readJsonElement("SetUp_ReportsPROD.json", "verify_ReportTest");
	
		basePageWeb.enterText(reportsPage.txtUsrName, testData.get("UserName"));
		basePageWeb.enterText(reportsPage.txtPswd, testData.get("Password"));
		basePageWeb.clickElement(reportsPage.btnLogOn);
	}
	
	 @AfterClass(alwaysRun = true) 
	  public void tearDown() throws Exception { 
	  startApp.closeDriver_Web(); 
	  }

	@Test
	public void verify_CirculationSummary() throws Exception {
			
		Map<String, String> testData = eff.readJsonElement("SetUp_ReportsPROD.json", "verify_CirculationSummary");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		basePageWeb.clickElement(reportsPage.lnkReports);
		basePageWeb.clickElement(reportsPage.lnkCirculationSummary);
		basePageWeb.clearAndEnterText(reportsPage.StartDate, testData.get("StartDate"));
		basePageWeb.clearAndEnterText(reportsPage.EndDate, testData.get("EndDate"));
		basePageWeb.clickElement(reportsPage.btnSearch);
		
		actualData.add(basePageWeb.getElement(reportsPage.txtContProv).getText());
		expectedData.add(testData.get("TextContProvider"));
		
		actualData.add(basePageWeb.getElement(reportsPage.txtTotalItems).getText());
		expectedData.add(testData.get("TotalItems"));
		
		Assert.assertEquals(expectedData, actualData);
	}	
	
	@Test
	public void verify_PurchaseHistory() throws Exception {
		
		Map<String, String> testData = eff.readJsonElement("SetUp_ReportsPROD.json", "verify_PurchaseHistory");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		basePageWeb.clickElement(reportsPage.lnkReports);
		basePageWeb.clickElement(reportsPage.lnkPurchaseHistory);
		basePageWeb.clearAndEnterText(reportsPage.StartDate, testData.get("StartDate"));
		basePageWeb.clearAndEnterText(reportsPage.EndDate, testData.get("EndDate"));
		basePageWeb.clickElement(reportsPage.btnSearch);
		
		actualData.add(basePageWeb.getElement(reportsPage.txtLibrary).getText());
		expectedData.add(testData.get("TextLibrary"));
		
		actualData.add(basePageWeb.getElement(reportsPage.txtTotalItems).getText());
		expectedData.add(testData.get("TotalItems"));
		
		Assert.assertEquals(expectedData, actualData);
		
	}	
	
	@Test
	public void verify_ContentExpiration() throws Exception {
		
		Map<String, String> testData = eff.readJsonElement("SetUp_ReportsPROD.json", "verify_ContentExpiration");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		basePageWeb.clickElement(reportsPage.lnkReports);
		basePageWeb.clickElement(reportsPage.lnkContentExpiration);
		basePageWeb.clickElement(reportsPage.btnSearch);
		
		actualData.add(basePageWeb.getElement(reportsPage.txtLibraryName).getText());
		expectedData.add(testData.get("TextLibraryName"));
			
		Assert.assertEquals(expectedData, actualData);
	}	
	
	@Test
	public void verify_LibraryCurrentStock() throws Exception {
		
		Map<String, String> testData = eff.readJsonElement("SetUp_ReportsPROD.json", "verify_LibraryCurrentStock");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		basePageWeb.clickElement(reportsPage.lnkReports);
		basePageWeb.clickElement(reportsPage.lnkLibraryCurrentStock);
		basePageWeb.clickElement(reportsPage.btnSearch);
		
		actualData.add(basePageWeb.getElement(reportsPage.txtLibrary).getText());
		expectedData.add(testData.get("TextLibrary"));
			
		Assert.assertEquals(expectedData, actualData);
	}
	
	@Test
	public void verify_PPUActivity() throws Exception {
		
		Map<String, String> testData = eff.readJsonElement("SetUp_ReportsPROD.json", "verify_PPUActivity");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		basePageWeb.clickElement(reportsPage.lnkReports);
		basePageWeb.clickElement(reportsPage.lnkPPUActivity);
		basePageWeb.clearAndEnterText(reportsPage.StartDate, testData.get("StartDate"));
		basePageWeb.clearAndEnterText(reportsPage.EndDate, testData.get("EndDate"));
		basePageWeb.clickElement(reportsPage.btnSearch);
		
		actualData.add(basePageWeb.getElement(reportsPage.txtPatron).getText());
		expectedData.add(testData.get("TextPatron"));
		
		actualData.add(basePageWeb.getElement(reportsPage.txtTotalItems).getText());
		expectedData.add(testData.get("TotalItems"));
			
		Assert.assertEquals(expectedData, actualData);
	}
	
	@Test
	public void verify_PPUTitles() throws Exception {
		
		Map<String, String> testData = eff.readJsonElement("SetUp_ReportsPROD.json", "verify_PPUTitles");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		basePageWeb.clickElement(reportsPage.lnkReports);
		basePageWeb.clickElement(reportsPage.lnkPPUTitles);
		basePageWeb.clearAndEnterText(reportsPage.StartDate, testData.get("StartDate"));
		basePageWeb.clearAndEnterText(reportsPage.EndDate, testData.get("EndDate"));
		basePageWeb.clickElement(reportsPage.btnSearch);
		
		actualData.add(basePageWeb.getElement(reportsPage.txtTitle).getText());
		expectedData.add(testData.get("TextTitle"));
		
		actualData.add(basePageWeb.getElement(reportsPage.txtTotalItems).getText());
		expectedData.add(testData.get("TotalItems"));
			
		Assert.assertEquals(expectedData, actualData);
	}
	
	@Test
	public void verify_HoldRatio() throws Exception {
		
		Map<String, String> testData = eff.readJsonElement("SetUp_ReportsPROD.json", "verify_HoldRatio");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		basePageWeb.clickElement(reportsPage.lnkReports);
		basePageWeb.clickElement(reportsPage.lnkHoldsRatio);
		basePageWeb.clickElement(reportsPage.btnSearch);
		
		actualData.add(basePageWeb.getElement(reportsPage.txtTitle).getText());
		expectedData.add(testData.get("TextTitle"));
		
		Assert.assertEquals(expectedData, actualData);
	}
	
	@Test
	public void verify_PatronUtilization() throws Exception {
		
		Map<String, String> testData = eff.readJsonElement("SetUp_ReportsPROD.json", "verify_PatronUtilization");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		basePageWeb.clickElement(reportsPage.lnkReports);
		basePageWeb.clickElement(reportsPage.lnkPatronUtilization);
		basePageWeb.clearAndEnterText(reportsPage.StartDate, testData.get("StartDate"));
		basePageWeb.clearAndEnterText(reportsPage.EndDate, testData.get("EndDate"));
		basePageWeb.clickElement(reportsPage.btnSearch);
		
		actualData.add(basePageWeb.getElement(reportsPage.txtPatron).getText());
		expectedData.add(testData.get("TextPatron"));
		
		actualData.add(basePageWeb.getElement(reportsPage.txtTotalItems).getText());
		expectedData.add(testData.get("TotalItems"));
			
		Assert.assertEquals(expectedData, actualData);
	}
	
	@Test
	public void verify_SuggestionsList() throws Exception {
		
		Map<String, String> testData = eff.readJsonElement("SetUp_ReportsPROD.json", "verify_SuggestionsList");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		basePageWeb.clickElement(reportsPage.lnkReports);
		basePageWeb.clickElement(reportsPage.lnkSuggestionsList);
		basePageWeb.clearAndEnterText(reportsPage.StartDate, testData.get("StartDate"));
		basePageWeb.clearAndEnterText(reportsPage.EndDate, testData.get("EndDate"));
		basePageWeb.clickElement(reportsPage.btnSearch);
		
		actualData.add(basePageWeb.getElement(reportsPage.txtTitle).getText());
		expectedData.add(testData.get("TextTitle"));
		
		actualData.add(basePageWeb.getElement(reportsPage.txtTotalItems).getText());
		expectedData.add(testData.get("TotalItems"));
			
		Assert.assertEquals(expectedData, actualData);
	}
	
	@Test
	public void verify_TopCirculating() throws Exception {
		
		Map<String, String> testData = eff.readJsonElement("SetUp_ReportsPROD.json", "verify_TopCirculating");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		basePageWeb.clickElement(reportsPage.lnkReports);
		basePageWeb.clickElement(reportsPage.lnkTopCirculating);
		basePageWeb.clearAndEnterText(reportsPage.StartDate, testData.get("StartDate"));
		basePageWeb.clearAndEnterText(reportsPage.EndDate, testData.get("EndDate"));
		basePageWeb.dropdwnSelection(reportsPage.country, testData.get("Country"));
		basePageWeb.clickElement(reportsPage.btnSearch);
		
		actualData.add(basePageWeb.getElement(reportsPage.txtTitle).getText());
		expectedData.add(testData.get("TextTitle"));
		
		actualData.add(basePageWeb.getElement(reportsPage.txtTotalItems).getText());
		expectedData.add(testData.get("TotalItems"));
			
		Assert.assertEquals(expectedData, actualData);
	}
	
	@Test
	public void verify_ConsortiaPatronActivity() throws Exception {
		
		Map<String, String> testData = eff.readJsonElement("SetUp_ReportsPROD.json", "verify_ConsortiaPatronActivity");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		basePageWeb.clickElement(reportsPage.lnkReports);
		basePageWeb.clickElement(reportsPage.lnkConsortiaPatronActivity);
		basePageWeb.clearAndEnterText(reportsPage.StartDate, testData.get("StartDate"));
		basePageWeb.clearAndEnterText(reportsPage.EndDate, testData.get("EndDate"));
		basePageWeb.clickElement(reportsPage.btnSearch);
		
		actualData.add(basePageWeb.getElement(reportsPage.txtPatLibName).getText());
		expectedData.add(testData.get("TextPatLibName"));
		
		actualData.add(basePageWeb.getElement(reportsPage.txtTotalItems).getText());
		expectedData.add(testData.get("TotalItems"));
			
		Assert.assertEquals(expectedData, actualData);
	}
	
	@Test
	public void verify_ConsortiaContentActivity() throws Exception {
		
		Map<String, String> testData = eff.readJsonElement("SetUp_ReportsPROD.json", "verify_ConsortiaContentActivity");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		basePageWeb.clickElement(reportsPage.lnkReports);
		basePageWeb.clickElement(reportsPage.lnkConsortiaContentActivity);
		basePageWeb.clearAndEnterText(reportsPage.StartDate, testData.get("StartDate"));
		basePageWeb.clearAndEnterText(reportsPage.EndDate, testData.get("EndDate"));
		basePageWeb.clickElement(reportsPage.btnSearch);
		
		actualData.add(basePageWeb.getElement(reportsPage.txtPatLibName).getText());
		expectedData.add(testData.get("TextPatLibName"));
		
		actualData.add(basePageWeb.getElement(reportsPage.txtTotalItems).getText());
		expectedData.add(testData.get("TotalItems"));
			
		Assert.assertEquals(expectedData, actualData);
	}
	
	@Test
	public void verify_ConsortiaGroupPatronActivity() throws Exception {
		
		Map<String, String> testData = eff.readJsonElement("SetUp_ReportsPROD.json", "verify_ConsortiaGroupPatronActivity");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		basePageWeb.clickElement(reportsPage.lnkReports);
		basePageWeb.clickElement(reportsPage.lnkConsortiaGroupPatronActivity);
		basePageWeb.clickElement(reportsPage.btnSearch);
		
		actualData.add(basePageWeb.getElement(reportsPage.txtPatLibName).getText());
		expectedData.add(testData.get("TextPatLibName"));
	
		Assert.assertEquals(expectedData, actualData);
	}
	
	@Test
	public void verify_ConsortiaGroupContentActivity() throws Exception {
		
		Map<String, String> testData = eff.readJsonElement("SetUp_ReportsPROD.json", "verify_ConsortiaGroupContentActivity");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		basePageWeb.clickElement(reportsPage.lnkReports);
		basePageWeb.clickElement(reportsPage.lnkConsortiaGroupContentActivity);
		basePageWeb.clearAndEnterText(reportsPage.StartDate, testData.get("StartDate"));
		basePageWeb.clearAndEnterText(reportsPage.EndDate, testData.get("EndDate"));
		basePageWeb.clickElement(reportsPage.btnSearch);
		
		actualData.add(basePageWeb.getElement(reportsPage.txtTitle).getText());
		expectedData.add(testData.get("TextTitle"));
		
		actualData.add(basePageWeb.getElement(reportsPage.txtTotalItems).getText());
		expectedData.add(testData.get("TotalItems"));
			
		Assert.assertEquals(expectedData, actualData);
	}
	
	@Test
	public void verify_LibrarySalesSummary() throws Exception {
		
		Map<String, String> testData = eff.readJsonElement("SetUp_ReportsPROD.json", "verify_LibrarySalesSummary");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		basePageWeb.clickElement(reportsPage.lnkReports);
		basePageWeb.clickElement(reportsPage.lnkLibrarySalesSummary);
		basePageWeb.clearAndEnterText(reportsPage.StartDate, testData.get("StartDate"));
		basePageWeb.clearAndEnterText(reportsPage.EndDate, testData.get("EndDate"));
		basePageWeb.clickElement(reportsPage.btnSearch);
		
		actualData.add(basePageWeb.getElement(reportsPage.txtLibID).getText());
		expectedData.add(testData.get("TextLibID"));
		
		actualData.add(basePageWeb.getElement(reportsPage.txtTotalItems).getText());
		expectedData.add(testData.get("TotalItems"));
			
		Assert.assertEquals(expectedData, actualData);
	}
	
	@Test
	public void verify_LibraryReports() throws Exception {
		
		Map<String, String> testData = eff.readJsonElement("SetUp_ReportsPROD.json", "verify_LibraryReports");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		basePageWeb.clickElement(reportsPage.lnkReports);
		basePageWeb.clickElement(reportsPage.lnkLibraryReports);
		basePageWeb.clickElement(reportsPage.lnkUATLib);
		
		actualData.add(basePageWeb.getElement(reportsPage.lblUAT).getText());
		expectedData.add(testData.get("TextUAT"));
					
		Assert.assertEquals(expectedData, actualData);
	}
	
	@Test
	public void verify_MARCRequest() throws Exception {
		
		Map<String, String> testData = eff.readJsonElement("SetUp_ReportsPROD.json", "verify_MARCRequest");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		basePageWeb.clickElement(reportsPage.lnkReports);
		basePageWeb.clickElement(reportsPage.lnkMarcRequest);
		
		actualData.add(basePageWeb.getElement(reportsPage.lblMarcRequest).getText());
		expectedData.add(testData.get("TextMARCReports"));
		
		actualData.add(basePageWeb.getElement(reportsPage.txtLibrary).getText());
		expectedData.add(testData.get("TextLibrary"));		
					
		Assert.assertEquals(expectedData, actualData);
	}
	
	@Test
	public void verify_CollectionHQ() throws Exception {
		
		Map<String, String> testData = eff.readJsonElement("SetUp_ReportsPROD.json", "verify_CollectionHQ");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		basePageWeb.clickElement(reportsPage.lnkReports);
		basePageWeb.clickElement(reportsPage.lnkCollectionHQ);
		basePageWeb.clickElement(reportsPage.btnSearch);
		
		actualData.add(basePageWeb.getElement(reportsPage.lblAuthor).getText());
		expectedData.add(testData.get("TextAuthor"));
		
		Assert.assertEquals(expectedData, actualData);
	}
	*/
}
