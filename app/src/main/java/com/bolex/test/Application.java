package com.bolex.test;

import com.bolex.autoEx.*;
import com.bolex.autoEx.BuildConfig;

/**
 * Created by Bolex on 2018/4/30.
 */

public class Application extends android.app.Application {
    @Override
    public void onCreate() {
        if (BuildConfig.DEBUG){AutoEx.apply(this);}
        super.onCreate();
    }
}
