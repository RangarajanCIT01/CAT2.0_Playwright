package TestPages;

import java.util.Map;

import com.microsoft.playwright.Page;

import BaseClass.PlaywrightFactory;

public class SettingsPage extends PlaywrightFactory {
	
	// References
	public Page page;
		
	// String Locators -Object Repository -OR
	public String Settings="//span[@class='settingsBtn']";
	public String SupportEmailEdit="//button[@class='primary mark-ready-button']";
	public String EnterSupportEmail="//input[@name='SupportEmail']";
	public String SaveButton="//button[@class='primary confirm-button']";
	public String EnterLibraryWebsite="//input[@name='LibraryWebsite']";
	public String LanguageDropdown="//span[@class='ant-select-selection-item']";
	public String LanguageElementList="//div[@class='ant-select-item-option-content']";
	public String edtLanguage = "//h4[text()='Default Language']//following::button[text()='Edit'][1]";
	
	//PatronTab 
	public String PatronTab="//div[@role='tab' and contains(text(),'Patron')]";
	public String CheckoutsPerPatron="//input[@name='MaxLoanedDocuments']";
	public String HoldsPerPatron="//input[@name='MaxHeldDocuments']";
	public String MonthlySuggestions="//input[@name='MaxPatronWishes']";
	public String HoldQueueReservations="//input[@name='MaxHoldTimeDuration']";
	public String DefaultLoanPeriod="//input[@name='MaxLoanTimeDuration']";
	public String Update="//button[@class='primary confirm-button']";
	public String NoButton="//button[@class='smallRed confirm-button']";

	//LibraryStaff
	public String LibraryStaff="//div[contains(text(),'Library Staff')]";
	public String AddUser="//button[@class='secondary cancel-button']";
	public String EmailAddress="//input[@name='EmailAddress']";
	public String FirstName="//input[@name='FirstName']";
	public String LastName="//input[@name='LastName']";
	public String LibraryManager="//span[@class='ant-checkbox']//input[@id='IsLibraryAdmin']";
	public String ShelfManager="//span[@class='ant-checkbox']//input[@id='IsShelfAdmin']";
	public String UserStatus="//span[@class='ant-radio']//input[@value='2']";
	public String AddUserButton="//button[@class='primary confirm-button']";
	
	// Pay per Use- Ebook
	public String PayPerUseTab="//div[contains(text(),'Pay Per Use')]";
	public String MonthlyBudget="//input[@name='SpendingLimit']"; // first
	public String MaxTitlePrice="//input[@name='MaxTitlePriceAllowed']"; //first
	public String MaxPatronLimit="//input[@name='MaxPatronLimit']";
	public String BuyerDropdown="//span[@class='ant-select-selection-search']";
	public String BuyerList="//div[@class='ant-select-item-option-content']";
	public String EmailNotificationDropdown="//div[@class='ant-select-selection-overflow']";
	public String EmailList="//div[@class='ant-select-item-option-content']";
	public String POReference="//input[@name='PORefNumber']";
	
	public SettingsPage(Page page)
	{
		this.page=page;
	}
		
	public void clickOnSettings() throws Exception 
	{
		
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
		

	}
	
	public void clickDefaultLanguage(String data) throws InterruptedException
	{
		fillText(edtLanguage,data);
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
		
	}
	
	public void enterHoldsPerPatron() throws Exception
	{
		Map<String, String> testData = readJsonElement("SettingsData.json", "settingdetails");
		String patron_holds=testData.get("Patron_HoldsPer");

		fillText(HoldsPerPatron,patron_holds);
		
	}
	
	public void enterMonthlySuggestionsPerPatron() throws Exception
	{
		Map<String, String> testData = readJsonElement("SettingsData.json", "settingdetails");
		String patron_monthlySuggestion=testData.get("Patron_MonthlySuggestions");

		fillText(MonthlySuggestions,patron_monthlySuggestion);
		
	}
	
	public void enterHoldQueueReservations() throws Exception
	{
		Map<String, String> testData = readJsonElement("SettingsData.json", "settingdetails");
		String patron_holdqueue=testData.get("Patron_HoldQueue");

		fillText(HoldQueueReservations,patron_holdqueue);
		
	}
	
	public void enterDefaultLoanPeriod() throws Exception
	{
		Map<String, String> testData = readJsonElement("SettingsData.json", "settingdetails");
		String patron_loanperiod=testData.get("Patron_Loan");

		fillText(DefaultLoanPeriod,patron_loanperiod);
	}
	
	
	public void clickNo() throws Exception 
	{	
		clickElement(NoButton);
	}
	
	public void clickUpdate() throws Exception 
	{	
		clickElement(Update);
	}
	
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
		
	}
	
	public void enterFirstName() throws Exception
	{
		Map<String, String> testData = readJsonElement("SettingsData.json", "settingdetails");
		String user_firstname=testData.get("User_FirstName");

		fillText(FirstName,user_firstname);
		
	}
	
	public void enterLastName() throws Exception
	{
		Map<String, String> testData = readJsonElement("SettingsData.json", "settingdetails");
		String user_lastname=testData.get("User_LastName");

		fillText(LastName,user_lastname);
		
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
		
		clickElement(PayPerUseTab);
	}
	
	public void enterEbookMonthlyBudget() throws Exception
	{
		Map<String, String> testData = readJsonElement("SettingsData.json", "settingdetails");
		String monthly_budget=testData.get("Ebook_MonthlyBudget");
		
		page.locator(MonthlyBudget).fill(monthly_budget);
		
	}
	
	public void enterMaxTitlePrice() throws Exception
	{
		Map<String, String> testData = readJsonElement("SettingsData.json", "settingdetails");
		String max_titleprice=testData.get("Ebook_MaxTitlePrice");
		
		page.locator(MaxTitlePrice).fill(max_titleprice);
		
	}
	
	public void enterMaxPatronLimit() throws Exception
	{
		Map<String, String> testData = readJsonElement("SettingsData.json", "settingdetails");
		String max_patronlimit=testData.get("Ebook_MaxPatronLimit");
		
		page.locator(MaxPatronLimit).fill(max_patronlimit);
		
	}
	
	public void selectBuyer() throws Exception
	{
		Map<String, String> testData = readJsonElement("SettingsData.json", "settingdetails");
		String max_patronlimit=testData.get("Ebook_MaxPatronLimit");
		
		page.locator(BuyerDropdown).click();

		selectDropdownByScrollingCustom(max_patronlimit,BuyerList);
		
	}
	
	public void selectEmailNotification() throws Exception
	{
		Map<String, String> testData = readJsonElement("SettingsData.json", "settingdetails");
		String email=testData.get("Ebook_EmailNotification");
		
		page.locator(EmailNotificationDropdown).click();
		
		selectDropdownByScrollingCustom(email,EmailList);
		
	}
	
	public void enterPOReference() throws Exception
	{
		Map<String, String> testData = readJsonElement("SettingsData.json", "settingdetails");
		String reference=testData.get("Ebook_POReference");
		
		page.locator(POReference).fill(reference);
		
	}
	
	public void enterAudioMonthlyBudget() throws Exception
	{
		Map<String, String> testData = readJsonElement("SettingsData.json", "settingdetails");
		String monthly_budget=testData.get("Audio_MonthlyBudget");
		
		page.locator(MonthlyBudget).fill(monthly_budget);
		
	}
	
	public void enterAudioMaxTitlePrice() throws Exception
	{
		Map<String, String> testData = readJsonElement("SettingsData.json", "settingdetails");
		String max_titleprice=testData.get("Audio_MaxTitlePrice");
		
		page.locator(MaxTitlePrice).fill(max_titleprice);
		
	}
	
	public void enterAudioMaxPatronLimit() throws Exception
	{
		Map<String, String> testData = readJsonElement("SettingsData.json", "settingdetails");
		String max_patronlimit=testData.get("Audio_MaxPatronLimit");
		
		page.locator(MaxPatronLimit).fill(max_patronlimit);
		
	}
	
	public void selectAudioBuyer() throws Exception
	{
		Map<String, String> testData = readJsonElement("SettingsData.json", "settingdetails");
		String max_patronlimit=testData.get("Audio_MaxPatronLimit");
		
		page.locator(BuyerDropdown).click();

		selectDropdownByScrollingCustom(max_patronlimit,BuyerList);
		
	}
	
	public void selectAudioEmailNotification() throws Exception
	{
		Map<String, String> testData = readJsonElement("SettingsData.json", "settingdetails");
		String email=testData.get("Audio_EmailNotification");
		
		page.locator(EmailNotificationDropdown).click();
		
		selectDropdownByScrollingCustom(email,EmailList);
		
	}
	
	public void enterAudioPOReference() throws Exception
	{
		Map<String, String> testData = readJsonElement("SettingsData.json", "settingdetails");
		String reference=testData.get("Audio_POReference");
		
		page.locator(POReference).fill(reference);
		
	}
}
