package com.dodata.appnet.model;

import java.io.Serializable;

/**
 * 作者：wangdakuan
 * 日期：2017/8/2 12:26
 * 邮箱：wangdakuan@kjtpay.com.cn
 * 功能：登录后用户的信息
 */
public class UserInfoModel implements Serializable {
    public static final String TABLE_NAME = "t_user_info";
    /**
     * userId : 14
     * org : null
     * custId : 20
     * loginId : 17717349618
     * registerTime : 1501494476000
     * email :
     * mobileNo : 17717349618
     * loginPwd : 36d20f138df572e97547d3bc6a4c2145a3bb2b6305dcf93db6410a36852bf75a113e9936a5df5c18
     * loginPwdErrNum : null
     * loginNum : null
     * loginPwdModTime : null
     * userStatus : null
     * userStasModTime : null
     * emailActivateFalg : N
     * realnameAuthFlag : N
     * lastLoginIp : null
     * lastLoginTime : null
     * idNo :
     * idType :
     * registedPlace : null
     * name :
     * gender : null
     * applySource : null
     * token : eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOjE0LCJpYXQiOjE1MDE2NDgzMjY3NjAsImV4dCI6MTUwMTczNDcyNjc2MH0.8d-Kgog4dH6U4zRFfBWxfLr_WEI6vim81RpBNr7KPhs
     * identityFlag : null
     * workmsgFlag : null
     * othFlag : null
     * basemsgFlag : null
     * transPwd : Y
     * idcardImageflag :
     * gestureFlag : Y
     * otherFlag : null
     * uuid : null
     * guid : 866568027820041
     */
    private Long id;
    public String userId;
    public String org;
    public int custId;
    public String loginId;
    public long registerTime;
    public String email;
    public String mobileNo;
    public String loginPwd;
    public String loginPwdErrNum;
    public String loginNum;
    public String loginPwdModTime;
    public String userStatus;
    public String userStasModTime;
    public String emailActivateFalg;
    public String realnameAuthFlag;//是否实名标识  Y已添加   N没有
    public String lastLoginIp;
    public String lastLoginTime;
    public String idNo;
    public String idType;
    public String registedPlace;
    public String name;
    public String gender;
    public String applySource;
    public String token;
    public String identityFlag;
    public String workmsgFlag;
    public String othFlag;//是否添加联系人标识  Y已添加   N没有
    public String basemsgFlag;
    public String transPwd;
    public String idcardImageflag;
    public String gestureFlag;
    public String otherFlag;//是否添加基本信息标识  Y已添加   N没有
    public String uuid;
    public String guid;
    public String bankCardNo; //银行卡卡号

}
