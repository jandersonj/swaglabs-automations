package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepDefinitions",
        tags = "@Cart",
        plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/Cucumber.json"},
        monochrome = false,
        dryRun = false
)
public class TestRunner extends AbstractTestNGCucumberTests {

     //override
     @Override
     @DataProvider(parallel = true)
     public Object[][] scenarios() {
         return super.scenarios();
     }
}
