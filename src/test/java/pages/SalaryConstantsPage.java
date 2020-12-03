package pages;

import pageModels.NavBarObjects;
import pageModels.NotificationResults;
import utilities.ParentClass;

import static com.codeborne.selenide.Selenide.$;
import static pageModels.Buttons.Save;

public class SalaryConstantsPage extends ParentClass {

    public void getPage(){
        clickOnMenuTo(NavBarObjects.Dashboard);
        clickOnMenuTo(NavBarObjects.SalaryConstants);
    }

    public void add(String name, String validFormDate, String key, int value){
        $(PageButtonAdd).click();;
        $(DialogFormName2Input).setValue(name);
        $(DialogFormValidFormInput).click();
        setCalenderDate(validFormDate);
        $(DialogFormKeyInput).setValue(key);
        $(DialogFormValueIntInput).setValue(value+"");
        clickToDialogButton(Save);
    }

    public void update(String oldName, String newName, String newValidFormDate, String newKey, int newValue){
        searchIn(PageFormNameInput2, oldName);

        editTheTableData(oldName);
        if (newName.length()>0){
            $(DialogFormName2Input).clear();
            $(DialogFormName2Input).setValue(newName);
        }
        if (newValidFormDate.length()>0) {
            $(DialogFormValidFormInput).clear();
            setCalenderDate(newValidFormDate);
        }
        if (newKey.length()>0) {
            $(DialogFormKeyInput).clear();
            $(DialogFormKeyInput).setValue(newKey);
        }
        $(DialogFormValueIntInput).setValue(newValue+"");
        clickToDialogButton(Save);
    }

    public void delete(String name){
        searchIn(PageFormNameInput2, name);
        deleteTheTableData(name);
    }

    public void exists(String text, boolean exist){
        searchIn(PageFormNameInput2, text);
        shouldBeExists(text, exist);
    }
}
