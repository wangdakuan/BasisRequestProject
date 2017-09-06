package com.app.view.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

import com.common.bar.UltimateBar;
import com.common.pageloading.PageStateLayout;

/**
 * 作者：wangdakuan
 * 日期：2017/9/4 10:26
 * 邮箱：wangdakuan@kjtpay.com.cn
 * 功能：activity 基类
 */
public abstract class BaseActivity extends AppCompatActivity implements IBaseView, View.OnClickListener {
    /**
     * 当前Activity渲染的视图View
     */
    protected View contentView;
    /**
     * 上次点击时间
     */
    private long lastClick = 0;

    protected BaseActivity mActivity;
    protected UltimateBar mUltimateBar;

    protected PageStateLayout mLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        mUltimateBar = new UltimateBar(this);
        mUltimateBar.setImmersionBar();
        mActivity = this;
        /**
         * 初始化数据方法
         */
        Bundle bundle = getIntent().getExtras();
        initData(bundle);
        initPageState();
        /**
         * 初始化绑定总布局
         */
        setBaseView(bindLayout());
        /**
         * 初始化控件方法
         */
        initView(savedInstanceState, contentView);
        /**
         * 业务操作方法
         */
        doBusiness();
    }

    private void initPageState(){
        mLayout = new PageStateLayout(this);
        mLayout.setOnEmptyListener(null)
                .setOnErrorListener(null);
    }

    protected void setBaseView(@LayoutRes int layoutId) {
        setContentView(contentView = LayoutInflater.from(this).inflate(layoutId, null));
        mUltimateBar.addMarginTopEqualStatusBarHeight(contentView, this);
    }

    /**
     * 判断是否快速点击
     *
     * @return {@code true}: 是<br>{@code false}: 否
     */
    private boolean isFastClick() {
        long now = System.currentTimeMillis();
        if (now - lastClick >= 200) {
            lastClick = now;
            return false;
        }
        return true;
    }

    /**
     * 控件的点击事件初始化
     *
     * @param view
     */
    @Override
    public void onClick(final View view) {
        if (!isFastClick()) onWidgetClick(view);
    }
}
