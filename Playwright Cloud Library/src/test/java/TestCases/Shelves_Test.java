package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseTest5;
import com.pages.MyCollectionPage;
import com.pages.Shelf;

public class Shelves_Test extends BaseTest5{

		
	@Test
	public void verifyCreateShelf() throws Exception
	{
		shelfpage=new Shelf(page);
		
		shelfpage.clickOnShelves();
		
		boolean ShelfTitle=shelfpage.verifyShelfTitle();
		
		if(ShelfTitle==true)
		{
			shelfpage.clickOnDeleteShelf();
			shelfpage.clickOnNewShelve();
			shelfpage.manualShelfType();
			shelfpage.enterManualShelfName();
			shelfpage.enterManualShelfDescription();
			shelfpage.clickOnContinue();
			
			// Assert Message
	
			boolean shelfAdded=shelfpage.verifyShelfCreatedSuccessfully();
			if(shelfAdded==true)
			{
				Assert.assertTrue(shelfAdded);
			}
			else
			{
				Assert.assertTrue(shelfAdded);
			}
		}
		else
		{
			shelfpage.clickOnNewShelve();
			shelfpage.manualShelfType();
			shelfpage.enterManualShelfName();
			shelfpage.enterManualShelfDescription();
			shelfpage.clickOnContinue();
			
			// Assert Message
			
			boolean shelf1Added=shelfpage.verifyShelfCreatedSuccessfully();
			if(shelf1Added==true)
			{
				Assert.assertTrue(shelf1Added);
			}
			else
			{
				Assert.assertTrue(shelf1Added);
			}
		}
		
	}
	
	
	@Test(dependsOnMethods="verifyCreateShelf")
	public void verifySearchCollection() throws Exception
	{
		collection=new MyCollectionPage(page);
		
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
	
	@Test(dependsOnMethods="verifySearchCollection")
	public void verifyAddToShelf() throws Exception
	{
		collection=new MyCollectionPage(page);
		
		collection.selectAllBooks();
		collection.addToShelf();
		collection.verifyShelfCreatedSuccessfully();
	}
	
	@Test(description = "Verify Title & Publish book",dependsOnMethods="verifyAddToShelf")
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
}