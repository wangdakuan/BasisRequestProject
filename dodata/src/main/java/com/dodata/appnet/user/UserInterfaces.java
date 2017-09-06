package com.dodata.appnet.user;

import com.dodata.appnet.model.UserInfoModel;
import com.dodata.net.presenter.RequestCallback;
import com.dodata.net.presenter.SucceedCallback;

import java.util.Map;

/**
 * 作者：wangdakuan
 * 日期：2017/9/5 17:37
 * 邮箱：wangdakuan@kjtpay.com.cn
 * 功能：
 */
public interface UserInterfaces {
    /**
     * 用户接口
     * @param map
     * @param callback
     * @param succeedCallback
     */
    void checkSignIn(Map map, RequestCallback callback, SucceedCallback<UserInfoModel> succeedCallback);
}
