package com.common.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import java.util.Iterator;
import java.util.List;

/**
 * 作者：wangdakuan
 * 日期：2017/9/6 12:27
 * 邮箱：wangdakuan@kjtpay.com.cn
 * 功能：Activity相关帮助类
 */
public class ActivityUtils {

    private ActivityUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 获取栈顶Activity
     *
     * @return 栈顶Activity
     */
    public static Activity getTopActivity() {
        return AppUtils.sTopActivity;
    }


    /**
     * 启动Activity
     *
     * @param targetActivity 需要启动的页面
     */
    public void navigateTo(@NonNull Class<? extends Activity> targetActivity) {
        navigateTo(targetActivity, new Intent());
    }

    /**
     * 启动Activity
     *
     * @param targetActivity 需要启动的页面
     * @param extras         页面传值对象
     */
    public void navigateTo(@NonNull Class<? extends Activity> targetActivity, @NonNull Bundle extras) {
        Intent intent = new Intent();
        intent.putExtras(extras);
        navigateTo(targetActivity, intent);
    }

    /**
     * 启动Activity
     *
     * @param targetActivity 需要启动的页面
     * @param extras         页面传值对象
     * @param requestCode    请求回调码
     */
    public void navigateTo(@NonNull Class<? extends Activity> targetActivity, @NonNull Bundle extras, int requestCode) {
        Intent intent = new Intent();
        intent.putExtras(extras);
        navigateTo(targetActivity, intent, requestCode);
    }

    /**
     * 启动Activity
     *
     * @param targetActivity 启动的页面
     * @param requestCode    请求回调码
     */
    public void navigateTo(@NonNull Class<? extends Activity> targetActivity, int requestCode) {
        navigateTo(targetActivity, new Intent(), requestCode);
    }

    /**
     * 启动Activity
     *
     * @param targetActivity 需要启动的页面
     * @param intent         Intent 对象
     */
    public void navigateTo(@NonNull Class<? extends Activity> targetActivity, @NonNull Intent intent) {
        Activity currentActivity = getTopActivity();
        navigateTo(currentActivity, targetActivity, intent, -1);
    }

    /**
     * 启动Activity
     *
     * @param targetActivity 需要启动的页面
     * @param intent         Intent 对象
     * @param requestCode    请求回调码
     */
    public void navigateTo(@NonNull Class<? extends Activity> targetActivity, @NonNull Intent intent, int requestCode) {
        Activity currentActivity = getTopActivity();
        navigateTo(currentActivity, targetActivity, intent, requestCode);
    }

    /**
     * 启动Activity
     *
     * @param context        上下文
     * @param targetActivity 启动的页面
     * @param intent         跳转Intent对象
     * @param requestCode    请求回调码
     */
    public void navigateTo(@NonNull Activity context, @NonNull Class<? extends Activity> targetActivity, @NonNull Intent intent, int requestCode) {
        intent.setClass(context, targetActivity);
        context.startActivityForResult(intent, requestCode);
    }


    /**
     * 判断是否存在Activity
     *
     * @param cls activity.class
     * @return {@code true}: 是<br>{@code false}: 否
     */
    public static boolean isActivityExists(@NonNull final Class<?> cls) {
        Context context = AppUtils.getApp();
        Intent intent = new Intent();
        intent.setClassName(context.getPackageName(), cls.getName());
        return !(AppUtils.getApp().getPackageManager().resolveActivity(intent, 0) == null ||
                intent.resolveActivity(AppUtils.getApp().getPackageManager()) == null ||
                AppUtils.getApp().getPackageManager().queryIntentActivities(intent, 0).size() == 0);
    }


    /**
     * 销毁指定页面
     *
     * @param classes 销毁指定页面
     */
    public void removerActivity(Class... classes) {
        Iterator<Activity> sListIterator = AppUtils.sActivityList.iterator();
        while (sListIterator.hasNext()) {
            Activity act = sListIterator.next();
            boolean isRemove = false;
            Class[] aClass = classes;
            for (int j = 0, sizeClass = aClass.length; j < sizeClass; j++) {
                if (act.getClass() == aClass[j]) {
                    isRemove = true;
                    break;
                }
            }
            if (isRemove) {
                act.finish();
                sListIterator.remove();
            }
        }
    }

    /**
     * 结束所有activity
     */
    public static void finishAllActivities() {
        List<Activity> activityList = AppUtils.sActivityList;
        for (int i = activityList.size() - 1; i >= 0; --i) {
            activityList.get(i).finish();
            activityList.remove(i);
        }
    }
}
