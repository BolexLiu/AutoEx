package com.bolex.autoEx;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * Created by Bolex on 2018/4/30.
 */

public class AutoEx implements AutoExConstant {

    private static int maxSize = 4;
    private Context mApp;
    private Thread.UncaughtExceptionHandler mUEH;


    public static void apply(Context mApp) {
        apply(mApp, maxSize);
    }

    public static void apply(Context mApp, int maxSize) {
        new AutoEx().init(mApp, maxSize);
    }


    private void init(Context mApp, int maxSize) {
        this.mApp = mApp;
        AutoEx.maxSize = maxSize;
        mUEH = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(handler);
    }

    Thread.UncaughtExceptionHandler handler = new Thread.UncaughtExceptionHandler() {
        public void uncaughtException(final Thread thread, final Throwable ex) {
            String errorMsg = getErrorMsg(ex);
            search(errorMsg);
            mUEH.uncaughtException(thread, ex);
        }
    };

    private void search(final String errorMsg) {
        HttpUtil.doGet(API.SEARCH_URL + API.PAGESIZE + maxSize + API.Body + errorMsg.replace(" ", "%20"), new HttpUtil.HResponse() {


            @Override
            public void onFinish(String msg) {
                StringBuffer log = new StringBuffer();
                log.append(LINE_START);
                try {
                    JSONObject stackoverflowData = new JSONObject(msg);
                    JSONArray items = stackoverflowData.getJSONArray(JSON_ITEMS);
                    int length = items.length();
                    if (length > 0) {
                        log.append(String.format(AUTO_ERROR_TYPE, errorMsg));
                        log.append(String.format(AUTO_RECOMMEND, length));
                        log.append(MI_LINE);
                        for (int i = 0; i < length; i++) {
                            JSONObject item = (JSONObject) items.get(i);
                            String link = item.getString(JSON_LINK);
                            String title = item.getString(JSON_TITLE);
                            log.append(String.format(AUTO_LINKS, title, link));
                            if (i < length - 1) {
                                log.append(MI_LINE);
                            }
                        }
                    } else {
                        log.append(SORRY);
                    }
                    log.append(LINE_END);
                    Log.e(AutoEx.this.getClass().getName(), log.toString());
                } catch (JSONException e) {
                    log.append(String.format(AUTO_ERROR, e.getMessage()));
                    log.append(LINE_END);
                    Log.e(AutoEx.this.getClass().getName(), log.toString());
                }
            }

            @Override
            public void onError(String error) {
                StringBuffer log = new StringBuffer();
                log.append(LINE_START);
                log.append(String.format(AUTO_ERROR, error));
                log.append(LINE_END);
                Log.e(AutoEx.this.getClass().getName(), log.toString());
            }
        });
    }

    private String getErrorMsg(Throwable ex) {
        String message = ex.getMessage();
        return message.substring(message.indexOf(":") + 2);
    }


}
