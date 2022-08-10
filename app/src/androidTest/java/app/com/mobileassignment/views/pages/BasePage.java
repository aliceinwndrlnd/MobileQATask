package app.com.mobileassignment.views.pages;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isFocusable;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.core.AllOf.allOf;
import static app.com.mobileassignment.views.waiter.Waiter.waitFor;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;

import app.com.mobileassignment.views.MainActivity;


public class BasePage {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);


    public void clickToElement(Integer resourceId) {
        int random = (int) (Math.random() * 1000 + 1); //it was a 209557 value (size of city list), but scroll takes a lot of time because of it
        onData(anything()).inAdapterView(withId(resourceId)).atPosition(random).perform(click());
    }

    public void resultMatches(Integer resourceId, String value) {
        onView(allOf(withId(resourceId), withText(value)))
                .check(matches(isDisplayed()));
    }

    public void checkEmptyInputField(Integer resourceID) {

        onView(withId(resourceID)).check(matches(allOf(
                withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE),
                isFocusable(),
                isClickable(),
                withText(isEmptyString())
        )));
    }

    public void checkThatElementIsDisplayed(Integer resourceId) {

        onView(allOf(withId(resourceId), isDisplayed()));
    }

    public void assertThatElementDoesNotExist(ViewInteraction element) {

        element.check(doesNotExist());
    }

    public void inputData(Integer resourceID, String cityName) {
        ViewInteraction elementText = onView(
                allOf(withId(resourceID), isDisplayed()));
        elementText.perform(replaceText(cityName), closeSoftKeyboard());
    }

    public void pressBackButton() {
        pressBack();
    }

    public void matchChildResults(Integer resourceId, Integer resourceIdChild, String value) {
        onData(anything()).inAdapterView(withId(resourceId))
                .atPosition(0)
                .onChildView(withId(resourceIdChild))
                .check(matches(withText(containsString(value))));
    }

    public void checkTheAppsTitleHasACorrectValue(String text, Integer resourceId, Integer resourceIdChild) {
        ViewInteraction textView = onView(
                allOf(withText(text),
                        withParent(allOf(withId(resourceId),
                                withParent(withId(resourceIdChild))))));
        textView.check(matches(withText(text)));
    }
}
