package com.qa.restapi.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import junit.framework.Assert;


public class RestClient {

	public void GetMethod(String url) {
		try {
			// It will create a client connection and it will return a
			// closeablehttpClient(Abstract class) object
			CloseableHttpClient objCloseableHttpClient = HttpClients.createDefault();

			// This will get httpRequest
			HttpGet objHttpGet = new HttpGet(url);

			// This will call the response for which it was request by user(just like
			// hitting the button to SEND(In a postman))
			// And also it will return CloseableHttpResponse object
			CloseableHttpResponse objCloseableHttpResponse = objCloseableHttpClient.execute(objHttpGet);

			// This will return a integer value with status code of your request
			int statusOfCodeLine = objCloseableHttpResponse.getStatusLine().getStatusCode();

			// Printing the response status code
			System.out.println("Status code is --> " + statusOfCodeLine);

			// This will return JSON string with pure string
			String reponseString = EntityUtils.toString(objCloseableHttpResponse.getEntity(), "UTF-8");

			// This will convert the entity of your response in JSON
			JSONObject responseJSON = new JSONObject(reponseString);

			// Printing the JSON response
			System.out.println("Response of your request is --> " + responseJSON);

			// This will return all headers value in headerArray object
			Header[] headerArray = objCloseableHttpResponse.getAllHeaders();

			// Storing of header in the form of Key, value pair format
			HashMap<String, String> objHashMap = new HashMap<String, String>();

			// iterating the key, value using for each loop
			for (Header header : headerArray) {
				objHashMap.put(header.getName(), header.getValue());
			}

			// print the header key, value
			System.out.println("Header values are -->" + objHashMap);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void GetMethodActivities(String url) {
		try {
			// It will create a client connection and it will return a
			// closeablehttpClient(Abstract class) object
			CloseableHttpClient objCloseableHttpClient = HttpClients.createDefault();

			// This will get httpRequest
			HttpGet objHttpGet = new HttpGet(url);

			// This will call the response for which it was request by user(just like
			// hitting the button to SEND(In a postman))
			// And also it will return CloseableHttpResponse object
			CloseableHttpResponse objCloseableHttpResponse = objCloseableHttpClient.execute(objHttpGet);

			// This will return a integer value with status code of your request
			int statusOfCodeLine = objCloseableHttpResponse.getStatusLine().getStatusCode();

			// Printing the response status code
			System.out.println("Status code is --> " + statusOfCodeLine);

			// This will return JSON string with pure string
			String reponseString = EntityUtils.toString(objCloseableHttpResponse.getEntity(), "UTF-8");

			// This will convert the entity of your response in JSON
			JSONObject responseJSON = new JSONObject(reponseString);

			// Printing the JSON response
			System.out.println("Response of your request is --> " + responseJSON);

			// This will return all headers value in headerArray object
			Header[] headerArray = objCloseableHttpResponse.getAllHeaders();

			// Storing of header in the form of Key, value pair format
			HashMap<String, String> objHashMap = new HashMap<String, String>();

			// iterating the key, value using for each loop
			for (Header header : headerArray) {
				objHashMap.put(header.getName(), header.getValue());
			}

			// print the header key, value
			System.out.println("Header values are -->" + objHashMap);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// This will return the executed GET method in CloseableHTTPResponse abstract
	// class object
	public CloseableHttpResponse ValidateSONResponseCode(String url) {
		CloseableHttpResponse objCloseableHttpResponse = null;
		try {
			CloseableHttpClient objCloseableHttpClient = HttpClients.createDefault();
			HttpGet objHttpGet = new HttpGet(url);
			objCloseableHttpResponse = objCloseableHttpClient.execute(objHttpGet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objCloseableHttpResponse;
	}

	// This method will return the JSON string Entity(which holds all "file.json"
	// values in entity)
	public String GetMethodJSONValues(String url) {
		String jsonStringValue = "";
		try {
			CloseableHttpClient objCloseableHttpClient = HttpClients.createDefault();
			HttpGet objHttpGet = new HttpGet(url);
			CloseableHttpResponse objCloseableHttpResponse = objCloseableHttpClient.execute(objHttpGet);
			jsonStringValue = EntityUtils.toString(objCloseableHttpResponse.getEntity(), "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonStringValue;
	}

	// This method will return the response of your payLoad in closeableHttpResponse
	public CloseableHttpResponse PostAPIMethod(String url, String getStringEntity, HashMap<String, String> header) {
		CloseableHttpResponse objCloseableHttpResponse = null;
		try {
			CloseableHttpClient objCloseableHttpClient = HttpClients.createDefault();

			// HTTP post request
			HttpPost objPost = new HttpPost(url);

			// defining payLoad(Like we did in this example i.e, created "userFirstName" and
			// "userSecondName")
			StringEntity objStringEntity = new StringEntity(getStringEntity);
			objPost.setEntity(objStringEntity);

			// String and returning header key/value pairs
			for (Map.Entry<String, String> entry : header.entrySet()) {
				objPost.addHeader(entry.getKey(), entry.getValue());
			}
			objCloseableHttpResponse = objCloseableHttpClient.execute(objPost);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objCloseableHttpResponse;
	}
	
	
	public int PUTAPITestMethod(String URL, String getStringEntity)
	{
		CloseableHttpClient objCloseableHttpClient;
		String jsonStringValue="";
		int statusOfCode=0;
		try
		{
			objCloseableHttpClient=HttpClients.createDefault();
			HttpPut objPut=new HttpPut(URL);
			StringEntity objStringEntity = new StringEntity(getStringEntity);			
			objPut.setEntity(objStringEntity);					
			CloseableHttpResponse obCloseableHttpResponse=objCloseableHttpClient.execute(objPut);
			jsonStringValue = EntityUtils.toString(obCloseableHttpResponse.getEntity(), "UTF-8");
			statusOfCode=obCloseableHttpResponse.getStatusLine().getStatusCode();						
			System.out.println(statusOfCode);
			System.out.println(jsonStringValue);
			
		}
		catch (Exception e) {
		e.printStackTrace();
		}
		
		return statusOfCode;
	}
}
