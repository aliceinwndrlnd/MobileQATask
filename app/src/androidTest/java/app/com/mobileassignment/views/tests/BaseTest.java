package app.com.mobileassignment.views.tests;


import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;

import app.com.mobileassignment.views.MainActivity;
import app.com.mobileassignment.views.pages.MainPage;


@RunWith(AndroidJUnit4.class)
public class BaseTest {


    public MainPage mainPage;


    @Before
    public void setUp() {
        mainPage = new MainPage();
    }

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @After
    public void tearDown() {
        mActivityScenarioRule.getScenario().close();
    }
}
