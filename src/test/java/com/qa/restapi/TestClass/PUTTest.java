package com.qa.restapi.TestClass;

import java.io.File;
import java.io.FileInputStream;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.restapi.base.TestBase;
import com.qa.restapi.client.RestClient;
import com.qa.restapi.data.PUTAPIUser;

import junit.framework.Assert;

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
			objPUTAPIUser = new PUTAPIUser("St. Brklyn", "Apt 989799", "New Delhi", "92998-3874");
			objMapper.writeValue(file, objPUTAPIUser);
			String enteredStringValue=objMapper.writeValueAsString(objPUTAPIUser);			
			int statusOfCode = restClient.PUTAPITestMethod(prop.getProperty("PUTAPIUserURL"), enteredStringValue);
			System.out.println(enteredStringValue);
			System.out.println(statusOfCode);
			Assert.assertEquals(statusOfCode, HTTP_RESPONSE_CODE_200);		

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
