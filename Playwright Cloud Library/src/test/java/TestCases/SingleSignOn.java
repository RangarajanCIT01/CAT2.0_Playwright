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
		Browser browser = playwright.chromium()
				.launch(new LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(arguments));
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
		Browser browser = playwright.chromium()
				.launch(new LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(arguments));

		BrowserContext brContext = 
				browser.newContext(new Browser.NewContextOptions().setStorageStatePath
						(Paths.get("applogin.json")));
		
		Page page = brContext.newPage();
		page.navigate("https://catqa.yourcloudlibrary.com/cloudLibrary/landing");
		Thread.sleep(4000);
		String txt = "//h1[text()='FEATURED']";
		Assert.assertEquals(txt, "Featured");
		
		
	}
	
	@Test
	public void generateSessionCookies1() throws InterruptedException {
		Playwright playwright = Playwright.create();
		LaunchOptions setHeadless = new BrowserType.LaunchOptions().setHeadless(false);
		BrowserContext context = playwright.chromium().launch(setHeadless)
				.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("applogin.json")));

		Page page = context.newPage();
		page.navigate("https://catqa.yourcloudlibrary.com");

		 page.fill("//input[@name='email']", "uat15mn@yahoo.com");
		 page.fill("//input[@name='password']", "3msuper#");
		 page.click("//button[@class='primary loginButton']");
		 context.storageState(new
		BrowserContext.StorageStateOptions().setPath(Paths.get("applogin.json")));
		Thread.sleep(10000);
		page.close();

	}

	 @Test
	public void useSavedSessionCookies1() throws InterruptedException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext browserContext = browser.newContext();
		Page page = browserContext.newPage();
		browserContext.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("applogin.json")));

		page.navigate("https://catqa.yourcloudlibrary.com");
		Thread.sleep(10000);
		// page.close();

	}

	//@Test
	public void testStorage() {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext browserContext = browser
				.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("appLoginInfo.json")));
		Page page = browserContext.newPage();
		page.navigate("https://catqa.yourcloudlibrary.com");
		page.fill("//input[@name='email']", "uat15mn@yahoo.com");
		page.fill("//input[@name='password']", "3msuper#");
		page.click("//button[@class='primary loginButton']");
		// Get session storage and store as env variable
		String sessionStorage = (String) page.evaluate("JSON.stringify(sessionStorage)");
		System.getenv().put("SESSION_STORAGE", sessionStorage);

		// Set session storage in a new context
		String sessionStorage1 = System.getenv("SESSION_STORAGE");
		browserContext.addInitScript("(storage => {\n" + "  if (window.location.hostname === 'https://catqa.yourcloudlibrary.com') {\n"
				+ "    const entries = JSON.parse(storage);\n"
				+ "     for (const [key, value] of Object.entries(entries)) {\n"
				+ "      window.sessionStorage.setItem(key, value);\n" + "    };\n" + "  }\n" + "})('" + sessionStorage1
				+ "')");
	}
	
	@Test
	public void generateSessionCookies() throws InterruptedException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("appLoginInfo.json")));
		Page page = browserContext.newPage();
		page.navigate("https://pms.congruentindia.com/congruent/login.jsp");
		Thread.sleep(6000);
		//page.fill("//input[@name='login']", "raja.k");
		//page.fill("//input[@id='password']", "Congruent@12345");
		//page.click("//button[@id='login_btn']");
		//browserContext.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("appLoginInfo.json")));
		Thread.sleep(2000);
		page.close();
	}

	//@Test
	public void useSavedSessionCookies() throws InterruptedException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext browserContext = browser.newContext();
		Page page = browserContext.newPage();
		browserContext.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("appLoginInfo.json")));

		page.navigate("https://pms.congruentindia.com/congruent/plm/content/container.jsp");
		Thread.sleep(6000);
		page.close();

	}
	
}
