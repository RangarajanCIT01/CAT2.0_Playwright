package com.pages;



import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.testng.Assert;

import com.Factory.PlaywrightFactory;
import com.microsoft.playwright.FileChooser;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class SaveSearchPage extends PlaywrightFactory{
	
	// References
	private Page page;
	
	// String Locators -Object Repository -OR
	private String Search="//span[contains(text(),'Search')]";
	private String Keyword="//*[@name='keyword']";
	private String Title="//*[@name='title']";
	private String Author="//*[@name='AuthorSearch']";
	private String Narrator="//*[@name='Narrator']";
	private String Series="//*[@name='series']";
	private String PresalesTitles="//div[@class='ant-select-selector']//span[contains(@class,'ant-select-selection-item')]";
	private String HoldRatio="//*[@id='HoldRatio']";
	private String Category="//span[text()='Category and Subjects']/..//input";
	private String Audience="//span[text()='All Audiences']/..//input";
	private String PricingMinAmount="//*[@name='MinimumPriceAmount']";
	private String PricingMaxAmount="//*[@name='MaximumPriceAmount']";
	private String Publishers="//span[text()='Publishers']/..//input";
	private String ContentProviders="//span[text()='Content Providers']/..//input";
	private String PublishedWithin="//div[@class='searchbyDateSelect'][1]//div[@class='ant-select-selector']";
	private String DateAdded="//div[@class='searchbyDateSelect'][2]//div[@class='ant-select-selector']";
	private String Languages="//span[text()='Language(s)']/..//input";
	private String FormatsList="//span[@class='ant-checkbox ant-checkbox-checked']//input[@name='3']";
	private String FormatsList2="//span[@class='ant-checkbox ant-checkbox-checked']//input[@name='2']";
	private String FilterSelfPublished="//span[@class='ant-checkbox']//input[@name='ExcludeSelfPublished']";
	private String FormatText="//div[@class='ant-row']//div[@class='ant-col ant-col-24']//div[@class='ant-card-body']//p[@class='card-title' and contains(text(),'Formats')]";
	private String SearchButton="//div[@class='ant-row ant-row-end search-top']//button[@class='primary']";
	private String titleList="//span[@class='book-title']";
	public String TitleCount="//span[@class='title-count']";
	private String ClearButton="//input[@value='CLEAR' and @id='advanced-clear-btn']";
	private String AdvanceSearchButton="//button[@id='advanced-search-btn' and contains(text(),'SEARCH')]";
	private String EditorDropdown="//img[@src='/static/media/downIcon.b7f4ea24.svg' and @class='down-icon']";
	private String SelectAll="//button[@class='secondary']";
	private String AddToCartDropdown="//button[@class='cart-tomain-dropdown ']";
	public String cartAddedSuccessfully="//span[contains(text(),'Added successfully.')]";
	private String SortDropdown="//span[@class='ant-select-selection-item'  and @title='Default']";
	private String IsbnTab="//div[@role='tab' and contains(text(),'ISBN')]";
	private String IsbnList="//textarea[@name='isbn-list']";
	private String IsbnSearchButton="//button[@id='isbn-search-btn']";
	private String Back="//button[@class='back-button']";
	private String TotalNotMatched="//span[@class='total_not_matched']";
	private String SaveSearch="//input[@class='Search_Save_btn' and @type='button']";
	private String SearchName="//input[@name='SearchSaveName']";
	private String SearchDesc="//input[@name='SearchSaveDescription']";
	private String SaveButton="//button[@class='primary searchSave']";
	private String SavedTab="//div[@role='tab' and contains(text(),'Saved')]";
	public String searchSavedSuccessfully="//span[contains(text(),'Search Saved Successfully')]";
	private String TitleAdvSearch="//input[@class='ant-input card-input' and @id='Title']";
	private String SearchAdvance="//button[@id='advanced-search-btn' and contains(text(),'SEARCH')]";
	//button[@id='advanced-search-btn' and contains(text(),'SEARCH')]
	//input[@class='ant-input card-input' and @id='Title']
		
	// Page Constructor
	public SaveSearchPage(Page page)
	{
		this.page=page;
	}
	
	// Page actions /methods
	public void clickOnSearch() throws Exception 
	{
		waitForVisibilityOf(Search);
		clickElement(Search);
		Thread.sleep(2000);

	}
	
	// Enter Book Keyword
	public void enterBookKeyword() throws Exception 
	{
		Thread.sleep(2000);
		Map<String, String> testData = readJsonElement("SearchData.json", "searchdetails");
		fillText(Keyword,testData.get("Book_Keyword"));	
	}
	
	// Enter Book Title 
	public void enterBookTitle(String title) throws Exception 
	{	
		Thread.sleep(2000);

		fillText(Title,title);
		Thread.sleep(1000);
	}
	
	public void enterBookTitleAdv() throws Exception 
	{	
		Thread.sleep(1000);
		Map<String, String> testData = readJsonElement("SearchData.json", "searchdetails");
		fillText(TitleAdvSearch,testData.get("Book_Title"));
		Thread.sleep(1000);
	}
	
	// Enter Book Author 
	public void enterBookAuthor() throws Exception 
	{
		Map<String, String> testData = readJsonElement("SearchData.json", "searchdetails");
		fillText(Author,testData.get("Book_Author"));
	}
	
	// Enter Book Narrator 
	public void enterBookNarrator() throws Exception 
	{
		Map<String, String> testData = readJsonElement("SearchData.json", "searchdetails");
		fillText(Narrator,testData.get("Book_Narrator"));
	}
	
	// Enter Book Series 
	public void enterBookSeries() throws Exception 
	{
		Map<String, String> testData = readJsonElement("SearchData.json", "searchdetails");
		fillText(Series,testData.get("Book_Series"));
	}
	
	// Enter Book preSaleTitles 
	public void preSaleTitles() throws Exception 
	{
		Map<String, String> testData = readJsonElement("SearchData.json", "searchdetails");
		
		String Elementlist="//div[@class='rc-virtual-list']//div[@class='ant-select-item-option-content']";
		String presalesOption=testData.get("Book_Presales");
		
		selectDropdownByScrolling(PresalesTitles,presalesOption,Elementlist);
	}
	
	// Enter HoldRatio
	public void enterBookHoldRatio() throws Exception
	{
	
		Map<String, String> testData = readJsonElement("SearchData.json", "searchdetails");
		fillText(HoldRatio,testData.get("Book_Ratio"));
	}
	
	public void catergoryAndSubject(Page page) throws Exception 
	{
		Thread.sleep(1000);
		Map<String, String> testData = readJsonElement("SearchData.json","searchdetails");
		String categoryOption=testData.get("Book_Category");
		     
		clickElement(Category);
		fillText(Category,categoryOption);
		page.keyboard().down("ArrowDown");
		page.keyboard().press("Enter");
		
	
		page.getByText("Category and Subject").click();
	}   //thread remove
	
	public void audience(Page page,String audience) throws Exception
	{    
		Thread.sleep(1000);
	     
	    clickElement(Audience);
		fillText(Audience,audience);
		page.keyboard().down("ArrowDown");
		page.keyboard().press("Enter");   
	}
	
	public void enterPrice(String min,String max) throws Exception 
	{	
		Thread.sleep(1000);
		
		fillText(PricingMinAmount,min);
		fillText(PricingMaxAmount,max);
		Thread.sleep(1000);
	
	}
	
	public void publishedWithin() throws InterruptedException
	{
		selectDropdown(PublishedWithin,2);
		Thread.sleep(1000);
	}
	
	public void dateAddedToCloudLibrary() throws InterruptedException
	{
		selectDropdown(DateAdded,3);
	}
	
	public void languages(String language) throws Exception
	{
		//Thread.sleep(1000);
		     
		clickElement(Languages);
		fillText(Languages,language);
		page.keyboard().down("ArrowDown");
		page.keyboard().press("Enter");
	}
	
	
	public void publisher(Page page) throws Exception
	{
		Thread.sleep(2000);
		Map<String, String> testData = readJsonElement("SearchData.json","searchdetails");
		String publisherOption=testData.get("Book_Publisher");
		
		clickElement(Publishers);
		fillText(Publishers,publisherOption);
		page.keyboard().down("ArrowDown");
		page.keyboard().press("Enter");
		
		//selectDropdownByScrolling(Publishers,publisherOption,publisherElementList); 	
	}
	
	public void contentProviders() throws Exception
	{
		Thread.sleep(1000);
		Map<String, String> testData = readJsonElement("SearchData.json", "searchdetails");
		String providerOption=testData.get("Book_ContentProvider");
		
		clickElement(ContentProviders);
		fillText(ContentProviders,providerOption);
		page.keyboard().down("ArrowDown");
		Thread.sleep(1000);
		page.keyboard().press("Enter");
		
		//selectDropdownByScrolling(ContentProviders,providerOption,publisherElementList);
	}
	
	public void bookFormats(String format) throws Exception
	{
		Thread.sleep(1000);
		page.locator(FormatText).scrollIntoViewIfNeeded();
		
		SelectCheckbox(FormatsList,format);
		//SelectCheckbox(FormatsList2,formatOption);
	}
	
	public void bookFilters() throws InterruptedException
	{
		clickElement(FilterSelfPublished);
		Thread.sleep(1000);
	}
	
	public void clickSearchButton() throws InterruptedException 
	{
		Thread.sleep(1000);
		clickElement(SearchButton);
		Thread.sleep(6000);
	}
	
	public void advanceSearch() throws InterruptedException 
	{
		Thread.sleep(1000);
		clickElement(SearchAdvance);
	}
	
	public  void verifybookSearchByTitleCount() throws Exception
	{
		Thread.sleep(4000);
		Map<String, String> testData = readJsonElement("SearchData.json", "searchdetails");
	
		boolean result = false;
			
		String bookTitleCount1=testData.get("Book_TitleCount");
			
		Locator element = page.locator(TitleCount);
		if(element.textContent().equalsIgnoreCase(bookTitleCount1)) {
			result = true;
		}
		Assert.assertTrue(result);
	}
	
	public void verifyTitle() throws InterruptedException 
	{
		List<String> book_title = new ArrayList<>();
		book_title.add("Harry the Poisonous Centipede’s Big Adventure");
		book_title.add("Harry Hill's Whopping Great Joke Book");
		book_title.add("Harry Hill's Bumper Book of Bloopers");
		book_title.add("An A–Z of Harry Potter");
		book_title.add("See You at Harry's");
		book_title.add("Horrible Harry Bugs the Three Bears");
		book_title.add("Horrible Harry and the Dungeon");
		book_title.add("Horrible Harry Moves up to the Third Grade");
		book_title.add("Horrible Harry at Halloween");
		book_title.add("Horrible Harry on the Ropes");
		
		//boolean res=compareList(titleList,book_title);
		
		boolean res=compare(titleList,book_title);
		
		Assert.assertTrue(res);
	}
	
	public void clickClearButton() throws InterruptedException 
	{
		Thread.sleep(1000);
		clickElement(ClearButton);
	}
	
	public void verifyTitleCountAdvanceSearch() throws Exception 
	{
		Locator element1 = page.locator(TitleCount);
		String oldTitleCount=element1.textContent();
		
		Thread.sleep(1000);
		clickElement(AdvanceSearchButton);
		Thread.sleep(3000);
			
		Locator element2 = page.locator(TitleCount);
		String newTitleCount=element2.textContent();

		
		Assert.assertEquals(oldTitleCount,newTitleCount);
		
	}
	
	public void editorDropdown(String pageSizeOption) throws Exception 
	{		
		String Elementlist="//span[@class='ant-dropdown-menu-title-content']";
		
		selectDropdownByScrolling(EditorDropdown,pageSizeOption,Elementlist);	
	}
	
	public void selectAll() throws Exception 
	{
		clickElement(SelectAll);
	}
	
	
	//Add a book to cart
	public void addToCart() throws Exception
	{
		//Map<String, String> testData = readJsonElement("CartData.json", "cartdetails");
		String Elementlist="//li[@class='ant-dropdown-menu-item']";
		//String carttitleoption=testData.get("CartName");

		selectDropdownByScrolling(AddToCartDropdown,cartname,Elementlist);
		Thread.sleep(4000);
			
	}
		
	public boolean verifyAddToCartSuccessfully() throws Exception
	{
		Thread.sleep(2000);
		Map<String, String> testData = readJsonElement("SearchData.json", "searchdetails");
		String actualMessage=testData.get("CartAddtoMessage");

		Locator element1 = page.locator(cartAddedSuccessfully);
		String expectedMessage=element1.textContent();
			
		boolean result = false;
			
		if(expectedMessage.equalsIgnoreCase(actualMessage)) {
			result = true;
		}
		return result;	
		//Assert-playwright factory
	}
	
	public void clickSortDropdown() throws Exception
	{
		clickElement(SortDropdown);
		Thread.sleep(2000);
	}
	
	
	public void selectSortByOption(String titleoption) throws Exception
	{
		String Elementlist="//div[@class='ant-select-item-option-content']";
		
		selectDropdownByScrolling(SortDropdown,titleoption,Elementlist);
	}
	
	public void verifySort() throws Exception
	{
		Thread.sleep(2000);
		List<String> book_title = new ArrayList<>();
		book_title.add("An A–Z of Harry Potter");
		book_title.add("Harry Hill's Bumper Book of Bloopers");
		book_title.add("Harry Hill's Whopping Great Joke Book");
		book_title.add("Harry the Poisonous Centipede’s Big Adventure");
		book_title.add("Horrible Harry and the Dungeon");
		book_title.add("Horrible Harry at Halloween");
		book_title.add("Horrible Harry Bugs the Three Bears");
		book_title.add("Horrible Harry Moves up to the Third Grade");
		book_title.add("Horrible Harry on the Ropes");
		book_title.add("See You at Harry's");
				
		boolean res=compareList(titleList,book_title);
		
		Assert.assertTrue(res);
	}
	
	public void clickOnIsbnTab() throws Exception 
	{
		waitForVisibilityOf(IsbnTab);
		clickElement(IsbnTab);
	}
	
	public void enterIsbn(String Book_Isbn) throws Exception 
	{
		Thread.sleep(1000);
		Map<String, String> testData = readJsonElement("SearchData.json", "searchdetails");
		fillText(IsbnList,testData.get("Book_Isbn"));	
	}
	
	public void clickOnIsbnSearchButton() throws Exception 
	{
		clickElement(IsbnSearchButton);
	}
	
	public void verifyTitleCount_Isbn() throws Exception
	{
		Thread.sleep(3000);
		Map<String, String> testData = readJsonElement("SearchData.json", "searchdetails");
	
		boolean result = false;
			
		String bookTitleCount1=testData.get("Book_TitleCount_Isbn");
			
		Locator element = page.locator(TitleCount);
		if(element.textContent().equalsIgnoreCase(bookTitleCount1)) {
			result = true;
		}
		Assert.assertTrue(result);
	
	}
	
	public void clickOnBackButton() throws Exception 
	{
		clickElement(Back);
		Thread.sleep(3000);
	}
	
	
	
	public void uploadIsbnFile() throws Exception 
	{	
		Thread.sleep(2000);
		page.setInputFiles("input#react-csv-reader-input",Paths.get("C:\\Users\\tejashree.k\\eclipse-workspace\\CloudLibrary_Playwright\\Isbn.csv"));
		Thread.sleep(5000);
	}
	
	public void verifyNotMatchedIsbnCount() throws Exception 
	{
		Map<String, String> testData = readJsonElement("SearchData.json", "searchdetails");			
		String count=testData.get("Book_NotMatched");
			
		boolean result = false;

		Locator element = page.locator(TotalNotMatched);
		if(element.textContent().equalsIgnoreCase(count)) 
		{
			result = true;
		}
		
		Assert.assertTrue(result);
	}
	
	public void verifyMatchedIsbnCount() throws Exception
	{
		Thread.sleep(3000);
		Map<String, String> testData = readJsonElement("SearchData.json", "searchdetails");
	
		boolean result = false;
			
		String bookTitleCount=testData.get("Book_Matched_Isbn");
			
		Locator element = page.locator(TitleCount);
		if(element.textContent().equalsIgnoreCase(bookTitleCount)) {
			result = true;
		}
		Assert.assertTrue(result);
	
	}
	
	public void clickOnSaveSearch()
	{
		page.locator(SaveSearch).first().click();
	}
	

	
	public void searchName(String Book_SearchName) throws Exception 
	{
		fillText(SearchName,Book_SearchName);
	}
	
	public void searchDesciption(String Book_SearchDesc) throws Exception 
	{
		fillText(SearchDesc,Book_SearchDesc);
	}
	
	public void clickSaveButton() throws Exception 
	{
		clickElement(SaveButton);
	}

	
	public void saveTab() throws Exception 
	{
		clickElement(SavedTab);
	}
	
	public void verifysearchSavedSuccessfully() throws Exception
	{
		Map<String, String> testData = readJsonElement("SearchData.json", "searchdetails");
		String actualMessage=testData.get("Book_SavedSearchMessage");
		
		Locator element1 = page.locator(searchSavedSuccessfully);
		String expectedMessage=element1.textContent();
		
		boolean val=verifyAssertMessage(expectedMessage,actualMessage);
		
		Assert.assertTrue(val);
	}
}
