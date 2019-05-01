package com.qa.restAssured;
import org.testng.annotations.Test;

import com.qa.restapi.base.TestBase;
import com.qa.restapi.client.RestAssuredClient;
import com.qa.restapi.utils.ReadJSONValue;

import io.restassured.response.Response;

public class GETRestTest extends TestBase {

	RestAssuredClient objRestAssuredClient;
	Response responseOfGETData;
	
	@Test
	public void GetData()
	{
		String requestedGETData=null;
		String jsonObjectName=null;
		String jsonStringValueName=null;
		String JsonObjectArrayValueName=null;
		try
		{
			jsonObjectName=prop.getProperty("GetJSONObject");
			jsonStringValueName=prop.getProperty("GetJSONStringValue");	
			JsonObjectArrayValueName=prop.getProperty("GetJSONArrayObject");

			objRestAssuredClient=new RestAssuredClient();
			responseOfGETData= objRestAssuredClient.GETRestAssuredTestMethod(prop.getProperty("GETRestAssuredURL"));
			requestedGETData=responseOfGETData.asString();
			System.out.println(requestedGETData);
			int responseCode=responseOfGETData.getStatusCode();
			System.out.println(responseCode);									
			// This method will fetch the JSONObject value in the form of (Key,Value) pair
			ReadJSONValue.GetJSONStringValues(requestedGETData, jsonObjectName, jsonStringValueName);		
			
			// This method will fetch the JSONArray value in the form of (Key,Value) pair
			ReadJSONValue.GetJSONArrayValue(requestedGETData, JsonObjectArrayValueName);
		}
		catch (Exception e) {
			e.printStackTrace();
		}		
	}	
}
