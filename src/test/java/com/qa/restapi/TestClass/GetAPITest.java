package com.qa.restapi.TestClass;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.qa.restapi.base.TestBase;
import com.qa.restapi.client.RestClient;


public class GetAPITest extends TestBase {

	TestBase objTestBase;
	RestClient objRestClient;
	String baseUrl;
	String serviceUrl;
	String completeUrl;
	
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
	
	@Test(priority=1, enabled=false)
	public void getRequest()
	{
		try
		{
			objRestClient=new RestClient();
			objRestClient.GetMethod(completeUrl);
			System.out.println("Your complete url"+completeUrl);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority=2, enabled=false)
	public void ValidateJSONResponseCode()
	{		
		String responsString;
		CloseableHttpResponse objCloseableHttpResponse;
		JSONObject objJSONObject=null;
		try
		{
			objRestClient=new RestClient();			
			objCloseableHttpResponse=objRestClient.ValidateSONResponseCode(completeUrl);
			responsString=EntityUtils.toString(objCloseableHttpResponse.getEntity(), "UTF-8");
			objJSONObject=new JSONObject(responsString);
			System.out.println("The value of JSON are : "+objJSONObject);
			
			int currentResponseStatusCode=objCloseableHttpResponse.getStatusLine().getStatusCode();			
			Assert.assertEquals(currentResponseStatusCode, HTTP_RESPONSE_CODE_200);									
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Response code of"+HTTP_RESPONSE_CODE_200+" don't match");
		}
	}
	
	@Test(priority=3, enabled=false)
	public void getRequestAct()
	{
		try
		{
			objRestClient=new RestClient();
			objRestClient.GetMethodActivities(completeUrl);
			System.out.println("Your complete url : "+completeUrl);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority=4, enabled=false)
	public void GetJSONValuesFromArray()
	{
		objRestClient=new RestClient();
		ArrayList<String> arraylist=new ArrayList<String>();
		String lastName="";
		JSONArray jsonArrayObj=null;
		JSONObject jsonObj=null;
		try
		{
			String jsonValues=objRestClient.GetMethodJSONValues(completeUrl);
			System.out.println("The values are : - "+jsonValues);			
			jsonObj=new JSONObject(jsonValues);
			jsonArrayObj=new JSONArray();
			
			
			jsonArrayObj= (JSONArray) jsonObj.get("data");
			int totalSizeOfData=jsonArrayObj.length();		
			for(int i=0;i<totalSizeOfData;i++)
			{
				jsonObj=(JSONObject) jsonArrayObj.get(i);
				lastName=(String) jsonObj.get("last_name");					
				arraylist.add(lastName);
			}
			
			Iterator<String> iterator=arraylist.iterator();
			
			while(iterator.hasNext())
			{
				String str=iterator.next();
				Assert.assertEquals(LAST_NAME, str);
				break;
			}
			
		}catch (Exception e) {
		e.printStackTrace();
		System.out.println("Last name didn't match.");
		}
	}
	
	@Test(priority=5)
	public void GetJSONStringValues()
	{
		objRestClient=new RestClient();
		try
		{
			String jsonValues=objRestClient.GetMethodJSONValues(completeUrl);
			JSONObject jsonObj=new JSONObject(jsonValues);
			int totalPagesValue=(Integer)jsonObj.get("total_pages");
			
			Assert.assertEquals(Integer.parseInt(totalpages), totalPagesValue);
			
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Total pages count didn't match.");			
		}
	}
}
