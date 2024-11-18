package ReportsPages;

import com.Factory.PlaywrightFactory;
import com.microsoft.playwright.Page;

public class QAReportsPage extends PlaywrightFactory {

	public Page page;
	
	public String txtUsrName = "//input[@id='UserName']";
	public String txtPswd = "//input[@id='Password']";
	public String btnLogOn = "//input[@value='Log On']";
	
	public String lnkReports = "#selectOption";
	
	public QAReportsPage(Page page)
	{
		this.page=page;
	}
	
	public void fillText(String locator, String text) throws InterruptedException {
		try {
			page.locator(locator).fill(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void enterUserName(String userName) throws Exception
	{
		
		fillText(txtUsrName,userName);
	}
	
	public void enterPassword(String passWord) throws Exception
	{
		
		fillText(txtPswd,passWord);
	}

	public void clickLogin() throws Exception
	{	
		
		clickElement(btnLogOn);
	} 

	
	
		
		
	
	


}
