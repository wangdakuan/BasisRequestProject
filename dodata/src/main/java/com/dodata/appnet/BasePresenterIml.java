package com.dodata.appnet;

import com.common.pageloading.PageStateListener;
import com.common.utils.ToastUtils;
import com.dodata.net.presenter.RequestCallback;
import com.dodata.net.presenter.ViewPresenter;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * 作者：wangdakuan
 * 日期：2017/8/30 14:38
 * 邮箱：wangdakuan@kjtpay.com.cn
 * 功能：Presenter基类处理
 */
public class BasePresenterIml implements ViewPresenter, RequestCallback {
    /**
     * 页面
     */
    protected PageStateListener mStateListener;
    /**
     * 订阅者的统计
     */
    private CompositeDisposable compositeDisposable;

    private boolean isCancelLoad; //请求时取消加载框  true 为取消，false为显示

    /**
     * 统计请求的订阅者
     *
     * @param disposable
     */
    public void addDisposable(Disposable disposable) {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);
    }

    /**
     * 撤销
     */
    private void dispose() {
        if (compositeDisposable != null) compositeDisposable.dispose();
    }

    /**
     * 页面的loding
     *
     * @param stateListener
     */
    public BasePresenterIml(PageStateListener stateListener) {
        mStateListener = stateListener;
    }

    @Override
    public void onResume() {
    }

    /**
     * 销毁页面后撤销请求
     */
    @Override
    public void onDestroy() {
        dispose();
    }

    /**
     * 请求开始
     */
    @Override
    public void onStart() {
//        if(){
//            mStateListener.onRequesting();
//        }
        if (null != mStateListener && !isCancelLoad) {
            mStateListener.onLoading();
            mStateListener.onRequesting();
        }
    }

    /**
     * 请求成功提示语
     *
     * @param message
     */
    @Override
    public void onPrompting(String message) {
        if (null != mStateListener) {
            ToastUtils.showShortSafe(message);
//            mStateListener.onPrompting(message);
        }
    }

    /**
     * 异常数据或失败
     *
     * @param message
     */
    @Override
    public void onError(String message) {
        if (null != mStateListener) {
            ToastUtils.showShortSafe(message);
            mStateListener.onError();
        }
    }

    /**
     * 记录请求的订阅者
     *
     * @param disposable
     */
    @Override
    public void onSubscribe(Disposable disposable) {
        addDisposable(disposable);
    }

    /**
     * 请求完成
     */
    @Override
    public void onComplete() {
        if (null != mStateListener) {
            mStateListener.onSucceed();
        }
    }

    /**
     * 设置请求时取消加载框
     */
    public void setCancelLoad(boolean isCancelLoad) {
        this.isCancelLoad = isCancelLoad;
    }
}
