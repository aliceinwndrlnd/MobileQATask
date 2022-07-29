package app.com.mobileassignment.views.pages;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.anything;

import androidx.test.espresso.ViewInteraction;

import java.util.concurrent.TimeUnit;

import app.com.mobileassignment.R;
import io.qameta.allure.kotlin.Step;

public class CitiesListPage extends BasePage {

    private static final ViewInteraction ACTIONBAR = onView(withId(R.id.action_bar));


    @Step("Get result City Name")
    public static int getResultCityName() {
        return R.id.cityName;
    }


    @Step("Match result of Search wth List data")
    public void matchResult(String value) {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        resultMatches(getResultCityName(), value);
    }


    @Step("Click on any City and check the map was opened")
    public void clickOnAnyCity() {
        int random = (int) (Math.random() * 100 + 1);
        onData(anything()).inAdapterView(withId(R.id.citiesList)).atPosition(random).perform(click());
        onView(withId(R.id.citiesList)).check(doesNotExist());
    }

    @Step("Click on any City and after the map was opened press back and check it works or not")
    public void checkBackButton() {
        int random = (int) (Math.random() * 100 + 1);
        onData(anything()).inAdapterView(withId(R.id.citiesList)).atPosition(random).perform(click());
        pressBack();
        elementIsDisplayed(ACTIONBAR);
    }

    @Step("Scroll to any City")
    public void scrollToRandomCity() {
        int random = (int) (Math.random() * 1000 + 1);
        onData(anything()).atPosition(random).perform(scrollTo(), click());
        onView(withId(R.id.citiesList)).check(doesNotExist());
    }

}
