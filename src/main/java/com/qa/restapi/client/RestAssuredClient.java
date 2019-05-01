package com.qa.restapi.client;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestAssuredClient {
	
	
	
	// This method will return the response data
	public Response GETRestAssuredTestMethod(String url)
	{
		Response getRequest = null;
		try
		{			
			// This will return response of the GET request.
			getRequest=RestAssured.get(url);
			
		}
		catch (Exception e) {

			e.printStackTrace();
		}
		return getRequest;
	}

}
