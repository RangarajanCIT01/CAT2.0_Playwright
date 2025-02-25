package TestCases;



import org.testng.annotations.Test;

import BaseClass.PlaywrightFactory;

public class Messages_Test extends PlaywrightFactory{

	@Test
	public void verify_AddMessage() throws Exception
	{		
		message.clickOnMessages();
		message.clickbtnNewMessage();
		message.createNewMessage();
		message.deleteMessage();
	}

}
