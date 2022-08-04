package app.com.mobileassignment.views.tests;


import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import static app.com.mobileassignment.views.pages.TestData.*;


@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest extends BaseTest {

    @DisplayName("Checking that after apk's start the title of the Main Screen is visible and have a correct value")
    @Test
    public void appHeaderTest() {

        mainPage.checkTheAppsTitle();
    }

    @DisplayName("Checking that after apk's start the search field is visible and empty")
    @Test
    public void searchFieldIsDisplayed() {

        mainPage.checkTheSearchField();
        mainPage.checkEmptyInputField();
    }

    @DisplayName("Checking that after apk's start cities list is visible")
    @Test
    public void cityListIsDisplayed() {

        mainPage.checkTheCitiesList();
    }

    @DisplayName("Scroll to any City, click and check that click was performed")
    @Test
    public void scrollToAnyCity() {
        mainPage.scrollToRandomCity();

    }

    @DisplayName("Checking work of Search by whole name")
    @Test
    public void checkSearchingByWholeName() {
        mainPage
                .inputData(getCityName1ForTest());
        mainPage.matchResult(getCityHoeksken());
    }

    @DisplayName("Checking work of Search without special symbols")
    @Test
    public void checkSearchingWithoutSpecialSymbols() {
        mainPage
                .inputData(getCityName2ForTest());
        mainPage.matchResult(getCityHoeksken());
    }

    @DisplayName("Click on random city and check click was performed")
    @Test
    public void clickOnAnyCity() {
        mainPage
                .clickOnAnyCity();
    }

    @DisplayName("Checking that Back button's work")
    @Test
    public void checkBackButtonWorks() {
        mainPage.checkBackButton();
    }

    @DisplayName("Checking that Search field converts foreign letters")
    @Test
    public void checkSearchResultWithSpecialSymbols() {
        mainPage
                .inputData(getCityName3ForTest());
        mainPage.matchResult(getCityCaniza());
    }

    @DisplayName("Checking that App doesn't crash after input a lot of symbols")
    @Test
    public void checkSearchingWithALotOfSymbols() {
        mainPage.inputData(getSymbols());

        mainPage.checkTheCitiesList();
    }
}
