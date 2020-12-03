package pages;

import pageModels.NavBarObjects;
import pageModels.NotificationResults;
import utilities.ParentClass;

import static com.codeborne.selenide.Selenide.$;
import static pageModels.Buttons.Save;

public class SubjectsPage extends ParentClass {

    public void getPage(){
        clickOnMenuTo(NavBarObjects.Dashboard);
        clickOnMenuTo(NavBarObjects.Subjects);
    }

    public void add(String newSubject, String newSubjectCode, int catOption, int styleOption){
        $(PageButtonAdd).click();
        $(DialogFormNameInput).setValue(newSubject);
        $(DialogFormCodeInput).setValue(newSubjectCode);
        selectOption(DialogFormSubjectCategorySelect, catOption);
        selectOption(DialogFormStyleSelect, styleOption);
        clickToDialogButton(Save);
    }

    public void add(String newSubject, String newSubjectCode, String catOption, int styleOption){
        $(PageButtonAdd).click();
        $(DialogFormNameInput).setValue(newSubject);
        $(DialogFormCodeInput).setValue(newSubjectCode);
        selectOption(DialogFormSubjectCategorySelect, catOption);
        selectOption(DialogFormStyleSelect, styleOption);
        clickToDialogButton(Save);
    }

    public void update(String oldSubject, String newSubject, String newSubjectCode,
                          int catOption, int styleOption){
        editTheTableData(oldSubject);
        if (newSubject.length()>0){
            $(DialogFormNameInput).clear();
            $(DialogFormNameInput).setValue(newSubject);
        }
        if (newSubjectCode.length()>0) {
            $(DialogFormCodeInput).clear();
            $(DialogFormCodeInput).setValue(newSubjectCode);
        }
        if (catOption>0) selectOption(DialogFormSubjectCategorySelect, catOption);
        if (styleOption>0) selectOption(DialogFormStyleSelect, styleOption);
        clickToDialogButton(Save);
    }

    public void delete(String subject){
        deleteTheTableData(subject);
    }

    public void exists(String text, boolean exist){
        searchIn(PageFormNameInput, text);
        shouldBeExists(text, exist);
    }
}
