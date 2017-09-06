package com.dodata.net.subscribe;


import com.dodata.net.presenter.RequestCallback;

import io.reactivex.functions.Consumer;

/**
 * 作者：wangdakuan
 * 日期：2017/8/30 11:20
 * 邮箱：wangdakuan@kjtpay.com.cn
 * 功能：开始请求
 */
public class StartSubscribe<M, T> implements Consumer<T> {
    private M presenter;

    public StartSubscribe(M presenter) {
        this.presenter = presenter;
    }

    @Override
    public void accept(T t) {
        if (presenter instanceof RequestCallback) {
            ((RequestCallback) presenter).onStart();
        }
    }
}
