package com.cydeo.tests.shortTasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P00_SeleniumTest {

    public static void main(String[] args) {

        //1-Setting up the web driver manager
        WebDriverManager.chromedriver().setup();

        //2-Create a instance of the chrome driver
        //empty "data" page will be opening
        WebDriver driver = new ChromeDriver();

        //3-Navigate to google page
        //Test if driver is working
        driver.get("https://www.google.com");


    }

}
