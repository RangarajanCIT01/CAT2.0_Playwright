package TestCases;

import java.nio.file.Paths;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;

public class SingleSignOn {

	public static void main(String[] args) throws InterruptedException {
		
		Playwright playwright = Playwright.create();
		ArrayList<String> arguments = new ArrayList<>();
		arguments.add("--start-maximized");
		Browser browser = playwright.firefox()
				.launch(new LaunchOptions().setChannel("firefox").setHeadless(false).setArgs(arguments));
		BrowserContext brContext = browser.newContext();
		brContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		
		Page page = brContext.newPage();
		page.navigate("https://catqa.yourcloudlibrary.com");
		Thread.sleep(6000);
		page.fill("//input[@name='email']", "uat15mn@yahoo.com");
		page.fill("//input[@name='password']", "3msuper#");
		page.click("//button[@class='primary loginButton']");
		
		brContext.storageState(new BrowserContext.StorageStateOptions()
				.setPath(Paths.get("applogin.json")));

		Thread.sleep(6000);
		SingleSignOn cls = new SingleSignOn();
		cls.test1();
	}
	
	public void test1() throws InterruptedException {
		Playwright playwright = Playwright.create();
		ArrayList<String> arguments = new ArrayList<>();
		arguments.add("--start-maximized");
		Browser browser = playwright.firefox()
				.launch(new LaunchOptions().setChannel("firefox").setHeadless(false).setArgs(arguments));

		BrowserContext brContext = 
				browser.newContext(new Browser.NewContextOptions().setStorageStatePath
						(Paths.get("applogin.json")));
		
		Page page = brContext.newPage();
		page.navigate("https://catqa.yourcloudlibrary.com/cloudLibrary/landing");
		Thread.sleep(4000);
		String txt = "//h1[text()='FEATURED']";
		Assert.assertEquals(txt, "Featured");
		
		
	}


	
	
}
