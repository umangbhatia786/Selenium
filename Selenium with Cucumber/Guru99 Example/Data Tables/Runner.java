
package TestRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:/UBS/Dev/CucumberMaven/Features/deals.feature",
				 glue={"C:/UBS/Dev/CucumberMaven/src/test/java/StepDefinition/dealSteps.java"}, 
				 plugin={"html:target/cucumber-html-report", "pretty:target/cucumber-pretty.txt",
						 "usage:target/cucumber-usage.json","junit:target/cucumber-results.xml"},
				 dryRun = false)

public class Runner {
	
}
