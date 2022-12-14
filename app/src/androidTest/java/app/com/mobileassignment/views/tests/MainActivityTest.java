package app.com.mobileassignment.views.tests;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static app.com.mobileassignment.views.testData.TestData.getAppsTitle;
import static app.com.mobileassignment.views.testData.TestData.getCityAbbotsford;
import static app.com.mobileassignment.views.testData.TestData.getCityAbbotsfordLowerCase;
import static app.com.mobileassignment.views.testData.TestData.getCityAbbotsfordUpperCase;
import static app.com.mobileassignment.views.testData.TestData.getCityCaniza;
import static app.com.mobileassignment.views.testData.TestData.getCityHoeksken;
import static app.com.mobileassignment.views.testData.TestData.getCityName1ForTest;
import static app.com.mobileassignment.views.testData.TestData.getCityName2ForTest;
import static app.com.mobileassignment.views.testData.TestData.getCityName3ForTest;
import static app.com.mobileassignment.views.testData.TestData.getPackageName;
import static app.com.mobileassignment.views.testData.TestData.getSymbols;

import android.content.pm.ActivityInfo;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;


@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest extends BaseTest {


    @DisplayName("Checking that after apk's start the title of the Main Screen is visible and have a correct value")
    @Test
    public void appHeaderTestTS001() {
        mainPage.checkThatElementIsDisplayed(mainPage.getActionBar());
        mainPage.checkTheAppsTitleHasACorrectValue(getAppsTitle());
    }

    @DisplayName("Checking that after apk's start the search field is visible and empty")
    @Test
    public void searchFieldIsDisplayedTS002() {

        mainPage.checkThatElementIsDisplayed(mainPage.getSearch());
        mainPage.checkEmptyInputField();
    }

    @DisplayName("Checking that after apk's start cities list is visible")
    @Test
    public void cityListIsDisplayedTS003() {

        mainPage.checkThatElementIsDisplayed(mainPage.getCitiesList());
        assertThat(mainPage.getCitiesList()).isNotNull();
    }


    @DisplayName("Checking work of Search with upper case")
    @Test
    public void searchWithUpperCaseTS004() {
        mainPage.inputData(getCityAbbotsfordUpperCase());
        mainPage.matchChildResults(getCityAbbotsford());
    }

    @DisplayName("Checking work of Search with lower case")
    @Test
    public void searchWithLowerCaseTS005() {
        mainPage.inputData(getCityAbbotsfordLowerCase());
        mainPage.matchChildResults(getCityAbbotsford());
    }

    @DisplayName("Checking that Back button's work")
    @Test
    public void checkBackButtonWorksTS006() {
        mainPage.clickToElement(mainPage.getCitiesList());
        mainPage.checkThatElementIsDisplayed(mainPage.getMapPoint());
        mainPage.pressBackButton();
    }

    @DisplayName("Click on random city and check click was performed")
    @Test
    public void clickOnAnyCityTS007() {
        mainPage.clickToElement(mainPage.getCitiesList());
        mainPage.checkThatElementIsDisplayed(mainPage.getMapPoint());
        mainPage.assertThatElementDoesNotExist(mainPage.getCityList());
    }

    @DisplayName("Checking work of Search by whole City name")
    @Test
    public void checkSearchingByWholeNameTS008() {
        mainPage
                .inputData(getCityName1ForTest());
        mainPage.resultMatches(getCityHoeksken());
    }

    @DisplayName("Checking work of Search without special symbols")
    @Test
    public void checkSearchingWithoutSpecialSymbolsTS009() {
        mainPage
                .inputData(getCityName2ForTest());
        mainPage.resultMatches(getCityHoeksken());
    }

    @DisplayName("Checking work of Search when we input City name which contains letters from foreign alphabet with regular letters")
    @Test
    public void checkSearchResultWithForeignLettersTS010() {
        mainPage
                .inputData(getCityName3ForTest());
        mainPage.resultMatches(getCityCaniza());
    }

    @DisplayName("Checking that App doesn't crash after input a lot of special symbols")
    @Test
    public void checkSearchingWithALotOfSymbolsTS011() {
        mainPage
                .inputData(getSymbols());

        mainPage.checkElementsAreDisplayed(mainPage.getActionBar(), mainPage.getSearch(), mainPage.getCitiesList());
    }

    @DisplayName("Count search results")
    @Test
    public void countResultsTS012() {
        mainPage.inputData(getCityAbbotsford());
        mainPage.assertCountResults(4);
    }

    @DisplayName("Verify app's package name")
    @Test
    public void packageNameTestTS013() {
        assertEquals(getPackageName(), appContext.getPackageName());
    }

    @DisplayName("Check screen orientation")
    @Test
    public void screenOrientationTestTS014() {
        mActivityScenarioRule.
                getScenario().onActivity(activity -> activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE));
        mainPage.checkElementsAreDisplayed(mainPage.getActionBar(), mainPage.getSearch(), mainPage.getCitiesList());
    }
}
