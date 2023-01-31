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

public class T5_Window_Handle_Practice {

    //TC #5: Window Handle practice
    //1. Create a new class called: T5_WindowsPractice
    //2. Create new test and make setups
    //3. Go to : https://practice.cydeo.com/windows
    //4. Assert: Title is “Windows”
    //5. Click to: “Click Here” link
    //6. Switch to new Window.
    //7. Assert: Title is “New Window”

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        //2. Create new test and make set ups
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //3. Go to : https://practice.cydeo.com/windows
        driver.get("https://practice.cydeo.com/windows");
    }

    @Test
    public void multiple_windows_test() throws InterruptedException {
        //4. Assert: Title is “Windows”
        String expectedTitle = "Windows";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);

        String mainHandle = driver.getWindowHandle();
        System.out.println("mainHandle = " + mainHandle);

        System.out.println(" Title before click: " + driver.getTitle());

        //5. Click to: “Click Here” link
        WebElement clickLink = driver.findElement(By.linkText("Click Here"));
        clickLink.click();
        System.out.println(" Title after click: " + driver.getTitle());
        Thread.sleep(2000);

        //6. Switch to new Window. we need to use driver.getWindowHandles() method
        //driver.getWindowHandles();
        //1-windowHandle : mainHandle
        //2-windowHandle : 2nd window

        for (String each: driver.getWindowHandles()) {
            driver.switchTo().window(each);
            System.out.println("Current title while switching windows: " + driver.getTitle());
        }

        //7. Assert: Title is “New Window”
        String expectedTitleAfterClick = "New Window";
        String actualTitleAfterClick = driver.getTitle();

        Assert.assertEquals(actualTitleAfterClick, expectedTitleAfterClick);

        //if we have to go back to main page to continue our test case we can use
        //     main handle to switch

        driver.switchTo().window(mainHandle);
        //code


    }

    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }

}
