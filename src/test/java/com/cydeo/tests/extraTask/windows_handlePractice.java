package com.cydeo.tests.extraTask;

import com.cydeo.tests.base.TestBase;
import org.testng.annotations.Test;

public class windows_handlePractice extends TestBase {

    // TC#3 : Windows handle practice
    // 1. Open browser
    // 2. Go to website: https://demoqa.com/browser-windows
    // 3. Click on New Window button
    // 4. Switch to new window
    // 5. Locate and print the message
    // 6. Close the new window
    // 7. Go back to main window

    @Test
    public void handleTest(){
        driver.get("https://demoqa.com/browser-windows");

    }

}
