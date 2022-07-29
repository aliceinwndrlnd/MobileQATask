package app.com.mobileassignment.views.utils;

import android.util.Log;

public class LogTests {

    static boolean logEnabled = true;
    public static void logTest(String log){
        if (logEnabled) {
            Log.v("Espresso Test", log);
        }
    }
}
