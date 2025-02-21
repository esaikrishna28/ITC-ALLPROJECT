package cucumbertests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;


//@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/login.feature",
    glue = {"cucumbertests"},
    plugin = {"html:target/cucumber-reports"},
    monochrome = true
)



public class TestRunnerClass extends AbstractTestNGCucumberTests {

}
