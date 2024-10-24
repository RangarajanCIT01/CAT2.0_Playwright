package com.pages;


import java.nio.file.Paths;
import java.util.Map;
import org.testng.Assert;
import com.Factory.PlaywrightFactory;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

public class MyCollectionPage extends PlaywrightFactory{

		private Page page;
	
		private String MyCollection="//span[contains(text(),'My Collection')]";
		private String cart = "//span[contains(text(),'Carts')]";
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

		public MyCollectionPage(Page page)
		{
			this.page=page;
		}
		
		public void clickOnMyCollection() throws Exception 
		{
			clickElement(MyCollection);
		}
		
		public void navigateToCartAndCollectionPage() throws InterruptedException {
			waitForVisibilityOf(cart);
			clickElement(cart);

			waitForVisibilityOf(MyCollection);
			clickElement(MyCollection);
		}
		
		public void enterBookKeyword() throws Exception 
		{
			Map<String, String> testData = readJsonElement("CollectionData.json", "collectiondetails");
			fillText(Keyword,testData.get("Book_Keyword"));	
		}
		
		// Enter Book Title 
		public void enterBookTitle(String data) throws Exception 
		{	
			waitForElement(2);
			fillText(Title,data);
		}
		
		public void enterBookAuthor(String data) throws Exception 
		{
			fillText(Author,data);
		}
		
		public void enterBookNarrator(String data) throws Exception 
		{
			fillText(Narrator,data);
		}
		
		public void enterBookSeries(String data) throws Exception 
		{
			fillText(Series,data);
		}
		
		public void enterBookHoldRatio(String data) throws Exception
		{
			fillText(HoldRatio,data);
		}
		
		public void catergoryAndSubject(String data) throws Exception 
		{
			String categoryOption=data;
			     
			clickElement(Category);
			fillText(Category,categoryOption);
			page.keyboard().down("ArrowDown");
			page.keyboard().press("Enter");

			page.getByText("Category and Subject").click();
		} 
		
		public void enterPrice(String min, String max) throws Exception 
		{	
			fillText(PricingMaxAmount,min);
			fillText(PricingMaxAmount,max);
		
		}
		
		public void publishedWithin() throws InterruptedException
		{
			selectDropdown(PublishedWithin,2);
		}
		
		public void dateAddedToCloudLibrary() throws InterruptedException
		{
			selectDropdown(DateAdded,3);
		}
		
		public void audience(String data) throws Exception
		{   
		    clickElement(Audience);
			fillText(Audience,data);
			page.keyboard().down("ArrowDown");
			page.keyboard().press("Enter");   
		}
		
		public void languages() throws Exception
		{
			Map<String, String> testData = readJsonElement("CollectionData.json","collectiondetails");
			String languageOption=testData.get("Book_Language");
			     
			clickElement(Languages);
			fillText(Languages,languageOption);
			page.keyboard().down("ArrowDown");
			page.keyboard().press("Enter");
		}
		
		public void publisher(String data) throws Exception
		{
			clickElement(Publishers);
			fillText(Publishers,data);
			waitForElement(2);
			page.keyboard().down("ArrowDown");
			page.keyboard().press("Enter"); 	
		}
		
		public void contentProviders(String data) throws Exception
		{
			clickElement(ContentProviders);
			fillText(ContentProviders,data);
			page.keyboard().down("ArrowDown");
			page.keyboard().press("Enter");
		}
		
		public void bookFormats() throws Exception
		{
			page.locator(FormatText).scrollIntoViewIfNeeded();
			
			Map<String, String> testData = readJsonElement("CollectionData.json", "collectiondetails");
			String formatOption=testData.get("Book_Format");
			SelectCheckbox(FormatsList,formatOption);
		}
		
		public void clickSearchButton() throws InterruptedException 
		{
			clickElement(SearchButton);
		}
		
		public void verifybookSearchByTitleCount() throws Exception
		{
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
		
		public void enterIsbn(String data) throws Exception 
		{
			waitForElement(3);
			fillText(IsbnList,data);	
		}
		
		public void clickOnIsbnSearchButton() throws Exception 
		{
			Thread.sleep(1000);
			clickElement(IsbnSearchButton);
		}
		
		public void verifyTitleCount_Isbn() throws Exception
		{
	
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
		}
		
		public void uploadIsbnFile() throws Exception 
		{	
			waitForElement(6);
			page.waitForSelector("input[type='file']", new Page.WaitForSelectorOptions().setState(WaitForSelectorState.VISIBLE));
			page.locator("#react-csv-reader-input").setInputFiles(Paths.get("./src/test/resource/TestData/Isbn.csv"));
			//page.setInputFiles("//input[@id='react-csv-reader-input']", Paths.get("Isbn.csv"));
			waitForElement(6);
			//page.setInputFiles("input#react-csv-reader-input",Paths.get("./src/test/resource/TestData/Isbn.csv"));
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
			Map<String, String> testData = readJsonElement("CollectionData.json", "collectiondetails");
		
			boolean result = false;
				
			String bookTitleCount=testData.get("Book_Matched_Isbn");
				
			Locator element = page.locator(TitleCount);
			if(element.textContent().equalsIgnoreCase(bookTitleCount)) {
				result = true;
			}
			Assert.assertTrue(result);
		
		}
		
		public void selectAllBooks() throws InterruptedException
		{
			clickElement(SelectAll);
		}
		
		public void addToShelf() throws Exception
		{
			Map<String, String> testData = readJsonElement("ShelfData.json", "shelfdetails");
			String Elementlist="//span[@class='ant-dropdown-menu-title-content']";
			String shelftitleoption=testData.get("ShelfName");
			selectDropdownByScrolling(AddToShelfDropdown,shelftitleoption,Elementlist);
		}
		
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
