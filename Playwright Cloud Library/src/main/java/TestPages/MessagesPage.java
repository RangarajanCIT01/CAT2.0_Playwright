package TestPages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.testng.Assert;
import org.testng.AssertJUnit;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import PlaywrightFactory.PlaywrightFactory;

public class MessagesPage extends PlaywrightFactory {

	public Page page;

	public String menuMessages = "//span[contains(text(),'Messages')]";
	public String btnNewMessage = "//button[text()='New Message']";
	public String txtSubject = "//input[@placeholder='Subject']";
	public String txtMessage = "//textarea[@placeholder='Message']";
	public String startDate = "//label[text()='Start Date:']/following::input[1]";
	public String endDate = "//label[text()='End Date:']/following::input[1]";
	public String today = "//a[text()='Today']";
	public String endToday = "//label[text()='End Date:']/following::a[2]";
	public String schedule = "//button[text()='Schedule & Send']";
	public String lnkdelete = "//div[text()='First Message']/following::span[text()='Delete']";
	public String btnYes = "//button[text()='Yes']";
	public String txtCreatedMessage = "//span[text()='Message Sent successfully']";
	public String txtDeleteMessage = "//span[text()='Message Deleted successfully']";	
	public String AllMessages = "//div[@class='message-screen']";
	

	public MessagesPage(Page page) {
		this.page = page;
	}

	public void clickOnMessages() throws Exception {
		clickElement(menuMessages);
	}

	public void clickbtnNewMessage() throws IOException, InterruptedException {
		clickElement(btnNewMessage);
	}

	public void createNewMessage() throws Exception {

		Map<String, String> testData = readJsonElement("Messages.json", "Messages");
		    ArrayList<Object> actualData = new ArrayList<>();
		    ArrayList<Object> expectedData = new ArrayList<>();
			
		    waitForElement(2);
			fillText(txtSubject, testData.get("Subject"));
			fillText(txtMessage, testData.get("Message"));
			clickElement(startDate);
			clickElement(today);
			clickElement(endDate);
			clickElement(endToday);
			clickElement(schedule);
						
			actualData.add(page.locator(txtCreatedMessage).textContent());
			expectedData.add(testData.get("CreatedMessage"));
			
			containsVerify(AllMessages, testData.get("Subject"));
			
			AssertJUnit.assertEquals(expectedData, actualData);
	}

	public void deleteMessage() throws Exception {
		Map<String, String> testData = readJsonElement("Messages.json", "Messages");
		
		ArrayList<Object> actualData = new ArrayList<>();
	    ArrayList<Object> expectedData = new ArrayList<>();
		clickElement(lnkdelete);
		clickElement(btnYes);
		
		actualData.add(page.locator(txtDeleteMessage).textContent());
		expectedData.add(testData.get("DeleteMessage"));
				
		AssertJUnit.assertEquals(expectedData, actualData);
	}
	
	public boolean containsVerify(String value, String exp) {
		String loc = page.locator(value).innerText();

		boolean flag = loc.contains(exp);

		if (!flag) {
			Assert.fail();
		}
		return flag;
	}

}
