package com.cydeo.tests.shortTasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P07_findElementByTagName {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com/");

        WebElement findHeader = driver.findElement(By.tagName("h1"));

        System.out.println("findHeader.getText() = " + findHeader.getText());

        driver.close();
    }

}
