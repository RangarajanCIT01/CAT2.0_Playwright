package com.pages;

import java.util.Map;

import com.Factory.PlaywrightFactory;
import com.microsoft.playwright.Page;

public class SettingsPage extends PlaywrightFactory {
	
	// References
	private Page page;
		
	// String Locators -Object Repository -OR
	private String Settings="//span[@class='settingsBtn']";
	private String SupportEmailEdit="//button[@class='primary mark-ready-button']";
	private String EnterSupportEmail="//input[@name='SupportEmail']";
	private String SaveButton="//button[@class='primary confirm-button']";
	private String EnterLibraryWebsite="//input[@name='LibraryWebsite']";
	private String LanguageDropdown="//span[@class='ant-select-selection-item']";
	private String LanguageElementList="//div[@class='ant-select-item-option-content']";
	
	//PatronTab 
	private String PatronTab="//div[@role='tab' and contains(text(),'Patron')]";
	private String CheckoutsPerPatron="//input[@name='MaxLoanedDocuments']";
	private String HoldsPerPatron="//input[@name='MaxHeldDocuments']";
	private String MonthlySuggestions="//input[@name='MaxPatronWishes']";
	private String HoldQueueReservations="//input[@name='MaxHoldTimeDuration']";
	private String DefaultLoanPeriod="//input[@name='MaxLoanTimeDuration']";
	private String Update="//button[@class='primary confirm-button']";
	private String NoButton="//button[@class='smallRed confirm-button']";


	//LibraryStaff
	private String LibraryStaff="//div[contains(text(),'Library Staff')]";
	private String AddUser="//button[@class='secondary cancel-button']";
	private String EmailAddress="//input[@name='EmailAddress']";
	private String FirstName="//input[@name='FirstName']";
	private String LastName="//input[@name='LastName']";
	private String LibraryManager="//span[@class='ant-checkbox']//input[@id='IsLibraryAdmin']";
	private String ShelfManager="//span[@class='ant-checkbox']//input[@id='IsShelfAdmin']";
	private String UserStatus="//span[@class='ant-radio']//input[@value='2']";
	private String AddUserButton="//button[@class='primary confirm-button']";
	
	// Pay per Use- Ebook
	
	private String PayPerUseTab="//div[contains(text(),'Pay Per Use')]";
	private String MonthlyBudget="//input[@name='SpendingLimit']"; // first
	private String MaxTitlePrice="//input[@name='MaxTitlePriceAllowed']"; //first
	private String MaxPatronLimit="//input[@name='MaxPatronLimit']";
	private String BuyerDropdown="//span[@class='ant-select-selection-search']";
	private String BuyerList="//div[@class='ant-select-item-option-content']";
	private String EmailNotificationDropdown="//div[@class='ant-select-selection-overflow']";
	private String EmailList="//div[@class='ant-select-item-option-content']";
	private String POReference="//input[@name='PORefNumber']";
	
	// Pay per Use-  Audio

	
	
	// Page Constructor
	public SettingsPage(Page page)
	{
		this.page=page;
	}
			
	// Page actions /methods
	public void clickOnSettings() throws Exception 
	{
		Thread.sleep(1000);
		clickElement(Settings);
	}
	
	public void clickEditSupportEmail()
	{
		page.locator(SupportEmailEdit).first().click();

	}
		
	public void enterSupportingEmail() throws Exception
	{
		Map<String, String> testData = readJsonElement("SettingsData.json", "settingdetails");
		String support_email=testData.get("Support_Email");

		fillText(EnterSupportEmail,support_email);
		Thread.sleep(2000);
	}
	
	public void clickOnSaveButton() throws Exception 
	{
		clickElement(SaveButton);
		Thread.sleep(8000);
	}
	
	public void clickEditLibraryWebsite()
	{
		page.locator(":nth-match(:text('Edit'), 2)").click();
	}
	
	

	public void enterLibraryWebsite() throws Exception
	{
		Map<String, String> testData = readJsonElement("SettingsData.json", "settingdetails");
		String library_website=testData.get("Library_Website");

		fillText(EnterLibraryWebsite,library_website);
		Thread.sleep(2000);

	}
	
	public void clickDefaultLanguage()
	{
		page.locator(":nth-match(:text('Edit'), 4)").click();
	}
	
	

	public void enterDefaultLanguage() throws Exception
	{
		Map<String, String> testData = readJsonElement("SettingsData.json", "settingdetails");
		String language=testData.get("Language");

		selectDropdownByScrolling(LanguageDropdown,language,LanguageElementList);

	}
	
	// Patron
	
	public void clickOnPatron() throws Exception 
	{
		clickElement(PatronTab);
	}

	public void enterCheckoutsPerPatron() throws Exception
	{
		Map<String, String> testData = readJsonElement("SettingsData.json", "settingdetails");
		String patron_checkouts=testData.get("Patron_Checkouts");

		fillText(CheckoutsPerPatron,patron_checkouts);
		Thread.sleep(1000);
	}
	
	public void enterHoldsPerPatron() throws Exception
	{
		Map<String, String> testData = readJsonElement("SettingsData.json", "settingdetails");
		String patron_holds=testData.get("Patron_HoldsPer");

		fillText(HoldsPerPatron,patron_holds);
		Thread.sleep(1000);
	}
	
	public void enterMonthlySuggestionsPerPatron() throws Exception
	{
		Map<String, String> testData = readJsonElement("SettingsData.json", "settingdetails");
		String patron_monthlySuggestion=testData.get("Patron_MonthlySuggestions");

		fillText(MonthlySuggestions,patron_monthlySuggestion);
		Thread.sleep(1000);
	}
	
	public void enterHoldQueueReservations() throws Exception
	{
		Map<String, String> testData = readJsonElement("SettingsData.json", "settingdetails");
		String patron_holdqueue=testData.get("Patron_HoldQueue");

		fillText(HoldQueueReservations,patron_holdqueue);
		Thread.sleep(1000);
	}
	
	public void enterDefaultLoanPeriod() throws Exception
	{
		Map<String, String> testData = readJsonElement("SettingsData.json", "settingdetails");
		String patron_loanperiod=testData.get("Patron_Loan");

		fillText(DefaultLoanPeriod,patron_loanperiod);
		//Thread.sleep(1000);
	}
	
	
	public void clickNo() throws Exception 
	{	
		//Thread.sleep(1000);
		clickElement(NoButton);
	}
	
	public void clickUpdate() throws Exception 
	{	
		//Thread.sleep(1000);
		clickElement(Update);
	}
	
	// Library Staff
	public void clickOnLibraryStaff() throws Exception 
	{
		clickElement(LibraryStaff);
	}
	
	public void clickOnAddUser() throws Exception 
	{
		clickElement(AddUser);
	}
	
	public void enterEmailAddress() throws Exception
	{
		Map<String, String> testData = readJsonElement("SettingsData.json", "settingdetails");
		String user_email=testData.get("User_Email");

		fillText(EmailAddress,user_email);
		Thread.sleep(1000);
	}
	
	public void enterFirstName() throws Exception
	{
		Map<String, String> testData = readJsonElement("SettingsData.json", "settingdetails");
		String user_firstname=testData.get("User_FirstName");

		fillText(FirstName,user_firstname);
		Thread.sleep(1000);
	}
	
	public void enterLastName() throws Exception
	{
		Map<String, String> testData = readJsonElement("SettingsData.json", "settingdetails");
		String user_lastname=testData.get("User_LastName");

		fillText(LastName,user_lastname);
		Thread.sleep(1000);
	}
	
	
	public void selectLibraryManager() throws Exception
	{
		SelectCheckbox2(LibraryManager);
	}
	
	public void selectShelfManager() throws Exception
	{
		SelectCheckbox2(ShelfManager);
	}
	
	public void userStatus() throws Exception
	{
		SelectCheckbox2(UserStatus);
	}
			
	public void clickOnAddUserButton() throws Exception 
	{
		clickElement(AddUserButton);
	}
	
	public void clickOnPayPerUse() throws Exception 
	{
		Thread.sleep(1000);
		clickElement(PayPerUseTab);
	}
	
	public void enterEbookMonthlyBudget() throws Exception
	{
		Map<String, String> testData = readJsonElement("SettingsData.json", "settingdetails");
		String monthly_budget=testData.get("Ebook_MonthlyBudget");
		
		page.locator(MonthlyBudget).first().fill(monthly_budget);
		Thread.sleep(2000);
	}
	
	public void enterMaxTitlePrice() throws Exception
	{
		Map<String, String> testData = readJsonElement("SettingsData.json", "settingdetails");
		String max_titleprice=testData.get("Ebook_MaxTitlePrice");
		
		page.locator(MaxTitlePrice).first().fill(max_titleprice);
		Thread.sleep(1000);
	}
	
	public void enterMaxPatronLimit() throws Exception
	{
		Map<String, String> testData = readJsonElement("SettingsData.json", "settingdetails");
		String max_patronlimit=testData.get("Ebook_MaxPatronLimit");
		
		page.locator(MaxPatronLimit).first().fill(max_patronlimit);
		Thread.sleep(1000);
	}
	
	public void selectBuyer() throws Exception
	{
		Map<String, String> testData = readJsonElement("SettingsData.json", "settingdetails");
		String max_patronlimit=testData.get("Ebook_MaxPatronLimit");
		
		page.locator(BuyerDropdown).first().click();

		selectDropdownByScrollingCustom(max_patronlimit,BuyerList);
		Thread.sleep(1000);
	}
	
	public void selectEmailNotification() throws Exception
	{
		Map<String, String> testData = readJsonElement("SettingsData.json", "settingdetails");
		String email=testData.get("Ebook_EmailNotification");
		
		page.locator(EmailNotificationDropdown).first().click();
		
		selectDropdownByScrollingCustom(email,EmailList);
		Thread.sleep(1000);
	}
	
	public void enterPOReference() throws Exception
	{
		Map<String, String> testData = readJsonElement("SettingsData.json", "settingdetails");
		String reference=testData.get("Ebook_POReference");
		
		page.locator(POReference).first().fill(reference);
		Thread.sleep(1000);
	}
	
	// Pay per use-Audio
	
	public void enterAudioMonthlyBudget() throws Exception
	{
		Map<String, String> testData = readJsonElement("SettingsData.json", "settingdetails");
		String monthly_budget=testData.get("Audio_MonthlyBudget");
		
		page.locator(MonthlyBudget).nth(-1).fill(monthly_budget);
		Thread.sleep(2000);
	}
	
	public void enterAudioMaxTitlePrice() throws Exception
	{
		Map<String, String> testData = readJsonElement("SettingsData.json", "settingdetails");
		String max_titleprice=testData.get("Audio_MaxTitlePrice");
		
		page.locator(MaxTitlePrice).nth(-1).fill(max_titleprice);
		Thread.sleep(1000);
	}
	
	public void enterAudioMaxPatronLimit() throws Exception
	{
		Map<String, String> testData = readJsonElement("SettingsData.json", "settingdetails");
		String max_patronlimit=testData.get("Audio_MaxPatronLimit");
		
		page.locator(MaxPatronLimit).nth(-1).fill(max_patronlimit);
		Thread.sleep(1000);
	}
	
	public void selectAudioBuyer() throws Exception
	{
		Map<String, String> testData = readJsonElement("SettingsData.json", "settingdetails");
		String max_patronlimit=testData.get("Audio_MaxPatronLimit");
		
		page.locator(BuyerDropdown).nth(-1).click();

		selectDropdownByScrollingCustom(max_patronlimit,BuyerList);
		Thread.sleep(1000);
	}
	
	public void selectAudioEmailNotification() throws Exception
	{
		Map<String, String> testData = readJsonElement("SettingsData.json", "settingdetails");
		String email=testData.get("Audio_EmailNotification");
		
		page.locator(EmailNotificationDropdown).nth(-1).click();
		
		selectDropdownByScrollingCustom(email,EmailList);
		Thread.sleep(1000);
	}
	
	public void enterAudioPOReference() throws Exception
	{
		Map<String, String> testData = readJsonElement("SettingsData.json", "settingdetails");
		String reference=testData.get("Audio_POReference");
		
		page.locator(POReference).nth(-1).fill(reference);
		Thread.sleep(1000);
	}
}
