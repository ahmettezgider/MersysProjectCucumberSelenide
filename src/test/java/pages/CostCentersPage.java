package pages;

import com.codeborne.selenide.Condition;
import pageModels.NavBarObjects;
import pageModels.NotificationResults;
import utilities.ParentClass;

import static com.codeborne.selenide.Selenide.$;
import static pageModels.Buttons.Close;
import static pageModels.Buttons.Save;

public class CostCentersPage extends ParentClass {

    public void getPage(){
        clickOnMenuTo(NavBarObjects.Dashboard);
        clickOnMenuTo(NavBarObjects.CostCenters);
    }

    public void add(String name, String code, String type,
                       int orderNo, String key, String value, int...expence){
        $(PageButtonAdd).click();
        $(DialogFormNameInput).setValue(name);
        $(DialogFormCodeInput).setValue(code);
        selectOption(DialogFormTypeSelect, type);
        $(DialogFormOrderInput).setValue(orderNo+"");
        selectOptionMulti(DialogFormExpenseAccoutMultiSelect, expence );
        $(TabPageConstants).click();
        $(DialogFormKeyInput).setValue(key);
        $(DialogFormValueTextInput).setValue(value);
        $(DialogButtonAddWithText).shouldBe(Condition.enabled).click();
        clickToDialogButton(Save);
    }

    public void add(String name, String code, int type,
                       int orderNo, String key, String value, int...expence){
        $(PageButtonAdd).click();
        $(DialogFormNameInput).setValue(name);
        $(DialogFormCodeInput).setValue(code);
        selectOption(DialogFormTypeSelect, type);
        $(DialogFormOrderInput).setValue(orderNo+"");
        selectOptionMulti(DialogFormExpenseAccoutMultiSelect, expence );
        $(TabPageConstants).click();
        $(DialogFormKeyInput).setValue(key);
        $(DialogFormValueTextInput).setValue(value);
        $(DialogButtonAddWithText).shouldBe(Condition.enabled).click();
        clickToDialogButton(Save);
    }

    public void update(String oldName, String name, String code, String type,
                          int orderNo, String key, String value, int...expence){
        editTheTableData(oldName);
        if (name.length() > 0){
            $(DialogFormNameInput).clear();
            $(DialogFormNameInput).setValue(name);
        }
        if (code.length() > 0) {
            $(DialogFormCodeInput).clear();
            $(DialogFormCodeInput).setValue(code);
        }
        if (type.length() > 0) {
            selectOption(DialogFormTypeSelect, type);
        }
        if (orderNo > 0) {
            $(DialogFormOrderInput).clear();
            $(DialogFormOrderInput).setValue(orderNo+"");
        }

        if (expence.length>0) {
            deleteMultiSelectOptions(MultiSelectOptionDelete);
            selectOptionMulti(DialogFormExpenseAccoutMultiSelect, expence);
        }
        $(TabPageConstants).click();
        if (key.length() > 0) $(DialogFormKeyInput).setValue(key);
        if (value.length() > 0) $(DialogFormValueTextInput).setValue(value);

        clickToDialogButton(Save);
    }

    public void update(String oldName, String name, String code, int type,
                          int orderNo, String key, String value, int...expence){
        editTheTableData(oldName);
        if (name.length() > 0){
            $(DialogFormNameInput).clear();
            $(DialogFormNameInput).setValue(name);
        }
        if (code.length() > 0) {
            $(DialogFormCodeInput).clear();
            $(DialogFormCodeInput).setValue(code);
        }
        if (type >= 0) {
            selectOption(DialogFormTypeSelect, type);
        }
        if (orderNo > 0) {
            $(DialogFormOrderInput).clear();
            $(DialogFormOrderInput).setValue(orderNo+"");
        }

        if (expence.length>0) {
            deleteMultiSelectOptions(MultiSelectOptionDelete);
            selectOptionMulti(DialogFormExpenseAccoutMultiSelect, expence);
        }
        $(TabPageConstants).click();
        if (key.length() > 0) $(DialogFormKeyInput).setValue(key);
        if (value.length() > 0) $(DialogFormValueTextInput).setValue(value);

        clickToDialogButton(Save);
    }
    public void delete(String excelTemplate){
        deleteTheTableData(excelTemplate);
    }

    public void exists(String text, boolean exist){
        //searchIn(PageFormNameInput, text);
        shouldBeExists(text, exist);
    }
}
