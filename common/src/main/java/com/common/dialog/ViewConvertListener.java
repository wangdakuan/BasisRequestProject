package com.common.dialog;

import java.io.Serializable;

/**
 * 作者：wangdakuan
 * 日期：2017/9/5 18:11
 * 邮箱：wangdakuan@kjtpay.com.cn
 * 功能：布局转换监听
 */
public interface ViewConvertListener extends Serializable {
    long serialVersionUID = System.currentTimeMillis();

    void convertView(ViewHolder holder, BaseDialog dialog);
}

