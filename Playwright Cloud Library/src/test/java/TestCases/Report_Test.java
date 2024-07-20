package TestCases;

import org.testng.annotations.Test;

import com.base.BaseTest5;

public class Report_Test extends BaseTest5{

	
	@Test
	public void validateReport() throws Exception
	{		
		report.clickOnReports();
		report.verifyOnReportTab();
	}

}
