package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/FeatureFiles",glue={"StepDefinitions"},monochrome=true,plugin= {"pretty","html:target/cucumber-reports"},publish=true)
public class TestRunner extends AbstractTestNGCucumberTests{
	@Override
    @DataProvider(parallel=true)
	public Object[][] scenarios(){
		return super.scenarios();
	}
}
