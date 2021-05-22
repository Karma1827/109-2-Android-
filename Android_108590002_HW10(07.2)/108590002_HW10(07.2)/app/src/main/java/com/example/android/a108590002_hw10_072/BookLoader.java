package com.example.android.a108590002_hw10_072;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class BookLoader extends AsyncTaskLoader<String> {

    private String mQueryString;
    private HttpURLConnection conn;
    private String content;

    public BookLoader(Context context, String queryString) {
        super(context);
        mQueryString = queryString;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();

        forceLoad();
    }

    @Nullable
    @Override
    public String loadInBackground() {
        try {
            URL url = new URL(mQueryString);
            conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setRequestMethod("GET");

            try {
                int url_status = conn.getResponseCode();
                System.out.println("狀態碼為：" + url_status);
                if (url_status == 200) {
                    InputStream in = conn.getInputStream();
                    content = MainActivity.instreamTOstr.readStream(in);
                    System.out.println(content);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}

