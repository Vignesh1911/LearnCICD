package utils;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.*;
import org.apache.commons.io.FileUtils;

public class ScreenshotUtil {

 public static void takeScreenshot(WebDriver driver, String fileName) {
     File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
     File destFile = new File("screenshots/" + fileName + ".png");
     try {
         FileUtils.copyFile(srcFile, destFile);
         System.out.println("Screenshot saved as: " + destFile.getAbsolutePath());
     } catch (IOException e) {
         System.out.println("Failed to save screenshot");
     }
 }
}
