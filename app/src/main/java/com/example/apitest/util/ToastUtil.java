package com.example.apitest.util;

import android.content.Context;
import android.widget.Toast;

/**
 * 弹窗工具类
 */
public class ToastUtil {
    public static Toast mtoast;

    public static void showMsg(Context context, String msg) {
        if (mtoast == null) {
            mtoast = Toast.makeText(context, msg, Toast.LENGTH_LONG);
        } else {
            mtoast.setText(msg);
        }
        mtoast.show();
    }
}
