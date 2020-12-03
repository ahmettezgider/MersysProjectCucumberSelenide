package stepdefs;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageModels.NavBarObjects;
import pageModels.NotificationResults;
import pages.SalaryModifiersPage;

import java.util.Map;

public class SalaryModifiersSteps {

    String textToSearch;
    SalaryModifiersPage sm = new SalaryModifiersPage();

    @Given("^user on salary modifiers page$")
    public void userOnCountriesPage() {
        if (!sm.userOnSameThePage(NavBarObjects.SalaryModifiers)) {
            sm.getPage();
        }
    }

    @And("^user navigate to salary modifiers page$")
    public void userNavigateToSalaryModifiersPage() {
        sm.getPage();
    }

    @When("^user create a salary modifier as follows$")
    public void userCreateASalaryModifierAsFollows(DataTable dataTable) {
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        sm.add(map);
        textToSearch = map.get("description");
    }

    @Then("^salary modifier should be created$")
    public void salaryModifierShouldBeCreated() {
        sm.exists(textToSearch, true);
        //sm.notificationResult(NotificationResults.Created);
    }

    @When("^user update the salary modifier named as \"([^\"]*)\" as follows$")
    public void userUpdateTheSalaryModifierNamedAsAsFollows(String oldDesc, DataTable dataTable) {
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        sm.getPage();
        sm.update(oldDesc, map);
        textToSearch = map.get("description");
    }

    @Then("^salary modifier should be updated$")
    public void salaryModifierShouldBeUpdated() {
        sm.exists(textToSearch, true);
        //sm.notificationResult(NotificationResults.Updated);
    }

    @When("^user delete the salary modifier description as \"([^\"]*)\"$")
    public void userDeleteTheSalaryModifierDescriptionAs(String description) {
        sm.getPage();
        sm.delete(description);
        textToSearch = description;
    }

    @Then("^salary modifier should be deleted$")
    public void salaryModifierShouldBeDeleted() {
        sm.exists(textToSearch, false);
        //sm.notificationResult(NotificationResults.Deleted);
    }

}
