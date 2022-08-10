package app.com.mobileassignment.views.pages;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isFocusable;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.core.AllOf.allOf;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.ViewMatchers;

import app.com.mobileassignment.R;


public class MainPage extends BasePage {


    public ViewInteraction getCityList() {
        return onView(withId(R.id.citiesList));
    }

    public int getActionBar() {
        return R.id.action_bar;
    }

    public int getActionBarContainer() {
        return R.id.action_bar_container;
    }

    public int getResultCityName() {return R.id.cityName;}

    public int getSearch() {
        return R.id.search;
    }

    public int getMapPoint() {
        return R.id.insert_point;
    }

    public int getCitiesList() {
        return R.id.citiesList;
    }

    public void matchChildResults(String value) {
        onData(anything()).inAdapterView(withId(getCitiesList()))
                .atPosition(0)
                .onChildView(withId(getResultCityName()))
                .check(matches(withText(containsString(value))));
    }

    public void checkTheAppsTitleHasACorrectValue(String text) {
        ViewInteraction textView = onView(
                allOf(withText(text),
                        withParent(allOf(withId(getActionBar()),
                                withParent(withId(getActionBarContainer()))))));
        textView.check(matches(withText(text)));
    }

    public void checkEmptyInputField() {

        onView(withId(getSearch())).check(matches(allOf(
                withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE),
                isFocusable(),
                isClickable(),
                withText(isEmptyString())
        )));
    }

    public void resultMatches(String value) {
        onView(allOf(withId(getResultCityName()), withText(value)))
                .check(matches(isDisplayed()));
    }

    public void inputData(String cityName) {
        ViewInteraction elementText = onView(
                allOf(withId(getSearch()), isDisplayed()));
        elementText.perform(replaceText(cityName), closeSoftKeyboard());
    }
}
