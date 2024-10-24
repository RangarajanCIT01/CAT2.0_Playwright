package TestCases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.base.BaseTest;

public class Spotlight_Test extends BaseTest{
	
	@Test
	public void validateSpotlight() throws Exception
	{	
		spotlight.clickOnSpotlight();
		spotlight.clickOnFeature();
		spotlight.clickOnToggle();
		spotlight.addToCart();
		Thread.sleep(5000);
		spotlight.verifyAddToCartSuccessfully();
		
		//cartpage.navigateCartPage();
		cartpage.clickOnSpotlightCartTitle();
		cartpage.verifySportLightCartTitleCount();
	}

}
