package com.example.amsapp;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class Fonts extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initFont();
    }

    private void initFont() {
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/DB Helvethaica X Med Cond v3.2.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}
