package TestCases;

import org.testng.annotations.Test;

import com.base.BaseTest5;
import com.pages.CartPage;

public class Purchase_Test extends BaseTest5{
	
	
	@Test()
	public void verifyPurchase() throws Exception
	{		
		purchase.clickOnPurchases();
		purchase.selectRecent();
		purchase.selectBuyers();
		
	}
	

	@Test(description="Verify the total amount for Purchase cart and Purchase Selected, Remove selected from Cart")
	public void verifyPurchaseCart() throws Exception
	{	
		cartpage=new CartPage(page);
		
		cartpage.navigateCartPage();
		cartpage.clickOnCartTitle();
		
		cartpage.verifyTotalAmountPurchaseCart();
		cartpage.verifyTotalPurchaseSelected();
		//cartpage.verifyRemoveSelected();
	}

}
