package com.cydeo.utilities;
//Task: New Method Creation
//Method name: getDriver
//Static method
//Accepts String arg: browserType
//  - This argument will determine what type of browser is opened
//  - if "chrome" passed --> it will open chrome driver
//  - if "fire fox" passed -->  it will open firefox browser
//return type: "WebDriver"

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    public static WebDriver getDriver(String browserType){

        if (browserType.equalsIgnoreCase("chrome")){

            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();

        }else if(browserType.equalsIgnoreCase("firefox")){

            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();

        }else {

            System.out.println("Given string doesn't represent any browser");
            System.out.println("Either that browser does not exist or not currently supported");
            System.out.println("driver = null");
            return null;
        }

    }

    }


