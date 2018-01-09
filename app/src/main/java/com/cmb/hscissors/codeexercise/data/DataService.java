package com.cmb.hscissors.codeexercise.data;

import java.util.ArrayList;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by hscissors on 1/7/18.
 */

public class DataService {
    private static String BASE_URL = "https://raw.githubusercontent.com/hscissors/cmb/master/app/src/main/assets/";

    private Retrofit retrofit;

    private static class SingletonHelper {
        private static final DataService INSTANCE = new DataService();
    }

    public static DataService getInstance() {
        return SingletonHelper.INSTANCE;
    }


    public void init() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    //A more robust app might abstract away from concretes to general CRUD calls
    public Observable<ArrayList<TeamMember>> getTeamMembers() {
        return retrofit.create(Api.class)
                .getTeamMembers()
                .subscribeOn(Schedulers.io());
    }

    interface Api {
        @GET("team.json")
        Observable<ArrayList<TeamMember>> getTeamMembers();
    }
}
