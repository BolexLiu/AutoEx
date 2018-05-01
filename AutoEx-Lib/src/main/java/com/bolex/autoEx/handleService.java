package com.bolex.autoEx;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Bolex on 2018/5/2.
 */

 class HandleService extends Service implements AutoExConstant {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String errorMsg = intent.getStringExtra(AutoExConstant.ERROR_MSG);
        int maxSize = intent.getIntExtra(AutoExConstant.MAX_SIZE, AutoEx.maxSize);
        search(errorMsg, maxSize);
        return super.onStartCommand(intent, flags, startId);
    }

    private void search(final String errorMsg, int maxSize) {
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
                    Log.e(LOG_TAG, log.toString());
                } catch (JSONException e) {
                    log.append(String.format(AUTO_ERROR, e.getMessage()));
                    log.append(LINE_END);
                    Log.e(LOG_TAG, log.toString());
                }
            }

            @Override
            public void onError(String error) {
                StringBuffer log = new StringBuffer();
                log.append(LINE_START);
                log.append(String.format(AUTO_ERROR, error));
                log.append(LINE_END);
                Log.e(LOG_TAG, log.toString());
            }
        });
    }
}
