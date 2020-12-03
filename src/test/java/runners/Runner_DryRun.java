package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;


@Listeners(utilities.TestNGListener.class)

@CucumberOptions(
        features = {"src/test/java/features"},
        glue = {"stepdefs"},
        dryRun = true
)

public class Runner_DryRun extends AbstractTestNGCucumberTests {


    @AfterTest
    public void tearDown(){

    }


}
