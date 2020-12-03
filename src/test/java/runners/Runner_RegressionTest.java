package runners;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.*;


@Listeners(utilities.TestNGListener.class)

@CucumberOptions(
        tags = {"@Regression"},
        features = {"src/test/java/features"},
        glue = {"stepdefs"},
        plugin = {
                "com.cucumber.listener.ExtentCucumberFormatter:" +
                        "target/ExtentReport/Runner_RegressionTest.html"
        }
)

public class Runner_RegressionTest extends AbstractTestNGCucumberTests {

    @BeforeSuite
    public void beforeSuite(){

    }

    @AfterSuite
    public void afterSuite(){
    }


    @AfterClass
    public static void afterClass() {

        Reporter.loadXMLConfig("src/test/java/XMLFiles/extentReport.xml");
        Reporter.setSystemInfo("User Name", "Grup-4");
        Reporter.setSystemInfo("Application Name", "Basqar");
        Reporter.setSystemInfo("Operating System Info", System.getProperty("os.name"));
        Reporter.setSystemInfo("Department", "QA-4");
        Reporter.setSystemInfo("Project Name", "SDET Proficiency Project");
        Reporter.setSystemInfo("Test Modüle", "Test NG, Selenium, Selenide");
        Reporter.setSystemInfo("Test Language", "Java, Cucumber");
    }

    @AfterTest
    public void tearDown(){

    }


}
