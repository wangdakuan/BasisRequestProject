package com.common.dialog;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

/**
 * 作者：wangdakuan
 * 日期：2017/9/5 18:14
 * 邮箱：wangdakuan@kjtpay.com.cn
 * 功能：BaseDialog基础使用封装
 */
public class DialogBuilder extends BaseDialog {
    private ViewConvertListener convertListener;

    public static DialogBuilder init() {
        return new DialogBuilder();
    }

    /**
     * dialog布局
     * @return
     */
    @Override
    public int intLayoutId() {
        return layoutId;
    }

    /**
     * 初始化布局
     * @param holder
     * @param dialog
     */
    @Override
    public void convertView(ViewHolder holder, BaseDialog dialog) {
        if (convertListener != null) { //监听布局
            convertListener.convertView(holder, dialog);
        }
    }

    /**
     * 设置dialog布局
     *
     * @param layoutId
     * @return
     */
    public DialogBuilder setLayoutId(@LayoutRes int layoutId) {
        this.layoutId = layoutId;
        return this;
    }

    /**
     * 回调布局监听
     *
     * @param convertListener 布局转换监听
     * @return
     */
    public DialogBuilder setConvertListener(ViewConvertListener convertListener) {
        this.convertListener = convertListener;
        return this;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            convertListener = (ViewConvertListener) savedInstanceState.getSerializable("listener");
        }
    }

    /**
     * 保存接口
     *
     * @param outState
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("listener", convertListener);
    }
}
