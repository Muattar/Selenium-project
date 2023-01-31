package com.cydeo.tests.day6_alerts_iframe_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T1_T2_T3Alert_Practices {

    //TC #1: Information alert practice
    //1. Open browser
    //2. Go to website: http://practice.cydeo.com/javascript_alerts
    //3. Click to “Click for JS Alert” button
    //4. Click to OK button from the alert
    //5. Verify “You successfully clicked an alert” text is displayed.

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        //1. Open browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //2. Go to website: http://practice.cydeo.com/javascript_alerts
        driver.get("http://practice.cydeo.com/javascript_alerts");
    }

    @Test
    public void information_Alert_Test1() throws InterruptedException {

        //3. Click to “Click for JS Alert” button
        WebElement JSButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        Thread.sleep(2000);
        JSButton.click();
        Thread.sleep(2000);

        //4. Click to OK button from the alert
        Alert alert = driver.switchTo().alert();
        alert.accept();

        //5. Verify “You successfully clicked an alert” text is displayed.
        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));

        Assert.assertTrue(resultText.isDisplayed(), "Result text is not displayed!");

        String expectedText = "You successfully clicked an alert";
        String actualText = resultText.getText();

        Assert.assertEquals(actualText, expectedText, "Actual result is not as expected!!");


    }
//TC #2: Confirmation alert practice
//1. Open browser
//2. Go to website: http://practice.cydeo.com/javascript_alerts
//3. Click to “Click for JS Confirm” button
//4. Click to OK button from the alert
//5. Verify “You clicked: Ok” text is displayed.

    @Test
    public void confirmation_Alert_Test2() throws InterruptedException {

        //3. Click to “Click for JS Confirm” button

        WebElement jsConfirm = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        Thread.sleep(2000);
        jsConfirm.click();
        Thread.sleep(2000);

        //4. Click to OK button from the alert
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);


        alert.accept();

        //5. Verify “You clicked: Ok” text is displayed.
        WebElement resultText = driver.findElement(By.xpath("//p[.='You clicked: Ok']"));
        Assert.assertTrue(resultText.isDisplayed(), "Result text is not a displayed!!");

    }
//TC #3: Information alert practice
//1. Open browser
//2. Go to website: http://practice.cydeo.com/javascript_alerts
//3. Click to “Click for JS Prompt” button
//4. Send “hello” text to alert
//5. Click to OK button from the alert
//6. Verify “You entered: hello” text is displayed.

     @Test
     public void prompt_Alert_Test3() throws InterruptedException {
         //3. Click to “Click for JS Prompt” button
         WebElement jsProp = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
         jsProp.click();

         //4. Send “hello” text to alert
         Alert alert = driver.switchTo().alert();
         Thread.sleep(2000);
         alert.sendKeys("hello");
         Thread.sleep(2000);

         //5. Click to OK button from the alert
         alert.accept();
         Thread.sleep(2000);

         //6. Verify “You entered: hello” text is displayed.
         WebElement displayText = driver.findElement(By.xpath("//p[@id='result']"));
         Assert.assertTrue(displayText.isDisplayed());
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }



}
