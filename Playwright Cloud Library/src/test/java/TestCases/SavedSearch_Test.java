package TestCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.util.ArrayList;
import java.util.Map;

import com.aventstack.extentreports.Status;
import com.pages.SearchPage;

import BaseClass.BaseTest;

public class SavedSearch_Test extends BaseTest {

	@BeforeClass
	public void setupBefore() throws Exception {

		searchpage = new SearchPage(page);
		searchpage.clickOnSearch();
		Map<String, String> testData = playwrightFactory.readJsonElement("SavedSearch.json", "setupBefore");

		searchpage.clickSearchButton();
		searchpage.editorDropdown(testData.get("Book_PageSize"));
		searchpage.clseLftPnlIfExists();
	}

	@Test(priority = 1)
	public void VerifyCreateSavedSearchSingleTitle() throws Exception {

		Map<String, String> testData = playwrightFactory.readJsonElement("SavedSearch.json",
				"VerifyCreateSavedSearchSingleTitle");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();

		searchpage.clseLftPnlIfExists();
		searchpage.navigateToCartAndSearchPage();
		extentTest.log(Status.INFO, "Entering Search Criteria's");

		searchpage.enterBookTitle(testData.get("Book_Title"));
		searchpage.enterBookAuthor(testData.get("Book_Author"));
		//searchpage.enterBookSeries(testData.get("Book_Series"));
		searchpage.enterBookNarrator(testData.get("Book_Narrator"));
		searchpage.publisher(testData.get("Book_Publisher"));
		searchpage.contentProviders(testData.get("Book_ContentProvider"));
		searchpage.uncheckEPUBAndPDF();
		searchpage.catergoryAndSubject(testData.get("Book_CategoryAndSubj"));
		searchpage.audience(testData.get("Book_Audience"));
		searchpage.enterPrice(testData.get("Book_MinAmount"), testData.get("Book_MaxAmount"));
		searchpage.languages(testData.get("Book_Languages"));
		searchpage.clickElement(searchpage.lblFilters);
		searchpage.clickSaveSearchbtn();
		searchpage.searchName(searchpage.titlenamelist());
		searchpage.searchDesciption(testData.get("Book_SearchDesc"));
		searchpage.waitForElement(3);
		searchpage.clickSaveButton();

		actualData.add(page.locator(searchpage.searchSavedSuccessfully).textContent());
		expectedData.add(testData.get("Book_SavedSearchMessage"));
		AssertJUnit.assertEquals(expectedData, actualData);

		searchpage.savedTab();
		searchpage.drpdwnSavedSelect(1);
		searchpage.selectDropdownByScrollingCustom(testData.get("Book_SaveSearchName"), searchpage.SavedList);
		searchpage.waitForElement(3);
		searchpage.loadResult();
		//searchpage.containsVerify(searchpage.AllElementsSaved, testData.get("Book_Title"));
	}

	@Test(priority = 2)
	public void VerifySearchKeywordsVisibility() throws Exception {
		searchpage.manageLnk();
		searchpage.editSavedSearch();
		searchpage.verifyTitleVisibility();
		searchpage.verifyAuthorVisibility();
		//searchpage.verifyContentProviderVisibility();
		//searchpage.verifyPublisherVisibility();
		searchpage.verifyFormatVisibility();
		searchpage.verifyAudienceVisibility();
		searchpage.verifyPricingVisibility();
		searchpage.verifyLanguageVisibility();
	}

	@Test(priority = 3)
	public void VerifyUpdateSearchTitles() throws Exception {
		Map<String, String> testData = playwrightFactory.readJsonElement("SavedSearch.json",
				"VerifyUpdateSearchTitles");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();

		searchpage.enterBookTitle(testData.get("Book_UpdatedTitle"));
		searchpage.enterBookAuthor(testData.get("Book_UpdatedAuthor"));
		searchpage.clickElement(searchpage.btnsaveSearch);

		//searchpage.loadResultSaved();

		actualData.add(page.locator(searchpage.searchSavedSuccessfully).textContent());
		expectedData.add(testData.get("Book_SavedSearchMessage"));
		AssertJUnit.assertEquals(expectedData, actualData);
		
		searchpage.waitForElement(3);
		searchpage.containsVerify(searchpage.AllElements, testData.get("Book_UpdatedTitle"));

	}

	@Test(priority = 4)
	public void VerifydeleteSavedSearch() throws Exception {

		searchpage.manageLnk();
		searchpage.deleteSavedSearch();
		searchpage.clickElement(searchpage.dltCnfrm);
		searchpage.waitForElement(4);
		searchpage.verifySearchNotVisibile();
		searchpage.waitForElement(2);
		searchpage.clickElement(searchpage.btnDone);
		
		searchpage.navigateToCartAndSearchPage();

	}

	//@Test(priority = 5) Need to work
	public void VerifyFormatDrpdwns() throws Exception {

		Map<String, String> testData = playwrightFactory.readJsonElement("SavedSearch.json", "VerifyFormatDrpdwns");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		searchpage.clseLftPnlIfExists();
		searchpage.navigateToCartAndSearchPage();

		searchpage.clickElement(searchpage.AdvSearchTab);
		searchpage.waitForElement(5);
		searchpage.enterBookTitle(testData.get("Book_Title"));
	
		searchpage.languages(testData.get("Book_Language"));
	
		searchpage.enterPrice(testData.get("Book_MinPrice"), testData.get("Book_MaxPrice"));
		searchpage.waitForElement(2);
		searchpage.clickSaveSearchbtn();
		searchpage.searchName(testData.get("SaveSearchName"));
		searchpage.clickSaveButton();

		actualData.add(page.locator(searchpage.searchSavedSuccessfully).textContent());
		expectedData.add(testData.get("Book_SavedSearchMessage"));
		AssertJUnit.assertEquals(expectedData, actualData);

		searchpage.savedTab();
		searchpage.waitForElement(3);
		searchpage.drpdwnSavedSelect(1);
		searchpage.selectDropdownByScrollingCustom(testData.get("SaveSearchName"), searchpage.SavedList);
		searchpage.waitForElement(5);
		searchpage.loadResult();
		//searchpage.containsVerify(searchpage.AllElements, testData.get("Book_TitleCount"));
		
		searchpage.clickElement(searchpage.SavedFormat);
		//searchpage.clickElement(searchpage.SavedFormatAll);
		searchpage.clickElement(searchpage.SavedFormatEPUB);		
		searchpage.containsVerify(searchpage.AllMultipleElements, testData.get("Book_EPUB"));
		searchpage.clickElement(searchpage.SavedFormatEPUB);	
		searchpage.clickElement(searchpage.SavedFormatPDF);		
		searchpage.containsVerify(searchpage.AllMultipleElements, testData.get("Book_PDF"));
		searchpage.clickElement(searchpage.SavedFormatPDF);	
		searchpage.clickElement(searchpage.SavedFormatMP3);		
		searchpage.containsVerify(searchpage.AllMultipleElements, testData.get("Book_MP3"));
		
		searchpage.clseLftPnlIfExists();
		searchpage.navigateToCartAndSearchPage();
		
		

	}

}
