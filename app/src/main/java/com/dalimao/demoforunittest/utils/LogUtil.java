package com.dalimao.demoforunittest.utils;

import android.util.Log;

/**
 * Created by liuguangli on 16/8/11.
 */
public class LogUtil {
    private static boolean debug = true;
    public static void setDebug(boolean d) {
        debug = d;
    }
    public static void d(String tag, String content) {
        if (debug) {
            Log.d(tag, content);
        } else {

        }
    }
}
