package com.bolex.autoEx;

import android.content.Context;
import android.content.Intent;


/**
 * Created by Bolex on 2018/4/30.
 */

public class AutoEx implements AutoExConstant {


    private Context mApp;
    private Thread.UncaughtExceptionHandler mUEH;
    public static int maxSize=4;


    public static void apply(Context mApp) {
        apply(mApp, AutoEx.maxSize);
    }

    public static void apply(Context mApp, int maxSize) {
        new AutoEx().init(mApp, maxSize);
    }


    private void init(Context mApp, int maxSize) {
        this.mApp = mApp;
       this.maxSize= maxSize;
        mUEH = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(handler);
    }

    Thread.UncaughtExceptionHandler handler = new Thread.UncaughtExceptionHandler() {
        public void uncaughtException(final Thread thread, final Throwable ex) {
            String errorMsg = getErrorMsg(ex);
            Intent intent = new Intent(mApp, HandleService.class);
            intent.putExtra(ERROR_MSG,errorMsg);
            intent.putExtra(MAX_SIZE,maxSize);
            mApp.startService(intent);
            mUEH.uncaughtException(thread, ex);
        }
    };


    private String getErrorMsg(Throwable ex) {
        String message = ex.getMessage();
        return message.substring(message.indexOf(":") + 2);
    }

}
