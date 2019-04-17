package RoughWork;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

public class ReadJSONFile {
	
	JSONObject jsonObj=null;
	JSONArray jsonArrObj=null;
	File file=null;
	FileReader fr=null;
	String path="src/main/java/RoughWork/Simple.json";
	
	public static void main(String[] args) {

		
		ReadJSONFile objReadJSONFile=new ReadJSONFile();
		objReadJSONFile.ReadJSON();
	}
	
	public void ReadJSON()
	{			
		file=new File(path);
		try {
			fr=new FileReader(file.getAbsolutePath());
			try {
				JSONParser jsonParser=new JSONParser();
				Object obj=jsonParser.parse(fr);				
				jsonObj=(org.json.simple.JSONObject) obj;
				String fname=(String) jsonObj.get("First name");
				String lname=(String) jsonObj.get("Second name");
				long phonePostalCode=(Long) jsonObj.get("Phone postal code");
				
				System.out.println("Firt name is : "+fname+" and last name is :"+lname+" and phone number code is :"+phonePostalCode);
				System.out.println(jsonObj);
				// This will get all values in the form of <Key, value> pair format and store in address type object of HashMap
				HashMap customerFamilyDetails=(HashMap) jsonObj.get("Customer Family");				
				// Reading and iterating the key and value
				Iterator custDetailIterator=customerFamilyDetails.entrySet().iterator();
				
				// Iterating and printing the values
				while(custDetailIterator.hasNext())
				{
					Map.Entry pair=(Entry) custDetailIterator.next();
					System.out.println(pair.getKey()+" : "+pair.getValue());
				}
				
				HashMap addressDetails=(HashMap) jsonObj.get("address");				
				Iterator addDetailsIterator=jsonObj.entrySet().iterator();
				
				while(addDetailsIterator.hasNext())
				{
					Map.Entry map=(Entry) addDetailsIterator.next();
				System.out.println(map.getKey()+ " : "+map.getValue());
				}
				
				jsonArrObj=(JSONArray)jsonObj.get("Phone number");				
				// This will get the total size of Phone number object
				int totalSizeOfPhonumber=jsonArrObj.size();
				for(int i=0;i<totalSizeOfPhonumber;i++)
				{
					jsonObj= (JSONObject) jsonArrObj.get(i);					
					String phoneType=(String) jsonObj.get("type");
					String phoneNumber=(String) jsonObj.get("number");
					System.out.println(phoneType + " phone number is :  " + phoneNumber);
				}
				
				JSONObject jsonObj1=(JSONObject) obj;
				JSONArray jsonArray1=(JSONArray) jsonObj1.get("Hobbies");
				
				int totalSizeOfHobbies=jsonArray1.size();
				
				for(int i=0;i<totalSizeOfHobbies;i++)
				{
					jsonObj1=(JSONObject) jsonArray1.get(i);
					String firsthobby=(String) jsonObj1.get("First hobby");
					String secondhobby=(String) jsonObj1.get("Second hobby");
					String thirdhobby=(String) jsonObj1.get("Third hobby");
					System.out.println("Hobby 1 :-> "+firsthobby+"\n"+"Hobby 2 :-> "+secondhobby+"\n"+"Hobby 3 :-> "+thirdhobby+"\n");
				}

			} catch (IOException e) {		
				e.printStackTrace();
			} catch (ParseException e) {				
				e.printStackTrace();
			}									
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		}
	}

}
