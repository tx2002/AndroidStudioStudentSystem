package com.example.apitest;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.apitest.entity.LoginResponse;
import com.example.apitest.util.ToastUtil;
import com.google.gson.Gson;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class activity_login extends Activity implements View.OnClickListener {
    private EditText et_username;
    private EditText et_password;
    private Button bt_login;
    private LoginResponse loginResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 将页面与xml文件绑定
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // 获取页面按钮
        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);
        bt_login = (Button) findViewById(R.id.bt_login);
        // 加入监听器
        et_username.setOnClickListener(this);
        et_password.setOnClickListener(this);
        bt_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_login:
                login();
        }
    }

    private void login() {
        String username = et_username.getText().toString();
        String passwors = et_password.getText().toString();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // apifox中的请求代码
                    OkHttpClient client = new OkHttpClient().newBuilder()
                            .build();
                    MediaType mediaType = MediaType.parse("text/plain");
                    RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                            .addFormDataPart("username", username)
                            .addFormDataPart("password", passwors)
                            .build();
                    Request request = new Request.Builder()
                            .url("http://1.117.115.133:8080/login")
                            .method("POST", body)
                            .build();
                    Response response = client.newCall(request).execute();
                    // 得到响应后，转化为json
                    String data = response.body().string();
                    LoginResponse res = parseJSONWithGSON(data);
                    if (res.getCode() == 200) {
                        // 存放临时数据
                        SharedPreferences settings = getSharedPreferences("setting", 0);
                        SharedPreferences.Editor editor = settings.edit();
                        editor.putString("role", res.getData().getRole());
                        editor.putString("token", res.getData().getToken());
                        editor.commit();
                        // 页面跳转，根据role的值判断身份
                        Intent intent = new Intent();
                        switch (res.getData().getRole()) {
                            case "0":
                                //前一个（MainActivity.this）是目前页面，后面一个是要跳转的下一个页面
                                intent.setClass(activity_login.this, activity_admin.class);
                                break;
                            case "1":
                                intent.setClass(activity_login.this, activity_teacher.class);
                                break;
                            case "2":
                                intent.setClass(activity_login.this, activity_student.class);
                                break;
                        }
                        startActivity(intent);
                    } else {
                        // 弹窗提示
                        Looper.prepare();
                        ToastUtil.showMsg(getApplicationContext(), res.getMessage());
                        Looper.loop();
                    }
                } catch (
                        Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();



    }

    private LoginResponse parseJSONWithGSON(String jsonData) {
        //使用轻量级的Gson解析得到的json
        Gson gson = new Gson();
        LoginResponse res = gson.fromJson(jsonData, LoginResponse.class);
        return res;
    }
}