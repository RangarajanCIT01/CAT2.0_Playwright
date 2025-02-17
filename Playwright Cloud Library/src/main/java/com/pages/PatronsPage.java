package com.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.testng.Assert;
import org.testng.AssertJUnit;

import com.Factory.PlaywrightFactory;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class PatronsPage extends PlaywrightFactory {

	public Page page;

	public String menuPatrons = "//span[text()='Patrons']";
	public String btnNewMessage = "//button[text()='New Message']";
		
	public PatronsPage(Page page) {
		this.page = page;
	}

	public void clickOnPatrons() throws Exception {
		clickElement(menuPatrons);
	}

	public void clickbtnNewMessage() throws IOException, InterruptedException {
		clickElement(btnNewMessage);
	}

	

}
