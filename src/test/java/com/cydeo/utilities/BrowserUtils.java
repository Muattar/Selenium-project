package com.cydeo.utilities;

//This class will be storing the utility method that can be used across the project

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Set;

public class BrowserUtils {

    /*
    This method will except integer in second and execute
          Thread.sleep method for given duration
          Arg: int argument

     */
      public  static void sleep(int second){
          second *= 1000;
          try {
              Thread.sleep(second);
          }catch (InterruptedException e){

          }
      }

      public static void switchWindowAndVerify(WebDriver driver, String expectedInUrl, String expectedInTitle){

          //return and store all window handles in a Set
          Set<String> allWindowHandle = driver.getWindowHandles();

          for (String each : allWindowHandle) {
              driver.switchTo().window(each);
              System.out.println("Current url: " + driver.getCurrentUrl());

              if (driver.getCurrentUrl().contains(expectedInUrl)){
                  break;
              }

          }

          // Assert: Title contains “in browse”

          String actualTitle = driver.getTitle();

          Assert.assertTrue(actualTitle.contains( expectedInTitle));

      }


      public static void verifyTitle(WebDriver driver, String expectedTitle) {

          Assert.assertEquals(driver.getTitle(), expectedTitle);
      }

      public static void verifyTitleContains(WebDriver driver, String expectedInTitle){


          Assert.assertTrue(driver.getTitle().contains(expectedInTitle));

      }

}


