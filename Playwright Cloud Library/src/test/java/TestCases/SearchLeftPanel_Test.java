package TestCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.util.ArrayList;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Factory.PlaywrightFactory;
import com.aventstack.extentreports.Status;
import com.base.BaseTest;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;
import com.pages.SearchPage;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;



public class SearchLeftPanel_Test extends BaseTest{
	
	@BeforeClass
	public void setupBefore() throws Exception {
		
		searchpage=new SearchPage(page);
		searchpage.clickOnSearch();
		Map<String, String> testData = playwrightFactory.readJsonElement("SearchData.json", "searchdetails");
	
		searchpage.clickSearchButton();
		searchpage.editorDropdown(testData.get("Book_PageSize"));	
		searchpage.clseLftPnlIfExists();
	}
	
	@Test
	public void VerifyQuickSearchByAuthor() throws Exception
	{		
		Map<String, String> testData = playwrightFactory.readJsonElement("SearchData.json", "quickSearchByAuthor");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		searchpage.clseLftPnlIfExists();
		searchpage.navigateToCartAndSearchPage();
		extentTest.log(Status.INFO, "Entering Author Details");
		
		searchpage.quickSearchByAuthor();
		searchpage.loadResult();
		actualData.add(searchpage.actualVerify(searchpage.TitleCount));
		expectedData.add(testData.get("Book_TitleCount"));	
		AssertJUnit.assertEquals(expectedData, actualData);
		
		extentTest.log(Status.INFO, "Verified the details of Author results");

		searchpage.clseLftPnlIfExists();
		
	}
	
	@Test
	public void VerifyQuickSearchByTitle() throws Exception
	{		
		Map<String, String> testData = playwrightFactory.readJsonElement("SearchData.json", "quickSearchByTitle");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		searchpage.clseLftPnlIfExists();
		searchpage.navigateToCartAndSearchPage();
		extentTest.log(Status.INFO, "Entering the Title ISBN on Quick Search Field ");
		searchpage.quickSearchByTitle();
		
		extentTest.log(Status.INFO, "Searching and verifying the Results");
		
		searchpage.loadResult();
		actualData.add(searchpage.actualVerify(searchpage.TitleCount));
		expectedData.add(testData.get("Book_TitleCount"));	
		AssertJUnit.assertEquals(expectedData, actualData);
		
		extentTest.log(Status.INFO, "Titles Count has been Verified");
		
		searchpage.clseLftPnlIfExists();

	}
	
	@Test
	public void VerifyQuickSearchByISBN() throws Exception
	{		
		Map<String, String> testData = playwrightFactory.readJsonElement("SearchData.json", "quickSearchByISBN");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		searchpage.clseLftPnlIfExists();
		searchpage.navigateToCartAndSearchPage();
		
		extentTest.log(Status.INFO, "Enter ISBN number on the Quick Search Field");
		searchpage.quickSearchByISBN();

		searchpage.loadResult();
		
		extentTest.log(Status.INFO, "Titles Count has been Verified");
		
		searchpage.clseLftPnlIfExists();
	}
	
	@Test 
	public void verifySpecificTitleSearch() throws Exception
	{		
		Map<String, String> testData = playwrightFactory.readJsonElement("SearchData.json", "verifySpecificTitleSearch");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();

		searchpage.clseLftPnlIfExists();
		searchpage.navigateToCartAndSearchPage();
		
		extentTest.log(Status.INFO, "Entering the Search criteria for a particular title");
		
		searchpage.enterBookTitle(testData.get("Book_Title"));
		searchpage.enterBookAuthor(testData.get("Book_Author"));
		searchpage.enterBookSeries(testData.get("Book_Series"));
		searchpage.enterBookNarrator(testData.get("Book_Narrator"));
		searchpage.audience(testData.get("Book_Audience"));
		searchpage.enterPrice(testData.get("Book_MinAmount"),testData.get("Book_MaxAmount"));
		searchpage.languages(testData.get("Book_Language"));
		searchpage.publisher(testData.get("Book_Publisher"));
		searchpage.contentProviders(testData.get("Book_ContentProvider"));
		searchpage.bookFilters();
		searchpage.clickSearchButton();
		
		extentTest.log(Status.INFO, "Search with search criteria");
		searchpage.loadResult();
		searchpage.containsVerify(searchpage.AllElements, testData.get("Book_Title"));

		extentTest.log(Status.INFO, "Titles Count has been Verified");
		searchpage.clseLftPnlIfExists();
	
	}
	
	@Test
	public void verifySpecificTitleLeftPanel() throws Exception
	{		
		Map<String, String> testData = playwrightFactory.readJsonElement("SearchData.json", "searchdetails");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		searchpage.clseLftPnlIfExists();
		searchpage.navigateToCartAndSearchPage();
		searchpage.clickClearButton();
		searchpage.clickSearchButton();
		searchpage.ClearButtonLftPnl();
		
		extentTest.log(Status.INFO, "Entering the Search criteria for a particular title");
		searchpage.enterBookTitle(testData.get("Book_Title"));
		searchpage.enterBookAuthor(testData.get("Book_Author"));
		searchpage.enterBookSeries(testData.get("Book_Keyword"));
		searchpage.enterBookNarrator(testData.get("Book_Narrator"));
		searchpage.audience(testData.get("Book_Audience"));
		searchpage.enterPrice(testData.get("Book_MinAmount"),testData.get("Book_MaxAmount"));
		searchpage.languages(testData.get("Book_Language"));
		searchpage.publisher(testData.get("Book_Publisher"));
		searchpage.contentProviders(testData.get("Book_ContentProvider"));
		searchpage.bookFilters();
		searchpage.SearchButtonLftPnl();
		extentTest.log(Status.INFO, "Search with search criteria");
		
		searchpage.loadResult();
		searchpage.containsVerify(searchpage.AllElements, testData.get("Book_Title"));
		extentTest.log(Status.INFO, "Titles Count has been Verified");
		
		searchpage.clseLftPnlIfExists();
	}

	@Test
	public void verifyMultipleTitlesAdvSearch() throws Exception
	{	
		Map<String, String> testData = playwrightFactory.readJsonElement("SearchData.json", "verifyMultipleTitlesAdvSearch");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		searchpage.clseLftPnlIfExists();
		searchpage.navigateToCartAndSearchPage();
		
		extentTest.log(Status.INFO, "Entering the Search criteria for a filtering multiple titles");

		searchpage.enterBookTitle(testData.get("Book_Title"));
		searchpage.enterBookAuthor(testData.get("Book_Author"));
		searchpage.enterBookSeries(testData.get("Book_Series"));
		searchpage.contentProviders(testData.get("Book_ContentProvider"));
		searchpage.audience(testData.get("Book_Audience"));
		searchpage.languages(testData.get("Book_Language"));
		
		searchpage.bookFormats(testData.get("Book_Format"));
		searchpage.enterPrice(testData.get("Book_MinAmount"),testData.get("Book_MaxAmount"));

		searchpage.clickElement(searchpage.SearchButton);
		extentTest.log(Status.INFO, "Search with search criteria");
		
		searchpage.loadResult();
		actualData.add(searchpage.actualVerify(searchpage.TitleCount));
		expectedData.add(testData.get("Book_TitleCount"));	
		AssertJUnit.assertEquals(expectedData, actualData);
		extentTest.log(Status.INFO, "Titles Count has been Verified");
		
		searchpage.clseLftPnlIfExists();
	}
	
	@Test
	public void verifyMultipleTitlesLeftPanel() throws Exception
	{	
		Map<String, String> testData = playwrightFactory.readJsonElement("SearchData.json", "verifyMultipleTitlesLeftPanel");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
			
		searchpage.clseLftPnlIfExists();

		searchpage.navigateToCartAndSearchPage();
		extentTest.log(Status.INFO, "Entering the Search criteria on left panel for a filtering multiple titles");
		
		searchpage.clickElement(searchpage.SearchButton);	
		searchpage.loadResult();
		searchpage.ClearButtonLftPnl();
		searchpage.enterBookTitle(testData.get("Book_Title"));
		searchpage.enterBookAuthor(testData.get("Book_Author"));
		searchpage.enterBookSeries(testData.get("Book_Series"));
		searchpage.contentProviders(testData.get("Book_ContentProvider"));
		searchpage.audience(testData.get("Book_Audience"));
		searchpage.languages(testData.get("Book_Language"));
		
		searchpage.bookFormats(testData.get("Book_Format"));
		searchpage.enterPrice(testData.get("Book_MinAmount"),testData.get("Book_MaxAmount"));
		searchpage.clickElement(searchpage.SearchButtonLftPnl);
		extentTest.log(Status.INFO, "Search with search criteria");
		
		searchpage.loadResult();
		actualData.add(searchpage.actualVerify(searchpage.TitleCount));
		expectedData.add(testData.get("Book_TitleCount"));	
		AssertJUnit.assertEquals(expectedData, actualData);
		extentTest.log(Status.INFO, "Titles Count has been Verified");
		
		searchpage.clseLftPnlIfExists();
	}
	
	
	@Test
	public void VerifyAuthorSearch() throws Exception
	{		
		Map<String, String> testData = playwrightFactory.readJsonElement("SearchData.json", "authorSearch");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		

		searchpage.clseLftPnlIfExists();
		searchpage.navigateToCartAndSearchPage();
		
		extentTest.log(Status.INFO, "Entering Author Details on Adv Search");
		searchpage.clickOnSearch();
		searchpage.clickClearButton();
		searchpage.enterBookAuthor(testData.get("AuthorName"));
		searchpage.clickSearchButton();
		
		searchpage.loadResult();
		actualData.add(searchpage.actualVerify(searchpage.TitleCount));
		expectedData.add(testData.get("Book_TitleCount"));		
		AssertJUnit.assertEquals(expectedData, actualData);
	
		searchpage.clickElement(searchpage.TitleCount);
				
		searchpage.ClearButtonLftPnl();
		searchpage.enterBookAuthor(testData.get("AuthorName"));
		searchpage.SearchButtonLftPnl();
		
		searchpage.loadResult();	
		actualData.add(searchpage.actualVerify(searchpage.TitleCount));
		expectedData.add(testData.get("Book_TitleCount"));	
		AssertJUnit.assertEquals(expectedData, actualData);
		
		searchpage.clickElement(searchpage.TitleCount);		
		extentTest.log(Status.INFO, "Titles Count has been Verified");
		
		searchpage.clseLftPnlIfExists();
	}
	
	
	@Test
	public void VerifyNarratorSearch() throws Exception
	{		
		Map<String, String> testData = playwrightFactory.readJsonElement("SearchData.json", "narratorSearch");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		searchpage.clseLftPnlIfExists();
		searchpage.navigateToCartAndSearchPage();
		
		extentTest.log(Status.INFO, "Entering Narrator Details on Adv Search");
		searchpage.enterBookNarrator(testData.get("NarratorName"));
		searchpage.clickSearchButton();
	
		searchpage.loadResult();
		actualData.add(searchpage.actualVerify(searchpage.TitleCount));
		expectedData.add(testData.get("Book_TitleCount"));	
		AssertJUnit.assertEquals(expectedData, actualData);
				
		searchpage.ClearButtonLftPnl();
		searchpage.enterBookNarrator(testData.get("NarratorName"));
		searchpage.SearchButtonLftPnl();
		
		searchpage.loadResult();
		actualData.add(searchpage.actualVerify(searchpage.TitleCount));
		expectedData.add(testData.get("Book_TitleCount"));	
		AssertJUnit.assertEquals(expectedData, actualData);
		extentTest.log(Status.INFO, "Titles Count has been Verified");
		
		searchpage.clseLftPnlIfExists();
	}
	
	@Test
	public void VerifySeriesSearch() throws Exception
	{		
		Map<String, String> testData = playwrightFactory.readJsonElement("SearchData.json", "seriesSearch");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		searchpage.clseLftPnlIfExists();
		searchpage.navigateToCartAndSearchPage();
		
		searchpage.enterBookSeries(testData.get("SeriesName"));
		searchpage.clickSearchButton();
		
		extentTest.log(Status.INFO, "Entering Series Details on Adv Search");
		
		searchpage.loadResult();
		actualData.add(searchpage.actualVerify(searchpage.TitleCount));
		expectedData.add(testData.get("Book_TitleCount"));	
		AssertJUnit.assertEquals(expectedData, actualData);
				
		searchpage.ClearButtonLftPnl();
		searchpage.enterBookSeries(testData.get("SeriesName"));
		searchpage.SearchButtonLftPnl();
		
		searchpage.loadResult();
		actualData.add(searchpage.actualVerify(searchpage.TitleCount));
		expectedData.add(testData.get("Book_TitleCount"));	
		AssertJUnit.assertEquals(expectedData, actualData);
		extentTest.log(Status.INFO, "Titles Count has been Verified");
		
		searchpage.clseLftPnlIfExists();
	}
	
	@Test
	public void verifyKeywordFieldsDisabled() throws Exception
	{		
		Map<String, String> testData = playwrightFactory.readJsonElement("SearchData.json", "verifyKeywordFieldsDisabled");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		searchpage.clseLftPnlIfExists();
		searchpage.navigateToCartAndSearchPage();
		
		extentTest.log(Status.INFO, "Entering Keyword on the keyword field");
		searchpage.enterBookKeyword(testData.get("Book_Keyword"));
		searchpage.verifyDisabled(searchpage.keywordTitle);
		searchpage.verifyDisabled(searchpage.Author);
		searchpage.verifyDisabled(searchpage.Series);
		searchpage.clickSearchButton();
		searchpage.verifyDisabled(searchpage.keywordTitle);
		searchpage.verifyDisabled(searchpage.Author);
		searchpage.verifyDisabled(searchpage.Series);
		extentTest.log(Status.INFO, "Title, Author and Series Fields are Disabled");
		
		searchpage.clseLftPnlIfExists();
	}
	
	//@Test
	public void verifySort() throws Exception
		{
			Map<String, String> testData = playwrightFactory.readJsonElement("SearchData.json", "verifySort");
			
			searchpage.selectSortByOption(testData.get("Book_SortBy"));
			searchpage.verifySort();
		}
	
	
			
}

