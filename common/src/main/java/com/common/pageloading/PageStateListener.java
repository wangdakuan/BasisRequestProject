package com.common.pageloading;

/**
 * Created by Syehunter on 16/1/9.
 */
public interface PageStateListener {

    void onLoading(); //加载

    void onError(); //异常

    void onEmpty(); //无数据

    void onSucceed(); //成功

    void onRequesting(); //请求

    void onPrompting(String msg); //提示

}
