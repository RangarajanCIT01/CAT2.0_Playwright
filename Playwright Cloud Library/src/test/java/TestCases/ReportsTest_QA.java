package TestCases;

import java.util.ArrayList;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.PlaywrightFactory;

public class ReportsTest_QA extends PlaywrightFactory {
	
	
	@Test(groups = "Reports", description = "Validate Authentication by entering Valid Credentials")
	public void verify_CirculationSummary() throws Exception {
		
		//ExtentTestManager.getTest().assignCategory("Reports");
		Map<String, String> testData = baseTest.readJsonElement("SetUp_Reports.json", "verify_CirculationSummary");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		//ExtentTestManager.getTest().info("Wait for spinner to Complete..");
		reportsPageQA.clickElement(reportsPageQA.lnkReports);
		reportsPageQA.clickElement(reportsPageQA.lnkCirculationSummary);
		reportsPageQA.clearAndfillText(reportsPageQA.StartDate, testData.get("StartDate"));
		reportsPageQA.clearAndfillText(reportsPageQA.EndDate, testData.get("EndDate"));
		reportsPageQA.clickElement(reportsPageQA.btnSearch);
		
		actualData.add(page.locator(searchpage.cartAddedSuccessfully).textContent());
		actualData.add(page.locator(reportsPageQA.txtContProv).textContent());
		expectedData.add(testData.get("TextContProvider"));
		
		actualData.add(page.locator(reportsPageQA.txtTotalItems).textContent());
		expectedData.add(testData.get("TotalItems"));
		
		Assert.assertEquals(expectedData, actualData);
		//ExtentTestManager.getTest().info("Verify Login is successfull - " + ExtentTestManager.getTest().getStatus());
		
	}	
	
	@Test
	public void verify_PurchaseHistory() throws Exception {
		
		Map<String, String> testData = baseTest.readJsonElement("SetUp_Reports.json", "verify_PurchaseHistory");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		reportsPageQA.clickElement(reportsPageQA.lnkReports);
		reportsPageQA.clickElement(reportsPageQA.lnkPurchaseHistory);
		reportsPageQA.clearAndfillText(reportsPageQA.StartDate, testData.get("StartDate"));
		reportsPageQA.clearAndfillText(reportsPageQA.EndDate, testData.get("EndDate"));
		reportsPageQA.clickElement(reportsPageQA.btnSearch);
		
		actualData.add(page.locator(reportsPageQA.txtLibrary).textContent());
		expectedData.add(testData.get("TextLibrary"));
		
		actualData.add(page.locator(reportsPageQA.txtTotalItems).textContent());
		expectedData.add(testData.get("TotalItems"));
		
		Assert.assertEquals(expectedData, actualData);
		
	}	
	
	@Test
	public void verify_ContentExpiration() throws Exception {
		
		Map<String, String> testData = baseTest.readJsonElement("SetUp_Reports.json", "verify_ContentExpiration");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		reportsPageQA.clickElement(reportsPageQA.lnkReports);
		reportsPageQA.clickElement(reportsPageQA.lnkContentExpiration);
		reportsPageQA.clickElement(reportsPageQA.btnSearch);
		
		actualData.add(page.locator(reportsPageQA.txtLibraryName).textContent());
		expectedData.add(testData.get("TextLibraryName"));
			
		Assert.assertEquals(expectedData, actualData);
	}	
	
	@Test
	public void verify_LibraryCurrentStock() throws Exception {
		
		Map<String, String> testData = baseTest.readJsonElement("SetUp_Reports.json", "verify_LibraryCurrentStock");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		reportsPageQA.clickElement(reportsPageQA.lnkReports);
		reportsPageQA.clickElement(reportsPageQA.lnkLibraryCurrentStock);
		reportsPageQA.clickElement(reportsPageQA.btnSearch);
		
		actualData.add(page.locator(reportsPageQA.txtLibrary).textContent());
		expectedData.add(testData.get("TextLibrary"));
			
		Assert.assertEquals(expectedData, actualData);
	}
	
	@Test
	public void verify_PPUActivity() throws Exception {
		
		Map<String, String> testData = baseTest.readJsonElement("SetUp_Reports.json", "verify_PPUActivity");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		reportsPageQA.clickElement(reportsPageQA.lnkReports);
		reportsPageQA.clickElement(reportsPageQA.lnkPPUActivity);
		reportsPageQA.clearAndfillText(reportsPageQA.StartDate, testData.get("StartDate"));
		reportsPageQA.clearAndfillText(reportsPageQA.EndDate, testData.get("EndDate"));
		reportsPageQA.clickElement(reportsPageQA.btnSearch);
		
		actualData.add(page.locator(reportsPageQA.txtPatron).textContent());
		expectedData.add(testData.get("TextPatron"));
		
		actualData.add(page.locator(reportsPageQA.txtTotalItems).textContent());
		expectedData.add(testData.get("TotalItems"));
			
		Assert.assertEquals(expectedData, actualData);
	}
	
	@Test
	public void verify_PPUTitles() throws Exception {
		
		Map<String, String> testData = baseTest.readJsonElement("SetUp_Reports.json", "verify_PPUTitles");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		reportsPageQA.clickElement(reportsPageQA.lnkReports);
		reportsPageQA.clickElement(reportsPageQA.lnkPPUTitles);
		reportsPageQA.clearAndfillText(reportsPageQA.StartDate, testData.get("StartDate"));
		reportsPageQA.clearAndfillText(reportsPageQA.EndDate, testData.get("EndDate"));
		reportsPageQA.clickElement(reportsPageQA.btnSearch);
		
		actualData.add(page.locator(reportsPageQA.txtTitle).textContent());
		expectedData.add(testData.get("TextTitle"));
		
		actualData.add(page.locator(reportsPageQA.txtTotalItems).textContent());
		expectedData.add(testData.get("TotalItems"));
			
		Assert.assertEquals(expectedData, actualData);
	}
	
	@Test
	public void verify_HoldRatio() throws Exception {
		
		Map<String, String> testData = baseTest.readJsonElement("SetUp_Reports.json", "verify_HoldRatio");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		reportsPageQA.clickElement(reportsPageQA.lnkReports);
		reportsPageQA.clickElement(reportsPageQA.lnkHoldsRatio);
		reportsPageQA.clickElement(reportsPageQA.btnSearch);
		
		actualData.add(page.locator(reportsPageQA.txtTitle).textContent());
		expectedData.add(testData.get("TextTitle"));
		
		Assert.assertEquals(expectedData, actualData);
	}
	
	@Test
	public void verify_PatronUtilization() throws Exception {
		
		Map<String, String> testData = baseTest.readJsonElement("SetUp_Reports.json", "verify_PatronUtilization");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		reportsPageQA.clickElement(reportsPageQA.lnkReports);
		reportsPageQA.clickElement(reportsPageQA.lnkPatronUtilization);
		reportsPageQA.clearAndfillText(reportsPageQA.StartDate, testData.get("StartDate"));
		reportsPageQA.clearAndfillText(reportsPageQA.EndDate, testData.get("EndDate"));
		reportsPageQA.clickElement(reportsPageQA.btnSearch);
		
		actualData.add(page.locator(reportsPageQA.txtPatron).textContent());
		expectedData.add(testData.get("TextPatron"));
		
		actualData.add(page.locator(reportsPageQA.txtTotalItems).textContent());
		expectedData.add(testData.get("TotalItems"));
			
		Assert.assertEquals(expectedData, actualData);
	}
	
	@Test
	public void verify_SuggestionsList() throws Exception {
		
		Map<String, String> testData = baseTest.readJsonElement("SetUp_Reports.json", "verify_SuggestionsList");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		reportsPageQA.clickElement(reportsPageQA.lnkReports);
		reportsPageQA.clickElement(reportsPageQA.lnkSuggestionsList);
		reportsPageQA.clearAndfillText(reportsPageQA.StartDate, testData.get("StartDate"));
		reportsPageQA.clearAndfillText(reportsPageQA.EndDate, testData.get("EndDate"));
		reportsPageQA.clickElement(reportsPageQA.btnSearch);
		
		actualData.add(page.locator(reportsPageQA.txtTitle).textContent());
		expectedData.add(testData.get("TextTitle"));
		
		actualData.add(page.locator(reportsPageQA.txtTotalItems).textContent());
		expectedData.add(testData.get("TotalItems"));
			
		Assert.assertEquals(expectedData, actualData);
	}
	
	@Test
	public void verify_TopCirculating() throws Exception {
		
		Map<String, String> testData = baseTest.readJsonElement("SetUp_Reports.json", "verify_TopCirculating");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		reportsPageQA.clickElement(reportsPageQA.lnkReports);
		reportsPageQA.clickElement(reportsPageQA.lnkTopCirculating);
		reportsPageQA.clearAndfillText(reportsPageQA.StartDate, testData.get("StartDate"));
		reportsPageQA.clearAndfillText(reportsPageQA.EndDate, testData.get("EndDate"));
		reportsPageQA.selectDropdownSpecificSearch(reportsPageQA.country, testData.get("Country"));
		reportsPageQA.clickElement(reportsPageQA.btnSearch);
		
		actualData.add(page.locator(reportsPageQA.txtTitle).textContent());
		expectedData.add(testData.get("TextTitle"));
		
		actualData.add(page.locator(reportsPageQA.txtTotalItems).textContent());
		expectedData.add(testData.get("TotalItems"));
			
		Assert.assertEquals(expectedData, actualData);
	}
	
	@Test
	public void verify_ConsortiaPatronActivity() throws Exception {
		
		Map<String, String> testData = baseTest.readJsonElement("SetUp_Reports.json", "verify_ConsortiaPatronActivity");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		reportsPageQA.clickElement(reportsPageQA.lnkReports);
		reportsPageQA.clickElement(reportsPageQA.lnkConsortiaPatronActivity);
		reportsPageQA.clearAndfillText(reportsPageQA.StartDate, testData.get("StartDate"));
		reportsPageQA.clearAndfillText(reportsPageQA.EndDate, testData.get("EndDate"));
		reportsPageQA.clickElement(reportsPageQA.btnSearch);
		
		actualData.add(page.locator(reportsPageQA.txtPatLibName).textContent());
		expectedData.add(testData.get("TextPatLibName"));
		
		actualData.add(page.locator(reportsPageQA.txtTotalItems).textContent());
		expectedData.add(testData.get("TotalItems"));
			
		Assert.assertEquals(expectedData, actualData);
	}
	
	@Test
	public void verify_ConsortiaContentActivity() throws Exception {
		
		Map<String, String> testData = baseTest.readJsonElement("SetUp_Reports.json", "verify_ConsortiaContentActivity");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		reportsPageQA.clickElement(reportsPageQA.lnkReports);
		reportsPageQA.clickElement(reportsPageQA.lnkConsortiaContentActivity);
		reportsPageQA.clearAndfillText(reportsPageQA.StartDate, testData.get("StartDate"));
		reportsPageQA.clearAndfillText(reportsPageQA.EndDate, testData.get("EndDate"));
		reportsPageQA.clickElement(reportsPageQA.btnSearch);
		
		actualData.add(page.locator(reportsPageQA.txtPatLibName).textContent());
		expectedData.add(testData.get("TextPatLibName"));
		
		actualData.add(page.locator(reportsPageQA.txtTotalItems).textContent());
		expectedData.add(testData.get("TotalItems"));
			
		Assert.assertEquals(expectedData, actualData);
	}
	
	@Test
	public void verify_ConsortiaGroupPatronActivity() throws Exception {
		
		Map<String, String> testData = baseTest.readJsonElement("SetUp_Reports.json", "verify_ConsortiaGroupPatronActivity");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		reportsPageQA.clickElement(reportsPageQA.lnkReports);
		reportsPageQA.clickElement(reportsPageQA.lnkConsortiaGroupPatronActivity);
		reportsPageQA.clickElement(reportsPageQA.btnSearch);
		
		actualData.add(page.locator(reportsPageQA.txtPatLibName).textContent());
		expectedData.add(testData.get("TextPatLibName"));
	
		Assert.assertEquals(expectedData, actualData);
	}
	
	@Test
	public void verify_ConsortiaGroupContentActivity() throws Exception {
		
		Map<String, String> testData = baseTest.readJsonElement("SetUp_Reports.json", "verify_ConsortiaGroupContentActivity");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		reportsPageQA.clickElement(reportsPageQA.lnkReports);
		reportsPageQA.clickElement(reportsPageQA.lnkConsortiaGroupContentActivity);
		reportsPageQA.clearAndfillText(reportsPageQA.StartDate, testData.get("StartDate"));
		reportsPageQA.clearAndfillText(reportsPageQA.EndDate, testData.get("EndDate"));
		reportsPageQA.clickElement(reportsPageQA.btnSearch);
		
		actualData.add(page.locator(reportsPageQA.txtTitle).textContent());
		expectedData.add(testData.get("TextTitle"));
		
		actualData.add(page.locator(reportsPageQA.txtTotalItems).textContent());
		expectedData.add(testData.get("TotalItems"));
			
		Assert.assertEquals(expectedData, actualData);
	}
	
	@Test
	public void verify_LibrarySalesSummary() throws Exception {
		
		Map<String, String> testData = baseTest.readJsonElement("SetUp_Reports.json", "verify_LibrarySalesSummary");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		reportsPageQA.clickElement(reportsPageQA.lnkReports);
		reportsPageQA.clickElement(reportsPageQA.lnkLibrarySalesSummary);
		reportsPageQA.clearAndfillText(reportsPageQA.StartDate, testData.get("StartDate"));
		reportsPageQA.clearAndfillText(reportsPageQA.EndDate, testData.get("EndDate"));
		reportsPageQA.clickElement(reportsPageQA.btnSearch);
		
		actualData.add(page.locator(reportsPageQA.txtLibID).textContent());
		expectedData.add(testData.get("TextLibID"));
		
		actualData.add(page.locator(reportsPageQA.txtTotalItems).textContent());
		expectedData.add(testData.get("TotalItems"));
			
		Assert.assertEquals(expectedData, actualData);
	}
	
	@Test
	public void verify_LibraryReports() throws Exception {
		
		Map<String, String> testData = baseTest.readJsonElement("SetUp_Reports.json", "verify_LibraryReports");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		reportsPageQA.clickElement(reportsPageQA.lnkReports);
		reportsPageQA.clickElement(reportsPageQA.lnkLibraryReports);
		reportsPageQA.clickElement(reportsPageQA.lnkReportsLib);
		
		actualData.add(page.locator(reportsPageQA.lblReports).textContent());
		expectedData.add(testData.get("TextReports"));
					
		Assert.assertEquals(expectedData, actualData);
	}
	
	@Test
	public void verify_MARCRequest() throws Exception {
		
		Map<String, String> testData = baseTest.readJsonElement("SetUp_Reports.json", "verify_MARCRequest");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		reportsPageQA.clickElement(reportsPageQA.lnkReports);
		reportsPageQA.clickElement(reportsPageQA.lnkMarcRequest);
		
		actualData.add(page.locator(reportsPageQA.lblMarcRequest).textContent());
		expectedData.add(testData.get("TextMARCReports"));
		
		actualData.add(page.locator(reportsPageQA.txtLibrary).textContent());
		expectedData.add(testData.get("TextLibrary"));		
					
		Assert.assertEquals(expectedData, actualData);
	}
	
	@Test
	public void verify_CollectionHQ() throws Exception {
		
		Map<String, String> testData = baseTest.readJsonElement("SetUp_Reports.json", "verify_CollectionHQ");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		reportsPageQA.clickElement(reportsPageQA.lnkReports);
		reportsPageQA.clickElement(reportsPageQA.lnkCollectionHQ);
		reportsPageQA.clickElement(reportsPageQA.btnSearch);
		
		actualData.add(page.locator(reportsPageQA.lblAuthor).textContent());
		expectedData.add(testData.get("TextAuthor"));
		
		Assert.assertEquals(expectedData, actualData);
	}
	
}
