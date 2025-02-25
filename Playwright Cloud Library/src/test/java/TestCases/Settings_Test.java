package TestCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.Map;

import BaseClass.BaseTest;
import TestPages.SearchPage;

public class Settings_Test extends BaseTest{
	
	@BeforeClass
	public void setupBefore() throws Exception {
		
		searchpage=new SearchPage(page);
		searchpage.clickOnSearch();
		Map<String, String> testData = playwrightFactory.readJsonElement("SearchData.json", "searchdetails");
		
		searchpage.clickSearchButton();
		searchpage.editorDropdown(testData.get("Book_PageSize"));	
		searchpage.clseLftPnlIfExists();
	}

	@Test
	public void verifyLibrarySettings() throws Exception
	{				
		Map<String, String> testData = playwrightFactory.readJsonElement("SettingsData.json", "settingdetails");
		
		settings.clickOnSettings();
		settings.clickEditSupportEmail();
		settings.enterSupportingEmail();
		settings.clickOnSaveButton();
		
		settings.clickEditLibraryWebsite();
		settings.enterLibraryWebsite();
		settings.clickOnSaveButton();
		
		settings.clickDefaultLanguage(testData.get("Language"));
		settings.enterDefaultLanguage();
		settings.clickOnSaveButton();
	}
	
	@Test
	public void verifyPatronSettings() throws Exception
	{		
		settings.clickOnSettings();
		settings.clickOnPatron();
		settings.enterCheckoutsPerPatron();
		settings.enterHoldsPerPatron();
		settings.enterMonthlySuggestionsPerPatron();
		settings.enterHoldQueueReservations();
		settings.enterDefaultLoanPeriod();
		settings.clickUpdate();
		settings.clickNo();
		settings.clickUpdate();
	}
	
	@Test
	public void verifyLibraryStaffSettings() throws Exception
	{		
		settings.clickOnSettings();
		settings.clickOnLibraryStaff();
		settings.clickOnAddUser();
		settings.enterEmailAddress();
		settings.enterFirstName();
		settings.enterLastName();
		settings.selectLibraryManager();
		settings.selectShelfManager();
		settings.userStatus();
		settings.clickOnAddUserButton();
	}
	
	//@Test -> Need to test
	public void verifyPayPerUse() throws Exception
	{		
		settings.clickOnSettings();
		settings.clickOnPayPerUse();
		settings.enterEbookMonthlyBudget();
		settings.enterMaxTitlePrice();
		settings.enterMaxPatronLimit();
		settings.selectBuyer();
		settings.selectEmailNotification();
		settings.enterPOReference();
		
		settings.enterAudioMonthlyBudget();
		settings.enterAudioMaxTitlePrice();
		settings.enterAudioMaxPatronLimit();
		settings.selectAudioBuyer();
		settings.selectAudioEmailNotification();
		settings.enterAudioPOReference();
	} 
}
