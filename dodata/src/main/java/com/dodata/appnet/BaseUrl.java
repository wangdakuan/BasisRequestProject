package com.dodata.appnet;

import com.example.dodata.BuildConfig;

/**
 * 作者：wangdakuan
 * 日期：2017/8/30 11:36
 * 邮箱：wangdakuan@kjtpay.com.cn
 * 功能：请求数据接口
 */
public class BaseUrl {
    public static String getName() {
        if (IS_RELEASE) {
            //线上
            return "http://140.207.39.250:50030/ace-app";
        } else {
            //测试
            return "http://140.207.39.250:50030/ace-app";
        }
    }

    private static final Boolean IS_RELEASE = BuildConfig.DEBUG;
}
