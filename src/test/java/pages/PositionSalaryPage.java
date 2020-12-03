package pages;

import pageModels.NavBarObjects;
import pageModels.NotificationResults;
import utilities.ParentClass;

import static com.codeborne.selenide.Selenide.$;
import static pageModels.Buttons.Save;

public class PositionSalaryPage extends ParentClass {

    public void getPage(){
        clickOnMenuTo(NavBarObjects.Dashboard);
        clickOnMenuTo(NavBarObjects.PositionSalary);
    }

    public void add(String newPositionSalary){
        $(PageButtonAdd).click();
        $(DialogFormNameInputInPosSal).setValue(newPositionSalary);
        clickToDialogButton(Save);
    }

    public void update(String oldPositionSalary, String newPositionSalary){
        editTheTableData(oldPositionSalary);
        if (newPositionSalary.length()>0) {
            $(DialogFormNameInputInPosSal).clear();
            $(DialogFormNameInputInPosSal).setValue(newPositionSalary);
        }
        clickToDialogButton(Save);
    }

    public void delete(String positionSalary){
        deleteTheTableData(positionSalary);
    }

    public void exists(String text, boolean exist){
        searchIn(PageFormNameInput2, text);
        shouldBeExists(text, exist);
    }

    public void addPositionSalaryTo(String experience, String from, String salary, String currency){
        $(PageButtonAdd).click();
        $(DialogFormName2Input).sendKeys(experience);
        $(DialogFormFromDate).click();
        setCalenderDate(from);
        $(DialogFormSalary).sendKeys(salary+"");
        selectOption(PageFormCurrencySelect, currency);
        $(DialogButtonAddWithText).click();
        $(DialogContainerButtonSave).click();
    }

    public void updatePositionSalaryTo(String experience, String from, String salary, String currency){
        editTheTableData(experience);
        $(TableButtonEditUnique).click();
        $(DialogFormName2Input).clear();
        $(DialogFormFromDate).click();
        setCalenderDate(from);
        $(DialogFormSalary).clear();
        $(DialogFormSalary).sendKeys(salary+"");
        selectOption(PageFormCurrencySelect, currency);
        $(DialogContainerButtonSave).click();
    }

    public void clickToAddPositionSalary(String name){
        addPositionSalaryButtonInTable(name);
    }

}
