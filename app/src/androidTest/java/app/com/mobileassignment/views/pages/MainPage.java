package app.com.mobileassignment.views.pages;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isFocusable;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static com.google.common.truth.Truth.assertThat;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.AllOf.allOf;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.ViewMatchers;


import app.com.mobileassignment.R;


public class MainPage extends BasePage {


    public final ViewInteraction ACTIONBAR = onView(withId(R.id.action_bar));
    public final ViewInteraction SEARCH_FIELD = onView(withId(R.id.search));
    public final ViewInteraction CITIES_LIST = onView(withId(R.id.citiesList));
    public final ViewInteraction MAP_POINT = onView(withId(R.id.insert_point));


    public static int getResultCityName() {

        return R.id.cityName;
    }

    public void checkTheAppsTitleHasACorrectValue() {
        ViewInteraction textView = onView(
                allOf(withText("Mobile Assignment"),
                        withParent(allOf(withId(androidx.appcompat.R.id.action_bar),
                                withParent(withId(androidx.appcompat.R.id.action_bar_container))))));
        textView.check(matches(withText("Mobile Assignment")));
    }

    public void checkEmptyInputField() {

        onView(withId(R.id.search)).check(matches(allOf(
                withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE),
                isFocusable(),
                isClickable(),
                withText("")
        )));
    }

    public void clickOnCity() {
        clickToElement(R.id.citiesList);
    }

    public void matchResult(String value) {
        textResultMatches(getResultCityName(), value);
    }

    public void pressBackButton() {
        pressBack();
    }

    public void matchResults(String value) {
        onData(anything()).inAdapterView(withId(R.id.citiesList))
            .atPosition(0)
                .onChildView(withId(R.id.cityName))
            .check(matches(withText(containsString(value))));
    }
}
