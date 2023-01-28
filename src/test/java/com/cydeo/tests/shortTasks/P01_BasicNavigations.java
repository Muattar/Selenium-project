package com.cydeo.tests.shortTasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class P01_BasicNavigations {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.etsy.com");

        List<WebElement> etsyLinks = driver.findElements(By.tagName("a"));

        System.out.println(etsyLinks);
        System.out.println(etsyLinks.size());

        for (WebElement eachLinks : etsyLinks) {
            System.out.println(eachLinks.getText());
            System.out.println(eachLinks.getAttribute("href"));
        }

        driver.navigate().to("https://www.amazon.com");

        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

        driver.close();


    }

}
