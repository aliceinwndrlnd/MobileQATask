package app.com.mobileassignment.views.pages;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.core.AllOf.allOf;

import androidx.test.espresso.ViewInteraction;
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

    public void checkThatElementIsDisplayed(Integer resourceId) {

        onView(allOf(withId(resourceId), isDisplayed()));
    }

    public void assertThatElementDoesNotExist(ViewInteraction element) {

        element.check(doesNotExist());
    }

    public void pressBackButton() {
        pressBack();
    }

}
