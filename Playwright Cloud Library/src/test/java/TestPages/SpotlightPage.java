package TestPages;

import java.util.Map;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import BaseClass.BaseTest;

public class SpotlightPage extends BaseTest{
	
	public Page page;
	public SearchPage searchpage = new SearchPage(page);
	
	public String menuSpotlight="//div[contains(text(),'Spotlight')]";
	public String Featured="//li[@class='featureList ' and contains(text(),'Adult NonFiction Top New Releases 6/5/2023 - 6/11/2023')]";
	public String AddToCartDropdown="//button[@class='cart-tomain-dropdown']";
	public String cartAddedSuccessfully="//span[contains(text(),'Added successfully.')]";
	public String Toggle="//button[@role='switch']";
	public String lnkViewAll="//span[text()='View All']";
	public String SelectAll = "//button[@class='secondary']";
	public String addToCartdrpdwn = "//button[@class='cart-tomain-dropdown ']";
	public String createCartButton = "//button[@class='primary']";
	
	
	public SpotlightPage(Page page)
	{
		this.page=page;
	}

	public void createCart() throws Exception {
		searchpage.waitForElement(2);
		waitForVisibilityOf(createCartButton);
		clickElement(createCartButton);
	}

	public void clickCart() throws Exception {
		Map<String, String> testData = readJsonElement("Spotlight.json", "AddToCart");
		String newCartName = testData.get("CartName");
		String newCart = "//span[text()='" + newCartName + " ']";
		clickElement(newCart);
	}

	public void addToCart() throws Exception {
		Map<String, String> testData = readJsonElement("Spotlight.json", "AddToCart");
		String newCartName = testData.get("CartName");
		String newCart = "//p[text()='" + newCartName + "']";
		clickElement(newCart);
	}

	public void sltNewCart() throws Exception {
		Map<String, String> testData = readJsonElement("Spotlight.json", "AddToCart");
		String newCartName = testData.get("CartName");
		String newCart = "//span[text()='" + newCartName + "']";
		clickElement(newCart);
	}

	public void dltNewCart() throws Exception {
		
		Map<String, String> testData = readJsonElement("Spotlight.json", "verifyDeleteNewCart");
		String newCartName = testData.get("CartName");
		String newCart = "//span[text()='" + newCartName + "']/following::img[@alt='deleteIcon'][1]";
		clickElement(newCart);
	}
	
	public boolean verifyAddToCartSuccessfully() throws Exception
	{
		Map<String, String> testData = readJsonElement("Spotlight.json", "spotlightdetails");
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
