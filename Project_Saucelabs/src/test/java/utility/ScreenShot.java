package utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShot{

    public static void takeScreenShot(WebDriver driver, String testName) {
        // 1. Create a unique timestamp (e.g., 20261028_234500)
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        
        // 2. Convert WebDriver object to TakeScreenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        
        // 3. Capture the screenshot file
        File source = ts.getScreenshotAs(OutputType.FILE);
        
        // 4. Define where to save it (Project Root Folder / screenshots / TestName_TimeStamp.png)
        String destination = System.getProperty("user.dir") + "/screenshots/" + testName + "_" + timeStamp + ".png";
        
        try {
            // 5. Copy file to the destination folder
            FileUtils.copyFile(source, new File(destination));
            System.out.println("Screenshot saved successfully at: " + destination);
        } catch (IOException e) {
            System.out.println("Exception while taking screenshot: " + e.getMessage());
        }
    }
}