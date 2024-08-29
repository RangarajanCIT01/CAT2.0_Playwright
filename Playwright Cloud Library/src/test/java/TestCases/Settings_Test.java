package TestCases;

import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.MyCollectionPage;
import com.pages.SearchPage;

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
	
	@Test(dependsOnMethods="verifyLibrarySettings")
	public void verifyPatronSettings() throws Exception
	{		
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
	
	@Test(dependsOnMethods="verifyPatronSettings")
	public void verifyLibraryStaffSettings() throws Exception
	{		
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
	
	@Test(dependsOnMethods="verifyLibraryStaffSettings")
	public void verifyParPerUse() throws Exception
	{		
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
