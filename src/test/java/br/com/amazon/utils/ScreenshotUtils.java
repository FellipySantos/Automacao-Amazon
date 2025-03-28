package br.com.amazon.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {

    public static String captureScreenshot(WebDriver driver, String testName) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotPath = "target/screenshots/" + testName + "_" + timestamp + ".png";
        File destFile = new File(screenshotPath);
        destFile.getParentFile().mkdirs();
        try {
            Files.copy(srcFile.toPath(), destFile.toPath());
        } catch (IOException e) {
            System.out.println("screenshot error: " + e.getMessage());
        }

        return screenshotPath;
    }
}