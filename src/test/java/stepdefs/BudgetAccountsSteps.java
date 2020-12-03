package stepdefs;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageModels.NavBarObjects;
import pageModels.NotificationResults;
import pages.BudgetAccountsPage;

import java.util.Map;

public class BudgetAccountsSteps {

    String textToSearch;
    int categotyToSearch;
    BudgetAccountsPage bp = new BudgetAccountsPage();

    @Given("^user on budget accounts page$")
    public void userOnCountriesPage() {
        if (!bp.userOnSameThePage(NavBarObjects.BudgetAccounts)) {
            bp.getPage();
        }
    }

    @And("^user navigate to budget accounts page$")
    public void userNavigateToBudgetAccountsPage() {
        bp.getPage();
    }

    @When("^user create a budget account as follows$")
    public void userCreateABudgetAccountAsFollows(DataTable dataTable) {
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        bp.add(map);
        textToSearch = map.get("name");
        categotyToSearch = Integer.parseInt(map.get("category"));
    }

    @Then("^budget account should be created$")
    public void budgetAccountShouldBeCreated() {
        bp.exists(textToSearch, categotyToSearch, true);
        //bp.notificationResult(NotificationResults.Created);
    }

    @When("^user delete the budget account named as \"([^\"]*)\" under category (\\d+)$")
    public void userDeleteTheBudgetAccountNamedAsUnderCategory(String name, int category) {
        bp.getPage();
        bp.delete(name, category);
        textToSearch = name;
        categotyToSearch = category;
    }

    @Then("^budget account should be deleted$")
    public void budgetAccountShouldBeDeleted() {
        bp.exists(textToSearch, categotyToSearch, false);
        //bp.notificationResult(NotificationResults.Deleted);
    }

}
