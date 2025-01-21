package com.pages;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

import org.testng.Assert;

import com.Factory.PlaywrightFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CartPage extends PlaywrightFactory {

	public Page page;
	public static ExtentTest test;
	public static ExtentReports extent;
	static ExtentTest logger;
	public SearchPage searchpage = new SearchPage(page);

	public String newCart = "//button[@class='primary new-cart']";
	public String cartName = "//input[@id='cartName']";
	public String cartDescription = "//*[@id='description']";
	public String createCartButton = "//button[@class='primary']";
	public String cart = "//span[contains(text(),'Carts')]";
	public String cartAddedSuccessfully = "//span[contains(text(),'Cart created successfully.')]";
	public String cartDeleteButton = "//button[@class='smallRed confirm-button']";
	public String cartDeletedSuccessfully = "//span[contains(text(),'Cart deleted successfully.')]";
	public String cartTitleList = "//span[@class='cart-title']";
	public String cartDeleteButtonList = "//img[contains(@src,'/static/media/deleteIcon.6e2e3761.svg')]";
	public String backButton = "//button[@class='back-button']";
	public String cartTitleCount = "//span[@class='title-count']";
	public String bookCheckbox = "//span[@class='ant-checkbox']//input[@class='ant-checkbox-input']";
	public String moveBetweenCartsDropdown = "//span[contains(text(),'Move Between Carts')]";
	public String cartMovedSuccessfully = "//span[contains(text(),'Moved successfully.')]";
	public String clickContinue = "//button[@class='primary confirm-button moveConfirm']";
	public String cartBack = "//button[@class='back-button']";
	public String totalAmount = "//div[@class='ant-col']//p[@class='footer-label']//b";
	public String purchaseCart = "//button[@class='primary mark-ready-button' ][1]";
	public String purchaseSelected = "//button[@class='primary mark-ready-button' and contains(text(),'Purchase Selected')]";
	public String purchaseTotalAmount = "//b[@class='PurchaseTotalAmount']";
	public String selectBooks = "//span[@class='ant-checkbox']//input";
	public String closePurchaseSelected = "//span[@role='img' and @aria-label='close']";
	public String removeSelected = "//button[@class='smallRed mark-ready-button']";
	public String yesButton = "//button[@class='primary confirm-button']";
	public String addToCartdrpdwn = "//button[@class='cart-tomain-dropdown ']";
	public String sltCart = "//p[text()='aaaaacart']";
	public String bcklnkMyCarts = "//u[text()='My Carts']";
	public String dltCart = "//span[text()='AddBooksCart']/following::img[@alt='deleteIcon'][1]";
	public String btnDeleteCartPopup = "//button[text()='Delete']";
	public String dltCnfrm = "//span[text()='Cart deleted successfully.']";
	public String cartPageLoadingSpinner = "//div[text()='Loading...']";
	public String lnkMveBtwCarts = "//span[text()='Move Between Carts']";
	public String MveSuccessMsg = "//span[text()='Moved successfully.']";
	public String btnRemoveSelected = "//span[text()='Move Between Carts']/preceding::button[1]";
	public String msgRemoved = "//span[text()='Removed successfully.']";
	public String btnYes = "//button[text()='Yes']";
	public String chkbxPrevent = "//div[text()='Prevent others from making changes']/preceding::span[2]";
	public String txtPrivateCart = "//span[text()='ACart1908']/following::span[6]";

	/******** AUTO CARTS **************/

	public String mnuAutoCart = "//div[text()='Auto Carts']";
	public String tabEBooks = "//div[text()='ebooks']";
	//public String cartStructure = "//label[text()='Cart structure']/following::input[1]";
	public String cartStructure = "//label[text()='Cart structure']/following::div[@class='ant-select-selector'][1]";
	
	
	public String cartStructureOneCart = "//label[text()='Cart structure']/following::div[1]";
	public String cartStructure1Cart = "//span[text()='Create one cart for all autocart rules']";
	
	public String cartStructureMultipleCart = "//span[text()='Create multiple carts per one rule']";
	public String eBookOneCart = "//div[text()='ebooks']/following::span[text()='Create one cart for all autocart rules'][1]";
	
	public String cartStructureLists = "//div[@class='rc-virtual-list-holder-inner']";
	public String cartStructureLists2 = "//div[@class='ant-select-item ant-select-item-option options ant-select-item-option-active ant-select-item-option-selected']";
	
	
	public String autoCartManagerSelection = "//label[text()='Cart structure']/following::input[@type='search'][2]";
	//public String autoCartManager = "//label[text()='Autocart Manager']/following::div[1]";
	public String autoCartManagerList = "//div[@class='rc-virtual-list-holder-inner']";
	//public String autoCartManagersList = "//div[@class='ant-select-dropdown dropdown ant-select-dropdown-placement-bottomLeft ']";
	
	public String emailNotification = "//label[text()='Email Notification']/following::div[1]";
	public String emailNotificationLists = "//*[@id='scroll_scroll']/div[1]/form/div/div[1]/div[3]/div[2]/div/div/div[2]/div/div/div/div[2]/div[1]/div/div";
	
	public String maxCopiesOwned = "//input[@type='number']";
	public String eBookAutoPurchase = "//div[text()='ebooks']/following::span[text()='Auto Purchase'][1]";
	public String eBookAutoCartSpendingLimit = "//input[@name='CartSpending']";
	public String eBookAutoCartPoRef = "//input[@name='autoCartPurchase']";
	public String eBookAutoCartManualPurchase = "//div[text()='ebooks']/following::span[text()='Manual Purchase'][1]";
	public String btnSaveCarts = "//button[text()='Save']";
	
	public String eBookHoldsEditRules = "//span[text()='Holds']/following::u[1]";
	public String eBookSuggestionsEditRules = "//span[text()='Holds']/following::u[2]";
	public String eBookContentExpirationEditRules = "//span[text()='Holds']/following::u[3]";
	public String eBookHoldAutoCartToggle = "//div[text()='Hold']/following::p[1]/following::button[1]";
	public String eBookHoldRatioLimit = "//div[text()='Hold']/following::span[text()='Hold Ratio Limit'][1]/following::div[1]";

	public String eBookSuggestionsTab = "//div[text()='Suggestions']";
	public String eBookSuggestionsCartToggle = "//*[@id='rc-tabs-12-panel-3']/div/div[1]/div[2]/button";
	public String eBookNoOfSuggestions = "//*[@id='rc-tabs-16-panel-3']/div/div[2]/div/div[2]/div[2]/div/div[2]/input";
	public String eBookSuggestionsDuration = "//*[@id='rc-tabs-16-panel-3']/div/div[2]/div/div[3]/div/div/div/div[1]/span[2]";
	public String eBookSuggestion1Year = "//span[text()='1 Year']";
	public String eBookSuggestionPreSale = "//*[@id=\"rc-tabs-16-panel-3\"]/div/div[2]/div/div[4]/div[2]/button";

	public String eBookContentExpirationTab = "//div[text()='//div[text()='Content Expiration']']";
	public String eBookCntExpAutoCartToggle = "//*[@id='rc-tabs-16-panel-2']/div/div[1]/div[2]/button";
	public String eBookCntExpAutoCartMinChk = "//*[@id='rc-tabs-16-panel-2']/div/div[2]/div/div[2]/div[2]/div/div[2]/input";

	public String btnSave = "//*[@id='rc-tabs-16-panel-2']/div/div[3]/div[2]/button";
	public String btnSaveAutoCarts = "//button[text()='Save']";
	
	public String btnSaveCartSt = "//*[@id='rc-tabs-0-panel-3']/div[2]/button";
	
	public String tabAudioBooks = "//div[text()='AudioBooks']";

	public CartPage(Page page) {
		this.page = page;
	}

	public void navigateToCartPage() throws InterruptedException {
		waitForVisibilityOf(cart);
		clickElement(cart);
	}

	public void navigateCartAndSearchPage() throws InterruptedException {
		waitForVisibilityOf(cart);
		clickElement(cart);

		waitForVisibilityOf(searchpage.Search);
		clickElement(searchpage.Search);
	}

	public void loadCartResult() {
		waitForVisibilityOfHidden(cartPageLoadingSpinner);
		untilDomContentLoads();
		untilDefaultLoadStateCompletes();
	}

	public void clickNewCart() throws Exception {
		waitForElement(3);
		waitForVisibilityOf(newCart);
		clickElement(newCart);
	}

	public void enterCartName(String value) throws Exception {
		fillText(cartName, value);
	}

	public void enterDescription(String value) throws Exception {
		waitForVisibilityOf(cartDescription);
		fillText(cartDescription, value);
	}

	public void createCart() throws Exception {
		searchpage.waitForElement(2);
		waitForVisibilityOf(createCartButton);
		clickElement(createCartButton);
	}

	public void clickCart() throws Exception {
		Map<String, String> testData = readJsonElement("CartData.json", "AddToCart");
		String newCartName = testData.get("CartName");
		String newCart = "//span[text()='" + newCartName + " ']";
		clickElement(newCart);
	}

	public void addToCart() throws Exception {
		Map<String, String> testData = readJsonElement("CartData.json", "AddToCart");
		String newCartName = testData.get("CartName");
		String newCart = "//p[text()='" + newCartName + "']";
		clickElement(newCart);
	}

	public void sltNewCart() throws Exception {
		Map<String, String> testData = readJsonElement("CartData.json", "AddToCart");
		String newCartName = testData.get("CartName");
		String newCart = "//span[text()='" + newCartName + "']";
		clickElement(newCart);
	}

	public void sltNewCart2() throws Exception {
		Map<String, String> testData = readJsonElement("CartData.json", "verifyMoveBetweenCarts");
		String newCartName = testData.get("CartName2");
		String newCart = "//span[text()='" + newCartName + "']";
		clickElement(newCart);
	}

	public void dltNewCart() throws Exception {
		searchpage.waitForElement(3);
		Map<String, String> testData = readJsonElement("CartData.json", "verifyDeleteNewCart");
		String newCartName = testData.get("CartName");
		String newCart = "//span[text()='" + newCartName + "']/following::img[@alt='deleteIcon'][1]";
		clickElement(newCart);
	}

	public void dltNewCart2() throws Exception {
		searchpage.waitForElement(3);
		Map<String, String> testData = readJsonElement("CartData.json", "verifyMoveBetweenCarts");
		String newCartName = testData.get("CartName2");
		String newCart = "//span[text()='" + newCartName + "']/following::img[@alt='deleteIcon'][1]";
		clickElement(newCart);
	}

	public void mveToNewCart() throws Exception {
		Map<String, String> testData = readJsonElement("CartData.json", "verifyMoveBetweenCarts");
		String newCartName = testData.get("CartName2");
		String newCart = "//p[text()='" + newCartName + "']";
		clickElement(newCart);
	}

	public void vrfyPrivateCart() throws Exception {
		Map<String, String> testData = readJsonElement("CartData.json", "verifyPrivateCart");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		String newCartName = testData.get("CartName");
		String privateCart = page.locator("//span[text()='" + newCartName + "']/following::span[6]").textContent();
		String pc = privateCart.toString();

		actualData.add(pc);
		expectedData.add(testData.get("TextPrivateCart"));
		Assert.assertEquals(expectedData, actualData);
	}

	public void vrfyCommunityCart() throws Exception {
		Map<String, String> testData = readJsonElement("CartData.json", "verifyCommunityCart");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		String newCartName = testData.get("CartName");
		String privateCart = page.locator("//span[text()='" + newCartName + "']/following::span[6]").textContent();
		String pc = privateCart.toString();

		actualData.add(pc);
		expectedData.add(testData.get("TextCommunityCart"));
		Assert.assertEquals(expectedData, actualData);
	}

	public boolean verifyCartAddedSuccessfully() throws Exception {
		waitForVisibilityOf(cartAddedSuccessfully);
		Map<String, String> testData = readJsonElement("CartData.json", "cartdetails");
		String actualMessage = testData.get("CartAdded");
		// String expectedMessage=page.locator(cartAddedSuccessfully).textContent();
		String expectedMessage = testData.get("SuccessMessage");

		boolean val = verifyAssertMessage(expectedMessage, actualMessage);
		return val;

	}

	public void enterSecondCartName() throws Exception {
		String cartname2;
		cartname2 = createRandomName();
		fillText(cartName, cartname2);
	}

	public boolean verifyCartTitle() throws Exception {
		Map<String, String> testData = readJsonElement("CartData.json", "cartdetails");
		String cartName = testData.get("CartName");

		boolean val = verifyTitleFromList(cartTitleList, cartName);
		return val;

	}

	public void clickOnDeleteCart() throws Exception {
		// deleteFromList(cartTitleList, cartDeleteButtonList, cartname,
		// cartDeleteButton);
	}

	public boolean verifyCartDeletedSuccessfully() throws Exception {
		Map<String, String> testData = readJsonElement("CartData.json", "cartdetails");
		String actualMessage = testData.get("CartDeleted");
		String expectedMessage = page.locator(cartDeletedSuccessfully).textContent();

		boolean val = verifyAssertMessage(expectedMessage, actualMessage);
		return val;
	}

	public void clickOnBackButton() throws Exception {
		clickElement(backButton);
	}

	public void clickOnCartTitle() throws Exception {
		String Titlelist = "//span[@class='cart-title']";
		// clickFromList(Titlelist, cartname);
	}

	public void clickOnSecondCartTitle() throws Exception {

		String Titlelist = "//span[@class='cart-title']";

		// clickFromList(Titlelist, cartname2);
	}

	public void clickOnSpotlightCartTitle() throws Exception {

		Map<String, String> testData = readJsonElement("SpotlightData.json", "spotlightdetails");
		String Titlelist = "//span[@class='cart-title']";

		String carttitle = testData.get("CartName");

		clickFromList(Titlelist, carttitle);
	}

	public void verifySportLightCartTitleCount() throws Exception {
		Map<String, String> testData = readJsonElement("CartData.json", "cartdetails");
		String CartBookCount = testData.get("CartBookTitleCount");

		Locator element1 = page.locator(cartTitleCount);
		String expectedMessage = element1.textContent();

		boolean val = verifyAssertMessage(expectedMessage, CartBookCount);

		Assert.assertTrue(val);

	}

	public void verifyCartTitleCount() throws Exception {

		Map<String, String> testData = readJsonElement("CartData.json", "cartdetails");
		String CartBookCount2 = testData.get("CartBookTitleCount");

		Locator element1 = page.locator(cartTitleCount);
		String expectedMessage = element1.textContent();

		boolean val = verifyAssertMessage(expectedMessage, CartBookCount2);

		System.out.println("String : " + CartBookCount2 + " locator val : " + expectedMessage);

		Assert.assertTrue(val);

	}

	public void selectBookCheckbox() throws Exception {
		page.locator(bookCheckbox).first().dispatchEvent("click");

	}

	public void clickOnContinue() throws Exception {
		clickElement(clickContinue);
	}

	public void verifyCartMovedSuccessfully() throws Exception {
		Map<String, String> testData = readJsonElement("CartData.json", "cartdetails");
		String actualMessage = testData.get("MoveBetweenCart");

		Locator element1 = page.locator(cartMovedSuccessfully);
		String expectedMessage = element1.textContent();

		boolean val = verifyAssertMessage(expectedMessage, actualMessage);
		Assert.assertTrue(val);
	}

	public void moveBack() {
		clickElement(cartBack);
	}

	public void verifyTotalAmountPurchaseCart() throws Exception {
		Locator element1 = page.locator(totalAmount);
		String totalAMount = element1.textContent();

		page.locator(purchaseCart).first().dispatchEvent("click");

		Locator element2 = page.locator(purchaseTotalAmount);
		String totalAmount2 = element2.textContent();

		boolean val = verifyAssertMessage(totalAMount, totalAmount2);
		clickElement(closePurchaseSelected);
	}

	public void verifyTotalPurchaseSelected() throws Exception {
		waitForElement(2);

		Locator element1 = page.locator(totalAmount);
		String totalAMount = element1.textContent();

		page.locator(selectBooks).first().dispatchEvent("click");
		page.locator(purchaseSelected).first().dispatchEvent("click");

		Locator element2 = page.locator(purchaseSelected).first();
		String totalAmount2 = element2.textContent();

		boolean val = verifyAssertMessage(totalAMount, totalAmount2);

		clickElement(closePurchaseSelected);
	}

	public void verifyRemoveSelected() throws Exception {
		page.locator(selectBooks).first().dispatchEvent("click");
		page.locator(removeSelected).first().click();
		page.locator(yesButton).first().click();
		clickElement(closePurchaseSelected);
	}

	public void verifySelectCart(String value) throws Exception {
		if (value.equals("One Cart")) {
			clickElement(cartStructureOneCart);
		} else {
			clickElement(cartStructureMultipleCart);
		}
	}

	public void SelectCartStructure(String value) throws Exception {
		Map<String, String> testData = searchpage.readJsonElement("AutoCart.json", "verifyCreateNewCart");

		String onecart = page.locator(cartStructureOneCart).textContent();
		String multiplecart = page.locator(cartStructureMultipleCart).textContent();

		if (value.equals("One Cart")) {
			clickElement(eBookOneCart);
		} else {
			clickElement(cartStructureMultipleCart);
		}

	}

}
