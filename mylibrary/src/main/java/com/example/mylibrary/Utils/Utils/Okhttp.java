package com.example.mylibrary.Utils.Utils;

import android.util.Log;

import com.google.gson.Gson;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * 用途：
 * 作者：xuBoTao
 * 时间：2017/4/12 09:31
 */
public class Okhttp {
    public  static void okhttp(FormEncodingBuilder buider, String path, final DataInterface dataInterface)
    {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request=new Request.Builder()
                .url(path)
                .post(buider.build())
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }
            @Override
            public void onResponse(Response response) throws IOException {
                String string = response.body().string();
                Log.d("zzz1", string);
                dataInterface.setData(string);
            }
        });
    }
}
