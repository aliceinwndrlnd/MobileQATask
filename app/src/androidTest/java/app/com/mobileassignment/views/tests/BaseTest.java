package app.com.mobileassignment.views.tests;


import android.content.Context;
import android.content.pm.ActivityInfo;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;

import app.com.mobileassignment.views.MainActivity;
import app.com.mobileassignment.views.pages.MainPage;


@RunWith(AndroidJUnit4.class)
public class BaseTest {


    protected MainPage mainPage;
    protected Context appContext;
    protected int orientation;



    @Before
    public void setUp() {
        mainPage = new MainPage();
        appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        orientation = InstrumentationRegistry.getInstrumentation().getTargetContext().getResources().getConfiguration().orientation;
    }

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @After
    public void tearDown() {
        mActivityScenarioRule.getScenario().close();
    }
}
