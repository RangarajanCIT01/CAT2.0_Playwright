package TestCases;

import java.util.ArrayList;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Factory.PlaywrightFactory;
import com.aventstack.extentreports.Status;
import com.base.BaseTest5;
import com.base.BaseTest;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;
import com.pages.SearchPage;

import Helper.ExtentTestManager;

public class Search_Test extends BaseTest{
	
	@BeforeClass
	public void setupBefore() throws Exception {
		
		searchpage=new SearchPage(page);
		searchpage.clickOnSearch();
		Map<String, String> testData = playwrightFactory.readJsonElement("SearchData.json", "searchdetails");
	
		searchpage.clickSearchButton();
		searchpage.editorDropdown(testData.get("Book_PageSize"));	
		//searchpage.clickElementIfExists(searchpage.leftPnlClse);
		searchpage.clickElement(searchpage.leftPnlClse);
		searchpage.navigateToCartAndSearchPage();
	}
	
	@Test
	public void VerifyQuickSearchByAuthor() throws Exception
	{		
		Map<String, String> testData = playwrightFactory.readJsonElement("SearchData.json", "quickSearchByAuthor");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		extentTest.log(Status.INFO, "Entering Author Details");
		searchpage.quickSearchByAuthor();
		searchpage.keyboardEnter();
		
		//page.waitForLoadState();
		searchpage.waitForElement(10);
		actualData.add(page.locator(searchpage.TitleCount).textContent());
		expectedData.add(testData.get("Book_TitleCount"));	
		Assert.assertEquals(expectedData, actualData);
		extentTest.log(Status.INFO, "Verified the details of Author results");
		
		//searchpage.clickElementIfExists(searchpage.leftPnlClse);
		searchpage.clickElement(searchpage.leftPnlClse);
		searchpage.navigateToCartAndSearchPage();
		
	}
	
	@Test
	public void VerifyQuickSearchByTitle() throws Exception
	{		
		Map<String, String> testData = playwrightFactory.readJsonElement("SearchData.json", "quickSearchByTitle");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		extentTest.log(Status.INFO, "Entering the Title ISBN on Quick Search Field ");
		searchpage.quickSearchByTitle();
		
		extentTest.log(Status.INFO, "Searching and verifying the Results");
		searchpage.keyboardEnter();
		
		searchpage.waitForElement(10);
		actualData.add(page.locator(searchpage.TitleCount).textContent());
		expectedData.add(testData.get("Book_TitleCount"));	
		Assert.assertEquals(expectedData, actualData);
		
		extentTest.log(Status.INFO, "Titles Count has been Verified");
		
		searchpage.clickElement(searchpage.leftPnlClse);
		searchpage.navigateToCartAndSearchPage();

	}
	
	//@Test 
	public void verifySpecificTitleSearch() throws Exception
	{		
		Map<String, String> testData = playwrightFactory.readJsonElement("SearchData.json", "verifySpecificTitleSearch");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();

		searchpage.clickOnSearch();
		extentTest.log(Status.INFO, "Entering the Search criteria for a particular title");
		searchpage.enterBookTitle(testData.get("Book_Title"));
		searchpage.enterBookAuthor(testData.get("Book_Author"));
		searchpage.enterBookSeries(testData.get("Book_Series"));
		searchpage.enterBookNarrator(testData.get("Book_Narrator"));
		
		//searchpage.enterBookHoldRatio(testData.get("Book_HoldRatio"));
		//searchpage.catergoryAndSubject(testData.get("));
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
	
	@Test
	public void verifySpecificTitleLeftPanel() throws Exception
	{		
		Map<String, String> testData = playwrightFactory.readJsonElement("SearchData.json", "searchdetails");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		searchpage.clickClearButton();
		searchpage.clickSearchButton();
		searchpage.ClearButtonLftPnl();
		
		extentTest.log(Status.INFO, "Entering the Search criteria for a particular title");
		searchpage.enterBookTitle(testData.get("Book_Title"));
		searchpage.enterBookAuthor(testData.get("Book_Author"));
		searchpage.enterBookSeries(testData.get("Book_Keyword"));
		searchpage.enterBookNarrator(testData.get("Book_Narrator"));
		///searchpage.enterBookHoldRatio(testData.get("Book_HoldRatio"));
		//searchpage.catergoryAndSubject(testData.get("));
		searchpage.audience(testData.get("Book_Audience"));
		searchpage.enterPrice(testData.get("Book_MinAmount"),testData.get("Book_MaxAmount"));
		searchpage.languages(testData.get("Book_Language"));
		searchpage.publisher(testData.get("Book_Publisher"));
		searchpage.contentProviders(testData.get("Book_ContentProvider"));
		searchpage.bookFilters();
		searchpage.SearchButtonLftPnl();
		extentTest.log(Status.INFO, "Search with search criteria");
		
		
		actualData.add(page.locator(searchpage.SpecificISBN).textContent());
		expectedData.add(testData.get("Book_SpecificISBN"));	
		Assert.assertEquals(expectedData, actualData);
		extentTest.log(Status.INFO, "Titles Count has been Verified");
		
		searchpage.clickElement(searchpage.leftPnlClse);
		searchpage.navigateToCartAndSearchPage();
	}

	@Test
	public void verifyMultipleTitlesAdvSearch() throws Exception
	{	
		Map<String, String> testData = playwrightFactory.readJsonElement("SearchData.json", "verifyMultipleTitlesAdvSearch");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		extentTest.log(Status.INFO, "Entering the Search criteria for a filtering multiple titles");
		//searchpage.enterBookKeyword(testData.get("Book_Keyword"));
		searchpage.enterBookTitle(testData.get("Book_Title"));
		searchpage.enterBookAuthor(testData.get("Book_Author"));
		searchpage.enterBookSeries(testData.get("Book_Series"));
		//searchpage.enterBookNarrator(testData.get("Book_Narrator"));
		//searchpage.preSaleTitles();
		//searchpage.enterBookHoldRatio(testData.get("Book_HoldRatio"));
		//searchpage.publisher(testData.get("Book_Publisher"));
		searchpage.contentProviders(testData.get("Book_ContentProvider"));
		//searchpage.catergoryAndSubject(testData.get(""));
		searchpage.audience(testData.get("Book_Audience"));
		searchpage.languages(testData.get("Book_Language"));
		
		searchpage.bookFormats(testData.get("Book_Format"));
		searchpage.enterPrice(testData.get("Book_MinAmount"),testData.get("Book_MaxAmount"));

		searchpage.clickElement(searchpage.SearchButton);
		extentTest.log(Status.INFO, "Search with search criteria");
		
		//searchpage.publishedWithin();
		//searchpage.dateAddedToCloudLibrary();
	
		//searchpage.bookFilters();
		
		//searchpage.verifyTitleCountAdvanceSearch();
		
		searchpage.waitForElement(10);
		actualData.add(page.locator(searchpage.TitleCount).textContent());
		expectedData.add(testData.get("Book_TitleCount"));	
		Assert.assertEquals(expectedData, actualData);
		extentTest.log(Status.INFO, "Titles Count has been Verified");
		
		searchpage.clickElement(searchpage.leftPnlClse);
		searchpage.navigateToCartAndSearchPage();
	}
	
	@Test
	public void verifyMultipleTitlesLeftPanel() throws Exception
	{	
		Map<String, String> testData = playwrightFactory.readJsonElement("SearchData.json", "verifyMultipleTitlesLeftPanel");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
			
		extentTest.log(Status.INFO, "Entering the Search criteria on left panel for a filtering multiple titles");
		//searchpage.enterBookKeyword(testData.get("Book_Keyword"));
		
		searchpage.clickElement(searchpage.SearchButton);		
		searchpage.enterBookTitle(testData.get("Book_Title"));
		searchpage.enterBookAuthor(testData.get("Book_Author"));
		searchpage.enterBookSeries(testData.get("Book_Series"));
		//searchpage.enterBookNarrator(testData.get("Book_Narrator"));
		//searchpage.preSaleTitles();
		//searchpage.enterBookHoldRatio(testData.get("Book_HoldRatio"));
		//searchpage.publisher(testData.get("Book_Publisher"));
		searchpage.contentProviders(testData.get("Book_ContentProvider"));
		//searchpage.catergoryAndSubject(testData.get(""));
		searchpage.audience(testData.get("Book_Audience"));
		searchpage.languages(testData.get("Book_Language"));
		
		searchpage.bookFormats(testData.get("Book_Format"));
		searchpage.enterPrice(testData.get("Book_MinAmount"),testData.get("Book_MaxAmount"));
		searchpage.clickElement(searchpage.SearchButtonLftPnl);
		extentTest.log(Status.INFO, "Search with search criteria");
		
		//searchpage.publishedWithin();
		//searchpage.dateAddedToCloudLibrary();
		//searchpage.bookFilters();
		//searchpage.verifyTitleCountAdvanceSearch();
		
		searchpage.waitForElement(10);
		actualData.add(page.locator(searchpage.TitleCount).textContent());
		expectedData.add(testData.get("Book_TitleCount"));	
		Assert.assertEquals(expectedData, actualData);
		extentTest.log(Status.INFO, "Titles Count has been Verified");
		
		searchpage.clickElement(searchpage.leftPnlClse);
		searchpage.navigateToCartAndSearchPage();
		
		//searchpage.verifyTitle();
		//actualData.add(page.locator(searchpage.SpecificISBN).textContent());
		//expectedData.add(testData.get("Book_SpecificISBN"));	
		//Assert.assertEquals(expectedData, actualData);
	}
	
	@Test
	public void VerifySearchByIsbn() throws Exception
	{		
		Map<String, String> testData = playwrightFactory.readJsonElement("SearchData.json", "searchByIsbn");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		extentTest.log(Status.INFO, "Entering the Search criteria on left panel for a filtering multiple titles");
		searchpage.clickElement(searchpage.leftPnlClse);
		searchpage.navigateToCartAndSearchPage();
		searchpage.clickOnIsbnTab();
		searchpage.enterIsbn();
		searchpage.clickOnIsbnSearchButton();
		searchpage.verifyTitleCount_Isbn();
		
		searchpage.waitForElement(3);
		actualData.add(page.locator(searchpage.SearchISBN).textContent());
		expectedData.add(testData.get("Book_SearchISBN"));	
		Assert.assertEquals(expectedData, actualData);
		extentTest.log(Status.INFO, "Titles Count has been Verified");
	
		searchpage.clickElement(searchpage.leftPnlClse);
		searchpage.navigateToCartAndSearchPage();
	}
	
	@Test
	public void VerifyQuickSearchByISBN() throws Exception
	{		
		Map<String, String> testData = playwrightFactory.readJsonElement("SearchData.json", "quickSearchByISBN");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		extentTest.log(Status.INFO, "Enter ISBN number on the Quick Search Field");
		searchpage.quickSearchByISBN();
		searchpage.keyboardEnter();
		
		searchpage.waitForElement(6);
		actualData.add(page.locator(searchpage.TitleCount).textContent());
		expectedData.add(testData.get("Book_TitleCount"));	
		Assert.assertEquals(expectedData, actualData);
		extentTest.log(Status.INFO, "Titles Count has been Verified");
		
		searchpage.clickElement(searchpage.leftPnlClse);
		searchpage.navigateToCartAndSearchPage();
	}
	
	@Test
	public void VerifyAuthorSearch() throws Exception
	{		
		Map<String, String> testData = playwrightFactory.readJsonElement("SearchData.json", "authorSearch");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		

		extentTest.log(Status.INFO, "Entering Author Details on Adv Search");
		//ExtentTestManager.getTest().assignCategory("CAT");
		searchpage.clickOnSearch();
		searchpage.clickClearButton();
		searchpage.enterBookAuthor(testData.get("AuthorName"));
		searchpage.clickSearchButton();

		actualData.add(page.locator(searchpage.TitleCount).textContent());
		expectedData.add(testData.get("Book_TitleCount"));	
		Assert.assertEquals(expectedData, actualData);
				
		searchpage.ClearButtonLftPnl();
		searchpage.enterBookAuthor(testData.get("AuthorName"));
		searchpage.SearchButtonLftPnl();
		
		actualData.add(page.locator(searchpage.TitleCount).textContent());
		expectedData.add(testData.get("Book_TitleCount"));	
		Assert.assertEquals(expectedData, actualData);
		extentTest.log(Status.INFO, "Titles Count has been Verified");
		
		searchpage.clickElement(searchpage.leftPnlClse);
		searchpage.navigateToCartAndSearchPage();
	}
	
	@Test
	public void VerifyNarratorSearch() throws Exception
	{		
		Map<String, String> testData = playwrightFactory.readJsonElement("SearchData.json", "narratorSearch");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		searchpage.clickClearButton();
		
		extentTest.log(Status.INFO, "Entering Narrator Details on Adv Search");
		searchpage.enterBookNarrator(testData.get("NarratorName"));
		searchpage.clickSearchButton();
	
		actualData.add(page.locator(searchpage.TitleCount).textContent());
		expectedData.add(testData.get("Book_TitleCount"));	
		Assert.assertEquals(expectedData, actualData);
				
		searchpage.ClearButtonLftPnl();
		searchpage.enterBookNarrator(testData.get("NarratorName"));
		searchpage.SearchButtonLftPnl();
		
		actualData.add(page.locator(searchpage.TitleCount).textContent());
		expectedData.add(testData.get("Book_TitleCount"));	
		Assert.assertEquals(expectedData, actualData);
		extentTest.log(Status.INFO, "Titles Count has been Verified");
		
		searchpage.clickElement(searchpage.leftPnlClse);
		searchpage.navigateToCartAndSearchPage();
		
	}
	
	@Test
	public void VerifySeriesSearch() throws Exception
	{		
		Map<String, String> testData = playwrightFactory.readJsonElement("SearchData.json", "seriesSearch");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		searchpage.enterBookSeries(testData.get("SeriesName"));
		searchpage.clickSearchButton();
		
		extentTest.log(Status.INFO, "Entering Series Details on Adv Search");
		searchpage.waitForElement(6);
		actualData.add(page.locator(searchpage.TitleCount).textContent());
		expectedData.add(testData.get("Book_TitleCount"));	
		Assert.assertEquals(expectedData, actualData);
				
		searchpage.ClearButtonLftPnl();
		searchpage.enterBookSeries(testData.get("SeriesName"));
		searchpage.SearchButtonLftPnl();
		
		searchpage.waitForElement(7);
		actualData.add(page.locator(searchpage.TitleCount).textContent());
		expectedData.add(testData.get("Book_TitleCount"));	
		Assert.assertEquals(expectedData, actualData);
		extentTest.log(Status.INFO, "Titles Count has been Verified");
		
		searchpage.clickElement(searchpage.leftPnlClse);
		searchpage.navigateToCartAndSearchPage();
	}
	
	@Test
	public void verifyKeywordFieldsDisabled() throws Exception
	{		
		Map<String, String> testData = playwrightFactory.readJsonElement("SearchData.json", "verifyKeywordFieldsDisabled");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
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
		
		searchpage.clickElement(searchpage.leftPnlClse);
		searchpage.navigateToCartAndSearchPage();
	}
	
	//@Test
	public void verifySort() throws Exception
		{
			Map<String, String> testData = playwrightFactory.readJsonElement("SearchData.json", "verifySort");
			
			searchpage.selectSortByOption(testData.get("Book_SortBy"));
			searchpage.verifySort();
		}
	
	//@Test
	public void VerifySearchByUploadIsbn() throws Exception
	{		
		Map<String, String> testData = playwrightFactory.readJsonElement("SearchData.json", "searchByUploadIsbn");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		searchpage.clickOnSearch();
		searchpage.clickOnIsbnTab();
		searchpage.uploadIsbnFile();
		
		actualData.add(page.locator(searchpage.TotalNotMatched).textContent());
		expectedData.add(testData.get("Book_NotMatched"));	
		Assert.assertEquals(expectedData, actualData);
		
		actualData.add(page.locator(searchpage.TitleCount).textContent());
		expectedData.add(testData.get("Book_Matched_Isbn"));	
		Assert.assertEquals(expectedData, actualData);
		
		searchpage.clickElement(searchpage.leftPnlClse);
		searchpage.navigateToCartAndSearchPage();
		
		//searchpage.verifyNotMatchedIsbnCount();
		//searchpage.verifyMatchedIsbnCount();	
	}			
}

