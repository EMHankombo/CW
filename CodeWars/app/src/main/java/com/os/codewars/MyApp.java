package com.os.codewars;

import android.app.Application;
import android.content.Context;

/**
 * Created by Os on 05/04/2018.
 */

public class MyApp extends Application {

    private static MyApp appInstance;
    private static Context context;

    private static String username;
    private static String challengeID;

    public static String LOG_TAG = "LOG_DATA_MyApp";

    public static MyApp getAppInstance() {
        if (appInstance == null) {
            appInstance = new MyApp();
        }
        return appInstance;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        MyApp.username = username;
    }

    public static String getChallengeID() {
        return challengeID;
    }

    public static void setChallengeID(String challengeID) {
        MyApp.challengeID = challengeID;
    }


    public Context getAppContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
}
