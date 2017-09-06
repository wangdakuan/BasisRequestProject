package com.dodata.appnet.user;

import com.dodata.appnet.UserUrl;
import com.dodata.appnet.model.UserInfoModel;
import com.dodata.net.callback.JsonConvert;
import com.dodata.net.model.DataResponse;
import com.dodata.net.presenter.RequestCallback;
import com.dodata.net.presenter.SucceedCallback;
import com.dodata.net.subscribe.MObserver;
import com.dodata.net.subscribe.StartSubscribe;
import com.lzy.okgo.OkGo;
import com.lzy.okrx2.adapter.ObservableBody;

import org.json.JSONObject;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * 作者：wangdakuan
 * 日期：2017/8/30 12:05
 * 邮箱：wangdakuan@kjtpay.com.cn
 * 功能：
 */
public class UserApi implements UserInterfaces{
    @Override
    public void checkSignIn(Map map, RequestCallback callback, final SucceedCallback<UserInfoModel> succeedCallback) {
        JSONObject object = new JSONObject(map);
        OkGo.<DataResponse<UserInfoModel>>post(UserUrl.CHECK_SIGN_IN)//
                .upJson(object)
                .converter(new JsonConvert<DataResponse<UserInfoModel>>() {
                })//
                .adapt(new ObservableBody<DataResponse<UserInfoModel>>())//
                .doOnSubscribe(new StartSubscribe<RequestCallback, Disposable>(callback))//
                .observeOn(AndroidSchedulers.mainThread())//
                .subscribe(new MObserver<DataResponse<UserInfoModel>>(callback){
                    @Override
                    public void onNext(@NonNull DataResponse<UserInfoModel> objectDataResponse) {
                        super.onNext(objectDataResponse);
                        succeedCallback.onData(objectDataResponse.data);
                    }
                })

        ;
    }

}
