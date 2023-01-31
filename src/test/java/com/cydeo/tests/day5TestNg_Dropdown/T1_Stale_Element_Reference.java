package com.cydeo.tests.day5TestNg_Dropdown;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.*;

import java.time.Duration;

public class T1_Stale_Element_Reference {

    public static void main(String[] args) throws InterruptedException {

        //TC #1: StaleElementReferenceException handling
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //2. Go to https://practice.cydeo.com/add_remove_elements/
        driver.get("https://practice.cydeo.com/add_remove_elements/");

        //3. Click to “Add Element” button
        WebElement addElementButton = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        addElementButton.click();

        //4. Verify “Delete” button is displayed after clicking.
        WebElement deleteButton = driver.findElement(By.xpath("//button[.='Delete']"));
        System.out.println("deleteButton.isDisplayed(), expecting TRUE = " + deleteButton.isDisplayed());

        //5. Click to “Delete” button.
        Thread.sleep(2000);
        deleteButton.click();

        //6. Verify “Delete” button is NOT displayed after clicking.
        try {
            System.out.println("deleteButton.isDisplayed(), expecting FALSE = " + deleteButton.isDisplayed());

        }catch(StaleElementReferenceException e){
            System.out.println("--> StaleElementReferenceException happened due to element being deleted from the page");
            System.out.println("Which concludes our test cases PASSING!");
            System.out.println("deleteButton.isDisplayed(),  FALSE " );

        }

        //use try/catch to handle and verify

driver.close();
    }

}
