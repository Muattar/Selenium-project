package com.cydeo.tests.shortTasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P10_findElementByCssSelector {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice.cydeo.com/");

        WebElement homeLink = driver.findElement(By.cssSelector("a[class='nav-link']"));

        if (homeLink.getText().equals("Home")){
            System.out.println("Home text verification is PASS!!!");
        }else {
            System.out.println("Home text verification is FAIL!!!");

        }

        driver.close();

    }

}
