package runners;


import org.testng.annotations.*;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@Listeners(utilities.TestNGListener.class)

@CucumberOptions(
        tags = {"@Navigation"},
        features = {"src/test/java/features"},
        glue = {"stepdefs"},
        plugin = {
                "com.cucumber.listener.ExtentCucumberFormatter:" +
                        "target/ExtentReport/Runner_NavigateOnMenu.html"
        }
)

public class Runner_NavigateOnMenu extends AbstractTestNGCucumberTests {


    @AfterClass
    public static void afterClass() {

        Reporter.loadXMLConfig("src/test/java/XMLFiles/extentReport.xml");
        Reporter.setSystemInfo("User Name", "Grup-4");
        Reporter.setSystemInfo("Application Name", "Basqar");
        Reporter.setSystemInfo("Operating System Info", System.getProperty("os.name"));
        Reporter.setSystemInfo("Department", "QA-4");
        Reporter.setSystemInfo("Project Name", "Proficiency Project");
        Reporter.setSystemInfo("Test Modüle", "Test NG, Selenium, Selenide");
        Reporter.setSystemInfo("Test Language", "Java, Cucumber");

    }

}
