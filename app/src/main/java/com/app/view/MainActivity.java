package com.app.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.app.view.base.BaseTitleActivity;
import com.dodata.appnet.model.UserInfoModel;
import com.dodata.appnet.user.UserPresenterImpl;
import com.dodata.net.presenter.SucceedCallback;
import com.example.admin.dataokhttp.R;

public class MainActivity extends BaseTitleActivity {

    UserPresenterImpl presenter;

    @Override
    public void initData(Bundle bundle) {
    }

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        findViewById(R.id.btn).setOnClickListener(this);
//        mToolBar.setTextTitle("测试").show();
    }

    @Override
    public void doBusiness() {
        presenter = new UserPresenterImpl(mLayout);
    }

    @Override
    public void onWidgetClick(View view) {
        presenter.checkSignIn("", new SucceedCallback<UserInfoModel>() {
            @Override
            public void onData(UserInfoModel infoModel) {
                Log.e("测试", "======UserInfoModel==" + infoModel.idNo);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}
