package com.example.apitest;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.example.apitest.entity.NormalResponse;
import com.google.gson.Gson;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class activity_student extends Activity {
    // todo 声明控件


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // todo 将页面与xml文件绑定
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//        // 获取页面按钮
//        et_username = (EditText) findViewById(R.id.et_username);
//        et_password = (EditText) findViewById(R.id.et_password);
//        bt_login = (Button) findViewById(R.id.bt_login);
//        // 加入监听器
//        et_username.setOnClickListener(this);
//        et_password.setOnClickListener(this);
//        bt_login.setOnClickListener(this);
    }



    private void getinfo() {
        // 读取暂存数据
        SharedPreferences settings = getSharedPreferences("setting", 0);
        // 第二个值为默认值
        String role = settings.getString("role", null);
        String token = settings.getString("token", "null");

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient().newBuilder()
                            .build();
                    MediaType mediaType = MediaType.parse("text/plain");
                    RequestBody body = RequestBody.create(mediaType, "");
                    Request request = new Request.Builder()
                            .url("http://1.117.115.133:8080/student/getinfo")
                            .method("GET", body)
                            .addHeader("token", token)
                            .addHeader("User-Agent", "apifox/1.0.0 (https://www.apifox.cn)")
                            .build();
                    Response response = client.newCall(request).execute();

                    // 得到响应后，转化为json
                    String data = response.body().string();
                    NormalResponse res = parseJSONWithGSON(data);
                    if (res.getCode() == 200) {
                        // todo
                    } else {
                        // todo
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }

    private void getCourse() {
        // 读取暂存数据
        SharedPreferences settings = getSharedPreferences("setting", 0);
        // 第二个值为默认值
        String role = settings.getString("role", null);
        String token = settings.getString("token", "null");

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient().newBuilder()
                            .build();
                    MediaType mediaType = MediaType.parse("text/plain");
                    RequestBody body = RequestBody.create(mediaType, "");
                    Request request = new Request.Builder()
                            .url("http://1.117.115.133:8080/student/getCourse")
                            .method("GET", body)
                            .addHeader("token", token)
                            .addHeader("User-Agent", "apifox/1.0.0 (https://www.apifox.cn)")
                            .build();
                    Response response = client.newCall(request).execute();

                    // 得到响应后，转化为json
                    String data = response.body().string();
                    NormalResponse res = parseJSONWithGSON(data);
                    if (res.getCode() == 200) {
                        // todo
                    } else {
                        // todo
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }


    private void report() {
        String term = "1";
        // 读取暂存数据
        SharedPreferences settings = getSharedPreferences("setting", 0);
        // 第二个值为默认值
        String role = settings.getString("role", null);
        String token = settings.getString("token", "null");

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient().newBuilder()
                            .build();
                    MediaType mediaType = MediaType.parse("text/plain");
                    RequestBody body = RequestBody.create(mediaType, "");
                    Request request = new Request.Builder()
                            .url("http://1.117.115.133:8080/student/report?term=" + term)
                            .method("GET", body)
                            .addHeader("token", token)
                            .addHeader("User-Agent", "apifox/1.0.0 (https://www.apifox.cn)")
                            .build();
                    Response response = client.newCall(request).execute();

                    // 得到响应后，转化为json
                    String data = response.body().string();
                    NormalResponse res = parseJSONWithGSON(data);
                    if (res.getCode() == 200) {
                        // todo
                    } else {
                        // todo
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }


    private void chooseCourseList() {
        String term = "1";
        // 读取暂存数据
        SharedPreferences settings = getSharedPreferences("setting", 0);
        // 第二个值为默认值
        String role = settings.getString("role", null);
        String token = settings.getString("token", "null");

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient().newBuilder()
                            .build();
                    MediaType mediaType = MediaType.parse("text/plain");
                    RequestBody body = RequestBody.create(mediaType, "");
                    Request request = new Request.Builder()
                            .url("http://1.117.115.133:8080/student/chooseCourseList?term=" + term)
                            .method("GET", body)
                            .addHeader("token", token)
                            .addHeader("User-Agent", "apifox/1.0.0 (https://www.apifox.cn)")
                            .build();
                    Response response = client.newCall(request).execute();

                    // 得到响应后，转化为json
                    String data = response.body().string();
                    NormalResponse res = parseJSONWithGSON(data);
                    if (res.getCode() == 200) {
                        // todo
                    } else {
                        // todo
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }


    private void addCourse() {
        String courseName = "";
        String term = "1";
        // 读取暂存数据
        SharedPreferences settings = getSharedPreferences("setting", 0);
        // 第二个值为默认值
        String role = settings.getString("role", null);
        String token = settings.getString("token", "null");

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient().newBuilder()
                            .build();
                    MediaType mediaType = MediaType.parse("text/plain");
                    RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                            .addFormDataPart("courseName",courseName)
                            .addFormDataPart("term",term)
                            .build();
                    Request request = new Request.Builder()
                            .url("http://1.117.115.133:8080/student/addCourse")
                            .method("POST", body)
                            .addHeader("token", token)
                            .addHeader("User-Agent", "apifox/1.0.0 (https://www.apifox.cn)")
                            .build();
                    Response response = client.newCall(request).execute();

                    // 得到响应后，转化为json
                    String data = response.body().string();
                    NormalResponse res = parseJSONWithGSON(data);
                    if (res.getCode() == 200) {
                        // todo
                    } else {
                        // todo
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }

    private void deleteCourse() {
        String courseName = "";
        // 读取暂存数据
        SharedPreferences settings = getSharedPreferences("setting", 0);
        // 第二个值为默认值
        String role = settings.getString("role", null);
        String token = settings.getString("token", "null");

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient().newBuilder()
                            .build();
                    MediaType mediaType = MediaType.parse("text/plain");
                    RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                            .addFormDataPart("courseName",courseName)
                            .build();
                    Request request = new Request.Builder()
                            .url("http://1.117.115.133:8080/student/deleteCourse")
                            .method("POST", body)
                            .addHeader("token", token)
                            .addHeader("User-Agent", "apifox/1.0.0 (https://www.apifox.cn)")
                            .build();
                    Response response = client.newCall(request).execute();

                    // 得到响应后，转化为json
                    String data = response.body().string();
                    NormalResponse res = parseJSONWithGSON(data);
                    if (res.getCode() == 200) {
                        // todo
                    } else {
                        // todo
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }

    private void changePassword() {
        String oldPassword = "";
        String newPassword = "";
        // 读取暂存数据
        SharedPreferences settings = getSharedPreferences("setting", 0);
        // 第二个值为默认值
        String role = settings.getString("role", null);
        String token = settings.getString("token", "null");

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient().newBuilder()
                            .build();
                    MediaType mediaType = MediaType.parse("text/plain");
                    RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                            .addFormDataPart("oldPassword",oldPassword)
                            .addFormDataPart("newPassword",newPassword)
                            .build();
                    Request request = new Request.Builder()
                            .url("http://1.117.115.133:8080/student/changePassword")
                            .method("POST", body)
                            .addHeader("token", token)
                            .addHeader("User-Agent", "apifox/1.0.0 (https://www.apifox.cn)")
                            .build();
                    Response response = client.newCall(request).execute();

                    // 得到响应后，转化为json
                    String data = response.body().string();
                    NormalResponse res = parseJSONWithGSON(data);
                    if (res.getCode() == 200) {
                        // todo
                    } else {
                        // todo
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }


    private NormalResponse parseJSONWithGSON(String jsonData) {
        //使用轻量级的Gson解析得到的json
        Gson gson = new Gson();
        NormalResponse res = gson.fromJson(jsonData, NormalResponse.class);
        return res;
    }
}
