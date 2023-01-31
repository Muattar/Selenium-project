package com.cydeo.tests.day6_alerts_iframe_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T4_Iframe_Task {

    //TC #4: Iframe practice
    //1. Create a new class called: T4_Iframes
    //2. Create new test and make set ups
    //3. Go to: https://practice.cydeo.com/iframe
    //4. Assert: “Your content goes here.” Text is displayed.
    //5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor”

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        //2. Create new test and make set ups
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //3. Go to: https://practice.cydeo.com/iframe
        driver.get("https://practice.cydeo.com/iframe");

    }

    @Test
    public void iframe_Test(){

        //we have to switch to iframe to be able to locate the web elements in there
        //option1 - switch "id" attribute value
        driver.switchTo().frame("mce_0_ifr");

        //option2 = switch using "index" number
       // driver.switchTo().frame(0);

        //option3 = switch using Webelement
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id=['mce_0_ifr']")));

        WebElement textDisplay = driver.findElement(By.xpath("//p[.='Your content goes here.']"));

        //4. Assert: “Your content goes here.” Text is displayed.
        Assert.assertTrue(textDisplay.isDisplayed());

        //5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor”
        driver.switchTo().parentFrame();
        //driver.switchTo().defaultContent();

        WebElement containEditor = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(containEditor.isDisplayed());


    }

@AfterMethod
    public void tearDownMethod(){
        driver.quit();
}


}
