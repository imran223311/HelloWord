package com.samegenes.helloword;

import android.app.Application;
import android.content.Context;

public class helloword extends Application {

    private static Context context;

    public void onCreate() {
        super.onCreate();
        helloword.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return helloword.context;
    }
}
