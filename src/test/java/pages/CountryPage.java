package pages;

import pageModels.NavBarObjects;
import utilities.ParentClass;

import static com.codeborne.selenide.Selenide.$;
import static pageModels.Buttons.Save;

public class CountryPage extends ParentClass {

    public void getPage(){
        clickOnMenuTo(NavBarObjects.Dashboard);
        clickOnMenuTo(NavBarObjects.Countries);
    }

    public void add(String newName){
        $(PageButtonAdd).click();
        $(DialogFormNameInput).setValue(newName);
        clickToDialogButton(Save);
    }

    public void add(String newName, String newCode){
        $(PageButtonAdd).click();
        $(DialogFormNameInput).setValue(newName);
        $(DialogFormCodeInput).setValue(newCode);
        clickToDialogButton(Save);
    }

    public void update(String oldName, String newName, String newCode){
        editTheTableData(oldName);
        if (newName.length()>0){
            $(DialogFormNameInput).clear();
            $(DialogFormNameInput).setValue(newName);
        }
        if (newCode.length()>0) {
            $(DialogFormCodeInput).clear();
            $(DialogFormCodeInput).setValue(newCode);
        }
        clickToDialogButton(Save);
    }

    public void delete(String text){
        deleteTheTableData(text);
    }

    public void exists(String text, boolean exist){
        searchIn(PageFormNameInput, text);
        shouldBeExists(text, exist);
    }


}
