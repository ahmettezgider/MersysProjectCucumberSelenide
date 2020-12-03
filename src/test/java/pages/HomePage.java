package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.NoSuchElementException;
import pageModels.BrowserSize;
import pageModels.NavBarObjects;
import utilities.ParentClass;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomePage extends ParentClass {


    public void getHomePage(){
        String url = "https://test.basqar.techno.study/";

        try {
            WebDriverRunner.getWebDriver().getCurrentUrl();
        }catch (Exception e){
            open(url);
            setBrowserSizeTo(BrowserSize.max);
        }
    }


    public void prepareLogin(){
        if (!isLoggedIn()) {
            if (!$(LoginButton).exists()){
                $(UserButton).click();
            }

            if ($(CookieDialogBox).waitUntil(Condition.exist, 2).isDisplayed()) {
                $(CookieDialogBox).find(CookieDialogButton).click();
            }
        }
    }


    public void login(){

        prepareLogin();

        if (!isLoggedIn()) {
            $(LoginButton).shouldBe(Condition.exist);
            $(LoginPageUserName).setValue("daulet2030@gmail.com");
            $(LoginPagePassword).setValue("TechnoStudy123@");
            $(LoginPageSubmitButton).click();
        }
    }

    /**
     * login site
     * @param username username
     * @param password  password
     */
    public void login(String username, String password){
        prepareLogin();
        if (!isLoggedIn()) {
            $(LoginButton).shouldBe(Condition.exist);
            $(LoginPageUserName).setValue(username);
            $(LoginPagePassword).setValue(password);
            $(LoginPageSubmitButton).click();
        }
    }

    public void clearLoginFields(){
        $(LoginPageUserName).clear();
        $(LoginPagePassword).clear();
    }

    public void logout(){
        openMenu();
        if ($(UserMenuVisible).exists()){
            $(UserMenuVisible).click();
        }else{
            clickOnMenuTo(NavBarObjects.Dashboard);
            openMenu();
            $(UserMenuHidden).click();
        }
        $(Logout).click();
    }

    private boolean isLoggedIn(){
        return $(UserMessageBell).exists();
    }

}
