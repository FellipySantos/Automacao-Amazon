package br.com.amazon.steps;

import br.com.amazon.utils.DriverManager;
import br.com.amazon.utils.ScreenshotUtils;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
public class Hooks {
    @After()
    public void tearDown(Scenario scenario) {
        WebDriver driver = DriverManager.getDriver();
        ScreenshotUtils.captureScreenshot(driver, scenario.getName());
        // Encerra o driver
        DriverManager.quitDriver();
    }

}
