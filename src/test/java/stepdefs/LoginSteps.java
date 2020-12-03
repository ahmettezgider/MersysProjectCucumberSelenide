package stepdefs;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pageModels.NavBarObjects;
import pageModels.NotificationResults;
import pages.HomePage;
import utilities.MyUtils;

import java.util.List;

public class LoginSteps extends MyUtils {

    HomePage hp = new HomePage();

    @When("^the users in the excel file \"([^\"]*)\" in the order \"([^\"]*)\" try to login$")
    public void theUsersInTheExcelFileInTheOrderTryToLogin(String excelFile, String rowNumber) {
        int row = Integer.parseInt(rowNumber);
        List<String> list = getExcelData(excelFile, "Sheet1", row);
        hp.clearLoginFields();
        hp.login(list.get(0), list.get(1));
    }

    @Then("^login should not be successfull$")
    public void loginShouldNotBeSuccessfull() {
        hp.justifyNotificationAs(NotificationResults.Error);
    }


}
