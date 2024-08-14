package TestCases;

import org.testng.annotations.Test;

import com.base.BaseTest;

public class Report_Test extends BaseTest{

	
	@Test
	public void validateReport() throws Exception
	{		
		report.clickOnReports();
		report.verifyOnReportTab();
	}

}
