package com.cydeo.tests.day3.practice;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T2_Xpath {

    public static void main(String[] args) {

        //HWP #2: Zero Bank header verification
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2. Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");

        //3. Verify header text
        //solution with xpath locator
       // WebElement headerText = driver.findElement(By.xpath("//h3"));

        //solution with sccSelector
        //--> tag[attribute='value']
        WebElement headerText = driver.findElement(By.cssSelector("h3"));


        //Expected: “Log in to ZeroBank”
        String expectedHeaderText = "Log in to ZeroBank";
        String actualHeaderText = headerText.getText();

        if (actualHeaderText.equals(expectedHeaderText)){
            System.out.println("Header text value PASS!!!");
        }else{
            System.out.println("Header text value FAIL!!!");
        }

     driver.close();





    }

}
