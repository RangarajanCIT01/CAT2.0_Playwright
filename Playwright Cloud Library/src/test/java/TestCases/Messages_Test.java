package TestCases;



import org.testng.annotations.Test;

import BaseClass.BaseTest;

public class Messages_Test extends BaseTest{

	@Test
	public void verify_AddMessage() throws Exception
	{		
		message.clickOnMessages();
		message.clickbtnNewMessage();
		message.createNewMessage();
		message.deleteMessage();
	}

}
