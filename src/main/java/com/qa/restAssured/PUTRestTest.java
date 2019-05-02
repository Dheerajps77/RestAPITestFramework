package com.qa.restAssured;

import org.testng.annotations.Test;

import com.qa.restapi.base.TestBase;
import com.qa.restapi.client.RestAssuredClient;

import io.restassured.response.Response;

public class PUTRestTest extends TestBase{
	
	RestAssuredClient objRestAssuredClient;
	Response objResponse;
	
	@Test
	public void PUTData()
	{
		String url;
		String id;
		String completePutURL="";
		String name;
		String code;
		String version;
		String statusOfLine;
		int statusOfCode;
		
		try
		{
			url=prop.getProperty("PUTRestAssuredURL");
			id=prop.getProperty("id");
			name=prop.getProperty("Name");
			code=prop.getProperty("Cod");
			version=prop.getProperty("Version");
			completePutURL=url+id;
			objRestAssuredClient=new RestAssuredClient();
			objResponse=objRestAssuredClient.PUTRestAssuredTestMethod(completePutURL,id, name, code, version);
			statusOfCode=objResponse.getStatusCode();
			statusOfLine=objResponse.getStatusLine();
			System.out.println(statusOfCode);
			System.out.println(statusOfLine);
			
			String str=objResponse.asString();
			
			System.out.println("Updated values are as follow : -");
			System.out.println(str);
			
		}
		catch (Exception e) {

			e.printStackTrace();
		}
	}

}
