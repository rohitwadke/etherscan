package com.etherscan.selenium;

import org.openqa.selenium.WebDriver;

public class PageActions {
    
    private static String currentWindowHandle;
	WebDriver driver = null;
    String browser = "";

    public PageActions(String driver) {
        if (driver.contains("safari")) {
            browser = "safari";
        } else if (driver.contains("geckodriver")) {
            browser = "firefox";
        } else if (driver.contains("chrome")) {
            browser = "chrome";
        }
        this.driver = SeleniumUtility.getDriver(driver, browser);
    	}
    
    public void launchurl(String url) {
    	this.driver.get(url);
    	SeleniumUtility.waitForPageLoad(this.driver);
    	driver.manage().window().maximize();
    	PageActions.currentWindowHandle = this.driver.getWindowHandle();
        }
    
    public void submitRequest(String username, String password) {
    	
    	}
    
    public void closeDriver() {
        this.driver.quit();
        this.driver = null;
    	}
    
	
}
