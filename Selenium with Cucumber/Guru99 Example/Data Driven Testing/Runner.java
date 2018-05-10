package TestRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="Features",
				 glue={"StepDefinition"}, 
				 plugin={"html:target/cucumber-html-report", "pretty:target/cucumber-pretty.txt",
						 "usage:target/cucumber-usage.json","junit:target/cucumber-results.xml"})
public class Runner {
	
}

