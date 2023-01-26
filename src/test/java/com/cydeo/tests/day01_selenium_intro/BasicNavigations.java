package com.cydeo.tests.day01_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {

    public static void main(String[] args) throws InterruptedException {

        //SetUp browser driver
        WebDriverManager.chromedriver().setup();

        //Create instance of Chrome Browser
        WebDriver driver = new ChromeDriver();

        //this line will maximize the currently opened browser
        //driver.manage().window().maximize();

        //this line will fullscreen for mac
        driver.manage().window().fullscreen();

        //Got to tesla.com
        driver.get("https://www.tesla.com");

        //use .getCurrentUrl method to print out current URL
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        //Stop execution for 3 seconds
        Thread.sleep(3000);

        //get title of the page
       // System.out.println("driver.getTitle() = " + driver.getTitle());
        String currentTitle = driver.getTitle();
        System.out.println("currentTitle = " + currentTitle);

        //Use navigate back() to go back         back() -> means it is a empty page
        driver.navigate().back();

        //Stop execution for 3 seconds
        Thread.sleep(3000);

        //Use navigate forward() to go forward
        driver.navigate().forward();

        //Stop execution for 3 seconds
        Thread.sleep(3000);

        //User refreshes the page using navigate.refresh() the page
        driver.navigate().refresh();

        //Stop execution for 3 seconds
        Thread.sleep(3000);

        //Navigate to google.com using navigate().to()
        driver.navigate().to("https://www.google.com");

        //use .getCurrentUrl method to print out current URL
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());


        //get title of the page
        //System.out.println("driver.getTitle() = " + driver.getTitle());
        currentTitle = driver.getTitle();
        System.out.println("currentTitle = " + currentTitle);


        //close only  the currently focused  windows/tab
        driver.close();

        //Closing all - of the opened browsers
        driver.quit();



    }
}
