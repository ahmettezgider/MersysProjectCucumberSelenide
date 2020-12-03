package pages;

import pageModels.NavBarObjects;
import pageModels.NotificationResults;
import utilities.ParentClass;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static pageModels.Buttons.Close;
import static pageModels.Buttons.Save;

public class ExcelTemplatePage extends ParentClass {

    public void getPage(){
        clickOnMenuTo(NavBarObjects.Dashboard);
        clickOnMenuTo(NavBarObjects.ExcelTemplate);
    }

    public void add(String name, int periodCount){
        $(PageButtonAdd).click();
        $(DialogFormNameInput).setValue(name);
        $(DialogFormPeriodCountInput).setValue(periodCount+"");
        clickToDialogButton(Save);
        clickToDialogButton(Close);
    }

    public void add(String name, int periodCount, List<List<String>> listOfLists){
        $(PageButtonAdd).click();
        $(DialogFormNameInput).setValue(name);
        $(DialogFormPeriodCountInput).setValue(periodCount+"");
        clickToDialogButton(Save);
        $(TabPageVersions).click();
        for (List<String> list : listOfLists) {
            $(DialogFormRowSizeCountInput).setValue(list.get(0)+"");
            $(DialogFormColumnSizeCountInput).setValue(list.get(1)+"");
            $(DialogButtonAddVersion).click();
        }
        clickToDialogButton(Save);
        clickToDialogButton(Close);
    }

    public void edit(String name){
        editTheTableData(name);
        clickToDialogButton(Save);
        clickToDialogButton(Close);
    }

    public void update(String oldName, String name, int periodCount){
        editTheTableData(oldName);
        if (name.length() > 0){
            $(DialogFormNameInput).clear();
            $(DialogFormNameInput).setValue(name);
        }
        if (periodCount > 0) {
            $(DialogFormPeriodCountInput).clear();
            $(DialogFormPeriodCountInput).setValue(periodCount+"");
        }
        clickToDialogButton(Save);
        $(TabPageVersions).click();
        /*
        editTheTableData(updateVersion+"");

        if (row > 0) {
            clear(DialogFormRowSizeCountInput);
            sendKeysTo(DialogFormRowSizeCountInput, row+"");
        }
        if (col > 0) {
            clear(DialogFormColumnSizeCountInput);
            sendKeysTo(DialogFormColumnSizeCountInput, col+"");
        }
        clickTo(DialogButtonAddVersion);
        clickToDialogButton(Save);
         */
        clickToDialogButton(Close);
    }

    public void delete(String excelTemplate){
        deleteTheTableData(excelTemplate);
    }

    public void exists(String text, boolean exist){
        searchIn(PageFormNameInput, text);
        shouldBeExists(text, exist);
    }
}
