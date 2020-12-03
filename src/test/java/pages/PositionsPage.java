package pages;

import pageModels.NavBarObjects;
import pageModels.NotificationResults;
import utilities.ParentClass;

import static com.codeborne.selenide.Selenide.$;
import static pageModels.Buttons.Save;

public class PositionsPage extends ParentClass {

    public void getPage(){
        clickOnMenuTo(NavBarObjects.Dashboard);
        clickOnMenuTo(NavBarObjects.Positions);
    }

    public void add(String newCountryName, String newCountryCode){
        $(PageButtonAdd).click();;
        $(DialogFormNameInput).setValue(newCountryName);
        $(DialogFormShortNameInput).setValue(newCountryCode);
        clickToDialogButton(Save);
    }

    public void update(String oldCountryName, String newCountryName, String newCountryCode){
        editTheTableData(oldCountryName);
        if (newCountryName.length()>0){
            $(DialogFormNameInput).clear();
            $(DialogFormNameInput).setValue(newCountryName);
        }
        if (newCountryCode.length()>0) {
            $(DialogFormShortNameInput).clear();
            $(DialogFormShortNameInput).setValue(newCountryCode);
        }
        clickToDialogButton(Save);
    }

    public void delete(String position){
        deleteTheTableData(position);
    }

    public void exists(String text, boolean exist){
        searchIn(PageFormNameInput, text);
        shouldBeExists(text, exist);
    }
}
