package com.cydeo.tests.day5TestNg_Dropdown;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T4TestNg_Selenium_IntroPractice {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        // TC #4: Cydeo Title Verification
        //1.Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2.Go to https://www.cydeo.com
        driver.get("https://practice.cydeo.com");

    }


    @Test
    public void test1_cydeo_title_verification(){

        // 3.Verify title:
        // Expected: Cydeo
        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);

    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

}
