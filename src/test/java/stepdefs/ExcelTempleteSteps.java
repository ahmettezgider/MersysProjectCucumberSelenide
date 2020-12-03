package stepdefs;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageModels.NavBarObjects;
import pageModels.NotificationResults;
import pages.ExcelTemplatePage;

import java.util.List;

public class ExcelTempleteSteps {

    String textToSearch;
    ExcelTemplatePage etp = new ExcelTemplatePage();

    @Given("^user on excel templetes page$")
    public void userOnCountriesPage() {
        if (!etp.userOnSameThePage(NavBarObjects.ExcelTemplate)) {
            etp.getPage();
        }
    }

    @And("^user navigate to excel templetes page$")
    public void userNavigateToExcelTempletesPage() {
        etp.getPage();
    }

    @When("^user create a excel templete name as \"([^\"]*)\" and period as (\\d+)$")
    public void userCreateAExcelTempleteNameAsAndPeriodAs(String name, int period)  {
        etp.add(name, period);
        textToSearch = name;
    }

    @Then("^excel templete should be created$")
    public void excelTempleteShouldBeCreated() {
        etp.exists(textToSearch, true);
        //etp.notificationResult(NotificationResults.Created);
    }

    @When("^user create a excel templete name as \"([^\"]*)\" and period as (\\d+) and row and column size as follows$")
    public void userCreateAExcelTempleteNameAsAndPeriodAsAndRowAndColumnSizeAsFollows(String name,
                                                                                      int period,
                                                                                      DataTable dataTable) {
       List<List<String>> lists = dataTable.asLists(String.class);
       etp.add(name, period, lists);
        textToSearch = name;
    }

    @When("^user update the excel templete named \"([^\"]*)\" to name as \"([^\"]*)\" and period as (\\d+)$")
    public void userUpdateTheExcelTempleteNamedToNameAsAndPeriodAs(String oldName,
                                                                   String newName,
                                                                   int newPeriod) {
        etp.update(oldName, newName, newPeriod);
        textToSearch = newName;
    }

    @Then("^excel templete should be updated$")
    public void excelTempleteShouldBeUpdated() {
        etp.exists(textToSearch, true);
        //etp.notificationResult(NotificationResults.Updated);
    }

    @When("^user edit the excel templete named \"([^\"]*)\"$")
    public void userEditTheExcelTempleteNamed(String name) {
        etp.edit(name);
    }

    @When("^user delete the excel templete named as \"([^\"]*)\"$")
    public void userDeleteTheExcelTempleteNamedAs(String name) {
        etp.delete(name);
        textToSearch = name;
    }

    @Then("^excel templete should be deleted$")
    public void excelTempleteShouldBeDeleted() {
        etp.exists(textToSearch, false);
        //etp.notificationResult(NotificationResults.Deleted);
    }
}
