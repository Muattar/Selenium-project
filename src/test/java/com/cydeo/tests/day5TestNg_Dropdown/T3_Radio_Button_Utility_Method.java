package com.cydeo.tests.day5TestNg_Dropdown;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class T3_Radio_Button_Utility_Method {

    public static void main(String[] args) throws InterruptedException {

        //TC #2: Radiobutton handling
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://practice.cydeo.com/radio_buttons");

//click and verify hockey radio button is selected
        //clickAndVerifyRadioButton(driver, "sport", "hockey" );
clickAndVerifyRadioButton(driver, "color", "red");


/*
Create a utility method to handle above logic.
Method name: clickAndVerifyRadioButton
Return type: void or boolean
Method args:
1. WebDriver
2. Name attribute as String (for providing which group of radio buttons)
3. Id attribute as String (for providing which radio button to be clicked)
Method should loop through the given group of radio buttons. When it finds the
matching option, it should click and verify option is Selected.
Print out verification: true/
 */


    }
    //Locate all-of-the 'sports' radio buttons, and store them in a List<WebElement>

    private static void clickAndVerifyRadioButton(WebDriver driver, String nameAttribute, String expectedID) throws InterruptedException {

        //Locate all-of-the 'sports' radio buttons, and store them in a List<WebElement>
        //List<WebElement> sportsRadioButtons = driver.findElements(By.xpath("//input[@name='"+nameAttribute+"']"));
        List<WebElement> radioButtons = driver.findElements(By.name(nameAttribute));

        for (WebElement each : radioButtons) {
            String actualID = each.getAttribute("id");
            System.out.println("actualID = " + actualID);

            if (actualID.equals(expectedID)){
                each.click();
                System.out.println(actualID + " is Selected: " + each.isSelected() );
                break;
            }
        }

         Thread.sleep(2000);
        driver.close();
    }


}
