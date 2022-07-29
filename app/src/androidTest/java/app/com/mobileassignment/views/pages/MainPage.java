package app.com.mobileassignment.views.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isFocusable;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.AllOf.allOf;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.ViewMatchers;

import app.com.mobileassignment.R;
import io.qameta.allure.kotlin.Step;


public class MainPage extends BasePage {

    private static final ViewInteraction ACTIONBAR = onView(withId(R.id.action_bar));
    private static final ViewInteraction SEARCH_FIELD = onView(withId(R.id.search));
    private static final ViewInteraction CITIES_LIST = onView(withId(R.id.citiesList));
    private static final ViewInteraction ACTIONBAR_CONTAINER = onView(withId(R.id.action_bar_container));


    @Step("The app is started/Checking the header of the main screen")
    public void checkTheAppsTitle() {
        ViewInteraction textView = onView(
                allOf(withText("Mobile Assignment"),
                        withParent(allOf(withId(androidx.appcompat.R.id.action_bar),
                                withParent(withId(androidx.appcompat.R.id.action_bar_container)))),
                        isDisplayed()));
        textView.check(matches(withText("Mobile Assignment")));
    }

    @Step("The app is started/Checking the search field is displayed")
    public void checkTheSearchField() {

        elementIsDisplayed(SEARCH_FIELD);
    }

    @Step("The app is started/Checking that search field is empty and clickable")
    public void checkEmptyInputField() {

        onView(withId(R.id.search)).check(matches(allOf(
                withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE),
                isFocusable(),
                isClickable(),
                withText("")
        )));
    }


    @Step("The app is started/Checking the Cities list")
    public void checkTheCitiesList() {

        elementIsDisplayed(CITIES_LIST);
    }

}
