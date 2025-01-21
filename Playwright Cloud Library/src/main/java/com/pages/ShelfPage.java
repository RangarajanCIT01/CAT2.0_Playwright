package com.pages;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.testng.Assert;
import com.Factory.PlaywrightFactory;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ShelfPage extends PlaywrightFactory {

	public Page page;

	public ShelfPage(Page page) {
		this.page = page;
	}

	public String Shelves = "//span[contains(text(),'Shelves')]";
	public String newShelf = "//button[@class='primary new-cart']";
	public String manualShelf = "//div[contains(text(),'Manual Shelf')]";
	public String automatedShelf = "//div[contains(text(),'Automated Shelf')]";
	public String shelfName = "//div[@class='ant-col ant-col-24']//input[@name='shelveName']";
	public String shelfDescription = "//div[@class='ant-col ant-col-24']//textarea[@name='shelveDescription']";
	public String clickContinue = "//button[@class='medium']";
	public String shelfAddedSuccessfully = "//span[contains(text(),'Shelf Created Successfully')]";
	public String shelfTitleCount = "//span[@class='title-count']";
	public String bookCheckboxForPublish = "//span[@class='ant-checkbox']//input[@class='ant-checkbox-input' and @type='checkbox']";
	public String publish = "//button[@class='primary cancel-button unpublish-button']";
	public String shelfEditedSuccessfully = "//span[contains(text(),'Shelf edited successfully')]";
	public String BookAuthor = "//*[@name='AuthorSearch']";
	public String PublishedWithin = "//div[@class='searchbyDateSelect'][1]//div[@class='ant-select-selector']";
	public String BookFormatopt = "//span[@class='ant-checkbox ant-checkbox-checked']//input[@name='2']";
	public String createShelf = "//*[@class='ant-col ant-col-5 ant-col-order-3 action-button primarySearch']/button";
	public String shelfDeleteButton = "//button[@class='primary confirm-button']";
	public String AllShelves = "//main[@class='ant-layout-content sc-fqkvVR diCcls']";
	public String dltCnfrm = "//button[@class='primary confirm-button']";
	public String LoadingSpinner = "//div[text()='Loading...']";
	public String lblManual = "//button[text()='MANUAL']";
	public String lblAutomated = "//button[text()='AUTOMATED']";
	public String lblDraft = "//button[text()='DRAFT']";
	public String lblLive = "//button[text()='LIVE']";
	public String btnAddItems = "//button[text()='Add Items']";
	public String SelectAll = "//button[@class='secondary']";
	public String btnAddToCart = "//button[text()='Add to Cart']";
	public String btnAddToShelf = "//button[text()='Add to Shelf']";
	public String addToShelfSuccessfully = "//span[contains(text(),'Added successfully.')]";
	public String btnPublish = "//button[text()='Publish']";
	public String lnkback = "//button[text()='< Back']";
	public String autoCreateShelf = "//button[text()='Create Shelf']";

	public void clickOnShelves() throws Exception {
		clickElement(Shelves);
	}

	public void clickOnNewShelve() throws Exception {
		clickElement(newShelf);
	}

	public void manualShelfType() throws Exception {
		clickElement(manualShelf);
	}

	public void enterManualShelfName() throws Exception {
		Map<String, String> testData = readJsonElement("ShelfData.json", "ManualShelf");

		fillText(shelfName, testData.get("ManualShelfName"));
	}

	public void enterManualShelfDescription() throws Exception {
		Map<String, String> testData = readJsonElement("ShelfData.json", "ManualShelf");

		fillText(shelfDescription, testData.get("ManualShelfDescription"));

	}

	public void clickOnContinue() throws IOException, InterruptedException {
		clickElement(clickContinue);

	}

	public void clickOnShelf() throws Exception {

		Map<String, String> testData = readJsonElement("ShelfData.json", "ManualShelf");
		String elementList = "//div[@class='card-titel']//span";
		String Sname = testData.get("ShelfName");

		clickFromList(elementList, Sname);
	}

	public boolean verifyShelfTitle() throws Exception {

		Map<String, String> testData = readJsonElement("ShelfData.json", "ManualShelf");
		String shelftitle = testData.get("ShelfName");
		String ElementList = "//div[@class='card-titel']";

		boolean val = verifyTitleFromList(ElementList, shelftitle);
		return val;
	}

	public void clickOnDeleteShelf() throws Exception {

		Map<String, String> testData = readJsonElement("ShelfData.json", "ManualShelf");
		String shlfName = testData.get("ManualShelfName");
		String deleteShelf = "//span[text()='" + shlfName + "']/following::img[2]";
		clickElement(deleteShelf);
	}

	public void clickOnAutoDeleteShelf() throws Exception {

		Map<String, String> testData = readJsonElement("ShelfData.json", "AutomatedShelf");
		String shlfName = testData.get("AutomatedShelfName");
		String deleteShelf = "//span[text()='" + shlfName + "']/following::img[2]";
		clickElement(deleteShelf);
	}

	public void verifyDeleteConfrm() throws Exception {
		page.click(dltCnfrm);
		Thread.sleep(2000);

	}

	public void selectAllBooks() throws InterruptedException {
		clickElement(SelectAll);
	}

	public void addToShelf() throws Exception {
		clickElement(btnAddToShelf);
	}

	public void clseLftPnlIfExists() throws InterruptedException {

		Locator leftPnlCls = page.locator(SearchPage.leftPnlClse);
		if (leftPnlCls.isVisible()) {

			leftPnlCls.click();
		} else {
			System.out.println("");
		}
	}

	public void verifyShelfCreatedSuccessfully() throws Exception {
		Map<String, String> testData = readJsonElement("ShelfData.json", "ManualShelf");
		String actualMessage = testData.get("ShelfAdded");

		Locator element1 = page.locator(shelfAddedSuccessfully);
		String expectedMessage = element1.textContent();

		boolean val = verifyAssertMessage(expectedMessage, actualMessage);
		Assert.assertTrue(val);
	}

	public void verifyShelfTitleCount() throws Exception {

		Map<String, String> testData = readJsonElement("ShelfData.json", "ManualShelf");
		String CartBookCountShelf = testData.get("bookTitleCountShelf");

		boolean val = verifyCount(shelfTitleCount, CartBookCountShelf);

		Assert.assertTrue(val);
	}

	public void selectBookCheckbox() throws Exception {
		page.locator(bookCheckboxForPublish).first().dispatchEvent("click");
	}

	public void clickPublish() throws Exception {
		clickElement(publish);
	}

	public boolean verifyShelfPublishedSuccessfully() throws Exception {
		Map<String, String> testData = readJsonElement("ShelfData.json", "ManualShelf");
		String actualMessage = testData.get("ShelfEdited");

		Locator element1 = page.locator(shelfAddedSuccessfully);
		String expectedMessage = element1.textContent();

		boolean val = verifyAssertMessage(expectedMessage, actualMessage);
		return val;
	}

	public void shelfTypeAutomated() throws Exception {
		clickElement(automatedShelf);
	}

	public void enterAutomatedShelfName() throws Exception {
		Map<String, String> testData = readJsonElement("ShelfData.json", "AutomatedShelf");
		fillText(shelfName, testData.get("AutomatedShelfName"));
	}

	public void enterAutomatedShelfDescription() throws Exception {
		Map<String, String> testData = readJsonElement("ShelfData.json", "AutomatedShelf");
		fillText(shelfDescription, testData.get("AutoShelfDescription"));
	}

	public void enterAuthor() throws Exception {
		Map<String, String> testData = readJsonElement("ShelfData.json", "AutomatedShelf");
		fillText(BookAuthor, testData.get("Author"));
	}

	public void publishedWithin() throws InterruptedException {
		selectDropdown(PublishedWithin, 2);

	}

	public void bookFormats() throws InterruptedException {
		// SelectCheckbox(BookFormatopt);

	}

	public void clickCreateShelfButton() throws InterruptedException {
		clickElement(createShelf);
	}

	public void loadResult() {
		String LoadingSpinner = "//div[text()='Loading...']";
		waitForVisibilityOfHidden(LoadingSpinner);
		untilDomContentLoads();
		untilDefaultLoadStateCompletes();
	}

}
