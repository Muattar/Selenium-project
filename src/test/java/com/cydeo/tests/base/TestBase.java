package com.cydeo.tests.base;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

//this class is parent class of all Test classes
//we can update this class based on what you are keep writing in your most test classes
//instead writing in all test classes, we can use this class and
// we can extend this class from any test classes
public abstract class TestBase{

  protected WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
