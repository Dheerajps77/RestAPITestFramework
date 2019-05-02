package com.qa.restAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.restapi.base.TestBase;
import com.qa.restapi.client.RestAssuredClient;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DELETERestTest extends TestBase {

	RestAssuredClient objRestAssuredClient;
	Response objresponse;
	@Test
	public void DELETEData()
	{
		String url="";
		String id="";
		String deleteURL="";
		String statusOfLine="";
		int responseOfStatusCodeOnSearchingDeletedRecords;
		String responseOfStatusLineOnSearchingDeletedRecords="";
		int responseCode;
		
		try
		{
			url=prop.getProperty("DELETERestAssuredURL");
			id=prop.getProperty("id");	
			deleteURL=url+id;
			objRestAssuredClient=new RestAssuredClient();
			objresponse=objRestAssuredClient.DELETERestAssuredTestMethod(url, id);
			responseCode=objresponse.getStatusCode();
			statusOfLine=objresponse.getStatusLine();
			System.out.println("Record has been deleted successfully and status of code is : "+ responseCode);
			System.out.println("Record has been deleted successfully and status of line is : "+ statusOfLine);
			
			Assert.assertEquals(responseCode, HTTP_RESPONSE_CODE_200);
			
			Response objresponse1=RestAssured.get(deleteURL);
			
			responseOfStatusCodeOnSearchingDeletedRecords=objresponse1.getStatusCode();
			responseOfStatusLineOnSearchingDeletedRecords=objresponse1.getStatusLine();
			System.out.println(responseOfStatusCodeOnSearchingDeletedRecords);
			System.out.println(responseOfStatusLineOnSearchingDeletedRecords);
			
			if(responseOfStatusCodeOnSearchingDeletedRecords==HTTP_RESPONSE_CODE_404)
			{
				System.out.println("TEST PASSED : We are not able to load the employee data after delete operation perform");	
			}
			else
			{
				System.out.println("TEST FAILED : We are able to load the employee data after delete operation perform");
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
