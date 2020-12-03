package runners;

import org.testng.annotations.Test;
import pageModels.BrowserSize;
import pageModels.NavBarObjects;
import pages.*;

public class TestNGDistinct {

    @Test
    public void ttt(){
        HomePage hp = new HomePage();
        hp.getHomePage();
        hp.prepareLogin();
        hp.login("daulet2030@gmail.com","TechnoStudy123@");
        hp.clickOnMenuTo(NavBarObjects.Dashboard);

        hp.getHomePage();
        hp.login("daulet2030@gmail.com","TechnoStudy123@");
        hp.clickOnMenuTo(NavBarObjects.Cities);

        hp.getHomePage();
        hp.login("daulet2030@gmail.com","TechnoStudy123@");
        hp.clickOnMenuTo(NavBarObjects.Positions);

        hp.getHomePage();
        hp.login("daulet2030@gmail.com","TechnoStudy123@");
        hp.clickOnMenuTo(NavBarObjects.ExcelTemplate);


    }

    @Test
    public void menuTest() {
        HomePage hp = new HomePage();
        hp.getHomePage();
        hp.setBrowserSizeTo(BrowserSize.half);
        hp.login("daulet2030@gmail.com","TechnoStudy123@");

        hp.clickOnMenuTo(NavBarObjects.Cities);
        hp.clickOnMenuTo(NavBarObjects.Dashboard);
        hp.clickOnMenuTo(NavBarObjects.Positions);
        hp.clickOnMenuTo(NavBarObjects.ExcelTemplate);

    }

    @Test
    public void countryTest() {
        HomePage hp = new HomePage();
        hp.getHomePage();
        hp.login("daulet2030@gmail.com","TechnoStudy123@");

        CountryPage cp = new CountryPage();
        cp.getPage();
        cp.add("Turkey123", "tr123");
        cp.update("Turkey123", "Turkey1234", "tr1234");
        cp.delete("Turkey1234");

        hp.logout();
    }

    @Test
    public void cityTest() {
        HomePage hp = new HomePage();
        hp.getHomePage();
        hp.login("daulet2030@gmail.com","TechnoStudy123@");

        CityPage cp = new CityPage();
        cp.getPage();
        cp.add("Turkey", "KKK");
        cp.update("KKK", "KKK1");
        cp.delete("KKK1");

        hp.logout();
    }


    @Test
    public void subjectCategoriesTest() {
        HomePage hp = new HomePage();
        hp.getHomePage();
        hp.login("daulet2030@gmail.com","TechnoStudy123@");

        SubjectCategoriesPage scp = new SubjectCategoriesPage();
        scp.getPage();
        scp.add("new Category-1", "nc1");
        scp.update("new Category-1", "new Category-2", "nc2");
        scp.delete("new Category-2");

    }

    @Test
    public void subjectTest() {
        HomePage hp = new HomePage();
        hp.getHomePage();
        hp.login("daulet2030@gmail.com","TechnoStudy123@");

        SubjectsPage sp = new SubjectsPage();
        sp.getPage();
        sp.add("Subject-1", "s1", 1, 5);
        sp.update("Subject-1", "Subject-2", "s2", 0, 0);
        sp.delete("Subject-2");

    }


    @Test
    public void positionSalaryTest() {
        HomePage hp = new HomePage();
        hp.getHomePage();
        hp.login("daulet2030@gmail.com","TechnoStudy123@");

        PositionSalaryPage ps = new PositionSalaryPage();
        ps.getPage();
        ps.add("Subject-1");
        ps.update("Subject-1", "Subject-2");
        ps.delete("Subject-2");

    }


    @Test
    public void positionTest() {
        HomePage hp = new HomePage();
        hp.getHomePage();
        hp.login("daulet2030@gmail.com","TechnoStudy123@");

        PositionsPage ps = new PositionsPage();
        ps.getPage();
        ps.add("Subject-1", "S1");
        ps.update("Subject-1", "Subject-2", "S2");
        ps.delete("Subject-2");

    }


    @Test
    public void salaryTypeTest() {
        HomePage hp = new HomePage();
        hp.getHomePage();
        hp.login("daulet2030@gmail.com","TechnoStudy123@");

        SalaryTypesPage ps = new SalaryTypesPage();
        ps.getPage();
        ps.add("Subject-1", "User");
        ps.update("Subject-1", "Subject-2", "user");
        ps.delete("Subject-2");

        ps.add("Subject-1", 7);
        ps.update("Subject-1", "Subject-2", 1);
        ps.delete("Subject-2");

    }

    @Test
    public void salaryConstantsTest() {
        HomePage hp = new HomePage();
        hp.getHomePage();
        hp.login("daulet2030@gmail.com","TechnoStudy123@");

        SalaryConstantsPage ps = new SalaryConstantsPage();
        ps.getPage();
        ps.add("Subject-1", "2019-01-01", "s123", 10);
        ps.update("Subject-1","Subject-2", "2020-01-01", "xs123", 2);
        ps.delete("Subject-2");

    }

    @Test
    public void excelTempleteTest() {
        HomePage hp = new HomePage();
        hp.getHomePage();
        hp.login("daulet2030@gmail.com","TechnoStudy123@");

        ExcelTemplatePage ps = new ExcelTemplatePage();
        ps.getPage();
        ps.add("Subject-1", 2);
        ps.update("Subject-1","Subject-2",  1);
        ps.delete("Subject-2");

    }

    @Test
    public void costCentersTest() {
        HomePage hp = new HomePage();
        hp.getHomePage();
        hp.login("daulet2030@gmail.com","TechnoStudy123@");

        CostCentersPage ps = new CostCentersPage();
        ps.getPage();
        ps.add("Subject-1", "code-1", "Service", 21, "5", "33", 3);
        ps.update("Subject-1", "Subject-2", "code-1", "Service", 21, "5", "33", 4);
        ps.delete("Subject-2");

    }

    @Test
    public void salaryModifierTest() {
        HomePage hp = new HomePage();
        hp.getHomePage();
        hp.login("daulet2030@gmail.com","TechnoStudy123@");

        SalaryModifiersPage sm = new SalaryModifiersPage();
        sm.getPage();

    }

}
