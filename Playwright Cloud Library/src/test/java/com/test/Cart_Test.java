package com.test;

import java.util.ArrayList;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseTest5;

public class Cart_Test extends BaseTest5{
	
	@Test
	public void verifyCreateNewCart() throws Exception
	{		
		Map<String, String> testData = playwrightFactory.readJsonElement("CartData.json", "cartdetails");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		cartpage.navigateCartPage();
		cartpage.clickNewCart();
		cartpage.enterCartName();
		cartpage.enterDescription(testData.get("CartDesciption"));
		cartpage.createCart();
		//cartpage.verifyCartAddedSuccessfully();
				
		actualData.add(page.locator(cartpage.cartAddedSuccessfully).textContent());
		expectedData.add(testData.get("CartAdded"));
				
		Assert.assertEquals(expectedData, actualData);
		
		//test.log(Status.PASS, "Cart created successfully");
	}
		
	@Test
	public void AddToCart() throws Exception
	{	
		Map<String, String> testData = playwrightFactory.readJsonElement("SearchData.json", "searchdetails");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		
		//searchpage.editorDropdown(10);
		searchpage.selectAll();
		searchpage.addToCart();
		searchpage.verifyAddToCartSuccessfully();
		
		actualData.add(page.locator(searchpage.cartAddedSuccessfully).textContent());
		expectedData.add(testData.get("CartAddtoMessage"));	
		Assert.assertEquals(expectedData, actualData);
		
	}
	
	@Test
	public void verifyAddToCart() throws Exception
	{	
		Map<String, String> testData = playwrightFactory.readJsonElement("CartData.json", "cartdetails");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
	//	test = extent.createTest("verifyAddToCart", "Verifying books are added to cart");
		cartpage.clickOnBackButton();
		cartpage.navigateCartPage();
		cartpage.clickOnCartTitle();
		cartpage.verifyCartTitleCount();
		
		actualData.add(page.locator(cartpage.cartTitleCount).textContent());
		expectedData.add(testData.get("CartBookTitleCount"));	
		Assert.assertEquals(expectedData, actualData);
		
	}
	
	@Test(description="Verify the total amount for Purchase cart and Purchase Selected, Remove selected from Cart",dependsOnMethods="verifyAddToCart")
	public void verifyPurchaseCart() throws Exception
	{	
		cartpage.navigateCartPage();
		cartpage.clickOnCartTitle();
		cartpage.verifyTotalAmountPurchaseCart();
		cartpage.verifyTotalPurchaseSelected();
		cartpage.verifyRemoveSelected();
	}
	
	@Test(description="Move books to new cart")
	public void verifyMoveBetweenCarts() throws Exception
	{	

		Map<String, String> testData = playwrightFactory.readJsonElement("CartData.json", "cartdetails");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		cartpage.clickOnBackButton();
		cartpage.navigateCartPage();
		cartpage.clickNewCart();
		cartpage.enterSecondCartName();
		cartpage.enterDescription();
		cartpage.createCart();
		//starting   
		//cartpage.navigateCartPage();
		cartpage.clickOnCartTitle();
		cartpage.selectBookCheckbox();
		cartpage.clickMoveBetweenCarts();
		cartpage.clickOnContinue();
		cartpage.verifyCartMovedSuccessfully();
		
		cartpage.moveBack();
		cartpage.clickOnSecondCartTitle();
		//cartpage.verifyCartTitleCount();
		
		actualData.add(page.locator(cartpage.cartTitleCount).textContent());
		expectedData.add(testData.get("CartBookTitleCount"));	
		Assert.assertEquals(expectedData, actualData);
	}
	//each class- 
	//4 classes in 1 clas
	//new cart-dynamic val
	//delete created data
	
//	@Test(dependsOnMethods="verifyPurchaseCart")
	public void verifyDeleteCart() throws Exception
	{				
		cartpage.navigateCartPage();
		cartpage.clickOnCartTitle();
		cartpage.clickOnDeleteCart();
		
	}
	
	//Added the below 3 classes from AddtoCart Class
	
	/*public void verifySearch1() throws Exception
	{	
		searchpage.clickOnSearch();
		//searchpage.enterBookKeyword();
		searchpage.enterBookTitle();
		searchpage.enterBookAuthor();
		searchpage.enterBookNarrator();
		searchpage.enterBookSeries();
		searchpage.preSaleTitles();
		searchpage.enterBookHoldRatio();
		searchpage.catergoryAndSubject();
		searchpage.audience();
		searchpage.enterPrice();
		searchpage.publishedWithin();
		searchpage.dateAddedToCloudLibrary();
		searchpage.languages();
		searchpage.publisher();
		searchpage.contentProviders();
		searchpage.bookFormats();
		searchpage.bookFilters();
		searchpage.clickSearchButton();
		searchpage.verifybookSearchByTitleCount();
		searchpage.verifyTitle();
		
	}
	*/
	
	@Test
	public void AddToCart1() throws Exception
	{		
		//searchpage.editorDropdown();
		searchpage.selectAll();
		searchpage.addToCart();
		searchpage.verifyAddToCartSuccessfully();
	}
	
	@Test
	public void verifyAddToCart1() throws Exception
	{		
		cartpage.clickOnBackButton();
		cartpage.navigateCartPage();
		cartpage.clickOnCartTitle();
		cartpage.verifyCartTitleCount();
	}
	
	//Added the below class from the CreateCart class
	@Test
	public void verifyCreateNewCart1() throws Exception
	{
	
		cartpage.navigateCartPage();
		
		boolean CartTitle=cartpage.verifyCartTitle();
		
		if(CartTitle==true)
		{
			cartpage.clickOnDeleteCart();
			
			cartpage.clickNewCart();
			cartpage.enterCartName();
			cartpage.enterDescription();
			cartpage.createCart();
			
			boolean cartAdded=cartpage.verifyCartAddedSuccessfully();
				if(cartAdded==true)
				{
					Assert.assertTrue(cartAdded);
				}
				else
				{
					Assert.assertTrue(cartAdded);
				}
		}
		else
		{
			cartpage.clickNewCart();
			cartpage.enterCartName();
			cartpage.enterDescription();
			cartpage.createCart();
			
			boolean cart1Added=cartpage.verifyCartAddedSuccessfully();
				if(cart1Added==true)
				{
					Assert.assertTrue(cart1Added);
				}
				else
				{
					Assert.assertTrue(cart1Added);
				}
		}}
	
		//Added the below methods from MoveBetweenCart Class
		
		@Test(description="Move books to new cart")
		public void verifyMoveBetweenCarts1() throws Exception
		{	
				
			cartpage.navigateCartPage();
			cartpage.clickOnCartTitle();
			cartpage.selectBookCheckbox();
			cartpage.clickMoveBetweenCarts();
			cartpage.clickOnContinue();
			cartpage.verifyCartMovedSuccessfully();
			
			cartpage.moveBack();
			cartpage.clickOnSecondCartTitle();
			cartpage.verifyCartTitleCount();
		}

}
