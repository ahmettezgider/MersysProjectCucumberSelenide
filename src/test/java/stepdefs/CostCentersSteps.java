package stepdefs;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageModels.NavBarObjects;
import pageModels.NotificationResults;
import pages.CostCentersPage;

import java.util.Map;

public class CostCentersSteps {

    String textToSearch;
    CostCentersPage cs = new CostCentersPage();

    @Given("^user on cost centers page$")
    public void userOnCountriesPage() {
        if (!cs.userOnSameThePage(NavBarObjects.CostCenters)) {
            cs.getPage();
        }
    }

    @And("^user navigate to cost centers page$")
    public void userNavigateToCostCentersPage() {
        cs.getPage();
    }

    @When("^user create a cost center as follows$")
    public void userCreateACostCenterAsFollows(DataTable dataTable) {
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        String name = map.get("name");
        String code = map.get("code");
        String type = map.get("type");
        int orderNo = Integer.parseInt(map.get("orderNo"));
        String key = map.get("key");
        String value = map.get("value");
        int expense = Integer.parseInt(map.get("expense"));

        String typeStr="";
        int typeInt=-1;
        try{
            typeInt = Integer.parseInt(type);
        }catch (Exception e){
            typeStr = type;
        }
        if (typeInt>-1)
            cs.add(name, code, typeInt, orderNo, key, value, expense);
        else
            cs.add(name, code, typeStr, orderNo, key, value, expense);

        textToSearch = name;

    }

    @Then("^cost center should be created$")
    public void costCenterShouldBeCreated() {
        cs.exists(textToSearch, true);
        //cs.notificationResult(NotificationResults.Created);
    }

    @When("^user update the cost center name as \"([^\"]*)\" as follows$")
    public void userUpdateTheCostCenterNameAsAsFollows(String oldName, DataTable dataTable) {
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        String name = map.get("name");
        String code = map.get("code");
        String type = map.get("type");
        int orderNo = Integer.parseInt(map.get("orderNo"));
        String key = map.get("key");
        String value = map.get("value");
        int expense = Integer.parseInt(map.get("expense"));

        String typeStr="";
        int typeInt=-1;
        try{
            typeInt = Integer.parseInt(type);
        }catch (Exception e){
            typeStr = type;
        }
        if (typeInt>-1)
            cs.update(oldName, name, code, typeInt, orderNo, key, value, expense);
        else
            cs.update(oldName, name, code, typeStr, orderNo, key, value, expense);
        textToSearch = name;
    }

    @Then("^cost center should be updated$")
    public void costCenterShouldBeUpdated() {
        cs.exists(textToSearch, true);
    }

    @When("^user delete the cost center named as \"([^\"]*)\"$")
    public void userDeleteTheCostCenterNamedAs(String name) {
        cs.delete(name);
        textToSearch = name;
    }

    @Then("^cost center should be deleted$")
    public void costCenterShouldBeDeleted() {
        cs.exists(textToSearch, false);
    }
}
