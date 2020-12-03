package stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageModels.NavBarObjects;
import pageModels.NotificationResults;
import pages.SubjectCategoriesPage;

public class SubjectCategoriesSteps {

    String textToSearch;
    SubjectCategoriesPage subCatPage = new SubjectCategoriesPage();

    @Given("^user on subject categories page$")
    public void userOnCountriesPage() {
        if (!subCatPage.userOnSameThePage(NavBarObjects.SubjectCategories)) {
            subCatPage.getPage();
        }
    }

    @And("^user navigate to subject categories page$")
    public void userNavigateToSubjectCategoriesPage() {
        subCatPage.getPage();
    }

    @When("^user create a subject category name as \"([^\"]*)\" and code as \"([^\"]*)\"$")
    public void userCreateASubjetCategoryAsAndCodeAs(String name, String code) {
        subCatPage.add(name, code);
        textToSearch = name;
    }

    @Then("^subject category should be created$")
    public void subjetCategoryShouldBeCreated() {
        subCatPage.exists(textToSearch, true);
        //subCatPage.justifyNotificationAs(NotificationResults.Created);
    }

    @When("^user delete the subject category name as \"([^\"]*)\"$")
    public void userDeleteTheSubjectCategoryNameAs(String name) {
        subCatPage.delete(name);
        textToSearch = name;
    }

    @Then("^subject category should be deleted$")
    public void subjectCategoryShouldBeDeleted() {
        subCatPage.exists(textToSearch, false);
        subCatPage.justifyNotificationAs(NotificationResults.deleted);
    }

    @When("^user update the subject category named \"([^\"]*)\" to name as \"([^\"]*)\" and code as \"([^\"]*)\"$")
    public void userUpdateTheSubjectCategoryNamedToNameAsAndCodeAs(String oldName, String newName, String newCode) {
        subCatPage.update(oldName, newName, newCode);
        textToSearch = newName;
    }

    @Then("^subject category should be updated$")
    public void subjectCategoryShouldBeUpdated() {
        subCatPage.exists(textToSearch, true);
        //subCatPage.justifyNotificationAs(NotificationResults.Updated);
    }

    @Then("^subject category should not be deleted$")
    public void subjectCategoryShouldNotBeDeleted() {
        subCatPage.exists(textToSearch, true);
        //subCatPage.notificationResult(NotificationResults.Error);
    }

}
