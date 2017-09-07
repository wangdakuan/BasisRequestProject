package com.common.dialog;

/**
 * 作者：wangdakuan
 * 日期：2017/9/5 18:11
 * 邮箱：wangdakuan@kjtpay.com.cn
 * 功能：布局转换监听
 *  extends Serializable
 */
public interface ViewConvertListener {
    long serialVersionUID = System.currentTimeMillis();

    void convertView(ViewHolder holder, BaseDialog dialog);
}

