package com.cydeo.tests.extraTask;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class FaceBookVerify {

    public static void main(String[] args) throws InterruptedException {

       // TC #1: Facebook title verification
       // 1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // 2. Go to https://www.facebook.com
        driver.get("https://www.facebook.com");

        Thread.sleep(2000);

       // 3. Verify title:
       // Expected: “Facebook – log in or sign up”
        String expectedTitle = "Facebook - log in or sign up";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title PASS!!!");
        }else {
            System.out.println("expectedTitle = " + expectedTitle);
            System.out.println("actualTitle = " + actualTitle);

            System.out.println("Title FAIL!!!");
        }

        driver.close();



    }

}
