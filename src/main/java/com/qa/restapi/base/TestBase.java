package com.qa.restapi.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
	
	String configPath="C:\\Users\\dheeraj.singh\\eclipse-workspace\\RestApiTest\\src\\main\\java\\com\\qa\\restapi\\config\\Config.properties";
	File file;
	FileInputStream fis;
	protected Properties prop=null;
	
	public int HTTP_RESPONSE_CODE_200=200;
	public int HTTP_RESPONSE_CODE_201=201;
	public int HTTP_RESPONSE_CODE_202=202;
	public int HTTP_RESPONSE_CODE_203=203;
	public int HTTP_RESPONSE_CODE_404=404;
	public String LAST_NAME="Bluth";
	public String totalpages="4";
	public String statusOfLine="HTTP/1.1 201 Created";
	
	public TestBase()
	{
		file=new File(configPath);
		try {
			fis=new FileInputStream(file);
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		}
		try {
			prop=new Properties();
			prop.load(fis);
			System.out.println(prop);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
