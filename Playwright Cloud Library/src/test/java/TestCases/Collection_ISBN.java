package TestCases;


import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.base.BaseTest;
import com.pages.MyCollectionPage;
import com.pages.SearchPage;

public class Collection_ISBN extends BaseTest{
	
	@BeforeClass
	public void setupBefore() throws Exception {
		
		collection=new MyCollectionPage(page);
		searchpage = new SearchPage(page);
		collection.clickOnMyCollection();
		Map<String, String> testData = playwrightFactory.readJsonElement("CollectionData.json", "Setup");
	
		searchpage.clickSearchButton();
		searchpage.editorDropdown(testData.get("Book_PageSize"));	
		searchpage.clseLftPnlIfExists();
	}
	
	@Test
	public void VerifyColSearchByIsbn() throws Exception
	{
		Map<String, String> testData = playwrightFactory.readJsonElement("CollectionData.json", "VerifyColSearchByIsbn");
		
		searchpage.clseLftPnlIfExists();
		collection.navigateToCartAndCollectionPage();
		extentTest.log(Status.INFO, "Entering ISBN Details");

		collection.clickOnIsbnTab();
		collection.enterIsbn(testData.get("Book_ISBN"));
		collection.clickOnIsbnSearchButton();
		searchpage.containsVerify(searchpage.AllElements, testData.get("Book_Title"));
				
		extentTest.log(Status.INFO, "Verified the details of ISBN Title result");

		searchpage.clseLftPnlIfExists();   
	}
	
	@Test
	public void VerifyColSearchByMultipleIsbn() throws Exception
	{
		Map<String, String> testData = playwrightFactory.readJsonElement("CollectionData.json", "VerifyColSearchByMultipleIsbn");
		
		searchpage.clseLftPnlIfExists();
		collection.navigateToCartAndCollectionPage();
		extentTest.log(Status.INFO, "Entering Multiple ISBN's Details");

		collection.clickOnIsbnTab();
		collection.enterIsbn(testData.get("Book_ISBNS"));
		collection.clickOnIsbnSearchButton();
		searchpage.containsVerify(searchpage.AllMultipleElements, testData.get("Book_Title"));
				
		extentTest.log(Status.INFO, "Verified the details of multiple ISBN Titles result");

		searchpage.clseLftPnlIfExists();   
	}
	
	@Test
	public void searchByUploadIsbn() throws Exception
	{ 
		Map<String, String> testData = playwrightFactory.readJsonElement("CollectionData.json", "searchByUploadIsbn");
	
		searchpage.clseLftPnlIfExists();
		collection.navigateToCartAndCollectionPage();
		extentTest.log(Status.INFO, "Entering Multiple ISBN's Details");

		collection.clickOnIsbnTab();
		collection.uploadIsbnFile();
		searchpage.waitForElement(2);
		//searchpage.containsVerify(searchpage.AllMultipleElements, testData.get("Book_Title"));
		//collection.verifyNotMatchedIsbnCount();
		//collection.verifyMatchedIsbnCount();
	}
	
	//@Test
		public void verifyAddToShelf() throws Exception
		{
			collection=new MyCollectionPage(page);
			
			collection.selectAllBooks();
			collection.addToShelf();
			collection.verifyShelfCreatedSuccessfully();
		}
	
	//@Test
	public void verifyCreateShelf() throws Exception
	{		
		shelfpage.clickOnShelves();
		shelfpage.clickOnNewShelve();
		shelfpage.manualShelfType();
		shelfpage.enterManualShelfName();
		shelfpage.enterManualShelfDescription();
		shelfpage.clickOnContinue();
		shelfpage.verifyShelfCreatedSuccessfully();
	}
	
	//@Test
	public void verifyAddToShelf1() throws Exception
	{		
		collection.selectAllBooks();
		collection.addToShelf();
		collection.verifyShelfCreatedSuccessfully();
	}
	
	//@Test
	public void verifyBookAddedToShelf() throws Exception 
	{
		collection.clickOnBackButton();
		
		shelfpage.clickOnShelves();
		//obj1.clickOnDrafts();
		shelfpage.clickOnShelf();
		
		shelfpage.selectBookCheckbox();
		shelfpage.clickPublish();
		
		boolean publishBook=shelfpage.verifyShelfPublishedSuccessfully();
		Assert.assertTrue(publishBook);
	}
	
	//@Test
	public void searchByUploadIsbn1() throws Exception
	{		
		collection.clickOnMyCollection();
		collection.clickOnIsbnTab();
		collection.uploadIsbnFile();
		collection.verifyNotMatchedIsbnCount();
		collection.verifyMatchedIsbnCount();
		
	}
}