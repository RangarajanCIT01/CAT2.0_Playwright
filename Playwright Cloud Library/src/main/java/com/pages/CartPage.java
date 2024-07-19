package com.pages;


import java.util.Map;
import java.util.Random;

import org.testng.Assert;

import com.Factory.PlaywrightFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;


public class CartPage extends PlaywrightFactory{
	
	// References
	private Page page;
	public static ExtentTest test;
	public static ExtentReports extent;
	static ExtentTest logger;
	protected SearchPage searchpage = new SearchPage(page);

	
	// String Locators -Object Repository -OR
	private String newCart="//button[@class='primary new-cart']";
	private String cartName="//input[@name='cartName']";
	private String cartDescription="//*[@id='description']";
	private String createCartButton="//button[@class='primary']";
	private String cart="//span[contains(text(),'Carts')]";
	public String cartAddedSuccessfully="//span[contains(text(),'Cart created successfully.')]";
	private String cartDeleteButton="//button[@class='smallRed confirm-button']";
	private String cartDeletedSuccessfully="//span[contains(text(),'Cart deleted successfully.')]";
	private String cartTitleList="//span[@class='cart-title']";
	private String cartDeleteButtonList="//img[contains(@src,'/static/media/deleteIcon.6e2e3761.svg')]";
	private String backButton="//button[@class='back-button']";
	public String cartTitleCount="//span[@class='title-count']";
	private String bookCheckbox="//span[@class='ant-checkbox']//input[@class='ant-checkbox-input']";	
	private String moveBetweenCartsDropdown="//span[contains(text(),'Move Between Carts')]";
	private String cartMovedSuccessfully="//span[contains(text(),'Moved successfully.')]";
	private String clickContinue="//button[@class='primary confirm-button moveConfirm']";
	private String cartBack="//button[@class='back-button']";
	private String totalAmount="//div[@class='ant-col']//p[@class='footer-label']//b";
	private String purchaseCart="//button[@class='primary mark-ready-button' ][1]";
	private String purchaseSelected="//button[@class='primary mark-ready-button' and contains(text(),'Purchase Selected')]";
	private String purchaseTotalAmount="//b[@class='PurchaseTotalAmount']";
	private String selectBooks="//span[@class='ant-checkbox']//input";
	private String closePurchaseSelected="//span[@role='img' and @aria-label='close']";
	private String removeSelected="//button[@class='smallRed mark-ready-button']";
	private String yesButton="//button[@class='primary confirm-button']";
	
	// Page Constructor
	public CartPage(Page page)
	{
		this.page=page;
	}
		
	// Page actions /methods
	public void navigateCartPage() throws InterruptedException
	{
		waitForVisibilityOf(cart);
		clickElement(cart);
	}
	
	public void navigateCartAndSearchPage() throws InterruptedException
	{
		waitForVisibilityOf(cart);
		clickElement(cart);

		waitForVisibilityOf(searchpage.Search);
		clickElement(searchpage.Search);
	}
	
	public void clickNewCart() throws Exception
	{
		waitForVisibilityOf(newCart);
		clickElement(newCart);
	}
	
	public void enterCartName() throws Exception 
	{
		cartname=createRandomName();
		fillText(cartName,cartname);
	}
	
	public void enterSecondCartName() throws Exception 
	{
		cartname2=createRandomName();
		fillText(cartName,cartname2);
	}
	
	public void enterDescription() throws Exception 
	{		
		waitForVisibilityOf(cartDescription);
		Map<String, String> testData = readJsonElement("CartData.json", "cartdetails");
		
		fillText(cartDescription, testData.get("CartDesciption"));
	}
	

	public void enterDescription(String value) throws Exception 
	{		
		waitForVisibilityOf(cartDescription);
		//Map<String, String> testData = readJsonElement("CartData.json", "cartdetails");
		
		fillText(cartDescription, value);
	}
	

	public void createCart() throws Exception 
	{
		waitForVisibilityOf(createCartButton);
		clickElement(createCartButton);
		waitForElement(2);
	}
	
	// Verify if Cart added successfully
	public boolean verifyCartAddedSuccessfully() throws Exception
	{
		waitForVisibilityOf(cartAddedSuccessfully);
		Map<String, String> testData = readJsonElement("CartData.json", "cartdetails");
		String actualMessage=testData.get("CartAdded");
		//String expectedMessage=page.locator(cartAddedSuccessfully).textContent();
		String expectedMessage=testData.get("SuccessMessage");
		
		boolean val=verifyAssertMessage(expectedMessage,actualMessage);
		return val;
		//Assert.assertTrue(val);
		//Assert.assertEquals(actualMessage, expectedMessage);
		
	}
	
	//Verify Cart Title
	public boolean verifyCartTitle() throws Exception
	{
	
		Map<String, String> testData = readJsonElement("CartData.json", "cartdetails");
		String cartName=testData.get("CartName");
			
		boolean val=verifyTitleFromList(cartTitleList,cartName);
		return val;
		
	}
	
	// Delete Cart
	public void clickOnDeleteCart() throws Exception 
	{
		waitForElement(1);

		deleteFromList(cartTitleList,cartDeleteButtonList,cartname,cartDeleteButton);
	}
	
	public boolean verifyCartDeletedSuccessfully() throws Exception
	{
		Map<String, String> testData = readJsonElement("CartData.json", "cartdetails");
		String actualMessage=testData.get("CartDeleted");
		String expectedMessage=page.locator(cartDeletedSuccessfully).textContent();
		
		boolean val=verifyAssertMessage(expectedMessage,actualMessage);
		return val;	
	}
	
	
	
	public void clickOnBackButton() throws Exception 
	{
		waitForElement(1);
		clickElement(backButton);
	}
	
	public void clickOnCartTitle() throws Exception 
	{
		waitForElement(2);
		String Titlelist="//span[@class='cart-title']";
		
		clickFromList(Titlelist,cartname);
		waitForElement(5);
	}
	
	public void clickOnSecondCartTitle() throws Exception 
	{
		waitForElement(2);
		String Titlelist="//span[@class='cart-title']";
	
		clickFromList(Titlelist,cartname2);
	}
	
	public void clickOnSpotlightCartTitle() throws Exception 
	{
		waitForElement(2);
		Map<String, String> testData = readJsonElement("SpotlightData.json", "spotlightdetails");
		String Titlelist="//span[@class='cart-title']";

		String carttitle=testData.get("CartName");
		
		clickFromList(Titlelist,carttitle);
	}
	
	public void verifySportLightCartTitleCount() throws Exception
	{
		waitForElement(2);
		Map<String, String> testData = readJsonElement("CartData.json", "cartdetails");
		String CartBookCount=testData.get("CartBookTitleCount");
		
		Locator element1 = page.locator(cartTitleCount);
		String expectedMessage=element1.textContent();
		
		boolean val=verifyAssertMessage(expectedMessage,CartBookCount);
	
		Assert.assertTrue(val);
		waitForElement(1);
	}	
		
	public void verifyCartTitleCount() throws Exception
	{
		waitForElement(2);
		Map<String, String> testData = readJsonElement("CartData.json", "cartdetails");
		String CartBookCount2=testData.get("CartBookTitleCount");
		
		Locator element1 = page.locator(cartTitleCount);
		String expectedMessage=element1.textContent();
		
		boolean val=verifyAssertMessage(expectedMessage,CartBookCount2);
		
		
		
		System.out.println("String : "+CartBookCount2+" locator val : "+expectedMessage);
		
		Assert.assertTrue(val);
		waitForElement(1);
	}	
	
	
	
	public void selectBookCheckbox() throws Exception 
	{
		page.locator(bookCheckbox).first().dispatchEvent("click");
		waitForElement(1);
	}
		
	//Click On Move Between Carts
	public void clickMoveBetweenCarts() throws Exception 
	{
		Map<String, String> testData = readJsonElement("CartData.json", "cartdetails");
		String Elementlist="//li[@class='ant-dropdown-menu-item']";
		
		selectDropdownByScrolling(moveBetweenCartsDropdown,cartname2,Elementlist);
		waitForElement(3);
	}
		
	// Continue button
	public void clickOnContinue() throws Exception 
	{
		clickElement(clickContinue);
		waitForElement(3);
	}
	
	// Verify Move between cart message
	public void verifyCartMovedSuccessfully() throws Exception
	{
		Map<String, String> testData = readJsonElement("CartData.json", "cartdetails");
		String actualMessage=testData.get("MoveBetweenCart");
		
		Locator element1 = page.locator(cartMovedSuccessfully);
		String expectedMessage=element1.textContent();
		
		boolean val=verifyAssertMessage(expectedMessage,actualMessage);
		//return val;
		Assert.assertTrue(val);
	}
	
	public void moveBack() 
	{
		clickElement(cartBack);
	}
	
	/*public void clickOnSecondCartTitle() throws Exception 
	{
		Thread.sleep(2000);
		Map<String, String> testData = readJsonElement("CartData.json", "cartdetails");
		String Titlelist="//span[@class='cart-title']";

		String carttitle=testData.get("MoveBetweenCarttitle");
		
		clickFromList(Titlelist,carttitle);
	}*/
	
	public void verifyTotalAmountPurchaseCart() throws Exception 
	{	
		Locator element1 = page.locator(totalAmount);
		String totalAMount=element1.textContent();
		
		page.locator(purchaseCart).first().dispatchEvent("click");
		
		waitForElement(2);
		Locator element2 = page.locator(purchaseTotalAmount);
		String totalAmount2=element2.textContent();
		
		boolean val=verifyAssertMessage(totalAMount,totalAmount2);
		waitForElement(2);
		clickElement(closePurchaseSelected);
		waitForElement(2);
	}
	
	public void verifyTotalPurchaseSelected() throws Exception 
	{
		waitForElement(2);

		Locator element1 = page.locator(totalAmount);
		String totalAMount=element1.textContent();
		
		page.locator(selectBooks).first().dispatchEvent("click");
		page.locator(purchaseSelected).first().dispatchEvent("click");

		
		waitForElement(6);
		Locator element2 = page.locator(purchaseSelected).first();
		String totalAmount2=element2.textContent();
		
		boolean val=verifyAssertMessage(totalAMount,totalAmount2);
		
		waitForElement(3);
		clickElement(closePurchaseSelected);	
		waitForElement(2);
	}
	
	public void verifyRemoveSelected() throws Exception 
	{
		page.locator(selectBooks).first().dispatchEvent("click");
		waitForElement(2);
		
		page.locator(removeSelected).first().click();
		waitForElement(2);
		
		page.locator(yesButton).first().click();
		
		clickElement(closePurchaseSelected);		
	}
	
	
}
		
	

