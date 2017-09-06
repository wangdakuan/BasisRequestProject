package com.app.view.base;

import android.os.Bundle;
import android.view.View;

/**
 * 作者：wangdakuan
 * 日期：2017/9/4 10:26
 * 邮箱：wangdakuan@kjtpay.com.cn
 * 功能：页面相关规定方法（统一管理）
 */
interface IBaseView extends View.OnClickListener {

    /**
     * 初始化数据
     *
     * @param bundle 传递过来的bundle
     */
    void initData(final Bundle bundle);

    /**
     * 绑定布局
     *
     * @return 布局Id
     */
    int bindLayout();

    /**
     * 初始化view
     */
    void initView(final Bundle savedInstanceState, final View view);

    /**
     * 业务操作
     */
    void doBusiness();

    /**
     * 视图点击事件
     *
     * @param view 视图
     */
    void onWidgetClick(final View view);
}
