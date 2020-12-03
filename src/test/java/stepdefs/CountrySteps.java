package stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageModels.Buttons;
import pageModels.NavBarObjects;
import pages.CountryPage;
import utilities.MyUtils;


public class CountrySteps extends MyUtils {

    String textToSearch;
    CountryPage countryPage = new CountryPage();

    @Given("^user on countries page$")
    public void userOnCountriesPage() {
        if (!countryPage.userOnSameThePage(NavBarObjects.Countries)) {
            countryPage.getPage();
        }
    }

    @And("^user navigate to countries page$")
    public void userNavigateToCountriesPage() {
        countryPage.getPage();
    }

    @When("^user create a country name as \"([^\"]*)\" and code as \"([^\"]*)\"$")
    public void userCreateACountryNameAsAndCodeAs(String country, String code) {
        countryPage.add(country, code);
        textToSearch = country;
    }

    @Then("^country should be created$")
    public void countryShouldBeCreated() {
        countryPage.exists(textToSearch, true);
    }

    @When("^user edit the country named \"([^\"]*)\"$")
    public void userEditThe(String country) {
        countryPage.editTheTableData(country);
        textToSearch = country;
    }

    @And("^click to \"([^\"]*)\" button on dialog$")
    public void clickToButtonOnDialog(String buttonString)  {
        Buttons button = countryPage.getButtonFromText(buttonString);
        countryPage.clickToDialogButton(button);
    }

    @When("^user delete the country named as \"([^\"]*)\"$")
    public void userDeleteTheCountryNameAs(String country) {
        countryPage.delete(country);
        textToSearch = country;
    }

    @Then("^country should be deleted$")
    public void countryShouldBeDeleted() {
        countryPage.exists(textToSearch, false);
    }

    @When("^user update the country named \"([^\"]*)\" to name as \"([^\"]*)\" and code as \"([^\"]*)\"$")
    public void userUpdateCountryNewAsNameAndNewCode(String oldCountry, String newCountry, String newCode)  {
        countryPage.update(oldCountry, newCountry, newCode);
        textToSearch = newCountry;
    }

    @Then("^country should be updated$")
    public void countryShouldBeUpdated() {
        countryPage.exists(textToSearch, true);
    }

    @Then("^country should not be deleted$")
    public void countryShouldNotBeDeleted() {
        countryPage.exists(textToSearch, true);
    }

}
