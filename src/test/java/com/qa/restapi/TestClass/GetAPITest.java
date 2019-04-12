package com.qa.restapi.TestClass;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.restapi.base.TestBase;
import com.qa.restapi.client.RestClient;
import com.qa.restapi.utils.JSONread;

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
		baseUrl = prop.getProperty("SecondBaseURL");
		serviceUrl = prop.getProperty("SecondServiceURL");
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
	public void ValidateJSONValues()
	{		
		String responsString;
		CloseableHttpResponse objCloseableHttpResponse;
		JSONObject objJSONObject=null;
		try
		{
			objRestClient=new RestClient();			
			objCloseableHttpResponse=objRestClient.ValidationJSONResponse(completeUrl);
			responsString=EntityUtils.toString(objCloseableHttpResponse.getEntity(), "UTF-8");
			objJSONObject=new JSONObject(responsString);
			System.out.println("The value of JSON are : "+objJSONObject);
			
			int currentResponseStatusCode=objCloseableHttpResponse.getStatusLine().getStatusCode();			
			Assert.assertEquals(currentResponseStatusCode, HTTP_RESPONSE_CODE_200 , "Response code of 200 don't match");			
		//	JSONread.ReadingJSON(responsString);						
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority=3)
	public void getRequestAct()
	{
		try
		{
			objRestClient=new RestClient();
			objRestClient.GetMethodActivities(completeUrl);
			System.out.println("Your complete url"+completeUrl);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
