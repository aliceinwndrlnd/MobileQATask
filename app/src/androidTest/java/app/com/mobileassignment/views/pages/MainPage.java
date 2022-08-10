package app.com.mobileassignment.views.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;

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

    public int getResultCityName() {

        return R.id.cityName;
    }

    public int getSearch() {
        return R.id.search;
    }


    public int getMapPoint() {
        return R.id.insert_point;
    }

    public int getCitiesList() {
        return R.id.citiesList;
    }
}
