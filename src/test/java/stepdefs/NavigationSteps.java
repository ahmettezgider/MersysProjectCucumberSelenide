package stepdefs;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageModels.BrowserSize;
import pageModels.NavBarObjects;
import pages.HomePage;

import java.util.List;

public class NavigationSteps {

    HomePage hp = new HomePage();

    @Given("^user on home page$")
    public void userOnHomePage() {
        hp.getHomePage();
        hp.prepareLogin();
    }

    @And("^user logged in to basqar$")
    public void userLoggedInToBasqar() {
        hp.login();
    }

    @When("^the browser size is \"([^\"]*)\"$")
    public void theBrowserSizeIs(String browserSize)  {
        BrowserSize size = BrowserSize.valueOf(browserSize);
        hp.setBrowserSizeTo(size);
    }

    @Then("^user should navigate to the following links on menu$")
    public void userNavigateToTheFollowingLinksOnMenu(DataTable dataTable) {
        List<String> list = dataTable.asList(String.class);
        for (String linkText : list) {
            NavBarObjects link = NavBarObjects.valueOf(linkText);
            hp.clickOnMenuTo(link);
        }
    }

    @And("^user logout from basqar$")
    public void userLogout() {
        hp.logout();
    }

}

