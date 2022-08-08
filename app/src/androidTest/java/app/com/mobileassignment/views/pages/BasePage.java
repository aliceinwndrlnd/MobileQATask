package app.com.mobileassignment.views.pages;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import app.com.mobileassignment.R;
import app.com.mobileassignment.views.MainActivity;
import org.junit.Rule;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.core.AllOf.allOf;


public class BasePage {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);


    public static void clickToElement(Integer resourceId) {
        int random = (int) (Math.random() * 1000 + 1); //it was a 209557 value (size of city list), but scroll takes a lot of time because of it
        onData(anything()).inAdapterView(withId(resourceId)).atPosition(random).perform(click());
    }

    public static void resultMatches(Integer resourceId, String value) {
        onView(allOf(withId(resourceId), withText(value)))
                .check(matches(isDisplayed()));
    }

    public static void assertThatElementIsDisplayed(ViewInteraction element) {

        element.check(matches(isDisplayed()));
    }

    public void inputData(String cityName) {
        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.search), isDisplayed()));
        appCompatEditText.perform(replaceText(cityName), closeSoftKeyboard());
    }

    public void assertThatElementDoesNotExist(Integer resourceId) {

        onView(withId(resourceId)).check(doesNotExist());
    }
}
