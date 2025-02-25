package TestCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.util.ArrayList;
import java.util.Map;

import BaseClass.BaseTest;
import TestPages.CartPage;
import TestPages.SearchPage;

public class Cart_Test extends BaseTest{
	
	@BeforeClass
	public void setupBefore() throws Exception {
		
		cartpage = new CartPage(page);
		searchpage = new SearchPage(page);
		searchpage.clickOnSearch();
		Map<String, String> testData = playwrightFactory.readJsonElement("CartData.json", "Editor");
	
		searchpage.clickSearchButton();
		searchpage.editorDropdown(testData.get("Book_PageSize"));	
		searchpage.clseLftPnlIfExists();
	}	
	
	@Test (priority=1)
	public void verifyCreateNewCart() throws Exception
	{		
		Map<String, String> testData = playwrightFactory.readJsonElement("CartData.json", "verifyCreateNewCart");
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
		Map<String, String> testData = playwrightFactory.readJsonElement("CartData.json", "AddToCart");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		searchpage.clickOnSearch();
		searchpage.enterBookTitle(testData.get("Book_Title"));
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.selectAll();
		searchpage.clickElement(cartpage.addToCartdrpdwn);
		cartpage.addToCart();
		searchpage.verifyAddToCartSuccessfully();
		
		actualData.add(page.locator(searchpage.cartAddedSuccessfully).textContent());
		expectedData.add(testData.get("CartAddtoMessage"));	
		AssertJUnit.assertEquals(expectedData, actualData);
		
	}
	
	@Test(priority=3)
	public void verifyAddToCart() throws Exception
	{	
		Map<String, String> testData = playwrightFactory.readJsonElement("CartData.json", "verifyAddToCart");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		searchpage.clseLftPnlIfExists();
		cartpage.navigateToCartPage();
		cartpage.sltNewCart();
		
		cartpage.loadCartResult();
		actualData.add(page.locator(cartpage.cartTitleCount).textContent());
		expectedData.add(testData.get("CartBookTitleCount"));	
		AssertJUnit.assertEquals(expectedData, actualData);
		
	}
	
	@Test(priority=4)
	public void verifyDeleteNewCart() throws Exception
	{	
		Map<String, String> testData = playwrightFactory.readJsonElement("CartData.json", "verifyDeleteNewCart");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		searchpage.clickElement(cartpage.bcklnkMyCarts);
		cartpage.dltNewCart();
		searchpage.clickElement(cartpage.btnDeleteCartPopup);
		
		actualData.add(page.locator(cartpage.dltCnfrm).textContent());
		expectedData.add(testData.get("CartDeleteSuccessMessage"));	
		AssertJUnit.assertEquals(expectedData, actualData);
		
	}
	
	@Test(priority=5)
	public void verifyMoveBetweenCarts() throws Exception
	{	

		Map<String, String> testData = playwrightFactory.readJsonElement("CartData.json", "verifyMoveBetweenCarts");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		cartpage.navigateToCartPage();
		cartpage.clickNewCart();
		cartpage.enterCartName(testData.get("CartName"));
		cartpage.enterDescription(testData.get("CartDesciption"));
		cartpage.createCart();
					
		actualData.add(page.locator(cartpage.cartAddedSuccessfully).textContent());
		expectedData.add(testData.get("CartAdded"));
		
		cartpage.clickNewCart();
		cartpage.enterCartName(testData.get("CartName2"));
		cartpage.enterDescription(testData.get("CartDesciption2"));
		cartpage.createCart();
					
		actualData.add(page.locator(cartpage.cartAddedSuccessfully).textContent());
		expectedData.add(testData.get("CartAdded"));
		AssertJUnit.assertEquals(expectedData, actualData);
		
		searchpage.clickOnSearch();
		searchpage.enterBookTitle(testData.get("Book_Title"));
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.selectAll();
		searchpage.clickElement(cartpage.addToCartdrpdwn);
		cartpage.addToCart();
		searchpage.verifyAddToCartSuccessfully();
		
		searchpage.clseLftPnlIfExists();
		cartpage.navigateToCartPage();
		cartpage.sltNewCart();
		
		cartpage.loadCartResult();
		actualData.add(page.locator(cartpage.cartTitleCount).textContent());
		expectedData.add(testData.get("CartBookTitleCount"));	
		AssertJUnit.assertEquals(expectedData, actualData);
		
		cartpage.selectBookCheckbox();
		searchpage.clickElement(cartpage.lnkMveBtwCarts);
		cartpage.mveToNewCart();
		cartpage.clickOnContinue();
		
		actualData.add(page.locator(cartpage.MveSuccessMsg).textContent());
		expectedData.add(testData.get("TitlesMovedMsg"));	
		AssertJUnit.assertEquals(expectedData, actualData);
			
		searchpage.clickElement(cartpage.bcklnkMyCarts);
		cartpage.dltNewCart();
		searchpage.clickElement(cartpage.btnDeleteCartPopup);
		
		actualData.add(page.locator(cartpage.dltCnfrm).textContent());
		expectedData.add(testData.get("CartDeleteSuccessMessage"));	
		AssertJUnit.assertEquals(expectedData, actualData);
		
		cartpage.sltNewCart2();
		cartpage.loadCartResult();
		actualData.add(page.locator(cartpage.cartTitleCount).textContent());
		expectedData.add(testData.get("CartBookTitleCount"));	
		AssertJUnit.assertEquals(expectedData, actualData);
		
		searchpage.clickElement(cartpage.bcklnkMyCarts);		
		cartpage.dltNewCart2();
		searchpage.clickElement(cartpage.btnDeleteCartPopup);
		
		actualData.add(page.locator(cartpage.dltCnfrm).textContent());
		expectedData.add(testData.get("CartDeleteSuccessMessage"));	
		
		AssertJUnit.assertEquals(expectedData, actualData);
		
		//searchpage.clickElement(cartpage.bcklnkMyCarts);
		
	}
	
	@Test(priority=6)
	public void verifyRemoveSelected() throws Exception
	{	

		Map<String, String> testData = playwrightFactory.readJsonElement("CartData.json", "verifyRemoveSelected");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		cartpage.navigateToCartPage();
		cartpage.clickNewCart();
		cartpage.enterCartName(testData.get("CartName"));
		cartpage.enterDescription(testData.get("CartDesciption"));
		cartpage.createCart();
					
		actualData.add(page.locator(cartpage.cartAddedSuccessfully).textContent());
		expectedData.add(testData.get("CartAdded"));
		
		searchpage.clickOnSearch();
		searchpage.enterBookTitle(testData.get("Book_Title"));
		searchpage.clickElement(searchpage.SearchButton);
		searchpage.selectAll();
		searchpage.clickElement(cartpage.addToCartdrpdwn);
		cartpage.addToCart();
		searchpage.verifyAddToCartSuccessfully();
		
		searchpage.clseLftPnlIfExists();
		cartpage.navigateToCartPage();
		cartpage.sltNewCart();
		
		cartpage.loadCartResult();
		actualData.add(page.locator(cartpage.cartTitleCount).textContent());
		expectedData.add(testData.get("CartBookTitleCount"));	
		AssertJUnit.assertEquals(expectedData, actualData);
		
		cartpage.selectBookCheckbox();
		cartpage.clickElement(cartpage.btnRemoveSelected);
		searchpage.waitForElement(3);
		cartpage.clickElement(cartpage.btnYes);
		
		actualData.add(page.locator(cartpage.msgRemoved).textContent());
		expectedData.add(testData.get("MsgRemoved"));	
		AssertJUnit.assertEquals(expectedData, actualData);
		
		searchpage.clickElement(cartpage.bcklnkMyCarts);
		cartpage.dltNewCart();
		searchpage.clickElement(cartpage.btnDeleteCartPopup);
		
		actualData.add(page.locator(cartpage.dltCnfrm).textContent());
		expectedData.add(testData.get("CartDeleteSuccessMessage"));	
		AssertJUnit.assertEquals(expectedData, actualData);
	}

	@Test(priority=7)
	public void verifyPrivateCart() throws Exception
	{	

		Map<String, String> testData = playwrightFactory.readJsonElement("CartData.json", "verifyPrivateCart");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		cartpage.navigateToCartPage();
		cartpage.clickNewCart();
		cartpage.enterCartName(testData.get("CartName"));
		cartpage.enterDescription(testData.get("CartDesciption"));
		cartpage.clickElement(cartpage.chkbxPrevent);
		cartpage.createCart();
					
		actualData.add(page.locator(cartpage.cartAddedSuccessfully).textContent());
		expectedData.add(testData.get("CartAdded"));
		AssertJUnit.assertEquals(expectedData, actualData);
		
		cartpage.vrfyPrivateCart();
	
		cartpage.dltNewCart();
		searchpage.clickElement(cartpage.btnDeleteCartPopup);
		
		actualData.add(page.locator(cartpage.dltCnfrm).textContent());
		expectedData.add(testData.get("CartDeleteSuccessMessage"));	
		AssertJUnit.assertEquals(expectedData, actualData);
		
	}
	
	@Test(priority=8)
	public void verifyCommunityCart() throws Exception
	{	

		Map<String, String> testData = playwrightFactory.readJsonElement("CartData.json", "verifyCommunityCart");
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
		
		cartpage.vrfyCommunityCart();
	
		cartpage.dltNewCart();
		searchpage.clickElement(cartpage.btnDeleteCartPopup);
		
		actualData.add(page.locator(cartpage.dltCnfrm).textContent());
		expectedData.add(testData.get("CartDeleteSuccessMessage"));	
		AssertJUnit.assertEquals(expectedData, actualData);
		
	}
	
}