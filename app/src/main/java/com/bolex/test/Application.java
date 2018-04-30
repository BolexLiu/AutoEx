package com.bolex.test;

import com.bolex.autoEx.AutoEx;

/**
 * Created by Bolex on 2018/4/30.
 */

public class Application extends android.app.Application {
    @Override
    public void onCreate() {
        AutoEx.apply(this);
        super.onCreate();
    }
}
