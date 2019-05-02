package com.qa.restapi.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class ReadJSONValue {

	public static void GetJSONStringValues(String GETData, String jsonOjectValue, String jsonStringValue) {
		Object obj;
		JSONObject objJSON1;
		JSONObject objJSON2;
		try {
			objJSON1 = new JSONObject(GETData);
			objJSON2 = objJSON1.getJSONObject(jsonOjectValue);
			Iterator<String> iterate = objJSON2.keys();
			while (iterate.hasNext()) {
				obj = objJSON2.get(jsonStringValue);

				if (obj instanceof Double) {
					double doubleValue = (Double) objJSON2.get(jsonStringValue);
					System.out.println(doubleValue);
					break;
				}

				else if (obj instanceof String) {
					String stringValue = (String) objJSON2.get(jsonStringValue);
					System.out.println(stringValue);
					break;
				}

				else if (obj instanceof Float) {
					float floatValue = (Float) objJSON2.get(jsonStringValue);
					System.out.println(floatValue);
					break;
				}

				else if (obj instanceof Integer) {
					int intValue = (Integer) objJSON2.get(jsonStringValue);
					System.out.println(intValue);
					break;
				}

				else if (obj instanceof Boolean) {
					boolean booleanValue = (Boolean) objJSON2.get(jsonStringValue);
					System.out.println(booleanValue);
					break;
				}
			}	

			Iterator<String> ite = objJSON2.keys();
			Map<Object, Object> mp = new HashMap<Object, Object>();
			Object objct4;
			while (ite.hasNext()) {				
				objJSON2 = objJSON1.getJSONObject(jsonOjectValue);
				String Key = ite.next();
				objct4 = objJSON2.get(Key);				
				if (objct4 instanceof Integer) {
					int intValue = objJSON2.getInt(Key);
					mp.put(Key, intValue);
				}

				if (objct4 instanceof Long) {
					Long longValue = objJSON2.getLong(Key);
					mp.put(Key, longValue);
				}
				
				if (objct4 instanceof Boolean) {
					boolean boolValue = objJSON2.getBoolean(Key);
					mp.put(Key, boolValue);
				}

				if (objct4 instanceof String) {
					String stringValue = objJSON2.getString(Key);
					mp.put(Key, stringValue);
				}

				if (objct4 instanceof Double) {
					Double doubleValue = objJSON2.getDouble(Key);
					mp.put(Key, doubleValue);
				}

				if (objct4 instanceof Float) {
					float floatValue = objJSON2.getFloat(Key);
					mp.put(Key, floatValue);
				}

			}

			for (Map.Entry mp1 : mp.entrySet()) {
				System.out.println(mp1.getKey() + " :: " + mp1.getValue());
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
	}	

	// This method will return all jsonObject in list
	public static ArrayList<String> GetAllJSONKeyValues(String GETData) {
		ArrayList<String> list = null;
		JSONObject objJSON1;
		try {
			list = new ArrayList<String>();
			objJSON1 = new JSONObject(GETData);
			Iterator<String> iterate1 = objJSON1.keys();
			while (iterate1.hasNext()) {
				String jsonObjectStringValue = (String) iterate1.next();
				list.add(jsonObjectStringValue);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static void GetJSONArrayValue(String GetAllData,String jsonArrayObjectValue)
	{
		
		JSONObject jsonObject;
		JSONArray jsonArrayObject;	
		Object obj;
		Map<Object, Object> map=new HashMap<Object, Object>();
		try
		{
			jsonObject=new JSONObject(GetAllData);
			jsonArrayObject=new JSONArray();
			jsonArrayObject=jsonObject.getJSONArray(jsonArrayObjectValue);						
			int totalCount=jsonArrayObject.length();
			
			for(int i=0;i<totalCount;i++)
			{
				JSONObject jb=jsonArrayObject.getJSONObject(i);				
				Iterator<String> it=jb.keys();					
				while(it.hasNext())
				{
					String key= it.next();
					obj=jb.get(key);
					
					if(obj instanceof String)
					{
						String Value=obj.toString();
						System.out.println(key + " :: "+Value);
						map.put(key, Value);										
					}					
					else if(obj instanceof Integer)
					{
						int Value=((Integer) obj).intValue();
						System.out.println(key + " :: "+Value);
						map.put(key, Value);										
					}
					
					else if(obj instanceof Boolean)
					{
						boolean Value=((Boolean) obj).booleanValue();
						System.out.println(key + " :: "+Value);
						map.put(key, Value);										
					}
					
					else if(obj instanceof Double)
					{
						double Value=((Double) obj).doubleValue();
						System.out.println(key + " :: "+Value);
						map.put(key, Value);										
					}
					
					else if(obj instanceof Float)
					{
						float Value=((Float) obj).floatValue();
						System.out.println(key + " :: "+Value);
						map.put(key, Value);										
					}
				}
				
			}
		}
		catch (Exception e) {

			e.printStackTrace();
		}
	}

}
