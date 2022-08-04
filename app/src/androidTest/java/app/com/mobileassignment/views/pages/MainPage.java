package app.com.mobileassignment.views.pages;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.ViewMatchers;
import app.com.mobileassignment.R;
import java.util.concurrent.TimeUnit;

import static androidx.test.espresso.Espresso.*;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.core.AllOf.allOf;
import static org.junit.Assert.*;


public class MainPage extends BasePage {

    private static final ViewInteraction ACTIONBAR = onView(withId(R.id.action_bar));
    private static final ViewInteraction SEARCH_FIELD = onView(withId(R.id.search));
    private static final ViewInteraction CITIES_LIST = onView(withId(R.id.citiesList));


    //@Step("The app is started/Checking the header of the main screen")
    public void checkTheAppsTitle() {
        ViewInteraction textView = onView(
                allOf(withText("Mobile Assignment"),
                        withParent(allOf(withId(androidx.appcompat.R.id.action_bar),
                                withParent(withId(androidx.appcompat.R.id.action_bar_container)))),
                        isDisplayed()));
        textView.check(matches(withText("Mobile Assignment")));
    }

    //@Step("The app is started/Checking the search field is displayed")
    public void checkTheSearchField() {

        elementIsDisplayed(SEARCH_FIELD);
    }

    //@Step("The app is started/Checking that search field is empty and clickable")
    public void checkEmptyInputField() {

        onView(withId(R.id.search)).check(matches(allOf(
                withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE),
                isFocusable(),
                isClickable(),
                withText("")
        )));
    }

    //@Step("The app is started/Checking the Cities list")
    public void checkTheCitiesList() {

        elementIsDisplayed(CITIES_LIST);
    }

    //@Step("Get result City Name")
    public static int getResultCityName() {

        return R.id.cityName;
    }


    //@Step("Match result of Search wth List data")
    public void matchResult(String value) {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        resultMatches(getResultCityName(), value);
    }


    //@Step("Click on any City and check the map was opened")
    public void clickOnAnyCity() {
        clickToElement(R.id.citiesList);
        onView(withId(R.id.citiesList)).check(doesNotExist());
    }

    //@Step("Click on any City and after the map was opened press back and check it works or not")
    public void checkBackButton() {
        clickToElement(R.id.citiesList);
        pressBack();
        elementIsDisplayed(ACTIONBAR);
    }

    //@Step("Scroll to any City")
    public void scrollToRandomCity() {
        clickToElement(R.id.citiesList);
        onView(withId(R.id.citiesList)).check(doesNotExist());
    }

}
