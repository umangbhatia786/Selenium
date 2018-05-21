package execution;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\Umang Bhatia\\eclipse-workspace\\CucumberPOM\\src\\main\\java\\Features\\LoginPage.feature", glue = {
		"stepDefinition" }, plugin = { "html:target/cucumber-html-report", "pretty:target/cucumber-pretty.txt",
				"usage:target/cucumber-usage.json",
				"junit:target/cucumber-results.xml" }, dryRun = false, monochrome = true, strict = true)

public class Runner {

}
