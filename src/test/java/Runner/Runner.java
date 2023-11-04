package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Feature", 
                 glue = { "StepDefinition","Hooks" },
                 tags = "@Usermanagement", 
                 monochrome = true, 
                 plugin = { "pretty", "html:target/cucumber-reports/cucumber.html",
				            "json:target/cucumber-reports/cucumber.json" })

public class Runner {

}
