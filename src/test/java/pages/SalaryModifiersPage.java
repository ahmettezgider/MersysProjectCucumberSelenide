package pages;

import pageModels.NavBarObjects;
import pageModels.NotificationResults;
import utilities.ParentClass;

import java.util.Map;

import static com.codeborne.selenide.Selenide.$;
import static pageModels.Buttons.Save;

public class SalaryModifiersPage extends ParentClass {

    public void getPage(){
        clickOnMenuTo(NavBarObjects.Dashboard);
        clickOnMenuTo(NavBarObjects.SalaryModifiers);
    }

    public void add(Map<String, String> map){
        String description = map.get("description");
        String variable = map.get("variable");
        String modifierType = map.get("modifierType");
        String integrationCode = map.get("integrationCode");
        String valueType = map.get("valueType");
        String priority = map.get("priority");
        String amount = map.get("amount");
        String formula = map.get("formula");
        String name = map.get("name");
        String formulaVariable = map.get("formulaVariable");
        String modifierVariableType = map.get("modifierVariableType");

        $(PageButtonAdd).click();;
        $(PageFormDescriptionInput).setValue(description);
        $(PageFormVariableInput).setValue(variable);
        selectOption(PageFormModifierTypeSelect, Integer.parseInt(modifierType));
        $(PageFormIntegrationCodeInput).setValue(integrationCode);
        selectOption(PageFormValueTypeSelect, Integer.parseInt(valueType));
        $(PageFormPriorityIntInput).setValue(priority+"");
        if ($(PageFormValueTypeSelect).getText().equalsIgnoreCase("formula")){
            $(PageFormFormulaInput).setValue(formula);
        }else {
            $(PageFormAmountIntInput).setValue(amount);
        }
        $(PageButtonAdd).click();;

        $(DialogFormName2Input).setValue(name);
        $(DialogFormFormulaVariableInput).setValue(formulaVariable);
        selectOption(DialogFormModifierVariableTypeSelect, Integer.parseInt(modifierVariableType));
        $(DialogButtonApplyWithText).click();;

        $(PageButtonSaveWithText).click();;
        getPage();
    }


    public void update(String oldName, Map<String, String> map){
        String description = map.get("description");
        String variable = map.get("variable");
        String modifierType = map.get("modifierType");
        String integrationCode = map.get("integrationCode");
        String valueType = map.get("valueType");
        String priority = map.get("priority");
        String amount = map.get("amount");
        String formula = map.get("formula");
        String name = map.get("name");
        String formulaVariable = map.get("formulaVariable");
        String modifierVariableType = map.get("modifierVariableType");

        editTheTableData(oldName);
        $(PageFormDescriptionInput).setValue(description);
        $(PageFormVariableInput).setValue(variable);
        selectOption(PageFormModifierTypeSelect, Integer.parseInt(modifierType));
        $(PageFormIntegrationCodeInput).setValue(integrationCode);
        selectOption(PageFormValueTypeSelect, Integer.parseInt(valueType));
        $(PageFormPriorityIntInput).setValue(priority+"");
        if ($(PageFormValueTypeSelect).getText().equalsIgnoreCase("formula")){
            $(PageFormFormulaInput).setValue(formula);
        }else {
            $(PageFormAmountIntInput).setValue(amount);
        }
        $(PageButtonAdd).click();;

        $(DialogFormName2Input).setValue(name);
        $(DialogFormFormulaVariableInput).setValue(formulaVariable);
        selectOption(DialogFormModifierVariableTypeSelect, Integer.parseInt(modifierVariableType));
        $(DialogButtonApplyWithText).click();

        $(PageButtonSaveWithText).click();
    }

    public void delete(String salaryModifier){
        deleteTheTableData(salaryModifier);
    }

    public void exists(String text, boolean exist){
        searchIn(PageFormDescriptionInputToSearch, text);
        shouldBeExists(text, exist);
    }
}


/*

    public boolean add(String description, String variable, int modifierType,
                       String integrationCode, int valueType, int priority, String amountFormula,
                       String name, String formulaVariable, int modifierVariableType){
        clickTo(PageButtonAdd);
        sendKeysTo(PageFormDescriptionInput, description);
        sendKeysTo(PageFormVariableInput, variable);
        selectOption(PageFormModifierTypeSelect, modifierType);
        sendKeysTo(PageFormIntegrationCodeInput, integrationCode);
        selectOption(PageFormValueTypeSelect, valueType);
        sendKeysTo(PageFormPriorityIntInput, priority+"");
        if (driver.findElement(PageFormValueTypeSelect).getText().equalsIgnoreCase("formula")){
            sendKeysTo(PageFormFormulaInput, amountFormula);
        }else {
            sendKeysTo(PageFormAmountIntInput, amountFormula);
        }
        clickTo(PageButtonAdd);

        sendKeysTo(DialogFormName2Input, name);
        sendKeysTo(DialogFormFormulaVariableInput, formulaVariable);
        selectOption(DialogFormModifierVariableTypeSelect, modifierVariableType);
        clickTo(DialogButtonApplyWithText);

        clickTo(PageButtonSaveWithText);
        getPage();
        return notificationResult(NotificationResults.Created);
    }


    public boolean update(String oldName, String description, String variable, int modifierType,
                          String integrationCode, int valueType, int priority, String amountFormula,
                          String name, String formulaVariable, int modifierVariableType){
        editTheTableData(oldName);
        sendKeysTo(PageFormDescriptionInput, description);
        sendKeysTo(PageFormVariableInput, variable);
        selectOption(PageFormModifierTypeSelect, modifierType);
        sendKeysTo(PageFormIntegrationCodeInput, integrationCode);
        selectOption(PageFormValueTypeSelect, valueType);
        sendKeysTo(PageFormPriorityIntInput, priority+"");
        if (driver.findElement(PageFormValueTypeSelect).getText().equalsIgnoreCase("formula")){
            sendKeysTo(PageFormFormulaInput, amountFormula);
        }else {
            sendKeysTo(PageFormAmountIntInput, amountFormula);
        }
        clickTo(PageButtonAdd);

        sendKeysTo(DialogFormName2Input, name);
        sendKeysTo(DialogFormFormulaVariableInput, formulaVariable);
        selectOption(DialogFormModifierVariableTypeSelect, modifierVariableType);
        clickTo(DialogButtonApplyWithText);

        clickTo(PageButtonSaveWithText);

        return notificationResult(NotificationResults.Updated);
    }
 */