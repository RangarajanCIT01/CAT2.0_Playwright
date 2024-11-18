package Reports_CAT;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.BaseTest3;
import ReportsPages.QAReportsPage;


public class ReportsTest extends BaseTest3 {
	
	@BeforeClass
	public void setupBefore() throws Exception {
		
		reportsPage = new QAReportsPage(page);
		
	}	
	
	@Test (priority=1)
	public void verifyCreateNewCart() throws Exception
	{		
		//reportsPage.enterUserName("uat15mn@yahoo.com");
		//reportsPage.enterPassword("3msuper#");	
		//reportsPage.clickLogin();
		reportsPage.clickElement(reportsPage.lnkReports);
		
		/*
		actualData.add(page.locator(cartpage.cartAddedSuccessfully).textContent());
		expectedData.add(testData.get("CartAdded"));
				
		AssertJUnit.assertEquals(expectedData, actualData); */
		
	}
}
