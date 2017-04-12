package com.example.administrator.okhttppractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.administrator.okhttppractice.Bean.Reason;
import com.example.mylibrary.Utils.Utils.DataInterface;
import com.example.mylibrary.Utils.Utils.Okhttp;
import com.google.gson.Gson;
import com.squareup.okhttp.FormEncodingBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DataInterface {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String path="http://v.juhe.cn/toutiao/index";
        FormEncodingBuilder buider=new FormEncodingBuilder();
        buider.add("type","top");
        buider.add("key","a1e360288df07697f4514880f2c1ee12");
        Okhttp.okhttp(buider,path,this);
    }

    @Override
    public void setData(String vaule) {
        Log.d("zzz", vaule);
        Gson gson = new Gson();
        Reason reason = gson.fromJson(vaule, Reason.class);
        List<Reason.ResultBean.DataBean> data = reason.getResult().getData();
        for(Reason.ResultBean.DataBean db:data)
        {
            String title = db.getTitle();
            String category = db.getCategory();
            String date = db.getDate();
            Log.d("zzz", title + "       " + category + "      " + date);
        }
    }
}
