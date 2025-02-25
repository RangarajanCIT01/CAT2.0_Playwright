package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;

import BaseClass.PlaywrightFactory;

public class Resources_Test extends PlaywrightFactory {

	public String mnuResources = "//span[text()='Resources']";
	public String acptcookies = "//button[@id='onetrust-accept-btn-handler']";
	
	@Test
	public void Verify_Resources() throws Exception {
		
		Page popup = page.waitForPopup(() -> {
					
			page.locator(mnuResources).click();
 
		});
		
		popup.click(acptcookies);

		Assert.assertEquals(page.title(), "CloudLibrary");
		page.close();
	}

}
