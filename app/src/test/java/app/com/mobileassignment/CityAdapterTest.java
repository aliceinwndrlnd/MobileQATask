package app.com.mobileassignment;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;

import android.content.Context;
import android.content.res.Configuration;
import android.net.wifi.WifiManager;
import android.util.Log;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import app.com.mobileassignment.views.adapters.CityAdapter;



@RunWith(RobolectricTestRunner.class)
@Config(manifest = "src/main/AndroidManifest.xml")
public class CityAdapterTest extends BaseTest {


    @DisplayName("Check City list size")
    @Test
    public void testFullListTS001() {
        assertEquals(209557, cityList.size());
    }

    @DisplayName("Clear city list and check that list is empty")
    @Test
    public void testClearListTS002() {
        cityList.clear();
        adapter = new CityAdapter(context, cityList);
        assertEquals(0, adapter.getCount());
    }

    @DisplayName("Verify app's package name")
    @Test
    public void packageNameTestTS003() {
        assertEquals("app.com.mobileassignment", appContext.getPackageName());
    }

    @DisplayName("Check screen orientation")
    @Test
    public void screenOrientationTestTS004() {

        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            Log.d("Screen's orientation", "ORIENTATION_PORTRAIT");
        } else
            Log.d("Screen's orientation", "ORIENTATION_LANDSCAPE");
        assertEquals(Configuration.ORIENTATION_PORTRAIT, orientation);
    }

    @DisplayName("Check wifi work")
    @Test
    public void servicesProvidingTestTS005() {
        assertThat(context.getSystemService(Context.WIFI_SERVICE))
                .isInstanceOf(android.net.wifi.WifiManager.class);

        wifiManager.setWifiEnabled(true);
        assertThat(wifiManager.getWifiState()).isEqualTo(WifiManager.WIFI_STATE_ENABLED);

        wifiManager.setWifiEnabled(false);
        assertThat(wifiManager.getWifiState()).isEqualTo(WifiManager.WIFI_STATE_DISABLED);
    }
}

