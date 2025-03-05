package TestCases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


import java.util.ArrayList;
import java.util.Map;

import com.aventstack.extentreports.Status;

import BaseClass.PlaywrightFactory;
import TestPages.NotForSalePage;
import TestPages.SearchPage;

public class Col_NotForSale extends PlaywrightFactory{
	
	@BeforeClass
	public void setupBefore() throws Exception {
		
		searchpage=new SearchPage(page);
		notForSale = new NotForSalePage(page);
		searchpage.clickOnSearch();
		//Map<String, String> testData = baseTest.readJsonElement("SearchData.json", "searchdetails");
	
		//searchpage.clickSearchButton();
		//searchpage.editorDropdown(testData.get("Book_PageSize"));	
		//searchpage.clseLftPnlIfExists();
	}
	
	@Test
	public void VerifyNotForSaleTitleSearch() throws Exception
	{		
		Map<String, String> testData = baseTest.readJsonElement("NotForSale.json", "VerifyNotForSaleTitleSearch");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
		
		searchpage.clseLftPnlIfExists();
		searchpage.navigateToCartAndSearchPage();
		extentTest.log(Status.INFO, "Enter Book Title Detail");
		
		searchpage.enterBookTitle(testData.get("Book_Title"));
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.loadResult();
		
		assertThat(page.locator(searchpage.noResultsFound)).hasText(testData.get("NoResultsFound"));
		
		//assertThat(page.locator(".title")).containsText("substring");
		                                                                              
		searchpage.clickElement(searchpage.Back);
	}
	
	@Test
	public void VerifyNotForSaleTitleQuickSearch() throws Exception
	{		
		Map<String, String> testData = baseTest.readJsonElement("NotForSale.json", "VerifyNotForSaleTitleQuickSearch");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
		
		searchpage.clseLftPnlIfExists();
		searchpage.navigateToCartAndSearchPage();
		extentTest.log(Status.INFO, "Enter Book ISBN Detail");
		
		searchpage.fillText(searchpage.txtfldquickSearch, testData.get("Book_ISBN"));		
		searchpage.loadResult();
		
		assertThat(page.locator(searchpage.noResultsFound)).hasText(testData.get("NoResultsFound"));
		
		extentTest.log(Status.INFO, "Verified the details of Not for sale title");                                                                               
	}
	
	@Test
	public void VerifyNotForSaleTitle() throws Exception
	{		
		Map<String, String> testData = baseTest.readJsonElement("NotForSale.json", "VerifyNotForSaleTitle");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		searchpage.clseLftPnlIfExists();
		collection.navigateToCartAndCollectionPage();
		extentTest.log(Status.INFO, "Entering Title Details");
			
		searchpage.enterBookTitle(testData.get("Book_Title"));
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.loadResult();
		
		searchpage.containsVerify(searchpage.AllElements, testData.get("Book_Label"));
					
		extentTest.log(Status.INFO, "Verified the details of Title results");

		searchpage.clseLftPnlIfExists();                                                                                          
		
	}
	
	@Test
	public void VerifyNotForSaleTitleDetailsPage() throws Exception
	{		
		Map<String, String> testData = baseTest.readJsonElement("NotForSale.json", "VerifyNotForSaleTitleDetailsPage");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		searchpage.clseLftPnlIfExists();
		collection.navigateToCartAndCollectionPage();
		extentTest.log(Status.INFO, "Entering Title Details");
			
		searchpage.enterBookTitle(testData.get("Book_Title"));
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.loadResult();
		
		searchpage.containsVerify(searchpage.AllElements, testData.get("Book_Label"));
		
		notForSale.verifyDetailsPage();
		searchpage.containsVerify(searchpage.AllDetailsPage, testData.get("Book_Label"));
					
		extentTest.log(Status.INFO, "Verified the details of Title results");

		searchpage.clseLftPnlIfExists();                                                                                          
		
	}
	
	@Test
	public void VerifyNotForSaleShelves() throws Exception
	{		
		Map<String, String> testData = baseTest.readJsonElement("NotForSale.json", "VerifyNotForSaleShelves");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();	
		
		shelfpage.clickOnShelves();
		shelfpage.clickOnNewShelve();
		shelfpage.manualShelfType();
		shelfpage.enterManualShelfName();
		shelfpage.enterManualShelfDescription();
		shelfpage.clickOnContinue();
		shelfpage.verifyShelfCreatedSuccessfully();
	
		searchpage.clseLftPnlIfExists();
		collection.navigateToCartAndCollectionPage();
		extentTest.log(Status.INFO, "Entering Title Details");
			
		searchpage.enterBookTitle(testData.get("Book_Title"));
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.loadResult();
		
		searchpage.containsVerify(searchpage.AllElements, testData.get("Book_Label"));
		
		shelfpage.clickElement(shelfpage.btnAddToShelf);
		shelfpage.clickElement(collection.Back);
		
		String data = testData.get("ManualShelfName");
		String selectShelf = "//span[text()='"+ data +"']";
		shelfpage.clickOnShelves();
		shelfpage.clickElement(selectShelf);
		
		searchpage.waitForElement(10);
		
		String lblNfs = page.locator(notForSale.lblNotForSale).innerText();
		Assert.assertEquals(lblNfs, testData.get("Book_Label"));
		
		shelfpage.clickElement(shelfpage.lnkback);
		shelfpage.clickOnDeleteShelf();
		shelfpage.verifyDeleteConfrm();
		
		extentTest.log(Status.INFO, "Verified the details of Title results");

		searchpage.clseLftPnlIfExists();                                                                                          
		
	}
}

