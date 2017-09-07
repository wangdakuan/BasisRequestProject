package com.app.view.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;

import com.common.bar.UltimateBar;
import com.common.pageloading.PageStateLayout;

/**
 * 作者：wangdakuan
 * 日期：2017/9/4 10:26
 * 邮箱：wangdakuan@kjtpay.com.cn
 * 功能：activity 基类
 */
public abstract class BaseActivity extends AppCompatActivity implements IBaseView {
    /**
     * 当前Activity渲染的视图View
     */
    protected View contentView;
    /**
     * 标题视图view
     */
    protected View titleView;
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
         * 设置标题布局
         */
        setTitleView(0);
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

    private void initPageState() {
        mLayout = new PageStateLayout(this);
        mLayout.setOnEmptyListener(null)
                .setOnErrorListener(null);
    }

    /**
     * 标题布局
     */
    protected void setTitleView(@LayoutRes int layoutId) {
        if (0 != layoutId) {
            titleView = LayoutInflater.from(this).inflate(layoutId, null);
            mUltimateBar.addMarginTopEqualStatusBarHeight(titleView, this);
        }
    }

    /**
     * 页面布局
     *
     * @param layoutId
     */
    protected void setBaseView(@LayoutRes int layoutId) {
        LinearLayout layout = new LinearLayout(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layout.setOrientation(LinearLayout.VERTICAL);
        if (0 != layoutId) {
            contentView = LayoutInflater.from(this).inflate(layoutId, null);
            mLayout.load(layout, contentView);
            mLayout.onSucceed();
        }
        if (titleView != null) {
            layout.addView(titleView, 0);
        } else {
            if(null != contentView){
                mUltimateBar.addMarginTopEqualStatusBarHeight(contentView, this);
            }
        }
        setContentView(layout, layoutParams);
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
