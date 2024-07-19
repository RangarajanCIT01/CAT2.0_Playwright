package com.pages;

import java.util.Map;

import com.Factory.PlaywrightFactory;
import com.microsoft.playwright.Page;

public class PurchasePage extends PlaywrightFactory{
	
	
	// References
	private Page page;
	
	// String Locators -Object Repository -OR
	private String Purchases="//span[contains(text(),'Purchases')]";
	private String WithinDays="//span[@class='ant-select-selection-item']//span[contains(text(),'Within 30 days')]";
	private String BuyersName="//span[@class='ant-select-selection-item']//span[contains(text(),'All buyers')]";
	//private String Purchases="//span[contains(text(),'Purchases')]";


	
	// Page Constructor
	public PurchasePage(Page page)
	{
		this.page=page;
	}
			
	// Page actions /methods
	public void clickOnPurchases() throws Exception 
	{
		
		clickElement(Purchases);
	}

	public void selectRecent() throws Exception 
	{
		Map<String, String> testData = readJsonElement("PurchaseData.json", "purchasedetails");
		
		String Elementlist="//div[@class='ant-select-item-option-content']";
		String daysOption=testData.get("Days");
		
		selectDropdownByScrolling(WithinDays,daysOption,Elementlist);
	}
	
	public void selectBuyers() throws Exception 
	{
		Map<String, String> testData = readJsonElement("PurchaseData.json", "purchasedetails");
		
		String Elementlist="//div[@class='ant-select-item-option-content']";
		String buyersOption=testData.get("Buyers");
		
		selectDropdownByScrolling(BuyersName,buyersOption,Elementlist);
	}
}
