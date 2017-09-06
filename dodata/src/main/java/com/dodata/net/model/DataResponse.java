package com.dodata.net.model;

import java.io.Serializable;

/**
 * 作者：wangdakuan
 * 日期：2017/8/30 10:54
 * 邮箱：wangdakuan@kjtpay.com.cn
 * 功能：请求数据返回的对象
 */
public class DataResponse<T> implements Serializable {

    private static final long serialVersionUID = 5213230387175987834L;

    public int status;
    public String message;
    public T data;

    @Override
    public String toString() {
        return "LzyResponse{\n" +//
                "\tcode=" + status + "\n" +//
                "\tmsg='" + message + "\'\n" +//
                "\tdata=" + data + "\n" +//
                '}';
    }
}
