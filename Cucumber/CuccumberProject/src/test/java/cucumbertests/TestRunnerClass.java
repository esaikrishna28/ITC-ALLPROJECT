package cucumbertests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
features={"src/test/resources/webshoploginall.feature","src/test/resources/login.feature"},
glue="cucumbertests",
plugin= {"pretty","html:target/cucumber-reports"}

		
		
)



public class TestRunnerClass extends AbstractTestNGCucumberTests {

}
