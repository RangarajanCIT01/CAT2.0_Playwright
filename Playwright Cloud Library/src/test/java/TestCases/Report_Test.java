package TestCases;

import org.testng.annotations.Test;

import BaseClass.PlaywrightFactory;

public class Report_Test extends PlaywrightFactory{

	
	@Test
	public void validateReport() throws Exception
	{		
		report.clickOnReports();
		report.verifyOnReportTab();
	}

}
