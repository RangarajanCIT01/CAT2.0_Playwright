package com.api.test;

import java.io.IOException;
import java.util.HashMap;
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

public class DeleteAPICall {
	
	//
	
	
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
		public void deleteUserTest() throws IOException
		{
			//token
			//6a141a6edbc160b669d12185d3b909f85bcd83328ec1eb6c56f5ac1e71f32572	
			
			Map<String,Object> data=new HashMap<String,Object>();
			data.put("name", "tejashree");
			data.put("email", "teju8.kakade@gmail.com");
			data.put("gender", "female");
			data.put("status", "active");
			
			// Post Call
			APIResponse apiPostResponse=requestContext.post("https://gorest.co.in/public/v2/users",
						RequestOptions.create()
							.setHeader("Content-Type","application/json")
							.setHeader("Authorization","Bearer 6a141a6edbc160b669d12185d3b909f85bcd83328ec1eb6c56f5ac1e71f32572")
							.setData(data));
			
			System.out.println("Status : "+apiPostResponse.status());
			Assert.assertEquals(apiPostResponse.status(), 201);
			
			System.out.println(apiPostResponse.text());
			
			ObjectMapper objectMapper=new ObjectMapper();
			JsonNode postJsonResponse=objectMapper.readTree(apiPostResponse.body());
			
			System.out.println(postJsonResponse.toPrettyString());
			
			// Get User Id
			
			String userId=postJsonResponse.get("id").asText();
			System.out.println("User Id : "+userId);
			
			// Delete user
			APIResponse apiDELETEResponse=requestContext.delete("https://gorest.co.in/public/v2/users/"+userId,
						RequestOptions.create()
						.setHeader("Authorization","Bearer 6a141a6edbc160b669d12185d3b909f85bcd83328ec1eb6c56f5ac1e71f32572")
					
					);
			
			System.out.println("\n---------------------------------------------------------");
			
			System.out.println(apiDELETEResponse.status());
			System.out.println(apiDELETEResponse.statusText());
			
			Assert.assertEquals(apiDELETEResponse.status(),204);
			
			
			System.out.println("Delete user response body : "+apiDELETEResponse.text());
			
			// fetch the same user
			
			APIResponse apiResponse=requestContext.get("https://gorest.co.in/public/v2/users/"+userId,
					RequestOptions.create()
					.setHeader("Authorization","Bearer 6a141a6edbc160b669d12185d3b909f85bcd83328ec1eb6c56f5ac1e71f32572")
					);
			
			
			//Status code 
			int statusCode=apiResponse.status();
			System.out.println("\nResponse Status Code : "+statusCode+"\n");
			Assert.assertEquals(statusCode, 404);
			
			Assert.assertEquals(apiResponse.statusText(), "Not Found");
			
			Assert.assertTrue(apiResponse.text().contains("Resource not found"));
						
		}
		
		@AfterTest
		public void tearDown()
		{
			playwright.close();
		}

}
