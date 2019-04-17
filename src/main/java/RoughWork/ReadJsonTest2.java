package RoughWork;

import java.io.File;
import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ReadJsonTest2 {
	static JSONObject jsonObj=null;
	static JSONArray jsonArrObj=null;
	static File file=null;
	static FileReader fr=null;
	static String path="src/main/java/RoughWork/Simple.json";
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		file=new File(path);
		try {
			fr=new FileReader(file.getAbsolutePath());
			JSONParser jsonParser=new JSONParser();
			Object obj=jsonParser.parse(fr);				
			jsonObj=(org.json.simple.JSONObject) obj;
			String str = jsonObj.toJSONString();
			System.out.println(str);
			//JSONObject object = new JSONObject();
			// Get Data Values
			System.out.println("------------- Phone --------------");
		    JSONArray dataValues = (JSONArray) jsonObj.get("Phone number");
		    
		    for(int i=0;i<dataValues.size();i++)
		    {
		    	
		    	jsonObj=(JSONObject) dataValues.get(i);
		    	String type=(String) jsonObj.get("type");
		    	String number=(String) jsonObj.get("number");
		    	
		    	System.out.println(type+" : "+number);		    			    
		    }
		    
			System.out.println("------------- Hobbies --------------");		    
		    JSONObject jsonObj1=new JSONObject();
		    jsonObj1=(org.json.simple.JSONObject) obj;
		    String str1 = jsonObj1.toJSONString();
		    JSONArray dataValues2 = (JSONArray) jsonObj1.get("Hobbies");
		    for(int i=0;i<dataValues2.size();i++)
		    {
		    	
		    	jsonObj1=(JSONObject) dataValues2.get(i);
		    	String firtHobby=(String) jsonObj1.get("First hobby");
		    	String secondHobby=(String) jsonObj1.get("Second hobby");
		    	String thirdHobby=(String) jsonObj1.get("Third hobby");
		    	
		    	System.out.println("Hobby 1 :-> "+firtHobby+"\n"+"Hobby 2 :-> "+secondHobby+"\n"+"Hobby 3 :-> "+thirdHobby+"\n");    			    
		    }		    
		}
		catch(Exception e) {
			
		}
	}

}
