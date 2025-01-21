package TestCases;

import org.testng.annotations.Test;

import BaseClass.BaseTest;

public class Report_Test extends BaseTest{

	
	@Test
	public void validateReport() throws Exception
	{		
		report.clickOnReports();
		report.verifyOnReportTab();
	}

}
