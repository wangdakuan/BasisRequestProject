package com.app.view.base;

import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.common.bar.ToolBarView;
import com.example.admin.dataokhttp.R;

/**
 * 作者：wangdakuan
 * 日期：2017/9/4 10:33
 * 邮箱：wangdakuan@kjtpay.com.cn
 * 功能：activity 头部基类
 */
public abstract class BaseTitleActivity extends BaseActivity {

    protected ToolBarView mToolBar;
    protected FrameLayout flActivityContainer;
    protected FrameLayout viewTitle;

    @Override
    protected void setBaseView(@LayoutRes int layoutId) {
        contentView = LayoutInflater.from(this).inflate(R.layout.page_base_title, null);
        setContentView(contentView);
        viewTitle = (FrameLayout) findViewById(R.id.view_title);
        mUltimateBar.addMarginTopEqualStatusBarHeight(viewTitle, this);
        mToolBar = (ToolBarView) findViewById(R.id.toolbar_view);
        flActivityContainer = (FrameLayout) findViewById(R.id.activity_container);
        View view = LayoutInflater.from(this).inflate(layoutId, null);
        mLayout.load(flActivityContainer, view);
        mLayout.onSucceed();
    }

}
