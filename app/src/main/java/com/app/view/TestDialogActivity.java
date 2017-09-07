package com.app.view;

import android.os.Bundle;
import android.view.View;

import com.app.view.base.BaseTitleActivity;
import com.common.dialog.BaseDialog;
import com.common.dialog.DialogBuilder;
import com.common.dialog.ViewConvertListener;
import com.common.dialog.ViewHolder;
import com.dodata.appnet.user.UserPresenterImpl;
import com.example.admin.dataokhttp.R;

/**
 * 作者：wangdakuan
 * 日期：2017/9/7 09:28
 * 邮箱：wangdakuan@kjtpay.com.cn
 * 功能：Dialog 测试类
 */
public class TestDialogActivity extends BaseTitleActivity {

    UserPresenterImpl presenter;

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.page_test_dialog;
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        mToolBar.setTextTitle("Dialog 测试实例").show();
        findViewById(R.id.dialog1).setOnClickListener(this);
        findViewById(R.id.dialog2).setOnClickListener(this);
    }

    @Override
    public void doBusiness() {
    }

    @Override
    public void onWidgetClick(View view) {
        switch (view.getId()) {
            case R.id.dialog1:
                DialogBuilder.init()
                        .setLayoutId(R.layout.test_dialog_layout1)
                        .setConvertListener(new ViewConvertListener() {
                            @Override
                            public void convertView(ViewHolder holder, final BaseDialog dialog) {
                                holder.setOnClickListener(R.id.close, new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        dialog.dismiss();
                                    }
                                });
                            }
                        })
                        .setWidth(210)
                        .setOutCancel(false)
                        .setAnimStyle(R.style.EnterExitAnimation)
                        .show(getSupportFragmentManager());

                break;
            case R.id.dialog2:
                DialogBuilder.init()
                        .setLayoutId(R.layout.test_dialog_layout2)
                        .setShowBottom(true)
                        .setAnimStyle(R.style.EnterExitAnimation)
                        .show(getSupportFragmentManager());

                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
