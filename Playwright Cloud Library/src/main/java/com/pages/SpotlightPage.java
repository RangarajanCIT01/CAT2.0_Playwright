package com.pages;

import java.util.Map;

import com.Factory.PlaywrightFactory;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class SpotlightPage extends PlaywrightFactory{
	
	private Page page;
	
	private String Spotlight="//div[contains(text(),'Spotlight')]";
	private String Featured="//li[@class='featureList ' and contains(text(),'Adult NonFiction Top New Releases 6/5/2023 - 6/11/2023')]";
	private String AddToCartDropdown="//button[@class='cart-tomain-dropdown']";
	private String cartAddedSuccessfully="//span[contains(text(),'Added successfully.')]";
	private String Toggle="//button[@role='switch']";
	
	public SpotlightPage(Page page)
	{
		this.page=page;
	}
	
	public void clickOnSpotlight() throws Exception 
	{
		clickElement(Spotlight);
	}
	
	public void clickOnFeature() throws Exception 
	{
		clickElement(Featured);
	}
	
	public void clickOnToggle() throws Exception 
	{
		clickElement(Toggle);
	}
	
	public void addToCart() throws Exception
	{
		Map<String, String> testData = readJsonElement("SpotlightData.json", "spotlightdetails");
		String Elementlist="//li[@class='ant-dropdown-menu-item']";
		String carttitleoption=testData.get("CartName");
		selectDropdownByScrolling(AddToCartDropdown,carttitleoption,Elementlist);
	}
	
	public boolean verifyAddToCartSuccessfully() throws Exception
	{
		Map<String, String> testData = readJsonElement("SpotlightData.json", "spotlightdetails");
		String actualMessage=testData.get("CartAddtoMessage");

		Locator element1 = page.locator(cartAddedSuccessfully);
		String expectedMessage=element1.textContent();
			
		boolean result = false;
			
		if(expectedMessage.equalsIgnoreCase(actualMessage)) {
			result = true;
		}
		return result;		
	}
	

}
