package com.pages;

import java.io.File;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Map.Entry;

import org.testng.Assert;

import com.Factory.PlaywrightFactory;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.FileChooser;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Locator.ScrollIntoViewIfNeededOptions;
import com.microsoft.playwright.Page;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertTrue;

public class SearchPage extends PlaywrightFactory {

	public Page page;

	public String Search = "//span[contains(text(),'Search')]";
	private String cart = "//span[contains(text(),'Carts')]";
	public String Keyword = "//*[@name='keyword']";
	public String Title = "//*[@name='title']";
	public String keywordTitle = "//input[@placeholder='Title']";
	public String Author = "//input[@name='AuthorSearch']";
	public String Narrator = "//input[@name='Narrator']";
	public String Series = "//input[@name='series']";
	public String PresaleDropdown = "//input[@id='PresaleTitles']";
	public String drpdwnIncludeTitles = "//span[@title='Include Pre-Sale Titles']";
	public String drpdwnExcludeTitles = "//span[@title='Exclude Pre-Sale Titles']";
	public String drpdwnOnlyIncludeTitles = "//span[@title='Only Include Pre-Sale Titles']";
	public String HoldRatio = "//input[@name='HoldRatio']";
	public String Category = "//span[text()='Category and Subjects']/..//input";
	public String Audience = "//span[text()='All Audiences']/..//input";
	//public String Audience = "//span[text()='All Audiences']";
	//public String AudienceList = "//div[@class='rc-virtual-list-holder-inner']";
	public String AudienceList = "//div[@class='rc-virtual-list-holder']";
	//public String AllElements = "//div[@class='ant-row book-details-container ']//p";
	public String AllElements = "//div[@class='ant-row book-details-container ']";
	public String AllMultipleElements = "//div[@class='ReactVirtualized__Grid ReactVirtualized__List scrollStyle']";
	public String PricingMinAmount = "//*[@name='MinimumPriceAmount']";
	public String PricingMaxAmount = "//*[@name='MaximumPriceAmount']";
	public String Publishers = "//span[text()='Publishers']/..//input";
	public String lblContentProvider = "//span[text()='Content Providers']/parent::div";
	public String ContentProviders = "//span[text()='Content Providers']/..//input";
	public String PublishedWithin = "//div[@class='searchbyDateSelect'][1]//div[@class='ant-select-selector']";
	public String DateAdded = "//div[@class='searchbyDateSelect'][2]//div[@class='ant-select-selector']";
	public String Languages = "//span[text()='Language(s)']/..//input";
	public String FormatsList = "//span[@class='ant-checkbox ant-checkbox-checked']//input[@name='3']";
	public String FormatsList2 = "//span[@class='ant-checkbox ant-checkbox-checked']//input[@name='2']";
	public String FilterSelfPublished = "//span[@class='ant-checkbox']//input[@name='ExcludeSelfPublished']";
	public String FormatText = "//div[@class='ant-row']//div[@class='ant-col ant-col-24']//div[@class='ant-card-body']//p[@class='card-title' and contains(text(),'Formats')]";
	public String SearchButton = "//div[@class='ant-row ant-row-end search-top']//button[@class='primary']";
	public String DatePurchased = "//p[text()='Dates and Languages']/following::span[1]";
	public String DatePurchasedDateRange = "//span[text()='Custom Date Range']";
	public String DatePurchasedStartDate= "//span[text()='Custom Date Range']/following::input[1]";
	public String DatePurchasedEndDate = "//input[@placeholder='Custom Date Range']/following::input[1]";
	
	
	
	public String SearchButtonLftPnl = "//button[text()='SEARCH']";
	public String titleList = "//span[@class='book-title']";
	public String TitleCount = "//span[@class='title-count']";
	
	public String resetButton = "//button[@class='resetBtn']";
	public static String leftPnlClse = "//span[text()='x']";
	public String quickSearch = "//input[@placeholder='Quick Search by Title, Author or ISBN']";
	public String ClearButton = "//*[@id='scrollableDiv']/div[2]/div/main/div/div[2]/div[1]/div[3]/div/div[1]/input";
	public String ClearButtonLftPnl = "//div[@class='ant-col ant-col-10 clear-button']";
	public String AdvanceSearchButton = "//button[@id='advanced-search-btn' and contains(text(),'SEARCH')]";
	public String EditorDropdown = "//img[@src='/static/media/downIcon.b7f4ea24.svg' and @class='down-icon']";
	public String SelectAll = "//button[@class='secondary']";
	public String AddToCartDropdown = "//button[@class='cart-tomain-dropdown ']";
	public String cartAddedSuccessfully = "//span[contains(text(),'Added successfully.')]";
	public String SortDropdown = "//span[@class='ant-select-selection-item'  and @title='Default']";
	public String IsbnTab = "//div[@role='tab' and contains(text(),'ISBN')]";
	public String IsbnList = "//textarea[@name='isbn-list']";
	public String IsbnSearchButton = "//button[@id='isbn-search-btn']";
	public String Back = "//button[@class='back-button']";
	public String TotalNotMatched = "//span[@class='total_not_matched']";
	
	/*********** Saved Search *********/
	public String SaveSearch = "//input[@class='Search_Save_btn' and @type='button']";
	public String savedSearch = "//span[text()='Saved Search']";
	public String savedDropdown = "//div[@class='rc-virtual-list-holder']";
	public String SearchName = "//input[@name='SearchSaveName']";
	public String SearchDesc = "//input[@name='SearchSaveDescription']";
	public String SaveButton = "//button[@class='primary searchSave']";
	public String SavedTab = "//div[@role='tab' and contains(text(),'Saved')]";
	public String SavedList = "//div[@class='rc-virtual-list-holder-inner']/..//span";
	public String ManagePopup = "//div[@style='display: flex; flex-direction: column; justify-content: center;']";
	public String ManageEditIcon = "//p[text()='FirstSave']/following::img[1]";
	public String editSavedSearch = "//span[text()='FirstSave']";
	public String deleteSavedSeach = "//p[text()='FirstSave']/following::img[2]";
	public String btnsaveSearch = "//button[text()='Save Search']";
	public String lnkdeleteSavedSearch = "//span[text()='Delete Saved Search']";
	public String btnDone = "//button[text()='Done']";
	public String dltCnfrm = "//span[text()='Delete Saved Search']";
	public String SavedSearchDropdwn = "//span[text()='Saved Search']";
	public String SavedSearchList = "//div[@role='listbox']//ancestor::div[@class='ant-select-dropdown dropdown ant-select-dropdown-placement-bottomLeft  ant-select-dropdown-hidden']";
	public String searchSavedSuccessfully = "//span[contains(text(),'Search Saved Successfully')]";
	public String TitleAdvSearch = "//input[@placeholder='Title']";
	public String lnkManage = "//button[text()='Manage']";
	public String SearchAdvance = "//button[@id='advanced-search-btn' and contains(text(),'SEARCH')]";
	public String AdvSearchTab = "//div[text()='Advanced Search']";
	public String SavedFormat = "//div[@class='rc-virtual-list-holder-inner']//span[text()='Format']";
	public String SavedFormatAll = "//div[@class='rc-virtual-list-holder-inner']//span[text()='All']";
	public String SavedFormatEPUB = "//div[@class='rc-virtual-list-holder-inner']//span[text()='EPUB']";
	public String SavedFormatPDF = "//div[@class='rc-virtual-list-holder-inner']//span[text()='PDF']";
	public String SavedFormatMP3 = "//div[@class='rc-virtual-list-holder-inner']//span[text()='MP3']";
	
	
	/*********** Search page ***********/
	// button[@id='advanced-search-btn' and contains(text(),'SEARCH')]
	// input[@class='ant-input card-input' and @id='Title']
	public String Elementlist = "//span[@class='ant-dropdown-menu-title-content']";
	public String ElementList2 = "//div[@class='rc-virtual-list']";
	public String loadingSpinner = "//span[@aria-label='loading']";
	public String loadingSpinnerSaved = "//div[@class='spinner-container']";
	public String resultContainer = "//div[@class='ant-row book-details-container ']";
	public String PresaleList = "//div[@class='rc-virtual-list-holder-inner']/..//span";
	public String chkbxEPUB = "//input[@name='1']";
	public String chkbxPDF = "//input[@name='2']";
	public String chkbxMP3 = "//input[@name='3']";
	public String txtFormat = "//p[text()='Formats']";
	public String PPUFilterList = "//div[@class='rc-virtual-list-holder-inner']/..//span";
	public String ExcludePPUTitles = "//span[text()='Exclude PPU Titles']";
	public String IncludePPUTitles = "//span[text()='Include PPU Titles']";
	public String OnlyIncludePPUTitles = "//span[text()='Search Only PPU titles']";	
	public String CustomPubDateRange = "//span[text()='Custom published date range']";
	public String drpdwnpublishedWithin = "//p[text()='Dates and Languages']/following::span[1]";
	public String drpdwnColpublishedWithin = "//p[text()='Dates and Languages']/following::span[4]";
	public String drpdwnAddedToCAT = "//p[text()='Dates and Languages']/following::div[5]";
	public String drpdwnColAddedToCAT = "//p[text()='Dates and Languages']/following::div[7]";
	public String drpdwnDatePurchased = "//p[text()='Dates and Languages']/following::span[1]";
	public String publicationList = "//div[@class='rc-virtual-list-holder-inner']//span";
	public String CustomDateRangeEndDate = "//div[@class='ant-picker-input']";
	public String CustomDateRangeStartDate = "//input[@placeholder='Custom Date Range']";
	public String publishedDateList = "//span[text()='Published within']";
	public String lblFilters = "//p[text()='Filters']";
	public String pubList = "//p[text()='Dates and Languages']/..//div[@class='searchbyDateSelect']/..//span[text()='Published Within']";
	public String publisherdrpdwnList = "//div[@class='ant-select-tree-list']"; 
	public String lstContentProvider = "//div[@class='ant-select-dropdown ant-tree-select-dropdown ant-select-dropdown-placement-bottomLeft ']";
	public String lastContentProvider = "//span[text()='Young Test ']";
	
	public SearchPage(Page page) {
		this.page = page;
	}
	
	public Map<String, String> readJsonElement(String fileName, String elementName) throws Exception {
		String filePath = null;

		filePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator
				+ "resource" + File.separator + "TestData" + File.separator + fileName;

		JsonElement root = (new JsonParser()).parse(new FileReader(filePath));
		JsonObject jsonObject = root.getAsJsonObject();
		JsonElement some = jsonObject.get(elementName);
		JsonObject testData = some.getAsJsonObject();
		Map<String, String> testDataMap = new HashMap();
		Iterator var = testData.entrySet().iterator();

		while (var.hasNext()) {
			Entry<String, JsonElement> entry = (Entry) var.next();
			testDataMap.put(((String) entry.getKey()).toString(), ((JsonElement) entry.getValue()).getAsString());
		}

		return testDataMap;
	}

	public String titlenamelist() throws Exception {
		
		Map<String, String> testData = readJsonElement("SavedSearch.json", "VerifyCreateSavedSearchSingleTitle");
		String TitleName = testData.get("Book_SearchName");
		
		return TitleName;
	}
	
	public void editSavedSearch() throws Exception {
		Map<String, String> testData = readJsonElement("SavedSearch.json", "VerifyCreateSavedSearchSingleTitle");
		String TitleName = testData.get("Book_SearchName");
		String xp = "//p[text()='"+ TitleName +"']/parent::div/following-sibling::div[1]/img";
		clickElement(xp);
	}
	
	public void deleteSavedSearch() throws Exception {
		Map<String, String> testData = readJsonElement("SavedSearch.json", "VerifydeleteSavedSearch");
		String TitleName = testData.get("Book_DeleteSavedSearch");
		String xp = "//p[text()='"+ TitleName +"']/parent::div/following-sibling::div[2]/img";
		clickElement(xp);
	}
	
	public String titlenamelist1() throws Exception {
		
		Map<String, String> testData = readJsonElement("SavedSearch.json", "VerifyCreateSavedSearchSingleTitle");
		String TitleName = testData.get("Book_SearchName");
		
		return TitleName;
	}
	
	public void clickOnSearch() throws Exception {
		waitForVisibilityOf(Search);
		clickElement(Search);
	}

	public void enterBookKeyword(String data) throws Exception {
		fillText(Keyword, data);
	}

	public void enterBookTitle(String data) throws Exception {
		fillText(TitleAdvSearch, data);
	}

	public void enterBookAuthor(String data) throws Exception {
	
		fillText(Author, data);
	}

	public void enterBookNarrator(String data) throws Exception {
		fillText(Narrator, data);
	}

	public void enterBookSeries(String data) throws Exception {
		fillText(Series, data);
	}

	public void preSaleIncludeTitles(String data) throws Exception {

		selectDropdownByScrolling(drpdwnOnlyIncludeTitles,data,PresaleList);
	}
	
	public void preSaleExcludeTitles(String data) throws Exception {

		selectDropdownByScrolling(drpdwnIncludeTitles,data,PresaleList);
	}
	
	public void preSaleOnlyIncludeTitles(String data) throws Exception {

		selectDropdownByScrolling(drpdwnIncludeTitles,data,PresaleList);
	}

	public void ExcludePPUTitles(String data) throws Exception {

		selectDropdownByScrolling(IncludePPUTitles,data,PPUFilterList);
	}
	
	public void ExcludeColPPUTitles(String data) throws Exception {

		selectDropdownByScrolling(OnlyIncludePPUTitles,data,PPUFilterList);
	}
	
	public void IncludePPUTitles(String data) throws Exception {

		selectDropdownByScrolling(IncludePPUTitles,data,PPUFilterList);
	}
	
	public void OnlyIncludePPUTitles(String data) throws Exception {

		selectDropdownByScrolling(IncludePPUTitles,data,PPUFilterList);
	}
	
		
	public void enterBookHoldRatio(String data) throws Exception {
		fillText(HoldRatio, data);
	}

	public void catergoryAndSubject(String data) throws Exception {

		clickElement(Category);
		fillText(Category, data);
		page.keyboard().down("ArrowDown");
		page.keyboard().press("Enter");
		page.getByText("Category and Subject").click();
	}

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

	public void audience(String data) throws Exception {
	
		String audience = data;
		clickElement(Audience);
		fillText(Audience, audience);
		page.keyboard().down("ArrowDown");
		page.keyboard().press("Enter");
	}
	
	public void uncheckEPUBAndPDF(){
		waitForVisibilityOf(txtFormat);
		clickElement(chkbxEPUB);
		clickElement(chkbxPDF);
	}
	
	public void uncheckEPUBAndMP3(){
		waitForVisibilityOf(txtFormat);
		clickElement(chkbxMP3);
		clickElement(chkbxPDF);
	}
	
	public void uncheckPDFAndMP3(){
		waitForVisibilityOf(txtFormat);
		clickElement(chkbxPDF);
		clickElement(chkbxEPUB);	
	}
	
	public void SelectElement() throws Exception {
		
		page.keyboard().down("ArrowDown");
		page.keyboard().press("Enter");
	}

	public void enterPrice(String min, String max) throws Exception {
		fillText(PricingMinAmount, min);
		fillText(PricingMaxAmount, max);
	}

	public void publishedWithin() throws InterruptedException {
		selectDropdown(PublishedWithin, 2);
	}

	public void dateAddedToCloudLibrary() throws InterruptedException {
		selectDropdown(DateAdded, 3);
	}

	public void languages(String data) throws Exception {
		clickElement(Languages);
		fillText(Languages, data);
		page.keyboard().down("ArrowDown");
		page.keyboard().press("Enter");
	}

	public void publisher(String data) throws Exception {
		
		clickElement(Publishers);
		fillText(Publishers, data);
		page.keyboard().down("ArrowDown");
		page.keyboard().press("Enter");
	}

	public void contentProviders(String data) throws Exception {
		
		String providerOption = data;
		clickElement(ContentProviders);
		fillText(ContentProviders, providerOption);
		page.keyboard().down("ArrowDown");
		page.keyboard().press("Enter");
	}

	public void bookFormats(String data) throws Exception {
		page.locator(FormatText).scrollIntoViewIfNeeded();
		SelectCheckbox(FormatsList, data);
	}

	public void navigateToCartAndSearchPage() throws InterruptedException {
		waitForVisibilityOf(cart);
		clickElement(cart);
		waitForVisibilityOf(Search);
		clickElement(Search);
	}

	public void bookFilters() throws InterruptedException {
		clickElement(FilterSelfPublished);
	}

	public void clickSearchButton() throws InterruptedException {
		clickElement(SearchButton);
		waitForVisibilityOfHidden(loadingSpinner);
	}

	public void loadResult() {
		waitForVisibilityOfHidden(loadingSpinner);
		untilDomContentLoads();
		untilDefaultLoadStateCompletes();
	}
	
	public void verifyElementNotDisplayed() {
		boolean isElementVisible = page.isVisible("your-element-selector");
        if (!isElementVisible) {
            System.out.println("The element is not visible.");
        } else {
            System.out.println("The element is visible.");
        }
		
	}
	
	public void scrollToBottom(String data) {
	 Locator dropDown = page.locator(data);
     dropDown.scrollIntoViewIfNeeded();
	}
	
	public void loadResultSaved() {
		waitForVisibilityOfHidden(loadingSpinnerSaved);
		untilDomContentLoads();
		untilDefaultLoadStateCompletes();
	}
	
	public void VerifyScroll1(String data) {		
		page.locator(data).scrollIntoViewIfNeeded();
	}

	public String actualVerify(String loc) {
		String ret = page.locator(loc).textContent();
		return ret;
	}

	public void SearchButtonLftPnl() throws InterruptedException {
		clickElement(SearchButtonLftPnl);
	}

	public void advanceSearch() throws InterruptedException {
		clickElement(SearchAdvance);
	}

	public void verifybookSearchByTitleCount() throws Exception {
		Map<String, String> testData = readJsonElement("SearchData.json", "searchdetails");

		boolean result = false;

		String bookTitleCount1 = testData.get("Book_TitleCount");

		Locator element = page.locator(TitleCount);
		if (element.textContent().equalsIgnoreCase(bookTitleCount1)) {
			result = true;
		}
		Assert.assertTrue(result);
	}
	
	public void clickClearButton() throws InterruptedException {
		clickElement(ClearButton);
	}

	public void ClearButtonLftPnl() throws InterruptedException {
		clickElement(ClearButtonLftPnl);
	}

	public void verifyTitleCountAdvanceSearch() throws Exception {
		Locator element1 = page.locator(TitleCount);
		String oldTitleCount = element1.textContent();

		clickElement(AdvanceSearchButton);

		Locator element2 = page.locator(TitleCount);
		String newTitleCount = element2.textContent();

		Assert.assertEquals(oldTitleCount, newTitleCount);
	}

	public void verifyDisabled(String data) {
		assertThat(page.locator(data)).isDisabled();
	}
	
	public void verifyHidden(String data) {
		assertThat(page.locator(data)).isHidden();
	}
	
	public void verifyVisibility(String data) {

		assertThat(page.locator(data)).isVisible();
	}
	
	public void verifyIsChecked(String data) {

		assertThat(page.locator(data)).isChecked();
	}
	
	public void verifyNonVisibile(String data) {

		assertThat(page.locator(data)).isEmpty();
	}
	
	public void verifyTitleVisibility() throws Exception {
		Map<String, String> testData = readJsonElement("SavedSearch.json", "VerifyCreatedSavedSearch");
		String titleVisible = "//input[@value='"+testData.get("Book_Title")+"']";
		verifyVisibility(titleVisible);
	}
	
	public void verifyAuthorVisibility() throws Exception {
		Map<String, String> testData = readJsonElement("SavedSearch.json", "VerifyCreatedSavedSearch");
		String authorVisible = "//input[@value='"+testData.get("Book_Author")+"']";
		verifyVisibility(authorVisible);
	}
	
	public void verifyContentProviderVisibility() throws Exception {
		Map<String, String> testData = readJsonElement("SavedSearch.json", "VerifyCreatedSavedSearch");
		String cpVisible = "//span[text()='"+testData.get("Book_ContentProvider")+"']";
		verifyVisibility(cpVisible);
	}
	
	public void verifyPublisherVisibility() throws Exception {
		Map<String, String> testData = readJsonElement("SavedSearch.json", "VerifyCreatedSavedSearch");
		String pubVisible = "//span[text()='"+testData.get("Book_Publisher")+"']";
		verifyVisibility(pubVisible);
	}
	
	public void verifyFormatVisibility() throws Exception {
		Map<String, String> testData = readJsonElement("SavedSearch.json", "VerifyCreatedSavedSearch");
		String formatVisible = "//input[@name='"+testData.get("Book_Format")+"']";
		verifyIsChecked(formatVisible);
	}
	
	public void verifyAudienceVisibility() throws Exception {
		Map<String, String> testData = readJsonElement("SavedSearch.json", "VerifyCreatedSavedSearch");
		String audienceVisible = "//span[text()='"+testData.get("Book_Audience")+"']";
		verifyVisibility(audienceVisible);
	}
	
	public void verifyPricingVisibility() throws Exception {
		Map<String, String> testData = readJsonElement("SavedSearch.json", "VerifyCreatedSavedSearch");
		String minPriceVisible = "//input[@name='MinimumPriceAmount' and @value='"+testData.get("Book_MinPrice")+"']";
		String maxPriceVisible = "//input[@name='MaximumPriceAmount' and @value='"+testData.get("Book_MaxPrice")+"']";
		verifyVisibility(minPriceVisible);
		verifyVisibility(maxPriceVisible);
	}
	
	public void verifyLanguageVisibility() throws Exception {
		Map<String, String> testData = readJsonElement("SavedSearch.json", "VerifyCreatedSavedSearch");
		String LanguageVisible = "//span[text()='"+testData.get("Book_Language")+"']";
		verifyVisibility(LanguageVisible);
	}
	
	public void verifySearchNotVisibile() throws Exception {
		Map<String, String> testData = readJsonElement("SavedSearch.json", "VerifydeleteSavedSearch");
		String titleNotVisible = "//p[text()='"+testData.get("SearchNotVisible")+"']";
		verifyHidden(titleNotVisible);
	}
	
	public void editorDropdown(String pageSizeOption) throws Exception {
		selectDropdownByScrolling(EditorDropdown, pageSizeOption, Elementlist);
	}

	public void selectAll() throws Exception {
		clickElement(SelectAll);
	}

	
	public void addToCart() throws Exception {
		// Map<String, String> testData = readJsonElement("CartData.json",
		// "cartdetails");
		String Elementlist = "//li[@class='ant-dropdown-menu-item']";
		// String carttitleoption=testData.get("CartName");
		selectDropdownByScrolling(AddToCartDropdown, cartname, Elementlist);
	}

	public boolean verifyAddToCartSuccessfully() throws Exception {
		Map<String, String> testData = readJsonElement("SearchData.json", "searchdetails");
		String actualMessage = testData.get("CartAddtoMessage");

		Locator element1 = page.locator(cartAddedSuccessfully);
		String expectedMessage = element1.textContent();

		boolean result = false;

		if (expectedMessage.equalsIgnoreCase(actualMessage)) {
			result = true;
		}
		return result;
	}

	public void clickSortDropdown() throws Exception {
		clickElement(SortDropdown);
	}

	public void selectSortByOption(String data) throws Exception {
		String titleOption = data;
		String Elementlist = "//div[@class='ant-select-item-option-content']";
		selectDropdownByScrolling(SortDropdown, titleOption, Elementlist);
	}
	
	public void checkList() throws Exception {

		List<String> Elementlist1 = page.locator(publisherdrpdwnList).allInnerTexts();
		List<Locator> Elementlist2 = page.locator(publisherdrpdwnList).all();
		List<String> Elementlist3 = page.locator(publisherdrpdwnList).allTextContents();
		String Elementlist4 = page.locator(publisherdrpdwnList).innerText();
		String Elementlist5 = page.locator(publisherdrpdwnList).textContent();
		int Elementlist6 = page.locator(publisherdrpdwnList).count();
		System.out.println("Below are the details of " +Elementlist1 );
		System.out.println("Below are the details of " +  Elementlist2);
		System.out.println("Below are the details of " + Elementlist3);
		System.out.println("Below are the details of " + Elementlist4);
		System.out.println("Below are the details of " + Elementlist5);
		System.out.println("Below are the details of " + Elementlist6);		
	}
	
	public void verifySort() throws Exception {
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

		boolean res = compareList(titleList, book_title);

		Assert.assertTrue(res);
	}
	
	
	public void clseLftPnlIfExists() throws InterruptedException {
	
		Locator leftPnlCls = page.locator(SearchPage.leftPnlClse);
		if( leftPnlCls.isVisible()) {
		
			leftPnlCls.click();
		} else{
			System.out.println("");
		}
	}

	public void clickOnIsbnTab() throws Exception {
		waitForVisibilityOf(IsbnTab);
		clickElement(IsbnTab);
	}

	public String getSuccessMessage() {
		String msg = page.locator(searchSavedSuccessfully).textContent();
		return msg;
	}
	
	public String getAllElements() {
		String msg = page.locator(AllElements).textContent();
		System.out.println(msg);
		return msg;
	}

	public void enterIsbn(String loc) throws Exception {
		fillText(IsbnList, loc);
		keyboardEnter();
	}

	public void quickSearchByISBN() throws Exception {
		Map<String, String> testData = readJsonElement("SearchData.json", "quickSearchByISBN");
		fillText(quickSearch, testData.get("Book_SearchISBN"));
		keyboardEnter();
	}

	public void quickSearchByAuthor() throws Exception {
		Map<String, String> testData = readJsonElement("SearchData.json", "quickSearchByAuthor");
		fillText(quickSearch, testData.get("Book_AuthorName"));
		keyboardEnter();
	}

	public void quickSearchByTitle() throws Exception {
		Map<String, String> testData = readJsonElement("SearchData.json", "quickSearchByTitle");
		fillText(quickSearch, testData.get("Book_TitleName"));
		keyboardEnter();
	}

	public void clickOnIsbnSearchButton() throws Exception {
		clickElement(IsbnSearchButton);
	}

	public void verifyTitleCount_Isbn() throws Exception {
		Map<String, String> testData = readJsonElement("SearchData.json", "searchByIsbn");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();

		actualData.add(page.locator(TitleCount).textContent());
		expectedData.add(testData.get("Book_TitleCount_Isbn"));
		Assert.assertEquals(expectedData, actualData);
	}

	public void verifyTitleCount_QuickSearchIsbn() throws Exception {
		Map<String, String> testData = readJsonElement("SearchData.json", "quickSearchByISBN");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();

		actualData.add(page.locator(TitleCount).textContent());
		expectedData.add(testData.get("Book_TitleCount_Isbn"));
		Assert.assertEquals(expectedData, actualData);
	}

	public void clickOnBackButton() throws Exception {
		clickElement(Back);
	}

	public void uploadIsbnFile() throws Exception {
		// page.setInputFiles("input#react-csv-reader-input",Paths.get("C:\\Users\\tejashree.k\\eclipse-workspace\\CloudLibrary_Playwright\\Isbn.csv"));
		page.setInputFiles("input#react-csv-reader-input", Paths.get("D:\\CloudLibrary_CAT 2.0\\Isbn.csv"));
		// Scanner sc = new Scanner(new File("F:\\CSVDemo.csv"));
	}

	public void verifyNotMatchedIsbnCount() throws Exception {
		Map<String, String> testData = readJsonElement("SearchData.json", "searchByIsbn");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();

		actualData.add(page.locator(TitleCount).textContent());
		expectedData.add(testData.get("Book_TitleCount_Isbn"));
		Assert.assertEquals(expectedData, actualData);

		// Map<String, String> testData = readJsonElement("SearchData.json",
		// "searchdetails");
		String count = testData.get("Book_NotMatched");

		boolean result = false;

		Locator element = page.locator(TotalNotMatched);
		if (element.textContent().equalsIgnoreCase(count)) {
			result = true;
		}

		Assert.assertTrue(result);
	}

	public void verifyMatchedIsbnCount() throws Exception {
		Map<String, String> testData = readJsonElement("SearchData.json", "searchdetails");

		boolean result = false;

		String bookTitleCount = testData.get("Book_Matched_Isbn");

		Locator element = page.locator(TitleCount);
		if (element.textContent().equalsIgnoreCase(bookTitleCount)) {
			result = true;
		}
		Assert.assertTrue(result);

	}

	public void clickSaveSearchbtn() {
		page.locator(SaveSearch).first().click();
	}

	public void searchName(String searchNameData) throws Exception {
		fillText(SearchName, searchNameData);
	}

	public void searchDesciption(String searchDescription) throws Exception {
		fillText(SearchDesc, searchDescription);

	}

	public void clickSaveButton() throws Exception {
		clickElement(SaveButton);
	}

	public void savedTab() throws Exception {
		clickElement(SavedTab);
	}

	public void manageLnk() throws Exception {
		clickElement(lnkManage);
	}
	
	public void scroll(String value) throws Exception {
		Locator ElementHandle = page.locator(value);

		ElementHandle.scrollIntoViewIfNeeded();
	}
	
	public void scrollAndClick(String value) throws Exception {
		Locator ElementHandle = page.locator(value);

		ElementHandle.scrollIntoViewIfNeeded();
		ElementHandle.click();
	}

	public void drpdwnSavedSelect(int n) throws Exception {
		for (int i = 0; i <= n; i++) {
			page.keyboard().press("Tab");
		}
		page.keyboard().press("ArrowDown");
	}
	
	public void pressTab() throws Exception {
			page.keyboard().press("Tab");
			page.keyboard().press("ArrowDown");
	}

	public void verifysearchSavedSuccessfully() throws Exception {
		Map<String, String> testData = readJsonElement("SearchData.json", "searchdetails");
		String actualMessage = testData.get("Book_SavedSearchMessage");

		Locator element1 = page.locator(searchSavedSuccessfully);
		String expectedMessage = element1.textContent();

		boolean val = verifyAssertMessage(expectedMessage, actualMessage);

		Assert.assertTrue(val);
	}
	

	}
