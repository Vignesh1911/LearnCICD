package utils;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.io.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotUtilForExtentReport {

	public static String captureScreenshot(WebDriver driver, String testName) {
        String path = System.getProperty("user.dir") + "/screenshots/" + testName + ".png";
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File(path);

        try {
            FileHandler.copy(src, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }
}
