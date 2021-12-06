package com.etherscan.executors;

import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.etherscan.selenium.TestReader;

public class RegistrationValidator {
	
	@Test
	@Parameters("configJson")
	public static void function(String configJson) throws JSONException
	{
		System.out.println("TEST 1 START");
		 TestReader reader = new TestReader(); 
		 reader.Json(configJson);
		 System.out.println("TEST 1 END");
	}
	
}
