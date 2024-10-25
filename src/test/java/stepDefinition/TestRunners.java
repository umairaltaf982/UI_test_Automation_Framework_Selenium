package stepDefinition;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/Features",
        glue = {"stepDefinition"},
        monochrome = true,
        plugin = {
                "pretty",
                "junit:target/JUnitReport.xml",
                "json:target/JsonReport.json",
                "html:target/HtmlReport.html",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        }
)
public class TestRunners {
}
