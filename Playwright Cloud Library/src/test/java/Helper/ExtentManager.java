package Helper;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    private static ExtentReports extent;

    private static String reportFileName = "Test-Automaton-Report"+".html";
    private static String fileSeperator = System.getProperty("file.separator");
    private static String reportFilepath = System.getProperty("user.dir") +fileSeperator+ "TestReport";
    private static String reportFileLocation =  reportFilepath +fileSeperator+ reportFileName;
  
 
    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance();
        return extent;
    }
 
    public static ExtentReports createInstance() {
        String fileName = getReportPath(reportFilepath);
                       
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
 
        try {
			Properties prop = new Efficacies().loadPropertiesFromResources("config.properties");
			extent.setSystemInfo("Server", prop.getProperty("Environment"));
			extent.setSystemInfo("Browser", prop.getProperty("Browser"));
			extent.setSystemInfo("CAT Build ", prop.getProperty("CAT_AppVer"));
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
        htmlReporter.config().setDocumentTitle("CloudLibrary Automation");
        htmlReporter.config().setReportName("CloudLibrary Automation");
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		 
        return extent;
    }

    private static String getReportPath (String path) {
    	File testDirectory = new File(path);
        if (!testDirectory.exists()) {
        	if (testDirectory.mkdir()) {
                System.out.println("Directory: " + path + " is created!" );
                return reportFileLocation;
            } else {
                System.out.println("Failed to create directory: " + path);
                return System.getProperty("user.dir");
            }
        } else {
            System.out.println("Directory already exists: " + path);
        }
		return reportFileLocation;
    }

 
}
