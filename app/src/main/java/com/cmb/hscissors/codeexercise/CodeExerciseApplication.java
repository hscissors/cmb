package com.cmb.hscissors.codeexercise;

import android.app.Application;

import com.cmb.hscissors.codeexercise.data.DataService;
import com.squareup.picasso.Picasso;

/**
 * Created by hscissors on 1/7/18.
 */

public class CodeExerciseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Picasso.setSingletonInstance(
                new Picasso.Builder(getApplicationContext())
                        .build());

        DataService.getInstance().init();
    }
}
