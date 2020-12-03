package pages;

import com.cucumber.listener.Reporter;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import utilities.ParentClass;


public class Hooks extends ParentClass {

    int i = 1;
    String scenarioName = "";
    @Before
    public void before(Scenario scenario) {
    }

    @After
    public void after(Scenario scenario) {

        if (scenario.isFailed()) {
            Reporter.setTestRunnerOutput("<b>Scenario Failure</b>");
            Reporter.setTestRunnerOutput("<br>Name : " + scenario.getName());
            Reporter.setTestRunnerOutput("<br>Status : " + scenario.getStatus());
            Reporter.setTestRunnerOutput("<br>SourceTagNames : " + scenario.getSourceTagNames());

            if (!scenarioName.equalsIgnoreCase(scenario.getName())){
                i=1;
                scenarioName = scenario.getName();
            }
            takeScreenshot(scenario.getName() + i++);
        }

    }
}
