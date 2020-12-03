package stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageModels.NavBarObjects;
import pages.CityPage;

public class CitySteps {

    String textToSearch;
    CityPage cityPage = new CityPage();

    @Given("^user on cities page$")
    public void userOnCountriesPage() {
        if (!cityPage.userOnSameThePage(NavBarObjects.Cities)) {
            cityPage.getPage();
        }
    }

    @And("^user navigate to cities page$")
    public void userNavigateToCityPage() {
        cityPage.getPage();
    }

    @When("^user create a city name as \"([^\"]*)\" that belong to the country \"([^\"]*)\"$")
    public void userCreateACityNameAsThatBelongToTheCountry(String cityName, String countryName) {
        cityPage.add(countryName, cityName);
        textToSearch = cityName;
    }

    @When("^user create a city which name is \"([^\"]*)\" to the country with option (\\d+)$")
    public void userCreateACityToTheCountryWithOptionWhichNameIs(String cityName, int countryOption) {
        cityPage.add(countryOption, cityName);
        textToSearch = cityName;
    }

    @Then("^city should be created$")
    public void cityShouldBeCreated() {
        cityPage.exists(textToSearch, true);
    }

    @When("^user delete the city named as \"([^\"]*)\"$")
    public void userDeleteTheCityNamedAs(String name) {
        cityPage.delete(name);
        textToSearch = name;
    }

    @Then("^city should be deleted$")
    public void cityShouldBeDeleted() {
        cityPage.exists(textToSearch, false);
    }

    @Then("^city should be updated$")
    public void cityShouldBeUpdated() {
        cityPage.exists(textToSearch, true);
    }

}
