package app.com.mobileassignment;


import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import app.com.mobileassignment.views.adapters.CityAdapter;


@RunWith(RobolectricTestRunner.class)
@Config(manifest = "src/main/AndroidManifest.xml")
public class CityAdapterTest extends BaseTest {


    @Test
    public void testFullListTS001() {
        assertEquals(209557, cityList.size());
    }

    @Test
    public void testClearListTS002() {
        cityList.clear();
        adapter = new CityAdapter(context, cityList);
        assertEquals(0, adapter.getCount());
    }
}