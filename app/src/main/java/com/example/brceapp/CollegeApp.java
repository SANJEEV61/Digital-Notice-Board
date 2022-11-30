package com.example.brceapp;

import android.app.Application;

import com.onesignal.OneSignal;

public class CollegeApp extends Application {

    private static final String ONESIGNAL_APP_ID = "57ee9ba5-94bc-4784-be7a-bd474faf4e49";
    @Override
    public void onCreate() {
        super.onCreate();

        // OneSignal Initialization
        OneSignal.initWithContext(this);
        OneSignal.setAppId(ONESIGNAL_APP_ID);
    }
}
