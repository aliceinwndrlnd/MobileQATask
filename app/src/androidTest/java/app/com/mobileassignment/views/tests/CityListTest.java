package app.com.mobileassignment.views.tests;


import androidx.test.filters.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class CityListTest extends BaseTest {

    private static final String cityHoeksken = "'t Hoeksken, BE";
    private static final String cityCaniza = "A Cañiza, ES";
    private static final String cityName1ForTest = "'t Hoeksken";
    private static final String cityName2ForTest = "Hoeksken";
    private static final String cityName3ForTest = "A Caniza";
    private static final String symbols = "#$%^&*((*&^%$#@$%^&*()(*&^%$#$%^&*()P)(*&^%$%^&*(";

    @Description("Scroll to any City, click and check that click was performed")
    @Test
    public void scrollToAnyCity() {
        citiesListPage.scrollToRandomCity();
    }

    @Description("Checking work of Search by whole name")
    @Test
    public void checkSearchingByWholeName() {
        citiesListPage
                .inputData(cityName1ForTest);
        citiesListPage.matchResult(cityHoeksken);
    }

    @Description("Checking work of Search without special symbols")
    @Test
    public void checkSearchingWithoutSpecialSymbols() {
        citiesListPage
                .inputData(cityName2ForTest);
        citiesListPage.matchResult(cityHoeksken);
    }

    @Description("Click on random city and check click was performed")
    @Test
    public void clickOnAnyCity() {
        citiesListPage
                .clickOnAnyCity();
    }

    @Description("Checking that Back button's work")
    @Test
    public void checkBackButtonWorks() {
        citiesListPage
                .checkBackButton();
    }

    @Description("Checking that Search field converts foreign letters")
    @Test
    public void checkSearchResultWithSpecialSymbols() {
        citiesListPage
                .inputData(cityName3ForTest);
        citiesListPage.matchResult(cityCaniza);
    }

    @Description("Checking that App doesn't crash after input a lot of symbols")
    @Test
    public void checkSearchingWithALotOfSymbols() {
        citiesListPage.inputData(symbols);

        mainPage.checkTheCitiesList();
    }
}
