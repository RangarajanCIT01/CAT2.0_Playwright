package TestCases;

import java.util.ArrayList;
import java.util.Map;

import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseClass.PlaywrightFactory;
import TestPages.CartPage;
import TestPages.SearchPage;

public class Spotlight_Test extends PlaywrightFactory{
	
	@BeforeClass
	public void setupBefore() throws Exception {
		
		cartpage = new CartPage(page);
		searchpage = new SearchPage(page);
		searchpage.clickOnSearch();
		Map<String, String> testData = baseTest.readJsonElement("Spotlight.json", "Editor");
	
		searchpage.clickSearchButton();
		searchpage.editorDropdown(testData.get("Book_PageSize"));	
		searchpage.clseLftPnlIfExists();
	}	
	
	@Test (priority=1)
	public void verifyCreateNewCart() throws Exception
	{		
		Map<String, String> testData = baseTest.readJsonElement("Spotlight.json", "verifyCreateNewCart");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		cartpage.navigateToCartPage();
		cartpage.clickNewCart();
		cartpage.enterCartName(testData.get("CartName"));
		cartpage.enterDescription(testData.get("CartDesciption"));
		cartpage.createCart();
					
		actualData.add(page.locator(cartpage.cartAddedSuccessfully).textContent());
		expectedData.add(testData.get("CartAdded"));
				
		AssertJUnit.assertEquals(expectedData, actualData);
	}
		
	
	@Test(priority=2)
	public void AddToCart() throws Exception
	{	
		Map<String, String> testData = baseTest.readJsonElement("Spotlight.json", "AddToCart");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		clickElement(spotlight.menuSpotlight);
		clickElement(spotlight.lnkViewAll);
		clickElement(spotlight.SelectAll);
		clickElement(spotlight.addToCartdrpdwn);
		spotlight.addToCart();
			
		actualData.add(page.locator(curatedList.cartAddedSuccessfully).textContent());
		expectedData.add(testData.get("CartAddtoMessage"));	
		AssertJUnit.assertEquals(expectedData, actualData);
		
	}
	
	@Test(priority=3)
	public void verifyTitlesInCart() throws Exception
	{	
		Map<String, String> testData = baseTest.readJsonElement("Spotlight.json", "verifyTitlesInCart");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		clickElement(curatedList.cart);
		clickElement(curatedList.mnuMyCarts);
		curatedList.sltNewCart();
		
		cartpage.loadCartResult();
		actualData.add(page.locator(cartpage.cartTitleCount).textContent());
		expectedData.add(testData.get("CartBookTitleCount"));	
		AssertJUnit.assertEquals(expectedData, actualData);
	}
	
	@Test(priority=4)
	public void verifyDeleteNewCart() throws Exception
	{	
		Map<String, String> testData = baseTest.readJsonElement("Spotlight.json", "verifyDeleteNewCart");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		curatedList.clickElement(curatedList.bcklnkMyCarts);
		curatedList.dltNewCart();
		curatedList.clickElement(curatedList.btnDeleteCartPopup);
		
		actualData.add(page.locator(curatedList.dltCnfrm).textContent());
		expectedData.add(testData.get("CartDeleteSuccessMessage"));	
		AssertJUnit.assertEquals(expectedData, actualData);
		
	}
	
}
