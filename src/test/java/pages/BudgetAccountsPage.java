package pages;

import pageModels.NavBarObjects;
import pageModels.NotificationResults;
import utilities.ParentClass;

import java.util.Map;

import static com.codeborne.selenide.Selenide.$;

public class BudgetAccountsPage extends ParentClass {


    public void getPage(){
        clickOnMenuTo(NavBarObjects.Dashboard);
        clickOnMenuTo(NavBarObjects.BudgetAccounts);
    }

    public void add(Map<String, String> map){
        String name = map.get("name");
        String code = map.get("code");
        String category = map.get("category");
        String type = map.get("type");
        String parentAccountCode = map.get("parentAccountCode");
        String closingAccountCode = map.get("closingAccountCode");
        String balanceType = map.get("balanceType");
        String integrationCodes = map.get("integrationCodes");
        String currency = map.get("currency");

        $(PageButtonAdd).click();
        $(DialogFormCodeInput).setValue(code);
        $(DialogFormNameInput).setValue(name);
        selectOption(PageFormCategorySelect, Integer.parseInt(category));
        selectOption(PageFormTypeSelect, type);
        switch (type.toLowerCase()){
            case "detail":
                $(PageFormParentClosingAccountCode).setValue(closingAccountCode);
                selectOption(3);
            case "auxiliary":
                $(PageFormParentAccountCode).setValue(parentAccountCode);
                selectOption(0);
        }

        selectOption(PageFormBalanceTypeSelect, balanceType);

        /*
        clickTo(PageFormIntegrationCodeToAdd);
        clickTo(DialogueFormIntegrationCodeToAdd);
        clickTo(DialogueFormIntegrationCodeInputLast);
        sendKeysTo(DialogueFormIntegrationCodeInputLast, integrationCodes);
        clickTo(DialogButtonApplyWithText);
         */

        selectOption(PageFormCurrencySelect, currency);

        $(PageButtonSaveWithText).click();
        //return notificationResult(NotificationResults.Created);
    }


    public boolean delete(String name, int category){
        getPage();
        selectOption(PageFormCategorySelectInBudgetAccount, category);
        searchIn(PageFormNameInput, name);
        return deleteTheTableData(name);
    }

    public void exists(String text, int category, boolean exist){
        getPage();
        selectOption(PageFormCategorySelectInBudgetAccount, category);
        searchIn(PageFormNameInput, text);
        shouldBeExists(text, exist);
    }
}
