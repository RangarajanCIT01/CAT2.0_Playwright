package TestCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.util.ArrayList;
import java.util.Map;

import com.aventstack.extentreports.Status;

import BaseClass.PlaywrightFactory;
import TestPages.MyCollectionPage;
import TestPages.SearchPage;

public class SearchISBN_Test extends PlaywrightFactory{
	
	@BeforeClass
	public void setupBefore() throws Exception {
		
		searchpage=new SearchPage(page);
		collection=new MyCollectionPage(page);
		searchpage.clickOnSearch();
		Map<String, String> testData = baseTest.readJsonElement("SearchData.json", "searchdetails");
	
		searchpage.clickSearchButton();
		searchpage.editorDropdown(testData.get("Book_PageSize"));	
		searchpage.clseLftPnlIfExists();
	}
	
	@Test
	public void VerifySearchByIsbn() throws Exception
	{
		Map<String, String> testData = baseTest.readJsonElement("SearchData.json", "VerifySearchByIsbn");
		
		searchpage.clseLftPnlIfExists();
		searchpage.navigateToCartAndSearchPage();
		extentTest.log(Status.INFO, "Entering ISBN Details");

		collection.clickOnIsbnTab();
		collection.enterIsbn(testData.get("Book_ISBN"));
		collection.clickOnIsbnSearchButton();
		searchpage.containsVerify(searchpage.AllElements, testData.get("Book_Title"));
				
		extentTest.log(Status.INFO, "Verified the details of ISBN Title result");

		searchpage.clseLftPnlIfExists();   
	}
	
	@Test
	public void VerifySearchByMultipleIsbn() throws Exception
	{
		Map<String, String> testData = baseTest.readJsonElement("SearchData.json", "VerifySearchByMultipleIsbn");
		
		searchpage.clseLftPnlIfExists();
		searchpage.navigateToCartAndSearchPage();
		extentTest.log(Status.INFO, "Entering Multiple ISBN's Details");

		collection.clickOnIsbnTab();
		collection.enterIsbn(testData.get("Book_ISBNS"));
		collection.clickOnIsbnSearchButton();
		searchpage.loadResult();
		searchpage.containsVerify(searchpage.AllElementsSaved, testData.get("Book_Title"));
				
		extentTest.log(Status.INFO, "Verified the details of multiple ISBN Titles result");

		searchpage.clseLftPnlIfExists();   
	}
		
	//@Test
		public void VerifySearchByUploadIsbn() throws Exception
		{		
			Map<String, String> testData = baseTest.readJsonElement("SearchData.json", "searchByUploadIsbn");
			ArrayList<Object> actualData = new ArrayList<>();
			ArrayList<Object> expectedData = new ArrayList<>();
			
			searchpage.clseLftPnlIfExists();
			searchpage.clickOnSearch();
			searchpage.clickOnIsbnTab();
			searchpage.uploadIsbnFile();
			
			searchpage.loadResult();
			actualData.add(searchpage.actualVerify(searchpage.TotalNotMatched));
			expectedData.add(testData.get("Book_NotMatched"));	
			AssertJUnit.assertEquals(expectedData, actualData);
			
			searchpage.loadResult();
			actualData.add(searchpage.actualVerify(searchpage.TitleCount));
			expectedData.add(testData.get("Book_Matched_Isbn"));	
			AssertJUnit.assertEquals(expectedData, actualData);
			
			searchpage.clickElement(SearchPage.leftPnlClse);
			searchpage.navigateToCartAndSearchPage();
			
			//searchpage.verifyNotMatchedIsbnCount();
			//searchpage.verifyMatchedIsbnCount();	
		}	
		
		//@Test
		public void VerifyPublisherList() throws Exception
		{				
		
			searchpage.clseLftPnlIfExists();
			searchpage.navigateToCartAndSearchPage();
			extentTest.log(Status.INFO, "Entering Author Details");
			searchpage.clickElement(searchpage.lblContentProvider);
			searchpage.checkList();
			extentTest.log(Status.INFO, "Verified the details of Author results");

			searchpage.clseLftPnlIfExists();
		}
			
}

