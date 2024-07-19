package com.test;

import java.util.ArrayList;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Factory.PlaywrightFactory;
import com.base.BaseTest;
import com.base.BaseTest5;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;
import com.pages.SearchPage;

public class SavedSearch extends BaseTest{
	
	@BeforeClass
	public void setupBefore() throws Exception {
		
		searchpage=new SearchPage(page);
		searchpage.clickOnSearch();
		Map<String, String> testData = playwrightFactory.readJsonElement("SavedSearch.json", "setupBefore");
	
		searchpage.clickSearchButton();
		searchpage.editorDropdown(testData.get("Book_PageSize"));	
		//searchpage.clickElementIfExists(searchpage.leftPnlClse);
		searchpage.clickElement(searchpage.leftPnlClse);
		searchpage.navigateToCartAndSearchPage();
	}
	
	@Test (priority=1)
	public void VerifySaveSearch() throws Exception
	{
		
		Map<String, String> testData = playwrightFactory.readJsonElement("SavedSearch.json", "VerifySaveSearch");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		searchpage.clickOnSearch();
		searchpage.enterBookTitle(testData.get("Book_Title"));
		searchpage.audience(testData.get("Book_Audience"));
		searchpage.enterPrice(testData.get("Book_MinAmount"),testData.get("Book_MaxAmount"));
		searchpage.contentProviders(testData.get("Book_ContentProvider"));
		searchpage.clickOnSaveSearch();
		searchpage.searchName(testData.get("Book_SearchName"));
		searchpage.searchDesciption(testData.get("Book_SearchDesc"));
		searchpage.clickSaveButton();
		
		actualData.add(page.locator(searchpage.searchSavedSuccessfully).textContent());
		expectedData.add(testData.get("Book_SavedSearchMessage"));	
		Assert.assertEquals(expectedData, actualData);

	}	
	
	//@Test(priority=2)
	public void VerifyEditManage() throws Exception
	{

		Map<String, String> testData = playwrightFactory.readJsonElement("SavedSearch.json", "VerifyEditManage");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
	
		searchpage.waitForElement(5);
		searchpage.savedTab();
		searchpage.click(1);
		//searchpage.scroll(searchpage.editSavedSearch);
		searchpage.scrollAndClick(searchpage.editSavedSearch);
		
		searchpage.waitForElement(5);
		actualData.add(page.locator(searchpage.TitleCount).textContent());
		expectedData.add(testData.get("Book_TitleCount"));	
		Assert.assertEquals(expectedData, actualData);
		
		searchpage.manageLnk();
	
		searchpage.scrollAndClick(searchpage.ManageEditIcon);
		searchpage.clickElement(searchpage.TitleAdvSearch);
		searchpage.keyboardSelectAll();
		searchpage.keyboardDelete();
				
		searchpage.enterBookTitle(testData.get("Book_UpdatedTitle"));
		searchpage.clickElement(searchpage.btnsaveSearch);
		
		actualData.add(page.locator(searchpage.searchSavedSuccessfully).textContent());
		expectedData.add(testData.get("Book_SavedSearchMessage"));	
		Assert.assertEquals(expectedData, actualData);
				
		searchpage.waitForElement(5);
		actualData.add(page.locator(searchpage.TitleCount).textContent());
		expectedData.add(testData.get("Book_UpdatedTitleCount"));	
		Assert.assertEquals(expectedData, actualData);
		
		searchpage.manageLnk();
		searchpage.scrollAndClick(searchpage.deleteSavedSeach);
		searchpage.clickElement(searchpage.lnkdeleteSavedSearch);		
		searchpage.clickElement(searchpage.btnDone);
		
		//searchpage.verifyVisibility(searchpage.editSavedSearch);
		//searchpage.isDisplayed(searchpage.editSavedSearch);
	
		searchpage.navigateToCartAndSearchPage();
	}
		
}