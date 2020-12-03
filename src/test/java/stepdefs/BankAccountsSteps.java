package stepdefs;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageModels.NavBarObjects;
import pageModels.NotificationResults;
import pages.BankAccountsPage;

import java.util.Map;

public class BankAccountsSteps {
    BankAccountsPage bank = new BankAccountsPage();

    @Given("^user on bank accounts page$")
    public void userOnCountriesPage() {
        if (!bank.userOnSameThePage(NavBarObjects.BankAccounts)) {
            bank.getPage();
        }
    }

    @And("^user navigate to bank accounts page$")
    public void userNavigateToBankAccountsPage() {
        bank.getPage();
    }

    @When("^user create a bank account as follows$")
    public void userCreateABankAccountAsFollows(DataTable dataTable) {
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        String name = map.get("name");
        String iban = map.get("iban");
        String currency = map.get("currency");
        String integrationCode = map.get("integrationCode");
        bank.add(name, iban, currency, integrationCode);

    }

    @Then("^bank account should be created$")
    public void bankAccountShouldBeCreated() {
        bank.justifyNotificationAs(NotificationResults.created);
    }

    @When("^user update the bank account named as \"([^\"]*)\" as follows$")
    public void userUpdateTheBankAccountAsFollows(String oldName, DataTable dataTable) {
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        String name = map.get("name");
        String iban = map.get("iban");
        String currency = map.get("currency");
        String integrationCode = map.get("integrationCode");
        bank.update(oldName, name, iban, currency, integrationCode);
    }

    @Then("^bank account should be updated$")
    public void bankAccountShouldBeUpdated() {
        bank.justifyNotificationAs(NotificationResults.updated);
    }

    @When("^user delete the bank account named as \"([^\"]*)\"$")
    public void userDeleteTheBankAccountNamedAs(String name)  {
        bank.delete(name);
    }

    @Then("^bank account should be deleted$")
    public void bankAccountShouldBeDeleted() {
        bank.justifyNotificationAs(NotificationResults.deleted);
    }
}
