package pages;

import pageModels.NavBarObjects;
import pageModels.NotificationResults;
import utilities.ParentClass;

import static com.codeborne.selenide.Selenide.$;
import static pageModels.Buttons.Save;

public class SubjectCategoriesPage extends ParentClass {

    public void getPage(){
        clickOnMenuTo(NavBarObjects.Dashboard);
        clickOnMenuTo(NavBarObjects.SubjectCategories);
    }

    public void add(String newSubjectCategory, String newSubjectCategoryCode){
        $(PageButtonAdd).click();
        $(DialogFormNameInput).setValue(newSubjectCategory);
        $(DialogFormCodeInput).setValue(newSubjectCategoryCode);
        clickToDialogButton(Save);
    }

    public void update(String oldSubjectCategory, String newSubjectCategory, String newSubjectCategoryCode){
        editTheTableData(oldSubjectCategory);
        if (newSubjectCategory.length()>0){
            $(DialogFormNameInput);
            $(DialogFormNameInput).setValue(newSubjectCategory);
        }
        if (newSubjectCategoryCode.length()>0) {
            $(DialogFormCodeInput).clear();
            $(DialogFormCodeInput).setValue(newSubjectCategoryCode);
        }
        clickToDialogButton(Save);
    }

    public void delete(String subjectCategory){
        deleteTheTableData(subjectCategory);
    }

    public void exists(String text, boolean exist){
        searchIn(PageFormNameInput, text);
        shouldBeExists(text, exist);
    }
}
