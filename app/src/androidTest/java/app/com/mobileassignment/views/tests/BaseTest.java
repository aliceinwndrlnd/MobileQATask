package app.com.mobileassignment.views.tests;


import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;

import app.com.mobileassignment.views.MainActivity;
import app.com.mobileassignment.views.pages.CitiesListPage;
import app.com.mobileassignment.views.pages.MainPage;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class BaseTest {


    public MainPage mainPage;
    public CitiesListPage citiesListPage;


    @Before
    public void setUp() {
        mainPage = new MainPage();
        citiesListPage = new CitiesListPage();
    }

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @After
    public void tearDown() {
        mActivityScenarioRule.getScenario().close();
    }
}
