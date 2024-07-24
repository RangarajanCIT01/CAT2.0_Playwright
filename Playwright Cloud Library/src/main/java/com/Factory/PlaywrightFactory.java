package com.Factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Random;

import java.util.regex.Pattern;

import javax.print.attribute.SetOfIntegerSyntax;

import java.util.Map.Entry;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.apache.logging.log4j.LogManager;
//import org.testng.log4testng.Logger;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.ElementHandle;

import baseClass.TestLog4J2;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;
import com.pages.LoginPage;
import com.pages.SearchPage;

public class PlaywrightFactory {

	// References
	Playwright playwright;
	Browser browser;
	BrowserContext browserContext;
	public static Page page;
	Properties prop;
	// public static ExtentHtmlReporter htmlReporter;
	// public static ExtentReports extent;
	// public static ExtentTest test;
	// public static org.apache.logging.log4j.Logger log;
	public static Logger log;
	public static String cartname;
	public static String cartname2;
	protected LoginPage loginpage;

	public PlaywrightFactory() {

	}

	public Page initBrowser(Properties prop) throws Exception {
		loginpage = new LoginPage(page);
		String browserName = prop.getProperty("browser").trim();

		playwright = Playwright.create();
		ArrayList<String> arguments = new ArrayList<>();
		arguments.add("--start-maximized");

		switch (browserName.toLowerCase()) {
		case "chrome":
			browser = playwright.chromium()
					.launch(new LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(arguments));
			browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
			break;

		case "firefox":
			browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;

		case "safari":
			browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;

		default:
			break;
		}

		// browserContext=browser.newContext(new
		// Browser.NewContextOptions().setViewportSize(1255,625));

		browserContext.tracing()
				.start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true).setSources(true));
		browserContext.clearCookies();

		page = browserContext.newPage();

		page.navigate(prop.getProperty("url"));
		page.waitForLoadState();
		loginpage.enterUserName(prop.getProperty("username"));
		loginpage.enterPassword(prop.getProperty("password"));
		loginpage.clickLogin();

		return page;
	}

	public Properties init_prop() throws FileNotFoundException {
		log = Logger.getLogger(PlaywrightFactory.class);
		// Logger log = LogManager.getLogger(TestLog4J2.class.getName());
		// log = LogManager.getLogger(PlaywrightFactory.class);
		// log = LogManager.getLogger(TestLog4J2.class.getName());

		PropertyConfigurator.configure("./src/test/resource/config/log4j.properties");

		FileInputStream ip = new FileInputStream("./src/test/resource/config/config.properties");

		prop = new Properties();
		try {
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}

	public void clickElement(String locator) {
		try {
			page.locator(locator).click();
			// log.info("'" + locator + "' is clicked");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public String createRandomName() {
		String name = "AddBooksCart";
		Random random = new Random();
		int randomNumber = random.nextInt(100);

		cartname = name + randomNumber;

		return cartname;
	}

	public void fillText(String locator, String text) {
		try {
			page.locator(locator).fill(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doubleClick(String locator) {

		try {
			page.locator(locator).dblclick();
			log.info("'" + locator + "' is double clicked");
		} catch (Exception e) {
			log.error("Failed to double click on '" + locator + "'");
			e.printStackTrace();
		}
	}

	public void hover(String locator) {

		page.locator(locator).hover();
	}

	public void clickOption(String option) {

		page.getByText(option).click();
	}

	public void keyPress(String key) {
		page.keyboard().press(key);
	}

	public void keyType(String key) {
		page.keyboard().type(key);
	}

	public void waitForVisibilityOf(String locator) {		
		page.waitForSelector(locator, new Page.WaitForSelectorOptions().setState(WaitForSelectorState.VISIBLE));
	}
	
	public void waitForVisibilityOfHidden(String locator) {
		untilDomContentLoads();		
		page.waitForSelector(locator, new Page.WaitForSelectorOptions().setState(WaitForSelectorState.HIDDEN));
	}
	
	public void waitForVisibilityOfTimeout(String locator, int value) {
		//untilDomContentLoads();		
		page.waitForSelector(locator, new Page.WaitForSelectorOptions().setTimeout(value));
	}
	
	private Locator waitForElement(Locator locator, boolean isVisible) {
	    WaitForSelectorState visibilityName = isVisible ? WaitForSelectorState.VISIBLE : WaitForSelectorState.HIDDEN;
	    locator.waitFor(new Locator.WaitForOptions().setState(visibilityName));
	    return locator;
	}

	public void untilElementHidden(Locator locator) {
		waitForElement(locator, false);
	}

	public void untilLoadEventCompletes() {
		page.waitForLoadState(LoadState.LOAD);
	}

	public void untilDomContentLoads() {
		page.waitForLoadState(LoadState.DOMCONTENTLOADED);
	}

	public void untilNetworkEventCompletes() {
		page.waitForLoadState(LoadState.NETWORKIDLE);
	}

	public void untilDefaultLoadStateCompletes() {
		page.waitForLoadState();
	}

	public void clickFromList(String elementList1, String title) throws InterruptedException {

		Thread.sleep(3000);
		try {
			Locator elements = page.locator(elementList1);

			int i;
			for (i = 0; i < elements.count(); i++) {
				if (elements.nth(i).textContent().equals(title)) {
					elements.nth(i).click();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void navigateBackToSearch(String elementList) throws InterruptedException {

		page.waitForSelector(elementList);

		try {
			Locator elements = page.locator(elementList);

			for (int i = 0; i < elements.count(); i++) {
				if (elements.nth(i).isVisible()) {
					Thread.sleep(6000);
					elements.nth(i).click();
					break;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void deleteFromList(String elementList1, String elementList2, String title, String button) {
		try {
			Locator eleliist1 = page.locator(elementList1);
			Locator eleliist2 = page.locator(elementList2);

			int i;
			for (i = 0; i < eleliist1.count(); i++) {
				if (eleliist1.nth(i).textContent().equals(title)) {
					eleliist2.nth(i).click();
					page.locator(button).click();
					Thread.sleep(2000);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void editFromList(String elementList1, String elementList2, String title) {
		try {
			Locator eleliist1 = page.locator(elementList1);
			Locator eleliist2 = page.locator(elementList2);
			Thread.sleep(2000);

			int i;
			for (i = 0; i < eleliist1.count(); i++) {
				if (eleliist1.nth(i).textContent().equals(title)) {
					eleliist2.nth(i).dispatchEvent("click");
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean verifyCount(String CountElement, String CountText) {
		boolean result = false;

		Locator element = page.locator(CountElement);
		if (element.textContent().equalsIgnoreCase(CountText)) {
			result = true;
		}
		return result;
	}

	public void selectDropdownByScrolling(String Element, String option, String elementList)
			throws InterruptedException {
		Thread.sleep(2000);
		try {

			page.locator(Element).click();

			Locator elementlist = page.locator(elementList);
			for (int i = 0; i < elementlist.count(); i++) {
				if (elementlist.nth(i).textContent().contains(option)) {
					elementlist.nth(i).click();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectDropdownSpecificSearch(String Element, String option, String elementList)
			throws InterruptedException {
		try {

			page.locator(Element).click();

			Locator elementlist = page.locator(elementList);
			for (int i = 0; i < elementlist.count(); i++) {
				if (elementlist.nth(i).textContent().contains(option)) {
					elementlist.nth(i).click();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void selectDropdownByScrollingFirst(String Element, String option, String elementList) {
		try {
			// page.locator(Element).dispatchEvent("click");
			page.locator(Element).click();
			Thread.sleep(2000);

			Locator elementlist = page.locator(elementList);
			for (int i = 0; i < elementlist.count(); i++) {
				if (elementlist.nth(i).textContent().contains(option)) {
					elementlist.nth(i).click();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void selectDropdownForFirstElement(String Element, String option, String elementList) {
		try {

			page.locator(Element).click();

			page.waitForSelector(".ant-select-item-option-content");
			List<ElementHandle> dropdownOptions = page.querySelectorAll(".ant-select-item-option-content");

			for (ElementHandle option1 : dropdownOptions) {
				page.keyboard().down("ArrowDown");
				System.out.println("Option Values" + option1.textContent());
				if (option1.textContent().equals(option)) {
					System.out.println("In Click.........");
					option1.click();
					Thread.sleep(1000);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void selectDropdownForOtherElements(String Element, String option, String elementList) {
		try {

			page.locator(Element).click();

			Locator elementlist = page.locator(elementList);
			System.out.println("Count of list ele : " + elementlist.count());
			Thread.sleep(1000);

			for (int i = 0; i < elementlist.count(); i++) {
				page.keyboard().down("ArrowDown");
				Thread.sleep(1000);
				if (elementlist.nth(i).textContent().contains(option)) {
					elementlist.nth(i).click();
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void selectDropdownByScrollingCustom(String option, String elementList) {
		try {
			Locator elementlist = page.locator(elementList);
			for (int i = 0; i < elementlist.count(); i++) {
				if (elementlist.nth(i).textContent().contains(option)) {
					elementlist.nth(i).click();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void selectDropdown(String Element, int pos) {
		try {

			page.locator(Element).click();

			Thread.sleep(1000);

			for (int i = 0; i < pos; i++) {
				page.keyboard().down("ArrowDown");
			}
			Thread.sleep(1000);
			page.keyboard().press("Enter");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void SelectCheckbox(String ElementList, String option) {
		page.locator(ElementList).click();
	}

	public static void SelectCheckbox2(String Element) {
		page.locator(Element).click();
	}

	public static boolean verifyTitleFromList(String elementList1, String title) throws InterruptedException {
		Thread.sleep(1000);
		Locator elements = page.locator(elementList1);
		boolean result = false;

		for (int i = 0; i < elements.count(); i++) {
			if (elements.nth(i).textContent().equals(title)) {
				elements.nth(i);
				result = true;
				break;
			}
		}
		return result;
	}

	public static boolean compareList(String elementList1, List<String> elementList2) {
		Locator elements = page.locator(elementList1);

		// Create a locator for the element list
		Locator locator = page.locator(elementList1);

		// Get the values of the element list
		List<String> elementList = locator.allTextContents();

		System.out.println("elementList-------------" + elementList);
		System.out.println("elementList2-------------" + elementList2);

		// Compare the two lists
		boolean isEqual = elementList2.equals(elementList);
		System.out.println("The two lists are equal: " + isEqual);

		return isEqual;

	}

	public static boolean compare(String elementList1, List<String> elementList2) {
		boolean result = false;
		Locator elements = page.locator(elementList1);

		Locator locator = page.locator(elementList1);

		List<String> elementList = locator.allTextContents();

		System.out.println("elementList-------------" + elementList);
		System.out.println("elementList2-------------" + elementList2);

		for (Locator element : locator.all()) {
			String value = element.textContent();
			System.out.println("Value " + value);

			result = elementList2.contains(value);
		}
		return result;
	}
	
	public void clickIfExists()
	{
		Locator leftPnlCls = page.locator(SearchPage.leftPnlClse);
		if( leftPnlCls.isVisible()) {
		
			leftPnlCls.click();
			
		} else{
			System.out.println("");
		}
			
	}
		

	public static boolean verifyAssertMessage(String expectedMessage, String actualMessage) {
		boolean result = false;

		if (expectedMessage.equalsIgnoreCase(actualMessage)) {
			result = true;
		}
		return result;
	}

	public void waitForElement(int num) {
		try {
			Thread.sleep(1000 * num);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Map<String, String> readJsonElement(String fileName, String elementName) throws Exception {
		String filePath = null;

		filePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator
				+ "resource" + File.separator + "TestData" + File.separator + fileName;
		// System.out.println("-----------Filepath---"+filePath);

		JsonElement root = (new JsonParser()).parse(new FileReader(filePath));
		JsonObject jsonObject = root.getAsJsonObject();
		JsonElement some = jsonObject.get(elementName);
		JsonObject testData = some.getAsJsonObject();
		Map<String, String> testDataMap = new HashMap();
		Iterator var = testData.entrySet().iterator();

		while (var.hasNext()) {
			Entry<String, JsonElement> entry = (Entry) var.next();
			testDataMap.put(((String) entry.getKey()).toString(), ((JsonElement) entry.getValue()).getAsString());
		}

		return testDataMap;
	}

}
