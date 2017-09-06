package com.dodata.net.presenter;

/**
 * 作者：wangdakuan
 * 日期：2017/8/30 15:10
 * 邮箱：wangdakuan@kjtpay.com.cn
 * 功能：成功后回调数据
 */
public interface SucceedCallback<T> {
    void onData(T t);
}
