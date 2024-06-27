package c1;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		   features="src/test/java/c1/f1.feature",
		   glue="c1",
		   tags="@login"
		)
public class TestRunner {

}
