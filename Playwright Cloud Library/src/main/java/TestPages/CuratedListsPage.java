package TestPages;

import java.util.Map;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import PlaywrightFactory.PlaywrightFactory;

public class CuratedListsPage extends PlaywrightFactory{
	
	public Page page;
	public SearchPage searchpage = new SearchPage(page);
	
	public String mnuCuratedLists = "//span[text()='Curated Lists']";
	public String lnkViewAll ="//span[text()='TestGroup']/following::span[1]";
	public String curatedListItem ="//span[text()='Top Circulating']";
	public String btnSelectAll="//button[text()='Select All']";
	public String addToCartdrpdwn = "//button[@class='cart-tomain-dropdown ']";
	public String SelectAll = "//button[@class='secondary']";
	public String mnuMyCarts = "//div[text()='My Carts']";
	public String cart = "//span[contains(text(),'Carts')]";
	public String cartAddedSuccessfully = "//span[contains(text(),'Added successfully.')]";
	public String bcklnkMyCarts = "//u[text()='My Carts']";
	public String createCartButton = "//button[@class='primary']";
	public String btnDeleteCartPopup = "//button[text()='Delete']";
	public String dltCnfrm = "//span[text()='Cart deleted successfully.']";
	
	
	public CuratedListsPage(Page page)
	{
		this.page=page;
	}
	
	public void createCart() throws Exception {
		searchpage.waitForElement(2);
		waitForVisibilityOf(createCartButton);
		clickElement(createCartButton);
	}

	public void clickCart() throws Exception {
		Map<String, String> testData = readJsonElement("CuratedLists.json", "AddToCart");
		String newCartName = testData.get("CartName");
		String newCart = "//span[text()='" + newCartName + " ']";
		clickElement(newCart);
	}

	public void addToCart() throws Exception {
		Map<String, String> testData = readJsonElement("CuratedLists.json", "AddToCart");
		String newCartName = testData.get("CartName");
		String newCart = "//p[text()='" + newCartName + "']";
		clickElement(newCart);
	}

	public void sltNewCart() throws Exception {
		Map<String, String> testData = readJsonElement("CuratedLists.json", "AddToCart");
		String newCartName = testData.get("CartName");
		String newCart = "//span[text()='" + newCartName + "']";
		clickElement(newCart);
	}

	public void dltNewCart() throws Exception {
		
		Map<String, String> testData = readJsonElement("CuratedLists.json", "verifyDeleteNewCart");
		String newCartName = testData.get("CartName");
		String newCart = "//span[text()='" + newCartName + "']/following::img[@alt='deleteIcon'][1]";
		clickElement(newCart);
	}
	
	public boolean verifyAddToCartSuccessfully() throws Exception {
		Map<String, String> testData = readJsonElement("CuratedLists.json", "AddToCart");
		String actualMessage = testData.get("CartAddtoMessage");
		
		waitForElement(3);

		Locator element1 = page.locator(cartAddedSuccessfully);
		String expectedMessage = element1.textContent();

		boolean result = false;

		if (expectedMessage.equalsIgnoreCase(actualMessage)) {
			result = true;
		}
		return result;
	}
	

}
