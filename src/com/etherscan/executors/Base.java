package com.etherscan.executors;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.etherscan.selenium.AutomationConstant;
import com.etherscan.selenium.PageActions;
import com.etherscan.selenium.TestReader;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.Map;

import org.json.JSONException;
import org.testng.annotations.AfterTest;

public class Base {
	
  PageActions act;
  
  @BeforeTest(alwaysRun = true)
  @Parameters("configJson")
  public void beforeClass(String configJson) throws JSONException {
	  TestReader reader = new TestReader(); 
	  String str = reader.JsonResponse(configJson,AutomationConstant.TEST_SUITE_NAME);
	  act = new PageActions(reader.JsonResponse(configJson,AutomationConstant.WEB_DRIVER_EXECUTABLE_PATH));
	  act.launchurl(reader.JsonResponse(configJson,AutomationConstant.WEB_URL));
  }

  @AfterTest(alwaysRun = true)
  public void afterClass() {
	  act.closeDriver();
  }
  
}
