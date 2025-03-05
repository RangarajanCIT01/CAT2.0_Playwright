package TestPages;


import java.nio.file.Paths;
import java.util.Map;
import org.testng.Assert;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

import BaseClass.BaseTest;

public class NotForSalePage extends BaseTest{

		private Page page;
		public String lblNotForSale = "//span[@class='notFor_sale']";
	
		public NotForSalePage(Page page)
		{
			this.page=page;
		}
		
		public void verifyDetailsPage() throws Exception {
			Map<String, String> testData = readJsonElement("NotForSale.json", "VerifyNotForSaleTitleDetailsPage");
			String NotForSale = testData.get("Book_Title");
			String NotForSaleTitleName ="//span[text()='"+NotForSale+"']";
			clickElement(NotForSaleTitleName);
		}
		
		
		
		

}
