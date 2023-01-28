package com.cydeo.tests.extraTask;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class GoogleFaceBookCheck {

    public static void main(String[] args) throws InterruptedException {


        //TC #2: Title and Url check
      // 1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

       //2. Go to https://www.facebook.com
        driver.get("https://www.facebook.com");

       //3. Verify url contains facebook
        String expectedUrl = "facebook";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrl)){
            System.out.println("Facebook Url PASS!!!");
        }else{
            System.out.println("Facebook Url FAIL!!!");
        }

        //4. Verify title contains Facebook
        String expectedTile = "Facebook";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTile)){
            System.out.println("Facebook Title PASS!!!");
        }else{
            System.out.println("Facebook Title FAIL!!!");
        }

       //5. Navigate to https://www.google.com
        driver.navigate().to("https://www.google.com");

        Thread.sleep(2000);

        //6. Verify url contains google
        String expectedGoogleUrl = "google";
        String actualGoogleUrl = driver.getCurrentUrl();

        if (actualGoogleUrl.contains(expectedGoogleUrl)){
            System.out.println("Google url PASS!!!");
        }else{
            System.out.println("Google url FAIL!!!");
        }


      // 7. Verify title contains Google
        String expectedGoogleTile = "Google";
        String actualGoogleTitle = driver.getTitle();

        if (actualGoogleTitle.contains(expectedGoogleTile)){
            System.out.println("Google title PASS!!!");
        }else{
            System.out.println("Google title FAIL!!!");
        }

      // 8. Navigate back
        driver.navigate().back();

       //9. Verify url contains facebook
        if (actualUrl.contains(expectedUrl)){
            System.out.println("Facebook Url PASS!!!");
        }else{
            System.out.println("Facebook Url FAIL!!!");
        }

        // 10.Navigate forward
        driver.navigate().forward();

     // 11.Verify url contains google

        if (actualGoogleUrl.contains(expectedGoogleUrl)){
            System.out.println("Google url PASS!!!");
        }else{
            System.out.println("Google url FAIL!!!");
        }
        Thread.sleep(2000);

        driver.close();

    }

}
