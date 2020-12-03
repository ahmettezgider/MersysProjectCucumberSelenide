package pages;

import pageModels.NavBarObjects;
import utilities.ParentClass;

import static com.codeborne.selenide.Selenide.$;
import static pageModels.Buttons.Save;

public class BankAccountsPage extends ParentClass {

    public void getPage(){
        clickOnMenuTo(NavBarObjects.Dashboard);
        clickOnMenuTo(NavBarObjects.BankAccounts);
    }

    public void add(String name, String iban, String currency, String integrationCode){
        $(PageButtonAdd).click();
        $(DialogFormNameInput).sendKeys(name);
        $(DialogFormIban).sendKeys(iban);
        if (isInteger(currency))
            selectOption(PageFormCurrencySelect, getIntVal(currency));
        else
            selectOption(PageFormCurrencySelect, currency);

        $(DialogFormIntegrationCode).sendKeys(integrationCode);
        clickToDialogButton(Save);
    }

    public void update(String oldName, String name, String iban, String currency, String integrationCode){
        editTheTableData(oldName);
        if (name.length()>0) {
            $(DialogFormNameInput).clear();
            $(DialogFormNameInput).sendKeys(name);
        }
        if (iban.length()==22) {
            $(DialogFormIban).clear();
            $(DialogFormIban).sendKeys(iban);
        }
        if (isInteger(currency))
            selectOption(PageFormCurrencySelect, getIntVal(currency));
        else
            selectOption(PageFormCurrencySelect, currency);

        if (integrationCode.length()>0) {
            $(DialogFormIntegrationCode).clear();
            $(DialogFormIntegrationCode).sendKeys(integrationCode);
        }
        clickToDialogButton(Save);
    }

    public void delete(String city){
        deleteTheTableData(city);
    }

}
