package TestPages;


import java.nio.file.Paths;
import java.util.Map;
import org.testng.Assert;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

import BaseClass.BaseTest;

public class MyCollectionPage extends BaseTest{

		public Page page;
	
		public String MyCollection="//span[contains(text(),'My Collection')]";
		public String cart = "//span[contains(text(),'Carts')]";
		public String Keyword="//*[@name='keyword']";
		public String Title="//input[@placeholder='Title']";
		public String Author="//input[@name='AuthorSearch']";
		public String Narrator="//*[@name='Narrator']";
		public String Series="//*[@name='series']";
		public String HoldRatio="//*[@id='HoldRatio']";
		public String Category="//span[text()='Category and Subjects']/..//input";
		public String Audience="//span[text()='All Audiences']/..//input";
		public String PricingMinAmount="//*[@name='MinimumPriceAmount']";
		public String PricingMaxAmount="//*[@name='MaximumPriceAmount']";
		public String Publishers="//span[text()='Publishers']/..//input";
		public String ContentProviders="//span[text()='Content Providers']/..//input";
		public String DatePurchased="//div[@class='searchByDatePurchase'][1]//div[@class='ant-select-selector']";
		public String PublishedWithin="//div[@class='searchbyDateSelect'][1]//div[@class='ant-select-selector']";
		public String DateAdded="//div[@class='searchbyDateSelect'][2]//div[@class='ant-select-selector']";
		public String Languages="//span[text()='Language(s)']/..//input";
		public String FormatsList="//span[@class='ant-checkbox ant-checkbox-checked']//input[@name='3']";
		//public String FormatsList2="//span[@class='ant-checkbox ant-checkbox-checked']//input[@name='2']";
		public String Filter="//span[@class='ant-select-selection-item']";
		public String ReferenceNumber="//*[@name='poReferenceNumber']";
		public String FormatText="//div[@class='ant-row']//div[@class='ant-col ant-col-24']//div[@class='ant-card-body']//p[@class='card-title' and contains(text(),'Formats')]";
		public String SearchButton="//div[@class='ant-row ant-row-end search-top']//button[@class='primary']";
		public String TitleCount="//span[@class='title-count']";
		public String IsbnTab="//div[@role='tab' and contains(text(),'ISBN')]";
		public String IsbnList="//textarea[@name='isbn-list']";
		public String IsbnSearchButton="//button[@id='isbn-search-btn']";
		public String Back="//button[@class='back-button']";
		public String TotalNotMatched="//span[@class='total_not_matched']";
		public String SelectAll="//button[@class='secondary']";
		public String AddToShelfDropdown="//button[@class='cart-tomain-dropdown ']//img[contains(@src,'/static/media/downIcon.b7f4ea24.svg')]";
		public String addToShelfSuccessfully="//span[contains(text(),'Added successfully.')]";

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
