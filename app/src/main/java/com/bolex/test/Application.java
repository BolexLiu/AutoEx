package com.bolex.test;


import com.bolex.autoEx.*;

/**
 * Created by Bolex on 2018/4/30.
 */

public class Application extends android.app.Application {
    @Override
    public void onCreate() {
        AutoEx.apply(this);
// 可选参数  AutoEx.apply(this,4,"AutoExTag",true);
        super.onCreate();
    }
}
