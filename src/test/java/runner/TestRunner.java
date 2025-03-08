package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/FeatureFiles",glue={"StepDefinitions"},  plugin = {"pretty",
		"json:target/cucumber-report.json",          // This generates the JSON report (optional)
		"junit:target/cucumber-results.xml"          // This generates the JUnit XML report (essential)
},monochrome=true,publish=true)
public class TestRunner extends AbstractTestNGCucumberTests{
	@Override
    @DataProvider(parallel=true)
	public Object[][] scenarios(){
		return super.scenarios();
	}
}
