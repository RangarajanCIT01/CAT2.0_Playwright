package BaseClass;

import java.util.Properties;

import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;

import BaseClass.BaseTest;
import TestCases.Shelves_Test;
import TestPages.CartPage;
import TestPages.CuratedListsPage;
import TestPages.LoginPage;
import TestPages.MessagesPage;
import TestPages.MyCollectionPage;
import TestPages.NotForSalePage;
import TestPages.PatronsPage;
import TestPages.PurchasePage;
import TestPages.ReportsPage;
import TestPages.ReportsPage_QA;
import TestPages.SavedSearchPage;
import TestPages.SearchPage;
import TestPages.SettingsPage;
import TestPages.ShelfPage;
import TestPages.SpotlightPage;

import org.testng.annotations.*;

public class PlaywrightFactory extends BaseTest{

	BaseTest pf;
	public Page page;
	public Properties prop;
	public BaseTest baseTest;
	public LoginPage loginpage;
	public CartPage cartpage;
	public SearchPage searchpage;
	public ShelfPage shelfpage;
	public MyCollectionPage collection;
	
	public SettingsPage settings;
	public PurchasePage purchase;
	public SpotlightPage spotlight;
	public ReportsPage report;
	public SavedSearchPage savesearch;
	public ExtentSparkReporter extentSparkReporter;
	public ExtentReports extentReports;
	public ExtentTest extentTest;
	public ReportsPage_QA reportsPageQA;
	public Shelves_Test shelves;
	public MessagesPage message;
	public PatronsPage patronsPage;
	public CuratedListsPage curatedList;
	public NotForSalePage notForSale;
	
	@BeforeClass
	public void setup() throws Exception {
		pf = new BaseTest();
		prop = pf.init_prop();
		page = pf.initBrowser(prop);

		baseTest = new BaseTest();

		cartpage = new CartPage(page);
		savesearch = new SavedSearchPage(page);
		shelfpage = new ShelfPage(page);
		collection = new MyCollectionPage(page);
		settings = new SettingsPage(page);
		purchase = new PurchasePage(page);
		collection = new MyCollectionPage(page);
		spotlight = new SpotlightPage(page);
		report = new ReportsPage(page);
		savesearch = new SavedSearchPage(page);
		loginpage = new LoginPage(page);
		reportsPageQA = new ReportsPage_QA(page);
		shelves = new Shelves_Test();
		message = new MessagesPage(page);
		patronsPage = new PatronsPage(page);
		curatedList = new CuratedListsPage(page);
		notForSale = new NotForSalePage(page);

		extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//reports//extentReport.html");
		extentReports = new ExtentReports();

		extentReports.attachReporter(extentSparkReporter);
		extentSparkReporter.config().setEncoding("utf-8");
		extentSparkReporter.config().setDocumentTitle("CAT 2.0 Automation Report");
		extentSparkReporter.config().setReportName("CAT 2.0 Automation Results");
		extentSparkReporter.config().setTheme(Theme.STANDARD);

		extentReports.setSystemInfo("Automation Tester", "Rangarajan");
		extentReports.setSystemInfo("Build No", "2.95.17.2");
		extentReports.setSystemInfo("Organization", "OCLC");
	}
	
	@AfterClass
	public void closeBrowser() throws Exception
	{
		pf.browser.close();		
	}

	@BeforeMethod
	public void setReport(ITestResult result) {

		try {
			extentTest = extentReports.createTest(" @ TestCase : " + result.getMethod().getMethodName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void addResult(ITestResult result) {

		String methodName;
		String logText;
		Markup markup;

		try {
			switch (result.getStatus()) {
			case ITestResult.SUCCESS:
				methodName = result.getMethod().getMethodName();
				logText = "Test Case :  " + methodName + " is Passed";
				markup = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
				extentTest.log(Status.PASS, markup);
				break;

			case ITestResult.FAILURE:
				methodName = result.getMethod().getMethodName();
				logText = "Test Case :  " + methodName + " is Failed";
				markup = MarkupHelper.createLabel(logText, ExtentColor.RED);
				extentTest.log(Status.FAIL, markup);
				break;

			case ITestResult.SKIP:
				methodName = result.getMethod().getMethodName();
				logText = "Test Case :  " + methodName + " is Skipped";
				markup = MarkupHelper.createLabel(logText, ExtentColor.ORANGE);
				extentTest.log(Status.SKIP, markup);
				break;

			default:
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterSuite
	public void afterSuiteMethod() {
		extentReports.flush();
	}
}
