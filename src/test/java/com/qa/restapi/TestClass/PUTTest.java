package com.qa.restapi.TestClass;

import java.io.File;
import java.io.FileInputStream;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.restapi.base.TestBase;
import com.qa.restapi.client.RestClient;
import com.qa.restapi.data.PUTAPIUser;


public class PUTTest extends TestBase {

	RestClient restClient;
	File file;
	FileInputStream fis;
	PUTAPIUser objPUTAPIUser;

	@Test
	public void PUTAPITest() {
		try {
			restClient = new RestClient();			
			
			file = new File(prop.getProperty("PUTAPIUserDerailsURL"));
			fis = new FileInputStream(file);
			ObjectMapper objMapper = new ObjectMapper();
			
			// Initialing values by creating parameterize constructor
			objPUTAPIUser = new PUTAPIUser("St. Brklyn", "Apt 989799", "New Delhi", "92998-3874");
			
			// This will used to serialize any Java value as JSON output, written to File provided.
			objMapper.writeValue(file, objPUTAPIUser);
			
			// This will used to serialize any Java value as a String.
			String enteredStringValue=objMapper.writeValueAsString(objPUTAPIUser);	
			
			// Getting the responseCode after click on PUT method button
			int statusOfCode = restClient.PUTAPITestMethod(prop.getProperty("PUTAPIUserURL"), enteredStringValue);
			System.out.println(enteredStringValue);
			System.out.println(statusOfCode);
			
			// Asserting the responseCode of actual with expected
			Assert.assertEquals(statusOfCode, HTTP_RESPONSE_CODE_200);		

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
