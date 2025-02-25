package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.PlaywrightFactory;

public class Support_Test extends PlaywrightFactory {

	public String mnuSupport = "//span[text()='Support']";
	public String lnkClickHere = "//a[text()='CLICK HERE']";
	
	@Test
	public void Verify_Support() throws Exception {
		
		page.waitForPopup(() -> {
					
			page.locator(mnuSupport).click();
			page.locator(lnkClickHere).click();
 
		});
				
		Assert.assertEquals(page.title(), "CloudLibrary");
		
		page.waitForTimeout(1000);
		page.close();
	}

}
