package TestCases;

import java.util.ArrayList;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.base.BaseTest;
import com.base.BaseTest5;
import com.pages.CartPage;
import com.pages.SearchPage;

import Helper.ExtentTestManager;

public class TestFile extends BaseTest{
	
	@BeforeClass
	public void setupBefore() throws Exception {
		
		searchpage=new SearchPage(page);
		searchpage.clickOnSearch();
		Map<String, String> testData = playwrightFactory.readJsonElement("SearchData.json", "searchdetails");
	
		searchpage.clickSearchButton();
		searchpage.editorDropdown(testData.get("Book_PageSize"));	
		//searchpage.clickElementIfExists(searchpage.leftPnlClse);
		//searchpage.clickElement(searchpage.leftPnlClse);
		searchpage.navigateToCartAndSearchPage();
	}
	
	
	@Test
	public void verifySpecificTitleSearch() throws Exception
	{		
		Map<String, String> testData = playwrightFactory.readJsonElement("SearchData.json", "verifySpecificTitleSearch");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();

		searchpage.clickOnSearch();
		//extentTest.log(Status.INFO, "Entering the Search criteria for a particular title");
		searchpage.enterBookTitle(testData.get("Book_Title"));
		searchpage.enterBookAuthor(testData.get("Book_Author"));
		searchpage.enterBookSeries(testData.get("Book_Series"));
		searchpage.enterBookNarrator(testData.get("Book_Narrator"));
		
		//searchpage.enterBookHoldRatio(testData.get("Book_HoldRatio"));
		searchpage.audience(testData.get("Book_Audience"));
		searchpage.enterPrice(testData.get("Book_MinAmount"),testData.get("Book_MaxAmount"));
		searchpage.languages(testData.get("Book_Language"));
		searchpage.publisher(testData.get("Book_Publisher"));
		searchpage.contentProviders(testData.get("Book_ContentProvider"));
		searchpage.bookFilters();
		searchpage.clickSearchButton();
		
		extentTest.log(Status.INFO, "Search with search criteria");
		System.out.println(page.locator(searchpage.SpecificISBN).textContent());
		
		actualData.add(page.locator(searchpage.SpecificISBN).textContent());
		expectedData.add(testData.get("Book_SpecificISBN"));	
		Assert.assertEquals(expectedData, actualData);
		extentTest.log(Status.INFO, "Titles Count has been Verified");
		
		ExtentTestManager.getTest().info("Verify Login is successfull - " + ExtentTestManager.getTest().getStatus());
		searchpage.clickElement(searchpage.leftPnlClse);
		searchpage.navigateToCartAndSearchPage();
	
	}	
}