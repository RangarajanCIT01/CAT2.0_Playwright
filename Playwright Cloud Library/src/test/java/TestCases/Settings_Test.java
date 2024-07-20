package TestCases;

import org.testng.annotations.Test;

import com.base.BaseTest5;

public class Settings_Test extends BaseTest5{

	
	@Test
	public void verifyLibrarySettings() throws Exception
	{		
		settings.clickOnSettings();
		settings.clickEditSupportEmail();
		settings.enterSupportingEmail();
		settings.clickOnSaveButton();
		
		settings.clickEditLibraryWebsite();
		settings.enterLibraryWebsite();
		settings.clickOnSaveButton();
		
		settings.clickDefaultLanguage();
		settings.enterDefaultLanguage();
		settings.clickOnSaveButton();
	}
	
	

	@Test(dependsOnMethods="verifyLibrarySettings")
	public void verifyPatronSettings() throws Exception
	{		
		//settings.clickOnSettings();
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
