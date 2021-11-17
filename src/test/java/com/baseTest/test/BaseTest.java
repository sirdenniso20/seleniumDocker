package com.baseTest.test;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected WebDriver driver;
    String baseurl, nodeUrl;


    @BeforeTest
    public void testSetup(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\sirde\\Desktop\\Automation\\automationLibraries\\chromedriver.exe" );
        this.driver = new ChromeDriver();
    }


        @AfterTest
        public void quitDriver() {
            this.driver.quit();
        }

}
