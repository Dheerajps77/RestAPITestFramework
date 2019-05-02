package com.qa.restapi.client;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredClient {

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
			objResquestSepcification.body(objJSON.toJSONString());			
			postRequest=objResquestSepcification.post(url);
		} catch (Exception e) {

			e.printStackTrace();

		}
		return postRequest;
	}

}
