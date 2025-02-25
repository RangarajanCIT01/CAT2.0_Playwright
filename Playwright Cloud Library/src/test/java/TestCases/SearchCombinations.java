package TestCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.ArrayList;
import java.util.Map;

import com.aventstack.extentreports.Status;

import BaseClass.PlaywrightFactory;
import TestPages.MyCollectionPage;
import TestPages.SearchPage;

public class SearchCombinations extends PlaywrightFactory{
	
	@BeforeClass
	public void setupBefore() throws Exception {
		
		collection=new MyCollectionPage(page);
		searchpage=new SearchPage(page);
		searchpage.clickOnSearch();
		Map<String, String> testData = baseTest.readJsonElement("SearchData.json", "searchdetails");
		//Map<String, String> testDataCollection = playwrightFactory.readJsonElement("CollectionData.json", "collectionDetails");
		
		searchpage.clickSearchButton();
		searchpage.editorDropdown(testData.get("Book_PageSize"));	
		searchpage.clseLftPnlIfExists();
	}
	
	@Test
	public void VerifyTitleAndAuthor() throws Exception
	{		
		Map<String, String> testData = baseTest.readJsonElement("SearchCombinations.json", "VerifyTitleAndAuthor");
		
	
		searchpage.clseLftPnlIfExists();
		searchpage.navigateToCartAndSearchPage();
		extentTest.log(Status.INFO, "Entering Title Details");
		
		searchpage.enterBookTitle(testData.get("Book_Title"));
		searchpage.enterBookAuthor(testData.get("Book_Author"));
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.loadResult();
		
		searchpage.containsVerify(searchpage.AllElements, testData.get("Book_Title"));
		searchpage.containsVerify(searchpage.AllElements, testData.get("Book_Author"));			
		
		extentTest.log(Status.INFO, "Verified the details of Title results");

		searchpage.clseLftPnlIfExists();                                                                                          
		
	}
	
	@Test
	public void VerifyAuthorAndProvider() throws Exception
	{		
		Map<String, String> testData = baseTest.readJsonElement("SearchCombinations.json", "VerifyAuthorAndProvider");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		searchpage.clseLftPnlIfExists();
		searchpage.navigateToCartAndSearchPage();
		extentTest.log(Status.INFO, "Entering Author Details");
		
		searchpage.enterBookAuthor(testData.get("Book_Author"));
		searchpage.contentProviders(testData.get("Book_Provider"));
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.loadResult();
				
		searchpage.containsVerify(searchpage.AllElements, testData.get("Book_Author"));
		searchpage.containsVerify(searchpage.AllElements, testData.get("Book_Provider"));
		
		extentTest.log(Status.INFO, "Verified the details of Author results");

		searchpage.clseLftPnlIfExists();
		
	}
	
	@Test
	public void VerifySeriesAndProvider() throws Exception
	{		
		Map<String, String> testData = baseTest.readJsonElement("SearchCombinations.json", "VerifySeriesAndProvider");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		searchpage.clseLftPnlIfExists();
		searchpage.navigateToCartAndSearchPage();
		extentTest.log(Status.INFO, "Entering Series Details");
		
		searchpage.enterBookSeries(testData.get("Book_Series"));
		searchpage.waitForElement(2);
		searchpage.contentProviders(testData.get("Book_Provider"));
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.loadResult();
		
		searchpage.containsVerify(searchpage.AllElements, testData.get("Book_Series"));
		searchpage.containsVerify(searchpage.AllElements, testData.get("Book_Provider"));
		
		extentTest.log(Status.INFO, "Verified the details of Series results");

		searchpage.clseLftPnlIfExists();
		
	}
	
	@Test
	public void VerifyNarratorAndModel() throws Exception
	{		
		Map<String, String> testData = baseTest.readJsonElement("SearchCombinations.json", "VerifyNarratorAndModel");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		searchpage.clseLftPnlIfExists();
		searchpage.navigateToCartAndSearchPage();
		extentTest.log(Status.INFO, "Enter Narrator Details");
		
		searchpage.enterBookNarrator(testData.get("Book_Narrator"));
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.loadResult();
		
		searchpage.containsVerify(searchpage.AllElements, testData.get("Book_Narrator"));
		searchpage.containsVerify(searchpage.AllElements, testData.get("Book_Model"));
		
		extentTest.log(Status.INFO, "Verified the details of Narrator results");

		searchpage.clseLftPnlIfExists();
	}
	
	@Test
	public void VerifyPreSaleFilterTitlesAndPublisher() throws Exception
	{		
		Map<String, String> testData = baseTest.readJsonElement("SearchCombinations.json", "VerifyPreSaleFilterTitlesAndPublisher");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		searchpage.clseLftPnlIfExists();
		searchpage.navigateToCartAndSearchPage();
		extentTest.log(Status.INFO, "Select Only Presale Titles option");
		
		searchpage.enterBookTitle(testData.get("OnlyPreSale_Title"));
		searchpage.preSaleOnlyIncludeTitles(testData.get("Only Include Pre-Sale Titles"));
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.loadResult();
		searchpage.containsVerify(searchpage.AllElements, testData.get("OnlyPreSale_Title"));
		searchpage.clickElement(searchpage.Back);
		
		searchpage.enterBookTitle(testData.get("IncludePreSale_Title"));
		searchpage.publisher(testData.get("Book_Publisher"));
		searchpage.preSaleIncludeTitles(testData.get("IncludePreSale"));
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.loadResult();
		searchpage.containsVerify(searchpage.AllElements, testData.get("IncludePreSale_Title"));
		searchpage.containsVerify(searchpage.AllElements, testData.get("Book_Publisher"));
		searchpage.clickElement(searchpage.Back);		
		
		searchpage.clickClearButton();
		searchpage.enterBookTitle(testData.get("ExcludePreSale_Title"));
		searchpage.preSaleExcludeTitles(testData.get("ExcludePreSale"));
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.loadResult();
		searchpage.containsVerify(searchpage.AllElements, testData.get("ExcludePreSale_Title"));
		
		extentTest.log(Status.INFO, "Verified the details of Presale results");

		searchpage.clseLftPnlIfExists();
		
	}
	
	@Test
	public void VerifyHoldRatioAndSubject() throws Exception
	{		
		Map<String, String> testData = baseTest.readJsonElement("SearchCombinations.json", "VerifyHoldRatioAndSubject");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		searchpage.clseLftPnlIfExists();
		searchpage.navigateToCartAndSearchPage();
		extentTest.log(Status.INFO, "Enter Hold Ratio Details");
		
		searchpage.enterBookHoldRatio(testData.get("Book_HoldRatio"));
		searchpage.catergoryAndSubject(testData.get("Book_Category"));
		searchpage.enterBookAuthor(testData.get("Book_Author"));
		searchpage.waitForElement(4);	
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.loadResult();
		
		searchpage.waitForElement(4);		
		searchpage.containsVerify(searchpage.AllElements, testData.get("Book_Title"));
		searchpage.containsVerify(searchpage.AllElements, testData.get("Book_Subject"));
		
		extentTest.log(Status.INFO, "Verified the details of Title, Author and Publisher results");
		
		searchpage.clseLftPnlIfExists();
		
	}
	
	@Test
	public void VerifyTitleAuthorAndPublisher() throws Exception
	{		
		Map<String, String> testData = baseTest.readJsonElement("SearchCombinations.json", "VerifyTitleAuthorAndPublisher");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		searchpage.clseLftPnlIfExists();
		searchpage.navigateToCartAndSearchPage();
		extentTest.log(Status.INFO, "Enter Publisher Detail");
		
		searchpage.enterBookTitle(testData.get("Book_Title"));
		searchpage.enterBookAuthor(testData.get("Book_Author"));
		searchpage.publisher(testData.get("Book_Publisher"));
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.loadResult();
		
		searchpage.containsVerify(searchpage.AllElements, testData.get("Book_Title"));
		searchpage.containsVerify(searchpage.AllElements, testData.get("Book_Author"));
		searchpage.containsVerify(searchpage.AllElements, testData.get("Book_Publisher"));
		
		extentTest.log(Status.INFO, "Verified the details of Title, Author and Publisher results");

		searchpage.clseLftPnlIfExists();
		
	}
	
	@Test
	public void VerifyNarratorAndEdition() throws Exception
	{		
		Map<String, String> testData = baseTest.readJsonElement("SearchCombinations.json", "VerifyNarratorAndEdition");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		searchpage.clseLftPnlIfExists();
		searchpage.navigateToCartAndSearchPage();
		extentTest.log(Status.INFO, "Enter Content Provider Details");
		
		searchpage.enterBookTitle(testData.get("Book_Title"));
		searchpage.enterBookAuthor(testData.get("Book_Author"));
		searchpage.enterBookNarrator(testData.get("Book_Narrator"));

		searchpage.clickElement(searchpage.SearchButton);
		searchpage.loadResult();
		
		searchpage.containsVerify(searchpage.AllElements, testData.get("Book_Edition"));
		
		extentTest.log(Status.INFO, "Verified the details of Book Edition results");

		searchpage.clseLftPnlIfExists();
		
	}
	
	@Test
	public void VerifyStreetDateAndLastCirculated() throws Exception
	{		
		Map<String, String> testData = baseTest.readJsonElement("SearchCombinations.json", "VerifyStreetDateAndLastCirculated");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		searchpage.clseLftPnlIfExists();
		searchpage.navigateToCartAndSearchPage();
		extentTest.log(Status.INFO, "Enter Content Provider Details");
		
		searchpage.enterBookTitle(testData.get("Book_Title"));
		searchpage.enterBookAuthor(testData.get("Book_Author"));
			
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.loadResult();
		
		searchpage.containsVerify(searchpage.AllElements, testData.get("Book_StreetDate"));
		searchpage.containsVerify(searchpage.AllElements, testData.get("Book_LastCirculated"));
		
		extentTest.log(Status.INFO, "Verified the details of Street Date and Last Circulated results");

		searchpage.clseLftPnlIfExists();
		
	}
		
	@Test
	public void VerifyAddedToCatAndLastPurchased() throws Exception
	{		
		Map<String, String> testData = baseTest.readJsonElement("SearchCombinations.json", "VerifyAddedToCatAndLastPurchased");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		searchpage.clseLftPnlIfExists();
		searchpage.navigateToCartAndSearchPage();
		extentTest.log(Status.INFO, "Entering Title and Author Details");
		
		searchpage.enterBookTitle(testData.get("Book_Title"));
		searchpage.enterBookAuthor(testData.get("Book_Author"));
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.loadResult();
		
		searchpage.containsVerify(searchpage.AllElements, testData.get("Book_AddedToCAT"));
		searchpage.containsVerify(searchpage.AllElements, testData.get("Book_LastPurchased"));
			
		extentTest.log(Status.INFO, "Verified the details of Added to CAT and Last Purchased results");

		searchpage.clseLftPnlIfExists();  
		
	}
	
	@Test
	public void VerifyPublishedDateAndAllLoans() throws Exception
	{		
		Map<String, String> testData = baseTest.readJsonElement("SearchCombinations.json", "VerifyPublishedDateAndAllLoans");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		searchpage.clseLftPnlIfExists();
		searchpage.navigateToCartAndSearchPage();
		extentTest.log(Status.INFO, "Enter Published Date and All Loans Details");
		
		searchpage.enterBookTitle(testData.get("Book_Title"));
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.loadResult();
		
		searchpage.containsVerify(searchpage.AllElements, testData.get("Book_Published Date"));
		searchpage.containsVerify(searchpage.AllElements, testData.get("Book_AllLoans"));
		
		extentTest.log(Status.INFO, "Verified the details of Published Date and All Loans details");

		searchpage.clseLftPnlIfExists();
		
	}
	
	@Test
	public void VerifyAllBookDetails() throws Exception
	{		
		Map<String, String> testData = baseTest.readJsonElement("SearchCombinations.json", "VerifyAllBookDetails");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		searchpage.clseLftPnlIfExists();
		searchpage.navigateToCartAndSearchPage();
		extentTest.log(Status.INFO, "Verify with All book details");
		
		searchpage.enterBookTitle(testData.get("Book_Title"));
		searchpage.enterBookNarrator(testData.get("Book_Narrator"));
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.loadResult(); 
	
		searchpage.clickElement(searchpage.coverimg);		
		searchpage.loadResult();
		searchpage.containsVerify(searchpage.AllElementsDetailsPage, testData.get("Book_USGrade"));
		searchpage.containsVerify(searchpage.AllElementsDetailsPage, testData.get("Book_Series"));
		searchpage.containsVerify(searchpage.AllElementsDetailsPage, testData.get("Book_Author"));
		searchpage.containsVerify(searchpage.AllElementsDetailsPage, testData.get("Book_Narrator"));
		searchpage.containsVerify(searchpage.AllElementsDetailsPage, testData.get("Book_Category"));
		searchpage.containsVerify(searchpage.AllElementsDetailsPage, testData.get("Book_Language"));
		searchpage.containsVerify(searchpage.AllElementsDetailsPage, testData.get("Book_Format"));
		searchpage.containsVerify(searchpage.AllElementsDetailsPage, testData.get("Book_Provider"));
		searchpage.containsVerify(searchpage.AllElementsDetailsPage, testData.get("Book_Publisher"));
		searchpage.containsVerify(searchpage.AllElementsDetailsPage, testData.get("Book_Edition"));
		searchpage.containsVerify(searchpage.AllElementsDetailsPage, testData.get("Book_PublishedDate"));
		searchpage.containsVerify(searchpage.AllElementsDetailsPage, testData.get("Book_StreetDate"));
		searchpage.containsVerify(searchpage.AllElementsDetailsPage, testData.get("Book_AddedToCAT"));
		searchpage.containsVerify(searchpage.AllElementsDetailsPage, testData.get("Book_Model"));
		searchpage.containsVerify(searchpage.AllElementsDetailsPage, testData.get("Book_Duration"));
		searchpage.containsVerify(searchpage.AllElementsDetailsPage, testData.get("Book_ISBN"));
		searchpage.containsVerify(searchpage.AllElementsDetailsPage, testData.get("Book_LastPurchased"));
		searchpage.containsVerify(searchpage.AllElementsDetailsPage, testData.get("Book_Audience"));
		
		searchpage.clickElement(searchpage.Back);
		
		extentTest.log(Status.INFO, "Verified the details of Published Date");

		searchpage.clseLftPnlIfExists();
		
	}
	
	@Test
	public void VerifyDateAddedToCat() throws Exception
	{		
		Map<String, String> testData = baseTest.readJsonElement("SearchData.json", "VerifyDateAddedToCat");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		searchpage.clseLftPnlIfExists();
		searchpage.navigateToCartAndSearchPage();
		extentTest.log(Status.INFO, "Enter the title details");
		
		searchpage.enterBookTitle(testData.get("Book_Title"));
		searchpage.enterBookAuthor(testData.get("Book_Author"));
		searchpage.enterBookSeries(testData.get("Book_Series"));
		searchpage.languages(testData.get("Book_Language"));
		searchpage.contentProviders(testData.get("Book_Provider"));
		searchpage.enterPrice(testData.get("Book_Min"),testData.get("Book_Max"));
		searchpage.waitForElement(2);
		searchpage.clickElement(searchpage.drpdwnAddedToCAT);
		searchpage.waitForElement(2);
		searchpage.selectDropdownSpecificSearchEquals(testData.get("Custom_Filter"), searchpage.publicationList);
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.loadResult(); 
	
		searchpage.containsVerify(searchpage.AllElements, testData.get("AddedToCAT_Date"));
		extentTest.log(Status.INFO, "Verified the details of Added to CAT Date");
		searchpage.clseLftPnlIfExists();	
	}
	
	@Test
	public void VerifyLanguage() throws Exception
	{		
		Map<String, String> testData = baseTest.readJsonElement("SearchData.json", "VerifyLanguage");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		searchpage.clseLftPnlIfExists();
		searchpage.navigateToCartAndSearchPage();
		extentTest.log(Status.INFO, "Enter Language Details");
		
		searchpage.languages(testData.get("Book_Language"));
		searchpage.enterBookTitle(testData.get("Book_Title"));
		
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.loadResult();
		
		searchpage.containsVerify(searchpage.AllElements, testData.get("Book_Language"));
		extentTest.log(Status.INFO, "Verified the details of Language results");

		searchpage.clseLftPnlIfExists();
		
	}
	
	//@Test 
	public void VerifyPPUTitles() throws Exception
	{		
		Map<String, String> testData = baseTest.readJsonElement("SearchData.json", "VerifyPPUTitles");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		searchpage.clseLftPnlIfExists();
		searchpage.navigateToCartAndSearchPage();
		extentTest.log(Status.INFO, "Verify with the PPU Filter Titles");
		
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
		searchpage.waitForElement(90);
		searchpage.loadResult();
		searchpage.containsVerify(searchpage.AllElements, testData.get("OnlyInclude_PPUTitle"));
		searchpage.clickElement(searchpage.Back);
		extentTest.log(Status.INFO, "Verified the Only Include PPU Titles");
		
		searchpage.enterBookTitle(testData.get("Exclude_PPUTitle"));
		searchpage.ExcludePPUTitles(testData.get("Exclude_PPU"));
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.loadResult();
		searchpage.containsVerify(searchpage.AllElements, testData.get("Exclude_PPUTitle"));
		extentTest.log(Status.INFO, "Verified the Exclude PPU Titles");		

		searchpage.clseLftPnlIfExists();
		
	}
	
	
	
	@Test
	public void VerifyColTitle() throws Exception
	{		
		Map<String, String> testData = baseTest.readJsonElement("CollectionData.json", "VerifyColTitle");
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
		Map<String, String> testData = baseTest.readJsonElement("CollectionData.json", "VerifyColAuthor");
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
		Map<String, String> testData = baseTest.readJsonElement("CollectionData.json", "VerifyColSeries");
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
		Map<String, String> testData = baseTest.readJsonElement("CollectionData.json", "VerifyColNarrator");
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
		Map<String, String> testData = baseTest.readJsonElement("CollectionData.json", "VerifyColHoldRatio");
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
		Map<String, String> testData = baseTest.readJsonElement("CollectionData.json", "VerifyColPublisher");
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
		Map<String, String> testData = baseTest.readJsonElement("CollectionData.json", "VerifyColContentProvider");
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
		Map<String, String> testData = baseTest.readJsonElement("CollectionData.json", "VerifyColFormat");
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
		searchpage.waitForElement(10);
		searchpage.loadResult();
		searchpage.containsVerify(searchpage.AllElements, testData.get("Format_PDF"));
		
		searchpage.clickElement(searchpage.Back);
		searchpage.uncheckPDFAndMP3();
		searchpage.enterBookTitle(testData.get("Book_EPUBTitle"));
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.waitForElement(10);
		searchpage.loadResult();
		searchpage.containsVerify(searchpage.AllElements, testData.get("Format_EPUB"));		
		
		extentTest.log(Status.INFO, "Verified the details of Author results");

		searchpage.clseLftPnlIfExists();
		
	}
	
	@Test
	public void VerifyColCategoryAndSubject() throws Exception
	{		
		Map<String, String> testData = baseTest.readJsonElement("CollectionData.json", "VerifyColCategoryAndSubject");
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
		Map<String, String> testData = baseTest.readJsonElement("CollectionData.json", "VerifyColAudience");
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
		Map<String, String> testData = baseTest.readJsonElement("CollectionData.json", "VerifyColPricing");
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
		Map<String, String> testData = baseTest.readJsonElement("CollectionData.json", "VerifyColPublishedWithin");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		searchpage.clseLftPnlIfExists();
		collection.navigateToCartAndCollectionPage();
		extentTest.log(Status.INFO, "Selecting Published Within Details");
		
		searchpage.enterBookTitle(testData.get("Book_Title"));
		searchpage.enterBookAuthor(testData.get("Book_Author"));
		searchpage.languages(testData.get("Book_Language"));
		searchpage.enterPrice(testData.get("Book_Min"),testData.get("Book_Max") );
		searchpage.waitForElement(2);
		searchpage.clickElement(searchpage.drpdwnColpublishedWithin);
		searchpage.waitForElement(2);
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
		Map<String, String> testData = baseTest.readJsonElement("CollectionData.json", "VerifyColDateAddedToCAT");
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
	
	//@Test -> Need to work
	public void VerifyColDatePurchased() throws Exception
	{		
		Map<String, String> testData = baseTest.readJsonElement("CollectionData.json", "VerifyColDatePurchased");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		searchpage.clseLftPnlIfExists();
		collection.navigateToCartAndCollectionPage();
		extentTest.log(Status.INFO, "Enter the title details");
		
		searchpage.enterBookTitle(testData.get("Book_Title"));
		searchpage.enterBookAuthor(testData.get("Book_Author"));
		//searchpage.enterBookSeries(testData.get("Book_Series"));
		//searchpage.languages(testData.get("Book_Language"));
		//searchpage.contentProviders(testData.get("Book_Provider"));
		//searchpage.enterPrice(testData.get("Book_Min"),testData.get("Book_Max"));
		searchpage.waitForElement(2);
		searchpage.clickElement(searchpage.drpdwnDatePurchased);
		searchpage.waitForElement(2);
		searchpage.selectDropdownSpecificSearchEquals(testData.get("Custom_Filter"), searchpage.publicationList);
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.loadResult(); 
	
		searchpage.containsVerify(searchpage.AllElements, testData.get("AddedToCAT_Date"));
		extentTest.log(Status.INFO, "Verified the details of Added to CAT Date");
		searchpage.clseLftPnlIfExists();	
	}
	
	
	@Test
	public void VerifyColLanguage() throws Exception
	{		
		Map<String, String> testData = baseTest.readJsonElement("CollectionData.json", "VerifyColLanguage");
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
		Map<String, String> testData = baseTest.readJsonElement("CollectionData.json", "VerifyColPPUTitles");
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

