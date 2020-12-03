
package utilities;

import com.codeborne.selenide.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import pageModels.*;
import pageModels.HomePageObjects;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Locale;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static pageModels.Buttons.*;


public class ParentClass implements HomePageObjects, PageObjects, DialogObjects {

    /**
     * set browser size
     * @param size BrowserType enum value
     */
    public void setBrowserSizeTo(BrowserSize size){

        WebDriver driver = WebDriverRunner.getWebDriver();
        switch (size){
            case big:
                driver.manage().window().setPosition(new Point(10, 10));
                driver.manage().window().setSize(new Dimension(1100, 700));
                break;
            case half:
                driver.manage().window().setPosition(new Point(0, 0));
                driver.manage().window().setSize(new Dimension(700, 730));
                break;
            default:
                driver.manage().window().maximize();
                break;
        }
    }

    /**
     * if the left menu is hidden, opens it
     */
    public void openMenu(){
        $(NavMenu).waitUntil(Condition.exist,5000);

        if (!$(ToggleSideBarFolded).isDisplayed())
            $(NavbarToggleButton).shouldBe(Condition.appear).click();

        if (!$(NavMenu).exists()) {
            if ($(ToggleSideBarFolded).exists())
                $(ToggleSideBarFolded).click();
            else if ($(NavbarToggleButton).exists())
                $(NavbarToggleButton).click();
            $(NavMenu).shouldBe(Condition.appear);
        }
    }

    /**
     * if user on the same page
     * @param page NavBarObjects
     * @return boolean
     */
    public boolean userOnSameThePage(NavBarObjects page){
        return $$(By.xpath("//toolbar//*[contains(text(),'" + page.getHeader() + "')]")).size()>0;
    }

    /**
     * click to left menu links, create own xpath's according to goven enum varargs
     * @param page takes NavBarObjects enum
     */
    public void clickOnMenuTo(NavBarObjects page){
        openMenu();

        String[] linkTexts = page.getLinks();

        String strXpath = "//fuse-nav-vertical-group/div/fuse-nav-vertical-collapsable";
        for (int i = 0; i < linkTexts.length; i++) {
            if (linkTexts[i].equalsIgnoreCase("dashboard"))
                strXpath = "(//span[contains(text(),'" + linkTexts[i] + "')])[1]";
            else
                strXpath += "/a/span[contains(text(),'" + linkTexts[i] + "')]";

            $x(strXpath).scrollIntoView(true).click();
            strXpath += "//ancestor::fuse-nav-vertical-collapsable/";
        }
        By headerText = By.xpath("//toolbar//*[contains(text(),'" + page.getHeader() + "')]");
        $$(headerText).shouldHave(CollectionCondition.sizeGreaterThanOrEqual(1));
    }


    /**
     *  notification result according to enum value
     * @param result NotificationResults type enum
     * @return boolean if requirement matches
     */
    public boolean notificationResult(NotificationResults result){
        return $(PopupMessageContainer).getText().toLowerCase().contains(result.toString());
    }

    /**
     * justify if the notification contains wanted value, assertion
     * @param result NotificationResults type enum
     */
    public void justifyNotificationAs(NotificationResults result){
        $(PopupMessageContainer).shouldHave(Condition.text(result.toString()));
    }


    /**
     * click to button in justification dialog
     * @param button, button from Buttons
     */
    public void clickToDialogButton(Buttons button){
        switch (button){
            case Save:
                $(DialogContainerButtonSave).click();
                break;
            case Yes:
                $(DialogContainerButtonYes).click();
                break;
            case No:
                $(DialogContainerButtonNo).click();
                break;
            case Close:
                $(DialogContainerButtonClose).click();
                break;
            case Apply:
                $(DialogButtonApplyWithText).click();
        }
    }


    private By getXpath(String text){
        return By.xpath("//table//*[contains(text(),'" + text + "')]");
    }

    /**
     * search a text in given input field
     * @param inputLocator the locator of input field
     * @param textToSearch text to searc
     */
    public void searchIn(By inputLocator, String textToSearch){
        $(inputLocator).clear();
        $(inputLocator).click();
        $(inputLocator).setValue(textToSearch);
        $(PageButtonSearchWithText).click();
    }

    public void searchIn(By inputLocator, String textToSearch, By selectLocator, String textInSelect){
        selectOption(selectLocator, textInSelect);
        $(inputLocator).click();
        $(inputLocator).clear();
        $(inputLocator).setValue(textToSearch);
        $(PageButtonSearchWithText).click();
    }

    public void searchIn(By inputLocator, String textToSearch, By selectLocator, int optionNumber){
        selectOption(selectLocator, optionNumber);
        $(inputLocator).click();
        $(inputLocator).clear();
        $(inputLocator).setValue(textToSearch);
        $(PageButtonSearchWithText).click();
    }

    public void shouldBeExists(String textToSearch, boolean bool){
        $(By.tagName("table")).shouldBe(Condition.appear);
        if (bool)
            $(getXpath(textToSearch)).should(Condition.appear);
        else
            $(getXpath(textToSearch)).shouldNot(Condition.appear);
    }

    /**
     * controls if the given text exists in the table
     * @param textToBeSearched text to be searched
     * @return true if the given text found
     */
    public boolean isDataExistsInTable(String textToBeSearched){
        $(By.tagName("table")).shouldBe(Condition.appear);
        //By byTr = By.xpath("//*[contains(text(),'" + textToBeSearched + "')]");
        return $(getXpath(textToBeSearched)).exists();
    }


    /**
     * clicks the given button in the table row, delete or edit
     * @param by the locator of button to be clicked, delete or edit
     * @param textToBeSearched the required text in the row
     */
    private void clickToEditDeleteButtonInTable(By by, String textToBeSearched){
        By row = By.xpath("//*[contains(text(),'" + textToBeSearched + "')]//ancestor::tr");
        if (!$(TableButtonDialogEditDeleteButton).isEnabled()) {
            $(row).find(TableButtonDialogEditDeleteButton).click();
            $(TableButtonDialogEditDeleteDialog).find(by).click();
        }else {
            $(row).find(by).click();
        }
    }

    /**
     * delete the table row data
     * @param textToBeSearched the required text in the row
     */
    public boolean deleteTheTableData(String textToBeSearched){
        clickToEditDeleteButtonInTable(TableButtonDelete, textToBeSearched);
        clickToDialogButton(Yes);
        return notificationResult(NotificationResults.deleted);
    }

    /**
     * edit the table row data
     * @param textToBeSearched the required text in the row
     */
    public void editTheTableData(String textToBeSearched){
        clickToEditDeleteButtonInTable(TableButtonEdit, textToBeSearched);
        $(DialogContainer).shouldBe(Condition.enabled);
    }

    /**
     * edit the table row data
     * @param textToBeSearched the required text in the row
     */
    public void addPositionSalaryButtonInTable(String textToBeSearched){
        clickToEditDeleteButtonInTable(PageFormButtonAddPositionSalary, textToBeSearched);
    }

    /**
     * converts the given text to Buttons type enum
     * @param buttonText text to be changed
     * @return Buttons type enum
     */
    public Buttons getButtonFromText(String buttonText){
        if (buttonText.toLowerCase().contains("save"))
            return Save;
        else if (buttonText.toLowerCase().contains("yes"))
            return Yes;
        else if (buttonText.toLowerCase().contains("no"))
            return No;
        else
            return Close;
    }

    /**
     * select option from dropdown by text
     * @param by locator of select
     * @param optionText text of wanted option
     */
    public void selectOption(By by, String optionText){
        $(by).click();
        $$(ListOfOptions)
                .findBy(Condition.matchesText(optionText))
                //.scrollIntoView(true)
                //.shouldBe(Condition.visible)
                .click();
    }

    /**
     * select option from dropdown by index
     * @param by locator of select
     * @param optionNumber index of wanted option
     */
    public void selectOption(By by, int optionNumber){
        $(by).click();
        $$(ListOfOptions)
                .get(optionNumber)
                //.scrollIntoView(true)
                //.shouldBe(Condition.visible)
                .click();
    }

    /**
     * select option from opened dropdown by text
     * @param optionText text of wanted option
     */
    public void selectOption(String optionText){
        $$(ListOfOptions)
                .findBy(Condition.matchesText(optionText))
                .scrollIntoView(true)
                .shouldBe(Condition.visible).click();
    }

    /**
     * select option from opened dropdown by index
     * @param optionNumber index of wanted option
     */
    public void selectOption(int optionNumber){
        $$(ListOfOptions)
                .get(optionNumber)
                .scrollIntoView(true)
                .shouldBe(Condition.visible).click();
    }

    /**
     * deletes the multiple select option input values
     * @param by locator of multi select
     */
    public void deleteMultiSelectOptions(By by){
        for (WebElement element : $$(by))
            element.click();
    }

    /**
     * select multi option from opened multi select dropdown by text
     * @param by locator of multi select
     * @param optionTexts text of wanted option as varargs
     */
    public void selectOptionMulti(By by, String...optionTexts){
        WebElement option = null;

        for (int i=0; i<optionTexts.length; i++) {
            $(by).click();
            for (WebElement element : $$(ListOfOptions)) {
                if (element.getText().equalsIgnoreCase(optionTexts[i])){
                    option = element;
                    break;
                }
            }
            option.click();
        }
    }

    /**
     * select multi option from opened multi select dropdown by index
     * @param by locator of multi select
     * @param optionNumbers index of wanted option as varargs
     */
    public void selectOptionMulti(By by, int...optionNumbers){
        for (int i=0; i<optionNumbers.length; i++) {
            $(by).click();
            ElementsCollection list = $$(ListOfOptions);
            if (optionNumbers[i] >= list.size())
                optionNumbers[i] = list.size()-1;
            else if (optionNumbers[i] < 0)
                optionNumbers[i] = 0;
            $$(ListOfOptions).get(optionNumbers[i]).click();
        }
    }

    /**
     * returns if the string consist of numbers
     * @param strNum string to get value
     * @return boolean
     */
    public boolean isInteger(String strNum){
        try {
            int i = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }


    /**
     * returns if the string consist of numbers
     * @param strNum string to get value
     * @return boolean
     */
    public int getIntVal(String strNum){
        try {
            return Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return Integer.MIN_VALUE;
        }
    }



    //////////////////////////////////////////////////////////////////////////
    //                  calander methods
    //////////////////////////////////////////////////////////////////////////

    /**
     * send keys to calander inputbox
     * @param dateField locator of date inputbox
     * @param date date to send
     */
    public void sendKeysToCalander(By dateField, LocalDate date){
        String dataToUSFormat = date.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        $(dateField).setValue(dataToUSFormat);
        if ($(Calender).exists()){
            $(OverlayContainer).click();
        }
    }

    /**
     * converts string to date
     * @param isoDate string of iso type date format (yyyy-MM-dd)
     * @return locale date
     */
    public LocalDate stringToDate(String isoDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(isoDate, formatter);
    }

    /**
     * gets the year, month, day as array
     * @param dateStr date string
     * @return array of (yyyy, mm, dd)
     */
    public String[] getYearMonthDayAsArray(String dateStr){
        String[] yearMonthDay = dateStr.split("-");
        LocalDate date = stringToDate(dateStr);
        yearMonthDay[1] = date.getMonth().getDisplayName(TextStyle.SHORT, Locale.ENGLISH).toUpperCase();
        return yearMonthDay;
    }

    /**
     * compares of the required month and calander month
     * @param month required month
     * @param monthCalender calander month
     * @return index of the given month
     */
    public int compareMonths(String month, String monthCalender){
        LinkedList<String> months =
                new LinkedList<>(Arrays.asList("JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"));
        int indexOfMonth = months.indexOf(month);
        int indexOfMonthCalender = months.indexOf(monthCalender);
        if (indexOfMonth > indexOfMonthCalender) return 1;
        else if (indexOfMonth < indexOfMonthCalender) return -1;
        else return 0;
    }

    /**
     * compares of the required monthYear and monthYearCalender (mm-yyyy)
     * @param monthYear required mm-yyyy
     * @param monthYearCalender calander mm-yyyy
     * @return an integer 1:1 year left, 2:1 month left, 3:1 month right, 4:1 year right
     */
    public int compareMonthYear(String monthYear, String monthYearCalender){

        String month = monthYear.replaceAll("[^A-Z]+","");
        int year = Integer.parseInt(monthYear.replaceAll("[^0-9]+",""));
        String monthCalender = monthYearCalender.replaceAll("[^A-Z]+","");
        int yearCalender = Integer.parseInt(monthYearCalender.replaceAll("[^0-9]+",""));

        if (year < yearCalender) return 1;
        if (year > yearCalender) return 4;
        if (compareMonths(month, monthCalender)==-1) return 2;
        if (compareMonths(month, monthCalender)==1) return 3;
        return 0;
    }

    /**
     * sets the calander date
     * @param dateStr wanted date as iso format (yyyy-mm-dd)
     */
    public void setCalenderDate(String dateStr){
        String[] dateArray = getYearMonthDayAsArray(dateStr);
        String monthYear = dateArray[1] + " " + dateArray[0];
        String monthYearCalender;
        do{
            monthYearCalender = $(CalanderMonthYearText).getText().trim();
            switch (compareMonthYear(monthYear, monthYearCalender)){
                case 1: $(CalanderPreviousYear).click(); break;
                case 2: $(CalanderPreviousMonth).click(); break;
                case 3: $(CalanderNextMonth).click(); break;
                case 4: $(CalanderNextYear).click(); break;
            }
            //$(byCalanderMonthYearText).shouldNotHave(Condition.text(monthYearCalender));
        }while (compareMonthYear(monthYear, monthYearCalender)!=0);

        String day = Integer.parseInt(dateArray[2]) + "";
        $(CalanderMonthTable).$(byText(day)).click();
    }


    /**
     * takeScreenshot
     * @param fileName		fileName
     */
    public void takeScreenshot(String fileName){
        String directoryPath = "screenshots/";
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdir();
        }

        File file = ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.FILE);

        String dt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH.mm.ss"));
        String filePath = directoryPath + fileName + "_" + Thread.currentThread().getName() + "_" + dt + ".png";
        try {
            FileUtils.copyFile(file, new File(filePath));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}


