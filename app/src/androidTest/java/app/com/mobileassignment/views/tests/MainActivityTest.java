package app.com.mobileassignment.views.tests;


import androidx.test.filters.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;


@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class MainActivityTest extends BaseTest {


    @Description("Checking that after apk's start the title of the Main Screen is visible and have a correct value")
    @Test
    public void appHeaderTest() {

        mainPage.checkTheAppsTitle();
    }

    @Description("Checking that after apk's start the search field is visible and empty")
    @Test
    public void searchFieldIsDisplayed() {

        mainPage.checkTheSearchField();
        mainPage.checkEmptyInputField();
    }

    @Description("Checking that after apk's start cities list is visible")
    @Test
    public void cityListIsDisplayed() {

        mainPage.checkTheCitiesList();
    }
}
