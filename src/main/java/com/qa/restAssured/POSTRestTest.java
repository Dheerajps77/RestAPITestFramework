package com.qa.restAssured;

import org.json.simple.JSONObject;

import org.json.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.restapi.base.TestBase;
import com.qa.restapi.client.RestAssuredClient;

import io.restassured.response.Response;

public class POSTRestTest extends TestBase{
	
	RestAssuredClient objRestAssuredClient=null;
	JSONObject objJSON=null;
	@Test
	public void POSTRestApiTest()
	{
		String URL;
		int statusOfCode;
		String statusOfLine;
		try
		{
								
			objRestAssuredClient=new RestAssuredClient();
			URL=prop.getProperty("POSTRestAssuredURL");
			Response objResponse=objRestAssuredClient.POSTRestAssuredTestMethod(URL);
			statusOfCode=objResponse.getStatusCode();
			statusOfLine=objResponse.getStatusLine();						
			System.out.println("Response of status code is : "+statusOfCode);
			System.out.println("Response of status line is : "+statusOfLine);			
			Assert.assertEquals(statusOfCode, HTTP_RESPONSE_CODE_201);
			Assert.assertEquals(statusOfLine, statusOfLine);
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
