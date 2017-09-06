package com.dodata.net.presenter;

import io.reactivex.disposables.Disposable;

/**
 * 作者：wangdakuan
 * 日期：2017/8/30 13:48
 * 邮箱：wangdakuan@kjtpay.com.cn
 * 功能：请求回调
 */
public interface RequestCallback {
    void onStart(); //开始请求
    void onSubscribe(Disposable disposable); //开始请求
    void onError(String message); //请求异常,请求失败异常
    void onPrompting(String message); //请求成功提示
    void onComplete(); //请求成功
}
