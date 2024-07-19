package com.base;


import java.util.Properties;
import java.util.logging.Logger;

import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.Factory.PlaywrightFactory;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import com.aventstack.extentreports.reporter.configuration.Theme;
import com.microsoft.playwright.Page;
import com.pages.CartPage;
//import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.MyCollectionPage;
import com.pages.PurchasePage;
import com.pages.ReportsPage;
import com.pages.SaveSearchPage;
import com.pages.SearchPage;
import com.pages.SettingsPage;
import com.pages.Shelf;
import com.pages.SpotlightPage;

public class BaseTest2{
	
	//create references
	PlaywrightFactory pf;
	public Page page;
	public Properties prop;
	//public static ExtentHtmlReporter htmlReporter;
	public PlaywrightFactory playwrightFactory;
	//public static ExtentReports extent;
	//public static ExtentTest test;
	public static ExtentTest logger;
	public LoginPage loginpage;
	public CartPage cartpage;
	public SearchPage searchpage;
	public Shelf shelfpage;
	public MyCollectionPage collection;
	public SettingsPage settings;
	public PurchasePage purchase;
	public SpotlightPage spotlight;
	public ReportsPage report;
	public SaveSearchPage savesearch;
	
	
	//public ExtentSparkReporter htmlReporter; // Create HTML file and add configuration
	public ExtentReports extent; //Attaching Report, Crating test cases and other system configuration
	public ExtentTest test; //maintaining the test cases, adding logs status
	
	@BeforeTest
	public void setReport() {
	
		/*
		htmlReporter = new ExtentSparkReporter("./reports/extent.html");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("CAT 2.0 Automation Report");
		htmlReporter.config().setReportName("CAT 2.0 Automation Results");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Automation Tester", "Rangarajan");
		extent.setSystemInfo("Build No", "2.92.33.1");
		extent.setSystemInfo("Organization", "OCLC"); */
		
	}
	
	@AfterMethod
	public void updateResults(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE) {
			String methodName = result.getMethod().getMethodName();
			Markup m = MarkupHelper.createLabel("Test Case Failed: " + methodName.toUpperCase(), ExtentColor.RED);
			test.fail(m);
		
	} else if(result.getStatus()==ITestResult.SUCCESS) {
		String methodName = result.getMethod().getMethodName();
		Markup m = MarkupHelper.createLabel("Test Case Pass: "+ methodName.toUpperCase(), ExtentColor.GREEN);
		test.fail(m);
		
	} else if(result.getStatus()==ITestResult.SKIP) {
		String methodName = result.getMethod().getMethodName();
		Markup m = MarkupHelper.createLabel("Test Case Skipped: "+ methodName.toUpperCase(), ExtentColor.GREY);
		test.fail(m);
	}
	
	}
	
	@BeforeSuite
	public void setup() throws Exception
	{	
		pf=new PlaywrightFactory();
		prop=pf.init_prop();
		page=pf.initBrowser(prop);
		
		playwrightFactory = new PlaywrightFactory();
		
		cartpage=new CartPage(page);
		searchpage=new SearchPage(page);
		savesearch=new SaveSearchPage(page);
		shelfpage=new Shelf(page);
		collection=new MyCollectionPage(page);
		settings=new SettingsPage(page);
		purchase=new PurchasePage(page);
		collection=new MyCollectionPage(page);
		spotlight=new SpotlightPage(page);
		report=new ReportsPage(page);
		loginpage=new LoginPage(page);
		

	}
	
	/*@BeforeClass
	public void createExtentReport() {

		try {
			htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "//reports//TestReport.html");
			htmlReporter.config().setDocumentTitle("Automation Test Report");
			htmlReporter.config().setReportName("Test Results");
			htmlReporter.config().setTheme(Theme.STANDARD);
			//htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
			htmlReporter.setAppendExisting(false);
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	//@BeforeMethod
	public void setReport(ITestResult result) {

		try {
			test = extent.createTest(" @ TestCase : " + result.getMethod().getMethodName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//@AfterMethod
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
				test.log(Status.PASS, markup);
				break;

			case ITestResult.FAILURE:
				methodName = result.getMethod().getMethodName();
				logText = "Test Case :  " + methodName + " is Failed";
				markup = MarkupHelper.createLabel(logText, ExtentColor.RED);
				test.log(Status.FAIL, markup);
				break;

			case ITestResult.SKIP:
				methodName = result.getMethod().getMethodName();
				logText = "Test Case :  " + methodName + " is Skipped";
				markup = MarkupHelper.createLabel(logText, ExtentColor.ORANGE);
				test.log(Status.SKIP, markup);
				break;

			default:
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/*@BeforeClass(enabled = true)
	public void createExtentReport() {
		
		//Logger log1 = (Logger) LogManager.getLogger(TestLogs.class.getName());
		//Logger log = Logger.getLogger(BaseTest.class);
		//PropertyConfigurator.configure("./src/test/resource/config/log4j.properties");

		try {
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"//TestReport.html");
	        extent = new ExtentReports();
	        extent.attachReporter(sparkReporter);
			test.log(Status.INFO, "Additional information about the test");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//log.info("Class executed");
	}*/
	
	
	public void waitElement(int num) throws Exception {
		
		Thread.sleep(1000 * num);
	}
	
//	@AfterMethod
	public void myres(ITestResult result) {

		
	}

	//@AfterClass
	public void deleteData() throws Exception
	{
		cartpage.navigateCartPage();
		cartpage.clickOnCartTitle();
		cartpage.clickOnDeleteCart();
	}
	
	//@AfterSuite
	public void tearDown()
	{
		//
	}

}
