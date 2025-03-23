package br.com.amazon.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "br.com.amazon.steps",
        plugin = {"pretty", "html:target/report.html"},
        monochrome = true
)
public class TestRunner {
}
