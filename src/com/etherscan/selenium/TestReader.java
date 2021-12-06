package com.etherscan.selenium;
import java.io.FileReader;
import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class TestReader {
	
	public static String JsonResponse(String jsonFile, String key) throws JSONException {
		String geoId = null;
		JSONParser parser = new JSONParser();
	      try {
	         Object obj = parser.parse(new FileReader(jsonFile));
	         JSONObject jsonObject = (JSONObject)obj;
	 	     geoId = (String) jsonObject.get(key);
	         
	      } catch(Exception e) {
	         e.printStackTrace();
	      }
		return geoId;
	} 
	
	public static void Json(String jsonFile) throws JSONException {
		JSONParser parser = new JSONParser();
	      try {
	         Object obj = parser.parse(new FileReader(jsonFile));
	         JSONObject jsonObject = (JSONObject)obj;
	 	     JSONArray fields = (JSONArray) jsonObject.get("testCases");
	    	for (Object field : fields) {
	    		JSONObject fld = (JSONObject) field;
	    		if(fld.get("testType").toString().equals("testMessageForManditoryField"))
	    		{
	    			JSONArray fields1 = (JSONArray) fld.get("fields");	
	    			for (Object field1 : fields1) {
	    				JSONObject fld1 = (JSONObject) field1;
	    				System.out.println(fld1.get("fieldName"));
	    				System.out.println(fld1.get("expectedError"));
	    			}
	    		}	
	    	} 	     
	         
	      } catch(Exception e) {
	         e.printStackTrace();
	      }
	}
	
	
	public static void CreateAnAccount()
	{
		
		
	}
	
	

}
