package com.base;


import java.util.Properties;

import org.openqa.selenium.devtools.v111.browser.Browser;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.Factory.PlaywrightFactory;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.microsoft.playwright.Page;
import com.pages.CartPage;
import com.pages.LoginPage;
import com.pages.MyCollectionPage;
import com.pages.PurchasePage;
import com.pages.ReportsPage;
import com.pages.SaveSearchPage;
import com.pages.SearchPage;
import com.pages.SettingsPage;
import com.pages.Shelf;
import com.pages.SpotlightPage;
import org.testng.annotations.*;

public class BaseTest4{

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
	public SaveSearchPage savesearch;
	public ExtentSparkReporter extentSparkReporter; 
	public ExtentReports extentReports; 
	public ExtentTest extentTest; 
	
	@BeforeSuite()
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
	
	   @BeforeClass
	   public void startReporter(ITestResult result)
	   {
	       
		   extentSparkReporter  = new ExtentSparkReporter(System.getProperty("user.dir") + "//reports//extentReport.html");
		   extentReports = new ExtentReports();
		   extentTest = extentReports.createTest(" @ TestCase : " + result.getMethod().getMethodName());
	       extentReports.attachReporter(extentSparkReporter);
 
	       extentSparkReporter.config().setEncoding("utf-8");
	       extentSparkReporter.config().setDocumentTitle("CAT 2.0 Automation Report");
	       extentSparkReporter.config().setReportName("CAT 2.0 Automation Results");
	       extentSparkReporter.config().setTheme(Theme.STANDARD);
			
	       extentReports.setSystemInfo("Automation Tester", "Rangarajan");
	       extentReports.setSystemInfo("Build No", "2.92.33.1");
	       extentReports.setSystemInfo("Organization", "OCLC");
	       
	  
	   }
	  
	 @AfterMethod
	   public void getResult(ITestResult result) {
		 
	       if(result.getStatus() == ITestResult.FAILURE) {
	           extentTest.log(Status.FAIL,result.getTestName());
	       }
	       else if(result.getStatus() == ITestResult.SUCCESS) {
	           extentTest.log(Status.PASS, result.getTestName());
	       }
	       else {
	           extentTest.log(Status.SKIP, result.getTestName());
	       }
	    
	   }
	   


	  @AfterSuite
	  public void afterSuiteMethod() {
		   extentReports.flush();
		  
	  }
	  
	 
	}
