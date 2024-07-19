package com.pages;

import org.testng.annotations.Test;

import com.Factory.PlaywrightFactory;
import com.microsoft.playwright.Page;


public class SearchIssues extends PlaywrightFactory {
	
	
	public String savedTab = "//div[text()='Saved']";
	
	public SearchIssues(Page page) {
		
		this.page = page;
		
	}
	
	public void SavedTab() {
		
		clickElement(savedTab);
	}
	
	

}
