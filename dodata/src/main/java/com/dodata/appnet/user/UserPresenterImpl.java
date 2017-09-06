package com.dodata.appnet.user;

import com.common.pageloading.PageStateListener;
import com.dodata.appnet.BasePresenterIml;
import com.dodata.appnet.model.UserInfoModel;
import com.dodata.net.presenter.SucceedCallback;

import java.util.HashMap;
import java.util.Map;

/**
 * 作者：wangdakuan
 * 日期：2017/8/30 13:36
 * 邮箱：wangdakuan@kjtpay.com.cn
 * 功能：用户
 */
public class UserPresenterImpl extends BasePresenterIml {

    private UserInterfaces mUserApi;

    public UserPresenterImpl(PageStateListener stateListener) {
        super(stateListener);
        mUserApi = new UserApi();
    }

    public void checkSignIn(String user, SucceedCallback<UserInfoModel> succeedCallback) {
        Map map = new HashMap();
        map.put("loginId", "18717890483");
        map.put("guid", "866568027820041");
        mUserApi.checkSignIn(map, this, succeedCallback);
    }
}
