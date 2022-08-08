package app.com.mobileassignment.views.tests;


import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import static app.com.mobileassignment.views.testData.TestData.*;


@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest extends BaseTest {

    @DisplayName("Checking that after apk's start the title of the Main Screen is visible and have a correct value")
    @Test
    public void appHeaderTestTS001() {

        mainPage.checkTheAppsTitle();
    }

    @DisplayName("Checking that after apk's start the search field is visible and empty")
    @Test
    public void searchFieldIsDisplayedTS002() {

        mainPage.checkTheSearchFieldIsDisplayed();
        mainPage.checkEmptyInputField();
    }

    @DisplayName("Checking that after apk's start cities list is visible")
    @Test
    public void cityListIsDisplayedTS003() {

        mainPage.checkTheCitiesList();
    }

    @DisplayName("Scroll to any City, click and check that click was performed")
    @Test
    public void scrollToAnyCityTS004() {

        mainPage.scrollToRandomCity();
    }

    @DisplayName("Checking that Back button's work")
    @Test
    public void checkBackButtonWorksTS005() {

        mainPage.checkBackButton();
    }

    @DisplayName("Click on random city and check click was performed")
    @Test
    public void clickOnAnyCityTS006() {
        mainPage
                .clickOnAnyCity();
    }

    @DisplayName("Checking work of Search by whole City name")
    @Test
    public void checkSearchingByWholeNameTS007() {
        mainPage
                .inputData(getCityName1ForTest());
        mainPage.matchResult(getCityHoeksken());
    }

    @DisplayName("Checking work of Search without special symbols")
    @Test
    public void checkSearchingWithoutSpecialSymbolsTS008() {
        mainPage
                .inputData(getCityName2ForTest());
        mainPage.matchResult(getCityHoeksken());
    }

    @DisplayName("Checking work of Search when we input City name which contains letters from foreign alphabet with regular letters")
    @Test
    public void checkSearchResultWithForeignLettersTS009() {
        mainPage
                .inputData(getCityName3ForTest());
        mainPage.matchResult(getCityCaniza());
    }

    @DisplayName("Checking that App doesn't crash after input a lot of special symbols")
    @Test
    public void checkSearchingWithALotOfSymbolsTS010() {
        mainPage
                .inputData(getSymbols());
        mainPage.checkTheCitiesList();
        mainPage.checkTheAppsTitle();
    }
}
