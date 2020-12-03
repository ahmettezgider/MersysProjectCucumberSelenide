package runners;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.*;


public class TestNGFull {
    HomePage homePage;

    @BeforeTest
    public void beforeTest(){
        homePage = new HomePage();
        homePage.getHomePage();
        homePage.login("daulet2030@gmail.com","TechnoStudy123@");
    }

    @AfterTest
    public void afterTest(){
        homePage.logout();
    }


    @Test(priority = 1)
    public void menuTest() {
        //homePage.clickOnMenuTo(NavBarObjects.Dashboard);
        //homePage.clickOnMenuTo(NavBarObjects.Cities);
        //homePage.clickOnMenuTo(NavBarObjects.Positions);
        //homePage.clickOnMenuTo(NavBarObjects.ExcelTemplate);
    }

    @Test(priority = 2)
    public void countryTest() {
        CountryPage cp = new CountryPage();
        cp.getPage();
        cp.add("Turkey123", "tr123");
        cp.update("Turkey123", "Turkey1234", "tr1234");
        cp.delete("Turkey1234");
    }

    @Test(priority = 3)
    public void cityTest() {
        CityPage cp = new CityPage();
        cp.getPage();
        cp.add("Turkey", "KKK");
        cp.update("KKK", "KKK1");
        cp.delete("KKK1");
    }


    @Test(priority = 4)
    public void subjectCategoriesTest() {
        SubjectCategoriesPage scp = new SubjectCategoriesPage();
        scp.getPage();
        scp.add("new Category-1", "nc1");
        scp.update("new Category-1", "new Category-2", "nc2");
        scp.delete("new Category-2");
    }

    @Test(priority = 5)
    public void subjectTest() {
        SubjectsPage sp = new SubjectsPage();
        sp.getPage();
        sp.add("Subject-1", "s1", 1, 5);
        sp.update("Subject-1", "Subject-2", "s2", 0, 0);
        sp.delete("Subject-2");
    }


    @Test(priority = 6)
    public void positionSalaryTest() {
        PositionSalaryPage ps = new PositionSalaryPage();
        ps.getPage();
        ps.add("Subject-1");
        ps.update("Subject-1", "Subject-2");
        ps.delete("Subject-2");
    }


    @Test(priority = 7)
    public void positionTest() {
        PositionsPage ps = new PositionsPage();
        ps.getPage();
        ps.add("Subject-1", "S1");
        ps.update("Subject-1", "Subject-2", "S2");
        ps.delete("Subject-2");
    }


    @Test(priority = 8)
    public void salaryTypeTest() {
        SalaryTypesPage ps = new SalaryTypesPage();
        ps.getPage();
        ps.add("Subject-1", "User");
        ps.update("Subject-1", "Subject-2", "user");
        ps.delete("Subject-2");

        ps.add("Subject-1", 7);
        ps.update("Subject-1", "Subject-2", 1);
        ps.delete("Subject-2");

    }

    @Test(priority = 9)
    public void salaryConstantsTest() {
        SalaryConstantsPage ps = new SalaryConstantsPage();
        ps.getPage();
        ps.add("Subject-1", "2019-01-01", "s123", 10);
        ps.update("Subject-1","Subject-2", "2020-01-01", "xs123", 2);
        ps.delete("Subject-2");
    }

    @Test(priority = 10)
    public void exelTempleteTest() {
        ExcelTemplatePage ps = new ExcelTemplatePage();
        ps.getPage();
        ps.add("Subject-1", 2);
        ps.update("Subject-1","Subject-2", 1);
        ps.delete("Subject-2");
    }

    @Test(priority = 11)
    public void costCentersTest() {
        CostCentersPage ps = new CostCentersPage();
        ps.getPage();
        ps.add("Subject-1", "code-1", "Service", 21, "5", "33", 3);
        ps.update("Subject-1", "Subject-2", "code-1", "Service", 21, "5", "33", 4);
        ps.delete("Subject-2");

    }

    @Test(priority = 12)
    public void salaryModifierTest() {
        SalaryModifiersPage sm = new SalaryModifiersPage();
        sm.getPage();

    }
}
