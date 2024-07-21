package TestRunner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)

@CucumberOptions(
		features = ".//Features/MediarelFeature.feature",
		glue="StepDefinition",
		dryRun= false,
		monochrome= true,
		plugin = {"pretty", "html:target/Cucumber-reports/reports.html"}
		)

public class Run {
	

}
