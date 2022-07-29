package app.com.mobileassignment.views.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;

import app.com.mobileassignment.R;
import app.com.mobileassignment.views.MainActivity;

public class BasePage {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);


    public static void clickToElement(Integer resourceId) {
        onView(withId(resourceId))
                .perform(click())
                .check(matches(isDisplayed()));
    }

    public static void resultMatches(Integer resourceId, String value) {
        onView(allOf(withId(resourceId), withText(value)))
                .check(matches(isDisplayed()));
    }

    public static void elementIsDisplayed(ViewInteraction element) {
        element.check(matches(isDisplayed()));
    }

    public void inputData(String cityName) {
        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.search), isDisplayed()));
        appCompatEditText.perform(replaceText(cityName), closeSoftKeyboard());
    }


}
