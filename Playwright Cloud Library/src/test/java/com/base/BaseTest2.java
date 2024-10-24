package com.base;


import java.util.Properties;

import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.Factory.PlaywrightFactory;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.microsoft.playwright.Page;
import com.pages.CartPage;
import com.pages.LoginPage;
import com.pages.MyCollectionPage;
import com.pages.PurchasePage;
import com.pages.ReportsPage;
import com.pages.SavedSearchPage;
import com.pages.SearchPage;
import com.pages.SettingsPage;
import com.pages.Shelf;
import com.pages.SpotlightPage;
import org.testng.annotations.*;

public class BaseTest2{

	PlaywrightFactory pf;
	public Page page;
	public Properties prop;
	public PlaywrightFactory playwrightFactory;
	public LoginPage loginpage;
	public CartPage cartpage;
	public SearchPage searchpage;
	public Shelf shelfpage;
	public MyCollectionPage collection;
	public SettingsPage settings;
	public PurchasePage purchase;
	public SpotlightPage spotlight;
	public ReportsPage report;
	public SavedSearchPage savesearch;
	public ExtentSparkReporter extentSparkReporter; 
	public ExtentReports extentReports; 
	public ExtentTest extentTest; 
	
	@BeforeSuite
	public void setup() throws Exception
	{	
		pf=new PlaywrightFactory();
		prop=pf.init_prop();
		page=pf.initBrowser(prop);
		
		playwrightFactory = new PlaywrightFactory();
		
		cartpage=new CartPage(page);
		savesearch=new SavedSearchPage(page);
		shelfpage=new Shelf(page);
		collection=new MyCollectionPage(page);
		settings=new SettingsPage(page);
		purchase=new PurchasePage(page);
		collection=new MyCollectionPage(page);
		spotlight=new SpotlightPage(page);
		report=new ReportsPage(page);
		loginpage=new LoginPage(page);
				
		}
	
	   @BeforeClass
	   public void startReporter()
	   {
		   extentSparkReporter  = new ExtentSparkReporter(System.getProperty("user.dir") + "//reports//extentReport.html");
		   extentReports = new ExtentReports();
		 
	       extentReports.attachReporter(extentSparkReporter);
	       extentSparkReporter.config().setEncoding("utf-8");
	       extentSparkReporter.config().setDocumentTitle("CAT 2.0 Automation Report");
	       extentSparkReporter.config().setReportName("CAT 2.0 Automation Results");
	       extentSparkReporter.config().setTheme(Theme.STANDARD);
			
	       extentReports.setSystemInfo("Automation Tester", "Rangarajan");
	       extentReports.setSystemInfo("Build No", "2.92.33.1");
	       extentReports.setSystemInfo("Organization", "OCLC");
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
