package com.edaibu.statistics;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.edaibu.statistics.bean.LoginResp;
import com.edaibu.statistics.http.Http;
import com.edaibu.statistics.http.biz.ILogin;
import com.edaibu.statistics.utils.SPUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * 登陆
 * Created by lyn
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private EditText et_login_phone;
    private EditText et_login_code;
    private Button tv_login_send_code;
    private Button bt_login_submit;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    /***/
    private void initView() {
        et_login_phone = (EditText) findViewById(R.id.et_login_phone);
        et_login_code = (EditText) findViewById(R.id.et_login_code);
        tv_login_send_code = (Button) findViewById(R.id.tv_login_send_code);
        bt_login_submit = (Button) findViewById(R.id.bt_login_submit);
        tv_login_send_code.setOnClickListener(this);
        bt_login_submit.setOnClickListener(this);
    }


    /**
     * 登录成功
     **/
    private void loginSuccess(LoginResp loginResp) {
        SPUtils.put(SPUtils.SP_KEY_ACCESS_TOKEN, loginResp.getData().getAccess_token());
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra(EXTRA_DATA, loginResp);
        startActivity(i);
    }


    /**
     * 登录
     **/
    private void login(String mobile, String smsCode) {
        showProgress();
        Http.getRetrofit().create(ILogin.class).login(mobile, smsCode).enqueue(new Callback<LoginResp>() {
            @Override
            public void onResponse(Call<LoginResp> call, Response<LoginResp> response) {
                dismissProgress();
                LoginResp loginResp = response.body();
                if (loginResp.getCode() == 200) {
                    loginSuccess(loginResp);
                }
            }

            @Override
            public void onFailure(Call<LoginResp> call, Throwable t) {
                dismissProgress();

            }
        });
    }


    /**
     * 发送验证码
     **/
    private void sendSms(String mobile) {
        showProgress();
        Http.getRetrofit().create(ILogin.class).getSms(mobile).enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                dismissProgress();

                if (response.body() == 200) {
                    cdTimer.start();
                }
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {
                dismissProgress();

            }
        });

    }


    /**
     * 倒计时
     **/
    CountDownTimer cdTimer = new CountDownTimer(60 * 1000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            tv_login_send_code.setText(millisUntilFinished / 1000 + "");
        }

        @Override
        public void onFinish() {
            tv_login_send_code.setText(getString(R.string.get_code));
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_login_send_code:
                if (getString(R.string.get_code).equals(tv_login_send_code.getText().toString())) {
                    String mobile = et_login_phone.getText().toString();
                    sendSms(mobile);
                }
                break;
            case R.id.bt_login_submit:
                String mobile = et_login_phone.getText().toString();
                String smsCode = et_login_code.getText().toString();
                login(mobile, smsCode);
                break;
        }
    }
}

