package com.qa.restapi.client;

import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {

	public void GetMethod(String url)
	{
		try
		{
			// It will create a client connection and it will return a closeablehttpClient(Abstract class) object
			CloseableHttpClient objCloseableHttpClient= HttpClients.createDefault();
			
			// This will get httpRequest
			HttpGet objHttpGet=new HttpGet(url); 
			
			// This will call the response for which it was request by user(just like hitting the button to SEND(In a postman))
			//And also it will return CloseableHttpResponse object
			CloseableHttpResponse objCloseableHttpResponse= objCloseableHttpClient.execute(objHttpGet);
			
			// This will return a integer value with status code of your request
			int statusOfCodeLine=objCloseableHttpResponse.getStatusLine().getStatusCode();
			
			
			// Printing the response status code
			System.out.println("Status code is --> "+ statusOfCodeLine);
			
			// This will return JSON string with pure string
			String reponseString=EntityUtils.toString(objCloseableHttpResponse.getEntity(), "UTF-8");
			
			// This will convert the entity of your response in JSON
			JSONObject responseJSON=new JSONObject(reponseString);

			// Printing the JSON response
			System.out.println("Response of your request is --> "+ responseJSON);
			
			// This will return all headers value in headerArray object
			Header[] headerArray= objCloseableHttpResponse.getAllHeaders();
			
			// Storing of header in the form of Key, value pair format
			HashMap<String, String> objHashMap=new HashMap<String, String>();
			
			// iterating the key, value using for each loop
			for(Header header: headerArray)
			{
				objHashMap.put(header.getName(), header.getValue());
			}
			
			// print the header key, value
			System.out.println("Header values are -->"+objHashMap);
						
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void GetMethodActivities(String url)
	{
		try
		{
			// It will create a client connection and it will return a closeablehttpClient(Abstract class) object
			CloseableHttpClient objCloseableHttpClient= HttpClients.createDefault();
			
			// This will get httpRequest
			HttpGet objHttpGet=new HttpGet(url); 
			
			// This will call the response for which it was request by user(just like hitting the button to SEND(In a postman))
			//And also it will return CloseableHttpResponse object
			CloseableHttpResponse objCloseableHttpResponse= objCloseableHttpClient.execute(objHttpGet);
			
			// This will return a integer value with status code of your request
			int statusOfCodeLine=objCloseableHttpResponse.getStatusLine().getStatusCode();
			
			
			// Printing the response status code
			System.out.println("Status code is --> "+ statusOfCodeLine);
			
			// This will return JSON string with pure string
			String reponseString=EntityUtils.toString(objCloseableHttpResponse.getEntity(), "UTF-8");
			
			// This will convert the entity of your response in JSON
			JSONObject responseJSON=new JSONObject(reponseString);

			// Printing the JSON response
			System.out.println("Response of your request is --> "+ responseJSON);
			
			// This will return all headers value in headerArray object
			Header[] headerArray= objCloseableHttpResponse.getAllHeaders();
			
			// Storing of header in the form of Key, value pair format
			HashMap<String, String> objHashMap=new HashMap<String, String>();
			
			// iterating the key, value using for each loop
			for(Header header: headerArray)
			{
				objHashMap.put(header.getName(), header.getValue());
			}
			
			// print the header key, value
			System.out.println("Header values are -->"+objHashMap);
						
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	
	public CloseableHttpResponse ValidationJSONResponse(String url)
	{		
		CloseableHttpResponse objCloseableHttpResponse = null;
		try
		{			
			CloseableHttpClient objCloseableHttpClient=HttpClients.createDefault();
			HttpGet objHttpGet=new HttpGet(url);
			objCloseableHttpResponse= objCloseableHttpClient.execute(objHttpGet);						
		}
		catch (Exception e) {
			e.printStackTrace();
		}		
		return objCloseableHttpResponse;
	}
	
	public void GetMethod(String url, HashMap<String, String> haspMap)
	{
		try
		{
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
