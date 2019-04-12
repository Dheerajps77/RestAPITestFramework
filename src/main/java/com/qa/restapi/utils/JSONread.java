package com.qa.restapi.utils;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONread {

	static JSONObject objJSONObject;	
	static JSONArray objJSONArray;
	public static void main(String[] args) {
		
	}

	public static void ReadingJSON(String jsonPath)
	{
		String firstName=null;
		try
		{
			Object obj=new Object();
			objJSONObject=(JSONObject)obj;
			JSONObject jsonObj=(JSONObject) objJSONObject.get("total_pages");
			System.out.println(jsonObj.toString());
			
		}
		catch (Exception e) {e.printStackTrace();}						
		}		
	}
