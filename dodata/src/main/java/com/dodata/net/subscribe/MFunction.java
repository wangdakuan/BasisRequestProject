package com.dodata.net.subscribe;

import com.dodata.net.model.DataResponse;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * 作者：wangdakuan
 * 日期：2017/8/30 11:31
 * 邮箱：wangdakuan@kjtpay.com.cn
 * 功能：请求数据转换
 */
public class MFunction<T, R> implements Function<T, R> {
    @Override
    public R apply(@NonNull T t) throws Exception {
        if (t instanceof DataResponse) {
            return (R) ((DataResponse) t).data;
        }
        return null;
    }
}
