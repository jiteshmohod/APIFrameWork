package cucumber.options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features" ,glue ="stepDefinations",tags = "@AddPlace or @DeletePlace")
public class TestRunner {

	
}
