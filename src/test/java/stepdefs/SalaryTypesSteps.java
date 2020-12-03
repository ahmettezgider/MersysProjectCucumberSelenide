package stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageModels.NavBarObjects;
import pageModels.NotificationResults;
import pages.SalaryTypesPage;

public class SalaryTypesSteps {

    String textToSearch;
    SalaryTypesPage st = new SalaryTypesPage();

    @Given("^user on salary types page$")
    public void userOnCountriesPage() {
        if (!st.userOnSameThePage(NavBarObjects.SalaryTypes)) {
            st.getPage();
        }
    }


    @And("^user navigate to salary types page$")
    public void userNavigateToSalaryTapesPage() {
        st.getPage();
    }

    @When("^user create a salary type name as \"([^\"]*)\" and user type as \"([^\"]*)\"$")
    public void userCreateASalaryTypeNameAsAndUserTypeAs(String name, String userType)  {
        int userTypeInt = -1;
        try {
            userTypeInt = Integer.parseInt(userType);
        }catch (Exception ignored){ }

        if (userTypeInt > -1)
            st.add(name, userTypeInt);
        else
            st.add(name, userType);
        textToSearch = name;
    }

    @Then("^salary type should be created$")
    public void salaryTypeShouldBeCreated() {
        st.exists(textToSearch, true);
        //st.notificationResult(NotificationResults.Created);
    }

    @When("^user update the salary type named \"([^\"]*)\" to name as \"([^\"]*)\" and user type as \"([^\"]*)\"$")
    public void userUpdateTheSalaryTypeNamedToNameAsAndUserTypeAs(String oldName,
                                                                  String newName,
                                                                  String newUserType)  {
        int newUserTypeInt = -1;
        try {
            newUserTypeInt = Integer.parseInt(newUserType);
        }catch (Exception ignored){ }

        if (newUserTypeInt > -1)
            st.update(oldName, newUserType, newUserTypeInt);
        else
            st.update(oldName, newName, newUserType);

        textToSearch = newName;

    }

    @Then("^salary type should be updated$")
    public void salaryTypeShouldBeUpdated() {
        st.exists(textToSearch, true);
        //st.notificationResult(NotificationResults.Updated);
    }

    @When("^user edit the salary type named \"([^\"]*)\"$")
    public void userEditTheSalaryTypeNamed(String name) {
        st.editTheTableData(name);
        textToSearch = name;
    }

    @When("^user delete the salary type named as \"([^\"]*)\"$")
    public void userDeleteTheSalaryTypeNamedAs(String name) {
        st.delete(name);
        textToSearch = name;
    }

    @Then("^salary type should be deleted$")
    public void salaryTypeShouldBeDeleted() {
        st.exists(textToSearch, false);
        //st.notificationResult(NotificationResults.Deleted);
    }
}
