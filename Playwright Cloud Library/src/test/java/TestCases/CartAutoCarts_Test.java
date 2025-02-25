package TestCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.ArrayList;
import java.util.Map;

import BaseClass.BaseTest;
import TestPages.CartPage;
import TestPages.SearchPage;

public class CartAutoCarts_Test extends BaseTest{
	
	@BeforeClass
	public void setupBefore() throws Exception {
		
		cartpage = new CartPage(page);
		searchpage = new SearchPage(page);
		searchpage.clickOnSearch();
		
	}	
	
	@Test (priority=1)
	public void verifyCreateNewCart() throws Exception
	{		
		Map<String, String> testData = playwrightFactory.readJsonElement("AutoCart.json", "verifyCreateNewCart");
		ArrayList<Object> actualData = new ArrayList<>();
		ArrayList<Object> expectedData = new ArrayList<>();
		
		cartpage.navigateToCartPage();
		cartpage.clickElement(cartpage.mnuAutoCart);
		cartpage.clickElement(cartpage.tabEBooks);
		searchpage.loadResult();
		cartpage.clearAndfillText(cartpage.maxCopiesOwned, testData.get("MaxCopies"));
		cartpage.clickElement(cartpage.cartStructure);
		Thread.sleep(3000);
		cartpage.clickElement(cartpage.cartStructure1Cart);
		
		cartpage.clickElement(cartpage.cartStructure);
		
		cartpage.clickElement(cartpage.cartStructureMultipleCart);
		
		cartpage.clickElement(cartpage.cartStructure);
		
		//cartpage.selectDropdownSpecificSearch(cartpage.cartStructureLists2, testData.get("MultipleCart"));
		
		/*
		cartpage.clickElement(cartpage.autoCartManagerSelection);
		cartpage.selectDropdownSpecificSearchEquals(cartpage.autoCartManagerList, testData.get("AutoCartManager"));
	
		cartpage.clickElement(cartpage.emailNotification);
		cartpage.selectDropdownSpecificSearchEquals(cartpage.emailNotificationLists, testData.get("EmailNotification"));
	
		cartpage.clearAndfillText(cartpage.maxCopiesOwned, testData.get("MaxCopies"));
		
		cartpage.clickElement(cartpage.eBookAutoPurchase);
		
		cartpage.clearAndfillText(cartpage.eBookAutoCartSpendingLimit, testData.get("SpendingLimit"));
		cartpage.clearAndfillText(cartpage.eBookAutoCartPoRef, testData.get("PORef"));
		cartpage.clickElement(cartpage.btnSaveCarts);
		cartpage.clickElement(cartpage.btnSaveAutoCarts);
		//cartpage.clickElement(cartpage.eBookHoldsEditRules);
		//cartpage.clickElement(cartpage.eBookHoldAutoCartToggle);
		//cartpage.clickElement(cartpage.eBookHoldAutoCartToggle);
		//cartpage.clearAndfillText(cartpage.eBookHoldRatioLimit, testData.get("PORef")); 
	
		/*
		 * cartpage.enterCartName(testData.get("CartName"));
		 * cartpage.enterDescription(testData.get("CartDesciption"));
		 * cartpage.createCart();
		 * 
		 * actualData.add(page.locator(cartpage.cartAddedSuccessfully).textContent());
		 * expectedData.add(testData.get("CartAdded"));
		 
				
		AssertJUnit.assertEquals(expectedData, actualData); */
		
	}
	
}