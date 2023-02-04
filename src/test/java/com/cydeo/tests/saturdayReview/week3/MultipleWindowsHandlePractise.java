package com.cydeo.tests.saturdayReview.week3;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindowsHandlePractise extends TestBase {

    //TC:Windows handle practice
    //1. Open browser
    //2. Go to website: https://demoqa.com/browser-windows
    //3. Click on New Tb button
    //4. Click on New Window button
    //5. Click on New Window Message button
    //6. Store parent window handle id in a veriable
    //7. Store all window handle id in a variable
    //8. Print out each window title

    @Test

    public void multiple_Windows_Handle_Test(){
        //TC:Windows handle practice
        //1. Open browser
        //2. Go to website: https://demoqa.com/browser-windows
        driver.get(ConfigurationReader.getProperty("demo.qa.url"));


        //3. Click on New Tb button
        WebElement newTab = driver.findElement(By.id("tabButton"));
        newTab.click();

        //4. Click on New Window button
        WebElement newWindow = driver.findElement(By.xpath("//button[@id='windowButton']"));
        newWindow.click();


        //5. Click on New Window Message button
        WebElement newWindowMessage = driver.findElement(By.id("messageWindowButton"));
        newWindowMessage.click();


        //6. Store parent window handle id in a variable
        System.out.println("driver.getTitle() = " + driver.getTitle());
        String mainWindow = driver.getWindowHandle();


        //7. Store all window handle id in a variable
        Set<String> allWindows = driver.getWindowHandles();


        //8. Print out each window title
        for (String eachWindow : allWindows) {
            driver.switchTo().window(eachWindow);
            System.out.println("eachWindow = " + eachWindow);
            System.out.println("driver.getTitle() = " + driver.getTitle());
        }
    }



}
