package com.cydeo.tests.shortTasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P03_GettingPageTitle {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://cydeo.com");

        //Test if title of the page is Cydeo
        if(driver.getTitle().equals("Cydeo")){
            System.out.println("Title verification is PASS!!!");

        }else{
            System.out.println("Title verification is FAIL!!!");
        }
driver.close();
    }

}
