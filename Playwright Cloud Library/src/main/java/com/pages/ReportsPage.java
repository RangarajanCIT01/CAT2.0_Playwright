package com.pages;

import java.util.Map;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import org.testng.Assert;

import com.Factory.PlaywrightFactory;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ReportsPage extends PlaywrightFactory{
	
	// References
	private Page page;
	
	// String Locators -Object Repository -OR
	private String Reports="//span[contains(text(),'Reports')]";
	private String ReportsTab="//div[@role='tab' and contains(text(),'Reports')]";
	private String Welcome="//div[@id='logindisplay']";

	
	public ReportsPage(Page page)
	{
		this.page=page;
	}
	
	// Page actions /methods
	public void clickOnReports() throws Exception 
	{
		waitForVisibilityOf(Reports);
		clickElement(Reports);
		Thread.sleep(2000);

	}
	
	public void verifyOnReportTab() throws Exception 
	{		
		page.click(ReportsTab);
		System.out.println(page.url());
		Thread.sleep(3000);
		
		Map<String, String> testData = readJsonElement("SettingsData.json", "settingdetails");
		String text=testData.get("ReportText");
		
		Locator element1 = page.locator(Welcome);
		String expectedMessage=element1.textContent();
		
		assertThat(page.locator(expectedMessage));
		
		boolean val=verifyAssertMessage(expectedMessage,text);
		Assert.assertTrue(val);
	}
}
