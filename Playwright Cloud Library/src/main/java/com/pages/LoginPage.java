package com.pages;


import java.util.Properties;
import com.Factory.PlaywrightFactory;
import com.microsoft.playwright.Page;

public class LoginPage extends PlaywrightFactory{
	
	// References
	private Page page;
	
	// String Locators -Object Repository -OR
	private String username="//input[@name='email']";
	private String password="//input[@name='password']";
	private String loginButton="//button[@class='primary loginButton']";
	
	// Page Constructor
	
	public LoginPage(Page page)
	{
		this.page=page;
	}

	// Page actions /methods
	
	// Enter User name
	public void enterUserName(String userName) throws Exception
	{
		waitForElement(4);
		waitForVisibilityOf(username);
		//String userName=prop.getProperty("username");
		fillText(username,userName);
	}
	
	// Enter Password
	public void enterPassword(String passWord) throws Exception
	{
		waitForVisibilityOf(password);
		//String passWord=prop.getProperty("password");
		fillText(password,passWord);
	}
	
	// Click Login button
	public void clickLogin() throws Exception
	{	
		waitForVisibilityOf(loginButton);
		clickElement(loginButton);
		waitForElement(5);
	} 
		
}




























