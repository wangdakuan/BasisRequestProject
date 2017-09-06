package com.dodata.net.model;

import java.io.Serializable;

/**
 * 作者：wangdakuan
 * 日期：2017/8/30 10:57
 * 邮箱：wangdakuan@kjtpay.com.cn
 * 功能：没数据返回的时候对象
 */
public class SimpleResponse implements Serializable {

    private static final long serialVersionUID = -1477609349345966116L;

    public int status;
    public String message;

    public DataResponse toLzyResponse() {
        DataResponse lzyResponse = new DataResponse();
        lzyResponse.status = status;
        lzyResponse.message = message;
        return lzyResponse;
    }
}