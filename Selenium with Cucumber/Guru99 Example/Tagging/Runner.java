package execution;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Features", glue = { "stepDefinition" }, plugin = { "html:target/cucumber-html-report",
		"pretty:target/cucumber-pretty.txt", "usage:target/cucumber-usage.json",
		"junit:target/cucumber-results.xml" }, dryRun = false, tags = { "@End2EndTest" })
public class Runner {

}

/*When you want to execute test cases taggged as Smoke Test or Regression Test then
 * tags = {"@SmokeTest , @RegressionTest"}
 * 
 * When you want to execute test cases taggged as both Smoke Test and Regression Test then
 * tags = {"@SmokeTest" , "@RegressionTest"}
 * 
 * When you want to ignore a test case
 * 
 * tags = {"~@SmokeTest"}
 * 
 * */


