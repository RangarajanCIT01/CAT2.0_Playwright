package com.pages;



import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.Factory.PlaywrightFactory;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.FileChooser;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SearchPage extends PlaywrightFactory{
	
	// References
	public Page page;
	
	// String Locators -Object Repository -OR
	public String Search="//span[contains(text(),'Search')]";
	private String cart="//span[contains(text(),'Carts')]";
	public String Keyword="//*[@name='keyword']";
	public String Title="//*[@name='title']";
	public String keywordTitle = "//input[@placeholder='Title']";
	public String Author="//input[@name='AuthorSearch']";
	public String Narrator="//input[@name='Narrator']";
	public String Series="//input[@name='series']";
	public String PresalesTitles="//div[@class='ant-select-selector']//span[contains(@class,'ant-select-selection-item')]";
	public String HoldRatio="//input[@name='HoldRatio']";
	public String Category="//span[text()='Category and Subjects']/..//input";
	public String Audience="//span[text()='All Audiences']/..//input";
	public String PricingMinAmount="//*[@name='MinimumPriceAmount']";
	public String PricingMaxAmount="//*[@name='MaximumPriceAmount']";
	public String Publishers="//span[text()='Publishers']/..//input";
	public String ContentProviders="//span[text()='Content Providers']/..//input";
	public String PublishedWithin="//div[@class='searchbyDateSelect'][1]//div[@class='ant-select-selector']";
	public String DateAdded="//div[@class='searchbyDateSelect'][2]//div[@class='ant-select-selector']";
	public String Languages="//span[text()='Language(s)']/..//input";
	public String FormatsList="//span[@class='ant-checkbox ant-checkbox-checked']//input[@name='3']";
	public String FormatsList2="//span[@class='ant-checkbox ant-checkbox-checked']//input[@name='2']";
	public String FilterSelfPublished="//span[@class='ant-checkbox']//input[@name='ExcludeSelfPublished']";
	public String FormatText="//div[@class='ant-row']//div[@class='ant-col ant-col-24']//div[@class='ant-card-body']//p[@class='card-title' and contains(text(),'Formats')]";
	public String SearchButton="//div[@class='ant-row ant-row-end search-top']//button[@class='primary']";
	public String SearchButtonLftPnl = "//button[text()='SEARCH']";
	public String titleList="//span[@class='book-title']";
	public String TitleCount="//span[@class='title-count']";
	public String SpecificISBN="//p[text()='9780739330029']";
	public String SearchISBN ="//p[text()='9781478956655']";
	public String quickSearchISBN ="//span[text()='Harry']";
	public String resetButton = "//button[@class='resetBtn']";
	public String leftPnlClse = "//span[text()='x']";	
	public String quickSearch = "//input[@placeholder='Quick Search by Title, Author or ISBN']";
	public String ClearButton="//*[@id='scrollableDiv']/div[2]/div/main/div/div[2]/div[1]/div[3]/div/div[1]/input";
	public String ClearButtonLftPnl = "//div[@class='ant-col ant-col-10 clear-button']";
	public String AdvanceSearchButton="//button[@id='advanced-search-btn' and contains(text(),'SEARCH')]";
	public String EditorDropdown="//img[@src='/static/media/downIcon.b7f4ea24.svg' and @class='down-icon']";
	public String SelectAll="//button[@class='secondary']";
	public String AddToCartDropdown="//button[@class='cart-tomain-dropdown ']";
	public String cartAddedSuccessfully="//span[contains(text(),'Added successfully.')]";
	public String SortDropdown="//span[@class='ant-select-selection-item'  and @title='Default']";
	public String IsbnTab="//div[@role='tab' and contains(text(),'ISBN')]";
	public String IsbnList="//textarea[@name='isbn-list']";
	public String IsbnSearchButton="//button[@id='isbn-search-btn']";
	public String Back="//button[@class='back-button']"; 
	public String TotalNotMatched="//span[@class='total_not_matched']";
	public String SaveSearch="//input[@class='Search_Save_btn' and @type='button']";
	public String savedSearch = "//span[text()='Saved Search']";
	public String savedDropdown = "//div[@class='rc-virtual-list-holder']";
	public String SearchName="//input[@name='SearchSaveName']";
	public String SearchDesc="//input[@name='SearchSaveDescription']";
	public String SaveButton="//button[@class='primary searchSave']";
	public String SavedTab="//div[@role='tab' and contains(text(),'Saved')]";
	public String ManagePopup = "//div[@style='display: flex; flex-direction: column; justify-content: center;']";
	//public String ManageEditIcon = "//p[text()='376257 TEST']/following::img[1]";
	//public String ManageEditIcon = "//p[text()='Search details for book named Harry']/following::img[1]";
	public String ManageEditIcon ="//p[text()='FirstSave']/following::img[1]";
	public String editSavedSearch = "//span[text()='FirstSave']";
	public String deleteSavedSeach = "//p[text()='FirstSave']/following::img[2]";
	public String btnsaveSearch = "//button[text()='Save Search']";
	public String lnkdeleteSavedSearch = "//span[text()='Delete Saved Search']";
	public String btnDone = "//button[text()='Done']";	
	public String SavedSearchDropdwn = "//span[text()='Saved Search']";
	public String SavedSearchList ="//div[@role='listbox']//ancestor::div[@class='ant-select-dropdown dropdown ant-select-dropdown-placement-bottomLeft  ant-select-dropdown-hidden']";
	public String searchSavedSuccessfully="//span[contains(text(),'Search Saved Successfully')]";
	public String TitleAdvSearch="//input[@placeholder='Title']";
	public String lnkManage = "//button[text()='Manage']";
	public String SearchAdvance="//button[@id='advanced-search-btn' and contains(text(),'SEARCH')]";
	//button[@id='advanced-search-btn' and contains(text(),'SEARCH')]
	//input[@class='ant-input card-input' and @id='Title']
	String Elementlist="//span[@class='ant-dropdown-menu-title-content']";
		
	// Page Constructor
	public SearchPage(Page page)
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
	public void enterBookKeyword(String data) throws Exception 
	{
		Thread.sleep(2000);
		
		fillText(Keyword,data);	
	}
	
		
	public void enterBookTitle(String data) throws Exception 
	{	
		Thread.sleep(1000);
		//Map<String, String> testData = readJsonElement("SearchData.json", "searchdetails");
		fillText(TitleAdvSearch,data);
		Thread.sleep(1000);
	}
	
	// Enter Book Author 
	public void enterBookAuthor(String data) throws Exception 
	{
		Thread.sleep(1000);
		//Map<String, String> testData = readJsonElement("SearchData.json", "searchdetails");
		fillText(Author,data);
	}
	
	// Enter Book Narrator 
	public void enterBookNarrator(String data) throws Exception 
	{
		Thread.sleep(1000);
		//Map<String, String> testData = readJsonElement("SearchData.json", "searchdetails");
		fillText(Narrator,data);
	}
	
	// Enter Book Series 
	public void enterBookSeries(String data) throws Exception 
	{
		Thread.sleep(1000);
		//Map<String, String> testData = readJsonElement("SearchData.json", "searchdetails");
		fillText(Series,data);
	}
	
	// Enter Book preSaleTitles 
	public void preSaleTitles() throws Exception 
	{
		Thread.sleep(2000);
		//Map<String, String> testData = readJsonElement("SearchData.json", "searchdetails");
		
		String Elementlist="//div[@class='rc-virtual-list']//div[@class='ant-select-item-option-content']";
		//String presalesOption=testData.get("Book_Presales");
		
		//selectDropdownByScrolling(PresalesTitles,presalesOption,Elementlist);
	}
	
	// Enter HoldRatio
	public void enterBookHoldRatio(String data) throws Exception
	{
		Thread.sleep(1000);
		//Map<String, String> testData = readJsonElement("SearchData.json", "searchdetails");
		fillText(HoldRatio,data);
	}
	
	public void catergoryAndSubject(String data) throws Exception 
	{
		Thread.sleep(1000);
		//Map<String, String> testData = readJsonElement("SearchData.json","searchdetails");
		String categoryOption=data;
		     
		clickElement(Category);
		fillText(Category,categoryOption);
		page.keyboard().down("ArrowDown");
		page.keyboard().press("Enter");
		
	
		page.getByText("Category and Subject").click();
	}   //thread remove
	
	public void keyboardEnter() {
		
		page.keyboard().press("Enter");
		
	}
	
	public void keyboardBackspace() {
		page.keyboard().press("Backspace");
	}
	
	public void keyboardDelete() {
		page.keyboard().press("Delete");
	}
	
	public void keyboardSelectAll() {
		page.keyboard().press("Control+A");
	}	
	
	public void audience(String data) throws Exception
	{    
		Thread.sleep(1000);
		//Map<String, String> testData = readJsonElement("SearchData.json","searchdetails");
		String audience=data; 
		
	    clickElement(Audience);
		fillText(Audience,audience);
		page.keyboard().down("ArrowDown");
		page.keyboard().press("Enter");   
	}
	
	public void enterPrice(String data1, String data2) throws Exception 
	{	
		Thread.sleep(1000);
		//Map<String, String> testData = readJsonElement("SearchData.json","searchdetails");
		//String min=testData.get("Book_MinAmount");
		//String max=testData.get("Book_MaxAmount");
		String min=data1;
		String max=data2;
		
		fillText(PricingMinAmount,min);
		fillText(PricingMaxAmount,max);
		Thread.sleep(1000);
	}
	
	public void publishedWithin() throws InterruptedException
	{
		Thread.sleep(1000);
		selectDropdown(PublishedWithin,2);
		
	}
	
	public void dateAddedToCloudLibrary() throws InterruptedException
	{
		Thread.sleep(1000);
		selectDropdown(DateAdded,3);
	}
	
	public void languages(String data) throws Exception
	{
		Thread.sleep(1000);
		//Map<String, String> testData = readJsonElement("SearchData.json","searchdetails");
		String language =data;    
		
		clickElement(Languages);
		fillText(Languages,language);
		page.keyboard().down("ArrowDown");
		page.keyboard().press("Enter");
	}
	
	
	public void publisher(String data) throws Exception
	{
		Thread.sleep(2000);
		//Map<String, String> testData = readJsonElement("SearchData.json","searchdetails");
		String publisherOption=data;
		
		clickElement(Publishers);
		fillText(Publishers,publisherOption);
		page.keyboard().down("ArrowDown");
		page.keyboard().press("Enter");
		
		//selectDropdownByScrolling(Publishers,publisherOption,publisherElementList); 	
	}
	
	public void contentProviders(String data) throws Exception
	{
		Thread.sleep(1000);
		//Map<String, String> testData = readJsonElement("SearchData.json", "searchdetails");
		String providerOption=data;
		
		clickElement(ContentProviders);
		fillText(ContentProviders,providerOption);
		page.keyboard().down("ArrowDown");
		Thread.sleep(1000);
		page.keyboard().press("Enter");
		
		//selectDropdownByScrolling(ContentProviders,providerOption,publisherElementList);
	}
	
	public void bookFormats(String data) throws Exception
	{
		Thread.sleep(1000);
		page.locator(FormatText).scrollIntoViewIfNeeded();
		
		//Map<String, String> testData = readJsonElement("SearchData.json", "searchdetails");
		String format=data;
		
		SelectCheckbox(FormatsList,format);
		//SelectCheckbox(FormatsList2,formatOption);
	}
	
	public void navigateToCartAndSearchPage() throws InterruptedException
	{
		waitForVisibilityOf(cart);
		clickElement(cart);

		waitForVisibilityOf(Search);
		clickElement(Search);
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
		Thread.sleep(8000);
	}
	
	public void SearchButtonLftPnl() throws InterruptedException 
	{
		Thread.sleep(1000);
		clickElement(SearchButtonLftPnl);
		Thread.sleep(8000);
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
	
	public void verifyTitle2() throws InterruptedException 
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
	
	public void verifyTitle() throws InterruptedException 
	{
		List<String> book_title = new ArrayList<>();
		book_title.add("Horrible Harry and the Christmas Surprise");
		book_title.add("Horrible Harry and the Dead Letters");
		book_title.add("Horrible Harry and the Dragon War");
		book_title.add("Horrible Harry and the Goog");
		book_title.add("Horrible Harry and the Holidaze");
		book_title.add("Horrible Harry and the June Box");
		book_title.add("Horrible Harry and the Locked Closet");
		book_title.add("Horrible Harry and the Missing Diamond");
		book_title.add("Horrible Harry and the Scarlet Scissors");
		book_title.add("Horrible Harry and the Stolen Cookie");
		book_title.add("Horrible Harry and the Triple Revenge");
		book_title.add("Horrible Harry Bugs the Three Bears");
		book_title.add("Horrible Harry Goes Cuckoo");
		
		book_title.add("Horrible Harry Takes the Cake");
		book_title.add("Horrible Harry on the Ropes");
		//boolean res=compareList(titleList,book_title);
		
		boolean res=compare(titleList,book_title);
		
		Assert.assertTrue(res);
	}
	
	public void clickClearButton() throws InterruptedException 
	{
		Thread.sleep(3000);
		clickElement(ClearButton);
	}
	
	public void ClearButtonLftPnl() throws InterruptedException 
	{
		Thread.sleep(3000);
		clickElement(ClearButtonLftPnl);
	}
	
	public void verifyTitleCountAdvanceSearch() throws Exception 
	{
		Locator element1 = page.locator(TitleCount);
		String oldTitleCount=element1.textContent();
		
		Thread.sleep(3000);
		clickElement(AdvanceSearchButton);
		Thread.sleep(3000);
			
		Locator element2 = page.locator(TitleCount);
		String newTitleCount=element2.textContent();

		Assert.assertEquals(oldTitleCount,newTitleCount);
		
	}
	
	public void verifyDisabled(String data)
	{
	assertThat(page.locator(data)).isDisabled();
	}
	
	public void verifyVisibility(String data)
	{
			
	assertThat(page.locator(data)).isVisible();
	//assertThat(page.locator(data)).not().isVisible();
	
	}
	
	public boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
	
	public void editorDropdown(String pageSizeOption) throws Exception 
	{				
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
	
	
	public void selectSortByOption(String data) throws Exception
	{
		
		//Map<String, String> testData = readJsonElement("SearchData.json", "searchdetails");
		String titleOption =data;
		//testData.get("Book_TitleOption")
		
		String Elementlist="//div[@class='ant-select-item-option-content']";
		
		selectDropdownByScrolling(SortDropdown,titleOption,Elementlist);
	}
	
	public void verifySort() throws Exception
	{
		Thread.sleep(10000);
		List<String> book_title = new ArrayList<>();
		book_title.add("Horrible Harry Takes the Cake");
		book_title.add("Horrible Harry on the Ropes");
		book_title.add("Horrible Harry Goes Cuckoo");
		book_title.add("Horrible Harry Bugs the Three Bears");
		book_title.add("Horrible Harry and the Triple Revenge");
		book_title.add("Horrible Harry and the Stolen Cookie");
		book_title.add("Horrible Harry and the Scarlet Scissors");
		book_title.add("Horrible Harry and the Missing Diamond");
		book_title.add("Horrible Harry and the Locked Closet");
		book_title.add("Horrible Harry and the June Box");
		book_title.add("Horrible Harry and the Holidaze");
		book_title.add("Horrible Harry and the Goog");
		book_title.add("Horrible Harry and the Dragon War");
		book_title.add("Horrible Harry and the Dead Letters");
		book_title.add("Horrible Harry and the Christmas Surprise");
				
		boolean res=compareList(titleList,book_title);
		
		Assert.assertTrue(res);
	}
	
	public void clickOnIsbnTab() throws Exception 
	{
		waitForVisibilityOf(IsbnTab);
		clickElement(IsbnTab);
	}
	
	
	public String getSuccessMessage() {
		
		String msg = page.locator(searchSavedSuccessfully).textContent();
		
		
		return msg;
	}
	
	public void enterIsbn() throws Exception 
	{
		Thread.sleep(1000);
		Map<String, String> testData = readJsonElement("SearchData.json", "searchByIsbn");
		fillText(IsbnList,testData.get("Book_Isbn"));	
	}
	
	public void quickSearchByISBN() throws Exception 
	{
		Thread.sleep(1000);
		Map<String, String> testData = readJsonElement("SearchData.json", "quickSearchByISBN");
		fillText(quickSearch,testData.get("Book_SearchISBN"));	
	}
	
	public void quickSearchByAuthor() throws Exception 
	{
		Thread.sleep(1000);
		Map<String, String> testData = readJsonElement("SearchData.json", "quickSearchByAuthor");
		fillText(quickSearch,testData.get("Book_AuthorName"));	
	}
	
	public void quickSearchByTitle() throws Exception 
	{
		Thread.sleep(1000);
		Map<String, String> testData = readJsonElement("SearchData.json", "quickSearchByTitle");
		fillText(quickSearch,testData.get("Book_TitleName"));	
	}
		
	
	public void clickOnIsbnSearchButton() throws Exception 
	{
		clickElement(IsbnSearchButton);
	}
	
	public void verifyTitleCount_Isbn() throws Exception
	{
		Thread.sleep(5000);
		Map<String, String> testData = readJsonElement("SearchData.json", "searchByIsbn");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		actualData.add(page.locator(TitleCount).textContent());
		expectedData.add(testData.get("Book_TitleCount_Isbn"));	
		Assert.assertEquals(expectedData, actualData);
	
	}
	
	public void verifyTitleCount_QuickSearchIsbn() throws Exception
	{
		Thread.sleep(5000);
		Map<String, String> testData = readJsonElement("SearchData.json", "quickSearchByISBN");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		actualData.add(page.locator(TitleCount).textContent());
		expectedData.add(testData.get("Book_TitleCount_Isbn"));	
		Assert.assertEquals(expectedData, actualData);
		
		Thread.sleep(3000);
	
	}
	
	public void clickOnBackButton() throws Exception 
	{
		Thread.sleep(3000);
		clickElement(Back);
		Thread.sleep(5000);
	}
	
	public void uploadIsbnFile() throws Exception 
	{	
		Thread.sleep(6000);
		//page.setInputFiles("input#react-csv-reader-input",Paths.get("C:\\Users\\tejashree.k\\eclipse-workspace\\CloudLibrary_Playwright\\Isbn.csv"));
		page.setInputFiles("input#react-csv-reader-input",Paths.get("D:\\CloudLibrary_CAT 2.0\\Isbn.csv"));
		//Scanner sc = new Scanner(new File("F:\\CSVDemo.csv"));  
		Thread.sleep(5000);
	}
	
	public void verifyNotMatchedIsbnCount() throws Exception 
	{
		Map<String, String> testData = readJsonElement("SearchData.json", "searchByIsbn");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		actualData.add(page.locator(TitleCount).textContent());
		expectedData.add(testData.get("Book_TitleCount_Isbn"));	
		Assert.assertEquals(expectedData, actualData);
		
		//Map<String, String> testData = readJsonElement("SearchData.json", "searchdetails");			
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
	

	
	public void searchName(String searchNameData) throws Exception 
	{
		fillText(SearchName,searchNameData);
	}
	
	public void searchDesciption(String searchDescription) throws Exception 
	{
		fillText(SearchDesc,searchDescription);

	}
	
	public void clickSaveButton() throws Exception 
	{
		clickElement(SaveButton);
	}

	
	public void savedTab() throws Exception 
	{
		clickElement(SavedTab);
	}
	
	public void manageLnk() throws Exception 
	{
		clickElement(lnkManage);
	}
	
	public void scroll(String value) throws Exception 
	{
		Locator ElementHandle = page.locator(value);
		
		ElementHandle.scrollIntoViewIfNeeded();
		
	}
	
	public void scrollAndClick(String value) throws Exception 
	{
		Locator ElementHandle = page.locator(value);
		
		ElementHandle.scrollIntoViewIfNeeded();
		Thread.sleep(3000);
		ElementHandle.click();
	}
	
	
	public void click(int n) throws Exception 
	{
		for (int i=0; i<=n; i++)
		{
			page.keyboard().press("Tab");
		}
		page.keyboard().press("ArrowDown");
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
