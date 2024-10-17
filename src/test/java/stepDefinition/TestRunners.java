package stepDefinition;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/Features", glue = {"stepDefinition"},
        monochrome = true,
        plugin = {"pretty", "junit:target/JUnitReport.xml", "pretty", "json:target/JsonReport.json", "pretty", "html:target/HtmlReport.html"}
)
public class TestRunners {

}
