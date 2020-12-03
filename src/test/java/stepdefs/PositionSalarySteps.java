package stepdefs;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageModels.NavBarObjects;
import pageModels.NotificationResults;
import pages.PositionSalaryPage;

import java.util.Map;

public class PositionSalarySteps {

    PositionSalaryPage pSal = new PositionSalaryPage();

    @Given("^user on position salary page$")
    public void userOnCountriesPage() {
        if (!pSal.userOnSameThePage(NavBarObjects.PositionSalary)) {
            pSal.getPage();
        }
    }

    @And("^user navigate to position salary page$")
    public void userNavigateToPositionSalary() {
        pSal.getPage();
    }

    @When("^user create a person to position salary name as \"([^\"]*)\"$")
    public void userCreateAPositionSalaryNameAs(String name) {
        pSal.add(name);
    }

    @Then("^person in position salary should be created$")
    public void personInPositionSalaryShouldBeCreated() {
        pSal.justifyNotificationAs(NotificationResults.created);
    }

    @When("^user update the person in position salary named \"([^\"]*)\" to name as \"([^\"]*)\"$")
    public void userUpdateThePositionSalaryNamedToNameAs(String oldName, String newName) {
        pSal.update(oldName, newName);
    }

    @Then("^person in position salary should be updated$")
    public void personInPositionSalaryShouldBeUpdated() {
        pSal.justifyNotificationAs(NotificationResults.updated);
    }

    @When("^user delete the person in position salary named as \"([^\"]*)\"$")
    public void userDeleteThePositionSalaryNamedAs(String name)  {
        pSal.delete(name);
    }

    @Then("^person in position salary should be deleted$")
    public void personInPositionSalaryShouldBeDeleted() {
        pSal.justifyNotificationAs(NotificationResults.deleted);
    }

    @When("^user edit the person in position salary named \"([^\"]*)\"$")
    public void userEditThePositionSalaryNamed(String name)  {
        pSal.editTheTableData(name);
    }

    @When("^user add position salary to the name \"([^\"]*)\" as follows$")
    public void userAddPositionSalaryToTheNameAsFollows(String name, DataTable dataTable)  {
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        String experience = map.get("experience");
        String from = map.get("fromDate");
        String salary = map.get("salary");
        String currency = map.get("currency");
        pSal.clickToAddPositionSalary(name);
        pSal.addPositionSalaryTo(experience, from, salary, currency);
    }

    @Then("^position salary should be created$")
    public void positionSalaryShouldBeCreated() {
        pSal.notificationResult(NotificationResults.created);
    }

    @When("^user update position salary to the name \"([^\"]*)\" as follows$")
    public void userUpdatePositionSalaryToTheNameAsFollows(String name, DataTable dataTable) {
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        String experience = map.get("experience");
        String from = map.get("fromDate");
        String salary = map.get("salary");
        String currency = map.get("currency");
        pSal.clickToAddPositionSalary(name);
        pSal.updatePositionSalaryTo(experience, from, salary, currency);
    }

    @Then("^position salary should be updated$")
    public void positionSalaryShouldBeUpdated() {
        pSal.justifyNotificationAs(NotificationResults.updated);
    }

    @Then("^position salary should be added$")
    public void positionSalaryShouldBeAdded() {
        pSal.justifyNotificationAs(NotificationResults.added);
    }

    @When("^user delete position salary belogs to person named \"([^\"]*)\" with the text \"([^\"]*)\"$")
    public void userDeletePositionSalaryBelogsToPersonNamedWithTheText(String name, String text) {
        pSal.clickToAddPositionSalary(name);
        pSal.deleteTheTableData(text);
    }

    @Then("^position salary should be deleted$")
    public void positionSalaryShouldBeDeleted() {
        pSal.justifyNotificationAs(NotificationResults.deleted);
    }
}
