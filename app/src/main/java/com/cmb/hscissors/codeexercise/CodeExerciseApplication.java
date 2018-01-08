package com.cmb.hscissors.codeexercise;

import android.app.Application;

import com.squareup.picasso.Picasso;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by hscissors on 1/7/18.
 */

public class CodeExerciseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        final Picasso picasso = new Picasso.Builder(getApplicationContext())
                .build();

        Picasso.setSingletonInstance(picasso);

        CalligraphyConfig.initDefault(
                new CalligraphyConfig.Builder()
                        .setDefaultFontPath("assets/fonts/Cahyati.tff")
                        .setFontAttrId(R.attr.fontPath)
                        .build()
        );
    }
}
