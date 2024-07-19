package com.api.test;

import java.io.IOException;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;

public class GetAPICall {
	
	// References
	
	Playwright playwright;
	APIRequest request;
	APIRequestContext requestContext;
	
	@BeforeTest
	public void setUp()
	{
		// Playwright instance
		 playwright=Playwright.create();
				
		//to create http request-- It will return APIRequest reference
		 request=playwright.request();
				
		// API request context
		 requestContext =request.newContext();	
	}
	
	@Test
	public void getAPITest() throws IOException {
		
		//Call API methods
		APIResponse apiResponse=requestContext.get("https://gorest.co.in/public/v2/users");
		
		System.out.println("\n---------------------------------------------------------");
		// API URL
		String URL=apiResponse.url();
		System.out.println("\nAPI URL : "+URL+"\n");
		
		//Status code 
		int statusCode=apiResponse.status();
		System.out.println("\nResponse Status Code : "+statusCode+"\n");
		Assert.assertEquals(statusCode, 200);
		
		String statusResText=apiResponse.statusText();
		System.out.println("\nStatus Response Text : "+statusResText+"\n");
		
		// Headers
		Map<String,String> headersMap=apiResponse.headers();
		System.out.println("\nAPI Headers : "+headersMap+"\n");
		Assert.assertEquals(headersMap.get("content-type"),"application/json; charset=utf-8");
		
		// Response body
		ObjectMapper objectMapper=new ObjectMapper();
		JsonNode jsonResponse=objectMapper.readTree(apiResponse.body());
		String response=jsonResponse.toPrettyString();
		System.out.println("\nResponse body : "+response+"\n");
		
		System.out.println("\n---------------------------------------------------------");
	}
	
	@Test
	public void queryParameterAPITest() throws IOException
	{	
		APIResponse apiResponse=requestContext.get("https://gorest.co.in/public/v2/users",
				RequestOptions.create()
					.setQueryParam("gender","male")
					.setQueryParam("status", "inactive"));
		
		System.out.println("\n---------------------------------------------------------");
		
		//Status code 
		int statusCode=apiResponse.status();
		System.out.println("\nResponse Status Code : "+statusCode+"\n");
		Assert.assertEquals(statusCode, 200);
		
		// Response body
		ObjectMapper objectMapper=new ObjectMapper();
		JsonNode jsonResponse=objectMapper.readTree(apiResponse.body());
		String response=jsonResponse.toPrettyString();
		System.out.println("\nResponse body : "+response+"\n");
				
		System.out.println("\n---------------------------------------------------------");
		
	}
	
	@AfterTest
	public void tearDown()
	{
		playwright.close();
	}
}
