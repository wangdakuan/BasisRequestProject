package com.app.view;

import android.os.Bundle;
import android.view.View;

import com.app.view.base.BaseTitleActivity;
import com.common.utils.ActivityUtils;
import com.common.utils.LogUtils;
import com.dodata.appnet.model.UserInfoModel;
import com.dodata.appnet.user.UserPresenterImpl;
import com.dodata.net.presenter.SucceedCallback;
import com.example.admin.dataokhttp.R;

/**
 * 入口测试
 */
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
        findViewById(R.id.request).setOnClickListener(this);
        findViewById(R.id.jump).setOnClickListener(this);
        mToolBar.setTextTitle("测试首页").setIsShowLeft(false).show();
    }

    @Override
    public void doBusiness() {
        presenter = new UserPresenterImpl(mLayout);
    }

    @Override
    public void onWidgetClick(View view) {
        switch (view.getId()) {
            case R.id.request:
                presenter.checkSignIn("", new SucceedCallback<UserInfoModel>() {
                    @Override
                    public void onData(UserInfoModel infoModel) {
                        LogUtils.e("======UserInfoModel==" + infoModel.idNo);
                    }
                });
                break;
            case R.id.jump:
                ActivityUtils.navigateTo(TestDialogActivity.class);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}
