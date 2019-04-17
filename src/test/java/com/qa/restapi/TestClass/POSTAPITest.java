package com.qa.restapi.TestClass;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.restapi.base.TestBase;
import com.qa.restapi.client.RestClient;
import com.qa.restapi.data.UserData;

import junit.framework.Assert;

public class POSTAPITest extends TestBase{

	TestBase objTestBase;
	RestClient objRestClient;
	String baseUrl;
	String serviceUrl;
	String completeUrl;	
	String userDataJSONPath="C:\\Users\\dheeraj.singh\\eclipse-workspace\\RestApiTest\\src\\main\\java\\com\\qa\\restapi\\data\\user.json";

	@BeforeMethod
	public void SetUp() 
	{		
		try
		{
		objTestBase = new TestBase();		
		baseUrl = prop.getProperty("FirstServiceURL");
		serviceUrl = prop.getProperty("FirstApiURL");
		completeUrl = baseUrl + serviceUrl;
		}
		catch (Exception e) {
		e.printStackTrace();
		}
	}
	
	@Test
	public void PostAPITest()
	{
		CloseableHttpResponse objCloseableHttpResponse;
		File file;
		try	
		{
			objRestClient=new RestClient();
			file=new File(userDataJSONPath);
			HashMap<String, String> hasMap=new HashMap<String, String>();
			hasMap.put("Content-Type", "application/json");
			ObjectMapper objMapper=new ObjectMapper();
			UserData userData=new UserData("Dheeraj", "Rajput"); //Expected user object
			
			// JavaOject convert to JSON(Marshaling)
			objMapper.writeValue(file, userData);
			// Obj convert to JSON in String
			String users=objMapper.writeValueAsString(userData);
			
			System.out.println(users);
			
			objCloseableHttpResponse=objRestClient.PostAPIMethod(completeUrl, users, hasMap);
			int getStatusCode=objCloseableHttpResponse.getStatusLine().getStatusCode();			
			Assert.assertEquals(HTTP_RESPONSE_CODE_201, getStatusCode);
			System.out.println("Created entity response code is : "+getStatusCode);
			
			String responseString=EntityUtils.toString(objCloseableHttpResponse.getEntity(), "UTF-8");
			JSONObject jsonObj=new JSONObject(responseString);		
     		System.out.println(jsonObj);
			
			
			// JSON to JavaObject(Un-Marshaling)		
			UserData userData1=objMapper.readValue(responseString, UserData.class); //Actual users Object
			System.out.println(userData1);
			
			Assert.assertEquals(userData.getUserFirstName(), (userData1.getUserFirstName()));
			Assert.assertEquals(userData.getUserSecondName(),(userData1.getUserSecondName()));									
			System.out.println();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
