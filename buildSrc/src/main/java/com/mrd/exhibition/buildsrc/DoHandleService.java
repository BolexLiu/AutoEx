package com.mrd.exhibition.buildsrc;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Bolex on 2018/5/2.
 */

public class DoHandleService implements AutoExConstant {


    public  static void search(final String errorMsg, int maxSize) {
        HttpUtil.dogetHttp3(API.SEARCH_URL + API.PAGESIZE + maxSize + API.Body + errorMsg.replace(" ", "%20"), new HttpUtil.HResponse() {
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
                    log(log.toString());
                } catch (JSONException e) {
                    log.append(String.format(AUTO_ERROR, e.getMessage()));
                    log.append(LINE_END);
                    log(log.toString());
                }
            }

            @Override
            public void onError(String error) {
                StringBuffer log = new StringBuffer();
                log.append(LINE_START);
                log.append(String.format(AUTO_ERROR, error));
                log.append(LINE_END);
                log(log.toString());
            }
        });
    }

    private static void log(String log) {
        System.out.println(log.toString());
    }
}
