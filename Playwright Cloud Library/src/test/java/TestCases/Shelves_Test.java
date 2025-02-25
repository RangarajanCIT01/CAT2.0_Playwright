package TestCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.Map;

import BaseClass.PlaywrightFactory;
import TestPages.MyCollectionPage;
import TestPages.SearchPage;

public class Shelves_Test extends PlaywrightFactory {

	@BeforeClass
	public void setupBefore() throws Exception {

		collection = new MyCollectionPage(page);
		searchpage = new SearchPage(page);
		shelves = new Shelves_Test();
		searchpage.clickOnSearch();
		Map<String, String> testData = baseTest.readJsonElement("SearchData.json", "searchdetails");
	
		searchpage.clickSearchButton();
		searchpage.editorDropdown(testData.get("Book_PageSize"));	
		searchpage.clseLftPnlIfExists();
	}

	@Test(priority = 1)
	public void verifyCreateManualShelf() throws Exception {

		shelfpage.clickOnShelves();
		shelfpage.clickOnNewShelve();
		shelfpage.manualShelfType();
		shelfpage.enterManualShelfName();
		shelfpage.enterManualShelfDescription();
		shelfpage.clickOnContinue();
		shelfpage.verifyShelfCreatedSuccessfully();
	}
	
	@Test(priority = 2)
	public void verifyAddToShelf() throws Exception {
		
		Map<String, String> testData = baseTest.readJsonElement("ShelfData.json", "ManualShelf");
		String data = testData.get("ManualShelfName");
		String selectShelf = "//span[text()='"+ data +"']";
		
		searchpage.clickOnSearch();
		shelfpage.clickOnShelves();
		shelfpage.clickElement(selectShelf);
		searchpage.containsVerify(shelfpage.lblManual, testData.get("LblManual"));
		searchpage.containsVerify(shelfpage.lblDraft, testData.get("LblDraft"));
		
		shelfpage.clickElement(shelfpage.btnAddItems);
		searchpage.enterBookTitle(testData.get("Book_Title"));
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.loadResult();
		shelfpage.selectAllBooks();
		shelfpage.addToShelf();
		shelfpage.clseLftPnlIfExists();
		
	}
	
	@Test(priority = 3)
	public void verifyPublishStatus() throws Exception {
		Map<String, String> testData = baseTest.readJsonElement("ShelfData.json", "ManualShelf");
		String data = testData.get("ManualShelfName");
		String selectShelf = "//span[text()='"+ data +"']";
		shelfpage.clickOnShelves();
		shelfpage.clickElement(selectShelf);
		shelfpage.clickElement(shelfpage.btnPublish);
		shelfpage.clickElement(selectShelf);
		searchpage.containsVerify(shelfpage.lblLive, testData.get("lblLive"));
		shelfpage.clickElement(shelfpage.lnkback);
		searchpage.loadResult();
	}

	@Test(priority = 4)
	public void verifyDeleteShelf() throws Exception {
	
		shelfpage.clickOnShelves();
		shelfpage.loadResult();
		shelfpage.clickOnDeleteShelf();
		shelfpage.verifyDeleteConfrm();
	}

	@Test(priority = 5)
	public void verifyCreateAutomatedShelf() throws Exception {

		shelfpage.clickOnShelves();
		shelfpage.clickOnNewShelve();
		shelfpage.shelfTypeAutomated();
		shelfpage.enterAutomatedShelfName();
		shelfpage.enterAutomatedShelfDescription();
		shelfpage.clickOnContinue();		
		//shelfpage.verifyShelfCreatedSuccessfully();
	}

	@Test(priority = 6)
	public void AutomatedShelf_AddData() throws Exception {
		
		Map<String, String> testData = baseTest.readJsonElement("ShelfData.json", "AutomatedShelf");
		String data = testData.get("AutomatedShelfName");
		String selectShelf = "//span[text()='"+ data +"']";
		
		shelfpage.clickElement(shelfpage.autoCreateShelf);
		shelfpage.clickOnShelves();
		shelfpage.clickElement(selectShelf);
		searchpage.containsVerify(shelfpage.lblAutomated, testData.get("LblAutomated"));
		searchpage.containsVerify(shelfpage.lblDraft, testData.get("LblDraft"));	
	}
	
	@Test(priority = 7)
	public void verifyAutoPublishStatus() throws Exception {
		Map<String, String> testData = baseTest.readJsonElement("ShelfData.json", "AutomatedShelf");
		String data = testData.get("AutomatedShelfName");
		String selectShelf = "//span[text()='"+ data +"']";
		shelfpage.clickElement(shelfpage.btnPublish);
		shelfpage.clickElement(selectShelf);
		searchpage.containsVerify(shelfpage.lblLive, testData.get("lblLive"));
		shelfpage.clickElement(shelfpage.lnkback);
		searchpage.loadResult();
	}

	@Test(priority = 8)
	public void verifyAutoDeleteShelf() throws Exception {
	
		shelfpage.clickOnShelves();
		shelfpage.loadResult();
		shelfpage.clickOnAutoDeleteShelf();
		shelfpage.verifyDeleteConfrm();
	}
	

}