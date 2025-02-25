package Helper;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestExtentReports {
	
	public ExtentSparkReporter htmlReporter; 
	public ExtentReports extent;
	public ExtentTest test;
	
	@BeforeTest
	public void setReport() {
	
		htmlReporter = new ExtentSparkReporter("./reports/extent.html");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("CAT 2.0 Automation Report");
		htmlReporter.config().setReportName("CAT 2.0 Automation Results");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Automation Tester", "Rangarajans");
		extent.setSystemInfo("Build No", "2.92.33.1");
		extent.setSystemInfo("Organization", "OCLC");
		
	}
	
	@AfterTest
	public void endReport() {
		extent.flush();
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
	
	}}


