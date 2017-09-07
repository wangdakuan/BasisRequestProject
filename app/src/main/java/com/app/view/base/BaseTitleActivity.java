package com.app.view.base;

import android.support.annotation.LayoutRes;
import android.view.View;

import com.common.bar.ToolBarView;
import com.example.admin.dataokhttp.R;

/**
 * 作者：wangdakuan
 * 日期：2017/9/4 10:33
 * 邮箱：wangdakuan@kjtpay.com.cn
 * 功能：activity 设置头部公共类
 */
public abstract class BaseTitleActivity extends BaseActivity {

    protected ToolBarView mToolBar;

    /**
     * 设置标题
     * @param layoutId
     */
    @Override
    protected void setTitleView(@LayoutRes int layoutId) {
        super.setTitleView(0 == layoutId ? R.layout.page_base_title : layoutId);
        mToolBar = titleView.findViewById(R.id.toolbar_view);
        mToolBar.setImagBackListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
