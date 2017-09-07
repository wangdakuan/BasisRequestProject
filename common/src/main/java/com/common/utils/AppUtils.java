package com.common.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.support.annotation.NonNull;

import java.util.LinkedList;
import java.util.List;

/**
 * 作者：wangdakuan
 * 日期：2017/9/5 18:01
 * 邮箱：wangdakuan@kjtpay.com.cn
 * 功能：初始化相关
 */
public final class AppUtils {
    /**
     * app Application
     */
    @SuppressLint("StaticFieldLeak")
    private static Application sApplication;
    /**
     * activity 管理
     */
    static List<Activity> sActivityList = new LinkedList<>();
    /**
     * 当前页面显示的activity（ 栈顶的activity）
     */
    @SuppressLint("StaticFieldLeak")
    static Activity sTopActivity;

    private static Application.ActivityLifecycleCallbacks mCallbacks = new Application.ActivityLifecycleCallbacks() {
        @Override
        public void onActivityCreated(Activity activity, Bundle bundle) {
            sActivityList.add(activity);
        }

        @Override
        public void onActivityStarted(Activity activity) {

        }

        @Override
        public void onActivityResumed(Activity activity) {
            sTopActivity = activity;
        }

        @Override
        public void onActivityPaused(Activity activity) {

        }

        @Override
        public void onActivityStopped(Activity activity) {

        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

        }

        @Override
        public void onActivityDestroyed(Activity activity) {
            sActivityList.remove(activity);
        }
    };

    private AppUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 初始化工具类
     *
     * @param app 应用
     */
    public static void init(@NonNull final Application app) {
        AppUtils.sApplication = app;
        app.registerActivityLifecycleCallbacks(mCallbacks);
        LogUtils.getConfig().setGlobalTag("测试");
        CrashUtils.init();
    }

    /**
     * 获取Application
     * 在不跟activity页面相关的context可以直接使用，方便于在app使用context
     *
     * @return Application
     */
    public static Application getApp() {
        if (sApplication != null) return sApplication;
        throw new NullPointerException("u should init first");
    }
}
