package app.com.mobileassignment;

import android.content.Context;

import org.junit.After;
import org.junit.Before;
import org.robolectric.RuntimeEnvironment;

import java.util.ArrayList;
import java.util.List;

import app.com.mobileassignment.model.City;
import app.com.mobileassignment.utils.JsonMapper;
import app.com.mobileassignment.views.adapters.CityAdapter;

public class BaseTest {

    CityAdapter adapter;
    Context context;
    List<City> cityList;
    JsonMapper jsonMapper;


    @Before
    public void setUp() {
        context = RuntimeEnvironment.getApplication();
        cityList = new ArrayList<>();
        jsonMapper = new JsonMapper();
        populateCityList();
    }


    @After
    public void tearDown() {
        cityList.clear();
    }

    private void populateCityList() {
        cityList = jsonMapper.getCityListFromRawFile(context, R.raw.cities);
    }
}
