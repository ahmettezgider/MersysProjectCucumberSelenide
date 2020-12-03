package pages;

import pageModels.NavBarObjects;
import pageModels.NotificationResults;
import utilities.ParentClass;

import static com.codeborne.selenide.Selenide.$;
import static pageModels.Buttons.Save;

public class SalaryTypesPage extends ParentClass {

    public void getPage(){
        clickOnMenuTo(NavBarObjects.Dashboard);
        clickOnMenuTo(NavBarObjects.SalaryTypes);
    }

    public void add(String newSalaryType, String...userType){
        $(PageButtonAdd).click();
        $(DialogFormNameInput).setValue(newSalaryType);
        selectOptionMulti(DialogFormUserTypeMultiSelect, userType);
        clickToDialogButton(Save);
    }

    public void add(String newSalaryType, int...userType){
        $(PageButtonAdd).click();
        $(DialogFormNameInput).setValue(newSalaryType);
        selectOptionMulti(DialogFormUserTypeMultiSelect, userType);
        clickToDialogButton(Save);
    }

    public void update(String oldName, String newName, String...userType){
        editTheTableData(oldName);
        if (newName.length()>0) {
            $(DialogFormNameInput).clear();
            $(DialogFormNameInput).setValue(newName);
        }
        if (userType.length>0) {
            deleteMultiSelectOptions(MultiSelectOptionDelete);
            selectOptionMulti(DialogFormUserTypeMultiSelect, userType);
        }
        clickToDialogButton(Save);
    }

    public void update(String oldName, String newName, int...userType){
        editTheTableData(oldName);
        if (newName.length()>0) {
            $(DialogFormNameInput).clear();
            $(DialogFormNameInput).setValue(newName);
        }
        if (userType.length>0) {
            deleteMultiSelectOptions(MultiSelectOptionDelete);
            selectOptionMulti(DialogFormUserTypeMultiSelect, userType);
        }
        clickToDialogButton(Save);
    }

    public void delete(String salaryType){
        deleteTheTableData(salaryType);
    }

    public void exists(String text, boolean exist){
        searchIn(PageFormNameInput2, text);
        shouldBeExists(text, exist);
    }
}
