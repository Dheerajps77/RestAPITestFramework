package com.qa.restapi.TestClass;

import java.util.Iterator;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.restapi.base.TestBase;
import com.qa.restapi.client.RestClient;
import org.json.simple.*;
import org.json.*;
import org.json.JSONArray;

public class ErgastApiTest extends TestBase {

	String serviceURL;
	String apiURL;
	String completeURL;
	TestBase objTestBase;
	RestClient objRestClient;
	JSONObject jsonObj;
	JSONObject jsonObj1;
	Object obj;
	JSONArray objArray;

	@BeforeMethod
	public void setUpMethod() {
		try {
			objTestBase = new TestBase();
			serviceURL = prop.getProperty("ErgastServiceURL");
			apiURL = prop.getProperty("ErgastApiURL");
			completeURL = serviceURL + apiURL;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void GetApiMethod() {
		try {
			objRestClient = new RestClient();
			CloseableHttpResponse objCloseableHttpResponse = objRestClient.ValidateSONResponseCode(completeURL);

			String jsonString = EntityUtils.toString(objCloseableHttpResponse.getEntity(), "UTF-8");
			int responseCode = objCloseableHttpResponse.getStatusLine().getStatusCode();
			System.out.println(responseCode);
			jsonObj = new JSONObject(jsonString);

			// Nested JSONObject i.e, MRData/CircuitTable
			JSONObject mrData = jsonObj.getJSONObject("MRData");
			
			String limit=mrData.getString("limit");
			System.out.println("Limit is --> "+limit);
			
			String url=mrData.getString("url");
			System.out.println("URL name is --> "+url);
			
			JSONObject CircuitTable = mrData.getJSONObject("CircuitTable");
			
			// Now Under circuitTable, circuits JSONArray is present
			JSONArray circuits = CircuitTable.getJSONArray("Circuits");
			int totalCount = circuits.length();
			System.out.println("Total number of list are there in circuits : " + totalCount);

			System.out.println("circuitId are as below : ");
			for (int i = 0; i < totalCount; i++) {
				String circuitId = circuits.getJSONObject(i).getString("circuitId");
				System.out.println("CircuitId is : " + circuitId);
			}

			System.out.println("Locality name are as below : ");
			for (int i = 0; i < totalCount; i++) {
				JSONObject locationIndexValue = circuits.getJSONObject(i);
				JSONObject locationObject = locationIndexValue.getJSONObject("Location");
				String localityName = locationObject.getString("locality");
				System.out.println(localityName);

			}

			System.out.println("Circuit name are as below : ");
			for (int i = 0; i < totalCount; i++) {
				JSONObject circuitIndex = circuits.getJSONObject(i);
				String circuitName = circuitIndex.getString("circuitName");
				System.out.println("Circuit name is " + circuitName);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
