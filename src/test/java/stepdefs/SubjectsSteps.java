package stepdefs;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageModels.NavBarObjects;
import pageModels.NotificationResults;
import pages.SubjectsPage;

import java.util.Map;

public class SubjectsSteps {

    String textToSearch;
    SubjectsPage subPage = new SubjectsPage();

    @Given("^user on subjects page$")
    public void userOnCountriesPage() {
        if (!subPage.userOnSameThePage(NavBarObjects.Subjects)) {
            subPage.getPage();
        }
    }

    @And("^user navigate to subjects page$")
    public void userNavigateToSubjectsPage() {
        subPage.getPage();
    }

    @When("^user create a subject as follows$")
    public void userCreateASubjectAsFollows(DataTable dataTable) {
        Map<String, String> map = dataTable.asMap(String.class, String.class);

        String name="", code="", categoryStr="";
        int categoryInt=0, style=0;

        for(Map.Entry entry : map.entrySet()){
            if (entry.getKey().toString().contains("name"))
                name = entry.getValue().toString();
            else if (entry.getKey().toString().contains("code"))
                code = entry.getValue().toString();
            else if (entry.getKey().toString().contains("category")) {
                try {
                    categoryInt = Integer.parseInt(entry.getValue().toString());
                }catch (Exception e){
                    categoryStr = entry.getValue().toString();
                }

            } else if (entry.getKey().toString().contains("style"))
                try {
                    style = Integer.parseInt(entry.getValue().toString());
                }catch (Exception e){
                    style = 1;
                }
        }
        if (categoryInt!=0)
            subPage.add(name, code, categoryInt, style);
        else
            subPage.add(name, code, categoryStr, style);

        textToSearch = name;
    }

    @Then("^subject should be created$")
    public void subjectShouldBeCreated() {
        subPage.exists(textToSearch, true);
        //subPage.notificationResult(NotificationResults.Created);
    }

    @When("^user delete the subject name as \"([^\"]*)\"$")
    public void userDeleteTheSubjectNameAs(String name)  {
        subPage.delete(name);
        textToSearch = name;
    }

    @Then("^subject should be deleted$")
    public void subjectShouldBeDeleted() {
        subPage.exists(textToSearch, false);
        //subPage.notificationResult(NotificationResults.Deleted);
    }

}
