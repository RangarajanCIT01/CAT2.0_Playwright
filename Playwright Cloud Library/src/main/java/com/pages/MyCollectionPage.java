package com.pages;


import java.nio.file.Paths;
import java.util.Map;
import org.testng.Assert;
import com.Factory.PlaywrightFactory;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class MyCollectionPage extends PlaywrightFactory{
	
	// References
		private Page page;
		
		// String Locators -Object Repository -OR
		private String MyCollection="//span[contains(text(),'My Collection')]";
		
		private String Keyword="//*[@name='keyword']";
		private String Title="//input[@placeholder='Title']";
		private String Author="//input[@name='AuthorSearch']";
		private String Narrator="//*[@name='Narrator']";
		private String Series="//*[@name='series']";
		private String HoldRatio="//*[@id='HoldRatio']";
		private String Category="//span[text()='Category and Subjects']/..//input";
		private String Audience="//span[text()='All Audiences']/..//input";
		private String PricingMinAmount="//*[@name='MinimumPriceAmount']";
		private String PricingMaxAmount="//*[@name='MaximumPriceAmount']";
		private String Publishers="//span[text()='Publishers']/..//input";
		private String ContentProviders="//span[text()='Content Providers']/..//input";
		private String DatePurchased="//div[@class='searchByDatePurchase'][1]//div[@class='ant-select-selector']";
		private String PublishedWithin="//div[@class='searchbyDateSelect'][1]//div[@class='ant-select-selector']";
		private String DateAdded="//div[@class='searchbyDateSelect'][2]//div[@class='ant-select-selector']";
		private String Languages="//span[text()='Language(s)']/..//input";
		private String FormatsList="//span[@class='ant-checkbox ant-checkbox-checked']//input[@name='3']";
		//private String FormatsList2="//span[@class='ant-checkbox ant-checkbox-checked']//input[@name='2']";
		private String Filter="//span[@class='ant-select-selection-item']";
		private String ReferenceNumber="//*[@name='poReferenceNumber']";
		private String FormatText="//div[@class='ant-row']//div[@class='ant-col ant-col-24']//div[@class='ant-card-body']//p[@class='card-title' and contains(text(),'Formats')]";
		private String SearchButton="//div[@class='ant-row ant-row-end search-top']//button[@class='primary']";
		private String TitleCount="//span[@class='title-count']";
		private String IsbnTab="//div[@role='tab' and contains(text(),'ISBN')]";
		private String IsbnList="//textarea[@name='isbn-list']";
		private String IsbnSearchButton="//button[@id='isbn-search-btn']";
		private String Back="//button[@class='back-button']";
		private String TotalNotMatched="//span[@class='total_not_matched']";
		
		private String SelectAll="//button[@class='secondary']";

		private String AddToShelfDropdown="//button[@class='cart-tomain-dropdown ']//img[contains(@src,'/static/media/downIcon.b7f4ea24.svg')]";

		private String addToShelfSuccessfully="//span[contains(text(),'Added successfully.')]";

		//private String TotalNotMatched="//span[@class='total_not_matched']";
	
		//Constructor
		public MyCollectionPage(Page page)
		{
			this.page=page;
		}
		
		// Page actions /methods
		public void clickOnMyCollection() throws Exception 
		{
			clickElement(MyCollection);
		}
		
		public void enterBookKeyword() throws Exception 
		{
			Thread.sleep(1000);
			Map<String, String> testData = readJsonElement("CollectionData.json", "collectiondetails");
			fillText(Keyword,testData.get("Book_Keyword"));	
		}
		
		// Enter Book Title 
		public void enterBookTitle() throws Exception 
		{	
			Thread.sleep(1000);
			Map<String, String> testData = readJsonElement("CollectionData.json", "collectiondetails");
			fillText(Title,testData.get("Book_Title"));
		}
		
		// Enter Book Author 
		public void enterBookAuthor() throws Exception 
		{
			Map<String, String> testData = readJsonElement("CollectionData.json", "collectiondetails");
			fillText(Author,testData.get("Book_Author"));
		}
		
		// Enter Book Narrator 
		public void enterBookNarrator() throws Exception 
		{
			Map<String, String> testData = readJsonElement("CollectionData.json", "collectiondetails");
			fillText(Narrator,testData.get("Book_Narrator"));
		}
		
		public void enterBookSeries() throws Exception 
		{
			Map<String, String> testData = readJsonElement("CollectionData.json", "collectiondetails");
			fillText(Series,testData.get("Book_Series"));
		}
		
		public void enterBookHoldRatio() throws Exception
		{
		
			Map<String, String> testData = readJsonElement("CollectionData.json", "collectiondetails");
			fillText(HoldRatio,testData.get("Book_Ratio"));
		}
		
		public void catergoryAndSubject(Page page) throws Exception 
		{
			Thread.sleep(1000);
			Map<String, String> testData = readJsonElement("CollectionData.json","collectiondetails");
			String categoryOption=testData.get("Book_Category");
			     
			clickElement(Category);
			fillText(Category,categoryOption);
			page.keyboard().down("ArrowDown");
			page.keyboard().press("Enter");
			
		
			page.getByText("Category and Subject").click();
		} 
		
		public void enterPrice(String min, String max) throws Exception 
		{	
			Thread.sleep(1000);
			Map<String, String> testData = readJsonElement("CollectionData.json", "collectiondetails");
			
			//fillText(PricingMinAmount,testData.get("Book_MinAmount"));
			//fillText(PricingMaxAmount,testData.get("Book_MaxAmount"));
			fillText(PricingMaxAmount,min);
			fillText(PricingMaxAmount,max);
		
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
		
		public void languages() throws Exception
		{
			Thread.sleep(1000);
			Map<String, String> testData = readJsonElement("CollectionData.json","collectiondetails");
			String languageOption=testData.get("Book_Language");
			     
			clickElement(Languages);
			fillText(Languages,languageOption);
			page.keyboard().down("ArrowDown");
			page.keyboard().press("Enter");
		}
		
		public void publisher() throws Exception
		{
			Thread.sleep(2000);
			Map<String, String> testData = readJsonElement("CollectionData.json","collectiondetails");
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
			Map<String, String> testData = readJsonElement("CollectionData.json", "collectiondetails");
			String providerOption=testData.get("Book_ContentProvider");
			
			clickElement(ContentProviders);
			fillText(ContentProviders,providerOption);
			page.keyboard().down("ArrowDown");
			Thread.sleep(1000);
			page.keyboard().press("Enter");
			
			//selectDropdownByScrolling(ContentProviders,providerOption,publisherElementList);
		}
		
		public void bookFormats() throws Exception
		{
			Thread.sleep(1000);
			page.locator(FormatText).scrollIntoViewIfNeeded();
			
			Map<String, String> testData = readJsonElement("CollectionData.json", "collectiondetails");
			String formatOption=testData.get("Book_Format");
			//String formatOption2=testData.get("Book_Format2");
			
			
			SelectCheckbox(FormatsList,formatOption);
		//	SelectCheckbox(FormatsList2,formatOption2);
		}
		
		public void clickSearchButton() throws InterruptedException 
		{
			Thread.sleep(1000);
			clickElement(SearchButton);
		}
		
		public void verifybookSearchByTitleCount() throws Exception
		{
			Thread.sleep(5000);
			Map<String, String> testData = readJsonElement("CollectionData.json", "collectiondetails");
		
			boolean result = false;
				
			String bookTitleCount1=testData.get("Book_TitleCount");
				
			Locator element = page.locator(TitleCount);
			if(element.textContent().equalsIgnoreCase(bookTitleCount1)) {
				result = true;
			}
			Assert.assertTrue(result);
		}
		
		public void clickOnIsbnTab() throws Exception 
		{
			waitForVisibilityOf(IsbnTab);
			clickElement(IsbnTab);
		}
		
		public void enterIsbn() throws Exception 
		{
			Thread.sleep(1000);
			Map<String, String> testData = readJsonElement("CollectionData.json", "collectiondetails");
			fillText(IsbnList,testData.get("Book_Isbn"));	
		}
		
		public void clickOnIsbnSearchButton() throws Exception 
		{
			clickElement(IsbnSearchButton);
		}
		
		public void verifyTitleCount_Isbn() throws Exception
		{
			Thread.sleep(3000);
			Map<String, String> testData = readJsonElement("CollectionData.json", "collectiondetails");
		
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
			page.setInputFiles("input#react-csv-reader-input",Paths.get("C:\\Users\\tejashree.k\\eclipse-workspace\\CloudLibrary_Playwright\\Isbn.csv"));
			Thread.sleep(5000);
		}
		
		public void verifyNotMatchedIsbnCount() throws Exception 
		{
			Map<String, String> testData = readJsonElement("CollectionData.json", "collectiondetails");			
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
			Map<String, String> testData = readJsonElement("CollectionData.json", "collectiondetails");
		
			boolean result = false;
				
			String bookTitleCount=testData.get("Book_Matched_Isbn");
				
			Locator element = page.locator(TitleCount);
			if(element.textContent().equalsIgnoreCase(bookTitleCount)) {
				result = true;
			}
			Assert.assertTrue(result);
		
		}
		
		
		///////
		
		public void selectAllBooks() throws InterruptedException
		{
			Thread.sleep(3000);
			clickElement(SelectAll);
			Thread.sleep(3000);
		}
		
		//Add a book to Shelf
		public void addToShelf() throws Exception
		{
			Map<String, String> testData = readJsonElement("ShelfData.json", "shelfdetails");
			String Elementlist="//span[@class='ant-dropdown-menu-title-content']";
			String shelftitleoption=testData.get("ShelfName");
			selectDropdownByScrolling(AddToShelfDropdown,shelftitleoption,Elementlist);
			Thread.sleep(4000);	
		}
		
		// Verify Shelf created successfully
		public void verifyShelfCreatedSuccessfully() throws Exception
		{
			Map<String, String> testData = readJsonElement("ShelfData.json", "shelfdetails");
			String actualMessage=testData.get("AddToShelf");
			
			Locator element1 = page.locator(addToShelfSuccessfully);
			String expectedMessage=element1.textContent();
						
			boolean val=verifyAssertMessage(expectedMessage,actualMessage);
			Assert.assertTrue(val);
		}
		
		

}
