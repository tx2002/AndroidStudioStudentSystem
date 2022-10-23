package com.example.apitest;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class activity_teacher extends Activity {
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //这个是获取布局文件的
        setContentView(R.layout.activity_main);
        // 读取暂存数据
        SharedPreferences settings = getSharedPreferences("setting", 0);
        // 第二个值为默认值
        String role = settings.getString("role", null);
        String token = settings.getString("token", "null");

        tv = (TextView) findViewById(R.id.tv_main);
        tv.setText("role:" + role + "\ntoken:" + token);

    }
}
