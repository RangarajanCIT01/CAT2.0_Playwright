package TestCases;

import java.util.ArrayList;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.base.BaseTest;
import com.pages.SearchPage;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Search_AdvSearchTest extends BaseTest{
	
	@BeforeClass
	public void setupBefore() throws Exception {
		
		searchpage=new SearchPage(page);
		searchpage.clickOnSearch();
		Map<String, String> testData = playwrightFactory.readJsonElement("SearchData.json", "searchdetails");
	
		searchpage.clickSearchButton();
		searchpage.editorDropdown(testData.get("Book_PageSize"));	
		searchpage.clseLftPnlIfExists();
	}
	
	@Test
	public void VerifyTitle() throws Exception
	{		
		Map<String, String> testData = playwrightFactory.readJsonElement("SearchData.json", "VerifyTitle");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		searchpage.clseLftPnlIfExists();
		searchpage.navigateToCartAndSearchPage();
		extentTest.log(Status.INFO, "Entering Title Details");
		
		searchpage.enterBookTitle(testData.get("Book_Title"));
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.loadResult();
		
		searchpage.containsVerify(searchpage.AllElements, testData.get("Book_Title"));
			
		//assertThat(page.getByText(testData.get("Book_Title"))).isVisible();
		
		extentTest.log(Status.INFO, "Verified the details of Title results");

		searchpage.clseLftPnlIfExists();                                                                                          
		
	}
	
	@Test
	public void VerifyAuthor() throws Exception
	{		
		Map<String, String> testData = playwrightFactory.readJsonElement("SearchData.json", "VerifyAuthor");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		searchpage.clseLftPnlIfExists();
		searchpage.navigateToCartAndSearchPage();
		extentTest.log(Status.INFO, "Entering Author Details");
		
		searchpage.enterBookAuthor(testData.get("Book_Author"));
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.loadResult();
		
		//assertThat(page.getByText(testData.get("Book_Author"))).isVisible();
		
		searchpage.containsVerify(searchpage.AllElements, testData.get("Book_Author"));
		
		extentTest.log(Status.INFO, "Verified the details of Author results");

		searchpage.clseLftPnlIfExists();
		
	}
	
	@Test
	public void VerifySeries() throws Exception
	{		
		Map<String, String> testData = playwrightFactory.readJsonElement("SearchData.json", "VerifySeries");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		searchpage.clseLftPnlIfExists();
		searchpage.navigateToCartAndSearchPage();
		extentTest.log(Status.INFO, "Entering Series Details");
		
		searchpage.enterBookSeries(testData.get("Book_Series"));
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.loadResult();
		
		searchpage.containsVerify(searchpage.AllElements, testData.get("Book_Series"));
		
		//assertThat(page.getByText(testData.get("Book_Series"))).isVisible();
			
		extentTest.log(Status.INFO, "Verified the details of Series results");

		searchpage.clseLftPnlIfExists();
		
	}
	
	@Test
	public void VerifyNarrator() throws Exception
	{		
		Map<String, String> testData = playwrightFactory.readJsonElement("SearchData.json", "VerifyNarrator");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		searchpage.clseLftPnlIfExists();
		searchpage.navigateToCartAndSearchPage();
		extentTest.log(Status.INFO, "Enter Narrator Details");
		
		searchpage.enterBookNarrator(testData.get("Book_Narrator"));
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.loadResult();
		
		searchpage.containsVerify(searchpage.AllElements, testData.get("Book_Narrator"));
		
		//assertThat(page.getByText(testData.get("Book_Narrator"))).isVisible();
		
		extentTest.log(Status.INFO, "Verified the details of Narrator results");

		searchpage.clseLftPnlIfExists();
		
	}
	
	@Test
	public void VerifyPreSaleFilterTitles() throws Exception
	{		
		Map<String, String> testData = playwrightFactory.readJsonElement("SearchData.json", "VerifyPreSaleFilterTitles");
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
		searchpage.preSaleIncludeTitles(testData.get("IncludePreSale"));
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.loadResult();
		searchpage.containsVerify(searchpage.AllElements, testData.get("IncludePreSale_Title"));
		searchpage.clickElement(searchpage.Back);
		
		searchpage.enterBookTitle(testData.get("ExcludePreSale_Title"));
		searchpage.preSaleExcludeTitles(testData.get("ExcludePreSale"));
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.loadResult();
		searchpage.containsVerify(searchpage.AllElements, testData.get("ExcludePreSale_Title"));
		
		extentTest.log(Status.INFO, "Verified the details of Presale results");

		searchpage.clseLftPnlIfExists();
		
	}
	
	@Test
	public void VerifyHoldRatio() throws Exception
	{		
		Map<String, String> testData = playwrightFactory.readJsonElement("SearchData.json", "VerifyHoldRatio");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		searchpage.clseLftPnlIfExists();
		searchpage.navigateToCartAndSearchPage();
		extentTest.log(Status.INFO, "Enter Hold Ratio Details");
		
		searchpage.enterBookHoldRatio(testData.get("Book_HoldRatio"));
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.loadResult();
		
		searchpage.containsVerify(searchpage.AllElements, testData.get("Book_Title"));
		
		//assertThat(page.getByText(testData.get("Book_Title"))).isVisible();
		
		searchpage.clseLftPnlIfExists();
		
	}
	
	@Test
	public void VerifyPublisher() throws Exception
	{		
		Map<String, String> testData = playwrightFactory.readJsonElement("SearchData.json", "VerifyPublisher");
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
		
		searchpage.containsVerify(searchpage.AllElements, testData.get("Book_Publisher"));
		
		extentTest.log(Status.INFO, "Verified the details of Publisher results");

		searchpage.clseLftPnlIfExists();
		
	}
	
	@Test
	public void VerifyContentProvider() throws Exception
	{		
		Map<String, String> testData = playwrightFactory.readJsonElement("SearchData.json", "VerifyContentProvider");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		searchpage.clseLftPnlIfExists();
		searchpage.navigateToCartAndSearchPage();
		extentTest.log(Status.INFO, "Enter Content Provider Details");
		
		searchpage.enterBookTitle(testData.get("Book_Title"));
		searchpage.contentProviders(testData.get("Book_ContentProvider"));
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.loadResult();
		
		searchpage.containsVerify(searchpage.AllElements, testData.get("Book_ContentProvider"));
		
		extentTest.log(Status.INFO, "Verified the details of Content Provider results");

		searchpage.clseLftPnlIfExists();
		
	}
	
	@Test
	public void VerifyFormat() throws Exception
	{		
		Map<String, String> testData = playwrightFactory.readJsonElement("SearchData.json", "VerifyFormat");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		searchpage.clseLftPnlIfExists();
		searchpage.navigateToCartAndSearchPage();
		extentTest.log(Status.INFO, "Selecting Format Details");
				
		searchpage.enterBookTitle(testData.get("Book_MP3Title"));
		searchpage.uncheckEPUBAndPDF();
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.loadResult();
		searchpage.containsVerify(searchpage.AllElements, testData.get("Format_MP3"));
		
		searchpage.clickElement(searchpage.Back);
		searchpage.uncheckEPUBAndMP3();
		searchpage.enterBookTitle(testData.get("Book_PDFTitle"));
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.loadResult();
		searchpage.containsVerify(searchpage.AllElements, testData.get("Format_PDF"));
		
		searchpage.clickElement(searchpage.Back);
		searchpage.uncheckPDFAndMP3();
		searchpage.enterBookTitle(testData.get("Book_EPUBTitle"));
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.loadResult();
		searchpage.containsVerify(searchpage.AllElements, testData.get("Format_EPUB"));
		
		extentTest.log(Status.INFO, "Verified the details of Author results");

		searchpage.clseLftPnlIfExists();
	}
	
	@Test
	public void VerifyCategoryAndSubject() throws Exception
	{		
		Map<String, String> testData = playwrightFactory.readJsonElement("SearchData.json", "VerifyCategoryAndSubject");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		searchpage.clseLftPnlIfExists();
		searchpage.navigateToCartAndSearchPage();
		extentTest.log(Status.INFO, "Select Category and Audience Details");
		
		searchpage.enterBookTitle(testData.get("Book_Title"));
		searchpage.catergoryAndSubject(testData.get("CategoryAndSubject"));
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.loadResult();
		
		searchpage.containsVerify(searchpage.AllElements, testData.get("Verify_CategoryAndSub"));		
		
		extentTest.log(Status.INFO, "Verified the details of Author results");

		searchpage.clseLftPnlIfExists();
		
	}
	
	@Test
	public void VerifyAudience() throws Exception
	{		
		Map<String, String> testData = playwrightFactory.readJsonElement("SearchData.json", "VerifyAudience");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		searchpage.clseLftPnlIfExists();
		searchpage.navigateToCartAndSearchPage();
		extentTest.log(Status.INFO, "Entering Audience Details");
		
		searchpage.enterBookTitle(testData.get("Book_Title"));
		searchpage.audience(testData.get("Book_Audience"));
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.loadResult();
		
		searchpage.containsVerify(searchpage.AllElements, testData.get("Book_Audience"));
		
		//assertThat(page.getByText(testData.get("Book_Isbn"))).isVisible();
			
		extentTest.log(Status.INFO, "Verified the details of Author results");

		searchpage.clseLftPnlIfExists();  
		
	}
	
	@Test
	public void VerifyPricing() throws Exception
	{		
		Map<String, String> testData = playwrightFactory.readJsonElement("SearchData.json", "VerifyPricing");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		searchpage.clseLftPnlIfExists();
		searchpage.navigateToCartAndSearchPage();
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
	public void VerifyPublishedWithin() throws Exception
	{		
		Map<String, String> testData = playwrightFactory.readJsonElement("SearchData.json", "VerifyPublishedWithin");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		searchpage.clseLftPnlIfExists();
		searchpage.navigateToCartAndSearchPage();
		extentTest.log(Status.INFO, "Selecting Published Within Details");
		
		searchpage.enterBookTitle(testData.get("Book_Title"));
		searchpage.enterBookAuthor(testData.get("Book_Author"));
		searchpage.languages(testData.get("Book_Language"));
		searchpage.publisher(testData.get("Book_Publisher"));
		searchpage.enterPrice(testData.get("Book_Min"),testData.get("Book_Max") );
		searchpage.clickElement(searchpage.drpdwnpublishedWithin);
		searchpage.selectDropdownSpecificSearchEquals(testData.get("Custom_Filter"), searchpage.publicationList);
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.loadResult(); 
	
		searchpage.containsVerify(searchpage.AllElements, testData.get("Published_Date"));
		
		extentTest.log(Status.INFO, "Verified the details of Published Date");

		searchpage.clseLftPnlIfExists();
		
	}
	
	@Test
	public void VerifyDateAddedToCat() throws Exception
	{		
		Map<String, String> testData = playwrightFactory.readJsonElement("SearchData.json", "VerifyDateAddedToCat");
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
		Map<String, String> testData = playwrightFactory.readJsonElement("SearchData.json", "VerifyLanguage");
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
	
	@Test 
	public void VerifyPPUTitles() throws Exception
	{		
		Map<String, String> testData = playwrightFactory.readJsonElement("SearchData.json", "VerifyPPUTitles");
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
	public void VerifyPreSaleTitle() throws Exception
	{		
		Map<String, String> testData = playwrightFactory.readJsonElement("SearchData.json", "VerifyPreSaleTitle");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		searchpage.clseLftPnlIfExists();
		searchpage.navigateToCartAndSearchPage();
		extentTest.log(Status.INFO, "Enter PreSale Title Details");
		
		searchpage.enterBookTitle(testData.get("Book_Title"));
		searchpage.publisher(testData.get("Book_Publisher"));		
		
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.loadResult();
		
		searchpage.containsVerify(searchpage.AllElements, testData.get("PreSaleLabel"));
		extentTest.log(Status.INFO, "Verified the details of PreSale title");

		searchpage.clseLftPnlIfExists();
		
	}
	
	@Test
	public void VerifyPPUTitle() throws Exception
	{		
		Map<String, String> testData = playwrightFactory.readJsonElement("SearchData.json", "VerifyPPUTitle");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		searchpage.clseLftPnlIfExists();
		searchpage.navigateToCartAndSearchPage();
		extentTest.log(Status.INFO, "Enter PreSale Title Details");
		
		searchpage.enterBookTitle(testData.get("Book_Title"));
		searchpage.enterBookAuthor(testData.get("Book_Author"));
		searchpage.enterBookSeries(testData.get("Book_Series"));
		searchpage.enterBookNarrator(testData.get("Book_Narrator"));
		
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.loadResult();
		
		searchpage.containsVerify(searchpage.AllElements, testData.get("PPULabel"));
		extentTest.log(Status.INFO, "Verified the details of PPU title");

		searchpage.clseLftPnlIfExists();
		
	}
	
	@Test
	public void VerifyHiddenProviders() throws Exception
	{		
		Map<String, String> testData = playwrightFactory.readJsonElement("SearchData.json", "VerifyHiddenProviders");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();		
	
		searchpage.clseLftPnlIfExists();
		searchpage.navigateToCartAndSearchPage();
		extentTest.log(Status.INFO, "Enter PreSale Title Details");
		
		searchpage.waitForElement(10);
		searchpage.clickElement(searchpage.ContentProviders);
		//searchpage.scrollToBottom(searchpage.lastContentProvider);
		searchpage.clickElement(searchpage.lastContentProvider);
		
		
		//searchpage.containsVerify(searchpage.AllElements, testData.get("PPULabel"));
		extentTest.log(Status.INFO, "Verified the details of PPU title");

		searchpage.clseLftPnlIfExists();
		
	}
	
	
	
	
	
}

