package com.pages;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.testng.Assert;
import com.Factory.PlaywrightFactory;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class Shelf extends PlaywrightFactory{
	
	private Page page;
	
	private String Shelves="//span[contains(text(),'Shelves')]";
	private String newShelf="//button[@class='primary new-cart']";
	private String manualShelf="//div[contains(text(),'Manual Shelf')]";
	private String automatedShelf="//div[contains(text(),'Automated Shelf')]";
	private String shelfName="//div[@class='ant-col ant-col-24']//input[@name='shelveName']";
	private String shelfDescription="//div[@class='ant-col ant-col-24']//textarea[@name='shelveDescription']";
	private String clickContinue="//button[@class='medium']";
	private String shelfAddedSuccessfully="//span[contains(text(),'Shelf Created Successfully')]";
	private String shelfTitleCount="//span[@class='title-count']";
	private String bookCheckboxForPublish="//span[@class='ant-checkbox']//input[@class='ant-checkbox-input' and @type='checkbox']";
	private String publish="//button[@class='primary cancel-button unpublish-button']";
	private String shelfEditedSuccessfully="//span[contains(text(),'Shelf edited successfully')]";
	private String BookAuthor="//*[@name='AuthorSearch']";
	private String PublishedWithin="//div[@class='searchbyDateSelect'][1]//div[@class='ant-select-selector']";
	private String BookFormatopt="//span[@class='ant-checkbox ant-checkbox-checked']//input[@name='2']";
	private String createShelf =  "//*[@class='ant-col ant-col-5 ant-col-order-3 action-button primarySearch']/button";
	private String shelfDeleteButton="//button[@class='primary confirm-button']";

	
	public Shelf(Page page)
	{
		this.page=page;
	}
		
	public void clickOnShelves() throws Exception 
	{
		clickElement(Shelves);
	}
	
	public void clickOnNewShelve() throws Exception 
	{
		clickElement(newShelf);
	}
	
	public void manualShelfType() throws Exception 
	{
		clickElement(manualShelf);
	}
	
	public void enterManualShelfName() throws Exception 
	{	
		Map<String, String> testData = readJsonElement("ShelfData.json", "shelfdetails");
		String Sname=testData.get("ShelfName");
			
		fillText(shelfName,Sname);
	}
	
	public void enterManualShelfDescription() throws Exception 
	{
		Map<String, String> testData = readJsonElement("ShelfData.json", "shelfdetails");
		String Sdesc=testData.get("ShelfDescription");
		
		fillText(shelfDescription,Sdesc);
		
	}
	
	public void clickOnContinue() throws IOException, InterruptedException 
	{
		clickElement(clickContinue);
		
	}
	
	public boolean verifyShelfCreatedSuccessfully() throws Exception
	{
		Map<String, String> testData = readJsonElement("ShelfData.json", "shelfdetails");
		String actualMessage=testData.get("ShelfAdded");
		
		Locator element1 = page.locator(shelfAddedSuccessfully);
		String expectedMessage=element1.textContent();
				
		boolean val=verifyAssertMessage(expectedMessage,actualMessage);
		return val;
	}
	
	public void clickOnShelf() throws Exception 
	{
		
		Map<String, String> testData = readJsonElement("ShelfData.json", "shelfdetails");
		String elementList="//div[@class='card-titel']//span";
		String Sname=testData.get("ShelfName");
		
		clickFromList(elementList,Sname);
	}
	
	public boolean verifyShelfTitle() throws Exception
	{
		
		Map<String, String> testData = readJsonElement("ShelfData.json", "shelfdetails");
		String shelftitle=testData.get("ShelfName");
		String Elementlist1="//div[@class='card-titel']";
			
		boolean val=verifyTitleFromList(Elementlist1,shelftitle);
		return val;
	}
	
	public void clickOnDeleteShelf() throws Exception 
	{
		
		Map<String, String> testData = readJsonElement("ShelfData.json", "shelfdetails");
		String carttitle=testData.get("ShelfName");
		String Elementlist1="//div[@class='card-titel']//span";
		String Elementlist2="//img[contains(@src,'/static/media/deleteIcon.6e2e3761.svg')]";

		deleteFromList(Elementlist1,Elementlist2,carttitle,shelfDeleteButton);
	}
	
	public void verifyShelfTitleCount() throws Exception
	{
		
		Map<String, String> testData = readJsonElement("ShelfData.json", "shelfdetails");
		String CartBookCountShelf=testData.get("bookTitleCountShelf");
		
		boolean val=verifyCount(shelfTitleCount,CartBookCountShelf);
		
		Assert.assertTrue(val);
	}
	
	public void selectBookCheckbox() throws Exception 
	{
		page.locator(bookCheckboxForPublish).first().dispatchEvent("click");		
	}
	public void clickPublish() throws Exception 
	{
		clickElement(publish);
	}
	
	public boolean verifyShelfPublishedSuccessfully() throws Exception
	{
		Map<String, String> testData = readJsonElement("ShelfData.json", "shelfdetails");
		String actualMessage=testData.get("ShelfEdited");
		
		Locator element1 = page.locator(shelfAddedSuccessfully);
		String expectedMessage=element1.textContent();
		
		boolean val=verifyAssertMessage(expectedMessage,actualMessage);
		return val;	
	}
		
	public void shelfTypeAutomated() throws Exception 
	{
		clickElement(automatedShelf);
	}
	
	public void enterAutomatedShelfName() throws Exception 
	{		
		Map<String, String> testData = readJsonElement("ShelfData.json", "shelfdetails");
		String Sname=testData.get("AutomatedShelfName");
			
		fillText(shelfName,Sname);
		
	}
	
	public void enterAutomatedShelfDescription() throws Exception 
	{
		Map<String, String> testData = readJsonElement("ShelfData.json", "shelfdetails");
		String Sdesc=testData.get("AutoShelfDescription");
		
		fillText(shelfDescription,Sdesc);
		
	}
	
	public void enterAuthor() throws Exception 
	{
		Map<String, String> testData = readJsonElement("ShelfData.json", "shelfdetails");
		String author=testData.get("Author");
		fillText(BookAuthor,author);
		
	}
	
	public void publishedWithin() throws InterruptedException
	{
		selectDropdown(PublishedWithin,2);
		
	}
	
	public void bookFormats() throws InterruptedException
	{
		//SelectCheckbox(BookFormatopt);
		
	 }
	
	public void clickCreateShelfButton() throws InterruptedException 
	{
		clickElement(createShelf);
	}
	
}
