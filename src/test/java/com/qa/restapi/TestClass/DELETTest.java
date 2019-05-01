package com.qa.restapi.TestClass;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.qa.restapi.base.TestBase;
import com.qa.restapi.client.RestClient;

public class DELETTest extends TestBase {

	RestClient objRestClient;
	
	
	@Test
	public void DELETAPITEST()
	{
	try
	{
		objRestClient=new RestClient();
		int responseCode=objRestClient.DELETEAPITestMethod(prop.getProperty("DELETEAPIUserURL"));
		System.out.println("Response code after the deletion of particular details : "+ responseCode);
		
		Assert.assertEquals(HTTP_RESPONSE_CODE_200, responseCode);
		
	}
	catch (Exception e) {
				
		e.printStackTrace();
	}
	}
}
