package TestPages;


import com.microsoft.playwright.Page;

import BaseClass.PlaywrightFactory;

public class LoginPage extends PlaywrightFactory{
	
	private Page page;
	private String username="//input[@name='email']";
	private String password="//input[@name='password']";
	private String loginButton="//button[@class='primary loginButton']";
	
	public LoginPage(Page page)
	{
		this.page=page;
	}

	public void enterUserName(String userName) throws Exception
	{
		waitForVisibilityOf(username);
		fillText(username,userName);
	}
	
	public void enterPassword(String passWord) throws Exception
	{
		waitForVisibilityOf(password);
		fillText(password,passWord);
	}

	public void clickLogin() throws Exception
	{	
		waitForVisibilityOf(loginButton);
		clickElement(loginButton);
	} 
		
}




























