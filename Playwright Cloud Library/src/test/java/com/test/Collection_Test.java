package com.test;


import org.testng.Assert;
import org.testng.annotations.Test;
import com.base.BaseTest5;
import com.pages.MyCollectionPage;

public class Collection_Test extends BaseTest5{

	@Test(priority=1)
	public void verifySearchCollection() throws Exception
	{
		collection.clickOnMyCollection();
		//collection.enterBookKeyword();
		collection.enterBookTitle();
		collection.enterBookAuthor();
		collection.enterBookNarrator();
		collection.enterBookSeries();
		//collection.preSaleTitles();
		//collection.enterBookHoldRatio();
		//collection.catergoryAndSubject();
		//collection.audience();
		//collection.enterPrice();
		collection.publishedWithin();
		collection.dateAddedToCloudLibrary();
		collection.languages();
		//collection.publisher();
		collection.contentProviders();
		collection.bookFormats();
		//collection.bookFilters();
		collection.clickSearchButton();
		collection.verifybookSearchByTitleCount();
		
	}
	
	//@Test(priority=2)
	public void verifyAddToShelf() throws Exception
	{
		collection=new MyCollectionPage(page);
		
		collection.selectAllBooks();
		collection.addToShelf();
		collection.verifyShelfCreatedSuccessfully();
	}
	
	//@Test(priority=3)
	public void searchByIsbnCollection() throws Exception
	{
		collection=new MyCollectionPage(page);
		
		collection.clickOnBackButton();
		collection.clickOnMyCollection();
		collection.clickOnIsbnTab();
		collection.enterIsbn();
		collection.clickOnIsbnSearchButton();
		collection.verifyTitleCount_Isbn();
		collection.clickOnBackButton();
	}
	
	//@Test(priority=4)
	public void searchByUploadIsbn() throws Exception
	{
		collection=new MyCollectionPage(page);
		
		collection.clickOnMyCollection();
		collection.clickOnIsbnTab();
		collection.uploadIsbnFile();
		collection.verifyNotMatchedIsbnCount();
		collection.verifyMatchedIsbnCount();
		
	}
	
	//@Test(priority=5)
	public void verifyCreateShelf() throws Exception
	{		
		shelfpage.clickOnShelves();
		
	
			shelfpage.clickOnNewShelve();
			shelfpage.manualShelfType();
			shelfpage.enterManualShelfName();
			shelfpage.enterManualShelfDescription();
			shelfpage.clickOnContinue();
			
			// Assert Message
			
			shelfpage.verifyShelfCreatedSuccessfully();
	}
	
	//Added the below methods from MyCollection class
	
	//@Test(priority=6)
	public void verifySearchCollection1() throws Exception
	{		
		collection.clickOnMyCollection();
		//collection.enterBookKeyword();
		collection.enterBookTitle();
		//collection.enterBookAuthor();
		//collection.enterBookNarrator();
		//collection.enterBookSeries();
		//collection.preSaleTitles();
		//collection.enterBookHoldRatio();
		//collection.catergoryAndSubject(page);
		//collection.audience(page);
		//collection.enterPrice();
		//collection.publishedWithin();
		//collection.dateAddedToCloudLibrary();
		collection.languages();
	//	collection.publisher(page);
		//collection.contentProviders();
		collection.bookFormats();
		//collection.bookFilters();
		collection.clickSearchButton();
		collection.verifybookSearchByTitleCount();
		
	}
	
	//@Test(priority=7)
	public void verifyAddToShelf1() throws Exception
	{		
		collection.selectAllBooks();
		collection.addToShelf();
		collection.verifyShelfCreatedSuccessfully();
	}
	
	//@Test(priority=8)
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
	
	//@Test(priority=9)
	public void searchByIsbnCollection1() throws Exception
	{		
		collection.clickOnBackButton();
		collection.clickOnMyCollection();
		collection.clickOnIsbnTab();
		collection.enterIsbn();
		collection.clickOnIsbnSearchButton();
		collection.verifyTitleCount_Isbn();
		collection.clickOnBackButton();
	}
	
	//@Test(priority=10)
	public void searchByUploadIsbn1() throws Exception
	{		
		collection.clickOnMyCollection();
		collection.clickOnIsbnTab();
		collection.uploadIsbnFile();
		collection.verifyNotMatchedIsbnCount();
		collection.verifyMatchedIsbnCount();
		
	}
}