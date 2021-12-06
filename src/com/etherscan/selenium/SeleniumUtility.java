package com.etherscan.selenium;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtility {

	  private static final Log LOGGER = LogFactory.getLog(SeleniumUtility.class);

	    // this is needed for reusing
	    public static WebDriver driver = null;
	    
	    public static WebDriver getDriver(String driverPath, String browser) {
	       if (browser.equalsIgnoreCase("chrome")) {
	            if (driver == null || (((RemoteWebDriver) driver).getSessionId()) == null) {
	                driver = (WebDriver) new ChromeDriver();
	                return driver;
	            } else
	                return driver;

	        } else if (browser.equalsIgnoreCase("firefox")) {
	            if (driver == null || (((RemoteWebDriver) driver).getSessionId()) == null) {
	                System.setProperty("webdriver.gecko.driver", driverPath);
	                driver = (WebDriver) new FirefoxDriver();
	                return driver;
	            } else
	                return driver;
	        } else {
	            System.setProperty("webdriver.ie.driver", driverPath);
	            InternetExplorerOptions options = new InternetExplorerOptions();
	            options.disableNativeEvents();
	            options.ignoreZoomSettings();
	            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
	            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
	            capabilities.setCapability("ignoreProtectedModeSettings", true);
	            capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "");
	            options.merge(capabilities);
	            driver = new InternetExplorerDriver(options);
	            driver.manage().window().maximize();
	            return driver;
	        }
	    }
	    
	    public static void waitForPageLoad(WebDriver driver) {
	        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
	            @Override
	            public Boolean apply(WebDriver driver) {
	                return "complete".equals(((JavascriptExecutor) driver)
	                        .executeScript("return document.readyState"));
	            }
	        };
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, 120);
	            wait.until(pageLoadCondition);
	        } catch (Exception exception) {
	            WebDriverWait wait = new WebDriverWait(driver, 120);
	            wait.until(pageLoadCondition);
	        }
	    }
	
}
