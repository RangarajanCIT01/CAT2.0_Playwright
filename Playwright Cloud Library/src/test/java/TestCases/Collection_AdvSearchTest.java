package TestCases;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.ArrayList;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.base.BaseTest;
import com.pages.MyCollectionPage;
import com.pages.SearchPage;

public class Collection_AdvSearchTest extends BaseTest{

	@BeforeClass
	public void setupBefore() throws Exception {
		
		collection=new MyCollectionPage(page);
		searchpage = new SearchPage(page);
		collection.clickOnMyCollection();
		Map<String, String> testData = playwrightFactory.readJsonElement("CollectionData.json", "collectionDetails");
	
		searchpage.clickSearchButton();
		searchpage.editorDropdown(testData.get("Book_PageSize"));	
		searchpage.clseLftPnlIfExists();
	}
	
	@Test
	public void VerifyColTitle() throws Exception
	{		
		Map<String, String> testData = playwrightFactory.readJsonElement("CollectionData.json", "VerifyColTitle");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		searchpage.clseLftPnlIfExists();
		collection.navigateToCartAndCollectionPage();
		extentTest.log(Status.INFO, "Entering Title Details");
		
		collection.enterBookTitle(testData.get("Book_Title"));
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.loadResult();
		
		searchpage.containsVerify(searchpage.AllElements, testData.get("Book_Title"));
			
		//assertThat(page.getByText(testData.get("Book_Title"))).isVisible();
		
		extentTest.log(Status.INFO, "Verified the details of Title results");

		searchpage.clseLftPnlIfExists();                                                                                          
		
	}
	
	@Test
	public void VerifyColAuthor() throws Exception
	{		
		Map<String, String> testData = playwrightFactory.readJsonElement("CollectionData.json", "VerifyColAuthor");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		searchpage.clseLftPnlIfExists();
		collection.navigateToCartAndCollectionPage();
		extentTest.log(Status.INFO, "Entering Author Details");
		
		collection.enterBookTitle(testData.get("Book_Title"));
		collection.enterBookAuthor(testData.get("Book_Author"));
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.loadResult();
		
		searchpage.containsVerify(searchpage.AllElements, testData.get("Book_Author"));
		
		extentTest.log(Status.INFO, "Verified the details of Author results");

		searchpage.clseLftPnlIfExists();
		
	}
	
	@Test
	public void VerifyColSeries() throws Exception
	{		
		Map<String, String> testData = playwrightFactory.readJsonElement("CollectionData.json", "VerifyColSeries");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		searchpage.clseLftPnlIfExists();
		collection.navigateToCartAndCollectionPage();
		extentTest.log(Status.INFO, "Entering Series Details");
		
		collection.enterBookTitle(testData.get("Book_Title"));
		collection.enterBookSeries(testData.get("Book_Series"));
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.loadResult();
		
		searchpage.containsVerify(searchpage.AllElements, testData.get("Book_Series"));
		
		//assertThat(page.getByText(testData.get("Book_Series"))).isVisible();
			
		extentTest.log(Status.INFO, "Verified the details of Series results");

		searchpage.clseLftPnlIfExists();
		
	}
	
	@Test
	public void VerifyColNarrator() throws Exception
	{		
		Map<String, String> testData = playwrightFactory.readJsonElement("CollectionData.json", "VerifyColNarrator");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		searchpage.clseLftPnlIfExists();
		collection.navigateToCartAndCollectionPage();
		extentTest.log(Status.INFO, "Enter Narrator Details");
		
		collection.enterBookTitle(testData.get("Book_Title"));
		collection.enterBookNarrator(testData.get("Book_Narrator"));
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.loadResult();
		
		searchpage.containsVerify(searchpage.AllElements, testData.get("Book_Narrator"));
		
		//assertThat(page.getByText(testData.get("Book_Narrator"))).isVisible();
		
		extentTest.log(Status.INFO, "Verified the details of Narrator results");

		searchpage.clseLftPnlIfExists();
		
	}
	
	@Test
	public void VerifyColHoldRatio() throws Exception
	{		
		Map<String, String> testData = playwrightFactory.readJsonElement("CollectionData.json", "VerifyColHoldRatio");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		searchpage.clseLftPnlIfExists();
		collection.navigateToCartAndCollectionPage();
		extentTest.log(Status.INFO, "Enter Hold Ratio Details");
		
		collection.enterBookTitle(testData.get("Book_Title"));
		collection.enterBookHoldRatio(testData.get("Book_HoldRatio"));
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.loadResult();
		
		searchpage.containsVerify(searchpage.AllElements, testData.get("Book_Title"));
		
		searchpage.clseLftPnlIfExists();
		
	}

	@Test
	public void VerifyColPublisher() throws Exception
	{		
		Map<String, String> testData = playwrightFactory.readJsonElement("CollectionData.json", "VerifyColPublisher");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		searchpage.clseLftPnlIfExists();
		collection.navigateToCartAndCollectionPage();
		extentTest.log(Status.INFO, "Enter Publisher Detail");
		
		collection.enterBookTitle(testData.get("Book_Title"));
		collection.publisher(testData.get("Book_Publisher"));
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.loadResult();
		
		searchpage.containsVerify(searchpage.AllElements, testData.get("Book_Publisher"));
		
		extentTest.log(Status.INFO, "Verified the details of Publisher results");

		searchpage.clseLftPnlIfExists();
		
	}
	
	@Test
	public void VerifyColContentProvider() throws Exception
	{		
		Map<String, String> testData = playwrightFactory.readJsonElement("CollectionData.json", "VerifyColContentProvider");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		searchpage.clseLftPnlIfExists();
		collection.navigateToCartAndCollectionPage();
		extentTest.log(Status.INFO, "Enter Content Provider Details");
		
		collection.enterBookTitle(testData.get("Book_Title"));
		collection.contentProviders(testData.get("Book_ContentProvider"));
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.loadResult();
		
		searchpage.containsVerify(searchpage.AllElements, testData.get("Book_ContentProvider"));
		
		extentTest.log(Status.INFO, "Verified the details of Content Provider results");

		searchpage.clseLftPnlIfExists();
		
	}
	
	@Test
	public void VerifyColFormat() throws Exception
	{		
		Map<String, String> testData = playwrightFactory.readJsonElement("CollectionData.json", "VerifyColFormat");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		searchpage.clseLftPnlIfExists();
		collection.navigateToCartAndCollectionPage();
		extentTest.log(Status.INFO, "Select Format Details");
		
		searchpage.enterBookTitle(testData.get("Book_MP3Title"));
		searchpage.uncheckEPUBAndPDF();
		searchpage.clickElement(searchpage.SearchButton);

		searchpage.loadResult();
		searchpage.containsVerify(searchpage.AllElements, testData.get("Format_MP3"));
		
		searchpage.clickElement(searchpage.Back);
		searchpage.uncheckEPUBAndMP3();
		searchpage.enterBookTitle(testData.get("Book_PDFTitle"));
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.waitForElement(8);
		//searchpage.loadResult();
		searchpage.containsVerify(searchpage.AllElements, testData.get("Format_PDF"));
		
		searchpage.clickElement(searchpage.Back);
		searchpage.uncheckPDFAndMP3();
		searchpage.enterBookTitle(testData.get("Book_EPUBTitle"));
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.waitForElement(8);
		//searchpage.loadResult();
		searchpage.containsVerify(searchpage.AllElements, testData.get("Format_EPUB"));		
		
		extentTest.log(Status.INFO, "Verified the details of Author results");

		searchpage.clseLftPnlIfExists();
		
	}
	
	@Test
	public void VerifyColCategoryAndSubject() throws Exception
	{		
		Map<String, String> testData = playwrightFactory.readJsonElement("CollectionData.json", "VerifyColCategoryAndSubject");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		searchpage.clseLftPnlIfExists();
		collection.navigateToCartAndCollectionPage();
		extentTest.log(Status.INFO, "Select Category and Audience Details");
		
		searchpage.enterBookTitle(testData.get("Book_Title"));
		searchpage.catergoryAndSubject(testData.get("CategoryAndSubject"));
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.loadResult();
		
		searchpage.containsVerify(searchpage.AllElements, testData.get("VerifyCatAndSubj"));
		
		extentTest.log(Status.INFO, "Verified the details of Author results");

		searchpage.clseLftPnlIfExists();
		
	}
	
	@Test
	public void VerifyColAudience() throws Exception
	{		
		Map<String, String> testData = playwrightFactory.readJsonElement("CollectionData.json", "VerifyColAudience");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		searchpage.clseLftPnlIfExists();
		collection.navigateToCartAndCollectionPage();
		extentTest.log(Status.INFO, "Entering Audience Details");
		
		collection.enterBookTitle(testData.get("Book_Title"));
		collection.audience(testData.get("Book_Audience"));
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.loadResult();
		
		searchpage.containsVerify(searchpage.AllElements, testData.get("Book_Audience"));
					
		extentTest.log(Status.INFO, "Verified the details of Author results");

		searchpage.clseLftPnlIfExists();  
		
	}
	
	@Test
	public void VerifyColPricing() throws Exception
	{		
		Map<String, String> testData = playwrightFactory.readJsonElement("CollectionData.json", "VerifyColPricing");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		searchpage.clseLftPnlIfExists();
		collection.navigateToCartAndCollectionPage();
		extentTest.log(Status.INFO, "Enter Min and Max pricing Details");
		
		searchpage.enterBookTitle(testData.get("Book_Title"));
		searchpage.enterPrice(testData.get("Book_Min"), testData.get("Book_Max"));
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.loadResult();
		
		searchpage.containsVerify(searchpage.AllElements, testData.get("Book_Price"));
		
		extentTest.log(Status.INFO, "Verified the details of Pricing result");

		searchpage.clseLftPnlIfExists();
		
	}
	
	@Test
	public void VerifyColPublishedWithin() throws Exception
	{		
		Map<String, String> testData = playwrightFactory.readJsonElement("CollectionData.json", "VerifyColPublishedWithin");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		searchpage.clseLftPnlIfExists();
		collection.navigateToCartAndCollectionPage();
		extentTest.log(Status.INFO, "Selecting Published Within Details");
		
		searchpage.enterBookTitle(testData.get("Book_Title"));
		searchpage.enterBookAuthor(testData.get("Book_Author"));
		searchpage.languages(testData.get("Book_Language"));
		searchpage.enterPrice(testData.get("Book_Min"),testData.get("Book_Max") );
		searchpage.clickElement(searchpage.drpdwnColpublishedWithin);
		
		searchpage.selectDropdownSpecificSearchEquals(testData.get("Custom_Filter"), searchpage.publicationList);
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.loadResult(); 
	
		searchpage.containsVerify(searchpage.AllElements, testData.get("Published_Date"));
		
		extentTest.log(Status.INFO, "Verified the details of Published Date");

		searchpage.clseLftPnlIfExists();
		
	}
	
	@Test
	public void VerifyColDateAddedToCAT() throws Exception
	{		
		Map<String, String> testData = playwrightFactory.readJsonElement("CollectionData.json", "VerifyColDateAddedToCAT");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		searchpage.clseLftPnlIfExists();
		collection.navigateToCartAndCollectionPage();
		extentTest.log(Status.INFO, "Enter the title details");
		
		searchpage.enterBookTitle(testData.get("Book_Title"));
		searchpage.enterBookAuthor(testData.get("Book_Author"));
		searchpage.enterBookSeries(testData.get("Book_Series"));
		searchpage.languages(testData.get("Book_Language"));
		searchpage.contentProviders(testData.get("Book_Provider"));
		searchpage.enterPrice(testData.get("Book_Min"),testData.get("Book_Max"));
		searchpage.waitForElement(2);
		searchpage.clickElement(searchpage.drpdwnColAddedToCAT);
		searchpage.waitForElement(2);
		searchpage.selectDropdownSpecificSearchEquals(testData.get("Custom_Filter"), searchpage.publicationList);
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.loadResult(); 
	
		searchpage.containsVerify(searchpage.AllElements, testData.get("AddedToCAT_Date"));
		extentTest.log(Status.INFO, "Verified the details of Added to CAT Date");
		searchpage.clseLftPnlIfExists();	
	}
	
	@Test
	public void VerifyColDatePurchased() throws Exception
	{		
		Map<String, String> testData = playwrightFactory.readJsonElement("CollectionData.json", "VerifyColDatePurchased");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		searchpage.clseLftPnlIfExists();
		collection.navigateToCartAndCollectionPage();
		extentTest.log(Status.INFO, "Enter the title details");
		
		searchpage.enterBookTitle(testData.get("Book_Title"));
		searchpage.enterBookAuthor(testData.get("Book_Author"));
		searchpage.clickElement(searchpage.DatePurchased);
		searchpage.clickElement(searchpage.DateRange);		
		searchpage.clickElement(searchpage.DatePurchasedDateRange);
		searchpage.fillText(searchpage.DatePurchasedStartDate, testData.get("StartDate"));
		searchpage.PressTabKey(2);
		searchpage.fillText(searchpage.DatePurchasedEndDate, testData.get("EndDate"));
		searchpage.PressTabKey(2);
	
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.loadResult(); 
	
		searchpage.containsVerify(searchpage.AllElements, testData.get("Last_Purchased"));
		extentTest.log(Status.INFO, "Verified the details of Added to CAT Date");
		searchpage.clseLftPnlIfExists();	
	}
	
	
	@Test
	public void VerifyColLanguage() throws Exception
	{		
		Map<String, String> testData = playwrightFactory.readJsonElement("CollectionData.json", "VerifyColLanguage");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		searchpage.clseLftPnlIfExists();
		collection.navigateToCartAndCollectionPage();
		extentTest.log(Status.INFO, "Enter Language Details");
		
		searchpage.languages(testData.get("Book_Language"));
		searchpage.enterBookTitle(testData.get("Book_Title"));
		
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.loadResult();
		
		searchpage.containsVerify(searchpage.AllElements, testData.get("Book_verifyLanguage"));
		extentTest.log(Status.INFO, "Verified the details of Language results");

		searchpage.clseLftPnlIfExists();
		
	}
	
	@Test
	public void VerifyColPPUTitles() throws Exception
	{		
		Map<String, String> testData = playwrightFactory.readJsonElement("CollectionData.json", "VerifyColPPUTitles");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		searchpage.clseLftPnlIfExists();
		collection.navigateToCartAndCollectionPage();
		extentTest.log(Status.INFO, "Selecting Audience Details");
		
		searchpage.enterBookTitle(testData.get("Inlcude_PPUTitle"));
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.loadResult();
		searchpage.containsVerify(searchpage.AllElements, testData.get("Inlcude_PPUTitle"));
		searchpage.clickElement(searchpage.Back);
		extentTest.log(Status.INFO, "Verified the Include PPU Titles");
		
		searchpage.enterBookTitle(testData.get("OnlyInclude_PPUTitle"));
		searchpage.languages(testData.get("Book_Language"));
		searchpage.OnlyIncludePPUTitles(testData.get("Only_Include_PPU"));		
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.waitForElement(10);
		searchpage.loadResult();
		searchpage.containsVerify(searchpage.AllElements, testData.get("OnlyInclude_PPUTitle"));
		searchpage.clickElement(searchpage.Back);
		extentTest.log(Status.INFO, "Verified the Only Include PPU Titles");
		
		searchpage.enterBookTitle(testData.get("Exclude_PPUTitle"));
		searchpage.ExcludeColPPUTitles(testData.get("Exclude_PPU"));
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.loadResult();
		searchpage.waitForElement(5);
		searchpage.containsVerify(searchpage.AllElements, testData.get("Exclude_PPUTitle"));
		extentTest.log(Status.INFO, "Verified the Exclude PPU Titles");	

		searchpage.clseLftPnlIfExists();
		
	}
}