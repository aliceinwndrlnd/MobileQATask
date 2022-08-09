package app.com.mobileassignment.views.tests;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import static app.com.mobileassignment.views.testData.TestData.*;

import app.com.mobileassignment.R;


@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest extends BaseTest {


    @DisplayName("Checking that after apk's start the title of the Main Screen is visible and have a correct value")
    @Test
    public void appHeaderTestTS001() {
        mainPage.checkThatElementIsDisplayed(mainPage.ACTIONBAR);
        mainPage.checkTheAppsTitleHasACorrectValue();
    }

    @DisplayName("Checking that after apk's start the search field is visible and empty")
    @Test
    public void searchFieldIsDisplayedTS002() {

        mainPage.checkThatElementIsDisplayed(mainPage.SEARCH_FIELD);
        mainPage.checkEmptyInputField();
    }

    @DisplayName("Checking that after apk's start cities list is visible")
    @Test
    public void cityListIsDisplayedTS003() {

        mainPage.checkThatElementIsDisplayed(mainPage.CITIES_LIST);
    }


    @DisplayName("Checking work of Search with upper case")
    @Test
    public void searchWithUpperCaseTS004() {
        mainPage.inputData(getCityAbbotsfordUpperCase());
        mainPage.waiter(1000);
        mainPage.matchResults(getCityAbbotsford());

    }

    @DisplayName("Checking work of Search with lower case")
    @Test
    public void searchWithLowerCaseTS005() {
        mainPage.inputData(getCityAbbotsfordLowerCase());
        mainPage.waiter(1000);
        mainPage.matchResults(getCityAbbotsford());
    }

    @DisplayName("Checking that Back button's work")
    @Test
    public void checkBackButtonWorksTS006() {
        mainPage.clickOnAnyCity();
        mainPage.checkThatElementIsDisplayed(mainPage.MAP_POINT);
        mainPage.pressBackButton();
    }

    @DisplayName("Click on random city and check click was performed")
    @Test
    public void clickOnAnyCityTS007() {
        mainPage.clickToElement(R.id.citiesList);
        mainPage.checkThatElementIsDisplayed(mainPage.MAP_POINT);
    }

    @DisplayName("Checking work of Search by whole City name")
    @Test
    public void checkSearchingByWholeNameTS008() {
        mainPage
                .inputData(getCityName1ForTest());
        mainPage.waiter(1000);
        mainPage.matchResult(getCityHoeksken());
    }

    @DisplayName("Checking work of Search without special symbols")
    @Test
    public void checkSearchingWithoutSpecialSymbolsTS009() {
        mainPage
                .inputData(getCityName2ForTest());
        mainPage.waiter(1000);
        mainPage.matchResult(getCityHoeksken());
    }

    @DisplayName("Checking work of Search when we input City name which contains letters from foreign alphabet with regular letters")
    @Test
    public void checkSearchResultWithForeignLettersTS010() {
        mainPage
                .inputData(getCityName3ForTest());
        mainPage.waiter(1000);
        mainPage.matchResult(getCityCaniza());
    }

    @DisplayName("Checking that App doesn't crash after input a lot of special symbols")
    @Test
    public void checkSearchingWithALotOfSymbolsTS011() {
        mainPage
                .inputData(getSymbols());
        mainPage.checkThatElementIsDisplayed(mainPage.CITIES_LIST);
        mainPage.checkThatElementIsDisplayed(mainPage.ACTIONBAR);
    }
}
