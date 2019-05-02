package com.qa.restapi.client;

import org.json.simple.JSONObject;

import com.qa.restapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredClient extends TestBase {

	// This method will return the response data
	public Response GETRestAssuredTestMethod(String url) {
		Response getRequest = null;
		try {
			// This will return response of the GET request.
			getRequest = RestAssured.get(url);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return getRequest;
	}

	// This method will add entity or data in existing JSON
	public Response POSTRestAssuredTestMethod(String url) {
		Response postRequest = null;
		JSONObject objJSON=null;
		try {
			
			RequestSpecification objResquestSepcification=RestAssured.given();
			objResquestSepcification.header("Content-Type", "application/json");					
			objJSON = new JSONObject();
			objJSON.put("id", 10);
			objJSON.put("name", "Dharmender Singh");
			objJSON.put("cod", 90);
			
			// Attaching JSON data to body
			objResquestSepcification.body(objJSON.toJSONString());	
			
			// Sending Body with JSON data using POST HTTP method
			postRequest=objResquestSepcification.post(url);
		} catch (Exception e) {

			e.printStackTrace();

		}
		return postRequest;
	}
	
	// This method will delete the date in existing JSON
	public Response DELETERestAssuredTestMethod(String url, String id)
	{
		String completedURL="";
		Response deleteRequest = null;
		try
		{
			RequestSpecification objResquestSepcification=RestAssured.given();
			completedURL=url+id;
			deleteRequest=objResquestSepcification.delete(completedURL);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return deleteRequest;
	}
	
	
	// This PUT method is used to update the data in existing JSON
	public Response PUTRestAssuredTestMethod(String url, String id, String name, String code, String version)
	{
		Response objResponse=null;
		String completedURL="";
		JSONObject objJSON=null;
		
		try
		{
			RequestSpecification objResquestSepcification=RestAssured.given();
			objResquestSepcification.header("Content-Type", "application/json");
			
			objJSON=new JSONObject();
			objJSON.put("Name", name);
			objJSON.put("Cod", code);
			objJSON.put("Version", version);
			
			objResquestSepcification.body(objJSON.toJSONString());
			completedURL=url;
			objResponse=objResquestSepcification.put(completedURL);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return objResponse;
	}

}
