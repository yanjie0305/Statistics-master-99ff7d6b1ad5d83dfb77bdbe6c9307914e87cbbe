package com.edaibu.statistics.http.biz;

import com.edaibu.statistics.bean.LoginResp;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.POST;

/**
 * Created by lyn on 2017/4/14.
 */

public interface ILogin {
    @POST("/sms/send")
    Call<Integer> getSms(@Field("mobile") String mobile);

    @POST("/sms/login")
    Call<LoginResp> login(@Field("smscode") String smscode, @Field("mobile") String mobile);
}
