package com.cydeo.tests.shortTasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P02_Close_Quite_Page {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://practice.cydeo.com/new_tab");

        Thread.sleep(2000);

        //it will close currently open page
        driver.close();


        //it will close all open page
        driver.quit();


    }

}
