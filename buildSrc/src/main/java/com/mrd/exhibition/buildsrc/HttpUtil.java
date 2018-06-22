package com.mrd.exhibition.buildsrc;

import com.squareup.okhttp.MultipartBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Bolex on 2018/4/30.
 */

public class HttpUtil {

    public interface HResponse {
        void onFinish(String msg);

        void onError(String error);
    }

    public static void dogetHttp3(final String urls, final HResponse mHResponse) {
        try {
            OkHttpClient client = new OkHttpClient();
            client.setConnectTimeout(10, TimeUnit.SECONDS);
            client.setReadTimeout(60, TimeUnit.SECONDS);
            Request build1 = new Request.Builder().url(urls).get().build();

            Response execute = client.newCall(build1).execute();
            if (execute == null || execute.body() == null) {
                mHResponse.onError("没有找到任何可参考的，真可惜。");
                return;
            }
            String string = execute.body().string();
            mHResponse.onFinish(string);
        } catch (IOException e) {
            e.printStackTrace();
            mHResponse.onError(e.getMessage());
        }
    }
}
