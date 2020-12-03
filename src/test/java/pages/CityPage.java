package pages;

import pageModels.NavBarObjects;
import pageModels.NotificationResults;
import utilities.ParentClass;

import static com.codeborne.selenide.Selenide.$;
import static pageModels.Buttons.Save;

public class CityPage extends ParentClass {

    public void getPage(){
        clickOnMenuTo(NavBarObjects.Dashboard);
        clickOnMenuTo(NavBarObjects.Cities);
    }

    public void add(String country, String city){
        $(PageButtonAdd).click();
        selectOption(DialogFormCountrySelect, country);
        $(DialogFormNameInput).setValue(city);
        clickToDialogButton(Save);
    }

    public void add(int countryIndex, String newCity){
        $(PageButtonAdd).click();
        selectOption(DialogFormCountrySelect, countryIndex);
        $(DialogFormNameInput).setValue(newCity);
        clickToDialogButton(Save);
    }

    public void update(String oldName, String newName){
        editTheTableData(oldName);
        if (newName.length()>0) {
            $(DialogFormNameInput).click();
            $(DialogFormNameInput).setValue(newName);
        }
        clickToDialogButton(Save);
    }

    public boolean delete(String city){
        return deleteTheTableData(city);
    }

    public void exists(String text, boolean exist){
        searchIn(PageFormNameInput, text);
        shouldBeExists(text, exist);
    }

}
