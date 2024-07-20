package TestCases;

import org.testng.annotations.Test;

import com.base.BaseTest5;

public class Spotlight_Test extends BaseTest5{
	
	@Test
	public void validateSpotlight() throws Exception
	{	
		spotlight.clickOnSpotlight();
		spotlight.clickOnFeature();
		spotlight.clickOnToggle();
		spotlight.addToCart();
		Thread.sleep(5000);
		spotlight.verifyAddToCartSuccessfully();
		
		cartpage.navigateCartPage();
		cartpage.clickOnSpotlightCartTitle();
		cartpage.verifySportLightCartTitleCount();
	}

}
