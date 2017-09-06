package com.dodata.net.subscribe;

import com.dodata.net.model.DataResponse;
import com.dodata.net.presenter.RequestCallback;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * 作者：wangdakuan
 * 日期：2017/8/30 11:25
 * 邮箱：wangdakuan@kjtpay.com.cn
 * 功能：请求回调监听
 */
public class MObserver<T> implements Observer<T> {

    private RequestCallback callback;

    public MObserver(RequestCallback callback) {
        this.callback = callback;
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {
        if (null != callback) {
            callback.onSubscribe(d);
        }
    }

    @Override
    public void onNext(@NonNull T t) { //成功后返回数据
        if (null != callback && t instanceof DataResponse) {
            callback.onPrompting(((DataResponse) t).message);
        }
    }

    @Override
    public void onError(@NonNull Throwable e) { //请求异常
        if (null != callback) {
            callback.onError(e.getMessage());
        }
    }

    @Override
    public void onComplete() { //请求结束
        if (null != callback) {
            callback.onComplete();
        }
    }
}
