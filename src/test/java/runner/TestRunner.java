package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/resources/features"},
				glue ="steps",	
				dryRun = false,
				monochrome =true,
				plugin= {"pretty","json:target/cucumber.json","html:target/results.html"},
				tags ="@E2E"
		)


public class TestRunner {

}
