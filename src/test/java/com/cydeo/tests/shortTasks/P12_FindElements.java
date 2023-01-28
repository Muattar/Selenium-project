package com.cydeo.tests.shortTasks;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P12_FindElements {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();


        driver.get("https://practice.cydeo.com/");

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));

        System.out.println(allLinks.size());

        for (WebElement eachLink : allLinks) {
            System.out.println(eachLink.getText());//
            System.out.println(eachLink.getAttribute("href"));//to get each of attribute value
        }




        driver.close();


    }

}
